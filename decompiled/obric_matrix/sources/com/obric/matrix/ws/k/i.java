package com.obric.matrix.ws.k;

import android.content.Context;
import android.net.Network;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import com.obric.matrix.account_api.IAccount;
import com.obric.matrix.osettings_api.IOSettings;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.i0.r;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000*\u0004\r\u0011\u0016\u001a\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\b\u0010$\u001a\u00020\u001dH\u0002J(\u0010%\u001a\u00020\u001d*\u00020&2\u0006\u0010'\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020*H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001b¨\u0006+"}, d2 = {"Lcom/obric/matrix/ws/internal/WsConnectionController;", "", "()V", "MSG_SEND_THROTTLE", "", "MSG_TRIGGER_CONNECT", "", "MSG_TRIGGER_DISCONNECT", "MSG_TRIGGER_HARD_RECONNECT", "MSG_TRIGGER_RECONNECT", "TAG", "", "accountStatusListener", "com/obric/matrix/ws/internal/WsConnectionController$accountStatusListener$1", "Lcom/obric/matrix/ws/internal/WsConnectionController$accountStatusListener$1;", "currentNetworkKey", "handler", "com/obric/matrix/ws/internal/WsConnectionController$handler$1", "Lcom/obric/matrix/ws/internal/WsConnectionController$handler$1;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "oSettingsListener", "com/obric/matrix/ws/internal/WsConnectionController$oSettingsListener$1", "Lcom/obric/matrix/ws/internal/WsConnectionController$oSettingsListener$1;", "skipNextAvailableNetworkKey", "systemStateListener", "com/obric/matrix/ws/internal/WsConnectionController$systemStateListener$1", "Lcom/obric/matrix/ws/internal/WsConnectionController$systemStateListener$1;", "ensureConnectPreconditions", "", "init", "context", "Landroid/content/Context;", "triggerConnect", "triggerDisconnect", "triggerHardReconnect", "triggerReconnect", "sendEmptyMessageDelayedEx", "Landroid/os/Handler;", "what", "delay", "clear", "", "ws_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f10657a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final b f10658b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f10659c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile String f10660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile String f10661e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final d f10662f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final c f10663g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final a f10664h = null;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/obric/matrix/ws/internal/WsConnectionController$accountStatusListener$1", "Lcom/obric/matrix/account_api/IAccountStatusListener;", "onAccountInfoUpdate", "", "scene", "", "onLogin", "onLogout", "logoutScene", "", "ws_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements com.obric.matrix.account_api.c {
        a() {
        }

        @Override // com.obric.matrix.account_api.c
        public void e() {
            com.obric.matrix.r.c.c.b("WSConnectionController", "onLogin");
            i.m(i.f10657a, i.b(), 103, 0, false, 6, null);
        }

        @Override // com.obric.matrix.account_api.c
        public void h(int r9) {
            com.obric.matrix.r.c.c.b("WSConnectionController", "onLogout, logoutScene: " + r9);
            i.m(i.f10657a, i.b(), 103, 0, false, 6, null);
        }

        @Override // com.obric.matrix.account_api.c
        public void j(String r2) {
            o.f(r2, "scene");
            com.obric.matrix.r.c.c.b("WSConnectionController", "onAccountInfoUpdate, scene: " + r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/matrix/ws/internal/WsConnectionController$handler$1", "Landroid/os/Handler;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "ws_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends Handler {
        b(Looper r1) {
            super(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r1) {
            o.f(r1, NotificationCompat.CATEGORY_MESSAGE);
            switch(r1.what) {
                case 101: goto L8;
                case 102: goto L7;
                case 103: goto L6;
                case 104: goto L5;
                default: goto L13;
            };
        L5:
            i.h(i.f10657a);
            return;
        L6:
            i.i(i.f10657a);
            return;
        L7:
            i.g(i.f10657a);
            return;
        L8:
            i.f(i.f10657a);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\t"}, d2 = {"com/obric/matrix/ws/internal/WsConnectionController$oSettingsListener$1", "Lcom/obric/matrix/osettings_api/OnSettingsUpdateListener;", "getInterestedKeys", "", "", "onSettingsUpdate", "", "key", "value", "ws_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c implements com.obric.matrix.osettings_api.a {
        c() {
        }

        @Override // com.obric.matrix.osettings_api.a
        public void a(String r9, String r10) {
            o.f(r9, "key");
            l.f10685a.f(true);
            i.m(i.f10657a, i.b(), 103, 0, false, 6, null);
        }

        @Override // com.obric.matrix.osettings_api.a
        public List<String> b() {
            return r.j(new String[]{"tcc.frontier", "network"});
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"com/obric/matrix/ws/internal/WsConnectionController$systemStateListener$1", "Lcom/obric/matrix/base/system/ISystemStateListener;", "onNetworkAvailable", "", "network", "Landroid/net/Network;", "onNetworkBackOnline", "onNetworkLost", "onPowerSaveModeChanged", "enter", "", "onScreenStateChanged", "on", "ws_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d implements com.obric.matrix.q.h.d {
        d() {
        }

        @Override // com.obric.matrix.q.h.d
        public void a(Network r9) {
            if (r9 == null) goto L5;
            String r10 = r9.toString();
        L6:
            String r0 = i.c();
            if (r10 != null) goto L9;
        L12:
            i r1 = i.f10657a;
            i.e(null);
            if (r10 != null) goto L15;
        L17:
            b r2 = i.b();
            int r3 = 101;
        L18:
            i.m(r1, r2, r3, 0, false, 6, null);
            return;
        L15:
            if (o.a(r10, i.a()) == true) goto L17;
            com.obric.matrix.r.c.c.b("WSConnectionController", "validated network changed: " + i.a() + " -> " + r10);
            i.d(r10);
            r2 = i.b();
            r3 = 104;
            goto L18
        L9:
            if (o.a(r10, r0) == false) goto L12;
            com.obric.matrix.r.c.c.b("WSConnectionController", "skip duplicated onNetworkAvailable after back online: " + r10);
            i r11 = i.f10657a;
            i.e(null);
            return;
        L5:
            r10 = null;
            goto L6
        }

        @Override // com.obric.matrix.q.h.d
        public void b(boolean r1) {
            com.obric.matrix.r.c.c.b("WSConnectionController", "onScreenStateChanged: do nothing");
        }

        @Override // com.obric.matrix.q.h.d
        public void c(boolean r1) {
            com.obric.matrix.r.c.c.b("WSConnectionController", "onPowerSaveModeChanged: do nothing");
        }

        @Override // com.obric.matrix.q.h.d
        public void d(Network r10) {
            if (r10 == null) goto L4;
            String r9 = r10.toString();
        L5:
            com.obric.matrix.r.c.c.b("WSConnectionController", "onNetworkBackOnline: " + r9);
            i r1 = i.f10657a;
            i.d(r9);
            i.e(r9);
            i.m(r1, i.b(), 104, 0, false, 6, null);
            return;
        L4:
            r9 = null;
            goto L5
        }

        @Override // com.obric.matrix.q.h.d
        public void f(Network r9) {
            com.obric.matrix.r.c.c.b("WSConnectionController", "onNetworkLost: " + r9);
            i r0 = i.f10657a;
            i.d(null);
            i.e(null);
            i.m(r0, i.b(), 102, 0, false, 6, null);
        }
    }

    static {
        f10657a = new i();
        f10658b = new b(Looper.getMainLooper());
        f10659c = new AtomicBoolean(false);
        f10662f = new d();
        f10663g = new c();
        f10664h = new a();
    }

    private i() {
    }

    public static final /* synthetic */ String a() {
        return f10660d;
    }

    public static final /* synthetic */ b b() {
        return f10658b;
    }

    public static final /* synthetic */ String c() {
        return f10661e;
    }

    public static final /* synthetic */ void d(String r0) {
        f10660d = r0;
    }

    public static final /* synthetic */ void e(String r0) {
        f10661e = r0;
    }

    public static final /* synthetic */ void f(i r0) {
        r0.n();
    }

    public static final /* synthetic */ void g(i r0) {
        r0.o();
    }

    public static final /* synthetic */ void h(i r0) {
        r0.p();
    }

    public static final /* synthetic */ void i(i r0) {
        r0.q();
    }

    private final void l(Handler r1, int r2, long r3, boolean r5) {
        if (r5 == false) goto L4;
        r1.removeCallbacksAndMessages(null);
    L4:
        r1.sendEmptyMessageDelayed(r2, r3);
    }

    static /* synthetic */ void m(i r6, Handler r7, int r8, long r9, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r9 = 500;
    L5:
        long r3 = r9;
        if ((r12 & 4) == 0) goto L8;
        r11 = true;
    L8:
        r6.l(r7, r8, r3, r11);
    }

    private final void n() {
        com.obric.matrix.r.c.c.b("WSConnectionController", "triggerConnect()");
        h r2 = n.a();
        Context r0 = com.bytedance.mpaas.app.a.a();
        o.e(r0, "getContext()");
        r2.m(r0);
        m.f10687a.h();
    }

    private final void o() {
        com.obric.matrix.r.c.c.b("WSConnectionController", "triggerDisconnect()");
        n.a().t();
        m.f10687a.j();
    }

    private final void p() {
        com.obric.matrix.r.c.c.j("WSConnectionController", "triggerHardReconnect(), rebuild ws channel after network changed");
        j.f10665a.k0("WSConnectionController.HardReconnect");
        n.a().t();
        h r2 = n.a();
        Context r0 = com.bytedance.mpaas.app.a.a();
        o.e(r0, "getContext()");
        r2.m(r0);
        m.f10687a.h();
    }

    private final void q() {
        com.obric.matrix.r.c.c.b("WSConnectionController", "triggerReconnect()");
        n.a().j("WSConnectionController.Reconnect");
        m.f10687a.h();
    }

    public final void j() {
        if (com.obric.matrix.r.e.h.b() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("device is not connected to network");
    }

    public final void k(Context r2) {
        o.f(r2, "context");
        if (f10659c.compareAndSet(false, true) == false) goto L11;
        com.obric.matrix.q.h.k.l(f10662f);
        IOSettings r1 = (IOSettings) com.bytedance.news.common.service.manager.d.a(IOSettings.class);
        if (r1 == null) goto L7;
        r1.registerSettingsUpdate(f10663g);
    L7:
        IAccount r3 = (IAccount) com.bytedance.news.common.service.manager.d.a(IAccount.class);
        if (r3 == null) goto L12;
        r3.addAccountStatusListener(f10664h);
        return;
    L12:
        return;
    }
}
