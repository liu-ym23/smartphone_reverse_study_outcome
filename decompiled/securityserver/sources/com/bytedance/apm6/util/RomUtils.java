package com.bytedance.apm6.util;

import a.a;
import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class RomUtils {
    private static final CharSequence AMIGO = null;
    public static final String COLOROS = "coloros";
    public static final String EMUI = "emotionui";
    private static final String EUI = "eui";
    public static final String FLYME = "flyme";
    private static final String FOUTOUCH_OS_SOFTWARE_VERSION = "ro.vivo.product.version";
    private static final CharSequence FUNTOUCHOS = null;
    private static final String FUNTOUCH_OS_VERSION = "ro.vivo.os.build.display.id";
    private static final String KEY_360OS = "ro.build.uiversion";
    public static final String MIUI = "miui";
    private static final String MODEL_LETV = "ro.letv.release.version";
    public static final String RUNTIME_MIUI = "ro.miui.ui.version.name";
    public static final String RUNTIME_OPPO = "ro.build.version.opporom";
    public static final String SEPARATOR = "_";
    private static final CharSequence SONY = null;
    private static String romInfo = null;
    public static boolean sIsInited = false;
    public static boolean sIsMiui = false;
    private static Method sSystemPropertiesGetMethod;

    static {
        SONY = "sony";
        AMIGO = "amigo";
        FUNTOUCHOS = "funtouch";
    }

    private RomUtils() {
    }

    public static String get360OSVersion() {
        return getSystemProperty(KEY_360OS) + "_" + Build.DISPLAY;
    }

    public static String getAmigoVersion() {
        return Build.DISPLAY + "_" + getSystemProperty("ro.gn.sv.version");
    }

    public static String getColorOsVersion() {
        if (isColorOS() == true) goto L5;
        return "";
    L5:
        return "coloros_" + getSystemProperty("ro.build.version.opporom") + "_" + Build.DISPLAY;
    }

    public static String getEMUI() {
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

    public static String getEMUVersion() {
        String r0 = getEmuiInfo();
        if (r0 != null) goto L5;
        return "";
    L5:
        if (a.z(r0, "emotionui") == false) goto L10;
        StringBuilder r1 = a.t(r0, "_");
        r1.append(Build.DISPLAY);
        return r1.toString();
    L10:
        return "";
    }

    public static String getEUIVersion() {
        if (isEUI() == true) goto L5;
        return "";
    L5:
        return "eui_" + getSystemProperty(MODEL_LETV) + "_" + Build.DISPLAY;
    }

    public static String getEmuiInfo() {
        return getSystemProperty("ro.build.version.emui");
    }

    public static String getFlymeVersion() {
        String r0 = Build.DISPLAY;
        if (r0 != null) goto L5;
        return "";
    L5:
        if (a.z(r0, "flyme") == false) goto L9;
        return r0;
    L9:
        return "";
    }

    public static String getFuntouchOSVersion() {
        return getSystemProperty(FUNTOUCH_OS_VERSION) + "_" + getSystemProperty(FOUTOUCH_OS_SOFTWARE_VERSION);
    }

    public static String getMIUIVersion() {
        if (isMiui() == true) goto L5;
        return "";
    L5:
        return "miui_" + getSystemProperty("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    private static String getRom() {
        if (isMiui() == false) goto L7;
        return getMIUIVersion();
    L7:
        if (isFlyme() == false) goto L11;
        return getFlymeVersion();
    L11:
        if (isColorOS() == true) goto L13;
        String r0 = getEMUVersion();
        if (TextUtils.isEmpty(r0) == true) goto L18;
        return r0;
    L18:
        if (isFunTouchOS() == false) goto L22;
        return getFuntouchOSVersion();
    L22:
        if (isAmigo() == false) goto L26;
        return getAmigoVersion();
    L26:
        if (is360OS() == true) goto L28;
        String r1 = getEUIVersion();
        if (TextUtils.isEmpty(r1) == true) goto L32;
        return r1;
    L32:
        sIsInited = true;
        return Build.DISPLAY;
    L28:
        return get360OSVersion();
    L13:
        return getColorOsVersion();
    }

    public static String getRomInfo() {
        if (sIsInited == true) goto L5;
    L8:
        String r0 = getRom();
        romInfo = r0;
        return r0;
    L5:
        if (TextUtils.isEmpty(romInfo) == true) goto L8;
        return romInfo;
    }

    private static String getSystemProperty(String r5) {
        String r1 = getSystemPropertyByReflect(r5);
        if (TextUtils.isEmpty(r1) == true) goto L5;
        return r1;
    L5:
        String r2 = "";
        BufferedReader r3 = null;
        Process r6 = Runtime.getRuntime().exec("getprop " + r5);     // Catch: Throwable -> L13
        BufferedReader r0 = new BufferedReader(new InputStreamReader(r6.getInputStream()), 1024);     // Catch: Throwable -> L13
        r2 = r0.readLine();     // Catch: Throwable -> L10
        r6.destroy();     // Catch: Throwable -> L10
        IOUtils.closeQuietly(r0);
        return r2;
    L10:
        r3 = r0;
    L11:
        IOUtils.closeQuietly(r3);
        return r2;
    }

    private static String getSystemPropertyByReflect(String r3) {
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    L3:
        if (sSystemPropertiesGetMethod != null) goto L7;
        sSystemPropertiesGetMethod = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});     // Catch: Exception -> L5
    L7:
        return (String) sSystemPropertiesGetMethod.invoke(null, new Object[]{r3});
    }

    public static boolean is360OS() {
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

    public static boolean isAmigo() {
        String r0 = Build.DISPLAY;
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L7:
        return false;
    L5:
        if (r0.toLowerCase(Locale.getDefault()).contains(AMIGO) == false) goto L7;
        return true;
    }

    public static boolean isColorOS() {
        String r0 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return false;
    L5:
        return a.z(r0, "oppo");
    }

    public static boolean isEUI() {
        return !TextUtils.isEmpty(getSystemProperty(MODEL_LETV));
    }

    public static boolean isEmui(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        r2 = getEmuiInfo();
    L6:
        if (TextUtils.isEmpty(r2) == true) goto L11;
        if (r2.toLowerCase().startsWith("emotionui") == false) goto L11;
        return true;
    L11:
        if (isHwDevice() == false) goto L13;
        return true;
    L13:
        return false;
    }

    public static boolean isFlyme() {
        if (Build.DISPLAY.contains("Flyme") == false) goto L5;
        return true;
    L5:
        if ("flyme".equals(Build.USER) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean isFunTouchOS() {
        String r0 = getSystemProperty(FUNTOUCH_OS_VERSION);
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L7:
        return false;
    L5:
        if (r0.toLowerCase(Locale.getDefault()).contains(FUNTOUCHOS) == false) goto L7;
        return true;
    }

    public static boolean isHwDevice() {
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

    public static boolean isMiui() {
        Class.forName("miui.os.Build");     // Catch: Exception -> L4
        sIsMiui = true;     // Catch: Exception -> L4
        return true;
    L5:
        return sIsMiui;
    }

    public static boolean isSony() {
        String r0 = Build.BRAND + Build.MANUFACTURER;
        if (TextUtils.isEmpty(r0) == true) goto L5;
    L8:
        return true;
    L5:
        if (r0.toLowerCase(Locale.getDefault()).contains(SONY) == true) goto L8;
        return false;
    }
}
