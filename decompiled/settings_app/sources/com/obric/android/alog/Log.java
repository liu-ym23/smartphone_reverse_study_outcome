package com.obric.android.alog;

import com.obric.android.agilelogger.ALog;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class Log {
    private static Alog instance;

    static {
    }

    public Log() {
    }

    public static void setInstance(Alog r2) {
        instance = r2;
        if (r2 != null) goto L5;
        long r0 = 0;
    L6:
        Alog.nativeSetDefaultInstance(r0);
        return;
    L5:
        r0 = r2.getNativeRef();
        goto L6
    }

    public static Alog getInstance() {
        return instance;
    }

    public static void close() {
        Alog.nativeSetDefaultInstance(0);
        instance.close();
        instance = null;
    }

    public static void asyncFlush() {
        Alog r0 = instance;
        if (r0 == null) goto L6;
        r0.asyncFlush();
        return;
    }

    public static void syncFlush() {
        Alog r0 = instance;
        if (r0 == null) goto L6;
        r0.syncFlush();
        return;
    }

    public static void timedSyncFlush(int r1) {
        Alog r0 = instance;
        if (r0 == null) goto L6;
        r0.timedSyncFlush(r1);
        return;
    }

    public static void setLevel(int r1) {
        Alog r0 = instance;
        if (r0 == null) goto L6;
        r0.setLevel(r1);
        return;
    }

    public static void setSyslog(boolean r1) {
        Alog r0 = instance;
        if (r0 == null) goto L6;
        r0.setSyslog(r1);
        return;
    }

    public static File[] getLogs(long r1, long r3) {
        Alog r0 = instance;
        if (r0 == null) goto L7;
        return r0.getLogs(r1, r3);
    L7:
        return new File[0];
    }

    public static File[] getLogs(String r7, String r8, long r9, long r11) {
        Alog r0 = instance;
        if (r0 == null) goto L7;
        return r0.getLogs(r7, r8, r9, r11);
    L7:
        return new File[0];
    }

    public static HashMap<String, String> getLastFetchErrorInfo() {
        Alog r0 = instance;
        if (r0 != null) goto L5;
        HashMap<String, String> r1 = new HashMap();
        r1.put("reason", "Log.instance does not exist");
        return r1;
    L5:
        return r0.getLastFetchErrorInfo();
    }

    public static String getStatus() {
        Alog r0 = instance;
        if (r0 != null) goto L5;
        return "default log instance is null";
    L5:
        return r0.getStatus();
    }

    public static long getLegacyWriteFuncAddr() {
        Alog r0 = instance;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getLegacyWriteFuncAddr();
    }

    public static long getLegacyFlushFuncAddr() {
        Alog r0 = instance;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getLegacyFlushFuncAddr();
    }

    public static long getLegacyGetLogFileDirFuncAddr() {
        Alog r0 = instance;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getLegacyGetLogFileDirFuncAddr();
    }

    public static long getNativeWriteFuncAddr() {
        Alog r0 = instance;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getNativeWriteFuncAddr();
    }

    @Deprecated
    public static void v(String r0, String r1) {
        ALog.v(r0, r1);
    }

    @Deprecated
    public static void d(String r0, String r1) {
        ALog.d(r0, r1);
    }

    @Deprecated
    public static void i(String r0, String r1) {
        ALog.i(r0, r1);
    }

    @Deprecated
    public static void w(String r0, String r1) {
        ALog.w(r0, r1);
    }

    @Deprecated
    public static void e(String r0, String r1) {
        ALog.e(r0, r1);
    }

    @Deprecated
    public static void f(String r0, String r1) {
        ALog.e(r0, r1);
    }

    @Deprecated
    public static void write(int r1, String r2, String r3) {
        Alog r0 = instance;
        if (r0 == null) goto L6;
        r0.write(r1, r2, r3);
        return;
    }

    @Deprecated
    public static void writeAsyncMsg(int r8, String r9, String r10, long r11, long r13) {
        Alog r0 = instance;
        if (r0 == null) goto L6;
        r0.writeAsyncMsg(r8, r9, r10, r11, r13);
        return;
    }

    @Deprecated
    public static void innerVerbose(String r1, String r2) {
        write(0, r1, r2);
    }

    @Deprecated
    public static void innerDebug(String r1, String r2) {
        write(1, r1, r2);
    }

    @Deprecated
    public static void innerInfo(String r1, String r2) {
        write(2, r1, r2);
    }

    @Deprecated
    public static void innerWarn(String r1, String r2) {
        write(3, r1, r2);
    }

    @Deprecated
    public static void innerError(String r1, String r2) {
        write(4, r1, r2);
    }

    @Deprecated
    public static void innerFatal(String r1, String r2) {
        write(5, r1, r2);
    }

    @Deprecated
    public static void innerWrite(int r1, String r2, String r3) {
        Alog r0 = instance;
        if (r0 == null) goto L6;
        r0.write(r1, r2, r3);
        return;
    }

    @Deprecated
    public static void innerWriteAsyncMsg(int r8, String r9, String r10, long r11, long r13) {
        Alog r0 = instance;
        if (r0 == null) goto L6;
        r0.writeAsyncMsg(r8, r9, r10, r11, r13);
        return;
    }
}
