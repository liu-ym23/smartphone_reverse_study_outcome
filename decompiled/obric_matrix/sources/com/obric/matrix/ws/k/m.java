package com.obric.matrix.ws.k;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import kotlin.Metadata;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u000b\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u0006\u0010\u001b\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u0019J\u001a\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/matrix/ws/internal/WsSurvivalHelper;", "", "()V", "CHECK_REGISTER_INTERVAL", "", "INIT_CHECK_REGISTER_DELAY", "MSG_CHECK_WS_REGISTER", "", "TAG", "", "handler", "com/obric/matrix/ws/internal/WsSurvivalHelper$handler$2$1", "getHandler", "()Lcom/obric/matrix/ws/internal/WsSurvivalHelper$handler$2$1;", "handler$delegate", "Lkotlin/Lazy;", "handlerThread", "Landroid/os/HandlerThread;", "getHandlerThread", "()Landroid/os/HandlerThread;", "handlerThread$delegate", "isFirstStart", "", "lastReportTime", "checkWsRegister", "", "checkWsRegisterInternal", "start", "stop", "uploadWsStatusMetrics", "connectEvent", "Lcom/bytedance/common/wschannel/event/ConnectEvent;", "connectJson", "Lorg/json/JSONObject;", "ws_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f10687a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlin.h f10688b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final kotlin.h f10689c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f10690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f10691e;

    @Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/obric/matrix/ws/internal/WsSurvivalHelper$handler$2$1", "invoke", "()Lcom/obric/matrix/ws/internal/WsSurvivalHelper$handler$2$1;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements kotlin.n0.c.a<HandlerC0288a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f10692f = null;

        /* JADX INFO: renamed from: com.obric.matrix.ws.k.m$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/matrix/ws/internal/WsSurvivalHelper$handler$2$1", "Landroid/os/Handler;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "ws_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class HandlerC0288a extends Handler {
            HandlerC0288a(Looper r1) {
                super(r1);
            }

            @Override // android.os.Handler
            public void handleMessage(Message r1) {
                o.f(r1, NotificationCompat.CATEGORY_MESSAGE);
                if (r1.what != 101) goto L6;
                m.a(m.f10687a);
                return;
            }
        }

        static {
            f10692f = new a();
        }

        a() {
            super(0);
        }

        public final HandlerC0288a a() {
            return new HandlerC0288a(m.b(m.f10687a).getLooper());
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ HandlerC0288a invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/HandlerThread;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends q implements kotlin.n0.c.a<HandlerThread> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f10693f = null;

        static {
            f10693f = new b();
        }

        b() {
            super(0);
        }

        public final HandlerThread a() {
            HandlerThread r1 = new HandlerThread("WsSurvivalHelper");
            r1.start();
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ HandlerThread invoke() {
            return a();
        }
    }

    static {
        f10687a = new m();
        f10688b = kotlin.i.b(b.f10693f);
        f10689c = kotlin.i.b(a.f10692f);
        f10690d = SystemClock.elapsedRealtime();
        f10691e = true;
    }

    private m() {
    }

    public static final /* synthetic */ void a(m r0) {
        r0.d();
    }

    public static final /* synthetic */ HandlerThread b(m r0) {
        return r0.f();
    }

    private final void c() {
        boolean r7 = com.obric.matrix.ws.h.f10618a.t();
        boolean r0 = com.obric.matrix.r.e.h.d();
        long r1 = j.f10665a.f0();
        long r3 = SystemClock.elapsedRealtime() - r1;
        com.obric.matrix.r.c.c.b("WsSurvivalHelper", "checkWsRegister() called, isWsConnected = " + r7 + ", isNetworkConnected = " + r0 + ", timeSinceLastPong = " + r3);
        if (r1 != 0) goto L5;
    L8:
        boolean r8 = true;
    L9:
        if (r0 == false) goto L13;
        if (r8 == false) goto L14;
        n.a().j("WsSurvivalHelper.checkWsRegister");
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (r3 > 300000) goto L8;
        r8 = false;
        goto L9
    }

    private final void d() {
        com.obric.matrix.r.c.c.b("WsSurvivalHelper", "checkWsRegisterInternal()");
        c();
        if ((SystemClock.elapsedRealtime() - f10690d) < 299999) goto L5;
        f10690d = SystemClock.elapsedRealtime();
        JSONObject r0 = new JSONObject();
        com.obric.matrix.ws.h r1 = com.obric.matrix.ws.h.f10618a;
        r0.put("is_connteced", r1.t());
        r0.put("net_status", com.obric.matrix.r.e.h.b() ? 1 : 0);
        com.obric.matrix.ostracker_api.b.g("matrix_ws_status", r0);
        k(r1.m(), r1.n());
    L5:
        e().removeMessages(101);
        e().sendEmptyMessageDelayed(101, 300000);
    }

    private final a.HandlerC0288a e() {
        return (a.HandlerC0288a) f10689c.getValue();
    }

    private final HandlerThread f() {
        return (HandlerThread) f10688b.getValue();
    }

    public static /* synthetic */ void g() {
        i();
    }

    private static final void i() {
        f10687a.c();
    }

    private final void k(com.bytedance.common.wschannel.r.b r8, JSONObject r9) {
        com.obric.matrix.r.c.c.b("WsSurvivalHelper", "uploadMetrics() called with: connectEvent = " + r8);
        if (r9 != null) goto L65;
        return;
    L65:
        String r7 = r9.optString(WsConstants.KEY_CONNECTION_STATE);     // Catch: Exception -> L62
        o.e(r7, "connectJson.optString(\"state\")");     // Catch: Exception -> L62
        int r10 = Integer.parseInt(r7);     // Catch: Exception -> L62
        com.obric.matrix.r.c.c.b("WsSurvivalHelper", "connectJson state = " + r10 + ", channel_type = " + r9.optString(WsConstants.KEY_CHANNEL_TYPE) + ", error_code = " + r9.optString(WsConstants.ERROR_CODE));     // Catch: Exception -> L62
        String r11 = r9.optString(WsConstants.KEY_CONNECTION_ERROR);     // Catch: Exception -> L62
        int r0 = 1;
        if (r11 != null) goto L8;
    L13:
        boolean r2 = false;
    L15:
        if (r2 == false) goto L55;
        com.obric.matrix.r.e.l r3 = com.obric.matrix.r.e.l.f9944a;     // Catch: Exception -> L62
        JSONObject r12 = r3.b(r11);     // Catch: Exception -> L62
        if (r12 == null) goto L52;
        com.obric.matrix.r.c.c.b("WsSurvivalHelper", "connectJson error code = " + r12.optString("code") + ", message = " + r12.optString("message") + ", ws_state = " + r12.optString("ws_state"));     // Catch: Exception -> L62
        String r13 = r12.optString(ICronetClient.KEY_REQUEST_LOG);     // Catch: Exception -> L62
        if (r13 == null) goto L26;
        o.e(r13, "requestLogStr");     // Catch: Exception -> L62
        if (r13.length() <= 0) goto L23;
        boolean r4 = true;
    L24:
        if (r4 != true) goto L26;
        boolean r5 = true;
    L27:
        if (r5 == false) goto L53;
        String r14 = new JSONObject(r13).optString("base");     // Catch: Exception -> L62
        com.obric.matrix.r.c.c.b("WsSurvivalHelper", "connectJson error request_log base = " + r14);     // Catch: Exception -> L62
        if (r14 == null) goto L36;
        o.e(r14, "baseStr");     // Catch: Exception -> L62
        if (r14.length() <= 0) goto L33;
        boolean r6 = true;
    L34:
        if (r6 != true) goto L36;
        boolean r15 = true;
    L37:
        if (r15 == false) goto L52;
        JSONObject r16 = r3.b(r14);     // Catch: Exception -> L62
        if (r16 == null) goto L52;
        String r17 = r16.optString("net_error");     // Catch: Exception -> L62
        com.obric.matrix.r.c.c.b("WsSurvivalHelper", "connectJson error request_log base net_error = " + r17);     // Catch: Exception -> L62
        if (r17 == null) goto L49;
        o.e(r17, "netError");     // Catch: Exception -> L62
        if (r17.length() <= 0) goto L46;
        boolean r18 = true;
    L47:
        if (r18 != true) goto L49;
        boolean r19 = true;
    L50:
        if (r19 == false) goto L52;
        o.e(r17, "netError");     // Catch: Exception -> L62
        int r20 = Integer.parseInt(r17);     // Catch: Exception -> L62
    L56:
        com.obric.matrix.r.c.c.b("WsSurvivalHelper", "lastWsStatus = " + r10 + ", lastNetError = " + r20 + ", isNetworkAvailable = " + com.obric.matrix.r.e.h.b() + ", isNetworkConnected = " + com.obric.matrix.r.e.h.d() + ", isScreenOn = " + com.obric.matrix.r.e.j.c());     // Catch: Exception -> L62
        JSONObject r21 = new JSONObject();     // Catch: Exception -> L62
        r21.put("is_screen_on", com.obric.matrix.r.e.j.c());     // Catch: Exception -> L62
        r21.put("is_network_available", com.obric.matrix.r.e.h.d());     // Catch: Exception -> L62
        r21.put("net_error", r20);     // Catch: Exception -> L62
        if (r10 == 4) goto L60;
        r0 = 0;
    L60:
        r21.put("status_tea", r0);     // Catch: Exception -> L62
        com.obric.matrix.ostracker_api.b.g("matrix_long_connection_ws_status", r21);     // Catch: Exception -> L62
        return;
    L46:
        r18 = false;
    L49:
        r19 = false;
        goto L50
    L33:
        r6 = false;
    L36:
        r15 = false;
        goto L37
    L53:
        String r22 = "connectJson error request_log is null";
    L54:
        com.obric.matrix.r.c.c.b("WsSurvivalHelper", r22);     // Catch: Exception -> L62
        goto L52
    L23:
        r4 = false;
    L26:
        r5 = false;
    L52:
        r20 = 0;
        goto L56
    L55:
        r22 = "connectJson error is null";
        goto L54
    L8:
        if (r11.length() <= 0) goto L10;
        boolean r23 = true;
    L11:
        if (r23 != true) goto L13;
        r2 = true;
        goto L15
    L10:
        r23 = false;
    L62:
        e = move-exception;
        com.obric.matrix.r.c.c.f("WsSurvivalHelper", "uploadMetrics() with Exception = " + e);
    }

    public final void h() {
        com.obric.matrix.r.c.c.j("WsSurvivalHelper", "start()");
        if (e().hasMessages(101) == true) goto L6;
        e().sendEmptyMessageDelayed(101, 300000);
    L6:
        if (f10691e == false) goto L9;
        e().postDelayed(e.f10642f, CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        f10691e = false;
        return;
    }

    public final void j() {
        com.obric.matrix.r.c.c.j("WsSurvivalHelper", "stop()");
        e().removeCallbacksAndMessages(null);
    }
}
