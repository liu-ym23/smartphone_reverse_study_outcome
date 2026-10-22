package com.bytedance.ttnet.j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.CookieManager;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ttnet.TTNetInit;
import d.b.h.a.a.h.o.b.s;
import d.b.h.a.a.h.s.l;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements d.b.h.a.a.h.g.e, WeakHandler.IHandler, d.b.h.b.a.a.InterfaceC0365a, com.bytedance.ttnet.d.c, com.bytedance.frameworks.baselib.network.http.cronet.e.j.b, com.bytedance.frameworks.baselib.network.http.cronet.e.j.a, d.b.h.a.a.f.b.InterfaceC0356b, d.b.h.a.a.h.g.i, com.bytedance.frameworks.baselib.network.http.cronet.e.j.d, d.b.h.a.a.h.g.InterfaceC0359g, d.b.h.a.a.h.g.j {
    private static a G = null;
    private static String H = null;
    private static String I = "";

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static int f6331J = -1;
    private static int K = -1;
    static boolean L = false;
    static boolean M = true;
    static boolean N = false;
    private static ArrayList<String> O;
    static boolean P;
    private static boolean Q;
    private static boolean R;
    private String A;
    private JSONObject B;
    private String C;
    private final AtomicInteger D;
    private final List<String> E;
    final WeakHandler F;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f6332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AtomicLong f6333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AtomicBoolean f6334h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f6335i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Context f6336j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile boolean f6337k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile int f6338l;
    private long m;
    private AtomicBoolean n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private String w;
    private List<String> x;
    private List<String> y;
    private volatile int z;

    /* JADX INFO: renamed from: com.bytedance.ttnet.j.a$a, reason: collision with other inner class name */
    class C0198a extends com.bytedance.common.utility.m.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ a f6339k;

        C0198a(a r1, String r2) {
            this.f6339k = r1;
            super(r2);
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            this.f6339k.G();
        }
    }

    class b extends com.bytedance.common.utility.m.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ com.bytedance.ttnet.r.c.d f6340k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ boolean f6341l;
        final /* synthetic */ a m;

        b(a r1, String r2, com.bytedance.ttnet.r.c.d r3, boolean r4) {
            this.m = r1;
            this.f6340k = r3;
            this.f6341l = r4;
            super(r2);
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            this.m.L(this.f6340k, this.f6341l);
        }
    }

    class c extends com.bytedance.common.utility.m.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ Map f6342k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ a f6343l;

        c(a r1, String r2, Map r3) {
            this.f6343l = r1;
            this.f6342k = r3;
            super(r2);
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            TTNetInit.getTTNetDepend().b(a.n(this.f6343l), this.f6342k);
            Intent r0 = new Intent("com.bytedance.ttnet.config.appconfig.SYNC_MAIN_PROCESS_CONFIG");
            if (TextUtils.isEmpty(a.o()) == true) goto L5;
            r0.setPackage(a.o());
        L5:
            a.n(this.f6343l).sendBroadcast(r0);
        }
    }

    class d extends com.bytedance.common.utility.m.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ Map f6344k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ a f6345l;

        d(a r1, String r2, Map r3) {
            this.f6345l = r1;
            this.f6344k = r3;
            super(r2);
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            TTNetInit.getTTNetDepend().b(a.n(this.f6345l), this.f6344k);
        }
    }

    static final class e extends BroadcastReceiver {

        /* JADX INFO: renamed from: com.bytedance.ttnet.j.a$e$a, reason: collision with other inner class name */
        class C0199a extends com.bytedance.common.utility.m.c {
            C0199a(e r1, String r2) {
                super(r2);
            }

            @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
            public void run() {
                i.f().a();
            }
        }

        e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            if ("com.bytedance.ttnet.config.appconfig.SYNC_MAIN_PROCESS_CONFIG".equals(r2.getAction()) == false) goto L8;
            new C0199a(this, "SyncMainProcessConfig").b();
            return;
        }
    }

    static {
        ArrayList<String> r0 = new ArrayList();
        O = r0;
        P = false;
        r0.add("MI PAD 2");
        O.add("YT3-X90L");
        O.add("YT3-X90F");
        O.add("GT-810");
        Q = false;
        R = false;
    }

    private a(Context r5, boolean r6) {
        this.f6333g = new AtomicLong(0);
        this.f6334h = new AtomicBoolean(false);
        this.f6335i = new Object();
        this.f6337k = false;
        this.f6338l = -1;
        this.m = 0;
        this.n = new AtomicBoolean(false);
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 1;
        this.s = 1;
        this.t = 1;
        this.u = 1;
        this.v = 1;
        this.w = "";
        this.x = new CopyOnWriteArrayList();
        this.y = new CopyOnWriteArrayList();
        this.A = "";
        this.D = new AtomicInteger(10800);
        this.E = new CopyOnWriteArrayList();
        this.F = new WeakHandler(Looper.getMainLooper(), this);
        this.f6336j = r5;
        this.f6332f = r6;
    }

    private boolean A() {
        if (q() != null) goto L5;
    L26:
        return true;
    L5:
        if (q().length < 1) goto L26;
        String r5 = q()[0];
        if (TextUtils.isEmpty(r5) == false) goto L10;
        return true;
    L10:
        String r6 = "https://" + r5 + "/get_domains/v5/";
        String r3 = d.b.h.a.a.h.g.c(r6, true);
        if (r6.equals(r3) == false) goto L13;
        return true;
    L13:
        LinkedHashMap r7 = new LinkedHashMap();
        l.k(r3, r7);     // Catch: Exception -> L27
        if (r7.containsKey(WsConstants.KEY_DEVICE_ID) == true) goto L17;
        return true;
    L17:
        List r8 = (List) r7.get(WsConstants.KEY_DEVICE_ID);     // Catch: Exception -> L27
        if (r8 != null) goto L20;
        return true;
    L20:
        Iterator r9 = r8.iterator();     // Catch: Exception -> L27
    L22:
        if (r9.hasNext() == false) goto L26;
        if (((String) r9.next()).equals(BDLocationException.ERROR_TIMEOUT) == true) goto L22;
        return false;
    }

    private void C(JSONObject r3, String r4) {
        if (r3 != null) goto L8;
        return;
    L8:
        r3.put("return", r4);     // Catch: JSONException -> L7
        r3.put("CurrentShareCookieHostList", this.x.toString());     // Catch: JSONException -> L7
    L5:
        TTNetInit.getTTNetDepend().d(TTNetInit.getTTNetDepend().getContext(), "handleResponse", "shareCookieHostList", r3);
    }

    private void K(com.bytedance.ttnet.r.c.d r3, boolean r4) {
        if (this.f6332f == false) goto L6;
        p(r3, r4);
        return;
    L6:
        if (this.f6333g.get() > 0) goto L13;
        new C0198a(this, "LoadDomainConfig4Other-Thread").b();     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences m(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    static /* synthetic */ Context n(a r0) {
        return r0.f6336j;
    }

    static /* synthetic */ String o() {
        return H;
    }

    public static a s(Context r4) {
        monitor-enter(a.class);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (G != null) goto L21;
        boolean r1 = d.b.h.a.a.h.s.h.h(r4);     // Catch: Throwable -> L24
        G = new a(r4.getApplicationContext(), r1);     // Catch: Throwable -> L24
        if (O.contains(Build.MODEL) == false) goto L9;
        P = true;     // Catch: Throwable -> L24
    L9:
        H = r4.getPackageName();     // Catch: Throwable -> L24
        if (r1 == false) goto L15;
        d.b.h.b.a.a.e(G);     // Catch: Throwable -> L24
        com.bytedance.frameworks.baselib.network.http.cronet.e.j.P(G);     // Catch: Throwable -> L24
        com.bytedance.frameworks.baselib.network.http.cronet.e.j.O(G);     // Catch: Throwable -> L24
        com.bytedance.frameworks.baselib.network.http.cronet.e.j.R(G);     // Catch: Throwable -> L24
        com.bytedance.ttnet.d.e(G);     // Catch: Throwable -> L24
        d.b.h.a.a.f.b.c().f(G);     // Catch: Throwable -> L24
        d.b.h.a.a.h.g.L(G);     // Catch: Throwable -> L24
        d.b.h.a.a.h.g.J(G);     // Catch: Throwable -> L24
        if (d.b.h.a.a.h.g.k() != null) goto L20;
        d.b.h.a.a.h.g.j r2 = G;     // Catch: Throwable -> L24
    L14:
        d.b.h.a.a.h.g.N(r2);     // Catch: Throwable -> L24
    L20:
        d.b.h.a.a.c r3 = d.b.h.a.a.c.k();     // Catch: Throwable -> L24
        r3.f13235k = System.nanoTime();     // Catch: Throwable -> L24
        com.bytedance.frameworks.baselib.network.http.cronet.e.j.Q(f.b(r4));     // Catch: Throwable -> L24
        d.b.h.a.a.c r5 = d.b.h.a.a.c.k();     // Catch: Throwable -> L24
        r5.f13236l = System.nanoTime();     // Catch: Throwable -> L24
        d.b.h.a.a.h.g.I(G);     // Catch: Throwable -> L24
        com.bytedance.ttnet.j.d.b(r4);     // Catch: Throwable -> L24
        goto L21
    L15:
        IntentFilter r6 = new IntentFilter();     // Catch: Throwable -> L24
        r6.addAction("com.bytedance.ttnet.config.appconfig.SYNC_MAIN_PROCESS_CONFIG");     // Catch: Throwable -> L24
        com.bytedance.ttnet.s.e.i(r4, new e(), r6);     // Catch: Throwable -> L27
    L17:
        i r7 = i.f();     // Catch: Throwable -> L24
        d.b.h.b.a.a.e(r7);     // Catch: Throwable -> L24
        com.bytedance.frameworks.baselib.network.http.cronet.e.j.P(r7);     // Catch: Throwable -> L24
        com.bytedance.frameworks.baselib.network.http.cronet.e.j.O(r7);     // Catch: Throwable -> L24
        com.bytedance.ttnet.d.e(r7);     // Catch: Throwable -> L24
        if (d.b.h.a.a.h.g.k() != null) goto L20;
        r2 = r7;
    L21:
        a r8 = G;     // Catch: Throwable -> L24
        monitor-exit(a.class);     // Catch: Throwable -> L24
        return r8;
    }

    public static String t() {
        return "ss_app_config";
    }

    public static boolean y() {
        if (com.bytedance.ttnet.j.c.f() == false) goto L25;
        return z();
    L25:
        if (Build.VERSION.SDK_INT >= 21) goto L10;
        String r1 = Build.CPU_ABI;     // Catch: Throwable -> L24
    L12:
        if (TextUtils.isEmpty(r1) == false) goto L15;
        return false;
    L15:
        if ("x86".equalsIgnoreCase(r1) == true) goto L19;
        if ("x86_64".equalsIgnoreCase(r1) == true) goto L19;
        return false;
    L19:
        if (com.bytedance.ttnet.l.a.e() == false) goto L21;
        return false;
    L21:
        s.v(2);     // Catch: Throwable -> L24
        return true;
    L10:
        r1 = Build.SUPPORTED_ABIS[0];     // Catch: Throwable -> L24
    L28:
        return false;
    }

    private static boolean z() {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        String[] r0 = Build.SUPPORTED_ABIS;
        int r4 = r0.length;
        int r5 = 0;
    L10:
        if (r5 >= r4) goto L15;
        if (r0[r5].contains("arm") == true) goto L13;
        r5 = r5 + 1;
    L13:
        boolean r1 = true;
    L16:
        int r2 = 2;
        if (r1 == false) goto L22;
        if (s.l() != 2) goto L26;
        r2 = -1;
    L24:
        s.v(r2);
    L26:
        if (Logger.debug() == false) goto L29;
        StringBuilder r3 = new StringBuilder();
        r3.append("use isCronetUnsupportedABIv2, result is ");
        r3.append(!r1);
        Logger.d("AppConfig", r3.toString());
    L29:
        return !r1;
    L22:
        if (com.bytedance.ttnet.l.a.e() == false) goto L24;
        return false;
    L15:
        r1 = false;
        goto L16
    L5:
        if (Build.CPU_ABI.contains("arm") == true) goto L13;
        if (Build.CPU_ABI2.contains("arm") == false) goto L15;
        goto L15
    }

    public void B() {
        SharedPreferences r0 = m(this.f6336j, "ss_app_config", 0);
        if (this.f6338l >= 0) goto L5;
        this.f6338l = r0.getInt("chromium_boot_failures", 0);
    L5:
        Logger.debug();
        this.m = r0.getLong("chromium_boot_failures_timestamp", 0);
        if (this.f6338l > 5) goto L8;
        return;
    L8:
        if ((System.currentTimeMillis() - this.m) <= TimeUnit.HOURS.toMillis(1)) goto L12;
        this.f6338l = 5;
        return;
    }

    public void D() {
        Logger.debug();     // Catch: Throwable -> L8
        if (this.f6338l != 0) goto L6;
        return;
    L6:
        this.f6338l = 0;     // Catch: Throwable -> L8
        SharedPreferences.Editor r2 = m(this.f6336j, "ss_app_config", 0).edit();     // Catch: Throwable -> L8
        r2.putInt("chromium_boot_failures", 0);     // Catch: Throwable -> L8
        com.bytedance.common.utility.o.a.a(r2);     // Catch: Throwable -> L8
        LinkedHashMap r3 = new LinkedHashMap();     // Catch: Throwable -> L8
        r3.put("chromium_boot_failures", 0);     // Catch: Throwable -> L8
        TTNetInit.getTTNetDepend().b(this.f6336j, r3);     // Catch: Throwable -> L8
        return;
    }

    public void E(String r2) {
        this.B = d.b.h.a.a.h.b.b(r2);
        com.bytedance.ttnet.r.c.l().n().k(r2);
    }

    public void F(String r1) {
        this.A = r1;
    }

    synchronized void G() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if ((System.currentTimeMillis() - this.f6333g.get()) <= (((long) this.D.get()) * 1000)) goto L12;
        this.f6333g.set(System.currentTimeMillis());     // Catch: Throwable -> L14
        int r0 = TTNetInit.getTTNetDepend().i(this.f6336j, "disable_framed_transport", 0);     // Catch: Exception -> L18 Throwable -> L14
        if (r0 <= 0) goto L10;
        d.b.h.a.a.h.o.b.i.c(r0);     // Catch: Throwable -> L17
    L10:
        if (com.bytedance.ttnet.r.c.l().n() == null) goto L12;
        com.bytedance.ttnet.r.c.l().n().h(this.f6333g.get());     // Catch: Exception -> L18 Throwable -> L14
    L12:
        monitor-exit(this);
    }

    public void H() {
        Object r0 = this.f6335i;
        monitor-enter(r0);
    L73:
        th = move-exception;
        throw th;
    L5:
        if (this.f6337k == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L73
        return;
    L8:
        boolean r1 = true;
        this.f6337k = true;     // Catch: Throwable -> L73
        monitor-exit(r0);     // Catch: Throwable -> L73
        SharedPreferences r2 = m(this.f6336j, "ss_app_config", 0);
        r2.getInt("ok_http_open", 0);
        r2.getInt("ok_http3_open", 0);
        r2.getInt("cronet_version", 0);
        this.o = r2.getInt("http_dns_enabled", 0);
        r2.getInt("detect_open", 0);
        r2.getInt("detect_native_page", 1);
        r2.getInt("collect_recent_page_info_enable", 1);
        this.p = r2.getInt("add_ss_queries_open", 0);
        this.q = r2.getInt("add_ss_queries_header_open", 0);
        this.r = r2.getInt("add_ss_queries_plaintext_open", 1);
        r2.getInt("add_device_fingerprint_open", 1);
        this.v = r2.getInt("dynamic_adjust_threadpool_size_open", 1);
        if (this.f6338l >= 0) goto L14;
        this.f6338l = r2.getInt("chromium_boot_failures", 0);
    L14:
        if (this.v <= 0) goto L16;
        boolean r3 = true;
    L17:
        d.b.h.a.a.g.g.e(r3);
        this.s = r2.getInt("image_ttnet_enabled", 1);
        this.t = r2.getInt("sample_band_width_enabled", 1);
        this.u = r2.getInt("cdn_sample_band_width_enabled", 1);
        f6331J = r2.getInt("use_http_dns", -1);
        K = r2.getInt("use_http_dns_refetch_on_expire", -1);
        d.b.h.a.a.h.p.f.d(r2);
        com.bytedance.frameworks.baselib.network.http.cronet.e.j.d0(null, r2);
        com.bytedance.ttnet.s.a.d(r2);
        if (this.p <= 0) goto L20;
    L21:
        com.bytedance.ttnet.q.a.e(true);
    L22:
        I = r2.getString(WsConstants.KEY_FRONTIER_URLS, "");
        this.w = r2.getString("cronet_so_path", "");
        String r5 = r2.getString("api_http_host_list", "");
        if (com.bytedance.common.utility.k.c(r5) == true) goto L30;
        String[] r6 = r5.split(",");
        int r7 = r6.length;
        int r8 = 0;
    L25:
        if (r8 >= r7) goto L30;
        String r9 = r6[r8];
        if (com.bytedance.common.utility.k.c(r9) == true) goto L29;
        this.y.add(r9.trim());
    L29:
        r8 = r8 + 1;
    L30:
        com.bytedance.frameworks.baselib.network.http.cronet.e.g.d().i(r2.getString("concurrent_request_config", ""));
        String r10 = r2.getString("add_common_params", "");
        d.b.h.a.a.h.k.a r11 = d.b.h.a.a.h.k.b.b().a();
        if (r11 != null) goto L71;
        d.b.h.a.a.j.d.f().k(r2.getString("L0_params", ""));
        int r4 = r2.getInt("query_filter_enabled", Integer.MIN_VALUE);
        String r12 = r2.getString("query_filter_actions", "");
        if (r4 == Integer.MIN_VALUE) goto L39;
        d.b.h.a.a.j.d r13 = d.b.h.a.a.j.d.f();
        if (r4 <= 0) goto L37;
        boolean r14 = true;
    L38:
        r13.d(r14);
        d.b.h.a.a.j.d.f().g(r12);
        goto L39
    L37:
        r14 = false;
    L39:
        String r15 = r2.getString("share_cookie_host_list", "");
        com.bytedance.ttnet.s.e.g(r15, this.x);
        String r16 = TTNetInit.getTTNetDepend().k();
        if (com.bytedance.common.utility.k.c(r16) == true) goto L45;
        if (com.bytedance.ttnet.s.e.d(r16, this.x) == true) goto L45;
        this.x.add(r16);
    L45:
        if (r2.getInt("private_protocol_enabled", 1) < 1) goto L47;
        boolean r17 = true;
    L48:
        d.b.h.a.a.h.g.S(r17);
        int r18 = r2.getInt("destroy_delta_millis", 100);
        if (r18 < 0) goto L52;
        d.b.h.a.a.h.g.P(r18);
    L52:
        if (r2.getInt("disable_rotating_host_path_retry", -1) >= 1) goto L55;
        r1 = false;
    L55:
        d.b.h.a.a.h.g.Q(r1);
        this.D.set(r2.getInt("tnc_update_interval", 10800));
        String r19 = r2.getString("send_tnc_host_arrays", "");
        if (TextUtils.isEmpty(r19) == true) goto L58;
        String[] r20 = r19.split(",");
        this.E.clear();
        this.E.addAll(Arrays.asList(r20));
    L58:
        this.C = r2.getString("tnc_summary", "");
        if (com.bytedance.ttnet.r.c.l().n() == null) goto L61;
        com.bytedance.ttnet.r.c.l().n().g(this.f6333g.get());
    L61:
        int r21 = r2.getInt("disable_framed_transport", 0);
        if (r21 <= 0) goto L65;
        d.b.h.a.a.h.o.b.i.c(r21);     // Catch: Throwable -> L76
    L65:
        if (this.f6332f == false) goto L86;
        LinkedHashMap r22 = new LinkedHashMap();     // Catch: Throwable -> L77
        if (com.bytedance.common.utility.k.c(I) == true) goto L69;
        r22.put(WsConstants.KEY_FRONTIER_URLS, I);     // Catch: Throwable -> L77
    L69:
        r22.put("http_dns_enabled", Integer.valueOf(this.o));     // Catch: Throwable -> L77
        r22.put("add_ss_queries_open", Integer.valueOf(this.p));     // Catch: Throwable -> L77
        r22.put("add_ss_queries_header_open", Integer.valueOf(this.q));     // Catch: Throwable -> L77
        r22.put("add_ss_queries_plaintext_open", Integer.valueOf(this.r));     // Catch: Throwable -> L77
        r22.put("chromium_boot_failures", Integer.valueOf(this.f6338l));     // Catch: Throwable -> L77
        r22.put("share_cookie_host_list", r15);     // Catch: Throwable -> L77
        r22.put("disable_framed_transport", Integer.valueOf(r21));     // Catch: Throwable -> L77
        new c(this, "SaveMapToProvider-Thread", r22).b();     // Catch: Throwable -> L77
        return;
    L87:
        return;
    L86:
        return;
    L47:
        r17 = false;
        goto L48
    L71:
        r11.b(r10);
        throw null;
    L20:
        if (this.q <= 0) goto L22;
    L16:
        r3 = false;
        goto L17
    }

    public void I(com.bytedance.ttnet.r.c.d r2) {
        J(r2, false);
    }

    public void J(com.bytedance.ttnet.r.c.d r1, boolean r2) {
        K(r1, r2);
    }

    void L(com.bytedance.ttnet.r.c.d r6, boolean r7) {
        Logger.debug();
        if (com.bytedance.common.utility.i.o(this.f6336j) == true) goto L5;
        return;
    L5:
        H();
        if (i() == true) goto L8;
    L11:
        if (r7 == true) goto L13;
    L16:
        int r8 = 102;
        if (com.bytedance.ttnet.r.c.l().i(this.f6336j, true, r6, this.C) == false) goto L20;
    L18:
        r8 = 101;
    L22:
        this.F.sendEmptyMessage(r8);
        this.F.removeMessages(103);
        this.F.sendEmptyMessageDelayed(103, ((long) this.D.get()) * 1000);
        return;
    L20:
        if (com.bytedance.ttnet.r.c.l().i(this.f6336j, false, com.bytedance.ttnet.r.c.d.n, this.C) == false) goto L22;
    L13:
        if (A() == false) goto L16;
        Logger.debug();
        this.F.sendEmptyMessageDelayed(104, CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        this.f6334h.set(false);
        return;
    L8:
        if (r6 == com.bytedance.ttnet.r.c.d.q) goto L11;
        this.f6334h.set(false);
    }

    @Override // d.b.h.a.a.h.g.i
    public boolean a(String r3) {
        if (com.bytedance.common.utility.k.c(r3) == false) goto L6;
        return false;
    L6:
        if (this.t > 0) goto L20;
        return false;
    L20:
        URI r2 = d.b.h.a.a.h.s.j.b(r3);     // Catch: Throwable -> L19
        if (r2 != null) goto L11;
        return false;
    L11:
        String r4 = r2.getHost();     // Catch: Throwable -> L19
        if (com.bytedance.common.utility.k.c(r4) == false) goto L14;
        return false;
    L14:
        if (r4.endsWith(com.bytedance.ttnet.c.a()) == false) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // d.b.h.a.a.h.g.e
    public void b(String r3, String r4, boolean r5) {
        if (this.y.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<String> r2 = this.y.iterator();
    L7:
        if (r2.hasNext() == false) goto L29;
        String r0 = r2.next();
        if (com.bytedance.common.utility.k.c(r0) == true) goto L7;
        if (r3.endsWith(r0) == false) goto L7;
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L20
        r6.put(WsConstants.KEY_CONNECTION_URL, r3 + r4);     // Catch: Throwable -> L20
        r6.put("replace", r5);     // Catch: Throwable -> L20
        TTNetInit.monitorLogSend("api_http", r6);     // Catch: Throwable -> L20
    L14:
        if (TTNetInit.apiHttpInterceptEnabled() == false) goto L19;
        if (r5 == false) goto L18;
        return;
    L18:
        throw new d.b.h.a.a.h.l.f("Api http request is not allowed to be executed");
    L19:
        return;
    }

    @Override // d.b.h.b.a.a.InterfaceC0365a
    public boolean c() {
        if (R == false) goto L6;
        return false;
    L6:
        if (this.q <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // d.b.h.b.a.a.InterfaceC0365a
    public boolean d() {
        if (R == false) goto L6;
        return true;
    L6:
        if (this.r > 0) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // d.b.h.a.a.h.g.j
    public List<String> e(CookieManager r4, d.b.h.a.a.h.m.c r5, URI r6) {
        if (r6 == null) goto L36;
        if (r4 != null) goto L39;
        if (r5 == null) goto L36;
    L39:
        String r1 = r6.getHost();     // Catch: Exception -> L9
    L11:
        if (com.bytedance.common.utility.k.c(r1) == true) goto L36;
        if (com.bytedance.ttnet.s.e.d(r1, this.x) == false) goto L36;
        if (com.bytedance.common.utility.k.c(TTNetInit.getTTNetDepend().k()) == false) goto L18;
        return null;
    L18:
        ArrayList r3 = new ArrayList();
        if (r4 == null) goto L25;
        String r7 = r4.getCookie(r6.getScheme() + "://" + TTNetInit.getTTNetDepend().k());
        if (com.bytedance.common.utility.k.c(r7) == true) goto L25;
        r3.add(r7);
        return r3;
    L25:
        if (com.bytedance.common.utility.e.a(r3) == false) goto L45;
        if (r5 == null) goto L46;
        Map<String, List<String>> r8 = r5.get(URI.create(r6.getScheme() + "://" + TTNetInit.getTTNetDepend().k()), new LinkedHashMap());     // Catch: Throwable -> L38
        if (r8 != null) goto L30;
        return r3;
    L30:
        if (r8.isEmpty() == true) goto L48;
        List<String> r9 = r8.get("Cookie");     // Catch: Throwable -> L38
        if (r9 == null) goto L35;
        r9.add("x-tt-cookie-backup-source=1");     // Catch: Throwable -> L37
    L35:
        return r9;
    L48:
        return r3;
    L49:
        return r3;
    L46:
        return r3;
    L45:
        return r3;
    L9:
        r1 = null;
    L36:
        return null;
    }

    @Override // d.b.h.a.a.h.g.e
    @Deprecated
    public String f(String r1, d.b.h.a.a.h.c r2) {
        if (com.bytedance.common.utility.k.c(r1) == false) goto L12;
        return r1;
    L12:
        if (this.f6332f == false) goto L8;
        H();     // Catch: Throwable -> L10
    L11:
        goto L9
    L8:
        G();     // Catch: Throwable -> L10
    L9:
        return r1;
    }

    @Override // d.b.h.a.a.h.g.j
    public List<String> g(String r2) {
        if (com.bytedance.ttnet.s.e.d(r2, this.x) == true) goto L5;
        return null;
    L5:
        return this.x;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.e.j.b
    public boolean h() {
        if (Q == false) goto L6;
        return false;
    L6:
        if (this.o <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public void handleConfigUpdate(String r1) {
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r4) {
        switch(r4.what) {
            case 101: goto L8;
            case 102: goto L9;
            case 103: goto L6;
            case 104: goto L5;
            default: goto L12;
        };
    L5:
        Logger.debug();
        com.bytedance.ttnet.r.c.d r5 = com.bytedance.ttnet.r.c.d.f6605j;
    L7:
        I(r5);
        return;
    L6:
        Logger.debug();
        r5 = com.bytedance.ttnet.r.c.d.f6607l;
        goto L7
    L8:
        this.f6333g.set(System.currentTimeMillis());
    L9:
        Logger.debug();
        this.f6334h.set(false);
        return;
    }

    @Override // com.bytedance.ttnet.d.c
    public boolean i() {
        if (M == false) goto L8;
        if (this.n.compareAndSet(false, true) == false) goto L8;
        B();
    L8:
        if (N == false) goto L12;
        s.v(0);
        return false;
    L12:
        if (P == false) goto L17;
        int r3 = 8;
    L14:
        s.v(r3);
        return false;
    L17:
        if (y() == false) goto L20;
        return false;
    L20:
        if (L == true) goto L25;
        if (this.f6338l <= 5) goto L25;
        r3 = 3;
    L25:
        if (TTNetInit.getTTNetDepend().g() == true) goto L27;
        r3 = 6;
        goto L14
    L27:
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.e.j.a
    public boolean isCronetBootFailureExpected() {
        Logger.debug();
        boolean r2 = false;
        SharedPreferences r0 = m(this.f6336j, "ss_app_config", 0);
        if (M == true) goto L13;
        if (this.f6338l >= 0) goto L7;
        this.f6338l = r0.getInt("chromium_boot_failures", 0);
    L7:
        this.m = r0.getLong("chromium_boot_failures_timestamp", 0);
        if (this.f6338l <= 5) goto L13;
        if ((System.currentTimeMillis() - this.m) <= TimeUnit.HOURS.toMillis(1)) goto L13;
        this.f6338l = 5;
    L13:
        if (i() == false) goto L18;
        SharedPreferences.Editor r1 = r0.edit();
        r2 = true;
        r1.putInt("chromium_boot_failures", this.f6338l + 1);
        r1.putLong("chromium_boot_failures_timestamp", System.currentTimeMillis());
        Logger.debug();
        com.bytedance.common.utility.o.a.a(r1);
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("chromium_boot_failures", Integer.valueOf(this.f6338l + 1));
        if (TTNetInit.getCronetProvider().getOptInit() == false) goto L17;
        new d(this, "SaveMapToProvider-Thread", r3).b();
        goto L18
    L17:
        TTNetInit.getTTNetDepend().b(this.f6336j, r3);
    L18:
        return r2;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.e.j.d
    public JSONObject j() {
        return this.B;
    }

    @Override // d.b.h.b.a.a.InterfaceC0365a
    public boolean k() {
        if (R == false) goto L6;
        return true;
    L6:
        if (this.p > 0) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // d.b.h.a.a.f.b.InterfaceC0356b
    public void l(d.b.h.a.a.f.c r1) {
        Logger.debug();
    }

    public boolean p(com.bytedance.ttnet.r.c.d r4, boolean r5) {
        Logger.debug();
        if (this.f6334h.compareAndSet(false, true) == false) goto L5;
    L8:
        new b(this, "AppConfigThread", r4, r5).b();
        return true;
    L5:
        if (r4 == com.bytedance.ttnet.r.c.d.q) goto L8;
        Logger.debug();
        return false;
    }

    public String[] q() {
        String[] r1 = TTNetInit.getTTNetDepend().f();
        if (r1 == null) goto L7;
        if (r1.length <= 0) goto L7;
        return r1;
    L7:
        return new String[0];
    }

    public String r() {
        return this.w;
    }

    public List<String> u() {
        return this.E;
    }

    public String v() {
        return this.C;
    }

    public void w(String r8, Object r9) {
        if (com.bytedance.ttnet.j.e.c(r9) == true) goto L21;
        return;
    L21:
        boolean r10 = x(r9, com.bytedance.ttnet.r.c.d.p, System.currentTimeMillis(), false);     // Catch: Exception -> L7
    L8:
        int r0 = 102;
        if (r10 == false) goto L17;
        r0 = 101;
    L17:
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L15
        r11.put(TypedValues.TransitionType.S_FROM, "cronet");     // Catch: Throwable -> L15
        TTNetInit.getTTNetDepend().a(this.f6336j, r11);     // Catch: Throwable -> L15
    L19:
        handleConfigUpdate(r8);     // Catch: Throwable -> L16
    L13:
        this.F.sendEmptyMessage(r0);
        return;
    L7:
        r10 = false;
        goto L8
    }

    public boolean x(Object r38, com.bytedance.ttnet.r.c.d r39, long r40, boolean r42) {
        JSONObject r9 = new JSONObject();
        if ((r38 instanceof String) == false) goto L11;
        String r2 = (String) r38;
        if (com.bytedance.common.utility.k.c(r2) == false) goto L9;
        String r0 = "empty response.";
    L7:
        C(r9, r0);
        return false;
    L9:
        JSONObject r5 = new JSONObject(r2);
    L17:
        if (r5 != null) goto L19;
        r0 = "object is null.";
        goto L7
    L19:
        this.C = r5.optString("summary");
        JSONObject r11 = r5.getJSONObject("data");
        f6331J = r11.optInt("use_http_dns", -1);
        K = r11.optInt("collect_recent_page_info_enable", -1);
        int r3 = r11.optInt("ok_http_open", 0);
        int r6 = r11.optInt("ok_http3_open", 0);
        int r7 = r11.optInt("cronet_version", 0);
        int r8 = r11.optInt("http_dns_enabled", 0);
        int r10 = r11.optInt("detect_open", 0);
        int r12 = r11.optInt("detect_native_page", 1);
        int r13 = r11.optInt("collect_recent_page_info_enable", 1);
        int r14 = r11.optInt("add_ss_queries_open", 0);
        int r4 = r11.optInt("add_ss_queries_header_open", 0);
        int r15 = r11.optInt("add_ss_queries_plaintext_open", 1);
        int r16 = r11.optInt("add_device_fingerprint_open", 1);
        int r17 = r11.optInt("image_ttnet_enabled", 1);
        int r18 = r11.optInt("sample_band_width_enabled", 1);
        int r19 = r11.optInt("cdn_sample_band_width_enabled", 1);
        int r110 = r11.optInt("dynamic_adjust_threadpool_size_open", 1);
        int r111 = r11.optInt("http_show_hijack", 1);
        int r112 = r11.optInt("http_verify_sign", 1);
        int r113 = r11.optInt("tnc_update_interval", -1);
        if (r113 <= 0) goto L22;
        this.D.set(r113);
    L22:
        int r114 = r11.optInt("private_protocol_enabled", 1);
        if (r114 < 1) goto L25;
        boolean r115 = true;
    L26:
        d.b.h.a.a.h.g.S(r115);
        int r116 = r11.optInt("destroy_delta_millis", 100);
        if (r116 < 0) goto L29;
        d.b.h.a.a.h.g.P(r116);
    L29:
        int r117 = r11.optInt("disable_rotating_host_path_retry", -1);
        if (r117 < 1) goto L32;
        boolean r118 = true;
    L33:
        d.b.h.a.a.h.g.Q(r118);
        JSONArray r119 = r11.optJSONArray("send_tnc_host_arrays");
        if (r119 == null) goto L44;
        this.E.clear();
        int r120 = 0;
    L37:
        if (r120 >= r119.length()) goto L43;
        if (TextUtils.isEmpty(r119.optString(r120)) == true) goto L42;
        this.E.add(r119.optString(r120));
    L42:
        r120 = r120 + 1;
        r6 = r6;
        goto L37
    L43:
        int r28 = r6;
    L45:
        int r20 = r11.optInt("crash_limit_times", 0);
        int r21 = r11.optInt("crash_detect_interval_ms", 5000);
        monitor-enter(this);
        this.o = r8;     // Catch: Throwable -> L150
        this.p = r14;     // Catch: Throwable -> L150
        this.q = r4;     // Catch: Throwable -> L150
        this.r = r15;     // Catch: Throwable -> L150
        this.v = r110;     // Catch: Throwable -> L150
        this.s = r17;     // Catch: Throwable -> L150
        this.t = r18;     // Catch: Throwable -> L150
        this.u = r19;     // Catch: Throwable -> L150
        monitor-exit(this);     // Catch: Throwable -> L150
        if (r110 <= 0) goto L51;
        boolean r22 = true;
    L52:
        d.b.h.a.a.g.g.e(r22);
        if (r11.optInt("enable_req_ticket", 1) <= 0) goto L55;
        boolean r23 = true;
    L56:
        com.bytedance.ttnet.s.c.e(r23);
        com.bytedance.ttnet.s.a.C0203a r24 = com.bytedance.ttnet.s.a.e(r11);
        if (this.p <= 0) goto L59;
    L62:
        com.bytedance.ttnet.q.a.e(true);
    L63:
        d.b.h.a.a.h.p.f.f(r11);
        com.bytedance.frameworks.baselib.network.http.cronet.e.j.d0(r11, null);
        String r121 = r11.optString(WsConstants.KEY_FRONTIER_URLS, "");
        String r122 = r11.optString("share_cookie_host_list", "");
        TTNetInit.getTTNetDepend().e(r122);
        String r123 = r11.optString("api_http_host_list", "");
        String r124 = r11.optString("concurrent_request_config", "");
        com.bytedance.frameworks.baselib.network.http.cronet.e.g.d().i(r124);
        String r125 = r11.optString("add_common_params", "");
        d.b.h.a.a.h.k.a r126 = d.b.h.a.a.h.k.b.b().a();
        if (r126 != null) goto L146;
        String r127 = r11.optString("L0_params", "");
        d.b.h.a.a.j.d.f().k(r127);
        int r128 = r11.optInt("query_filter_enabled", Integer.MIN_VALUE);
        String r129 = com.bytedance.ttnet.j.e.e(r38, r11, new String[]{"data", "query_filter_actions"});
        if (r128 == Integer.MIN_VALUE) goto L72;
        d.b.h.a.a.j.d r130 = d.b.h.a.a.j.d.f();
        if (r128 <= 0) goto L70;
        boolean r1 = true;
    L71:
        r130.d(r1);
        d.b.h.a.a.j.d.f().g(r129);
        goto L72
    L70:
        r1 = false;
    L72:
        this.z = r11.optInt("disable_encrypt_switch", 0);
        this.w = r11.optString("cronet_so_path", "");
        if (this.z != 2) goto L75;
        int r131 = 0;
        SharedPreferences.Editor r25 = m(this.f6336j, "app_log_encrypt_switch_count", 0).edit();
        r25.putInt("app_log_encrypt_faild_count", 0);
        com.bytedance.common.utility.o.a.a(r25);
    L76:
        int r26 = r11.optInt("disable_framed_transport", r131);
        if (r26 > 0) goto L154;
    L79:
        monitor-enter(this);
        SharedPreferences r132 = m(this.f6336j, "ss_app_config", 0);     // Catch: Throwable -> L143
        String r133 = r132.getString("share_cookie_host_list", "");     // Catch: Throwable -> L143
        SharedPreferences.Editor r134 = r132.edit();     // Catch: Throwable -> L143
        r134.putString("ttnet_response_verify", r24.f6615b);     // Catch: Throwable -> L143
        r134.putInt("ttnet_response_verify_enabled", r24.f6614a);     // Catch: Throwable -> L143
        d.b.h.a.a.h.p.f.e(r134);     // Catch: Throwable -> L143
        com.bytedance.frameworks.baselib.network.http.cronet.e.j.D(r134);     // Catch: Throwable -> L143
        r134.putInt("ok_http_open", r3);     // Catch: Throwable -> L143
        r134.putInt("ok_http3_open", r28);     // Catch: Throwable -> L143
        r134.putInt("cronet_version", r7);     // Catch: Throwable -> L143
        r134.putInt("http_dns_enabled", r8);     // Catch: Throwable -> L143
        r134.putInt("detect_open", r10);     // Catch: Throwable -> L143
        r134.putInt("detect_native_page", r12);     // Catch: Throwable -> L143
        r134.putInt("collect_recent_page_info_enable", r13);     // Catch: Throwable -> L143
        r134.putInt("add_ss_queries_open", r14);     // Catch: Throwable -> L143
        r134.putInt("add_ss_queries_header_open", r4);     // Catch: Throwable -> L143
        r134.putInt("add_ss_queries_plaintext_open", r15);     // Catch: Throwable -> L143
        r134.putInt("add_device_fingerprint_open", r16);     // Catch: Throwable -> L143
        r134.putInt("dynamic_adjust_threadpool_size_open", r110);     // Catch: Throwable -> L143
        r134.putInt("image_ttnet_enabled", r17);     // Catch: Throwable -> L143
        r134.putInt("use_http_dns", f6331J);     // Catch: Throwable -> L143
        r134.putInt("use_http_dns_refetch_on_expire", K);     // Catch: Throwable -> L143
        r134.putInt("http_show_hijack", r111);     // Catch: Throwable -> L143
        r134.putInt("http_verify_sign", r112);     // Catch: Throwable -> L143
        r134.putInt("crash_limit_times", r20);     // Catch: Throwable -> L143
        r134.putInt("crash_detect_interval_ms", r21);     // Catch: Throwable -> L143
        r134.putString(WsConstants.KEY_FRONTIER_URLS, r121);     // Catch: Throwable -> L143
        r134.putString("cronet_so_path", this.w);     // Catch: Throwable -> L143
        r134.putString("share_cookie_host_list", r122);     // Catch: Throwable -> L143
        r9.put("oldShareCookieHosts", r133);     // Catch: Throwable -> L143
        r9.put("newShareCookieHosts", r122);     // Catch: Throwable -> L143
        if (TextUtils.isEmpty(r122) == true) goto L83;
        this.x.clear();     // Catch: Throwable -> L143
        com.bytedance.ttnet.s.e.g(r122, this.x);     // Catch: Throwable -> L143
    L83:
        String r27 = TTNetInit.getTTNetDepend().k();     // Catch: Throwable -> L143
        if (com.bytedance.common.utility.k.c(r27) == false) goto L86;
    L88:
        r134.putString("api_http_host_list", r123);     // Catch: Throwable -> L143
        r134.putString("concurrent_request_config", r124);     // Catch: Throwable -> L143
        r134.putString("add_common_params", r125);     // Catch: Throwable -> L143
        r134.putString("query_filter_actions", r129);     // Catch: Throwable -> L143
        r134.putString("L0_params", r127);     // Catch: Throwable -> L143
        r134.putInt("query_filter_enabled", r128);     // Catch: Throwable -> L143
        String[] r29 = r123.split(",");     // Catch: Throwable -> L143
        int r30 = r29.length;     // Catch: Throwable -> L143
        int r135 = 0;
    L89:
        if (r135 >= r30) goto L97;
        int r136 = r30;
        String r31 = r29[r135];     // Catch: Throwable -> L143
        if (com.bytedance.common.utility.k.c(r31) == true) goto L95;
        String[] r137 = r29;
        if (com.bytedance.ttnet.s.e.d(r31, this.y) == true) goto L96;
        String r32 = r31.trim();     // Catch: Throwable -> L143
        this.y.add(r32);     // Catch: Throwable -> L143
    L96:
        r135 = r135 + 1;     // Catch: Throwable -> L143
        r30 = r136;
        r29 = r137;
        goto L89
    L95:
        r137 = r29;
        goto L96
    L97:
        r134.putInt("android_log_encrypt_switch", this.z);     // Catch: Throwable -> L143
        r134.putInt("image_ttnet_enabled", this.s);     // Catch: Throwable -> L143
        r134.putInt("sample_band_width_enabled", this.t);     // Catch: Throwable -> L143
        r134.putInt("cdn_sample_band_width_enabled", this.u);     // Catch: Throwable -> L143
        r134.putInt("disable_framed_transport", r26);     // Catch: Throwable -> L143
        r134.putInt("tnc_update_interval", this.D.get());     // Catch: Throwable -> L143
        r134.putInt("private_protocol_enabled", r114);     // Catch: Throwable -> L143
        r134.putInt("destroy_delta_millis", r116);     // Catch: Throwable -> L143
        r134.putInt("disable_rotating_host_path_retry", r117);     // Catch: Throwable -> L143
        StringBuilder r33 = new StringBuilder();     // Catch: Throwable -> L143
        int r138 = 0;
    L99:
        if (r138 >= this.E.size()) goto L104;
        r33.append(this.E.get(r138));     // Catch: Throwable -> L143
        if (r138 == this.E.size()) goto L103;
        r33.append(',');     // Catch: Throwable -> L143
    L103:
        r138 = r138 + 1;     // Catch: Throwable -> L143
        goto L99
    L104:
        String r34 = r33.toString();     // Catch: Throwable -> L143
        if (TextUtils.isEmpty(r34) == true) goto L108;
        r134.putString("send_tnc_host_arrays", r34);     // Catch: Throwable -> L143
    L108:
        if (TextUtils.isEmpty(this.C) == true) goto L110;
        r134.putString("tnc_summary", this.C);     // Catch: Throwable -> L143
    L110:
        com.bytedance.common.utility.o.a.a(r134);     // Catch: Throwable -> L143
        LinkedHashMap r35 = new LinkedHashMap();     // Catch: Throwable -> L153
        if (com.bytedance.common.utility.k.c(r121) == false) goto L114;
    L116:
        r35.put("http_dns_enabled", Integer.valueOf(r8));     // Catch: Throwable -> L153
        r35.put("add_ss_queries_open", Integer.valueOf(r14));     // Catch: Throwable -> L153
        r35.put("add_ss_queries_header_open", Integer.valueOf(r4));     // Catch: Throwable -> L153
        r35.put("add_ss_queries_plaintext_open", Integer.valueOf(r15));     // Catch: Throwable -> L153
        r35.put("share_cookie_host_list", r122);     // Catch: Throwable -> L153
        r35.put("disable_framed_transport", Integer.valueOf(r26));     // Catch: Throwable -> L153
        r35.put("query_filter_actions", r129);     // Catch: Throwable -> L153
        r35.put("L0_params", r127);     // Catch: Throwable -> L153
        r35.put("query_filter_enabled", Integer.valueOf(r128));     // Catch: Throwable -> L153
        r35.put("private_protocol_enabled", Integer.valueOf(r114));     // Catch: Throwable -> L153
        r35.put("disable_rotating_host_path_retry", Integer.valueOf(r117));     // Catch: Throwable -> L153
        TTNetInit.getTTNetDepend().b(this.f6336j, r35);     // Catch: Throwable -> L153
        Intent r36 = new Intent("com.bytedance.ttnet.config.appconfig.SYNC_MAIN_PROCESS_CONFIG");     // Catch: Throwable -> L153
        if (TextUtils.isEmpty(H) == true) goto L119;
        r36.setPackage(H);     // Catch: Throwable -> L153
    L119:
        this.f6336j.sendBroadcast(r36);     // Catch: Throwable -> L153
        goto L120
    L114:
        if (r121.equals(I) == true) goto L116;
        I = r121;     // Catch: Throwable -> L153
        r35.put(WsConstants.KEY_FRONTIER_URLS, r121);     // Catch: Throwable -> L153
    L120:
        monitor-exit(this);     // Catch: Throwable -> L143
        if (com.bytedance.common.utility.k.c(r122) == true) goto L125;
        h.c().d(r133, r122);
    L125:
        if (com.bytedance.ttnet.j.d.c() == null) goto L127;
        JSONObject r37 = r11;
        com.bytedance.ttnet.j.d.c().f(r37);
    L129:
        if (com.bytedance.ttnet.r.c.l().n() != null) goto L131;
        boolean r41 = true;
    L141:
        C(r9, "return true");
        return r41;
    L131:
        if (com.bytedance.ttnet.j.e.b() == true) goto L133;
    L137:
        JSONObject r139 = r37;
        r41 = true;
        com.bytedance.ttnet.r.c.l().n().e(r139, r39, this.A, "", r40);
    L138:
        if (r42 == false) goto L141;
        d.b.h.a.a.h.r.b.n().s();
        goto L141
    L133:
        if ((r38 instanceof com.bytedance.ttnet.j.e.b) == false) goto L137;
        if (com.bytedance.ttnet.j.c.e() == false) goto L137;
        com.bytedance.ttnet.r.c.l().n().e(r38, r39, this.A, "", r40);
        r41 = true;
        goto L138
    L127:
        r37 = r11;
        goto L129
    L86:
        if (com.bytedance.ttnet.s.e.d(r27, this.x) == true) goto L88;
        this.x.add(r27);     // Catch: Throwable -> L143
    L143:
        th = move-exception;
        throw th;
    L154:
        d.b.h.a.a.h.o.b.i.c(r26);     // Catch: Throwable -> L152
        goto L79
    L75:
        r131 = 0;
        goto L76
    L146:
        r126.b(r125);
        throw null;
    L59:
        if (this.q <= 0) goto L63;
    L55:
        r23 = false;
        goto L56
    L51:
        r22 = false;
    L150:
        th = move-exception;
        throw th;
    L44:
        r28 = r6;
        goto L45
    L32:
        r118 = false;
        goto L33
    L25:
        r115 = false;
        goto L26
    L11:
        if ((r38 instanceof JSONObject) == false) goto L14;
        r5 = (JSONObject) r38;
        goto L17
    L14:
        if ((r38 instanceof com.bytedance.ttnet.j.e.b) == false) goto L16;
        r5 = ((com.bytedance.ttnet.j.e.b) r38).b();
        goto L17
    L16:
        r5 = null;
        goto L17
    }
}
