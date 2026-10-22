package com.bytedance.privacy.utils;

import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.privacy.bridge.ILogBridge;

/* JADX INFO: loaded from: classes3.dex */
public class LogUtils {
    private static final String LEGACY_TAG_PREFIX = "PSDK-";
    private static final boolean LOG_DEBUG = false;
    private static final int MAX_TAG_LENGTH_PRE_O = 23;
    private static final String SDK_VERSION = "1.2.8";
    private static final String TAG_PREFIX = "PrivacySDK-1.2.8-";
    private static ILogBridge mLogBridge;

    public LogUtils() {
    }

    static {
        LOG_DEBUG = PrivacyConfig.isDebug();
    }

    public static void init(ILogBridge r0) {
        mLogBridge = r0;
    }

    public static void d(String r1, String r2, Throwable r3) {
        if (LOG_DEBUG == false) goto L8;
        String r4 = formatTag(r1);
        Log.d(r4, r2, r3);
        ILogBridge r5 = mLogBridge;
        if (r5 == null) goto L9;
        r5.d(r4, r2);
        return;
    L9:
        return;
    }

    public static void i(String r0, String r1, Throwable r2) {
        String r3 = formatTag(r0);
        Log.i(r3, r1);
        ILogBridge r4 = mLogBridge;
        if (r4 == null) goto L6;
        r4.i(r3, r1);
        return;
    }

    public static void e(String r0, String r1, Throwable r2) {
        String r3 = formatTag(r0);
        Log.e(r3, r1, r2);
        ILogBridge r4 = mLogBridge;
        if (r4 == null) goto L6;
        r4.e(r3, r1);
        return;
    }

    public static void d(String r1, String r2) {
        if (LOG_DEBUG == false) goto L8;
        String r3 = formatTag(r1);
        Log.d(r3, r2);
        ILogBridge r0 = mLogBridge;
        if (r0 == null) goto L9;
        r0.d(r3, r2);
        return;
    L9:
        return;
    }

    public static void i(String r1, String r2) {
        String r3 = formatTag(r1);
        Log.i(r3, r2);
        ILogBridge r0 = mLogBridge;
        if (r0 == null) goto L6;
        r0.i(r3, r2);
        return;
    }

    public static void w(String r1, String r2) {
        String r3 = formatTag(r1);
        Log.w(r3, r2);
        ILogBridge r0 = mLogBridge;
        if (r0 == null) goto L6;
        r0.w(r3, r2);
        return;
    }

    public static void e(String r1, String r2) {
        String r3 = formatTag(r1);
        Log.e(r3, r2);
        ILogBridge r0 = mLogBridge;
        if (r0 == null) goto L6;
        r0.e(r3, r2);
        return;
    }

    private static String formatTag(String r2) {
        if (isBlank(r2) == false) goto L5;
        String r3 = "Unknown";
    L7:
        return TAG_PREFIX + r3;
    L5:
        r3 = r2.trim();
        goto L7
    }

    private static String compactVersion(String r3) {
        if (isBlank(r3) == false) goto L5;
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L5:
        String r4 = r3.trim().replace("-SNAPSHOT", ExifInterface.LATITUDE_SOUTH).replaceAll("[^0-9A-Za-z.]", "");
        if (r4.isEmpty() == false) goto L9;
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L9:
        return r4;
    }

    private static boolean isBlank(String r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.trim().isEmpty() == true) goto L7;
        return false;
    }
}
