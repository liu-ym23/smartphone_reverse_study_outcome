package com.bytedance.privacy;

import android.content.Context;
import com.bytedance.privacy.a.c;
import com.bytedance.privacy.b.a;
import com.bytedance.privacy.b.b;
import com.bytedance.privacy.pcc.PccManager;
import com.bytedance.privacy.pseudoid.PseudoManager;

/* JADX INFO: loaded from: classes.dex */
public class PrivacySdk {
    private static volatile boolean initialized = false;

    static {
    }

    public PrivacySdk() {
    }

    private static void checkInitialized() {
        if (initialized == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Privacy SDK not initialized. Please call PrivacySdk.init(...) during app startup.");
    }

    public static c getIdAttestationManager() {
        checkInitialized();
        return c.f();
    }

    public static PccManager getPccManager(Context r0) {
        checkInitialized();
        return PccManager.getInstance(r0);
    }

    public static PseudoManager getPseudoManager() {
        checkInitialized();
        return PseudoManager.getInstance();
    }

    public static void init(a r2, b r3) {
        if (initialized == false) goto L5;
        return;
    L5:
        monitor-enter(PrivacySdk.class);
    L17:
        th = move-exception;
        throw th;
    L7:
        if (initialized == true) goto L15;
        if (r2 == null) goto L14;
        if (r3 == null) goto L12;
        com.bytedance.privacy.pseudoid.c.a.e(r2);     // Catch: Throwable -> L17
        com.bytedance.privacy.e.b.a().b(r3);     // Catch: Throwable -> L17
        initialized = true;     // Catch: Throwable -> L17
        goto L15
    L12:
        throw new com.bytedance.privacy.c.a("IEnvBridge cannot be null");     // Catch: Throwable -> L17
    L14:
        throw new com.bytedance.privacy.c.a("IAccountBridge cannot be null");     // Catch: Throwable -> L17
    L15:
        monitor-exit(PrivacySdk.class);     // Catch: Throwable -> L17
    }

    public static boolean isInitialized() {
        return initialized;
    }
}
