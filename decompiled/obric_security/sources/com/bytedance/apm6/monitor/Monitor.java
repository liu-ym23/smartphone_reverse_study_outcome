package com.bytedance.apm6.monitor;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedTransferQueue;

/* JADX INFO: loaded from: classes.dex */
public class Monitor {
    private static final String LOG_TAG = "APM-Monitor";
    private static final String THREAD_NAME = "APM-Monitor";
    private static List<MonitorableHandler> handlers;
    private static volatile boolean isWorking;
    private static final BlockingQueue<Monitorable> queue = null;

    public Monitor() {
    }

    static /* synthetic */ BlockingQueue access$000() {
        return queue;
    }

    static /* synthetic */ List access$100() {
        return handlers;
    }

    static {
        handlers = new CopyOnWriteArrayList();
        queue = new LinkedTransferQueue();
        isWorking = false;
    }

    public static void registerHandler(MonitorableHandler r1) {
        if (handlers.contains(r1) == true) goto L6;
        handlers.add(r1);
        return;
    }

    public static void record(Monitorable r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        queue.offer(r1);
        if (isWorking == true) goto L8;
        startWork();
        return;
    }

    private static synchronized void startWork() {
        monitor-enter(Monitor.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (isWorking == false) goto L9;
        monitor-exit(Monitor.class);
        return;
    L9:
        isWorking = true;     // Catch: Throwable -> L12
        new Thread(new AnonymousClass1(), "APM-Monitor").start();     // Catch: Throwable -> L12
        monitor-exit(Monitor.class);
    }
}
