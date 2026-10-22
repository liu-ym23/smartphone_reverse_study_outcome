package com.google.common.collect;

import androidx.exifinterface.media.ExifInterface;
import com.google.errorprone.annotations.Immutable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@Immutable(containerOf = {"R", "C", ExifInterface.GPS_MEASUREMENT_INTERRUPTED})
@ElementTypesAreNonnullByDefault
final class SparseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    static final ImmutableTable<Object, Object, Object> EMPTY = null;
    private final int[] cellColumnInRowIndices;
    private final int[] cellRowIndices;
    private final ImmutableMap<C, ImmutableMap<R, V>> columnMap;
    private final ImmutableMap<R, ImmutableMap<C, V>> rowMap;

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map columnMap() {
        return columnMap();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map rowMap() {
        return rowMap();
    }

    static {
        EMPTY = new SparseImmutableTable(ImmutableList.of(), ImmutableSet.of(), ImmutableSet.of());
    }

    /* JADX WARN: Multi-variable type inference failed */
    SparseImmutableTable(ImmutableList<Table.Cell<R, C, V>> r10, ImmutableSet<R> r11, ImmutableSet<C> r12) {
        ImmutableMap r0 = Maps.indexMap(r11);
        LinkedHashMap r1 = Maps.newLinkedHashMap();
        UnmodifiableIterator<R> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r1.put(r13.next(), new LinkedHashMap());
        goto L4
    L6:
        LinkedHashMap r14 = Maps.newLinkedHashMap();
        UnmodifiableIterator<C> r15 = r12.iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        r14.put(r15.next(), new LinkedHashMap());
        goto L8
    L10:
        int[] r16 = new int[r10.size()];
        int[] r2 = new int[r10.size()];
        int r3 = 0;
    L12:
        if (r3 >= r10.size()) goto L14;
        Table.Cell<R, C, V> r4 = r10.get(r3);
        R r5 = r4.getRowKey();
        C r6 = r4.getColumnKey();
        V r7 = r4.getValue();
        r16[r3] = ((Integer) Objects.requireNonNull((Integer) r0.get(r5))).intValue();
        Map r8 = (Map) Objects.requireNonNull((Map) r1.get(r5));
        r2[r3] = r8.size();
        checkNoDuplicate(r5, r6, r8.put(r6, r7), r7);
        ((Map) Objects.requireNonNull((Map) r14.get(r6))).put(r5, r7);
        r3 = r3 + 1;
        goto L12
    L14:
        this.cellRowIndices = r16;
        this.cellColumnInRowIndices = r2;
        ImmutableMap.Builder r17 = new ImmutableMap.Builder(r1.size());
        Iterator r18 = r1.entrySet().iterator();
    L16:
        if (r18.hasNext() == false) goto L18;
        Map.Entry r9 = (Map.Entry) r18.next();
        r17.put(r9.getKey(), ImmutableMap.copyOf((Map) r9.getValue()));
        goto L16
    L18:
        this.rowMap = r17.build();
        ImmutableMap.Builder r19 = new ImmutableMap.Builder(r14.size());
        Iterator r110 = r14.entrySet().iterator();
    L20:
        if (r110.hasNext() == false) goto L22;
        Map.Entry r111 = (Map.Entry) r110.next();
        r19.put(r111.getKey(), ImmutableMap.copyOf((Map) r111.getValue()));
        goto L20
    L22:
        this.columnMap = r19.build();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.copyOf(this.columnMap);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.copyOf(this.rowMap);
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.cellRowIndices.length;
    }

    @Override // com.google.common.collect.RegularImmutableTable
    Table.Cell<R, C, V> getCell(int r3) {
        int r0 = this.cellRowIndices[r3];
        Map.Entry<R, ImmutableMap<C, V>> r1 = this.rowMap.entrySet().asList().get(r0);
        ImmutableMap<C, V> r2 = r1.getValue();
        int r4 = this.cellColumnInRowIndices[r3];
        Map.Entry<C, V> r5 = r2.entrySet().asList().get(r4);
        return cellOf(r1.getKey(), r5.getKey(), r5.getValue());
    }

    @Override // com.google.common.collect.RegularImmutableTable
    V getValue(int r3) {
        int r0 = this.cellRowIndices[r3];
        ImmutableMap<C, V> r1 = this.rowMap.values().asList().get(r0);
        int r2 = this.cellColumnInRowIndices[r3];
        return r1.values().asList().get(r2);
    }

    @Override // com.google.common.collect.ImmutableTable
    ImmutableTable.SerializedForm createSerializedForm() {
        ImmutableMap r0 = Maps.indexMap(columnKeySet());
        int[] r1 = new int[cellSet().size()];
        UnmodifiableIterator<Table.Cell<R, C, V>> r2 = cellSet().iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L7;
        r1[r3] = ((Integer) Objects.requireNonNull((Integer) r0.get(r2.next().getColumnKey()))).intValue();
        r3 = r3 + 1;
        goto L4
    L7:
        return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, r1);
    }
}
