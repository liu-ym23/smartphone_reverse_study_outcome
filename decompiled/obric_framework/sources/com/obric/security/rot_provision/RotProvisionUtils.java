package com.obric.security.rot_provision;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import system.bytedance.hardware.rot_provision.IRotProvisionService;

/* JADX INFO: loaded from: classes.dex */
public class RotProvisionUtils {
    private static final String ROT_PROVISION_SERVICE_NAME = "system.bytedance.hardware.rot_provision.IRotProvisionService/default";
    public static final String TAG = null;
    private static final IBinder.DeathRecipient deathRecipient = null;
    private static volatile IRotProvisionService rotProvisionServiceBinder;

    /* JADX INFO: renamed from: -$$Nest$sfgetdeathRecipient, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBinder.DeathRecipient m65$$Nest$sfgetdeathRecipient() {
        return deathRecipient;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetrotProvisionServiceBinder, reason: not valid java name */
    static /* bridge */ /* synthetic */ IRotProvisionService m66$$Nest$sfgetrotProvisionServiceBinder() {
        return rotProvisionServiceBinder;
    }

    /* JADX INFO: renamed from: -$$Nest$sfputrotProvisionServiceBinder, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m67$$Nest$sfputrotProvisionServiceBinder(IRotProvisionService r0) {
        rotProvisionServiceBinder = r0;
    }

    public RotProvisionUtils() {
    }

    static {
        TAG = RotProvisionUtils.class.getSimpleName();
        deathRecipient = new AnonymousClass1();
    }

    public static IRotProvisionService getRotProvisionService() {
        if (rotProvisionServiceBinder != null) goto L21;
        monitor-enter(RotProvisionUtils.class);
    L17:
        th = move-exception;
        throw th;
    L7:
        if (rotProvisionServiceBinder != null) goto L10;
        rotProvisionServiceBinder = IRotProvisionService.Stub.asInterface(ServiceManager.getService(ROT_PROVISION_SERVICE_NAME));     // Catch: Throwable -> L17
    L10:
        if (rotProvisionServiceBinder != null) goto L22;
    L15:
        monitor-exit(RotProvisionUtils.class);     // Catch: Throwable -> L17
        goto L21
    L22:
        rotProvisionServiceBinder.asBinder().linkToDeath(deathRecipient, 0);     // Catch: RemoteException -> L13 Throwable -> L17
    L13:
        e = move-exception;
        Log.e(TAG, "Failed to link to death: " + e.getMessage());     // Catch: Throwable -> L17
        rotProvisionServiceBinder = null;     // Catch: Throwable -> L17
    L21:
        return rotProvisionServiceBinder;
    }
}
