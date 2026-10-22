package com.bytedance.monitor.util.thread;

/* JADX INFO: loaded from: classes3.dex */
public interface TaskRunnable extends Runnable {
    String getTaskName();

    AsyncTaskType getTaskType();
}
