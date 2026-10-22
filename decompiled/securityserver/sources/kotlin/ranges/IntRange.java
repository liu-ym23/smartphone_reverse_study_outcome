package kotlin.ranges;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class IntRange extends IntProgression implements ClosedRange<Integer> {
    public static final IntRange f = null;

    @Metadata
    public static final class Companion {
    }

    static {
        f = new IntRange(1, 0, 1);
    }

    public final boolean b(int r2) {
        if (this.b <= r2) goto L5;
    L7:
        return false;
    L5:
        if (r2 > this.c) goto L7;
        return true;
    }

    @Override // kotlin.ranges.IntProgression
    public final boolean equals(Object r3) {
        if ((r3 instanceof IntRange) == true) goto L5;
    L13:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        IntRange r4 = (IntRange) r3;
        int r0 = r4.b;
        if (this.b != r0) goto L13;
        int r5 = r4.c;
        if (this.c != r5) goto L13;
    L12:
        return true;
    L7:
        if (((IntRange) r3).isEmpty() == true) goto L12;
        goto L8
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable getEndInclusive() {
        return Integer.valueOf(this.c);
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable getStart() {
        return Integer.valueOf(this.b);
    }

    @Override // kotlin.ranges.IntProgression
    public final int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        int r0 = this.b * 31;
        return this.c + r0;
    }

    @Override // kotlin.ranges.IntProgression
    public final boolean isEmpty() {
        if (this.b <= this.c) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.ranges.IntProgression
    public final String toString() {
        return this.b + ".." + this.c;
    }
}
