package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f7109a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static int f7110b = 20;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f7111c = 20;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static WeakReference<v0> f7112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f7113e;

    static class a extends s1 {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        static int f7114k = 1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        static int f7115l = 2;
        static int m = 3;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Context f7116g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private z0 f7117h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f7118i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private List<z0> f7119j;

        static {
        }

        a(Context r1, int r2) {
            this.f7116g = r1;
            this.f7118i = r2;
        }

        a(Context r1, int r2, z0 r3) {
            this(r1, r2);
            this.f7117h = r3;
        }

        a(Context r1, int r2, List<z0> r3) {
            this(r1, r2);
            this.f7119j = r3;
        }

        @Override // com.loc.s1
        public final void b() {
            int r1 = this.f7118i;
            if (r1 != 1) goto L29;
        L24:
            th = th;
            String r0 = "stm";
            String r2 = "as";
        L26:
            v.m(th, r0, r2);
            return;
        L5:
            if (this.f7116g != null) goto L7;
            return;
        L7:
            if (this.f7117h == null) goto L119;
            monitor-enter(a1.class);     // Catch: Throwable -> L24
            Context r3 = this.f7116g;     // Catch: Throwable -> L20
            if (r3 == null) goto L18;
            z0 r15 = this.f7117h;     // Catch: Throwable -> L20
            if (r15 == null) goto L18;
            a1.c(r3, r15.b());     // Catch: Throwable -> L20
            monitor-exit(a1.class);     // Catch: Throwable -> L20
            return;
        L18:
            monitor-exit(a1.class);     // Catch: Throwable -> L20
            return;
        L20:
            th = move-exception;
            throw th;     // Catch: Throwable -> L24
        L119:
            return;
        L29:
            if (r1 != 2) goto L78;
            monitor-enter(a1.class);     // Catch: Throwable -> L75
        L72:
            th = move-exception;
            throw th;     // Catch: Throwable -> L75
        L32:
            if (this.f7119j != null) goto L34;
        L70:
            monitor-exit(a1.class);     // Catch: Throwable -> L72
            return;
        L34:
            if (this.f7116g == null) goto L70;
            byte[] r4 = new byte[0];     // Catch: Throwable -> L72
            ByteArrayOutputStream r5 = new ByteArrayOutputStream();     // Catch: Throwable -> L52
            Iterator<z0> r6 = this.f7119j.iterator();     // Catch: Throwable -> L50
        L40:
            if (r6.hasNext() == false) goto L44;
            z0 r7 = r6.next();     // Catch: Throwable -> L50
            if (r7 == null) goto L40;
            r5.write(r7.b());     // Catch: Throwable -> L50
            goto L40
        L44:
            r4 = r5.toByteArray();     // Catch: Throwable -> L50
            r5.close();     // Catch: Throwable -> L47
        L60:
            a1.c(this.f7116g, r4);     // Catch: Throwable -> L72
            monitor-exit(a1.class);     // Catch: Throwable -> L72
            return;
        L47:
            th = th;
        L48:
            th.printStackTrace();     // Catch: Throwable -> L72
        L50:
            Throwable th = th;
        L111:
            v.m(th, "stm", "aStB");     // Catch: Throwable -> L63
            if (r5 == null) goto L60;
            r5.close();     // Catch: Throwable -> L58
        L58:
            th = th;
            goto L48
        L63:
            th = move-exception;
            if (r5 != null) goto L100;
        L69:
            throw th;     // Catch: Throwable -> L72
        L100:
            r5.close();     // Catch: Throwable -> L67
        L67:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L72
        L52:
            th = move-exception;
            r5 = null;
            th = th;
        L75:
            th = th;
            r0 = "stm";
            r2 = "apb";
            goto L26
        L78:
            if (r1 != 3) goto L120;
        L93:
            th = move-exception;
            v.m(th, "stm", "usd");
            return;
        L80:
            if (this.f7116g != null) goto L82;
            return;
        L82:
            v0 r8 = b1.a(a1.a());     // Catch: Throwable -> L93
            b1.e(this.f7116g, r8, t.f7784e, 1000, 307200, "2");     // Catch: Throwable -> L93
            if (r8.f7886g != null) goto L85;
            r8.f7886g = new c1(new g1(this.f7116g, new d1(new h1(new j1()))));     // Catch: Throwable -> L93
        L85:
            r8.f7887h = 3600000;     // Catch: Throwable -> L93
            if (TextUtils.isEmpty(r8.f7888i) == false) goto L89;
            r8.f7888i = "cKey";     // Catch: Throwable -> L93
        L89:
            if (r8.f7885f != null) goto L91;
            Context r16 = this.f7116g;     // Catch: Throwable -> L93
            r8.f7885f = new n1(r16, r8.f7887h, r8.f7888i, new k1(r8.f7880a, new l1(r16, a1.f7109a, a1.g() * 1024, a1.f7110b * 1024, "staticUpdate", a1.i() * 1024)));     // Catch: Throwable -> L93
        L91:
            w0.a(r8);     // Catch: Throwable -> L93
            return;
        }
    }

    static {
    }

    public a1() {
    }

    static /* synthetic */ WeakReference a() {
        return f7112d;
    }

    public static void b(Context r3) {
        r1.f().d(new a(r3, a.m));
    }

    static /* synthetic */ void c(Context r7, byte[] r8) {
        v0 r0 = b1.a(f7112d);
        b1.e(r7, r0, t.f7784e, 1000, 307200, "2");
        if (r0.f7884e != null) goto L11;
        r0.f7884e = new e0();
    L11:
        w0.c(Integer.toString(new Random().nextInt(100)) + Long.toString(System.nanoTime()), r8, r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        v.m(th, "stm", "wts");
    }

    public static synchronized void d(z0 r4, Context r5) {
        monitor-enter(a1.class);
        r1.f().d(new a(r5, a.f7114k, r4));     // Catch: Throwable -> L7
        monitor-exit(a1.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void e(List<z0> r4, Context r5) {
        monitor-enter(a1.class);
        if (r4 != null) goto L15;
    L13:
        monitor-exit(a1.class);
        return;
    L15:
        if (r4.size() == 0) goto L13;
        r1.f().d(new a(r5, a.f7115l, r4));     // Catch: Throwable -> L11
        monitor-exit(a1.class);
        return;
    }

    public static synchronized void f(boolean r1, int r2) {
        monitor-enter(a1.class);
        f7109a = r1;     // Catch: Throwable -> L7
        f7113e = Math.max(0, r2);     // Catch: Throwable -> L7
        monitor-exit(a1.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ int g() {
        return f7111c;
    }

    public static synchronized void h(List<z0> r3, Context r4) {
        monitor-enter(a1.class);
        List<z0> r1 = q0.q();     // Catch: Throwable -> L15
        if (r1 == null) goto L18;
        if (r1.size() <= 0) goto L18;
        r3.addAll(r1);     // Catch: Throwable -> L15
    L18:
        e(r3, r4);     // Catch: Throwable -> L12
        monitor-exit(a1.class);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ int i() {
        return f7113e;
    }
}
