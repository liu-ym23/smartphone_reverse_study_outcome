package d.b.b.d.c;

import android.text.TextUtils;
import d.b.b.o.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b implements d.b.b.l.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f12567b;

    public b(String r1, JSONObject r2) {
        this.f12566a = r1;
        this.f12567b = r2;
    }

    @Override // d.b.b.l.b
    public String a() {
        return this.f12566a;
    }

    @Override // d.b.b.l.b
    public boolean b() {
        return !TextUtils.isEmpty(this.f12566a);
    }

    @Override // d.b.b.l.b
    public JSONObject c() {
        JSONObject r0 = e();     // Catch: Exception -> L7
        if (r0 != null) goto L5;
        r0 = new JSONObject();     // Catch: Exception -> L7
    L5:
        r0.put("log_type", a());     // Catch: Exception -> L7
        return r0;
    L7:
        e = move-exception;
        if (d.b.b.o.a.c() == false) goto L15;
        d.b.b.o.m.b.g("APM-CommonEvent", "toJsonObject Error.", e);
        return null;
    L15:
        return null;
    }

    public void d() {
        this.f12567b = e.l(this.f12567b);
    }

    public JSONObject e() {
        return this.f12567b;
    }

    public String toString() {
        return "CommonLog{logType='" + this.f12566a + "'}";
    }
}
