package com.bytedance.common.wschannel.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.UByte;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Utils {
    private static String sCurProcessName;

    static {
    }

    public Utils() {
    }

    public static String byte2HexStr(byte[] r1) {
        return byte2HexStr(r1, " ");
    }

    public static String byte2HexStr(byte[] r5, String r6) {
        StringBuilder r0 = new StringBuilder("");
        int r1 = 0;
    L4:
        if (r1 >= r5.length) goto L10;
        String r2 = Integer.toHexString(r5[r1] & UByte.MAX_VALUE);
        if (r2.length() != 1) goto L8;
        r2 = "0" + r2;
    L8:
        r0.append(r2);
        r0.append(r6);
        r1 = r1 + 1;
        goto L4
    L10:
        return r0.toString().toUpperCase().trim();
    }

    public static String md5(String r7) {
        if (TextUtils.isEmpty(r7) == false) goto L16;
        return "";
    L16:
        byte[] r8 = MessageDigest.getInstance("MD5").digest(r7.getBytes());     // Catch: NoSuchAlgorithmException -> L13
        StringBuilder r0 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L13
        int r2 = r8.length;     // Catch: NoSuchAlgorithmException -> L13
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L11;
        String r4 = Integer.toHexString(r8[r3] & UByte.MAX_VALUE);     // Catch: NoSuchAlgorithmException -> L13
        if (r4.length() != 1) goto L10;
        r4 = "0" + r4;     // Catch: NoSuchAlgorithmException -> L13
    L10:
        r0.append(r4);     // Catch: NoSuchAlgorithmException -> L13
        r3 = r3 + 1;     // Catch: NoSuchAlgorithmException -> L13
        goto L6
    L11:
        return r0.toString();
    L13:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static String getTimeFormat(long r2) {
        return DateFormat.getDateTimeInstance().format(new Date(r2));
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

    public static boolean isMainProcess(Context r2, String r3) {
        if (r3 != null) goto L5;
    L7:
        if (r3 != null) goto L9;
        return false;
    L9:
        if (r3.equals(r2.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r3.contains(":") == false) goto L7;
        return false;
    }

    public static String getCurProcessName(Context r2) {
        String r0 = sCurProcessName;
        if (StringUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        String r1 = getCurrentProcessNameFromApplication();
        sCurProcessName = r1;
        if (StringUtils.isEmpty(r1) == false) goto L8;
        String r3 = getCurrentProcessNameFromActivityThread();
        sCurProcessName = r3;
        if (StringUtils.isEmpty(r3) == false) goto L12;
        String r4 = getCurProcessNameFromProc();
        sCurProcessName = r4;
        if (StringUtils.isEmpty(r4) == false) goto L16;
        String r5 = getCurProcessNameFromActivityManager(r2);
        sCurProcessName = r5;
        return r5;
    L16:
        return sCurProcessName;
    L12:
        return sCurProcessName;
    L8:
        return sCurProcessName;
    }

    private static String getCurrentProcessNameFromApplication() {
        return Application.getProcessName();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private static String getCurrentProcessNameFromActivityThread() {
        Method r1 = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L7
        r1.setAccessible(true);     // Catch: Throwable -> L7
        Object r2 = r1.invoke(null, new Object[0]);     // Catch: Throwable -> L7
        if ((r2 instanceof String) == false) goto L12;
        return (String) r2;
    L12:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static String getCurProcessNameFromActivityManager(Context r6) {
        String r0 = null;
        if (r6 != null) goto L18;
        return null;
    L18:
        int r1 = Process.myPid();     // Catch: Exception -> L15
        Iterator<ActivityManager.RunningAppProcessInfo> r7 = ((ActivityManager) r6.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L15
    L6:
        if (r7.hasNext() == false) goto L17;
        ActivityManager.RunningAppProcessInfo r2 = r7.next();     // Catch: Exception -> L15
        if (r2.pid != r1) goto L6;
        if (Logger.debug() == false) goto L13;
        Logger.d("Process", "processName = " + r2.processName);     // Catch: Exception -> L15
    L13:
        r0 = r2.processName;     // Catch: Exception -> L15
    L17:
        return r0;
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

    public static boolean isMessageProcess(String r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (r1.endsWith(":push") == false) goto L6;
        return true;
    }

    public static boolean isServiceRunning(Context r3, Class<? extends Service> r4) {
        if (r3 == null) goto L20;
        if (r4 == null) goto L20;
        Iterator<ActivityManager.RunningServiceInfo> r5 = ((ActivityManager) r3.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();     // Catch: Exception -> L18
    L8:
        if (r5.hasNext() == false) goto L20;
        ActivityManager.RunningServiceInfo r1 = r5.next();     // Catch: Exception -> L18
        if (r1 == null) goto L8;
        if (r1.service == null) goto L8;
        if (TextUtils.equals(r4.getName(), r1.service.getClassName()) == false) goto L8;
        return true;
    L18:
        e = move-exception;
        e.printStackTrace();
    L20:
        return false;
    }

    public static JSONObject mapToJson(Map<String, String> r3) {
        JSONObject r0 = new JSONObject();
        if (r3 != null) goto L5;
    L17:
        return r0;
    L5:
        if (r3.isEmpty() == true) goto L17;
        Iterator<Map.Entry<String, String>> r4 = r3.entrySet().iterator();
    L9:
        if (r4.hasNext() == false) goto L17;
        Map.Entry<String, String> r1 = r4.next();
        if (TextUtils.isEmpty(r1.getKey()) == true) goto L9;
        r0.put(r1.getKey(), r1.getValue());     // Catch: JSONException -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public static Map<String, String> jsonToMap(JSONObject r4) {
        HashMap r0 = new HashMap();
        if (r4 != null) goto L5;
        return r0;
    L5:
        Iterator<String> r1 = r4.keys();
    L7:
        if (r1.hasNext() == false) goto L16;
        String r2 = r1.next();
        if (TextUtils.isEmpty(r2) == true) goto L7;
        Object r3 = r4.opt(r2);
        if (r3 != null) goto L14;
        String r5 = null;
    L15:
        r0.put(r2, r5);
        goto L7
    L14:
        r5 = r3.toString();
        goto L15
    L16:
        return r0;
    }

    public static String outputThrowableStackTrace(Throwable r3) {
        String r0 = null;
        if (r3 != null) goto L29;
        return null;
    L29:
        StringWriter r1 = new StringWriter();     // Catch: Throwable -> L15
        PrintWriter r2 = new PrintWriter(r1);     // Catch: Throwable -> L15
        r3.printStackTrace(r2);     // Catch: Throwable -> L13
        Throwable r4 = r3.getCause();     // Catch: Throwable -> L13
        if (r4 == null) goto L11;
        r4.printStackTrace(r2);     // Catch: Throwable -> L13
        Throwable r5 = r4.getCause();     // Catch: Throwable -> L13
        if (r5 == null) goto L11;
        r5.printStackTrace(r2);     // Catch: Throwable -> L13
    L11:
        r0 = r1.toString();     // Catch: Throwable -> L13
    L12:
        r2.close();
    L20:
        return r0;
    L13:
        th = th;
    L25:
        th.printStackTrace();     // Catch: Throwable -> L21
        if (r2 == null) goto L20;
    L21:
        th = move-exception;
        if (r2 == null) goto L24;
        r2.close();
    L24:
        throw th;
    L15:
        th = th;
        r2 = null;
        goto L25
    }
}
