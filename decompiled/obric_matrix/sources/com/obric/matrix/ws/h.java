package com.obric.matrix.ws;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.obric.matrix.w.b0;
import com.obric.matrix.w.b1;
import com.obric.matrix.w.c0;
import com.obric.matrix.w.d0;
import com.obric.matrix.w.e0;
import com.obric.matrix.w.l0;
import com.obric.matrix.w.o0;
import com.obric.matrix.w.p;
import com.obric.matrix.w.q0;
import com.obric.matrix.w.r0;
import com.obric.matrix.w.s0;
import com.obric.matrix.w.t0;
import com.obric.matrix.w.u0;
import com.obric.matrix.w.v0;
import com.obric.matrix.w.w0;
import com.obric.matrix.w.x0;
import com.obric.matrix.w.y0;
import com.obric.matrix.w.z0;
import com.obric.matrix.ws.k.k;
import com.obric.matrix.ws.k.m;
import com.obric.matrix.ws.k.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Û\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r*\u0001\b\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u00106\u001a\u00020\u0013J\u001e\u00107\u001a\u00020\u00132\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020<J\u0006\u0010=\u001a\u00020)J\b\u0010>\u001a\u0004\u0018\u00010\u001bJ!\u0010?\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u0002020@2\u0006\u0010\u0012\u001a\u00020\u000fH\u0000¢\u0006\u0002\bAJ\u0006\u0010B\u001a\u000202J\u000e\u0010C\u001a\u00020\u00132\u0006\u0010D\u001a\u00020\u001dJ\u0010\u0010E\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\u0006\u0010F\u001a\u00020\u0004J:\u0010G\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u000f2(\u0010H\u001a$\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f\u0012\f\u0012\n\u0018\u00010Jj\u0004\u0018\u0001`K\u0012\u0004\u0012\u00020\u0013\u0018\u00010IH\u0002J,\u0010G\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u001a\u0010H\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010LJ+\u0010M\u001a\u00020\u00132#\u0010H\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000eJ\u000e\u0010N\u001a\u00020\u00132\u0006\u0010H\u001a\u00020\u0019J+\u0010O\u001a\u00020\u00132#\u0010H\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000eJ\u0006\u0010P\u001a\u00020\u0013J\u000e\u0010Q\u001a\u00020\u00132\u0006\u0010H\u001a\u00020\u0019J\u0006\u0010R\u001a\u00020\u0013J\u0014\u0010S\u001a\b\u0012\u0004\u0012\u00020U0T2\u0006\u0010V\u001a\u00020WJ0\u0010X\u001a\u00020\u00132\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020U0Z2\u0006\u0010[\u001a\u00020\u00042\u0010\b\u0002\u0010\\\u001a\n\u0018\u00010Jj\u0004\u0018\u0001`KH\u0002J\u001e\u0010]\u001a\b\u0012\u0004\u0012\u00020U0T2\u0006\u0010V\u001a\u00020W2\b\u0010^\u001a\u0004\u0018\u00010\u0017J\u001e\u0010_\u001a\b\u0012\u0004\u0012\u00020U0T2\u0006\u0010V\u001a\u00020W2\b\u0010^\u001a\u0004\u0018\u00010\u0017J\u001e\u0010`\u001a\b\u0012\u0004\u0012\u00020U0T2\u0006\u0010V\u001a\u00020W2\b\u0010^\u001a\u0004\u0018\u00010\u0017J\u0014\u0010a\u001a\b\u0012\u0004\u0012\u00020U0T2\u0006\u0010V\u001a\u00020WJ4\u0010b\u001a\u00020\u00132\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\u0006\u0010c\u001a\u0002092\b\u0010d\u001a\u0004\u0018\u0001022\b\u0010^\u001a\u0004\u0018\u00010\u0017H\u0002J\u001e\u0010e\u001a\b\u0012\u0004\u0012\u00020U0T2\u0006\u0010V\u001a\u00020W2\b\u0010^\u001a\u0004\u0018\u00010\u0017J\b\u0010f\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R1\u0010\f\u001a%\u0012!\u0012\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\u001c\u00100\u001a\u0010\u0012\u0004\u0012\u000202\u0012\u0006\u0012\u0004\u0018\u00010\u001701X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u00103\u001a\u0012\u0012\u0004\u0012\u00020204j\b\u0012\u0004\u0012\u000202`5X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/obric/matrix/ws/WsMsgManager;", "", "()V", "beforeIsConnect", "", "handler", "Landroid/os/Handler;", "iWsChannelListener", "com/obric/matrix/ws/WsMsgManager$iWsChannelListener$1", "Lcom/obric/matrix/ws/WsMsgManager$iWsChannelListener$1;", "iWsChannelRegister", "Lcom/obric/matrix/ws/internal/IWsChannelRegister;", "iWsMsgReceivedListeners", "", "Lkotlin/Function1;", "Lcom/bytedance/common/wschannel/model/WsChannelMsg;", "Lkotlin/ParameterName;", "name", "wsChannelMsg", "", "iWsMsgSender", "Lcom/obric/matrix/ws/internal/IWsMsgSender;", "iWsStatusChangeIPCListeners", "Lcom/obric/matrix/platform/server/IServerCallback;", "iWsStatusChangeListeners", "Lcom/obric/matrix/ws_api/IWsStatusChangeListener;", "lastConnectJson", "Lorg/json/JSONObject;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "onMessageReceiveListener", "Lcom/bytedance/common/wschannel/app/OnMessageReceiveListener;", "proxyWsChannelMgr", "Lcom/obric/matrix/ws/internal/WsChannel2Manager;", "runnable", "Ljava/lang/Runnable;", "wsConnectionEvent", "Lcom/bytedance/common/wschannel/event/ConnectEvent;", "wsMonitor", "Lcom/obric/matrix/ws/internal/WsMonitor;", "getWsMonitor", "()Lcom/obric/matrix/ws/internal/WsMonitor;", "wsMonitor$delegate", "Lkotlin/Lazy;", "wsMsgSubscriberIPCCallback", "Ljava/util/concurrent/ConcurrentHashMap;", "", "wsStatusSubscriberPkgs", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "clearWsMsgSubscriberIPCCallback", "generateWsMsg", "service", "", "method", WsConstants.KEY_PAYLOAD, "", "getLastConnectEvent", "getLastConnectJson", "getMsgPackage", "Lkotlin/Pair;", "getMsgPackage$ws_cnRelease", "getSubscriber", "init", "context", "interceptReceivedWsMsg", "isWsConnected", "realSendWsMessage", "listener", "Lkotlin/Function3;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/Function2;", "registerWsMsgReceivedListener", "registerWsStatusChangeListener", "removeWsMsgReceivedListener", "removeWsMsgReceivedListenerAll", "removeWsStatusChangeListener", "removeWsStatusChangeListenerAll", "sendWsMessage", "Lio/reactivex/Maybe;", "Lcom/obric/matrix/model/BaseResponseBody;", "request", "Lcom/obric/matrix/proto/Request;", "sendWsMsgBinderCallBack", "maybe", "Lio/reactivex/MaybeEmitter;", "success", "exception", "subscribeWsMsg", "callback", "subscribeWsMsgByBroadCast", "subscribeWsMsgByCallBack", "subscribeWsMsgByProvider", "subscribeWsMsgReal", "opt", "packageName", "subscribeWsWsStatus", "uploadMetrics", "ws_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f10618a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f10619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Handler f10620c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Runnable f10621d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final HashSet<String> f10622e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ConcurrentHashMap<String, com.obric.matrix.platform.e.b> f10623f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static com.bytedance.common.wschannel.r.b f10624g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final List<com.obric.matrix.ws_api.b> f10625h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static List<com.obric.matrix.platform.e.b> f10626i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final List<l<WsChannelMsg, f0>> f10627j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static com.obric.matrix.ws.k.h f10628k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static com.obric.matrix.ws.k.g f10629l;
    private static com.obric.matrix.ws.k.f m;
    private static com.bytedance.common.wschannel.app.d n;
    private static final kotlin.h o = null;
    private static volatile JSONObject p;
    private static final a q = null;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"com/obric/matrix/ws/WsMsgManager$iWsChannelListener$1", "Lcom/obric/matrix/ws_api/IWsChannelListener;", "onWsChannelMsg", "", "wsChannelMsg", "Lcom/bytedance/common/wschannel/model/WsChannelMsg;", "onWsConnectEvent", "connectEvent", "Lcom/bytedance/common/wschannel/event/ConnectEvent;", "connectJson", "Lorg/json/JSONObject;", "ws_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements com.obric.matrix.ws_api.a {
        a() {
        }

        @Override // com.obric.matrix.ws_api.a
        public void a(com.bytedance.common.wschannel.r.b r8, JSONObject r9) {
            o.f(r8, "connectEvent");
            h.j(h.f10618a);
            h.i(r8);
            h.h(r9);
            List r7 = h.d();
            monitor-enter(r7);
            Iterator r10 = h.d().iterator();     // Catch: Throwable -> L36
        L6:
            if (r10.hasNext() == false) goto L8;
            ((com.obric.matrix.ws_api.b) r10.next()).a(r8);     // Catch: Throwable -> L36
            goto L6
        L8:
            f0 r11 = f0.f18324a;     // Catch: Throwable -> L36
            monitor-exit(r7);
            List r12 = h.c();
            monitor-enter(r12);
            Iterator r13 = h.c().iterator();     // Catch: Throwable -> L33
        L14:
            if (r13.hasNext() == false) goto L24;
            com.obric.matrix.platform.e.b r0 = (com.obric.matrix.platform.e.b) r13.next();     // Catch: Throwable -> L33
            if (r0.asBinder().isBinderAlive() == false) goto L23;
            z0.a r1 = new z0.a();     // Catch: Throwable -> L33
            r1.b(Integer.valueOf(r8.f3662d));     // Catch: Throwable -> L33
            r1.c(Integer.valueOf(r8.f3659a.a()));     // Catch: Throwable -> L33
            r1.d(Integer.valueOf(r8.f3660b.a()));     // Catch: Throwable -> L33
            r1.e(Boolean.valueOf(h.a().isConnected()));     // Catch: Throwable -> L33
            z0 r2 = r1.a();     // Catch: Throwable -> L33
            com.obric.matrix.u.b.a r3 = new com.obric.matrix.u.b.a();     // Catch: Throwable -> L33
            r3.c(new com.obric.matrix.u.a("", 0, ""));     // Catch: Throwable -> L33
            e0.a r4 = new e0.a();     // Catch: Throwable -> L33
            r4.q(r2);     // Catch: Throwable -> L33
            e0 r5 = r4.b();     // Catch: Throwable -> L33
            o.e(r5, "Builder().subscribeWsSta…WsStatusResponse).build()");     // Catch: Throwable -> L33
            r3.d(r5);     // Catch: Throwable -> L33
            com.obric.matrix.u.b r6 = r3.a();     // Catch: Throwable -> L33
            d0.a r14 = new d0.a();     // Catch: Throwable -> L33
            p r15 = p.f10469k;     // Catch: Throwable -> L33
            r14.d(Integer.valueOf(r15.getValue()));     // Catch: Throwable -> L33
            r14.j(Integer.valueOf(o0.f10458g.getValue()));     // Catch: Throwable -> L33
            r14.i(BDLocationException.ERROR_TIMEOUT);     // Catch: Throwable -> L33
            r14.b(r6.c());     // Catch: Throwable -> L33
            r0.A(r15.getValue(), r14.c().encode());     // Catch: Exception -> L20 Throwable -> L33
            com.obric.matrix.r.c.c.b("WsMsgManager", "iWsChannelListener#onWsConnectEvent()->ipcCallback wsConnectionEvent: " + r8);     // Catch: Exception -> L20 Throwable -> L33
        L20:
            e = move-exception;
            com.obric.matrix.r.c.c.b("WsMsgManager", "iWsChannelListener#onWsConnectEvent()->ipcCallback with Exception: " + e);     // Catch: Throwable -> L33
        L22:
            r13.remove();     // Catch: Throwable -> L33
            goto L14
        L23:
            com.obric.matrix.r.c.c.b("WsMsgManager", "iWsChannelListener#onWsConnectEvent()->ipcCallback " + r0 + " is not alive remove it");     // Catch: Throwable -> L33
            goto L22
        L24:
            f0 r16 = f0.f18324a;     // Catch: Throwable -> L33
            monitor-exit(r12);
            if (h.e().size() <= 0) goto L51;
            Intent r17 = new Intent("android.intent.action.WS_STATUS");
            r17.setFlags((r17.getFlags() | 16777216) | 32);
            r17.putExtra("ws_status_channel_id", r8.f3662d);
            r17.putExtra("ws_status_channel_type", r8.f3659a.a());
            r17.putExtra("ws_connection_state", r8.f3660b.a());
            r17.putExtra("ws_is_connected", h.a().isConnected());
            Context r18 = h.f10618a.o();
            if (r18 == null) goto L31;
            r18.sendBroadcast(r17);
        L31:
            com.obric.matrix.r.c.c.b("WsMsgManager", "iWsChannelListener#onWsConnectEvent()->sendBroadcast(..): " + r17);
            return;
        L51:
            return;
        L33:
            th = move-exception;
            throw th;
        L36:
            th = move-exception;
            throw th;
        }

        @Override // com.obric.matrix.ws_api.a
        public void b(com.bytedance.common.wschannel.j r1) {
            com.obric.matrix.ws_api.a.C0289a.b(this, r1);
        }

        @Override // com.obric.matrix.ws_api.a
        public void c() {
            com.obric.matrix.ws_api.a.C0289a.a(this);
        }

        @Override // com.obric.matrix.ws_api.a
        public void d(WsChannelMsg r3) {
            o.f(r3, "wsChannelMsg");
            if (h.f(h.f10618a, r3) == true) goto L23;
            List r2 = h.b();     // Catch: Exception -> L16
            monitor-enter(r2);     // Catch: Exception -> L16
            Iterator r0 = h.b().iterator();     // Catch: Throwable -> L13
        L8:
            if (r0.hasNext() == false) goto L10;
            ((l) r0.next()).invoke(r3);     // Catch: Throwable -> L13
            goto L8
        L10:
            f0 r4 = f0.f18324a;     // Catch: Throwable -> L13
            monitor-exit(r2);     // Catch: Exception -> L16
            return;
        L13:
            th = move-exception;
            throw th;     // Catch: Exception -> L16
        L16:
            e = move-exception;
            com.obric.matrix.r.c.c.f("WsMsgManager", "iWsMsgReceivedListener.invoke(...) with Exception:" + e);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "isSuccess", "", NotificationCompat.CATEGORY_MESSAGE, "Lcom/bytedance/common/wschannel/model/WsChannelMsg;", "<anonymous parameter 2>", "Ljava/lang/Exception;", "Lkotlin/Exception;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends q implements kotlin.n0.c.q<Boolean, WsChannelMsg, Exception, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.p<Boolean, WsChannelMsg, f0> f10630f;

        /* JADX WARN: Multi-variable type inference failed */
        b(kotlin.n0.c.p<? super Boolean, ? super WsChannelMsg, f0> r1) {
            this.f10630f = r1;
            super(3);
        }

        public final void a(boolean r1, WsChannelMsg r2, Exception r3) {
            o.f(r2, NotificationCompat.CATEGORY_MESSAGE);
            kotlin.n0.c.p<Boolean, WsChannelMsg, f0> r0 = this.f10630f;
            if (r0 == null) goto L6;
            r0.invoke(Boolean.valueOf(r1), r2);
            return;
        }

        @Override // kotlin.n0.c.q
        public /* bridge */ /* synthetic */ f0 f(Boolean r1, WsChannelMsg r2, Exception r3) {
            a(r1.booleanValue(), r2, r3);
            return f0.f18324a;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "b", "", NotificationCompat.CATEGORY_MESSAGE, "Lcom/bytedance/common/wschannel/model/WsChannelMsg;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class c extends q implements kotlin.n0.c.q<Boolean, WsChannelMsg, Exception, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.q<Boolean, WsChannelMsg, Exception, f0> f10631f;

        /* JADX WARN: Multi-variable type inference failed */
        c(kotlin.n0.c.q<? super Boolean, ? super WsChannelMsg, ? super Exception, f0> r1) {
            this.f10631f = r1;
            super(3);
        }

        public final void a(boolean r2, WsChannelMsg r3, Exception r4) {
            o.f(r3, NotificationCompat.CATEGORY_MESSAGE);
            kotlin.n0.c.q<Boolean, WsChannelMsg, Exception, f0> r1 = this.f10631f;
            if (r1 == null) goto L6;
            r1.f(Boolean.valueOf(r2), r3, r4);
            return;
        }

        @Override // kotlin.n0.c.q
        public /* bridge */ /* synthetic */ f0 f(Boolean r1, WsChannelMsg r2, Exception r3) {
            a(r1.booleanValue(), r2, r3);
            return f0.f18324a;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "isSuccess", "", NotificationCompat.CATEGORY_MESSAGE, "Lcom/bytedance/common/wschannel/model/WsChannelMsg;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class d extends q implements kotlin.n0.c.q<Boolean, WsChannelMsg, Exception, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f.a.b<com.obric.matrix.u.b> f10632f;

        d(f.a.b<com.obric.matrix.u.b> r1) {
            this.f10632f = r1;
            super(3);
        }

        public final void a(boolean r2, WsChannelMsg r3, Exception r4) {
            o.f(r3, NotificationCompat.CATEGORY_MESSAGE);
            h r5 = h.f10618a;
            f.a.b<com.obric.matrix.u.b> r1 = this.f10632f;
            o.e(r1, "it");
            h.g(r5, r1, r2, r4);
        }

        @Override // kotlin.n0.c.q
        public /* bridge */ /* synthetic */ f0 f(Boolean r1, WsChannelMsg r2, Exception r3) {
            a(r1.booleanValue(), r2, r3);
            return f0.f18324a;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/obric/matrix/ws/internal/WsMonitor;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class e extends q implements kotlin.n0.c.a<k> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final e f10633f = null;

        static {
            f10633f = new e();
        }

        e() {
            super(0);
        }

        public final k a() {
            k r0 = new k();
            r0.h();
            return r0;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ k invoke() {
            return a();
        }
    }

    static {
        f10618a = new h();
        f10620c = new Handler(Looper.getMainLooper());
        f10621d = com.obric.matrix.ws.c.f10613f;
        f10622e = new HashSet();
        f10623f = new ConcurrentHashMap();
        f10624g = new com.bytedance.common.wschannel.r.b(com.bytedance.common.wschannel.r.c.f3663g, com.bytedance.common.wschannel.r.a.f3655g, 0, 0);
        f10625h = new ArrayList();
        f10626i = new ArrayList();
        f10627j = new ArrayList();
        com.obric.matrix.ws.k.h r0 = n.a();
        f10628k = r0;
        f10629l = r0;
        m = r0;
        n = r0;
        o = kotlin.i.b(e.f10633f);
        q = new a();
    }

    private h() {
    }

    public static /* synthetic */ void A(b0 r0, f.a.b r1) {
        L(r0, r1);
    }

    private final void C(WsChannelMsg r2, kotlin.n0.c.q<? super Boolean, ? super WsChannelMsg, ? super Exception, f0> r3) {
        com.obric.matrix.r.c.c.b("WsMsgManager", "realSendWsMessage() called with: wsChannelMsg = " + n.b(r2));
        f10629l.a(r2, new c(r3));
    }

    private static final void J() {
        com.obric.matrix.r.c.c.b("WsMsgManager", "current subscriber = " + f10618a.p());
    }

    private static final void L(b0 r14, f.a.b r15) {
        o.f(r14, "$request");
        o.f(r15, "it");
        b1 r16 = r14.o.f10239g.f10401f;
        if (r16 == null) goto L27;
        if (m.isConnected() == false) goto L25;
        WsChannelMsg.b r0 = WsChannelMsg.b.c(com.obric.matrix.ws.k.l.f10685a.b());
        Long r1 = r16.f10216g;
        o.e(r1, "messageInfo.logId");
        r0.d(r1.longValue());
        Long r2 = r16.f10215f;
        o.e(r2, "messageInfo.seqId");
        r0.i(r2.longValue());
        Integer r3 = r16.f10217h;
        o.e(r3, "messageInfo.service");
        r0.j(r3.intValue());
        Integer r4 = r16.f10218i;
        o.e(r4, "messageInfo.method");
        r0.e(r4.intValue());
        r0.h(r16.f10219j);
        r0.g(r16.f10220k);
        r0.f(r16.f10221l.E());
        r0.a("cmd", String.valueOf(r16.m));
        r0.a("seq_id", String.valueOf(r16.f10215f));
        Map<String, String> r17 = r16.o;
        if (r17 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == true) goto L22;
        Iterator<Map.Entry<String, String>> r18 = r17.entrySet().iterator();
    L16:
        if (r18.hasNext() == false) goto L22;
        Map.Entry<String, String> r6 = r18.next();
        if (r6 == null) goto L16;
        if (TextUtils.isEmpty(r6.getValue()) == true) goto L16;
        r0.a(r6.getKey(), r6.getValue());
    L22:
        WsChannelMsg r19 = r0.b();
        h r7 = f10618a;
        o.e(r19, "wsChannelMsg");
        r7.C(r19, new d(r15));
        return;
    L9:
        if (r17.isEmpty() == true) goto L12;
        r5 = false;
        goto L13
    L25:
        throw new com.obric.matrix.q.c.a(-100030, "wsChannel not connected", null, 4, null);
    L27:
        throw new com.obric.matrix.q.c.a(-100033, "messageInfo is null", null, 4, null);
    }

    private final void M(f.a.b<com.obric.matrix.u.b> r5, boolean r6, Exception r7) {
        l0.a r4 = new l0.a();
        r4.b(Boolean.valueOf(r6));
        l0 r8 = r4.a();
        com.obric.matrix.u.b.a r0 = new com.obric.matrix.u.b.a();
        if (r6 == false) goto L5;
        int r2 = 0;
    L6:
        r0.c(new com.obric.matrix.u.a("", Integer.valueOf(r2), ""));
        e0.a r1 = new e0.a();
        r1.k(r8);
        e0 r9 = r1.b();
        o.e(r9, "Builder().sendWsMessageR…sMessageResponse).build()");
        r0.d(r9);
        com.obric.matrix.u.b r10 = r0.a();
        if (r6 == false) goto L9;
        r5.b(r10);
        return;
    L9:
        if (r7 != null) goto L11;
        r7 = new Exception("send ws msg failed with unknown reason");
    L11:
        r5.onError(r7);
        return;
    L5:
        r2 = -1;
        goto L6
    }

    private static final void O(f.a.b r1) {
        o.f(r1, "it");
        r1.a();
    }

    private static final void Q(f.a.b r5) {
        o.f(r5, "it");
        r0.a r0 = new r0.a();
        r0.b(Boolean.TRUE);
        r0 r1 = r0.a();
        com.obric.matrix.u.b.a r2 = new com.obric.matrix.u.b.a();
        r2.c(new com.obric.matrix.u.a("", 0, ""));
        e0.a r3 = new e0.a();
        r3.m(r1);
        e0 r4 = r3.b();
        o.e(r4, "Builder().subscribeWsMsg…roadCastResponse).build()");
        r2.d(r4);
        r5.b(r2.a());
    }

    private static final void S(f.a.b r5) {
        o.f(r5, "it");
        t0.a r0 = new t0.a();
        r0.b(Boolean.TRUE);
        t0 r1 = r0.a();
        com.obric.matrix.u.b.a r2 = new com.obric.matrix.u.b.a();
        r2.c(new com.obric.matrix.u.a("", 0, ""));
        e0.a r3 = new e0.a();
        r3.n(r1);
        e0 r4 = r3.b();
        o.e(r4, "Builder().subscribeWsMsg…CallBackResponse).build()");
        r2.d(r4);
        r5.b(r2.a());
    }

    private static final void U(f.a.b r5) {
        o.f(r5, "it");
        v0.a r0 = new v0.a();
        r0.c(Boolean.TRUE);
        v0 r1 = r0.a();
        com.obric.matrix.u.b.a r2 = new com.obric.matrix.u.b.a();
        r2.c(new com.obric.matrix.u.a("", 0, ""));
        e0.a r3 = new e0.a();
        r3.o(r1);
        e0 r4 = r3.b();
        o.e(r4, "Builder().subscribeWsMsg…ProviderResponse).build()");
        r2.d(r4);
        r5.b(r2.a());
    }

    private final void V(int r2, int r3, int r4, String r5, com.obric.matrix.platform.e.b r6) {
        com.obric.matrix.r.c.c.b("WsMsgManager", "subscribeWsMsgReal() called with: service = " + r2 + ", method = " + r3 + ", opt = " + r4 + ", packageName = " + r5 + ", callback = " + r6);
        if (r6 == null) goto L5;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L15;
        f10623f.put(i.a(r2, r3), r6);
    L15:
        JSONObject r1 = new JSONObject();
        r1.put("sub_method_id", r3);
        r1.put("sub_sevice_id", r2);
        r1.put("sub_pkg", r5);
        r1.put("ws_conntect_status", f10618a.t());
        com.obric.matrix.ostracker_api.b.g("matrix_ws_subscribe", r1);
        Handler r7 = f10620c;
        Runnable r8 = f10621d;
        r7.removeCallbacks(r8);
        r7.postDelayed(r8, WsConstants.EXIT_DELAY_TIME);
        return;
    L14:
        f10623f.remove(i.a(r2, r3));
        goto L15
    L5:
        if (r4 == 0) goto L9;
        if (r4 != 1) goto L15;
        com.obric.matrix.q.e.a.f9851a.l(i.a(r2, r3), r5, "WS_MSG_KEVA_REPO");
        goto L15
    L9:
        com.obric.matrix.q.e.a.f9851a.b(i.a(r2, r3), "WS_MSG_KEVA_REPO");
        goto L15
    }

    private static final void X(com.bytedance.common.wschannel.r.b r4, f.a.b r5) {
        o.f(r4, "$wsConnectionEvent");
        o.f(r5, "it");
        z0.a r0 = new z0.a();
        r0.b(Integer.valueOf(r4.f3662d));
        r0.c(Integer.valueOf(r4.f3659a.a()));
        r0.d(Integer.valueOf(r4.f3660b.a()));
        r0.e(Boolean.valueOf(m.isConnected()));
        z0 r6 = r0.a();
        com.obric.matrix.u.b.a r1 = new com.obric.matrix.u.b.a();
        r1.c(new com.obric.matrix.u.a("", 0, ""));
        e0.a r2 = new e0.a();
        r2.q(r6);
        e0 r7 = r2.b();
        o.e(r7, "Builder().subscribeWsSta…WsStatusResponse).build()");
        r1.d(r7);
        r5.b(r1.a());
    }

    private final void Y() {
        t();
    }

    public static final /* synthetic */ com.obric.matrix.ws.k.f a() {
        return m;
    }

    public static final /* synthetic */ List b() {
        return f10627j;
    }

    public static final /* synthetic */ List c() {
        return f10626i;
    }

    public static final /* synthetic */ List d() {
        return f10625h;
    }

    public static final /* synthetic */ HashSet e() {
        return f10622e;
    }

    public static final /* synthetic */ boolean f(h r0, WsChannelMsg r1) {
        return r0.s(r1);
    }

    public static final /* synthetic */ void g(h r0, f.a.b r1, boolean r2, Exception r3) {
        r0.M(r1, r2, r3);
    }

    public static final /* synthetic */ void h(JSONObject r0) {
        p = r0;
    }

    public static final /* synthetic */ void i(com.bytedance.common.wschannel.r.b r0) {
        f10624g = r0;
    }

    public static final /* synthetic */ void j(h r0) {
        r0.Y();
    }

    private final k q() {
        return (k) o.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v9, types: [android.database.Cursor] */
    private final boolean s(WsChannelMsg r26) {
        com.obric.matrix.r.c.c.b("WsMsgManager", "interceptReceivedWsMsg() called with: wsChannelMsg = " + n.b(r26));
        int r2 = r26.s();
        int r3 = r26.f();
        com.obric.matrix.q.e.a r0 = com.obric.matrix.q.e.a.f9851a;
        String r10 = com.obric.matrix.q.e.a.k(r0, i.a(r2, r3), null, "WS_MSG_KEVA_REPO", 2, null);
        ?? r4 = com.obric.matrix.q.e.a.k(r0, i.b(r2, r3), null, "WS_MSG_KEVA_REPO", 2, null);
        if (f10623f.get(i.a(r2, r3)) == null) goto L19;
        HashMap r1 = new HashMap();
        List<WsChannelMsg.MsgHeader> r11 = r26.g();
        o.e(r11, "wsChannelMsg.msgHeaders");
        Iterator r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        WsChannelMsg.MsgHeader r13 = (WsChannelMsg.MsgHeader) r12.next();
        String r14 = r13.b();
        o.e(r14, "msgHeader.key");
        String r15 = r13.d();
        o.e(r15, "msgHeader.value");
        r1.put(r14, r15);
        goto L6
    L8:
        b1 r16 = new b1(Long.valueOf(r26.q()), Long.valueOf(r26.d()), Integer.valueOf(r26.s()), Integer.valueOf(r26.f()), r26.l(), r26.j(), k.h.v(r26.i(), 0, r26.i().length), 0, Integer.valueOf(r26.c()), r1);
        ConcurrentHashMap<String, com.obric.matrix.platform.e.b> r5 = f10623f;
        com.obric.matrix.platform.e.b r8 = r5.get(i.a(r2, r3));
        if (r8 == null) goto L19;
        if (r8.asBinder().isBinderAlive() == false) goto L18;
        x0.a r6 = new x0.a();
        r6.b(r16);
        x0 r7 = r6.a();
        com.obric.matrix.u.b.a r17 = new com.obric.matrix.u.b.a();
        r17.c(new com.obric.matrix.u.a("", 0, ""));
        e0.a r18 = new e0.a();
        r18.p(r7);
        e0 r9 = r18.b();
        o.e(r9, "Builder().subscribeWsMsg…ibeWsMsgResponse).build()");
        r17.d(r9);
        com.obric.matrix.u.b r19 = r17.a();
        d0.a r110 = new d0.a();
        p r111 = p.f10468j;
        r110.d(Integer.valueOf(r111.getValue()));
        r110.j(Integer.valueOf(o0.f10458g.getValue()));
        r110.i(BDLocationException.ERROR_TIMEOUT);
        r110.b(r19.c());
        d0 r20 = r110.c();
        long r112 = System.currentTimeMillis();
        r8.A(r111.getValue(), r20.encode());     // Catch: Exception -> L15
        com.obric.matrix.r.c.c.b("WsMsgManager", "interceptReceivedWsMsg()->callback: " + r16);     // Catch: Exception -> L15
        boolean r21 = true;
    L17:
        com.obric.matrix.r.c.c.b("WsMsgManager", "interceptReceivedWsMsg()->callback, cost = " + (System.currentTimeMillis() - r112) + " ms");
    L20:
        if (r21 == false) goto L23;
        return true;
    L23:
        String r22 = "it.key";
        if (TextUtils.isEmpty(r4) == true) goto L84;
        HashMap r23 = new HashMap();
        List<WsChannelMsg.MsgHeader> r24 = r26.g();
        o.e(r24, "wsChannelMsg.msgHeaders");
        Iterator r25 = r24.iterator();
    L27:
        if (r25.hasNext() == false) goto L29;
        WsChannelMsg.MsgHeader r113 = (WsChannelMsg.MsgHeader) r25.next();
        Iterator r27 = r25;
        String r28 = r113.b();
        o.e(r28, r22);
        String r29 = r22;
        String r30 = r113.d();
        o.e(r30, "it.value");
        r23.put(r28, r30);
        r25 = r27;
        r22 = r29;
        goto L27
    L29:
        String r210 = r22;
        Bundle r31 = new Bundle();
        r31.putInt(WsConstants.KEY_CHANNEL_ID, r26.c());
        String r32 = "WsMsgManager";
        r31.putLong("seq_id", r26.q());
        r31.putLong("log_id", r26.d());
        r31.putInt("service", r26.s());
        r31.putInt("method", r26.f());
        r31.putString("payload_type", r26.l());
        r31.putString("payload_encoding", r26.j());
        r31.putByteArray(WsConstants.KEY_PAYLOAD, r26.i());
        r31.putSerializable("ws_headers", r23);
        String r33 = "content://com.obric.matrix.platform.sdk.ones.provider." + r4 + "/ws_msg";
        com.obric.matrix.r.c.c.b(r32, "interceptReceivedWsMsg()->query provider, AUTHORITYS = " + r33);
        long r34 = System.currentTimeMillis();
        Context r211 = f10619b;     // Catch: Throwable -> L68 Exception -> L71
        if (r211 == null) goto L42;
        ContentResolver r35 = r211.getContentResolver();     // Catch: Throwable -> L68 Exception -> L71
        if (r35 == null) goto L42;
        String r212 = "ws_headers";
        Cursor r36 = null;
        Cursor r37 = r35.query(Uri.parse(r33), null, r31, null);     // Catch: Throwable -> L38 Exception -> L40
    L107:
        if (r37 != null) goto L45;
        com.obric.matrix.r.c.c.b(r32, "interceptReceivedWsMsg()->query provider, cursor is null");     // Catch: Exception -> L66 Throwable -> L80
        boolean r38 = false;
    L62:
        if (r37 == null) goto L79;
        r37.close();
    L79:
        long r39 = System.currentTimeMillis() - r34;
        StringBuilder r40 = new StringBuilder();
        r40.append("interceptReceivedWsMsg()->query provider, cost = ");
        r40.append(r39);
        String r41 = " ms";
        r40.append(r41);
        com.obric.matrix.r.c.c.b(r32, r40.toString());
    L86:
        if (r38 == false) goto L89;
        return true;
    L89:
        if (TextUtils.isEmpty(r10) == true) goto L98;
        HashMap r42 = new HashMap();
        List<WsChannelMsg.MsgHeader> r43 = r26.g();
        o.e(r43, "wsChannelMsg.msgHeaders");
        Iterator r44 = r43.iterator();
    L92:
        if (r44.hasNext() == false) goto L94;
        WsChannelMsg.MsgHeader r45 = (WsChannelMsg.MsgHeader) r44.next();
        String r46 = r45.b();
        o.e(r46, r210);
        String r47 = r45.d();
        o.e(r47, "it.value");
        r42.put(r46, r47);
        goto L92
    L94:
        Intent r48 = new Intent("android.intent.action." + r10 + ".WS_MSG");
        r48.setPackage(r10);
        r48.setFlags((r48.getFlags() | 16777216) | 32);
        r48.putExtra(WsConstants.KEY_CHANNEL_ID, r26.c());
        r48.putExtra("seq_id", r26.q());
        r48.putExtra("log_id", r26.d());
        r48.putExtra("service", r26.s());
        r48.putExtra("method", r26.f());
        r48.putExtra("payload_type", r26.l());
        r48.putExtra("payload_encoding", r26.j());
        r48.putExtra(WsConstants.KEY_PAYLOAD, r26.i());
        r48.putExtra(r212, r42);
        long r49 = System.currentTimeMillis();
        Context r50 = f10619b;
        if (r50 == null) goto L97;
        r50.sendBroadcast(r48);
    L97:
        com.obric.matrix.r.c.c.b(r32, "interceptReceivedWsMsg()->sendBroadcast: " + r48);
        com.obric.matrix.r.c.c.b(r32, "interceptReceivedWsMsg()->sendBroadcast, cost = " + (System.currentTimeMillis() - r49) + r41);
        return true;
    L98:
        return false;
    L45:
        com.obric.matrix.r.c.c.b(r32, "interceptReceivedWsMsg()->query provider, cursor is not null");     // Catch: Exception -> L66 Throwable -> L80
        r38 = false;
    L100:
        if (r37.moveToNext() == false) goto L62;
        String r51 = r37.getString(r37.getColumnIndex("received"));     // Catch: Exception -> L64 Throwable -> L80
        if (r51 != null) goto L52;
        r51 = "";
    L53:
        StringBuilder r52 = new StringBuilder();     // Catch: Exception -> L64 Throwable -> L80
        boolean r213 = r38;
        r52.append("interceptReceivedWsMsg()->query provider, received: ");     // Catch: Exception -> L59 Throwable -> L80
        r52.append(r51);     // Catch: Exception -> L59 Throwable -> L80
        com.obric.matrix.r.c.c.b(r32, r52.toString());     // Catch: Exception -> L59 Throwable -> L80
        if (o.a(r51, "true") == true) goto L57;
        r38 = r213;
        goto L100
    L57:
        r38 = true;
    L59:
        e = e;
        r38 = r213;
    L75:
        StringBuilder r53 = new StringBuilder();     // Catch: Throwable -> L80
        boolean r114 = r38;
        r53.append("interceptReceivedWsMsg()->query provider, Exception: ");     // Catch: Throwable -> L80
        r53.append(e);     // Catch: Throwable -> L80
        com.obric.matrix.r.c.c.f(r32, r53.toString());     // Catch: Throwable -> L80
        if (r37 == null) goto L78;
        r37.close();
    L78:
        r38 = r114;
        goto L79
    L52:
        o.e(r51, "cursor.getString(cursor.…nIndex(\"received\")) ?: \"\"");     // Catch: Exception -> L64 Throwable -> L80
    L64:
        e = e;
    L66:
        e = e;
    L74:
        r38 = false;
        goto L75
    L40:
        e = e;
    L73:
        r37 = r36;
    L38:
        th = th;
    L70:
        r4 = r36;
    L81:
        if (r4 == 0) goto L83;
        r4.close();
    L83:
        throw th;
    L42:
        r212 = "ws_headers";
        r37 = null;
    L80:
        th = th;
    L71:
        e = e;
        r212 = "ws_headers";
        r36 = null;
    L68:
        th = th;
        r36 = null;
        goto L70
    L84:
        r210 = "it.key";
        r212 = "ws_headers";
        r32 = "WsMsgManager";
        r41 = " ms";
        r38 = false;
    L15:
        e = move-exception;
        com.obric.matrix.r.c.c.b("WsMsgManager", "interceptReceivedWsMsg()->callback with Exception: " + e);
        f10623f.remove(i.a(r2, r3));
        r21 = false;
        goto L17
    L18:
        com.obric.matrix.r.c.c.b("WsMsgManager", "interceptReceivedWsMsg()->callback " + r8 + " is not alive remove it");
        r5.remove(i.a(r2, r3));
    L19:
        r21 = false;
        goto L20
    }

    public static /* synthetic */ void u(com.bytedance.common.wschannel.r.b r0, f.a.b r1) {
        X(r0, r1);
    }

    public static /* synthetic */ void v(f.a.b r0) {
        S(r0);
    }

    public static /* synthetic */ void w() {
        J();
    }

    public static /* synthetic */ void x(f.a.b r0) {
        Q(r0);
    }

    public static /* synthetic */ void y(f.a.b r0) {
        U(r0);
    }

    public static /* synthetic */ void z(f.a.b r0) {
        O(r0);
    }

    public final void B(WsChannelMsg r2, kotlin.n0.c.p<? super Boolean, ? super WsChannelMsg, f0> r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        C(r2, new b(r3));
    }

    public final void D(l<? super WsChannelMsg, f0> r3) {
        o.f(r3, "listener");
        List<l<WsChannelMsg, f0>> r2 = f10627j;
        monitor-enter(r2);
        r2.add(r3);     // Catch: Throwable -> L8
        monitor-exit(r2);
        com.obric.matrix.r.c.c.b("WsMsgManager", "registerWsMsgReceivedListener, listeners size = " + r2.size());
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void E(com.obric.matrix.ws_api.b r3) {
        o.f(r3, "listener");
        List<com.obric.matrix.ws_api.b> r2 = f10625h;
        monitor-enter(r2);
        r2.add(r3);     // Catch: Throwable -> L8
        monitor-exit(r2);
        com.obric.matrix.r.c.c.b("WsMsgManager", "registerWsStatusChangeListener, listeners size = " + r2.size());
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void F(l<? super WsChannelMsg, f0> r3) {
        o.f(r3, "listener");
        List<l<WsChannelMsg, f0>> r2 = f10627j;
        monitor-enter(r2);
        r2.remove(r3);     // Catch: Throwable -> L8
        monitor-exit(r2);
        com.obric.matrix.r.c.c.b("WsMsgManager", "removeWsMsgReceivedListener, listeners size = " + r2.size());
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void G() {
        List<l<WsChannelMsg, f0>> r1 = f10627j;
        monitor-enter(r1);
        r1.clear();     // Catch: Throwable -> L7
        f0 r0 = f0.f18324a;     // Catch: Throwable -> L7
        monitor-exit(r1);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void H(com.obric.matrix.ws_api.b r3) {
        o.f(r3, "listener");
        List<com.obric.matrix.ws_api.b> r2 = f10625h;
        monitor-enter(r2);
        r2.remove(r3);     // Catch: Throwable -> L8
        monitor-exit(r2);
        com.obric.matrix.r.c.c.b("WsMsgManager", "removeWsStatusChangeListener, listeners size = " + r2.size());
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void I() {
        List<com.obric.matrix.ws_api.b> r1 = f10625h;
        monitor-enter(r1);
        r1.clear();     // Catch: Throwable -> L7
        f0 r0 = f0.f18324a;     // Catch: Throwable -> L7
        monitor-exit(r1);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final f.a.a<com.obric.matrix.u.b> K(final b0 r2) {
        o.f(r2, "request");
        com.obric.matrix.r.c.c.b("WsMsgManager", "sendWsMessage() called with: request = " + r2);
        c0 r1 = r2.o;
        if (r1 == null) goto L9;
        if (r1.f10239g == null) goto L9;
        f.a.a<com.obric.matrix.u.b> r3 = f.a.a.b(new g(r2));
        o.e(r3, "create {\n            val…)\n            }\n        }");
        return r3;
    L9:
        throw new com.obric.matrix.s.e(r2);
    }

    public final f.a.a<com.obric.matrix.u.b> N(b0 r9, com.obric.matrix.platform.e.b r10) {
        o.f(r9, "request");
        com.obric.matrix.r.c.c.b("WsMsgManager", "subscribeWsMsg() called with: request = " + r9);
        c0 r0 = r9.o;
        if (r0 == null) goto L9;
        w0 r1 = r0.f10240h;
        if (r1 == null) goto L9;
        Integer r11 = r1.f10573f;
        Integer r2 = r1.f10574g;
        String r6 = r1.f10575h;
        Integer r3 = r1.f10576i;
        o.e(r11, "service");
        int r4 = r11.intValue();
        o.e(r2, "method");
        int r5 = r2.intValue();
        o.e(r3, "opt");
        V(r4, r5, r3.intValue(), r6, r10);
        f.a.a<com.obric.matrix.u.b> r8 = f.a.a.b(f.f10616a);
        o.e(r8, "create {\n            it.…andThen 的逻辑会被执行\n        }");
        return r8;
    L9:
        throw new com.obric.matrix.s.e(r9);
    }

    public final f.a.a<com.obric.matrix.u.b> P(b0 r8, com.obric.matrix.platform.e.b r9) {
        o.f(r8, "request");
        com.obric.matrix.r.c.c.b("WsMsgManager", "subscribeWsMsgByBroadCast() called with: request = " + r8);
        c0 r10 = r8.o;
        if (r10 == null) goto L9;
        q0 r11 = r10.f10244l;
        if (r11 == null) goto L9;
        Integer r12 = r11.f10487f;
        Integer r0 = r11.f10488g;
        String r5 = r11.f10489h;
        Integer r13 = r11.f10490i;
        o.e(r12, "service");
        int r2 = r12.intValue();
        o.e(r0, "method");
        int r3 = r0.intValue();
        o.e(r13, "opt");
        V(r2, r3, r13.intValue(), r5, null);
        f.a.a<com.obric.matrix.u.b> r7 = f.a.a.b(com.obric.matrix.ws.d.f10614a);
        o.e(r7, "create {\n            val…      .build())\n        }");
        return r7;
    L9:
        throw new com.obric.matrix.s.e(r8);
    }

    public final f.a.a<com.obric.matrix.u.b> R(b0 r9, com.obric.matrix.platform.e.b r10) {
        o.f(r9, "request");
        com.obric.matrix.r.c.c.b("WsMsgManager", "subscribeWsMsgByCallBack() called with: request = " + r9);
        c0 r0 = r9.o;
        if (r0 == null) goto L9;
        s0 r1 = r0.f10243k;
        if (r1 == null) goto L9;
        Integer r11 = r1.f10507f;
        Integer r2 = r1.f10508g;
        String r6 = r1.f10509h;
        Integer r3 = r1.f10510i;
        o.e(r11, "service");
        int r4 = r11.intValue();
        o.e(r2, "method");
        int r5 = r2.intValue();
        o.e(r3, "opt");
        V(r4, r5, r3.intValue(), r6, r10);
        f.a.a<com.obric.matrix.u.b> r8 = f.a.a.b(com.obric.matrix.ws.b.f10612a);
        o.e(r8, "create {\n            val…      .build())\n        }");
        return r8;
    L9:
        throw new com.obric.matrix.s.e(r9);
    }

    public final f.a.a<com.obric.matrix.u.b> T(b0 r8) {
        o.f(r8, "request");
        com.obric.matrix.r.c.c.b("WsMsgManager", "subscribeWsMsgByProvider() called with: request = " + r8);
        c0 r7 = r8.o;
        if (r7 == null) goto L20;
        u0 r9 = r7.f10242j;
        if (r9 == null) goto L20;
        Integer r10 = r9.f10543f;
        Integer r0 = r9.f10544g;
        String r1 = r9.f10545h;
        Integer r11 = r9.f10546i;
        if (r11 != null) goto L10;
    L12:
        if (r11 != null) goto L15;
    L17:
        JSONObject r12 = new JSONObject();
        o.e(r0, "method");
        r12.put("sub_method_id", r0.intValue());
        o.e(r10, "service");
        r12.put("sub_sevice_id", r10.intValue());
        r12.put("sub_pkg", "provider:" + r1);
        r12.put("ws_conntect_status", f10618a.t());
        com.obric.matrix.ostracker_api.b.g("matrix_ws_subscribe", r12);
        Handler r13 = f10620c;
        Runnable r14 = f10621d;
        r13.removeCallbacks(r14);
        r13.postDelayed(r14, WsConstants.EXIT_DELAY_TIME);
        f.a.a<com.obric.matrix.u.b> r15 = f.a.a.b(com.obric.matrix.ws.e.f10615a);
        o.e(r15, "create {\n            val…      .build())\n        }");
        return r15;
    L15:
        if (r11.intValue() != 0) goto L17;
        com.obric.matrix.q.e.a r16 = com.obric.matrix.q.e.a.f9851a;
        o.e(r10, "service");
        int r2 = r10.intValue();
        o.e(r0, "method");
        r16.b(i.b(r2, r0.intValue()), "WS_MSG_KEVA_REPO");
        goto L17
    L10:
        if (r11.intValue() != 1) goto L12;
        com.obric.matrix.q.e.a r17 = com.obric.matrix.q.e.a.f9851a;
        o.e(r10, "service");
        int r3 = r10.intValue();
        o.e(r0, "method");
        r17.l(i.b(r3, r0.intValue()), r1, "WS_MSG_KEVA_REPO");
    L20:
        throw new com.obric.matrix.s.e(r8);
    }

    public final f.a.a<com.obric.matrix.u.b> W(b0 r5, com.obric.matrix.platform.e.b r6) {
        o.f(r5, "request");
        com.obric.matrix.r.c.c.b("WsMsgManager", "subscribeWsWsStatus() called with: request = " + r5 + ", callback = " + r6);
        c0 r4 = r5.o;
        if (r4 == null) goto L41;
        if (r4.f10241i == null) goto L41;
        final com.bytedance.common.wschannel.r.b r7 = f10624g;
        com.obric.matrix.r.c.c.b("WsMsgManager", "current wsConnectionEvent: " + r7 + ", isConnected: " + m.isConnected());
        y0 r8 = r5.o.f10241i;
        Integer r0 = r8.f10593f;
        String r9 = r8.f10594g;
        if (r6 == null) goto L27;
        List<com.obric.matrix.platform.e.b> r2 = f10626i;
        monitor-enter(r2);
        if (r0 != null) goto L42;
    L15:
        if (r0 != null) goto L18;
    L20:
        f0 r10 = f0.f18324a;     // Catch: Throwable -> L23
        monitor-exit(r2);
    L23:
        th = move-exception;
        throw th;
    L18:
        if (r0.intValue() != 0) goto L20;
        f10626i.remove(r6);     // Catch: Throwable -> L23
        goto L20
    L42:
        if (r0.intValue() != 1) goto L15;
        f10626i.add(r6);     // Catch: Throwable -> L23
    L27:
        if (TextUtils.isEmpty(r9) == true) goto L38;
        if (r0 != null) goto L31;
    L33:
        if (r0 == null) goto L38;
        if (r0.intValue() != 0) goto L38;
        f10622e.remove(r9);
        goto L38
    L31:
        if (r0.intValue() != 1) goto L33;
        f10622e.add(r9);
    L38:
        f.a.a<com.obric.matrix.u.b> r11 = f.a.a.b(new com.obric.matrix.ws.a(r7));
        o.e(r11, "create {\n            // …      .build())\n        }");
        return r11;
    L41:
        throw new com.obric.matrix.s.e(r5);
    }

    public final void k() {
        f10623f.clear();
    }

    public final void l(int r3, int r4, byte[] r5) {
        o.f(r5, WsConstants.KEY_PAYLOAD);
        WsChannelMsg.b r2 = WsChannelMsg.b.c(123);
        r2.d(111);
        r2.i(222);
        r2.j(r3);
        r2.e(r4);
        r2.h("555");
        r2.g("666");
        r2.f(r5);
        r2.a("888", "999");
        WsChannelMsg r6 = r2.b();
        n.c(r6);
    }

    public final com.bytedance.common.wschannel.r.b m() {
        return f10624g;
    }

    public final JSONObject n() {
        return p;
    }

    public final Context o() {
        return f10619b;
    }

    public final String p() {
        StringBuilder r8 = new StringBuilder();
        StringBuilder r0 = new StringBuilder();
        Iterator<Map.Entry<String, ?>> r1 = com.obric.matrix.q.e.a.f9851a.e("WS_MSG_KEVA_REPO").entrySet().iterator();
    L3:
        boolean r3 = false;
        if (r1.hasNext() == false) goto L11;
        Map.Entry<String, ?> r2 = r1.next();
        if (kotlin.u0.k.A(r2.getKey(), "WS_MSG_SUBSCRIBER", false, 2, null) == false) goto L3;
        if (kotlin.u0.k.A(r2.getKey(), "WS_MSG_SUBSCRIBER_PROVIDER", false, 2, null) == true) goto L9;
        r8.append(r2 + " \n");
        goto L3
    L9:
        r0.append(r2 + " \n");
        goto L3
    L11:
        StringBuilder r4 = new StringBuilder();
        r4.append("aidl callBack 订阅记录:\n");
        StringBuilder r5 = new StringBuilder();
        r5.append(f10623f);
        r5.append('\n');
        r4.append(r5.toString());
        r4.append("provider 订阅记录:\n");
        String r6 = r0.toString();
        if (r6 != null) goto L14;
    L15:
        r3 = true;
    L16:
        if (r3 == false) goto L18;
        String r7 = "null\n";
    L19:
        r4.append(r7);
        r4.append("广播订阅记录:\n");
        r4.append(String.valueOf(r8));
        String r9 = r4.toString();
        o.e(r9, "res.toString()");
        return r9;
    L18:
        r7 = String.valueOf(r0);
        goto L19
    L14:
        if (r6.length() != 0) goto L16;
        goto L15
    }

    public final void r(Context r3) {
        o.f(r3, "context");
        f10619b = r3;
        m.registerListener(q);
        m.registerListener(q());
        com.obric.matrix.ws.k.j.f10665a.g0(r3);
        m.f10687a.h();
        com.obric.matrix.ws.k.i.f10657a.k(r3);
    }

    public final boolean t() {
        return m.isConnected();
    }
}
