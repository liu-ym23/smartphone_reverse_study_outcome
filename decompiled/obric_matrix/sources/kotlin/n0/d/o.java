package kotlin.n0.d;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class o {
    private o() {
    }

    public static boolean a(Object r0, Object r1) {
        if (r0 != null) goto L7;
        if (r1 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r0.equals(r1);
    }

    public static void b(Object r1, String r2) {
        if (r1 == null) goto L4;
        return;
    L4:
        IllegalStateException r3 = new IllegalStateException(r2 + " must not be null");
        k(r3);
        throw r3;
    }

    public static void c(Object r0) {
        if (r0 == null) goto L4;
        return;
    L4:
        n();
        throw null;
    }

    public static void d(Object r0, String r1) {
        if (r0 == null) goto L4;
        return;
    L4:
        o(r1);
        throw null;
    }

    public static void e(Object r1, String r2) {
        if (r1 == null) goto L4;
        return;
    L4:
        NullPointerException r3 = new NullPointerException(r2 + " must not be null");
        k(r3);
        throw r3;
    }

    public static void f(Object r0, String r1) {
        if (r0 == null) goto L4;
        return;
    L4:
        r(r1);
        throw null;
    }

    public static void g(Object r0, String r1) {
        if (r0 == null) goto L4;
        return;
    L4:
        q(r1);
        throw null;
    }

    public static int h(int r0, int r1) {
        if (r0 >= r1) goto L4;
        return -1;
    L4:
        if (r0 != r1) goto L6;
        return 0;
    L6:
        return 1;
    }

    private static String i(String r4) {
        StackTraceElement r0 = Thread.currentThread().getStackTrace()[4];
        return "Parameter specified as non-null is null: method " + r0.getClassName() + "." + r0.getMethodName() + ", parameter " + r4;
    }

    public static void j(int r0, String r1) {
        s();
        throw null;
    }

    private static <T extends Throwable> T k(T r1) {
        l(r1, o.class.getName());
        return r1;
    }

    static <T extends Throwable> T l(T r5, String r6) {
        StackTraceElement[] r0 = r5.getStackTrace();
        int r1 = r0.length;
        int r2 = -1;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        if (r6.equals(r0[r3].getClassName()) == false) goto L7;
        r2 = r3;
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        r5.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(r0, r2 + 1, r1));
        return r5;
    }

    public static String m(String r1, Object r2) {
        return r1 + r2;
    }

    public static void n() {
        NullPointerException r0 = new NullPointerException();
        k(r0);
        throw r0;
    }

    public static void o(String r1) {
        NullPointerException r0 = new NullPointerException(r1);
        k(r0);
        throw r0;
    }

    public static void p() {
        kotlin.e r0 = new kotlin.e();
        k(r0);
        throw r0;
    }

    private static void q(String r1) {
        IllegalArgumentException r0 = new IllegalArgumentException(i(r1));
        k(r0);
        throw r0;
    }

    private static void r(String r1) {
        NullPointerException r0 = new NullPointerException(i(r1));
        k(r0);
        throw r0;
    }

    public static void s() {
        t("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
        throw null;
    }

    public static void t(String r1) {
        throw new UnsupportedOperationException(r1);
    }

    public static void u(String r1) {
        kotlin.e0 r0 = new kotlin.e0(r1);
        k(r0);
        throw r0;
    }

    public static void v(String r2) {
        u("lateinit property " + r2 + " has not been initialized");
        throw null;
    }
}
