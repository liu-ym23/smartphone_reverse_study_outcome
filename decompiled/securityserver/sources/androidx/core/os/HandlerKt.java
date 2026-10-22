package androidx.core.os;

import android.os.Handler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class HandlerKt {
    @NotNull
    public static final Runnable postAtTime(@NotNull Handler r1, long r2, @Nullable Object r4, @NotNull Function0<Unit> r5) {
        Intrinsics.g(r1, "$this$postAtTime");
        Intrinsics.g(r5, "action");
        HandlerKt$postAtTime$runnable$1 r0 = new HandlerKt$postAtTime$runnable$1(r5);
        r1.postAtTime(r0, r4, r2);
        return r0;
    }

    @NotNull
    public static /* synthetic */ Runnable postAtTime$default(Handler r0, long r1, Object r3, Function0 r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L5;
        r3 = null;
    L5:
        Intrinsics.g(r0, "$this$postAtTime");
        Intrinsics.g(r4, "action");
        HandlerKt$postAtTime$runnable$1 r7 = new HandlerKt$postAtTime$runnable$1(r4);
        r0.postAtTime(r7, r3, r1);
        return r7;
    }

    @NotNull
    public static final Runnable postDelayed(@NotNull Handler r1, long r2, @Nullable Object r4, @NotNull Function0<Unit> r5) {
        Intrinsics.g(r1, "$this$postDelayed");
        Intrinsics.g(r5, "action");
        HandlerKt$postDelayed$runnable$1 r0 = new HandlerKt$postDelayed$runnable$1(r5);
        if (r4 != null) goto L5;
        r1.postDelayed(r0, r2);
    L6:
        return r0;
    L5:
        HandlerCompat.postDelayed(r1, r0, r4, r2);
        goto L6
    }

    @NotNull
    public static /* synthetic */ Runnable postDelayed$default(Handler r0, long r1, Object r3, Function0 r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L5;
        r3 = null;
    L5:
        Intrinsics.g(r0, "$this$postDelayed");
        Intrinsics.g(r4, "action");
        HandlerKt$postDelayed$runnable$1 r7 = new HandlerKt$postDelayed$runnable$1(r4);
        if (r3 != null) goto L8;
        r0.postDelayed(r7, r1);
    L9:
        return r7;
    L8:
        HandlerCompat.postDelayed(r0, r7, r3, r1);
        goto L9
    }
}
