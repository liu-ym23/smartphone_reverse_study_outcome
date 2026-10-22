package com.bytedance.lego.init;

import a.b.a.a.L;
import a.b.a.a.h;
import a.b.a.a.m;
import a.b.a.a.n;
import android.app.Activity;
import android.util.Log;
import androidx.annotation.UiThread;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.os.TraceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.lego.init.config.ProcessMatchMode;
import com.bytedance.lego.init.config.TaskConfig;
import com.bytedance.lego.init.e.k;
import com.bytedance.lego.init.monitor.InitMonitor;
import java.lang.ref.WeakReference;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bF\u0010\u0007J\u0017\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0012\u0010\u0007J\u000f\u0010\u0013\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0013\u0010\u0007J\u000f\u0010\u0014\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0014\u0010\u0007J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u001a\u0010\u0018J\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0004\b\u001e\u0010\u001cJ\u000f\u0010!\u001a\u00020\u0004H\u0001¢\u0006\u0004\b \u0010\u0007J\u000f\u0010#\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\"\u0010\u0007J\u000f\u0010$\u001a\u00020\u0004H\u0007¢\u0006\u0004\b$\u0010\u0007J\u000f\u0010(\u001a\u00020%H\u0000¢\u0006\u0004\b&\u0010'J\u000f\u0010+\u001a\u00020\tH\u0000¢\u0006\u0004\b)\u0010*J\u0011\u0010-\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0004\b,\u0010*J\u000f\u00101\u001a\u00020.H\u0000¢\u0006\u0004\b/\u00100J\r\u00102\u001a\u00020%¢\u0006\u0004\b2\u0010'J\u0017\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u000203H\u0007¢\u0006\u0004\b5\u00106R\u0018\u00107\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u001c\u0010:\u001a\u0002098\u0000@\u0000X\u0080D¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001e\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u001e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010@R\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\u0003\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010\u0005¨\u0006G"}, d2 = {"Lcom/bytedance/lego/init/InitScheduler;", "", "Lcom/bytedance/lego/init/config/TaskConfig;", "config", "Lkotlin/f0;", "(Lcom/bytedance/lego/init/config/TaskConfig;)V", "initTasks", "()V", "initPeriodTask", "Ljava/util/concurrent/ThreadPoolExecutor;", "executor", "setExecutorService", "(Ljava/util/concurrent/ThreadPoolExecutor;)V", "Lcom/bytedance/lego/init/e/k;", TypedValues.CycleType.S_WAVE_PERIOD, "onPeriodStart", "(Lcom/bytedance/lego/init/e/k;)V", "onPeriodEnd", "startDispatchDelayTask", "startDispatchIdleTask", "onFeedShow", "Landroid/app/Activity;", "mainActivity", "registerMainActivity", "(Landroid/app/Activity;)V", "splashActivity", "registerSplashActivity", "getMainActivity$initscheduler_release", "()Landroid/app/Activity;", "getMainActivity", "getSplashActivity$initscheduler_release", "getSplashActivity", "unRegisterMainActivity$initscheduler_release", "unRegisterMainActivity", "unRegisterSplashActivity$initscheduler_release", "unRegisterSplashActivity", "afterPrivacyPopupWindow", "", "isDebug$initscheduler_release", "()Z", "isDebug", "getExecutorService$initscheduler_release", "()Ljava/util/concurrent/ThreadPoolExecutor;", "getExecutorService", "getExecutorServiceOrNull$initscheduler_release", "getExecutorServiceOrNull", "Lcom/bytedance/lego/init/config/ProcessMatchMode;", "getProcessMatchMode$initscheduler_release", "()Lcom/bytedance/lego/init/config/ProcessMatchMode;", "getProcessMatchMode", "enableCatchException", "Lcom/bytedance/lego/init/IServiceManagerProxy;", "proxy", "setServiceManagerProxy", "(Lcom/bytedance/lego/init/IServiceManagerProxy;)V", "taskExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "", "INIT_SCHEDULER_CATEGORY", "Ljava/lang/String;", "getINIT_SCHEDULER_CATEGORY$initscheduler_release", "()Ljava/lang/String;", "Ljava/lang/ref/WeakReference;", "splashActivityWR", "Ljava/lang/ref/WeakReference;", "mainActivityWR", "Lcom/bytedance/lego/init/config/TaskConfig;", "getConfig$initscheduler_release", "()Lcom/bytedance/lego/init/config/TaskConfig;", "setConfig$initscheduler_release", "<init>", "initscheduler_release"}, k = 1, mv = {1, 1, 15})
public final class InitScheduler {
    public static final String INIT_SCHEDULER_CATEGORY = "init_scheduler";
    public static final InitScheduler INSTANCE = null;
    public static TaskConfig config;
    public static WeakReference<Activity> mainActivityWR;
    public static WeakReference<Activity> splashActivityWR;
    public static ThreadPoolExecutor taskExecutor;

    static {
        INSTANCE = new InitScheduler();
        INIT_SCHEDULER_CATEGORY = "init_scheduler";
    }

    public InitScheduler() {
    }

    public static final void afterPrivacyPopupWindow() {
        a.b.a.a.d.u.k();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        if (INSTANCE.enableCatchException() == false) goto L9;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "START_DELAY_TASK_DISPATCHER");
        return;
    L9:
        throw e;
    }

    public static final void config(TaskConfig r3) {
        o.g(r3, "config");
        config = r3;
        a.b.a.a.o.f88i.c(r3.getIdleTaskConfig());
        a.b.a.a.j.d.f48e.c(r3.getApplicationStartTime());
    }

    public static final Activity getMainActivity$initscheduler_release() {
        WeakReference<Activity> r0 = mainActivityWR;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    public static final Activity getSplashActivity$initscheduler_release() {
        WeakReference<Activity> r0 = splashActivityWR;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    public static final void initPeriodTask() {
        o.g("initPeriodTask", "message");
        InitScheduler r1 = INSTANCE;
        if (r1.isDebug$initscheduler_release() == false) goto L6;
        TraceCompat.beginSection("Task:initPeriodTask");
    L6:
        L.f3d.a();
        f0 r0 = f0.f18324a;
        if (r1.isDebug$initscheduler_release() == false) goto L11;
        TraceCompat.endSection();
        return;
    }

    public static final void initTasks() {
        o.g("initTasks", "message");
        InitScheduler r1 = INSTANCE;
        if (r1.isDebug$initscheduler_release() == false) goto L6;
        TraceCompat.beginSection("Task:initTasks");
    L6:
        a.b.a.a.d.u.j();
        f0 r0 = f0.f18324a;
        if (r1.isDebug$initscheduler_release() == false) goto L11;
        TraceCompat.endSection();
        return;
    }

    @UiThread
    public static final void onFeedShow() {
        TaskConfig r0 = config;
        if (r0 == null) goto L13;
        r0.isDebug();
        m.f77d.a();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        if (INSTANCE.enableCatchException() == false) goto L12;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "START_FEED_SHOW_TASK_DISPATCHER");
        return;
    L12:
        throw e;
    L13:
        o.v("config");
        throw null;
    }

    @UiThread
    public static final void onPeriodEnd(k r7) {
        o.g(r7, TypedValues.CycleType.S_WAVE_PERIOD);
        a.b.a.a.d.u.c(r7, true);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        InitMonitor r1 = InitMonitor.INSTANCE;
        a.b.a.a.j.a r2 = a.b.a.a.j.a.f31g;
        String r3 = r7.name();
        JSONObject r4 = new JSONObject();
        r4.put("exception_detail", Log.getStackTraceString(e));
        r1.monitorEvent(r2, r3, r4);
        TaskConfig r5 = config;
        if (r5 != null) goto L9;
        o.v("config");
        throw null;
    L9:
        if (r5.getCatchException() == false) goto L12;
        StringBuilder r6 = b.a.a.a.a.e("ON_PERIOD_EXCEPTION:");
        r6.append(r7.name());
        r1.ensureNotReachHere(e, r6.toString());
        return;
    L12:
        throw e;
    }

    @UiThread
    public static final void onPeriodStart(k r9) {
        o.g(r9, TypedValues.CycleType.S_WAVE_PERIOD);
        TaskConfig r0 = config;
        if (r0 == null) goto L17;
        r0.isDebug();
        a.b.a.a.d.u.c(r9, false);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        InitMonitor r3 = InitMonitor.INSTANCE;
        a.b.a.a.j.a r4 = a.b.a.a.j.a.f31g;
        String r5 = r9.name();
        JSONObject r6 = new JSONObject();
        r6.put("exception_detail", Log.getStackTraceString(e));
        r3.monitorEvent(r4, r5, r6);
        TaskConfig r7 = config;
        if (r7 != null) goto L11;
        o.v("config");
        throw null;
    L11:
        if (r7.getCatchException() == false) goto L14;
        StringBuilder r1 = b.a.a.a.a.e("ON_PERIOD_EXCEPTION:");
        r1.append(r9.name());
        r3.ensureNotReachHere(e, r1.toString());
        return;
    L14:
        throw e;
    L17:
        o.v("config");
        throw null;
    }

    public static final void registerMainActivity(Activity r2) {
        o.g(r2, "mainActivity");
        mainActivityWR = new WeakReference(r2);
        boolean r0 = r2 instanceof LifecycleOwner;
        Lifecycle r1 = null;
        Object r3 = r2;
        if (r0 == true) goto L5;
        r3 = null;
    L5:
        LifecycleOwner r4 = (LifecycleOwner) r3;
        if (r4 == null) goto L8;
        r1 = r4.getLifecycle();
    L8:
        if (r1 == null) goto L12;
        L.f3d.d(r1);
        return;
    L12:
        throw new IllegalArgumentException("mainActivity must be LifecycleOwner.");
    }

    public static final void registerSplashActivity(Activity r2) {
        o.g(r2, "splashActivity");
        splashActivityWR = new WeakReference(r2);
        boolean r0 = r2 instanceof LifecycleOwner;
        Lifecycle r1 = null;
        Object r3 = r2;
        if (r0 == true) goto L5;
        r3 = null;
    L5:
        LifecycleOwner r4 = (LifecycleOwner) r3;
        if (r4 == null) goto L8;
        r1 = r4.getLifecycle();
    L8:
        if (r1 == null) goto L12;
        L.f3d.f(r1);
        return;
    L12:
        throw new IllegalArgumentException("splashActivity must be LifecycleOwner.");
    }

    public static final void setExecutorService(ThreadPoolExecutor r1) {
        o.g(r1, "executor");
        taskExecutor = r1;
    }

    public static final void setServiceManagerProxy(n r1) {
        o.g(r1, "proxy");
        h.f29a = r1;
    }

    @UiThread
    public static final void startDispatchDelayTask() {
        TaskConfig r0 = config;
        if (r0 == null) goto L13;
        r0.isDebug();
        a.b.a.a.k.f58h.j();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        if (INSTANCE.enableCatchException() == false) goto L12;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "START_DELAY_TASK_DISPATCHER");
        return;
    L12:
        throw e;
    L13:
        o.v("config");
        throw null;
    }

    @UiThread
    public static final void startDispatchIdleTask() {
        a.b.a.a.o.f88i.d();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        if (INSTANCE.enableCatchException() == false) goto L9;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "START_IDLE_TASK_DISPATCHER");
        return;
    L9:
        throw e;
    }

    public static final void unRegisterMainActivity$initscheduler_release() {
        WeakReference<Activity> r0 = mainActivityWR;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public static final void unRegisterSplashActivity$initscheduler_release() {
        WeakReference<Activity> r0 = splashActivityWR;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public final boolean enableCatchException() {
        TaskConfig r0 = config;
        if (r0 != null) goto L5;
        o.v("config");
        throw null;
    L5:
        return r0.getCatchException();
    }

    public final TaskConfig getConfig$initscheduler_release() {
        TaskConfig r0 = config;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.v("config");
        throw null;
    }

    public final ThreadPoolExecutor getExecutorService$initscheduler_release() {
        ThreadPoolExecutor r1 = taskExecutor;
        if (r1 == null) goto L8;
        if (r1 == null) goto L6;
        return r1;
    L6:
        o.p();
        throw null;
    L8:
        TaskConfig r2 = config;
        if (r2 == null) goto L15;
        ThreadPoolExecutor r3 = r2.getTaskExecutor();
        if (r3 == null) goto L13;
        return r3;
    L13:
        o.p();
        throw null;
    L15:
        o.v("config");
        throw null;
    }

    public final ThreadPoolExecutor getExecutorServiceOrNull$initscheduler_release() {
        ThreadPoolExecutor r1 = taskExecutor;
        if (r1 == null) goto L16;
        return r1;
    L16:
        TaskConfig r0 = config;     // Catch: Exception -> L13
        if (r0 == null) goto L11;
        return r0.getTaskExecutor();
    L11:
        o.v("config");     // Catch: Exception -> L13
        throw null;
    L13:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final String getINIT_SCHEDULER_CATEGORY$initscheduler_release() {
        return INIT_SCHEDULER_CATEGORY;
    }

    public final ProcessMatchMode getProcessMatchMode$initscheduler_release() {
        TaskConfig r0 = config;
        if (r0 != null) goto L5;
        o.v("config");
        throw null;
    L5:
        return r0.getMode();
    }

    public final boolean isDebug$initscheduler_release() {
        TaskConfig r0 = config;     // Catch: Exception -> L10
        if (r0 == null) goto L7;
        return r0.isDebug();
    L7:
        o.v("config");     // Catch: Exception -> L10
        throw null;
    L10:
        e = move-exception;
        e.printStackTrace();
        return true;
    }

    public final void setConfig$initscheduler_release(TaskConfig r1) {
        o.g(r1, "<set-?>");
        config = r1;
    }
}
