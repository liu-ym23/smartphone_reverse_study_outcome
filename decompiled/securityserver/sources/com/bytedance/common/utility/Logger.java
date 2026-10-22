package com.bytedance.common.utility;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class Logger {
    private static final String TAG = "Logger";
    private static int mLevel = 4;
    private static ILogWritter sLogWriter;

    /* JADX INFO: renamed from: com.bytedance.common.utility.Logger$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class DefaultLogHandler extends ILogWritter {

        public static class SingletonHolder {
            private static final DefaultLogHandler INSTANCE = null;

            static {
                INSTANCE = new DefaultLogHandler(null);
            }

            private SingletonHolder() {
            }

            public static /* synthetic */ DefaultLogHandler access$000() {
                return INSTANCE;
            }
        }

        public /* synthetic */ DefaultLogHandler(AnonymousClass1 r1) {
            this();
        }

        public static DefaultLogHandler getInstance() {
            return SingletonHolder.access$000();
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logD(String r1, String r2) {
            Log.d(r1, r2);
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logE(String r1, String r2, Throwable r3) {
            Log.e(r1, r2, r3);
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logI(String r1, String r2) {
            Log.i(r1, r2);
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logV(String r1, String r2) {
            Log.v(r1, r2);
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logW(String r1, String r2) {
            Log.w(r1, r2);
        }

        private DefaultLogHandler() {
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logD(String r1, String r2, Throwable r3) {
            Log.d(r1, r2, r3);
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logE(String r1, String r2) {
            Log.e(r1, r2);
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logI(String r1, String r2, Throwable r3) {
            Log.i(r1, r2, r3);
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logV(String r1, String r2, Throwable r3) {
            Log.v(r1, r2, r3);
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logW(String r1, String r2, Throwable r3) {
            Log.w(r1, r2, r3);
        }
    }

    public static abstract class ILogWritter extends com.bytedance.android.standard.tools.logging.Logger.ILogWritter {
        public ILogWritter() {
        }

        @Override // com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public boolean isLoggable(int r1) {
            if (Logger.getLogLevel() > r1) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logD(String r1, String r2) {
        }

        @Override // com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logE(String r1, String r2) {
        }

        @Override // com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logI(String r1, String r2) {
        }

        @Override // com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logK(String r1, String r2) {
        }

        @Override // com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logV(String r1, String r2) {
        }

        @Override // com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logW(String r1, String r2) {
        }

        @Override // com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logD(String r1, String r2, Throwable r3) {
        }

        @Override // com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logE(String r1, String r2, Throwable r3) {
        }

        @Override // com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logI(String r1, String r2, Throwable r3) {
        }

        @Override // com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logV(String r1, String r2, Throwable r3) {
        }

        @Override // com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logW(String r1, String r2, Throwable r3) {
        }
    }

    static {
        sLogWriter = DefaultLogHandler.getInstance();
    }

    public Logger() {
    }

    public static void alertErrorInfo(String r0) {
        com.bytedance.android.standard.tools.logging.Logger.alertErrorInfo(r0);
    }

    public static void d(String r0) {
        com.bytedance.android.standard.tools.logging.Logger.d(r0);
    }

    public static boolean debug() {
        return com.bytedance.android.standard.tools.logging.Logger.debug();
    }

    public static void e(String r0) {
        com.bytedance.android.standard.tools.logging.Logger.e(r0);
    }

    public static int getLogLevel() {
        return com.bytedance.android.standard.tools.logging.Logger.getLogLevel();
    }

    private static String getSimpleClassName(String r1) {
        int r0 = r1.lastIndexOf(46);
        if (r0 >= 0) goto L6;
        return r1;
    L6:
        return r1.substring(r0 + 1);
    }

    public static void i(String r0) {
        com.bytedance.android.standard.tools.logging.Logger.i(r0);
    }

    @Deprecated
    public static void k(String r0) {
        com.bytedance.android.standard.tools.logging.Logger.k(r0);
    }

    public static void registerLogHandler(ILogWritter r0) {
        com.bytedance.android.standard.tools.logging.Logger.registerLogHandler(r0);
    }

    public static void setLogLevel(int r0) {
        com.bytedance.android.standard.tools.logging.Logger.setLogLevel(r0);
    }

    public static void st(String r0, int r1) {
        com.bytedance.android.standard.tools.logging.Logger.st(r0, r1);
    }

    public static void throwException(Throwable r0) {
        com.bytedance.android.standard.tools.logging.Logger.throwException(r0);
    }

    public static void v(String r0) {
        com.bytedance.android.standard.tools.logging.Logger.v(r0);
    }

    public static void w(String r0) {
        com.bytedance.android.standard.tools.logging.Logger.w(r0);
    }

    public static void d(String r0, String r1) {
        com.bytedance.android.standard.tools.logging.Logger.d(r0, r1);
    }

    public static void e(String r0, String r1) {
        com.bytedance.android.standard.tools.logging.Logger.e(r0, r1);
    }

    public static void i(String r0, String r1) {
        com.bytedance.android.standard.tools.logging.Logger.i(r0, r1);
    }

    @Deprecated
    public static void k(String r0, String r1) {
        com.bytedance.android.standard.tools.logging.Logger.k(r0, r1);
    }

    public static void v(String r0, String r1) {
        com.bytedance.android.standard.tools.logging.Logger.v(r0, r1);
    }

    public static void w(String r0, String r1) {
        com.bytedance.android.standard.tools.logging.Logger.w(r0, r1);
    }

    public static void d(String r0, String r1, Throwable r2) {
        com.bytedance.android.standard.tools.logging.Logger.d(r0, r1, r2);
    }

    public static void e(String r0, String r1, Throwable r2) {
        com.bytedance.android.standard.tools.logging.Logger.e(r0, r1, r2);
    }

    public static void i(String r0, String r1, Throwable r2) {
        com.bytedance.android.standard.tools.logging.Logger.i(r0, r1, r2);
    }

    public static void v(String r0, String r1, Throwable r2) {
        com.bytedance.android.standard.tools.logging.Logger.v(r0, r1, r2);
    }

    public static void w(String r0, String r1, Throwable r2) {
        com.bytedance.android.standard.tools.logging.Logger.w(r0, r1, r2);
    }
}
