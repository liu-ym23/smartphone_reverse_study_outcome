package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
class FilteredEntryMultimap<K, V> extends AbstractMultimap<K, V> implements FilteredMultimap<K, V> {
    final Predicate<? super Map.Entry<K, V>> predicate;
    final Multimap<K, V> unfiltered;

    class AsMap extends Maps.ViewCachingAbstractMap<K, Collection<V>> {
        final /* synthetic */ FilteredEntryMultimap this$0;

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

        AsMap(FilteredEntryMultimap r1) {
            this.this$0 = r1;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object r1) {
            if (get(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public Collection<V> get(@CheckForNull Object r4) {
            Collection<V> r0 = this.this$0.unfiltered.asMap().get(r4);
            if (r0 != null) goto L5;
            return null;
        L5:
            Collection<V> r3 = FilteredEntryMultimap.filterCollection(r0, new ValuePredicate(this.this$0, r4));
            if (r3.isEmpty() == false) goto L9;
            return null;
        L9:
            return r3;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public Collection<V> remove(@CheckForNull Object r6) {
            Collection<V> r0 = this.this$0.unfiltered.asMap().get(r6);
            if (r0 != null) goto L5;
            return null;
        L5:
            ArrayList r2 = Lists.newArrayList();
            Iterator<V> r1 = r0.iterator();
        L7:
            if (r1.hasNext() == false) goto L12;
            V r3 = r1.next();
            if (FilteredEntryMultimap.access$000(this.this$0, r6, r3) == false) goto L7;
            r1.remove();
            r2.add(r3);
            goto L7
        L12:
            if (r2.isEmpty() == false) goto L15;
            return null;
        L15:
            if ((this.this$0.unfiltered instanceof SetMultimap) == false) goto L19;
            return Collections.unmodifiableSet(Sets.newLinkedHashSet(r2));
        L19:
            return Collections.unmodifiableList(r2);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        Set<K> createKeySet() {
            return new C1KeySetImpl(this);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        Set<Map.Entry<K, Collection<V>>> createEntrySet() {
            return new C1EntrySetImpl(this);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        Collection<Collection<V>> createValues() {
            return new C1ValuesImpl(this);
        }
    }

    class Keys extends Multimaps.Keys<K, V> {
        final /* synthetic */ FilteredEntryMultimap this$0;

        Keys(FilteredEntryMultimap r1) {
            this.this$0 = r1;
            super(r1);
        }

        @Override // com.google.common.collect.Multimaps.Keys, com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int remove(@CheckForNull Object r5, int r6) {
            CollectPreconditions.checkNonnegative(r6, "occurrences");
            if (r6 == 0) goto L5;
            Collection<V> r0 = this.this$0.unfiltered.asMap().get(r5);
            int r1 = 0;
            if (r0 != null) goto L9;
            return 0;
        L9:
            Iterator<V> r2 = r0.iterator();
        L11:
            if (r2.hasNext() == false) goto L17;
            V r3 = r2.next();
            if (FilteredEntryMultimap.access$000(this.this$0, r5, r3) == false) goto L11;
            r1 = r1 + 1;
            if (r1 > r6) goto L11;
            r2.remove();
            goto L11
        L17:
            return r1;
        L5:
            return count(r5);
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public Set<Multiset.Entry<K>> entrySet() {
            return new AnonymousClass1(this);
        }
    }

    final class ValuePredicate implements Predicate<V> {

        @ParametricNullness
        private final K key;
        final /* synthetic */ FilteredEntryMultimap this$0;

        ValuePredicate(@ParametricNullness FilteredEntryMultimap r1, K r2) {
            this.this$0 = r1;
            this.key = r2;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@ParametricNullness V r2) {
            return FilteredEntryMultimap.access$000(this.this$0, this.key, r2);
        }
    }

    static /* synthetic */ boolean access$000(FilteredEntryMultimap r0, Object r1, Object r2) {
        return r0.satisfies(r1, r2);
    }

    FilteredEntryMultimap(Multimap<K, V> r1, Predicate<? super Map.Entry<K, V>> r2) {
        this.unfiltered = (Multimap) Preconditions.checkNotNull(r1);
        this.predicate = (Predicate) Preconditions.checkNotNull(r2);
    }

    @Override // com.google.common.collect.FilteredMultimap
    public Multimap<K, V> unfiltered() {
        return this.unfiltered;
    }

    @Override // com.google.common.collect.FilteredMultimap
    public Predicate<? super Map.Entry<K, V>> entryPredicate() {
        return this.predicate;
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return entries().size();
    }

    private boolean satisfies(@ParametricNullness K r1, @ParametricNullness V r2) {
        return this.predicate.apply(Maps.immutableEntry(r1, r2));
    }

    static <E> Collection<E> filterCollection(Collection<E> r1, Predicate<? super E> r2) {
        if ((r1 instanceof Set) == false) goto L7;
        return Sets.filter((Set) r1, r2);
    L7:
        return Collections2.filter(r1, r2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@CheckForNull Object r1) {
        if (asMap().get(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection<V> removeAll(@CheckForNull Object r2) {
        return (Collection) MoreObjects.firstNonNull(asMap().remove(r2), unmodifiableEmptyCollection());
    }

    Collection<V> unmodifiableEmptyCollection() {
        if ((this.unfiltered instanceof SetMultimap) == false) goto L6;
        return Collections.emptySet();
    L6:
        return Collections.emptyList();
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        entries().clear();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection<V> get(@ParametricNullness K r3) {
        return filterCollection(this.unfiltered.get(r3), new ValuePredicate(this, r3));
    }

    @Override // com.google.common.collect.AbstractMultimap
    Collection<Map.Entry<K, V>> createEntries() {
        return filterCollection(this.unfiltered.entries(), this.predicate);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Collection<V> createValues() {
        return new FilteredMultimapValues(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractMultimap
    Map<K, Collection<V>> createAsMap() {
        return new AsMap(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Set<K> createKeySet() {
        return asMap().keySet();
    }

    boolean removeEntriesIf(Predicate<? super Map.Entry<K, Collection<V>>> r7) {
        Iterator<Map.Entry<K, Collection<V>>> r0 = this.unfiltered.asMap().entrySet().iterator();
        boolean r1 = false;
    L4:
        if (r0.hasNext() == false) goto L14;
        Map.Entry<K, Collection<V>> r2 = r0.next();
        K r3 = r2.getKey();
        Collection r4 = filterCollection(r2.getValue(), new ValuePredicate(this, r3));
        if (r4.isEmpty() == true) goto L4;
        if (r7.apply(Maps.immutableEntry(r3, r4)) == false) goto L4;
        if (r4.size() != r2.getValue().size()) goto L12;
        r0.remove();
    L13:
        r1 = true;
        goto L4
    L12:
        r4.clear();
        goto L13
    L14:
        return r1;
    }

    @Override // com.google.common.collect.AbstractMultimap
    Multiset<K> createKeys() {
        return new Keys(this);
    }
}
