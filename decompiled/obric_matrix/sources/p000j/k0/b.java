package p000j.k0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final String f17791f;

    public b(String r1, Object... r2) {
        this.f17791f = c.r(r1, r2);
    }

    protected abstract void l();

    @Override // java.lang.Runnable
    public final void run() {
        String r0 = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f17791f);
        l();     // Catch: Throwable -> L6
        Thread.currentThread().setName(r0);
        return;
    L6:
        th = move-exception;
        Thread.currentThread().setName(r0);
        throw th;
    }
}
