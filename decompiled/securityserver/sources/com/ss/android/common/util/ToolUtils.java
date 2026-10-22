package com.ss.android.common.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.location.LocationManager;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.widget.ActivityChooserView;
import com.bytedance.android.standard.tools.device.SystemPropertiesUtils;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.librarian.LibrarianImpl;
import com.ttnet.org.chromium.net.NetError;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"NewApi", "CI_InlinedApi", "CI_NewApi", "InlinedApi"})
public final class ToolUtils {
    private static final int FLAGS_GET_ONLY_FROM_ANDROID = 16777216;
    public static final int FLAG_LOC_GPS = 1;
    public static final int FLAG_LOC_NETWORK = 2;
    public static final int FLAG_LOC_PASSIVE = 4;
    public static final String NODEX_PROCESS_SUFFIX = ":nodex";
    private static volatile boolean bAlreadyGetProp = false;
    public static String mMsgProcessSuffix = ":push";
    private static boolean sCanSetStatusBar = true;
    private static String sCurProcessName = null;
    public static boolean sIsInited = false;
    public static boolean sIsMiui = false;
    private static String systemProperty;

    public static class MyMediaScannerConnectionClient implements MediaScannerConnection.MediaScannerConnectionClient {
        private MediaScannerConnection conn;
        private Context mContext;
        private String mImagePath;

        public MyMediaScannerConnectionClient(Context r1, String r2) {
            this.mContext = r1;
            this.mImagePath = r2;
        }

        @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
        public void onMediaScannerConnected() {
            this.conn.scanFile(this.mImagePath, "image/*");     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
        public void onScanCompleted(String r1, Uri r2) {
            MediaScannerConnection r3 = this.conn;
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.isConnected() == false) goto L7;
            this.conn.disconnect();
        L7:
            this.conn = null;
        }

        public void startScan() {
            MediaScannerConnection r0 = this.conn;
            if (r0 != null) goto L5;
        L7:
            MediaScannerConnection r1 = new MediaScannerConnection(this.mContext, this);
            this.conn = r1;
            r1.connect();
            return;
        L5:
            if (r0.isConnected() == false) goto L7;
            this.conn.disconnect();
            goto L7
        }
    }

    private ToolUtils() {
    }

    public static void addImageMedia(Context r2, String r3) {
        r2.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(r3))));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Logger.w("ToolUtils", "add image media exception: " + e);
    }

    public static void addImageMedia2(Context r1, String r2) {
        new MyMediaScannerConnectionClient(r1, r2).startScan();     // Catch: Exception -> L4
        return;
    }

    @TargetApi(19)
    public static int areNotificationsEnabled(Context r7) {
        if (r7 != null) goto L14;
        return -1;
    L14:
        AppOpsManager r1 = (AppOpsManager) r7.getSystemService("appops");     // Catch: Throwable -> L11
        ApplicationInfo r2 = r7.getApplicationInfo();     // Catch: Throwable -> L11
        String r8 = r7.getApplicationContext().getPackageName();     // Catch: Throwable -> L11
        int r3 = r2.uid;     // Catch: Throwable -> L11
        Reflect r4 = Reflect.on(r1);     // Catch: Throwable -> L11
        Class r5 = Integer.TYPE;     // Catch: Throwable -> L11
        Integer r6 = (Integer) r4.field("OP_POST_NOTIFICATION", new Class[]{r5}).get();     // Catch: Throwable -> L11
        r6.intValue();     // Catch: Throwable -> L11
        if (((Integer) r4.call("checkOpNoThrow", new Class[]{r5, r5, String.class}, new Object[]{r6, Integer.valueOf(r3), r8}).get()).intValue() != 0) goto L9;
        return 1;
    L9:
        return 0;
    L11:
        th = move-exception;
        th.printStackTrace();
        return -1;
    }

    public static void clearDir(String r3) {
        File r0 = new File(r3);
        if (r0.exists() == true) goto L5;
        return;
    L5:
        File[] r4 = r0.listFiles();
        int r1 = r4.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L14;
        if (r4[r2].isDirectory() == false) goto L11;
        removeDir(r4[r2].getAbsolutePath());
    L13:
        r2 = r2 + 1;
        goto L6
    L11:
        if (r4[r2].isFile() == false) goto L13;
        r4[r2].delete();
        goto L13
    }

    public static void createShortCut(Context r3, Intent r4, String r5, Bitmap r6) {
        if (r3 == null) goto L19;
        if (r4 != null) goto L6;
        return;
    L6:
        if (StringUtils.isEmpty(r5) == true) goto L21;
        if (r6 != null) goto L10;
        return;
    L10:
        if (isShortcutInstalled(r3, r5) == false) goto L17;
        return;
    L17:
        Intent r1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");     // Catch: Exception -> L16
        r1.putExtra("android.intent.extra.shortcut.NAME", r5);     // Catch: Exception -> L16
        r1.putExtra("android.intent.extra.shortcut.ICON", r6);     // Catch: Exception -> L16
        r1.putExtra("duplicate", false);     // Catch: Exception -> L16
        r1.putExtra("android.intent.extra.shortcut.INTENT", r4);     // Catch: Exception -> L16
        r3.sendBroadcast(r1);     // Catch: Exception -> L16
        if (Logger.debug() == false) goto L22;
        Logger.d("launcher_ad", "createShortCut intent " + r4.toUri(0));     // Catch: Exception -> L16
        return;
    L22:
        return;
    L24:
        return;
    L21:
        return;
    }

    public static void deleteShortCut(Context r3, Intent r4, String r5) {
        if (r3 == null) goto L15;
        if (r4 != null) goto L6;
        return;
    L6:
        if (StringUtils.isEmpty(r5) == true) goto L18;
        Intent r1 = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");     // Catch: Exception -> L12
        r1.putExtra("android.intent.extra.shortcut.INTENT", r4);     // Catch: Exception -> L12
        r1.putExtra("android.intent.extra.shortcut.NAME", r5);     // Catch: Exception -> L12
        r1.putExtra("duplicate", false);     // Catch: Exception -> L12
        r3.sendBroadcast(r1);     // Catch: Exception -> L12
        if (Logger.debug() == false) goto L17;
        Logger.d("launcher_ad", "deleteShortCut intent " + r4.toUri(0));     // Catch: Exception -> L12
        return;
    L17:
        return;
    L19:
        return;
    L18:
        return;
    }

    private static String getAuthorityFromPermission(Context r6, String r7) {
        if (TextUtils.isEmpty(r7) == false) goto L25;
        return null;
    L25:
        List<PackageInfo> r8 = r6.getPackageManager().getInstalledPackages(8);     // Catch: Exception -> L24
        if (r8 != null) goto L8;
        return null;
    L8:
        Iterator<PackageInfo> r9 = r8.iterator();     // Catch: Exception -> L24
    L10:
        if (r9.hasNext() == false) goto L23;
        ProviderInfo[] r0 = r9.next().providers;     // Catch: Exception -> L24
        if (r0 == null) goto L10;
        int r2 = r0.length;     // Catch: Exception -> L24
        int r3 = 0;
    L14:
        if (r3 >= r2) goto L10;
        ProviderInfo r4 = r0[r3];     // Catch: Exception -> L24
        if (r7.equals(r4.readPermission) == true) goto L21;
        if (r7.equals(r4.writePermission) == true) goto L21;
        r3 = r3 + 1;     // Catch: Exception -> L24
    L21:
        return r4.authority;
    L23:
        return null;
    }

    public static String getCacheDirPath(Context r3) {
        if (r3 == null) goto L17;
        String r1 = null;
        if (r3.getCacheDir() == null) goto L8;
        r1 = r3.getCacheDir().getPath();     // Catch: Throwable -> L18
    L19:
        goto L12
    L8:
        File r4 = r3.getDir("/data/data/" + r3.getPackageName() + "/cache/", 0);     // Catch: Throwable -> L18
        if (r4 == null) goto L19;
        r1 = r4.getPath();     // Catch: Throwable -> L18
    L12:
        if (StringUtils.isEmpty(r1) == true) goto L15;
        return r1;
    L15:
        throw new NullPointerException("Cannot Create Cache Dir");
    L17:
        throw new NullPointerException("Context is NUll");
    }

    public static String getCurProcessName(Context r3) {
        String r0 = sCurProcessName;
        if (StringUtils.isEmpty(r0) == true) goto L20;
        return r0;
    L20:
        int r1 = Process.myPid();     // Catch: Exception -> L13
        Iterator<ActivityManager.RunningAppProcessInfo> r4 = ((ActivityManager) r3.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L13
    L7:
        if (r4.hasNext() == false) goto L18;
        ActivityManager.RunningAppProcessInfo r2 = r4.next();     // Catch: Exception -> L13
        if (r2.pid != r1) goto L7;
        if (Logger.debug() == false) goto L15;
        Logger.d("Process", "processName = " + r2.processName);     // Catch: Exception -> L13
    L15:
        String r5 = r2.processName;     // Catch: Exception -> L13
        sCurProcessName = r5;     // Catch: Exception -> L13
        return r5;
    L18:
        String r6 = getCurProcessNameFromProc();
        sCurProcessName = r6;
        return r6;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L18
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
        if (r2 != null) goto L27;
    L17:
        return null;
    L27:
        r2.close();     // Catch: Exception -> L20
    L14:
        r2 = null;
        goto L15
    }

    public static String getDefaultBrowserString(Context r5) {
        Intent r0 = new Intent("android.intent.action.VIEW");     // Catch: Exception -> L16
        r0.addCategory("android.intent.category.DEFAULT");     // Catch: Exception -> L16
        r0.addCategory("android.intent.category.BROWSABLE");     // Catch: Exception -> L16
        r0.setDataAndType(Uri.parse("http://"), null);     // Catch: Exception -> L16
        List<ResolveInfo> r6 = r5.getPackageManager().queryIntentActivities(r0, 65568);     // Catch: Exception -> L16
        if (r6.size() <= 0) goto L36;
        Iterator<ResolveInfo> r1 = r6.iterator();     // Catch: Exception -> L16
    L7:
        if (r1.hasNext() == false) goto L18;
        ResolveInfo r2 = r1.next();     // Catch: Exception -> L16
        if (r2 == null) goto L7;
        ActivityInfo r3 = r2.activityInfo;     // Catch: Exception -> L16
        if (r3 == null) goto L7;
        if ("com.android.browser".equals(r3.packageName) == false) goto L7;
        return r2.activityInfo.packageName + LibrarianImpl.Constants.SEPARATOR + r2.activityInfo.name;
    L18:
        ResolveInfo r7 = r6.get(0);     // Catch: Exception -> L16
        if (r7 != null) goto L21;
        return "com.android.browser/com.android.browser.BrowserActivity";
    L21:
        if (r7.activityInfo != null) goto L23;
        return "com.android.browser/com.android.browser.BrowserActivity";
    L23:
        return r7.activityInfo.packageName + LibrarianImpl.Constants.SEPARATOR + r7.activityInfo.name;
    L36:
        return "com.android.browser/com.android.browser.BrowserActivity";
    L16:
        e = move-exception;
        e.printStackTrace();
        return "com.android.browser/com.android.browser.BrowserActivity";
    }

    public static long getDirectorySize(File r6, boolean r7) {
        long r0 = 0;
        if (r6.exists() == false) goto L6;
    L8:
        File[] r8 = r6.listFiles();     // Catch: Throwable -> L20
        int r2 = r8.length;     // Catch: Throwable -> L20
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L19;
        File r4 = r8[r3];     // Catch: Throwable -> L20
        if (r4.isDirectory() == false) goto L15;
        long r5 = getDirectorySize(r4, r7);     // Catch: Throwable -> L20
    L13:
        r0 = r0 + r5;     // Catch: Throwable -> L20
    L18:
        r3 = r3 + 1;
        goto L9
    L15:
        if (r4.isFile() == false) goto L18;
        r5 = r4.length();     // Catch: Throwable -> L20
        goto L13
    L6:
        if (r6.isDirectory() == false) goto L8;
        return 0;
    L19:
        return r0;
    }

    public static String getEmuiInfo() {
        if (StringUtils.isEmpty(systemProperty) == true) goto L7;
        return systemProperty;
    L7:
        if (bAlreadyGetProp == true) goto L10;
        systemProperty = SystemPropertiesUtils.getSystemProperty("ro.build.version.emui");
        bAlreadyGetProp = true;
    L10:
        return systemProperty;
    }

    public static String getFilesDirPath(Context r3) {
        if (r3 == null) goto L17;
        String r1 = null;
        if (r3.getFilesDir() == null) goto L8;
        r1 = r3.getFilesDir().getPath();     // Catch: Throwable -> L18
    L19:
        goto L12
    L8:
        File r4 = r3.getDir("/data/data/" + r3.getPackageName() + "/files/", 0);     // Catch: Throwable -> L18
        if (r4 == null) goto L19;
        r1 = r4.getPath();     // Catch: Throwable -> L18
    L12:
        if (StringUtils.isEmpty(r1) == true) goto L15;
        return r1;
    L15:
        throw new NullPointerException("Cannot Create Files Dir");
    L17:
        throw new NullPointerException("Context is NUll");
    }

    public static Intent getLaunchIntentForPackage(Context r1, String r2) {
        Intent r3 = r1.getPackageManager().getLaunchIntentForPackage(r2);
        if (r3 != null) goto L6;
        return r3;
    L6:
        if (r3.hasCategory("android.intent.category.LAUNCHER") == true) goto L8;
        r3.addCategory("android.intent.category.LAUNCHER");
        Logger.d("ToolUtils", "add category LAUNCHER in launch intent");
    L8:
        r3.setPackage(null);
        r3.addFlags(2097152);
        r3.addFlags(268435456);
        return r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    public static int getLocationMode(Context r3) {
        if (r3 != null) goto L16;
        return -1;
    L16:
    L15:
        return -1;
    L6:
        if (StringUtils.isEmpty(Settings.Secure.getString(r3.getContentResolver(), "location_providers_allowed")) == true) goto L13;
        LocationManager r4 = (LocationManager) r3.getSystemService(BatteryTypeInf.BATTERY_LOC_API);     // Catch: Throwable -> L15
        boolean r1 = r4.isProviderEnabled("gps");     // Catch: Throwable -> L15
        ?? r2 = r1;
        if (r4.isProviderEnabled("network") == false) goto L10;
        r2 = (r1 ? 1 : 0) | 2;     // Catch: Throwable -> L15
    L10:
        if (r4.isProviderEnabled("passive") == true) goto L19;
        return r2;
    L19:
        return r2 | 4;
    L13:
        return 0;
    }

    public static String getProviderAuthority(Context r5, String r6) {
        if (r5 != null) goto L5;
    L14:
        return null;
    L5:
        if (StringUtils.isEmpty(r6) == true) goto L14;
        ProviderInfo[] r7 = r5.getPackageManager().getPackageInfo(r5.getPackageName(), 8).providers;     // Catch: Exception -> L15
        int r1 = r7.length;     // Catch: Exception -> L15
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L14;
        ProviderInfo r3 = r7[r2];     // Catch: Exception -> L15
        if (r6.equals(r3.name) == true) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        return r3.authority;
    }

    public static String getRunningTaskInfoString(Context r6) {
        if (r6 != null) goto L22;
        return "";
    L22:
        List<ActivityManager.RunningTaskInfo> r2 = ((ActivityManager) r6.getSystemService("activity")).getRunningTasks(5);     // Catch: Throwable -> L21
        if (r2 != null) goto L8;
        return "";
    L8:
        String r7 = r6.getPackageName();     // Catch: Throwable -> L21
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L21
        Iterator<ActivityManager.RunningTaskInfo> r4 = r2.iterator();     // Catch: Throwable -> L21
    L10:
        if (r4.hasNext() == false) goto L20;
        ActivityManager.RunningTaskInfo r5 = r4.next();     // Catch: Throwable -> L21
        if (r5 == null) goto L10;
        ComponentName r8 = r5.baseActivity;     // Catch: Throwable -> L21
        if (r8 == null) goto L10;
        if (r7.equals(r8.getPackageName()) == false) goto L10;
        r3.append("id = ");     // Catch: Throwable -> L21
        r3.append(r5.id);     // Catch: Throwable -> L21
        r3.append(" ");     // Catch: Throwable -> L21
        r3.append("description = ");     // Catch: Throwable -> L21
        r3.append(r5.description);     // Catch: Throwable -> L21
        r3.append(" ");     // Catch: Throwable -> L21
        r3.append("number_of_activities = ");     // Catch: Throwable -> L21
        r3.append(r5.numActivities);     // Catch: Throwable -> L21
        r3.append(" ");     // Catch: Throwable -> L21
        r3.append("number_of_running_activities = ");     // Catch: Throwable -> L21
        r3.append(r5.numRunning);     // Catch: Throwable -> L21
        r3.append(" ");     // Catch: Throwable -> L21
        r3.append("topActivity = ");     // Catch: Throwable -> L21
        r3.append(r5.topActivity.toString());     // Catch: Throwable -> L21
        r3.append(" ");     // Catch: Throwable -> L21
        r3.append("baseActivity = ");     // Catch: Throwable -> L21
        r3.append(r5.baseActivity.toString());     // Catch: Throwable -> L21
        return r3.toString();
    L20:
        return "";
    }

    public static String getUserSerial(Context r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        Object r8 = r7.getSystemService("user");
        if (r8 != null) goto L25;
        Logger.e("ToolUtils", "userManager not exsit !!!");
        return null;
    L25:
        Object r0 = Process.class.getMethod("myUserHandle", null).invoke(Process.class, null);     // Catch: InvocationTargetException -> L11 IllegalAccessException -> L13 IllegalArgumentException -> L15 NoSuchMethodException -> L17 Throwable -> L24
        return String.valueOf(((Long) r8.getClass().getMethod("getSerialNumberForUser", new Class[]{r0.getClass()}).invoke(r8, new Object[]{r0})).longValue());
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
    L23:
        return null;
    }

    public static String handleZipEntryGetNameLeak(String r5) {
        if (StringUtils.isEmpty(r5) == false) goto L14;
        return r5;
    L14:
        if (Logger.debug() == false) goto L9;
        Logger.d("Process", "before handle = " + r5);     // Catch: Exception -> L13
    L9:
        r5 = r5.replaceAll(".." + File.separator, "");     // Catch: Exception -> L13
        if (Logger.debug() == false) goto L12;
        Logger.d("Process", "after handle = " + r5);     // Catch: Exception -> L13
    L12:
        return r5;
    }

    public static void installShortcut(Context r7, String r8) {
        if (r7 != null) goto L22;
        return;
    L22:
        Intent r0 = getLaunchIntentForPackage(r7, r8);     // Catch: Exception -> L12
        if (r0 != null) goto L7;
        return;
    L7:
        PackageManager r1 = r7.getPackageManager();     // Catch: Exception -> L12
        ApplicationInfo r3 = r1.getApplicationInfo(r8, 0);     // Catch: Exception -> L12
        Resources r4 = r1.getResourcesForApplication(r3);     // Catch: Exception -> L12
        String r5 = r4.getResourceName(r3.icon);     // Catch: Exception -> L12
        int r6 = r1.getActivityInfo(r0.getComponent(), 0).labelRes;     // Catch: Exception -> L12 Resources.NotFoundException -> L15
        if (r6 <= 0) goto L14;
        CharSequence r2 = r4.getString(r6);     // Catch: Exception -> L12 Resources.NotFoundException -> L15
    L16:
        if (r2 != null) goto L18;
        return;
    L18:
        Intent r9 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");     // Catch: Exception -> L12
        r9.putExtra("android.intent.extra.shortcut.NAME", r2);     // Catch: Exception -> L12
        r9.putExtra("android.intent.extra.shortcut.INTENT", r0);     // Catch: Exception -> L12
        r9.putExtra("launch_from", 1);     // Catch: Exception -> L12
        Intent.ShortcutIconResource r10 = new Intent.ShortcutIconResource();     // Catch: Exception -> L12
        r10.packageName = r8;     // Catch: Exception -> L12
        r10.resourceName = r5;     // Catch: Exception -> L12
        r9.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", r10);     // Catch: Exception -> L12
        r9.putExtra("duplicate", false);     // Catch: Exception -> L12
        r7.sendBroadcast(r9);     // Catch: Exception -> L12
        return;
    L14:
        r2 = null;
    L15:
        r2 = r1.getApplicationLabel(r3);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        Log.w("ToolUtils", "addAppShortcut failed: " + e);
    }

    public static boolean isApkInstalled(Context r3, String r4) {
        if (r3 == null) goto L30;
        if (r4 != null) goto L6;
        return false;
    L6:
        if (StringUtils.isEmpty(r4) == true) goto L35;
        File r1 = new File(r4);     // Catch: Exception -> L16
        if (r1.exists() == false) goto L32;
        PackageInfo r5 = r3.getPackageManager().getPackageArchiveInfo(r1.getAbsolutePath(), 1);     // Catch: Exception -> L16
        if (r5 != null) goto L13;
        return false;
    L13:
        String r2 = r5.packageName;     // Catch: Exception -> L16
        int r6 = r5.versionCode;     // Catch: Exception -> L16
        PackageInfo r7 = r3.getPackageManager().getPackageInfo(r2, 1);     // Catch: Exception -> L16 PackageManager.NameNotFoundException -> L18
    L19:
        if (r7 == null) goto L36;
        if (r6 <= r7.versionCode) goto L34;
        return false;
    L34:
        return true;
    L36:
        return false;
    L18:
        r7 = null;
        goto L19
    L32:
        return false;
    L16:
        e = move-exception;
        e.printStackTrace();
        return false;
    L35:
        return false;
    L30:
        return false;
    }

    public static boolean isApplicationForeground(Context r3, String r4) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (StringUtils.isEmpty(r4) == true) goto L24;
        List<ActivityManager.RunningAppProcessInfo> r5 = ((ActivityManager) r3.getSystemService("activity")).getRunningAppProcesses();
        if (r5 == null) goto L22;
        Iterator<ActivityManager.RunningAppProcessInfo> r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L25;
        ActivityManager.RunningAppProcessInfo r1 = r6.next();
        if (r4.equals(r1.processName) == false) goto L11;
        if (r1.importance != 100) goto L23;
        return true;
    L23:
        return false;
    L25:
        return false;
    L22:
        return false;
    L24:
        return false;
    }

    public static boolean isEmui(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        r2 = getEmuiInfo();
    L6:
        if (TextUtils.isEmpty(r2) == true) goto L11;
        if (r2.toLowerCase(Locale.getDefault()).startsWith("emotionui") == false) goto L11;
        return true;
    L11:
        if (isHuaweiDevice() == false) goto L13;
        return true;
    L13:
        return false;
    }

    public static boolean isFlyme() {
        String r0 = Build.DISPLAY;
        if (StringUtils.isEmpty(r0) == false) goto L5;
    L6:
        String r1 = Build.USER;
        if (StringUtils.isEmpty(r1) == false) goto L9;
        return false;
    L9:
        if (r1.equals("flyme") == false) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r0.indexOf("Flyme") < 0) goto L6;
        return true;
    }

    public static boolean isHuaweiDevice() {
        String r1 = Build.BRAND;     // Catch: Throwable -> L14
        if (StringUtils.isEmpty(r1) == false) goto L7;
    L8:
        String r2 = Build.MANUFACTURER;     // Catch: Throwable -> L14
        if (StringUtils.isEmpty(r2) == true) goto L17;
        if (r2.toLowerCase(Locale.getDefault()).startsWith("huawei") == false) goto L18;
    L12:
        return true;
    L18:
        return false;
    L17:
        return false;
    L7:
        if (r1.toLowerCase(Locale.getDefault()).startsWith("huawei") == true) goto L12;
    L19:
        return false;
    }

    public static boolean isInstalledApp(Context r2, String r3) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (StringUtils.isEmpty(r3) == false) goto L12;
        return false;
    L12:
        if (r2.getPackageManager().getPackageInfo(r3, 16777216) == null) goto L16;
        return true;
    L16:
        return false;
    L17:
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

    public static long isMainProcessRetId(Context r2) {
        if (isMainProcess(r2) == true) goto L5;
        return 0;
    L5:
        return Thread.currentThread().getId();
    }

    public static boolean isMessageProcess(Context r1) {
        String r2 = getCurProcessName(r1);
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.endsWith(mMsgProcessSuffix) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean isMiui() {
        if (sIsInited == true) goto L9;
        Class.forName("miui.os.Build");     // Catch: Exception -> L7
        sIsMiui = true;     // Catch: Exception -> L7
        sIsInited = true;     // Catch: Exception -> L7
        return true;
    L7:
        sIsInited = true;
    L9:
        return sIsMiui;
    }

    public static boolean isNoDexProcess(Context r1) {
        String r2 = getCurProcessName(r1);
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.endsWith(NODEX_PROCESS_SUFFIX) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean isPackageMatchApk(Context r3, String r4, String r5) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (StringUtils.isEmpty(r4) == false) goto L7;
        return false;
    L7:
        if (StringUtils.isEmpty(r5) == true) goto L39;
        File r1 = new File(r4);     // Catch: Exception -> L20
        if (r1.exists() == false) goto L36;
        PackageInfo r6 = r3.getPackageManager().getPackageArchiveInfo(r1.getAbsolutePath(), 1);     // Catch: Exception -> L20
        if (r6 != null) goto L15;
        return false;
    L15:
        if (r6.packageName.equals(r5) == true) goto L17;
        return false;
    L17:
        int r7 = r6.versionCode;     // Catch: Exception -> L20
        PackageInfo r8 = r3.getPackageManager().getPackageInfo(r5, 1);     // Catch: Exception -> L20 PackageManager.NameNotFoundException -> L22
    L23:
        if (r8 == null) goto L40;
        if (r7 == r8.versionCode) goto L38;
        return false;
    L38:
        return true;
    L40:
        return false;
    L22:
        r8 = null;
        goto L23
    L36:
        return false;
    L20:
        e = move-exception;
        e.printStackTrace();
        return false;
    L39:
        return false;
    }

    public static boolean isSafeModeProcess(Context r1) {
        String r2 = getCurProcessName(r1);
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.endsWith(":safe_mode") == false) goto L7;
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
        List<ActivityManager.RunningServiceInfo> r6 = ((ActivityManager) r3.getSystemService("activity")).getRunningServices(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);     // Catch: Throwable -> L22
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

    public static boolean isShortcutInstalled(Context r8, String r9) {
        boolean r1 = false;
        String r2 = getAuthorityFromPermission(r8, "com.android.launcher.permission.READ_SETTINGS");     // Catch: Exception -> L14
        if (r2 != null) goto L6;
        r2 = "com.android.launcher.settings";
    L6:
        Cursor r10 = r8.getContentResolver().query(Uri.parse("content://" + r2 + "/favorites?notify=true"), new String[]{"title"}, "title=?", new String[]{r9}, null);     // Catch: Exception -> L14
        if (r10 != null) goto L9;
    L11:
        if (r10 == null) goto L13;
        r10.close();     // Catch: Exception -> L14
        goto L13
    L9:
        if (r10.getCount() <= 0) goto L11;
        r1 = true;
    L13:
        return r1;
    }

    public static boolean isSubProcess(Context r0, String r1) {
        String r2 = getCurProcessName(r0);
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.endsWith(r1) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static void openInstalledApp(Context r1, String r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (StringUtils.isEmpty(r2) == true) goto L12;
        Intent r3 = r1.getPackageManager().getLaunchIntentForPackage(r2);     // Catch: Exception -> L8
        r3.addFlags(268435456);     // Catch: Exception -> L8
        r1.startActivity(r3);     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    public static void removeDir(String r4) {
        File r0 = new File(r4);
        if (r0.exists() == true) goto L5;
        return;
    L5:
        if (r0.isDirectory() == false) goto L19;
        File[] r5 = r0.listFiles();
        int r1 = r5.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L13;
        if (r5[r2].isDirectory() == false) goto L11;
        removeDir(r5[r2].getAbsolutePath());
    L12:
        r2 = r2 + 1;
        goto L7
    L11:
        r5[r2].delete();
        goto L12
    L13:
        r0.delete();
        return;
    }

    public static void runApplication(Context r2, String r3, String r4) {
        if (StringUtils.isEmpty(r3) == true) goto L5;
        boolean r0 = isInstalledApp(r2, r3);
    L6:
        if (r0 == false) goto L12;
        Intent r1 = getLaunchIntentForPackage(r2, r3);
        if (r1 == null) goto L12;
        r2.startActivity(r1);
        return;
    L12:
        if (StringUtils.isEmpty(r4) == true) goto L16;
        r2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(r4)));     // Catch: Exception -> L20
        return;
    L16:
        if (StringUtils.isEmpty(r3) == true) goto L26;
        Intent r5 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + r3));
        r5.addFlags(268435456);
        r2.startActivity(r5);     // Catch: Exception -> L21
        return;
    L27:
        return;
    L26:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void setCanSetStatusBar(boolean r0) {
        sCanSetStatusBar = r0;
    }

    private static void setFlymeStatusBarDarkMode(boolean r3, Window r4) {
        WindowManager.LayoutParams r0 = r4.getAttributes();     // Catch: Throwable -> L5
        Field r1 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");     // Catch: Throwable -> L5
        if (r3 == false) goto L7;
        r1.set(r0, Integer.valueOf(r1.getInt(r0) | 512));     // Catch: Throwable -> L5
    L8:
        r4.setAttributes(r0);     // Catch: Throwable -> L5
        return;
    L7:
        r1.set(r0, Integer.valueOf(r1.getInt(r0) & NetError.ERR_TTNET_FT_INVALID_STREAM));     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public static void setMessageProcessSuffix(String r0) {
        mMsgProcessSuffix = r0;
    }

    private static void setMiuiStatusBarDarkMode(boolean r4, Window r5) {
        Class<?> r0 = r5.getClass();     // Catch: Throwable -> L8
        Class<?> r1 = Class.forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L8
        int r2 = r1.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(r1);     // Catch: Throwable -> L8
        Class r3 = Integer.TYPE;     // Catch: Throwable -> L8
        Method r6 = r0.getMethod("setExtraFlags", new Class[]{r3, r3});     // Catch: Throwable -> L8
        if (r4 == false) goto L5;
        int r7 = r2;
    L6:
        r6.invoke(r5, new Object[]{Integer.valueOf(r7), Integer.valueOf(r2)});     // Catch: Throwable -> L8
        return;
    L5:
        r7 = 0;
    L8:
        th = move-exception;
        th.printStackTrace();
    }

    public static void startPhoneScreen(Context r2, String r3) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (StringUtils.isEmpty(r3) == true) goto L16;
        Intent r0 = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + Uri.encode(r3)));     // Catch: Exception -> L12
        if ((r2 instanceof Activity) == true) goto L10;
        r0.setFlags(268435456);     // Catch: Exception -> L12
    L10:
        r2.startActivity(r0);     // Catch: Exception -> L12
        return;
    L17:
        return;
    }

    @TargetApi(21)
    public static void trySetStatusBar(Context r4, Window r5, int r6, boolean r7) {
        if (r4 == null) goto L30;
        if (r5 == null) goto L31;
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (sCanSetStatusBar == true) goto L12;
        r5.clearFlags(Integer.MIN_VALUE);     // Catch: Throwable -> L9
        return;
    L12:
        if (isMiui() == false) goto L17;
        if (r7 == false) goto L15;
        setMiuiStatusBarDarkMode(false, r5);     // Catch: Throwable -> L9
    L25:
        r5.clearFlags(67108864);     // Catch: Throwable -> L9
        r5.addFlags(Integer.MIN_VALUE);     // Catch: Throwable -> L9
        r5.setStatusBarColor(r4.getResources().getColor(r6));     // Catch: Throwable -> L9
        return;
    L15:
        setMiuiStatusBarDarkMode(true, r5);     // Catch: Throwable -> L9
        goto L25
    L17:
        if (isFlyme() == false) goto L21;
        if (r7 == false) goto L20;
        setFlymeStatusBarDarkMode(false, r5);     // Catch: Throwable -> L9
        goto L25
    L20:
        setFlymeStatusBarDarkMode(true, r5);     // Catch: Throwable -> L9
        goto L25
    L21:
        View r0 = r5.getDecorView();     // Catch: Throwable -> L9
        int r2 = r0.getSystemUiVisibility();     // Catch: Throwable -> L9
        if (r7 == false) goto L24;
        r0.setSystemUiVisibility(r2 & (-8193));     // Catch: Throwable -> L9
        goto L25
    L24:
        r0.setSystemUiVisibility(r2 | 8192);     // Catch: Throwable -> L9
        goto L25
    L31:
        return;
    }

    public static void trySetStatusBarWithFullScreen(Window r2) {
        if (r2 != null) goto L10;
        return;
    L10:
        r2.clearFlags(201326592);     // Catch: Throwable -> L7
        r2.getDecorView().setSystemUiVisibility(1792);     // Catch: Throwable -> L7
        r2.addFlags(Integer.MIN_VALUE);     // Catch: Throwable -> L7
        r2.setStatusBarColor(0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
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

    public static void clearDir(String r3, Set<String> r4) {
        File r0 = new File(r3);
        if (r0.exists() == true) goto L5;
        return;
    L5:
        File[] r5 = r0.listFiles();
        int r1 = r5.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L18;
        if (r5[r2].isDirectory() == false) goto L11;
        removeDir(r5[r2].getAbsolutePath(), r4);
    L17:
        r2 = r2 + 1;
        goto L6
    L11:
        if (r5[r2].isFile() == false) goto L17;
        String r6 = r5[r2].getName();
        if (r4 != null) goto L15;
    L16:
        r5[r2].delete();
        goto L17
    L15:
        if (r4.contains(r6) == true) goto L17;
    }

    public static void removeDir(String r3, Set<String> r4) {
        File r0 = new File(r3);
        if (r0.exists() == true) goto L5;
        return;
    L5:
        if (r0.isDirectory() == false) goto L22;
        File[] r5 = r0.listFiles();
        int r1 = r5.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L23;
        if (r5[r2].isDirectory() == false) goto L11;
        removeDir(r5[r2].getAbsolutePath(), r4);
    L16:
        r2 = r2 + 1;
        goto L7
    L11:
        String r6 = r5[r2].getName();
        if (r4 != null) goto L14;
    L15:
        r5[r2].delete();
        goto L16
    L14:
        if (r4.contains(r6) == true) goto L16;
    L23:
        return;
    }
}
