package d.b.h.a.a.h.r;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import d.b.h.a.a.h.s.k;
import d.b.h.a.a.h.s.l;
import d.b.r.h0.c;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000j.f0;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static volatile b n;
    private static boolean o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f13716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f13717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f13718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f13719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f13720e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f13721f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f13722g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f13723h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<String> f13724i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<String> f13725j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Context f13726k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f13727l;
    private d.b.h.a.a.h.r.a m;

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f13728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f13729b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f13730c;

        a(b r1, String r2, String r3, String r4) {
            this.f13728a = r2;
            this.f13729b = r3;
            this.f13730c = r4;
        }
    }

    /* JADX INFO: renamed from: d.b.h.a.a.h.r.b$b, reason: collision with other inner class name */
    public interface InterfaceC0362b {
        void a(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11);
    }

    static {
    }

    private b() {
        this.f13716a = "";
        this.f13717b = "";
        this.f13718c = "";
        this.f13719d = "";
        this.f13720e = "";
        this.f13721f = "";
        this.f13722g = "";
        this.f13724i = new ArrayList();
        this.f13725j = new ArrayList();
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private boolean b(c r5, c.a r6) {
        if (TextUtils.isEmpty(r5.A()) == false) goto L6;
        return false;
    L6:
        if ("/get_domains/v5/".equals(r5.A()) == false) goto L8;
        return true;
    L8:
        Iterator<String> r4 = this.f13724i.iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        if (l.i(r5.A(), r4.next()) == false) goto L10;
        boolean r7 = true;
    L15:
        if (r7 == true) goto L17;
        return false;
    L17:
        k r8 = new k(r5.G());
        r8.b("okhttp_version", "4.2.228.16-pico");
        r8.b("use_store_region_cookie", LocationInfoConst.ALLOW_USE_LOCATION);
        r6.h(r8.c());
        return true;
    L14:
        r7 = false;
        goto L15
    }

    private boolean e(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return false;
    L5:
        Iterator<String> r2 = this.f13724i.iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        if (l.i(r3, r2.next()) == false) goto L7;
        return true;
    L12:
        return false;
    }

    private a f(List<String> r10) {
        if (r10 != null) goto L5;
    L31:
        return null;
    L5:
        if (r10.isEmpty() == true) goto L31;
        if (o == false) goto L10;
        String r1 = "store-region=";
        String r2 = "store-region-src=";
    L11:
        Iterator<String> r11 = r10.iterator();
        String r3 = "";
        String r4 = "";
        String r5 = r4;
    L13:
        if (r11.hasNext() == false) goto L24;
        String r6 = r11.next();
        if (r6.toLowerCase().startsWith(r1) == true) goto L16;
        if (r6.toLowerCase().startsWith(r2) == true) goto L19;
        if (r6.toLowerCase().startsWith("region_legacy_user=") == false) goto L13;
        r5 = r6;
        goto L13
    L19:
        r4 = r6;
        goto L13
    L16:
        r3 = r6;
        goto L13
    L24:
        if (TextUtils.isEmpty(r3) == false) goto L26;
        return null;
    L26:
        String r12 = g(r3);
        if (r12.isEmpty() == false) goto L30;
        return null;
    L30:
        return new a(this, r12, g(r4), g(r5));
    L10:
        r1 = "store-country-code=";
        r2 = "store-country-code-src=";
        goto L11
    }

    private String g(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return "";
    L5:
        String[] r2 = r3.split(";");
        if (r2 != null) goto L8;
    L15:
        return "";
    L8:
        if (r2.length <= 0) goto L15;
        String[] r4 = r2[0].trim().split("=");
        if (r4 == null) goto L15;
        if (r4.length != 2) goto L15;
        return r4[1];
    }

    private static String h(Map<String, List<String>> r5, String r6) {
        if (r5 != null) goto L5;
    L18:
        return "";
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L18;
        List<String> r1 = null;
        Iterator<String> r2 = r5.keySet().iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        String r3 = r2.next();
        if (r6.equalsIgnoreCase(r3) == false) goto L9;
        r1 = r5.get(r3);
    L13:
        if (r1 == null) goto L18;
        if (r1.size() <= 0) goto L18;
        return r1.get(r1.size() - 1);
    }

    private String k(String r4, String r5, boolean r6) {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        r1.put(WsConstants.KEY_CONNECTION_URL, r5);     // Catch: JSONException -> L5
        r1.put("logId", r4);     // Catch: JSONException -> L5
        r0.put("tnc", r6);     // Catch: JSONException -> L5
        r0.put("base", r1);     // Catch: JSONException -> L5
        r0.put("report_time", System.currentTimeMillis());     // Catch: JSONException -> L5
        r0.put("store_region", this.f13716a);     // Catch: JSONException -> L5
        r0.put("source", this.f13717b);     // Catch: JSONException -> L5
        r0.put("region_legacy_user", this.f13718c);     // Catch: JSONException -> L5
        r0.put("local", this.f13720e);     // Catch: JSONException -> L5
    L8:
        return r0.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public static String l() {
        return "ttnet_store_region";
    }

    public static b n() {
        if (n != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (n != null) goto L9;
        n = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return n;
    }

    public static boolean o() {
        return o;
    }

    private void q() {
        SharedPreferences r0 = a(this.f13726k, "ttnet_store_region", 0);
        this.f13716a = r0.getString("store_region", "");
        this.f13717b = r0.getString("store_region_src", "");
        this.f13718c = r0.getString("region_legacy_user", "");
        this.f13719d = r0.getString("store_sec_uid", "");
        this.f13721f = r0.getString("update_region_info", "");
        this.f13723h = r0.getBoolean("received_region_config", false);
        if (TextUtils.isEmpty(this.f13716a) == true) goto L5;
    L7:
        this.m.onStoreIdcChanged("", this.f13716a, this.f13717b, this.f13718c, this.f13719d, "");
        Logger.debug();
        return;
    L5:
        if (TextUtils.isEmpty(this.f13720e) == true) goto L7;
        this.f13716a = this.f13720e;
        this.f13717b = "local";
        goto L7
    }

    public void c(Map<String, String> r2) {
        if (this.f13727l == false) goto L12;
        if (r2 != null) goto L7;
        return;
    L7:
        if (this.f13723h == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(this.f13722g) == true) goto L14;
        r2.put("x-tt-app-init-region", this.f13722g);
        return;
    L14:
        return;
    }

    public c d(c r7) {
        if (this.f13727l == true) goto L5;
    L44:
        return null;
    L5:
        if (TextUtils.isEmpty(r7.w()) == true) goto L44;
        if (r7.L() == false) goto L10;
        return null;
    L10:
        boolean r0 = false;
        Iterator<String> r2 = this.f13725j.iterator();
    L11:
        boolean r4 = true;
        if (r2.hasNext() == false) goto L16;
        if (l.i(r7.w(), r2.next()) == false) goto L11;
        r0 = true;
    L16:
        ArrayList r3 = new ArrayList();
        if (this.f13723h == false) goto L19;
    L21:
        r4 = r0;
    L22:
        if (r4 == true) goto L25;
        return null;
    L25:
        if (r7.v() == null) goto L27;
        r3.addAll(r7.v());
    L27:
        c.a r1 = r7.O();
        if (b(r7, r1) == false) goto L32;
    L29:
        r1.b(r3);
        return r1.a();
    L32:
        if (this.f13716a.isEmpty() == true) goto L35;
        String r8 = this.f13716a;
    L39:
        if (TextUtils.isEmpty(r8) == true) goto L42;
        r3.add(new d.b.r.h0.b("x-tt-store-region", r8));
    L42:
        if (TextUtils.isEmpty(this.f13717b) == true) goto L29;
        r3.add(new d.b.r.h0.b("x-tt-store-region-src", this.f13717b));
        goto L29
    L35:
        if (this.f13720e.isEmpty() == true) goto L37;
        r8 = this.f13720e;
        goto L39
    L37:
        r8 = "";
        goto L39
    L19:
        if (TextUtils.isEmpty(this.f13722g) == true) goto L21;
        r3.add(new d.b.r.h0.b("x-tt-app-init-region", this.f13722g));
        goto L22
    }

    public JSONObject i() {
        if (this.f13727l == true) goto L6;
        return null;
    L6:
        JSONObject r0 = new JSONObject();
        r0.put("region", this.f13716a);     // Catch: JSONException -> L9
        r0.put("source", this.f13717b);     // Catch: JSONException -> L9
        r0.put("local_region", this.f13720e);     // Catch: JSONException -> L9
        r0.put("update_region", this.f13721f);     // Catch: JSONException -> L9
    L11:
        return r0;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public String j() {
        return this.f13716a;
    }

    public void m(String r6, String r7, String r8, Context r9, d.b.h.a.a.h.r.a r10) {
        Logger.debug();
        if (TextUtils.isEmpty(r7) == true) goto L41;
        if (r9 == null) goto L42;
        if (r10 == null) goto L45;
        JSONObject r0 = new JSONObject(r7);     // Catch: JSONException -> L30
        JSONArray r11 = r0.optJSONArray("update_store_idc_path_list");     // Catch: JSONException -> L30
        int r1 = 0;
        int r2 = 0;
    L9:
        if (r2 >= r11.length()) goto L14;
        String r3 = r11.getString(r2);     // Catch: JSONException -> L30
        if (TextUtils.isEmpty(r3) == true) goto L13;
        this.f13724i.add(r3);     // Catch: JSONException -> L30
    L13:
        r2 = r2 + 1;     // Catch: JSONException -> L30
        goto L9
    L14:
        JSONArray r12 = r0.optJSONArray("add_store_idc_host_list");     // Catch: JSONException -> L30
    L16:
        if (r1 >= r12.length()) goto L21;
        String r4 = r12.getString(r1);     // Catch: JSONException -> L30
        if (TextUtils.isEmpty(r4) == true) goto L20;
        this.f13725j.add(r4);     // Catch: JSONException -> L30
    L20:
        r1 = r1 + 1;     // Catch: JSONException -> L30
        goto L16
    L21:
        this.f13726k = r9;     // Catch: JSONException -> L30
        this.m = r10;     // Catch: JSONException -> L30
        if (TextUtils.isEmpty(r6) == true) goto L25;
        this.f13720e = r6.toLowerCase();     // Catch: JSONException -> L30
    L25:
        if (this.f13725j.isEmpty() == false) goto L27;
        return;
    L27:
        if (this.f13724i.isEmpty() == true) goto L44;
        this.f13727l = true;     // Catch: JSONException -> L30
        this.f13722g = r8;     // Catch: JSONException -> L30
        q();     // Catch: JSONException -> L30
        return;
    L44:
        return;
    L30:
        e = move-exception;
        e.printStackTrace();
        return;
    L45:
        return;
    L42:
        return;
    }

    public boolean p() {
        return this.f13727l;
    }

    public void r(String r1, String r2, String r3, String r4, String r5, String r6) {
        if (this.f13726k != null) goto L5;
        return;
    L5:
        if (this.f13727l == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r3) == false) goto L13;
        return;
    L13:
        if (this.f13716a.equalsIgnoreCase(r2) == true) goto L15;
    L19:
        this.f13719d = r5;
        this.f13716a = r2;
        this.f13717b = r3;
        this.f13718c = r4;
        Logger.debug();
        SharedPreferences.Editor r7 = a(this.f13726k, "ttnet_store_region", 0).edit();
        r7.putString("store_region", this.f13716a);
        r7.putString("store_region_src", this.f13717b);
        r7.putString("store_sec_uid", this.f13719d);
        r7.apply();
        return;
    L15:
        if (this.f13717b.equalsIgnoreCase(r3) == false) goto L19;
        if (this.f13719d.equalsIgnoreCase(r5) == false) goto L19;
    }

    public void s() {
        if (this.f13723h == true) goto L6;
        this.f13723h = true;
        SharedPreferences.Editor r3 = a(this.f13726k, "ttnet_store_region", 0).edit();
        r3.putBoolean("received_region_config", true);
        r3.apply();
        return;
    }

    public void t(HttpURLConnection r19, byte[] r20, InterfaceC0362b r21) {
        if (r19 != null) goto L5;
        return;
    L5:
        if (this.f13727l == true) goto L8;
        return;
    L8:
        if (e(r19.getURL().getPath()) == true) goto L10;
        return;
    L10:
        Map<String, List<String>> r2 = r19.getHeaderFields();
        List<String> r3 = r2.get("Set-Cookie");
        if (r3 != null) goto L13;
    L14:
        r3 = r2.get("Set-Cookie".toLowerCase());
    L15:
        a r4 = f(r3);
        String r0 = h(r2, "x-tt-with-tnc");
        String r5 = "";
        if (TextUtils.isEmpty(r0) == false) goto L18;
    L23:
        String r14 = "";
    L24:
        if (r4 == null) goto L26;
    L28:
        if (r4 != null) goto L30;
        r4 = new a(this, "", "", "");
    L30:
        String r16 = h(r2, "x-tt-store-sec-uid");
        String r1 = h(r2, "x-tt-logid");
        String r11 = h(r2, "x-tt-tnc-attr");
        String r12 = h(r2, "x-ss-etag");
        String r13 = h(r2, "x-tt-tnc-config");
        JSONObject r6 = new JSONObject();
        r5 = r19.getURL().getPath();     // Catch: JSONException -> L33
        r6.put(WsConstants.KEY_CONNECTION_URL, r19.getURL().getHost() + r5);     // Catch: JSONException -> L33
        r6.put("store_region", r4.f13728a + "," + r4.f13729b);     // Catch: JSONException -> L33
        r6.put("region_legacy_user", r4.f13730c);     // Catch: JSONException -> L33
        r6.put("logId", r1);     // Catch: JSONException -> L33
    L35:
        r21.a(r5, r4.f13728a, r4.f13729b, r4.f13730c, r11, r12, r13, r14, r6.toString(), r16, r1);
        return;
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L35
    L26:
        if (TextUtils.isEmpty(r14) == false) goto L28;
        return;
    L18:
        if (r0.equals(LocationInfoConst.ALLOW_USE_LOCATION) == false) goto L23;
        r14 = "{\"data\": " + new JSONObject(new String(r20)).getString("tnc_data") + "}";     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L13:
        if (r3.isEmpty() == false) goto L15;
        goto L14
    }

    public void u(f0 r21, String r22, byte[] r23) {
        if (this.f13727l == true) goto L49;
        return;
    L49:
        URI r3 = l.l(r22);     // Catch: Exception -> L46
        String r4 = r3.getHost() + r3.getPath();     // Catch: Exception -> L46
        if (r3 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r3.getPath()) == false) goto L11;
        return;
    L11:
        if (e(r3.getPath()) == true) goto L13;
        return;
    L13:
        a r5 = f(r21.E("Set-Cookie"));
        String r6 = r21.A("x-ss-etag");
        String r7 = r21.A("x-tt-tnc-attr");
        String r0 = r21.A("x-tt-with-tnc");
        JSONObject r8 = null;
        if (TextUtils.isEmpty(r0) == false) goto L16;
    L21:
        boolean r1 = false;
        if (r5 != null) goto L26;
        if (r8 == null) goto L26;
        this.m.b(r8, r6, r7, false);
        return;
    L26:
        if (r5 != null) goto L28;
        return;
    L28:
        Logger.debug();
        boolean r10 = true;
        boolean r9 = !this.f13716a.equals(r5.f13728a);
        String r11 = r21.A("x-tt-store-sec-uid");
        if (r11 != null) goto L31;
        r11 = "";
    L31:
        SharedPreferences.Editor r12 = a(this.f13726k, "ttnet_store_region", 0).edit();
        if (this.f13716a.equals(r5.f13728a) == true) goto L34;
    L37:
        String r2 = r5.f13728a;
        this.f13716a = r2;
        this.f13717b = r5.f13729b;
        this.f13719d = r11;
        r12.putString("store_region", r2);
        r12.putString("store_region_src", this.f13717b);
        r12.putString("store_sec_uid", this.f13719d);
        r1 = true;
    L39:
        if (this.f13718c.equals(r5.f13730c) == true) goto L41;
        String r13 = r5.f13730c;
        this.f13718c = r13;
        r12.putString("region_legacy_user", r13);
    L42:
        Logger.debug();
        boolean r14 = this.m.b(r8, r6, r7, r9);
        if (r10 == false) goto L52;
        String r15 = r21.A("x-tt-logid");
        String r16 = r3.getPath() + "," + r15 + "," + r5.f13728a + "," + r5.f13729b;
        this.f13721f = r16;
        r12.putString("update_region_info", r16);
        r12.apply();
        this.m.a(k(r15, r4, r14), "store_idc");
        this.m.onStoreIdcChanged("", this.f13716a, this.f13717b, this.f13718c, this.f13719d, r15);
        return;
    L52:
        return;
    L41:
        r10 = r1;
        goto L42
    L34:
        if (this.f13717b.equals(r5.f13729b) == false) goto L37;
        if (r11.equals(this.f13719d) == true) goto L39;
    L16:
        if (r0.equals(LocationInfoConst.ALLOW_USE_LOCATION) == false) goto L21;
        r8 = new JSONObject(new String(r23)).getJSONObject("tnc_data");     // Catch: JSONException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
    }
}
