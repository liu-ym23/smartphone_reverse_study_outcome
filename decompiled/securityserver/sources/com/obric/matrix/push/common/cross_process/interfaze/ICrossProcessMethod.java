package com.obric.matrix.push.common.cross_process.interfaze;

import com.obric.matrix.push.common.cross_process.ICrossProcessCallbackInterface;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface ICrossProcessMethod {
    @NotNull
    String getMethodName();

    void onMethodInvoke(@NotNull String r1, @Nullable List<Object> r2, @Nullable ICrossProcessCallbackInterface r3);
}
