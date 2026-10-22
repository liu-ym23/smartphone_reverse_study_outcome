package kotlinx.coroutines.internal;

import com.bytedance.framwork.core.sdklib.DBHelper;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;

/* JADX INFO: compiled from: LimitedDispatcher.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001(B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0097Aø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\tj\u0002`\nH\u0016J-\u0010\u0019\u001a\u00020\u00112\n\u0010\u0018\u001a\u00060\tj\u0002`\n2\u0016\u0010\u001a\u001a\u0012\u0012\b\u0012\u00060\u001cR\u00020\u0000\u0012\u0004\u0012\u00020\u00110\u001bH\u0082\bJ\u001c\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\tj\u0002`\nH\u0017J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00132\n\u0010\u0018\u001a\u00060\tj\u0002`\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0096\u0001J\u0010\u0010!\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0010\u0010\"\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0002J\u001f\u0010#\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00132\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00110%H\u0096\u0001J\b\u0010&\u001a\u00020'H\u0002R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\f\u0012\b\u0012\u00060\tj\u0002`\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\t\u0010\u000b\u001a\u00020\fX\u0082\u0004R\u0012\u0010\r\u001a\u00060\u000ej\u0002`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lkotlinx/coroutines/internal/LimitedDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "dispatcher", "parallelism", "", "(Lkotlinx/coroutines/CoroutineDispatcher;I)V", DBHelper.TABLE_QUEUE, "Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "runningWorkers", "Lkotlinx/atomicfu/AtomicInt;", "workerAllocationLock", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "delay", "", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "dispatchInternal", "startWorker", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/LimitedDispatcher$Worker;", "dispatchYield", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "limitedParallelism", "obtainTaskOrDeallocateWorker", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "tryAllocateWorker", "", "Worker", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LimitedDispatcher extends CoroutineDispatcher implements Delay {
    private static final AtomicIntegerFieldUpdater runningWorkers$FU = null;
    private final /* synthetic */ Delay $$delegate_0;
    private final CoroutineDispatcher dispatcher;
    private final int parallelism;
    private final LockFreeTaskQueue<Runnable> queue;

    @Volatile
    private volatile int runningWorkers;
    private final Object workerAllocationLock;

    /* JADX INFO: compiled from: LimitedDispatcher.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0012\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/internal/LimitedDispatcher$Worker;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "currentTask", "(Lkotlinx/coroutines/internal/LimitedDispatcher;Ljava/lang/Runnable;)V", "run", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class Worker implements Runnable {
        private Runnable currentTask;
        final /* synthetic */ LimitedDispatcher this$0;

        public Worker(LimitedDispatcher r1, Runnable r2) {
            this.this$0 = r1;
            this.currentTask = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r0 = 0;
        L16:
            this.currentTask.run();     // Catch: Throwable -> L5
        L7:
            Runnable r1 = LimitedDispatcher.access$obtainTaskOrDeallocateWorker(this.this$0);
            if (r1 == null) goto L9;
            this.currentTask = r1;
            r0 = r0 + 1;
            if (r0 < 16) goto L16;
            if (LimitedDispatcher.access$getDispatcher$p(this.this$0).isDispatchNeeded(this.this$0) == false) goto L16;
            LimitedDispatcher.access$getDispatcher$p(this.this$0).mo3067dispatch(this.this$0, this);
            return;
        L9:
            return;
        L5:
            th = move-exception;
            CoroutineExceptionHandlerKt.handleCoroutineException(EmptyCoroutineContext.INSTANCE, th);
            goto L7
        }
    }

    static {
        runningWorkers$FU = AtomicIntegerFieldUpdater.newUpdater(LimitedDispatcher.class, "runningWorkers");
    }

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
    public void mo3068scheduleResumeAfterDelay(long r1, CancellableContinuation<? super Unit> r3) {
        this.$$delegate_0.mo3068scheduleResumeAfterDelay(r1, r3);
    }

    public static final /* synthetic */ CoroutineDispatcher access$getDispatcher$p(LimitedDispatcher r0) {
        return r0.dispatcher;
    }

    public static final /* synthetic */ Runnable access$obtainTaskOrDeallocateWorker(LimitedDispatcher r0) {
        return r0.obtainTaskOrDeallocateWorker();
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

    private final void dispatchInternal(Runnable r2, Function1<? super Worker, Unit> r3) {
        this.queue.addLast(r2);
        if (runningWorkers$FU.get(this) < this.parallelism) goto L6;
        return;
    L6:
        if (tryAllocateWorker() == true) goto L8;
        return;
    L8:
        Runnable r4 = obtainTaskOrDeallocateWorker();
        if (r4 != null) goto L11;
        return;
    L11:
        r3.invoke(new Worker(this, r4));
    }

    private final boolean tryAllocateWorker() {
        Object r0 = this.workerAllocationLock;
        monitor-enter(r0);
        AtomicIntegerFieldUpdater r1 = runningWorkers$FU;     // Catch: Throwable -> L13
        if (r1.get(this) < this.parallelism) goto L9;
        monitor-exit(r0);
        return false;
    L9:
        r1.incrementAndGet(this);     // Catch: Throwable -> L13
        monitor-exit(r0);
        return true;
    L13:
        th = move-exception;
        throw th;
    }

    private final Runnable obtainTaskOrDeallocateWorker() {
    L2:
        Runnable r0 = this.queue.removeFirstOrNull();
        if (r0 != null) goto L17;
        Object r1 = this.workerAllocationLock;
        monitor-enter(r1);
        AtomicIntegerFieldUpdater r2 = runningWorkers$FU;     // Catch: Throwable -> L14
        r2.decrementAndGet(this);     // Catch: Throwable -> L14
        if (this.queue.getSize() == 0) goto L8;
        r2.incrementAndGet(this);     // Catch: Throwable -> L14
        monitor-exit(r1);
        goto L2
    L8:
        monitor-exit(r1);
        return null;
    L14:
        th = move-exception;
        throw th;
    L17:
        return r0;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* JADX INFO: renamed from: dispatch */
    public void mo3067dispatch(CoroutineContext r1, Runnable r2) {
        this.queue.addLast(r2);
        if (runningWorkers$FU.get(this) < this.parallelism) goto L5;
        return;
    L5:
        if (tryAllocateWorker() == false) goto L12;
        Runnable r3 = obtainTaskOrDeallocateWorker();
        if (r3 == null) goto L13;
        Worker r4 = new Worker(this, r3);
        this.dispatcher.mo3067dispatch(this, r4);
        return;
    L13:
        return;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext r1, Runnable r2) {
        this.queue.addLast(r2);
        if (runningWorkers$FU.get(this) < this.parallelism) goto L5;
        return;
    L5:
        if (tryAllocateWorker() == false) goto L12;
        Runnable r3 = obtainTaskOrDeallocateWorker();
        if (r3 == null) goto L13;
        Worker r4 = new Worker(this, r3);
        this.dispatcher.dispatchYield(this, r4);
        return;
    L13:
        return;
    }
}
