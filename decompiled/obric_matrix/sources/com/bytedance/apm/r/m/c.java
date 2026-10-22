package com.bytedance.apm.r.m;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile c f1882b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f1883c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile InterfaceC0059c f1884a;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f1885f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long[] f1886g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ c f1887h;

        a(c r1, long r2, long[] r4) {
            this.f1887h = r1;
            this.f1885f = r2;
            this.f1886g = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a(this.f1887h).c(this.f1885f, this.f1886g);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f1888f;

        b(c r1) {
            this.f1888f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a(this.f1888f).b();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.apm.r.m.c$c, reason: collision with other inner class name */
    public interface InterfaceC0059c {
        boolean a();

        void b();

        void c(long r1, long[] r3);
    }

    static {
    }

    private c() {
    }

    static /* synthetic */ InterfaceC0059c a(c r0) {
        return r0.f1884a;
    }

    public static c c() {
        if (f1882b != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1882b != null) goto L9;
        f1882b = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f1882b;
    }

    public void b(long[] r3, long r4) {
        if (this.f1884a != null) goto L6;
        return;
    L6:
        if (this.f1884a.a() == true) goto L10;
        e.A().o.b(new a(this, r4, r3));
        boolean r2 = true;
    L8:
        f1883c = r2;
        return;
    L10:
        if (f1883c == false) goto L13;
        e.A().o.b(new b(this));
        r2 = false;
        goto L8
    }
}
