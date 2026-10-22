package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class LongProgression implements Iterable<Long>, KMappedMarker {

    @Metadata
    public static final class Companion {
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof LongProgression) == true) goto L5;
    L15:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        LongProgression r6 = (LongProgression) r5;
        r6.getClass();
        if (0 != 0) goto L15;
        r6.getClass();
        if (0 != 0) goto L15;
        r6.getClass();
        if (0 != 0) goto L15;
    L14:
        return true;
    L7:
        if (((LongProgression) r5).isEmpty() == true) goto L14;
        goto L8
    }

    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        long r0 = 31;
        return (int) (((((0 ^ (0 >>> 32)) * r0) + (0 ^ (0 >>> 32))) * r0) + (0 ^ (0 >>> 32)));
    }

    public boolean isEmpty() {
        if (0 <= 0) goto L8;
        if (0 > 0) goto L11;
        return false;
    L11:
        return true;
    L8:
        if (0 < 0) goto L11;
        return false;
    }

    @Override // java.lang.Iterable
    public final Iterator<Long> iterator() {
        return new LongProgressionIterator(0, 0);
    }

    public String toString() {
        if (0 <= 0) goto L6;
        StringBuilder r8 = new StringBuilder();
        r8.append(0);
        r8.append("..");
        r8.append(0);
        r8.append(" step ");
        r8.append(0);
    L7:
        return r8.toString();
    L6:
        r8 = new StringBuilder();
        r8.append(0);
        r8.append(" downTo ");
        r8.append(0);
        r8.append(" step ");
        r8.append(-0);
        goto L7
    }
}
