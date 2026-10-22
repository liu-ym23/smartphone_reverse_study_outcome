package com.bytedance.applog.v;

import android.content.ContentValues;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.o.h;
import com.bytedance.applog.s.c;
import com.bytedance.applog.util.e;
import com.bytedance.applog.util.n;
import com.bytedance.applog.util.p;
import com.bytedance.applog.w.g;
import com.bytedance.bdinstall.r0;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.common_api.INetworkApi;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f2435a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static JSONObject f2436b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final String[] f2437c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f2438d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static String f2439e = "";

    /* JADX INFO: renamed from: com.bytedance.applog.v.a$a, reason: collision with other inner class name */
    static class C0075a extends com.ss.android.ugc.quota.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f2440a;

        C0075a(boolean r1) {
            this.f2440a = r1;
        }

        @Override // com.ss.android.ugc.quota.a, com.ss.android.ugc.quota.b
        public boolean markAsNewUser() {
            return this.f2440a;
        }

        @Override // com.ss.android.ugc.quota.a, com.ss.android.ugc.quota.b
        public int triggerType() {
            return 0;
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f2441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        byte[] f2442b;

        b(int r1) {
        }
    }

    static {
        f2435a = new String[]{"GET", "POST"};
        f2437c = new String[]{WsConstants.KEY_APP_ID, "version_code", "ab_version", WsConstants.KEY_INSTALL_ID, "device_platform"};
        f2438d = new String[]{"tt_data", "device_platform"};
    }

    public static JSONObject a(String r4, JSONObject r5) {
        boolean r0 = false;
        String r6 = com.bytedance.applog.a.u().a(r4, e.i(r5.toString()), g(false, false, -1, null));     // Catch: Exception -> L5
    L6:
        if (r6 != null) goto L29;
        JSONObject r7 = null;
    L16:
        if (r7 != null) goto L18;
    L20:
        if (r0 == true) goto L22;
        com.bytedance.applog.o.b.d(com.bytedance.applog.r.b.a.s, com.bytedance.applog.r.b.d.A);
        return null;
    L22:
        return r7.optJSONObject("data");
    L18:
        if ("success".equals(r7.optString("message", "")) == false) goto L20;
        r0 = true;
        goto L20
    L29:
        r7 = new JSONObject(r6);     // Catch: JSONException -> L12
        n(r7);     // Catch: JSONException -> L10
    L10:
        e = e;
    L14:
        e.printStackTrace();
    L12:
        e = e;
        r7 = null;
    L5:
        com.bytedance.applog.o.b.d(com.bytedance.applog.r.b.a.s, com.bytedance.applog.r.b.d.p);
        r6 = null;
        goto L6
    }

    public static boolean b(int r1) {
        if (r1 >= 500) goto L5;
    L7:
        return false;
    L5:
        if (r1 >= 600) goto L7;
        return true;
    }

    public static boolean c(int r1) {
        if (404 != r1) goto L5;
        return true;
    L5:
        return false;
    }

    public static JSONObject d(String r7, JSONObject r8) {
        boolean r0 = false;
        HashMap<String, String> r1 = g(false, false, -1, null);
        byte[] r4 = e.i(r8.toString());     // Catch: Throwable -> L16
        String r5 = r8.optString("key");     // Catch: Throwable -> L16
        String r9 = r8.optString("iv");     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r5) == false) goto L6;
    L8:
        boolean r6 = false;
    L9:
        if (r6 == false) goto L14;
        byte[] r10 = com.bytedance.applog.a.u().b(r7, r4, r1);     // Catch: Throwable -> L16
        byte[] r11 = e.b(r10, r5, r9);     // Catch: Throwable -> L16
        if (r11 != null) goto L13;
        String r12 = new String(r10);     // Catch: Throwable -> L16
    L17:
        if (r12 != null) goto L39;
        JSONObject r13 = null;
    L27:
        if (r13 != null) goto L29;
    L31:
        if (r0 == true) goto L33;
        com.bytedance.applog.o.b.d(com.bytedance.applog.r.b.a.r, com.bytedance.applog.r.b.d.A);
        return null;
    L33:
        return r13.optJSONObject("config");
    L29:
        if ("ss_app_log".equals(r13.optString("magic_tag", "")) == false) goto L31;
        r0 = true;
        goto L31
    L39:
        r13 = new JSONObject(r12);     // Catch: JSONException -> L23
        n(r13);     // Catch: JSONException -> L21
    L21:
        e = e;
    L25:
        e.printStackTrace();
    L23:
        e = e;
        r13 = null;
        goto L25
    L13:
        r12 = new String(e.f(r11));     // Catch: Throwable -> L16
        goto L17
    L14:
        r12 = com.bytedance.applog.a.u().a(r7, r4, r1);     // Catch: Throwable -> L16
        goto L17
    L6:
        if (TextUtils.isEmpty(r9) == true) goto L8;
        r6 = true;
    L16:
        com.bytedance.applog.o.b.d(com.bytedance.applog.r.b.a.r, com.bytedance.applog.r.b.d.p);
        r12 = null;
        goto L17
    }

    public static void e(JSONObject r5, boolean r6, com.bytedance.applog.q.b r7) {
        if (r6 == false) goto L16;
        if (com.bytedance.applog.a.m() == false) goto L7;
        r5.put("uid_enable", 1);     // Catch: JSONException -> L26
        boolean r8 = true;
    L9:
        if (com.bytedance.applog.a.C() == false) goto L19;
        r5.put("event_sampling", 1);     // Catch: JSONException -> L26
        com.bytedance.applog.p.e r9 = com.bytedance.applog.o.e.v();     // Catch: JSONException -> L26
        if (r9 == null) goto L19;
        JSONObject r3 = r5.optJSONObject("header");     // Catch: JSONException -> L26
        if (r3 == null) goto L19;
        r3.put("event_sampling_version", r9.d());     // Catch: JSONException -> L26
        r5.put("header", r3);     // Catch: JSONException -> L26
    L19:
        if (r8 == true) goto L21;
        return;
    L21:
        if (com.bytedance.applog.a.n() == false) goto L32;
        String[] r10 = e.d();     // Catch: JSONException -> L26
        if (e.g(r10) == false) goto L33;
        r5.put("key", r10[0]);     // Catch: JSONException -> L26
        r5.put("iv", r10[1]);     // Catch: JSONException -> L26
        return;
    L33:
        return;
    L32:
        return;
    L7:
        r8 = false;
        goto L9
    L16:
        if (r7.t().M() == false) goto L18;
        r5.put("event_filter", 1);     // Catch: JSONException -> L26
        r8 = true;
        goto L19
    L18:
        r8 = false;
    L26:
        e = move-exception;
        n.c("fillKeyIvForEncryptResp", e);
    }

    public static String f(String r6, String[] r7) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return r6;
    L5:
        Uri r8 = Uri.parse(r6);
        HashMap r0 = new HashMap(r7.length);
        int r1 = r7.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L11;
        String r3 = r7[r2];
        String r4 = r8.getQueryParameter(r3);
        if (TextUtils.isEmpty(r4) == true) goto L10;
        r0.put(r3, r4);
    L10:
        r2 = r2 + 1;
        goto L6
    L11:
        Uri.Builder r9 = r8.buildUpon();
        r9.clearQuery();
        Iterator r10 = r0.keySet().iterator();
    L13:
        if (r10.hasNext() == false) goto L16;
        String r5 = (String) r10.next();
        r9.appendQueryParameter(r5, (String) r0.get(r5));
        goto L13
    L16:
        return r9.build().toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static HashMap<String, String> g(boolean r5, boolean r6, int r7, String r8) {
        HashMap<String, String> r0 = new HashMap(2);
        if (com.bytedance.applog.a.n() == false) goto L5;
        String r2 = "application/octet-stream;tt-data=a";
    L6:
        r0.put(INetworkApi.CONTENT_TYPE, r2);
        if (TextUtils.isEmpty(r8) == false) goto L27;
    L21:
        if (r6 == false) goto L29;
    L25:
        return r0;
    L29:
        Pair<String, String> r9 = BDNetworkTagManager.d().a(new C0075a(r5));     // Catch: Throwable -> L26
        if (r9 == null) goto L25;
        r0.put(r9.first, r9.second);     // Catch: Throwable -> L26
        goto L25
    L27:
        JSONObject r3 = new JSONObject(r8);     // Catch: Throwable -> L13
        Iterator<String> r10 = r3.keys();     // Catch: Throwable -> L13
    L10:
        if (r10.hasNext() == false) goto L21;
        String r4 = r10.next();     // Catch: Throwable -> L13
        r0.put(r4, r3.optString(r4));     // Catch: Throwable -> L13
    L13:
        String r11 = "log-encode-type";
        if (r7 != 0) goto L18;
        String r12 = "gzip";
    L16:
        r0.put(r11, r12);
        goto L21
    L18:
        if (r7 == 1) goto L20;
        if (r7 != 2) goto L21;
    L20:
        r0.put("log-encode-type", "zstd");
        r12 = String.valueOf(0);
        r11 = "log-encode-token";
        goto L16
    L5:
        r2 = INetworkApi.DEFAULT_CONTENT_TYPE;
        goto L6
    }

    public static String h(int r1, String r2, HashMap<String, String> r3, byte[] r4) {
        return i(r1, r2, r3, r4, 0).f2441a;
    }

    private static b i(int r8, String r9, HashMap<String, String> r10, byte[] r11, int r12) {
        Closeable r3 = null;
        if (n.f2430b == false) goto L16;
        n.b("http: " + r9, null);
        if (r10 == null) goto L14;
        Iterator<Map.Entry<String, String>> r2 = r10.entrySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L14;
        Map.Entry<String, String> r4 = r2.next();
        if (TextUtils.isEmpty(r4.getKey()) == true) goto L8;
        if (TextUtils.isEmpty(r4.getValue()) == true) goto L8;
        n.b("http headers key:" + r4.getKey() + " value:" + r4.getValue(), null);
    L14:
        if (r11 == null) goto L16;
        n.b("http data length:" + r11.length, null);
    L16:
        b r5 = new b(r12);
        HttpURLConnection r13 = (HttpURLConnection) new URL(r9).openConnection();     // Catch: Throwable -> L84
        if (r8 != 0) goto L21;
        r13.setDoOutput(false);     // Catch: Throwable -> L84
    L24:
        r13.setRequestMethod(f2435a[r8]);     // Catch: Throwable -> L84
        if (r10 != null) goto L27;
    L37:
        r13.setRequestProperty("Accept-Encoding", "gzip");     // Catch: Throwable -> L84
        if (r11 != null) goto L40;
    L43:
        DataOutputStream r14 = null;
    L44:
        int r15 = r13.getResponseCode();     // Catch: Throwable -> L81
        if (r15 != 200) goto L80;
        if (r12 == 0) goto L48;
        InputStream r16 = r13.getInputStream();     // Catch: Throwable -> L81
        if ("gzip".equalsIgnoreCase(r13.getContentEncoding()) == true) goto L66;
    L96:
        ByteArrayOutputStream r17 = new ByteArrayOutputStream();     // Catch: Throwable -> L77
        byte[] r18 = new byte[1024];     // Catch: Throwable -> L75
    L70:
        int r19 = r16.read(r18);     // Catch: Throwable -> L75
        if (r19 == (-1)) goto L73;
        r17.write(r18, 0, r19);     // Catch: Throwable -> L75
        goto L70
    L73:
        r5.f2442b = r17.toByteArray();     // Catch: Throwable -> L75
        ByteArrayOutputStream r20 = r17;
    L74:
        p.b(r14);
        p.b(r3);
        Closeable r21 = r20;
    L89:
        p.b(r16);
        p.b(r21);
        return r5;
    L75:
        th = move-exception;
        r3 = r14;
        th = th;
        BufferedReader r110 = null;
        Closeable r22 = r17;
    L105:
        n.i(th);     // Catch: Throwable -> L93
        if ((th instanceof r0) == true) goto L92;
        p.b(r3);
        p.b(r110);
        r21 = r22;
        goto L89
    L92:
        throw th;     // Catch: Throwable -> L93
    L93:
        th = move-exception;
        p.b(r3);
        p.b(r110);
        p.b(r16);
        p.b(r22);
        throw th;
    L77:
        r0 th = th;
        r110 = null;
    L83:
        r3 = r14;
        th = th;
        r22 = r110;
        goto L105
    L66:
        r16 = new GZIPInputStream(r16);     // Catch: Throwable -> L81
        goto L96
    L48:
        if (r13.getContentLength() >= 10240) goto L61;
        InputStream r111 = r13.getInputStream();     // Catch: Throwable -> L81
        if ("gzip".equalsIgnoreCase(r13.getContentEncoding()) == false) goto L52;
        r110 = new BufferedReader(new InputStreamReader(new GZIPInputStream(r111)));     // Catch: Throwable -> L81
    L100:
        StringBuilder r112 = new StringBuilder(r111.available());     // Catch: Throwable -> L59
    L54:
        String r113 = r110.readLine();     // Catch: Throwable -> L59
        if (r113 == null) goto L57;
        r112.append(r113);     // Catch: Throwable -> L59
        r112.append("\n");     // Catch: Throwable -> L59
        goto L54
    L57:
        r5.f2441a = r112.toString();     // Catch: Throwable -> L59
        JSONObject r114 = new JSONObject(r5.f2441a);     // Catch: Throwable -> L59
        r114.put("Set-Cookie", r13.getHeaderField("Set-Cookie"));     // Catch: Throwable -> L59
        r5.f2441a = r114.toString();     // Catch: Throwable -> L59
    L62:
        r20 = null;
        r16 = null;
        r3 = r110;
    L59:
        th = move-exception;
        r16 = null;
        r3 = r14;
        th = th;
        r22 = null;
        goto L105
    L52:
        r110 = new BufferedReader(new InputStreamReader(r111));     // Catch: Throwable -> L81
        goto L100
    L61:
        n.i(null);     // Catch: Throwable -> L81
        r110 = null;
        goto L62
    L80:
        throw new r0(r15, r13.getResponseMessage());     // Catch: Throwable -> L81
    L40:
        if (r11.length <= 0) goto L43;
        r14 = new DataOutputStream(r13.getOutputStream());     // Catch: Throwable -> L84
        r14.write(r11);     // Catch: Throwable -> L81
        r14.flush();     // Catch: Throwable -> L81
        r14.close();     // Catch: Throwable -> L81
    L81:
        th = th;
        r16 = null;
        r110 = null;
        goto L83
    L27:
        if (r10.isEmpty() == true) goto L37;
        Iterator<Map.Entry<String, String>> r23 = r10.entrySet().iterator();     // Catch: Throwable -> L84
    L30:
        if (r23.hasNext() == false) goto L37;
        Map.Entry<String, String> r115 = r23.next();     // Catch: Throwable -> L84
        if (TextUtils.isEmpty(r115.getKey()) == true) goto L36;
        if (TextUtils.isEmpty(r115.getValue()) == true) goto L36;
        r13.addRequestProperty(r115.getKey(), r115.getValue());     // Catch: Throwable -> L84
    L36:
        n.i(null);     // Catch: Throwable -> L84
        goto L30
    L21:
        if (r8 != 1) goto L23;
        r13.setDoOutput(true);     // Catch: Throwable -> L84
        goto L24
    L23:
        n.i(null);     // Catch: Throwable -> L84
    L84:
        th = th;
        r22 = null;
        r16 = null;
        r110 = null;
        goto L105
    }

    public static byte[] j(int r1, String r2, HashMap<String, String> r3, byte[] r4) {
        return i(r1, r2, r3, r4, 1).f2442b;
    }

    public static int k(String[] r10, byte[] r11, com.bytedance.applog.q.b r12, String[] r13, int r14, String r15) {
        int r0 = r10.length;
        int r2 = 0;
        int r3 = 10;
        JSONObject r5 = null;
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L49;
        String r6 = r10[r4];
        HashMap<String, String> r7 = g(false, true, r14, r15);     // Catch: Throwable -> L30
        if (e.g(r13) == false) goto L15;
        byte[] r8 = com.bytedance.applog.a.u().b(r6, r11, r7);     // Catch: Throwable -> L30
        if (r8 == null) goto L14;
        byte[] r9 = e.b(r8, r13[0], r13[1]);     // Catch: Throwable -> L30
        if (r9 != null) goto L12;
        String r16 = new String(r8);     // Catch: Throwable -> L30
    L16:
        n.e("send log resp: " + r16);     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r16) == true) goto L28;
        JSONObject r17 = new JSONObject(r16);     // Catch: Throwable -> L30
        n(r17);     // Catch: Throwable -> L26
        if ("ss_app_log".equals(r17.optString("magic_tag")) == false) goto L25;
        if ("success".equals(r17.optString("message")) == true) goto L23;
        int r18 = 13;
    L29:
        int r19 = r18;
        r5 = r17;
        r3 = r19;
    L48:
        r4 = r4 + 1;
        goto L3
    L23:
        r5 = r17;
        r3 = 200;
        goto L49
    L25:
        r18 = 12;
    L26:
        th = move-exception;
        r5 = r17;
        th = th;
    L32:
        if ((th instanceof r0) == false) goto L47;
        r0 r20 = th;
        int r21 = r20.a();
        String r22 = r20.getMessage();
        if (TextUtils.isEmpty(r22) == false) goto L36;
    L38:
        int r23 = r21;
    L39:
        n.c("send resultCode: " + r23, th);
        if (r12.t().K() == false) goto L44;
        if (b(r23) == false) goto L44;
    L45:
        r3 = r23;
    L44:
        if (c(r23) == true) goto L45;
        r3 = r23;
        goto L48
    L36:
        if (r22.contains("lateinit property") == false) goto L38;
        r23 = 15;
        goto L39
    L47:
        r3 = 14;
        goto L48
    L28:
        JSONObject r24 = r5;
        r18 = 11;
        r17 = r24;
        goto L29
    L12:
        r16 = new String(e.f(r9));     // Catch: Throwable -> L30
        goto L16
    L14:
        throw new RuntimeException("get encrypted resp failed");     // Catch: Throwable -> L30
    L15:
        r16 = com.bytedance.applog.a.u().a(r6, r11, r7);     // Catch: Throwable -> L30
    L30:
        th = th;
    L49:
        if (r5 == null) goto L82;
        r12.K(r5);
        if (com.bytedance.applog.a.m() == false) goto L54;
        h.o = r5.optLong("uid");
        h.p = r5.optInt("user_type");
        h.q = r5.optInt("user_is_login");
        h.r = r5.optInt("user_is_auth");
    L54:
        if (com.bytedance.applog.a.C() == false) goto L57;
        com.bytedance.applog.o.e.M(com.bytedance.applog.p.e.f(r12.m(), r5.optJSONObject("sampling_list"), com.bytedance.applog.o.e.v()));
    L57:
        if (com.bytedance.applog.a.B() == false) goto L59;
        c.c(r12, r5);
    L59:
        r12.J(r5);
        JSONObject r110 = r5.optJSONObject("blocklist");
        if (r110 == null) goto L82;
        JSONArray r111 = r110.optJSONArray("v1");
        if (r111 == null) goto L64;
        int r112 = r111.length();
    L65:
        HashSet<String> r113 = new HashSet(r112);
        int r114 = 0;
    L66:
        if (r114 >= r112) goto L71;
        String r1 = r111.optString(r114, null);
        if (TextUtils.isEmpty(r1) == true) goto L70;
        r113.add(r1);
    L70:
        r114 = r114 + 1;
        goto L66
    L71:
        JSONArray r115 = r110.optJSONArray("v3");
        if (r115 == null) goto L74;
        int r116 = r115.length();
    L75:
        HashSet<String> r117 = new HashSet(r116);
    L76:
        if (r2 >= r116) goto L81;
        String r118 = r115.optString(r2, null);
        if (TextUtils.isEmpty(r118) == true) goto L80;
        r117.add(r118);
    L80:
        r2 = r2 + 1;
        goto L76
    L81:
        r12.T(r113, r117);
        goto L82
    L74:
        r116 = 0;
        goto L75
    L64:
        r112 = 0;
    L82:
        return r3;
    }

    public static void l(JSONObject r5, String r6) {
        JSONObject r0 = new JSONObject();
        r0.put("header", com.bytedance.applog.a.p());     // Catch: JSONException -> L23
        JSONArray r1 = new JSONArray();     // Catch: JSONException -> L23
        if (r5 == null) goto L6;
        r1.put(r5);     // Catch: JSONException -> L23
    L6:
        r0.put("event_v3", r1);     // Catch: JSONException -> L23
    L7:
        HashMap r7 = new HashMap();
        r7.put(INetworkApi.CONTENT_TYPE, INetworkApi.DEFAULT_CONTENT_TYPE);
        r7.put("Cookie", r6);
        JSONObject r2 = null;
        boolean r3 = true;
        String r8 = h(1, f2439e + "/simulator/mobile/log", r7, e.i(r0.toString()));     // Catch: r0 -> L10
    L12:
        if (TextUtils.isEmpty(r8) == false) goto L29;
        r3 = false;
    L20:
        if (r3 == true) goto L31;
        com.bytedance.applog.a.J(false, r6);
        return;
    L31:
        return;
    L29:
        r2 = new JSONObject(r8);     // Catch: JSONException -> L24
    L15:
        if (r2 == null) goto L20;
        JSONObject r9 = r2.optJSONObject("data");
        if (r9 == null) goto L20;
        r3 = r9.optBoolean("keep", true);
    L10:
        r8 = null;
        goto L12
    }

    public static void m(com.bytedance.applog.w.b r4, g r5, com.bytedance.applog.s.b r6) {
        if (r5.k() == 0) goto L20;
        if (r6 == null) goto L22;
        String r7 = r6.d();
        if (TextUtils.isEmpty(r7) == false) goto L18;
        return;
    L18:
        n.e("trySendForward resp: " + com.bytedance.applog.a.u().a(r7, r5.v, g(false, true, r5.N, r5.O)));     // Catch: Throwable -> L12
    L14:
        r5.q(0);
        if (r4 == null) goto L21;
        ContentValues r8 = new ContentValues();
        r8.put("forward", 0);
        r4.F(r5.E(), r8);
        return;
    L21:
        return;
    L12:
        th = move-exception;
        n.e("trySendForward exception: " + th);
        goto L14
    L22:
        return;
    }

    private static void n(JSONObject r5) {
        long r1 = r5.optLong("server_time");     // Catch: Exception -> L7
        if (r1 <= 0) goto L10;
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L7
        r6.put("server_time", r1);     // Catch: Exception -> L7
        r6.put("local_time", System.currentTimeMillis() / 1000);     // Catch: Exception -> L7
        f2436b = r6;     // Catch: Exception -> L7
        return;
    L10:
        return;
    }
}
