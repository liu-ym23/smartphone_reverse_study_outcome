package kotlin.s0.w.d.l0.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f18901b;

    protected n1(String r2, boolean r3) {
        kotlin.n0.d.o.f(r2, "name");
        this.f18900a = r2;
        this.f18901b = r3;
    }

    public Integer a(n1 r2) {
        kotlin.n0.d.o.f(r2, "visibility");
        return m1.f18886a.a(this, r2);
    }

    public String b() {
        return this.f18900a;
    }

    public final boolean c() {
        return this.f18901b;
    }

    public n1 d() {
        return this;
    }

    public final String toString() {
        return b();
    }
}
