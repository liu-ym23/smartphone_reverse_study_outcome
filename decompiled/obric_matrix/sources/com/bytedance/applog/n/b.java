package com.bytedance.applog.n;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.w;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class b implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Application f2255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SharedPreferences f2256b;

    b(Application r1) {
        this.f2255a = r1;
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences b(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private JSONObject c(Context r2) {
        if (r2 == null) goto L12;
        SharedPreferences r1 = d(r2);     // Catch: Exception -> L9
        if (r1 == null) goto L13;
        return new JSONObject(r1.getString("header_custom_info", null));
    L13:
        return null;
    L14:
        return null;
    L12:
        return null;
    }

    private SharedPreferences d(Context r3) {
        if (this.f2256b != null) goto L6;
        this.f2256b = b(r3, "header_custom", 0);
    L6:
        return this.f2256b;
    }

    @Override // com.bytedance.bdinstall.w
    public Map<String, Object> a() {
        JSONObject r4 = c(this.f2255a);
        if (r4 == null) goto L5;
        HashMap r0 = new HashMap();
        Iterator<String> r1 = r4.keys();
    L8:
        if (r1.hasNext() == false) goto L12;
        String r2 = r1.next();
        if (r2 == null) goto L8;
        r0.put(r2, r4.opt(r2));
        goto L8
    L12:
        return r0;
    L5:
        return Collections.emptyMap();
    }
}
