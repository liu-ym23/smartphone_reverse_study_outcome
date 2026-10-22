package d.b.b.o.m;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static d.b.b.o.m.a f13057a;

    public static class a implements d.b.b.o.m.a {
        public a() {
        }

        @Override // d.b.b.o.m.a
        public void a(String r1, String r2) {
            if (d.b.b.o.a.c() == false) goto L6;
            Log.d(r1, r2);
            return;
        }

        @Override // d.b.b.o.m.a
        public void b(String r1, String r2) {
            if (d.b.b.o.a.c() == false) goto L6;
            Log.i(r1, r2);
            return;
        }

        @Override // d.b.b.o.m.a
        public void c(String r1, String r2) {
            if (d.b.b.o.a.c() == false) goto L6;
            Log.e(r1, r2);
            return;
        }

        @Override // d.b.b.o.m.a
        public void d(String r1, String r2) {
            if (d.b.b.o.a.c() == false) goto L6;
            Log.w(r1, r2);
            return;
        }

        @Override // d.b.b.o.m.a
        public void e(String r1, String r2, Throwable r3) {
            if (d.b.b.o.a.c() == false) goto L6;
            Log.e(r1, r2, r3);
            return;
        }

        @Override // d.b.b.o.m.a
        public void w(String r1, String r2, Throwable r3) {
            if (d.b.b.o.a.c() == false) goto L6;
            Log.w(r1, r2, r3);
            return;
        }
    }

    static {
        f13057a = new a();
    }

    public static void a(String r1, String r2) {
        d.b.b.o.m.a r0 = f13057a;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    public static void b(String r1, String r2) {
        d.b.b.o.m.a r0 = f13057a;
        if (r0 == null) goto L6;
        r0.c(r1, r2);
        return;
    }

    public static void c(String r1, String r2, Throwable r3) {
        d.b.b.o.m.a r0 = f13057a;
        if (r0 == null) goto L6;
        r0.e(r1, r2, r3);
        return;
    }

    public static void d(String r1, String r2) {
        d.b.b.o.m.a r0 = f13057a;
        if (r0 == null) goto L6;
        r0.b(r1, r2);
        return;
    }

    public static void e(d.b.b.o.m.a r0) {
        f13057a = r0;
    }

    public static void f(String r1, String r2) {
        d.b.b.o.m.a r0 = f13057a;
        if (r0 == null) goto L6;
        r0.d(r1, r2);
        return;
    }

    public static void g(String r1, String r2, Throwable r3) {
        d.b.b.o.m.a r0 = f13057a;
        if (r0 == null) goto L6;
        r0.w(r1, r2, r3);
        return;
    }
}
