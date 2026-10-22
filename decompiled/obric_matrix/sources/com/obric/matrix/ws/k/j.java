package com.obric.matrix.ws.k;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.lego.init.IdleTaskConfig;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.obric.matrix.base.settings.iconfig.IPushConfig;
import com.obric.matrix.opush_api.IPush;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.a0;
import kotlin.i0.m0;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.u;
import kotlin.v;
import kotlin.w;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011*\u0002 2\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010>\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\u0018H\u0003J\b\u0010@\u001a\u00020;H\u0003J\u0010\u0010A\u001a\u00020;2\u0006\u0010B\u001a\u00020+H\u0003J\u0012\u0010C\u001a\u0004\u0018\u00010\b2\u0006\u0010D\u001a\u00020+H\u0003J\b\u0010E\u001a\u00020;H\u0002J\b\u0010F\u001a\u00020;H\u0002J\b\u0010G\u001a\u00020HH\u0002J\b\u0010I\u001a\u00020HH\u0002J\u0018\u0010J\u001a\u00020;2\u0006\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020%H\u0002J\u0006\u0010M\u001a\u00020\u0004J\u000e\u0010N\u001a\u00020;2\u0006\u0010B\u001a\u00020+J\u0012\u0010O\u001a\u00020\u00182\b\u0010P\u001a\u0004\u0018\u00010QH\u0002J\b\u0010R\u001a\u00020\u0004H\u0002J\u0012\u0010S\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0002J\u000e\u0010T\u001a\u00020;2\u0006\u0010U\u001a\u00020\bJ\u0010\u0010V\u001a\u00020;2\u0006\u0010\u001e\u001a\u00020\u0004H\u0007J\u000e\u0010W\u001a\u00020;2\u0006\u0010U\u001a\u00020\bJ\b\u0010X\u001a\u00020;H\u0002J\u0010\u0010Y\u001a\u00020;2\u0006\u0010Z\u001a\u00020\u0004H\u0002J\u0010\u0010[\u001a\u00020;2\u0006\u0010Z\u001a\u00020\u0004H\u0002J\u0012\u0010\\\u001a\u00020;2\b\b\u0002\u0010]\u001a\u00020\u0018H\u0003J\b\u0010^\u001a\u00020;H\u0003J\b\u0010_\u001a\u00020;H\u0002J\u0012\u0010`\u001a\u00020\u00182\b\u0010<\u001a\u0004\u0018\u00010=H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u000e\u0010\"\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103R\u000e\u00104\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\b\u0018\u000108R\u000209X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/obric/matrix/ws/internal/WsHeartbeatManager;", "", "()V", "DEFAULT_INIT_HEARTBEAT_MS", "", "HALF_HOUR_MS", "MAX_HEARTBEAT_MS", "PING_ACTION", "", "PING_INTERVAL", "PING_REQUEST_CODE", "", "PONG_TIMEOUT_ACTION", "PONG_TIMEOUT_MS", "PONG_TIMEOUT_REQUEST_CODE", "SETTINGS_KEY_HEARTBEAT_INTERVAL", "SEVEN_DAYS_MS", "TAG", "WS_HEARTBEAT_KEY_PREFIX", "WS_HEARTBEAT_REPO", "WS_HEARTBEAT_TS_PREFIX", "alarmManager", "Landroid/app/AlarmManager;", "curNetHadConnected", "", "currentIntervalMs", "disconnectCount", "disconnectWindow", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "hadDisconnectSinceLastPing", "heartbeatCount", "iWsChannelListener", "com/obric/matrix/ws/internal/WsHeartbeatManager$iWsChannelListener$1", "Lcom/obric/matrix/ws/internal/WsHeartbeatManager$iWsChannelListener$1;", "isWaitingForPong", "lastConnectedTime", "lastConnectionState", "Lcom/bytedance/common/wschannel/event/ConnectionState;", "lastNetworkAvailableTime", "lastPongReceiveTime", "lastStableBeforeDisconnectMs", "lastWakeLockAcquireTime", "mContext", "Landroid/content/Context;", "maxIntervalMsCap", "pendingReconnectScene", "resetHeartbeatCountOnNextConnected", "skipNextValidatedNetworkAvailableFor", "stableNoChangeCount", "systemStateListener", "com/obric/matrix/ws/internal/WsHeartbeatManager$systemStateListener$1", "Lcom/obric/matrix/ws/internal/WsHeartbeatManager$systemStateListener$1;", "totalConnectedDuration", "totalNetworkDuration", "usingLearnedInterval", "wakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "applyHeartbeatConfigForCurrentNetwork", "", "network", "Landroid/net/Network;", "resetDurationStats", "relearnWhenNoLearned", "beginRelearn", "bootstrapOnlineStateIfNeeded", "context", "buildNetworkKey", "ctx", "cancelPongTimeout", "clearLearned", "createPingIntent", "Landroid/app/PendingIntent;", "createPongTimeoutIntent", "endCurrentConnectionSegment", "reason", "currentState", "getLastPongReceiveTime", "init", "isRSTError", "connectJson", "Lorg/json/JSONObject;", "loadLearned", "markSkipNextValidatedNetworkAvailable", "onNetworkChangedReconnectRequested", "scene", "onPongReceive", "onReconnectRequested", "reportOnlineDurationRate", "saveLearned", "intervalMs", "saveToSettings", "scheduleNextPing", "learn", "schedulePongTimeout", "sendPing", "shouldSkipValidatedNetworkAvailable", "WsAlarmReceiver", "ws_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
public final class j {
    private static final c A = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f10665a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f10666b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f10667c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f10668d = 120000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f10669e = 300000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f10670f = 120000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f10671g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f10672h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f10673i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ConcurrentLinkedDeque<Long> f10674j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile long f10675k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile long f10676l;
    private static volatile long m;
    private static volatile long n;
    private static volatile int o;
    private static volatile long p;
    private static volatile long q;
    private static volatile String r;
    private static volatile boolean s;
    private static AlarmManager t;
    private static PowerManager.WakeLock u;
    private static long v;
    private static boolean w;
    private static volatile String x;
    private static com.bytedance.common.wschannel.r.c y;
    private static final b z = null;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017¨\u0006\t"}, d2 = {"Lcom/obric/matrix/ws/internal/WsHeartbeatManager$WsAlarmReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "ws_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        @RequiresApi(31)
        public void onReceive(Context r2, Intent r3) {
            o.f(r2, "context");
            o.f(r3, "intent");
            com.obric.matrix.r.c.c.b("WsHeartbeatManager", "onReceive: " + r3.getAction());
            String r1 = r3.getAction();
            if (r1 == null) goto L17;
            int r4 = r1.hashCode();
            if (r4 == 734413332) goto L13;
            if (r4 == 2097894044) goto L10;
            return;
        L10:
            if (r1.equals("com.obric.matrix.ws.PING_ACTION") == false) goto L18;
            j.D(j.f10665a);
            return;
        L18:
            return;
        L13:
            if (r1.equals("com.obric.matrix.ws.PONG_TIMEOUT_ACTION") == false) goto L21;
            com.obric.matrix.r.c.c.f("WsHeartbeatManager", "pong timeout, trigger reconnect");
            j r5 = j.f10665a;
            j.I(0);
            n.a().j("pong_timeout");
            return;
        L21:
            return;
        }
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"com/obric/matrix/ws/internal/WsHeartbeatManager$iWsChannelListener$1", "Lcom/obric/matrix/ws_api/IWsChannelListener;", "hasInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onWsChannelMsg", "", "wsChannelMsg", "Lcom/bytedance/common/wschannel/model/WsChannelMsg;", "onWsConnectEvent", "connectEvent", "Lcom/bytedance/common/wschannel/event/ConnectEvent;", "connectJson", "Lorg/json/JSONObject;", "ws_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b implements com.obric.matrix.ws_api.a {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f10677a = null;

            static {
                int[] r0 = new int[com.bytedance.common.wschannel.r.c.values().length];
                r0[com.bytedance.common.wschannel.r.c.f3665i.ordinal()] = 1;
                r0[com.bytedance.common.wschannel.r.c.f3666j.ordinal()] = 2;
                r0[com.bytedance.common.wschannel.r.c.f3667k.ordinal()] = 3;
                f10677a = r0;
            }
        }

        b() {
            new AtomicBoolean(false);
        }

        @Override // com.obric.matrix.ws_api.a
        @RequiresApi(31)
        public void a(com.bytedance.common.wschannel.r.b r12, JSONObject r13) {
            o.f(r12, "connectEvent");
            com.bytedance.common.wschannel.r.c r11 = r12.f3660b;
            String r14 = j.s();
            com.obric.matrix.r.c.c.j("WsHeartbeatManager", "onWsConnectEvent currentState=" + r11 + " lastState=" + j.n() + " pendingReconnectScene=" + r14 + " lastConnectedTime=" + j.m() + " lastNetworkAvailableTime=" + j.o());
            if (r11 != null) goto L5;
            int r0 = -1;
        L7:
            if (r0 != 1) goto L9;
        L44:
            com.bytedance.common.wschannel.r.c r1 = j.n();
            com.bytedance.common.wschannel.r.c r2 = com.bytedance.common.wschannel.r.c.f3667k;
            if (r1 != r2) goto L48;
            if (r14 != null) goto L48;
            j r15 = j.f10665a;
            j.G(j.j() + 1);
        L48:
            j r16 = j.f10665a;
            boolean r17 = j.y(r16, r13);
            o.e(r11, "currentState");
            j.f(r16, "explicit_disconnect", r11);
            AlarmManager r3 = j.g();
            if (r3 != null) goto L51;
        L53:
            boolean r4 = false;
        L54:
            if (r4 == false) goto L58;
            com.obric.matrix.r.c.c.j("WsHeartbeatManager", "cancel ping alarm when ws disconnect");
            AlarmManager r5 = j.g();
            if (r5 == null) goto L58;
            r5.cancel(j.e(r16));
        L58:
            j.d(r16);
            j.U(false);
            j.I(0);
            if (j.t() == false) goto L61;
            com.obric.matrix.r.c.c.j("WsHeartbeatManager", "clear pending heartbeat reset on disconnect currentState=" + r11);
            j.P(false);
        L61:
            if (r17 == true) goto L63;
        L67:
            j.H(true);
            j.Q(0);
            if (j.n() != r2) goto L81;
            long r18 = SystemClock.elapsedRealtime();
            j.k().addLast(Long.valueOf(r18));
        L71:
            if ((!j.k().isEmpty()) == false) goto L76;
            Object r6 = j.k().peekFirst();
            o.e(r6, "disconnectWindow.peekFirst()");
            if ((r18 - ((Number) r6).longValue()) <= 1800000) goto L76;
            j.k().removeFirst();
        L76:
            if (j.w() == false) goto L81;
            if (j.k().size() < 3) goto L81;
            j.c(j.f10665a);
            j.k().clear();
        L81:
            if (com.obric.matrix.r.e.h.d() == false) goto L92;
            long r19 = SystemClock.elapsedRealtime();
            if ((r19 - j.q()) > TimeUnit.MINUTES.toMillis(10)) goto L95;
            com.obric.matrix.r.c.c.b("WsHeartbeatManager", "skip wakelock on disconnect, in 10min cooldown");
            goto L92
        L95:
            PowerManager.WakeLock r7 = j.x();     // Catch: Exception -> L89
            if (r7 == null) goto L87;
            r7.acquire(BDLocationConfig.sScanBleMaxInterval);     // Catch: Exception -> L89
        L87:
            j r8 = j.f10665a;     // Catch: Exception -> L89
            j.M(r19);     // Catch: Exception -> L89
            com.obric.matrix.r.c.c.j("WsHeartbeatManager", "acquired wakelock on disconnect for 10s");     // Catch: Exception -> L89
        L89:
            e = move-exception;
            com.obric.matrix.r.c.c.g("WsHeartbeatManager", "failed to acquire wakelock", e);
        L92:
            Settings.Global.putInt(com.bytedance.mpaas.app.a.a().getContentResolver(), "ws_heartbeat_stable", 0);
            com.obric.matrix.r.c.c.b("WsHeartbeatManager", "onDisconnect: currentIntervalMs=" + j.i() + ", maxCap=" + j.r());
        L93:
            j r110 = j.f10665a;
            o.e(r11, "currentState");
            j.K(r11);
            return;
        L63:
            if (j.w() == true) goto L67;
            if (j.h() == false) goto L67;
            long r111 = j.i();
            TimeUnit r9 = TimeUnit.MINUTES;
            j.F(Math.max(r111 - r9.toMillis(1), r9.toMillis(2)));
            j.N(Math.min(300000, j.p()));
            goto L67
        L51:
            if (r3.canScheduleExactAlarms() != true) goto L53;
            r4 = true;
            goto L54
        L9:
            if (r0 == 2) goto L44;
            if (r0 != 3) goto L13;
            j r10 = j.f10665a;
            j.L(SystemClock.elapsedRealtime());
            PowerManager.WakeLock r20 = j.x();     // Catch: Exception -> L31
            if (r20 != null) goto L22;
        L24:
            boolean r21 = false;
        L25:
            if (r21 == false) goto L34;
            PowerManager.WakeLock r22 = j.x();     // Catch: Exception -> L31
            if (r22 == null) goto L29;
            r22.release();     // Catch: Exception -> L31
        L29:
            com.obric.matrix.r.c.c.j("WsHeartbeatManager", "released wakelock on connect");     // Catch: Exception -> L31
        L34:
            if (j.n() != com.bytedance.common.wschannel.r.c.f3667k) goto L37;
            if (r14 != null) goto L37;
        L43:
            j r112 = j.f10665a;
            j.O(null);
            j.E(true);
        L37:
            if (j.t() == false) goto L39;
            com.obric.matrix.r.c.c.j("WsHeartbeatManager", "reset heartbeat count for network changed reconnect lastState=" + j.n() + " currentState=" + r11 + " pendingReconnectScene=" + r14 + " oldHeartbeatCount=" + j.l());
            j r23 = j.f10665a;
            j.I(0);
            j.P(false);
        L40:
            j r24 = j.f10665a;
            j.J(SystemClock.elapsedRealtime());
            com.obric.matrix.r.c.c.b("WsHeartbeatManager", "start heartbeat session and send ping when ws connected pendingReconnectScene=" + r14);
            j.D(r24);
            long r25 = j.z(r24);
            if (r25 <= 0) goto L43;
            j.C(r24, r25);
            j.F(r25);
            j.N(r25);
            j.H(false);
            j.T(true);
            j.k().clear();
            goto L43
        L39:
            com.obric.matrix.r.c.c.b("WsHeartbeatManager", "start heartbeat session without network-change reset lastState=" + j.n() + " currentState=" + r11 + " pendingReconnectScene=" + r14 + " heartbeatCount=" + j.l());
            goto L40
        L22:
            if (r20.isHeld() != true) goto L24;
            r21 = true;
        L31:
            e = move-exception;
            com.obric.matrix.r.c.c.g("WsHeartbeatManager", "failed to release wakelock", e);
            goto L34
        L13:
            if (j.n() != com.bytedance.common.wschannel.r.c.f3667k) goto L16;
            if (r14 != null) goto L16;
            j r26 = j.f10665a;
            j.G(j.j() + 1);
            o.e(r11, "currentState");
            j.f(r26, "reconnect_started_without_terminal_state", r11);
            com.obric.matrix.r.c.c.j("WsHeartbeatManager", "count implicit reconnect disconnectCount=" + j.j() + " currentState=" + r11 + " lastState=" + j.n());
        L16:
            if (r14 == null) goto L93;
            com.obric.matrix.r.c.c.j("WsHeartbeatManager", "reconnect request observed non-connected state scene=" + r14 + " currentState=" + r11);
            j r113 = j.f10665a;
            j.O(null);
            goto L93
        L5:
            r0 = a.f10677a[r11.ordinal()];
            goto L7
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
        public void d(WsChannelMsg r1) {
            o.f(r1, "wsChannelMsg");
            com.obric.matrix.r.c.c.b("WsHeartbeatManager", "do nothing");
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0017J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0017J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"com/obric/matrix/ws/internal/WsHeartbeatManager$systemStateListener$1", "Lcom/obric/matrix/base/system/ISystemStateListener;", "onNetworkAvailable", "", "network", "Landroid/net/Network;", "onNetworkBackOnline", "onNetworkLost", "onPowerSaveModeChanged", "enter", "", "onScreenStateChanged", "on", "ws_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c implements com.obric.matrix.q.h.d {
        c() {
        }

        @Override // com.obric.matrix.q.h.d
        @SuppressLint({"NewApi"})
        public void a(Network r4) {
            j r3 = j.f10665a;
            if (j.V(r3, r4) == false) goto L6;
            com.obric.matrix.r.c.c.b("WsHeartbeatManager", "skip onNetworkAvailable after bootstrap/back online: " + r4);
            return;
        L6:
            com.obric.matrix.r.c.c.b("WsHeartbeatManager", "onNetworkAvailable: " + r4);
            j.b(r3, r4, false, true);
        }

        @Override // com.obric.matrix.q.h.d
        public void b(boolean r1) {
        }

        @Override // com.obric.matrix.q.h.d
        public void c(boolean r1) {
        }

        @Override // com.obric.matrix.q.h.d
        @SuppressLint({"NewApi"})
        public void d(Network r3) {
            j r2 = j.f10665a;
            j.A(r2, r3);
            com.obric.matrix.r.c.c.b("WsHeartbeatManager", "onNetworkBackOnline: " + r3);
            j.b(r2, r3, true, false);
            j.E(false);
        }

        @Override // com.obric.matrix.q.h.d
        public void f(Network r7) {
            com.obric.matrix.r.c.c.b("WsHeartbeatManager", "onNetworkLost: " + r7);
            long r6 = SystemClock.elapsedRealtime();
            if (j.o() <= 0) goto L9;
            j r0 = j.f10665a;
            j.S(j.v() + (r6 - j.o()));
            if (j.n() != com.bytedance.common.wschannel.r.c.f3667k) goto L9;
            if (j.m() <= 0) goto L9;
            j.R(j.u() + (r6 - Math.max(j.m(), j.o())));
        L9:
            j.B(j.f10665a);
        }
    }

    static {
        f10665a = new j();
        f10674j = new ConcurrentLinkedDeque();
        y = com.bytedance.common.wschannel.r.c.f3663g;
        z = new b();
        A = new c();
    }

    private j() {
    }

    public static final /* synthetic */ void A(j r0, Network r1) {
        r0.j0(r1);
    }

    public static final /* synthetic */ void B(j r0) {
        r0.n0();
    }

    public static final /* synthetic */ void C(j r0, long r1) {
        r0.p0(r1);
    }

    public static final /* synthetic */ void D(j r0) {
        r0.t0();
    }

    public static final /* synthetic */ void E(boolean r0) {
        w = r0;
    }

    public static final /* synthetic */ void F(long r0) {
        f10668d = r0;
    }

    public static final /* synthetic */ void G(int r0) {
        o = r0;
    }

    public static final /* synthetic */ void H(boolean r0) {
        f10671g = r0;
    }

    public static final /* synthetic */ void I(long r0) {
        p = r0;
    }

    public static final /* synthetic */ void J(long r0) {
        f10675k = r0;
    }

    public static final /* synthetic */ void K(com.bytedance.common.wschannel.r.c r0) {
        y = r0;
    }

    public static final /* synthetic */ void L(long r0) {
        q = r0;
    }

    public static final /* synthetic */ void M(long r0) {
        v = r0;
    }

    public static final /* synthetic */ void N(long r0) {
        f10669e = r0;
    }

    public static final /* synthetic */ void O(String r0) {
        r = r0;
    }

    public static final /* synthetic */ void P(boolean r0) {
        s = r0;
    }

    public static final /* synthetic */ void Q(int r0) {
        f10672h = r0;
    }

    public static final /* synthetic */ void R(long r0) {
        f10676l = r0;
    }

    public static final /* synthetic */ void S(long r0) {
        n = r0;
    }

    public static final /* synthetic */ void T(boolean r0) {
        f10673i = r0;
    }

    public static final /* synthetic */ void U(boolean r0) {
        f10667c = r0;
    }

    public static final /* synthetic */ boolean V(j r0, Network r1) {
        return r0.u0(r1);
    }

    @RequiresApi(31)
    private final void W(Network r12, boolean r13, boolean r14) {
        if (r13 == false) goto L5;
        m = SystemClock.elapsedRealtime();
        f10676l = 0;
        n = 0;
        o = 0;
        p = 0;
    L5:
        long r3 = i0();
        f10674j.clear();
        if (r3 <= 0) goto L9;
        f10668d = r3;
        f10669e = r3;
        p0(r3);
        f10671g = false;
        f10673i = true;
        q0(true);
        StringBuilder r11 = new StringBuilder();
        r11.append("applyHeartbeatConfigForCurrentNetwork(");
        r11.append(r12);
        r11.append("): apply learned interval ");
        r11.append(f10668d);
    L8:
        com.obric.matrix.r.c.c.b("WsHeartbeatManager", r11.toString());
        StringBuilder r15 = new StringBuilder();
        r15.append("learned cache ");
        Map<String, ?> r16 = com.obric.matrix.q.e.a.f9851a.e("WS_HEARTBEAT_REPO");
        ArrayList r2 = new ArrayList(r16.size());
        Iterator<Map.Entry<String, ?>> r17 = r16.entrySet().iterator();
    L15:
        if (r17.hasNext() == false) goto L17;
        Map.Entry<String, ?> r18 = r17.next();
        r2.add(r18.getKey() + '-' + r18.getValue());
        goto L15
    L17:
        r15.append(r.Z(r2, null, null, null, 0, null, null, 63, null));
        com.obric.matrix.r.c.c.b("WsHeartbeatManager", r15.toString());
        return;
    L9:
        if (r14 == false) goto L11;
        X();
    L12:
        r0(this, false, 1, null);
        r11 = new StringBuilder();
        r11.append("applyHeartbeatConfigForCurrentNetwork(");
        r11.append(r12);
        r11.append("): reset interval to 2min relearn=");
        r11.append(r14);
        goto L8
    L11:
        f10668d = 120000;
        f10669e = 300000;
        f10671g = false;
        f10673i = false;
        goto L12
    }

    @RequiresApi(31)
    private final void X() {
        b0();
        f10673i = false;
        f10668d = 120000;
        f10669e = 300000;
        f10671g = false;
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    private final void Y(Context r6) {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
        return;
    L5:
        Object r7 = r6.getSystemService("connectivity");
        if ((r7 instanceof ConnectivityManager) == false) goto L8;
        ConnectivityManager r8 = (ConnectivityManager) r7;
    L9:
        if (r8 != null) goto L11;
        return;
    L11:
        Network r0 = r8.getActiveNetwork();
        if (r0 != null) goto L14;
        return;
    L14:
        NetworkCapabilities r9 = r8.getNetworkCapabilities(r0);
        if (r9 != null) goto L18;
        return;
    L18:
        if (r9.hasCapability(12) == true) goto L20;
    L22:
        boolean r10 = false;
    L24:
        if (r10 == true) goto L27;
        com.obric.matrix.r.c.c.b("WsHeartbeatManager", "bootstrapOnlineStateIfNeeded: active network is not validated");
        return;
    L27:
        j0(r0);
        com.obric.matrix.r.c.c.b("WsHeartbeatManager", "bootstrapOnlineStateIfNeeded: " + r0);
        W(r0, true, false);
        return;
    L20:
        if (r9.hasCapability(16) == false) goto L22;
        r10 = true;
        goto L24
    L8:
        r8 = null;
        goto L9
    }

    @SuppressLint({"MissingPermission"})
    private final String Z(Context r9) {
        Object r8 = r9.getSystemService("connectivity");
        Objects.requireNonNull(r8, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager r10 = (ConnectivityManager) r8;
        Network r0 = r10.getActiveNetwork();
        String r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        NetworkCapabilities r11 = r10.getNetworkCapabilities(r0);
        if (r11 != null) goto L8;
        return null;
    L8:
        boolean r2 = true;
        if (r11.hasTransport(1) == false) goto L30;
        Object r12 = r9.getApplicationContext().getSystemService("wifi");
        Objects.requireNonNull(r12, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        WifiManager r13 = (WifiManager) r12;
        WifiInfo r14 = r13.getConnectionInfo();
        if (r14 == null) goto L13;
        String r15 = r14.getSSID();
    L14:
        if (r15 != null) goto L17;
        return null;
    L17:
        if (r15.length() >= 2) goto L19;
    L23:
        WifiInfo r16 = r13.getConnectionInfo();
        if (r16 == null) goto L26;
        r1 = r16.getMacAddress();
    L26:
        if (r1 != null) goto L28;
        r1 = EnvironmentCompat.MEDIA_UNKNOWN;
    L28:
        r1 = "wifi:" + r15 + ':' + r1;
        StringBuilder r17 = new StringBuilder();
    L41:
        r17.append("buildNetworkKey ");
        r17.append(r1);
        com.obric.matrix.r.c.c.b("WsHeartbeatManager", r17.toString());
    L42:
        return r1;
    L19:
        if (kotlin.u0.k.A(r15, "\"", false, 2, null) == false) goto L23;
        if (kotlin.u0.k.n(r15, "\"", false, 2, null) == false) goto L23;
        r15 = r15.substring(1, r15.length() - 1);
        o.e(r15, "this as java.lang.String…ing(startIndex, endIndex)");
        goto L23
    L13:
        r15 = null;
        goto L14
    L30:
        if (r11.hasTransport(0) == false) goto L42;
        Object r18 = r9.getSystemService("phone");
        Objects.requireNonNull(r18, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        String r19 = ((TelephonyManager) r18).getNetworkOperator();
        if (r19 != null) goto L35;
        return null;
    L35:
        if (r19.length() == 0) goto L38;
        r2 = false;
    L38:
        if (r2 == false) goto L40;
        return null;
    L40:
        r1 = "cell:" + r19;
        r17 = new StringBuilder();
        goto L41
    }

    @Proxy("registerReceiver")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @RequiresApi(api = 26)
    public static Intent a(Context r1, BroadcastReceiver r2, IntentFilter r3, int r4) {
        return r1.registerReceiver(r2, r3, r4);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4);
    }

    private final void a0() {
        AlarmManager r0 = t;
        if (r0 == null) goto L5;
        r0.cancel(d0());
    L5:
        com.obric.matrix.r.c.c.b("WsHeartbeatManager", "cancel pong timeout");
    }

    public static final /* synthetic */ void b(j r0, Network r1, boolean r2, boolean r3) {
        r0.W(r1, r2, r3);
    }

    private final void b0() {
        Context r0 = f10666b;
        if (r0 != null) goto L5;
        return;
    L5:
        String r4 = Z(r0);
        if (r4 != null) goto L8;
        return;
    L8:
        com.obric.matrix.q.e.a r1 = com.obric.matrix.q.e.a.f9851a;
        r1.b("WS_HEARTBEAT_INTERVAL_" + r4, "WS_HEARTBEAT_REPO");
        r1.b("WS_HEARTBEAT_SAVEDAT_" + r4, "WS_HEARTBEAT_REPO");
    }

    public static final /* synthetic */ void c(j r0) {
        r0.X();
    }

    private final PendingIntent c0() {
        Intent r3 = new Intent("com.obric.matrix.ws.PING_ACTION");
        Context r0 = f10666b;
        if (r0 == null) goto L5;
        String r1 = r0.getPackageName();
    L6:
        r3.setPackage(r1);
        PendingIntent r4 = PendingIntent.getBroadcast(f10666b, 1001, r3, 201326592);
        o.e(r4, "pendingIntent");
        return r4;
    L5:
        r1 = null;
        goto L6
    }

    public static final /* synthetic */ void d(j r0) {
        r0.a0();
    }

    private final PendingIntent d0() {
        Intent r3 = new Intent("com.obric.matrix.ws.PONG_TIMEOUT_ACTION");
        Context r0 = f10666b;
        if (r0 == null) goto L5;
        String r1 = r0.getPackageName();
    L6:
        r3.setPackage(r1);
        PendingIntent r4 = PendingIntent.getBroadcast(f10666b, 1002, r3, 201326592);
        o.e(r4, "getBroadcast(\n          ….FLAG_IMMUTABLE\n        )");
        return r4;
    L5:
        r1 = null;
        goto L6
    }

    public static final /* synthetic */ PendingIntent e(j r0) {
        return r0.c0();
    }

    private final void e0(String r11, com.bytedance.common.wschannel.r.c r12) {
        long r0 = SystemClock.elapsedRealtime();
        if (f10675k > 0) goto L5;
    L7:
        com.obric.matrix.r.c.c.j("WsHeartbeatManager", "endCurrentConnectionSegment reason=" + r11 + " currentState=" + r12 + " lastState=" + y + " lastConnectedTime=" + f10675k + " lastNetworkAvailableTime=" + m + " totalConnectedDuration=" + f10676l);
        f10675k = 0;
        return;
    L5:
        if (m <= 0) goto L7;
        f10676l += r0 - Math.max(f10675k, m);
        goto L7
    }

    public static final /* synthetic */ void f(j r0, String r1, com.bytedance.common.wschannel.r.c r2) {
        r0.e0(r1, r2);
    }

    public static final /* synthetic */ AlarmManager g() {
        return t;
    }

    public static final /* synthetic */ boolean h() {
        return w;
    }

    private final boolean h0(JSONObject r6) {
        if (((IPushConfig) com.bytedance.news.common.settings.e.e(IPushConfig.class)).enableRSTOpt() == true) goto L26;
        return true;
    L26:
        v.a r2 = v.f21457g;     // Catch: Throwable -> L21
        if (r6 != null) goto L9;
        return false;
    L9:
        String r7 = r6.optString(WsConstants.KEY_CONNECTION_ERROR);     // Catch: Throwable -> L21
        if (r7 != null) goto L13;
        r7 = "";
    L14:
        JSONObject r3 = new JSONObject(r7);     // Catch: Throwable -> L21
        int r8 = r3.optInt("code", 0);     // Catch: Throwable -> L21
        String r4 = r3.optString("message", "");     // Catch: Throwable -> L21
        if (r8 == 1006) goto L17;
    L20:
        return false;
    L17:
        if (o.a(r4, "OnReadDone error: -101") == false) goto L20;
        com.obric.matrix.r.c.c.j("WsHeartbeatManager", "RST error");     // Catch: Throwable -> L21
        return true;
    L13:
        o.e(r7, "connectJson.optString(\"error\") ?: \"\"");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        v.a r1 = v.f21457g;
        Object r9 = w.a(th);
        v.b(r9);
        Throwable r10 = v.d(r9);
        if (r10 == null) goto L25;
        com.obric.matrix.r.c.c.g("WsHeartbeatManager", "isRSTError error", r10);
    L25:
        return false;
    }

    public static final /* synthetic */ long i() {
        return f10668d;
    }

    private final long i0() {
        Context r0 = f10666b;
        if (r0 != null) goto L5;
        return 0;
    L5:
        String r10 = Z(r0);
        if (r10 != null) goto L8;
        return 0;
    L8:
        com.obric.matrix.q.e.a r1 = com.obric.matrix.q.e.a.f9851a;
        long r6 = r1.h("WS_HEARTBEAT_INTERVAL_" + r10, 0L, "WS_HEARTBEAT_REPO");
        long r3 = r1.h("WS_HEARTBEAT_SAVEDAT_" + r10, 0L, "WS_HEARTBEAT_REPO");
        long r8 = System.currentTimeMillis();
        if (r6 > 0) goto L11;
    L15:
        return 0;
    L11:
        if (r3 <= 0) goto L15;
        if ((r8 - r3) > 604800000) goto L15;
        return r6;
    }

    public static final /* synthetic */ int j() {
        return o;
    }

    private final void j0(Network r1) {
        if (r1 == null) goto L4;
        String r0 = r1.toString();
    L5:
        x = r0;
        return;
    L4:
        r0 = null;
        goto L5
    }

    public static final /* synthetic */ ConcurrentLinkedDeque k() {
        return f10674j;
    }

    public static final /* synthetic */ long l() {
        return p;
    }

    public static final /* synthetic */ long m() {
        return f10675k;
    }

    public static final /* synthetic */ com.bytedance.common.wschannel.r.c n() {
        return y;
    }

    private final void n0() {
        if (n <= 0) goto L5;
        double r4 = f10676l / n;
        com.obric.matrix.dataanalysis.j.f9071a.a("ws_online_duration_rate", m0.k(new u[]{a0.a("total_connected_duration", Float.valueOf(f10676l / 1000.0f)), a0.a("total_network_duration", Float.valueOf(n / 1000.0f)), a0.a("online_duration_rate", Double.valueOf(r4)), a0.a("disconnect_count", Integer.valueOf(o))}));
        com.obric.matrix.r.c.c.j("WsHeartbeatManager", "reportOnlineDurationRate: connected=" + f10676l + ", network=" + n + ", rate=" + r4 + ", disconnect_count=" + o);
    L5:
        f10676l = 0;
        n = 0;
        m = 0;
        o = 0;
        p = 0;
    }

    public static final /* synthetic */ long o() {
        return m;
    }

    private final void o0(long r21) {
        Context r2 = f10666b;
        if (r2 != null) goto L5;
        return;
    L5:
        String r4 = Z(r2);
        if (r4 != null) goto L8;
        return;
    L8:
        long r5 = System.currentTimeMillis();
        com.obric.matrix.q.e.a r3 = com.obric.matrix.q.e.a.f9851a;
        long r13 = r3.h("WS_HEARTBEAT_INTERVAL_" + r4, 0L, "WS_HEARTBEAT_REPO");
        long r9 = r3.h("WS_HEARTBEAT_SAVEDAT_" + r4, 0L, "WS_HEARTBEAT_REPO");
        if (r13 == r21) goto L11;
    L12:
        r3.l("WS_HEARTBEAT_INTERVAL_" + r4, Long.valueOf(r21), "WS_HEARTBEAT_REPO");
        r3.l("WS_HEARTBEAT_SAVEDAT_" + r4, Long.valueOf(r5), "WS_HEARTBEAT_REPO");
        com.obric.matrix.r.c.c.b("WsHeartbeatManager", "saveLearned key=" + r4 + " intervalMs=" + r21);
        com.obric.matrix.dataanalysis.j.f9071a.a("ws_heartbeat_learned", m0.k(new u[]{a0.a("interval_ms", Long.valueOf(r21)), a0.a("key", r.Z(r.t0(kotlin.u0.k.n0(r4, new String[]{":"}, false, 0, 6, null), 1), ":", null, null, 0, null, null, 62, null))}));
    L13:
        p0(r21);
        return;
    L11:
        if (Math.abs(r9 - r5) < 604800000) goto L13;
        goto L12
    }

    public static final /* synthetic */ long p() {
        return f10670f;
    }

    private final void p0(long r5) {
        Context r4 = f10666b;
        if (r4 != null) goto L6;
        return;
    L6:
        if (Settings.Global.getLong(r4.getContentResolver(), "matrix_ws_heartbeat_interval_ms", 0) == r5) goto L9;
        Settings.Global.putLong(r4.getContentResolver(), "matrix_ws_heartbeat_interval_ms", r5);
        return;
    }

    public static final /* synthetic */ long q() {
        return v;
    }

    @RequiresApi(31)
    private final void q0(boolean r9) {
        if (com.obric.matrix.r.e.h.d() == true) goto L6;
        com.obric.matrix.r.c.c.j("WsHeartbeatManager", "network is not connected, skip schedule next ping");
        return;
    L6:
        AlarmManager r0 = t;
        boolean r2 = false;
        if (r0 != null) goto L9;
    L11:
        if (r2 == false) goto L13;
        com.obric.matrix.r.c.c.b("WsHeartbeatManager", "don't support scheduleExactAlarms");
    L13:
        PendingIntent r8 = c0();
        long r3 = SystemClock.elapsedRealtime();
        long r4 = f10668d;
        if (r9 == false) goto L16;
        long r5 = ((r3 / r4) + 1) * r4;
    L17:
        AlarmManager r1 = t;
        if (r1 == null) goto L20;
        r1.setExactAndAllowWhileIdle(2, r5, r8);
    L20:
        com.obric.matrix.r.c.c.b("WsHeartbeatManager", "schedule next ping " + f10668d + " ms learn=" + r9 + " nextTriggerTime=" + r5);
        return;
    L16:
        r5 = r3 + r4;
        goto L17
    L9:
        if (r0.canScheduleExactAlarms() == true) goto L11;
        r2 = true;
        goto L11
    }

    public static final /* synthetic */ long r() {
        return f10669e;
    }

    static /* synthetic */ void r0(j r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.q0(r1);
    }

    public static final /* synthetic */ String s() {
        return r;
    }

    @RequiresApi(31)
    private final void s0() {
        AlarmManager r0 = t;
        boolean r1 = false;
        if (r0 == null) goto L8;
        if (r0.canScheduleExactAlarms() == true) goto L8;
        r1 = true;
    L8:
        if (r1 == false) goto L10;
        com.obric.matrix.r.c.c.b("WsHeartbeatManager", "don't support scheduleExactAlarms");
    L10:
        PendingIntent r5 = d0();
        long r2 = SystemClock.elapsedRealtime() + IdleTaskConfig.IDLE_START_TIME_OUT;
        AlarmManager r3 = t;
        if (r3 == null) goto L13;
        r3.setExactAndAllowWhileIdle(2, r2, r5);
    L13:
        com.obric.matrix.r.c.c.b("WsHeartbeatManager", "schedule pong timeout in 15000 ms");
    }

    public static final /* synthetic */ boolean t() {
        return s;
    }

    private final void t0() {
        long r0 = p;
        a0();
        ((IPush) com.bytedance.news.common.service.manager.d.a(IPush.class)).sendPing(r0);
        com.obric.matrix.r.c.c.b("WsHeartbeatManager", "send ping, count: " + r0);
        p = p + 1;
        s0();
        f10667c = true;
        n.a().h();
    }

    public static final /* synthetic */ long u() {
        return f10676l;
    }

    private final boolean u0(Network r4) {
        String r3 = x;
        if (r3 != null) goto L5;
        return false;
    L5:
        String r1 = null;
        x = null;
        if (r4 == null) goto L9;
        r1 = r4.toString();
    L9:
        if (o.a(r3, r1) == true) goto L12;
        com.obric.matrix.r.c.c.b("WsHeartbeatManager", "consume skip target=" + r3 + " but current=" + r1);
        return false;
    L12:
        return true;
    }

    public static final /* synthetic */ long v() {
        return n;
    }

    public static final /* synthetic */ boolean w() {
        return f10673i;
    }

    public static final /* synthetic */ PowerManager.WakeLock x() {
        return u;
    }

    public static final /* synthetic */ boolean y(j r0, JSONObject r1) {
        return r0.h0(r1);
    }

    public static final /* synthetic */ long z(j r2) {
        return r2.i0();
    }

    public final long f0() {
        return q;
    }

    public final void g0(Context r5) {
        o.f(r5, "context");
        f10666b = r5;
        Object r0 = r5.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.app.AlarmManager");
        t = (AlarmManager) r0;
        Object r1 = r5.getSystemService("power");
        PowerManager.WakeLock r2 = null;
        if ((r1 instanceof PowerManager) == false) goto L5;
        PowerManager r3 = (PowerManager) r1;
    L6:
        if (r3 == null) goto L8;
        r2 = r3.newWakeLock(1, "Matrix:WsReconnectWakeLock");
    L8:
        u = r2;
        if (r2 == null) goto L11;
        r2.setReferenceCounted(false);
    L11:
        n.a().registerListener(z);
        IntentFilter r4 = new IntentFilter();
        r4.addAction("com.obric.matrix.ws.PING_ACTION");
        r4.addAction("com.obric.matrix.ws.PONG_TIMEOUT_ACTION");
        Context r6 = f10666b;
        if (r6 == null) goto L14;
        a(r6, new a(), r4, 4);
    L14:
        com.obric.matrix.q.h.k.l(A);
        Y(r5);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void k0(String r5) {
        o.f(r5, "scene");
        if (((IPushConfig) com.bytedance.news.common.settings.e.e(IPushConfig.class)).enableNetworkChangeHeartbeatOpt() == true) goto L6;
        com.obric.matrix.r.c.c.j("WsHeartbeatManager", "network changed heartbeat opt disabled, skip reset heartbeat scene=" + r5);
        return;
    L6:
        s = true;
        com.obric.matrix.r.c.c.j("WsHeartbeatManager", "network changed reconnect requested, mark reset heartbeat on next connected scene=" + r5 + " lastState=" + y + " heartbeatCount=" + p + " pendingScene=" + r);
        m0(r5);
    }

    @RequiresApi(31)
    public final void l0(long r9) {
        com.obric.matrix.r.c.c.b("WsHeartbeatManager", "onPongReceive: " + r9);
        q = SystemClock.elapsedRealtime();
        if (f10667c == false) goto L28;
        boolean r10 = false;
        f10667c = false;
        a0();
        if (p <= 1) goto L21;
        long r2 = f10668d;
        f10670f = r2;
        if (f10673i == false) goto L9;
        f10672h = 0;
        goto L21
    L9:
        if (f10671g == true) goto L12;
        f10668d = Math.min(TimeUnit.SECONDS.toMillis(30) + r2, f10669e);
    L12:
        if (f10671g == false) goto L14;
    L16:
        f10672h = 0;
    L18:
        if (f10672h < 4) goto L21;
        o0(f10668d);
        Settings.Global.putInt(com.bytedance.mpaas.app.a.a().getContentResolver(), "ws_heartbeat_stable", 1);
        goto L21
    L14:
        if (f10668d != r2) goto L16;
        f10672h++;
    L21:
        f10671g = false;
        if (f10672h < 4) goto L24;
    L25:
        r10 = true;
    L26:
        q0(r10);
        return;
    L24:
        if (f10673i == false) goto L26;
    }

    public final void m0(String r6) {
        o.f(r6, "scene");
        String r0 = r;
        com.obric.matrix.r.c.c.j("WsHeartbeatManager", "onReconnectRequested scene=" + r6 + " pendingScene=" + r0 + " currentState=" + y + " lastConnectedTime=" + f10675k + " lastNetworkAvailableTime=" + m);
        if (r0 == null) goto L5;
    L9:
        if (r0 != null) goto L13;
        r = r6;
        return;
    L13:
        return;
    L5:
        if (y != com.bytedance.common.wschannel.r.c.f3667k) goto L9;
        if (f10675k <= 0) goto L9;
        o++;
        r = r6;
        e0("reconnect_requested:" + r6, y);
    }
}
