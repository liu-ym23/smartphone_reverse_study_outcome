package androidx.work;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class Logger {
    private static final int MAX_PREFIXED_TAG_LENGTH = 20;
    private static final int MAX_TAG_LENGTH = 23;
    private static final String TAG_PREFIX = "WM-";
    private static final Object sLock = null;
    private static volatile Logger sLogger;

    public static class LogcatLogger extends Logger {
        private final int mLoggingLevel;

        public LogcatLogger(int loggingLevel) {
            super(loggingLevel);
            this.mLoggingLevel = loggingLevel;
        }

        @Override // androidx.work.Logger
        public void verbose(String tag, String message) {
            if (this.mLoggingLevel > 2) goto L6;
            Log.v(tag, message);
            return;
        }

        @Override // androidx.work.Logger
        public void verbose(String tag, String message, Throwable throwable) {
            if (this.mLoggingLevel > 2) goto L6;
            Log.v(tag, message, throwable);
            return;
        }

        @Override // androidx.work.Logger
        public void debug(String tag, String message) {
            if (this.mLoggingLevel > 3) goto L6;
            Log.d(tag, message);
            return;
        }

        @Override // androidx.work.Logger
        public void debug(String tag, String message, Throwable throwable) {
            if (this.mLoggingLevel > 3) goto L6;
            Log.d(tag, message, throwable);
            return;
        }

        @Override // androidx.work.Logger
        public void info(String tag, String message) {
            if (this.mLoggingLevel > 4) goto L6;
            Log.i(tag, message);
            return;
        }

        @Override // androidx.work.Logger
        public void info(String tag, String message, Throwable throwable) {
            if (this.mLoggingLevel > 4) goto L6;
            Log.i(tag, message, throwable);
            return;
        }

        @Override // androidx.work.Logger
        public void warning(String tag, String message) {
            if (this.mLoggingLevel > 5) goto L6;
            Log.w(tag, message);
            return;
        }

        @Override // androidx.work.Logger
        public void warning(String tag, String message, Throwable throwable) {
            if (this.mLoggingLevel > 5) goto L6;
            Log.w(tag, message, throwable);
            return;
        }

        @Override // androidx.work.Logger
        public void error(String tag, String message) {
            if (this.mLoggingLevel > 6) goto L6;
            Log.e(tag, message);
            return;
        }

        @Override // androidx.work.Logger
        public void error(String tag, String message, Throwable throwable) {
            if (this.mLoggingLevel > 6) goto L6;
            Log.e(tag, message, throwable);
            return;
        }
    }

    public abstract void debug(String tag, String message);

    public abstract void debug(String tag, String message, Throwable throwable);

    public abstract void error(String tag, String message);

    public abstract void error(String tag, String message, Throwable throwable);

    public abstract void info(String tag, String message);

    public abstract void info(String tag, String message, Throwable throwable);

    public abstract void verbose(String tag, String message);

    public abstract void verbose(String tag, String message, Throwable throwable);

    public abstract void warning(String tag, String message);

    public abstract void warning(String tag, String message, Throwable throwable);

    static {
        sLock = new Object();
    }

    public static void setLogger(Logger logger) {
        Object r0 = sLock;
        monitor-enter(r0);
        sLogger = logger;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static String tagWithPrefix(String tag) {
        int r0 = tag.length();
        StringBuilder r1 = new StringBuilder(23);
        r1.append(TAG_PREFIX);
        int r2 = MAX_PREFIXED_TAG_LENGTH;
        if (r0 < r2) goto L5;
        r1.append(tag.substring(0, r2));
    L7:
        return r1.toString();
    L5:
        r1.append(tag);
        goto L7
    }

    public static Logger get() {
        Object r0 = sLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sLogger != null) goto L7;
        sLogger = new LogcatLogger(3);     // Catch: Throwable -> L10
    L7:
        Logger r1 = sLogger;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    }

    public Logger(int loggingLevel) {
    }
}
