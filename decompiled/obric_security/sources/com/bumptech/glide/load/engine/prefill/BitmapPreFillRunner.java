package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class BitmapPreFillRunner implements Runnable {
    static final int BACKOFF_RATIO = 4;
    private static final Clock DEFAULT_CLOCK = null;
    static final long INITIAL_BACKOFF_MS = 40;
    static final long MAX_BACKOFF_MS = 0;
    static final long MAX_DURATION_MS = 32;
    static final String TAG = "PreFillRunner";
    private final BitmapPool bitmapPool;
    private final Clock clock;
    private long currentDelay;
    private final Handler handler;
    private boolean isCancelled;
    private final MemoryCache memoryCache;
    private final Set<PreFillType> seenTypes;
    private final PreFillQueue toPrefill;

    static class Clock {
        Clock() {
        }

        long now() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    private static final class UniqueKey implements Key {
        UniqueKey() {
        }

        @Override // com.bumptech.glide.load.Key
        public void updateDiskCacheKey(MessageDigest r1) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        DEFAULT_CLOCK = new Clock();
        MAX_BACKOFF_MS = TimeUnit.SECONDS.toMillis(1);
    }

    public BitmapPreFillRunner(BitmapPool r7, MemoryCache r8, PreFillQueue r9) {
        this(r7, r8, r9, DEFAULT_CLOCK, new Handler(Looper.getMainLooper()));
    }

    BitmapPreFillRunner(BitmapPool r3, MemoryCache r4, PreFillQueue r5, Clock r6, Handler r7) {
        this.seenTypes = new HashSet();
        this.currentDelay = INITIAL_BACKOFF_MS;
        this.bitmapPool = r3;
        this.memoryCache = r4;
        this.toPrefill = r5;
        this.clock = r6;
        this.handler = r7;
    }

    public void cancel() {
        this.isCancelled = true;
    }

    boolean allocate() {
        long r0 = this.clock.now();
    L4:
        if (this.toPrefill.isEmpty() == true) goto L19;
        if (isGcDetected(r0) == true) goto L19;
        PreFillType r2 = this.toPrefill.remove();
        if (this.seenTypes.contains(r2) == true) goto L10;
        this.seenTypes.add(r2);
        Bitmap r3 = this.bitmapPool.getDirty(r2.getWidth(), r2.getHeight(), r2.getConfig());
    L11:
        int r4 = Util.getBitmapByteSize(r3);
        if (getFreeMemoryCacheBytes() < r4) goto L14;
        this.memoryCache.put(new UniqueKey(), BitmapResource.obtain(r3, this.bitmapPool));
    L16:
        if (Log.isLoggable(TAG, 3) == false) goto L4;
        Log.d(TAG, "allocated [" + r2.getWidth() + MaterialConfigFormatNames.X + r2.getHeight() + "] " + r2.getConfig() + " size: " + r4);
        goto L4
    L14:
        this.bitmapPool.put(r3);
        goto L16
    L10:
        r3 = Bitmap.createBitmap(r2.getWidth(), r2.getHeight(), r2.getConfig());
    L19:
        if (this.isCancelled == false) goto L21;
    L23:
        return false;
    L21:
        if (this.toPrefill.isEmpty() == true) goto L23;
        return true;
    }

    private boolean isGcDetected(long r3) {
        if ((this.clock.now() - r3) < 32) goto L5;
        return true;
    L5:
        return false;
    }

    private long getFreeMemoryCacheBytes() {
        return this.memoryCache.getMaxSize() - this.memoryCache.getCurrentSize();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (allocate() == false) goto L6;
        this.handler.postDelayed(this, getNextDelay());
        return;
    }

    private long getNextDelay() {
        long r0 = this.currentDelay;
        this.currentDelay = Math.min(4 * r0, MAX_BACKOFF_MS);
        return r0;
    }
}
