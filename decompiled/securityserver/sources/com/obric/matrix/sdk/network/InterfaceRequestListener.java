package com.obric.matrix.sdk.network;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface InterfaceRequestListener {
    void onApiDuration(long r1, long r3, @Nullable String r5, @Nullable String r6, @Nullable String r7, int r8, @Nullable JSONObject r9);

    void onApiError(long r1, long r3, @Nullable String r5, @Nullable String r6, @Nullable String r7, int r8, @Nullable JSONObject r9);
}
