package kotlin.s0.w.d.l0.e.b;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements kotlin.s0.w.d.l0.l.b.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o f19770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f19771b;

    public h(o r2, g r3) {
        kotlin.n0.d.o.f(r2, "kotlinClassFinder");
        kotlin.n0.d.o.f(r3, "deserializedDescriptorResolver");
        this.f19770a = r2;
        this.f19771b = r3;
    }

    @Override // kotlin.s0.w.d.l0.l.b.h
    public kotlin.s0.w.d.l0.l.b.g a(kotlin.s0.w.d.l0.g.b r3) {
        kotlin.n0.d.o.f(r3, "classId");
        q r0 = p.b(this.f19770a, r3);
        if (r0 != null) goto L6;
        return null;
    L6:
        kotlin.n0.d.o.a(r0.f(), r3);
        return this.f19771b.i(r0);
    }
}
