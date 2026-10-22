package com.bytedance.sdk.account.impl;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f5636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f5637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f5638d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f5639e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f5640f;

    private q(JSONObject r1, String r2, int r3, String r4, String r5, long r6, String r8, boolean r9, boolean r10, boolean r11, String r12) {
        this.f5635a = r2;
        this.f5636b = r3;
        this.f5637c = r6;
        this.f5638d = r8;
        this.f5639e = r9;
        this.f5640f = r11;
    }

    public static q g(String r14) {
        JSONObject r2 = new JSONObject(r14);     // Catch: JSONException -> L9
        String r3 = r2.optString("message");     // Catch: JSONException -> L9
        int r4 = r2.optInt("protocol_type");     // Catch: JSONException -> L9
        String r9 = r2.optString("log_id");     // Catch: JSONException -> L9
        boolean r10 = r2.optBoolean("degrade");     // Catch: JSONException -> L9
        boolean r11 = r2.optBoolean("allow_login");     // Catch: JSONException -> L9
        boolean r12 = r2.optBoolean("kick_new_text_switch");     // Catch: JSONException -> L9
        String r13 = r2.optString("reason");     // Catch: JSONException -> L9
        JSONObject r15 = r2.optJSONObject("params");     // Catch: JSONException -> L9
        if (r15 == null) goto L6;
        String r1 = r15.optString("device_name");     // Catch: JSONException -> L9
        String r5 = r15.optString("user_name");     // Catch: JSONException -> L9
        long r7 = r15.optLong("user_id");     // Catch: JSONException -> L9
        String r6 = r5;
        String r8 = r1;
    L7:
        return new q(r2, r3, r4, r8, r6, r7, r9, r10, r11, r12, r13);
    L6:
        r7 = 0;
        r8 = null;
        r6 = null;
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public String a() {
        return this.f5638d;
    }

    public String b() {
        return this.f5635a;
    }

    public int c() {
        return this.f5636b;
    }

    public long d() {
        return this.f5637c;
    }

    public boolean e() {
        return this.f5639e;
    }

    public boolean f() {
        return this.f5640f;
    }
}
