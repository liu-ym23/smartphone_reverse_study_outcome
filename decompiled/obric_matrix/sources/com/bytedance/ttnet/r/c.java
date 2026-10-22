package com.bytedance.ttnet.r;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.i;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.keva.KevaImpl;
import com.bytedance.ttnet.INetworkApi;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import d.b.h.a.a.h.o.b.g;
import d.b.h.a.a.h.s.h;
import d.b.h.a.a.h.s.k;
import d.b.h.a.a.h.s.l;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONException;
import org.json.JSONObject;
import p000j.d0;
import p000j.f0;
import p000j.w;

/* JADX INFO: loaded from: classes.dex */
public class c implements g {
    private static c A;
    private static String B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f6588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile long f6589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile long f6590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f6591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile long f6592e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f6593f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f6594g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f6595h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f6596i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile long f6597j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private AtomicBoolean f6598k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f6599l;
    private Context m;
    private com.bytedance.ttnet.r.b n;
    private volatile int o;
    private volatile long p;
    private volatile long q;
    private int r;
    private HashMap<String, Integer> s;
    private HashMap<String, Integer> t;
    private int u;
    private HashMap<String, Integer> v;
    private HashMap<String, Integer> w;
    private boolean x;
    Handler y;
    private volatile InterfaceC0202c z;

    class a implements d.b.h.a.a.h.r.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ICronetAppProvider f6600a;

        a(ICronetAppProvider r1) {
            this.f6600a = r1;
        }

        @Override // d.b.h.a.a.h.r.a
        public void a(String r1, String r2) {
            this.f6600a.sendAppMonitorEvent(r1, r2);
        }

        @Override // d.b.h.a.a.h.r.a
        public boolean b(JSONObject r1, String r2, String r3, boolean r4) {
            return c.l().p(r1, r2, r3, r4);
        }

        @Override // d.b.h.a.a.h.r.a
        public void onStoreIdcChanged(String r8, String r9, String r10, String r11, String r12, String r13) {
            com.bytedance.ttnet.k.b.a().c(r8, r9, r10, r11, r12, r13);
        }
    }

    class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f6601a;

        b(c r1, Looper r2) {
            this.f6601a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r3) {
            if (r3.what == 10000) goto L6;
            return;
        L6:
            if (r3.arg1 != 0) goto L8;
            boolean r0 = false;
        L9:
            c r2 = this.f6601a;
            c.f(r2, r0, c.e(r2, r3.arg2));
            return;
        L8:
            r0 = true;
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ttnet.r.c$c, reason: collision with other inner class name */
    public interface InterfaceC0202c {
        boolean a(String r1, String r2, List<d.b.r.h0.b> r3, String r4);

        boolean b(String r1, String r2, List<d.b.r.h0.b> r3, String r4);
    }

    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final d f6602g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final d f6603h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final d f6604i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final d f6605j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final d f6606k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final d f6607l = null;
        public static final d m = null;
        public static final d n = null;
        public static final d o = null;
        public static final d p = null;
        public static final d q = null;
        private static final /* synthetic */ d[] r = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f6608f;

        static {
            d r0 = new d("TTRESUME", 0, -2);
            f6602g = r0;
            d r1 = new d("TTHardCode", 1, -1);
            f6603h = r1;
            d r3 = new d("TTCACHE", 2, 0);
            f6604i = r3;
            d r5 = new d("TTSERVER", 3, 1);
            f6605j = r5;
            d r7 = new d("TTERROR", 4, 2);
            f6606k = r7;
            d r9 = new d("TTPOLL", 5, 3);
            f6607l = r9;
            d r11 = new d("TTTNC", 6, 4);
            m = r11;
            d r13 = new d("PORTRETRY", 7, 7);
            n = r13;
            d r15 = new d("TTREGION", 8, 10);
            o = r15;
            d r14 = new d("TTCRONET", 9, 20);
            p = r14;
            d r6 = new d("TTCRONETFAILED", 10, 30);
            q = r6;
            r = new d[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r6};
        }

        private d(String r1, int r2, int r3) {
            super(r1, r2);
            this.f6608f = r3;
        }

        public static d valueOf(String r1) {
            return (d) Enum.valueOf(d.class, r1);
        }

        public static d[] values() {
            return (d[]) r.clone();
        }
    }

    private c() {
        this.f6588a = 0;
        this.f6589b = 0;
        this.f6590c = 0;
        this.f6591d = d.f6604i;
        this.f6592e = 0;
        this.f6593f = false;
        this.f6594g = false;
        this.f6598k = new AtomicBoolean(false);
        this.f6599l = false;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = new HashMap();
        this.t = new HashMap();
        this.u = 0;
        this.v = new HashMap();
        this.w = new HashMap();
        this.x = true;
        this.y = new b(this, Looper.getMainLooper());
        this.z = null;
    }

    private List<d.b.r.h0.b> A(Map<String, List<String>> r6) {
        ArrayList r5 = new ArrayList();
        Iterator<String> r0 = r6.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        String r1 = r0.next();
        List<String> r2 = r6.get(r1);
        if (r2 == null) goto L4;
        Iterator<String> r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L4;
        r5.add(new d.b.r.h0.b(r1, r3.next()));
        goto L10
    L12:
        return r5;
    }

    private void B() {
        Logger.debug();
        this.r = 0;
        this.s.clear();
        this.t.clear();
        this.u = 0;
        this.v.clear();
        this.w.clear();
    }

    private void C(boolean r4, long r5, d r7) {
        if (this.y.hasMessages(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD) == false) goto L5;
        return;
    L5:
        Message r0 = this.y.obtainMessage();
        r0.what = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        r0.arg1 = r4 ? 1 : 0;
        r0.arg2 = r7.f6608f;
        Handler r3 = this.y;
        if (r5 <= 0) goto L8;
        r3.sendMessageDelayed(r0, r5);
        return;
    L8:
        r3.sendMessage(r0);
    }

    private d D(int r1) {
        if (r1 == 7) goto L34;
        if (r1 == 10) goto L32;
        if (r1 == 20) goto L30;
        if (r1 == 30) goto L28;
        switch(r1) {
            case -2: goto L26;
            case -1: goto L24;
            case 0: goto L22;
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            default: goto L12;
        };
    L12:
        return d.f6605j;
    L14:
        return d.m;
    L16:
        return d.f6607l;
    L18:
        return d.f6606k;
    L20:
        return d.f6605j;
    L22:
        return d.f6604i;
    L24:
        return d.f6603h;
    L26:
        return d.f6602g;
    L28:
        return d.q;
    L30:
        return d.p;
    L32:
        return d.o;
    L34:
        return d.n;
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences d(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    static /* synthetic */ d e(c r0, int r1) {
        return r0.D(r1);
    }

    static /* synthetic */ void f(c r0, boolean r1, d r2) {
        r0.h(r1, r2);
    }

    private static void g(k r3) {
        Object r0 = TTNetInit.getTTNetDepend();
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0 instanceof com.bytedance.ttnet.b) == false) goto L16;
        Map<String, String> r1 = ((com.bytedance.ttnet.b) r0).c();
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.isEmpty() == true) goto L18;
        Iterator<Map.Entry<String, String>> r2 = r1.entrySet().iterator();
    L12:
        if (r2.hasNext() == false) goto L19;
        Map.Entry<String, String> r4 = r2.next();
        r3.b(r4.getKey(), r4.getValue());
        goto L12
    L19:
        return;
    L18:
        return;
    }

    private void h(boolean r10, d r11) {
        com.bytedance.ttnet.r.a r0 = m();
        if (r0 != null) goto L5;
        return;
    L5:
        Logger.debug();
        long r1 = SystemClock.elapsedRealtime();
        if (r10 == false) goto L8;
    L11:
        this.f6588a = r1;
        if (r11 != d.m) goto L14;
        this.f6589b = System.currentTimeMillis();
    L14:
        com.bytedance.ttnet.j.a.s(this.m).p(r11, false);
        return;
    L8:
        if ((this.f6588a + (((long) r0.f6579j) * 1000)) <= r1) goto L11;
        Logger.debug();
    }

    private String j(Exception r2) {
        StringWriter r1 = new StringWriter();
        r2.printStackTrace(new PrintWriter(r1));
        return r1.toString().toLowerCase();
    }

    static String k() {
        return B;
    }

    public static synchronized c l() {
        monitor-enter(c.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (A != null) goto L7;
        A = new c();     // Catch: Throwable -> L10
    L7:
        c r1 = A;     // Catch: Throwable -> L10
        monitor-exit(c.class);
        return r1;
    }

    private void q(f0 r9, String r10) {
        if (r9 != null) goto L5;
        return;
    L5:
        if (this.x == true) goto L7;
        return;
    L7:
        String r11 = r9.C("tt-idc-switch", null);
        if (TextUtils.isEmpty(r11) == false) goto L11;
        Logger.debug();
        return;
    L11:
        String[] r12 = r11.split("@");
        if (r12 != null) goto L14;
    L35:
        Logger.debug();
        return;
    L14:
        if (r12.length != 2) goto L35;
        long r0 = 0;
        int r3 = Integer.parseInt(r12[0]);     // Catch: Throwable -> L20
        long r4 = Long.parseLong(r12[1]);     // Catch: Throwable -> L37
    L22:
        Logger.debug();
        if (r4 > this.p) goto L25;
        return;
    L25:
        this.o = r3;
        this.p = r4;
        this.f6590c = System.currentTimeMillis();
        d(this.m, "ttnet_tnc_config", 0).edit().putInt("tnc_probe_cmd", r3).putLong("tnc_probe_version", r4).apply();
        if (this.o != 10000) goto L42;
        com.bytedance.ttnet.r.a r13 = m();
        if (r13 != null) goto L30;
        return;
    L30:
        Random r2 = new Random(System.currentTimeMillis());
        int r14 = r13.f6580k;
        if (r14 <= 0) goto L33;
        r0 = ((long) r2.nextInt(r14)) * 1000;
    L33:
        Logger.debug();
        C(true, r0, d.m);
        return;
    L42:
        return;
    L21:
        Logger.debug();
        r4 = 0;
    L20:
        r3 = 0;
        goto L21
    }

    private boolean r(Context r8, d r9, String r10, String r11, String r12, String r13, boolean r14) {
        Logger.debug();     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r12) == true) goto L6;
        com.bytedance.ttnet.j.a.s(r8).F(r12);     // Catch: Exception -> L23
    L6:
        l().n.k(r13);     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r11) == true) goto L12;
        if (r11.equals(LocationInfoConst.ALLOW_USE_LOCATION) == false) goto L12;
        return true;
    L12:
        if (TextUtils.isEmpty(r10) == false) goto L14;
        return false;
    L14:
        JSONObject r2 = new JSONObject(r10);     // Catch: Exception -> L23
        ClientKeyManager.k().c(r10);     // Catch: Exception -> L23
        boolean r15 = com.bytedance.ttnet.j.a.s(r8).x(r2, r9, System.currentTimeMillis(), r14);     // Catch: Exception -> L23
        if (r15 == false) goto L22;
        this.f6592e = System.currentTimeMillis();     // Catch: Exception -> L23
        if (this.f6593f == true) goto L19;
        this.f6593f = true;     // Catch: Exception -> L23
    L19:
        this.f6594g = true;     // Catch: Exception -> L23
        if (r9 != d.m) goto L22;
        this.q = this.p;     // Catch: Exception -> L23
    L22:
        return r15;
    L23:
        return false;
    }

    private List<d.b.r.h0.b> s(Map<String, String> r5) {
        ArrayList r4 = new ArrayList();
        Iterator<String> r0 = r5.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        String r1 = r0.next();
        String r2 = r5.get(r1);
        if (TextUtils.isEmpty(r1) == true) goto L4;
        if (TextUtils.isEmpty(r2) == true) goto L4;
        r4.add(new d.b.r.h0.b(r1, r2));
        goto L4
    L10:
        return r4;
    }

    public static void t(ICronetAppProvider r9) {
        String r0 = r9.getCarrierRegion();
        String r1 = r9.getSysRegion();
        String r2 = r9.getRegion();
        if (TextUtils.isEmpty(r0) == true) goto L6;
    L9:
        String r4 = r0;
        d.b.h.a.a.h.r.b.n().m(r4, r9.getStoreIdcRuleJSON(), r9.getAppInitialRegionInfo(), TTNetInit.getTTNetDepend().getContext(), new a(r9));
        if (TextUtils.isEmpty(r0) == true) goto L13;
        B = TTNetInit.getGetDomainConfigByRegion(r0);
    L13:
        if (TextUtils.isEmpty(B) == false) goto L15;
        B = r9.getGetDomainDefaultJSON();
    L15:
        Logger.debug();
        return;
    L6:
        if (TextUtils.isEmpty(r1) == true) goto L8;
        r0 = r1;
        goto L9
    L8:
        r0 = r2;
        goto L9
    }

    private boolean v(int r4) {
        if (r4 >= 100) goto L5;
    L16:
        return true;
    L5:
        if (r4 >= 1000) goto L16;
        com.bytedance.ttnet.r.a r3 = m();
        if (r3 != null) goto L10;
        return false;
    L10:
        if (TextUtils.isEmpty(r3.f6581l) == false) goto L12;
        return false;
    L12:
        if (r3.f6581l.contains("" + r4) == false) goto L18;
        return true;
    L18:
        return false;
    }

    private boolean w(int r1) {
        if (r1 >= 200) goto L5;
        return false;
    L5:
        if (r1 >= 400) goto L10;
        return true;
    L10:
        return false;
    }

    private void z() {
        SharedPreferences r0 = d(this.m, "ttnet_tnc_config", 0);
        this.o = r0.getInt("tnc_probe_cmd", 0);
        this.p = r0.getLong("tnc_probe_version", 0);
    }

    @Override // d.b.h.a.a.h.o.b.g
    public synchronized void a(d0 r5, f0 r6) {
        monitor-enter(this);
        if (r5 == null) goto L72;
        if (r6 == null) goto L72;
    L69:
        th = move-exception;
        throw th;
    L7:
        if (this.x == true) goto L11;
        monitor-exit(this);
        return;
    L11:
        if (i.o(this.m) == true) goto L14;
        monitor-exit(this);
        return;
    L14:
        w r7 = r5.k();     // Catch: Throwable -> L69
        String r0 = r7.D();     // Catch: Throwable -> L69
        String r1 = r7.m();     // Catch: Throwable -> L69
        String r8 = r7.h();     // Catch: Throwable -> L69
        int r2 = r6.s();     // Catch: Throwable -> L69
        if ("http".equals(r0) == true) goto L21;
        if (LocationInfoConst.HTTPS.equals(r0) == true) goto L21;
        monitor-exit(this);
        return;
    L21:
        if (TextUtils.isEmpty(r1) == false) goto L25;
        monitor-exit(this);
        return;
    L25:
        if (r6.O() != null) goto L28;
        monitor-exit(this);
        return;
    L28:
        Logger.debug();     // Catch: Throwable -> L69
        com.bytedance.ttnet.r.a r3 = m();     // Catch: Throwable -> L69
        if (r3 != null) goto L31;
    L33:
        if (r3 != null) goto L35;
    L67:
        monitor-exit(this);
        return;
    L35:
        if (r3.f6570a == false) goto L67;
        Map<String, Integer> r9 = r3.f6572c;     // Catch: Throwable -> L69
        if (r9 != null) goto L40;
    L65:
        monitor-exit(this);
        return;
    L40:
        if (r9.size() <= 0) goto L65;
        if (r3.f6572c.containsKey(r1) == false) goto L65;
        Logger.debug();     // Catch: Throwable -> L69
        if (r2 > 0) goto L47;
    L63:
        monitor-exit(this);
        return;
    L47:
        if (w(r2) == false) goto L54;
        if (this.r <= 0) goto L51;
    L52:
        B();     // Catch: Throwable -> L69
        goto L63
    L51:
        if (this.u <= 0) goto L63;
    L54:
        if (v(r2) == true) goto L63;
        this.u++;     // Catch: Throwable -> L69
        this.v.put(r8, 0);     // Catch: Throwable -> L69
        this.w.put(r1, 0);     // Catch: Throwable -> L69
        if (this.u < r3.f6576g) goto L63;
        if (this.v.size() < r3.f6577h) goto L63;
        if (this.w.size() < r3.f6578i) goto L63;
        Logger.debug();     // Catch: Throwable -> L69
        C(false, 0, d.f6606k);     // Catch: Throwable -> L69
        goto L52
    L31:
        if (r3.f6571b == false) goto L33;
        q(r6, r1);     // Catch: Throwable -> L69
    L72:
        monitor-exit(this);
    }

    @Override // d.b.h.a.a.h.o.b.g
    public JSONObject b() {
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L29
        r2.put("update_time", this.f6592e);     // Catch: JSONException -> L29
        r2.put("source", this.f6591d.f6608f);     // Catch: JSONException -> L29
        int r5 = 1;
        if (this.f6593f == false) goto L6;
        int r4 = 1;
    L7:
        r2.put("cold_start", r4);     // Catch: JSONException -> L29
        if (this.f6594g == true) goto L11;
        r5 = 0;
    L11:
        r2.put("config_updated", r5);     // Catch: JSONException -> L29
        if (TextUtils.isEmpty(this.f6595h) == true) goto L15;
        r2.put("config", this.f6595h);     // Catch: JSONException -> L29
    L15:
        if (TextUtils.isEmpty(this.f6596i) == true) goto L17;
        r2.put("canary", this.f6596i);     // Catch: JSONException -> L29
    L17:
        r2.put("local_probe_version", this.q);     // Catch: JSONException -> L29
        String r3 = com.bytedance.ttnet.j.a.s(this.m).v();     // Catch: JSONException -> L29
        if (TextUtils.isEmpty(r3) == true) goto L20;
        r2.put("rules", r3);     // Catch: JSONException -> L29
    L20:
        com.bytedance.ttnet.r.b r6 = this.n;     // Catch: JSONException -> L29
        if (r6 != null) goto L23;
    L27:
        r1.put("data", r2);     // Catch: JSONException -> L29
        JSONObject r7 = new JSONObject();     // Catch: JSONException -> L29
        r7.put("version", this.p);     // Catch: JSONException -> L29
        r7.put("cmd", this.o);     // Catch: JSONException -> L29
        r7.put(ICronetClient.KEY_SEND_TIME, this.f6589b);     // Catch: JSONException -> L29
        r7.put("get_time", this.f6590c);     // Catch: JSONException -> L29
        r1.put("probe", r7);     // Catch: JSONException -> L29
        JSONObject r8 = new JSONObject();     // Catch: JSONException -> L29
        r8.put("probe_version", this.q);     // Catch: JSONException -> L29
        r8.put("source", this.f6591d.f6608f);     // Catch: JSONException -> L29
        r8.put("start_time", this.f6597j);     // Catch: JSONException -> L29
        r1.put("request", r8);     // Catch: JSONException -> L29
    L31:
        return r1;
    L23:
        if (TextUtils.isEmpty(r6.b()) == true) goto L27;
        if (TextUtils.isEmpty(this.n.c()) == true) goto L27;
        r2.put("region", this.n.b());     // Catch: JSONException -> L29
        r2.put("region_source", this.n.c());     // Catch: JSONException -> L29
        goto L27
    L6:
        r4 = 0;
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L31
    }

    @Override // d.b.h.a.a.h.o.b.g
    public synchronized void c(d0 r5, Exception r6) {
        monitor-enter(this);
        if (r5 == null) goto L63;
        if (r6 == null) goto L63;
    L60:
        th = move-exception;
        throw th;
    L7:
        if (this.x == true) goto L11;
        monitor-exit(this);
        return;
    L11:
        if (i.o(this.m) == true) goto L14;
        monitor-exit(this);
        return;
    L14:
        w r7 = r5.k();     // Catch: Throwable -> L60
        String r0 = r7.D();     // Catch: Throwable -> L60
        String r1 = r7.m();     // Catch: Throwable -> L60
        String r8 = r7.h();     // Catch: Throwable -> L60
        String r9 = j(r6);     // Catch: Throwable -> L60
        if ("http".equals(r0) == true) goto L21;
        if (LocationInfoConst.HTTPS.equals(r0) == true) goto L21;
        monitor-exit(this);
        return;
    L21:
        if (TextUtils.isEmpty(r1) == false) goto L25;
        monitor-exit(this);
        return;
    L25:
        if (TextUtils.isEmpty(r9) == false) goto L27;
    L58:
        monitor-exit(this);
        return;
    L27:
        if (r9.contains(LocationMonitorConst.TIMEOUT) == false) goto L58;
        if (r9.contains("time out") == false) goto L58;
        if (r9.contains("unreachable") == true) goto L58;
        com.bytedance.ttnet.r.a r10 = m();     // Catch: Throwable -> L60
        if (r10 != null) goto L36;
    L56:
        monitor-exit(this);
        return;
    L36:
        if (r10.f6570a == false) goto L56;
        Map<String, Integer> r2 = r10.f6572c;     // Catch: Throwable -> L60
        if (r2 != null) goto L41;
    L54:
        monitor-exit(this);
        return;
    L41:
        if (r2.size() <= 0) goto L54;
        if (r10.f6572c.containsKey(r1) == false) goto L54;
        Logger.debug();     // Catch: Throwable -> L60
        this.r++;     // Catch: Throwable -> L60
        this.s.put(r8, 0);     // Catch: Throwable -> L60
        this.t.put(r1, 0);     // Catch: Throwable -> L60
        if (this.r >= r10.f6573d) goto L48;
    L52:
        monitor-exit(this);
        return;
    L48:
        if (this.s.size() < r10.f6574e) goto L52;
        if (this.t.size() < r10.f6575f) goto L52;
        Logger.debug();     // Catch: Throwable -> L60
        C(false, 0, d.f6606k);     // Catch: Throwable -> L60
        B();     // Catch: Throwable -> L60
    L63:
        monitor-exit(this);
    }

    public boolean i(Context r23, boolean r24, d r25, String r26) {
        Logger.debug();
        ArrayList r0 = new ArrayList();
        if (com.bytedance.ttnet.j.a.s(r23).u() != null) goto L5;
    L12:
        r0.addAll(Arrays.asList(com.bytedance.ttnet.j.a.s(r23).q()));
    L13:
        this.f6591d = r25;
        this.f6597j = System.currentTimeMillis();
        Iterator r12 = r0.iterator();
    L15:
        if (r12.hasNext() == false) goto L77;
        k r1 = new k("https://" + ((String) r12.next()) + "/get_domains/v5/");
        if (Build.VERSION.SDK_INT >= 21) goto L20;
        String r2 = Build.CPU_ABI;     // Catch: Throwable -> L79
    L21:
        r1.b("abi", r2);     // Catch: Throwable -> L79
        r1.a("tnc_src", r25.f6608f);     // Catch: Throwable -> L79
        r1.b("okhttp_version", "4.2.228.16-pico");     // Catch: Throwable -> L79
        if (d.b.h.a.a.h.r.b.n().p() == false) goto L24;
        r1.b("use_store_region_cookie", LocationInfoConst.ALLOW_USE_LOCATION);     // Catch: Throwable -> L79
    L24:
        g(r1);     // Catch: Throwable -> L79
        goto L25
    L20:
        r2 = Build.SUPPORTED_ABIS[0];     // Catch: Throwable -> L79
    L25:
        HashMap r3 = new HashMap();
        d.b.h.a.a.h.r.b.n().c(r3);
        boolean r9 = !TextUtils.isEmpty(d.b.h.a.a.h.r.b.n().j());
        if (TextUtils.isEmpty(r26) == true) goto L30;
        r3.put("x-tt-tnc-summary", r26);
    L30:
        if (r24 == false) goto L31;
        r1.a(WsConstants.KEY_APP_ID, TTNetInit.getTTNetDepend().getAppId());
        r1.b("device_platform", "android");
        if (TTNetInit.getCronetProvider() == null) goto L45;
        r1.b("version_code", TTNetInit.getCronetProvider().getVersionCode());
        r1.b("channel", TTNetInit.getCronetProvider().getChannel());
    L45:
        ArrayList r4 = new ArrayList();
        Iterator<Map.Entry<String, String>> r5 = r3.entrySet().iterator();
    L47:
        if (r5.hasNext() == false) goto L53;
        Map.Entry<String, String> r6 = r5.next();
        if (TextUtils.isEmpty(r6.getKey()) == true) goto L47;
        if (TextUtils.isEmpty(r6.getValue()) == true) goto L47;
        r4.add(new d.b.r.h0.b(r6.getKey(), r6.getValue()));
        goto L47
    L53:
        String r7 = r1.toString();
        LinkedHashMap r8 = new LinkedHashMap();
        Pair<String, String> r10 = l.j(r7, r8);     // Catch: IOException -> L75
        String r11 = (String) r10.first;     // Catch: IOException -> L75
        String r18 = (String) r10.second;     // Catch: IOException -> L75
        INetworkApi r15 = (INetworkApi) com.bytedance.ttnet.s.d.f(r11, INetworkApi.class);
        if (r15 == null) goto L15;
        d.b.r.b<String> r13 = r15.doGet(true, -1, r18, r8, r4, null);
        d.b.r.d0<String> r14 = r13.execute();     // Catch: Throwable -> L73
        List<d.b.r.h0.b> r16 = r14.d();     // Catch: Throwable -> L73
        String r17 = r14.a();     // Catch: Throwable -> L73
        if (this.z != null) goto L62;
    L66:
        String r19 = com.bytedance.ttnet.s.d.g(r16, "x-ss-etag");     // Catch: Throwable -> L73
        String r20 = com.bytedance.ttnet.s.d.g(r16, "x-tt-tnc-abtest");     // Catch: Throwable -> L73
        String r21 = com.bytedance.ttnet.s.d.g(r16, "x-tt-tnc-control");     // Catch: Throwable -> L73
        this.f6595h = com.bytedance.ttnet.s.d.g(r16, "x-tt-tnc-config");     // Catch: Throwable -> L73
        this.f6596i = com.bytedance.ttnet.s.d.g(r16, "x-ss-canary");     // Catch: Throwable -> L73
        if (l().r(r23, r25, r17, r21, r19, r20, r9) == true) goto L70;
        if (r13 == null) goto L15;
    L69:
        r13.cancel();
        goto L15
    L70:
        if (r13 == null) goto L72;
        r13.cancel();
    L72:
        return true;
    L62:
        if (this.z.a("GET", r13.b().G(), r16, r17) == true) goto L66;
        if (r13 == null) goto L65;
        r13.cancel();
    L65:
        return false;
    L73:
        if (r13 == null) goto L15;
    L75:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L31:
        com.bytedance.ttnet.m.a r22 = new com.bytedance.ttnet.m.a();
        r22.f6473b = r1.toString();
        r22.f6475d = true;
        System.currentTimeMillis();
        if (x("GET", r22.f6473b, r3, "") == false) goto L34;
        HashMap r27 = new HashMap();     // Catch: Throwable -> L78
        String r28 = com.bytedance.ttnet.m.c.a(r22.f6473b, r3, r27, r22);     // Catch: Throwable -> L78
        if (y("GET", r22.f6473b, r27, r28) == false) goto L37;
        System.currentTimeMillis();     // Catch: Throwable -> L78
        this.f6596i = r22.f6483l;     // Catch: Throwable -> L78
        this.f6595h = r22.f6482k;     // Catch: Throwable -> L78
        if (l().r(r23, r25, r28, r22.f6481j, r22.f6477f, r22.f6478g, r9) == false) goto L15;
        return true;
    L37:
        return false;
    L34:
        return false;
    L77:
        return false;
    L5:
        if (com.bytedance.ttnet.j.a.s(r23).u().size() == 0) goto L12;
        r0.addAll(com.bytedance.ttnet.j.a.s(r23).u());
        String[] r29 = com.bytedance.ttnet.j.a.s(r23).q();
        int r30 = r29.length;
        int r31 = 0;
    L7:
        if (r31 >= r30) goto L13;
        String r32 = r29[r31];
        if (r0.contains(r32) == true) goto L11;
        r0.add(r32);
    L11:
        r31 = r31 + 1;
        goto L7
    }

    public com.bytedance.ttnet.r.a m() {
        com.bytedance.ttnet.r.b r0 = this.n;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.d();
    }

    public com.bytedance.ttnet.r.b n() {
        return this.n;
    }

    public void o() {
        if (m() != null) goto L5;
        return;
    L5:
        if (h.h(this.m) == true) goto L7;
        return;
    L7:
        if (this.f6598k.compareAndSet(false, true) == false) goto L12;
        C(true, 0, d.q);
        return;
    }

    public boolean p(JSONObject r11, String r12, String r13, boolean r14) {
        Logger.debug();
        if (r11 == null) goto L10;
        com.bytedance.ttnet.r.b r1 = this.n;
        if (r1 == null) goto L7;
        r1.k("");
        boolean r15 = this.n.e(r11, d.f6605j, r12, r13, System.currentTimeMillis());
    L8:
        if (r15 == false) goto L11;
        d.b.h.a.a.h.r.b.n().s();
    L11:
        if (r14 == false) goto L15;
        if (r15 == true) goto L15;
        h(true, d.o);
        return true;
    L15:
        return false;
    L7:
        r15 = false;
        goto L8
    L10:
        r15 = false;
        goto L11
    }

    public synchronized void u(Context r2, boolean r3) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f6599l == true) goto L9;
        this.m = r2;     // Catch: Throwable -> L11
        this.x = r3;     // Catch: Throwable -> L11
        this.n = new com.bytedance.ttnet.r.b(r2, r3);     // Catch: Throwable -> L11
        if (r3 == false) goto L8;
        z();     // Catch: Throwable -> L11
    L8:
        Logger.debug();     // Catch: Throwable -> L11
        this.f6599l = true;     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
    }

    public boolean x(String r2, String r3, Map<String, String> r4, String r5) {
        if (this.z != null) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        List<d.b.r.h0.b> r6 = s(r4);
        return this.z.b(r2, r3, r6, r5);
    }

    public boolean y(String r2, String r3, Map<String, List<String>> r4, String r5) {
        if (this.z != null) goto L6;
        return true;
    L6:
        List<d.b.r.h0.b> r6 = A(r4);
        return this.z.a(r2, r3, r6, r5);
    }
}
