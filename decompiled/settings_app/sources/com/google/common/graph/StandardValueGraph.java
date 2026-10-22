package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
class StandardValueGraph<N, V> extends AbstractValueGraph<N, V> {
    private final boolean allowsSelfLoops;
    long edgeCount;
    private final boolean isDirected;
    final MapIteratorCache<N, GraphConnections<N, V>> nodeConnections;
    private final ElementOrder<N> nodeOrder;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Iterable predecessors(Object r1) {
        return predecessors(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Iterable successors(Object r1) {
        return successors(r1);
    }

    StandardValueGraph(AbstractGraphBuilder<? super N> r4) {
        this(r4, r4.nodeOrder.createMap(r4.expectedNodeCount.or(10).intValue()), 0);
    }

    StandardValueGraph(AbstractGraphBuilder<? super N> r2, Map<N, GraphConnections<N, V>> r3, long r4) {
        this.isDirected = r2.directed;
        this.allowsSelfLoops = r2.allowsSelfLoops;
        this.nodeOrder = (ElementOrder<N>) r2.nodeOrder.cast();
        if ((r3 instanceof TreeMap) == false) goto L5;
        MapIteratorCache<N, GraphConnections<N, V>> r5 = new MapRetrievalCache(r3);
    L6:
        this.nodeConnections = r5;
        this.edgeCount = Graphs.checkNonNegative(r4);
        return;
    L5:
        r5 = new MapIteratorCache(r3);
        goto L6
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public Set<N> nodes() {
        return this.nodeConnections.unmodifiableKeySet();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean isDirected() {
        return this.isDirected;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public ElementOrder<N> nodeOrder() {
        return this.nodeOrder;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public Set<N> adjacentNodes(N r1) {
        return checkedConnections(r1).adjacentNodes();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public Set<N> predecessors(N r1) {
        return checkedConnections(r1).predecessors();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public Set<N> successors(N r1) {
        return checkedConnections(r1).successors();
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public Set<EndpointPair<N>> incidentEdges(final N r3) {
        final GraphConnections<N, V> r0 = checkedConnections(r3);
        return new AnonymousClass1(this, this, r3, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(N r1, N r2) {
        return hasEdgeConnectingInternal(Preconditions.checkNotNull(r1), Preconditions.checkNotNull(r2));
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(EndpointPair<N> r2) {
        Preconditions.checkNotNull(r2);
        if (isOrderingCompatible(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (hasEdgeConnectingInternal(r2.nodeU(), r2.nodeV()) == false) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    public V edgeValueOrDefault(N r1, N r2, @CheckForNull V r3) {
        return (V) edgeValueOrDefaultInternal(Preconditions.checkNotNull(r1), Preconditions.checkNotNull(r2), r3);
    }

    @CheckForNull
    public V edgeValueOrDefault(EndpointPair<N> r2, @CheckForNull V r3) {
        validateEndpoints(r2);
        return edgeValueOrDefaultInternal(r2.nodeU(), r2.nodeV(), r3);
    }

    @Override // com.google.common.graph.AbstractBaseGraph
    protected long edgeCount() {
        return this.edgeCount;
    }

    private final GraphConnections<N, V> checkedConnections(N r3) {
        GraphConnections<N, V> r2 = this.nodeConnections.get(r3);
        if (r2 == null) goto L5;
        return r2;
    L5:
        Preconditions.checkNotNull(r3);
        String r4 = String.valueOf(r3);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(r4).length() + 38).append("Node ").append(r4).append(" is not an element of this graph.").toString());
    }

    final boolean containsNode(@CheckForNull N r1) {
        return this.nodeConnections.containsKey(r1);
    }

    private final boolean hasEdgeConnectingInternal(N r1, N r2) {
        GraphConnections<N, V> r0 = this.nodeConnections.get(r1);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.successors().contains(r2) == false) goto L7;
        return true;
    }

    @CheckForNull
    private final V edgeValueOrDefaultInternal(N r1, N r2, @CheckForNull V r3) {
        GraphConnections<N, V> r0 = this.nodeConnections.get(r1);
        if (r0 != null) goto L5;
        V r4 = null;
    L6:
        if (r4 != null) goto L8;
        return r3;
    L8:
        return r4;
    L5:
        r4 = r0.value(r2);
        goto L6
    }
}
