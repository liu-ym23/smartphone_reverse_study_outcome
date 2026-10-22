package com.android.settings.utils;

import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class SysUtils {
    private static final String SYS_PROP_OTA_VERSION = "ro.os.ota.version";
    private static final String TAG = "SysUtils";

    public SysUtils() {
    }

    public static String getOsOtaVersion() {
        String r0 = getSystemProperty(SYS_PROP_OTA_VERSION);
        OLog.d(TAG, "getOsOtaVersion: [" + r0 + "]");
        return r0;
    }

    private static String getSystemProperty(String r8) {
        Object r9 = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{r8, ""});     // Catch: Throwable -> L8
        if ((r9 instanceof String) == false) goto L11;
        return (String) r9;
    L11:
        return "";
    L12:
        return "";
    }
}
