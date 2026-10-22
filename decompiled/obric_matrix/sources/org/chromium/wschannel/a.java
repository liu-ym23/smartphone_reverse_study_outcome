package org.chromium.wschannel;

import android.text.TextUtils;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.keva.KevaImpl;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import com.ttnet.org.chromium.net.impl.CronetFrontierClient;
import com.ttnet.org.chromium.net.impl.TTServiceInfo;
import d.b.h.a.a.h.g;
import d.b.h.a.a.h.s.l;
import java.net.CookieHandler;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.chromium.CronetClient;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static CronetEngine o = null;
    private static volatile String p = "";
    private static final String q = null;
    private static boolean r;
    private static volatile AtomicInteger s;
    private static volatile int t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IWsChannelClient f22676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f22677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f22678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicInteger f22679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f22680e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f22681f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<Integer, Boolean> f22682g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private CronetFrontierClient f22683h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AtomicBoolean f22684i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile int f22685j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile boolean f22686k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TTWebsocketConnection f22687l;
    private e m;
    private org.chromium.wschannel.b n;

    /* JADX INFO: renamed from: org.chromium.wschannel.a$a, reason: collision with other inner class name */
    final class C0603a extends d.b.h.a.a.h.s.b {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final Map<String, Object> f22688j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final List<String> f22689k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ a f22690l;

        public C0603a(a r1, long r2, Map<String, Object> r4, List<String> r5) {
            this.f22690l = r1;
            super(r2, a.m());
            this.f22688j = r4;
            this.f22689k = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.j(this.f22690l) == false) goto L6;
            a.n(this.f22690l).set(0);
            a.d(this.f22690l).set(false);
            return;
        L6:
            int r0 = a.n(this.f22690l).incrementAndGet();
            if (Logger.debug() == false) goto L9;
            Logger.d("CronetFrontierConnection", "Fallback to websocket connection, retry attempts:" + r0);
        L9:
            this.f22690l.s();
            a.e(this.f22690l, this.f22688j, this.f22689k);
            JSONObject r1 = new JSONObject();     // Catch: JSONException -> L12
            r1.put(ICronetClient.KEY_RETRY_ATTEMPTS, r0);     // Catch: JSONException -> L12
            r1.put("reason", "connect timeout fallback");     // Catch: JSONException -> L12
            a.f(this.f22690l, r1, 1);     // Catch: JSONException -> L12
            return;
        L12:
            e = move-exception;
            e.printStackTrace();
        }
    }

    class b implements CronetFrontierClient.IServiceMessageReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f22691a;

        b(a r1) {
            this.f22691a = r1;
        }

        @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IServiceMessageReceiver
        public void onError(int r3, int r4, String r5) {
            if (Logger.debug() == false) goto L5;
            Logger.d("CronetFrontierConnection", "onError ServiceId:" + r3 + " error code:" + r4 + " info:" + r5);
        L5:
            a.l(this.f22691a).onServiceConnectEvent(r3, false, "");
        }

        @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IServiceMessageReceiver
        public void onReceivedAck(int r1, long r2, String r4, Boolean r5) {
            if (Logger.debug() == false) goto L6;
            Logger.d("CronetFrontierConnection", "onReceivedAck serviceId:" + r1 + " messageId:" + r2 + " logInfo:" + r4);
            return;
        }

        @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IServiceMessageReceiver
        public void onReceivedMessage(int r7, Map<String, String> r8, byte[] r9) {
            if (a.i(this.f22691a).get() == false) goto L10;
            if (Logger.debug() == false) goto L7;
            Logger.d("CronetFrontierConnection", "proxy onReceivedMessage service id:" + r7 + " data length:" + r9.length);
        L7:
            a.l(this.f22691a).onMessage(r9);
            return;
        L10:
            if (Logger.debug() == false) goto L12;
            Logger.d("CronetFrontierConnection", "onReceivedMessage service id:" + r7 + " data length:" + r9.length);
        L12:
            WsChannelMsg r0 = new WsChannelMsg();
            r0.O(r7);
            ArrayList r10 = new ArrayList();
            Iterator<Map.Entry<String, String>> r11 = r8.entrySet().iterator();
        L14:
            if (r11.hasNext() == false) goto L39;
            Map.Entry<String, String> r1 = r11.next();
            if (TextUtils.isEmpty(r1.getKey()) == true) goto L14;
            if (TextUtils.isEmpty(r1.getValue()) == true) goto L14;
            if (r1.getKey().equals("method_id") == false) goto L27;
            r0.C(Integer.valueOf(r1.getValue()).intValue());     // Catch: NumberFormatException -> L24
        L24:
            e = move-exception;
            Logger.e("CronetFrontierConnection", "method_id is not valid: " + r1.getValue());
            e.printStackTrace();
            goto L14
        L27:
            if (r1.getKey().equalsIgnoreCase("payload_encoding") == true) goto L28;
            if (r1.getKey().equalsIgnoreCase("payload_type") == true) goto L31;
            if (r1.getKey().equalsIgnoreCase("msg_id") == true) goto L34;
            if (r1.getKey().equalsIgnoreCase("server_timing") == true) goto L37;
            WsChannelMsg.MsgHeader r3 = new WsChannelMsg.MsgHeader();
            r3.e(r1.getKey());
            r3.f(r1.getValue());
            r10.add(r3);
            goto L14
        L37:
            r0.N(r1.getValue());
            goto L14
        L34:
            r0.E(r1.getValue());
            goto L14
        L31:
            r0.K(r1.getValue());
            goto L14
        L28:
            r0.H(r1.getValue());
            goto L14
        L39:
            r0.D(r10);
            r0.G(r9);
            if (r0.j() != null) goto L43;
            r0.H("");
        L43:
            if (r0.l() != null) goto L46;
            r0.K("");
        L46:
            if (Logger.debug() == false) goto L48;
            Logger.d("CronetFrontierConnection", "onReceivedMessage:" + r0);
        L48:
            a.l(this.f22691a).onMessage(r0);
        }

        @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IServiceMessageReceiver
        public void onServiceReady(int r5, String r6) {
            if (Logger.debug() == false) goto L6;
            Logger.d("CronetFrontierConnection", "onServiceReady ServiceId:" + r5 + " log info:" + r6);
        L6:
            if (a.a(this.f22691a) == true) goto L16;
            a.b(this.f22691a, true);
            if (a.c(this.f22691a) == null) goto L16;
            if (a.g(this.f22691a) == (-1)) goto L16;
            CronetFrontierClient r7 = a.c(this.f22691a);
            if (a.g(this.f22691a) != 1) goto L14;
            boolean r2 = true;
        L15:
            r7.reportAppStateChange(r2);
            goto L16
        L14:
            r2 = false;
        L16:
            a.h(this.f22691a).put(Integer.valueOf(r5), Boolean.TRUE);
            if (this.f22691a.z() == true) goto L19;
        L26:
            a.l(this.f22691a).onServiceConnectEvent(r5, true, "");
            return;
        L19:
            if (a.i(this.f22691a).get() == false) goto L26;
            if (a.j(this.f22691a) == false) goto L26;
            JSONObject r8 = new JSONObject();     // Catch: Throwable -> L28
            r8.put(WsConstants.KEY_CONNECTION_TYPE, 1);     // Catch: Throwable -> L28
            r8.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, 1);     // Catch: Throwable -> L28
            r8.put(WsConstants.KEY_CONNECTION_STATE, 4);     // Catch: Throwable -> L28
            r8.put(WsConstants.KEY_CONNECTION_URL, a.k());     // Catch: Throwable -> L28
            if (Logger.debug() == false) goto L25;
            Logger.d("CronetFrontierConnection", "PP onConnectionStateChanged state: 4 url:" + a.k());     // Catch: Throwable -> L28
        L25:
            a.l(this.f22691a).onConnection(r8);     // Catch: Throwable -> L28
            goto L26
        }
    }

    static {
        q = UUID.randomUUID().toString();
        r = false;
        CronetFrontierClient.TransportMode r1 = CronetFrontierClient.TransportMode.QUIC;
        s = new AtomicInteger(0);
        t = -1;
    }

    public a(IWsChannelClient r3) {
        this.f22677b = new AtomicBoolean(false);
        this.f22678c = new AtomicBoolean(false);
        this.f22679d = new AtomicInteger(0);
        this.f22680e = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        this.f22681f = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        this.f22682g = new ConcurrentHashMap();
        this.f22684i = new AtomicBoolean(false);
        this.f22685j = -1;
        this.f22686k = false;
        this.f22676a = r3;
        this.m = new e(r3);
        A();     // Catch: Throwable -> L5
    L9:
        o = CronetClient.getCronetEngine();
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        if (Logger.debug() == false) goto L9;
        Logger.d("CronetFrontierConnection", "TTNet init failed, cronet engine is null.");
        goto L9
    }

    private static void A() {
        Object r0 = Class.forName("com.bytedance.ttnet.TTNetInit").newInstance();
        Reflect.on(r0).call("getInitCompletedLatch");
        Reflect.on(r0).call("preInitCronetKernel");
    }

    private static void B(Map<String, Object> r2, List<Integer> r3) {
        ArrayList r4 = (ArrayList) r2.get(WsConstants.KEY_SERVICE_ID_LIST);
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.size() == 0) goto L19;
        Iterator r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L20;
        int r0 = ((Integer) r5.next()).intValue();
        if (r3.contains(Integer.valueOf(r0)) == true) goto L9;
        r3.add(Integer.valueOf(r0));
        goto L9
    L20:
        return;
    }

    private void C(String r8, HashMap<String, String> r9) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        String[] r10 = r8.split("&");
        int r0 = r10.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L28;
        String r3 = r10[r2];
        if (TextUtils.isEmpty(r3) == true) goto L27;
        String[] r4 = r3.split("=");
        if (r4.length != 2) goto L27;
        if (TextUtils.isEmpty(r4[0]) == true) goto L27;
        if (TextUtils.isEmpty(r4[1]) == true) goto L27;
        if (r4[0].equals("ttnet_heartbeat_interval") == false) goto L21;
        this.f22680e = Integer.valueOf(r4[1]).intValue() * 1000;     // Catch: NumberFormatException -> L29
        goto L27
    L21:
        if (r4[0].equals("ttnet_timeout_millis") == false) goto L25;
        this.f22681f = Integer.valueOf(r4[1]).intValue();     // Catch: NumberFormatException -> L29
        goto L27
    L25:
        if (this.f22678c.get() == true) goto L27;
        r9.put(r4[0], r4[1]);
    L27:
        r2 = r2 + 1;
        goto L6
    }

    private URI D(Map<String, Object> r3) {
        String r2 = (String) r3.get(WsConstants.KEY_PRIVATE_PROTOCOL_URL);
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return null;
    L5:
        p = r2;
        if (r2.startsWith("wss:") == false) goto L11;
        StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L15
        r4.append("https:");     // Catch: Throwable -> L15
        String r5 = r2.substring(4);     // Catch: Throwable -> L15
    L9:
        r4.append(r5);     // Catch: Throwable -> L15
        r2 = r4.toString();     // Catch: Throwable -> L15
    L13:
        return l.l(r2);
    L11:
        if (r2.startsWith("ws:") == false) goto L13;
        r4 = new StringBuilder();     // Catch: Throwable -> L15
        r4.append("http:");     // Catch: Throwable -> L15
        r5 = r2.substring(3);     // Catch: Throwable -> L15
    L18:
        return null;
    }

    private void H(int r3, ByteBuffer r4, String[] r5) {
        if (this.f22683h == null) goto L6;
        TTServiceInfo r0 = new TTServiceInfo(r3, new b(this));
        this.f22683h.registerService(r0, r4, r5);
        return;
    }

    private void I(List<WsChannelMsg.MsgHeader> r4) {
        Iterator<WsChannelMsg.MsgHeader> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L32;
        WsChannelMsg.MsgHeader r0 = r5.next();
        if (r0 == null) goto L4;
        if (WsConstants.APP_STATE_BACKGROUND_KEY.equals(r0.b()) == false) goto L4;
        String r6 = r0.d();
        boolean r1 = false;
        if (r6.equals(LocationInfoConst.ALLOW_USE_LOCATION) == false) goto L13;
        this.f22685j = 1;
    L16:
        if (this.f22686k == true) goto L18;
        return;
    L18:
        if (this.f22685j == (-1)) goto L31;
        CronetFrontierClient r7 = this.f22683h;
        if (this.f22685j != 1) goto L22;
        r1 = true;
    L22:
        r7.reportAppStateChange(r1);
        return;
    L31:
        return;
    L13:
        if (r6.equals(BDLocationException.ERROR_TIMEOUT) == false) goto L16;
        this.f22685j = 0;
        goto L16
    }

    private void J(JSONObject r3, int r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        r3.put("report_type", r4);
        r3.put("report_time", System.currentTimeMillis());
        if (Logger.debug() == false) goto L7;
        Logger.d("CronetFrontierConnection", "report log:" + r3.toString());
    L7:
        org.chromium.c.W().y0(r3.toString(), "private_protocol");
    }

    private void P(Map<String, Object> r20, URI r21) {
        int r0 = r21.getPort();
        String r3 = r21.getPath();
        String r4 = r21.getQuery();
        if (r0 > 0) goto L5;
        r0 = 443;
    L5:
        int r8 = r0;
        if (Logger.debug() == false) goto L8;
        Logger.d("CronetFrontierConnection", "PP connection host:" + r21.getHost() + ":" + r8 + r3 + "?" + r4);
    L8:
        CronetFrontierClient.TransportMode r13 = r(((Integer) r20.get(WsConstants.KEY_TRANSPORT_MODE)).intValue());
        ArrayList r14 = new ArrayList();
        if (this.f22678c.get() == false) goto L11;
        r14.add(1);
    L12:
        HashMap<String, String> r11 = new HashMap();
        String r10 = (String) r20.get(WsConstants.KEY_EXTRA);
        C(r10, r11);
        Map<String, String> r1 = u();     // Catch: Throwable -> L34
        if (Logger.debug() == false) goto L16;
        Logger.d("CronetFrontierConnection", "PP client key: " + r1);     // Catch: Throwable -> L34
    L16:
        if (r1 != null) goto L18;
    L20:
        Map<? extends String, ? extends String> r2 = (Map) r20.get(WsConstants.KEY_HEADERS);     // Catch: Throwable -> L34
        if (r2 == null) goto L26;
        if (r2.isEmpty() == true) goto L26;
        r11.putAll(r2);     // Catch: Throwable -> L34
    L26:
        if (F() == false) goto L36;
        String r5 = MySelfChannelImpl.getDefaultUserAgent();     // Catch: Throwable -> L34
        if (TextUtils.isEmpty(r5) == true) goto L30;
        r11.put("user-agent", r5);     // Catch: Throwable -> L34
    L30:
        String r6 = v(r21);     // Catch: Throwable -> L34
        if (TextUtils.isEmpty(r6) == true) goto L36;
        r11.put("cookie", r6);     // Catch: Throwable -> L34
    L36:
        this.f22682g.clear();
        org.chromium.wschannel.b r7 = this.n;
        if (r7 != null) goto L39;
    L44:
        CronetFrontierClient.Builder r9 = CronetFrontierClient.Builder.create(((Integer) r20.get(WsConstants.KEY_APP_ID)).intValue(), ((Integer) r20.get(WsConstants.KEY_FPID)).intValue(), r21.getHost(), r8, Integer.toString(((Integer) r20.get(WsConstants.KEY_APP_VERSION)).intValue()), (String) r20.get(WsConstants.KEY_DEVICE_ID), (String) r20.get(WsConstants.KEY_APP_KEY)).pingInterval(this.f22680e).timeout(this.f22681f).transportMode(r13).headers(r11).callback(new c(this.f22676a, this));
        if (this.f22678c.get() == false) goto L51;
        r9.proxy(true);
        String r12 = q(r4, r10, r20.get(WsConstants.KEY_INSTALL_ID));
        if (Logger.debug() == false) goto L49;
        String r15 = "CronetFrontierConnection";
        Logger.d(r15, "PP connection real query:" + r12 + " path:" + r3);
    L50:
        r9.query(r12);
        r9.path(r3);
    L52:
        r9.uniqueServiceIdList(r14);
        this.f22683h = r9.build();
        if (Logger.debug() == false) goto L55;
        Logger.d(r15, "Register serviceIdList: " + r14 + " mode:" + r13);
    L55:
        Iterator r16 = r14.iterator();
    L57:
        if (r16.hasNext() == false) goto L59;
        Integer r17 = (Integer) r16.next();
        H(r17.intValue(), null, null);
        this.f22682g.put(r17, Boolean.FALSE);
        goto L57
    L59:
        return;
    L49:
        r15 = "CronetFrontierConnection";
        goto L50
    L51:
        r15 = "CronetFrontierConnection";
        goto L52
    L39:
        if (r7.b() <= 0) goto L44;
        int r18 = (int) this.n.b();
        if (Logger.debug() == false) goto L43;
        Logger.d("CronetFrontierConnection", "PP destroy timeout:" + r18);
    L43:
        this.f22681f = r18;
        goto L44
    L18:
        if (r1.isEmpty() == true) goto L20;
        r11.putAll(r1);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        th.printStackTrace();
        goto L36
    L11:
        r14.add(Integer.valueOf(WsConstants.APP_STATE_CHANGE_SERVICE));
        B(r20, r14);
        goto L12
    }

    private void Q(Map<String, Object> r11, List<String> r12) {
        this.f22677b.set(false);
        this.f22678c.set(false);
        s.incrementAndGet();
        Object r2 = r11.get(WsConstants.KEY_CHANNEL_ID);
        if (r2 != null) goto L5;
        int r3 = -1;
    L7:
        if (t != (-1)) goto L12;
        if (r3 <= 0) goto L12;
        if (s.get() != 1) goto L12;
        t = r3;
    L12:
        TTWebsocketConnection.Builder r5 = o.newWebsocketConnectionBuilder(this.m, Executors.newSingleThreadExecutor());
        r5.setUrlList(r12);     // Catch: Throwable -> L58
        r5.setAppKey(String.valueOf(r11.get(WsConstants.KEY_APP_KEY)));     // Catch: Throwable -> L58
        r5.setFpid(((Integer) r11.get(WsConstants.KEY_FPID)).intValue());     // Catch: Throwable -> L58
        r5.setAppVersion(((Integer) r11.get(WsConstants.KEY_APP_VERSION)).intValue());     // Catch: Throwable -> L58
        r5.setAppId(((Integer) r11.get(WsConstants.KEY_APP_ID)).intValue());     // Catch: Throwable -> L58
        r5.setDeviceId(Long.parseLong((String) r11.get(WsConstants.KEY_DEVICE_ID)));     // Catch: Throwable -> L58
        r5.setInstallId(Long.parseLong((String) r11.get(WsConstants.KEY_INSTALL_ID)));     // Catch: Throwable -> L58
        if (r3 <= 0) goto L16;
        int r13 = t;     // Catch: Throwable -> L58
    L16:
        r5.setSharedConnection(false);     // Catch: Throwable -> L58
        if (r11.containsKey(WsConstants.KEY_SESSION_ID) == false) goto L19;
        r5.setSessionId((String) r11.get(WsConstants.KEY_SESSION_ID));     // Catch: Throwable -> L58
    L19:
        String r14 = (String) r11.get(WsConstants.KEY_EXTRA);     // Catch: Throwable -> L58
        HashMap r1 = new HashMap();     // Catch: Throwable -> L58
        if (TextUtils.isEmpty(r14) == true) goto L63;
        String[] r15 = r14.split("&");     // Catch: Throwable -> L58
        int r4 = r15.length;     // Catch: Throwable -> L58
        int r6 = 0;
    L22:
        if (r6 >= r4) goto L63;
        String r7 = r15[r6];     // Catch: Throwable -> L58
        if (TextUtils.isEmpty(r7) == true) goto L28;
        String[] r8 = r7.split("=");     // Catch: Throwable -> L58
        if (r8.length != 2) goto L28;
        r1.put(r8[0], r8[1]);     // Catch: Throwable -> L58
    L28:
        r6 = r6 + 1;
    L63:
        HashMap r16 = new HashMap();     // Catch: Throwable -> L45
        Map<String, String> r9 = u();     // Catch: Throwable -> L45
        if (Logger.debug() == false) goto L32;
        Logger.d("CronetFrontierConnection", "Client key: " + r9);     // Catch: Throwable -> L45
    L32:
        if (r9 != null) goto L34;
    L36:
        Map r17 = (Map) r11.get(WsConstants.KEY_HEADERS);     // Catch: Throwable -> L45
        if (r17 == null) goto L42;
        if (r17.isEmpty() == true) goto L42;
        r16.putAll(r17);     // Catch: Throwable -> L45
    L42:
        if (r16.isEmpty() == true) goto L47;
        r5.setCustomizedHeaders(r16);     // Catch: Throwable -> L45
    L47:
        org.chromium.wschannel.b r18 = this.n;     // Catch: Throwable -> L58
        if (r18 != null) goto L50;
    L55:
        r5.setCustomizedParams(r1);     // Catch: Throwable -> L58
        TTWebsocketConnection r19 = r5.build();
        this.f22687l = r19;
        r19.startConnection();
        return;
    L50:
        if (r18.c() <= 0) goto L55;
        long r110 = this.n.c();     // Catch: Throwable -> L58
        if (Logger.debug() == false) goto L54;
        Logger.d("CronetFrontierConnection", "WS destroy timeout:" + r110);     // Catch: Throwable -> L58
    L54:
        r1.put("ttnet_timeout_millis", String.valueOf(r110));     // Catch: Throwable -> L58
        goto L55
    L34:
        if (r9.isEmpty() == true) goto L36;
        r16.putAll(r9);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        th.printStackTrace();
        throw new IllegalArgumentException("configMap contain err params !!!");
    L5:
        r3 = ((Integer) r2).intValue();
        goto L7
    }

    static /* synthetic */ boolean a(a r0) {
        return r0.f22686k;
    }

    static /* synthetic */ boolean b(a r0, boolean r1) {
        r0.f22686k = r1;
        return r1;
    }

    static /* synthetic */ CronetFrontierClient c(a r0) {
        return r0.f22683h;
    }

    static /* synthetic */ AtomicBoolean d(a r0) {
        return r0.f22684i;
    }

    static /* synthetic */ void e(a r0, Map r1, List r2) {
        r0.Q(r1, r2);
    }

    static /* synthetic */ void f(a r0, JSONObject r1, int r2) {
        r0.J(r1, r2);
    }

    static /* synthetic */ int g(a r0) {
        return r0.f22685j;
    }

    static /* synthetic */ Map h(a r0) {
        return r0.f22682g;
    }

    static /* synthetic */ AtomicBoolean i(a r0) {
        return r0.f22678c;
    }

    static /* synthetic */ boolean j(a r0) {
        return r0.x();
    }

    static /* synthetic */ String k() {
        return p;
    }

    static /* synthetic */ IWsChannelClient l(a r0) {
        return r0.f22676a;
    }

    static /* synthetic */ String m() {
        return q;
    }

    static /* synthetic */ AtomicInteger n(a r0) {
        return r0.f22679d;
    }

    private boolean o(Map<String, Object> r4) {
        if (g.w() == false) goto L12;
        if (this.f22679d.get() >= 3) goto L12;
        Object r3 = r4.get(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE);
        if (r3 != null) goto L10;
        return false;
    L10:
        return ((Boolean) r3).booleanValue();
    L12:
        if (Logger.debug() == false) goto L14;
        Logger.d("CronetFrontierConnection", "Retry attempts:" + this.f22679d.get() + ",tnc enabled:" + g.w());
    L14:
        return false;
    }

    private static String[] p(WsChannelMsg r4) {
        ArrayList r0 = new ArrayList();
        r0.add("method_id");
        r0.add(String.valueOf(r4.f()));
        if (TextUtils.isEmpty(r4.l()) == true) goto L6;
        r0.add("payload_type");
        r0.add(r4.l());
    L6:
        if (TextUtils.isEmpty(r4.j()) == true) goto L9;
        r0.add("payload_encoding");
        r0.add(r4.j());
    L9:
        if (r4.g() != null) goto L13;
        Object[] r5 = r0.toArray(new String[0]);
    L12:
        return (String[]) r5;
    L13:
        Iterator<WsChannelMsg.MsgHeader> r6 = r4.g().iterator();
    L15:
        if (r6.hasNext() == false) goto L21;
        WsChannelMsg.MsgHeader r1 = r6.next();
        if (TextUtils.isEmpty(r1.b()) == true) goto L15;
        if (TextUtils.isEmpty(r1.d()) == true) goto L15;
        r0.add(r1.b());
        r0.add(r1.d());
        goto L15
    L21:
        r5 = r0.toArray(new String[0]);
        goto L12
    }

    private static String q(String r2, String r3, Object r4) {
        StringBuilder r0 = new StringBuilder();
        if (TextUtils.isEmpty(r2) == true) goto L6;
        r0.append(r2);
    L6:
        if (TextUtils.isEmpty(r3) == false) goto L8;
    L18:
        long r5 = Long.parseLong((String) r4);     // Catch: Exception -> L17
        if (r0.length() <= 0) goto L14;
        r0.append("&");     // Catch: Exception -> L17
    L14:
        r0.append("iid=" + r5);     // Catch: Exception -> L17
    L16:
        return r0.toString();
    L8:
        if (r0.length() <= 0) goto L10;
        r0.append("&");
    L10:
        r0.append(r3);
        goto L18
    }

    private CronetFrontierClient.TransportMode r(int r4) {
        if (r4 == 3) goto L5;
        if (r4 == 4) goto L5;
    L6:
        if (r4 == 1) goto L13;
        if (r4 == 2) goto L13;
        if (r4 == 4) goto L13;
        return CronetFrontierClient.TransportMode.QUIC;
    L13:
        return CronetFrontierClient.TransportMode.TLS;
    L5:
        this.f22678c.set(true);
        goto L6
    }

    private void t() {
        TTWebsocketConnection r0 = this.f22687l;
        if (r0 == null) goto L5;
        r0.stopConnection();
        this.f22687l.destroyConnection();
    L5:
        CronetFrontierClient r1 = this.f22683h;
        if (r1 == null) goto L9;
        r1.destroy();
        d.b.h.a.a.h.s.a.c().e(q);
        this.f22684i.set(false);
        return;
    }

    private Map<String, String> u() {
        return (Map) Class.forName("com.bytedance.ttnet.clientkey.ClientKeyManager").getMethod("getClientKeyHeaders", new Class[0]).invoke(null, new Object[0]);
    L5:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static String v(URI r5) {
        HashMap r0 = new HashMap();
        StringBuilder r1 = new StringBuilder();
        Map<String, List<String>> r2 = null;
        CookieHandler r3 = CookieHandler.getDefault();     // Catch: Exception -> L25
        if (r3 == null) goto L6;
        r2 = r3.get(r5, r0);     // Catch: Exception -> L25
    L6:
        if (r2 == null) goto L24;
        if (r2.size() <= 0) goto L24;
        Iterator<Map.Entry<String, List<String>>> r6 = r2.entrySet().iterator();
    L11:
        if (r6.hasNext() == false) goto L24;
        Map.Entry<String, List<String>> r4 = r6.next();
        if ("cookie".equalsIgnoreCase(r4.getKey()) == false) goto L11;
        if (r4.getValue().isEmpty() == true) goto L11;
        int r7 = 0;
        Iterator<String> r8 = r4.getValue().iterator();
    L18:
        if (r8.hasNext() == false) goto L11;
        String r9 = r8.next();
        if (r7 <= 0) goto L22;
        r1.append("; ");
    L22:
        r1.append(r9);
        r7 = r7 + 1;
    L24:
        return r1.toString();
    L25:
        return null;
    }

    private long w(Map<String, Object> r4) {
        Map r3 = (Map) r4.get(WsConstants.KEY_HEADERS);
        if (r3 != null) goto L5;
        return BDLocationConfig.sScanBleMaxInterval;
    L5:
        if (r3.isEmpty() == false) goto L8;
        return BDLocationConfig.sScanBleMaxInterval;
    L8:
        if (r3.containsKey("fallback_timeout_mills") == true) goto L10;
        return BDLocationConfig.sScanBleMaxInterval;
    L10:
        String r5 = (String) r3.get("fallback_timeout_mills");
        if (TextUtils.isEmpty(r5) == false) goto L18;
        return BDLocationConfig.sScanBleMaxInterval;
    L18:
        int r6 = Integer.valueOf(r5).intValue();     // Catch: Exception -> L17
        if (r6 > 0) goto L16;
        return BDLocationConfig.sScanBleMaxInterval;
    L16:
        return r6;
    L23:
        return BDLocationConfig.sScanBleMaxInterval;
    }

    private boolean x() {
        if (this.f22682g.isEmpty() == false) goto L5;
        return false;
    L5:
        Iterator<Map.Entry<Integer, Boolean>> r2 = this.f22682g.entrySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        if (r2.next().getValue().booleanValue() == true) goto L7;
        return false;
    L11:
        return true;
    }

    public boolean E() {
        return this.f22677b.get();
    }

    public boolean F() {
        return this.f22678c.get();
    }

    public void G(int r1) {
    }

    public boolean K(WsChannelMsg r6) {
        if (Logger.debug() == false) goto L6;
        Logger.d("CronetFrontierConnection", "PP sendMessage data:" + r6.toString());
    L6:
        if (this.f22683h == null) goto L19;
        if (r6 == null) goto L21;
        int r0 = r6.s();
        if (r0 == 9000) goto L12;
    L15:
        String[] r2 = p(r6);
        ByteBuffer r4 = ByteBuffer.allocateDirect(r6.i().length);
        r4.put(r6.i());
        this.f22683h.sendMessage(r0, r2, r4);
        if (Logger.debug() == false) goto L18;
        Logger.d("CronetFrontierConnection", "PP sendMessage serviceId:" + r0);
    L18:
        return true;
    L12:
        if (r6.f() != 4) goto L15;
        I(r6.g());
        return true;
    L21:
        return false;
    L19:
        return false;
    }

    public boolean L(byte[] r4) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetFrontierConnection", "PP proxy sendMessage data:" + r4.toString());
    L5:
        CronetFrontierClient r0 = this.f22683h;
        if (r0 == null) goto L14;
        if (r4 != null) goto L10;
        return false;
    L10:
        if (r0.isServiceExisted(1) == true) goto L12;
        H(1, null, null);
    L12:
        ByteBuffer r1 = ByteBuffer.allocateDirect(r4.length);
        r1.put(r4);
        this.f22683h.sendMessage(1, null, r1);
        return true;
    L14:
        return false;
    }

    public boolean M(byte[] r3) {
        if (Logger.debug() == false) goto L6;
        Logger.d("CronetFrontierConnection", "WS sendMessage data:" + r3);
    L6:
        if (this.f22687l != null) goto L9;
        return false;
    L9:
        ByteBuffer r0 = ByteBuffer.allocateDirect(r3.length);
        r0.put(r3);
        this.f22687l.asyncSendBinary(r0);
        return true;
    }

    public void N(boolean r1) {
        this.f22686k = r1;
    }

    public void O(Map<String, Object> r11, List<String> r12) {
        if (r12 == null) goto L39;
        if (r12.size() <= 0) goto L39;
        boolean r1 = false;
        if (Logger.debug() == false) goto L8;
        Logger.d("CronetFrontierConnection", "openConnection url:" + r12.get(0));
    L8:
        if (r11 == null) goto L37;
        if (r11.isEmpty() == true) goto L37;
        s();
        if (o(r11) == true) goto L15;
        this.n = new org.chromium.wschannel.b(r11, true);
        Q(r11, r12);
        return;
    L15:
        URI r0 = D(r11);
        if (r0 != null) goto L19;
        this.n = new org.chromium.wschannel.b(r11, true);
        Q(r11, r12);
        return;
    L19:
        this.n = new org.chromium.wschannel.b(r11, false);
        Object r4 = r11.get(WsConstants.KEY_DISABLE_FALLBACK_WEBSOCKET);
        if (r4 == null) goto L23;
        r1 = ((Boolean) r4).booleanValue();
    L23:
        if (Logger.debug() == false) goto L26;
        Logger.d("CronetFrontierConnection", "DisableFallbackTask:" + r + " DisableFallbackWS:" + r1);
    L26:
        if (r == true) goto L34;
        if (r1 == true) goto L34;
        if (this.n.e() == false) goto L34;
        long r6 = w(r11);
        if (Logger.debug() == false) goto L33;
        Logger.d("CronetFrontierConnection", "Fallback to websocket timeout:" + r6);
    L33:
        d.b.h.a.a.h.s.a.c().d(new C0603a(this, r6, r11, r12));
        this.f22684i.set(true);
    L34:
        this.f22677b.set(true);
        P(r11, r0);
        return;
    L37:
        throw new IllegalArgumentException("configMap is empty !!!");
    L39:
        throw new IllegalArgumentException("urls size <= 0 !!!");
    }

    public void R() {
        t();
    }

    public void S(int r1) {
    }

    public void s() {
        t();
    }

    public boolean y() {
        if (this.f22677b.get() == false) goto L9;
        CronetFrontierClient r0 = this.f22683h;
        if (r0 == null) goto L9;
        return r0.isConnected();
    L9:
        if (this.f22677b.get() == true) goto L14;
        TTWebsocketConnection r1 = this.f22687l;
        if (r1 != null) goto L13;
        return false;
    L13:
        return r1.isConnected();
    L14:
        return false;
    }

    public boolean z() {
        return this.f22684i.get();
    }
}
