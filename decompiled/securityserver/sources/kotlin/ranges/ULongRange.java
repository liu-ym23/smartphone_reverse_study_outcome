package kotlin.ranges;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.WasExperimental;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
@WasExperimental
public final class ULongRange extends ULongProgression implements ClosedRange<ULong> {

    @Metadata
    public static final class Companion {
    }

    static {
        new ULongRange();
    }

    @Override // kotlin.ranges.ULongProgression
    public final boolean equals(Object r5) {
        if ((r5 instanceof ULongRange) == true) goto L5;
    L13:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        ULongRange r6 = (ULongRange) r5;
        long r0 = r6.b;
        if (this.b != r0) goto L13;
        long r1 = r6.c;
        if (this.c != r1) goto L13;
    L12:
        return true;
    L7:
        if (((ULongRange) r5).isEmpty() == true) goto L12;
        goto L8
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable getEndInclusive() {
        return new ULong(this.c);
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable getStart() {
        return new ULong(this.b);
    }

    @Override // kotlin.ranges.ULongProgression
    public final int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        long r0 = this.b;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.c;
        return ((int) ((r3 >>> 32) ^ r3)) + r1;
    }

    @Override // kotlin.ranges.ULongProgression
    public final boolean isEmpty() {
        if (UnsignedKt.b(this.b, this.c) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.ranges.ULongProgression
    public final String toString() {
        return ULong.a(this.b) + ".." + ULong.a(this.c);
    }
}
