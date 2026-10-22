package org.apache.commons.math3.geometry.spherical.twod;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import org.apache.commons.math3.geometry.spherical.oned.ArcsSet;
import org.apache.commons.math3.geometry.spherical.oned.Sphere1D;

/* JADX INFO: loaded from: classes6.dex */
public class SubCircle extends AbstractSubHyperplane<Sphere2D, Sphere1D> {
    public SubCircle(Hyperplane<Sphere2D> r1, Region<Sphere1D> r2) {
        super(r1, r2);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane
    protected AbstractSubHyperplane<Sphere2D, Sphere1D> buildNew(Hyperplane<Sphere2D> r1, Region<Sphere1D> r2) {
        return new SubCircle(r1, r2);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane, org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public SubHyperplane.SplitSubHyperplane<Sphere2D> split(Hyperplane<Sphere2D> r10) {
        Circle r0 = (Circle) getHyperplane();
        Circle r11 = (Circle) r10;
        double r1 = Vector3D.angle(r0.getPole(), r11.getPole());
        SubCircle r4 = null;
        if (r1 < r0.getTolerance()) goto L17;
        if (r1 > (3.141592653589793d - r0.getTolerance())) goto L17;
        ArcsSet.Split r9 = ((ArcsSet) getRemainingRegion()).split(r0.getInsideArc(r11));
        ArcsSet r12 = r9.getPlus();
        ArcsSet r13 = r9.getMinus();
        if (r12 != null) goto L10;
        SubCircle r2 = null;
    L11:
        if (r13 == null) goto L15;
        r4 = new SubCircle(r0.copySelf(), r13);
    L15:
        return new SubHyperplane.SplitSubHyperplane(r2, r4);
    L10:
        r2 = new SubCircle(r0.copySelf(), r12);
    L17:
        return new SubHyperplane.SplitSubHyperplane(null, null);
    }
}
