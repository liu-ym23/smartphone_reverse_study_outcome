package com.bytedance.apm6.util.log;

import android.util.Log;
import com.bytedance.apm6.util.ApmBaseContext;

/* JADX INFO: loaded from: classes3.dex */
public class Logger {
    private static ILogger sApmLogImp;

    public static class DefaultLogger implements ILogger {
        public DefaultLogger() {
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void v(String r1, String r2) {
            if (ApmBaseContext.isDebugMode() == false) goto L6;
            Log.v(r1, r2);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void d(String r1, String r2) {
            if (ApmBaseContext.isDebugMode() == false) goto L6;
            Log.d(r1, r2);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void i(String r1, String r2) {
            if (ApmBaseContext.isDebugMode() == false) goto L6;
            Log.i(r1, r2);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void w(String r1, String r2) {
            if (ApmBaseContext.isDebugMode() == false) goto L6;
            Log.w(r1, r2);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void w(String r1, String r2, Throwable r3) {
            if (ApmBaseContext.isDebugMode() == false) goto L6;
            Log.w(r1, r2, r3);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void e(String r1, String r2) {
            if (ApmBaseContext.isDebugMode() == false) goto L6;
            Log.e(r1, r2);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void e(String r1, String r2, Throwable r3) {
            if (ApmBaseContext.isDebugMode() == false) goto L6;
            Log.e(r1, r2, r3);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void wtf(String r1, String r2) {
            if (ApmBaseContext.isDebugMode() == false) goto L6;
            Log.wtf(r1, r2);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void wtf(String r1, String r2, Throwable r3) {
            if (ApmBaseContext.isDebugMode() == false) goto L6;
            Log.e(r1, r2, r3);
            return;
        }
    }

    static {
        sApmLogImp = new DefaultLogger();
    }

    private Logger() {
    }

    public static void setLoggerImpl(ILogger r0) {
        sApmLogImp = r0;
    }

    public static void v(String r1, String r2) {
        ILogger r0 = sApmLogImp;
        if (r0 == null) goto L6;
        r0.v(r1, r2);
        return;
    }

    public static void d(String r1, String r2) {
        ILogger r0 = sApmLogImp;
        if (r0 == null) goto L6;
        r0.d(r1, r2);
        return;
    }

    public static void i(String r1, String r2) {
        ILogger r0 = sApmLogImp;
        if (r0 == null) goto L6;
        r0.i(r1, r2);
        return;
    }

    public static void w(String r1, String r2) {
        ILogger r0 = sApmLogImp;
        if (r0 == null) goto L6;
        r0.w(r1, r2);
        return;
    }

    public static void w(String r1, String r2, Throwable r3) {
        ILogger r0 = sApmLogImp;
        if (r0 == null) goto L6;
        r0.w(r1, r2, r3);
        return;
    }

    public static void e(String r1, String r2) {
        ILogger r0 = sApmLogImp;
        if (r0 == null) goto L6;
        r0.e(r1, r2);
        return;
    }

    public static void e(String r1, String r2, Throwable r3) {
        ILogger r0 = sApmLogImp;
        if (r0 == null) goto L6;
        r0.e(r1, r2, r3);
        return;
    }

    public static void wtf(String r1, String r2) {
        ILogger r0 = sApmLogImp;
        if (r0 == null) goto L6;
        r0.e(r1, r2);
        return;
    }

    public static void wtf(String r1, String r2, Throwable r3) {
        ILogger r0 = sApmLogImp;
        if (r0 == null) goto L6;
        r0.e(r1, r2, r3);
        return;
    }
}
