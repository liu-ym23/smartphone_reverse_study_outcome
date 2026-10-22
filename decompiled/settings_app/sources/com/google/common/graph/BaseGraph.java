package com.google.common.graph;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
interface BaseGraph<N> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    Set<N> adjacentNodes(N r1);

    boolean allowsSelfLoops();

    int degree(N r1);

    Set<EndpointPair<N>> edges();

    boolean hasEdgeConnecting(EndpointPair<N> r1);

    boolean hasEdgeConnecting(N r1, N r2);

    int inDegree(N r1);

    ElementOrder<N> incidentEdgeOrder();

    Set<EndpointPair<N>> incidentEdges(N r1);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N r1);

    Set<N> predecessors(N r1);

    @Override // com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    Set<N> successors(N r1);

    /* JADX WARN: Multi-variable type inference failed */
    /* bridge */ /* synthetic */ default Iterable predecessors(Object r1) {
        return predecessors(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    /* bridge */ /* synthetic */ default Iterable successors(Object r1) {
        return successors(r1);
    }
}
