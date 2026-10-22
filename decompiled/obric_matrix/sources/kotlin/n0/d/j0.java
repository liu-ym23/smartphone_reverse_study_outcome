package kotlin.n0.d;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class j0 {
    public j0() {
    }

    public static Collection a(Object r1) {
        if ((r1 instanceof kotlin.n0.d.l0.a) == false) goto L10;
        if ((r1 instanceof kotlin.n0.d.l0.b) == true) goto L10;
        p(r1, "kotlin.collections.MutableCollection");
        throw null;
    L10:
        return f(r1);
    }

    public static List b(Object r1) {
        if ((r1 instanceof kotlin.n0.d.l0.a) == false) goto L10;
        if ((r1 instanceof kotlin.n0.d.l0.c) == true) goto L10;
        p(r1, "kotlin.collections.MutableList");
        throw null;
    L10:
        return g(r1);
    }

    public static Map c(Object r1) {
        if ((r1 instanceof kotlin.n0.d.l0.a) == false) goto L10;
        if ((r1 instanceof kotlin.n0.d.l0.d) == true) goto L10;
        p(r1, "kotlin.collections.MutableMap");
        throw null;
    L10:
        return h(r1);
    }

    public static Set d(Object r1) {
        if ((r1 instanceof kotlin.n0.d.l0.a) == false) goto L10;
        if ((r1 instanceof kotlin.n0.d.l0.e) == true) goto L10;
        p(r1, "kotlin.collections.MutableSet");
        throw null;
    L10:
        return i(r1);
    }

    public static Object e(Object r2, int r3) {
        if (r2 != null) goto L4;
    L8:
        return r2;
    L4:
        if (k(r2, r3) == true) goto L8;
        p(r2, "kotlin.jvm.functions.Function" + r3);
        throw null;
    }

    public static Collection f(Object r0) {
        return (Collection) r0;
    L4:
        e = move-exception;
        o(e);
        throw null;
    }

    public static List g(Object r0) {
        return (List) r0;
    L4:
        e = move-exception;
        o(e);
        throw null;
    }

    public static Map h(Object r0) {
        return (Map) r0;
    L4:
        e = move-exception;
        o(e);
        throw null;
    }

    public static Set i(Object r0) {
        return (Set) r0;
    L4:
        e = move-exception;
        o(e);
        throw null;
    }

    public static int j(Object r1) {
        if ((r1 instanceof k) == false) goto L7;
        return ((k) r1).getArity();
    L7:
        if ((r1 instanceof kotlin.n0.c.a) == false) goto L11;
        return 0;
    L11:
        if ((r1 instanceof kotlin.n0.c.l) == false) goto L15;
        return 1;
    L15:
        if ((r1 instanceof kotlin.n0.c.p) == false) goto L19;
        return 2;
    L19:
        if ((r1 instanceof kotlin.n0.c.q) == false) goto L23;
        return 3;
    L23:
        if ((r1 instanceof kotlin.n0.c.r) == false) goto L27;
        return 4;
    L27:
        if ((r1 instanceof kotlin.n0.c.s) == false) goto L31;
        return 5;
    L31:
        if ((r1 instanceof kotlin.n0.c.t) == false) goto L35;
        return 6;
    L35:
        if ((r1 instanceof kotlin.n0.c.u) == false) goto L39;
        return 7;
    L39:
        if ((r1 instanceof kotlin.n0.c.v) == false) goto L43;
        return 8;
    L43:
        if ((r1 instanceof kotlin.n0.c.w) == false) goto L47;
        return 9;
    L47:
        if ((r1 instanceof kotlin.n0.c.b) == false) goto L51;
        return 10;
    L51:
        if ((r1 instanceof kotlin.n0.c.c) == false) goto L55;
        return 11;
    L55:
        if ((r1 instanceof kotlin.n0.c.d) == false) goto L59;
        return 12;
    L59:
        if ((r1 instanceof kotlin.n0.c.e) == false) goto L63;
        return 13;
    L63:
        if ((r1 instanceof kotlin.n0.c.f) == false) goto L67;
        return 14;
    L67:
        if ((r1 instanceof kotlin.n0.c.g) == false) goto L71;
        return 15;
    L71:
        if ((r1 instanceof kotlin.n0.c.h) == false) goto L75;
        return 16;
    L75:
        if ((r1 instanceof kotlin.n0.c.i) == false) goto L79;
        return 17;
    L79:
        if ((r1 instanceof kotlin.n0.c.j) == false) goto L83;
        return 18;
    L83:
        if ((r1 instanceof kotlin.n0.c.k) == false) goto L87;
        return 19;
    L87:
        if ((r1 instanceof kotlin.n0.c.m) == false) goto L91;
        return 20;
    L91:
        if ((r1 instanceof kotlin.n0.c.n) == false) goto L95;
        return 21;
    L95:
        if ((r1 instanceof kotlin.n0.c.o) == false) goto L98;
        return 22;
    L98:
        return -1;
    }

    public static boolean k(Object r1, int r2) {
        if ((r1 instanceof kotlin.c) == true) goto L5;
    L7:
        return false;
    L5:
        if (j(r1) != r2) goto L7;
        return true;
    }

    public static boolean l(Object r1) {
        if ((r1 instanceof List) == true) goto L5;
    L9:
        return false;
    L5:
        if ((r1 instanceof kotlin.n0.d.l0.a) == true) goto L7;
    L8:
        return true;
    L7:
        if ((r1 instanceof kotlin.n0.d.l0.c) == false) goto L9;
        goto L8
    }

    public static boolean m(Object r1) {
        if ((r1 instanceof Map) == true) goto L5;
    L9:
        return false;
    L5:
        if ((r1 instanceof kotlin.n0.d.l0.a) == true) goto L7;
    L8:
        return true;
    L7:
        if ((r1 instanceof kotlin.n0.d.l0.d) == false) goto L9;
        goto L8
    }

    private static <T extends Throwable> T n(T r1) {
        o.l(r1, j0.class.getName());
        return r1;
    }

    public static ClassCastException o(ClassCastException r0) {
        n(r0);
        throw r0;
    }

    public static void p(Object r1, String r2) {
        if (r1 != null) goto L4;
        String r3 = "null";
    L5:
        q(r3 + " cannot be cast to " + r2);
        throw null;
    L4:
        r3 = r1.getClass().getName();
        goto L5
    }

    public static void q(String r1) {
        o(new ClassCastException(r1));
        throw null;
    }
}
