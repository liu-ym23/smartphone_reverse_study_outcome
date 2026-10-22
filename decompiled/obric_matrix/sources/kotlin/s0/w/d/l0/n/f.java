package kotlin.s0.w.d.l0.n;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f20979a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f20980b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20981a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f20982b = null;

        static {
            int[] r0 = new int[kotlin.s0.w.d.l0.n.w1.u.values().length];
            r0[kotlin.s0.w.d.l0.n.w1.u.f21189i.ordinal()] = 1;
            r0[kotlin.s0.w.d.l0.n.w1.u.f21188h.ordinal()] = 2;
            r0[kotlin.s0.w.d.l0.n.w1.u.f21187g.ordinal()] = 3;
            f20981a = r0;
            int[] r1 = new int[d1.b.values().length];
            r1[d1.b.f20968f.ordinal()] = 1;
            r1[d1.b.f20969g.ordinal()] = 2;
            r1[d1.b.f20970h.ordinal()] = 3;
            f20982b = r1;
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.l<d1.a, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List<kotlin.s0.w.d.l0.n.w1.k> f20983f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d1 f20984g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.n.w1.p f20985h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.n.w1.k f20986i;

        static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<Boolean> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ d1 f20987f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ kotlin.s0.w.d.l0.n.w1.p f20988g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ kotlin.s0.w.d.l0.n.w1.k f20989h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ kotlin.s0.w.d.l0.n.w1.k f20990i;

            a(d1 r1, kotlin.s0.w.d.l0.n.w1.p r2, kotlin.s0.w.d.l0.n.w1.k r3, kotlin.s0.w.d.l0.n.w1.k r4) {
                this.f20987f = r1;
                this.f20988g = r2;
                this.f20989h = r3;
                this.f20990i = r4;
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.n0.c.a
            public final Boolean invoke() {
                return Boolean.valueOf(f.f20979a.q(this.f20987f, this.f20988g.r(this.f20989h), this.f20990i));
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return invoke();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        b(List<? extends kotlin.s0.w.d.l0.n.w1.k> r1, d1 r2, kotlin.s0.w.d.l0.n.w1.p r3, kotlin.s0.w.d.l0.n.w1.k r4) {
            this.f20983f = r1;
            this.f20984g = r2;
            this.f20985h = r3;
            this.f20986i = r4;
            super(1);
        }

        public final void a(d1.a r7) {
            kotlin.n0.d.o.f(r7, "$this$runForkingPoint");
            Iterator<kotlin.s0.w.d.l0.n.w1.k> r0 = this.f20983f.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            kotlin.s0.w.d.l0.n.w1.k r1 = r0.next();
            r7.a(new a(this.f20984g, this.f20985h, r1, this.f20986i));
            goto L4
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(d1.a r1) {
            a(r1);
            return kotlin.f0.f18324a;
        }
    }

    static {
        f20979a = new f();
    }

    private f() {
    }

    private final Boolean a(d1 r4, kotlin.s0.w.d.l0.n.w1.k r5, kotlin.s0.w.d.l0.n.w1.k r6) {
        Boolean r3 = Boolean.TRUE;
        kotlin.s0.w.d.l0.n.w1.p r0 = r4.j();
        if (r0.J(r5) == true) goto L8;
        if (r0.J(r6) == true) goto L8;
        return null;
    L8:
        if (d(r0, r5) == false) goto L13;
        if (d(r0, r6) == false) goto L13;
        return r3;
    L13:
        if (r0.J(r5) == false) goto L18;
        if (e(r0, r4, r5, r6, false) == false) goto L24;
        return r3;
    L24:
        return null;
    L18:
        if (r0.J(r6) == false) goto L24;
        if (c(r0, r5) == false) goto L22;
    L23:
        return r3;
    L22:
        if (e(r0, r4, r6, r5, true) == false) goto L24;
        goto L23
    }

    private static final boolean b(kotlin.s0.w.d.l0.n.w1.p r2, kotlin.s0.w.d.l0.n.w1.k r3) {
        if ((r3 instanceof kotlin.s0.w.d.l0.n.w1.d) == true) goto L5;
        return false;
    L5:
        kotlin.s0.w.d.l0.n.w1.m r4 = r2.S(r2.d0((kotlin.s0.w.d.l0.n.w1.d) r3));
        if (r2.L(r4) == false) goto L8;
        return false;
    L8:
        if (r2.J(r2.T(r2.x0(r4))) == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static final boolean c(kotlin.s0.w.d.l0.n.w1.p r3, kotlin.s0.w.d.l0.n.w1.k r4) {
        kotlin.s0.w.d.l0.n.w1.n r5 = r3.c(r4);
        if ((r5 instanceof kotlin.s0.w.d.l0.n.w1.h) == false) goto L23;
        Collection<kotlin.s0.w.d.l0.n.w1.i> r6 = r3.t(r5);
        if ((r6 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r7 = r6.iterator();
    L11:
        if (r7.hasNext() == false) goto L8;
        kotlin.s0.w.d.l0.n.w1.k r0 = r3.a((kotlin.s0.w.d.l0.n.w1.i) r7.next());
        if (r0 != null) goto L15;
    L17:
        boolean r1 = false;
    L18:
        if (r1 == false) goto L11;
        boolean r8 = true;
    L20:
        if (r8 == false) goto L23;
        return true;
    L15:
        if (r3.J(r0) != true) goto L17;
        r1 = true;
    L8:
        r8 = false;
        goto L20
    L7:
        if (r6.isEmpty() == false) goto L9;
    L23:
        return false;
    }

    private static final boolean d(kotlin.s0.w.d.l0.n.w1.p r1, kotlin.s0.w.d.l0.n.w1.k r2) {
        if (r1.J(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (b(r1, r2) == true) goto L8;
        return false;
    }

    private static final boolean e(kotlin.s0.w.d.l0.n.w1.p r10, d1 r11, kotlin.s0.w.d.l0.n.w1.k r12, kotlin.s0.w.d.l0.n.w1.k r13, boolean r14) {
        Collection<kotlin.s0.w.d.l0.n.w1.i> r15 = r10.v(r12);
        if ((r15 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r16 = r15.iterator();
    L9:
        if (r16.hasNext() == false) goto L19;
        kotlin.s0.w.d.l0.n.w1.i r6 = (kotlin.s0.w.d.l0.n.w1.i) r16.next();
        if (kotlin.n0.d.o.a(r10.w(r6), r10.c(r13)) == true) goto L17;
        if (r14 == true) goto L14;
    L16:
        boolean r0 = false;
    L18:
        if (r0 == false) goto L9;
        return true;
    L14:
        if (t(f20979a, r11, r13, r6, false, 8, null) == false) goto L16;
    L17:
        r0 = true;
    L19:
        return false;
    L5:
        if (r15.isEmpty() == false) goto L7;
        goto L7
    }

    private final Boolean f(d1 r16, kotlin.s0.w.d.l0.n.w1.k r17, kotlin.s0.w.d.l0.n.w1.k r18) {
        Boolean r9 = Boolean.TRUE;
        kotlin.s0.w.d.l0.n.w1.p r10 = r16.j();
        boolean r11 = false;
        if (r10.Y(r17) == true) goto L90;
        if (r10.Y(r18) == true) goto L90;
        if (r10.w0(r17) == false) goto L19;
        if (r10.w0(r18) == false) goto L19;
        if (f20979a.p(r10, r17, r18) == false) goto L14;
    L15:
        r11 = true;
    L17:
        return Boolean.valueOf(r11);
    L14:
        if (r16.n() == false) goto L17;
    L19:
        if (r10.n0(r17) == false) goto L21;
    L88:
        boolean r0 = r16.n();
    L51:
        return Boolean.valueOf(r0);
    L21:
        if (r10.n0(r18) == true) goto L88;
        kotlin.s0.w.d.l0.n.w1.e r1 = r10.s0(r18);
        if (r1 == null) goto L27;
        kotlin.s0.w.d.l0.n.w1.k r2 = r10.H(r1);
        if (r2 == null) goto L27;
    L28:
        kotlin.s0.w.d.l0.n.w1.d r3 = r10.f(r2);
        if (r3 == null) goto L31;
        kotlin.s0.w.d.l0.n.w1.i r4 = r10.U(r3);
    L32:
        if (r3 == null) goto L53;
        if (r4 == null) goto L53;
        if (r10.W(r18) == false) goto L39;
        r4 = r10.G(r4, true);
    L37:
        kotlin.s0.w.d.l0.n.w1.i r5 = r4;
        int r6 = a.f20982b[r16.g(r17, r3).ordinal()];
        if (r6 != 1) goto L44;
        r0 = t(f20979a, r16, r17, r5, false, 8, null);
        goto L51
    L44:
        if (r6 != 2) goto L53;
        if (t(f20979a, r16, r17, r5, false, 8, null) == false) goto L53;
        return r9;
    L39:
        if (r10.C(r18) == false) goto L37;
        r4 = r10.Q(r4);
    L53:
        kotlin.s0.w.d.l0.n.w1.n r7 = r10.c(r18);
        if (r10.Z(r7) == false) goto L67;
        r10.W(r18);
        Collection<kotlin.s0.w.d.l0.n.w1.i> r8 = r10.t(r7);
        if ((r8 instanceof Collection) == true) goto L58;
    L60:
        Iterator<T> r12 = r8.iterator();
    L62:
        if (r12.hasNext() == false) goto L59;
        if (t(f20979a, r16, r17, (kotlin.s0.w.d.l0.n.w1.i) r12.next(), false, 8, null) == true) goto L62;
    L66:
        return Boolean.valueOf(r11);
    L59:
        r11 = true;
        goto L66
    L58:
        if (r8.isEmpty() == false) goto L60;
    L67:
        kotlin.s0.w.d.l0.n.w1.n r13 = r10.c(r17);
        if ((r17 instanceof kotlin.s0.w.d.l0.n.w1.d) == false) goto L70;
    L82:
        kotlin.s0.w.d.l0.n.w1.o r14 = f20979a.m(r16.j(), r18, r17);
        if (r14 != null) goto L85;
    L87:
        return null;
    L85:
        if (r10.o(r14, r10.c(r18)) == false) goto L87;
        return r9;
    L70:
        if (r10.Z(r13) == false) goto L87;
        Collection<kotlin.s0.w.d.l0.n.w1.i> r15 = r10.t(r13);
        if ((r15 instanceof Collection) == true) goto L74;
    L76:
        Iterator<T> r19 = r15.iterator();
    L78:
        if (r19.hasNext() == false) goto L75;
        if ((((kotlin.s0.w.d.l0.n.w1.i) r19.next()) instanceof kotlin.s0.w.d.l0.n.w1.d) == true) goto L78;
    L81:
        if (r11 == false) goto L87;
    L75:
        r11 = true;
        goto L81
    L74:
        if (r15.isEmpty() == false) goto L76;
    L31:
        r4 = null;
    L27:
        r2 = r18;
    L90:
        if (r16.m() == false) goto L93;
        return r9;
    L93:
        if (r10.W(r17) == true) goto L95;
    L98:
        r0 = d.f20949a.b(r10, r10.d(r17, false), r10.d(r18, false));
        goto L51
    L95:
        if (r10.W(r18) == true) goto L98;
        return Boolean.FALSE;
    }

    private final List<kotlin.s0.w.d.l0.n.w1.k> g(d1 r12, kotlin.s0.w.d.l0.n.w1.k r13, kotlin.s0.w.d.l0.n.w1.n r14) {
        kotlin.s0.w.d.l0.n.w1.p r11 = r12.j();
        List<kotlin.s0.w.d.l0.n.w1.k> r0 = r11.n(r13, r14);
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (r11.V(r14) == true) goto L12;
        if (r11.v0(r13) == false) goto L12;
        return kotlin.i0.r.g();
    L12:
        if (r11.u0(r14) == true) goto L14;
        kotlin.s0.w.d.l0.p.e r1 = new kotlin.s0.w.d.l0.p.e();
        r12.k();
        ArrayDeque<kotlin.s0.w.d.l0.n.w1.k> r2 = r12.h();
        kotlin.n0.d.o.c(r2);
        Set<kotlin.s0.w.d.l0.n.w1.k> r3 = r12.i();
        kotlin.n0.d.o.c(r3);
        r2.push(r13);
    L24:
        if ((!r2.isEmpty()) == false) goto L51;
        if (r3.size() > 1000) goto L50;
        kotlin.s0.w.d.l0.n.w1.k r4 = r2.pop();
        kotlin.n0.d.o.e(r4, "current");
        if (r3.add(r4) == false) goto L24;
        kotlin.s0.w.d.l0.n.w1.k r5 = r11.r0(r4, kotlin.s0.w.d.l0.n.w1.b.f21182f);
        if (r5 != null) goto L33;
        r5 = r4;
    L33:
        if (r11.A0(r11.c(r5), r14) == false) goto L36;
        r1.add(r5);
        d1.c r6 = d1.c.C0576c.f20973a;
    L40:
        if ((!kotlin.n0.d.o.a(r6, d1.c.C0576c.f20973a)) == true) goto L43;
        r6 = null;
    L43:
        if (r6 == null) goto L24;
        kotlin.s0.w.d.l0.n.w1.p r7 = r12.j();
        Iterator<kotlin.s0.w.d.l0.n.w1.i> r8 = r7.t(r7.c(r4)).iterator();
    L47:
        if (r8.hasNext() == false) goto L24;
        r2.add(r6.a(r12, r8.next()));
        goto L47
    L36:
        if (r11.j(r5) != 0) goto L38;
        r6 = d1.c.b.f20972a;
        goto L40
    L38:
        r6 = r12.j().A(r5);
        goto L40
    L50:
        throw new IllegalStateException(("Too many supertypes for type: " + r13 + ". Supertypes = " + kotlin.i0.r.Z(r3, null, null, null, 0, null, null, 63, null)).toString());
    L51:
        r12.e();
        return r1;
    L14:
        if (r11.A0(r11.c(r13), r14) == false) goto L21;
        kotlin.s0.w.d.l0.n.w1.k r15 = r11.r0(r13, kotlin.s0.w.d.l0.n.w1.b.f21182f);
        if (r15 == null) goto L61;
        r13 = r15;
    L61:
        return kotlin.i0.r.d(r13);
    L21:
        return kotlin.i0.r.g();
    }

    private final List<kotlin.s0.w.d.l0.n.w1.k> h(d1 r1, kotlin.s0.w.d.l0.n.w1.k r2, kotlin.s0.w.d.l0.n.w1.n r3) {
        return w(r1, g(r1, r2, r3));
    }

    private final boolean i(d1 r4, kotlin.s0.w.d.l0.n.w1.i r5, kotlin.s0.w.d.l0.n.w1.i r6, boolean r7) {
        kotlin.s0.w.d.l0.n.w1.p r3 = r4.j();
        kotlin.s0.w.d.l0.n.w1.i r8 = r4.o(r4.p(r5));
        kotlin.s0.w.d.l0.n.w1.i r9 = r4.o(r4.p(r6));
        f r0 = f20979a;
        Boolean r1 = r0.f(r4, r3.h0(r8), r3.T(r9));
        if (r1 == null) goto L6;
        boolean r10 = r1.booleanValue();
        r4.c(r8, r9, r7);
        return r10;
    L6:
        Boolean r11 = r4.c(r8, r9, r7);
        if (r11 == null) goto L11;
        return r11.booleanValue();
    L11:
        return r0.u(r4, r3.h0(r8), r3.T(r9));
    }

    private final kotlin.s0.w.d.l0.n.w1.o m(kotlin.s0.w.d.l0.n.w1.p r8, kotlin.s0.w.d.l0.n.w1.i r9, kotlin.s0.w.d.l0.n.w1.i r10) {
        int r0 = r8.j(r9);
        int r2 = 0;
    L3:
        kotlin.s0.w.d.l0.n.w1.m r3 = null;
        if (r2 >= r0) goto L30;
        kotlin.s0.w.d.l0.n.w1.m r4 = r8.g0(r9, r2);
        boolean r6 = true;
        if ((!r8.L(r4)) == false) goto L8;
        r3 = r4;
    L8:
        if (r3 == null) goto L29;
        kotlin.s0.w.d.l0.n.w1.i r5 = r8.x0(r3);
        if (r5 == null) goto L29;
        if (r8.B(r8.h0(r5)) == true) goto L15;
    L17:
        r6 = false;
    L19:
        if (kotlin.n0.d.o.a(r5, r10) == true) goto L28;
        if (r6 == true) goto L22;
    L24:
        kotlin.s0.w.d.l0.n.w1.o r7 = m(r8, r5, r10);
        if (r7 == null) goto L29;
        return r7;
    L22:
        if (kotlin.n0.d.o.a(r8.w(r5), r8.w(r10)) == false) goto L24;
    L28:
        return r8.D(r8.w(r9), r2);
    L15:
        if (r8.B(r8.h0(r10)) == false) goto L17;
    L29:
        r2 = r2 + 1;
        goto L3
    L30:
        return null;
    }

    private final boolean n(d1 r12, kotlin.s0.w.d.l0.n.w1.k r13) {
        kotlin.s0.w.d.l0.n.w1.p r11 = r12.j();
        kotlin.s0.w.d.l0.n.w1.n r0 = r11.c(r13);
        if (r11.V(r0) == false) goto L7;
        return r11.p(r0);
    L7:
        if (r11.p(r11.c(r13)) == true) goto L47;
        r12.k();
        ArrayDeque<kotlin.s0.w.d.l0.n.w1.k> r1 = r12.h();
        kotlin.n0.d.o.c(r1);
        Set<kotlin.s0.w.d.l0.n.w1.k> r2 = r12.i();
        kotlin.n0.d.o.c(r2);
        r1.push(r13);
    L11:
        if ((!r1.isEmpty()) == false) goto L35;
        if (r2.size() > 1000) goto L34;
        kotlin.s0.w.d.l0.n.w1.k r3 = r1.pop();
        kotlin.n0.d.o.e(r3, "current");
        if (r2.add(r3) == false) goto L11;
        if (r11.v0(r3) == false) goto L19;
        d1.c r4 = d1.c.C0576c.f20973a;
    L21:
        if ((!kotlin.n0.d.o.a(r4, d1.c.C0576c.f20973a)) == true) goto L24;
        r4 = null;
    L24:
        if (r4 == null) goto L11;
        kotlin.s0.w.d.l0.n.w1.p r5 = r12.j();
        Iterator<kotlin.s0.w.d.l0.n.w1.i> r6 = r5.t(r5.c(r3)).iterator();
    L28:
        if (r6.hasNext() == false) goto L11;
        kotlin.s0.w.d.l0.n.w1.k r7 = r4.a(r12, r6.next());
        if (r11.p(r11.c(r7)) == true) goto L31;
        r1.add(r7);
        goto L28
    L31:
        r12.e();
        return true;
    L19:
        r4 = d1.c.b.f20972a;
        goto L21
    L34:
        throw new IllegalStateException(("Too many supertypes for type: " + r13 + ". Supertypes = " + kotlin.i0.r.Z(r2, null, null, null, 0, null, null, 63, null)).toString());
    L35:
        r12.e();
        return false;
    L47:
        return true;
    }

    private final boolean o(kotlin.s0.w.d.l0.n.w1.p r1, kotlin.s0.w.d.l0.n.w1.i r2) {
        if (r1.x(r1.w(r2)) == true) goto L5;
    L13:
        return false;
    L5:
        if (r1.s(r2) == true) goto L13;
        if (r1.C(r2) == true) goto L13;
        if (r1.I(r2) == true) goto L13;
        if (kotlin.n0.d.o.a(r1.c(r1.h0(r2)), r1.c(r1.T(r2))) == false) goto L13;
        return true;
    }

    private final boolean p(kotlin.s0.w.d.l0.n.w1.p r3, kotlin.s0.w.d.l0.n.w1.k r4, kotlin.s0.w.d.l0.n.w1.k r5) {
        kotlin.s0.w.d.l0.n.w1.e r2 = r3.s0(r4);
        if (r2 == null) goto L6;
        kotlin.s0.w.d.l0.n.w1.k r6 = r3.H(r2);
        if (r6 == null) goto L6;
    L7:
        kotlin.s0.w.d.l0.n.w1.e r0 = r3.s0(r5);
        if (r0 == null) goto L11;
        kotlin.s0.w.d.l0.n.w1.k r1 = r3.H(r0);
        if (r1 == null) goto L11;
    L13:
        if (r3.c(r6) == r3.c(r1)) goto L16;
        return false;
    L16:
        if (r3.C(r4) == true) goto L21;
        if (r3.C(r5) == false) goto L21;
        return false;
    L21:
        if (r3.W(r4) == true) goto L23;
        return true;
    L23:
        if (r3.W(r5) == true) goto L27;
        return false;
    L27:
        return true;
    L11:
        r1 = r5;
    L6:
        r6 = r4;
        goto L7
    }

    public static /* synthetic */ boolean t(f r0, d1 r1, kotlin.s0.w.d.l0.n.w1.i r2, kotlin.s0.w.d.l0.n.w1.i r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = false;
    L6:
        return r0.s(r1, r2, r3, r4);
    }

    private final boolean u(d1 r17, kotlin.s0.w.d.l0.n.w1.k r18, kotlin.s0.w.d.l0.n.w1.k r19) {
        kotlin.s0.w.d.l0.n.w1.p r3 = r17.j();
        if (f20980b == true) goto L5;
    L12:
        boolean r5 = false;
        if (c.f20945a.d(r17, r18, r19) == true) goto L15;
        return false;
    L15:
        f r4 = f20979a;
        Boolean r6 = r4.a(r17, r3.h0(r18), r3.T(r19));
        if (r6 == null) goto L19;
        boolean r7 = r6.booleanValue();
        d1.d(r17, r18, r19, false, 4, null);
        return r7;
    L19:
        kotlin.s0.w.d.l0.n.w1.n r8 = r3.c(r19);
        boolean r9 = true;
        if (r3.A0(r3.c(r18), r8) == false) goto L25;
        if (r3.h(r8) != 0) goto L25;
        return true;
    L25:
        if (r3.k0(r3.c(r19)) == false) goto L27;
        return true;
    L27:
        List<kotlin.s0.w.d.l0.n.w1.k> r10 = r4.l(r17, r18, r8);
        int r11 = 10;
        ArrayList r12 = new ArrayList(kotlin.i0.r.q(r10, 10));
        Iterator<T> r13 = r10.iterator();
    L29:
        if (r13.hasNext() == false) goto L35;
        kotlin.s0.w.d.l0.n.w1.k r14 = (kotlin.s0.w.d.l0.n.w1.k) r13.next();
        kotlin.s0.w.d.l0.n.w1.k r15 = r3.a(r17.o(r14));
        if (r15 == null) goto L34;
        r14 = r15;
    L34:
        r12.add(r14);
        goto L29
    L35:
        int r16 = r12.size();
        if (r16 == 0) goto L77;
        if (r16 == 1) goto L75;
        kotlin.s0.w.d.l0.n.w1.a r20 = new kotlin.s0.w.d.l0.n.w1.a(r3.h(r8));
        int r110 = r3.h(r8);
        int r111 = 0;
        boolean r112 = false;
    L39:
        if (r111 >= r110) goto L67;
        if (r112 == false) goto L42;
    L45:
        r112 = r9;
    L46:
        if (r112 == true) goto L66;
        ArrayList r113 = new ArrayList(kotlin.i0.r.q(r12, r11));
        Iterator r114 = r12.iterator();
    L49:
        if (r114.hasNext() == false) goto L65;
        kotlin.s0.w.d.l0.n.w1.k r115 = (kotlin.s0.w.d.l0.n.w1.k) r114.next();
        kotlin.s0.w.d.l0.n.w1.m r21 = r3.D0(r115, r111);
        if (r21 == null) goto L64;
        if (r3.j0(r21) != kotlin.s0.w.d.l0.n.w1.u.f21189i) goto L55;
        boolean r22 = true;
    L56:
        if (r22 == true) goto L59;
        r21 = null;
    L59:
        if (r21 == null) goto L64;
        kotlin.s0.w.d.l0.n.w1.i r23 = r3.x0(r21);
        if (r23 == null) goto L64;
        r113.add(r23);
        goto L49
    L55:
        r22 = false;
    L64:
        throw new IllegalStateException(("Incorrect type: " + r115 + ", subType: " + r18 + ", superType: " + r19).toString());
    L65:
        r20.add(r3.c0(r3.O(r113)));
    L66:
        r111 = r111 + 1;
        r5 = false;
        r9 = true;
        r11 = 10;
        goto L39
    L42:
        if (r3.N(r3.D(r8, r111)) != kotlin.s0.w.d.l0.n.w1.u.f21188h) goto L45;
        r112 = r5;
        goto L46
    L67:
        if (r112 == true) goto L73;
        if (f20979a.q(r17, r20, r19) == false) goto L73;
        return true;
    L73:
        return r17.q(new b(r12, r17, r3, r19));
    L75:
        return f20979a.q(r17, r3.r((kotlin.s0.w.d.l0.n.w1.k) kotlin.i0.r.P(r12)), r19);
    L77:
        return f20979a.n(r17, r18);
    L5:
        if (r3.b(r18) == true) goto L10;
        if (r3.Z(r3.c(r18)) == true) goto L10;
        r17.l(r18);
    L10:
        if (r3.b(r19) == true) goto L12;
        r17.l(r19);
        goto L12
    }

    private final boolean v(kotlin.s0.w.d.l0.n.w1.p r2, kotlin.s0.w.d.l0.n.w1.i r3, kotlin.s0.w.d.l0.n.w1.i r4, kotlin.s0.w.d.l0.n.w1.n r5) {
        kotlin.s0.w.d.l0.n.w1.k r1 = r2.a(r3);
        if ((r1 instanceof kotlin.s0.w.d.l0.n.w1.d) == false) goto L24;
        kotlin.s0.w.d.l0.n.w1.d r6 = (kotlin.s0.w.d.l0.n.w1.d) r1;
        if (r2.q(r6) == false) goto L7;
        return false;
    L7:
        if (r2.L(r2.S(r2.d0(r6))) == true) goto L10;
        return false;
    L10:
        if (r2.P(r6) == kotlin.s0.w.d.l0.n.w1.b.f21182f) goto L12;
        return false;
    L12:
        kotlin.s0.w.d.l0.n.w1.n r7 = r2.w(r4);
        if ((r7 instanceof kotlin.s0.w.d.l0.n.w1.t) == false) goto L15;
        kotlin.s0.w.d.l0.n.w1.t r8 = (kotlin.s0.w.d.l0.n.w1.t) r7;
    L16:
        if (r8 != null) goto L18;
        return false;
    L18:
        kotlin.s0.w.d.l0.n.w1.o r9 = r2.m0(r8);
        if (r9 != null) goto L21;
        return false;
    L21:
        if (r2.o(r9, r5) == true) goto L23;
        return false;
    L23:
        return true;
    L15:
        r8 = null;
        goto L16
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<kotlin.s0.w.d.l0.n.w1.k> w(d1 r9, List<? extends kotlin.s0.w.d.l0.n.w1.k> r10) {
        kotlin.s0.w.d.l0.n.w1.p r8 = r9.j();
        if (r10.size() >= 2) goto L5;
        return r10;
    L5:
        ArrayList r11 = new ArrayList();
        Iterator r0 = r10.iterator();
    L6:
        boolean r2 = true;
        if (r0.hasNext() == false) goto L20;
        Object r1 = r0.next();
        kotlin.s0.w.d.l0.n.w1.l r3 = r8.r((kotlin.s0.w.d.l0.n.w1.k) r1);
        int r4 = r8.R(r3);
        int r6 = 0;
    L9:
        if (r6 >= r4) goto L17;
        if (r8.M(r8.x0(r8.u(r3, r6))) != null) goto L13;
        boolean r7 = true;
    L14:
        if (r7 == false) goto L15;
        r6 = r6 + 1;
        goto L9
    L15:
        r2 = false;
        goto L17
    L13:
        r7 = false;
    L17:
        if (r2 == false) goto L6;
        r11.add(r1);
        goto L6
    L20:
        if ((!r11.isEmpty()) == true) goto L22;
        return r10;
    L22:
        return r11;
    }

    public final kotlin.s0.w.d.l0.n.w1.u j(kotlin.s0.w.d.l0.n.w1.u r1, kotlin.s0.w.d.l0.n.w1.u r2) {
        kotlin.n0.d.o.f(r1, "declared");
        kotlin.n0.d.o.f(r2, "useSite");
        kotlin.s0.w.d.l0.n.w1.u r0 = kotlin.s0.w.d.l0.n.w1.u.f21189i;
        if (r1 != r0) goto L5;
        return r2;
    L5:
        if (r2 != r0) goto L7;
        return r1;
    L7:
        if (r1 != r2) goto L9;
        return r1;
    L9:
        return null;
    }

    public final boolean k(d1 r11, kotlin.s0.w.d.l0.n.w1.i r12, kotlin.s0.w.d.l0.n.w1.i r13) {
        kotlin.n0.d.o.f(r11, WsConstants.KEY_CONNECTION_STATE);
        kotlin.n0.d.o.f(r12, "a");
        kotlin.n0.d.o.f(r13, "b");
        kotlin.s0.w.d.l0.n.w1.p r10 = r11.j();
        if (r12 != r13) goto L5;
        return true;
    L5:
        f r8 = f20979a;
        if (r8.o(r10, r12) == false) goto L25;
        if (r8.o(r10, r13) == false) goto L25;
        kotlin.s0.w.d.l0.n.w1.i r1 = r11.o(r11.p(r12));
        kotlin.s0.w.d.l0.n.w1.i r2 = r11.o(r11.p(r13));
        kotlin.s0.w.d.l0.n.w1.k r3 = r10.h0(r1);
        if (r10.A0(r10.w(r1), r10.w(r2)) == true) goto L13;
        return false;
    L13:
        if (r10.j(r3) != 0) goto L25;
        if (r10.z(r1) == false) goto L17;
        return true;
    L17:
        if (r10.z(r2) == false) goto L20;
        return true;
    L20:
        if (r10.W(r3) != r10.W(r10.h0(r2))) goto L23;
        return true;
    L23:
        return false;
    L25:
        if (t(r8, r11, r12, r13, false, 8, null) == false) goto L30;
        if (t(r8, r11, r13, r12, false, 8, null) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public final List<kotlin.s0.w.d.l0.n.w1.k> l(d1 r12, kotlin.s0.w.d.l0.n.w1.k r13, kotlin.s0.w.d.l0.n.w1.n r14) {
        kotlin.n0.d.o.f(r12, WsConstants.KEY_CONNECTION_STATE);
        kotlin.n0.d.o.f(r13, "subType");
        kotlin.n0.d.o.f(r14, "superConstructor");
        kotlin.s0.w.d.l0.n.w1.p r11 = r12.j();
        if (r11.v0(r13) == false) goto L7;
        return f20979a.h(r12, r13, r14);
    L7:
        if (r11.V(r14) == false) goto L9;
    L12:
        kotlin.s0.w.d.l0.p.e r0 = new kotlin.s0.w.d.l0.p.e();
        r12.k();
        ArrayDeque<kotlin.s0.w.d.l0.n.w1.k> r1 = r12.h();
        kotlin.n0.d.o.c(r1);
        Set<kotlin.s0.w.d.l0.n.w1.k> r2 = r12.i();
        kotlin.n0.d.o.c(r2);
        r1.push(r13);
    L14:
        if ((!r1.isEmpty()) == false) goto L35;
        if (r2.size() > 1000) goto L34;
        kotlin.s0.w.d.l0.n.w1.k r3 = r1.pop();
        kotlin.n0.d.o.e(r3, "current");
        if (r2.add(r3) == false) goto L14;
        if (r11.v0(r3) == false) goto L22;
        r0.add(r3);
        d1.c r4 = d1.c.C0576c.f20973a;
    L24:
        if ((!kotlin.n0.d.o.a(r4, d1.c.C0576c.f20973a)) == true) goto L27;
        r4 = null;
    L27:
        if (r4 == null) goto L14;
        kotlin.s0.w.d.l0.n.w1.p r5 = r12.j();
        Iterator<kotlin.s0.w.d.l0.n.w1.i> r6 = r5.t(r5.c(r3)).iterator();
    L31:
        if (r6.hasNext() == false) goto L14;
        r1.add(r4.a(r12, r6.next()));
        goto L31
    L22:
        r4 = d1.c.b.f20972a;
        goto L24
    L34:
        throw new IllegalStateException(("Too many supertypes for type: " + r13 + ". Supertypes = " + kotlin.i0.r.Z(r2, null, null, null, 0, null, null, 63, null)).toString());
    L35:
        r12.e();
        ArrayList r15 = new ArrayList();
        Iterator<E> r16 = r0.iterator();
    L37:
        if (r16.hasNext() == false) goto L39;
        kotlin.s0.w.d.l0.n.w1.k r7 = (kotlin.s0.w.d.l0.n.w1.k) r16.next();
        f r8 = f20979a;
        kotlin.n0.d.o.e(r7, "it");
        kotlin.i0.r.v(r15, r8.h(r12, r7, r14));
        goto L37
    L39:
        return r15;
    L9:
        if (r11.q0(r14) == true) goto L12;
        return f20979a.g(r12, r13, r14);
    }

    public final boolean q(d1 r17, kotlin.s0.w.d.l0.n.w1.l r18, kotlin.s0.w.d.l0.n.w1.k r19) {
        kotlin.n0.d.o.f(r17, "<this>");
        kotlin.n0.d.o.f(r18, "capturedSubArguments");
        kotlin.n0.d.o.f(r19, "superType");
        kotlin.s0.w.d.l0.n.w1.p r10 = r17.j();
        kotlin.s0.w.d.l0.n.w1.n r11 = r10.c(r19);
        int r0 = r10.R(r18);
        int r12 = r10.h(r11);
        if (r0 == r12) goto L5;
    L46:
        return false;
    L5:
        if (r0 != r10.j(r19)) goto L46;
        int r14 = 0;
    L9:
        if (r14 >= r12) goto L45;
        kotlin.s0.w.d.l0.n.w1.m r1 = r10.g0(r19, r14);
        if (r10.L(r1) == true) goto L44;
        kotlin.s0.w.d.l0.n.w1.i r3 = r10.x0(r1);
        kotlin.s0.w.d.l0.n.w1.m r2 = r10.u(r18, r14);
        r10.j0(r2);
        kotlin.s0.w.d.l0.n.w1.u r5 = kotlin.s0.w.d.l0.n.w1.u.f21189i;
        kotlin.s0.w.d.l0.n.w1.i r4 = r10.x0(r2);
        f r6 = f20979a;
        kotlin.s0.w.d.l0.n.w1.u r7 = r6.j(r10.N(r10.D(r11, r14)), r10.j0(r1));
        if (r7 == null) goto L15;
        if (r7 == r5) goto L18;
    L22:
        boolean r8 = false;
    L23:
        if (r8 == true) goto L44;
        if (d1.a(r17) > 100) goto L43;
        d1.b(r17, d1.a(r17) + 1);
        int r9 = a.f20981a[r7.ordinal()];
        if (r9 != 1) goto L30;
        boolean r13 = r6.k(r17, r4, r3);
    L39:
        d1.b(r17, d1.a(r17) - 1);
        if (r13 == true) goto L44;
        return false;
    L30:
        if (r9 != 2) goto L32;
        boolean r15 = false;
        int r16 = 8;
        Object r110 = null;
        kotlin.s0.w.d.l0.n.w1.i r20 = r4;
    L37:
        r13 = t(r6, r17, r20, r3, r15, r16, r110);
        goto L39
    L32:
        if (r9 != 3) goto L35;
        r15 = false;
        r16 = 8;
        r110 = null;
        r20 = r3;
        r3 = r4;
        goto L37
    L35:
        throw new kotlin.m();
    L43:
        throw new IllegalStateException(("Arguments depth is too high. Some related argument: " + r4).toString());
    L18:
        if (r6.v(r10, r4, r3, r11) == false) goto L20;
    L21:
        r8 = true;
        goto L23
    L20:
        if (r6.v(r10, r3, r4, r11) == false) goto L22;
    L15:
        return r17.m();
    L44:
        r14 = r14 + 1;
        goto L9
    L45:
        return true;
    }

    public final boolean r(d1 r9, kotlin.s0.w.d.l0.n.w1.i r10, kotlin.s0.w.d.l0.n.w1.i r11) {
        kotlin.n0.d.o.f(r9, WsConstants.KEY_CONNECTION_STATE);
        kotlin.n0.d.o.f(r10, "subType");
        kotlin.n0.d.o.f(r11, "superType");
        return t(this, r9, r10, r11, false, 8, null);
    }

    public final boolean s(d1 r2, kotlin.s0.w.d.l0.n.w1.i r3, kotlin.s0.w.d.l0.n.w1.i r4, boolean r5) {
        kotlin.n0.d.o.f(r2, WsConstants.KEY_CONNECTION_STATE);
        kotlin.n0.d.o.f(r3, "subType");
        kotlin.n0.d.o.f(r4, "superType");
        if (r3 != r4) goto L7;
        return true;
    L7:
        if (r2.f(r3, r4) == true) goto L11;
        return false;
    L11:
        return i(r2, r3, r4, r5);
    }
}
