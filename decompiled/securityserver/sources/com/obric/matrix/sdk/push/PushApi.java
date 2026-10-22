package com.obric.matrix.sdk.push;

import android.content.Context;
import com.obric.matrix.push.common.log.ILogger;
import com.obric.matrix.push.common.log.Logger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class PushApi {

    @NotNull
    public static final PushApi INSTANCE = null;

    @NotNull
    private static final Lazy pushService$delegate = null;

    static {
        INSTANCE = new PushApi();
        pushService$delegate = LazyKt.b(PushApi$pushService$2.INSTANCE);
    }

    private PushApi() {
    }

    private final PushImpl getPushService() {
        return (PushImpl) pushService$delegate.getValue();
    }

    @JvmStatic
    public static final void registerPush(@NotNull Context r1, @NotNull PushConfiguration r2, @NotNull IRegisterCallback r3) {
        Intrinsics.f(r1, "context");
        Intrinsics.f(r2, "pushConfiguration");
        Intrinsics.f(r3, "registerCallback");
        INSTANCE.getPushService().registerPush(r1, r2, r3);
    }

    @JvmStatic
    public static final void setLogger(boolean r1, @NotNull ILogger r2) {
        Intrinsics.f(r2, "logger");
        Logger.INSTANCE.init(r1, r2);
    }

    public static /* synthetic */ void setLogger$default(boolean r0, ILogger r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r0 = true;
    L5:
        setLogger(r0, r1);
    }

    @JvmStatic
    public static final void unRegisterPush(@NotNull Context r1) {
        Intrinsics.f(r1, "context");
        INSTANCE.getPushService().unRegisterPush(r1);
    }
}
