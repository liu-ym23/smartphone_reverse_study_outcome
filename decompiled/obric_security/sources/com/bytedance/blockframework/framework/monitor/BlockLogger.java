package com.bytedance.blockframework.framework.monitor;

import com.bytedance.apm.alog.AlogMonitor;
import com.obric.olog.Constants;
import com.ss.android.message.log.PushLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlockLogger.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J$\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000bH&¨\u0006\r"}, d2 = {"Lcom/bytedance/blockframework/framework/monitor/BlockLogger;", "", "debug", "", "log", "", PushLog.KEY_TAG, "", AlogMonitor.ALOG_RESULT_INFO, Constants.REPORT_FIELD, "params", "", "Companion", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface BlockLogger {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: BlockLogger.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J$\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\rH\u0016J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0001R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/blockframework/framework/monitor/BlockLogger$Companion;", "Lcom/bytedance/blockframework/framework/monitor/BlockLogger;", "()V", "logger", "debug", "", "log", "", PushLog.KEY_TAG, "", AlogMonitor.ALOG_RESULT_INFO, Constants.REPORT_FIELD, "params", "", "setLogger", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion implements BlockLogger {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static BlockLogger logger;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            logger = new DefaultBlockLogger();
        }

        public final void setLogger(BlockLogger r1) {
            Intrinsics.checkNotNullParameter(r1, "logger");
            logger = r1;
        }

        @Override // com.bytedance.blockframework.framework.monitor.BlockLogger
        public boolean debug() {
            return logger.debug();
        }

        @Override // com.bytedance.blockframework.framework.monitor.BlockLogger
        public void log(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, PushLog.KEY_TAG);
            Intrinsics.checkNotNullParameter(r2, AlogMonitor.ALOG_RESULT_INFO);
            logger.log(r1, r2);
        }

        @Override // com.bytedance.blockframework.framework.monitor.BlockLogger
        public void report(String r1, Map<String, String> r2) {
            Intrinsics.checkNotNullParameter(r1, PushLog.KEY_TAG);
            Intrinsics.checkNotNullParameter(r2, "params");
            logger.report(r1, r2);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    boolean debug();

    void log(String r1, String r2);

    void report(String r1, Map<String, String> r2);
}
