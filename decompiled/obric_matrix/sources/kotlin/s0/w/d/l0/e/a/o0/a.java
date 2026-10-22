package kotlin.s0.w.d.l0.e.a.o0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.s0.w.d.l0.e.a.x;
import kotlin.s0.w.d.l0.n.w1.u;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<TAnnotation> {

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.e.a.o0.a$a, reason: collision with other inner class name */
    private static final class C0518a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.n.w1.i f19533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final x f19534b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.n.w1.o f19535c;

        public C0518a(kotlin.s0.w.d.l0.n.w1.i r1, x r2, kotlin.s0.w.d.l0.n.w1.o r3) {
            this.f19533a = r1;
            this.f19534b = r2;
            this.f19535c = r3;
        }

        public final x a() {
            return this.f19534b;
        }

        public final kotlin.s0.w.d.l0.n.w1.i b() {
            return this.f19533a;
        }

        public final kotlin.s0.w.d.l0.n.w1.o c() {
            return this.f19535c;
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.l<Integer, e> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ q f19536f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e[] f19537g;

        b(q r1, e[] r2) {
            this.f19536f = r1;
            this.f19537g = r2;
            super(1);
        }

        public final e a(int r3) {
            q r0 = this.f19536f;
            if (r0 == null) goto L8;
            Map<Integer, e> r1 = r0.a();
            if (r1 == null) goto L8;
            e r2 = r1.get(Integer.valueOf(r3));
            if (r2 == null) goto L8;
            return r2;
        L8:
            e[] r4 = this.f19537g;
            if (r3 < 0) goto L14;
            if (r3 > kotlin.i0.i.z(r4)) goto L14;
            return r4[r3];
        L14:
            return e.f19549e.a();
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ e invoke(Integer r1) {
            return a(r1.intValue());
        }
    }

    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.l<TAnnotation, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a<TAnnotation> f19538f;

        c(a<TAnnotation> r1) {
            this.f19538f = r1;
            super(1);
        }

        public final Boolean a(TAnnotation r2) {
            kotlin.n0.d.o.f(r2, "$this$extractNullability");
            return Boolean.valueOf(this.f19538f.r(r2));
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(Object r1) {
            return a(r1);
        }
    }

    static final class d extends kotlin.n0.d.q implements kotlin.n0.c.l<C0518a, Iterable<? extends C0518a>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a<TAnnotation> f19539f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.n.w1.p f19540g;

        d(a<TAnnotation> r1, kotlin.s0.w.d.l0.n.w1.p r2) {
            this.f19539f = r1;
            this.f19540g = r2;
            super(1);
        }

        public final Iterable<C0518a> a(C0518a r10) {
            kotlin.n0.d.o.f(r10, "it");
            if (this.f19539f.u() == false) goto L12;
            kotlin.s0.w.d.l0.n.w1.i r0 = r10.b();
            if (r0 == null) goto L9;
            kotlin.s0.w.d.l0.n.w1.g r1 = this.f19540g.M(r0);
            if (r1 == null) goto L9;
            kotlin.s0.w.d.l0.n.w1.j r2 = this.f19540g.y(r1);
        L10:
            if (r2 == null) goto L12;
            return null;
        L9:
            r2 = null;
        L12:
            kotlin.s0.w.d.l0.n.w1.i r3 = r10.b();
            if (r3 == null) goto L34;
            kotlin.s0.w.d.l0.n.w1.n r4 = this.f19540g.w(r3);
            if (r4 == null) goto L35;
            List<kotlin.s0.w.d.l0.n.w1.o> r5 = this.f19540g.e0(r4);
            if (r5 == null) goto L36;
            List<kotlin.s0.w.d.l0.n.w1.m> r6 = this.f19540g.X(r10.b());
            kotlin.s0.w.d.l0.n.w1.p r7 = this.f19540g;
            a<TAnnotation> r9 = this.f19539f;
            Iterator<T> r8 = r5.iterator();
            Iterator<T> r11 = r6.iterator();
            ArrayList r12 = new ArrayList(Math.min(kotlin.i0.r.q(r5, 10), kotlin.i0.r.q(r6, 10)));
        L20:
            if (r8.hasNext() == false) goto L29;
            if (r11.hasNext() == false) goto L29;
            Object r13 = r8.next();
            kotlin.s0.w.d.l0.n.w1.m r14 = (kotlin.s0.w.d.l0.n.w1.m) r11.next();
            kotlin.s0.w.d.l0.n.w1.o r15 = (kotlin.s0.w.d.l0.n.w1.o) r13;
            if (r7.L(r14) == false) goto L26;
            C0518a r16 = new C0518a(null, r10.a(), r15);
        L27:
            r12.add(r16);
            goto L20
        L26:
            kotlin.s0.w.d.l0.n.w1.i r17 = r7.x0(r14);
            r16 = new C0518a(r17, a.a(r9, r17, r10.a()), r15);
        L29:
            return r12;
        L36:
            return null;
        L35:
            return null;
        L34:
            return null;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Iterable<? extends C0518a> invoke(C0518a r1) {
            return a(r1);
        }
    }

    public a() {
    }

    private final i B(i r2, i r3) {
        if (r2 != null) goto L4;
        return r3;
    L4:
        if (r3 != null) goto L7;
        return r2;
    L7:
        if (r2.d() == false) goto L12;
        if (r3.d() == true) goto L12;
        return r3;
    L12:
        if (r2.d() == true) goto L17;
        if (r3.d() == false) goto L17;
        return r2;
    L17:
        if (r2.c().compareTo(r3.c()) >= 0) goto L20;
        return r3;
    L20:
        if (r2.c().compareTo(r3.c()) <= 0) goto L22;
        return r2;
    L22:
        return r3;
    }

    private final List<C0518a> C(kotlin.s0.w.d.l0.n.w1.i r5) {
        kotlin.s0.w.d.l0.n.w1.p r0 = v();
        return f(new C0518a(r5, c(r5, m()), null), new d(this, r0));
    }

    public static final /* synthetic */ x a(a r0, kotlin.s0.w.d.l0.n.w1.i r1, x r2) {
        return r0.c(r1, r2);
    }

    private final x c(kotlin.s0.w.d.l0.n.w1.i r2, x r3) {
        return h().c(r3, i(r2));
    }

    private final e d(kotlin.s0.w.d.l0.n.w1.i r7) {
        h r0 = t(r7);
        f r1 = null;
        if (r0 != null) goto L8;
        kotlin.s0.w.d.l0.n.w1.i r2 = p(r7);
        if (r2 == null) goto L7;
        h r3 = t(r2);
    L9:
        kotlin.s0.w.d.l0.n.w1.p r4 = v();
        kotlin.s0.w.d.l0.b.q.c r5 = kotlin.s0.w.d.l0.b.q.c.f18771a;
        if (r5.l(s(r4.h0(r7))) == false) goto L13;
        r1 = f.f19555f;
    L15:
        boolean r6 = false;
        if (v().C(r7) == false) goto L18;
    L21:
        boolean r8 = true;
    L23:
        if (r3 == r0) goto L26;
        r6 = true;
    L26:
        return new e(r3, r1, r8, r6);
    L18:
        if (A(r7) == true) goto L21;
        r8 = false;
        goto L23
    L13:
        if (r5.k(s(r4.T(r7))) == false) goto L15;
        r1 = f.f19556g;
        goto L15
    L7:
        r3 = null;
        goto L9
    L8:
        r3 = r0;
        goto L9
    }

    private final e e(C0518a r12) {
        h r1 = null;
        if (r12.b() != null) goto L12;
        kotlin.s0.w.d.l0.n.w1.p r0 = v();
        kotlin.s0.w.d.l0.n.w1.o r2 = r12.c();
        if (r2 == null) goto L7;
        u r3 = r0.N(r2);
    L9:
        if (r3 != u.f21187g) goto L12;
        return e.f19549e.a();
    L7:
        r3 = null;
    L12:
        boolean r4 = true;
        if (r12.c() != null) goto L15;
        boolean r5 = true;
    L16:
        kotlin.s0.w.d.l0.n.w1.i r6 = r12.b();
        if (r6 == null) goto L20;
        Iterable<? extends TAnnotation> r7 = i(r6);
        if (r7 == null) goto L20;
    L21:
        kotlin.s0.w.d.l0.n.w1.p r8 = v();
        kotlin.s0.w.d.l0.n.w1.i r9 = r12.b();
        if (r9 == null) goto L26;
        kotlin.s0.w.d.l0.n.w1.n r10 = r8.w(r9);
        if (r10 == null) goto L26;
        kotlin.s0.w.d.l0.n.w1.o r11 = r8.F(r10);
    L28:
        if (l() != kotlin.s0.w.d.l0.e.a.b.f19220k) goto L30;
        boolean r13 = true;
    L31:
        if (r5 == false) goto L51;
        if (r13 == false) goto L35;
    L50:
        r7 = kotlin.i0.r.i0(k(), r7);
        goto L51
    L35:
        if (o() == false) goto L50;
        kotlin.s0.w.d.l0.n.w1.i r14 = r12.b();
        if (r14 != null) goto L39;
    L41:
        boolean r15 = false;
    L42:
        if (r15 == false) goto L50;
        Iterable<TAnnotation> r16 = k();
        ArrayList r17 = new ArrayList();
        Iterator<TAnnotation> r18 = r16.iterator();
    L45:
        if (r18.hasNext() == false) goto L49;
        TAnnotation r19 = r18.next();
        if ((!h().m(r19)) == false) goto L45;
        r17.add(r19);
        goto L45
    L49:
        r7 = kotlin.i0.r.k0(r17, r7);
        goto L51
    L39:
        if (w(r14) != true) goto L41;
        r15 = true;
    L51:
        f r20 = h().e(r7);
        i r21 = h().f(r7, new c(this));
        if (r21 == null) goto L60;
        h r110 = r21.c();
        if (r21.c() != h.f19561h) goto L57;
        if (r11 == null) goto L57;
    L59:
        return new e(r110, r20, r4, r21.d());
    L57:
        r4 = false;
        goto L59
    L60:
        if (r5 == true) goto L64;
        if (r13 == true) goto L64;
        kotlin.s0.w.d.l0.e.a.b r22 = kotlin.s0.w.d.l0.e.a.b.f19219j;
    L65:
        x r23 = r12.a();
        if (r23 == null) goto L68;
        kotlin.s0.w.d.l0.e.a.q r24 = r23.a(r22);
    L69:
        if (r11 == null) goto L71;
        i r25 = j(r11);
    L73:
        if (r25 == null) goto L76;
        i r26 = i.b(r25, h.f19561h, false, 2, null);
        if (r26 == null) goto L76;
    L79:
        if (r25 == null) goto L81;
        h r27 = r25.c();
    L83:
        if (r27 == h.f19561h) goto L93;
        if (r11 == null) goto L92;
        if (r24 != null) goto L87;
    L89:
        boolean r28 = false;
    L90:
        if (r28 == false) goto L92;
    L87:
        if (r24.c() != true) goto L89;
        r28 = true;
    L92:
        boolean r29 = false;
    L94:
        kotlin.s0.w.d.l0.n.w1.o r111 = r12.c();
        if (r111 == null) goto L101;
        i r112 = j(r111);
        if (r112 == null) goto L101;
        if (r112.c() != h.f19560g) goto L102;
        r112 = i.b(r112, h.f19559f, false, 2, null);
    L102:
        i r113 = B(r112, r26);
        if (r113 == null) goto L105;
        r1 = r113.c();
    L105:
        if (r113 != null) goto L107;
    L109:
        r4 = false;
    L111:
        return new e(r1, r20, r29, r4);
    L107:
        if (r113.d() != true) goto L109;
    L101:
        r112 = null;
    L93:
        r29 = true;
        goto L94
    L81:
        r27 = null;
    L76:
        if (r24 == null) goto L78;
        r26 = r24.d();
        goto L79
    L78:
        r26 = null;
        goto L79
    L71:
        r25 = null;
        goto L73
    L68:
        r24 = null;
    L64:
        r22 = l();
        goto L65
    L30:
        r13 = false;
    L26:
        r11 = null;
    L20:
        r7 = kotlin.i0.r.g();
        goto L21
    L15:
        r5 = false;
        goto L16
    }

    private final <T> List<T> f(T r3, kotlin.n0.c.l<? super T, ? extends Iterable<? extends T>> r4) {
        ArrayList r0 = new ArrayList(1);
        g(r3, r0, r4);
        return r0;
    }

    private final <T> void g(T r2, List<T> r3, kotlin.n0.c.l<? super T, ? extends Iterable<? extends T>> r4) {
        r3.add(r2);
        Iterable<? extends T> r5 = r4.invoke(r2);
        if (r5 == null) goto L8;
        Iterator<? extends T> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        g(r6.next(), r3, r4);
        goto L6
    L10:
        return;
    }

    private final i j(kotlin.s0.w.d.l0.n.w1.o r8) {
        kotlin.s0.w.d.l0.n.w1.p r0 = v();
        if (z(r8) == true) goto L5;
        return null;
    L5:
        List<kotlin.s0.w.d.l0.n.w1.i> r9 = r0.B0(r8);
        boolean r1 = r9 instanceof Collection;
        boolean r3 = false;
        if (r1 == true) goto L8;
    L10:
        Iterator<T> r5 = r9.iterator();
    L12:
        if (r5.hasNext() == false) goto L9;
        if (r0.Y((kotlin.s0.w.d.l0.n.w1.i) r5.next()) == true) goto L12;
        boolean r6 = false;
    L16:
        if (r6 == false) goto L18;
        return null;
    L18:
        if (r1 == true) goto L20;
    L22:
        Iterator<T> r7 = r9.iterator();
    L24:
        if (r7.hasNext() == false) goto L21;
        if (t((kotlin.s0.w.d.l0.n.w1.i) r7.next()) == null) goto L28;
        boolean r10 = true;
    L29:
        if (r10 == false) goto L24;
        boolean r11 = true;
    L31:
        if (r11 == false) goto L33;
        List<kotlin.s0.w.d.l0.n.w1.i> r2 = r9;
    L54:
        if ((r2 instanceof Collection) == true) goto L56;
    L58:
        Iterator<T> r12 = r2.iterator();
    L60:
        if (r12.hasNext() == false) goto L57;
        if (r0.p0((kotlin.s0.w.d.l0.n.w1.i) r12.next()) == true) goto L60;
        boolean r13 = false;
    L64:
        if (r13 == false) goto L66;
        h r14 = h.f19560g;
    L68:
        if (r2 == r9) goto L71;
        r3 = true;
    L71:
        return new i(r14, r3);
    L66:
        r14 = h.f19561h;
    L57:
        r13 = true;
        goto L64
    L56:
        if (r2.isEmpty() == false) goto L58;
    L33:
        if (r1 == true) goto L35;
    L37:
        Iterator<T> r4 = r9.iterator();
    L39:
        if (r4.hasNext() == false) goto L36;
        if (p((kotlin.s0.w.d.l0.n.w1.i) r4.next()) == null) goto L43;
        boolean r15 = true;
    L44:
        if (r15 == false) goto L39;
        boolean r16 = true;
    L46:
        if (r16 == false) goto L72;
        r2 = new ArrayList();
        Iterator<T> r17 = r9.iterator();
    L49:
        if (r17.hasNext() == false) goto L54;
        kotlin.s0.w.d.l0.n.w1.i r18 = p((kotlin.s0.w.d.l0.n.w1.i) r17.next());
        if (r18 == null) goto L49;
        r2.add(r18);
        goto L49
    L72:
        return null;
    L43:
        r15 = false;
    L36:
        r16 = false;
        goto L46
    L35:
        if (r9.isEmpty() == false) goto L37;
    L28:
        r10 = false;
    L21:
        r11 = false;
        goto L31
    L20:
        if (r9.isEmpty() == false) goto L22;
    L9:
        r6 = true;
        goto L16
    L8:
        if (r9.isEmpty() == false) goto L10;
        goto L9
    }

    private final h t(kotlin.s0.w.d.l0.n.w1.i r2) {
        kotlin.s0.w.d.l0.n.w1.p r1 = v();
        if (r1.W(r1.h0(r2)) == false) goto L6;
        return h.f19560g;
    L6:
        if (r1.W(r1.T(r2)) == false) goto L11;
        return null;
    L11:
        return h.f19561h;
    }

    public abstract boolean A(kotlin.s0.w.d.l0.n.w1.i r1);

    public final kotlin.n0.c.l<Integer, e> b(kotlin.s0.w.d.l0.n.w1.i r10, Iterable<? extends kotlin.s0.w.d.l0.n.w1.i> r11, q r12, boolean r13) {
        kotlin.n0.d.o.f(r10, "<this>");
        kotlin.n0.d.o.f(r11, "overrides");
        List<C0518a> r0 = C(r10);
        ArrayList r1 = new ArrayList(kotlin.i0.r.q(r11, 10));
        Iterator<? extends kotlin.s0.w.d.l0.n.w1.i> r2 = r11.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        r1.add(C(r2.next()));
        goto L4
    L7:
        if (q() == false) goto L9;
    L24:
        boolean r14 = true;
    L25:
        if (r14 == false) goto L27;
        int r15 = 1;
    L28:
        e[] r16 = new e[r15];
        int r3 = 0;
    L29:
        if (r3 >= r15) goto L53;
        e r5 = e(r0.get(r3));
        ArrayList r6 = new ArrayList();
        Iterator r7 = r1.iterator();
    L32:
        if (r7.hasNext() == false) goto L41;
        C0518a r8 = (C0518a) kotlin.i0.r.S((List) r7.next(), r3);
        if (r8 == null) goto L38;
        kotlin.s0.w.d.l0.n.w1.i r9 = r8.b();
        if (r9 == null) goto L38;
        e r17 = d(r9);
    L39:
        if (r17 == null) goto L32;
        r6.add(r17);
    L38:
        r17 = null;
        goto L39
    L41:
        if (r3 == 0) goto L43;
    L45:
        boolean r18 = false;
    L46:
        if (r3 == 0) goto L48;
    L50:
        boolean r19 = false;
    L51:
        r16[r3] = s.a(r5, r6, r18, r19, r13);
        r3 = r3 + 1;
        goto L29
    L48:
        if (n() == false) goto L50;
        r19 = true;
        goto L51
    L43:
        if (x() == false) goto L45;
        r18 = true;
        goto L46
    L53:
        return new b(r12, r16);
    L27:
        r15 = r0.size();
        goto L28
    L9:
        if (x() == true) goto L11;
    L23:
        r14 = false;
        goto L25
    L11:
        if ((r11 instanceof Collection) == true) goto L13;
    L15:
        Iterator<? extends kotlin.s0.w.d.l0.n.w1.i> r110 = r11.iterator();
    L17:
        if (r110.hasNext() == false) goto L14;
        if ((!y(r10, r110.next())) == false) goto L17;
        boolean r111 = true;
    L21:
        if (r111 == false) goto L23;
    L14:
        r111 = false;
        goto L21
    L13:
        if (((Collection) r11).isEmpty() == false) goto L15;
        goto L14
    }

    public abstract kotlin.s0.w.d.l0.e.a.a<TAnnotation> h();

    public abstract Iterable<TAnnotation> i(kotlin.s0.w.d.l0.n.w1.i r1);

    public abstract Iterable<TAnnotation> k();

    public abstract kotlin.s0.w.d.l0.e.a.b l();

    public abstract x m();

    public abstract boolean n();

    public abstract boolean o();

    public abstract kotlin.s0.w.d.l0.n.w1.i p(kotlin.s0.w.d.l0.n.w1.i r1);

    public boolean q() {
        return false;
    }

    public abstract boolean r(TAnnotation r1);

    public abstract kotlin.s0.w.d.l0.g.d s(kotlin.s0.w.d.l0.n.w1.i r1);

    public abstract boolean u();

    public abstract kotlin.s0.w.d.l0.n.w1.p v();

    public abstract boolean w(kotlin.s0.w.d.l0.n.w1.i r1);

    public abstract boolean x();

    public abstract boolean y(kotlin.s0.w.d.l0.n.w1.i r1, kotlin.s0.w.d.l0.n.w1.i r2);

    public abstract boolean z(kotlin.s0.w.d.l0.n.w1.o r1);
}
