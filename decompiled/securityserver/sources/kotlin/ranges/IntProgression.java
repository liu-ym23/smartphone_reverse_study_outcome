package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class IntProgression implements Iterable<Integer>, KMappedMarker {
    public final int b;
    public final int c;
    public final int e;

    @Metadata
    public static final class Companion {
    }

    public IntProgression(int r2, int r3, int r4) {
        if (r4 == 0) goto L11;
        if (r4 == Integer.MIN_VALUE) goto L9;
        this.b = r2;
        this.c = ProgressionUtilKt.a(r2, r3, r4);
        this.e = r4;
        return;
    L9:
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    L11:
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public final IntProgressionIterator a() {
        int r1 = this.e;
        return new IntProgressionIterator(this.b, this.c, r1);
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof IntProgression) == true) goto L5;
    L15:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        IntProgression r4 = (IntProgression) r3;
        int r0 = r4.b;
        if (this.b != r0) goto L15;
        if (this.c != r4.c) goto L15;
        if (this.e != r4.e) goto L15;
    L14:
        return true;
    L7:
        if (((IntProgression) r3).isEmpty() == true) goto L14;
        goto L8
    }

    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        int r0 = ((this.b * 31) + this.c) * 31;
        return this.e + r0;
    }

    public boolean isEmpty() {
        int r0 = this.e;
        int r3 = this.c;
        int r4 = this.b;
        if (r0 <= 0) goto L6;
        if (r4 > r3) goto L9;
        return false;
    L9:
        return true;
    L6:
        if (r4 < r3) goto L9;
        return false;
    }

    @Override // java.lang.Iterable
    public final /* bridge */ /* synthetic */ Iterator<Integer> iterator() {
        return a();
    }

    public String toString() {
        int r1 = this.c;
        int r2 = this.b;
        int r4 = this.e;
        if (r4 <= 0) goto L6;
        StringBuilder r3 = new StringBuilder();
        r3.append(r2);
        r3.append("..");
        r3.append(r1);
        r3.append(" step ");
    L5:
        r3.append(r4);
        return r3.toString();
    L6:
        r3 = new StringBuilder();
        r3.append(r2);
        r3.append(" downTo ");
        r3.append(r1);
        r3.append(" step ");
        r4 = -r4;
        goto L5
    }
}
