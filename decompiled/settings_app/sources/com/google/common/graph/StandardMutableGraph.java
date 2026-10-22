package com.google.common.graph;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class StandardMutableGraph<N> extends ForwardingGraph<N> implements MutableGraph<N> {
    private final MutableValueGraph<N, GraphConstants.Presence> backingValueGraph;

    StandardMutableGraph(AbstractGraphBuilder<? super N> r2) {
        this.backingValueGraph = new StandardMutableValueGraph(r2);
    }

    @Override // com.google.common.graph.ForwardingGraph
    BaseGraph<N> delegate() {
        return this.backingValueGraph;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean addNode(N r1) {
        return this.backingValueGraph.addNode(r1);
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean putEdge(N r2, N r3) {
        if (this.backingValueGraph.putEdgeValue(r2, r3, GraphConstants.Presence.EDGE_EXISTS) != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean putEdge(EndpointPair<N> r2) {
        validateEndpoints(r2);
        return putEdge(r2.nodeU(), r2.nodeV());
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeNode(N r1) {
        return this.backingValueGraph.removeNode(r1);
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeEdge(N r1, N r2) {
        if (this.backingValueGraph.removeEdge(r1, r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeEdge(EndpointPair<N> r2) {
        validateEndpoints(r2);
        return removeEdge(r2.nodeU(), r2.nodeV());
    }
}
