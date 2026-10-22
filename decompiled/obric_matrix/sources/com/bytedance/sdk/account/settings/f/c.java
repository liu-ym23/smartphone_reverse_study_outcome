package com.bytedance.sdk.account.settings.f;

import d.b.s.a.l0.m;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static JSONObject f5751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f5752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final m f5753c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final m f5754d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final m f5755e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f5756f = null;

    static {
        f5756f = new c();
        f5753c = new m(null, true);
        f5754d = new m(null, true);
        f5755e = new m(null, true);
    }

    private c() {
    }

    private final boolean a() {
        JSONObject r0 = b();
        boolean r2 = false;
        if (f5751a == r0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L22;
        f5751a = r0;
        if (r0 == null) goto L10;
        r2 = r0.optBoolean("enable", false);
    L10:
        f5752b = r2;
        m r3 = f();
        JSONObject r4 = f5751a;
        JSONArray r5 = null;
        if (r4 == null) goto L13;
        JSONArray r6 = r4.optJSONArray("save_headers");
    L14:
        r3.h(r6);
        m r7 = c();
        JSONObject r8 = f5751a;
        if (r8 == null) goto L17;
        JSONArray r9 = r8.optJSONArray("deprecate_headers");
    L18:
        r7.h(r9);
        m r10 = e();
        JSONObject r11 = f5751a;
        if (r11 == null) goto L21;
        r5 = r11.optJSONArray("logout_clear_headers");
    L21:
        r10.h(r5);
        goto L22
    L17:
        r9 = null;
        goto L18
    L13:
        r6 = null;
    L22:
        return r1;
    L5:
        r1 = false;
        goto L6
    }

    private final JSONObject b() {
        JSONObject r1 = a.c();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.optJSONObject("handle_passport_extra_header");
    }

    public final m c() {
        a();
        return f5754d;
    }

    public final boolean d() {
        a();
        return f5752b;
    }

    public final m e() {
        a();
        return f5755e;
    }

    public final m f() {
        a();
        return f5753c;
    }
}
