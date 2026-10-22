package com.obric.security.securityconfig;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import com.obric.security.IObricSecurityPluginService;

/* JADX INFO: loaded from: classes.dex */
public final class SecurityConfigManager {
    private static final int SECURITY_CONFIG_PLUGIN_CODE = 6;
    private static final String SERVICE_NAME = "ObricSecurityService";
    private static final String TAG = "SecurityConfigManager";
    private static final IBinder.DeathRecipient sDeathRecipient = null;
    private static final Object sLock = null;
    private static IObricSecurityConfigManager sService;
    private static IBinder sServiceBinder;

    /* JADX INFO: renamed from: -$$Nest$sfgetsLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m68$$Nest$sfgetsLock() {
        return sLock;
    }

    /* JADX INFO: renamed from: -$$Nest$sfputsService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m69$$Nest$sfputsService(IObricSecurityConfigManager r0) {
        sService = r0;
    }

    /* JADX INFO: renamed from: -$$Nest$sfputsServiceBinder, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m70$$Nest$sfputsServiceBinder(IBinder r0) {
        sServiceBinder = r0;
    }

    static {
        sLock = new Object();
        sDeathRecipient = new AnonymousClass1();
    }

    private SecurityConfigManager() {
    }

    public static int updateConfig(String key, String value) {
        IObricSecurityConfigManager service = getServiceLocked();
        if (service != null) goto L14;
        return -4;
    L14:
        return service.updateConfig(key, value);
    L11:
        e = move-exception;
        Log.w(TAG, "updateConfig remote exception", e);
        return -6;
    L8:
        e = move-exception;
        Log.w(TAG, "updateConfig runtime exception", e);
        return -100;
    }

    public static int updateConfigInt(String key, int value) {
        IObricSecurityConfigManager service = getServiceLocked();
        if (service != null) goto L14;
        return -4;
    L14:
        return service.updateConfigInt(key, value);
    L11:
        e = move-exception;
        Log.w(TAG, "updateConfigInt remote exception", e);
        return -6;
    L8:
        e = move-exception;
        Log.w(TAG, "updateConfigInt runtime exception", e);
        return -100;
    }

    private static IObricSecurityConfigManager getServiceLocked() {
        Object r0 = sLock;
        monitor-enter(r0);
    L51:
        th = move-exception;
        throw th;
    L5:
        if (sService == null) goto L9;
        IObricSecurityConfigManager r1 = sService;     // Catch: Throwable -> L51
        monitor-exit(r0);     // Catch: Throwable -> L51
        return r1;
    L9:
        IBinder binder = ServiceManager.getService(SERVICE_NAME);     // Catch: Throwable -> L51
        if (binder != null) goto L14;
        Log.w(TAG, "getServiceLocked: ObricSecurityService not found");     // Catch: Throwable -> L51
        monitor-exit(r0);     // Catch: Throwable -> L51
        return null;
    L14:
        IObricSecurityPluginService pluginService = IObricSecurityPluginService.Stub.asInterface(binder);     // Catch: Throwable -> L51
        if (pluginService != null) goto L55;
        Log.w(TAG, "getServiceLocked: plugin service null");     // Catch: Throwable -> L51
        monitor-exit(r0);     // Catch: Throwable -> L51
        return null;
    L55:
        IBinder configBinder = pluginService.querySecurityPlugin(6);     // Catch: RuntimeException -> L43 RemoteException -> L47 Throwable -> L51
        if (configBinder != null) goto L26;
        Log.w(TAG, "getServiceLocked: security config plugin binder null");     // Catch: RuntimeException -> L43 RemoteException -> L47 Throwable -> L51
        monitor-exit(r0);     // Catch: Throwable -> L51
        return null;
    L26:
        if (sServiceBinder != configBinder) goto L29;
    L39:
        sService = IObricSecurityConfigManager.Stub.asInterface(configBinder);     // Catch: RuntimeException -> L43 RemoteException -> L47 Throwable -> L51
        IObricSecurityConfigManager r2 = sService;     // Catch: Throwable -> L51
        monitor-exit(r0);     // Catch: Throwable -> L51
        return r2;
    L29:
        if (sServiceBinder == null) goto L58;
        sServiceBinder.unlinkToDeath(sDeathRecipient, 0);     // Catch: RuntimeException -> L32 RemoteException -> L47 Throwable -> L51
    L58:
        configBinder.linkToDeath(sDeathRecipient, 0);     // Catch: RemoteException -> L35 RuntimeException -> L43 Throwable -> L51
        sServiceBinder = configBinder;     // Catch: RemoteException -> L35 RuntimeException -> L43 Throwable -> L51
    L35:
        e = move-exception;
        Log.w(TAG, "getServiceLocked: linkToDeath failed", e);     // Catch: RuntimeException -> L43 RemoteException -> L47 Throwable -> L51
        sServiceBinder = null;     // Catch: RuntimeException -> L43 RemoteException -> L47 Throwable -> L51
        sService = null;     // Catch: RuntimeException -> L43 RemoteException -> L47 Throwable -> L51
        return null;
    L47:
        e = move-exception;
        Log.w(TAG, "getServiceLocked: querySecurityPlugin remote exception", e);     // Catch: Throwable -> L51
        return null;
    L43:
        e = move-exception;
        Log.w(TAG, "getServiceLocked: runtime exception", e);     // Catch: Throwable -> L51
        return null;
    }
}
