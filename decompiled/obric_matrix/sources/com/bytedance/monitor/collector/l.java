package com.bytedance.monitor.collector;

import android.util.Pair;

/* JADX INFO: loaded from: classes.dex */
public class l extends b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5208f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f5209g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f5210h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    d.b.l.a.h.e f5211i;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ l f5212f;

        a(l r1) {
            this.f5212f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5212f.g();
        }
    }

    l(int r2) {
        super(r2, "proc_monitor");
        this.f5208f = 200;
        this.f5209g = 1000;
        this.f5210h = true;
        this.f5211i = d.b.l.a.h.c.e("collect-proc", new a(this));
    }

    public static long h(int r4) {
    L9:
        return -1;
    L4:
        if (k.p == true) goto L6;
        return -1;
    L6:
        return MonitorJni.doGetCpuTime(r4) * n.b();
    }

    public static void i() {
        if (k.p == true) goto L5;
        return;
    L5:
        MonitorJni.doInit();     // Catch: Throwable -> L7
        return;
    }

    @Override // com.bytedance.monitor.collector.b
    public synchronized Pair<String, String> a() {
        monitor-enter(this);
        if (k.p == true) goto L8;
        monitor-exit(this);
        return null;
    L8:
        Pair<String, String> r1 = new Pair(this.f5108a, MonitorJni.getProcInfos());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L12:
        return null;
    }

    @Override // com.bytedance.monitor.collector.b
    public synchronized Pair<String, String> b(long r4, long r6) {
        monitor-enter(this);
        if (k.p == true) goto L8;
        monitor-exit(this);
        return null;
    L8:
        Pair<String, String> r1 = new Pair(this.f5108a, MonitorJni.getProcInfoTimeRange(r4, r6));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L12:
        return null;
    }

    @Override // com.bytedance.monitor.collector.b
    public void d() {
        super.d();
        if (k.p == true) goto L6;
        return;
    L6:
        if (this.f5110c == 0) goto L20;
        boolean r0 = this.f5210h;     // Catch: Throwable -> L16
        if (r0 == false) goto L11;
        this.f5209g = 5000;     // Catch: Throwable -> L16
    L12:
        MonitorJni.keepProcHyperOpen(r0);     // Catch: Throwable -> L16
        MonitorJni.doStart();     // Catch: Throwable -> L16
        d.b.l.a.h.d r2 = this.f5112e;     // Catch: Throwable -> L16
        if (r2 == null) goto L21;
        r2.g(this.f5211i, 0, this.f5209g);     // Catch: Throwable -> L16
        return;
    L21:
        return;
    L11:
        this.f5209g = 1000;     // Catch: Throwable -> L16
        goto L12
    L20:
        return;
    }

    @Override // com.bytedance.monitor.collector.b
    public void e() {
        super.e();
        if (k.p == true) goto L6;
        return;
    L6:
        d.b.l.a.h.d r0 = this.f5112e;     // Catch: Throwable -> L11
        if (r0 == null) goto L9;
        r0.e(this.f5211i);     // Catch: Throwable -> L11
    L9:
        MonitorJni.doStop();     // Catch: Throwable -> L11
        return;
    }

    @Override // com.bytedance.monitor.collector.b
    protected void f(int r3) {
        if (k.p == true) goto L5;
        return;
    L5:
        e();     // Catch: Throwable -> L19
        if (r3 != 0) goto L8;
        return;
    L8:
        if (r3 != 1) goto L10;
        int r4 = 200;
        this.f5208f = 200;     // Catch: Throwable -> L19
    L15:
        this.f5209g = 1000;     // Catch: Throwable -> L19
        MonitorJni.setBufferSize(r4);     // Catch: Throwable -> L19
    L17:
        d();     // Catch: Throwable -> L19
        return;
    L10:
        if (r3 != 2) goto L12;
    L14:
        r4 = 400;
        this.f5208f = 400;     // Catch: Throwable -> L19
        goto L15
    L12:
        if (r3 == 3) goto L14;
    }

    public synchronized void g() {
        monitor-enter(this);
        if (k.p == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        MonitorJni.doCollect();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
    }
}
