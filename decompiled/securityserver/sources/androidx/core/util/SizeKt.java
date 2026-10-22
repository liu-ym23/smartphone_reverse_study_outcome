package androidx.core.util;

import android.util.Size;
import android.util.SizeF;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SizeKt {
    @RequiresApi(21)
    public static final int component1(@NotNull Size r1) {
        Intrinsics.g(r1, "$this$component1");
        return r1.getWidth();
    }

    @RequiresApi(21)
    public static final int component2(@NotNull Size r1) {
        Intrinsics.g(r1, "$this$component2");
        return r1.getHeight();
    }

    @RequiresApi(21)
    public static final float component1(@NotNull SizeF r1) {
        Intrinsics.g(r1, "$this$component1");
        return r1.getWidth();
    }

    @RequiresApi(21)
    public static final float component2(@NotNull SizeF r1) {
        Intrinsics.g(r1, "$this$component2");
        return r1.getHeight();
    }
}
