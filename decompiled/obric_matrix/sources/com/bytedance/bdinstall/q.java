package com.bytedance.bdinstall;

import com.ss.android.agilelogger.ALog;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f2856a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f2857b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static c0 f2858c;

    class a implements c0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c0 f2859a;

        a() {
            this.f2859a = new b(null);
        }

        @Override // com.bytedance.bdinstall.c0
        public void a(String r1, Throwable r2) {
            this.f2859a.a(r1, r2);
        }

        @Override // com.bytedance.bdinstall.c0
        public void b(String r1, Throwable r2) {
            this.f2859a.b(r1, r2);
        }

        @Override // com.bytedance.bdinstall.c0
        public void c(String r1, Throwable r2) {
            this.f2859a.c(r1, r2);
        }

        @Override // com.bytedance.bdinstall.c0
        public void d(String r1, Throwable r2) {
            this.f2859a.d(r1, r2);
        }

        @Override // com.bytedance.bdinstall.c0
        public void e(String r1, Throwable r2) {
            this.f2859a.e(r1, r2);
        }
    }

    private static class b implements c0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f2860a;

        private b() {
            this.f2860a = true;
        }

        /* synthetic */ b(a r1) {
            this();
        }

        @Override // com.bytedance.bdinstall.c0
        public void a(String r1, Throwable r2) {
            if (this.f2860a == true) goto L9;
            return;
        L9:
            ALog.i("DrLog", r1);     // Catch: Throwable -> L7
            return;
        L7:
            this.f2860a = false;
        }

        @Override // com.bytedance.bdinstall.c0
        public void b(String r1, Throwable r2) {
            if (this.f2860a == true) goto L9;
            return;
        L9:
            ALog.w("DrLog", r1);     // Catch: Throwable -> L7
            return;
        L7:
            this.f2860a = false;
        }

        @Override // com.bytedance.bdinstall.c0
        public void c(String r1, Throwable r2) {
            if (this.f2860a == true) goto L9;
            return;
        L9:
            ALog.i("DrLog", r1);     // Catch: Throwable -> L7
            return;
        L7:
            this.f2860a = false;
        }

        @Override // com.bytedance.bdinstall.c0
        public void d(String r1, Throwable r2) {
            if (this.f2860a == true) goto L9;
            return;
        L9:
            ALog.e("DrLog", r1);     // Catch: Throwable -> L7
            return;
        L7:
            this.f2860a = false;
        }

        @Override // com.bytedance.bdinstall.c0
        public void e(String r1, Throwable r2) {
            if (this.f2860a == true) goto L9;
            return;
        L9:
            ALog.i("DrLog", r1);     // Catch: Throwable -> L7
            return;
        L7:
            this.f2860a = false;
        }
    }

    static {
        f2857b = com.bytedance.bdinstall.d1.h.e();
        f2858c = new a();
    }

    public static void a(String r2) {
        f2858c.a(r2, null);
    }

    public static boolean b() {
        return f2856a;
    }

    public static void c(String r2) {
        f2858c.d(r2, null);
    }

    public static void d(String r1, Throwable r2) {
        f2858c.d(r1, r2);
    }

    public static void e(String r1, Throwable r2) {
        f2858c.e(r1, r2);
    }

    static void f(c0 r0) {
        f2858c = r0;
    }

    public static void g(String r2) {
        f2858c.c(r2, null);
    }

    public static void h(String r1, Throwable r2) {
        f2858c.b(r1, r2);
    }

    public static void i(Throwable r2) {
        f2858c.d(null, r2);
    }
}
