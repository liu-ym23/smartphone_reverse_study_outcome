package com.obric.search.common.log;

import com.obric.search.common.log.impl.AndroidLogger;
import com.obric.search.common.log.intf.ILogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RuntimeLogger.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001#B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006JP\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u000626\u0010\u001c\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00180\u001dH\u0002J\u0016\u0010 \u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006J\u0016\u0010!\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006J\u0016\u0010\"\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006$"}, d2 = {"Lcom/obric/search/common/log/RuntimeLogger;", "", "()V", "MAX_LENGTH", "", "TAG_PREFIX", "", "<set-?>", "Lcom/obric/search/common/log/RuntimeLogger$LogLevel;", "logLevel", "getLogLevel", "()Lcom/obric/search/common/log/RuntimeLogger$LogLevel;", "setLogLevel", "(Lcom/obric/search/common/log/RuntimeLogger$LogLevel;)V", "logger", "Lcom/obric/search/common/log/intf/ILogger;", "getLogger", "()Lcom/obric/search/common/log/intf/ILogger;", "setLogger", "(Lcom/obric/search/common/log/intf/ILogger;)V", "canLog", "", "level", "debug", "", "tag", "message", "doLogWith", "logMethod", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "error", "info", "warn", "LogLevel", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RuntimeLogger {
    public static final RuntimeLogger INSTANCE = null;
    private static final int MAX_LENGTH = 2048;
    private static final String TAG_PREFIX = "SeSDK_";
    private static LogLevel logLevel;
    private static ILogger logger;

    /* JADX INFO: compiled from: RuntimeLogger.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/search/common/log/RuntimeLogger$LogLevel;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DEBUG", "INFO", "WARN", "ERROR", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum LogLevel extends Enum<LogLevel> {
        private static final /* synthetic */ LogLevel[] $VALUES = null;
        public static final LogLevel DEBUG = null;
        public static final LogLevel ERROR = null;
        public static final LogLevel INFO = null;
        public static final LogLevel WARN = null;
        private final int value;

        private static final /* synthetic */ LogLevel[] $values() {
            return new LogLevel[]{DEBUG, INFO, WARN, ERROR};
        }

        public static LogLevel valueOf(String r1) {
            return (LogLevel) Enum.valueOf(LogLevel.class, r1);
        }

        public static LogLevel[] values() {
            return (LogLevel[]) $VALUES.clone();
        }

        private LogLevel(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public final int getValue() {
            return this.value;
        }

        static {
            DEBUG = new LogLevel("DEBUG", 0, 0);
            INFO = new LogLevel("INFO", 1, 1);
            WARN = new LogLevel("WARN", 2, 2);
            ERROR = new LogLevel("ERROR", 3, 3);
            $VALUES = $values();
        }
    }

    private RuntimeLogger() {
    }

    static {
        INSTANCE = new RuntimeLogger();
        logger = new AndroidLogger();
        logLevel = LogLevel.DEBUG;
    }

    public final ILogger getLogger() {
        return logger;
    }

    public final void setLogger(ILogger r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        logger = r1;
    }

    public final synchronized LogLevel getLogLevel() {
        monitor-enter(this);
        LogLevel r0 = logLevel;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void setLogLevel(LogLevel r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "<set-?>");     // Catch: Throwable -> L6
        logLevel = r2;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void debug(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "message");
        if (canLog(LogLevel.DEBUG) == true) goto L5;
        return;
    L5:
        doLogWith(r2, r3, AnonymousClass1.INSTANCE);
    }

    public final void info(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "message");
        if (canLog(LogLevel.INFO) == true) goto L5;
        return;
    L5:
        doLogWith(r2, r3, C03221.INSTANCE);
    }

    public final void warn(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "message");
        if (canLog(LogLevel.WARN) == true) goto L5;
        return;
    L5:
        doLogWith(r2, r3, C03231.INSTANCE);
    }

    public final void error(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "message");
        if (canLog(LogLevel.ERROR) == true) goto L5;
        return;
    L5:
        doLogWith(r2, r3, C03211.INSTANCE);
    }

    private final boolean canLog(LogLevel r1) {
        if (r1.getValue() < logLevel.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    private final void doLogWith(String r3, String r4, Function2<? super String, ? super String, Unit> r5) {
        String r2 = TAG_PREFIX + r3;
        if (r4.length() > 2048) goto L6;
        r5.invoke(r2, r4);
        return;
    L6:
        int r6 = 0;
    L8:
        if (r6 >= r4.length()) goto L10;
        int r0 = r6 + 2048;
        String r7 = r4.substring(r6, Math.min(r0, r4.length()));
        Intrinsics.checkNotNullExpressionValue(r7, "this as java.lang.String…ing(startIndex, endIndex)");
        r5.invoke(r2, r7);
        r6 = r0;
        goto L8
    }
}
