package com.bytedance.privacy.e;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile b f5366b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.privacy.b.b f5367a;

    static {
    }

    public b() {
    }

    public static b a() {
        if (f5366b != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5366b != null) goto L9;
        f5366b = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f5366b;
    }

    public void b(com.bytedance.privacy.b.b r2) {
        Objects.requireNonNull(r2, "IEnvBridge envBridge cannot be null");
        this.f5367a = r2;
    }

    public boolean c() {
        com.bytedance.privacy.b.b r0 = this.f5367a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }
}
