package com.bytedance.sliver;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import androidx.annotation.Keep;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Keep
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

    public static class SliverGroup {
    }

    public static class SliverThreadMonitor implements Runnable {
        public final int b;
        public List c;

        public SliverThreadMonitor(int r1) {
            this.b = r1;
        }

        public static void a(List r4) {
            int r0 = r4.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L16;
            if (SliverAllThreadSupport.access$400() == null) goto L9;
            Sliver.ThreadFilter r2 = SliverAllThreadSupport.access$400();
            Thread r3 = (Thread) r4.get(r1);
            if (r2.a() == true) goto L9;
            r1 = r1 + 1;
        L9:
            SliverGroup r5 = (SliverGroup) SliverAllThreadSupport.access$100().get(1);
            Thread r6 = (Thread) r4.get(r1);
            monitor-enter(r5);
            throw null;     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            List r0 = SliverAllThreadSupport.access$200();
            if (this.c != null) goto L5;
            a(r0);
        L30:
            this.c = r0;
            Iterator r1 = SliverAllThreadSupport.access$100().iterator();
            if (r1.hasNext() == true) goto L34;
            SliverAllThreadSupport.access$300().postDelayed(this, this.b);
            return;
        L34:
            SliverGroup r7 = (SliverGroup) r1.next();
            monitor-enter(r7);
            monitor-enter(r7);     // Catch: Throwable -> L43
            throw null;     // Catch: Throwable -> L38
        L38:
            th = move-exception;
            throw th;     // Catch: Throwable -> L43
        L43:
            th = move-exception;
            throw th;
        L5:
            ArrayList r2 = new ArrayList();
            ArrayList r3 = new ArrayList();
            Iterator r4 = r0.iterator();
        L7:
            if (r4.hasNext() == false) goto L11;
            Thread r5 = (Thread) r4.next();
            if (this.c.contains(r5) == true) goto L7;
            r2.add(r5);
            goto L7
        L11:
            Iterator r6 = this.c.iterator();
        L13:
            if (r6.hasNext() == false) goto L17;
            Thread r8 = (Thread) r6.next();
            if (r0.contains(r8) == true) goto L13;
            r3.add(r8);
            goto L13
        L17:
            Iterator r9 = r3.iterator();
        L19:
            if (r9.hasNext() == false) goto L29;
            Thread r10 = (Thread) r9.next();
            if (1 >= SliverAllThreadSupport.access$100().size()) goto L19;
            monitor-enter(((SliverGroup) SliverAllThreadSupport.access$100().get(1)));
            throw null;     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            throw th;
        L29:
            a(r2);
            goto L30
        }
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

    public SliverAllThreadSupport() {
    }

    public static /* synthetic */ boolean access$000(String r0) {
        return dumpHeader(r0);
    }

    public static /* synthetic */ List access$100() {
        return threadGroups;
    }

    public static /* synthetic */ void access$1000(long r0) {
        nPauseSliverGroup(r0);
    }

    public static /* synthetic */ void access$1100(long r0) {
        nResumeSliverGroup(r0);
    }

    public static /* synthetic */ void access$1200(long r0) {
        nClearSliverGroup(r0);
    }

    public static /* synthetic */ List access$200() {
        return getAllThread();
    }

    public static /* synthetic */ Handler access$300() {
        return newThreadHandler();
    }

    public static /* synthetic */ Sliver.ThreadFilter access$400() {
        return filter;
    }

    public static /* synthetic */ void access$500(long r0, Thread[] r2, long[] r3) {
        nNotifySliverGroup(r0, r2, r3);
    }

    public static /* synthetic */ long access$600(int r0, int r1, int r2, int r3) {
        return nStartSliverGroup(r0, r1, r2, r3);
    }

    public static /* synthetic */ void access$700(long r0) {
        nStopSliverGroup(r0);
    }

    public static /* synthetic */ int access$800(long r0) {
        return nGetThreadId(r0);
    }

    public static /* synthetic */ void access$900(long r0, String r2) {
        nDumpSliverGroup(r0, r2);
    }

    public static boolean clearAll() {
        if (isStart == true) goto L6;
        return false;
    L6:
        Iterator<SliverGroup> r0 = threadGroups.iterator();
    L8:
        if (r0.hasNext() == false) goto L18;
        SliverGroup r1 = r0.next();
        monitor-enter(r1);
        access$1200(0);     // Catch: Throwable -> L15
        monitor-exit(r1);
    L15:
        th = move-exception;
        throw th;
    L18:
        return true;
    }

    private static synchronized void deleteThreadHandler() {
        monitor-enter(SliverAllThreadSupport.class);
        Handler r1 = threadHandler;     // Catch: Throwable -> L8
        if (r1 == null) goto L10;
        r1.removeCallbacksAndMessages(null);     // Catch: Throwable -> L8
        threadHandler.getLooper().quitSafely();     // Catch: Throwable -> L8
        threadHandler = null;     // Catch: Throwable -> L8
    L10:
        monitor-exit(SliverAllThreadSupport.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static boolean dumpAll(final String r1, boolean r2) {
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

    private static List<Thread> getAllThread() {
        int r0 = systemThreadGroup.activeCount();
        Thread[] r1 = new Thread[(r0 / 2) + r0];
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

    public static boolean isStart() {
        return isStart;
    }

    private static native void nClearSliverGroup(long r0);

    private static native void nDumpSliverGroup(long r0, String r2);

    private static native int nGetThreadId(long r0);

    private static native void nNotifySliverGroup(long r0, Thread[] r2, long[] r3);

    private static native void nPauseSliverGroup(long r0);

    private static native void nResumeSliverGroup(long r0);

    private static native long nStartSliverGroup(int r0, int r1, int r2, int r3);

    private static native void nStopSliverGroup(long r0);

    private static synchronized Handler newThreadHandler() {
        monitor-enter(SliverAllThreadSupport.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (threadHandler != null) goto L9;
        HandlerThread r1 = new HandlerThread("sliver_check_thread");     // Catch: Throwable -> L7
        r1.start();     // Catch: Throwable -> L7
        threadHandler = new Handler(r1.getLooper());     // Catch: Throwable -> L7
    L9:
        Handler r2 = threadHandler;     // Catch: Throwable -> L7
        monitor-exit(SliverAllThreadSupport.class);
        return r2;
    }

    public static boolean pauseAll() {
        if (isStart == true) goto L6;
        return false;
    L6:
        if (isRunning == true) goto L8;
        return false;
    L8:
        Iterator<SliverGroup> r0 = threadGroups.iterator();
    L10:
        if (r0.hasNext() == false) goto L20;
        SliverGroup r2 = r0.next();
        monitor-enter(r2);
        access$1000(0);     // Catch: Throwable -> L17
        monitor-exit(r2);
    L17:
        th = move-exception;
        throw th;
    L20:
        deleteThreadHandler();
        isRunning = false;
        return true;
    }

    public static boolean resumeAll() {
        if (isStart == true) goto L6;
        return false;
    L6:
        if (isRunning == false) goto L8;
        return false;
    L8:
        Iterator<SliverGroup> r0 = threadGroups.iterator();
    L10:
        if (r0.hasNext() == false) goto L20;
        SliverGroup r1 = r0.next();
        monitor-enter(r1);
        access$1100(0);     // Catch: Throwable -> L17
        monitor-exit(r1);
    L17:
        th = move-exception;
        throw th;
    L20:
        newThreadHandler().post(new SliverThreadMonitor(samplingRateMs));
        isRunning = true;
        return true;
    }

    public static boolean startAll(int r0, int r1, int r2, Sliver.Mode r3, Sliver.ThreadFilter r4) {
        return false;
    }

    public static boolean stopAll() {
        if (isStart == true) goto L5;
        return false;
    L5:
        Iterator<SliverGroup> r0 = threadGroups.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        SliverGroup r2 = r0.next();
        monitor-enter(r2);
        monitor-exit(r2);
        goto L7
    L12:
        threadGroups.clear();
        deleteThreadHandler();
        isStart = false;
        isRunning = false;
        return true;
    }
}
