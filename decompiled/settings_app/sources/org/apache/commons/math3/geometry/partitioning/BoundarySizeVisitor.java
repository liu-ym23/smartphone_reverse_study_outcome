package org.apache.commons.math3.geometry.partitioning;

import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
class BoundarySizeVisitor<S extends Space> implements BSPTreeVisitor<S> {
    private double boundarySize;

    @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
    public void visitLeafNode(BSPTree<S> r1) {
    }

    BoundarySizeVisitor() {
        this.boundarySize = 0.0d;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
    public BSPTreeVisitor.Order visitOrder(BSPTree<S> r1) {
        return BSPTreeVisitor.Order.MINUS_SUB_PLUS;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
    public void visitInternalNode(BSPTree<S> r5) {
        BoundaryAttribute r6 = (BoundaryAttribute) r5.getAttribute();
        if (r6.getPlusOutside() == null) goto L6;
        this.boundarySize += r6.getPlusOutside().getSize();
    L6:
        if (r6.getPlusInside() == null) goto L9;
        this.boundarySize += r6.getPlusInside().getSize();
        return;
    }

    public double getSize() {
        return this.boundarySize;
    }
}
