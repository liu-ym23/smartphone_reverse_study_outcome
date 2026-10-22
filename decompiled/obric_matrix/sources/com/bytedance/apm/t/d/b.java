package com.bytedance.apm.t.d;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.bytedance.apm.t.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f1983b;

    public b(String r1, JSONObject r2, boolean r3) {
        this.f1982a = r1;
        this.f1983b = r2;
    }

    @Override // com.bytedance.apm.t.b
    public String a() {
        return this.f1982a;
    }

    @Override // com.bytedance.apm.t.b
    public boolean b(JSONObject r1) {
        return com.bytedance.apm.d0.c.a(this.f1982a);
    }

    @Override // com.bytedance.apm.t.b
    @Nullable
    public JSONObject c() {
        JSONObject r0 = this.f1983b;
        if (r0 != null) goto L10;
        return null;
    L10:
        r0.put("log_type", this.f1982a);     // Catch: JSONException -> L9
    L6:
        return this.f1983b;
    }

    @Override // com.bytedance.apm.t.b
    public boolean d() {
        return true;
    }

    @Override // com.bytedance.apm.t.b
    public String e() {
        return "common_log";
    }
}
