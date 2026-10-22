package d.b.a.a.a.b;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f12546a = 4;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static c f12547b;

    /* JADX INFO: renamed from: d.b.a.a.a.b.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0322a {
    }

    private static final class b extends c {

        /* JADX INFO: renamed from: d.b.a.a.a.b.a$b$a, reason: collision with other inner class name */
        private static class C0323a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final b f12548a = null;

            static {
                f12548a = new b(null);
            }

            static /* synthetic */ b a() {
                return f12548a;
            }
        }

        private b() {
        }

        /* synthetic */ b(C0322a r1) {
            this();
        }

        static b m() {
            return C0323a.a();
        }

        @Override // d.b.a.a.a.b.a.c
        public void b(String r1, String r2) {
            Log.d(r1, r2);
        }

        @Override // d.b.a.a.a.b.a.c
        public void c(String r1, String r2, Throwable r3) {
            Log.d(r1, r2, r3);
        }

        @Override // d.b.a.a.a.b.a.c
        public void d(String r1, String r2) {
            Log.e(r1, r2);
        }

        @Override // d.b.a.a.a.b.a.c
        public void e(String r1, String r2, Throwable r3) {
            Log.e(r1, r2, r3);
        }

        @Override // d.b.a.a.a.b.a.c
        public void f(String r1, String r2) {
            Log.i(r1, r2);
        }

        @Override // d.b.a.a.a.b.a.c
        public void g(String r1, String r2, Throwable r3) {
            Log.i(r1, r2, r3);
        }

        @Override // d.b.a.a.a.b.a.c
        public void i(String r1, String r2) {
            Log.v(r1, r2);
        }

        @Override // d.b.a.a.a.b.a.c
        public void j(String r1, String r2, Throwable r3) {
            Log.v(r1, r2, r3);
        }

        @Override // d.b.a.a.a.b.a.c
        public void k(String r1, String r2) {
            Log.w(r1, r2);
        }

        @Override // d.b.a.a.a.b.a.c
        public void l(String r1, String r2, Throwable r3) {
            Log.w(r1, r2, r3);
        }
    }

    public static abstract class c {
        public c() {
        }

        public boolean a(int r1) {
            if (a.i() > r1) goto L5;
            return true;
        L5:
            return false;
        }

        public abstract void b(String r1, String r2);

        public abstract void c(String r1, String r2, Throwable r3);

        public abstract void d(String r1, String r2);

        public abstract void e(String r1, String r2, Throwable r3);

        public abstract void f(String r1, String r2);

        public abstract void g(String r1, String r2, Throwable r3);

        public void h(String r1, String r2) {
        }

        public abstract void i(String r1, String r2);

        public abstract void j(String r1, String r2, Throwable r3);

        public abstract void k(String r1, String r2);

        public abstract void l(String r1, String r2, Throwable r3);
    }

    static {
        f12547b = b.m();
    }

    public static void a(String r1) {
        if (e() == false) goto L6;
        f(Log.getStackTraceString(new IllegalStateException(r1)));
        return;
    }

    public static void b(String r1) {
        c("Logger", r1);
    }

    public static void c(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (f12547b.a(3) == false) goto L8;
        f12547b.b(r2, r3);
        return;
    }

    public static void d(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (f12547b.a(3) == false) goto L9;
        f12547b.c(r2, r3, r4);
        return;
    }

    public static boolean e() {
        if (f12546a > 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static void f(String r1) {
        g("Logger", r1);
    }

    public static void g(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (f12547b.a(6) == false) goto L8;
        f12547b.d(r2, r3);
        return;
    }

    public static void h(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (f12547b.a(6) == false) goto L9;
        f12547b.e(r2, r3, r4);
        return;
    }

    public static int i() {
        return f12546a;
    }

    private static String j(String r1) {
        int r0 = r1.lastIndexOf(46);
        if (r0 >= 0) goto L6;
        return r1;
    L6:
        return r1.substring(r0 + 1);
    }

    public static void k(String r1) {
        l("Logger", r1);
    }

    public static void l(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (f12547b.a(4) == false) goto L8;
        f12547b.f(r2, r3);
        return;
    }

    public static void m(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (f12547b.a(4) == false) goto L9;
        f12547b.g(r2, r3, r4);
        return;
    }

    @Deprecated
    public static void n(String r1) {
        o("Logger", r1);
    }

    @Deprecated
    public static void o(String r2, String r3) {
        if (f12547b.a(3) == false) goto L6;
        f12547b.h(r2, r3);
        return;
    }

    public static void p(c r0) {
        f12547b = r0;
    }

    public static void q(int r0) {
        f12546a = r0;
    }

    public static void r(String r5, int r6) {
    L4:
        e = move-exception;
        StackTraceElement[] r0 = e.getStackTrace();
        StringBuilder r1 = new StringBuilder();
        int r3 = 1;
    L7:
        if (r3 >= Math.min(r6, r0.length)) goto L11;
        if (r3 <= 1) goto L10;
        r1.append("\n");
    L10:
        r1.append(j(r0[r3].getClassName()));
        r1.append(".");
        r1.append(r0[r3].getMethodName());
        r3 = r3 + 1;
        goto L7
    L11:
        u(r5, r1.toString());
        return;
    L3:
        throw new Exception();     // Catch: Exception -> L4
    }

    public static void s(Throwable r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        r2.printStackTrace();
        if (e() == false) goto L8;
        f(Log.getStackTraceString(new RuntimeException("Error! Now in debug, we alert to you to correct it !", r2)));
        return;
    }

    public static void t(String r1) {
        u("Logger", r1);
    }

    public static void u(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (f12547b.a(2) == false) goto L8;
        f12547b.i(r2, r3);
        return;
    }

    public static void v(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (f12547b.a(2) == false) goto L9;
        f12547b.j(r2, r3, r4);
        return;
    }

    public static void w(String r1) {
        x("Logger", r1);
    }

    public static void x(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (f12547b.a(5) == false) goto L8;
        f12547b.k(r2, r3);
        return;
    }

    public static void y(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (f12547b.a(5) == false) goto L9;
        f12547b.l(r2, r3, r4);
        return;
    }
}
