package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import com.obric.matrix.proto.Response;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface CmdResultCallback {
    void onResult(int r1, @NotNull Response r2);
}
