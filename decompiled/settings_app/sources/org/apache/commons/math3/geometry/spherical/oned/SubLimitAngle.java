package org.apache.commons.math3.geometry.spherical.oned;

import org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;

/* JADX INFO: loaded from: classes6.dex */
public class SubLimitAngle extends AbstractSubHyperplane<Sphere1D, Sphere1D> {
    @Override // org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane, org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public double getSize() {
        return 0.0d;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane, org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public boolean isEmpty() {
        return false;
    }

    public SubLimitAngle(Hyperplane<Sphere1D> r1, Region<Sphere1D> r2) {
        super(r1, r2);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane
    protected AbstractSubHyperplane<Sphere1D, Sphere1D> buildNew(Hyperplane<Sphere1D> r1, Region<Sphere1D> r2) {
        return new SubLimitAngle(r1, r2);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane, org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public SubHyperplane.SplitSubHyperplane<Sphere1D> split(Hyperplane<Sphere1D> r5) {
        if (r5.getOffset(((LimitAngle) getHyperplane()).getLocation()) >= (-1.0E-10d)) goto L6;
        return new SubHyperplane.SplitSubHyperplane(null, this);
    L6:
        return new SubHyperplane.SplitSubHyperplane(this, null);
    }
}
