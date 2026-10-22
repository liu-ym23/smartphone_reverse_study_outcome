package com.ss.android.agilelogger.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes2.dex */
public class StackTraceUtils {
    public StackTraceUtils() {
    }

    public static String getStackTraceString(Throwable r2) {
        if (r2 != null) goto L5;
        return "";
    L5:
        Throwable r0 = r2;
    L6:
        if (r0 == null) goto L12;
        if ((r0 instanceof UnknownHostException) == true) goto L9;
        r0 = r0.getCause();
        goto L6
    L9:
        return "ALOG:UnknownHostException";
    L12:
        StringWriter r1 = new StringWriter();
        PrintWriter r3 = new PrintWriter(r1);
        r2.printStackTrace(r3);     // Catch: Throwable -> L16
    L14:
        r3.flush();
        return r1.toString();
    }
}
