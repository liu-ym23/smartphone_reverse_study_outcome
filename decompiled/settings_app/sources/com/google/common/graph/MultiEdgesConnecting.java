package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class MultiEdgesConnecting<E> extends AbstractSet<E> {
    private final Map<E, ?> outEdgeToNode;
    private final Object targetNode;

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    static /* synthetic */ Object access$000(MultiEdgesConnecting r0) {
        return r0.targetNode;
    }

    MultiEdgesConnecting(Map<E, ?> r1, Object r2) {
        this.outEdgeToNode = (Map) Preconditions.checkNotNull(r1);
        this.targetNode = Preconditions.checkNotNull(r2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<E> iterator() {
        final Iterator<Map.Entry<E, ?>> r0 = this.outEdgeToNode.entrySet().iterator();
        return new AnonymousClass1(this, r0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object r2) {
        return this.targetNode.equals(this.outEdgeToNode.get(r2));
    }
}
