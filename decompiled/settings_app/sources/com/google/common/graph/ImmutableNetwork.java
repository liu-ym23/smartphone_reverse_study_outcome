package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.Immutable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@Immutable(containerOf = {"N", "E"})
@ElementTypesAreNonnullByDefault
public final class ImmutableNetwork<N, E> extends StandardNetwork<N, E> {

    public static class Builder<N, E> {
        private final MutableNetwork<N, E> mutableNetwork;

        Builder(NetworkBuilder<N, E> r1) {
            this.mutableNetwork = (MutableNetwork<N, E>) r1.build();
        }

        public Builder<N, E> addNode(N r2) {
            this.mutableNetwork.addNode(r2);
            return this;
        }

        public Builder<N, E> addEdge(N r2, N r3, E r4) {
            this.mutableNetwork.addEdge(r2, r3, r4);
            return this;
        }

        public Builder<N, E> addEdge(EndpointPair<N> r2, E r3) {
            this.mutableNetwork.addEdge(r2, r3);
            return this;
        }

        public ImmutableNetwork<N, E> build() {
            return ImmutableNetwork.copyOf(this.mutableNetwork);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set adjacentNodes(Object r1) {
        return super.adjacentNodes(r1);
    }

    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ boolean allowsParallelEdges() {
        return super.allowsParallelEdges();
    }

    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ boolean allowsSelfLoops() {
        return super.allowsSelfLoops();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Graph asGraph() {
        return asGraph();
    }

    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ ElementOrder edgeOrder() {
        return super.edgeOrder();
    }

    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set edges() {
        return super.edges();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set edgesConnecting(Object r1, Object r2) {
        return super.edgesConnecting(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set inEdges(Object r1) {
        return super.inEdges(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set incidentEdges(Object r1) {
        return super.incidentEdges(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ EndpointPair incidentNodes(Object r1) {
        return super.incidentNodes(r1);
    }

    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ boolean isDirected() {
        return super.isDirected();
    }

    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ ElementOrder nodeOrder() {
        return super.nodeOrder();
    }

    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set nodes() {
        return super.nodes();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set outEdges(Object r1) {
        return super.outEdges(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set predecessors(Object r1) {
        return super.predecessors(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set successors(Object r1) {
        return super.successors(r1);
    }

    private ImmutableNetwork(Network<N, E> r3) {
        super(NetworkBuilder.from(r3), getNodeConnections(r3), getEdgeToReferenceNode(r3));
    }

    public static <N, E> ImmutableNetwork<N, E> copyOf(Network<N, E> r1) {
        if ((r1 instanceof ImmutableNetwork) == false) goto L6;
        return (ImmutableNetwork) r1;
    L6:
        return new ImmutableNetwork(r1);
    }

    @Deprecated
    public static <N, E> ImmutableNetwork<N, E> copyOf(ImmutableNetwork<N, E> r0) {
        return (ImmutableNetwork) Preconditions.checkNotNull(r0);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public ImmutableGraph<N> asGraph() {
        return new ImmutableGraph(super.asGraph());
    }

    private static <N, E> Map<N, NetworkConnections<N, E>> getNodeConnections(Network<N, E> r4) {
        ImmutableMap.Builder r0 = ImmutableMap.builder();
        Iterator<N> r1 = r4.nodes().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        N r2 = r1.next();
        r0.put(r2, connectionsOf(r4, r2));
        goto L4
    L7:
        return r0.build();
    }

    private static <N, E> Map<E, N> getEdgeToReferenceNode(Network<N, E> r4) {
        ImmutableMap.Builder r0 = ImmutableMap.builder();
        Iterator<E> r1 = r4.edges().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        E r2 = r1.next();
        r0.put(r2, r4.incidentNodes(r2).nodeU());
        goto L4
    L7:
        return r0.build();
    }

    private static <N, E> NetworkConnections<N, E> connectionsOf(Network<N, E> r3, N r4) {
        if (r3.isDirected() == false) goto L9;
        Map r0 = Maps.asMap(r3.inEdges(r4), sourceNodeFn(r3));
        Map r1 = Maps.asMap(r3.outEdges(r4), targetNodeFn(r3));
        int r5 = r3.edgesConnecting(r4, r4).size();
        if (r3.allowsParallelEdges() == false) goto L8;
        return DirectedMultiNetworkConnections.ofImmutable(r0, r1, r5);
    L8:
        return DirectedNetworkConnections.ofImmutable(r0, r1, r5);
    L9:
        Map r6 = Maps.asMap(r3.incidentEdges(r4), adjacentNodeFn(r3, r4));
        if (r3.allowsParallelEdges() == false) goto L13;
        return UndirectedMultiNetworkConnections.ofImmutable(r6);
    L13:
        return UndirectedNetworkConnections.ofImmutable(r6);
    }

    private static <N, E> Function<E, N> sourceNodeFn(final Network<N, E> r1) {
        return new AnonymousClass1(r1);
    }

    private static <N, E> Function<E, N> targetNodeFn(final Network<N, E> r1) {
        return new AnonymousClass2(r1);
    }

    private static <N, E> Function<E, N> adjacentNodeFn(final Network<N, E> r1, final N r2) {
        return new AnonymousClass3(r1, r2);
    }
}
