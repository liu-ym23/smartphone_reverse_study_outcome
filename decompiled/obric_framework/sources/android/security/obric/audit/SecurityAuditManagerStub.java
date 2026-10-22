package android.security.obric.audit;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SecurityAuditManagerStub {
    private static final String IMPL_CLASS_NAME = "com.obric.security.audit.SecurityAuditManager";
    private static final String TAG = "SecurityAuditManagerStub";
    private static volatile SecurityAuditManagerStub sInstance;
    private Class<?> mClazz;

    private SecurityAuditManagerStub() {
    }

    public static SecurityAuditManagerStub getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(SecurityAuditManagerStub.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SecurityAuditManagerStub();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SecurityAuditManagerStub.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public int recordAuditWithResult(String json) {
        init();
        if (this.mClazz != null) goto L12;
        return 100;
    L12:
        Method method = this.mClazz.getDeclaredMethod("recordAuditWithResult", new Class[]{String.class});     // Catch: Exception -> L9
        method.setAccessible(true);     // Catch: Exception -> L9
        Object ret = method.invoke(null, new Object[]{json});     // Catch: Exception -> L9
        if ((ret instanceof Integer) == false) goto L14;
        return ((Integer) ret).intValue();
    L14:
        return 100;
    L9:
        e = move-exception;
        Log.e(TAG, "recordAuditWithResult failed", e);
        return 100;
    }

    public List<String> queryLogs(long startTimeMs, long endTimeMs, String targetIntent, String targetActivity) {
        init();
        if (this.mClazz == null) goto L5;
        Method method = this.mClazz.getDeclaredMethod("queryLogs", new Class[]{Long.TYPE, Long.TYPE, String.class, String.class});     // Catch: Exception -> L11
        method.setAccessible(true);     // Catch: Exception -> L11
        Object ret = method.invoke(null, new Object[]{Long.valueOf(startTimeMs), Long.valueOf(endTimeMs), targetIntent, targetActivity});     // Catch: Exception -> L11
        if ((ret instanceof List) == false) goto L10;
        return (List) ret;
    L10:
        return new ArrayList();
    L11:
        e = move-exception;
        Log.e(TAG, "queryLogs failed", e);
        return new ArrayList();
    L5:
        return new ArrayList();
    }

    private void init() {
        if (this.mClazz == null) goto L10;
        return;
    L10:
        this.mClazz = Class.forName(IMPL_CLASS_NAME);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        Log.e(TAG, "init failed", e);
        this.mClazz = null;
    }
}
