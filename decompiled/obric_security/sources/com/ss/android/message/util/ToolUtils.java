package com.ss.android.message.util;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.security.battertpower.powerHigh.clearApp.ClearPowerHighAppsActivity;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ToolUtils {
    private static String sCurProcessName = null;
    public static boolean sIsInited = false;
    public static boolean sIsMiui = false;

    static {
    }

    public ToolUtils() {
    }

    public static String getCurProcessName(Context r3) {
        String r0 = sCurProcessName;
        if (StringUtils.isEmpty(r0) == true) goto L19;
        return r0;
    L19:
        int r1 = Process.myPid();     // Catch: Exception -> L15
        Iterator<ActivityManager.RunningAppProcessInfo> r4 = ((ActivityManager) r3.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L15
    L7:
        if (r4.hasNext() == false) goto L17;
        ActivityManager.RunningAppProcessInfo r2 = r4.next();     // Catch: Exception -> L15
        if (r2.pid != r1) goto L7;
        if (Logger.debug() == false) goto L13;
        Logger.d("Process", "processName = " + r2.processName);     // Catch: Exception -> L15
    L13:
        String r5 = r2.processName;     // Catch: Exception -> L15
        sCurProcessName = r5;     // Catch: Exception -> L15
        return r5;
    L17:
        String r6 = getCurProcessNameFromProc();
        sCurProcessName = r6;
        return r6;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    private static String getCurProcessNameFromProc() {
        BufferedReader r2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L14
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L19
    L5:
        int r3 = r2.read();     // Catch: Throwable -> L19
        if (r3 <= 0) goto L9;
        r0.append((char) r3);     // Catch: Throwable -> L19
        goto L5
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.d("Process", "get processName = " + r0.toString());     // Catch: Throwable -> L19
    L11:
        String r1 = r0.toString();     // Catch: Throwable -> L19
        r2.close();     // Catch: Exception -> L18
    L13:
        return r1;
    L15:
        if (r2 != null) goto L21;
    L17:
        return null;
    L21:
        r2.close();     // Catch: Exception -> L20
    L14:
        r2 = null;
        goto L15
    }

    public static String getUserSerial(Context r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        Object r11 = r10.getSystemService("user");
        if (r11 != null) goto L21;
        Logger.e("ToolUtils", "userManager not exsit !!!");
        return null;
    L21:
        Class[] r5 = (Class[]) null;     // Catch: InvocationTargetException -> L11 IllegalAccessException -> L13 IllegalArgumentException -> L15 NoSuchMethodException -> L17 Throwable -> L20
        Object[] r6 = (Object[]) null;     // Catch: InvocationTargetException -> L11 IllegalAccessException -> L13 IllegalArgumentException -> L15 NoSuchMethodException -> L17 Throwable -> L20
        Object r3 = Process.class.getMethod("myUserHandle", null).invoke(Process.class, null);     // Catch: InvocationTargetException -> L11 IllegalAccessException -> L13 IllegalArgumentException -> L15 NoSuchMethodException -> L17 Throwable -> L20
        return String.valueOf(((Long) r11.getClass().getMethod("getSerialNumberForUser", new Class[]{r3.getClass()}).invoke(r11, new Object[]{r3})).longValue());
    L13:
        e = move-exception;
        Logger.e("ToolUtils", "", e);
    L15:
        e = move-exception;
        Logger.e("ToolUtils", "", e);
    L17:
        e = move-exception;
        Logger.e("ToolUtils", "", e);
    L11:
        e = move-exception;
        Logger.e("ToolUtils", "", e);
    L19:
        return null;
    }

    public static boolean isApplicationForeground(Context r3, String r4) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (StringUtils.isEmpty(r4) == true) goto L27;
        List<ActivityManager.RunningAppProcessInfo> r5 = ((ActivityManager) r3.getSystemService("activity")).getRunningAppProcesses();
        if (r5 != null) goto L10;
        return false;
    L10:
        if (r5.isEmpty() == true) goto L25;
        Iterator<ActivityManager.RunningAppProcessInfo> r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L28;
        ActivityManager.RunningAppProcessInfo r1 = r6.next();
        if (r4.equals(r1.processName) == false) goto L13;
        if (r1.importance != 100) goto L26;
        return true;
    L26:
        return false;
    L28:
        return false;
    L25:
        return false;
    L27:
        return false;
    }

    public static String getDefaultBrowserString(Context r5) {
        Intent r0 = new Intent("android.intent.action.VIEW");     // Catch: Exception -> L22
        r0.addCategory("android.intent.category.DEFAULT");     // Catch: Exception -> L22
        r0.addCategory("android.intent.category.BROWSABLE");     // Catch: Exception -> L22
        r0.setDataAndType(Uri.parse("http://"), null);     // Catch: Exception -> L22
        List<ResolveInfo> r6 = r5.getPackageManager().queryIntentActivities(r0, 65568);     // Catch: Exception -> L22
        if (r6.size() <= 0) goto L35;
        Iterator<ResolveInfo> r1 = r6.iterator();     // Catch: Exception -> L22
    L7:
        if (r1.hasNext() == false) goto L16;
        ResolveInfo r2 = r1.next();     // Catch: Exception -> L22
        if (r2 == null) goto L7;
        if (r2.activityInfo == null) goto L7;
        if ("com.android.browser".equals(r2.activityInfo.packageName) == false) goto L7;
        return r2.activityInfo.packageName + LibrarianImpl.Constants.SEPARATOR + r2.activityInfo.name;
    L16:
        ResolveInfo r7 = r6.get(0);     // Catch: Exception -> L22
        if (r7 != null) goto L19;
        return "com.android.browser/com.android.browser.BrowserActivity";
    L19:
        if (r7.activityInfo != null) goto L21;
        return "com.android.browser/com.android.browser.BrowserActivity";
    L21:
        return r7.activityInfo.packageName + LibrarianImpl.Constants.SEPARATOR + r7.activityInfo.name;
    L35:
        return "com.android.browser/com.android.browser.BrowserActivity";
    L22:
        e = move-exception;
        e.printStackTrace();
        return "com.android.browser/com.android.browser.BrowserActivity";
    }

    public static boolean isInstalledApp(Context r2, String r3) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (StringUtils.isEmpty(r3) == false) goto L12;
        return false;
    L12:
        if (r2.getPackageManager().getPackageInfo(r3, 0) != null) goto L10;
        return false;
    L10:
        return true;
    L17:
        return false;
    }

    public static boolean isInstalledApp(Context r2, Intent r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        List<ResolveInfo> r4 = r2.getPackageManager().queryIntentActivities(r3, 65536);
        if (r4 != null) goto L8;
    L11:
        return false;
    L8:
        if (r4.size() <= 0) goto L11;
        return true;
    }

    public static boolean isServiceRunning(Context r3, String r4, String r5) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (StringUtils.isEmpty(r4) == false) goto L7;
        return false;
    L7:
        if (StringUtils.isEmpty(r5) == true) goto L35;
        List<ActivityManager.RunningServiceInfo> r6 = ((ActivityManager) r3.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);     // Catch: Throwable -> L22
        if (r6 != null) goto L12;
        return false;
    L12:
        if (r6.size() <= 0) goto L34;
        Iterator<ActivityManager.RunningServiceInfo> r7 = r6.iterator();     // Catch: Throwable -> L22
    L15:
        if (r7.hasNext() == false) goto L37;
        ActivityManager.RunningServiceInfo r1 = r7.next();     // Catch: Throwable -> L22
        if (r4.equals(r1.service.getPackageName()) == false) goto L15;
        if (r5.equals(r1.service.getClassName()) == false) goto L15;
        return true;
    L37:
        return false;
    L34:
        return false;
    L36:
        return false;
    L35:
        return false;
    }

    public static boolean isMainProcess(Context r3) {
        String r0 = getCurProcessName(r3);
        if (r0 != null) goto L5;
    L7:
        if (r0 != null) goto L9;
        return false;
    L9:
        if (r0.equals(r3.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r0.contains(":") == false) goto L7;
        return false;
    }

    public static boolean isFlyme() {
        if (Build.DISPLAY.indexOf("Flyme") < 0) goto L5;
        return true;
    L5:
        if (Build.USER.equals("flyme") == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static String addUrlParam(String r4, Map<String, String> r5) {
        ArrayList r0 = new ArrayList();
        if (r5 == null) goto L9;
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L9;
        Map.Entry<String, String> r1 = r6.next();
        r0.add(new Pair(r1.getKey(), r1.getValue()));
    L9:
        return addUrlParam(r4, r0);
    }

    public static String addUrlParam(String r2, List<Pair<String, String>> r3) {
        StringBuilder r0 = new StringBuilder(r2);
        if (r2.indexOf(63) >= 0) goto L5;
        r0.append("?");
    L6:
        r0.append(NetworkUtils.format(r3, "UTF-8"));
        return r0.toString();
    L5:
        r0.append("&");
        goto L6
    }

    public static int areNotificationsEnabled(Context r11) {
        if (r11 != null) goto L18;
        return -1;
    L18:
        return ((Boolean) Reflect.on((NotificationManager) r11.getSystemService(ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION)).call("areNotificationsEnabled").get()).booleanValue() ? 1 : 0;
    L7:
        e = move-exception;
        e.printStackTrace();
        AppOpsManager r1 = (AppOpsManager) r11.getSystemService("appops");     // Catch: Throwable -> L13
        ApplicationInfo r2 = r11.getApplicationInfo();     // Catch: Throwable -> L13
        String r12 = r11.getApplicationContext().getPackageName();     // Catch: Throwable -> L13
        int r3 = r2.uid;     // Catch: Throwable -> L13
        Reflect r4 = Reflect.on(r1);     // Catch: Throwable -> L13
        int r5 = ((Integer) r4.field("OP_POST_NOTIFICATION", new Class[]{Integer.TYPE}).get()).intValue();     // Catch: Throwable -> L13
        if (((Integer) r4.call("checkOpNoThrow", new Class[]{Integer.TYPE, Integer.TYPE, String.class}, new Object[]{Integer.valueOf(r5), Integer.valueOf(r3), r12}).get()).intValue() != 0) goto L12;
        return 1;
    L12:
        return 0;
    L13:
        th = move-exception;
        th.printStackTrace();
        return -1;
    }

    public static boolean isHuaweiDevice() {
        if (StringUtils.isEmpty(Build.BRAND) == true) goto L9;
        if (Build.BRAND.toLowerCase().startsWith("huawei") == false) goto L9;
    L12:
        return true;
    L9:
        if (StringUtils.isEmpty(Build.MANUFACTURER) == true) goto L17;
        if (Build.MANUFACTURER.toLowerCase().startsWith("huawei") == true) goto L12;
        return false;
    L17:
        return false;
    L19:
        return false;
    }

    public static boolean isEmui(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        r2 = getEmuiInfo();
    L6:
        if (TextUtils.isEmpty(r2) == true) goto L11;
        if (r2.toLowerCase().startsWith("emotionui") == false) goto L11;
        return true;
    L11:
        if (isHuaweiDevice() == false) goto L13;
        return true;
    L13:
        return false;
    }

    public static String getEmuiInfo() {
        return getSystemProperty("ro.build.version.emui");
    }

    public static String getEMUI() {
        Method r1 = Build.class.getDeclaredMethod("getString", new Class[]{String.class});     // Catch: Throwable -> L7
        r1.setAccessible(true);     // Catch: Throwable -> L7
        Object r2 = r1.invoke(null, new Object[]{"ro.build.version.emui"});     // Catch: Throwable -> L7
        Logger.d("ToolUtils", "getEMUI: emuiVersion " + r2);     // Catch: Throwable -> L7
        if ((r2 instanceof String) == false) goto L12;
        return (String) r2;
    L12:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    private static String getSystemProperty(String r8) {
        BufferedReader r4 = null;
        String r5 = null;
        BufferedReader r6 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + r8).getInputStream()), 1024);     // Catch: Throwable -> L12
        r5 = r6.readLine();     // Catch: Throwable -> L10
        r6.close();     // Catch: Throwable -> L10
        r6.close();     // Catch: IOException -> L7
    L9:
        return r5;
    L7:
        e = move-exception;
        Logger.e("ToolUtils", "Exception while closing InputStream", e);
    L10:
        th = th;
        String r7 = r5;
        r4 = r6;
    L28:
        Logger.e("ToolUtils", "Unable to read sysprop " + r8, th);     // Catch: Throwable -> L21
        if (r4 != null) goto L36;
    L20:
        return r7;
    L36:
        r4.close();     // Catch: IOException -> L18
    L18:
        e = move-exception;
        Logger.e("ToolUtils", "Exception while closing InputStream", e);
    L21:
        th = move-exception;
        if (r4 != null) goto L32;
    L27:
        throw th;
    L32:
        r4.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        Logger.e("ToolUtils", "Exception while closing InputStream", e);
    L12:
        th = th;
        r7 = null;
        goto L28
    }

    public static boolean isMiui() {
        if (sIsInited == true) goto L11;
        if (Class.forName("miui.os.Build") == null) goto L9;
        sIsMiui = true;     // Catch: Exception -> L12
        sIsInited = true;     // Catch: Exception -> L12
        return true;
    L9:
        sIsInited = true;
    L11:
        return sIsMiui;
    }

    public static String getRomInfo() {
        StringBuilder r0 = new StringBuilder();
        if (isMiui() == false) goto L7;
        r0.append("MIUI-");     // Catch: Throwable -> L20
    L17:
        r0.append(Build.VERSION.INCREMENTAL);     // Catch: Throwable -> L20
        goto L19
    L7:
        if (isFlyme() == false) goto L9;
        r0.append("FLYME-");     // Catch: Throwable -> L20
        goto L17
    L9:
        String r1 = getEmuiInfo();     // Catch: Throwable -> L20
        if (isEmui(r1) == false) goto L15;
        if (isNexus6p() == true) goto L15;
        r0.append("EMUI-");     // Catch: Throwable -> L20
    L15:
        if (TextUtils.isEmpty(r1) == true) goto L17;
        r0.append(r1).append("-");     // Catch: Throwable -> L20
    L19:
        return r0.toString();
    }

    public static boolean isNexus6p() {
        if ("angler".equals(Build.BOARD) == true) goto L5;
    L11:
        return false;
    L5:
        if (Build.MODEL == null) goto L11;
        if (Build.MODEL.toLowerCase().contains("nexus") == false) goto L11;
        if (Build.MODEL.toLowerCase().contains("6p") == false) goto L11;
        return true;
    }

    public static void setProcessName(String r0) {
        sCurProcessName = r0;
    }
}
