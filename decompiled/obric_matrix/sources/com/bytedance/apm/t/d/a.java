package com.bytedance.apm.t.d;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.apm.t.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f1976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f1978e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f1979f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1980g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f1981h;

    public a(String r1, long r2, long r4, String r6, String r7, String r8, int r9, JSONObject r10) {
        this.f1974a = r1;
        this.f1975b = r2;
        this.f1976c = r4;
        this.f1977d = r6;
        this.f1978e = r7;
        this.f1979f = r8;
        this.f1980g = r9;
        if (r10 != null) goto L5;
        this.f1981h = new JSONObject();
        return;
    L5:
        this.f1981h = r10;
    }

    @Override // com.bytedance.apm.t.b
    public String a() {
        return null;
    }

    @Override // com.bytedance.apm.t.b
    public boolean b(JSONObject r1) {
        return false;
    }

    @Override // com.bytedance.apm.t.b
    @Nullable
    public JSONObject c() {
        if (TextUtils.isEmpty(this.f1974a) == false) goto L20;
        return null;
    L20:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L19
        r0.put("log_type", this.f1974a);     // Catch: Exception -> L19
        r0.put(TypedValues.TransitionType.S_DURATION, this.f1975b);     // Catch: Exception -> L19
        r0.put("uri", Uri.parse(this.f1977d));     // Catch: Exception -> L19
        long r2 = this.f1976c;     // Catch: Exception -> L19
        if (r2 <= 0) goto L8;
        r0.put("timestamp", r2);     // Catch: Exception -> L19
    L8:
        r0.put("status", this.f1980g);     // Catch: Exception -> L19
        if (TextUtils.isEmpty(this.f1978e) == true) goto L13;
        r0.put("ip", this.f1978e);     // Catch: Exception -> L19
    L13:
        if (TextUtils.isEmpty(this.f1979f) == true) goto L16;
        String r6 = this.f1979f;     // Catch: Exception -> L19
    L15:
        r0.put("trace_code", r6);     // Catch: Exception -> L19
        return r0;
    L16:
        r6 = "";
    L19:
        return null;
    }

    @Override // com.bytedance.apm.t.b
    public boolean d() {
        return true;
    }

    @Override // com.bytedance.apm.t.b
    public String e() {
        return null;
    }

    public void f(String r3) {
        if (this.f1981h.isNull("net_consume_type") == false) goto L6;
        this.f1981h.put("net_consume_type", r3);
        return;
    }

    public void g(boolean r3) {
        if (this.f1981h.isNull("front") == false) goto L6;
        this.f1981h.put("front", r3 ? 1 : 0);
        return;
    }

    public void h() {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put("trace_base", com.bytedance.apm.d.g());     // Catch: JSONException -> L4
        this.f1981h.put("relate_start_trace", r0);     // Catch: JSONException -> L4
        return;
    }
}
