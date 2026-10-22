package com.obric.matrix.ws.k;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.mpaas.app.AppInfo;
import com.obric.matrix.account_api.OAccount;
import com.obric.matrix.r.e.p;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0;
import kotlin.f0;
import kotlin.i0.m0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\u001c\u0010\u001e\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%H\u0016J\u0012\u0010&\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\fH\u0016J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u000fH\u0016J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u000fH\u0016J$\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00062\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0/H\u0002J:\u00100\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2(\u0010*\u001a$\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020%\u0012\f\u0012\n\u0018\u000102j\u0004\u0018\u0001`3\u0012\u0004\u0012\u00020\u0019\u0018\u000101H\u0016J\u0012\u00104\u001a\u00020\u00192\b\b\u0002\u00105\u001a\u00020\nH\u0002J\b\u00106\u001a\u00020\u0019H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/obric/matrix/ws/internal/WsChannel2Manager;", "Lcom/bytedance/common/wschannel/app/OnMessageReceiveListener;", "Lcom/obric/matrix/ws/internal/IWsChannelRegister;", "Lcom/obric/matrix/ws/internal/IWsMsgSender;", "()V", "TAG", "", "connectLock", "", "connecting", "", "mContext", "Landroid/content/Context;", "mIWsChannelListeners", "", "Lcom/obric/matrix/ws_api/IWsChannelListener;", "mWsChannel", "Lcom/bytedance/common/wschannel/WsChannel;", "receiveMsgHandler", "Lcom/obric/matrix/common_utils/utils/WeakHandler;", "receiveStatusHandler", "sendMsgHandler", "isConnected", "isConnectedWithUid", "notifyHeartbeat", "", "notifyWsChannelChanged", "wsChannel", "onParamChanged", "scene", "onReceiveConnectEvent", "connectEvent", "Lcom/bytedance/common/wschannel/event/ConnectEvent;", "connectJson", "Lorg/json/JSONObject;", "onReceiveMsg", "wsChannelMsg", "Lcom/bytedance/common/wschannel/model/WsChannelMsg;", "parseConnectJson", "registerChannel", "context", "registerListener", "listener", "removeListener", "reportTeaEvent", "eventName", "params", "", "sendWsMsg", "Lkotlin/Function3;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "tryConnect", "forceConnect", "unRegisterChannel", "ws_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
public final class h implements com.bytedance.common.wschannel.app.d, f, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f10643a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile com.bytedance.common.wschannel.j f10644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Context f10645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f10646d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f10647e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final List<com.obric.matrix.ws_api.a> f10648f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static p f10649g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static p f10650h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static p f10651i;

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/matrix/ws_api/IWsChannelListener;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements kotlin.n0.c.l<com.obric.matrix.ws_api.a, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f10652f = null;

        static {
            f10652f = new a();
        }

        a() {
            super(1);
        }

        public final void a(com.obric.matrix.ws_api.a r1) {
            o.f(r1, "it");
            r1.c();
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(com.obric.matrix.ws_api.a r1) {
            a(r1);
            return f0.f18324a;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/matrix/ws_api/IWsChannelListener;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends q implements kotlin.n0.c.l<com.obric.matrix.ws_api.a, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.bytedance.common.wschannel.j f10653f;

        b(com.bytedance.common.wschannel.j r1) {
            this.f10653f = r1;
            super(1);
        }

        public final void a(com.obric.matrix.ws_api.a r2) {
            o.f(r2, "it");
            r2.b(this.f10653f);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(com.obric.matrix.ws_api.a r1) {
            a(r1);
            return f0.f18324a;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/matrix/ws_api/IWsChannelListener;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class c extends q implements kotlin.n0.c.l<com.obric.matrix.ws_api.a, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.bytedance.common.wschannel.r.b f10654f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f10655g;

        c(com.bytedance.common.wschannel.r.b r1, JSONObject r2) {
            this.f10654f = r1;
            this.f10655g = r2;
            super(1);
        }

        public final void a(com.obric.matrix.ws_api.a r2) {
            o.f(r2, "it");
            r2.a(this.f10654f, this.f10655g);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(com.obric.matrix.ws_api.a r1) {
            a(r1);
            return f0.f18324a;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/matrix/ws_api/IWsChannelListener;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class d extends q implements kotlin.n0.c.l<com.obric.matrix.ws_api.a, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ WsChannelMsg f10656f;

        d(WsChannelMsg r1) {
            this.f10656f = r1;
            super(1);
        }

        public final void a(com.obric.matrix.ws_api.a r2) {
            o.f(r2, "it");
            r2.d(this.f10656f);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(com.obric.matrix.ws_api.a r1) {
            a(r1);
            return f0.f18324a;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/ws/internal/WsChannel2Manager$registerChannel$1", "Lcom/obric/matrix/ostracker_api/IOSTrackerListener;", "onDeviceIdLoaded", "", "did", "", "onInstallIdLoaded", "installId", "ws_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class e implements com.obric.matrix.ostracker_api.a {
        e() {
        }

        @Override // com.obric.matrix.ostracker_api.a
        public void a(String r3) {
            com.obric.matrix.r.c.c.b("WsChannel2Manager", "onDeviceIdLoaded called with: did = " + r3);
            h.s(h.f10643a, false, 1, null);
        }

        @Override // com.obric.matrix.ostracker_api.a
        public void b(String r3) {
            h.s(h.f10643a, false, 1, null);
        }
    }

    static {
        f10643a = new h();
        f10646d = new Object();
        f10648f = new ArrayList();
        HandlerThread r0 = new HandlerThread("WsChannel2Manager-SendMsg-QUEUE");
        r0.start();
        f10649g = new p(r0.getLooper(), null);
        HandlerThread r1 = new HandlerThread("WsChannel2Manager-ReceiveMsg-QUEUE");
        r1.start();
        f10650h = new p(r1.getLooper(), null);
        HandlerThread r2 = new HandlerThread("WsChannel2Manager-ReceiveStatus-QUEUE");
        r2.start();
        f10651i = new p(r2.getLooper(), null);
    }

    private h() {
    }

    public static /* synthetic */ void d(WsChannelMsg r0) {
        l(r0);
    }

    public static /* synthetic */ void e(com.bytedance.common.wschannel.r.b r0, JSONObject r1) {
        k(r0, r1);
    }

    public static /* synthetic */ void f(kotlin.n0.c.q r0, WsChannelMsg r1) {
        p(r0, r1);
    }

    public static /* synthetic */ void g(kotlin.n0.c.q r0, WsChannelMsg r1, WsChannelMsg r2, boolean r3) {
        q(r0, r1, r2, r3);
    }

    private final void i(com.bytedance.common.wschannel.j r3) {
        List<com.obric.matrix.ws_api.a> r2 = f10648f;
        monitor-enter(r2);
        com.obric.matrix.r.e.f.f9940a.b(r2, new b(r3));     // Catch: Throwable -> L7
        f0 r4 = f0.f18324a;     // Catch: Throwable -> L7
        monitor-exit(r2);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static final void k(com.bytedance.common.wschannel.r.b r3, JSONObject r4) {
        com.obric.matrix.r.c.c.b("WsChannel2Manager", "onReceiveConnectEvent called with: connectEvent = " + r3);
        List<com.obric.matrix.ws_api.a> r0 = f10648f;
        monitor-enter(r0);
        com.obric.matrix.r.e.f.f9940a.b(r0, new c(r3, r4));     // Catch: Throwable -> L7
        f0 r5 = f0.f18324a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static final void l(WsChannelMsg r3) {
        o.f(r3, "$wsChannelMsg");
        List<com.obric.matrix.ws_api.a> r0 = f10648f;
        monitor-enter(r0);
        com.obric.matrix.r.e.f.f9940a.b(r0, new d(r3));     // Catch: Throwable -> L7
        f0 r4 = f0.f18324a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private final void o(String r3, Map<String, ? extends Object> r4) {
        com.obric.matrix.dataanalysis.j.f9071a.a("matrix_" + r3, r4);
    }

    private static final void p(final kotlin.n0.c.q r12, final WsChannelMsg r13) {
        Boolean r1 = Boolean.FALSE;
        o.f(r13, "$wsChannelMsg");
        boolean r3 = false;
        Integer r5 = null;
        s(f10643a, false, 1, null);
        com.bytedance.common.wschannel.j r2 = f10644b;
        if (r2 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L12;
        if (r12 == null) goto L35;
        r12.f(r1, r13, new com.obric.matrix.q.c.a(-100030, "WsChannel not Connected", null, 4, null));
        return;
    L35:
        return;
    L12:
        com.bytedance.common.wschannel.j r6 = f10644b;
        if (r6 != null) goto L15;
    L17:
        if (r3 == true) goto L33;
        if (r12 == null) goto L36;
        StringBuilder r7 = new StringBuilder();
        r7.append("wrong channel id: [");
        com.bytedance.common.wschannel.j r8 = f10644b;
        if (r8 == null) goto L22;
        r5 = Integer.valueOf(r8.c());
    L22:
        r7.append(r5);
        r7.append('|');
        r7.append(r13.c());
        r7.append(']');
        r12.f(r1, r13, new com.obric.matrix.q.c.a(-100031, r7.toString(), null, 4, null));
        return;
    L36:
        return;
    L33:
        com.obric.matrix.r.c.c.j("WsChannel2Manager", "sendWsMsg sendWsMsg >>");     // Catch: Exception -> L28
        com.bytedance.common.wschannel.j r9 = f10644b;     // Catch: Exception -> L28
        if (r9 == null) goto L37;
        r9.d(r13, new com.obric.matrix.ws.k.d(r12, r13));     // Catch: Exception -> L28
        return;
    L37:
        return;
    L28:
        e = move-exception;
        com.obric.matrix.r.c.c.b("WsChannel2Manager", "WsChannel sendWsMsg with Exception = " + e);
        if (r12 == null) goto L38;
        r12.f(r1, r13, e);
        return;
    L38:
        return;
    L15:
        if (r13.c() != r6.c()) goto L17;
        r3 = true;
        goto L17
    L5:
        if (r2.isConnected() == true) goto L7;
        r4 = true;
        goto L8
    }

    private static final void q(kotlin.n0.c.q r8, WsChannelMsg r9, WsChannelMsg r10, boolean r11) {
        o.f(r9, "$wsChannelMsg");
        StringBuilder r0 = new StringBuilder();
        r0.append("WsChannel sendWsMsg << callback with succ = ");
        r0.append(r11);
        r0.append(", msg = ");
        o.e(r10, NotificationCompat.CATEGORY_MESSAGE);
        r0.append(n.b(r10));
        com.obric.matrix.r.c.c.b("WsChannel2Manager", r0.toString());
        if (r11 == true) goto L5;
        com.obric.matrix.q.c.a r1 = new com.obric.matrix.q.c.a(-100032, n.b(r10), null, 4, null);
    L6:
        if (r8 == null) goto L9;
        r8.f(Boolean.valueOf(r11), r9, r1);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void r(boolean r14) {
        com.obric.matrix.r.c.c.b("WsChannel2Manager", "tryConnect() called with: forceConnect = " + r14);
        com.bytedance.common.wschannel.j r0 = f10644b;
        if (r0 != null) goto L5;
    L9:
        Object r1 = f10646d;
        monitor-enter(r1);
    L86:
        th = move-exception;
        throw th;
    L12:
        if (f10647e == false) goto L18;
        if (r14 == true) goto L18;
        com.obric.matrix.r.c.c.j("WsChannel2Manager", "tryConnect skipped, another connect is in progress");     // Catch: Throwable -> L86
        monitor-exit(r1);
        return;
    L18:
        f10647e = true;     // Catch: Throwable -> L86
        f0 r2 = f0.f18324a;     // Catch: Throwable -> L86
        monitor-exit(r1);
        com.bytedance.common.wschannel.j r3 = null;
        o("ws_channel_try_connect", m0.e(a0.a("force_connect", Boolean.valueOf(r14))));     // Catch: Throwable -> L64 Exception -> L66
        l r4 = l.f10685a;     // Catch: Throwable -> L64 Exception -> L66
        l.g(r4, false, 1, null);     // Catch: Throwable -> L64 Exception -> L66
        i.f10657a.j();     // Catch: Throwable -> L64 Exception -> L66
        Context r5 = f10645c;     // Catch: Throwable -> L64 Exception -> L66
        String r6 = com.obric.matrix.ostracker_api.b.c();     // Catch: Throwable -> L64 Exception -> L66
        com.obric.matrix.r.c.c.j("WsChannel2Manager", "tryConnect, context = " + r5 + ", deviceId = " + r6 + ", installId = " + com.obric.matrix.ostracker_api.b.e());     // Catch: Throwable -> L64 Exception -> L66
        if (r5 == null) goto L24;
        boolean r7 = true;
    L25:
        if (r7 == false) goto L63;
        if (r6 != null) goto L28;
    L31:
        boolean r8 = true;
    L33:
        if ((!r8) == false) goto L61;
        com.obric.matrix.account_api.a r9 = OAccount.INSTANCE.getAccountInfo();     // Catch: Throwable -> L64 Exception -> L66
        boolean r10 = r9.f();     // Catch: Throwable -> L64 Exception -> L66
        com.obric.matrix.r.c.c.j("WsChannel2Manager", "tryConnect, isLogin? " + r10);     // Catch: Throwable -> L64 Exception -> L66
        LinkedHashMap r11 = new LinkedHashMap();     // Catch: Throwable -> L64 Exception -> L66
        r11.put("sdk-version", "2");     // Catch: Throwable -> L64 Exception -> L66
        if (r10 == false) goto L37;
        r11.put("X-Tt-token", r9.r());     // Catch: Throwable -> L64 Exception -> L66
        r11.put("X-Common-Inner-Sso-Token", r9.d());     // Catch: Throwable -> L64 Exception -> L66
    L37:
        LinkedHashMap r12 = new LinkedHashMap();     // Catch: Throwable -> L64 Exception -> L66
        r12.put("ttnet_heartbeat_interval", "6000");     // Catch: Throwable -> L64 Exception -> L66
        r12.put("ttnet_timeout_millis", "50000");     // Catch: Throwable -> L64 Exception -> L66
        r12.put("max_reconnect_count", String.valueOf(r4.d()));     // Catch: Throwable -> L64 Exception -> L66
        r12.put("qos_level", "2");     // Catch: Throwable -> L64 Exception -> L66
        r12.put("use-olympus-account", LocationInfoConst.ALLOW_USE_LOCATION);     // Catch: Throwable -> L64 Exception -> L66
        if (r10 == false) goto L40;
        r12.put("X-Login-UserID", r9.n());     // Catch: Throwable -> L64 Exception -> L66
    L40:
        r12.putAll(com.obric.matrix.ostracker_api.b.b(r5, true, 1));     // Catch: Throwable -> L64 Exception -> L66
        com.bytedance.common.wschannel.a.C0093a r13 = com.bytedance.common.wschannel.a.C0093a.b(r4.b());     // Catch: Throwable -> L64 Exception -> L66
        r13.k(r4.e());     // Catch: Throwable -> L64 Exception -> L66
        r13.i(r4.c());     // Catch: Throwable -> L64 Exception -> L66
        r13.f(r4.a());     // Catch: Throwable -> L64 Exception -> L66
        r13.h(r6);     // Catch: Throwable -> L64 Exception -> L66
        r13.j(com.obric.matrix.ostracker_api.b.e());     // Catch: Throwable -> L64 Exception -> L66
        String r15 = AppInfo.getInstatnce().getAid();     // Catch: Throwable -> L64 Exception -> L66
        o.e(r15, "getInstatnce().aid");     // Catch: Throwable -> L64 Exception -> L66
        r13.e(Integer.parseInt(r15));     // Catch: Throwable -> L64 Exception -> L66
        String r16 = AppInfo.getInstatnce().getVersionCode(com.bytedance.mpaas.app.a.f5245g);     // Catch: Throwable -> L64 Exception -> L66
        o.e(r16, "getInstatnce().getVersio…Application.sApplication)");     // Catch: Throwable -> L64 Exception -> L66
        r13.g(Integer.parseInt(r16));     // Catch: Throwable -> L64 Exception -> L66
        r13.c(r12);     // Catch: Throwable -> L64 Exception -> L66
        r13.d(r11);     // Catch: Throwable -> L64 Exception -> L66
        com.bytedance.common.wschannel.a r17 = r13.a();     // Catch: Throwable -> L64 Exception -> L66
        com.obric.matrix.r.c.e.d("WsChannel2Manager", "tryConnect, channelInfo:\n" + com.obric.matrix.r.e.e.d(r17));     // Catch: Throwable -> L64 Exception -> L66
        monitor-enter(r1);     // Catch: Throwable -> L64 Exception -> L66
    L57:
        th = move-exception;
        throw th;     // Catch: Throwable -> L64 Exception -> L66
    L43:
        if (f10644b != null) goto L45;
        com.obric.matrix.r.c.c.b("WsChannel2Manager", "WsChannelSdk2.registerChannel(...)");     // Catch: Throwable -> L57
        Context r18 = f10645c;     // Catch: Throwable -> L57
        o.c(r18);     // Catch: Throwable -> L57
        f10644b = com.bytedance.common.wschannel.n.h(r18, r17, this);     // Catch: Throwable -> L57
    L48:
        r3 = f10644b;     // Catch: Throwable -> L57
        monitor-exit(r1);     // Catch: Throwable -> L64 Exception -> L66
        monitor-enter(r1);
        f10647e = false;     // Catch: Throwable -> L54
        monitor-exit(r1);
    L72:
        if (r3 == null) goto L100;
        i(r3);
        return;
    L100:
        return;
    L54:
        th = move-exception;
        throw th;
    L45:
        com.obric.matrix.r.c.c.b("WsChannel2Manager", "WsChannelSdk2.onParamChanged(...)");     // Catch: Throwable -> L57
        com.bytedance.common.wschannel.j r19 = f10644b;     // Catch: Throwable -> L57
        if (r19 == null) goto L48;
        r19.e(r17);     // Catch: Throwable -> L57
        goto L48
    L61:
        throw new IllegalArgumentException(("deviceId is [" + r6 + "]! can not connect ws").toString());     // Catch: Throwable -> L64 Exception -> L66
    L28:
        if (r6.length() == 0) goto L31;
        r8 = false;
        goto L33
    L63:
        throw new IllegalArgumentException("context is null! can not connect ws".toString());     // Catch: Throwable -> L64 Exception -> L66
    L24:
        r7 = false;
    L66:
        e = move-exception;
        com.obric.matrix.r.c.c.g("WsChannel2Manager", "ws connect error ", e);     // Catch: Throwable -> L64
        o("ws_channel_try_connect_error", m0.k(new u[]{a0.a("force_connect", Boolean.valueOf(r14)), a0.a("error_msg", e.toString())}));     // Catch: Throwable -> L64
        monitor-enter(f10646d);
        f10647e = false;     // Catch: Throwable -> L75
        f0 r20 = f0.f18324a;     // Catch: Throwable -> L75
    L75:
        th = move-exception;
        throw th;
    L64:
        th = move-exception;
        monitor-enter(f10646d);
        f10647e = false;     // Catch: Throwable -> L83
        f0 r21 = f0.f18324a;     // Catch: Throwable -> L83
        throw th;
    L83:
        th = move-exception;
        throw th;
    L5:
        if (r0.isConnected() == false) goto L9;
        if (r14 == true) goto L9;
        com.obric.matrix.r.c.c.j("WsChannel2Manager", "ws is connect, no need to connect");
    }

    static /* synthetic */ void s(h r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.r(r1);
    }

    @Override // com.obric.matrix.ws.k.g
    public void a(final WsChannelMsg r2, final kotlin.n0.c.q<? super Boolean, ? super WsChannelMsg, ? super Exception, f0> r3) {
        o.f(r2, "wsChannelMsg");
        com.obric.matrix.r.c.c.b("WsChannel2Manager", "sendWsMsg called with: wsChannelMsg = " + n.b(r2) + ", listener = " + r3);
        f10649g.post(new com.obric.matrix.ws.k.c(r3, r2));
    }

    @Override // com.bytedance.common.wschannel.app.d
    public void b(final com.bytedance.common.wschannel.r.b r2, final JSONObject r3) {
        if (r2 == null) goto L5;
        f10651i.removeCallbacksAndMessages(null);
        f10651i.postDelayed(new com.obric.matrix.ws.k.b(r2, r3), 250);
        return;
    }

    @Override // com.bytedance.common.wschannel.app.d
    public void c(final WsChannelMsg r2) {
        o.f(r2, "wsChannelMsg");
        com.obric.matrix.r.c.c.b("WsChannel2Manager", "onReceiveMsg called with: serviceId=" + r2.s() + " wsChannelMsg = " + n.b(r2));
        f10650h.post(new com.obric.matrix.ws.k.a(r2));
    }

    public void h() {
        List<com.obric.matrix.ws_api.a> r2 = f10648f;
        monitor-enter(r2);
        com.obric.matrix.r.e.f.f9940a.b(r2, a.f10652f);     // Catch: Throwable -> L7
        f0 r0 = f0.f18324a;     // Catch: Throwable -> L7
        monitor-exit(r2);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.matrix.ws.k.f
    public boolean isConnected() {
        com.bytedance.common.wschannel.j r0 = f10644b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isConnected();
    }

    public void j(String r3) {
        o.f(r3, "scene");
        com.obric.matrix.r.c.c.b("WsChannel2Manager", "onParamChanged() called, scene: " + r3);
        j.f10665a.m0(r3);
        r(true);
    }

    public void m(Context r3) {
        o.f(r3, "context");
        com.obric.matrix.r.c.c.b("WsChannel2Manager", "registerChannel() called with: context = " + r3 + ", did = " + com.obric.matrix.ostracker_api.b.c());
        f10645c = r3;
        if (TextUtils.isEmpty(com.obric.matrix.ostracker_api.b.c()) == true) goto L5;
        s(this, false, 1, null);
        return;
    L5:
        com.obric.matrix.ostracker_api.b.a(new e());
    }

    public void n(com.obric.matrix.ws_api.a r1) {
        o.f(r1, "listener");
        List<com.obric.matrix.ws_api.a> r0 = f10648f;
        monitor-enter(r0);
        r0.remove(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.matrix.ws.k.f
    public void registerListener(com.obric.matrix.ws_api.a r1) {
        o.f(r1, "listener");
        List<com.obric.matrix.ws_api.a> r0 = f10648f;
        monitor-enter(r0);
        r0.add(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void t() {
        Object r1 = f10646d;
        monitor-enter(r1);
        com.bytedance.common.wschannel.j r0 = f10644b;     // Catch: Throwable -> L10
        if (r0 == null) goto L7;
        r0.f();     // Catch: Throwable -> L10
    L7:
        f10644b = null;     // Catch: Throwable -> L10
        f0 r2 = f0.f18324a;     // Catch: Throwable -> L10
        monitor-exit(r1);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
