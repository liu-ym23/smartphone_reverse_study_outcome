package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Stream;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Multimaps {

    static final class AsMap<K, V> extends Maps.ViewCachingAbstractMap<K, Collection<V>> {
        private final Multimap<K, V> multimap;

        class EntrySet extends Maps.EntrySet<K, Collection<V>> {
            final /* synthetic */ AsMap this$0;

            EntrySet(AsMap r1) {
                this.this$0 = r1;
            }

            @Override // com.google.common.collect.Maps.EntrySet
            Map<K, Collection<V>> map() {
                return this.this$0;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return Maps.asMapEntryIterator(AsMap.access$200(this.this$0).keySet(), new AnonymousClass1(this));
            }

            @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object r2) {
                if (contains(r2) == true) goto L6;
                return false;
            L6:
                Map.Entry r3 = (Map.Entry) Objects.requireNonNull((Map.Entry) r2);
                this.this$0.removeValuesForKey(r3.getKey());
                return true;
            }
        }

        static /* synthetic */ Multimap access$200(AsMap r0) {
            return r0.multimap;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public /* bridge */ /* synthetic */ Object get(@CheckForNull Object r1) {
            return get(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public /* bridge */ /* synthetic */ Object remove(@CheckForNull Object r1) {
            return remove(r1);
        }

        AsMap(Multimap<K, V> r1) {
            this.multimap = (Multimap) Preconditions.checkNotNull(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.multimap.keySet().size();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        protected Set<Map.Entry<K, Collection<V>>> createEntrySet() {
            return new EntrySet(this);
        }

        void removeValuesForKey(@CheckForNull Object r1) {
            this.multimap.keySet().remove(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public Collection<V> get(@CheckForNull Object r2) {
            if (containsKey(r2) == true) goto L7;
            return null;
        L7:
            return this.multimap.get(r2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public Collection<V> remove(@CheckForNull Object r2) {
            if (containsKey(r2) == true) goto L7;
            return null;
        L7:
            return this.multimap.removeAll(r2);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.multimap.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.multimap.isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object r1) {
            return this.multimap.containsKey(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.multimap.clear();
        }
    }

    private static class CustomListMultimap<K, V> extends AbstractListMultimap<K, V> {
        private static final long serialVersionUID = 0;
        transient Supplier<? extends List<V>> factory;

        @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap
        protected /* bridge */ /* synthetic */ Collection createCollection() {
            return createCollection();
        }

        CustomListMultimap(Map<K, Collection<V>> r1, Supplier<? extends List<V>> r2) {
            super(r1);
            this.factory = (Supplier) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap
        protected List<V> createCollection() {
            return this.factory.get();
        }

        private void writeObject(ObjectOutputStream r2) throws IOException {
            r2.defaultWriteObject();
            r2.writeObject(this.factory);
            r2.writeObject(backingMap());
        }

        private void readObject(ObjectInputStream r2) throws IOException, ClassNotFoundException {
            r2.defaultReadObject();
            this.factory = (Supplier) r2.readObject();
            setMap((Map) r2.readObject());
        }
    }

    private static class CustomMultimap<K, V> extends AbstractMapBasedMultimap<K, V> {
        private static final long serialVersionUID = 0;
        transient Supplier<? extends Collection<V>> factory;

        CustomMultimap(Map<K, Collection<V>> r1, Supplier<? extends Collection<V>> r2) {
            super(r1);
            this.factory = (Supplier) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        protected Collection<V> createCollection() {
            return this.factory.get();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> r1) {
            if ((r1 instanceof NavigableSet) == false) goto L7;
            return Sets.unmodifiableNavigableSet((NavigableSet) r1);
        L7:
            if ((r1 instanceof SortedSet) == false) goto L11;
            return Collections.unmodifiableSortedSet((SortedSet) r1);
        L11:
            if ((r1 instanceof Set) == false) goto L15;
            return Collections.unmodifiableSet((Set) r1);
        L15:
            if ((r1 instanceof List) == false) goto L19;
            return Collections.unmodifiableList((List) r1);
        L19:
            return Collections.unmodifiableCollection(r1);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        Collection<V> wrapCollection(@ParametricNullness K r3, Collection<V> r4) {
            if ((r4 instanceof List) == false) goto L7;
            return wrapList(r3, (List) r4, null);
        L7:
            if ((r4 instanceof NavigableSet) == false) goto L11;
            return new AbstractMapBasedMultimap.WrappedNavigableSet(this, r3, (NavigableSet) r4, null);
        L11:
            if ((r4 instanceof SortedSet) == false) goto L15;
            return new AbstractMapBasedMultimap.WrappedSortedSet(this, r3, (SortedSet) r4, null);
        L15:
            if ((r4 instanceof Set) == false) goto L19;
            return new AbstractMapBasedMultimap.WrappedSet(this, r3, (Set) r4);
        L19:
            return new AbstractMapBasedMultimap.WrappedCollection(this, r3, r4, null);
        }

        private void writeObject(ObjectOutputStream r2) throws IOException {
            r2.defaultWriteObject();
            r2.writeObject(this.factory);
            r2.writeObject(backingMap());
        }

        private void readObject(ObjectInputStream r2) throws IOException, ClassNotFoundException {
            r2.defaultReadObject();
            this.factory = (Supplier) r2.readObject();
            setMap((Map) r2.readObject());
        }
    }

    private static class CustomSetMultimap<K, V> extends AbstractSetMultimap<K, V> {
        private static final long serialVersionUID = 0;
        transient Supplier<? extends Set<V>> factory;

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        protected /* bridge */ /* synthetic */ Collection createCollection() {
            return createCollection();
        }

        CustomSetMultimap(Map<K, Collection<V>> r1, Supplier<? extends Set<V>> r2) {
            super(r1);
            this.factory = (Supplier) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        protected Set<V> createCollection() {
            return this.factory.get();
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> r1) {
            if ((r1 instanceof NavigableSet) == false) goto L7;
            return Sets.unmodifiableNavigableSet((NavigableSet) r1);
        L7:
            if ((r1 instanceof SortedSet) == false) goto L11;
            return Collections.unmodifiableSortedSet((SortedSet) r1);
        L11:
            return Collections.unmodifiableSet((Set) r1);
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        Collection<V> wrapCollection(@ParametricNullness K r3, Collection<V> r4) {
            if ((r4 instanceof NavigableSet) == false) goto L7;
            return new AbstractMapBasedMultimap.WrappedNavigableSet(this, r3, (NavigableSet) r4, null);
        L7:
            if ((r4 instanceof SortedSet) == false) goto L11;
            return new AbstractMapBasedMultimap.WrappedSortedSet(this, r3, (SortedSet) r4, null);
        L11:
            return new AbstractMapBasedMultimap.WrappedSet(this, r3, (Set) r4);
        }

        private void writeObject(ObjectOutputStream r2) throws IOException {
            r2.defaultWriteObject();
            r2.writeObject(this.factory);
            r2.writeObject(backingMap());
        }

        private void readObject(ObjectInputStream r2) throws IOException, ClassNotFoundException {
            r2.defaultReadObject();
            this.factory = (Supplier) r2.readObject();
            setMap((Map) r2.readObject());
        }
    }

    private static class CustomSortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V> {
        private static final long serialVersionUID = 0;
        transient Supplier<? extends SortedSet<V>> factory;

        @CheckForNull
        transient Comparator<? super V> valueComparator;

        @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        protected /* bridge */ /* synthetic */ Collection createCollection() {
            return createCollection();
        }

        @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        protected /* bridge */ /* synthetic */ Set createCollection() {
            return createCollection();
        }

        CustomSortedSetMultimap(Map<K, Collection<V>> r1, Supplier<? extends SortedSet<V>> r2) {
            super(r1);
            this.factory = (Supplier) Preconditions.checkNotNull(r2);
            this.valueComparator = r2.get().comparator();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        protected SortedSet<V> createCollection() {
            return this.factory.get();
        }

        @Override // com.google.common.collect.SortedSetMultimap
        @CheckForNull
        public Comparator<? super V> valueComparator() {
            return this.valueComparator;
        }

        private void writeObject(ObjectOutputStream r2) throws IOException {
            r2.defaultWriteObject();
            r2.writeObject(this.factory);
            r2.writeObject(backingMap());
        }

        private void readObject(ObjectInputStream r2) throws IOException, ClassNotFoundException {
            r2.defaultReadObject();
            Supplier<? extends SortedSet<V>> r0 = (Supplier) r2.readObject();
            this.factory = r0;
            this.valueComparator = r0.get().comparator();
            setMap((Map) r2.readObject());
        }
    }

    static abstract class Entries<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        abstract Multimap<K, V> multimap();

        Entries() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return multimap().size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object r2) {
            if ((r2 instanceof Map.Entry) == false) goto L6;
            Map.Entry r3 = (Map.Entry) r2;
            return multimap().containsEntry(r3.getKey(), r3.getValue());
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(@CheckForNull Object r2) {
            if ((r2 instanceof Map.Entry) == false) goto L6;
            Map.Entry r3 = (Map.Entry) r2;
            return multimap().remove(r3.getKey(), r3.getValue());
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            multimap().clear();
        }
    }

    static class Keys<K, V> extends AbstractMultiset<K> {
        final Multimap<K, V> multimap;

        Keys(Multimap<K, V> r1) {
            this.multimap = r1;
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator<Multiset.Entry<K>> entryIterator() {
            final Iterator<Map.Entry<K, Collection<V>>> r1 = this.multimap.asMap().entrySet().iterator();
            return new AnonymousClass1(this, r1);
        }

        @Override // java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        public Spliterator<K> spliterator() {
            return CollectSpliterators.map(this.multimap.entries().spliterator(), new ImmutableMap$$ExternalSyntheticLambda0());
        }

        @Override // java.lang.Iterable, com.google.common.collect.Multiset
        public void forEach(final Consumer<? super K> r2) {
            Preconditions.checkNotNull(r2);
            this.multimap.entries().forEach(new Multimaps$Keys$$ExternalSyntheticLambda0(r2));
        }

        static /* synthetic */ void lambda$forEach$0(Consumer r0, Map.Entry r1) {
            r0.accept(r1.getKey());
        }

        @Override // com.google.common.collect.AbstractMultiset
        int distinctElements() {
            return this.multimap.asMap().size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return this.multimap.size();
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public boolean contains(@CheckForNull Object r1) {
            return this.multimap.containsKey(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        public Iterator<K> iterator() {
            return Maps.keyIterator(this.multimap.entries().iterator());
        }

        @Override // com.google.common.collect.Multiset
        public int count(@CheckForNull Object r1) {
            Collection r0 = (Collection) Maps.safeGet(this.multimap.asMap(), r1);
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.size();
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int remove(@CheckForNull Object r2, int r3) {
            CollectPreconditions.checkNonnegative(r3, "occurrences");
            if (r3 == 0) goto L5;
            Collection r1 = (Collection) Maps.safeGet(this.multimap.asMap(), r2);
            int r4 = 0;
            if (r1 != null) goto L9;
            return 0;
        L9:
            int r0 = r1.size();
            if (r3 < r0) goto L12;
            r1.clear();
        L15:
            return r0;
        L12:
            Iterator r5 = r1.iterator();
        L13:
            if (r4 >= r3) goto L15;
            r5.next();
            r5.remove();
            r4 = r4 + 1;
            goto L13
        L5:
            return count(r2);
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.multimap.clear();
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public Set<K> elementSet() {
            return this.multimap.keySet();
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator<K> elementIterator() {
            throw new AssertionError("should never be called");
        }
    }

    private static class MapMultimap<K, V> extends AbstractMultimap<K, V> implements SetMultimap<K, V>, Serializable {
        private static final long serialVersionUID = 7845222491160860175L;
        final Map<K, V> map;

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection entries() {
            return entries();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Collection get(@ParametricNullness Object r1) {
            return get(r1);
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Collection removeAll(@CheckForNull Object r1) {
            return removeAll(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Collection replaceValues(@ParametricNullness Object r1, Iterable r2) {
            return replaceValues(r1, r2);
        }

        MapMultimap(Map<K, V> r1) {
            this.map = (Map) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            return this.map.size();
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(@CheckForNull Object r1) {
            return this.map.containsKey(r1);
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean containsValue(@CheckForNull Object r1) {
            return this.map.containsValue(r1);
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean containsEntry(@CheckForNull Object r1, @CheckForNull Object r2) {
            return this.map.entrySet().contains(Maps.immutableEntry(r1, r2));
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set<V> get(@ParametricNullness final K r2) {
            return new AnonymousClass1(this, r2);
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean put(@ParametricNullness K r1, @ParametricNullness V r2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean putAll(@ParametricNullness K r1, Iterable<? extends V> r2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean putAll(Multimap<? extends K, ? extends V> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set<V> replaceValues(@ParametricNullness K r1, Iterable<? extends V> r2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean remove(@CheckForNull Object r1, @CheckForNull Object r2) {
            return this.map.entrySet().remove(Maps.immutableEntry(r1, r2));
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set<V> removeAll(@CheckForNull Object r3) {
            HashSet r0 = new HashSet(2);
            if (this.map.containsKey(r3) == true) goto L5;
            return r0;
        L5:
            r0.add(this.map.remove(r3));
            return r0;
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            this.map.clear();
        }

        @Override // com.google.common.collect.AbstractMultimap
        Set<K> createKeySet() {
            return this.map.keySet();
        }

        @Override // com.google.common.collect.AbstractMultimap
        Collection<V> createValues() {
            return this.map.values();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public Set<Map.Entry<K, V>> entries() {
            return this.map.entrySet();
        }

        @Override // com.google.common.collect.AbstractMultimap
        Collection<Map.Entry<K, V>> createEntries() {
            throw new AssertionError("unreachable");
        }

        @Override // com.google.common.collect.AbstractMultimap
        Multiset<K> createKeys() {
            return new Keys(this);
        }

        @Override // com.google.common.collect.AbstractMultimap
        Iterator<Map.Entry<K, V>> entryIterator() {
            return this.map.entrySet().iterator();
        }

        @Override // com.google.common.collect.AbstractMultimap
        Map<K, Collection<V>> createAsMap() {
            return new AsMap(this);
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public int hashCode() {
            return this.map.hashCode();
        }
    }

    private static final class TransformedEntriesListMultimap<K, V1, V2> extends TransformedEntriesMultimap<K, V1, V2> implements ListMultimap<K, V2> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Collection get(@ParametricNullness Object r1) {
            return get(r1);
        }

        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Collection removeAll(@CheckForNull Object r1) {
            return removeAll(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Collection replaceValues(@ParametricNullness Object r1, Iterable r2) {
            return replaceValues(r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap
        /* bridge */ /* synthetic */ Collection transform(@ParametricNullness Object r1, Collection r2) {
            return transform(r1, r2);
        }

        TransformedEntriesListMultimap(ListMultimap<K, V1> r1, Maps.EntryTransformer<? super K, ? super V1, V2> r2) {
            super(r1, r2);
        }

        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap
        List<V2> transform(@ParametricNullness K r1, Collection<V1> r2) {
            return Lists.transform((List) r2, Maps.asValueToValueFunction(this.transformer, r1));
        }

        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List<V2> get(@ParametricNullness K r2) {
            return transform(r2, this.fromMultimap.get(r2));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List<V2> removeAll(@CheckForNull Object r2) {
            return transform(r2, this.fromMultimap.removeAll(r2));
        }

        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List<V2> replaceValues(@ParametricNullness K r1, Iterable<? extends V2> r2) {
            throw new UnsupportedOperationException();
        }
    }

    private static class TransformedEntriesMultimap<K, V1, V2> extends AbstractMultimap<K, V2> {
        final Multimap<K, V1> fromMultimap;
        final Maps.EntryTransformer<? super K, ? super V1, V2> transformer;

        TransformedEntriesMultimap(Multimap<K, V1> r1, Maps.EntryTransformer<? super K, ? super V1, V2> r2) {
            this.fromMultimap = (Multimap) Preconditions.checkNotNull(r1);
            this.transformer = (Maps.EntryTransformer) Preconditions.checkNotNull(r2);
        }

        Collection<V2> transform(@ParametricNullness K r1, Collection<V1> r2) {
            Function r0 = Maps.asValueToValueFunction(this.transformer, r1);
            if ((r2 instanceof List) == false) goto L7;
            return Lists.transform((List) r2, r0);
        L7:
            return Collections2.transform(r2, r0);
        }

        @Override // com.google.common.collect.AbstractMultimap
        Map<K, Collection<V2>> createAsMap() {
            return Maps.transformEntries(this.fromMultimap.asMap(), new AnonymousClass1(this));
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            this.fromMultimap.clear();
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(@CheckForNull Object r1) {
            return this.fromMultimap.containsKey(r1);
        }

        @Override // com.google.common.collect.AbstractMultimap
        Collection<Map.Entry<K, V2>> createEntries() {
            return new AbstractMultimap.Entries(this);
        }

        @Override // com.google.common.collect.AbstractMultimap
        Iterator<Map.Entry<K, V2>> entryIterator() {
            return Iterators.transform(this.fromMultimap.entries().iterator(), Maps.asEntryToEntryFunction(this.transformer));
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Collection<V2> get(@ParametricNullness K r2) {
            return transform(r2, this.fromMultimap.get(r2));
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean isEmpty() {
            return this.fromMultimap.isEmpty();
        }

        @Override // com.google.common.collect.AbstractMultimap
        Set<K> createKeySet() {
            return this.fromMultimap.keySet();
        }

        @Override // com.google.common.collect.AbstractMultimap
        Multiset<K> createKeys() {
            return this.fromMultimap.keys();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean put(@ParametricNullness K r1, @ParametricNullness V2 r2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean putAll(@ParametricNullness K r1, Iterable<? extends V2> r2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean putAll(Multimap<? extends K, ? extends V2> r1) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean remove(@CheckForNull Object r1, @CheckForNull Object r2) {
            return get(r1).remove(r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Collection<V2> removeAll(@CheckForNull Object r2) {
            return transform(r2, this.fromMultimap.removeAll(r2));
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Collection<V2> replaceValues(@ParametricNullness K r1, Iterable<? extends V2> r2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            return this.fromMultimap.size();
        }

        @Override // com.google.common.collect.AbstractMultimap
        Collection<V2> createValues() {
            return Collections2.transform(this.fromMultimap.entries(), Maps.asEntryToValueFunction(this.transformer));
        }
    }

    private static class UnmodifiableListMultimap<K, V> extends UnmodifiableMultimap<K, V> implements ListMultimap<K, V> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Multimap delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Collection get(@ParametricNullness Object r1) {
            return get(r1);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Collection removeAll(@CheckForNull Object r1) {
            return removeAll(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Collection replaceValues(@ParametricNullness Object r1, Iterable r2) {
            return replaceValues(r1, r2);
        }

        UnmodifiableListMultimap(ListMultimap<K, V> r1) {
            super(r1);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public ListMultimap<K, V> delegate() {
            return (ListMultimap) super.delegate();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List<V> get(@ParametricNullness K r1) {
            return Collections.unmodifiableList(delegate().get(r1));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List<V> removeAll(@CheckForNull Object r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List<V> replaceValues(@ParametricNullness K r1, Iterable<? extends V> r2) {
            throw new UnsupportedOperationException();
        }
    }

    private static class UnmodifiableMultimap<K, V> extends ForwardingMultimap<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final Multimap<K, V> delegate;

        @CheckForNull
        @LazyInit
        transient Collection<Map.Entry<K, V>> entries;

        @CheckForNull
        @LazyInit
        transient Set<K> keySet;

        @CheckForNull
        @LazyInit
        transient Multiset<K> keys;

        @CheckForNull
        @LazyInit
        transient Map<K, Collection<V>> map;

        @CheckForNull
        @LazyInit
        transient Collection<V> values;

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        UnmodifiableMultimap(Multimap<K, V> r1) {
            this.delegate = (Multimap) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        protected Multimap<K, V> delegate() {
            return this.delegate;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> r0 = this.map;
            if (r0 != null) goto L6;
            Map<K, Collection<V>> r1 = Collections.unmodifiableMap(Maps.transformValues(this.delegate.asMap(), new AnonymousClass1(this)));
            this.map = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Collection<Map.Entry<K, V>> entries() {
            Collection<Map.Entry<K, V>> r0 = this.entries;
            if (r0 != null) goto L6;
            Collection<Map.Entry<K, V>> r1 = Multimaps.access$100(this.delegate.entries());
            this.entries = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // com.google.common.collect.Multimap
        public void forEach(BiConsumer<? super K, ? super V> r1) {
            this.delegate.forEach((BiConsumer) Preconditions.checkNotNull(r1));
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Collection<V> get(@ParametricNullness K r1) {
            return Multimaps.access$000(this.delegate.get(r1));
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Multiset<K> keys() {
            Multiset<K> r0 = this.keys;
            if (r0 != null) goto L6;
            Multiset<K> r1 = Multisets.unmodifiableMultiset(this.delegate.keys());
            this.keys = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Set<K> keySet() {
            Set<K> r0 = this.keySet;
            if (r0 != null) goto L6;
            Set<K> r1 = Collections.unmodifiableSet(this.delegate.keySet());
            this.keySet = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean put(@ParametricNullness K r1, @ParametricNullness V r2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean putAll(@ParametricNullness K r1, Iterable<? extends V> r2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean putAll(Multimap<? extends K, ? extends V> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean remove(@CheckForNull Object r1, @CheckForNull Object r2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Collection<V> removeAll(@CheckForNull Object r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Collection<V> replaceValues(@ParametricNullness K r1, Iterable<? extends V> r2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Collection<V> values() {
            Collection<V> r0 = this.values;
            if (r0 != null) goto L6;
            Collection<V> r1 = Collections.unmodifiableCollection(this.delegate.values());
            this.values = r1;
            return r1;
        L6:
            return r0;
        }
    }

    private static class UnmodifiableSetMultimap<K, V> extends UnmodifiableMultimap<K, V> implements SetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Multimap delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection entries() {
            return entries();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Collection get(@ParametricNullness Object r1) {
            return get(r1);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Collection removeAll(@CheckForNull Object r1) {
            return removeAll(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Collection replaceValues(@ParametricNullness Object r1, Iterable r2) {
            return replaceValues(r1, r2);
        }

        UnmodifiableSetMultimap(SetMultimap<K, V> r1) {
            super(r1);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public SetMultimap<K, V> delegate() {
            return (SetMultimap) super.delegate();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set<V> get(@ParametricNullness K r1) {
            return Collections.unmodifiableSet(delegate().get(r1));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Set<Map.Entry<K, V>> entries() {
            return Maps.unmodifiableEntrySet(delegate().entries());
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set<V> removeAll(@CheckForNull Object r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set<V> replaceValues(@ParametricNullness K r1, Iterable<? extends V> r2) {
            throw new UnsupportedOperationException();
        }
    }

    private static class UnmodifiableSortedSetMultimap<K, V> extends UnmodifiableSetMultimap<K, V> implements SortedSetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Multimap delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ SetMultimap delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Collection get(@ParametricNullness Object r1) {
            return get(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Set get(@ParametricNullness Object r1) {
            return get(r1);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Collection removeAll(@CheckForNull Object r1) {
            return removeAll(r1);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Set removeAll(@CheckForNull Object r1) {
            return removeAll(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Collection replaceValues(@ParametricNullness Object r1, Iterable r2) {
            return replaceValues(r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Set replaceValues(@ParametricNullness Object r1, Iterable r2) {
            return replaceValues(r1, r2);
        }

        UnmodifiableSortedSetMultimap(SortedSetMultimap<K, V> r1) {
            super(r1);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public SortedSetMultimap<K, V> delegate() {
            return (SortedSetMultimap) super.delegate();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public SortedSet<V> get(@ParametricNullness K r1) {
            return Collections.unmodifiableSortedSet(delegate().get(r1));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public SortedSet<V> removeAll(@CheckForNull Object r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public SortedSet<V> replaceValues(@ParametricNullness K r1, Iterable<? extends V> r2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.SortedSetMultimap
        @CheckForNull
        public Comparator<? super V> valueComparator() {
            return delegate().valueComparator();
        }
    }

    static /* synthetic */ Collection access$000(Collection r0) {
        return unmodifiableValueCollection(r0);
    }

    static /* synthetic */ Collection access$100(Collection r0) {
        return unmodifiableEntries(r0);
    }

    private Multimaps() {
    }

    public static <T, K, V, M extends Multimap<K, V>> Collector<T, ?, M> toMultimap(java.util.function.Function<? super T, ? extends K> r0, java.util.function.Function<? super T, ? extends V> r1, java.util.function.Supplier<M> r2) {
        return CollectCollectors.toMultimap(r0, r1, r2);
    }

    public static <T, K, V, M extends Multimap<K, V>> Collector<T, ?, M> flatteningToMultimap(java.util.function.Function<? super T, ? extends K> r0, java.util.function.Function<? super T, ? extends Stream<? extends V>> r1, java.util.function.Supplier<M> r2) {
        return CollectCollectors.flatteningToMultimap(r0, r1, r2);
    }

    public static <K, V> Multimap<K, V> newMultimap(Map<K, Collection<V>> r1, Supplier<? extends Collection<V>> r2) {
        return new CustomMultimap(r1, r2);
    }

    public static <K, V> ListMultimap<K, V> newListMultimap(Map<K, Collection<V>> r1, Supplier<? extends List<V>> r2) {
        return new CustomListMultimap(r1, r2);
    }

    public static <K, V> SetMultimap<K, V> newSetMultimap(Map<K, Collection<V>> r1, Supplier<? extends Set<V>> r2) {
        return new CustomSetMultimap(r1, r2);
    }

    public static <K, V> SortedSetMultimap<K, V> newSortedSetMultimap(Map<K, Collection<V>> r1, Supplier<? extends SortedSet<V>> r2) {
        return new CustomSortedSetMultimap(r1, r2);
    }

    public static <K, V, M extends Multimap<K, V>> M invertFrom(Multimap<? extends V, ? extends K> r2, M r3) {
        Preconditions.checkNotNull(r3);
        Iterator<Map.Entry<? extends V, ? extends K>> r4 = r2.entries().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry<? extends V, ? extends K> r0 = r4.next();
        r3.put(r0.getValue(), r0.getKey());
        goto L4
    L6:
        return r3;
    }

    public static <K, V> Multimap<K, V> synchronizedMultimap(Multimap<K, V> r1) {
        return Synchronized.multimap(r1, null);
    }

    public static <K, V> Multimap<K, V> unmodifiableMultimap(Multimap<K, V> r1) {
        if ((r1 instanceof UnmodifiableMultimap) == false) goto L5;
    L9:
        return r1;
    L5:
        if ((r1 instanceof ImmutableMultimap) == true) goto L9;
        return new UnmodifiableMultimap(r1);
    }

    @Deprecated
    public static <K, V> Multimap<K, V> unmodifiableMultimap(ImmutableMultimap<K, V> r0) {
        return (Multimap) Preconditions.checkNotNull(r0);
    }

    public static <K, V> SetMultimap<K, V> synchronizedSetMultimap(SetMultimap<K, V> r1) {
        return Synchronized.setMultimap(r1, null);
    }

    public static <K, V> SetMultimap<K, V> unmodifiableSetMultimap(SetMultimap<K, V> r1) {
        if ((r1 instanceof UnmodifiableSetMultimap) == false) goto L5;
    L9:
        return r1;
    L5:
        if ((r1 instanceof ImmutableSetMultimap) == true) goto L9;
        return new UnmodifiableSetMultimap(r1);
    }

    @Deprecated
    public static <K, V> SetMultimap<K, V> unmodifiableSetMultimap(ImmutableSetMultimap<K, V> r0) {
        return (SetMultimap) Preconditions.checkNotNull(r0);
    }

    public static <K, V> SortedSetMultimap<K, V> synchronizedSortedSetMultimap(SortedSetMultimap<K, V> r1) {
        return Synchronized.sortedSetMultimap(r1, null);
    }

    public static <K, V> SortedSetMultimap<K, V> unmodifiableSortedSetMultimap(SortedSetMultimap<K, V> r1) {
        if ((r1 instanceof UnmodifiableSortedSetMultimap) == false) goto L6;
        return r1;
    L6:
        return new UnmodifiableSortedSetMultimap(r1);
    }

    public static <K, V> ListMultimap<K, V> synchronizedListMultimap(ListMultimap<K, V> r1) {
        return Synchronized.listMultimap(r1, null);
    }

    public static <K, V> ListMultimap<K, V> unmodifiableListMultimap(ListMultimap<K, V> r1) {
        if ((r1 instanceof UnmodifiableListMultimap) == false) goto L5;
    L9:
        return r1;
    L5:
        if ((r1 instanceof ImmutableListMultimap) == true) goto L9;
        return new UnmodifiableListMultimap(r1);
    }

    @Deprecated
    public static <K, V> ListMultimap<K, V> unmodifiableListMultimap(ImmutableListMultimap<K, V> r0) {
        return (ListMultimap) Preconditions.checkNotNull(r0);
    }

    private static <V> Collection<V> unmodifiableValueCollection(Collection<V> r1) {
        if ((r1 instanceof SortedSet) == false) goto L7;
        return Collections.unmodifiableSortedSet((SortedSet) r1);
    L7:
        if ((r1 instanceof Set) == false) goto L11;
        return Collections.unmodifiableSet((Set) r1);
    L11:
        if ((r1 instanceof List) == false) goto L15;
        return Collections.unmodifiableList((List) r1);
    L15:
        return Collections.unmodifiableCollection(r1);
    }

    private static <K, V> Collection<Map.Entry<K, V>> unmodifiableEntries(Collection<Map.Entry<K, V>> r1) {
        if ((r1 instanceof Set) == false) goto L7;
        return Maps.unmodifiableEntrySet((Set) r1);
    L7:
        return new Maps.UnmodifiableEntries(Collections.unmodifiableCollection(r1));
    }

    public static <K, V> Map<K, List<V>> asMap(ListMultimap<K, V> r0) {
        return r0.asMap();
    }

    public static <K, V> Map<K, Set<V>> asMap(SetMultimap<K, V> r0) {
        return r0.asMap();
    }

    public static <K, V> Map<K, SortedSet<V>> asMap(SortedSetMultimap<K, V> r0) {
        return r0.asMap();
    }

    public static <K, V> Map<K, Collection<V>> asMap(Multimap<K, V> r0) {
        return r0.asMap();
    }

    public static <K, V> SetMultimap<K, V> forMap(Map<K, V> r1) {
        return new MapMultimap(r1);
    }

    public static <K, V1, V2> Multimap<K, V2> transformValues(Multimap<K, V1> r0, Function<? super V1, V2> r1) {
        Preconditions.checkNotNull(r1);
        return transformEntries(r0, Maps.asEntryTransformer(r1));
    }

    public static <K, V1, V2> ListMultimap<K, V2> transformValues(ListMultimap<K, V1> r0, Function<? super V1, V2> r1) {
        Preconditions.checkNotNull(r1);
        return transformEntries(r0, Maps.asEntryTransformer(r1));
    }

    public static <K, V1, V2> Multimap<K, V2> transformEntries(Multimap<K, V1> r1, Maps.EntryTransformer<? super K, ? super V1, V2> r2) {
        return new TransformedEntriesMultimap(r1, r2);
    }

    public static <K, V1, V2> ListMultimap<K, V2> transformEntries(ListMultimap<K, V1> r1, Maps.EntryTransformer<? super K, ? super V1, V2> r2) {
        return new TransformedEntriesListMultimap(r1, r2);
    }

    public static <K, V> ImmutableListMultimap<K, V> index(Iterable<V> r0, Function<? super V, K> r1) {
        return index(r0.iterator(), r1);
    }

    public static <K, V> ImmutableListMultimap<K, V> index(Iterator<V> r3, Function<? super V, K> r4) {
        Preconditions.checkNotNull(r4);
        ImmutableListMultimap.Builder r0 = ImmutableListMultimap.builder();
    L4:
        if (r3.hasNext() == false) goto L7;
        V r1 = r3.next();
        Preconditions.checkNotNull(r1, r3);
        r0.put(r4.apply(r1), r1);
        goto L4
    L7:
        return r0.build();
    }

    public static <K, V> Multimap<K, V> filterKeys(Multimap<K, V> r2, Predicate<? super K> r3) {
        if ((r2 instanceof SetMultimap) == false) goto L7;
        return filterKeys((SetMultimap) r2, r3);
    L7:
        if ((r2 instanceof ListMultimap) == false) goto L11;
        return filterKeys((ListMultimap) r2, r3);
    L11:
        if ((r2 instanceof FilteredKeyMultimap) == false) goto L15;
        FilteredKeyMultimap r4 = (FilteredKeyMultimap) r2;
        return new FilteredKeyMultimap(r4.unfiltered, Predicates.and(r4.keyPredicate, r3));
    L15:
        if ((r2 instanceof FilteredMultimap) == false) goto L19;
        return filterFiltered((FilteredMultimap) r2, Maps.keyPredicateOnEntries(r3));
    L19:
        return new FilteredKeyMultimap(r2, r3);
    }

    public static <K, V> SetMultimap<K, V> filterKeys(SetMultimap<K, V> r2, Predicate<? super K> r3) {
        if ((r2 instanceof FilteredKeySetMultimap) == false) goto L7;
        FilteredKeySetMultimap r4 = (FilteredKeySetMultimap) r2;
        return new FilteredKeySetMultimap(r4.unfiltered(), Predicates.and(r4.keyPredicate, r3));
    L7:
        if ((r2 instanceof FilteredSetMultimap) == false) goto L11;
        return filterFiltered((FilteredSetMultimap) r2, Maps.keyPredicateOnEntries(r3));
    L11:
        return new FilteredKeySetMultimap(r2, r3);
    }

    public static <K, V> ListMultimap<K, V> filterKeys(ListMultimap<K, V> r2, Predicate<? super K> r3) {
        if ((r2 instanceof FilteredKeyListMultimap) == false) goto L7;
        FilteredKeyListMultimap r4 = (FilteredKeyListMultimap) r2;
        return new FilteredKeyListMultimap(r4.unfiltered(), Predicates.and(r4.keyPredicate, r3));
    L7:
        return new FilteredKeyListMultimap(r2, r3);
    }

    public static <K, V> Multimap<K, V> filterValues(Multimap<K, V> r0, Predicate<? super V> r1) {
        return filterEntries(r0, Maps.valuePredicateOnEntries(r1));
    }

    public static <K, V> SetMultimap<K, V> filterValues(SetMultimap<K, V> r0, Predicate<? super V> r1) {
        return filterEntries(r0, Maps.valuePredicateOnEntries(r1));
    }

    public static <K, V> Multimap<K, V> filterEntries(Multimap<K, V> r1, Predicate<? super Map.Entry<K, V>> r2) {
        Preconditions.checkNotNull(r2);
        if ((r1 instanceof SetMultimap) == false) goto L7;
        return filterEntries((SetMultimap) r1, r2);
    L7:
        if ((r1 instanceof FilteredMultimap) == false) goto L10;
        return filterFiltered((FilteredMultimap) r1, r2);
    L10:
        return new FilteredEntryMultimap((Multimap) Preconditions.checkNotNull(r1), r2);
    }

    public static <K, V> SetMultimap<K, V> filterEntries(SetMultimap<K, V> r1, Predicate<? super Map.Entry<K, V>> r2) {
        Preconditions.checkNotNull(r2);
        if ((r1 instanceof FilteredSetMultimap) == false) goto L6;
        return filterFiltered((FilteredSetMultimap) r1, r2);
    L6:
        return new FilteredEntrySetMultimap((SetMultimap) Preconditions.checkNotNull(r1), r2);
    }

    private static <K, V> Multimap<K, V> filterFiltered(FilteredMultimap<K, V> r1, Predicate<? super Map.Entry<K, V>> r2) {
        Predicate r3 = Predicates.and(r1.entryPredicate(), r2);
        return new FilteredEntryMultimap(r1.unfiltered(), r3);
    }

    private static <K, V> SetMultimap<K, V> filterFiltered(FilteredSetMultimap<K, V> r1, Predicate<? super Map.Entry<K, V>> r2) {
        Predicate r3 = Predicates.and(r1.entryPredicate(), r2);
        return new FilteredEntrySetMultimap(r1.unfiltered(), r3);
    }

    static boolean equalsImpl(Multimap<?, ?> r1, @CheckForNull Object r2) {
        if (r2 != r1) goto L6;
        return true;
    L6:
        if ((r2 instanceof Multimap) == true) goto L8;
        return false;
    L8:
        return r1.asMap().equals(((Multimap) r2).asMap());
    }
}
