package com.google.common.graph;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Optional;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@DoNotMock("Use NetworkBuilder to create a real instance")
@ElementTypesAreNonnullByDefault
public interface Network<N, E> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    Set<E> adjacentEdges(E r1);

    Set<N> adjacentNodes(N r1);

    boolean allowsParallelEdges();

    boolean allowsSelfLoops();

    Graph<N> asGraph();

    int degree(N r1);

    Optional<E> edgeConnecting(EndpointPair<N> r1);

    Optional<E> edgeConnecting(N r1, N r2);

    @CheckForNull
    E edgeConnectingOrNull(EndpointPair<N> r1);

    @CheckForNull
    E edgeConnectingOrNull(N r1, N r2);

    ElementOrder<E> edgeOrder();

    Set<E> edges();

    Set<E> edgesConnecting(EndpointPair<N> r1);

    Set<E> edgesConnecting(N r1, N r2);

    boolean equals(@CheckForNull Object r1);

    boolean hasEdgeConnecting(EndpointPair<N> r1);

    boolean hasEdgeConnecting(N r1, N r2);

    int hashCode();

    int inDegree(N r1);

    Set<E> inEdges(N r1);

    Set<E> incidentEdges(N r1);

    EndpointPair<N> incidentNodes(E r1);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N r1);

    Set<E> outEdges(N r1);

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
