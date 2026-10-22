package k;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j implements x {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final x f18274f;

    public j(x r2) {
        kotlin.n0.d.o.g(r2, "delegate");
        this.f18274f = r2;
    }

    @Override // k.x
    public void J(e r2, long r3) {
        kotlin.n0.d.o.g(r2, "source");
        this.f18274f.J(r2, r3);
    }

    @Override // k.x, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f18274f.close();
    }

    @Override // k.x
    public a0 e() {
        return this.f18274f.e();
    }

    @Override // k.x, java.io.Flushable
    public void flush() {
        this.f18274f.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f18274f + ')';
    }
}
