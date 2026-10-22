package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class ImmutableTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {

    @DoNotMock
    public static final class Builder<R, C, V> {
        private final List<Table.Cell<R, C, V>> cells;

        @CheckForNull
        private Comparator<? super C> columnComparator;

        @CheckForNull
        private Comparator<? super R> rowComparator;

        public Builder() {
            this.cells = Lists.newArrayList();
        }

        public Builder<R, C, V> orderRowsBy(Comparator<? super R> r2) {
            this.rowComparator = (Comparator) Preconditions.checkNotNull(r2, "rowComparator");
            return this;
        }

        public Builder<R, C, V> orderColumnsBy(Comparator<? super C> r2) {
            this.columnComparator = (Comparator) Preconditions.checkNotNull(r2, "columnComparator");
            return this;
        }

        public Builder<R, C, V> put(R r2, C r3, V r4) {
            this.cells.add(ImmutableTable.cellOf(r2, r3, r4));
            return this;
        }

        public Builder<R, C, V> put(Table.Cell<? extends R, ? extends C, ? extends V> r3) {
            if ((r3 instanceof Tables.ImmutableCell) == false) goto L5;
            Preconditions.checkNotNull(r3.getRowKey(), "row");
            Preconditions.checkNotNull(r3.getColumnKey(), "column");
            Preconditions.checkNotNull(r3.getValue(), "value");
            this.cells.add(r3);
        L6:
            return this;
        L5:
            put(r3.getRowKey(), r3.getColumnKey(), r3.getValue());
            goto L6
        }

        public Builder<R, C, V> putAll(Table<? extends R, ? extends C, ? extends V> r2) {
            Iterator<Table.Cell<? extends R, ? extends C, ? extends V>> r3 = r2.cellSet().iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            put(r3.next());
            goto L4
        L6:
            return this;
        }

        Builder<R, C, V> combine(Builder<R, C, V> r2) {
            this.cells.addAll(r2.cells);
            return this;
        }

        public ImmutableTable<R, C, V> build() {
            return buildOrThrow();
        }

        public ImmutableTable<R, C, V> buildOrThrow() {
            int r0 = this.cells.size();
            if (r0 == 0) goto L11;
            if (r0 == 1) goto L9;
            return RegularImmutableTable.forCells(this.cells, this.rowComparator, this.columnComparator);
        L9:
            return new SingletonImmutableTable((Table.Cell) Iterables.getOnlyElement(this.cells));
        L11:
            return ImmutableTable.of();
        }
    }

    static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final int[] cellColumnIndices;
        private final int[] cellRowIndices;
        private final Object[] cellValues;
        private final Object[] columnKeys;
        private final Object[] rowKeys;

        private SerializedForm(Object[] r1, Object[] r2, Object[] r3, int[] r4, int[] r5) {
            this.rowKeys = r1;
            this.columnKeys = r2;
            this.cellValues = r3;
            this.cellRowIndices = r4;
            this.cellColumnIndices = r5;
        }

        static SerializedForm create(ImmutableTable<?, ?, ?> r7, int[] r8, int[] r9) {
            return new SerializedForm(r7.rowKeySet().toArray(), r7.columnKeySet().toArray(), r7.values().toArray(), r8, r9);
        }

        Object readResolve() {
            Object[] r0 = this.cellValues;
            if (r0.length == 0) goto L5;
            int r3 = 0;
            if (r0.length == 1) goto L9;
            ImmutableList.Builder r1 = new ImmutableList.Builder(this.cellValues.length);
        L11:
            Object[] r2 = this.cellValues;
            if (r3 >= r2.length) goto L15;
            r1.add(ImmutableTable.cellOf(this.rowKeys[this.cellRowIndices[r3]], this.columnKeys[this.cellColumnIndices[r3]], r2[r3]));
            r3 = r3 + 1;
            goto L11
        L15:
            return RegularImmutableTable.forOrderedComponents(r1.build(), ImmutableSet.copyOf(this.rowKeys), ImmutableSet.copyOf(this.columnKeys));
        L9:
            return ImmutableTable.of(this.rowKeys[0], this.columnKeys[0], r0[0]);
        L5:
            return ImmutableTable.of();
        }
    }

    @Override // com.google.common.collect.Table
    public abstract ImmutableMap<C, Map<R, V>> columnMap();

    @Override // com.google.common.collect.AbstractTable
    abstract ImmutableSet<Table.Cell<R, C, V>> createCellSet();

    abstract SerializedForm createSerializedForm();

    @Override // com.google.common.collect.AbstractTable
    abstract ImmutableCollection<V> createValues();

    @Override // com.google.common.collect.Table
    public abstract ImmutableMap<R, Map<C, V>> rowMap();

    @Override // com.google.common.collect.AbstractTable
    /* bridge */ /* synthetic */ Iterator cellIterator() {
        return cellIterator();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set cellSet() {
        return cellSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map column(Object r1) {
        return column(r1);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return columnKeySet();
    }

    @Override // com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map columnMap() {
        return columnMap();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsColumn(@CheckForNull Object r1) {
        return super.containsColumn(r1);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsRow(@CheckForNull Object r1) {
        return super.containsRow(r1);
    }

    @Override // com.google.common.collect.AbstractTable
    /* bridge */ /* synthetic */ Set createCellSet() {
        return createCellSet();
    }

    @Override // com.google.common.collect.AbstractTable
    /* bridge */ /* synthetic */ Collection createValues() {
        return createValues();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object r1) {
        return super.equals(r1);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CheckForNull
    public /* bridge */ /* synthetic */ Object get(@CheckForNull Object r1, @CheckForNull Object r2) {
        return super.get(r1, r2);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map row(Object r1) {
        return row(r1);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return rowKeySet();
    }

    @Override // com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map rowMap() {
        return rowMap();
    }

    @Override // com.google.common.collect.AbstractTable
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public static <T, R, C, V> Collector<T, ?, ImmutableTable<R, C, V>> toImmutableTable(Function<? super T, ? extends R> r0, Function<? super T, ? extends C> r1, Function<? super T, ? extends V> r2) {
        return TableCollectors.toImmutableTable(r0, r1, r2);
    }

    public static <T, R, C, V> Collector<T, ?, ImmutableTable<R, C, V>> toImmutableTable(Function<? super T, ? extends R> r0, Function<? super T, ? extends C> r1, Function<? super T, ? extends V> r2, BinaryOperator<V> r3) {
        return TableCollectors.toImmutableTable(r0, r1, r2, r3);
    }

    public static <R, C, V> ImmutableTable<R, C, V> of() {
        return (ImmutableTable<R, C, V>) SparseImmutableTable.EMPTY;
    }

    public static <R, C, V> ImmutableTable<R, C, V> of(R r1, C r2, V r3) {
        return new SingletonImmutableTable(r1, r2, r3);
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(Table<? extends R, ? extends C, ? extends V> r1) {
        if ((r1 instanceof ImmutableTable) == false) goto L7;
        return (ImmutableTable) r1;
    L7:
        return copyOf(r1.cellSet());
    }

    static <R, C, V> ImmutableTable<R, C, V> copyOf(Iterable<? extends Table.Cell<? extends R, ? extends C, ? extends V>> r2) {
        Builder r0 = builder();
        Iterator<? extends Table.Cell<? extends R, ? extends C, ? extends V>> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        r0.put(r3.next());
        goto L4
    L7:
        return r0.build();
    }

    public static <R, C, V> Builder<R, C, V> builder() {
        return new Builder();
    }

    static <R, C, V> Table.Cell<R, C, V> cellOf(R r1, C r2, V r3) {
        return Tables.immutableCell(Preconditions.checkNotNull(r1, "rowKey"), Preconditions.checkNotNull(r2, "columnKey"), Preconditions.checkNotNull(r3, "value"));
    }

    ImmutableTable() {
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public ImmutableSet<Table.Cell<R, C, V>> cellSet() {
        return (ImmutableSet) super.cellSet();
    }

    @Override // com.google.common.collect.AbstractTable
    final UnmodifiableIterator<Table.Cell<R, C, V>> cellIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractTable
    final Spliterator<Table.Cell<R, C, V>> cellSpliterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    @Override // com.google.common.collect.AbstractTable
    final Iterator<V> valuesIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.Table
    public ImmutableMap<R, V> column(C r2) {
        Preconditions.checkNotNull(r2, "columnKey");
        return (ImmutableMap) MoreObjects.firstNonNull((ImmutableMap) columnMap().get(r2), ImmutableMap.of());
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public ImmutableSet<C> columnKeySet() {
        return columnMap().keySet();
    }

    @Override // com.google.common.collect.Table
    public ImmutableMap<C, V> row(R r2) {
        Preconditions.checkNotNull(r2, "rowKey");
        return (ImmutableMap) MoreObjects.firstNonNull((ImmutableMap) rowMap().get(r2), ImmutableMap.of());
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public ImmutableSet<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean contains(@CheckForNull Object r1, @CheckForNull Object r2) {
        if (get(r1, r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsValue(@CheckForNull Object r1) {
        return values().contains(r1);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CheckForNull
    @Deprecated
    public final V put(R r1, C r2, V r3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @Deprecated
    public final void putAll(Table<? extends R, ? extends C, ? extends V> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CheckForNull
    @Deprecated
    public final V remove(@CheckForNull Object r1, @CheckForNull Object r2) {
        throw new UnsupportedOperationException();
    }

    final Object writeReplace() {
        return createSerializedForm();
    }
}
