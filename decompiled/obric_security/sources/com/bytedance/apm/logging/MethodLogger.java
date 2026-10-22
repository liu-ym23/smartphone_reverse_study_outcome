package com.bytedance.apm.logging;

/* JADX INFO: loaded from: classes.dex */
public class MethodLogger {
    private static MethodLog.LogImp logImp;

    static {
        logImp = MethodLog.sLog;
    }

    private MethodLogger() {
    }

    public static void i(String r1, String r2, Object... r3) {
        MethodLog.LogImp r0 = logImp;
        if (r0 == null) goto L6;
        r0.i(r1, r2, r3);
        return;
    }

    public static void v(String r1, String r2, Object... r3) {
        MethodLog.LogImp r0 = logImp;
        if (r0 == null) goto L6;
        r0.v(r1, r2, r3);
        return;
    }

    public static void w(String r1, String r2, Object... r3) {
        MethodLog.LogImp r0 = logImp;
        if (r0 == null) goto L6;
        r0.w(r1, r2, r3);
        return;
    }

    public static void d(String r1, String r2, Object... r3) {
        MethodLog.LogImp r0 = logImp;
        if (r0 == null) goto L6;
        r0.d(r1, r2, r3);
        return;
    }

    public static void printErrStackTrace(String r1, Throwable r2, String r3, Object... r4) {
        MethodLog.LogImp r0 = logImp;
        if (r0 == null) goto L6;
        r0.printErrStackTrace(r1, r2, r3, r4);
        return;
    }

    public static void e(String r1, String r2, Object... r3) {
        MethodLog.LogImp r0 = logImp;
        if (r0 == null) goto L6;
        r0.e(r1, r2, r3);
        return;
    }
}
