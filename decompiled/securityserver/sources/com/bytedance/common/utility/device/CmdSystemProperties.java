package com.bytedance.common.utility.device;

import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class CmdSystemProperties {
    private static final int DEFAULT_CACHE_SIZE = 1024;
    private static final String TAG = "CmdSystemProperties";

    private CmdSystemProperties() {
    }

    public static String getSystemProperty(String r8) {
        BufferedReader r4 = null;
        BufferedReader r5 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + r8).getInputStream(), "UTF-8"), 1024);     // Catch: Throwable -> L14 IOException -> L16
        String r3 = r5.readLine();     // Catch: Throwable -> L10 IOException -> L12
        r5.close();     // Catch: Throwable -> L10 IOException -> L12
        r5.close();     // Catch: IOException -> L7
    L9:
        return r3;
    L7:
        e = move-exception;
        Log.e(TAG, "Exception while closing InputStream", e);
    L12:
        e = e;
    L18:
        Log.e(TAG, "Unable to read sysprop " + r8, e);     // Catch: Throwable -> L10
        if (r5 != null) goto L37;
    L24:
        return null;
    L37:
        r5.close();     // Catch: IOException -> L22
    L22:
        e = move-exception;
        Log.e(TAG, "Exception while closing InputStream", e);
    L10:
        th = th;
        r4 = r5;
    L25:
        if (r4 != null) goto L33;
    L30:
        throw th;
    L33:
        r4.close();     // Catch: IOException -> L28
    L28:
        e = move-exception;
        Log.e(TAG, "Exception while closing InputStream", e);
        goto L30
    L16:
        e = e;
        r5 = null;
    L14:
        th = th;
        goto L25
    }
}
