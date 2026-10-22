package a.b.a.a;

import androidx.annotation.UiThread;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.e.l;
import com.bytedance.lego.init.monitor.InitMonitor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.f0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, l> f22a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<l> f23b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PriorityBlockingQueue<l> f24c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PriorityBlockingQueue<l> f25d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f26e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AtomicInteger f27f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f28g;

    public f() {
        this.f22a = new LinkedHashMap();
        this.f23b = new ArrayList();
        this.f24c = new PriorityBlockingQueue();
        this.f25d = new PriorityBlockingQueue();
        this.f26e = new Object();
        this.f27f = new AtomicInteger(0);
        this.f28g = "InitTaskManager";
    }

    @UiThread
    public final l a(long r2) {
        return this.f24c.poll(r2, TimeUnit.MILLISECONDS);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final l b(com.bytedance.lego.init.e.k r5) {
        kotlin.n0.d.o.g(r5, TypedValues.CycleType.S_WAVE_PERIOD);
        if (h() == true) goto L5;
        return null;
    L5:
        Iterator<l> r4 = this.f25d.iterator();
        kotlin.n0.d.o.b(r4, "nonUiReadyQueue.iterator()");
    L7:
        if (r4.hasNext() == false) goto L12;
        l r0 = r4.next();
        com.bytedance.lego.init.e.k r2 = r0.q;
        kotlin.n0.d.o.b(r2, "next.endPeriod");
        if (r2.a() > r5.a()) goto L7;
        r4.remove();
        return r0;
    L12:
        return null;
    }

    public final l c(String r2) {
        kotlin.n0.d.o.g(r2, "taskId");
        return this.f22a.get(r2);
    }

    public final void d() {
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.f27f.get() == this.f22a.size()) goto L24;
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L18
        r0.put("count", this.f27f.get() - this.f22a.size());     // Catch: Exception -> L18
        r0.put("undispatchCount", this.f23b.size());     // Catch: Exception -> L18
        Iterator<T> r1 = this.f23b.iterator();     // Catch: Exception -> L18
    L10:
        if (r1.hasNext() == false) goto L14;
        r0.put(((l) r1.next()).f4899f, "task");     // Catch: Exception -> L18
        goto L10
    L14:
        InitMonitor r2 = InitMonitor.INSTANCE;     // Catch: Exception -> L18
        a.b.a.a.j.a r3 = a.b.a.a.j.a.f32h;     // Catch: Exception -> L18
        String r5 = String.valueOf(this.f27f.get() - this.f22a.size());     // Catch: Exception -> L18
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L18
        r4.put("task_count_exception", r0);     // Catch: Exception -> L18
        r2.monitorEvent(r3, r5, r4);     // Catch: Exception -> L18
        return;
    }

    public final void e(l r13) {
        String r0 = this.f28g;
        StringBuilder r1 = b.a.a.a.a.e("letTaskReady: ");
        r1.append(r13.f4899f);
        String r2 = r1.toString();
        kotlin.n0.d.o.g(r0, "classname");
        kotlin.n0.d.o.g(r2, "message");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L13;
        String r3 = b.a.a.a.a.b(r0, ' ', r2);
        int r4 = r3.length();
        int r5 = 0;
        int r6 = 3072;
        int r11 = 1;
    L6:
        int r7 = r5;
        r5 = r6;
        if (r11 > 100) goto L13;
        if (r4 <= r5) goto L11;
        r6 = b.a.a.a.a.a(r3, r7, r5, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r11), r5, 3072);
        r11 = r11 + 1;
        goto L6
    L11:
        b.a.a.a.a.f(r3, r7, r4, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r11));
    L13:
        if (r13.f4903j == false) goto L15;
        PriorityBlockingQueue<l> r8 = this.f24c;
    L16:
        r8.add(r13);
        this.f23b.remove(r13);
        return;
    L15:
        r8 = this.f25d;
        goto L16
    }

    public final float f(String r2) {
        kotlin.n0.d.o.g(r2, "taskId");
        l r1 = this.f22a.get(r2);
        if (r1 != null) goto L7;
        return -1.0f;
    L7:
        return r1.m;
    }

    public final void g(l r6) {
        kotlin.n0.d.o.g(r6, "task");
        Object r0 = this.f26e;
        monitor-enter(r0);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (r6.t == false) goto L9;
        monitor-exit(r0);
        return;
    L9:
        r6.t = true;     // Catch: Throwable -> L30
        this.f27f.getAndIncrement();     // Catch: Throwable -> L30
        List<String> r1 = r6.n;     // Catch: Throwable -> L30
        if (r1 == null) goto L28;
        Iterator<T> r2 = r1.iterator();     // Catch: Throwable -> L30
    L13:
        if (r2.hasNext() == false) goto L27;
        String r3 = (String) r2.next();     // Catch: Throwable -> L30
        l r4 = this.f22a.get(r3);     // Catch: Throwable -> L30
        if (r4 == null) goto L13;
        if (this.f23b.contains(r4) == false) goto L13;
        List<String> r5 = r4.p;     // Catch: Throwable -> L30
        if (r5 == null) goto L22;
        r5.remove(r6.f4899f);     // Catch: Throwable -> L30
    L22:
        List<String> r7 = r4.p;     // Catch: Throwable -> L30
        if (r7 == null) goto L26;
        if (r7.isEmpty() == false) goto L13;
    L26:
        e(r4);     // Catch: Throwable -> L30
        goto L13
    L27:
        f0 r8 = f0.f18324a;     // Catch: Throwable -> L30
    L28:
        monitor-exit(r0);
    }

    public final boolean h() {
        Object r0 = this.f26e;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L6:
        if ((!this.f25d.isEmpty()) == false) goto L9;
        monitor-exit(r0);
        return true;
    L9:
        Iterator<T> r3 = this.f23b.iterator();     // Catch: Throwable -> L19
    L11:
        if (r3.hasNext() == false) goto L16;
        if (((l) r3.next()).f4903j == true) goto L11;
        monitor-exit(r0);
        return true;
    L16:
        monitor-exit(r0);
        return false;
    }

    public final List<String> i(String r3) {
        kotlin.n0.d.o.g(r3, "taskId");
        ArrayList r0 = new ArrayList();
        Object r1 = this.f26e;
        monitor-enter(r1);
        l r2 = this.f22a.get(r3);     // Catch: Throwable -> L11
        if (r2 == null) goto L9;
        List<String> r4 = r2.p;     // Catch: Throwable -> L11
        kotlin.n0.d.o.b(r4, "it.dependencies");     // Catch: Throwable -> L11
        r0.addAll(r4);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r1);
        return r0;
    L11:
        th = move-exception;
        throw th;
    }

    public final void j() {
        long r0 = System.currentTimeMillis();
        Map<String, l> r2 = com.bytedance.lego.init.d.g();
        kotlin.n0.d.o.b(r2, "TaskCollectorManager.getInitTaskIndexs()");
        this.f22a = r2;
        a.b.a.a.l.b r3 = a.b.a.a.l.b.f72a;
        StringBuilder r4 = b.a.a.a.a.e("collect cos: ");
        r4.append(System.currentTimeMillis() - r0);
        r4.append("ms  size: ");
        r4.append(this.f22a.size());
        a.b.a.a.l.b.a(r3, null, r4.toString(), 1);
        InitMonitor.INSTANCE.monitorCosTime("InitTaskManager.CollectTasks", System.currentTimeMillis() - r0, false);
        this.f23b.addAll(this.f22a.values());
        Collection<l> r5 = this.f22a.values();
        if (r5 == null) goto L12;
        Iterator<T> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L12;
        l r7 = (l) r6.next();
        List<String> r8 = r7.p;
        if (r8 == null) goto L11;
        if (r8.isEmpty() == false) goto L6;
    L11:
        e(r7);
    L12:
        d.u.e(this.f22a.isEmpty());
        InitMonitor.INSTANCE.monitorCosTime("InitTaskManager.init", System.currentTimeMillis() - r0, false);
    }
}
