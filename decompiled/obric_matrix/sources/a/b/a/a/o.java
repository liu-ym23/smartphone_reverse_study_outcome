package a.b.a.a;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import com.bytedance.lego.init.IdleTaskConfig;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.e.j;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.lego.init.tasks.IdleTaskProxy;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.f0;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"CI_ByteDanceKotlinRules_Static_Names"})
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IdleTaskConfig f80a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList<j> f81b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayList<j> f82c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile AtomicInteger f83d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f84e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Handler f85f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile boolean f86g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f87h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final o f88i = null;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f89f = null;

        static {
            f89f = new a();
        }

        public a() {
            super(0);
        }

        @Override // kotlin.n0.c.a
        public f0 invoke() {
            kotlin.n0.d.o.g("IdleTaskDispatcher", "classname");     // Catch: Throwable -> L17
            kotlin.n0.d.o.g("asyncSendMonitorData", "message");     // Catch: Throwable -> L17
            if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L15;
            String r9 = "IdleTaskDispatcher asyncSendMonitorData";     // Catch: Throwable -> L17
            int r0 = r9.length();     // Catch: Throwable -> L17
            int r3 = 0;
            int r1 = 3072;
            int r4 = 1;
        L10:
            if (r4 > 100) goto L15;
            if (r0 <= r1) goto L14;
            String r5 = r9.substring(r3, r1);     // Catch: Throwable -> L17
            kotlin.n0.d.o.b(r5, "(this as java.lang.Strin…ing(startIndex, endIndex)");     // Catch: Throwable -> L17
            Log.d("#inittask#" + r4, r5);     // Catch: Throwable -> L17
            r4 = r4 + 1;     // Catch: Throwable -> L17
            r3 = r1;
            r1 = r1 + 3072;     // Catch: Throwable -> L17
            goto L10
        L14:
            String r10 = r9.substring(r3, r0);     // Catch: Throwable -> L17
            kotlin.n0.d.o.b(r10, "(this as java.lang.Strin…ing(startIndex, endIndex)");     // Catch: Throwable -> L17
            Log.d("#inittask#" + r4, r10);     // Catch: Throwable -> L17
        L15:
            a.b.a.a.j.d.f48e.b();     // Catch: Throwable -> L17
        L20:
            return f0.f18324a;
        L17:
            th = move-exception;
            InitMonitor.INSTANCE.ensureNotReachHere(th, "IDLE_TASK_MONITOR_EXCEPTION");
            goto L20
        }
    }

    static final class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f90f = null;

        static {
            f90f = new b();
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            InitScheduler.startDispatchIdleTask();
        }
    }

    public static final class c implements MessageQueue.IdleHandler {
        public c() {
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            o r2 = o.f88i;
            if (o.f86g == true) goto L5;
            return true;
        L5:
            o.e(r2);
            if ((!r2.f().isEmpty()) == false) goto L8;
            return true;
        L8:
            if ((!r2.g().isEmpty()) == true) goto L13;
            return false;
        L13:
            return true;
        }
    }

    static {
        f88i = new o();
        f80a = IdleTaskConfig.Companion.a();
        f81b = new ArrayList();
        f82c = new ArrayList();
        f83d = new AtomicInteger(0);
        f85f = new Handler(Looper.getMainLooper());
        f87h = new c();
    }

    public o() {
    }

    public static final /* synthetic */ void b(o r0) {
        r0.a();
    }

    public static final /* synthetic */ boolean e(o r0) {
        return r0.h();
    }

    public final void a() {
        if (f83d.incrementAndGet() == f84e) goto L5;
        return;
    L5:
        a.b.a.a.c.a(a.f89f);
    }

    public final void c(IdleTaskConfig r3) {
        kotlin.n0.d.o.g(r3, "config");
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().isMainProcess() == true) goto L5;
        return;
    L5:
        f86g = false;
        f80a = r3;
        if (r3.getAutoIdleTask() == false) goto L9;
        f85f.postDelayed(b.f90f, f80a.getBootFinishTimeOut());
        return;
    }

    public final void d() {
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().isMainProcess() == true) goto L6;
        return;
    L6:
        if (f86g == false) goto L8;
        return;
    L8:
        f86g = true;
        ArrayList<j> r2 = f81b;
        r2.addAll(com.bytedance.lego.init.d.i());
        ArrayList<j> r0 = f82c;
        r0.addAll(com.bytedance.lego.init.d.h());
        int r3 = r2.size();
        int r1 = r0.size() + r3;
        f84e = r1;
        if (r1 != 0) goto L11;
        return;
    L11:
        Looper.myQueue().addIdleHandler(f87h);
    }

    public final ArrayList<j> f() {
        return f82c;
    }

    public final ArrayList<j> g() {
        return f81b;
    }

    public final boolean h() {
        int r7 = Math.min(f81b.size(), f80a.getUiThreadTaskNum());
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 >= r7) goto L5;
        j r4 = f81b.remove(0);
        kotlin.n0.d.o.b(r4, "uiTaskList.removeAt(0)");
        j r5 = r4;
        com.bytedance.lego.init.e.b r6 = r5.f4891i;
        kotlin.n0.d.o.b(r6, "task.task");
        String r8 = r5.f4888f;
        kotlin.n0.d.o.b(r8, "task.taskId");
        new IdleTaskProxy(r6, r8, true, r.f93f).run();
        r2 = r2 + 1;
        r3 = true;
        goto L3
    L5:
        if (r3 == true) goto L9;
        int r9 = Math.min(f82c.size(), f80a.getNonUIThreadTaskNum());
        int r10 = 0;
        r3 = false;
    L7:
        if (r10 >= r9) goto L9;
        j r11 = f82c.remove(0);
        kotlin.n0.d.o.b(r11, "nonUiTaskList.removeAt(0)");
        a.b.a.a.c.a(new q(r11));
        r10 = r10 + 1;
        r3 = true;
    L9:
        return r3;
    }
}
