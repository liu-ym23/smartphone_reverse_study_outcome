package com.bytedance.blockframework.utils;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.obric.oui.calendar.format.DayFormatter;
import com.ss.android.message.log.PushLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u0016\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u0016\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u0016\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/blockframework/utils/Logger;", "", "()V", "TAG", "", "logLevel", "", "getLogLevel", "()I", "setLogLevel", "(I)V", DayFormatter.DEFAULT_FORMAT, "", NotificationCompat.CATEGORY_MESSAGE, PushLog.KEY_TAG, "e", "i", "isDebugLoggable", "", "isErrorLoggable", "isInfoLoggable", "isVerboseLoggable", "isWarnLoggable", BaseSwitches.V, "w", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Logger {
    public static final Logger INSTANCE = null;
    private static final String TAG = "Logger";
    private static int logLevel;

    private Logger() {
    }

    public final int getLogLevel() {
        return logLevel;
    }

    public final void setLogLevel(int r1) {
        logLevel = r1;
    }

    static {
        INSTANCE = new Logger();
        logLevel = 6;
    }

    public final void v(String r2) {
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        v(TAG, r2);
    }

    public final void v(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        if (isVerboseLoggable() == false) goto L6;
        Log.v(r2, r3);
        return;
    }

    public final boolean isVerboseLoggable() {
        if (logLevel > 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        d(TAG, r2);
    }

    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        if (isDebugLoggable() == false) goto L6;
        Log.d(r2, r3);
        return;
    }

    public final boolean isDebugLoggable() {
        if (logLevel > 3) goto L5;
        return true;
    L5:
        return false;
    }

    public final void i(String r2) {
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        i(TAG, r2);
    }

    public final void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        if (isInfoLoggable() == false) goto L6;
        Log.i(r2, r3);
        return;
    }

    public final boolean isInfoLoggable() {
        if (logLevel > 4) goto L5;
        return true;
    L5:
        return false;
    }

    public final void w(String r2) {
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        w(TAG, r2);
    }

    public final void w(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        if (isWarnLoggable() == false) goto L6;
        Log.w(r2, r3);
        return;
    }

    public final boolean isWarnLoggable() {
        if (logLevel > 5) goto L5;
        return true;
    L5:
        return false;
    }

    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        e(TAG, r2);
    }

    public final void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        if (isErrorLoggable() == false) goto L6;
        Log.e(r2, r3);
        return;
    }

    public final boolean isErrorLoggable() {
        if (logLevel > 6) goto L5;
        return true;
    L5:
        return false;
    }
}
