package org.greenrobot.eventbus;

import android.util.Log;
import com.obric.hook.lancet.LogLancet;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes6.dex */
public interface Logger {

    public static class AndroidLogger implements Logger {
        static final boolean ANDROID_LOG_AVAILABLE = false;
        private final String tag;

        static {
            boolean r0 = false;
            if (Class.forName(LogLancet.TARGET_CLASS) == null) goto L6;
            r0 = true;
        L6:
            ANDROID_LOG_AVAILABLE = r0;
        }

        public static boolean isAndroidLogAvailable() {
            return ANDROID_LOG_AVAILABLE;
        }

        public AndroidLogger(String r1) {
            this.tag = r1;
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(Level r2, String r3) {
            if (r2 == Level.OFF) goto L6;
            Log.println(mapLevel(r2), this.tag, r3);
            return;
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(Level r2, String r3, Throwable r4) {
            if (r2 == Level.OFF) goto L6;
            Log.println(mapLevel(r2), this.tag, r3 + "\n" + Log.getStackTraceString(r4));
            return;
        }

        protected int mapLevel(Level r1) {
            int r0 = r1.intValue();
            if (r0 >= 800) goto L11;
            if (r0 >= 500) goto L8;
            return 2;
        L8:
            return 3;
        L11:
            if (r0 >= 900) goto L15;
            return 4;
        L15:
            if (r0 >= 1000) goto L18;
            return 5;
        L18:
            return 6;
        }
    }

    public static class JavaLogger implements Logger {
        protected final java.util.logging.Logger logger;

        public JavaLogger(String r1) {
            this.logger = java.util.logging.Logger.getLogger(r1);
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(Level r1, String r2) {
            this.logger.log(r1, r2);
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(Level r1, String r2, Throwable r3) {
            this.logger.log(r1, r2, r3);
        }
    }

    public static class SystemOutLogger implements Logger {
        public SystemOutLogger() {
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(Level r3, String r4) {
            System.out.println("[" + r3 + "] " + r4);
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(Level r3, String r4, Throwable r5) {
            System.out.println("[" + r3 + "] " + r4);
            r5.printStackTrace(System.out);
        }
    }

    void log(Level r1, String r2);

    void log(Level r1, String r2, Throwable r3);
}
