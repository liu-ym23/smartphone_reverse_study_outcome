package okhttp3.internal.platform.android;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidLog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lokhttp3/internal/platform/android/AndroidLogHandler;", "Ljava/util/logging/Handler;", "()V", "close", "", "flush", "publish", "record", "Ljava/util/logging/LogRecord;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AndroidLogHandler extends Handler {
    public static final AndroidLogHandler INSTANCE = null;

    static {
        INSTANCE = new AndroidLogHandler();
    }

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }

    private AndroidLogHandler() {
    }

    @Override // java.util.logging.Handler
    public void publish(LogRecord r5) {
        Intrinsics.checkNotNullParameter(r5, "record");
        AndroidLog r4 = AndroidLog.INSTANCE;
        String r0 = r5.getLoggerName();
        Intrinsics.checkNotNullExpressionValue(r0, "record.loggerName");
        int r1 = AndroidLogKt.access$getAndroidLevel(r5);
        String r2 = r5.getMessage();
        Intrinsics.checkNotNullExpressionValue(r2, "record.message");
        r4.androidLog$okhttp(r0, r1, r2, r5.getThrown());
    }
}
