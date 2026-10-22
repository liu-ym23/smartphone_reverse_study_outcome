package com.bytedance.sliver;

import android.os.Build;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Keep
final class SliverAllThreadSupport {
    static final int SLIVER_GROUP_CACHE_SIZE = 50000;
    private static final int SUPPORT_API_MAX = 31;
    private static final int SUPPORT_API_MIN = 21;
    private static Sliver.i filter;
    private static volatile boolean isRunning;
    private static volatile boolean isStart;
    private static final Thread mainThread = null;
    private static int samplingRateMs;
    private static ThreadGroup systemThreadGroup;
    private static final List<b> threadGroups = null;
    private static Handler threadHandler;

    static class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f5837f;

        a(String r1) {
            this.f5837f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SliverAllThreadSupport.access$000(this.f5837f) == true) goto L5;
            return;
        L5:
            Iterator r0 = SliverAllThreadSupport.access$100().iterator();
        L7:
            if (r0.hasNext() == false) goto L9;
            ((b) r0.next()).d(this.f5837f);
            goto L7
        L9:
            Iterator r1 = SliverAllThreadSupport.access$100().iterator();
        L11:
            if (r1.hasNext() == false) goto L13;
            ((b) r1.next()).c(this.f5837f);
            goto L11
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f5838a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f5839b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final HashSet<Thread> f5840c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private volatile long f5841d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f5842e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Sliver.e f5843f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private volatile boolean f5844g;

        b(int r3, int r4, int r5, Sliver.e r6) {
            this.f5841d = 0;
            this.f5844g = false;
            this.f5838a = r3;
            this.f5839b = r4;
            this.f5840c = new HashSet();
            this.f5842e = r5;
            this.f5843f = r6;
        }

        synchronized void a(Thread r2) {
            monitor-enter(this);
            this.f5840c.add(r2);     // Catch: Throwable -> L6
            this.f5844g = true;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized void b() {
            monitor-enter(this);
            SliverAllThreadSupport.access$1200(this.f5841d);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized void c(String r3) {
            monitor-enter(this);
            SliverAllThreadSupport.access$900(this.f5841d, r3);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized void d(String r7) {
            monitor-enter(this);
            BufferedWriter r0 = null;
            BufferedWriter r1 = new BufferedWriter(new FileWriter(r7, true));     // Catch: Throwable -> L24
            Iterator<Thread> r8 = this.f5840c.iterator();     // Catch: Throwable -> L14
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

        synchronized void e() {
            monitor-enter(this);
            i();     // Catch: Throwable -> L26
            if (this.f5841d != 0) goto L9;
            monitor-exit(this);
            return;
        L9:
            if (this.f5844g == true) goto L12;
            monitor-exit(this);
            return;
        L12:
            ArrayList r0 = new ArrayList(this.f5840c.size());     // Catch: Throwable -> L26
            ArrayList r1 = new ArrayList(this.f5840c.size());     // Catch: Throwable -> L26
            Iterator<Thread> r4 = this.f5840c.iterator();     // Catch: Throwable -> L26
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
            SliverAllThreadSupport.access$500(this.f5841d, (Thread[]) r1.toArray(new Thread[0]), r2);     // Catch: Throwable -> L26
            this.f5844g = false;     // Catch: Throwable -> L26
            monitor-exit(this);
            return;
        L26:
            th = move-exception;
            throw th;
        }

        synchronized void f() {
            monitor-enter(this);
            SliverAllThreadSupport.access$1000(this.f5841d);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized boolean g(Thread r3) {
            monitor-enter(this);
        L15:
            th = move-exception;
            throw th;
        L5:
            if (this.f5840c.isEmpty() == false) goto L9;
            monitor-exit(this);
            return false;
        L9:
            if (this.f5840c.remove(r3) == false) goto L13;
            this.f5844g = true;     // Catch: Throwable -> L15
            monitor-exit(this);
            return true;
        L13:
            monitor-exit(this);
            return false;
        }

        synchronized void h() {
            monitor-enter(this);
            SliverAllThreadSupport.access$1100(this.f5841d);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized void i() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.f5841d == 0) goto L8;
            monitor-exit(this);
            return;
        L8:
            this.f5841d = SliverAllThreadSupport.access$600(this.f5839b, this.f5842e, Sliver.mode2Int(this.f5843f), this.f5838a);     // Catch: Throwable -> L11
            monitor-exit(this);
        }

        synchronized void j() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.f5841d != 0) goto L8;
            monitor-exit(this);
            return;
        L8:
            SliverAllThreadSupport.access$700(this.f5841d);     // Catch: Throwable -> L11
            monitor-exit(this);
        }
    }

    private static class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f5845f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private List<Thread> f5846g;

        public c(int r1) {
            this.f5845f = r1;
        }

        private void b() {
            Iterator r1 = SliverAllThreadSupport.access$100().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ((b) r1.next()).e();
            goto L4
        }

        private void c(List<Thread> r3) {
            Iterator<Thread> r2 = r3.iterator();
        L4:
            if (r2.hasNext() == false) goto L12;
            Thread r4 = r2.next();
            int r0 = 1;
        L7:
            if (r0 >= SliverAllThreadSupport.access$100().size()) goto L4;
            if (((b) SliverAllThreadSupport.access$100().get(r0)).g(r4) == true) goto L4;
            r0 = r0 + 1;
            goto L7
        }

        private void d(List<Thread> r6) {
            int r5 = r6.size();
            int r1 = 0;
        L3:
            int r2 = 1;
        L4:
            if (r1 >= r5) goto L13;
            if (SliverAllThreadSupport.access$400() == null) goto L10;
            if (SliverAllThreadSupport.access$400().a(r6.get(r1)) == true) goto L10;
            r1 = r1 + 1;
        L10:
            ((b) SliverAllThreadSupport.access$100().get(r2)).a(r6.get(r1));
            r1 = r1 + 1;
            r2 = r2 + 1;
            if (r2 < SliverAllThreadSupport.access$100().size()) goto L4;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<Thread> r0 = SliverAllThreadSupport.access$200();
            if (this.f5846g != null) goto L5;
            d(r0);
        L18:
            this.f5846g = r0;
            b();
            SliverAllThreadSupport.access$300().postDelayed(this, this.f5845f);
            return;
        L5:
            ArrayList r1 = new ArrayList();
            ArrayList r2 = new ArrayList();
            Iterator<Thread> r3 = r0.iterator();
        L7:
            if (r3.hasNext() == false) goto L11;
            Thread r4 = r3.next();
            if (this.f5846g.contains(r4) == true) goto L7;
            r1.add(r4);
            goto L7
        L11:
            Iterator<Thread> r5 = this.f5846g.iterator();
        L13:
            if (r5.hasNext() == false) goto L17;
            Thread r6 = r5.next();
            if (r0.contains(r6) == true) goto L13;
            r2.add(r6);
            goto L13
        L17:
            c(r2);
            d(r1);
            goto L18
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

    static /* synthetic */ Sliver.i access$400() {
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

    static boolean clearAll() {
        if (isStart == true) goto L6;
        return false;
    L6:
        Iterator<b> r0 = threadGroups.iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        r0.next().b();
        goto L8
    L10:
        return true;
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

    static boolean dumpAll(String r1, boolean r2) {
        if (isStart == true) goto L6;
        return false;
    L6:
        a r0 = new a(r1);
        if (r2 == false) goto L9;
        r0.run();
        return true;
    L9:
        newThreadHandler().post(r0);
        return true;
    }

    private static boolean dumpHeader(String r3) {
        BufferedWriter r0 = null;
        BufferedWriter r1 = new BufferedWriter(new FileWriter(r3));     // Catch: Throwable -> L14
        r1.write("# sliver\n");     // Catch: Throwable -> L8
        r1.write("# pid:" + Process.myPid() + "\n");     // Catch: Throwable -> L8
        r1.flush();     // Catch: Throwable -> L8
        r1.close();     // Catch: IOException -> L13
    L7:
        return true;
    L8:
        r0 = r1;
    L10:
        if (r0 != null) goto L22;
    L12:
        return false;
    L22:
        r0.close();     // Catch: IOException -> L15
        goto L12
    }

    private static List<Thread> getAllThread() {
        int r0 = systemThreadGroup.activeCount();
        Thread[] r1 = new Thread[r0 + (r0 / 2)];
        int r2 = systemThreadGroup.enumerate(r1);
        ArrayList r3 = new ArrayList(r2);
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L12;
        if (r1[r4] == mainThread) goto L11;
        if (r1[r4].getName().contains("sliver") == true) goto L11;
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

    static boolean isStart() {
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

    static boolean pauseAll() {
        if (isStart == true) goto L6;
        return false;
    L6:
        if (isRunning == true) goto L8;
        return false;
    L8:
        Iterator<b> r0 = threadGroups.iterator();
    L10:
        if (r0.hasNext() == false) goto L12;
        r0.next().f();
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
        Iterator<b> r0 = threadGroups.iterator();
    L10:
        if (r0.hasNext() == false) goto L12;
        r0.next().h();
        goto L10
    L12:
        newThreadHandler().post(new c(samplingRateMs));
        isRunning = true;
        return true;
    }

    static boolean startAll(int r3, int r4, int r5, Sliver.e r6, Sliver.i r7) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 21) goto L5;
    L18:
        return false;
    L5:
        if (r0 > 31) goto L18;
        if (isStart == false) goto L11;
        return false;
    L11:
        if (initSystemThreadGroup() == true) goto L13;
        return false;
    L13:
        samplingRateMs = r4;
        filter = r7;
        List<b> r8 = threadGroups;
        r8.clear();
        int r9 = Math.max(r3, 2);
        b r1 = new b(0, r4, r5, r6);
        r1.a(mainThread);
        r1.e();
        r8.add(r1);
        int r2 = 1;
    L14:
        if (r2 >= r9) goto L16;
        threadGroups.add(new b(r2, r4, r5, r6));
        r2 = r2 + 1;
        goto L14
    L16:
        newThreadHandler().post(new c(r4 * 5));
        isStart = true;
        isRunning = true;
        return true;
    }

    static boolean stopAll() {
        if (isStart == true) goto L5;
        return false;
    L5:
        Iterator<b> r0 = threadGroups.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        r0.next().j();
        goto L7
    L9:
        threadGroups.clear();
        deleteThreadHandler();
        isStart = false;
        isRunning = false;
        return true;
    }
}
