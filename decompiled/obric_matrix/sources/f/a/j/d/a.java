package f.a.j.d;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
/* JADX INFO: loaded from: classes2.dex */
abstract class a extends AtomicReference<Future<?>> implements f.a.g.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected static final FutureTask<Void> f17082h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected static final FutureTask<Void> f17083i = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final Runnable f17084f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected Thread f17085g;

    static {
        Runnable r1 = f.a.j.b.a.f17058a;
        f17082h = new FutureTask(r1, null);
        f17083i = new FutureTask(r1, null);
    }

    a(Runnable r1) {
        this.f17084f = r1;
    }

    public final void a(Future<?> r3) {
    L2:
        Future<?> r0 = get();
        if (r0 == f17082h) goto L19;
        if (r0 == f17083i) goto L8;
        if (compareAndSet(r0, r3) == false) goto L2;
        return;
    L8:
        if (this.f17085g == Thread.currentThread()) goto L10;
        boolean r2 = true;
    L11:
        r3.cancel(r2);
        return;
    L10:
        r2 = false;
        goto L11
    }

    @Override // f.a.g.b
    public final void dispose() {
        Future<?> r0 = get();
        if (r0 == f17082h) goto L15;
        FutureTask<Void> r1 = f17083i;
        if (r0 != r1) goto L7;
        return;
    L7:
        if (compareAndSet(r0, r1) == false) goto L17;
        if (r0 != null) goto L10;
        return;
    L10:
        if (this.f17085g == Thread.currentThread()) goto L12;
        boolean r2 = true;
    L13:
        r0.cancel(r2);
        return;
    L12:
        r2 = false;
        goto L13
    L17:
        return;
    }
}
