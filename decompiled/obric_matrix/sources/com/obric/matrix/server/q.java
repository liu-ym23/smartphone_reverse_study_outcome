package com.obric.matrix.server;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.w.b0;
import java.util.Objects;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.c0;
import kotlin.n0.d.d0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u000204J\u0006\u00106\u001a\u000204J\u000e\u00107\u001a\u0002042\u0006\u00108\u001a\u00020\u0017J,\u00109\u001a\u0002042\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010AJ6\u00109\u001a\u0002042\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020\u001dH\u0002J*\u00109\u001a\u0002042\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010B\u001a\u00020\u001dJ4\u0010C\u001a\u0002042\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020\u001dH\u0002J\b\u0010D\u001a\u000204H\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u0006E"}, d2 = {"Lcom/obric/matrix/server/ServerBrokerJniInner;", "", "()V", "bind", "Lcom/obric/matrix/platform/server/IServerBroker;", "getBind", "()Lcom/obric/matrix/platform/server/IServerBroker;", "setBind", "(Lcom/obric/matrix/platform/server/IServerBroker;)V", "bindLock", "Ljava/util/concurrent/locks/ReentrantLock;", "getBindLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "setBindLock", "(Ljava/util/concurrent/locks/ReentrantLock;)V", "bindLockCondition", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "getBindLockCondition", "()Ljava/util/concurrent/locks/Condition;", "setBindLockCondition", "(Ljava/util/concurrent/locks/Condition;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "delayReconnectTimeStep", "", "getDelayReconnectTimeStep", "()J", "setDelayReconnectTimeStep", "(J)V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "isBinding", "", "()Z", "setBinding", "(Z)V", "reConnectRunnable", "Ljava/lang/Runnable;", "getReConnectRunnable", "()Ljava/lang/Runnable;", "setReConnectRunnable", "(Ljava/lang/Runnable;)V", "checkInit", "", "checkReconnect", "connectBinder", "init", "ctx", "invokeAsync", "cmd", "", "seqId", "", "bytes", "", "callback", "Lcom/obric/matrix/platform/server/IServerCallback;", "callbackNativeFunc", "invokeAsyncInternal", "registerActivityLifecycle", "sdk_platform_server_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f9994a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f9995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Handler f9996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f9997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Runnable f9998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile com.obric.matrix.platform.e.a f9999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static ReentrantLock f10000g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Condition f10001h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f10002i;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/matrix/server/ServerBrokerJniInner$connectBinder$bindResult$1", "Landroid/content/ServiceConnection;", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "sdk_platform_server_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements ServiceConnection {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c0 f10003f;

        a(c0 r1) {
            this.f10003f = r1;
        }

        @Override // android.content.ServiceConnection
        @SuppressLint({"CheckResult"})
        public void onServiceConnected(ComponentName r6, IBinder r7) {
            kotlin.n0.d.o.f(r7, "service");
            com.obric.matrix.server.t.b.b.a("ServerBrokerJniInner", "onServiceConnected()");
            com.obric.matrix.server.t.a.a.f10008a.c(System.currentTimeMillis() - this.f10003f.f18430f);
            q r5 = q.f9994a;
            r5.u(com.obric.matrix.platform.e.a.AbstractBinderC0261a.a(r7));
            com.obric.matrix.platform.e.a r0 = r5.e();
            if (r0 == null) goto L9;
            r r1 = new r();
            Context r2 = r5.h();
            if (r2 == null) goto L7;
            String r3 = r2.getPackageName();
        L8:
            r0.s(r3, r1);
            StringBuilder r4 = new StringBuilder();
            r4.append("registerServerCallback for ");
            r4.append(Binder.getCallingPid());
            r4.append(" and binder is ");
            r1.asBinder();
            r4.append(r1);
            r4.append(" and service is ");
            r4.append(r7);
            com.obric.matrix.server.t.b.b.a("ServerBrokerJniInner", r4.toString());
            goto L9
        L7:
            r3 = null;
        L9:
            ReentrantLock r8 = r5.f();
            r8.lock();
            r5.g().signalAll();     // Catch: Throwable -> L13
            f0 r9 = f0.f18324a;     // Catch: Throwable -> L13
            r8.unlock();
            com.obric.matrix.server.t.a.c.f10010a.n();
            r5.v(false);
            return;
        L13:
            th = move-exception;
            r8.unlock();
            throw th;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r4) {
            kotlin.n0.d.o.f(r4, "name");
            com.obric.matrix.server.t.b.b.a("ServerBrokerJniInner", "onServiceDisconnected() ");
            com.obric.matrix.server.t.a.a.f10008a.a();
            q r3 = q.f9994a;
            r3.u(null);
            r3.j().postDelayed(r3.k(), r3.i());
            ReentrantLock r5 = r3.f();
            r5.lock();
            r3.g().signalAll();     // Catch: Throwable -> L6
            f0 r0 = f0.f18324a;     // Catch: Throwable -> L6
            r5.unlock();
            r3.v(false);
            return;
        L6:
            th = move-exception;
            r5.unlock();
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/server/ServerBrokerJniInner$invokeAsyncInternal$1", "Lcom/obric/matrix/platform/server/IServerCallback$Stub;", "onResult", "", "cmd", "", "resultBytes", "", "sdk_platform_server_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends com.obric.matrix.platform.e.b.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.obric.matrix.platform.e.b f10004f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f10005g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f10006h;

        b(com.obric.matrix.platform.e.b r1, String r2, long r3) {
            this.f10004f = r1;
            this.f10005g = r2;
            this.f10006h = r3;
        }

        public static /* synthetic */ void k(com.obric.matrix.platform.e.b r0, int r1, byte[] r2, String r3, long r4, d0 r6) {
            m(r0, r1, r2, r3, r4, r6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static final void m(com.obric.matrix.platform.e.b r1, int r2, byte[] r3, String r4, long r5, d0 r7) {
            kotlin.n0.d.o.f(r7, "$response");
            if (r1 == null) goto L5;
            r1.A(r2, r3);
        L6:
            o.f9992a.e((com.obric.matrix.w.d0) r7.f18431f);
            return;
        L5:
            ServerBrokerJni.onResponse(r2, r4, r3, r5);
            goto L6
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, com.obric.matrix.w.d0] */
        @Override // com.obric.matrix.platform.e.b
        public void A(final int r9, final byte[] r10) {
            if (r10 != null) goto L5;
            com.obric.matrix.server.t.b.b.c("ServerBrokerJniInner", "invokeAsyn resultBytes is null");
            return;
        L5:
            final d0 r7 = new d0();
            o r0 = o.f9992a;
            r7.f18431f = r0.g(r0.b(r10));
            final com.obric.matrix.platform.e.b r1 = this.f10004f;
            final String r4 = this.f10005g;
            final long r5 = this.f10006h;
            com.bytedance.common.utility.m.c.c(new m(r1, r9, r10, r4, r5, r7));
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"com/obric/matrix/server/ServerBrokerJniInner$registerActivityLifecycle$1", "Landroid/app/Application$ActivityLifecycleCallbacks;", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "sdk_platform_server_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c implements Application.ActivityLifecycleCallbacks {
        c() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r1, Bundle r2) {
            kotlin.n0.d.o.f(r1, "activity");
            q.f9994a.b();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r1) {
            kotlin.n0.d.o.f(r1, "activity");
            q.f9994a.b();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r1) {
            kotlin.n0.d.o.f(r1, "activity");
            q.f9994a.b();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r1) {
            kotlin.n0.d.o.f(r1, "activity");
            q.f9994a.b();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
            kotlin.n0.d.o.f(r1, "activity");
            kotlin.n0.d.o.f(r2, "outState");
            q.f9994a.b();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r1) {
            kotlin.n0.d.o.f(r1, "activity");
            q.f9994a.b();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r1) {
            kotlin.n0.d.o.f(r1, "activity");
            q.f9994a.b();
        }
    }

    static {
        f9994a = new q();
        f9996c = new Handler(Looper.getMainLooper());
        f9997d = WsConstants.EXIT_DELAY_TIME;
        f9998e = l.f9984f;
        ReentrantLock r0 = new ReentrantLock();
        f10000g = r0;
        f10001h = r0.newCondition();
    }

    private q() {
    }

    private static final void d() {
        q r0 = f9994a;
        Thread.sleep(f9997d);
        ReentrantLock r1 = f10000g;
        r1.lock();
        f10001h.signalAll();     // Catch: Throwable -> L8
        f0 r2 = f0.f18324a;     // Catch: Throwable -> L8
        r1.unlock();
        if (r0.e() != null) goto L13;
        f10002i = false;
        com.obric.matrix.server.t.a.a.f10008a.b("time out");
        return;
    L13:
        return;
    L8:
        th = move-exception;
        r1.unlock();
        throw th;
    }

    private final void o(int r10, String r11, byte[] r12, com.obric.matrix.platform.e.b r13, long r14) {
        com.obric.matrix.server.t.b.b.a("ServerBrokerJniInner", "invokeAsyn() called with: cmd = " + r10 + ", seqId = " + r11 + ", thread = " + Thread.currentThread());
        if (r12 != null) goto L7;
        String r9 = "invokeAsyn() bytes is null";
    L5:
        com.obric.matrix.server.t.b.b.a("ServerBrokerJniInner", r9);
        return;
    L7:
        o r0 = o.f9992a;
        byte[] r5 = b0.r.encode(r0.f(r0.a(r12)));
        if (e() != null) goto L18;
        com.obric.matrix.server.t.a.c.f10010a.m("matrix_third_invkoe_nobind", null);
        if (kotlin.n0.d.o.a(Looper.myLooper(), Looper.getMainLooper()) == false) goto L12;
        r9 = "main thread can not wait bind";
        goto L5
    L12:
        ReentrantLock r15 = f10000g;
        r15.lock();
        com.obric.matrix.server.t.b.b.a("ServerBrokerJniInner", "invokeAsyn() before wait");     // Catch: Throwable -> L15
        q r2 = f9994a;     // Catch: Throwable -> L15
        f10001h.await();     // Catch: Throwable -> L15
        com.obric.matrix.server.t.b.b.a("ServerBrokerJniInner", "invokeAsyn() by wait ");     // Catch: Throwable -> L15
        kotlin.n0.d.o.e(r5, "withMonitorInfoRequestBytes");     // Catch: Throwable -> L15
        r2.p(r10, r11, r5, r13, r14);     // Catch: Throwable -> L15
        f0 r16 = f0.f18324a;     // Catch: Throwable -> L15
        r15.unlock();
        return;
    L15:
        th = move-exception;
        r15.unlock();
        throw th;
    L18:
        com.obric.matrix.server.t.b.b.a("ServerBrokerJniInner", "invokeAsyn() has bind ");
        kotlin.n0.d.o.e(r5, "withMonitorInfoRequestBytes");
        p(r10, r11, r5, r13, r14);
    }

    private final void p(int r4, String r5, byte[] r6, com.obric.matrix.platform.e.b r7, long r8) {
        com.obric.matrix.platform.e.a r1 = e();     // Catch: Exception -> L7 DeadObjectException -> L9
        if (r1 == null) goto L14;
        r1.z(r4, r6, new b(r7, r5, r8));     // Catch: Exception -> L7 DeadObjectException -> L9
    L16:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        com.obric.matrix.server.t.b.b.d("ServerBrokerJniInner", "invokeAsyn DeadObjectException ", e);
        f9999f = null;
        c();
        return;
    L7:
        e = move-exception;
        com.obric.matrix.server.t.b.b.d("ServerBrokerJniInner", "invokeAsyn Exception ", e);
    }

    public static /* synthetic */ void q() {
        d();
    }

    public static /* synthetic */ void r() {
        s();
    }

    private static final void s() {
        f9994a.b();
    }

    private final void t() {
        Context r1 = f9995b;
        kotlin.n0.d.o.c(r1);
        Context r2 = r1.getApplicationContext();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.app.Application");
        ((Application) r2).registerActivityLifecycleCallbacks(new c());
    }

    public final void a() {
        if (f9995b == null) goto L6;
        return;
    L6:
        throw new RuntimeException("please call init first ");
    }

    public final void b() {
        if (e() != null) goto L6;
        c();
        return;
    }

    public final synchronized void c() {
        monitor-enter(this);
        a();     // Catch: Throwable -> L22
        if (e() == null) goto L6;
    L20:
        monitor-exit(this);
        return;
    L6:
        if (f10002i == true) goto L20;
        c0 r0 = new c0();     // Catch: Throwable -> L22
        r0.f18430f = System.currentTimeMillis();     // Catch: Throwable -> L22
        f10002i = true;     // Catch: Exception -> L15 Throwable -> L22
        Intent r3 = new Intent();     // Catch: Exception -> L15 Throwable -> L22
        r3.setComponent(new ComponentName("com.obric.matrix", "com.obric.matrix.server.MatrixServer"));     // Catch: Exception -> L15 Throwable -> L22
        Context r4 = f9995b;     // Catch: Exception -> L15 Throwable -> L22
        kotlin.n0.d.o.c(r4);     // Catch: Exception -> L15 Throwable -> L22
        boolean r1 = r4.bindService(r3, new a(r0), 1);     // Catch: Exception -> L15 Throwable -> L22
        com.obric.matrix.server.t.b.b.a("ServerBrokerJniInner", "initBinder: bindResult = " + r1);     // Catch: Exception -> L15 Throwable -> L22
        if (r1 == true) goto L13;
        com.obric.matrix.server.t.a.a.f10008a.b("bind failed");     // Catch: Exception -> L15 Throwable -> L22
        f10002i = false;     // Catch: Exception -> L15 Throwable -> L22
    L13:
        f9996c.postDelayed(f9998e, f9997d);     // Catch: Exception -> L15 Throwable -> L22
    L17:
        new Thread(k.f9983f).start();     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L15:
        e = move-exception;
        com.obric.matrix.server.t.a.a.f10008a.b("bind Exception e = " + e);     // Catch: Throwable -> L22
        f10002i = false;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public final com.obric.matrix.platform.e.a e() {
        a();
        return f9999f;
    }

    public final ReentrantLock f() {
        return f10000g;
    }

    public final Condition g() {
        return f10001h;
    }

    public final Context h() {
        return f9995b;
    }

    public final long i() {
        return f9997d;
    }

    public final Handler j() {
        return f9996c;
    }

    public final Runnable k() {
        return f9998e;
    }

    public final void l(Context r2) {
        kotlin.n0.d.o.f(r2, "ctx");
        f9995b = r2.getApplicationContext();
        c();
        t();
    }

    public final void m(int r8, String r9, byte[] r10, long r11) {
        o(r8, r9, r10, null, r11);
    }

    public final void n(int r8, String r9, byte[] r10, com.obric.matrix.platform.e.b r11) {
        o(r8, r9, r10, r11, 0);
    }

    public final void u(com.obric.matrix.platform.e.a r1) {
        f9999f = r1;
    }

    public final void v(boolean r1) {
        f10002i = r1;
    }
}
