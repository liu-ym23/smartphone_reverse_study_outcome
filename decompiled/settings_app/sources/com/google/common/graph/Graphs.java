package com.google.common.graph;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Graphs {

    private static final enum NodeVisitState extends Enum<NodeVisitState> {
        private static final /* synthetic */ NodeVisitState[] $VALUES = null;
        public static final NodeVisitState COMPLETE = null;
        public static final NodeVisitState PENDING = null;

        private static /* synthetic */ NodeVisitState[] $values() {
            return new NodeVisitState[]{PENDING, COMPLETE};
        }

        private NodeVisitState(String r1, int r2) {
            super(r1, r2);
        }

        public static NodeVisitState valueOf(String r1) {
            return (NodeVisitState) Enum.valueOf(NodeVisitState.class, r1);
        }

        public static NodeVisitState[] values() {
            return (NodeVisitState[]) $VALUES.clone();
        }

        static {
            PENDING = new NodeVisitState("PENDING", 0);
            COMPLETE = new NodeVisitState("COMPLETE", 1);
            $VALUES = $values();
        }
    }

    private static class TransposedGraph<N> extends ForwardingGraph<N> {
        private final Graph<N> graph;

        static /* synthetic */ Graph access$000(TransposedGraph r0) {
            return r0.graph;
        }

        @Override // com.google.common.graph.ForwardingGraph
        /* bridge */ /* synthetic */ BaseGraph delegate() {
            return delegate();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
        public /* bridge */ /* synthetic */ Iterable predecessors(Object r1) {
            return predecessors(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        public /* bridge */ /* synthetic */ Iterable successors(Object r1) {
            return successors(r1);
        }

        TransposedGraph(Graph<N> r1) {
            this.graph = r1;
        }

        @Override // com.google.common.graph.ForwardingGraph
        Graph<N> delegate() {
            return this.graph;
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
        public Set<N> predecessors(N r1) {
            return delegate().successors(r1);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        public Set<N> successors(N r1) {
            return delegate().predecessors(r1);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public Set<EndpointPair<N>> incidentEdges(final N r2) {
            return new AnonymousClass1(this, this, r2);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int inDegree(N r1) {
            return delegate().outDegree(r1);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int outDegree(N r1) {
            return delegate().inDegree(r1);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(N r1, N r2) {
            return delegate().hasEdgeConnecting(r2, r1);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(EndpointPair<N> r1) {
            return delegate().hasEdgeConnecting(Graphs.transpose(r1));
        }
    }

    private static class TransposedNetwork<N, E> extends ForwardingNetwork<N, E> {
        private final Network<N, E> network;

        static /* synthetic */ Network access$200(TransposedNetwork r0) {
            return r0.network;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
        public /* bridge */ /* synthetic */ Iterable predecessors(Object r1) {
            return predecessors(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        public /* bridge */ /* synthetic */ Iterable successors(Object r1) {
            return successors(r1);
        }

        TransposedNetwork(Network<N, E> r1) {
            this.network = r1;
        }

        @Override // com.google.common.graph.ForwardingNetwork
        Network<N, E> delegate() {
            return this.network;
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
        public Set<N> predecessors(N r1) {
            return delegate().successors(r1);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        public Set<N> successors(N r1) {
            return delegate().predecessors(r1);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public int inDegree(N r1) {
            return delegate().outDegree(r1);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public int outDegree(N r1) {
            return delegate().inDegree(r1);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public Set<E> inEdges(N r1) {
            return delegate().outEdges(r1);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public Set<E> outEdges(N r1) {
            return delegate().inEdges(r1);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public EndpointPair<N> incidentNodes(E r2) {
            EndpointPair<N> r3 = delegate().incidentNodes(r2);
            return EndpointPair.of(this.network, r3.nodeV(), r3.nodeU());
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public Set<E> edgesConnecting(N r1, N r2) {
            return delegate().edgesConnecting(r2, r1);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public Set<E> edgesConnecting(EndpointPair<N> r1) {
            return delegate().edgesConnecting(Graphs.transpose(r1));
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public Optional<E> edgeConnecting(N r1, N r2) {
            return delegate().edgeConnecting(r2, r1);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public Optional<E> edgeConnecting(EndpointPair<N> r1) {
            return delegate().edgeConnecting(Graphs.transpose(r1));
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        @CheckForNull
        public E edgeConnectingOrNull(N r1, N r2) {
            return delegate().edgeConnectingOrNull(r2, r1);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        @CheckForNull
        public E edgeConnectingOrNull(EndpointPair<N> r1) {
            return delegate().edgeConnectingOrNull(Graphs.transpose(r1));
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public boolean hasEdgeConnecting(N r1, N r2) {
            return delegate().hasEdgeConnecting(r2, r1);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public boolean hasEdgeConnecting(EndpointPair<N> r1) {
            return delegate().hasEdgeConnecting(Graphs.transpose(r1));
        }
    }

    private static class TransposedValueGraph<N, V> extends ForwardingValueGraph<N, V> {
        private final ValueGraph<N, V> graph;

        static /* synthetic */ ValueGraph access$100(TransposedValueGraph r0) {
            return r0.graph;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
        public /* bridge */ /* synthetic */ Iterable predecessors(Object r1) {
            return predecessors(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        public /* bridge */ /* synthetic */ Iterable successors(Object r1) {
            return successors(r1);
        }

        TransposedValueGraph(ValueGraph<N, V> r1) {
            this.graph = r1;
        }

        @Override // com.google.common.graph.ForwardingValueGraph
        ValueGraph<N, V> delegate() {
            return this.graph;
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
        public Set<N> predecessors(N r1) {
            return delegate().successors(r1);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        public Set<N> successors(N r1) {
            return delegate().predecessors(r1);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int inDegree(N r1) {
            return delegate().outDegree(r1);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int outDegree(N r1) {
            return delegate().inDegree(r1);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(N r1, N r2) {
            return delegate().hasEdgeConnecting(r2, r1);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(EndpointPair<N> r1) {
            return delegate().hasEdgeConnecting(Graphs.transpose(r1));
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.ValueGraph
        public Optional<V> edgeValue(N r1, N r2) {
            return delegate().edgeValue(r2, r1);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.ValueGraph
        public Optional<V> edgeValue(EndpointPair<N> r1) {
            return delegate().edgeValue(Graphs.transpose(r1));
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.ValueGraph
        @CheckForNull
        public V edgeValueOrDefault(N r1, N r2, @CheckForNull V r3) {
            return delegate().edgeValueOrDefault(r2, r1, r3);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.ValueGraph
        @CheckForNull
        public V edgeValueOrDefault(EndpointPair<N> r1, @CheckForNull V r2) {
            return delegate().edgeValueOrDefault(Graphs.transpose(r1), r2);
        }
    }

    private Graphs() {
    }

    public static <N> boolean hasCycle(Graph<N> r6) {
        int r0 = r6.edges().size();
        if (r0 != 0) goto L6;
        return false;
    L6:
        if (r6.isDirected() == false) goto L8;
    L10:
        HashMap r1 = Maps.newHashMapWithExpectedSize(r6.nodes().size());
        Iterator<N> r2 = r6.nodes().iterator();
    L12:
        if (r2.hasNext() == false) goto L16;
        if (subgraphHasCycle(r6, r1, r2.next(), null) == false) goto L12;
        return true;
    L16:
        return false;
    L8:
        if (r0 < r6.nodes().size()) goto L10;
        return true;
    }

    public static boolean hasCycle(Network<?, ?> r2) {
        if (r2.isDirected() == true) goto L11;
        if (r2.allowsParallelEdges() == false) goto L11;
        if (r2.edges().size() <= r2.asGraph().edges().size()) goto L11;
        return true;
    L11:
        return hasCycle(r2.asGraph());
    }

    private static <N> boolean subgraphHasCycle(Graph<N> r5, Map<Object, NodeVisitState> r6, N r7, @CheckForNull N r8) {
        NodeVisitState r0 = r6.get(r7);
        if (r0 != NodeVisitState.COMPLETE) goto L6;
        return false;
    L6:
        if (r0 != NodeVisitState.PENDING) goto L8;
        return true;
    L8:
        r6.put(r7, NodeVisitState.PENDING);
        Iterator<N> r1 = r5.successors(r7).iterator();
    L10:
        if (r1.hasNext() == false) goto L16;
        N r2 = r1.next();
        if (canTraverseWithoutReusingEdge(r5, r2, r8) == false) goto L10;
        if (subgraphHasCycle(r5, r6, r2, r7) == false) goto L10;
        return true;
    L16:
        r6.put(r7, NodeVisitState.COMPLETE);
        return false;
    }

    private static boolean canTraverseWithoutReusingEdge(Graph<?> r0, Object r1, @CheckForNull Object r2) {
        if (r0.isDirected() == false) goto L5;
        return true;
    L5:
        if (Objects.equal(r2, r1) == false) goto L11;
        return false;
    L11:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <N> Graph<N> transitiveClosure(Graph<N> r10) {
        StandardMutableGraph r0 = GraphBuilder.from(r10).allowsSelfLoops(true).build();
        if (r10.isDirected() == false) goto L11;
        Iterator<N> r1 = r10.nodes().iterator();
    L6:
        if (r1.hasNext() == false) goto L24;
        N r2 = r1.next();
        Iterator r3 = reachableNodes(r10, r2).iterator();
    L9:
        if (r3.hasNext() == false) goto L6;
        r0.putEdge(r2, r3.next());
    L24:
        return r0;
    L11:
        HashSet r4 = new HashSet();
        Iterator<N> r5 = r10.nodes().iterator();
    L13:
        if (r5.hasNext() == false) goto L24;
        N r6 = r5.next();
        if (r4.contains(r6) == true) goto L13;
        Set r7 = reachableNodes(r10, r6);
        r4.addAll(r7);
        Iterator r8 = r7.iterator();
        int r9 = 1;
    L18:
        if (r8.hasNext() == false) goto L13;
        Object r11 = r8.next();
        int r12 = r9 + 1;
        Iterator r13 = Iterables.limit(r7, r9).iterator();
    L21:
        if (r13.hasNext() == false) goto L23;
        r0.putEdge(r11, r13.next());
        goto L21
    L23:
        r9 = r12;
        goto L18
    }

    public static <N> Set<N> reachableNodes(Graph<N> r2, N r3) {
        Preconditions.checkArgument(r2.nodes().contains(r3), "Node %s is not an element of this graph.", r3);
        return ImmutableSet.copyOf(Traverser.forGraph(r2).breadthFirst(r3));
    }

    public static <N> Graph<N> transpose(Graph<N> r1) {
        if (r1.isDirected() == true) goto L6;
        return r1;
    L6:
        if ((r1 instanceof TransposedGraph) == false) goto L10;
        return TransposedGraph.access$000((TransposedGraph) r1);
    L10:
        return new TransposedGraph(r1);
    }

    public static <N, V> ValueGraph<N, V> transpose(ValueGraph<N, V> r1) {
        if (r1.isDirected() == true) goto L6;
        return r1;
    L6:
        if ((r1 instanceof TransposedValueGraph) == false) goto L10;
        return TransposedValueGraph.access$100((TransposedValueGraph) r1);
    L10:
        return new TransposedValueGraph(r1);
    }

    public static <N, E> Network<N, E> transpose(Network<N, E> r1) {
        if (r1.isDirected() == true) goto L6;
        return r1;
    L6:
        if ((r1 instanceof TransposedNetwork) == false) goto L10;
        return TransposedNetwork.access$200((TransposedNetwork) r1);
    L10:
        return new TransposedNetwork(r1);
    }

    static <N> EndpointPair<N> transpose(EndpointPair<N> r1) {
        if (r1.isOrdered() == true) goto L5;
        return r1;
    L5:
        return EndpointPair.ordered(r1.target(), r1.source());
    }

    public static <N> MutableGraph<N> inducedSubgraph(Graph<N> r5, Iterable<? extends N> r6) {
        if ((r6 instanceof Collection) == false) goto L5;
        StandardMutableGraph r0 = (MutableGraph<N>) GraphBuilder.from(r5).expectedNodeCount(((Collection) r6).size()).build();
    L6:
        Iterator<? extends N> r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        StandardMutableGraph r1 = r0;
        r1.addNode(r7.next());
        goto L8
    L10:
        Iterator<N> r8 = r0.nodes().iterator();
    L12:
        if (r8.hasNext() == false) goto L19;
        N r2 = r8.next();
        Iterator<N> r3 = r5.successors(r2).iterator();
    L15:
        if (r3.hasNext() == false) goto L12;
        N r4 = r3.next();
        if (r0.nodes().contains(r4) == false) goto L15;
        r0.putEdge(r2, r4);
        goto L15
    L19:
        return r0;
    L5:
        r0 = (MutableGraph<N>) GraphBuilder.from(r5).build();
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <N, V> MutableValueGraph<N, V> inducedSubgraph(ValueGraph<N, V> r5, Iterable<? extends N> r6) {
        if ((r6 instanceof Collection) == false) goto L5;
        MutableValueGraph r0 = (MutableValueGraph<N, V>) ValueGraphBuilder.from(r5).expectedNodeCount(((Collection) r6).size()).build();
    L6:
        Iterator<? extends N> r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        MutableValueGraph r1 = r0;
        r1.addNode(r7.next());
        goto L8
    L10:
        Iterator<N> r8 = r0.nodes().iterator();
    L12:
        if (r8.hasNext() == false) goto L19;
        N r2 = r8.next();
        Iterator<N> r3 = r5.successors(r2).iterator();
    L15:
        if (r3.hasNext() == false) goto L12;
        N r4 = r3.next();
        if (r0.nodes().contains(r4) == false) goto L15;
        MutableValueGraph r9 = r0;
        r9.putEdgeValue(r2, r4, java.util.Objects.requireNonNull(r5.edgeValueOrDefault(r2, r4, null)));
        goto L15
    L19:
        return (MutableValueGraph<N, V>) r0;
    L5:
        r0 = (MutableValueGraph<N, V>) ValueGraphBuilder.from(r5).build();
        goto L6
    }

    public static <N, E> MutableNetwork<N, E> inducedSubgraph(Network<N, E> r6, Iterable<? extends N> r7) {
        if ((r7 instanceof Collection) == false) goto L5;
        StandardMutableNetwork r0 = (MutableNetwork<N, E>) NetworkBuilder.from(r6).expectedNodeCount(((Collection) r7).size()).build();
    L6:
        Iterator<? extends N> r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        StandardMutableNetwork r1 = r0;
        r1.addNode(r8.next());
        goto L8
    L10:
        Iterator<E> r9 = r0.nodes().iterator();
    L12:
        if (r9.hasNext() == false) goto L19;
        E r2 = r9.next();
        Iterator<E> r3 = r6.outEdges(r2).iterator();
    L15:
        if (r3.hasNext() == false) goto L12;
        E r4 = r3.next();
        N r5 = r6.incidentNodes(r4).adjacentNode(r2);
        if (r0.nodes().contains(r5) == false) goto L15;
        r0.addEdge(r2, r5, r4);
        goto L15
    L19:
        return r0;
    L5:
        r0 = (MutableNetwork<N, E>) NetworkBuilder.from(r6).build();
        goto L6
    }

    public static <N> MutableGraph<N> copyOf(Graph<N> r3) {
        MutableGraph<N> r0 = (MutableGraph<N>) GraphBuilder.from(r3).expectedNodeCount(r3.nodes().size()).build();
        Iterator<N> r1 = r3.nodes().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.addNode(r1.next());
        goto L4
    L6:
        Iterator<EndpointPair<N>> r4 = r3.edges().iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        EndpointPair<N> r2 = r4.next();
        r0.putEdge(r2.nodeU(), r2.nodeV());
        goto L8
    L10:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <N, V> MutableValueGraph<N, V> copyOf(ValueGraph<N, V> r7) {
        StandardMutableValueGraph r0 = (MutableValueGraph<N, V>) ValueGraphBuilder.from(r7).expectedNodeCount(r7.nodes().size()).build();
        Iterator<N> r1 = r7.nodes().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.addNode(r1.next());
        goto L4
    L6:
        Iterator<EndpointPair<N>> r2 = r7.edges().iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        EndpointPair<N> r3 = r2.next();
        r0.putEdgeValue(r3.nodeU(), r3.nodeV(), java.util.Objects.requireNonNull(r7.edgeValueOrDefault(r3.nodeU(), r3.nodeV(), null)));
        goto L8
    L10:
        return r0;
    }

    public static <N, E> MutableNetwork<N, E> copyOf(Network<N, E> r5) {
        MutableNetwork<N, E> r0 = (MutableNetwork<N, E>) NetworkBuilder.from(r5).expectedNodeCount(r5.nodes().size()).expectedEdgeCount(r5.edges().size()).build();
        Iterator<N> r1 = r5.nodes().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.addNode(r1.next());
        goto L4
    L6:
        Iterator<E> r2 = r5.edges().iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        E r3 = r2.next();
        EndpointPair<N> r4 = r5.incidentNodes(r3);
        r0.addEdge(r4.nodeU(), r4.nodeV(), r3);
        goto L8
    L10:
        return r0;
    }

    static int checkNonNegative(int r2) {
        if (r2 < 0) goto L4;
        boolean r0 = true;
    L5:
        Preconditions.checkArgument(r0, "Not true that %s is non-negative.", r2);
        return r2;
    L4:
        r0 = false;
        goto L5
    }

    static long checkNonNegative(long r2) {
        if (r2 < 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "Not true that %s is non-negative.", r2);
        return r2;
    L5:
        r0 = false;
        goto L6
    }

    static int checkPositive(int r2) {
        if (r2 <= 0) goto L4;
        boolean r0 = true;
    L5:
        Preconditions.checkArgument(r0, "Not true that %s is positive.", r2);
        return r2;
    L4:
        r0 = false;
        goto L5
    }

    static long checkPositive(long r2) {
        if (r2 <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "Not true that %s is positive.", r2);
        return r2;
    L5:
        r0 = false;
        goto L6
    }
}
