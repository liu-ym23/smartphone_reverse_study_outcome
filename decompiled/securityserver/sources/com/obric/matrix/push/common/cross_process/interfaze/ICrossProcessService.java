package com.obric.matrix.push.common.cross_process.interfaze;

import com.obric.matrix.push.common.cross_process.ICrossProcessCallbackInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface ICrossProcessService {
    void disConnectWithTargetPkg(@NotNull String r1);

    void invoke(@NotNull String r1, @NotNull String r2, @Nullable ArrayList<Object> r3, @Nullable ICrossProcessCallback r4);

    void onMethodInvoke(@NotNull String r1, @NotNull String r2, @Nullable List<Object> r3, @Nullable ICrossProcessCallbackInterface r4);

    void registerCrossProcessMethod(@NotNull ICrossProcessMethod r1);

    void unRegisterCrossProcessMethod(@NotNull ICrossProcessMethod r1);
}
