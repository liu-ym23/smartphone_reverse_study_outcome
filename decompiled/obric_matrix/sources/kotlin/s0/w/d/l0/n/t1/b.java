package kotlin.s0.w.d.l0.n.t1;

import com.bytedance.common.wschannel.WsConstants;
import java.util.Collection;
import java.util.List;
import kotlin.s0.w.d.l0.c.f0;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.h1;
import kotlin.s0.w.d.l0.c.z;
import kotlin.s0.w.d.l0.n.d0;
import kotlin.s0.w.d.l0.n.d1;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.e1;
import kotlin.s0.w.d.l0.n.g0;
import kotlin.s0.w.d.l0.n.g1;
import kotlin.s0.w.d.l0.n.j0;
import kotlin.s0.w.d.l0.n.l0;
import kotlin.s0.w.d.l0.n.l1;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.m1;
import kotlin.s0.w.d.l0.n.n1;
import kotlin.s0.w.d.l0.n.p0;
import kotlin.s0.w.d.l0.n.q1;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
public interface b extends m1, kotlin.s0.w.d.l0.n.w1.r {

    public static final class a {

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.n.t1.b$a$a, reason: collision with other inner class name */
        public static final class C0579a extends d1.c.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f21076a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ l1 f21077b;

            C0579a(b r1, l1 r2) {
                this.f21076a = r1;
                this.f21077b = r2;
            }

            @Override // kotlin.s0.w.d.l0.n.d1.c
            public kotlin.s0.w.d.l0.n.w1.k a(d1 r2, kotlin.s0.w.d.l0.n.w1.i r3) {
                kotlin.n0.d.o.f(r2, WsConstants.KEY_CONNECTION_STATE);
                kotlin.n0.d.o.f(r3, WsConstants.KEY_CONNECTION_TYPE);
                b r4 = this.f21076a;
                l1 r1 = this.f21077b;
                kotlin.s0.w.d.l0.n.w1.i r5 = r4.h0(r3);
                kotlin.n0.d.o.d(r5, "null cannot be cast to non-null type org.jetbrains.kotlin.types.KotlinType");
                e0 r6 = r1.n((e0) r5, r1.f21065h);
                kotlin.n0.d.o.e(r6, "substitutor.safeSubstitu…VARIANT\n                )");
                kotlin.s0.w.d.l0.n.w1.k r7 = r4.a(r6);
                kotlin.n0.d.o.c(r7);
                return r7;
            }
        }

        public static kotlin.s0.w.d.l0.n.w1.o A(b r1, kotlin.s0.w.d.l0.n.w1.n r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof e1) == false) goto L10;
            kotlin.s0.w.d.l0.c.h r3 = ((e1) r2).d();
            if ((r3 instanceof f1) == true) goto L11;
            return null;
        L11:
            return (f1) r3;
        L10:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.n.w1.c A0(b r1, kotlin.s0.w.d.l0.n.w1.d r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof i) == false) goto L7;
            return ((i) r2).Y0();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.n.w1.i B(b r1, kotlin.s0.w.d.l0.n.w1.i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof e0) == false) goto L7;
            return kotlin.s0.w.d.l0.k.f.e((e0) r2);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.n.w1.n B0(b r1, kotlin.s0.w.d.l0.n.w1.i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            return kotlin.s0.w.d.l0.n.w1.r.a.n(r1, r2);
        }

        public static List<kotlin.s0.w.d.l0.n.w1.i> C(b r1, kotlin.s0.w.d.l0.n.w1.o r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof f1) == false) goto L7;
            List<e0> r3 = ((f1) r2).getUpperBounds();
            kotlin.n0.d.o.e(r3, "this.upperBounds");
            return r3;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.n.w1.n C0(b r1, kotlin.s0.w.d.l0.n.w1.k r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof m0) == false) goto L7;
            return ((m0) r2).O0();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.n.w1.u D(b r1, kotlin.s0.w.d.l0.n.w1.m r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof g1) == false) goto L7;
            r1 r3 = ((g1) r2).a();
            kotlin.n0.d.o.e(r3, "this.projectionKind");
            return kotlin.s0.w.d.l0.n.w1.q.a(r3);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.n.w1.k D0(b r1, kotlin.s0.w.d.l0.n.w1.g r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof kotlin.s0.w.d.l0.n.y) == false) goto L7;
            return ((kotlin.s0.w.d.l0.n.y) r2).X0();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.n.w1.u E(b r1, kotlin.s0.w.d.l0.n.w1.o r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof f1) == false) goto L7;
            r1 r3 = ((f1) r2).n();
            kotlin.n0.d.o.e(r3, "this.variance");
            return kotlin.s0.w.d.l0.n.w1.q.a(r3);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.n.w1.k E0(b r1, kotlin.s0.w.d.l0.n.w1.i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            return kotlin.s0.w.d.l0.n.w1.r.a.o(r1, r2);
        }

        public static boolean F(b r0, kotlin.s0.w.d.l0.n.w1.i r1, kotlin.s0.w.d.l0.g.c r2) {
            kotlin.n0.d.o.f(r1, "$receiver");
            kotlin.n0.d.o.f(r2, "fqName");
            if ((r1 instanceof e0) == false) goto L7;
            return ((e0) r1).getAnnotations().k(r2);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r1 + ", " + kotlin.n0.d.e0.b(r1.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.n.w1.i F0(b r1, kotlin.s0.w.d.l0.n.w1.i r2, boolean r3) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof kotlin.s0.w.d.l0.n.w1.k) == false) goto L6;
            return r1.d((kotlin.s0.w.d.l0.n.w1.k) r2, r3);
        L6:
            if ((r2 instanceof kotlin.s0.w.d.l0.n.w1.g) == false) goto L10;
            kotlin.s0.w.d.l0.n.w1.g r4 = (kotlin.s0.w.d.l0.n.w1.g) r2;
            return r1.E(r1.d(r1.g(r4), r3), r1.d(r1.e(r4), r3));
        L10:
            throw new IllegalStateException("sealed".toString());
        }

        public static boolean G(b r1, kotlin.s0.w.d.l0.n.w1.i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            return kotlin.s0.w.d.l0.n.w1.r.a.d(r1, r2);
        }

        public static kotlin.s0.w.d.l0.n.w1.k G0(b r0, kotlin.s0.w.d.l0.n.w1.k r1, boolean r2) {
            kotlin.n0.d.o.f(r1, "$receiver");
            if ((r1 instanceof m0) == false) goto L7;
            return ((m0) r1).V0(r2);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r1 + ", " + kotlin.n0.d.e0.b(r1.getClass())).toString());
        }

        public static boolean H(b r2, kotlin.s0.w.d.l0.n.w1.o r3, kotlin.s0.w.d.l0.n.w1.n r4) {
            kotlin.n0.d.o.f(r3, "$receiver");
            if ((r3 instanceof f1) == false) goto L13;
            if (r4 != null) goto L6;
            boolean r5 = true;
        L7:
            if (r5 == false) goto L11;
            return kotlin.s0.w.d.l0.n.x1.a.l((f1) r3, (e1) r4, null, 4, null);
        L11:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r3 + ", " + kotlin.n0.d.e0.b(r3.getClass())).toString());
        L6:
            r5 = r4 instanceof e1;
            goto L7
        L13:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r3 + ", " + kotlin.n0.d.e0.b(r3.getClass())).toString());
        }

        public static boolean I(b r2, kotlin.s0.w.d.l0.n.w1.k r3, kotlin.s0.w.d.l0.n.w1.k r4) {
            kotlin.n0.d.o.f(r3, "a");
            kotlin.n0.d.o.f(r4, "b");
            if ((r3 instanceof m0) == false) goto L14;
            if ((r4 instanceof m0) == false) goto L12;
            if (((m0) r3).M0() != ((m0) r4).M0()) goto L9;
            return true;
        L9:
            return false;
        L12:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r4 + ", " + kotlin.n0.d.e0.b(r4.getClass())).toString());
        L14:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r3 + ", " + kotlin.n0.d.e0.b(r3.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.n.w1.i J(b r0, List<? extends kotlin.s0.w.d.l0.n.w1.i> r1) {
            kotlin.n0.d.o.f(r1, "types");
            return d.a(r1);
        }

        public static boolean K(b r1, kotlin.s0.w.d.l0.n.w1.n r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof e1) == false) goto L7;
            return kotlin.s0.w.d.l0.b.h.v0((e1) r2, kotlin.s0.w.d.l0.b.k.a.f18719b);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static boolean L(b r1, kotlin.s0.w.d.l0.n.w1.i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            return kotlin.s0.w.d.l0.n.w1.r.a.e(r1, r2);
        }

        public static boolean M(b r1, kotlin.s0.w.d.l0.n.w1.k r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            return kotlin.s0.w.d.l0.n.w1.r.a.f(r1, r2);
        }

        public static boolean N(b r1, kotlin.s0.w.d.l0.n.w1.n r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof e1) == false) goto L7;
            return ((e1) r2).d() instanceof kotlin.s0.w.d.l0.c.e;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static boolean O(b r2, kotlin.s0.w.d.l0.n.w1.n r3) {
            kotlin.n0.d.o.f(r3, "$receiver");
            if ((r3 instanceof e1) == false) goto L20;
            kotlin.s0.w.d.l0.c.h r4 = ((e1) r3).d();
            if ((r4 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L7;
            kotlin.s0.w.d.l0.c.e r5 = (kotlin.s0.w.d.l0.c.e) r4;
        L9:
            if (r5 != null) goto L12;
            return false;
        L12:
            if (f0.a(r5) == true) goto L14;
            return false;
        L14:
            if (r5.i() != kotlin.s0.w.d.l0.c.f.f18868i) goto L16;
            return false;
        L16:
            if (r5.i() == kotlin.s0.w.d.l0.c.f.f18869j) goto L23;
            return true;
        L23:
            return false;
        L7:
            r5 = null;
            goto L9
        L20:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r3 + ", " + kotlin.n0.d.e0.b(r3.getClass())).toString());
        }

        public static boolean P(b r1, kotlin.s0.w.d.l0.n.w1.i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            return kotlin.s0.w.d.l0.n.w1.r.a.g(r1, r2);
        }

        public static boolean Q(b r1, kotlin.s0.w.d.l0.n.w1.n r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof e1) == false) goto L7;
            return ((e1) r2).e();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static boolean R(b r1, kotlin.s0.w.d.l0.n.w1.i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            return kotlin.s0.w.d.l0.n.w1.r.a.h(r1, r2);
        }

        public static boolean S(b r1, kotlin.s0.w.d.l0.n.w1.i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof e0) == false) goto L7;
            return g0.a((e0) r2);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static boolean T(b r1, kotlin.s0.w.d.l0.n.w1.n r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof e1) == false) goto L13;
            kotlin.s0.w.d.l0.c.h r3 = ((e1) r2).d();
            h1<m0> r0 = null;
            if ((r3 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L7;
            kotlin.s0.w.d.l0.c.e r4 = (kotlin.s0.w.d.l0.c.e) r3;
        L8:
            if (r4 == null) goto L11;
            r0 = r4.z0();
        L11:
            return r0 instanceof z;
        L7:
            r4 = null;
            goto L8
        L13:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static boolean U(b r1, kotlin.s0.w.d.l0.n.w1.k r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            return kotlin.s0.w.d.l0.n.w1.r.a.i(r1, r2);
        }

        public static boolean V(b r1, kotlin.s0.w.d.l0.n.w1.n r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof e1) == false) goto L7;
            return r2 instanceof kotlin.s0.w.d.l0.k.r.n;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static boolean W(b r1, kotlin.s0.w.d.l0.n.w1.n r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof e1) == false) goto L7;
            return r2 instanceof d0;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static boolean X(b r1, kotlin.s0.w.d.l0.n.w1.i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            return kotlin.s0.w.d.l0.n.w1.r.a.j(r1, r2);
        }

        public static boolean Y(b r1, kotlin.s0.w.d.l0.n.w1.k r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof m0) == false) goto L7;
            return ((m0) r2).P0();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static boolean Z(b r0, kotlin.s0.w.d.l0.n.w1.i r1) {
            kotlin.n0.d.o.f(r1, "$receiver");
            return r1 instanceof j0;
        }

        public static boolean a(b r2, kotlin.s0.w.d.l0.n.w1.n r3, kotlin.s0.w.d.l0.n.w1.n r4) {
            kotlin.n0.d.o.f(r3, "c1");
            kotlin.n0.d.o.f(r4, "c2");
            if ((r3 instanceof e1) == false) goto L11;
            if ((r4 instanceof e1) == false) goto L9;
            return kotlin.n0.d.o.a(r3, r4);
        L9:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r4 + ", " + kotlin.n0.d.e0.b(r4.getClass())).toString());
        L11:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r3 + ", " + kotlin.n0.d.e0.b(r3.getClass())).toString());
        }

        public static boolean a0(b r1, kotlin.s0.w.d.l0.n.w1.i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            return kotlin.s0.w.d.l0.n.w1.r.a.k(r1, r2);
        }

        public static int b(b r1, kotlin.s0.w.d.l0.n.w1.i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof e0) == false) goto L7;
            return ((e0) r2).M0().size();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static boolean b0(b r1, kotlin.s0.w.d.l0.n.w1.n r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof e1) == false) goto L7;
            return kotlin.s0.w.d.l0.b.h.v0((e1) r2, kotlin.s0.w.d.l0.b.k.a.f18720c);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.n.w1.l c(b r1, kotlin.s0.w.d.l0.n.w1.k r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof m0) == false) goto L7;
            return (kotlin.s0.w.d.l0.n.w1.l) r2;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static boolean c0(b r1, kotlin.s0.w.d.l0.n.w1.i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof e0) == false) goto L7;
            return n1.l((e0) r2);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.n.w1.d d(b r1, kotlin.s0.w.d.l0.n.w1.k r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof m0) == false) goto L13;
            if ((r2 instanceof p0) == false) goto L8;
            return r1.f(((p0) r2).a1());
        L8:
            if ((r2 instanceof i) == true) goto L15;
            return null;
        L15:
            return (i) r2;
        L13:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static boolean d0(b r0, kotlin.s0.w.d.l0.n.w1.d r1) {
            kotlin.n0.d.o.f(r1, "$receiver");
            return r1 instanceof kotlin.s0.w.d.l0.k.q.a.a;
        }

        public static kotlin.s0.w.d.l0.n.w1.e e(b r1, kotlin.s0.w.d.l0.n.w1.k r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof m0) == false) goto L10;
            if ((r2 instanceof kotlin.s0.w.d.l0.n.p) == true) goto L11;
            return null;
        L11:
            return (kotlin.s0.w.d.l0.n.p) r2;
        L10:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean e0(b r1, kotlin.s0.w.d.l0.n.w1.k r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof e0) == false) goto L7;
            return kotlin.s0.w.d.l0.b.h.r0((e0) r2);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.n.w1.f f(b r1, kotlin.s0.w.d.l0.n.w1.g r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof kotlin.s0.w.d.l0.n.y) == false) goto L10;
            if ((r2 instanceof kotlin.s0.w.d.l0.n.v) == true) goto L11;
            return null;
        L11:
            return (kotlin.s0.w.d.l0.n.v) r2;
        L10:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static boolean f0(b r1, kotlin.s0.w.d.l0.n.w1.d r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof i) == false) goto L7;
            return ((i) r2).a1();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.n.w1.g g(b r1, kotlin.s0.w.d.l0.n.w1.i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof e0) == false) goto L10;
            q1 r3 = ((e0) r2).R0();
            if ((r3 instanceof kotlin.s0.w.d.l0.n.y) == true) goto L11;
            return null;
        L11:
            return (kotlin.s0.w.d.l0.n.y) r3;
        L10:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean g0(b r2, kotlin.s0.w.d.l0.n.w1.k r3) {
            kotlin.n0.d.o.f(r3, "$receiver");
            if ((r3 instanceof m0) == false) goto L24;
            if (g0.a((e0) r3) == true) goto L21;
            m0 r0 = (m0) r3;
            if ((r0.O0().d() instanceof kotlin.s0.w.d.l0.c.e1) == true) goto L21;
            if (r0.O0().d() == null) goto L11;
        L20:
            return true;
        L11:
            if ((r3 instanceof kotlin.s0.w.d.l0.k.q.a.a) == true) goto L20;
            if ((r3 instanceof i) == true) goto L20;
            if ((r3 instanceof kotlin.s0.w.d.l0.n.p) == true) goto L20;
            if ((r0.O0() instanceof kotlin.s0.w.d.l0.k.r.n) == true) goto L20;
            if (h0(r2, r3) == true) goto L20;
        L21:
            return false;
        L24:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r3 + ", " + kotlin.n0.d.e0.b(r3.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.n.w1.j h(b r1, kotlin.s0.w.d.l0.n.w1.g r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof kotlin.s0.w.d.l0.n.y) == false) goto L10;
            if ((r2 instanceof l0) == true) goto L11;
            return null;
        L11:
            return (l0) r2;
        L10:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        private static boolean h0(b r1, kotlin.s0.w.d.l0.n.w1.k r2) {
            if ((r2 instanceof p0) == true) goto L5;
        L7:
            return false;
        L5:
            if (r1.b(((p0) r2).a1()) == false) goto L7;
            return true;
        }

        public static kotlin.s0.w.d.l0.n.w1.k i(b r1, kotlin.s0.w.d.l0.n.w1.i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof e0) == false) goto L10;
            q1 r3 = ((e0) r2).R0();
            if ((r3 instanceof m0) == true) goto L11;
            return null;
        L11:
            return (m0) r3;
        L10:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static boolean i0(b r1, kotlin.s0.w.d.l0.n.w1.m r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof g1) == false) goto L7;
            return ((g1) r2).d();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.n.w1.m j(b r1, kotlin.s0.w.d.l0.n.w1.i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof e0) == false) goto L7;
            return kotlin.s0.w.d.l0.n.x1.a.a((e0) r2);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean j0(b r1, kotlin.s0.w.d.l0.n.w1.k r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof m0) == false) goto L7;
            return kotlin.s0.w.d.l0.n.x1.a.m((e0) r2);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.n.w1.k k(b r0, kotlin.s0.w.d.l0.n.w1.k r1, kotlin.s0.w.d.l0.n.w1.b r2) {
            kotlin.n0.d.o.f(r1, WsConstants.KEY_CONNECTION_TYPE);
            kotlin.n0.d.o.f(r2, "status");
            if ((r1 instanceof m0) == false) goto L7;
            return k.b((m0) r1, r2);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r1 + ", " + kotlin.n0.d.e0.b(r1.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean k0(b r1, kotlin.s0.w.d.l0.n.w1.k r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof m0) == false) goto L7;
            return kotlin.s0.w.d.l0.n.x1.a.n((e0) r2);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.n.w1.b l(b r1, kotlin.s0.w.d.l0.n.w1.d r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof i) == false) goto L7;
            return ((i) r2).X0();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static boolean l0(b r0, kotlin.s0.w.d.l0.n.w1.i r1) {
            kotlin.n0.d.o.f(r1, "$receiver");
            if ((r1 instanceof q1) == true) goto L5;
        L7:
            return false;
        L5:
            if ((((q1) r1).O0() instanceof n) == false) goto L7;
            return true;
        }

        public static kotlin.s0.w.d.l0.n.w1.i m(b r3, kotlin.s0.w.d.l0.n.w1.k r4, kotlin.s0.w.d.l0.n.w1.k r5) {
            kotlin.n0.d.o.f(r4, "lowerBound");
            kotlin.n0.d.o.f(r5, "upperBound");
            if ((r4 instanceof m0) == false) goto L11;
            if ((r5 instanceof m0) == false) goto L9;
            return kotlin.s0.w.d.l0.n.f0.d((m0) r4, (m0) r5);
        L9:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r3 + ", " + kotlin.n0.d.e0.b(r3.getClass())).toString());
        L11:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r3 + ", " + kotlin.n0.d.e0.b(r3.getClass())).toString());
        }

        public static boolean m0(b r1, kotlin.s0.w.d.l0.n.w1.n r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof e1) == false) goto L12;
            kotlin.s0.w.d.l0.c.h r3 = ((e1) r2).d();
            if (r3 == null) goto L10;
            if (kotlin.s0.w.d.l0.b.h.A0(r3) != true) goto L10;
            return true;
        L10:
            return false;
        L12:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static List<kotlin.s0.w.d.l0.n.w1.k> n(b r1, kotlin.s0.w.d.l0.n.w1.k r2, kotlin.s0.w.d.l0.n.w1.n r3) {
            kotlin.n0.d.o.f(r2, "$receiver");
            kotlin.n0.d.o.f(r3, "constructor");
            return kotlin.s0.w.d.l0.n.w1.r.a.a(r1, r2, r3);
        }

        public static kotlin.s0.w.d.l0.n.w1.k n0(b r1, kotlin.s0.w.d.l0.n.w1.g r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof kotlin.s0.w.d.l0.n.y) == false) goto L7;
            return ((kotlin.s0.w.d.l0.n.y) r2).W0();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.n.w1.m o(b r1, kotlin.s0.w.d.l0.n.w1.l r2, int r3) {
            kotlin.n0.d.o.f(r2, "$receiver");
            return kotlin.s0.w.d.l0.n.w1.r.a.b(r1, r2, r3);
        }

        public static kotlin.s0.w.d.l0.n.w1.k o0(b r1, kotlin.s0.w.d.l0.n.w1.i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            return kotlin.s0.w.d.l0.n.w1.r.a.l(r1, r2);
        }

        public static kotlin.s0.w.d.l0.n.w1.m p(b r0, kotlin.s0.w.d.l0.n.w1.i r1, int r2) {
            kotlin.n0.d.o.f(r1, "$receiver");
            if ((r1 instanceof e0) == false) goto L7;
            return ((e0) r1).M0().get(r2);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r1 + ", " + kotlin.n0.d.e0.b(r1.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.n.w1.i p0(b r1, kotlin.s0.w.d.l0.n.w1.d r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof i) == false) goto L7;
            return ((i) r2).Z0();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.n.w1.m q(b r1, kotlin.s0.w.d.l0.n.w1.k r2, int r3) {
            kotlin.n0.d.o.f(r2, "$receiver");
            return kotlin.s0.w.d.l0.n.w1.r.a.c(r1, r2, r3);
        }

        public static kotlin.s0.w.d.l0.n.w1.i q0(b r1, kotlin.s0.w.d.l0.n.w1.i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof q1) == false) goto L7;
            return c.a((q1) r2);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static List<kotlin.s0.w.d.l0.n.w1.m> r(b r1, kotlin.s0.w.d.l0.n.w1.i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof e0) == false) goto L7;
            return ((e0) r2).M0();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.n.w1.i r0(b r1, kotlin.s0.w.d.l0.n.w1.i r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            return m1.a.a(r1, r2);
        }

        public static kotlin.s0.w.d.l0.g.d s(b r1, kotlin.s0.w.d.l0.n.w1.n r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof e1) == false) goto L7;
            kotlin.s0.w.d.l0.c.h r3 = ((e1) r2).d();
            kotlin.n0.d.o.d(r3, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return kotlin.s0.w.d.l0.k.t.a.i((kotlin.s0.w.d.l0.c.e) r3);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static d1 s0(b r7, boolean r8, boolean r9) {
            return kotlin.s0.w.d.l0.n.t1.a.b(r8, r9, r7, null, null, 24, null);
        }

        public static kotlin.s0.w.d.l0.n.w1.o t(b r0, kotlin.s0.w.d.l0.n.w1.n r1, int r2) {
            kotlin.n0.d.o.f(r1, "$receiver");
            if ((r1 instanceof e1) == false) goto L7;
            f1 r3 = ((e1) r1).getParameters().get(r2);
            kotlin.n0.d.o.e(r3, "this.parameters[index]");
            return r3;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r1 + ", " + kotlin.n0.d.e0.b(r1.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.n.w1.k t0(b r1, kotlin.s0.w.d.l0.n.w1.e r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof kotlin.s0.w.d.l0.n.p) == false) goto L7;
            return ((kotlin.s0.w.d.l0.n.p) r2).a1();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static List<kotlin.s0.w.d.l0.n.w1.o> u(b r1, kotlin.s0.w.d.l0.n.w1.n r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof e1) == false) goto L7;
            List<f1> r3 = ((e1) r2).getParameters();
            kotlin.n0.d.o.e(r3, "this.parameters");
            return r3;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static int u0(b r1, kotlin.s0.w.d.l0.n.w1.n r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof e1) == false) goto L7;
            return ((e1) r2).getParameters().size();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.b.i v(b r1, kotlin.s0.w.d.l0.n.w1.n r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof e1) == false) goto L7;
            kotlin.s0.w.d.l0.c.h r3 = ((e1) r2).d();
            kotlin.n0.d.o.d(r3, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return kotlin.s0.w.d.l0.b.h.P((kotlin.s0.w.d.l0.c.e) r3);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static Collection<kotlin.s0.w.d.l0.n.w1.i> v0(b r1, kotlin.s0.w.d.l0.n.w1.k r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            kotlin.s0.w.d.l0.n.w1.n r3 = r1.c(r2);
            if ((r3 instanceof kotlin.s0.w.d.l0.k.r.n) == false) goto L7;
            return ((kotlin.s0.w.d.l0.k.r.n) r3).k();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.b.i w(b r1, kotlin.s0.w.d.l0.n.w1.n r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof e1) == false) goto L7;
            kotlin.s0.w.d.l0.c.h r3 = ((e1) r2).d();
            kotlin.n0.d.o.d(r3, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return kotlin.s0.w.d.l0.b.h.S((kotlin.s0.w.d.l0.c.e) r3);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.n.w1.m w0(b r1, kotlin.s0.w.d.l0.n.w1.c r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof j) == false) goto L7;
            return ((j) r2).f();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.n.w1.i x(b r1, kotlin.s0.w.d.l0.n.w1.o r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof f1) == false) goto L7;
            return kotlin.s0.w.d.l0.n.x1.a.i((f1) r2);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static int x0(b r1, kotlin.s0.w.d.l0.n.w1.l r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            return kotlin.s0.w.d.l0.n.w1.r.a.m(r1, r2);
        }

        public static kotlin.s0.w.d.l0.n.w1.i y(b r1, kotlin.s0.w.d.l0.n.w1.m r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof g1) == false) goto L7;
            return ((g1) r2).b().R0();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static d1.c y0(b r1, kotlin.s0.w.d.l0.n.w1.k r2) {
            kotlin.n0.d.o.f(r2, WsConstants.KEY_CONNECTION_TYPE);
            if ((r2 instanceof m0) == false) goto L7;
            return new C0579a(r1, kotlin.s0.w.d.l0.n.f1.f21004b.a((e0) r2).c());
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static kotlin.s0.w.d.l0.n.w1.o z(b r1, kotlin.s0.w.d.l0.n.w1.t r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof n) == false) goto L7;
            return ((n) r2).b();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }

        public static Collection<kotlin.s0.w.d.l0.n.w1.i> z0(b r1, kotlin.s0.w.d.l0.n.w1.n r2) {
            kotlin.n0.d.o.f(r2, "$receiver");
            if ((r2 instanceof e1) == false) goto L7;
            Collection<e0> r3 = ((e1) r2).a();
            kotlin.n0.d.o.e(r3, "this.supertypes");
            return r3;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + kotlin.n0.d.e0.b(r2.getClass())).toString());
        }
    }

    kotlin.s0.w.d.l0.n.w1.i E(kotlin.s0.w.d.l0.n.w1.k r1, kotlin.s0.w.d.l0.n.w1.k r2);

    @Override // kotlin.s0.w.d.l0.n.w1.p
    kotlin.s0.w.d.l0.n.w1.k a(kotlin.s0.w.d.l0.n.w1.i r1);

    @Override // kotlin.s0.w.d.l0.n.w1.p
    boolean b(kotlin.s0.w.d.l0.n.w1.k r1);

    @Override // kotlin.s0.w.d.l0.n.w1.p
    kotlin.s0.w.d.l0.n.w1.n c(kotlin.s0.w.d.l0.n.w1.k r1);

    @Override // kotlin.s0.w.d.l0.n.w1.p
    kotlin.s0.w.d.l0.n.w1.k d(kotlin.s0.w.d.l0.n.w1.k r1, boolean r2);

    @Override // kotlin.s0.w.d.l0.n.w1.p
    kotlin.s0.w.d.l0.n.w1.k e(kotlin.s0.w.d.l0.n.w1.g r1);

    @Override // kotlin.s0.w.d.l0.n.w1.p
    kotlin.s0.w.d.l0.n.w1.d f(kotlin.s0.w.d.l0.n.w1.k r1);

    @Override // kotlin.s0.w.d.l0.n.w1.p
    kotlin.s0.w.d.l0.n.w1.k g(kotlin.s0.w.d.l0.n.w1.g r1);
}
