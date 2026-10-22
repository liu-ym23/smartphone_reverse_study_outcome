package com.obric.matrix.platform.sdk.ones.dataanalysis;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface DeviceInfoListener {
    void onDeviceIdLoaded(@NotNull String r1);

    void onInstallIdLoaded(@NotNull String r1);
}
