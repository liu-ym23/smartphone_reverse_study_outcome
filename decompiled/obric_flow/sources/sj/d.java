package sj;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.connectionclass.ConnectionQuality;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.tnc.TNCManager$TNCUpdateSource;
import com.lynx.tasm.ui.image.f0;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import u9.l;
import ym.p;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements WeakHandler.IHandler, da.a, rj.a, u9.k, u9.j, s9.f {
    public static d s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ArrayList f21905t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f21906u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f21907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f21908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f21909c;
    public final Object d;
    public final Context e;
    public volatile boolean f;
    public volatile int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f21910h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f21911i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f21912j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f21913k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f21914l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f21915m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f21916n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final CopyOnWriteArrayList f21917o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final CopyOnWriteArrayList f21918p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicInteger f21919q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final CopyOnWriteArrayList f21920r;

    static {
        ArrayList r5 = new ArrayList();
        f21905t = r5;
        f21906u = false;
        r5.add("MI PAD 2");
        r5.add("YT3-X90L");
        r5.add("YT3-X90F");
        r5.add("GT-810");
    }

    public d(Context r5, boolean r10) {
        this.f21908b = new AtomicLong(0);
        this.f21909c = new AtomicBoolean(false);
        this.d = new Object();
        this.f = false;
        this.g = -1;
        this.f21910h = 0;
        this.f21911i = 0;
        this.f21912j = 0;
        this.f21913k = 0;
        this.f21914l = 1;
        this.f21915m = 1;
        this.f21916n = 1;
        this.f21917o = new CopyOnWriteArrayList();
        this.f21918p = new CopyOnWriteArrayList();
        this.f21919q = new AtomicInteger(10800);
        this.f21920r = new CopyOnWriteArrayList();
        new WeakHandler(Looper.getMainLooper(), this);
        this.e = r5;
        this.f21907a = r10;
    }

    public static d h(Context r5) {
        monitor-enter(d.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (s != null) goto L39;
        boolean r10 = com.bytedance.frameworks.baselib.network.http.util.b.b(r5);     // Catch: Throwable -> L9
        s = new d(r5.getApplicationContext(), r10);     // Catch: Throwable -> L9
        if (f21905t.contains(Build.MODEL) == false) goto L11;
        f21906u = true;     // Catch: Throwable -> L9
    L11:
        r5.getPackageName();     // Catch: Throwable -> L9
        if (r10 == false) goto L32;
        d r11 = s;     // Catch: Throwable -> L9
        com.lynx.tasm.behavior.ui.utils.e.f10745a = r11;     // Catch: Throwable -> L9
        l.g = r11;     // Catch: Throwable -> L9
        l.f = s;     // Catch: Throwable -> L9
        com.lynx.tasm.utils.e.e = s;     // Catch: Throwable -> L9
        p r12 = q9.a.f21495a;     // Catch: Throwable -> L9
        d r13 = s;     // Catch: Throwable -> L9
        if (r13 == null) goto L16;
        ((ArrayList) r12.f23313c).add(r13);     // Catch: Throwable -> L9
    L16:
        ConnectionQuality r14 = (ConnectionQuality) ((AtomicReference) r12.f23312b).get();     // Catch: Throwable -> L9
        s9.h.f21879a = s;     // Catch: Throwable -> L9
        if (s9.h.g != null) goto L19;
        s9.h.g = s;     // Catch: Throwable -> L9
    L19:
        s9.h.f = s;     // Catch: Throwable -> L9
        if (f.f21922b != null) goto L39;
        Object r15 = f.f21923c;     // Catch: Throwable -> L9
        monitor-enter(r15);     // Catch: Throwable -> L9
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L24:
        if (f.f21922b != null) goto L28;
        f.f21922b = new f(r5);     // Catch: Throwable -> L26
    L28:
        monitor-exit(r15);     // Catch: Throwable -> L26
    L32:
        IntentFilter r16 = new IntentFilter();     // Catch: Throwable -> L9
        r16.addAction("com.bytedance.ttnet.config.appconfig.SYNC_MAIN_PROCESS_CONFIG");     // Catch: Throwable -> L9
        r5.registerReceiver(new com.lynx.tasm.base.e(1), r16);     // Catch: Throwable -> L35
    L37:
        g.q();     // Catch: Throwable -> L9
        throw null;     // Catch: Throwable -> L9
    L35:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L9
    L39:
        d r17 = s;     // Catch: Throwable -> L9
        monitor-exit(d.class);     // Catch: Throwable -> L9
        return r17;
    }

    @Override // s9.f
    public final List a(String r5) {
        CopyOnWriteArrayList r10 = this.f21917o;
        if (f0.s(r5, r10) == false) goto L5;
        return r10;
    L5:
        return null;
    }

    @Override // rj.a
    public final void b() {
        if (f21906u == false) goto L6;
        com.bytedance.frameworks.baselib.network.http.ok3.impl.a.f4682a = 8;
        return;
    L6:
        boolean r5 = false;
        String r10 = Build.SUPPORTED_ABIS[0];     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r10) == false) goto L11;
    L26:
        if (r5 == false) goto L29;
        return;
    L29:
        if (this.g <= 5) goto L32;
        com.bytedance.frameworks.baselib.network.http.ok3.impl.a.f4682a = 3;
        Logger.e("AppConfig", "After five consecutive crashes of cronet, you must reinstall app to enable cronet, or wait until several hours");
        return;
    L32:
        TTNetInit.getTTNetDepend();
        throw null;
    L11:
        if ("x86".equalsIgnoreCase(r10) == true) goto L18;
        if ("x86_64".equalsIgnoreCase(r10) == false) goto L26;
    L18:
        if (TTNetInit.ENV.RELEASE == TTNetInit.getEnv()) goto L20;
        boolean r11 = true;
    L21:
        if (r11 == true) goto L23;
        Logger.w("AppConfig", "Cronet unsupported CPU arch: " + r10);     // Catch: Throwable -> L15
        com.bytedance.frameworks.baselib.network.http.ok3.impl.a.f4682a = 2;     // Catch: Throwable -> L15
        r5 = true;
        goto L26
    L23:
        TTNetInit.getTTNetDepend();     // Catch: Throwable -> L15
        throw null;     // Catch: Throwable -> L15
    L20:
        r11 = false;
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L26
    }

    @Override // da.a
    public final boolean c() {
        if (this.f21912j <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void d(TNCManager$TNCUpdateSource r5, boolean r10) {
        StringBuilder r11 = new StringBuilder("doRefresh: updating state ");
        AtomicBoolean r12 = this.f21909c;
        r11.append(r12.get());
        Logger.d("TNCManager", r11.toString());
        if (r12.compareAndSet(false, true) == true) goto L6;
        Logger.d("TNCManager", "doRefresh, already running");
        return;
    L6:
        new b(this, r5, r10).a();
    }

    @Override // da.a
    public final boolean e() {
        if (this.f21913k <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // da.a
    public final boolean f() {
        if (this.f21914l <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // u9.k
    public final boolean g() {
        if (this.f21911i <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r10) {
        int r11 = r10.what;
        AtomicBoolean r5 = this.f21909c;
        switch(r11) {
            case 101: goto L17;
            case 102: goto L14;
            case 103: goto L10;
            case 104: goto L6;
            default: goto L25;
        };
    L17:
        this.f21908b.set(System.currentTimeMillis());
        if (Logger.debug() == false) goto L20;
        Logger.d("TNCManager", "doRefresh, succ");
    L20:
        r5.set(false);
        return;
    L25:
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("TNCManager", "did is empty, delay request tnc");
    L8:
        l(TNCManager$TNCUpdateSource.TTSERVER, false);
        return;
    L10:
        if (Logger.debug() == false) goto L12;
        Logger.d("TNCManager", "do tnc polling");
    L12:
        l(TNCManager$TNCUpdateSource.TTPOLL, false);
        return;
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.d("TNCManager", "doRefresh, error");
    L16:
        r5.set(false);
    }

    public final void i(String r5) {
        if (com.bytedance.common.utility.b.b(r5) == false) goto L6;
        return;
    L6:
        if (this.f21915m > 0) goto L19;
        return;
    L19:
        URI r10 = com.lynx.tasm.utils.e.j(r5);     // Catch: Throwable -> L16
        if (r10 != null) goto L12;
        return;
    L12:
        if (com.bytedance.common.utility.b.b(r10.getHost()) == false) goto L14;
        return;
    L14:
        TTNetInit.getTTNetDepend();     // Catch: Throwable -> L16
        throw null;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // u9.j
    public final boolean isCronetBootFailureExpected() {
        if (Logger.debug() == false) goto L5;
        Logger.d("AppConfig", "isCronetBootFailureExpected...");
    L5:
        SharedPreferences r5 = this.e.getSharedPreferences("ss_app_config", 0);
        if (this.g >= 0) goto L8;
        this.g = r5.getInt("chromium_boot_failures", 0);
    L8:
        this.f21910h = r5.getLong("chromium_boot_failures_timestamp", 0);
        if (this.g > 5) goto L11;
    L13:
        b();
        return false;
    L11:
        if ((System.currentTimeMillis() - this.f21910h) <= TimeUnit.HOURS.toMillis(1)) goto L13;
        this.g = 5;
        goto L13
    }

    public final synchronized void j() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if ((System.currentTimeMillis() - this.f21908b.get()) <= (((long) this.f21919q.get()) * 1000)) goto L11;
        this.f21908b.set(System.currentTimeMillis());     // Catch: Throwable -> L9
        TTNetInit.getTTNetDepend();     // Catch: Throwable -> L9 Exception -> L15
        throw null;     // Catch: Throwable -> L9 Exception -> L15
    L11:
        monitor-exit(this);
    }

    public final void k() {
        int r5 = 0;
        Object r10 = this.d;
        monitor-enter(r10);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.f == false) goto L10;
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L10:
        this.f = true;     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        j r11 = j.b(this.e);
        String r12 = r11.f21929a.getSharedPreferences("tt_state_config", 4).getString("tnc_delay_config", "");
        r11.d = r12;
        if (TextUtils.isEmpty(r12) == true) goto L19;
        r11.f(new JSONObject(r11.d));     // Catch: JSONException -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
    L19:
        if (r11.f21930b == true) goto L127;
        SharedPreferences r13 = this.e.getSharedPreferences("ss_app_config", 0);
        r13.getInt("ok_http_open", 0);
        r13.getInt("ok_http3_open", 0);
        r13.getInt("cronet_version", 0);
        this.f21911i = r13.getInt("http_dns_enabled", 0);
        r13.getInt("detect_open", 0);
        r13.getInt("detect_native_page", 1);
        r13.getInt("collect_recent_page_info_enable", 1);
        this.f21912j = r13.getInt("add_ss_queries_open", 0);
        this.f21913k = r13.getInt("add_ss_queries_header_open", 0);
        this.f21914l = r13.getInt("add_ss_queries_plaintext_open", 1);
        r13.getInt("add_device_fingerprint_open", 1);
        this.f21916n = r13.getInt("dynamic_adjust_threadpool_size_open", 1);
        if (this.g >= 0) goto L24;
        this.g = r13.getInt("chromium_boot_failures", 0);
    L24:
        if (this.f21916n <= 0) goto L26;
        boolean r14 = true;
    L28:
        monitor-enter(r9.c.class);
        r9.c.f21704b = r14;     // Catch: Throwable -> L33
        if (r9.c.f21705c == null) goto L35;
        r9.c.f21705c.f21710h = r9.c.f21704b;     // Catch: Throwable -> L33
    L35:
        monitor-exit(r9.c.class);
        r13.getInt("image_ttnet_enabled", 1);
        this.f21915m = r13.getInt("sample_band_width_enabled", 1);
        r13.getInt("cdn_sample_band_width_enabled", 1);
        r13.getInt("use_http_dns", -1);
        r13.getInt("use_http_dns_refetch_on_expire", -1);
        com.lynx.tasm.utils.g.d = r13.getInt("read_response_buff_init_size", 0);
        com.lynx.tasm.utils.g.e = r13.getInt("read_response_buff_increase_size", 0);
        l.e = r13.getInt("cronet_inputstream_buff_size", 0);
        boolean r15 = com.bytedance.ttnet.utils.b.f7537a;
        int r16 = r13.getInt("ttnet_response_verify_enabled", -1);
        String r17 = r13.getString("ttnet_response_verify", "");
        if (TextUtils.isEmpty(r17) == false) goto L152;
    L42:
        JSONArray r18 = null;
    L43:
        if (r16 <= 0) goto L63;
        ArrayList r19 = new ArrayList();
        if (r18 == null) goto L62;
        int r20 = r18.length();
        int r21 = 0;
    L47:
        if (r21 >= r20) goto L56;
        String r22 = r18.optString(r21);
        if (TextUtils.isEmpty(r22) == true) goto L55;
        com.bytedance.ttnet.utils.a r23 = new com.bytedance.ttnet.utils.a();
        r23.f7536a = Pattern.compile(r22);     // Catch: PatternSyntaxException -> L53
        r19.add(r23);
    L53:
        e = move-exception;
        e.printStackTrace();
    L55:
        r21 = r21 + 1;
        goto L47
    L56:
        ReentrantReadWriteLock.WriteLock r24 = com.bytedance.ttnet.utils.b.d;
        r24.lock();     // Catch: Throwable -> L59
        com.bytedance.ttnet.utils.b.f7538b = r19;     // Catch: Throwable -> L59
        r24.unlock();
    L59:
        th = move-exception;
        r24.unlock();
        throw th;
    L62:
        com.bytedance.ttnet.utils.b.f7537a = true;
    L65:
        if (this.f21912j <= 0) goto L67;
    L68:
        wa.a.f22819b = true;
    L69:
        r13.getString(WsConstants.KEY_FRONTIER_URLS, "");
        r13.getString("cronet_so_path", "");
        String r25 = r13.getString("api_http_host_list", "");
        if (com.bytedance.common.utility.b.b(r25) == true) goto L77;
        String[] r26 = r25.split(",");
        int r27 = r26.length;
        int r28 = 0;
    L72:
        if (r28 >= r27) goto L77;
        String r29 = r26[r28];
        if (com.bytedance.common.utility.b.b(r29) == true) goto L76;
        this.f21918p.add(r29.trim());
    L76:
        r28 = r28 + 1;
    L77:
        String r30 = r13.getString("concurrent_request_config", "");
        u9.g r31 = u9.g.a();
        r31.getClass();
        Logger.d("g", "onNetConfigChanged config: " + r30);
        if (TextUtils.isEmpty(r30) == false) goto L148;
    L86:
        r13.getString("add_common_params", "");
        t9.a.i().getClass();
        String r32 = r13.getString("L0_params", "");
        ca.e r33 = ca.e.b();
        r33.getClass();
        if (TextUtils.isEmpty(r32) == true) goto L97;
        CopyOnWriteArrayList r34 = r33.d;
        r34.clear();
        JSONArray r35 = new JSONArray(r32);     // Catch: JSONException -> L95
        int r36 = 0;
    L92:
        if (r36 >= r35.length()) goto L97;
        r34.add(r35.getString(r36));     // Catch: JSONException -> L95
        r36 = r36 + 1;
    L95:
        e = move-exception;
        e.printStackTrace();
    L97:
        int r37 = r13.getInt("query_filter_enabled", Integer.MIN_VALUE);
        String r38 = r13.getString("query_filter_actions", "");
        if (r37 == Integer.MIN_VALUE) goto L112;
        ca.e r39 = ca.e.b();
        if (r37 <= 0) goto L102;
        boolean r40 = true;
    L103:
        r39.f1157b = r40;
        ca.e r41 = ca.e.b();
        r41.getClass();
        Logger.d("e", "onNetConfigChanged config: " + r38 + " enabled: " + r41.f1157b);
        if (r41.f1157b == false) goto L112;
        if (TextUtils.isEmpty(r38) == true) goto L112;
        r41.e(r38);     // Catch: Throwable -> L110
    L110:
        th = move-exception;
        th.printStackTrace();
        goto L112
    L102:
        r40 = false;
    L112:
        String r42 = r13.getString("share_cookie_host_list", "");
        CopyOnWriteArrayList r110 = this.f21917o;
        if (com.bytedance.common.utility.b.b(r42) == true) goto L123;
        if (r110 == null) goto L123;
        String[] r43 = r42.split(",");
        int r44 = r43.length;
    L116:
        if (r5 >= r44) goto L123;
        String r45 = r43[r5];
        if (com.bytedance.common.utility.b.b(r45) == true) goto L122;
        if (f0.s(r45, r110) == true) goto L122;
        r110.add(r45.trim());
    L122:
        r5 = r5 + 1;
    L123:
        TTNetInit.getTTNetDepend();
        throw null;
    L148:
        JSONObject r46 = new JSONObject(r30);     // Catch: Throwable -> L85
        r31.f22313a = r46.optInt("enabled_v2", 0);     // Catch: Throwable -> L85
        r31.f22314b.clear();     // Catch: Throwable -> L85
        JSONArray r47 = r46.getJSONArray("match_rules");     // Catch: Throwable -> L85
        int r48 = 0;
    L82:
        if (r48 >= r47.length()) goto L86;
        r31.d((JSONObject) r47.get(r48));     // Catch: Throwable -> L85
        r48 = r48 + 1;
    L85:
        Logger.d("g", "parse json config error");
        goto L86
    L67:
        if (this.f21913k <= 0) goto L69;
    L63:
        com.bytedance.ttnet.utils.b.f7537a = false;
        goto L65
    L152:
        r18 = new JSONArray(r17);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        th.printStackTrace();
    L33:
        th = move-exception;
        throw th;
    L26:
        r14 = false;
        goto L28
    L127:
        h r111 = (h) r11.f21931c.get(com.bytedance.frameworks.baselib.network.http.cronet.a.f4671a);
        monitor-enter(r11);
        r11.f = false;     // Catch: Throwable -> L136
        r11.f21933i.clear();     // Catch: Throwable -> L136
        r11.g = 100;     // Catch: Throwable -> L136
        r11.f21932h.clear();     // Catch: Throwable -> L136
        r11.f21934j.clear();     // Catch: Throwable -> L136
        if (r111 != null) goto L132;
        r11.e = false;     // Catch: Throwable -> L136
    L140:
        r11.g();     // Catch: Throwable -> L136
        throw null;     // Catch: Throwable -> L136
    L132:
        if (r111.f21926b.isEmpty() == true) goto L134;
        r11.e = true;     // Catch: Throwable -> L136
        r11.g = r111.f21927c;     // Catch: Throwable -> L136
        r11.f21932h = r111.f21926b;     // Catch: Throwable -> L136
        goto L140
    L134:
        if (r111.f21925a.isEmpty() == true) goto L140;
        r11.e = true;     // Catch: Throwable -> L136
        r11.f = true;     // Catch: Throwable -> L136
        r11.f21933i = r111.f21925a;     // Catch: Throwable -> L136
    L136:
        th = move-exception;
        throw th;
    }

    public final void l(TNCManager$TNCUpdateSource r5, boolean r10) {
        if (this.f21907a == false) goto L6;
        d(r5, r10);
        return;
    L6:
        if (this.f21908b.get() > 0) goto L13;
        new a(this).a();     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }
}
