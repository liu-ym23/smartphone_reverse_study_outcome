package okhttp3.internal.concurrent;

import a.a;
import androidx.appcompat.widget.ActivityChooserView;
import com.bytedance.keva.KevaImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class TaskRunner {
    public static final Companion Companion = null;

    @JvmField
    @NotNull
    public static final TaskRunner INSTANCE = null;

    @NotNull
    private static final Logger logger = null;

    @NotNull
    private final Backend backend;
    private final List<TaskQueue> busyQueues;
    private boolean coordinatorWaiting;
    private long coordinatorWakeUpAt;
    private int nextQueueName;
    private final List<TaskQueue> readyQueues;
    private final Runnable runnable;

    @Metadata
    public interface Backend {
        void beforeTask(@NotNull TaskRunner r1);

        void coordinatorNotify(@NotNull TaskRunner r1);

        void coordinatorWait(@NotNull TaskRunner r1, long r2);

        void execute(@NotNull Runnable r1);

        long nanoTime();
    }

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Logger getLogger() {
            return TaskRunner.access$getLogger$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata
    public static final class RealBackend implements Backend {
        private final ThreadPoolExecutor executor;

        public RealBackend(@NotNull ThreadFactory r10) {
            Intrinsics.f(r10, "threadFactory");
            this.executor = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), r10);
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void beforeTask(@NotNull TaskRunner r1) {
            Intrinsics.f(r1, "taskRunner");
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void coordinatorNotify(@NotNull TaskRunner r1) {
            Intrinsics.f(r1, "taskRunner");
            r1.notify();
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void coordinatorWait(@NotNull TaskRunner r7, long r8) {
            Intrinsics.f(r7, "taskRunner");
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
        public void execute(@NotNull Runnable r2) {
            Intrinsics.f(r2, "runnable");
            this.executor.execute(r2);
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public long nanoTime() {
            return System.nanoTime();
        }

        public final void shutdown() {
            this.executor.shutdown();
        }
    }

    static {
        Companion = new Companion(null);
        INSTANCE = new TaskRunner(new RealBackend(Util.threadFactory(Util.okHttpName + " TaskRunner", true)));
        Logger r0 = Logger.getLogger(TaskRunner.class.getName());
        Intrinsics.e(r0, "Logger.getLogger(TaskRunner::class.java.name)");
        logger = r0;
    }

    public TaskRunner(@NotNull Backend r2) {
        Intrinsics.f(r2, "backend");
        this.backend = r2;
        this.nextQueueName = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
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

    private final void afterRun(Task r7, long r8) {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        TaskQueue r0 = r7.getQueue$okhttp();
        Intrinsics.c(r0);
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
        StringBuilder r9 = new StringBuilder("Thread ");
        Thread r10 = Thread.currentThread();
        Intrinsics.e(r10, "Thread.currentThread()");
        r9.append(r10.getName());
        r9.append(" MUST hold lock on ");
        r9.append(this);
        throw new AssertionError(r9.toString());
    }

    private final void beforeRun(Task r4) {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        r4.setNextExecuteNanoTime$okhttp(-1);
        TaskQueue r0 = r4.getQueue$okhttp();
        Intrinsics.c(r0);
        r0.getFutureTasks$okhttp().remove(r4);
        this.readyQueues.remove(r0);
        r0.setActiveTask$okhttp(r4);
        this.busyQueues.add(r0);
        return;
    L5:
        if (Thread.holdsLock(this) == true) goto L9;
        StringBuilder r1 = new StringBuilder("Thread ");
        Thread r2 = Thread.currentThread();
        Intrinsics.e(r2, "Thread.currentThread()");
        r1.append(r2.getName());
        r1.append(" MUST hold lock on ");
        r1.append(this);
        throw new AssertionError(r1.toString());
    }

    private final void runTask(Task r6) {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        Thread r0 = Thread.currentThread();
        Intrinsics.e(r0, "currentThread");
        String r1 = r0.getName();
        r0.setName(r6.getName());
        long r2 = r6.runOnce();     // Catch: Throwable -> L19
        monitor-enter(this);
        afterRun(r6, r2);     // Catch: Throwable -> L16
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
        r0.setName(r1);
        throw th;
    L26:
        th = move-exception;
        throw th;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        StringBuilder r3 = new StringBuilder("Thread ");
        Thread r4 = Thread.currentThread();
        Intrinsics.e(r4, "Thread.currentThread()");
        r3.append(r4.getName());
        r3.append(" MUST NOT hold lock on ");
        r3.append(this);
        throw new AssertionError(r3.toString());
    }

    @NotNull
    public final List<TaskQueue> activeQueues() {
        monitor-enter(this);
        ArrayList r0 = CollectionsKt.n(this.busyQueues, this.readyQueues);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Nullable
    public final Task awaitTaskToRun() {
        if (Util.assertionsEnabled == false) goto L10;
        if (Thread.holdsLock(this) == true) goto L10;
        StringBuilder r1 = new StringBuilder("Thread ");
        Thread r2 = Thread.currentThread();
        Intrinsics.e(r2, "Thread.currentThread()");
        r1.append(r2.getName());
        r1.append(" MUST hold lock on ");
        r1.append(this);
        throw new AssertionError(r1.toString());
    L10:
        if (this.readyQueues.isEmpty() == true) goto L11;
        long r3 = this.backend.nanoTime();
        Iterator<TaskQueue> r0 = this.readyQueues.iterator();
        long r4 = Long.MAX_VALUE;
        Task r6 = null;
    L14:
        if (r0.hasNext() == false) goto L21;
        Task r7 = r0.next().getFutureTasks$okhttp().get(0);
        long r10 = Math.max(0, r7.getNextExecuteNanoTime$okhttp() - r3);
        if (r10 > 0) goto L17;
        if (r6 != null) goto L19;
        r6 = r7;
        goto L14
    L19:
        boolean r5 = true;
    L22:
        if (r6 != null) goto L23;
        if (this.coordinatorWaiting == true) goto L34;
        this.coordinatorWaiting = true;
        this.coordinatorWakeUpAt = r3 + r4;
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
        if (r4 >= (this.coordinatorWakeUpAt - r3)) goto L36;
        this.backend.coordinatorNotify(this);
    L36:
        return null;
    L23:
        beforeRun(r6);
        if (r5 == false) goto L26;
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
        r5 = false;
        goto L22
    L11:
        return null;
    }

    public final void cancelAll() {
        int r0 = this.busyQueues.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        this.busyQueues.get(r0).cancelAllAndDecide$okhttp();
        r0 = r0 - 1;
        goto L3
    L5:
        int r1 = this.readyQueues.size() - 1;
    L6:
        if (r1 < 0) goto L11;
        TaskQueue r2 = this.readyQueues.get(r1);
        r2.cancelAllAndDecide$okhttp();
        if (r2.getFutureTasks$okhttp().isEmpty() == false) goto L10;
        this.readyQueues.remove(r1);
    L10:
        r1 = r1 - 1;
        goto L6
    }

    @NotNull
    public final Backend getBackend() {
        return this.backend;
    }

    public final void kickCoordinator$okhttp(@NotNull TaskQueue r4) {
        Intrinsics.f(r4, "taskQueue");
        if (Util.assertionsEnabled == false) goto L10;
        if (Thread.holdsLock(this) == true) goto L10;
        StringBuilder r0 = new StringBuilder("Thread ");
        Thread r1 = Thread.currentThread();
        Intrinsics.e(r1, "Thread.currentThread()");
        r0.append(r1.getName());
        r0.append(" MUST hold lock on ");
        r0.append(this);
        throw new AssertionError(r0.toString());
    L10:
        if (r4.getActiveTask$okhttp() != null) goto L16;
        if ((!r4.getFutureTasks$okhttp().isEmpty()) == false) goto L14;
        Util.addIfAbsent(this.readyQueues, r4);
        goto L16
    L14:
        this.readyQueues.remove(r4);
    L16:
        if (this.coordinatorWaiting == false) goto L18;
        this.backend.coordinatorNotify(this);
        return;
    L18:
        this.backend.execute(this.runnable);
    }

    @NotNull
    public final TaskQueue newQueue() {
        monitor-enter(this);
        int r0 = this.nextQueueName;     // Catch: Throwable -> L7
        this.nextQueueName = r0 + 1;     // Catch: Throwable -> L7
        monitor-exit(this);
        return new TaskQueue(this, a.e(r0, "Q"));
    L7:
        th = move-exception;
        throw th;
    }
}
