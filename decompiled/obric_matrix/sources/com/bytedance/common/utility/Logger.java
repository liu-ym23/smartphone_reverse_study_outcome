package com.bytedance.common.utility;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class Logger {
    private static final String TAG = "Logger";
    private static int mLevel = 4;
    private static c sLogWriter;

    static /* synthetic */ class a {
    }

    private static final class b extends c {

        private static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final b f3260a = null;

            static {
                f3260a = new b(null);
            }

            static /* synthetic */ b a() {
                return f3260a;
            }
        }

        private b() {
        }

        /* synthetic */ b(a r1) {
            this();
        }

        static b m() {
            return a.a();
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

    public static abstract class c extends d.b.a.a.a.b.a.c {
        public c() {
        }

        @Override // d.b.a.a.a.b.a.c
        public boolean a(int r1) {
            if (Logger.getLogLevel() > r1) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // d.b.a.a.a.b.a.c
        public void h(String r1, String r2) {
        }
    }

    static {
        sLogWriter = b.m();
    }

    public Logger() {
    }

    public static void alertErrorInfo(String r0) {
        d.b.a.a.a.b.a.a(r0);
    }

    public static void d(String r0) {
        d.b.a.a.a.b.a.b(r0);
    }

    public static void d(String r0, String r1) {
        d.b.a.a.a.b.a.c(r0, r1);
    }

    public static void d(String r0, String r1, Throwable r2) {
        d.b.a.a.a.b.a.d(r0, r1, r2);
    }

    public static boolean debug() {
        return d.b.a.a.a.b.a.e();
    }

    public static void e(String r0) {
        d.b.a.a.a.b.a.f(r0);
    }

    public static void e(String r0, String r1) {
        d.b.a.a.a.b.a.g(r0, r1);
    }

    public static void e(String r0, String r1, Throwable r2) {
        d.b.a.a.a.b.a.h(r0, r1, r2);
    }

    public static int getLogLevel() {
        return d.b.a.a.a.b.a.i();
    }

    private static String getSimpleClassName(String r1) {
        int r0 = r1.lastIndexOf(46);
        if (r0 >= 0) goto L6;
        return r1;
    L6:
        return r1.substring(r0 + 1);
    }

    public static void i(String r0) {
        d.b.a.a.a.b.a.k(r0);
    }

    public static void i(String r0, String r1) {
        d.b.a.a.a.b.a.l(r0, r1);
    }

    public static void i(String r0, String r1, Throwable r2) {
        d.b.a.a.a.b.a.m(r0, r1, r2);
    }

    @Deprecated
    public static void k(String r0) {
        d.b.a.a.a.b.a.n(r0);
    }

    @Deprecated
    public static void k(String r0, String r1) {
        d.b.a.a.a.b.a.o(r0, r1);
    }

    public static void registerLogHandler(c r0) {
        d.b.a.a.a.b.a.p(r0);
    }

    public static void setLogLevel(int r0) {
        d.b.a.a.a.b.a.q(r0);
    }

    public static void st(String r0, int r1) {
        d.b.a.a.a.b.a.r(r0, r1);
    }

    public static void throwException(Throwable r0) {
        d.b.a.a.a.b.a.s(r0);
    }

    public static void v(String r0) {
        d.b.a.a.a.b.a.t(r0);
    }

    public static void v(String r0, String r1) {
        d.b.a.a.a.b.a.u(r0, r1);
    }

    public static void v(String r0, String r1, Throwable r2) {
        d.b.a.a.a.b.a.v(r0, r1, r2);
    }

    public static void w(String r0) {
        d.b.a.a.a.b.a.w(r0);
    }

    public static void w(String r0, String r1) {
        d.b.a.a.a.b.a.x(r0, r1);
    }

    public static void w(String r0, String r1, Throwable r2) {
        d.b.a.a.a.b.a.y(r0, r1, r2);
    }
}
