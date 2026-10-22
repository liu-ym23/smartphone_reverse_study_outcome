package com.obric.matrix.platform.sdk.ones.account.log;

import androidx.core.app.NotificationCompat;
import com.obric.matrix.platform.sdk.ones.account.api.ILogger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OLog implements ILogger {

    @NotNull
    public static final OLog INSTANCE = null;

    @NotNull
    private static ILogger loggerProxy;

    static {
        INSTANCE = new OLog();
        loggerProxy = new OLog$loggerProxy$1();
    }

    private OLog() {
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
    public void d(@NotNull String r1, @NotNull String r2, @Nullable Throwable r3) {
        Intrinsics.f(r1, "tag");
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        loggerProxy.d(r1, r2, r3);
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
    public void e(@NotNull String r1, @NotNull String r2, @Nullable Throwable r3) {
        Intrinsics.f(r1, "tag");
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        loggerProxy.e(r1, r2, r3);
    }

    @NotNull
    public final ILogger getLoggerProxy() {
        return loggerProxy;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
    public void i(@NotNull String r1, @NotNull String r2, @Nullable Throwable r3) {
        Intrinsics.f(r1, "tag");
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        loggerProxy.i(r1, r2, r3);
    }

    public final void setLoggerProxy(@NotNull ILogger r1) {
        Intrinsics.f(r1, "<set-?>");
        loggerProxy = r1;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
    public void v(@NotNull String r1, @NotNull String r2, @Nullable Throwable r3) {
        Intrinsics.f(r1, "tag");
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        loggerProxy.v(r1, r2, r3);
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
    public void w(@NotNull String r1, @NotNull String r2, @Nullable Throwable r3) {
        Intrinsics.f(r1, "tag");
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        loggerProxy.w(r1, r2, r3);
    }

    @JvmStatic
    public static final void d(@NotNull String r2, @NotNull String r3) {
        Intrinsics.f(r2, "tag");
        Intrinsics.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        INSTANCE.d(r2, r3, null);
    }

    @JvmStatic
    public static final void e(@NotNull String r2, @NotNull String r3) {
        Intrinsics.f(r2, "tag");
        Intrinsics.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        INSTANCE.e(r2, r3, null);
    }

    @JvmStatic
    public static final void i(@NotNull String r2, @NotNull String r3) {
        Intrinsics.f(r2, "tag");
        Intrinsics.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        INSTANCE.i(r2, r3, null);
    }

    @JvmStatic
    public static final void v(@NotNull String r2, @NotNull String r3) {
        Intrinsics.f(r2, "tag");
        Intrinsics.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        INSTANCE.v(r2, r3, null);
    }

    @JvmStatic
    public static final void w(@NotNull String r2, @NotNull String r3) {
        Intrinsics.f(r2, "tag");
        Intrinsics.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        INSTANCE.w(r2, r3, null);
    }
}
