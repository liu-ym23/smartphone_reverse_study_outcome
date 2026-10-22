package com.bytedance.apm.t.d;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.util.h;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e implements com.bytedance.apm.t.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f1997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f1998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f1999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONObject f2000g;

    public e() {
    }

    public e(String r8, String r9, JSONObject r10, JSONObject r11, JSONObject r12) {
        this(r8, r9, false, r10, r11, r12);
    }

    public e(String r1, String r2, boolean r3, JSONObject r4, JSONObject r5, JSONObject r6) {
        this.f1994a = r1;
        this.f1995b = r2;
        this.f1996c = r3;
        this.f1997d = r4;
        this.f1998e = r5;
        this.f2000g = r6;
    }

    public e(String r8, JSONObject r9, JSONObject r10, JSONObject r11) {
        this(r8, "", false, r9, r10, r11);
    }

    @Override // com.bytedance.apm.t.b
    public String a() {
        return this.f1994a;
    }

    @Override // com.bytedance.apm.t.b
    public boolean b(@Nullable JSONObject r5) {
        if ("fps".equals(this.f1994a) == false) goto L5;
    L33:
        boolean r6 = com.bytedance.apm.d0.c.d(this.f1994a, this.f1995b);
    L35:
        if (this.f1996c == true) goto L38;
        if (r6 == true) goto L38;
        return false;
    L38:
        return true;
    L5:
        if ("fps_drop".equals(this.f1994a) == true) goto L33;
        if ("temperature".equals(this.f1994a) == false) goto L11;
        r6 = com.bytedance.apm.d0.c.e(this.f1994a);
        goto L35
    L11:
        if ("battery".equals(this.f1994a) == false) goto L14;
    L12:
        r6 = true;
        goto L35
    L14:
        if ("start".equals(this.f1994a) == false) goto L22;
        if (com.bytedance.apm.d0.c.c(this.f1994a) == true) goto L12;
        if (com.bytedance.apm.d0.c.b(this.f1995b) == true) goto L12;
        r6 = false;
        goto L35
    L22:
        if ("start_trace".equals(this.f1994a) == false) goto L32;
        if (r5 == null) goto L32;
        if (com.bytedance.apm.d0.c.e("enable_perf_data_collect") == true) goto L28;
        r5.remove("perf_data");
    L28:
        if (com.bytedance.apm.d0.c.c(this.f1994a) == true) goto L32;
        JSONObject r7 = r5.optJSONObject("trace");
        if (r7 == null) goto L32;
        r7.remove("spans");
    L32:
        r6 = com.bytedance.apm.d0.c.c(this.f1994a);
        goto L35
    }

    @Override // com.bytedance.apm.t.b
    @Nullable
    public JSONObject c() {
    L24:
        return null;
    L3:
        if (this.f2000g != null) goto L5;
        this.f2000g = new JSONObject();     // Catch: JSONException -> L24
    L5:
        this.f2000g.put("log_type", "performance_monitor");     // Catch: JSONException -> L24
        this.f2000g.put("service", this.f1994a);     // Catch: JSONException -> L24
        if (h.c(this.f1997d) == true) goto L9;
        this.f2000g.put("extra_values", this.f1997d);     // Catch: JSONException -> L24
    L9:
        if (TextUtils.equals("start", this.f1994a) == false) goto L17;
        if (TextUtils.equals(TypedValues.TransitionType.S_FROM, this.f2000g.optString("monitor-plugin")) == false) goto L17;
        if (this.f1998e != null) goto L15;
        this.f1998e = new JSONObject();     // Catch: JSONException -> L24
    L15:
        this.f1998e.put("start_mode", com.bytedance.apm.d.u());     // Catch: JSONException -> L24
    L17:
        if (h.c(this.f1998e) == true) goto L20;
        this.f2000g.put("extra_status", this.f1998e);     // Catch: JSONException -> L24
    L20:
        if (h.c(this.f1999f) == true) goto L22;
        this.f2000g.put("filters", this.f1999f);     // Catch: JSONException -> L24
    L22:
        return this.f2000g;
    }

    @Override // com.bytedance.apm.t.b
    public boolean d() {
        return true;
    }

    @Override // com.bytedance.apm.t.b
    public String e() {
        return "performance_monitor";
    }

    public e f(JSONObject r1) {
        this.f1999f = r1;
        return this;
    }

    public e g(JSONObject r1) {
        this.f2000g = r1;
        return this;
    }

    public e h(JSONObject r1) {
        this.f1998e = r1;
        return this;
    }

    public e i(JSONObject r1) {
        this.f1997d = r1;
        return this;
    }

    public boolean j() {
        return TextUtils.equals(this.f1994a, "memory");
    }

    public e k(String r1) {
        this.f1994a = r1;
        return this;
    }
}
