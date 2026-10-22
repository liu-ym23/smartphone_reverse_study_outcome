package okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: TaskRunner.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 #2\u00020\u0001:\u0003\"#$B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0014J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rH\u0002J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0006\u0010\u001c\u001a\u00020\u0016J\u0015\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\tH\u0000¢\u0006\u0002\b\u001fJ\u0006\u0010 \u001a\u00020\tJ\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lokhttp3/internal/concurrent/TaskRunner;", "", "backend", "Lokhttp3/internal/concurrent/TaskRunner$Backend;", "(Lokhttp3/internal/concurrent/TaskRunner$Backend;)V", "getBackend", "()Lokhttp3/internal/concurrent/TaskRunner$Backend;", "busyQueues", "", "Lokhttp3/internal/concurrent/TaskQueue;", "coordinatorWaiting", "", "coordinatorWakeUpAt", "", "nextQueueName", "", "readyQueues", "runnable", "Ljava/lang/Runnable;", "activeQueues", "", "afterRun", "", "task", "Lokhttp3/internal/concurrent/Task;", "delayNanos", "awaitTaskToRun", "beforeRun", "cancelAll", "kickCoordinator", "taskQueue", "kickCoordinator$okhttp", "newQueue", "runTask", "Backend", "Companion", "RealBackend", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TaskRunner {
    public static final Companion Companion = null;
    public static final TaskRunner INSTANCE = null;
    private static final Logger logger = null;
    private final Backend backend;
    private final List<TaskQueue> busyQueues;
    private boolean coordinatorWaiting;
    private long coordinatorWakeUpAt;
    private int nextQueueName;
    private final List<TaskQueue> readyQueues;
    private final Runnable runnable;

    /* JADX INFO: compiled from: TaskRunner.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\tH&¨\u0006\u000e"}, d2 = {"Lokhttp3/internal/concurrent/TaskRunner$Backend;", "", "beforeTask", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "coordinatorNotify", "coordinatorWait", "nanos", "", "execute", "runnable", "Ljava/lang/Runnable;", "nanoTime", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Backend {
        void beforeTask(TaskRunner r1);

        void coordinatorNotify(TaskRunner r1);

        void coordinatorWait(TaskRunner r1, long r2);

        void execute(Runnable r1);

        long nanoTime();
    }

    /* JADX INFO: compiled from: TaskRunner.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lokhttp3/internal/concurrent/TaskRunner$Companion;", "", "()V", "INSTANCE", "Lokhttp3/internal/concurrent/TaskRunner;", "logger", "Ljava/util/logging/Logger;", "getLogger", "()Ljava/util/logging/Logger;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final Logger getLogger() {
            return TaskRunner.access$getLogger$cp();
        }
    }

    /* JADX INFO: compiled from: TaskRunner.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u0006\u0010\u0013\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/concurrent/TaskRunner$RealBackend;", "Lokhttp3/internal/concurrent/TaskRunner$Backend;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "(Ljava/util/concurrent/ThreadFactory;)V", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "beforeTask", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "coordinatorNotify", "coordinatorWait", "nanos", "", "execute", "runnable", "Ljava/lang/Runnable;", "nanoTime", "shutdown", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RealBackend implements Backend {
        private final ThreadPoolExecutor executor;

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void beforeTask(TaskRunner r1) {
            Intrinsics.checkNotNullParameter(r1, "taskRunner");
        }

        public RealBackend(ThreadFactory r10) {
            Intrinsics.checkNotNullParameter(r10, "threadFactory");
            this.executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), r10);
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public long nanoTime() {
            return System.nanoTime();
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void coordinatorWait(TaskRunner r7, long r8) throws InterruptedException {
            Intrinsics.checkNotNullParameter(r7, "taskRunner");
            long r2 = r8 / 1000000;
            long r0 = r8 - (1000000 * r2);
            if (r2 <= 0) goto L5;
        L6:
            r7.wait(r2, (int) r0);
            return;
        L5:
            if (r8 > 0) goto L6;
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void execute(Runnable r2) {
            Intrinsics.checkNotNullParameter(r2, "runnable");
            this.executor.execute(r2);
        }

        public final void shutdown() {
            this.executor.shutdown();
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void coordinatorNotify(TaskRunner r1) {
            Intrinsics.checkNotNullParameter(r1, "taskRunner");
            r1.notify();
        }
    }

    public TaskRunner(Backend r2) {
        Intrinsics.checkNotNullParameter(r2, "backend");
        this.backend = r2;
        this.nextQueueName = 10000;
        this.busyQueues = new ArrayList();
        this.readyQueues = new ArrayList();
        this.runnable = new TaskRunner$runnable$1(this);
    }

    public static final /* synthetic */ Logger access$getLogger$cp() {
        return logger;
    }

    public static final /* synthetic */ void access$runTask(TaskRunner r0, Task r1) {
        r0.runTask(r1);
    }

    public final Backend getBackend() {
        return this.backend;
    }

    public final TaskQueue newQueue() {
        monitor-enter(this);
        int r0 = this.nextQueueName;     // Catch: Throwable -> L7
        this.nextQueueName = r0 + 1;     // Catch: Throwable -> L7
        monitor-exit(this);
        return new TaskQueue(this, Intrinsics.stringPlus("Q", Integer.valueOf(r0)));
    L7:
        th = move-exception;
        throw th;
    }

    public final List<TaskQueue> activeQueues() {
        monitor-enter(this);
        List<TaskQueue> r0 = CollectionsKt.plus(this.busyQueues, this.readyQueues);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final void cancelAll() {
        int r0 = this.busyQueues.size() - 1;
        if (r0 < 0) goto L8;
    L4:
        int r1 = r0 - 1;
        this.busyQueues.get(r0).cancelAllAndDecide$okhttp();
        if (r1 < 0) goto L8;
        r0 = r1;
    L8:
        int r2 = this.readyQueues.size() - 1;
        if (r2 < 0) goto L16;
    L10:
        int r3 = r2 - 1;
        TaskQueue r4 = this.readyQueues.get(r2);
        r4.cancelAllAndDecide$okhttp();
        if (r4.getFutureTasks$okhttp().isEmpty() == false) goto L13;
        this.readyQueues.remove(r2);
    L13:
        if (r3 < 0) goto L19;
        r2 = r3;
        goto L10
    L19:
        return;
    }

    static {
        Companion = new Companion(null);
        INSTANCE = new TaskRunner(new RealBackend(Util.threadFactory(Intrinsics.stringPlus(Util.okHttpName, " TaskRunner"), true)));
        Logger r0 = Logger.getLogger(TaskRunner.class.getName());
        Intrinsics.checkNotNullExpressionValue(r0, "getLogger(TaskRunner::class.java.name)");
        logger = r0;
    }

    public final void kickCoordinator$okhttp(TaskQueue r3) {
        Intrinsics.checkNotNullParameter(r3, "taskQueue");
        if (Util.assertionsEnabled == false) goto L10;
        if (Thread.holdsLock(this) == true) goto L10;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    L10:
        if (r3.getActiveTask$okhttp() != null) goto L16;
        if ((!r3.getFutureTasks$okhttp().isEmpty()) == false) goto L14;
        Util.addIfAbsent(this.readyQueues, r3);
        goto L16
    L14:
        this.readyQueues.remove(r3);
    L16:
        if (this.coordinatorWaiting == false) goto L18;
        this.backend.coordinatorNotify(this);
        return;
    L18:
        this.backend.execute(this.runnable);
    }

    private final void beforeRun(Task r3) {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        r3.setNextExecuteNanoTime$okhttp(-1);
        TaskQueue r0 = r3.getQueue$okhttp();
        Intrinsics.checkNotNull(r0);
        r0.getFutureTasks$okhttp().remove(r3);
        this.readyQueues.remove(r0);
        r0.setActiveTask$okhttp(r3);
        this.busyQueues.add(r0);
        return;
    L5:
        if (Thread.holdsLock(this) == true) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    private final void runTask(Task r6) {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        Thread r0 = Thread.currentThread();
        String r1 = r0.getName();
        r0.setName(r6.getName());
        long r2 = r6.runOnce();     // Catch: Throwable -> L19
        monitor-enter(this);
        afterRun(r6, r2);     // Catch: Throwable -> L16
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
        r0.setName(r1);
        return;
    L16:
        th = move-exception;
        throw th;
    L19:
        th = move-exception;
        monitor-enter(this);
        afterRun(r6, -1);     // Catch: Throwable -> L26
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L26
        r0.setName(r1);
        throw th;
    L26:
        th = move-exception;
        throw th;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    private final void afterRun(Task r7, long r8) {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        TaskQueue r0 = r7.getQueue$okhttp();
        Intrinsics.checkNotNull(r0);
        if (r0.getActiveTask$okhttp() != r7) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == false) goto L25;
        boolean r2 = r0.getCancelActiveTask$okhttp();
        r0.setCancelActiveTask$okhttp(false);
        r0.setActiveTask$okhttp(null);
        this.busyQueues.remove(r0);
        if (r8 == (-1)) goto L21;
        if (r2 == true) goto L21;
        if (r0.getShutdown$okhttp() == true) goto L21;
        r0.scheduleAndDecide$okhttp(r7, r8, true);
    L21:
        if ((!r0.getFutureTasks$okhttp().isEmpty()) == false) goto L26;
        this.readyQueues.add(r0);
        return;
    L26:
        return;
    L25:
        throw new IllegalStateException("Check failed.".toString());
    L12:
        r1 = false;
        goto L13
    L5:
        if (Thread.holdsLock(this) == true) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    public final Task awaitTaskToRun() {
        if (Util.assertionsEnabled == false) goto L10;
        if (Thread.holdsLock(this) == true) goto L10;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    L10:
        if (this.readyQueues.isEmpty() == true) goto L11;
        long r2 = this.backend.nanoTime();
        Iterator<TaskQueue> r0 = this.readyQueues.iterator();
        long r4 = Long.MAX_VALUE;
        Task r6 = null;
    L14:
        if (r0.hasNext() == false) goto L21;
        Task r7 = r0.next().getFutureTasks$okhttp().get(0);
        long r10 = Math.max(0, r7.getNextExecuteNanoTime$okhttp() - r2);
        if (r10 > 0) goto L17;
        if (r6 != null) goto L19;
        r6 = r7;
        goto L14
    L19:
        boolean r1 = true;
    L22:
        if (r6 != null) goto L23;
        if (this.coordinatorWaiting == true) goto L34;
        this.coordinatorWaiting = true;
        this.coordinatorWakeUpAt = r2 + r4;
        this.backend.coordinatorWait(this, r4);     // Catch: Throwable -> L40 InterruptedException -> L42
    L39:
        this.coordinatorWaiting = false;
    L42:
        cancelAll();     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        this.coordinatorWaiting = false;
        throw th;
    L34:
        if (r4 >= (this.coordinatorWakeUpAt - r2)) goto L36;
        this.backend.coordinatorNotify(this);
    L36:
        return null;
    L23:
        beforeRun(r6);
        if (r1 == false) goto L26;
    L29:
        this.backend.execute(this.runnable);
    L30:
        return r6;
    L26:
        if (this.coordinatorWaiting == true) goto L30;
        if ((!this.readyQueues.isEmpty()) == false) goto L30;
    L17:
        r4 = Math.min(r10, r4);
        goto L14
    L21:
        r1 = false;
        goto L22
    L11:
        return null;
    }
}
