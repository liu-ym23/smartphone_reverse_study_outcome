package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class TableCollectors {

    /* JADX INFO: renamed from: com.google.common.collect.TableCollectors$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class ImmutableTableCollectorState<R, C, V> {
        final List<MutableCell<R, C, V>> insertionOrder;
        final Table<R, C, MutableCell<R, C, V>> table;

        private ImmutableTableCollectorState() {
            this.insertionOrder = new ArrayList();
            this.table = HashBasedTable.create();
        }

        /* synthetic */ ImmutableTableCollectorState(AnonymousClass1 r1) {
            this();
        }

        void put(R r2, C r3, V r4, BinaryOperator<V> r5) {
            MutableCell<R, C, V> r0 = this.table.get(r2, r3);
            if (r0 != null) goto L5;
            MutableCell<R, C, V> r6 = new MutableCell(r2, r3, r4);
            this.insertionOrder.add(r6);
            this.table.put(r2, r3, r6);
            return;
        L5:
            r0.merge(r4, r5);
        }

        ImmutableTableCollectorState<R, C, V> combine(ImmutableTableCollectorState<R, C, V> r4, BinaryOperator<V> r5) {
            Iterator<MutableCell<R, C, V>> r6 = r4.insertionOrder.iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            MutableCell<R, C, V> r0 = r6.next();
            put(r0.getRowKey(), r0.getColumnKey(), r0.getValue(), r5);
            goto L4
        L6:
            return this;
        }

        ImmutableTable<R, C, V> toTable() {
            return ImmutableTable.copyOf(this.insertionOrder);
        }
    }

    private static final class MutableCell<R, C, V> extends Tables.AbstractCell<R, C, V> {
        private final C column;
        private final R row;
        private V value;

        MutableCell(R r2, C r3, V r4) {
            this.row = (R) Preconditions.checkNotNull(r2, "row");
            this.column = (C) Preconditions.checkNotNull(r3, "column");
            this.value = (V) Preconditions.checkNotNull(r4, "value");
        }

        @Override // com.google.common.collect.Table.Cell
        public R getRowKey() {
            return this.row;
        }

        @Override // com.google.common.collect.Table.Cell
        public C getColumnKey() {
            return this.column;
        }

        @Override // com.google.common.collect.Table.Cell
        public V getValue() {
            return this.value;
        }

        void merge(V r2, BinaryOperator<V> r3) {
            Preconditions.checkNotNull(r2, "value");
            this.value = (V) Preconditions.checkNotNull(r3.apply(this.value, r2), "mergeFunction.apply");
        }
    }

    static <T, R, C, V> Collector<T, ?, ImmutableTable<R, C, V>> toImmutableTable(final Function<? super T, ? extends R> r2, final Function<? super T, ? extends C> r3, final Function<? super T, ? extends V> r4) {
        Preconditions.checkNotNull(r2, "rowFunction");
        Preconditions.checkNotNull(r3, "columnFunction");
        Preconditions.checkNotNull(r4, "valueFunction");
        return Collector.of(new TableCollectors$$ExternalSyntheticLambda3(), new TableCollectors$$ExternalSyntheticLambda4(r2, r3, r4), new TableCollectors$$ExternalSyntheticLambda5(), new TableCollectors$$ExternalSyntheticLambda6(), new Collector.Characteristics[0]);
    }

    static /* synthetic */ void lambda$toImmutableTable$0(Function r0, Function r1, Function r2, ImmutableTable.Builder r3, Object r4) {
        r3.put(r0.apply(r4), r1.apply(r4), r2.apply(r4));
    }

    static <T, R, C, V> Collector<T, ?, ImmutableTable<R, C, V>> toImmutableTable(final Function<? super T, ? extends R> r2, final Function<? super T, ? extends C> r3, final Function<? super T, ? extends V> r4, final BinaryOperator<V> r5) {
        Preconditions.checkNotNull(r2, "rowFunction");
        Preconditions.checkNotNull(r3, "columnFunction");
        Preconditions.checkNotNull(r4, "valueFunction");
        Preconditions.checkNotNull(r5, "mergeFunction");
        return Collector.of(new TableCollectors$$ExternalSyntheticLambda8(), new TableCollectors$$ExternalSyntheticLambda9(r2, r3, r4, r5), new TableCollectors$$ExternalSyntheticLambda10(r5), new TableCollectors$$ExternalSyntheticLambda1(), new Collector.Characteristics[0]);
    }

    static /* synthetic */ ImmutableTableCollectorState lambda$toImmutableTable$1() {
        return new ImmutableTableCollectorState(null);
    }

    static /* synthetic */ void lambda$toImmutableTable$2(Function r0, Function r1, Function r2, BinaryOperator r3, ImmutableTableCollectorState r4, Object r5) {
        r4.put(r0.apply(r5), r1.apply(r5), r2.apply(r5), r3);
    }

    static /* synthetic */ ImmutableTableCollectorState lambda$toImmutableTable$3(BinaryOperator r0, ImmutableTableCollectorState r1, ImmutableTableCollectorState r2) {
        return r1.combine(r2, r0);
    }

    static /* synthetic */ ImmutableTable lambda$toImmutableTable$4(ImmutableTableCollectorState r0) {
        return r0.toTable();
    }

    static <T, R, C, V, I extends Table<R, C, V>> Collector<T, ?, I> toTable(Function<? super T, ? extends R> r1, Function<? super T, ? extends C> r2, Function<? super T, ? extends V> r3, Supplier<I> r4) {
        return toTable(r1, r2, r3, new TableCollectors$$ExternalSyntheticLambda7(), r4);
    }

    static /* synthetic */ Object lambda$toTable$5(Object r3, Object r4) {
        String r5 = String.valueOf(r3);
        String r6 = String.valueOf(r4);
        throw new IllegalStateException(new StringBuilder((String.valueOf(r5).length() + 24) + String.valueOf(r6).length()).append("Conflicting values ").append(r5).append(" and ").append(r6).toString());
    }

    static <T, R, C, V, I extends Table<R, C, V>> Collector<T, ?, I> toTable(final Function<? super T, ? extends R> r1, final Function<? super T, ? extends C> r2, final Function<? super T, ? extends V> r3, final BinaryOperator<V> r4, Supplier<I> r5) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        Preconditions.checkNotNull(r5);
        return Collector.of(r5, new TableCollectors$$ExternalSyntheticLambda0(r1, r2, r3, r4), new TableCollectors$$ExternalSyntheticLambda2(r4), new Collector.Characteristics[0]);
    }

    static /* synthetic */ void lambda$toTable$6(Function r0, Function r1, Function r2, BinaryOperator r3, Table r4, Object r5) {
        mergeTables(r4, r0.apply(r5), r1.apply(r5), r2.apply(r5), r3);
    }

    static /* synthetic */ Table lambda$toTable$7(BinaryOperator r3, Table r4, Table r5) {
        Iterator r6 = r5.cellSet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Table.Cell r0 = (Table.Cell) r6.next();
        mergeTables(r4, r0.getRowKey(), r0.getColumnKey(), r0.getValue(), r3);
        goto L4
    L6:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <R, C, V> void mergeTables(Table<R, C, V> r1, @ParametricNullness R r2, @ParametricNullness C r3, @ParametricNullness V r4, BinaryOperator<V> r5) {
        Preconditions.checkNotNull(r4);
        V r0 = r1.get(r2, r3);
        if (r0 != null) goto L5;
        r1.put(r2, r3, r4);
        return;
    L5:
        Object r6 = r5.apply(r0, r4);
        if (r6 != null) goto L8;
        r1.remove(r2, r3);
        return;
    L8:
        r1.put(r2, r3, r6);
    }

    private TableCollectors() {
    }
}
