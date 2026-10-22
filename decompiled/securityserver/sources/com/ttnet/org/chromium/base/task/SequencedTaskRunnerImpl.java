package com.ttnet.org.chromium.base.task;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class SequencedTaskRunnerImpl extends TaskRunnerImpl implements SequencedTaskRunner {
    private AtomicInteger mPendingTasks;
    private volatile boolean mReadyToCreateNativeTaskRunner;

    public SequencedTaskRunnerImpl(TaskTraits r3) {
        super(r3, "SequencedTaskRunnerImpl", 1);
        this.mPendingTasks = new AtomicInteger();
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunnerImpl
    public void initNativeTaskRunner() {
        this.mReadyToCreateNativeTaskRunner = true;
        if (this.mPendingTasks.getAndIncrement() != 0) goto L6;
        super.initNativeTaskRunner();
        return;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunnerImpl
    public void runPreNativeTask() {
        super.runPreNativeTask();
        if (this.mPendingTasks.decrementAndGet() > 0) goto L5;
        return;
    L5:
        if (this.mReadyToCreateNativeTaskRunner == true) goto L7;
        super.schedulePreNativeTask();
        return;
    L7:
        super.initNativeTaskRunner();
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunnerImpl
    public void schedulePreNativeTask() {
        if (this.mPendingTasks.getAndIncrement() != 0) goto L6;
        super.schedulePreNativeTask();
        return;
    }
}
