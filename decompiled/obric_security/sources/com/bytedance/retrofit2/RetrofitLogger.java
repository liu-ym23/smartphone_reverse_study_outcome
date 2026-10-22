package com.bytedance.retrofit2;

import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes.dex */
public class RetrofitLogger {
    private static final String TAG = "Logger";
    static int mLevel = 4;
    static ILogWritter sLogWritter;

    public static abstract class ILogWritter {
        public void logE(String r1, String r2) {
        }

        public void logE(String r1, String r2, Throwable r3) {
        }

        public void logI(String r1, String r2) {
        }

        public void logI(String r1, String r2, Throwable r3) {
        }

        public void logK(String r1, String r2) {
        }

        public void logW(String r1, String r2) {
        }

        public void logW(String r1, String r2, Throwable r3) {
        }

        public ILogWritter() {
        }
    }

    static {
    }

    public RetrofitLogger() {
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
        Log.v(r2, r3);
        return;
    }

    public static void v(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (mLevel > 2) goto L9;
        Log.v(r2, r3, r4);
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
        Log.d(r2, r3);
        return;
    }

    public static void d(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (mLevel > 3) goto L9;
        Log.d(r2, r3, r4);
        return;
    }

    public static void i(String r1) {
        i(TAG, r1);
    }

    public static void i(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (mLevel > 4) goto L7;
        Log.i(r2, r3);
    L7:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L11;
        r0.logI(r2, r3);
        return;
    }

    public static void i(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (mLevel > 4) goto L8;
        Log.i(r2, r3, r4);
    L8:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L12;
        r0.logI(r2, r3, r4);
        return;
    }

    public static void w(String r1) {
        w(TAG, r1);
    }

    public static void w(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (mLevel > 5) goto L7;
        Log.w(r2, r3);
    L7:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L11;
        r0.logW(r2, r3);
        return;
    }

    public static void w(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (mLevel > 5) goto L8;
        Log.w(r2, r3, r4);
    L8:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L12;
        r0.logW(r2, r3, r4);
        return;
    }

    public static void e(String r1) {
        e(TAG, r1);
    }

    public static void e(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (mLevel > 6) goto L7;
        Log.e(r2, r3);
    L7:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L11;
        r0.logE(r2, r3);
        return;
    }

    public static void e(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (mLevel > 6) goto L8;
        Log.e(r2, r3, r4);
    L8:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L12;
        r0.logE(r2, r3, r4);
        return;
    }

    public static void k(String r1) {
        k(TAG, r1);
    }

    public static void k(String r2, String r3) {
        if (mLevel > 3) goto L5;
        Log.d(r2, r3);
    L5:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L9;
        r0.logK(r2, r3);
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
        r1.append(IOUtils.LINE_SEPARATOR_UNIX);
    L10:
        r1.append(getSimpleClassName(r0[r3].getClassName()));
        r1.append(LibrarianImpl.Constants.DOT);
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

    public static void registerLogHandler(ILogWritter r0) {
        sLogWritter = r0;
    }
}
