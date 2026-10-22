package com.bytedance.privacy.utils;

import android.util.Log;
import com.bytedance.privacy.bridge.ILogBridge;

/* JADX INFO: loaded from: classes.dex */
public class LogUtils {
    private static final boolean LOG_DEBUG = false;
    private static ILogBridge mLogBridge;

    public LogUtils() {
    }

    static {
        LOG_DEBUG = PrivacyConfig.isDebug();
    }

    public static void init(ILogBridge r0) {
        mLogBridge = r0;
    }

    public static void d(String r0, String r1, Throwable r2) {
        if (LOG_DEBUG == false) goto L8;
        Log.i(r0, r1);
        ILogBridge r3 = mLogBridge;
        if (r3 == null) goto L9;
        r3.i(r0, r1);
        return;
    L9:
        return;
    }

    public static void i(String r0, String r1, Throwable r2) {
        Log.i(r0, r1);
        ILogBridge r3 = mLogBridge;
        if (r3 == null) goto L6;
        r3.i(r0, r1);
        return;
    }

    public static void e(String r0, String r1, Throwable r2) {
        Log.e(r0, r1, r2);
        ILogBridge r3 = mLogBridge;
        if (r3 == null) goto L6;
        r3.e(r0, r1);
        return;
    }

    public static void d(String r1, String r2) {
        if (LOG_DEBUG == false) goto L8;
        Log.i(r1, r2);
        ILogBridge r0 = mLogBridge;
        if (r0 == null) goto L9;
        r0.i(r1, r2);
        return;
    L9:
        return;
    }

    public static void i(String r1, String r2) {
        Log.i(r1, r2);
        ILogBridge r0 = mLogBridge;
        if (r0 == null) goto L6;
        r0.i(r1, r2);
        return;
    }

    public static void w(String r1, String r2) {
        Log.w(r1, r2);
        ILogBridge r0 = mLogBridge;
        if (r0 == null) goto L6;
        r0.w(r1, r2);
        return;
    }

    public static void e(String r1, String r2) {
        Log.e(r1, r2);
        ILogBridge r0 = mLogBridge;
        if (r0 == null) goto L6;
        r0.e(r1, r2);
        return;
    }
}
