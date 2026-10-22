package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class RegularImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {

    private final class CellSet extends IndexedImmutableSet<Table.Cell<R, C, V>> {
        final /* synthetic */ RegularImmutableTable this$0;

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        private CellSet(RegularImmutableTable r1) {
            this.this$0 = r1;
        }

        /* synthetic */ CellSet(RegularImmutableTable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size();
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        Table.Cell<R, C, V> get(int r1) {
            return this.this$0.getCell(r1);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r4) {
            if ((r4 instanceof Table.Cell) == false) goto L10;
            Table.Cell r5 = (Table.Cell) r4;
            Object r3 = this.this$0.get(r5.getRowKey(), r5.getColumnKey());
            if (r3 != null) goto L7;
            return false;
        L7:
            if (r3.equals(r5.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }
    }

    private final class Values extends ImmutableList<V> {
        final /* synthetic */ RegularImmutableTable this$0;

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        private Values(RegularImmutableTable r1) {
            this.this$0 = r1;
        }

        /* synthetic */ Values(RegularImmutableTable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.this$0.size();
        }

        @Override // java.util.List
        public V get(int r1) {
            return (V) this.this$0.getValue(r1);
        }
    }

    abstract Table.Cell<R, C, V> getCell(int r1);

    abstract V getValue(int r1);

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    /* bridge */ /* synthetic */ Set createCellSet() {
        return createCellSet();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    /* bridge */ /* synthetic */ Collection createValues() {
        return createValues();
    }

    RegularImmutableTable() {
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    final ImmutableSet<Table.Cell<R, C, V>> createCellSet() {
        if (isEmpty() == false) goto L6;
        return ImmutableSet.of();
    L6:
        return new CellSet(this, null);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    final ImmutableCollection<V> createValues() {
        if (isEmpty() == false) goto L6;
        return ImmutableList.of();
    L6:
        return new Values(this, null);
    }

    static <R, C, V> RegularImmutableTable<R, C, V> forCells(List<Table.Cell<R, C, V>> r1, @CheckForNull final Comparator<? super R> r2, @CheckForNull final Comparator<? super C> r3) {
        Preconditions.checkNotNull(r1);
        if (r2 != null) goto L5;
        if (r3 != null) goto L5;
    L7:
        return forCellsInternal(r1, r2, r3);
    L5:
        Collections.sort(r1, new AnonymousClass1(r2, r3));
        goto L7
    }

    static <R, C, V> RegularImmutableTable<R, C, V> forCells(Iterable<Table.Cell<R, C, V>> r1) {
        return forCellsInternal(r1, null, null);
    }

    private static <R, C, V> RegularImmutableTable<R, C, V> forCellsInternal(Iterable<Table.Cell<R, C, V>> r5, @CheckForNull Comparator<? super R> r6, @CheckForNull Comparator<? super C> r7) {
        LinkedHashSet r0 = new LinkedHashSet();
        LinkedHashSet r1 = new LinkedHashSet();
        ImmutableList r2 = ImmutableList.copyOf(r5);
        Iterator<Table.Cell<R, C, V>> r8 = r5.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Table.Cell<R, C, V> r3 = r8.next();
        r0.add(r3.getRowKey());
        r1.add(r3.getColumnKey());
        goto L4
    L6:
        if (r6 != null) goto L8;
        ImmutableSet r9 = ImmutableSet.copyOf(r0);
    L9:
        if (r7 != null) goto L11;
        ImmutableSet r10 = ImmutableSet.copyOf(r1);
    L13:
        return forOrderedComponents(r2, r9, r10);
    L11:
        r10 = ImmutableSet.copyOf(ImmutableList.sortedCopyOf(r7, r1));
        goto L13
    L8:
        r9 = ImmutableSet.copyOf(ImmutableList.sortedCopyOf(r6, r0));
        goto L9
    }

    static <R, C, V> RegularImmutableTable<R, C, V> forOrderedComponents(ImmutableList<Table.Cell<R, C, V>> r6, ImmutableSet<R> r7, ImmutableSet<C> r8) {
        if (r6.size() <= ((((long) r7.size()) * ((long) r8.size())) / 2)) goto L6;
        return new DenseImmutableTable(r6, r7, r8);
    L6:
        return new SparseImmutableTable(r6, r7, r8);
    }

    final void checkNoDuplicate(R r7, C r8, @CheckForNull V r9, V r10) {
        if (r9 != null) goto L4;
        boolean r6 = true;
    L5:
        Preconditions.checkArgument(r6, "Duplicate key: (row=%s, column=%s), values: [%s, %s].", r7, r8, r10, r9);
        return;
    L4:
        r6 = false;
        goto L5
    }
}
