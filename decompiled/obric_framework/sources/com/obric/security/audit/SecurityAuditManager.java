package com.obric.security.audit;

import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import com.obric.security.IObricSecurityPluginService;
import com.obric.security.robots.RobotsProtocolHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SecurityAuditManager {
    private static final int AUDIT_PLUGIN_CODE = 5;
    private static final String SERVICE_NAME = "ObricSecurityService";
    private static final String TAG = "SecurityAuditManager";
    private static final IBinder.DeathRecipient sDeathRecipient = null;
    private static final Object sLock = null;
    private static IObricAuditManager sService;
    private static IBinder sServiceBinder;

    /* JADX INFO: renamed from: -$$Nest$sfgetsLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m59$$Nest$sfgetsLock() {
        return sLock;
    }

    /* JADX INFO: renamed from: -$$Nest$sfputsService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m60$$Nest$sfputsService(IObricAuditManager r0) {
        sService = r0;
    }

    /* JADX INFO: renamed from: -$$Nest$sfputsServiceBinder, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m61$$Nest$sfputsServiceBinder(IBinder r0) {
        sServiceBinder = r0;
    }

    static {
        sLock = new Object();
        sDeathRecipient = new AnonymousClass1();
    }

    private SecurityAuditManager() {
    }

    public static boolean recordAudit(String json) {
        if (recordAuditWithResult(json) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static int recordAuditWithResult(String json) {
        IObricAuditManager service = getServiceLocked();
        if (service != null) goto L18;
        Log.w(TAG, "recordAuditWithResult: service not ready");
        return 2;
    L18:
        int result = service.recordAuditWithResult(json);     // Catch: Throwable -> L12 RemoteException -> L15
        if (result != 0) goto L10;
        Log.d(TAG, "recordAuditWithResult: service result=" + result);     // Catch: Throwable -> L12 RemoteException -> L15
    L11:
        return result;
    L10:
        Log.w(TAG, "recordAuditWithResult: service result=" + result);     // Catch: Throwable -> L12 RemoteException -> L15
    L15:
        e = move-exception;
        Log.w(TAG, "recordAuditWithResult remote exception", e);
        return 8;
    L12:
        t = move-exception;
        Log.w(TAG, "recordAuditWithResult unexpected error", t);
        return 100;
    }

    public static List<String> queryLogs(long startTimeMs, long endTimeMs, String targetIntent, String targetActivity) {
        if (RobotsProtocolHelper.isRobotsEnabled() == true) goto L6;
        Log.d(TAG, "queryLogs: robots protocol disabled");
        return new ArrayList();
    L6:
        IObricAuditManager service = getServiceLocked();
        if (service != null) goto L22;
        return new ArrayList();
    L22:
        List<String> list = service.queryLogs(startTimeMs, endTimeMs, targetIntent, targetActivity);     // Catch: Throwable -> L16 RemoteException -> L18
        if (list != null) goto L24;
        return new ArrayList();
    L24:
        return list;
    L18:
        e = move-exception;
        Log.w(TAG, "queryLogs remote exception", e);
    L21:
        return new ArrayList();
    L16:
        t = move-exception;
        Log.w(TAG, "queryLogs unexpected error", t);
        goto L21
    }

    public static ParcelFileDescriptor exportAllLogs(long startTimeMs, long endTimeMs, boolean gzip) {
        IObricAuditManager service = getServiceLocked();
        if (service != null) goto L15;
        Log.w(TAG, "exportAllLogs: service not ready");
        return null;
    L15:
        return service.exportAllLogs(startTimeMs, endTimeMs, gzip);
    L12:
        e = move-exception;
        Log.w(TAG, "exportAllLogs remote exception", e);
        return null;
    L9:
        t = move-exception;
        Log.w(TAG, "exportAllLogs unexpected error", t);
        return null;
    }

    public static void setActiveSession(String sessionId) {
        IObricAuditManager service = getServiceLocked();
        if (service != null) goto L14;
        Log.w(TAG, "setActiveSession: service not ready");
        return;
    L14:
        service.setActiveSession(sessionId, 0);     // Catch: Throwable -> L9 RemoteException -> L11
    L16:
        return;
    L11:
        e = move-exception;
        Log.w(TAG, "setActiveSession remote exception", e);
        return;
    L9:
        t = move-exception;
        Log.w(TAG, "setActiveSession unexpected error", t);
    }

    public static void clearActiveSession() {
        IObricAuditManager service = getServiceLocked();
        if (service != null) goto L14;
        Log.w(TAG, "clearActiveSession: service not ready");
        return;
    L14:
        service.clearActiveSession(null);     // Catch: Throwable -> L9 RemoteException -> L11
    L16:
        return;
    L11:
        e = move-exception;
        Log.w(TAG, "clearActiveSession remote exception", e);
        return;
    L9:
        t = move-exception;
        Log.w(TAG, "clearActiveSession unexpected error", t);
    }

    public static int getPendingUploadCount() {
        IObricAuditManager service = getServiceLocked();
        if (service != null) goto L13;
        return 0;
    L13:
        return service.getPendingUploadCount();
    L10:
        e = move-exception;
        Log.w(TAG, "getPendingUploadCount remote exception", e);
        return 0;
    L7:
        t = move-exception;
        Log.w(TAG, "getPendingUploadCount unexpected error", t);
        return 0;
    }

    public static String getPendingUploadReport(int maxCount, int maxBytes) {
        IObricAuditManager service = getServiceLocked();
        if (service != null) goto L13;
        return null;
    L13:
        return service.getPendingUploadReport(maxCount, maxBytes);
    L10:
        e = move-exception;
        Log.w(TAG, "getPendingUploadReport remote exception", e);
        return null;
    L7:
        t = move-exception;
        Log.w(TAG, "getPendingUploadReport unexpected error", t);
        return null;
    }

    public static int confirmUploadSuccess(String batchId) {
        IObricAuditManager service = getServiceLocked();
        if (service != null) goto L14;
        return 2;
    L14:
        return service.confirmUploadSuccess(batchId);
    L11:
        e = move-exception;
        Log.w(TAG, "confirmUploadSuccess remote exception", e);
        return 8;
    L8:
        t = move-exception;
        Log.w(TAG, "confirmUploadSuccess unexpected error", t);
        return 100;
    }

    public static int confirmUploadFailure(String batchId, int errorCode, String errorMessage) {
        IObricAuditManager service = getServiceLocked();
        if (service != null) goto L14;
        return 2;
    L14:
        return service.confirmUploadFailure(batchId, errorCode, errorMessage);
    L11:
        e = move-exception;
        Log.w(TAG, "confirmUploadFailure remote exception", e);
        return 8;
    L9:
        return 100;
    }

    private static IObricAuditManager getServiceLocked() {
        Object r0 = sLock;
        monitor-enter(r0);
    L51:
        th = move-exception;
        throw th;
    L5:
        if (sService == null) goto L9;
        IObricAuditManager r1 = sService;     // Catch: Throwable -> L51
        monitor-exit(r0);     // Catch: Throwable -> L51
        return r1;
    L9:
        IBinder binder = ServiceManager.getService(SERVICE_NAME);     // Catch: Throwable -> L51
        if (binder != null) goto L14;
        Log.w(TAG, "getServiceLocked: ObircSecurityService not found");     // Catch: Throwable -> L51
        monitor-exit(r0);     // Catch: Throwable -> L51
        return null;
    L14:
        IObricSecurityPluginService pluginService = IObricSecurityPluginService.Stub.asInterface(binder);     // Catch: Throwable -> L51
        if (pluginService != null) goto L55;
        Log.w(TAG, "getServiceLocked: plugin service null");     // Catch: Throwable -> L51
        monitor-exit(r0);     // Catch: Throwable -> L51
        return null;
    L55:
        IBinder auditBinder = pluginService.querySecurityPlugin(5);     // Catch: Throwable -> L43 RemoteException -> L47
        if (auditBinder != null) goto L26;
        Log.w(TAG, "getServiceLocked: audit plugin binder null");     // Catch: Throwable -> L43 RemoteException -> L47
        monitor-exit(r0);     // Catch: Throwable -> L51
        return null;
    L26:
        if (sServiceBinder != auditBinder) goto L29;
    L39:
        sService = IObricAuditManager.Stub.asInterface(auditBinder);     // Catch: Throwable -> L43 RemoteException -> L47
        IObricAuditManager r2 = sService;     // Catch: Throwable -> L51
        monitor-exit(r0);     // Catch: Throwable -> L51
        return r2;
    L29:
        if (sServiceBinder == null) goto L58;
        sServiceBinder.unlinkToDeath(sDeathRecipient, 0);     // Catch: Throwable -> L32
    L58:
        auditBinder.linkToDeath(sDeathRecipient, 0);     // Catch: RemoteException -> L35 Throwable -> L43
        sServiceBinder = auditBinder;     // Catch: RemoteException -> L35 Throwable -> L43
    L35:
        e = move-exception;
        Log.w(TAG, "getServiceLocked: linkToDeath failed", e);     // Catch: Throwable -> L43 RemoteException -> L47
        sServiceBinder = null;     // Catch: Throwable -> L43 RemoteException -> L47
        sService = null;     // Catch: Throwable -> L43 RemoteException -> L47
        return null;
    L47:
        e = move-exception;
        Log.w(TAG, "getServiceLocked: querySecurityPlugin remote exception", e);     // Catch: Throwable -> L51
        return null;
    L43:
        t = move-exception;
        Log.w(TAG, "getServiceLocked: unexpected error", t);     // Catch: Throwable -> L51
        return null;
    }
}
