package kotlin.ranges;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class ClosedDoubleRange implements ClosedFloatingPointRange<Double> {
    public final boolean equals(Object r1) {
        if ((r1 instanceof ClosedDoubleRange) == false) goto L5;
        ClosedDoubleRange r2 = (ClosedDoubleRange) r1;
        r2.getClass();
        r2.getClass();
        return true;
    L5:
        return false;
    }

    @Override // kotlin.ranges.ClosedRange
    public final /* bridge */ /* synthetic */ Comparable getEndInclusive() {
        return Double.valueOf(0.0d);
    }

    @Override // kotlin.ranges.ClosedRange
    public final /* bridge */ /* synthetic */ Comparable getStart() {
        return Double.valueOf(0.0d);
    }

    public final int hashCode() {
        int r2 = Double.valueOf(0.0d).hashCode() * 31;
        return Double.valueOf(0.0d).hashCode() + r2;
    }

    public final String toString() {
        return "0.0..0.0";
    }
}
