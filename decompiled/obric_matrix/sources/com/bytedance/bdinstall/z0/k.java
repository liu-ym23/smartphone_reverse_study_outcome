package com.bytedance.bdinstall.z0;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.bdinstall.h0;
import com.bytedance.bdinstall.i0;
import com.bytedance.bdinstall.v0;
import com.bytedance.common.wschannel.WsConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class k implements com.bytedance.bdinstall.x0.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, d> f2922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f2924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bytedance.bdinstall.r f2925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final Context f2926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final i0 f2927f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final i f2928g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f2929h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private JSONObject f2930i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.bytedance.bdinstall.c1.i f2931j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f2932k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AtomicBoolean f2933l;
    private int m;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ k f2934f;

        a(k r1) {
            this.f2934f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2934f.u();
        }
    }

    public k(Context r3, i0 r4, com.bytedance.bdinstall.r r5) {
        this.f2922a = new LinkedHashMap(32);
        this.f2923b = false;
        this.f2924c = new Object();
        this.f2929h = false;
        this.f2933l = new AtomicBoolean(false);
        this.m = 0;
        this.f2926e = r3;
        this.f2925d = r5;
        this.f2927f = r4;
        this.f2930i = new JSONObject();
        this.f2928g = new i(r4);
        this.f2931j = d(r3, r5);
        com.bytedance.bdinstall.t.e(new a(this));
    }

    private void A(com.bytedance.bdinstall.r r3) {
        r3.c(this.f2926e).edit().putLong("register_time", 0).apply();
    }

    private void b() {
    L3:
        if (this.f2929h == true) goto L8;
        this.f2924c.wait();     // Catch: InterruptedException -> L6
    L6:
        e = move-exception;
        com.bytedance.bdinstall.q.i(e);
        goto L3
    }

    private com.bytedance.bdinstall.c1.i d(Context r2, com.bytedance.bdinstall.r r3) {
        com.bytedance.bdinstall.b1.c r1 = (com.bytedance.bdinstall.b1.c) com.bytedance.bdinstall.b1.e.a(com.bytedance.bdinstall.b1.c.class);
        com.bytedance.bdinstall.c1.j r0 = new com.bytedance.bdinstall.c1.j(r2, r3.c(r2));
        if (r1 != null) goto L5;
        return r0;
    L5:
        return (com.bytedance.bdinstall.c1.i) r1.b(com.bytedance.bdinstall.c1.i.class, r0);
    }

    @WorkerThread
    private boolean e(Context r5, com.bytedance.bdinstall.r r6) {
        if (this.f2927f.c() == true) goto L6;
        com.bytedance.bdinstall.q.a("disable OneKeyMigrateDetect");
        return false;
    L6:
        com.bytedance.bdinstall.migrate.a r0 = new com.bytedance.bdinstall.migrate.a(r5);
        boolean r1 = r0.e();
        com.bytedance.bdinstall.q.a("is one key migrate：" + r1);
        if (r1 == false) goto L9;
        com.bytedance.bdinstall.migrate.a.h(r5, i(), true);
        r.b(r5, this.f2927f, r6);
    L9:
        r0.a();
        return r1;
    }

    private String f() {
        return com.bytedance.bdinstall.d1.h.a(this.f2926e).getString("clientudid", null);
    }

    private String k() {
        return this.f2931j.b("install_id");
    }

    private String m() {
        return com.bytedance.bdinstall.d1.h.a(this.f2926e).getString("openudid", null);
    }

    private String o() {
        return this.f2931j.b("ssid");
    }

    private void v(com.bytedance.bdinstall.b1.a r4, String r5, String r6) {
        String r0 = r4.c();
        JSONObject r1 = new JSONObject();
        r1.put("old_id", r6);
        r1.put("new_id", r5);
        if (this.f2925d.e() == true) goto L5;
        r1.put("openudid", r4.b(true));
    L5:
        r1.put("clientudid", r0);
        com.bytedance.bdinstall.z r3 = this.f2927f.w();
        if (r3 == null) goto L9;
        r3.onEvent("did_change", r1);
        return;
    }

    private boolean w(d r3) {
        if (v0.j(this.f2927f.t()) == false) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (com.bytedance.bdinstall.q.b() == false) goto L11;
        com.bytedance.bdinstall.q.a("needSyncFromSub " + r3 + " " + r2);
    L11:
        return r2;
    L5:
        if (r3.f2916d == false) goto L7;
        r2 = true;
        goto L9
    }

    public void B() {
        if (this.f2933l.getAndSet(true) == true) goto L6;
        com.bytedance.bdinstall.c1.f.b(this.f2926e, this.f2925d, this.f2927f);
        return;
    }

    public void C(JSONObject r1, com.bytedance.bdinstall.r r2) {
        this.f2928g.b(r1, r2);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public boolean D(String r4, @Nullable Object r5) {
        Object r0 = g().opt(r4);
        if (r5 != null) goto L5;
    L6:
        if (r5 != null) goto L19;
        if (r0 == null) goto L19;
    L8:
        monitor-enter(this);
        JSONObject r1 = this.f2930i;     // Catch: Throwable -> L11 JSONException -> L13
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L11 JSONException -> L13
        v0.c(r2, r1);     // Catch: Throwable -> L11 JSONException -> L13
        r2.put(r4, r5);     // Catch: Throwable -> L11 JSONException -> L13
        this.f2930i = r2;     // Catch: Throwable -> L11 JSONException -> L13
    L15:
        monitor-exit(this);     // Catch: Throwable -> L11
        boolean r3 = true;
    L21:
        if (com.bytedance.bdinstall.q.b() == false) goto L23;
        com.bytedance.bdinstall.q.a("updateHeader, " + r4 + ", " + r0 + ", " + r5);
    L23:
        return r3;
    L11:
        th = move-exception;
        throw th;
    L13:
        e = move-exception;
        com.bytedance.bdinstall.q.i(e);     // Catch: Throwable -> L11
    L19:
        r3 = false;
        goto L21
    L5:
        if (r5.equals(r0) == false) goto L8;
        goto L6
    }

    @Override // com.bytedance.bdinstall.x0.f
    public boolean a(JSONObject r20, com.bytedance.bdinstall.r r21, com.bytedance.bdinstall.b1.a r22) {
        if (r20 != null) goto L5;
        return false;
    L5:
        String r9 = r20.optString("device_id_str", "");
        String r11 = r20.optString("install_id_str", "");
        String r4 = r20.optString("device_token", "");
        String r13 = r20.optString("ssid", "");
        String r5 = r20.optString("cd", "");
        r20.optInt("new_user", 0);
        if (com.bytedance.bdinstall.q.b() == false) goto L8;
        com.bytedance.bdinstall.q.a("saveRegisterInfo, " + r9 + ", " + r11 + ", " + r13 + ", , " + r5 + ", " + r20);
    L8:
        boolean r14 = v0.a(r9);
        boolean r15 = v0.a(r11);
        v0.a(r5);
        SharedPreferences.Editor r6 = this.f2927f.D().edit();
        SharedPreferences r7 = com.bytedance.bdinstall.d1.h.a(this.f2926e);
        SharedPreferences.Editor r8 = r7.edit();
        boolean r10 = v0.a(r13);     // Catch: JSONException -> L91
        long r17 = r7.getLong("dr_install_vc", 0);     // Catch: JSONException -> L89
        long r3 = g().optLong("version_code", 0);     // Catch: JSONException -> L89
        if (r17 != r3) goto L104;
    L18:
        r8.putString("dr_channel", this.f2927f.r());     // Catch: JSONException -> L89
        r8.putString("dr_aid", String.valueOf(this.f2927f.j()));     // Catch: JSONException -> L89
        if (r14 == false) goto L108;
    L23:
        String r12 = i();     // Catch: JSONException -> L87
        if (com.bytedance.bdinstall.q.b() == false) goto L26;
        com.bytedance.bdinstall.q.a("od=" + r12 + " nd=" + r9 + " ck=" + r14);     // Catch: JSONException -> L87
    L26:
        if (r14 == true) goto L28;
        boolean r16 = false;
        boolean r18 = false;
    L45:
        boolean r23 = r16;
        String r19 = g().optString("install_id", "");     // Catch: JSONException -> L87
        if (r15 == true) goto L48;
    L55:
        boolean r24 = r23;
    L56:
        r6.putString(WsConstants.KEY_DEVICE_ID, r9);     // Catch: JSONException -> L87
        r6.putString("install_id", r11);     // Catch: JSONException -> L87
        boolean r25 = r24;
        boolean r110 = r18;
        String r0 = g().optString("ssid", "");     // Catch: JSONException -> L87
        if (r10 == true) goto L59;
    L61:
        boolean r26 = r25;
    L62:
        this.f2927f.X(r8);     // Catch: JSONException -> L87
        r8.apply();     // Catch: JSONException -> L87
        r6.apply();     // Catch: JSONException -> L87
        ((com.bytedance.bdinstall.o) com.bytedance.bdinstall.b1.e.a(com.bytedance.bdinstall.o.class)).a(r4, r21);     // Catch: JSONException -> L87
        if (TextUtils.equals(r9, r12) == false) goto L65;
    L67:
        boolean r27 = false;
    L69:
        if (TextUtils.equals(r11, r19) == false) goto L71;
    L73:
        boolean r28 = false;
    L74:
        if (r26 == false) goto L76;
        com.bytedance.bdinstall.x0.b.b(new com.bytedance.bdinstall.x0.g.a(g()));     // Catch: JSONException -> L87
    L76:
        if (r27 == true) goto L80;
        if (r28 == true) goto L80;
        boolean r29 = false;
    L83:
        com.bytedance.bdinstall.d1.b.d().a(r110, r12, r9, r19, r11, r0, r13);     // Catch: JSONException -> L85
    L95:
        if (r14 == false) goto L98;
        if (r15 == false) goto L98;
        boolean r30 = true;
    L99:
        if (r30 == false) goto L101;
        com.bytedance.bdinstall.x0.b.b(new com.bytedance.bdinstall.x0.g.d(r20));
    L101:
        return r30;
    L98:
        r30 = r29;
    L85:
        e = e;
    L94:
        com.bytedance.bdinstall.q.i(e);
    L80:
        y();     // Catch: JSONException -> L87
        r29 = false;
        com.bytedance.bdinstall.migrate.a.h(this.f2926e, null, false);     // Catch: JSONException -> L85
        goto L83
    L71:
        if (TextUtils.isEmpty(r11) == true) goto L73;
        r28 = true;
        goto L74
    L65:
        if (TextUtils.isEmpty(r9) == true) goto L67;
        r27 = true;
        goto L69
    L59:
        if (D("ssid", r13) == false) goto L61;
        this.f2931j.a("ssid", r13);     // Catch: JSONException -> L87
        r26 = true;
        r110 = true;
        goto L62
    L48:
        if (D("install_id", r11) == false) goto L55;
        this.f2931j.a("install_id", r11);     // Catch: JSONException -> L87
        if (TextUtils.isEmpty(r19) == true) goto L54;
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L87
        r1.put("old_id", r19);     // Catch: JSONException -> L87
        r1.put("new_id", r11);     // Catch: JSONException -> L87
        com.bytedance.bdinstall.z r31 = this.f2927f.w();     // Catch: JSONException -> L87
        if (r31 == null) goto L54;
        r31.onEvent("iid_change", r1);     // Catch: JSONException -> L87
    L54:
        r24 = true;
        r18 = true;
        goto L56
    L28:
        if (r9.equals(this.f2930i.optString(WsConstants.KEY_DEVICE_ID)) == true) goto L37;
        monitor-enter(this);     // Catch: JSONException -> L87
        JSONObject r32 = this.f2930i;     // Catch: Throwable -> L34
        JSONObject r111 = new JSONObject();     // Catch: Throwable -> L34
        v0.c(r111, r32);     // Catch: Throwable -> L34
        r111.put(WsConstants.KEY_DEVICE_ID, r9);     // Catch: Throwable -> L34
        this.f2930i = r111;     // Catch: Throwable -> L34
        monitor-exit(this);     // Catch: Throwable -> L34
        r22.a(r9);     // Catch: JSONException -> L87
        r16 = true;
        r18 = true;
    L39:
        if (r9.equals(r12) == true) goto L45;
        if (TextUtils.isEmpty(r12) == true) goto L43;
        v(r22, r9, r12);     // Catch: JSONException -> L87
    L43:
        r18 = true;
        goto L45
    L34:
        th = move-exception;
        throw th;     // Catch: JSONException -> L87
    L87:
        e = e;
        r29 = false;
        goto L94
    L37:
        r16 = false;
        r18 = false;
        goto L39
    L108:
        JSONObject r33 = new JSONObject();     // Catch: JSONException -> L87
        r33.put("response", r20);     // Catch: JSONException -> L87
        com.bytedance.bdinstall.z r34 = this.f2927f.w();     // Catch: JSONException -> L87
        if (r34 == null) goto L23;
        r34.onEvent("tt_fetch_did_error", r33);     // Catch: JSONException -> L87
        goto L23
    L104:
        r8.putLong("dr_install_vc", r3);     // Catch: JSONException -> L16
    L16:
        e = e;
        r29 = false;
        r14 = false;
    L89:
        e = e;
        r29 = false;
    L93:
        r14 = r29;
    L91:
        e = e;
        r29 = false;
        goto L93
    }

    public void c(com.bytedance.bdinstall.r r7, boolean r8) {
        this.f2925d = r7;
        this.f2931j = d(this.f2926e, r7);
        com.bytedance.bdinstall.c1.f.b(this.f2926e, r7, this.f2927f);
        Map<Class<?>, d> r0 = this.f2922a;
        monitor-enter(r0);
        this.f2922a.put(w.class, new w(this.f2927f, r7));     // Catch: Throwable -> L10
        this.f2922a.put(l.class, new l(this.f2926e, this.f2927f, r7));     // Catch: Throwable -> L10
        this.f2922a.put(g.class, new g(this.f2926e, this.f2927f, r7));     // Catch: Throwable -> L10
        this.f2922a.put(f.class, new f(this.f2926e));     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        A(r7);
        if (r8 == false) goto L15;
        t();
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @NonNull
    public JSONObject g() {
        return this.f2930i;
    }

    public com.bytedance.bdinstall.r h() {
        return this.f2925d;
    }

    public String i() {
        com.bytedance.bdinstall.b1.a r0 = (com.bytedance.bdinstall.b1.a) com.bytedance.bdinstall.b1.e.a(com.bytedance.bdinstall.b1.a.class);
        if (r0 == null) goto L7;
        return r0.getDeviceId();
    L7:
        return this.f2931j.c("", "");
    }

    public JSONObject j() {
        if (this.f2932k == true) goto L7;
        return null;
    L7:
        return g();
    }

    public h0 l() {
        Object r0 = this.f2924c;
        monitor-enter(r0);
        b();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        String r1 = i();
        String r2 = k();
        String r3 = m();
        String r4 = f();
        String r6 = o();
        h0 r5 = new h0();
        if (TextUtils.isEmpty(r1) == false) goto L9;
        r1 = "";
    L9:
        r5.j(r1);
        if (TextUtils.isEmpty(r2) == false) goto L12;
        r2 = "";
    L12:
        r5.k(r2);
        r5.i(r4);
        r5.m(r3);
        r5.n(r6);
        return r5;
    L14:
        th = move-exception;
        throw th;
    }

    public int n() {
        String r0 = g().optString(WsConstants.KEY_DEVICE_ID, "");
        String r1 = g().optString("install_id", "");
        String r2 = g().optString("bd_did", "");
        if (v0.a(r0) == true) goto L7;
        if (v0.a(r2) == true) goto L7;
        return 0;
    L7:
        if (v0.a(r1) == true) goto L9;
        return 0;
    L9:
        if (com.bytedance.bdinstall.d1.h.a(this.f2926e).getLong("dr_install_vc", 0) != g().optLong("version_code", -1)) goto L11;
        return 1;
    L11:
        return 2;
    }

    public boolean p() {
        return !TextUtils.equals(com.bytedance.bdinstall.d1.h.a(this.f2926e).getString("dr_aid", null), String.valueOf(this.f2927f.j()));
    }

    public boolean q() {
        return !TextUtils.equals(com.bytedance.bdinstall.d1.h.a(this.f2926e).getString("dr_channel", null), this.f2927f.r());
    }

    public boolean r() {
        if (com.bytedance.bdinstall.d1.h.a(this.f2926e).getLong("dr_install_vc", 0) == g().optLong("version_code", 0)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean s() {
        Map<Class<?>, d> r0 = this.f2922a;
        monitor-enter(r0);
    L58:
        th = move-exception;
        throw th;
    L5:
        if (this.f2923b == true) goto L7;
        this.f2923b = true;     // Catch: Throwable -> L58
        this.f2922a.put(e.class, new e(this.f2926e));     // Catch: Throwable -> L58
        this.f2922a.put(g.class, new g(this.f2926e, this.f2927f, this.f2925d));     // Catch: Throwable -> L58
        this.f2922a.put(m.class, new m(this.f2926e));     // Catch: Throwable -> L58
        this.f2922a.put(q.class, new q(this.f2926e));     // Catch: Throwable -> L58
        this.f2922a.put(s.class, new s(this.f2926e));     // Catch: Throwable -> L58
        this.f2922a.put(u.class, new u(this.f2926e, this.f2927f));     // Catch: Throwable -> L58
        this.f2922a.put(v.class, new v());     // Catch: Throwable -> L58
        this.f2922a.put(w.class, new w(this.f2927f, this.f2925d));     // Catch: Throwable -> L58
        this.f2922a.put(x.class, new x(this.f2926e));     // Catch: Throwable -> L58
        this.f2922a.put(y.class, new y(this.f2926e));     // Catch: Throwable -> L58
        this.f2922a.put(l.class, new l(this.f2926e, this.f2927f, this.f2925d));     // Catch: Throwable -> L58
        this.f2922a.put(f.class, new f(this.f2926e));     // Catch: Throwable -> L58
        this.f2922a.put(c.class, new c(this.f2926e, this.f2927f));     // Catch: Throwable -> L58
        this.f2922a.put(b.class, new b(this.f2926e));     // Catch: Throwable -> L58
        this.f2922a.put(h.class, new h(this.f2927f));     // Catch: Throwable -> L58
        this.f2922a.put(n.class, new n(this.f2926e, this.f2927f));     // Catch: Throwable -> L58
        this.f2922a.put(z.class, new z(this.f2926e, this.f2927f));     // Catch: Throwable -> L58
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L58
        monitor-enter(this);
        JSONObject r1 = g();     // Catch: Throwable -> L55
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L55
        v0.c(r2, r1);     // Catch: Throwable -> L55
        Iterator<d> r3 = this.f2922a.values().iterator();     // Catch: Throwable -> L55
        boolean r4 = true;
        int r5 = 0;
        int r6 = 0;
    L11:
        if (r3.hasNext() == false) goto L43;
        d r7 = r3.next();     // Catch: Throwable -> L55
        if (r7.f2913a == true) goto L15;
    L65:
        r7.b(r2);     // Catch: SecurityException -> L20 JSONException -> L28 Throwable -> L55
        r7.f2913a = r7.a(r2);     // Catch: SecurityException -> L20 JSONException -> L28 Throwable -> L55
    L31:
        if (r7.f2913a == false) goto L33;
    L36:
        if (r7.f2913a == false) goto L38;
    L41:
        boolean r8 = true;
    L42:
        r4 = r4 & r8;     // Catch: Throwable -> L55
        goto L11
    L38:
        if (r7.f2914b == true) goto L41;
        r8 = false;
        goto L42
    L33:
        if (r7.f2914b == true) goto L36;
        r6 = r6 + 1;     // Catch: Throwable -> L55
    L20:
        e = move-exception;
        if (r7.f2914b == true) goto L31;
        r5 = r5 + 1;     // Catch: Throwable -> L55
        com.bytedance.bdinstall.q.h("loadHeader, " + this.m, e);     // Catch: Throwable -> L55
        if (r7.f2913a == true) goto L31;
        if (this.m <= 10) goto L31;
        r7.f2913a = true;     // Catch: Throwable -> L55
    L28:
        e = move-exception;
        com.bytedance.bdinstall.q.i(e);     // Catch: Throwable -> L55
        goto L31
    L15:
        if (r7.f2915c == true) goto L65;
        if (w(r7) == false) goto L36;
    L43:
        this.f2930i = r2;     // Catch: Throwable -> L55
        this.f2932k = r4;     // Catch: Throwable -> L55
        if (com.bytedance.bdinstall.q.b() == false) goto L46;
        com.bytedance.bdinstall.q.a("loadHeader, " + this.f2932k + ", " + this.m + ", " + this.f2930i);     // Catch: Throwable -> L55
    L47:
        if (r5 <= 0) goto L52;
        if (r5 != r6) goto L52;
        this.m++;     // Catch: Throwable -> L55
        if (n() == 0) goto L52;
        this.m += 10;     // Catch: Throwable -> L55
    L52:
        monitor-exit(this);     // Catch: Throwable -> L55
        return this.f2932k;
    L46:
        com.bytedance.bdinstall.q.e("loadHeader, " + this.f2932k + ", " + this.m, null);     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        throw th;
    }

    public void t() {
        s();
        com.bytedance.bdinstall.x0.b.b(new com.bytedance.bdinstall.x0.g.a(g()));
        y();
    }

    protected void u() {
        Context r0 = this.f2926e;
    L14:
        th = move-exception;
        monitor-enter(this.f2924c);
        this.f2929h = true;     // Catch: Throwable -> L20
        this.f2924c.notifyAll();     // Catch: Throwable -> L20
        throw th;
    L20:
        th = move-exception;
        throw th;
    L4:
        if (e(r0, this.f2925d) == true) goto L6;
        t.b(r0, this.f2925d, this.f2927f);     // Catch: Throwable -> L14
    L6:
        Object r1 = this.f2924c;
        monitor-enter(r1);
        this.f2929h = true;     // Catch: Throwable -> L11
        this.f2924c.notifyAll();     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void x() {
        h0 r4 = l();
        String r0 = null;
        if (r4 == null) goto L5;
        String r1 = r4.c();
    L6:
        if (r4 == null) goto L8;
        String r2 = r4.d();
    L9:
        if (r4 == null) goto L11;
        r0 = r4.f();
    L11:
        com.bytedance.bdinstall.d1.b.d().b(r1, r2, r0);
        if (r4 != null) goto L14;
        return;
    L14:
        if (TextUtils.isEmpty(r4.c()) == false) goto L16;
        return;
    L16:
        if (TextUtils.isEmpty(r4.d()) == true) goto L22;
        com.bytedance.bdinstall.x0.b.b(new com.bytedance.bdinstall.x0.g.b(r4));
        return;
    L22:
        return;
    L8:
        r2 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public void y() {
        h0 r1 = l();
        if (r1 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r1.c()) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r1.d()) == true) goto L13;
        com.bytedance.bdinstall.x0.b.b(new com.bytedance.bdinstall.x0.g.b(r1));
        return;
    }

    public void z() {
        d r0 = this.f2922a.get(z.class);
        Objects.requireNonNull(r0);
        r0.f2913a = false;
        t();
    }
}
