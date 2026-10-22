package com.bytedance.sdk.account.ticketguard;

import com.ss.android.i.j;
import d.b.s.a.l0.m;
import java.util.Arrays;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static JSONObject f5772a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f5773b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f5774c = null;

    static {
        f5774c = new m(new HashSet(Arrays.asList(new String[]{"/passport/device/trust_users/", "/passport/device/one_login/"})), true);
    }

    private static boolean a() {
        JSONObject r0 = b();
        if (f5772a == r0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L12;
        f5772a = r0;
        if (r0 == null) goto L10;
        f5773b = r0.optBoolean("enable_sec_user_id_guard", false);
        m r2 = f5774c;
        JSONArray r3 = f5772a.optJSONArray("sec_user_id_guard_paths");
    L11:
        r2.h(r3);
        goto L12
    L10:
        f5773b = false;
        r2 = f5774c;
        r3 = null;
    L12:
        return r1;
    L5:
        r1 = false;
        goto L6
    }

    private static JSONObject b() {
        com.ss.android.d r0 = j.l();
        if (r0 != null) goto L5;
        return null;
    L5:
        JSONObject r1 = com.bytedance.sdk.account.impl.g.b(r0.e()).b();
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.optJSONObject("sec_user_id_guard_config");
    }

    public static boolean c() {
        a();
        return f5773b;
    }

    public static boolean d(String r1) {
        a();
        return f5774c.b().contains(r1);
    }
}
