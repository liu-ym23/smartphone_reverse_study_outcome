package h.a.i3;

import androidx.core.location.LocationRequestCompat;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import h.a.f3.c0;
import h.a.f3.f0;
import h.a.q0;
import h.a.r0;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0000\u0018\u0000 X2\u00020\\2\u00020]:\u0003XYZB+\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\u0082\b¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001d\u001a\u00020\n2\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\u0082\b¢\u0006\u0004\b\u001f\u0010\u0011J\u0015\u0010!\u001a\b\u0018\u00010 R\u00020\u0000H\u0002¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0013H\u0082\b¢\u0006\u0004\b#\u0010\u0015J\u0010\u0010$\u001a\u00020\u0001H\u0082\b¢\u0006\u0004\b$\u0010\u0017J-\u0010&\u001a\u00020\u00132\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020\f¢\u0006\u0004\b&\u0010'J\u001b\u0010)\u001a\u00020\u00132\n\u0010(\u001a\u00060\u0018j\u0002`\u0019H\u0016¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0004H\u0082\b¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0001H\u0082\b¢\u0006\u0004\b-\u0010\u0017J\u001b\u0010/\u001a\u00020\u00012\n\u0010.\u001a\u00060 R\u00020\u0000H\u0002¢\u0006\u0004\b/\u00100J\u0015\u00101\u001a\b\u0018\u00010 R\u00020\u0000H\u0002¢\u0006\u0004\b1\u0010\"J\u0019\u00102\u001a\u00020\f2\n\u0010.\u001a\u00060 R\u00020\u0000¢\u0006\u0004\b2\u00103J)\u00106\u001a\u00020\u00132\n\u0010.\u001a\u00060 R\u00020\u00002\u0006\u00104\u001a\u00020\u00012\u0006\u00105\u001a\u00020\u0001¢\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u00020\u0004H\u0082\b¢\u0006\u0004\b8\u0010,J\u0015\u00109\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b9\u0010:J\u0015\u0010<\u001a\u00020\u00132\u0006\u0010;\u001a\u00020\u0004¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\fH\u0002¢\u0006\u0004\b?\u0010@J\r\u0010A\u001a\u00020\u0013¢\u0006\u0004\bA\u0010\u0015J\u000f\u0010B\u001a\u00020\u0006H\u0016¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020\fH\u0082\b¢\u0006\u0004\bD\u0010EJ\u0019\u0010F\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\fH\u0002¢\u0006\u0004\bH\u0010EJ+\u0010I\u001a\u0004\u0018\u00010\n*\b\u0018\u00010 R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010%\u001a\u00020\fH\u0002¢\u0006\u0004\bI\u0010JR\u0015\u0010\u0010\u001a\u00020\u00018Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u0017R\u0014\u0010\u0002\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010LR\u0015\u0010\u001f\u001a\u00020\u00018Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010\u0017R\u0014\u0010O\u001a\u00020N8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010Q\u001a\u00020N8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bQ\u0010PR\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010RR\u0011\u0010S\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\bS\u0010ER\u0014\u0010\u0003\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010LR\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010TR\u001e\u0010V\u001a\f\u0012\b\u0012\u00060 R\u00020\u00000U8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bV\u0010W¨\u0006["}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "addToGlobalQueue", "(Lkotlinx/coroutines/scheduling/Task;)Z", WsConstants.KEY_CONNECTION_STATE, "availableCpuPermits", "(J)I", "blockingTasks", "", "close", "()V", "createNewWorker", "()I", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "createTask", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;)Lkotlinx/coroutines/scheduling/Task;", "createdWorkers", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "currentWorker", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "decrementBlockingTasks", "decrementCreatedWorkers", "tailDispatch", "dispatch", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "command", "execute", "(Ljava/lang/Runnable;)V", "incrementBlockingTasks", "()J", "incrementCreatedWorkers", "worker", "parkedWorkersStackNextIndex", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)I", "parkedWorkersStackPop", "parkedWorkersStackPush", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)Z", "oldIndex", "newIndex", "parkedWorkersStackTopUpdate", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "releaseCpuPermit", "runSafely", "(Lkotlinx/coroutines/scheduling/Task;)V", LocationMonitorConst.TIMEOUT, "shutdown", "(J)V", "skipUnpark", "signalBlockingWork", "(Z)V", "signalCpuWork", "toString", "()Ljava/lang/String;", "tryAcquireCpuPermit", "()Z", "tryCreateWorker", "(J)Z", "tryUnpark", "submitToLocalQueue", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "getAvailableCpuPermits", "I", "getCreatedWorkers", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "J", "isTerminated", "Ljava/lang/String;", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "workers", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a implements Executor, Closeable {
    private static final /* synthetic */ AtomicLongFieldUpdater m = null;
    static final /* synthetic */ AtomicLongFieldUpdater n = null;
    private static final /* synthetic */ AtomicIntegerFieldUpdater o = null;
    public static final f0 p = null;
    private volatile /* synthetic */ int _isTerminated;
    volatile /* synthetic */ long controlState;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f17467f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f17468g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f17469h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f17470i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d f17471j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f17472k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c0<b> f17473l;
    private volatile /* synthetic */ long parkedWorkersStack;

    /* JADX INFO: renamed from: h.a.i3.a$a, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class C0461a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17474a = null;

        static {
            int[] r0 = new int[c.values().length];
            r0[c.f17484h.ordinal()] = 1;
            r0[c.f17483g.ordinal()] = 2;
            r0[c.f17482f.ordinal()] = 3;
            r0[c.f17485i.ordinal()] = 4;
            r0[c.f17486j.ordinal()] = 5;
            f17474a = r0;
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\b\u0080\u0004\u0018\u00002\u00020GB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0015\u0010\tJ\u000f\u0010\u0016\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010\u001cJ\u000f\u0010 \u001a\u00020\u0007H\u0002¢\u0006\u0004\b \u0010\u001cJ\u000f\u0010!\u001a\u00020\u000fH\u0002¢\u0006\u0004\b!\u0010\u0017J\u000f\u0010\"\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\"\u0010\u001cJ\u0015\u0010%\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u0019\u0010(\u001a\u0004\u0018\u00010\u000b2\u0006\u0010'\u001a\u00020\u000fH\u0002¢\u0006\u0004\b(\u0010\u0012J\u000f\u0010)\u001a\u00020\u0007H\u0002¢\u0006\u0004\b)\u0010\u001cR*\u0010*\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00018\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010\tR\u0014\u00100\u001a\u00020/8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010+R\u0012\u0010B\u001a\u00020?8Æ\u0002¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u00106¨\u0006F"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "", "index", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "taskMode", "", "afterTask", "(I)V", "beforeTask", "Lkotlinx/coroutines/scheduling/Task;", "task", "executeTask", "(Lkotlinx/coroutines/scheduling/Task;)V", "", "scanLocalQueue", "findAnyTask", "(Z)Lkotlinx/coroutines/scheduling/Task;", "findTask", "mode", "idleReset", "inStack", "()Z", "upperBound", "nextInt", "(I)I", "park", "()V", "pollGlobalQueues", "()Lkotlinx/coroutines/scheduling/Task;", "run", "runWorker", "tryAcquireCpuPermit", "tryPark", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "tryReleaseCpu", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "blockingOnly", "trySteal", "tryTerminateWorker", "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "Lkotlinx/coroutines/scheduling/WorkQueue;", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "mayHaveLocalTasks", "Z", "", "minDelayUntilStealableTaskNs", "J", "", "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "rngState", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", WsConstants.KEY_CONNECTION_STATE, "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "terminationDeadline", "kotlinx-coroutines-core", "Ljava/lang/Thread;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class b extends Thread {
        static final /* synthetic */ AtomicIntegerFieldUpdater m = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final n f17475f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public c f17476g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f17477h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f17478i;
        private volatile int indexInArray;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f17479j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f17480k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ a f17481l;
        private volatile Object nextParkedWorker;
        volatile /* synthetic */ int workerCtl;

        static {
            m = AtomicIntegerFieldUpdater.newUpdater(b.class, "workerCtl");
        }

        private b(a r1) {
            this.f17481l = r1;
            setDaemon(true);
            this.f17475f = new n();
            this.f17476g = c.f17485i;
            this.workerCtl = 0;
            this.nextParkedWorker = a.p;
            this.f17479j = kotlin.q0.c.f18452f.c();
        }

        public b(a r1, int r2) {
            this.f17481l = r1;
            this(r1);
            o(r2);
        }

        public static final /* synthetic */ a a(b r0) {
            return r0.f17481l;
        }

        private final void b(int r4) {
            if (r4 != 0) goto L4;
            return;
        L4:
            a r5 = this.f17481l;
            a.n.addAndGet(r5, -2097152);
            c r6 = this.f17476g;
            if (r6 != c.f17486j) goto L7;
            return;
        L7:
            if (q0.a() == true) goto L9;
        L16:
            this.f17476g = c.f17485i;
            return;
        L9:
            if (r6 != c.f17483g) goto L11;
            boolean r7 = true;
        L12:
            if (r7 == true) goto L16;
            throw new AssertionError();
        L11:
            r7 = false;
            goto L12
        }

        private final void c(int r1) {
            if (r1 != 0) goto L5;
            return;
        L5:
            if (s(c.f17483g) == false) goto L8;
            this.f17481l.O();
            return;
        }

        private final void d(h r3) {
            int r0 = r3.f17498g.b();
            i(r0);
            c(r0);
            this.f17481l.L(r3);
            b(r0);
        }

        private final h e(boolean r3) {
            if (r3 == true) goto L5;
            h r4 = m();
            if (r4 == null) goto L24;
            return r4;
        L24:
            return t(false);
        L5:
            if (k(this.f17481l.f17467f * 2) != 0) goto L7;
            boolean r5 = true;
        L8:
            if (r5 == false) goto L13;
            h r1 = m();
            if (r1 == null) goto L13;
            return r1;
        L13:
            h r2 = this.f17475f.h();
            if (r2 != null) goto L20;
            if (r5 == true) goto L24;
            h r6 = m();
            if (r6 == null) goto L24;
            return r6;
        L20:
            return r2;
        L7:
            r5 = false;
            goto L8
        }

        private final void i(int r3) {
            this.f17477h = 0;
            if (this.f17476g == c.f17484h) goto L5;
            return;
        L5:
            if (q0.a() == false) goto L14;
            boolean r0 = true;
            if (r3 == 1) goto L10;
            r0 = false;
        L10:
            if (r0 == true) goto L14;
            throw new AssertionError();
        L14:
            this.f17476g = c.f17483g;
        }

        private final boolean j() {
            if (this.nextParkedWorker == a.p) goto L5;
            return true;
        L5:
            return false;
        }

        private final void l() {
            if (this.f17477h != 0) goto L5;
            this.f17477h = System.nanoTime() + this.f17481l.f17469h;
        L5:
            LockSupport.parkNanos(this.f17481l.f17469h);
            if ((System.nanoTime() - this.f17477h) < 0) goto L9;
            this.f17477h = 0;
            u();
            return;
        }

        private final h m() {
            if (k(2) != 0) goto L10;
            h r0 = this.f17481l.f17471j.d();
            if (r0 != null) goto L9;
            d r1 = this.f17481l.f17472k;
        L8:
            return r1.d();
        L9:
            return r0;
        L10:
            h r2 = this.f17481l.f17472k.d();
            if (r2 != null) goto L13;
            r1 = this.f17481l.f17471j;
            goto L8
        L13:
            return r2;
        }

        private final void n() {
        L3:
            boolean r1 = false;
        L5:
            if (this.f17481l.isTerminated() == true) goto L17;
            if (this.f17476g == c.f17486j) goto L17;
            h r2 = f(this.f17480k);
            if (r2 != null) goto L10;
            this.f17480k = false;
            if (this.f17478i != 0) goto L13;
            r();
            goto L5
        L13:
            if (r1 == true) goto L15;
            r1 = true;
            goto L5
        L15:
            s(c.f17484h);
            Thread.interrupted();
            LockSupport.parkNanos(this.f17478i);
            this.f17478i = 0;
            goto L3
        L10:
            this.f17478i = 0;
            d(r2);
        L17:
            s(c.f17486j);
        }

        private final boolean q() {
            if (this.f17476g == c.f17482f) goto L14;
            a r0 = this.f17481l;
        L6:
            long r6 = r0.controlState;
            if (((int) ((9223367638808264704L & r6) >> 42)) == 0) goto L8;
            if (a.n.compareAndSet(r0, r6, r6 - 4398046511104L) == false) goto L6;
            boolean r1 = true;
        L12:
            if (r1 == false) goto L18;
            this.f17476g = c.f17482f;
            goto L14
        L18:
            return false;
        L8:
            r1 = false;
        L14:
            return true;
        }

        private final void r() {
            if (j() == true) goto L7;
            this.f17481l.E(this);
            return;
        L7:
            if (q0.a() == true) goto L9;
        L16:
            this.workerCtl = -1;
        L18:
            if (j() == false) goto L27;
            if (this.workerCtl != (-1)) goto L32;
            if (this.f17481l.isTerminated() == true) goto L33;
            if (this.f17476g == c.f17486j) goto L34;
            s(c.f17484h);
            Thread.interrupted();
            l();
            goto L18
        L34:
            return;
        L33:
            return;
        L32:
            return;
        L27:
            return;
        L9:
            if (this.f17475f.f() != 0) goto L11;
            boolean r0 = true;
        L12:
            if (r0 == true) goto L16;
            throw new AssertionError();
        L11:
            r0 = false;
            goto L12
        }

        private final h t(boolean r19) {
            if (q0.a() == true) goto L5;
        L12:
            int r1 = (int) (this.f17481l.controlState & 2097151);
            if (r1 >= 2) goto L15;
            return null;
        L15:
            int r4 = k(r1);
            a r6 = this.f17481l;
            int r9 = 0;
            long r10 = Long.MAX_VALUE;
        L17:
            if (r9 >= r1) goto L46;
            r9 = r9 + 1;
            r4 = r4 + 1;
            if (r4 <= r1) goto L21;
            r4 = 1;
        L21:
            b r14 = r6.f17473l.b(r4);
            if (r14 == null) goto L17;
            if (r14 == this) goto L17;
            if (q0.a() == true) goto L27;
        L34:
            n r15 = this.f17475f;
            n r16 = r14.f17475f;
            if (r19 == false) goto L37;
            long r17 = r15.k(r16);
        L39:
            if (r17 == (-1)) goto L41;
            if (r17 <= 0) goto L17;
            r10 = Math.min(r10, r17);
            goto L17
        L41:
            return this.f17475f.h();
        L37:
            r17 = r15.l(r16);
            goto L39
        L27:
            if (this.f17475f.f() != 0) goto L29;
            boolean r18 = true;
        L30:
            if (r18 == true) goto L34;
            throw new AssertionError();
        L29:
            r18 = false;
            goto L30
        L46:
            if (r10 != LocationRequestCompat.PASSIVE_INTERVAL) goto L49;
            r10 = 0;
        L49:
            this.f17478i = r10;
            return null;
        L5:
            if (this.f17475f.f() != 0) goto L7;
            boolean r2 = true;
        L8:
            if (r2 == true) goto L12;
            throw new AssertionError();
        L7:
            r2 = false;
            goto L8
        }

        private final void u() {
            a r0 = this.f17481l;
            c0<b> r1 = r0.f17473l;
            monitor-enter(r1);
        L23:
            th = move-exception;
            throw th;
        L5:
            if (r0.isTerminated() == false) goto L9;
            monitor-exit(r1);
            return;
        L9:
            if (((int) (r0.controlState & 2097151)) > r0.f17467f) goto L13;
            monitor-exit(r1);
            return;
        L13:
            if (m.compareAndSet(this, -1, 1) == true) goto L16;
            monitor-exit(r1);
            return;
        L16:
            int r2 = g();     // Catch: Throwable -> L23
            o(0);     // Catch: Throwable -> L23
            r0.F(this, r2, 0);     // Catch: Throwable -> L23
            int r3 = (int) (a.n.getAndDecrement(r0) & 2097151);     // Catch: Throwable -> L23
            if (r3 == r2) goto L19;
            b r4 = r0.f17473l.b(r3);     // Catch: Throwable -> L23
            o.c(r4);     // Catch: Throwable -> L23
            b r5 = r4;     // Catch: Throwable -> L23
            r0.f17473l.c(r2, r5);     // Catch: Throwable -> L23
            r5.o(r2);     // Catch: Throwable -> L23
            r0.F(r5, r3, r2);     // Catch: Throwable -> L23
        L19:
            r0.f17473l.c(r3, null);     // Catch: Throwable -> L23
            kotlin.f0 r6 = kotlin.f0.f18324a;     // Catch: Throwable -> L23
            monitor-exit(r1);
            this.f17476g = c.f17486j;
        }

        public final h f(boolean r2) {
            if (q() == true) goto L5;
            if (r2 == false) goto L9;
            h r3 = this.f17475f.h();
            if (r3 == null) goto L9;
        L10:
            if (r3 == null) goto L12;
            return r3;
        L12:
            return t(true);
        L9:
            r3 = this.f17481l.f17472k.d();
            goto L10
        L5:
            return e(r2);
        }

        public final int g() {
            return this.indexInArray;
        }

        public final Object h() {
            return this.nextParkedWorker;
        }

        public final int k(int r3) {
            int r0 = this.f17479j;
            int r1 = r0 ^ (r0 << 13);
            int r2 = r1 ^ (r1 >> 17);
            int r4 = r2 ^ (r2 << 5);
            this.f17479j = r4;
            int r5 = r3 - 1;
            if ((r5 & r3) != 0) goto L7;
            return r5 & r4;
        L7:
            return (Integer.MAX_VALUE & r4) % r3;
        }

        public final void o(int r3) {
            StringBuilder r0 = new StringBuilder();
            r0.append(this.f17481l.f17470i);
            r0.append("-worker-");
            if (r3 != 0) goto L5;
            String r1 = "TERMINATED";
        L6:
            r0.append(r1);
            setName(r0.toString());
            this.indexInArray = r3;
            return;
        L5:
            r1 = String.valueOf(r3);
            goto L6
        }

        public final void p(Object r1) {
            this.nextParkedWorker = r1;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            n();
        }

        public final boolean s(c r7) {
            c r0 = this.f17476g;
            if (r0 != c.f17482f) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L8;
            a r2 = this.f17481l;
            a.n.addAndGet(r2, 4398046511104L);
        L8:
            if (r0 == r7) goto L10;
            this.f17476g = r7;
        L10:
            return r1;
        L5:
            r1 = false;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f17482f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f17483g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final c f17484h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final c f17485i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final c f17486j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final /* synthetic */ c[] f17487k = null;

        static {
            f17482f = new c("CPU_ACQUIRED", 0);
            f17483g = new c("BLOCKING", 1);
            f17484h = new c("PARKING", 2);
            f17485i = new c("DORMANT", 3);
            f17486j = new c("TERMINATED", 4);
            f17487k = a();
        }

        private c(String r1, int r2) {
            super(r1, r2);
        }

        private static final /* synthetic */ c[] a() {
            return new c[]{f17482f, f17483g, f17484h, f17485i, f17486j};
        }

        public static c valueOf(String r1) {
            return (c) Enum.valueOf(c.class, r1);
        }

        public static c[] values() {
            return (c[]) f17487k.clone();
        }
    }

    static {
        p = new f0("NOT_IN_STACK");
        m = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");
        n = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");
        o = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");
    }

    public a(int r4, int r5, long r6, String r8) {
        this.f17467f = r4;
        this.f17468g = r5;
        this.f17469h = r6;
        this.f17470i = r8;
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
        this.f17471j = new d();
        this.f17472k = new d();
        this.parkedWorkersStack = 0;
        this.f17473l = new c0(r4 + 1);
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

    private final int A(b r1) {
        Object r0 = r1.h();
    L4:
        if (r0 == p) goto L5;
        if (r0 == null) goto L8;
        b r2 = (b) r0;
        int r3 = r2.g();
        if (r3 != 0) goto L12;
        r0 = r2.h();
        goto L4
    L12:
        return r3;
    L8:
        return 0;
    L5:
        return -1;
    }

    private final b C() {
    L2:
        long r2 = this.parkedWorkersStack;
        c0<b> r1 = this.f17473l;
        b r6 = r1.b((int) (2097151 & r2));
        if (r6 == null) goto L4;
        long r0 = (2097152 + r2) & (-2097152);
        int r4 = A(r6);
        if (r4 < 0) goto L2;
        if (m.compareAndSet(this, r2, ((long) r4) | r0) == false) goto L2;
        r6.p(p);
        return r6;
    L4:
        return null;
    }

    private final void N(boolean r4) {
        long r0 = n.addAndGet(this, 2097152);
        if (r4 == false) goto L6;
        return;
    L6:
        if (X() == false) goto L9;
        return;
    L9:
        if (S(r0) == false) goto L11;
        return;
    L11:
        X();
    }

    private final h Q(b r2, h r3, boolean r4) {
        if (r2 != null) goto L5;
        return r3;
    L5:
        if (r2.f17476g != c.f17486j) goto L8;
        return r3;
    L8:
        if (r3.f17498g.b() == 0) goto L10;
    L12:
        r2.f17480k = true;
        return r2.f17475f.a(r3, r4);
    L10:
        if (r2.f17476g != c.f17483g) goto L12;
        return r3;
    }

    private final boolean S(long r4) {
        if (kotlin.r0.e.c(((int) (2097151 & r4)) - ((int) ((r4 & 4398044413952L) >> 21)), 0) >= this.f17467f) goto L11;
        int r5 = b();
        if (r5 == 1) goto L7;
    L9:
        if (r5 <= 0) goto L11;
        return true;
    L7:
        if (this.f17467f <= 1) goto L9;
        b();
    L11:
        return false;
    }

    static /* synthetic */ boolean V(a r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.controlState;
    L6:
        return r0.S(r1);
    }

    private final boolean X() {
    L2:
        b r0 = C();
        if (r0 == null) goto L4;
        if (b.m.compareAndSet(r0, -1, 0) == false) goto L2;
        LockSupport.unpark(r0);
        return true;
    L4:
        return false;
    }

    private final boolean a(h r3) {
        boolean r1 = true;
        if (r3.f17498g.b() == 1) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L8;
        d r2 = this.f17472k;
    L10:
        return r2.a(r3);
    L8:
        r2 = this.f17471j;
        goto L10
    }

    private final int b() {
        c0<b> r0 = this.f17473l;
        monitor-enter(r0);
    L36:
        th = move-exception;
        throw th;
    L5:
        if (isTerminated() == true) goto L7;
        long r1 = this.controlState;     // Catch: Throwable -> L36
        int r5 = (int) (r1 & 2097151);     // Catch: Throwable -> L36
        boolean r2 = false;
        int r3 = kotlin.r0.e.c(r5 - ((int) ((r1 & 4398044413952L) >> 21)), 0);     // Catch: Throwable -> L36
        if (r3 < this.f17467f) goto L14;
        monitor-exit(r0);
        return 0;
    L14:
        if (r5 < this.f17468g) goto L17;
        monitor-exit(r0);
        return 0;
    L17:
        int r6 = ((int) (this.controlState & 2097151)) + 1;     // Catch: Throwable -> L36
        if (r6 > 0) goto L20;
    L22:
        boolean r7 = false;
    L23:
        if (r7 == false) goto L35;
        b r8 = new b(this, r6);     // Catch: Throwable -> L36
        this.f17473l.c(r6, r8);     // Catch: Throwable -> L36
        if (r6 != ((int) (2097151 & n.incrementAndGet(this)))) goto L27;
        r2 = true;
    L27:
        if (r2 == false) goto L33;
        r8.start();     // Catch: Throwable -> L36
        int r4 = r3 + 1;
        monitor-exit(r0);
        return r4;
    L33:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L36
    L35:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L36
    L20:
        if (this.f17473l.b(r6) != null) goto L22;
        r7 = true;
        goto L23
    L7:
        monitor-exit(r0);
        return -1;
    }

    private final b l() {
        Thread r0 = Thread.currentThread();
        if ((r0 instanceof b) == false) goto L5;
        b r1 = (b) r0;
    L6:
        if (r1 != null) goto L9;
        return null;
    L9:
        if (o.a(b.a(r1), this) == true) goto L11;
        return null;
    L11:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public static /* synthetic */ void x(a r0, Runnable r1, i r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = l.f17506f;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = false;
    L8:
        r0.s(r1, r2, r3);
    }

    public final boolean E(b r11) {
        if (r11.h() == p) goto L5;
        return false;
    L5:
        long r5 = this.parkedWorkersStack;
        int r0 = (int) (2097151 & r5);
        long r3 = (2097152 + r5) & (-2097152);
        int r1 = r11.g();
        if (q0.a() == false) goto L14;
        if (r1 == 0) goto L9;
        boolean r7 = true;
    L10:
        if (r7 == true) goto L14;
        throw new AssertionError();
    L9:
        r7 = false;
    L14:
        r11.p(this.f17473l.b(r0));
        if (m.compareAndSet(this, r5, ((long) r1) | r3) == false) goto L5;
        return true;
    }

    public final void F(b r9, int r10, int r11) {
    L2:
        long r2 = this.parkedWorkersStack;
        int r0 = (int) (2097151 & r2);
        long r4 = (2097152 + r2) & (-2097152);
        if (r0 != r10) goto L7;
        if (r11 != 0) goto L6;
        r0 = A(r9);
        goto L7
    L6:
        r0 = r11;
    L7:
        if (r0 < 0) goto L2;
        if (m.compareAndSet(this, r2, r4 | ((long) r0)) == false) goto L2;
    }

    public final void L(h r2) {
        r2.run();     // Catch: Throwable -> L7
        h.a.b r1 = h.a.c.a();
        if (r1 == null) goto L23;
    L6:
        r1.e();
        return;
    L23:
        return;
    L7:
        th = move-exception;
        Thread r3 = Thread.currentThread();     // Catch: Throwable -> L12
        r3.getUncaughtExceptionHandler().uncaughtException(r3, th);     // Catch: Throwable -> L12
        r1 = h.a.c.a();
        if (r1 != null) goto L6;
        return;
    L12:
        th = move-exception;
        h.a.b r4 = h.a.c.a();
        if (r4 == null) goto L17;
        r4.e();
    L17:
        throw th;
    }

    public final void M(long r10) {
        boolean r1 = false;
        if (o.compareAndSet(this, 0, 1) == true) goto L5;
        return;
    L5:
        b r0 = l();
        c0<b> r3 = this.f17473l;
        monitor-enter(r3);
        int r4 = (int) (this.controlState & 2097151);
        monitor-exit(r3);
        if (1 > r4) goto L31;
        int r5 = 1;
    L12:
        int r6 = r5 + 1;
        b r7 = this.f17473l.b(r5);
        o.c(r7);
        b r8 = r7;
        if (r8 != r0) goto L15;
    L28:
        if (r5 == r4) goto L31;
        r5 = r6;
    L15:
        if (r8.isAlive() == false) goto L17;
        LockSupport.unpark(r8);
        r8.join(r10);
        goto L15
    L17:
        c r9 = r8.f17476g;
        if (q0.a() == true) goto L20;
    L27:
        r8.f17475f.g(this.f17472k);
        goto L28
    L20:
        if (r9 != c.f17486j) goto L22;
        boolean r11 = true;
    L23:
        if (r11 == true) goto L27;
        throw new AssertionError();
    L22:
        r11 = false;
    L31:
        this.f17472k.b();
        this.f17471j.b();
    L32:
        if (r0 != null) goto L34;
        h r12 = null;
    L35:
        if (r12 != null) goto L54;
        r12 = this.f17471j.d();
        if (r12 != null) goto L54;
        r12 = this.f17472k.d();
        if (r12 != null) goto L54;
        if (r0 == null) goto L44;
        r0.s(c.f17486j);
    L44:
        if (q0.a() == true) goto L46;
    L52:
        this.parkedWorkersStack = 0;
        this.controlState = 0;
        return;
    L46:
        if (((int) ((this.controlState & 9223367638808264704L) >> 42)) != this.f17467f) goto L48;
        r1 = true;
    L48:
        if (r1 == true) goto L52;
        throw new AssertionError();
    L54:
        L(r12);
        goto L32
    L34:
        r12 = r0.f(true);
    L55:
        th = move-exception;
        throw th;
    }

    public final void O() {
        if (X() == false) goto L6;
        return;
    L6:
        if (V(this, 0, 1, null) == false) goto L8;
        return;
    L8:
        X();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        M(BDLocationConfig.sScanBleMaxInterval);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r7) {
        x(this, r7, null, false, 6, null);
    }

    public final h g(Runnable r3, i r4) {
        long r0 = l.f17505e.a();
        if ((r3 instanceof h) == false) goto L7;
        h r5 = (h) r3;
        r5.f17497f = r0;
        r5.f17498g = r4;
        return r5;
    L7:
        return new k(r3, r0, r4);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final void s(Runnable r2, i r3, boolean r4) {
        h.a.b r0 = h.a.c.a();
        if (r0 == null) goto L6;
        r0.d();
    L6:
        h r5 = g(r2, r3);
        b r6 = l();
        h r1 = Q(r6, r5, r4);
        if (r1 != null) goto L9;
    L13:
        if (r4 == false) goto L16;
        if (r6 == null) goto L16;
        boolean r7 = true;
    L18:
        if (r5.f17498g.b() != 0) goto L22;
        if (r7 == false) goto L21;
        return;
    L21:
        O();
        return;
    L22:
        N(r7);
        return;
    L16:
        r7 = false;
        goto L18
    L9:
        if (a(r1) == true) goto L13;
        throw new RejectedExecutionException(o.m(this.f17470i, " was terminated"));
    }

    public String toString() {
        ArrayList r0 = new ArrayList();
        int r1 = this.f17473l.a();
        int r2 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
        int r8 = 1;
    L3:
        if (r8 >= r1) goto L26;
        int r9 = r8 + 1;
        b r10 = this.f17473l.b(r8);
        if (r10 == null) goto L6;
        int r11 = r10.f17475f.f();
        int r12 = C0461a.f17474a[r10.f17476g.ordinal()];
        if (r12 != 1) goto L10;
        r5 = r5 + 1;
        goto L6
    L10:
        if (r12 != 2) goto L12;
        r4 = r4 + 1;
        StringBuilder r13 = new StringBuilder();
        r13.append(r11);
        char r14 = 'b';
    L24:
        r13.append(r14);
        r0.add(r13.toString());
        goto L6
    L12:
        if (r12 != 3) goto L14;
        r2 = r2 + 1;
        r13 = new StringBuilder();
        r13.append(r11);
        r14 = 'c';
        goto L24
    L14:
        if (r12 != 4) goto L16;
        r6 = r6 + 1;
        if (r11 <= 0) goto L6;
        r13 = new StringBuilder();
        r13.append(r11);
        r14 = 'd';
        goto L24
    L16:
        if (r12 != 5) goto L6;
        r7 = r7 + 1;
    L6:
        r8 = r9;
        goto L3
    L26:
        long r15 = this.controlState;
        return this.f17470i + '@' + r0.b(this) + "[Pool Size {core = " + this.f17467f + ", max = " + this.f17468g + "}, Worker States {CPU = " + r2 + ", blocking = " + r4 + ", parked = " + r5 + ", dormant = " + r6 + ", terminated = " + r7 + "}, running workers queues = " + r0 + ", global CPU queue size = " + this.f17471j.c() + ", global blocking queue size = " + this.f17472k.c() + ", Control State {created workers= " + ((int) (2097151 & r15)) + ", blocking tasks = " + ((int) ((4398044413952L & r15) >> 21)) + ", CPUs acquired = " + (this.f17467f - ((int) ((9223367638808264704L & r15) >> 42))) + "}]";
    }
}
