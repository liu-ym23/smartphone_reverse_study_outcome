package com.bytedance.frameworks.baselib.network.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class PlatformHandlerThread {
    private static final String BACKGROUND_THREAD_NAME = "back_handler_thread";
    private static final String DEFAULT_THREAD_NAME = "common_handler_thread";
    private static final String MARK = "\u200b";
    private static final String TAG = "PlatformHandlerThread";
    private static volatile Handler backgroundHandler;
    private static volatile HandlerThread backgroundHandlerThread;
    private static volatile Handler defaultHandler;
    private static volatile HandlerThread defaultHandlerThread;
    private static volatile Handler defaultMainHandler;
    private static Map<String, String> groupMap;
    private static HashMap<String, HandlerThread> handlerThreads;
    private static List<String> normalList;
    private static List<String> whiteList;

    public static class InnerHandlerThread extends HandlerThread {
        private volatile boolean isStart;

        public InnerHandlerThread(String r1) {
            super(r1);
            this.isStart = false;
        }

        public InnerHandlerThread(String r1, int r2) {
            super(r1, r2);
            this.isStart = false;
        }

        @Override // java.lang.Thread
        public synchronized void start() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.isStart == false) goto L8;
            monitor-exit(this);
            return;
        L8:
            this.isStart = true;     // Catch: Throwable -> L11
            super.start();     // Catch: Throwable -> L11
            monitor-exit(this);
        }
    }

    public PlatformHandlerThread() {
    }

    static {
        defaultMainHandler = new Handler(Looper.getMainLooper());
        handlerThreads = new HashMap();
        whiteList = Arrays.asList(new String[]{"NpthHandlerThread", "NewVideo-HandlerThread", "trace_time_update_thread"});
        normalList = Arrays.asList(new String[]{"DBHelper-AsyncOp-New"});
        groupMap = new HashMap();
    }

    public static Handler getDefaultMainHandler() {
        return defaultMainHandler;
    }

    public static Handler getDefaultHandler() {
        monitor-enter(PlatformHandlerThread.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (defaultHandler != null) goto L7;
        getDefaultHandlerThread();     // Catch: Throwable -> L10
    L7:
        Handler r1 = defaultHandler;     // Catch: Throwable -> L10
        monitor-exit(PlatformHandlerThread.class);     // Catch: Throwable -> L10
        return r1;
    }

    public static HandlerThread getDefaultHandlerThread() {
        monitor-enter(PlatformHandlerThread.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (defaultHandlerThread != null) goto L7;
        defaultHandlerThread = new InnerHandlerThread(DEFAULT_THREAD_NAME);     // Catch: Throwable -> L10
        defaultHandlerThread.start();     // Catch: Throwable -> L10
        defaultHandler = new Handler(defaultHandlerThread.getLooper());     // Catch: Throwable -> L10
    L7:
        HandlerThread r1 = defaultHandlerThread;     // Catch: Throwable -> L10
        monitor-exit(PlatformHandlerThread.class);     // Catch: Throwable -> L10
        return r1;
    }

    public static Handler getBackgroundHandler() {
        monitor-enter(PlatformHandlerThread.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (backgroundHandler != null) goto L7;
        getBackgroundHandlerThread();     // Catch: Throwable -> L10
    L7:
        Handler r1 = backgroundHandler;     // Catch: Throwable -> L10
        monitor-exit(PlatformHandlerThread.class);     // Catch: Throwable -> L10
        return r1;
    }

    public static HandlerThread getBackgroundHandlerThread() {
        monitor-enter(PlatformHandlerThread.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (backgroundHandlerThread != null) goto L7;
        backgroundHandlerThread = new InnerHandlerThread(BACKGROUND_THREAD_NAME, 10);     // Catch: Throwable -> L10
        backgroundHandlerThread.start();     // Catch: Throwable -> L10
        backgroundHandler = new Handler(backgroundHandlerThread.getLooper());     // Catch: Throwable -> L10
    L7:
        HandlerThread r1 = backgroundHandlerThread;     // Catch: Throwable -> L10
        monitor-exit(PlatformHandlerThread.class);     // Catch: Throwable -> L10
        return r1;
    }

    public static HandlerThread getNewHandlerThread(String r2) {
        return getNewHandlerThread(r2, 0, "");
    }

    public static HandlerThread getNewHandlerThread(String r1, String r2) {
        return getNewHandlerThread(r1, 0, r2);
    }

    public static HandlerThread getNewHandlerThread(String r1, int r2, String r3) {
        Iterator<Map.Entry<String, HandlerThread>> r4 = handlerThreads.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        if (r4.next().getValue().isAlive() == true) goto L4;
        r4.remove();
        goto L4
    L8:
        HandlerThread r5 = handlerThreads.get(r1);
        if (r5 != null) goto L17;
        InnerHandlerThread r6 = new InnerHandlerThread(r1, r2);
        r6.start();
        handlerThreads.put(r1, r6);
        return r6;
    L17:
        return r5;
    }

    private static String getNameByCommonPackage(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == true) goto L11;
        String[] r4 = r2.split(LibrarianImpl.Constants.SEPARATOR);
        if (r4.length < 4) goto L14;
        String r5 = r4[0] + r4[1] + r4[2] + r4[3];
        String r0 = groupMap.get(r5);
        if (TextUtils.isEmpty(r0) == false) goto L10;
        groupMap.put(r5, r3);
        return r3;
    L10:
        return r0;
    L14:
        return "platform_handler";
    L11:
        return "platform_handler";
    }
}
