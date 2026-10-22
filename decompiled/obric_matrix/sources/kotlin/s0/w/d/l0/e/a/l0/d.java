package kotlin.s0.w.d.l0.e.a.l0;

import java.util.Iterator;
import kotlin.i0.r;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements kotlin.s0.w.d.l0.c.o1.g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final g f19364f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.e.a.n0.d f19365g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f19366h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.h<kotlin.s0.w.d.l0.e.a.n0.a, kotlin.s0.w.d.l0.c.o1.c> f19367i;

    static final class a extends q implements l<kotlin.s0.w.d.l0.e.a.n0.a, kotlin.s0.w.d.l0.c.o1.c> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f19368f;

        a(d r1) {
            this.f19368f = r1;
            super(1);
        }

        public final kotlin.s0.w.d.l0.c.o1.c a(kotlin.s0.w.d.l0.e.a.n0.a r3) {
            o.f(r3, "annotation");
            return kotlin.s0.w.d.l0.e.a.j0.c.f19305a.e(r3, d.b(this.f19368f), d.a(this.f19368f));
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.o1.c invoke(kotlin.s0.w.d.l0.e.a.n0.a r1) {
            return a(r1);
        }
    }

    public d(g r2, kotlin.s0.w.d.l0.e.a.n0.d r3, boolean r4) {
        o.f(r2, "c");
        o.f(r3, "annotationOwner");
        this.f19364f = r2;
        this.f19365g = r3;
        this.f19366h = r4;
        this.f19367i = r2.a().u().i(new a(this));
    }

    public /* synthetic */ d(g r1, kotlin.s0.w.d.l0.e.a.n0.d r2, boolean r3, int r4, kotlin.n0.d.g r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ boolean a(d r0) {
        return r0.f19366h;
    }

    public static final /* synthetic */ g b(d r0) {
        return r0.f19364f;
    }

    @Override // kotlin.s0.w.d.l0.c.o1.g
    public kotlin.s0.w.d.l0.c.o1.c i(kotlin.s0.w.d.l0.g.c r3) {
        o.f(r3, "fqName");
        kotlin.s0.w.d.l0.e.a.n0.a r0 = this.f19365g.i(r3);
        if (r0 == null) goto L7;
        kotlin.s0.w.d.l0.c.o1.c r1 = this.f19367i.invoke(r0);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return kotlin.s0.w.d.l0.e.a.j0.c.f19305a.a(r3, this.f19365g, this.f19364f);
    }

    @Override // kotlin.s0.w.d.l0.c.o1.g
    public boolean isEmpty() {
        if (this.f19365g.getAnnotations().isEmpty() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f19365g.l() == true) goto L7;
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<kotlin.s0.w.d.l0.c.o1.c> iterator() {
        return kotlin.t0.k.p(kotlin.t0.k.w(kotlin.t0.k.t(r.I(this.f19365g.getAnnotations()), this.f19367i), kotlin.s0.w.d.l0.e.a.j0.c.f19305a.a(kotlin.s0.w.d.l0.b.k.a.n, this.f19365g, this.f19364f))).iterator();
    }

    @Override // kotlin.s0.w.d.l0.c.o1.g
    public boolean k(kotlin.s0.w.d.l0.g.c r1) {
        return kotlin.s0.w.d.l0.c.o1.g.b.b(this, r1);
    }
}
