package com.obric.oui.toast;

import android.os.Handler;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OToast$TN$mHandler$1 extends Handler {
    @Override // android.os.Handler
    public final void handleMessage(Message r2) {
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        int r1 = r2.what;
        if (r1 != 1) goto L5;
        throw null;
    L5:
        if (r1 == 2) goto L7;
        return;
    L7:
        throw null;
    }
}
