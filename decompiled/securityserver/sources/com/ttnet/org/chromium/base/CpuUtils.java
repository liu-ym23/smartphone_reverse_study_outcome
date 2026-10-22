package com.ttnet.org.chromium.base;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;

/* JADX INFO: loaded from: classes2.dex */
public class CpuUtils {
    private static final FileFilter CPU_FILTER = null;
    private static String TAG = "CpuUtils";
    private static int sCpuCores = 0;
    private static final Object sCpuCoresLock = null;
    private static String sCpuDirectory = "/sys/devices/system/cpu/";
    private static String sCpuInfoPath = "/proc/cpuinfo";
    private static String sCpuModelTitle = "Hardware";
    private static String sCpuPossiblePath = "/sys/devices/system/cpu/possible";
    private static String sCpuPresentPath = "/sys/devices/system/cpu/present";
    private static String sCpuVendorTag = "vendor";
    private static boolean sInitialized = false;
    private static String sModel = "unknown";
    private static final Object sModelLock = null;

    static {
        sModelLock = new Object();
        sCpuCoresLock = new Object();
        CPU_FILTER = new a();
    }

    public CpuUtils() {
    }

    public static /* synthetic */ boolean a(File r0) {
        return lambda$static$0(r0);
    }

    private static boolean fetchCPUCores() {
        if (fetchCoresFromFile(sCpuPossiblePath) == false) goto L5;
        return true;
    L5:
        if (fetchCoresFromFile(sCpuPresentPath) == false) goto L7;
        return true;
    L7:
        if (fetchCoresFromFileList() == true) goto L14;
        return false;
    L14:
        return true;
    }

    private static boolean fetchCPUModel() {
        String r0 = null;
        FileReader r1 = new FileReader(sCpuInfoPath);     // Catch: Throwable -> L36 Exception -> L38
        BufferedReader r2 = new BufferedReader(r1);     // Catch: Throwable -> L32 Exception -> L34
    L80:
        String r3 = r2.readLine();     // Catch: Throwable -> L12 Exception -> L14
        if (r3 == null) goto L16;
        if (r3.contains(sCpuModelTitle) == false) goto L80;
        if (r3.contains(":") == false) goto L80;
        r0 = r3.substring(r3.indexOf(58) + 1).trim();     // Catch: Throwable -> L12 Exception -> L14
    L16:
        if (r0 != null) goto L18;
    L20:
        if (r0 == null) goto L89;
        Object r4 = sModelLock;
        monitor-enter(r4);
        sModel = r0;     // Catch: Throwable -> L26
        monitor-exit(r4);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L89:
        r2.close();     // Catch: Exception -> L70
    L78:
        r1.close();     // Catch: Exception -> L71
    L31:
        return true;
    L18:
        if (r0.contains(sCpuVendorTag) == false) goto L20;
        r0 = r0.substring((r0.indexOf(sCpuVendorTag) + sCpuVendorTag.length()) + 1).trim();     // Catch: Throwable -> L12 Exception -> L14
    L14:
        e = e;
    L40:
        android.util.Log.w(TAG, "Cannot get CPU model from " + sCpuInfoPath, e);     // Catch: Throwable -> L12
        if (0 == 0) goto L50;
        Object r5 = sModelLock;
        monitor-enter(r5);
        sModel = null;     // Catch: Throwable -> L47
        monitor-exit(r5);     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        throw th;
    L50:
        if (r2 != null) goto L95;
    L52:
        if (r1 == null) goto L109;
        r1.close();     // Catch: Exception -> L75
        return false;
    L110:
        return false;
    L109:
        return false;
    L95:
        r2.close();     // Catch: Exception -> L74
    L12:
        th = th;
    L56:
        if (0 == 0) goto L65;
        Object r6 = sModelLock;
        monitor-enter(r6);
        sModel = null;     // Catch: Throwable -> L62
        monitor-exit(r6);     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        throw th;
    L65:
        if (r2 != null) goto L87;
    L67:
        if (r1 == null) goto L107;
        r1.close();     // Catch: Exception -> L73
        throw th;
    L108:
        throw th;
    L107:
        throw th;
    L87:
        r2.close();     // Catch: Exception -> L72
        goto L67
    L34:
        e = e;
        r2 = null;
    L32:
        th = th;
        r2 = null;
        goto L56
    L38:
        e = e;
        r1 = null;
        r2 = null;
    L36:
        th = th;
        r1 = null;
        r2 = null;
        goto L56
    }

    private static boolean fetchCoresFromFile(String r6) {
        BufferedReader r0 = null;
        FileReader r1 = new FileReader(r6);     // Catch: Throwable -> L29 Exception -> L31
        BufferedReader r7 = new BufferedReader(r1);     // Catch: Throwable -> L27 Exception -> L47
        goto L37
    L66:
        String r2 = r7.readLine();     // Catch: Throwable -> L11 Exception -> L13
        if (TextUtils.isEmpty(r2) == false) goto L8;
    L14:
        int r3 = -1;
    L15:
        if (r3 == (-1)) goto L52;
        Object r4 = sCpuCoresLock;
        monitor-enter(r4);
        sCpuCores = r3;     // Catch: Throwable -> L21
        monitor-exit(r4);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    L52:
        r7.close();     // Catch: Exception -> L43
    L62:
        r1.close();     // Catch: Exception -> L44
    L26:
        return true;
    L8:
        if (r2.startsWith("0-") == false) goto L14;
        r3 = getFirstInteger(r2.substring(2)) + 1;
        goto L15
    L13:
        r0 = r7;
    L11:
        Throwable th = th;
    L32:
        if (r7 != null) goto L60;
    L34:
        if (r1 == null) goto L70;
        r1.close();     // Catch: Exception -> L46
        throw th;
    L71:
        throw th;
    L70:
        throw th;
    L60:
        r7.close();     // Catch: Exception -> L45
    L27:
        th = move-exception;
        th = th;
        r7 = null;
    L37:
        if (r0 != null) goto L50;
    L39:
        if (r1 == null) goto L72;
        r1.close();     // Catch: Exception -> L49
        return false;
    L73:
        return false;
    L72:
        return false;
    L50:
        r0.close();     // Catch: Exception -> L48
        goto L39
    L31:
        r1 = null;
    L29:
        th = move-exception;
        r1 = null;
        th = th;
        r7 = null;
        goto L32
    }

    private static boolean fetchCoresFromFileList() {
        File[] r0 = new File(sCpuDirectory).listFiles(CPU_FILTER);
        if (r0 == null) goto L13;
        Object r1 = sCpuCoresLock;
        monitor-enter(r1);
        sCpuCores = r0.length;     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return true;
    L10:
        th = move-exception;
        throw th;
    L13:
        return false;
    }

    public static String getCPUCores() {
        Object r0 = sCpuCoresLock;
        monitor-enter(r0);
        String r1 = String.valueOf(sCpuCores);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static String getCPUModel() {
        Object r0 = sModelLock;
        monitor-enter(r0);
        String r1 = sModel;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private static int getFirstInteger(String r4) {
        if (TextUtils.isEmpty(r4) == true) goto L25;
        int r0 = 0;
    L6:
        if (r0 >= r4.length()) goto L17;
        if (Character.isDigit(r4.charAt(r0)) == true) goto L9;
        r0 = r0 + 1;
        goto L6
    L9:
        int r2 = r0 + 1;
    L11:
        if (r2 < r4.length()) goto L13;
    L21:
        return Integer.parseInt(r4.substring(r0, r2));
    L26:
        return 0;
    L13:
        if (Character.isDigit(r4.charAt(r2)) == false) goto L21;
        r2 = r2 + 1;
        goto L11
    L17:
        r0 = 0;
        r2 = 0;
        goto L21
    L25:
        return 0;
    }

    public static void initialize() {
        if (sInitialized == false) goto L6;
        return;
    L6:
        if (fetchCPUModel() == false) goto L8;
    L10:
        sInitialized = true;
        return;
    L8:
        if (fetchCPUCores() == true) goto L10;
    }

    private static /* synthetic */ boolean lambda$static$0(File r3) {
        String r4 = r3.getName();
        if (r4.startsWith("cpu") == false) goto L13;
        int r0 = 3;
    L6:
        if (r0 >= r4.length()) goto L11;
        if (Character.isDigit(r4.charAt(r0)) == false) goto L9;
        r0 = r0 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    L13:
        return false;
    }
}
