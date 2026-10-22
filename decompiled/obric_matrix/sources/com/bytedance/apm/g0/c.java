package com.bytedance.apm.g0;

import androidx.annotation.RequiresApi;
import com.bytedance.apm.block.evil.EvilMethodSwitcher;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static f f1542a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f1543b = false;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f1545b;

        /* JADX INFO: renamed from: com.bytedance.apm.g0.c$a$a, reason: collision with other inner class name */
        public static class C0046a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f1546a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private boolean f1547b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private boolean f1548c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private boolean f1549d;

            public C0046a() {
            }

            static /* synthetic */ boolean a(C0046a r0) {
                return r0.f1546a;
            }

            static /* synthetic */ boolean b(C0046a r0) {
                return r0.f1547b;
            }

            static /* synthetic */ boolean c(C0046a r0) {
                return r0.f1548c;
            }

            static /* synthetic */ boolean d(C0046a r0) {
                return r0.f1549d;
            }

            public a e() {
                return new a(this, null);
            }
        }

        private a(C0046a r2) {
            C0046a.a(r2);
            this.f1544a = C0046a.b(r2);
            this.f1545b = C0046a.c(r2);
            C0046a.d(r2);
        }

        /* synthetic */ a(C0046a r1, b r2) {
            this(r1);
        }

        public boolean a() {
            return this.f1545b;
        }

        public boolean b() {
            return this.f1544a;
        }
    }

    static {
    }

    public static void a() {
        if (f1543b == false) goto L5;
        com.bytedance.apm.v.g.b.c();
    L5:
        f r0 = f1542a;
        if (r0 == null) goto L9;
        r0.d();
        f1542a = null;
        return;
    }

    public static void b(String r1, String r2) {
        f r0 = f1542a;
        if (r0 == null) goto L6;
        r0.e(r1, r2);
        return;
    }

    public static void c(int r6, String r7, long r8) {
        d(r6, r7, r8, 0);
    }

    public static void d(int r8, String r9, long r10, long r12) {
        if (f1543b == false) goto L5;
        com.bytedance.apm.v.g.b.c();
    L5:
        f r1 = f1542a;
        if (r1 == null) goto L9;
        r1.f(r8, r9, r10, r12);
        return;
    }

    public static long e() {
        f r0 = f1542a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.h();
    }

    @Deprecated
    public static void f(int r1) {
        boolean r0 = true;
        if ((r1 & 1) != 0) goto L5;
    L8:
        com.bytedance.apm.t.c.d.G(r0);
        return;
    L5:
        if (com.bytedance.apm.v.a.b().a().c() == true) goto L8;
        r0 = false;
        goto L8
    }

    @Deprecated
    public static void g(long r0) {
        com.bytedance.apm.t.c.d.H(r0);
    }

    public static void h(String r1, String r2) {
        f r0 = f1542a;
        if (r0 == null) goto L6;
        r0.l(r1, r2);
        return;
    }

    @RequiresApi(api = 18)
    public static void i() {
        f r0 = new f("start_trace", "launch_stats");
        f1542a = r0;
        r0.n();
        if (com.bytedance.apm.d.H() == false) goto L8;
        boolean r1 = EvilMethodSwitcher.isOpenLaunchEvilMethod();
        f1543b = r1;
        if (r1 == false) goto L9;
        com.bytedance.apm.v.g.b.b();
        return;
    L9:
        return;
    }
}
