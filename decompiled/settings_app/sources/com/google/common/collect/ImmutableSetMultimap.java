package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Stream;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements SetMultimap<K, V> {
    private static final long serialVersionUID = 0;
    private final transient ImmutableSet<V> emptySet;

    @CheckForNull
    @LazyInit
    private transient ImmutableSet<Map.Entry<K, V>> entries;

    @CheckForNull
    @LazyInit
    private transient ImmutableSetMultimap<V, K> inverse;

    public static final class Builder<K, V> extends ImmutableMultimap.Builder<K, V> {
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public /* bridge */ /* synthetic */ ImmutableMultimap build() {
            return build();
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        /* bridge */ /* synthetic */ ImmutableMultimap.Builder combine(ImmutableMultimap.Builder r1) {
            return combine(r1);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder orderKeysBy(Comparator r1) {
            return orderKeysBy(r1);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder orderValuesBy(Comparator r1) {
            return orderValuesBy(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder put(Object r1, Object r2) {
            return put(r1, r2);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder put(Map.Entry r1) {
            return put(r1);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder putAll(Multimap r1) {
            return putAll(r1);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder putAll(Iterable r1) {
            return putAll(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder putAll(Object r1, Iterable r2) {
            return putAll(r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder putAll(Object r1, Object[] r2) {
            return putAll(r1, r2);
        }

        public Builder() {
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        Collection<V> newMutableValueCollection() {
            return Platform.preservesInsertionOrderOnAddsSet();
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public Builder<K, V> put(K r1, V r2) {
            super.put(r1, r2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> r1) {
            super.put(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> r1) {
            super.putAll(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public Builder<K, V> putAll(K r1, Iterable<? extends V> r2) {
            super.putAll(r1, r2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public Builder<K, V> putAll(K r1, V... r2) {
            return putAll(r1, Arrays.asList(r2));
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public Builder<K, V> putAll(Multimap<? extends K, ? extends V> r3) {
            Iterator<Map.Entry<? extends K, Collection<? extends V>>> r4 = r3.asMap().entrySet().iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            Map.Entry<? extends K, Collection<? extends V>> r0 = r4.next();
            putAll(r0.getKey(), r0.getValue());
            goto L4
        L6:
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        Builder<K, V> combine(ImmutableMultimap.Builder<K, V> r1) {
            super.combine(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public Builder<K, V> orderKeysBy(Comparator<? super K> r1) {
            super.orderKeysBy(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public Builder<K, V> orderValuesBy(Comparator<? super V> r1) {
            super.orderValuesBy(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public ImmutableSetMultimap<K, V> build() {
            Collection r0 = this.builderMap.entrySet();
            if (this.keyComparator == null) goto L6;
            r0 = Ordering.from(this.keyComparator).onKeys().immutableSortedCopy(r0);
        L6:
            return ImmutableSetMultimap.fromMapEntries(r0, this.valueComparator);
        }
    }

    private static final class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        private final transient ImmutableSetMultimap<K, V> multimap;

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        EntrySet(ImmutableSetMultimap<K, V> r1) {
            this.multimap = r1;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r2) {
            if ((r2 instanceof Map.Entry) == false) goto L6;
            Map.Entry r3 = (Map.Entry) r2;
            return this.multimap.containsEntry(r3.getKey(), r3.getValue());
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.multimap.size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }
    }

    private static final class SetFieldSettersHolder {
        static final Serialization.FieldSetter<ImmutableSetMultimap> EMPTY_SET_FIELD_SETTER = null;

        private SetFieldSettersHolder() {
        }

        static {
            EMPTY_SET_FIELD_SETTER = Serialization.getFieldSetter(ImmutableSetMultimap.class, "emptySet");
        }
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ ImmutableCollection entries() {
        return entries();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection entries() {
        return entries();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set entries() {
        return entries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ ImmutableCollection get(Object r1) {
        return get(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Collection get(Object r1) {
        return get(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Set get(Object r1) {
        return get(r1);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public /* bridge */ /* synthetic */ ImmutableMultimap inverse() {
        return inverse();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @Deprecated
    public /* bridge */ /* synthetic */ ImmutableCollection removeAll(@CheckForNull Object r1) {
        return removeAll(r1);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @Deprecated
    public /* bridge */ /* synthetic */ Collection removeAll(@CheckForNull Object r1) {
        return removeAll(r1);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @Deprecated
    public /* bridge */ /* synthetic */ Set removeAll(@CheckForNull Object r1) {
        return removeAll(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @Deprecated
    public /* bridge */ /* synthetic */ ImmutableCollection replaceValues(Object r1, Iterable r2) {
        return replaceValues(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @Deprecated
    public /* bridge */ /* synthetic */ Collection replaceValues(Object r1, Iterable r2) {
        return replaceValues(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @Deprecated
    public /* bridge */ /* synthetic */ Set replaceValues(Object r1, Iterable r2) {
        return replaceValues(r1, r2);
    }

    public static <T, K, V> Collector<T, ?, ImmutableSetMultimap<K, V>> toImmutableSetMultimap(Function<? super T, ? extends K> r0, Function<? super T, ? extends V> r1) {
        return CollectCollectors.toImmutableSetMultimap(r0, r1);
    }

    public static <T, K, V> Collector<T, ?, ImmutableSetMultimap<K, V>> flatteningToImmutableSetMultimap(Function<? super T, ? extends K> r0, Function<? super T, ? extends Stream<? extends V>> r1) {
        return CollectCollectors.flatteningToImmutableSetMultimap(r0, r1);
    }

    public static <K, V> ImmutableSetMultimap<K, V> of() {
        return EmptyImmutableSetMultimap.INSTANCE;
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r1, V r2) {
        Builder r0 = builder();
        r0.put(r1, r2);
        return r0.build();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r1, V r2, K r3, V r4) {
        Builder r0 = builder();
        r0.put(r1, r2);
        r0.put(r3, r4);
        return r0.build();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6) {
        Builder r0 = builder();
        r0.put(r1, r2);
        r0.put(r3, r4);
        r0.put(r5, r6);
        return r0.build();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6, K r7, V r8) {
        Builder r0 = builder();
        r0.put(r1, r2);
        r0.put(r3, r4);
        r0.put(r5, r6);
        r0.put(r7, r8);
        return r0.build();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10) {
        Builder r0 = builder();
        r0.put(r1, r2);
        r0.put(r3, r4);
        r0.put(r5, r6);
        r0.put(r7, r8);
        r0.put(r9, r10);
        return r0.build();
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder();
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> r1) {
        return copyOf(r1, null);
    }

    private static <K, V> ImmutableSetMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> r2, @CheckForNull Comparator<? super V> r3) {
        Preconditions.checkNotNull(r2);
        if (r2.isEmpty() == false) goto L8;
        if (r3 != null) goto L8;
        return of();
    L8:
        if ((r2 instanceof ImmutableSetMultimap) == false) goto L13;
        ImmutableSetMultimap<K, V> r0 = (ImmutableSetMultimap) r2;
        if (r0.isPartialView() == true) goto L13;
        return r0;
    L13:
        return fromMapEntries(r2.asMap().entrySet(), r3);
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r1) {
        return new Builder().putAll(r1).build();
    }

    static <K, V> ImmutableSetMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> r5, @CheckForNull Comparator<? super V> r6) {
        if (r5.isEmpty() == true) goto L5;
        ImmutableMap.Builder r0 = new ImmutableMap.Builder(r5.size());
        Iterator<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> r7 = r5.iterator();
        int r1 = 0;
    L8:
        if (r7.hasNext() == false) goto L13;
        Map.Entry<? extends K, ? extends Collection<? extends V>> r2 = r7.next();
        K r3 = r2.getKey();
        ImmutableSet r4 = valueSet(r6, r2.getValue());
        if (r4.isEmpty() == true) goto L8;
        r0.put(r3, r4);
        r1 = r1 + r4.size();
        goto L8
    L13:
        return new ImmutableSetMultimap(r0.build(), r1, r6);
    L5:
        return of();
    }

    ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> r1, int r2, @CheckForNull Comparator<? super V> r3) {
        super(r1, r2);
        this.emptySet = emptySet(r3);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public ImmutableSet<V> get(K r2) {
        return (ImmutableSet) MoreObjects.firstNonNull((ImmutableSet) this.map.get(r2), this.emptySet);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableSetMultimap<V, K> inverse() {
        ImmutableSetMultimap<V, K> r0 = this.inverse;
        if (r0 != null) goto L6;
        ImmutableSetMultimap<V, K> r1 = invert();
        this.inverse = r1;
        return r1;
    L6:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableSetMultimap<V, K> invert() {
        Builder r0 = builder();
        UnmodifiableIterator r1 = entries().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) r1.next();
        r0.put(r2.getValue(), r2.getKey());
        goto L4
    L6:
        ImmutableSetMultimap<V, K> r3 = r0.build();
        r3.inverse = this;
        return r3;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @Deprecated
    public final ImmutableSet<V> removeAll(@CheckForNull Object r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @Deprecated
    public final ImmutableSet<V> replaceValues(K r1, Iterable<? extends V> r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public ImmutableSet<Map.Entry<K, V>> entries() {
        ImmutableSet<Map.Entry<K, V>> r0 = this.entries;
        if (r0 != null) goto L6;
        EntrySet r1 = new EntrySet(this);
        this.entries = r1;
        return r1;
    L6:
        return r0;
    }

    private static <V> ImmutableSet<V> valueSet(@CheckForNull Comparator<? super V> r0, Collection<? extends V> r1) {
        if (r0 != null) goto L5;
        return ImmutableSet.copyOf(r1);
    L5:
        return ImmutableSortedSet.copyOf(r0, r1);
    }

    private static <V> ImmutableSet<V> emptySet(@CheckForNull Comparator<? super V> r0) {
        if (r0 != null) goto L5;
        return ImmutableSet.of();
    L5:
        return ImmutableSortedSet.emptySet(r0);
    }

    private static <V> ImmutableSet.Builder<V> valuesBuilder(@CheckForNull Comparator<? super V> r1) {
        if (r1 != null) goto L5;
        return new ImmutableSet.Builder();
    L5:
        return new ImmutableSortedSet.Builder(r1);
    }

    private void writeObject(ObjectOutputStream r2) throws IOException {
        r2.defaultWriteObject();
        r2.writeObject(valueComparator());
        Serialization.writeMultimap(this, r2);
    }

    @CheckForNull
    Comparator<? super V> valueComparator() {
        ImmutableSet<V> r1 = this.emptySet;
        if ((r1 instanceof ImmutableSortedSet) == true) goto L7;
        return null;
    L7:
        return ((ImmutableSortedSet) r1).comparator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream r12) throws IOException, ClassNotFoundException {
        r12.defaultReadObject();
        Comparator r0 = (Comparator) r12.readObject();
        int r1 = r12.readInt();
        if (r1 < 0) goto L25;
        ImmutableMap.Builder r2 = ImmutableMap.builder();
        int r4 = 0;
        int r5 = 0;
    L5:
        if (r4 >= r1) goto L26;
        Object r6 = r12.readObject();
        int r7 = r12.readInt();
        if (r7 <= 0) goto L17;
        ImmutableSet.Builder r8 = valuesBuilder(r0);
        int r9 = 0;
    L9:
        if (r9 >= r7) goto L11;
        r8.add(r12.readObject());
        r9 = r9 + 1;
        goto L9
    L11:
        ImmutableSet r10 = r8.build();
        if (r10.size() != r7) goto L14;
        r2.put(r6, r10);
        r5 = r5 + r7;
        r4 = r4 + 1;
        goto L5
    L14:
        String r13 = String.valueOf(r6);
        throw new InvalidObjectException(new StringBuilder(String.valueOf(r13).length() + 40).append("Duplicate key-value pairs exist for key ").append(r13).toString());
    L17:
        throw new InvalidObjectException(new StringBuilder(31).append("Invalid value count ").append(r7).toString());
    L26:
        ImmutableMultimap.FieldSettersHolder.MAP_FIELD_SETTER.set(this, r2.build());
        ImmutableMultimap.FieldSettersHolder.SIZE_FIELD_SETTER.set(this, r5);
        SetFieldSettersHolder.EMPTY_SET_FIELD_SETTER.set(this, emptySet(r0));
        return;
    L21:
        e = move-exception;
        throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
    L25:
        throw new InvalidObjectException(new StringBuilder(29).append("Invalid key count ").append(r1).toString());
    }
}
