package com.bytedance.sdk.account.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class j implements d.b.s.a.d0.r.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile d.b.s.a.d0.r.a f5612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static JSONObject f5613e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f5614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SharedPreferences f5615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d.b.s.a.d0.r.a.InterfaceC0395a f5616c;

    private j(Context r2) {
        com.ss.android.d r0 = com.ss.android.i.j.l();
        if (r0 != null) goto L5;
        Context r3 = r2.getApplicationContext();
    L6:
        this.f5614a = r3;
        return;
    L5:
        r3 = r0.e();
        goto L6
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences d(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private SharedPreferences e(Context r3) {
        if (this.f5615b != null) goto L7;
        if (r3 == null) goto L7;
        this.f5615b = d(r3, "account_sdk_settings_sp", 0);
    L7:
        return this.f5615b;
    }

    private SharedPreferences.Editor f(Context r1) {
        SharedPreferences r0 = e(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.edit();
    }

    static d.b.s.a.d0.r.a g(Context r2) {
        if (f5612d != null) goto L15;
        monitor-enter(j.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5612d != null) goto L9;
        f5612d = new j(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(j.class);     // Catch: Throwable -> L11
    L15:
        return f5612d;
    }

    private void h(String r2) {
        SharedPreferences.Editor r1 = f(this.f5614a);
        if (r1 != null) goto L5;
        return;
    L5:
        r1.putString("account_sdk_settings", r2);
        r1.apply();
    }

    @Override // d.b.s.a.d0.r.a
    public JSONObject a() {
        JSONObject r1 = b();     // Catch: Exception -> L8
        if (r1 == null) goto L6;
        return r1.optJSONObject("login_info_config");
    L6:
        return null;
    L11:
        return null;
    }

    @Override // d.b.s.a.d0.r.a
    public JSONObject b() {
        d.b.s.a.d0.r.a.InterfaceC0395a r0 = this.f5616c;
        if (r0 != null) goto L5;
        JSONObject r1 = f5613e;
        if (r1 == null) goto L9;
        return r1;
    L9:
        SharedPreferences r3 = e(this.f5614a);
        if (r3 == null) goto L16;
        String r4 = r3.getString("account_sdk_settings", "{}");
        d.b.s.a.a0.a.d("BDAccountSettingsManager", "getAccountSettingsConfig read from sp: " + r4);
        f5613e = new JSONObject(r4);     // Catch: Throwable -> L14
    L18:
        return f5613e;
    L14:
        th = move-exception;
        d.b.s.a.a0.a.c("BDAccountSettingsManager", "parse settings failed", th);
        goto L18
    L16:
        d.b.s.a.a0.a.b("BDAccountSettingsManager", "getAccountSettingsConfig sp is null");
        goto L18
    L5:
        return r0.a();
    }

    @Override // d.b.s.a.d0.r.a
    public void c(JSONObject r8) {
        StringBuilder r5 = new StringBuilder();     // Catch: Exception -> L29
        r5.append("updateSettings: settingsJson=");     // Catch: Exception -> L29
        if (r8 == null) goto L6;
        boolean r6 = true;
    L7:
        r5.append(r6);     // Catch: Exception -> L29
        d.b.s.a.a0.a.a("BDAccountSettingsManager", r5.toString());     // Catch: Exception -> L29
        if (r8 != null) goto L10;
        return;
    L10:
        if (r8.has("data") == false) goto L12;
        r8 = r8.optJSONObject("data");     // Catch: Exception -> L29
    L12:
        if (r8 != null) goto L14;
    L19:
        if (r8 != null) goto L21;
        return;
    L21:
        if (r8.has("sdk_key_accountSDK") == false) goto L34;
        JSONObject r9 = r8.optJSONObject("sdk_key_accountSDK");     // Catch: Exception -> L29
        if (r9 == null) goto L35;
        d.b.s.a.a0.a.a("BDAccountSettingsManager", "updateSettings has account config, config length: " + r9.length());     // Catch: Exception -> L29
        f5613e = r9;     // Catch: Exception -> L29
        String r10 = r9.toString();     // Catch: Exception -> L29
        if (TextUtils.isEmpty(r10) == true) goto L27;
        h(r10);     // Catch: Exception -> L29
    L27:
        com.bytedance.sdk.account.ticketguard.f.l();     // Catch: Exception -> L29
        com.bytedance.sdk.account.ticketguard.b.f5771b.a();     // Catch: Exception -> L29
        com.ss.android.j.a.d();     // Catch: Exception -> L29
        return;
    L35:
        return;
    L34:
        return;
    L14:
        if (r8.has("app") == false) goto L17;
        r8 = r8.optJSONObject("app");     // Catch: Exception -> L29
        goto L19
    L17:
        if (r8.has("settings") == false) goto L19;
        r8 = r8.optJSONObject("settings");     // Catch: Exception -> L29
        goto L19
    L6:
        r6 = false;
    }
}
