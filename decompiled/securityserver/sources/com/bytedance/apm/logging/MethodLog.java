package com.bytedance.apm.logging;

/* JADX INFO: loaded from: classes.dex */
public class MethodLog {
    public static LogImp sLog;

    public interface LogImp {
        void d(String r1, String r2, Object... r3);

        void e(String r1, String r2, Object... r3);

        void i(String r1, String r2, Object... r3);

        void printErrStackTrace(String r1, Throwable r2, String r3, Object... r4);

        void v(String r1, String r2, Object... r3);

        void w(String r1, String r2, Object... r3);
    }

    static {
        sLog = new AnonymousClass1();
    }

    public MethodLog() {
    }
}
