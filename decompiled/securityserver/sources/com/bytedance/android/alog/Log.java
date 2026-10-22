package com.bytedance.android.alog;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class Log {
    private static Alog instance;

    public Log() {
    }

    public static void asyncFlush() {
        Alog r0 = instance;
        if (r0 == null) goto L6;
        r0.asyncFlush();
        return;
    }

    public static void close() {
        instance.close();
        instance = null;
    }

    public static void d(String r1, String r2) {
        write(1, r1, r2);
    }

    public static void e(String r1, String r2) {
        write(4, r1, r2);
    }

    public static void f(String r1, String r2) {
        write(5, r1, r2);
    }

    public static Alog getInstance() {
        return instance;
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

    public static long getLegacyWriteFuncAddr() {
        Alog r0 = instance;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getLegacyWriteFuncAddr();
    }

    public static File[] getLogs(long r1, long r3) {
        Alog r0 = instance;
        if (r0 == null) goto L7;
        return r0.getLogs(r1, r3);
    L7:
        return new File[0];
    }

    public static String getStatus() {
        Alog r0 = instance;
        if (r0 != null) goto L5;
        return "default log instance is null";
    L5:
        return r0.getStatus();
    }

    public static void i(String r1, String r2) {
        write(2, r1, r2);
    }

    public static void setInstance(Alog r0) {
        instance = r0;
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

    public static void v(String r1, String r2) {
        write(0, r1, r2);
    }

    public static void w(String r1, String r2) {
        write(3, r1, r2);
    }

    public static void write(int r1, String r2, String r3) {
        Alog r0 = instance;
        if (r0 == null) goto L6;
        r0.write(r1, r2, r3);
        return;
    }

    public static File[] getLogs(String r7, String r8, long r9, long r11) {
        Alog r0 = instance;
        if (r0 == null) goto L7;
        return r0.getLogs(r7, r8, r9, r11);
    L7:
        return new File[0];
    }
}
