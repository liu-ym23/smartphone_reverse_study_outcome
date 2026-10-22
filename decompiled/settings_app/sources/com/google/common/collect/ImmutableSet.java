package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collector;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private static final int CUTOFF = 751619276;
    private static final double DESIRED_LOAD_FACTOR = 0.7d;
    static final int MAX_TABLE_SIZE = 1073741824;
    static final int SPLITERATOR_CHARACTERISTICS = 1297;

    public static class Builder<E> extends ImmutableCollection.Builder<E> {
        boolean forceCopy;

        @CheckForNull
        private SetBuilderImpl<E> impl;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object r1) {
            return add(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object[] r1) {
            return add(r1);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder addAll(Iterable r1) {
            return addAll(r1);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder addAll(Iterator r1) {
            return addAll(r1);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection build() {
            return build();
        }

        public Builder() {
            this(0);
        }

        Builder(int r2) {
            if (r2 <= 0) goto L5;
            this.impl = new RegularSetBuilderImpl(r2);
            return;
        L5:
            this.impl = EmptySetBuilderImpl.instance();
        }

        Builder(boolean r1) {
            this.impl = null;
        }

        void forceJdk() {
            Objects.requireNonNull(this.impl);
            this.impl = new JdkBackedSetBuilderImpl(this.impl);
        }

        final void copyIfNecessary() {
            if (this.forceCopy == false) goto L6;
            copy();
            this.forceCopy = false;
            return;
        }

        void copy() {
            Objects.requireNonNull(this.impl);
            this.impl = this.impl.copy();
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> add(E r2) {
            Objects.requireNonNull(this.impl);
            Preconditions.checkNotNull(r2);
            copyIfNecessary();
            this.impl = this.impl.add(r2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> add(E... r1) {
            super.add(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> addAll(Iterable<? extends E> r1) {
            super.addAll(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> addAll(Iterator<? extends E> r1) {
            super.addAll(r1);
            return this;
        }

        Builder<E> combine(Builder<E> r2) {
            Objects.requireNonNull(this.impl);
            Objects.requireNonNull(r2.impl);
            copyIfNecessary();
            this.impl = this.impl.combine(r2.impl);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public ImmutableSet<E> build() {
            Objects.requireNonNull(this.impl);
            this.forceCopy = true;
            SetBuilderImpl<E> r0 = this.impl.review();
            this.impl = r0;
            return r0.build();
        }
    }

    static abstract class CachingAsList<E> extends ImmutableSet<E> {

        @CheckForNull
        @LazyInit
        private transient ImmutableList<E> asList;

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        CachingAsList() {
        }

        @Override // com.google.common.collect.ImmutableCollection
        public ImmutableList<E> asList() {
            ImmutableList<E> r0 = this.asList;
            if (r0 != null) goto L6;
            ImmutableList<E> r1 = createAsList();
            this.asList = r1;
            return r1;
        L6:
            return r0;
        }

        ImmutableList<E> createAsList() {
            return new RegularImmutableAsList(this, toArray());
        }
    }

    private static final class EmptySetBuilderImpl<E> extends SetBuilderImpl<E> {
        private static final EmptySetBuilderImpl<Object> INSTANCE = null;

        @Override // com.google.common.collect.ImmutableSet.SetBuilderImpl
        SetBuilderImpl<E> copy() {
            return this;
        }

        static {
            INSTANCE = new EmptySetBuilderImpl();
        }

        static <E> SetBuilderImpl<E> instance() {
            return INSTANCE;
        }

        private EmptySetBuilderImpl() {
            super(0);
        }

        @Override // com.google.common.collect.ImmutableSet.SetBuilderImpl
        SetBuilderImpl<E> add(E r2) {
            return new RegularSetBuilderImpl(4).add(r2);
        }

        @Override // com.google.common.collect.ImmutableSet.SetBuilderImpl
        ImmutableSet<E> build() {
            return ImmutableSet.of();
        }
    }

    static abstract class Indexed<E> extends CachingAsList<E> {
        abstract E get(int r1);

        Indexed() {
        }

        @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public UnmodifiableIterator<E> iterator() {
            return asList().iterator();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
        public Spliterator<E> spliterator() {
            return CollectSpliterators.indexed(size(), ImmutableSet.SPLITERATOR_CHARACTERISTICS, new ImmutableSet$Indexed$$ExternalSyntheticLambda0(this));
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> r4) {
            Preconditions.checkNotNull(r4);
            int r0 = size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r4.accept(get(r1));
            r1 = r1 + 1;
            goto L3
        }

        @Override // com.google.common.collect.ImmutableCollection
        int copyIntoArray(Object[] r1, int r2) {
            return asList().copyIntoArray(r1, r2);
        }

        @Override // com.google.common.collect.ImmutableSet.CachingAsList
        ImmutableList<E> createAsList() {
            return new AnonymousClass1(this);
        }
    }

    private static final class JdkBackedSetBuilderImpl<E> extends SetBuilderImpl<E> {
        private final Set<Object> delegate;

        JdkBackedSetBuilderImpl(SetBuilderImpl<E> r3) {
            super(r3);
            this.delegate = Sets.newHashSetWithExpectedSize(this.distinct);
            int r4 = 0;
        L4:
            if (r4 >= this.distinct) goto L6;
            this.delegate.add(Objects.requireNonNull(this.dedupedElements[r4]));
            r4 = r4 + 1;
            goto L4
        }

        @Override // com.google.common.collect.ImmutableSet.SetBuilderImpl
        SetBuilderImpl<E> add(E r2) {
            Preconditions.checkNotNull(r2);
            if (this.delegate.add(r2) == false) goto L5;
            addDedupedElement(r2);
        L5:
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.SetBuilderImpl
        SetBuilderImpl<E> copy() {
            return new JdkBackedSetBuilderImpl(this);
        }

        @Override // com.google.common.collect.ImmutableSet.SetBuilderImpl
        ImmutableSet<E> build() {
            int r0 = this.distinct;
            if (r0 == 0) goto L11;
            if (r0 == 1) goto L9;
            return new JdkBackedImmutableSet(this.delegate, ImmutableList.asImmutableList(this.dedupedElements, this.distinct));
        L9:
            return ImmutableSet.of(Objects.requireNonNull(this.dedupedElements[0]));
        L11:
            return ImmutableSet.of();
        }
    }

    private static final class RegularSetBuilderImpl<E> extends SetBuilderImpl<E> {
        static final int MAX_RUN_MULTIPLIER = 13;
        private int expandTableThreshold;
        private int hashCode;
        private Object[] hashTable;
        private int maxRunBeforeFallback;

        RegularSetBuilderImpl(int r1) {
            super(r1);
            this.hashTable = null;
            this.maxRunBeforeFallback = 0;
            this.expandTableThreshold = 0;
        }

        RegularSetBuilderImpl(RegularSetBuilderImpl<E> r2) {
            super(r2);
            Object[] r0 = r2.hashTable;
            if (r0 != null) goto L5;
            Object[] r1 = null;
        L6:
            this.hashTable = r1;
            this.maxRunBeforeFallback = r2.maxRunBeforeFallback;
            this.expandTableThreshold = r2.expandTableThreshold;
            this.hashCode = r2.hashCode;
            return;
        L5:
            r1 = (Object[]) r0.clone();
            goto L6
        }

        @Override // com.google.common.collect.ImmutableSet.SetBuilderImpl
        SetBuilderImpl<E> add(E r3) {
            Preconditions.checkNotNull(r3);
            if (this.hashTable != null) goto L11;
            if (this.distinct != 0) goto L8;
            addDedupedElement(r3);
            return this;
        L8:
            ensureTableCapacity(this.dedupedElements.length);
            E r0 = this.dedupedElements[0];
            this.distinct--;
            return insertInHashTable(r0).add(r3);
        L11:
            return insertInHashTable(r3);
        }

        private SetBuilderImpl<E> insertInHashTable(E r7) {
            Objects.requireNonNull(this.hashTable);
            int r0 = r7.hashCode();
            int r1 = Hashing.smear(r0);
            int r2 = this.hashTable.length - 1;
            int r3 = r1;
        L4:
            if ((r3 - r1) >= this.maxRunBeforeFallback) goto L14;
            int r4 = r3 & r2;
            Object r5 = this.hashTable[r4];
            if (r5 == null) goto L7;
            if (r5.equals(r7) == true) goto L11;
            r3 = r3 + 1;
            goto L4
        L11:
            return this;
        L7:
            addDedupedElement(r7);
            this.hashTable[r4] = r7;
            this.hashCode += r0;
            ensureTableCapacity(this.distinct);
            return this;
        L14:
            return new JdkBackedSetBuilderImpl(this).add(r7);
        }

        @Override // com.google.common.collect.ImmutableSet.SetBuilderImpl
        SetBuilderImpl<E> copy() {
            return new RegularSetBuilderImpl(this);
        }

        @Override // com.google.common.collect.ImmutableSet.SetBuilderImpl
        SetBuilderImpl<E> review() {
            if (this.hashTable != null) goto L5;
            return this;
        L5:
            int r0 = ImmutableSet.chooseTableSize(this.distinct);
            if ((r0 * 2) >= this.hashTable.length) goto L9;
            this.hashTable = rebuildHashTable(r0, this.dedupedElements, this.distinct);
            this.maxRunBeforeFallback = maxRunBeforeFallback(r0);
            this.expandTableThreshold = (int) (((double) r0) * ImmutableSet.DESIRED_LOAD_FACTOR);
        L9:
            if (hashFloodingDetected(this.hashTable) == true) goto L11;
            return this;
        L11:
            return new JdkBackedSetBuilderImpl(this);
        }

        @Override // com.google.common.collect.ImmutableSet.SetBuilderImpl
        ImmutableSet<E> build() {
            int r0 = this.distinct;
            if (r0 == 0) goto L15;
            if (r0 == 1) goto L13;
            if (this.distinct != this.dedupedElements.length) goto L9;
            Object[] r1 = this.dedupedElements;
        L11:
            return new RegularImmutableSet(r1, this.hashCode, (Object[]) Objects.requireNonNull(this.hashTable), this.hashTable.length - 1);
        L9:
            r1 = Arrays.copyOf(this.dedupedElements, this.distinct);
            goto L11
        L13:
            return ImmutableSet.of(Objects.requireNonNull(this.dedupedElements[0]));
        L15:
            return ImmutableSet.of();
        }

        static Object[] rebuildHashTable(int r6, Object[] r7, int r8) {
            Object[] r0 = new Object[r6];
            int r9 = r6 - 1;
            int r1 = 0;
        L3:
            if (r1 >= r8) goto L9;
            Object r2 = Objects.requireNonNull(r7[r1]);
            int r3 = Hashing.smear(r2.hashCode());
        L5:
            int r4 = r3 & r9;
            if (r0[r4] == null) goto L7;
            r3 = r3 + 1;
            goto L5
        L7:
            r0[r4] = r2;
            r1 = r1 + 1;
            goto L3
        L9:
            return r0;
        }

        void ensureTableCapacity(int r5) {
            Object[] r0 = this.hashTable;
            if (r0 != null) goto L6;
            int r6 = ImmutableSet.chooseTableSize(r5);
            this.hashTable = new Object[r6];
        L10:
            this.maxRunBeforeFallback = maxRunBeforeFallback(r6);
            this.expandTableThreshold = (int) (((double) r6) * ImmutableSet.DESIRED_LOAD_FACTOR);
            return;
        L6:
            if (r5 > this.expandTableThreshold) goto L8;
            return;
        L8:
            if (r0.length >= 1073741824) goto L13;
            r6 = r0.length * 2;
            this.hashTable = rebuildHashTable(r6, this.dedupedElements, this.distinct);
            goto L10
        }

        static boolean hashFloodingDetected(Object[] r9) {
            int r0 = maxRunBeforeFallback(r9.length);
            int r1 = r9.length - 1;
            int r4 = 0;
            int r5 = 0;
        L4:
            if (r4 >= r9.length) goto L20;
            if (r4 != r5) goto L13;
            if (r9[r4] != null) goto L13;
            r5 = r4 + r0;
            if (r9[(r5 - 1) & r1] == null) goto L12;
            r5 = r4 + 1;
        L12:
            r4 = r5;
        L13:
            int r6 = r4 + r0;
            int r7 = r6 - 1;
        L14:
            if (r7 < r5) goto L19;
            if (r9[r7 & r1] == null) goto L17;
            r7 = r7 - 1;
            goto L14
        L17:
            r5 = r6;
            r4 = r7 + 1;
            goto L4
        L19:
            return true;
        L20:
            return false;
        }

        static int maxRunBeforeFallback(int r1) {
            return IntMath.log2(r1, RoundingMode.UNNECESSARY) * 13;
        }
    }

    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        SerializedForm(Object[] r1) {
            this.elements = r1;
        }

        Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    private static abstract class SetBuilderImpl<E> {
        E[] dedupedElements;
        int distinct;

        abstract SetBuilderImpl<E> add(E r1);

        abstract ImmutableSet<E> build();

        abstract SetBuilderImpl<E> copy();

        SetBuilderImpl<E> review() {
            return this;
        }

        SetBuilderImpl(int r1) {
            this.dedupedElements = (E[]) new Object[r1];
            this.distinct = 0;
        }

        SetBuilderImpl(SetBuilderImpl<E> r3) {
            E[] r0 = r3.dedupedElements;
            this.dedupedElements = (E[]) Arrays.copyOf(r0, r0.length);
            this.distinct = r3.distinct;
        }

        private void ensureCapacity(int r3) {
            E[] r0 = this.dedupedElements;
            if (r3 <= r0.length) goto L6;
            int r4 = ImmutableCollection.Builder.expandedCapacity(r0.length, r3);
            this.dedupedElements = (E[]) Arrays.copyOf(this.dedupedElements, r4);
            return;
        }

        final void addDedupedElement(E r4) {
            ensureCapacity(this.distinct + 1);
            E[] r0 = this.dedupedElements;
            int r1 = this.distinct;
            this.distinct = r1 + 1;
            r0[r1] = r4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [com.google.common.collect.ImmutableSet$SetBuilderImpl, com.google.common.collect.ImmutableSet$SetBuilderImpl<E>] */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v7 */
        final SetBuilderImpl<E> combine(SetBuilderImpl<E> r3) {
            int r0 = 0;
            ?? r2 = this;
        L4:
            if (r0 >= r3.distinct) goto L6;
            RegularSetBuilderImpl r4 = (SetBuilderImpl) r2;
            boolean r5 = (SetBuilderImpl<E>) r4.add(Objects.requireNonNull(r3.dedupedElements[r0]));
            r0 = r0 + 1;
            r2 = r5;
            goto L4
        L6:
            return (SetBuilderImpl<E>) r2;
        }
    }

    boolean isHashCodeFast() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public abstract UnmodifiableIterator<E> iterator();

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public static <E> Collector<E, ?, ImmutableSet<E>> toImmutableSet() {
        return CollectCollectors.toImmutableSet();
    }

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.EMPTY;
    }

    public static <E> ImmutableSet<E> of(E r1) {
        return new SingletonImmutableSet(r1);
    }

    public static <E> ImmutableSet<E> of(E r3, E r4) {
        return construct(2, 2, new Object[]{r3, r4});
    }

    public static <E> ImmutableSet<E> of(E r3, E r4, E r5) {
        return construct(3, 3, new Object[]{r3, r4, r5});
    }

    public static <E> ImmutableSet<E> of(E r3, E r4, E r5, E r6) {
        return construct(4, 4, new Object[]{r3, r4, r5, r6});
    }

    public static <E> ImmutableSet<E> of(E r3, E r4, E r5, E r6, E r7) {
        return construct(5, 5, new Object[]{r3, r4, r5, r6, r7});
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E r5, E r6, E r7, E r8, E r9, E r10, E... r11) {
        if (r11.length > 2147483641) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "the total number of elements must fit in an int");
        int r1 = r11.length + 6;
        Object[] r4 = new Object[r1];
        r4[0] = r5;
        r4[1] = r6;
        r4[2] = r7;
        r4[3] = r8;
        r4[4] = r9;
        r4[5] = r10;
        System.arraycopy(r11, 0, r4, 6, r11.length);
        return construct(r1, r1, r4);
    L5:
        r0 = false;
        goto L6
    }

    private static <E> ImmutableSet<E> constructUnknownDuplication(int r2, Object... r3) {
        return construct(r2, Math.max(4, IntMath.sqrt(r2, RoundingMode.CEILING)), r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.common.collect.ImmutableSet$SetBuilderImpl] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    private static <E> ImmutableSet<E> construct(int r2, int r3, Object... r4) {
        if (r2 == 0) goto L13;
        int r0 = 0;
        if (r2 == 1) goto L11;
        ?? r1 = new RegularSetBuilderImpl(r3);
    L6:
        if (r0 >= r2) goto L9;
        Object r5 = r1.add(Preconditions.checkNotNull(r4[r0]));
        r0 = r0 + 1;
        r1 = r5;
        goto L6
    L9:
        return r1.review().build();
    L11:
        return of(r4[0]);
    L13:
        return of();
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> r2) {
        if ((r2 instanceof ImmutableSet) == false) goto L10;
        if ((r2 instanceof SortedSet) == true) goto L10;
        ImmutableSet<E> r0 = (ImmutableSet) r2;
        if (r0.isPartialView() == true) goto L13;
        return r0;
    L13:
        Object[] r1 = r2.toArray();
        if ((r2 instanceof Set) == false) goto L18;
        return construct(r1.length, r1.length, r1);
    L18:
        return constructUnknownDuplication(r1.length, r1);
    L10:
        if ((r2 instanceof EnumSet) == false) goto L13;
        return copyOfEnumSet((EnumSet) r2);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> r1) {
        if ((r1 instanceof Collection) == false) goto L6;
        return copyOf((Collection) r1);
    L6:
        return copyOf(r1.iterator());
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> r2) {
        if (r2.hasNext() == false) goto L5;
        E r0 = r2.next();
        if (r2.hasNext() == true) goto L11;
        return of(r0);
    L11:
        return new Builder().add(r0).addAll(r2).build();
    L5:
        return of();
    }

    public static <E> ImmutableSet<E> copyOf(E[] r2) {
        int r0 = r2.length;
        if (r0 == 0) goto L11;
        if (r0 == 1) goto L9;
        return constructUnknownDuplication(r2.length, (Object[]) r2.clone());
    L9:
        return of(r2[0]);
    L11:
        return of();
    }

    private static ImmutableSet copyOfEnumSet(EnumSet r0) {
        return ImmutableEnumSet.asImmutable(EnumSet.copyOf(r0));
    }

    ImmutableSet() {
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@CheckForNull Object r3) {
        if (r3 != this) goto L6;
        return true;
    L6:
        if ((r3 instanceof ImmutableSet) == false) goto L16;
        if (isHashCodeFast() == false) goto L16;
        if (((ImmutableSet) r3).isHashCodeFast() == false) goto L16;
        if (hashCode() == r3.hashCode()) goto L16;
        return false;
    L16:
        return Sets.equalsImpl(this, r3);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> Builder<E> builder() {
        return new Builder();
    }

    public static <E> Builder<E> builderWithExpectedSize(int r1) {
        CollectPreconditions.checkNonnegative(r1, "expectedSize");
        return new Builder(r1);
    }

    static int chooseTableSize(int r5) {
        int r6 = Math.max(r5, 2);
        boolean r1 = true;
        if (r6 >= CUTOFF) goto L10;
        int r0 = Integer.highestOneBit(r6 - 1) << 1;
    L6:
        if ((((double) r0) * DESIRED_LOAD_FACTOR) >= r6) goto L8;
        r0 = r0 << 1;
        goto L6
    L8:
        return r0;
    L10:
        if (r6 < 1073741824) goto L13;
        r1 = false;
    L13:
        Preconditions.checkArgument(r1, "collection too large");
        return 1073741824;
    }
}
