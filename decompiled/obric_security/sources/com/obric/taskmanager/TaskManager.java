package com.obric.taskmanager;

import androidx.exifinterface.media.ExifInterface;
import com.obric.olog.OLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TaskManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0010\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bJ\u0006\u0010\u001c\u001a\u00020\u0019J\u001c\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00192\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J(\u0010!\u001a\b\u0012\u0004\u0012\u0002H#0\"\"\u0004\b\u0000\u0010#2\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H#0$R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/taskmanager/TaskManager;", "", "()V", "activeTasks", "Ljava/util/concurrent/atomic/AtomicInteger;", "completedTasks", "Ljava/util/concurrent/atomic/AtomicLong;", "corePoolSize", "", "executorService", "Ljava/util/concurrent/ThreadPoolExecutor;", "failedTasks", "keepAliveTime", "", "maxPoolSize", "threadFactory", "com/obric/taskmanager/TaskManager$threadFactory$1", "Lcom/obric/taskmanager/TaskManager$threadFactory$1;", "totalTasks", "workQueue", "Ljava/util/concurrent/BlockingQueue;", "Ljava/lang/Runnable;", "execute", "", "taskId", "", "task", "Lcom/obric/taskmanager/TaskWithCallback;", "getTaskStats", "log", "message", "throwable", "", "submit", "Ljava/util/concurrent/Future;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/concurrent/Callable;", "Companion", "api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TaskManager {
    public static final Companion Companion = null;
    private static final boolean LOG_VERBOSE = true;
    private static final String TAG = "TaskManager";
    private static volatile TaskManager instance;
    private final AtomicInteger activeTasks;
    private final AtomicLong completedTasks;
    private final int corePoolSize;
    private final ThreadPoolExecutor executorService;
    private final AtomicLong failedTasks;
    private final long keepAliveTime;
    private final int maxPoolSize;
    private final TaskManager$threadFactory$1 threadFactory;
    private final AtomicLong totalTasks;
    private final BlockingQueue<Runnable> workQueue;

    /* JADX INFO: compiled from: TaskManager.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/taskmanager/TaskManager$Companion;", "", "()V", "LOG_VERBOSE", "", "TAG", "", "instance", "Lcom/obric/taskmanager/TaskManager;", "getInstance", "api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final TaskManager getInstance() {
            TaskManager r0 = TaskManager.access$getInstance$cp();
            if (r0 != null) goto L13;
            monitor-enter(this);
            r0 = TaskManager.access$getInstance$cp();     // Catch: Throwable -> L10
            if (r0 != null) goto L8;
            r0 = new TaskManager(null);     // Catch: Throwable -> L10
            Companion r1 = TaskManager.Companion;     // Catch: Throwable -> L10
            TaskManager.access$setInstance$cp(r0);     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r0;
        }
    }

    public static /* synthetic */ void $r8$lambda$7Qa4nJqtwb5uKLlb8mhmXYDMWC4(TaskManager r0, String r1, TaskWithCallback r2) {
        execute$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ Object $r8$lambda$siPx9yruIWTZ56HXj9Ab_2Oml88(TaskManager r0, String r1, Callable r2) {
        return submit$lambda$1(r0, r1, r2);
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ TaskManager(DefaultConstructorMarker r1) {
        this();
    }

    private TaskManager() {
        this.corePoolSize = 8;
        this.maxPoolSize = 8;
        this.keepAliveTime = 30;
        LinkedBlockingQueue r6 = new LinkedBlockingQueue();
        this.workQueue = r6;
        this.totalTasks = new AtomicLong(0);
        this.activeTasks = new AtomicInteger(0);
        this.completedTasks = new AtomicLong(0);
        this.failedTasks = new AtomicLong(0);
        TaskManager$threadFactory$1 r0 = new TaskManager$threadFactory$1(this);
        this.threadFactory = r0;
        ThreadPoolExecutor r8 = new ThreadPoolExecutor(8, 8, 30, TimeUnit.SECONDS, r6, r0);
        r8.allowCoreThreadTimeOut(true);
        this.executorService = r8;
    }

    public static final /* synthetic */ AtomicInteger access$getActiveTasks$p(TaskManager r0) {
        return r0.activeTasks;
    }

    public static final /* synthetic */ AtomicLong access$getFailedTasks$p(TaskManager r0) {
        return r0.failedTasks;
    }

    public static final /* synthetic */ TaskManager access$getInstance$cp() {
        return instance;
    }

    public static final /* synthetic */ void access$log(TaskManager r0, String r1, Throwable r2) {
        r0.log(r1, r2);
    }

    public static final /* synthetic */ void access$setInstance$cp(TaskManager r0) {
        instance = r0;
    }

    public final <T> Future<T> submit(final String r2, final Callable<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "task");
        Callable<T> r0 = new TaskManager$$ExternalSyntheticLambda0(this, r2, r3);
        Future<T> r1 = this.executorService.submit(r0);
        Intrinsics.checkNotNullExpressionValue(r1, "executorService.submit(wrappedTask)");
        return r1;
    }

    private static final Object submit$lambda$1(TaskManager r5, String r6, Callable r7) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r6, "$taskId");
        Intrinsics.checkNotNullParameter(r7, "$task");
        log$default(r5, "任务[" + r6 + "]开始执行", null, 2, null);
        r5.activeTasks.incrementAndGet();
        r5.totalTasks.incrementAndGet();
        Object r8 = r7.call();     // Catch: Throwable -> L6 Exception -> L8
        log$default(r5, "任务[" + r6 + "]执行成功", null, 2, null);     // Catch: Throwable -> L6 Exception -> L8
        r5.completedTasks.incrementAndGet();     // Catch: Throwable -> L6 Exception -> L8
        r5.activeTasks.decrementAndGet();
        return r8;
    L8:
        e = move-exception;
        r5.log("任务[" + r6 + "]执行失败: " + e.getMessage(), e);     // Catch: Throwable -> L6
        r5.failedTasks.incrementAndGet();     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        r5.activeTasks.decrementAndGet();
        throw th;
    }

    public final void execute(final String r2, final TaskWithCallback<?> r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "task");
        Runnable r0 = new TaskManager$$ExternalSyntheticLambda1(this, r2, r3);
        this.executorService.execute(r0);
    }

    private static final void execute$lambda$2(TaskManager r6, String r7, TaskWithCallback r8) {
        Intrinsics.checkNotNullParameter(r6, "this$0");
        Intrinsics.checkNotNullParameter(r7, "$taskId");
        Intrinsics.checkNotNullParameter(r8, "$task");
        log$default(r6, "任务[" + r7 + "]开始执行", null, 2, null);
        r6.activeTasks.incrementAndGet();
        r6.totalTasks.incrementAndGet();
        Object r0 = r8.call();     // Catch: Throwable -> L5 Exception -> L7
        log$default(r6, "任务[" + r7 + "]执行成功", null, 2, null);     // Catch: Throwable -> L5 Exception -> L7
        r6.completedTasks.incrementAndGet();     // Catch: Throwable -> L5 Exception -> L7
        r8.onSuccess(r0);     // Catch: Throwable -> L5 Exception -> L7
    L4:
        r6.activeTasks.decrementAndGet();
        return;
    L7:
        e = move-exception;
        r6.log("任务[" + r7 + "]执行失败: " + e.getMessage(), e);     // Catch: Throwable -> L5
        r6.failedTasks.incrementAndGet();     // Catch: Throwable -> L5
        r8.onError(e);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        r6.activeTasks.decrementAndGet();
        throw th;
    }

    public final String getTaskStats() {
        return "总任务: " + this.totalTasks.get() + ", 活跃任务: " + this.activeTasks.get() + ", 已完成: " + this.completedTasks.get() + ", 失败: " + this.failedTasks.get();
    }

    static /* synthetic */ void log$default(TaskManager r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.log(r1, r2);
    }

    private final void log(String r1, Throwable r2) {
        if (r2 != null) goto L5;
        OLog.d(TAG, r1);
        return;
    L5:
        OLog.e(TAG, r1, r2);
    }
}
