package com.bytedance.apm.t.c;

import android.text.TextUtils;
import com.bytedance.apm.util.h;
import com.bytedance.apm.util.l;
import com.bytedance.apm.util.o;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends com.bytedance.apm.t.a<com.bytedance.apm.t.d.a> {
    private static long v = 30000;
    private static boolean w = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f1967g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1968h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile int f1969i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile List<String> f1970j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<Pattern> f1971k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<String> f1972l;
    private List<Pattern> m;
    private List<String> n;
    private List<String> o;
    private List<String> p;
    private boolean q;
    private boolean r;
    private double s;
    private boolean t;
    private c u;

    static /* synthetic */ class a {
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f1973a = null;

        static {
            f1973a = new d(null);
        }

        static /* synthetic */ d a() {
            return f1973a;
        }
    }

    static {
    }

    private d() {
        this.f1968h = true;
        this.q = true;
        this.r = false;
    }

    /* synthetic */ d(a r1) {
        this();
    }

    private boolean C(String r2) {
        return o.c(r2, this.f1972l, this.m);
    }

    private boolean D(String r2) {
        return o.c(r2, this.f1970j, this.f1971k);
    }

    public static boolean E() {
        if (w == true) goto L6;
        return false;
    L6:
        if (com.bytedance.apm.d.g() != 0) goto L9;
        return false;
    L9:
        if ((System.currentTimeMillis() - com.bytedance.apm.d.g()) <= v) goto L11;
        return false;
    L11:
        return true;
    }

    private boolean F(String r1) {
        return o.b(r1, this.n);
    }

    public static void G(boolean r0) {
        w = r0;
    }

    public static void H(long r0) {
        v = r0;
    }

    private void p(JSONObject r5, String r6) {
        if (r5 == null) goto L32;
    L27:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (TextUtils.equals(r6, "api_all") == false) goto L9;
        String r7 = "api_all_v2";
    L7:
        r5.put("net_log_type", r7);     // Catch: Exception -> L27
    L13:
        if (A() == false) goto L19;
        if (B() == false) goto L19;
        String r8 = "01";
    L17:
        r5.put("inject_tracelog", r8);     // Catch: Exception -> L27
    L23:
        double r0 = this.s;     // Catch: Exception -> L27
        if (r0 == 0.0d) goto L33;
        r5.put("enable_base_api_all", r0);     // Catch: Exception -> L27
        return;
    L33:
        return;
    L19:
        if (u() != 1) goto L23;
        if (B() == false) goto L23;
        r8 = "02";
        goto L17
    L9:
        if (TextUtils.equals(r6, "api_error") == false) goto L13;
        r7 = "api_error_v2";
        goto L7
    }

    private void r(JSONObject r3) {
        s(this.o, r3, "requestHeader");
        s(this.p, r3, "responseHeader");
    }

    private void s(List<String> r5, JSONObject r6, String r7) {
        if (r5 == null) goto L31;
        if (r6 == null) goto L32;
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (TextUtils.isEmpty(r7) == true) goto L33;
        String r4 = r6.optString(r7);     // Catch: JSONException -> L16 Exception -> L19
        if (TextUtils.isEmpty(r4) == true) goto L34;
        JSONObject r0 = new JSONObject(r4);     // Catch: JSONException -> L16 Exception -> L19
        JSONObject r8 = new JSONObject();     // Catch: JSONException -> L16 Exception -> L19
        Iterator<String> r1 = r0.keys();     // Catch: JSONException -> L16 Exception -> L19
    L10:
        if (r1.hasNext() == false) goto L14;
        String r2 = r1.next();     // Catch: JSONException -> L16 Exception -> L19
        if (r5.contains(r2) == false) goto L10;
        r8.put(r2, r0.opt(r2));     // Catch: JSONException -> L16 Exception -> L19
        goto L10
    L14:
        r6.put(r7, r8.toString());     // Catch: JSONException -> L16 Exception -> L19
    L35:
        return;
    L34:
        return;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L19
        return;
    L33:
        return;
    L32:
        return;
    }

    public static d t() {
        return b.a();
    }

    private boolean w(String r5, JSONObject r6) {
        if (A() == false) goto L5;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == false) goto L13;
        int r7 = 1;
    L14:
        boolean r0 = com.bytedance.apm.d0.c.f("smart_traffic");
        if (r0 == false) goto L24;
        r7 = r7 | 4;
    L24:
        r6.put("hit_rules", r7);     // Catch: JSONException -> L23
    L18:
        if (r4 == true) goto L26;
        if (r0 == false) goto L22;
        return true;
    L22:
        return false;
    L26:
        return true;
    L13:
        r7 = 0;
        goto L14
    L5:
        if (this.f1967g != 0) goto L10;
        if (C(r5) == true) goto L10;
        r4 = false;
        goto L11
    }

    private void x(com.bytedance.apm.t.d.a r9) {
        String r0 = r9.f1977d;
        if (F(r0) == false) goto L5;
        return;
    L5:
        if (l.b(com.bytedance.apm.d.h()) == true) goto L10;
        if (this.t == true) goto L10;
        return;
    L10:
        if (z(r9.f1981h) == true) goto L12;
    L14:
        String r4 = r9.f1974a;
        JSONObject r5 = r9.c();
        h.a(r5, r9.f1981h);
        if (r5 != null) goto L17;
        return;
    L17:
        boolean r3 = true;
        if (TextUtils.equals(r4, "api_all") == false) goto L28;
        if (A() == false) goto L24;
        w(r0, r5);
    L22:
        boolean r7 = r3;
    L35:
        if (this.q == false) goto L37;
        p(r5, r9.f1974a);
    L37:
        r(r5);
        if (this.u != null) goto L40;
    L44:
        l(r4, r4, r5, r7, true);
        return;
    L40:
        if ("api_all".equals(r4) == false) goto L44;
        if (r9.f1981h.optBoolean("download", false) == true) goto L44;
        this.u.a(r0, r9.f1981h);
        goto L44
    L24:
        if (D(r0) == true) goto L33;
        r7 = w(r0, r5);
    L33:
        r7 = false;
        goto L35
    L28:
        if (TextUtils.equals(r4, "api_error") == false) goto L33;
        if (this.f1969i == 1) goto L22;
        r3 = false;
        goto L22
    L12:
        if (this.r == true) goto L14;
    }

    private boolean z(JSONObject r2) {
        if (r2 != null) goto L12;
        return false;
    L12:
        String r1 = r2.optString("cronet_internal_error_code");     // Catch: Exception -> L11
        if ("11".equals(r2.optString("cronet_error_code")) == false) goto L14;
        if ("-999".equals(r1) == false) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L16:
        return false;
    }

    public boolean A() {
        if (this.q == true) goto L5;
    L7:
        return false;
    L5:
        if (this.s == 0.0d) goto L7;
        return true;
    }

    public boolean B() {
        return this.f1968h;
    }

    public void I(boolean r1) {
        this.t = r1;
    }

    public void J(c r1) {
        this.u = r1;
    }

    @Override // com.bytedance.apm.t.a
    protected /* bridge */ /* synthetic */ boolean d(com.bytedance.apm.t.b r1) {
        return q((com.bytedance.apm.t.d.a) r1);
    }

    @Override // com.bytedance.apm.t.a
    protected /* bridge */ /* synthetic */ void f(com.bytedance.apm.t.b r1) {
        v((com.bytedance.apm.t.d.a) r1);
    }

    @Override // com.bytedance.apm.t.a
    protected /* bridge */ /* synthetic */ void i(com.bytedance.apm.t.b r1) {
        y((com.bytedance.apm.t.d.a) r1);
    }

    @Override // com.bytedance.apm.t.a, com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject r4, boolean r5) {
        JSONObject r6 = o.a(r4, "network_image_modules");
        if (r6 == null) goto L14;
        JSONObject r7 = o.a(r6, "network");
        if (r7 == null) goto L10;
        this.f1970j = o.d(r7, "api_block_list");
        this.f1971k = o.g(r7, "api_block_list");
        this.f1972l = o.e(r7, "api_allow_list");
        this.m = o.f(r7, "api_allow_list");
        boolean r1 = false;
        this.f1967g = r7.optInt("enable_api_all_upload", 0);
        this.f1968h = r7.optBoolean("enable_trace_log", true);
        this.f1969i = r7.optInt("enable_api_error_upload", 1);
        if (r7.optInt("enable_cancel_error_report") != 1) goto L9;
        r1 = true;
    L9:
        this.r = r1;
        this.o = o.e(r7, "request_allow_header");
        this.p = o.e(r7, "response_allow_header");
        this.s = r7.optDouble("enable_base_api_all", 0.0d);
    L10:
        JSONObject r8 = o.a(r6, "image");
        if (r8 == null) goto L15;
        this.n = o.e(r8, "image_allow_list");
        return;
    L15:
        return;
    }

    protected boolean q(com.bytedance.apm.t.d.a r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (TextUtils.isEmpty(r1.f1977d) == true) goto L6;
        return true;
    }

    public int u() {
        return this.f1967g;
    }

    protected void v(com.bytedance.apm.t.d.a r1) {
        x(r1);
    }

    protected void y(com.bytedance.apm.t.d.a r1) {
        if (com.bytedance.apm.t.a.k() == true) goto L5;
        boolean r0 = true;
    L6:
        r1.g(r0);     // Catch: JSONException -> L11
        if (E() == false) goto L9;
        r1.h();     // Catch: JSONException -> L11
    L9:
        r1.f("ttnet");     // Catch: JSONException -> L11
        return;
    L5:
        r0 = false;
    }
}
