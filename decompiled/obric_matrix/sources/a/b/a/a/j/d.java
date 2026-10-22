package a.b.a.a.j;

import a.b.a.a.n;
import android.annotation.SuppressLint;
import android.util.Log;
import android.util.Pair;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.services.apm.api.IApmAgent;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.h;
import kotlin.i;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"CI_ByteDanceKotlinRules_Static_Names"})
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ l[] f44a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<Pair<String, Long>> f45b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f46c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f47d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f48e = null;

    static final class a extends q implements kotlin.n0.c.a<IApmAgent> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f49f = null;

        static {
            f49f = new a();
        }

        public a() {
            super(0);
        }

        @Override // kotlin.n0.c.a
        public IApmAgent invoke() {
            o.g(IApmAgent.class, "clazz");
            n r0 = a.b.a.a.h.f29a;
            if (r0 == null) goto L5;
            Object r1 = ((a.b.a.a.h) r0).a(IApmAgent.class);
        L7:
            return (IApmAgent) r1;
        L5:
            r1 = com.bytedance.news.common.service.manager.d.a(IApmAgent.class);
            goto L7
        }
    }

    static {
        f44a = new l[]{e0.g(new y(e0.b(d.class), "iApmAgent", "getIApmAgent()Lcom/bytedance/services/apm/api/IApmAgent;"))};
        f48e = new d();
        f45b = new CopyOnWriteArrayList();
        f46c = i.b(a.f49f);
        f47d = -1;
    }

    public d() {
    }

    public final String a(boolean r1) {
        if (r1 == false) goto L4;
        return InitMonitor.MAIN;
    L4:
        return InitMonitor.ASYNC;
    }

    public final void b() {
        h r14 = f46c;
        l r0 = f44a[0];
        if (((IApmAgent) r14.getValue()) == null) goto L25;
        JSONObject r15 = new JSONObject();
        Iterator<T> r6 = f45b.iterator();     // Catch: Throwable -> L27
    L7:
        if (r6.hasNext() == false) goto L12;
        Pair r7 = (Pair) r6.next();     // Catch: Throwable -> L27
        String r8 = (String) r7.first;     // Catch: Throwable -> L27
        Object r9 = r7.second;     // Catch: Throwable -> L27
        o.b(r9, "it.second");     // Catch: Throwable -> L27
        r15.put(r8, ((Number) r9).longValue());     // Catch: Throwable -> L27
    L12:
        String r10 = "sendIdleTaskMonitor " + r15;
        o.g("IdleTaskMonitor", "classname");
        o.g(r10, "message");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L20;
        String r1 = b.a.a.a.a.b("IdleTaskMonitor", ' ', r10);
        int r2 = r1.length();
        int r3 = 3072;
        int r11 = 1;
        int r12 = 0;
    L16:
        if (r11 > 100) goto L20;
        if (r2 <= r3) goto L19;
        int r13 = b.a.a.a.a.a(r1, r12, r3, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r11), r3, 3072);
        r11 = r11 + 1;
        r12 = r3;
        r3 = r13;
        goto L16
    L19:
        b.a.a.a.a.f(r1, r12, r2, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r11));
    L20:
        JSONObject r4 = new JSONObject();
        r4.put("category", InitScheduler.INSTANCE.getINIT_SCHEDULER_CATEGORY$initscheduler_release());
        h r5 = f46c;
        l r16 = f44a[0];
        IApmAgent r17 = (IApmAgent) r5.getValue();
        if (r17 == null) goto L23;
        r17.monitorEvent("idle_task_monitor", r4, r15, new JSONObject());
    L23:
        f45b.clear();
        return;
    L25:
        o.g("IdleTaskMonitor", "classname");
        o.g("ServiceManager.getService(IApmAgent::class.java) is null.", "message");
        Log.e("#inittask#", "IdleTaskMonitor ServiceManager.getService(IApmAgent::class.java) is null.");
    }

    public final void c(long r1) {
        f47d = r1;
    }

    public final void d(String r2, long r3) {
        f45b.add(new Pair(r2, Long.valueOf(r3)));
    }

    public final void e(String r2, long r3, boolean r5) {
        o.g(r2, "taskId");
        d(a(r5) + "Task-" + r2, r3);
    }

    public final void f(String r5, boolean r6) {
        o.g(r5, "taskId");
        if (f47d <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        d(a(r6) + r5 + InitMonitor.TASK_END_SUFFIX, System.currentTimeMillis() - f47d);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void g(String r5, boolean r6) {
        o.g(r5, "taskId");
        if (f47d <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        d(a(r6) + r5 + InitMonitor.TASK_START_SUFFIX, System.currentTimeMillis() - f47d);
        return;
    L5:
        r0 = false;
        goto L6
    }
}
