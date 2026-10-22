package a.b.a.a;

import androidx.core.os.TraceCompat;
import androidx.lifecycle.Lifecycle;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.PeriodTaskManager$registerMain$1;
import com.bytedance.lego.init.PeriodTaskManager$registerSplash$1;
import com.bytedance.lego.init.monitor.InitMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.f0;

/* JADX INFO: loaded from: classes.dex */
public final class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<com.bytedance.lego.init.e.e, List<com.bytedance.lego.init.e.m>> f0a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f1b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f2c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final L f3d = null;

    static {
        f3d = new L();
        f0a = new LinkedHashMap();
    }

    public L() {
    }

    public static final /* synthetic */ void b(L r0, com.bytedance.lego.init.e.e r1, boolean r2) {
        r0.e(r1, r2);
    }

    public static /* synthetic */ void c(L r0, com.bytedance.lego.init.e.e r1, boolean r2, int r3) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.e(r1, r2);
    }

    public final void a() {
        List<com.bytedance.lego.init.e.m> r12 = com.bytedance.lego.init.d.c();
        kotlin.n0.d.o.b(r12, "TaskCollectorManager.getAllPeriodTaskInfo()");
        Iterator<T> r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L11;
        com.bytedance.lego.init.e.m r0 = (com.bytedance.lego.init.e.m) r13.next();
        Map<com.bytedance.lego.init.e.e, List<com.bytedance.lego.init.e.m>> r1 = f0a;
        kotlin.n0.d.o.b(r0, "taskInfo");
        List<com.bytedance.lego.init.e.m> r2 = r1.get(r0.a());
        if (r2 != null) goto L9;
        r2 = new ArrayList();
        com.bytedance.lego.init.e.e r3 = r0.a();
        kotlin.n0.d.o.b(r3, "taskInfo.executionPeriod");
        r1.put(r3, r2);
        f0 r4 = f0.f18324a;
    L9:
        r2.add(r0);
        goto L4
    L11:
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L44;
        StringBuilder r14 = new StringBuilder("------------------------------ AllPeriodTask --------------------------------\n");
        Iterator<Map.Entry<com.bytedance.lego.init.e.e, List<com.bytedance.lego.init.e.m>>> r5 = f0a.entrySet().iterator();
    L14:
        int r6 = 1;
        if (r5.hasNext() == false) goto L23;
        Map.Entry<com.bytedance.lego.init.e.e, List<com.bytedance.lego.init.e.m>> r7 = r5.next();
        if ((true ^ r7.getValue().isEmpty()) == false) goto L14;
        r14.append(r7.getKey().name() + ": ");
        Iterator<T> r8 = r7.getValue().iterator();
    L20:
        if (r8.hasNext() == false) goto L22;
        r14.append(((com.bytedance.lego.init.e.m) r8.next()).c() + ' ');
        goto L20
    L22:
        r14.append("\n");
        goto L14
    L23:
        String r15 = r14.toString();
        kotlin.n0.d.o.b(r15, "totalInfo.toString()");
        kotlin.n0.d.o.g("PeriodTaskManager", "classname");
        kotlin.n0.d.o.g(r15, "message");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L45;
        String r16 = b.a.a.a.a.b("PeriodTaskManager", ' ', r15);
        int r9 = r16.length();
        int r10 = 3072;
        int r11 = 0;
    L27:
        if (r6 > 100) goto L46;
        if (r9 <= r10) goto L31;
        int r17 = b.a.a.a.a.a(r16, r11, r10, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r6), r10, 3072);
        r6 = r6 + 1;
        r11 = r10;
        r10 = r17;
        goto L27
    L31:
        b.a.a.a.a.f(r16, r11, r9, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r6));
        return;
    L46:
        return;
    L45:
        return;
    }

    public final void d(Lifecycle r1) {
        kotlin.n0.d.o.g(r1, "lifecycle");
        r1.addObserver(new PeriodTaskManager$registerMain$1());
    }

    public final void e(com.bytedance.lego.init.e.e r24, boolean r25) {
        List<com.bytedance.lego.init.e.m> r0 = f0a.get(r24);
        if (r0 == null) goto L37;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L52;
        com.bytedance.lego.init.e.m r2 = (com.bytedance.lego.init.e.m) r1.next();
        int r12 = 1;
        if (r2.b().b() == true) goto L9;
        InitScheduler r3 = InitScheduler.INSTANCE;
        r3.getExecutorService$initscheduler_release().submit(r2.b());
        String r5 = "ASYNC " + r2.c() + " submit.";
        kotlin.n0.d.o.g("PeriodTaskManager", "classname");
        kotlin.n0.d.o.g(r5, "message");
        if (r3.isDebug$initscheduler_release() == false) goto L35;
        String r4 = b.a.a.a.a.b("PeriodTaskManager", ' ', r5);
        int r6 = r4.length();
        int r7 = 3072;
        int r14 = 0;
    L31:
        if (r12 > 100) goto L35;
        if (r6 <= r7) goto L34;
        int r8 = b.a.a.a.a.a(r4, r14, r7, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r12), r7, 3072);
        r12 = r12 + 1;
        r14 = r7;
        r7 = r8;
        goto L31
    L34:
        b.a.a.a.a.f(r4, r14, r6, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r12));
    L35:
        if (r25 == false) goto L6;
        InitMonitor.INSTANCE.monitor(r2.c() + "-SUBMIT");
        goto L6
    L9:
        long r13 = System.currentTimeMillis();
        String r9 = r2.c();
        kotlin.n0.d.o.b(r9, "taskInfo.taskId");
        kotlin.n0.d.o.g(r9, "message");
        InitScheduler r15 = InitScheduler.INSTANCE;
        if (r15.isDebug$initscheduler_release() == false) goto L13;
        TraceCompat.beginSection("Task:" + r9);
    L13:
        r2.b().run();
        if (r15.isDebug$initscheduler_release() == false) goto L17;
        TraceCompat.endSection();
    L17:
        StringBuilder r10 = b.a.a.a.a.e("UIThread ");
        r10.append(r2.c());
        r10.append(" done.");
        String r11 = r10.toString();
        kotlin.n0.d.o.g("PeriodTaskManager", "classname");
        kotlin.n0.d.o.g(r11, "message");
        if (r15.isDebug$initscheduler_release() == false) goto L25;
        String r16 = b.a.a.a.a.b("PeriodTaskManager", ' ', r11);
        int r17 = r16.length();
        int r18 = 1;
        int r19 = 3072;
        int r20 = 0;
    L21:
        if (r18 > 100) goto L25;
        if (r17 <= r19) goto L24;
        int r21 = b.a.a.a.a.a(r16, r20, r19, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r18), r19, 3072);
        r18 = r18 + 1;
        r20 = r19;
        r19 = r21;
        goto L21
    L24:
        b.a.a.a.a.f(r16, r20, r17, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r18));
    L25:
        if (r25 == false) goto L6;
        InitMonitor.INSTANCE.monitorCosTime(r2, System.currentTimeMillis() - r13, true);
        goto L6
    L52:
        return;
    }

    public final void f(Lifecycle r1) {
        kotlin.n0.d.o.g(r1, "lifecycle");
        r1.addObserver(new PeriodTaskManager$registerSplash$1());
    }
}
