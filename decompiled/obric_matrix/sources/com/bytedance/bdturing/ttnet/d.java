package com.bytedance.bdturing.ttnet;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.net.URL;
import java.util.Map;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class d {
    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    public static void b(Context r1, String r2, Map<String, String> r3) {
        boolean r4 = c(r1, r2);     // Catch: Exception -> L8
        StringBuilder r5 = new StringBuilder();     // Catch: Exception -> L8
        r5.append("");     // Catch: Exception -> L8
        r5.append("n=");     // Catch: Exception -> L8
        if (r4 == false) goto L5;
        int r6 = 1;
    L6:
        r5.append(r6);     // Catch: Exception -> L8
        r5.append(";");     // Catch: Exception -> L8
        r3.put("x-tt-request-tag", r5.toString() + "t=0");     // Catch: Exception -> L8
        return;
    L5:
        r6 = 0;
    }

    private static boolean c(Context r2, String r3) {
        URL r0 = new URL(r3);
        if (TextUtils.isEmpty(r0.getPath()) == false) goto L5;
        return true;
    L5:
        if (r0.getPath().contains("vc/setting") == true) goto L7;
        return true;
    L7:
        return true ^ a(r2, "bd_turning_settings_init", 0).getBoolean("inited", false);
    }
}
