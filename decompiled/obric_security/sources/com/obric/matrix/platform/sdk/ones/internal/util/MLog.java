package com.obric.matrix.platform.sdk.ones.internal.util;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.obric.matrix.platform.sdk.ones.IMatrixBridge;
import com.obric.matrix.platform.sdk.ones.MatrixOnesSdk;
import com.obric.oui.calendar.format.DayFormatter;
import com.ss.android.message.log.PushLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MLog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J$\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J$\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\"\u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\"\u0010\u0010\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0006J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J$\u0010\u0013\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J$\u0010\u0014\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/util/MLog;", "", "()V", "TAG", "", "sPrintable", "", DayFormatter.DEFAULT_FORMAT, "", NotificationCompat.CATEGORY_MESSAGE, PushLog.KEY_TAG, "tr", "", "e", "i", "proxyDebugLog", "proxyInfoLog", "setEnabled", "enabled", BaseSwitches.V, "w", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MLog {
    public static final MLog INSTANCE = null;
    private static final String TAG = "matrix_ones";
    private static boolean sPrintable;

    static {
        INSTANCE = new MLog();
    }

    @JvmStatic
    public static final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        d$default(r2, r3, null, 4, null);
    }

    @JvmStatic
    public static final void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        e$default(r2, r3, null, 4, null);
    }

    @JvmStatic
    public static final void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        i$default(r2, r3, null, 4, null);
    }

    @JvmStatic
    public static final void v(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        v$default(r2, r3, null, 4, null);
    }

    @JvmStatic
    public static final void w(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        w$default(r2, r3, null, 4, null);
    }

    private MLog() {
    }

    public final void setEnabled(boolean r1) {
        sPrintable = r1;
    }

    @JvmStatic
    public static final void v(String r3) {
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        v$default(TAG, r3, null, 4, null);
    }

    public static /* synthetic */ void v$default(String r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        v(r0, r1, r2);
    }

    @JvmStatic
    public static final void v(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        if (sPrintable == false) goto L5;
        Log.v(r1, r2, r3);
    L5:
        INSTANCE.proxyDebugLog(r1, r2, r3);
    }

    @JvmStatic
    public static final void d(String r3) {
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        d$default(TAG, r3, null, 4, null);
    }

    @JvmStatic
    public static final void d(String r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_MESSAGE);
        d(TAG, r1, r2);
    }

    public static /* synthetic */ void d$default(String r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        d(r0, r1, r2);
    }

    @JvmStatic
    public static final void d(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        if (sPrintable == false) goto L5;
        Log.d(r1, r2, r3);
    L5:
        INSTANCE.proxyDebugLog(r1, r2, r3);
    }

    @JvmStatic
    public static final void i(String r3) {
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        i$default(TAG, r3, null, 4, null);
    }

    public static /* synthetic */ void i$default(String r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        i(r0, r1, r2);
    }

    @JvmStatic
    public static final void i(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        if (sPrintable == false) goto L5;
        Log.i(r1, r2, r3);
    L5:
        INSTANCE.proxyInfoLog(r1, r2, r3);
    }

    @JvmStatic
    public static final void w(String r3) {
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        w$default(TAG, r3, null, 4, null);
    }

    public static /* synthetic */ void w$default(String r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        w(r0, r1, r2);
    }

    @JvmStatic
    public static final void w(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        if (sPrintable == false) goto L5;
        Log.w(r1, r2, r3);
    L5:
        INSTANCE.proxyInfoLog(r1, r2, r3);
    }

    @JvmStatic
    public static final void e(String r3) {
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        e$default(TAG, r3, null, 4, null);
    }

    @JvmStatic
    public static final void e(String r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_MESSAGE);
        e(TAG, r1, r2);
    }

    public static /* synthetic */ void e$default(String r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        e(r0, r1, r2);
    }

    @JvmStatic
    public static final void e(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        if (sPrintable == false) goto L5;
        Log.e(r1, r2, r3);
    L5:
        INSTANCE.proxyInfoLog(r1, r2, r3);
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
}
