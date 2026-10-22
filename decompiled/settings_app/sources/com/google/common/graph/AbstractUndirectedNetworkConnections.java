package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractUndirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
    final Map<E, N> incidentEdgeMap;

    AbstractUndirectedNetworkConnections(Map<E, N> r1) {
        this.incidentEdgeMap = (Map) Preconditions.checkNotNull(r1);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> predecessors() {
        return adjacentNodes();
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> successors() {
        return adjacentNodes();
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> incidentEdges() {
        return Collections.unmodifiableSet(this.incidentEdgeMap.keySet());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> inEdges() {
        return incidentEdges();
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> outEdges() {
        return incidentEdges();
    }

    @Override // com.google.common.graph.NetworkConnections
    public N adjacentNode(E r1) {
        return (N) Objects.requireNonNull(this.incidentEdgeMap.get(r1));
    }

    @Override // com.google.common.graph.NetworkConnections
    @CheckForNull
    public N removeInEdge(E r1, boolean r2) {
        if (r2 == false) goto L4;
        return null;
    L4:
        return removeOutEdge(r1);
    }

    @Override // com.google.common.graph.NetworkConnections
    public N removeOutEdge(E r1) {
        return (N) Objects.requireNonNull(this.incidentEdgeMap.remove(r1));
    }

    @Override // com.google.common.graph.NetworkConnections
    public void addInEdge(E r1, N r2, boolean r3) {
        if (r3 == true) goto L5;
        addOutEdge(r1, r2);
        return;
    }

    @Override // com.google.common.graph.NetworkConnections
    public void addOutEdge(E r1, N r2) {
        if (this.incidentEdgeMap.put(r1, r2) != null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        return;
    L5:
        r0 = false;
        goto L6
    }
}
