package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractValueGraph<N, V> extends AbstractBaseGraph<N> implements ValueGraph<N, V> {
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

    public AbstractValueGraph() {
    }

    @Override // com.google.common.graph.ValueGraph
    public Graph<N> asGraph() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.graph.ValueGraph
    public Optional<V> edgeValue(N r2, N r3) {
        return Optional.ofNullable(edgeValueOrDefault(r2, r3, null));
    }

    @Override // com.google.common.graph.ValueGraph
    public Optional<V> edgeValue(EndpointPair<N> r2) {
        return Optional.ofNullable(edgeValueOrDefault(r2, null));
    }

    @Override // com.google.common.graph.ValueGraph
    public final boolean equals(@CheckForNull Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ValueGraph) == true) goto L8;
        return false;
    L8:
        ValueGraph r6 = (ValueGraph) r5;
        if (isDirected() != r6.isDirected()) goto L16;
        if (nodes().equals(r6.nodes()) == false) goto L16;
        if (edgeValueMap(this).equals(edgeValueMap(r6)) == false) goto L16;
        return true;
    L16:
        return false;
    }

    @Override // com.google.common.graph.ValueGraph
    public final int hashCode() {
        return edgeValueMap(this).hashCode();
    }

    public String toString() {
        boolean r0 = isDirected();
        boolean r1 = allowsSelfLoops();
        String r2 = String.valueOf(nodes());
        String r5 = String.valueOf(edgeValueMap(this));
        return new StringBuilder((String.valueOf(r2).length() + 59) + String.valueOf(r5).length()).append("isDirected: ").append(r0).append(", allowsSelfLoops: ").append(r1).append(", nodes: ").append(r2).append(", edges: ").append(r5).toString();
    }

    private static <N, V> Map<EndpointPair<N>, V> edgeValueMap(final ValueGraph<N, V> r1) {
        Function<EndpointPair<N>, V> r0 = new AnonymousClass2(r1);
        return Maps.asMap(r1.edges(), r0);
    }
}
