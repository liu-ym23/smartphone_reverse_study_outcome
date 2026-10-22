package com.bytedance.monitor.util.thread;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class AsyncTaskUtil {
    public AsyncTaskUtil() {
    }

    public static IAsyncTaskManager getAsyncTaskManagerInstance() {
        return AsyncTaskManager.getInstance();
    }

    public static String getTaskInfo(TaskRunnable r2) {
        if (r2 != null) goto L6;
        return "null";
    L6:
        return r2.getTaskName() + ", " + r2.getTaskType();
    }

    public static void logd(ThreadLogListener r3, String r4, String r5) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isDebug() == false) goto L8;
        String r0 = Thread.currentThread().getName();
        Locale r1 = Locale.CHINA;
        r3.onLog(r4, "[callerThread: " + r0 + "] \n " + r5);
        return;
    }

    public static void loge(ThreadLogListener r3, String r4, String r5) {
        if (r3 == null) goto L5;
        String r0 = Thread.currentThread().getName();
        Locale r1 = Locale.CHINA;
        r3.onError(r4, "[callerThread: " + r0 + "] \n " + r5);
        return;
    }

    public static TaskRunnable wrapIOTask(String r1, Runnable r2) {
        return wrapRunnable(AsyncTaskType.IO, r1, r2);
    }

    public static TaskRunnable wrapLightWeightTask(String r1, Runnable r2) {
        return wrapRunnable(AsyncTaskType.LIGHT_WEIGHT, r1, r2);
    }

    public static TaskRunnable wrapLightWeightTaskNoName(Runnable r2) {
        return wrapRunnable(AsyncTaskType.LIGHT_WEIGHT, "no-name", r2);
    }

    public static TaskRunnable wrapRunnable(final AsyncTaskType r1, final String r2, final Runnable r3) {
        return new AnonymousClass1(r2, r1, r3);
    }

    public static TaskRunnable wrapTimeSensitiveTask(String r1, Runnable r2) {
        return wrapRunnable(AsyncTaskType.TIME_SENSITIVE, r1, r2);
    }
}
