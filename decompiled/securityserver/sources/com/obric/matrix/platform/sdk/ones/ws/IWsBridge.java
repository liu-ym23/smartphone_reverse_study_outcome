package com.obric.matrix.platform.sdk.ones.ws;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface IWsBridge {
    void onWsMsgReceived(int r1, long r2, long r4, int r6, int r7, @Nullable String r8, @Nullable String r9, @Nullable byte[] r10, @Nullable Map<String, String> r11);
}
