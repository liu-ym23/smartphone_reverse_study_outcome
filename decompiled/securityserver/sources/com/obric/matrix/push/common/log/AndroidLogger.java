package com.obric.matrix.push.common.log;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AndroidLogger implements ILogger {
    public AndroidLogger() {
    }

    @Override // com.obric.matrix.push.common.log.ILogger
    public void logd(@NotNull String r1, @NotNull String r2) {
        Intrinsics.f(r1, "tag");
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        Log.d(r1, r2);
    }

    @Override // com.obric.matrix.push.common.log.ILogger
    public void loge(@NotNull String r1, @NotNull String r2, @Nullable Throwable r3) {
        Intrinsics.f(r1, "tag");
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        Log.e(r1, r2, r3);
    }

    @Override // com.obric.matrix.push.common.log.ILogger
    public void logi(@NotNull String r1, @NotNull String r2) {
        Intrinsics.f(r1, "tag");
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        Log.i(r1, r2);
    }

    @Override // com.obric.matrix.push.common.log.ILogger
    public void logv(@NotNull String r1, @NotNull String r2) {
        Intrinsics.f(r1, "tag");
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        Log.v(r1, r2);
    }

    @Override // com.obric.matrix.push.common.log.ILogger
    public void logw(@NotNull String r1, @NotNull String r2, @Nullable Throwable r3) {
        Intrinsics.f(r1, "tag");
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        Log.w(r1, r2, r3);
    }
}
