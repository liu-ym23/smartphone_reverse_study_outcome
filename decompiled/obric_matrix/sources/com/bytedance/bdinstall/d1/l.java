package com.bytedance.bdinstall.d1;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CharSequence f2734a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final n<Boolean> f2735b = null;

    class a extends n<Boolean> {
        a() {
        }

        @Override // com.bytedance.bdinstall.d1.n
        protected /* bridge */ /* synthetic */ Boolean a(Object[] r1) {
            return c(r1);
        }

        protected Boolean c(Object... r3) {
            Class<?> r2 = Class.forName("com.huawei.system.BuildEx");     // Catch: Throwable -> L4
            return Boolean.valueOf("harmony".equals(r2.getMethod("getOsBrand", new Class[0]).invoke(r2, new Object[0])));
        L4:
            com.bytedance.bdinstall.q.g("isn't harmony");
            return Boolean.FALSE;
        }
    }

    static {
        f2734a = "amigo";
        f2735b = new a();
    }

    public static boolean A(Context r1) {
        if (r1.getApplicationInfo().targetSdkVersion < 29) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean B(Context r1) {
        if (r1.getApplicationInfo().targetSdkVersion < 30) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean C() {
        return !TextUtils.isEmpty(m("ro.vivo.os.build.display.id"));
    }

    public static String a() {
        return m("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static String b() {
        return Build.DISPLAY + "_" + m("ro.gn.sv.version");
    }

    public static String c() {
        if (r() == true) goto L5;
        return "";
    L5:
        return "coloros_" + m("ro.build.version.opporom") + "_" + Build.DISPLAY;
    }

    public static String d() {
        String r0 = f();
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.toLowerCase().contains("emotionui") == true) goto L9;
        if (r0.toLowerCase().contains("magicui") == true) goto L9;
        return "";
    L9:
        return r0 + "_" + Build.DISPLAY;
    }

    public static String e() {
        if (s() == true) goto L5;
        return "";
    L5:
        return "eui_" + m("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    public static String f() {
        return m("ro.build.version.emui");
    }

    public static String g() {
        String r0 = Build.DISPLAY;
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.toLowerCase().contains("flyme") == false) goto L9;
        return r0;
    L9:
        return "";
    }

    public static String h() {
        return m("ro.vivo.os.build.display.id") + "_" + m("ro.vivo.product.version");
    }

    public static String i() {
        if (z() == true) goto L5;
        return "";
    L5:
        return "miui_" + m("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    public static String j() {
        String r0 = l("persist.pxr.product.forcename", "");
        if (TextUtils.isEmpty(r0) == false) goto L6;
        r0 = l("pxr.vendorhw.product.name", "");
    L6:
        if (TextUtils.isEmpty(r0) == true) goto L8;
        return r0;
    L8:
        return Build.PRODUCT;
    }

    public static String k() {
        if (z() == false) goto L7;
        return i();
    L7:
        if (r() == true) goto L9;
        String r0 = d();
        if (TextUtils.isEmpty(r0) == true) goto L14;
        return r0;
    L14:
        if (C() == false) goto L18;
        return h();
    L18:
        if (t() == false) goto L22;
        return g();
    L22:
        if (o() == false) goto L26;
        return b();
    L26:
        if (n() == true) goto L28;
        String r1 = e();
        if (TextUtils.isEmpty(r1) == true) goto L33;
        return r1;
    L33:
        return Build.DISPLAY;
    L28:
        return a();
    L9:
        return c();
    }

    public static String l(String r7, String r8) {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{r7, r8});
    L5:
        return r8;
    }

    private static String m(String r0) {
        return (String) q.a(r0);
    }

    public static boolean n() {
        String r0 = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return false;
    L5:
        String r1 = r0.toLowerCase();
        if (r1.contains("360") == false) goto L8;
    L9:
        return true;
    L8:
        if (r1.contains("qiku") == true) goto L9;
        return false;
    }

    public static boolean o() {
        String r0 = Build.DISPLAY;
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L7:
        return false;
    L5:
        if (r0.toLowerCase().contains(f2734a) == false) goto L7;
        return true;
    }

    public static boolean p() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 29) goto L5;
    L10:
        return true;
    L5:
        if (r0 == 28) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    public static boolean q() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 30) goto L5;
    L10:
        return true;
    L5:
        if (r0 == 29) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    public static boolean r() {
        String r0 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return false;
    L5:
        return r0.toLowerCase().contains("oppo");
    }

    public static boolean s() {
        return !TextUtils.isEmpty(m("ro.letv.release.version"));
    }

    public static boolean t() {
        String r0 = Build.DISPLAY;
        if (TextUtils.isEmpty(r0) == true) goto L7;
        if (r0.contains("Flyme") == false) goto L7;
    L8:
        return true;
    L7:
        if ("flyme".equals(Build.USER) == true) goto L8;
        return false;
    }

    public static boolean u() {
        return f2735b.b(new Object[0]).booleanValue();
    }

    public static boolean v() {
        String r0 = Build.BRAND;
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L6:
        String r1 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r1) == false) goto L9;
    L11:
        return false;
    L9:
        if (r1.toLowerCase().startsWith("honor") == false) goto L11;
    L10:
        return true;
    L5:
        if (r0.toLowerCase().startsWith("honor") == true) goto L10;
        goto L6
    }

    private static boolean w() {
        String r0 = Build.BRAND;
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L6:
        String r1 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r1) == false) goto L9;
    L11:
        return false;
    L9:
        if (r1.toLowerCase().startsWith("huawei") == false) goto L11;
    L10:
        return true;
    L5:
        if (r0.toLowerCase().startsWith("huawei") == true) goto L10;
        goto L6
    }

    public static boolean x(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        r3 = f();
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L13;
        if (r3.toLowerCase().contains("emotionui") == false) goto L10;
    L11:
        return true;
    L10:
        if (r3.toLowerCase().contains("magicui") == true) goto L11;
    L13:
        if (w() == false) goto L15;
        return true;
    L15:
        if (v() == true) goto L20;
        return false;
    L20:
        return true;
    }

    public static boolean y() {
        String r0 = Build.BRAND;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.toLowerCase(Locale.ENGLISH).contains("meizu");
    }

    public static boolean z() {
        if (Class.forName("miui.os.Build").getName().length() <= 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }
}
