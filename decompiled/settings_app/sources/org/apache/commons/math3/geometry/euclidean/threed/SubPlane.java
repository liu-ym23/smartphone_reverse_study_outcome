package org.apache.commons.math3.geometry.euclidean.threed;

import org.apache.commons.math3.geometry.euclidean.oned.Vector1D;
import org.apache.commons.math3.geometry.euclidean.twod.Euclidean2D;
import org.apache.commons.math3.geometry.euclidean.twod.PolygonsSet;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;

/* JADX INFO: loaded from: classes6.dex */
public class SubPlane extends AbstractSubHyperplane<Euclidean3D, Euclidean2D> {
    public SubPlane(Hyperplane<Euclidean3D> r1, Region<Euclidean2D> r2) {
        super(r1, r2);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane
    protected AbstractSubHyperplane<Euclidean3D, Euclidean2D> buildNew(Hyperplane<Euclidean3D> r1, Region<Euclidean2D> r2) {
        return new SubPlane(r1, r2);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane, org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public SubHyperplane.SplitSubHyperplane<Euclidean3D> split(Hyperplane<Euclidean3D> r13) {
        Plane r14 = (Plane) r13;
        Plane r0 = (Plane) getHyperplane();
        Line r1 = r14.intersection(r0);
        double r2 = r0.getTolerance();
        if (r1 != null) goto L14;
        double r3 = r14.getOffset(r0);
        if (r3 >= (-r2)) goto L9;
        return new SubHyperplane.SplitSubHyperplane(null, this);
    L9:
        if (r3 <= r2) goto L13;
        return new SubHyperplane.SplitSubHyperplane(this, null);
    L13:
        return new SubHyperplane.SplitSubHyperplane(null, null);
    L14:
        Vector2D r5 = r0.toSubSpace(r1.toSpace(Vector1D.ZERO));
        Vector2D r6 = r0.toSubSpace(r1.toSpace(Vector1D.ONE));
        if (Vector3D.crossProduct(r1.getDirection(), r0.getNormal()).dotProduct(r14.getNormal()) >= 0.0d) goto L17;
        r6 = r5;
        r5 = r6;
    L17:
        org.apache.commons.math3.geometry.euclidean.twod.SubLine r15 = new org.apache.commons.math3.geometry.euclidean.twod.Line(r5, r6, r2).wholeHyperplane();
        org.apache.commons.math3.geometry.euclidean.twod.SubLine r4 = new org.apache.commons.math3.geometry.euclidean.twod.Line(r6, r5, r2).wholeHyperplane();
        BSPTree r7 = getRemainingRegion().getTree(false).split(r15);
        if (getRemainingRegion().isEmpty(r7.getPlus()) == false) goto L20;
        BSPTree r8 = new BSPTree(Boolean.FALSE);
    L22:
        if (getRemainingRegion().isEmpty(r7.getMinus()) == false) goto L24;
        BSPTree r12 = new BSPTree(Boolean.FALSE);
    L26:
        return new SubHyperplane.SplitSubHyperplane(new SubPlane(r0.copySelf(), new PolygonsSet(r8, r2)), new SubPlane(r0.copySelf(), new PolygonsSet(r12, r2)));
    L24:
        r12 = new BSPTree(r15, new BSPTree(Boolean.FALSE), r7.getMinus(), null);
        goto L26
    L20:
        r8 = new BSPTree(r4, new BSPTree(Boolean.FALSE), r7.getPlus(), null);
        goto L22
    }
}
