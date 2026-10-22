package kotlin.s0.w.d.l0.n.w1;

import java.util.Collection;
import java.util.List;
import kotlin.n0.d.e0;
import kotlin.s0.w.d.l0.n.d1;

/* JADX INFO: loaded from: classes2.dex */
public interface p extends s {

    public static final class a {
        public static List<k> a(p r0, k r1, n r2) {
            kotlin.n0.d.o.f(r1, "$receiver");
            kotlin.n0.d.o.f(r2, "constructor");
            return null;
        }

        public static m b(p r1, l r2, int r3) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof k) == false) goto L6;
            return r1.g0((i) r2, r3);
        L6:
            if ((r2 instanceof kotlin.s0.w.d.l0.n.w1.a) == false) goto L10;
            m r4 = ((kotlin.s0.w.d.l0.n.w1.a) r2).get(r3);
            kotlin.n0.d.o.e(r4, "get(index)");
            return r4;
        L10:
            throw new IllegalStateException(("unknown type argument list type: " + r2 + ", " + e0.b(r2.getClass())).toString());
        }

        public static m c(p r2, k r3, int r4) {
            kotlin.n0.d.o.f(r3, "$receiver");
            boolean r0 = false;
            if (r4 >= 0) goto L5;
        L7:
            if (r0 == true) goto L9;
            return null;
        L9:
            return r2.g0(r3, r4);
        L5:
            if (r4 >= r2.j(r3)) goto L7;
            r0 = true;
            goto L7
        }

        public static boolean d(p r1, i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if (r1.W(r1.h0(r2)) == r1.W(r1.T(r2))) goto L5;
            return true;
        L5:
            return false;
        }

        public static boolean e(p r1, i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            k r3 = r1.a(r2);
            if (r3 == null) goto L5;
            d r4 = r1.f(r3);
        L6:
            if (r4 == null) goto L8;
            return true;
        L8:
            return false;
        L5:
            r4 = null;
            goto L6
        }

        public static boolean f(p r1, k r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            return r1.V(r1.c(r2));
        }

        public static boolean g(p r1, i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            k r3 = r1.a(r2);
            if (r3 == null) goto L5;
            e r4 = r1.s0(r3);
        L6:
            if (r4 == null) goto L8;
            return true;
        L8:
            return false;
        L5:
            r4 = null;
            goto L6
        }

        public static boolean h(p r1, i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            g r3 = r1.M(r2);
            if (r3 == null) goto L5;
            f r4 = r1.y0(r3);
        L6:
            if (r4 == null) goto L8;
            return true;
        L8:
            return false;
        L5:
            r4 = null;
            goto L6
        }

        public static boolean i(p r1, k r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            return r1.q0(r1.c(r2));
        }

        public static boolean j(p r1, i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof k) == true) goto L5;
        L7:
            return false;
        L5:
            if (r1.W((k) r2) == false) goto L7;
            return true;
        }

        public static boolean k(p r1, i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if (r1.p(r1.w(r2)) == true) goto L5;
        L7:
            return false;
        L5:
            if (r1.p0(r2) == true) goto L7;
            return true;
        }

        public static k l(p r1, i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            g r0 = r1.M(r2);
            if (r0 == null) goto L6;
            k r3 = r1.g(r0);
            if (r3 == null) goto L6;
            return r3;
        L6:
            k r4 = r1.a(r2);
            kotlin.n0.d.o.c(r4);
            return r4;
        }

        public static int m(p r2, l r3) {
            kotlin.n0.d.o.f(r3, "$receiver");
            if ((r3 instanceof k) == false) goto L6;
            return r2.j((i) r3);
        L6:
            if ((r3 instanceof kotlin.s0.w.d.l0.n.w1.a) == false) goto L10;
            return ((kotlin.s0.w.d.l0.n.w1.a) r3).size();
        L10:
            throw new IllegalStateException(("unknown type argument list type: " + r3 + ", " + e0.b(r3.getClass())).toString());
        }

        public static n n(p r1, i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            k r0 = r1.a(r2);
            if (r0 != null) goto L6;
            r0 = r1.h0(r2);
        L6:
            return r1.c(r0);
        }

        public static k o(p r1, i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            g r0 = r1.M(r2);
            if (r0 == null) goto L6;
            k r3 = r1.e(r0);
            if (r3 == null) goto L6;
            return r3;
        L6:
            k r4 = r1.a(r2);
            kotlin.n0.d.o.c(r4);
            return r4;
        }
    }

    d1.c A(k r1);

    boolean A0(n r1, n r2);

    boolean B(i r1);

    List<i> B0(o r1);

    boolean C(i r1);

    o D(n r1, int r2);

    m D0(k r1, int r2);

    boolean E0(k r1);

    o F(n r1);

    i G(i r1, boolean r2);

    k H(e r1);

    boolean I(i r1);

    boolean J(k r1);

    boolean L(m r1);

    g M(i r1);

    u N(o r1);

    i O(List<? extends i> r1);

    b P(d r1);

    i Q(i r1);

    int R(l r1);

    m S(c r1);

    k T(i r1);

    i U(d r1);

    boolean V(n r1);

    boolean W(k r1);

    List<m> X(i r1);

    boolean Y(i r1);

    boolean Z(n r1);

    k a(i r1);

    boolean b(k r1);

    n c(k r1);

    m c0(i r1);

    k d(k r1, boolean r2);

    c d0(d r1);

    k e(g r1);

    List<o> e0(n r1);

    d f(k r1);

    boolean f0(i r1);

    k g(g r1);

    m g0(i r1, int r2);

    int h(n r1);

    k h0(i r1);

    int j(i r1);

    u j0(m r1);

    boolean k(d r1);

    boolean k0(n r1);

    o m0(t r1);

    List<k> n(k r1, n r2);

    boolean n0(k r1);

    boolean o(o r1, n r2);

    boolean o0(i r1);

    boolean p(n r1);

    boolean p0(i r1);

    boolean q(d r1);

    boolean q0(n r1);

    l r(k r1);

    k r0(k r1, b r2);

    boolean s(i r1);

    e s0(k r1);

    Collection<i> t(n r1);

    m u(l r1, int r2);

    boolean u0(n r1);

    Collection<i> v(k r1);

    boolean v0(k r1);

    n w(i r1);

    boolean w0(k r1);

    boolean x(n r1);

    i x0(m r1);

    j y(g r1);

    f y0(g r1);

    boolean z(i r1);

    boolean z0(i r1);
}
