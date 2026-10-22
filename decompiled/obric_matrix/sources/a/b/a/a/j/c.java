package a.b.a.a.j;

import a.b.a.a.h;
import a.b.a.a.n;
import android.util.Log;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.e.f;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.services.apm.api.IApmAgent;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.n0.d.o;
import kotlin.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f41a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<u<String, Long>> f42b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f43c = null;

    static {
        f43c = new c();
        f42b = new CopyOnWriteArrayList();
    }

    public c() {
    }

    public final void a() {
        f41a = System.currentTimeMillis();
    }

    public final void b(f r2, long r3, boolean r5) {
        o.g(r2, "taskInfo");
        if (r5 == false) goto L5;
        String r6 = "Main:Task-";
    L6:
        StringBuilder r7 = b.a.a.a.a.e(r6);
        r7.append(r2.f4883f);
        d(r7.toString(), r3);
        return;
    L5:
        r6 = "Async:Task-";
        goto L6
    }

    public final void c(f r5, boolean r6) {
        o.g(r5, "taskInfo");
        if (f41a > 0) goto L6;
        return;
    L6:
        if (r6 == false) goto L8;
        String r7 = InitMonitor.MAIN;
    L9:
        d(b.a.a.a.a.d(b.a.a.a.a.e(r7), r5.f4883f, "_TASKEND"), System.currentTimeMillis() - f41a);
        return;
    L8:
        r7 = InitMonitor.ASYNC;
        goto L9
    }

    public final void d(String r2, long r3) {
        f42b.add(new u(r2, Long.valueOf(r3)));
    }

    public final void e() {
        o.g(IApmAgent.class, "clazz");
        n r0 = h.f29a;
        if (r0 == null) goto L7;
        if (r0 == null) goto L6;
        Object r14 = ((h) r0).a(IApmAgent.class);
    L8:
        IApmAgent r15 = (IApmAgent) r14;
        if (r15 == null) goto L28;
        JSONObject r5 = new JSONObject();
        Iterator<T> r6 = f42b.iterator();     // Catch: Exception -> L16
    L13:
        if (r6.hasNext() == false) goto L18;
        u r7 = (u) r6.next();     // Catch: Exception -> L16
        r5.put((String) r7.c(), ((Number) r7.d()).longValue());     // Catch: Exception -> L16
    L18:
        String r8 = "sendTaskMonitor " + r5;
        o.g("FeedShowTaskMonitor", "classname");
        o.g(r8, "message");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L26;
        String r1 = b.a.a.a.a.b("FeedShowTaskMonitor", ' ', r8);
        int r2 = r1.length();
        int r4 = 3072;
        int r9 = 0;
        int r3 = 1;
    L22:
        if (r3 > 100) goto L26;
        if (r2 <= r4) goto L25;
        int r10 = b.a.a.a.a.a(r1, r9, r4, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r3), r4, 3072);
        r3 = r3 + 1;
        r9 = r4;
        r4 = r10;
        goto L22
    L25:
        b.a.a.a.a.f(r1, r9, r2, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r3));
    L26:
        r15.monitorEvent("feed_show_task_monitor", new JSONObject(), r5, new JSONObject());
        f42b.clear();
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    L28:
        o.g("FeedShowTaskMonitor", "classname");
        o.g("ServiceManager.getService(IApmAgent::class.java) is null.", "message");
        Log.e("#inittask#", "FeedShowTaskMonitor ServiceManager.getService(IApmAgent::class.java) is null.");
        return;
    L6:
        r14 = null;
        goto L8
    L7:
        r14 = com.bytedance.news.common.service.manager.d.a(IApmAgent.class);
        goto L8
    }

    public final void f(f r5, boolean r6) {
        o.g(r5, "taskInfo");
        if (f41a > 0) goto L6;
        return;
    L6:
        if (r6 == false) goto L8;
        String r7 = InitMonitor.MAIN;
    L9:
        d(b.a.a.a.a.d(b.a.a.a.a.e(r7), r5.f4883f, "_TASKSTART"), System.currentTimeMillis() - f41a);
        return;
    L8:
        r7 = InitMonitor.ASYNC;
        goto L9
    }
}
