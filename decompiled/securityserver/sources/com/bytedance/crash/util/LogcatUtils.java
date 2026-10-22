package com.bytedance.crash.util;

/* JADX INFO: loaded from: classes.dex */
public final class LogcatUtils {
    private static LogcatImpl sLogcat;

    public static abstract class LogcatImpl {
        public LogcatImpl() {
        }

        public abstract String dumpLogcat();

        public abstract void dumpLogcat(String r1);
    }

    public LogcatUtils() {
    }

    public static void dumpLogcat(String r1) {
        LogcatImpl r0 = sLogcat;
        if (r0 == null) goto L6;
        r0.dumpLogcat(r1);
        return;
    }

    public static void setLogcatImpl(LogcatImpl r0) {
        sLogcat = r0;
    }
}
