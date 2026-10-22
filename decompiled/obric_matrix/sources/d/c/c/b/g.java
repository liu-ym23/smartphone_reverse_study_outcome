package d.c.c.b;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class g<T> implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final AtomicInteger f15375f;

    public g() {
        this.f15375f = new AtomicInteger(0);
    }

    public void b() {
        if (this.f15375f.compareAndSet(0, 2) == false) goto L6;
        e();
        return;
    }

    protected abstract void c(T r1);

    protected abstract T d();

    protected abstract void e();

    protected abstract void f(Exception r1);

    protected abstract void g(T r1);

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f15375f.compareAndSet(0, 1) == true) goto L18;
        return;
    L18:
        T r0 = d();     // Catch: Exception -> L13
        this.f15375f.set(3);
        g(r0);     // Catch: Throwable -> L10
        c(r0);
        return;
    L10:
        th = move-exception;
        c(r0);
        throw th;
    L13:
        e = move-exception;
        this.f15375f.set(4);
        f(e);
    }
}
