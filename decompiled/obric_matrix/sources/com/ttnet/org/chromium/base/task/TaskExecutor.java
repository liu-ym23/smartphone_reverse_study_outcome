package com.ttnet.org.chromium.base.task;

/* JADX INFO: loaded from: classes2.dex */
public interface TaskExecutor {
    boolean canRunTaskImmediately(TaskTraits r1);

    SequencedTaskRunner createSequencedTaskRunner(TaskTraits r1);

    SingleThreadTaskRunner createSingleThreadTaskRunner(TaskTraits r1);

    TaskRunner createTaskRunner(TaskTraits r1);

    void postDelayedTask(TaskTraits r1, Runnable r2, long r3);
}
