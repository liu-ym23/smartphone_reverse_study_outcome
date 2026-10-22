package com.google.common.cache;

import adcpeJava.adcpe.Constants;
import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.util.concurrent.Uninterruptibles;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final Queue<?> DISCARDING_QUEUE = null;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final ValueReference<Object, Object> UNSET = null;
    static final Logger logger = null;
    final int concurrencyLevel;
    final CacheLoader<? super K, V> defaultLoader;
    final EntryFactory entryFactory;
    Set<Map.Entry<K, V>> entrySet;
    final long expireAfterAccessNanos;
    final long expireAfterWriteNanos;
    final AbstractCache.StatsCounter globalStatsCounter;
    final Equivalence<Object> keyEquivalence;
    Set<K> keySet;
    final Strength keyStrength;
    final long maxWeight;
    final long refreshNanos;
    final RemovalListener<K, V> removalListener;
    final Queue<RemovalNotification<K, V>> removalNotificationQueue;
    final int segmentMask;
    final int segmentShift;
    final Segment<K, V>[] segments;
    final Ticker ticker;
    final Equivalence<Object> valueEquivalence;
    final Strength valueStrength;
    Collection<V> values;
    final Weigher<K, V> weigher;

    abstract class AbstractCacheSet<T> extends AbstractSet<T> {
        final /* synthetic */ LocalCache this$0;

        AbstractCacheSet(LocalCache r1) {
            this.this$0 = r1;
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

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return LocalCache.access$200(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] r1) {
            return (E[]) LocalCache.access$200(this).toArray(r1);
        }
    }

    static abstract class AbstractReferenceEntry<K, V> implements ReferenceEntry<K, V> {
        AbstractReferenceEntry() {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<K, V> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setAccessTime(long r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setWriteTime(long r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> r1) {
            throw new UnsupportedOperationException();
        }
    }

    static final class AccessQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> head;

        AccessQueue() {
            this.head = new AnonymousClass1(this);
        }

        @Override // java.util.Queue
        public /* bridge */ /* synthetic */ boolean offer(Object r1) {
            return offer((ReferenceEntry) r1);
        }

        @Override // java.util.Queue
        public /* bridge */ /* synthetic */ Object peek() {
            return peek();
        }

        @Override // java.util.Queue
        public /* bridge */ /* synthetic */ Object poll() {
            return poll();
        }

        public boolean offer(ReferenceEntry<K, V> r3) {
            LocalCache.connectAccessOrder(r3.getPreviousInAccessQueue(), r3.getNextInAccessQueue());
            LocalCache.connectAccessOrder(this.head.getPreviousInAccessQueue(), r3);
            LocalCache.connectAccessOrder(r3, this.head);
            return true;
        }

        @Override // java.util.Queue
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> r0 = this.head.getNextInAccessQueue();
            if (r0 != this.head) goto L6;
            return null;
        L6:
            return r0;
        }

        @Override // java.util.Queue
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> r0 = this.head.getNextInAccessQueue();
            if (r0 != this.head) goto L6;
            return null;
        L6:
            remove(r0);
            return r0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object r2) {
            ReferenceEntry r3 = (ReferenceEntry) r2;
            ReferenceEntry<K, V> r1 = r3.getPreviousInAccessQueue();
            ReferenceEntry<K, V> r0 = r3.getNextInAccessQueue();
            LocalCache.connectAccessOrder(r1, r0);
            LocalCache.nullifyAccessOrder(r3);
            if (r0 == NullEntry.INSTANCE) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r1) {
            if (((ReferenceEntry) r1).getNextInAccessQueue() == NullEntry.INSTANCE) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.head.getNextInAccessQueue() != this.head) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            ReferenceEntry<K, V> r0 = this.head.getNextInAccessQueue();
            int r1 = 0;
        L4:
            if (r0 == this.head) goto L6;
            r1 = r1 + 1;
            r0 = r0.getNextInAccessQueue();
            goto L4
        L6:
            return r1;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ReferenceEntry<K, V> r0 = this.head.getNextInAccessQueue();
        L3:
            ReferenceEntry<K, V> r1 = this.head;
            if (r0 == r1) goto L6;
            ReferenceEntry<K, V> r2 = r0.getNextInAccessQueue();
            LocalCache.nullifyAccessOrder(r0);
            r0 = r2;
            goto L3
        L6:
            r1.setNextInAccessQueue(r1);
            ReferenceEntry<K, V> r3 = this.head;
            r3.setPreviousInAccessQueue(r3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<ReferenceEntry<K, V>> iterator() {
            final ReferenceEntry<K, V> r1 = peek();
            return new AnonymousClass2(this, r1);
        }
    }

    static class ComputingValueReference<K, V> extends LoadingValueReference<K, V> {
        @Override // com.google.common.cache.LocalCache.LoadingValueReference, com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        ComputingValueReference(ValueReference<K, V> r1) {
            super(r1);
        }
    }

    static abstract enum EntryFactory extends Enum<EntryFactory> {
        private static final /* synthetic */ EntryFactory[] $VALUES = null;
        static final int ACCESS_MASK = 1;
        public static final EntryFactory STRONG = null;
        public static final EntryFactory STRONG_ACCESS = null;
        public static final EntryFactory STRONG_ACCESS_WRITE = null;
        public static final EntryFactory STRONG_WRITE = null;
        public static final EntryFactory WEAK = null;
        public static final EntryFactory WEAK_ACCESS = null;
        public static final EntryFactory WEAK_ACCESS_WRITE = null;
        static final int WEAK_MASK = 4;
        public static final EntryFactory WEAK_WRITE = null;
        static final int WRITE_MASK = 2;
        static final EntryFactory[] factories = null;

        abstract <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> r1, K r2, int r3, ReferenceEntry<K, V> r4);

        private static /* synthetic */ EntryFactory[] $values() {
            return new EntryFactory[]{STRONG, STRONG_ACCESS, STRONG_WRITE, STRONG_ACCESS_WRITE, WEAK, WEAK_ACCESS, WEAK_WRITE, WEAK_ACCESS_WRITE};
        }

        private EntryFactory(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ EntryFactory(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static EntryFactory valueOf(String r1) {
            return (EntryFactory) Enum.valueOf(EntryFactory.class, r1);
        }

        public static EntryFactory[] values() {
            return (EntryFactory[]) $VALUES.clone();
        }

        static {
            final String r1 = "STRONG";
            final int r2 = 0;
            EntryFactory r0 = new AnonymousClass1(r1, r2);
            STRONG = r0;
            final String r3 = "STRONG_ACCESS";
            final int r4 = 1;
            EntryFactory r5 = new AnonymousClass2(r3, r4);
            STRONG_ACCESS = r5;
            final String r6 = "STRONG_WRITE";
            final int r7 = 2;
            EntryFactory r8 = new AnonymousClass3(r6, r7);
            STRONG_WRITE = r8;
            final String r9 = "STRONG_ACCESS_WRITE";
            final int r10 = 3;
            EntryFactory r11 = new AnonymousClass4(r9, r10);
            STRONG_ACCESS_WRITE = r11;
            final String r12 = "WEAK";
            final int r13 = 4;
            EntryFactory r14 = new AnonymousClass5(r12, r13);
            WEAK = r14;
            final String r15 = "WEAK_ACCESS";
            final int r16 = 5;
            EntryFactory r17 = new AnonymousClass6(r15, r16);
            WEAK_ACCESS = r17;
            final String r18 = "WEAK_WRITE";
            final int r19 = 6;
            EntryFactory r110 = new AnonymousClass7(r18, r19);
            WEAK_WRITE = r110;
            final String r111 = "WEAK_ACCESS_WRITE";
            final int r112 = 7;
            EntryFactory r113 = new AnonymousClass8(r111, r112);
            WEAK_ACCESS_WRITE = r113;
            $VALUES = $values();
            factories = new EntryFactory[]{r0, r5, r8, r11, r14, r17, r110, r113};
        }

        /* JADX WARN: Multi-variable type inference failed */
        static EntryFactory getFactory(Strength r2, boolean r3, boolean r4) {
            int r1 = 0;
            if (r2 != Strength.WEAK) goto L5;
            char r5 = 4;
        L6:
            boolean r6 = r5 | (r3 ? 1 : 0);
            if (r4 == false) goto L10;
            r1 = 2;
        L10:
            return factories[(r6 ? 1 : 0) | r1];
        L5:
            r5 = 0;
            goto L6
        }

        <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> r2, ReferenceEntry<K, V> r3, ReferenceEntry<K, V> r4) {
            return newEntry(r2, r3.getKey(), r3.getHash(), r4);
        }

        <K, V> void copyAccessEntry(ReferenceEntry<K, V> r3, ReferenceEntry<K, V> r4) {
            r4.setAccessTime(r3.getAccessTime());
            LocalCache.connectAccessOrder(r3.getPreviousInAccessQueue(), r4);
            LocalCache.connectAccessOrder(r4, r3.getNextInAccessQueue());
            LocalCache.nullifyAccessOrder(r3);
        }

        <K, V> void copyWriteEntry(ReferenceEntry<K, V> r3, ReferenceEntry<K, V> r4) {
            r4.setWriteTime(r3.getWriteTime());
            LocalCache.connectWriteOrder(r3.getPreviousInWriteQueue(), r4);
            LocalCache.connectWriteOrder(r4, r3.getNextInWriteQueue());
            LocalCache.nullifyWriteOrder(r3);
        }
    }

    final class EntryIterator extends LocalCache<K, V>.HashIterator<Map.Entry<K, V>> {
        EntryIterator(LocalCache r1) {
            super(r1);
        }

        @Override // com.google.common.cache.LocalCache.HashIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // com.google.common.cache.LocalCache.HashIterator, java.util.Iterator
        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    final class EntrySet extends LocalCache<K, V>.AbstractCacheSet<Map.Entry<K, V>> {
        final /* synthetic */ LocalCache this$0;

        EntrySet(LocalCache r1) {
            this.this$0 = r1;
            super(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(this.this$0);
        }

        @Override // java.util.Collection
        public boolean removeIf(final Predicate<? super Map.Entry<K, V>> r2) {
            Preconditions.checkNotNull(r2);
            return this.this$0.removeIf(new LocalCache$EntrySet$$ExternalSyntheticLambda0(r2));
        }

        static /* synthetic */ boolean lambda$removeIf$0(Predicate r0, Object r1, Object r2) {
            return r0.test(Maps.immutableEntry(r1, r2));
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
            if (this.this$0.valueEquivalence.equivalent(r5.getValue(), r1) == false) goto L15;
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
    }

    abstract class HashIterator<T> implements Iterator<T> {
        Segment<K, V> currentSegment;
        AtomicReferenceArray<ReferenceEntry<K, V>> currentTable;
        LocalCache<K, V>.WriteThroughEntry lastReturned;
        ReferenceEntry<K, V> nextEntry;
        LocalCache<K, V>.WriteThroughEntry nextExternal;
        int nextSegmentIndex;
        int nextTableIndex;
        final /* synthetic */ LocalCache this$0;

        @Override // java.util.Iterator
        public abstract T next();

        HashIterator(LocalCache r1) {
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
            Segment<K, V>[] r0 = this.this$0.segments;
            int r1 = this.nextSegmentIndex;
            this.nextSegmentIndex = r1 - 1;
            Segment<K, V> r2 = r0[r1];
            this.currentSegment = r2;
            if (r2.count == 0) goto L9;
            AtomicReferenceArray<ReferenceEntry<K, V>> r3 = this.currentSegment.table;
            this.currentTable = r3;
            this.nextTableIndex = r3.length() - 1;
            if (nextInTable() == false) goto L9;
            return;
        }

        boolean nextInChain() {
            ReferenceEntry<K, V> r0 = this.nextEntry;
            if (r0 == null) goto L11;
        L4:
            this.nextEntry = r0.getNext();
            ReferenceEntry<K, V> r1 = this.nextEntry;
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
            AtomicReferenceArray<ReferenceEntry<K, V>> r1 = this.currentTable;
            this.nextTableIndex = r0 - 1;
            ReferenceEntry<K, V> r2 = r1.get(r0);
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

        boolean advanceTo(ReferenceEntry<K, V> r5) {
            long r0 = this.this$0.ticker.read();     // Catch: Throwable -> L9
            K r2 = r5.getKey();     // Catch: Throwable -> L9
            Object r6 = this.this$0.getLiveValue(r5, r0);     // Catch: Throwable -> L9
            if (r6 == null) goto L7;
            this.nextExternal = new WriteThroughEntry(this.this$0, r2, r6);     // Catch: Throwable -> L9
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

        LocalCache<K, V>.WriteThroughEntry nextEntry() {
            LocalCache<K, V>.WriteThroughEntry r0 = this.nextExternal;
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
            Preconditions.checkState(r0);
            this.this$0.remove(this.lastReturned.getKey());
            this.lastReturned = null;
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    final class KeyIterator extends LocalCache<K, V>.HashIterator<K> {
        KeyIterator(LocalCache r1) {
            super(r1);
        }

        @Override // com.google.common.cache.LocalCache.HashIterator, java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }
    }

    final class KeySet extends LocalCache<K, V>.AbstractCacheSet<K> {
        final /* synthetic */ LocalCache this$0;

        KeySet(LocalCache r1) {
            this.this$0 = r1;
            super(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new KeyIterator(this.this$0);
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
    }

    static final class LoadingSerializationProxy<K, V> extends ManualSerializationProxy<K, V> implements LoadingCache<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        transient LoadingCache<K, V> autoDelegate;

        LoadingSerializationProxy(LocalCache<K, V> r1) {
            super(r1);
        }

        private void readObject(ObjectInputStream r2) throws IOException, ClassNotFoundException {
            r2.defaultReadObject();
            this.autoDelegate = (LoadingCache<K, V>) recreateCacheBuilder().build(this.loader);
        }

        @Override // com.google.common.cache.LoadingCache
        public V get(K r1) throws ExecutionException {
            return this.autoDelegate.get(r1);
        }

        @Override // com.google.common.cache.LoadingCache
        public V getUnchecked(K r1) {
            return this.autoDelegate.getUnchecked(r1);
        }

        @Override // com.google.common.cache.LoadingCache
        public ImmutableMap<K, V> getAll(Iterable<? extends K> r1) throws ExecutionException {
            return this.autoDelegate.getAll(r1);
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function, java.util.function.Function
        public final V apply(K r1) {
            return this.autoDelegate.apply(r1);
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(K r1) {
            this.autoDelegate.refresh(r1);
        }

        private Object readResolve() {
            return this.autoDelegate;
        }
    }

    static class LoadingValueReference<K, V> implements ValueReference<K, V> {
        final SettableFuture<V> futureValue;
        volatile ValueReference<K, V> oldValue;
        final Stopwatch stopwatch;

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> r1, V r2, ReferenceEntry<K, V> r3) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return true;
        }

        public LoadingValueReference() {
            this(null);
        }

        public LoadingValueReference(ValueReference<K, V> r2) {
            this.futureValue = SettableFuture.create();
            this.stopwatch = Stopwatch.createUnstarted();
            if (r2 != null) goto L5;
            r2 = LocalCache.unset();
        L5:
            this.oldValue = r2;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return this.oldValue.isActive();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.oldValue.getWeight();
        }

        public boolean set(V r1) {
            return this.futureValue.set(r1);
        }

        public boolean setException(Throwable r1) {
            return this.futureValue.setException(r1);
        }

        private ListenableFuture<V> fullyFailedFuture(Throwable r1) {
            return Futures.immediateFailedFuture(r1);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(V r1) {
            if (r1 == null) goto L4;
            set(r1);
            return;
        L4:
            this.oldValue = LocalCache.unset();
        }

        public ListenableFuture<V> loadFuture(K r2, CacheLoader<? super K, V> r3) {
            this.stopwatch.start();     // Catch: Throwable -> L15
            V r0 = this.oldValue.get();     // Catch: Throwable -> L15
            if (r0 != null) goto L9;
            V r4 = r3.load(r2);     // Catch: Throwable -> L15
            if (set(r4) == false) goto L8;
            return this.futureValue;
        L8:
            return Futures.immediateFuture(r4);
        L9:
            ListenableFuture<V> r5 = r3.reload(r2, r0);     // Catch: Throwable -> L15
            if (r5 != null) goto L14;
            return Futures.immediateFuture(null);
        L14:
            return Futures.transform(r5, new AnonymousClass1(this), MoreExecutors.directExecutor());
        L15:
            th = move-exception;
            if (setException(th) == false) goto L19;
            ListenableFuture<V> r1 = this.futureValue;
        L21:
            if ((th instanceof InterruptedException) == false) goto L23;
            Thread.currentThread().interrupt();
        L23:
            return r1;
        L19:
            r1 = fullyFailedFuture(th);
            goto L21
        }

        public V compute(K r2, BiFunction<? super K, ? super V, ? extends V> r3) {
            this.stopwatch.start();
            Constants r0 = this.oldValue.waitForValue();     // Catch: ExecutionException -> L5
        L12:
            V r4 = r3.apply(r2, r0);     // Catch: Throwable -> L9
            set(r4);
            return r4;
        L9:
            th = move-exception;
            setException(th);
            throw th;
        L5:
            r0 = null;
            goto L12
        }

        public long elapsedNanos() {
            return this.stopwatch.elapsed(TimeUnit.NANOSECONDS);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V waitForValue() throws ExecutionException {
            return (V) Uninterruptibles.getUninterruptibly(this.futureValue);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V get() {
            return this.oldValue.get();
        }

        public ValueReference<K, V> getOldValue() {
            return this.oldValue;
        }
    }

    static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements LoadingCache<K, V> {
        private static final long serialVersionUID = 1;

        LocalLoadingCache(CacheBuilder<? super K, ? super V> r2, CacheLoader<? super K, V> r3) {
            super(new LocalCache(r2, (CacheLoader) Preconditions.checkNotNull(r3)), null);
        }

        @Override // com.google.common.cache.LoadingCache
        public V get(K r1) throws ExecutionException {
            return this.localCache.getOrLoad(r1);
        }

        @Override // com.google.common.cache.LoadingCache
        public V getUnchecked(K r1) {
            return get(r1);
        L4:
            e = move-exception;
            throw new UncheckedExecutionException(e.getCause());
        }

        @Override // com.google.common.cache.LoadingCache
        public ImmutableMap<K, V> getAll(Iterable<? extends K> r1) throws ExecutionException {
            return this.localCache.getAll(r1);
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(K r1) {
            this.localCache.refresh(r1);
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function, java.util.function.Function
        public final V apply(K r1) {
            return getUnchecked(r1);
        }

        @Override // com.google.common.cache.LocalCache.LocalManualCache
        Object writeReplace() {
            return new LoadingSerializationProxy(this.localCache);
        }
    }

    static class LocalManualCache<K, V> implements Cache<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        final LocalCache<K, V> localCache;

        /* synthetic */ LocalManualCache(LocalCache r1, AnonymousClass1 r2) {
            this(r1);
        }

        LocalManualCache(CacheBuilder<? super K, ? super V> r3) {
            this(new LocalCache(r3, null));
        }

        private LocalManualCache(LocalCache<K, V> r1) {
            this.localCache = r1;
        }

        @Override // com.google.common.cache.Cache
        public V getIfPresent(Object r1) {
            return this.localCache.getIfPresent(r1);
        }

        @Override // com.google.common.cache.Cache
        public V get(K r3, final Callable<? extends V> r4) throws ExecutionException {
            Preconditions.checkNotNull(r4);
            return this.localCache.get(r3, new AnonymousClass1(this, r4));
        }

        @Override // com.google.common.cache.Cache
        public ImmutableMap<K, V> getAllPresent(Iterable<?> r1) {
            return this.localCache.getAllPresent(r1);
        }

        @Override // com.google.common.cache.Cache
        public void put(K r1, V r2) {
            this.localCache.put(r1, r2);
        }

        @Override // com.google.common.cache.Cache
        public void putAll(Map<? extends K, ? extends V> r1) {
            this.localCache.putAll(r1);
        }

        @Override // com.google.common.cache.Cache
        public void invalidate(Object r1) {
            Preconditions.checkNotNull(r1);
            this.localCache.remove(r1);
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll(Iterable<?> r1) {
            this.localCache.invalidateAll(r1);
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll() {
            this.localCache.clear();
        }

        @Override // com.google.common.cache.Cache
        public long size() {
            return this.localCache.longSize();
        }

        @Override // com.google.common.cache.Cache
        public ConcurrentMap<K, V> asMap() {
            return this.localCache;
        }

        @Override // com.google.common.cache.Cache
        public CacheStats stats() {
            AbstractCache.SimpleStatsCounter r0 = new AbstractCache.SimpleStatsCounter();
            r0.incrementBy(this.localCache.globalStatsCounter);
            Segment<K, V>[] r4 = this.localCache.segments;
            int r1 = r4.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L6;
            r0.incrementBy(r4[r2].statsCounter);
            r2 = r2 + 1;
            goto L3
        L6:
            return r0.snapshot();
        }

        @Override // com.google.common.cache.Cache
        public void cleanUp() {
            this.localCache.cleanUp();
        }

        Object writeReplace() {
            return new ManualSerializationProxy(this.localCache);
        }
    }

    static class ManualSerializationProxy<K, V> extends ForwardingCache<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        final int concurrencyLevel;
        transient Cache<K, V> delegate;
        final long expireAfterAccessNanos;
        final long expireAfterWriteNanos;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final CacheLoader<? super K, V> loader;
        final long maxWeight;
        final RemovalListener<? super K, ? super V> removalListener;
        final Ticker ticker;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;
        final Weigher<K, V> weigher;

        @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        ManualSerializationProxy(LocalCache<K, V> r17) {
            this(r17.keyStrength, r17.valueStrength, r17.keyEquivalence, r17.valueEquivalence, r17.expireAfterWriteNanos, r17.expireAfterAccessNanos, r17.maxWeight, r17.weigher, r17.concurrencyLevel, r17.removalListener, r17.ticker, r17.defaultLoader);
        }

        private ManualSerializationProxy(Strength r1, Strength r2, Equivalence<Object> r3, Equivalence<Object> r4, long r5, long r7, long r9, Weigher<K, V> r11, int r12, RemovalListener<? super K, ? super V> r13, Ticker r14, CacheLoader<? super K, V> r15) {
            this.keyStrength = r1;
            this.valueStrength = r2;
            this.keyEquivalence = r3;
            this.valueEquivalence = r4;
            this.expireAfterWriteNanos = r5;
            this.expireAfterAccessNanos = r7;
            this.maxWeight = r9;
            this.weigher = r11;
            this.concurrencyLevel = r12;
            this.removalListener = r13;
            if (r14 != Ticker.systemTicker()) goto L5;
        L6:
            r14 = null;
        L7:
            this.ticker = r14;
            this.loader = r15;
            return;
        L5:
            if (r14 != CacheBuilder.NULL_TICKER) goto L7;
            goto L6
        }

        CacheBuilder<K, V> recreateCacheBuilder() {
            CacheBuilder<K, V> r0 = (CacheBuilder<K, V>) CacheBuilder.newBuilder().setKeyStrength(this.keyStrength).setValueStrength(this.valueStrength).keyEquivalence(this.keyEquivalence).valueEquivalence(this.valueEquivalence).concurrencyLevel(this.concurrencyLevel).removalListener(this.removalListener);
            r0.strictParsing = false;
            long r1 = this.expireAfterWriteNanos;
            if (r1 <= 0) goto L5;
            r0.expireAfterWrite(r1, TimeUnit.NANOSECONDS);
        L5:
            long r2 = this.expireAfterAccessNanos;
            if (r2 <= 0) goto L9;
            r0.expireAfterAccess(r2, TimeUnit.NANOSECONDS);
        L9:
            if (this.weigher == CacheBuilder.OneWeigher.INSTANCE) goto L13;
            r0.weigher(this.weigher);
            long r3 = this.maxWeight;
            if (r3 == (-1)) goto L16;
            r0.maximumWeight(r3);
        L16:
            Ticker r6 = this.ticker;
            if (r6 == null) goto L19;
            r0.ticker(r6);
        L19:
            return r0;
        L13:
            long r4 = this.maxWeight;
            if (r4 == (-1)) goto L16;
            r0.maximumSize(r4);
            goto L16
        }

        private void readObject(ObjectInputStream r1) throws IOException, ClassNotFoundException {
            r1.defaultReadObject();
            this.delegate = (Cache<K, V>) recreateCacheBuilder().build();
        }

        private Object readResolve() {
            return this.delegate;
        }

        @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        protected Cache<K, V> delegate() {
            return this.delegate;
        }
    }

    private static final enum NullEntry extends Enum<NullEntry> implements ReferenceEntry<Object, Object> {
        private static final /* synthetic */ NullEntry[] $VALUES = null;
        public static final NullEntry INSTANCE = null;

        @Override // com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return 0;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            return 0;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public Object getKey() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNext() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNextInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNextInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getPreviousInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getPreviousInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference<Object, Object> getValueReference() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return 0;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setAccessTime(long r1) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<Object, Object> r1) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<Object, Object> r1) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<Object, Object> r1) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<Object, Object> r1) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<Object, Object> r1) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setWriteTime(long r1) {
        }

        private static /* synthetic */ NullEntry[] $values() {
            return new NullEntry[]{INSTANCE};
        }

        private NullEntry(String r1, int r2) {
            super(r1, r2);
        }

        public static NullEntry valueOf(String r1) {
            return (NullEntry) Enum.valueOf(NullEntry.class, r1);
        }

        public static NullEntry[] values() {
            return (NullEntry[]) $VALUES.clone();
        }

        static {
            INSTANCE = new NullEntry("INSTANCE", 0);
            $VALUES = $values();
        }
    }

    static class Segment<K, V> extends ReentrantLock {
        final Queue<ReferenceEntry<K, V>> accessQueue;
        volatile int count;
        final ReferenceQueue<K> keyReferenceQueue;
        final LocalCache<K, V> map;
        final long maxSegmentWeight;
        int modCount;
        final AtomicInteger readCount;
        final Queue<ReferenceEntry<K, V>> recencyQueue;
        final AbstractCache.StatsCounter statsCounter;
        volatile AtomicReferenceArray<ReferenceEntry<K, V>> table;
        int threshold;
        long totalWeight;
        final ReferenceQueue<V> valueReferenceQueue;
        final Queue<ReferenceEntry<K, V>> writeQueue;

        Segment(LocalCache<K, V> r2, int r3, long r4, AbstractCache.StatsCounter r6) {
            this.readCount = new AtomicInteger();
            this.map = r2;
            this.maxSegmentWeight = r4;
            this.statsCounter = (AbstractCache.StatsCounter) Preconditions.checkNotNull(r6);
            initTable(newEntryArray(r3));
            ReferenceQueue<V> r5 = null;
            if (r2.usesKeyReferences() == false) goto L5;
            ReferenceQueue<K> r7 = new ReferenceQueue();
        L6:
            this.keyReferenceQueue = r7;
            if (r2.usesValueReferences() == false) goto L9;
            r5 = new ReferenceQueue();
        L9:
            this.valueReferenceQueue = r5;
            if (r2.usesAccessQueue() == false) goto L12;
            Queue<ReferenceEntry<K, V>> r8 = new ConcurrentLinkedQueue();
        L13:
            this.recencyQueue = r8;
            if (r2.usesWriteQueue() == false) goto L16;
            Queue<ReferenceEntry<K, V>> r9 = new WriteQueue();
        L17:
            this.writeQueue = r9;
            if (r2.usesAccessQueue() == false) goto L20;
            Queue<ReferenceEntry<K, V>> r10 = new AccessQueue();
        L21:
            this.accessQueue = r10;
            return;
        L20:
            r10 = LocalCache.discardingQueue();
            goto L21
        L16:
            r9 = LocalCache.discardingQueue();
            goto L17
        L12:
            r8 = LocalCache.discardingQueue();
            goto L13
        L5:
            r7 = null;
            goto L6
        }

        AtomicReferenceArray<ReferenceEntry<K, V>> newEntryArray(int r1) {
            return new AtomicReferenceArray(r1);
        }

        void initTable(AtomicReferenceArray<ReferenceEntry<K, V>> r6) {
            this.threshold = (r6.length() * 3) / 4;
            if (this.map.customWeigher() == true) goto L7;
            int r0 = this.threshold;
            if (r0 != this.maxSegmentWeight) goto L7;
            this.threshold = r0 + 1;
        L7:
            this.table = r6;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        ReferenceEntry<K, V> newEntry(K r2, int r3, ReferenceEntry<K, V> r4) {
            return this.map.entryFactory.newEntry(this, Preconditions.checkNotNull(r2), r3, r4);
        }

        ReferenceEntry<K, V> copyEntry(ReferenceEntry<K, V> r5, ReferenceEntry<K, V> r6) {
            if (r5.getKey() != null) goto L5;
            return null;
        L5:
            ValueReference<K, V> r0 = r5.getValueReference();
            V r2 = r0.get();
            if (r2 == null) goto L8;
        L10:
            ReferenceEntry<K, V> r7 = this.map.entryFactory.copyEntry(this, r5, r6);
            r7.setValueReference(r0.copyFor(this.valueReferenceQueue, r2, r7));
            return r7;
        L8:
            if (r0.isActive() == false) goto L10;
            return null;
        }

        void setValue(ReferenceEntry<K, V> r4, K r5, V r6, long r7) {
            ValueReference<K, V> r0 = r4.getValueReference();
            int r8 = this.map.weigher.weigh(r5, r6);
            if (r8 < 0) goto L5;
            boolean r1 = true;
        L6:
            Preconditions.checkState(r1, "Weights must be non-negative");
            r4.setValueReference(this.map.valueStrength.referenceValue(this, r4, r6, r8));
            recordWrite(r4, r8, r7);
            r0.notifyNewValue(r6);
            return;
        L5:
            r1 = false;
            goto L6
        }

        V get(K r10, int r11, CacheLoader<? super K, V> r12) throws ExecutionException {
            Preconditions.checkNotNull(r10);
            Preconditions.checkNotNull(r12);
        L22:
            e = move-exception;
            Throwable r13 = e.getCause();     // Catch: Throwable -> L20
            if ((r13 instanceof Error) == true) goto L31;
            if ((r13 instanceof RuntimeException) == true) goto L28;
            throw e;     // Catch: Throwable -> L20
        L28:
            throw new UncheckedExecutionException(r13);     // Catch: Throwable -> L20
        L31:
            throw new ExecutionError((Error) r13);     // Catch: Throwable -> L20
        L4:
            if (this.count == 0) goto L17;
            ReferenceEntry<K, V> r2 = getEntry(r10, r11);     // Catch: Throwable -> L20 ExecutionException -> L22
            if (r2 == null) goto L17;
            long r6 = this.map.ticker.read();     // Catch: Throwable -> L20 ExecutionException -> L22
            V r5 = getLiveValue(r2, r6);     // Catch: Throwable -> L20 ExecutionException -> L22
            if (r5 == null) goto L12;
            recordRead(r2, r6);     // Catch: Throwable -> L20 ExecutionException -> L22
            this.statsCounter.recordHits(1);     // Catch: Throwable -> L20 ExecutionException -> L22
            V r14 = scheduleRefresh(r2, r10, r11, r5, r6, r12);     // Catch: Throwable -> L20 ExecutionException -> L22
            postReadCleanup();
            return r14;
        L12:
            ValueReference<K, V> r0 = r2.getValueReference();     // Catch: Throwable -> L20 ExecutionException -> L22
            if (r0.isLoading() == false) goto L17;
            V r15 = waitForLoadingValue(r2, r10, r0);     // Catch: Throwable -> L20 ExecutionException -> L22
            postReadCleanup();
            return r15;
        L17:
            V r16 = lockedGetOrLoad(r10, r11, r12);     // Catch: Throwable -> L20 ExecutionException -> L22
            postReadCleanup();
            return r16;
        L20:
            th = move-exception;
            postReadCleanup();
            throw th;
        }

        V get(Object r11, int r12) {
        L16:
            th = move-exception;
            postReadCleanup();
            throw th;
        L3:
            if (this.count == 0) goto L14;
            long r7 = this.map.ticker.read();     // Catch: Throwable -> L16
            ReferenceEntry<K, V> r3 = getLiveEntry(r11, r12, r7);     // Catch: Throwable -> L16
            if (r3 != null) goto L8;
            postReadCleanup();
            return null;
        L8:
            V r6 = r3.getValueReference().get();     // Catch: Throwable -> L16
            if (r6 == null) goto L13;
            recordRead(r3, r7);     // Catch: Throwable -> L16
            V r13 = scheduleRefresh(r3, r3.getKey(), r12, r6, r7, this.map.defaultLoader);     // Catch: Throwable -> L16
            postReadCleanup();
            return r13;
        L13:
            tryDrainReferenceQueues();     // Catch: Throwable -> L16
        L14:
            postReadCleanup();
            return null;
        }

        V lockedGetOrLoad(K r18, int r19, CacheLoader<? super K, V> r20) throws ExecutionException {
            lock();
            long r1 = this.map.ticker.read();     // Catch: Throwable -> L48
            preWriteCleanup(r1);     // Catch: Throwable -> L48
            int r10 = this.count - 1;     // Catch: Throwable -> L48
            AtomicReferenceArray<ReferenceEntry<K, V>> r11 = this.table;     // Catch: Throwable -> L48
            int r12 = r19 & (r11.length() - 1);     // Catch: Throwable -> L48
            ReferenceEntry<K, V> r13 = r11.get(r12);     // Catch: Throwable -> L48
            ReferenceEntry<K, V> r14 = r13;
        L4:
            LoadingValueReference<K, V> r15 = null;
            if (r14 == null) goto L26;
            K r3 = r14.getKey();     // Catch: Throwable -> L48
            if (r14.getHash() != r19) goto L25;
            if (r3 == null) goto L25;
            if (this.map.keyEquivalence.equivalent(r18, r3) == false) goto L25;
            ValueReference<K, V> r16 = r14.getValueReference();     // Catch: Throwable -> L48
            if (r16.isLoading() == false) goto L15;
            boolean r2 = false;
        L14:
            ValueReference<K, V> r4 = r16;
        L27:
            if (r2 == false) goto L32;
            r15 = new LoadingValueReference();     // Catch: Throwable -> L48
            if (r14 != null) goto L31;
            r14 = newEntry(r18, r19, r13);     // Catch: Throwable -> L48
            r14.setValueReference(r15);     // Catch: Throwable -> L48
            r11.set(r12, r14);     // Catch: Throwable -> L48
            goto L32
        L31:
            r14.setValueReference(r15);     // Catch: Throwable -> L48
        L32:
            unlock();
            postWriteCleanup();
            if (r2 == false) goto L47;
            monitor-enter(r14);     // Catch: Throwable -> L43
            V r0 = loadSync(r18, r19, r15, r20);     // Catch: Throwable -> L40
            monitor-exit(r14);     // Catch: Throwable -> L40
            this.statsCounter.recordMisses(1);
            return r0;
        L40:
            th = move-exception;
            throw th;     // Catch: Throwable -> L43
        L43:
            th = move-exception;
            this.statsCounter.recordMisses(1);
            throw th;
        L47:
            return waitForLoadingValue(r14, r18, r4);
        L15:
            V r5 = r16.get();     // Catch: Throwable -> L48
            if (r5 != null) goto L19;
            enqueueNotification(r3, r19, r5, r16.getWeight(), RemovalCause.COLLECTED);     // Catch: Throwable -> L48
        L21:
            this.writeQueue.remove(r14);     // Catch: Throwable -> L48
            this.accessQueue.remove(r14);     // Catch: Throwable -> L48
            this.count = r10;     // Catch: Throwable -> L48
            r2 = true;
            goto L14
        L19:
            if (this.map.isExpired(r14, r1) == false) goto L22;
            enqueueNotification(r3, r19, r5, r16.getWeight(), RemovalCause.EXPIRED);     // Catch: Throwable -> L48
            goto L21
        L22:
            recordLockedRead(r14, r1);     // Catch: Throwable -> L48
            this.statsCounter.recordHits(1);     // Catch: Throwable -> L48
            unlock();
            postWriteCleanup();
            return r5;
        L25:
            r14 = r14.getNext();     // Catch: Throwable -> L48
            goto L4
        L26:
            r2 = true;
            r4 = null;
        L48:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        V waitForLoadingValue(ReferenceEntry<K, V> r5, K r6, ValueReference<K, V> r7) throws ExecutionException {
            if (r7.isLoading() == false) goto L16;
            Preconditions.checkState(!Thread.holdsLock(r5), "Recursive load of: %s", r6);
            V r8 = r7.waitForValue();     // Catch: Throwable -> L12
            if (r8 == null) goto L10;
            recordRead(r5, this.map.ticker.read());     // Catch: Throwable -> L12
            this.statsCounter.recordMisses(1);
            return r8;
        L10:
            String r9 = String.valueOf(r6);     // Catch: Throwable -> L12
            throw new CacheLoader.InvalidCacheLoadException(new StringBuilder(String.valueOf(r9).length() + 35).append("CacheLoader returned null for key ").append(r9).append(".").toString());     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            this.statsCounter.recordMisses(1);
            throw th;
        L16:
            throw new AssertionError();
        }

        V compute(K r21, int r22, BiFunction<? super K, ? super V, ? extends V> r23) {
            lock();
            long r9 = this.map.ticker.read();     // Catch: Throwable -> L44
            preWriteCleanup(r9);     // Catch: Throwable -> L44
            AtomicReferenceArray<ReferenceEntry<K, V>> r11 = this.table;     // Catch: Throwable -> L44
            int r13 = r22 & (r11.length() - 1);     // Catch: Throwable -> L44
            ReferenceEntry<K, V> r14 = r11.get(r13);     // Catch: Throwable -> L44
            ReferenceEntry<K, V> r15 = r14;
        L4:
            char r6 = 0;
            if (r15 == null) goto L17;
            K r2 = r15.getKey();     // Catch: Throwable -> L44
            if (r15.getHash() != r22) goto L16;
            if (r2 == null) goto L16;
            if (this.map.keyEquivalence.equivalent(r21, r2) == false) goto L16;
            ValueReference<K, V> r17 = r15.getValueReference();     // Catch: Throwable -> L44
            if (this.map.isExpired(r15, r9) == false) goto L15;
            enqueueNotification(r2, r22, r17.get(), r17.getWeight(), RemovalCause.EXPIRED);     // Catch: Throwable -> L44
        L15:
            this.writeQueue.remove(r15);     // Catch: Throwable -> L44
            this.accessQueue.remove(r15);     // Catch: Throwable -> L44
            char r7 = r6;
            ValueReference<K, V> r1 = r17;
        L18:
            ComputingValueReference r3 = new ComputingValueReference(r1);     // Catch: Throwable -> L44
            if (r15 != null) goto L21;
            r15 = newEntry(r21, r22, r14);     // Catch: Throwable -> L44
            r15.setValueReference(r3);     // Catch: Throwable -> L44
            r11.set(r13, r15);     // Catch: Throwable -> L44
            char r19 = 1;
        L22:
            V r4 = r3.compute(r21, r23);     // Catch: Throwable -> L44
            if (r4 == null) goto L35;
            if (r1 != null) goto L26;
        L47:
            V r0 = getAndRecordStats(r21, r22, r3, Futures.immediateFuture(r4));     // Catch: ExecutionException -> L33 Throwable -> L44
            unlock();
            postWriteCleanup();
            return r0;
        L34:
            throw new AssertionError("impossible; Futures.immediateFuture can't throw");     // Catch: Throwable -> L44
        L26:
            if (r4 != r1.get()) goto L47;
            r3.set(r4);     // Catch: Throwable -> L44
            r15.setValueReference(r1);     // Catch: Throwable -> L44
            recordWrite(r15, r6, r9);     // Catch: Throwable -> L44
            unlock();
            postWriteCleanup();
            return r4;
        L35:
            if (r19 == 0) goto L37;
        L42:
            removeLoadingValue(r21, r22, r3);     // Catch: Throwable -> L44
        L40:
            unlock();
            postWriteCleanup();
            return null;
        L37:
            if (r1.isLoading() == true) goto L42;
            removeEntry(r15, r22, RemovalCause.EXPLICIT);     // Catch: Throwable -> L44
            goto L40
        L21:
            r15.setValueReference(r3);     // Catch: Throwable -> L44
            r19 = r7;
        L16:
            r15 = r15.getNext();     // Catch: Throwable -> L44
            goto L4
        L17:
            r6 = 0;
            r1 = null;
            r7 = 1;
        L44:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        V loadSync(K r1, int r2, LoadingValueReference<K, V> r3, CacheLoader<? super K, V> r4) throws ExecutionException {
            return getAndRecordStats(r1, r2, r3, r3.loadFuture(r1, r4));
        }

        ListenableFuture<V> loadAsync(final K r8, final int r9, final LoadingValueReference<K, V> r10, CacheLoader<? super K, V> r11) {
            final ListenableFuture<V> r12 = r10.loadFuture(r8, r11);
            r12.addListener(new AnonymousClass1(this, r8, r9, r10, r12), MoreExecutors.directExecutor());
            return r12;
        }

        V getAndRecordStats(K r5, int r6, LoadingValueReference<K, V> r7, ListenableFuture<V> r8) throws ExecutionException {
            V r9 = (V) Uninterruptibles.getUninterruptibly(r8);
            if (r9 == null) goto L10;
            this.statsCounter.recordLoadSuccess(r7.elapsedNanos());     // Catch: Throwable -> L8
            storeLoadedValue(r5, r6, r7, r9);     // Catch: Throwable -> L8
            if (r9 != null) goto L7;
            this.statsCounter.recordLoadException(r7.elapsedNanos());
            removeLoadingValue(r5, r6, r7);
        L7:
            return r9;
        L10:
            String r1 = String.valueOf(r5);     // Catch: Throwable -> L8
            throw new CacheLoader.InvalidCacheLoadException(new StringBuilder(String.valueOf(r1).length() + 35).append("CacheLoader returned null for key ").append(r1).append(".").toString());     // Catch: Throwable -> L8
        L8:
            th = th;
        L14:
            if (r9 != null) goto L16;
            this.statsCounter.recordLoadException(r7.elapsedNanos());
            removeLoadingValue(r5, r6, r7);
        L16:
            throw th;
        L12:
            th = th;
            r9 = null;
            goto L14
        }

        V scheduleRefresh(ReferenceEntry<K, V> r3, K r4, int r5, V r6, long r7, CacheLoader<? super K, V> r9) {
            if (this.map.refreshes() == true) goto L5;
        L11:
            return r6;
        L5:
            if ((r7 - r3.getWriteTime()) <= this.map.refreshNanos) goto L11;
            if (r3.getValueReference().isLoading() == true) goto L11;
            V r2 = refresh(r4, r5, r9, true);
            if (r2 == null) goto L11;
            return r2;
        }

        V refresh(K r2, int r3, CacheLoader<? super K, V> r4, boolean r5) {
            LoadingValueReference<K, V> r6 = insertLoadingValueReference(r2, r3, r5);
            if (r6 != null) goto L5;
            return null;
        L5:
            ListenableFuture<V> r1 = loadAsync(r2, r3, r6, r4);
            if (r1.isDone() == true) goto L11;
        L9:
            return null;
        L11:
            return (V) Uninterruptibles.getUninterruptibly(r1);
        }

        LoadingValueReference<K, V> insertLoadingValueReference(K r9, int r10, boolean r11) {
            lock();
            long r0 = this.map.ticker.read();     // Catch: Throwable -> L25
            preWriteCleanup(r0);     // Catch: Throwable -> L25
            AtomicReferenceArray<ReferenceEntry<K, V>> r2 = this.table;     // Catch: Throwable -> L25
            int r3 = (r2.length() - 1) & r10;     // Catch: Throwable -> L25
            ReferenceEntry<K, V> r4 = (ReferenceEntry) r2.get(r3);     // Catch: Throwable -> L25
            ReferenceEntry r5 = r4;
        L4:
            if (r5 == null) goto L22;
            Object r6 = r5.getKey();     // Catch: Throwable -> L25
            if (r5.getHash() != r10) goto L21;
            if (r6 == null) goto L21;
            if (this.map.keyEquivalence.equivalent(r9, r6) == false) goto L21;
            ValueReference<K, V> r12 = r5.getValueReference();     // Catch: Throwable -> L25
            if (r12.isLoading() == true) goto L19;
            if (r11 == true) goto L14;
        L16:
            this.modCount++;     // Catch: Throwable -> L25
            LoadingValueReference<K, V> r13 = new LoadingValueReference(r12);     // Catch: Throwable -> L25
            r5.setValueReference(r13);     // Catch: Throwable -> L25
            unlock();
            postWriteCleanup();
            return r13;
        L14:
            if ((r0 - r5.getWriteTime()) >= this.map.refreshNanos) goto L16;
        L19:
            unlock();
            postWriteCleanup();
            return null;
        L21:
            r5 = r5.getNext();     // Catch: Throwable -> L25
            goto L4
        L22:
            this.modCount++;     // Catch: Throwable -> L25
            LoadingValueReference<K, V> r14 = new LoadingValueReference();     // Catch: Throwable -> L25
            ReferenceEntry<K, V> r15 = newEntry(r9, r10, r4);     // Catch: Throwable -> L25
            r15.setValueReference(r14);     // Catch: Throwable -> L25
            r2.set(r3, r15);     // Catch: Throwable -> L25
            unlock();
            postWriteCleanup();
            return r14;
        L25:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        void tryDrainReferenceQueues() {
            if (tryLock() == true) goto L10;
            return;
        L10:
            drainReferenceQueues();     // Catch: Throwable -> L6
            unlock();
            return;
        L6:
            th = move-exception;
            unlock();
            throw th;
        }

        void drainReferenceQueues() {
            if (this.map.usesKeyReferences() == false) goto L6;
            drainKeyReferenceQueue();
        L6:
            if (this.map.usesValueReferences() == false) goto L9;
            drainValueReferenceQueue();
            return;
        }

        void drainKeyReferenceQueue() {
            int r0 = 0;
        L3:
            Reference<? extends K> r1 = this.keyReferenceQueue.poll();
            if (r1 == null) goto L7;
            LocalCache<K, V> r2 = this.map;
            r2.reclaimKey((ReferenceEntry) r1);
            r0 = r0 + 1;
            if (r0 != 16) goto L3;
            return;
        }

        void drainValueReferenceQueue() {
            int r0 = 0;
        L3:
            Reference<? extends V> r1 = this.valueReferenceQueue.poll();
            if (r1 == null) goto L7;
            LocalCache<K, V> r2 = this.map;
            r2.reclaimValue((ValueReference) r1);
            r0 = r0 + 1;
            if (r0 != 16) goto L3;
            return;
        }

        void clearReferenceQueues() {
            if (this.map.usesKeyReferences() == false) goto L6;
            clearKeyReferenceQueue();
        L6:
            if (this.map.usesValueReferences() == false) goto L9;
            clearValueReferenceQueue();
            return;
        }

        void clearKeyReferenceQueue() {
        L3:
            if (this.keyReferenceQueue.poll() != null) goto L3;
        }

        void clearValueReferenceQueue() {
        L3:
            if (this.valueReferenceQueue.poll() != null) goto L3;
        }

        void recordRead(ReferenceEntry<K, V> r2, long r3) {
            if (this.map.recordsAccess() == false) goto L5;
            r2.setAccessTime(r3);
        L5:
            this.recencyQueue.add(r2);
        }

        void recordLockedRead(ReferenceEntry<K, V> r2, long r3) {
            if (this.map.recordsAccess() == false) goto L5;
            r2.setAccessTime(r3);
        L5:
            this.accessQueue.add(r2);
        }

        void recordWrite(ReferenceEntry<K, V> r5, int r6, long r7) {
            drainRecencyQueue();
            this.totalWeight += (long) r6;
            if (this.map.recordsAccess() == false) goto L6;
            r5.setAccessTime(r7);
        L6:
            if (this.map.recordsWrite() == false) goto L8;
            r5.setWriteTime(r7);
        L8:
            this.accessQueue.add(r5);
            this.writeQueue.add(r5);
        }

        void drainRecencyQueue() {
        L2:
            ReferenceEntry<K, V> r0 = this.recencyQueue.poll();
            if (r0 == null) goto L7;
            if (this.accessQueue.contains(r0) == false) goto L2;
            this.accessQueue.add(r0);
            goto L2
        }

        void tryExpireEntries(long r2) {
            if (tryLock() == true) goto L10;
            return;
        L10:
            expireEntries(r2);     // Catch: Throwable -> L6
            unlock();
            return;
        L6:
            th = move-exception;
            unlock();
            throw th;
        }

        void expireEntries(long r4) {
            drainRecencyQueue();
        L3:
            ReferenceEntry<K, V> r0 = this.writeQueue.peek();
            if (r0 == null) goto L12;
            if (this.map.isExpired(r0, r4) == false) goto L12;
            if (removeEntry(r0, r0.getHash(), RemovalCause.EXPIRED) == true) goto L3;
            throw new AssertionError();
        L12:
            ReferenceEntry<K, V> r1 = this.accessQueue.peek();
            if (r1 == null) goto L21;
            if (this.map.isExpired(r1, r4) == false) goto L31;
            if (removeEntry(r1, r1.getHash(), RemovalCause.EXPIRED) == true) goto L12;
            throw new AssertionError();
        L31:
            return;
        }

        void enqueueNotification(K r5, int r6, V r7, int r8, RemovalCause r9) {
            this.totalWeight -= (long) r8;
            if (r9.wasEvicted() == false) goto L6;
            this.statsCounter.recordEviction();
        L6:
            if (this.map.removalNotificationQueue == LocalCache.DISCARDING_QUEUE) goto L9;
            this.map.removalNotificationQueue.offer(RemovalNotification.create(r5, r7, r9));
            return;
        }

        void evictEntries(ReferenceEntry<K, V> r5) {
            if (this.map.evictsBySize() == true) goto L5;
            return;
        L5:
            drainRecencyQueue();
            if (r5.getValueReference().getWeight() <= this.maxSegmentWeight) goto L13;
            if (removeEntry(r5, r5.getHash(), RemovalCause.SIZE) == true) goto L13;
            throw new AssertionError();
        L13:
            if (this.totalWeight <= this.maxSegmentWeight) goto L19;
            ReferenceEntry<K, V> r6 = getNextEvictable();
            if (removeEntry(r6, r6.getHash(), RemovalCause.SIZE) == true) goto L13;
            throw new AssertionError();
        }

        ReferenceEntry<K, V> getNextEvictable() {
            Iterator<ReferenceEntry<K, V>> r2 = this.accessQueue.iterator();
        L4:
            if (r2.hasNext() == false) goto L9;
            ReferenceEntry<K, V> r0 = r2.next();
            if (r0.getValueReference().getWeight() <= 0) goto L4;
            return r0;
        L9:
            throw new AssertionError();
        }

        ReferenceEntry<K, V> getFirst(int r2) {
            AtomicReferenceArray<ReferenceEntry<K, V>> r1 = this.table;
            return r1.get(r2 & (r1.length() - 1));
        }

        ReferenceEntry<K, V> getEntry(Object r4, int r5) {
            ReferenceEntry<K, V> r0 = getFirst(r5);
        L3:
            if (r0 == null) goto L14;
            if (r0.getHash() != r5) goto L13;
            K r1 = r0.getKey();
            if (r1 != null) goto L11;
            tryDrainReferenceQueues();
            goto L13
        L11:
            if (this.map.keyEquivalence.equivalent(r4, r1) == false) goto L13;
            return r0;
        L13:
            r0 = r0.getNext();
            goto L3
        L14:
            return null;
        }

        ReferenceEntry<K, V> getLiveEntry(Object r2, int r3, long r4) {
            ReferenceEntry<K, V> r5 = getEntry(r2, r3);
            if (r5 != null) goto L6;
            return null;
        L6:
            if (this.map.isExpired(r5, r4) == false) goto L9;
            tryExpireEntries(r4);
            return null;
        L9:
            return r5;
        }

        V getLiveValue(ReferenceEntry<K, V> r4, long r5) {
            if (r4.getKey() != null) goto L6;
            tryDrainReferenceQueues();
            return null;
        L6:
            V r0 = r4.getValueReference().get();
            if (r0 != null) goto L11;
            tryDrainReferenceQueues();
            return null;
        L11:
            if (this.map.isExpired(r4, r5) == false) goto L14;
            tryExpireEntries(r5);
            return null;
        L14:
            return r0;
        }

        boolean containsKey(Object r5, int r6) {
            boolean r1 = false;
            if (this.count == 0) goto L13;
            ReferenceEntry<K, V> r7 = getLiveEntry(r5, r6, this.map.ticker.read());     // Catch: Throwable -> L15
            if (r7 != null) goto L8;
            postReadCleanup();
            return false;
        L8:
            if (r7.getValueReference().get() == null) goto L11;
            r1 = true;
        L11:
            postReadCleanup();
            return r1;
        L13:
            postReadCleanup();
            return false;
        L15:
            th = move-exception;
            postReadCleanup();
            throw th;
        }

        boolean containsValue(Object r10) {
        L20:
            th = move-exception;
            postReadCleanup();
            throw th;
        L3:
            if (this.count == 0) goto L18;
            long r2 = this.map.ticker.read();     // Catch: Throwable -> L20
            AtomicReferenceArray<ReferenceEntry<K, V>> r0 = this.table;     // Catch: Throwable -> L20
            int r4 = r0.length();     // Catch: Throwable -> L20
            int r5 = 0;
        L5:
            if (r5 >= r4) goto L18;
            ReferenceEntry<K, V> r6 = r0.get(r5);     // Catch: Throwable -> L20
        L7:
            if (r6 == null) goto L17;
            V r7 = getLiveValue(r6, r2);     // Catch: Throwable -> L20
            if (r7 != null) goto L12;
        L15:
            r6 = r6.getNext();     // Catch: Throwable -> L20
            goto L7
        L12:
            if (this.map.valueEquivalence.equivalent(r10, r7) == false) goto L15;
            postReadCleanup();
            return true;
        L17:
            r5 = r5 + 1;
        L18:
            postReadCleanup();
            return false;
        }

        V put(K r15, int r16, V r17, boolean r18) {
            lock();
            long r8 = this.map.ticker.read();     // Catch: Throwable -> L31
            preWriteCleanup(r8);     // Catch: Throwable -> L31
            if ((this.count + 1) <= this.threshold) goto L6;
            expand();     // Catch: Throwable -> L31
        L6:
            AtomicReferenceArray<ReferenceEntry<K, V>> r10 = this.table;     // Catch: Throwable -> L31
            int r11 = r16 & (r10.length() - 1);     // Catch: Throwable -> L31
            ReferenceEntry<K, V> r1 = r10.get(r11);     // Catch: Throwable -> L31
            ReferenceEntry<K, V> r12 = r1;
        L8:
            if (r12 == null) goto L29;
            K r2 = r12.getKey();     // Catch: Throwable -> L31
            if (r12.getHash() != r16) goto L28;
            if (r2 == null) goto L28;
            if (this.map.keyEquivalence.equivalent(r15, r2) == false) goto L28;
            ValueReference<K, V> r3 = r12.getValueReference();     // Catch: Throwable -> L31
            V r13 = r3.get();     // Catch: Throwable -> L31
            if (r13 != null) goto L23;
            this.modCount++;     // Catch: Throwable -> L31
            if (r3.isActive() == false) goto L19;
            enqueueNotification(r15, r16, r13, r3.getWeight(), RemovalCause.COLLECTED);     // Catch: Throwable -> L31
            setValue(r12, r15, r17, r8);     // Catch: Throwable -> L31
            int r0 = this.count;     // Catch: Throwable -> L31
        L20:
            this.count = r0;     // Catch: Throwable -> L31
            evictEntries(r12);     // Catch: Throwable -> L31
        L21:
            unlock();
            postWriteCleanup();
            return null;
        L19:
            setValue(r12, r15, r17, r8);     // Catch: Throwable -> L31
            r0 = this.count + 1;     // Catch: Throwable -> L31
            goto L20
        L23:
            if (r18 == false) goto L27;
            recordLockedRead(r12, r8);     // Catch: Throwable -> L31
        L25:
            unlock();
            postWriteCleanup();
            return r13;
        L27:
            this.modCount++;     // Catch: Throwable -> L31
            enqueueNotification(r15, r16, r13, r3.getWeight(), RemovalCause.REPLACED);     // Catch: Throwable -> L31
            setValue(r12, r15, r17, r8);     // Catch: Throwable -> L31
            evictEntries(r12);     // Catch: Throwable -> L31
        L28:
            r12 = r12.getNext();     // Catch: Throwable -> L31
            goto L8
        L29:
            this.modCount++;     // Catch: Throwable -> L31
            ReferenceEntry<K, V> r14 = newEntry(r15, r16, r1);     // Catch: Throwable -> L31
            setValue(r14, r15, r17, r8);     // Catch: Throwable -> L31
            r10.set(r11, r14);     // Catch: Throwable -> L31
            this.count++;     // Catch: Throwable -> L31
            evictEntries(r14);     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        void expand() {
            AtomicReferenceArray<ReferenceEntry<K, V>> r0 = this.table;
            int r1 = r0.length();
            if (r1 < 1073741824) goto L5;
            return;
        L5:
            int r2 = this.count;
            AtomicReferenceArray<ReferenceEntry<K, V>> r3 = newEntryArray(r1 << 1);
            this.threshold = (r3.length() * 3) / 4;
            int r4 = r3.length() - 1;
            int r5 = 0;
        L6:
            if (r5 >= r1) goto L26;
            ReferenceEntry<K, V> r6 = r0.get(r5);
            if (r6 == null) goto L25;
            ReferenceEntry<K, V> r7 = r6.getNext();
            int r8 = r6.getHash() & r4;
            if (r7 != null) goto L12;
            r3.set(r8, r6);
            goto L25
        L12:
            ReferenceEntry<K, V> r9 = r6;
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
            ReferenceEntry<K, V> r12 = copyEntry(r6, r3.get(r11));
            if (r12 == null) goto L23;
            r3.set(r11, r12);
        L24:
            r6 = r6.getNext();
            goto L19
        L23:
            removeCollectedEntry(r6);
            r2 = r2 - 1;
        L25:
            r5 = r5 + 1;
            goto L6
        L26:
            this.table = r3;
            this.count = r2;
        }

        boolean replace(K r18, int r19, V r20, V r21) {
            lock();
            long r7 = this.map.ticker.read();     // Catch: Throwable -> L27
            preWriteCleanup(r7);     // Catch: Throwable -> L27
            AtomicReferenceArray<ReferenceEntry<K, V>> r10 = this.table;     // Catch: Throwable -> L27
            int r12 = r19 & (r10.length() - 1);     // Catch: Throwable -> L27
            ReferenceEntry<K, V> r2 = r10.get(r12);     // Catch: Throwable -> L27
            ReferenceEntry<K, V> r13 = r2;
        L5:
            if (r13 == null) goto L16;
            K r4 = r13.getKey();     // Catch: Throwable -> L27
            if (r13.getHash() != r19) goto L25;
            if (r4 == null) goto L25;
            if (this.map.keyEquivalence.equivalent(r18, r4) == false) goto L25;
            ValueReference<K, V> r16 = r13.getValueReference();     // Catch: Throwable -> L27
            V r6 = r16.get();     // Catch: Throwable -> L27
            if (r6 != null) goto L19;
            if (r16.isActive() == false) goto L16;
            this.modCount++;     // Catch: Throwable -> L27
            ReferenceEntry<K, V> r0 = removeValueFromChain(r2, r13, r4, r19, r6, r16, RemovalCause.COLLECTED);     // Catch: Throwable -> L27
            int r1 = this.count - 1;     // Catch: Throwable -> L27
            r10.set(r12, r0);     // Catch: Throwable -> L27
            this.count = r1;     // Catch: Throwable -> L27
            goto L16
        L19:
            if (this.map.valueEquivalence.equivalent(r20, r6) == false) goto L23;
            this.modCount++;     // Catch: Throwable -> L27
            enqueueNotification(r18, r19, r6, r16.getWeight(), RemovalCause.REPLACED);     // Catch: Throwable -> L27
            setValue(r13, r18, r21, r7);     // Catch: Throwable -> L27
            evictEntries(r13);     // Catch: Throwable -> L27
            unlock();
            postWriteCleanup();
            return true;
        L23:
            recordLockedRead(r13, r7);     // Catch: Throwable -> L27
        L25:
            r13 = r13.getNext();     // Catch: Throwable -> L27
        L16:
            unlock();
            postWriteCleanup();
            return false;
        L27:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        V replace(K r18, int r19, V r20) {
            lock();
            long r7 = this.map.ticker.read();     // Catch: Throwable -> L24
            preWriteCleanup(r7);     // Catch: Throwable -> L24
            AtomicReferenceArray<ReferenceEntry<K, V>> r10 = this.table;     // Catch: Throwable -> L24
            int r11 = r19 & (r10.length() - 1);     // Catch: Throwable -> L24
            ReferenceEntry<K, V> r2 = r10.get(r11);     // Catch: Throwable -> L24
            ReferenceEntry<K, V> r12 = r2;
        L5:
            if (r12 == null) goto L16;
            K r4 = r12.getKey();     // Catch: Throwable -> L24
            if (r12.getHash() != r19) goto L22;
            if (r4 == null) goto L22;
            if (this.map.keyEquivalence.equivalent(r18, r4) == false) goto L22;
            ValueReference<K, V> r15 = r12.getValueReference();     // Catch: Throwable -> L24
            V r16 = r15.get();     // Catch: Throwable -> L24
            if (r16 == null) goto L14;
            this.modCount++;     // Catch: Throwable -> L24
            enqueueNotification(r18, r19, r16, r15.getWeight(), RemovalCause.REPLACED);     // Catch: Throwable -> L24
            setValue(r12, r18, r20, r7);     // Catch: Throwable -> L24
            evictEntries(r12);     // Catch: Throwable -> L24
            unlock();
            postWriteCleanup();
            return r16;
        L14:
            if (r15.isActive() == false) goto L16;
            this.modCount++;     // Catch: Throwable -> L24
            ReferenceEntry<K, V> r0 = removeValueFromChain(r2, r12, r4, r19, r16, r15, RemovalCause.COLLECTED);     // Catch: Throwable -> L24
            int r1 = this.count - 1;     // Catch: Throwable -> L24
            r10.set(r11, r0);     // Catch: Throwable -> L24
            this.count = r1;     // Catch: Throwable -> L24
        L22:
            r12 = r12.getNext();     // Catch: Throwable -> L24
        L16:
            unlock();
            postWriteCleanup();
            return null;
        L24:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        V remove(Object r12, int r13) {
            lock();
            preWriteCleanup(this.map.ticker.read());     // Catch: Throwable -> L25
            AtomicReferenceArray<ReferenceEntry<K, V>> r0 = this.table;     // Catch: Throwable -> L25
            int r1 = (r0.length() - 1) & r13;     // Catch: Throwable -> L25
            ReferenceEntry<K, V> r4 = r0.get(r1);     // Catch: Throwable -> L25
            ReferenceEntry<K, V> r5 = r4;
        L5:
            if (r5 == null) goto L21;
            K r6 = r5.getKey();     // Catch: Throwable -> L25
            if (r5.getHash() != r13) goto L23;
            if (r6 == null) goto L23;
            if (this.map.keyEquivalence.equivalent(r12, r6) == false) goto L23;
            ValueReference<K, V> r9 = r5.getValueReference();     // Catch: Throwable -> L25
            V r14 = r9.get();     // Catch: Throwable -> L25
            if (r14 == null) goto L16;
            RemovalCause r2 = RemovalCause.EXPLICIT;     // Catch: Throwable -> L25
        L14:
            RemovalCause r10 = r2;
            this.modCount++;     // Catch: Throwable -> L25
            ReferenceEntry<K, V> r15 = removeValueFromChain(r4, r5, r6, r13, r14, r9, r10);     // Catch: Throwable -> L25
            int r3 = this.count - 1;     // Catch: Throwable -> L25
            r0.set(r1, r15);     // Catch: Throwable -> L25
            this.count = r3;     // Catch: Throwable -> L25
            unlock();
            postWriteCleanup();
            return r14;
        L16:
            if (r9.isActive() == false) goto L21;
            r2 = RemovalCause.COLLECTED;     // Catch: Throwable -> L25
        L23:
            r5 = r5.getNext();     // Catch: Throwable -> L25
        L21:
            unlock();
            postWriteCleanup();
            return null;
        L25:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        boolean remove(Object r13, int r14, Object r15) {
            lock();
            preWriteCleanup(this.map.ticker.read());     // Catch: Throwable -> L28
            AtomicReferenceArray<ReferenceEntry<K, V>> r0 = this.table;     // Catch: Throwable -> L28
            boolean r2 = true;
            int r1 = (r0.length() - 1) & r14;     // Catch: Throwable -> L28
            ReferenceEntry<K, V> r5 = r0.get(r1);     // Catch: Throwable -> L28
            ReferenceEntry<K, V> r6 = r5;
        L5:
            if (r6 == null) goto L24;
            K r7 = r6.getKey();     // Catch: Throwable -> L28
            if (r6.getHash() != r14) goto L26;
            if (r7 == null) goto L26;
            if (this.map.keyEquivalence.equivalent(r13, r7) == false) goto L26;
            ValueReference<K, V> r10 = r6.getValueReference();     // Catch: Throwable -> L28
            V r9 = r10.get();     // Catch: Throwable -> L28
            if (this.map.valueEquivalence.equivalent(r15, r9) == false) goto L14;
            RemovalCause r16 = RemovalCause.EXPLICIT;     // Catch: Throwable -> L28
        L18:
            this.modCount++;     // Catch: Throwable -> L28
            ReferenceEntry<K, V> r17 = removeValueFromChain(r5, r6, r7, r14, r9, r10, r16);     // Catch: Throwable -> L28
            int r18 = this.count - 1;     // Catch: Throwable -> L28
            r0.set(r1, r17);     // Catch: Throwable -> L28
            this.count = r18;     // Catch: Throwable -> L28
            if (r16 == RemovalCause.EXPLICIT) goto L22;
            r2 = false;
        L22:
            unlock();
            postWriteCleanup();
            return r2;
        L14:
            if (r9 != null) goto L24;
            if (r10.isActive() == false) goto L24;
            r16 = RemovalCause.COLLECTED;     // Catch: Throwable -> L28
        L26:
            r6 = r6.getNext();     // Catch: Throwable -> L28
        L24:
            unlock();
            postWriteCleanup();
            return false;
        L28:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        boolean storeLoadedValue(K r16, int r17, LoadingValueReference<K, V> r18, V r19) {
            lock();
            long r8 = this.map.ticker.read();     // Catch: Throwable -> L35
            preWriteCleanup(r8);     // Catch: Throwable -> L35
            int r1 = this.count + 1;     // Catch: Throwable -> L35
            if (r1 <= this.threshold) goto L6;
            expand();     // Catch: Throwable -> L35
            r1 = this.count + 1;     // Catch: Throwable -> L35
        L6:
            int r11 = r1;
            AtomicReferenceArray<ReferenceEntry<K, V>> r12 = this.table;     // Catch: Throwable -> L35
            int r13 = r17 & (r12.length() - 1);     // Catch: Throwable -> L35
            ReferenceEntry<K, V> r2 = r12.get(r13);     // Catch: Throwable -> L35
            ReferenceEntry<K, V> r14 = r2;
        L7:
            if (r14 == null) goto L33;
            K r3 = r14.getKey();     // Catch: Throwable -> L35
            if (r14.getHash() != r17) goto L32;
            if (r3 == null) goto L32;
            if (this.map.keyEquivalence.equivalent(r16, r3) == false) goto L32;
            ValueReference<K, V> r4 = r14.getValueReference();     // Catch: Throwable -> L35
            V r5 = r4.get();     // Catch: Throwable -> L35
            if (r18 == r4) goto L22;
            if (r5 == null) goto L17;
        L19:
            enqueueNotification(r16, r17, r19, 0, RemovalCause.REPLACED);     // Catch: Throwable -> L35
            unlock();
            postWriteCleanup();
            return false;
        L17:
            if (r4 == LocalCache.UNSET) goto L19;
        L22:
            this.modCount++;     // Catch: Throwable -> L35
            if (r18.isActive() == false) goto L28;
            if (r5 != null) goto L26;
            RemovalCause r6 = RemovalCause.COLLECTED;     // Catch: Throwable -> L35
        L27:
            enqueueNotification(r16, r17, r5, r18.getWeight(), r6);     // Catch: Throwable -> L35
            r11 = r11 - 1;     // Catch: Throwable -> L35
            goto L28
        L26:
            r6 = RemovalCause.REPLACED;     // Catch: Throwable -> L35
        L28:
            setValue(r14, r16, r19, r8);     // Catch: Throwable -> L35
            this.count = r11;     // Catch: Throwable -> L35
            evictEntries(r14);     // Catch: Throwable -> L35
        L29:
            unlock();
            postWriteCleanup();
            return true;
        L32:
            r14 = r14.getNext();     // Catch: Throwable -> L35
            goto L7
        L33:
            this.modCount++;     // Catch: Throwable -> L35
            ReferenceEntry<K, V> r15 = newEntry(r16, r17, r2);     // Catch: Throwable -> L35
            setValue(r15, r16, r19, r8);     // Catch: Throwable -> L35
            r12.set(r13, r15);     // Catch: Throwable -> L35
            this.count = r11;     // Catch: Throwable -> L35
            evictEntries(r15);     // Catch: Throwable -> L35
        L35:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        void clear() {
            if (this.count == 0) goto L30;
            lock();
            preWriteCleanup(this.map.ticker.read());     // Catch: Throwable -> L27
            AtomicReferenceArray<ReferenceEntry<K, V>> r0 = this.table;     // Catch: Throwable -> L27
            int r2 = 0;
        L7:
            if (r2 >= r0.length()) goto L21;
            ReferenceEntry<K, V> r3 = r0.get(r2);     // Catch: Throwable -> L27
        L9:
            if (r3 == null) goto L20;
            if (r3.getValueReference().isActive() == false) goto L19;
            K r6 = r3.getKey();     // Catch: Throwable -> L27
            V r8 = r3.getValueReference().get();     // Catch: Throwable -> L27
            if (r6 == null) goto L17;
            if (r8 == null) goto L17;
            RemovalCause r4 = RemovalCause.EXPLICIT;     // Catch: Throwable -> L27
        L18:
            enqueueNotification(r6, r3.getHash(), r8, r3.getValueReference().getWeight(), r4);     // Catch: Throwable -> L27
        L17:
            r4 = RemovalCause.COLLECTED;     // Catch: Throwable -> L27
        L19:
            r3 = r3.getNext();     // Catch: Throwable -> L27
            goto L9
        L20:
            r2 = r2 + 1;     // Catch: Throwable -> L27
            goto L7
        L21:
            int r5 = 0;
        L23:
            if (r5 >= r0.length()) goto L25;
            r0.set(r5, null);     // Catch: Throwable -> L27
            r5 = r5 + 1;     // Catch: Throwable -> L27
            goto L23
        L25:
            clearReferenceQueues();     // Catch: Throwable -> L27
            this.writeQueue.clear();     // Catch: Throwable -> L27
            this.accessQueue.clear();     // Catch: Throwable -> L27
            this.readCount.set(0);     // Catch: Throwable -> L27
            this.modCount++;     // Catch: Throwable -> L27
            this.count = 0;     // Catch: Throwable -> L27
            unlock();
            postWriteCleanup();
            return;
        L27:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        ReferenceEntry<K, V> removeValueFromChain(ReferenceEntry<K, V> r7, ReferenceEntry<K, V> r8, K r9, int r10, V r11, ValueReference<K, V> r12, RemovalCause r13) {
            enqueueNotification(r9, r10, r11, r12.getWeight(), r13);
            this.writeQueue.remove(r8);
            this.accessQueue.remove(r8);
            if (r12.isLoading() == false) goto L7;
            r12.notifyNewValue(null);
            return r7;
        L7:
            return removeEntryFromChain(r7, r8);
        }

        ReferenceEntry<K, V> removeEntryFromChain(ReferenceEntry<K, V> r4, ReferenceEntry<K, V> r5) {
            int r0 = this.count;
            ReferenceEntry<K, V> r1 = r5.getNext();
        L3:
            if (r4 == r5) goto L9;
            ReferenceEntry<K, V> r2 = copyEntry(r4, r1);
            if (r2 == null) goto L7;
            r1 = r2;
        L8:
            r4 = r4.getNext();
            goto L3
        L7:
            removeCollectedEntry(r4);
            r0 = r0 - 1;
            goto L8
        L9:
            this.count = r0;
            return r1;
        }

        void removeCollectedEntry(ReferenceEntry<K, V> r7) {
            enqueueNotification(r7.getKey(), r7.getHash(), r7.getValueReference().get(), r7.getValueReference().getWeight(), RemovalCause.COLLECTED);
            this.writeQueue.remove(r7);
            this.accessQueue.remove(r7);
        }

        boolean reclaimKey(ReferenceEntry<K, V> r13, int r14) {
            lock();
            AtomicReferenceArray<ReferenceEntry<K, V>> r0 = this.table;     // Catch: Throwable -> L13
            int r1 = (r0.length() - 1) & r14;     // Catch: Throwable -> L13
            ReferenceEntry<K, V> r5 = r0.get(r1);     // Catch: Throwable -> L13
            ReferenceEntry<K, V> r6 = r5;
        L4:
            if (r6 == null) goto L11;
            if (r6 == r13) goto L6;
            r6 = r6.getNext();     // Catch: Throwable -> L13
            goto L4
        L6:
            this.modCount++;     // Catch: Throwable -> L13
            ReferenceEntry<K, V> r15 = removeValueFromChain(r5, r6, r6.getKey(), r14, r6.getValueReference().get(), r6.getValueReference(), RemovalCause.COLLECTED);     // Catch: Throwable -> L13
            int r16 = this.count - 1;     // Catch: Throwable -> L13
            r0.set(r1, r15);     // Catch: Throwable -> L13
            this.count = r16;     // Catch: Throwable -> L13
            unlock();
            postWriteCleanup();
            return true;
        L11:
            unlock();
            postWriteCleanup();
            return false;
        L13:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        boolean reclaimValue(K r13, int r14, ValueReference<K, V> r15) {
            lock();
            AtomicReferenceArray<ReferenceEntry<K, V>> r0 = this.table;     // Catch: Throwable -> L28
            int r1 = (r0.length() - 1) & r14;     // Catch: Throwable -> L28
            ReferenceEntry<K, V> r5 = r0.get(r1);     // Catch: Throwable -> L28
            ReferenceEntry<K, V> r6 = r5;
        L5:
            if (r6 == null) goto L24;
            K r7 = r6.getKey();     // Catch: Throwable -> L28
            if (r6.getHash() != r14) goto L22;
            if (r7 == null) goto L22;
            if (this.map.keyEquivalence.equivalent(r13, r7) == false) goto L22;
            if (r6.getValueReference() != r15) goto L18;
            this.modCount++;     // Catch: Throwable -> L28
            ReferenceEntry<K, V> r16 = removeValueFromChain(r5, r6, r7, r14, r15.get(), r15, RemovalCause.COLLECTED);     // Catch: Throwable -> L28
            int r17 = this.count - 1;     // Catch: Throwable -> L28
            r0.set(r1, r16);     // Catch: Throwable -> L28
            this.count = r17;     // Catch: Throwable -> L28
            unlock();
            if (isHeldByCurrentThread() == true) goto L17;
            postWriteCleanup();
        L17:
            return true;
        L18:
            unlock();
            if (isHeldByCurrentThread() == true) goto L21;
            postWriteCleanup();
        L21:
            return false;
        L22:
            r6 = r6.getNext();     // Catch: Throwable -> L28
            goto L5
        L24:
            unlock();
            if (isHeldByCurrentThread() == true) goto L27;
            postWriteCleanup();
        L27:
            return false;
        L28:
            th = move-exception;
            unlock();
            if (isHeldByCurrentThread() == true) goto L32;
            postWriteCleanup();
        L32:
            throw th;
        }

        boolean removeLoadingValue(K r9, int r10, LoadingValueReference<K, V> r11) {
            lock();
            AtomicReferenceArray<ReferenceEntry<K, V>> r0 = this.table;     // Catch: Throwable -> L23
            int r1 = (r0.length() - 1) & r10;     // Catch: Throwable -> L23
            ReferenceEntry<K, V> r3 = r0.get(r1);     // Catch: Throwable -> L23
            ReferenceEntry<K, V> r4 = r3;
        L5:
            if (r4 == null) goto L19;
            K r6 = r4.getKey();     // Catch: Throwable -> L23
            if (r4.getHash() != r10) goto L21;
            if (r6 == null) goto L21;
            if (this.map.keyEquivalence.equivalent(r9, r6) == false) goto L21;
            if (r4.getValueReference() != r11) goto L19;
            if (r11.isActive() == false) goto L16;
            r4.setValueReference(r11.getOldValue());     // Catch: Throwable -> L23
        L17:
            unlock();
            postWriteCleanup();
            return true;
        L16:
            r0.set(r1, removeEntryFromChain(r3, r4));     // Catch: Throwable -> L23
        L21:
            r4 = r4.getNext();     // Catch: Throwable -> L23
        L19:
            unlock();
            postWriteCleanup();
            return false;
        L23:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        boolean removeEntry(ReferenceEntry<K, V> r13, int r14, RemovalCause r15) {
            AtomicReferenceArray<ReferenceEntry<K, V>> r0 = this.table;
            int r1 = (r0.length() - 1) & r14;
            ReferenceEntry<K, V> r5 = r0.get(r1);
            ReferenceEntry<K, V> r6 = r5;
        L3:
            if (r6 == null) goto L8;
            if (r6 == r13) goto L5;
            r6 = r6.getNext();
            goto L3
        L5:
            this.modCount++;
            ReferenceEntry<K, V> r16 = removeValueFromChain(r5, r6, r6.getKey(), r14, r6.getValueReference().get(), r6.getValueReference(), r15);
            int r17 = this.count - 1;
            r0.set(r1, r16);
            this.count = r17;
            return true;
        L8:
            return false;
        }

        void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) != 0) goto L6;
            cleanUp();
            return;
        }

        void preWriteCleanup(long r1) {
            runLockedCleanup(r1);
        }

        void postWriteCleanup() {
            runUnlockedCleanup();
        }

        void cleanUp() {
            runLockedCleanup(this.map.ticker.read());
            runUnlockedCleanup();
        }

        void runLockedCleanup(long r2) {
            if (tryLock() == true) goto L10;
            return;
        L10:
            drainReferenceQueues();     // Catch: Throwable -> L6
            expireEntries(r2);     // Catch: Throwable -> L6
            this.readCount.set(0);     // Catch: Throwable -> L6
            unlock();
            return;
        L6:
            th = move-exception;
            unlock();
            throw th;
        }

        void runUnlockedCleanup() {
            if (isHeldByCurrentThread() == true) goto L6;
            this.map.processPendingNotifications();
            return;
        }
    }

    static class SoftValueReference<K, V> extends SoftReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> entry;

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(V r1) {
        }

        SoftValueReference(ReferenceQueue<V> r1, V r2, ReferenceEntry<K, V> r3) {
            super(r2, r1);
            this.entry = r3;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return this.entry;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> r1, V r2, ReferenceEntry<K, V> r3) {
            return new SoftValueReference(r1, r2, r3);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V waitForValue() {
            return get();
        }
    }

    static abstract enum Strength extends Enum<Strength> {
        private static final /* synthetic */ Strength[] $VALUES = null;
        public static final Strength SOFT = null;
        public static final Strength STRONG = null;
        public static final Strength WEAK = null;

        abstract Equivalence<Object> defaultEquivalence();

        abstract <K, V> ValueReference<K, V> referenceValue(Segment<K, V> r1, ReferenceEntry<K, V> r2, V r3, int r4);

        private static /* synthetic */ Strength[] $values() {
            return new Strength[]{STRONG, SOFT, WEAK};
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
            final String r3 = "SOFT";
            final int r4 = 1;
            SOFT = new AnonymousClass2(r3, r4);
            final String r5 = "WEAK";
            final int r6 = 2;
            WEAK = new AnonymousClass3(r5, r6);
            $VALUES = $values();
        }
    }

    static final class StrongAccessEntry<K, V> extends StrongEntry<K, V> {
        volatile long accessTime;
        ReferenceEntry<K, V> nextAccess;
        ReferenceEntry<K, V> previousAccess;

        StrongAccessEntry(K r1, int r2, ReferenceEntry<K, V> r3) {
            super(r1, r2, r3);
            this.accessTime = Long.MAX_VALUE;
            this.nextAccess = LocalCache.nullEntry();
            this.previousAccess = LocalCache.nullEntry();
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.accessTime;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long r1) {
            this.accessTime = r1;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.nextAccess;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> r1) {
            this.nextAccess = r1;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> r1) {
            this.previousAccess = r1;
        }
    }

    static final class StrongAccessWriteEntry<K, V> extends StrongEntry<K, V> {
        volatile long accessTime;
        ReferenceEntry<K, V> nextAccess;
        ReferenceEntry<K, V> nextWrite;
        ReferenceEntry<K, V> previousAccess;
        ReferenceEntry<K, V> previousWrite;
        volatile long writeTime;

        StrongAccessWriteEntry(K r1, int r2, ReferenceEntry<K, V> r3) {
            super(r1, r2, r3);
            this.accessTime = Long.MAX_VALUE;
            this.nextAccess = LocalCache.nullEntry();
            this.previousAccess = LocalCache.nullEntry();
            this.writeTime = Long.MAX_VALUE;
            this.nextWrite = LocalCache.nullEntry();
            this.previousWrite = LocalCache.nullEntry();
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.accessTime;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long r1) {
            this.accessTime = r1;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.nextAccess;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> r1) {
            this.nextAccess = r1;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> r1) {
            this.previousAccess = r1;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.writeTime;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long r1) {
            this.writeTime = r1;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.nextWrite;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> r1) {
            this.nextWrite = r1;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> r1) {
            this.previousWrite = r1;
        }
    }

    static class StrongEntry<K, V> extends AbstractReferenceEntry<K, V> {
        final int hash;
        final K key;
        final ReferenceEntry<K, V> next;
        volatile ValueReference<K, V> valueReference;

        StrongEntry(K r2, int r3, ReferenceEntry<K, V> r4) {
            this.valueReference = LocalCache.unset();
            this.key = r2;
            this.hash = r3;
            this.next = r4;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public K getKey() {
            return this.key;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            return this.valueReference;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<K, V> r1) {
            this.valueReference = r1;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public int getHash() {
            return this.hash;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            return this.next;
        }
    }

    static class StrongValueReference<K, V> implements ValueReference<K, V> {
        final V referent;

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> r1, V r2, ReferenceEntry<K, V> r3) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(V r1) {
        }

        StrongValueReference(V r1) {
            this.referent = r1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V get() {
            return this.referent;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V waitForValue() {
            return get();
        }
    }

    static final class StrongWriteEntry<K, V> extends StrongEntry<K, V> {
        ReferenceEntry<K, V> nextWrite;
        ReferenceEntry<K, V> previousWrite;
        volatile long writeTime;

        StrongWriteEntry(K r1, int r2, ReferenceEntry<K, V> r3) {
            super(r1, r2, r3);
            this.writeTime = Long.MAX_VALUE;
            this.nextWrite = LocalCache.nullEntry();
            this.previousWrite = LocalCache.nullEntry();
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.writeTime;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long r1) {
            this.writeTime = r1;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.nextWrite;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> r1) {
            this.nextWrite = r1;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> r1) {
            this.previousWrite = r1;
        }
    }

    final class ValueIterator extends LocalCache<K, V>.HashIterator<V> {
        ValueIterator(LocalCache r1) {
            super(r1);
        }

        @Override // com.google.common.cache.LocalCache.HashIterator, java.util.Iterator
        public V next() {
            return nextEntry().getValue();
        }
    }

    interface ValueReference<K, V> {
        ValueReference<K, V> copyFor(ReferenceQueue<V> r1, V r2, ReferenceEntry<K, V> r3);

        V get();

        ReferenceEntry<K, V> getEntry();

        int getWeight();

        boolean isActive();

        boolean isLoading();

        void notifyNewValue(V r1);

        V waitForValue() throws ExecutionException;
    }

    final class Values extends AbstractCollection<V> {
        final /* synthetic */ LocalCache this$0;

        Values(LocalCache r1) {
            this.this$0 = r1;
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
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ValueIterator(this.this$0);
        }

        @Override // java.util.Collection
        public boolean removeIf(final Predicate<? super V> r2) {
            Preconditions.checkNotNull(r2);
            return this.this$0.removeIf(new LocalCache$Values$$ExternalSyntheticLambda0(r2));
        }

        static /* synthetic */ boolean lambda$removeIf$0(Predicate r0, Object r1, Object r2) {
            return r0.test(r2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r1) {
            return this.this$0.containsValue(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return LocalCache.access$200(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <E> E[] toArray(E[] r1) {
            return (E[]) LocalCache.access$200(this).toArray(r1);
        }
    }

    static final class WeakAccessEntry<K, V> extends WeakEntry<K, V> {
        volatile long accessTime;
        ReferenceEntry<K, V> nextAccess;
        ReferenceEntry<K, V> previousAccess;

        WeakAccessEntry(ReferenceQueue<K> r1, K r2, int r3, ReferenceEntry<K, V> r4) {
            super(r1, r2, r3, r4);
            this.accessTime = Long.MAX_VALUE;
            this.nextAccess = LocalCache.nullEntry();
            this.previousAccess = LocalCache.nullEntry();
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.accessTime;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long r1) {
            this.accessTime = r1;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.nextAccess;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> r1) {
            this.nextAccess = r1;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> r1) {
            this.previousAccess = r1;
        }
    }

    static final class WeakAccessWriteEntry<K, V> extends WeakEntry<K, V> {
        volatile long accessTime;
        ReferenceEntry<K, V> nextAccess;
        ReferenceEntry<K, V> nextWrite;
        ReferenceEntry<K, V> previousAccess;
        ReferenceEntry<K, V> previousWrite;
        volatile long writeTime;

        WeakAccessWriteEntry(ReferenceQueue<K> r1, K r2, int r3, ReferenceEntry<K, V> r4) {
            super(r1, r2, r3, r4);
            this.accessTime = Long.MAX_VALUE;
            this.nextAccess = LocalCache.nullEntry();
            this.previousAccess = LocalCache.nullEntry();
            this.writeTime = Long.MAX_VALUE;
            this.nextWrite = LocalCache.nullEntry();
            this.previousWrite = LocalCache.nullEntry();
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.accessTime;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long r1) {
            this.accessTime = r1;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.nextAccess;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> r1) {
            this.nextAccess = r1;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> r1) {
            this.previousAccess = r1;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.writeTime;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long r1) {
            this.writeTime = r1;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.nextWrite;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> r1) {
            this.nextWrite = r1;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> r1) {
            this.previousWrite = r1;
        }
    }

    static class WeakEntry<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {
        final int hash;
        final ReferenceEntry<K, V> next;
        volatile ValueReference<K, V> valueReference;

        WeakEntry(ReferenceQueue<K> r1, K r2, int r3, ReferenceEntry<K, V> r4) {
            super(r2, r1);
            this.valueReference = LocalCache.unset();
            this.hash = r3;
            this.next = r4;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public K getKey() {
            return (K) get();
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long r1) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> r1) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> r1) {
            throw new UnsupportedOperationException();
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setWriteTime(long r1) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> r1) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            return this.valueReference;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<K, V> r1) {
            this.valueReference = r1;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            return this.hash;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            return this.next;
        }
    }

    static class WeakValueReference<K, V> extends WeakReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> entry;

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(V r1) {
        }

        WeakValueReference(ReferenceQueue<V> r1, V r2, ReferenceEntry<K, V> r3) {
            super(r2, r1);
            this.entry = r3;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return this.entry;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> r1, V r2, ReferenceEntry<K, V> r3) {
            return new WeakValueReference(r1, r2, r3);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V waitForValue() {
            return get();
        }
    }

    static final class WeakWriteEntry<K, V> extends WeakEntry<K, V> {
        ReferenceEntry<K, V> nextWrite;
        ReferenceEntry<K, V> previousWrite;
        volatile long writeTime;

        WeakWriteEntry(ReferenceQueue<K> r1, K r2, int r3, ReferenceEntry<K, V> r4) {
            super(r1, r2, r3, r4);
            this.writeTime = Long.MAX_VALUE;
            this.nextWrite = LocalCache.nullEntry();
            this.previousWrite = LocalCache.nullEntry();
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.writeTime;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long r1) {
            this.writeTime = r1;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.nextWrite;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> r1) {
            this.nextWrite = r1;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> r1) {
            this.previousWrite = r1;
        }
    }

    static final class WeightedSoftValueReference<K, V> extends SoftValueReference<K, V> {
        final int weight;

        WeightedSoftValueReference(ReferenceQueue<V> r1, V r2, ReferenceEntry<K, V> r3, int r4) {
            super(r1, r2, r3);
            this.weight = r4;
        }

        @Override // com.google.common.cache.LocalCache.SoftValueReference, com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.weight;
        }

        @Override // com.google.common.cache.LocalCache.SoftValueReference, com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> r2, V r3, ReferenceEntry<K, V> r4) {
            return new WeightedSoftValueReference(r2, r3, r4, this.weight);
        }
    }

    static final class WeightedStrongValueReference<K, V> extends StrongValueReference<K, V> {
        final int weight;

        WeightedStrongValueReference(V r1, int r2) {
            super(r1);
            this.weight = r2;
        }

        @Override // com.google.common.cache.LocalCache.StrongValueReference, com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.weight;
        }
    }

    static final class WeightedWeakValueReference<K, V> extends WeakValueReference<K, V> {
        final int weight;

        WeightedWeakValueReference(ReferenceQueue<V> r1, V r2, ReferenceEntry<K, V> r3, int r4) {
            super(r1, r2, r3);
            this.weight = r4;
        }

        @Override // com.google.common.cache.LocalCache.WeakValueReference, com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.weight;
        }

        @Override // com.google.common.cache.LocalCache.WeakValueReference, com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> r2, V r3, ReferenceEntry<K, V> r4) {
            return new WeightedWeakValueReference(r2, r3, r4, this.weight);
        }
    }

    static final class WriteQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> head;

        WriteQueue() {
            this.head = new AnonymousClass1(this);
        }

        @Override // java.util.Queue
        public /* bridge */ /* synthetic */ boolean offer(Object r1) {
            return offer((ReferenceEntry) r1);
        }

        @Override // java.util.Queue
        public /* bridge */ /* synthetic */ Object peek() {
            return peek();
        }

        @Override // java.util.Queue
        public /* bridge */ /* synthetic */ Object poll() {
            return poll();
        }

        public boolean offer(ReferenceEntry<K, V> r3) {
            LocalCache.connectWriteOrder(r3.getPreviousInWriteQueue(), r3.getNextInWriteQueue());
            LocalCache.connectWriteOrder(this.head.getPreviousInWriteQueue(), r3);
            LocalCache.connectWriteOrder(r3, this.head);
            return true;
        }

        @Override // java.util.Queue
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> r0 = this.head.getNextInWriteQueue();
            if (r0 != this.head) goto L6;
            return null;
        L6:
            return r0;
        }

        @Override // java.util.Queue
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> r0 = this.head.getNextInWriteQueue();
            if (r0 != this.head) goto L6;
            return null;
        L6:
            remove(r0);
            return r0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object r2) {
            ReferenceEntry r3 = (ReferenceEntry) r2;
            ReferenceEntry<K, V> r1 = r3.getPreviousInWriteQueue();
            ReferenceEntry<K, V> r0 = r3.getNextInWriteQueue();
            LocalCache.connectWriteOrder(r1, r0);
            LocalCache.nullifyWriteOrder(r3);
            if (r0 == NullEntry.INSTANCE) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r1) {
            if (((ReferenceEntry) r1).getNextInWriteQueue() == NullEntry.INSTANCE) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.head.getNextInWriteQueue() != this.head) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            ReferenceEntry<K, V> r0 = this.head.getNextInWriteQueue();
            int r1 = 0;
        L4:
            if (r0 == this.head) goto L6;
            r1 = r1 + 1;
            r0 = r0.getNextInWriteQueue();
            goto L4
        L6:
            return r1;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ReferenceEntry<K, V> r0 = this.head.getNextInWriteQueue();
        L3:
            ReferenceEntry<K, V> r1 = this.head;
            if (r0 == r1) goto L6;
            ReferenceEntry<K, V> r2 = r0.getNextInWriteQueue();
            LocalCache.nullifyWriteOrder(r0);
            r0 = r2;
            goto L3
        L6:
            r1.setNextInWriteQueue(r1);
            ReferenceEntry<K, V> r3 = this.head;
            r3.setPreviousInWriteQueue(r3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<ReferenceEntry<K, V>> iterator() {
            final ReferenceEntry<K, V> r1 = peek();
            return new AnonymousClass2(this, r1);
        }
    }

    final class WriteThroughEntry implements Map.Entry<K, V> {
        final K key;
        final /* synthetic */ LocalCache this$0;
        V value;

        WriteThroughEntry(LocalCache r1, K r2, V r3) {
            this.this$0 = r1;
            this.key = r2;
            this.value = r3;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
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

        @Override // java.util.Map.Entry
        public int hashCode() {
            int r0 = this.key.hashCode();
            return this.value.hashCode() ^ r0;
        }

        @Override // java.util.Map.Entry
        public V setValue(V r3) {
            V r0 = (V) this.this$0.put(this.key, r3);
            this.value = r3;
            return r0;
        }

        public String toString() {
            String r0 = String.valueOf(getKey());
            String r3 = String.valueOf(getValue());
            return new StringBuilder((String.valueOf(r0).length() + 1) + String.valueOf(r3).length()).append(r0).append("=").append(r3).toString();
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

    static /* synthetic */ ArrayList access$200(Collection r0) {
        return toArrayList(r0);
    }

    static {
        logger = Logger.getLogger(LocalCache.class.getName());
        UNSET = new AnonymousClass1();
        DISCARDING_QUEUE = new AnonymousClass2();
    }

    LocalCache(CacheBuilder<? super K, ? super V> r12, CacheLoader<? super K, V> r13) {
        this.concurrencyLevel = Math.min(r12.getConcurrencyLevel(), 65536);
        Strength r0 = r12.getKeyStrength();
        this.keyStrength = r0;
        this.valueStrength = r12.getValueStrength();
        this.keyEquivalence = r12.getKeyEquivalence();
        this.valueEquivalence = r12.getValueEquivalence();
        long r1 = r12.getMaximumWeight();
        this.maxWeight = r1;
        this.weigher = (Weigher<K, V>) r12.getWeigher();
        this.expireAfterAccessNanos = r12.getExpireAfterAccessNanos();
        this.expireAfterWriteNanos = r12.getExpireAfterWriteNanos();
        this.refreshNanos = r12.getRefreshNanos();
        CacheBuilder.NullListener r3 = (RemovalListener<K, V>) r12.getRemovalListener();
        this.removalListener = r3;
        if (r3 != CacheBuilder.NullListener.INSTANCE) goto L5;
        Queue<RemovalNotification<K, V>> r4 = discardingQueue();
    L6:
        this.removalNotificationQueue = r4;
        this.ticker = r12.getTicker(recordsTime());
        this.entryFactory = EntryFactory.getFactory(r0, usesAccessEntries(), usesWriteEntries());
        this.globalStatsCounter = r12.getStatsCounterSupplier().get();
        this.defaultLoader = r13;
        int r14 = Math.min(r12.getInitialCapacity(), 1073741824);
        if (evictsBySize() == true) goto L9;
    L11:
        int r2 = 0;
        int r5 = 1;
        int r6 = 0;
        int r7 = 1;
    L13:
        if (r7 >= this.concurrencyLevel) goto L19;
        if (evictsBySize() == false) goto L18;
        if ((r7 * 20) > this.maxWeight) goto L19;
    L18:
        r6 = r6 + 1;
        r7 = r7 << 1;
    L19:
        this.segmentShift = 32 - r6;
        this.segmentMask = r7 - 1;
        this.segments = newSegmentArray(r7);
        int r8 = r14 / r7;
        if ((r8 * r7) >= r14) goto L22;
        r8 = r8 + 1;
    L22:
        if (r5 >= r8) goto L25;
        r5 = r5 << 1;
        goto L22
    L25:
        if (evictsBySize() == false) goto L33;
        long r9 = this.maxWeight;
        long r10 = r7;
        long r11 = (r9 / r10) + 1;
        long r15 = r9 % r10;
    L27:
        Segment<K, V>[] r16 = this.segments;
        if (r2 >= r16.length) goto L36;
        if (r2 != r15) goto L32;
        r11 = r11 - 1;
    L32:
        r16[r2] = createSegment(r5, r11, r12.getStatsCounterSupplier().get());
        r2 = r2 + 1;
        goto L27
    L36:
        return;
    L33:
        Segment<K, V>[] r17 = this.segments;
        if (r2 >= r17.length) goto L47;
        r17[r2] = createSegment(r5, -1, r12.getStatsCounterSupplier().get());
        r2 = r2 + 1;
        goto L33
    L47:
        return;
    L9:
        if (customWeigher() == true) goto L11;
        r14 = (int) Math.min(r14, r1);
        goto L11
    L5:
        r4 = new ConcurrentLinkedQueue();
        goto L6
    }

    boolean evictsBySize() {
        if (this.maxWeight < 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean customWeigher() {
        if (this.weigher == CacheBuilder.OneWeigher.INSTANCE) goto L5;
        return true;
    L5:
        return false;
    }

    boolean expires() {
        if (expiresAfterWrite() == false) goto L5;
    L8:
        return true;
    L5:
        if (expiresAfterAccess() == true) goto L8;
        return false;
    }

    boolean expiresAfterWrite() {
        if (this.expireAfterWriteNanos <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean expiresAfterAccess() {
        if (this.expireAfterAccessNanos <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean refreshes() {
        if (this.refreshNanos <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean usesAccessQueue() {
        if (expiresAfterAccess() == false) goto L5;
    L8:
        return true;
    L5:
        if (evictsBySize() == true) goto L8;
        return false;
    }

    boolean usesWriteQueue() {
        return expiresAfterWrite();
    }

    boolean recordsWrite() {
        if (expiresAfterWrite() == false) goto L5;
    L8:
        return true;
    L5:
        if (refreshes() == true) goto L8;
        return false;
    }

    boolean recordsAccess() {
        return expiresAfterAccess();
    }

    boolean recordsTime() {
        if (recordsWrite() == false) goto L5;
    L8:
        return true;
    L5:
        if (recordsAccess() == true) goto L8;
        return false;
    }

    boolean usesWriteEntries() {
        if (usesWriteQueue() == false) goto L5;
    L8:
        return true;
    L5:
        if (recordsWrite() == true) goto L8;
        return false;
    }

    boolean usesAccessEntries() {
        if (usesAccessQueue() == false) goto L5;
    L8:
        return true;
    L5:
        if (recordsAccess() == true) goto L8;
        return false;
    }

    boolean usesKeyReferences() {
        if (this.keyStrength == Strength.STRONG) goto L5;
        return true;
    L5:
        return false;
    }

    boolean usesValueReferences() {
        if (this.valueStrength == Strength.STRONG) goto L5;
        return true;
    L5:
        return false;
    }

    static <K, V> ValueReference<K, V> unset() {
        return (ValueReference<K, V>) UNSET;
    }

    static <K, V> ReferenceEntry<K, V> nullEntry() {
        return NullEntry.INSTANCE;
    }

    static <E> Queue<E> discardingQueue() {
        return (Queue<E>) DISCARDING_QUEUE;
    }

    ReferenceEntry<K, V> newEntry(K r1, int r2, ReferenceEntry<K, V> r3) {
        Segment<K, V> r0 = segmentFor(r2);
        r0.lock();
        ReferenceEntry<K, V> r4 = r0.newEntry(r1, r2, r3);     // Catch: Throwable -> L6
        r0.unlock();
        return r4;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    ReferenceEntry<K, V> copyEntry(ReferenceEntry<K, V> r2, ReferenceEntry<K, V> r3) {
        return segmentFor(r2.getHash()).copyEntry(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    ValueReference<K, V> newValueReference(ReferenceEntry<K, V> r3, V r4, int r5) {
        int r0 = r3.getHash();
        return this.valueStrength.referenceValue(segmentFor(r0), r3, Preconditions.checkNotNull(r4), r5);
    }

    int hash(Object r1) {
        return rehash(this.keyEquivalence.hash(r1));
    }

    void reclaimValue(ValueReference<K, V> r3) {
        ReferenceEntry<K, V> r0 = r3.getEntry();
        int r1 = r0.getHash();
        segmentFor(r1).reclaimValue(r0.getKey(), r1, r3);
    }

    void reclaimKey(ReferenceEntry<K, V> r2) {
        int r0 = r2.getHash();
        segmentFor(r0).reclaimKey(r2, r0);
    }

    boolean isLive(ReferenceEntry<K, V> r2, long r3) {
        if (segmentFor(r2.getHash()).getLiveValue(r2, r3) == null) goto L5;
        return true;
    L5:
        return false;
    }

    Segment<K, V> segmentFor(int r3) {
        Segment<K, V>[] r0 = this.segments;
        int r4 = r3 >>> this.segmentShift;
        return r0[this.segmentMask & r4];
    }

    Segment<K, V> createSegment(int r8, long r9, AbstractCache.StatsCounter r11) {
        return new Segment(this, r8, r9, r11);
    }

    V getLiveValue(ReferenceEntry<K, V> r3, long r4) {
        if (r3.getKey() != null) goto L5;
        return null;
    L5:
        V r0 = r3.getValueReference().get();
        if (r0 != null) goto L9;
        return null;
    L9:
        if (isExpired(r3, r4) == false) goto L11;
        return null;
    L11:
        return r0;
    }

    boolean isExpired(ReferenceEntry<K, V> r7, long r8) {
        Preconditions.checkNotNull(r7);
        if (expiresAfterAccess() == false) goto L8;
        if ((r8 - r7.getAccessTime()) < this.expireAfterAccessNanos) goto L8;
        return true;
    L8:
        if (expiresAfterWrite() == true) goto L10;
        return false;
    L10:
        if ((r8 - r7.getWriteTime()) < this.expireAfterWriteNanos) goto L14;
        return true;
    L14:
        return false;
    }

    static <K, V> void connectAccessOrder(ReferenceEntry<K, V> r0, ReferenceEntry<K, V> r1) {
        r0.setNextInAccessQueue(r1);
        r1.setPreviousInAccessQueue(r0);
    }

    static <K, V> void nullifyAccessOrder(ReferenceEntry<K, V> r1) {
        ReferenceEntry<K, V> r0 = nullEntry();
        r1.setNextInAccessQueue(r0);
        r1.setPreviousInAccessQueue(r0);
    }

    static <K, V> void connectWriteOrder(ReferenceEntry<K, V> r0, ReferenceEntry<K, V> r1) {
        r0.setNextInWriteQueue(r1);
        r1.setPreviousInWriteQueue(r0);
    }

    static <K, V> void nullifyWriteOrder(ReferenceEntry<K, V> r1) {
        ReferenceEntry<K, V> r0 = nullEntry();
        r1.setNextInWriteQueue(r0);
        r1.setPreviousInWriteQueue(r0);
    }

    void processPendingNotifications() {
    L2:
        RemovalNotification<K, V> r0 = this.removalNotificationQueue.poll();
        if (r0 == null) goto L8;
        this.removalListener.onRemoval(r0);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        logger.log(Level.WARNING, "Exception thrown by removal listener", th);
        goto L2
    }

    final Segment<K, V>[] newSegmentArray(int r1) {
        return new Segment[r1];
    }

    public void cleanUp() {
        Segment<K, V>[] r3 = this.segments;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].cleanUp();
        r1 = r1 + 1;
        goto L3
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V>[] r9 = this.segments;
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

    long longSize() {
        Segment<K, V>[] r5 = this.segments;
        long r0 = 0;
        int r2 = 0;
    L4:
        if (r2 >= r5.length) goto L6;
        r0 = r0 + ((long) r5[r2].count);
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return Ints.saturatedCast(longSize());
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        int r0 = hash(r2);
        return segmentFor(r0).get(r2, r0);
    }

    V get(K r2, CacheLoader<? super K, V> r3) throws ExecutionException {
        int r0 = hash(Preconditions.checkNotNull(r2));
        return segmentFor(r0).get(r2, r0, r3);
    }

    public V getIfPresent(Object r3) {
        int r0 = hash(Preconditions.checkNotNull(r3));
        V r4 = segmentFor(r0).get(r3, r0);
        if (r4 != null) goto L5;
        this.globalStatsCounter.recordMisses(1);
    L6:
        return r4;
    L5:
        this.globalStatsCounter.recordHits(1);
        goto L6
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V getOrDefault(Object r1, V r2) {
        V r0 = get(r1);
        if (r0 != null) goto L5;
        return r2;
    L5:
        return r0;
    }

    V getOrLoad(K r2) throws ExecutionException {
        return get(r2, this.defaultLoader);
    }

    /* JADX WARN: Multi-variable type inference failed */
    ImmutableMap<K, V> getAllPresent(Iterable<?> r6) {
        LinkedHashMap r0 = Maps.newLinkedHashMap();
        Iterator<?> r7 = r6.iterator();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r7.hasNext() == false) goto L9;
        Object r3 = r7.next();
        V r4 = get(r3);
        if (r4 == null) goto L7;
        r0.put(r3, r4);
        r1 = r1 + 1;
        goto L4
    L7:
        r2 = r2 + 1;
        goto L4
    L9:
        this.globalStatsCounter.recordHits(r1);
        this.globalStatsCounter.recordMisses(r2);
        return ImmutableMap.copyOf(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    ImmutableMap<K, V> getAll(Iterable<? extends K> r8) throws ExecutionException {
        LinkedHashMap r0 = Maps.newLinkedHashMap();
        LinkedHashSet r1 = Sets.newLinkedHashSet();
        Iterator<? extends K> r9 = r8.iterator();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r9.hasNext() == false) goto L31;
        K r4 = r9.next();
        Object r5 = get(r4);
        if (r0.containsKey(r4) == true) goto L4;
        r0.put(r4, r5);
        if (r5 == null) goto L9;
        r2 = r2 + 1;
        goto L4
    L9:
        r3 = r3 + 1;
        r1.add(r4);
        goto L4
    L31:
    L28:
        th = move-exception;
        this.globalStatsCounter.recordHits(r2);
        this.globalStatsCounter.recordMisses(r3);
        throw th;
    L12:
        if (r1.isEmpty() == false) goto L32;
    L25:
        ImmutableMap<K, V> r10 = ImmutableMap.copyOf(r0);     // Catch: Throwable -> L28
        this.globalStatsCounter.recordHits(r2);
        this.globalStatsCounter.recordMisses(r3);
        return r10;
    L32:
        Map r11 = loadAll(r1, this.defaultLoader);     // Catch: CacheLoader.UnsupportedLoadingOperationException -> L21 Throwable -> L28
        Iterator r6 = r1.iterator();     // Catch: CacheLoader.UnsupportedLoadingOperationException -> L21 Throwable -> L28
    L15:
        if (r6.hasNext() == false) goto L25;
        Object r7 = r6.next();     // Catch: CacheLoader.UnsupportedLoadingOperationException -> L21 Throwable -> L28
        Object r12 = r11.get(r7);     // Catch: CacheLoader.UnsupportedLoadingOperationException -> L21 Throwable -> L28
        if (r12 == null) goto L19;
        r0.put(r7, r12);     // Catch: CacheLoader.UnsupportedLoadingOperationException -> L21 Throwable -> L28
        goto L15
    L19:
        String r13 = String.valueOf(r7);     // Catch: CacheLoader.UnsupportedLoadingOperationException -> L21 Throwable -> L28
        throw new CacheLoader.InvalidCacheLoadException(new StringBuilder(String.valueOf(r13).length() + 37).append("loadAll failed to return a value for ").append(r13).toString());     // Catch: CacheLoader.UnsupportedLoadingOperationException -> L21 Throwable -> L28
    L21:
        Iterator r14 = r1.iterator();     // Catch: Throwable -> L28
    L23:
        if (r14.hasNext() == false) goto L25;
        Object r15 = r14.next();     // Catch: Throwable -> L28
        r3 = r3 - 1;     // Catch: Throwable -> L28
        r0.put(r15, get(r15, this.defaultLoader));     // Catch: Throwable -> L28
        goto L23
    }

    Map<K, V> loadAll(Set<? extends K> r7, CacheLoader<? super K, V> r8) throws ExecutionException {
        Preconditions.checkNotNull(r8);
        Preconditions.checkNotNull(r7);
        Stopwatch r0 = Stopwatch.createStarted();
        boolean r1 = true;
        boolean r2 = false;
        Map<? super K, V> r9 = r8.loadAll(r7);     // Catch: Throwable -> L21 Error -> L23 Exception -> L26 RuntimeException -> L29 InterruptedException -> L32 CacheLoader.UnsupportedLoadingOperationException -> L35
        if (r9 == null) goto L19;
        r0.stop();
        Iterator<Map.Entry<K, V>> r3 = r9.entrySet().iterator();
    L7:
        if (r3.hasNext() == false) goto L14;
        Map.Entry<K, V> r4 = r3.next();
        K r5 = r4.getKey();
        V r6 = r4.getValue();
        if (r5 == null) goto L13;
        if (r6 == null) goto L13;
        put(r5, r6);
    L13:
        r2 = true;
        goto L7
    L14:
        if (r2 == true) goto L17;
        this.globalStatsCounter.recordLoadSuccess(r0.elapsed(TimeUnit.NANOSECONDS));
        return r9;
    L17:
        this.globalStatsCounter.recordLoadException(r0.elapsed(TimeUnit.NANOSECONDS));
        String r10 = String.valueOf(r8);
        throw new CacheLoader.InvalidCacheLoadException(new StringBuilder(String.valueOf(r10).length() + 42).append(r10).append(" returned null keys or values from loadAll").toString());
    L19:
        this.globalStatsCounter.recordLoadException(r0.elapsed(TimeUnit.NANOSECONDS));
        String r11 = String.valueOf(r8);
        throw new CacheLoader.InvalidCacheLoadException(new StringBuilder(String.valueOf(r11).length() + 31).append(r11).append(" returned null map from loadAll").toString());
    L21:
        th = th;
        r1 = false;
    L38:
        if (r1 == true) goto L40;
        this.globalStatsCounter.recordLoadException(r0.elapsed(TimeUnit.NANOSECONDS));
    L40:
        throw th;
    L35:
        e = move-exception;
        throw e;     // Catch: Throwable -> L37
    L37:
        th = th;
    L26:
        e = move-exception;
        throw new ExecutionException(e);     // Catch: Throwable -> L21
    L23:
        e = move-exception;
        throw new ExecutionError(e);     // Catch: Throwable -> L21
    L32:
        e = move-exception;
        Thread.currentThread().interrupt();     // Catch: Throwable -> L21
        throw new ExecutionException(e);     // Catch: Throwable -> L21
    L29:
        e = move-exception;
        throw new UncheckedExecutionException(e);     // Catch: Throwable -> L21
    }

    ReferenceEntry<K, V> getEntry(Object r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        int r0 = hash(r2);
        return segmentFor(r0).getEntry(r2, r0);
    }

    void refresh(K r4) {
        int r0 = hash(Preconditions.checkNotNull(r4));
        segmentFor(r0).refresh(r4, r0, this.defaultLoader, false);
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
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v3 */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object r20) {
        boolean r2 = false;
        if (r20 != null) goto L5;
        return false;
    L5:
        long r3 = this.ticker.read();
        Segment<K, V>[] r5 = this.segments;
        long r6 = -1;
        int r8 = 0;
    L7:
        if (r8 >= 3) goto L29;
        int r9 = r5.length;
        long r10 = 0;
        ?? r12 = r2;
    L9:
        if (r12 >= r9) goto L24;
        Segment<K, V> r13 = r5[r12];
        int r14 = r13.count;
        AtomicReferenceArray<ReferenceEntry<K, V>> r15 = r13.table;
        ?? r16 = r2;
    L12:
        if (r16 >= r15.length()) goto L23;
        ReferenceEntry<K, V> r4 = r15.get(r16);
    L14:
        if (r4 == null) goto L22;
        Segment<K, V>[] r17 = r5;
        V r7 = r13.getLiveValue(r4, r3);
        long r18 = r3;
        if (r7 == null) goto L21;
        if (this.valueEquivalence.equivalent(r20, r7) == false) goto L21;
        return true;
    L21:
        r4 = r4.getNext();
        r5 = r17;
        r3 = r18;
        goto L14
    L22:
        r16 = r16 + 1;
        goto L12
    L23:
        r10 = r10 + ((long) r13.modCount);
        r3 = r3;
        r2 = false;
        r12 = r12 + 1;
        goto L9
    L24:
        long r19 = r3;
        Segment<K, V>[] r110 = r5;
        if (r10 == r6) goto L26;
        r8 = r8 + 1;
        r6 = r10;
        r5 = r110;
        r3 = r19;
        r2 = false;
        goto L7
    L26:
        return false;
    L29:
        return r2;
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

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V compute(K r2, BiFunction<? super K, ? super V, ? extends V> r3) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        int r0 = hash(r2);
        return segmentFor(r0).compute(r2, r0, r3);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V computeIfAbsent(final K r2, final Function<? super K, ? extends V> r3) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        return compute(r2, new LocalCache$$ExternalSyntheticLambda0(r3, r2));
    }

    static /* synthetic */ Object lambda$computeIfAbsent$0(Function r0, Object r1, Object r2, Object r3) {
        if (r3 == null) goto L4;
        return r3;
    L4:
        return r0.apply(r1);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V computeIfPresent(K r2, final BiFunction<? super K, ? super V, ? extends V> r3) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        return compute(r2, new LocalCache$$ExternalSyntheticLambda1(r3));
    }

    static /* synthetic */ Object lambda$computeIfPresent$1(BiFunction r0, Object r1, Object r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        return r0.apply(r1, r2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V merge(K r2, final V r3, final BiFunction<? super V, ? super V, ? extends V> r4) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        return compute(r2, new LocalCache$$ExternalSyntheticLambda2(r3, r4));
    }

    static /* synthetic */ Object lambda$merge$2(Object r0, BiFunction r1, Object r2, Object r3) {
        if (r3 != null) goto L5;
        return r0;
    L5:
        return r1.apply(r3, r0);
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
        Segment<K, V>[] r3 = this.segments;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].clear();
        r1 = r1 + 1;
        goto L3
    }

    void invalidateAll(Iterable<?> r2) {
        Iterator<?> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        remove(r3.next());
        goto L4
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

    boolean removeIf(BiPredicate<? super K, ? super V> r6) {
        Preconditions.checkNotNull(r6);
        Iterator<K> r0 = keySet().iterator();
        boolean r1 = false;
    L4:
        if (r0.hasNext() == false) goto L14;
        K r2 = r0.next();
    L6:
        V r3 = get(r2);
        if (r3 == null) goto L4;
        if (r6.test(r2, r3) == false) goto L4;
        if (remove(r2, r3) == false) goto L6;
        r1 = true;
        goto L4
    L14:
        return r1;
    }
}
