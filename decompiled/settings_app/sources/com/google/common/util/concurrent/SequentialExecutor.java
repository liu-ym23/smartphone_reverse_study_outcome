package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class SequentialExecutor implements Executor {
    private static final Logger log = null;
    private final Executor executor;
    private final Deque<Runnable> queue;
    private final QueueWorker worker;
    private long workerRunCount;
    private WorkerRunningState workerRunningState;

    private final class QueueWorker implements Runnable {

        @CheckForNull
        Runnable task;
        final /* synthetic */ SequentialExecutor this$0;

        private QueueWorker(SequentialExecutor r1) {
            this.this$0 = r1;
        }

        /* synthetic */ QueueWorker(SequentialExecutor r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            workOnQueue();     // Catch: Error -> L4
            return;
        L4:
            e = move-exception;
            monitor-enter(SequentialExecutor.access$100(this.this$0));
            SequentialExecutor.access$202(this.this$0, WorkerRunningState.IDLE);     // Catch: Throwable -> L10
            throw e;
        L10:
            th = move-exception;
            throw th;
        }

        private void workOnQueue() {
            boolean r0 = false;
            boolean r1 = false;
        L41:
            Deque r2 = SequentialExecutor.access$100(this.this$0);     // Catch: Throwable -> L36
            monitor-enter(r2);     // Catch: Throwable -> L36
            if (r0 == false) goto L40;
        L13:
            Runnable r3 = (Runnable) SequentialExecutor.access$100(this.this$0).poll();     // Catch: Throwable -> L33
            this.task = r3;     // Catch: Throwable -> L33
            if (r3 == null) goto L15;
            monitor-exit(r2);     // Catch: Throwable -> L33
            r1 = r1 | Thread.interrupted();
            this.task.run();     // Catch: Throwable -> L26 RuntimeException -> L28
        L24:
            this.task = null;     // Catch: Throwable -> L36
        L28:
            e = move-exception;
            Logger r4 = SequentialExecutor.access$400();     // Catch: Throwable -> L26
            Level r5 = Level.SEVERE;     // Catch: Throwable -> L26
            String r6 = String.valueOf(this.task);     // Catch: Throwable -> L26
            r4.log(r5, new StringBuilder(String.valueOf(r6).length() + 35).append("Exception while executing runnable ").append(r6).toString(), e);     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            this.task = null;     // Catch: Throwable -> L36
            throw th;     // Catch: Throwable -> L36
        L15:
            SequentialExecutor.access$202(this.this$0, WorkerRunningState.IDLE);     // Catch: Throwable -> L33
            monitor-exit(r2);     // Catch: Throwable -> L33
            if (r1 == false) goto L49;
            Thread.currentThread().interrupt();
            return;
        L49:
            return;
        L40:
        L33:
            th = move-exception;
            throw th;     // Catch: Throwable -> L36
        L7:
            if (SequentialExecutor.access$200(this.this$0) == WorkerRunningState.RUNNING) goto L8;
            SequentialExecutor.access$308(this.this$0);     // Catch: Throwable -> L33
            SequentialExecutor.access$202(this.this$0, WorkerRunningState.RUNNING);     // Catch: Throwable -> L33
            r0 = true;
            goto L13
        L8:
            monitor-exit(r2);     // Catch: Throwable -> L33
            if (r1 == false) goto L48;
            Thread.currentThread().interrupt();
            return;
        L48:
            return;
        L36:
            th = move-exception;
            if (r1 == false) goto L39;
            Thread.currentThread().interrupt();
        L39:
            throw th;
        }

        public String toString() {
            Runnable r0 = this.task;
            if (r0 == null) goto L6;
            String r3 = String.valueOf(r0);
            return new StringBuilder(String.valueOf(r3).length() + 34).append("SequentialExecutorWorker{running=").append(r3).append(VectorFormat.DEFAULT_SUFFIX).toString();
        L6:
            String r4 = String.valueOf(SequentialExecutor.access$200(this.this$0));
            return new StringBuilder(String.valueOf(r4).length() + 32).append("SequentialExecutorWorker{state=").append(r4).append(VectorFormat.DEFAULT_SUFFIX).toString();
        }
    }

    static final enum WorkerRunningState extends Enum<WorkerRunningState> {
        private static final /* synthetic */ WorkerRunningState[] $VALUES = null;
        public static final WorkerRunningState IDLE = null;
        public static final WorkerRunningState QUEUED = null;
        public static final WorkerRunningState QUEUING = null;
        public static final WorkerRunningState RUNNING = null;

        private static /* synthetic */ WorkerRunningState[] $values() {
            return new WorkerRunningState[]{IDLE, QUEUING, QUEUED, RUNNING};
        }

        private WorkerRunningState(String r1, int r2) {
            super(r1, r2);
        }

        public static WorkerRunningState valueOf(String r1) {
            return (WorkerRunningState) Enum.valueOf(WorkerRunningState.class, r1);
        }

        public static WorkerRunningState[] values() {
            return (WorkerRunningState[]) $VALUES.clone();
        }

        static {
            IDLE = new WorkerRunningState("IDLE", 0);
            QUEUING = new WorkerRunningState("QUEUING", 1);
            QUEUED = new WorkerRunningState("QUEUED", 2);
            RUNNING = new WorkerRunningState(DebugCoroutineInfoImplKt.RUNNING, 3);
            $VALUES = $values();
        }
    }

    static /* synthetic */ Deque access$100(SequentialExecutor r0) {
        return r0.queue;
    }

    static /* synthetic */ WorkerRunningState access$200(SequentialExecutor r0) {
        return r0.workerRunningState;
    }

    static /* synthetic */ WorkerRunningState access$202(SequentialExecutor r0, WorkerRunningState r1) {
        r0.workerRunningState = r1;
        return r1;
    }

    static /* synthetic */ long access$308(SequentialExecutor r4) {
        long r0 = r4.workerRunCount;
        r4.workerRunCount = 1 + r0;
        return r0;
    }

    static /* synthetic */ Logger access$400() {
        return log;
    }

    static {
        log = Logger.getLogger(SequentialExecutor.class.getName());
    }

    SequentialExecutor(Executor r3) {
        this.queue = new ArrayDeque();
        this.workerRunningState = WorkerRunningState.IDLE;
        this.workerRunCount = 0;
        this.worker = new QueueWorker(this, null);
        this.executor = (Executor) Preconditions.checkNotNull(r3);
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable r8) {
        Preconditions.checkNotNull(r8);
        Deque<Runnable> r0 = this.queue;
        monitor-enter(r0);
    L54:
        th = move-exception;
        throw th;
    L5:
        if (this.workerRunningState != WorkerRunningState.RUNNING) goto L7;
    L51:
        this.queue.add(r8);     // Catch: Throwable -> L54
        monitor-exit(r0);     // Catch: Throwable -> L54
        return;
    L7:
        if (this.workerRunningState == WorkerRunningState.QUEUED) goto L51;
        long r1 = this.workerRunCount;     // Catch: Throwable -> L54
        Runnable r3 = new AnonymousClass1(this, r8);     // Catch: Throwable -> L54
        this.queue.add(r3);     // Catch: Throwable -> L54
        this.workerRunningState = WorkerRunningState.QUEUING;     // Catch: Throwable -> L54
        monitor-exit(r0);     // Catch: Throwable -> L54
        boolean r9 = true;
        this.executor.execute(this.worker);     // Catch: Throwable -> L31
        if (this.workerRunningState != WorkerRunningState.QUEUING) goto L17;
        r9 = false;
    L17:
        if (r9 == false) goto L19;
        return;
    L19:
        Deque<Runnable> r4 = this.queue;
        monitor-enter(r4);
    L28:
        th = move-exception;
        throw th;
    L22:
        if (this.workerRunCount == r1) goto L24;
    L26:
        monitor-exit(r4);     // Catch: Throwable -> L28
        return;
    L24:
        if (this.workerRunningState != WorkerRunningState.QUEUING) goto L26;
        this.workerRunningState = WorkerRunningState.QUEUED;     // Catch: Throwable -> L28
    L31:
        e = move-exception;
        monitor-enter(this.queue);
    L48:
        th = move-exception;
        throw th;
    L35:
        if (this.workerRunningState == WorkerRunningState.IDLE) goto L39;
        if (this.workerRunningState == WorkerRunningState.QUEUING) goto L39;
    L41:
        r9 = false;
    L43:
        if ((e instanceof RejectedExecutionException) == false) goto L47;
        if (r9 == true) goto L47;
        return;
    L47:
        throw e;     // Catch: Throwable -> L48
    L39:
        if (this.queue.removeLastOccurrence(r3) == false) goto L41;
        goto L41
    }

    public String toString() {
        int r0 = System.identityHashCode(this);
        String r3 = String.valueOf(this.executor);
        return new StringBuilder(String.valueOf(r3).length() + 32).append("SequentialExecutor@").append(r0).append(VectorFormat.DEFAULT_PREFIX).append(r3).append(VectorFormat.DEFAULT_SUFFIX).toString();
    }
}
