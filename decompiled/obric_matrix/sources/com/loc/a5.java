package com.loc;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.MotionEventCompat;
import com.amap.api.location.AMapLocation;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f7149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String[] f7150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static WifiManager f7151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f7152d;

    static {
    }

    public static long A() {
        return SystemClock.elapsedRealtime();
    }

    private static FileInputStream B(File r3) {
        if (r3.exists() == false) goto L15;
        if (r3.isDirectory() == true) goto L13;
        if (r3.canRead() == false) goto L11;
        return new FileInputStream(r3);
    L11:
        throw new IOException("File '" + r3 + "' cannot be read");
    L13:
        throw new IOException("File '" + r3 + "' exists but is a directory");
    L15:
        throw new FileNotFoundException("File '" + r3 + "' does not exist");
    }

    public static String C(Context r5) {
        if (TextUtils.isEmpty(s4.f7777j) == false) goto L5;
        CharSequence r1 = null;
        if (r5 != null) goto L38;
        return null;
    L38:
        PackageInfo r2 = r5.getPackageManager().getPackageInfo(i5.g(r5), 64);     // Catch: Throwable -> L12
    L40:
    L18:
        th = move-exception;
        s4.h(th, "Utils", "getAppName");
    L20:
        StringBuilder r0 = new StringBuilder();
        if (r2 == null) goto L30;
        ApplicationInfo r3 = r2.applicationInfo;
        if (r3 == null) goto L25;
        r1 = r3.loadLabel(r5.getPackageManager());
    L25:
        if (r1 == null) goto L28;
        r0.append(r1.toString());
    L28:
        if (TextUtils.isEmpty(r2.versionName) == true) goto L30;
        r0.append(r2.versionName);
    L30:
        String r6 = i5.g(r5);
        if (TextUtils.isEmpty(r6) == true) goto L34;
        r0.append(",");
        r0.append(r6);
    L34:
        if (TextUtils.isEmpty(s4.f7778k) == true) goto L36;
        r0.append(",");
        r0.append(s4.f7778k);
    L36:
        String r7 = r0.toString();
        s4.f7777j = r7;
        return r7;
    L15:
        if (TextUtils.isEmpty(s4.f7778k) == false) goto L20;
        s4.f7778k = null;     // Catch: Throwable -> L18
    L12:
        th = move-exception;
        s4.h(th, "Utils", "getAppName part");
        r2 = null;
        goto L40
    L5:
        return s4.f7777j;
    }

    public static ArrayList<String> D(String r4) {
        ArrayList<String> r0 = new ArrayList();
        if (TextUtils.isEmpty(r4) == true) goto L13;
        String[] r5 = r4.split("#");
        int r1 = 0;
    L6:
        if (r1 >= r5.length) goto L13;
        if (r5[r1].contains(",nb") == false) goto L10;
    L11:
        r0.add(r5[r1]);
    L12:
        r1 = r1 + 1;
        goto L6
    L10:
        if (r5[r1].contains(",access") == false) goto L12;
    L13:
        return r0;
    }

    public static boolean E(Context r1, String r2) {
        PackageInfo r3 = r1.getApplicationContext().getPackageManager().getPackageInfo(r2, 256);     // Catch: Throwable -> L5
    L6:
        if (r3 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r3 = null;
        goto L6
    }

    public static boolean F(AMapLocation r7) {
        double r0 = r7.getLongitude();
        double r2 = r7.getLatitude();
        if (r0 != 0.0d) goto L8;
        if (r2 != 0.0d) goto L8;
        return false;
    L8:
        if (r0 <= 180.0d) goto L10;
    L19:
        return false;
    L10:
        if (r2 > 90.0d) goto L19;
        if (r0 < (-180.0d)) goto L19;
        if (r2 < (-90.0d)) goto L19;
        return true;
    }

    public static byte[] G(int r2, byte[] r3) {
        if (r3 != null) goto L5;
    L6:
        r3 = new byte[4];
    L7:
        int r0 = 0;
    L9:
        if (r0 >= r3.length) goto L11;
        r3[r0] = (byte) ((r2 >> (r0 * 8)) & 255);
        r0 = r0 + 1;
        goto L9
    L11:
        return r3;
    L5:
        if (r3.length >= 4) goto L7;
        goto L6
    }

    public static double H(double r2) {
        return ((long) (r2 * 100.0d)) / 100.0d;
    }

    public static double I(String r2) {
        return Double.parseDouble(r2);
    }

    public static int J() {
        int r0 = f7149a;
        if (r0 <= 0) goto L11;
        return r0;
    L11:
        return w4.g("android.os.Build$VERSION", "SDK_INT");
    L8:
        return Integer.parseInt(w4.d("android.os.Build$VERSION", "SDK").toString());
    L15:
        return 0;
    }

    public static NetworkInfo K(Context r2) {
        return l5.O(r2);
    L4:
        th = move-exception;
        s4.h(th, "Utils", "getNetWorkInfo");
        return null;
    }

    private static FileOutputStream L(File r3) {
        if (r3.exists() == true) goto L5;
        File r0 = r3.getParentFile();
        if (r0 != null) goto L16;
    L24:
        return new FileOutputStream(r3, false);
    L16:
        if (r0.mkdirs() == false) goto L18;
    L22:
        r3.createNewFile();
        goto L24
    L18:
        if (r0.isDirectory() == true) goto L22;
        throw new IOException("Directory '" + r0 + "' could not be created");
    L5:
        if (r3.isDirectory() == true) goto L12;
        if (r3.canWrite() == true) goto L24;
        throw new IOException("File '" + r3 + "' cannot be written to");
    L12:
        throw new IOException("File '" + r3 + "' exists but is a directory");
    }

    public static boolean M(Context r4, String r5) {
        boolean r0 = false;
    L13:
        u4.c();
    L14:
        return r0;
    L4:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        if (r4 != null) goto L7;
    L15:
        goto L14
    L7:
        if (r4.checkSelfPermission(u5.u(r5)) != 0) goto L15;
    L8:
        r0 = true;
        goto L15
    L9:
        if (r4 == null) goto L15;
        if (r4.checkCallingOrSelfPermission(u5.u(r5)) != 0) goto L15;
        goto L8
    }

    public static float N(String r0) {
        return Float.parseFloat(r0);
    }

    public static int O() {
        return new Random().nextInt(65536) - 32768;
    }

    public static boolean P(Context r1) {
        NetworkInfo r2 = K(r1);     // Catch: Throwable -> L10
        if (r2 == null) goto L9;
        if (r2.isConnectedOrConnecting() == false) goto L9;
        return true;
    L9:
        return false;
    }

    private static boolean Q(Context r4, String r5) {
        if (((Integer) w4.e(r5, "getInt", new Object[]{r4.getContentResolver(), ((String) w4.d(r5, "AIRPLANE_MODE_ON")).toString()}, new Class[]{ContentResolver.class, String.class})).intValue() != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public static int R(String r0) {
        return Integer.parseInt(r0);
    }

    public static String S() {
        return m5.f("S128DF1572465B890OE3F7A13167KLEI".getBytes("UTF-8")).substring(20);
    L4:
        return "";
    }

    public static boolean T(Context r9) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
    L15:
        String[] r0 = s3.O;
        int r1 = r0.length;
        int r4 = 0;
    L16:
        if (r4 >= r1) goto L29;
        if (r9.checkCallingOrSelfPermission(r0[r4]) != 0) goto L21;
        r4 = r4 + 1;
    L21:
        return false;
    L29:
        return true;
    L5:
        if (r9.getApplicationInfo().targetSdkVersion < 23) goto L15;
        Application r10 = (Application) r9;
        String[] r2 = s3.O;
        int r3 = r2.length;
        int r5 = 0;
    L7:
        if (r5 >= r3) goto L28;
        int r6 = w4.f(r10.getBaseContext(), "checkSelfPermission", new Object[]{r2[r5]});     // Catch: Throwable -> L11
    L12:
        if (r6 != 0) goto L21;
        r5 = r5 + 1;
    L11:
        r6 = 0;
        goto L12
    L28:
        return true;
    }

    public static int U(String r1) {
        return Integer.parseInt(r1, 16);
    }

    public static boolean V(Context r5) {
        if (r5.getApplicationInfo().targetSdkVersion >= 29) goto L5;
        return true;
    L5:
        if (Build.VERSION.SDK_INT >= 29) goto L13;
        return true;
    L13:
        int r6 = w4.f(((Application) r5).getBaseContext(), "checkSelfPermission", new Object[]{s3.P});     // Catch: Throwable -> L9
    L10:
        if (r6 != 0) goto L12;
        return true;
    L12:
        return false;
    L9:
        r6 = 0;
        goto L10
    }

    public static byte W(String r0) {
        return Byte.parseByte(r0);
    }

    @SuppressLint({"NewApi"})
    public static boolean X(Context r3) {
        if (r3 != null) goto L6;
        return true;
    L6:
        if (f7151c != null) goto L25;
        f7151c = (WifiManager) g(r3, "wifi");
    L25:
    L16:
        boolean r4 = false;
    L17:
        u4.d();
    L18:
        if (r4 == false) goto L20;
        return r4;
    L20:
        if (J() <= 17) goto L31;
        return "true".equals(String.valueOf(w4.c(f7151c, "isScanAlwaysAvailable", new Object[0])));
    L32:
        return r4;
    L31:
        return r4;
    L10:
        if (M(r3, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF") == false) goto L12;
        r4 = f7151c.isWifiEnabled();     // Catch: Throwable -> L16
    L26:
        u4.c();     // Catch: Throwable -> L24
    L12:
        s4.h(new Exception("n_aws"), "OPENSDK_UTS", "iwfal_n_aws");     // Catch: Throwable -> L16
        r4 = false;
        goto L26
    }

    public static String Y(Context r4) {
        NetworkInfo r5 = K(r4);
        if (r5 != null) goto L5;
        return "DISCONNECTED";
    L5:
        if (r5.isConnectedOrConnecting() == false) goto L38;
        int r0 = r5.getType();
        if (r0 != 1) goto L10;
        return "WIFI";
    L10:
        if (r0 != 0) goto L26;
        String r1 = r5.getSubtypeName();
        switch(r5.getSubtype()) {
            case 1: goto L33;
            case 2: goto L33;
            case 3: goto L31;
            case 4: goto L33;
            case 5: goto L31;
            case 6: goto L31;
            case 7: goto L33;
            case 8: goto L31;
            case 9: goto L31;
            case 10: goto L31;
            case 11: goto L33;
            case 12: goto L31;
            case 13: goto L16;
            case 14: goto L31;
            case 15: goto L31;
            case 16: goto L33;
            case 17: goto L31;
            default: goto L14;
        };
    L16:
        return "4G";
    L31:
        return "3G";
    L14:
        if ("GSM".equalsIgnoreCase(r1) == true) goto L33;
        if ("TD-SCDMA".equalsIgnoreCase(r1) == false) goto L21;
        return "3G";
    L21:
        if ("WCDMA".equalsIgnoreCase(r1) == false) goto L23;
        return "3G";
    L23:
        if ("CDMA2000".equalsIgnoreCase(r1) == false) goto L36;
        return "3G";
    L36:
        return r1;
    L33:
        return "2G";
    L26:
        return "UNKNOWN";
    L38:
        return "DISCONNECTED";
    }

    private static boolean Z(String r3) {
        String r1 = Build.MANUFACTURER;     // Catch: Throwable -> L8
        String r2 = Build.BRAND;     // Catch: Throwable -> L8
        if (r1.equalsIgnoreCase(r3) == true) goto L13;
        if (r2.toLowerCase().contains(r3) == true) goto L13;
        return false;
    L13:
        return true;
    L8:
        u4.c();
        return false;
    }

    public static double a(double r0) {
        return y(r0);
    }

    public static String a0(Context r3) {
        String r0 = l5.I();
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L6:
        r0 = z4.e(r3);
    L8:
        if (TextUtils.isEmpty(r0) == false) goto L11;
        return "00:00:00:00:00:00";
    L11:
        return r0;
    L5:
        if (r0.equals("00:00:00:00:00:00") == false) goto L8;
        goto L6
    }

    public static float b(float r4) {
        return (float) (((long) (((double) r4) * 100.0d)) / 100.0d);
    }

    public static boolean b0(Context r2) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return false;
    L5:
        if (r2.getApplicationInfo().targetSdkVersion < 28) goto L10;
        return true;
    L10:
        return false;
    }

    public static float c(AMapLocation r4, AMapLocation r5) {
        return d(new double[]{r4.getLatitude(), r4.getLongitude(), r5.getLatitude(), r5.getLongitude()});
    }

    public static boolean c0(Context r2) {
        ComponentName r0 = new ComponentName(r2, "com.amap.api.location.APSService");     // Catch: Throwable -> L4
        ServiceInfo r3 = r2.getPackageManager().getServiceInfo(r0, 128);     // Catch: Throwable -> L4
    L5:
        if (r3 != null) goto L8;
        return false;
    L8:
        return true;
    L4:
        r3 = null;
        goto L5
    }

    public static float d(double[] r12) {
        float[] r10 = new float[1];
        Location.distanceBetween(r12[0], r12[1], r12[2], r12[3], r10);
        return r10[0];
    }

    public static String d0(Context r1) {
        if (f7152d != null) goto L6;
        f7152d = h4.b("MD5", i5.g(r1));
    L6:
        return f7152d;
    }

    public static int e(NetworkInfo r2) {
        if (r2 != null) goto L6;
        return -1;
    L6:
        if (r2.isAvailable() == true) goto L9;
        return -1;
    L9:
        if (r2.isConnected() == true) goto L12;
        return -1;
    L12:
        return r2.getType();
    }

    public static boolean e0(Context r2) {
    L10:
        u4.c();
        return false;
    L4:
        if (h0(r2) == true) goto L15;
        if (g0(r2) == true) goto L15;
        if (f0(r2) == true) goto L15;
        return false;
    L15:
        return true;
    }

    public static long f() {
        return System.currentTimeMillis();
    }

    private static boolean f0(Context r1) {
        if (Z("huawei") == true) goto L5;
        return false;
    L5:
        if (i0(r1) == true) goto L7;
        return false;
    L7:
        if (k0(r1) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public static Object g(Context r2, String r3) {
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.getApplicationContext().getSystemService(r3);
    L7:
        th = move-exception;
        s4.h(th, "Utils", "getServ");
        return null;
    }

    private static boolean g0(Context r1) {
        if (Z("vivo") == true) goto L5;
        return false;
    L5:
        if (i0(r1) == true) goto L7;
        return false;
    L7:
        if (j0(r1) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public static String h(int r2) {
        if (r2 == 33) goto L25;
        switch(r2) {
            case 0: goto L24;
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L27;
            case 9: goto L16;
            case 10: goto L15;
            case 11: goto L14;
            case 12: goto L13;
            case 13: goto L12;
            case 14: goto L11;
            case 15: goto L10;
            default: goto L5;
        };
    L5:
        switch(r2) {
            case 18: goto L9;
            case 19: goto L8;
            case 20: goto L7;
            default: goto L46;
        };
    L7:
        return "模糊定位失败，具体可查看错误信息/详细信息描述";
    L8:
        return "定位失败，没有检查到SIM卡，并且关闭了WIFI开关，请打开WIFI开关或者插入SIM卡";
    L9:
        return "定位失败，飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关";
    L46:
        return "其他错误";
    L10:
        return "当前返回位置为模拟软件返回，请关闭模拟软件，或者在option中设置允许模拟";
    L11:
        return "GPS 定位失败，由于设备当前 GPS 状态差,建议持设备到相对开阔的露天场所再次尝试";
    L12:
        return "网络定位失败，请检查设备是否插入sim卡，是否开启移动网络或开启了wifi模块";
    L13:
        return "缺少定位权限";
    L14:
        return "错误的基站信息，请检查是否插入SIM卡";
    L15:
        return "定位服务启动失败";
    L16:
        return "初始化异常";
    L17:
        return "KEY错误";
    L18:
        return "定位结果错误";
    L19:
        return "解析数据异常";
    L20:
        return "网络连接异常";
    L21:
        return "请求参数获取出现异常";
    L22:
        return "WIFI信息不足";
    L23:
        return "重要参数为空";
    L24:
        return "success";
    L27:
        return "其他错误";
    L25:
        return "补偿定位失败，未命中缓存";
    }

    private static boolean h0(Context r3) {
    L11:
        u4.c();
        return false;
    L4:
        if (Build.VERSION.SDK_INT < 31) goto L15;
        if (r3 != null) goto L7;
        return false;
    L7:
        if (r3.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) goto L17;
        if (r3.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) goto L19;
        return false;
    L19:
        return true;
    L17:
        return false;
    L15:
        return false;
    }

    public static String i(long r4, String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        r6 = "yyyy-MM-dd HH:mm:ss";
    L5:
        SimpleDateFormat r0 = null;
        SimpleDateFormat r1 = new SimpleDateFormat(r6, Locale.CHINA);     // Catch: Throwable -> L11
        r1.applyPattern(r6);     // Catch: Throwable -> L9
    L14:
        if (r4 > 0) goto L16;
        r4 = f();
    L16:
        if (r1 != null) goto L20;
        return "NULL";
    L20:
        return r1.format(Long.valueOf(r4));
    L9:
        th = th;
        r0 = r1;
    L12:
        s4.h(th, "Utils", "formatUTC");
        r1 = r0;
    L11:
        th = th;
        goto L12
    }

    private static boolean i0(Context r8) {
        int r1 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L31
        int r9 = r8.getApplicationInfo().targetSdkVersion;     // Catch: Throwable -> L31
        if (r1 != 30) goto L7;
        boolean r4 = true;
    L9:
        if (r9 < 23) goto L11;
        boolean r6 = true;
    L13:
        if (r1 != 31) goto L15;
        boolean r2 = true;
    L16:
        if (r9 > 30) goto L19;
        if (r9 < 23) goto L19;
        boolean r10 = true;
    L20:
        if (r4 == false) goto L23;
        if (r6 == false) goto L23;
        boolean r3 = true;
    L24:
        if (r2 == false) goto L27;
        if (r10 == false) goto L27;
        boolean r11 = true;
    L28:
        if (r3 == true) goto L36;
        if (r11 == true) goto L36;
        return false;
    L36:
        return true;
    L27:
        r11 = false;
    L23:
        r3 = false;
    L19:
        r10 = false;
        goto L20
    L15:
        r2 = false;
        goto L16
    L11:
        r6 = false;
        goto L13
    L7:
        r4 = false;
    L31:
        u4.c();
        return false;
    }

    public static String j(ConnectivityManager r1) {
        int r0 = 0;
        if (r1 != null) goto L42;
    L8:
        switch(r0) {
            case 1: goto L39;
            case 2: goto L37;
            case 3: goto L35;
            case 4: goto L33;
            case 5: goto L31;
            case 6: goto L29;
            case 7: goto L27;
            case 8: goto L25;
            case 9: goto L23;
            case 10: goto L21;
            case 11: goto L19;
            case 12: goto L17;
            case 13: goto L15;
            case 14: goto L13;
            case 15: goto L11;
            default: goto L9;
        };
    L9:
        return "UNKWN";
    L11:
        return "HSPAP";
    L13:
        return "EHRPD";
    L15:
        return "LTE";
    L17:
        return "EVDO_B";
    L19:
        return "IDEN";
    L21:
        return "HSPA";
    L23:
        return "HSUPA";
    L25:
        return "HSDPA";
    L27:
        return "1xRTT";
    L29:
        return "EVDO_A";
    L31:
        return "EVDO_0";
    L33:
        return "CDMA";
    L35:
        return "UMTS";
    L37:
        return "EDGE";
    L39:
        return "GPRS";
    L42:
        NetworkInfo r2 = r1.getActiveNetworkInfo();     // Catch: Throwable -> L41
        if (r2 == null) goto L8;
        r0 = r2.getSubtype();     // Catch: Throwable -> L41
        goto L8
    }

    private static boolean j0(Context r8) {
        boolean r0 = false;
        Cursor r1 = r8.getContentResolver().query(Uri.parse("content://com.vivo.permissionmanager.provider.permission/fuzzy_location_apps"), new String[]{"package_name", "selected_fuzzy"}, "package_name=?", new String[]{r8.getPackageName()}, null);     // Catch: Throwable -> L17
        boolean r2 = false;
    L5:
        if (r1 == null) goto L14;
    L13:
        r0 = r2;
    L29:
        u4.c();     // Catch: Throwable -> L22
        if (r1 == null) goto L21;
        r1.close();
    L21:
        return r0;
    L22:
        if (r1 == null) goto L24;
        r1.close();
    L24:
        return r0;
    L7:
        if (r1.moveToNext() == false) goto L14;
        if (r1.getString(0) == null) goto L5;
        if (r1.getInt(1) != 1) goto L5;
        r2 = true;
    L14:
        if (r1 == null) goto L16;
        r1.close();
    L16:
        return r2;
    L17:
        r1 = null;
        goto L29
    }

    public static List<String> k(File r4) {
        ArrayList r0 = new ArrayList();
        BufferedReader r1 = null;
        FileInputStream r5 = B(r4);     // Catch: Throwable -> L13
        InputStreamReader r2 = new InputStreamReader(r5, Charset.defaultCharset());     // Catch: Throwable -> L12
        BufferedReader r3 = new BufferedReader(r2);     // Catch: Throwable -> L25
    L31:
        String r6 = r3.readLine();     // Catch: Throwable -> L11
        if (r6 == null) goto L10;
        r0.add(r6);     // Catch: Throwable -> L11
        goto L31
    L10:
        r3.close();     // Catch: IOException -> L16
        r2.close();     // Catch: IOException -> L16
        r5.close();     // Catch: IOException -> L16
    L24:
        return r0;
    L11:
        r1 = r3;
    L14:
        if (r1 == null) goto L18;
        r1.close();     // Catch: IOException -> L16
    L18:
        if (r2 == null) goto L20;
        r2.close();     // Catch: IOException -> L16
    L20:
        if (r5 == null) goto L24;
        r5.close();     // Catch: IOException -> L16
    L12:
        r2 = null;
    L13:
        r5 = null;
        r2 = null;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L24
    }

    private static boolean k0(Context r5) {
    L15:
        u4.c();     // Catch: Throwable -> L17
        goto L16
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L10;
        if (r5 != null) goto L8;
        return false;
    L8:
        if (r5.checkSelfPermission("com.huawei.permission.ACCESS_APPROXIMATELY_LOCATION") == 0) goto L21;
        return false;
    L21:
        return true;
    L10:
        if (r5 != null) goto L12;
        return false;
    L12:
        if (r5.checkCallingOrSelfPermission("com.huawei.permission.ACCESS_APPROXIMATELY_LOCATION") == 0) goto L21;
        return false;
    L16:
        return false;
    }

    public static void l(File r1, String r2) {
        FileOutputStream r0 = null;
        r0 = L(r1);     // Catch: Throwable -> L11 IOException -> L13
        if (r2 == null) goto L32;
        r0.write(r2.getBytes());     // Catch: Throwable -> L11 IOException -> L13
    L32:
        r0.close();     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        if (r0 == null) goto L36;
        r0.close();     // Catch: IOException -> L18
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    L36:
        return;
    L11:
        th = move-exception;
        if (r0 != null) goto L34;
    L26:
        throw th;
    L34:
        r0.close();     // Catch: IOException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L26
    }

    public static boolean m(Context r3) {
        if (r3 != null) goto L12;
        return false;
    L12:
    L11:
        return false;
    L6:
        if (J() >= 17) goto L10;
        return Q(r3, "android.provider.Settings$System");
    L10:
        return Q(r3, "android.provider.Settings$Global");
    }

    public static boolean n(SQLiteDatabase r13, String r14) {
        boolean r1 = false;
        if (TextUtils.isEmpty(r14) == false) goto L5;
        return false;
    L5:
        String r0 = "2.0.201501131131".replace(".", "");
        Cursor r2 = null;
        if (r13 != null) goto L25;
    L24:
        return false;
    L25:
    L21:
        if (r2 == null) goto L28;
        r2.close();
        return true;
    L28:
        return true;
    L9:
        if (r13.isOpen() == false) goto L24;
        r2 = r13.query("sqlite_master", new String[]{"count(*) as c"}, "type = 'table' AND name = '" + r14.trim() + r0 + "'", null, null, null, null);     // Catch: Throwable -> L21
        if (r2 != null) goto L14;
    L18:
        if (r2 == null) goto L27;
        r2.close();
    L27:
        return r1;
    L14:
        if (r2.moveToFirst() == false) goto L18;
        if (r2.getInt(0) <= 0) goto L18;
        r1 = true;
        goto L18
    }

    public static boolean o(Location r7, int r8) {
        if (Build.VERSION.SDK_INT >= 18) goto L32;
    L8:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L12;
        return true;
    L12:
        Bundle r2 = r7.getExtras();     // Catch: Throwable -> L29
        if (r2 == null) goto L15;
        int r3 = r2.getInt("satellites");     // Catch: Throwable -> L29
    L16:
        if (r3 > 0) goto L18;
        return true;
    L18:
        if (r8 != 0) goto L27;
        if (r7.getAltitude() != 0.0d) goto L27;
        if (r7.getBearing() != 0.0f) goto L27;
        if (r7.getSpeed() != 0.0f) goto L27;
        return true;
    L15:
        r3 = 0;
        goto L16
    L32:
        r1 = r7.isFromMockProvider();     // Catch: Throwable -> L28
    L27:
        return false;
    }

    public static boolean p(AMapLocation r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.U() == 0) goto L9;
        return false;
    L9:
        return F(r2);
    }

    public static boolean q(ew r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if ("8".equals(r3.h1()) == false) goto L9;
        return false;
    L9:
        if ("5".equals(r3.h1()) == false) goto L12;
        return false;
    L12:
        if ("6".equals(r3.h1()) == false) goto L15;
        return false;
    L15:
        return F(r3);
    }

    public static boolean r(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        if ("00:00:00:00:00:00".equals(r2) == false) goto L8;
        return false;
    L8:
        if ("02:00:00:00:00:00".equals(r2) == false) goto L11;
        return false;
    L11:
        if (r2.contains(" :") == true) goto L18;
        return true;
    L18:
        return false;
    }

    public static boolean s(String r6, String r7) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
    L22:
        return false;
    L5:
        if (TextUtils.isEmpty(r7) == true) goto L22;
        ArrayList<String> r8 = D(r6);
        String[] r9 = r7.toString().split("#");
        int r0 = 0;
        int r2 = 0;
        int r3 = 0;
    L9:
        if (r0 >= r9.length) goto L19;
        if (r9[r0].contains(",nb") == false) goto L13;
    L14:
        r2 = r2 + 1;
        if (r8.contains(r9[r0]) == false) goto L17;
        r3 = r3 + 1;
    L17:
        r0 = r0 + 1;
        goto L9
    L13:
        if (r9[r0].contains(",access") == false) goto L17;
    L19:
        if ((r3 * 2) < (((double) (r8.size() + r2)) * 0.618d)) goto L22;
        return true;
    }

    public static boolean t(JSONObject r0, String r1) {
        return u5.m(r0, r1);
    }

    public static byte[] u(int r2, byte[] r3) {
        if (r3 != null) goto L5;
    L6:
        r3 = new byte[2];
    L7:
        r3[0] = (byte) (r2 & 255);
        r3[1] = (byte) ((r2 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
        return r3;
    L5:
        if (r3.length >= 2) goto L7;
        goto L6
    }

    public static byte[] v(long r7) {
        byte[] r1 = new byte[8];
        int r2 = 0;
    L3:
        if (r2 >= 8) goto L5;
        r1[r2] = (byte) ((r7 >> (r2 * 8)) & 255);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public static byte[] w(byte[] r0) {
        return u5.t(r0);
    }

    public static String[] x(TelephonyManager r8) {
        if (r8 == null) goto L4;
        String r9 = r8.getNetworkOperator();
    L5:
        String[] r1 = {BDLocationException.ERROR_TIMEOUT, BDLocationException.ERROR_TIMEOUT};
        if (TextUtils.isEmpty(r9) == false) goto L9;
    L7:
        boolean r2 = false;
    L15:
        if (r2 == false) goto L42;
        r1[0] = r9.substring(0, 3);
        char[] r5 = r9.substring(3).toCharArray();
        int r6 = 0;
    L18:
        if (r6 >= r5.length) goto L22;
        if (Character.isDigit(r5[r6]) == false) goto L22;
        r6 = r6 + 1;
    L22:
        r1[1] = r9.substring(3, r6 + 3);
    L42:
        int r10 = Integer.parseInt(r1[0]);     // Catch: Throwable -> L25
    L27:
        if (r10 != 0) goto L30;
        r1[0] = BDLocationException.ERROR_TIMEOUT;
    L30:
        if (BDLocationException.ERROR_TIMEOUT.equals(r1[0]) == true) goto L35;
        if (BDLocationException.ERROR_TIMEOUT.equals(r1[1]) == true) goto L35;
        f7150b = r1;
        return r1;
    L35:
        if (BDLocationException.ERROR_TIMEOUT.equals(r1[0]) == true) goto L37;
        return r1;
    L37:
        if (BDLocationException.ERROR_TIMEOUT.equals(r1[1]) == false) goto L48;
        String[] r11 = f7150b;
        if (r11 != null) goto L41;
        return r1;
    L41:
        return r11;
    L48:
        return r1;
    L25:
        th = move-exception;
        s4.h(th, "Utils", "getMccMnc");
        r10 = 0;
        goto L27
    L9:
        if (TextUtils.isDigitsOnly(r9) == false) goto L7;
        if (r9.length() <= 4) goto L7;
        r2 = true;
        goto L15
    L4:
        r9 = null;
        goto L5
    }

    public static double y(double r2) {
        return ((long) (r2 * 1000000.0d)) / 1000000.0d;
    }

    public static int z(byte[] r4) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= 2) goto L6;
        r1 = r1 | ((r4[r0] & 255) << ((1 - r0) * 8));
        r0 = r0 + 1;
        goto L4
    L6:
        return r1;
    }
}
