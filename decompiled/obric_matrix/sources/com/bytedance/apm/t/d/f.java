package com.bytedance.apm.t.d;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f implements com.bytedance.apm.t.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f2003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f2004d;

    public f(String r1, String r2, JSONObject r3, JSONObject r4) {
        this.f2001a = r1;
        this.f2002b = r2;
        this.f2003c = r3;
        this.f2004d = r4;
    }

    @Override // com.bytedance.apm.t.b
    public String a() {
        return "ui_action";
    }

    @Override // com.bytedance.apm.t.b
    public boolean b(JSONObject r1) {
        return com.bytedance.apm.d0.c.c("ui");
    }

    @Override // com.bytedance.apm.t.b
    @Nullable
    public JSONObject c() {
    L7:
        return null;
    L3:
        if (this.f2004d != null) goto L5;
        this.f2004d = new JSONObject();     // Catch: JSONException -> L7
    L5:
        this.f2004d.put("log_type", "ui_action");     // Catch: JSONException -> L7
        this.f2004d.put("action", this.f2001a);     // Catch: JSONException -> L7
        this.f2004d.put("page", this.f2002b);     // Catch: JSONException -> L7
        this.f2004d.put("context", this.f2003c);     // Catch: JSONException -> L7
        return this.f2004d;
    }

    @Override // com.bytedance.apm.t.b
    public boolean d() {
        return true;
    }

    @Override // com.bytedance.apm.t.b
    public String e() {
        return "ui_action";
    }
}
