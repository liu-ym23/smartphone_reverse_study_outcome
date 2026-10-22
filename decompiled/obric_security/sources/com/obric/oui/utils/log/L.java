package com.obric.oui.utils.log;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.obric.oui.calendar.format.DayFormatter;
import com.obric.oui.material.MaterialConfigBuilder;
import com.ss.android.message.log.PushLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: L.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001&B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J(\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015H\u0086\bø\u0001\u0000J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J\"\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u001a\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J(\u0010\u0016\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015H\u0086\bø\u0001\u0000J\b\u0010\u0018\u001a\u00020\u0012H\u0007J\u0006\u0010\u0019\u001a\u00020\u000eJ\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J(\u0010\u001a\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015H\u0086\bø\u0001\u0000J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004J\u001e\u0010\u001e\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0007J8\u0010\u001f\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0017H\u0086\bø\u0001\u0000J8\u0010!\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\"\u001a\u00020\u001cH\u0002J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J(\u0010$\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015H\u0086\bø\u0001\u0000J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J\u0018\u0010%\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J\"\u0010%\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u001a\u0010%\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J(\u0010%\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015H\u0086\bø\u0001\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006'"}, d2 = {"Lcom/obric/oui/utils/log/L;", "", "()V", "ABOVE_VERBOSE", "", "BASE_TAG", "", "D", ExifInterface.LONGITUDE_EAST, "I", "JSON_INDENT", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "androidLogger", "Lcom/obric/oui/utils/log/L$Logger;", "impl", "logLevelMask", DayFormatter.DEFAULT_FORMAT, "", NotificationCompat.CATEGORY_MESSAGE, PushLog.KEY_TAG, "Lkotlin/Function0;", "e", "", "flush", "getImpl", "i", "isBlocked", "", "level", MaterialConfigBuilder.SERIALIZATION_FORMAT_JSON, "log", "t", "log0", "splitLines", "setImpl", BaseSwitches.V, "w", "Logger", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class L {
    private static final int ABOVE_VERBOSE = 31;
    private static final String BASE_TAG = "OUI_SDK";
    public static final int D = 2;
    public static final int E = 16;
    public static final int I = 4;
    public static final L INSTANCE = null;
    private static final int JSON_INDENT = 2;
    public static final int V = 1;
    public static final int W = 8;
    private static final Logger androidLogger = null;
    private static Logger impl;
    private static int logLevelMask;

    /* JADX INFO: compiled from: L.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J.\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, d2 = {"Lcom/obric/oui/utils/log/L$Logger;", "", "flush", "", "writeLog", PushLog.KEY_TAG, "", "level", "", NotificationCompat.CATEGORY_MESSAGE, "e", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Logger {

        /* JADX INFO: compiled from: L.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void flush(Logger r1) {
                Intrinsics.checkNotNullParameter(r1, "this");
            }

            public static /* synthetic */ void writeLog$default(Logger r0, String r1, int r2, String r3, Throwable r4, int r5, Object r6) {
                if (r6 != null) goto L9;
                if ((r5 & 8) == 0) goto L6;
                r4 = null;
            L6:
                r0.writeLog(r1, r2, r3, r4);
                return;
            L9:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeLog");
            }
        }

        void flush();

        void writeLog(String r1, int r2, String r3, Throwable r4);
    }

    private L() {
    }

    static {
        INSTANCE = new L();
        androidLogger = new AndroidLogger(BASE_TAG, false, 2, null);
        logLevelMask = 31;
    }

    @JvmStatic
    public static final void setImpl(Logger r1) {
        Intrinsics.checkNotNullParameter(r1, "impl");
        impl = r1;
    }

    public final Logger getImpl() {
        Logger r0 = impl;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return androidLogger;
    }

    @JvmStatic
    public static final void flush() {
        L r8 = INSTANCE;
        log0$default(r8, null, 4, "flush!", null, false, 24, null);
        r8.getImpl().flush();
    }

    public static /* synthetic */ void v$default(L r1, String r2, Function0 r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L5;
        r2 = null;
    L5:
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        if (r1.isBlocked(1) == true) goto L10;
        r1.getImpl().writeLog(r2, 1, (String) r3.invoke(), null);
        return;
    }

    public static /* synthetic */ void d$default(L r1, String r2, Function0 r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L5;
        r2 = null;
    L5:
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        if (r1.isBlocked(2) == true) goto L10;
        r1.getImpl().writeLog(r2, 2, (String) r3.invoke(), null);
        return;
    }

    public static /* synthetic */ void i$default(L r1, String r2, Function0 r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L5;
        r2 = null;
    L5:
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        if (r1.isBlocked(4) == true) goto L10;
        r1.getImpl().writeLog(r2, 4, (String) r3.invoke(), null);
        return;
    }

    public static /* synthetic */ void w$default(L r1, String r2, Function0 r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L5;
        r2 = null;
    L5:
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        if (r1.isBlocked(8) == true) goto L10;
        r1.getImpl().writeLog(r2, 8, (String) r3.invoke(), null);
        return;
    }

    public static /* synthetic */ void e$default(L r1, String r2, Function0 r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L5;
        r2 = null;
    L5:
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        if (r1.isBlocked(16) == true) goto L10;
        r1.getImpl().writeLog(r2, 16, (String) r3.invoke(), null);
        return;
    }

    @JvmStatic
    public static final void v(String r9) {
        Intrinsics.checkNotNullParameter(r9, NotificationCompat.CATEGORY_MESSAGE);
        log0$default(INSTANCE, null, 1, r9, null, false, 24, null);
    }

    @JvmStatic
    public static final void d(String r9) {
        Intrinsics.checkNotNullParameter(r9, NotificationCompat.CATEGORY_MESSAGE);
        log0$default(INSTANCE, null, 2, r9, null, false, 24, null);
    }

    @JvmStatic
    public static final void i(String r9) {
        Intrinsics.checkNotNullParameter(r9, NotificationCompat.CATEGORY_MESSAGE);
        log0$default(INSTANCE, null, 4, r9, null, false, 24, null);
    }

    @JvmStatic
    public static final void w(String r9) {
        Intrinsics.checkNotNullParameter(r9, NotificationCompat.CATEGORY_MESSAGE);
        log0$default(INSTANCE, null, 8, r9, null, false, 24, null);
    }

    @JvmStatic
    public static final void w(String r9, Throwable r10) {
        Intrinsics.checkNotNullParameter(r9, NotificationCompat.CATEGORY_MESSAGE);
        log0$default(INSTANCE, null, 8, r9, r10, false, 16, null);
    }

    @JvmStatic
    public static final void e(String r9) {
        Intrinsics.checkNotNullParameter(r9, NotificationCompat.CATEGORY_MESSAGE);
        log0$default(INSTANCE, null, 16, r9, null, false, 24, null);
    }

    @JvmStatic
    public static final void e(String r9, Throwable r10) {
        Intrinsics.checkNotNullParameter(r9, NotificationCompat.CATEGORY_MESSAGE);
        log0$default(INSTANCE, null, 16, r9, r10, false, 16, null);
    }

    @JvmStatic
    public static final void v(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_MESSAGE);
        log0$default(INSTANCE, r9, 1, r10, null, false, 24, null);
    }

    @JvmStatic
    public static final void d(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_MESSAGE);
        log0$default(INSTANCE, r9, 2, r10, null, false, 24, null);
    }

    @JvmStatic
    public static final void i(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_MESSAGE);
        log0$default(INSTANCE, r9, 4, r10, null, false, 24, null);
    }

    @JvmStatic
    public static final void w(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_MESSAGE);
        log0$default(INSTANCE, r9, 8, r10, null, false, 24, null);
    }

    @JvmStatic
    public static final void w(String r9, String r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r9, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_MESSAGE);
        log0$default(INSTANCE, r9, 8, r10, r11, false, 16, null);
    }

    @JvmStatic
    public static final void e(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_MESSAGE);
        log0$default(INSTANCE, r9, 16, r10, null, false, 24, null);
    }

    @JvmStatic
    public static final void e(String r9, String r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r9, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_MESSAGE);
        log0$default(INSTANCE, r9, 16, r10, r11, false, 16, null);
    }

    public static /* synthetic */ void json$default(String r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r0 = null;
    L5:
        json(r0, r1);
    }

    @JvmStatic
    public static final void json(String r21, String r22) {
        String r0 = r22;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L23;
        log0$default(INSTANCE, r21, 8, "Empty/Null json content", null, false, 24, null);
        return;
    L23:
        String r2 = StringsKt.trim(r22).toString();     // Catch: JSONException -> L20
        if (StringsKt.startsWith$default(r2, "{", false, 2, null) == false) goto L16;
        L r5 = INSTANCE;     // Catch: JSONException -> L20
        String r8 = new JSONObject(r2).toString(2);     // Catch: JSONException -> L20
        Intrinsics.checkNotNullExpressionValue(r8, "JSONObject(jsonStr).toString(JSON_INDENT)");     // Catch: JSONException -> L20
        log0$default(r5, r21, 1, r8, null, true, 8, null);     // Catch: JSONException -> L20
    L22:
        return;
    L16:
        if (StringsKt.startsWith$default(r2, "[", false, 2, null) == false) goto L18;
        L r6 = INSTANCE;     // Catch: JSONException -> L20
        String r9 = new JSONArray(r2).toString(2);     // Catch: JSONException -> L20
        Intrinsics.checkNotNullExpressionValue(r9, "JSONArray(jsonStr).toString(JSON_INDENT)");     // Catch: JSONException -> L20
        log0$default(r6, r21, 1, r9, null, true, 8, null);     // Catch: JSONException -> L20
        goto L22
    L18:
        log0$default(INSTANCE, r21, 16, "Invalid Json", null, false, 24, null);     // Catch: JSONException -> L20
    L20:
        log0$default(INSTANCE, r21, 16, "Invalid Json", null, false, 24, null);
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public static /* synthetic */ void log$default(L r0, String r1, int r2, Function0 r3, Throwable r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        if (r0.isBlocked(r2) == false) goto L8;
        return;
    L8:
        r0.getImpl().writeLog(r1, r2, (String) r3.invoke(), r4);
    }

    public final void log(String r2, int r3, Function0<String> r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
        if (isBlocked(r3) == false) goto L5;
        return;
    L5:
        getImpl().writeLog(r2, r3, r4.invoke(), r5);
    }

    static /* synthetic */ void log0$default(L r6, String r7, int r8, String r9, Throwable r10, boolean r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = null;
    L5:
        Throwable r4 = r10;
        if ((r12 & 16) == 0) goto L8;
        r11 = false;
    L8:
        r6.log0(r7, r8, r9, r4, r11);
    }

    private final void log0(String r7, int r8, String r9, Throwable r10, boolean r11) {
        if (isBlocked(r8) == false) goto L5;
        return;
    L5:
        if (r11 == true) goto L7;
        getImpl().writeLog(r7, r8, r9, r10);
        return;
    L7:
        Iterator r6 = StringsKt.split$default(r9, new String[]{IOUtils.LINE_SEPARATOR_UNIX}, false, 0, 6, null).iterator();
    L9:
        if (r6.hasNext() == false) goto L13;
        String r12 = (String) r6.next();
        INSTANCE.getImpl().writeLog(r7, r8, r12, null);
        goto L9
    }

    public final boolean isBlocked(int r1) {
        if ((logLevelMask & r1) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void v(String r3, Function0<String> r4) {
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
        if (isBlocked(1) == true) goto L7;
        getImpl().writeLog(r3, 1, r4.invoke(), null);
        return;
    }

    public final void d(String r3, Function0<String> r4) {
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
        if (isBlocked(2) == true) goto L7;
        getImpl().writeLog(r3, 2, r4.invoke(), null);
        return;
    }

    public final void i(String r3, Function0<String> r4) {
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
        if (isBlocked(4) == true) goto L7;
        getImpl().writeLog(r3, 4, r4.invoke(), null);
        return;
    }

    public final void w(String r3, Function0<String> r4) {
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
        if (isBlocked(8) == true) goto L7;
        getImpl().writeLog(r3, 8, r4.invoke(), null);
        return;
    }

    public final void e(String r3, Function0<String> r4) {
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
        if (isBlocked(16) == true) goto L7;
        getImpl().writeLog(r3, 16, r4.invoke(), null);
        return;
    }
}
