package com.bytedance.bdinstall;

import com.bytedance.bdinstall.util.LocalConstants;
import com.ss.android.agilelogger.ALog;

/* JADX INFO: loaded from: classes3.dex */
public class DrLog {
    public static boolean DEBUG = false;
    public static final int SDK_VERSION_CODE = 0;
    static final String TAG = "DrLog";
    private static final String USNP = "U SHALL NOT PASS!";
    private static ILogger logger;

    private static class ALogLogger implements ILogger {
        private boolean mEnable;

        private ALogLogger() {
            this.mEnable = true;
        }

        /* synthetic */ ALogLogger(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.bdinstall.ILogger
        public void v(String r1, Throwable r2) {
            if (this.mEnable == true) goto L9;
            return;
        L9:
            ALog.i(DrLog.TAG, r1);     // Catch: Throwable -> L7
            return;
        L7:
            this.mEnable = false;
        }

        @Override // com.bytedance.bdinstall.ILogger
        public void d(String r1, Throwable r2) {
            if (this.mEnable == true) goto L9;
            return;
        L9:
            ALog.i(DrLog.TAG, r1);     // Catch: Throwable -> L7
            return;
        L7:
            this.mEnable = false;
        }

        @Override // com.bytedance.bdinstall.ILogger
        public void w(String r1, Throwable r2) {
            if (this.mEnable == true) goto L9;
            return;
        L9:
            ALog.w(DrLog.TAG, r1);     // Catch: Throwable -> L7
            return;
        L7:
            this.mEnable = false;
        }

        @Override // com.bytedance.bdinstall.ILogger
        public void i(String r1, Throwable r2) {
            if (this.mEnable == true) goto L9;
            return;
        L9:
            ALog.i(DrLog.TAG, r1);     // Catch: Throwable -> L7
            return;
        L7:
            this.mEnable = false;
        }

        @Override // com.bytedance.bdinstall.ILogger
        public void e(String r1, Throwable r2) {
            if (this.mEnable == true) goto L9;
            return;
        L9:
            ALog.e(DrLog.TAG, r1);     // Catch: Throwable -> L7
            return;
        L7:
            this.mEnable = false;
        }
    }

    public DrLog() {
    }

    static {
        SDK_VERSION_CODE = LocalConstants.getVersionCode();
        logger = new AnonymousClass1();
    }

    static void setLogger(ILogger r0) {
        logger = r0;
    }

    public static void d(String r2) {
        logger.d(r2, null);
    }

    public static void w(String r1, Throwable r2) {
        logger.w(r1, r2);
    }

    public static void e(String r1, Throwable r2) {
        logger.e(r1, r2);
    }

    public static void i(String r1, Throwable r2) {
        logger.i(r1, r2);
    }

    public static void v(String r1, Throwable r2) {
        logger.v(r1, r2);
    }

    public static void ysnp(Throwable r2) {
        logger.e(null, r2);
    }

    public static boolean debug() {
        return DEBUG;
    }

    public static void v(String r2) {
        logger.v(r2, null);
    }

    public static void e(String r2) {
        logger.e(r2, null);
    }
}
