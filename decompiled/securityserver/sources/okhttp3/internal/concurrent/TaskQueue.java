package okhttp3.internal.concurrent;

import a.a;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class TaskQueue {

    @Nullable
    private Task activeTask;
    private boolean cancelActiveTask;

    @NotNull
    private final List<Task> futureTasks;

    @NotNull
    private final String name;
    private boolean shutdown;

    @NotNull
    private final TaskRunner taskRunner;

    @Metadata
    public static final class AwaitIdleTask extends Task {

        @NotNull
        private final CountDownLatch latch;

        public AwaitIdleTask() {
            super(a.o(new StringBuilder(), Util.okHttpName, " awaitIdle"), false);
            this.latch = new CountDownLatch(1);
        }

        @NotNull
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
    @Metadata
    public static final class AnonymousClass1 extends Task {
        final /* synthetic */ Function0 $block;
        final /* synthetic */ boolean $cancelable;
        final /* synthetic */ String $name;

        public AnonymousClass1(Function0 r1, String r2, boolean r3, String r4, boolean r5) {
            this.$block = r1;
            this.$name = r2;
            this.$cancelable = r3;
            super(r4, r5);
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            this.$block.invoke();
            return -1;
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.concurrent.TaskQueue$schedule$2, reason: invalid class name */
    @Metadata
    public static final class AnonymousClass2 extends Task {
        final /* synthetic */ Function0 $block;
        final /* synthetic */ String $name;

        public AnonymousClass2(Function0 r2, String r3, String r4) {
            this.$block = r2;
            this.$name = r3;
            super(r4, false, 2, null);
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            return ((Number) this.$block.invoke()).longValue();
        }
    }

    public TaskQueue(@NotNull TaskRunner r2, @NotNull String r3) {
        Intrinsics.f(r2, "taskRunner");
        Intrinsics.f(r3, "name");
        this.taskRunner = r2;
        this.name = r3;
        this.futureTasks = new ArrayList();
    }

    public static /* synthetic */ void execute$default(TaskQueue r6, String r7, long r8, boolean r10, Function0 r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r8 = 0;
    L6:
        if ((r12 & 4) == 0) goto L8;
        r10 = true;
    L8:
        boolean r5 = r10;
        Intrinsics.f(r7, "name");
        Intrinsics.f(r11, "block");
        r6.schedule(new AnonymousClass1(r11, r7, r5, r7, r5), r8);
    }

    public static /* synthetic */ void schedule$default(TaskQueue r0, Task r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        r0.schedule(r1, r2);
    }

    public final void cancelAll() {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        TaskRunner r0 = this.taskRunner;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L12:
        if (cancelAllAndDecide$okhttp() == false) goto L17;
        this.taskRunner.kickCoordinator$okhttp(this);     // Catch: Throwable -> L15
    L17:
        monitor-exit(r0);
        return;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        StringBuilder r1 = new StringBuilder("Thread ");
        Thread r2 = Thread.currentThread();
        Intrinsics.e(r2, "Thread.currentThread()");
        r1.append(r2.getName());
        r1.append(" MUST NOT hold lock on ");
        r1.append(this);
        throw new AssertionError(r1.toString());
    }

    public final boolean cancelAllAndDecide$okhttp() {
        Task r0 = this.activeTask;
        if (r0 == null) goto L7;
        Intrinsics.c(r0);
        if (r0.getCancelable() == false) goto L7;
        this.cancelActiveTask = true;
    L7:
        int r1 = this.futureTasks.size() - 1;
        boolean r2 = false;
    L8:
        if (r1 < 0) goto L16;
        if (this.futureTasks.get(r1).getCancelable() == false) goto L15;
        Task r3 = this.futureTasks.get(r1);
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE) == false) goto L14;
        TaskLoggerKt.access$log(r3, this, "canceled");
    L14:
        this.futureTasks.remove(r1);
        r2 = true;
    L15:
        r1 = r1 - 1;
        goto L8
    L16:
        return r2;
    }

    public final void execute(@NotNull String r8, long r9, boolean r11, @NotNull Function0<Unit> r12) {
        Intrinsics.f(r8, "name");
        Intrinsics.f(r12, "block");
        schedule(new AnonymousClass1(r12, r8, r11, r8, r11), r9);
    }

    @Nullable
    public final Task getActiveTask$okhttp() {
        return this.activeTask;
    }

    public final boolean getCancelActiveTask$okhttp() {
        return this.cancelActiveTask;
    }

    @NotNull
    public final List<Task> getFutureTasks$okhttp() {
        return this.futureTasks;
    }

    @NotNull
    public final String getName$okhttp() {
        return this.name;
    }

    @NotNull
    public final List<Task> getScheduledTasks() {
        TaskRunner r0 = this.taskRunner;
        monitor-enter(r0);
        List<Task> r1 = CollectionsKt.q(this.futureTasks);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean getShutdown$okhttp() {
        return this.shutdown;
    }

    @NotNull
    public final TaskRunner getTaskRunner$okhttp() {
        return this.taskRunner;
    }

    @NotNull
    public final CountDownLatch idleLatch() {
        TaskRunner r0 = this.taskRunner;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.activeTask == null) goto L7;
    L13:
        Task r1 = this.activeTask;     // Catch: Throwable -> L11
        if ((r1 instanceof AwaitIdleTask) == false) goto L18;
        CountDownLatch r5 = ((AwaitIdleTask) r1).getLatch();     // Catch: Throwable -> L11
        monitor-exit(r0);
        return r5;
    L18:
        Iterator<Task> r2 = this.futureTasks.iterator();     // Catch: Throwable -> L11
    L20:
        if (r2.hasNext() == false) goto L26;
        Task r3 = r2.next();     // Catch: Throwable -> L11
        if ((r3 instanceof AwaitIdleTask) == false) goto L20;
        CountDownLatch r6 = ((AwaitIdleTask) r3).getLatch();     // Catch: Throwable -> L11
        monitor-exit(r0);
        return r6;
    L26:
        AwaitIdleTask r4 = new AwaitIdleTask();     // Catch: Throwable -> L11
        if (scheduleAndDecide$okhttp(r4, 0, false) == false) goto L29;
        this.taskRunner.kickCoordinator$okhttp(this);     // Catch: Throwable -> L11
    L29:
        CountDownLatch r7 = r4.getLatch();     // Catch: Throwable -> L11
        monitor-exit(r0);
        return r7;
    L7:
        if (this.futureTasks.isEmpty() == false) goto L13;
        CountDownLatch r8 = new CountDownLatch(0);     // Catch: Throwable -> L11
        monitor-exit(r0);
        return r8;
    }

    public final void schedule(@NotNull Task r3, long r4) {
        Intrinsics.f(r3, "task");
        TaskRunner r0 = this.taskRunner;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.shutdown == false) goto L22;
        if (r3.getCancelable() == false) goto L17;
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE) == false) goto L14;
        TaskLoggerKt.access$log(r3, this, "schedule canceled (queue is shutdown)");     // Catch: Throwable -> L12
    L14:
        monitor-exit(r0);
        return;
    L17:
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE) == false) goto L20;
        TaskLoggerKt.access$log(r3, this, "schedule failed (queue is shutdown)");     // Catch: Throwable -> L12
    L20:
        throw new RejectedExecutionException();     // Catch: Throwable -> L12
    L22:
        if (scheduleAndDecide$okhttp(r3, r4, false) == false) goto L24;
        this.taskRunner.kickCoordinator$okhttp(this);     // Catch: Throwable -> L12
    L24:
        monitor-exit(r0);
    }

    public final boolean scheduleAndDecide$okhttp(@NotNull Task r10, long r11, boolean r13) {
        Intrinsics.f(r10, "task");
        r10.initQueue$okhttp(this);
        long r0 = this.taskRunner.getBackend().nanoTime();
        long r2 = r0 + r11;
        int r4 = this.futureTasks.indexOf(r10);
        if (r4 != (-1)) goto L5;
    L11:
        r10.setNextExecuteNanoTime$okhttp(r2);
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE) == false) goto L17;
        if (r13 == false) goto L15;
        String r14 = "run again after " + TaskLoggerKt.formatDuration(r2 - r0);
    L16:
        TaskLoggerKt.access$log(r10, this, r14);
        goto L17
    L15:
        r14 = "scheduled after " + TaskLoggerKt.formatDuration(r2 - r0);
    L17:
        Iterator<Task> r15 = this.futureTasks.iterator();
        int r3 = 0;
    L19:
        if (r15.hasNext() == false) goto L24;
        if ((r15.next().getNextExecuteNanoTime$okhttp() - r0) > r11) goto L25;
        r3 = r3 + 1;
    L25:
        if (r3 != (-1)) goto L27;
        r3 = this.futureTasks.size();
    L27:
        this.futureTasks.add(r3, r10);
        if (r3 != 0) goto L33;
        return true;
    L33:
        return false;
    L24:
        r3 = -1;
        goto L25
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

    public final void setActiveTask$okhttp(@Nullable Task r1) {
        this.activeTask = r1;
    }

    public final void setCancelActiveTask$okhttp(boolean r1) {
        this.cancelActiveTask = r1;
    }

    public final void setShutdown$okhttp(boolean r1) {
        this.shutdown = r1;
    }

    public final void shutdown() {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        TaskRunner r0 = this.taskRunner;
        monitor-enter(r0);
        this.shutdown = true;     // Catch: Throwable -> L16
        if (cancelAllAndDecide$okhttp() == false) goto L18;
        this.taskRunner.kickCoordinator$okhttp(this);     // Catch: Throwable -> L16
    L18:
        monitor-exit(r0);
        return;
    L16:
        th = move-exception;
        throw th;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        StringBuilder r1 = new StringBuilder("Thread ");
        Thread r2 = Thread.currentThread();
        Intrinsics.e(r2, "Thread.currentThread()");
        r1.append(r2.getName());
        r1.append(" MUST NOT hold lock on ");
        r1.append(this);
        throw new AssertionError(r1.toString());
    }

    @NotNull
    public String toString() {
        return this.name;
    }

    public static /* synthetic */ void schedule$default(TaskQueue r0, String r1, long r2, Function0 r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        Intrinsics.f(r1, "name");
        Intrinsics.f(r4, "block");
        r0.schedule(new AnonymousClass2(r4, r1, r1), r2);
    }

    public final void schedule(@NotNull String r2, long r3, @NotNull Function0<Long> r5) {
        Intrinsics.f(r2, "name");
        Intrinsics.f(r5, "block");
        schedule(new AnonymousClass2(r5, r2, r2), r3);
    }
}
