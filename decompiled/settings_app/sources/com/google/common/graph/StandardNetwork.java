package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
class StandardNetwork<N, E> extends AbstractNetwork<N, E> {
    private final boolean allowsParallelEdges;
    private final boolean allowsSelfLoops;
    private final ElementOrder<E> edgeOrder;
    final MapIteratorCache<E, N> edgeToReferenceNode;
    private final boolean isDirected;
    final MapIteratorCache<N, NetworkConnections<N, E>> nodeConnections;
    private final ElementOrder<N> nodeOrder;

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

    StandardNetwork(NetworkBuilder<? super N, ? super E> r5) {
        this(r5, r5.nodeOrder.createMap(r5.expectedNodeCount.or(10).intValue()), r5.edgeOrder.createMap(r5.expectedEdgeCount.or(20).intValue()));
    }

    StandardNetwork(NetworkBuilder<? super N, ? super E> r2, Map<N, NetworkConnections<N, E>> r3, Map<E, N> r4) {
        this.isDirected = r2.directed;
        this.allowsParallelEdges = r2.allowsParallelEdges;
        this.allowsSelfLoops = r2.allowsSelfLoops;
        this.nodeOrder = (ElementOrder<N>) r2.nodeOrder.cast();
        this.edgeOrder = (ElementOrder<E>) r2.edgeOrder.cast();
        if ((r3 instanceof TreeMap) == false) goto L5;
        MapIteratorCache<N, NetworkConnections<N, E>> r5 = new MapRetrievalCache(r3);
    L6:
        this.nodeConnections = r5;
        this.edgeToReferenceNode = new MapIteratorCache(r4);
        return;
    L5:
        r5 = new MapIteratorCache(r3);
        goto L6
    }

    @Override // com.google.common.graph.Network
    public Set<N> nodes() {
        return this.nodeConnections.unmodifiableKeySet();
    }

    @Override // com.google.common.graph.Network
    public Set<E> edges() {
        return this.edgeToReferenceNode.unmodifiableKeySet();
    }

    @Override // com.google.common.graph.Network
    public boolean isDirected() {
        return this.isDirected;
    }

    @Override // com.google.common.graph.Network
    public boolean allowsParallelEdges() {
        return this.allowsParallelEdges;
    }

    @Override // com.google.common.graph.Network
    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<N> nodeOrder() {
        return this.nodeOrder;
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<E> edgeOrder() {
        return this.edgeOrder;
    }

    @Override // com.google.common.graph.Network
    public Set<E> incidentEdges(N r1) {
        return checkedConnections(r1).incidentEdges();
    }

    @Override // com.google.common.graph.Network
    public EndpointPair<N> incidentNodes(E r3) {
        N r0 = checkedReferenceNode(r3);
        return EndpointPair.of(this, r0, ((NetworkConnections) Objects.requireNonNull(this.nodeConnections.get(r0))).adjacentNode(r3));
    }

    @Override // com.google.common.graph.Network
    public Set<N> adjacentNodes(N r1) {
        return checkedConnections(r1).adjacentNodes();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> edgesConnecting(N r3, N r4) {
        NetworkConnections<N, E> r0 = checkedConnections(r3);
        if (this.allowsSelfLoops == true) goto L7;
        if (r3 != r4) goto L7;
        return ImmutableSet.of();
    L7:
        Preconditions.checkArgument(containsNode(r4), "Node %s is not an element of this graph.", r4);
        return r0.edgesConnecting(r4);
    }

    @Override // com.google.common.graph.Network
    public Set<E> inEdges(N r1) {
        return checkedConnections(r1).inEdges();
    }

    @Override // com.google.common.graph.Network
    public Set<E> outEdges(N r1) {
        return checkedConnections(r1).outEdges();
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public Set<N> predecessors(N r1) {
        return checkedConnections(r1).predecessors();
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public Set<N> successors(N r1) {
        return checkedConnections(r1).successors();
    }

    final NetworkConnections<N, E> checkedConnections(N r3) {
        NetworkConnections<N, E> r2 = this.nodeConnections.get(r3);
        if (r2 == null) goto L5;
        return r2;
    L5:
        Preconditions.checkNotNull(r3);
        throw new IllegalArgumentException(String.format("Node %s is not an element of this graph.", new Object[]{r3}));
    }

    final N checkedReferenceNode(E r3) {
        N r2 = this.edgeToReferenceNode.get(r3);
        if (r2 == null) goto L5;
        return r2;
    L5:
        Preconditions.checkNotNull(r3);
        throw new IllegalArgumentException(String.format("Edge %s is not an element of this graph.", new Object[]{r3}));
    }

    final boolean containsNode(N r1) {
        return this.nodeConnections.containsKey(r1);
    }

    final boolean containsEdge(E r1) {
        return this.edgeToReferenceNode.containsKey(r1);
    }
}
