package com.bytedance.apm.t.d;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.bytedance.apm.t.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f1986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f1987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f1988e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f1989f;

    public c(String r1, int r2, JSONObject r3, JSONObject r4, JSONObject r5, JSONObject r6) {
        this.f1984a = r1;
        this.f1985b = r2;
        this.f1986c = r3;
        this.f1987d = r4;
        this.f1988e = r5;
        this.f1989f = r6;
    }

    public c(String r1, int r2, JSONObject r3, JSONObject r4, JSONObject r5, JSONObject r6, boolean r7) {
        this.f1984a = r1;
        this.f1985b = r2;
        this.f1986c = r3;
        this.f1987d = r4;
        this.f1988e = r5;
        this.f1989f = r6;
    }

    @Override // com.bytedance.apm.t.b
    public String a() {
        return "service_monitor";
    }

    @Override // com.bytedance.apm.t.b
    public boolean b(JSONObject r1) {
        return com.bytedance.apm.d0.c.f(this.f1984a);
    }

    @Override // com.bytedance.apm.t.b
    @Nullable
    public JSONObject c() {
        if (this.f1989f != null) goto L18;
        this.f1989f = new JSONObject();
    L18:
        this.f1989f.put("log_type", "service_monitor");     // Catch: JSONException -> L16
        this.f1989f.put("service", this.f1984a);     // Catch: JSONException -> L16
        this.f1989f.put("status", this.f1985b);     // Catch: JSONException -> L16
        JSONObject r0 = this.f1986c;     // Catch: JSONException -> L16
        if (r0 == null) goto L8;
        this.f1989f.put("value", r0);     // Catch: JSONException -> L16
    L8:
        JSONObject r1 = this.f1987d;     // Catch: JSONException -> L16
        if (r1 == null) goto L11;
        this.f1989f.put("category", r1);     // Catch: JSONException -> L16
    L11:
        JSONObject r2 = this.f1988e;     // Catch: JSONException -> L16
        if (r2 == null) goto L14;
        this.f1989f.put("metric", r2);     // Catch: JSONException -> L16
    L14:
        return this.f1989f;
    L16:
        return null;
    }

    @Override // com.bytedance.apm.t.b
    public boolean d() {
        return true;
    }

    @Override // com.bytedance.apm.t.b
    public String e() {
        return "service_monitor";
    }
}
