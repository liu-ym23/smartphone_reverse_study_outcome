package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.ObjIntConsumer;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractMapBasedMultiset<E> extends AbstractMultiset<E> implements Serializable {
    private static final long serialVersionUID = -2250766705698539974L;
    private transient Map<E, Count> backingMap;
    private transient long size;

    private class MapBasedMultisetIterator implements Iterator<E> {
        boolean canRemove;

        @CheckForNull
        Map.Entry<E, Count> currentEntry;
        final Iterator<Map.Entry<E, Count>> entryIterator;
        int occurrencesLeft;
        final /* synthetic */ AbstractMapBasedMultiset this$0;

        MapBasedMultisetIterator(AbstractMapBasedMultiset r1) {
            this.this$0 = r1;
            this.entryIterator = AbstractMapBasedMultiset.access$100(r1).entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.occurrencesLeft <= 0) goto L5;
        L8:
            return true;
        L5:
            if (this.entryIterator.hasNext() == true) goto L8;
            return false;
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public E next() {
            if (this.occurrencesLeft != 0) goto L5;
            Map.Entry<E, Count> r0 = this.entryIterator.next();
            this.currentEntry = r0;
            this.occurrencesLeft = r0.getValue().get();
        L5:
            this.occurrencesLeft--;
            this.canRemove = true;
            return (E) ((Map.Entry) Objects.requireNonNull(this.currentEntry)).getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            CollectPreconditions.checkRemove(this.canRemove);
            if (((Count) ((Map.Entry) Objects.requireNonNull(this.currentEntry)).getValue()).get() <= 0) goto L10;
            if (this.currentEntry.getValue().addAndGet(-1) != 0) goto L7;
            this.entryIterator.remove();
        L7:
            AbstractMapBasedMultiset.access$010(this.this$0);
            this.canRemove = false;
            return;
        L10:
            throw new ConcurrentModificationException();
        }
    }

    static /* synthetic */ long access$010(AbstractMapBasedMultiset r4) {
        long r0 = r4.size;
        r4.size = r0 - 1;
        return r0;
    }

    static /* synthetic */ long access$022(AbstractMapBasedMultiset r2, long r3) {
        long r0 = r2.size - r3;
        r2.size = r0;
        return r0;
    }

    static /* synthetic */ Map access$100(AbstractMapBasedMultiset r0) {
        return r0.backingMap;
    }

    protected AbstractMapBasedMultiset(Map<E, Count> r2) {
        Preconditions.checkArgument(r2.isEmpty());
        this.backingMap = r2;
    }

    void setBackingMap(Map<E, Count> r1) {
        this.backingMap = r1;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public Set<Multiset.Entry<E>> entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator<E> elementIterator() {
        final Iterator<Map.Entry<E, Count>> r0 = this.backingMap.entrySet().iterator();
        return new AnonymousClass1(this, r0);
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator<Multiset.Entry<E>> entryIterator() {
        final Iterator<Map.Entry<E, Count>> r0 = this.backingMap.entrySet().iterator();
        return new AnonymousClass2(this, r0);
    }

    @Override // com.google.common.collect.Multiset
    public void forEachEntry(final ObjIntConsumer<? super E> r2) {
        Preconditions.checkNotNull(r2);
        this.backingMap.forEach(new AbstractMapBasedMultiset$$ExternalSyntheticLambda0(r2));
    }

    static /* synthetic */ void lambda$forEachEntry$0(ObjIntConsumer r0, Object r1, Count r2) {
        r0.accept(r1, r2.get());
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Iterator<Count> r0 = this.backingMap.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().set(0);
        goto L4
    L6:
        this.backingMap.clear();
        this.size = 0;
    }

    @Override // com.google.common.collect.AbstractMultiset
    int distinctElements() {
        return this.backingMap.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return Ints.saturatedCast(this.size);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return new MapBasedMultisetIterator(this);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@CheckForNull Object r1) {
        Count r0 = (Count) Maps.safeGet(this.backingMap, r1);
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.get();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int add(@ParametricNullness E r8, int r9) {
        if (r9 == 0) goto L4;
        boolean r0 = true;
        int r1 = 0;
        if (r9 <= 0) goto L8;
        boolean r2 = true;
    L9:
        Preconditions.checkArgument(r2, "occurrences cannot be negative: %s", r9);
        Count r3 = this.backingMap.get(r8);
        if (r3 != null) goto L12;
        this.backingMap.put(r8, new Count(r9));
    L17:
        this.size += (long) r9;
        return r1;
    L12:
        int r10 = r3.get();
        long r4 = ((long) r10) + ((long) r9);
        if (r4 <= 2147483647L) goto L16;
        r0 = false;
    L16:
        Preconditions.checkArgument(r0, "too many occurrences: %s", r4);
        r3.add(r9);
        r1 = r10;
        goto L17
    L8:
        r2 = false;
        goto L9
    L4:
        return count(r8);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int remove(@CheckForNull Object r4, int r5) {
        if (r5 != 0) goto L6;
        return count(r4);
    L6:
        if (r5 <= 0) goto L8;
        boolean r1 = true;
    L9:
        Preconditions.checkArgument(r1, "occurrences cannot be negative: %s", r5);
        Count r2 = this.backingMap.get(r4);
        if (r2 != null) goto L12;
        return 0;
    L12:
        int r0 = r2.get();
        if (r0 > r5) goto L16;
        this.backingMap.remove(r4);
        r5 = r0;
    L16:
        r2.add(-r5);
        this.size -= (long) r5;
        return r0;
    L8:
        r1 = false;
        goto L9
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int setCount(@ParametricNullness E r5, int r6) {
        CollectPreconditions.checkNonnegative(r6, "count");
        if (r6 != 0) goto L5;
        int r7 = getAndSet(this.backingMap.remove(r5), r6);
    L9:
        this.size += (long) (r6 - r7);
        return r7;
    L5:
        Count r0 = this.backingMap.get(r5);
        int r1 = getAndSet(r0, r6);
        if (r0 != null) goto L8;
        this.backingMap.put(r5, new Count(r6));
    L8:
        r7 = r1;
        goto L9
    }

    private static int getAndSet(@CheckForNull Count r0, int r1) {
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.getAndSet(r1);
    }

    private void readObjectNoData() throws ObjectStreamException {
        throw new InvalidObjectException("Stream data required");
    }
}
