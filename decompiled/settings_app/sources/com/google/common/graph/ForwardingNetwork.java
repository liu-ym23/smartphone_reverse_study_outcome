package com.google.common.graph;

import java.util.Optional;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class ForwardingNetwork<N, E> extends AbstractNetwork<N, E> {
    abstract Network<N, E> delegate();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Iterable predecessors(Object r1) {
        return predecessors(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Iterable successors(Object r1) {
        return successors(r1);
    }

    ForwardingNetwork() {
    }

    @Override // com.google.common.graph.Network
    public Set<N> nodes() {
        return delegate().nodes();
    }

    @Override // com.google.common.graph.Network
    public Set<E> edges() {
        return delegate().edges();
    }

    @Override // com.google.common.graph.Network
    public boolean isDirected() {
        return delegate().isDirected();
    }

    @Override // com.google.common.graph.Network
    public boolean allowsParallelEdges() {
        return delegate().allowsParallelEdges();
    }

    @Override // com.google.common.graph.Network
    public boolean allowsSelfLoops() {
        return delegate().allowsSelfLoops();
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<N> nodeOrder() {
        return delegate().nodeOrder();
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<E> edgeOrder() {
        return delegate().edgeOrder();
    }

    @Override // com.google.common.graph.Network
    public Set<N> adjacentNodes(N r1) {
        return delegate().adjacentNodes(r1);
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public Set<N> predecessors(N r1) {
        return delegate().predecessors(r1);
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public Set<N> successors(N r1) {
        return delegate().successors(r1);
    }

    @Override // com.google.common.graph.Network
    public Set<E> incidentEdges(N r1) {
        return delegate().incidentEdges(r1);
    }

    @Override // com.google.common.graph.Network
    public Set<E> inEdges(N r1) {
        return delegate().inEdges(r1);
    }

    @Override // com.google.common.graph.Network
    public Set<E> outEdges(N r1) {
        return delegate().outEdges(r1);
    }

    @Override // com.google.common.graph.Network
    public EndpointPair<N> incidentNodes(E r1) {
        return delegate().incidentNodes(r1);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> adjacentEdges(E r1) {
        return delegate().adjacentEdges(r1);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int degree(N r1) {
        return delegate().degree(r1);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int inDegree(N r1) {
        return delegate().inDegree(r1);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int outDegree(N r1) {
        return delegate().outDegree(r1);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> edgesConnecting(N r1, N r2) {
        return delegate().edgesConnecting(r1, r2);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> edgesConnecting(EndpointPair<N> r1) {
        return delegate().edgesConnecting(r1);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Optional<E> edgeConnecting(N r1, N r2) {
        return delegate().edgeConnecting(r1, r2);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Optional<E> edgeConnecting(EndpointPair<N> r1) {
        return delegate().edgeConnecting(r1);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    @CheckForNull
    public E edgeConnectingOrNull(N r1, N r2) {
        return delegate().edgeConnectingOrNull(r1, r2);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    @CheckForNull
    public E edgeConnectingOrNull(EndpointPair<N> r1) {
        return delegate().edgeConnectingOrNull(r1);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public boolean hasEdgeConnecting(N r1, N r2) {
        return delegate().hasEdgeConnecting(r1, r2);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public boolean hasEdgeConnecting(EndpointPair<N> r1) {
        return delegate().hasEdgeConnecting(r1);
    }
}
