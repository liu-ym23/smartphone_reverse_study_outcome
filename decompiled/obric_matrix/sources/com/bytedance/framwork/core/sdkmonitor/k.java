package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IHttpService;
import com.obric.matrix.common_api.INetworkApi;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class k implements d.b.i.a.b.e.b, d.b.i.a.b.g.c, d.b.i.a.b.h.b {
    private volatile boolean A;
    private List<String> B;
    private com.bytedance.framwork.core.sdkmonitor.b C;
    private String D;
    private boolean E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f4802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d.b.i.a.b.d f4803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d.b.i.a.b.b f4804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile long f4805e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile long f4806f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile int f4807g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile int f4808h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile int f4809i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile int f4810j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile JSONObject f4811k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile JSONObject f4812l;
    private volatile IHttpService m;
    private volatile int n;
    private volatile int o;
    private volatile List<String> p;
    private volatile List<Pattern> q;
    private volatile List<String> r;
    private volatile List<Pattern> s;
    private m t;
    private Map<String, String> u;
    private List<String> v;
    private volatile boolean w;
    private volatile boolean x;
    private volatile boolean y;
    private volatile boolean z;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ k f4813f;

        a(k r1) {
            this.f4813f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k.u(this.f4813f) == null) goto L6;
            k.u(this.f4813f).e(0, true);
            return;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ l f4814f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ k f4815g;

        b(k r1, l r2) {
            this.f4815g = r1;
            this.f4814f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean r0 = false;
        L8:
            th = move-exception;
            this.f4814f.a(false);
            throw th;
        L4:
            if (k.u(this.f4815g) == null) goto L6;
            r0 = k.u(this.f4815g).e(0, true);     // Catch: Throwable -> L8
        L6:
            this.f4814f.a(r0);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ k f4816f;

        c(k r1) {
            this.f4816f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k.u(this.f4816f) != null) goto L5;
            return;
        L5:
            if (k.l(this.f4816f) == null) goto L9;
            k.l(this.f4816f).g(true);
            return;
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ l f4817f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ k f4818g;

        d(k r1, l r2) {
            this.f4818g = r1;
            this.f4817f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean r0 = false;
        L10:
            th = move-exception;
            this.f4817f.a(false);
            throw th;
        L4:
            if (k.u(this.f4818g) != null) goto L6;
        L8:
            this.f4817f.a(r0);
            return;
        L6:
            if (k.l(this.f4818g) == null) goto L8;
            r0 = k.l(this.f4818g).g(true);     // Catch: Throwable -> L10
            goto L8
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f4819f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f4820g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ m f4821h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ k f4822i;

        e(k r1, Context r2, JSONObject r3, m r4) {
            this.f4822i = r1;
            this.f4819f = r2;
            this.f4820g = r3;
            this.f4821h = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.j(this.f4822i, this.f4819f, this.f4820g, this.f4821h);
            if (k.k(this.f4822i) == false) goto L6;
            k.n(this.f4822i).h(this.f4822i);
            return;
        }
    }

    class f implements m {
        f(k r1) {
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.k.m
        public Map<String, String> getCommonParams() {
            return null;
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.k.m
        public String getSessionId() {
            return null;
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ k f4823f;

        g(k r1) {
            this.f4823f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
        L18:
            th = move-exception;
            if (k.k(this.f4823f) == true) goto L22;
            k.m(this.f4823f, true);
            k.n(this.f4823f).h(this.f4823f);
        L22:
            th.printStackTrace();
            return;
        L3:
            if (k.o(this.f4823f) == null) goto L31;
            Iterator r0 = k.p(this.f4823f).iterator();     // Catch: Throwable -> L18
        L5:
            if (r0.hasNext() == false) goto L32;
            String r1 = (String) r0.next();     // Catch: Throwable -> L18
            StringBuilder r2 = k.q(this.f4823f, r1);     // Catch: Throwable -> L18
            r2.append("&encrypt=close");     // Catch: Throwable -> L18
            String r3 = r2.toString();     // Catch: Throwable -> L18
        L15:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L18
            goto L5
        L9:
            if (k.r(this.f4823f) == null) goto L11;
            byte[] r4 = k.r(this.f4823f).doGet(r3, null).getResponseBytes();     // Catch: Throwable -> L15
        L12:
            if (r4 == null) goto L33;
            k.t(this.f4823f, new JSONObject(new String(r4)));     // Catch: Throwable -> L15
        L34:
            return;
        L33:
            return;
        L11:
            r4 = com.bytedance.framwork.core.sdkmonitor.j.e(r3, null, k.s(this.f4823f));     // Catch: Throwable -> L15
            goto L12
        L32:
            return;
        }
    }

    class h implements d.b.i.a.c.c.b {
        h(k r1) {
        }

        @Override // d.b.i.a.c.c.b
        public boolean a(Context r1) {
            return com.bytedance.framwork.core.sdkmonitor.j.f(r1);
        }
    }

    class i implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f4824f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f4825g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f4826h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f4827i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f4828j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f4829k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ JSONObject f4830l;
        final /* synthetic */ k m;

        i(k r1, long r2, long r4, String r6, String r7, String r8, int r9, JSONObject r10) {
            this.m = r1;
            this.f4824f = r2;
            this.f4825g = r4;
            this.f4826h = r6;
            this.f4827i = r7;
            this.f4828j = r8;
            this.f4829k = r9;
            this.f4830l = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.m.M(this.f4824f, this.f4825g, this.f4826h, this.f4827i, this.f4828j, this.f4829k, this.f4830l);
        }
    }

    class j implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f4831f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f4832g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f4833h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f4834i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f4835j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f4836k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ JSONObject f4837l;
        final /* synthetic */ k m;

        j(k r1, long r2, long r4, String r6, String r7, String r8, int r9, JSONObject r10) {
            this.m = r1;
            this.f4831f = r2;
            this.f4832g = r4;
            this.f4833h = r6;
            this.f4834i = r7;
            this.f4835j = r8;
            this.f4836k = r9;
            this.f4837l = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.m.L(this.f4831f, this.f4832g, this.f4833h, this.f4834i, this.f4835j, this.f4836k, this.f4837l);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.framwork.core.sdkmonitor.k$k, reason: collision with other inner class name */
    class RunnableC0150k implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f4838f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f4839g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ JSONObject f4840h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ JSONObject f4841i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ JSONObject f4842j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ JSONObject f4843k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ long f4844l;
        final /* synthetic */ k m;

        RunnableC0150k(k r1, String r2, int r3, JSONObject r4, JSONObject r5, JSONObject r6, JSONObject r7, long r8) {
            this.m = r1;
            this.f4838f = r2;
            this.f4839g = r3;
            this.f4840h = r4;
            this.f4841i = r5;
            this.f4842j = r6;
            this.f4843k = r7;
            this.f4844l = r8;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.m.Z(this.f4838f, this.f4839g, this.f4840h, this.f4841i, this.f4842j, this.f4843k, this.f4844l);
        }
    }

    public interface l {
        void a(boolean r1);
    }

    public interface m {
        Map<String, String> getCommonParams();

        String getSessionId();
    }

    protected k(String r3) {
        this.f4805e = 0;
        this.v = new LinkedList();
        this.y = true;
        this.B = new LinkedList();
        this.D = r3;
        this.A = false;
        this.C = new com.bytedance.framwork.core.sdkmonitor.b();
    }

    private static String A(String r0, String r1) {
        if (r1 != null) goto L10;
        r1 = "UTF-8";
    L10:
        return URLEncoder.encode(r0, r1);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    private IHttpService F() {
        if (this.m != null) goto L6;
        this.m = (IHttpService) com.bytedance.news.common.service.manager.d.a(IHttpService.class);
    L6:
        return this.m;
    }

    private String J() {
        m r0 = this.t;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getSessionId();
    }

    private SharedPreferences K() {
        String r0 = com.bytedance.framwork.core.sdkmonitor.i.a(this.f4801a);
        return i(this.f4801a, "monitor_config" + this.D + r0, 0);
    }

    private void O() {
        SharedPreferences r0 = K();
        String r1 = r0.getString("monitor_net_config", null);
        this.f4805e = r0.getLong("monitor_configure_refresh_time", 0);
        if (r0.getInt("monitor_config_update", 0) != 1) goto L5;
        boolean r2 = true;
    L6:
        d.b.i.a.b.h.a.e().d(this);
        if (TextUtils.isEmpty(r1) == false) goto L16;
    L14:
        k0(false);
        return;
    L16:
        this.A = true;     // Catch: Exception -> L13
        JSONObject r3 = new JSONObject(r1);     // Catch: Exception -> L13
        if (r2 == true) goto L11;
        r3.remove("report_host_new");     // Catch: Exception -> L13
    L11:
        j0(r3);     // Catch: Exception -> L13
    L13:
        Log.e("monitor_config", "config error");
        goto L14
    L5:
        r2 = false;
        goto L6
    }

    private void P() {
        d.b.i.a.c.c.a(new h(this));
    }

    private void Q(Context r18, JSONObject r19, m r20) {
        if (r18 == null) goto L29;
        if (r19 == null) goto L30;
        this.z = true;
        this.f4801a = r18.getApplicationContext();
        this.f4802b = r19;
        r19.put(WsConstants.KEY_APP_ID, this.D);     // Catch: Exception -> L26
        this.f4802b.put("os", LocationInfoConst.SYSTEM);     // Catch: Exception -> L26
        this.f4802b.put("device_platform", "android");     // Catch: Exception -> L26
        this.f4802b.put("os_version", Build.VERSION.RELEASE);     // Catch: Exception -> L26
        this.f4802b.put("os_api", Build.VERSION.SDK_INT);     // Catch: Exception -> L26
        this.f4802b.put("device_model", Build.MODEL);     // Catch: Exception -> L26
        this.f4802b.put("device_brand", Build.BRAND);     // Catch: Exception -> L26
        this.f4802b.put("device_manufacturer", Build.MANUFACTURER);     // Catch: Exception -> L26
        this.f4802b.put("sdkmonitor_version", "2.0.35");     // Catch: Exception -> L26
        this.f4802b.put("monitor_from", "sdk");     // Catch: Exception -> L26
        if (TextUtils.isEmpty(this.f4802b.optString("package_name")) == false) goto L10;
        this.f4802b.put("package_name", r18.getPackageName());     // Catch: Exception -> L26
    L10:
        PackageInfo r1 = null;
        if (TextUtils.isEmpty(this.f4802b.optString("version_name")) == false) goto L14;
        r1 = this.f4801a.getPackageManager().getPackageInfo(this.f4801a.getPackageName(), 0);     // Catch: Exception -> L26
        this.f4802b.put("version_name", r1.versionName);     // Catch: Exception -> L26
    L14:
        if (TextUtils.isEmpty(this.f4802b.optString("version_code")) == false) goto L18;
        if (r1 != null) goto L17;
        r1 = this.f4801a.getPackageManager().getPackageInfo(this.f4801a.getPackageName(), 0);     // Catch: Exception -> L26
    L17:
        this.f4802b.put("version_code", r1.versionCode);     // Catch: Exception -> L26
    L18:
        this.t = r20;     // Catch: Exception -> L26
        if (r20 != null) goto L21;
        this.t = new f(this);     // Catch: Exception -> L26
    L21:
        Map<String, String> r2 = this.t.getCommonParams();     // Catch: Exception -> L26
        this.u = r2;     // Catch: Exception -> L26
        if (r2 != null) goto L24;
        this.u = new HashMap();     // Catch: Exception -> L26
    L24:
        this.E = TextUtils.equals(this.u.get("oversea"), LocationInfoConst.ALLOW_USE_LOCATION);     // Catch: Exception -> L26
        this.u.put(WsConstants.KEY_APP_ID, this.D);     // Catch: Exception -> L26
        this.u.put(WsConstants.KEY_DEVICE_ID, this.f4802b.optString(WsConstants.KEY_DEVICE_ID));     // Catch: Exception -> L26
        this.u.put("device_platform", "android");     // Catch: Exception -> L26
        this.u.put("package_name", this.f4802b.optString("package_name"));     // Catch: Exception -> L26
        this.u.put("channel", this.f4802b.optString("channel"));     // Catch: Exception -> L26
        this.u.put(WsConstants.KEY_APP_VERSION, this.f4802b.optString(WsConstants.KEY_APP_VERSION));     // Catch: Exception -> L26
        this.u.put("sdkmonitor_version", "2.0.35");     // Catch: Exception -> L26
        this.u.put("minor_version", LocationInfoConst.ALLOW_USE_LOCATION);     // Catch: Exception -> L26
        d.b.i.a.b.e.c.h(this.D, this);     // Catch: Exception -> L26
        d.b.i.a.b.g.d.d(this.D, this);     // Catch: Exception -> L26
        P();     // Catch: Exception -> L26
        d.b.i.a.b.d r3 = new d.b.i.a.b.d(this.f4801a, this.D);     // Catch: Exception -> L26
        this.f4803c = r3;     // Catch: Exception -> L26
        r3.c();     // Catch: Exception -> L26
        this.m = (IHttpService) com.bytedance.news.common.service.manager.d.a(IHttpService.class);     // Catch: Exception -> L26
        O();     // Catch: Exception -> L26
        return;
    L31:
        return;
    L30:
        return;
    }

    private boolean S(String r3, List<String> r4, List<Pattern> r5) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return false;
    L6:
        if (com.bytedance.framwork.core.sdkmonitor.g.a(r4) == true) goto L23;
        Iterator<String> r2 = r4.iterator();
    L9:
        if (r2.hasNext() == false) goto L23;
        if (r3.contains(r2.next()) == false) goto L9;
        return true;
    L23:
        String r6 = new URI(r3).getPath();     // Catch: Throwable -> L22
        if (com.bytedance.framwork.core.sdkmonitor.g.a(r5) == true) goto L21;
        Iterator<Pattern> r7 = r5.iterator();     // Catch: Throwable -> L22
    L17:
        if (r7.hasNext() == false) goto L21;
        if (r7.next().matcher(r6).matches() == false) goto L17;
        return true;
    L21:
        return false;
    }

    private boolean T(String r3) {
        return S(r3, this.r, this.s);
    }

    private boolean U(String r3) {
        return S(r3, this.p, this.q);
    }

    private boolean c0() {
        if (((System.currentTimeMillis() - this.f4805e) / 1000) <= this.f4806f) goto L5;
        return true;
    L5:
        return false;
    }

    private JSONObject d0(String r4, long r5, long r7, String r9, String r10, String r11, int r12) {
        if (TextUtils.isEmpty(r4) == false) goto L22;
        return null;
    L22:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L21
        r0.put("log_type", r4);     // Catch: Exception -> L21
        r0.put(TypedValues.TransitionType.S_DURATION, r5);     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r9) == true) goto L9;
        r0.put("uri", Uri.parse(r9));     // Catch: Exception -> L21
    L9:
        if (r7 <= 0) goto L11;
        r0.put("timestamp", r7);     // Catch: Exception -> L21
    L11:
        r0.put("status", r12);     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r10) == true) goto L16;
        r0.put("ip", r10);     // Catch: Exception -> L21
    L16:
        if (TextUtils.isEmpty(r11) == true) goto L18;
        r0.put("trace_code", r11);     // Catch: Exception -> L21
    L19:
        r0.put("network_type", com.bytedance.framwork.core.sdkmonitor.j.d(this.f4801a).a());     // Catch: Exception -> L21
        return r0;
    L18:
        r0.put("trace_code", "");     // Catch: Exception -> L21
    L21:
        return null;
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences i(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    static /* synthetic */ void j(k r0, Context r1, JSONObject r2, m r3) {
        r0.Q(r1, r2, r3);
    }

    static /* synthetic */ boolean k(k r0) {
        return r0.A;
    }

    static /* synthetic */ d.b.i.a.b.b l(k r0) {
        return r0.f4804d;
    }

    private void l0(JSONObject r6) {
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.length() <= 0) goto L14;
        j0(r6.getJSONObject("ret"));     // Catch: Throwable -> L10
        SharedPreferences.Editor r1 = K().edit();     // Catch: Throwable -> L10
        r1.putLong("monitor_configure_refresh_time", System.currentTimeMillis());     // Catch: Throwable -> L10
        r1.putInt("monitor_config_update", 1);     // Catch: Throwable -> L10
        r1.putString("monitor_net_config", r6.getJSONObject("ret").toString());     // Catch: Throwable -> L10
        r1.apply();     // Catch: Throwable -> L10
        if (this.A == true) goto L15;
        this.A = true;     // Catch: Throwable -> L10
        this.C.h(this);     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L16:
        return;
    }

    static /* synthetic */ boolean m(k r0, boolean r1) {
        r0.A = r1;
        return r1;
    }

    static /* synthetic */ com.bytedance.framwork.core.sdkmonitor.b n(k r0) {
        return r0.C;
    }

    static /* synthetic */ Map o(k r0) {
        return r0.u;
    }

    static /* synthetic */ List p(k r0) {
        return r0.v;
    }

    static /* synthetic */ StringBuilder q(k r0, String r1) {
        return r0.v(r1);
    }

    static /* synthetic */ IHttpService r(k r0) {
        return r0.F();
    }

    static /* synthetic */ boolean s(k r0) {
        return r0.y;
    }

    static /* synthetic */ void t(k r0, JSONObject r1) {
        r0.l0(r1);
    }

    static /* synthetic */ d.b.i.a.b.d u(k r0) {
        return r0.f4803c;
    }

    private StringBuilder v(String r4) {
        StringBuilder r0 = new StringBuilder(r4);
        if (TextUtils.isDigitsOnly(r4) == false) goto L5;
    L20:
        return r0;
    L5:
        if (this.u == null) goto L20;
        if (r4.contains("?") == true) goto L10;
        r0.append("?");
    L10:
        w(r0, "sdk_version", String.valueOf(400));
        Map<String, String> r5 = this.u;
        if (r5 == null) goto L20;
        if (r5.size() <= 0) goto L20;
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L16:
        if (r6.hasNext() == false) goto L20;
        Map.Entry<String, String> r1 = r6.next();
        if (r1.getKey() == null) goto L16;
        w(r0, String.valueOf(r1.getKey()), String.valueOf(r1.getValue()));
        goto L16
    }

    private StringBuilder w(@NonNull StringBuilder r2, String r3, String r4) {
        if (r2.charAt(r2.length() - 1) == '?') goto L5;
        r2.append("&");
    L5:
        r2.append(A(r3, "UTF-8"));
        r2.append('=');
        r2.append(A(r4, "UTF-8"));
        return r2;
    }

    private void x(JSONObject r3, JSONObject r4) {
        if (r3 == null) goto L19;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.length() <= 0) goto L21;
        Iterator<String> r2 = r4.keys();     // Catch: JSONException -> L12
    L9:
        if (r2.hasNext() == false) goto L22;
        String r0 = r2.next();     // Catch: JSONException -> L12
        r3.put(r0, r4.get(r0));     // Catch: JSONException -> L12
        goto L9
    L22:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L21:
        return;
    }

    public void B() {
        d.b.i.a.b.h.a.e().f(new a(this));
    }

    public void C(l r3) {
        d.b.i.a.b.h.a.e().f(new b(this, r3));
    }

    public void D() {
        d.b.i.a.b.h.a.e().f(new c(this));
    }

    public void E(l r3) {
        d.b.i.a.b.h.a.e().f(new d(this, r3));
    }

    public boolean G(String r3) {
        if (this.f4812l != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (this.f4812l.opt(r3) == null) goto L12;
        return true;
    L12:
        return false;
    }

    public int H() {
        return d.b.i.a.b.i.d.a(this.f4801a).a();
    }

    public boolean I(String r3) {
        if (this.f4811k != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (this.f4811k.opt(r3) == null) goto L12;
        return true;
    L12:
        return false;
    }

    void L(long r12, long r14, String r16, String r17, String r18, int r19, JSONObject r20) {
        if (this.n != 1) goto L5;
        return;
    L5:
        if (U(r16) == true) goto L19;
        JSONObject r0 = d0("api_error", r12, r14, r16, r17, r18, r19);
        x(r0, r20);
        if (r0 != null) goto L10;
        return;
    L10:
        if (r0.length() <= 0) goto L17;
        d.b.i.a.b.d r1 = this.f4803c;
        if (r1 == null) goto L18;
        r1.d("api_error", "api_error", r0);
        return;
    L18:
        return;
    L17:
        return;
    }

    void M(long r14, long r16, String r18, String r19, String r20, int r21, JSONObject r22) {
        if (U(r18) == false) goto L5;
        return;
    L5:
        if (com.bytedance.framwork.core.sdkmonitor.j.f(this.f4801a) == false) goto L20;
        JSONObject r0 = d0("api_all", r14, r16, r18, r19, r20, r21);
        x(r0, r22);
        if (r0 == null) goto L12;
        if (T(r18) == false) goto L12;
    L16:
        r0.put("hit_rules", 1);     // Catch: JSONException -> L15
        this.f4803c.d("api_all", "api_all", r0);     // Catch: JSONException -> L15
        return;
    L21:
        return;
    L12:
        if (this.o != 0) goto L16;
        return;
    }

    public boolean N(@NonNull Context r4, @NonNull JSONObject r5, @NonNull m r6) {
        this.z = true;
        d.b.i.a.b.h.a.e().g(new e(this, r4, r5, r6), CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        return true;
    }

    protected boolean R() {
        return this.z;
    }

    public void V(long r14, long r16, String r18, String r19, String r20, int r21, JSONObject r22) {
        if (this.A == true) goto L6;
        this.C.k(new com.bytedance.framwork.core.sdkmonitor.a("api_all", r14, r16, r18, r19, r20, r21, r22));     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        d.b.i.a.b.h.a.e().f(new j(this, r14, r16, r18, r19, r20, r21, r22));     // Catch: Throwable -> L8
    }

    void W(String r5, JSONObject r6, long r7) {
        r6.put("log_type", r5);     // Catch: Throwable -> L15
        r6.put("network_type", H());     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(J()) == true) goto L7;
        r6.put("session_id", J());     // Catch: Throwable -> L15
    L7:
        if (r6.isNull("timestamp") == false) goto L10;
        r6.put("timestamp", r7);     // Catch: Throwable -> L15
    L10:
        if (this.f4803c != null) goto L12;
        return;
    L12:
        if (G(r5) == false) goto L19;
        this.f4803c.d("common_log", "common_log", r6);     // Catch: Throwable -> L15
        return;
    L19:
        return;
    }

    public void X(String r12, JSONObject r13, JSONObject r14, JSONObject r15) {
        if (this.A == true) goto L5;
        this.C.l(new com.bytedance.framwork.core.sdkmonitor.l(r12, 0, null, r13, r14, r15, System.currentTimeMillis()));     // Catch: Throwable -> L7
    L8:
        return;
    L5:
        a0(r12, 0, null, r13, r14, r15, System.currentTimeMillis());     // Catch: Throwable -> L7
    }

    public void Y(long r14, long r16, String r18, String r19, String r20, int r21, JSONObject r22) {
        if (this.A == true) goto L6;
        this.C.k(new com.bytedance.framwork.core.sdkmonitor.a("api_all", r14, r16, r18, r19, r20, r21, r22));     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        d.b.i.a.b.h.a.e().f(new i(this, r14, r16, r18, r19, r20, r21, r22));     // Catch: Throwable -> L8
    }

    void Z(String r4, int r5, JSONObject r6, JSONObject r7, JSONObject r8, JSONObject r9, long r10) {
        if (r9 == null) goto L23;
    L5:
        r9.put("log_type", "service_monitor");     // Catch: Throwable -> L22
        r9.put("service", r4);     // Catch: Throwable -> L22
        r9.put("status", r5);     // Catch: Throwable -> L22
        r9.put("network_type", H());     // Catch: Throwable -> L22
        r9.put("value", r6);     // Catch: Throwable -> L22
        if (r7 == null) goto L8;
        r9.put("category", r7);     // Catch: Throwable -> L22
    L8:
        if (r8 == null) goto L11;
        r9.put("metric", r8);     // Catch: Throwable -> L22
    L11:
        if (r9.isNull("timestamp") == false) goto L14;
        r9.put("timestamp", r10);     // Catch: Throwable -> L22
    L14:
        if (TextUtils.isEmpty(J()) == true) goto L17;
        r9.put("session_id", J());     // Catch: Throwable -> L22
    L17:
        if (this.f4803c != null) goto L19;
        return;
    L19:
        if (I(r4) == false) goto L26;
        this.f4803c.d("service_monitor", "service_monitor", r9);     // Catch: Throwable -> L22
        return;
    L27:
        return;
    L26:
        return;
    L23:
        r9 = new JSONObject();     // Catch: Throwable -> L22
        goto L5
    }

    @Override // d.b.i.a.b.e.b
    public boolean a() {
        if (this.x == false) goto L6;
        return this.x;
    L6:
        return this.w;
    }

    void a0(String r13, int r14, JSONObject r15, JSONObject r16, JSONObject r17, JSONObject r18, long r19) {
        d.b.i.a.b.h.a.e().f(new RunnableC0150k(this, r13, r14, r15, r16, r17, r18, r19));
    }

    @Override // d.b.i.a.b.e.b
    public int b() {
        if (this.f4807g > 0) goto L7;
        return 120;
    L7:
        return this.f4807g;
    }

    public void b0(String r12, int r13, JSONObject r14, JSONObject r15, JSONObject r16) {
        if (this.A == true) goto L6;
        this.C.l(new com.bytedance.framwork.core.sdkmonitor.l(r12, r13, null, r14, r15, r16, System.currentTimeMillis()));     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        a0(r12, r13, null, r14, r15, r16, System.currentTimeMillis());     // Catch: Throwable -> L8
    }

    @Override // d.b.i.a.b.g.c
    public d.b.i.a.b.g.e c(String r5, byte[] r6) {
        d.b.i.a.b.g.e r0 = new d.b.i.a.b.g.e();
        String r7 = v(r5).toString();     // Catch: Throwable -> L32
        new HashMap();     // Catch: Throwable -> L32
        if (F() == null) goto L13;
        HashMap r1 = new HashMap();     // Catch: Throwable -> L32
        byte[] r8 = com.bytedance.framwork.core.sdkmonitor.j.a(r6, r1);     // Catch: Throwable -> L32
        if (this.y == false) goto L12;
        byte[] r9 = d.b.h.b.a.b.a(r8, r8.length);     // Catch: Throwable -> L32
        if (r9 == null) goto L10;
        r7 = r7 + "&tt_data=a";     // Catch: Throwable -> L32
        r1.put(INetworkApi.CONTENT_TYPE, "application/octet-stream;tt-data=a");     // Catch: Throwable -> L32
    L10:
        HttpResponse r4 = F().doPost(r7, r9, r1);     // Catch: Throwable -> L32
        byte[] r10 = r4.getResponseBytes();     // Catch: Throwable -> L32
    L11:
        Map<String, String> r11 = r4.getHeaders();     // Catch: Throwable -> L32
        String r12 = null;
        if (r11 != null) goto L17;
    L19:
        r0.f13873a = 200;     // Catch: Throwable -> L32
        JSONObject r13 = new JSONObject(new String(r10));     // Catch: Throwable -> L32
        String r14 = r13.optString("data");     // Catch: Throwable -> L28
        if (r14.isEmpty() == true) goto L26;
        String r15 = d.b.i.a.b.i.a.a(r14.getBytes(), r12);     // Catch: Throwable -> L28
        if (TextUtils.isEmpty(r15) == true) goto L25;
        r13 = new JSONObject(r15);     // Catch: Throwable -> L28
        goto L26
    L25:
        r13.put("message", "success");     // Catch: Throwable -> L28
    L26:
        r0.f13874b = r13;     // Catch: Throwable -> L28
    L30:
        r0.f13874b = r13;     // Catch: Throwable -> L32
        return r0;
    L28:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L32
        goto L30
    L17:
        if (r11.isEmpty() == true) goto L19;
        r12 = r11.get("ran");     // Catch: Throwable -> L32
        goto L19
    L12:
        r4 = F().doPost(r7, r8, r1);     // Catch: Throwable -> L32
        r10 = r4.getResponseBytes();     // Catch: Throwable -> L32
        goto L11
    L13:
        r4 = com.bytedance.framwork.core.sdkmonitor.j.b(r7, r6, com.bytedance.framwork.core.sdkmonitor.j.a.f4791g, INetworkApi.DEFAULT_CONTENT_TYPE, this.y);     // Catch: Throwable -> L32
        r10 = r4.getResponseBytes();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        if ((th instanceof com.bytedance.framwork.core.sdkmonitor.d) == false) goto L36;
        int r16 = th.a();
    L37:
        r0.f13873a = r16;
        return r0;
    L36:
        r16 = -1;
        goto L37
    }

    @Override // d.b.i.a.b.e.b
    public List<String> d(String r1) {
        return this.B;
    }

    @Override // d.b.i.a.b.e.b
    public JSONObject e() {
        return this.f4802b;
    }

    void e0(List<String> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (com.bytedance.framwork.core.sdkmonitor.g.a(r2) == true) goto L8;
        this.v.clear();
        this.v.addAll(r2);
        return;
    }

    @Override // d.b.i.a.b.e.b
    public int f() {
        if (this.f4808h > 0) goto L7;
        return 100;
    L7:
        return this.f4808h;
    }

    void f0(List<String> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (com.bytedance.framwork.core.sdkmonitor.g.a(r2) == true) goto L8;
        this.B.clear();
        this.B.addAll(r2);
        return;
    }

    @Override // d.b.i.a.b.e.b
    public int g() {
        if (this.f4810j > 0) goto L7;
        return 15;
    L7:
        return this.f4810j;
    }

    public void g0() {
        this.f4804d.i();
    }

    @Override // d.b.i.a.b.e.b
    public int h() {
        if (this.f4809i > 0) goto L7;
        return 4;
    L7:
        return this.f4809i;
    }

    public void h0(long r1) {
        this.f4804d.k(r1);
    }

    public void i0(boolean r1) {
        this.f4803c.f(r1);
    }

    synchronized void j0(JSONObject r9) {
        monitor-enter(this);
        if (r9 != null) goto L73;
        monitor-exit(this);
        return;
    L73:
        JSONObject r0 = com.bytedance.framwork.core.sdkmonitor.f.a(r9, com.bytedance.framwork.core.sdkmonitor.h.f4780a, com.bytedance.framwork.core.sdkmonitor.h.f4783d);     // Catch: Throwable -> L69
        if (r0 == null) goto L53;
        JSONObject r2 = r0.optJSONObject(com.bytedance.framwork.core.sdkmonitor.h.f4785f);     // Catch: Throwable -> L69
        if (r2 == null) goto L12;
        this.f4806f = r2.optLong(com.bytedance.framwork.core.sdkmonitor.h.f4786g, 1200);     // Catch: Throwable -> L69
    L12:
        if (this.f4806f >= 600) goto L15;
        this.f4806f = 600;     // Catch: Throwable -> L69
    L15:
        if (c0() == false) goto L18;
        monitor-exit(this);
        return;
    L18:
        JSONObject r1 = r0.optJSONObject(com.bytedance.framwork.core.sdkmonitor.h.f4787h);     // Catch: Throwable -> L69
        if (r1 == null) goto L53;
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L69
        JSONArray r4 = r1.optJSONArray("hosts");     // Catch: Exception -> L72 Throwable -> L69
        if (r4 == null) goto L41;
        if (r4.length() <= 0) goto L41;
        int r5 = r4.length();     // Catch: Exception -> L72 Throwable -> L69
        int r6 = 0;
    L26:
        if (r6 >= r5) goto L41;
        String r7 = r4.getString(r6);     // Catch: Exception -> L72 Throwable -> L69
        if (this.E == false) goto L35;
        if (r7.contains(".snssdk.") == true) goto L33;
        if (r7.contains(".toutiao.") == false) goto L35;
    L33:
        r3.clear();     // Catch: Exception -> L72 Throwable -> L69
    L35:
        if (TextUtils.isEmpty(r7) == true) goto L39;
        if (r7.indexOf(46) <= 0) goto L39;
        r3.add(r7);     // Catch: Exception -> L72 Throwable -> L69
    L39:
        r6 = r6 + 1;
    L41:
        if (r3.isEmpty() == true) goto L43;
        this.B = SDKMonitorUtils.a(r3);     // Catch: Throwable -> L69
    L43:
        int r8 = 120;
        this.f4807g = r1.optInt("uploading_interval", 120);     // Catch: Throwable -> L69
        if (this.f4807g < 0) goto L47;
        r8 = this.f4807g;     // Catch: Throwable -> L69
    L47:
        this.f4807g = r8;     // Catch: Throwable -> L69
        int r10 = 100;
        this.f4808h = r1.optInt("once_max_count", 100);     // Catch: Throwable -> L69
        if (this.f4808h < 0) goto L51;
        r10 = this.f4808h;     // Catch: Throwable -> L69
    L51:
        this.f4808h = r10;     // Catch: Throwable -> L69
        this.f4809i = r1.optInt("max_retry_count", 4);     // Catch: Throwable -> L69
        this.f4810j = r1.optInt("report_fail_base_interval", 15);     // Catch: Throwable -> L69
        r1.optInt("log_send_switch", 1);     // Catch: Throwable -> L69
        r1.optLong("more_channel_stop_interval", 1800);     // Catch: Throwable -> L69
        this.y = r1.optBoolean("enable_encrypt", true);     // Catch: Throwable -> L69
        r1.optLong("memory_store_cache_max_count", 2000);     // Catch: Throwable -> L69
        this.w = r1.optBoolean("log_remove_switch", false);     // Catch: Throwable -> L69
    L53:
        if (r9.length() > 0) goto L57;
        this.B = null;     // Catch: Throwable -> L69
        monitor-exit(this);
        return;
    L57:
        JSONObject r11 = r9.optJSONObject(com.bytedance.framwork.core.sdkmonitor.h.f4781b);     // Catch: Throwable -> L69
        if (r11 == null) goto L60;
        this.f4811k = r11.optJSONObject("allow_service_name");     // Catch: Throwable -> L69
        this.f4812l = r11.optJSONObject("allow_log_type");     // Catch: Throwable -> L69
    L60:
        JSONObject r12 = com.bytedance.framwork.core.sdkmonitor.f.a(r9, com.bytedance.framwork.core.sdkmonitor.h.f4782c, com.bytedance.framwork.core.sdkmonitor.h.f4784e);     // Catch: Throwable -> L69
        if (r12 == null) goto L64;
        this.n = r12.optInt("enable_api_error_upload", 0);     // Catch: Throwable -> L69
        this.o = r12.optInt("enable_api_all_upload", 0);     // Catch: Throwable -> L69
        this.p = com.bytedance.framwork.core.sdkmonitor.g.b(r12, "api_block_list");     // Catch: Throwable -> L69
        this.q = com.bytedance.framwork.core.sdkmonitor.g.c(r12, "api_block_list");     // Catch: Throwable -> L69
        this.r = com.bytedance.framwork.core.sdkmonitor.g.b(r12, "api_allow_list");     // Catch: Throwable -> L69
        this.s = com.bytedance.framwork.core.sdkmonitor.g.c(r12, "api_allow_list");     // Catch: Throwable -> L69
    L64:
        if (this.f4804d != null) goto L66;
        d.b.i.a.b.b r13 = new d.b.i.a.b.b(this.f4801a, this.D);     // Catch: Throwable -> L69
        this.f4804d = r13;     // Catch: Throwable -> L69
        r13.f();     // Catch: Throwable -> L69
    L66:
        this.f4804d.o();     // Catch: Throwable -> L69
        monitor-exit(this);
        return;
    L69:
        th = move-exception;
        throw th;
    }

    void k0(boolean r5) {
        if (this.f4806f >= 600) goto L5;
        this.f4806f = 600;
    L5:
        if (r5 == true) goto L9;
        if (c0() == true) goto L9;
        return;
    L9:
        if (com.bytedance.framwork.core.sdkmonitor.j.f(this.f4801a) == true) goto L11;
        return;
    L11:
        monitor-enter(k.class);
        this.f4805e = System.currentTimeMillis();     // Catch: Throwable -> L16
        monitor-exit(k.class);     // Catch: Throwable -> L16
        d.b.i.a.b.h.a.e().f(new g(this));     // Catch: Throwable -> L20
        return;
    L27:
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // d.b.i.a.b.h.b
    public void onTimeEvent(long r3) {
        if (this.f4806f > 0) goto L5;
        return;
    L5:
        k0(false);
    }

    public void y() {
        this.f4803c.a();     // Catch: Throwable -> L4
        this.f4804d.a();     // Catch: Throwable -> L4
        return;
    }

    public void z() {
        this.f4804d.c();
        this.x = true;
    }
}
