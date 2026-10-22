package com.ss.ttuploader;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class TTUploadLog {
    public static final String FORMAT = "<%s>%s";
    public static final int LOG_DEBUG = 1;
    public static final int LOG_ERROR = 6;
    public static final int LOG_INFO = 2;
    public static final int LOG_KILL = 4;
    public static final int LOG_TRACK = 3;
    public static final int LOG_VERBOSE = 0;
    public static final int LOG_WARN = 5;
    public static int LogTurnOn = 112;
    private static final String TAG = "TTUploadLog";

    static {
    }

    public TTUploadLog() {
    }

    public static final void d(String r3, String r4) {
        if (((LogTurnOn >> 1) & 1) != 1) goto L6;
        Log.d(TAG, String.format(FORMAT, new Object[]{r3, r4}));
        return;
    }

    public static void e(String r3, String r4) {
        if (((LogTurnOn >> 6) & 1) != 1) goto L6;
        Log.e(TAG, String.format(FORMAT, new Object[]{r3, r4}));
        return;
    }

    public static final void i(String r3, String r4) {
        if (((LogTurnOn >> 2) & 1) != 1) goto L6;
        Log.i(TAG, String.format(FORMAT, new Object[]{r3, r4}));
        return;
    }

    public static final void k(String r3, String r4) {
        if (((LogTurnOn >> 4) & 1) != 1) goto L6;
        Log.i(TAG, String.format(FORMAT, new Object[]{r3, r4}));
        return;
    }

    public static final void t(String r3, String r4) {
        if (((LogTurnOn >> 3) & 1) != 1) goto L6;
        Log.i(TAG, String.format(FORMAT, new Object[]{r3, r4}));
        return;
    }

    public static final void turnOn(int r2, int r3) {
        int r0 = (~(1 << r2)) & LogTurnOn;
        LogTurnOn = r0;
        LogTurnOn = (r3 << r2) | r0;
    }

    public static final void w(String r3, String r4) {
        if (((LogTurnOn >> 5) & 1) != 1) goto L6;
        Log.w(TAG, String.format(FORMAT, new Object[]{r3, r4}));
        return;
    }
}
