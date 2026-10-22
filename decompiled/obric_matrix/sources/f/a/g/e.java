package f.a.g;

/* JADX INFO: loaded from: classes2.dex */
final class e extends d<Runnable> {
    e(Runnable r1) {
        super(r1);
    }

    @Override // f.a.g.d
    protected /* bridge */ /* synthetic */ void b(Runnable r1) {
        c(r1);
    }

    protected void c(Runnable r1) {
        r1.run();
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return "RunnableDisposable(disposed=" + a() + ", " + get() + ")";
    }
}
