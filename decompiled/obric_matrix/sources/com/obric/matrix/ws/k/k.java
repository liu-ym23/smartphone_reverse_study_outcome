package com.obric.matrix.ws.k;

import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.a0;
import kotlin.f0;
import kotlin.i0.m0;
import kotlin.n0.d.o;
import kotlin.u;
import kotlin.v;
import kotlin.w;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010\u0010\u001a\u00020\u000fJ\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J\u001c\u0010 \u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010!\u001a\u00020\u000fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/matrix/ws/internal/WsMonitor;", "Lcom/obric/matrix/ws_api/IWsChannelListener;", "()V", "mCurrConnectEvent", "Lcom/bytedance/common/wschannel/event/ConnectEvent;", "mCurrConnectedChangedTimeStamp", "", "mCurrStateChangedTimeStamp", "mWsChannel", "Lcom/bytedance/common/wschannel/WsChannel;", "checkConnected", "", "wsChannel", "connectEvent", "checkConnectedChanged", "", "init", "onWsChannelChanged", "onWsChannelMsg", "wsChannelMsg", "Lcom/bytedance/common/wschannel/model/WsChannelMsg;", "onWsConnectEvent", "connectJson", "Lorg/json/JSONObject;", "reportTeaEvent", "eventName", "", "params", "", "", "reportWsConnectedChanged", "isConnected", "reportWsConnectionStateChanged", "reportWsException", "Companion", "ws_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class k implements com.obric.matrix.ws_api.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f10678e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f10679f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.common.wschannel.j f10680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.common.wschannel.r.b f10681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f10682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f10683d;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/matrix/ws/internal/WsMonitor$init$1", "Ljava/util/TimerTask;", "run", "", "ws_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a extends TimerTask {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ k f10684f;

        a(k r1) {
            this.f10684f = r1;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            k.e(this.f10684f);
        }
    }

    static {
        TimeUnit r0 = TimeUnit.MINUTES;
        f10678e = r0.toMillis(60);
        f10679f = r0.toMillis(60);
    }

    public k() {
        this.f10682c = SystemClock.elapsedRealtime();
        this.f10683d = SystemClock.elapsedRealtime();
    }

    public static final /* synthetic */ void e(k r0) {
        r0.l();
    }

    private final boolean f(com.bytedance.common.wschannel.j r1, com.bytedance.common.wschannel.r.b r2) {
        if (r1 == null) goto L7;
        if (r2 == null) goto L7;
        if (r2.f3660b != com.bytedance.common.wschannel.r.c.f3667k) goto L7;
        return true;
    L7:
        return false;
    }

    private final void g(com.bytedance.common.wschannel.j r3, com.bytedance.common.wschannel.r.b r4) {
        if (f(this.f10680a, this.f10681b) == false) goto L9;
        if (f(r3, r4) == true) goto L9;
        boolean r5 = false;
    L7:
        j(r5);
        this.f10683d = SystemClock.elapsedRealtime();
        return;
    L9:
        if (f(this.f10680a, this.f10681b) == false) goto L11;
        return;
    L11:
        if (f(r3, r4) == false) goto L15;
        r5 = true;
        goto L7
    }

    private final void i(String r3, Map<String, ? extends Object> r4) {
        com.obric.matrix.dataanalysis.j.f9071a.a("matrix_" + r3, r4);
    }

    private final void j(boolean r6) {
        long r0 = SystemClock.elapsedRealtime() - this.f10683d;
        com.obric.matrix.r.d.c r2 = new com.obric.matrix.r.d.c("com.obric.common.ws_connected_changed");
        r2.g("ws_is_connected", Boolean.valueOf(!r6));
        r2.i("ws_is_connected_duration", Long.valueOf(r0));
        r2.j();
        if (r6 == false) goto L5;
        Map<String, ? extends Object> r7 = m0.e(a0.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(r0)));
        String r1 = "ws_channel_connected";
    L6:
        i(r1, r7);
        return;
    L5:
        r7 = m0.e(a0.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(r0)));
        r1 = "ws_channel_disconnected";
        goto L6
    }

    private final void k(com.bytedance.common.wschannel.r.b r13, JSONObject r14) {
        com.obric.matrix.r.d.c r0 = new com.obric.matrix.r.d.c("com.obric.common.ws_connection_state_changed");
        com.bytedance.common.wschannel.r.b r1 = this.f10681b;
        if (r1 != null) goto L5;
        com.bytedance.common.wschannel.r.c r2 = com.bytedance.common.wschannel.r.c.f3666j;
    L6:
        int r3 = r2.a();
        r0.g("ws_old_connection_state", Integer.valueOf(r3));
        if (r13 == null) goto L11;
        com.bytedance.common.wschannel.r.c r4 = r13.f3660b;
        if (r4 == null) goto L11;
    L12:
        int r5 = r4.a();
        r0.g("ws_new_connection_state", Integer.valueOf(r5));
        long r6 = SystemClock.elapsedRealtime() - this.f10682c;
        r0.i("ws_old_connection_state_duration", Long.valueOf(r6));
        if (r14 == null) goto L15;
        r0.h("ws_connect_json", r14);
    L15:
        r0.j();
        String r7 = null;
        if (r13 == null) goto L18;
        com.bytedance.common.wschannel.r.c r8 = r13.f3660b;
    L19:
        String r9 = "";
        if (r8 == com.bytedance.common.wschannel.r.c.f3665i) goto L48;
        if (r13 == null) goto L23;
        com.bytedance.common.wschannel.r.c r15 = r13.f3660b;
    L25:
        if (r15 == com.bytedance.common.wschannel.r.c.f3666j) goto L48;
        int r16 = 0;
    L46:
        i("ws_channel_connection_state_changed", m0.k(new u[]{a0.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(r6)), a0.a("ws_old_connection_state", Integer.valueOf(r3)), a0.a("ws_new_connection_state", Integer.valueOf(r5)), a0.a("ws_error", r9), a0.a("ws_error_code", Integer.valueOf(r16))}));
        return;
    L23:
        r15 = null;
    L48:
        v.a r17 = v.f21457g;     // Catch: Throwable -> L42
        if (r14 == null) goto L31;
        r7 = r14.optString(WsConstants.KEY_CONNECTION_ERROR);     // Catch: Throwable -> L42
    L31:
        if (r7 == null) goto L34;
        o.e(r7, "connectJson?.optString(\"error\") ?: \"\"");     // Catch: Throwable -> L42
        r9 = r7;
    L34:
        if (r14 == null) goto L37;
        r16 = r14.optInt(WsConstants.ERROR_CODE);     // Catch: Throwable -> L42
    L50:
        v.b(f0.f18324a);     // Catch: Throwable -> L40
    L45:
        com.obric.matrix.r.c.c.b("WSMonitor", "reportWsConnectionStateChanged, error: " + r9 + ", errorCode: " + r16);
    L40:
        th = move-exception;
        int r18 = r16;
        th = th;
    L44:
        v.a r10 = v.f21457g;
        v.b(w.a(th));
        r16 = r18;
        goto L45
    L37:
        r16 = 0;
    L42:
        th = th;
        r18 = 0;
        goto L44
    L18:
        r8 = null;
    L11:
        r4 = com.bytedance.common.wschannel.r.c.f3666j;
        goto L12
    L5:
        o.c(r1);
        r2 = r1.f3660b;
        goto L6
    }

    private final void l() {
        long r0 = SystemClock.elapsedRealtime() - this.f10683d;
        if (f(this.f10680a, this.f10681b) == false) goto L5;
    L9:
        com.obric.matrix.r.c.c.j("WSMonitor", "reportWsException: ");
        return;
    L5:
        if (r0 <= f10679f) goto L9;
        if (com.obric.matrix.r.e.h.b() == false) goto L9;
        com.obric.matrix.r.d.b r2 = new com.obric.matrix.r.d.b("ws_exception");
        r2.i(TypedValues.TransitionType.S_DURATION, Long.valueOf(r0));
        r2.j();
        i("ws_channel_exception", m0.e(a0.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(r0))));
    }

    @Override // com.obric.matrix.ws_api.a
    public void a(com.bytedance.common.wschannel.r.b r4, JSONObject r5) {
        o.f(r4, "connectEvent");
        if (this.f10680a != null) goto L6;
        com.obric.matrix.r.c.c.s("WSMonitor", "onStateChanged: mWsChannel is null");
        return;
    L6:
        com.bytedance.common.wschannel.r.b r0 = this.f10681b;
        if (r0 == null) goto L12;
        o.c(r0);
        if (r0.f3660b != r4.f3660b) goto L12;
        com.obric.matrix.r.c.c.s("WSMonitor", "onStateChanged: connectionState doesn't changed, connectionState=" + r4.f3660b);
        return;
    L12:
        k(r4, r5);
        g(this.f10680a, r4);
        this.f10681b = r4;
        this.f10682c = SystemClock.elapsedRealtime();
    }

    @Override // com.obric.matrix.ws_api.a
    public void b(com.bytedance.common.wschannel.j r3) {
        if (this.f10680a != r3) goto L5;
        return;
    L5:
        com.obric.matrix.r.c.c.b("WSMonitor", "onWsChannelChanged, wsChannel: " + r3);
        if (r3 != null) goto L8;
        k(null, null);
        g(null, null);
        this.f10681b = null;
        this.f10682c = SystemClock.elapsedRealtime();
    L8:
        this.f10680a = r3;
    }

    @Override // com.obric.matrix.ws_api.a
    public void c() {
        com.obric.matrix.ws_api.a.C0289a.a(this);
    }

    @Override // com.obric.matrix.ws_api.a
    public void d(WsChannelMsg r1) {
        o.f(r1, "wsChannelMsg");
    }

    public final void h() {
        com.obric.matrix.r.c.c.b("WSMonitor", "init");
        Timer r2 = new Timer();     // Catch: Exception -> L5
        a r3 = new a(this);     // Catch: Exception -> L5
        long r6 = f10678e;     // Catch: Exception -> L5
        r2.schedule(r3, r6, r6);     // Catch: Exception -> L5
        return;
    L5:
        com.obric.matrix.r.c.c.f("WSMonitor", "schedule timer");
    }
}
