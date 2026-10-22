package com.tencent.wcdb.support;

/* JADX INFO: loaded from: classes5.dex */
public class Log {
    public static final int LOGGER_DEFAULT = 1;
    public static final int LOGGER_NONE = 0;
    private static LogCallback mCallback;

    public interface LogCallback {
        void println(int r1, String r2, String r3);
    }

    static {
    }

    private static native void nativePrintLn(int r0, String r1, String r2);

    private static native void nativeSetLogger(int r0, LogCallback r1);

    private Log() {
    }

    public static void setLogger(int r1) {
        mCallback = null;
        nativeSetLogger(r1, null);
    }

    public static void setLogger(LogCallback r1) {
        mCallback = r1;
        nativeSetLogger(-1, r1);
    }

    public static void println(int r1, String r2, String r3) {
        LogCallback r0 = mCallback;
        if (r0 == null) goto L5;
        r0.println(r1, r2, r3);
        return;
    L5:
        nativePrintLn(r1, r2, r3);
    }

    public static void f(String r1, String r2) {
        println(7, r1, r2);
    }

    public static void e(String r1, String r2) {
        println(6, r1, r2);
    }

    public static void w(String r1, String r2) {
        println(5, r1, r2);
    }

    public static void i(String r1, String r2) {
        println(4, r1, r2);
    }

    public static void d(String r1, String r2) {
        println(3, r1, r2);
    }

    public static void v(String r1, String r2) {
        println(2, r1, r2);
    }

    public static void f(String r1, String r2, Object... r3) {
        println(7, r1, String.format(r2, r3));
    }

    public static void e(String r1, String r2, Object... r3) {
        println(6, r1, String.format(r2, r3));
    }

    public static void w(String r1, String r2, Object... r3) {
        println(5, r1, String.format(r2, r3));
    }

    public static void i(String r1, String r2, Object... r3) {
        println(4, r1, String.format(r2, r3));
    }

    public static void d(String r1, String r2, Object... r3) {
        println(3, r1, String.format(r2, r3));
    }

    public static void v(String r1, String r2, Object... r3) {
        println(2, r1, String.format(r2, r3));
    }
}
