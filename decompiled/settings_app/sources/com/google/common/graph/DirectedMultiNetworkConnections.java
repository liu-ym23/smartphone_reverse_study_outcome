package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class DirectedMultiNetworkConnections<N, E> extends AbstractDirectedNetworkConnections<N, E> {

    @CheckForNull
    @LazyInit
    private transient Reference<Multiset<N>> predecessorsReference;

    @CheckForNull
    @LazyInit
    private transient Reference<Multiset<N>> successorsReference;

    static /* synthetic */ Multiset access$000(DirectedMultiNetworkConnections r0) {
        return r0.successorsMultiset();
    }

    private DirectedMultiNetworkConnections(Map<E, N> r1, Map<E, N> r2, int r3) {
        super(r1, r2, r3);
    }

    static <N, E> DirectedMultiNetworkConnections<N, E> of() {
        return new DirectedMultiNetworkConnections(new HashMap(2, 1.0f), new HashMap(2, 1.0f), 0);
    }

    static <N, E> DirectedMultiNetworkConnections<N, E> ofImmutable(Map<E, N> r1, Map<E, N> r2, int r3) {
        return new DirectedMultiNetworkConnections(ImmutableMap.copyOf(r1), ImmutableMap.copyOf(r2), r3);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> predecessors() {
        return Collections.unmodifiableSet(predecessorsMultiset().elementSet());
    }

    private Multiset<N> predecessorsMultiset() {
        Multiset<N> r0 = (Multiset) getReference(this.predecessorsReference);
        if (r0 != null) goto L6;
        HashMultiset r1 = HashMultiset.create(this.inEdgeMap.values());
        this.predecessorsReference = new SoftReference(r1);
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> successors() {
        return Collections.unmodifiableSet(successorsMultiset().elementSet());
    }

    private Multiset<N> successorsMultiset() {
        Multiset<N> r0 = (Multiset) getReference(this.successorsReference);
        if (r0 != null) goto L6;
        HashMultiset r1 = HashMultiset.create(this.outEdgeMap.values());
        this.successorsReference = new SoftReference(r1);
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> edgesConnecting(final N r3) {
        final Map<E, N> r1 = this.outEdgeMap;
        return new AnonymousClass1(this, r1, r3, r3);
    }

    @Override // com.google.common.graph.AbstractDirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public N removeInEdge(E r1, boolean r2) {
        N r3 = (N) super.removeInEdge(r1, r2);
        Multiset r0 = (Multiset) getReference(this.predecessorsReference);
        if (r0 == null) goto L5;
        Preconditions.checkState(r0.remove(r3));
    L5:
        return r3;
    }

    @Override // com.google.common.graph.AbstractDirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public N removeOutEdge(E r1) {
        N r2 = (N) super.removeOutEdge(r1);
        Multiset r0 = (Multiset) getReference(this.successorsReference);
        if (r0 == null) goto L5;
        Preconditions.checkState(r0.remove(r2));
    L5:
        return r2;
    }

    @Override // com.google.common.graph.AbstractDirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public void addInEdge(E r1, N r2, boolean r3) {
        super.addInEdge(r1, r2, r3);
        Multiset r0 = (Multiset) getReference(this.predecessorsReference);
        if (r0 == null) goto L6;
        Preconditions.checkState(r0.add(r2));
        return;
    }

    @Override // com.google.common.graph.AbstractDirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public void addOutEdge(E r1, N r2) {
        super.addOutEdge(r1, r2);
        Multiset r0 = (Multiset) getReference(this.successorsReference);
        if (r0 == null) goto L6;
        Preconditions.checkState(r0.add(r2));
        return;
    }

    @CheckForNull
    private static <T> T getReference(@CheckForNull Reference<T> r0) {
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.get();
    }
}
