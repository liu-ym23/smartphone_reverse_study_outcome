package com.google.common.collect;

import android.icu.lang.UCharacter;
import com.android.settings.utils.HanziToPinyin;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class ArrayTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    private final V[][] array;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableList<C> columnList;

    @CheckForNull
    private transient ArrayTable<R, C, V>.ColumnMap columnMap;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableList<R> rowList;

    @CheckForNull
    private transient ArrayTable<R, C, V>.RowMap rowMap;

    private static abstract class ArrayMap<K, V> extends Maps.IteratorBasedAbstractMap<K, V> {
        private final ImmutableMap<K, Integer> keyIndex;

        abstract String getKeyRole();

        @ParametricNullness
        abstract V getValue(int r1);

        @ParametricNullness
        abstract V setValue(int r1, @ParametricNullness V r2);

        /* synthetic */ ArrayMap(ImmutableMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        private ArrayMap(ImmutableMap<K, Integer> r1) {
            this.keyIndex = r1;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.keyIndex.keySet();
        }

        K getKey(int r1) {
            return this.keyIndex.keySet().asList().get(r1);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.keyIndex.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.keyIndex.isEmpty();
        }

        Map.Entry<K, V> getEntry(final int r2) {
            Preconditions.checkElementIndex(r2, size());
            return new AnonymousClass1(this, r2);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        Iterator<Map.Entry<K, V>> entryIterator() {
            final int r1 = size();
            return new AnonymousClass2(this, r1);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        Spliterator<Map.Entry<K, V>> entrySpliterator() {
            return CollectSpliterators.indexed(size(), 16, new ArrayTable$ArrayMap$$ExternalSyntheticLambda0(this));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object r1) {
            return this.keyIndex.containsKey(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V get(@CheckForNull Object r2) {
            Integer r3 = this.keyIndex.get(r2);
            if (r3 != null) goto L7;
            return null;
        L7:
            return getValue(r3.intValue());
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V put(K r4, @ParametricNullness V r5) {
            Integer r0 = this.keyIndex.get(r4);
            if (r0 != null) goto L5;
            String r1 = getKeyRole();
            String r6 = String.valueOf(r4);
            String r3 = String.valueOf(this.keyIndex.keySet());
            throw new IllegalArgumentException(new StringBuilder(((String.valueOf(r1).length() + 9) + String.valueOf(r6).length()) + String.valueOf(r3).length()).append(r1).append(HanziToPinyin.Token.SEPARATOR).append(r6).append(" not in ").append(r3).toString());
        L5:
            return setValue(r0.intValue(), r5);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V remove(@CheckForNull Object r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }
    }

    private class Column extends ArrayMap<R, V> {
        final int columnIndex;
        final /* synthetic */ ArrayTable this$0;

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        String getKeyRole() {
            return "Row";
        }

        Column(ArrayTable r2, int r3) {
            this.this$0 = r2;
            super(ArrayTable.access$300(r2), null);
            this.columnIndex = r3;
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        @CheckForNull
        V getValue(int r2) {
            return (V) this.this$0.at(r2, this.columnIndex);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        @CheckForNull
        V setValue(int r2, @CheckForNull V r3) {
            return (V) this.this$0.set(r2, this.columnIndex, r3);
        }
    }

    private class ColumnMap extends ArrayMap<C, Map<R, V>> {
        final /* synthetic */ ArrayTable this$0;

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        String getKeyRole() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        /* bridge */ /* synthetic */ Object getValue(int r1) {
            return getValue(r1);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap, java.util.AbstractMap, java.util.Map
        @CheckForNull
        public /* bridge */ /* synthetic */ Object put(Object r1, Object r2) {
            return put(r1, (Map) r2);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        /* bridge */ /* synthetic */ Object setValue(int r1, Object r2) {
            return setValue(r1, (Map) r2);
        }

        /* synthetic */ ColumnMap(ArrayTable r1, AnonymousClass1 r2) {
            this(r1);
        }

        private ColumnMap(ArrayTable r2) {
            this.this$0 = r2;
            super(ArrayTable.access$600(r2), null);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        Map<R, V> getValue(int r2) {
            return new Column(this.this$0, r2);
        }

        Map<R, V> setValue(int r1, Map<R, V> r2) {
            throw new UnsupportedOperationException();
        }

        @CheckForNull
        public Map<R, V> put(C r1, Map<R, V> r2) {
            throw new UnsupportedOperationException();
        }
    }

    private class Row extends ArrayMap<C, V> {
        final int rowIndex;
        final /* synthetic */ ArrayTable this$0;

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        String getKeyRole() {
            return "Column";
        }

        Row(ArrayTable r2, int r3) {
            this.this$0 = r2;
            super(ArrayTable.access$600(r2), null);
            this.rowIndex = r3;
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        @CheckForNull
        V getValue(int r2) {
            return (V) this.this$0.at(this.rowIndex, r2);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        @CheckForNull
        V setValue(int r2, @CheckForNull V r3) {
            return (V) this.this$0.set(this.rowIndex, r2, r3);
        }
    }

    private class RowMap extends ArrayMap<R, Map<C, V>> {
        final /* synthetic */ ArrayTable this$0;

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        String getKeyRole() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        /* bridge */ /* synthetic */ Object getValue(int r1) {
            return getValue(r1);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap, java.util.AbstractMap, java.util.Map
        @CheckForNull
        public /* bridge */ /* synthetic */ Object put(Object r1, Object r2) {
            return put(r1, (Map) r2);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        /* bridge */ /* synthetic */ Object setValue(int r1, Object r2) {
            return setValue(r1, (Map) r2);
        }

        /* synthetic */ RowMap(ArrayTable r1, AnonymousClass1 r2) {
            this(r1);
        }

        private RowMap(ArrayTable r2) {
            this.this$0 = r2;
            super(ArrayTable.access$300(r2), null);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        Map<C, V> getValue(int r2) {
            return new Row(this.this$0, r2);
        }

        Map<C, V> setValue(int r1, Map<C, V> r2) {
            throw new UnsupportedOperationException();
        }

        @CheckForNull
        public Map<C, V> put(R r1, Map<C, V> r2) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$yqJBEUhtD7sOM-8hNQp9h3Mi57Y, reason: not valid java name */
    public static /* synthetic */ Object m893$r8$lambda$yqJBEUhtD7sOM8hNQp9h3Mi57Y(ArrayTable r0, int r1) {
        return r0.getValue(r1);
    }

    public static /* synthetic */ Table.Cell $r8$lambda$zTKS5BxTstixK4BzUflA6FnJJlE(ArrayTable r0, int r1) {
        return r0.getCell(r1);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return columnKeySet();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object r1) {
        return super.equals(r1);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return rowKeySet();
    }

    @Override // com.google.common.collect.AbstractTable
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    static /* synthetic */ Table.Cell access$000(ArrayTable r0, int r1) {
        return r0.getCell(r1);
    }

    static /* synthetic */ ImmutableList access$100(ArrayTable r0) {
        return r0.columnList;
    }

    static /* synthetic */ ImmutableList access$200(ArrayTable r0) {
        return r0.rowList;
    }

    static /* synthetic */ ImmutableMap access$300(ArrayTable r0) {
        return r0.rowKeyToIndex;
    }

    static /* synthetic */ ImmutableMap access$600(ArrayTable r0) {
        return r0.columnKeyToIndex;
    }

    static /* synthetic */ Object access$800(ArrayTable r0, int r1) {
        return r0.getValue(r1);
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> r1, Iterable<? extends C> r2) {
        return new ArrayTable(r1, r2);
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Table<R, C, ? extends V> r1) {
        if ((r1 instanceof ArrayTable) == false) goto L6;
        return new ArrayTable((ArrayTable) r1);
    L6:
        return new ArrayTable(r1);
    }

    private ArrayTable(Iterable<? extends R> r5, Iterable<? extends C> r6) {
        ImmutableList<R> r7 = ImmutableList.copyOf(r5);
        this.rowList = r7;
        ImmutableList<C> r8 = ImmutableList.copyOf(r6);
        this.columnList = r8;
        if (r7.isEmpty() != r8.isEmpty()) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        this.rowKeyToIndex = Maps.indexMap(r7);
        this.columnKeyToIndex = Maps.indexMap(r8);
        this.array = (V[][]) ((Object[][]) Array.newInstance(Object.class, new int[]{r7.size(), r8.size()}));
        eraseAll();
        return;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ArrayTable(Table<R, C, ? extends V> r3) {
        this(r3.rowKeySet(), r3.columnKeySet());
        putAll(r3);
    }

    private ArrayTable(ArrayTable<R, C, V> r7) {
        ImmutableList<R> r0 = r7.rowList;
        this.rowList = r0;
        ImmutableList<C> r1 = r7.columnList;
        this.columnList = r1;
        this.rowKeyToIndex = r7.rowKeyToIndex;
        this.columnKeyToIndex = r7.columnKeyToIndex;
        V[][] r2 = (V[][]) ((Object[][]) Array.newInstance(Object.class, new int[]{r0.size(), r1.size()}));
        this.array = r2;
        int r3 = 0;
    L4:
        if (r3 >= this.rowList.size()) goto L6;
        V[] r4 = r7.array[r3];
        System.arraycopy(r4, 0, r2[r3], 0, r4.length);
        r3 = r3 + 1;
        goto L4
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    @CheckForNull
    public V at(int r2, int r3) {
        Preconditions.checkElementIndex(r2, this.rowList.size());
        Preconditions.checkElementIndex(r3, this.columnList.size());
        return this.array[r2][r3];
    }

    @CheckForNull
    public V set(int r2, int r3, @CheckForNull V r4) {
        Preconditions.checkElementIndex(r2, this.rowList.size());
        Preconditions.checkElementIndex(r3, this.columnList.size());
        V[] r1 = this.array[r2];
        V r5 = r1[r3];
        r1[r3] = r4;
        return r5;
    }

    public V[][] toArray(Class<V> r6) {
        V[][] r7 = (V[][]) ((Object[][]) Array.newInstance(r6, new int[]{this.rowList.size(), this.columnList.size()}));
        int r0 = 0;
    L4:
        if (r0 >= this.rowList.size()) goto L6;
        V[] r1 = this.array[r0];
        System.arraycopy(r1, 0, r7[r0], 0, r1.length);
        r0 = r0 + 1;
        goto L4
    L6:
        return r7;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public void eraseAll() {
        V[][] r4 = this.array;
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Arrays.fill(r4[r1], null);
        r1 = r1 + 1;
        goto L3
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean contains(@CheckForNull Object r1, @CheckForNull Object r2) {
        if (containsRow(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (containsColumn(r2) == false) goto L7;
        return true;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsColumn(@CheckForNull Object r1) {
        return this.columnKeyToIndex.containsKey(r1);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsRow(@CheckForNull Object r1) {
        return this.rowKeyToIndex.containsKey(r1);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsValue(@CheckForNull Object r8) {
        V[][] r7 = this.array;
        int r0 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        V[] r3 = r7[r2];
        int r4 = r3.length;
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L11;
        if (Objects.equal(r8, r3[r5]) == true) goto L8;
        r5 = r5 + 1;
        goto L5
    L8:
        return true;
    L11:
        r2 = r2 + 1;
        goto L3
    L12:
        return false;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CheckForNull
    public V get(@CheckForNull Object r2, @CheckForNull Object r3) {
        Integer r4 = this.rowKeyToIndex.get(r2);
        Integer r5 = this.columnKeyToIndex.get(r3);
        if (r4 == null) goto L7;
        if (r5 == null) goto L7;
        return at(r4.intValue(), r5.intValue());
    L7:
        return null;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean isEmpty() {
        if (this.rowList.isEmpty() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.columnList.isEmpty() == true) goto L8;
        return false;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CheckForNull
    public V put(R r7, C r8, @CheckForNull V r9) {
        Preconditions.checkNotNull(r7);
        Preconditions.checkNotNull(r8);
        Integer r0 = this.rowKeyToIndex.get(r7);
        boolean r1 = true;
        if (r0 == null) goto L5;
        boolean r3 = true;
    L6:
        Preconditions.checkArgument(r3, "Row %s not in %s", r7, this.rowList);
        Integer r10 = this.columnKeyToIndex.get(r8);
        if (r10 != null) goto L10;
        r1 = false;
    L10:
        Preconditions.checkArgument(r1, "Column %s not in %s", r8, this.columnList);
        return set(r0.intValue(), r10.intValue(), r9);
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public void putAll(Table<? extends R, ? extends C, ? extends V> r1) {
        super.putAll(r1);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CheckForNull
    @Deprecated
    public V remove(@CheckForNull Object r1, @CheckForNull Object r2) {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    public V erase(@CheckForNull Object r2, @CheckForNull Object r3) {
        Integer r4 = this.rowKeyToIndex.get(r2);
        Integer r5 = this.columnKeyToIndex.get(r3);
        if (r4 == null) goto L8;
        if (r5 == null) goto L8;
        return set(r4.intValue(), r5.intValue(), null);
    L8:
        return null;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.AbstractTable
    Iterator<Table.Cell<R, C, V>> cellIterator() {
        final int r1 = size();
        return new AnonymousClass1(this, r1);
    }

    @Override // com.google.common.collect.AbstractTable
    Spliterator<Table.Cell<R, C, V>> cellSpliterator() {
        return CollectSpliterators.indexed(size(), UCharacter.UnicodeBlock.TANGUT_COMPONENTS_ID, new ArrayTable$$ExternalSyntheticLambda1(this));
    }

    private Table.Cell<R, C, V> getCell(final int r2) {
        return new AnonymousClass2(this, r2);
    }

    @CheckForNull
    private V getValue(int r3) {
        return at(r3 / this.columnList.size(), r3 % this.columnList.size());
    }

    @Override // com.google.common.collect.Table
    public Map<R, V> column(C r2) {
        Preconditions.checkNotNull(r2);
        Integer r3 = this.columnKeyToIndex.get(r2);
        if (r3 != null) goto L7;
        return Collections.emptyMap();
    L7:
        return new Column(this, r3.intValue());
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        ArrayTable<R, C, V>.ColumnMap r0 = this.columnMap;
        if (r0 != null) goto L6;
        ArrayTable<R, C, V>.ColumnMap r1 = new ColumnMap(this, null);
        this.columnMap = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.Table
    public Map<C, V> row(R r2) {
        Preconditions.checkNotNull(r2);
        Integer r3 = this.rowKeyToIndex.get(r2);
        if (r3 != null) goto L7;
        return Collections.emptyMap();
    L7:
        return new Row(this, r3.intValue());
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.Table
    public Map<R, Map<C, V>> rowMap() {
        ArrayTable<R, C, V>.RowMap r0 = this.rowMap;
        if (r0 != null) goto L6;
        ArrayTable<R, C, V>.RowMap r1 = new RowMap(this, null);
        this.rowMap = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Collection<V> values() {
        return super.values();
    }

    @Override // com.google.common.collect.AbstractTable
    Iterator<V> valuesIterator() {
        final int r1 = size();
        return new AnonymousClass3(this, r1);
    }

    @Override // com.google.common.collect.AbstractTable
    Spliterator<V> valuesSpliterator() {
        return CollectSpliterators.indexed(size(), 16, new ArrayTable$$ExternalSyntheticLambda0(this));
    }
}
