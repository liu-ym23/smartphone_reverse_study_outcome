package h.a;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0016J\u001c\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J.\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010#*\u00020$2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006%"}, d2 = {"Lkotlinx/coroutines/ExecutorCoroutineDispatcherImpl;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "executor", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Executor;)V", "getExecutor", "()Ljava/util/concurrent/Executor;", "cancelJobOnRejection", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "Ljava/util/concurrent/RejectedExecutionException;", "close", "dispatch", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "equals", "", "other", "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "", "scheduleBlock", "Ljava/util/concurrent/ScheduledFuture;", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class o1 extends n1 implements u0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Executor f17551f;

    public o1(Executor r1) {
        this.f17551f = r1;
        h.a.f3.f.a(i0());
    }

    private final void h0(kotlin.k0.g r1, RejectedExecutionException r2) {
        b2.c(r1, m1.a("The task was rejected", r2));
    }

    private final ScheduledFuture<?> j0(ScheduledExecutorService r2, Runnable r3, kotlin.k0.g r4, long r5) {
        return r2.schedule(r3, r5, TimeUnit.MILLISECONDS);
    L4:
        e = move-exception;
        h0(r4, e);
        return null;
    }

    @Override // h.a.u0
    public d1 M(long r10, Runnable r12, kotlin.k0.g r13) {
        Executor r0 = i0();
        ScheduledFuture<?> r2 = null;
        if ((r0 instanceof ScheduledExecutorService) == false) goto L5;
        ScheduledExecutorService r4 = (ScheduledExecutorService) r0;
    L6:
        if (r4 == null) goto L9;
        r2 = j0(r4, r12, r13, r10);
    L9:
        if (r2 == null) goto L12;
        return new c1(r2);
    L12:
        return s0.f17564k.M(r10, r12, r13);
    L5:
        r4 = null;
        goto L6
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor r1 = i0();
        if ((r1 instanceof ExecutorService) == false) goto L5;
        ExecutorService r2 = (ExecutorService) r1;
    L6:
        if (r2 == null) goto L10;
        r2.shutdown();
        return;
    L10:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // h.a.g0
    public void dispatch(kotlin.k0.g r3, Runnable r4) {
        Executor r0 = i0();     // Catch: RejectedExecutionException -> L10
        b r1 = c.a();     // Catch: RejectedExecutionException -> L10
        if (r1 == null) goto L7;
        Runnable r2 = r1.h(r4);     // Catch: RejectedExecutionException -> L10
        if (r2 == null) goto L7;
    L8:
        r0.execute(r2);     // Catch: RejectedExecutionException -> L10
        return;
    L7:
        r2 = r4;
    L10:
        e = move-exception;
        b r5 = c.a();
        if (r5 == null) goto L15;
        r5.e();
    L15:
        h0(r3, e);
        b1.b().dispatch(r3, r4);
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof o1) == true) goto L5;
    L7:
        return false;
    L5:
        if (((o1) r2).i0() != i0()) goto L7;
        return true;
    }

    public int hashCode() {
        return System.identityHashCode(i0());
    }

    public Executor i0() {
        return this.f17551f;
    }

    @Override // h.a.u0
    public void l(long r10, n<? super kotlin.f0> r12) {
        Executor r0 = i0();
        ScheduledFuture<?> r2 = null;
        if ((r0 instanceof ScheduledExecutorService) == false) goto L5;
        ScheduledExecutorService r4 = (ScheduledExecutorService) r0;
    L6:
        if (r4 == null) goto L9;
        r2 = j0(r4, new p2(this, r12), r12.getContext(), r10);
    L9:
        if (r2 == null) goto L12;
        b2.e(r12, r2);
        return;
    L12:
        s0.f17564k.l(r10, r12);
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // h.a.g0
    public String toString() {
        return i0().toString();
    }
}
