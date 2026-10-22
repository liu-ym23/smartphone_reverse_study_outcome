package com.obric.matrix.platform.sdk.ones.internal.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class KtExt {

    @NotNull
    public static final KtExt INSTANCE = null;

    static {
        INSTANCE = new KtExt();
    }

    private KtExt() {
    }

    public static /* synthetic */ Object tryRun$default(KtExt r0, String r1, Function0 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = "";
    L5:
        Intrinsics.f(r2, "block");
        return r2.invoke();
    L8:
        th = move-exception;
        MLog.e("tryRun " + r1 + ", failed, " + th);
        return null;
    }

    public final <P1, P2> void invokeSafely(@NotNull Function2<? super P1, ? super P2, Unit> r1, P1 r2, P2 r3) {
        Intrinsics.f(r1, "<this>");
        r1.mo7invoke(r2, r3);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        MLog.e("invoke failed, " + th);
    }

    @NotNull
    public final JSONObject toSafeJson(@Nullable String r1) {
        if (r1 == null) goto L10;
        if (r1.length() == 0) goto L10;
        return new JSONObject(r1);
    L13:
        return new JSONObject();
    L10:
        return new JSONObject();
    }

    @Nullable
    public final <T> T tryRun(@Nullable String r2, @NotNull Function0<? extends T> r3) {
        Intrinsics.f(r3, "block");
        return (T) r3.invoke();
    L5:
        th = move-exception;
        MLog.e("tryRun " + r2 + ", failed, " + th);
        return null;
    }
}
