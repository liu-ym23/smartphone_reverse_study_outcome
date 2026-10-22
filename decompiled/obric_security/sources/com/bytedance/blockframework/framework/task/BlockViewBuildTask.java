package com.bytedance.blockframework.framework.task;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.blockframework.framework.base.BaseBlock;
import com.bytedance.blockframework.framework.base.IUIBlock;
import com.bytedance.blockframework.framework.join.IBlockContext;
import com.bytedance.blockframework.framework.join.IBlockScene;
import com.bytedance.blockframework.framework.monitor.BlockLoggerKt;
import com.bytedance.blockframework.framework.monitor.BlockMonitor;
import com.bytedance.blockframework.framework.monitor.BlockMonitorKt;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlockViewBuildTask.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/bytedance/blockframework/framework/task/BlockViewBuildTask;", "Lcom/bytedance/blockframework/framework/task/Task;", "Landroid/view/View;", "uiBlock", "Lcom/bytedance/blockframework/framework/base/IUIBlock;", "parent", "Landroid/view/ViewGroup;", "result", "Lcom/bytedance/blockframework/framework/task/TaskResult;", "(Lcom/bytedance/blockframework/framework/base/IUIBlock;Landroid/view/ViewGroup;Lcom/bytedance/blockframework/framework/task/TaskResult;)V", "mustMainThread", "", "getMustMainThread", "()Z", "getResult", "()Lcom/bytedance/blockframework/framework/task/TaskResult;", "taskPriority", "", "getTaskPriority", "()I", "getUiBlock", "()Lcom/bytedance/blockframework/framework/base/IUIBlock;", "getBlockScene", "", "run", "", "Companion", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BlockViewBuildTask implements Task<View> {
    public static final Companion Companion = null;
    private static AtomicInteger sAtomViewTypeCreator;
    private final boolean mustMainThread;
    private final ViewGroup parent;
    private final TaskResult<View> result;
    private final int taskPriority;
    private final IUIBlock uiBlock;

    /* JADX INFO: compiled from: BlockViewBuildTask.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/blockframework/framework/task/BlockViewBuildTask$Companion;", "", "()V", "sAtomViewTypeCreator", "Ljava/util/concurrent/atomic/AtomicInteger;", "getSAtomViewTypeCreator", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setSAtomViewTypeCreator", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final AtomicInteger getSAtomViewTypeCreator() {
            return BlockViewBuildTask.access$getSAtomViewTypeCreator$cp();
        }

        public final void setSAtomViewTypeCreator(AtomicInteger r1) {
            Intrinsics.checkNotNullParameter(r1, "<set-?>");
            BlockViewBuildTask.access$setSAtomViewTypeCreator$cp(r1);
        }
    }

    public BlockViewBuildTask(IUIBlock r2, ViewGroup r3, TaskResult<View> r4) {
        Intrinsics.checkNotNullParameter(r2, "uiBlock");
        Intrinsics.checkNotNullParameter(r4, "result");
        this.uiBlock = r2;
        this.parent = r3;
        this.result = r4;
        this.taskPriority = sAtomViewTypeCreator.decrementAndGet();
        this.mustMainThread = r2.getUiConfig().getCreateUIOnMainThread();
    }

    public static final /* synthetic */ AtomicInteger access$getSAtomViewTypeCreator$cp() {
        return sAtomViewTypeCreator;
    }

    public static final /* synthetic */ void access$setSAtomViewTypeCreator$cp(AtomicInteger r0) {
        sAtomViewTypeCreator = r0;
    }

    public final IUIBlock getUiBlock() {
        return this.uiBlock;
    }

    public /* synthetic */ BlockViewBuildTask(IUIBlock r1, ViewGroup r2, TaskResult r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = new TaskResult();
    L5:
        this(r1, r2, r3);
    }

    @Override // com.bytedance.blockframework.framework.task.Task
    public TaskResult<View> getResult() {
        return this.result;
    }

    static {
        Companion = new Companion(null);
        sAtomViewTypeCreator = new AtomicInteger(100);
    }

    @Override // com.bytedance.blockframework.framework.task.Task, com.bytedance.blockframework.framework.task.ScheduleTask
    public int getTaskPriority() {
        return this.taskPriority;
    }

    @Override // com.bytedance.blockframework.framework.task.Task, com.bytedance.blockframework.framework.task.ScheduleTask
    public boolean getMustMainThread() {
        return this.mustMainThread;
    }

    @Override // com.bytedance.blockframework.framework.task.Task, com.bytedance.blockframework.framework.task.ScheduleTask
    public void run() {
        if (this.parent == null) goto L6;
        long r0 = BlockLoggerKt.currentTime();
        BlockMonitor r2 = BlockMonitor.INSTANCE;
        String r3 = getBlockScene();
        Object r4 = this.uiBlock;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.bytedance.blockframework.framework.base.BaseBlock<*, *>");
        BlockMonitor.record$default(r2, r3, ((BaseBlock) r4).getBlockKey(), BlockMonitorKt.TYPE_BLOCK_VIEW_CREATE, "[" + BlockLoggerKt.currentThread().getName() + "] view_create_start", 0, 16, null);
        getResult().setValue(this.uiBlock.onCreateView(this.parent));
        BlockMonitor r5 = BlockMonitor.INSTANCE;
        String r6 = getBlockScene();
        Object r13 = this.uiBlock;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.blockframework.framework.base.BaseBlock<*, *>");
        r5.record(r6, ((BaseBlock) r13).getBlockKey(), BlockMonitorKt.TYPE_BLOCK_VIEW_CREATE, "[" + BlockLoggerKt.currentThread().getName() + "] view_create_end", BlockLoggerKt.currentTime() - r0);
        return;
    }

    public final String getBlockScene() {
        Object r1 = this.uiBlock;
        if ((r1 instanceof BaseBlock) == false) goto L5;
        BaseBlock r2 = (BaseBlock) r1;
    L6:
        if (r2 == null) goto L13;
        IBlockContext r3 = r2.getBlockContext();
        if (r3 == null) goto L13;
        IBlockScene r4 = r3.getScene();
        if (r4 == null) goto L13;
        String r5 = r4.getName();
        if (r5 == null) goto L13;
        return r5;
    L13:
        return "";
    L5:
        r2 = null;
        goto L6
    }
}
