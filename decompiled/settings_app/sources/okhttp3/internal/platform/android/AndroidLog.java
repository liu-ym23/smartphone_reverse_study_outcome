package okhttp3.internal.platform.android;

import android.util.Log;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2;

/* JADX INFO: compiled from: AndroidLog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0002\b\u0012J\u0006\u0010\u0013\u001a\u00020\fJ\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lokhttp3/internal/platform/android/AndroidLog;", "", "()V", "MAX_LOG_LENGTH", "", "configuredLoggers", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/logging/Logger;", "knownLoggers", "", "", "androidLog", "", "loggerName", "logLevel", "message", "t", "", "androidLog$okhttp", "enable", "enableLogging", "logger", "tag", "loggerTag", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AndroidLog {
    public static final AndroidLog INSTANCE = null;
    private static final int MAX_LOG_LENGTH = 4000;
    private static final CopyOnWriteArraySet<Logger> configuredLoggers = null;
    private static final Map<String, String> knownLoggers = null;

    private AndroidLog() {
    }

    static {
        INSTANCE = new AndroidLog();
        configuredLoggers = new CopyOnWriteArraySet();
        LinkedHashMap r0 = new LinkedHashMap();
        Package r1 = OkHttpClient.class.getPackage();
        if (r1 != null) goto L5;
        String r2 = null;
    L6:
        if (r2 == null) goto L8;
        r0.put(r2, "OkHttp");
    L8:
        LinkedHashMap r3 = r0;
        String r4 = OkHttpClient.class.getName();
        Intrinsics.checkNotNullExpressionValue(r4, "OkHttpClient::class.java.name");
        r3.put(r4, "okhttp.OkHttpClient");
        String r5 = Http2.class.getName();
        Intrinsics.checkNotNullExpressionValue(r5, "Http2::class.java.name");
        r3.put(r5, "okhttp.Http2");
        String r6 = TaskRunner.class.getName();
        Intrinsics.checkNotNullExpressionValue(r6, "TaskRunner::class.java.name");
        r3.put(r6, "okhttp.TaskRunner");
        r3.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        knownLoggers = MapsKt.toMap(r3);
        return;
    L5:
        r2 = r1.getName();
        goto L6
    }

    public final void androidLog$okhttp(String r7, int r8, String r9, Throwable r10) {
        Intrinsics.checkNotNullParameter(r7, "loggerName");
        Intrinsics.checkNotNullParameter(r9, "message");
        String r6 = loggerTag(r7);
        if (Log.isLoggable(r6, r8) == false) goto L16;
        if (r10 == null) goto L6;
        r9 = r9 + '\n' + Log.getStackTraceString(r10);
    L6:
        int r11 = r9.length();
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L20;
        int r0 = StringsKt.indexOf$default(r9, '\n', r12, false, 4, null);
        if (r0 != (-1)) goto L12;
        r0 = r11;
    L12:
        int r1 = Math.min(r0, r12 + MAX_LOG_LENGTH);
        String r13 = r9.substring(r12, r1);
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String…ing(startIndex, endIndex)");
        Log.println(r8, r6, r13);
        if (r1 >= r0) goto L14;
        r12 = r1;
        goto L12
    L14:
        r12 = r1 + 1;
        goto L7
    L20:
        return;
    }

    private final String loggerTag(String r1) {
        String r0 = knownLoggers.get(r1);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return StringsKt.take(r1, 23);
    }

    public final void enable() {
        Iterator<Map.Entry<String, String>> r0 = knownLoggers.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<String, String> r1 = r0.next();
        enableLogging(r1.getKey(), r1.getValue());
        goto L4
    }

    private final void enableLogging(String r1, String r2) {
        Logger r0 = Logger.getLogger(r1);
        if (configuredLoggers.add(r0) == false) goto L13;
        r0.setUseParentHandlers(false);
        if (Log.isLoggable(r2, 3) == false) goto L8;
        Level r3 = Level.FINE;
    L11:
        r0.setLevel(r3);
        r0.addHandler(AndroidLogHandler.INSTANCE);
        return;
    L8:
        if (Log.isLoggable(r2, 4) == false) goto L10;
        r3 = Level.INFO;
        goto L11
    L10:
        r3 = Level.WARNING;
        goto L11
    }
}
