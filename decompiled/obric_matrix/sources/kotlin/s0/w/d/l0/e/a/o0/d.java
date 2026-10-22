package kotlin.s0.w.d.l0.e.a.o0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.n.a1;
import kotlin.s0.w.d.l0.n.b0;
import kotlin.s0.w.d.l0.n.b1;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.e1;
import kotlin.s0.w.d.l0.n.f0;
import kotlin.s0.w.d.l0.n.g0;
import kotlin.s0.w.d.l0.n.g1;
import kotlin.s0.w.d.l0.n.l0;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.n1;
import kotlin.s0.w.d.l0.n.p1;
import kotlin.s0.w.d.l0.n.q0;
import kotlin.s0.w.d.l0.n.q1;
import kotlin.s0.w.d.l0.n.r1;
import kotlin.s0.w.d.l0.n.y;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.e.a.l0.c f19543a;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e0 f19544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f19545b;

        public a(e0 r1, int r2) {
            this.f19544a = r1;
            this.f19545b = r2;
        }

        public final int a() {
            return this.f19545b;
        }

        public final e0 b() {
            return this.f19544a;
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final m0 f19546a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f19547b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f19548c;

        public b(m0 r1, int r2, boolean r3) {
            this.f19546a = r1;
            this.f19547b = r2;
            this.f19548c = r3;
        }

        public final boolean a() {
            return this.f19548c;
        }

        public final int b() {
            return this.f19547b;
        }

        public final m0 c() {
            return this.f19546a;
        }
    }

    public d(kotlin.s0.w.d.l0.e.a.l0.c r2) {
        kotlin.n0.d.o.f(r2, "javaResolverSettings");
        this.f19543a = r2;
    }

    private final b b(m0 r19, kotlin.n0.c.l<? super Integer, e> r20, int r21, o r22, boolean r23, boolean r24) {
        kotlin.n0.c.l<? super Integer, e> r1 = r20;
        boolean r4 = p.a(r22);
        if (r24 == false) goto L7;
        if (r23 == false) goto L7;
        boolean r7 = false;
    L8:
        e0 r8 = null;
        if (r4 == false) goto L11;
    L14:
        kotlin.s0.w.d.l0.c.h r5 = r19.O0().d();
        if (r5 == null) goto L17;
        e r9 = r1.invoke(Integer.valueOf(r21));
        kotlin.s0.w.d.l0.c.h r6 = r.b(r5, r9, r22);
        Boolean r2 = r.e(r9, r22);
        if (r6 == null) goto L22;
        e1 r10 = r6.k();
        if (r10 == null) goto L22;
    L23:
        e1 r12 = r10;
        kotlin.n0.d.o.e(r12, "enhancedClassifier?.typeConstructor ?: constructor");
        int r11 = r21 + 1;
        List<g1> r13 = r19.M0();
        List<f1> r14 = r12.getParameters();
        kotlin.n0.d.o.e(r14, "typeConstructor.parameters");
        Iterator<T> r15 = r13.iterator();
        Iterator<T> r16 = r14.iterator();
        ArrayList r17 = new ArrayList(Math.min(kotlin.i0.r.q(r13, 10), kotlin.i0.r.q(r14, 10)));
    L25:
        if (r15.hasNext() == false) goto L50;
        if (r16.hasNext() == false) goto L50;
        Object r18 = r15.next();
        f1 r110 = (f1) r16.next();
        g1 r111 = (g1) r18;
        if (r7 == true) goto L31;
        boolean r25 = r7;
        a r26 = new a(r8, 0);
    L38:
        r11 = r11 + r26.a();
        if (r26.b() == null) goto L42;
        e0 r3 = r26.b();
    L41:
        r1 r27 = r111.a();
        kotlin.n0.d.o.e(r27, "arg.projectionKind");
        g1 r28 = kotlin.s0.w.d.l0.n.x1.a.e(r3, r27, r110);
    L49:
        r17.add(r28);
        r1 = r20;
        r7 = r25;
        r8 = null;
        goto L25
    L42:
        if (r6 != null) goto L44;
    L46:
        if (r6 == null) goto L48;
        r28 = n1.s(r110);
        goto L49
    L48:
        r28 = null;
        goto L49
    L44:
        if (r111.d() == true) goto L46;
        r3 = r111.b();
        kotlin.n0.d.o.e(r3, "arg.type");
        goto L41
    L31:
        r25 = r7;
        if (r111.d() == true) goto L35;
        r26 = d(r111.b().R0(), r1, r11, r24);
        goto L38
    L35:
        if (r1.invoke(Integer.valueOf(r11)).d() != h.f19559f) goto L37;
        q1 r29 = r111.b().R0();
        r26 = new a(f0.d(b0.c(r29).V0(false), b0.d(r29).V0(true)), 1);
        goto L38
    L37:
        r26 = new a(null, 1);
    L50:
        int r112 = r11 - r21;
        if (r6 != null) goto L68;
        if (r2 != null) goto L68;
        if (r17.isEmpty() == false) goto L56;
    L55:
        boolean r30 = true;
    L65:
        if (r30 == false) goto L68;
        return new b(null, r112, false);
    L56:
        Iterator r31 = r17.iterator();
    L58:
        if (r31.hasNext() == false) goto L55;
        if (((g1) r31.next()) != null) goto L62;
        boolean r32 = true;
    L63:
        if (r32 == true) goto L58;
        r30 = false;
        goto L65
    L62:
        r32 = false;
    L68:
        kotlin.s0.w.d.l0.c.o1.g[] r33 = new kotlin.s0.w.d.l0.c.o1.g[3];
        r33[0] = r19.getAnnotations();
        c r34 = r.c();
        if (r6 == null) goto L71;
        boolean r35 = true;
    L72:
        if (r35 == true) goto L75;
        r34 = null;
    L75:
        r33[1] = r34;
        c r36 = r.d();
        if (r2 == null) goto L78;
        boolean r113 = true;
    L79:
        if (r113 == true) goto L82;
        r36 = null;
    L82:
        r33[2] = r36;
        a1 r114 = b1.b(r.a(kotlin.i0.r.l(r33)));
        List<g1> r37 = r19.M0();
        Iterator r38 = r17.iterator();
        Iterator<T> r39 = r37.iterator();
        ArrayList r115 = new ArrayList(Math.min(kotlin.i0.r.q(r17, 10), kotlin.i0.r.q(r37, 10)));
    L84:
        if (r38.hasNext() == false) goto L92;
        if (r39.hasNext() == false) goto L92;
        Object r40 = r38.next();
        g1 r41 = (g1) r39.next();
        g1 r42 = (g1) r40;
        if (r42 == null) goto L91;
        r41 = r42;
    L91:
        r115.add(r41);
    L92:
        if (r2 == null) goto L94;
        boolean r43 = r2.booleanValue();
    L95:
        m0 r44 = f0.i(r114, r12, r115, r43, null, 16, null);
        if (r9.b() == false) goto L98;
        r44 = e(r44);
    L98:
        if (r2 != null) goto L100;
    L102:
        boolean r45 = false;
    L104:
        return new b(r44, r112, r45);
    L100:
        if (r9.e() == false) goto L102;
        r45 = true;
        goto L104
    L94:
        r43 = r19.P0();
        goto L95
    L78:
        r113 = false;
        goto L79
    L71:
        r35 = false;
    L22:
        r10 = r19.O0();
        goto L23
    L17:
        return new b(null, 1, false);
    L11:
        if (r19.M0().isEmpty() == false) goto L14;
        return new b(null, 1, false);
    L7:
        r7 = true;
        goto L8
    }

    static /* synthetic */ b c(d r9, m0 r10, kotlin.n0.c.l r11, int r12, o r13, boolean r14, boolean r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L5;
        boolean r7 = false;
    L7:
        if ((r16 & 16) == 0) goto L9;
        boolean r8 = false;
    L11:
        return r9.b(r10, r11, r12, r13, r7, r8);
    L9:
        r8 = r15;
        goto L11
    L5:
        r7 = r14;
        goto L7
    }

    private final a d(q1 r12, kotlin.n0.c.l<? super Integer, e> r13, int r14, boolean r15) {
        e0 r1 = null;
        if (g0.a(r12) == false) goto L7;
        return new a(null, 1);
    L7:
        if ((r12 instanceof y) == false) goto L44;
        boolean r0 = r12 instanceof l0;
        y r9 = (y) r12;
        b r10 = b(r9.W0(), r13, r14, o.f19623f, r0, r15);
        b r11 = b(r9.X0(), r13, r14, o.f19624g, r0, r15);
        r10.b();
        r11.b();
        if (r10.c() != null) goto L14;
        if (r11.c() != null) goto L14;
    L53:
        return new a(r1, r10.b());
    L14:
        if (r10.a() == false) goto L16;
    L33:
        m0 r16 = r11.c();
        if (r16 == null) goto L40;
        m0 r17 = r10.c();
        if (r17 != null) goto L38;
        r17 = r16;
    L38:
        e0 r18 = f0.d(r17, r16);
        if (r18 == null) goto L40;
    L41:
        r1 = p1.d(r12, r18);
    L40:
        r18 = r10.c();
        kotlin.n0.d.o.c(r18);
        goto L41
    L16:
        if (r11.a() == true) goto L33;
        if (r0 == false) goto L26;
        m0 r19 = r10.c();
        if (r19 != null) goto L22;
        r19 = r9.W0();
    L22:
        m0 r110 = r11.c();
        if (r110 != null) goto L25;
        r110 = r9.X0();
    L25:
        r1 = new kotlin.s0.w.d.l0.e.a.l0.m.f(r19, r110);
        goto L53
    L26:
        m0 r111 = r10.c();
        if (r111 != null) goto L29;
        r111 = r9.W0();
    L29:
        m0 r112 = r11.c();
        if (r112 != null) goto L32;
        r112 = r9.X0();
    L32:
        r1 = f0.d(r111, r112);
        goto L53
    L44:
        if ((r12 instanceof m0) == false) goto L52;
        b r113 = c(this, (m0) r12, r13, r14, o.f19625h, false, r15, 8, null);
        if (r113.a() == false) goto L48;
        e0 r114 = p1.d(r12, r113.c());
    L50:
        return new a(r114, r113.b());
    L48:
        r114 = r113.c();
        goto L50
    L52:
        throw new kotlin.m();
    }

    private final m0 e(m0 r1) {
        if (this.f19543a.a() == false) goto L6;
        return q0.h(r1, true);
    L6:
        return new g(r1);
    }

    public final e0 a(e0 r2, kotlin.n0.c.l<? super Integer, e> r3, boolean r4) {
        kotlin.n0.d.o.f(r2, "<this>");
        kotlin.n0.d.o.f(r3, "qualifiers");
        return d(r2.R0(), r3, 0, r4).b();
    }
}
