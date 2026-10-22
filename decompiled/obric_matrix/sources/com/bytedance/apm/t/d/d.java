package com.bytedance.apm.t.d;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d implements com.bytedance.apm.t.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f1991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f1993d;

    public d(String r3, JSONObject r4) {
        this(r3, r4, System.currentTimeMillis());
    }

    public d(String r1, JSONObject r2, long r3) {
        this.f1990a = r1;
        this.f1991b = r2;
        this.f1993d = r3;
    }

    @Override // com.bytedance.apm.t.b
    public String a() {
        return this.f1990a;
    }

    @Override // com.bytedance.apm.t.b
    public boolean b(JSONObject r1) {
        if (this.f1992c == false) goto L5;
    L8:
        return true;
    L5:
        if (com.bytedance.apm.d0.c.e(this.f1990a) == true) goto L8;
        return false;
    }

    @Override // com.bytedance.apm.t.b
    @Nullable
    public JSONObject c() {
        JSONObject r0 = this.f1991b;
        if (r0 != null) goto L18;
        return null;
    L18:
        r0.put("timestamp", this.f1993d);     // Catch: JSONException -> L17
        this.f1991b.put("crash_time", this.f1993d);     // Catch: JSONException -> L17
        this.f1991b.put("is_main_process", com.bytedance.apm.d.G());     // Catch: JSONException -> L17
        this.f1991b.put("process_name", com.bytedance.apm.d.i());     // Catch: JSONException -> L17
        this.f1991b.put("log_type", this.f1990a);     // Catch: JSONException -> L17
        if (com.bytedance.apm.d.g() <= com.bytedance.apm.d.A()) goto L8;
    L11:
        JSONObject r1 = this.f1991b;     // Catch: JSONException -> L17
        long r2 = com.bytedance.apm.d.A();     // Catch: JSONException -> L17
    L10:
        r1.put("app_launch_start_time", r2);     // Catch: JSONException -> L17
        goto L14
    L8:
        if (com.bytedance.apm.d.g() == 0) goto L11;
        r1 = this.f1991b;     // Catch: JSONException -> L17
        r2 = com.bytedance.apm.d.g();     // Catch: JSONException -> L17
    L14:
        return this.f1991b;
    }

    @Override // com.bytedance.apm.t.b
    public boolean d() {
        return true;
    }

    @Override // com.bytedance.apm.t.b
    public String e() {
        return this.f1990a;
    }

    public long f() {
        return this.f1993d;
    }

    public void g() {
        this.f1992c = true;
    }

    public String toString() {
        return "ExceptionLogData{eventType='" + this.f1990a + "', logJson=" + this.f1991b + ", forceSampled=" + this.f1992c + ", time=" + this.f1993d + '}';
    }
}
