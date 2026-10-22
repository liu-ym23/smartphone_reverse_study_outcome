package com.bytedance.apm.f0;

import android.annotation.SuppressLint;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f1504h = 30000;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static long f1505i = 30000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile ExecutorService f1506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f1507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d.b.l.a.h.d f1508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.b.l.a.h.e f1509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.b.l.a.h.e f1510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    CopyOnWriteArraySet<e> f1511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    CopyOnWriteArraySet<e> f1512g;

    class a implements d.b.l.a.h.e {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f1513f;

        a(b r1) {
            this.f1513f = r1;
        }

        @Override // d.b.l.a.h.e
        public d.b.l.a.h.b S() {
            return d.b.l.a.h.b.f14114h;
        }

        @Override // d.b.l.a.h.e
        public String X() {
            return "AsyncEventManager-mTimerRunnable";
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator<e> r0 = this.f1513f.f1511f.iterator();
        L4:
            if (r0.hasNext() == false) goto L7;
            r0.next().onTimeEvent(System.currentTimeMillis());
            goto L4
        L7:
            if (b.a(this.f1513f) == false) goto L11;
            this.f1513f.j(this, b.f1504h);
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.apm.f0.b$b, reason: collision with other inner class name */
    class C0044b implements d.b.l.a.h.e {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f1514f;

        C0044b(b r1) {
            this.f1514f = r1;
        }

        @Override // d.b.l.a.h.e
        public d.b.l.a.h.b S() {
            return d.b.l.a.h.b.f14114h;
        }

        @Override // d.b.l.a.h.e
        public String X() {
            return "AsyncEventManager-mControlledTimerRunnable";
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator<e> r0 = this.f1514f.f1512g.iterator();
        L4:
            if (r0.hasNext() == false) goto L7;
            r0.next().onTimeEvent(System.currentTimeMillis());
            goto L4
        L7:
            if (b.a(this.f1514f) == false) goto L11;
            this.f1514f.j(this, b.b());
            return;
        }
    }

    class c implements ThreadFactory {
        c(b r1) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r2) {
            return new Thread(r2, "Apm_Normal");
        }
    }

    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f1515a = null;

        static {
            f1515a = new b(null);
        }
    }

    public interface e {
        void onTimeEvent(long r1);
    }

    static {
    }

    private b() {
        this.f1507b = true;
        this.f1509d = new a(this);
        this.f1510e = new C0044b(this);
        this.f1511f = new CopyOnWriteArraySet();
        this.f1512g = new CopyOnWriteArraySet();
        this.f1508c = d.b.l.a.h.c.a();
    }

    /* synthetic */ b(a r1) {
        this();
    }

    static /* synthetic */ boolean a(b r0) {
        return r0.f1507b;
    }

    static /* synthetic */ long b() {
        return f1505i;
    }

    public static b f() {
        return d.f1515a;
    }

    private d.b.l.a.h.e q(Runnable r2, String r3) {
        return d.b.l.a.h.c.e("AsyncEventManager-" + r3, r2);
    }

    public void c(e r3) {
        if (r3 == null) goto L12;
        if (this.f1507b == true) goto L6;
        return;
    L6:
        if (this.f1511f.contains(r3) == true) goto L14;
        this.f1511f.add(r3);     // Catch: Throwable -> L9
        l(this.f1509d);     // Catch: Throwable -> L9
        j(this.f1509d, f1504h);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L15:
        return;
    }

    public void d(Runnable r3) {
        d.b.l.a.h.d r0 = this.f1508c;
        if (r0 == null) goto L8;
        if (r3 == null) goto L9;
        r0.c(q(r3, "post"));
        return;
    L9:
        return;
    }

    public void e(d.b.l.a.h.e r1, long r2) {
        d.b.l.a.h.d r0 = this.f1508c;
        if (r0 == null) goto L8;
        if (r1 == null) goto L9;
        r0.h(r1, r2);
        return;
    L9:
        return;
    }

    public boolean g() {
        if (this.f1508c != null) goto L5;
    L7:
        return false;
    L5:
        if (Thread.currentThread().getId() != this.f1508c.i(d.b.l.a.h.b.f14114h)) goto L7;
        return true;
    }

    public void h(ExecutorService r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        monitor-enter(this);
        this.f1506a = r2;     // Catch: Throwable -> L10
        d.b.l.a.h.d r0 = this.f1508c;     // Catch: Throwable -> L10
        if (r0 == null) goto L8;
        r0.d(r2);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void i(Runnable r3) {
        if (this.f1508c == null) goto L10;
        if (r3 != null) goto L6;
        return;
    L6:
        if (this.f1507b == false) goto L12;
        this.f1508c.c(q(r3, "post"));
        return;
    L12:
        return;
    }

    public void j(d.b.l.a.h.e r2, long r3) {
        if (this.f1508c == null) goto L10;
        if (r2 != null) goto L6;
        return;
    L6:
        if (this.f1507b == false) goto L12;
        this.f1508c.h(r2, r3);
        return;
    L12:
        return;
    }

    public void k(Runnable r3, long r4) {
        if (this.f1508c == null) goto L10;
        if (r3 != null) goto L6;
        return;
    L6:
        if (this.f1507b == false) goto L12;
        this.f1508c.h(q(r3, "postDelayed"), r4);
        return;
    L12:
        return;
    }

    public void l(d.b.l.a.h.e r1) {
        d.b.l.a.h.d r0 = this.f1508c;
        if (r0 == null) goto L8;
        if (r1 == null) goto L9;
        r0.e(r1);
        return;
    L9:
        return;
    }

    public void m(e r1) {
        if (r1 == null) goto L8;
        this.f1511f.remove(r1);     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public void n() {
        this.f1507b = true;
        if (this.f1511f.isEmpty() == true) goto L6;
        l(this.f1509d);
        j(this.f1509d, f1504h);
    L6:
        if (this.f1512g.isEmpty() == true) goto L9;
        l(this.f1510e);
        j(this.f1510e, f1505i);
        return;
    }

    public void o() {
        this.f1507b = false;
        l(this.f1509d);
        l(this.f1510e);
    }

    @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
    public void p(Runnable r3) {
        if (this.f1506a != null) goto L17;
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L6:
        if (this.f1506a != null) goto L12;
        d.b.l.a.h.d r0 = this.f1508c;     // Catch: Throwable -> L14
        if (r0 == null) goto L11;
        ExecutorService r1 = r0.f();     // Catch: Throwable -> L14
    L10:
        this.f1506a = r1;     // Catch: Throwable -> L14
        goto L12
    L11:
        r1 = Executors.newFixedThreadPool(1, new c(this));     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
    L17:
        this.f1506a.submit(r3);
    }
}
