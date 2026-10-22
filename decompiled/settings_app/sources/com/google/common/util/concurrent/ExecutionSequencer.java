package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class ExecutionSequencer {
    private ThreadConfinedTaskQueue latestTaskQueue;
    private final AtomicReference<ListenableFuture<Void>> ref;

    static final enum RunningState extends Enum<RunningState> {
        private static final /* synthetic */ RunningState[] $VALUES = null;
        public static final RunningState CANCELLED = null;
        public static final RunningState NOT_RUN = null;
        public static final RunningState STARTED = null;

        private static /* synthetic */ RunningState[] $values() {
            return new RunningState[]{NOT_RUN, CANCELLED, STARTED};
        }

        private RunningState(String r1, int r2) {
            super(r1, r2);
        }

        public static RunningState valueOf(String r1) {
            return (RunningState) Enum.valueOf(RunningState.class, r1);
        }

        public static RunningState[] values() {
            return (RunningState[]) $VALUES.clone();
        }

        static {
            NOT_RUN = new RunningState("NOT_RUN", 0);
            CANCELLED = new RunningState("CANCELLED", 1);
            STARTED = new RunningState("STARTED", 2);
            $VALUES = $values();
        }
    }

    private static final class TaskNonReentrantExecutor extends AtomicReference<RunningState> implements Executor, Runnable {

        @CheckForNull
        Executor delegate;

        @CheckForNull
        ExecutionSequencer sequencer;

        @CheckForNull
        Thread submitting;

        @CheckForNull
        Runnable task;

        /* synthetic */ TaskNonReentrantExecutor(Executor r1, ExecutionSequencer r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ boolean access$200(TaskNonReentrantExecutor r0) {
            return r0.trySetStarted();
        }

        static /* synthetic */ boolean access$300(TaskNonReentrantExecutor r0) {
            return r0.trySetCancelled();
        }

        private TaskNonReentrantExecutor(Executor r2, ExecutionSequencer r3) {
            super(RunningState.NOT_RUN);
            this.delegate = r2;
            this.sequencer = r3;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r5) {
            if (get() != RunningState.CANCELLED) goto L6;
            this.delegate = null;
            this.sequencer = null;
            return;
        L6:
            this.submitting = Thread.currentThread();
            ThreadConfinedTaskQueue r0 = ExecutionSequencer.access$400((ExecutionSequencer) Objects.requireNonNull(this.sequencer));     // Catch: Throwable -> L17
            if (r0.thread != this.submitting) goto L14;
            this.sequencer = null;     // Catch: Throwable -> L17
            if (r0.nextTask != null) goto L12;
            boolean r1 = true;
        L13:
            Preconditions.checkState(r1);     // Catch: Throwable -> L17
            r0.nextTask = r5;     // Catch: Throwable -> L17
            r0.nextExecutor = (Executor) Objects.requireNonNull(this.delegate);     // Catch: Throwable -> L17
            this.delegate = null;     // Catch: Throwable -> L17
        L15:
            this.submitting = null;
            return;
        L12:
            r1 = false;
            goto L13
        L14:
            Executor r2 = (Executor) Objects.requireNonNull(this.delegate);     // Catch: Throwable -> L17
            this.delegate = null;     // Catch: Throwable -> L17
            this.task = r5;     // Catch: Throwable -> L17
            r2.execute(this);     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            this.submitting = null;
            throw th;
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread r0 = Thread.currentThread();
            AnonymousClass1 r2 = null;
            if (r0 == this.submitting) goto L6;
            Runnable r1 = (Runnable) Objects.requireNonNull(this.task);
            this.task = null;
            r1.run();
            return;
        L6:
            ThreadConfinedTaskQueue r3 = new ThreadConfinedTaskQueue(r2);
            r3.thread = r0;
            ExecutionSequencer.access$402((ExecutionSequencer) Objects.requireNonNull(this.sequencer), r3);
            this.sequencer = null;
            Runnable r4 = (Runnable) Objects.requireNonNull(this.task);     // Catch: Throwable -> L22
            this.task = null;     // Catch: Throwable -> L22
            r4.run();     // Catch: Throwable -> L22
        L8:
            Runnable r6 = r3.nextTask;     // Catch: Throwable -> L22
            boolean r5 = true;
            if (r6 == null) goto L11;
            boolean r7 = true;
        L12:
            Executor r8 = r3.nextExecutor;     // Catch: Throwable -> L22
            if (r8 != null) goto L17;
            r5 = false;
        L17:
            if ((r5 & r7) == false) goto L20;
            r3.nextTask = null;     // Catch: Throwable -> L22
            r3.nextExecutor = null;     // Catch: Throwable -> L22
            r8.execute(r6);     // Catch: Throwable -> L22
            goto L8
        L20:
            r3.thread = null;
            return;
        L11:
            r7 = false;
        L22:
            th = move-exception;
            r3.thread = null;
            throw th;
        }

        private boolean trySetStarted() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.STARTED);
        }

        private boolean trySetCancelled() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.CANCELLED);
        }
    }

    private static final class ThreadConfinedTaskQueue {

        @CheckForNull
        Executor nextExecutor;

        @CheckForNull
        Runnable nextTask;

        @CheckForNull
        Thread thread;

        private ThreadConfinedTaskQueue() {
        }

        /* synthetic */ ThreadConfinedTaskQueue(AnonymousClass1 r1) {
            this();
        }
    }

    static /* synthetic */ ThreadConfinedTaskQueue access$400(ExecutionSequencer r0) {
        return r0.latestTaskQueue;
    }

    static /* synthetic */ ThreadConfinedTaskQueue access$402(ExecutionSequencer r0, ThreadConfinedTaskQueue r1) {
        r0.latestTaskQueue = r1;
        return r1;
    }

    private ExecutionSequencer() {
        this.ref = new AtomicReference(Futures.immediateVoidFuture());
        this.latestTaskQueue = new ThreadConfinedTaskQueue(null);
    }

    public static ExecutionSequencer create() {
        return new ExecutionSequencer();
    }

    public <T> ListenableFuture<T> submit(final Callable<T> r2, Executor r3) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        return submitAsync(new AnonymousClass1(this, r2), r3);
    }

    public <T> ListenableFuture<T> submitAsync(final AsyncCallable<T> r9, Executor r10) {
        Preconditions.checkNotNull(r9);
        Preconditions.checkNotNull(r10);
        final TaskNonReentrantExecutor r6 = new TaskNonReentrantExecutor(r10, this, null);
        AsyncCallable<T> r11 = new AnonymousClass2(this, r6, r9);
        final SettableFuture r3 = SettableFuture.create();
        final ListenableFuture<Void> r4 = this.ref.getAndSet(r3);
        final TrustedListenableFutureTask r12 = TrustedListenableFutureTask.create(r11);
        r4.addListener(r12, r6);
        final ListenableFuture<T> r13 = Futures.nonCancellationPropagating(r12);
        Runnable r7 = new AnonymousClass3(this, r12, r3, r4, r13, r6);
        r13.addListener(r7, MoreExecutors.directExecutor());
        r12.addListener(r7, MoreExecutors.directExecutor());
        return r13;
    }
}
