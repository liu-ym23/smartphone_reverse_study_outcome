package com.ttnet.org.chromium.base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class MemoryUtils {
    private static String TAG = "MemoryUtils";
    private static boolean sInitialized = false;
    private static String sMemoryInfoPath = "/proc/meminfo";
    private static final Object sMemoryLock = null;
    private static String sTotalMemoryGB = "unknown";

    static {
        sMemoryLock = new Object();
    }

    public MemoryUtils() {
    }

    private static void fetchTotalMemory() {
        Pattern r0 = Pattern.compile("^MemTotal:\\s+([0-9]+) kB$");
        BufferedReader r5 = null;
        long r6 = 0;
        FileReader r8 = new FileReader(sMemoryInfoPath);     // Catch: Throwable -> L38 Exception -> L40
        BufferedReader r9 = new BufferedReader(r8);     // Catch: Throwable -> L34 Exception -> L36
    L89:
        String r7 = r9.readLine();     // Catch: Throwable -> L20 Exception -> L22
        if (r7 == null) goto L85;
        Matcher r10 = r0.matcher(r7);     // Catch: Throwable -> L20 Exception -> L22
        if (r10.find() == false) goto L89;
        long r11 = Long.parseLong(r10.group(1));     // Catch: Throwable -> L20 Exception -> L22
    L12:
        if (r11 <= 1024) goto L91;
        r6 = r11;
        goto L85
    L91:
        android.util.Log.w(TAG, "Invalid " + sMemoryInfoPath + " total size in kB: " + r11);     // Catch: Throwable -> L15 Exception -> L17
    L17:
        e = e;
        r5 = r9;
        r6 = r11;
    L42:
        android.util.Log.w(TAG, "Cannot get total physical size from " + sMemoryInfoPath, e);     // Catch: Throwable -> L34
        if (r5 != null) goto L81;
    L45:
        if (r8 == null) goto L47;
        r8.close();     // Catch: Exception -> L70
    L47:
        Object r1 = sMemoryLock;
        monitor-enter(r1);
        sTotalMemoryGB = String.valueOf((int) Math.ceil((r6 * 1.0d) / 1048576.0d));     // Catch: Throwable -> L53
        monitor-exit(r1);     // Catch: Throwable -> L53
        return;
    L53:
        th = move-exception;
        throw th;
    L81:
        r5.close();     // Catch: Exception -> L70
    L15:
        th = th;
        r5 = r9;
        r6 = r11;
    L56:
        if (r5 != null) goto L83;
    L58:
        if (r8 == null) goto L60;
        r8.close();     // Catch: Exception -> L69
    L60:
        Object r12 = sMemoryLock;
        monitor-enter(r12);
        sTotalMemoryGB = String.valueOf((int) Math.ceil((r6 * 1.0d) / 1048576.0d));     // Catch: Throwable -> L66
        monitor-exit(r12);     // Catch: Throwable -> L66
        throw th;
    L66:
        th = move-exception;
        throw th;
    L83:
        r5.close();     // Catch: Exception -> L69
    L85:
        r9.close();     // Catch: Exception -> L71
        r8.close();     // Catch: Exception -> L71
    L25:
        Object r2 = sMemoryLock;
        monitor-enter(r2);
        sTotalMemoryGB = String.valueOf((int) Math.ceil((r6 * 1.0d) / 1048576.0d));     // Catch: Throwable -> L31
        monitor-exit(r2);     // Catch: Throwable -> L31
        return;
    L31:
        th = move-exception;
        throw th;
    L22:
        e = e;
        r5 = r9;
    L20:
        th = th;
        r5 = r9;
    L36:
        e = e;
    L34:
        th = th;
        goto L56
    L40:
        e = e;
        r8 = null;
    L38:
        th = th;
        r8 = null;
        goto L56
    }

    public static String getTotalMemoryGB() {
        Object r0 = sMemoryLock;
        monitor-enter(r0);
        String r1 = sTotalMemoryGB;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean initialize() {
        if (sInitialized == false) goto L5;
        return true;
    L5:
        fetchTotalMemory();
        sInitialized = true;
        return true;
    }
}
