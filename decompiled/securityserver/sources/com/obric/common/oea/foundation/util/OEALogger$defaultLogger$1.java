package com.obric.common.oea.foundation.util;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OEALogger$defaultLogger$1 implements OEALog {
    public final void a(String r1, Throwable r2) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_MESSAGE);
        Log.e("OEA_SDK", "SmoothCornerHelper->".concat(r1), r2);
    }

    public final void b(String r1, String r2) {
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        Log.i("OEA_SDK", r1 + "->" + r2);
    }
}
