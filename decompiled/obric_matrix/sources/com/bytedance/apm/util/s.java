package com.bytedance.apm.util;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CharSequence f2073a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CharSequence f2074b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f2075c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f2076d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f2077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Method f2078f;

    static {
        f2073a = "amigo";
        f2074b = "funtouch";
    }

    public static String a() {
        return m("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static String b() {
        return Build.DISPLAY + "_" + m("ro.gn.sv.version");
    }

    public static String c() {
        if (q() == true) goto L5;
        return "";
    L5:
        return "coloros_" + m("ro.build.version.opporom") + "_" + Build.DISPLAY;
    }

    public static String d() {
        Method r0 = Build.class.getDeclaredMethod("getString", new Class[]{String.class});     // Catch: Throwable -> L6
        r0.setAccessible(true);     // Catch: Throwable -> L6
        Object r1 = r0.invoke(null, new Object[]{"ro.build.version.emui"});     // Catch: Throwable -> L6
        if ((r1 instanceof String) == false) goto L11;
        return (String) r1;
    L11:
        return null;
    L6:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public static String e() {
        String r0 = g();
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.toLowerCase(Locale.getDefault()).contains("emotionui") == true) goto L7;
        return "";
    L7:
        return r0 + "_" + Build.DISPLAY;
    }

    public static String f() {
        if (r() == true) goto L5;
        return "";
    L5:
        return "eui_" + m("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    public static String g() {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return m("ro.build.version.emui");
    L7:
        return d();
    }

    public static String h() {
        String r0 = Build.DISPLAY;
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.toLowerCase(Locale.getDefault()).contains("flyme") == false) goto L9;
        return r0;
    L9:
        return "";
    }

    public static String i() {
        return m("ro.vivo.os.build.display.id") + "_" + m("ro.vivo.product.version");
    }

    public static String j() {
        if (v() == true) goto L5;
        return "";
    L5:
        return "miui_" + m("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    private static String k() {
        if (v() == false) goto L7;
        return j();
    L7:
        if (s() == false) goto L11;
        return h();
    L11:
        if (q() == true) goto L13;
        String r0 = e();
        if (TextUtils.isEmpty(r0) == true) goto L18;
        return r0;
    L18:
        if (t() == false) goto L22;
        return i();
    L22:
        if (p() == false) goto L26;
        return b();
    L26:
        if (o() == true) goto L28;
        String r1 = f();
        if (TextUtils.isEmpty(r1) == true) goto L32;
        return r1;
    L32:
        f2076d = true;
        return Build.DISPLAY;
    L28:
        return a();
    L13:
        return c();
    }

    public static String l() {
        if (f2076d == true) goto L5;
    L8:
        String r0 = k();
        f2077e = r0;
        return r0;
    L5:
        if (TextUtils.isEmpty(f2077e) == true) goto L8;
        return f2077e;
    }

    private static String m(String r5) {
        String r0 = n(r5);
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        String r1 = "";
        BufferedReader r2 = null;
        Process r6 = Runtime.getRuntime().exec("getprop " + r5);     // Catch: Throwable -> L13
        BufferedReader r3 = new BufferedReader(new InputStreamReader(r6.getInputStream()), 1024);     // Catch: Throwable -> L13
        r1 = r3.readLine();     // Catch: Throwable -> L10
        r6.destroy();     // Catch: Throwable -> L10
        d.b.l.a.d.b(r3);
        return r1;
    L10:
        r2 = r3;
    L11:
        d.b.l.a.d.b(r2);
        return r1;
    }

    private static String n(String r6) {
    L7:
        e = move-exception;
        e.printStackTrace();
        return "";
    L3:
        if (f2078f != null) goto L5;
        f2078f = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});     // Catch: Exception -> L7
    L5:
        return (String) f2078f.invoke(null, new Object[]{r6});
    }

    public static boolean o() {
        String r0 = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return false;
    L5:
        String r1 = r0.toLowerCase(Locale.getDefault());
        if (r1.contains("360") == false) goto L8;
    L9:
        return true;
    L8:
        if (r1.contains("qiku") == true) goto L9;
        return false;
    }

    public static boolean p() {
        String r0 = Build.DISPLAY;
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L7:
        return false;
    L5:
        if (r0.toLowerCase(Locale.getDefault()).contains(f2073a) == false) goto L7;
        return true;
    }

    public static boolean q() {
        String r0 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return false;
    L5:
        return r0.toLowerCase(Locale.getDefault()).contains("oppo");
    }

    public static boolean r() {
        return !TextUtils.isEmpty(m("ro.letv.release.version"));
    }

    public static boolean s() {
        if (Build.DISPLAY.contains("Flyme") == false) goto L5;
        return true;
    L5:
        if ("flyme".equals(Build.USER) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean t() {
        String r0 = m("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L7:
        return false;
    L5:
        if (r0.toLowerCase(Locale.getDefault()).contains(f2074b) == false) goto L7;
        return true;
    }

    public static boolean u() {
        String r1 = Build.BRAND;     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r1) == false) goto L7;
    L8:
        String r2 = Build.MANUFACTURER;     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r2) == true) goto L17;
        if (r2.toLowerCase().startsWith("hua") == false) goto L18;
    L12:
        return true;
    L18:
        return false;
    L17:
        return false;
    L7:
        if (r1.toLowerCase().startsWith("hua") == true) goto L12;
    L19:
        return false;
    }

    public static boolean v() {
        if (Class.forName("miui.os.Build") == null) goto L7;
        f2075c = true;     // Catch: Exception -> L8
        return true;
    L7:
        return f2075c;
    }
}
