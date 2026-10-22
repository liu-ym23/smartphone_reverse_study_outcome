package com.bytedance.blockframework.framework.monitor;

import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.blockframework.utils.Logger;
import com.obric.olog.Constants;
import com.ss.android.message.log.PushLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlockLogger.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J$\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\fH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/blockframework/framework/monitor/DefaultBlockLogger;", "Lcom/bytedance/blockframework/framework/monitor/BlockLogger;", "()V", "debug", "", "log", "", PushLog.KEY_TAG, "", AlogMonitor.ALOG_RESULT_INFO, Constants.REPORT_FIELD, "params", "", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DefaultBlockLogger implements BlockLogger {
    @Override // com.bytedance.blockframework.framework.monitor.BlockLogger
    public boolean debug() {
        return false;
    }

    @Override // com.bytedance.blockframework.framework.monitor.BlockLogger
    public void report(String r1, Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r1, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r2, "params");
    }

    public DefaultBlockLogger() {
    }

    @Override // com.bytedance.blockframework.framework.monitor.BlockLogger
    public void log(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r2, AlogMonitor.ALOG_RESULT_INFO);
        Logger.INSTANCE.d(r1, r2);
    }
}
