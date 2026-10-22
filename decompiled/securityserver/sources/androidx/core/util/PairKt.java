package androidx.core.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class PairKt {
    public static final <F, S> F component1(@NotNull android.util.Pair<F, S> r1) {
        Intrinsics.g(r1, "$this$component1");
        return (F) r1.first;
    }

    public static final <F, S> S component2(@NotNull android.util.Pair<F, S> r1) {
        Intrinsics.g(r1, "$this$component2");
        return (S) r1.second;
    }

    @NotNull
    public static final <F, S> android.util.Pair<F, S> toAndroidPair(@NotNull kotlin.Pair<? extends F, ? extends S> r2) {
        Intrinsics.g(r2, "$this$toAndroidPair");
        return new android.util.Pair(r2.b, r2.c);
    }

    @NotNull
    public static final <F, S> kotlin.Pair<F, S> toKotlinPair(@NotNull android.util.Pair<F, S> r2) {
        Intrinsics.g(r2, "$this$toKotlinPair");
        return new kotlin.Pair(r2.first, r2.second);
    }
}
