package kotlin.s0.w.d.l0.b.q;

import java.util.List;
import kotlin.i0.r;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.c.q1.x;
import kotlin.s0.w.d.l0.m.m;
import kotlin.s0.w.d.l0.m.n;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends kotlin.s0.w.d.l0.b.h {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final /* synthetic */ l<Object>[] f18798j = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a f18799g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private kotlin.n0.c.a<b> f18800h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i f18801i;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f18802f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f18803g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f18804h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ a[] f18805i = null;

        static {
            f18802f = new a("FROM_DEPENDENCIES", 0);
            f18803g = new a("FROM_CLASS_LOADER", 1);
            f18804h = new a("FALLBACK", 2);
            f18805i = a();
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{f18802f, f18803g, f18804h};
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f18805i.clone();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final h0 f18806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f18807b;

        public b(h0 r2, boolean r3) {
            o.f(r2, "ownerModuleDescriptor");
            this.f18806a = r2;
            this.f18807b = r3;
        }

        public final h0 a() {
            return this.f18806a;
        }

        public final boolean b() {
            return this.f18807b;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18808a = null;

        static {
            int[] r0 = new int[a.values().length];
            r0[a.f18802f.ordinal()] = 1;
            r0[a.f18803g.ordinal()] = 2;
            r0[a.f18804h.ordinal()] = 3;
            f18808a = r0;
        }
    }

    static final class d extends q implements kotlin.n0.c.a<g> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f18809f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ n f18810g;

        static final class a extends q implements kotlin.n0.c.a<b> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ f f18811f;

            a(f r1) {
                this.f18811f = r1;
                super(0);
            }

            public final b a() {
                kotlin.n0.c.a r0 = f.E0(this.f18811f);
                if (r0 == null) goto L7;
                Object r1 = r0.invoke();
                b r2 = (b) r1;
                f.F0(this.f18811f, null);
                return r2;
            L7:
                throw new AssertionError("JvmBuiltins instance has not been initialized properly");
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ b invoke() {
                return a();
            }
        }

        d(f r1, n r2) {
            this.f18809f = r1;
            this.f18810g = r2;
            super(0);
        }

        public final g a() {
            x r1 = this.f18809f.r();
            o.e(r1, "builtInsModule");
            return new g(r1, this.f18810g, new a(this.f18809f));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ g invoke() {
            return a();
        }
    }

    static final class e extends q implements kotlin.n0.c.a<b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h0 f18812f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f18813g;

        e(h0 r1, boolean r2) {
            this.f18812f = r1;
            this.f18813g = r2;
            super(0);
        }

        public final b a() {
            return new b(this.f18812f, this.f18813g);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ b invoke() {
            return a();
        }
    }

    static {
        f18798j = new l[]{e0.g(new y(e0.b(f.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};
    }

    public f(n r2, a r3) {
        o.f(r2, "storageManager");
        o.f(r3, "kind");
        super(r2);
        this.f18799g = r3;
        this.f18801i = r2.d(new d(this, r2));
        int r4 = c.f18808a[r3.ordinal()];
        if (r4 != 2) goto L5;
        boolean r5 = false;
    L9:
        f(r5);
        return;
    L5:
        if (r4 != 3) goto L11;
        r5 = true;
        goto L9
    }

    public static final /* synthetic */ kotlin.n0.c.a E0(f r0) {
        return r0.f18800h;
    }

    public static final /* synthetic */ void F0(f r0, kotlin.n0.c.a r1) {
        r0.f18800h = r1;
    }

    protected List<kotlin.s0.w.d.l0.c.p1.b> G0() {
        Iterable<kotlin.s0.w.d.l0.c.p1.b> r0 = super.v();
        o.e(r0, "super.getClassDescriptorFactories()");
        n r3 = U();
        o.e(r3, "storageManager");
        x r4 = r();
        o.e(r4, "builtInsModule");
        return r.j0(r0, new kotlin.s0.w.d.l0.b.q.e(r3, r4, null, 4, null));
    }

    public final g H0() {
        return (g) m.a(this.f18801i, this, f18798j[0]);
    }

    public final void I0(h0 r2, boolean r3) {
        o.f(r2, "moduleDescriptor");
        J0(new e(r2, r3));
    }

    public final void J0(kotlin.n0.c.a<b> r2) {
        o.f(r2, "computation");
        kotlin.n0.c.a<b> r0 = this.f18800h;
        this.f18800h = r2;
    }

    @Override // kotlin.s0.w.d.l0.b.h
    protected kotlin.s0.w.d.l0.c.p1.c M() {
        return H0();
    }

    @Override // kotlin.s0.w.d.l0.b.h
    protected kotlin.s0.w.d.l0.c.p1.a g() {
        return H0();
    }

    @Override // kotlin.s0.w.d.l0.b.h
    public /* bridge */ /* synthetic */ Iterable v() {
        return G0();
    }
}
