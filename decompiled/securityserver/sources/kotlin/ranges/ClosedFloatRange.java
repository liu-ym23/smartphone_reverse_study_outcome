package kotlin.ranges;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class ClosedFloatRange implements ClosedFloatingPointRange<Float> {
    public final boolean equals(Object r1) {
        if ((r1 instanceof ClosedFloatRange) == false) goto L5;
        ClosedFloatRange r2 = (ClosedFloatRange) r1;
        r2.getClass();
        r2.getClass();
        return true;
    L5:
        return false;
    }

    @Override // kotlin.ranges.ClosedRange
    public final /* bridge */ /* synthetic */ Comparable getEndInclusive() {
        return Float.valueOf(0.0f);
    }

    @Override // kotlin.ranges.ClosedRange
    public final /* bridge */ /* synthetic */ Comparable getStart() {
        return Float.valueOf(0.0f);
    }

    public final int hashCode() {
        int r0 = Float.valueOf(0.0f).hashCode() * 31;
        return Float.valueOf(0.0f).hashCode() + r0;
    }

    public final String toString() {
        return "0.0..0.0";
    }
}
