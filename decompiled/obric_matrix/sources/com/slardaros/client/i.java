package com.slardaros.client;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.obric.olog.OLog;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f11676a = false;

    static {
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private static void b() {
        Context r1 = c();
        if (r1 != null) goto L14;
        return;
    L14:
        SharedPreferences r2 = a(r1, "slardar_client_sdk", 0);     // Catch: Exception -> L10
        String r4 = r2.getString("last_version_code", "");     // Catch: Exception -> L10
        String r3 = m.e(r1);     // Catch: Exception -> L10
        if (TextUtils.equals(r4, r3) == true) goto L8;
        f11676a = true;     // Catch: Exception -> L10
        r2.edit().putString("last_version_code", r3).apply();     // Catch: Exception -> L10
    L13:
        return;
    L8:
        f11676a = false;     // Catch: Exception -> L10
    L10:
        e = move-exception;
        OLog.d("SlardarAgent", "checkWhetherFirstInstall" + e.getMessage());
    }

    public static Context c() {
        return ((k) e.a()).f();
    }

    public static void d(Context r3) {
        OLog.c("SlardarAgent", "on init");     // Catch: Throwable -> L7
        e.a().b(r3);     // Catch: Throwable -> L7
        if (m.f() == false) goto L12;
        b();     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        OLog.d("SlardarAgent", "init " + th.getMessage());
    }

    public static boolean e() {
        return f11676a;
    }

    private static void f(String r8, String r9, String r10, String r11, boolean r12, String r13, boolean r14) {
        if (m.b(new String[]{r8, r9, r10}) == true) goto L7;
        OLog.d("Slardaros_Agent", "tag, type, summary can't be empty");
        return;
    L7:
        if (m.c(((k) e.a()).f(), r8) == false) goto L9;
        return;
    L9:
        if (r13 != null) goto L22;
        r13 = ((k) e.a()).f().getPackageName();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        r13 = EnvironmentCompat.MEDIA_UNKNOWN;
    L22:
        e.a().c(new f("custom_error", r9, r10, r11, r12, r13, r14));     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        OLog.d("SlardarAgent", "sendCustomError " + th.getMessage());
    }

    public static void g(String r9, String r10, String r11, boolean r12, String r13, boolean r14) {
        OLog.c("SlardarAgent", "sendCustomError");     // Catch: Throwable -> L5
        f("custom_error", r9, r10, r11, r12, r13, r14);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        OLog.d("SlardarAgent", "sendCustomError " + th.getMessage());
    }
}
