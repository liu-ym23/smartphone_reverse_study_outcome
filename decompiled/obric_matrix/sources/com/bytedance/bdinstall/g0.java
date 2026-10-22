package com.bytedance.bdinstall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
class g0 implements Handler.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final i0 f2756f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.bytedance.bdinstall.z0.k f2757g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Handler f2758h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.bytedance.bdinstall.w0.b f2759i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private r f2760j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AtomicBoolean f2761k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private s0 f2762l;
    private com.bytedance.bdinstall.c m;
    private final e n;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g0 f2763f;

        a(g0 r1) {
            this.f2763f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g0.a(this.f2763f).compareAndSet(false, true) == false) goto L6;
            g0.d(this.f2763f, new com.bytedance.bdinstall.c(g0.b(this.f2763f), g0.c(this.f2763f)));
            return;
        }
    }

    class b implements com.bytedance.bdinstall.w0.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f2764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ g0 f2765b;

        b(g0 r1, Runnable r2) {
            this.f2765b = r1;
            this.f2764a = r2;
        }

        @Override // com.bytedance.bdinstall.w0.b.a
        public void onResume() {
            g0.e(this.f2765b).c(null);
            q.a("dispatcher#active onResume");
            t.e(this.f2764a);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g0 f2766f;

        c(g0 r1) {
            this.f2766f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            g0.f(this.f2766f).x();
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f2767f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ g0 f2768g;

        class a implements e.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f2769a;

            a(d r1) {
                this.f2769a = r1;
            }

            @Override // com.bytedance.bdinstall.g0.e.c
            public void a() {
                if (g0.h(this.f2769a.f2768g).hasMessages(1235, this.f2769a.f2767f) == false) goto L5;
                g0.h(this.f2769a.f2768g).removeMessages(1235, this.f2769a.f2767f);
                g0.h(this.f2769a.f2768g).obtainMessage(1235, this.f2769a.f2767f).sendToTarget();
                q.a("on net ready. do " + this.f2769a.f2767f + " again");
            L5:
                this.f2769a.f2767f.j(null);
                g0.g(this.f2769a.f2768g).h(this);
                q.g("remove observer " + this.f2769a.f2767f + ", " + this);
            }
        }

        d(g0 r1, j r2) {
            this.f2768g = r1;
            this.f2767f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g0.b(this.f2768g).R() == false) goto L20;
            e.c r0 = this.f2767f.c();
            if (r0 == null) goto L7;
            this.f2767f.j(null);
            g0.g(this.f2768g).h(r0);
            q.g("remove observer " + this.f2767f + ", " + r0);
        L7:
            j.a r1 = this.f2767f.m();
            if (this.f2767f.e() == false) goto L14;
            if (q.b() == false) goto L27;
            q.a("worker ends after init " + this.f2767f);
            return;
        L27:
            return;
        L14:
            if (r1.f2813a == false) goto L16;
        L22:
            g0.h(this.f2768g).sendMessageDelayed(g0.h(this.f2768g).obtainMessage(1235, this.f2767f), r1.f2815c);
            return;
        L16:
            if (this.f2767f.f() == false) goto L22;
            if (r1.f2814b != 1) goto L22;
            a r2 = new a(this);
            this.f2767f.j(r2);
            g0.g(this.f2768g).f(r2);
            goto L22
        L20:
            r1 = this.f2767f.m();
            if (this.f2767f.e() == false) goto L22;
            if (q.b() == false) goto L29;
            q.a("worker ends after init " + this.f2767f);
            return;
        }
    }

    static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set<WeakReference<c>> f2770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicBoolean f2771b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Context f2772c;

        class a extends BroadcastReceiver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f2773a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ e f2774b;

            a(e r1) {
                this.f2774b = r1;
                this.f2773a = true;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context r2, Intent r3) {
                if (this.f2773a == false) goto L6;
                this.f2773a = false;
                return;
            L6:
                if (r3 != null) goto L11;
                String r1 = "intent is null when receive net change event";
            L8:
                q.a(r1);
                return;
            L11:
                if (r3.getBooleanExtra("noConnectivity", false) == false) goto L14;
                r1 = "no connectivity";
                goto L8
            L14:
                if (com.bytedance.bdinstall.d1.i.a(e.c(this.f2774b)) == false) goto L17;
                e.d(this.f2774b);
                return;
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ e f2775f;

            b(e r1) {
                this.f2775f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator r1 = new ArrayList(e.b(this.f2775f)).iterator();
            L4:
                if (r1.hasNext() == false) goto L8;
                c r0 = (c) ((WeakReference) r1.next()).get();
                if (r0 == null) goto L4;
                r0.a();
                goto L4
            }
        }

        interface c {
            void a();
        }

        public e(Context r3) {
            this.f2770a = Collections.synchronizedSet(new HashSet());
            this.f2771b = new AtomicBoolean(false);
            this.f2772c = r3;
        }

        @Proxy("registerReceiver")
        @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
        @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
        public static Intent a(Context r1, BroadcastReceiver r2, IntentFilter r3) {
            return r1.registerReceiver(r2, r3);
        L4:
            e = move-exception;
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
            throw e;
        L8:
            return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
        }

        static /* synthetic */ Set b(e r0) {
            return r0.f2770a;
        }

        static /* synthetic */ Context c(e r0) {
            return r0.f2772c;
        }

        static /* synthetic */ void d(e r0) {
            r0.e();
        }

        private void e() {
            t.e(new b(this));
        }

        private void g() {
            if (this.f2771b.compareAndSet(false, true) == false) goto L10;
            a r0 = new a(this);
            IntentFilter r1 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            a(this.f2772c, r0, r1);     // Catch: Exception -> L7
            return;
        L11:
            return;
        }

        public synchronized void f(c r3) {
            monitor-enter(this);
            this.f2770a.add(new WeakReference(r3));     // Catch: Throwable -> L6
            g();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized void h(c r3) {
            monitor-enter(this);
            Iterator<WeakReference<c>> r0 = this.f2770a.iterator();     // Catch: Throwable -> L14
        L5:
            if (r0.hasNext() == false) goto L12;
            WeakReference<c> r1 = r0.next();     // Catch: Throwable -> L14
            if (r1 == null) goto L8;
            if (r1.get() != r3) goto L5;
            r0.remove();     // Catch: Throwable -> L14
            goto L12
        L8:
            r0.remove();     // Catch: Throwable -> L14
        L12:
            monitor-exit(this);
            return;
        L14:
            th = move-exception;
            throw th;
        }
    }

    g0(i0 r3, com.bytedance.bdinstall.z0.k r4, com.bytedance.bdinstall.w0.b r5, r r6) {
        this.f2761k = new AtomicBoolean(false);
        this.f2756f = r3;
        this.f2757g = r4;
        this.f2759i = r5;
        this.f2758h = new Handler(t.c(), this);
        this.f2760j = r6;
        this.n = new e(r3.t());
    }

    static /* synthetic */ AtomicBoolean a(g0 r0) {
        return r0.f2761k;
    }

    static /* synthetic */ i0 b(g0 r0) {
        return r0.f2756f;
    }

    static /* synthetic */ r c(g0 r0) {
        return r0.f2760j;
    }

    static /* synthetic */ void d(g0 r0, com.bytedance.bdinstall.c r1) {
        r0.j(r1);
    }

    static /* synthetic */ com.bytedance.bdinstall.w0.b e(g0 r0) {
        return r0.f2759i;
    }

    static /* synthetic */ com.bytedance.bdinstall.z0.k f(g0 r0) {
        return r0.f2757g;
    }

    static /* synthetic */ e g(g0 r0) {
        return r0.n;
    }

    static /* synthetic */ Handler h(g0 r0) {
        return r0.f2758h;
    }

    private void i() {
        if (this.f2756f.N() == true) goto L5;
        return;
    L5:
        a r0 = new a(this);
        this.f2759i.c(new b(this, r0));
        if (this.f2756f.Q() == false) goto L9;
    L7:
        q.a("dispatcher#active isActive");
        r0.run();
        return;
    L9:
        if (this.f2759i.b() == true) goto L7;
    }

    private void j(com.bytedance.bdinstall.c r4) {
        q.a("dispatcher#activeImmediately");
        this.f2761k.set(true);
        com.bytedance.bdinstall.c r0 = this.m;
        if (r0 == null) goto L6;
        if (r4 == null) goto L6;
        r0.l();
        this.f2758h.removeMessages(1235, this.m);
    L6:
        this.m = r4;
        r(r4);
    }

    private boolean l(j r4) {
        if (this.f2756f.U() == true) goto L5;
        return false;
    L5:
        if (this.f2759i.isForeground() == false) goto L7;
        return false;
    L7:
        if (q.b() == false) goto L9;
        q.a("skip work " + r4 + " cause user set silent in bg.");
    L9:
        Handler r3 = this.f2758h;
        r3.sendMessageDelayed(r3.obtainMessage(1235, r4), r4.k());
        return true;
    }

    private void o(r r5, boolean r6) {
        t.g(new c(this));
        if (this.f2757g.s() == false) goto L14;
        s0 r0 = new s0(this.f2756f, this.f2757g, r5, this.f2759i);
        com.bytedance.bdinstall.x0.b.b(new com.bytedance.bdinstall.x0.g.a(this.f2757g.g()));
        if (r6 == false) goto L7;
    L12:
        r0.i();
    L13:
        q(r0);
        this.f2762l = r0;
        return;
    L7:
        if (this.f2757g.r() == true) goto L12;
        if (this.f2757g.q() == true) goto L12;
        if (this.f2757g.p() == false) goto L13;
    L14:
        this.f2758h.removeMessages(1234);
        Handler r4 = this.f2758h;
        r4.sendMessageDelayed(r4.obtainMessage(1234, Boolean.valueOf(r6)), 1000);
    }

    private void q(j r2) {
        t.g(new d(this, r2));
    }

    @AnyThread
    private void r(j r2) {
        s(r2, false);
    }

    @AnyThread
    private void s(j r3, boolean r4) {
        Handler r0 = this.f2758h;
        if (r0 == null) goto L12;
        if (r3 == null) goto L13;
        r0.removeMessages(1235, r3);
        Handler r1 = this.f2758h;
        r3.i();
        Message r5 = r1.obtainMessage(1235, r3);
        if (r4 == true) goto L8;
    L10:
        this.f2758h.sendMessage(r5);
        return;
    L8:
        if (Looper.myLooper() != this.f2758h.getLooper()) goto L10;
        handleMessage(r5);
        return;
    L13:
        return;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message r3) {
        int r0 = r3.what;
        if (r0 != 1234) goto L5;
        o(this.f2760j, ((Boolean) r3.obj).booleanValue());
        return false;
    L5:
        if (r0 != 1235) goto L18;
        j r4 = (j) r3.obj;
        if (l(r4) == false) goto L11;
        return false;
    L11:
        if (r4.e() == true) goto L16;
        q(r4);
        return false;
    L16:
        return false;
    L18:
        return false;
    }

    boolean k(r r2, boolean r3) {
        if (this.f2760j.equals(r2) == false) goto L6;
        return false;
    L6:
        this.f2760j = r2;
        this.f2757g.c(r2, r3);
        return true;
    }

    boolean m(r r3, boolean r4, boolean r5) {
        if (k(r3, r5) == true) goto L7;
        if (r4 == true) goto L7;
        q.c("the env is the same with before,ignore." + r3);
        return false;
    L7:
        this.f2758h.removeMessages(1235);
        this.f2757g.z();
        if (this.f2758h.hasMessages(1234) == false) goto L10;
        this.f2758h.removeMessages(1234);
        Handler r2 = this.f2758h;
        r2.sendMessage(r2.obtainMessage(1234, Boolean.TRUE));
        return true;
    L10:
        s0 r6 = new s0(this.f2756f, this.f2757g, r3, this.f2759i);
        r(r6);
        this.f2762l = r6;
        if (this.f2756f.N() == true) goto L13;
        return true;
    L13:
        if (this.f2761k.get() == false) goto L19;
        j(new com.bytedance.bdinstall.c(this.f2756f, r3));
        return true;
    L19:
        return true;
    }

    @AnyThread
    void n() {
        s0 r0 = this.f2762l;
        if (r0 == null) goto L6;
        s(r0, true);
        return;
    }

    void p(boolean r2) {
        o(this.f2760j, r2);
        i();
    }
}
