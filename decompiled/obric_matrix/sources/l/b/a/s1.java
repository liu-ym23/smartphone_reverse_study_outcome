package l.b.a;

/* JADX INFO: loaded from: classes2.dex */
public class s1 implements x {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private y f21707f;

    s1(y r1) {
        this.f21707f = r1;
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
        return new r1(this.f21707f.d());
    }
}
