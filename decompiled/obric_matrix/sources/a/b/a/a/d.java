package a.b.a.a;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.UiThread;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.os.TraceCompat;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.monitor.InitMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.b0;
import kotlin.f0;
import kotlin.n0.d.d0;
import kotlin.n0.d.e0;
import kotlin.n0.d.y;
import kotlin.s0.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ l[] f9f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f10g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Thread f11h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final kotlin.h f12i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f13j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f14k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final CountDownLatch f15l = null;
    public static final List<com.bytedance.lego.init.e.k> m = null;
    public static final List<com.bytedance.lego.init.e.k> n = null;
    public static long o;
    public static final List<g> p = null;
    public static final Object q = null;
    public static boolean r;
    public static final CopyOnWriteArrayList<g> s = null;
    public static final Handler t = null;
    public static final d u = null;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<ThreadPoolExecutor> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f16f = null;

        static {
            f16f = new a();
        }

        public a() {
            super(0);
        }

        @Override // kotlin.n0.c.a
        public ThreadPoolExecutor invoke() {
            return InitScheduler.INSTANCE.getExecutorService$initscheduler_release();
        }
    }

    public static final class b implements g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public com.bytedance.lego.init.e.l f17f;

        public b(com.bytedance.lego.init.e.l r1) {
            this.f17f = r1;
        }

        @Override // a.b.a.a.g
        public com.bytedance.lego.init.e.l a() {
            return this.f17f;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a(d.u, this.f17f);
        }
    }

    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f18f = null;

        static {
            f18f = new c();
        }

        public c() {
            super(0);
        }

        @Override // kotlin.n0.c.a
        public f0 invoke() {
            d r4 = d.u;
            Iterator<T> r5 = d.s.iterator();
        L4:
            if (r5.hasNext() == false) goto L10;
            g r0 = (g) r5.next();
            if (r0.a().f4903j == true) goto L7;
            d.a(d.u, r0.a());
            goto L4
        L7:
            CountDownLatch r1 = new CountDownLatch(1);
            d r2 = d.u;
            d.t.post(new e(r0, r1));
            r1.await();
            goto L4
        L10:
            return f0.f18324a;
        }
    }

    /* JADX INFO: renamed from: a.b.a.a.d$d, reason: collision with other inner class name */
    public static final class C0001d implements g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public com.bytedance.lego.init.e.l f19f;

        /* JADX WARN: Multi-variable type inference failed */
        public C0001d(d0 r1) {
            this.f19f = (com.bytedance.lego.init.e.l) r1.f18431f;
        }

        @Override // a.b.a.a.g
        public com.bytedance.lego.init.e.l a() {
            return this.f19f;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a(d.u, this.f19f);
        }
    }

    static {
        f9f = new l[]{e0.g(new y(e0.b(d.class), "executor", "getExecutor()Ljava/util/concurrent/ThreadPoolExecutor;"))};
        u = new d();
        f10g = new f();
        f12i = kotlin.i.a(kotlin.l.f18419h, a.f16f);
        f15l = new CountDownLatch(1);
        m = new ArrayList();
        n = new ArrayList();
        p = new ArrayList();
        q = new Object();
        s = new CopyOnWriteArrayList();
        t = new Handler(Looper.getMainLooper());
    }

    public d() {
    }

    public static final /* synthetic */ void a(d r0, com.bytedance.lego.init.e.l r1) {
        r0.d(r1);
    }

    public final void b(com.bytedance.lego.init.e.k r5) {
        StringBuilder r4 = new StringBuilder();     // Catch: Exception -> L12
        f r0 = f10g;     // Catch: Exception -> L12
        StringBuilder r1 = new StringBuilder();     // Catch: Exception -> L12
        r1.append(r5.name());     // Catch: Exception -> L12
        r1.append("_END");     // Catch: Exception -> L12
        Iterator<T> r2 = r0.i(r1.toString()).iterator();     // Catch: Exception -> L12
    L6:
        if (r2.hasNext() == false) goto L8;
        r4.append(((String) r2.next()) + ' ');     // Catch: Exception -> L12
        goto L6
    L8:
        InitMonitor r3 = InitMonitor.INSTANCE;     // Catch: Exception -> L12
        a.b.a.a.j.a r6 = a.b.a.a.j.a.f34j;     // Catch: Exception -> L12
        String r7 = r5.name();     // Catch: Exception -> L12
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L12
        r8.put("dependencyTasks", r4.toString());     // Catch: Exception -> L12
        r3.monitorEvent(r6, r7, r8);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        InitMonitor.INSTANCE.ensureNotReachHere(e, "sendPeriodTimeoutException");
    }

    @UiThread
    public final void c(com.bytedance.lego.init.e.k r30, boolean r31) {
        kotlin.n0.d.o.g(r30, TypedValues.CycleType.S_WAVE_PERIOD);
        long r1 = System.currentTimeMillis();
        if (r31 == false) goto L5;
        String r3 = "-END";
    L6:
        List<com.bytedance.lego.init.e.k> r4 = m;
        if (r4.contains(r30) == true) goto L21;
        Iterator<T> r5 = r4.iterator();
    L11:
        if (r5.hasNext() == false) goto L18;
        Object r6 = r5.next();
        if (((com.bytedance.lego.init.e.k) r6).a() < r30.a()) goto L15;
        boolean r9 = true;
    L16:
        if (r9 == false) goto L11;
    L20:
        if (((com.bytedance.lego.init.e.k) r6) != null) goto L21;
        if (r31 == false) goto L24;
        m.add(r30);
    L24:
        boolean r7 = true;
    L25:
        if (r7 == true) goto L27;
        return;
    L27:
        InitMonitor r8 = InitMonitor.INSTANCE;
        r8.monitorStart(r30.name() + r3, true);
        String r10 = "onPeriod-" + r30.name() + r3;
        kotlin.n0.d.o.g(r10, "message");
        InitScheduler r11 = InitScheduler.INSTANCE;
        if (r11.isDebug$initscheduler_release() == false) goto L32;
        TraceCompat.beginSection("Task:" + r10);
    L32:
        if (f13j == true) goto L41;
        a.b.a.a.l.b r12 = a.b.a.a.l.b.f72a;
        StringBuilder r13 = b.a.a.a.a.e("wait init countdownlatch ");
        r13.append(r30.name());
        a.b.a.a.l.b.a(r12, null, r13.toString(), 1);
        long r14 = System.currentTimeMillis();
        f15l.await();
        long r19 = r1;
        r8.monitorCosTime(InitMonitor.WAIT_ASYNC_TASK_INIT, System.currentTimeMillis() - r14, true);
        String r0 = "wait initTaskCountDownLatch cos: " + (System.currentTimeMillis() - r14);
        kotlin.n0.d.o.g("InitTaskDispatcher", "classname");
        kotlin.n0.d.o.g(r0, "message");
        if (r11.isDebug$initscheduler_release() == false) goto L43;
        String r2 = b.a.a.a.a.b("InitTaskDispatcher", ' ', r0);
        int r15 = r2.length();
        int r16 = 1;
        int r17 = 0;
        int r18 = 3072;
        int r20 = 100;
    L37:
        if (r16 > r20) goto L43;
        if (r15 <= r18) goto L40;
        int r21 = b.a.a.a.a.a(r2, r17, r18, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r16), r18, 3072);
        r16 = r16 + 1;
        r20 = 100;
        int r28 = r18;
        r18 = r21;
        r17 = r28;
        goto L37
    L40:
        b.a.a.a.a.f(r2, r17, r15, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r16));
    L43:
        if (r == false) goto L47;
        a.b.a.a.l.b.c(a.b.a.a.l.b.f72a, null, "No task.", 1);
        return;
    L47:
        if (f14k == true) goto L65;
        kotlin.n0.d.o.g("InitTaskDispatcher", "classname");
        kotlin.n0.d.o.g("startAsyncTask", "message");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L56;
        String r22 = b.a.a.a.a.b("InitTaskDispatcher", ' ', "startAsyncTask");
        int r23 = r22.length();
        int r24 = 3072;
        int r25 = 1;
        int r26 = 0;
    L52:
        if (r25 > 100) goto L56;
        if (r23 <= r24) goto L55;
        int r27 = b.a.a.a.a.a(r22, r26, r24, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r25), r24, 3072);
        r25 = r25 + 1;
        r26 = r24;
        r24 = r27;
        goto L52
    L55:
        b.a.a.a.a.f(r22, r26, r23, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r25));
    L56:
        kotlin.n0.d.o.g("startAsyncTask", "message");
        InitScheduler r29 = InitScheduler.INSTANCE;
        if (r29.isDebug$initscheduler_release() == false) goto L60;
        TraceCompat.beginSection("Task:startAsyncTask");
    L60:
        Thread r32 = new Thread(this);
        f11h = r32;
        r32.start();
        f14k = true;
        if (r29.isDebug$initscheduler_release() == false) goto L65;
        TraceCompat.endSection();
    L65:
        a.b.a.a.l.b r33 = a.b.a.a.l.b.f72a;
        StringBuilder r34 = b.a.a.a.a.e("onPeriod: ");
        r34.append(r30.name());
        r34.append(r3);
        a.b.a.a.l.b.a(r33, null, r34.toString(), 1);
        g(r30, r31);
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L69;
        TraceCompat.endSection();
    L69:
        InitMonitor r35 = InitMonitor.INSTANCE;
        r35.monitorEnd(r30.name() + r3, true);
        StringBuilder r36 = b.a.a.a.a.e("onPeriod-");
        r36.append(r30.name());
        r36.append(r3);
        r35.monitorCosTime(r36.toString(), System.currentTimeMillis() - r19, true);
        return;
    L41:
        r19 = r1;
        goto L43
    L15:
        r9 = false;
        goto L16
    L18:
        r6 = null;
    L21:
        r7 = false;
        goto L25
    L5:
        r3 = "-START";
        goto L6
    }

    public final void d(com.bytedance.lego.init.e.l r11) {
        boolean r10 = kotlin.n0.d.o.a(Looper.getMainLooper(), Looper.myLooper());
        a.b.a.a.l.b.e(a.b.a.a.l.b.f72a, null, "TaskStart - " + r11 + "  isUIThread:" + r10, 1);
        long r0 = System.currentTimeMillis();
        r11.r = r0;
        InitMonitor.INSTANCE.monitorTaskStart(r11, r10);
        kotlin.n0.d.o.g(r11, "taskInfo");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L30;
        StringBuilder r4 = b.a.a.a.a.e("Task:");
        r4.append(r11.f4899f);
        TraceCompat.beginSection(r4.toString());
    L30:
        com.bytedance.lego.init.e.h r5 = r11.f4902i;     // Catch: Exception -> L16
        if (r5 == null) goto L9;
    L8:
        r5.run();     // Catch: Exception -> L16
    L25:
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L28;
        TraceCompat.endSection();
    L28:
        InitMonitor r6 = InitMonitor.INSTANCE;
        r6.monitorTaskEnd(r11, r10);
        long r7 = System.currentTimeMillis();
        r11.s = r7;
        r6.monitorCosTime(r11, r7 - r0, r10);
        a.b.a.a.l.b r12 = a.b.a.a.l.b.f72a;
        StringBuilder r8 = b.a.a.a.a.e("Task ");
        r8.append(r11.f4899f);
        r8.append(" done. cos ");
        r8.append(System.currentTimeMillis() - r0);
        r8.append("ms.");
        a.b.a.a.l.b.a(r12, null, r8.toString(), 1);
        f10g.g(r11);
        return;
    L9:
        Object r9 = Class.forName(r11.f4901h).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L16
        if (r9 == null) goto L15;
        r5 = (com.bytedance.lego.init.e.h) r9;     // Catch: Exception -> L16
        goto L8
    L15:
        throw new b0("null cannot be cast to non-null type com.bytedance.lego.init.model.IInitTask");     // Catch: Exception -> L16
    L16:
        e = move-exception;
        StringBuilder r13 = b.a.a.a.a.e("\nerror!error!error! ");
        r13.append(r11.f4899f);
        r13.append(" run error.\n ");
        e.printStackTrace();
        r13.append(f0.f18324a);
        r13.append(" \n");
        String r14 = r13.toString();
        kotlin.n0.d.o.g("InitTaskDispatcher", "classname");
        kotlin.n0.d.o.g(r14, "message");
        Log.e("#inittask#", "InitTaskDispatcher " + r14);
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L20;
    L23:
        InitMonitor r15 = InitMonitor.INSTANCE;
        StringBuilder r16 = b.a.a.a.a.e("RUN_TASK_EXCEPTION:");
        r16.append(r11.f4901h);
        r15.ensureNotReachHere(e, r16.toString());
        a.b.a.a.j.a r17 = a.b.a.a.j.a.f33i;
        String r18 = r11.f4901h + ":" + e.getClass().getName();
        JSONObject r19 = new JSONObject();
        r19.put("exception_detail", Log.getStackTraceString(e));
        r15.monitorEvent(r17, r18, r19);
        goto L25
    L20:
        if ((e instanceof ClassNotFoundException) == true) goto L23;
        throw e;
    }

    public final void e(boolean r1) {
        r = r1;
    }

    public final void f() {
        f10g.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, com.bytedance.lego.init.e.l] */
    /* JADX WARN: Type inference failed for: r5v15, types: [T, com.bytedance.lego.init.e.l] */
    /* JADX WARN: Type inference failed for: r5v33, types: [T, com.bytedance.lego.init.e.l] */
    @UiThread
    public final void g(com.bytedance.lego.init.e.k r13, boolean r14) {
    L3:
        if (n.contains(r13) == true) goto L135;
        d0 r0 = new d0();
        f r5 = f10g;
        if (r14 == false) goto L75;
        ?? r6 = r5.a(0);
        r0.f18431f = r6;
        if (((com.bytedance.lego.init.e.l) r6) != null) goto L44;
        Object r7 = q;
        monitor-enter(r7);
        Iterator<g> r8 = p.iterator();     // Catch: Throwable -> L40
    L13:
        if (r8.hasNext() == false) goto L33;
        g r9 = r8.next();     // Catch: Throwable -> L40
        f r10 = f10g;     // Catch: Throwable -> L40
        String r11 = r9.a().f4899f;     // Catch: Throwable -> L40
        kotlin.n0.d.o.b(r11, "runnable.initTaskInfo.taskId");     // Catch: Throwable -> L40
        float r12 = r10.f(r11);     // Catch: Throwable -> L40
        if (r12 <= 0) goto L13;
        com.bytedance.lego.init.e.k r15 = r9.a().q;     // Catch: Throwable -> L40
        kotlin.n0.d.o.b(r15, "runnable.initTaskInfo.endPeriod");     // Catch: Throwable -> L40
        if (r15.a() > r13.a()) goto L13;
        StringBuilder r16 = new StringBuilder();     // Catch: Throwable -> L40
        r16.append(r13.name());     // Catch: Throwable -> L40
        r16.append("_END");     // Catch: Throwable -> L40
        if (r12 <= r10.f(r16.toString())) goto L13;
        r8.remove();     // Catch: Throwable -> L40
        if (u.i().remove(r9) == false) goto L13;
        a.b.a.a.l.b r17 = a.b.a.a.l.b.f72a;     // Catch: Throwable -> L40
        StringBuilder r18 = new StringBuilder();     // Catch: Throwable -> L40
        r18.append("execute async-task:");     // Catch: Throwable -> L40
        r18.append(r9.a().f4899f);     // Catch: Throwable -> L40
        r18.append(" in UIThread.");     // Catch: Throwable -> L40
        a.b.a.a.l.b.a(r17, null, r18.toString(), 1);     // Catch: Throwable -> L40
    L34:
        f0 r19 = f0.f18324a;     // Catch: Throwable -> L40
        monitor-exit(r7);
        if (r9 == null) goto L38;
        r9.run();
        o = System.currentTimeMillis();
    L38:
        if (r9 != null) goto L44;
        r0.f18431f = f10g.b(r13);
        goto L44
    L33:
        r9 = null;
    L40:
        th = move-exception;
        throw th;
    L44:
        if (((com.bytedance.lego.init.e.l) r0.f18431f) != null) goto L73;
        if ((System.currentTimeMillis() - o) < InitScheduler.INSTANCE.getConfig$initscheduler_release().getTimeout()) goto L71;
        a.b.a.a.l.b.a(a.b.a.a.l.b.f72a, null, "UIThread wait timeout.", 1);
        u.b(r13);
        f r20 = f10g;     // Catch: Exception -> L66
        StringBuilder r21 = new StringBuilder();     // Catch: Exception -> L66
        r21.append(r13.name());     // Catch: Exception -> L66
        r21.append("_END");     // Catch: Exception -> L66
        Iterator<T> r22 = r20.i(r21.toString()).iterator();     // Catch: Exception -> L66
    L53:
        if (r22.hasNext() == false) goto L71;
        String r23 = (String) r22.next();     // Catch: Exception -> L66
        f r24 = f10g;     // Catch: Exception -> L66
        com.bytedance.lego.init.e.l r25 = r24.c(r23);     // Catch: Exception -> L66
        if (r25 == null) goto L53;
        long r26 = System.currentTimeMillis() - r25.r;     // Catch: Exception -> L66
        if (r25.r <= 0) goto L53;
        if (r26 < InitScheduler.INSTANCE.getConfig$initscheduler_release().getTimeout()) goto L53;
        r24.g(r25);     // Catch: Exception -> L66
        u.h(r25);     // Catch: Exception -> L66
        a.b.a.a.l.b r1 = a.b.a.a.l.b.f72a;     // Catch: Exception -> L66
        StringBuilder r2 = new StringBuilder();     // Catch: Exception -> L66
        r2.append("Task ");     // Catch: Exception -> L66
        r2.append(r25.f4899f);     // Catch: Exception -> L66
        r2.append(" timeout, is forced to complete.");     // Catch: Exception -> L66
        a.b.a.a.l.b.a(r1, null, r2.toString(), 1);     // Catch: Exception -> L66
    L66:
        e = move-exception;
        e.printStackTrace();
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L70;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "letTimeoutTaskCompele");
        goto L71
    L70:
        throw e;
    L71:
        f0 r3 = f0.f18324a;
    L73:
        if (((com.bytedance.lego.init.e.l) r0.f18431f) == null) goto L3;
    L78:
        long r4 = System.currentTimeMillis();
        if (a.b.a.a.c.d((com.bytedance.lego.init.e.l) r0.f18431f) == false) goto L81;
    L89:
        com.bytedance.lego.init.e.l r27 = (com.bytedance.lego.init.e.l) r0.f18431f;
        kotlin.n0.d.o.g(r27, "taskInfo");
        InitScheduler r28 = InitScheduler.INSTANCE;
        if (r28.isDebug$initscheduler_release() == false) goto L93;
        StringBuilder r29 = b.a.a.a.a.e("Task:");
        r29.append(r27.f4899f);
        TraceCompat.beginSection(r29.toString());
    L93:
        a.b.a.a.l.b r30 = a.b.a.a.l.b.f72a;
        a.b.a.a.l.b.a(r30, null, ((com.bytedance.lego.init.e.l) r0.f18431f).f4899f + " complete directly. cos " + (System.currentTimeMillis() - r4) + "ms", 1);
        f10g.g((com.bytedance.lego.init.e.l) r0.f18431f);
        if (r28.isDebug$initscheduler_release() == false) goto L98;
        TraceCompat.endSection();
    L98:
        if (a.b.a.a.c.d((com.bytedance.lego.init.e.l) r0.f18431f) == true) goto L100;
    L102:
        o = System.currentTimeMillis();
        goto L3
    L100:
        if (kotlin.n0.d.o.a(r13.name() + "_END", ((com.bytedance.lego.init.e.l) r0.f18431f).f4899f) == false) goto L102;
        InitMonitor r110 = InitMonitor.INSTANCE;
        StringBuilder r111 = b.a.a.a.a.e("wait: ");
        r111.append(r13.name());
        r110.monitorCosTime(r111.toString(), System.currentTimeMillis() - o, true);
        StringBuilder r112 = b.a.a.a.a.e("wait: ");
        r112.append(r13.name());
        r112.append(' ');
        r112.append(System.currentTimeMillis() - o);
        r112.append("ms.");
        a.b.a.a.l.b.a(r30, null, r112.toString(), 1);
        n.add(r13);
        return;
    L81:
        if (a.b.a.a.c.c((com.bytedance.lego.init.e.l) r0.f18431f) == false) goto L89;
        if (((com.bytedance.lego.init.e.l) r0.f18431f).f4904k == true) goto L86;
    L88:
        d((com.bytedance.lego.init.e.l) r0.f18431f);
        goto L102
    L86:
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getAgreePrivacyPopupWindow() == true) goto L88;
        s.add(new C0001d(r0));
        a.b.a.a.l.b.a(a.b.a.a.l.b.f72a, null, b.a.a.a.a.d(new StringBuilder(), ((com.bytedance.lego.init.e.l) r0.f18431f).f4899f, " skip directly."), 1);
        f10g.g((com.bytedance.lego.init.e.l) r0.f18431f);
        goto L102
    L75:
        ?? r31 = r5.a(0);
        if (r31 == 0) goto L136;
        r0.f18431f = r31;
        goto L78
    L136:
        return;
    }

    public final void h(com.bytedance.lego.init.e.l r6) {
        InitMonitor r5 = InitMonitor.INSTANCE;
        String r0 = r6.f4899f;
        kotlin.n0.d.o.b(r0, "task.taskId");
        r5.onTaskTimeout(r0);
        a.b.a.a.j.a r1 = a.b.a.a.j.a.f35k;
        String r2 = r6.f4899f;
        kotlin.n0.d.o.b(r2, "task.taskId");
        JSONObject r3 = new JSONObject();
        r3.put("startTime", r6.r);
        r3.put("curTime", System.currentTimeMillis());
        r5.monitorEvent(r1, r2, r3);
    }

    public final ThreadPoolExecutor i() {
        kotlin.h r2 = f12i;
        l r0 = f9f[0];
        return (ThreadPoolExecutor) r2.getValue();
    }

    public final void j() {
        if (f13j == false) goto L5;
        return;
    L5:
        long r2 = System.currentTimeMillis();
        InitScheduler r4 = InitScheduler.INSTANCE;
        int r6 = 100;
        int r13 = 0;
        if (r4.isDebug$initscheduler_release() == false) goto L16;
        String r5 = InitMonitor.TASKDISPATCHER_INIT + " start";
        kotlin.n0.d.o.g("InitTaskDispatcher", "classname");
        kotlin.n0.d.o.g(r5, "message");
        if (r4.isDebug$initscheduler_release() == false) goto L16;
        String r7 = b.a.a.a.a.b("InitTaskDispatcher", ' ', r5);
        int r8 = r7.length();
        int r15 = 0;
        int r9 = 3072;
        int r11 = 1;
    L11:
        if (r11 > r6) goto L16;
        String r10 = b.a.a.a.a.c("#inittask#", r11);
        if (r8 <= r9) goto L15;
        String r16 = r7.substring(r15, r9);
        kotlin.n0.d.o.b(r16, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Log.v(r10, r16);
        r11 = r11 + 1;
        r15 = r9;
        r9 = r9 + 3072;
        r6 = 100;
        goto L11
    L15:
        String r12 = r7.substring(r15, r8);
        kotlin.n0.d.o.b(r12, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Log.v(r10, r12);
    L16:
        InitMonitor r14 = InitMonitor.INSTANCE;
        r14.monitorStart(InitMonitor.TASKDISPATCHER_INIT, false);
        kotlin.n0.d.o.g("InitTaskDispatcher.initInternal", "message");
        InitScheduler r17 = InitScheduler.INSTANCE;
        if (r17.isDebug$initscheduler_release() == false) goto L20;
        TraceCompat.beginSection("Task:InitTaskDispatcher.initInternal");
    L20:
        f10g.j();
        f13j = true;
        f15l.countDown();
        f0 r18 = f0.f18324a;
        if (r17.isDebug$initscheduler_release() == false) goto L24;
        TraceCompat.endSection();
    L24:
        r14.monitorEnd(InitMonitor.TASKDISPATCHER_INIT, false);
        r14.monitorCosTime(InitMonitor.TASKDISPATCHER_INIT, System.currentTimeMillis() - r2, false);
        if (r17.isDebug$initscheduler_release() == false) goto L39;
        String r0 = InitMonitor.TASKDISPATCHER_INIT + " done. cos: " + (System.currentTimeMillis() - r2) + "ms.";
        kotlin.n0.d.o.g("InitTaskDispatcher", "classname");
        kotlin.n0.d.o.g(r0, "message");
        if (r17.isDebug$initscheduler_release() == false) goto L40;
        String r1 = b.a.a.a.a.b("InitTaskDispatcher", ' ', r0);
        int r3 = r1.length();
        int r19 = 1;
        int r110 = 3072;
    L30:
        if (r19 > 100) goto L41;
        if (r3 <= r110) goto L33;
        int r20 = b.a.a.a.a.a(r1, r13, r110, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r19), r110, 3072);
        r19 = r19 + 1;
        r13 = r110;
        r110 = r20;
        goto L30
    L33:
        b.a.a.a.a.f(r1, r13, r3, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r19));
        return;
    L41:
        return;
    L40:
        return;
    }

    public final void k() {
        a.b.a.a.l.b.a(a.b.a.a.l.b.f72a, null, "startPrivacyTask", 1);
        a.b.a.a.c.a(c.f18f);
    }

    @Override // java.lang.Runnable
    public void run() {
    L2:
        f r0 = f10g;
        if (r0.h() == true) goto L5;
        com.bytedance.lego.init.e.l r1 = null;
    L7:
        if (r1 == null) goto L28;
        kotlin.n0.d.o.g(r1, "receiver$0");
        if (kotlin.n0.d.o.a("init_shceduler_internal_task", r1.f4901h) == true) goto L26;
        if (a.b.a.a.c.c(r1) == false) goto L26;
        b r4 = new b(r1);
        if (r1.f4904k == false) goto L18;
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getAgreePrivacyPopupWindow() == true) goto L18;
        s.add(r4);
        a.b.a.a.l.b r5 = a.b.a.a.l.b.f72a;
        StringBuilder r6 = new StringBuilder();
        String r7 = r1.f4899f;
        String r8 = " skip directly.";
    L27:
        a.b.a.a.l.b.a(r5, null, b.a.a.a.a.d(r6, r7, r8), 1);
        r0.g(r1);
    L18:
        i().execute(r4);
        Object r2 = q;
        monitor-enter(r2);
        p.add(r4);     // Catch: Throwable -> L23
        monitor-exit(r2);
    L23:
        th = move-exception;
        throw th;
    L26:
        r5 = a.b.a.a.l.b.f72a;
        r6 = new StringBuilder();
        r7 = r1.f4899f;
        r8 = " complete directly.";
        goto L27
    L28:
        a.b.a.a.l.b.e(a.b.a.a.l.b.f72a, null, "异步调度线程 end.", 1);
        return;
    L5:
        r1 = r0.f25d.take();
        goto L7
    }
}
