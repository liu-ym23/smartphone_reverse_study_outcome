package org.apache.commons.math3.geometry.partitioning;

import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
public class BoundaryAttribute<S extends Space> {
    private final SubHyperplane<S> plusInside;
    private final SubHyperplane<S> plusOutside;
    private final NodesSet<S> splitters;

    @Deprecated
    public BoundaryAttribute(SubHyperplane<S> r2, SubHyperplane<S> r3) {
        this(r2, r3, null);
    }

    BoundaryAttribute(SubHyperplane<S> r1, SubHyperplane<S> r2, NodesSet<S> r3) {
        this.plusOutside = r1;
        this.plusInside = r2;
        this.splitters = r3;
    }

    public SubHyperplane<S> getPlusOutside() {
        return this.plusOutside;
    }

    public SubHyperplane<S> getPlusInside() {
        return this.plusInside;
    }

    public NodesSet<S> getSplitters() {
        return this.splitters;
    }
}
