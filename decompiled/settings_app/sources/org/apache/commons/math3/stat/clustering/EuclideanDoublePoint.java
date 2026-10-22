package org.apache.commons.math3.stat.clustering;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class EuclideanDoublePoint implements Clusterable<EuclideanDoublePoint>, Serializable {
    private static final long serialVersionUID = 8026472786091227632L;
    private final double[] point;

    @Override // org.apache.commons.math3.stat.clustering.Clusterable
    public /* bridge */ /* synthetic */ EuclideanDoublePoint centroidOf(Collection<EuclideanDoublePoint> r1) {
        return centroidOf2(r1);
    }

    @Override // org.apache.commons.math3.stat.clustering.Clusterable
    public /* bridge */ /* synthetic */ double distanceFrom(EuclideanDoublePoint r1) {
        return distanceFrom2(r1);
    }

    public EuclideanDoublePoint(double[] r1) {
        this.point = r1;
    }

    @Override // org.apache.commons.math3.stat.clustering.Clusterable
    /* JADX INFO: renamed from: centroidOf, reason: avoid collision after fix types in other method */
    public EuclideanDoublePoint centroidOf2(Collection<EuclideanDoublePoint> r9) {
        int r8 = getPoint().length;
        double[] r0 = new double[r8];
        Iterator<EuclideanDoublePoint> r1 = r9.iterator();
    L3:
        int r3 = 0;
        if (r1.hasNext() == false) goto L8;
        EuclideanDoublePoint r2 = r1.next();
    L6:
        if (r3 >= r8) goto L3;
        r0[r3] = r0[r3] + r2.getPoint()[r3];
        r3 = r3 + 1;
    L8:
        if (r3 >= r8) goto L11;
        r0[r3] = r0[r3] / ((double) r9.size());
        r3 = r3 + 1;
        goto L8
    L11:
        return new EuclideanDoublePoint(r0);
    }

    /* JADX INFO: renamed from: distanceFrom, reason: avoid collision after fix types in other method */
    public double distanceFrom2(EuclideanDoublePoint r1) {
        return MathArrays.distance(this.point, r1.getPoint());
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof EuclideanDoublePoint) == true) goto L7;
        return false;
    L7:
        return Arrays.equals(this.point, ((EuclideanDoublePoint) r2).point);
    }

    public double[] getPoint() {
        return this.point;
    }

    public int hashCode() {
        return Arrays.hashCode(this.point);
    }

    public String toString() {
        return Arrays.toString(this.point);
    }
}
