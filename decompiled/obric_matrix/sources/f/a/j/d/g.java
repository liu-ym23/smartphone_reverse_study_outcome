package f.a.j.d;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends a implements Callable<Void> {
    public g(Runnable r1) {
        super(r1);
    }

    public Void b() {
        this.f17085g = Thread.currentThread();
        this.f17084f.run();     // Catch: Throwable -> L6
        lazySet(a.f17082h);
        this.f17085g = null;
        return null;
    L6:
        th = move-exception;
        lazySet(a.f17082h);
        this.f17085g = null;
        throw th;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Void call() {
        return b();
    }
}
