package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractDirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
    final Map<E, N> inEdgeMap;
    final Map<E, N> outEdgeMap;
    private int selfLoopCount;

    static /* synthetic */ int access$000(AbstractDirectedNetworkConnections r0) {
        return r0.selfLoopCount;
    }

    AbstractDirectedNetworkConnections(Map<E, N> r2, Map<E, N> r3, int r4) {
        this.inEdgeMap = (Map) Preconditions.checkNotNull(r2);
        this.outEdgeMap = (Map) Preconditions.checkNotNull(r3);
        this.selfLoopCount = Graphs.checkNonNegative(r4);
        if (r4 <= r2.size()) goto L5;
    L7:
        boolean r1 = false;
    L8:
        Preconditions.checkState(r1);
        return;
    L5:
        if (r4 > r3.size()) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> adjacentNodes() {
        return Sets.union(predecessors(), successors());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> incidentEdges() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> inEdges() {
        return Collections.unmodifiableSet(this.inEdgeMap.keySet());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> outEdges() {
        return Collections.unmodifiableSet(this.outEdgeMap.keySet());
    }

    @Override // com.google.common.graph.NetworkConnections
    public N adjacentNode(E r1) {
        return (N) Objects.requireNonNull(this.outEdgeMap.get(r1));
    }

    @Override // com.google.common.graph.NetworkConnections
    public N removeInEdge(E r1, boolean r2) {
        if (r2 == false) goto L5;
        int r3 = this.selfLoopCount - 1;
        this.selfLoopCount = r3;
        Graphs.checkNonNegative(r3);
    L5:
        return (N) Objects.requireNonNull(this.inEdgeMap.remove(r1));
    }

    @Override // com.google.common.graph.NetworkConnections
    public N removeOutEdge(E r1) {
        return (N) Objects.requireNonNull(this.outEdgeMap.remove(r1));
    }

    @Override // com.google.common.graph.NetworkConnections
    public void addInEdge(E r2, N r3, boolean r4) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        boolean r0 = true;
        if (r4 == false) goto L6;
        int r5 = this.selfLoopCount + 1;
        this.selfLoopCount = r5;
        Graphs.checkPositive(r5);
    L6:
        if (this.inEdgeMap.put(r2, r3) == null) goto L9;
        r0 = false;
    L9:
        Preconditions.checkState(r0);
    }

    @Override // com.google.common.graph.NetworkConnections
    public void addOutEdge(E r1, N r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        if (this.outEdgeMap.put(r1, r2) != null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        return;
    L5:
        r0 = false;
        goto L6
    }
}
