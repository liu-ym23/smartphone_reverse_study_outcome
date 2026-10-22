package okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u00013B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010!\u001a\u00020\"J\r\u0010#\u001a\u00020\u000eH\u0000¢\u0006\u0002\b$J8\u0010%\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u000e2\u000e\b\u0004\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0*H\u0086\bø\u0001\u0000J\u0006\u0010+\u001a\u00020,J.\u0010-\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020'2\u000e\b\u0004\u0010)\u001a\b\u0012\u0004\u0012\u00020'0*H\u0086\bø\u0001\u0000J\u0018\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020'J%\u0010/\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\b2\u0006\u0010&\u001a\u00020'2\u0006\u00100\u001a\u00020\u000eH\u0000¢\u0006\u0002\b1J\u0006\u0010\u001c\u001a\u00020\"J\b\u00102\u001a\u00020\u0005H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u001a\u0010\u001c\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00064"}, d2 = {"Lokhttp3/internal/concurrent/TaskQueue;", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "name", "", "(Lokhttp3/internal/concurrent/TaskRunner;Ljava/lang/String;)V", "activeTask", "Lokhttp3/internal/concurrent/Task;", "getActiveTask$okhttp", "()Lokhttp3/internal/concurrent/Task;", "setActiveTask$okhttp", "(Lokhttp3/internal/concurrent/Task;)V", "cancelActiveTask", "", "getCancelActiveTask$okhttp", "()Z", "setCancelActiveTask$okhttp", "(Z)V", "futureTasks", "", "getFutureTasks$okhttp", "()Ljava/util/List;", "getName$okhttp", "()Ljava/lang/String;", "scheduledTasks", "", "getScheduledTasks", "shutdown", "getShutdown$okhttp", "setShutdown$okhttp", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "cancelAll", "", "cancelAllAndDecide", "cancelAllAndDecide$okhttp", "execute", "delayNanos", "", "cancelable", "block", "Lkotlin/Function0;", "idleLatch", "Ljava/util/concurrent/CountDownLatch;", "schedule", "task", "scheduleAndDecide", "recurrence", "scheduleAndDecide$okhttp", "toString", "AwaitIdleTask", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TaskQueue {
    private Task activeTask;
    private boolean cancelActiveTask;
    private final List<Task> futureTasks;
    private final String name;
    private boolean shutdown;
    private final TaskRunner taskRunner;

    /* JADX INFO: compiled from: TaskQueue.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lokhttp3/internal/concurrent/TaskQueue$AwaitIdleTask;", "Lokhttp3/internal/concurrent/Task;", "()V", "latch", "Ljava/util/concurrent/CountDownLatch;", "getLatch", "()Ljava/util/concurrent/CountDownLatch;", "runOnce", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class AwaitIdleTask extends Task {
        private final CountDownLatch latch;

        public AwaitIdleTask() {
            super(Intrinsics.stringPlus(Util.okHttpName, " awaitIdle"), false);
            this.latch = new CountDownLatch(1);
        }

        public final CountDownLatch getLatch() {
            return this.latch;
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            this.latch.countDown();
            return -1;
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.concurrent.TaskQueue$execute$1, reason: invalid class name */
    /* JADX INFO: compiled from: TaskQueue.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"okhttp3/internal/concurrent/TaskQueue$execute$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass1 extends Task {
        final /* synthetic */ Function0<Unit> $block;
        final /* synthetic */ boolean $cancelable;
        final /* synthetic */ String $name;

        public AnonymousClass1(String r1, boolean r2, Function0<Unit> r3) {
            this.$name = r1;
            this.$cancelable = r2;
            this.$block = r3;
            super(r1, r2);
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            this.$block.invoke();
            return -1;
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.concurrent.TaskQueue$schedule$2, reason: invalid class name */
    /* JADX INFO: compiled from: TaskQueue.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"okhttp3/internal/concurrent/TaskQueue$schedule$2", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass2 extends Task {
        final /* synthetic */ Function0<Long> $block;
        final /* synthetic */ String $name;

        public AnonymousClass2(String r3, Function0<Long> r4) {
            this.$name = r3;
            this.$block = r4;
            super(r3, false, 2, null);
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            return this.$block.invoke().longValue();
        }
    }

    public TaskQueue(TaskRunner r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "taskRunner");
        Intrinsics.checkNotNullParameter(r3, "name");
        this.taskRunner = r2;
        this.name = r3;
        this.futureTasks = new ArrayList();
    }

    public final TaskRunner getTaskRunner$okhttp() {
        return this.taskRunner;
    }

    public final String getName$okhttp() {
        return this.name;
    }

    public final boolean getShutdown$okhttp() {
        return this.shutdown;
    }

    public final void setShutdown$okhttp(boolean r1) {
        this.shutdown = r1;
    }

    public final Task getActiveTask$okhttp() {
        return this.activeTask;
    }

    public final void setActiveTask$okhttp(Task r1) {
        this.activeTask = r1;
    }

    public final List<Task> getFutureTasks$okhttp() {
        return this.futureTasks;
    }

    public final boolean getCancelActiveTask$okhttp() {
        return this.cancelActiveTask;
    }

    public final void setCancelActiveTask$okhttp(boolean r1) {
        this.cancelActiveTask = r1;
    }

    public final List<Task> getScheduledTasks() {
        TaskRunner r0 = this.taskRunner;
        monitor-enter(r0);
        List<Task> r1 = CollectionsKt.toList(getFutureTasks$okhttp());     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void schedule$default(TaskQueue r0, Task r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        r0.schedule(r1, r2);
    }

    public final void schedule(Task r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "task");
        TaskRunner r0 = this.taskRunner;
        monitor-enter(r0);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (getShutdown$okhttp() == false) goto L19;
        if (r3.getCancelable() == false) goto L14;
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE) == false) goto L11;
        TaskLoggerKt.access$log(r3, this, "schedule canceled (queue is shutdown)");     // Catch: Throwable -> L24
    L11:
        monitor-exit(r0);
        return;
    L14:
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE) == false) goto L17;
        TaskLoggerKt.access$log(r3, this, "schedule failed (queue is shutdown)");     // Catch: Throwable -> L24
    L17:
        throw new RejectedExecutionException();     // Catch: Throwable -> L24
    L19:
        if (scheduleAndDecide$okhttp(r3, r4, false) == false) goto L21;
        getTaskRunner$okhttp().kickCoordinator$okhttp(this);     // Catch: Throwable -> L24
    L21:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r0);
    }

    public static /* synthetic */ void schedule$default(TaskQueue r0, String r1, long r2, Function0 r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        Intrinsics.checkNotNullParameter(r1, "name");
        Intrinsics.checkNotNullParameter(r4, "block");
        r0.schedule(new AnonymousClass2(r1, r4), r2);
    }

    public final void schedule(String r2, long r3, Function0<Long> r5) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r5, "block");
        schedule(new AnonymousClass2(r2, r5), r3);
    }

    public static /* synthetic */ void execute$default(TaskQueue r0, String r1, long r2, boolean r4, Function0 r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r4 = true;
    L8:
        Intrinsics.checkNotNullParameter(r1, "name");
        Intrinsics.checkNotNullParameter(r5, "block");
        r0.schedule(new AnonymousClass1(r1, r4, r5), r2);
    }

    public final void execute(String r2, long r3, boolean r5, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r6, "block");
        schedule(new AnonymousClass1(r2, r5, r6), r3);
    }

    public final CountDownLatch idleLatch() {
        TaskRunner r0 = this.taskRunner;
        monitor-enter(r0);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (getActiveTask$okhttp() == null) goto L7;
    L11:
        Task r1 = getActiveTask$okhttp();     // Catch: Throwable -> L30
        if ((r1 instanceof AwaitIdleTask) == false) goto L16;
        CountDownLatch r6 = ((AwaitIdleTask) r1).getLatch();     // Catch: Throwable -> L30
        monitor-exit(r0);
        return r6;
    L16:
        Iterator<Task> r2 = getFutureTasks$okhttp().iterator();     // Catch: Throwable -> L30
    L18:
        if (r2.hasNext() == false) goto L24;
        Task r3 = r2.next();     // Catch: Throwable -> L30
        if ((r3 instanceof AwaitIdleTask) == false) goto L18;
        CountDownLatch r7 = ((AwaitIdleTask) r3).getLatch();     // Catch: Throwable -> L30
        monitor-exit(r0);
        return r7;
    L24:
        AwaitIdleTask r4 = new AwaitIdleTask();     // Catch: Throwable -> L30
        if (scheduleAndDecide$okhttp(r4, 0, false) == false) goto L27;
        getTaskRunner$okhttp().kickCoordinator$okhttp(this);     // Catch: Throwable -> L30
    L27:
        CountDownLatch r8 = r4.getLatch();     // Catch: Throwable -> L30
        monitor-exit(r0);
        return r8;
    L7:
        if (getFutureTasks$okhttp().isEmpty() == false) goto L11;
        CountDownLatch r9 = new CountDownLatch(0);     // Catch: Throwable -> L30
        monitor-exit(r0);
        return r9;
    }

    public final boolean scheduleAndDecide$okhttp(Task r10, long r11, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "task");
        r10.initQueue$okhttp(this);
        long r0 = this.taskRunner.getBackend().nanoTime();
        long r2 = r0 + r11;
        int r4 = this.futureTasks.indexOf(r10);
        if (r4 != (-1)) goto L5;
    L11:
        r10.setNextExecuteNanoTime$okhttp(r2);
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE) == false) goto L17;
        if (r13 == false) goto L15;
        String r14 = Intrinsics.stringPlus("run again after ", TaskLoggerKt.formatDuration(r2 - r0));
    L16:
        TaskLoggerKt.access$log(r10, this, r14);
        goto L17
    L15:
        r14 = Intrinsics.stringPlus("scheduled after ", TaskLoggerKt.formatDuration(r2 - r0));
    L17:
        Iterator<Task> r15 = this.futureTasks.iterator();
        int r3 = 0;
    L19:
        if (r15.hasNext() == false) goto L27;
        if ((r15.next().getNextExecuteNanoTime$okhttp() - r0) <= r11) goto L23;
        boolean r5 = true;
    L24:
        if (r5 == true) goto L28;
        r3 = r3 + 1;
    L28:
        if (r3 != (-1)) goto L30;
        r3 = this.futureTasks.size();
    L30:
        this.futureTasks.add(r3, r10);
        if (r3 == 0) goto L33;
        return false;
    L33:
        return true;
    L23:
        r5 = false;
        goto L24
    L27:
        r3 = -1;
        goto L28
    L5:
        if (r10.getNextExecuteNanoTime$okhttp() <= r2) goto L7;
        this.futureTasks.remove(r4);
        goto L11
    L7:
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE) == false) goto L9;
        TaskLoggerKt.access$log(r10, this, "already scheduled");
    L9:
        return false;
    }

    public final boolean cancelAllAndDecide$okhttp() {
        Task r0 = this.activeTask;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNull(r0);
        if (r0.getCancelable() == false) goto L7;
        this.cancelActiveTask = true;
    L7:
        int r1 = this.futureTasks.size() - 1;
        boolean r2 = false;
        if (r1 < 0) goto L18;
    L9:
        int r3 = r1 - 1;
        if (this.futureTasks.get(r1).getCancelable() == false) goto L15;
        Task r4 = this.futureTasks.get(r1);
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE) == false) goto L14;
        TaskLoggerKt.access$log(r4, this, "canceled");
    L14:
        this.futureTasks.remove(r1);
        r2 = true;
    L15:
        if (r3 < 0) goto L18;
        r1 = r3;
    L18:
        return r2;
    }

    public String toString() {
        return this.name;
    }

    public final void cancelAll() {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        TaskRunner r0 = this.taskRunner;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L12:
        if (cancelAllAndDecide$okhttp() == false) goto L14;
        getTaskRunner$okhttp().kickCoordinator$okhttp(this);     // Catch: Throwable -> L17
    L14:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r0);
        return;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final void shutdown() {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        TaskRunner r0 = this.taskRunner;
        monitor-enter(r0);
        setShutdown$okhttp(true);     // Catch: Throwable -> L18
        if (cancelAllAndDecide$okhttp() == false) goto L15;
        getTaskRunner$okhttp().kickCoordinator$okhttp(this);     // Catch: Throwable -> L18
    L15:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r0);
        return;
    L18:
        th = move-exception;
        throw th;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }
}
