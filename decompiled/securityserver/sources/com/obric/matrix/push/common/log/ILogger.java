package com.obric.matrix.push.common.log;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface ILogger {
    void logd(@NotNull String r1, @NotNull String r2);

    void loge(@NotNull String r1, @NotNull String r2, @Nullable Throwable r3);

    void logi(@NotNull String r1, @NotNull String r2);

    void logv(@NotNull String r1, @NotNull String r2);

    void logw(@NotNull String r1, @NotNull String r2, @Nullable Throwable r3);
}
