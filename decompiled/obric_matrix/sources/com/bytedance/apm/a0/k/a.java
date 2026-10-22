package com.bytedance.apm.a0.k;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.apm.util.l;
import com.bytedance.apm.util.y;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, c> f1191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, c> f1192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, c> f1193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, c> f1194e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, c> f1195f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, c> f1196g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private y<i> f1197h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile long f1198i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map<String, Map<String, c>> f1199j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private double f1200k;

    /* JADX INFO: renamed from: com.bytedance.apm.a0.k.a$a, reason: collision with other inner class name */
    class C0037a implements com.bytedance.apm.t.c.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f1201a;

        C0037a(a r1) {
            this.f1201a = r1;
        }

        @Override // com.bytedance.apm.t.c.c
        public void a(String r2, JSONObject r3) {
            if (a.a(this.f1201a) == true) goto L5;
            return;
        L5:
            this.f1201a.m(r2, r3);
        }
    }

    class b implements com.bytedance.apm.t.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f1202a;

        b(a r1) {
            this.f1202a = r1;
        }

        @Override // com.bytedance.apm.t.c.b
        public void a(String r1, String r2, JSONObject r3) {
            if (a.a(this.f1202a) == true) goto L5;
            return;
        L5:
            if ("image_monitor_v2".equals(r2) == false) goto L9;
            this.f1202a.n(r3);
            return;
        }
    }

    class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f1203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, Long> f1204b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f1205c;

        public c(a r3, String r4) {
            this.f1205c = 0;
            this.f1203a = r4;
            this.f1204b = new HashMap();
        }

        public void a(String r4, long r5) {
            if (this.f1204b.containsKey(r4) == false) goto L5;
            Map<String, Long> r0 = this.f1204b;
            Long r1 = Long.valueOf(r0.get(r4).longValue() + r5);
        L6:
            r0.put(r4, r1);
            this.f1205c += r5;
            return;
        L5:
            r0 = this.f1204b;
            r1 = Long.valueOf(r5);
            goto L6
        }

        public JSONObject b() {
            JSONObject r1 = new JSONObject();
            r1.put("biz", this.f1203a);     // Catch: JSONException -> L13
            r1.put("usage", this.f1205c);     // Catch: JSONException -> L13
            JSONArray r2 = new JSONArray();     // Catch: JSONException -> L13
            Map<String, Long> r3 = this.f1204b;     // Catch: JSONException -> L13
            if (r3 != null) goto L6;
        L11:
            r1.put("detail", r2);     // Catch: JSONException -> L13
            goto L12
        L6:
            if (r3.size() <= 0) goto L11;
            Iterator<Map.Entry<String, Long>> r7 = this.f1204b.entrySet().iterator();     // Catch: JSONException -> L13
        L9:
            if (r7.hasNext() == false) goto L11;
            Map.Entry<String, Long> r4 = r7.next();     // Catch: JSONException -> L13
            JSONObject r5 = new JSONObject();     // Catch: JSONException -> L13
            r5.put("source_id", r4.getKey());     // Catch: JSONException -> L13
            r5.put("usage", r4.getValue());     // Catch: JSONException -> L13
            r2.put(r5);     // Catch: JSONException -> L13
        L12:
            return r1;
        }

        public JSONObject c(long r8) {
            JSONObject r1 = new JSONObject();
            r1.put("biz", this.f1203a);     // Catch: JSONException -> L15
            r1.put("usage", this.f1205c);     // Catch: JSONException -> L15
            JSONArray r2 = new JSONArray();     // Catch: JSONException -> L15
            Map<String, Long> r3 = this.f1204b;     // Catch: JSONException -> L15
            if (r3 != null) goto L6;
        L13:
            r1.put("detail", r2);     // Catch: JSONException -> L15
            goto L14
        L6:
            if (r3.size() <= 0) goto L13;
            Iterator<Map.Entry<String, Long>> r7 = this.f1204b.entrySet().iterator();     // Catch: JSONException -> L15
        L9:
            if (r7.hasNext() == false) goto L13;
            Map.Entry<String, Long> r4 = r7.next();     // Catch: JSONException -> L15
            if (r4.getValue().longValue() < r8) goto L9;
            JSONObject r5 = new JSONObject();     // Catch: JSONException -> L15
            r5.put("source_id", r4.getKey());     // Catch: JSONException -> L15
            r5.put("usage", r4.getValue());     // Catch: JSONException -> L15
            r2.put(r5);     // Catch: JSONException -> L15
        L14:
            return r1;
        }
    }

    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f1206a = null;

        static {
            f1206a = new a(null);
        }

        static /* synthetic */ a a() {
            return f1206a;
        }
    }

    private a() {
        this.f1198i = 0;
        this.f1200k = 102400.0d;
    }

    /* synthetic */ a(C0037a r1) {
        this();
    }

    static /* synthetic */ boolean a(a r0) {
        return r0.f1190a;
    }

    private void b(String r5, long r6, String r8) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        boolean r0 = l.c(com.bytedance.apm.d.h());
        boolean r1 = false;
        d.b.b.n.g.a r2 = (d.b.b.n.g.a) d.b.b.n.c.a(d.b.b.n.g.a.class);
        if (r2 == null) goto L9;
        r1 = r2.isForeground();
    L9:
        if (this.f1191b != null) goto L12;
        this.f1191b = new HashMap();
    L12:
        if (this.f1192c != null) goto L15;
        this.f1192c = new HashMap();
    L15:
        if (this.f1193d != null) goto L18;
        this.f1193d = new HashMap();
    L18:
        if (this.f1194e != null) goto L21;
        this.f1194e = new HashMap();
    L21:
        if (this.f1195f != null) goto L24;
        this.f1195f = new HashMap();
    L24:
        if (this.f1191b.containsKey(r5) == false) goto L26;
        this.f1191b.get(r5).a(r8, r6);
    L27:
        if (r0 == false) goto L33;
        if (r1 == true) goto L33;
        if (this.f1192c.containsKey(r5) == false) goto L32;
        this.f1192c.get(r5).a(r8, r6);
        goto L33
    L32:
        c r3 = new c(this, r5);
        r3.a(r8, r6);
        this.f1192c.put(r5, r3);
    L33:
        if (r0 == false) goto L39;
        if (r1 == false) goto L39;
        if (this.f1193d.containsKey(r5) == false) goto L38;
        this.f1193d.get(r5).a(r8, r6);
        goto L39
    L38:
        c r4 = new c(this, r5);
        r4.a(r8, r6);
        this.f1193d.put(r5, r4);
    L39:
        if (r0 == true) goto L45;
        if (r1 == true) goto L45;
        if (this.f1194e.containsKey(r5) == false) goto L44;
        this.f1194e.get(r5).a(r8, r6);
        goto L45
    L44:
        c r7 = new c(this, r5);
        r7.a(r8, r6);
        this.f1194e.put(r5, r7);
    L45:
        if (r0 == true) goto L52;
        if (r1 == false) goto L52;
        if (this.f1195f.containsKey(r5) == false) goto L50;
        this.f1195f.get(r5).a(r8, r6);
        goto L52
    L50:
        c r9 = new c(this, r5);
        r9.a(r8, r6);
        this.f1195f.put(r5, r9);
    L52:
        if (this.f1196g != null) goto L55;
        this.f1196g = new HashMap();
    L55:
        if (this.f1196g.containsKey(r5) == false) goto L57;
        this.f1196g.get(r5).a(r8, r6);
    L58:
        Map<String, Map<String, c>> r10 = this.f1199j;
        if (r10 == null) goto L67;
        Iterator<Map.Entry<String, Map<String, c>>> r11 = r10.entrySet().iterator();
    L62:
        if (r11.hasNext() == false) goto L74;
        Map<String, c> r12 = r11.next().getValue();
        if (r12.containsKey(r5) == true) goto L65;
        c r13 = new c(this, r5);
        r13.a(r8, r6);
        r12.put(r5, r13);
        goto L62
    L65:
        r12.get(r5).a(r8, r6);
        goto L62
    L74:
        return;
    L67:
        return;
    L57:
        c r14 = new c(this, r5);
        r14.a(r8, r6);
        this.f1196g.put(r5, r14);
        goto L58
    L26:
        c r15 = new c(this, r5);
        r15.a(r8, r6);
        this.f1191b.put(r5, r15);
        goto L27
    }

    public static a j() {
        return d.a();
    }

    private void p() {
        com.bytedance.apm.t.c.a.p().q(new b(this));
    }

    private void q(boolean r1) {
        this.f1190a = r1;
    }

    private void r(boolean r1) {
        com.bytedance.apm.x.a.i(r1);
    }

    private void t() {
        com.bytedance.apm.t.c.d.t().J(new C0037a(this));
    }

    public void c() {
        Map<String, c> r0 = this.f1191b;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        Map<String, c> r1 = this.f1192c;
        if (r1 == null) goto L8;
        r1.clear();
    L8:
        Map<String, c> r2 = this.f1193d;
        if (r2 == null) goto L11;
        r2.clear();
    L11:
        Map<String, c> r3 = this.f1194e;
        if (r3 == null) goto L14;
        r3.clear();
    L14:
        Map<String, c> r4 = this.f1195f;
        if (r4 == null) goto L17;
        r4.clear();
    L17:
        y<i> r5 = this.f1197h;
        if (r5 == null) goto L20;
        r5.b();
    L20:
        this.f1198i = 0;
    }

    public long d() {
        return this.f1198i;
    }

    @Nullable
    public Map<String, c> e() {
        return this.f1194e;
    }

    @Nullable
    public Map<String, c> f() {
        return this.f1195f;
    }

    @Nullable
    public Map<String, c> g() {
        return this.f1191b;
    }

    @Nullable
    public Map<String, c> h() {
        return this.f1192c;
    }

    @Nullable
    public Map<String, c> i() {
        return this.f1193d;
    }

    @Nullable
    public y<i> k() {
        return this.f1197h;
    }

    public Map<String, c> l() {
        return this.f1196g;
    }

    public void m(String r10, JSONObject r11) {
        if (this.f1190a == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10) == true) goto L38;
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.length() == 0) goto L40;
        String r1 = new URL(r10).getPath();     // Catch: Throwable -> L34
        if (TextUtils.isEmpty(r1) == false) goto L14;
        return;
    L14:
        String r2 = r11.optString("net_consume_type", "ttnet");     // Catch: Throwable -> L34
        JSONObject r3 = r11.optJSONObject(ICronetClient.KEY_REQUEST_LOG);     // Catch: Throwable -> L34
        if (r3 != null) goto L19;
        String r12 = r11.optString(ICronetClient.KEY_REQUEST_LOG);     // Catch: Throwable -> L34
        if (TextUtils.isEmpty(r12) == true) goto L19;
        r3 = new JSONObject(r12);     // Catch: Throwable -> L34
    L19:
        JSONObject r13 = r3.optJSONObject("response");     // Catch: Throwable -> L34
        long r4 = 0;
        if (r13 == null) goto L22;
        r4 = r13.optLong("received_bytes") + r13.optLong("sent_bytes");     // Catch: Throwable -> L34
    L22:
        this.f1198i += r4;     // Catch: Throwable -> L34
        if (r4 <= this.f1200k) goto L29;
        if (this.f1197h != null) goto L27;
        this.f1197h = new y(30);     // Catch: Throwable -> L34
    L27:
        this.f1197h.a(new i(r1, r4, r2));     // Catch: Throwable -> L34
    L29:
        if (TextUtils.isEmpty(r10) == false) goto L37;
    L31:
        b(r2, r4, r10);
        com.bytedance.apm.a0.k.c.d().a(r4, r1, r2);
        return;
    L37:
        r10 = Uri.parse(r10).buildUpon().clearQuery().build().toString();     // Catch: Exception -> L33 Throwable -> L34
    L41:
        return;
    L40:
        return;
    }

    @WorkerThread
    @Deprecated
    public void n(JSONObject r1) {
    }

    public void o(double r1) {
    }

    public void s(double r1) {
        this.f1200k = r1;
    }

    public void u() {
        q(true);
        r(true);
        t();
        p();
    }
}
