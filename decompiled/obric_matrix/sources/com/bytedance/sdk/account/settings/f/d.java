package com.bytedance.sdk.account.settings.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.b.s.a.l0.m;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static JSONObject f5757a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f5758b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final m f5759c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final m f5760d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final m f5761e = null;

    static {
        f5759c = new m(null, false);
        f5760d = new m(Collections.singletonList("/passport/"), false);
        f5761e = new m(null, false);
    }

    public static boolean a(@NonNull String r4, @NonNull String r5) {
        b();
        if (f5758b == true) goto L6;
        return true;
    L6:
        if (TextUtils.isEmpty(r4) == false) goto L8;
    L28:
        return false;
    L8:
        if (TextUtils.isEmpty(r5) == true) goto L28;
        Iterator<String> r0 = f5759c.b().iterator();
    L12:
        if (r0.hasNext() == false) goto L16;
        if (r4.endsWith(r0.next()) == false) goto L12;
        return false;
    L16:
        Iterator<String> r6 = f5761e.b().iterator();
    L18:
        if (r6.hasNext() == false) goto L22;
        if (r5.startsWith(r6.next()) == false) goto L18;
        return false;
    L22:
        Iterator<String> r7 = f5760d.b().iterator();
    L24:
        if (r7.hasNext() == false) goto L28;
        if (r5.startsWith(r7.next()) == false) goto L24;
        return true;
    }

    private static boolean b() {
        JSONObject r0 = c();
        if (f5757a == r0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L12;
        f5757a = r0;
        d.b.s.a.a0.a.a("TokenSaveManager", "settings=" + f5757a);
        JSONObject r2 = f5757a;
        if (r2 == null) goto L10;
        f5758b = r2.optBoolean("enable", false);
        f5759c.h(f5757a.optJSONArray("exclude_domain_suffix"));
        f5760d.h(f5757a.optJSONArray("path_prefix"));
        m r3 = f5761e;
        JSONArray r4 = f5757a.optJSONArray("exclude_path_prefix");
    L11:
        r3.h(r4);
        d.b.s.a.a0.a.a("TokenSaveManager", "excludeDomainSuffix=" + f5759c);
        d.b.s.a.a0.a.a("TokenSaveManager", "pathPrefix=" + f5760d);
        d.b.s.a.a0.a.a("TokenSaveManager", "excludePathPrefix=" + f5761e);
        goto L12
    L10:
        f5758b = false;
        r4 = null;
        f5759c.h(null);
        f5760d.h(null);
        r3 = f5761e;
    L12:
        return r1;
    L5:
        r1 = false;
        goto L6
    }

    private static JSONObject c() {
        JSONObject r0 = a.c();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.optJSONObject("xtoken_safe_save_config");
    }
}
