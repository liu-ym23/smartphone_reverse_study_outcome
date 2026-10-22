package com.bytedance.applog.x;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.bytedance.applog.util.n;
import com.bytedance.applog.util.p;
import com.bytedance.lego.init.IdleTaskConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile com.bytedance.applog.x.a f2465l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f2467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f2469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bytedance.applog.x.d f2470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Handler f2471f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.bytedance.applog.x.b f2472g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<com.bytedance.applog.x.d> f2473h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f2474i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Runnable f2475j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Runnable f2476k;

    class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f2477a;

        a(c r1, Looper r2) {
            this.f2477a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r4) {
            super.handleMessage(r4);
            boolean r1 = true;
            if (r4.what == 1) goto L6;
            return;
        L6:
            if (c.a(this.f2477a) == null) goto L19;
            Object r5 = r4.obj;
            if ((r5 instanceof String) == false) goto L19;
            String r6 = (String) r5;
            boolean r0 = p.f(r6, c.a(this.f2477a).g());
            if (c.c(this.f2477a) == true) goto L12;
        L14:
            r1 = false;
        L15:
            if (r0 == false) goto L19;
            if (r1 == false) goto L19;
            c.a(this.f2477a).n(System.currentTimeMillis());
            c.m(this.f2477a).i(c.a(this.f2477a));
            c.n(this.f2477a, r6);
            c.o(this.f2477a);
            return;
        L12:
            if (c.k(this.f2477a) == false) goto L14;
        L19:
            c.m(this.f2477a).c();
            c.o(this.f2477a);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f2478f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f2479g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ c f2480h;

        b(c r1, long r2, String r4) {
            this.f2480h = r1;
            this.f2478f = r2;
            this.f2479g = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.a("[task] onExitBg");
            if (c.c(this.f2480h) == false) goto L18;
            c.f(this.f2480h, false);
            com.bytedance.applog.x.e.d().h(c.p(this.f2480h));
            com.bytedance.applog.x.e.d().h(c.q(this.f2480h));
            c.r(this.f2480h);
            c.m(this.f2480h).c();
            if (c.s(this.f2480h) == true) goto L7;
        L16:
            c.h(this.f2480h);
            return;
        L7:
            if ((this.f2478f - c.d(this.f2480h)) > 30000) goto L10;
            n.d("[task] time diff is less than 30000 , so clear current session", null);
            c.g(this.f2480h).clear();
            c.b(this.f2480h, null);
            goto L16
        L10:
            if (c.a(this.f2480h) == null) goto L15;
            n.d("[task] close current session", null);
            if (c.k(this.f2480h) == false) goto L14;
            c.a(this.f2480h).l(this.f2479g);
            c.a(this.f2480h).n(this.f2478f);
        L14:
            c.m(this.f2480h).h(c.a(this.f2480h));
            c.b(this.f2480h, null);
        L15:
            c.p(this.f2480h).run();
            goto L16
        }
    }

    /* JADX INFO: renamed from: com.bytedance.applog.x.c$c, reason: collision with other inner class name */
    class RunnableC0077c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f2481f;

        RunnableC0077c(c r1) {
            this.f2481f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder r0 = new StringBuilder();
            r0.append("[task] closeCurrentSession currentSession is null : ");
            if (c.a(this.f2481f) != null) goto L5;
            boolean r1 = true;
        L6:
            r0.append(r1);
            n.a(r0.toString());
            if (c.a(this.f2481f) != null) goto L9;
            n.h("[task] closeCurrentSession found that currentSession is null", null);
            return;
        L9:
            if (c.i(this.f2481f) == false) goto L11;
            n.d("[task] is fired : so save session to Db", null);
            c.m(this.f2481f).h(c.a(this.f2481f));
        L12:
            c.b(this.f2481f, null);
            c.m(this.f2481f).c();
            return;
        L11:
            n.d("[task] is not fired : so save session in pendingSessions", null);
            c.g(this.f2481f).add(c.a(this.f2481f));
            goto L12
        L5:
            r1 = false;
            goto L6
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f2482f;

        d(c r1) {
            this.f2482f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.j(this.f2482f, true);
            n.d("[task] fire pending Sessions", null);
            Iterator r0 = new ArrayList(c.g(this.f2482f)).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            com.bytedance.applog.x.d r1 = (com.bytedance.applog.x.d) r0.next();
            c.m(this.f2482f).h(r1);
            goto L4
        L6:
            c.g(this.f2482f).clear();
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f2483f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ c f2484g;

        e(c r1, long r2) {
            this.f2484g = r1;
            this.f2483f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.k(this.f2484g) == false) goto L11;
            n.a("[task] onTaskPause");
            c.l(this.f2484g, false);
            if (c.c(this.f2484g) == true) goto L7;
            return;
        L7:
            if (c.a(this.f2484g) == null) goto L9;
            n.d("[task] wait 15000 to close current session", null);
            c.a(this.f2484g).n(this.f2483f);
            com.bytedance.applog.x.e.d().i(c.q(this.f2484g), IdleTaskConfig.IDLE_START_TIME_OUT);
            c.m(this.f2484g).i(c.a(this.f2484g));
            c.r(this.f2484g);
            return;
        L9:
            n.h("[task] onTaskPause when bg, but no session available", null);
            return;
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f2485f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f2486g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ c f2487h;

        f(c r1, long r2, String r4) {
            this.f2487h = r1;
            this.f2485f = r2;
            this.f2486g = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.a("[task] onEnterBg");
            if (c.c(this.f2487h) == true) goto L11;
            c.h(this.f2487h);
            com.bytedance.applog.x.e.d().i(c.p(this.f2487h), 30010);
            c.e(this.f2487h, this.f2485f);
            c.f(this.f2487h, true);
            if (c.k(this.f2487h) == false) goto L12;
            c.t(this.f2487h, true);
            if (c.a(this.f2487h) == null) goto L9;
            n.h("[task] enter bg , bug there is already a bg task is running", null);
        L9:
            n.d("[task] task is running , so create a new task session", null);
            c.b(this.f2487h, new com.bytedance.applog.x.d(this.f2485f));
            c.a(this.f2487h).m(this.f2486g);
            c r4 = this.f2487h;
            c.n(r4, c.a(r4).g());
            return;
        L12:
            return;
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f2488f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ c f2489g;

        g(c r1, long r2) {
            this.f2489g = r1;
            this.f2488f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.k(this.f2489g) == true) goto L15;
            n.a("[task] onTaskResume");
            c.l(this.f2489g, true);
            if (c.c(this.f2489g) == false) goto L16;
            c.t(this.f2489g, true);
            if (c.a(this.f2489g) != null) goto L11;
            n.d("[task] pure bg launch , so create a new task session", null);
            c r0 = this.f2489g;
            com.bytedance.applog.x.d r1 = new com.bytedance.applog.x.d(this.f2488f);
        L9:
            c.b(r0, r1);
            c.m(this.f2489g).c();
        L10:
            c r7 = this.f2489g;
            c.n(r7, c.a(r7).g());
            return;
        L11:
            long r4 = this.f2488f - c.a(this.f2489g).f();
            if (r4 > IdleTaskConfig.IDLE_START_TIME_OUT) goto L14;
            n.d("[task] task time diff " + r4 + " , is less than " + IdleTaskConfig.IDLE_START_TIME_OUT + " so , merge in previous session", null);
            com.bytedance.applog.x.e.d().h(c.q(this.f2489g));
            c.a(this.f2489g).a(r4);
            c.a(this.f2489g).n(this.f2488f);
            c.m(this.f2489g).i(c.a(this.f2489g));
            goto L10
        L14:
            n.d("[task] task time diff " + r4 + " , is bigger than " + IdleTaskConfig.IDLE_START_TIME_OUT + " so close current session and create new session", null);
            com.bytedance.applog.x.e.d().h(c.q(this.f2489g));
            c.q(this.f2489g).run();
            r0 = this.f2489g;
            r1 = new com.bytedance.applog.x.d(this.f2488f);
            goto L9
        L16:
            return;
        }
    }

    public c(Context r4, com.bytedance.applog.w.b r5, com.bytedance.applog.q.c r6) {
        this.f2466a = false;
        this.f2467b = false;
        this.f2468c = true;
        this.f2469d = System.currentTimeMillis();
        this.f2473h = new ArrayList();
        this.f2474i = false;
        this.f2475j = new RunnableC0077c(this);
        this.f2476k = new d(this);
        r4.getApplicationContext();
        this.f2472g = new com.bytedance.applog.x.b(r4, r5, r6);
    }

    private void C(String r3) {
        Handler r2 = x();
        r2.removeMessages(1);
        r2.sendMessageDelayed(Message.obtain(r2, 1, r3), CoroutineLiveDataKt.DEFAULT_TIMEOUT);
    }

    private void D() {
        com.bytedance.applog.x.a r0 = f2465l;
        if (r0 == null) goto L11;
        boolean r1 = r0.a();
        if (this.f2467b == r1) goto L12;
        n.d("[task] tryCorrectTaskState newIsTaskRunning : " + r1, null);
        if (r1 == false) goto L9;
        B();
        return;
    L9:
        A();
        return;
    L12:
        return;
    }

    static /* synthetic */ com.bytedance.applog.x.d a(c r0) {
        return r0.f2470e;
    }

    static /* synthetic */ com.bytedance.applog.x.d b(c r0, com.bytedance.applog.x.d r1) {
        r0.f2470e = r1;
        return r1;
    }

    static /* synthetic */ boolean c(c r0) {
        return r0.f2468c;
    }

    static /* synthetic */ long d(c r2) {
        return r2.f2469d;
    }

    static /* synthetic */ long e(c r0, long r1) {
        r0.f2469d = r1;
        return r1;
    }

    static /* synthetic */ boolean f(c r0, boolean r1) {
        r0.f2468c = r1;
        return r1;
    }

    static /* synthetic */ List g(c r0) {
        return r0.f2473h;
    }

    static /* synthetic */ void h(c r0) {
        r0.v();
    }

    static /* synthetic */ boolean i(c r0) {
        return r0.f2474i;
    }

    static /* synthetic */ boolean j(c r0, boolean r1) {
        r0.f2474i = r1;
        return r1;
    }

    static /* synthetic */ boolean k(c r0) {
        return r0.f2467b;
    }

    static /* synthetic */ boolean l(c r0, boolean r1) {
        r0.f2467b = r1;
        return r1;
    }

    static /* synthetic */ com.bytedance.applog.x.b m(c r0) {
        return r0.f2472g;
    }

    static /* synthetic */ void n(c r0, String r1) {
        r0.C(r1);
    }

    static /* synthetic */ void o(c r0) {
        r0.D();
    }

    static /* synthetic */ Runnable p(c r0) {
        return r0.f2476k;
    }

    static /* synthetic */ Runnable q(c r0) {
        return r0.f2475j;
    }

    static /* synthetic */ void r(c r0) {
        r0.u();
    }

    static /* synthetic */ boolean s(c r0) {
        return r0.f2466a;
    }

    static /* synthetic */ boolean t(c r0, boolean r1) {
        r0.f2466a = r1;
        return r1;
    }

    private void u() {
        x().removeMessages(1);
    }

    private void v() {
        this.f2466a = false;
        this.f2473h.clear();
        this.f2474i = false;
    }

    private Handler w() {
        return new a(this, com.bytedance.applog.x.e.d().getLooper());
    }

    private Handler x() {
        if (this.f2471f != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f2471f != null) goto L8;
        this.f2471f = w();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f2471f;
    }

    public void A() {
        long r0 = System.currentTimeMillis();
        com.bytedance.applog.x.e.d().a(new e(this, r0));
    }

    public void B() {
        long r0 = System.currentTimeMillis();
        com.bytedance.applog.x.e.d().a(new g(this, r0));
    }

    public void y(long r3, String r5) {
        com.bytedance.applog.x.e.d().a(new f(this, r3, r5));
    }

    public void z(long r3, String r5) {
        com.bytedance.applog.x.e.d().a(new b(this, r3, r5));
    }
}
