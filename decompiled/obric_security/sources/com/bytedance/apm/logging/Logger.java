package com.bytedance.apm.logging;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Logger {
    private static ILogger debugLog;
    private static ILogger sApmLogImp;

    static /* synthetic */ String access$000(String[] r0) {
        return wrap(r0);
    }

    private static String wrap(String... r4) {
        StringBuilder r0 = new StringBuilder(400);
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.append(r4[r2]);
        r2 = r2 + 1;
        goto L3
    L6:
        return r0.toString();
    }

    static {
        ILogger r0 = new AnonymousClass1();
        debugLog = r0;
        sApmLogImp = r0;
    }

    private Logger() {
    }

    public static void seApmLogImp(ILogger r0) {
        sApmLogImp = r0;
    }

    public static ILogger getImpl() {
        return sApmLogImp;
    }

    public static void v(String r1, String... r2) {
        ILogger r0 = sApmLogImp;
        if (r0 == null) goto L6;
        r0.v(r1, r2);
        return;
    }

    public static void e(String r1, String... r2) {
        ILogger r0 = sApmLogImp;
        if (r0 == null) goto L6;
        r0.e(r1, r2);
        return;
    }

    public static void w(String r1, String... r2) {
        ILogger r0 = sApmLogImp;
        if (r0 == null) goto L6;
        r0.w(r1, r2);
        return;
    }

    public static void i(String r1, String... r2) {
        ILogger r0 = sApmLogImp;
        if (r0 == null) goto L6;
        r0.i(r1, r2);
        return;
    }

    public static void iJson(String r6, Object... r7) {
        if (sApmLogImp == null) goto L15;
        JSONObject r0 = new JSONObject();
        int r1 = r7.length;
        if ((r1 % 2) != 0) goto L14;
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L12;
        r0.put(String.valueOf(r7[r3]), String.valueOf(r7[r3 + 1]));     // Catch: JSONException -> L10
        r3 = r3 + 2;
    L10:
        e = move-exception;
        e.printStackTrace();
    L12:
        sApmLogImp.i(r6, new String[]{r0.toString()});
        return;
    L14:
        throw new IllegalArgumentException();
    }

    public static void d(String r1, String... r2) {
        ILogger r0 = sApmLogImp;
        if (r0 == null) goto L6;
        r0.d(r1, r2);
        return;
    }

    public static void printErrStackTrace(String r1, Throwable r2, String... r3) {
        ILogger r0 = sApmLogImp;
        if (r0 == null) goto L6;
        r0.printErrStackTrace(r1, r2, r3);
        return;
    }
}
