package l.b.a;

/* JADX INFO: loaded from: classes2.dex */
public class i0 implements v {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private y f21598f;

    i0(y r1) {
        this.f21598f = r1;
    }

    @Override // l.b.a.e
    public t b() {
        return d();
    L4:
        e = move-exception;
        throw new IllegalStateException(e.getMessage());
    }

    @Override // l.b.a.w1
    public t d() {
        return new h0(this.f21598f.d());
    }
}
