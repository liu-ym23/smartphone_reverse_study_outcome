package com.bytedance.android.standard.tools.device;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.os.EnvironmentCompat;
import com.android.settings.MultiSimAdapter;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.bytedance.android.standard.tools.R;
import com.bytedance.android.standard.tools.logging.Logger;
import com.bytedance.android.standard.tools.reflect.ReflectUtils;
import com.bytedance.android.standard.tools.string.StringUtils;
import com.bytedance.android.standard.tools.ui.UIUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: loaded from: classes3.dex */
public final class DeviceUtils {
    private static final int DEFAULT_CACHE_SIZE = 1024;
    private static final String IMMERSION_EMUI_NAVIGATION_BAR_HIDE_SHOW = "navigationbar_is_min";
    private static final String IMMERSION_MIUI_NAVIGATION_BAR_HIDE_SHOW = "force_fsg_nav_bar";
    static final String IMMERSION_NAVIGATION_BAR_HEIGHT = "navigation_bar_height";
    private static final String KEY_SYSTEM_PROPERTIES_CACHE = "system_properties_cache";
    private static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    private static final String KEY_VERSION_GIONEE = "ro.gn.sv.version";
    private static final String KEY_VERSION_LENOVO = "ro.lenovo.lvp.version";
    private static final String KEY_VERSION_MAGIC = "ro.build.version.magic";
    private static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final String KEY_VERSION_OPPO = "ro.build.version.opporom";
    private static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    private static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
    public static final String ROM_EMUI = "EMUI";
    public static final String ROM_FLYME = "FLYME";
    public static final String ROM_GIONEE = "QIONEE";
    public static final String ROM_LENOVO = "LENOVO";
    public static final String ROM_MAGIC = "magic";
    public static final String ROM_MIUI = "MIUI";
    public static final String ROM_OPPO = "OPPO";
    public static final String ROM_QIKU = "QIKU";
    public static final String ROM_SAMSUNG = "samsung";
    public static final String ROM_SMARTISAN = "SMARTISAN";
    public static final String ROM_VIVO = "VIVO";
    public static final String ROM_ZTE = "zte";
    private static final Map<String, String> SYSTEM_PROPERTIES_CACHE = null;
    private static final String TAG = "DeviceUtils";
    public static boolean deviceDataHasInit = false;
    public static int displayMetricsHeightPixels = 0;
    public static int displayMetricsWidthPixels = 0;
    private static Boolean isCoolpad = null;
    private static Boolean isEmui = null;
    private static int mIsFoldableScreen = -1;
    private static volatile Properties properties = null;
    private static int sEmuiLevel = -1;
    private static boolean sIsMiui = false;
    private static boolean sIsMiuiInited = false;
    private static String sMiuiVersion;
    private static String sName;
    private static int sStatusBarHeight;
    private static String sVersion;

    private DeviceUtils() {
    }

    public static boolean isEmui() {
        Boolean r0 = isEmui;
        if (r0 != null) goto L5;
        boolean r1 = false;
        Method r2 = Build.class.getDeclaredMethod("getString", new Class[]{String.class});     // Catch: Throwable -> L14
        r2.setAccessible(true);     // Catch: Throwable -> L14
        Object r3 = r2.invoke(null, new Object[]{KEY_VERSION_EMUI});     // Catch: Throwable -> L14
        if ((r3 instanceof String) == true) goto L10;
    L16:
        isEmui = Boolean.valueOf(r1);
        return r1;
    L10:
        if (StringUtils.isEmpty((String) r3) == true) goto L16;
        if (EnvironmentCompat.MEDIA_UNKNOWN.equals((String) r3) == true) goto L16;
        r1 = true;
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L16
    L5:
        return r0.booleanValue();
    }

    public static boolean isCoolpad() {
        Boolean r0 = isCoolpad;
        if (r0 != null) goto L5;
        String r1 = Build.BRAND;
        if (TextUtils.isEmpty(r1) == true) goto L9;
        isCoolpad = Boolean.valueOf(r1.toLowerCase(Locale.getDefault()).contains("coolpad"));
    L11:
        return isCoolpad.booleanValue();
    L9:
        isCoolpad = false;
        goto L11
    L5:
        return r0.booleanValue();
    }

    public static boolean isWifiProxy(Context r1) {
        String r2 = System.getProperty("http.proxyHost");
        String r0 = System.getProperty("http.proxyPort");
        if (r0 != null) goto L6;
        r0 = "-1";
    L6:
        int r3 = Integer.parseInt(r0);
        if (TextUtils.isEmpty(r2) == false) goto L9;
    L11:
        return false;
    L9:
        if (r3 == (-1)) goto L11;
        return true;
    }

    public static boolean isInstallXposed() {
    L4:
        e = move-exception;
        StackTraceElement[] r0 = e.getStackTrace();
        int r1 = r0.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L12;
        if (r0[r3].getClassName().contains("de.robv.android.xposed") == true) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    L3:
        throw new Exception("hook");     // Catch: Exception -> L4
    }

    public static void setNoScreenCap(Activity r1) {
        r1.getWindow().setFlags(8192, 8192);
    }

    private static boolean checkHuaweiFoldableList(String r2) {
        if (TextUtils.equals(r2, "HWTAH") == false) goto L6;
        return true;
    L6:
        if (TextUtils.equals(r2, "unknownRLI") == false) goto L9;
        return true;
    L9:
        if (TextUtils.equals(r2, "unknownRHA") == false) goto L12;
        return true;
    L12:
        if (TextUtils.equals(r2, "HWTAH-C") == false) goto L15;
        return true;
    L15:
        if (TextUtils.equals(r2, "unknownTXL") == false) goto L17;
        return true;
    L17:
        return false;
    }

    private static boolean isHwFoldableDevice(Context r1) {
        if (r1 == null) goto L15;
    L9:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (r1.getPackageManager() == null) goto L16;
        if (r1.getPackageManager().hasSystemFeature("com.huawei.hardware.sensor.posture") == false) goto L17;
        return true;
    L17:
        return false;
    L16:
        return false;
    L15:
        return false;
    }

    private static boolean checkHonorFoldableList(String r1) {
        if ("DIA-AN00".equalsIgnoreCase(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if ("MGI-AN00".equalsIgnoreCase(r1) == true) goto L8;
        return false;
    }

    private static boolean isHonorFoldableDevice(Context r1) {
        if (r1 == null) goto L15;
    L9:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (r1.getPackageManager() == null) goto L16;
        if (r1.getPackageManager().hasSystemFeature("com.hihonor.hardware.sensor.posture") == false) goto L17;
        return true;
    L17:
        return false;
    L16:
        return false;
    L15:
        return false;
    }

    private static boolean checkSamsungFoldableList() {
        String r0 = Build.MODEL;
        if (TextUtils.isEmpty(r0) == false) goto L6;
        return false;
    L6:
        if (r0.startsWith("SM-F9") == false) goto L8;
    L11:
        return true;
    L8:
        if (r0.startsWith("SM-W202") == true) goto L11;
        if (r0.startsWith("SM-W90") == true) goto L11;
        return false;
    }

    public static boolean isFoldableScreen() {
        int r0 = mIsFoldableScreen;
        if (r0 <= (-1)) goto L7;
        if (r0 > 0) goto L6;
        return false;
    L6:
        return true;
    L7:
        mIsFoldableScreen = 0;
        if (isSamsung() == false) goto L13;
        if (checkSamsungFoldableList() == false) goto L13;
        mIsFoldableScreen = 1;
    L18:
        if (mIsFoldableScreen > 0) goto L20;
        return false;
    L20:
        return true;
    L13:
        if (isHuawei() == false) goto L18;
        if (checkHuaweiFoldableList(Build.DEVICE) == false) goto L18;
        mIsFoldableScreen = 1;
        goto L18
    }

    public static boolean isFoldableScreenV2(Context r4) {
        int r0 = mIsFoldableScreen;
        if (r0 <= (-1)) goto L7;
        if (r0 > 0) goto L6;
        return false;
    L6:
        return true;
    L7:
        mIsFoldableScreen = 0;
        if (isSamsung() == false) goto L13;
        if (checkSamsungFoldableList() == false) goto L13;
        mIsFoldableScreen = 1;
    L38:
        if (mIsFoldableScreen > 0) goto L40;
        return false;
    L40:
        return true;
    L13:
        if (isHuawei() == false) goto L20;
        if (checkHuaweiFoldableList(Build.DEVICE) == false) goto L17;
    L18:
        mIsFoldableScreen = 1;
        goto L38
    L17:
        if (isHwFoldableDevice(r4) == true) goto L18;
    L20:
        if (r4.getPackageManager().hasSystemFeature("oplus.feature.largescreen") == false) goto L23;
        mIsFoldableScreen = 1;
        goto L38
    L23:
        if (isHonor() == false) goto L30;
        if (checkHonorFoldableList(Build.DEVICE) == false) goto L27;
    L28:
        mIsFoldableScreen = 1;
        goto L38
    L27:
        if (isHonorFoldableDevice(r4) == true) goto L28;
    L30:
        if (isVivoFoldableScreen() == false) goto L33;
        mIsFoldableScreen = 1;
        goto L38
    L33:
        if (isMiui() == false) goto L38;
        if (isMiuiFoldableScreen() == false) goto L38;
        mIsFoldableScreen = 1;
        goto L38
    }

    public static boolean isVivoFoldableScreen() {
        Method r0 = ReflectUtils.getMethod("android.util.FtDeviceInfo", "getDeviceType");
        if (r0 != null) goto L10;
        return false;
    L10:
        return "foldable".equals(r0.invoke(null, null));
    L12:
        return false;
    }

    public static boolean isMiuiFoldableScreen() {
        Class<?> r1 = Class.forName("android.os.SystemProperties");     // Catch: Exception -> L6
        if (((Integer) r1.getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(r1, new Object[]{"persist.sys.muiltdisplay_type", 0})).intValue() == 2) goto L12;
        return false;
    L12:
        return true;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean isMiui() {
        if (sIsMiuiInited == true) goto L10;
        if (Class.forName("miui.os.Build") == null) goto L8;
        sIsMiui = true;     // Catch: Exception -> L11
    L8:
        sIsMiuiInited = true;
    L10:
        return sIsMiui;
    }

    public static void setMiuiStatusBarDarkMode(boolean r8, Window r9) {
        Class<?> r0 = r9.getClass();     // Catch: Throwable -> L8
        Class<?> r1 = Class.forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L8
        int r2 = r1.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(r1);     // Catch: Throwable -> L8
        Method r3 = r0.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE});     // Catch: Throwable -> L8
        Object[] r4 = new Object[2];     // Catch: Throwable -> L8
        if (r8 == false) goto L5;
        int r10 = r2;
    L6:
        r4[0] = Integer.valueOf(r10);     // Catch: Throwable -> L8
        r4[1] = Integer.valueOf(r2);     // Catch: Throwable -> L8
        r3.invoke(r9, r4);     // Catch: Throwable -> L8
        return;
    L5:
        r10 = 0;
    L8:
        th = move-exception;
        th.printStackTrace();
    }

    public static boolean isMiuiV6() {
        initMiuiVersion();
        return "V6".equals(sMiuiVersion);
    }

    public static boolean isMiuiV7() {
        initMiuiVersion();
        return "V7".equals(sMiuiVersion);
    }

    public static boolean isMiuiV8() {
        initMiuiVersion();
        return "V8".equals(sMiuiVersion);
    }

    public static boolean isMiuiV9() {
        initMiuiVersion();
        return "V9".equals(sMiuiVersion);
    }

    private static void initMiuiVersion() {
        if (sMiuiVersion != null) goto L15;
        sMiuiVersion = getSystemProperty("ro.miui.ui.version.name");     // Catch: IOException -> L6
    L8:
        String r0 = sMiuiVersion;
        if (r0 != null) goto L11;
        r0 = "";
    L11:
        sMiuiVersion = r0;
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public static int getEmuiLevel() {
        int r0 = sEmuiLevel;
        if (r0 <= (-1)) goto L5;
        return r0;
    L5:
        sEmuiLevel = 0;
        sEmuiLevel = Integer.parseInt(getSystemProperty("ro.build.hw_emui_api_level"));     // Catch: Exception -> L8
    L11:
        return sEmuiLevel;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static boolean isHuawei() {
        if (Build.MANUFACTURER != null) goto L5;
    L7:
        return false;
    L5:
        if (Build.MANUFACTURER.toUpperCase(Locale.getDefault()).contains("HUAWEI") == false) goto L7;
        return true;
    }

    public static boolean isHonor() {
        if (Build.MANUFACTURER != null) goto L5;
    L7:
        return false;
    L5:
        if (Build.MANUFACTURER.toUpperCase(Locale.getDefault()).contains("HONOR") == false) goto L7;
        return true;
    }

    public static boolean isSumsungV4_4_4() {
        if (isSamsung() == true) goto L5;
        return false;
    L5:
        if (Build.VERSION.RELEASE.startsWith("4.4.4") == false) goto L8;
        return true;
    L8:
        if (Build.VERSION.RELEASE.startsWith("4.4.2") == true) goto L10;
        return false;
    L10:
        if (Build.DEVICE.startsWith("klte") == false) goto L15;
        return true;
    L15:
        return false;
    }

    public static boolean isSumsungV5() {
        if (isSamsung() == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isSumsungCorePrime() {
        if (isSamsung() == true) goto L5;
        return false;
    L5:
        if (Build.DISPLAY.contains("G3608ZMU1AOA4") == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean isFlyme() {
        return Build.DISPLAY.startsWith("Flyme");
    }

    public static boolean isFlyme2() {
        return Build.DISPLAY.startsWith("Flyme 2");
    }

    public static boolean isFlyme4() {
        return Build.DISPLAY.startsWith("Flyme OS 4");
    }

    public static boolean isFlyme5() {
        return Build.DISPLAY.startsWith("Flyme 5");
    }

    public static boolean isFlyme6() {
        return Build.DISPLAY.startsWith("Flyme 6");
    }

    public static boolean isFlyme7() {
        return Build.DISPLAY.startsWith("Flyme 7");
    }

    public static boolean isOnePlusLOLLIPOP() {
        if (Build.BRAND.equals("ONEPLUS") == false) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isSamsung() {
        if ("samsung".equalsIgnoreCase(Build.BRAND) == false) goto L5;
        return true;
    L5:
        if ("samsung".equalsIgnoreCase(Build.MANUFACTURER) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean isLG() {
        if ("lge".equalsIgnoreCase(Build.BRAND) == true) goto L7;
        if ("lge".equalsIgnoreCase(Build.MANUFACTURER) == true) goto L7;
        return false;
    L7:
        if (Build.MODEL != null) goto L9;
        return false;
    L9:
        if (Build.MODEL.toLowerCase(Locale.getDefault()).contains("lg") == false) goto L15;
        return true;
    L15:
        return false;
    }

    public static boolean isMeizuMx3() {
        if (isMeizu() == true) goto L5;
        return false;
    L5:
        return "mx3".equalsIgnoreCase(Build.DEVICE);
    }

    public static boolean isHtcOs() {
        if (Build.BRAND != null) goto L5;
        return false;
    L5:
        if (Build.BRAND.toLowerCase(Locale.getDefault()).contains("htc") == true) goto L7;
        return false;
    L7:
        if (Build.MANUFACTURER != null) goto L9;
        return false;
    L9:
        if (Build.MANUFACTURER.toLowerCase(Locale.getDefault()).contains("htc") == true) goto L11;
        return false;
    L11:
        if (Build.MODEL != null) goto L13;
        return false;
    L13:
        if (Build.MODEL.toLowerCase(Locale.getDefault()).contains("htc") == false) goto L22;
        return true;
    L22:
        return false;
    }

    public static boolean isMeizu() {
        String r0 = Build.BRAND;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.toLowerCase(Locale.ENGLISH).indexOf("meizu") <= (-1)) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isVivo() {
        String r0 = Build.BRAND;
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L7:
        String r1 = Build.MODEL;
        if (TextUtils.isEmpty(r1) == false) goto L10;
    L12:
        String r2 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r2) == false) goto L15;
        return false;
    L15:
        if (r2.toLowerCase(Locale.getDefault()).contains("vivo") == false) goto L19;
        return true;
    L19:
        return false;
    L10:
        if (r1.toLowerCase(Locale.getDefault()).contains("vivo") == false) goto L12;
        return true;
    L5:
        if (r0.toLowerCase(Locale.getDefault()).contains("vivo") == false) goto L7;
        return true;
    }

    public static boolean isOppo() {
        return check("OPPO");
    }

    public static boolean isQiku() {
        if (check("QIKU") == false) goto L5;
    L8:
        return true;
    L5:
        if (check("360") == true) goto L8;
        return false;
    }

    public static boolean isSmartisan() {
        return check("SMARTISAN");
    }

    public static String getName() {
        if (sName != null) goto L6;
        check("");
    L6:
        return sName;
    }

    public static String getVersion() {
        if (sVersion != null) goto L6;
        check("");
    L6:
        return sVersion;
    }

    public static boolean check(String r2) {
        String r0 = sName;
        if (r0 != null) goto L5;
        String r1 = getProp("ro.miui.ui.version.name");
        sVersion = r1;
        if (TextUtils.isEmpty(r1) == true) goto L9;
        sName = "MIUI";
    L41:
        return sName.equals(r2);
    L9:
        String r3 = getProp(KEY_VERSION_EMUI);
        sVersion = r3;
        if (TextUtils.isEmpty(r3) == true) goto L12;
        sName = "EMUI";
        goto L41
    L12:
        String r4 = getProp("ro.build.version.opporom");
        sVersion = r4;
        if (TextUtils.isEmpty(r4) == true) goto L15;
        sName = "OPPO";
        goto L41
    L15:
        String r5 = getProp(KEY_VERSION_VIVO);
        sVersion = r5;
        if (TextUtils.isEmpty(r5) == true) goto L18;
        sName = "VIVO";
        goto L41
    L18:
        String r6 = getProp(KEY_VERSION_SMARTISAN);
        sVersion = r6;
        if (TextUtils.isEmpty(r6) == true) goto L21;
        sName = "SMARTISAN";
        goto L41
    L21:
        String r7 = getProp(KEY_VERSION_GIONEE);
        sVersion = r7;
        if (TextUtils.isEmpty(r7) == true) goto L24;
        sName = "QIONEE";
        goto L41
    L24:
        String r8 = getProp(KEY_VERSION_LENOVO);
        sVersion = r8;
        if (TextUtils.isEmpty(r8) == true) goto L27;
        sName = "LENOVO";
        goto L41
    L27:
        String r9 = getProp(KEY_VERSION_MAGIC);
        sVersion = r9;
        if (TextUtils.isEmpty(r9) == true) goto L31;
        sName = ROM_MAGIC;
        goto L41
    L31:
        if (getManufacturer().toLowerCase(Locale.getDefault()).contains("samsung") == false) goto L34;
        sName = "samsung";
        goto L41
    L34:
        if (getManufacturer().toLowerCase(Locale.getDefault()).contains("zte") == false) goto L36;
        sName = "zte";
        goto L41
    L36:
        String r10 = Build.DISPLAY;
        sVersion = r10;
        if (r10.toUpperCase(Locale.getDefault()).contains("FLYME") == false) goto L39;
        sName = "FLYME";
        goto L41
    L39:
        sVersion = EnvironmentCompat.MEDIA_UNKNOWN;
        sName = Build.MANUFACTURER.toUpperCase(Locale.getDefault());
        goto L41
    L5:
        return r0.equals(r2);
    }

    public static String getProp(String r4) {
        BufferedReader r1 = null;
        BufferedReader r0 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + r4).getInputStream(), "UTF-8"), 1024);     // Catch: Throwable -> L12 IOException -> L19
    L35:
        String r5 = r0.readLine();     // Catch: Throwable -> L10 IOException -> L26
        r0.close();     // Catch: Throwable -> L10 IOException -> L26
        r0.close();     // Catch: IOException -> L7
    L9:
        return r5;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L10:
        th = th;
        r1 = r0;
    L13:
        if (r1 != null) goto L29;
    L18:
        throw th;
    L29:
        r1.close();     // Catch: IOException -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
    L20:
        if (r0 != null) goto L31;
    L25:
        return null;
    L31:
        r0.close();     // Catch: IOException -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
    L19:
        r0 = null;
    L12:
        th = th;
        goto L13
    }

    public static String getManufacturer() {
        if (Build.MANUFACTURER != null) goto L6;
        return "";
    L6:
        return Build.MANUFACTURER.trim();
    }

    static {
        SYSTEM_PROPERTIES_CACHE = new HashMap();
        properties = null;
    }

    public static String getSystemPropertyInSp(Context r4, String r5) {
        Map<String, String> r0 = SYSTEM_PROPERTIES_CACHE;
        monitor-enter(r0);
        String r1 = r0.get(r5);     // Catch: Throwable -> L16
        if (StringUtils.isEmpty(r1) == true) goto L21;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return r1;
    L21:
        SharedPreferences r6 = r4.getSharedPreferences(KEY_SYSTEM_PROPERTIES_CACHE, 0);     // Catch: Exception -> L12 Throwable -> L16
        r1 = r6.getString(r5, null);     // Catch: Exception -> L12 Throwable -> L16
        if (StringUtils.isEmpty(r1) == false) goto L14;
        r1 = getSystemProperty(r5);     // Catch: Exception -> L12 Throwable -> L16
        if (StringUtils.isEmpty(r1) == true) goto L14;
        SharedPreferences.Editor r7 = r6.edit();     // Catch: Exception -> L12 Throwable -> L16
        r7.putString(r5, r1);     // Catch: Exception -> L12 Throwable -> L16
        r7.apply();     // Catch: Exception -> L12 Throwable -> L16
    L12:
        e = move-exception;
        Logger.e(TAG, "getSystemProperties in sp error", e);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public static String getSystemProperty(String r0) {
        return SystemPropertiesUtils.getSystemProperty(r0);
    }

    public static double getEmuiVersion() {
        String r0 = getSystemProperty(KEY_VERSION_EMUI);     // Catch: Exception -> L4
        return Double.parseDouble(r0.substring(r0.indexOf("_") + 1));
    L4:
        e = move-exception;
        e.printStackTrace();
        return 4.0d;
    }

    public static boolean hasSmartBar() {
        if (isMeizu() == true) goto L16;
        return false;
    L16:
        return ((Boolean) Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
    L7:
        e = move-exception;
        e.printStackTrace();
        if (Build.DEVICE.equals("mx") == false) goto L11;
    L15:
        return false;
    L11:
        if (Build.DEVICE.equals("m9") == true) goto L15;
        return true;
    }

    public static boolean hasVirtualButtons(Context r0) {
        return !ViewConfiguration.get(r0).hasPermanentMenuKey();
    }

    public static String getDeviceId(Context r2) {
        String r0 = ((TelephonyManager) r2.getSystemService(MultiSimAdapter.PHONE_KEY)).getDeviceId();
        if (TextUtils.isEmpty(r0) == true) goto L7;
        if ("000000000000000".equals(r0) == true) goto L7;
        return r0;
    L7:
        return ((WifiManager) r2.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
    }

    public static boolean isLenovo() {
        if ("lenovo".equalsIgnoreCase(Build.BRAND) == false) goto L5;
    L14:
        return true;
    L5:
        if ("lenovo".equalsIgnoreCase(Build.MANUFACTURER) == true) goto L14;
        if ("motorola".equalsIgnoreCase(Build.BRAND) == true) goto L14;
        if ("motorola".equalsIgnoreCase(Build.MANUFACTURER) == true) goto L14;
        return false;
    }

    public static long getTotalMemory() {
        BufferedReader r0 = new BufferedReader(new FileReader("/proc/meminfo"), 8192);     // Catch: Throwable -> L12 Exception -> L14
        long r1 = Integer.parseInt(r0.readLine().split("\\s+")[1]) * 1024;
        r0.close();     // Catch: IOException -> L8
        return r1;
    L8:
        e = move-exception;
        e.printStackTrace();
        return r1;
    L10:
        Exception e = e;
    L16:
        e.printStackTrace();     // Catch: Throwable -> L24
        if (r0 != null) goto L36;
    L22:
        return 0;
    L36:
        r0.close();     // Catch: IOException -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
    L24:
        Throwable th = th;
    L25:
        if (r0 != null) goto L38;
    L30:
        throw th;
    L38:
        r0.close();     // Catch: IOException -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
        goto L30
    L14:
        e = move-exception;
        e = e;
        r0 = null;
    L12:
        th = move-exception;
        th = th;
        r0 = null;
        goto L25
    }

    public static int getStatusBarHeight(Context r4) {
        int r0 = sStatusBarHeight;
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        int r1 = r4.getResources().getIdentifier("status_bar_height", "dimen", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        if (r1 <= 0) goto L8;
        int r2 = r4.getResources().getDimensionPixelSize(r1);
    L9:
        if (r2 != 0) goto L11;
        r2 = (int) UIUtils.dip2Px(r4, 25.0f);
    L11:
        sStatusBarHeight = r2;
        return r2;
    L8:
        r2 = 0;
        goto L9
    }

    public static void initDeviceData(Context r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        DisplayMetrics r0 = new DisplayMetrics();
        WindowManager r4 = (WindowManager) r3.getSystemService("window");
        if (r4 != null) goto L7;
        return;
    L7:
        r4.getDefaultDisplay().getMetrics(r0);
        int r5 = r4.getDefaultDisplay().getOrientation();
        if (r5 != 1) goto L10;
    L13:
        displayMetricsWidthPixels = r0.heightPixels;
        displayMetricsHeightPixels = r0.widthPixels;
    L14:
        deviceDataHasInit = true;
        return;
    L10:
        if (r5 == 3) goto L13;
        displayMetricsWidthPixels = r0.widthPixels;
        displayMetricsHeightPixels = r0.heightPixels;
        goto L14
    }

    public static int getEquipmentWidth(Context r1) {
        if (deviceDataHasInit == true) goto L5;
    L6:
        initDeviceData(r1);
    L8:
        return displayMetricsWidthPixels;
    L5:
        if (isFoldableScreenV2(r1) == false) goto L8;
        goto L6
    }

    public static int getEquipmentHeight(Context r1) {
        if (deviceDataHasInit == true) goto L5;
    L6:
        initDeviceData(r1);
    L8:
        return displayMetricsHeightPixels;
    L5:
        if (isFoldableScreenV2(r1) == false) goto L8;
        goto L6
    }

    public static boolean isLargeScreenPad(Context r3, int r4, int r5) {
        if (isFoldableScreenV2(r3) == false) goto L5;
        return false;
    L5:
        Resources r6 = r3.getResources();
        int r0 = r6.getDimensionPixelSize(R.dimen.mohist_standard_tools_large_pad_min_width);
        int r7 = r6.getDimensionPixelSize(R.dimen.mohist_standard_tools_large_pad_min_height);
        if (r4 < r0) goto L10;
        if (r5 < r7) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }

    public static boolean isLargeScreenPad(Display r1, Context r2) {
        Point r0 = new Point();
        HoneyCombMR2V13Compat.getDisplaySize(r1, r0);
        return isLargeScreenPad(r2, r0.x, r0.y);
    }

    public static boolean isPad(Context r1) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (r1.getResources() != null) goto L6;
        return false;
    L6:
        if (r1.getResources().getConfiguration() != null) goto L9;
        return false;
    L9:
        return "tablet".equals(getDeviceType(r1));
    }

    public static boolean isPad(Context r0, Resources r1) {
        if (r0 == null) goto L9;
        if (r1 != null) goto L5;
        return false;
    L5:
        if (r1.getConfiguration() != null) goto L8;
        return false;
    L8:
        return "tablet".equals(getDeviceType(r0));
    L9:
        return false;
    }

    public static boolean isHuawei_Os_3x() {
        if (isHuawei() == false) goto L14;
        String r0 = getSystemProperty(KEY_VERSION_EMUI);
        if ("EmotionUI 3".equals(r0) == false) goto L7;
    L13:
        return true;
    L7:
        if ("EmotionUI_3.1".contains(r0) == true) goto L13;
        if ("EmotionUI_3.0".contains(r0) == false) goto L12;
        return true;
    L12:
        return false;
    L14:
        return false;
    }

    public static int getNavigationBarHeight(Context r1) {
        if (hasNavBar((Activity) r1) == true) goto L5;
        return 0;
    L5:
        return getInternalDimensionSize(r1, IMMERSION_NAVIGATION_BAR_HEIGHT);
    }

    public static boolean hasNavBar(Activity r4) {
        if (Settings.Global.getInt(r4.getContentResolver(), IMMERSION_MIUI_NAVIGATION_BAR_HIDE_SHOW, 0) == 0) goto L6;
        return false;
    L6:
        if (isEmui() == true) goto L8;
    L15:
        Display r5 = r4.getWindowManager().getDefaultDisplay();
        DisplayMetrics r0 = new DisplayMetrics();
        r5.getRealMetrics(r0);
        int r1 = r0.heightPixels;
        int r2 = r0.widthPixels;
        DisplayMetrics r3 = new DisplayMetrics();
        r5.getMetrics(r3);
        int r6 = r3.heightPixels;
        if ((r2 - r3.widthPixels) <= 0) goto L18;
    L19:
        return true;
    L18:
        if ((r1 - r6) > 0) goto L19;
        return false;
    L8:
        if (isHuawei_Os_3x() == true) goto L13;
        if (Settings.Global.getInt(r4.getContentResolver(), IMMERSION_EMUI_NAVIGATION_BAR_HIDE_SHOW, 0) == 0) goto L15;
        return false;
    L13:
        if (Settings.System.getInt(r4.getContentResolver(), IMMERSION_EMUI_NAVIGATION_BAR_HIDE_SHOW, 0) == 0) goto L15;
        return false;
    }

    public static int getInternalDimensionSize(Context r4, String r5) {
        int r6 = Resources.getSystem().getIdentifier(r5, "dimen", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);     // Catch: Resources.NotFoundException -> L11
        if (r6 <= 0) goto L10;
        int r1 = r4.getResources().getDimensionPixelSize(r6);     // Catch: Resources.NotFoundException -> L11
        int r7 = Resources.getSystem().getDimensionPixelSize(r6);     // Catch: Resources.NotFoundException -> L11
        if (r7 < r1) goto L8;
        return r7;
    L8:
        return Math.round((r1 * Resources.getSystem().getDisplayMetrics().density) / r4.getResources().getDisplayMetrics().density);
    L10:
        return 0;
    }

    private static String getDeviceType(Context r1) {
        String r2 = getSystemPropertyInSp(r1, "ro.build.characteristics");
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L6:
        return MultiSimAdapter.PHONE_KEY;
    L5:
        if (r2.equals("tablet") == false) goto L6;
        return r2;
    }

    public static int getScreenWidth(Context r2) {
        DisplayMetrics r0 = new DisplayMetrics();
        WindowManager r3 = (WindowManager) r2.getSystemService("window");
        r3.getDefaultDisplay().getMetrics(r0);
        int r4 = r3.getDefaultDisplay().getOrientation();
        if (r4 == 1) goto L9;
        if (r4 == 3) goto L9;
        return r0.widthPixels;
    L9:
        return r0.heightPixels;
    }

    public static int getScreenHeight(Context r2) {
        DisplayMetrics r0 = new DisplayMetrics();
        WindowManager r3 = (WindowManager) r2.getSystemService("window");
        r3.getDefaultDisplay().getMetrics(r0);
        int r4 = r3.getDefaultDisplay().getOrientation();
        if (r4 == 1) goto L9;
        if (r4 == 3) goto L9;
        return r0.heightPixels;
    L9:
        return r0.widthPixels;
    }

    @Deprecated
    private static String getProperty(String r6) throws IOException {
        if (properties != null) goto L15;
        monitor-enter(DeviceUtils.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (properties != null) goto L9;
        properties = new Properties();     // Catch: Throwable -> L11
        properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));     // Catch: Throwable -> L11
    L9:
        monitor-exit(DeviceUtils.class);     // Catch: Throwable -> L11
    L15:
        return properties.getProperty(r6);
    }

    public static boolean isMiuiV10() {
        initMiuiVersion();
        if ("V10".equals(sMiuiVersion) == false) goto L5;
    L8:
        return true;
    L5:
        if ("v10".equals(sMiuiVersion) == true) goto L8;
        return false;
    }

    public static boolean isMagicWindow(Context r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.getResources() != null) goto L7;
        return false;
    L7:
        if (r2.getResources().getConfiguration() == null) goto L16;
        String r3 = r2.getResources().getConfiguration().toString();
        if (r3.contains("hwMultiwindow-magic") == false) goto L11;
    L12:
        return true;
    L11:
        if (r3.contains("hw-magic-windows") == true) goto L12;
        return false;
    L16:
        return false;
    }
}
