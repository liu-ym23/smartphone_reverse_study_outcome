package com.bytedance.monitor.util.thread.inner;

import com.bytedance.monitor.util.thread.TaskRunnable;
import com.bytedance.monitor.util.thread.ThreadLogListener;

/* JADX INFO: loaded from: classes.dex */
public interface IAsyncTaskHandler {
    boolean isPending(TaskRunnable r1);

    void post(TaskRunnable r1);

    void postDelayed(TaskRunnable r1, long r2);

    void release();

    void removeTask(TaskRunnable r1);

    void scheduleWithFixedDelay(TaskRunnable r1, long r2, long r4);

    void setThreadLogListener(ThreadLogListener r1);
}
