package com.bytedance.sliver;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class SliverAllThreadSupport {
    static final int SLIVER_GROUP_CACHE_SIZE = 50000;
    private static final int SUPPORT_API_MAX = 31;
    private static final int SUPPORT_API_MIN = 21;
    private static Sliver.ThreadFilter filter;
    private static volatile boolean isRunning;
    private static volatile boolean isStart;
    private static final Thread mainThread = null;
    private static int samplingRateMs;
    private static ThreadGroup systemThreadGroup;
    private static final List<SliverGroup> threadGroups = null;
    private static Handler threadHandler;

    private static class SliverGroup {
        private final int cacheSize;
        private volatile boolean change;
        private final int index;
        private final Sliver.Mode mode;
        private volatile long peer;
        private final int samplingRateMs;
        private final HashSet<Thread> threads;

        SliverGroup(int r3, int r4, int r5, Sliver.Mode r6) {
            this.peer = 0;
            this.change = false;
            this.index = r3;
            this.samplingRateMs = r4;
            this.threads = new HashSet();
            this.cacheSize = r5;
            this.mode = r6;
        }

        synchronized void add(Thread r2) {
            monitor-enter(this);
            this.threads.add(r2);     // Catch: Throwable -> L6
            this.change = true;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized boolean remove(Thread r3) {
            monitor-enter(this);
        L15:
            th = move-exception;
            throw th;
        L5:
            if (this.threads.isEmpty() == false) goto L9;
            monitor-exit(this);
            return false;
        L9:
            if (this.threads.remove(r3) == false) goto L13;
            this.change = true;     // Catch: Throwable -> L15
            monitor-exit(this);
            return true;
        L13:
            monitor-exit(this);
            return false;
        }

        synchronized void notifyThread() {
            monitor-enter(this);
            start();     // Catch: Throwable -> L26
            if (this.peer != 0) goto L9;
            monitor-exit(this);
            return;
        L9:
            if (this.change == true) goto L12;
            monitor-exit(this);
            return;
        L12:
            ArrayList r0 = new ArrayList(this.threads.size());     // Catch: Throwable -> L26
            ArrayList r1 = new ArrayList(this.threads.size());     // Catch: Throwable -> L26
            Iterator<Thread> r4 = this.threads.iterator();     // Catch: Throwable -> L26
        L14:
            if (r4.hasNext() == false) goto L19;
            Thread r5 = r4.next();     // Catch: Throwable -> L26
            long r6 = Sliver.getThreadPeer(r5);     // Catch: Throwable -> L26
            if (r6 == 0) goto L14;
            r0.add(Long.valueOf(r6));     // Catch: Throwable -> L26
            r1.add(r5);     // Catch: Throwable -> L26
            goto L14
        L19:
            long[] r2 = new long[r0.size()];     // Catch: Throwable -> L26
            int r7 = 0;
        L21:
            if (r7 >= r0.size()) goto L23;
            r2[r7] = ((Long) r0.get(r7)).longValue();     // Catch: Throwable -> L26
            r7 = r7 + 1;     // Catch: Throwable -> L26
            goto L21
        L23:
            SliverAllThreadSupport.access$500(this.peer, (Thread[]) r1.toArray(new Thread[0]), r2);     // Catch: Throwable -> L26
            this.change = false;     // Catch: Throwable -> L26
            monitor-exit(this);
            return;
        L26:
            th = move-exception;
            throw th;
        }

        synchronized void start() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.peer == 0) goto L8;
            monitor-exit(this);
            return;
        L8:
            this.peer = SliverAllThreadSupport.access$600(this.samplingRateMs, this.cacheSize, Sliver.mode2Int(this.mode), this.index);     // Catch: Throwable -> L11
            monitor-exit(this);
        }

        synchronized void stop() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.peer != 0) goto L8;
            monitor-exit(this);
            return;
        L8:
            SliverAllThreadSupport.access$700(this.peer);     // Catch: Throwable -> L11
            monitor-exit(this);
        }

        synchronized void dumpHeader(String r7) {
            monitor-enter(this);
            BufferedWriter r0 = null;
            BufferedWriter r1 = new BufferedWriter(new FileWriter(r7, true));     // Catch: Throwable -> L24
            Iterator<Thread> r8 = this.threads.iterator();     // Catch: Throwable -> L14
        L7:
            if (r8.hasNext() == false) goto L12;
            Thread r2 = r8.next();     // Catch: Throwable -> L14
            long r3 = Sliver.getThreadPeer(r2);     // Catch: Throwable -> L14
            if (r3 == 0) goto L7;
            r1.write("# thread_info:" + SliverAllThreadSupport.access$800(r3) + ":" + r2.getName() + "\n");     // Catch: Throwable -> L14
            goto L7
        L12:
            r1.flush();     // Catch: Throwable -> L14
            r1.close();     // Catch: Throwable -> L18 IOException -> L23
        L29:
        L14:
            r0 = r1;
        L15:
            if (r0 == null) goto L21;
            r0.close();     // Catch: Throwable -> L18 IOException -> L23
        L18:
            th = move-exception;
            throw th;
        L21:
            monitor-exit(this);
        }

        synchronized int getThreadNum() {
            monitor-enter(this);
            int r0 = this.threads.size();     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized void dump(String r3) {
            monitor-enter(this);
            SliverAllThreadSupport.access$900(this.peer, r3);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized void pause() {
            monitor-enter(this);
            SliverAllThreadSupport.access$1000(this.peer);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized void resume() {
            monitor-enter(this);
            SliverAllThreadSupport.access$1100(this.peer);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized void clear() {
            monitor-enter(this);
            SliverAllThreadSupport.access$1200(this.peer);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    private static class SliverThreadMonitor implements Runnable {
        private List<Thread> preThreads;
        private final int samplingRateMs;

        public SliverThreadMonitor(int r1) {
            this.samplingRateMs = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<Thread> r0 = SliverAllThreadSupport.access$200();
            if (this.preThreads != null) goto L5;
            onNewThread(r0);
        L18:
            this.preThreads = r0;
            notifyThreadGroup();
            SliverAllThreadSupport.access$300().postDelayed(this, this.samplingRateMs);
            return;
        L5:
            ArrayList r1 = new ArrayList();
            ArrayList r2 = new ArrayList();
            Iterator<Thread> r3 = r0.iterator();
        L7:
            if (r3.hasNext() == false) goto L11;
            Thread r4 = r3.next();
            if (this.preThreads.contains(r4) == true) goto L7;
            r1.add(r4);
            goto L7
        L11:
            Iterator<Thread> r5 = this.preThreads.iterator();
        L13:
            if (r5.hasNext() == false) goto L17;
            Thread r6 = r5.next();
            if (r0.contains(r6) == true) goto L13;
            r2.add(r6);
            goto L13
        L17:
            onDeleteThread(r2);
            onNewThread(r1);
            goto L18
        }

        private void notifyThreadGroup() {
            Iterator r1 = SliverAllThreadSupport.access$100().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ((SliverGroup) r1.next()).notifyThread();
            goto L4
        }

        private void onDeleteThread(List<Thread> r3) {
            Iterator<Thread> r2 = r3.iterator();
        L4:
            if (r2.hasNext() == false) goto L12;
            Thread r4 = r2.next();
            int r0 = 1;
        L7:
            if (r0 >= SliverAllThreadSupport.access$100().size()) goto L4;
            if (((SliverGroup) SliverAllThreadSupport.access$100().get(r0)).remove(r4) == true) goto L4;
            r0 = r0 + 1;
            goto L7
        }

        private void onNewThread(List<Thread> r6) {
            int r5 = r6.size();
            int r0 = 0;
        L3:
            int r2 = 1;
        L4:
            if (r0 >= r5) goto L13;
            if (SliverAllThreadSupport.access$400() == null) goto L10;
            if (SliverAllThreadSupport.access$400().traceEnable(r6.get(r0)) == true) goto L10;
            r0 = r0 + 1;
        L10:
            ((SliverGroup) SliverAllThreadSupport.access$100().get(r2)).add(r6.get(r0));
            r0 = r0 + 1;
            r2 = r2 + 1;
            if (r2 < SliverAllThreadSupport.access$100().size()) goto L4;
        }
    }

    private static native void nClearSliverGroup(long r0);

    private static native void nDumpSliverGroup(long r0, String r2);

    private static native int nGetThreadId(long r0);

    private static native void nNotifySliverGroup(long r0, Thread[] r2, long[] r3);

    private static native void nPauseSliverGroup(long r0);

    private static native void nResumeSliverGroup(long r0);

    private static native long nStartSliverGroup(int r0, int r1, int r2, int r3);

    private static native void nStopSliverGroup(long r0);

    static boolean startAll(int r0, int r1, int r2, Sliver.Mode r3, Sliver.ThreadFilter r4) {
        return false;
    }

    SliverAllThreadSupport() {
    }

    static /* synthetic */ boolean access$000(String r0) {
        return dumpHeader(r0);
    }

    static /* synthetic */ List access$100() {
        return threadGroups;
    }

    static /* synthetic */ void access$1000(long r0) {
        nPauseSliverGroup(r0);
    }

    static /* synthetic */ void access$1100(long r0) {
        nResumeSliverGroup(r0);
    }

    static /* synthetic */ void access$1200(long r0) {
        nClearSliverGroup(r0);
    }

    static /* synthetic */ List access$200() {
        return getAllThread();
    }

    static /* synthetic */ Handler access$300() {
        return newThreadHandler();
    }

    static /* synthetic */ Sliver.ThreadFilter access$400() {
        return filter;
    }

    static /* synthetic */ void access$500(long r0, Thread[] r2, long[] r3) {
        nNotifySliverGroup(r0, r2, r3);
    }

    static /* synthetic */ long access$600(int r0, int r1, int r2, int r3) {
        return nStartSliverGroup(r0, r1, r2, r3);
    }

    static /* synthetic */ void access$700(long r0) {
        nStopSliverGroup(r0);
    }

    static /* synthetic */ int access$800(long r0) {
        return nGetThreadId(r0);
    }

    static /* synthetic */ void access$900(long r0, String r2) {
        nDumpSliverGroup(r0, r2);
    }

    static {
        threadGroups = new LinkedList();
        mainThread = Looper.getMainLooper().getThread();
        isStart = false;
        isRunning = false;
        samplingRateMs = 10;
        filter = null;
        threadHandler = null;
        systemThreadGroup = null;
    }

    static boolean isStart() {
        return isStart;
    }

    static boolean stopAll() {
        if (isStart == true) goto L5;
        return false;
    L5:
        Iterator<SliverGroup> r0 = threadGroups.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        r0.next().stop();
        goto L7
    L9:
        threadGroups.clear();
        deleteThreadHandler();
        isStart = false;
        isRunning = false;
        return true;
    }

    static boolean dumpAll(final String r1, boolean r2) {
        if (isStart == true) goto L6;
        return false;
    L6:
        Runnable r0 = new AnonymousClass1(r1);
        if (r2 == false) goto L9;
        r0.run();
        return true;
    L9:
        newThreadHandler().post(r0);
        return true;
    }

    static boolean pauseAll() {
        if (isStart == true) goto L6;
        return false;
    L6:
        if (isRunning == true) goto L8;
        return false;
    L8:
        Iterator<SliverGroup> r0 = threadGroups.iterator();
    L10:
        if (r0.hasNext() == false) goto L12;
        r0.next().pause();
        goto L10
    L12:
        deleteThreadHandler();
        isRunning = false;
        return true;
    }

    static boolean resumeAll() {
        if (isStart == true) goto L6;
        return false;
    L6:
        if (isRunning == false) goto L8;
        return false;
    L8:
        Iterator<SliverGroup> r0 = threadGroups.iterator();
    L10:
        if (r0.hasNext() == false) goto L12;
        r0.next().resume();
        goto L10
    L12:
        newThreadHandler().post(new SliverThreadMonitor(samplingRateMs));
        isRunning = true;
        return true;
    }

    static boolean clearAll() {
        if (isStart == true) goto L6;
        return false;
    L6:
        Iterator<SliverGroup> r0 = threadGroups.iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        r0.next().clear();
        goto L8
    L10:
        return true;
    }

    private static boolean dumpHeader(String r4) {
        BufferedWriter r1 = null;
        BufferedWriter r2 = new BufferedWriter(new FileWriter(r4));     // Catch: Throwable -> L14
        r2.write("# sliver\n");     // Catch: Throwable -> L8
        r2.write("# pid:" + Process.myPid() + "\n");     // Catch: Throwable -> L8
        r2.flush();     // Catch: Throwable -> L8
        r2.close();     // Catch: IOException -> L13
        return true;
    L24:
        return true;
    L8:
        r1 = r2;
    L9:
        if (r1 == null) goto L25;
        r1.close();     // Catch: IOException -> L15
        return false;
    L26:
        return false;
    L25:
        return false;
    }

    private static synchronized Handler newThreadHandler() {
        monitor-enter(SliverAllThreadSupport.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (threadHandler != null) goto L7;
        HandlerThread r1 = new HandlerThread("sliver_check_thread");     // Catch: Throwable -> L10
        r1.start();     // Catch: Throwable -> L10
        threadHandler = new Handler(r1.getLooper());     // Catch: Throwable -> L10
    L7:
        Handler r2 = threadHandler;     // Catch: Throwable -> L10
        monitor-exit(SliverAllThreadSupport.class);
        return r2;
    }

    private static synchronized void deleteThreadHandler() {
        monitor-enter(SliverAllThreadSupport.class);
        Handler r1 = threadHandler;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.removeCallbacksAndMessages(null);     // Catch: Throwable -> L9
        threadHandler.getLooper().quitSafely();     // Catch: Throwable -> L9
        threadHandler = null;     // Catch: Throwable -> L9
    L7:
        monitor-exit(SliverAllThreadSupport.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private static boolean initSystemThreadGroup() {
        if (systemThreadGroup != null) goto L7;
        Field r1 = ThreadGroup.class.getDeclaredField("systemThreadGroup");     // Catch: Throwable -> L11
        r1.setAccessible(true);     // Catch: Throwable -> L11
        systemThreadGroup = (ThreadGroup) r1.get(null);     // Catch: Throwable -> L11
    L7:
        if (systemThreadGroup != null) goto L14;
        return false;
    L14:
        return true;
    }

    private static List<Thread> getAllThread() {
        int r0 = systemThreadGroup.activeCount();
        Thread[] r1 = new Thread[r0 + (r0 / 2)];
        int r2 = systemThreadGroup.enumerate(r1);
        ArrayList r3 = new ArrayList(r2);
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L12;
        Thread r5 = r1[r4];
        if (r5 == mainThread) goto L11;
        if (r5.getName().contains("sliver") == true) goto L11;
        r3.add(r1[r4]);
    L11:
        r4 = r4 + 1;
        goto L3
    L12:
        return r3;
    }
}
