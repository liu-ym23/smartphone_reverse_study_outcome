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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [long] */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    private static void fetchTotalMemory() {
        Pattern r0 = Pattern.compile("^MemTotal:\\s+([0-9]+) kB$");
        ?? r1 = 0;
        long r2 = 0;
        r2 = 0;
        long r3 = 0;
        r1 = 0;
        r3 = 0;
        r3 = 0;
        r1 = 0;
        ?? r4 = 0;
        BufferedReader r5 = null;
        r5 = null;
        r4 = 0;
        FileReader r8 = new FileReader(sMemoryInfoPath);     // Catch: Throwable -> L36 Exception -> L38
        BufferedReader r9 = new BufferedReader(r8);     // Catch: Exception -> L34 Throwable -> L54
    L88:
        String r6 = r9.readLine();     // Catch: Throwable -> L30 Exception -> L32
        Object r7 = r6;
        if (r6 == null) goto L82;
        Matcher r10 = r0.matcher(r6);     // Catch: Throwable -> L30 Exception -> L32
        if (r10.find() == false) goto L88;
        long r11 = Long.parseLong(r10.group(1));     // Catch: Throwable -> L30 Exception -> L32
    L12:
        if (r11 <= 1024) goto L91;
        r2 = r11;
        r7 = r10;
        goto L82
    L91:
        String r12 = TAG;     // Catch: Throwable -> L15 Exception -> L17
        String r13 = "Invalid " + sMemoryInfoPath + " total size in kB: " + r11;     // Catch: Throwable -> L15 Exception -> L17
        android.util.Log.w(r12, r13);     // Catch: Throwable -> L15 Exception -> L17
        r7 = r13;
    L17:
        e = e;
        r5 = r9;
        r3 = r11;
    L40:
        android.util.Log.w(TAG, "Cannot get total physical size from " + sMemoryInfoPath, e);     // Catch: Throwable -> L54
        if (r5 != null) goto L73;
    L43:
        if (r8 == null) goto L45;
        r8.close();     // Catch: Exception -> L69
    L45:
        Object r14 = sMemoryLock;
        monitor-enter(r14);
        String r15 = String.valueOf((int) Math.ceil((r3 * 1.0d) / 1048576.0d));     // Catch: Throwable -> L51
        sTotalMemoryGB = r15;     // Catch: Throwable -> L51
        r1 = r15;
        r4 = r5;
        monitor-exit(r14);     // Catch: Throwable -> L51
    L79:
        return;
    L51:
        th = move-exception;
        throw th;
    L73:
        r5.close();     // Catch: Exception -> L69
    L15:
        th = th;
        r4 = r9;
        r1 = r11;
    L55:
        if (r4 != 0) goto L71;
    L57:
        if (r8 == null) goto L59;
        r8.close();     // Catch: Exception -> L68
    L59:
        Object r16 = sMemoryLock;
        monitor-enter(r16);
        sTotalMemoryGB = String.valueOf((int) Math.ceil((((double) r1) * 1.0d) / 1048576.0d));     // Catch: Throwable -> L65
        monitor-exit(r16);     // Catch: Throwable -> L65
        throw th;
    L65:
        th = move-exception;
        throw th;
    L71:
        r4.close();     // Catch: Exception -> L68
    L82:
        r9.close();     // Catch: Exception -> L70
        r8.close();     // Catch: Exception -> L70
    L21:
        Object r17 = sMemoryLock;
        monitor-enter(r17);
        String r18 = String.valueOf((int) Math.ceil((r2 * 1.0d) / 1048576.0d));     // Catch: Throwable -> L27
        sTotalMemoryGB = r18;     // Catch: Throwable -> L27
        monitor-exit(r17);     // Catch: Throwable -> L27
        r1 = r18;
        r4 = r7;
    L27:
        th = move-exception;
        throw th;
    L32:
        e = e;
        r5 = r9;
    L30:
        th = th;
        r4 = r9;
    L34:
        e = e;
        goto L40
    L54:
        th = th;
    L38:
        e = e;
        r8 = null;
    L36:
        th = th;
        r8 = null;
        goto L55
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
