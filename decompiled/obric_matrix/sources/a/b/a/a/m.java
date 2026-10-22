package a.b.a.a;

import android.util.Log;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.monitor.InitMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile AtomicInteger f74a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<com.bytedance.lego.init.e.f> f75b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f76c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f77d = null;

    static final class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f78f = null;

        /* JADX INFO: renamed from: a.b.a.a.m$a$a, reason: collision with other inner class name */
        static final class RunnableC0003a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.lego.init.e.f f79f;

            public RunnableC0003a(com.bytedance.lego.init.e.f r1) {
                this.f79f = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                m.b(m.f77d, this.f79f, true);
            }
        }

        static {
            f78f = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            m r3 = m.f77d;
            List<com.bytedance.lego.init.e.f> r0 = m.f75b;
            List<com.bytedance.lego.init.e.f> r1 = com.bytedance.lego.init.d.b();
            kotlin.n0.d.o.b(r1, "TaskCollectorManager.getAllFeedShowTaskInfo()");
            r0.addAll(r1);
            kotlin.i0.r.t(r0);
            m.c(r3, r0);
            Iterator<T> r4 = r0.iterator();
        L4:
            if (r4.hasNext() == false) goto L9;
            com.bytedance.lego.init.e.f r2 = (com.bytedance.lego.init.e.f) r4.next();
            if (r2.f4886i == true) goto L7;
            m.b(m.f77d, r2, false);
            goto L4
        L7:
            k.f58h.a().post(new RunnableC0003a(r2));
            goto L4
        }
    }

    static {
        f77d = new m();
        f74a = new AtomicInteger(0);
        f75b = new ArrayList();
    }

    public m() {
    }

    public static final /* synthetic */ void b(m r0, com.bytedance.lego.init.e.f r1, boolean r2) {
        r0.d(r1, r2);
    }

    public static final /* synthetic */ void c(m r0, List r1) {
        r0.e(r1);
    }

    public final synchronized void a() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (f76c == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        f76c = true;     // Catch: Throwable -> L11
        new Thread(a.f78f, "A-FeedShowTaskDispatcher").start();     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public final void d(com.bytedance.lego.init.e.f r18, boolean r19) {
        long r7 = System.currentTimeMillis();     // Catch: Exception -> L30
        a.b.a.a.j.c.f43c.f(r18, r19);     // Catch: Exception -> L30
        StringBuilder r9 = new StringBuilder();     // Catch: Exception -> L30
        r9.append(r18.f4883f);     // Catch: Exception -> L30
        r9.append(" start. isUIThread: ");     // Catch: Exception -> L30
        r9.append(r19);     // Catch: Exception -> L30
        String r10 = r9.toString();     // Catch: Exception -> L30
        kotlin.n0.d.o.g("FeedShowTaskDispatcher", "classname");     // Catch: Exception -> L30
        kotlin.n0.d.o.g(r10, "message");     // Catch: Exception -> L30
        int r11 = 100;
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L14;
        String r12 = "FeedShowTaskDispatcher " + r10;     // Catch: Exception -> L30
        int r13 = r12.length();     // Catch: Exception -> L30
        int r14 = 1;
        int r15 = 3072;
        int r16 = 0;
    L10:
        if (r14 > r11) goto L14;
        if (r13 <= r15) goto L13;
        String r17 = r12.substring(r16, r15);     // Catch: Exception -> L30
        kotlin.n0.d.o.b(r17, "(this as java.lang.Strin…ing(startIndex, endIndex)");     // Catch: Exception -> L30
        Log.d("#inittask#" + r14, r17);     // Catch: Exception -> L30
        r14 = r14 + 1;     // Catch: Exception -> L30
        r16 = r15;
        r15 = r15 + 3072;     // Catch: Exception -> L30
        r11 = 100;
        goto L10
    L13:
        String r20 = r12.substring(r16, r13);     // Catch: Exception -> L30
        kotlin.n0.d.o.b(r20, "(this as java.lang.Strin…ing(startIndex, endIndex)");     // Catch: Exception -> L30
        Log.d("#inittask#" + r14, r20);     // Catch: Exception -> L30
    L14:
        r18.f4885h.run();     // Catch: Exception -> L30
        long r21 = System.currentTimeMillis();     // Catch: Exception -> L30
        a.b.a.a.j.c r110 = a.b.a.a.j.c.f43c;     // Catch: Exception -> L30
        r110.c(r18, r19);     // Catch: Exception -> L30
        long r22 = r21 - r7;     // Catch: Exception -> L30
        r110.b(r18, r22, r19);     // Catch: Exception -> L30
        StringBuilder r0 = new StringBuilder();     // Catch: Exception -> L30
        r0.append(r18.f4883f);     // Catch: Exception -> L30
        r0.append(" end. cos ");     // Catch: Exception -> L30
        r0.append(r22);     // Catch: Exception -> L30
        r0.append(" ms.");     // Catch: Exception -> L30
        String r1 = r0.toString();     // Catch: Exception -> L30
        kotlin.n0.d.o.g("FeedShowTaskDispatcher", "classname");     // Catch: Exception -> L30
        kotlin.n0.d.o.g(r1, "message");     // Catch: Exception -> L30
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L27;
        String r2 = "FeedShowTaskDispatcher " + r1;     // Catch: Exception -> L30
        int r8 = r2.length();     // Catch: Exception -> L30
        int r23 = 0;
        int r111 = 3072;
        int r112 = 1;
    L22:
        if (r112 > 100) goto L27;
        if (r8 <= r111) goto L25;
        String r24 = r2.substring(r23, r111);     // Catch: Exception -> L30
        kotlin.n0.d.o.b(r24, "(this as java.lang.Strin…ing(startIndex, endIndex)");     // Catch: Exception -> L30
        Log.d("#inittask#" + r112, r24);     // Catch: Exception -> L30
        r112 = r112 + 1;     // Catch: Exception -> L30
        int r113 = r111;
        r111 = r111 + 3072;     // Catch: Exception -> L30
        r23 = r113;
        goto L22
    L25:
        String r3 = r2.substring(r23, r8);     // Catch: Exception -> L30
        kotlin.n0.d.o.b(r3, "(this as java.lang.Strin…ing(startIndex, endIndex)");     // Catch: Exception -> L30
        Log.d("#inittask#" + r112, r3);     // Catch: Exception -> L30
    L27:
        if (f74a.incrementAndGet() != f75b.size()) goto L42;
        f();     // Catch: Exception -> L30
        return;
    L42:
        return;
    L30:
        e = move-exception;
        e.printStackTrace();
        String r25 = "\nerror!error!error!  " + r18.f4883f + " run error.\n";
        kotlin.n0.d.o.g("FeedShowTaskDispatcher", "classname");
        kotlin.n0.d.o.g(r25, "message");
        Log.e("#inittask#", "FeedShowTaskDispatcher " + r25);
        String r26 = Log.getStackTraceString(e);
        kotlin.n0.d.o.b(r26, "Log.getStackTraceString(e)");
        kotlin.n0.d.o.g("FeedShowTaskDispatcher", "classname");
        kotlin.n0.d.o.g(r26, "message");
        Log.e("#inittask#", "FeedShowTaskDispatcher " + r26);
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L35;
        InitMonitor r4 = InitMonitor.INSTANCE;
        StringBuilder r5 = b.a.a.a.a.e("RUN_FEED_SHOW_TASK_EXCEPTION:");
        r5.append(r18.f4883f);
        r4.ensureNotReachHere(e, r5.toString());
        return;
    L35:
        throw e;
    }

    public final void e(List<? extends com.bytedance.lego.init.e.f> r11) {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        if (r11 == null) goto L24;
        StringBuilder r10 = new StringBuilder("\n-------------------------   AllFeedShowTasks   ------------------------\n");
        Iterator<T> r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        com.bytedance.lego.init.e.f r0 = (com.bytedance.lego.init.e.f) r12.next();
        StringBuilder r1 = new StringBuilder();
        r1.append(r0);
        r1.append('\n');
        r10.append(r1.toString());
        goto L8
    L10:
        String r13 = r10.toString();
        kotlin.n0.d.o.b(r13, "sb.toString()");
        kotlin.n0.d.o.g("FeedShowTaskDispatcher", "classname");
        kotlin.n0.d.o.g(r13, "message");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L25;
        String r14 = b.a.a.a.a.b("FeedShowTaskDispatcher", ' ', r13);
        int r15 = r14.length();
        int r2 = 0;
        int r3 = 3072;
        int r9 = 1;
    L14:
        int r4 = r2;
        r2 = r3;
        if (r9 > 100) goto L26;
        if (r15 <= r2) goto L19;
        r3 = b.a.a.a.a.a(r14, r4, r2, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r9), r2, 3072);
        r9 = r9 + 1;
        goto L14
    L19:
        b.a.a.a.a.f(r14, r4, r15, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r9));
        return;
    L26:
        return;
    L25:
        return;
    }

    public final void f() {
        kotlin.n0.d.o.g("FeedShowTaskDispatcher", "classname");     // Catch: Exception -> L17
        kotlin.n0.d.o.g("sendMonitorData", "message");     // Catch: Exception -> L17
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L15;
        String r9 = "FeedShowTaskDispatcher sendMonitorData";     // Catch: Exception -> L17
        int r0 = r9.length();     // Catch: Exception -> L17
        int r3 = 0;
        int r1 = 3072;
        int r4 = 1;
    L10:
        if (r4 > 100) goto L15;
        if (r0 <= r1) goto L14;
        String r5 = r9.substring(r3, r1);     // Catch: Exception -> L17
        kotlin.n0.d.o.b(r5, "(this as java.lang.Strin…ing(startIndex, endIndex)");     // Catch: Exception -> L17
        Log.d("#inittask#" + r4, r5);     // Catch: Exception -> L17
        r4 = r4 + 1;     // Catch: Exception -> L17
        r3 = r1;
        r1 = r1 + 3072;     // Catch: Exception -> L17
        goto L10
    L14:
        String r10 = r9.substring(r3, r0);     // Catch: Exception -> L17
        kotlin.n0.d.o.b(r10, "(this as java.lang.Strin…ing(startIndex, endIndex)");     // Catch: Exception -> L17
        Log.d("#inittask#" + r4, r10);     // Catch: Exception -> L17
    L15:
        a.b.a.a.j.c.f43c.e();     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "DELAY_TASK_MONITOR_EXCEPTION");
    }
}
