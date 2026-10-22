package com.bytedance.ttnet.clientkey;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.keva.Keva;
import com.bytedance.ttnet.i;
import com.bytedance.ttnet.j.e;
import d.b.h.a.a.h.s.j;
import d.b.h.a.a.h.s.l;
import d.b.r.h0.b;
import d.b.r.h0.c;
import d.b.r.h0.d;
import d.b.r.y;
import java.net.CookieHandler;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ClientKeyManager {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile ClientKeyManager f6290h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Keva f6291i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile boolean f6292j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static boolean f6293k = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static Map<String, String> f6294l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<String> f6295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f6296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f6297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f6298d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f6299e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f6300f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f6301g;

    static {
    }

    private ClientKeyManager() {
        this.f6295a = new CopyOnWriteArrayList();
        this.f6296b = new CopyOnWriteArrayList();
        this.f6297c = "";
        this.f6298d = "";
        this.f6299e = "";
        this.f6300f = "";
        this.f6301g = true;
    }

    private void d(JSONObject r7) {
        int r1 = 0;
        boolean r2 = true;
        if (r7.optInt("client_key_sign_enabled", 0) <= 0) goto L5;
        boolean r0 = true;
    L6:
        f6292j = r0;
        if (f6292j == true) goto L11;
        Logger.debug();
        f6291i.clear();
        return;
    L11:
        if (r7.optInt("rewrite_session_enabled", 1) > 0) goto L14;
        r2 = false;
    L14:
        this.f6301g = r2;
        this.f6295a.clear();
        String r3 = r7.optString("update_host_list", null);
        if (TextUtils.isEmpty(r3) == true) goto L23;
        JSONArray r4 = new JSONArray(r3);
        int r5 = 0;
    L18:
        if (r5 >= r4.length()) goto L23;
        String r6 = r4.getString(r5);
        if (TextUtils.isEmpty(r6) == true) goto L22;
        this.f6295a.add(r6);
    L22:
        r5 = r5 + 1;
    L23:
        this.f6296b.clear();
        String r8 = r7.optString("update_path_list", null);
        if (TextUtils.isEmpty(r8) == true) goto L32;
        JSONArray r9 = new JSONArray(r8);
    L27:
        if (r1 >= r9.length()) goto L39;
        String r10 = r9.getString(r1);
        if (TextUtils.isEmpty(r10) == true) goto L31;
        this.f6296b.add(r10);
    L31:
        r1 = r1 + 1;
        goto L27
    L39:
        return;
    L32:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private static String e(String[] r10, long r11, String r13) {
        if (r10 != null) goto L5;
    L33:
        return null;
    L5:
        if (r10.length < 2) goto L33;
        long r3 = 0;
        if (r11 <= 0) goto L33;
        int r1 = r10.length;
        int r5 = 0;
    L11:
        if (r5 >= r1) goto L18;
        String r7 = r10[r5];
        if (TextUtils.isEmpty(r7) == true) goto L17;
        if (r7.toLowerCase().trim().startsWith("Max-Age=".toLowerCase()) == false) goto L17;
        String[] r12 = r7.split("=");
    L19:
        if (r12 == null) goto L33;
        if (r12.length != 2) goto L33;
        long r2 = Long.parseLong(r12[1]);     // Catch: Throwable -> L34
        if (r2 > 0) goto L27;
        return null;
    L27:
        long r4 = r2 - ((System.currentTimeMillis() - r11) / 1000);     // Catch: Throwable -> L34
        if (r4 <= 0) goto L31;
        r3 = r4;
    L31:
        return r13.replaceFirst(r7.trim(), "Max-Age=" + r3);
    L17:
        r5 = r5 + 1;
        goto L11
    L18:
        r12 = null;
        r7 = null;
        goto L19
    }

    private void f(String r6, String r7) {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("report_time", System.currentTimeMillis() + "");     // Catch: Throwable -> L4
        r0.put("cookie_line", r6);     // Catch: Throwable -> L4
        r0.put("session_id", r7);     // Catch: Throwable -> L4
        r0.put(WsConstants.KEY_CONNECTION_URL, this.f6299e);     // Catch: Throwable -> L4
        i.a("cookie_mismatch", r0);     // Catch: Throwable -> L4
        return;
    }

    public static Map<String, String> getClientKeyHeaders() {
        if (f6291i != null) goto L5;
        return null;
    L5:
        if (f6292j == true) goto L8;
        return null;
    L8:
        if (f6293k == false) goto L12;
        return f6294l;
    L12:
        return j(f6291i.getString("client_key", ""), f6291i.getString("kms_version", ""));
    }

    private void h(String r6) {
        CookieHandler r1 = CookieHandler.getDefault();
        if (r1 != null) goto L24;
        return;
    L24:
        URI r2 = j.b(this.f6299e);     // Catch: Throwable -> L23
        if (r2 != null) goto L8;
        return;
    L8:
        Map<String, List<String>> r3 = r1.get(r2, null);     // Catch: Throwable -> L23
        if (r3 != null) goto L11;
        return;
    L11:
        if (r3.isEmpty() == false) goto L13;
        return;
    L13:
        if (r3.containsKey("Cookie") == false) goto L27;
        String r0 = r3.get("Cookie").toString();     // Catch: Throwable -> L23
        Logger.debug();     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r0) == false) goto L17;
        l(r6, r1, r2);     // Catch: Throwable -> L23
        r0 = "empty";
    L19:
        f(r0, r6);     // Catch: Throwable -> L23
        return;
    L17:
        if (r0.contains(this.f6298d) == true) goto L28;
        l(r6, r1, r2);     // Catch: Throwable -> L23
        goto L19
    L28:
        return;
    L27:
        return;
    }

    private static String i(d r1, String r2) {
        b r3 = r1.c(r2);
        if (r3 != null) goto L5;
        return "";
    L5:
        return ("" + r3.toString()) + "; ";
    }

    private static Map<String, String> j(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L11;
        HashMap r0 = new HashMap();
        r0.put("x-bd-client-key", r2);
        r0.put("x-bd-kmsv", r3);
        return r0;
    L11:
        return null;
    }

    public static ClientKeyManager k() {
        if (f6290h != null) goto L15;
        monitor-enter(ClientKeyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f6290h != null) goto L9;
        f6290h = new ClientKeyManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ClientKeyManager.class);     // Catch: Throwable -> L11
    L15:
        return f6290h;
    }

    private void l(String r2, CookieHandler r3, URI r4) {
        if (this.f6301g == true) goto L5;
        return;
    L5:
        LinkedHashMap r1 = new LinkedHashMap();
        ArrayList r0 = new ArrayList();
        r0.add(r2);
        r1.put("Set-Cookie", r0);
        r3.put(r4, r1);
        Logger.debug();
    }

    private void m(int r2, String r3, String r4, String r5, String r6, String r7, String r8, d r9, String r10) {
        JSONObject r1 = new JSONObject();
        r1.put("origin_sid", r3);
        r1.put(WsConstants.KEY_SESSION_ID, r4);
        r1.put("origin_key", r5);
        r1.put("key", r6);
        r1.put("origin_kms", r7);
        r1.put("kms", r8);
        if (r9 == null) goto L7;
        String r11 = ((i(r9, "x-tt-token") + i(r9, "x-tt-logid")) + i(r9, "x-bd-lanusk")) + i(r9, "x-bd-lanusv");
        if (TextUtils.isEmpty(r11) == true) goto L7;
        r1.put("headers", r11);
    L7:
        i.b("client_key", r1, r2, r10);
    }

    public void a(List<b> r5, y r6) {
        if (f6291i != null) goto L5;
        return;
    L5:
        if (f6292j == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.f6297c) == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(this.f6300f) == true) goto L19;
        Long r0 = Long.valueOf(SystemClock.uptimeMillis());
        r5.add(new b("x-bd-client-key", this.f6297c));
        r5.add(new b("x-bd-kmsv", this.f6300f));
        if (r6 == null) goto L18;
        r6.c0 = SystemClock.uptimeMillis() - r0.longValue();
        r6.i0 = true;
        return;
    L18:
        return;
    }

    public void b(boolean r6) {
        f6293k = r6;
        f6291i = Keva.getRepo("ttnet_client_key_config", 1);     // Catch: Throwable -> L31
    L4:
        Keva r7 = f6291i;
        if (r7 != null) goto L7;
        return;
    L7:
        String r8 = r7.getString("client_key_config", "");
        if (TextUtils.isEmpty(r8) == true) goto L11;
        d(new JSONObject(r8));     // Catch: Throwable -> L32
    L11:
        if (f6292j == true) goto L13;
        return;
    L13:
        String r9 = f6291i.getString("session_id", "");
        long r2 = f6291i.getLong("session_time", 0);
        this.f6299e = f6291i.getString("session_url", "");
        this.f6297c = f6291i.getString("client_key", "");
        String r0 = f6291i.getString("kms_version", "");
        this.f6300f = r0;
        f6294l = j(this.f6297c, r0);
        if (r9.isEmpty() == false) goto L16;
        return;
    L16:
        if (this.f6299e.isEmpty() == true) goto L38;
        String[] r1 = r9.split(";");
        if (r1 == null) goto L24;
        if (r1.length <= 0) goto L24;
        this.f6298d = r1[0].trim();
    L24:
        if (TextUtils.isEmpty(this.f6298d) == false) goto L26;
        return;
    L26:
        String r3 = e(r1, r2, r9);
        if (TextUtils.isEmpty(r3) == true) goto L29;
        r9 = r3;
    L29:
        Logger.debug();
        h(r9);
        return;
    }

    public void c(Object r4) {
        if (f6291i != null) goto L5;
        return;
    L5:
        if (e.c(r4) == false) goto L20;
        JSONObject r5 = e.d(r4);     // Catch: Throwable -> L17
        if (r5 == null) goto L11;
        JSONObject r6 = r5.getJSONObject("data").optJSONObject("client_key_config");     // Catch: Throwable -> L17
    L12:
        if (r6 != null) goto L15;
        Logger.debug();     // Catch: Throwable -> L17
        f6292j = false;     // Catch: Throwable -> L17
        f6291i.clear();     // Catch: Throwable -> L17
        return;
    L15:
        String r1 = r6.toString();     // Catch: Throwable -> L17
        Logger.debug();     // Catch: Throwable -> L17
        f6291i.storeString("client_key_config", r1);     // Catch: Throwable -> L17
        d(r6);     // Catch: Throwable -> L17
        return;
    L11:
        r6 = null;
        goto L12
    L21:
        return;
    }

    public synchronized void g(c r18, d r19) {
        monitor-enter(this);
    L90:
        th = move-exception;
        throw th;
    L5:
        if (f6291i != null) goto L7;
    L88:
        monitor-exit(this);
        return;
    L7:
        if (f6292j == false) goto L88;
        Long r12 = Long.valueOf(SystemClock.uptimeMillis());     // Catch: Throwable -> L90
        URI r1 = null;
        r1 = j.b(r18.G());     // Catch: Throwable -> L93
    L12:
        if (r1 != null) goto L15;
        monitor-exit(this);
        return;
    L15:
        int r3 = 1;
        if (this.f6295a.isEmpty() == true) goto L28;
        Iterator<String> r2 = this.f6295a.iterator();     // Catch: Throwable -> L90
    L19:
        if (r2.hasNext() == false) goto L23;
        if (l.i(r1.getHost(), r2.next()) == false) goto L19;
        boolean r4 = true;
    L24:
        if (r4 == true) goto L28;
        monitor-exit(this);
        return;
    L23:
        r4 = false;
    L28:
        if (this.f6296b.isEmpty() == true) goto L35;
        Iterator<String> r5 = this.f6296b.iterator();     // Catch: Throwable -> L90
    L31:
        if (r5.hasNext() == false) goto L35;
        if (l.i(r1.getPath(), r5.next()) == false) goto L31;
        boolean r6 = true;
    L36:
        if (r6 == true) goto L39;
        monitor-exit(this);
        return;
    L39:
        String r7 = "";
        List<b> r8 = r19.h("Set-Cookie");     // Catch: Throwable -> L90
        if (r8 != null) goto L42;
    L49:
        String r13 = "";
    L50:
        String[] r9 = r13.split(";");     // Catch: Throwable -> L90
        if (r9 != null) goto L53;
    L55:
        String r14 = r7;
        if (TextUtils.isEmpty(r14) == false) goto L59;
        monitor-exit(this);
        return;
    L59:
        Logger.debug();     // Catch: Throwable -> L90
        String r10 = "";
        String r11 = "";
        b r15 = r19.c("x-bd-lanusk");     // Catch: Throwable -> L90
        b r16 = r19.c("x-bd-lanusv");     // Catch: Throwable -> L90
        if (r15 == null) goto L70;
        if (r16 == null) goto L70;
        String r17 = r15.b();     // Catch: Throwable -> L90
        r11 = r16.b();     // Catch: Throwable -> L90
        if (TextUtils.isEmpty(r17) == false) goto L65;
    L68:
        r10 = "";
        r11 = "";
    L74:
        String r110 = r10;
        int r20 = r3;
    L75:
        String r111 = r11;
        if (r20 != 0) goto L102;
    L81:
        String r0 = r111;
    L82:
        this.f6297c = r110;     // Catch: Throwable -> L90
        this.f6300f = r0;     // Catch: Throwable -> L90
        String r21 = r18.G();     // Catch: Throwable -> L90
        this.f6299e = r21;     // Catch: Throwable -> L90
        this.f6298d = r14;     // Catch: Throwable -> L90
        f6291i.storeString("session_url", r21);     // Catch: Throwable -> L90
        f6291i.storeString("session_id", r13);     // Catch: Throwable -> L90
        f6291i.storeString("client_key", this.f6297c);     // Catch: Throwable -> L90
        f6291i.storeString("kms_version", this.f6300f);     // Catch: Throwable -> L90
        f6291i.storeLong("session_time", System.currentTimeMillis());     // Catch: Throwable -> L90
        f6294l = j(this.f6297c, this.f6300f);     // Catch: Throwable -> L90
        if (r18.z() == null) goto L85;
        r18.z().d0 = SystemClock.uptimeMillis() - r12.longValue();     // Catch: Throwable -> L90
    L85:
        Logger.debug();     // Catch: Throwable -> L90
        monitor-exit(this);
        return;
    L102:
        r0 = r111;
        m(r20, this.f6298d, r14, this.f6297c, r110, this.f6300f, r111, r19, r1.getPath());     // Catch: Throwable -> L94
        goto L82
    L65:
        if (TextUtils.isEmpty(r11) == true) goto L68;
        r110 = r17;
        r20 = 0;
    L70:
        if (r14.equals(this.f6298d) == false) goto L73;
        r10 = this.f6297c;     // Catch: Throwable -> L90
        r11 = this.f6300f;     // Catch: Throwable -> L90
        r3 = 2;
        goto L74
    L73:
        r3 = 3;
        goto L74
    L53:
        if (r9.length <= 0) goto L55;
        r7 = r9[0].trim();     // Catch: Throwable -> L90
        goto L55
    L42:
        if (r8.isEmpty() == true) goto L49;
        Iterator<b> r22 = r8.iterator();     // Catch: Throwable -> L90
    L45:
        if (r22.hasNext() == false) goto L49;
        String r23 = r22.next().b().trim();     // Catch: Throwable -> L90
        if (r23.toLowerCase().startsWith("sessionid=") == false) goto L45;
        r13 = r23;
    L35:
        r6 = false;
        goto L36
    }
}
