package org.apache.commons.math3.geometry.euclidean.oned;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.partitioning.AbstractRegion;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.BoundaryProjection;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class IntervalsSet extends AbstractRegion<Euclidean1D, Euclidean1D> implements Iterable<double[]> {
    private static final double DEFAULT_TOLERANCE = 1.0E-10d;

    private class SubIntervalsIterator implements Iterator<double[]> {
        private BSPTree<Euclidean1D> current;
        private double[] pending;
        final /* synthetic */ IntervalsSet this$0;

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ double[] next() {
            return next2();
        }

        SubIntervalsIterator(IntervalsSet r6) {
            this.this$0 = r6;
            BSPTree<Euclidean1D> r0 = IntervalsSet.access$000(r6);
            this.current = r0;
            if (r0 != null) goto L9;
            if (((Boolean) IntervalsSet.access$100(r6, r6.getTree(false)).getAttribute()).booleanValue() == false) goto L7;
            this.pending = new double[]{Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY};
            return;
        L7:
            this.pending = null;
            return;
        L9:
            if (IntervalsSet.access$200(r6, r0) == false) goto L11;
            this.pending = new double[]{Double.NEGATIVE_INFINITY, IntervalsSet.access$300(r6, this.current)};
            return;
        L11:
            selectPending();
        }

        private void selectPending() {
            BSPTree<Euclidean1D> r0 = this.current;
        L3:
            if (r0 == null) goto L8;
            if (IntervalsSet.access$400(this.this$0, r0) == true) goto L8;
            r0 = IntervalsSet.access$500(this.this$0, r0);
        L8:
            if (r0 != null) goto L11;
            this.current = null;
            this.pending = null;
            return;
        L11:
            BSPTree<Euclidean1D> r2 = r0;
        L12:
            if (r2 == null) goto L17;
            if (IntervalsSet.access$200(this.this$0, r2) == true) goto L17;
            r2 = IntervalsSet.access$500(this.this$0, r2);
        L17:
            if (r2 == null) goto L19;
            this.pending = new double[]{IntervalsSet.access$300(this.this$0, r0), IntervalsSet.access$300(this.this$0, r2)};
            this.current = r2;
            return;
        L19:
            this.pending = new double[]{IntervalsSet.access$300(this.this$0, r0), Double.POSITIVE_INFINITY};
            this.current = null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.pending == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public double[] next2() {
            double[] r0 = this.pending;
            if (r0 == null) goto L7;
            selectPending();
            return r0;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    static /* synthetic */ BSPTree access$000(IntervalsSet r0) {
        return r0.getFirstIntervalBoundary();
    }

    static /* synthetic */ BSPTree access$100(IntervalsSet r0, BSPTree r1) {
        return r0.getFirstLeaf(r1);
    }

    static /* synthetic */ boolean access$200(IntervalsSet r0, BSPTree r1) {
        return r0.isIntervalEnd(r1);
    }

    static /* synthetic */ double access$300(IntervalsSet r0, BSPTree r1) {
        return r0.getAngle(r1);
    }

    static /* synthetic */ boolean access$400(IntervalsSet r0, BSPTree r1) {
        return r0.isIntervalStart(r1);
    }

    static /* synthetic */ BSPTree access$500(IntervalsSet r0, BSPTree r1) {
        return r0.nextInternalNode(r1);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ AbstractRegion buildNew(BSPTree r1) {
        return buildNew(r1);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ Region buildNew(BSPTree r1) {
        return buildNew(r1);
    }

    public IntervalsSet(double r1) {
        super(r1);
    }

    public IntervalsSet(double r1, double r3, double r5) {
        super(buildTree(r1, r3, r5), r5);
    }

    public IntervalsSet(BSPTree<Euclidean1D> r1, double r2) {
        super(r1, r2);
    }

    public IntervalsSet(Collection<SubHyperplane<Euclidean1D>> r1, double r2) {
        super(r1, r2);
    }

    @Deprecated
    public IntervalsSet() {
        this(1.0E-10d);
    }

    @Deprecated
    public IntervalsSet(double r8, double r10) {
        this(r8, r10, 1.0E-10d);
    }

    @Deprecated
    public IntervalsSet(BSPTree<Euclidean1D> r3) {
        this(r3, 1.0E-10d);
    }

    @Deprecated
    public IntervalsSet(Collection<SubHyperplane<Euclidean1D>> r3) {
        this(r3, 1.0E-10d);
    }

    private static BSPTree<Euclidean1D> buildTree(double r6, double r8, double r10) {
        if (Double.isInfinite(r6) == true) goto L5;
    L14:
        SubOrientedPoint r7 = new OrientedPoint(new Vector1D(r6), false, r10).wholeHyperplane();
        if (Double.isInfinite(r8) == true) goto L17;
    L20:
        SubOrientedPoint r9 = new OrientedPoint(new Vector1D(r8), true, r10).wholeHyperplane();
        return new BSPTree(r7, new BSPTree(Boolean.FALSE), new BSPTree(r9, new BSPTree(Boolean.FALSE), new BSPTree(Boolean.TRUE), null), null);
    L17:
        if (r8 <= 0.0d) goto L20;
        return new BSPTree(r7, new BSPTree(Boolean.FALSE), new BSPTree(Boolean.TRUE), null);
    L5:
        if (r6 >= 0.0d) goto L14;
        if (Double.isInfinite(r8) == false) goto L13;
        if (r8 <= 0.0d) goto L13;
        return new BSPTree(Boolean.TRUE);
    L13:
        return new BSPTree(new OrientedPoint(new Vector1D(r8), true, r10).wholeHyperplane(), new BSPTree(Boolean.FALSE), new BSPTree(Boolean.TRUE), null);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public IntervalsSet buildNew(BSPTree<Euclidean1D> r4) {
        return new IntervalsSet(r4, getTolerance());
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion
    protected void computeGeometricalProperties() {
        double r2 = 0.0d;
        if (getTree(false).getCut() != null) goto L8;
        setBarycenter(Vector1D.NaN);
        if (((Boolean) getTree(false).getAttribute()).booleanValue() == false) goto L7;
        r2 = Double.POSITIVE_INFINITY;
    L7:
        setSize(r2);
        return;
    L8:
        Iterator<Interval> r1 = asList().iterator();
        double r4 = 0.0d;
    L10:
        if (r1.hasNext() == false) goto L12;
        Interval r6 = r1.next();
        r2 = r2 + r6.getSize();
        r4 = r4 + (r6.getSize() * r6.getBarycenter());
        goto L10
    L12:
        setSize(r2);
        if (Double.isInfinite(r2) == false) goto L16;
        setBarycenter(Vector1D.NaN);
        return;
    L16:
        if (r2 < Precision.SAFE_MIN) goto L18;
        setBarycenter(new Vector1D(r4 / r2));
        return;
    L18:
        setBarycenter(((OrientedPoint) getTree(false).getCut().getHyperplane()).getLocation());
    }

    public double getInf() {
        BSPTree<Euclidean1D> r3 = getTree(false);
        double r0 = Double.POSITIVE_INFINITY;
    L4:
        if (r3.getCut() == null) goto L11;
        OrientedPoint r1 = (OrientedPoint) r3.getCut().getHyperplane();
        double r2 = r1.getLocation().getX();
        if (r1.isDirect() == false) goto L8;
        r3 = r3.getMinus();
    L9:
        r0 = r2;
        goto L4
    L8:
        r3 = r3.getPlus();
        goto L9
    L11:
        if (((Boolean) r3.getAttribute()).booleanValue() == false) goto L17;
        return Double.NEGATIVE_INFINITY;
    L17:
        return r0;
    }

    public double getSup() {
        BSPTree<Euclidean1D> r3 = getTree(false);
        double r0 = Double.NEGATIVE_INFINITY;
    L4:
        if (r3.getCut() == null) goto L11;
        OrientedPoint r1 = (OrientedPoint) r3.getCut().getHyperplane();
        double r2 = r1.getLocation().getX();
        if (r1.isDirect() == false) goto L8;
        r3 = r3.getPlus();
    L9:
        r0 = r2;
        goto L4
    L8:
        r3 = r3.getMinus();
        goto L9
    L11:
        if (((Boolean) r3.getAttribute()).booleanValue() == false) goto L17;
        return Double.POSITIVE_INFINITY;
    L17:
        return r0;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public BoundaryProjection<Euclidean1D> projectToBoundary(Point<Euclidean1D> r12) {
        double r0 = ((Vector1D) r12).getX();
        Iterator<double[]> r2 = iterator();
        double r3 = Double.NEGATIVE_INFINITY;
    L4:
        if (r2.hasNext() == false) goto L23;
        double[] r5 = r2.next();
        double r7 = r5[0];
        if (r0 < r7) goto L7;
        double r9 = r5[1];
        if (r0 <= r9) goto L15;
        r3 = r9;
        goto L4
    L15:
        double r8 = r7 - r0;
        double r1 = r0 - r9;
        if (r8 >= r1) goto L20;
        return new BoundaryProjection(r12, finiteOrNullPoint(r5[1]), r1);
    L20:
        return new BoundaryProjection(r12, finiteOrNullPoint(r5[0]), r8);
    L7:
        double r10 = r0 - r3;
        double r11 = r7 - r0;
        if (r10 >= r11) goto L12;
        return new BoundaryProjection(r12, finiteOrNullPoint(r3), r10);
    L12:
        return new BoundaryProjection(r12, finiteOrNullPoint(r5[0]), r11);
    L23:
        return new BoundaryProjection(r12, finiteOrNullPoint(r3), r0 - r3);
    }

    private Vector1D finiteOrNullPoint(double r1) {
        if (Double.isInfinite(r1) == false) goto L6;
        return null;
    L6:
        return new Vector1D(r1);
    }

    public List<Interval> asList() {
        ArrayList r0 = new ArrayList();
        Iterator<double[]> r7 = iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        double[] r1 = r7.next();
        r0.add(new Interval(r1[0], r1[1]));
        goto L4
    L6:
        return r0;
    }

    private BSPTree<Euclidean1D> getFirstLeaf(BSPTree<Euclidean1D> r3) {
        if (r3.getCut() != null) goto L5;
        return r3;
    L5:
        BSPTree<Euclidean1D> r0 = null;
    L6:
        if (r3 == null) goto L9;
        r0 = r3;
        r3 = previousInternalNode(r3);
        goto L6
    L9:
        return leafBefore(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [org.apache.commons.math3.geometry.euclidean.oned.IntervalsSet] */
    private BSPTree<Euclidean1D> getFirstIntervalBoundary() {
        BSPTree r0 = getTree(false);
        if (r0.getCut() != null) goto L6;
        return null;
    L6:
        BSPTree r1 = getFirstLeaf(r0).getParent();
    L7:
        if (r1 == null) goto L13;
        if (isIntervalStart(r1) == true) goto L13;
        if (isIntervalEnd(r1) == true) goto L13;
        r1 = nextInternalNode(r1);
    L13:
        return r1;
    }

    private boolean isIntervalStart(BSPTree<Euclidean1D> r3) {
        if (((Boolean) leafBefore(r3).getAttribute()).booleanValue() == false) goto L6;
        return false;
    L6:
        if (((Boolean) leafAfter(r3).getAttribute()).booleanValue() == true) goto L8;
        return false;
    L8:
        return true;
    }

    private boolean isIntervalEnd(BSPTree<Euclidean1D> r3) {
        if (((Boolean) leafBefore(r3).getAttribute()).booleanValue() == true) goto L6;
        return false;
    L6:
        if (((Boolean) leafAfter(r3).getAttribute()).booleanValue() == false) goto L8;
        return false;
    L8:
        return true;
    }

    private BSPTree<Euclidean1D> nextInternalNode(BSPTree<Euclidean1D> r2) {
        if (childAfter(r2).getCut() == null) goto L7;
        return leafAfter(r2).getParent();
    L7:
        if (isAfterParent(r2) == false) goto L10;
        r2 = r2.getParent();
        goto L7
    L10:
        return r2.getParent();
    }

    private BSPTree<Euclidean1D> previousInternalNode(BSPTree<Euclidean1D> r2) {
        if (childBefore(r2).getCut() == null) goto L7;
        return leafBefore(r2).getParent();
    L7:
        if (isBeforeParent(r2) == false) goto L10;
        r2 = r2.getParent();
        goto L7
    L10:
        return r2.getParent();
    }

    private BSPTree<Euclidean1D> leafBefore(BSPTree<Euclidean1D> r2) {
        BSPTree<Euclidean1D> r3 = childBefore(r2);
    L4:
        if (r3.getCut() == null) goto L6;
        r3 = childAfter(r3);
        goto L4
    L6:
        return r3;
    }

    private BSPTree<Euclidean1D> leafAfter(BSPTree<Euclidean1D> r2) {
        BSPTree<Euclidean1D> r3 = childAfter(r2);
    L4:
        if (r3.getCut() == null) goto L6;
        r3 = childBefore(r3);
        goto L4
    L6:
        return r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isBeforeParent(BSPTree<Euclidean1D> r3) {
        BSPTree<S> r0 = r3.getParent();
        if (r0 != 0) goto L6;
        return false;
    L6:
        if (r3 != childBefore(r0)) goto L9;
        return true;
    L9:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isAfterParent(BSPTree<Euclidean1D> r3) {
        BSPTree<S> r0 = r3.getParent();
        if (r0 != 0) goto L6;
        return false;
    L6:
        if (r3 != childAfter(r0)) goto L9;
        return true;
    L9:
        return false;
    }

    private BSPTree<Euclidean1D> childBefore(BSPTree<Euclidean1D> r1) {
        if (isDirect(r1) == false) goto L7;
        return r1.getMinus();
    L7:
        return r1.getPlus();
    }

    private BSPTree<Euclidean1D> childAfter(BSPTree<Euclidean1D> r1) {
        if (isDirect(r1) == false) goto L7;
        return r1.getPlus();
    L7:
        return r1.getMinus();
    }

    private boolean isDirect(BSPTree<Euclidean1D> r1) {
        return ((OrientedPoint) r1.getCut().getHyperplane()).isDirect();
    }

    private double getAngle(BSPTree<Euclidean1D> r1) {
        return ((OrientedPoint) r1.getCut().getHyperplane()).getLocation().getX();
    }

    @Override // java.lang.Iterable
    public Iterator<double[]> iterator() {
        return new SubIntervalsIterator(this);
    }
}
