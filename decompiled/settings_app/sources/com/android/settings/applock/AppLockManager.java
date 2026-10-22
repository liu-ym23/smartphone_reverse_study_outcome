package com.android.settings.applock;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.UserHandle;
import com.android.settings.AppLockUtil;
import com.bytedanceos.securitycenter.IAppLockService;
import com.obric.olog.OLog;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppLockManager {
    private static final long REBIND_DELAY_MS = 1000;
    private static final String TAG = "AppLockManager";
    private static volatile AppLockManager sInstance;
    private final ServiceConnection mConn;
    private final Context mContext;
    private final IBinder.DeathRecipient mDeath;
    private Handler mHandler;
    private final Runnable mRebindTask;
    private IAppLockService mService;

    /* JADX INFO: renamed from: $r8$lambda$k-CGuGAfdC42c016weddVgQ79eA, reason: not valid java name */
    public static /* synthetic */ void m317$r8$lambda$kCGuGAfdC42c016weddVgQ79eA(AppLockManager r0) {
        r0.bind();
    }

    static {
    }

    static /* synthetic */ IBinder.DeathRecipient access$000(AppLockManager r0) {
        return r0.mDeath;
    }

    static /* synthetic */ IAppLockService access$102(AppLockManager r0, IAppLockService r1) {
        r0.mService = r1;
        return r1;
    }

    /* JADX INFO: renamed from: lambda$new$0$com-android-settings-applock-AppLockManager, reason: not valid java name */
    /* synthetic */ void m318lambda$new$0$comandroidsettingsapplockAppLockManager() {
        OLog.i(TAG, "Service died. Rebind after 1000");
        this.mHandler.removeCallbacks(this.mRebindTask);
        this.mHandler.postDelayed(this.mRebindTask, 1000);
    }

    public static AppLockManager getInstance(Context r2) {
        if (sInstance != null) goto L15;
        monitor-enter(AppLockManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new AppLockManager(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(AppLockManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private AppLockManager(Context r2) {
        this.mConn = new AnonymousClass1(this);
        this.mRebindTask = new AppLockManager$$ExternalSyntheticLambda0(this);
        this.mDeath = new AppLockManager$$ExternalSyntheticLambda1(this);
        this.mContext = r2;
        this.mHandler = new Handler(Looper.getMainLooper());
        bind();
    }

    private void bind() {
        Intent r0 = new Intent();
        r0.setAction(AppLockUtil.ACTION_APP_LOCK_SETTING);
        r0.setPackage(AppLockUtil.PACKAGE_NAME);
        this.mContext.bindServiceAsUser(r0, this.mConn, 1, UserHandle.SYSTEM);
    }

    public void unbind() {
        if (isBind() == false) goto L6;
        this.mContext.unbindService(this.mConn);
        this.mService.asBinder().unlinkToDeath(this.mDeath, 0);
        this.mService = null;
        return;
    }

    public boolean isBind() {
        if (this.mService == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void lockApp(String r2) {
        if (isBind() == true) goto L10;
        return;
    L10:
        this.mService.lockApp(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public void unlockApp(String r2) {
        if (isBind() == true) goto L10;
        return;
    L10:
        this.mService.unlockApp(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public boolean isAppLocked(String r3) {
        if (isBind() == true) goto L10;
        return false;
    L10:
        return this.mService.isAppLocked(r3);
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public List<String> getLockedAppList() {
        if (isBind() == true) goto L10;
        return null;
    L10:
        return this.mService.getLockedAppList();
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public List<String> getIgnoredAppList() {
        if (isBind() == true) goto L10;
        return null;
    L10:
        return this.mService.getIgnoredAppList();
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
