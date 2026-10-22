package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.util.Log;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class LruBitmapPool implements BitmapPool {
    private static final Bitmap.Config DEFAULT_CONFIG = null;
    private static final String TAG = "LruBitmapPool";
    private final Set<Bitmap.Config> allowedConfigs;
    private long currentSize;
    private int evictions;
    private int hits;
    private final long initialMaxSize;
    private long maxSize;
    private int misses;
    private int puts;
    private final LruPoolStrategy strategy;
    private final BitmapTracker tracker;

    private interface BitmapTracker {
        void add(Bitmap r1);

        void remove(Bitmap r1);
    }

    private static final class NullBitmapTracker implements BitmapTracker {
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void add(Bitmap r1) {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void remove(Bitmap r1) {
        }

        NullBitmapTracker() {
        }
    }

    private static class ThrowingBitmapTracker implements BitmapTracker {
        private final Set<Bitmap> bitmaps;

        private ThrowingBitmapTracker() {
            this.bitmaps = Collections.synchronizedSet(new HashSet());
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void add(Bitmap r3) {
            if (this.bitmaps.contains(r3) == true) goto L7;
            this.bitmaps.add(r3);
            return;
        L7:
            throw new IllegalStateException("Can't add already added bitmap: " + r3 + " [" + r3.getWidth() + MaterialConfigFormatNames.X + r3.getHeight() + "]");
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void remove(Bitmap r2) {
            if (this.bitmaps.contains(r2) == false) goto L7;
            this.bitmaps.remove(r2);
            return;
        L7:
            throw new IllegalStateException("Cannot remove bitmap not in tracker");
        }
    }

    static {
        DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
    }

    LruBitmapPool(long r1, LruPoolStrategy r3, Set<Bitmap.Config> r4) {
        this.initialMaxSize = r1;
        this.maxSize = r1;
        this.strategy = r3;
        this.allowedConfigs = r4;
        this.tracker = new NullBitmapTracker();
    }

    public LruBitmapPool(long r3) {
        this(r3, getDefaultStrategy(), getDefaultAllowedConfigs());
    }

    public LruBitmapPool(long r2, Set<Bitmap.Config> r4) {
        this(r2, getDefaultStrategy(), r4);
    }

    public long hitCount() {
        return this.hits;
    }

    public long missCount() {
        return this.misses;
    }

    public long evictionCount() {
        return this.evictions;
    }

    public long getCurrentSize() {
        return this.currentSize;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public long getMaxSize() {
        return this.maxSize;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void setSizeMultiplier(float r3) {
        monitor-enter(this);
        this.maxSize = Math.round(this.initialMaxSize * r3);     // Catch: Throwable -> L6
        evict();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void put(Bitmap r9) {
        monitor-enter(this);
        if (r9 == null) goto L31;
        if (r9.isRecycled() == true) goto L27;
        if (r9.isMutable() == false) goto L21;
        if (this.strategy.getSize(r9) > this.maxSize) goto L21;
        if (this.allowedConfigs.contains(r9.getConfig()) == false) goto L21;
        int r1 = this.strategy.getSize(r9);     // Catch: Throwable -> L28
        this.strategy.put(r9);     // Catch: Throwable -> L28
        this.tracker.add(r9);     // Catch: Throwable -> L28
        this.puts++;     // Catch: Throwable -> L28
        this.currentSize += (long) r1;     // Catch: Throwable -> L28
        if (Log.isLoggable(TAG, 2) == false) goto L17;
        Log.v(TAG, "Put bitmap in pool=" + this.strategy.logBitmap(r9));     // Catch: Throwable -> L28
    L17:
        dump();     // Catch: Throwable -> L28
        evict();     // Catch: Throwable -> L28
        monitor-exit(this);
        return;
    L21:
        if (Log.isLoggable(TAG, 2) == false) goto L23;
        Log.v(TAG, "Reject bitmap from pool, bitmap: " + this.strategy.logBitmap(r9) + ", is mutable: " + r9.isMutable() + ", is allowed config: " + this.allowedConfigs.contains(r9.getConfig()));     // Catch: Throwable -> L28
    L23:
        r9.recycle();     // Catch: Throwable -> L28
        monitor-exit(this);
        return;
    L27:
        throw new IllegalStateException("Cannot pool recycled bitmap");     // Catch: Throwable -> L28
    L31:
        throw new NullPointerException("Bitmap must not be null");     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public Bitmap get(int r1, int r2, Bitmap.Config r3) {
        Bitmap r0 = getDirtyOrNull(r1, r2, r3);
        if (r0 == null) goto L6;
        r0.eraseColor(0);
        return r0;
    L6:
        return createBitmap(r1, r2, r3);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public Bitmap getDirty(int r1, int r2, Bitmap.Config r3) {
        Bitmap r0 = getDirtyOrNull(r1, r2, r3);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return createBitmap(r1, r2, r3);
    }

    private static Bitmap createBitmap(int r0, int r1, Bitmap.Config r2) {
        if (r2 != null) goto L6;
        r2 = DEFAULT_CONFIG;
    L6:
        return Bitmap.createBitmap(r0, r1, r2);
    }

    private static void assertNotHardwareConfig(Bitmap.Config r3) {
        if (r3 == Bitmap.Config.HARDWARE) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + r3 + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
    }

    private synchronized Bitmap getDirtyOrNull(int r8, int r9, Bitmap.Config r10) {
        monitor-enter(this);
        assertNotHardwareConfig(r10);     // Catch: Throwable -> L21
        LruPoolStrategy r2 = this.strategy;     // Catch: Throwable -> L21
        if (r10 == null) goto L7;
        Bitmap.Config r3 = r10;
    L8:
        Bitmap r4 = r2.get(r8, r9, r3);     // Catch: Throwable -> L21
        if (r4 == null) goto L11;
        this.hits++;     // Catch: Throwable -> L21
        this.currentSize -= (long) this.strategy.getSize(r4);     // Catch: Throwable -> L21
        this.tracker.remove(r4);     // Catch: Throwable -> L21
        normalize(r4);     // Catch: Throwable -> L21
    L16:
        if (Log.isLoggable(TAG, 2) == false) goto L18;
        Log.v(TAG, "Get bitmap=" + this.strategy.logBitmap(r8, r9, r10));     // Catch: Throwable -> L21
    L18:
        dump();     // Catch: Throwable -> L21
        monitor-exit(this);
        return r4;
    L11:
        if (Log.isLoggable(TAG, 3) == false) goto L13;
        Log.d(TAG, "Missing bitmap=" + this.strategy.logBitmap(r8, r9, r10));     // Catch: Throwable -> L21
    L13:
        this.misses++;     // Catch: Throwable -> L21
        goto L16
    L7:
        r3 = DEFAULT_CONFIG;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    private static void normalize(Bitmap r1) {
        r1.setHasAlpha(true);
        maybeSetPreMultiplied(r1);
    }

    private static void maybeSetPreMultiplied(Bitmap r1) {
        r1.setPremultiplied(true);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void clearMemory() {
        if (Log.isLoggable(TAG, 3) == false) goto L5;
        Log.d(TAG, "clearMemory");
    L5:
        trimToSize(0);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void trimMemory(int r5) {
        if (Log.isLoggable(TAG, 3) == false) goto L6;
        Log.d(TAG, "trimMemory, level=" + r5);
    L6:
        if (r5 < 40) goto L8;
    L14:
        clearMemory();
        return;
    L8:
        if (r5 >= 20) goto L14;
        if (r5 < 20) goto L12;
    L13:
        trimToSize(getMaxSize() / 2);
        return;
    L12:
        if (r5 == 15) goto L13;
    }

    private synchronized void trimToSize(long r6) {
        monitor-enter(this);
    L23:
    L20:
        th = move-exception;
        throw th;
    L4:
        if (this.currentSize <= r6) goto L18;
        Bitmap r0 = this.strategy.removeLast();     // Catch: Throwable -> L20
        if (r0 == null) goto L8;
        this.tracker.remove(r0);     // Catch: Throwable -> L20
        this.currentSize -= (long) this.strategy.getSize(r0);     // Catch: Throwable -> L20
        this.evictions++;     // Catch: Throwable -> L20
        if (Log.isLoggable(TAG, 3) == false) goto L16;
        Log.d(TAG, "Evicting bitmap=" + this.strategy.logBitmap(r0));     // Catch: Throwable -> L20
    L16:
        dump();     // Catch: Throwable -> L20
        r0.recycle();     // Catch: Throwable -> L20
        goto L23
    L8:
        if (Log.isLoggable(TAG, 5) == false) goto L10;
        Log.w(TAG, "Size mismatch, resetting");     // Catch: Throwable -> L20
        dumpUnchecked();     // Catch: Throwable -> L20
    L10:
        this.currentSize = 0;     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L18:
        monitor-exit(this);
    }

    private void dump() {
        if (Log.isLoggable(TAG, 2) == false) goto L6;
        dumpUnchecked();
        return;
    }

    private void dumpUnchecked() {
        Log.v(TAG, "Hits=" + this.hits + ", misses=" + this.misses + ", puts=" + this.puts + ", evictions=" + this.evictions + ", currentSize=" + this.currentSize + ", maxSize=" + this.maxSize + "\nStrategy=" + this.strategy);
    }

    private static LruPoolStrategy getDefaultStrategy() {
        return new SizeConfigStrategy();
    }

    private static Set<Bitmap.Config> getDefaultAllowedConfigs() {
        HashSet r0 = new HashSet(Arrays.asList(Bitmap.Config.values()));
        r0.add(null);
        r0.remove(Bitmap.Config.HARDWARE);
        return Collections.unmodifiableSet(r0);
    }
}
