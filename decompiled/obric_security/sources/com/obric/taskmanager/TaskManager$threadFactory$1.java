package com.obric.taskmanager;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TaskManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"com/obric/taskmanager/TaskManager$threadFactory$1", "Ljava/util/concurrent/ThreadFactory;", "group", "Ljava/lang/ThreadGroup;", "namePrefix", "", "threadNumber", "Ljava/util/concurrent/atomic/AtomicInteger;", "newThread", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TaskManager$threadFactory$1 implements ThreadFactory {
    private final ThreadGroup group;
    private final String namePrefix;
    final /* synthetic */ TaskManager this$0;
    private final AtomicInteger threadNumber;

    public static /* synthetic */ void $r8$lambda$BMZJRTX5ZlcWFjjCanGCj7DC3jo(TaskManager r0, Thread r1, Throwable r2) {
        newThread$lambda$1$lambda$0(r0, r1, r2);
    }

    TaskManager$threadFactory$1(TaskManager r2) {
        this.this$0 = r2;
        this.group = new ThreadGroup("TaskManagerGroup");
        this.threadNumber = new AtomicInteger(1);
        this.namePrefix = "task-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r8) {
        Intrinsics.checkNotNullParameter(r8, "r");
        Thread r0 = new Thread(this.group, r8, this.namePrefix + this.threadNumber.getAndIncrement(), 0);
        final TaskManager r7 = this.this$0;
        r0.setUncaughtExceptionHandler(new TaskManager$threadFactory$1$$ExternalSyntheticLambda0(r7));
        return r0;
    }

    private static final void newThread$lambda$1$lambda$0(TaskManager r3, Thread r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        TaskManager.access$log(r3, "线程 " + r4.getName() + " 异常终止: " + r5.getMessage(), r5);
        TaskManager.access$getFailedTasks$p(r3).incrementAndGet();
        TaskManager.access$getActiveTasks$p(r3).decrementAndGet();
    }
}
