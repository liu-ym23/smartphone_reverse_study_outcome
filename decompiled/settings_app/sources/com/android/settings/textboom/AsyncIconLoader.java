package com.android.settings.textboom;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class AsyncIconLoader {
    private static final int IMAGE_CACHE_SIZE = 5242880;
    private static final int INTRINSIC_WIDTH = 96;
    private static final int MAX_THREAD_NUM = 2;
    private static final String TAG = "AsyncIconLoader";
    private static volatile AsyncIconLoader sInstance;
    private Context mContext;
    private ExecutorService mExecutorService;
    LruCache<String, Bitmap> mImageCache;

    public interface ImageCallback {
        void imageLoaded(Bitmap r1, String r2);

        boolean isCancel(String r1);
    }

    static /* synthetic */ AsyncIconLoader access$000() {
        return sInstance;
    }

    static /* synthetic */ Context access$100(AsyncIconLoader r0) {
        return r0.mContext;
    }

    static /* synthetic */ void access$200(AsyncIconLoader r0, String r1, Bitmap r2) {
        r0.putValue(r1, r2);
    }

    private AsyncIconLoader(Context r3) {
        final int r1 = IMAGE_CACHE_SIZE;
        this.mImageCache = new AnonymousClass1(this, r1);
        this.mContext = r3;
        this.mExecutorService = Executors.newFixedThreadPool(2);
    }

    public static AsyncIconLoader getInstance(Context r2) {
        if (sInstance != null) goto L16;
        monitor-enter(AsyncIconLoader.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new AsyncIconLoader(r2);     // Catch: Throwable -> L12
    L9:
        AsyncIconLoader r3 = sInstance;     // Catch: Throwable -> L12
        monitor-exit(AsyncIconLoader.class);     // Catch: Throwable -> L12
        return r3;
    L16:
        return sInstance;
    }

    private void putValue(String r2, Bitmap r3) {
        LruCache<String, Bitmap> r0 = this.mImageCache;
        monitor-enter(r0);
        this.mImageCache.put(r2, r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private Bitmap getValue(String r2) {
        LruCache<String, Bitmap> r0 = this.mImageCache;
        monitor-enter(r0);
        Bitmap r1 = this.mImageCache.get(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void loadBitmap(final ApplicationInfo r3, final ImageCallback r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r3.sourceDir) == true) goto L14;
        Bitmap r0 = getValue(r3.sourceDir);
        if (r0 != null) goto L9;
    L11:
        this.mExecutorService.submit(new AnonymousClass2(this, r4, r3));
        return;
    L9:
        if (r0.isRecycled() == true) goto L11;
        r4.imageLoaded(r0, r3.sourceDir);
        goto L11
    }
}
