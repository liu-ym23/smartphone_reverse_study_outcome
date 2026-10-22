package kotlin.s0.w.d.l0.n.x1;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.i0.g0;
import kotlin.i0.r;
import kotlin.m;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.s0.w.d.l0.c.e;
import kotlin.s0.w.d.l0.c.e1;
import kotlin.s0.w.d.l0.c.f;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.h;
import kotlin.s0.w.d.l0.c.i;
import kotlin.s0.w.d.l0.c.o1.g;
import kotlin.s0.w.d.l0.n.b1;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.f0;
import kotlin.s0.w.d.l0.n.g1;
import kotlin.s0.w.d.l0.n.i1;
import kotlin.s0.w.d.l0.n.k1;
import kotlin.s0.w.d.l0.n.l1;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.n1;
import kotlin.s0.w.d.l0.n.p;
import kotlin.s0.w.d.l0.n.p1;
import kotlin.s0.w.d.l0.n.q1;
import kotlin.s0.w.d.l0.n.r1;
import kotlin.s0.w.d.l0.n.s0;
import kotlin.s0.w.d.l0.n.u0;
import kotlin.s0.w.d.l0.n.y;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.n.x1.a$a, reason: collision with other inner class name */
    static final class C0581a extends q implements l<q1, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0581a f21193f = null;

        static {
            f21193f = new C0581a();
        }

        C0581a() {
            super(1);
        }

        public final Boolean a(q1 r1) {
            o.f(r1, "it");
            h r0 = r1.O0().d();
            if (r0 == null) goto L5;
            boolean r2 = a.p(r0);
        L7:
            return Boolean.valueOf(r2);
        L5:
            r2 = false;
            goto L7
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(q1 r1) {
            return a(r1);
        }
    }

    static final class b extends q implements l<q1, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f21194f = null;

        static {
            f21194f = new b();
        }

        b() {
            super(1);
        }

        public final Boolean a(q1 r2) {
            o.f(r2, "it");
            h r1 = r2.O0().d();
            boolean r3 = false;
            if (r1 == null) goto L10;
            if ((r1 instanceof e1) == false) goto L7;
        L8:
            r3 = true;
            goto L10
        L7:
            if ((r1 instanceof f1) == true) goto L8;
        L10:
            return Boolean.valueOf(r3);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(q1 r1) {
            return a(r1);
        }
    }

    public static final g1 a(e0 r1) {
        o.f(r1, "<this>");
        return new i1(r1);
    }

    public static final boolean b(e0 r1, l<? super q1, Boolean> r2) {
        o.f(r1, "<this>");
        o.f(r2, "predicate");
        return n1.c(r1, r2);
    }

    private static final boolean c(e0 r6, kotlin.s0.w.d.l0.n.e1 r7, Set<? extends f1> r8) {
        if (o.a(r6.O0(), r7) == false) goto L5;
        return true;
    L5:
        h r0 = r6.O0().d();
        if ((r0 instanceof i) == false) goto L8;
        i r1 = (i) r0;
    L9:
        if (r1 == null) goto L11;
        List<f1> r2 = r1.u();
    L12:
        Iterable r9 = r.F0(r6.M0());
        if ((r9 instanceof Collection) == true) goto L15;
    L17:
        Iterator r10 = r9.iterator();
    L19:
        if (r10.hasNext() == false) goto L37;
        g0 r3 = (g0) r10.next();
        int r5 = r3.a();
        g1 r4 = (g1) r3.b();
        if (r2 == null) goto L23;
        f1 r11 = (f1) r.S(r2, r5);
    L24:
        if (r11 == null) goto L29;
        if (r8 == null) goto L29;
        if (r8.contains(r11) == false) goto L29;
        boolean r12 = true;
    L30:
        if (r12 == false) goto L32;
    L35:
        boolean r13 = false;
    L36:
        if (r13 == false) goto L19;
        return true;
    L32:
        if (r4.d() == true) goto L35;
        e0 r14 = r4.b();
        o.e(r14, "argument.type");
        r13 = c(r14, r7, r8);
    L29:
        r12 = false;
        goto L30
    L23:
        r11 = null;
    L37:
        return false;
    L15:
        if (((Collection) r9).isEmpty() == false) goto L17;
    L11:
        r2 = null;
        goto L12
    L8:
        r1 = null;
        goto L9
    }

    public static final boolean d(e0 r1) {
        o.f(r1, "<this>");
        return b(r1, C0581a.f21193f);
    }

    public static final g1 e(e0 r1, r1 r2, f1 r3) {
        o.f(r1, WsConstants.KEY_CONNECTION_TYPE);
        o.f(r2, "projectionKind");
        if (r3 == null) goto L5;
        r1 r4 = r3.n();
    L6:
        if (r4 != r2) goto L9;
        r2 = r1.f21065h;
    L9:
        return new i1(r2, r1);
    L5:
        r4 = null;
        goto L6
    }

    public static final Set<f1> f(e0 r1, Set<? extends f1> r2) {
        o.f(r1, "<this>");
        LinkedHashSet r0 = new LinkedHashSet();
        g(r1, r1, r0, r2);
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void g(e0 r7, e0 r8, Set<f1> r9, Set<? extends f1> r10) {
        h r0 = r7.O0().d();
        if ((r0 instanceof f1) == true) goto L5;
        h r1 = r7.O0().d();
        if ((r1 instanceof i) == false) goto L14;
        i r2 = (i) r1;
    L15:
        if (r2 == null) goto L17;
        List<f1> r3 = r2.u();
    L18:
        Iterator<g1> r11 = r7.M0().iterator();
        int r4 = 0;
    L20:
        if (r11.hasNext() == false) goto L51;
        int r5 = r4 + 1;
        g1 r6 = r11.next();
        if (r3 == null) goto L24;
        f1 r12 = (f1) r.S(r3, r4);
    L25:
        if (r12 == null) goto L30;
        if (r10 == null) goto L30;
        if (r10.contains(r12) == false) goto L30;
        boolean r13 = true;
    L31:
        if (r13 == true) goto L41;
        if (r6.d() == true) goto L41;
        if (r.J(r9, r6.b().O0().d()) == true) goto L41;
        if (o.a(r6.b().O0(), r8.O0()) == true) goto L41;
        e0 r14 = r6.b();
        o.e(r14, "argument.type");
        g(r14, r8, r9, r10);
    L41:
        r4 = r5;
    L30:
        r13 = false;
        goto L31
    L24:
        r12 = null;
        goto L25
    L51:
        return;
    L17:
        r3 = null;
        goto L18
    L14:
        r2 = null;
        goto L15
    L5:
        if (o.a(r7.O0(), r8.O0()) == true) goto L7;
        r9.add(r0);
        return;
    L7:
        Iterator<e0> r15 = ((f1) r0).getUpperBounds().iterator();
    L9:
        if (r15.hasNext() == false) goto L50;
        e0 r16 = r15.next();
        o.e(r16, "upperBound");
        g(r16, r8, r9, r10);
        goto L9
    }

    public static final kotlin.s0.w.d.l0.b.h h(e0 r1) {
        o.f(r1, "<this>");
        kotlin.s0.w.d.l0.b.h r2 = r1.O0().o();
        o.e(r2, "constructor.builtIns");
        return r2;
    }

    public static final e0 i(f1 r7) {
        o.f(r7, "<this>");
        List<e0> r0 = r7.getUpperBounds();
        o.e(r0, "upperBounds");
        r0.isEmpty();
        List<e0> r1 = r7.getUpperBounds();
        o.e(r1, "upperBounds");
        Iterator<T> r2 = r1.iterator();
    L3:
        Object r3 = null;
        e r4 = null;
        if (r2.hasNext() == false) goto L18;
        Object r5 = r2.next();
        h r6 = ((e0) r5).O0().d();
        if ((r6 instanceof e) == false) goto L8;
        r4 = (e) r6;
    L8:
        boolean r8 = false;
        if (r4 == null) goto L16;
        if (r4.i() == f.f18866g) goto L16;
        if (r4.i() == f.f18869j) goto L16;
        r8 = true;
    L16:
        if (r8 == false) goto L3;
        r3 = r5;
    L18:
        e0 r9 = (e0) r3;
        if (r9 != null) goto L29;
        List<e0> r10 = r7.getUpperBounds();
        o.e(r10, "upperBounds");
        Object r11 = r.P(r10);
        o.e(r11, "upperBounds.first()");
        return (e0) r11;
    L29:
        return r9;
    }

    public static final boolean j(f1 r2) {
        o.f(r2, "typeParameter");
        return l(r2, null, null, 6, null);
    }

    public static final boolean k(f1 r5, kotlin.s0.w.d.l0.n.e1 r6, Set<? extends f1> r7) {
        o.f(r5, "typeParameter");
        List<e0> r0 = r5.getUpperBounds();
        o.e(r0, "typeParameter.upperBounds");
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        e0 r2 = (e0) r1.next();
        o.e(r2, "upperBound");
        if (c(r2, r5.s().O0(), r7) == false) goto L16;
        if (r6 != null) goto L14;
    L15:
        boolean r3 = true;
    L17:
        if (r3 == false) goto L9;
        return true;
    L14:
        if (o.a(r2.O0(), r6) == true) goto L15;
    L16:
        r3 = false;
    L18:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }

    public static /* synthetic */ boolean l(f1 r1, kotlin.s0.w.d.l0.n.e1 r2, Set r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = null;
    L9:
        return k(r1, r2, r3);
    }

    public static final boolean m(e0 r3) {
        o.f(r3, "<this>");
        if ((r3 instanceof kotlin.s0.w.d.l0.n.e) == true) goto L12;
        if ((r3 instanceof p) == true) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == true) goto L12;
        return false;
    L7:
        if ((((p) r3).a1() instanceof kotlin.s0.w.d.l0.n.e) == false) goto L9;
        r4 = true;
    L12:
        return true;
    }

    public static final boolean n(e0 r3) {
        o.f(r3, "<this>");
        if ((r3 instanceof u0) == true) goto L12;
        if ((r3 instanceof p) == true) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == true) goto L12;
        return false;
    L7:
        if ((((p) r3).a1() instanceof u0) == false) goto L9;
        r4 = true;
    L12:
        return true;
    }

    public static final boolean o(e0 r1, e0 r2) {
        o.f(r1, "<this>");
        o.f(r2, "superType");
        return kotlin.s0.w.d.l0.n.t1.e.f21078a.d(r1, r2);
    }

    public static final boolean p(h r1) {
        o.f(r1, "<this>");
        if ((r1 instanceof f1) == true) goto L5;
    L7:
        return false;
    L5:
        if ((((f1) r1).c() instanceof e1) == false) goto L7;
        return true;
    }

    public static final boolean q(e0 r1) {
        o.f(r1, "<this>");
        return n1.m(r1);
    }

    public static final boolean r(e0 r1) {
        o.f(r1, WsConstants.KEY_CONNECTION_TYPE);
        if ((r1 instanceof kotlin.s0.w.d.l0.n.u1.h) == true) goto L5;
    L7:
        return false;
    L5:
        if (((kotlin.s0.w.d.l0.n.u1.h) r1).Y0().c() == false) goto L7;
        return true;
    }

    public static final e0 s(e0 r1) {
        o.f(r1, "<this>");
        e0 r2 = n1.n(r1);
        o.e(r2, "makeNotNullable(this)");
        return r2;
    }

    public static final e0 t(e0 r1) {
        o.f(r1, "<this>");
        e0 r2 = n1.o(r1);
        o.e(r2, "makeNullable(this)");
        return r2;
    }

    public static final e0 u(e0 r1, g r2) {
        o.f(r1, "<this>");
        o.f(r2, "newAnnotations");
        if (r1.getAnnotations().isEmpty() == false) goto L8;
        if (r2.isEmpty() == false) goto L8;
        return r1;
    L8:
        return r1.R0().U0(b1.a(r1.N0(), r2));
    }

    public static final e0 v(e0 r16, l1 r17, Map<kotlin.s0.w.d.l0.n.e1, ? extends g1> r18, r1 r19, Set<? extends f1> r20) {
        o.f(r16, "<this>");
        o.f(r17, "substitutor");
        o.f(r18, "substitutionMap");
        o.f(r19, "variance");
        q1 r4 = r16.R0();
        if ((r4 instanceof y) == false) goto L50;
        y r6 = (y) r4;
        m0 r13 = r6.W0();
        if (r13.O0().getParameters().isEmpty() == false) goto L7;
    L26:
        m0 r7 = r6.X0();
        if (r7.O0().getParameters().isEmpty() == false) goto L29;
    L48:
        q1 r1 = f0.d(r13, r7);
    L74:
        e0 r0 = r17.n(p1.b(r1, r4), r19);
        o.e(r0, "replaceArgumentsByParame…ubstitute(it, variance) }");
        return r0;
    L29:
        if (r7.O0().d() == null) goto L48;
        List<f1> r8 = r7.O0().getParameters();
        o.e(r8, "constructor.parameters");
        ArrayList r9 = new ArrayList(r.q(r8, 10));
        Iterator<T> r10 = r8.iterator();
    L33:
        if (r10.hasNext() == false) goto L47;
        f1 r11 = (f1) r10.next();
        g1 r12 = (g1) r.S(r16.M0(), r11.j());
        if (r20 != null) goto L37;
    L39:
        boolean r14 = false;
    L40:
        if (r14 == true) goto L45;
        if (r12 == null) goto L45;
        if (r18.containsKey(r12.b().O0()) == false) goto L45;
    L46:
        r9.add(r12);
    L45:
        r12 = new s0(r11);
        goto L46
    L37:
        if (r20.contains(r11) == false) goto L39;
        r14 = true;
        goto L40
    L47:
        r7 = k1.f(r7, r9, null, 2, null);
        goto L48
    L7:
        if (r13.O0().d() == null) goto L26;
        List<f1> r15 = r13.O0().getParameters();
        o.e(r15, "constructor.parameters");
        ArrayList r110 = new ArrayList(r.q(r15, 10));
        Iterator<T> r21 = r15.iterator();
    L11:
        if (r21.hasNext() == false) goto L25;
        f1 r111 = (f1) r21.next();
        g1 r22 = (g1) r.S(r16.M0(), r111.j());
        if (r20 != null) goto L15;
    L17:
        boolean r112 = false;
    L18:
        if (r112 == true) goto L23;
        if (r22 == null) goto L23;
        if (r18.containsKey(r22.b().O0()) == false) goto L23;
    L24:
        r110.add(r22);
    L23:
        r22 = new s0(r111);
        goto L24
    L15:
        if (r20.contains(r111) == false) goto L17;
        r112 = true;
        goto L18
    L25:
        r13 = k1.f(r13, r110, null, 2, null);
        goto L26
    L50:
        if ((r4 instanceof m0) == false) goto L77;
        m0 r23 = (m0) r4;
        if (r23.O0().getParameters().isEmpty() == false) goto L54;
    L73:
        r1 = r23;
        goto L74
    L54:
        if (r23.O0().d() == null) goto L73;
        List<f1> r24 = r23.O0().getParameters();
        o.e(r24, "constructor.parameters");
        ArrayList r25 = new ArrayList(r.q(r24, 10));
        Iterator<T> r26 = r24.iterator();
    L58:
        if (r26.hasNext() == false) goto L72;
        f1 r113 = (f1) r26.next();
        g1 r114 = (g1) r.S(r16.M0(), r113.j());
        if (r20 != null) goto L62;
    L64:
        boolean r115 = false;
    L65:
        if (r115 == true) goto L70;
        if (r114 == null) goto L70;
        if (r18.containsKey(r114.b().O0()) == false) goto L70;
    L71:
        r25.add(r114);
    L70:
        r114 = new s0(r113);
        goto L71
    L62:
        if (r20.contains(r113) == false) goto L64;
        r115 = true;
        goto L65
    L72:
        r1 = k1.f(r23, r25, null, 2, null);
        goto L74
    L77:
        throw new m();
    }

    public static final e0 w(e0 r10) {
        o.f(r10, "<this>");
        q1 r11 = r10.R0();
        if ((r11 instanceof y) == false) goto L26;
        y r0 = (y) r11;
        m0 r5 = r0.W0();
        if (r5.O0().getParameters().isEmpty() == false) goto L7;
    L14:
        m0 r1 = r0.X0();
        if (r1.O0().getParameters().isEmpty() == false) goto L17;
    L24:
        q1 r2 = f0.d(r5, r1);
    L38:
        return p1.b(r2, r11);
    L17:
        if (r1.O0().d() == null) goto L24;
        List<f1> r6 = r1.O0().getParameters();
        o.e(r6, "constructor.parameters");
        ArrayList r3 = new ArrayList(r.q(r6, 10));
        Iterator<T> r4 = r6.iterator();
    L21:
        if (r4.hasNext() == false) goto L23;
        r3.add(new s0((f1) r4.next()));
        goto L21
    L23:
        r1 = k1.f(r1, r3, null, 2, null);
        goto L24
    L7:
        if (r5.O0().d() == null) goto L14;
        List<f1> r7 = r5.O0().getParameters();
        o.e(r7, "constructor.parameters");
        ArrayList r8 = new ArrayList(r.q(r7, 10));
        Iterator<T> r9 = r7.iterator();
    L11:
        if (r9.hasNext() == false) goto L13;
        r8.add(new s0((f1) r9.next()));
        goto L11
    L13:
        r5 = k1.f(r5, r8, null, 2, null);
        goto L14
    L26:
        if ((r11 instanceof m0) == false) goto L40;
        m0 r12 = (m0) r11;
        boolean r13 = r12.O0().getParameters().isEmpty();
        r2 = r12;
        if (r13 == true) goto L38;
        h r14 = r12.O0().d();
        r2 = r12;
        if (r14 == null) goto L38;
        List<f1> r15 = r12.O0().getParameters();
        o.e(r15, "constructor.parameters");
        ArrayList r16 = new ArrayList(r.q(r15, 10));
        Iterator<T> r17 = r15.iterator();
    L34:
        if (r17.hasNext() == false) goto L36;
        r16.add(new s0((f1) r17.next()));
        goto L34
    L36:
        r2 = k1.f(r12, r16, null, 2, null);
        goto L38
    L40:
        throw new m();
    }

    public static final boolean x(e0 r1) {
        o.f(r1, "<this>");
        return b(r1, b.f21194f);
    }
}
