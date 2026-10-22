package com.slardaros.client;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.obric.olog.OLog;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Boolean f11703a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f11704b = false;

    static {
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    public static boolean b(String... r3) {
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L9;
        if (TextUtils.isEmpty(r3[r1]) == true) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public static boolean c(Context r8, String r9) {
        SharedPreferences r10 = a(r8, r9, 0);     // Catch: Exception -> L12
        long r4 = r10.getLong("time_start", 0);     // Catch: Exception -> L12
        int r11 = r10.getInt("count", 0);     // Catch: Exception -> L12
        if ((System.currentTimeMillis() - r4) <= 300000) goto L8;
        r10.edit().putLong("time_start", System.currentTimeMillis()).putInt("count", 1).apply();     // Catch: Exception -> L12
        return false;
    L8:
        if (r11 < 5) goto L10;
        return true;
    L10:
        r10.edit().putInt("count", r11 + 1).apply();     // Catch: Exception -> L12
        return false;
    L12:
        return true;
    }

    private static String d() {
        BufferedReader r3 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L16
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L14
    L5:
        int r4 = r3.read();     // Catch: Throwable -> L14
        if (r4 <= 0) goto L8;
        r2.append((char) r4);     // Catch: Throwable -> L14
        goto L5
    L8:
        String r5 = r2.toString();     // Catch: Throwable -> L14
        r3.close();     // Catch: Exception -> L11
    L13:
        return r5;
    L11:
        e = move-exception;
        OLog.d("Slardaros_Agent", "getCurProcessNameFromProc: " + e.getMessage());
    L14:
        Throwable th = th;
    L39:
        OLog.d("Slardaros_Agent", "getCurProcessNameFromProc: " + th.getMessage());     // Catch: Throwable -> L26
        if (r3 == null) goto L46;
        r3.close();     // Catch: Exception -> L22
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L22:
        e = move-exception;
        OLog.d("Slardaros_Agent", "getCurProcessNameFromProc: " + e.getMessage());
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L46:
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L26:
        th = move-exception;
        if (r3 != null) goto L41;
    L32:
        throw th;
    L41:
        r3.close();     // Catch: Exception -> L30
    L30:
        e = move-exception;
        OLog.d("Slardaros_Agent", "getCurProcessNameFromProc: " + e.getMessage());
    L16:
        th = move-exception;
        r3 = null;
        th = th;
        goto L39
    }

    public static String e(Context r3) {
        return r3.getPackageManager().getPackageInfo(r3.getPackageName(), 0).versionCode + "";
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static boolean f() {
        if (f11704b == false) goto L6;
        return true;
    L6:
        Context r0 = i.c();
        if (r0 == null) goto L9;
        String r1 = d();
        if (r1.contains(":") == false) goto L13;
        boolean r2 = false;
    L14:
        f11704b = r2;
        return f11704b;
    L13:
        r2 = r1.equals(r0.getPackageName());
        goto L14
    L9:
        return g();
    }

    public static boolean g() {
        if (f11704b == false) goto L6;
        return true;
    L6:
        return !d().contains(":");
    }

    public static boolean h(Context r5) {
        Boolean r0 = f11703a;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L9:
        Intent r2 = new Intent("com.bytedance.os.slardar.ACTION_SLARDAR_SERVICE");
        List<ResolveInfo> r3 = null;
        if (r5 == null) goto L12;
        PackageManager r6 = r5.getPackageManager();
    L14:
        if (r6 == null) goto L16;
        r3 = r6.queryIntentServices(r2, 0);
    L17:
        if (r3 != null) goto L19;
    L21:
        String r7 = "resolveInfoList is null or empty";
    L22:
        OLog.c("Slardaros_Agent", r7);
        if (r3 != null) goto L25;
    L29:
        r1 = false;
    L30:
        Boolean r8 = Boolean.valueOf(r1);
        f11703a = r8;
    L8:
        return r8.booleanValue();
    L25:
        if (r3.size() != 1) goto L29;
        if ("com.bytedance.os.slardar".equals(r3.get(0).serviceInfo.packageName) == false) goto L29;
    L19:
        if (r3.size() < 1) goto L21;
        r7 = "resolveInfoList size: " + r3.size() + " first name: " + r3.get(0).serviceInfo.packageName;
        goto L22
    L16:
        OLog.c("Slardaros_Agent", "packageManager is null");
        goto L17
    L12:
        r6 = null;
        goto L14
    L5:
        if (r0.booleanValue() != true) goto L9;
        r8 = f11703a;
        goto L8
    }
}
