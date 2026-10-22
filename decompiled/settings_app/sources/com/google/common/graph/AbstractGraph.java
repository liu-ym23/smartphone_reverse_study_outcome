package com.google.common.graph;

import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractGraph<N> extends AbstractBaseGraph<N> implements Graph<N> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int degree(Object r1) {
        return super.degree(r1);
    }

    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ Set edges() {
        return super.edges();
    }

    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(EndpointPair r1) {
        return super.hasEdgeConnecting(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(Object r1, Object r2) {
        return super.hasEdgeConnecting(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int inDegree(Object r1) {
        return super.inDegree(r1);
    }

    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ ElementOrder incidentEdgeOrder() {
        return super.incidentEdgeOrder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ Set incidentEdges(Object r1) {
        return super.incidentEdges(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int outDegree(Object r1) {
        return super.outDegree(r1);
    }

    public AbstractGraph() {
    }

    @Override // com.google.common.graph.Graph
    public final boolean equals(@CheckForNull Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Graph) == true) goto L8;
        return false;
    L8:
        Graph r6 = (Graph) r5;
        if (isDirected() != r6.isDirected()) goto L16;
        if (nodes().equals(r6.nodes()) == false) goto L16;
        if (edges().equals(r6.edges()) == false) goto L16;
        return true;
    L16:
        return false;
    }

    @Override // com.google.common.graph.Graph
    public final int hashCode() {
        return edges().hashCode();
    }

    public String toString() {
        boolean r0 = isDirected();
        boolean r1 = allowsSelfLoops();
        String r2 = String.valueOf(nodes());
        String r5 = String.valueOf(edges());
        return new StringBuilder((String.valueOf(r2).length() + 59) + String.valueOf(r5).length()).append("isDirected: ").append(r0).append(", allowsSelfLoops: ").append(r1).append(", nodes: ").append(r2).append(", edges: ").append(r5).toString();
    }
}
