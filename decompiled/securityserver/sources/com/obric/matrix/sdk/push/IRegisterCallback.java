package com.obric.matrix.sdk.push;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface IRegisterCallback {
    void onFailed(@NotNull String r1, @NotNull String r2);

    void onSuccess(@NotNull String r1);
}
