package com.bytedance.sync.v2.compensate;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.bytedance.sync.v2.f.k;
import d.b.u.l;
import d.b.u.w.m;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
final class CompensatorImpl implements m, LifecycleObserver, com.bytedance.sync.v2.compensate.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f5872f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final l<Handler> f5873g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final k f5874h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final d.b.u.e f5875i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile d.b.u.b0.a f5876j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile com.bytedance.sync.v2.compensate.d f5877k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f5878l;
    private final AtomicBoolean m;
    private final AtomicBoolean n;
    private final Runnable o;

    class a extends l<Handler> {
        a(CompensatorImpl r1) {
        }

        @Override // d.b.u.l
        protected /* bridge */ /* synthetic */ Handler a(Object[] r1) {
            return c(r1);
        }

        protected Handler c(Object... r1) {
            return new Handler(((d.b.u.w.e) com.ss.android.ug.bus.b.a(d.b.u.w.e.class)).get());
        }
    }

    class b implements com.bytedance.sync.v2.f.g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.bytedance.sync.v2.h.c f5879f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ CompensatorImpl f5880g;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ com.bytedance.sync.v2.g.a f5881f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ b f5882g;

            a(b r1, com.bytedance.sync.v2.g.a r2) {
                this.f5882g = r1;
                this.f5881f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f5882g.f5879f.W(this.f5881f);
            }
        }

        b(CompensatorImpl r1, com.bytedance.sync.v2.h.c r2) {
            this.f5880g = r1;
            this.f5879f = r2;
        }

        @Override // com.bytedance.sync.v2.f.g
        public void W(com.bytedance.sync.v2.g.a r4) {
            r4.f5948d = new com.bytedance.sync.v2.h.b(CompensatorImpl.b(this.f5880g), CompensatorImpl.d(this.f5880g));
            d.b.u.z.a.a(new a(this, r4));
        }

        @Override // com.bytedance.sync.v2.f.g
        public boolean c() {
            return false;
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d.b.u.b0.a f5883f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ CompensatorImpl f5884g;

        c(CompensatorImpl r1, d.b.u.b0.a r2) {
            this.f5884g = r1;
            this.f5883f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            CompensatorImpl.e(this.f5884g, this.f5883f);
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ CompensatorImpl f5885f;

        d(CompensatorImpl r1) {
            this.f5885f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.u.b0.a r0 = d.b.u.b0.b.g(CompensatorImpl.f(this.f5885f)).f();
            d.b.u.b0.b.g(CompensatorImpl.f(this.f5885f)).d(this.f5885f);
            CompensatorImpl.e(this.f5885f, r0);
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ CompensatorImpl f5886f;

        e(CompensatorImpl r1) {
            this.f5886f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            ProcessLifecycleOwner.get().getLifecycle().addObserver(this.f5886f);     // Catch: Exception -> L4
            return;
        L4:
            d.b.u.x.b.b("there is something wrong when add life cycle Observer,maybe someone add addObserver in work thread");
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ CompensatorImpl f5887f;

        f(CompensatorImpl r1) {
            this.f5887f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            ProcessLifecycleOwner.get().getLifecycle().removeObserver(this.f5887f);     // Catch: Exception -> L4
            return;
        L4:
            d.b.u.x.b.b("there is something wrong when add life cycle Observer,maybe someone add addObserver in work thread");
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ CompensatorImpl f5888f;

        g(CompensatorImpl r1) {
            this.f5888f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            CompensatorImpl.c(this.f5888f, false);
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ CompensatorImpl f5889f;

        h(CompensatorImpl r1) {
            this.f5889f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            CompensatorImpl.c(this.f5889f, true);
        }
    }

    public CompensatorImpl(Context r3, d.b.u.e r4, com.bytedance.sync.v2.f.i r5) {
        this.m = new AtomicBoolean(false);
        this.n = new AtomicBoolean(false);
        this.o = new d(this);
        this.f5872f = r3;
        this.f5875i = r4;
        this.f5873g = new a(this);
        this.f5874h = new com.bytedance.sync.v2.j.m(new b(this, new com.bytedance.sync.v2.h.c(r3, r4, r5, null)));
    }

    static /* synthetic */ boolean b(CompensatorImpl r0) {
        return r0.f5878l;
    }

    static /* synthetic */ boolean c(CompensatorImpl r0, boolean r1) {
        r0.f5878l = r1;
        return r1;
    }

    static /* synthetic */ com.bytedance.sync.v2.compensate.d d(CompensatorImpl r0) {
        return r0.f5877k;
    }

    static /* synthetic */ void e(CompensatorImpl r0, d.b.u.b0.a r1) {
        r0.n(r1);
    }

    static /* synthetic */ Context f(CompensatorImpl r0) {
        return r0.f5872f;
    }

    private com.bytedance.sync.v2.compensate.d g(boolean r9) {
        if (r9 == false) goto L6;
        return new j(this, this.f5874h, this.f5875i);
    L6:
        return new com.bytedance.sync.v2.compensate.b(this, this.f5873g, this.f5874h, false, true);
    }

    private boolean i() {
        return this.m.get();
    }

    private void k() {
        e r0 = new e(this);
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        r0.run();
        return;
    L5:
        new Handler(Looper.getMainLooper()).post(r0);
    }

    private void n(d.b.u.b0.a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        d.b.u.b0.a r0 = this.f5876j;
        com.bytedance.sync.v2.compensate.d r1 = this.f5877k;
        if (r0 == null) goto L18;
        if (r1 == null) goto L18;
        if (this.f5876j.o() == false) goto L13;
        if (r3.o() == true) goto L13;
    L16:
        r1.destroy();
    L13:
        if (this.f5876j.o() == false) goto L15;
    L17:
        r1.d(r3);
    L19:
        this.f5876j = r3;
        this.n.set(true);
        return;
    L15:
        if (r3.o() == false) goto L17;
    L18:
        com.bytedance.sync.v2.compensate.d r2 = g(r3.o());
        r2.c(r3, i());
        this.f5877k = r2;
        goto L19
    }

    private void o() {
        f r0 = new f(this);
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        r0.run();
        return;
    L5:
        new Handler(Looper.getMainLooper()).post(r0);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onAppBackground() {
        d.b.u.x.b.a("[Compensator] startCompensate ON_STOP");
        this.f5873g.b(new Object[0]).post(new g(this));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void onAppForeground() {
        d.b.u.x.b.a("[Compensator] startCompensate ON_START");
        this.f5873g.b(new Object[0]).post(new h(this));
    }

    @Override // d.b.u.w.m
    public void a(d.b.u.w.i.a r3) {
        d.b.u.b0.a r4 = d.b.u.b0.b.g(this.f5872f).f();
        this.f5873g.b(new Object[0]).post(new c(this, r4));
    }

    public void h() {
        this.f5873g.b(new Object[0]).removeCallbacksAndMessages(null);
        d.b.u.b0.b.g(this.f5872f).h(this);
        o();
        if (this.f5877k == null) goto L6;
        this.f5877k.destroy();
        this.f5877k = null;
        return;
    }

    @Override // com.bytedance.sync.v2.compensate.c
    public boolean isForeground() {
        return this.f5878l;
    }

    public void j() {
        this.m.set(true);
        if (i() == true) goto L5;
        return;
    L5:
        if (this.f5877k == null) goto L8;
        this.f5877k.b();
        return;
    L8:
        if (this.f5873g.b(new Object[0]).hasCallbacks(this.o) == false) goto L13;
        d.b.u.x.b.a("[Compensator] reset start delay task and run right now");
        this.f5873g.b(new Object[0]).removeCallbacks(this.o);
        this.f5873g.b(new Object[0]).post(this.o);
        return;
    }

    public void l(com.bytedance.sync.v2.j.e r2) {
        if (this.n.get() == true) goto L5;
        return;
    L5:
        if (this.f5877k == null) goto L9;
        this.f5877k.a(r2);
        return;
    }

    public void m() {
        k();
        d.b.u.b0.a r0 = d.b.u.b0.b.g(this.f5872f).f();
        StringBuilder r1 = new StringBuilder();
        r1.append("[Compensator] start compensator. compensator will run after ");
        long r4 = 1000;
        r1.append((r0.g() * 1000) + 1000);
        r1.append("ms");
        d.b.u.x.b.a(r1.toString());
        Handler r2 = this.f5873g.b(new Object[0]);
        Runnable r6 = this.o;
        if (r0.o() == false) goto L5;
        r4 = 1000 + (r0.g() * 1000);
    L5:
        r2.postDelayed(r6, r4);
    }
}
