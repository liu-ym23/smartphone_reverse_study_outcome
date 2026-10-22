package d.b.h.a.a.h.o.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.ttnet.org.chromium.net.NetError;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import java.io.IOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000j.b0;
import p000j.d0;
import p000j.f0;
import p000j.i0;

/* JADX INFO: loaded from: classes.dex */
public class n {
    private b0 A;
    private String B;
    private boolean C;
    private boolean D;
    private String E;
    private Socket F;
    private p000j.v G;
    private String H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final List<q> f13506J;
    private e K;
    private String L;
    private int M;
    private t N;
    private String O;
    private boolean P;
    private boolean Q;
    private final List<d.b.h.a.a.h.o.b.z.d> R;
    private int S;
    private d.b.h.a.a.h.o.b.y.b T;
    private String U;
    private d.b.h.a.a.h.c V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f13507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f13508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f13509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f13510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f13511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f13512f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f13513g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f13514h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f13515i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f13516j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f13517k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f13518l;
    private long m;
    private long n;
    private final AtomicLong o;
    private long p;
    private long q;
    private final List<Pair<InetSocketAddress, Integer>> r;
    private Proxy.Type s;
    private d t;
    private i0 u;
    private p000j.i v;
    private long w;
    private p000j.v x;
    private int y;
    private long z;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13519a = null;

        static {
            int[] r0 = new int[b0.values().length];
            f13519a = r0;
            r0[b0.f17672g.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f13519a[b0.f17673h.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f13519a[b0.f17675j.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f13519a[b0.f17674i.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f13519a[b0.f17677l.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public n() {
        this.f13507a = -1;
        this.f13508b = -1;
        this.f13509c = -1;
        this.f13510d = -1;
        this.f13511e = -1;
        this.f13512f = -1;
        this.f13513g = -1;
        this.f13514h = -1;
        this.f13515i = -1;
        this.f13516j = -1;
        this.f13517k = -1;
        this.f13518l = -1;
        this.m = -1;
        this.n = -1;
        this.o = new AtomicLong(-1);
        this.p = -1;
        this.q = -1;
        this.r = new ArrayList();
        this.s = Proxy.Type.DIRECT;
        this.t = d.f13481f;
        this.w = 0;
        this.y = -1;
        this.z = 0;
        this.A = null;
        this.B = "";
        this.C = false;
        this.D = false;
        this.E = "";
        this.H = "";
        this.I = 0;
        this.f13506J = new ArrayList();
        this.K = e.f13485f;
        this.L = "";
        this.M = -1;
        this.N = t.f13541f;
        this.O = "";
        this.P = false;
        this.Q = false;
        this.R = new ArrayList();
        this.S = 0;
        this.U = "";
    }

    private static c I(b0 r1) {
        if (r1 == null) goto L4;
        int r2 = a.f13519a[r1.ordinal()];
        if (r2 == 1) goto L26;
        if (r2 == 2) goto L24;
        if (r2 == 3) goto L22;
        if (r2 == 4) goto L20;
        if (r2 == 5) goto L18;
        return c.f13474g;
    L18:
        return c.f13478k;
    L20:
        return c.f13476i;
    L22:
        return c.f13477j;
    L24:
        return c.f13475h;
    L26:
        return c.f13479l;
    L4:
        return c.f13474g;
    }

    private static long J(String r7) {
        String[] r8 = r7.split("=");
        if (r8.length == 2) goto L12;
        return -1;
    L12:
        long r3 = Long.parseLong(r8[1]);     // Catch: NumberFormatException -> L11
        if (r3 >= 0) goto L10;
        return -1;
    L10:
        return r3;
    L16:
        return -1;
    }

    private static long K(long r3, long r5) {
        if (r5 != (-1)) goto L5;
    L8:
        return -1;
    L5:
        if (r3 == (-1)) goto L8;
        return r3 - r5;
    }

    private String h(Context r20) {
        String r2 = "Cookie";
        JSONObject r8 = new JSONObject();
        JSONObject r9 = new JSONObject();     // Catch: JSONException -> L272
        String r10 = d.b.h.a.a.h.o.b.z.l.m().h();     // Catch: JSONException -> L272
        ArrayList r11 = new ArrayList();     // Catch: JSONException -> L272
        if (TextUtils.isEmpty(r10) == true) goto L8;
        String[] r12 = r10.split(",");     // Catch: JSONException -> L272
        if (r12 == null) goto L8;
        r11.addAll(Arrays.asList(r12));     // Catch: JSONException -> L272
    L8:
        d.b.h.a.a.h.o.a r13 = s.p();     // Catch: JSONException -> L272
        if (r13 == null) goto L22;
        List<String> r14 = r13.getAbSdkVersion();     // Catch: JSONException -> L272
        if (r14 == null) goto L22;
        if (r14.size() <= 5) goto L15;
        Logger.debug();     // Catch: JSONException -> L272
    L15:
        Iterator<String> r15 = r14.iterator();     // Catch: JSONException -> L272
        int r16 = 0;
    L17:
        if (r15.hasNext() == false) goto L22;
        String r17 = r15.next();     // Catch: JSONException -> L272
        r16 = r16 + 1;     // Catch: JSONException -> L272
        if (r16 > 5) goto L22;
        r11.add(r17);     // Catch: JSONException -> L272
    L22:
        JSONArray r18 = new JSONArray();     // Catch: JSONException -> L272
        Iterator r19 = r11.iterator();     // Catch: JSONException -> L272
    L24:
        if (r19.hasNext() == false) goto L28;
        String r110 = (String) r19.next();     // Catch: JSONException -> L272
        if (TextUtils.isEmpty(r110) == true) goto L24;
        r18.put(r110);     // Catch: JSONException -> L272
        goto L24
    L28:
        r9.put("hit", r18);     // Catch: JSONException -> L272
        r8.put("ab_test", r9);     // Catch: JSONException -> L272
        JSONObject r21 = new JSONObject();     // Catch: JSONException -> L272
        r21.put("load_state", this.K.ordinal());     // Catch: JSONException -> L272
        r21.put("method", this.L);     // Catch: JSONException -> L272
        if (this.N != t.f13543h) goto L31;
        boolean r111 = true;
    L32:
        r21.put("is_pending", r111);     // Catch: JSONException -> L272
        r21.put("status", this.N);     // Catch: JSONException -> L272
        if (this.N == t.f13542g) goto L37;
        r21.put("net_error", this.M);     // Catch: JSONException -> L272
    L37:
        if (TextUtils.isEmpty(this.O) == true) goto L47;
        Uri r112 = Uri.parse(this.O);     // Catch: JSONException -> L272
        if (r112 == null) goto L47;
        if (TextUtils.isEmpty(r112.getScheme()) == true) goto L47;
        if (TextUtils.isEmpty(r112.getHost()) == true) goto L47;
        if (r112.getPath() == null) goto L47;
        r21.put("origin_url", r112.getScheme() + "://" + r112.getHost() + r112.getPath());     // Catch: JSONException -> L272
    L47:
        r21.put("redirect_times", this.I);     // Catch: JSONException -> L272
        JSONArray r113 = new JSONArray();     // Catch: JSONException -> L272
        JSONArray r114 = new JSONArray();     // Catch: JSONException -> L272
        Iterator<q> r115 = this.f13506J.iterator();     // Catch: JSONException -> L272
    L50:
        if (r115.hasNext() == false) goto L64;
        q r116 = r115.next();     // Catch: JSONException -> L272
        Iterator<q> r117 = r115;
        JSONObject r118 = new JSONObject();     // Catch: JSONException -> L272
        String r119 = r2;
        r118.put("code", r116.f13521a);     // Catch: JSONException -> L272
        r118.put("method", r116.f13522b);     // Catch: JSONException -> L272
        r118.put("internal", r116.f13524d);     // Catch: JSONException -> L272
        String r3 = r116.f13523c;     // Catch: JSONException -> L272
        if (r3 == null) goto L63;
        Uri r4 = Uri.parse(r3);     // Catch: JSONException -> L272
        if (r4 == null) goto L63;
        if (TextUtils.isEmpty(r4.getScheme()) == true) goto L63;
        if (TextUtils.isEmpty(r4.getHost()) == true) goto L63;
        String r120 = r4.getScheme() + "://" + r4.getHost();     // Catch: JSONException -> L272
        r114.put(r120);     // Catch: JSONException -> L272
        if (r4.getPath() == null) goto L62;
        r120 = r120 + r4.getPath();     // Catch: JSONException -> L272
    L62:
        r118.put(WsConstants.KEY_CONNECTION_URL, r120);     // Catch: JSONException -> L272
    L63:
        r113.put(r118);     // Catch: JSONException -> L272
        r115 = r117;
        r2 = r119;
        goto L50
    L64:
        String r121 = r2;
        r21.put("redirect_info", r113);     // Catch: JSONException -> L272
        r21.put("redirecting_list", r114);     // Catch: JSONException -> L272
        r21.put("dispatched", this.P);     // Catch: JSONException -> L272
        r8.put("base", r21);     // Catch: JSONException -> L272
        JSONObject r5 = new JSONObject();     // Catch: JSONException -> L272
        r5.put("code", this.y);     // Catch: JSONException -> L272
        r5.put("connection_info", I(this.A).f13480f);     // Catch: JSONException -> L272
        p000j.v r7 = this.x;     // Catch: JSONException -> L272
        if (r7 == null) goto L67;
        long r122 = r7.a();     // Catch: JSONException -> L272
    L68:
        r5.put("sent_bytes", this.w + r122);     // Catch: JSONException -> L272
        p000j.v r22 = this.G;     // Catch: JSONException -> L272
        if (r22 == null) goto L71;
        long r123 = r22.a();     // Catch: JSONException -> L272
    L72:
        r5.put("received_bytes", this.z + r123);     // Catch: JSONException -> L272
        r5.put("cached", this.C);     // Catch: JSONException -> L272
        r5.put("network_accessed", this.D);     // Catch: JSONException -> L272
        if (this.s == Proxy.Type.DIRECT) goto L75;
        boolean r124 = true;
    L76:
        r5.put("via_proxy", r124);     // Catch: JSONException -> L272
        p000j.v r23 = this.G;     // Catch: JSONException -> L272
        if (r23 == null) goto L91;
        List<String> r24 = r23.n("Set-Cookie");     // Catch: JSONException -> L272
        if (com.bytedance.common.utility.collection.a.a(r24) == true) goto L81;
        boolean r125 = true;
    L82:
        r5.put("set_cookie", r125);     // Catch: JSONException -> L272
        if (r125 == false) goto L91;
        r5.put("set_cookie_lines", r24.size());     // Catch: JSONException -> L272
        Iterator<String> r25 = r24.iterator();     // Catch: JSONException -> L272
        long r126 = 0;
    L86:
        if (r25.hasNext() == false) goto L90;
        String r127 = r25.next();     // Catch: JSONException -> L272
        if (r127 == null) goto L86;
        r126 = r126 + ((long) r127.length());     // Catch: JSONException -> L272
        goto L86
    L90:
        r5.put("set_cookie_bytes", r126);     // Catch: JSONException -> L272
        goto L91
    L81:
        r125 = false;
    L91:
        r8.put("response", r5);     // Catch: JSONException -> L272
        JSONObject r6 = new JSONObject();     // Catch: JSONException -> L272
        if (this.G == null) goto L115;
        int r26 = 0;
    L96:
        if (r26 >= this.G.k()) goto L108;
        String r128 = this.G.f(r26);     // Catch: JSONException -> L272
        String r129 = this.G.m(r26);     // Catch: JSONException -> L272
        if (TextUtils.isEmpty(r128) == true) goto L107;
        String r130 = r128.toLowerCase();     // Catch: JSONException -> L272
        if (TextUtils.isEmpty(r130) == true) goto L107;
        if (r130.startsWith("x-tt-") == false) goto L107;
        if (TextUtils.isEmpty(r129) == true) goto L107;
        r6.put(r128, r129);     // Catch: JSONException -> L272
    L107:
        r26 = r26 + 1;     // Catch: JSONException -> L272
        goto L96
    L108:
        String r27 = this.G.d("tt-idc-switch");     // Catch: JSONException -> L272
        if (TextUtils.isEmpty(r27) == true) goto L111;
        r6.put("tt-idc-switch", r27);     // Catch: JSONException -> L272
    L111:
        String r28 = this.G.d("server-timing");     // Catch: JSONException -> L272
        if (TextUtils.isEmpty(r28) == true) goto L114;
        r6.put("server-timing", r28);     // Catch: JSONException -> L272
    L114:
        r8.put("header", r6);     // Catch: JSONException -> L272
    L116:
        JSONObject r29 = new JSONObject();     // Catch: JSONException -> L272
        r29.put("libcore", "okhttp");     // Catch: JSONException -> L272
        r29.put("core_ver", s.q());     // Catch: JSONException -> L272
        r29.put("is_main_process", d.b.h.a.a.h.s.h.h(r20));     // Catch: JSONException -> L272
        r29.put("ttnet_version", "4.2.228.16-pico");     // Catch: JSONException -> L272
        r29.put(ICronetClient.KEY_RETRY_ATTEMPTS, -1);     // Catch: JSONException -> L272
        d.b.h.a.a.h.c r30 = this.V;     // Catch: JSONException -> L272
        if (r30 != null) goto L119;
    L121:
        r8.put("other", r29);     // Catch: JSONException -> L272
        JSONObject r31 = new JSONObject();     // Catch: JSONException -> L272
        JSONObject r32 = new JSONObject();     // Catch: JSONException -> L272
        r32.put("dns", K(this.f13509c, this.f13508b));     // Catch: JSONException -> L272
        r32.put("tcp", K(this.f13511e, this.f13510d));     // Catch: JSONException -> L272
        r32.put("ssl", K(this.f13512f, this.f13511e));     // Catch: JSONException -> L272
        r32.put("send", K(this.f13514h, this.f13513g) + K(this.f13516j, this.f13515i));     // Catch: JSONException -> L272
        long r33 = K(this.f13518l, this.f13514h);     // Catch: JSONException -> L272
        r32.put(ICronetClient.KEY_TTFB, r33);     // Catch: JSONException -> L272
        r32.put("header_recv", K(this.f13518l, this.f13517k));     // Catch: JSONException -> L272
        r32.put("body_recv", K(this.n, this.m));     // Catch: JSONException -> L272
        r32.put("dispatch", this.q);     // Catch: JSONException -> L272
        p(r28, r32, r33);     // Catch: JSONException -> L272
        d.b.h.a.a.h.o.b.y.b r34 = this.T;     // Catch: JSONException -> L272
        if (r34 == null) goto L127;
        long r35 = r34.f13632e;     // Catch: JSONException -> L272
        if (r35 < 0) goto L127;
        r32.put("meta_dp", r35);     // Catch: JSONException -> L272
    L127:
        r31.put("detailed_duration", r32);     // Catch: JSONException -> L272
        JSONObject r36 = new JSONObject();     // Catch: JSONException -> L272
        r36.put("start_time", this.f13507a);     // Catch: JSONException -> L272
        r36.put(TypedValues.TransitionType.S_DURATION, K(this.o.get(), this.f13507a));     // Catch: JSONException -> L272
        r36.put("request_sent_time", this.f13513g);     // Catch: JSONException -> L272
        r36.put("response_recv_time", this.f13517k);     // Catch: JSONException -> L272
        r31.put("request", r36);     // Catch: JSONException -> L272
        r8.put("timing", r31);     // Catch: JSONException -> L272
        JSONObject r37 = new JSONObject();     // Catch: JSONException -> L272
        Socket r38 = this.F;     // Catch: JSONException -> L272
        if (r38 == null) goto L146;
        InetAddress r39 = r38.getInetAddress();     // Catch: JSONException -> L272
        if (r39 == null) goto L146;
        b r40 = b.f13470f;     // Catch: JSONException -> L272
        if ((r39 instanceof Inet4Address) == false) goto L135;
        r40 = b.f13471g;     // Catch: JSONException -> L272
    L137:
        r37.put("address_family", r40.ordinal());     // Catch: JSONException -> L272
        if (this.f13510d == (-1)) goto L140;
    L142:
        boolean r41 = false;
    L143:
        r37.put(ICronetClient.KEY_SOCKET_REUSED, r41);     // Catch: JSONException -> L272
        if (r39.getHostAddress() == null) goto L146;
        r37.put("remote", r39.getHostAddress());     // Catch: JSONException -> L272
        goto L146
    L140:
        if (this.p == (-1)) goto L142;
        r41 = true;
        goto L143
    L135:
        if ((r39 instanceof Inet6Address) == false) goto L137;
        r40 = b.f13472h;     // Catch: JSONException -> L272
    L146:
        JSONArray r42 = new JSONArray();     // Catch: JSONException -> L272
        Iterator<Pair<InetSocketAddress, Integer>> r43 = this.r.iterator();     // Catch: JSONException -> L272
    L148:
        if (r43.hasNext() == false) goto L150;
        Pair<InetSocketAddress, Integer> r44 = r43.next();     // Catch: JSONException -> L272
        JSONObject r131 = new JSONObject();     // Catch: JSONException -> L272
        r131.put("address", ((InetSocketAddress) r44.first).toString().substring(1));     // Catch: JSONException -> L272
        r131.put("result", r44.second);     // Catch: JSONException -> L272
        r42.put(r131);     // Catch: JSONException -> L272
        goto L148
    L150:
        r37.put("connection_attempts", r42);     // Catch: JSONException -> L272
        r8.put("socket", r37);     // Catch: JSONException -> L272
        JSONObject r45 = new JSONObject();     // Catch: JSONException -> L272
        r45.put("handshake_type", this.t.ordinal());     // Catch: JSONException -> L272
        r45.put("cipher_suite", this.v);     // Catch: JSONException -> L272
        r45.put("ssl_version", this.u);     // Catch: JSONException -> L272
        r8.put("ssl", r45);     // Catch: JSONException -> L272
        JSONObject r46 = new JSONObject();     // Catch: JSONException -> L272
        JSONArray r47 = new JSONArray();     // Catch: JSONException -> L272
        if (this.Q == false) goto L155;
        boolean r48 = true;
        r46.put("host_replace_map", 1);     // Catch: JSONException -> L272
        r46.put("host_replace_map_size", this.S);     // Catch: JSONException -> L272
        boolean r49 = false;
    L177:
        r46.put("source", d.b.h.a.a.h.o.b.z.l.m().j());     // Catch: JSONException -> L272
        r46.put("update_time", d.b.h.a.a.h.o.b.z.l.m().k());     // Catch: JSONException -> L272
        r46.put(URLDispatch.KEY_EPOCH, d.b.h.a.a.h.o.b.z.l.m().f());     // Catch: JSONException -> L272
        r8.put("url_dispatch", r46);     // Catch: JSONException -> L272
        if (TextUtils.isEmpty(d.b.h.a.a.h.o.b.z.l.m().i()) == true) goto L181;
        r8.put("tt_tnc_etag", d.b.h.a.a.h.o.b.z.l.m().i());     // Catch: JSONException -> L272
    L181:
        if (this.T == null) goto L206;
        JSONObject r50 = new JSONObject();     // Catch: JSONException -> L272
        Set<String> r51 = this.T.f13630c;     // Catch: JSONException -> L272
        if (r51 != null) goto L185;
    L187:
        Set<String> r52 = this.T.f13631d;     // Catch: JSONException -> L272
        if (r52 != null) goto L190;
    L192:
        Set<String> r53 = this.T.f13628a;     // Catch: JSONException -> L272
        if (r53 != null) goto L195;
    L197:
        Set<String> r54 = this.T.f13629b;     // Catch: JSONException -> L272
        if (r54 == null) goto L203;
        if (r54.isEmpty() == true) goto L203;
        r50.put("query_rm", this.T.f13629b);     // Catch: JSONException -> L272
    L203:
        if (r50.length() <= 0) goto L206;
        r8.put("meta_dp", r50);     // Catch: JSONException -> L272
        goto L206
    L195:
        if (r53.isEmpty() == true) goto L197;
        r50.put("query_add", this.T.f13628a);     // Catch: JSONException -> L272
        goto L197
    L190:
        if (r52.isEmpty() == true) goto L192;
        r50.put("header_rm", this.T.f13631d);     // Catch: JSONException -> L272
        goto L192
    L185:
        if (r51.isEmpty() == true) goto L187;
        r50.put("header_add", this.T.f13630c);     // Catch: JSONException -> L272
    L206:
        if (TextUtils.isEmpty(this.U) == false) goto L279;
    L208:
        JSONObject r55 = new JSONObject();     // Catch: JSONException -> L272
        d.b.h.a.a.h.c r56 = this.V;     // Catch: JSONException -> L272
        if (r56 == null) goto L222;
        long r57 = r56.f13374i;     // Catch: JSONException -> L272
        if (r57 <= 0) goto L213;
        r55.put("protect", r57);     // Catch: JSONException -> L272
    L213:
        long r58 = this.V.f13371f;     // Catch: JSONException -> L272
        if (r58 <= 0) goto L216;
        r55.put("connect", r58);     // Catch: JSONException -> L272
    L216:
        long r59 = this.V.f13369d;     // Catch: JSONException -> L272
        if (r59 <= 0) goto L219;
        r55.put("read", r59);     // Catch: JSONException -> L272
    L219:
        long r60 = this.V.f13370e;     // Catch: JSONException -> L272
        long r61 = 0;
        if (r60 <= 0) goto L223;
        r55.put("write", r60);     // Catch: JSONException -> L272
    L223:
        r8.put("socket_timeout_param", r55);     // Catch: JSONException -> L272
        JSONObject r62 = new JSONObject();     // Catch: JSONException -> L272
        r62.put("ipv4_reachable", com.bytedance.common.utility.i.o(r20));     // Catch: JSONException -> L272
        r62.put("ipv6_reachable", d.b.h.a.a.h.o.b.x.k.d.b().get());     // Catch: JSONException -> L272
        r8.put("ifconfig", r62);     // Catch: JSONException -> L272
        if (s.o() == null) goto L229;
        Object r63 = s.o().b();     // Catch: JSONException -> L272
        if (r63 == null) goto L229;
        r8.put("tnc", r63);     // Catch: JSONException -> L272
    L229:
        if (d.b.h.a.a.h.r.b.n().i() == null) goto L232;
        r8.put("store_idc", d.b.h.a.a.h.r.b.n().i());     // Catch: JSONException -> L272
    L232:
        if (this.x == null) goto L275;
        JSONObject r64 = new JSONObject();     // Catch: JSONException -> L272
        List<String> r65 = this.x.n(r121);     // Catch: JSONException -> L272
        if (com.bytedance.common.utility.collection.a.a(r65) == true) goto L236;
        boolean r132 = r48;
    L237:
        r64.put(r121, r132);     // Catch: JSONException -> L272
        if (r132 == false) goto L246;
        Iterator<String> r66 = r65.iterator();     // Catch: JSONException -> L272
    L241:
        if (r66.hasNext() == false) goto L245;
        String r67 = r66.next();     // Catch: JSONException -> L272
        if (r67 == null) goto L241;
        r61 = r61 + ((long) r67.length());     // Catch: JSONException -> L272
        goto L241
    L245:
        r64.put("add_cookie_bytes", r61);     // Catch: JSONException -> L272
    L246:
        String r68 = this.x.d("x-tt-token");     // Catch: JSONException -> L272
        if (r68 == null) goto L252;
        if (r68.isEmpty() == true) goto L252;
        r64.put("token_md5", k.h.k(r68).t().q());     // Catch: JSONException -> L272
    L252:
        if ("http".equalsIgnoreCase(this.B) == false) goto L270;
        if (r65 != null) goto L255;
    L263:
        Set<String> r1 = d.b.h.a.a.e.a.b(this.x);     // Catch: JSONException -> L272
        if (r1 == null) goto L270;
        JSONArray r69 = new JSONArray();     // Catch: JSONException -> L272
        Iterator<String> r70 = r1.iterator();     // Catch: JSONException -> L272
    L267:
        if (r70.hasNext() == false) goto L269;
        r69.put(r70.next());     // Catch: JSONException -> L272
        goto L267
    L269:
        r64.put("insecure_headers", r69);     // Catch: JSONException -> L272
        goto L270
    L255:
        if (r65.isEmpty() == true) goto L263;
        Set<String> r71 = d.b.h.a.a.e.a.a(r65);     // Catch: JSONException -> L272
        if (r71 == null) goto L263;
        JSONArray r72 = new JSONArray();     // Catch: JSONException -> L272
        Iterator<String> r73 = r71.iterator();     // Catch: JSONException -> L272
    L260:
        if (r73.hasNext() == false) goto L262;
        r72.put(r73.next());     // Catch: JSONException -> L272
        goto L260
    L262:
        r64.put("insecure_cookies", r72);     // Catch: JSONException -> L272
    L270:
        r8.put("session", r64);     // Catch: JSONException -> L272
        goto L275
    L236:
        r132 = r49;
    L275:
        return r8.toString();
    L222:
        r61 = 0;
        goto L223
    L279:
        r8.put("dns", new JSONObject(this.U));     // Catch: JSONException -> L276
        goto L208
    L155:
        r48 = true;
        List<d.b.h.a.a.h.o.b.z.d> r74 = this.R;     // Catch: JSONException -> L272
        if (r74 == null) goto L176;
        Iterator<d.b.h.a.a.h.o.b.z.d> r75 = r74.iterator();     // Catch: JSONException -> L272
    L159:
        if (r75.hasNext() == false) goto L176;
        d.b.h.a.a.h.o.b.z.d r133 = r75.next();     // Catch: JSONException -> L272
        JSONObject r134 = new JSONObject();     // Catch: JSONException -> L272
        if (r133.f13660d == false) goto L159;
        r134.put("priority", r133.f13659c);     // Catch: JSONException -> L272
        r134.put(WsConstants.KEY_CONNECTION_TYPE, r133.f13661e);     // Catch: JSONException -> L272
        r134.put("action_hit", r133.f13660d);     // Catch: JSONException -> L272
        if (TextUtils.isEmpty(r133.f13663g) == true) goto L168;
        Uri r135 = Uri.parse(r133.f13663g);     // Catch: JSONException -> L272
        if (r135.getHost() == null) goto L169;
        r134.put("replace_host", r135.getHost());     // Catch: JSONException -> L272
    L169:
        r134.put("feedback", r133.f13662f);     // Catch: JSONException -> L272
        long r136 = r133.f13658b;     // Catch: JSONException -> L272
        if (r136 <= 0) goto L173;
        r134.put("rule_id", r136);     // Catch: JSONException -> L272
    L173:
        if (TextUtils.isEmpty(r133.f13657a) == true) goto L175;
        r134.put("service_name", r133.f13657a);     // Catch: JSONException -> L272
    L175:
        r47.put(r134);     // Catch: JSONException -> L272
        goto L159
    L168:
        r134.put("replace_host", "");     // Catch: JSONException -> L272
    L176:
        r46.put("action_info", r47);     // Catch: JSONException -> L272
        r46.put("empty_action", d.b.h.a.a.h.o.b.z.l.m().n());     // Catch: JSONException -> L272
        r49 = false;
        r46.put("host_replace_map", 0);     // Catch: JSONException -> L272
        goto L177
    L119:
        if (r30.B == null) goto L121;
        r29.put("hook", 1);     // Catch: JSONException -> L272
        goto L121
    L115:
        r28 = "";
        goto L116
    L75:
        r124 = false;
        goto L76
    L71:
        r123 = 0;
        goto L72
    L67:
        r122 = 0;
        goto L68
    L31:
        r111 = false;
    L272:
        e = move-exception;
        e.printStackTrace();
        goto L275
    }

    private static int i(IOException r2, int r3) {
        if (r2 != null) goto L21;
        return r3;
    L21:
        int r0 = j(r2.getMessage(), r3);     // Catch: Throwable -> L18
        if (r0 == r3) goto L19;
        return r0;
    L19:
        Throwable r4 = r2.getCause();     // Catch: Throwable -> L15
        if (r4 != null) goto L10;
        return r0;
    L10:
        String r5 = r4.getMessage();     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r5) == false) goto L13;
        return r0;
    L13:
        return j(r5, r3);
    L15:
        r3 = r0;
    L17:
        return r3;
    }

    private static int j(String r1, int r2) {
        if (TextUtils.isEmpty(r1) == false) goto L6;
        return r2;
    L6:
        if (r1.contains("ECONNRESET") == false) goto L8;
    L39:
        return NetError.ERR_CONNECTION_RESET;
    L8:
        if (r1.contains("Connection reset") == true) goto L39;
        if (r1.contains("reset by peer") == true) goto L39;
        if (r1.contains("ECONNREFUSED") == false) goto L16;
        return NetError.ERR_CONNECTION_REFUSED;
    L16:
        if (r1.contains("CONNECTION_ABORTED") == false) goto L18;
    L38:
        return NetError.ERR_CONNECTION_ABORTED;
    L18:
        if (r1.contains("connection abort") == true) goto L38;
        if (r1.contains("ENETDOWN") == false) goto L23;
    L37:
        return NetError.ERR_INTERNET_DISCONNECTED;
    L23:
        if (r1.contains("Network is unreachable") == true) goto L37;
        if (r1.contains("EHOSTUNREACH") == false) goto L28;
    L36:
        return NetError.ERR_ADDRESS_UNREACHABLE;
    L28:
        if (r1.contains("ENETUNREACH") == true) goto L36;
        if (r1.contains("EADDRNOTAVAIL") == false) goto L34;
        return NetError.ERR_ADDRESS_INVALID;
    L34:
        if (r1.contains("EADDRINUSE") == false) goto L43;
        return NetError.ERR_ADDRESS_IN_USE;
    L43:
        return r2;
    }

    public static int k(IOException r2) {
        if ((r2 instanceof SSLHandshakeException) == false) goto L6;
        return NetError.ERR_SSL_HANDSHAKE_NOT_COMPLETED;
    L6:
        if ((r2 instanceof SSLKeyException) == false) goto L9;
        return NetError.ERR_SSL_BAD_PEER_PUBLIC_KEY;
    L9:
        if ((r2 instanceof SSLProtocolException) == false) goto L12;
        return NetError.ERR_SSL_PROTOCOL_ERROR;
    L12:
        if ((r2 instanceof SSLPeerUnverifiedException) == false) goto L15;
        return NetError.ERR_SSL_DECRYPT_ERROR_ALERT;
    L15:
        if ((r2 instanceof UnknownHostException) == false) goto L18;
        return NetError.ERR_NAME_NOT_RESOLVED;
    L18:
        if ((r2 instanceof ConnectException) == false) goto L22;
        int r0 = NetError.ERR_CONNECTION_FAILED;
    L60:
        return i(r2, r0);
    L22:
        if ((r2 instanceof PortUnreachableException) == false) goto L25;
        return NetError.ERR_ADDRESS_INVALID;
    L25:
        if ((r2 instanceof NoRouteToHostException) == false) goto L28;
        return NetError.ERR_ADDRESS_UNREACHABLE;
    L28:
        if ((r2 instanceof BindException) == false) goto L31;
        return NetError.ERR_ADDRESS_IN_USE;
    L31:
        if ((r2 instanceof SocketException) == false) goto L34;
        r0 = -15;
        goto L60
    L34:
        if ((r2 instanceof MalformedURLException) == false) goto L37;
        return NetError.ERR_INVALID_URL;
    L37:
        if ((r2 instanceof SocketTimeoutException) == false) goto L40;
        return NetError.ERR_CONNECTION_TIMED_OUT;
    L40:
        if ((r2 instanceof ProtocolException) == false) goto L43;
        return -901;
    L43:
        if ((r2 instanceof HttpRetryException) == false) goto L51;
        String r3 = r2.getMessage();
        if (TextUtils.isEmpty(r3) == true) goto L68;
        if (r3.contains("Too many follow-up requests") == false) goto L68;
        return NetError.ERR_TOO_MANY_REDIRECTS;
    L68:
        return NetError.ERR_TTNET_UNSUPPORTED_REDIRECT;
    L51:
        if ((r2 instanceof UnknownServiceException) == false) goto L53;
        return -902;
    L53:
        return -1;
    }

    private static String o(p000j.v r4) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L17
        Iterator<Map.Entry<String, List<String>>> r5 = r4.l().entrySet().iterator();     // Catch: Exception -> L17
    L4:
        if (r5.hasNext() == false) goto L15;
        Map.Entry<String, List<String>> r1 = r5.next();     // Catch: Exception -> L17
        String r2 = r1.getKey();     // Catch: Exception -> L17
        List<String> r3 = r1.getValue();     // Catch: Exception -> L17
        if (TextUtils.isEmpty(r2) == true) goto L4;
        if (r3 == null) goto L4;
        if (r3.size() <= 0) goto L4;
        Iterator<String> r6 = r3.iterator();     // Catch: Exception -> L17
    L13:
        if (r6.hasNext() == false) goto L4;
        r0.put(r2, r6.next());     // Catch: Exception -> L17
        goto L13
    L15:
        return r0.toString();
    L17:
        return "";
    }

    private void p(String r12, JSONObject r13, long r14) {
        HashMap r11 = new HashMap();
        r r0 = new r();
        if (TextUtils.isEmpty(r12) == true) goto L18;
        String[] r15 = r12.split(",");
        if (r15 == null) goto L18;
        int r1 = r15.length;
        int r5 = 0;
    L7:
        if (r5 >= r1) goto L18;
        String[] r6 = r15[r5].split(";");
        if (r6 == null) goto L17;
        if (r6.length != 2) goto L17;
        if (TextUtils.isEmpty(r6[0]) == true) goto L17;
        if (TextUtils.isEmpty(r6[1]) == true) goto L17;
        r11.put(r6[0], r6[1]);
    L17:
        r5 = r5 + 1;
    L18:
        Iterator r16 = r11.entrySet().iterator();
    L20:
        if (r16.hasNext() == false) goto L41;
        Map.Entry r17 = (Map.Entry) r16.next();
        String r9 = ((String) r17.getKey()).trim();
        String r18 = ((String) r17.getValue()).trim();
        if (r9.equalsIgnoreCase("cdn-cache") == true) goto L23;
        if (r9.equalsIgnoreCase("edge") == true) goto L31;
        if (r9.equalsIgnoreCase("origin") == true) goto L34;
        if (r9.equalsIgnoreCase("inner") == true) goto L37;
        if (TextUtils.isEmpty(r9) == true) goto L20;
        r13.put(r9, J(r18));
        goto L20
    L37:
        r0.f13529e = J(r18);
        goto L20
    L34:
        r0.f13528d = J(r18);
        goto L20
    L31:
        r0.f13527c = J(r18);
        goto L20
    L23:
        r0.f13525a = true;
        String[] r19 = r18.split("=");
        if (r19.length != 2) goto L28;
        if (r19[1].equalsIgnoreCase("hit") == false) goto L28;
        r0.f13526b = true;
    L28:
        r0.f13526b = false;
        goto L20
    L41:
        boolean r110 = r0.f13525a;
        if (r110 == true) goto L44;
    L50:
        if (r110 == false) goto L60;
        r13.put("edge", r0.f13527c);
        r13.put("cdn-cache", "miss");
        long r7 = r0.f13528d;
        long r10 = r0.f13529e;
        if (r7 <= r10) goto L54;
        r13.put("origin", r7 - r10);
    L55:
        r13.put("inner", r0.f13529e);
        if (r14 == (-1)) goto L66;
        long r2 = r0.f13528d;
        long r3 = r0.f13527c;
        if (r14 <= (r2 + r3)) goto L66;
        long r111 = (r14 - r2) - r3;
    L65:
        r0.f13530f = r111;
    L66:
        r13.put("rtt", r0.f13530f);
        return;
    L54:
        r13.put("origin", -1);
        goto L55
    L60:
        r13.put("inner", r0.f13529e);
        if (r14 == (-1)) goto L66;
        long r4 = r0.f13529e;
        if (r14 <= r4) goto L66;
    L64:
        r111 = r14 - r4;
        goto L65
    L44:
        if (r0.f13526b == false) goto L50;
        r13.put("edge", r0.f13527c);
        r13.put("cdn-cache", "hit");
        if (r14 == (-1)) goto L66;
        r4 = r0.f13527c;
        if (r14 <= r4) goto L66;
        goto L66
    }

    public void A() {
        this.f13517k = System.currentTimeMillis();
    }

    public void B() {
        this.f13512f = System.currentTimeMillis();
    }

    public void C() {
        this.f13511e = System.currentTimeMillis();
        this.K = e.r;
    }

    public void D(int r1) {
        this.M = r1;
    }

    public void E(String r1, String r2) {
        this.O = r1;
        this.L = r2;
    }

    public void F(d.b.h.a.a.h.b r7, Context r8) {
        r7.f13357d = this.E;
        r7.o = K(this.f13509c, this.f13508b);
        r7.p = K(this.f13511e, this.f13510d);
        r7.q = K(this.f13512f, this.f13511e);
        r7.r = K(this.f13514h, this.f13513g) + K(this.f13516j, this.f13515i);
        r7.s = -1;
        r7.t = K(this.f13518l, this.f13514h);
        if (this.f13510d == (-1)) goto L5;
    L7:
        boolean r2 = false;
    L8:
        r7.u = r2;
        r7.v = -1;
        r7.w = K(this.o.get(), this.f13507a);
        r7.x = this.w;
        long r3 = this.z;
        r7.y = r3;
        r7.X = r3;
        r7.E = h(r8);
        r7.z = -1;
        p000j.v r9 = this.x;
        if (r9 == null) goto L11;
        r7.H = o(r9);
        r7.x += this.x.a();
    L11:
        p000j.v r10 = this.G;
        if (r10 == null) goto L14;
        r7.I = o(r10);
        r7.y += this.G.a();
    L14:
        r7.W = this.H;
        r7.K = -1;
        r7.f13353J = -1;
        r7.L = -1;
        return;
    L5:
        if (this.p == (-1)) goto L7;
        r2 = true;
        goto L8
    }

    public void G(d.b.h.a.a.h.c r1) {
        this.V = r1;
    }

    public void H(f0 r4) {
        boolean r1 = true;
        if (r4.g() == null) goto L5;
        boolean r0 = true;
    L6:
        this.C = r0;
        if (r4.O() != null) goto L10;
        r1 = false;
    L10:
        this.D = r1;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void a() {
        this.o.set(System.currentTimeMillis());
        this.K = e.f13485f;
        this.N = t.f13542g;
    }

    public void b(IOException r4) {
        this.o.set(System.currentTimeMillis());
        this.K = e.f13485f;
        if (r4 != null) goto L5;
    L9:
        t r0 = t.f13545j;
    L10:
        this.N = r0;
        this.M = k(r4);
        return;
    L5:
        if (TextUtils.isEmpty(r4.getMessage()) == true) goto L9;
        if (r4.getMessage().contains("Canceled") == false) goto L9;
        r0 = t.f13544i;
        goto L10
    }

    public void c() {
        this.f13507a = System.currentTimeMillis();
        this.N = t.f13543h;
    }

    public void d(Proxy r1) {
        System.currentTimeMillis();
        if (r1 == null) goto L6;
        this.s = r1.type();
        return;
    }

    public void e(InetSocketAddress r5, IOException r6, String r7) {
        System.currentTimeMillis();
        if (r5 == null) goto L8;
        if (this.o.get() != (-1)) goto L8;
        this.r.add(new Pair(r5, Integer.valueOf(k(r6))));
    L8:
        if (TextUtils.isEmpty(this.U) == true) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r7) == true) goto L14;
        this.U = r7;
        return;
    }

    public void f() {
        this.f13510d = System.currentTimeMillis();
        this.K = e.q;
    }

    public void g(p000j.j r5) {
        if (r5 != null) goto L4;
    L13:
        this.p = System.currentTimeMillis();
        return;
    L4:
        if (this.o.get() != (-1)) goto L13;
        if (r5.b() != null) goto L8;
    L12:
        this.F = r5.b();
        goto L13
    L8:
        if (r5.b().getInetAddress() == null) goto L12;
        if (r5.b().getInetAddress().getHostAddress() == null) goto L12;
        this.E = r5.b().getInetAddress().getHostAddress();
        goto L12
    }

    public void l() {
        this.f13509c = System.currentTimeMillis();
    }

    public void m(String r3) {
        this.f13509c = System.currentTimeMillis();
        this.U = r3;
    }

    public void n() {
        this.f13508b = System.currentTimeMillis();
        this.K = e.p;
    }

    public boolean q() {
        if (this.o.get() == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public void r(String r3, String r4, long r5, boolean r7, List<d.b.h.a.a.h.o.b.z.d> r8) {
        q r0 = new q();
        r0.f13521a = 307;
        r0.f13524d = true;
        r0.f13522b = r3;
        r0.f13523c = r4;
        this.f13506J.add(r0);
        this.I++;
        this.q = r5;
        this.P = true;
        if (r7 == false) goto L5;
        this.Q = true;
        this.S = d.b.h.a.a.h.o.b.z.l.m().g().size();
        return;
    L5:
        this.R.addAll(r8);
        this.Q = false;
    }

    public void s(d.b.h.a.a.h.o.b.y.b r1) {
        this.T = r1;
    }

    public void t(long r3) {
        this.f13516j = System.currentTimeMillis();
        this.w = r3;
    }

    public void u() {
        this.f13515i = System.currentTimeMillis();
    }

    public void v(d0 r5) {
        this.f13514h = System.currentTimeMillis();
        if (r5 != null) goto L5;
    L9:
        this.K = e.t;
        return;
    L5:
        if (this.o.get() != (-1)) goto L9;
        this.x = r5.d();
        if (r5.k() == null) goto L9;
        this.B = r5.k().D();
        goto L9
    }

    public void w() {
        this.K = e.s;
        this.f13513g = System.currentTimeMillis();
    }

    public void x(long r3) {
        this.n = System.currentTimeMillis();
        this.z = r3;
    }

    public void y() {
        this.K = e.u;
        this.m = System.currentTimeMillis();
    }

    public void z(f0 r5) {
        this.f13518l = System.currentTimeMillis();
        if (this.f13512f == (-1)) goto L5;
        d r0 = d.f13483h;
    L6:
        this.t = r0;
        if (r5 != null) goto L9;
        return;
    L9:
        if (this.o.get() != (-1)) goto L28;
        this.y = r5.s();
        this.A = r5.V();
        if (r5.x() == null) goto L15;
        this.u = r5.x().d();
        this.v = r5.x().a();
    L15:
        if (r5.L() == false) goto L21;
        this.I++;
        q r1 = new q();
        r1.f13521a = r5.s();
        r1.f13522b = r5.Y().f();
        String r2 = r5.A(LocationMonitorConst.LOCATION);
        if (TextUtils.isEmpty(r2) == true) goto L19;
        r1.f13523c = r2;
    L19:
        this.f13506J.add(r1);
    L21:
        if (r5.M() == false) goto L25;
        String r3 = r5.A("content-type");
        if (TextUtils.isEmpty(r3) == true) goto L25;
        this.H = r3;
    L25:
        this.G = r5.F();
        return;
    L28:
        return;
    L5:
        r0 = d.f13482g;
        goto L6
    }
}
