package d.b.b.d.c;

import android.text.TextUtils;
import d.b.b.o.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a implements d.b.b.l.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f12561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f12562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JSONObject f12563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JSONObject f12564e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private JSONObject f12565f;

    public a(String r1, int r2, JSONObject r3, JSONObject r4, JSONObject r5, JSONObject r6) {
        this.f12560a = r1;
        this.f12561b = r2;
        this.f12562c = r3;
        this.f12563d = r4;
        this.f12564e = r5;
        this.f12565f = r6;
    }

    @Override // d.b.b.l.b
    public String a() {
        return "service_monitor";
    }

    @Override // d.b.b.l.b
    public boolean b() {
        return !TextUtils.isEmpty(this.f12560a);
    }

    @Override // d.b.b.l.b
    public JSONObject c() {
        JSONObject r0 = f();     // Catch: Exception -> L15
        if (r0 != null) goto L5;
        r0 = new JSONObject();     // Catch: Exception -> L15
    L5:
        r0.put("log_type", "service_monitor");     // Catch: Exception -> L15
        r0.put("service", h());     // Catch: Exception -> L15
        r0.put("status", i());     // Catch: Exception -> L15
        if (j() == null) goto L9;
        r0.put("value", j());     // Catch: Exception -> L15
    L9:
        if (e() == null) goto L12;
        r0.put("category", e());     // Catch: Exception -> L15
    L12:
        if (g() == null) goto L14;
        r0.put("metric", g());     // Catch: Exception -> L15
    L14:
        return r0;
    L15:
        e = move-exception;
        if (d.b.b.o.a.c() == false) goto L23;
        d.b.b.o.m.b.g("APM-CommonEvent", "toJsonObject Error.", e);
        return null;
    L23:
        return null;
    }

    public void d() {
        this.f12562c = e.l(this.f12562c);
        this.f12563d = e.l(this.f12563d);
        this.f12564e = e.l(this.f12564e);
        this.f12565f = e.l(this.f12565f);
    }

    public JSONObject e() {
        return this.f12563d;
    }

    public JSONObject f() {
        return this.f12565f;
    }

    public JSONObject g() {
        return this.f12564e;
    }

    public String h() {
        return this.f12560a;
    }

    public int i() {
        return this.f12561b;
    }

    public JSONObject j() {
        return this.f12562c;
    }

    public String toString() {
        return "CommonEvent{serviceName='" + this.f12560a + "'}";
    }
}
