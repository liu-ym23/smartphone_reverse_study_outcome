package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.IntegerParcelable;
import com.bytedance.common.wschannel.model.ServiceParcelable;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class b implements WeakHandler.IHandler, f.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final WeakHandler f3714f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f3715g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f3716h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final g f3717i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.bytedance.common.wschannel.channel.a f3718j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.bytedance.common.wschannel.server.a f3719k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private AtomicLong f3720l;
    private f m;
    private boolean n;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f3721f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f3722g;

        a(b r1, f r2) {
            this.f3722g = r1;
            this.f3721f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3721f.b();
            b r1 = this.f3722g;
            b.c(r1, b.b(r1).a());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.server.b$b, reason: collision with other inner class name */
    class RunnableC0105b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Message f3723f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f3724g;

        RunnableC0105b(b r1, Message r2) {
            this.f3724g = r1;
            this.f3723f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3723f.what != 1) goto L5;
        L7:
            b.e(this.f3724g, this.f3723f);
            return;
        L5:
            if (b.d(this.f3724g).a() == true) goto L7;
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ IWsChannelClient f3725f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f3726g;

        c(b r1, IWsChannelClient r2) {
            this.f3726g = r1;
            this.f3725f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.f(this.f3726g, this.f3725f);
        }
    }

    b(Context r4, Looper r5, g r6, com.bytedance.common.wschannel.server.a r7, com.bytedance.common.wschannel.channel.a r8, f r9) {
        this.f3716h = new Object();
        this.f3720l = new AtomicLong(0);
        this.n = false;
        this.f3715g = r4.getApplicationContext();
        this.f3714f = new WeakHandler(r5, this);
        this.f3717i = r6;
        this.f3719k = r7;
        this.f3718j = r8;
        this.m = r9;
        r9.c(this);
        p(new a(this, r9));
    }

    static /* synthetic */ g b(b r0) {
        return r0.f3717i;
    }

    static /* synthetic */ void c(b r0, Map r1) {
        r0.v(r1);
    }

    static /* synthetic */ f d(b r0) {
        return r0.m;
    }

    static /* synthetic */ void e(b r0, Message r1) {
        r0.h(r1);
    }

    static /* synthetic */ void f(b r0, IWsChannelClient r1) {
        r0.r(r1);
    }

    private void h(Message r11) {
        int r0 = r11.what;     // Catch: Throwable -> L134
        if (r0 == 0) goto L130;
        boolean r1 = true;
        if (r0 == 1) goto L107;
        boolean r3 = false;
        if (r0 != 2) goto L9;
        int r12 = r11.arg1;     // Catch: Throwable -> L134
        if (Logger.debug() == false) goto L96;
        Logger.d("WsChannelService", "appState = " + r12);     // Catch: Throwable -> L134
    L96:
        if (r12 == 1) goto L99;
        r1 = false;
    L99:
        this.n = r1;     // Catch: Throwable -> L134
        this.f3718j.c();     // Catch: Throwable -> L134
        if (l() == false) goto L166;
        q(this.f3719k.f3712b.values());     // Catch: Throwable -> L134
        Iterator<IWsChannelClient> r10 = this.f3719k.f3712b.values().iterator();     // Catch: Throwable -> L134
    L103:
        if (r10.hasNext() == false) goto L172;
        IWsChannelClient r2 = r10.next();     // Catch: Throwable -> L134
        if (r2 == null) goto L103;
        r2.onAppStateChanged(r12);     // Catch: Throwable -> L134
        goto L103
    L172:
        return;
    L166:
        return;
    L9:
        if (r0 != 3) goto L11;
        int r13 = r11.arg1;     // Catch: Throwable -> L134
        if (Logger.debug() == false) goto L85;
        Logger.d("WsChannelService", "networkState = " + r13);     // Catch: Throwable -> L134
    L85:
        this.f3718j.c();     // Catch: Throwable -> L134
        if (l() == false) goto L165;
        Iterator<IWsChannelClient> r14 = this.f3719k.f3712b.values().iterator();     // Catch: Throwable -> L134
    L89:
        if (r14.hasNext() == false) goto L171;
        IWsChannelClient r4 = r14.next();     // Catch: Throwable -> L134
        if (r4 == null) goto L89;
        r4.onNetworkStateChanged(r13);     // Catch: Throwable -> L134
        goto L89
    L171:
        return;
    L165:
        return;
    L11:
        if (r0 != 4) goto L13;
        r11.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r15 = r11.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L134
        if ((r15 instanceof IWsApp) == false) goto L163;
        i((IWsApp) r15);     // Catch: Throwable -> L134
        return;
    L163:
        return;
    L13:
        if (r0 != 5) goto L15;
    L39:
        if (r0 == 10) goto L42;
        r1 = false;
    L42:
        r11.getData().setClassLoader(WsChannelMsg.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r5 = r11.getData().getParcelable(WsConstants.KEY_PAYLOAD);     // Catch: Throwable -> L134
        if ((r5 instanceof WsChannelMsg) == false) goto L160;
        WsChannelMsg r6 = (WsChannelMsg) r5;     // Catch: Throwable -> L134
        if (r6.q() > 0) goto L47;
        r6.M(this.f3720l.incrementAndGet());     // Catch: Throwable -> L134
    L47:
        IWsChannelClient r7 = this.f3719k.f3712b.get(Integer.valueOf(r6.c()));     // Catch: Throwable -> L134
        if (r1 == false) goto L50;
        Logger.d("WsChannelService", "retry send msg");     // Catch: Throwable -> L134
    L50:
        if (r7 == null) goto L75;
        if (r0 == 10) goto L58;
        if ((r7 instanceof com.bytedance.common.wschannel.channel.b) == false) goto L58;
        if (((com.bytedance.common.wschannel.channel.b) r7).b() == false) goto L58;
        u(r7, r6);     // Catch: Throwable -> L134
    L58:
        if (r7.privateProtocolEnabled() == true) goto L60;
    L62:
        boolean r8 = r7.sendMessage(com.bytedance.common.wschannel.q.b.a().b(r6));     // Catch: Throwable -> L134
    L63:
        r3 = r8;
        long r9 = com.bytedance.common.wschannel.o.f(this.f3715g).c();     // Catch: Throwable -> L134
        if (r3 == true) goto L69;
        if (r1 == true) goto L69;
        if (r9 <= 0) goto L69;
        Message r16 = Message.obtain(r11);     // Catch: Throwable -> L134
        r16.what = 10;     // Catch: Throwable -> L134
        this.f3714f.sendMessageDelayed(r16, r9);     // Catch: Throwable -> L134
    L69:
        if (r3 == false) goto L71;
    L73:
        com.bytedance.common.wschannel.channel.a r17 = this.f3718j;     // Catch: Throwable -> L134
    L74:
        r17.a(r6, r3);     // Catch: Throwable -> L134
    L77:
        if (Logger.debug() == false) goto L161;
        Logger.d("WsChannelService", "send payload success = " + r3);     // Catch: Throwable -> L134
        return;
    L161:
        return;
    L71:
        if (r9 <= 0) goto L73;
        if (r1 == false) goto L77;
    L60:
        if (r7.privateProtocolProxyEnabled() == true) goto L62;
        r8 = r7.sendMessage(r6);     // Catch: Throwable -> L134
        goto L63
    L75:
        r17 = this.f3718j;     // Catch: Throwable -> L134
        goto L74
    L160:
        return;
    L15:
        if (r0 == 9) goto L38;
        if (r0 == 10) goto L39;
        if (r0 != 12) goto L20;
        r11.getData().setClassLoader(ServiceParcelable.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r18 = r11.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L134
        if ((r18 instanceof ServiceParcelable) == false) goto L156;
        int r19 = ((ServiceParcelable) r18).c();     // Catch: Throwable -> L134
        int r110 = ((ServiceParcelable) r18).b();     // Catch: Throwable -> L134
        IWsChannelClient r111 = this.f3719k.f3712b.get(Integer.valueOf(r19));     // Catch: Throwable -> L134
        if (r111 != null) goto L35;
        return;
    L35:
        if (Logger.debug() == false) goto L37;
        Logger.d("WsChannelService", "register serviceId = " + r110);     // Catch: Throwable -> L134
    L37:
        r111.registerService(r110);     // Catch: Throwable -> L134
        return;
    L156:
        return;
    L20:
        if (r0 != 13) goto L152;
        r11.getData().setClassLoader(ServiceParcelable.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r112 = r11.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L134
        if ((r112 instanceof ServiceParcelable) == false) goto L153;
        int r20 = ((ServiceParcelable) r112).c();     // Catch: Throwable -> L134
        int r113 = ((ServiceParcelable) r112).b();     // Catch: Throwable -> L134
        IWsChannelClient r114 = this.f3719k.f3712b.get(Integer.valueOf(r20));     // Catch: Throwable -> L134
        if (r114 != null) goto L27;
        return;
    L27:
        if (Logger.debug() == false) goto L29;
        Logger.d("WsChannelService", "unregister serviceId = " + r113);     // Catch: Throwable -> L134
    L29:
        r114.unregisterService(r113);     // Catch: Throwable -> L134
        return;
    L153:
        return;
    L152:
        return;
    L38:
        this.f3718j.e();     // Catch: Throwable -> L134
        return;
    L107:
        r11.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r115 = r11.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L134
        if ((r115 instanceof IntegerParcelable) == false) goto L167;
        int r116 = ((IntegerParcelable) r115).b();     // Catch: Throwable -> L134
        monitor-enter(WsChannelService.class);     // Catch: Throwable -> L134
        this.f3719k.f3711a.remove(Integer.valueOf(r116));     // Catch: Throwable -> L127
        this.f3717i.b(this.f3719k.f3711a);     // Catch: Throwable -> L127
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L127
        Object r21 = this.f3716h;     // Catch: Throwable -> L134
        monitor-enter(r21);     // Catch: Throwable -> L134
        IWsChannelClient r22 = this.f3719k.f3712b.remove(Integer.valueOf(r116));     // Catch: Throwable -> L124
        monitor-exit(r21);     // Catch: Throwable -> L124
        if (r22 != null) goto L119;
    L122:
        this.f3719k.f3713c.remove(Integer.valueOf(r116));     // Catch: Throwable -> L134
        this.f3714f.sendMessageDelayed(this.f3714f.obtainMessage(8, r22), 1000);     // Catch: Throwable -> L134
        return;
    L119:
        if (Logger.debug() == false) goto L121;
        Logger.d("WsChannelService", "stopConnection,channelId = " + r116);     // Catch: Throwable -> L134
    L121:
        r22.destroy();     // Catch: Throwable -> L134
        goto L122
    L124:
        th = move-exception;
        throw th;     // Catch: Throwable -> L134
    L127:
        th = move-exception;
        throw th;     // Catch: Throwable -> L134
    L167:
        return;
    L130:
        r11.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r117 = r11.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L134
        if ((r117 instanceof IWsApp) == false) goto L168;
        j((IWsApp) r117);     // Catch: Throwable -> L134
        return;
    L168:
        return;
    L134:
        th = move-exception;
        th.printStackTrace();
    }

    private void i(@NonNull IWsApp r6) {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "doOnParamChange");
    L5:
        int r0 = WsChannelService.d(r6);
        if (l() == false) goto L33;
        IWsChannelClient r1 = this.f3719k.f3712b.get(Integer.valueOf(r6.c()));     // Catch: Throwable -> L28
        monitor-enter(WsChannelService.class);     // Catch: Throwable -> L28
        IWsApp r3 = this.f3719k.f3711a.get(Integer.valueOf(r0));     // Catch: Throwable -> L25
        if (r1 != null) goto L12;
    L23:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L25
        return;
    L12:
        if (r6.equals(r3) == true) goto L14;
    L16:
        this.f3719k.f3711a.put(Integer.valueOf(r0), r6);     // Catch: Throwable -> L25
        this.f3717i.b(this.f3719k.f3711a);     // Catch: Throwable -> L25
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L25
        Map<String, Object> r5 = k(r6);     // Catch: Throwable -> L28
        if (r5 == null) goto L22;
        r1.onParameterChange(r5, r6.f0());     // Catch: Throwable -> L28
        return;
    L22:
        throw new IllegalArgumentException("configMap is empty !!!");     // Catch: Throwable -> L28
    L14:
        if (r1.isConnected() == false) goto L16;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    private void j(@NonNull IWsApp r9) {
        int r0 = WsChannelService.d(r9);
        if (l() == true) goto L6;
        return;
    L6:
        monitor-enter(WsChannelService.class);
        IWsApp r2 = this.f3719k.f3711a.get(Integer.valueOf(r0));     // Catch: Throwable -> L22
        IWsChannelClient r3 = this.f3719k.f3712b.get(Integer.valueOf(r0));     // Catch: Throwable -> L22
        boolean r4 = false;
        boolean r5 = true;
        if (r2 != null) goto L10;
    L14:
        if (r2 != null) goto L16;
        this.f3719k.f3711a.put(Integer.valueOf(r0), r9);     // Catch: Throwable -> L22
        this.f3717i.b(this.f3719k.f3711a);     // Catch: Throwable -> L22
    L12:
        r5 = false;
        r4 = true;
    L16:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L22
        if (r4 == false) goto L19;
        w(r9);
        return;
    L19:
        if (r5 == false) goto L28;
        i(r9);
        return;
    L28:
        return;
    L10:
        if (r9.equals(r2) == false) goto L14;
        if (r3 == null) goto L12;
        r5 = false;
    L22:
        th = move-exception;
        throw th;
    }

    private Map<String, Object> k(IWsApp r11) {
        HashMap r0 = new HashMap();
        r0.put(WsConstants.KEY_APP_KEY, r11.r());
        r0.put(WsConstants.KEY_FPID, Integer.valueOf(r11.b0()));
        r0.put("sdk_version", 2);
        r0.put(WsConstants.KEY_PLATFORM, 0);
        r0.put(WsConstants.KEY_APP_VERSION, Integer.valueOf(r11.a()));
        r0.put(WsConstants.KEY_APP_ID, Integer.valueOf(r11.getAppId()));
        r0.put(WsConstants.KEY_DEVICE_ID, r11.getDeviceId());
        r0.put(WsConstants.KEY_INSTALL_ID, r11.getInstallId());
        r0.put(WsConstants.KEY_HEADERS, r11.t());
        String r3 = r11.getExtra();
        if (r3 != null) goto L6;
        o(WsConstants.KEY_EXTRA);
        r3 = "";
    L6:
        if (com.bytedance.common.wschannel.o.f(this.f3715g).j() == false) goto L17;
        String[] r7 = r3.split("&");
        StringBuilder r8 = new StringBuilder();
        r8.append("is_background=");
        if (n() == false) goto L10;
        String r9 = BDLocationException.ERROR_TIMEOUT;
    L11:
        r8.append(r9);
        String r10 = r8.toString();
        if (r7.length > 0) goto L14;
    L16:
        r3 = r10;
        goto L17
    L14:
        if (TextUtils.isEmpty(r7[0]) == true) goto L16;
        r3 = r3 + "&" + r10;
        goto L17
    L10:
        r9 = LocationInfoConst.ALLOW_USE_LOCATION;
    L17:
        r0.put(WsConstants.KEY_EXTRA, r3);
        if (r11.getDeviceId() != null) goto L21;
        o(WsConstants.KEY_DEVICE_ID);
    L21:
        if (r11.getInstallId() != null) goto L24;
        o("install_id");
    L24:
        if (com.bytedance.common.utility.k.c(r11.r()) == false) goto L26;
        o(WsConstants.KEY_APP_KEY);
    L26:
        r0.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, Boolean.valueOf(r11.n()));
        if (r11.u() == null) goto L30;
        r0.put(WsConstants.KEY_SERVICE_ID_LIST, r11.u());
    L30:
        if (TextUtils.isEmpty(r11.I()) == true) goto L32;
        r0.put(WsConstants.KEY_PRIVATE_PROTOCOL_URL, r11.I());
    L32:
        r0.put(WsConstants.KEY_TRANSPORT_MODE, Integer.valueOf(r11.k()));
        r0.put(WsConstants.KEY_DISABLE_FALLBACK_WEBSOCKET, Boolean.valueOf(r11.J()));
        return r0;
    }

    private boolean l() {
        return this.m.a();
    }

    private boolean m() {
        Context r1 = this.f3715g;
        if (r1 != null) goto L5;
        return false;
    L5:
        com.bytedance.common.wschannel.o r2 = com.bytedance.common.wschannel.o.f(r1);
        if (r2 != null) goto L9;
        return false;
    L9:
        return r2.h();
    }

    private boolean n() {
        return this.n;
    }

    private void o(String r3) {
        Bundle r0 = new Bundle();
        r0.putString("param_name", r3);
        com.bytedance.common.wschannel.t.a.a(this.f3715g, "wschannel_param_null", r0);
    }

    private void p(Runnable r1) {
        this.f3714f.post(r1);
    }

    private void q(Collection<IWsChannelClient> r2) {
        if (com.bytedance.common.wschannel.o.f(this.f3715g).j() == true) goto L5;
        return;
    L5:
        Iterator<IWsChannelClient> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L13;
        r(r3.next());     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    private void r(IWsChannelClient r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        WsChannelMsg r1 = g();
        if (r2.privateProtocolEnabled() == false) goto L8;
        r2.sendMessage(r1);
        return;
    L8:
        r2.sendMessage(com.bytedance.common.wschannel.q.b.a().b(r1));
    }

    private void s() {
        Object r0 = this.f3716h;     // Catch: Throwable -> L17
        monitor-enter(r0);     // Catch: Throwable -> L17
        Iterator<Map.Entry<Integer, IWsChannelClient>> r1 = this.f3719k.f3712b.entrySet().iterator();     // Catch: Throwable -> L14
    L6:
        if (r1.hasNext() == false) goto L10;
        IWsChannelClient r2 = r1.next().getValue();     // Catch: Throwable -> L14
        if (r2 == null) goto L6;
        r2.destroy();     // Catch: Throwable -> L14
        goto L6
    L10:
        this.f3719k.f3712b.clear();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        this.f3719k.f3711a.clear();     // Catch: Throwable -> L17
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();
    }

    private void v(Map<Integer, IWsApp> r2) {
        if (m() == false) goto L8;
        if (j.c(this.f3715g) == true) goto L8;
        return;
    L8:
        if (this.m.a() == false) goto L17;
        if (r2 == null) goto L23;
        Iterator<IWsApp> r3 = r2.values().iterator();
    L12:
        if (r3.hasNext() == false) goto L24;
        IWsApp r0 = r3.next();
        if (r0 == null) goto L12;
        j(r0);
        goto L12
    L24:
        return;
    L23:
        return;
    }

    private void w(IWsApp r5) {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "tryOpenConnection");
    L5:
        Object r0 = this.f3716h;
        monitor-enter(r0);
        IWsChannelClient r1 = this.f3719k.f3712b.get(Integer.valueOf(r5.c()));     // Catch: Throwable -> L28
        if (r1 != null) goto L10;
        r1 = com.bytedance.common.wschannel.channel.b.c(r5.c(), this.f3718j, this.f3714f);     // Catch: Throwable -> L28
        r1.init(this.f3715g, r1);     // Catch: Throwable -> L28
        this.f3719k.f3712b.put(Integer.valueOf(r5.c()), r1);     // Catch: Throwable -> L28
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L28
        if (r1.isConnected() == false) goto L32;
        SocketState r6 = this.f3719k.f3713c.get(Integer.valueOf(r5.c()));
        Logger.d("WsChannelService", "state = " + r6);
        if (r6 == null) goto L37;
        this.f3718j.h(r1, r6);     // Catch: Throwable -> L31
        return;
    L40:
        return;
    L37:
        return;
    L32:
    L25:
        th = move-exception;
        th.printStackTrace();
        return;
    L18:
        if (Logger.debug() == false) goto L20;
        Logger.d("WsChannelService", "try to open connection ,channelId = " + r5.c());     // Catch: Throwable -> L25
    L20:
        Map<String, Object> r4 = k(r5);     // Catch: Throwable -> L25
        if (r4 == null) goto L24;
        r1.openConnection(r4, r5.f0());     // Catch: Throwable -> L25
        return;
    L24:
        throw new IllegalArgumentException("configMap is empty !!!");     // Catch: Throwable -> L25
    L28:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.wschannel.server.f.a
    public void a(boolean r1) {
        if (r1 == false) goto L4;
        v(this.f3717i.a());
        return;
    L4:
        s();
    }

    @NonNull
    WsChannelMsg g() {
        WsChannelMsg.b r0 = WsChannelMsg.b.c(Integer.MAX_VALUE);
        r0.e(4);
        r0.j(WsConstants.APP_STATE_CHANGE_SERVICE);
        r0.d(1008601);
        r0.f(new byte[0]);
        r0.g("pb");
        r0.h("pb");
        if (n() == false) goto L5;
        String r3 = BDLocationException.ERROR_TIMEOUT;
    L6:
        r0.a(WsConstants.APP_STATE_BACKGROUND_KEY, r3);
        return r0.b();
    L5:
        r3 = LocationInfoConst.ALLOW_USE_LOCATION;
        goto L6
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r2) {
        p(new RunnableC0105b(this, Message.obtain(r2)));
    }

    void t(IWsChannelClient r3) {
        if (r3.isConnected() == true) goto L5;
        return;
    L5:
        this.f3714f.post(new c(this, r3));
    }

    public WsChannelMsg u(IWsChannelClient r2, WsChannelMsg r3) {
        com.bytedance.common.wschannel.o.a r1 = com.bytedance.common.wschannel.o.b();
        if (r1 != null) goto L14;
        return r3;
    L14:
        Iterator<Map.Entry<String, String>> r4 = r1.b(r3.R()).entrySet().iterator();     // Catch: Exception -> L11
    L7:
        if (r4.hasNext() == false) goto L10;
        Map.Entry<String, String> r5 = r4.next();     // Catch: Exception -> L11
        r3.b(r5.getKey(), r5.getValue());     // Catch: Exception -> L11
        goto L7
    L10:
        return r3;
    L11:
        e = move-exception;
        Logger.w("tryAddOkWsPayloadOpaque failed with exception" + e);
        return r3;
    }
}
