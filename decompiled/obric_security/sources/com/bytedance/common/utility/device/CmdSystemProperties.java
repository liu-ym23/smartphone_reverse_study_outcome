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

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0062: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:24:0x0062 */
    static String getSystemProperty(String r8) {
        BufferedReader r4 = null;
        BufferedReader r5 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + r8).getInputStream(), "UTF-8"), 1024);     // Catch: Throwable -> L12 IOException -> L14
        String r3 = r5.readLine();     // Catch: IOException -> L10 Throwable -> L23
        r5.close();     // Catch: IOException -> L10 Throwable -> L23
        r5.close();     // Catch: IOException -> L7
    L9:
        return r3;
    L7:
        e = move-exception;
        Log.e(TAG, "Exception while closing InputStream", e);
    L10:
        e = e;
    L16:
        Log.e(TAG, "Unable to read sysprop " + r8, e);     // Catch: Throwable -> L23
        if (r5 != null) goto L38;
    L22:
        return null;
    L38:
        r5.close();     // Catch: IOException -> L20
    L20:
        e = move-exception;
        Log.e(TAG, "Exception while closing InputStream", e);
        goto L22
    L23:
        th = th;
        r4 = r5;
    L25:
        if (r4 != null) goto L31;
    L30:
        throw th;
    L31:
        r4.close();     // Catch: IOException -> L28
    L28:
        e = move-exception;
        Log.e(TAG, "Exception while closing InputStream", e);
    L14:
        e = e;
        r5 = null;
    L12:
        th = th;
        goto L25
    }
}
