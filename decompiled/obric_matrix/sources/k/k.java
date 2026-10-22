package k;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k implements z {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final z f18275f;

    public k(z r2) {
        kotlin.n0.d.o.g(r2, "delegate");
        this.f18275f = r2;
    }

    public final z a() {
        return this.f18275f;
    }

    @Override // k.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f18275f.close();
    }

    @Override // k.z
    public a0 e() {
        return this.f18275f.e();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f18275f + ')';
    }
}
