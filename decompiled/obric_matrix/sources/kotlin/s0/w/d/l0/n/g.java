package kotlin.s0.w.d.l0.n;

import com.bytedance.common.wschannel.WsConstants;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i<b> f21007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f21008c;

    private final class a implements e1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.n.t1.g f21009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final kotlin.h f21010b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ g f21011c;

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.n.g$a$a, reason: collision with other inner class name */
        static final class C0578a extends kotlin.n0.d.q implements kotlin.n0.c.a<List<? extends e0>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ a f21012f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ g f21013g;

            C0578a(a r1, g r2) {
                this.f21012f = r1;
                this.f21013g = r2;
                super(0);
            }

            public final List<e0> a() {
                return kotlin.s0.w.d.l0.n.t1.h.b(a.g(this.f21012f), this.f21013g.r());
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ List<? extends e0> invoke() {
                return a();
            }
        }

        public a(g r2, kotlin.s0.w.d.l0.n.t1.g r3) {
            kotlin.n0.d.o.f(r3, "kotlinTypeRefiner");
            this.f21011c = r2;
            this.f21009a = r3;
            this.f21010b = kotlin.i.a(kotlin.l.f18418g, new C0578a(this, r2));
        }

        public static final /* synthetic */ kotlin.s0.w.d.l0.n.t1.g g(a r0) {
            return r0.f21009a;
        }

        private final List<e0> h() {
            return (List) this.f21010b.getValue();
        }

        @Override // kotlin.s0.w.d.l0.n.e1
        public /* bridge */ /* synthetic */ Collection a() {
            return i();
        }

        @Override // kotlin.s0.w.d.l0.n.e1
        public e1 c(kotlin.s0.w.d.l0.n.t1.g r2) {
            kotlin.n0.d.o.f(r2, "kotlinTypeRefiner");
            return this.f21011c.c(r2);
        }

        @Override // kotlin.s0.w.d.l0.n.e1
        public kotlin.s0.w.d.l0.c.h d() {
            return this.f21011c.d();
        }

        @Override // kotlin.s0.w.d.l0.n.e1
        public boolean e() {
            return this.f21011c.e();
        }

        public boolean equals(Object r1) {
            return this.f21011c.equals(r1);
        }

        @Override // kotlin.s0.w.d.l0.n.e1
        public List<kotlin.s0.w.d.l0.c.f1> getParameters() {
            List<kotlin.s0.w.d.l0.c.f1> r1 = this.f21011c.getParameters();
            kotlin.n0.d.o.e(r1, "this@AbstractTypeConstructor.parameters");
            return r1;
        }

        public int hashCode() {
            return this.f21011c.hashCode();
        }

        public List<e0> i() {
            return h();
        }

        @Override // kotlin.s0.w.d.l0.n.e1
        public kotlin.s0.w.d.l0.b.h o() {
            kotlin.s0.w.d.l0.b.h r1 = this.f21011c.o();
            kotlin.n0.d.o.e(r1, "this@AbstractTypeConstructor.builtIns");
            return r1;
        }

        public String toString() {
            return this.f21011c.toString();
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Collection<e0> f21014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<? extends e0> f21015b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Collection<? extends e0> r2) {
            kotlin.n0.d.o.f(r2, "allSupertypes");
            this.f21014a = r2;
            this.f21015b = kotlin.i0.r.d(kotlin.s0.w.d.l0.n.u1.k.f21165a.l());
        }

        public final Collection<e0> a() {
            return this.f21014a;
        }

        public final List<e0> b() {
            return this.f21015b;
        }

        public final void c(List<? extends e0> r2) {
            kotlin.n0.d.o.f(r2, "<set-?>");
            this.f21015b = r2;
        }
    }

    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.a<b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f21016f;

        c(g r1) {
            this.f21016f = r1;
            super(0);
        }

        public final b a() {
            return new b(this.f21016f.l());
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ b invoke() {
            return a();
        }
    }

    static final class d extends kotlin.n0.d.q implements kotlin.n0.c.l<Boolean, b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f21017f = null;

        static {
            f21017f = new d();
        }

        d() {
            super(1);
        }

        public final b a(boolean r1) {
            return new b(kotlin.i0.r.d(kotlin.s0.w.d.l0.n.u1.k.f21165a.l()));
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ b invoke(Boolean r1) {
            return a(r1.booleanValue());
        }
    }

    static final class e extends kotlin.n0.d.q implements kotlin.n0.c.l<b, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f21018f;

        static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<e1, Iterable<? extends e0>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ g f21019f;

            a(g r1) {
                this.f21019f = r1;
                super(1);
            }

            public final Iterable<e0> a(e1 r2) {
                kotlin.n0.d.o.f(r2, "it");
                return g.j(this.f21019f, r2, true);
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ Iterable<? extends e0> invoke(e1 r1) {
                return a(r1);
            }
        }

        static final class b extends kotlin.n0.d.q implements kotlin.n0.c.l<e0, kotlin.f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ g f21020f;

            b(g r1) {
                this.f21020f = r1;
                super(1);
            }

            public final void a(e0 r2) {
                kotlin.n0.d.o.f(r2, "it");
                this.f21020f.t(r2);
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ kotlin.f0 invoke(e0 r1) {
                a(r1);
                return kotlin.f0.f18324a;
            }
        }

        static final class c extends kotlin.n0.d.q implements kotlin.n0.c.l<e1, Iterable<? extends e0>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ g f21021f;

            c(g r1) {
                this.f21021f = r1;
                super(1);
            }

            public final Iterable<e0> a(e1 r2) {
                kotlin.n0.d.o.f(r2, "it");
                return g.j(this.f21021f, r2, false);
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ Iterable<? extends e0> invoke(e1 r1) {
                return a(r1);
            }
        }

        static final class d extends kotlin.n0.d.q implements kotlin.n0.c.l<e0, kotlin.f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ g f21022f;

            d(g r1) {
                this.f21022f = r1;
                super(1);
            }

            public final void a(e0 r2) {
                kotlin.n0.d.o.f(r2, "it");
                this.f21022f.u(r2);
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ kotlin.f0 invoke(e0 r1) {
                a(r1);
                return kotlin.f0.f18324a;
            }
        }

        e(g r1) {
            this.f21018f = r1;
            super(1);
        }

        public final void a(b r8) {
            kotlin.n0.d.o.f(r8, "supertypes");
            Collection<e0> r0 = this.f21018f.q().a(this.f21018f, r8.a(), new c(this.f21018f), new d(this.f21018f));
            List<e0> r2 = null;
            if (r0.isEmpty() == false) goto L11;
            e0 r1 = this.f21018f.m();
            if (r1 == null) goto L7;
            r0 = kotlin.i0.r.d(r1);
        L8:
            if (r0 != null) goto L11;
            r0 = kotlin.i0.r.g();
            goto L11
        L7:
            r0 = null;
        L11:
            if (this.f21018f.p() == false) goto L13;
            kotlin.s0.w.d.l0.c.d1 r3 = this.f21018f.q();
            g r4 = this.f21018f;
            r3.a(r4, r0, new a(r4), new b(this.f21018f));
        L13:
            g r7 = this.f21018f;
            if ((r0 instanceof List) == false) goto L16;
            r2 = (List) r0;
        L16:
            if (r2 != null) goto L18;
            r2 = kotlin.i0.r.z0(r0);
        L18:
            r8.c(r7.s(r2));
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(b r1) {
            a(r1);
            return kotlin.f0.f18324a;
        }
    }

    public g(kotlin.s0.w.d.l0.m.n r4) {
        kotlin.n0.d.o.f(r4, "storageManager");
        this.f21007b = r4.g(new c(this), d.f21017f, new e(this));
    }

    public static final /* synthetic */ Collection j(g r0, e1 r1, boolean r2) {
        return r0.k(r1, r2);
    }

    private final Collection<e0> k(e1 r2, boolean r3) {
        if ((r2 instanceof g) == false) goto L5;
        g r1 = (g) r2;
    L6:
        if (r1 == null) goto L10;
        List r4 = kotlin.i0.r.k0(r1.f21007b.invoke().a(), r1.n(r3));
        if (r4 == null) goto L10;
        return r4;
    L10:
        Collection<e0> r5 = r2.a();
        kotlin.n0.d.o.e(r5, "supertypes");
        return r5;
    L5:
        r1 = null;
        goto L6
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public /* bridge */ /* synthetic */ Collection a() {
        return r();
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public e1 c(kotlin.s0.w.d.l0.n.t1.g r2) {
        kotlin.n0.d.o.f(r2, "kotlinTypeRefiner");
        return new a(this, r2);
    }

    protected abstract Collection<e0> l();

    protected e0 m() {
        return null;
    }

    protected Collection<e0> n(boolean r1) {
        return kotlin.i0.r.g();
    }

    protected boolean p() {
        return this.f21008c;
    }

    protected abstract kotlin.s0.w.d.l0.c.d1 q();

    public List<e0> r() {
        return this.f21007b.invoke().b();
    }

    protected List<e0> s(List<e0> r1) {
        kotlin.n0.d.o.f(r1, "supertypes");
        return r1;
    }

    protected void t(e0 r1) {
        kotlin.n0.d.o.f(r1, WsConstants.KEY_CONNECTION_TYPE);
    }

    protected void u(e0 r1) {
        kotlin.n0.d.o.f(r1, WsConstants.KEY_CONNECTION_TYPE);
    }
}
