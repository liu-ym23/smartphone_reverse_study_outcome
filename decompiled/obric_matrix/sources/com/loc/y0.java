package com.loc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static int f7975a = 1000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static boolean f7976b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static WeakReference<v0> f7977c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static int f7978d = 20;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f7979e = 10;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static int f7980f;

    static class a extends s1 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f7981g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Context f7982h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private x0 f7983i;

        a(Context r1, int r2) {
            this.f7982h = r1;
            this.f7981g = r2;
        }

        a(Context r2, x0 r3) {
            this(r2, 1);
            this.f7983i = r3;
        }

        @Override // com.loc.s1
        public final void b() {
            int r0 = this.f7981g;
            if (r0 != 1) goto L19;
            monitor-enter(y0.class);     // Catch: Throwable -> L15
            String r1 = Long.toString(System.currentTimeMillis());     // Catch: Throwable -> L12
            v0 r2 = b1.a(y0.a());     // Catch: Throwable -> L12
            b1.e(this.f7982h, r2, t.f7785f, y0.f7975a, 2097152, "6");     // Catch: Throwable -> L12
            if (r2.f7884e != null) goto L9;
            r2.f7884e = new g0(new i0(new j0(new i0())));     // Catch: Throwable -> L12
        L9:
            w0.c(r1, this.f7983i.b(), r2);     // Catch: Throwable -> L12
            monitor-exit(y0.class);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            v.m(th, "ofm", "aple");
            return;
        L19:
            if (r0 != 2) goto L37;
            v0 r3 = b1.a(y0.a());     // Catch: Throwable -> L28
            b1.e(this.f7982h, r3, t.f7785f, y0.f7975a, 2097152, "6");     // Catch: Throwable -> L28
            r3.f7887h = 14400000;     // Catch: Throwable -> L28
            if (r3.f7886g != null) goto L24;
            g0 r7 = new g0(new i0(new j0()));     // Catch: Throwable -> L28
            r3.f7886g = new f1(new e1(this.f7982h, new j1(), r7, new String(g.c()), new Object[]{i5.j(this.f7982h), l5.P(), l5.I(), l5.F(this.f7982h), l5.o(), Build.MANUFACTURER, Build.DEVICE, l5.U(), i5.g(this.f7982h), Build.MODEL, i5.h(this.f7982h), i5.e(this.f7982h), l5.D(this.f7982h), l5.p(this.f7982h), String.valueOf(Build.VERSION.SDK_INT), c.a(this.f7982h).b()}));     // Catch: Throwable -> L28
        L24:
            if (TextUtils.isEmpty(r3.f7888i) == false) goto L26;
            r3.f7888i = "fKey";     // Catch: Throwable -> L28
        L26:
            Context r12 = this.f7982h;     // Catch: Throwable -> L28
            r3.f7885f = new n1(r12, r3.f7887h, r3.f7888i, new l1(r12, y0.f7976b, y0.e() * 1024, y0.f7978d * 1024, "offLocKey", y0.f7980f * 1024));     // Catch: Throwable -> L28
            w0.a(r3);     // Catch: Throwable -> L28
            return;
        L28:
            th = move-exception;
            v.m(th, "ofm", "uold");
            return;
        }
    }

    static {
    }

    public y0() {
    }

    static /* synthetic */ WeakReference a() {
        return f7977c;
    }

    public static synchronized void b(int r1, boolean r2, int r3, int r4) {
        monitor-enter(y0.class);
        f7975a = r1;     // Catch: Throwable -> L15
        f7976b = r2;     // Catch: Throwable -> L15
        if (r3 >= 10) goto L7;
    L8:
        r3 = 20;
    L9:
        f7978d = r3;     // Catch: Throwable -> L15
        if ((r3 / 5) <= f7979e) goto L12;
        f7979e = r3 / 5;     // Catch: Throwable -> L15
    L12:
        f7980f = r4;     // Catch: Throwable -> L15
        monitor-exit(y0.class);
        return;
    L7:
        if (r3 <= 100) goto L9;
    L15:
        th = move-exception;
        throw th;
    }

    public static void c(Context r3) {
        r1.f().d(new a(r3, 2));
    }

    public static synchronized void d(x0 r3, Context r4) {
        monitor-enter(y0.class);
        r1.f().d(new a(r4, r3));     // Catch: Throwable -> L7
        monitor-exit(y0.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ int e() {
        return f7979e;
    }
}
