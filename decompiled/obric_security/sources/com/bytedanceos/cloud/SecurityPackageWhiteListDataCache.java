package com.bytedanceos.cloud;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SecurityPackageWhiteListDataCache {
    private static volatile SecurityPackageWhiteListDataCache sInstance;
    private SecurityPackageWhiteListData mCacheData;

    private SecurityPackageWhiteListDataCache() {
    }

    public static SecurityPackageWhiteListDataCache getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(SecurityPackageWhiteListDataCache.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SecurityPackageWhiteListDataCache();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SecurityPackageWhiteListDataCache.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public synchronized void setCacheData(SecurityPackageWhiteListData data) {
        monitor-enter(this);
        this.mCacheData = data;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized List<String> getMemoryPackages() {
        monitor-enter(this);
        SecurityPackageWhiteListData r0 = this.mCacheData;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        List<String> r1 = r0.getMemoryPackages();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L11:
        th = move-exception;
        throw th;
    }
}
