package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.math.IntMath;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractNetwork<N, E> implements Network<N, E> {

    /* JADX INFO: renamed from: com.google.common.graph.AbstractNetwork$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractGraph<N> {
        final /* synthetic */ AbstractNetwork this$0;

        AnonymousClass1(AbstractNetwork r1) {
            this.this$0 = r1;
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
        public /* bridge */ /* synthetic */ Iterable predecessors(Object r1) {
            return predecessors(r1);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        public /* bridge */ /* synthetic */ Iterable successors(Object r1) {
            return successors(r1);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public Set<N> nodes() {
            return this.this$0.nodes();
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public Set<EndpointPair<N>> edges() {
            if (this.this$0.allowsParallelEdges() == false) goto L7;
            return super.edges();
        L7:
            return new C00711(this);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public ElementOrder<N> nodeOrder() {
            return this.this$0.nodeOrder();
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public ElementOrder<N> incidentEdgeOrder() {
            return ElementOrder.unordered();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public boolean isDirected() {
            return this.this$0.isDirected();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public boolean allowsSelfLoops() {
            return this.this$0.allowsSelfLoops();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public Set<N> adjacentNodes(N r1) {
            return this.this$0.adjacentNodes(r1);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
        public Set<N> predecessors(N r1) {
            return this.this$0.predecessors(r1);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        public Set<N> successors(N r1) {
            return this.this$0.successors(r1);
        }
    }

    public AbstractNetwork() {
    }

    @Override // com.google.common.graph.Network
    public Graph<N> asGraph() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.graph.Network
    public int degree(N r2) {
        if (isDirected() == false) goto L7;
        return IntMath.saturatedAdd(inEdges(r2).size(), outEdges(r2).size());
    L7:
        return IntMath.saturatedAdd(incidentEdges(r2).size(), edgesConnecting(r2, r2).size());
    }

    @Override // com.google.common.graph.Network
    public int inDegree(N r2) {
        if (isDirected() == false) goto L6;
        return inEdges(r2).size();
    L6:
        return degree(r2);
    }

    @Override // com.google.common.graph.Network
    public int outDegree(N r2) {
        if (isDirected() == false) goto L6;
        return outEdges(r2).size();
    L6:
        return degree(r2);
    }

    @Override // com.google.common.graph.Network
    public Set<E> adjacentEdges(E r3) {
        EndpointPair<N> r0 = incidentNodes(r3);
        return Sets.difference(Sets.union(incidentEdges(r0.nodeU()), incidentEdges(r0.nodeV())), ImmutableSet.of(r3));
    }

    @Override // com.google.common.graph.Network
    public Set<E> edgesConnecting(N r5, N r6) {
        Set<E> r0 = outEdges(r5);
        Set<E> r1 = inEdges(r6);
        if (r0.size() > r1.size()) goto L6;
        return Collections.unmodifiableSet(Sets.filter(r0, connectedPredicate(r5, r6)));
    L6:
        return Collections.unmodifiableSet(Sets.filter(r1, connectedPredicate(r6, r5)));
    }

    @Override // com.google.common.graph.Network
    public Set<E> edgesConnecting(EndpointPair<N> r2) {
        validateEndpoints(r2);
        return edgesConnecting(r2.nodeU(), r2.nodeV());
    }

    private Predicate<E> connectedPredicate(final N r2, final N r3) {
        return new AnonymousClass2(this, r2, r3);
    }

    @Override // com.google.common.graph.Network
    public Optional<E> edgeConnecting(N r1, N r2) {
        return Optional.ofNullable(edgeConnectingOrNull(r1, r2));
    }

    @Override // com.google.common.graph.Network
    public Optional<E> edgeConnecting(EndpointPair<N> r2) {
        validateEndpoints(r2);
        return edgeConnecting(r2.nodeU(), r2.nodeV());
    }

    @Override // com.google.common.graph.Network
    @CheckForNull
    public E edgeConnectingOrNull(N r4, N r5) {
        Set<E> r3 = edgesConnecting(r4, r5);
        int r0 = r3.size();
        if (r0 != 0) goto L5;
        return null;
    L5:
        if (r0 != 1) goto L9;
        return r3.iterator().next();
    L9:
        throw new IllegalArgumentException(String.format("Cannot call edgeConnecting() when parallel edges exist between %s and %s. Consider calling edgesConnecting() instead.", new Object[]{r4, r5}));
    }

    @Override // com.google.common.graph.Network
    @CheckForNull
    public E edgeConnectingOrNull(EndpointPair<N> r2) {
        validateEndpoints(r2);
        return edgeConnectingOrNull(r2.nodeU(), r2.nodeV());
    }

    @Override // com.google.common.graph.Network
    public boolean hasEdgeConnecting(N r2, N r3) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        if (nodes().contains(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (successors(r2).contains(r3) == false) goto L7;
        return true;
    }

    @Override // com.google.common.graph.Network
    public boolean hasEdgeConnecting(EndpointPair<N> r2) {
        Preconditions.checkNotNull(r2);
        if (isOrderingCompatible(r2) == true) goto L7;
        return false;
    L7:
        return hasEdgeConnecting(r2.nodeU(), r2.nodeV());
    }

    protected final void validateEndpoints(EndpointPair<?> r1) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkArgument(isOrderingCompatible(r1), "Mismatch: unordered endpoints cannot be used with directed graphs");
    }

    protected final boolean isOrderingCompatible(EndpointPair<?> r1) {
        if (r1.isOrdered() == false) goto L5;
    L8:
        return true;
    L5:
        if (isDirected() == false) goto L8;
        return false;
    }

    @Override // com.google.common.graph.Network
    public final boolean equals(@CheckForNull Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Network) == true) goto L8;
        return false;
    L8:
        Network r6 = (Network) r5;
        if (isDirected() != r6.isDirected()) goto L16;
        if (nodes().equals(r6.nodes()) == false) goto L16;
        if (edgeIncidentNodesMap(this).equals(edgeIncidentNodesMap(r6)) == false) goto L16;
        return true;
    L16:
        return false;
    }

    @Override // com.google.common.graph.Network
    public final int hashCode() {
        return edgeIncidentNodesMap(this).hashCode();
    }

    public String toString() {
        boolean r0 = isDirected();
        boolean r1 = allowsParallelEdges();
        boolean r2 = allowsSelfLoops();
        String r3 = String.valueOf(nodes());
        String r6 = String.valueOf(edgeIncidentNodesMap(this));
        return new StringBuilder((String.valueOf(r3).length() + 87) + String.valueOf(r6).length()).append("isDirected: ").append(r0).append(", allowsParallelEdges: ").append(r1).append(", allowsSelfLoops: ").append(r2).append(", nodes: ").append(r3).append(", edges: ").append(r6).toString();
    }

    private static <N, E> Map<E, EndpointPair<N>> edgeIncidentNodesMap(final Network<N, E> r1) {
        Function<E, EndpointPair<N>> r0 = new AnonymousClass3(r1);
        return Maps.asMap(r1.edges(), r0);
    }
}
