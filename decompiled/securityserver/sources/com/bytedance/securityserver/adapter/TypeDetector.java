package com.bytedance.securityserver.adapter;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class TypeDetector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f43a = -1;

    public static synchronized int a() {
        monitor-enter(TypeDetector.class);
        int r1 = f43a;     // Catch: Throwable -> L27
        if (r1 == (-1)) goto L10;
        monitor-exit(TypeDetector.class);
        return r1;
    L10:
        int r3 = 1;
        Class.forName("com.obric.security.agentmanager.AgentManager", false, null);     // Catch: Throwable -> L13 Throwable -> L27
        boolean r2 = true;
    L15:
        if (r2 == false) goto L34;
        Log.i("SecurityLibTypeDetector", "securitylib framework detected: obric");     // Catch: Throwable -> L27
    L24:
        f43a = r3;     // Catch: Throwable -> L27
        monitor-exit(TypeDetector.class);
        return r3;
    L34:
        Class.forName("com.aiassistant.security.agentmanager.AgentManager", false, null);     // Catch: Throwable -> L20 Throwable -> L27
    L21:
        if (r3 == 0) goto L23;
        Log.i("SecurityLibTypeDetector", "securitylib framework detected: assistant");     // Catch: Throwable -> L27
        r3 = 2;
        goto L24
    L23:
        Log.w("SecurityLibTypeDetector", "securitylib framework not found (TYPE_UNKNOWN)");     // Catch: Throwable -> L27
        r3 = 0;
    L20:
        r3 = 0;
    L13:
        r2 = false;
    L27:
        th = move-exception;
        throw th;
    }
}
