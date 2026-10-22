package d.c.f.a.a;

import android.content.Context;
import d.c.i.g.h;
import d.c.i.g.j;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Class<?> f15491a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static f f15492b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f15493c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f15494d = true;

    static {
        f15491a = c.class;
    }

    private c() {
    }

    public static d.c.i.g.g a() {
        return b().m();
    }

    public static j b() {
        return j.o();
    }

    public static boolean c() {
        return f15493c;
    }

    public static void d(Context r1, h r2) {
        e(r1, r2, null);
    }

    public static void e(Context r4, h r5, b r6) {
        if (d.c.i.r.b.d() == false) goto L6;
        d.c.i.r.b.a("Fresco#initialize");
    L6:
        if (f15493c == false) goto L13;
        d.c.c.e.a.f(f15491a, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        if (f15494d == false) goto L10;
    L33:
    L21:
        e = move-exception;
        d.c.c.e.a.B(f15491a, e, "Could not initialize SoLoader", new Object[0]);
        if (d.c.i.r.b.d() == false) goto L25;
        d.c.i.r.b.b();
    L25:
        Context r7 = r4.getApplicationContext();
        if (r5 != null) goto L28;
        j.x(r7);
    L29:
        f(r7, r6);
        if (d.c.i.r.b.d() == false) goto L36;
        d.c.i.r.b.b();
        return;
    L36:
        return;
    L28:
        j.y(r5);
        goto L29
    L15:
        if (d.c.i.r.b.d() == false) goto L17;
        d.c.i.r.b.a("Fresco.initialize->SoLoader.init");     // Catch: Exception -> L21
    L17:
        com.facebook.imageutils.c.a(r4);     // Catch: Exception -> L21
        if (d.c.i.r.b.d() == false) goto L25;
        d.c.i.r.b.b();     // Catch: Exception -> L21
        goto L25
    L10:
        if (d.c.i.r.b.d() == false) goto L35;
        d.c.i.r.b.b();
        return;
    L35:
        return;
    L13:
        f15493c = true;
        goto L33
    }

    private static void f(Context r1, b r2) {
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("Fresco.initializeDrawee");
    L5:
        f r0 = new f(r1, r2);
        f15492b = r0;
        d.c.f.i.f.m(r0);
        if (d.c.i.r.b.d() == false) goto L9;
        d.c.i.r.b.b();
        return;
    }

    public static e g() {
        return f15492b.a();
    }
}
