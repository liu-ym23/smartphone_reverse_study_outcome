package com.android.settingslib.applications;

import android.graphics.drawable.Drawable;
import android.os.UserHandle;
import android.util.LruCache;
import com.GlobalProxyLancet;

/* JADX INFO: loaded from: classes.dex */
public class AppIconCacheManager {
    private static final float CACHE_RATIO = 0.1f;
    private static final String DELIMITER = ":";
    static final int MAX_CACHE_SIZE_IN_KB = 0;
    private static final String TAG = "AppIconCacheManager";
    private static AppIconCacheManager sAppIconCacheManager;
    private final LruCache<String, Drawable> mDrawableCache;

    static {
        MAX_CACHE_SIZE_IN_KB = getMaxCacheInKb();
    }

    private AppIconCacheManager() {
        final int r1 = MAX_CACHE_SIZE_IN_KB;
        this.mDrawableCache = new AnonymousClass1(this, r1);
    }

    public static synchronized AppIconCacheManager getInstance() {
        monitor-enter(AppIconCacheManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sAppIconCacheManager != null) goto L7;
        sAppIconCacheManager = new AppIconCacheManager();     // Catch: Throwable -> L10
    L7:
        AppIconCacheManager r1 = sAppIconCacheManager;     // Catch: Throwable -> L10
        monitor-exit(AppIconCacheManager.class);
        return r1;
    }

    public void put(String r1, int r2, Drawable r3) {
        String r4 = getKey(r1, r2);
        if (r4 == null) goto L12;
        if (r3 == null) goto L12;
        if (r3.getIntrinsicHeight() < 0) goto L12;
        if (r3.getIntrinsicWidth() < 0) goto L12;
        this.mDrawableCache.put(r4, r3);
        return;
    L12:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Invalid key or drawable.");
    }

    public Drawable get(String r1, int r2) {
        String r3 = getKey(r1, r2);
        if (r3 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Invalid key with package or uid.");
        return null;
    L6:
        Drawable r0 = this.mDrawableCache.get(r3);
        if (r0 != null) goto L9;
        return null;
    L9:
        return r0.mutate();
    }

    public static void release() {
        AppIconCacheManager r0 = sAppIconCacheManager;
        if (r0 == null) goto L6;
        r0.mDrawableCache.evictAll();
        return;
    }

    private static String getKey(String r1, int r2) {
        if (r1 == null) goto L7;
        if (r2 >= 0) goto L6;
        return null;
    L6:
        return r1 + ":" + UserHandle.getUserId(r2);
    L7:
        return null;
    }

    private static int getMaxCacheInKb() {
        return Math.round((Runtime.getRuntime().maxMemory() * 0.1f) / 1024.0f);
    }

    public void trimMemory(int r1) {
        if (r1 < 40) goto L8;
        AppIconCacheManager r0 = sAppIconCacheManager;
        if (r0 == null) goto L15;
        r0.mDrawableCache.trimToSize(0);
        return;
    L15:
        return;
    L8:
        if (r1 < 20) goto L10;
    L11:
        AppIconCacheManager r2 = sAppIconCacheManager;
        if (r2 == null) goto L18;
        int r3 = r2.mDrawableCache.maxSize();
        sAppIconCacheManager.mDrawableCache.trimToSize(r3 / 2);
        return;
    L18:
        return;
    L10:
        if (r1 == 15) goto L11;
    }
}
