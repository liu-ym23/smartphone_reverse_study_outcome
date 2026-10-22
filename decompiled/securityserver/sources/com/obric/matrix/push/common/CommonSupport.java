package com.obric.matrix.push.common;

import android.content.Context;
import com.obric.matrix.push.common.cross_process.CrossProcessService;
import com.obric.matrix.push.common.cross_process.interfaze.ICrossProcessService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CommonSupport {

    @NotNull
    public static final CommonSupport INSTANCE = null;

    @Nullable
    private static ICrossProcessService iCrossProcessService;

    static {
        INSTANCE = new CommonSupport();
    }

    private CommonSupport() {
    }

    @NotNull
    public final ICrossProcessService getCrossProcessService(@NotNull Context r2) {
        Intrinsics.f(r2, "context");
        if (iCrossProcessService != null) goto L15;
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L6:
        if (iCrossProcessService != null) goto L11;
        iCrossProcessService = new CrossProcessService(r2);     // Catch: Throwable -> L9
    L11:
        monitor-exit(this);
    L15:
        ICrossProcessService r1 = iCrossProcessService;
        Intrinsics.c(r1);
        return r1;
    }
}
