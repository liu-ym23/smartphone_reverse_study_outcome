package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
class StandardTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;

    @GwtTransient
    final Map<R, Map<C, V>> backingMap;

    @CheckForNull
    private transient Set<C> columnKeySet;

    @CheckForNull
    private transient StandardTable<R, C, V>.ColumnMap columnMap;

    @GwtTransient
    final Supplier<? extends Map<C, V>> factory;

    @CheckForNull
    private transient Map<R, Map<C, V>> rowMap;

    /* JADX INFO: renamed from: com.google.common.collect.StandardTable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class CellIterator implements Iterator<Table.Cell<R, C, V>> {
        Iterator<Map.Entry<C, V>> columnIterator;

        @CheckForNull
        Map.Entry<R, Map<C, V>> rowEntry;
        final Iterator<Map.Entry<R, Map<C, V>>> rowIterator;
        final /* synthetic */ StandardTable this$0;

        private CellIterator(StandardTable r1) {
            this.this$0 = r1;
            this.rowIterator = r1.backingMap.entrySet().iterator();
            this.columnIterator = Iterators.emptyModifiableIterator();
        }

        /* synthetic */ CellIterator(StandardTable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.rowIterator.hasNext() == false) goto L5;
        L8:
            return true;
        L5:
            if (this.columnIterator.hasNext() == true) goto L8;
            return false;
        }

        @Override // java.util.Iterator
        public Table.Cell<R, C, V> next() {
            if (this.columnIterator.hasNext() == true) goto L5;
            Map.Entry<R, Map<C, V>> r0 = this.rowIterator.next();
            this.rowEntry = r0;
            this.columnIterator = r0.getValue().entrySet().iterator();
        L5:
            Objects.requireNonNull(this.rowEntry);
            Map.Entry<C, V> r1 = this.columnIterator.next();
            return Tables.immutableCell(this.rowEntry.getKey(), r1.getKey(), r1.getValue());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.columnIterator.remove();
            if (((Map) ((Map.Entry) Objects.requireNonNull(this.rowEntry)).getValue()).isEmpty() == false) goto L6;
            this.rowIterator.remove();
            this.rowEntry = null;
            return;
        }
    }

    private class Column extends Maps.ViewCachingAbstractMap<R, V> {
        final C columnKey;
        final /* synthetic */ StandardTable this$0;

        private class EntrySet extends Sets.ImprovedAbstractSet<Map.Entry<R, V>> {
            final /* synthetic */ Column this$1;

            private EntrySet(Column r1) {
                this.this$1 = r1;
            }

            /* synthetic */ EntrySet(Column r1, AnonymousClass1 r2) {
                this(r1);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, V>> iterator() {
                return new EntrySetIterator(this.this$1, null);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                Iterator<Map<C, V>> r0 = this.this$1.this$0.backingMap.values().iterator();
                int r1 = 0;
            L4:
                if (r0.hasNext() == false) goto L8;
                if (r0.next().containsKey(this.this$1.columnKey) == false) goto L4;
                r1 = r1 + 1;
                goto L4
            L8:
                return r1;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return !this.this$1.this$0.containsColumn(this.this$1.columnKey);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                this.this$1.removeFromColumnIf(Predicates.alwaysTrue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object r3) {
                if ((r3 instanceof Map.Entry) == false) goto L6;
                Map.Entry r4 = (Map.Entry) r3;
                return StandardTable.access$300(this.this$1.this$0, r4.getKey(), this.this$1.columnKey, r4.getValue());
            L6:
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object r3) {
                if ((r3 instanceof Map.Entry) == false) goto L6;
                Map.Entry r4 = (Map.Entry) r3;
                return StandardTable.access$400(this.this$1.this$0, r4.getKey(), this.this$1.columnKey, r4.getValue());
            L6:
                return false;
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> r1) {
                return this.this$1.removeFromColumnIf(Predicates.not(Predicates.in(r1)));
            }
        }

        private class EntrySetIterator extends AbstractIterator<Map.Entry<R, V>> {
            final Iterator<Map.Entry<R, Map<C, V>>> iterator;
            final /* synthetic */ Column this$1;

            private EntrySetIterator(Column r1) {
                this.this$1 = r1;
                this.iterator = r1.this$0.backingMap.entrySet().iterator();
            }

            /* synthetic */ EntrySetIterator(Column r1, AnonymousClass1 r2) {
                this(r1);
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            protected /* bridge */ /* synthetic */ Object computeNext() {
                return computeNext();
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            protected Map.Entry<R, V> computeNext() {
            L3:
                if (this.iterator.hasNext() == false) goto L9;
                final Map.Entry<R, Map<C, V>> r0 = this.iterator.next();
                if (r0.getValue().containsKey(this.this$1.columnKey) == false) goto L3;
                return new C1EntryImpl(this, r0);
            L9:
                return endOfData();
            }
        }

        private class KeySet extends Maps.KeySet<R, V> {
            final /* synthetic */ Column this$1;

            KeySet(Column r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object r2) {
                return this.this$1.this$0.contains(r2, this.this$1.columnKey);
            }

            @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object r2) {
                if (this.this$1.this$0.remove(r2, this.this$1.columnKey) == null) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> r1) {
                return this.this$1.removeFromColumnIf(Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(r1))));
            }
        }

        private class Values extends Maps.Values<R, V> {
            final /* synthetic */ Column this$1;

            Values(Column r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean remove(@CheckForNull Object r1) {
                if (r1 != null) goto L4;
            L6:
                return false;
            L4:
                if (this.this$1.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.equalTo(r1))) == false) goto L6;
                return true;
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> r1) {
                return this.this$1.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.in(r1)));
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> r1) {
                return this.this$1.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(r1))));
            }
        }

        Column(StandardTable r1, C r2) {
            this.this$0 = r1;
            this.columnKey = (C) Preconditions.checkNotNull(r2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V put(R r2, V r3) {
            return (V) this.this$0.put(r2, this.columnKey, r3);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V get(@CheckForNull Object r2) {
            return (V) this.this$0.get(r2, this.columnKey);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object r2) {
            return this.this$0.contains(r2, this.columnKey);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V remove(@CheckForNull Object r2) {
            return (V) this.this$0.remove(r2, this.columnKey);
        }

        boolean removeFromColumnIf(Predicate<? super Map.Entry<R, V>> r6) {
            Iterator<Map.Entry<R, Map<C, V>>> r0 = this.this$0.backingMap.entrySet().iterator();
            boolean r1 = false;
        L4:
            if (r0.hasNext() == false) goto L13;
            Map.Entry<R, Map<C, V>> r2 = r0.next();
            Map<C, V> r3 = r2.getValue();
            V r4 = r3.get(this.columnKey);
            if (r4 == null) goto L4;
            if (r6.apply(Maps.immutableEntry(r2.getKey(), r4)) == false) goto L4;
            r3.remove(this.columnKey);
            if (r3.isEmpty() == false) goto L12;
            r0.remove();
        L12:
            r1 = true;
            goto L4
        L13:
            return r1;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        Set<Map.Entry<R, V>> createEntrySet() {
            return new EntrySet(this, null);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        Set<R> createKeySet() {
            return new KeySet(this);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        Collection<V> createValues() {
            return new Values(this);
        }
    }

    private class ColumnKeyIterator extends AbstractIterator<C> {
        Iterator<Map.Entry<C, V>> entryIterator;
        final Iterator<Map<C, V>> mapIterator;
        final Map<C, V> seen;
        final /* synthetic */ StandardTable this$0;

        private ColumnKeyIterator(StandardTable r2) {
            this.this$0 = r2;
            this.seen = r2.factory.get();
            this.mapIterator = r2.backingMap.values().iterator();
            this.entryIterator = Iterators.emptyIterator();
        }

        /* synthetic */ ColumnKeyIterator(StandardTable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        protected C computeNext() {
        L3:
            if (this.entryIterator.hasNext() == true) goto L4;
            if (this.mapIterator.hasNext() == false) goto L12;
            this.entryIterator = this.mapIterator.next().entrySet().iterator();
            goto L3
        L12:
            return endOfData();
        L4:
            Map.Entry<C, V> r0 = this.entryIterator.next();
            if (this.seen.containsKey(r0.getKey()) == true) goto L3;
            this.seen.put(r0.getKey(), r0.getValue());
            return r0.getKey();
        }
    }

    private class ColumnKeySet extends StandardTable<R, C, V>.TableSet<C> {
        final /* synthetic */ StandardTable this$0;

        private ColumnKeySet(StandardTable r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ ColumnKeySet(StandardTable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<C> iterator() {
            return this.this$0.createColumnKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Iterators.size(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object r4) {
            boolean r0 = false;
            if (r4 != null) goto L5;
            return false;
        L5:
            Iterator<Map<C, V>> r3 = this.this$0.backingMap.values().iterator();
        L7:
            if (r3.hasNext() == false) goto L14;
            Map<C, V> r1 = r3.next();
            if (r1.keySet().remove(r4) == false) goto L7;
            if (r1.isEmpty() == false) goto L13;
            r3.remove();
        L13:
            r0 = true;
            goto L7
        L14:
            return r0;
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r4) {
            Preconditions.checkNotNull(r4);
            Iterator<Map<C, V>> r3 = this.this$0.backingMap.values().iterator();
            boolean r0 = false;
        L4:
            if (r3.hasNext() == false) goto L11;
            Map<C, V> r1 = r3.next();
            if (Iterators.removeAll(r1.keySet().iterator(), r4) == false) goto L4;
            if (r1.isEmpty() == false) goto L10;
            r3.remove();
        L10:
            r0 = true;
            goto L4
        L11:
            return r0;
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r4) {
            Preconditions.checkNotNull(r4);
            Iterator<Map<C, V>> r3 = this.this$0.backingMap.values().iterator();
            boolean r0 = false;
        L4:
            if (r3.hasNext() == false) goto L11;
            Map<C, V> r1 = r3.next();
            if (r1.keySet().retainAll(r4) == false) goto L4;
            if (r1.isEmpty() == false) goto L10;
            r3.remove();
        L10:
            r0 = true;
            goto L4
        L11:
            return r0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r1) {
            return this.this$0.containsColumn(r1);
        }
    }

    private class ColumnMap extends Maps.ViewCachingAbstractMap<C, Map<R, V>> {
        final /* synthetic */ StandardTable this$0;

        class ColumnMapEntrySet extends StandardTable<R, C, V>.TableSet<Map.Entry<C, Map<R, V>>> {
            final /* synthetic */ ColumnMap this$1;

            ColumnMapEntrySet(ColumnMap r2) {
                this.this$1 = r2;
                super(r2.this$0, null);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
                return Maps.asMapEntryIterator(this.this$1.this$0.columnKeySet(), new AnonymousClass1(this));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.this$1.this$0.columnKeySet().size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object r3) {
                if ((r3 instanceof Map.Entry) == false) goto L8;
                Map.Entry r4 = (Map.Entry) r3;
                if (this.this$1.this$0.containsColumn(r4.getKey()) == true) goto L7;
                return false;
            L7:
                return ((Map) Objects.requireNonNull(this.this$1.get(r4.getKey()))).equals(r4.getValue());
            L8:
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object r2) {
                if (contains(r2) == true) goto L5;
                return false;
            L5:
                if ((r2 instanceof Map.Entry) == false) goto L10;
                StandardTable.access$900(this.this$1.this$0, ((Map.Entry) r2).getKey());
                return true;
            L10:
                return false;
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> r1) {
                Preconditions.checkNotNull(r1);
                return Sets.removeAllImpl(this, r1.iterator());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> r5) {
                Preconditions.checkNotNull(r5);
                Iterator r0 = Lists.newArrayList(this.this$1.this$0.columnKeySet().iterator()).iterator();
                boolean r1 = false;
            L4:
                if (r0.hasNext() == false) goto L8;
                Object r2 = r0.next();
                if (r5.contains(Maps.immutableEntry(r2, this.this$1.this$0.column(r2))) == true) goto L4;
                StandardTable.access$900(this.this$1.this$0, r2);
                r1 = true;
                goto L4
            L8:
                return r1;
            }
        }

        private class ColumnMapValues extends Maps.Values<C, Map<R, V>> {
            final /* synthetic */ ColumnMap this$1;

            ColumnMapValues(ColumnMap r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean remove(@CheckForNull Object r4) {
                Iterator<Map.Entry<C, Map<R, V>>> r0 = this.this$1.entrySet().iterator();
            L4:
                if (r0.hasNext() == false) goto L9;
                Map.Entry<C, Map<R, V>> r1 = r0.next();
                if (r1.getValue().equals(r4) == false) goto L4;
                StandardTable.access$900(this.this$1.this$0, r1.getKey());
                return true;
            L9:
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> r5) {
                Preconditions.checkNotNull(r5);
                Iterator r0 = Lists.newArrayList(this.this$1.this$0.columnKeySet().iterator()).iterator();
                boolean r1 = false;
            L4:
                if (r0.hasNext() == false) goto L8;
                Object r2 = r0.next();
                if (r5.contains(this.this$1.this$0.column(r2)) == false) goto L4;
                StandardTable.access$900(this.this$1.this$0, r2);
                r1 = true;
                goto L4
            L8:
                return r1;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> r5) {
                Preconditions.checkNotNull(r5);
                Iterator r0 = Lists.newArrayList(this.this$1.this$0.columnKeySet().iterator()).iterator();
                boolean r1 = false;
            L4:
                if (r0.hasNext() == false) goto L8;
                Object r2 = r0.next();
                if (r5.contains(this.this$1.this$0.column(r2)) == true) goto L4;
                StandardTable.access$900(this.this$1.this$0, r2);
                r1 = true;
                goto L4
            L8:
                return r1;
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

        private ColumnMap(StandardTable r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ColumnMap(StandardTable r1, AnonymousClass1 r2) {
            this(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public Map<R, V> get(@CheckForNull Object r2) {
            if (this.this$0.containsColumn(r2) == true) goto L7;
            return null;
        L7:
            return this.this$0.column(Objects.requireNonNull(r2));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object r1) {
            return this.this$0.containsColumn(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public Map<R, V> remove(@CheckForNull Object r2) {
            if (this.this$0.containsColumn(r2) == true) goto L7;
            return null;
        L7:
            return StandardTable.access$900(this.this$0, r2);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<Map.Entry<C, Map<R, V>>> createEntrySet() {
            return new ColumnMapEntrySet(this);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public Set<C> keySet() {
            return this.this$0.columnKeySet();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        Collection<Map<R, V>> createValues() {
            return new ColumnMapValues(this);
        }
    }

    class Row extends Maps.IteratorBasedAbstractMap<C, V> {

        @CheckForNull
        Map<C, V> backingRowMap;
        final R rowKey;
        final /* synthetic */ StandardTable this$0;

        Row(StandardTable r1, R r2) {
            this.this$0 = r1;
            this.rowKey = (R) Preconditions.checkNotNull(r2);
        }

        final void updateBackingRowMapField() {
            Map<C, V> r0 = this.backingRowMap;
            if (r0 != null) goto L5;
        L8:
            this.backingRowMap = computeBackingRowMap();
            return;
        L5:
            if (r0.isEmpty() == true) goto L7;
            return;
        L7:
            if (this.this$0.backingMap.containsKey(this.rowKey) == true) goto L8;
        }

        @CheckForNull
        Map<C, V> computeBackingRowMap() {
            return this.this$0.backingMap.get(this.rowKey);
        }

        void maintainEmptyInvariant() {
            updateBackingRowMapField();
            Map<C, V> r0 = this.backingRowMap;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.isEmpty() == false) goto L9;
            this.this$0.backingMap.remove(this.rowKey);
            this.backingRowMap = null;
            return;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object r1) {
            updateBackingRowMapField();
            if (r1 == null) goto L9;
            Map<C, V> r0 = this.backingRowMap;
            if (r0 == null) goto L9;
            if (Maps.safeContainsKey(r0, r1) == false) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V get(@CheckForNull Object r1) {
            updateBackingRowMapField();
            if (r1 == null) goto L7;
            Map<C, V> r0 = this.backingRowMap;
            if (r0 == null) goto L7;
            return (V) Maps.safeGet(r0, r1);
        L7:
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V put(C r2, V r3) {
            Preconditions.checkNotNull(r2);
            Preconditions.checkNotNull(r3);
            Map<C, V> r0 = this.backingRowMap;
            if (r0 == null) goto L9;
            if (r0.isEmpty() == true) goto L9;
            return this.backingRowMap.put(r2, r3);
        L9:
            return (V) this.this$0.put(this.rowKey, r2, r3);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V remove(@CheckForNull Object r2) {
            updateBackingRowMapField();
            Map<C, V> r0 = this.backingRowMap;
            if (r0 != null) goto L6;
            return null;
        L6:
            V r3 = (V) Maps.safeRemove(r0, r2);
            maintainEmptyInvariant();
            return r3;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            updateBackingRowMapField();
            Map<C, V> r0 = this.backingRowMap;
            if (r0 == null) goto L5;
            r0.clear();
        L5:
            maintainEmptyInvariant();
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            updateBackingRowMapField();
            Map<C, V> r0 = this.backingRowMap;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.size();
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        Iterator<Map.Entry<C, V>> entryIterator() {
            updateBackingRowMapField();
            Map<C, V> r0 = this.backingRowMap;
            if (r0 == null) goto L5;
            final Iterator<Map.Entry<C, V>> r1 = r0.entrySet().iterator();
            return new AnonymousClass1(this, r1);
        L5:
            return Iterators.emptyModifiableIterator();
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        Spliterator<Map.Entry<C, V>> entrySpliterator() {
            updateBackingRowMapField();
            Map<C, V> r0 = this.backingRowMap;
            if (r0 != null) goto L7;
            return Spliterators.emptySpliterator();
        L7:
            return CollectSpliterators.map(r0.entrySet().spliterator(), new StandardTable$Row$$ExternalSyntheticLambda0(this));
        }

        Map.Entry<C, V> wrapEntry(final Map.Entry<C, V> r2) {
            return new AnonymousClass2(this, r2);
        }
    }

    class RowMap extends Maps.ViewCachingAbstractMap<R, Map<C, V>> {
        final /* synthetic */ StandardTable this$0;

        class EntrySet extends StandardTable<R, C, V>.TableSet<Map.Entry<R, Map<C, V>>> {
            final /* synthetic */ RowMap this$1;

            EntrySet(RowMap r2) {
                this.this$1 = r2;
                super(r2.this$0, null);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
                return Maps.asMapEntryIterator(this.this$1.this$0.backingMap.keySet(), new AnonymousClass1(this));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.this$1.this$0.backingMap.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object r3) {
                if ((r3 instanceof Map.Entry) == false) goto L12;
                Map.Entry r4 = (Map.Entry) r3;
                if (r4.getKey() != null) goto L7;
                return false;
            L7:
                if ((r4.getValue() instanceof Map) == true) goto L9;
                return false;
            L9:
                if (Collections2.safeContains(this.this$1.this$0.backingMap.entrySet(), r4) == false) goto L15;
                return true;
            L15:
                return false;
            L12:
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object r3) {
                if ((r3 instanceof Map.Entry) == false) goto L12;
                Map.Entry r4 = (Map.Entry) r3;
                if (r4.getKey() != null) goto L7;
                return false;
            L7:
                if ((r4.getValue() instanceof Map) == true) goto L9;
                return false;
            L9:
                if (this.this$1.this$0.backingMap.entrySet().remove(r4) == false) goto L15;
                return true;
            L15:
                return false;
            L12:
                return false;
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

        RowMap(StandardTable r1) {
            this.this$0 = r1;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object r1) {
            return this.this$0.containsRow(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public Map<C, V> get(@CheckForNull Object r2) {
            if (this.this$0.containsRow(r2) == true) goto L7;
            return null;
        L7:
            return this.this$0.row(Objects.requireNonNull(r2));
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public Map<C, V> remove(@CheckForNull Object r1) {
            if (r1 != null) goto L5;
            return null;
        L5:
            return this.this$0.backingMap.remove(r1);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        protected Set<Map.Entry<R, Map<C, V>>> createEntrySet() {
            return new EntrySet(this);
        }
    }

    private abstract class TableSet<T> extends Sets.ImprovedAbstractSet<T> {
        final /* synthetic */ StandardTable this$0;

        private TableSet(StandardTable r1) {
            this.this$0 = r1;
        }

        /* synthetic */ TableSet(StandardTable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.this$0.backingMap.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.backingMap.clear();
        }
    }

    static /* synthetic */ boolean access$300(StandardTable r0, Object r1, Object r2, Object r3) {
        return r0.containsMapping(r1, r2, r3);
    }

    static /* synthetic */ boolean access$400(StandardTable r0, Object r1, Object r2, Object r3) {
        return r0.removeMapping(r1, r2, r3);
    }

    static /* synthetic */ Map access$900(StandardTable r0, Object r1) {
        return r0.removeColumn(r1);
    }

    StandardTable(Map<R, Map<C, V>> r1, Supplier<? extends Map<C, V>> r2) {
        this.backingMap = r1;
        this.factory = r2;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean contains(@CheckForNull Object r1, @CheckForNull Object r2) {
        if (r1 == null) goto L7;
        if (r2 == null) goto L7;
        if (super.contains(r1, r2) == false) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsColumn(@CheckForNull Object r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        Iterator<Map<C, V>> r2 = this.backingMap.values().iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        if (Maps.safeContainsKey(r2.next(), r3) == false) goto L7;
        return true;
    L12:
        return false;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsRow(@CheckForNull Object r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (Maps.safeContainsKey(this.backingMap, r1) == false) goto L6;
        return true;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsValue(@CheckForNull Object r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (super.containsValue(r1) == false) goto L6;
        return true;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CheckForNull
    public V get(@CheckForNull Object r1, @CheckForNull Object r2) {
        if (r1 == null) goto L6;
        if (r2 == null) goto L6;
        return (V) super.get(r1, r2);
    L6:
        return null;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override // com.google.common.collect.Table
    public int size() {
        Iterator<Map<C, V>> r2 = this.backingMap.values().iterator();
        int r0 = 0;
    L4:
        if (r2.hasNext() == false) goto L6;
        r0 = r0 + r2.next().size();
        goto L4
    L6:
        return r0;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public void clear() {
        this.backingMap.clear();
    }

    private Map<C, V> getOrCreate(R r2) {
        Map<C, V> r0 = this.backingMap.get(r2);
        if (r0 != null) goto L6;
        Map<C, V> r1 = this.factory.get();
        this.backingMap.put(r2, r1);
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CheckForNull
    public V put(R r1, C r2, V r3) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        return getOrCreate(r1).put(r2, r3);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CheckForNull
    public V remove(@CheckForNull Object r3, @CheckForNull Object r4) {
        if (r3 == null) goto L13;
        if (r4 == null) goto L13;
        Map r1 = (Map) Maps.safeGet(this.backingMap, r3);
        if (r1 != null) goto L9;
        return null;
    L9:
        V r5 = (V) r1.remove(r4);
        if (r1.isEmpty() == false) goto L12;
        this.backingMap.remove(r3);
    L12:
        return r5;
    L13:
        return null;
    }

    private Map<R, V> removeColumn(@CheckForNull Object r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Map.Entry<R, Map<C, V>>> r4 = this.backingMap.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        Map.Entry<R, Map<C, V>> r1 = r4.next();
        V r2 = r1.getValue().remove(r5);
        if (r2 == null) goto L4;
        r0.put(r1.getKey(), r2);
        if (r1.getValue().isEmpty() == false) goto L4;
        r4.remove();
        goto L4
    L10:
        return r0;
    }

    private boolean containsMapping(@CheckForNull Object r1, @CheckForNull Object r2, @CheckForNull Object r3) {
        if (r3 != null) goto L4;
    L6:
        return false;
    L4:
        if (r3.equals(get(r1, r2)) == false) goto L6;
        return true;
    }

    private boolean removeMapping(@CheckForNull Object r1, @CheckForNull Object r2, @CheckForNull Object r3) {
        if (containsMapping(r1, r2, r3) == false) goto L6;
        remove(r1, r2);
        return true;
    L6:
        return false;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.AbstractTable
    Iterator<Table.Cell<R, C, V>> cellIterator() {
        return new CellIterator(this, null);
    }

    @Override // com.google.common.collect.AbstractTable
    Spliterator<Table.Cell<R, C, V>> cellSpliterator() {
        return CollectSpliterators.flatMap(this.backingMap.entrySet().spliterator(), new StandardTable$$ExternalSyntheticLambda1(), 65, size());
    }

    static /* synthetic */ Spliterator lambda$cellSpliterator$1(final Map.Entry r2) {
        return CollectSpliterators.map(((Map) r2.getValue()).entrySet().spliterator(), new StandardTable$$ExternalSyntheticLambda0(r2));
    }

    static /* synthetic */ Table.Cell lambda$cellSpliterator$0(Map.Entry r1, Map.Entry r2) {
        return Tables.immutableCell(r1.getKey(), r2.getKey(), r2.getValue());
    }

    @Override // com.google.common.collect.Table
    public Map<C, V> row(R r2) {
        return new Row(this, r2);
    }

    @Override // com.google.common.collect.Table
    public Map<R, V> column(C r2) {
        return new Column(this, r2);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Set<C> columnKeySet() {
        Set<C> r0 = this.columnKeySet;
        if (r0 != null) goto L6;
        ColumnKeySet r1 = new ColumnKeySet(this, null);
        this.columnKeySet = r1;
        return r1;
    L6:
        return r0;
    }

    Iterator<C> createColumnKeyIterator() {
        return new ColumnKeyIterator(this, null);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Collection<V> values() {
        return super.values();
    }

    @Override // com.google.common.collect.Table
    public Map<R, Map<C, V>> rowMap() {
        Map<R, Map<C, V>> r0 = this.rowMap;
        if (r0 != null) goto L6;
        Map<R, Map<C, V>> r1 = createRowMap();
        this.rowMap = r1;
        return r1;
    L6:
        return r0;
    }

    Map<R, Map<C, V>> createRowMap() {
        return new RowMap(this);
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        StandardTable<R, C, V>.ColumnMap r0 = this.columnMap;
        if (r0 != null) goto L6;
        StandardTable<R, C, V>.ColumnMap r1 = new ColumnMap(this, null);
        this.columnMap = r1;
        return r1;
    L6:
        return r0;
    }
}
