package com.bytedance.bdinstall;

import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h0 implements Cloneable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f2784f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f2785g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f2786h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f2787i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f2788j;

    public h0() {
        this.f2784f = "";
        this.f2785g = "";
    }

    static h0 h(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L10;
        return null;
    L10:
        JSONObject r1 = new JSONObject(r4);     // Catch: JSONException -> L7
        h0 r5 = new h0();     // Catch: JSONException -> L7
        r5.j(r1.optString("did", ""));     // Catch: JSONException -> L7
        r5.k(r1.optString(WsConstants.KEY_INSTALL_ID, ""));     // Catch: JSONException -> L7
        r5.m(r1.optString("openudid", ""));     // Catch: JSONException -> L7
        r5.i(r1.optString("cliend_udid", ""));     // Catch: JSONException -> L7
        r5.n(r1.optString("ssid", ""));     // Catch: JSONException -> L7
        return r5;
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public h0 a() {
        return (h0) super.clone();
    L4:
        e = move-exception;
        q.d("clone error", e);
        return null;
    }

    public String c() {
        return this.f2784f;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return a();
    }

    public String d() {
        return this.f2785g;
    }

    public String e() {
        return this.f2786h;
    }

    public String f() {
        return this.f2788j;
    }

    public void i(String r1) {
        this.f2787i = r1;
    }

    public void j(String r1) {
        this.f2784f = r1;
    }

    public void k(String r1) {
        this.f2785g = r1;
    }

    public void m(String r1) {
        this.f2786h = r1;
    }

    public void n(String r1) {
        this.f2788j = r1;
    }

    JSONObject o() {
        JSONObject r0 = new JSONObject();
        r0.put("did", this.f2784f);     // Catch: JSONException -> L5
        r0.put(WsConstants.KEY_INSTALL_ID, this.f2785g);     // Catch: JSONException -> L5
        r0.put("openudid", this.f2786h);     // Catch: JSONException -> L5
        r0.put("cliend_udid", this.f2787i);     // Catch: JSONException -> L5
        r0.put("ssid", this.f2788j);     // Catch: JSONException -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public String toString() {
        return "{d='" + this.f2784f + "', i='" + this.f2785g + "', o='" + this.f2786h + "', c='" + this.f2787i + "', s='" + this.f2788j + "'}";
    }
}
