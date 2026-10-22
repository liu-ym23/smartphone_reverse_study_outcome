package l.b.a;

/* JADX INFO: loaded from: classes2.dex */
public class d0 implements e, w1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f21526f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final y f21527g;

    d0(int r1, y r2) {
        this.f21526f = r1;
        this.f21527g = r2;
    }

    @Override // l.b.a.e
    public t b() {
        return d();
    L4:
        e = move-exception;
        throw new s(e.getMessage(), e);
    }

    @Override // l.b.a.w1
    public t d() {
        return new c0(this.f21526f, this.f21527g.d());
    }
}
