package com.bytedance.securityserver.adapter;

import android.security.aiassistant.guard.AssistantSecurityGuardStub;
import android.security.obric.guard.ObricSecurityGuardStub;
import android.util.Log;
import com.bytedance.securityserver.adapter.api.IAgentManager;
import com.bytedance.securityserver.adapter.api.IKeyManager;
import com.bytedance.securityserver.adapter.api.ISecretDataManager;
import com.bytedance.securityserver.adapter.api.ISecurityAuditReportManager;
import com.bytedance.securityserver.adapter.api.ISecurityConfig;
import com.bytedance.securityserver.adapter.api.ISecurityGuard;
import com.bytedance.securityserver.adapter.api.ITeaReportBridge;
import com.bytedance.securityserver.adapter.assistant.AssistantSecretDataManagerAdapter;
import com.bytedance.securityserver.adapter.assistant.AssistantSecurityConfigAdapter;
import com.bytedance.securityserver.adapter.assistant.AssistantSecurityGuardAdapter;
import com.bytedance.securityserver.adapter.obric.ObricSecretDataManagerAdapter;
import com.bytedance.securityserver.adapter.obric.ObricSecurityConfigAdapter;
import com.bytedance.securityserver.adapter.obric.ObricSecurityGuardAdapter;

/* JADX INFO: loaded from: classes.dex */
public class SecurityLibFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IAgentManager f41a;
    public static IKeyManager b;
    public static ISecurityConfig c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ISecretDataManager f42d;
    public static ISecurityGuard e;
    public static ISecurityAuditReportManager f;
    public static ITeaReportBridge g;

    public static synchronized ISecretDataManager a() {
        monitor-enter(SecurityLibFactory.class);
        ISecretDataManager r1 = f42d;     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        monitor-exit(SecurityLibFactory.class);
        return r1;
    L8:
        int r2 = TypeDetector.a();     // Catch: Throwable -> L11
        if (r2 != 1) goto L14;
        f42d = new ObricSecretDataManagerAdapter();     // Catch: Throwable -> L11
    L16:
        ISecretDataManager r3 = f42d;     // Catch: Throwable -> L11
        monitor-exit(SecurityLibFactory.class);
        return r3;
    L14:
        if (r2 != 2) goto L16;
        f42d = new AssistantSecretDataManagerAdapter();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public static synchronized ISecurityConfig b() {
        monitor-enter(SecurityLibFactory.class);
        ISecurityConfig r1 = c;     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        monitor-exit(SecurityLibFactory.class);
        return r1;
    L8:
        int r2 = TypeDetector.a();     // Catch: Throwable -> L11
        if (r2 != 1) goto L14;
        c = new ObricSecurityConfigAdapter();     // Catch: Throwable -> L11
    L16:
        ISecurityConfig r3 = c;     // Catch: Throwable -> L11
        monitor-exit(SecurityLibFactory.class);
        return r3;
    L14:
        if (r2 != 2) goto L16;
        c = new AssistantSecurityConfigAdapter();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public static synchronized ISecurityGuard c() {
        monitor-enter(SecurityLibFactory.class);
        ISecurityGuard r1 = e;     // Catch: Throwable -> L22
        if (r1 == null) goto L27;
        monitor-exit(SecurityLibFactory.class);
        return r1;
    L27:
        ObricSecurityGuardStub r2 = ObricSecurityGuardStub.getInstance();     // Catch: Throwable -> L25
        if (r2 == null) goto L31;
        e = new ObricSecurityGuardAdapter(r2);     // Catch: Throwable -> L25
        Log.i("SecurityLibFactory", "SecurityGuard: using obric");     // Catch: Throwable -> L25
        ISecurityGuard r3 = e;     // Catch: Throwable -> L25
        monitor-exit(SecurityLibFactory.class);
        return r3;
    L31:
        AssistantSecurityGuardStub r4 = AssistantSecurityGuardStub.getInstance();     // Catch: Throwable -> L26
        if (r4 == null) goto L18;
        e = new AssistantSecurityGuardAdapter(r4);     // Catch: Throwable -> L26
        Log.i("SecurityLibFactory", "SecurityGuard: using assistant");     // Catch: Throwable -> L26
        ISecurityGuard r5 = e;     // Catch: Throwable -> L26
        monitor-exit(SecurityLibFactory.class);
        return r5;
    L18:
        Log.w("SecurityLibFactory", "SecurityGuard: both obric and assistant unavailable");     // Catch: Throwable -> L22
        monitor-exit(SecurityLibFactory.class);
        return null;
    L22:
        th = move-exception;
        throw th;
    }
}
