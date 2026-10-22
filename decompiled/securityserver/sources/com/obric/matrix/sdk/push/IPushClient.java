package com.obric.matrix.sdk.push;

import com.obric.matrix.sdk.push.model.Message;
import com.obric.matrix.sdk.push.model.RevokeMsg;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface IPushClient {
    void onReceiveMsg(@NotNull Message r1);

    void onRevokeMsg(@NotNull RevokeMsg r1);
}
