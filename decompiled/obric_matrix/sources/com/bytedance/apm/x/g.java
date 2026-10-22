package com.bytedance.apm.x;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static f.b f2132a;

    static {
        f2132a = f.f2131a;
    }

    public static void a(String r1, String r2, Object... r3) {
        f.b r0 = f2132a;
        if (r0 == null) goto L6;
        r0.c(r1, r2, r3);
        return;
    }

    public static void b(String r1, String r2, Object... r3) {
        f.b r0 = f2132a;
        if (r0 == null) goto L6;
        r0.b(r1, r2, r3);
        return;
    }

    public static void c(String r1, String r2, Object... r3) {
        f.b r0 = f2132a;
        if (r0 == null) goto L6;
        r0.a(r1, r2, r3);
        return;
    }
}
