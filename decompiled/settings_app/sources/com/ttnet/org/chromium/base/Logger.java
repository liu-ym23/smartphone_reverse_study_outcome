package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes5.dex */
public class Logger {
    private static final String TAG = "Logger";
    static int mLevel = 4;

    static {
    }

    public Logger() {
    }

    public static void setLogLevel(int r0) {
        mLevel = r0;
    }

    public static int getLogLevel() {
        return mLevel;
    }

    public static boolean debug() {
        if (mLevel > 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static void v(String r1) {
        v(TAG, r1);
    }

    public static void v(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (mLevel > 2) goto L8;
        android.util.Log.v(r2, r3);
        return;
    }

    public static void v(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (mLevel > 2) goto L9;
        android.util.Log.v(r2, r3, r4);
        return;
    }

    public static void d(String r1) {
        d(TAG, r1);
    }

    public static void d(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (mLevel > 3) goto L8;
        android.util.Log.d(r2, r3);
        return;
    }

    public static void d(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (mLevel > 3) goto L9;
        android.util.Log.d(r2, r3, r4);
        return;
    }

    public static void i(String r1) {
        i(TAG, r1);
    }

    public static void i(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (mLevel > 4) goto L8;
        android.util.Log.i(r2, r3);
        return;
    }

    public static void i(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (mLevel > 4) goto L9;
        android.util.Log.i(r2, r3, r4);
        return;
    }

    public static void w(String r1) {
        w(TAG, r1);
    }

    public static void w(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (mLevel > 5) goto L8;
        android.util.Log.w(r2, r3);
        return;
    }

    public static void w(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (mLevel > 5) goto L9;
        android.util.Log.w(r2, r3, r4);
        return;
    }

    public static void e(String r1) {
        e(TAG, r1);
    }

    public static void e(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (mLevel > 6) goto L8;
        android.util.Log.e(r2, r3);
        return;
    }

    public static void e(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (mLevel > 6) goto L9;
        android.util.Log.e(r2, r3, r4);
        return;
    }

    public static void st(String r5, int r6) {
    L4:
        e = move-exception;
        StackTraceElement[] r0 = e.getStackTrace();
        StringBuilder r1 = new StringBuilder();
        int r3 = 1;
    L7:
        if (r3 >= Math.min(r6, r0.length)) goto L11;
        if (r3 <= 1) goto L10;
        r1.append("\n");
    L10:
        r1.append(getSimpleClassName(r0[r3].getClassName()));
        r1.append(".");
        r1.append(r0[r3].getMethodName());
        r3 = r3 + 1;
        goto L7
    L11:
        v(r5, r1.toString());
        return;
    L3:
        throw new Exception();     // Catch: Exception -> L4
    }

    private static String getSimpleClassName(String r1) {
        int r0 = r1.lastIndexOf(46);
        if (r0 >= 0) goto L6;
        return r1;
    L6:
        return r1.substring(r0 + 1);
    }

    public static void throwException(Throwable r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        r2.printStackTrace();
        if (debug() == true) goto L8;
        return;
    L8:
        throw new RuntimeException("Error! Now in debug, we alert to you to correct it !", r2);
    }

    public static void alertErrorInfo(String r1) {
        if (debug() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException(r1);
    }
}
