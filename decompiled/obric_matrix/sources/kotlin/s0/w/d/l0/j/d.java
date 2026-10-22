package kotlin.s0.w.d.l0.j;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.f0;
import kotlin.i0.r;
import kotlin.n0.d.q;
import kotlin.s0.w.d.l0.c.d0;
import kotlin.s0.w.d.l0.c.e1;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.k0;
import kotlin.s0.w.d.l0.c.k1;
import kotlin.s0.w.d.l0.c.l0;
import kotlin.s0.w.d.l0.c.o;
import kotlin.s0.w.d.l0.c.p;
import kotlin.s0.w.d.l0.c.q0;
import kotlin.s0.w.d.l0.c.s0;
import kotlin.s0.w.d.l0.c.t;
import kotlin.s0.w.d.l0.c.t0;
import kotlin.s0.w.d.l0.c.u;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.v0;
import kotlin.s0.w.d.l0.c.w;
import kotlin.s0.w.d.l0.c.w0;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.c.y;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.g0;
import kotlin.s0.w.d.l0.n.g1;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.n1;
import kotlin.s0.w.d.l0.n.q1;
import kotlin.s0.w.d.l0.n.r1;
import kotlin.s0.w.d.l0.n.s1;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends kotlin.s0.w.d.l0.j.c implements kotlin.s0.w.d.l0.j.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.j.g f20452d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlin.h f20453e;

    private final class a implements o<f0, StringBuilder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f20454a;

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.j.d$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0556a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f20455a = null;

            static {
                int[] r0 = new int[l.values().length];
                r0[l.f20499f.ordinal()] = 1;
                r0[l.f20500g.ordinal()] = 2;
                r0[l.f20501h.ordinal()] = 3;
                f20455a = r0;
            }
        }

        public a(d r1) {
            this.f20454a = r1;
        }

        private final void t(t0 r3, StringBuilder r4, String r5) {
            int r0 = C0556a.f20455a[this.f20454a.m0().ordinal()];
            if (r0 != 1) goto L5;
            d.z(this.f20454a, r3, r4);
            r4.append(r5 + " for ");
            d r2 = this.f20454a;
            u0 r6 = r3.B0();
            kotlin.n0.d.o.e(r6, "descriptor.correspondingProperty");
            d.H(r2, r6, r4);
            return;
        L5:
            if (r0 != 2) goto L11;
            p(r3, r4);
            return;
        }

        public void A(j1 r2, StringBuilder r3) {
            kotlin.n0.d.o.f(r2, "descriptor");
            kotlin.n0.d.o.f(r3, "builder");
            d.K(this.f20454a, r2, true, r3, true);
        }

        @Override // kotlin.s0.w.d.l0.c.o
        public /* bridge */ /* synthetic */ f0 a(kotlin.s0.w.d.l0.c.e r1, StringBuilder r2) {
            n(r1, r2);
            return f0.f18324a;
        }

        @Override // kotlin.s0.w.d.l0.c.o
        public /* bridge */ /* synthetic */ f0 b(v0 r1, StringBuilder r2) {
            v(r1, r2);
            return f0.f18324a;
        }

        @Override // kotlin.s0.w.d.l0.c.o
        public /* bridge */ /* synthetic */ f0 c(q0 r1, StringBuilder r2) {
            s(r1, r2);
            return f0.f18324a;
        }

        @Override // kotlin.s0.w.d.l0.c.o
        public /* bridge */ /* synthetic */ f0 d(u0 r1, StringBuilder r2) {
            u(r1, r2);
            return f0.f18324a;
        }

        @Override // kotlin.s0.w.d.l0.c.o
        public /* bridge */ /* synthetic */ f0 e(e1 r1, StringBuilder r2) {
            y(r1, r2);
            return f0.f18324a;
        }

        @Override // kotlin.s0.w.d.l0.c.o
        public /* bridge */ /* synthetic */ f0 f(l0 r1, StringBuilder r2) {
            r(r1, r2);
            return f0.f18324a;
        }

        @Override // kotlin.s0.w.d.l0.c.o
        public /* bridge */ /* synthetic */ f0 g(y r1, StringBuilder r2) {
            p(r1, r2);
            return f0.f18324a;
        }

        @Override // kotlin.s0.w.d.l0.c.o
        public /* bridge */ /* synthetic */ f0 h(kotlin.s0.w.d.l0.c.l r1, StringBuilder r2) {
            o(r1, r2);
            return f0.f18324a;
        }

        @Override // kotlin.s0.w.d.l0.c.o
        public /* bridge */ /* synthetic */ f0 i(w0 r1, StringBuilder r2) {
            w(r1, r2);
            return f0.f18324a;
        }

        @Override // kotlin.s0.w.d.l0.c.o
        public /* bridge */ /* synthetic */ f0 j(h0 r1, StringBuilder r2) {
            q(r1, r2);
            return f0.f18324a;
        }

        @Override // kotlin.s0.w.d.l0.c.o
        public /* bridge */ /* synthetic */ f0 k(j1 r1, StringBuilder r2) {
            A(r1, r2);
            return f0.f18324a;
        }

        @Override // kotlin.s0.w.d.l0.c.o
        public /* bridge */ /* synthetic */ f0 l(x0 r1, StringBuilder r2) {
            x(r1, r2);
            return f0.f18324a;
        }

        @Override // kotlin.s0.w.d.l0.c.o
        public /* bridge */ /* synthetic */ f0 m(f1 r1, StringBuilder r2) {
            z(r1, r2);
            return f0.f18324a;
        }

        public void n(kotlin.s0.w.d.l0.c.e r2, StringBuilder r3) {
            kotlin.n0.d.o.f(r2, "descriptor");
            kotlin.n0.d.o.f(r3, "builder");
            d.A(this.f20454a, r2, r3);
        }

        public void o(kotlin.s0.w.d.l0.c.l r2, StringBuilder r3) {
            kotlin.n0.d.o.f(r2, "constructorDescriptor");
            kotlin.n0.d.o.f(r3, "builder");
            d.C(this.f20454a, r2, r3);
        }

        public void p(y r2, StringBuilder r3) {
            kotlin.n0.d.o.f(r2, "descriptor");
            kotlin.n0.d.o.f(r3, "builder");
            d.D(this.f20454a, r2, r3);
        }

        public void q(h0 r2, StringBuilder r3) {
            kotlin.n0.d.o.f(r2, "descriptor");
            kotlin.n0.d.o.f(r3, "builder");
            d.E(this.f20454a, r2, r3, true);
        }

        public void r(l0 r2, StringBuilder r3) {
            kotlin.n0.d.o.f(r2, "descriptor");
            kotlin.n0.d.o.f(r3, "builder");
            d.F(this.f20454a, r2, r3);
        }

        public void s(q0 r2, StringBuilder r3) {
            kotlin.n0.d.o.f(r2, "descriptor");
            kotlin.n0.d.o.f(r3, "builder");
            d.G(this.f20454a, r2, r3);
        }

        public void u(u0 r2, StringBuilder r3) {
            kotlin.n0.d.o.f(r2, "descriptor");
            kotlin.n0.d.o.f(r3, "builder");
            d.H(this.f20454a, r2, r3);
        }

        public void v(v0 r2, StringBuilder r3) {
            kotlin.n0.d.o.f(r2, "descriptor");
            kotlin.n0.d.o.f(r3, "builder");
            t(r2, r3, "getter");
        }

        public void w(w0 r2, StringBuilder r3) {
            kotlin.n0.d.o.f(r2, "descriptor");
            kotlin.n0.d.o.f(r3, "builder");
            t(r2, r3, "setter");
        }

        public void x(x0 r1, StringBuilder r2) {
            kotlin.n0.d.o.f(r1, "descriptor");
            kotlin.n0.d.o.f(r2, "builder");
            r2.append(r1.getName());
        }

        public void y(e1 r2, StringBuilder r3) {
            kotlin.n0.d.o.f(r2, "descriptor");
            kotlin.n0.d.o.f(r3, "builder");
            d.I(this.f20454a, r2, r3);
        }

        public void z(f1 r2, StringBuilder r3) {
            kotlin.n0.d.o.f(r2, "descriptor");
            kotlin.n0.d.o.f(r3, "builder");
            d.J(this.f20454a, r2, r3, true);
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20456a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f20457b = null;

        static {
            int[] r0 = new int[m.values().length];
            r0[m.f20503f.ordinal()] = 1;
            r0[m.f20504g.ordinal()] = 2;
            f20456a = r0;
            int[] r1 = new int[k.values().length];
            r1[k.f20495f.ordinal()] = 1;
            r1[k.f20496g.ordinal()] = 2;
            r1[k.f20497h.ordinal()] = 3;
            f20457b = r1;
        }
    }

    static final class c extends q implements kotlin.n0.c.l<g1, CharSequence> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f20458f;

        c(d r1) {
            this.f20458f = r1;
            super(1);
        }

        public final CharSequence a(g1 r3) {
            kotlin.n0.d.o.f(r3, "it");
            if (r3.d() == false) goto L5;
            return "*";
        L5:
            d r2 = this.f20458f;
            e0 r0 = r3.b();
            kotlin.n0.d.o.e(r0, "it.type");
            String r4 = r2.w(r0);
            if (r3.a() != r1.f21065h) goto L9;
            return r4;
        L9:
            return r3.a() + ' ' + r4;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ CharSequence invoke(g1 r1) {
            return a(r1);
        }
    }

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.j.d$d, reason: collision with other inner class name */
    static final class C0557d extends q implements kotlin.n0.c.a<d> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f20459f;

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.j.d$d$a */
        static final class a extends q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.j.f, f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final a f20460f = null;

            static {
                f20460f = new a();
            }

            a() {
                super(1);
            }

            public final void a(kotlin.s0.w.d.l0.j.f r4) {
                kotlin.n0.d.o.f(r4, "$this$withOptions");
                r4.a(kotlin.i0.t0.h(r4.m(), r.j(new kotlin.s0.w.d.l0.g.c[]{kotlin.s0.w.d.l0.b.k.a.q, kotlin.s0.w.d.l0.b.k.a.r})));
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ f0 invoke(kotlin.s0.w.d.l0.j.f r1) {
                a(r1);
                return f0.f18324a;
            }
        }

        C0557d(d r1) {
            this.f20459f = r1;
            super(0);
        }

        public final d a() {
            kotlin.s0.w.d.l0.j.c r1 = this.f20459f.y(a.f20460f);
            kotlin.n0.d.o.d(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
            return (d) r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ d invoke() {
            return a();
        }
    }

    static final class e extends q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.k.r.g<?>, CharSequence> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f20461f;

        e(d r1) {
            this.f20461f = r1;
            super(1);
        }

        public final CharSequence a(kotlin.s0.w.d.l0.k.r.g<?> r2) {
            kotlin.n0.d.o.f(r2, "it");
            return d.B(this.f20461f, r2);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ CharSequence invoke(kotlin.s0.w.d.l0.k.r.g<?> r1) {
            return a(r1);
        }
    }

    static final class f extends q implements kotlin.n0.c.l<j1, CharSequence> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final f f20462f = null;

        static {
            f20462f = new f();
        }

        f() {
            super(1);
        }

        public final CharSequence a(j1 r1) {
            return "";
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ CharSequence invoke(j1 r1) {
            return a(r1);
        }
    }

    static final class g extends q implements kotlin.n0.c.l<e0, CharSequence> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f20463f;

        g(d r1) {
            this.f20463f = r1;
            super(1);
        }

        public final CharSequence a(e0 r2) {
            d r1 = this.f20463f;
            kotlin.n0.d.o.e(r2, "it");
            return r1.w(r2);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ CharSequence invoke(e0 r1) {
            return a(r1);
        }
    }

    static final class h extends q implements kotlin.n0.c.l<e0, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final h f20464f = null;

        static {
            f20464f = new h();
        }

        h() {
            super(1);
        }

        public final Object a(e0 r1) {
            kotlin.n0.d.o.f(r1, "it");
            if ((r1 instanceof kotlin.s0.w.d.l0.n.u0) == true) goto L5;
            return r1;
        L5:
            return ((kotlin.s0.w.d.l0.n.u0) r1).X0();
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Object invoke(e0 r1) {
            return a(r1);
        }
    }

    public d(kotlin.s0.w.d.l0.j.g r2) {
        kotlin.n0.d.o.f(r2, "options");
        this.f20452d = r2;
        r2.k0();
        this.f20453e = kotlin.i.b(new C0557d(this));
    }

    public static final /* synthetic */ void A(d r0, kotlin.s0.w.d.l0.c.e r1, StringBuilder r2) {
        r0.Y0(r1, r2);
    }

    private final void A1(StringBuilder r3, s0 r4) {
        s0 r0 = r4.c();
        if (r0 == null) goto L6;
        A1(r3, r0);
        r3.append('.');
        kotlin.s0.w.d.l0.g.f r1 = r4.b().getName();
        kotlin.n0.d.o.e(r1, "possiblyInnerType.classifierDescriptor.name");
        r3.append(v(r1, false));
        if (r3 == null) goto L6;
    L7:
        r3.append(K1(r4.a()));
        return;
    L6:
        kotlin.s0.w.d.l0.n.e1 r2 = r4.b().k();
        kotlin.n0.d.o.e(r2, "possiblyInnerType.classi…escriptor.typeConstructor");
        r3.append(L1(r2));
        goto L7
    }

    public static final /* synthetic */ String B(d r0, kotlin.s0.w.d.l0.k.r.g r1) {
        return r0.c1(r1);
    }

    private final void B1(u0 r11, StringBuilder r12) {
        if (z0() == false) goto L5;
    L19:
        t1(r11, r12, true);
        r12.append(": ");
        e0 r0 = r11.b();
        kotlin.n0.d.o.e(r0, "property.type");
        r12.append(w(r0));
        E1(r11, r12);
        l1(r11, r12);
        List<f1> r13 = r11.getTypeParameters();
        kotlin.n0.d.o.e(r13, "property.typeParameters");
        X1(r13, r12);
        return;
    L5:
        if (y0() == true) goto L18;
        C1(r11, r12);
        List<x0> r1 = r11.r0();
        kotlin.n0.d.o.e(r1, "property.contextReceiverParameters");
        e1(r1, r12);
        u r2 = r11.getVisibility();
        kotlin.n0.d.o.e(r2, "property.visibility");
        W1(r2, r12);
        boolean r3 = false;
        if (f0().contains(kotlin.s0.w.d.l0.j.e.s) == true) goto L9;
    L11:
        boolean r4 = false;
    L12:
        s1(r12, r4, "const");
        o1(r11, r12);
        r1(r11, r12);
        w1(r11, r12);
        if (f0().contains(kotlin.s0.w.d.l0.j.e.t) == true) goto L15;
    L17:
        s1(r12, r3, "lateinit");
        n1(r11, r12);
        goto L18
    L15:
        if (r11.s0() == false) goto L17;
        r3 = true;
        goto L17
    L9:
        if (r11.y() == false) goto L11;
        r4 = true;
    L18:
        S1(this, r11, r12, false, 4, null);
        List<f1> r5 = r11.getTypeParameters();
        kotlin.n0.d.o.e(r5, "property.typeParameters");
        Q1(r5, r12, true);
        D1(r11, r12);
        goto L19
    }

    public static final /* synthetic */ void C(d r0, kotlin.s0.w.d.l0.c.l r1, StringBuilder r2) {
        r0.d1(r1, r2);
    }

    private final void C1(u0 r8, StringBuilder r9) {
        if (f0().contains(kotlin.s0.w.d.l0.j.e.f20470l) == true) goto L5;
        return;
    L5:
        W0(this, r9, r8, null, 2, null);
        w r0 = r8.q0();
        if (r0 == null) goto L8;
        V0(r9, r0, kotlin.s0.w.d.l0.c.o1.e.f18906g);
    L8:
        w r1 = r8.n0();
        if (r1 == null) goto L12;
        V0(r9, r1, kotlin.s0.w.d.l0.c.o1.e.o);
    L12:
        if (m0() != l.f20501h) goto L20;
        v0 r2 = r8.g();
        if (r2 == null) goto L16;
        V0(r9, r2, kotlin.s0.w.d.l0.c.o1.e.f18909j);
    L16:
        w0 r10 = r8.Y();
        if (r10 == null) goto L21;
        V0(r9, r10, kotlin.s0.w.d.l0.c.o1.e.f18910k);
        List<j1> r11 = r10.h();
        kotlin.n0.d.o.e(r11, "setter.valueParameters");
        j1 r12 = (j1) r.o0(r11);
        kotlin.n0.d.o.e(r12, "it");
        V0(r9, r12, kotlin.s0.w.d.l0.c.o1.e.n);
        return;
    L21:
        return;
    }

    public static final /* synthetic */ void D(d r0, y r1, StringBuilder r2) {
        r0.j1(r1, r2);
    }

    private final void D1(kotlin.s0.w.d.l0.c.a r2, StringBuilder r3) {
        x0 r4 = r2.m0();
        if (r4 == null) goto L6;
        V0(r3, r4, kotlin.s0.w.d.l0.c.o1.e.f18911l);
        e0 r5 = r4.b();
        kotlin.n0.d.o.e(r5, "receiver.type");
        r3.append(h1(r5));
        r3.append(".");
        return;
    }

    public static final /* synthetic */ void E(d r0, kotlin.s0.w.d.l0.c.m r1, StringBuilder r2, boolean r3) {
        r0.t1(r1, r2, r3);
    }

    private final void E1(kotlin.s0.w.d.l0.c.a r2, StringBuilder r3) {
        if (n0() == true) goto L5;
        return;
    L5:
        x0 r4 = r2.m0();
        if (r4 == null) goto L9;
        r3.append(" on ");
        e0 r5 = r4.b();
        kotlin.n0.d.o.e(r5, "receiver.type");
        r3.append(w(r5));
        return;
    }

    public static final /* synthetic */ void F(d r0, l0 r1, StringBuilder r2) {
        r0.x1(r1, r2);
    }

    private final void F1(StringBuilder r3, m0 r4) {
        if (kotlin.n0.d.o.a(r4, n1.f21052b) == false) goto L5;
    L23:
        r3.append("???");
        return;
    L5:
        if (n1.k(r4) == true) goto L23;
        if (kotlin.s0.w.d.l0.n.u1.k.o(r4) == false) goto L15;
        if (C0() == false) goto L12;
        kotlin.s0.w.d.l0.n.e1 r5 = r4.O0();
        kotlin.n0.d.o.d(r5, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
        r3.append(g1(((kotlin.s0.w.d.l0.n.u1.i) r5).h(0)));
        return;
    L12:
        r3.append("???");
        return;
    L15:
        if (g0.a(r4) == false) goto L19;
        f1(r3, r4);
        return;
    L19:
        if (Z1(r4) == false) goto L21;
        k1(r3, r4);
        return;
    L21:
        f1(r3, r4);
    }

    public static final /* synthetic */ void G(d r0, q0 r1, StringBuilder r2) {
        r0.z1(r1, r2);
    }

    private final void G1(StringBuilder r2) {
        int r1 = r2.length();
        if (r1 != 0) goto L5;
    L6:
        r2.append(' ');
        return;
    L5:
        if (r2.charAt(r1 - 1) != ' ') goto L6;
    }

    public static final /* synthetic */ void H(d r0, u0 r1, StringBuilder r2) {
        r0.B1(r1, r2);
    }

    private final void H1(kotlin.s0.w.d.l0.c.e r11, StringBuilder r12) {
        if (J0() == false) goto L6;
        return;
    L6:
        if (kotlin.s0.w.d.l0.b.h.m0(r11.s()) == false) goto L8;
        return;
    L8:
        Collection<e0> r0 = r11.k().a();
        kotlin.n0.d.o.e(r0, "klass.typeConstructor.supertypes");
        if (r0.isEmpty() == false) goto L11;
        return;
    L11:
        if (r0.size() == 1) goto L13;
    L15:
        G1(r12);
        r12.append(": ");
        r.X(r0, r12, ", ", null, null, 0, null, new g(this), 60, null);
        return;
    L13:
        if (kotlin.s0.w.d.l0.b.h.b0(r0.iterator().next()) == false) goto L15;
    }

    public static final /* synthetic */ void I(d r0, e1 r1, StringBuilder r2) {
        r0.J1(r1, r2);
    }

    private final void I1(y r2, StringBuilder r3) {
        s1(r3, r2.isSuspend(), "suspend");
    }

    public static final /* synthetic */ void J(d r0, f1 r1, StringBuilder r2, boolean r3) {
        r0.O1(r1, r2, r3);
    }

    private final void J1(e1 r7, StringBuilder r8) {
        W0(this, r8, r7, null, 2, null);
        u r0 = r7.getVisibility();
        kotlin.n0.d.o.e(r0, "typeAlias.visibility");
        W1(r0, r8);
        o1(r7, r8);
        r8.append(m1("typealias"));
        r8.append(" ");
        t1(r7, r8, true);
        List<f1> r1 = r7.u();
        kotlin.n0.d.o.e(r1, "typeAlias.declaredTypeParameters");
        Q1(r1, r8, false);
        X0(r7, r8);
        r8.append(" = ");
        r8.append(w(r7.g0()));
    }

    public static final /* synthetic */ void K(d r0, j1 r1, boolean r2, StringBuilder r3, boolean r4) {
        r0.T1(r1, r2, r3, r4);
    }

    private final void L(StringBuilder r5, kotlin.s0.w.d.l0.c.m r6) {
        if ((r6 instanceof l0) == false) goto L5;
        return;
    L5:
        if ((r6 instanceof q0) == true) goto L32;
        kotlin.s0.w.d.l0.c.m r0 = r6.c();
        if (r0 != null) goto L10;
        return;
    L10:
        if ((r0 instanceof h0) == true) goto L27;
        r5.append(" ");
        r5.append(p1("defined in"));
        r5.append(" ");
        kotlin.s0.w.d.l0.g.d r2 = kotlin.s0.w.d.l0.k.d.m(r0);
        kotlin.n0.d.o.e(r2, "getFqName(containingDeclaration)");
        if (r2.e() == false) goto L14;
        String r3 = "root package";
    L15:
        r5.append(r3);
        if (H0() == true) goto L18;
        return;
    L18:
        if ((r0 instanceof l0) == true) goto L20;
        return;
    L20:
        if ((r6 instanceof p) == false) goto L30;
        String r7 = ((p) r6).getSource().a().getName();
        if (r7 == null) goto L31;
        r5.append(" ");
        r5.append(p1("in file"));
        r5.append(" ");
        r5.append(r7);
        return;
    L31:
        return;
    L30:
        return;
    L14:
        r3 = u(r2);
        goto L15
    L27:
        return;
    }

    private final String L0() {
        return P(">");
    }

    private final void M(StringBuilder r11, List<? extends g1> r12) {
        r.X(r12, r11, ", ", null, null, 0, null, new c(this), 60, null);
    }

    private final boolean M0(e0 r1) {
        if (kotlin.s0.w.d.l0.b.g.q(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (r1.getAnnotations().isEmpty() == false) goto L8;
        return false;
    }

    private final void M1(StringBuilder r2, e0 r3, kotlin.s0.w.d.l0.n.e1 r4) {
        s0 r0 = kotlin.s0.w.d.l0.c.g1.a(r3);
        if (r0 != null) goto L6;
        r2.append(L1(r4));
        r2.append(K1(r3.M0()));
        return;
    L6:
        A1(r2, r0);
    }

    private final String N() {
        m r0 = A0();
        int r1 = b.f20456a[r0.ordinal()];
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L8;
        return "&rarr;";
    L8:
        throw new kotlin.m();
    L10:
        return P("->");
    }

    private final kotlin.s0.w.d.l0.c.e0 N0(d0 r3) {
        if ((r3 instanceof kotlin.s0.w.d.l0.c.e) == true) goto L5;
        kotlin.s0.w.d.l0.c.m r2 = r3.c();
        if ((r2 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L12;
        kotlin.s0.w.d.l0.c.e r4 = (kotlin.s0.w.d.l0.c.e) r2;
    L13:
        if (r4 != null) goto L17;
        return kotlin.s0.w.d.l0.c.e0.f18860g;
    L17:
        if ((r3 instanceof kotlin.s0.w.d.l0.c.b) == false) goto L19;
        kotlin.s0.w.d.l0.c.b r5 = (kotlin.s0.w.d.l0.c.b) r3;
        Collection<? extends kotlin.s0.w.d.l0.c.b> r0 = r5.f();
        kotlin.n0.d.o.e(r0, "this.overriddenDescriptors");
        if ((!r0.isEmpty()) == false) goto L27;
        if (r4.l() == kotlin.s0.w.d.l0.c.e0.f18860g) goto L27;
        return kotlin.s0.w.d.l0.c.e0.f18862i;
    L27:
        if (r4.i() != kotlin.s0.w.d.l0.c.f.f18866g) goto L35;
        if (kotlin.n0.d.o.a(r5.getVisibility(), t.f19159a) == true) goto L35;
        kotlin.s0.w.d.l0.c.e0 r6 = r5.l();
        kotlin.s0.w.d.l0.c.e0 r7 = kotlin.s0.w.d.l0.c.e0.f18863j;
        if (r6 != r7) goto L37;
        return r7;
    L37:
        return kotlin.s0.w.d.l0.c.e0.f18862i;
    L35:
        return kotlin.s0.w.d.l0.c.e0.f18860g;
    L19:
        return kotlin.s0.w.d.l0.c.e0.f18860g;
    L12:
        r4 = null;
        goto L13
    L5:
        if (((kotlin.s0.w.d.l0.c.e) r3).i() != kotlin.s0.w.d.l0.c.f.f18866g) goto L8;
        return kotlin.s0.w.d.l0.c.e0.f18863j;
    L8:
        return kotlin.s0.w.d.l0.c.e0.f18860g;
    }

    static /* synthetic */ void N1(d r0, StringBuilder r1, e0 r2, kotlin.s0.w.d.l0.n.e1 r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r3 = r2.O0();
    L5:
        r0.M1(r1, r2, r3);
    }

    private final boolean O(String r7, String r8) {
        if (kotlin.n0.d.o.a(r7, kotlin.u0.k.w(r8, "?", "", false, 4, null)) == false) goto L5;
    L10:
        return true;
    L5:
        if (kotlin.u0.k.n(r8, "?", false, 2, null) == false) goto L9;
        if (kotlin.n0.d.o.a(r7 + '?', r8) == true) goto L10;
    L9:
        if (kotlin.n0.d.o.a('(' + r7 + ")?", r8) == true) goto L10;
        return false;
    }

    private final boolean O0(kotlin.s0.w.d.l0.c.o1.c r1) {
        return kotlin.n0.d.o.a(r1.e(), kotlin.s0.w.d.l0.b.k.a.s);
    }

    private final void O1(f1 r11, StringBuilder r12, boolean r13) {
        if (r13 == false) goto L5;
        r12.append(P0());
    L5:
        if (F0() == false) goto L7;
        r12.append("/*");
        r12.append(r11.j());
        r12.append("*/ ");
    L7:
        s1(r12, r11.D(), "reified");
        String r0 = r11.n().c();
        boolean r3 = true;
        if (r0.length() <= 0) goto L10;
        boolean r1 = true;
    L11:
        s1(r12, r1, r0);
        W0(this, r12, r11, null, 2, null);
        t1(r11, r12, r13);
        int r2 = r11.getUpperBounds().size();
        if (r2 <= 1) goto L14;
        if (r13 == true) goto L14;
    L15:
        e0 r14 = r11.getUpperBounds().iterator().next();
        if (kotlin.s0.w.d.l0.b.h.i0(r14) == true) goto L29;
        r12.append(" : ");
        kotlin.n0.d.o.e(r14, "upperBound");
        r12.append(w(r14));
    L29:
        if (r13 == false) goto L37;
        r12.append(L0());
        return;
    L37:
        return;
    L14:
        if (r2 == 1) goto L15;
        if (r13 == false) goto L29;
        Iterator<e0> r15 = r11.getUpperBounds().iterator();
    L21:
        if (r15.hasNext() == false) goto L29;
        e0 r4 = r15.next();
        if (kotlin.s0.w.d.l0.b.h.i0(r4) == true) goto L21;
        if (r3 == false) goto L27;
        r12.append(" : ");
    L28:
        kotlin.n0.d.o.e(r4, "upperBound");
        r12.append(w(r4));
        r3 = false;
        goto L21
    L27:
        r12.append(" & ");
        goto L28
    L10:
        r1 = false;
        goto L11
    }

    private final String P(String r1) {
        return A0().b(r1);
    }

    private final String P0() {
        return P("<");
    }

    private final void P1(StringBuilder r3, List<? extends f1> r4) {
        Iterator<? extends f1> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        O1(r5.next(), r3, false);
        if (r5.hasNext() == false) goto L4;
        r3.append(", ");
        goto L4
    }

    private final boolean Q0(kotlin.s0.w.d.l0.c.b r1) {
        return !r1.f().isEmpty();
    }

    private final void Q1(List<? extends f1> r2, StringBuilder r3, boolean r4) {
        if (K0() == false) goto L6;
        return;
    L6:
        if ((!r2.isEmpty()) == false) goto L11;
        r3.append(P0());
        P1(r3, r2);
        r3.append(L0());
        if (r4 == false) goto L12;
        r3.append(" ");
        return;
    L12:
        return;
    }

    private final void R0(StringBuilder r3, kotlin.s0.w.d.l0.n.a r4) {
        m r0 = A0();
        m r1 = m.f20504g;
        if (r0 != r1) goto L5;
        r3.append("<font color=\"808080\"><i>");
    L5:
        r3.append(" /* = ");
        v1(r3, r4.V());
        r3.append(" */");
        if (A0() != r1) goto L9;
        r3.append("</i></font>");
        return;
    }

    private final void R1(k1 r1, StringBuilder r2, boolean r3) {
        if (r3 == true) goto L6;
        if ((r1 instanceof j1) == false) goto L6;
        return;
    L6:
        if (r1.j0() == false) goto L8;
        String r4 = "var";
    L9:
        r2.append(m1(r4));
        r2.append(" ");
        return;
    L8:
        r4 = "val";
        goto L9
    }

    private final void S0(t0 r1, StringBuilder r2) {
        o1(r1, r2);
    }

    static /* synthetic */ void S1(d r0, k1 r1, StringBuilder r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.R1(r1, r2, r3);
    }

    private final void T0(y r6, StringBuilder r7) {
        boolean r2 = false;
        if (r6.isOperator() == false) goto L17;
        Collection<? extends y> r0 = r6.f();
        kotlin.n0.d.o.e(r0, "functionDescriptor.overriddenDescriptors");
        if (r0.isEmpty() == false) goto L7;
    L6:
        boolean r1 = true;
    L13:
        if (r1 == false) goto L15;
    L16:
        boolean r3 = true;
    L19:
        if (r6.isInfix() == false) goto L33;
        Collection<? extends y> r4 = r6.f();
        kotlin.n0.d.o.e(r4, "functionDescriptor.overriddenDescriptors");
        if (r4.isEmpty() == false) goto L23;
    L22:
        boolean r5 = true;
    L29:
        if (r5 == false) goto L31;
    L32:
        r2 = true;
        goto L33
    L31:
        if (R() == false) goto L33;
    L23:
        Iterator<T> r8 = r4.iterator();
    L25:
        if (r8.hasNext() == false) goto L22;
        if (((y) r8.next()).isInfix() == false) goto L25;
        r5 = false;
    L33:
        s1(r7, r6.P(), "tailrec");
        I1(r6, r7);
        s1(r7, r6.isInline(), "inline");
        s1(r7, r2, "infix");
        s1(r7, r3, "operator");
        return;
    L15:
        if (R() == false) goto L17;
    L7:
        Iterator<T> r9 = r0.iterator();
    L9:
        if (r9.hasNext() == false) goto L6;
        if (((y) r9.next()).isOperator() == false) goto L9;
        r1 = false;
    L17:
        r3 = false;
        goto L19
    }

    private final void T1(j1 r10, boolean r11, StringBuilder r12, boolean r13) {
        if (r13 == false) goto L5;
        r12.append(m1("value-parameter"));
        r12.append(" ");
    L5:
        if (F0() == false) goto L7;
        r12.append("/*");
        r12.append(r10.j());
        r12.append("*/ ");
    L7:
        W0(this, r12, r10, null, 2, null);
        s1(r12, r10.b0(), "crossinline");
        s1(r12, r10.X(), "noinline");
        boolean r1 = true;
        if (u0() == false) goto L20;
        kotlin.s0.w.d.l0.c.a r0 = r10.c();
        if ((r0 instanceof kotlin.s0.w.d.l0.c.d) == false) goto L12;
        kotlin.s0.w.d.l0.c.d r2 = (kotlin.s0.w.d.l0.c.d) r0;
    L13:
        if (r2 != null) goto L15;
    L17:
        boolean r3 = false;
    L18:
        if (r3 == false) goto L20;
        boolean r8 = true;
    L21:
        if (r8 == false) goto L23;
        s1(r12, Q(), "actual");
    L23:
        V1(r10, r11, r12, r13, r8);
        if (W() != null) goto L26;
    L31:
        r1 = false;
    L32:
        if (r1 == false) goto L35;
        StringBuilder r14 = new StringBuilder();
        r14.append(" = ");
        kotlin.n0.c.l<j1, String> r9 = W();
        kotlin.n0.d.o.c(r9);
        r14.append(r9.invoke(r10));
        r12.append(r14.toString());
        return;
    L35:
        return;
    L26:
        if (n() == false) goto L28;
        boolean r15 = r10.u0();
    L29:
        if (r15 == false) goto L31;
    L28:
        r15 = kotlin.s0.w.d.l0.k.t.a.a(r10);
        goto L29
    L15:
        if (r2.z() != true) goto L17;
        r3 = true;
        goto L18
    L12:
        r2 = null;
    L20:
        r8 = false;
        goto L21
    }

    private final List<String> U0(kotlin.s0.w.d.l0.c.o1.c r8) {
        Map<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.k.r.g<?>> r0 = r8.a();
        List r2 = null;
        if (r0() == false) goto L5;
        kotlin.s0.w.d.l0.c.e r9 = kotlin.s0.w.d.l0.k.t.a.e(r8);
    L7:
        if (r9 == null) goto L23;
        kotlin.s0.w.d.l0.c.d r10 = r9.Q();
        if (r10 == null) goto L23;
        List<j1> r11 = r10.h();
        if (r11 == null) goto L23;
        ArrayList r3 = new ArrayList();
        Iterator<T> r12 = r11.iterator();
    L14:
        if (r12.hasNext() == false) goto L18;
        Object r4 = r12.next();
        if (((j1) r4).u0() == false) goto L14;
        r3.add(r4);
        goto L14
    L18:
        ArrayList r13 = new ArrayList(r.q(r3, 10));
        Iterator r5 = r3.iterator();
    L20:
        if (r5.hasNext() == false) goto L22;
        r13.add(((j1) r5.next()).getName());
        goto L20
    L22:
        r2 = r13;
    L23:
        if (r2 != null) goto L25;
        r2 = r.g();
    L25:
        ArrayList r14 = new ArrayList();
        Iterator r6 = r2.iterator();
    L27:
        if (r6.hasNext() == false) goto L31;
        Object r7 = r6.next();
        kotlin.s0.w.d.l0.g.f r15 = (kotlin.s0.w.d.l0.g.f) r7;
        kotlin.n0.d.o.e(r15, "it");
        if ((!r0.containsKey(r15)) == false) goto L27;
        r14.add(r7);
        goto L27
    L31:
        ArrayList r16 = new ArrayList(r.q(r14, 10));
        Iterator r17 = r14.iterator();
    L33:
        if (r17.hasNext() == false) goto L35;
        r16.add(((kotlin.s0.w.d.l0.g.f) r17.next()).b() + " = ...");
        goto L33
    L35:
        Set<Map.Entry<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.k.r.g<?>>> r18 = r0.entrySet();
        ArrayList r1 = new ArrayList(r.q(r18, 10));
        Iterator<T> r19 = r18.iterator();
    L37:
        if (r19.hasNext() == false) goto L44;
        Map.Entry r20 = (Map.Entry) r19.next();
        kotlin.s0.w.d.l0.g.f r21 = (kotlin.s0.w.d.l0.g.f) r20.getKey();
        kotlin.s0.w.d.l0.k.r.g<?> r22 = (kotlin.s0.w.d.l0.k.r.g) r20.getValue();
        StringBuilder r23 = new StringBuilder();
        r23.append(r21.b());
        r23.append(" = ");
        if (r2.contains(r21) == true) goto L41;
        String r24 = c1(r22);
    L42:
        r23.append(r24);
        r1.add(r23.toString());
        goto L37
    L41:
        r24 = "...";
        goto L42
    L44:
        return r.r0(r.k0(r16, r1));
    L5:
        r9 = null;
        goto L7
    }

    private final void U1(Collection<? extends j1> r7, boolean r8, StringBuilder r9) {
        boolean r10 = a2(r8);
        int r0 = r7.size();
        E0().b(r0, r9);
        Iterator<? extends j1> r11 = r7.iterator();
        int r2 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        j1 r4 = r11.next();
        E0().a(r4, r2, r0, r9);
        T1(r4, r10, r9, false);
        E0().d(r4, r2, r0, r9);
        r2 = r2 + 1;
        goto L4
    L6:
        E0().c(r0, r9);
    }

    private final void V0(StringBuilder r5, kotlin.s0.w.d.l0.c.o1.a r6, kotlin.s0.w.d.l0.c.o1.e r7) {
        if (f0().contains(kotlin.s0.w.d.l0.j.e.f20470l) == true) goto L6;
        return;
    L6:
        if ((r6 instanceof e0) == false) goto L8;
        Set<kotlin.s0.w.d.l0.g.c> r0 = m();
    L9:
        kotlin.n0.c.l<kotlin.s0.w.d.l0.c.o1.c, Boolean> r1 = S();
        Iterator<kotlin.s0.w.d.l0.c.o1.c> r8 = r6.getAnnotations().iterator();
    L11:
        if (r8.hasNext() == false) goto L23;
        kotlin.s0.w.d.l0.c.o1.c r2 = r8.next();
        if (r.J(r0, r2.e()) == true) goto L11;
        if (O0(r2) == true) goto L11;
        if (r1 == null) goto L19;
        if (r1.invoke(r2).booleanValue() == false) goto L11;
    L19:
        r5.append(r(r2, r7));
        if (X() == true) goto L21;
        r5.append(" ");
        goto L11
    L21:
        r5.append('\n');
        kotlin.n0.d.o.e(r5, "append('\\n')");
        goto L11
    L23:
        return;
    L8:
        r0 = Y();
        goto L9
    }

    private final void V1(k1 r6, boolean r7, StringBuilder r8, boolean r9, boolean r10) {
        e0 r0 = r6.b();
        kotlin.n0.d.o.e(r0, "variable.type");
        e0 r2 = null;
        if ((r6 instanceof j1) == false) goto L5;
        j1 r1 = (j1) r6;
    L6:
        if (r1 == null) goto L8;
        r2 = r1.l0();
    L8:
        if (r2 != null) goto L10;
        e0 r3 = r0;
    L11:
        if (r2 == null) goto L13;
        boolean r4 = true;
    L14:
        s1(r8, r4, "vararg");
        if (r10 == true) goto L19;
        if (r9 == true) goto L18;
    L20:
        if (r7 == false) goto L22;
        t1(r6, r8, r9);
        r8.append(": ");
    L22:
        r8.append(w(r3));
        l1(r6, r8);
        if (F0() == false) goto L27;
        if (r2 == null) goto L28;
        r8.append(" /*");
        r8.append(w(r0));
        r8.append("*/");
        return;
    L28:
        return;
    L27:
        return;
    L18:
        if (z0() == true) goto L20;
    L19:
        R1(r6, r8, r10);
        goto L20
    L13:
        r4 = false;
        goto L14
    L10:
        r3 = r2;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    static /* synthetic */ void W0(d r0, StringBuilder r1, kotlin.s0.w.d.l0.c.o1.a r2, kotlin.s0.w.d.l0.c.o1.e r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r3 = null;
    L5:
        r0.V0(r1, r2, r3);
    }

    private final boolean W1(u r3, StringBuilder r4) {
        if (f0().contains(kotlin.s0.w.d.l0.j.e.f20467i) == true) goto L6;
        return false;
    L6:
        if (g0() == false) goto L9;
        r3 = r3.f();
    L9:
        if (t0() == false) goto L11;
    L13:
        r4.append(m1(r3.c()));
        r4.append(" ");
        return true;
    L11:
        if (kotlin.n0.d.o.a(r3, t.f19169k) == false) goto L13;
        return false;
    }

    private final void X0(kotlin.s0.w.d.l0.c.i r4, StringBuilder r5) {
        List<f1> r0 = r4.u();
        kotlin.n0.d.o.e(r0, "classifier.declaredTypeParameters");
        List<f1> r1 = r4.k().getParameters();
        kotlin.n0.d.o.e(r1, "classifier.typeConstructor.parameters");
        if (F0() == true) goto L5;
        return;
    L5:
        if (r4.M() == true) goto L7;
        return;
    L7:
        if (r1.size() <= r0.size()) goto L12;
        r5.append(" /*captured type parameters: ");
        P1(r5, r1.subList(r0.size(), r1.size()));
        r5.append("*/");
        return;
    }

    private final void X1(List<? extends f1> r12, StringBuilder r13) {
        if (K0() == false) goto L5;
        return;
    L5:
        ArrayList r1 = new ArrayList(0);
        Iterator<? extends f1> r14 = r12.iterator();
    L7:
        if (r14.hasNext() == false) goto L13;
        f1 r2 = r14.next();
        List<e0> r4 = r2.getUpperBounds();
        kotlin.n0.d.o.e(r4, "typeParameter.upperBounds");
        Iterator r3 = r.L(r4, 1).iterator();
    L10:
        if (r3.hasNext() == false) goto L7;
        e0 r5 = (e0) r3.next();
        StringBuilder r6 = new StringBuilder();
        kotlin.s0.w.d.l0.g.f r7 = r2.getName();
        kotlin.n0.d.o.e(r7, "typeParameter.name");
        r6.append(v(r7, false));
        r6.append(" : ");
        kotlin.n0.d.o.e(r5, "it");
        r6.append(w(r5));
        r1.add(r6.toString());
        goto L10
    L13:
        if ((!r1.isEmpty()) == false) goto L18;
        r13.append(" ");
        r13.append(m1("where"));
        r13.append(" ");
        r.X(r1, r13, ", ", null, null, 0, null, null, 124, null);
        return;
    }

    private final void Y0(kotlin.s0.w.d.l0.c.e r11, StringBuilder r12) {
        if (r11.i() != kotlin.s0.w.d.l0.c.f.f18868i) goto L5;
        boolean r0 = true;
    L7:
        if (z0() == true) goto L52;
        W0(this, r12, r11, null, 2, null);
        List<x0> r1 = r11.G0();
        kotlin.n0.d.o.e(r1, "klass.contextReceivers");
        e1(r1, r12);
        if (r0 == true) goto L12;
        u r2 = r11.getVisibility();
        kotlin.n0.d.o.e(r2, "klass.visibility");
        W1(r2, r12);
    L12:
        if (r11.i() != kotlin.s0.w.d.l0.c.f.f18866g) goto L16;
        if (r11.l() != kotlin.s0.w.d.l0.c.e0.f18863j) goto L16;
    L20:
        o1(r11, r12);
        if (f0().contains(kotlin.s0.w.d.l0.j.e.m) == true) goto L23;
    L25:
        boolean r3 = false;
    L26:
        s1(r12, r3, "inner");
        if (f0().contains(kotlin.s0.w.d.l0.j.e.o) == true) goto L29;
    L31:
        boolean r4 = false;
    L32:
        s1(r12, r4, "data");
        if (f0().contains(kotlin.s0.w.d.l0.j.e.p) == true) goto L35;
    L37:
        boolean r5 = false;
    L38:
        s1(r12, r5, "inline");
        if (f0().contains(kotlin.s0.w.d.l0.j.e.v) == true) goto L41;
    L43:
        boolean r6 = false;
    L44:
        s1(r12, r6, "value");
        if (f0().contains(kotlin.s0.w.d.l0.j.e.u) == true) goto L47;
    L49:
        boolean r7 = false;
    L50:
        s1(r12, r7, "fun");
        Z0(r11, r12);
        goto L52
    L47:
        if (r11.B() == false) goto L49;
        r7 = true;
        goto L50
    L41:
        if (r11.I() == false) goto L43;
        r6 = true;
        goto L44
    L35:
        if (r11.isInline() == false) goto L37;
        r5 = true;
        goto L38
    L29:
        if (r11.J0() == false) goto L31;
        r4 = true;
        goto L32
    L23:
        if (r11.M() == false) goto L25;
        r3 = true;
    L16:
        if (r11.i().b() == true) goto L18;
    L19:
        kotlin.s0.w.d.l0.c.e0 r8 = r11.l();
        kotlin.n0.d.o.e(r8, "klass.modality");
        q1(r8, r12, N0(r11));
        goto L20
    L18:
        if (r11.l() == kotlin.s0.w.d.l0.c.e0.f18860g) goto L20;
    L52:
        if (kotlin.s0.w.d.l0.k.d.x(r11) == false) goto L54;
        b1(r11, r12);
    L58:
        if (r0 == false) goto L60;
        return;
    L60:
        List<f1> r9 = r11.u();
        kotlin.n0.d.o.e(r9, "klass.declaredTypeParameters");
        Q1(r9, r12, false);
        X0(r11, r12);
        if (r11.i().b() == false) goto L63;
    L67:
        H1(r11, r12);
        X1(r9, r12);
        return;
    L63:
        if (U() == false) goto L67;
        kotlin.s0.w.d.l0.c.d r10 = r11.Q();
        if (r10 == null) goto L67;
        r12.append(" ");
        W0(this, r12, r10, null, 2, null);
        u r13 = r10.getVisibility();
        kotlin.n0.d.o.e(r13, "primaryConstructor.visibility");
        W1(r13, r12);
        r12.append(m1("constructor"));
        List<j1> r14 = r10.h();
        kotlin.n0.d.o.e(r14, "primaryConstructor.valueParameters");
        U1(r14, r10.E(), r12);
        goto L67
    L54:
        if (z0() == true) goto L56;
        G1(r12);
    L56:
        t1(r11, r12, true);
        goto L58
    L5:
        r0 = false;
        goto L7
    }

    private final String Y1(String r5, String r6, String r7, String r8, String r9) {
        if (kotlin.u0.k.A(r5, r6, false, 2, null) == true) goto L5;
    L13:
        return null;
    L5:
        if (kotlin.u0.k.A(r7, r8, false, 2, null) == false) goto L13;
        String r10 = r5.substring(r6.length());
        kotlin.n0.d.o.e(r10, "this as java.lang.String).substring(startIndex)");
        String r11 = r7.substring(r8.length());
        kotlin.n0.d.o.e(r11, "this as java.lang.String).substring(startIndex)");
        String r12 = r9 + r10;
        if (kotlin.n0.d.o.a(r10, r11) == false) goto L10;
        return r12;
    L10:
        if (O(r10, r11) == false) goto L13;
        return r12 + '!';
    }

    private final d Z() {
        return (d) this.f20453e.getValue();
    }

    private final void Z0(kotlin.s0.w.d.l0.c.e r2, StringBuilder r3) {
        r3.append(m1(kotlin.s0.w.d.l0.j.c.f20437a.a(r2)));
    }

    private final boolean Z1(e0 r3) {
        if (kotlin.s0.w.d.l0.b.g.o(r3) == false) goto L21;
        List<g1> r2 = r3.M0();
        if ((r2 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r4 = r2.iterator();
    L11:
        if (r4.hasNext() == false) goto L8;
        if (((g1) r4.next()).d() == false) goto L11;
        boolean r5 = false;
    L15:
        if (r5 == true) goto L17;
        return false;
    L17:
        return true;
    L8:
        r5 = true;
        goto L15
    L7:
        if (r2.isEmpty() == false) goto L9;
    L21:
        return false;
    }

    private final boolean a2(boolean r4) {
        k r3 = j0();
        int r5 = b.f20457b[r3.ordinal()];
        if (r5 == 1) goto L13;
        if (r5 != 2) goto L7;
        if (r4 == false) goto L13;
        return false;
    L7:
        if (r5 != 3) goto L10;
        return false;
    L10:
        throw new kotlin.m();
    L13:
        return true;
    }

    private final void b1(kotlin.s0.w.d.l0.c.m r3, StringBuilder r4) {
        if (o0() == false) goto L11;
        if (z0() == false) goto L7;
        r4.append("companion object");
    L7:
        G1(r4);
        kotlin.s0.w.d.l0.c.m r0 = r3.c();
        if (r0 == null) goto L11;
        r4.append("of ");
        kotlin.s0.w.d.l0.g.f r1 = r0.getName();
        kotlin.n0.d.o.e(r1, "containingDeclaration.name");
        r4.append(v(r1, false));
    L11:
        if (F0() == true) goto L15;
        if (kotlin.n0.d.o.a(r3.getName(), kotlin.s0.w.d.l0.g.h.f20276c) == false) goto L15;
        return;
    L15:
        if (z0() == true) goto L17;
        G1(r4);
    L17:
        kotlin.s0.w.d.l0.g.f r5 = r3.getName();
        kotlin.n0.d.o.e(r5, "descriptor.name");
        r4.append(v(r5, true));
    }

    private final String c1(kotlin.s0.w.d.l0.k.r.g<?> r10) {
        if ((r10 instanceof kotlin.s0.w.d.l0.k.r.b) == false) goto L6;
        return r.Z(((kotlin.s0.w.d.l0.k.r.b) r10).b(), ", ", "{", "}", 0, null, new e(this), 24, null);
    L6:
        if ((r10 instanceof kotlin.s0.w.d.l0.k.r.a) == false) goto L9;
        return kotlin.u0.k.g0(kotlin.s0.w.d.l0.j.c.s(this, ((kotlin.s0.w.d.l0.k.r.a) r10).b(), null, 2, null), "@");
    L9:
        if ((r10 instanceof kotlin.s0.w.d.l0.k.r.q) == false) goto L22;
        kotlin.s0.w.d.l0.k.r.q.b r9 = ((kotlin.s0.w.d.l0.k.r.q) r10).b();
        if ((r9 instanceof kotlin.s0.w.d.l0.k.r.q.b.a) == false) goto L14;
        return ((kotlin.s0.w.d.l0.k.r.q.b.a) r9).a() + "::class";
    L14:
        if ((r9 instanceof kotlin.s0.w.d.l0.k.r.q.b.C0561b) == false) goto L20;
        kotlin.s0.w.d.l0.k.r.q.b.C0561b r11 = (kotlin.s0.w.d.l0.k.r.q.b.C0561b) r9;
        String r12 = r11.b().b().b();
        kotlin.n0.d.o.e(r12, "classValue.classId.asSingleFqName().asString()");
        int r1 = 0;
    L16:
        if (r1 >= r11.a()) goto L27;
        r12 = "kotlin.Array<" + r12 + '>';
        r1 = r1 + 1;
        goto L16
    L27:
        return r12 + "::class";
    L20:
        throw new kotlin.m();
    L22:
        return r10.toString();
    }

    private final void d1(kotlin.s0.w.d.l0.c.l r18, StringBuilder r19) {
        W0(this, r19, r18, null, 2, null);
        if (this.f20452d.S() == false) goto L5;
    L6:
        u r0 = r18.getVisibility();
        kotlin.n0.d.o.e(r0, "constructor.visibility");
        if (W1(r0, r19) == false) goto L9;
        boolean r1 = true;
    L10:
        n1(r18, r19);
        if (q0() == false) goto L13;
    L17:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L20;
        r19.append(m1("constructor"));
    L20:
        kotlin.s0.w.d.l0.c.i r3 = r18.c();
        kotlin.n0.d.o.e(r3, "constructor.containingDeclaration");
        if (x0() == false) goto L25;
        if (r2 == false) goto L24;
        r19.append(" ");
    L24:
        t1(r3, r19, true);
        List<f1> r4 = r18.getTypeParameters();
        kotlin.n0.d.o.e(r4, "constructor.typeParameters");
        Q1(r4, r19, false);
    L25:
        List<j1> r5 = r18.h();
        kotlin.n0.d.o.e(r5, "constructor.valueParameters");
        U1(r5, r18.E(), r19);
        if (p0() == false) goto L48;
        if (r18.z() == true) goto L48;
        if ((r3 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L48;
        kotlin.s0.w.d.l0.c.d r6 = ((kotlin.s0.w.d.l0.c.e) r3).Q();
        if (r6 == null) goto L48;
        List<j1> r7 = r6.h();
        kotlin.n0.d.o.e(r7, "primaryConstructor.valueParameters");
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r7.iterator();
    L35:
        if (r9.hasNext() == false) goto L45;
        Object r10 = r9.next();
        j1 r11 = (j1) r10;
        if (r11.u0() == false) goto L39;
    L41:
        boolean r12 = false;
    L42:
        if (r12 == false) goto L35;
        r8.add(r10);
        goto L35
    L39:
        if (r11.l0() != null) goto L41;
        r12 = true;
        goto L42
    L45:
        if ((!r8.isEmpty()) == false) goto L48;
        r19.append(" : ");
        r19.append(m1("this"));
        r19.append(r.Z(r8, ", ", "(", ")", 0, null, f.f20462f, 24, null));
    L48:
        if (x0() == false) goto L56;
        List<f1> r13 = r18.getTypeParameters();
        kotlin.n0.d.o.e(r13, "constructor.typeParameters");
        X1(r13, r19);
        return;
    L56:
        return;
    L13:
        if (r18.z() == false) goto L17;
        if (r1 == true) goto L17;
        r2 = false;
    L9:
        r1 = false;
        goto L10
    L5:
        if (r18.A().l() == kotlin.s0.w.d.l0.c.e0.f18861h) goto L9;
        goto L6
    }

    private final void e1(List<? extends x0> r6, StringBuilder r7) {
        if ((!r6.isEmpty()) == false) goto L12;
        r7.append("context(");
        Iterator<? extends x0> r0 = r6.iterator();
        int r1 = 0;
    L6:
        if (r0.hasNext() == false) goto L16;
        int r2 = r1 + 1;
        x0 r3 = r0.next();
        V0(r7, r3, kotlin.s0.w.d.l0.c.o1.e.f18911l);
        e0 r4 = r3.b();
        kotlin.n0.d.o.e(r4, "contextReceiver.type");
        r7.append(h1(r4));
        if (r1 != r.i(r6)) goto L10;
        String r5 = ") ";
    L11:
        r7.append(r5);
        r1 = r2;
        goto L6
    L10:
        r5 = ", ";
        goto L11
    L16:
        return;
    }

    private final void f1(StringBuilder r7, e0 r8) {
        W0(this, r7, r8, null, 2, null);
        m0 r1 = null;
        if ((r8 instanceof kotlin.s0.w.d.l0.n.p) == false) goto L5;
        kotlin.s0.w.d.l0.n.p r0 = (kotlin.s0.w.d.l0.n.p) r8;
    L6:
        if (r0 == null) goto L9;
        r1 = r0.a1();
    L9:
        if (g0.a(r8) == false) goto L23;
        if (kotlin.s0.w.d.l0.n.x1.a.r(r8) == false) goto L16;
        if (l0() == false) goto L16;
    L14:
        String r2 = ((kotlin.s0.w.d.l0.n.u1.h) r8).X0();
    L21:
        r7.append(r2);
        String r6 = K1(r8.M0());
    L26:
        r7.append(r6);
    L32:
        if (r8.P0() == false) goto L35;
        r7.append("?");
    L35:
        if (kotlin.s0.w.d.l0.n.q0.c(r8) == false) goto L38;
        r7.append(" & Any");
        return;
    L38:
        return;
    L16:
        if ((r8 instanceof kotlin.s0.w.d.l0.n.u1.h) == true) goto L18;
    L20:
        r2 = r8.O0().toString();
        goto L21
    L18:
        if (e0() == true) goto L20;
    L23:
        if ((r8 instanceof kotlin.s0.w.d.l0.n.u0) == false) goto L28;
        kotlin.s0.w.d.l0.n.t1.n r9 = ((kotlin.s0.w.d.l0.n.u0) r8).X0();
    L25:
        r6 = r9.toString();
        goto L26
    L28:
        if ((r1 instanceof kotlin.s0.w.d.l0.n.u0) == false) goto L30;
        r9 = ((kotlin.s0.w.d.l0.n.u0) r1).X0();
        goto L25
    L30:
        N1(this, r7, r8, null, 2, null);
        goto L32
    L5:
        r0 = null;
        goto L6
    }

    private final String g1(String r2) {
        int r1 = b.f20456a[A0().ordinal()];
        if (r1 != 1) goto L5;
        return r2;
    L5:
        if (r1 != 2) goto L8;
        return "<font color=red><b>" + r2 + "</b></font>";
    L8:
        throw new kotlin.m();
    }

    private final String h1(e0 r2) {
        String r0 = w(r2);
        if (Z1(r2) == true) goto L5;
        return r0;
    L5:
        if (n1.l(r2) == false) goto L7;
        return r0;
    L7:
        return '(' + r0 + ')';
    }

    private final String i1(List<kotlin.s0.w.d.l0.g.f> r1) {
        return P(n.c(r1));
    }

    private final void j1(y r10, StringBuilder r11) {
        if (z0() == false) goto L5;
    L22:
        t1(r10, r11, true);
        List<j1> r0 = r10.h();
        kotlin.n0.d.o.e(r0, "function.valueParameters");
        U1(r0, r10.E(), r11);
        E1(r10, r11);
        e0 r1 = r10.getReturnType();
        if (I0() == false) goto L25;
    L34:
        List<f1> r12 = r10.getTypeParameters();
        kotlin.n0.d.o.e(r12, "function.typeParameters");
        X1(r12, r11);
        return;
    L25:
        if (D0() == true) goto L29;
        if (r1 == null) goto L29;
        if (kotlin.s0.w.d.l0.b.h.B0(r1) == true) goto L34;
    L29:
        r11.append(": ");
        if (r1 != null) goto L32;
        String r2 = "[NULL]";
    L33:
        r11.append(r2);
        goto L34
    L32:
        r2 = w(r1);
        goto L33
    L5:
        if (y0() == true) goto L21;
        W0(this, r11, r10, null, 2, null);
        List<x0> r3 = r10.r0();
        kotlin.n0.d.o.e(r3, "function.contextReceiverParameters");
        e1(r3, r11);
        u r4 = r10.getVisibility();
        kotlin.n0.d.o.e(r4, "function.visibility");
        W1(r4, r11);
        r1(r10, r11);
        if (a0() == false) goto L9;
        o1(r10, r11);
    L9:
        w1(r10, r11);
        if (a0() == false) goto L12;
        T0(r10, r11);
    L13:
        n1(r10, r11);
        if (F0() == false) goto L21;
        if (r10.w0() == false) goto L19;
        r11.append("/*isHiddenToOvercomeSignatureClash*/ ");
    L19:
        if (r10.C0() == false) goto L21;
        r11.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
        goto L21
    L12:
        I1(r10, r11);
    L21:
        r11.append(m1("fun"));
        r11.append(" ");
        List<f1> r5 = r10.getTypeParameters();
        kotlin.n0.d.o.e(r5, "function.typeParameters");
        Q1(r5, r11, true);
        D1(r10, r11);
        goto L22
    }

    private final void k1(StringBuilder r12, e0 r13) {
        int r0 = r12.length();
        W0(Z(), r12, r13, null, 2, null);
        if (r12.length() == r0) goto L5;
        boolean r1 = true;
    L6:
        e0 r4 = kotlin.s0.w.d.l0.b.g.j(r13);
        List<e0> r5 = kotlin.s0.w.d.l0.b.g.e(r13);
        if ((!r5.isEmpty()) == false) goto L13;
        r12.append("context(");
        Iterator<e0> r6 = r5.subList(0, r.i(r5)).iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        u1(r12, r6.next());
        r12.append(", ");
        goto L10
    L12:
        u1(r12, (e0) r.b0(r5));
        r12.append(") ");
    L13:
        boolean r7 = kotlin.s0.w.d.l0.b.g.q(r13);
        boolean r8 = r13.P0();
        if (r8 == true) goto L19;
        if (r1 == false) goto L18;
        if (r4 != null) goto L19;
    L18:
        boolean r9 = false;
    L21:
        if (r9 == false) goto L29;
        if (r7 == false) goto L24;
        r12.insert(r0, '(');
        goto L29
    L24:
        if (r1 == false) goto L28;
        kotlin.u0.a.c(kotlin.u0.k.J0(r12));
        if (r12.charAt(kotlin.u0.k.K(r12) - 1) == ')') goto L28;
        r12.insert(kotlin.u0.k.K(r12), "()");
    L28:
        r12.append("(");
    L29:
        s1(r12, r7, "suspend");
        if (r4 != null) goto L32;
    L45:
        r12.append("(");
        if (kotlin.s0.w.d.l0.b.g.m(r13) == true) goto L48;
    L50:
        Iterator<g1> r2 = kotlin.s0.w.d.l0.b.g.l(r13).iterator();
        int r3 = 0;
    L52:
        if (r2.hasNext() == false) goto L63;
        int r10 = r3 + 1;
        g1 r11 = r2.next();
        if (r3 <= 0) goto L57;
        r12.append(", ");
    L57:
        if (k0() == false) goto L59;
        e0 r14 = r11.b();
        kotlin.n0.d.o.e(r14, "typeProjection.type");
        kotlin.s0.w.d.l0.g.f r15 = kotlin.s0.w.d.l0.b.g.d(r14);
    L60:
        if (r15 == null) goto L62;
        r12.append(v(r15, false));
        r12.append(": ");
    L62:
        r12.append(x(r11));
        r3 = r10;
        goto L52
    L59:
        r15 = null;
    L63:
        r12.append(") ");
        r12.append(N());
        r12.append(" ");
        u1(r12, kotlin.s0.w.d.l0.b.g.k(r13));
        if (r9 == false) goto L66;
        r12.append(")");
    L66:
        if (r8 == false) goto L73;
        r12.append("?");
        return;
    L73:
        return;
    L48:
        if (r13.M0().size() > 1) goto L50;
        r12.append("???");
        goto L63
    L32:
        if (Z1(r4) == false) goto L36;
        if (r4.P0() == true) goto L36;
    L37:
        boolean r16 = true;
    L39:
        if (r16 == false) goto L41;
        r12.append("(");
    L41:
        u1(r12, r4);
        if (r16 == false) goto L44;
        r12.append(")");
    L44:
        r12.append(".");
    L36:
        if (M0(r4) == true) goto L37;
        r16 = false;
    L19:
        r9 = true;
        goto L21
    L5:
        r1 = false;
        goto L6
    }

    private final void l1(k1 r2, StringBuilder r3) {
        if (d0() == false) goto L8;
        kotlin.s0.w.d.l0.k.r.g<?> r4 = r2.W();
        if (r4 == null) goto L9;
        r3.append(" = ");
        r3.append(P(c1(r4)));
        return;
    L9:
        return;
    }

    private final String m1(String r3) {
        int r0 = b.f20456a[A0().ordinal()];
        if (r0 != 1) goto L5;
        return r3;
    L5:
        if (r0 != 2) goto L11;
        if (T() == false) goto L13;
        return r3;
    L13:
        return "<b>" + r3 + "</b>";
    L11:
        throw new kotlin.m();
    }

    private final void n1(kotlin.s0.w.d.l0.c.b r3, StringBuilder r4) {
        if (f0().contains(kotlin.s0.w.d.l0.j.e.n) == true) goto L6;
        return;
    L6:
        if (F0() == true) goto L8;
        return;
    L8:
        if (r3.i() == kotlin.s0.w.d.l0.c.b.a.f18848f) goto L12;
        r4.append("/*");
        r4.append(kotlin.s0.w.d.l0.o.u.a.f(r3.i().name()));
        r4.append("*/ ");
        return;
    }

    private final void o1(d0 r5, StringBuilder r6) {
        s1(r6, r5.isExternal(), "external");
        boolean r1 = true;
        if (f0().contains(kotlin.s0.w.d.l0.j.e.q) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        s1(r6, r0, "expect");
        if (f0().contains(kotlin.s0.w.d.l0.j.e.r) == true) goto L11;
    L13:
        r1 = false;
    L14:
        s1(r6, r1, "actual");
        return;
    L11:
        if (r5.E0() == false) goto L13;
    L5:
        if (r5.L() == false) goto L7;
        r0 = true;
        goto L8
    }

    private final void q1(kotlin.s0.w.d.l0.c.e0 r2, StringBuilder r3, kotlin.s0.w.d.l0.c.e0 r4) {
        if (s0() == true) goto L6;
        if (r2 != r4) goto L6;
        return;
    L6:
        s1(r3, f0().contains(kotlin.s0.w.d.l0.j.e.f20468j), kotlin.s0.w.d.l0.o.u.a.f(r2.name()));
    }

    private final void r1(kotlin.s0.w.d.l0.c.b r3, StringBuilder r4) {
        if (kotlin.s0.w.d.l0.k.d.J(r3) == false) goto L7;
        if (r3.l() != kotlin.s0.w.d.l0.c.e0.f18860g) goto L7;
        return;
    L7:
        if (i0() == j.f20491f) goto L9;
    L13:
        kotlin.s0.w.d.l0.c.e0 r0 = r3.l();
        kotlin.n0.d.o.e(r0, "callable.modality");
        q1(r0, r4, N0(r3));
        return;
    L9:
        if (r3.l() != kotlin.s0.w.d.l0.c.e0.f18862i) goto L13;
        if (Q0(r3) == false) goto L13;
    }

    private final void s1(StringBuilder r1, boolean r2, String r3) {
        if (r2 == false) goto L5;
        r1.append(m1(r3));
        r1.append(" ");
        return;
    }

    private final void t1(kotlin.s0.w.d.l0.c.m r2, StringBuilder r3, boolean r4) {
        kotlin.s0.w.d.l0.g.f r5 = r2.getName();
        kotlin.n0.d.o.e(r5, "descriptor.name");
        r3.append(v(r5, r4));
    }

    private final void u1(StringBuilder r3, e0 r4) {
        q1 r0 = r4.R0();
        if ((r0 instanceof kotlin.s0.w.d.l0.n.a) == false) goto L5;
        kotlin.s0.w.d.l0.n.a r1 = (kotlin.s0.w.d.l0.n.a) r0;
    L6:
        if (r1 != null) goto L8;
        v1(r3, r4);
        return;
    L8:
        if (v0() == false) goto L10;
        v1(r3, r1.V());
        return;
    L10:
        v1(r3, r1.a1());
        if (w0() == false) goto L17;
        R0(r3, r1);
        return;
    L17:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void v1(StringBuilder r2, e0 r3) {
        if ((r3 instanceof s1) == true) goto L5;
    L10:
        q1 r4 = r3.R0();
        if ((r4 instanceof kotlin.s0.w.d.l0.n.y) == false) goto L14;
        r2.append(((kotlin.s0.w.d.l0.n.y) r4).Y0(this, this));
        return;
    L14:
        if ((r4 instanceof m0) == false) goto L18;
        F1(r2, (m0) r4);
        return;
    L18:
        return;
    L5:
        if (n() == false) goto L10;
        if (((s1) r3).T0() == true) goto L10;
        r2.append("<Not computed yet>");
    }

    private final void w1(kotlin.s0.w.d.l0.c.b r3, StringBuilder r4) {
        if (f0().contains(kotlin.s0.w.d.l0.j.e.f20469k) == true) goto L6;
        return;
    L6:
        if (Q0(r3) == true) goto L8;
        return;
    L8:
        if (i0() == j.f20492g) goto L14;
        s1(r4, true, "override");
        if (F0() == false) goto L15;
        r4.append("/*");
        r4.append(r3.f().size());
        r4.append("*/ ");
        return;
    L15:
        return;
    }

    private final void x1(l0 r3, StringBuilder r4) {
        y1(r3.e(), "package-fragment", r4);
        if (n() == false) goto L6;
        r4.append(" in ");
        t1(r3.c(), r4, false);
        return;
    }

    private final void y1(kotlin.s0.w.d.l0.g.c r1, String r2, StringBuilder r3) {
        r3.append(m1(r2));
        kotlin.s0.w.d.l0.g.d r4 = r1.j();
        kotlin.n0.d.o.e(r4, "fqName.toUnsafe()");
        String r0 = u(r4);
        if (r0.length() <= 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L9;
        r3.append(" ");
        r3.append(r0);
        return;
    L9:
        return;
    L5:
        r5 = false;
        goto L6
    }

    public static final /* synthetic */ void z(d r0, t0 r1, StringBuilder r2) {
        r0.S0(r1, r2);
    }

    private final void z1(q0 r3, StringBuilder r4) {
        y1(r3.e(), "package", r4);
        if (n() == false) goto L6;
        r4.append(" in context of ");
        t1(r3.v0(), r4, false);
        return;
    }

    public m A0() {
        return this.f20452d.Z();
    }

    public kotlin.n0.c.l<e0, e0> B0() {
        return this.f20452d.a0();
    }

    public boolean C0() {
        return this.f20452d.b0();
    }

    public boolean D0() {
        return this.f20452d.c0();
    }

    public kotlin.s0.w.d.l0.j.c.l E0() {
        return this.f20452d.d0();
    }

    public boolean F0() {
        return this.f20452d.e0();
    }

    public boolean G0() {
        return this.f20452d.f0();
    }

    public boolean H0() {
        return this.f20452d.g0();
    }

    public boolean I0() {
        return this.f20452d.h0();
    }

    public boolean J0() {
        return this.f20452d.i0();
    }

    public boolean K0() {
        return this.f20452d.j0();
    }

    public String K1(List<? extends g1> r3) {
        kotlin.n0.d.o.f(r3, "typeArguments");
        if (r3.isEmpty() == false) goto L5;
        return "";
    L5:
        StringBuilder r0 = new StringBuilder();
        r0.append(P0());
        M(r0, r3);
        r0.append(L0());
        String r2 = r0.toString();
        kotlin.n0.d.o.e(r2, "StringBuilder().apply(builderAction).toString()");
        return r2;
    }

    public String L1(kotlin.s0.w.d.l0.n.e1 r4) {
        kotlin.n0.d.o.f(r4, "typeConstructor");
        kotlin.s0.w.d.l0.c.h r0 = r4.d();
        boolean r2 = true;
        if ((r0 instanceof f1) == false) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r2 = r0 instanceof e1;
    L9:
        if (r2 == true) goto L19;
        if (r0 != null) goto L18;
        if ((r4 instanceof kotlin.s0.w.d.l0.n.d0) == false) goto L16;
        return ((kotlin.s0.w.d.l0.n.d0) r4).j(h.f20464f);
    L16:
        return r4.toString();
    L18:
        throw new IllegalStateException(("Unexpected classifier: " + r0.getClass()).toString());
    L19:
        return a1(r0);
    L5:
        r1 = r0 instanceof kotlin.s0.w.d.l0.c.e;
        goto L6
    }

    public boolean Q() {
        return this.f20452d.r();
    }

    public boolean R() {
        return this.f20452d.s();
    }

    public kotlin.n0.c.l<kotlin.s0.w.d.l0.c.o1.c, Boolean> S() {
        return this.f20452d.t();
    }

    public boolean T() {
        return this.f20452d.u();
    }

    public boolean U() {
        return this.f20452d.v();
    }

    public kotlin.s0.w.d.l0.j.b V() {
        return this.f20452d.w();
    }

    public kotlin.n0.c.l<j1, String> W() {
        return this.f20452d.x();
    }

    public boolean X() {
        return this.f20452d.y();
    }

    public Set<kotlin.s0.w.d.l0.g.c> Y() {
        return this.f20452d.z();
    }

    @Override // kotlin.s0.w.d.l0.j.f
    public void a(Set<kotlin.s0.w.d.l0.g.c> r2) {
        kotlin.n0.d.o.f(r2, "<set-?>");
        this.f20452d.a(r2);
    }

    public boolean a0() {
        return this.f20452d.A();
    }

    public String a1(kotlin.s0.w.d.l0.c.h r2) {
        kotlin.n0.d.o.f(r2, "klass");
        if (kotlin.s0.w.d.l0.n.u1.k.m(r2) == false) goto L6;
        return r2.k().toString();
    L6:
        return V().a(r2, this);
    }

    @Override // kotlin.s0.w.d.l0.j.f
    public void b(boolean r1) {
        this.f20452d.b(r1);
    }

    public boolean b0() {
        return this.f20452d.B();
    }

    @Override // kotlin.s0.w.d.l0.j.f
    public void c(Set<? extends kotlin.s0.w.d.l0.j.e> r2) {
        kotlin.n0.d.o.f(r2, "<set-?>");
        this.f20452d.c(r2);
    }

    public boolean c0() {
        return this.f20452d.C();
    }

    @Override // kotlin.s0.w.d.l0.j.f
    public void d(k r2) {
        kotlin.n0.d.o.f(r2, "<set-?>");
        this.f20452d.d(r2);
    }

    public boolean d0() {
        return this.f20452d.D();
    }

    @Override // kotlin.s0.w.d.l0.j.f
    public void e(boolean r1) {
        this.f20452d.e(r1);
    }

    public boolean e0() {
        return this.f20452d.E();
    }

    @Override // kotlin.s0.w.d.l0.j.f
    public boolean f() {
        return this.f20452d.f();
    }

    public Set<kotlin.s0.w.d.l0.j.e> f0() {
        return this.f20452d.F();
    }

    @Override // kotlin.s0.w.d.l0.j.f
    public void g(kotlin.s0.w.d.l0.j.b r2) {
        kotlin.n0.d.o.f(r2, "<set-?>");
        this.f20452d.g(r2);
    }

    public boolean g0() {
        return this.f20452d.G();
    }

    @Override // kotlin.s0.w.d.l0.j.f
    public void h(boolean r1) {
        this.f20452d.h(r1);
    }

    public final kotlin.s0.w.d.l0.j.g h0() {
        return this.f20452d;
    }

    @Override // kotlin.s0.w.d.l0.j.f
    public void i(boolean r1) {
        this.f20452d.i(r1);
    }

    public j i0() {
        return this.f20452d.H();
    }

    @Override // kotlin.s0.w.d.l0.j.f
    public void j(boolean r1) {
        this.f20452d.j(r1);
    }

    public k j0() {
        return this.f20452d.I();
    }

    @Override // kotlin.s0.w.d.l0.j.f
    public void k(boolean r1) {
        this.f20452d.k(r1);
    }

    public boolean k0() {
        return this.f20452d.J();
    }

    @Override // kotlin.s0.w.d.l0.j.f
    public void l(m r2) {
        kotlin.n0.d.o.f(r2, "<set-?>");
        this.f20452d.l(r2);
    }

    public boolean l0() {
        return this.f20452d.K();
    }

    @Override // kotlin.s0.w.d.l0.j.f
    public Set<kotlin.s0.w.d.l0.g.c> m() {
        return this.f20452d.m();
    }

    public l m0() {
        return this.f20452d.L();
    }

    @Override // kotlin.s0.w.d.l0.j.f
    public boolean n() {
        return this.f20452d.n();
    }

    public boolean n0() {
        return this.f20452d.M();
    }

    @Override // kotlin.s0.w.d.l0.j.f
    public kotlin.s0.w.d.l0.j.a o() {
        return this.f20452d.o();
    }

    public boolean o0() {
        return this.f20452d.N();
    }

    @Override // kotlin.s0.w.d.l0.j.f
    public void p(boolean r1) {
        this.f20452d.p(r1);
    }

    public boolean p0() {
        return this.f20452d.O();
    }

    public String p1(String r2) {
        kotlin.n0.d.o.f(r2, "message");
        int r1 = b.f20456a[A0().ordinal()];
        if (r1 != 1) goto L5;
        return r2;
    L5:
        if (r1 != 2) goto L8;
        return "<i>" + r2 + "</i>";
    L8:
        throw new kotlin.m();
    }

    @Override // kotlin.s0.w.d.l0.j.c
    public String q(kotlin.s0.w.d.l0.c.m r3) {
        kotlin.n0.d.o.f(r3, "declarationDescriptor");
        StringBuilder r0 = new StringBuilder();
        r3.K(new a(this), r0);
        if (G0() == false) goto L5;
        L(r0, r3);
    L5:
        String r2 = r0.toString();
        kotlin.n0.d.o.e(r2, "StringBuilder().apply(builderAction).toString()");
        return r2;
    }

    public boolean q0() {
        return this.f20452d.P();
    }

    @Override // kotlin.s0.w.d.l0.j.c
    public String r(kotlin.s0.w.d.l0.c.o1.c r12, kotlin.s0.w.d.l0.c.o1.e r13) {
        kotlin.n0.d.o.f(r12, "annotation");
        StringBuilder r0 = new StringBuilder();
        r0.append('@');
        if (r13 == null) goto L5;
        r0.append(r13.b() + ':');
    L5:
        e0 r14 = r12.b();
        r0.append(w(r14));
        if (b0() == false) goto L13;
        List<String> r1 = U0(r12);
        if (c0() == false) goto L10;
    L11:
        r.X(r1, r0, ", ", "(", ")", 0, null, null, 112, null);
        goto L13
    L10:
        if ((!r1.isEmpty()) == true) goto L11;
    L13:
        if (F0() == true) goto L15;
    L19:
        String r11 = r0.toString();
        kotlin.n0.d.o.e(r11, "StringBuilder().apply(builderAction).toString()");
        return r11;
    L15:
        if (g0.a(r14) == false) goto L17;
    L18:
        r0.append(" /* annotation class not found */");
        goto L19
    L17:
        if ((r14.O0().d() instanceof k0.b) == false) goto L19;
        goto L18
    }

    public boolean r0() {
        return this.f20452d.Q();
    }

    public boolean s0() {
        return this.f20452d.R();
    }

    @Override // kotlin.s0.w.d.l0.j.c
    public String t(String r16, String r17, kotlin.s0.w.d.l0.b.h r18) {
        kotlin.n0.d.o.f(r16, "lowerRendered");
        kotlin.n0.d.o.f(r17, "upperRendered");
        kotlin.n0.d.o.f(r18, "builtIns");
        if (O(r16, r17) == true) goto L5;
        kotlin.s0.w.d.l0.j.b r0 = V();
        kotlin.s0.w.d.l0.c.e r1 = r18.w();
        kotlin.n0.d.o.e(r1, "builtIns.collection");
        String r13 = kotlin.u0.k.E0(r0.a(r1, this), "Collection", null, 2, null);
        String r2 = Y1(r16, r13 + "Mutable", r17, r13, r13 + "(Mutable)");
        if (r2 == null) goto L13;
        return r2;
    L13:
        String r3 = Y1(r16, r13 + "MutableMap.MutableEntry", r17, r13 + "Map.Entry", r13 + "(Mutable)Map.(Mutable)Entry");
        if (r3 == null) goto L16;
        return r3;
    L16:
        kotlin.s0.w.d.l0.j.b r4 = V();
        kotlin.s0.w.d.l0.c.e r5 = r18.j();
        kotlin.n0.d.o.e(r5, "builtIns.array");
        String r6 = kotlin.u0.k.E0(r4.a(r5, this), "Array", null, 2, null);
        String r7 = Y1(r16, r6 + P("Array<"), r17, r6 + P("Array<out "), r6 + P("Array<(out) "));
        if (r7 == null) goto L19;
        return r7;
    L19:
        StringBuilder r8 = new StringBuilder();
        r8.append('(');
        r8.append(r16);
        r8.append("..");
        r8.append(r17);
        r8.append(')');
    L8:
        return r8.toString();
    L5:
        if (kotlin.u0.k.A(r17, "(", false, 2, null) == false) goto L9;
        r8 = new StringBuilder();
        r8.append('(');
        r8.append(r16);
        r8.append(")!");
        goto L8
    L9:
        r8 = new StringBuilder();
        r8.append(r16);
        r8.append('!');
        goto L8
    }

    public boolean t0() {
        return this.f20452d.S();
    }

    @Override // kotlin.s0.w.d.l0.j.c
    public String u(kotlin.s0.w.d.l0.g.d r2) {
        kotlin.n0.d.o.f(r2, "fqName");
        List<kotlin.s0.w.d.l0.g.f> r3 = r2.h();
        kotlin.n0.d.o.e(r3, "fqName.pathSegments()");
        return i1(r3);
    }

    public boolean u0() {
        return this.f20452d.T();
    }

    @Override // kotlin.s0.w.d.l0.j.c
    public String v(kotlin.s0.w.d.l0.g.f r2, boolean r3) {
        kotlin.n0.d.o.f(r2, "name");
        String r4 = P(n.b(r2));
        if (T() == true) goto L5;
        return r4;
    L5:
        if (A0() != m.f20504g) goto L10;
        if (r3 == true) goto L8;
        return r4;
    L8:
        return "<b>" + r4 + "</b>";
    L10:
        return r4;
    }

    public boolean v0() {
        return this.f20452d.U();
    }

    @Override // kotlin.s0.w.d.l0.j.c
    public String w(e0 r3) {
        kotlin.n0.d.o.f(r3, WsConstants.KEY_CONNECTION_TYPE);
        StringBuilder r0 = new StringBuilder();
        u1(r0, B0().invoke(r3));
        String r2 = r0.toString();
        kotlin.n0.d.o.e(r2, "StringBuilder().apply(builderAction).toString()");
        return r2;
    }

    public boolean w0() {
        return this.f20452d.V();
    }

    @Override // kotlin.s0.w.d.l0.j.c
    public String x(g1 r2) {
        kotlin.n0.d.o.f(r2, "typeProjection");
        StringBuilder r0 = new StringBuilder();
        M(r0, r.d(r2));
        String r1 = r0.toString();
        kotlin.n0.d.o.e(r1, "StringBuilder().apply(builderAction).toString()");
        return r1;
    }

    public boolean x0() {
        return this.f20452d.W();
    }

    public boolean y0() {
        return this.f20452d.X();
    }

    public boolean z0() {
        return this.f20452d.Y();
    }
}
