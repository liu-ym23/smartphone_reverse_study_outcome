package com.obric.common.oea.foundation.util;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OEALogger.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b*\u0001\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\"\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0015\u001a\u00020\u000fJ\u0016\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u0016\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\tJ\u0016\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u0016\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/obric/common/oea/foundation/util/OEALogger;", "", "()V", "TAG", "", "defaultLogger", "com/obric/common/oea/foundation/util/OEALogger$defaultLogger$1", "Lcom/obric/common/oea/foundation/util/OEALogger$defaultLogger$1;", "loggerDelegate", "Lcom/obric/common/oea/foundation/util/OEALog;", "getLoggerDelegate", "()Lcom/obric/common/oea/foundation/util/OEALog;", "setLoggerDelegate", "(Lcom/obric/common/oea/foundation/util/OEALog;)V", "d", "", "tag", NotificationCompat.CATEGORY_MESSAGE, "e", "throwable", "", "enableAndroidDebugLog", "i", "r", "setLogDelegate", "delegate", "v", "w", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OEALogger {
    public static final OEALogger INSTANCE = null;
    private static final String TAG = "OEA_SDK";
    private static final OEALogger$defaultLogger$1 defaultLogger = null;
    private static OEALog loggerDelegate;

    static {
        INSTANCE = new OEALogger();
        defaultLogger = new OEALogger$defaultLogger$1();
    }

    private OEALogger() {
    }

    public final OEALog getLoggerDelegate() {
        return loggerDelegate;
    }

    public final void setLoggerDelegate(OEALog r1) {
        loggerDelegate = r1;
    }

    public final void enableAndroidDebugLog() {
        loggerDelegate = defaultLogger;
    }

    public final void setLogDelegate(OEALog r1) {
        Intrinsics.checkNotNullParameter(r1, "delegate");
        loggerDelegate = r1;
    }

    public final void v(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        OEALog r0 = loggerDelegate;
        if (r0 == null) goto L6;
        r0.v(r1, r2);
        return;
    }

    public final void d(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        OEALog r0 = loggerDelegate;
        if (r0 == null) goto L6;
        r0.d(r1, r2);
        return;
    }

    public final void i(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        OEALog r0 = loggerDelegate;
        if (r0 == null) goto L6;
        r0.i(r1, r2);
        return;
    }

    public final void w(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        OEALog r0 = loggerDelegate;
        if (r0 == null) goto L6;
        if (r0 == null) goto L8;
        r0.w(r1, r2);
        return;
    L8:
        return;
    L6:
        defaultLogger.w(r1, r2);
    }

    public static /* synthetic */ void e$default(OEALogger r0, String r1, String r2, Throwable r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
        Throwable r6 = (Throwable) null;
    L5:
        r0.e(r1, r2, r3);
    }

    public final void e(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        OEALog r0 = loggerDelegate;
        if (r0 == null) goto L6;
        if (r0 == null) goto L8;
        r0.e(r1, r2, r3);
        return;
    L8:
        return;
    L6:
        defaultLogger.e(r1, r2, r3);
    }

    public final void r(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        OEALog r0 = loggerDelegate;
        if (r0 == null) goto L6;
        if (r0 == null) goto L8;
        r0.i(r1, r2);
        return;
    L8:
        return;
    L6:
        defaultLogger.i(r1, r2);
    }
}
