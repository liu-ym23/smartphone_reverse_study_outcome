package kotlin.s0.w.d.l0.n;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends y0<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.c.o1.g f21030a;

    public j(kotlin.s0.w.d.l0.c.o1.g r2) {
        kotlin.n0.d.o.f(r2, "annotations");
        this.f21030a = r2;
    }

    @Override // kotlin.s0.w.d.l0.n.y0
    public /* bridge */ /* synthetic */ y0 a(y0 r1) {
        return d((j) r1);
    }

    @Override // kotlin.s0.w.d.l0.n.y0
    public kotlin.s0.d<? extends j> b() {
        return kotlin.n0.d.e0.b(j.class);
    }

    @Override // kotlin.s0.w.d.l0.n.y0
    public /* bridge */ /* synthetic */ y0 c(y0 r1) {
        return f((j) r1);
    }

    public j d(j r2) {
        if (r2 != null) goto L5;
        return this;
    L5:
        return new j(kotlin.s0.w.d.l0.c.o1.i.a(this.f21030a, r2.f21030a));
    }

    public final kotlin.s0.w.d.l0.c.o1.g e() {
        return this.f21030a;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof j) == true) goto L7;
        return false;
    L7:
        return kotlin.n0.d.o.a(((j) r2).f21030a, this.f21030a);
    }

    public j f(j r1) {
        if (kotlin.n0.d.o.a(r1, this) == true) goto L7;
        return null;
    L7:
        return this;
    }

    public int hashCode() {
        return this.f21030a.hashCode();
    }
}
