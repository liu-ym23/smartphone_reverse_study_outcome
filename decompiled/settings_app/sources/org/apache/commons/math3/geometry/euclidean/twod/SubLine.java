package org.apache.commons.math3.geometry.euclidean.twod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D;
import org.apache.commons.math3.geometry.euclidean.oned.Interval;
import org.apache.commons.math3.geometry.euclidean.oned.IntervalsSet;
import org.apache.commons.math3.geometry.euclidean.oned.OrientedPoint;
import org.apache.commons.math3.geometry.euclidean.oned.SubOrientedPoint;
import org.apache.commons.math3.geometry.euclidean.oned.Vector1D;
import org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class SubLine extends AbstractSubHyperplane<Euclidean2D, Euclidean1D> {
    private static final double DEFAULT_TOLERANCE = 1.0E-10d;

    public SubLine(Hyperplane<Euclidean2D> r1, Region<Euclidean1D> r2) {
        super(r1, r2);
    }

    public SubLine(Vector2D r2, Vector2D r3, double r4) {
        super(new Line(r2, r3, r4), buildIntervalSet(r2, r3, r4));
    }

    @Deprecated
    public SubLine(Vector2D r3, Vector2D r4) {
        this(r3, r4, 1.0E-10d);
    }

    public SubLine(Segment r6) {
        super(r6.getLine(), buildIntervalSet(r6.getStart(), r6.getEnd(), r6.getLine().getTolerance()));
    }

    public List<Segment> getSegments() {
        Line r0 = (Line) getHyperplane();
        List<Interval> r7 = ((IntervalsSet) getRemainingRegion()).asList();
        ArrayList r1 = new ArrayList(r7.size());
        Iterator<Interval> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Interval r2 = r8.next();
        r1.add(new Segment(r0.toSpace(new Vector1D(r2.getInf())), r0.toSpace(new Vector1D(r2.getSup())), r0));
        goto L4
    L6:
        return r1;
    }

    public Vector2D intersection(SubLine r5, boolean r6) {
        Line r0 = (Line) getHyperplane();
        Line r1 = (Line) r5.getHyperplane();
        Vector2D r2 = r0.intersection(r1);
        if (r2 != null) goto L5;
        return null;
    L5:
        Region.Location r4 = getRemainingRegion().checkPoint(r0.toSubSpace(r2));
        Region.Location r7 = r5.getRemainingRegion().checkPoint(r1.toSubSpace(r2));
        if (r6 == false) goto L15;
        if (r4 == Region.Location.OUTSIDE) goto L13;
        if (r7 == Region.Location.OUTSIDE) goto L13;
        return r2;
    L13:
        return null;
    L15:
        if (r4 != Region.Location.INSIDE) goto L20;
        if (r7 != Region.Location.INSIDE) goto L20;
        return r2;
    L20:
        return null;
    }

    private static IntervalsSet buildIntervalSet(Vector2D r9, Vector2D r10, double r11) {
        Line r0 = new Line(r9, r10, r11);
        return new IntervalsSet(r0.toSubSpace(r9).getX(), r0.toSubSpace(r10).getX(), r11);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane
    protected AbstractSubHyperplane<Euclidean2D, Euclidean1D> buildNew(Hyperplane<Euclidean2D> r1, Region<Euclidean1D> r2) {
        return new SubLine(r1, r2);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane, org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public SubHyperplane.SplitSubHyperplane<Euclidean2D> split(Hyperplane<Euclidean2D> r10) {
        Line r0 = (Line) getHyperplane();
        Line r11 = (Line) r10;
        Vector2D r1 = r0.intersection(r11);
        double r2 = r0.getTolerance();
        if (r1 != null) goto L15;
        double r3 = r11.getOffset(r0);
        if (r3 >= (-r2)) goto L9;
        return new SubHyperplane.SplitSubHyperplane(null, this);
    L9:
        if (r3 <= r2) goto L13;
        return new SubHyperplane.SplitSubHyperplane(this, null);
    L13:
        return new SubHyperplane.SplitSubHyperplane(null, null);
    L15:
        if (FastMath.sin(r0.getAngle() - r11.getAngle()) >= 0.0d) goto L17;
        boolean r12 = true;
    L18:
        Vector1D r4 = r0.toSubSpace(r1);
        SubOrientedPoint r6 = new OrientedPoint(r4, !r12, r2).wholeHyperplane();
        SubOrientedPoint r13 = new OrientedPoint(r4, r12, r2).wholeHyperplane();
        BSPTree r5 = getRemainingRegion().getTree(false).split(r13);
        if (getRemainingRegion().isEmpty(r5.getPlus()) == false) goto L21;
        BSPTree r7 = new BSPTree(Boolean.FALSE);
    L23:
        if (getRemainingRegion().isEmpty(r5.getMinus()) == false) goto L25;
        BSPTree r9 = new BSPTree(Boolean.FALSE);
    L27:
        return new SubHyperplane.SplitSubHyperplane(new SubLine(r0.copySelf(), new IntervalsSet(r7, r2)), new SubLine(r0.copySelf(), new IntervalsSet(r9, r2)));
    L25:
        r9 = new BSPTree(r13, new BSPTree(Boolean.FALSE), r5.getMinus(), null);
        goto L27
    L21:
        r7 = new BSPTree(r6, new BSPTree(Boolean.FALSE), r5.getPlus(), null);
        goto L23
    L17:
        r12 = false;
        goto L18
    }
}
