package org.apache.commons.math3.geometry.euclidean.oned;

import org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;

/* JADX INFO: loaded from: classes6.dex */
public class SubOrientedPoint extends AbstractSubHyperplane<Euclidean1D, Euclidean1D> {
    @Override // org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane, org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public double getSize() {
        return 0.0d;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane, org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public boolean isEmpty() {
        return false;
    }

    public SubOrientedPoint(Hyperplane<Euclidean1D> r1, Region<Euclidean1D> r2) {
        super(r1, r2);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane
    protected AbstractSubHyperplane<Euclidean1D, Euclidean1D> buildNew(Hyperplane<Euclidean1D> r1, Region<Euclidean1D> r2) {
        return new SubOrientedPoint(r1, r2);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane, org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public SubHyperplane.SplitSubHyperplane<Euclidean1D> split(Hyperplane<Euclidean1D> r6) {
        double r0 = r6.getOffset(((OrientedPoint) getHyperplane()).getLocation());
        if (r0 >= (-1.0E-10d)) goto L7;
        return new SubHyperplane.SplitSubHyperplane(null, this);
    L7:
        if (r0 <= 1.0E-10d) goto L11;
        return new SubHyperplane.SplitSubHyperplane(this, null);
    L11:
        return new SubHyperplane.SplitSubHyperplane(null, null);
    }
}
