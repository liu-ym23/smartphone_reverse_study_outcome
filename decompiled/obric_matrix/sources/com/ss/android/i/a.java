package com.ss.android.i;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a extends d.b.s.a.k0.a {
    public String t;
    public String u;
    public String v;

    public a() {
    }

    public a(JSONObject r1) {
        super(r1);
    }

    public a(JSONObject r1, JSONObject r2) {
        super(r1, r2);
    }

    private static void r(a r2, JSONObject r3) {
        String r0 = "name";
        if (r3.has("name") == false) goto L5;
    L4:
        r2.t = r3.optString(r0);
    L8:
        r2.v = r3.optString("avatar_url");
        r2.u = r3.optString("description");
        return;
    L5:
        r0 = "username";
        if (r3.has("username") == false) goto L8;
        goto L8
    }

    @Override // d.b.s.a.k0.a
    public void a() {
        super.a();
        r(this, n());
    }
}
