package com.bytedance.bdinstall;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class Utils {
    private static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    public static final int MAX_UDID_LENGTH = 128;
    public static final int MIN_UDID_LENGTH = 13;
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final String PARAMETER_SEPARATOR = "&";
    private static volatile Boolean isMainProcess;
    private static String sProcessName;

    public Utils() {
    }

    static String getProcessName(Context r3) {
        String r0 = sProcessName;
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        String r1 = Application.getProcessName();
        if (TextUtils.isEmpty(r1) == true) goto L9;
        sProcessName = r1;
        return r1;
    L9:
        String r2 = getCurrentProcessNameByActivityThread();
        if (TextUtils.isEmpty(r2) == true) goto L27;
        sProcessName = r2;
        return r2;
    L27:
        int r4 = Process.myPid();     // Catch: Exception -> L20
        Iterator<ActivityManager.RunningAppProcessInfo> r5 = ((ActivityManager) r3.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L20
    L15:
        if (r5.hasNext() == false) goto L22;
        ActivityManager.RunningAppProcessInfo r6 = r5.next();     // Catch: Exception -> L20
        if (r6.pid != r4) goto L15;
        sProcessName = r6.processName;     // Catch: Exception -> L20
    L22:
        sProcessName = getProcessNameFromProc();
        if (DrLog.debug() == false) goto L26;
        DrLog.d("getProcessName, " + sProcessName);
    L26:
        return sProcessName;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }

    public static String getCurrentProcessNameByActivityThread() {
        Method r1 = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L8
        r1.setAccessible(true);     // Catch: Throwable -> L8
        Object r2 = r1.invoke(null, new Object[0]);     // Catch: Throwable -> L8
        if ((r2 instanceof String) == false) goto L11;
        return (String) r2;
    L11:
        return null;
    L12:
        return null;
    }

    public static boolean isMainProcess(Context r1) {
        if (isMainProcess != null) goto L9;
        if (r1 == null) goto L7;
        isMainProcess = Boolean.valueOf(TextUtils.equals(getProcessName(r1), r1.getPackageName()));
        goto L9
    L7:
        throw new NullPointerException("context is null");
    L9:
        return isMainProcess.booleanValue();
    }

    public static boolean isValidUDID(String r5) {
        if (r5 == null) goto L5;
        int r1 = r5.length();
    L7:
        if (r1 >= 13) goto L9;
    L31:
        return false;
    L9:
        if (r1 > 128) goto L31;
        int r2 = 0;
    L12:
        if (r2 >= r1) goto L29;
        char r3 = r5.charAt(r2);
        if (r3 < '0') goto L18;
        if (r3 > '9') goto L18;
    L27:
        r2 = r2 + 1;
    L18:
        if (r3 < 'a') goto L22;
        if (r3 <= 'f') goto L27;
    L22:
        if (r3 < 'A') goto L26;
        if (r3 <= 'F') goto L27;
    L26:
        if (r3 == '-') goto L27;
        return false;
    L29:
        return true;
    L5:
        r1 = 0;
        goto L7
    }

    private static String getProcessNameFromProc() {
        BufferedReader r2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L11
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L16
    L5:
        int r3 = r2.read();     // Catch: Throwable -> L16
        if (r3 <= 0) goto L8;
        r0.append((char) r3);     // Catch: Throwable -> L16
        goto L5
    L8:
        String r1 = r0.toString();     // Catch: Throwable -> L16
        r2.close();     // Catch: Exception -> L15
    L10:
        return r1;
    L12:
        if (r2 != null) goto L22;
    L14:
        return null;
    L22:
        r2.close();     // Catch: Exception -> L17
    L11:
        r2 = null;
        goto L12
    }

    public static void copy(JSONObject r3, JSONObject r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r4 != null) goto L14;
        return;
    L14:
        Iterator<String> r0 = r4.keys();     // Catch: JSONException -> L11
    L8:
        if (r0.hasNext() == false) goto L18;
        String r1 = r0.next();     // Catch: JSONException -> L11
        r3.put(r1, r4.opt(r1));     // Catch: JSONException -> L11
        goto L8
    L18:
        return;
    L11:
        e = move-exception;
        DrLog.ysnp(e);
    }

    static String format(HashMap<String, String> r4, String r5) {
        StringBuilder r0 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r6 = r4.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L14;
        Map.Entry<String, String> r1 = r6.next();
        String r2 = encode(r1.getKey(), r5);
        String r3 = r1.getValue();
        if (r3 == null) goto L8;
        String r7 = encode(r3, r5);
    L10:
        if (r0.length() <= 0) goto L12;
        r0.append(PARAMETER_SEPARATOR);
    L12:
        r0.append(r2);
        r0.append(NAME_VALUE_SEPARATOR);
        r0.append(r7);
        goto L4
    L8:
        r7 = "";
        goto L10
    L14:
        return r0.toString();
    }

    private static String encode(String r0, String r1) {
        if (r1 != null) goto L9;
        r1 = "ISO-8859-1";
    L9:
        return URLEncoder.encode(r0, r1);
    L7:
        return "";
    }

    public static boolean equal(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == true) goto L5;
    L6:
        if (r1 != null) goto L8;
    L10:
        return false;
    L8:
        if (r1.equals(r2) == false) goto L10;
    L9:
        return true;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L9;
        goto L6
    }

    public static void putStringIfNotEmpty(JSONObject r1, String r2, String r3) throws JSONException {
        if (TextUtils.isEmpty(r3) == true) goto L6;
        r1.put(r2, r3);
        return;
    }

    public static boolean isBadId(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return true;
    L6:
        if (r5.equalsIgnoreCase(EnvironmentCompat.MEDIA_UNKNOWN) == false) goto L9;
        return true;
    L9:
        if (r5.equalsIgnoreCase("None") == false) goto L11;
        return true;
    L11:
        int r2 = 0;
    L13:
        if (r2 >= r5.length()) goto L21;
        if (r5.charAt(r2) != '0') goto L18;
        r2 = r2 + 1;
        goto L13
    L18:
        return false;
    L21:
        return true;
    }

    public static boolean checkId(String r5) {
        boolean r1 = false;
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L18:
        return false;
    L5:
        if (EnvironmentCompat.MEDIA_UNKNOWN.equalsIgnoreCase(r5) == true) goto L18;
        if ("Null".equalsIgnoreCase(r5) == true) goto L18;
        int r0 = 0;
    L10:
        if (r0 >= r5.length()) goto L15;
        if (r5.charAt(r0) != '0') goto L17;
        r0 = r0 + 1;
    L17:
        return !r1;
    L15:
        r1 = true;
        goto L17
    }

    public static void removeSpValues(SharedPreferences r6, String[] r7) {
        SharedPreferences.Editor r0 = r6.edit();
        int r1 = r7.length;
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 >= r1) goto L8;
        String r4 = r7[r2];
        if (r6.contains(r4) == false) goto L7;
        r0.remove(r4);
        r3 = true;
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        if (r3 == false) goto L14;
        r0.apply();
        return;
    }

    static void setIsMainProcess(boolean r0) {
        isMainProcess = Boolean.valueOf(r0);
    }

    public static void closeSafely(Closeable r0) {
        if (r0 == null) goto L10;
        r0.close();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    static Context getApp(Context r1) {
        if ((r1 instanceof Application) == true) goto L7;
        if (r1 != null) goto L6;
        return r1;
    L6:
        return r1.getApplicationContext();
    L7:
        return r1;
    }
}
