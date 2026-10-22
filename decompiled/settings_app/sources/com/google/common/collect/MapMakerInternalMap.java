package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMakerInternalMap.InternalEntry;
import com.google.common.collect.MapMakerInternalMap.Segment;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes3.dex */
class MapMakerInternalMap<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    static final long CLEANUP_EXECUTOR_DELAY_SECS = 60;
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final WeakValueReference<Object, Object, DummyInternalEntry> UNSET_WEAK_VALUE_REFERENCE = null;
    private static final long serialVersionUID = 5;
    final int concurrencyLevel;
    final transient InternalEntryHelper<K, V, E, S> entryHelper;
    transient Set<Map.Entry<K, V>> entrySet;
    final Equivalence<Object> keyEquivalence;
    transient Set<K> keySet;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient Segment<K, V, E, S>[] segments;
    transient Collection<V> values;

    static abstract class AbstractSerializationProxy<K, V> extends ForwardingConcurrentMap<K, V> implements Serializable {
        private static final long serialVersionUID = 3;
        final int concurrencyLevel;
        transient ConcurrentMap<K, V> delegate;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;

        @Override // com.google.common.collect.ForwardingConcurrentMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingConcurrentMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Map delegate() {
            return delegate();
        }

        AbstractSerializationProxy(Strength r1, Strength r2, Equivalence<Object> r3, Equivalence<Object> r4, int r5, ConcurrentMap<K, V> r6) {
            this.keyStrength = r1;
            this.valueStrength = r2;
            this.keyEquivalence = r3;
            this.valueEquivalence = r4;
            this.concurrencyLevel = r5;
            this.delegate = r6;
        }

        @Override // com.google.common.collect.ForwardingConcurrentMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        protected ConcurrentMap<K, V> delegate() {
            return this.delegate;
        }

        void writeMapTo(ObjectOutputStream r3) throws IOException {
            r3.writeInt(this.delegate.size());
            Iterator<Map.Entry<K, V>> r2 = this.delegate.entrySet().iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            Map.Entry<K, V> r0 = r2.next();
            r3.writeObject(r0.getKey());
            r3.writeObject(r0.getValue());
            goto L4
        L6:
            r3.writeObject(null);
        }

        MapMaker readMapMaker(ObjectInputStream r2) throws IOException {
            int r3 = r2.readInt();
            return new MapMaker().initialCapacity(r3).setKeyStrength(this.keyStrength).setValueStrength(this.valueStrength).keyEquivalence(this.keyEquivalence).concurrencyLevel(this.concurrencyLevel);
        }

        void readEntries(ObjectInputStream r4) throws IOException, ClassNotFoundException {
        L2:
            Object r0 = r4.readObject();
            if (r0 == null) goto L4;
            Object r1 = r4.readObject();
            this.delegate.put((K) r0, (V) r1);
            goto L2
        }
    }

    static abstract class AbstractStrongKeyEntry<K, V, E extends InternalEntry<K, V, E>> implements InternalEntry<K, V, E> {
        final int hash;
        final K key;
        final E next;

        AbstractStrongKeyEntry(K r1, int r2, E r3) {
            this.key = r1;
            this.hash = r2;
            this.next = r3;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public K getKey() {
            return this.key;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public int getHash() {
            return this.hash;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public E getNext() {
            return this.next;
        }
    }

    static abstract class AbstractWeakKeyEntry<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<K> implements InternalEntry<K, V, E> {
        final int hash;
        final E next;

        AbstractWeakKeyEntry(ReferenceQueue<K> r1, K r2, int r3, E r4) {
            super(r2, r1);
            this.hash = r3;
            this.next = r4;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public K getKey() {
            return (K) get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public int getHash() {
            return this.hash;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public E getNext() {
            return this.next;
        }
    }

    static final class CleanupMapTask implements Runnable {
        final WeakReference<MapMakerInternalMap<?, ?, ?, ?>> mapReference;

        public CleanupMapTask(MapMakerInternalMap<?, ?, ?, ?> r2) {
            this.mapReference = new WeakReference(r2);
        }

        @Override // java.lang.Runnable
        public void run() {
            MapMakerInternalMap<?, ?, ?, ?> r3 = this.mapReference.get();
            if (r3 == null) goto L9;
            Segment<?, ?, E, S>[] r4 = r3.segments;
            int r0 = r4.length;
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L7;
            r4[r1].runCleanup();
            r1 = r1 + 1;
            goto L5
        L7:
            return;
        L9:
            throw new CancellationException();
        }
    }

    static final class DummyInternalEntry implements InternalEntry<Object, Object, DummyInternalEntry> {
        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public /* bridge */ /* synthetic */ InternalEntry getNext() {
            return getNext();
        }

        private DummyInternalEntry() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public DummyInternalEntry getNext() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public int getHash() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public Object getKey() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public Object getValue() {
            throw new AssertionError();
        }
    }

    final class EntryIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<Map.Entry<K, V>> {
        EntryIterator(MapMakerInternalMap r1) {
            super(r1);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.HashIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.HashIterator, java.util.Iterator
        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    final class EntrySet extends SafeToArraySet<Map.Entry<K, V>> {
        final /* synthetic */ MapMakerInternalMap this$0;

        EntrySet(MapMakerInternalMap r1) {
            this.this$0 = r1;
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(this.this$0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r4) {
            if ((r4 instanceof Map.Entry) == true) goto L5;
            return false;
        L5:
            Map.Entry r5 = (Map.Entry) r4;
            Object r0 = r5.getKey();
            if (r0 != null) goto L8;
            return false;
        L8:
            Object r1 = this.this$0.get(r0);
            if (r1 != null) goto L11;
            return false;
        L11:
            if (this.this$0.valueEquivalence().equivalent(r5.getValue(), r1) == false) goto L15;
            return true;
        L15:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r3) {
            if ((r3 instanceof Map.Entry) == true) goto L5;
            return false;
        L5:
            Map.Entry r4 = (Map.Entry) r3;
            Object r0 = r4.getKey();
            if (r0 != null) goto L8;
            return false;
        L8:
            if (this.this$0.remove(r0, r4.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.this$0.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }
    }

    abstract class HashIterator<T> implements Iterator<T> {
        Segment<K, V, E, S> currentSegment;
        AtomicReferenceArray<E> currentTable;
        MapMakerInternalMap<K, V, E, S>.WriteThroughEntry lastReturned;
        E nextEntry;
        MapMakerInternalMap<K, V, E, S>.WriteThroughEntry nextExternal;
        int nextSegmentIndex;
        int nextTableIndex;
        final /* synthetic */ MapMakerInternalMap this$0;

        @Override // java.util.Iterator
        public abstract T next();

        HashIterator(MapMakerInternalMap r1) {
            this.this$0 = r1;
            this.nextSegmentIndex = r1.segments.length - 1;
            this.nextTableIndex = -1;
            advance();
        }

        final void advance() {
            this.nextExternal = null;
            if (nextInChain() == false) goto L6;
            return;
        L6:
            if (nextInTable() == false) goto L9;
            return;
        L9:
            if (this.nextSegmentIndex < 0) goto L14;
            Segment<K, V, E, S>[] r0 = this.this$0.segments;
            int r1 = this.nextSegmentIndex;
            this.nextSegmentIndex = r1 - 1;
            Segment<K, V, E, S> r2 = r0[r1];
            this.currentSegment = r2;
            if (r2.count == 0) goto L9;
            AtomicReferenceArray<E> r3 = this.currentSegment.table;
            this.currentTable = r3;
            this.nextTableIndex = r3.length() - 1;
            if (nextInTable() == false) goto L9;
            return;
        }

        boolean nextInChain() {
            E r0 = this.nextEntry;
            if (r0 == null) goto L11;
        L4:
            this.nextEntry = (E) r0.getNext();
            E r1 = this.nextEntry;
            if (r1 == null) goto L15;
            if (advanceTo(r1) == true) goto L8;
            r0 = this.nextEntry;
            goto L4
        L8:
            return true;
        L15:
            return false;
        L11:
            return false;
        }

        boolean nextInTable() {
        L2:
            int r0 = this.nextTableIndex;
            if (r0 < 0) goto L12;
            AtomicReferenceArray<E> r1 = this.currentTable;
            this.nextTableIndex = r0 - 1;
            E r2 = r1.get(r0);
            this.nextEntry = r2;
            if (r2 == null) goto L2;
            if (advanceTo(r2) == true) goto L10;
            if (nextInChain() == false) goto L2;
            return true;
        L10:
            return true;
        L12:
            return false;
        }

        boolean advanceTo(E r4) {
            Object r0 = r4.getKey();     // Catch: Throwable -> L9
            Object r5 = this.this$0.getLiveValue(r4);     // Catch: Throwable -> L9
            if (r5 == null) goto L7;
            this.nextExternal = new WriteThroughEntry(this.this$0, r0, r5);     // Catch: Throwable -> L9
            this.currentSegment.postReadCleanup();
            return true;
        L7:
            this.currentSegment.postReadCleanup();
            return false;
        L9:
            th = move-exception;
            this.currentSegment.postReadCleanup();
            throw th;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextExternal == null) goto L5;
            return true;
        L5:
            return false;
        }

        MapMakerInternalMap<K, V, E, S>.WriteThroughEntry nextEntry() {
            MapMakerInternalMap<K, V, E, S>.WriteThroughEntry r0 = this.nextExternal;
            if (r0 == null) goto L7;
            this.lastReturned = r0;
            advance();
            return this.lastReturned;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.lastReturned == null) goto L5;
            boolean r0 = true;
        L6:
            CollectPreconditions.checkRemove(r0);
            this.this$0.remove(this.lastReturned.getKey());
            this.lastReturned = null;
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    interface InternalEntry<K, V, E extends InternalEntry<K, V, E>> {
        int getHash();

        K getKey();

        E getNext();

        V getValue();
    }

    interface InternalEntryHelper<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> {
        E copy(S r1, E r2, E r3);

        Strength keyStrength();

        E newEntry(S r1, K r2, int r3, E r4);

        S newSegment(MapMakerInternalMap<K, V, E, S> r1, int r2, int r3);

        void setValue(S r1, E r2, V r3);

        Strength valueStrength();
    }

    final class KeyIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<K> {
        KeyIterator(MapMakerInternalMap r1) {
            super(r1);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.HashIterator, java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }
    }

    final class KeySet extends SafeToArraySet<K> {
        final /* synthetic */ MapMakerInternalMap this$0;

        KeySet(MapMakerInternalMap r1) {
            this.this$0 = r1;
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new KeyIterator(this.this$0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.this$0.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return this.this$0.containsKey(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r1) {
            if (this.this$0.remove(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }
    }

    private static abstract class SafeToArraySet<E> extends AbstractSet<E> {
        private SafeToArraySet() {
        }

        /* synthetic */ SafeToArraySet(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return MapMakerInternalMap.access$900(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r1) {
            return (T[]) MapMakerInternalMap.access$900(this).toArray(r1);
        }
    }

    static abstract class Segment<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {
        volatile int count;
        final MapMakerInternalMap<K, V, E, S> map;
        final int maxSegmentSize;
        int modCount;
        final AtomicInteger readCount;
        volatile AtomicReferenceArray<E> table;
        int threshold;

        abstract E castForTesting(InternalEntry<K, V, ?> r1);

        void maybeClearReferenceQueues() {
        }

        void maybeDrainReferenceQueues() {
        }

        abstract S self();

        Segment(MapMakerInternalMap<K, V, E, S> r2, int r3, int r4) {
            this.readCount = new AtomicInteger();
            this.map = r2;
            this.maxSegmentSize = r4;
            initTable(newEntryArray(r3));
        }

        void setValue(E r2, V r3) {
            this.map.entryHelper.setValue(self(), r2, r3);
        }

        E copyEntry(E r2, E r3) {
            return (E) this.map.entryHelper.copy(self(), r2, r3);
        }

        AtomicReferenceArray<E> newEntryArray(int r1) {
            return new AtomicReferenceArray(r1);
        }

        void initTable(AtomicReferenceArray<E> r3) {
            int r0 = (r3.length() * 3) / 4;
            this.threshold = r0;
            if (r0 != this.maxSegmentSize) goto L5;
            this.threshold = r0 + 1;
        L5:
            this.table = r3;
        }

        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            throw new AssertionError();
        }

        ReferenceQueue<V> getValueReferenceQueueForTesting() {
            throw new AssertionError();
        }

        WeakValueReference<K, V, E> getWeakValueReferenceForTesting(InternalEntry<K, V, ?> r1) {
            throw new AssertionError();
        }

        WeakValueReference<K, V, E> newWeakValueReferenceForTesting(InternalEntry<K, V, ?> r1, V r2) {
            throw new AssertionError();
        }

        void setWeakValueReferenceForTesting(InternalEntry<K, V, ?> r1, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> r2) {
            throw new AssertionError();
        }

        void setTableEntryForTesting(int r2, InternalEntry<K, V, ?> r3) {
            this.table.set(r2, (E) castForTesting(r3));
        }

        E copyForTesting(InternalEntry<K, V, ?> r3, InternalEntry<K, V, ?> r4) {
            return (E) this.map.entryHelper.copy(self(), castForTesting(r3), castForTesting(r4));
        }

        void setValueForTesting(InternalEntry<K, V, ?> r3, V r4) {
            this.map.entryHelper.setValue(self(), castForTesting(r3), r4);
        }

        E newEntryForTesting(K r3, int r4, InternalEntry<K, V, ?> r5) {
            return (E) this.map.entryHelper.newEntry(self(), r3, r4, castForTesting(r5));
        }

        boolean removeTableEntryForTesting(InternalEntry<K, V, ?> r1) {
            return removeEntryForTesting(castForTesting(r1));
        }

        E removeFromChainForTesting(InternalEntry<K, V, ?> r1, InternalEntry<K, V, ?> r2) {
            return (E) removeFromChain(castForTesting(r1), castForTesting(r2));
        }

        V getLiveValueForTesting(InternalEntry<K, V, ?> r1) {
            return getLiveValue(castForTesting(r1));
        }

        void tryDrainReferenceQueues() {
            if (tryLock() == true) goto L10;
            return;
        L10:
            maybeDrainReferenceQueues();     // Catch: Throwable -> L6
            unlock();
            return;
        L6:
            th = move-exception;
            unlock();
            throw th;
        }

        void drainKeyReferenceQueue(ReferenceQueue<K> r4) {
            int r0 = 0;
        L3:
            Reference<? extends K> r1 = r4.poll();
            if (r1 == null) goto L7;
            MapMakerInternalMap<K, V, E, S> r2 = this.map;
            r2.reclaimKey((InternalEntry) r1);
            r0 = r0 + 1;
            if (r0 != 16) goto L3;
            return;
        }

        void drainValueReferenceQueue(ReferenceQueue<V> r4) {
            int r0 = 0;
        L3:
            Reference<? extends V> r1 = r4.poll();
            if (r1 == null) goto L7;
            MapMakerInternalMap<K, V, E, S> r2 = this.map;
            r2.reclaimValue((WeakValueReference) r1);
            r0 = r0 + 1;
            if (r0 != 16) goto L3;
            return;
        }

        <T> void clearReferenceQueue(ReferenceQueue<T> r1) {
        L3:
            if (r1.poll() != null) goto L3;
        }

        E getFirst(int r2) {
            AtomicReferenceArray<E> r1 = this.table;
            return r1.get(r2 & (r1.length() - 1));
        }

        E getEntry(Object r4, int r5) {
            if (this.count == 0) goto L16;
            E r0 = (E) getFirst(r5);
        L5:
            if (r0 == null) goto L23;
            if (r0.getHash() != r5) goto L15;
            Object r1 = r0.getKey();
            if (r1 != null) goto L13;
            tryDrainReferenceQueues();
            goto L15
        L13:
            if (this.map.keyEquivalence.equivalent(r4, r1) == false) goto L15;
            return r0;
        L15:
            r0 = (E) r0.getNext();
            goto L5
        L23:
            return null;
        L16:
            return null;
        }

        E getLiveEntry(Object r1, int r2) {
            return (E) getEntry(r1, r2);
        }

        V get(Object r1, int r2) {
            InternalEntry r3 = getLiveEntry(r1, r2);     // Catch: Throwable -> L11
            if (r3 != null) goto L6;
            postReadCleanup();
            return null;
        L6:
            V r4 = (V) r3.getValue();
            if (r4 != null) goto L9;
            tryDrainReferenceQueues();     // Catch: Throwable -> L11
        L9:
            postReadCleanup();
            return r4;
        L11:
            th = move-exception;
            postReadCleanup();
            throw th;
        }

        boolean containsKey(Object r3, int r4) {
            boolean r1 = false;
            if (this.count == 0) goto L11;
            InternalEntry r5 = getLiveEntry(r3, r4);     // Catch: Throwable -> L13
            if (r5 == null) goto L9;
            if (r5.getValue() == null) goto L9;
            r1 = true;
        L9:
            postReadCleanup();
            return r1;
        L11:
            postReadCleanup();
            return false;
        L13:
            th = move-exception;
            postReadCleanup();
            throw th;
        }

        boolean containsValue(Object r8) {
        L20:
            th = move-exception;
            postReadCleanup();
            throw th;
        L3:
            if (this.count == 0) goto L18;
            AtomicReferenceArray<E> r0 = this.table;     // Catch: Throwable -> L20
            int r2 = r0.length();     // Catch: Throwable -> L20
            int r3 = 0;
        L5:
            if (r3 >= r2) goto L18;
            E r4 = r0.get(r3);     // Catch: Throwable -> L20
        L7:
            if (r4 == null) goto L17;
            V r5 = getLiveValue(r4);     // Catch: Throwable -> L20
            if (r5 != null) goto L12;
        L15:
            r4 = r4.getNext();     // Catch: Throwable -> L20
            goto L7
        L12:
            if (this.map.valueEquivalence().equivalent(r8, r5) == false) goto L15;
            postReadCleanup();
            return true;
        L17:
            r3 = r3 + 1;
        L18:
            postReadCleanup();
            return false;
        }

        V put(K r9, int r10, V r11, boolean r12) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L29
            int r0 = this.count + 1;     // Catch: Throwable -> L29
            if (r0 <= this.threshold) goto L6;
            expand();     // Catch: Throwable -> L29
            r0 = this.count + 1;     // Catch: Throwable -> L29
        L6:
            AtomicReferenceArray<E> r1 = this.table;     // Catch: Throwable -> L29
            int r2 = (r1.length() - 1) & r10;     // Catch: Throwable -> L29
            E r3 = r1.get(r2);     // Catch: Throwable -> L29
            InternalEntry r4 = r3;
        L8:
            if (r4 == null) goto L26;
            Object r6 = r4.getKey();     // Catch: Throwable -> L29
            if (r4.getHash() != r10) goto L25;
            if (r6 == null) goto L25;
            if (this.map.keyEquivalence.equivalent(r9, r6) == false) goto L25;
            V r13 = (V) r4.getValue();
            if (r13 != null) goto L19;
            this.modCount++;     // Catch: Throwable -> L29
            setValue(r4, r11);     // Catch: Throwable -> L29
            this.count = this.count;     // Catch: Throwable -> L29
            unlock();
            return null;
        L19:
            if (r12 == false) goto L22;
            unlock();
            return r13;
        L22:
            this.modCount++;     // Catch: Throwable -> L29
            setValue(r4, r11);     // Catch: Throwable -> L29
            unlock();
            return r13;
        L25:
            r4 = r4.getNext();     // Catch: Throwable -> L29
            goto L8
        L26:
            this.modCount++;     // Catch: Throwable -> L29
            InternalEntry r14 = this.map.entryHelper.newEntry(self(), r9, r10, r3);     // Catch: Throwable -> L29
            setValue(r14, r11);     // Catch: Throwable -> L29
            r1.set(r2, (E) r14);     // Catch: Throwable -> L29
            this.count = r0;     // Catch: Throwable -> L29
            unlock();
            return null;
        L29:
            th = move-exception;
            unlock();
            throw th;
        }

        void expand() {
            AtomicReferenceArray<E> r0 = this.table;
            int r1 = r0.length();
            if (r1 < 1073741824) goto L5;
            return;
        L5:
            int r2 = this.count;
            AtomicReferenceArray<E> r3 = newEntryArray(r1 << 1);
            this.threshold = (r3.length() * 3) / 4;
            int r4 = r3.length() - 1;
            int r5 = 0;
        L6:
            if (r5 >= r1) goto L26;
            E r6 = r0.get(r5);
            if (r6 == null) goto L25;
            InternalEntry r7 = r6.getNext();
            int r8 = r6.getHash() & r4;
            if (r7 != null) goto L12;
            r3.set(r8, r6);
            goto L25
        L12:
            InternalEntry r9 = r6;
        L13:
            if (r7 == null) goto L18;
            int r10 = r7.getHash() & r4;
            if (r10 == r8) goto L17;
            r9 = r7;
            r8 = r10;
        L17:
            r7 = r7.getNext();
            goto L13
        L18:
            r3.set(r8, r9);
        L19:
            if (r6 == r9) goto L25;
            int r11 = r6.getHash() & r4;
            InternalEntry r12 = copyEntry(r6, (InternalEntry) r3.get(r11));
            if (r12 == null) goto L23;
            r3.set(r11, r12);
        L24:
            r6 = r6.getNext();
            goto L19
        L23:
            r2 = r2 - 1;
        L25:
            r5 = r5 + 1;
            goto L6
        L26:
            this.table = r3;
            this.count = r2;
        }

        boolean replace(K r9, int r10, V r11, V r12) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L29
            AtomicReferenceArray<E> r0 = this.table;     // Catch: Throwable -> L29
            int r1 = (r0.length() - 1) & r10;     // Catch: Throwable -> L29
            E r3 = r0.get(r1);     // Catch: Throwable -> L29
            InternalEntry r4 = r3;
        L5:
            if (r4 == null) goto L27;
            Object r6 = r4.getKey();     // Catch: Throwable -> L29
            if (r4.getHash() != r10) goto L25;
            if (r6 == null) goto L25;
            if (this.map.keyEquivalence.equivalent(r9, r6) == false) goto L25;
            Object r13 = r4.getValue();     // Catch: Throwable -> L29
            if (r13 != null) goto L19;
            if (isCollected(r4) == false) goto L16;
            this.modCount++;     // Catch: Throwable -> L29
            InternalEntry r14 = removeFromChain(r3, r4);     // Catch: Throwable -> L29
            int r15 = this.count - 1;     // Catch: Throwable -> L29
            r0.set(r1, (E) r14);     // Catch: Throwable -> L29
            this.count = r15;     // Catch: Throwable -> L29
        L16:
            unlock();
            return false;
        L19:
            if (this.map.valueEquivalence().equivalent(r11, r13) == false) goto L23;
            this.modCount++;     // Catch: Throwable -> L29
            setValue(r4, r12);     // Catch: Throwable -> L29
            unlock();
            return true;
        L23:
            unlock();
            return false;
        L25:
            r4 = r4.getNext();     // Catch: Throwable -> L29
            goto L5
        L27:
            unlock();
            return false;
        L29:
            th = move-exception;
            unlock();
            throw th;
        }

        V replace(K r8, int r9, V r10) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L25
            AtomicReferenceArray<E> r0 = this.table;     // Catch: Throwable -> L25
            int r1 = (r0.length() - 1) & r9;     // Catch: Throwable -> L25
            E r2 = r0.get(r1);     // Catch: Throwable -> L25
            InternalEntry r3 = r2;
        L5:
            if (r3 == null) goto L23;
            Object r5 = r3.getKey();     // Catch: Throwable -> L25
            if (r3.getHash() != r9) goto L21;
            if (r5 == null) goto L21;
            if (this.map.keyEquivalence.equivalent(r8, r5) == false) goto L21;
            V r11 = (V) r3.getValue();
            if (r11 == null) goto L14;
            this.modCount++;     // Catch: Throwable -> L25
            setValue(r3, r10);     // Catch: Throwable -> L25
            unlock();
            return r11;
        L14:
            if (isCollected(r3) == false) goto L16;
            this.modCount++;     // Catch: Throwable -> L25
            InternalEntry r12 = removeFromChain(r2, r3);     // Catch: Throwable -> L25
            int r13 = this.count - 1;     // Catch: Throwable -> L25
            r0.set(r1, (E) r12);     // Catch: Throwable -> L25
            this.count = r13;     // Catch: Throwable -> L25
        L16:
            unlock();
            return null;
        L21:
            r3 = r3.getNext();     // Catch: Throwable -> L25
            goto L5
        L23:
            unlock();
            return null;
        L25:
            th = move-exception;
            unlock();
            throw th;
        }

        V remove(Object r8, int r9) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L25
            AtomicReferenceArray<E> r0 = this.table;     // Catch: Throwable -> L25
            int r1 = (r0.length() - 1) & r9;     // Catch: Throwable -> L25
            E r2 = r0.get(r1);     // Catch: Throwable -> L25
            InternalEntry r3 = r2;
        L5:
            if (r3 == null) goto L23;
            Object r5 = r3.getKey();     // Catch: Throwable -> L25
            if (r3.getHash() != r9) goto L21;
            if (r5 == null) goto L21;
            if (this.map.keyEquivalence.equivalent(r8, r5) == false) goto L21;
            V r10 = (V) r3.getValue();
            if (r10 == null) goto L15;
        L16:
            this.modCount++;     // Catch: Throwable -> L25
            InternalEntry r11 = removeFromChain(r2, r3);     // Catch: Throwable -> L25
            int r4 = this.count - 1;     // Catch: Throwable -> L25
            r0.set(r1, (E) r11);     // Catch: Throwable -> L25
            this.count = r4;     // Catch: Throwable -> L25
            unlock();
            return r10;
        L15:
            if (isCollected(r3) == true) goto L16;
            unlock();
            return null;
        L21:
            r3 = r3.getNext();     // Catch: Throwable -> L25
            goto L5
        L23:
            unlock();
            return null;
        L25:
            th = move-exception;
            unlock();
            throw th;
        }

        boolean remove(Object r9, int r10, Object r11) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L25
            AtomicReferenceArray<E> r0 = this.table;     // Catch: Throwable -> L25
            int r1 = (r0.length() - 1) & r10;     // Catch: Throwable -> L25
            E r3 = r0.get(r1);     // Catch: Throwable -> L25
            InternalEntry r4 = r3;
        L4:
            boolean r5 = false;
            if (r4 == null) goto L23;
            Object r6 = r4.getKey();     // Catch: Throwable -> L25
            if (r4.getHash() != r10) goto L21;
            if (r6 == null) goto L21;
            if (this.map.keyEquivalence.equivalent(r9, r6) == false) goto L21;
            if (this.map.valueEquivalence().equivalent(r11, r4.getValue()) == false) goto L15;
            r5 = true;
        L16:
            this.modCount++;     // Catch: Throwable -> L25
            InternalEntry r12 = removeFromChain(r3, r4);     // Catch: Throwable -> L25
            int r13 = this.count - 1;     // Catch: Throwable -> L25
            r0.set(r1, (E) r12);     // Catch: Throwable -> L25
            this.count = r13;     // Catch: Throwable -> L25
            unlock();
            return r5;
        L15:
            if (isCollected(r4) == true) goto L16;
            unlock();
            return false;
        L21:
            r4 = r4.getNext();     // Catch: Throwable -> L25
            goto L4
        L23:
            unlock();
            return false;
        L25:
            th = move-exception;
            unlock();
            throw th;
        }

        void clear() {
            if (this.count == 0) goto L14;
            lock();
            AtomicReferenceArray<E> r0 = this.table;     // Catch: Throwable -> L11
            int r2 = 0;
        L7:
            if (r2 >= r0.length()) goto L9;
            r0.set(r2, null);     // Catch: Throwable -> L11
            r2 = r2 + 1;     // Catch: Throwable -> L11
            goto L7
        L9:
            maybeClearReferenceQueues();     // Catch: Throwable -> L11
            this.readCount.set(0);     // Catch: Throwable -> L11
            this.modCount++;     // Catch: Throwable -> L11
            this.count = 0;     // Catch: Throwable -> L11
            unlock();
            return;
        L11:
            th = move-exception;
            unlock();
            throw th;
        }

        E removeFromChain(E r4, E r5) {
            int r0 = this.count;
            E r1 = (E) r5.getNext();
        L3:
            if (r4 == r5) goto L9;
            InternalEntry r2 = copyEntry(r4, r1);
            if (r2 == null) goto L7;
            r1 = (E) r2;
        L8:
            r4 = (E) r4.getNext();
            goto L3
        L7:
            r0 = r0 - 1;
            goto L8
        L9:
            this.count = r0;
            return r1;
        }

        boolean reclaimKey(E r5, int r6) {
            lock();
            AtomicReferenceArray<E> r0 = this.table;     // Catch: Throwable -> L13
            int r7 = r6 & (r0.length() - 1);     // Catch: Throwable -> L13
            E r1 = r0.get(r7);     // Catch: Throwable -> L13
            InternalEntry r3 = r1;
        L4:
            if (r3 == null) goto L11;
            if (r3 == r5) goto L6;
            r3 = r3.getNext();     // Catch: Throwable -> L13
            goto L4
        L6:
            this.modCount++;     // Catch: Throwable -> L13
            InternalEntry r8 = removeFromChain(r1, r3);     // Catch: Throwable -> L13
            int r2 = this.count - 1;     // Catch: Throwable -> L13
            r0.set(r7, (E) r8);     // Catch: Throwable -> L13
            this.count = r2;     // Catch: Throwable -> L13
            unlock();
            return true;
        L11:
            unlock();
            return false;
        L13:
            th = move-exception;
            unlock();
            throw th;
        }

        boolean reclaimValue(K r9, int r10, WeakValueReference<K, V, E> r11) {
            lock();
            AtomicReferenceArray<E> r0 = this.table;     // Catch: Throwable -> L22
            int r1 = (r0.length() - 1) & r10;     // Catch: Throwable -> L22
            E r3 = r0.get(r1);     // Catch: Throwable -> L22
            InternalEntry r4 = r3;
        L5:
            if (r4 == null) goto L20;
            Object r6 = r4.getKey();     // Catch: Throwable -> L22
            if (r4.getHash() != r10) goto L18;
            if (r6 == null) goto L18;
            if (this.map.keyEquivalence.equivalent(r9, r6) == false) goto L18;
            if (((WeakValueEntry) r4).getValueReference() != r11) goto L16;
            this.modCount++;     // Catch: Throwable -> L22
            InternalEntry r12 = removeFromChain(r3, r4);     // Catch: Throwable -> L22
            int r13 = this.count - 1;     // Catch: Throwable -> L22
            r0.set(r1, (E) r12);     // Catch: Throwable -> L22
            this.count = r13;     // Catch: Throwable -> L22
            unlock();
            return true;
        L16:
            unlock();
            return false;
        L18:
            r4 = r4.getNext();     // Catch: Throwable -> L22
            goto L5
        L20:
            unlock();
            return false;
        L22:
            th = move-exception;
            unlock();
            throw th;
        }

        boolean clearValueForTesting(K r9, int r10, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> r11) {
            lock();
            AtomicReferenceArray<E> r0 = this.table;     // Catch: Throwable -> L22
            int r1 = (r0.length() - 1) & r10;     // Catch: Throwable -> L22
            E r3 = r0.get(r1);     // Catch: Throwable -> L22
            InternalEntry r4 = r3;
        L5:
            if (r4 == null) goto L20;
            Object r6 = r4.getKey();     // Catch: Throwable -> L22
            if (r4.getHash() != r10) goto L18;
            if (r6 == null) goto L18;
            if (this.map.keyEquivalence.equivalent(r9, r6) == false) goto L18;
            if (((WeakValueEntry) r4).getValueReference() != r11) goto L16;
            r0.set(r1, (E) removeFromChain(r3, r4));     // Catch: Throwable -> L22
            unlock();
            return true;
        L16:
            unlock();
            return false;
        L18:
            r4 = r4.getNext();     // Catch: Throwable -> L22
            goto L5
        L20:
            unlock();
            return false;
        L22:
            th = move-exception;
            unlock();
            throw th;
        }

        boolean removeEntryForTesting(E r6) {
            int r0 = r6.getHash();
            AtomicReferenceArray<E> r1 = this.table;
            int r2 = r0 & (r1.length() - 1);
            E r3 = r1.get(r2);
            InternalEntry r4 = r3;
        L3:
            if (r4 == null) goto L8;
            if (r4 == r6) goto L5;
            r4 = r4.getNext();
            goto L3
        L5:
            this.modCount++;
            InternalEntry r7 = removeFromChain(r3, r4);
            int r5 = this.count - 1;
            r1.set(r2, (E) r7);
            this.count = r5;
            return true;
        L8:
            return false;
        }

        static <K, V, E extends InternalEntry<K, V, E>> boolean isCollected(E r0) {
            if (r0.getValue() != null) goto L5;
            return true;
        L5:
            return false;
        }

        V getLiveValue(E r3) {
            if (r3.getKey() != null) goto L6;
            tryDrainReferenceQueues();
            return null;
        L6:
            V r4 = (V) r3.getValue();
            if (r4 != null) goto L10;
            tryDrainReferenceQueues();
            return null;
        L10:
            return r4;
        }

        void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) != 0) goto L6;
            runCleanup();
            return;
        }

        void preWriteCleanup() {
            runLockedCleanup();
        }

        void runCleanup() {
            runLockedCleanup();
        }

        void runLockedCleanup() {
            if (tryLock() == true) goto L10;
            return;
        L10:
            maybeDrainReferenceQueues();     // Catch: Throwable -> L6
            this.readCount.set(0);     // Catch: Throwable -> L6
            unlock();
            return;
        L6:
            th = move-exception;
            unlock();
            throw th;
        }
    }

    private static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        SerializationProxy(Strength r1, Strength r2, Equivalence<Object> r3, Equivalence<Object> r4, int r5, ConcurrentMap<K, V> r6) {
            super(r1, r2, r3, r4, r5, r6);
        }

        private void writeObject(ObjectOutputStream r1) throws IOException {
            r1.defaultWriteObject();
            writeMapTo(r1);
        }

        private void readObject(ObjectInputStream r2) throws IOException, ClassNotFoundException {
            r2.defaultReadObject();
            this.delegate = readMapMaker(r2).makeMap();
            readEntries(r2);
        }

        private Object readResolve() {
            return this.delegate;
        }
    }

    static abstract enum Strength extends Enum<Strength> {
        private static final /* synthetic */ Strength[] $VALUES = null;
        public static final Strength STRONG = null;
        public static final Strength WEAK = null;

        abstract Equivalence<Object> defaultEquivalence();

        private static /* synthetic */ Strength[] $values() {
            return new Strength[]{STRONG, WEAK};
        }

        private Strength(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ Strength(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static Strength valueOf(String r1) {
            return (Strength) Enum.valueOf(Strength.class, r1);
        }

        public static Strength[] values() {
            return (Strength[]) $VALUES.clone();
        }

        static {
            final String r1 = "STRONG";
            final int r2 = 0;
            STRONG = new AnonymousClass1(r1, r2);
            final String r3 = "WEAK";
            final int r4 = 1;
            WEAK = new AnonymousClass2(r3, r4);
            $VALUES = $values();
        }
    }

    static final class StrongKeyDummyValueEntry<K> extends AbstractStrongKeyEntry<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>> implements StrongValueEntry<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>> {

        static final class Helper<K> implements InternalEntryHelper<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> {
            private static final Helper<?> INSTANCE = null;

            public void setValue(StrongKeyDummyValueSegment<K> r1, StrongKeyDummyValueEntry<K> r2, MapMaker.Dummy r3) {
            }

            Helper() {
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry copy(Segment r1, InternalEntry r2, InternalEntry r3) {
                return copy((StrongKeyDummyValueSegment) r1, (StrongKeyDummyValueEntry) r2, (StrongKeyDummyValueEntry) r3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry newEntry(Segment r1, Object r2, int r3, InternalEntry r4) {
                return newEntry((StrongKeyDummyValueSegment) r1, r2, r3, (StrongKeyDummyValueEntry) r4);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ Segment newSegment(MapMakerInternalMap r1, int r2, int r3) {
                return newSegment(r1, r2, r3);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ void setValue(Segment r1, InternalEntry r2, MapMaker.Dummy r3) {
                setValue((StrongKeyDummyValueSegment) r1, (StrongKeyDummyValueEntry) r2, r3);
            }

            static {
                INSTANCE = new Helper();
            }

            static <K> Helper<K> instance() {
                return (Helper<K>) INSTANCE;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public StrongKeyDummyValueSegment<K> newSegment(MapMakerInternalMap<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> r1, int r2, int r3) {
                return new StrongKeyDummyValueSegment(r1, r2, r3);
            }

            public StrongKeyDummyValueEntry<K> copy(StrongKeyDummyValueSegment<K> r1, StrongKeyDummyValueEntry<K> r2, StrongKeyDummyValueEntry<K> r3) {
                return r2.copy(r3);
            }

            public StrongKeyDummyValueEntry<K> newEntry(StrongKeyDummyValueSegment<K> r1, K r2, int r3, StrongKeyDummyValueEntry<K> r4) {
                return new StrongKeyDummyValueEntry(r2, r3, r4);
            }
        }

        void setValue(MapMaker.Dummy r1) {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public /* bridge */ /* synthetic */ Object getValue() {
            return getValue();
        }

        StrongKeyDummyValueEntry(K r1, int r2, StrongKeyDummyValueEntry<K> r3) {
            super(r1, r2, r3);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }

        StrongKeyDummyValueEntry<K> copy(StrongKeyDummyValueEntry<K> r3) {
            return new StrongKeyDummyValueEntry(this.key, this.hash, r3);
        }
    }

    static final class StrongKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> {
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        StrongKeyDummyValueSegment<K> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ InternalEntry castForTesting(InternalEntry r1) {
            return castForTesting(r1);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* bridge */ /* synthetic */ Segment self() {
            return self();
        }

        StrongKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> r1, int r2, int r3) {
            super(r1, r2, r3);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyDummyValueEntry<K> castForTesting(InternalEntry<K, MapMaker.Dummy, ?> r1) {
            return (StrongKeyDummyValueEntry) r1;
        }
    }

    static final class StrongKeyStrongValueEntry<K, V> extends AbstractStrongKeyEntry<K, V, StrongKeyStrongValueEntry<K, V>> implements StrongValueEntry<K, V, StrongKeyStrongValueEntry<K, V>> {
        private volatile V value;

        static final class Helper<K, V> implements InternalEntryHelper<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> {
            private static final Helper<?, ?> INSTANCE = null;

            Helper() {
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry copy(Segment r1, InternalEntry r2, InternalEntry r3) {
                return copy((StrongKeyStrongValueSegment) r1, (StrongKeyStrongValueEntry) r2, (StrongKeyStrongValueEntry) r3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry newEntry(Segment r1, Object r2, int r3, InternalEntry r4) {
                return newEntry((StrongKeyStrongValueSegment) r1, r2, r3, (StrongKeyStrongValueEntry) r4);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ Segment newSegment(MapMakerInternalMap r1, int r2, int r3) {
                return newSegment(r1, r2, r3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ void setValue(Segment r1, InternalEntry r2, Object r3) {
                setValue((StrongKeyStrongValueSegment) r1, (StrongKeyStrongValueEntry) r2, r3);
            }

            static {
                INSTANCE = new Helper();
            }

            static <K, V> Helper<K, V> instance() {
                return (Helper<K, V>) INSTANCE;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public StrongKeyStrongValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> r1, int r2, int r3) {
                return new StrongKeyStrongValueSegment(r1, r2, r3);
            }

            public StrongKeyStrongValueEntry<K, V> copy(StrongKeyStrongValueSegment<K, V> r1, StrongKeyStrongValueEntry<K, V> r2, StrongKeyStrongValueEntry<K, V> r3) {
                return r2.copy(r3);
            }

            public void setValue(StrongKeyStrongValueSegment<K, V> r1, StrongKeyStrongValueEntry<K, V> r2, V r3) {
                r2.setValue(r3);
            }

            public StrongKeyStrongValueEntry<K, V> newEntry(StrongKeyStrongValueSegment<K, V> r1, K r2, int r3, StrongKeyStrongValueEntry<K, V> r4) {
                return new StrongKeyStrongValueEntry(r2, r3, r4);
            }
        }

        StrongKeyStrongValueEntry(K r1, int r2, StrongKeyStrongValueEntry<K, V> r3) {
            super(r1, r2, r3);
            this.value = null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public V getValue() {
            return this.value;
        }

        void setValue(V r1) {
            this.value = r1;
        }

        StrongKeyStrongValueEntry<K, V> copy(StrongKeyStrongValueEntry<K, V> r4) {
            StrongKeyStrongValueEntry<K, V> r0 = new StrongKeyStrongValueEntry(this.key, this.hash, r4);
            r0.value = this.value;
            return r0;
        }
    }

    static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> {
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        StrongKeyStrongValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ InternalEntry castForTesting(InternalEntry r1) {
            return castForTesting(r1);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* bridge */ /* synthetic */ Segment self() {
            return self();
        }

        StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> r1, int r2, int r3) {
            super(r1, r2, r3);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyStrongValueEntry<K, V> castForTesting(InternalEntry<K, V, ?> r1) {
            return (StrongKeyStrongValueEntry) r1;
        }
    }

    static final class StrongKeyWeakValueEntry<K, V> extends AbstractStrongKeyEntry<K, V, StrongKeyWeakValueEntry<K, V>> implements WeakValueEntry<K, V, StrongKeyWeakValueEntry<K, V>> {
        private volatile WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> valueReference;

        static final class Helper<K, V> implements InternalEntryHelper<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> {
            private static final Helper<?, ?> INSTANCE = null;

            Helper() {
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry copy(Segment r1, InternalEntry r2, InternalEntry r3) {
                return copy((StrongKeyWeakValueSegment) r1, (StrongKeyWeakValueEntry) r2, (StrongKeyWeakValueEntry) r3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry newEntry(Segment r1, Object r2, int r3, InternalEntry r4) {
                return newEntry((StrongKeyWeakValueSegment) r1, r2, r3, (StrongKeyWeakValueEntry) r4);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ Segment newSegment(MapMakerInternalMap r1, int r2, int r3) {
                return newSegment(r1, r2, r3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ void setValue(Segment r1, InternalEntry r2, Object r3) {
                setValue((StrongKeyWeakValueSegment) r1, (StrongKeyWeakValueEntry) r2, r3);
            }

            static {
                INSTANCE = new Helper();
            }

            static <K, V> Helper<K, V> instance() {
                return (Helper<K, V>) INSTANCE;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public StrongKeyWeakValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> r1, int r2, int r3) {
                return new StrongKeyWeakValueSegment(r1, r2, r3);
            }

            public StrongKeyWeakValueEntry<K, V> copy(StrongKeyWeakValueSegment<K, V> r1, StrongKeyWeakValueEntry<K, V> r2, StrongKeyWeakValueEntry<K, V> r3) {
                if (Segment.isCollected(r2) == false) goto L7;
                return null;
            L7:
                return r2.copy(StrongKeyWeakValueSegment.access$100(r1), r3);
            }

            public void setValue(StrongKeyWeakValueSegment<K, V> r1, StrongKeyWeakValueEntry<K, V> r2, V r3) {
                r2.setValue(r3, StrongKeyWeakValueSegment.access$100(r1));
            }

            public StrongKeyWeakValueEntry<K, V> newEntry(StrongKeyWeakValueSegment<K, V> r1, K r2, int r3, StrongKeyWeakValueEntry<K, V> r4) {
                return new StrongKeyWeakValueEntry(r2, r3, r4);
            }
        }

        static /* synthetic */ WeakValueReference access$600(StrongKeyWeakValueEntry r0) {
            return r0.valueReference;
        }

        static /* synthetic */ WeakValueReference access$602(StrongKeyWeakValueEntry r0, WeakValueReference r1) {
            r0.valueReference = r1;
            return r1;
        }

        StrongKeyWeakValueEntry(K r1, int r2, StrongKeyWeakValueEntry<K, V> r3) {
            super(r1, r2, r3);
            this.valueReference = MapMakerInternalMap.unsetWeakValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public V getValue() {
            return this.valueReference.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public void clearValue() {
            this.valueReference.clear();
        }

        void setValue(V r3, ReferenceQueue<V> r4) {
            WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> r0 = this.valueReference;
            this.valueReference = new WeakValueReferenceImpl(r4, r3, this);
            r0.clear();
        }

        StrongKeyWeakValueEntry<K, V> copy(ReferenceQueue<V> r4, StrongKeyWeakValueEntry<K, V> r5) {
            StrongKeyWeakValueEntry<K, V> r0 = new StrongKeyWeakValueEntry(this.key, this.hash, r5);
            r0.valueReference = this.valueReference.copyFor(r4, r0);
            return r0;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> getValueReference() {
            return this.valueReference;
        }
    }

    static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<V> queueForValues;

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        StrongKeyWeakValueSegment<K, V> self() {
            return this;
        }

        static /* synthetic */ ReferenceQueue access$100(StrongKeyWeakValueSegment r0) {
            return r0.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ InternalEntry castForTesting(InternalEntry r1) {
            return castForTesting(r1);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* bridge */ /* synthetic */ Segment self() {
            return self();
        }

        StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> r1, int r2, int r3) {
            super(r1, r2, r3);
            this.queueForValues = new ReferenceQueue();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyWeakValueEntry<K, V> castForTesting(InternalEntry<K, V, ?> r1) {
            return (StrongKeyWeakValueEntry) r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> getWeakValueReferenceForTesting(InternalEntry<K, V, ?> r1) {
            return castForTesting(r1).getValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> newWeakValueReferenceForTesting(InternalEntry<K, V, ?> r3, V r4) {
            return new WeakValueReferenceImpl(this.queueForValues, r4, castForTesting(r3));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(InternalEntry<K, V, ?> r1, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> r2) {
            StrongKeyWeakValueEntry<K, V> r0 = castForTesting(r1);
            WeakValueReference r3 = StrongKeyWeakValueEntry.access$600(r0);
            StrongKeyWeakValueEntry.access$602(r0, r2);
            r3.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForValues);
        }
    }

    interface StrongValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {
    }

    final class ValueIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<V> {
        ValueIterator(MapMakerInternalMap r1) {
            super(r1);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.HashIterator, java.util.Iterator
        public V next() {
            return nextEntry().getValue();
        }
    }

    final class Values extends AbstractCollection<V> {
        final /* synthetic */ MapMakerInternalMap this$0;

        Values(MapMakerInternalMap r1) {
            this.this$0 = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ValueIterator(this.this$0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.this$0.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.this$0.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r1) {
            return this.this$0.containsValue(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return MapMakerInternalMap.access$900(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] r1) {
            return (T[]) MapMakerInternalMap.access$900(this).toArray(r1);
        }
    }

    static final class WeakKeyDummyValueEntry<K> extends AbstractWeakKeyEntry<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>> implements StrongValueEntry<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>> {

        static final class Helper<K> implements InternalEntryHelper<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> {
            private static final Helper<?> INSTANCE = null;

            public void setValue(WeakKeyDummyValueSegment<K> r1, WeakKeyDummyValueEntry<K> r2, MapMaker.Dummy r3) {
            }

            Helper() {
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry copy(Segment r1, InternalEntry r2, InternalEntry r3) {
                return copy((WeakKeyDummyValueSegment) r1, (WeakKeyDummyValueEntry) r2, (WeakKeyDummyValueEntry) r3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry newEntry(Segment r1, Object r2, int r3, InternalEntry r4) {
                return newEntry((WeakKeyDummyValueSegment) r1, r2, r3, (WeakKeyDummyValueEntry) r4);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ Segment newSegment(MapMakerInternalMap r1, int r2, int r3) {
                return newSegment(r1, r2, r3);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ void setValue(Segment r1, InternalEntry r2, MapMaker.Dummy r3) {
                setValue((WeakKeyDummyValueSegment) r1, (WeakKeyDummyValueEntry) r2, r3);
            }

            static {
                INSTANCE = new Helper();
            }

            static <K> Helper<K> instance() {
                return (Helper<K>) INSTANCE;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public WeakKeyDummyValueSegment<K> newSegment(MapMakerInternalMap<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> r1, int r2, int r3) {
                return new WeakKeyDummyValueSegment(r1, r2, r3);
            }

            public WeakKeyDummyValueEntry<K> copy(WeakKeyDummyValueSegment<K> r1, WeakKeyDummyValueEntry<K> r2, WeakKeyDummyValueEntry<K> r3) {
                if (r2.getKey() != null) goto L7;
                return null;
            L7:
                return r2.copy(WeakKeyDummyValueSegment.access$200(r1), r3);
            }

            public WeakKeyDummyValueEntry<K> newEntry(WeakKeyDummyValueSegment<K> r1, K r2, int r3, WeakKeyDummyValueEntry<K> r4) {
                return new WeakKeyDummyValueEntry(WeakKeyDummyValueSegment.access$200(r1), r2, r3, r4);
            }
        }

        void setValue(MapMaker.Dummy r1) {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public /* bridge */ /* synthetic */ Object getValue() {
            return getValue();
        }

        WeakKeyDummyValueEntry(ReferenceQueue<K> r1, K r2, int r3, WeakKeyDummyValueEntry<K> r4) {
            super(r1, r2, r3, r4);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }

        WeakKeyDummyValueEntry<K> copy(ReferenceQueue<K> r3, WeakKeyDummyValueEntry<K> r4) {
            return new WeakKeyDummyValueEntry(r3, getKey(), this.hash, r4);
        }
    }

    static final class WeakKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> {
        private final ReferenceQueue<K> queueForKeys;

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        WeakKeyDummyValueSegment<K> self() {
            return this;
        }

        static /* synthetic */ ReferenceQueue access$200(WeakKeyDummyValueSegment r0) {
            return r0.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ InternalEntry castForTesting(InternalEntry r1) {
            return castForTesting(r1);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* bridge */ /* synthetic */ Segment self() {
            return self();
        }

        WeakKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> r1, int r2, int r3) {
            super(r1, r2, r3);
            this.queueForKeys = new ReferenceQueue();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyDummyValueEntry<K> castForTesting(InternalEntry<K, MapMaker.Dummy, ?> r1) {
            return (WeakKeyDummyValueEntry) r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }
    }

    static final class WeakKeyStrongValueEntry<K, V> extends AbstractWeakKeyEntry<K, V, WeakKeyStrongValueEntry<K, V>> implements StrongValueEntry<K, V, WeakKeyStrongValueEntry<K, V>> {
        private volatile V value;

        static final class Helper<K, V> implements InternalEntryHelper<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> {
            private static final Helper<?, ?> INSTANCE = null;

            Helper() {
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry copy(Segment r1, InternalEntry r2, InternalEntry r3) {
                return copy((WeakKeyStrongValueSegment) r1, (WeakKeyStrongValueEntry) r2, (WeakKeyStrongValueEntry) r3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry newEntry(Segment r1, Object r2, int r3, InternalEntry r4) {
                return newEntry((WeakKeyStrongValueSegment) r1, r2, r3, (WeakKeyStrongValueEntry) r4);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ Segment newSegment(MapMakerInternalMap r1, int r2, int r3) {
                return newSegment(r1, r2, r3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ void setValue(Segment r1, InternalEntry r2, Object r3) {
                setValue((WeakKeyStrongValueSegment) r1, (WeakKeyStrongValueEntry) r2, r3);
            }

            static {
                INSTANCE = new Helper();
            }

            static <K, V> Helper<K, V> instance() {
                return (Helper<K, V>) INSTANCE;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public WeakKeyStrongValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> r1, int r2, int r3) {
                return new WeakKeyStrongValueSegment(r1, r2, r3);
            }

            public WeakKeyStrongValueEntry<K, V> copy(WeakKeyStrongValueSegment<K, V> r1, WeakKeyStrongValueEntry<K, V> r2, WeakKeyStrongValueEntry<K, V> r3) {
                if (r2.getKey() != null) goto L7;
                return null;
            L7:
                return r2.copy(WeakKeyStrongValueSegment.access$300(r1), r3);
            }

            public void setValue(WeakKeyStrongValueSegment<K, V> r1, WeakKeyStrongValueEntry<K, V> r2, V r3) {
                r2.setValue(r3);
            }

            public WeakKeyStrongValueEntry<K, V> newEntry(WeakKeyStrongValueSegment<K, V> r1, K r2, int r3, WeakKeyStrongValueEntry<K, V> r4) {
                return new WeakKeyStrongValueEntry(WeakKeyStrongValueSegment.access$300(r1), r2, r3, r4);
            }
        }

        WeakKeyStrongValueEntry(ReferenceQueue<K> r1, K r2, int r3, WeakKeyStrongValueEntry<K, V> r4) {
            super(r1, r2, r3, r4);
            this.value = null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public V getValue() {
            return this.value;
        }

        void setValue(V r1) {
            this.value = r1;
        }

        WeakKeyStrongValueEntry<K, V> copy(ReferenceQueue<K> r4, WeakKeyStrongValueEntry<K, V> r5) {
            WeakKeyStrongValueEntry<K, V> r0 = new WeakKeyStrongValueEntry(r4, getKey(), this.hash, r5);
            r0.setValue(this.value);
            return r0;
        }
    }

    static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        WeakKeyStrongValueSegment<K, V> self() {
            return this;
        }

        static /* synthetic */ ReferenceQueue access$300(WeakKeyStrongValueSegment r0) {
            return r0.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ InternalEntry castForTesting(InternalEntry r1) {
            return castForTesting(r1);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* bridge */ /* synthetic */ Segment self() {
            return self();
        }

        WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> r1, int r2, int r3) {
            super(r1, r2, r3);
            this.queueForKeys = new ReferenceQueue();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyStrongValueEntry<K, V> castForTesting(InternalEntry<K, V, ?> r1) {
            return (WeakKeyStrongValueEntry) r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }
    }

    static final class WeakKeyWeakValueEntry<K, V> extends AbstractWeakKeyEntry<K, V, WeakKeyWeakValueEntry<K, V>> implements WeakValueEntry<K, V, WeakKeyWeakValueEntry<K, V>> {
        private volatile WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> valueReference;

        static final class Helper<K, V> implements InternalEntryHelper<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> {
            private static final Helper<?, ?> INSTANCE = null;

            Helper() {
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry copy(Segment r1, InternalEntry r2, InternalEntry r3) {
                return copy((WeakKeyWeakValueSegment) r1, (WeakKeyWeakValueEntry) r2, (WeakKeyWeakValueEntry) r3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry newEntry(Segment r1, Object r2, int r3, InternalEntry r4) {
                return newEntry((WeakKeyWeakValueSegment) r1, r2, r3, (WeakKeyWeakValueEntry) r4);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ Segment newSegment(MapMakerInternalMap r1, int r2, int r3) {
                return newSegment(r1, r2, r3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ void setValue(Segment r1, InternalEntry r2, Object r3) {
                setValue((WeakKeyWeakValueSegment) r1, (WeakKeyWeakValueEntry) r2, r3);
            }

            static {
                INSTANCE = new Helper();
            }

            static <K, V> Helper<K, V> instance() {
                return (Helper<K, V>) INSTANCE;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public WeakKeyWeakValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> r1, int r2, int r3) {
                return new WeakKeyWeakValueSegment(r1, r2, r3);
            }

            public WeakKeyWeakValueEntry<K, V> copy(WeakKeyWeakValueSegment<K, V> r2, WeakKeyWeakValueEntry<K, V> r3, WeakKeyWeakValueEntry<K, V> r4) {
                if (r3.getKey() != null) goto L6;
                return null;
            L6:
                if (Segment.isCollected(r3) == false) goto L9;
                return null;
            L9:
                return r3.copy(WeakKeyWeakValueSegment.access$400(r2), WeakKeyWeakValueSegment.access$500(r2), r4);
            }

            public void setValue(WeakKeyWeakValueSegment<K, V> r1, WeakKeyWeakValueEntry<K, V> r2, V r3) {
                r2.setValue(r3, WeakKeyWeakValueSegment.access$500(r1));
            }

            public WeakKeyWeakValueEntry<K, V> newEntry(WeakKeyWeakValueSegment<K, V> r1, K r2, int r3, WeakKeyWeakValueEntry<K, V> r4) {
                return new WeakKeyWeakValueEntry(WeakKeyWeakValueSegment.access$400(r1), r2, r3, r4);
            }
        }

        static /* synthetic */ WeakValueReference access$700(WeakKeyWeakValueEntry r0) {
            return r0.valueReference;
        }

        static /* synthetic */ WeakValueReference access$702(WeakKeyWeakValueEntry r0, WeakValueReference r1) {
            r0.valueReference = r1;
            return r1;
        }

        WeakKeyWeakValueEntry(ReferenceQueue<K> r1, K r2, int r3, WeakKeyWeakValueEntry<K, V> r4) {
            super(r1, r2, r3, r4);
            this.valueReference = MapMakerInternalMap.unsetWeakValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public V getValue() {
            return this.valueReference.get();
        }

        WeakKeyWeakValueEntry<K, V> copy(ReferenceQueue<K> r4, ReferenceQueue<V> r5, WeakKeyWeakValueEntry<K, V> r6) {
            WeakKeyWeakValueEntry<K, V> r0 = new WeakKeyWeakValueEntry(r4, getKey(), this.hash, r6);
            r0.valueReference = this.valueReference.copyFor(r5, r0);
            return r0;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public void clearValue() {
            this.valueReference.clear();
        }

        void setValue(V r3, ReferenceQueue<V> r4) {
            WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> r0 = this.valueReference;
            this.valueReference = new WeakValueReferenceImpl(r4, r3, this);
            r0.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> getValueReference() {
            return this.valueReference;
        }
    }

    static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;
        private final ReferenceQueue<V> queueForValues;

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        WeakKeyWeakValueSegment<K, V> self() {
            return this;
        }

        static /* synthetic */ ReferenceQueue access$400(WeakKeyWeakValueSegment r0) {
            return r0.queueForKeys;
        }

        static /* synthetic */ ReferenceQueue access$500(WeakKeyWeakValueSegment r0) {
            return r0.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ InternalEntry castForTesting(InternalEntry r1) {
            return castForTesting(r1);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* bridge */ /* synthetic */ Segment self() {
            return self();
        }

        WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> r1, int r2, int r3) {
            super(r1, r2, r3);
            this.queueForKeys = new ReferenceQueue();
            this.queueForValues = new ReferenceQueue();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyWeakValueEntry<K, V> castForTesting(InternalEntry<K, V, ?> r1) {
            return (WeakKeyWeakValueEntry) r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> getWeakValueReferenceForTesting(InternalEntry<K, V, ?> r1) {
            return castForTesting(r1).getValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> newWeakValueReferenceForTesting(InternalEntry<K, V, ?> r3, V r4) {
            return new WeakValueReferenceImpl(this.queueForValues, r4, castForTesting(r3));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(InternalEntry<K, V, ?> r1, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> r2) {
            WeakKeyWeakValueEntry<K, V> r0 = castForTesting(r1);
            WeakValueReference r3 = WeakKeyWeakValueEntry.access$700(r0);
            WeakKeyWeakValueEntry.access$702(r0, r2);
            r3.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }
    }

    interface WeakValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {
        void clearValue();

        WeakValueReference<K, V, E> getValueReference();
    }

    interface WeakValueReference<K, V, E extends InternalEntry<K, V, E>> {
        void clear();

        WeakValueReference<K, V, E> copyFor(ReferenceQueue<V> r1, E r2);

        V get();

        E getEntry();
    }

    static final class WeakValueReferenceImpl<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<V> implements WeakValueReference<K, V, E> {
        final E entry;

        WeakValueReferenceImpl(ReferenceQueue<V> r1, V r2, E r3) {
            super(r2, r1);
            this.entry = r3;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public E getEntry() {
            return this.entry;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public WeakValueReference<K, V, E> copyFor(ReferenceQueue<V> r2, E r3) {
            return new WeakValueReferenceImpl(r2, get(), r3);
        }
    }

    final class WriteThroughEntry extends AbstractMapEntry<K, V> {
        final K key;
        final /* synthetic */ MapMakerInternalMap this$0;
        V value;

        WriteThroughEntry(MapMakerInternalMap r1, K r2, V r3) {
            this.this$0 = r1;
            this.key = r2;
            this.value = r3;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public boolean equals(Object r4) {
            if ((r4 instanceof Map.Entry) == false) goto L10;
            Map.Entry r5 = (Map.Entry) r4;
            if (this.key.equals(r5.getKey()) == true) goto L7;
            return false;
        L7:
            if (this.value.equals(r5.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public int hashCode() {
            int r0 = this.key.hashCode();
            return this.value.hashCode() ^ r0;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V setValue(V r3) {
            V r0 = (V) this.this$0.put(this.key, r3);
            this.value = r3;
            return r0;
        }
    }

    static int rehash(int r2) {
        int r3 = r2 + ((r2 << 15) ^ (-12931));
        int r4 = r3 ^ (r3 >>> 10);
        int r5 = r4 + (r4 << 3);
        int r6 = r5 ^ (r5 >>> 6);
        int r7 = r6 + ((r6 << 2) + (r6 << 14));
        return r7 ^ (r7 >>> 16);
    }

    static /* synthetic */ ArrayList access$900(Collection r0) {
        return toArrayList(r0);
    }

    private MapMakerInternalMap(MapMaker r5, InternalEntryHelper<K, V, E, S> r6) {
        this.concurrencyLevel = Math.min(r5.getConcurrencyLevel(), 65536);
        this.keyEquivalence = r5.getKeyEquivalence();
        this.entryHelper = r6;
        int r7 = Math.min(r5.getInitialCapacity(), 1073741824);
        int r8 = 0;
        int r0 = 1;
        int r2 = 0;
        int r1 = 1;
    L4:
        if (r1 >= this.concurrencyLevel) goto L6;
        r2 = r2 + 1;
        r1 = r1 << 1;
        goto L4
    L6:
        this.segmentShift = 32 - r2;
        this.segmentMask = r1 - 1;
        this.segments = newSegmentArray(r1);
        int r3 = r7 / r1;
        if ((r1 * r3) >= r7) goto L9;
        r3 = r3 + 1;
    L9:
        if (r0 >= r3) goto L11;
        r0 = r0 << 1;
    L11:
        Segment<K, V, E, S>[] r9 = this.segments;
        if (r8 >= r9.length) goto L14;
        r9[r8] = createSegment(r0, -1);
        r8 = r8 + 1;
        goto L11
    }

    static <K, V> MapMakerInternalMap<K, V, ? extends InternalEntry<K, V, ?>, ?> create(MapMaker r2) {
        if (r2.getKeyStrength() != Strength.STRONG) goto L9;
        if (r2.getValueStrength() != Strength.STRONG) goto L9;
        return new MapMakerInternalMap(r2, StrongKeyStrongValueEntry.Helper.instance());
    L9:
        if (r2.getKeyStrength() != Strength.STRONG) goto L15;
        if (r2.getValueStrength() != Strength.WEAK) goto L15;
        return new MapMakerInternalMap(r2, StrongKeyWeakValueEntry.Helper.instance());
    L15:
        if (r2.getKeyStrength() != Strength.WEAK) goto L21;
        if (r2.getValueStrength() != Strength.STRONG) goto L21;
        return new MapMakerInternalMap(r2, WeakKeyStrongValueEntry.Helper.instance());
    L21:
        if (r2.getKeyStrength() != Strength.WEAK) goto L27;
        if (r2.getValueStrength() != Strength.WEAK) goto L27;
        return new MapMakerInternalMap(r2, WeakKeyWeakValueEntry.Helper.instance());
    L27:
        throw new AssertionError();
    }

    static <K> MapMakerInternalMap<K, MapMaker.Dummy, ? extends InternalEntry<K, MapMaker.Dummy, ?>, ?> createWithDummyValues(MapMaker r2) {
        if (r2.getKeyStrength() != Strength.STRONG) goto L9;
        if (r2.getValueStrength() != Strength.STRONG) goto L9;
        return new MapMakerInternalMap(r2, StrongKeyDummyValueEntry.Helper.instance());
    L9:
        if (r2.getKeyStrength() != Strength.WEAK) goto L15;
        if (r2.getValueStrength() != Strength.STRONG) goto L15;
        return new MapMakerInternalMap(r2, WeakKeyDummyValueEntry.Helper.instance());
    L15:
        if (r2.getValueStrength() != Strength.WEAK) goto L19;
        throw new IllegalArgumentException("Map cannot have both weak and dummy values");
    L19:
        throw new AssertionError();
    }

    static <K, V, E extends InternalEntry<K, V, E>> WeakValueReference<K, V, E> unsetWeakValueReference() {
        return (WeakValueReference<K, V, E>) UNSET_WEAK_VALUE_REFERENCE;
    }

    static {
        UNSET_WEAK_VALUE_REFERENCE = new AnonymousClass1();
    }

    E copyEntry(E r2, E r3) {
        return (E) segmentFor(r2.getHash()).copyEntry(r2, r3);
    }

    int hash(Object r1) {
        return rehash(this.keyEquivalence.hash(r1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    void reclaimValue(WeakValueReference<K, V, E> r3) {
        InternalEntry r0 = r3.getEntry();
        int r1 = r0.getHash();
        segmentFor(r1).reclaimValue(r0.getKey(), r1, r3);
    }

    void reclaimKey(E r2) {
        int r0 = r2.getHash();
        segmentFor(r0).reclaimKey(r2, r0);
    }

    boolean isLiveForTesting(InternalEntry<K, V, ?> r2) {
        if (segmentFor(r2.getHash()).getLiveValueForTesting(r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    Segment<K, V, E, S> segmentFor(int r3) {
        Segment<K, V, E, S>[] r0 = this.segments;
        int r4 = r3 >>> this.segmentShift;
        return r0[this.segmentMask & r4];
    }

    Segment<K, V, E, S> createSegment(int r2, int r3) {
        return this.entryHelper.newSegment(this, r2, r3);
    }

    V getLiveValue(E r1) {
        if (r1.getKey() != null) goto L7;
        return null;
    L7:
        return (V) r1.getValue();
    }

    final Segment<K, V, E, S>[] newSegmentArray(int r1) {
        return new Segment[r1];
    }

    Strength keyStrength() {
        return this.entryHelper.keyStrength();
    }

    Strength valueStrength() {
        return this.entryHelper.valueStrength();
    }

    Equivalence<Object> valueEquivalence() {
        return this.entryHelper.valueStrength().defaultEquivalence();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V, E, S>[] r9 = this.segments;
        long r4 = 0;
        int r3 = 0;
    L4:
        if (r3 >= r9.length) goto L10;
        if (r9[r3].count != 0) goto L7;
        r4 = r4 + ((long) r9[r3].modCount);
        r3 = r3 + 1;
        goto L4
    L7:
        return false;
    L10:
        if (r4 == 0) goto L22;
        int r5 = 0;
    L13:
        if (r5 >= r9.length) goto L19;
        if (r9[r5].count != 0) goto L16;
        r4 = r4 - ((long) r9[r5].modCount);
        r5 = r5 + 1;
        goto L13
    L16:
        return false;
    L19:
        if (r4 == 0) goto L21;
        return false;
    L21:
        return true;
    L22:
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Segment<K, V, E, S>[] r5 = this.segments;
        long r0 = 0;
        int r2 = 0;
    L4:
        if (r2 >= r5.length) goto L7;
        r0 = r0 + ((long) r5[r2].count);
        r2 = r2 + 1;
        goto L4
    L7:
        return Ints.saturatedCast(r0);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        int r0 = hash(r2);
        return segmentFor(r0).get(r2, r0);
    }

    E getEntry(Object r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        int r0 = hash(r2);
        return (E) segmentFor(r0).getEntry(r2, r0);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        int r0 = hash(r2);
        return segmentFor(r0).containsKey(r2, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [int] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r13v3 */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object r17) {
        boolean r1 = false;
        if (r17 != null) goto L5;
        return false;
    L5:
        Segment<K, V, E, S>[] r3 = this.segments;
        long r4 = -1;
        int r6 = 0;
    L7:
        if (r6 >= 3) goto L29;
        int r7 = r3.length;
        long r8 = 0;
        ?? r10 = r1;
    L9:
        if (r10 >= r7) goto L25;
        Segment<K, V, E, S> r11 = r3[r10];
        int r12 = r11.count;
        AtomicReferenceArray<E> r13 = r11.table;
        ?? r14 = r1;
    L12:
        if (r14 >= r13.length()) goto L23;
        E r15 = r13.get(r14);
    L14:
        if (r15 == null) goto L22;
        V r16 = r11.getLiveValue(r15);
        if (r16 == null) goto L21;
        if (valueEquivalence().equivalent(r17, r16) == false) goto L21;
        return true;
    L21:
        r15 = r15.getNext();
        goto L14
    L22:
        r14 = r14 + 1;
        goto L12
    L23:
        r8 = r8 + ((long) r11.modCount);
        r1 = false;
        r10 = r10 + 1;
        goto L9
    L25:
        if (r8 == r4) goto L26;
        r6 = r6 + 1;
        r4 = r8;
        r1 = false;
        goto L7
    L26:
        return false;
    L29:
        return r1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K r3, V r4) {
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        int r0 = hash(r3);
        return segmentFor(r0).put(r3, r0, r4, false);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K r3, V r4) {
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        int r0 = hash(r3);
        return segmentFor(r0).put(r3, r0, r4, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r3) {
        Iterator<Map.Entry<? extends K, ? extends V>> r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends V> r0 = r4.next();
        put(r0.getKey(), r0.getValue());
        goto L4
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        int r0 = hash(r2);
        return segmentFor(r0).remove(r2, r0);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object r2, Object r3) {
        if (r2 == null) goto L7;
        if (r3 == null) goto L9;
        int r0 = hash(r2);
        return segmentFor(r0).remove(r2, r0, r3);
    L9:
        return false;
    L7:
        return false;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K r2, V r3, V r4) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r4);
        if (r3 != null) goto L6;
        return false;
    L6:
        int r0 = hash(r2);
        return segmentFor(r0).replace(r2, r0, r3, r4);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K r2, V r3) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        int r0 = hash(r2);
        return segmentFor(r0).replace(r2, r0, r3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Segment<K, V, E, S>[] r3 = this.segments;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].clear();
        r1 = r1 + 1;
        goto L3
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> r0 = this.keySet;
        if (r0 != null) goto L7;
        KeySet r1 = new KeySet(this);
        this.keySet = r1;
        return r1;
    L7:
        return r0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> r0 = this.values;
        if (r0 != null) goto L7;
        Values r1 = new Values(this);
        this.values = r1;
        return r1;
    L7:
        return r0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> r0 = this.entrySet;
        if (r0 != null) goto L7;
        EntrySet r1 = new EntrySet(this);
        this.entrySet = r1;
        return r1;
    L7:
        return r0;
    }

    private static <E> ArrayList<E> toArrayList(Collection<E> r2) {
        ArrayList<E> r0 = new ArrayList(r2.size());
        Iterators.addAll(r0, r2.iterator());
        return r0;
    }

    Object writeReplace() {
        return new SerializationProxy(this.entryHelper.keyStrength(), this.entryHelper.valueStrength(), this.keyEquivalence, this.entryHelper.valueStrength().defaultEquivalence(), this.concurrencyLevel, this);
    }
}
