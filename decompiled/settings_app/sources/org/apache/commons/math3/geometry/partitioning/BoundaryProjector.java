package org.apache.commons.math3.geometry.partitioning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
class BoundaryProjector<S extends Space, T extends Space> implements BSPTreeVisitor<S> {
    private BSPTree<S> leaf;
    private double offset;
    private final Point<S> original;
    private Point<S> projected;

    BoundaryProjector(Point<S> r3) {
        this.original = r3;
        this.projected = null;
        this.leaf = null;
        this.offset = Double.POSITIVE_INFINITY;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
    public BSPTreeVisitor.Order visitOrder(BSPTree<S> r3) {
        if (r3.getCut().getHyperplane().getOffset(this.original) > 0.0d) goto L7;
        return BSPTreeVisitor.Order.MINUS_SUB_PLUS;
    L7:
        return BSPTreeVisitor.Order.PLUS_SUB_MINUS;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
    public void visitInternalNode(BSPTree<S> r9) {
        Hyperplane<S> r0 = r9.getCut().getHyperplane();
        double r1 = r0.getOffset(this.original);
        if (FastMath.abs(r1) >= this.offset) goto L21;
        Point<S> r3 = r0.project(this.original);
        List<Region<T>> r10 = boundaryRegions(r9);
        Iterator<Region<T>> r4 = r10.iterator();
        boolean r5 = false;
    L6:
        if (r4.hasNext() == false) goto L12;
        Region<T> r6 = r4.next();
        if (r5 == true) goto L6;
        if (belongsToPart(r3, r0, r6) == false) goto L6;
        this.projected = r3;
        this.offset = FastMath.abs(r1);
        r5 = true;
        goto L6
    L12:
        if (r5 == true) goto L36;
        Iterator<Region<T>> r11 = r10.iterator();
    L15:
        if (r11.hasNext() == false) goto L37;
        Point<S> r2 = singularProjection(r3, r0, r11.next());
        if (r2 == null) goto L15;
        double r7 = this.original.distance(r2);
        if (r7 >= this.offset) goto L15;
        this.projected = r2;
        this.offset = r7;
        goto L15
    L37:
        return;
    L36:
        return;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
    public void visitLeafNode(BSPTree<S> r2) {
        if (this.leaf != null) goto L6;
        this.leaf = r2;
        return;
    }

    public BoundaryProjection<S> getProjection() {
        double r0 = this.offset;
        if (((Boolean) this.leaf.getAttribute()).booleanValue() == false) goto L5;
        double r2 = -1.0d;
    L6:
        this.offset = FastMath.copySign(r0, r2);
        return new BoundaryProjection(this.original, this.projected, this.offset);
    L5:
        r2 = 1.0d;
        goto L6
    }

    private List<Region<T>> boundaryRegions(BSPTree<S> r3) {
        ArrayList r0 = new ArrayList(2);
        BoundaryAttribute r4 = (BoundaryAttribute) r3.getAttribute();
        addRegion(r4.getPlusInside(), r0);
        addRegion(r4.getPlusOutside(), r0);
        return r0;
    }

    private void addRegion(SubHyperplane<S> r1, List<Region<T>> r2) {
        if (r1 == null) goto L7;
        Region<T> r0 = ((AbstractSubHyperplane) r1).getRemainingRegion();
        if (r0 == null) goto L8;
        r2.add(r0);
        return;
    L8:
        return;
    }

    private boolean belongsToPart(Point<S> r1, Hyperplane<S> r2, Region<T> r3) {
        if (r3.checkPoint(((Embedding) r2).toSubSpace(r1)) == Region.Location.OUTSIDE) goto L5;
        return true;
    L5:
        return false;
    }

    private Point<S> singularProjection(Point<S> r1, Hyperplane<S> r2, Region<T> r3) {
        Embedding r4 = (Embedding) r2;
        BoundaryProjection<S> r0 = r3.projectToBoundary(r4.toSubSpace(r1));
        if (r0.getProjected() != null) goto L6;
        return null;
    L6:
        return r4.toSpace(r0.getProjected());
    }
}
