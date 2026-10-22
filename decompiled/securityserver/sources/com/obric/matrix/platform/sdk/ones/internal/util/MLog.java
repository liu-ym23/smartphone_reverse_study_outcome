package com.obric.matrix.platform.sdk.ones.internal.util;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.obric.matrix.platform.sdk.ones.IMatrixBridge;
import com.obric.matrix.platform.sdk.ones.MatrixOnesSdk;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MLog {

    @NotNull
    public static final MLog INSTANCE = null;

    @NotNull
    private static final String TAG = "matrix_ones";
    private static boolean sPrintable;

    static {
        INSTANCE = new MLog();
    }

    private MLog() {
    }

    @JvmStatic
    @JvmOverloads
    public static final void d(@NotNull String r2, @NotNull String r3) {
        Intrinsics.f(r2, "tag");
        Intrinsics.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        d$default(r2, r3, null, 4, null);
    }

    public static /* synthetic */ void d$default(String r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        d(r0, r1, r2);
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
    @JvmOverloads
    public static final void i(@NotNull String r2, @NotNull String r3) {
        Intrinsics.f(r2, "tag");
        Intrinsics.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        i$default(r2, r3, null, 4, null);
    }

    public static /* synthetic */ void i$default(String r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        i(r0, r1, r2);
    }

    private final void proxyDebugLog(String r3, String r4, Throwable r5) {
        IMatrixBridge r2 = MatrixOnesSdk.INSTANCE.getBridge$sdk_platform_ones_release();
        if (r2 == null) goto L6;
        r2.logd(r3, "MatrixOnesSdk: " + r4, r5);
        return;
    }

    private final void proxyInfoLog(String r3, String r4, Throwable r5) {
        IMatrixBridge r2 = MatrixOnesSdk.INSTANCE.getBridge$sdk_platform_ones_release();
        if (r2 == null) goto L6;
        r2.loge(r3, "MatrixOnesSdk: " + r4, r5);
        return;
    }

    @JvmStatic
    @JvmOverloads
    public static final void v(@NotNull String r2, @NotNull String r3) {
        Intrinsics.f(r2, "tag");
        Intrinsics.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        v$default(r2, r3, null, 4, null);
    }

    public static /* synthetic */ void v$default(String r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        v(r0, r1, r2);
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

    public final void setEnabled(boolean r1) {
        sPrintable = r1;
    }

    @JvmStatic
    public static final void d(@NotNull String r3) {
        Intrinsics.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        d$default(TAG, r3, null, 4, null);
    }

    @JvmStatic
    public static final void e(@NotNull String r3) {
        Intrinsics.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        e$default(TAG, r3, null, 4, null);
    }

    @JvmStatic
    public static final void i(@NotNull String r3) {
        Intrinsics.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        i$default(TAG, r3, null, 4, null);
    }

    @JvmStatic
    public static final void v(@NotNull String r3) {
        Intrinsics.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        v$default(TAG, r3, null, 4, null);
    }

    @JvmStatic
    public static final void w(@NotNull String r3) {
        Intrinsics.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        w$default(TAG, r3, null, 4, null);
    }

    @JvmStatic
    public static final void d(@NotNull String r1, @Nullable Throwable r2) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_MESSAGE);
        d(TAG, r1, r2);
    }

    @JvmStatic
    public static final void e(@NotNull String r1, @Nullable Throwable r2) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_MESSAGE);
        e(TAG, r1, r2);
    }

    @JvmStatic
    @JvmOverloads
    public static final void i(@NotNull String r1, @NotNull String r2, @Nullable Throwable r3) {
        Intrinsics.f(r1, "tag");
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        if (sPrintable == false) goto L5;
        Log.i(r1, r2, r3);
    L5:
        INSTANCE.proxyInfoLog(r1, r2, r3);
    }

    @JvmStatic
    @JvmOverloads
    public static final void v(@NotNull String r1, @NotNull String r2, @Nullable Throwable r3) {
        Intrinsics.f(r1, "tag");
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        if (sPrintable == false) goto L5;
        Log.v(r1, r2, r3);
    L5:
        INSTANCE.proxyDebugLog(r1, r2, r3);
    }

    @JvmStatic
    @JvmOverloads
    public static final void w(@NotNull String r1, @NotNull String r2, @Nullable Throwable r3) {
        Intrinsics.f(r1, "tag");
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        if (sPrintable == false) goto L5;
        Log.w(r1, r2, r3);
    L5:
        INSTANCE.proxyInfoLog(r1, r2, r3);
    }

    @JvmStatic
    @JvmOverloads
    public static final void d(@NotNull String r1, @NotNull String r2, @Nullable Throwable r3) {
        Intrinsics.f(r1, "tag");
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        if (sPrintable == false) goto L5;
        Log.d(r1, r2, r3);
    L5:
        INSTANCE.proxyDebugLog(r1, r2, r3);
    }

    @JvmStatic
    @JvmOverloads
    public static final void e(@NotNull String r1, @NotNull String r2, @Nullable Throwable r3) {
        Intrinsics.f(r1, "tag");
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        if (sPrintable == false) goto L5;
        Log.e(r1, r2, r3);
    L5:
        INSTANCE.proxyInfoLog(r1, r2, r3);
    }
}
