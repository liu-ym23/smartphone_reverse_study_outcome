package com.google.common.graph;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class NetworkBuilder<N, E> extends AbstractGraphBuilder<N> {
    boolean allowsParallelEdges;
    ElementOrder<? super E> edgeOrder;
    Optional<Integer> expectedEdgeCount;

    /* JADX WARN: Multi-variable type inference failed */
    private <N1 extends N, E1 extends E> NetworkBuilder<N1, E1> cast() {
        return this;
    }

    private NetworkBuilder(boolean r1) {
        super(r1);
        this.allowsParallelEdges = false;
        this.edgeOrder = ElementOrder.insertion();
        this.expectedEdgeCount = Optional.absent();
    }

    public static NetworkBuilder<Object, Object> directed() {
        return new NetworkBuilder(true);
    }

    public static NetworkBuilder<Object, Object> undirected() {
        return new NetworkBuilder(false);
    }

    public static <N, E> NetworkBuilder<N, E> from(Network<N, E> r2) {
        return new NetworkBuilder(r2.isDirected()).allowsParallelEdges(r2.allowsParallelEdges()).allowsSelfLoops(r2.allowsSelfLoops()).nodeOrder(r2.nodeOrder()).edgeOrder(r2.edgeOrder());
    }

    public <N1 extends N, E1 extends E> ImmutableNetwork.Builder<N1, E1> immutable() {
        return new ImmutableNetwork.Builder(cast());
    }

    public NetworkBuilder<N, E> allowsParallelEdges(boolean r1) {
        this.allowsParallelEdges = r1;
        return this;
    }

    public NetworkBuilder<N, E> allowsSelfLoops(boolean r1) {
        this.allowsSelfLoops = r1;
        return this;
    }

    public NetworkBuilder<N, E> expectedNodeCount(int r1) {
        this.expectedNodeCount = Optional.of(Integer.valueOf(Graphs.checkNonNegative(r1)));
        return this;
    }

    public NetworkBuilder<N, E> expectedEdgeCount(int r1) {
        this.expectedEdgeCount = Optional.of(Integer.valueOf(Graphs.checkNonNegative(r1)));
        return this;
    }

    public <N1 extends N> NetworkBuilder<N1, E> nodeOrder(ElementOrder<N1> r1) {
        NetworkBuilder<N1, E> r0 = (NetworkBuilder<N1, E>) cast();
        r0.nodeOrder = (ElementOrder) Preconditions.checkNotNull(r1);
        return r0;
    }

    public <E1 extends E> NetworkBuilder<N, E1> edgeOrder(ElementOrder<E1> r1) {
        NetworkBuilder<N, E1> r0 = (NetworkBuilder<N, E1>) cast();
        r0.edgeOrder = (ElementOrder) Preconditions.checkNotNull(r1);
        return r0;
    }

    public <N1 extends N, E1 extends E> MutableNetwork<N1, E1> build() {
        return new StandardMutableNetwork(this);
    }
}
