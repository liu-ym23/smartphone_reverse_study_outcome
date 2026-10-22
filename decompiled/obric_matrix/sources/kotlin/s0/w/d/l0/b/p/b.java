package kotlin.s0.w.d.l0.b.p;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.i0.j0;
import kotlin.i0.r;
import kotlin.m;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.b.k;
import kotlin.s0.w.d.l0.c.d1;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.h;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.c.h1;
import kotlin.s0.w.d.l0.c.l0;
import kotlin.s0.w.d.l0.c.o1.g;
import kotlin.s0.w.d.l0.c.q1.k0;
import kotlin.s0.w.d.l0.c.t;
import kotlin.s0.w.d.l0.c.u;
import kotlin.s0.w.d.l0.c.x;
import kotlin.s0.w.d.l0.g.f;
import kotlin.s0.w.d.l0.m.n;
import kotlin.s0.w.d.l0.n.a1;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.e1;
import kotlin.s0.w.d.l0.n.f0;
import kotlin.s0.w.d.l0.n.i1;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends kotlin.s0.w.d.l0.c.q1.a {
    private static final kotlin.s0.w.d.l0.g.b r = null;
    private static final kotlin.s0.w.d.l0.g.b s = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final n f18752k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final l0 f18753l;
    private final c m;
    private final int n;
    private final a o;
    private final d p;
    private final List<f1> q;

    private final class a extends kotlin.s0.w.d.l0.n.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f18754d;

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.b.p.b$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0496a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f18755a = null;

            static {
                int[] r0 = new int[c.values().length];
                r0[c.f18757i.ordinal()] = 1;
                r0[c.f18759k.ordinal()] = 2;
                r0[c.f18758j.ordinal()] = 3;
                r0[c.f18760l.ordinal()] = 4;
                f18755a = r0;
            }
        }

        public a(b r1) {
            this.f18754d = r1;
            super(b.Q0(r1));
        }

        @Override // kotlin.s0.w.d.l0.n.b, kotlin.s0.w.d.l0.n.m, kotlin.s0.w.d.l0.n.e1
        public /* bridge */ /* synthetic */ h d() {
            return x();
        }

        @Override // kotlin.s0.w.d.l0.n.e1
        public boolean e() {
            return true;
        }

        @Override // kotlin.s0.w.d.l0.n.e1
        public List<f1> getParameters() {
            return b.P0(this.f18754d);
        }

        @Override // kotlin.s0.w.d.l0.n.g
        protected Collection<e0> l() {
            int r0 = C0496a.f18755a[this.f18754d.V0().ordinal()];
            if (r0 != 1) goto L5;
        L14:
            List r1 = r.d(b.N0());
        L15:
            h0 r2 = b.M0(this.f18754d).c();
            ArrayList r3 = new ArrayList(r.q(r1, 10));
            Iterator r4 = r1.iterator();
        L17:
            if (r4.hasNext() == false) goto L28;
            kotlin.s0.w.d.l0.g.b r5 = (kotlin.s0.w.d.l0.g.b) r4.next();
            kotlin.s0.w.d.l0.c.e r6 = x.a(r2, r5);
            if (r6 == null) goto L26;
            List r7 = r.u0(getParameters(), r6.k().getParameters().size());
            ArrayList r8 = new ArrayList(r.q(r7, 10));
            Iterator r9 = r7.iterator();
        L22:
            if (r9.hasNext() == false) goto L24;
            r8.add(new i1(((f1) r9.next()).s()));
            goto L22
        L24:
            r3.add(f0.g(a1.f20943g.h(), r6, r8));
            goto L17
        L26:
            throw new IllegalStateException(("Built-in class " + r5 + " not found").toString());
        L28:
            return r.z0(r3);
        L5:
            if (r0 != 2) goto L7;
            r1 = r.j(new kotlin.s0.w.d.l0.g.b[]{b.O0(), new kotlin.s0.w.d.l0.g.b(k.f18715k, c.f18757i.g(this.f18754d.R0()))});
            goto L15
        L7:
            if (r0 == 3) goto L14;
            if (r0 != 4) goto L12;
            r1 = r.j(new kotlin.s0.w.d.l0.g.b[]{b.O0(), new kotlin.s0.w.d.l0.g.b(k.f18709e, c.f18758j.g(this.f18754d.R0()))});
            goto L15
        L12:
            throw new m();
        }

        @Override // kotlin.s0.w.d.l0.n.g
        protected d1 q() {
            return d1.a.f18858a;
        }

        public String toString() {
            return x().toString();
        }

        @Override // kotlin.s0.w.d.l0.n.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.e w() {
            return x();
        }

        public b x() {
            return this.f18754d;
        }
    }

    static {
        r = new kotlin.s0.w.d.l0.g.b(k.f18715k, f.k("Function"));
        s = new kotlin.s0.w.d.l0.g.b(k.f18712h, f.k("KFunction"));
    }

    public b(n r4, l0 r5, c r6, int r7) {
        o.f(r4, "storageManager");
        o.f(r5, "containingDeclaration");
        o.f(r6, "functionKind");
        super(r4, r6.g(r7));
        this.f18752k = r4;
        this.f18753l = r5;
        this.m = r6;
        this.n = r7;
        this.o = new a(this);
        this.p = new d(r4, this);
        ArrayList r8 = new ArrayList();
        kotlin.r0.d r9 = new kotlin.r0.d(1, r7);
        ArrayList r10 = new ArrayList(r.q(r9, 10));
        Iterator<Integer> r11 = r9.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        int r12 = ((j0) r11).nextInt();
        r1 r0 = r1.f21066i;
        StringBuilder r1 = new StringBuilder();
        r1.append('P');
        r1.append(r12);
        L0(r8, this, r0, r1.toString());
        r10.add(kotlin.f0.f18324a);
        goto L4
    L6:
        L0(r8, this, r1.f21067j, "R");
        this.q = r.z0(r8);
    }

    private static final void L0(ArrayList<f1> r8, b r9, r1 r10, String r11) {
        r8.add(k0.S0(r9, g.f18919b.b(), false, r10, f.k(r11), r8.size(), r9.f18752k));
    }

    public static final /* synthetic */ l0 M0(b r0) {
        return r0.f18753l;
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.g.b N0() {
        return r;
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.g.b O0() {
        return s;
    }

    public static final /* synthetic */ List P0(b r0) {
        return r0.q;
    }

    public static final /* synthetic */ n Q0(b r0) {
        return r0.f18752k;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public boolean B() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.d0
    public boolean E0() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public /* bridge */ /* synthetic */ Collection H() {
        return W0();
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public boolean I() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.t
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.k.w.h J(kotlin.s0.w.d.l0.n.t1.g r1) {
        return Y0(r1);
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public boolean J0() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.d0
    public boolean L() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.i
    public boolean M() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.d Q() {
        return (kotlin.s0.w.d.l0.c.d) Z0();
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.k.w.h R() {
        return X0();
    }

    public final int R0() {
        return this.n;
    }

    public Void S0() {
        return null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.e T() {
        return (kotlin.s0.w.d.l0.c.e) S0();
    }

    public List<kotlin.s0.w.d.l0.c.d> T0() {
        return r.g();
    }

    public l0 U0() {
        return this.f18753l;
    }

    public final c V0() {
        return this.m;
    }

    public List<kotlin.s0.w.d.l0.c.e> W0() {
        return r.g();
    }

    public kotlin.s0.w.d.l0.k.w.h.b X0() {
        return kotlin.s0.w.d.l0.k.w.h.b.f20650b;
    }

    protected d Y0(kotlin.s0.w.d.l0.n.t1.g r2) {
        o.f(r2, "kotlinTypeRefiner");
        return this.p;
    }

    public Void Z0() {
        return null;
    }

    @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.n, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.m c() {
        return U0();
    }

    @Override // kotlin.s0.w.d.l0.c.o1.a
    public g getAnnotations() {
        return g.f18919b.b();
    }

    @Override // kotlin.s0.w.d.l0.c.p
    public kotlin.s0.w.d.l0.c.a1 getSource() {
        kotlin.s0.w.d.l0.c.a1 r1 = kotlin.s0.w.d.l0.c.a1.f18847a;
        o.e(r1, "NO_SOURCE");
        return r1;
    }

    @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.q, kotlin.s0.w.d.l0.c.d0
    public u getVisibility() {
        u r1 = t.f19163e;
        o.e(r1, "PUBLIC");
        return r1;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public kotlin.s0.w.d.l0.c.f i() {
        return kotlin.s0.w.d.l0.c.f.f18866g;
    }

    @Override // kotlin.s0.w.d.l0.c.d0
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.h
    public e1 k() {
        return this.o;
    }

    @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.d0
    public kotlin.s0.w.d.l0.c.e0 l() {
        return kotlin.s0.w.d.l0.c.e0.f18863j;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public /* bridge */ /* synthetic */ Collection m() {
        return T0();
    }

    public String toString() {
        String r1 = getName().b();
        o.e(r1, "name.asString()");
        return r1;
    }

    @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.i
    public List<f1> u() {
        return this.q;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public boolean x() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public h1<m0> z0() {
        return null;
    }
}
