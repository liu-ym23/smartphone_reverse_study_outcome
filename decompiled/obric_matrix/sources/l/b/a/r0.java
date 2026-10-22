package l.b.a;

/* JADX INFO: loaded from: classes2.dex */
public class r0 implements e, w1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private y f21669f;

    public r0(y r1) {
        this.f21669f = r1;
    }

    @Override // l.b.a.e
    public t b() {
        return d();
    L8:
        e = move-exception;
        throw new s("unable to get DER object", e);
    L5:
        e = move-exception;
        throw new s("unable to get DER object", e);
    }

    @Override // l.b.a.w1
    public t d() {
        return new m1(this.f21669f.d());
    L4:
        e = move-exception;
        throw new h(e.getMessage(), e);
    }
}
