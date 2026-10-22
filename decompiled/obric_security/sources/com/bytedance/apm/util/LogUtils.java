package com.bytedance.apm.util;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class LogUtils {
    public LogUtils() {
    }

    public static void e(String r5, String r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.length() == 0) goto L19;
        if (r6 != null) goto L7;
        return;
    L7:
        if (r6.length() != 0) goto L10;
        return;
    L10:
        if (r6.length() > 3072) goto L13;
        Log.e(r5, r6);
        return;
    L13:
        if (r6.length() <= 3072) goto L15;
        String r0 = r6.substring(0, 3072);
        r6 = r6.replace(r0, "");
        Log.e(r5, r0);
        goto L13
    L15:
        Log.e(r5, r6);
        return;
    }

    public static void d(String r5, String r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.length() == 0) goto L19;
        if (r6 != null) goto L7;
        return;
    L7:
        if (r6.length() != 0) goto L10;
        return;
    L10:
        if (r6.length() > 3072) goto L13;
        Log.d(r5, r6);
        return;
    L13:
        if (r6.length() <= 3072) goto L15;
        String r0 = r6.substring(0, 3072);
        r6 = r6.replace(r0, "");
        Log.d(r5, r0);
        goto L13
    L15:
        Log.d(r5, r6);
        return;
    }
}
