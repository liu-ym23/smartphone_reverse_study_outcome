package d.c.c.e;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f15387a;

    static {
        f15387a = b.i();
    }

    public static void A(Class<?> r2, String r3, Object... r4) {
        if (f15387a.g(5) == false) goto L6;
        f15387a.d(o(r2), n(r3, r4));
        return;
    }

    public static void B(Class<?> r1, Throwable r2, String r3, Object... r4) {
        if (p(5) == false) goto L6;
        z(r1, n(r3, r4), r2);
        return;
    }

    public static void C(String r2, String r3, Object... r4) {
        if (f15387a.g(5) == false) goto L6;
        f15387a.d(r2, n(r3, r4));
        return;
    }

    public static void D(String r2, Throwable r3, String r4, Object... r5) {
        if (f15387a.g(5) == false) goto L6;
        f15387a.w(r2, n(r4, r5), r3);
        return;
    }

    public static void E(Class<?> r2, String r3, Throwable r4) {
        if (f15387a.g(6) == false) goto L6;
        f15387a.b(o(r2), r3, r4);
        return;
    }

    public static void F(String r2, String r3) {
        if (f15387a.g(6) == false) goto L6;
        f15387a.f(r2, r3);
        return;
    }

    public static void G(String r2, String r3, Object... r4) {
        if (f15387a.g(6) == false) goto L6;
        f15387a.f(r2, n(r3, r4));
        return;
    }

    public static void a(Class<?> r3, String r4, Object r5) {
        if (f15387a.g(3) == false) goto L6;
        f15387a.a(o(r3), n(r4, new Object[]{r5}));
        return;
    }

    public static void b(Class<?> r3, String r4, Object r5, Object r6, Object r7) {
        if (f15387a.g(3) == false) goto L6;
        f15387a.a(o(r3), n(r4, new Object[]{r5, r6, r7}));
        return;
    }

    public static void c(String r2, String r3) {
        if (f15387a.g(3) == false) goto L6;
        f15387a.a(r2, r3);
        return;
    }

    public static void d(String r3, String r4, Object r5, Object r6) {
        if (f15387a.g(3) == false) goto L6;
        f15387a.a(r3, n(r4, new Object[]{r5, r6}));
        return;
    }

    public static void e(String r2, String r3, Throwable r4) {
        if (f15387a.g(3) == false) goto L6;
        f15387a.d(r2, r3, r4);
        return;
    }

    public static void f(Class<?> r2, String r3) {
        if (f15387a.g(6) == false) goto L6;
        f15387a.c(o(r2), r3);
        return;
    }

    public static void g(Class<?> r2, String r3, Throwable r4) {
        if (f15387a.g(6) == false) goto L6;
        f15387a.e(o(r2), r3, r4);
        return;
    }

    public static void h(Class<?> r2, String r3, Object... r4) {
        if (f15387a.g(6) == false) goto L6;
        f15387a.c(o(r2), n(r3, r4));
        return;
    }

    public static void i(Class<?> r2, Throwable r3, String r4, Object... r5) {
        if (f15387a.g(6) == false) goto L6;
        f15387a.e(o(r2), n(r4, r5), r3);
        return;
    }

    public static void j(String r2, String r3) {
        if (f15387a.g(6) == false) goto L6;
        f15387a.c(r2, r3);
        return;
    }

    public static void k(String r2, String r3, Throwable r4) {
        if (f15387a.g(6) == false) goto L6;
        f15387a.e(r2, r3, r4);
        return;
    }

    public static void l(String r2, String r3, Object... r4) {
        if (f15387a.g(6) == false) goto L6;
        f15387a.c(r2, n(r3, r4));
        return;
    }

    public static void m(String r2, Throwable r3, String r4, Object... r5) {
        if (f15387a.g(6) == false) goto L6;
        f15387a.e(r2, n(r4, r5), r3);
        return;
    }

    private static String n(String r1, Object... r2) {
        return String.format(null, r1, r2);
    }

    private static String o(Class<?> r0) {
        return r0.getSimpleName();
    }

    public static boolean p(int r1) {
        return f15387a.g(r1);
    }

    public static void q(int r1) {
        f15387a.h(r1);
    }

    public static void r(Class<?> r2, String r3) {
        if (f15387a.g(2) == false) goto L6;
        f15387a.e(o(r2), r3);
        return;
    }

    public static void s(Class<?> r3, String r4, Object r5) {
        if (f15387a.g(2) == false) goto L6;
        f15387a.e(o(r3), n(r4, new Object[]{r5}));
        return;
    }

    public static void t(Class<?> r3, String r4, Object r5, Object r6) {
        if (f15387a.g(2) == false) goto L6;
        f15387a.e(o(r3), n(r4, new Object[]{r5, r6}));
        return;
    }

    public static void u(Class<?> r3, String r4, Object r5, Object r6, Object r7) {
        if (p(2) == false) goto L6;
        r(r3, n(r4, new Object[]{r5, r6, r7}));
        return;
    }

    public static void v(Class<?> r4, String r5, Object r6, Object r7, Object r8, Object r9) {
        if (f15387a.g(2) == false) goto L6;
        f15387a.e(o(r4), n(r5, new Object[]{r6, r7, r8, r9}));
        return;
    }

    public static void w(Class<?> r2, String r3, Object... r4) {
        if (f15387a.g(2) == false) goto L6;
        f15387a.e(o(r2), n(r3, r4));
        return;
    }

    public static void x(String r2, String r3, Object... r4) {
        if (f15387a.g(2) == false) goto L6;
        f15387a.e(r2, n(r3, r4));
        return;
    }

    public static void y(Class<?> r2, String r3) {
        if (f15387a.g(5) == false) goto L6;
        f15387a.d(o(r2), r3);
        return;
    }

    public static void z(Class<?> r2, String r3, Throwable r4) {
        if (f15387a.g(5) == false) goto L6;
        f15387a.w(o(r2), r3, r4);
        return;
    }
}
