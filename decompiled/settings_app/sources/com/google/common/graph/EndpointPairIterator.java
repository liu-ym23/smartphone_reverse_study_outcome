package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class EndpointPairIterator<N> extends AbstractIterator<EndpointPair<N>> {
    private final BaseGraph<N> graph;

    @CheckForNull
    N node;
    private final Iterator<N> nodeIterator;
    Iterator<N> successorIterator;

    /* JADX INFO: renamed from: com.google.common.graph.EndpointPairIterator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class Directed<N> extends EndpointPairIterator<N> {
        /* synthetic */ Directed(BaseGraph r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        protected /* bridge */ /* synthetic */ Object computeNext() {
            return computeNext();
        }

        private Directed(BaseGraph<N> r2) {
            super(r2, null);
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        protected EndpointPair<N> computeNext() {
        L3:
            if (this.successorIterator.hasNext() == true) goto L5;
            if (advance() == true) goto L3;
            return endOfData();
        L5:
            return EndpointPair.ordered(Objects.requireNonNull(this.node), this.successorIterator.next());
        }
    }

    private static final class Undirected<N> extends EndpointPairIterator<N> {

        @CheckForNull
        private Set<N> visitedNodes;

        /* synthetic */ Undirected(BaseGraph r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        protected /* bridge */ /* synthetic */ Object computeNext() {
            return computeNext();
        }

        private Undirected(BaseGraph<N> r2) {
            super(r2, null);
            this.visitedNodes = Sets.newHashSetWithExpectedSize(r2.nodes().size() + 1);
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        protected EndpointPair<N> computeNext() {
        L2:
            Objects.requireNonNull(this.visitedNodes);
        L4:
            if (this.successorIterator.hasNext() == false) goto L9;
            N r0 = this.successorIterator.next();
            if (this.visitedNodes.contains(r0) == true) goto L4;
            return EndpointPair.unordered(Objects.requireNonNull(this.node), r0);
        L9:
            this.visitedNodes.add(this.node);
            if (advance() == true) goto L2;
            this.visitedNodes = null;
            return endOfData();
        }
    }

    /* synthetic */ EndpointPairIterator(BaseGraph r1, AnonymousClass1 r2) {
        this(r1);
    }

    static <N> EndpointPairIterator<N> of(BaseGraph<N> r2) {
        AnonymousClass1 r1 = null;
        if (r2.isDirected() == false) goto L6;
        return new Directed(r2, r1);
    L6:
        return new Undirected(r2, r1);
    }

    private EndpointPairIterator(BaseGraph<N> r2) {
        this.node = null;
        this.successorIterator = ImmutableSet.of().iterator();
        this.graph = r2;
        this.nodeIterator = r2.nodes().iterator();
    }

    final boolean advance() {
        Preconditions.checkState(!this.successorIterator.hasNext());
        if (this.nodeIterator.hasNext() == true) goto L6;
        return false;
    L6:
        N r0 = this.nodeIterator.next();
        this.node = r0;
        this.successorIterator = this.graph.successors(r0).iterator();
        return true;
    }
}
