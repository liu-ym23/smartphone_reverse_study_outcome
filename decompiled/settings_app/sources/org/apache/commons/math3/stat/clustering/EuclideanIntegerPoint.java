package org.apache.commons.math3.stat.clustering;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class EuclideanIntegerPoint implements Clusterable<EuclideanIntegerPoint>, Serializable {
    private static final long serialVersionUID = 3946024775784901369L;
    private final int[] point;

    @Override // org.apache.commons.math3.stat.clustering.Clusterable
    public /* bridge */ /* synthetic */ EuclideanIntegerPoint centroidOf(Collection<EuclideanIntegerPoint> r1) {
        return centroidOf2(r1);
    }

    @Override // org.apache.commons.math3.stat.clustering.Clusterable
    public /* bridge */ /* synthetic */ double distanceFrom(EuclideanIntegerPoint r1) {
        return distanceFrom2(r1);
    }

    public EuclideanIntegerPoint(int[] r1) {
        this.point = r1;
    }

    public int[] getPoint() {
        return this.point;
    }

    /* JADX INFO: renamed from: distanceFrom, reason: avoid collision after fix types in other method */
    public double distanceFrom2(EuclideanIntegerPoint r1) {
        return MathArrays.distance(this.point, r1.getPoint());
    }

    @Override // org.apache.commons.math3.stat.clustering.Clusterable
    /* JADX INFO: renamed from: centroidOf, reason: avoid collision after fix types in other method */
    public EuclideanIntegerPoint centroidOf2(Collection<EuclideanIntegerPoint> r7) {
        int r6 = getPoint().length;
        int[] r0 = new int[r6];
        Iterator<EuclideanIntegerPoint> r1 = r7.iterator();
    L3:
        int r3 = 0;
        if (r1.hasNext() == false) goto L8;
        EuclideanIntegerPoint r2 = r1.next();
    L6:
        if (r3 >= r6) goto L3;
        r0[r3] = r0[r3] + r2.getPoint()[r3];
        r3 = r3 + 1;
    L8:
        if (r3 >= r6) goto L11;
        r0[r3] = r0[r3] / r7.size();
        r3 = r3 + 1;
        goto L8
    L11:
        return new EuclideanIntegerPoint(r0);
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof EuclideanIntegerPoint) == true) goto L7;
        return false;
    L7:
        return Arrays.equals(this.point, ((EuclideanIntegerPoint) r2).point);
    }

    public int hashCode() {
        return Arrays.hashCode(this.point);
    }

    public String toString() {
        return Arrays.toString(this.point);
    }
}
