package com.bytedance.blockframework.framework.task;

import com.bytedance.blockframework.framework.config.BlockInit;
import com.bytedance.blockframework.framework.join.IBlockScene;
import com.bytedance.blockframework.framework.monitor.BlockLogger;
import com.bytedance.blockframework.framework.monitor.BlockLoggerKt;
import com.bytedance.blockframework.framework.monitor.BlockMonitor;
import com.bytedance.blockframework.framework.monitor.BlockMonitorKt;
import com.bytedance.blockframework.framework.performance.HandlerProcessor;
import com.bytedance.blockframework.framework.performance.ThreadProcessor;
import com.bytedance.blockframework.framework.utils.BlockExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TaskManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u001e\u001a\u00020\r2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\b\u0010 \u001a\u00020\rH\u0016J\u001a\u0010!\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010#\u001a\u00020$H\u0002Jn\u0010%\u001a\u00020\r2 \u0010&\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\nj\u0004\u0018\u0001`\u000e2 \u0010'\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\nj\u0004\u0018\u0001`\u000e2 \u0010\t\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\nj\u0004\u0018\u0001`\u000eH\u0017J2\u0010(\u001a\u00020\r2 \u0010&\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\nj\u0004\u0018\u0001`\u000e2\u0006\u0010)\u001a\u00020*H\u0003JT\u0010+\u001a\u00020\r2 \u0010'\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\nj\u0004\u0018\u0001`\u000e2 \u0010&\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\nj\u0004\u0018\u0001`\u000e2\u0006\u0010)\u001a\u00020*H\u0003R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R(\u0010\t\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\nj\u0004\u0018\u0001`\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\f0\f0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\f0\f0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/blockframework/framework/task/TaskManager;", "Lcom/bytedance/blockframework/framework/task/ITaskManager;", "scene", "Lcom/bytedance/blockframework/framework/join/IBlockScene;", "allTaskMustRunOnMain", "", "(Lcom/bytedance/blockframework/framework/join/IBlockScene;Z)V", "TAG", "", "allFinished", "Lkotlin/Function1;", "", "Lcom/bytedance/blockframework/framework/task/ScheduleTask;", "", "Lcom/bytedance/blockframework/framework/task/TasksFinished;", "allTasks", "isMainTasksFinish", "isSubTasksFinish", "main", "Lcom/bytedance/blockframework/framework/performance/HandlerProcessor;", "mainThreadTasks", "Ljava/util/PriorityQueue;", "kotlin.jvm.PlatformType", "managerName", "getManagerName", "()Ljava/lang/String;", "managerName$delegate", "Lkotlin/Lazy;", "subThreadTasks", "work", "addTask", "tasks", "clear", "handleException", "task", "t", "", "handleTasks", "mainFinished", "subFinished", "processMainThreadTasks", "start", "", "processTaskInSubThread", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TaskManager implements ITaskManager {
    private final String TAG;
    private Function1<? super List<? extends ScheduleTask>, Unit> allFinished;
    private final boolean allTaskMustRunOnMain;
    private List<? extends ScheduleTask> allTasks;
    private boolean isMainTasksFinish;
    private boolean isSubTasksFinish;
    private HandlerProcessor main;
    private final PriorityQueue<ScheduleTask> mainThreadTasks;
    private final Lazy managerName$delegate;
    private final IBlockScene scene;
    private final PriorityQueue<ScheduleTask> subThreadTasks;
    private HandlerProcessor work;

    /* JADX INFO: renamed from: $r8$lambda$D-I25nvr3CkY4NAa8kVEKi2jsXw, reason: not valid java name */
    public static /* synthetic */ int m70$r8$lambda$DI25nvr3CkY4NAa8kVEKi2jsXw(ScheduleTask r0, ScheduleTask r1) {
        return mainThreadTasks$lambda$0(r0, r1);
    }

    public static /* synthetic */ int $r8$lambda$gFXiCBTALBZysGjJsFzeYYRMcjc(ScheduleTask r0, ScheduleTask r1) {
        return subThreadTasks$lambda$1(r0, r1);
    }

    public TaskManager(IBlockScene r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.scene = r2;
        this.allTaskMustRunOnMain = r3;
        this.TAG = "TaskManager";
        this.managerName$delegate = LazyKt.lazy(new TaskManager$managerName$2(this));
        this.main = new HandlerProcessor(ThreadProcessor.INSTANCE.main(), false);
        this.work = new HandlerProcessor(ThreadProcessor.INSTANCE.work(), false);
        this.mainThreadTasks = new PriorityQueue(20, new TaskManager$$ExternalSyntheticLambda0());
        this.subThreadTasks = new PriorityQueue(20, new TaskManager$$ExternalSyntheticLambda1());
        this.allTasks = CollectionsKt.emptyList();
    }

    public static final /* synthetic */ Function1 access$getAllFinished$p(TaskManager r0) {
        return r0.allFinished;
    }

    public static final /* synthetic */ List access$getAllTasks$p(TaskManager r0) {
        return r0.allTasks;
    }

    public static final /* synthetic */ PriorityQueue access$getMainThreadTasks$p(TaskManager r0) {
        return r0.mainThreadTasks;
    }

    public static final /* synthetic */ String access$getManagerName(TaskManager r0) {
        return r0.getManagerName();
    }

    public static final /* synthetic */ IBlockScene access$getScene$p(TaskManager r0) {
        return r0.scene;
    }

    public static final /* synthetic */ boolean access$isMainTasksFinish$p(TaskManager r0) {
        return r0.isMainTasksFinish;
    }

    public static final /* synthetic */ void access$processMainThreadTasks(TaskManager r0, Function1 r1, long r2) {
        r0.processMainThreadTasks(r1, r2);
    }

    public static final /* synthetic */ void access$processTaskInSubThread(TaskManager r0, Function1 r1, Function1 r2, long r3) {
        r0.processTaskInSubThread(r1, r2, r3);
    }

    public static final /* synthetic */ void access$setMainTasksFinish$p(TaskManager r0, boolean r1) {
        r0.isMainTasksFinish = r1;
    }

    public static final /* synthetic */ void access$setSubTasksFinish$p(TaskManager r0, boolean r1) {
        r0.isSubTasksFinish = r1;
    }

    private final String getManagerName() {
        return (String) this.managerName$delegate.getValue();
    }

    private static final int mainThreadTasks$lambda$0(ScheduleTask r0, ScheduleTask r1) {
        return Intrinsics.compare(r1.getTaskPriority(), r0.getTaskPriority());
    }

    private static final int subThreadTasks$lambda$1(ScheduleTask r0, ScheduleTask r1) {
        return Intrinsics.compare(r1.getTaskPriority(), r0.getTaskPriority());
    }

    @Override // com.bytedance.blockframework.framework.task.ITaskManager
    public synchronized void addTask(List<? extends ScheduleTask> r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "tasks");     // Catch: Throwable -> L16
        this.allTasks = r3;     // Catch: Throwable -> L16
        Iterator<T> r4 = r3.iterator();     // Catch: Throwable -> L16
    L5:
        if (r4.hasNext() == false) goto L13;
        ScheduleTask r0 = (ScheduleTask) r4.next();     // Catch: Throwable -> L16
        if (this.allTaskMustRunOnMain == true) goto L12;
        if (r0.getMustMainThread() == true) goto L12;
        this.subThreadTasks.add(r0);     // Catch: Throwable -> L16
    L12:
        this.mainThreadTasks.add(r0);     // Catch: Throwable -> L16
        goto L5
    L13:
        this.isMainTasksFinish = this.mainThreadTasks.isEmpty();     // Catch: Throwable -> L16
        this.isSubTasksFinish = this.subThreadTasks.isEmpty();     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.blockframework.framework.task.ITaskManager
    public void handleTasks(final Function1<? super List<? extends ScheduleTask>, Unit> r19, final Function1<? super List<? extends ScheduleTask>, Unit> r20, Function1<? super List<? extends ScheduleTask>, Unit> r21) {
        this.allFinished = r21;
        final long r7 = BlockLoggerKt.currentTime();
        BlockMonitor.record$default(BlockMonitor.INSTANCE, this.scene.getName(), getManagerName(), BlockMonitorKt.TYPE_BLOCK_RUN_TASK, "start_handle_tasks", 0, 16, null);
        if (this.subThreadTasks.isEmpty() == true) goto L6;
        this.work.post(new AnonymousClass1(this, r20, r19, r7));
    L6:
        if (this.mainThreadTasks.isEmpty() == true) goto L9;
        processMainThreadTasks(r19, r7);
        return;
    }

    private final void processMainThreadTasks(Function1<? super List<? extends ScheduleTask>, Unit> r13, long r14) {
        ArrayList r0 = new ArrayList();
        long r1 = BlockLoggerKt.currentTime();
        BlockMonitor.record$default(BlockMonitor.INSTANCE, this.scene.getName(), getManagerName(), BlockMonitorKt.TYPE_BLOCK_RUN_TASK, "start_handle_main_tasks", 0, 16, null);
    L3:
        ScheduleTask r3 = this.mainThreadTasks.poll();
        if (r3 == null) goto L7;
        r3.run();
        r0.add(r3);
    L7:
        if (this.mainThreadTasks.isEmpty() == false) goto L18;
        BlockMonitor.INSTANCE.record(this.scene.getName(), getManagerName(), BlockMonitorKt.TYPE_BLOCK_RUN_TASK, "mainTasks_end", BlockLoggerKt.currentTime() - r1);
        if (r13 == null) goto L11;
        r13.invoke(r0);
    L11:
        this.isMainTasksFinish = true;
        if (this.isSubTasksFinish == false) goto L18;
        Function1<? super List<? extends ScheduleTask>, Unit> r4 = this.allFinished;
        if (r4 == null) goto L16;
        r4.invoke(this.allTasks);
    L16:
        BlockMonitor.INSTANCE.record(this.scene.getName(), getManagerName(), BlockMonitorKt.TYPE_BLOCK_RUN_TASK, "allTask_main_end", BlockLoggerKt.currentTime() - r14);
    L18:
        if (this.mainThreadTasks.isEmpty() == false) goto L3;
    }

    private final void processTaskInSubThread(final Function1<? super List<? extends ScheduleTask>, Unit> r22, final Function1<? super List<? extends ScheduleTask>, Unit> r23, final long r24) {
        final ArrayList r8 = new ArrayList();
        final ArrayList r9 = new ArrayList();
        long r10 = BlockLoggerKt.currentTime();
        BlockMonitor.record$default(BlockMonitor.INSTANCE, this.scene.getName(), getManagerName(), BlockMonitorKt.TYPE_BLOCK_RUN_TASK, "start_handle_sub_tasks", 0, 16, null);
    L3:
        ScheduleTask r1 = this.subThreadTasks.poll();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        TaskManager r2 = this;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        r1.run();     // Catch: Throwable -> L10
        Boolean r3 = Boolean.valueOf(r8.add(r1));     // Catch: Throwable -> L10
    L8:
        Object r4 = Result.m774constructorimpl(r3);     // Catch: Throwable -> L10
    L12:
        Throwable r5 = Result.m777exceptionOrNullimpl(r4);
        if (r5 == null) goto L18;
        if (r1 == null) goto L16;
        r9.add(r1);
    L16:
        handleException(r1, r5);
    L18:
        if (this.subThreadTasks.isEmpty() == false) goto L26;
        if (r9.size() <= 0) goto L23;
        this.main.post(new AnonymousClass3(this, r9, r23));
    L23:
        BlockMonitor.INSTANCE.record(this.scene.getName(), getManagerName(), BlockMonitorKt.TYPE_BLOCK_RUN_TASK, "subTasks_end", BlockLoggerKt.currentTime() - r10);
        this.main.post(new AnonymousClass4(r22, r8, this, r24));
    L26:
        if (this.subThreadTasks.isEmpty() == false) goto L3;
        return;
    L7:
        r3 = null;
    L10:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // com.bytedance.blockframework.framework.task.ITaskManager
    public void clear() {
        this.mainThreadTasks.clear();
        this.subThreadTasks.clear();
    }

    private final void handleException(ScheduleTask r2, Throwable r3) {
        if ((r2 instanceof BlockViewBuildTask) == true) goto L5;
        return;
    L5:
        if (BlockInit.INSTANCE.logOptEnable() == true) goto L7;
    L8:
        BlockLoggerKt.logger(this.TAG, ((BlockViewBuildTask) r2).getBlockScene() + " build UI Exception in " + Thread.currentThread().getName());
    L9:
        BlockExtKt.uploadException(r3, true);
        BlockInit.INSTANCE.recordException(r3);
        return;
    L7:
        if (BlockLogger.Companion.debug() == false) goto L9;
        goto L8
    }
}
