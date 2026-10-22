package d.b.r;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class y {
    public long A;
    public long A0;
    public int B;
    public long B0;
    public String C;
    public long C0;
    public boolean D;
    public long D0;
    public long E;
    public long E0;
    public long F;
    public long F0;
    public long G;
    public int G0;
    public long H;
    public JSONObject H0;
    public long I;
    public int I0;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public long f14613J;
    public List<b> J0;
    public long K;
    public List<b> K0;
    public long L;
    public long M;
    public long N;
    public long O;
    public long P;
    public boolean Q;
    public Throwable R;
    public Map<String, Long> S;
    public Map<String, Long> T;
    public long U;
    public long V;
    public long W;
    public long X;
    public long Y;
    public long Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public URL f14614a;
    public long a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14615b;
    public long b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14616c;
    public long c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f14617d;
    public long d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f14618e;
    public long e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f14619f;
    public long f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f14620g;
    public long g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14621h;
    public long h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f14622i;
    public boolean i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public JSONObject f14623j;
    public Map<String, Long> j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f14624k;
    public String k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f14625l;
    public JSONArray l0;
    public long m;
    public String m0;
    public long n;
    public long n0;
    public long o;
    public boolean o0;
    public long p;
    public long p0;
    public long q;
    public long q0;
    public long r;
    public long r0;
    public long s;
    public int s0;
    public long t;
    public int t0;
    public long u;
    public String u0;
    public long v;
    public String v0;
    public long w;
    public JSONObject w0;
    public long x;
    public int x0;
    public long y;
    public int y0;
    public long z;
    public long z0;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f14626g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f14627h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f14628i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f14629j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final /* synthetic */ a[] f14630k = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f14631f;

        static {
            a r0 = new a("ENCRYPT_NONE", 0, 0);
            f14626g = r0;
            a r1 = new a("ENCRYPT_QUERY", 1, 1);
            f14627h = r1;
            a r3 = new a("ENCRYPT_BODY", 2, 2);
            f14628i = r3;
            a r5 = new a("ENCRYPT_BOTH_QUERY_AND_BODY", 3, 3);
            f14629j = r5;
            f14630k = new a[]{r0, r1, r3, r5};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f14631f = r3;
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f14630k.clone();
        }

        public int a() {
            return this.f14631f;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f14632a;

        public b(y r1, String r2, long r3) {
        }
    }

    public y() {
        this.f14614a = null;
        this.f14615b = -1;
        this.f14616c = -1;
        this.f14617d = a.f14626g;
        this.f14619f = -1;
        this.f14620g = "";
        this.f14621h = -1;
        this.f14622i = "";
        this.f14624k = "";
        this.B = -1;
        this.C = null;
        this.E = -1;
        this.F = -1;
        this.G = -1;
        this.H = -1;
        this.I = -1;
        this.Q = false;
        this.S = new ConcurrentHashMap();
        this.T = new ConcurrentHashMap();
        this.U = -1;
        this.V = -1;
        this.W = -1;
        this.X = -1;
        this.Y = -1;
        this.Z = -1;
        this.a0 = -1;
        this.b0 = -1;
        this.c0 = -1;
        this.d0 = -1;
        this.e0 = -1;
        this.f0 = -1;
        this.g0 = -1;
        this.h0 = -1;
        this.j0 = new HashMap();
        this.k0 = "";
        this.y0 = -1;
        this.z0 = -1;
        this.A0 = -1;
        this.B0 = -1;
        this.C0 = -1;
        this.D0 = -1;
        this.E0 = -1;
        this.F0 = -1;
        this.G0 = -1;
        new HashMap();
        this.I0 = 0;
        this.J0 = new ArrayList();
        this.K0 = new ArrayList();
    }

    public y(boolean r7) {
        this.f14614a = null;
        this.f14615b = -1;
        this.f14616c = -1;
        this.f14617d = a.f14626g;
        this.f14619f = -1;
        this.f14620g = "";
        this.f14621h = -1;
        this.f14622i = "";
        this.f14624k = "";
        this.B = -1;
        this.C = null;
        this.E = -1;
        this.F = -1;
        this.G = -1;
        this.H = -1;
        this.I = -1;
        this.Q = false;
        this.S = new ConcurrentHashMap();
        this.T = new ConcurrentHashMap();
        this.U = -1;
        this.V = -1;
        this.W = -1;
        this.X = -1;
        this.Y = -1;
        this.Z = -1;
        this.a0 = -1;
        this.b0 = -1;
        this.c0 = -1;
        this.d0 = -1;
        this.e0 = -1;
        this.f0 = -1;
        this.g0 = -1;
        this.h0 = -1;
        this.j0 = new HashMap();
        this.k0 = "";
        this.y0 = -1;
        this.z0 = -1;
        this.A0 = -1;
        this.B0 = -1;
        this.C0 = -1;
        this.D0 = -1;
        this.E0 = -1;
        this.F0 = -1;
        this.G0 = -1;
        new HashMap();
        this.I0 = 0;
        this.J0 = new ArrayList();
        this.K0 = new ArrayList();
        this.o = System.currentTimeMillis();
        long r0 = SystemClock.uptimeMillis();
        this.n0 = r0;
        this.f14618e = r7;
        if (r7 == false) goto L6;
        this.u = r0;
        this.v = r0;
        return;
    }

    private JSONObject b() {
        JSONObject r8 = new JSONObject();
        r8.put("fallback", this.f14619f);     // Catch: JSONException -> L23
        if (TextUtils.isEmpty(this.f14620g) == true) goto L6;
        r8.put("fallbackMessage", this.f14620g);     // Catch: JSONException -> L23
    L6:
        r8.put("reqFallback", this.f14621h);     // Catch: JSONException -> L23
        if (TextUtils.isEmpty(this.f14622i) == true) goto L9;
        r8.put("reqFallbackMsg", this.f14622i);     // Catch: JSONException -> L23
    L9:
        r8.put("createRetrofitTime", this.o);     // Catch: JSONException -> L23
        r8.put("appRequestStartTime", this.p);     // Catch: JSONException -> L23
        r8.put("beforeAllInterceptTime", this.q);     // Catch: JSONException -> L23
        r8.put("callServerInterceptTime", this.r);     // Catch: JSONException -> L23
        r8.put("callExecuteStartTime", this.s);     // Catch: JSONException -> L23
        r8.put("reportTime", this.t);     // Catch: JSONException -> L23
        r8.put("delayWait", this.A);     // Catch: JSONException -> L23
        a r0 = this.f14617d;     // Catch: JSONException -> L23
        if (r0 == a.f14626g) goto L13;
        r8.put("encrypt", r0.a());     // Catch: JSONException -> L23
    L13:
        if (TextUtils.isEmpty(this.f14624k) == true) goto L15;
        r8.put("transactionId", this.f14624k);     // Catch: JSONException -> L23
    L15:
        long r1 = this.E0;     // Catch: JSONException -> L23
        if (r1 < 0) goto L18;
        r8.put(ICronetClient.KEY_UPPER_ADD_COOKIE_US, r1);     // Catch: JSONException -> L23
    L18:
        long r2 = this.F0;     // Catch: JSONException -> L23
        if (r2 < 0) goto L21;
        r8.put(ICronetClient.KEY_UPPER_SAVE_COOKIE_US, r2);     // Catch: JSONException -> L23
    L21:
        r8.put("request_cookie_source", this.G0);     // Catch: JSONException -> L23
    L25:
        boolean r7 = l(r8, "loadServiceMethod", this.u, this.v, true);
        long r3 = this.w;
        if (r3 <= 0) goto L28;
        boolean r11 = l(r8, "enqueueWait", r3, this.f14613J, r7);
        boolean r9 = true;
        l(r8, "biz_start_after_cronet_start", this.m / 1000, this.x / 1000, true);
        long r4 = this.x;
    L29:
        l(r8, "biz_start_before_cronet_end", r4 / 1000, this.n / 1000, r9);
        long r5 = this.M;
        long r6 = this.N;
        boolean r10 = l(r8, "executeCall", r5, r6, r11);
        boolean r12 = l(r8, "requestParse", this.K, this.L, r10);
        l(r8, "responseParse", this.O, this.P, r12);
        return r8;
    L28:
        r11 = l(r8, "executeWait", this.y, this.f14613J, r7);
        r9 = true;
        l(r8, "biz_start_after_cronet_start", this.m / 1000, this.z / 1000, true);
        r4 = this.z;
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L25
    }

    private JSONObject c() {
        JSONObject r0 = new JSONObject();
        r0.put("filterUrl", this.U);     // Catch: JSONException -> L8
        r0.put("addCommonParam", this.V);     // Catch: JSONException -> L8
        r0.put("requestVerify", this.W);     // Catch: JSONException -> L8
        r0.put("encryptRequest", this.Y);     // Catch: JSONException -> L8
        r0.put("genReqTicket", this.Z);     // Catch: JSONException -> L8
        r0.put("checkReqTicket", this.a0);     // Catch: JSONException -> L8
        r0.put("preCdnVerify", this.b0);     // Catch: JSONException -> L8
        r0.put("postCdnVerify", this.e0);     // Catch: JSONException -> L8
        r0.put("addClientKey", this.c0);     // Catch: JSONException -> L8
        r0.put("updateClientKey", this.d0);     // Catch: JSONException -> L8
        r0.put("commandListener", this.f0);     // Catch: JSONException -> L8
        r0.put("filterDupQuery", this.X);     // Catch: JSONException -> L8
        r0.put("queryFilter", this.g0);     // Catch: JSONException -> L8
        long r1 = this.h0;     // Catch: JSONException -> L8
        if (r1 < 0) goto L6;
        r0.put("bodyEncrypt", r1);     // Catch: JSONException -> L8
    L6:
        r0.put("setSpeed", this.z0);     // Catch: JSONException -> L8
        r0.put("tryInit", this.A0);     // Catch: JSONException -> L8
        r0.put("openConn", this.B0);     // Catch: JSONException -> L8
        r0.put("setConn", this.C0);     // Catch: JSONException -> L8
        r0.put("prepareReq", this.D0);     // Catch: JSONException -> L8
    L10:
        return r0;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    private JSONObject d() {
        JSONObject r0 = new JSONObject();
    L18:
        e = move-exception;
        e.printStackTrace();
    L20:
        return r0;
    L4:
        if (this.S.isEmpty() == true) goto L11;
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L18
        Iterator<Map.Entry<String, Long>> r2 = this.S.entrySet().iterator();     // Catch: JSONException -> L18
    L7:
        if (r2.hasNext() == false) goto L9;
        Map.Entry<String, Long> r3 = r2.next();     // Catch: JSONException -> L18
        r1.put(r3.getKey(), r3.getValue());     // Catch: JSONException -> L18
        goto L7
    L9:
        r0.put("request", r1);     // Catch: JSONException -> L18
    L11:
        if (this.T.isEmpty() == true) goto L20;
        JSONObject r4 = new JSONObject();     // Catch: JSONException -> L18
        Iterator<Map.Entry<String, Long>> r5 = this.T.entrySet().iterator();     // Catch: JSONException -> L18
    L14:
        if (r5.hasNext() == false) goto L16;
        Map.Entry<String, Long> r6 = r5.next();     // Catch: JSONException -> L18
        r4.put(r6.getKey(), r6.getValue());     // Catch: JSONException -> L18
        goto L14
    L16:
        r0.put("response", r4);     // Catch: JSONException -> L18
        goto L20
    }

    private JSONObject e() {
        JSONObject r3 = new JSONObject();
        r3.put("model", Build.MODEL);     // Catch: JSONException -> L13
        String r0 = "";
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        r0 = Build.CPU_ABI;     // Catch: JSONException -> L13
    L11:
        r3.put("abis", r0);     // Catch: JSONException -> L13
    L15:
        return r3;
    L6:
        String[] r1 = Build.SUPPORTED_ABIS;     // Catch: JSONException -> L13
        if (r1 == null) goto L11;
        if (r1.length <= 0) goto L11;
        r0 = Arrays.asList(r1).toString();     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    private boolean l(JSONObject r1, String r2, long r3, long r5, boolean r7) {
        if (r7 == true) goto L5;
    L10:
        r1.put(r2, -1);     // Catch: JSONException -> L12
        return false;
    L5:
        if (r3 > r5) goto L10;
        r1.put(r2, r5 - r3);     // Catch: JSONException -> L12
        return true;
    L12:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public y a() {
        y r0 = new y();
        r0.n0 = this.n0;
        r0.o = this.p;
        r0.f14618e = this.f14618e;
        r0.u = this.u;
        r0.v = this.v;
        return r0;
    }

    public String f() {
        JSONObject r0 = new JSONObject();
    L39:
        e = move-exception;
        e.printStackTrace();
    L42:
        return r0.toString();
    L4:
        if (this.f14619f == (-1)) goto L6;
        r0.put("model", e());     // Catch: JSONException -> L39
    L6:
        JSONObject r1 = this.f14623j;     // Catch: JSONException -> L39
        if (r1 == null) goto L9;
        r0.put("concurrentRequest", r1);     // Catch: JSONException -> L39
    L9:
        r0.put("concurrent", this.f14625l);     // Catch: JSONException -> L39
        r0.put("base", b());     // Catch: JSONException -> L39
        r0.put("callback", c());     // Catch: JSONException -> L39
        r0.put("interceptor", d());     // Catch: JSONException -> L39
        r0.put("ttnetVersion", this.k0);     // Catch: JSONException -> L39
        JSONArray r2 = this.l0;     // Catch: JSONException -> L39
        if (r2 != null) goto L12;
    L14:
        JSONObject r3 = this.w0;     // Catch: JSONException -> L39
        if (r3 == null) goto L17;
        r0.put("compress", r3);     // Catch: JSONException -> L39
    L17:
        int r4 = this.x0;     // Catch: JSONException -> L39
        if (r4 <= 0) goto L20;
        r0.put("postBufferSize", r4);     // Catch: JSONException -> L39
    L20:
        int r5 = this.I0;     // Catch: JSONException -> L39
        if (r5 <= 0) goto L23;
        r0.put("blockingQueueSize", r5);     // Catch: JSONException -> L39
    L23:
        int r6 = this.y0;     // Catch: JSONException -> L39
        if (r6 <= 0) goto L26;
        r0.put("apiStreamReadCount", r6);     // Catch: JSONException -> L39
    L26:
        r0.put("stateDelayed", this.D);     // Catch: JSONException -> L39
        r0.put("stateDelayTime", this.E);     // Catch: JSONException -> L39
        r0.put("syncCount", this.F);     // Catch: JSONException -> L39
        r0.put("asyncCount", this.G);     // Catch: JSONException -> L39
        r0.put("delayState", this.B);     // Catch: JSONException -> L39
        r0.put("random", this.I);     // Catch: JSONException -> L39
        if (TextUtils.isEmpty(this.C) == true) goto L30;
        r0.put("stateName", this.C);     // Catch: JSONException -> L39
    L30:
        if (this.i0 == false) goto L32;
        r0.put("cli_key", true);     // Catch: JSONException -> L39
    L32:
        int r7 = this.f14615b;     // Catch: JSONException -> L39
        if (r7 < 0) goto L35;
        r0.put("cp_cnt", r7);     // Catch: JSONException -> L39
    L35:
        int r8 = this.f14616c;     // Catch: JSONException -> L39
        if (r8 < 0) goto L42;
        r0.put("read_type", r8);     // Catch: JSONException -> L39
        goto L42
    L12:
        if (r2.length() <= 0) goto L14;
        r0.put("actionInfo", this.l0);     // Catch: JSONException -> L39
        goto L14
    }

    public void g() {
        if (this.J0.size() > 0) goto L5;
        return;
    L5:
        List<b> r2 = this.J0;
        r2.get(r2.size() - 1).f14632a = SystemClock.uptimeMillis();
    }

    public void h(d.b.r.j0.a r5) {
        String r6 = r5.getClass().getName();
        if (TextUtils.isEmpty(r6) == true) goto L6;
        String r7 = r6.substring(r6.lastIndexOf(46) + 1);
        this.J0.add(new b(this, r7, SystemClock.uptimeMillis()));
        return;
    }

    public void i() {
        if (this.K0.size() > 0) goto L5;
        return;
    L5:
        List<b> r2 = this.K0;
        r2.get(r2.size() - 1).f14632a = SystemClock.uptimeMillis();
    }

    public void j(d.b.r.j0.a r5) {
        String r6 = r5.getClass().getName();
        if (TextUtils.isEmpty(r6) == true) goto L6;
        String r7 = r6.substring(r6.lastIndexOf(46) + 1);
        this.K0.add(new b(this, r7, SystemClock.uptimeMillis()));
        return;
    }

    public void k(a r1) {
        this.f14617d = r1;
    }
}
