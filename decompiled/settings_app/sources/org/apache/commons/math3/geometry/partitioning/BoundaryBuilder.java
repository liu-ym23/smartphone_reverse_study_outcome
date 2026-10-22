package org.apache.commons.math3.geometry.partitioning;

import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
class BoundaryBuilder<S extends Space> implements BSPTreeVisitor<S> {
    @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
    public void visitLeafNode(BSPTree<S> r1) {
    }

    BoundaryBuilder() {
    }

    @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
    public BSPTreeVisitor.Order visitOrder(BSPTree<S> r1) {
        return BSPTreeVisitor.Order.PLUS_MINUS_SUB;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
    public void visitInternalNode(BSPTree<S> r7) {
        Characterization r6 = new Characterization(r7.getPlus(), r7.getCut().copySelf());
        SubHyperplane<S> r1 = null;
        if (r6.touchOutside() == false) goto L7;
        Characterization r0 = new Characterization(r7.getMinus(), r6.outsideTouching());
        if (r0.touchInside() == false) goto L7;
        SubHyperplane<S> r2 = r0.insideTouching();
        NodesSet r3 = new NodesSet();
        r3.addAll(r0.getInsideSplitters());
        r3.addAll(r6.getOutsideSplitters());
    L9:
        if (r6.touchInside() == false) goto L16;
        Characterization r4 = new Characterization(r7.getMinus(), r6.insideTouching());
        if (r4.touchOutside() == false) goto L16;
        r1 = r4.outsideTouching();
        if (r3 != null) goto L15;
        r3 = new NodesSet();
    L15:
        r3.addAll(r4.getOutsideSplitters());
        r3.addAll(r6.getInsideSplitters());
    L16:
        if (r3 == null) goto L20;
        BSPTree<S> r8 = r7.getParent();
    L18:
        if (r8 == null) goto L20;
        r3.add(r8);
        r8 = r8.getParent();
    L20:
        r7.setAttribute(new BoundaryAttribute(r2, r1, r3));
        return;
    L7:
        r2 = null;
        r3 = null;
        goto L9
    }
}
