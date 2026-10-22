package kotlin.ranges;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.WasExperimental;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
@WasExperimental
public final class UIntRange extends UIntProgression implements ClosedRange<UInt> {

    @Metadata
    public static final class Companion {
    }

    static {
        new UIntRange();
    }

    @Override // kotlin.ranges.UIntProgression
    public final boolean equals(Object r3) {
        if ((r3 instanceof UIntRange) == true) goto L5;
    L13:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        UIntRange r4 = (UIntRange) r3;
        int r0 = r4.b;
        if (this.b != r0) goto L13;
        int r5 = r4.c;
        if (this.c != r5) goto L13;
    L12:
        return true;
    L7:
        if (((UIntRange) r3).isEmpty() == true) goto L12;
        goto L8
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable getEndInclusive() {
        return new UInt(this.c);
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable getStart() {
        return new UInt(this.b);
    }

    @Override // kotlin.ranges.UIntProgression
    public final int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        int r0 = this.b * 31;
        return this.c + r0;
    }

    @Override // kotlin.ranges.UIntProgression
    public final boolean isEmpty() {
        if (UnsignedKt.a(this.b, this.c) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.ranges.UIntProgression
    public final String toString() {
        return UInt.a(this.b) + ".." + UInt.a(this.c);
    }
}
