package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CharRange extends CharProgression implements ClosedRange<Character> {

    @Metadata
    public static final class Companion {
    }

    static {
        new CharRange();
    }

    @Override // kotlin.ranges.CharProgression
    public final boolean equals(Object r3) {
        if ((r3 instanceof CharRange) == true) goto L5;
    L13:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        CharRange r4 = (CharRange) r3;
        char r0 = r4.b;
        if (this.b != r0) goto L13;
        char r5 = r4.c;
        if (this.c != r5) goto L13;
    L12:
        return true;
    L7:
        if (((CharRange) r3).isEmpty() == true) goto L12;
        goto L8
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable getEndInclusive() {
        return Character.valueOf(this.c);
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable getStart() {
        return Character.valueOf(this.b);
    }

    @Override // kotlin.ranges.CharProgression
    public final int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        int r0 = this.b * 31;
        return this.c + r0;
    }

    @Override // kotlin.ranges.CharProgression
    public final boolean isEmpty() {
        if (Intrinsics.h(this.b, this.c) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.ranges.CharProgression
    public final String toString() {
        return this.b + ".." + this.c;
    }
}
