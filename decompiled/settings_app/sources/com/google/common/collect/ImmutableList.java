package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {

    public static final class Builder<E> extends ImmutableCollection.Builder<E> {
        Object[] contents;
        private boolean forceCopy;
        private int size;

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
            this(4);
        }

        Builder(int r1) {
            this.contents = new Object[r1];
            this.size = 0;
        }

        private void getReadyToExpandTo(int r4) {
            Object[] r0 = this.contents;
            if (r0.length >= r4) goto L6;
            this.contents = Arrays.copyOf(r0, expandedCapacity(r0.length, r4));
            this.forceCopy = false;
            return;
        L6:
            if (this.forceCopy == false) goto L10;
            this.contents = Arrays.copyOf(r0, r0.length);
            this.forceCopy = false;
            return;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> add(E r4) {
            Preconditions.checkNotNull(r4);
            getReadyToExpandTo(this.size + 1);
            Object[] r0 = this.contents;
            int r1 = this.size;
            this.size = r1 + 1;
            r0[r1] = r4;
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> add(E... r2) {
            ObjectArrays.checkElementsNotNull(r2);
            add(r2, r2.length);
            return this;
        }

        private void add(Object[] r4, int r5) {
            getReadyToExpandTo(this.size + r5);
            System.arraycopy(r4, 0, this.contents, this.size, r5);
            this.size += r5;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> addAll(Iterable<? extends E> r4) {
            Preconditions.checkNotNull(r4);
            if ((r4 instanceof Collection) == false) goto L8;
            Collection r0 = (Collection) r4;
            getReadyToExpandTo(this.size + r0.size());
            if ((r0 instanceof ImmutableCollection) == false) goto L8;
            this.size = ((ImmutableCollection) r0).copyIntoArray(this.contents, this.size);
            return this;
        L8:
            super.addAll(r4);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> addAll(Iterator<? extends E> r1) {
            super.addAll(r1);
            return this;
        }

        Builder<E> combine(Builder<E> r2) {
            Preconditions.checkNotNull(r2);
            add(r2.contents, r2.size);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public ImmutableList<E> build() {
            this.forceCopy = true;
            return ImmutableList.asImmutableList(this.contents, this.size);
        }
    }

    private static class ReverseImmutableList<E> extends ImmutableList<E> {
        private final transient ImmutableList<E> forwardList;

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int r1) {
            return super.listIterator(r1);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ List subList(int r1, int r2) {
            return subList(r1, r2);
        }

        ReverseImmutableList(ImmutableList<E> r1) {
            this.forwardList = r1;
        }

        private int reverseIndex(int r1) {
            return (size() - 1) - r1;
        }

        private int reversePosition(int r1) {
            return size() - r1;
        }

        @Override // com.google.common.collect.ImmutableList
        public ImmutableList<E> reverse() {
            return this.forwardList;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r1) {
            return this.forwardList.contains(r1);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(@CheckForNull Object r2) {
            int r3 = this.forwardList.lastIndexOf(r2);
            if (r3 >= 0) goto L7;
            return -1;
        L7:
            return reverseIndex(r3);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(@CheckForNull Object r2) {
            int r3 = this.forwardList.indexOf(r2);
            if (r3 >= 0) goto L7;
            return -1;
        L7:
            return reverseIndex(r3);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int r2, int r3) {
            Preconditions.checkPositionIndexes(r2, r3, size());
            return this.forwardList.subList(reversePosition(r3), reversePosition(r2)).reverse();
        }

        @Override // java.util.List
        public E get(int r2) {
            Preconditions.checkElementIndex(r2, size());
            return this.forwardList.get(reverseIndex(r2));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.forwardList.size();
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return this.forwardList.isPartialView();
        }
    }

    static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        SerializedForm(Object[] r1) {
            this.elements = r1;
        }

        Object readResolve() {
            return ImmutableList.copyOf(this.elements);
        }
    }

    class SubList extends ImmutableList<E> {
        final transient int length;
        final transient int offset;
        final /* synthetic */ ImmutableList this$0;

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int r1) {
            return super.listIterator(r1);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ List subList(int r1, int r2) {
            return subList(r1, r2);
        }

        SubList(ImmutableList r1, int r2, int r3) {
            this.this$0 = r1;
            this.offset = r2;
            this.length = r3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.length;
        }

        @Override // java.util.List
        public E get(int r2) {
            Preconditions.checkElementIndex(r2, this.length);
            return this.this$0.get(r2 + this.offset);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int r2, int r3) {
            Preconditions.checkPositionIndexes(r2, r3, this.length);
            ImmutableList r0 = this.this$0;
            int r1 = this.offset;
            return r0.subList(r2 + r1, r3 + r1);
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    @Deprecated
    public final ImmutableList<E> asList() {
        return this;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator() {
        return listIterator();
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator(int r1) {
        return listIterator(r1);
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ List subList(int r1, int r2) {
        return subList(r1, r2);
    }

    public static <E> Collector<E, ?, ImmutableList<E>> toImmutableList() {
        return CollectCollectors.toImmutableList();
    }

    public static <E> ImmutableList<E> of() {
        return (ImmutableList<E>) RegularImmutableList.EMPTY;
    }

    public static <E> ImmutableList<E> of(E r1) {
        return new SingletonImmutableList(r1);
    }

    public static <E> ImmutableList<E> of(E r2, E r3) {
        return construct(new Object[]{r2, r3});
    }

    public static <E> ImmutableList<E> of(E r2, E r3, E r4) {
        return construct(new Object[]{r2, r3, r4});
    }

    public static <E> ImmutableList<E> of(E r2, E r3, E r4, E r5) {
        return construct(new Object[]{r2, r3, r4, r5});
    }

    public static <E> ImmutableList<E> of(E r2, E r3, E r4, E r5, E r6) {
        return construct(new Object[]{r2, r3, r4, r5, r6});
    }

    public static <E> ImmutableList<E> of(E r2, E r3, E r4, E r5, E r6, E r7) {
        return construct(new Object[]{r2, r3, r4, r5, r6, r7});
    }

    public static <E> ImmutableList<E> of(E r2, E r3, E r4, E r5, E r6, E r7, E r8) {
        return construct(new Object[]{r2, r3, r4, r5, r6, r7, r8});
    }

    public static <E> ImmutableList<E> of(E r2, E r3, E r4, E r5, E r6, E r7, E r8, E r9) {
        return construct(new Object[]{r2, r3, r4, r5, r6, r7, r8, r9});
    }

    public static <E> ImmutableList<E> of(E r2, E r3, E r4, E r5, E r6, E r7, E r8, E r9, E r10) {
        return construct(new Object[]{r2, r3, r4, r5, r6, r7, r8, r9, r10});
    }

    public static <E> ImmutableList<E> of(E r2, E r3, E r4, E r5, E r6, E r7, E r8, E r9, E r10, E r11) {
        return construct(new Object[]{r2, r3, r4, r5, r6, r7, r8, r9, r10, r11});
    }

    public static <E> ImmutableList<E> of(E r2, E r3, E r4, E r5, E r6, E r7, E r8, E r9, E r10, E r11, E r12) {
        return construct(new Object[]{r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12});
    }

    @SafeVarargs
    public static <E> ImmutableList<E> of(E r5, E r6, E r7, E r8, E r9, E r10, E r11, E r12, E r13, E r14, E r15, E r16, E... r17) {
        if (r17.length > 2147483635) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "the total number of elements must fit in an int");
        Object[] r2 = new Object[r17.length + 12];
        r2[0] = r5;
        r2[1] = r6;
        r2[2] = r7;
        r2[3] = r8;
        r2[4] = r9;
        r2[5] = r10;
        r2[6] = r11;
        r2[7] = r12;
        r2[8] = r13;
        r2[9] = r14;
        r2[10] = r15;
        r2[11] = r16;
        System.arraycopy(r17, 0, r2, 12, r17.length);
        return construct(r2);
    L5:
        r1 = false;
        goto L6
    }

    public static <E> ImmutableList<E> copyOf(Iterable<? extends E> r1) {
        Preconditions.checkNotNull(r1);
        if ((r1 instanceof Collection) == false) goto L6;
        return copyOf((Collection) r1);
    L6:
        return copyOf(r1.iterator());
    }

    public static <E> ImmutableList<E> copyOf(Collection<? extends E> r1) {
        if ((r1 instanceof ImmutableCollection) == false) goto L9;
        ImmutableList<E> r2 = ((ImmutableCollection) r1).asList();
        if (r2.isPartialView() == true) goto L7;
        return r2;
    L7:
        return asImmutableList(r2.toArray());
    L9:
        return construct(r1.toArray());
    }

    public static <E> ImmutableList<E> copyOf(Iterator<? extends E> r2) {
        if (r2.hasNext() == false) goto L5;
        E r0 = r2.next();
        if (r2.hasNext() == true) goto L11;
        return of(r0);
    L11:
        return new Builder().add(r0).addAll(r2).build();
    L5:
        return of();
    }

    public static <E> ImmutableList<E> copyOf(E[] r2) {
        int r0 = r2.length;
        if (r0 == 0) goto L11;
        if (r0 == 1) goto L9;
        return construct((Object[]) r2.clone());
    L9:
        return of(r2[0]);
    L11:
        return of();
    }

    public static <E extends Comparable<? super E>> ImmutableList<E> sortedCopyOf(Iterable<? extends E> r1) {
        Comparable[] r2 = (Comparable[]) Iterables.toArray(r1, new Comparable[0]);
        ObjectArrays.checkElementsNotNull(r2);
        Arrays.sort(r2);
        return asImmutableList(r2);
    }

    public static <E> ImmutableList<E> sortedCopyOf(Comparator<? super E> r0, Iterable<? extends E> r1) {
        Preconditions.checkNotNull(r0);
        Object[] r2 = Iterables.toArray(r1);
        ObjectArrays.checkElementsNotNull(r2);
        Arrays.sort(r2, r0);
        return asImmutableList(r2);
    }

    private static <E> ImmutableList<E> construct(Object... r0) {
        return asImmutableList(ObjectArrays.checkElementsNotNull(r0));
    }

    static <E> ImmutableList<E> asImmutableList(Object[] r1) {
        return asImmutableList(r1, r1.length);
    }

    static <E> ImmutableList<E> asImmutableList(Object[] r1, int r2) {
        if (r2 == 0) goto L13;
        if (r2 == 1) goto L11;
        if (r2 >= r1.length) goto L9;
        r1 = Arrays.copyOf(r1, r2);
    L9:
        return new RegularImmutableList(r1);
    L11:
        return of(Objects.requireNonNull(r1[0]));
    L13:
        return of();
    }

    ImmutableList() {
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public UnmodifiableIterator<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public UnmodifiableListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public UnmodifiableListIterator<E> listIterator(final int r3) {
        final int r1 = size();
        return new AnonymousClass1(this, r1, r3);
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

    @Override // java.util.List
    public int indexOf(@CheckForNull Object r1) {
        if (r1 != null) goto L5;
        return -1;
    L5:
        return Lists.indexOfImpl(this, r1);
    }

    @Override // java.util.List
    public int lastIndexOf(@CheckForNull Object r1) {
        if (r1 != null) goto L5;
        return -1;
    L5:
        return Lists.lastIndexOfImpl(this, r1);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object r1) {
        if (indexOf(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.List
    public ImmutableList<E> subList(int r3, int r4) {
        Preconditions.checkPositionIndexes(r3, r4, size());
        int r0 = r4 - r3;
        if (r0 != size()) goto L5;
        return this;
    L5:
        if (r0 != 0) goto L9;
        return of();
    L9:
        if (r0 != 1) goto L13;
        return of(get(r3));
    L13:
        return subListUnchecked(r3, r4);
    }

    ImmutableList<E> subListUnchecked(int r2, int r3) {
        return new SubList(this, r2, r3 - r2);
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int r1, Collection<? extends E> r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int r1, E r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int r1, E r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final void replaceAll(UnaryOperator<E> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final void sort(Comparator<? super E> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return CollectSpliterators.indexed(size(), 1296, new ImmutableList$$ExternalSyntheticLambda0(this));
    }

    @Override // com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] r5, int r6) {
        int r0 = size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L6;
        r5[r6 + r1] = get(r1);
        r1 = r1 + 1;
        goto L3
    L6:
        return r6 + r0;
    }

    public ImmutableList<E> reverse() {
        if (size() > 1) goto L6;
        return this;
    L6:
        return new ReverseImmutableList(this);
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@CheckForNull Object r1) {
        return Lists.equalsImpl(this, r1);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int r0 = size();
        int r1 = 1;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1 = ~(~((r1 * 31) + get(r2).hashCode()));
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    private void readObject(ObjectInputStream r1) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
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
}
