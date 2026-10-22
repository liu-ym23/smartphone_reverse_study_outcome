package com.bytedance.common.wschannel.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.SystemClock;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.model.IntegerParcelable;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.o;
import com.bytedance.common.wschannel.server.WsChannelService;
import java.lang.ref.WeakReference;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes.dex */
public class l implements k {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f3505g = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f3506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f3507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f3508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WeakReference<Context> f3509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Messenger f3510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinkedBlockingDeque<k.a> f3511f;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ l f3512f;

        a(l r1) {
            this.f3512f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            l r0 = this.f3512f;
            if (r0.f3510e != null) goto L6;
            l.i(r0, 1, SystemClock.uptimeMillis() - l.h(this.f3512f));
            return;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f3513f;

        b(l r1, Context r2) {
            this.f3513f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3513f.startService(new Intent(this.f3513f, WsChannelService.class));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f3514f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f3515g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ l f3516h;

        c(l r1, Context r2, boolean r3) {
            this.f3516h = r1;
            this.f3514f = r2;
            this.f3515g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3514f != null) goto L6;
            return;
        L6:
            if (l.j(this.f3516h) != null) goto L8;
        L9:
            l.k(this.f3516h, new WeakReference(this.f3514f.getApplicationContext()));
        L19:
            ComponentName r0 = new ComponentName(this.f3514f, WsChannelService.class);     // Catch: Throwable -> L16
            k.a r1 = new k.a();     // Catch: Throwable -> L16
            if (this.f3515g == false) goto L13;
            int r2 = 9;
        L14:
            r1.f3504c = r2;     // Catch: Throwable -> L16
            l.l(this.f3516h).offer(r1);     // Catch: Throwable -> L16
            l.m(this.f3516h, r0);     // Catch: Throwable -> L16
            return;
        L13:
            r2 = 11;
        L16:
            th = move-exception;
            th.printStackTrace();
            return;
        L8:
            if (l.j(this.f3516h).get() != null) goto L19;
            goto L9
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f3517f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f3518g;

        d(l r1, Context r2, int r3) {
            this.f3517f = r2;
            this.f3518g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentName r0 = new ComponentName(this.f3517f, WsChannelService.class);     // Catch: Throwable -> L4
            Intent r1 = new Intent(WsConstants.APP_STATE_ACTION);     // Catch: Throwable -> L4
            r1.setComponent(r0);     // Catch: Throwable -> L4
            r1.putExtra(WsConstants.KEY_APP_STATE, this.f3518g);     // Catch: Throwable -> L4
            this.f3517f.startService(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    class e implements ServiceConnection {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ l f3519f;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ ComponentName f3520f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ e f3521g;

            a(e r1, ComponentName r2) {
                this.f3521g = r1;
                this.f3520f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                l.m(this.f3521g.f3519f, this.f3520f);
            }
        }

        e(l r1) {
            this.f3519f = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r5, IBinder r6) {
            if (r5 == null) goto L18;
            if (r6 != null) goto L6;
            return;
        L6:
            if (Logger.debug() == false) goto L17;
            Logger.d("WsChannelSdk", "onServiceConnected name = " + r5.toString() + ", " + l.q());
        L17:
            this.f3519f.f3510e = new Messenger(r6);     // Catch: Throwable -> L13
            if (l.q() == false) goto L11;
            com.bytedance.common.utility.m.c.c(new a(this, r5));     // Catch: Throwable -> L13
        L15:
            l.p(this.f3519f, SystemClock.uptimeMillis());
            l.i(this.f3519f, 0, SystemClock.uptimeMillis() - l.h(this.f3519f));
            return;
        L11:
            l.m(this.f3519f, r5);     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            th.printStackTrace();
            goto L15
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r6) {
            if (r6 != null) goto L5;
            return;
        L5:
            if (Logger.debug() == false) goto L13;
            Logger.d("WsChannelSdk", "onServiceDisconnected name = " + r6.toString());
        L13:
            l r0 = this.f3519f;     // Catch: Throwable -> L9
            r0.f3510e = null;     // Catch: Throwable -> L9
            l.l(r0).clear();     // Catch: Throwable -> L9
            l.n(this.f3519f, r6);     // Catch: Throwable -> L9
        L11:
            l.i(this.f3519f, 2, SystemClock.uptimeMillis() - l.o(this.f3519f));
            return;
        L9:
            th = move-exception;
            th.printStackTrace();
            goto L11
        }
    }

    static {
    }

    public l() {
        this.f3506a = new a(this);
        this.f3507b = 0;
        this.f3508c = 0;
        this.f3511f = new LinkedBlockingDeque();
    }

    private void A() {
        this.f3507b = SystemClock.uptimeMillis();
        if (WsConstants.getBindWsChannelServiceListener() != null) goto L5;
        return;
    L5:
        com.bytedance.common.wschannel.h.b().a().postDelayed(this.f3506a, BDLocationConfig.sScanBleMaxInterval);
    }

    private void B(Context r2, boolean r3) {
        com.bytedance.common.utility.m.c.c(new c(this, r2, r3));
    }

    private void C(Context r3, int r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        WeakReference<Context> r0 = this.f3509d;
        if (r0 != null) goto L7;
    L8:
        this.f3509d = new WeakReference(r3.getApplicationContext());
    L10:
        if (Logger.debug() == false) goto L17;
        Logger.d("WsChannelSdk", "unregister channelId = " + r4);
    L17:
        ComponentName r1 = new ComponentName(r3, WsChannelService.class);     // Catch: Throwable -> L14
        k.a r5 = new k.a();     // Catch: Throwable -> L14
        r5.f3502a = WsConstants.KEY_WS_APP;     // Catch: Throwable -> L14
        r5.f3503b = new IntegerParcelable(r4);     // Catch: Throwable -> L14
        r5.f3504c = 1;     // Catch: Throwable -> L14
        this.f3511f.offer(r5);     // Catch: Throwable -> L14
        r(r1);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L7:
        if (r0.get() != null) goto L10;
        goto L8
    }

    static /* synthetic */ long h(l r2) {
        return r2.f3507b;
    }

    static /* synthetic */ void i(l r0, int r1, long r2) {
        r0.t(r1, r2);
    }

    static /* synthetic */ WeakReference j(l r0) {
        return r0.f3509d;
    }

    static /* synthetic */ WeakReference k(l r0, WeakReference r1) {
        r0.f3509d = r1;
        return r1;
    }

    static /* synthetic */ LinkedBlockingDeque l(l r0) {
        return r0.f3511f;
    }

    static /* synthetic */ void m(l r0, ComponentName r1) {
        r0.r(r1);
    }

    static /* synthetic */ void n(l r0, ComponentName r1) {
        r0.v(r1);
    }

    static /* synthetic */ long o(l r2) {
        return r2.f3508c;
    }

    static /* synthetic */ long p(l r0, long r1) {
        r0.f3508c = r1;
        return r1;
    }

    static /* synthetic */ boolean q() {
        return f3505g;
    }

    private synchronized void r(ComponentName r2) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f3510e != null) goto L6;
        s(r2);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        u(r2);     // Catch: Throwable -> L9
        goto L7
    }

    private void s(ComponentName r4) {
        WeakReference<Context> r0 = this.f3509d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.get() == null) goto L24;
        Context r1 = r0.get();
        if (Logger.debug() == false) goto L10;
        Logger.d("WsChannelSdk", "doBindService");
    L10:
        if (r4 != null) goto L21;
        return;
    L21:
        Intent r2 = new Intent();     // Catch: Throwable -> L18
        r2.setComponent(r4);     // Catch: Throwable -> L18
        r1.startService(r2);     // Catch: Throwable -> L18
    L19:
        Intent r3 = new Intent();     // Catch: Throwable -> L15
        r3.setComponent(r4);     // Catch: Throwable -> L15
        e r5 = new e(this);     // Catch: Throwable -> L15
        A();     // Catch: Throwable -> L15
        r1.bindService(r3, r5, 1);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    private void t(int r1, long r2) {
        com.bytedance.common.wschannel.app.b r0 = WsConstants.getBindWsChannelServiceListener();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(r1, r2);
    }

    private void u(ComponentName r6) {
        if (r6 != null) goto L17;
        return;
    L17:
        if (this.f3511f.peek() == null) goto L27;
        k.a r0 = this.f3511f.poll();     // Catch: Throwable -> L16
        if (r0 == null) goto L8;
        Message r1 = new Message();     // Catch: Throwable -> L16
        r1.what = r0.f3504c;     // Catch: Throwable -> L16
        r1.getData().putParcelable(r0.f3502a, r0.f3503b);     // Catch: Throwable -> L16
        y(r6, r1);     // Catch: Throwable -> L12 DeadObjectException -> L14
    L14:
        this.f3510e = null;     // Catch: Throwable -> L16
        this.f3511f.offerFirst(r0);     // Catch: Throwable -> L16
        t(3, SystemClock.uptimeMillis() - this.f3508c);     // Catch: Throwable -> L16
        return;
    L12:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
        goto L17
    L8:
        return;
    L27:
        return;
    }

    private synchronized void v(ComponentName r1) {
        monitor-enter(this);
        monitor-exit(this);
    }

    private void w(Context r3, IWsApp r4) {
        if (r3 == null) goto L23;
        if (r4 == null) goto L24;
        WeakReference<Context> r0 = this.f3509d;
        if (r0 != null) goto L8;
    L9:
        this.f3509d = new WeakReference(r3.getApplicationContext());
    L11:
        if (Logger.debug() == false) goto L14;
        Logger.d("WsChannelSdk", "register wsApp = " + r4.toString());
    L14:
        if (o.f(r3).g() == true) goto L21;
        return;
    L21:
        ComponentName r1 = new ComponentName(r3, WsChannelService.class);     // Catch: Throwable -> L18
        k.a r5 = new k.a();     // Catch: Throwable -> L18
        r5.f3502a = WsConstants.KEY_WS_APP;     // Catch: Throwable -> L18
        r5.f3503b = r4;     // Catch: Throwable -> L18
        r5.f3504c = 0;     // Catch: Throwable -> L18
        this.f3511f.offer(r5);     // Catch: Throwable -> L18
        r(r1);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (r0.get() != null) goto L11;
    L24:
        return;
    }

    private void x(Context r3, int r4) {
        if (r3 == null) goto L20;
        if (r4 > 0) goto L5;
        return;
    L5:
        if (r4 > 3) goto L22;
        WeakReference<Context> r0 = this.f3509d;
        if (r0 != null) goto L10;
    L11:
        this.f3509d = new WeakReference(r3.getApplicationContext());
    L13:
        if (Logger.debug() == false) goto L16;
        Logger.d("WsChannelSdk", "sendAppState appState = " + r4);
    L16:
        if (o.f(r3).g() == true) goto L18;
        return;
    L18:
        com.bytedance.common.utility.m.c.c(new d(this, r3, r4));
        return;
    L10:
        if (r0.get() != null) goto L13;
    L22:
        return;
    }

    private void y(ComponentName r2, Message r3) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.d("WsChannelSdk", "sendMsg msg = " + r3.toString() + " , + what = " + r3.what);
    L7:
        Messenger r1 = this.f3510e;
        if (r1 != null) goto L10;
        return;
    L10:
        r1.send(r3);
    }

    private void z(Context r3, IWsApp r4) {
        if (r3 == null) goto L23;
        if (r4 == null) goto L24;
        WeakReference<Context> r0 = this.f3509d;
        if (r0 != null) goto L8;
    L9:
        this.f3509d = new WeakReference(r3.getApplicationContext());
    L11:
        if (Logger.debug() == false) goto L14;
        Logger.d("WsChannelSdk", "sendParameterChange wsApp = " + r4.toString());
    L14:
        if (o.f(r3).g() == true) goto L21;
        return;
    L21:
        ComponentName r1 = new ComponentName(r3, WsChannelService.class);     // Catch: Throwable -> L18
        k.a r5 = new k.a();     // Catch: Throwable -> L18
        r5.f3502a = WsConstants.KEY_WS_APP;     // Catch: Throwable -> L18
        r5.f3503b = r4;     // Catch: Throwable -> L18
        r5.f3504c = 4;     // Catch: Throwable -> L18
        this.f3511f.offer(r5);     // Catch: Throwable -> L18
        r(r1);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (r0.get() != null) goto L11;
    L24:
        return;
    }

    @Override // com.bytedance.common.wschannel.client.k
    public void a(Context r3, SsWsApp r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        WeakReference<Context> r0 = this.f3509d;
        if (r0 != null) goto L7;
    L8:
        this.f3509d = new WeakReference(r3.getApplicationContext());
    L10:
        if (o.f(r3).g() == true) goto L12;
        return;
    L12:
        if (r4 == null) goto L15;
        w(r3, r4);
        return;
    L15:
        return;
    L7:
        if (r0.get() != null) goto L10;
        goto L8
    }

    @Override // com.bytedance.common.wschannel.client.k
    public void b(Context r3, int r4) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.d("WsChannelSdk", "unRegisterApp");
    L7:
        C(r3, r4);
    }

    @Override // com.bytedance.common.wschannel.client.k
    public void c(Context r1, boolean r2, boolean r3) {
        if (r2 == false) goto L4;
        B(r1, r3);
        return;
    L4:
        com.bytedance.common.utility.m.c.c(new b(this, r1));
    }

    @Override // com.bytedance.common.wschannel.client.k
    public void d(Context r2) {
        x(r2, 2);
    }

    @Override // com.bytedance.common.wschannel.client.k
    public void e(Context r2) {
        x(r2, 1);
    }

    @Override // com.bytedance.common.wschannel.client.k
    public void f(Context r3, WsChannelMsg r4) {
        if (r3 == null) goto L23;
        if (r4 == null) goto L24;
        WeakReference<Context> r0 = this.f3509d;
        if (r0 != null) goto L8;
    L9:
        this.f3509d = new WeakReference(r3.getApplicationContext());
    L11:
        if (Logger.debug() == false) goto L14;
        Logger.d("WsChannelSdk", "sendPayload wsChannelMsg = " + r4.toString());
    L14:
        if (o.f(r3).g() == true) goto L21;
        return;
    L21:
        ComponentName r1 = new ComponentName(r3, WsChannelService.class);     // Catch: Throwable -> L18
        k.a r5 = new k.a();     // Catch: Throwable -> L18
        r5.f3502a = WsConstants.KEY_PAYLOAD;     // Catch: Throwable -> L18
        r5.f3503b = r4;     // Catch: Throwable -> L18
        r5.f3504c = 5;     // Catch: Throwable -> L18
        this.f3511f.offer(r5);     // Catch: Throwable -> L18
        r(r1);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (r0.get() != null) goto L11;
    L24:
        return;
    }

    @Override // com.bytedance.common.wschannel.client.k
    public void g(Context r3, SsWsApp r4) {
        if (r3 == null) goto L18;
        if (r4 == null) goto L19;
        WeakReference<Context> r0 = this.f3509d;
        if (r0 != null) goto L8;
    L9:
        this.f3509d = new WeakReference(r3.getApplicationContext());
    L11:
        if (Logger.debug() == false) goto L14;
        Logger.d("WsChannelSdk", "onParameterChange" + r4.toString());
    L14:
        if (o.f(r3).g() == true) goto L16;
        return;
    L16:
        z(r3, r4);
        return;
    L8:
        if (r0.get() != null) goto L11;
    L19:
        return;
    }
}
