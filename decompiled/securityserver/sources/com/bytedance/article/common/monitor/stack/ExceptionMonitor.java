package com.bytedance.article.common.monitor.stack;

import android.text.TextUtils;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.apm.util.StackUtils;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ExceptionMonitor {
    private static boolean sDebug;

    public ExceptionMonitor() {
    }

    private static void appendData(Map<String, String> r4, JSONObject r5) {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L10
        if (r4 == null) goto L14;
        Iterator<String> r1 = r4.keySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L8;
        String r2 = r1.next();     // Catch: Throwable -> L10
        r0.put(r2, r4.get(r2));     // Catch: Throwable -> L10
        goto L6
    L8:
        r5.put("custom", r0);     // Catch: Throwable -> L10
        return;
    L14:
        return;
    }

    public static boolean ensureFalse(boolean r1) {
        if (EnsureManager.getEnsureImpl() == null) goto L7;
        return EnsureManager.ensureFalse(r1);
    L7:
        return ensureFalseDefault(r1);
    }

    private static boolean ensureFalseDefault(boolean r4) {
        if (r4 == false) goto L4;
        report(3, Thread.currentThread().getStackTrace(), null, true, null);
    L4:
        return r4;
    }

    public static boolean ensureNotEmpty(Collection r1) {
        if (EnsureManager.getEnsureImpl() == null) goto L7;
        return EnsureManager.ensureNotEmpty(r1);
    L7:
        return ensureNotEmptyDefault(r1);
    }

    private static boolean ensureNotEmptyDefault(Collection r4) {
        if (r4 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        if (r5 == true) goto L10;
        report(3, Thread.currentThread().getStackTrace(), null, true, null);
    L10:
        return r5;
    L5:
        if (r4.size() == 0) goto L7;
        r5 = true;
        goto L8
    }

    public static boolean ensureNotNull(Object r1) {
        if (EnsureManager.getEnsureImpl() == null) goto L7;
        return EnsureManager.ensureNotNull(r1);
    L7:
        return ensureNotNullDefault(r1);
    }

    private static boolean ensureNotNullDefault(Object r4) {
        if (r4 == null) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == true) goto L8;
        report(3, Thread.currentThread().getStackTrace(), null, true, null);
    L8:
        return r5;
    L5:
        r5 = false;
        goto L6
    }

    public static void ensureNotReachHere() {
        if (EnsureManager.getEnsureImpl() == null) goto L5;
        EnsureManager.ensureNotReachHere();
        return;
    L5:
        ensureNotReachHereDefault();
    }

    private static void ensureNotReachHereDefault() {
        report(3, Thread.currentThread().getStackTrace(), null, true, null);
    }

    public static boolean ensureTrue(boolean r1) {
        if (EnsureManager.getEnsureImpl() == null) goto L7;
        return EnsureManager.ensureTrue(r1);
    L7:
        return ensureTrueDefault(r1);
    }

    private static boolean ensureTrueDefault(boolean r4) {
        if (r4 == true) goto L4;
        report(3, Thread.currentThread().getStackTrace(), null, true, null);
    L4:
        return r4;
    }

    private static boolean needReport(Throwable r2) {
        if (ExceptionMonitorManager.getInstance().getExceptionFilterSwitch() == true) goto L5;
        return true;
    L5:
        return !FilterNetworkException.filterException(r2);
    }

    private static void report(String r3, Map<String, String> r4) {
        report(3, Thread.currentThread().getStackTrace(), r3, false, r4);
    }

    private static void reportException(int r5, StackTraceElement[] r6, Throwable r7, String r8, boolean r9, boolean r10, Map<String, String> r11) {
        if (r7 != null) goto L23;
        return;
    L23:
        StackTraceElement r12 = r6[r5];     // Catch: Throwable -> L9
        String r13 = r12.getClassName();     // Catch: Throwable -> L9
        String r0 = r12.getMethodName();     // Catch: Throwable -> L9
        int r14 = r12.getLineNumber();     // Catch: Throwable -> L9
        String r15 = StackUtils.getThrowableStack(r7);     // Catch: Throwable -> L9
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L9
        r1.put("event_type", "exception");     // Catch: Throwable -> L9
        r1.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L9
        r1.put("class_ref", r13);     // Catch: Throwable -> L9
        r1.put("method", r0);     // Catch: Throwable -> L9
        r1.put("line_num", r14);     // Catch: Throwable -> L9
        r1.put("stack", r15);     // Catch: Throwable -> L9
        r1.put(ApmTrafficStats.KEY_EXCEPTION_TYPE, 0);     // Catch: Throwable -> L9
        if (r10 == true) goto L8;
        r1.put("is_core", 0);     // Catch: Throwable -> L9
    L13:
        if (TextUtils.isEmpty(r8) == false) goto L16;
    L19:
        appendData(r11, r1);     // Catch: Throwable -> L9
        ExceptionMonitorManager.getInstance().enqueue(SlardarSettingsConsts.TYPE_ENSURE_MONITOR, r1.toString(), r8, r9);     // Catch: Throwable -> L9
        return;
    L16:
        if (r8.length() <= 1024) goto L18;
        r1.put("message", r8.substring(0, 1024));     // Catch: Throwable -> L9
        goto L19
    L18:
        r1.put("message", r8);     // Catch: Throwable -> L9
        goto L19
    L8:
        r1.put("is_core", 1);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.printStackTrace();
    }

    public static void reportLogEException(int r1, Throwable r2, String r3, boolean r4) {
        if (EnsureManager.getEnsureImpl() == null) goto L6;
        EnsureManager.reportLogEException(r1, r2, r3, r4);
        return;
    L6:
        reportLogEExceptionDefault(r1, r2, r3, r4);
    }

    private static void reportLogEExceptionDefault(int r8, Throwable r9, String r10, boolean r11) {
        if (needReport(r9) == true) goto L5;
        return;
    L5:
        reportException(r8 + 2, Thread.currentThread().getStackTrace(), r9, r10, r11, false, null);
    }

    public static void setDebug(boolean r0) {
        sDebug = r0;
    }

    public static void setUploadUrl(String r1) {
        if (TextUtils.isEmpty(r1) == true) goto L6;
        ExceptionMonitorManager.setUploadUrl(r1);
        return;
    }

    private static boolean ensureFalseDefault(boolean r4, String r5) {
        if (r4 == false) goto L4;
        report(3, Thread.currentThread().getStackTrace(), r5, true, null);
    L4:
        return r4;
    }

    private static boolean ensureNotNullDefault(Object r4, String r5) {
        if (r4 == null) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == true) goto L8;
        report(3, Thread.currentThread().getStackTrace(), r5, true, null);
    L8:
        return r6;
    L5:
        r6 = false;
        goto L6
    }

    private static void ensureNotReachHereDefault(String r4) {
        report(3, Thread.currentThread().getStackTrace(), r4, true, null);
    }

    private static boolean ensureTrueDefault(boolean r4, String r5) {
        if (r4 == true) goto L4;
        report(3, Thread.currentThread().getStackTrace(), r5, true, null);
    L4:
        return r4;
    }

    private static boolean ensureFalseDefault(boolean r0, String r1, Map<String, String> r2) {
        if (r0 == false) goto L4;
        report(r1, r2);
    L4:
        return r0;
    }

    private static void ensureNotReachHereDefault(Throwable r8) {
        if (needReport(r8) == true) goto L5;
        return;
    L5:
        reportException(3, Thread.currentThread().getStackTrace(), r8, null, true, true, null);
    }

    private static boolean ensureTrueDefault(boolean r0, String r1, Map<String, String> r2) {
        if (r0 == true) goto L4;
        report(r1, r2);
    L4:
        return r0;
    }

    private static void report(int r6, StackTraceElement[] r7, String r8, boolean r9, Map<String, String> r10) {
        if (r7 == null) goto L25;
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (r7.length <= (r6 + 1)) goto L26;
        StackTraceElement r11 = r7[r6];     // Catch: Throwable -> L16
        if (r11 != null) goto L9;
        return;
    L9:
        String r0 = r11.getClassName();     // Catch: Throwable -> L16
        String r1 = r11.getMethodName();     // Catch: Throwable -> L16
        int r12 = r11.getLineNumber();     // Catch: Throwable -> L16
        String r13 = StackUtils.getStackTraces(r7);     // Catch: Throwable -> L16
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L16
        r2.put("event_type", "exception");     // Catch: Throwable -> L16
        r2.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L16
        r2.put("class_ref", r0);     // Catch: Throwable -> L16
        r2.put("method", r1);     // Catch: Throwable -> L16
        r2.put("line_num", r12);     // Catch: Throwable -> L16
        r2.put("stack", r13);     // Catch: Throwable -> L16
        r2.put(ApmTrafficStats.KEY_EXCEPTION_TYPE, 1);     // Catch: Throwable -> L16
        r2.put("is_core", 1);     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r8) == false) goto L13;
    L19:
        appendData(r10, r2);     // Catch: Throwable -> L16
        ExceptionMonitorManager.getInstance().enqueue(SlardarSettingsConsts.TYPE_ENSURE_MONITOR, r2.toString(), r8, r9);     // Catch: Throwable -> L16
        return;
    L13:
        if (r8.length() > 1024) goto L15;
        r2.put("message", r8);     // Catch: Throwable -> L16
        goto L19
    L15:
        r2.put("message", r8.substring(0, 1024));     // Catch: Throwable -> L16
        goto L19
    L26:
        return;
    }

    public static boolean ensureFalse(boolean r1, String r2) {
        if (EnsureManager.getEnsureImpl() == null) goto L7;
        return EnsureManager.ensureFalse(r1, r2);
    L7:
        return ensureFalseDefault(r1, r2);
    }

    public static boolean ensureNotNull(Object r1, String r2) {
        if (EnsureManager.getEnsureImpl() == null) goto L7;
        return EnsureManager.ensureNotNull(r1, r2);
    L7:
        return ensureNotNullDefault(r1, r2);
    }

    public static void ensureNotReachHere(String r1) {
        if (EnsureManager.getEnsureImpl() == null) goto L5;
        EnsureManager.ensureNotReachHere(r1);
        return;
    L5:
        ensureNotReachHereDefault(r1);
    }

    public static boolean ensureTrue(boolean r1, String r2) {
        if (EnsureManager.getEnsureImpl() == null) goto L7;
        return EnsureManager.ensureTrue(r1, r2);
    L7:
        return ensureTrueDefault(r1, r2);
    }

    private static void ensureNotReachHereDefault(Throwable r8, String r9) {
        if (needReport(r8) == true) goto L5;
        return;
    L5:
        reportException(3, Thread.currentThread().getStackTrace(), r8, r9, true, true, null);
    }

    public static boolean ensureFalse(boolean r1, String r2, Map<String, String> r3) {
        if (EnsureManager.getEnsureImpl() == null) goto L7;
        return EnsureManager.ensureFalse(r1, r2, r3);
    L7:
        return ensureFalseDefault(r1, r2, r3);
    }

    public static void ensureNotReachHere(Throwable r1) {
        if (EnsureManager.getEnsureImpl() == null) goto L5;
        EnsureManager.ensureNotReachHere(r1);
        return;
    L5:
        ensureNotReachHereDefault(r1);
    }

    private static void ensureNotReachHereDefault(Throwable r8, String r9, Map<String, String> r10) {
        if (needReport(r8) == true) goto L5;
        return;
    L5:
        reportException(3, Thread.currentThread().getStackTrace(), r8, r9, true, false, r10);
    }

    public static boolean ensureTrue(boolean r1, String r2, Map<String, String> r3) {
        if (EnsureManager.getEnsureImpl() == null) goto L7;
        return EnsureManager.ensureTrue(r1, r2, r3);
    L7:
        return ensureTrueDefault(r1, r2, r3);
    }

    private static void ensureNotReachHereDefault(String r0, Map<String, String> r1) {
        report(r0, r1);
    }

    public static void ensureNotReachHere(String r1, Map<String, String> r2) {
        if (EnsureManager.getEnsureImpl() == null) goto L5;
        EnsureManager.ensureNotReachHere(r1, r2);
        return;
    L5:
        ensureNotReachHereDefault(r1, r2);
    }

    public static void ensureNotReachHere(Throwable r1, String r2) {
        if (EnsureManager.getEnsureImpl() == null) goto L5;
        EnsureManager.ensureNotReachHere(r1, r2);
        return;
    L5:
        ensureNotReachHereDefault(r1, r2);
    }

    public static void ensureNotReachHere(Throwable r1, String r2, Map<String, String> r3) {
        if (EnsureManager.getEnsureImpl() == null) goto L5;
        EnsureManager.ensureNotReachHere(r1, r2, r3);
        return;
    L5:
        ensureNotReachHereDefault(r1, r2, r3);
    }
}
