package l.b.a;

/* JADX INFO: loaded from: classes2.dex */
public class m0 implements e, w1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f21623f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f21624g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private y f21625h;

    m0(boolean r1, int r2, y r3) {
        this.f21623f = r1;
        this.f21624g = r2;
        this.f21625h = r3;
    }

    @Override // l.b.a.e
    public t b() {
        return d();
    L4:
        e = move-exception;
        throw new s(e.getMessage());
    }

    @Override // l.b.a.w1
    public t d() {
        return this.f21625h.c(this.f21623f, this.f21624g);
    }
}
