package d.b.s.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import d.b.s.a.l0.s;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f14726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static SharedPreferences f14727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f14728c;

    public f() {
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    public static Pair<Integer, String> b(String r2) {
        String r3 = c(r2);
        if (TextUtils.isEmpty(r3) == true) goto L5;
        int r0 = 1;
    L10:
        return new Pair(Integer.valueOf(r0), r3);
    L5:
        r3 = d();
        if (TextUtils.isEmpty(r3) == true) goto L8;
        r0 = -2;
        goto L10
    L8:
        r0 = 0;
        goto L10
    }

    public static String c(String r2) {
        String r0 = s.e(r2, "passport_csrf_token");
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        return s.e(r2, "passport_csrf_token_default");
    }

    public static String d() {
        h();
        return f14728c;
    }

    public static String e() {
        boolean r0 = !TextUtils.isEmpty(d());
        boolean r1 = !TextUtils.isEmpty(c(com.ss.android.i.j.k().c()));
        if (r0 == false) goto L6;
        if (r1 == false) goto L6;
        return "both";
    L6:
        if (r0 == false) goto L8;
        return "sp";
    L8:
        if (r1 == false) goto L10;
        return "cookie";
    L10:
        return "none";
    }

    public static boolean f() {
        h();
        return !TextUtils.isEmpty(f14728c);
    }

    public static void g(String r2) {
        h();
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        if (TextUtils.equals(r2, f14728c) == true) goto L10;
        f14728c = r2;
        f14727b.edit().putString("csrf_token", r2).apply();
        return;
    }

    public static void h() {
        if (f14726a == false) goto L5;
        return;
    L5:
        monitor-enter(f.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (f14726a == true) goto L13;
        Context r1 = com.ss.android.i.j.j();     // Catch: Throwable -> L15
        if (r1 != null) goto L12;
        monitor-exit(f.class);     // Catch: Throwable -> L15
        return;
    L12:
        SharedPreferences r2 = a(r1, "CsrfTokenManager_sp", 0);     // Catch: Throwable -> L15
        f14727b = r2;     // Catch: Throwable -> L15
        f14728c = r2.getString("csrf_token", null);     // Catch: Throwable -> L15
        f14726a = true;     // Catch: Throwable -> L15
    L13:
        monitor-exit(f.class);     // Catch: Throwable -> L15
    }
}
