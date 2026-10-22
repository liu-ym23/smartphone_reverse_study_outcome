package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractMapBasedMultimap<K, V> extends AbstractMultimap<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    private transient Map<K, Collection<V>> map;
    private transient int totalSize;

    private class AsMap extends Maps.ViewCachingAbstractMap<K, Collection<V>> {
        final transient Map<K, Collection<V>> submap;
        final /* synthetic */ AbstractMapBasedMultimap this$0;

        class AsMapEntries extends Maps.EntrySet<K, Collection<V>> {
            final /* synthetic */ AsMap this$1;

            AsMapEntries(AsMap r1) {
                this.this$1 = r1;
            }

            @Override // com.google.common.collect.Maps.EntrySet
            Map<K, Collection<V>> map() {
                return this.this$1;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new AsMapIterator(this.this$1);
            }

            @Override // java.util.Collection, java.lang.Iterable, java.util.Set
            public Spliterator<Map.Entry<K, Collection<V>>> spliterator() {
                Spliterator<Map.Entry<K, Collection<V>>> r0 = this.this$1.submap.entrySet().spliterator();
                final AsMap r2 = this.this$1;
                return CollectSpliterators.map(r0, new AbstractMapBasedMultimap$AsMap$AsMapEntries$$ExternalSyntheticLambda0(r2));
            }

            @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object r1) {
                return Collections2.safeContains(this.this$1.submap.entrySet(), r1);
            }

            @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object r2) {
                if (contains(r2) == true) goto L6;
                return false;
            L6:
                Map.Entry r3 = (Map.Entry) Objects.requireNonNull((Map.Entry) r2);
                AbstractMapBasedMultimap.access$300(this.this$1.this$0, r3.getKey());
                return true;
            }
        }

        class AsMapIterator implements Iterator<Map.Entry<K, Collection<V>>> {

            @CheckForNull
            Collection<V> collection;
            final Iterator<Map.Entry<K, Collection<V>>> delegateIterator;
            final /* synthetic */ AsMap this$1;

            AsMapIterator(AsMap r1) {
                this.this$1 = r1;
                this.delegateIterator = r1.submap.entrySet().iterator();
            }

            @Override // java.util.Iterator
            public /* bridge */ /* synthetic */ Object next() {
                return next();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.delegateIterator.hasNext();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, Collection<V>> next() {
                Map.Entry<K, Collection<V>> r0 = this.delegateIterator.next();
                this.collection = r0.getValue();
                return this.this$1.wrapEntry(r0);
            }

            @Override // java.util.Iterator
            public void remove() {
                if (this.collection == null) goto L5;
                boolean r0 = true;
            L6:
                Preconditions.checkState(r0, "no calls to next() since the last call to remove()");
                this.delegateIterator.remove();
                AbstractMapBasedMultimap.access$220(this.this$1.this$0, this.collection.size());
                this.collection.clear();
                this.collection = null;
                return;
            L5:
                r0 = false;
                goto L6
            }
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

        AsMap(AbstractMapBasedMultimap r1, Map<K, Collection<V>> r2) {
            this.this$0 = r1;
            this.submap = r2;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        protected Set<Map.Entry<K, Collection<V>>> createEntrySet() {
            return new AsMapEntries(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object r1) {
            return Maps.safeContainsKey(this.submap, r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public Collection<V> get(@CheckForNull Object r2) {
            Collection<V> r0 = (Collection) Maps.safeGet(this.submap, r2);
            if (r0 != null) goto L7;
            return null;
        L7:
            return this.this$0.wrapCollection(r2, r0);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.this$0.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.submap.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public Collection<V> remove(@CheckForNull Object r3) {
            Collection<V> r4 = this.submap.remove(r3);
            if (r4 != null) goto L6;
            return null;
        L6:
            Collection<V> r0 = this.this$0.createCollection();
            r0.addAll(r4);
            AbstractMapBasedMultimap.access$220(this.this$0, r4.size());
            r4.clear();
            return r0;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(@CheckForNull Object r1) {
            if (this != r1) goto L4;
        L7:
            return true;
        L4:
            if (this.submap.equals(r1) == true) goto L7;
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.submap.hashCode();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.submap.toString();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.submap != AbstractMapBasedMultimap.access$000(this.this$0)) goto L5;
            this.this$0.clear();
            return;
        L5:
            Iterators.clear(new AsMapIterator(this));
        }

        Map.Entry<K, Collection<V>> wrapEntry(Map.Entry<K, Collection<V>> r2) {
            K r0 = r2.getKey();
            return Maps.immutableEntry(r0, this.this$0.wrapCollection(r0, r2.getValue()));
        }
    }

    private abstract class Itr<T> implements Iterator<T> {

        @CheckForNull
        Collection<V> collection;

        @CheckForNull
        K key;
        final Iterator<Map.Entry<K, Collection<V>>> keyIterator;
        final /* synthetic */ AbstractMapBasedMultimap this$0;
        Iterator<V> valueIterator;

        abstract T output(@ParametricNullness K r1, @ParametricNullness V r2);

        Itr(AbstractMapBasedMultimap r1) {
            this.this$0 = r1;
            this.keyIterator = AbstractMapBasedMultimap.access$000(r1).entrySet().iterator();
            this.key = null;
            this.collection = null;
            this.valueIterator = Iterators.emptyModifiableIterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.keyIterator.hasNext() == false) goto L5;
        L8:
            return true;
        L5:
            if (this.valueIterator.hasNext() == true) goto L8;
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.valueIterator.hasNext() == true) goto L6;
            Map.Entry<K, Collection<V>> r0 = this.keyIterator.next();
            this.key = r0.getKey();
            Collection<V> r1 = r0.getValue();
            this.collection = r1;
            this.valueIterator = r1.iterator();
        L6:
            return output(NullnessCasts.uncheckedCastNullableTToT(this.key), this.valueIterator.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.valueIterator.remove();
            if (((Collection) Objects.requireNonNull(this.collection)).isEmpty() == false) goto L5;
            this.keyIterator.remove();
        L5:
            AbstractMapBasedMultimap.access$210(this.this$0);
        }
    }

    private class KeySet extends Maps.KeySet<K, Collection<V>> {
        final /* synthetic */ AbstractMapBasedMultimap this$0;

        KeySet(AbstractMapBasedMultimap r1, Map<K, Collection<V>> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            final Iterator<Map.Entry<K, Collection<V>>> r0 = map().entrySet().iterator();
            return new AnonymousClass1(this, r0);
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<K> spliterator() {
            return map().keySet().spliterator();
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object r3) {
            Collection<V> r4 = map().remove(r3);
            if (r4 == null) goto L5;
            int r1 = r4.size();
            r4.clear();
            AbstractMapBasedMultimap.access$220(this.this$0, r1);
        L6:
            if (r1 <= 0) goto L9;
            return true;
        L9:
            return false;
        L5:
            r1 = 0;
            goto L6
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Iterators.clear(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> r1) {
            return map().keySet().containsAll(r1);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(@CheckForNull Object r1) {
            if (this != r1) goto L4;
        L7:
            return true;
        L4:
            if (map().keySet().equals(r1) == true) goto L7;
            return false;
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return map().keySet().hashCode();
        }
    }

    class NavigableAsMap extends AbstractMapBasedMultimap<K, V>.SortedAsMap implements NavigableMap<K, Collection<V>> {
        final /* synthetic */ AbstractMapBasedMultimap this$0;

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, com.google.common.collect.Maps.ViewCachingAbstractMap
        /* bridge */ /* synthetic */ Set createKeySet() {
            return createKeySet();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, com.google.common.collect.Maps.ViewCachingAbstractMap
        /* bridge */ /* synthetic */ SortedSet createKeySet() {
            return createKeySet();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ SortedMap headMap(@ParametricNullness Object r1) {
            return headMap(r1);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, com.google.common.collect.AbstractMapBasedMultimap.AsMap, com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return keySet();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, com.google.common.collect.AbstractMapBasedMultimap.AsMap, com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ SortedSet keySet() {
            return keySet();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap
        /* bridge */ /* synthetic */ SortedMap sortedMap() {
            return sortedMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ SortedMap subMap(@ParametricNullness Object r1, @ParametricNullness Object r2) {
            return subMap(r1, r2);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ SortedMap tailMap(@ParametricNullness Object r1) {
            return tailMap(r1);
        }

        NavigableAsMap(AbstractMapBasedMultimap r1, NavigableMap<K, Collection<V>> r2) {
            this.this$0 = r1;
            super(r1, r2);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap
        NavigableMap<K, Collection<V>> sortedMap() {
            return (NavigableMap) super.sortedMap();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> lowerEntry(@ParametricNullness K r2) {
            Map.Entry<K, Collection<V>> r3 = sortedMap().lowerEntry(r2);
            if (r3 != null) goto L6;
            return null;
        L6:
            return wrapEntry(r3);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K lowerKey(@ParametricNullness K r1) {
            return sortedMap().lowerKey(r1);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> floorEntry(@ParametricNullness K r2) {
            Map.Entry<K, Collection<V>> r3 = sortedMap().floorEntry(r2);
            if (r3 != null) goto L6;
            return null;
        L6:
            return wrapEntry(r3);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K floorKey(@ParametricNullness K r1) {
            return sortedMap().floorKey(r1);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> ceilingEntry(@ParametricNullness K r2) {
            Map.Entry<K, Collection<V>> r3 = sortedMap().ceilingEntry(r2);
            if (r3 != null) goto L6;
            return null;
        L6:
            return wrapEntry(r3);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K ceilingKey(@ParametricNullness K r1) {
            return sortedMap().ceilingKey(r1);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> higherEntry(@ParametricNullness K r2) {
            Map.Entry<K, Collection<V>> r3 = sortedMap().higherEntry(r2);
            if (r3 != null) goto L6;
            return null;
        L6:
            return wrapEntry(r3);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K higherKey(@ParametricNullness K r1) {
            return sortedMap().higherKey(r1);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry<K, Collection<V>> r0 = sortedMap().firstEntry();
            if (r0 != null) goto L6;
            return null;
        L6:
            return wrapEntry(r0);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry<K, Collection<V>> r0 = sortedMap().lastEntry();
            if (r0 != null) goto L6;
            return null;
        L6:
            return wrapEntry(r0);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return pollAsMapEntry(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return pollAsMapEntry(descendingMap().entrySet().iterator());
        }

        @CheckForNull
        Map.Entry<K, Collection<V>> pollAsMapEntry(Iterator<Map.Entry<K, Collection<V>>> r4) {
            if (r4.hasNext() == true) goto L6;
            return null;
        L6:
            Map.Entry<K, Collection<V>> r0 = r4.next();
            Collection<V> r1 = this.this$0.createCollection();
            r1.addAll(r0.getValue());
            r4.remove();
            return Maps.immutableEntry(r0.getKey(), this.this$0.unmodifiableCollectionSubclass(r1));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> descendingMap() {
            return new NavigableAsMap(this.this$0, sortedMap().descendingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, com.google.common.collect.AbstractMapBasedMultimap.AsMap, com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public NavigableSet<K> keySet() {
            return (NavigableSet) super.keySet();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, com.google.common.collect.Maps.ViewCachingAbstractMap
        NavigableSet<K> createKeySet() {
            return new NavigableKeySet(this.this$0, sortedMap());
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return keySet();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(@ParametricNullness K r3, @ParametricNullness K r4) {
            return subMap(r3, true, r4, false);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(@ParametricNullness K r3, boolean r4, @ParametricNullness K r5, boolean r6) {
            return new NavigableAsMap(this.this$0, sortedMap().subMap(r3, r4, r5, r6));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(@ParametricNullness K r2) {
            return headMap(r2, false);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(@ParametricNullness K r3, boolean r4) {
            return new NavigableAsMap(this.this$0, sortedMap().headMap(r3, r4));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(@ParametricNullness K r2) {
            return tailMap(r2, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(@ParametricNullness K r3, boolean r4) {
            return new NavigableAsMap(this.this$0, sortedMap().tailMap(r3, r4));
        }
    }

    class NavigableKeySet extends AbstractMapBasedMultimap<K, V>.SortedKeySet implements NavigableSet<K> {
        final /* synthetic */ AbstractMapBasedMultimap this$0;

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public /* bridge */ /* synthetic */ SortedSet headSet(@ParametricNullness Object r1) {
            return headSet(r1);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet
        /* bridge */ /* synthetic */ SortedMap sortedMap() {
            return sortedMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public /* bridge */ /* synthetic */ SortedSet subSet(@ParametricNullness Object r1, @ParametricNullness Object r2) {
            return subSet(r1, r2);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public /* bridge */ /* synthetic */ SortedSet tailSet(@ParametricNullness Object r1) {
            return tailSet(r1);
        }

        NavigableKeySet(AbstractMapBasedMultimap r1, NavigableMap<K, Collection<V>> r2) {
            this.this$0 = r1;
            super(r1, r2);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet
        NavigableMap<K, Collection<V>> sortedMap() {
            return (NavigableMap) super.sortedMap();
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K lower(@ParametricNullness K r1) {
            return sortedMap().lowerKey(r1);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K floor(@ParametricNullness K r1) {
            return sortedMap().floorKey(r1);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K ceiling(@ParametricNullness K r1) {
            return sortedMap().ceilingKey(r1);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K higher(@ParametricNullness K r1) {
            return sortedMap().higherKey(r1);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K pollFirst() {
            return (K) Iterators.pollNext(iterator());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K pollLast() {
            return (K) Iterators.pollNext(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return new NavigableKeySet(this.this$0, sortedMap().descendingMap());
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public NavigableSet<K> headSet(@ParametricNullness K r2) {
            return headSet(r2, false);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(@ParametricNullness K r3, boolean r4) {
            return new NavigableKeySet(this.this$0, sortedMap().headMap(r3, r4));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public NavigableSet<K> subSet(@ParametricNullness K r3, @ParametricNullness K r4) {
            return subSet(r3, true, r4, false);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(@ParametricNullness K r3, boolean r4, @ParametricNullness K r5, boolean r6) {
            return new NavigableKeySet(this.this$0, sortedMap().subMap(r3, r4, r5, r6));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public NavigableSet<K> tailSet(@ParametricNullness K r2) {
            return tailSet(r2, true);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(@ParametricNullness K r3, boolean r4) {
            return new NavigableKeySet(this.this$0, sortedMap().tailMap(r3, r4));
        }
    }

    private class RandomAccessWrappedList extends AbstractMapBasedMultimap<K, V>.WrappedList implements RandomAccess {
        RandomAccessWrappedList(@ParametricNullness AbstractMapBasedMultimap r1, K r2, @CheckForNull List<V> r3, AbstractMapBasedMultimap<K, V>.WrappedCollection r4) {
            super(r1, r2, r3, r4);
        }
    }

    private class SortedAsMap extends AbstractMapBasedMultimap<K, V>.AsMap implements SortedMap<K, Collection<V>> {

        @CheckForNull
        SortedSet<K> sortedKeySet;
        final /* synthetic */ AbstractMapBasedMultimap this$0;

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        /* bridge */ /* synthetic */ Set createKeySet() {
            return createKeySet();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.AsMap, com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return keySet();
        }

        SortedAsMap(AbstractMapBasedMultimap r1, SortedMap<K, Collection<V>> r2) {
            this.this$0 = r1;
            super(r1, r2);
        }

        SortedMap<K, Collection<V>> sortedMap() {
            return (SortedMap) this.submap;
        }

        @Override // java.util.SortedMap
        @CheckForNull
        public Comparator<? super K> comparator() {
            return sortedMap().comparator();
        }

        @Override // java.util.SortedMap
        @ParametricNullness
        public K firstKey() {
            return sortedMap().firstKey();
        }

        @Override // java.util.SortedMap
        @ParametricNullness
        public K lastKey() {
            return sortedMap().lastKey();
        }

        public SortedMap<K, Collection<V>> headMap(@ParametricNullness K r3) {
            return new SortedAsMap(this.this$0, sortedMap().headMap(r3));
        }

        public SortedMap<K, Collection<V>> subMap(@ParametricNullness K r3, @ParametricNullness K r4) {
            return new SortedAsMap(this.this$0, sortedMap().subMap(r3, r4));
        }

        public SortedMap<K, Collection<V>> tailMap(@ParametricNullness K r3) {
            return new SortedAsMap(this.this$0, sortedMap().tailMap(r3));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.AsMap, com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public SortedSet<K> keySet() {
            SortedSet<K> r0 = this.sortedKeySet;
            if (r0 != null) goto L6;
            SortedSet<K> r1 = createKeySet();
            this.sortedKeySet = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        SortedSet<K> createKeySet() {
            return new SortedKeySet(this.this$0, sortedMap());
        }
    }

    private class SortedKeySet extends AbstractMapBasedMultimap<K, V>.KeySet implements SortedSet<K> {
        final /* synthetic */ AbstractMapBasedMultimap this$0;

        SortedKeySet(AbstractMapBasedMultimap r1, SortedMap<K, Collection<V>> r2) {
            this.this$0 = r1;
            super(r1, r2);
        }

        SortedMap<K, Collection<V>> sortedMap() {
            return (SortedMap) super.map();
        }

        @Override // java.util.SortedSet
        @CheckForNull
        public Comparator<? super K> comparator() {
            return sortedMap().comparator();
        }

        @Override // java.util.SortedSet
        @ParametricNullness
        public K first() {
            return sortedMap().firstKey();
        }

        public SortedSet<K> headSet(@ParametricNullness K r3) {
            return new SortedKeySet(this.this$0, sortedMap().headMap(r3));
        }

        @Override // java.util.SortedSet
        @ParametricNullness
        public K last() {
            return sortedMap().lastKey();
        }

        public SortedSet<K> subSet(@ParametricNullness K r3, @ParametricNullness K r4) {
            return new SortedKeySet(this.this$0, sortedMap().subMap(r3, r4));
        }

        public SortedSet<K> tailSet(@ParametricNullness K r3) {
            return new SortedKeySet(this.this$0, sortedMap().tailMap(r3));
        }
    }

    class WrappedCollection extends AbstractCollection<V> {

        @CheckForNull
        final AbstractMapBasedMultimap<K, V>.WrappedCollection ancestor;

        @CheckForNull
        final Collection<V> ancestorDelegate;
        Collection<V> delegate;

        @ParametricNullness
        final K key;
        final /* synthetic */ AbstractMapBasedMultimap this$0;

        class WrappedIterator implements Iterator<V> {
            final Iterator<V> delegateIterator;
            final Collection<V> originalDelegate;
            final /* synthetic */ WrappedCollection this$1;

            WrappedIterator(WrappedCollection r2) {
                this.this$1 = r2;
                this.originalDelegate = r2.delegate;
                this.delegateIterator = AbstractMapBasedMultimap.access$100(r2.delegate);
            }

            WrappedIterator(WrappedCollection r1, Iterator<V> r2) {
                this.this$1 = r1;
                this.originalDelegate = r1.delegate;
                this.delegateIterator = r2;
            }

            void validateIterator() {
                this.this$1.refreshIfEmpty();
                if (this.this$1.delegate != this.originalDelegate) goto L6;
                return;
            L6:
                throw new ConcurrentModificationException();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                validateIterator();
                return this.delegateIterator.hasNext();
            }

            @Override // java.util.Iterator
            @ParametricNullness
            public V next() {
                validateIterator();
                return this.delegateIterator.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.delegateIterator.remove();
                AbstractMapBasedMultimap.access$210(this.this$1.this$0);
                this.this$1.removeIfEmpty();
            }

            Iterator<V> getDelegateIterator() {
                validateIterator();
                return this.delegateIterator;
            }
        }

        WrappedCollection(@ParametricNullness AbstractMapBasedMultimap r1, K r2, @CheckForNull Collection<V> r3, AbstractMapBasedMultimap<K, V>.WrappedCollection r4) {
            this.this$0 = r1;
            this.key = r2;
            this.delegate = r3;
            this.ancestor = r4;
            if (r4 != null) goto L5;
            Collection<V> r5 = null;
        L6:
            this.ancestorDelegate = r5;
            return;
        L5:
            r5 = r4.getDelegate();
            goto L6
        }

        void refreshIfEmpty() {
            AbstractMapBasedMultimap<K, V>.WrappedCollection r0 = this.ancestor;
            if (r0 == null) goto L10;
            r0.refreshIfEmpty();
            if (this.ancestor.getDelegate() != this.ancestorDelegate) goto L8;
            return;
        L8:
            throw new ConcurrentModificationException();
        L10:
            if (this.delegate.isEmpty() == false) goto L15;
            Collection<V> r1 = (Collection) AbstractMapBasedMultimap.access$000(this.this$0).get(this.key);
            if (r1 == null) goto L16;
            this.delegate = r1;
            return;
        L16:
            return;
        }

        void removeIfEmpty() {
            AbstractMapBasedMultimap<K, V>.WrappedCollection r0 = this.ancestor;
            if (r0 == null) goto L6;
            r0.removeIfEmpty();
            return;
        L6:
            if (this.delegate.isEmpty() == false) goto L10;
            AbstractMapBasedMultimap.access$000(this.this$0).remove(this.key);
            return;
        }

        @ParametricNullness
        K getKey() {
            return this.key;
        }

        void addToMap() {
            AbstractMapBasedMultimap<K, V>.WrappedCollection r0 = this.ancestor;
            if (r0 == null) goto L5;
            r0.addToMap();
            return;
        L5:
            AbstractMapBasedMultimap.access$000(this.this$0).put(this.key, this.delegate);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            refreshIfEmpty();
            return this.delegate.size();
        }

        @Override // java.util.Collection
        public boolean equals(@CheckForNull Object r1) {
            if (r1 != this) goto L5;
            return true;
        L5:
            refreshIfEmpty();
            return this.delegate.equals(r1);
        }

        @Override // java.util.Collection
        public int hashCode() {
            refreshIfEmpty();
            return this.delegate.hashCode();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            refreshIfEmpty();
            return this.delegate.toString();
        }

        Collection<V> getDelegate() {
            return this.delegate;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            refreshIfEmpty();
            return new WrappedIterator(this);
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<V> spliterator() {
            refreshIfEmpty();
            return this.delegate.spliterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(@ParametricNullness V r3) {
            refreshIfEmpty();
            boolean r0 = this.delegate.isEmpty();
            boolean r4 = this.delegate.add(r3);
            if (r4 == false) goto L7;
            AbstractMapBasedMultimap.access$208(this.this$0);
            if (r0 == false) goto L7;
            addToMap();
        L7:
            return r4;
        }

        @CheckForNull
        AbstractMapBasedMultimap<K, V>.WrappedCollection getAncestor() {
            return this.ancestor;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> r4) {
            if (r4.isEmpty() == false) goto L6;
            return false;
        L6:
            int r0 = size();
            boolean r5 = this.delegate.addAll(r4);
            if (r5 == false) goto L11;
            int r1 = this.delegate.size();
            AbstractMapBasedMultimap.access$212(this.this$0, r1 - r0);
            if (r0 != 0) goto L11;
            addToMap();
        L11:
            return r5;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object r1) {
            refreshIfEmpty();
            return this.delegate.contains(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> r1) {
            refreshIfEmpty();
            return this.delegate.containsAll(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int r0 = size();
            if (r0 != 0) goto L5;
            return;
        L5:
            this.delegate.clear();
            AbstractMapBasedMultimap.access$220(this.this$0, r0);
            removeIfEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(@CheckForNull Object r2) {
            refreshIfEmpty();
            boolean r3 = this.delegate.remove(r2);
            if (r3 == false) goto L5;
            AbstractMapBasedMultimap.access$210(this.this$0);
            removeIfEmpty();
        L5:
            return r3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> r4) {
            if (r4.isEmpty() == false) goto L6;
            return false;
        L6:
            int r0 = size();
            boolean r5 = this.delegate.removeAll(r4);
            if (r5 == false) goto L9;
            int r1 = this.delegate.size();
            AbstractMapBasedMultimap.access$212(this.this$0, r1 - r0);
            removeIfEmpty();
        L9:
            return r5;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> r4) {
            Preconditions.checkNotNull(r4);
            int r0 = size();
            boolean r5 = this.delegate.retainAll(r4);
            if (r5 == false) goto L5;
            int r1 = this.delegate.size();
            AbstractMapBasedMultimap.access$212(this.this$0, r1 - r0);
            removeIfEmpty();
        L5:
            return r5;
        }
    }

    class WrappedList extends AbstractMapBasedMultimap<K, V>.WrappedCollection implements List<V> {
        final /* synthetic */ AbstractMapBasedMultimap this$0;

        private class WrappedListIterator extends AbstractMapBasedMultimap<K, V>.WrappedCollection.WrappedIterator implements ListIterator<V> {
            final /* synthetic */ WrappedList this$1;

            WrappedListIterator(WrappedList r1) {
                this.this$1 = r1;
                super(r1);
            }

            public WrappedListIterator(WrappedList r2, int r3) {
                this.this$1 = r2;
                super(r2, r2.getListDelegate().listIterator(r3));
            }

            private ListIterator<V> getDelegateListIterator() {
                return (ListIterator) getDelegateIterator();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return getDelegateListIterator().hasPrevious();
            }

            @Override // java.util.ListIterator
            @ParametricNullness
            public V previous() {
                return getDelegateListIterator().previous();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return getDelegateListIterator().nextIndex();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return getDelegateListIterator().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(@ParametricNullness V r1) {
                getDelegateListIterator().set(r1);
            }

            @Override // java.util.ListIterator
            public void add(@ParametricNullness V r3) {
                boolean r0 = this.this$1.isEmpty();
                getDelegateListIterator().add(r3);
                AbstractMapBasedMultimap.access$208(this.this$1.this$0);
                if (r0 == false) goto L6;
                this.this$1.addToMap();
                return;
            }
        }

        WrappedList(@ParametricNullness AbstractMapBasedMultimap r1, K r2, @CheckForNull List<V> r3, AbstractMapBasedMultimap<K, V>.WrappedCollection r4) {
            this.this$0 = r1;
            super(r1, r2, r3, r4);
        }

        List<V> getListDelegate() {
            return (List) getDelegate();
        }

        @Override // java.util.List
        public boolean addAll(int r3, Collection<? extends V> r4) {
            if (r4.isEmpty() == false) goto L6;
            return false;
        L6:
            int r0 = size();
            boolean r5 = getListDelegate().addAll(r3, r4);
            if (r5 == false) goto L11;
            int r6 = getDelegate().size();
            AbstractMapBasedMultimap.access$212(this.this$0, r6 - r0);
            if (r0 != 0) goto L11;
            addToMap();
        L11:
            return r5;
        }

        @Override // java.util.List
        @ParametricNullness
        public V get(int r1) {
            refreshIfEmpty();
            return getListDelegate().get(r1);
        }

        @Override // java.util.List
        @ParametricNullness
        public V set(int r1, @ParametricNullness V r2) {
            refreshIfEmpty();
            return getListDelegate().set(r1, r2);
        }

        @Override // java.util.List
        public void add(int r3, @ParametricNullness V r4) {
            refreshIfEmpty();
            boolean r0 = getDelegate().isEmpty();
            getListDelegate().add(r3, r4);
            AbstractMapBasedMultimap.access$208(this.this$0);
            if (r0 == false) goto L6;
            addToMap();
            return;
        }

        @Override // java.util.List
        @ParametricNullness
        public V remove(int r2) {
            refreshIfEmpty();
            V r3 = getListDelegate().remove(r2);
            AbstractMapBasedMultimap.access$210(this.this$0);
            removeIfEmpty();
            return r3;
        }

        @Override // java.util.List
        public int indexOf(@CheckForNull Object r1) {
            refreshIfEmpty();
            return getListDelegate().indexOf(r1);
        }

        @Override // java.util.List
        public int lastIndexOf(@CheckForNull Object r1) {
            refreshIfEmpty();
            return getListDelegate().lastIndexOf(r1);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            refreshIfEmpty();
            return new WrappedListIterator(this);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int r2) {
            refreshIfEmpty();
            return new WrappedListIterator(this, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.collect.AbstractMapBasedMultimap] */
        /* JADX WARN: Type inference failed for: r3v1, types: [com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection] */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.util.List
        public List<V> subList(int r4, int r5) {
            refreshIfEmpty();
            ?? r0 = this.this$0;
            Object r1 = getKey();
            List<V> r6 = getListDelegate().subList(r4, r5);
            AbstractMapBasedMultimap<K, V>.WrappedCollection r7 = getAncestor();
            ?? r3 = this;
            if (r7 == null) goto L7;
            r3 = getAncestor();
        L7:
            return r0.wrapList(r1, r6, r3);
        }
    }

    class WrappedNavigableSet extends AbstractMapBasedMultimap<K, V>.WrappedSortedSet implements NavigableSet<V> {
        final /* synthetic */ AbstractMapBasedMultimap this$0;

        @Override // com.google.common.collect.AbstractMapBasedMultimap.WrappedSortedSet
        /* bridge */ /* synthetic */ SortedSet getSortedSetDelegate() {
            return getSortedSetDelegate();
        }

        WrappedNavigableSet(@ParametricNullness AbstractMapBasedMultimap r1, K r2, @CheckForNull NavigableSet<V> r3, AbstractMapBasedMultimap<K, V>.WrappedCollection r4) {
            this.this$0 = r1;
            super(r1, r2, r3, r4);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.WrappedSortedSet
        NavigableSet<V> getSortedSetDelegate() {
            return (NavigableSet) super.getSortedSetDelegate();
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public V lower(@ParametricNullness V r1) {
            return getSortedSetDelegate().lower(r1);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public V floor(@ParametricNullness V r1) {
            return getSortedSetDelegate().floor(r1);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public V ceiling(@ParametricNullness V r1) {
            return getSortedSetDelegate().ceiling(r1);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public V higher(@ParametricNullness V r1) {
            return getSortedSetDelegate().higher(r1);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public V pollFirst() {
            return (V) Iterators.pollNext(iterator());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public V pollLast() {
            return (V) Iterators.pollNext(descendingIterator());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection] */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4 */
        private NavigableSet<V> wrap(NavigableSet<V> r5) {
            AbstractMapBasedMultimap r1 = this.this$0;
            K r2 = this.key;
            AbstractMapBasedMultimap<K, V>.WrappedCollection r3 = getAncestor();
            ?? r4 = this;
            if (r3 == null) goto L7;
            r4 = getAncestor();
        L7:
            return new WrappedNavigableSet(r1, r2, r5, r4);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> descendingSet() {
            return wrap(getSortedSetDelegate().descendingSet());
        }

        @Override // java.util.NavigableSet
        public Iterator<V> descendingIterator() {
            return new WrappedCollection.WrappedIterator(this, getSortedSetDelegate().descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> subSet(@ParametricNullness V r2, boolean r3, @ParametricNullness V r4, boolean r5) {
            return wrap(getSortedSetDelegate().subSet(r2, r3, r4, r5));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> headSet(@ParametricNullness V r2, boolean r3) {
            return wrap(getSortedSetDelegate().headSet(r2, r3));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> tailSet(@ParametricNullness V r2, boolean r3) {
            return wrap(getSortedSetDelegate().tailSet(r2, r3));
        }
    }

    class WrappedSet extends AbstractMapBasedMultimap<K, V>.WrappedCollection implements Set<V> {
        final /* synthetic */ AbstractMapBasedMultimap this$0;

        WrappedSet(@ParametricNullness AbstractMapBasedMultimap r2, K r3, Set<V> r4) {
            this.this$0 = r2;
            super(r2, r3, r4, null);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.WrappedCollection, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> r4) {
            if (r4.isEmpty() == false) goto L6;
            return false;
        L6:
            int r0 = size();
            boolean r5 = Sets.removeAllImpl((Set) this.delegate, r4);
            if (r5 == false) goto L9;
            int r1 = this.delegate.size();
            AbstractMapBasedMultimap.access$212(this.this$0, r1 - r0);
            removeIfEmpty();
        L9:
            return r5;
        }
    }

    class WrappedSortedSet extends AbstractMapBasedMultimap<K, V>.WrappedCollection implements SortedSet<V> {
        final /* synthetic */ AbstractMapBasedMultimap this$0;

        WrappedSortedSet(@ParametricNullness AbstractMapBasedMultimap r1, K r2, @CheckForNull SortedSet<V> r3, AbstractMapBasedMultimap<K, V>.WrappedCollection r4) {
            this.this$0 = r1;
            super(r1, r2, r3, r4);
        }

        SortedSet<V> getSortedSetDelegate() {
            return (SortedSet) getDelegate();
        }

        @Override // java.util.SortedSet
        @CheckForNull
        public Comparator<? super V> comparator() {
            return getSortedSetDelegate().comparator();
        }

        @Override // java.util.SortedSet
        @ParametricNullness
        public V first() {
            refreshIfEmpty();
            return getSortedSetDelegate().first();
        }

        @Override // java.util.SortedSet
        @ParametricNullness
        public V last() {
            refreshIfEmpty();
            return getSortedSetDelegate().last();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection] */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4 */
        @Override // java.util.SortedSet
        public SortedSet<V> headSet(@ParametricNullness V r5) {
            refreshIfEmpty();
            AbstractMapBasedMultimap r1 = this.this$0;
            Object r2 = getKey();
            SortedSet<V> r6 = getSortedSetDelegate().headSet(r5);
            AbstractMapBasedMultimap<K, V>.WrappedCollection r3 = getAncestor();
            ?? r4 = this;
            if (r3 == null) goto L7;
            r4 = getAncestor();
        L7:
            return new WrappedSortedSet(r1, r2, r6, r4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection] */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4 */
        @Override // java.util.SortedSet
        public SortedSet<V> subSet(@ParametricNullness V r5, @ParametricNullness V r6) {
            refreshIfEmpty();
            AbstractMapBasedMultimap r1 = this.this$0;
            Object r2 = getKey();
            SortedSet<V> r7 = getSortedSetDelegate().subSet(r5, r6);
            AbstractMapBasedMultimap<K, V>.WrappedCollection r8 = getAncestor();
            ?? r4 = this;
            if (r8 == null) goto L7;
            r4 = getAncestor();
        L7:
            return new WrappedSortedSet(r1, r2, r7, r4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection] */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4 */
        @Override // java.util.SortedSet
        public SortedSet<V> tailSet(@ParametricNullness V r5) {
            refreshIfEmpty();
            AbstractMapBasedMultimap r1 = this.this$0;
            Object r2 = getKey();
            SortedSet<V> r6 = getSortedSetDelegate().tailSet(r5);
            AbstractMapBasedMultimap<K, V>.WrappedCollection r3 = getAncestor();
            ?? r4 = this;
            if (r3 == null) goto L7;
            r4 = getAncestor();
        L7:
            return new WrappedSortedSet(r1, r2, r6, r4);
        }
    }

    abstract Collection<V> createCollection();

    static /* synthetic */ Map access$000(AbstractMapBasedMultimap r0) {
        return r0.map;
    }

    static /* synthetic */ Iterator access$100(Collection r0) {
        return iteratorOrListIterator(r0);
    }

    static /* synthetic */ int access$208(AbstractMapBasedMultimap r2) {
        int r0 = r2.totalSize;
        r2.totalSize = r0 + 1;
        return r0;
    }

    static /* synthetic */ int access$210(AbstractMapBasedMultimap r2) {
        int r0 = r2.totalSize;
        r2.totalSize = r0 - 1;
        return r0;
    }

    static /* synthetic */ int access$212(AbstractMapBasedMultimap r1, int r2) {
        int r0 = r1.totalSize + r2;
        r1.totalSize = r0;
        return r0;
    }

    static /* synthetic */ int access$220(AbstractMapBasedMultimap r1, int r2) {
        int r0 = r1.totalSize - r2;
        r1.totalSize = r0;
        return r0;
    }

    static /* synthetic */ void access$300(AbstractMapBasedMultimap r0, Object r1) {
        r0.removeValuesForKey(r1);
    }

    protected AbstractMapBasedMultimap(Map<K, Collection<V>> r2) {
        Preconditions.checkArgument(r2.isEmpty());
        this.map = r2;
    }

    final void setMap(Map<K, Collection<V>> r3) {
        this.map = r3;
        this.totalSize = 0;
        Iterator<Collection<V>> r4 = r3.values().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Collection<V> r0 = r4.next();
        Preconditions.checkArgument(!r0.isEmpty());
        this.totalSize += r0.size();
        goto L4
    }

    Collection<V> createUnmodifiableEmptyCollection() {
        return (Collection<V>) unmodifiableCollectionSubclass(createCollection());
    }

    Collection<V> createCollection(@ParametricNullness K r1) {
        return createCollection();
    }

    Map<K, Collection<V>> backingMap() {
        return this.map;
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.totalSize;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@CheckForNull Object r1) {
        return this.map.containsKey(r1);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean put(@ParametricNullness K r3, @ParametricNullness V r4) {
        Collection<V> r0 = this.map.get(r3);
        if (r0 != null) goto L11;
        Collection<V> r1 = createCollection(r3);
        if (r1.add(r4) == false) goto L9;
        this.totalSize++;
        this.map.put(r3, r1);
        return true;
    L9:
        throw new AssertionError("New Collection violated the Collection spec");
    L11:
        if (r0.add(r4) == false) goto L14;
        this.totalSize++;
        return true;
    L14:
        return false;
    }

    private Collection<V> getOrCreateCollection(@ParametricNullness K r2) {
        Collection<V> r0 = this.map.get(r2);
        if (r0 != null) goto L6;
        Collection<V> r1 = createCollection(r2);
        this.map.put(r2, r1);
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection<V> replaceValues(@ParametricNullness K r4, Iterable<? extends V> r5) {
        Iterator<? extends V> r6 = r5.iterator();
        if (r6.hasNext() == false) goto L5;
        Collection<V> r7 = getOrCreateCollection(r4);
        Collection<V> r0 = createCollection();
        r0.addAll(r7);
        this.totalSize -= r7.size();
        r7.clear();
    L8:
        if (r6.hasNext() == false) goto L13;
        if (r7.add(r6.next()) == false) goto L8;
        this.totalSize++;
        goto L8
    L13:
        return (Collection<V>) unmodifiableCollectionSubclass(r0);
    L5:
        return removeAll(r4);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection<V> removeAll(@CheckForNull Object r4) {
        Collection<V> r5 = this.map.remove(r4);
        if (r5 == null) goto L5;
        Collection r0 = createCollection();
        r0.addAll(r5);
        this.totalSize -= r5.size();
        r5.clear();
        return (Collection<V>) unmodifiableCollectionSubclass(r0);
    L5:
        return createUnmodifiableEmptyCollection();
    }

    <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> r1) {
        return Collections.unmodifiableCollection(r1);
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        Iterator<Collection<V>> r0 = this.map.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().clear();
        goto L4
    L6:
        this.map.clear();
        this.totalSize = 0;
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection<V> get(@ParametricNullness K r2) {
        Collection<V> r0 = this.map.get(r2);
        if (r0 != null) goto L6;
        r0 = createCollection(r2);
    L6:
        return wrapCollection(r2, r0);
    }

    Collection<V> wrapCollection(@ParametricNullness K r3, Collection<V> r4) {
        return new WrappedCollection(this, r3, r4, null);
    }

    final List<V> wrapList(@ParametricNullness K r2, List<V> r3, @CheckForNull AbstractMapBasedMultimap<K, V>.WrappedCollection r4) {
        if ((r3 instanceof RandomAccess) == false) goto L6;
        return new RandomAccessWrappedList(this, r2, r3, r4);
    L6:
        return new WrappedList(this, r2, r3, r4);
    }

    private static <E> Iterator<E> iteratorOrListIterator(Collection<E> r1) {
        if ((r1 instanceof List) == false) goto L6;
        return ((List) r1).listIterator();
    L6:
        return r1.iterator();
    }

    @Override // com.google.common.collect.AbstractMultimap
    Set<K> createKeySet() {
        return new KeySet(this, this.map);
    }

    final Set<K> createMaybeNavigableKeySet() {
        Map<K, Collection<V>> r0 = this.map;
        if ((r0 instanceof NavigableMap) == false) goto L7;
        return new NavigableKeySet(this, (NavigableMap) this.map);
    L7:
        if ((r0 instanceof SortedMap) == false) goto L11;
        return new SortedKeySet(this, (SortedMap) this.map);
    L11:
        return new KeySet(this, this.map);
    }

    private void removeValuesForKey(@CheckForNull Object r2) {
        Collection r3 = (Collection) Maps.safeRemove(this.map, r2);
        if (r3 == null) goto L6;
        int r0 = r3.size();
        r3.clear();
        this.totalSize -= r0;
        return;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Collection<V> values() {
        return super.values();
    }

    @Override // com.google.common.collect.AbstractMultimap
    Collection<V> createValues() {
        return new AbstractMultimap.Values(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Iterator<V> valueIterator() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Spliterator<V> valueSpliterator() {
        return CollectSpliterators.flatMap(this.map.values().spliterator(), new AbstractMapBasedMultimap$$ExternalSyntheticLambda3(), 64, size());
    }

    @Override // com.google.common.collect.AbstractMultimap
    Multiset<K> createKeys() {
        return new Multimaps.Keys(this);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Collection<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    Collection<Map.Entry<K, V>> createEntries() {
        if ((this instanceof SetMultimap) == false) goto L7;
        return new AbstractMultimap.EntrySet(this);
    L7:
        return new AbstractMultimap.Entries(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Iterator<Map.Entry<K, V>> entryIterator() {
        return new AnonymousClass2(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Spliterator<Map.Entry<K, V>> entrySpliterator() {
        return CollectSpliterators.flatMap(this.map.entrySet().spliterator(), new AbstractMapBasedMultimap$$ExternalSyntheticLambda2(), 64, size());
    }

    static /* synthetic */ Spliterator lambda$entrySpliterator$1(Map.Entry r2) {
        final Object r0 = r2.getKey();
        return CollectSpliterators.map(((Collection) r2.getValue()).spliterator(), new AbstractMapBasedMultimap$$ExternalSyntheticLambda4(r0));
    }

    static /* synthetic */ Map.Entry lambda$entrySpliterator$0(Object r0, Object r1) {
        return Maps.immutableEntry(r0, r1);
    }

    @Override // com.google.common.collect.Multimap
    public void forEach(final BiConsumer<? super K, ? super V> r2) {
        Preconditions.checkNotNull(r2);
        this.map.forEach(new AbstractMapBasedMultimap$$ExternalSyntheticLambda0(r2));
    }

    static /* synthetic */ void lambda$forEach$2(BiConsumer r0, Object r1, Object r2) {
        r0.accept(r1, r2);
    }

    static /* synthetic */ void lambda$forEach$3(final BiConsumer r1, final Object r2, Collection r3) {
        r3.forEach(new AbstractMapBasedMultimap$$ExternalSyntheticLambda1(r1, r2));
    }

    @Override // com.google.common.collect.AbstractMultimap
    Map<K, Collection<V>> createAsMap() {
        return new AsMap(this, this.map);
    }

    final Map<K, Collection<V>> createMaybeNavigableAsMap() {
        Map<K, Collection<V>> r0 = this.map;
        if ((r0 instanceof NavigableMap) == false) goto L7;
        return new NavigableAsMap(this, (NavigableMap) this.map);
    L7:
        if ((r0 instanceof SortedMap) == false) goto L11;
        return new SortedAsMap(this, (SortedMap) this.map);
    L11:
        return new AsMap(this, this.map);
    }
}
