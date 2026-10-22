package kotlin.ranges;

import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
class ComparableRange<T extends Comparable<? super T>> implements ClosedRange<T> {
    public final boolean equals(Object r2) {
        if ((r2 instanceof ComparableRange) == true) goto L5;
    L13:
        return false;
    L5:
        if (ClosedRange.DefaultImpls.a(this) == false) goto L8;
        ComparableRange r1 = (ComparableRange) r2;
        r1.getClass();
        if (ClosedRange.DefaultImpls.a(r1) == false) goto L8;
    L12:
        return true;
    L8:
        ComparableRange r3 = (ComparableRange) r2;
        r3.getClass();
        if (Intrinsics.a(null, null) == false) goto L13;
        r3.getClass();
        if (Intrinsics.a(null, null) == false) goto L13;
        goto L12
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable getEndInclusive() {
        return null;
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable getStart() {
        return null;
    }

    public final int hashCode() {
        if (ClosedRange.DefaultImpls.a(this) == false) goto L7;
        return -1;
    L7:
        throw null;
    }

    public final String toString() {
        return "null..null";
    }
}
