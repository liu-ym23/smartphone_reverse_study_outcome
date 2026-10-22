package com.bytedance.frameworks.baselib.network.http.cronet.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import d.b.r.y;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class j extends d.b.h.a.a.h.a implements ICronetClient.ICronetBootFailureCheckerProvider, ICronetClient.ICronetThreadStackOptFailureCheckerProvider {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f4739c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile int f4740d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Context f4741e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static ICronetClient f4742f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile j f4743g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile boolean f4744h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile String f4745i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile String f4746j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static ConcurrentHashMap<String, Integer> f4747k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static Map<String, Integer> f4748l;
    private static volatile ICronetAppProvider m;
    private static a n;
    private static b o;
    private static c p;
    private static d q;

    public interface a {
        boolean isCronetBootFailureExpected();
    }

    public interface b {
        boolean h();
    }

    public interface c {
        String getThreadStackInitReason();

        boolean isCronetThreadStackOptFailureExpected();
    }

    public interface d {
        JSONObject j();
    }

    static {
        f4747k = new ConcurrentHashMap();
        f4748l = new ConcurrentHashMap();
    }

    private j(Context r1) {
        f4741e = r1.getApplicationContext();
    }

    public static void A(String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22) {
        g();
        f4742f.notifyStoreRegionUpdated(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public static void D(SharedPreferences.Editor r2) {
        r2.putInt("cronet_inputstream_buff_size", f4740d);
        if (f4745i == null) goto L6;
        r2.putString("post_body_buffer_size", f4745i);
    L6:
        if (f4746j == null) goto L9;
        r2.putString("path_cronet_inputstream_buff_size", f4746j);
        return;
    }

    protected static HttpURLConnection E(String r10, d.b.h.a.a.h.b r11) {
        b0();
        ICronetClient r0 = f4742f;
        if (r0 == null) goto L11;
        r0.setCronetBootFailureCheckerProvider(f4743g);
        f4742f.setCronetThreadStackOptFailureCheckerProvider(f4743g);
        ICronetClient r2 = f4742f;
        Context r3 = f4741e;
        b r1 = o;
        if (r1 != null) goto L7;
        boolean r4 = false;
    L8:
        HttpURLConnection r12 = r2.openConnection(r3, r10, r4, d.b.h.a.a.h.g.r(), r11.f13355b, new d.b.h.a.a.h.q.c(), m);
        r12.setConnectTimeout(d.b.h.a.a.h.g.i());
        r12.setReadTimeout(d.b.h.a.a.h.g.o());
        return r12;
    L7:
        r4 = r1.h();
        goto L8
    L11:
        throw new IllegalArgumentException("CronetClient is null");
    }

    public static void K(String r1, String r2) {
        g();
        f4742f.setBestHostWithRouteSelectionName(r1, r2);
    }

    public static void L(boolean r0) {
        f4744h = r0;
    }

    public static void N(ICronetAppProvider r0) {
        m = r0;
    }

    public static void O(a r0) {
        n = r0;
    }

    public static void P(b r0) {
        o = r0;
    }

    public static void Q(c r0) {
        p = r0;
    }

    public static void R(d r0) {
        q = r0;
    }

    private static void b0() {
        if (f4742f == null) goto L5;
        return;
    L5:
        if (com.bytedance.common.utility.k.c(f4739c) == true) goto L7;
        String r0 = f4739c;
    L13:
        Object r1 = Class.forName(r0).newInstance();     // Catch: Throwable -> L12
        if ((r1 instanceof ICronetClient) == false) goto L16;
        f4742f = (ICronetClient) r1;     // Catch: Throwable -> L12
        return;
    L16:
        return;
    L17:
        return;
    L7:
        r0 = "org.chromium.CronetClient";
        goto L13
    }

    public static void d0(JSONObject r7, SharedPreferences r8) {
        if (r7 == null) goto L18;
        f4740d = r7.optInt("cronet_inputstream_buff_size", 0);
        JSONObject r5 = r7.optJSONObject("post_body_buffer_size");     // Catch: Throwable -> L26
        if (r5 == null) goto L8;
        h0(r5);     // Catch: Throwable -> L26
        f4745i = r5.toString();     // Catch: Throwable -> L26
    L9:
        JSONObject r9 = r7.optJSONObject("path_cronet_inputstream_buff_size");     // Catch: Throwable -> L26
        if (r9 == null) goto L17;
        String r6 = r9.toString();     // Catch: Throwable -> L26
        if (f4746j != null) goto L14;
    L16:
        g0(r9);     // Catch: Throwable -> L26
        f4746j = r6;     // Catch: Throwable -> L26
        goto L18
    L14:
        if (r6.equals(f4746j) == false) goto L16;
        return;
    L17:
        f4748l.clear();     // Catch: Throwable -> L26
        f4746j = "";     // Catch: Throwable -> L26
        goto L18
    L8:
        f4747k.clear();     // Catch: Throwable -> L26
        f4745i = "";     // Catch: Throwable -> L26
    L18:
        if (r8 == null) goto L34;
        f4740d = r8.getInt("cronet_inputstream_buff_size", 0);
        String r10 = r8.getString("post_body_buffer_size", "");
        if (TextUtils.isEmpty(r10) == false) goto L29;
    L22:
        String r11 = r8.getString("path_cronet_inputstream_buff_size", "");
        if (TextUtils.isEmpty(r11) == true) goto L35;
        g0(new JSONObject(r11));     // Catch: Throwable -> L28
        return;
    L36:
        return;
    L35:
        return;
    L29:
        h0(new JSONObject(r10));     // Catch: Throwable -> L27
        goto L22
    }

    public static l f0(String r1, int r2, boolean r3) {
        g();
        return f4742f.ttUrlDispatch(r1, r2, r3);
    }

    private static void g() {
        if (f4742f == null) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    private static void g0(JSONObject r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        f4748l.clear();
        Iterator<String> r0 = r4.keys();
    L6:
        if (r0.hasNext() == false) goto L13;
        String r1 = r0.next();
        if (TextUtils.isEmpty(r1) == true) goto L6;
        int r2 = r4.optInt(r1);
        if (y(r2) == false) goto L6;
        f4748l.put(r1, Integer.valueOf(r2));
        goto L6
    }

    private static void h0(JSONObject r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        f4747k.clear();
        Iterator<String> r0 = r4.keys();
    L6:
        if (r0.hasNext() == false) goto L12;
        String r1 = r0.next();
        int r2 = r4.optInt(r1);
        if (TextUtils.isEmpty(r1) == true) goto L6;
        if (z(r2) == false) goto L6;
        f4747k.put(r1, Integer.valueOf(r2));
        goto L6
    }

    public static Context j() {
        return f4741e;
    }

    protected static int k(String r1, d.b.h.a.a.h.b r2) {
        if (x(f4740d) == false) goto L7;
        return f4740d;
    L7:
        if (TextUtils.isEmpty(r1) == false) goto L9;
    L18:
        if (r2 == null) goto L29;
        T r3 = r2.f13358e;
        if (r3 != 0) goto L22;
        return 0;
    L22:
        if (x(r3.p) == true) goto L28;
        T r4 = r2.f13358e;
        if (r4.q == true) goto L26;
        return 0;
    L26:
        if (y(r4.p) == true) goto L28;
        return 0;
    L28:
        return r2.f13358e.p;
    L29:
        return 0;
    L9:
        if (f4748l.isEmpty() == true) goto L18;
        if (f4748l.containsKey(r1) == false) goto L18;
        Integer r5 = f4748l.get(r1);
        if (r5 == null) goto L18;
        if (x(r5.intValue()) == false) goto L18;
        return r5.intValue();
    }

    public static int l(HttpURLConnection r1) {
        return f4742f.getCronetInternalErrorCode(r1);
    }

    protected static int m(String r2, int r3) {
        if (z(r3) == true) goto L7;
        r3 = 0;
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return r3;
    L10:
        if (f4747k.containsKey(r2) == false) goto L16;
        Integer r4 = f4747k.get(r2);
        if (r4 != null) goto L14;
        r3 = 0;
        goto L16
    L14:
        r3 = r4.intValue();
    L16:
        if (z(r3) == true) goto L18;
        return 0;
    L18:
        return r3;
    }

    public static d n() {
        return q;
    }

    public static String o() {
        g();
        return f4742f.getCronetVersion();
    }

    public static boolean q() {
        return f4744h;
    }

    protected static Map<String, Object> v(HttpURLConnection r1) {
        ICronetClient r0 = f4742f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRequestMetricsMap(r1);
    }

    public static j w(Context r2) {
        if (f4743g != null) goto L15;
        monitor-enter(j.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f4743g != null) goto L9;
        f4743g = new j(r2);     // Catch: Throwable -> L11
        b0();     // Catch: Throwable -> L11
    L9:
        monitor-exit(j.class);     // Catch: Throwable -> L11
    L15:
        return f4743g;
    }

    protected static boolean x(int r1) {
        if (r1 >= 8192) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 20971520) goto L7;
        return true;
    }

    protected static boolean y(int r1) {
        if (r1 > 0) goto L4;
    L6:
        return false;
    L4:
        if (r1 > 20971520) goto L6;
        return true;
    }

    protected static boolean z(int r1) {
        if (r1 >= 16384) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 10485760) goto L7;
        return true;
    }

    public boolean B(boolean r1) {
        g();
        return f4742f.notifySwitchToMultiNetwork(r1);
    }

    public void C(String r8, String r9, String r10, String r11, String r12, String r13) {
        g();
        f4742f.notifyTNCConfigUpdated(r8, r9, r10, r11, r12, r13);
    }

    public void F(String r1, Map<String, String> r2) {
        g();
        f4742f.preconnectUrl(r1, r2);
    }

    public void G(String r1) {
        if (f4742f != null) goto L6;
        return;
    L6:
        if (d.b.h.a.a.h.s.h.h(f4741e) == true) goto L8;
        return;
    L8:
        f4742f.removeClientOpaqueData(r1);
    }

    public void H(String r1) {
        g();
        f4742f.reportNetDiagnosisUserLog(r1);
    }

    public void I(boolean r1) {
        if (f4742f != null) goto L6;
        return;
    L6:
        if (d.b.h.a.a.h.s.h.h(f4741e) == true) goto L8;
        return;
    L8:
        f4742f.runInBackGround(r1);
    }

    public void J(long r1) {
        g();
        f4742f.setAlogFuncAddr(r1);
    }

    public void M() {
        g();
        f4742f.setCookieInitCompleted();
    }

    public void S(String r1) {
        g();
        f4742f.setHostResolverRules(r1);
    }

    public void T(String r1) {
        g();
        f4742f.setProxy(r1);
    }

    public void U(JSONObject r1) {
        g();
        f4742f.setSlaSamplingSetting(r1);
    }

    public void V(long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32) {
        g();
        f4742f.setZstdFuncAddr(r18, r20, r22, r24, r26, r28, r30, r32);
    }

    public void W(String[] r1, int r2, long r3) {
        g();
        f4742f.startThrottle(r1, r2, r3);
    }

    public void X(String[] r1, int r2) {
        g();
        f4742f.stopThrottle(r1, r2);
    }

    public void Y(boolean r1) {
        if (f4742f != null) goto L6;
        return;
    L6:
        if (d.b.h.a.a.h.s.h.h(f4741e) == true) goto L8;
        return;
    L8:
        f4742f.triggerGetDomain(r1);
    }

    public void Z() {
        g();
        f4742f.triggerSwitchingToCellular();
    }

    @Override // d.b.r.h0.a
    public d.b.r.h0.e a(d.b.r.h0.c r6) {
        long r0 = SystemClock.uptimeMillis();
        d.b.r.h0.c r5 = d.b.h.a.a.j.d.f().e(r6);
        if (r6.z() == null) goto L5;
        y r2 = r6.z();
        r2.g0 = SystemClock.uptimeMillis() - r0;
    L5:
        if (r5 == null) goto L8;
        r6 = r5;
    L8:
        if (g.d().e() == false) goto L20;
        if (r6.G().contains("no_retry=1") == true) goto L20;
        g.a r7 = g.d().b(r6);
        if (r7 == null) goto L20;
        if (r7.a() == null) goto L20;
        if (r7.a().size() < 2) goto L20;
        return new com.bytedance.frameworks.baselib.network.http.cronet.e.d(r6, r7);
    L20:
        return new f(r6);
    }

    public void a0(boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, ICronetAppProvider r18) {
        b0();
        ICronetClient r1 = f4742f;
        if (r1 == null) goto L6;
        r1.setCronetBootFailureCheckerProvider(this);
        f4742f.setCronetThreadStackOptFailureCheckerProvider(this);
        f4742f.tryCreateCronetEngine(f4741e, r13, r14, r15, r16, d.b.h.a.a.h.g.r(), new d.b.h.a.a.h.q.c(), r17, r18);
        return;
    }

    public void c0(String[] r1, int r2, int r3) {
        g();
        f4742f.tryStartNetDetect(r1, r2, r3);
    }

    public void e0(String r1, int r2, String r3, Map<String, String> r4) {
        g();
        f4742f.ttDnsResolve(r1, r2, r3, r4);
    }

    public void f(String[] r9, byte[] r10, byte[] r11, long r12, long r14) {
        if (f4742f != null) goto L6;
        return;
    L6:
        if (d.b.h.a.a.h.s.h.h(f4741e) == true) goto L8;
        return;
    L8:
        f4742f.addClientOpaqueData(r9, r10, r11, r12, r14);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient.ICronetThreadStackOptFailureCheckerProvider
    public String getThreadStackInitReason() {
        c r0 = p;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getThreadStackInitReason();
    }

    public void h() {
        if (f4742f != null) goto L6;
        return;
    L6:
        if (d.b.h.a.a.h.s.h.h(f4741e) == true) goto L8;
        return;
    L8:
        f4742f.clearClientOpaqueData();
    }

    public void i(boolean r8, String r9, String r10, String r11, boolean r12, String r13) {
        g();
        f4742f.enableTTBizHttpDns(r8, r9, r10, r11, r12, r13);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient.ICronetBootFailureCheckerProvider
    public boolean isCronetBootFailureExpected() {
        a r0 = n;
        if (r0 != null) goto L6;
        return false;
    L6:
        return r0.isCronetBootFailureExpected();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient.ICronetThreadStackOptFailureCheckerProvider
    public boolean isCronetThreadStackOptFailureExpected() {
        c r0 = p;
        if (r0 != null) goto L6;
        return false;
    L6:
        return r0.isCronetThreadStackOptFailureExpected();
    }

    public int p() {
        g();
        return f4742f.getEffectiveConnectionType();
    }

    public Map<String, h> r() {
        g();
        return f4742f.getGroupRttEstimates();
    }

    public void s(String r1) {
        g();
        f4742f.getMappingRequestState(r1);
    }

    public h t() {
        g();
        return f4742f.getNetworkQuality();
    }

    public i u(int r1) {
        g();
        return f4742f.getPacketLossRateMetrics(r1);
    }
}
