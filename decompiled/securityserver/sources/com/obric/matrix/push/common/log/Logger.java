package com.obric.matrix.push.common.log;

import a.a;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Logger {

    @NotNull
    public static final Logger INSTANCE = null;

    @NotNull
    private static final String TAG = "MATRIX_PUSH";

    @NotNull
    private static final ILogger androidLogger = null;
    private static boolean enableAndroidLog;

    @Nullable
    private static ILogger proxyLogger;

    static {
        INSTANCE = new Logger();
        enableAndroidLog = true;
        androidLogger = new AndroidLogger();
    }

    private Logger() {
    }

    @JvmStatic
    public static final void d(@NotNull String r1) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_MESSAGE);
        d("", r1);
    }

    @JvmStatic
    @JvmOverloads
    public static final void e(@NotNull String r2, @NotNull String r3) {
        Intrinsics.f(r2, "tag");
        Intrinsics.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        e$default(r2, r3, null, 4, null);
    }

    public static /* synthetic */ void e$default(String r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        e(r0, r1, r2);
    }

    @JvmStatic
    private static final String formatMsg(String r1, String r2) {
        if (r1 != null) goto L4;
        return r2;
    L4:
        if (r1.length() != 0) goto L7;
        return r2;
    L7:
        return a.B(r1, "-->", r2);
    }

    @JvmStatic
    private static final String formatTag(String r0) {
        return TAG;
    }

    @JvmStatic
    public static final void i(@NotNull String r1) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_MESSAGE);
        i("", r1);
    }

    public static /* synthetic */ void init$default(Logger r0, boolean r1, ILogger r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = true;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        r0.init(r1, r2);
    }

    @JvmStatic
    public static final void v(@NotNull String r1) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_MESSAGE);
        v("", r1);
    }

    @JvmStatic
    @JvmOverloads
    public static final void w(@NotNull String r2, @NotNull String r3) {
        Intrinsics.f(r2, "tag");
        Intrinsics.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        w$default(r2, r3, null, 4, null);
    }

    public static /* synthetic */ void w$default(String r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        w(r0, r1, r2);
    }

    public final void init(boolean r1, @Nullable ILogger r2) {
        enableAndroidLog = r1;
        proxyLogger = r2;
    }

    @JvmStatic
    public static final void d(@NotNull String r1, @NotNull String r2) {
        Intrinsics.f(r1, "tag");
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        String r0 = formatTag(r1);
        String r3 = formatMsg(r1, r2);
        if (enableAndroidLog == false) goto L5;
        androidLogger.logd(r0, r3);
    L5:
        ILogger r4 = proxyLogger;
        if (r4 == null) goto L9;
        r4.logd(r0, r3);
        return;
    }

    @JvmStatic
    public static final void e(@NotNull String r3) {
        Intrinsics.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        e$default("", r3, null, 4, null);
    }

    @JvmStatic
    public static final void i(@NotNull String r1, @NotNull String r2) {
        Intrinsics.f(r1, "tag");
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        String r0 = formatTag(r1);
        String r3 = formatMsg(r1, r2);
        if (enableAndroidLog == false) goto L5;
        androidLogger.logi(r0, r3);
    L5:
        ILogger r4 = proxyLogger;
        if (r4 == null) goto L9;
        r4.logi(r0, r3);
        return;
    }

    @JvmStatic
    public static final void v(@NotNull String r1, @NotNull String r2) {
        Intrinsics.f(r1, "tag");
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        String r0 = formatTag(r1);
        String r3 = formatMsg(r1, r2);
        if (enableAndroidLog == false) goto L5;
        androidLogger.logv(r0, r3);
    L5:
        ILogger r4 = proxyLogger;
        if (r4 == null) goto L9;
        r4.logd(r0, r3);
        return;
    }

    @JvmStatic
    public static final void w(@NotNull String r3) {
        Intrinsics.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        w$default("", r3, null, 4, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void e(@NotNull String r1, @NotNull String r2, @Nullable Throwable r3) {
        Intrinsics.f(r1, "tag");
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        String r0 = formatTag(r1);
        String r4 = formatMsg(r1, r2);
        if (enableAndroidLog == false) goto L5;
        androidLogger.loge(r0, r4, r3);
    L5:
        ILogger r5 = proxyLogger;
        if (r5 == null) goto L9;
        r5.loge(r0, r4, r3);
        return;
    }

    @JvmStatic
    @JvmOverloads
    public static final void w(@NotNull String r1, @NotNull String r2, @Nullable Throwable r3) {
        Intrinsics.f(r1, "tag");
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        String r0 = formatTag(r1);
        String r4 = formatMsg(r1, r2);
        if (enableAndroidLog == false) goto L5;
        androidLogger.logw(r0, r4, r3);
    L5:
        ILogger r5 = proxyLogger;
        if (r5 == null) goto L9;
        r5.logw(r0, r4, r3);
        return;
    }
}
