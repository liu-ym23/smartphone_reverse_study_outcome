package kotlin.s0.w.d.l0.k.w;

import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends kotlin.s0.w.d.l0.k.w.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i<h> f20644b;

    static final class a extends q implements kotlin.n0.c.a<h> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.a<h> f20645f;

        /* JADX WARN: Multi-variable type inference failed */
        a(kotlin.n0.c.a<? extends h> r1) {
            this.f20645f = r1;
            super(0);
        }

        public final h a() {
            h r1 = this.f20645f.invoke();
            if ((r1 instanceof kotlin.s0.w.d.l0.k.w.a) == true) goto L5;
            return r1;
        L5:
            return ((kotlin.s0.w.d.l0.k.w.a) r1).h();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ h invoke() {
            return a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(kotlin.n0.c.a<? extends h> r3) {
        o.f(r3, "getScope");
        this(null, r3, 1, 0 == true ? 1 : 0);
    }

    public g(kotlin.s0.w.d.l0.m.n r2, kotlin.n0.c.a<? extends h> r3) {
        o.f(r2, "storageManager");
        o.f(r3, "getScope");
        this.f20644b = r2.d(new a(r3));
    }

    public /* synthetic */ g(kotlin.s0.w.d.l0.m.n r1, kotlin.n0.c.a r2, int r3, kotlin.n0.d.g r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = kotlin.s0.w.d.l0.m.f.f20912e;
        o.e(r1, "NO_LOCKS");
    L5:
        this(r1, r2);
    }

    @Override // kotlin.s0.w.d.l0.k.w.a
    protected h i() {
        return this.f20644b.invoke();
    }
}
