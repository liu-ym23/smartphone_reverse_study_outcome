package com.bytedance.apm.d0;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f1491a;

    static {
        f1491a = new a();
    }

    public static boolean a(String r1) {
        return f1491a.getLogTypeSwitch(r1);
    }

    public static boolean b(String r1) {
        return f1491a.b(r1);
    }

    public static boolean c(String r1) {
        return f1491a.d(r1);
    }

    public static boolean d(String r1, String r2) {
        return f1491a.a(r1, r2);
    }

    public static boolean e(String r1) {
        return f1491a.c(r1);
    }

    public static boolean f(String r1) {
        return f1491a.getServiceSwitch(r1);
    }

    public static void g(b r0) {
        f1491a = r0;
    }
}
