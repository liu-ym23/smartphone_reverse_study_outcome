package kotlin.ranges;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class LongRange extends LongProgression implements ClosedRange<Long> {

    @Metadata
    public static final class Companion {
    }

    @Override // kotlin.ranges.LongProgression
    public final boolean equals(Object r5) {
        if ((r5 instanceof LongRange) == true) goto L5;
    L13:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        LongRange r6 = (LongRange) r5;
        r6.getClass();
        if (0 != 0) goto L13;
        r6.getClass();
        if (0 != 0) goto L13;
    L12:
        return true;
    L7:
        if (((LongRange) r5).isEmpty() == true) goto L12;
        goto L8
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable getEndInclusive() {
        return 0L;
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable getStart() {
        return 0L;
    }

    @Override // kotlin.ranges.LongProgression
    public final int hashCode() {
        if (isEmpty() == false) goto L6;
        return -1;
    L6:
        return (int) ((((long) 31) * (0 ^ (0 >>> 32))) + (0 ^ (0 >>> 32)));
    }

    @Override // kotlin.ranges.LongProgression
    public final boolean isEmpty() {
        if (0 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.ranges.LongProgression
    public final String toString() {
        return "0..0";
    }
}
