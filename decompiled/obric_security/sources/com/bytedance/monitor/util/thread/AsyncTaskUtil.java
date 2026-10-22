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

    public static TaskRunnable wrapLightWeightTask(String r1, Runnable r2) {
        return wrapRunnable(AsyncTaskType.LIGHT_WEIGHT, r1, r2);
    }

    public static TaskRunnable wrapLightWeightTaskNoName(Runnable r2) {
        return wrapRunnable(AsyncTaskType.LIGHT_WEIGHT, "no-name", r2);
    }

    public static TaskRunnable wrapIOTask(String r1, Runnable r2) {
        return wrapRunnable(AsyncTaskType.IO, r1, r2);
    }

    public static TaskRunnable wrapTimeSensitiveTask(String r1, Runnable r2) {
        return wrapRunnable(AsyncTaskType.TIME_SENSITIVE, r1, r2);
    }

    public static TaskRunnable wrapRunnable(final AsyncTaskType r1, final String r2, final Runnable r3) {
        return new AnonymousClass1(r2, r1, r3);
    }

    public static void logd(ThreadLogListener r4, String r5, String r6) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.isDebug() == false) goto L8;
        String r0 = Thread.currentThread().getName();
        r4.onLog(r5, String.format(Locale.CHINA, "[callerThread: %s] \n %s", new Object[]{r0, r6}));
        return;
    }

    public static void loge(ThreadLogListener r4, String r5, String r6) {
        if (r4 == null) goto L5;
        String r0 = Thread.currentThread().getName();
        r4.onError(r5, String.format(Locale.CHINA, "[callerThread: %s] \n %s", new Object[]{r0, r6}));
        return;
    }
}
