package com.ttnet.org.chromium.base;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class TTProcessUtils {
    public static final String MESSAGE_PROCESS_SERVICE_SUFFIX = ":pushservice";
    public static final String MESSAGE_PROCESS_SUFFIX = ":push";
    private static volatile String sCurProcessName;

    public TTProcessUtils() {
    }

    public static boolean isMessageProcess(Context r1) {
        String r2 = getCurProcessName(r1);
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.endsWith(":push") == false) goto L7;
        return true;
    L7:
        if (r2.endsWith(":pushservice") == false) goto L13;
        return true;
    L13:
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

    public static String getCurProcessName(Context r1) {
        if (TextUtils.isEmpty(sCurProcessName) == false) goto L5;
        sCurProcessName = getCurrentProcessNameFromApplication();
        if (TextUtils.isEmpty(sCurProcessName) == false) goto L9;
        sCurProcessName = getCurrentProcessNameFromActivityThread();
        if (TextUtils.isEmpty(sCurProcessName) == false) goto L13;
        sCurProcessName = getCurProcessNameFromProc();
        if (TextUtils.isEmpty(sCurProcessName) == false) goto L17;
        sCurProcessName = getCurProcessNameFromActivityManager(r1);
        return sCurProcessName;
    L17:
        return sCurProcessName;
    L13:
        return sCurProcessName;
    L9:
        return sCurProcessName;
    L5:
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
}
