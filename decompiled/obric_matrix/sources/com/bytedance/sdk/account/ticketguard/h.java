package com.bytedance.sdk.account.ticketguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ss.android.i.j;
import com.ss.android.token.p;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SharedPreferences f5806a;

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private static SharedPreferences.Editor b() {
        SharedPreferences r0 = c();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.edit();
    }

    private static SharedPreferences c() {
        if (f5806a != null) goto L8;
        Context r0 = j.j();
        if (r0 == null) goto L8;
        f5806a = a(r0, "account_sdk_ts_sign_cache", 0);
    L8:
        return f5806a;
    }

    public static String d(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return null;
    L5:
        SharedPreferences r0 = c();
        if (r0 != null) goto L8;
        return null;
    L8:
        return r0.getString(r2, "");
    }

    public static void e(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        d.b.s.a.a0.a.a("TsSignCacheHelper", "saveTsSign key=" + r2 + ", value=" + p.O(r3));
        SharedPreferences.Editor r0 = b();
        if (r0 == null) goto L9;
        r0.putString(r2, r3).apply();
        return;
    }
}
