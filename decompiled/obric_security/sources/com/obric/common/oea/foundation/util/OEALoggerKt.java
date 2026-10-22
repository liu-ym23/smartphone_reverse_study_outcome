package com.obric.common.oea.foundation.util;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OEALogger.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0005"}, d2 = {"debugLog", "", NotificationCompat.CATEGORY_MESSAGE, "", "raiseIllegalArgumentException", "foundation_standardRelease"}, k = 2, mv = {1, 4, 3})
public final class OEALoggerKt {
    public static final void debugLog(String r2) {
        OEALogger r0 = OEALogger.INSTANCE;
        if (r2 != null) goto L6;
        r2 = "null";
    L6:
        r0.d("debugging", r2);
    }

    public static final void raiseIllegalArgumentException(String r7) {
        Intrinsics.checkNotNullParameter(r7, NotificationCompat.CATEGORY_MESSAGE);
        OEALogger.e$default(OEALogger.INSTANCE, "debugging", r7, null, 4, null);
        throw new IllegalArgumentException(r7);
    }
}
