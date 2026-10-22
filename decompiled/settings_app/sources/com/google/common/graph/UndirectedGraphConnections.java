package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class UndirectedGraphConnections<N, V> implements GraphConnections<N, V> {
    private final Map<N, V> adjacentNodeValues;

    /* JADX INFO: renamed from: com.google.common.graph.UndirectedGraphConnections$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$graph$ElementOrder$Type = null;

        static {
            int[] r0 = new int[ElementOrder.Type.values().length];
            $SwitchMap$com$google$common$graph$ElementOrder$Type = r0;
            r0[ElementOrder.Type.UNORDERED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$google$common$graph$ElementOrder$Type[ElementOrder.Type.STABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    private UndirectedGraphConnections(Map<N, V> r1) {
        this.adjacentNodeValues = (Map) Preconditions.checkNotNull(r1);
    }

    static <N, V> UndirectedGraphConnections<N, V> of(ElementOrder<N> r4) {
        int r0 = AnonymousClass2.$SwitchMap$com$google$common$graph$ElementOrder$Type[r4.type().ordinal()];
        if (r0 == 1) goto L10;
        if (r0 != 2) goto L8;
        return new UndirectedGraphConnections(new LinkedHashMap(2, 1.0f));
    L8:
        throw new AssertionError(r4.type());
    L10:
        return new UndirectedGraphConnections(new HashMap(2, 1.0f));
    }

    static <N, V> UndirectedGraphConnections<N, V> ofImmutable(Map<N, V> r1) {
        return new UndirectedGraphConnections(ImmutableMap.copyOf(r1));
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> adjacentNodes() {
        return Collections.unmodifiableSet(this.adjacentNodeValues.keySet());
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> predecessors() {
        return adjacentNodes();
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> successors() {
        return adjacentNodes();
    }

    @Override // com.google.common.graph.GraphConnections
    public Iterator<EndpointPair<N>> incidentEdgeIterator(final N r3) {
        return Iterators.transform(this.adjacentNodeValues.keySet().iterator(), new AnonymousClass1(this, r3));
    }

    @Override // com.google.common.graph.GraphConnections
    @CheckForNull
    public V value(N r1) {
        return this.adjacentNodeValues.get(r1);
    }

    @Override // com.google.common.graph.GraphConnections
    public void removePredecessor(N r1) {
        removeSuccessor(r1);
    }

    @Override // com.google.common.graph.GraphConnections
    @CheckForNull
    public V removeSuccessor(N r1) {
        return this.adjacentNodeValues.remove(r1);
    }

    @Override // com.google.common.graph.GraphConnections
    public void addPredecessor(N r1, V r2) {
        addSuccessor(r1, r2);
    }

    @Override // com.google.common.graph.GraphConnections
    @CheckForNull
    public V addSuccessor(N r1, V r2) {
        return this.adjacentNodeValues.put(r1, r2);
    }
}
