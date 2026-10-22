package kotlin.s0.w.d.l0.c.q1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.s0.w.d.l0.c.o0;
import kotlin.s0.w.d.l0.c.q0;

/* JADX INFO: loaded from: classes2.dex */
public class r extends j implements q0 {
    static final /* synthetic */ kotlin.s0.l<Object>[] m = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final x f19045h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.g.c f19046i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i f19047j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i f19048k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.k.w.h f19049l;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ r f19050f;

        a(r r1) {
            this.f19050f = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final Boolean invoke() {
            return Boolean.valueOf(o0.b(this.f19050f.L0().R0(), this.f19050f.e()));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return invoke();
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.a<List<? extends kotlin.s0.w.d.l0.c.l0>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ r f19051f;

        b(r r1) {
            this.f19051f = r1;
            super(0);
        }

        public final List<kotlin.s0.w.d.l0.c.l0> a() {
            return o0.c(this.f19051f.L0().R0(), this.f19051f.e());
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<? extends kotlin.s0.w.d.l0.c.l0> invoke() {
            return a();
        }
    }

    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.s0.w.d.l0.k.w.h> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ r f19052f;

        c(r r1) {
            this.f19052f = r1;
            super(0);
        }

        public final kotlin.s0.w.d.l0.k.w.h a() {
            if (this.f19052f.isEmpty() == true) goto L12;
            List<kotlin.s0.w.d.l0.c.l0> r0 = this.f19052f.G();
            ArrayList r1 = new ArrayList(kotlin.i0.r.q(r0, 10));
            Iterator<T> r2 = r0.iterator();
        L7:
            if (r2.hasNext() == false) goto L9;
            r1.add(((kotlin.s0.w.d.l0.c.l0) r2.next()).q());
            goto L7
        L9:
            List r3 = kotlin.i0.r.l0(r1, new h0(this.f19052f.L0(), this.f19052f.e()));
            return kotlin.s0.w.d.l0.k.w.b.f20617d.a("package view scope for " + this.f19052f.e() + " in " + this.f19052f.L0().getName(), r3);
        L12:
            return kotlin.s0.w.d.l0.k.w.h.b.f20650b;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.k.w.h invoke() {
            return a();
        }
    }

    static {
        m = new kotlin.s0.l[]{kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(r.class), "fragments", "getFragments()Ljava/util/List;")), kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(r.class), "empty", "getEmpty()Z"))};
    }

    public r(x r3, kotlin.s0.w.d.l0.g.c r4, kotlin.s0.w.d.l0.m.n r5) {
        kotlin.n0.d.o.f(r3, "module");
        kotlin.n0.d.o.f(r4, "fqName");
        kotlin.n0.d.o.f(r5, "storageManager");
        super(kotlin.s0.w.d.l0.c.o1.g.f18919b.b(), r4.h());
        this.f19045h = r3;
        this.f19046i = r4;
        this.f19047j = r5.d(new b(this));
        this.f19048k = r5.d(new a(this));
        this.f19049l = new kotlin.s0.w.d.l0.k.w.g(r5, new c(this));
    }

    public q0 A0() {
        if (e().d() == false) goto L5;
        return null;
    L5:
        x r0 = L0();
        kotlin.s0.w.d.l0.g.c r2 = e().e();
        kotlin.n0.d.o.e(r2, "fqName.parent()");
        return r0.N(r2);
    }

    protected final boolean F0() {
        return ((Boolean) kotlin.s0.w.d.l0.m.m.a(this.f19048k, this, m[1])).booleanValue();
    }

    @Override // kotlin.s0.w.d.l0.c.q0
    public List<kotlin.s0.w.d.l0.c.l0> G() {
        return (List) kotlin.s0.w.d.l0.m.m.a(this.f19047j, this, m[0]);
    }

    @Override // kotlin.s0.w.d.l0.c.m
    public <R, D> R K(kotlin.s0.w.d.l0.c.o<R, D> r2, D r3) {
        kotlin.n0.d.o.f(r2, "visitor");
        return r2.c(this, r3);
    }

    public x L0() {
        return this.f19045h;
    }

    @Override // kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.m c() {
        return A0();
    }

    @Override // kotlin.s0.w.d.l0.c.q0
    public kotlin.s0.w.d.l0.g.c e() {
        return this.f19046i;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof q0) == false) goto L5;
        q0 r5 = (q0) r4;
    L7:
        if (r5 != null) goto L10;
        return false;
    L10:
        if (kotlin.n0.d.o.a(e(), r5.e()) == true) goto L12;
        return false;
    L12:
        if (kotlin.n0.d.o.a(L0(), r5.v0()) == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        r5 = null;
        goto L7
    }

    public int hashCode() {
        return (L0().hashCode() * 31) + e().hashCode();
    }

    @Override // kotlin.s0.w.d.l0.c.q0
    public boolean isEmpty() {
        return F0();
    }

    @Override // kotlin.s0.w.d.l0.c.q0
    public kotlin.s0.w.d.l0.k.w.h q() {
        return this.f19049l;
    }

    @Override // kotlin.s0.w.d.l0.c.q0
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.h0 v0() {
        return L0();
    }
}
