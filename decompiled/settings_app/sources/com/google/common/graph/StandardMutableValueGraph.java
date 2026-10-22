package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class StandardMutableValueGraph<N, V> extends StandardValueGraph<N, V> implements MutableValueGraph<N, V> {
    private final ElementOrder<N> incidentEdgeOrder;

    StandardMutableValueGraph(AbstractGraphBuilder<? super N> r1) {
        super(r1);
        this.incidentEdgeOrder = (ElementOrder<N>) r1.incidentEdgeOrder.cast();
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public ElementOrder<N> incidentEdgeOrder() {
        return this.incidentEdgeOrder;
    }

    @Override // com.google.common.graph.MutableValueGraph
    public boolean addNode(N r2) {
        Preconditions.checkNotNull(r2, "node");
        if (containsNode(r2) == false) goto L6;
        return false;
    L6:
        addNodeInternal(r2);
        return true;
    }

    private GraphConnections<N, V> addNodeInternal(N r2) {
        GraphConnections<N, V> r0 = newConnections();
        if (this.nodeConnections.put(r2, r0) != null) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkState(r1);
        return r0;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CheckForNull
    public V putEdgeValue(N r4, N r5, V r6) {
        Preconditions.checkNotNull(r4, "nodeU");
        Preconditions.checkNotNull(r5, "nodeV");
        Preconditions.checkNotNull(r6, "value");
        if (allowsSelfLoops() == true) goto L5;
        Preconditions.checkArgument(!r4.equals(r5), "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", r4);
    L5:
        GraphConnections<N, V> r0 = this.nodeConnections.get(r4);
        if (r0 != null) goto L8;
        r0 = addNodeInternal(r4);
    L8:
        V r1 = r0.addSuccessor(r5, r6);
        GraphConnections<N, V> r2 = this.nodeConnections.get(r5);
        if (r2 != null) goto L11;
        r2 = addNodeInternal(r5);
    L11:
        r2.addPredecessor(r4, r6);
        if (r1 != null) goto L14;
        long r7 = this.edgeCount + 1;
        this.edgeCount = r7;
        Graphs.checkPositive(r7);
    L14:
        return r1;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CheckForNull
    public V putEdgeValue(EndpointPair<N> r2, V r3) {
        validateEndpoints(r2);
        return putEdgeValue(r2.nodeU(), r2.nodeV(), r3);
    }

    @Override // com.google.common.graph.MutableValueGraph
    public boolean removeNode(N r9) {
        Preconditions.checkNotNull(r9, "node");
        GraphConnections<N, V> r0 = this.nodeConnections.get(r9);
        if (r0 != null) goto L6;
        return false;
    L6:
        if (allowsSelfLoops() == true) goto L8;
    L10:
        Iterator<N> r2 = r0.successors().iterator();
    L12:
        if (r2.hasNext() == false) goto L15;
        ((GraphConnections) Objects.requireNonNull(this.nodeConnections.getWithoutCaching(r2.next()))).removePredecessor(r9);
        this.edgeCount--;
        goto L12
    L15:
        if (isDirected() == false) goto L24;
        Iterator<N> r1 = r0.predecessors().iterator();
    L18:
        if (r1.hasNext() == false) goto L24;
        if (((GraphConnections) Objects.requireNonNull(this.nodeConnections.getWithoutCaching(r1.next()))).removeSuccessor(r9) == null) goto L22;
        boolean r3 = true;
    L23:
        Preconditions.checkState(r3);
        this.edgeCount--;
        goto L18
    L22:
        r3 = false;
    L24:
        this.nodeConnections.remove(r9);
        Graphs.checkNonNegative(this.edgeCount);
        return true;
    L8:
        if (r0.removeSuccessor(r9) == null) goto L10;
        r0.removePredecessor(r9);
        this.edgeCount--;
        goto L10
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CheckForNull
    public V removeEdge(N r5, N r6) {
        Preconditions.checkNotNull(r5, "nodeU");
        Preconditions.checkNotNull(r6, "nodeV");
        GraphConnections<N, V> r0 = this.nodeConnections.get(r5);
        GraphConnections<N, V> r1 = this.nodeConnections.get(r6);
        if (r0 == null) goto L10;
        if (r1 == null) goto L12;
        V r7 = r0.removeSuccessor(r6);
        if (r7 == null) goto L9;
        r1.removePredecessor(r5);
        long r2 = this.edgeCount - 1;
        this.edgeCount = r2;
        Graphs.checkNonNegative(r2);
    L9:
        return r7;
    L12:
        return null;
    L10:
        return null;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CheckForNull
    public V removeEdge(EndpointPair<N> r2) {
        validateEndpoints(r2);
        return removeEdge(r2.nodeU(), r2.nodeV());
    }

    private GraphConnections<N, V> newConnections() {
        if (isDirected() == false) goto L6;
        return DirectedGraphConnections.of(this.incidentEdgeOrder);
    L6:
        return UndirectedGraphConnections.of(this.incidentEdgeOrder);
    }
}
