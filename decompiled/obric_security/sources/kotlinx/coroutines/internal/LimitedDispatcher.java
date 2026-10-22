package kotlinx.coroutines.internal;

import com.bytedance.framwork.core.sdklib.DBHelper;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;

/* JADX INFO: compiled from: LimitedDispatcher.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u00032\u00020\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003H\u0002J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0097Aø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u001c\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003H\u0016J#\u0010\u001a\u001a\u00020\u00132\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u001bH\u0082\bJ\u001c\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003H\u0017J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00152\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0096\u0001J\u0010\u0010 \u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\b\u0010!\u001a\u00020\u0013H\u0016J\u001f\u0010\"\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00152\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00130$H\u0096\u0001J\b\u0010%\u001a\u00020\u0010H\u0002R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00060\rj\u0002`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lkotlinx/coroutines/internal/LimitedDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lkotlinx/coroutines/Delay;", "dispatcher", "parallelism", "", "(Lkotlinx/coroutines/CoroutineDispatcher;I)V", DBHelper.TABLE_QUEUE, "Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "runningWorkers", "workerAllocationLock", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "addAndTryDispatching", "", "block", "delay", "", DBHelper.COL_TIME, "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "dispatchInternal", "Lkotlin/Function0;", "dispatchYield", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "limitedParallelism", "run", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "tryAllocateWorker", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LimitedDispatcher extends CoroutineDispatcher implements Runnable, Delay {
    private final /* synthetic */ Delay $$delegate_0;
    private final CoroutineDispatcher dispatcher;
    private final int parallelism;
    private final LockFreeTaskQueue<Runnable> queue;
    private volatile int runningWorkers;
    private final Object workerAllocationLock;

    @Override // kotlinx.coroutines.Delay
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    public Object delay(long r1, Continuation<? super Unit> r3) {
        return this.$$delegate_0.delay(r1, r3);
    }

    @Override // kotlinx.coroutines.Delay
    public DisposableHandle invokeOnTimeout(long r1, Runnable r3, CoroutineContext r4) {
        return this.$$delegate_0.invokeOnTimeout(r1, r3, r4);
    }

    @Override // kotlinx.coroutines.Delay
    /* JADX INFO: renamed from: scheduleResumeAfterDelay */
    public void mo2327scheduleResumeAfterDelay(long r1, CancellableContinuation<? super Unit> r3) {
        this.$$delegate_0.mo2327scheduleResumeAfterDelay(r1, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LimitedDispatcher(CoroutineDispatcher r1, int r2) {
        this.dispatcher = r1;
        this.parallelism = r2;
        if ((r1 instanceof Delay) == false) goto L5;
        Delay r3 = (Delay) r1;
    L6:
        if (r3 != null) goto L8;
        r3 = DefaultExecutorKt.getDefaultDelay();
    L8:
        this.$$delegate_0 = r3;
        this.queue = new LockFreeTaskQueue(false);
        this.workerAllocationLock = new Object();
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher limitedParallelism(int r2) {
        LimitedDispatcherKt.checkParallelism(r2);
        if (r2 < this.parallelism) goto L7;
        return this;
    L7:
        return super.limitedParallelism(r2);
    }

    @Override // java.lang.Runnable
    public void run() {
    L3:
        int r1 = 0;
    L4:
        Runnable r2 = this.queue.removeFirstOrNull();
        if (r2 == null) goto L16;
        r2.run();     // Catch: Throwable -> L8
    L10:
        r1 = r1 + 1;
        if (r1 < 16) goto L4;
        LimitedDispatcher r3 = this;
        if (this.dispatcher.isDispatchNeeded(r3) == false) goto L4;
        this.dispatcher.mo2326dispatch(r3, this);
        return;
    L8:
        th = move-exception;
        CoroutineExceptionHandlerKt.handleCoroutineException(EmptyCoroutineContext.INSTANCE, th);
        goto L10
    L16:
        Object r4 = this.workerAllocationLock;
        monitor-enter(r4);
        this.runningWorkers--;     // Catch: Throwable -> L25
        if (this.queue.getSize() == 0) goto L20;
        this.runningWorkers++;     // Catch: Throwable -> L25
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r4);
        goto L3
    L20:
        monitor-exit(r4);
        return;
    L25:
        th = move-exception;
        throw th;
    }

    private final void dispatchInternal(Runnable r1, Function0<Unit> r2) {
        if (addAndTryDispatching(r1) == false) goto L6;
        return;
    L6:
        if (tryAllocateWorker() == true) goto L8;
        return;
    L8:
        r2.invoke();
    }

    private final boolean tryAllocateWorker() {
        Object r0 = this.workerAllocationLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.runningWorkers < this.parallelism) goto L9;
        monitor-exit(r0);
        return false;
    L9:
        this.runningWorkers++;     // Catch: Throwable -> L12
        monitor-exit(r0);
        return true;
    }

    private final boolean addAndTryDispatching(Runnable r2) {
        this.queue.addLast(r2);
        if (this.runningWorkers < this.parallelism) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* JADX INFO: renamed from: dispatch */
    public void mo2326dispatch(CoroutineContext r1, Runnable r2) {
        if (addAndTryDispatching(r2) == false) goto L5;
        return;
    L5:
        if (tryAllocateWorker() == false) goto L9;
        this.dispatcher.mo2326dispatch(this, this);
        return;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext r1, Runnable r2) {
        if (addAndTryDispatching(r2) == false) goto L5;
        return;
    L5:
        if (tryAllocateWorker() == false) goto L9;
        this.dispatcher.dispatchYield(this, this);
        return;
    }
}
