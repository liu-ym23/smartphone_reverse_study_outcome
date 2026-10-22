package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Tables {
    private static final Function<? extends Map<?, ?>, ? extends Map<?, ?>> UNMODIFIABLE_WRAPPER = null;

    static abstract class AbstractCell<R, C, V> implements Table.Cell<R, C, V> {
        AbstractCell() {
        }

        @Override // com.google.common.collect.Table.Cell
        public boolean equals(@CheckForNull Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if ((r5 instanceof Table.Cell) == false) goto L16;
            Table.Cell r6 = (Table.Cell) r5;
            if (Objects.equal(getRowKey(), r6.getRowKey()) == false) goto L15;
            if (Objects.equal(getColumnKey(), r6.getColumnKey()) == false) goto L15;
            if (Objects.equal(getValue(), r6.getValue()) == false) goto L15;
            return true;
        L15:
            return false;
        L16:
            return false;
        }

        @Override // com.google.common.collect.Table.Cell
        public int hashCode() {
            return Objects.hashCode(new Object[]{getRowKey(), getColumnKey(), getValue()});
        }

        public String toString() {
            String r0 = String.valueOf(getRowKey());
            String r1 = String.valueOf(getColumnKey());
            String r4 = String.valueOf(getValue());
            return new StringBuilder(((String.valueOf(r0).length() + 4) + String.valueOf(r1).length()) + String.valueOf(r4).length()).append("(").append(r0).append(",").append(r1).append(")=").append(r4).toString();
        }
    }

    static final class ImmutableCell<R, C, V> extends AbstractCell<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;

        @ParametricNullness
        private final C columnKey;

        @ParametricNullness
        private final R rowKey;

        @ParametricNullness
        private final V value;

        ImmutableCell(@ParametricNullness R r1, @ParametricNullness C r2, @ParametricNullness V r3) {
            this.rowKey = r1;
            this.columnKey = r2;
            this.value = r3;
        }

        @Override // com.google.common.collect.Table.Cell
        @ParametricNullness
        public R getRowKey() {
            return this.rowKey;
        }

        @Override // com.google.common.collect.Table.Cell
        @ParametricNullness
        public C getColumnKey() {
            return this.columnKey;
        }

        @Override // com.google.common.collect.Table.Cell
        @ParametricNullness
        public V getValue() {
            return this.value;
        }
    }

    private static class TransformedTable<R, C, V1, V2> extends AbstractTable<R, C, V2> {
        final Table<R, C, V1> fromTable;
        final Function<? super V1, V2> function;

        TransformedTable(Table<R, C, V1> r1, Function<? super V1, V2> r2) {
            this.fromTable = (Table) Preconditions.checkNotNull(r1);
            this.function = (Function) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public boolean contains(@CheckForNull Object r1, @CheckForNull Object r2) {
            return this.fromTable.contains(r1, r2);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        @CheckForNull
        public V2 get(@CheckForNull Object r2, @CheckForNull Object r3) {
            if (contains(r2, r3) == true) goto L7;
            return null;
        L7:
            return this.function.apply((Object) NullnessCasts.uncheckedCastNullableTToT(this.fromTable.get(r2, r3)));
        }

        @Override // com.google.common.collect.Table
        public int size() {
            return this.fromTable.size();
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public void clear() {
            this.fromTable.clear();
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        @CheckForNull
        public V2 put(@ParametricNullness R r1, @ParametricNullness C r2, @ParametricNullness V2 r3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public void putAll(Table<? extends R, ? extends C, ? extends V2> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        @CheckForNull
        public V2 remove(@CheckForNull Object r2, @CheckForNull Object r3) {
            if (contains(r2, r3) == true) goto L7;
            return null;
        L7:
            return this.function.apply((Object) NullnessCasts.uncheckedCastNullableTToT(this.fromTable.remove(r2, r3)));
        }

        @Override // com.google.common.collect.Table
        public Map<C, V2> row(@ParametricNullness R r2) {
            return Maps.transformValues(this.fromTable.row(r2), this.function);
        }

        @Override // com.google.common.collect.Table
        public Map<R, V2> column(@ParametricNullness C r2) {
            return Maps.transformValues(this.fromTable.column(r2), this.function);
        }

        Function<Table.Cell<R, C, V1>, Table.Cell<R, C, V2>> cellFunction() {
            return new AnonymousClass1(this);
        }

        @Override // com.google.common.collect.AbstractTable
        Iterator<Table.Cell<R, C, V2>> cellIterator() {
            return Iterators.transform(this.fromTable.cellSet().iterator(), cellFunction());
        }

        @Override // com.google.common.collect.AbstractTable
        Spliterator<Table.Cell<R, C, V2>> cellSpliterator() {
            return CollectSpliterators.map(this.fromTable.cellSet().spliterator(), cellFunction());
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public Set<R> rowKeySet() {
            return this.fromTable.rowKeySet();
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public Set<C> columnKeySet() {
            return this.fromTable.columnKeySet();
        }

        @Override // com.google.common.collect.AbstractTable
        Collection<V2> createValues() {
            return Collections2.transform(this.fromTable.values(), this.function);
        }

        @Override // com.google.common.collect.Table
        public Map<R, Map<C, V2>> rowMap() {
            Function<Map<C, V1>, Map<C, V2>> r0 = new AnonymousClass2(this);
            return Maps.transformValues(this.fromTable.rowMap(), r0);
        }

        @Override // com.google.common.collect.Table
        public Map<C, Map<R, V2>> columnMap() {
            Function<Map<R, V1>, Map<R, V2>> r0 = new AnonymousClass3(this);
            return Maps.transformValues(this.fromTable.columnMap(), r0);
        }
    }

    private static class TransposeTable<C, R, V> extends AbstractTable<C, R, V> {
        private static final Function<Table.Cell<?, ?, ?>, Table.Cell<?, ?, ?>> TRANSPOSE_CELL = null;
        final Table<R, C, V> original;

        TransposeTable(Table<R, C, V> r1) {
            this.original = (Table) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public void clear() {
            this.original.clear();
        }

        @Override // com.google.common.collect.Table
        public Map<C, V> column(@ParametricNullness R r1) {
            return this.original.row(r1);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public Set<R> columnKeySet() {
            return this.original.rowKeySet();
        }

        @Override // com.google.common.collect.Table
        public Map<R, Map<C, V>> columnMap() {
            return this.original.rowMap();
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public boolean contains(@CheckForNull Object r1, @CheckForNull Object r2) {
            return this.original.contains(r2, r1);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public boolean containsColumn(@CheckForNull Object r1) {
            return this.original.containsRow(r1);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public boolean containsRow(@CheckForNull Object r1) {
            return this.original.containsColumn(r1);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public boolean containsValue(@CheckForNull Object r1) {
            return this.original.containsValue(r1);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        @CheckForNull
        public V get(@CheckForNull Object r1, @CheckForNull Object r2) {
            return this.original.get(r2, r1);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        @CheckForNull
        public V put(@ParametricNullness C r1, @ParametricNullness R r2, @ParametricNullness V r3) {
            return this.original.put(r2, r1, r3);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public void putAll(Table<? extends C, ? extends R, ? extends V> r1) {
            this.original.putAll(Tables.transpose(r1));
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        @CheckForNull
        public V remove(@CheckForNull Object r1, @CheckForNull Object r2) {
            return this.original.remove(r2, r1);
        }

        @Override // com.google.common.collect.Table
        public Map<R, V> row(@ParametricNullness C r1) {
            return this.original.column(r1);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public Set<C> rowKeySet() {
            return this.original.columnKeySet();
        }

        @Override // com.google.common.collect.Table
        public Map<C, Map<R, V>> rowMap() {
            return this.original.columnMap();
        }

        @Override // com.google.common.collect.Table
        public int size() {
            return this.original.size();
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public Collection<V> values() {
            return this.original.values();
        }

        static {
            TRANSPOSE_CELL = new AnonymousClass1();
        }

        @Override // com.google.common.collect.AbstractTable
        Iterator<Table.Cell<C, R, V>> cellIterator() {
            return Iterators.transform(this.original.cellSet().iterator(), TRANSPOSE_CELL);
        }

        @Override // com.google.common.collect.AbstractTable
        Spliterator<Table.Cell<C, R, V>> cellSpliterator() {
            return CollectSpliterators.map(this.original.cellSet().spliterator(), TRANSPOSE_CELL);
        }
    }

    static final class UnmodifiableRowSortedMap<R, C, V> extends UnmodifiableTable<R, C, V> implements RowSortedTable<R, C, V> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ForwardingTable, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Table delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ForwardingTable, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public /* bridge */ /* synthetic */ Set rowKeySet() {
            return rowKeySet();
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public /* bridge */ /* synthetic */ Map rowMap() {
            return rowMap();
        }

        public UnmodifiableRowSortedMap(RowSortedTable<R, ? extends C, ? extends V> r1) {
            super(r1);
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ForwardingTable, com.google.common.collect.ForwardingObject
        protected RowSortedTable<R, C, V> delegate() {
            return (RowSortedTable) super.delegate();
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public SortedMap<R, Map<C, V>> rowMap() {
            Function r0 = Tables.access$000();
            return Collections.unmodifiableSortedMap(Maps.transformValues(delegate().rowMap(), r0));
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public SortedSet<R> rowKeySet() {
            return Collections.unmodifiableSortedSet(delegate().rowKeySet());
        }
    }

    private static class UnmodifiableTable<R, C, V> extends ForwardingTable<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final Table<? extends R, ? extends C, ? extends V> delegate;

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        UnmodifiableTable(Table<? extends R, ? extends C, ? extends V> r1) {
            this.delegate = (Table) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.ForwardingObject
        protected Table<R, C, V> delegate() {
            return this.delegate;
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Set<Table.Cell<R, C, V>> cellSet() {
            return Collections.unmodifiableSet(super.cellSet());
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Map<R, V> column(@ParametricNullness C r1) {
            return Collections.unmodifiableMap(super.column(r1));
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Set<C> columnKeySet() {
            return Collections.unmodifiableSet(super.columnKeySet());
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Map<C, Map<R, V>> columnMap() {
            Function r0 = Tables.access$000();
            return Collections.unmodifiableMap(Maps.transformValues(super.columnMap(), r0));
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        @CheckForNull
        public V put(@ParametricNullness R r1, @ParametricNullness C r2, @ParametricNullness V r3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public void putAll(Table<? extends R, ? extends C, ? extends V> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        @CheckForNull
        public V remove(@CheckForNull Object r1, @CheckForNull Object r2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Map<C, V> row(@ParametricNullness R r1) {
            return Collections.unmodifiableMap(super.row(r1));
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Set<R> rowKeySet() {
            return Collections.unmodifiableSet(super.rowKeySet());
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Map<R, Map<C, V>> rowMap() {
            Function r0 = Tables.access$000();
            return Collections.unmodifiableMap(Maps.transformValues(super.rowMap(), r0));
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Collection<V> values() {
            return Collections.unmodifiableCollection(super.values());
        }
    }

    static /* synthetic */ Function access$000() {
        return unmodifiableWrapper();
    }

    private Tables() {
    }

    public static <T, R, C, V, I extends Table<R, C, V>> Collector<T, ?, I> toTable(java.util.function.Function<? super T, ? extends R> r0, java.util.function.Function<? super T, ? extends C> r1, java.util.function.Function<? super T, ? extends V> r2, Supplier<I> r3) {
        return TableCollectors.toTable(r0, r1, r2, r3);
    }

    public static <T, R, C, V, I extends Table<R, C, V>> Collector<T, ?, I> toTable(java.util.function.Function<? super T, ? extends R> r0, java.util.function.Function<? super T, ? extends C> r1, java.util.function.Function<? super T, ? extends V> r2, BinaryOperator<V> r3, Supplier<I> r4) {
        return TableCollectors.toTable(r0, r1, r2, r3, r4);
    }

    public static <R, C, V> Table.Cell<R, C, V> immutableCell(@ParametricNullness R r1, @ParametricNullness C r2, @ParametricNullness V r3) {
        return new ImmutableCell(r1, r2, r3);
    }

    public static <R, C, V> Table<C, R, V> transpose(Table<R, C, V> r1) {
        if ((r1 instanceof TransposeTable) == false) goto L6;
        return ((TransposeTable) r1).original;
    L6:
        return new TransposeTable(r1);
    }

    public static <R, C, V> Table<R, C, V> newCustomTable(Map<R, Map<C, V>> r1, com.google.common.base.Supplier<? extends Map<C, V>> r2) {
        Preconditions.checkArgument(r1.isEmpty());
        Preconditions.checkNotNull(r2);
        return new StandardTable(r1, r2);
    }

    public static <R, C, V1, V2> Table<R, C, V2> transformValues(Table<R, C, V1> r1, Function<? super V1, V2> r2) {
        return new TransformedTable(r1, r2);
    }

    public static <R, C, V> Table<R, C, V> unmodifiableTable(Table<? extends R, ? extends C, ? extends V> r1) {
        return new UnmodifiableTable(r1);
    }

    public static <R, C, V> RowSortedTable<R, C, V> unmodifiableRowSortedTable(RowSortedTable<R, ? extends C, ? extends V> r1) {
        return new UnmodifiableRowSortedMap(r1);
    }

    private static <K, V> Function<Map<K, V>, Map<K, V>> unmodifiableWrapper() {
        return (Function<Map<K, V>, Map<K, V>>) UNMODIFIABLE_WRAPPER;
    }

    static {
        UNMODIFIABLE_WRAPPER = new AnonymousClass1();
    }

    public static <R, C, V> Table<R, C, V> synchronizedTable(Table<R, C, V> r1) {
        return Synchronized.table(r1, null);
    }

    static boolean equalsImpl(Table<?, ?, ?> r1, @CheckForNull Object r2) {
        if (r2 != r1) goto L6;
        return true;
    L6:
        if ((r2 instanceof Table) == true) goto L8;
        return false;
    L8:
        return r1.cellSet().equals(((Table) r2).cellSet());
    }
}
