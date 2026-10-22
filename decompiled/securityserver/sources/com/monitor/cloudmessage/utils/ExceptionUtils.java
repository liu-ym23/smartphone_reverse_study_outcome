package com.monitor.cloudmessage.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes.dex */
public class ExceptionUtils {
    public ExceptionUtils() {
    }

    public static String getFullStacktrace(Throwable r2) {
        StringWriter r0 = new StringWriter();
        r2.printStackTrace(new PrintWriter(r0));
        return r0.toString();
    }
}
