package com.android.settings;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.UserHandle;
import com.bytedanceos.securitycenter.IPrivacySecurityService;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class PrivacySecurity {
    private static final long REBIND_DELAY_MS = 1000;
    private static final String TAG = "PrivacySecurity";
    private static volatile PrivacySecurity sInstance;
    private final ServiceConnection mConn;
    private final Context mContext;
    private final IBinder.DeathRecipient mDeath;
    private Handler mHandler;
    private final Runnable mRebindTask;
    private IPrivacySecurityService mService;

    static {
    }

    static /* synthetic */ IBinder.DeathRecipient access$000(PrivacySecurity r0) {
        return r0.mDeath;
    }

    static /* synthetic */ IPrivacySecurityService access$102(PrivacySecurity r0, IPrivacySecurityService r1) {
        r0.mService = r1;
        return r1;
    }

    /* JADX INFO: renamed from: lambda$new$0$com-android-settings-PrivacySecurity, reason: not valid java name */
    /* synthetic */ void m192lambda$new$0$comandroidsettingsPrivacySecurity() {
        OLog.i(TAG, "Service died. Rebind after 1000");
        this.mHandler.removeCallbacks(this.mRebindTask);
        this.mHandler.postDelayed(this.mRebindTask, 1000);
    }

    public static PrivacySecurity getInstance(Context r2) {
        if (sInstance != null) goto L15;
        monitor-enter(PrivacySecurity.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new PrivacySecurity(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(PrivacySecurity.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private PrivacySecurity(Context r2) {
        this.mConn = new AnonymousClass1(this);
        this.mRebindTask = new PrivacySecurity$$ExternalSyntheticLambda0(this);
        this.mDeath = new PrivacySecurity$$ExternalSyntheticLambda1(this);
        this.mContext = r2;
        this.mHandler = new Handler(Looper.getMainLooper());
        bind();
    }

    public void bind() {
        OLog.d(TAG, "bind");
        Intent r0 = new Intent();
        r0.setAction(AppLockUtil.ACTION_PRIVACY_SECURITY);
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

    public boolean isSecurityOn() {
        if (isBind() == true) goto L10;
        return false;
    L10:
        return this.mService.isSecurityOn();
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public void setPassword(String r2) {
        if (isBind() == true) goto L10;
        return;
    L10:
        this.mService.setPassword(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public void disableSecurity() {
        if (isBind() == true) goto L10;
        return;
    L10:
        this.mService.disableSecurity();     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public boolean checkPassword(String r3) {
        if (isBind() == true) goto L10;
        return false;
    L10:
        return this.mService.checkPassword(r3);
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public void setFingerprintUnlock(boolean r2) {
        if (isBind() == true) goto L10;
        return;
    L10:
        this.mService.setFingerprintUnlock(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public void setFaceIdUnlock(boolean r2) {
        if (isBind() == true) goto L10;
        return;
    L10:
        this.mService.setFaceIdUnlock(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public boolean isFingerprintUnlockOn() {
        if (isBind() == true) goto L10;
        return false;
    L10:
        return this.mService.isFingerprintUnlockOn();
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public boolean isFaceIdUnlockOn() {
        if (isBind() == true) goto L10;
        return false;
    L10:
        return this.mService.isFaceIdUnlockOn();
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public boolean isCloudIdUnlockOn() {
        if (isBind() == true) goto L10;
        return false;
    L10:
        return this.mService.isCloudIdUnlockOn();
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    }
}
