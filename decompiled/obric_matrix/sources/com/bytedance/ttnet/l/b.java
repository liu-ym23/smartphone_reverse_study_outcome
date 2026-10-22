package com.bytedance.ttnet.l;

import android.content.Context;
import android.content.SharedPreferences;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f6469a = "ttnet_debug_setting";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f6470b = "log_switcher";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f6471c = "x86_support";

    static {
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private static String b(Context r3, String r4) {
        if (r3 != null) goto L5;
        return null;
    L5:
        return a(r3, f6469a, 0).getString(r4, null);
    }

    public static boolean c(Context r1) {
        return "true".equals(b(r1, f6470b));
    }

    public static boolean d(Context r1) {
        return "true".equals(b(r1, f6471c));
    }
}
