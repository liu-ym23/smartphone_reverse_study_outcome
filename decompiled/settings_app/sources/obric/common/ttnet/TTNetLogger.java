package obric.common.ttnet;

import androidx.core.app.NotificationCompat;
import com.bytedance.common.utility.Logger;
import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TTNetLogger.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\u0010"}, d2 = {"Lobric/common/ttnet/TTNetLogger;", "Lcom/bytedance/common/utility/Logger$ILogWritter;", "()V", "logE", "", "tag", "", NotificationCompat.CATEGORY_MESSAGE, "message", "e", "", "logI", "throwable", "logK", "logW", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TTNetLogger extends Logger.ILogWritter {
    public static final Companion Companion = null;
    private static final String TAG = "TTNetLogger";

    /* JADX INFO: compiled from: TTNetLogger.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lobric/common/ttnet/TTNetLogger$Companion;", "", "()V", "TAG", "", "init", "", "isDebug", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final void init(boolean r1) {
            Logger.registerLogHandler(new TTNetLogger());
            if (r1 == false) goto L5;
            Logger.setLogLevel(4);
            return;
        L5:
            Logger.setLogLevel(4);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TTNetLogger() {
    }

    @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
    public void logI(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "message");
        OLog.i(TAG, "[" + r2 + "], " + r3);
    }

    @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
    public void logI(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(r4, "throwable");
        OLog.w(TAG, "[" + r2 + "], " + r3, r4);
    }

    @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
    public void logE(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "e");
        OLog.e(TAG, "[" + r2 + "], " + r3, r4);
    }

    @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
    public void logE(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        OLog.e(TAG, "[" + r2 + "], " + r3);
    }

    @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
    public void logW(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        OLog.w(TAG, "[" + r2 + "], " + r3);
    }

    @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
    public void logW(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(r4, "throwable");
        OLog.w(TAG, "[" + r2 + "], " + r3, r4);
    }

    @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
    public void logK(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "message");
        OLog.w(TAG, "[" + r2 + "], " + r3);
    }
}
