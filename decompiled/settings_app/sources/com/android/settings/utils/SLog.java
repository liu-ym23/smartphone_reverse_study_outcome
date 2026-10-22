package com.android.settings.utils;

import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class SLog {
    public SLog() {
    }

    public static void v(String r0, String r1) {
        OLog.vSensitive(r0, r1);
    }

    public static void v(String r0, String r1, Throwable r2) {
        OLog.vSensitive(r0, r1, r2);
    }

    public static void i(String r0, String r1) {
        OLog.iSensitive(r0, r1);
    }

    public static void i(String r0, String r1, Throwable r2) {
        OLog.iSensitive(r0, r1, r2);
    }

    public static void d(String r0, String r1) {
        OLog.dSensitive(r0, r1);
    }

    public static void d(String r0, String r1, Throwable r2) {
        OLog.dSensitive(r0, r1, r2);
    }

    public static void w(String r0, String r1) {
        OLog.wSensitive(r0, r1);
    }

    public static void w(String r0, String r1, Throwable r2) {
        OLog.wSensitive(r0, r1, r2);
    }

    public static void e(String r0, String r1) {
        OLog.eSensitive(r0, r1);
    }

    public static void e(String r0, String r1, Throwable r2) {
        OLog.eSensitive(r0, r1, r2);
    }
}
