package com.android.launcher3.icons;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.SparseLongArray;
import com.GlobalProxyLancet;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.android.settingslib.R;

/* JADX INFO: loaded from: classes.dex */
public class SimpleIconCache extends BaseIconCache {
    private static final Object CACHE_LOCK = null;
    private static SimpleIconCache sIconCache;
    private final UserManager mUserManager;
    private final SparseLongArray mUserSerialMap;

    static /* synthetic */ void access$000(SimpleIconCache r0) {
        r0.resetUserCache();
    }

    static {
        CACHE_LOCK = new Object();
    }

    public SimpleIconCache(Context r7, String r8, Looper r9, int r10, int r11, boolean r12) {
        super(r7, r8, r9, r10, r11, r12);
        this.mUserSerialMap = new SparseLongArray(2);
        this.mUserManager = (UserManager) r7.getSystemService(UserManager.class);
        IntentFilter r2 = new IntentFilter("android.intent.action.MANAGED_PROFILE_ADDED");
        r2.addAction("android.intent.action.MANAGED_PROFILE_REMOVED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r7, new AnonymousClass1(this), r2, null, new Handler(r9), 0);
    }

    @Override // com.android.launcher3.icons.cache.BaseIconCache
    protected long getSerialNumberForUser(UserHandle r4) {
        SparseLongArray r0 = this.mUserSerialMap;
        monitor-enter(r0);
        int r1 = this.mUserSerialMap.indexOfKey(r4.getIdentifier());     // Catch: Throwable -> L12
        if (r1 < 0) goto L9;
        long r3 = this.mUserSerialMap.valueAt(r1);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r3;
    L9:
        long r2 = this.mUserManager.getSerialNumberForUser(r4);     // Catch: Throwable -> L12
        this.mUserSerialMap.put(r4.getIdentifier(), r2);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L12:
        th = move-exception;
        throw th;
    }

    private void resetUserCache() {
        SparseLongArray r0 = this.mUserSerialMap;
        monitor-enter(r0);
        this.mUserSerialMap.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.launcher3.icons.cache.BaseIconCache
    protected boolean isInstantApp(ApplicationInfo r1) {
        return r1.isInstantApp();
    }

    @Override // com.android.launcher3.icons.cache.BaseIconCache
    public BaseIconFactory getIconFactory() {
        return IconFactory.obtain(this.mContext);
    }

    public static SimpleIconCache getIconCache(Context r10) {
        Object r0 = CACHE_LOCK;
        monitor-enter(r0);
        SimpleIconCache r1 = sIconCache;     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L8:
        boolean r9 = r10.getResources().getBoolean(R.bool.simple_cache_enable_im_memory);     // Catch: Throwable -> L11
        String r5 = r10.getString(R.string.cache_db_name);     // Catch: Throwable -> L11
        HandlerThread r2 = new HandlerThread("simple-icon-cache");     // Catch: Throwable -> L11
        r2.start();     // Catch: Throwable -> L11
        SimpleIconCache r3 = new SimpleIconCache(r10.getApplicationContext(), r5, r2.getLooper(), r10.getResources().getConfiguration().densityDpi, r10.getResources().getDimensionPixelSize(R.dimen.default_icon_bitmap_size), r9);     // Catch: Throwable -> L11
        sIconCache = r3;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r3;
    L11:
        th = move-exception;
        throw th;
    }
}
