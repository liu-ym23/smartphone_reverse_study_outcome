package com.google.common.collect;

import com.bytedance.apm.constant.PerfConsts;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class ImmutableMultimap<K, V> extends BaseImmutableMultimap<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
    final transient int size;

    @DoNotMock
    public static class Builder<K, V> {
        final Map<K, Collection<V>> builderMap;

        @CheckForNull
        Comparator<? super K> keyComparator;

        @CheckForNull
        Comparator<? super V> valueComparator;

        public Builder() {
            this.builderMap = Platform.preservesInsertionOrderOnPutsMap();
        }

        Collection<V> newMutableValueCollection() {
            return new ArrayList();
        }

        public Builder<K, V> put(K r3, V r4) {
            CollectPreconditions.checkEntryNotNull(r3, r4);
            Collection<V> r0 = this.builderMap.get(r3);
            if (r0 != null) goto L5;
            Map<K, Collection<V>> r1 = this.builderMap;
            Collection<V> r2 = newMutableValueCollection();
            r1.put(r3, r2);
            r0 = r2;
        L5:
            r0.add(r4);
            return this;
        }

        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> r2) {
            return put(r2.getKey(), r2.getValue());
        }

        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> r2) {
            Iterator<? extends Map.Entry<? extends K, ? extends V>> r3 = r2.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            put(r3.next());
            goto L4
        L6:
            return this;
        }

        public Builder<K, V> putAll(K r3, Iterable<? extends V> r4) {
            if (r3 != null) goto L9;
            String r5 = String.valueOf(Iterables.toString(r4));
            if (r5.length() == 0) goto L6;
            String r6 = "null key in entry: null=".concat(r5);
        L8:
            throw new NullPointerException(r6);
        L6:
            r6 = new String("null key in entry: null=");
            goto L8
        L9:
            Collection<V> r0 = this.builderMap.get(r3);
            if (r0 == null) goto L16;
            Iterator<? extends V> r7 = r4.iterator();
        L13:
            if (r7.hasNext() == false) goto L15;
            V r1 = r7.next();
            CollectPreconditions.checkEntryNotNull(r3, r1);
            r0.add(r1);
            goto L13
        L15:
            return this;
        L16:
            Iterator<? extends V> r8 = r4.iterator();
            if (r8.hasNext() == true) goto L19;
            return this;
        L19:
            Collection<V> r2 = newMutableValueCollection();
        L21:
            if (r8.hasNext() == false) goto L23;
            V r9 = r8.next();
            CollectPreconditions.checkEntryNotNull(r3, r9);
            r2.add(r9);
            goto L21
        L23:
            this.builderMap.put(r3, r2);
            return this;
        }

        public Builder<K, V> putAll(K r1, V... r2) {
            return putAll(r1, Arrays.asList(r2));
        }

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

        public Builder<K, V> orderKeysBy(Comparator<? super K> r1) {
            this.keyComparator = (Comparator) Preconditions.checkNotNull(r1);
            return this;
        }

        public Builder<K, V> orderValuesBy(Comparator<? super V> r1) {
            this.valueComparator = (Comparator) Preconditions.checkNotNull(r1);
            return this;
        }

        Builder<K, V> combine(Builder<K, V> r3) {
            Iterator<Map.Entry<K, Collection<V>>> r4 = r3.builderMap.entrySet().iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            Map.Entry<K, Collection<V>> r0 = r4.next();
            putAll(r0.getKey(), r0.getValue());
            goto L4
        L6:
            return this;
        }

        public ImmutableMultimap<K, V> build() {
            Collection r0 = this.builderMap.entrySet();
            Comparator<? super K> r1 = this.keyComparator;
            if (r1 == null) goto L6;
            r0 = Ordering.from(r1).onKeys().immutableSortedCopy(r0);
        L6:
            return ImmutableListMultimap.fromMapEntries(r0, this.valueComparator);
        }
    }

    private static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
        private static final long serialVersionUID = 0;
        final ImmutableMultimap<K, V> multimap;

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        EntryCollection(ImmutableMultimap<K, V> r1) {
            this.multimap = r1;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return this.multimap.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r2) {
            if ((r2 instanceof Map.Entry) == false) goto L6;
            Map.Entry r3 = (Map.Entry) r2;
            return this.multimap.containsEntry(r3.getKey(), r3.getValue());
        L6:
            return false;
        }
    }

    static class FieldSettersHolder {
        static final Serialization.FieldSetter<ImmutableMultimap> MAP_FIELD_SETTER = null;
        static final Serialization.FieldSetter<ImmutableMultimap> SIZE_FIELD_SETTER = null;

        FieldSettersHolder() {
        }

        static {
            MAP_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultimap.class, "map");
            SIZE_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultimap.class, PerfConsts.PERF_DISK_FILE_SIZE);
        }
    }

    class Keys extends ImmutableMultiset<K> {
        final /* synthetic */ ImmutableMultimap this$0;

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
        public /* bridge */ /* synthetic */ Set elementSet() {
            return elementSet();
        }

        Keys(ImmutableMultimap r1) {
            this.this$0 = r1;
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r1) {
            return this.this$0.containsKey(r1);
        }

        @Override // com.google.common.collect.Multiset
        public int count(@CheckForNull Object r1) {
            ImmutableCollection<V> r0 = this.this$0.map.get(r1);
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
        public ImmutableSet<K> elementSet() {
            return this.this$0.keySet();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return this.this$0.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset
        Multiset.Entry<K> getEntry(int r1) {
            Map.Entry<K, ? extends ImmutableCollection<V>> r0 = this.this$0.map.entrySet().asList().get(r1);
            return Multisets.immutableEntry(r0.getKey(), r0.getValue().size());
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return new KeysSerializedForm(this.this$0);
        }
    }

    private static final class KeysSerializedForm implements Serializable {
        final ImmutableMultimap<?, ?> multimap;

        KeysSerializedForm(ImmutableMultimap<?, ?> r1) {
            this.multimap = r1;
        }

        Object readResolve() {
            return this.multimap.keys();
        }
    }

    private static final class Values<K, V> extends ImmutableCollection<V> {
        private static final long serialVersionUID = 0;
        private final transient ImmutableMultimap<K, V> multimap;

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        Values(ImmutableMultimap<K, V> r1) {
            this.multimap = r1;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r1) {
            return this.multimap.containsValue(r1);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public UnmodifiableIterator<V> iterator() {
            return this.multimap.valueIterator();
        }

        @Override // com.google.common.collect.ImmutableCollection
        int copyIntoArray(Object[] r2, int r3) {
            UnmodifiableIterator<? extends ImmutableCollection<V>> r1 = this.multimap.map.values().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            r3 = r1.next().copyIntoArray(r2, r3);
            goto L4
        L6:
            return r3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public abstract ImmutableCollection<V> get(K r1);

    public abstract ImmutableMultimap<V, K> inverse();

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Map asMap() {
        return asMap();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(@CheckForNull Object r1, @CheckForNull Object r2) {
        return super.containsEntry(r1, r2);
    }

    @Override // com.google.common.collect.AbstractMultimap
    /* bridge */ /* synthetic */ Collection createEntries() {
        return createEntries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    /* bridge */ /* synthetic */ Multiset createKeys() {
        return createKeys();
    }

    @Override // com.google.common.collect.AbstractMultimap
    /* bridge */ /* synthetic */ Collection createValues() {
        return createValues();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection entries() {
        return entries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    /* bridge */ /* synthetic */ Iterator entryIterator() {
        return entryIterator();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object r1) {
        return super.equals(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Collection get(Object r1) {
        return get(r1);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Multiset keys() {
        return keys();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @Deprecated
    public /* bridge */ /* synthetic */ Collection removeAll(@CheckForNull Object r1) {
        return removeAll(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @Deprecated
    public /* bridge */ /* synthetic */ Collection replaceValues(Object r1, Iterable r2) {
        return replaceValues(r1, r2);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractMultimap
    /* bridge */ /* synthetic */ Iterator valueIterator() {
        return valueIterator();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public static <K, V> ImmutableMultimap<K, V> of() {
        return ImmutableListMultimap.of();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r0, V r1) {
        return ImmutableListMultimap.of(r0, r1);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r0, V r1, K r2, V r3) {
        return ImmutableListMultimap.of(r0, r1, r2, r3);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r0, V r1, K r2, V r3, K r4, V r5) {
        return ImmutableListMultimap.of(r0, r1, r2, r3, r4, r5);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r0, V r1, K r2, V r3, K r4, V r5, K r6, V r7) {
        return ImmutableListMultimap.of(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r0, V r1, K r2, V r3, K r4, V r5, K r6, V r7, K r8, V r9) {
        return ImmutableListMultimap.of(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder();
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> r2) {
        if ((r2 instanceof ImmutableMultimap) == false) goto L8;
        ImmutableMultimap<K, V> r0 = (ImmutableMultimap) r2;
        if (r0.isPartialView() == true) goto L8;
        return r0;
    L8:
        return ImmutableListMultimap.copyOf(r2);
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r0) {
        return ImmutableListMultimap.copyOf(r0);
    }

    ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> r1, int r2) {
        this.map = r1;
        this.size = r2;
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @Deprecated
    public ImmutableCollection<V> removeAll(@CheckForNull Object r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @Deprecated
    public ImmutableCollection<V> replaceValues(K r1, Iterable<? extends V> r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimap
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @Deprecated
    public final boolean put(K r1, V r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @Deprecated
    public final boolean putAll(K r1, Iterable<? extends V> r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @Deprecated
    public final boolean putAll(Multimap<? extends K, ? extends V> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @Deprecated
    public final boolean remove(@CheckForNull Object r1, @CheckForNull Object r2) {
        throw new UnsupportedOperationException();
    }

    boolean isPartialView() {
        return this.map.isPartialView();
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@CheckForNull Object r1) {
        return this.map.containsKey(r1);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean containsValue(@CheckForNull Object r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (super.containsValue(r1) == false) goto L6;
        return true;
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public ImmutableSet<K> keySet() {
        return this.map.keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap
    Set<K> createKeySet() {
        throw new AssertionError("unreachable");
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public ImmutableMap<K, Collection<V>> asMap() {
        return this.map;
    }

    @Override // com.google.common.collect.AbstractMultimap
    Map<K, Collection<V>> createAsMap() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public ImmutableCollection<Map.Entry<K, V>> entries() {
        return (ImmutableCollection) super.entries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    ImmutableCollection<Map.Entry<K, V>> createEntries() {
        return new EntryCollection(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    UnmodifiableIterator<Map.Entry<K, V>> entryIterator() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Spliterator<Map.Entry<K, V>> entrySpliterator() {
        return CollectSpliterators.flatMap(asMap().entrySet().spliterator(), new ImmutableMultimap$$ExternalSyntheticLambda1(), (this instanceof SetMultimap ? 1 : 0) | 64, size());
    }

    static /* synthetic */ Spliterator lambda$entrySpliterator$1(Map.Entry r2) {
        final Object r0 = r2.getKey();
        return CollectSpliterators.map(((Collection) r2.getValue()).spliterator(), new ImmutableMultimap$$ExternalSyntheticLambda2(r0));
    }

    static /* synthetic */ Map.Entry lambda$entrySpliterator$0(Object r0, Object r1) {
        return Maps.immutableEntry(r0, r1);
    }

    @Override // com.google.common.collect.Multimap
    public void forEach(final BiConsumer<? super K, ? super V> r2) {
        Preconditions.checkNotNull(r2);
        asMap().forEach(new ImmutableMultimap$$ExternalSyntheticLambda0(r2));
    }

    static /* synthetic */ void lambda$forEach$2(BiConsumer r0, Object r1, Object r2) {
        r0.accept(r1, r2);
    }

    static /* synthetic */ void lambda$forEach$3(final BiConsumer r1, final Object r2, Collection r3) {
        r3.forEach(new ImmutableMultimap$$ExternalSyntheticLambda3(r1, r2));
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public ImmutableMultiset<K> keys() {
        return (ImmutableMultiset) super.keys();
    }

    @Override // com.google.common.collect.AbstractMultimap
    ImmutableMultiset<K> createKeys() {
        return new Keys(this);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    @Override // com.google.common.collect.AbstractMultimap
    ImmutableCollection<V> createValues() {
        return new Values(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    UnmodifiableIterator<V> valueIterator() {
        return new AnonymousClass2(this);
    }
}
