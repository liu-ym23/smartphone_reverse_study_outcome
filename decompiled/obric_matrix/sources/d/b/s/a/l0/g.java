package d.b.s.a.l0;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static g f14854b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f14855a;

    private g() {
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    public static g c() {
        if (f14854b != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f14854b != null) goto L9;
        f14854b = new g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f14854b;
    }

    public static String d(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L8;
    L6:
        return null;
    L8:
        return new URL(r2).getPath();
    }

    private SharedPreferences e() {
        if (this.f14855a != null) goto L8;
        Context r0 = com.ss.android.i.j.j();
        if (r0 == null) goto L8;
        this.f14855a = a(r0, "com_bytedance_sdk_account_utils_common_request_cache_helper", 0);
    L8:
        return this.f14855a;
    }

    private String f(String r2, Map<String, String> r3) {
        StringBuilder r1 = new StringBuilder();
        r1.append(r2);
        if (r3 == null) goto L13;
        if (r3.isEmpty() == true) goto L13;
        ArrayList r4 = new ArrayList(r3.keySet());
        Collections.sort(r4);
        Iterator r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L13;
        String r0 = r3.get((String) r5.next());
        if (r0 == null) goto L8;
        r1.append(r0);
    L13:
        return r1.toString();
    }

    public String b(String r8, Map<String, String> r9) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return null;
    L5:
        SharedPreferences r0 = e();
        if (r0 != null) goto L8;
        return null;
    L8:
        String r7 = f(r8, r9);
        String r10 = r0.getString(r7, "");
        if (TextUtils.isEmpty(r10) == false) goto L18;
        return null;
    L18:
        JSONObject r2 = new JSONObject(r10);     // Catch: Exception -> L17
        long r3 = r2.optLong("expire_timing");     // Catch: Exception -> L17
        if (System.currentTimeMillis() < r3) goto L14;
        r0.edit().putString(r7, "").apply();     // Catch: Exception -> L17
        goto L16
    L14:
        return r2.optString("cache_value", "");
    L16:
        return null;
    }

    public void g(String r3, Map<String, String> r4, String r5, long r6) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L19;
        String r7 = f(r3, r4);     // Catch: Exception -> L13
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L13
        r8.put("expire_timing", r6);     // Catch: Exception -> L13
        r8.put("cache_value", r5);     // Catch: Exception -> L13
        SharedPreferences r2 = e();     // Catch: Exception -> L13
        if (r2 != null) goto L10;
        return;
    L10:
        if (System.currentTimeMillis() >= r6) goto L18;
        r2.edit().putString(r7, r8.toString()).apply();     // Catch: Exception -> L13
        return;
    L18:
        return;
    L20:
        return;
    }
}
