package com.bytedance.blockframework.framework.monitor;

import android.os.SystemClock;
import com.bytedance.apm.alog.AlogMonitor;
import com.ss.android.message.log.PushLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlockLogger.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¨\u0006\t"}, d2 = {"currentThread", "Ljava/lang/Thread;", "currentTime", "", "logger", "", PushLog.KEY_TAG, "", AlogMonitor.ALOG_RESULT_INFO, "blockframework_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BlockLoggerKt {
    public static final void logger(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r2, AlogMonitor.ALOG_RESULT_INFO);
        BlockLogger.Companion.log(r1, r2);
    }

    public static final long currentTime() {
        return SystemClock.elapsedRealtime();
    }

    public static final Thread currentThread() {
        Thread r0 = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(r0, "currentThread");
        return r0;
    }
}
