package com.obric.matrix.platform.sdk.ones;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface IMatrixBridge {
    @NotNull
    String appId();

    @NotNull
    String appVersionCode();

    @NotNull
    String did();

    boolean isOverSea();

    void logd(@NotNull String r1, @NotNull String r2, @Nullable Throwable r3);

    void loge(@NotNull String r1, @NotNull String r2, @Nullable Throwable r3);
}
