package f.a.j.d;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, f.a.g.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final Object f17126g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final Object f17127h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final Object f17128i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final Object f17129j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Runnable f17130f;

    static {
        f17126g = new Object();
        f17127h = new Object();
        f17128i = new Object();
        f17129j = new Object();
    }

    public h(Runnable r2, f.a.j.a.b r3) {
        super(3);
        this.f17130f = r2;
        lazySet(0, r3);
    }

    public void a(Future<?> r4) {
    L2:
        Object r1 = get(1);
        if (r1 == f17129j) goto L4;
        if (r1 == f17127h) goto L7;
        if (r1 == f17128i) goto L11;
        if (compareAndSet(1, r1, r4) == false) goto L2;
        return;
    L11:
        r4.cancel(true);
        return;
    L7:
        r4.cancel(false);
        return;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // f.a.g.b
    public void dispose() {
    L2:
        Object r1 = get(1);
        if (r1 == f17129j) goto L19;
        Object r2 = f17127h;
        if (r1 == r2) goto L19;
        Object r4 = f17128i;
        if (r1 == r4) goto L19;
        if (get(2) == Thread.currentThread()) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L16;
        r2 = r4;
    L16:
        if (compareAndSet(1, r1, r2) == false) goto L2;
        if (r1 == null) goto L19;
        ((Future) r1).cancel(r5);
        goto L19
    L12:
        r5 = false;
    L19:
        Object r0 = get(0);
        if (r0 == f17129j) goto L40;
        Object r3 = f17126g;
        if (r0 == r3) goto L41;
        if (r0 == null) goto L42;
        if (compareAndSet(0, r0, r3) == false) goto L19;
        ((f.a.j.a.b) r0).c(this);
        return;
    L42:
        return;
    L41:
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        lazySet(2, Thread.currentThread());
        this.f17130f.run();     // Catch: Throwable -> L5
    L7:
        lazySet(2, null);
        Object r0 = get(0);
        if (r0 == f17126g) goto L13;
        if (compareAndSet(0, r0, f17129j) == false) goto L13;
        if (r0 == null) goto L13;
        ((f.a.j.a.b) r0).c(this);
    L13:
        Object r1 = get(1);
        if (r1 == f17127h) goto L50;
        if (r1 == f17128i) goto L19;
        if (compareAndSet(1, r1, f17129j) == false) goto L13;
        return;
    L19:
        return;
    L50:
        return;
    L5:
        th = move-exception;
        f.a.k.a.m(th);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        lazySet(2, null);
        Object r2 = get(0);
        if (r2 == f17126g) goto L27;
        if (compareAndSet(0, r2, f17129j) == false) goto L27;
        if (r2 == null) goto L27;
        ((f.a.j.a.b) r2).c(this);
    L27:
        Object r3 = get(1);
        if (r3 == f17127h) goto L34;
        if (r3 == f17128i) goto L34;
        if (compareAndSet(1, r3, f17129j) == false) goto L27;
    L34:
        throw th;
    }
}
