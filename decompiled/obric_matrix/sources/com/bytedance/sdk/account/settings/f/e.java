package com.bytedance.sdk.account.settings.f;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static JSONObject f5762a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f5763b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f5764c = false;

    static {
    }

    private static boolean a() {
        JSONObject r0 = b();
        if (f5762a == r0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L11;
        f5762a = r0;
        d.b.s.a.a0.a.a("TokenUseSettingsManager", "settings=" + f5762a);
        JSONObject r2 = f5762a;
        if (r2 == null) goto L10;
        f5763b = r2.optBoolean("enable_http_forbid", false);
        f5764c = f5762a.optBoolean("enable_http_request_track", false);
        goto L11
    L10:
        f5763b = false;
        f5764c = false;
    L11:
        return r1;
    L5:
        r1 = false;
        goto L6
    }

    private static JSONObject b() {
        JSONObject r0 = a.c();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.optJSONObject("xtoken_safe_use_config");
    }

    public static boolean c() {
        a();
        return f5763b;
    }

    public static boolean d() {
        a();
        return f5764c;
    }
}
