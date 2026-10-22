package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.WasExperimental;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
@WasExperimental
public class ULongProgression implements Iterable<ULong>, KMappedMarker {
    public final long b;
    public final long c;
    public final long e;

    @Metadata
    public static final class Companion {
    }

    public ULongProgression() {
        this.b = -1;
        long r2 = 0;
        if (UnsignedKt.b(-1, 0) >= 0) goto L10;
        long r7 = UnsignedKt.c(0, 1);
        long r0 = UnsignedKt.c(-1, 1);
        int r4 = UnsignedKt.b(r7, r0);
        long r8 = r7 - r0;
        if (r4 >= 0) goto L9;
        r8 = r8 + 1;
    L9:
        r2 = 0 - r8;
    L10:
        this.c = r2;
        this.e = 1;
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof ULongProgression) == true) goto L5;
    L15:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        ULongProgression r6 = (ULongProgression) r5;
        long r0 = r6.b;
        if (this.b != r0) goto L15;
        if (this.c != r6.c) goto L15;
        if (this.e != r6.e) goto L15;
    L14:
        return true;
    L7:
        if (((ULongProgression) r5).isEmpty() == true) goto L14;
        goto L8
    }

    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        long r0 = this.b;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.c;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.e;
        return ((int) ((r4 >>> 32) ^ r4)) + r2;
    }

    public boolean isEmpty() {
        long r0 = this.e;
        long r3 = this.c;
        int r7 = UnsignedKt.b(this.b, r3);
        if (r0 <= 0) goto L6;
        if (r7 > 0) goto L9;
        return false;
    L9:
        return true;
    L6:
        if (r7 < 0) goto L9;
        return false;
    }

    @Override // java.lang.Iterable
    public final Iterator<ULong> iterator() {
        long r1 = this.e;
        return new ULongProgressionIterator(this.c, r1);
    }

    public String toString() {
        long r2 = this.e;
        long r4 = this.c;
        long r6 = this.b;
        if (r2 <= 0) goto L6;
        StringBuilder r8 = new StringBuilder();
        r8.append(ULong.a(r6));
        r8.append("..");
        r8.append(ULong.a(r4));
        r8.append(" step ");
        r8.append(r2);
    L7:
        return r8.toString();
    L6:
        r8 = new StringBuilder();
        r8.append(ULong.a(r6));
        r8.append(" downTo ");
        r8.append(ULong.a(r4));
        r8.append(" step ");
        r8.append(-r2);
        goto L7
    }
}
