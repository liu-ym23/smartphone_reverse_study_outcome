package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import com.obric.matrix.proto.Response;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface IResultCallback {
    void onResponse(@NotNull Response r1, @NotNull JSONObject r2);
}
