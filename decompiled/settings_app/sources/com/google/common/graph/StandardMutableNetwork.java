package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class StandardMutableNetwork<N, E> extends StandardNetwork<N, E> implements MutableNetwork<N, E> {
    StandardMutableNetwork(NetworkBuilder<? super N, ? super E> r1) {
        super(r1);
    }

    @Override // com.google.common.graph.MutableNetwork
    public boolean addNode(N r2) {
        Preconditions.checkNotNull(r2, "node");
        if (containsNode(r2) == false) goto L6;
        return false;
    L6:
        addNodeInternal(r2);
        return true;
    }

    private NetworkConnections<N, E> addNodeInternal(N r2) {
        NetworkConnections<N, E> r0 = newConnections();
        if (this.nodeConnections.put(r2, r0) != null) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkState(r1);
        return r0;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.google.common.graph.MutableNetwork
    public boolean addEdge(N r6, N r7, E r8) {
        Preconditions.checkNotNull(r6, "nodeU");
        Preconditions.checkNotNull(r7, "nodeV");
        Preconditions.checkNotNull(r8, "edge");
        boolean r1 = false;
        if (containsEdge(r8) == false) goto L6;
        EndpointPair<N> r0 = incidentNodes(r8);
        EndpointPair r5 = EndpointPair.of(this, r6, r7);
        Preconditions.checkArgument(r0.equals(r5), "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s.", r8, r0, r5);
        return false;
    L6:
        NetworkConnections<N, E> r2 = this.nodeConnections.get(r6);
        if (allowsParallelEdges() == true) goto L13;
        if (r2 != null) goto L10;
    L11:
        r1 = true;
    L12:
        Preconditions.checkArgument(r1, "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder.", r6, r7);
        goto L13
    L10:
        if (r2.successors().contains(r7) == true) goto L12;
    L13:
        boolean r3 = r6.equals(r7);
        if (allowsSelfLoops() == true) goto L16;
        Preconditions.checkArgument(!r3, "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", r6);
    L16:
        if (r2 != null) goto L18;
        r2 = addNodeInternal(r6);
    L18:
        r2.addOutEdge(r8, r7);
        NetworkConnections<N, E> r4 = this.nodeConnections.get(r7);
        if (r4 != null) goto L21;
        r4 = addNodeInternal(r7);
    L21:
        r4.addInEdge(r8, r6, r3);
        this.edgeToReferenceNode.put(r8, r6);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    public boolean addEdge(EndpointPair<N> r2, E r3) {
        validateEndpoints(r2);
        return addEdge(r2.nodeU(), r2.nodeV(), r3);
    }

    @Override // com.google.common.graph.MutableNetwork
    public boolean removeNode(N r3) {
        Preconditions.checkNotNull(r3, "node");
        NetworkConnections<N, E> r0 = this.nodeConnections.get(r3);
        if (r0 != null) goto L6;
        return false;
    L6:
        UnmodifiableIterator<E> r1 = ImmutableList.copyOf(r0.incidentEdges()).iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        removeEdge(r1.next());
        goto L8
    L10:
        this.nodeConnections.remove(r3);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    public boolean removeEdge(E r7) {
        Preconditions.checkNotNull(r7, "edge");
        N r0 = this.edgeToReferenceNode.get(r7);
        boolean r1 = false;
        if (r0 != null) goto L5;
        return false;
    L5:
        NetworkConnections r2 = (NetworkConnections) Objects.requireNonNull(this.nodeConnections.get(r0));
        Object r3 = r2.adjacentNode(r7);
        NetworkConnections r4 = (NetworkConnections) Objects.requireNonNull(this.nodeConnections.get(r3));
        r2.removeOutEdge(r7);
        if (allowsSelfLoops() == true) goto L8;
    L10:
        r4.removeInEdge(r7, r1);
        this.edgeToReferenceNode.remove(r7);
        return true;
    L8:
        if (r0.equals(r3) == false) goto L10;
        r1 = true;
        goto L10
    }

    private NetworkConnections<N, E> newConnections() {
        if (isDirected() == false) goto L9;
        if (allowsParallelEdges() == false) goto L14;
        return DirectedMultiNetworkConnections.of();
    L14:
        return DirectedNetworkConnections.of();
    L9:
        if (allowsParallelEdges() == false) goto L12;
        return UndirectedMultiNetworkConnections.of();
    L12:
        return UndirectedNetworkConnections.of();
    }
}
