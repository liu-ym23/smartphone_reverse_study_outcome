package d.b.b.f.c;

import android.os.Process;
import com.bytedance.apm.util.n;
import com.bytedance.common.utility.i;
import com.bytedance.monitor.collector.k;
import d.b.b.f.e.j;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class d extends d.b.b.n.g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f12761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f12762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d.b.b.o.o.a f12763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f12764d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f12765e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f12766f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f12767g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private d.b.b.f.d.a f12768h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private d.b.w.a.a.c f12769i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f12770j;

    class a extends d.b.b.o.o.a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ d f12771i;

        a(d r1, long r2, long r4) {
            this.f12771i = r1;
            super(r2, r4);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.bytedance.apm.d.C() == false) goto L5;
            d.b.b.o.m.b.a("APM-CPU", "run: " + d.d(this.f12771i));
        L5:
            d.e(this.f12771i, d.b.b.f.c.b.e().g());
            if (d.f(this.f12771i) == true) goto L8;
            d.h(this.f12771i);
            d.i(this.f12771i);
        L8:
            d.g(this.f12771i, false);
        }
    }

    class b implements Comparator<d.b.b.n.h.a.C0344a> {
        b(d r1) {
        }

        public int a(d.b.b.n.h.a.C0344a r5, d.b.b.n.h.a.C0344a r6) {
            return (int) ((r6.a() * 100.0d) - (r5.a() * 100.0d));
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(d.b.b.n.h.a.C0344a r1, d.b.b.n.h.a.C0344a r2) {
            return a(r1, r2);
        }
    }

    d(c r3, d.b.w.a.a.c r4) {
        this.f12770j = true;
        this.f12762b = new AtomicBoolean(false);
        this.f12761a = r3;
        this.f12769i = r4;
    }

    static /* synthetic */ long d(d r2) {
        return r2.f12764d;
    }

    static /* synthetic */ void e(d r0, boolean r1) {
        r0.n(r1);
    }

    static /* synthetic */ boolean f(d r0) {
        return r0.f12770j;
    }

    static /* synthetic */ boolean g(d r0, boolean r1) {
        r0.f12770j = r1;
        return r1;
    }

    static /* synthetic */ void h(d r0) {
        r0.j();
    }

    static /* synthetic */ void i(d r0) {
        r0.k();
    }

    private void j() {
        long r1 = System.currentTimeMillis();
        if ((r1 - this.f12766f) >= this.f12764d) goto L5;
        return;
    L5:
        this.f12766f = r1;
        int r3 = com.bytedance.apm.util.b.c();
        if (r3 > 0) goto L8;
        return;
    L8:
        long r4 = k.n().c();
        long r6 = k.n().k(r3);
        boolean r8 = false;
        Thread.sleep(360);     // Catch: InterruptedException -> L11
    L12:
        if (r8 == false) goto L14;
        return;
    L14:
        long r9 = k.n().c();
        double r12 = -1.0d;
        long r10 = k.n().k(r3) - r6;
        if (r10 <= 0) goto L17;
        r12 = (r9 - r4) / r10;
        com.bytedance.apm.x.a.b("MonitorCpu", "appCpuRate -> " + r12);
    L17:
        double r7 = (r9 - r4) * 1000.0d;
        double r5 = (r7 / (System.currentTimeMillis() - r1)) / com.bytedance.apm.util.b.j(100);
        if (com.bytedance.apm.d.C() == false) goto L21;
        d.b.b.o.m.b.a("APM-CPU", String.valueOf(r7) + " " + (System.currentTimeMillis() - r1) + " " + com.bytedance.apm.util.b.j(100));
    L21:
        if (com.bytedance.apm.d.C() == false) goto L23;
        com.bytedance.apm.x.a.b("MonitorCpu", "appCpuSpeed -> " + r5);
        d.b.b.o.m.b.a("APM-CPU", "collect cpu data, rate: " + r12 + " speed: " + r5);
    L23:
        d.b.w.a.a.c.a r2 = null;
        this.f12769i.g();     // Catch: Throwable -> L32
        r2 = this.f12769i.e();     // Catch: Throwable -> L32
    L26:
        if (this.f12761a.i() == false) goto L28;
        this.f12761a.d(r12, r5);
        this.f12761a.l(r2);
    L28:
        d.b.b.f.f.a.c().d(r12, r5);
        d.b.b.f.a.InterfaceC0333a r14 = d.b.b.f.c.b.e().d();
        if (r14 == null) goto L37;
        r14.a(r5, r12, d.b.b.m.a.c.a().e(), r2, i.j(com.bytedance.apm.d.h()));
        return;
    L37:
        return;
    L11:
        r8 = true;
        goto L12
    }

    private void k() {
        long r0 = System.currentTimeMillis();
        if ((r0 - this.f12767g) >= this.f12765e) goto L5;
        return;
    L5:
        this.f12767g = r0;
        HashMap r6 = new HashMap();
        HashMap r7 = new HashMap();
        boolean r1 = false;
        d.b.b.f.e.i.d(Process.myPid(), r6);
        Thread.sleep(100);     // Catch: InterruptedException -> L8
    L10:
        if (r1 == false) goto L12;
        return;
    L12:
        d.b.b.f.e.i.d(Process.myPid(), r7);
        d.b.w.a.a.c.a r2 = null;
        r2 = this.f12769i.e();     // Catch: Exception -> L16
    L14:
        l(0, r6, r7, r2);
        return;
    L8:
        e = move-exception;
        d.b.b.o.m.b.c("APM-CPU", "InterruptedException", e);
        r1 = true;
        goto L10
    }

    private void l(long r17, Map<Integer, j> r19, Map<Integer, j> r20, d.b.w.a.a.c.a r21) {
        if (r19.isEmpty() == false) goto L5;
        return;
    L5:
        if (r20.isEmpty() == true) goto L61;
        LinkedList r3 = new LinkedList();
        LinkedList<d.b.b.n.h.a.C0344a> r4 = new LinkedList();
        Iterator<Map.Entry<Integer, j>> r5 = r19.entrySet().iterator();
    L9:
        if (r5.hasNext() == false) goto L30;
        Map.Entry<Integer, j> r6 = r5.next();
        j r7 = r6.getValue();
        if (r7 == null) goto L9;
        j r8 = r20.get(r6.getKey());
        if (r8 == null) goto L9;
        if (r8.g().equals(r7.g()) == false) goto L9;
        long r9 = r8.e() - r7.e();
        if (r9 == 0) goto L9;
        d.b.b.o.m.b.a("APM-CPU", "cpu_thread=" + r8.g() + " thread_time=" + r9 + " app_time=" + r17);
        if (r17 == 0) goto L24;
        double r10 = r9 / r17;
        if (r10 <= 9.0E-4d) goto L9;
        r3.add(new n(r8.g(), Double.valueOf(String.format("%.3f", new Object[]{Double.valueOf(r10)}))));
        d.b.b.n.h.a.C0344a r11 = new d.b.b.n.h.a.C0344a(r8.g(), Double.valueOf(String.format("%.3f", new Object[]{Double.valueOf(r10)})).doubleValue(), r8.f());
    L25:
        r4.add(r11);
        goto L9
    L24:
        double r12 = r9;
        r3.add(new n(r8.g(), Double.valueOf(r12)));
        r11 = new d.b.b.n.h.a.C0344a(r8.g(), r12, r8.f());
        goto L25
    L30:
        if (r3.isEmpty() == false) goto L32;
        return;
    L32:
        Collections.sort(r4, new b(this));
        d.b.b.f.f.a.c().f(r4);
        if (this.f12768h.g() == true) goto L35;
        return;
    L35:
        if (d.b.b.f.c.b.e().g() == false) goto L37;
        d.b.b.f.c.a.EnumC0334a r1 = d.b.b.f.c.a.EnumC0334a.f12741g;
    L38:
        e r2 = new e(r1, d.b.b.m.a.c.a().e(), r3, r21);
        r2.j(d.i.c.c.b(com.bytedance.apm.d.h()));
        r2.k(this.f12769i.h());     // Catch: Throwable -> L42
    L40:
        d.b.b.l.a.d(r2);
        return;
    L37:
        r1 = d.b.b.f.c.a.EnumC0334a.f12742h;
        goto L38
    }

    private void m() {
        if (this.f12763c != null) goto L6;
        this.f12763c = new a(this, 30000, 30000);
        return;
    }

    private void n(boolean r3) {
        d.b.b.f.d.a r0 = this.f12768h;
        if (r3 == false) goto L5;
        long r1 = r0.c();
    L6:
        this.f12764d = r1;
        if (r3 == false) goto L9;
        long r2 = this.f12768h.d();
    L10:
        this.f12765e = r2;
        return;
    L9:
        r2 = this.f12768h.b();
        goto L10
    L5:
        r1 = r0.a();
        goto L6
    }

    void o(d.b.b.f.d.a r4) {
        if (this.f12762b.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.f12768h = r4;
        m();
        if (this.f12763c == null) goto L11;
        d.b.b.o.o.b.a(d.b.b.o.o.c.f13069i).c(this.f12763c);
    L11:
        this.f12769i.start();     // Catch: Throwable -> L10
        return;
    }
}
