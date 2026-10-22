package okhttp3.internal.platform.android;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AndroidLogHandler extends Handler {
    public static final AndroidLogHandler INSTANCE = null;

    static {
        INSTANCE = new AndroidLogHandler();
    }

    private AndroidLogHandler() {
    }

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }

    @Override // java.util.logging.Handler
    public void publish(@NotNull LogRecord r5) {
        Intrinsics.f(r5, "record");
        AndroidLog r4 = AndroidLog.INSTANCE;
        String r0 = r5.getLoggerName();
        Intrinsics.e(r0, "record.loggerName");
        int r1 = AndroidLogKt.access$getAndroidLevel$p(r5);
        String r2 = r5.getMessage();
        Intrinsics.e(r2, "record.message");
        r4.androidLog$okhttp(r0, r1, r2, r5.getThrown());
    }
}
