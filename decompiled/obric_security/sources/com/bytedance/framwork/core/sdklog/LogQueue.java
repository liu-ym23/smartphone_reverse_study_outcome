package com.bytedance.framwork.core.sdklog;

import android.content.Context;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class LogQueue {
    static final boolean DEBUG = false;
    private static final int MAX_QUEUE_SIZE = 2000;
    static final String TAG = "LogQueue";
    private static LogQueue sLogQueue;
    private final Context mContext;
    private final Map<String, LogHandler> mLogHandlers;
    private final LogSender mLogSender;
    private final LinkedList<LogItem> mPendingQueue;
    private final AtomicBoolean mStopFlag;

    static void log(String r0) {
    }

    static void log(String r0, String r1) {
    }

    public static LogQueue getInstance(Context r2) {
        if (sLogQueue != null) goto L15;
        monitor-enter(LogQueue.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sLogQueue != null) goto L9;
        sLogQueue = new LogQueue(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(LogQueue.class);     // Catch: Throwable -> L11
    L15:
        return sLogQueue;
    }

    public static void quit() {
        monitor-enter(LogQueue.class);
        LogQueue r1 = sLogQueue;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.stop();     // Catch: Throwable -> L9
    L7:
        monitor-exit(LogQueue.class);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private LogQueue(Context r4) {
        AtomicBoolean r0 = new AtomicBoolean(false);
        this.mStopFlag = r0;
        LinkedList<LogItem> r1 = new LinkedList();
        this.mPendingQueue = r1;
        Context r5 = r4.getApplicationContext();
        this.mContext = r5;
        this.mLogHandlers = new ConcurrentHashMap();
        LogSender r2 = new LogSender(r5, this, r1, r0);
        this.mLogSender = r2;
        r2.start();
    }

    public void registerLogHandler(String r2, LogHandler r3) {
        if (isStop() == true) goto L8;
        if (r3 == null) goto L9;
        this.mLogHandlers.put(r2, r3);
        return;
    L9:
        return;
    }

    public void unregisterLogHandler(LogHandler r2) {
        if (isStop() == true) goto L8;
        if (r2 == null) goto L9;
        this.mLogHandlers.remove(r2.getType());
        return;
    L9:
        return;
    }

    LogHandler getLogHandler(String r1) {
        return this.mLogHandlers.get(r1);
    }

    Map<String, LogHandler> getAllLogHandler() {
        return this.mLogHandlers;
    }

    boolean enqueue(String r4, byte[] r5) {
        if (isStop() == true) goto L26;
        if (r5 == null) goto L26;
        if (r5.length <= 0) goto L26;
        if (getLogHandler(r4) != null) goto L11;
        return false;
    L11:
        LinkedList<LogItem> r0 = this.mPendingQueue;
        monitor-enter(r0);
    L23:
        th = move-exception;
        throw th;
    L14:
        if (this.mStopFlag.get() == false) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L23
        return false;
    L18:
        if (this.mPendingQueue.size() < 2000) goto L20;
        this.mPendingQueue.poll();     // Catch: Throwable -> L23
    L20:
        boolean r6 = this.mPendingQueue.add(new LogItem(r4, r5));     // Catch: Throwable -> L23
        this.mLogSender.awaken();     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        return r6;
    L26:
        return false;
    }

    boolean isStop() {
        return this.mStopFlag.get();
    }

    void stop() {
        LinkedList<LogItem> r0 = this.mPendingQueue;
        monitor-enter(r0);
        this.mPendingQueue.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mStopFlag.set(true);
        this.mLogSender.quit();
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
