package com.bytedanceos.securitycenter.networkControl;

import android.os.Build;
import android.os.IDeviceIdleController;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.obric.olog.OLog;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceIdleControllerHelper {
    private static final Boolean DEBUG = null;
    private static final String DEVICE_IDLE_SERVICE = "deviceidle";
    private static final String TAG = "DeviceIdle";

    public DeviceIdleControllerHelper() {
    }

    static {
        DEBUG = Boolean.valueOf(Build.IS_DEBUGGABLE);
    }

    public static void addApp(String name) {
        IDeviceIdleController.Stub.asInterface(ServiceManager.getService(DEVICE_IDLE_SERVICE)).addPowerSaveWhitelistApp(name);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public static void removeApp(String name) {
        IDeviceIdleController.Stub.asInterface(ServiceManager.getService(DEVICE_IDLE_SERVICE)).removePowerSaveWhitelistApp(name);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public static void addApps(Collection<String> collection) {
        IDeviceIdleController r0 = IDeviceIdleController.Stub.asInterface(ServiceManager.getService(DEVICE_IDLE_SERVICE));
        Iterator<String> r5 = collection.iterator();     // Catch: RemoteException -> L11
    L4:
        if (r5.hasNext() == false) goto L19;
        String r1 = r5.next();     // Catch: RemoteException -> L11
        if (DEBUG.booleanValue() == false) goto L9;
        OLog.i(TAG, "add doze app " + r1);     // Catch: RemoteException -> L11
    L9:
        r0.addPowerSaveWhitelistApp(r1);     // Catch: RemoteException -> L11
        goto L4
    L19:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    public static void removeApps(Collection<String> collection) {
        IDeviceIdleController r0 = IDeviceIdleController.Stub.asInterface(ServiceManager.getService(DEVICE_IDLE_SERVICE));
        Iterator<String> r2 = collection.iterator();     // Catch: RemoteException -> L8
    L5:
        if (r2.hasNext() == false) goto L15;
        r0.removePowerSaveWhitelistApp(r2.next());     // Catch: RemoteException -> L8
        goto L5
    L15:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public static boolean isWhileListApp(String packageName) {
        return IDeviceIdleController.Stub.asInterface(ServiceManager.getService(DEVICE_IDLE_SERVICE)).isPowerSaveWhitelistApp(packageName);
    L5:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
    L7:
        return false;
    }
}
