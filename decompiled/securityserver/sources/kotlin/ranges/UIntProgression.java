package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.WasExperimental;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
@WasExperimental
public class UIntProgression implements Iterable<UInt>, KMappedMarker {
    public final int b;
    public final int c;
    public final int e;

    @Metadata
    public static final class Companion {
    }

    public UIntProgression() {
        this.b = -1;
        int r1 = 0;
        if (UnsignedKt.a(-1, 0) >= 0) goto L10;
        long r8 = ((long) 1) & 4294967295L;
        int r2 = (int) ((((long) 0) & 4294967295L) % r8);
        int r0 = (int) ((((long) (-1)) & 4294967295L) % r8);
        int r4 = UnsignedKt.a(r2, r0);
        int r3 = r2 - r0;
        if (r4 >= 0) goto L9;
        r3 = r3 + 1;
    L9:
        r1 = 0 - r3;
    L10:
        this.c = r1;
        this.e = 1;
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof UIntProgression) == true) goto L5;
    L15:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        UIntProgression r4 = (UIntProgression) r3;
        int r0 = r4.b;
        if (this.b != r0) goto L15;
        if (this.c != r4.c) goto L15;
        if (this.e != r4.e) goto L15;
    L14:
        return true;
    L7:
        if (((UIntProgression) r3).isEmpty() == true) goto L14;
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
        int r4 = UnsignedKt.a(this.b, r3);
        if (r0 <= 0) goto L6;
        if (r4 > 0) goto L9;
        return false;
    L9:
        return true;
    L6:
        if (r4 < 0) goto L9;
        return false;
    }

    @Override // java.lang.Iterable
    public final Iterator<UInt> iterator() {
        int r1 = this.e;
        return new UIntProgressionIterator(this.c, r1);
    }

    public String toString() {
        int r1 = this.c;
        int r2 = this.b;
        int r4 = this.e;
        if (r4 <= 0) goto L6;
        StringBuilder r3 = new StringBuilder();
        r3.append(UInt.a(r2));
        r3.append("..");
        r3.append(UInt.a(r1));
        r3.append(" step ");
    L5:
        r3.append(r4);
        return r3.toString();
    L6:
        r3 = new StringBuilder();
        r3.append(UInt.a(r2));
        r3.append(" downTo ");
        r3.append(UInt.a(r1));
        r3.append(" step ");
        r4 = -r4;
        goto L5
    }
}
