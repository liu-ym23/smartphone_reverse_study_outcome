package com.android.server.accessibility;

import android.os.Handler;
import android.os.RemoteException;
import android.util.Slog;
import android.view.accessibility.IAccessibilityManagerClient;
import com.android.internal.util.ArrayUtils;

/* JADX INFO: loaded from: classes.dex */
public class ObricAccessibilityManagerServiceImpl implements IObricAccessibilityManagerService {
    private static final String LOG_TAG = "ObricAccessibilityManagerServiceImpl";
    private AbstractAccessibilityServiceConnection mCurrentConnection;
    private AccessibilityManagerService mService;
    private int mTargetEventType;
    private int mTargetInterval;
    private String mTargetPackageName;

    /* JADX INFO: renamed from: $r8$lambda$1Ur-sedYIp8IaaLsZ-CUvOuB2vo, reason: not valid java name */
    public static /* synthetic */ void m0$r8$lambda$1UrsedYIp8IaaLsZCUvOuB2vo(ObricAccessibilityManagerServiceImpl r0, AccessibilityManagerService.Client r1) {
        r0.lambda$handleClientAdded$0(r1);
    }

    public ObricAccessibilityManagerServiceImpl(AccessibilityManagerService base) {
        this.mTargetPackageName = "";
        this.mTargetEventType = -1;
        this.mTargetInterval = -1;
        this.mService = base;
    }

    public void setMinumumIntervalObric(String targetPackageName, int eventType, int interval, AbstractAccessibilityServiceConnection connection) {
        Object r0 = this.mService.getLock();
        monitor-enter(r0);
        int i = 0;
    L22:
    L19:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mService.getCurrentUserState().mUserClients.getRegisteredCallbackCount()) goto L16;
        AccessibilityManagerService.Client client = (AccessibilityManagerService.Client) this.mService.getCurrentUserState().mUserClients.getRegisteredCallbackCookie(i);     // Catch: Throwable -> L19
        if (client.mPackageNames == null) goto L15;
        if (ArrayUtils.contains(client.mPackageNames, targetPackageName) == false) goto L15;
        client.mCallback.setMinumumIntervalObric(eventType, interval);     // Catch: RemoteException -> L13 Throwable -> L19
    L14:
        Slog.e(LOG_TAG, "Failed to set minimum interval for " + targetPackageName);     // Catch: Throwable -> L19
    L15:
        i = i + 1;     // Catch: Throwable -> L19
        goto L22
    L16:
        this.mTargetPackageName = targetPackageName;     // Catch: Throwable -> L19
        this.mTargetEventType = eventType;     // Catch: Throwable -> L19
        this.mTargetInterval = interval;     // Catch: Throwable -> L19
        this.mCurrentConnection = connection;     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
    }

    public void clearFrequencyLimit(AbstractAccessibilityServiceConnection connection) {
        Slog.d(LOG_TAG, connection + "is deconnecting");
        Object r0 = this.mService.getLock();
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (connection != this.mCurrentConnection) goto L7;
        this.mTargetPackageName = "";     // Catch: Throwable -> L9
        this.mTargetEventType = -1;     // Catch: Throwable -> L9
        this.mTargetInterval = -1;     // Catch: Throwable -> L9
        this.mCurrentConnection = null;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public void handleClientAdded(final AccessibilityManagerService.Client client, Handler mainHandler) {
        Object r0 = this.mService.getLock();
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (client.mPackageNames != null) goto L7;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        if (ArrayUtils.contains(client.mPackageNames, this.mTargetPackageName) == false) goto L9;
        mainHandler.postDelayed(new ObricAccessibilityManagerServiceImpl$$ExternalSyntheticLambda0(this, client), 500);     // Catch: Throwable -> L11
        goto L9
    }

    private /* synthetic */ void lambda$handleClientAdded$0(AccessibilityManagerService.Client client) {
        Object r0 = this.mService.getLock();
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (client.mCallback != null) goto L21;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L21:
        IAccessibilityManagerClient r1 = client.mCallback;     // Catch: RemoteException -> L12 Throwable -> L16
        int r2 = this.mTargetEventType;     // Catch: RemoteException -> L12 Throwable -> L16
        if (this.mTargetInterval > 0) goto L9;
        int r3 = -1;
    L10:
        r1.setMinumumIntervalObric(r2, r3);     // Catch: RemoteException -> L12 Throwable -> L16
    L9:
        r3 = this.mTargetInterval;     // Catch: RemoteException -> L12 Throwable -> L16
    L12:
        e = move-exception;
        Slog.e(LOG_TAG, "Failed to set minimum interval", e);     // Catch: Throwable -> L16
        goto L14
    }
}
