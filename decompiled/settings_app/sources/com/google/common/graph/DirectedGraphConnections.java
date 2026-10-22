package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class DirectedGraphConnections<N, V> implements GraphConnections<N, V> {
    private static final Object PRED = null;
    private final Map<N, Object> adjacentNodeValues;

    @CheckForNull
    private final List<NodeConnection<N>> orderedNodeConnections;
    private int predecessorCount;
    private int successorCount;

    /* JADX INFO: renamed from: com.google.common.graph.DirectedGraphConnections$8, reason: invalid class name */
    static /* synthetic */ class AnonymousClass8 {
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

    private static abstract class NodeConnection<N> {
        final N node;

        static final class Pred<N> extends NodeConnection<N> {
            Pred(N r1) {
                super(r1);
            }

            public boolean equals(@CheckForNull Object r2) {
                if ((r2 instanceof Pred) == true) goto L5;
                return false;
            L5:
                return this.node.equals(((Pred) r2).node);
            }

            public int hashCode() {
                return Pred.class.hashCode() + this.node.hashCode();
            }
        }

        static final class Succ<N> extends NodeConnection<N> {
            Succ(N r1) {
                super(r1);
            }

            public boolean equals(@CheckForNull Object r2) {
                if ((r2 instanceof Succ) == true) goto L5;
                return false;
            L5:
                return this.node.equals(((Succ) r2).node);
            }

            public int hashCode() {
                return Succ.class.hashCode() + this.node.hashCode();
            }
        }

        NodeConnection(N r1) {
            this.node = (N) Preconditions.checkNotNull(r1);
        }
    }

    private static final class PredAndSucc {
        private final Object successorValue;

        static /* synthetic */ Object access$600(PredAndSucc r0) {
            return r0.successorValue;
        }

        PredAndSucc(Object r1) {
            this.successorValue = r1;
        }
    }

    static /* synthetic */ List access$000(DirectedGraphConnections r0) {
        return r0.orderedNodeConnections;
    }

    static /* synthetic */ Map access$100(DirectedGraphConnections r0) {
        return r0.adjacentNodeValues;
    }

    static /* synthetic */ boolean access$200(Object r0) {
        return isPredecessor(r0);
    }

    static /* synthetic */ int access$300(DirectedGraphConnections r0) {
        return r0.predecessorCount;
    }

    static /* synthetic */ boolean access$400(Object r0) {
        return isSuccessor(r0);
    }

    static /* synthetic */ int access$500(DirectedGraphConnections r0) {
        return r0.successorCount;
    }

    static {
        PRED = new Object();
    }

    private DirectedGraphConnections(Map<N, Object> r2, @CheckForNull List<NodeConnection<N>> r3, int r4, int r5) {
        this.adjacentNodeValues = (Map) Preconditions.checkNotNull(r2);
        this.orderedNodeConnections = r3;
        this.predecessorCount = Graphs.checkNonNegative(r4);
        this.successorCount = Graphs.checkNonNegative(r5);
        if (r4 <= r2.size()) goto L5;
    L7:
        boolean r1 = false;
    L8:
        Preconditions.checkState(r1);
        return;
    L5:
        if (r5 > r2.size()) goto L7;
        r1 = true;
        goto L8
    }

    static <N, V> DirectedGraphConnections<N, V> of(ElementOrder<N> r4) {
        int r0 = AnonymousClass8.$SwitchMap$com$google$common$graph$ElementOrder$Type[r4.type().ordinal()];
        if (r0 != 1) goto L5;
        ArrayList r5 = null;
    L11:
        return new DirectedGraphConnections(new HashMap(4, 1.0f), r5, 0, 0);
    L5:
        if (r0 != 2) goto L8;
        r5 = new ArrayList();
        goto L11
    L8:
        throw new AssertionError(r4.type());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <N, V> DirectedGraphConnections<N, V> ofImmutable(N r9, Iterable<EndpointPair<N>> r10, Function<N, V> r11) {
        Preconditions.checkNotNull(r9);
        Preconditions.checkNotNull(r11);
        HashMap r0 = new HashMap();
        ImmutableList.Builder r1 = ImmutableList.builder();
        Iterator<EndpointPair<N>> r12 = r10.iterator();
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r12.hasNext() == false) goto L26;
        EndpointPair<N> r5 = r12.next();
        if (r5.nodeU().equals(r9) == false) goto L12;
        if (r5.nodeV().equals(r9) == false) goto L12;
        r0.put(r9, new PredAndSucc(r11.apply(r9)));
        r1.add(new NodeConnection.Pred(r9));
        r1.add(new NodeConnection.Succ(r9));
        r3 = r3 + 1;
    L10:
        r4 = r4 + 1;
    L12:
        if (r5.nodeV().equals(r9) == false) goto L17;
        N r6 = r5.nodeU();
        Object r7 = r0.put(r6, PRED);
        if (r7 == null) goto L16;
        r0.put(r6, new PredAndSucc(r7));
    L16:
        r1.add(new NodeConnection.Pred(r6));
        r3 = r3 + 1;
        goto L4
    L17:
        Preconditions.checkArgument(r5.nodeU().equals(r9));
        N r8 = r5.nodeV();
        V r13 = r11.apply(r8);
        Object r14 = r0.put(r8, r13);
        if (r14 != null) goto L20;
    L24:
        r1.add(new NodeConnection.Succ(r8));
        goto L10
    L20:
        if (r14 != PRED) goto L22;
        boolean r15 = true;
    L23:
        Preconditions.checkArgument(r15);
        r0.put(r8, new PredAndSucc(r13));
        goto L24
    L22:
        r15 = false;
        goto L23
    L26:
        return new DirectedGraphConnections(r0, r1.build(), r3, r4);
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> adjacentNodes() {
        if (this.orderedNodeConnections != null) goto L7;
        return Collections.unmodifiableSet(this.adjacentNodeValues.keySet());
    L7:
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> predecessors() {
        return new AnonymousClass2(this);
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> successors() {
        return new AnonymousClass3(this);
    }

    @Override // com.google.common.graph.GraphConnections
    public Iterator<EndpointPair<N>> incidentEdgeIterator(final N r4) {
        Preconditions.checkNotNull(r4);
        List<NodeConnection<N>> r0 = this.orderedNodeConnections;
        if (r0 != null) goto L5;
        final Iterator r5 = Iterators.concat(Iterators.transform(predecessors().iterator(), new AnonymousClass4(this, r4)), Iterators.transform(successors().iterator(), new AnonymousClass5(this, r4)));
    L6:
        final AtomicBoolean r1 = new AtomicBoolean(false);
        return new AnonymousClass7(this, r5, r1);
    L5:
        r5 = Iterators.transform(r0.iterator(), new AnonymousClass6(this, r4));
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.GraphConnections
    @CheckForNull
    public V value(N r1) {
        Preconditions.checkNotNull(r1);
        V r0 = (V) this.adjacentNodeValues.get(r1);
        if (r0 != PRED) goto L7;
        return null;
    L7:
        if ((r0 instanceof PredAndSucc) == true) goto L9;
        return r0;
    L9:
        return (V) PredAndSucc.access$600((PredAndSucc) r0);
    }

    @Override // com.google.common.graph.GraphConnections
    public void removePredecessor(N r4) {
        Preconditions.checkNotNull(r4);
        Object r0 = this.adjacentNodeValues.get(r4);
        if (r0 != PRED) goto L7;
        this.adjacentNodeValues.remove(r4);
    L5:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L15;
        int r2 = this.predecessorCount - 1;
        this.predecessorCount = r2;
        Graphs.checkNonNegative(r2);
        List<NodeConnection<N>> r3 = this.orderedNodeConnections;
        if (r3 == null) goto L16;
        r3.remove(new NodeConnection.Pred(r4));
        return;
    L16:
        return;
    L15:
        return;
    L7:
        if ((r0 instanceof PredAndSucc) == false) goto L9;
        this.adjacentNodeValues.put(r4, PredAndSucc.access$600((PredAndSucc) r0));
        goto L5
    L9:
        r1 = false;
        goto L10
    }

    @Override // com.google.common.graph.GraphConnections
    @CheckForNull
    public V removeSuccessor(Object r5) {
        Preconditions.checkNotNull(r5);
        Object r0 = this.adjacentNodeValues.get(r5);
        if (r0 == null) goto L11;
        Object r2 = PRED;
        if (r0 == r2) goto L11;
        if ((r0 instanceof PredAndSucc) == false) goto L10;
        this.adjacentNodeValues.put(r5, r2);
        r0 = PredAndSucc.access$600((PredAndSucc) r0);
    L12:
        if (r0 == null) goto L16;
        int r3 = this.successorCount - 1;
        this.successorCount = r3;
        Graphs.checkNonNegative(r3);
        List<NodeConnection<N>> r4 = this.orderedNodeConnections;
        if (r4 == null) goto L16;
        r4.remove(new NodeConnection.Succ(r5));
    L16:
        if (r0 != null) goto L19;
        return null;
    L19:
        return (V) r0;
    L10:
        this.adjacentNodeValues.remove(r5);
    L11:
        r0 = null;
        goto L12
    }

    @Override // com.google.common.graph.GraphConnections
    public void addPredecessor(N r5, V r6) {
        Map<N, Object> r7 = this.adjacentNodeValues;
        Object r0 = PRED;
        Object r8 = r7.put(r5, r0);
        if (r8 != null) goto L5;
    L4:
        boolean r3 = true;
    L10:
        if (r3 == false) goto L15;
        int r9 = this.predecessorCount + 1;
        this.predecessorCount = r9;
        Graphs.checkPositive(r9);
        List<NodeConnection<N>> r4 = this.orderedNodeConnections;
        if (r4 == null) goto L16;
        r4.add(new NodeConnection.Pred(r5));
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r3 = false;
        if ((r8 instanceof PredAndSucc) == false) goto L8;
        this.adjacentNodeValues.put(r5, r8);
        goto L10
    L8:
        if (r8 == r0) goto L10;
        this.adjacentNodeValues.put(r5, new PredAndSucc(r8));
        goto L4
    }

    @Override // com.google.common.graph.GraphConnections
    @CheckForNull
    public V addSuccessor(N r5, V r6) {
        Object r0 = this.adjacentNodeValues.put(r5, r6);
        if (r0 != null) goto L6;
    L4:
        r0 = null;
    L11:
        if (r0 != null) goto L15;
        int r7 = this.successorCount + 1;
        this.successorCount = r7;
        Graphs.checkPositive(r7);
        List<NodeConnection<N>> r4 = this.orderedNodeConnections;
        if (r4 == null) goto L15;
        r4.add(new NodeConnection.Succ(r5));
    L15:
        if (r0 != null) goto L18;
        return null;
    L18:
        return (V) r0;
    L6:
        if ((r0 instanceof PredAndSucc) == false) goto L9;
        this.adjacentNodeValues.put(r5, new PredAndSucc(r6));
        r0 = PredAndSucc.access$600((PredAndSucc) r0);
        goto L11
    L9:
        if (r0 != PRED) goto L11;
        this.adjacentNodeValues.put(r5, new PredAndSucc(r6));
        goto L4
    }

    private static boolean isPredecessor(@CheckForNull Object r1) {
        if (r1 != PRED) goto L5;
    L8:
        return true;
    L5:
        if ((r1 instanceof PredAndSucc) == true) goto L8;
        return false;
    }

    private static boolean isSuccessor(@CheckForNull Object r1) {
        if (r1 == PRED) goto L6;
        if (r1 == null) goto L6;
        return true;
    L6:
        return false;
    }
}
