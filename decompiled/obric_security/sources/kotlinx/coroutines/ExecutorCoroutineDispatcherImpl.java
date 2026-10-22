package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ConcurrentKt;

/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0016J\u001c\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J.\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010#*\u00020$2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006%"}, d2 = {"Lkotlinx/coroutines/ExecutorCoroutineDispatcherImpl;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "executor", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Executor;)V", "getExecutor", "()Ljava/util/concurrent/Executor;", "cancelJobOnRejection", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "Ljava/util/concurrent/RejectedExecutionException;", "close", "dispatch", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "equals", "", "other", "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "", "scheduleBlock", "Ljava/util/concurrent/ScheduledFuture;", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExecutorCoroutineDispatcherImpl extends ExecutorCoroutineDispatcher implements Delay {
    private final Executor executor;

    public ExecutorCoroutineDispatcherImpl(Executor r1) {
        this.executor = r1;
        ConcurrentKt.removeFutureOnCancel(getExecutor());
    }

    @Override // kotlinx.coroutines.Delay
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    public Object delay(long r1, Continuation<? super Unit> r3) {
        return Delay.DefaultImpls.delay(this, r1, r3);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public Executor getExecutor() {
        return this.executor;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* JADX INFO: renamed from: dispatch */
    public void mo2326dispatch(CoroutineContext r3, Runnable r4) {
        Executor r0 = getExecutor();     // Catch: RejectedExecutionException -> L9
        AbstractTimeSource r1 = AbstractTimeSourceKt.getTimeSource();     // Catch: RejectedExecutionException -> L9
        if (r1 == null) goto L6;
        Runnable r2 = r1.wrapTask(r4);     // Catch: RejectedExecutionException -> L9
        if (r2 == null) goto L6;
    L7:
        r0.execute(r2);     // Catch: RejectedExecutionException -> L9
        return;
    L6:
        r2 = r4;
    L9:
        e = move-exception;
        AbstractTimeSource r5 = AbstractTimeSourceKt.getTimeSource();
        if (r5 == null) goto L13;
        r5.unTrackTask();
    L13:
        cancelJobOnRejection(r3, e);
        Dispatchers.getIO().mo2326dispatch(r3, r4);
    }

    @Override // kotlinx.coroutines.Delay
    /* JADX INFO: renamed from: scheduleResumeAfterDelay */
    public void mo2327scheduleResumeAfterDelay(long r10, CancellableContinuation<? super Unit> r12) {
        Executor r0 = getExecutor();
        ScheduledFuture<?> r2 = null;
        if ((r0 instanceof ScheduledExecutorService) == false) goto L5;
        ScheduledExecutorService r4 = (ScheduledExecutorService) r0;
    L6:
        if (r4 == null) goto L8;
        r2 = scheduleBlock(r4, new ResumeUndispatchedRunnable(this, r12), r12.getContext(), r10);
    L8:
        if (r2 == null) goto L11;
        JobKt.cancelFutureOnCancellation(r12, r2);
        return;
    L11:
        DefaultExecutor.INSTANCE.mo2327scheduleResumeAfterDelay(r10, r12);
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.Delay
    public DisposableHandle invokeOnTimeout(long r10, Runnable r12, CoroutineContext r13) {
        Executor r0 = getExecutor();
        ScheduledFuture<?> r2 = null;
        if ((r0 instanceof ScheduledExecutorService) == false) goto L5;
        ScheduledExecutorService r4 = (ScheduledExecutorService) r0;
    L6:
        if (r4 == null) goto L8;
        r2 = scheduleBlock(r4, r12, r13, r10);
    L8:
        if (r2 == null) goto L11;
        return new DisposableFutureHandle(r2);
    L11:
        return DefaultExecutor.INSTANCE.invokeOnTimeout(r10, r12, r13);
    L5:
        r4 = null;
        goto L6
    }

    private final ScheduledFuture<?> scheduleBlock(ScheduledExecutorService r2, Runnable r3, CoroutineContext r4, long r5) {
        return r2.schedule(r3, r5, TimeUnit.MILLISECONDS);
    L4:
        e = move-exception;
        cancelJobOnRejection(r4, e);
        ScheduledFuture r6 = (ScheduledFuture) null;
        return null;
    }

    private final void cancelJobOnRejection(CoroutineContext r1, RejectedExecutionException r2) {
        JobKt.cancel(r1, ExceptionsKt.CancellationException("The task was rejected", r2));
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor r1 = getExecutor();
        if ((r1 instanceof ExecutorService) == false) goto L5;
        ExecutorService r2 = (ExecutorService) r1;
    L6:
        if (r2 == null) goto L9;
        r2.shutdown();
        return;
    L9:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return getExecutor().toString();
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof ExecutorCoroutineDispatcherImpl) == true) goto L5;
    L7:
        return false;
    L5:
        if (((ExecutorCoroutineDispatcherImpl) r2).getExecutor() != getExecutor()) goto L7;
        return true;
    }

    public int hashCode() {
        return System.identityHashCode(getExecutor());
    }
}
