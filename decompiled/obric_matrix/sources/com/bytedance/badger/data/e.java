package com.bytedance.badger.data;

import kotlin.n0.d.g;
import kotlin.n0.d.o;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e implements b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f2544g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient String f2547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient long f2548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f2549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f2550f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }

        public final e a(String r14) {
            if (r14 != null) goto L5;
        L8:
            boolean r1 = true;
        L10:
            if (r1 == false) goto L15;
            return null;
        L15:
            JSONObject r2 = new JSONObject(r14);     // Catch: JSONException -> L14
            String r4 = r2.optString("challenge_key", "");     // Catch: JSONException -> L14
            o.b(r4, "jsonObject.optString(\"challenge_key\", \"\")");     // Catch: JSONException -> L14
            String r9 = r2.optString("path", "");     // Catch: JSONException -> L14
            o.b(r9, "jsonObject.optString(\"path\", \"\")");     // Catch: JSONException -> L14
            String r10 = r2.optString("log_id", "");     // Catch: JSONException -> L14
            o.b(r10, "jsonObject.optString(\"log_id\", \"\")");     // Catch: JSONException -> L14
            return new e(r4, r2.optInt("bbid", 0), null, 0, r9, r10, 12, null);
        L14:
            return null;
        L5:
            if (r14.length() == 0) goto L8;
            r1 = false;
            goto L10
        }
    }

    static {
        f2544g = new a(null);
    }

    public e() {
        this(null, 0, null, 0, null, null, 63, null);
    }

    public e(String r2, int r3, String r4, long r5, String r7, String r8) {
        o.g(r2, "challengeKey");
        o.g(r4, "deviceId");
        o.g(r7, "triggerPath");
        o.g(r8, "triggerLogid");
        this.f2545a = r2;
        this.f2546b = r3;
        this.f2547c = r4;
        this.f2548d = r5;
        this.f2549e = r7;
        this.f2550f = r8;
    }

    public /* synthetic */ e(String r2, int r3, String r4, long r5, String r7, String r8, int r9, g r10) {
        if ((r9 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r9 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r9 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r9 & 8) == 0) goto L15;
        r5 = System.currentTimeMillis();
    L15:
        if ((r9 & 16) == 0) goto L18;
        r7 = "";
    L18:
        if ((r9 & 32) == 0) goto L20;
        r8 = "";
    L20:
        this(r2, r3, r4, r5, r7, r8);
    }

    public final String a() {
        return this.f2550f;
    }

    @Override // com.bytedance.badger.data.b
    public long b() {
        return this.f2548d;
    }

    @Override // com.bytedance.badger.data.b
    public String c() {
        return this.f2545a;
    }

    @Override // com.bytedance.badger.data.b
    public int d() {
        return this.f2546b;
    }

    public final String e() {
        return this.f2549e;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L5;
    L26:
        return true;
    L5:
        if ((r8 instanceof e) == false) goto L25;
        e r9 = (e) r8;
        if (o.a(c(), r9.c()) == false) goto L25;
        if (d() != r9.d()) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L25;
        if (o.a(getDeviceId(), r9.getDeviceId()) == false) goto L25;
        if (b() != r9.b()) goto L18;
        boolean r2 = true;
    L19:
        if (r2 == false) goto L25;
        if (o.a(this.f2549e, r9.f2549e) == false) goto L25;
        if (o.a(this.f2550f, r9.f2550f) == false) goto L25;
    L18:
        r2 = false;
        goto L19
    L11:
        r1 = false;
    L25:
        return false;
    }

    public void f(String r2) {
        o.g(r2, "<set-?>");
        this.f2547c = r2;
    }

    public void g(long r1) {
        this.f2548d = r1;
    }

    @Override // com.bytedance.badger.data.b
    public String getDeviceId() {
        return this.f2547c;
    }

    public final String h() {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put("challenge_key", c());     // Catch: JSONException -> L4
        r0.put("bbid", d());     // Catch: JSONException -> L4
        r0.put("path", this.f2549e);     // Catch: JSONException -> L4
        r0.put("log_id", this.f2550f);     // Catch: JSONException -> L4
        String r3 = r0.toString();     // Catch: JSONException -> L4
        o.b(r3, "JSONObject().apply {\n   …\n            }.toString()");     // Catch: JSONException -> L4
        return r3;
    L4:
        return "";
    }

    public int hashCode() {
        String r0 = c();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + Integer.hashCode(d())) * 31;
        String r4 = getDeviceId();
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (((r3 + r5) * 31) + Long.hashCode(b())) * 31;
        String r7 = this.f2549e;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.f2550f;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "LoginBadgerRequest(challengeKey=" + c() + ", bbid=" + d() + ", deviceId=" + getDeviceId() + ", timestamp=" + b() + ", triggerPath=" + this.f2549e + ", triggerLogid=" + this.f2550f + ")";
    }
}
