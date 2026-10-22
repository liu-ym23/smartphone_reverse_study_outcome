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

    public static LogQueue getInstance(Context r2) {
        if (sLogQueue != null) goto L16;
        monitor-enter(LogQueue.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sLogQueue != null) goto L11;
        sLogQueue = new LogQueue(r2);     // Catch: Throwable -> L9
    L11:
        monitor-exit(LogQueue.class);     // Catch: Throwable -> L9
    L16:
        return sLogQueue;
    }

    public static void log(String r0) {
    }

    public static void quit() {
        monitor-enter(LogQueue.class);
        LogQueue r1 = sLogQueue;     // Catch: Throwable -> L7
        if (r1 == null) goto L9;
        r1.stop();     // Catch: Throwable -> L7
    L9:
        monitor-exit(LogQueue.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean enqueue(String r4, byte[] r5) {
        if (isStop() == true) goto L27;
        if (r5 == null) goto L27;
        if (r5.length <= 0) goto L27;
        if (getLogHandler(r4) != null) goto L11;
        return false;
    L11:
        LinkedList<LogItem> r0 = this.mPendingQueue;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L14:
        if (this.mStopFlag.get() == false) goto L20;
        monitor-exit(r0);     // Catch: Throwable -> L17
        return false;
    L20:
        if (this.mPendingQueue.size() < 2000) goto L22;
        this.mPendingQueue.poll();     // Catch: Throwable -> L17
    L22:
        boolean r6 = this.mPendingQueue.add(new LogItem(r4, r5));     // Catch: Throwable -> L17
        this.mLogSender.awaken();     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return r6;
    L27:
        return false;
    }

    public Map<String, LogHandler> getAllLogHandler() {
        return this.mLogHandlers;
    }

    public LogHandler getLogHandler(String r1) {
        return this.mLogHandlers.get(r1);
    }

    public boolean isStop() {
        return this.mStopFlag.get();
    }

    public void registerLogHandler(String r2, LogHandler r3) {
        if (isStop() == true) goto L8;
        if (r3 == null) goto L9;
        this.mLogHandlers.put(r2, r3);
        return;
    L9:
        return;
    }

    public void stop() {
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

    public void unregisterLogHandler(LogHandler r2) {
        if (isStop() == true) goto L8;
        if (r2 == null) goto L9;
        this.mLogHandlers.remove(r2.getType());
        return;
    L9:
        return;
    }

    public static void log(String r0, String r1) {
    }
}
