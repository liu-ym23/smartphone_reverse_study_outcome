package com.bytedance.apm.x;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f2120a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f2121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static c f2122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static c f2123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile d.b.b.i.b f2124e;

    static {
    }

    public static void a(String r1, String r2) {
        if (f2120a == false) goto L8;
        c r0 = f2122c;
        if (r0 == null) goto L9;
        r0.c(r1, r2);
        return;
    L9:
        return;
    }

    public static void b(String r1, String r2) {
        if (f2121b == false) goto L8;
        c r0 = f2122c;
        if (r0 == null) goto L9;
        r0.b(r1, r2);
        return;
    L9:
        return;
    }

    public static c c() {
        return f2123d;
    }

    public static void d(String r1, String r2) {
        if (f2120a == false) goto L8;
        c r0 = f2122c;
        if (r0 == null) goto L9;
        r0.b(r1, r2);
        return;
    L9:
        return;
    }

    public static boolean e() {
        return f2121b;
    }

    public static boolean f() {
        if (f2124e == null) goto L6;
        return true;
    L6:
        return false;
    }

    public static void g(String r1, String r2) {
        if (f2124e == null) goto L6;
        f2124e.a(r1, r2);
        return;
    }

    public static void h(c r0) {
        f2122c = r0;
        if (r0 == null) goto L6;
        f2120a = true;
        return;
    }

    public static void i(boolean r0) {
        f2120a = r0;
    }

    public static void j(d.b.b.i.b r0) {
        f2124e = r0;
    }
}
