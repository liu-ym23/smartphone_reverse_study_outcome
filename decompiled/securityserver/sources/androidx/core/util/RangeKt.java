package androidx.core.util;

import android.util.Range;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class RangeKt {
    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> Range<T> and(@NotNull Range<T> r1, @NotNull Range<T> r2) {
        Intrinsics.g(r1, "$this$and");
        Intrinsics.g(r2, "other");
        Range<T> r3 = r1.intersect(r2);
        Intrinsics.b(r3, "intersect(other)");
        return r3;
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> Range<T> plus(@NotNull Range<T> r1, @NotNull T r2) {
        Intrinsics.g(r1, "$this$plus");
        Intrinsics.g(r2, "value");
        Range<T> r3 = r1.extend(r2);
        Intrinsics.b(r3, "extend(value)");
        return r3;
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> Range<T> rangeTo(@NotNull T r1, @NotNull T r2) {
        Intrinsics.g(r1, "$this$rangeTo");
        Intrinsics.g(r2, "that");
        return new Range(r1, r2);
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> ClosedRange<T> toClosedRange(@NotNull final Range<T> r1) {
        Intrinsics.g(r1, "$this$toClosedRange");
        return (ClosedRange<T>) new AnonymousClass1(r1);
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> Range<T> toRange(@NotNull ClosedRange<T> r2) {
        Intrinsics.g(r2, "$this$toRange");
        return new Range(r2.getStart(), r2.getEndInclusive());
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> Range<T> plus(@NotNull Range<T> r1, @NotNull Range<T> r2) {
        Intrinsics.g(r1, "$this$plus");
        Intrinsics.g(r2, "other");
        Range<T> r3 = r1.extend(r2);
        Intrinsics.b(r3, "extend(other)");
        return r3;
    }
}
