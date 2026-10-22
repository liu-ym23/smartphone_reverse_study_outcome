package kotlinx.coroutines.scheduling;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.ResizableAtomicArray;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: compiled from: CoroutineScheduler.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\b\u0000\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0003IJKB)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0011\u0010\r\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0007H\u0086\bJ\u0011\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0007H\u0082\bJ\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0004H\u0002J\u001a\u0010&\u001a\u00020 2\n\u0010'\u001a\u00060(j\u0002`)2\u0006\u0010*\u001a\u00020+J\u0011\u0010\u0012\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0007H\u0082\bJ\u000e\u0010,\u001a\b\u0018\u00010\u001dR\u00020\u0000H\u0002J\t\u0010-\u001a\u00020$H\u0082\bJ\t\u0010.\u001a\u00020\u0004H\u0082\bJ&\u0010/\u001a\u00020$2\n\u0010'\u001a\u00060(j\u0002`)2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u00100\u001a\u00020\u0018J\u0014\u00101\u001a\u00020$2\n\u00102\u001a\u00060(j\u0002`)H\u0016J\t\u00103\u001a\u00020\u0007H\u0082\bJ\t\u00104\u001a\u00020\u0004H\u0082\bJ\u0014\u00105\u001a\u00020\u00042\n\u00106\u001a\u00060\u001dR\u00020\u0000H\u0002J\u000e\u00107\u001a\b\u0018\u00010\u001dR\u00020\u0000H\u0002J\u0012\u00108\u001a\u00020\u00182\n\u00106\u001a\u00060\u001dR\u00020\u0000J\"\u00109\u001a\u00020$2\n\u00106\u001a\u00060\u001dR\u00020\u00002\u0006\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u0004J\t\u0010<\u001a\u00020\u0007H\u0082\bJ\u000e\u0010=\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020\u0007J\u0018\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0018H\u0002J\u0006\u0010C\u001a\u00020$J\b\u0010D\u001a\u00020\tH\u0016J\t\u0010E\u001a\u00020\u0018H\u0082\bJ\u0012\u0010F\u001a\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u0007H\u0002J\b\u0010G\u001a\u00020\u0018H\u0002J$\u0010H\u001a\u0004\u0018\u00010 *\b\u0018\u00010\u001dR\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u00100\u001a\u00020\u0018H\u0002R\t\u0010\u000b\u001a\u00020\fX\u0082\u0004R\u0015\u0010\r\u001a\u00020\u00048Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\t\u0010\u0010\u001a\u00020\u0011X\u0082\u0004R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0012\u001a\u00020\u00048Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0010\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0019R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\t\u0010\u001a\u001a\u00020\u0011X\u0082\u0004R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u001dR\u00020\u00000\u001c8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "corePoolSize", "", "maxPoolSize", "idleWorkerKeepAliveNs", "", "schedulerName", "", "(IIJLjava/lang/String;)V", "_isTerminated", "Lkotlinx/atomicfu/AtomicBoolean;", "availableCpuPermits", "getAvailableCpuPermits", "()I", "controlState", "Lkotlinx/atomicfu/AtomicLong;", "createdWorkers", "getCreatedWorkers", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "isTerminated", "", "()Z", "parkedWorkersStack", "workers", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "addToGlobalQueue", "task", "Lkotlinx/coroutines/scheduling/Task;", "state", "blockingTasks", "close", "", "createNewWorker", "createTask", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "currentWorker", "decrementBlockingTasks", "decrementCreatedWorkers", "dispatch", "tailDispatch", "execute", "command", "incrementBlockingTasks", "incrementCreatedWorkers", "parkedWorkersStackNextIndex", "worker", "parkedWorkersStackPop", "parkedWorkersStackPush", "parkedWorkersStackTopUpdate", "oldIndex", "newIndex", "releaseCpuPermit", "runSafely", "shutdown", "timeout", "signalBlockingWork", "stateSnapshot", "skipUnpark", "signalCpuWork", "toString", "tryAcquireCpuPermit", "tryCreateWorker", "tryUnpark", "submitToLocalQueue", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CoroutineScheduler implements Executor, Closeable {
    private static final long BLOCKING_MASK = 4398044413952L;
    private static final int BLOCKING_SHIFT = 21;
    private static final int CLAIMED = 0;
    private static final long CPU_PERMITS_MASK = 9223367638808264704L;
    private static final int CPU_PERMITS_SHIFT = 42;
    private static final long CREATED_MASK = 2097151;
    public static final Companion Companion = null;
    public static final int MAX_SUPPORTED_POOL_SIZE = 2097150;
    public static final int MIN_SUPPORTED_POOL_SIZE = 1;
    public static final Symbol NOT_IN_STACK = null;
    private static final int PARKED = -1;
    private static final long PARKED_INDEX_MASK = 2097151;
    private static final long PARKED_VERSION_INC = 2097152;
    private static final long PARKED_VERSION_MASK = -2097152;
    private static final int TERMINATED = 1;
    private static final AtomicIntegerFieldUpdater _isTerminated$FU = null;
    private static final AtomicLongFieldUpdater controlState$FU = null;
    private static final AtomicLongFieldUpdater parkedWorkersStack$FU = null;

    @Volatile
    private volatile int _isTerminated;

    @Volatile
    private volatile long controlState;
    public final int corePoolSize;
    public final GlobalQueue globalBlockingQueue;
    public final GlobalQueue globalCpuQueue;
    public final long idleWorkerKeepAliveNs;
    public final int maxPoolSize;

    @Volatile
    private volatile long parkedWorkersStack;
    public final String schedulerName;
    public final ResizableAtomicArray<Worker> workers;

    /* JADX INFO: compiled from: CoroutineScheduler.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Companion;", "", "()V", "BLOCKING_MASK", "", "BLOCKING_SHIFT", "", "CLAIMED", "CPU_PERMITS_MASK", "CPU_PERMITS_SHIFT", "CREATED_MASK", "MAX_SUPPORTED_POOL_SIZE", "MIN_SUPPORTED_POOL_SIZE", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/Symbol;", "PARKED", "PARKED_INDEX_MASK", "PARKED_VERSION_INC", "PARKED_VERSION_MASK", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: CoroutineScheduler.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[WorkerState.values().length];
            r0[WorkerState.PARKING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[WorkerState.BLOCKING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[WorkerState.CPU_ACQUIRED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[WorkerState.DORMANT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[WorkerState.TERMINATED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: compiled from: CoroutineScheduler.kt */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003H\u0002J\u0010\u0010'\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003H\u0002J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020 H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010 2\u0006\u0010+\u001a\u00020\u000eH\u0002J\n\u0010,\u001a\u0004\u0018\u00010 H\u0002J\n\u0010-\u001a\u0004\u0018\u00010 H\u0002J\u0010\u0010.\u001a\u0004\u0018\u00010 2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020\u0003H\u0002J\b\u00101\u001a\u00020\u000eH\u0002J\u0006\u00102\u001a\u00020\u000eJ\u000e\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0003J\b\u00105\u001a\u00020%H\u0002J\n\u00106\u001a\u0004\u0018\u00010 H\u0002J\b\u00107\u001a\u00020%H\u0016J\u0006\u00108\u001a\u00020\u0010J\b\u00109\u001a\u00020%H\u0002J\b\u0010:\u001a\u00020\u000eH\u0002J\b\u0010;\u001a\u00020%H\u0002J\u000e\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u001dJ\u0016\u0010>\u001a\u0004\u0018\u00010 2\n\u0010?\u001a\u00060\u0003j\u0002`@H\u0002J\b\u0010A\u001a\u00020%H\u0002R$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00198Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0006\u0010\"\u001a\u00020#¨\u0006B"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "index", "", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "indexInArray", "getIndexInArray", "()I", "setIndexInArray", "(I)V", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "mayHaveLocalTasks", "", "minDelayUntilStealableTaskNs", "", "nextParkedWorker", "", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "rngState", "scheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "stolenTask", "Lkotlin/jvm/internal/Ref$ObjectRef;", "Lkotlinx/coroutines/scheduling/Task;", "terminationDeadline", "workerCtl", "Lkotlinx/atomicfu/AtomicInt;", "afterTask", "", "taskMode", "beforeTask", "executeTask", "task", "findAnyTask", "scanLocalQueue", "findBlockingTask", "findCpuTask", "findTask", "idleReset", "mode", "inStack", "isIo", "nextInt", "upperBound", "park", "pollGlobalQueues", "run", "runSingleTask", "runWorker", "tryAcquireCpuPermit", "tryPark", "tryReleaseCpu", "newState", "trySteal", "stealingMode", "Lkotlinx/coroutines/scheduling/StealingMode;", "tryTerminateWorker", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class Worker extends Thread {
        private static final AtomicIntegerFieldUpdater workerCtl$FU = null;
        private volatile int indexInArray;
        public final WorkQueue localQueue;
        public boolean mayHaveLocalTasks;
        private long minDelayUntilStealableTaskNs;
        private volatile Object nextParkedWorker;
        private int rngState;
        public WorkerState state;
        private final Ref.ObjectRef<Task> stolenTask;
        private long terminationDeadline;
        final /* synthetic */ CoroutineScheduler this$0;

        @Volatile
        private volatile int workerCtl;

        static {
            workerCtl$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl");
        }

        public static final AtomicIntegerFieldUpdater getWorkerCtl$FU() {
            return workerCtl$FU;
        }

        public final int getWorkerCtl() {
            return this.workerCtl;
        }

        private Worker(CoroutineScheduler r1) {
            this.this$0 = r1;
            setDaemon(true);
            this.localQueue = new WorkQueue();
            this.stolenTask = new Ref.ObjectRef();
            this.state = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
            this.rngState = Random.Default.nextInt();
        }

        public static final /* synthetic */ CoroutineScheduler access$getThis$0$p(Worker r0) {
            return r0.this$0;
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        public final void setIndexInArray(int r3) {
            StringBuilder r0 = new StringBuilder().append(this.this$0.schedulerName).append("-worker-");
            if (r3 != 0) goto L5;
            String r1 = "TERMINATED";
        L6:
            setName(r0.append(r1).toString());
            this.indexInArray = r3;
            return;
        L5:
            r1 = String.valueOf(r3);
            goto L6
        }

        public Worker(CoroutineScheduler r1, int r2) {
            this(r1);
            setIndexInArray(r2);
        }

        public final CoroutineScheduler getScheduler() {
            return access$getThis$0$p(this);
        }

        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final void setNextParkedWorker(Object r1) {
            this.nextParkedWorker = r1;
        }

        private final boolean tryAcquireCpuPermit() {
            if (this.state == WorkerState.CPU_ACQUIRED) goto L20;
            CoroutineScheduler r0 = this.this$0;
            AtomicLongFieldUpdater r1 = CoroutineScheduler.access$getControlState$FU$p();
        L6:
            long r5 = r1.get(r0);
            if (((int) ((CoroutineScheduler.CPU_PERMITS_MASK & r5) >> 42)) == 0) goto L8;
            if (CoroutineScheduler.access$getControlState$FU$p().compareAndSet(r0, r5, r5 - 4398046511104L) == false) goto L6;
            boolean r2 = true;
        L12:
            if (r2 == false) goto L15;
            this.state = WorkerState.CPU_ACQUIRED;
            return true;
        L15:
            return false;
        L8:
            r2 = false;
            goto L12
        L20:
            return true;
        }

        public final boolean tryReleaseCpu(WorkerState r7) {
            WorkerState r0 = this.state;
            if (r0 != WorkerState.CPU_ACQUIRED) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L8;
            CoroutineScheduler r2 = this.this$0;
            CoroutineScheduler.access$getControlState$FU$p().addAndGet(r2, 4398046511104L);
        L8:
            if (r0 == r7) goto L10;
            this.state = r7;
        L10:
            return r1;
        L5:
            r1 = false;
            goto L6
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            runWorker();
        }

        private final void runWorker() {
        L3:
            boolean r1 = false;
        L5:
            if (this.this$0.isTerminated() == true) goto L17;
            if (this.state == WorkerState.TERMINATED) goto L17;
            Task r2 = findTask(this.mayHaveLocalTasks);
            if (r2 != null) goto L10;
            this.mayHaveLocalTasks = false;
            if (this.minDelayUntilStealableTaskNs != 0) goto L13;
            tryPark();
            goto L5
        L13:
            if (r1 == true) goto L15;
            r1 = true;
            goto L5
        L15:
            tryReleaseCpu(WorkerState.PARKING);
            Thread.interrupted();
            LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
            this.minDelayUntilStealableTaskNs = 0;
            goto L3
        L10:
            this.minDelayUntilStealableTaskNs = 0;
            executeTask(r2);
        L17:
            tryReleaseCpu(WorkerState.TERMINATED);
        }

        public final long runSingleTask() {
            WorkerState r0 = this.state;
            boolean r2 = true;
            if (r0 != WorkerState.CPU_ACQUIRED) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L8;
            Task r4 = findCpuTask();
        L10:
            if (r4 != null) goto L15;
            long r3 = this.minDelayUntilStealableTaskNs;
            if (r3 != 0) goto L29;
            return -1;
        L29:
            return r3;
        L15:
            this.this$0.runSafely(r4);
            if (r1 == true) goto L19;
            CoroutineScheduler.access$getControlState$FU$p().addAndGet(this.this$0, CoroutineScheduler.PARKED_VERSION_MASK);
        L19:
            if (DebugKt.getASSERTIONS_ENABLED() == true) goto L21;
        L28:
            return 0;
        L21:
            if (this.state == r0) goto L24;
            r2 = false;
        L24:
            if (r2 == true) goto L28;
            throw new AssertionError();
        L8:
            r4 = findBlockingTask();
            goto L10
        L5:
            r1 = false;
            goto L6
        }

        public final boolean isIo() {
            if (this.state != WorkerState.BLOCKING) goto L5;
            return true;
        L5:
            return false;
        }

        private final void tryPark() {
            if (inStack() == true) goto L6;
            this.this$0.parkedWorkersStackPush(this);
            return;
        L6:
            workerCtl$FU.set(this, -1);
        L8:
            if (inStack() == false) goto L17;
            if (workerCtl$FU.get(this) != (-1)) goto L22;
            if (this.this$0.isTerminated() == true) goto L23;
            if (this.state == WorkerState.TERMINATED) goto L24;
            tryReleaseCpu(WorkerState.PARKING);
            Thread.interrupted();
            park();
            goto L8
        L24:
            return;
        L23:
            return;
        L22:
            return;
        }

        private final boolean inStack() {
            if (this.nextParkedWorker == CoroutineScheduler.NOT_IN_STACK) goto L5;
            return true;
        L5:
            return false;
        }

        private final void beforeTask(int r1) {
            if (r1 != 0) goto L5;
            return;
        L5:
            if (tryReleaseCpu(WorkerState.BLOCKING) == false) goto L8;
            this.this$0.signalCpuWork();
            return;
        }

        private final void afterTask(int r4) {
            if (r4 != 0) goto L4;
            return;
        L4:
            CoroutineScheduler r5 = this.this$0;
            CoroutineScheduler.access$getControlState$FU$p().addAndGet(r5, CoroutineScheduler.PARKED_VERSION_MASK);
            WorkerState r6 = this.state;
            if (r6 != WorkerState.TERMINATED) goto L7;
            return;
        L7:
            if (DebugKt.getASSERTIONS_ENABLED() == true) goto L9;
        L16:
            this.state = WorkerState.DORMANT;
            return;
        L9:
            if (r6 != WorkerState.BLOCKING) goto L11;
            boolean r7 = true;
        L12:
            if (r7 == true) goto L16;
            throw new AssertionError();
        L11:
            r7 = false;
            goto L12
        }

        public final int nextInt(int r3) {
            int r0 = this.rngState;
            int r1 = r0 ^ (r0 << 13);
            int r2 = r1 ^ (r1 >> 17);
            int r4 = r2 ^ (r2 << 5);
            this.rngState = r4;
            int r5 = r3 - 1;
            if ((r5 & r3) != 0) goto L7;
            return r5 & r4;
        L7:
            return (Integer.MAX_VALUE & r4) % r3;
        }

        private final void park() {
            if (this.terminationDeadline != 0) goto L5;
            this.terminationDeadline = System.nanoTime() + this.this$0.idleWorkerKeepAliveNs;
        L5:
            LockSupport.parkNanos(this.this$0.idleWorkerKeepAliveNs);
            if ((System.nanoTime() - this.terminationDeadline) < 0) goto L9;
            this.terminationDeadline = 0;
            tryTerminateWorker();
            return;
        }

        private final void tryTerminateWorker() {
            ResizableAtomicArray<Worker> r0 = this.this$0.workers;
            CoroutineScheduler r1 = this.this$0;
            monitor-enter(r0);
        L23:
            th = move-exception;
            throw th;
        L5:
            if (r1.isTerminated() == false) goto L9;
            monitor-exit(r0);
            return;
        L9:
            if (((int) (CoroutineScheduler.access$getControlState$FU$p().get(r1) & 2097151)) > r1.corePoolSize) goto L13;
            monitor-exit(r0);
            return;
        L13:
            if (workerCtl$FU.compareAndSet(this, -1, 1) == true) goto L16;
            monitor-exit(r0);
            return;
        L16:
            int r2 = this.indexInArray;     // Catch: Throwable -> L23
            setIndexInArray(0);     // Catch: Throwable -> L23
            r1.parkedWorkersStackTopUpdate(this, r2, 0);     // Catch: Throwable -> L23
            int r3 = (int) (CoroutineScheduler.access$getControlState$FU$p().getAndDecrement(r1) & 2097151);     // Catch: Throwable -> L23
            if (r3 == r2) goto L19;
            Worker r4 = r1.workers.get(r3);     // Catch: Throwable -> L23
            Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L23
            Worker r5 = r4;     // Catch: Throwable -> L23
            r1.workers.setSynchronized(r2, r5);     // Catch: Throwable -> L23
            r5.setIndexInArray(r2);     // Catch: Throwable -> L23
            r1.parkedWorkersStackTopUpdate(r5, r3, r2);     // Catch: Throwable -> L23
        L19:
            r1.workers.setSynchronized(r3, null);     // Catch: Throwable -> L23
            Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L23
            monitor-exit(r0);
            this.state = WorkerState.TERMINATED;
        }

        private final void idleReset(int r3) {
            this.terminationDeadline = 0;
            if (this.state == WorkerState.PARKING) goto L5;
            return;
        L5:
            if (DebugKt.getASSERTIONS_ENABLED() == false) goto L14;
            boolean r0 = true;
            if (r3 == 1) goto L10;
            r0 = false;
        L10:
            if (r0 == true) goto L14;
            throw new AssertionError();
        L14:
            this.state = WorkerState.BLOCKING;
        }

        public final Task findTask(boolean r2) {
            if (tryAcquireCpuPermit() == false) goto L7;
            return findAnyTask(r2);
        L7:
            return findBlockingTask();
        }

        private final Task findBlockingTask() {
            Task r0 = this.localQueue.pollBlocking();
            if (r0 != null) goto L8;
            Task r1 = this.this$0.globalBlockingQueue.removeFirstOrNull();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return trySteal(1);
        L8:
            return r0;
        }

        private final Task findCpuTask() {
            Task r0 = this.localQueue.pollCpu();
            if (r0 != null) goto L8;
            Task r1 = this.this$0.globalBlockingQueue.removeFirstOrNull();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return trySteal(2);
        L8:
            return r0;
        }

        private final Task findAnyTask(boolean r2) {
            if (r2 == true) goto L4;
            Task r3 = pollGlobalQueues();
            if (r3 == null) goto L22;
            return r3;
        L22:
            return trySteal(3);
        L4:
            if (nextInt(this.this$0.corePoolSize * 2) != 0) goto L6;
            boolean r4 = true;
        L7:
            if (r4 == false) goto L11;
            Task r0 = pollGlobalQueues();
            if (r0 == null) goto L11;
            return r0;
        L11:
            Task r1 = this.localQueue.poll();
            if (r1 == null) goto L14;
            return r1;
        L14:
            if (r4 == true) goto L22;
            Task r5 = pollGlobalQueues();
            if (r5 == null) goto L22;
            return r5;
        L6:
            r4 = false;
            goto L7
        }

        private final Task pollGlobalQueues() {
            if (nextInt(2) != 0) goto L9;
            Task r0 = this.this$0.globalCpuQueue.removeFirstOrNull();
            if (r0 == null) goto L8;
            return r0;
        L8:
            return this.this$0.globalBlockingQueue.removeFirstOrNull();
        L9:
            Task r1 = this.this$0.globalBlockingQueue.removeFirstOrNull();
            if (r1 == null) goto L13;
            return r1;
        L13:
            return this.this$0.globalCpuQueue.removeFirstOrNull();
        }

        private final Task trySteal(int r18) {
            int r1 = (int) (CoroutineScheduler.access$getControlState$FU$p().get(this.this$0) & 2097151);
            if (r1 >= 2) goto L5;
            return null;
        L5:
            int r2 = nextInt(r1);
            CoroutineScheduler r4 = this.this$0;
            int r7 = 0;
            long r8 = Long.MAX_VALUE;
        L7:
            if (r7 >= r1) goto L24;
            r2 = r2 + 1;
            if (r2 <= r1) goto L11;
            r2 = 1;
        L11:
            Worker r12 = r4.workers.get(r2);
            if (r12 == null) goto L22;
            if (r12 == this) goto L22;
            long r13 = r12.localQueue.trySteal(r18, this.stolenTask);
            if (r13 == (-1)) goto L16;
            if (r13 <= 0) goto L22;
            r8 = Math.min(r8, r13);
            goto L22
        L16:
            Task r3 = this.stolenTask.element;
            this.stolenTask.element = null;
            return r3;
        L22:
            r7 = r7 + 1;
            goto L7
        L24:
            if (r8 != Long.MAX_VALUE) goto L27;
            r8 = 0;
        L27:
            this.minDelayUntilStealableTaskNs = r8;
            return null;
        }

        private final void executeTask(Task r3) {
            int r0 = r3.taskContext.getTaskMode();
            idleReset(r0);
            beforeTask(r0);
            this.this$0.runSafely(r3);
            afterTask(r0);
        }
    }

    /* JADX INFO: compiled from: CoroutineScheduler.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum WorkerState extends Enum<WorkerState> {
        private static final /* synthetic */ WorkerState[] $VALUES = null;
        public static final WorkerState BLOCKING = null;
        public static final WorkerState CPU_ACQUIRED = null;
        public static final WorkerState DORMANT = null;
        public static final WorkerState PARKING = null;
        public static final WorkerState TERMINATED = null;

        private static final /* synthetic */ WorkerState[] $values() {
            return new WorkerState[]{CPU_ACQUIRED, BLOCKING, PARKING, DORMANT, TERMINATED};
        }

        public static WorkerState valueOf(String r1) {
            return (WorkerState) Enum.valueOf(WorkerState.class, r1);
        }

        public static WorkerState[] values() {
            return (WorkerState[]) $VALUES.clone();
        }

        private WorkerState(String r1, int r2) {
            super(r1, r2);
        }

        static {
            CPU_ACQUIRED = new WorkerState("CPU_ACQUIRED", 0);
            BLOCKING = new WorkerState("BLOCKING", 1);
            PARKING = new WorkerState("PARKING", 2);
            DORMANT = new WorkerState("DORMANT", 3);
            TERMINATED = new WorkerState("TERMINATED", 4);
            $VALUES = $values();
        }
    }

    private final int blockingTasks(long r3) {
        return (int) ((r3 & BLOCKING_MASK) >> 21);
    }

    private final int createdWorkers(long r3) {
        return (int) (r3 & 2097151);
    }

    private final void loop$atomicfu(AtomicLongFieldUpdater r3, Function1<? super Long, Unit> r4, Object r5) {
    L2:
        r4.invoke(Long.valueOf(r3.get(r5)));
        goto L2
    }

    public final int availableCpuPermits(long r3) {
        return (int) ((r3 & CPU_PERMITS_MASK) >> 42);
    }

    public CoroutineScheduler(int r4, int r5, long r6, String r8) {
        this.corePoolSize = r4;
        this.maxPoolSize = r5;
        this.idleWorkerKeepAliveNs = r6;
        this.schedulerName = r8;
        boolean r0 = true;
        if (r4 < 1) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L31;
        if (r5 < r4) goto L9;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L29;
        if (r5 > 2097150) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L27;
        if (r6 > 0) goto L21;
        r0 = false;
    L21:
        if (r0 == false) goto L25;
        this.globalCpuQueue = new GlobalQueue();
        this.globalBlockingQueue = new GlobalQueue();
        this.workers = new ResizableAtomicArray((r4 + 1) * 2);
        this.controlState = ((long) r4) << 42;
        this._isTerminated = 0;
        return;
    L25:
        throw new IllegalArgumentException(("Idle worker keep alive time " + r6 + " must be positive").toString());
    L27:
        throw new IllegalArgumentException(("Max pool size " + r5 + " should not exceed maximal supported number of threads 2097150").toString());
    L15:
        r3 = false;
        goto L16
    L29:
        throw new IllegalArgumentException(("Max pool size " + r5 + " should be greater than or equals to core pool size " + r4).toString());
    L9:
        r2 = false;
        goto L11
    L31:
        throw new IllegalArgumentException(("Core pool size " + r4 + " should be at least 1").toString());
    L5:
        r1 = false;
        goto L6
    }

    public static final /* synthetic */ AtomicLongFieldUpdater access$getControlState$FU$p() {
        return controlState$FU;
    }

    public /* synthetic */ CoroutineScheduler(int r7, int r8, long r9, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r9 = TasksKt.IDLE_WORKER_KEEP_ALIVE_NS;
    L5:
        long r3 = r9;
        if ((r12 & 8) == 0) goto L8;
        r11 = TasksKt.DEFAULT_SCHEDULER_NAME;
    L8:
        this(r7, r8, r3, r11);
    }

    public final void parkedWorkersStackTopUpdate(Worker r10, int r11, int r12) {
        AtomicLongFieldUpdater r0 = parkedWorkersStack$FU;
    L3:
        long r3 = r0.get(this);
        int r1 = (int) (2097151 & r3);
        long r5 = (2097152 + r3) & PARKED_VERSION_MASK;
        if (r1 != r11) goto L8;
        if (r12 != 0) goto L7;
        r1 = parkedWorkersStackNextIndex(r10);
        goto L8
    L7:
        r1 = r12;
    L8:
        if (r1 < 0) goto L3;
        if (parkedWorkersStack$FU.compareAndSet(this, r3, r5 | ((long) r1)) == false) goto L3;
    }

    public final boolean parkedWorkersStackPush(Worker r11) {
        if (r11.getNextParkedWorker() == NOT_IN_STACK) goto L5;
        return false;
    L5:
        AtomicLongFieldUpdater r0 = parkedWorkersStack$FU;
    L6:
        long r5 = r0.get(this);
        int r1 = (int) (2097151 & r5);
        long r3 = (2097152 + r5) & PARKED_VERSION_MASK;
        int r7 = r11.getIndexInArray();
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L15;
        if (r7 == 0) goto L10;
        boolean r8 = true;
    L11:
        if (r8 == true) goto L15;
        throw new AssertionError();
    L10:
        r8 = false;
    L15:
        r11.setNextParkedWorker(this.workers.get(r1));
        if (parkedWorkersStack$FU.compareAndSet(this, r5, ((long) r7) | r3) == false) goto L6;
        return true;
    }

    private final Worker parkedWorkersStackPop() {
        AtomicLongFieldUpdater r0 = parkedWorkersStack$FU;
    L3:
        long r3 = r0.get(this);
        ResizableAtomicArray<Worker> r2 = this.workers;
        Worker r7 = r2.get((int) (2097151 & r3));
        if (r7 == null) goto L5;
        long r1 = (2097152 + r3) & PARKED_VERSION_MASK;
        int r5 = parkedWorkersStackNextIndex(r7);
        if (r5 < 0) goto L3;
        if (parkedWorkersStack$FU.compareAndSet(this, r3, ((long) r5) | r1) == false) goto L3;
        r7.setNextParkedWorker(NOT_IN_STACK);
        return r7;
    L5:
        return null;
    }

    private final int parkedWorkersStackNextIndex(Worker r1) {
        Object r0 = r1.getNextParkedWorker();
    L4:
        if (r0 == NOT_IN_STACK) goto L5;
        if (r0 == null) goto L8;
        Worker r2 = (Worker) r0;
        int r3 = r2.getIndexInArray();
        if (r3 != 0) goto L12;
        r0 = r2.getNextParkedWorker();
        goto L4
    L12:
        return r3;
    L8:
        return 0;
    L5:
        return -1;
    }

    private final int getCreatedWorkers() {
        return (int) (access$getControlState$FU$p().get(this) & 2097151);
    }

    private final int getAvailableCpuPermits() {
        return (int) ((controlState$FU.get(this) & CPU_PERMITS_MASK) >> 42);
    }

    private final int incrementCreatedWorkers() {
        return (int) (controlState$FU.incrementAndGet(this) & 2097151);
    }

    private final int decrementCreatedWorkers() {
        return (int) (access$getControlState$FU$p().getAndDecrement(this) & 2097151);
    }

    private final long incrementBlockingTasks() {
        return controlState$FU.addAndGet(this, 2097152);
    }

    private final void decrementBlockingTasks() {
        access$getControlState$FU$p().addAndGet(this, PARKED_VERSION_MASK);
    }

    private final boolean tryAcquireCpuPermit() {
        AtomicLongFieldUpdater r0 = access$getControlState$FU$p();
    L3:
        long r3 = r0.get(this);
        if (((int) ((CPU_PERMITS_MASK & r3) >> 42)) == 0) goto L5;
        AtomicLongFieldUpdater r1 = access$getControlState$FU$p();
        if (r1.compareAndSet(this, r3, r3 - 4398046511104L) == false) goto L3;
        return true;
    L5:
        return false;
    }

    private final long releaseCpuPermit() {
        return access$getControlState$FU$p().addAndGet(this, 4398046511104L);
    }

    public final boolean isTerminated() {
        if (_isTerminated$FU.get(this) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    static {
        Companion = new Companion(null);
        parkedWorkersStack$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
        controlState$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
        _isTerminated$FU = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");
        NOT_IN_STACK = new Symbol("NOT_IN_STACK");
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r7) {
        dispatch$default(this, r7, null, false, 6, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        shutdown(10000);
    }

    public final void shutdown(long r9) {
        boolean r1 = false;
        if (_isTerminated$FU.compareAndSet(this, 0, 1) == true) goto L5;
        return;
    L5:
        Worker r0 = currentWorker();
        ResizableAtomicArray<Worker> r3 = this.workers;
        monitor-enter(r3);
        int r4 = (int) (access$getControlState$FU$p().get(this) & 2097151);
        monitor-exit(r3);
        if (1 > r4) goto L30;
        int r5 = 1;
    L12:
        Worker r6 = this.workers.get(r5);
        Intrinsics.checkNotNull(r6);
        Worker r7 = r6;
        if (r7 != r0) goto L15;
    L28:
        if (r5 == r4) goto L30;
        r5 = r5 + 1;
    L15:
        if (r7.isAlive() == false) goto L17;
        LockSupport.unpark(r7);
        r7.join(r9);
        goto L15
    L17:
        WorkerState r8 = r7.state;
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L20;
    L27:
        r7.localQueue.offloadAllWorkTo(this.globalBlockingQueue);
        goto L28
    L20:
        if (r8 != WorkerState.TERMINATED) goto L22;
        boolean r10 = true;
    L23:
        if (r10 == true) goto L27;
        throw new AssertionError();
    L22:
        r10 = false;
    L30:
        this.globalBlockingQueue.close();
        this.globalCpuQueue.close();
    L31:
        if (r0 == null) goto L34;
        Task r11 = r0.findTask(true);
        if (r11 == null) goto L34;
    L51:
        runSafely(r11);
    L34:
        r11 = this.globalCpuQueue.removeFirstOrNull();
        if (r11 != null) goto L51;
        r11 = this.globalBlockingQueue.removeFirstOrNull();
        if (r11 != null) goto L51;
        if (r0 == null) goto L41;
        r0.tryReleaseCpu(WorkerState.TERMINATED);
    L41:
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L43;
    L49:
        parkedWorkersStack$FU.set(this, 0);
        controlState$FU.set(this, 0);
        return;
    L43:
        if (((int) ((controlState$FU.get(this) & CPU_PERMITS_MASK) >> 42)) != this.corePoolSize) goto L45;
        r1 = true;
    L45:
        if (r1 == true) goto L49;
        throw new AssertionError();
    L52:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void dispatch$default(CoroutineScheduler r0, Runnable r1, TaskContext r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = TasksKt.NonBlockingContext;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = false;
    L8:
        r0.dispatch(r1, r2, r3);
    }

    public final void dispatch(Runnable r6, TaskContext r7, boolean r8) {
        AbstractTimeSource r0 = AbstractTimeSourceKt.getTimeSource();
        if (r0 == null) goto L5;
        r0.trackTask();
    L5:
        Task r9 = createTask(r6, r7);
        boolean r1 = false;
        if (r9.taskContext.getTaskMode() != 1) goto L8;
        boolean r10 = true;
    L9:
        if (r10 == false) goto L11;
        long r2 = controlState$FU.addAndGet(this, 2097152);
    L12:
        Worker r4 = currentWorker();
        Task r11 = submitToLocalQueue(r4, r9, r8);
        if (r11 != null) goto L15;
    L19:
        if (r8 == false) goto L22;
        if (r4 == null) goto L22;
        r1 = true;
    L22:
        if (r10 == false) goto L24;
        signalBlockingWork(r2, r1);
        return;
    L24:
        if (r1 == false) goto L26;
        return;
    L26:
        signalCpuWork();
        return;
    L15:
        if (addToGlobalQueue(r11) == true) goto L19;
        throw new RejectedExecutionException(this.schedulerName + " was terminated");
    L11:
        r2 = 0;
        goto L12
    L8:
        r10 = false;
        goto L9
    }

    public final Task createTask(Runnable r3, TaskContext r4) {
        long r0 = TasksKt.schedulerTimeSource.nanoTime();
        if ((r3 instanceof Task) == false) goto L7;
        Task r5 = (Task) r3;
        r5.submissionTime = r0;
        r5.taskContext = r4;
        return r5;
    L7:
        return new TaskImpl(r3, r0, r4);
    }

    private final void signalBlockingWork(long r1, boolean r3) {
        if (r3 == false) goto L5;
        return;
    L5:
        if (tryUnpark() == false) goto L8;
        return;
    L8:
        if (tryCreateWorker(r1) == false) goto L10;
        return;
    L10:
        tryUnpark();
    }

    public final void signalCpuWork() {
        if (tryUnpark() == false) goto L6;
        return;
    L6:
        if (tryCreateWorker$default(this, 0, 1, null) == false) goto L8;
        return;
    L8:
        tryUnpark();
    }

    static /* synthetic */ boolean tryCreateWorker$default(CoroutineScheduler r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = controlState$FU.get(r0);
    L6:
        return r0.tryCreateWorker(r1);
    }

    private final boolean tryCreateWorker(long r4) {
        if (RangesKt.coerceAtLeast(((int) (2097151 & r4)) - ((int) ((r4 & BLOCKING_MASK) >> 21)), 0) >= this.corePoolSize) goto L11;
        int r5 = createNewWorker();
        if (r5 == 1) goto L7;
    L9:
        if (r5 <= 0) goto L11;
        return true;
    L7:
        if (this.corePoolSize <= 1) goto L9;
        createNewWorker();
    L11:
        return false;
    }

    private final boolean tryUnpark() {
    L2:
        Worker r0 = parkedWorkersStackPop();
        if (r0 == null) goto L4;
        if (Worker.getWorkerCtl$FU().compareAndSet(r0, -1, 0) == false) goto L2;
        LockSupport.unpark(r0);
        return true;
    L4:
        return false;
    }

    private final int createNewWorker() {
        ResizableAtomicArray<Worker> r0 = this.workers;
        monitor-enter(r0);
    L37:
        th = move-exception;
        throw th;
    L5:
        if (isTerminated() == false) goto L9;
        monitor-exit(r0);
        return -1;
    L9:
        AtomicLongFieldUpdater r1 = controlState$FU;     // Catch: Throwable -> L37
        long r2 = r1.get(this);     // Catch: Throwable -> L37
        int r6 = (int) (r2 & 2097151);     // Catch: Throwable -> L37
        boolean r3 = false;
        int r4 = RangesKt.coerceAtLeast(r6 - ((int) ((r2 & BLOCKING_MASK) >> 21)), 0);     // Catch: Throwable -> L37
        if (r4 < this.corePoolSize) goto L14;
        monitor-exit(r0);
        return 0;
    L14:
        if (r6 < this.maxPoolSize) goto L17;
        monitor-exit(r0);
        return 0;
    L17:
        int r7 = ((int) (access$getControlState$FU$p().get(this) & 2097151)) + 1;     // Catch: Throwable -> L37
        if (r7 > 0) goto L20;
    L22:
        boolean r8 = false;
    L23:
        if (r8 == false) goto L36;
        Worker r9 = new Worker(this, r7);     // Catch: Throwable -> L37
        this.workers.setSynchronized(r7, r9);     // Catch: Throwable -> L37
        if (r7 != ((int) (2097151 & r1.incrementAndGet(this)))) goto L28;
        r3 = true;
    L28:
        if (r3 == false) goto L34;
        int r5 = r4 + 1;
        monitor-exit(r0);
        r9.start();
        return r5;
    L34:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L37
    L36:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L37
    L20:
        if (this.workers.get(r7) != null) goto L22;
        r8 = true;
        goto L23
    }

    private final Task submitToLocalQueue(Worker r2, Task r3, boolean r4) {
        if (r2 != null) goto L5;
        return r3;
    L5:
        if (r2.state != WorkerState.TERMINATED) goto L8;
        return r3;
    L8:
        if (r3.taskContext.getTaskMode() == 0) goto L10;
    L12:
        r2.mayHaveLocalTasks = true;
        return r2.localQueue.add(r3, r4);
    L10:
        if (r2.state != WorkerState.BLOCKING) goto L12;
        return r3;
    }

    private final Worker currentWorker() {
        Thread r0 = Thread.currentThread();
        if ((r0 instanceof Worker) == false) goto L5;
        Worker r1 = (Worker) r0;
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        if (Intrinsics.areEqual(Worker.access$getThis$0$p(r1), this) == true) goto L10;
        return null;
    L10:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public String toString() {
        ArrayList r0 = new ArrayList();
        int r1 = this.workers.currentLength();
        int r2 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
        int r8 = 1;
    L3:
        if (r8 >= r1) goto L26;
        Worker r9 = this.workers.get(r8);
        if (r9 == null) goto L25;
        int r10 = r9.localQueue.getSize$kotlinx_coroutines_core();
        int r11 = WhenMappings.$EnumSwitchMapping$0[r9.state.ordinal()];
        if (r11 != 1) goto L10;
        r5 = r5 + 1;
        goto L25
    L10:
        if (r11 != 2) goto L12;
        r4 = r4 + 1;
        r0.add(new StringBuilder().append(r10).append('b').toString());
        goto L25
    L12:
        if (r11 != 3) goto L14;
        r2 = r2 + 1;
        r0.add(new StringBuilder().append(r10).append('c').toString());
        goto L25
    L14:
        if (r11 != 4) goto L16;
        r6 = r6 + 1;
        if (r10 <= 0) goto L25;
        r0.add(new StringBuilder().append(r10).append('d').toString());
        goto L25
    L16:
        if (r11 != 5) goto L25;
        r7 = r7 + 1;
    L25:
        r8 = r8 + 1;
        goto L3
    L26:
        long r12 = controlState$FU.get(this);
        StringBuilder r3 = new StringBuilder();
        r3.append(this.schedulerName).append('@').append(DebugStringsKt.getHexAddress(this)).append("[Pool Size {core = ").append(this.corePoolSize).append(", max = ").append(this.maxPoolSize).append("}, Worker States {CPU = ").append(r2).append(", blocking = ").append(r4).append(", parked = ").append(r5).append(", dormant = ").append(r6).append(", terminated = ").append(r7).append("}, running workers queues = ").append(r0).append(", global CPU queue size = ").append(this.globalCpuQueue.getSize()).append(", global blocking queue size = ").append(this.globalBlockingQueue.getSize());
        r3.append(", Control State {created workers= ").append((int) (2097151 & r12)).append(", blocking tasks = ").append((int) ((BLOCKING_MASK & r12) >> 21)).append(", CPUs acquired = ").append(this.corePoolSize - ((int) ((CPU_PERMITS_MASK & r12) >> 42))).append("}]");
        return r3.toString();
    }

    public final void runSafely(Task r2) {
        r2.run();     // Catch: Throwable -> L6
        AbstractTimeSource r1 = AbstractTimeSourceKt.getTimeSource();
        if (r1 == null) goto L11;
    L5:
        r1.unTrackTask();
        return;
    L11:
        return;
    L6:
        th = move-exception;
        Thread r3 = Thread.currentThread();     // Catch: Throwable -> L12
        r3.getUncaughtExceptionHandler().uncaughtException(r3, th);     // Catch: Throwable -> L12
        r1 = AbstractTimeSourceKt.getTimeSource();
        if (r1 != null) goto L5;
        return;
    L12:
        th = move-exception;
        AbstractTimeSource r4 = AbstractTimeSourceKt.getTimeSource();
        if (r4 == null) goto L16;
        r4.unTrackTask();
    L16:
        throw th;
    }

    private final boolean addToGlobalQueue(Task r3) {
        boolean r1 = true;
        if (r3.taskContext.getTaskMode() == 1) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L9;
        return this.globalBlockingQueue.addLast(r3);
    L9:
        return this.globalCpuQueue.addLast(r3);
    }
}
