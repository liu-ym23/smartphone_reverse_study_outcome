package com.obric.netdetect.Utils;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class NetDetectLog {
    private static final String LOG_TAG = "NetDetect";
    private static int mLogLevel = 1;

    static {
    }

    public NetDetectLog() {
    }

    public static boolean isLoggable(int r1) {
        if (mLogLevel > r1) goto L5;
        return true;
    L5:
        return false;
    }

    public static void setNetDetectLogLevel(int r0) {
        mLogLevel = r0;
    }

    public static void i(String r1, String r2) {
        if (isLoggable(2) == false) goto L6;
        Log.i(LOG_TAG, formatMessage(r1, r2));
        return;
    }

    public static void i(String r1, String r2, Throwable r3) {
        if (isLoggable(2) == false) goto L6;
        Log.i(LOG_TAG, formatMessage(r1, r2), r3);
        return;
    }

    public static void v(String r1, String r2) {
        if (isLoggable(0) == false) goto L6;
        Log.v(LOG_TAG, formatMessage(r1, r2));
        return;
    }

    public static void v(String r1, String r2, Throwable r3) {
        if (isLoggable(0) == false) goto L6;
        Log.v(LOG_TAG, formatMessage(r1, r2), r3);
        return;
    }

    public static void d(String r1, String r2) {
        if (isLoggable(1) == false) goto L6;
        Log.d(LOG_TAG, formatMessage(r1, r2));
        return;
    }

    public static void d(String r1, String r2, Throwable r3) {
        if (isLoggable(1) == false) goto L6;
        Log.d(LOG_TAG, formatMessage(r1, r2), r3);
        return;
    }

    public static void w(String r1, String r2) {
        if (isLoggable(3) == false) goto L6;
        Log.w(LOG_TAG, formatMessage(r1, r2));
        return;
    }

    public static void w(String r1, String r2, Throwable r3) {
        if (isLoggable(3) == false) goto L6;
        Log.w(LOG_TAG, formatMessage(r1, r2), r3);
        return;
    }

    public static void e(String r0, String r1) {
        Log.e(LOG_TAG, formatMessage(r0, r1));
    }

    public static void e(String r0, String r1, Throwable r2) {
        Log.e(LOG_TAG, formatMessage(r0, r1), r2);
    }

    private static String formatMessage(String r2, String r3) {
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        return "<" + r2 + "> " + r3;
    }
}
