package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class ConcurrentHashMultiset<E> extends AbstractMultiset<E> implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient ConcurrentMap<E, AtomicInteger> countMap;

    private class EntrySet extends AbstractMultiset<E>.EntrySet {
        final /* synthetic */ ConcurrentHashMultiset this$0;

        @Override // com.google.common.collect.AbstractMultiset.EntrySet, com.google.common.collect.Multisets.EntrySet
        /* bridge */ /* synthetic */ Multiset multiset() {
            return multiset();
        }

        private EntrySet(ConcurrentHashMultiset r1) {
            this.this$0 = r1;
            super(r1);
        }

        /* synthetic */ EntrySet(ConcurrentHashMultiset r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.collect.AbstractMultiset.EntrySet, com.google.common.collect.Multisets.EntrySet
        ConcurrentHashMultiset<E> multiset() {
            return this.this$0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return snapshot().toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r1) {
            return (T[]) snapshot().toArray(r1);
        }

        private List<Multiset.Entry<E>> snapshot() {
            ArrayList r0 = Lists.newArrayListWithExpectedSize(size());
            Iterators.addAll(r0, iterator());
            return r0;
        }
    }

    private static class FieldSettersHolder {
        static final Serialization.FieldSetter<ConcurrentHashMultiset> COUNT_MAP_FIELD_SETTER = null;

        private FieldSettersHolder() {
        }

        static {
            COUNT_MAP_FIELD_SETTER = Serialization.getFieldSetter(ConcurrentHashMultiset.class, "countMap");
        }
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object r1) {
        return super.contains(r1);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    static /* synthetic */ ConcurrentMap access$100(ConcurrentHashMultiset r0) {
        return r0.countMap;
    }

    public static <E> ConcurrentHashMultiset<E> create() {
        return new ConcurrentHashMultiset(new ConcurrentHashMap());
    }

    public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> r1) {
        ConcurrentHashMultiset<E> r0 = create();
        Iterables.addAll(r0, r1);
        return r0;
    }

    public static <E> ConcurrentHashMultiset<E> create(ConcurrentMap<E, AtomicInteger> r1) {
        return new ConcurrentHashMultiset(r1);
    }

    ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> r3) {
        Preconditions.checkArgument(r3.isEmpty(), "the backing map (%s) must be empty", r3);
        this.countMap = r3;
    }

    @Override // com.google.common.collect.Multiset
    public int count(@CheckForNull Object r1) {
        AtomicInteger r0 = (AtomicInteger) Maps.safeGet(this.countMap, r1);
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.get();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        Iterator<AtomicInteger> r4 = this.countMap.values().iterator();
        long r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L7;
        r0 = r0 + ((long) r4.next().get());
        goto L4
    L7:
        return Ints.saturatedCast(r0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return snapshot().toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] r1) {
        return (T[]) snapshot().toArray(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private List<E> snapshot() {
        ArrayList r0 = Lists.newArrayListWithExpectedSize(size());
        Iterator<E> r3 = entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Multiset.Entry r1 = (Multiset.Entry) r3.next();
        Object r2 = r1.getElement();
        int r4 = r1.getCount();
    L6:
        if (r4 <= 0) goto L4;
        r0.add(r2);
        r4 = r4 - 1;
        goto L6
    L8:
        return r0;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int add(E r5, int r6) {
        Preconditions.checkNotNull(r5);
        if (r6 == 0) goto L5;
        CollectPreconditions.checkPositive(r6, "occurrences");
    L7:
        AtomicInteger r0 = (AtomicInteger) Maps.safeGet(this.countMap, r5);
        if (r0 != null) goto L12;
        r0 = this.countMap.putIfAbsent(r5, new AtomicInteger(r6));
        if (r0 != null) goto L12;
        return 0;
    L12:
        int r2 = r0.get();
        if (r2 == 0) goto L19;
        if (r0.compareAndSet(r2, IntMath.checkedAdd(r2, r6)) == false) goto L12;
        return r2;
    L18:
        throw new IllegalArgumentException(new StringBuilder(65).append("Overflow adding ").append(r6).append(" occurrences to a count of ").append(r2).toString());
    L19:
        AtomicInteger r3 = new AtomicInteger(r6);
        if (this.countMap.putIfAbsent(r5, r3) == null) goto L23;
        if (this.countMap.replace(r5, r0, r3) == false) goto L7;
    L23:
        return 0;
    L5:
        return count(r5);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int remove(@CheckForNull Object r6, int r7) {
        if (r7 == 0) goto L4;
        CollectPreconditions.checkPositive(r7, "occurrences");
        AtomicInteger r0 = (AtomicInteger) Maps.safeGet(this.countMap, r6);
        if (r0 != null) goto L8;
        return 0;
    L8:
        int r2 = r0.get();
        if (r2 == 0) goto L15;
        int r3 = Math.max(0, r2 - r7);
        if (r0.compareAndSet(r2, r3) == false) goto L8;
        if (r3 != 0) goto L14;
        this.countMap.remove(r6, r0);
    L14:
        return r2;
    L15:
        return 0;
    L4:
        return count(r6);
    }

    public boolean removeExactly(@CheckForNull Object r6, int r7) {
        if (r7 != 0) goto L5;
        return true;
    L5:
        CollectPreconditions.checkPositive(r7, "occurrences");
        AtomicInteger r1 = (AtomicInteger) Maps.safeGet(this.countMap, r6);
        if (r1 != null) goto L8;
        return false;
    L8:
        int r3 = r1.get();
        if (r3 < r7) goto L10;
        int r4 = r3 - r7;
        if (r1.compareAndSet(r3, r4) == false) goto L8;
        if (r4 != 0) goto L15;
        this.countMap.remove(r6, r1);
    L15:
        return true;
    L10:
        return false;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int setCount(E r5, int r6) {
        Preconditions.checkNotNull(r5);
        CollectPreconditions.checkNonnegative(r6, "count");
    L3:
        AtomicInteger r0 = (AtomicInteger) Maps.safeGet(this.countMap, r5);
        if (r0 != null) goto L10;
        if (r6 == 0) goto L6;
        r0 = this.countMap.putIfAbsent(r5, new AtomicInteger(r6));
        if (r0 != null) goto L10;
        return 0;
    L6:
        return 0;
    L10:
        int r2 = r0.get();
        if (r2 == 0) goto L12;
        if (r0.compareAndSet(r2, r6) == false) goto L10;
        if (r6 != 0) goto L23;
        this.countMap.remove(r5, r0);
    L23:
        return r2;
    L12:
        if (r6 == 0) goto L13;
        AtomicInteger r3 = new AtomicInteger(r6);
        if (this.countMap.putIfAbsent(r5, r3) == null) goto L18;
        if (this.countMap.replace(r5, r0, r3) == false) goto L3;
    L18:
        return 0;
    L13:
        return 0;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public boolean setCount(E r5, int r6, int r7) {
        Preconditions.checkNotNull(r5);
        CollectPreconditions.checkNonnegative(r6, "oldCount");
        CollectPreconditions.checkNonnegative(r7, "newCount");
        AtomicInteger r0 = (AtomicInteger) Maps.safeGet(this.countMap, r5);
        if (r0 != null) goto L12;
        if (r6 == 0) goto L6;
        return false;
    L6:
        if (r7 != 0) goto L9;
        return true;
    L9:
        if (this.countMap.putIfAbsent(r5, new AtomicInteger(r7)) == null) goto L11;
        return false;
    L11:
        return true;
    L12:
        int r3 = r0.get();
        if (r3 != r6) goto L29;
        if (r3 != 0) goto L25;
        if (r7 != 0) goto L18;
        this.countMap.remove(r5, r0);
        return true;
    L18:
        AtomicInteger r8 = new AtomicInteger(r7);
        if (this.countMap.putIfAbsent(r5, r8) == null) goto L23;
        if (this.countMap.replace(r5, r0, r8) == true) goto L23;
        return false;
    L23:
        return true;
    L25:
        if (r0.compareAndSet(r3, r7) == false) goto L29;
        if (r7 != 0) goto L28;
        this.countMap.remove(r5, r0);
    L28:
        return true;
    L29:
        return false;
    }

    @Override // com.google.common.collect.AbstractMultiset
    Set<E> createElementSet() {
        final Set<E> r0 = this.countMap.keySet();
        return new AnonymousClass1(this, r0);
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator<E> elementIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractMultiset
    @Deprecated
    public Set<Multiset.Entry<E>> createEntrySet() {
        return new EntrySet(this, null);
    }

    @Override // com.google.common.collect.AbstractMultiset
    int distinctElements() {
        return this.countMap.size();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.countMap.isEmpty();
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator<Multiset.Entry<E>> entryIterator() {
        final AbstractIterator<Multiset.Entry<E>> r0 = new AnonymousClass2(this);
        return new AnonymousClass3(this, r0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.countMap.clear();
    }

    private void writeObject(ObjectOutputStream r1) throws IOException {
        r1.defaultWriteObject();
        r1.writeObject(this.countMap);
    }

    private void readObject(ObjectInputStream r2) throws IOException, ClassNotFoundException {
        r2.defaultReadObject();
        ConcurrentMap r3 = (ConcurrentMap) r2.readObject();
        FieldSettersHolder.COUNT_MAP_FIELD_SETTER.set(this, r3);
    }
}
