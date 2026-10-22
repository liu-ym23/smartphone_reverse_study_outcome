package okhttp3.internal.platform.android;

import a.a;
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
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@SuppressSignatureCheck
@Metadata
public final class AndroidLog {
    public static final AndroidLog INSTANCE = null;
    private static final int MAX_LOG_LENGTH = 4000;
    private static final CopyOnWriteArraySet<Logger> configuredLoggers = null;
    private static final Map<String, String> knownLoggers = null;

    static {
        INSTANCE = new AndroidLog();
        configuredLoggers = new CopyOnWriteArraySet();
        LinkedHashMap r0 = new LinkedHashMap();
        Package r2 = OkHttpClient.class.getPackage();
        if (r2 == null) goto L5;
        String r3 = r2.getName();
    L6:
        if (r3 == null) goto L8;
        r0.put(r3, "OkHttp");
    L8:
        r0.put(OkHttpClient.class.getName(), "okhttp.OkHttpClient");
        r0.put(Http2.class.getName(), "okhttp.Http2");
        r0.put(TaskRunner.class.getName(), "okhttp.TaskRunner");
        r0.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        knownLoggers = MapsKt.g(r0);
        return;
    L5:
        r3 = null;
        goto L6
    }

    private AndroidLog() {
    }

    private final void enableLogging(String r1, String r2) {
        Logger r0 = Logger.getLogger(r1);
        if (configuredLoggers.add(r0) == false) goto L13;
        Intrinsics.e(r0, "logger");
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

    private final String loggerTag(String r2) {
        String r1 = knownLoggers.get(r2);
        if (r1 != null) goto L11;
        Intrinsics.f(r2, "<this>");
        int r3 = r2.length();
        if (23 > r3) goto L9;
        r3 = 23;
    L9:
        String r4 = r2.substring(0, r3);
        Intrinsics.e(r4, "this as java.lang.String…ing(startIndex, endIndex)");
        return r4;
    L11:
        return r1;
    }

    public final void androidLog$okhttp(@NotNull String r5, int r6, @NotNull String r7, @Nullable Throwable r8) {
        Intrinsics.f(r5, "loggerName");
        Intrinsics.f(r7, "message");
        String r4 = loggerTag(r5);
        if (Log.isLoggable(r4, r6) == false) goto L16;
        if (r8 == null) goto L6;
        StringBuilder r9 = a.t(r7, "\n");
        r9.append(Log.getStackTraceString(r8));
        r7 = r9.toString();
    L6:
        int r10 = r7.length();
        int r0 = 0;
    L7:
        if (r0 >= r10) goto L20;
        int r1 = StringsKt.r(r7, '\n', r0, false, 4);
        if (r1 != (-1)) goto L12;
        r1 = r10;
    L12:
        int r2 = Math.min(r1, r0 + MAX_LOG_LENGTH);
        String r3 = r7.substring(r0, r2);
        Intrinsics.e(r3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Log.println(r6, r4, r3);
        if (r2 >= r1) goto L14;
        r0 = r2;
        goto L12
    L14:
        r0 = r2 + 1;
        goto L7
    L20:
        return;
    }

    public final void enable() {
        Iterator<Map.Entry<String, String>> r0 = knownLoggers.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<String, String> r1 = r0.next();
        enableLogging(r1.getKey(), r1.getValue());
        goto L4
    }
}
