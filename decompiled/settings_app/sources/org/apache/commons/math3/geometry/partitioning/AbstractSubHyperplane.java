package org.apache.commons.math3.geometry.partitioning;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractSubHyperplane<S extends Space, T extends Space> implements SubHyperplane<S> {
    private final Hyperplane<S> hyperplane;
    private final Region<T> remainingRegion;

    protected abstract AbstractSubHyperplane<S, T> buildNew(Hyperplane<S> r1, Region<T> r2);

    @Override // org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public abstract SubHyperplane.SplitSubHyperplane<S> split(Hyperplane<S> r1);

    @Override // org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public /* bridge */ /* synthetic */ SubHyperplane copySelf() {
        return copySelf();
    }

    @Override // org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public /* bridge */ /* synthetic */ SubHyperplane reunite(SubHyperplane r1) {
        return reunite(r1);
    }

    protected AbstractSubHyperplane(Hyperplane<S> r1, Region<T> r2) {
        this.hyperplane = r1;
        this.remainingRegion = r2;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public AbstractSubHyperplane<S, T> copySelf() {
        return buildNew(this.hyperplane.copySelf(), this.remainingRegion);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public Hyperplane<S> getHyperplane() {
        return this.hyperplane;
    }

    public Region<T> getRemainingRegion() {
        return this.remainingRegion;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public double getSize() {
        return this.remainingRegion.getSize();
    }

    @Override // org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public AbstractSubHyperplane<S, T> reunite(SubHyperplane<S> r4) {
        return buildNew(this.hyperplane, new RegionFactory().union(this.remainingRegion, ((AbstractSubHyperplane) r4).remainingRegion));
    }

    public AbstractSubHyperplane<S, T> applyTransform(Transform<S, T> r8) {
        Hyperplane<S> r0 = r8.apply(this.hyperplane);
        HashMap r1 = new HashMap();
        BSPTree<T> r9 = recurseTransform(this.remainingRegion.getTree(false), r0, r8, r1);
        Iterator<Map.Entry<BSPTree<T>, BSPTree<T>>> r2 = r1.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L14;
        Map.Entry<BSPTree<T>, BSPTree<T>> r3 = r2.next();
        if (r3.getKey().getCut() == null) goto L4;
        BoundaryAttribute r4 = (BoundaryAttribute) r3.getKey().getAttribute();
        if (r4 == null) goto L4;
        BoundaryAttribute r5 = (BoundaryAttribute) r3.getValue().getAttribute();
        Iterator<BSPTree<S>> r6 = r4.getSplitters().iterator();
    L11:
        if (r6.hasNext() == false) goto L4;
        BSPTree<S> r7 = r6.next();
        r5.getSplitters().add(r1.get(r7));
        goto L11
    L14:
        return buildNew(r0, this.remainingRegion.buildNew(r9));
    }

    private BSPTree<T> recurseTransform(BSPTree<T> r6, Hyperplane<S> r7, Transform<S, T> r8, Map<BSPTree<T>, BSPTree<T>> r9) {
        if (r6.getCut() != null) goto L5;
        BSPTree<T> r5 = new BSPTree(r6.getAttribute());
    L17:
        r9.put(r6, r5);
        return r5;
    L5:
        BoundaryAttribute r0 = (BoundaryAttribute) r6.getAttribute();
        if (r0 == null) goto L16;
        SubHyperplane<T> r2 = null;
        if (r0.getPlusOutside() != null) goto L10;
        SubHyperplane<T> r1 = null;
    L12:
        if (r0.getPlusInside() == null) goto L15;
        r2 = r8.apply(r0.getPlusInside(), this.hyperplane, r7);
    L15:
        r0 = new BoundaryAttribute(r1, r2, new NodesSet());
        goto L16
    L10:
        r1 = r8.apply(r0.getPlusOutside(), this.hyperplane, r7);
    L16:
        r5 = new BSPTree(r8.apply(r6.getCut(), this.hyperplane, r7), recurseTransform(r6.getPlus(), r7, r8, r9), recurseTransform(r6.getMinus(), r7, r8, r9), r0);
        goto L17
    }

    @Override // org.apache.commons.math3.geometry.partitioning.SubHyperplane
    @Deprecated
    public Side side(Hyperplane<S> r1) {
        return split(r1).getSide();
    }

    @Override // org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public boolean isEmpty() {
        return this.remainingRegion.isEmpty();
    }
}
