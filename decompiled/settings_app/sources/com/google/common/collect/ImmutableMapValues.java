package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class ImmutableMapValues<K, V> extends ImmutableCollection<V> {
    private final ImmutableMap<K, V> map;

    private static class SerializedForm<V> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<?, V> map;

        SerializedForm(ImmutableMap<?, V> r1) {
            this.map = r1;
        }

        Object readResolve() {
            return this.map.values();
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    static /* synthetic */ ImmutableMap access$000(ImmutableMapValues r0) {
        return r0.map;
    }

    ImmutableMapValues(ImmutableMap<K, V> r1) {
        this.map = r1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.map.size();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public UnmodifiableIterator<V> iterator() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<V> spliterator() {
        return CollectSpliterators.map(this.map.entrySet().spliterator(), new ImmutableMapValues$$ExternalSyntheticLambda0());
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (Iterators.contains(iterator(), r1) == false) goto L6;
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<V> asList() {
        final ImmutableList<Map.Entry<K, V>> r0 = this.map.entrySet().asList();
        return new AnonymousClass2(this, r0);
    }

    @Override // java.lang.Iterable
    public void forEach(final Consumer<? super V> r2) {
        Preconditions.checkNotNull(r2);
        this.map.forEach(new ImmutableMapValues$$ExternalSyntheticLambda1(r2));
    }

    static /* synthetic */ void lambda$forEach$0(Consumer r0, Object r1, Object r2) {
        r0.accept(r2);
    }
}
