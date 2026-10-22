package com.bytedance.lego.init.tasks;

import a.b.a.a.j.d;
import android.util.Log;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.e.b;
import com.bytedance.lego.init.monitor.InitMonitor;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.a;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\n\u001a\u00020\u0001\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/lego/init/tasks/IdleTaskProxy;", "Lcom/bytedance/lego/init/e/b;", "Lkotlin/f0;", "run", "()V", "Lkotlin/Function0;", "executeFinish", "Lkotlin/n0/c/a;", "getExecuteFinish", "()Lkotlin/n0/c/a;", "origin", "Lcom/bytedance/lego/init/e/b;", "", "taskId", "Ljava/lang/String;", "getTaskId", "()Ljava/lang/String;", "", "uiThread", "Z", "getUiThread", "()Z", "<init>", "(Lcom/bytedance/lego/init/e/b;Ljava/lang/String;ZLkotlin/n0/c/a;)V", "initscheduler_release"}, k = 1, mv = {1, 1, 15})
public final class IdleTaskProxy extends b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f4912f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f4913g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f4914h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a<f0> f4915i;

    public IdleTaskProxy(b r2, String r3, boolean r4, a<f0> r5) {
        o.g(r2, "origin");
        o.g(r3, "taskId");
        o.g(r5, "executeFinish");
        this.f4912f = r2;
        this.f4913g = r3;
        this.f4914h = r4;
        this.f4915i = r5;
    }

    @Override // java.lang.Runnable
    public void run() {
        long r5 = System.currentTimeMillis();     // Catch: Throwable -> L18
        d r7 = d.f48e;     // Catch: Throwable -> L18
        r7.g(this.f4913g, this.f4914h);     // Catch: Throwable -> L18
        this.f4912f.run();     // Catch: Throwable -> L18
        long r8 = System.currentTimeMillis();     // Catch: Throwable -> L18
        r7.f(this.f4913g, this.f4914h);     // Catch: Throwable -> L18
        long r9 = r8 - r5;     // Catch: Throwable -> L18
        r7.e(this.f4913g, r9, this.f4914h);     // Catch: Throwable -> L18
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L18
        r6.append(this.f4913g);     // Catch: Throwable -> L18
        r6.append(" end. cos ");     // Catch: Throwable -> L18
        r6.append(r9);     // Catch: Throwable -> L18
        r6.append(" ms.");     // Catch: Throwable -> L18
        String r10 = r6.toString();     // Catch: Throwable -> L18
        o.g("IdleTaskDispatcher", "classname");     // Catch: Throwable -> L18
        o.g(r10, "message");     // Catch: Throwable -> L18
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L22;
        String r11 = "IdleTaskDispatcher " + r10;     // Catch: Throwable -> L18
        int r12 = r11.length();     // Catch: Throwable -> L18
        int r13 = 0;
        int r14 = 3072;
        int r15 = 1;
    L12:
        if (r15 > 100) goto L22;
        if (r12 <= r14) goto L16;
        String r16 = r11.substring(r13, r14);     // Catch: Throwable -> L18
        o.b(r16, "(this as java.lang.Strin…ing(startIndex, endIndex)");     // Catch: Throwable -> L18
        Log.d("#inittask#" + r15, r16);     // Catch: Throwable -> L18
        r15 = r15 + 1;     // Catch: Throwable -> L18
        r13 = r14;
        r14 = r14 + 3072;     // Catch: Throwable -> L18
        goto L12
    L16:
        String r17 = r11.substring(r13, r12);     // Catch: Throwable -> L18
        o.b(r17, "(this as java.lang.Strin…ing(startIndex, endIndex)");     // Catch: Throwable -> L18
        Log.d("#inittask#" + r15, r17);     // Catch: Throwable -> L18
    L22:
        this.f4915i.invoke();
        return;
    L18:
        th = move-exception;
        th.printStackTrace();
        String r18 = "\nerror!error!error!  " + this.f4913g + " run error.\n";
        o.g("IdleTaskDispatcher", "classname");
        o.g(r18, "message");
        Log.e("#inittask#", "IdleTaskDispatcher " + r18);
        String r19 = Log.getStackTraceString(th);
        o.b(r19, "Log.getStackTraceString(e)");
        o.g("IdleTaskDispatcher", "classname");
        o.g(r19, "message");
        Log.e("#inittask#", "IdleTaskDispatcher " + r19);
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L24;
        InitMonitor r0 = InitMonitor.INSTANCE;
        StringBuilder r1 = b.a.a.a.a.e("RUN_IDLE_TASK_EXCEPTION:");
        r1.append(this.f4913g);
        r0.ensureNotReachHere(th, r1.toString());
        goto L22
    L24:
        throw th;
    }
}
