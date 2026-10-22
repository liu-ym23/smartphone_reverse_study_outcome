package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractBaseGraph<N> implements BaseGraph<N> {
    AbstractBaseGraph() {
    }

    protected long edgeCount() {
        Iterator<N> r0 = nodes().iterator();
        long r3 = 0;
    L4:
        if (r0.hasNext() == false) goto L7;
        r3 = r3 + ((long) degree(r0.next()));
        goto L4
    L7:
        if ((1 & r3) != 0) goto L9;
        boolean r7 = true;
    L10:
        Preconditions.checkState(r7);
        return r3 >>> 1;
    L9:
        r7 = false;
        goto L10
    }

    @Override // com.google.common.graph.BaseGraph
    public Set<EndpointPair<N>> edges() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.graph.BaseGraph
    public ElementOrder<N> incidentEdgeOrder() {
        return ElementOrder.unordered();
    }

    @Override // com.google.common.graph.BaseGraph
    public Set<EndpointPair<N>> incidentEdges(final N r3) {
        Preconditions.checkNotNull(r3);
        Preconditions.checkArgument(nodes().contains(r3), "Node %s is not an element of this graph.", r3);
        return new AnonymousClass2(this, this, r3);
    }

    @Override // com.google.common.graph.BaseGraph
    public int degree(N r2) {
        if (isDirected() == true) goto L5;
        Set<N> r0 = adjacentNodes(r2);
        if (allowsSelfLoops() == true) goto L9;
    L11:
        int r1 = 0;
    L13:
        return IntMath.saturatedAdd(r0.size(), r1);
    L9:
        if (r0.contains(r2) == false) goto L11;
        r1 = 1;
        goto L13
    L5:
        return IntMath.saturatedAdd(predecessors(r2).size(), successors(r2).size());
    }

    @Override // com.google.common.graph.BaseGraph
    public int inDegree(N r2) {
        if (isDirected() == false) goto L6;
        return predecessors(r2).size();
    L6:
        return degree(r2);
    }

    @Override // com.google.common.graph.BaseGraph
    public int outDegree(N r2) {
        if (isDirected() == false) goto L6;
        return successors(r2).size();
    L6:
        return degree(r2);
    }

    @Override // com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(N r2, N r3) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        if (nodes().contains(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (successors(r2).contains(r3) == false) goto L7;
        return true;
    }

    @Override // com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(EndpointPair<N> r4) {
        Preconditions.checkNotNull(r4);
        if (isOrderingCompatible(r4) == true) goto L5;
        return false;
    L5:
        N r0 = r4.nodeU();
        N r5 = r4.nodeV();
        if (nodes().contains(r0) == true) goto L8;
        return false;
    L8:
        if (successors(r0).contains(r5) == false) goto L12;
        return true;
    L12:
        return false;
    }

    protected final void validateEndpoints(EndpointPair<?> r1) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkArgument(isOrderingCompatible(r1), "Mismatch: unordered endpoints cannot be used with directed graphs");
    }

    protected final boolean isOrderingCompatible(EndpointPair<?> r1) {
        if (r1.isOrdered() == false) goto L5;
    L8:
        return true;
    L5:
        if (isDirected() == false) goto L8;
        return false;
    }
}
