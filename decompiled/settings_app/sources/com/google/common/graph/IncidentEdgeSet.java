package com.google.common.graph;

import java.util.AbstractSet;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class IncidentEdgeSet<N> extends AbstractSet<EndpointPair<N>> {
    final BaseGraph<N> graph;
    final N node;

    IncidentEdgeSet(BaseGraph<N> r1, N r2) {
        this.graph = r1;
        this.node = r2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(@CheckForNull Object r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        if (this.graph.isDirected() == false) goto L7;
        return (this.graph.inDegree(this.node) + this.graph.outDegree(this.node)) - (this.graph.successors(this.node).contains(this.node) ? 1 : 0);
    L7:
        return this.graph.adjacentNodes(this.node).size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object r6) {
        if ((r6 instanceof EndpointPair) == true) goto L5;
        return false;
    L5:
        EndpointPair r7 = (EndpointPair) r6;
        if (this.graph.isDirected() == false) goto L21;
        if (r7.isOrdered() == true) goto L10;
        return false;
    L10:
        Object r0 = r7.source();
        Object r8 = r7.target();
        if (this.node.equals(r0) == false) goto L15;
        if (this.graph.successors(this.node).contains(r8) == false) goto L15;
    L19:
        return true;
    L15:
        if (this.node.equals(r8) == true) goto L17;
        return false;
    L17:
        if (this.graph.predecessors(this.node).contains(r0) == true) goto L19;
        return false;
    L21:
        if (r7.isOrdered() == false) goto L23;
        return false;
    L23:
        Set<N> r1 = this.graph.adjacentNodes(this.node);
        Object r3 = r7.nodeU();
        Object r9 = r7.nodeV();
        if (this.node.equals(r9) == false) goto L28;
        if (r1.contains(r3) == false) goto L28;
    L32:
        return true;
    L28:
        if (this.node.equals(r3) == true) goto L30;
        return false;
    L30:
        if (r1.contains(r9) == true) goto L32;
        return false;
    }
}
