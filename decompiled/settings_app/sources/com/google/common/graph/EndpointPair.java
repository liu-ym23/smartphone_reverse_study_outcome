package com.google.common.graph;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@Immutable(containerOf = {"N"})
@ElementTypesAreNonnullByDefault
public abstract class EndpointPair<N> implements Iterable<N> {
    private final N nodeU;
    private final N nodeV;

    /* JADX INFO: renamed from: com.google.common.graph.EndpointPair$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class Ordered<N> extends EndpointPair<N> {
        @Override // com.google.common.graph.EndpointPair
        public boolean isOrdered() {
            return true;
        }

        /* synthetic */ Ordered(Object r1, Object r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        private Ordered(N r2, N r3) {
            super(r2, r3, null);
        }

        @Override // com.google.common.graph.EndpointPair
        public N source() {
            return nodeU();
        }

        @Override // com.google.common.graph.EndpointPair
        public N target() {
            return nodeV();
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean equals(@CheckForNull Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if ((r5 instanceof EndpointPair) == true) goto L8;
            return false;
        L8:
            EndpointPair r6 = (EndpointPair) r5;
            if (isOrdered() == r6.isOrdered()) goto L12;
            return false;
        L12:
            if (source().equals(r6.source()) == false) goto L17;
            if (target().equals(r6.target()) == false) goto L17;
            return true;
        L17:
            return false;
        }

        @Override // com.google.common.graph.EndpointPair
        public int hashCode() {
            return Objects.hashCode(new Object[]{source(), target()});
        }

        public String toString() {
            String r0 = String.valueOf(source());
            String r3 = String.valueOf(target());
            return new StringBuilder((String.valueOf(r0).length() + 6) + String.valueOf(r3).length()).append("<").append(r0).append(" -> ").append(r3).append(">").toString();
        }
    }

    private static final class Unordered<N> extends EndpointPair<N> {
        @Override // com.google.common.graph.EndpointPair
        public boolean isOrdered() {
            return false;
        }

        /* synthetic */ Unordered(Object r1, Object r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        private Unordered(N r2, N r3) {
            super(r2, r3, null);
        }

        @Override // com.google.common.graph.EndpointPair
        public N source() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        @Override // com.google.common.graph.EndpointPair
        public N target() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean equals(@CheckForNull Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if ((r5 instanceof EndpointPair) == true) goto L8;
            return false;
        L8:
            EndpointPair r6 = (EndpointPair) r5;
            if (isOrdered() == r6.isOrdered()) goto L12;
            return false;
        L12:
            if (nodeU().equals(r6.nodeU()) == false) goto L16;
            return nodeV().equals(r6.nodeV());
        L16:
            if (nodeU().equals(r6.nodeV()) == false) goto L21;
            if (nodeV().equals(r6.nodeU()) == false) goto L21;
            return true;
        L21:
            return false;
        }

        @Override // com.google.common.graph.EndpointPair
        public int hashCode() {
            return nodeU().hashCode() + nodeV().hashCode();
        }

        public String toString() {
            String r0 = String.valueOf(nodeU());
            String r3 = String.valueOf(nodeV());
            return new StringBuilder((String.valueOf(r0).length() + 4) + String.valueOf(r3).length()).append("[").append(r0).append(", ").append(r3).append("]").toString();
        }
    }

    public abstract boolean equals(@CheckForNull Object r1);

    public abstract int hashCode();

    public abstract boolean isOrdered();

    public abstract N source();

    public abstract N target();

    @Override // java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    /* synthetic */ EndpointPair(Object r1, Object r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    private EndpointPair(N r1, N r2) {
        this.nodeU = (N) Preconditions.checkNotNull(r1);
        this.nodeV = (N) Preconditions.checkNotNull(r2);
    }

    public static <N> EndpointPair<N> ordered(N r2, N r3) {
        return new Ordered(r2, r3, null);
    }

    public static <N> EndpointPair<N> unordered(N r2, N r3) {
        return new Unordered(r3, r2, null);
    }

    static <N> EndpointPair<N> of(Graph<?> r0, N r1, N r2) {
        if (r0.isDirected() == false) goto L6;
        return ordered(r1, r2);
    L6:
        return unordered(r1, r2);
    }

    static <N> EndpointPair<N> of(Network<?, ?> r0, N r1, N r2) {
        if (r0.isDirected() == false) goto L6;
        return ordered(r1, r2);
    L6:
        return unordered(r1, r2);
    }

    public final N nodeU() {
        return this.nodeU;
    }

    public final N nodeV() {
        return this.nodeV;
    }

    public final N adjacentNode(N r4) {
        if (r4.equals(this.nodeU) == false) goto L7;
        return this.nodeV;
    L7:
        if (r4.equals(this.nodeV) == true) goto L9;
        String r3 = String.valueOf(this);
        String r5 = String.valueOf(r4);
        throw new IllegalArgumentException(new StringBuilder((String.valueOf(r3).length() + 36) + String.valueOf(r5).length()).append("EndpointPair ").append(r3).append(" does not contain node ").append(r5).toString());
    L9:
        return this.nodeU;
    }

    @Override // java.lang.Iterable
    public final UnmodifiableIterator<N> iterator() {
        return Iterators.forArray(new Object[]{this.nodeU, this.nodeV});
    }
}
