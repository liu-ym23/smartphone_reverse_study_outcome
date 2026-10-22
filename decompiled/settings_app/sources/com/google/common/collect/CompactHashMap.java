package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import javax.annotation.CheckForNull;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final double HASH_FLOODING_FPP = 0.001d;
    private static final int MAX_HASH_BUCKET_LENGTH = 9;
    private static final Object NOT_FOUND = null;

    @CheckForNull
    transient int[] entries;

    @CheckForNull
    private transient Set<Map.Entry<K, V>> entrySetView;

    @CheckForNull
    private transient Set<K> keySetView;

    @CheckForNull
    transient Object[] keys;
    private transient int metadata;
    private transient int size;

    @CheckForNull
    private transient Object table;

    @CheckForNull
    transient Object[] values;

    @CheckForNull
    private transient Collection<V> valuesView;

    class EntrySetView extends Maps.EntrySet<K, V> {
        final /* synthetic */ CompactHashMap this$0;

        EntrySetView(CompactHashMap r1) {
            this.this$0 = r1;
        }

        @Override // com.google.common.collect.Maps.EntrySet
        Map<K, V> map() {
            return this.this$0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return this.this$0.entrySetIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<Map.Entry<K, V>> spliterator() {
            Map<K, V> r0 = this.this$0.delegateOrNull();
            if (r0 == null) goto L6;
            return r0.entrySet().spliterator();
        L6:
            return CollectSpliterators.indexed(CompactHashMap.access$300(this.this$0), 17, new CompactHashMap$EntrySetView$$ExternalSyntheticLambda0(this));
        }

        /* JADX INFO: renamed from: lambda$spliterator$0$com-google-common-collect-CompactHashMap$EntrySetView, reason: not valid java name */
        /* synthetic */ Map.Entry m902x823e55f9(int r2) {
            return new MapEntry(this.this$0, r2);
        }

        @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r4) {
            Map<K, V> r0 = this.this$0.delegateOrNull();
            if (r0 == null) goto L7;
            return r0.entrySet().contains(r4);
        L7:
            if ((r4 instanceof Map.Entry) == false) goto L14;
            Map.Entry r5 = (Map.Entry) r4;
            int r1 = CompactHashMap.access$700(this.this$0, r5.getKey());
            if (r1 != (-1)) goto L11;
            return false;
        L11:
            if (Objects.equal(CompactHashMap.access$800(this.this$0, r1), r5.getValue()) == false) goto L16;
            return true;
        L16:
            return false;
        L14:
            return false;
        }

        @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object r10) {
            Map<K, V> r0 = this.this$0.delegateOrNull();
            if (r0 == null) goto L7;
            return r0.entrySet().remove(r10);
        L7:
            if ((r10 instanceof Map.Entry) == false) goto L16;
            Map.Entry r11 = (Map.Entry) r10;
            if (this.this$0.needsAllocArrays() == false) goto L11;
            return false;
        L11:
            int r1 = CompactHashMap.access$900(this.this$0);
            int r12 = CompactHashing.remove(r11.getKey(), r11.getValue(), r1, CompactHashMap.access$1000(this.this$0), CompactHashMap.access$1100(this.this$0), CompactHashMap.access$200(this.this$0), CompactHashMap.access$1200(this.this$0));
            if (r12 != (-1)) goto L14;
            return false;
        L14:
            this.this$0.moveLastEntry(r12, r1);
            CompactHashMap.access$310(this.this$0);
            this.this$0.incrementModCount();
            return true;
        L16:
            return false;
        }
    }

    private abstract class Itr<T> implements Iterator<T> {
        int currentIndex;
        int expectedMetadata;
        int indexToRemove;
        final /* synthetic */ CompactHashMap this$0;

        @ParametricNullness
        abstract T getOutput(int r1);

        private Itr(CompactHashMap r2) {
            this.this$0 = r2;
            this.expectedMetadata = CompactHashMap.access$000(r2);
            this.currentIndex = r2.firstEntryIndex();
            this.indexToRemove = -1;
        }

        /* synthetic */ Itr(CompactHashMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.currentIndex < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            checkForConcurrentModification();
            if (hasNext() == false) goto L7;
            int r0 = this.currentIndex;
            this.indexToRemove = r0;
            T r1 = getOutput(r0);
            this.currentIndex = this.this$0.getSuccessor(this.currentIndex);
            return r1;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            checkForConcurrentModification();
            if (this.indexToRemove < 0) goto L5;
            boolean r0 = true;
        L6:
            CollectPreconditions.checkRemove(r0);
            incrementExpectedModCount();
            CompactHashMap r1 = this.this$0;
            r1.remove(CompactHashMap.access$100(r1, this.indexToRemove));
            this.currentIndex = this.this$0.adjustAfterRemove(this.currentIndex, this.indexToRemove);
            this.indexToRemove = -1;
            return;
        L5:
            r0 = false;
            goto L6
        }

        void incrementExpectedModCount() {
            this.expectedMetadata += 32;
        }

        private void checkForConcurrentModification() {
            if (CompactHashMap.access$000(this.this$0) != this.expectedMetadata) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }
    }

    class KeySetView extends Maps.KeySet<K, V> {
        final /* synthetic */ CompactHashMap this$0;

        KeySetView(CompactHashMap r1) {
            this.this$0 = r1;
            super(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            if (this.this$0.needsAllocArrays() == true) goto L5;
            Map<K, V> r0 = this.this$0.delegateOrNull();
            if (r0 == null) goto L10;
            return r0.keySet().toArray();
        L10:
            return ObjectArrays.copyAsObjectArray(CompactHashMap.access$200(this.this$0), 0, CompactHashMap.access$300(this.this$0));
        L5:
            return new Object[0];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r3) {
            if (this.this$0.needsAllocArrays() == true) goto L5;
            Map<K, V> r0 = this.this$0.delegateOrNull();
            if (r0 == null) goto L12;
            return (T[]) r0.keySet().toArray(r3);
        L12:
            return (T[]) ObjectArrays.toArrayImpl(CompactHashMap.access$200(this.this$0), 0, CompactHashMap.access$300(this.this$0), r3);
        L5:
            if (r3.length <= 0) goto L7;
            r3[0] = null;
        L7:
            return r3;
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object r2) {
            Map<K, V> r0 = this.this$0.delegateOrNull();
            if (r0 == null) goto L6;
            return r0.keySet().remove(r2);
        L6:
            if (CompactHashMap.access$400(this.this$0, r2) == CompactHashMap.access$500()) goto L8;
            return true;
        L8:
            return false;
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return this.this$0.keySetIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<K> spliterator() {
            if (this.this$0.needsAllocArrays() == true) goto L5;
            Map<K, V> r0 = this.this$0.delegateOrNull();
            if (r0 == null) goto L10;
            return r0.keySet().spliterator();
        L10:
            return Spliterators.spliterator(CompactHashMap.access$200(this.this$0), 0, CompactHashMap.access$300(this.this$0), 17);
        L5:
            return Spliterators.spliterator(new Object[0], 17);
        }

        @Override // com.google.common.collect.Maps.KeySet, java.lang.Iterable
        public void forEach(Consumer<? super K> r3) {
            Preconditions.checkNotNull(r3);
            Map<K, V> r0 = this.this$0.delegateOrNull();
            if (r0 == null) goto L5;
            r0.keySet().forEach(r3);
            return;
        L5:
            int r1 = this.this$0.firstEntryIndex();
        L6:
            if (r1 < 0) goto L10;
            r3.accept((Object) CompactHashMap.access$100(this.this$0, r1));
            r1 = this.this$0.getSuccessor(r1);
            goto L6
        }
    }

    final class MapEntry extends AbstractMapEntry<K, V> {

        @ParametricNullness
        private final K key;
        private int lastKnownIndex;
        final /* synthetic */ CompactHashMap this$0;

        MapEntry(CompactHashMap r1, int r2) {
            this.this$0 = r1;
            this.key = (K) CompactHashMap.access$100(r1, r2);
            this.lastKnownIndex = r2;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public K getKey() {
            return this.key;
        }

        private void updateLastKnownIndex() {
            int r0 = this.lastKnownIndex;
            if (r0 != (-1)) goto L5;
        L8:
            this.lastKnownIndex = CompactHashMap.access$700(this.this$0, this.key);
            return;
        L5:
            if (r0 >= this.this$0.size()) goto L8;
            if (Objects.equal(this.key, CompactHashMap.access$100(this.this$0, this.lastKnownIndex)) == false) goto L8;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public V getValue() {
            Map<K, V> r0 = this.this$0.delegateOrNull();
            if (r0 != null) goto L5;
            updateLastKnownIndex();
            int r1 = this.lastKnownIndex;
            if (r1 != (-1)) goto L10;
            return (V) NullnessCasts.unsafeNull();
        L10:
            return (V) CompactHashMap.access$800(this.this$0, r1);
        L5:
            return (V) NullnessCasts.uncheckedCastNullableTToT(r0.get(this.key));
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public V setValue(@ParametricNullness V r3) {
            Map<K, V> r0 = this.this$0.delegateOrNull();
            if (r0 != null) goto L5;
            updateLastKnownIndex();
            int r1 = this.lastKnownIndex;
            if (r1 != (-1)) goto L10;
            this.this$0.put(this.key, r3);
            return (V) NullnessCasts.unsafeNull();
        L10:
            V r2 = (V) CompactHashMap.access$800(this.this$0, r1);
            CompactHashMap.access$1300(this.this$0, this.lastKnownIndex, r3);
            return r2;
        L5:
            return (V) NullnessCasts.uncheckedCastNullableTToT(r0.put(this.key, r3));
        }
    }

    class ValuesView extends Maps.Values<K, V> {
        final /* synthetic */ CompactHashMap this$0;

        ValuesView(CompactHashMap r1) {
            this.this$0 = r1;
            super(r1);
        }

        @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return this.this$0.valuesIterator();
        }

        @Override // com.google.common.collect.Maps.Values, java.lang.Iterable
        public void forEach(Consumer<? super V> r3) {
            Preconditions.checkNotNull(r3);
            Map<K, V> r0 = this.this$0.delegateOrNull();
            if (r0 == null) goto L5;
            r0.values().forEach(r3);
            return;
        L5:
            int r1 = this.this$0.firstEntryIndex();
        L6:
            if (r1 < 0) goto L10;
            r3.accept((Object) CompactHashMap.access$800(this.this$0, r1));
            r1 = this.this$0.getSuccessor(r1);
            goto L6
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<V> spliterator() {
            if (this.this$0.needsAllocArrays() == true) goto L5;
            Map<K, V> r0 = this.this$0.delegateOrNull();
            if (r0 == null) goto L10;
            return r0.values().spliterator();
        L10:
            return Spliterators.spliterator(CompactHashMap.access$1200(this.this$0), 0, CompactHashMap.access$300(this.this$0), 16);
        L5:
            return Spliterators.spliterator(new Object[0], 16);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            if (this.this$0.needsAllocArrays() == true) goto L5;
            Map<K, V> r0 = this.this$0.delegateOrNull();
            if (r0 == null) goto L10;
            return r0.values().toArray();
        L10:
            return ObjectArrays.copyAsObjectArray(CompactHashMap.access$1200(this.this$0), 0, CompactHashMap.access$300(this.this$0));
        L5:
            return new Object[0];
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] r3) {
            if (this.this$0.needsAllocArrays() == true) goto L5;
            Map<K, V> r0 = this.this$0.delegateOrNull();
            if (r0 == null) goto L12;
            return (T[]) r0.values().toArray(r3);
        L12:
            return (T[]) ObjectArrays.toArrayImpl(CompactHashMap.access$1200(this.this$0), 0, CompactHashMap.access$300(this.this$0), r3);
        L5:
            if (r3.length <= 0) goto L7;
            r3[0] = null;
        L7:
            return r3;
        }
    }

    void accessEntry(int r1) {
    }

    int adjustAfterRemove(int r1, int r2) {
        return r1 - 1;
    }

    static /* synthetic */ int access$000(CompactHashMap r0) {
        return r0.metadata;
    }

    static /* synthetic */ Object access$100(CompactHashMap r0, int r1) {
        return r0.key(r1);
    }

    static /* synthetic */ Object access$1000(CompactHashMap r0) {
        return r0.requireTable();
    }

    static /* synthetic */ int[] access$1100(CompactHashMap r0) {
        return r0.requireEntries();
    }

    static /* synthetic */ Object[] access$1200(CompactHashMap r0) {
        return r0.requireValues();
    }

    static /* synthetic */ void access$1300(CompactHashMap r0, int r1, Object r2) {
        r0.setValue(r1, r2);
    }

    static /* synthetic */ Object[] access$200(CompactHashMap r0) {
        return r0.requireKeys();
    }

    static /* synthetic */ int access$300(CompactHashMap r0) {
        return r0.size;
    }

    static /* synthetic */ int access$310(CompactHashMap r2) {
        int r0 = r2.size;
        r2.size = r0 - 1;
        return r0;
    }

    static /* synthetic */ Object access$400(CompactHashMap r0, Object r1) {
        return r0.removeHelper(r1);
    }

    static /* synthetic */ Object access$500() {
        return NOT_FOUND;
    }

    static /* synthetic */ int access$700(CompactHashMap r0, Object r1) {
        return r0.indexOf(r1);
    }

    static /* synthetic */ Object access$800(CompactHashMap r0, int r1) {
        return r0.value(r1);
    }

    static /* synthetic */ int access$900(CompactHashMap r0) {
        return r0.hashTableMask();
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int r1) {
        return new CompactHashMap(r1);
    }

    static {
        NOT_FOUND = new Object();
    }

    CompactHashMap() {
        init(3);
    }

    CompactHashMap(int r1) {
        init(r1);
    }

    void init(int r4) {
        if (r4 < 0) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "Expected size must be >= 0");
        this.metadata = Ints.constrainToRange(r4, 1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
        return;
    L5:
        r1 = false;
        goto L6
    }

    boolean needsAllocArrays() {
        if (this.table != null) goto L5;
        return true;
    L5:
        return false;
    }

    int allocArrays() {
        Preconditions.checkState(needsAllocArrays(), "Arrays already allocated");
        int r0 = this.metadata;
        int r1 = CompactHashing.tableSize(r0);
        this.table = CompactHashing.createTable(r1);
        setHashTableMask(r1 - 1);
        this.entries = new int[r0];
        this.keys = new Object[r0];
        this.values = new Object[r0];
        return r0;
    }

    @CheckForNull
    Map<K, V> delegateOrNull() {
        Object r1 = this.table;
        if ((r1 instanceof Map) == true) goto L5;
        return null;
    L5:
        return (Map) r1;
    }

    Map<K, V> createHashFloodingResistantDelegate(int r2) {
        return new LinkedHashMap(r2, 1.0f);
    }

    Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> r0 = createHashFloodingResistantDelegate(hashTableMask() + 1);
        int r1 = firstEntryIndex();
    L3:
        if (r1 < 0) goto L5;
        r0.put(key(r1), value(r1));
        r1 = getSuccessor(r1);
        goto L3
    L5:
        this.table = r0;
        this.entries = null;
        this.keys = null;
        this.values = null;
        incrementModCount();
        return r0;
    }

    private void setHashTableMask(int r3) {
        int r4 = 32 - Integer.numberOfLeadingZeros(r3);
        this.metadata = CompactHashing.maskCombine(this.metadata, r4, 31);
    }

    private int hashTableMask() {
        return (1 << (this.metadata & 31)) - 1;
    }

    void incrementModCount() {
        this.metadata += 32;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V put(@ParametricNullness K r13, @ParametricNullness V r14) {
        if (needsAllocArrays() == false) goto L5;
        allocArrays();
    L5:
        Map<K, V> r0 = delegateOrNull();
        if (r0 != null) goto L8;
        int[] r1 = requireEntries();
        Object[] r2 = requireKeys();
        Object[] r3 = requireValues();
        int r4 = this.size;
        int r9 = r4 + 1;
        int r7 = Hashing.smearedHash(r13);
        int r5 = hashTableMask();
        int r6 = r7 & r5;
        int r8 = CompactHashing.tableGet(requireTable(), r6);
        if (r8 != 0) goto L15;
        if (r9 <= r5) goto L14;
        int r10 = resizeTable(r5, CompactHashing.newCapacity(r5), r7, r4);
    L13:
        int r11 = r10;
    L32:
        resizeMeMaybe(r9);
        insertEntry(r4, r13, r14, r7, r11);
        this.size = r9;
        incrementModCount();
        return null;
    L14:
        CompactHashing.tableSet(requireTable(), r6, r9);
    L31:
        r11 = r5;
        goto L32
    L15:
        int r12 = CompactHashing.getHashPrefix(r7, r5);
        int r15 = 0;
    L16:
        int r16 = r8 - 1;
        int r17 = r1[r16];
        if (CompactHashing.getHashPrefix(r17, r5) == r12) goto L19;
    L22:
        int r18 = CompactHashing.getNext(r17, r5);
        r15 = r15 + 1;
        if (r18 == 0) goto L25;
        r8 = r18;
        goto L16
    L25:
        if (r15 >= 9) goto L27;
        if (r9 <= r5) goto L30;
        r10 = resizeTable(r5, CompactHashing.newCapacity(r5), r7, r4);
        goto L13
    L30:
        r1[r16] = CompactHashing.maskCombine(r17, r9, r5);
        goto L31
    L27:
        return convertToHashFloodingResistantImplementation().put(r13, r14);
    L19:
        if (Objects.equal(r13, r2[r16]) == false) goto L22;
        V r19 = (V) r3[r16];
        r3[r16] = r14;
        accessEntry(r16);
        return r19;
    L8:
        return r0.put(r13, r14);
    }

    void insertEntry(int r2, @ParametricNullness K r3, @ParametricNullness V r4, int r5, int r6) {
        setEntry(r2, CompactHashing.maskCombine(r5, 0, r6));
        setKey(r2, r3);
        setValue(r2, r4);
    }

    private void resizeMeMaybe(int r3) {
        int r0 = requireEntries().length;
        if (r3 <= r0) goto L8;
        int r4 = Math.min(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, (Math.max(1, r0 >>> 1) + r0) | 1);
        if (r4 == r0) goto L9;
        resizeEntries(r4);
        return;
    L9:
        return;
    }

    void resizeEntries(int r2) {
        this.entries = Arrays.copyOf(requireEntries(), r2);
        this.keys = Arrays.copyOf(requireKeys(), r2);
        this.values = Arrays.copyOf(requireValues(), r2);
    }

    private int resizeTable(int r9, int r10, int r11, int r12) {
        Object r0 = CompactHashing.createTable(r10);
        int r13 = r10 - 1;
        if (r12 == 0) goto L5;
        CompactHashing.tableSet(r0, r11 & r13, r12 + 1);
    L5:
        Object r14 = requireTable();
        int[] r15 = requireEntries();
        int r1 = 0;
    L6:
        if (r1 > r9) goto L11;
        int r2 = CompactHashing.tableGet(r14, r1);
    L8:
        if (r2 == 0) goto L10;
        int r3 = r2 - 1;
        int r4 = r15[r3];
        int r5 = CompactHashing.getHashPrefix(r4, r9) | r1;
        int r6 = r5 & r13;
        int r7 = CompactHashing.tableGet(r0, r6);
        CompactHashing.tableSet(r0, r6, r2);
        r15[r3] = CompactHashing.maskCombine(r5, r7, r13);
        r2 = CompactHashing.getNext(r4, r9);
        goto L8
    L10:
        r1 = r1 + 1;
        goto L6
    L11:
        this.table = r0;
        setHashTableMask(r13);
        return r13;
    }

    private int indexOf(@CheckForNull Object r7) {
        if (needsAllocArrays() == false) goto L5;
        return -1;
    L5:
        int r0 = Hashing.smearedHash(r7);
        int r2 = hashTableMask();
        int r3 = CompactHashing.tableGet(requireTable(), r0 & r2);
        if (r3 != 0) goto L8;
        return -1;
    L8:
        int r1 = CompactHashing.getHashPrefix(r0, r2);
    L9:
        int r4 = r3 - 1;
        int r5 = entry(r4);
        if (CompactHashing.getHashPrefix(r5, r2) == r1) goto L12;
    L14:
        r3 = CompactHashing.getNext(r5, r2);
        if (r3 != 0) goto L9;
        return -1;
    L12:
        if (Objects.equal(r7, key(r4)) == false) goto L14;
        return r4;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@CheckForNull Object r2) {
        Map<K, V> r0 = delegateOrNull();
        if (r0 == null) goto L6;
        return r0.containsKey(r2);
    L6:
        if (indexOf(r2) == (-1)) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object r2) {
        Map<K, V> r0 = delegateOrNull();
        if (r0 != null) goto L5;
        int r3 = indexOf(r2);
        if (r3 != (-1)) goto L10;
        return null;
    L10:
        accessEntry(r3);
        return value(r3);
    L5:
        return r0.get(r2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V remove(@CheckForNull Object r2) {
        Map<K, V> r0 = delegateOrNull();
        if (r0 != null) goto L5;
        V r1 = (V) removeHelper(r2);
        if (r1 != NOT_FOUND) goto L10;
        return null;
    L10:
        return r1;
    L5:
        return r0.remove(r2);
    }

    private Object removeHelper(@CheckForNull Object r9) {
        if (needsAllocArrays() == true) goto L5;
        int r7 = hashTableMask();
        int r10 = CompactHashing.remove(r9, null, r7, requireTable(), requireEntries(), requireKeys(), null);
        if (r10 == (-1)) goto L9;
        V r0 = value(r10);
        moveLastEntry(r10, r7);
        this.size--;
        incrementModCount();
        return r0;
    L9:
        return NOT_FOUND;
    L5:
        return NOT_FOUND;
    }

    void moveLastEntry(int r9, int r10) {
        Object r0 = requireTable();
        int[] r1 = requireEntries();
        Object[] r2 = requireKeys();
        Object[] r3 = requireValues();
        int r8 = size() - 1;
        if (r9 >= r8) goto L11;
        Object r6 = r2[r8];
        r2[r9] = r6;
        r3[r9] = r3[r8];
        r2[r8] = null;
        r3[r8] = null;
        r1[r9] = r1[r8];
        r1[r8] = 0;
        int r4 = Hashing.smearedHash(r6) & r10;
        int r5 = CompactHashing.tableGet(r0, r4);
        int r11 = r8 + 1;
        if (r5 != r11) goto L7;
        CompactHashing.tableSet(r0, r4, r9 + 1);
        return;
    L7:
        int r7 = r5 - 1;
        int r12 = r1[r7];
        int r13 = CompactHashing.getNext(r12, r10);
        if (r13 == r11) goto L9;
        r5 = r13;
        goto L7
    L9:
        r1[r7] = CompactHashing.maskCombine(r12, r9 + 1, r10);
        return;
    L11:
        r2[r9] = null;
        r3[r9] = null;
        r1[r9] = 0;
    }

    int firstEntryIndex() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        return 0;
    }

    int getSuccessor(int r1) {
        int r2 = r1 + 1;
        if (r2 < this.size) goto L7;
        return -1;
    L7:
        return r2;
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> r4) {
        Preconditions.checkNotNull(r4);
        Map<K, V> r0 = delegateOrNull();
        if (r0 == null) goto L5;
        r0.replaceAll(r4);
        return;
    L5:
        int r1 = 0;
    L7:
        if (r1 >= this.size) goto L11;
        setValue(r1, r4.apply(key(r1), value(r1)));
        r1 = r1 + 1;
        goto L7
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> r0 = this.keySetView;
        if (r0 != null) goto L6;
        Set<K> r1 = createKeySet();
        this.keySetView = r1;
        return r1;
    L6:
        return r0;
    }

    Set<K> createKeySet() {
        return new KeySetView(this);
    }

    Iterator<K> keySetIterator() {
        Map<K, V> r0 = delegateOrNull();
        if (r0 == null) goto L7;
        return r0.keySet().iterator();
    L7:
        return new AnonymousClass1(this);
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> r4) {
        Preconditions.checkNotNull(r4);
        Map<K, V> r0 = delegateOrNull();
        if (r0 == null) goto L5;
        r0.forEach(r4);
        return;
    L5:
        int r1 = firstEntryIndex();
    L6:
        if (r1 < 0) goto L10;
        r4.accept(key(r1), value(r1));
        r1 = getSuccessor(r1);
        goto L6
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> r0 = this.entrySetView;
        if (r0 != null) goto L6;
        Set<Map.Entry<K, V>> r1 = createEntrySet();
        this.entrySetView = r1;
        return r1;
    L6:
        return r0;
    }

    Set<Map.Entry<K, V>> createEntrySet() {
        return new EntrySetView(this);
    }

    Iterator<Map.Entry<K, V>> entrySetIterator() {
        Map<K, V> r0 = delegateOrNull();
        if (r0 == null) goto L7;
        return r0.entrySet().iterator();
    L7:
        return new AnonymousClass2(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map<K, V> r0 = delegateOrNull();
        if (r0 == null) goto L6;
        return r0.size();
    L6:
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@CheckForNull Object r4) {
        Map<K, V> r0 = delegateOrNull();
        if (r0 != null) goto L5;
        int r1 = 0;
    L8:
        if (r1 >= this.size) goto L14;
        if (Objects.equal(r4, value(r1)) == true) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        return true;
    L14:
        return false;
    L5:
        return r0.containsValue(r4);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> r0 = this.valuesView;
        if (r0 != null) goto L6;
        Collection<V> r1 = createValues();
        this.valuesView = r1;
        return r1;
    L6:
        return r0;
    }

    Collection<V> createValues() {
        return new ValuesView(this);
    }

    Iterator<V> valuesIterator() {
        Map<K, V> r0 = delegateOrNull();
        if (r0 == null) goto L7;
        return r0.values().iterator();
    L7:
        return new AnonymousClass3(this);
    }

    public void trimToSize() {
        if (needsAllocArrays() == false) goto L5;
        return;
    L5:
        Map<K, V> r0 = delegateOrNull();
        if (r0 == null) goto L9;
        Map<K, V> r1 = createHashFloodingResistantDelegate(size());
        r1.putAll(r0);
        this.table = r1;
        return;
    L9:
        int r2 = this.size;
        if (r2 >= requireEntries().length) goto L12;
        resizeEntries(r2);
    L12:
        int r3 = CompactHashing.tableSize(r2);
        int r4 = hashTableMask();
        if (r3 >= r4) goto L16;
        resizeTable(r4, r3, 0, 0);
        return;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays() == false) goto L5;
        return;
    L5:
        incrementModCount();
        Map<K, V> r0 = delegateOrNull();
        if (r0 == null) goto L8;
        this.metadata = Ints.constrainToRange(size(), 3, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
        r0.clear();
        this.table = null;
        this.size = 0;
        return;
    L8:
        Arrays.fill(requireKeys(), 0, this.size, null);
        Arrays.fill(requireValues(), 0, this.size, null);
        CompactHashing.tableClear(requireTable());
        Arrays.fill(requireEntries(), 0, this.size, 0);
        this.size = 0;
    }

    private void writeObject(ObjectOutputStream r3) throws IOException {
        r3.defaultWriteObject();
        r3.writeInt(size());
        Iterator<Map.Entry<K, V>> r2 = entrySetIterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Map.Entry<K, V> r0 = r2.next();
        r3.writeObject(r0.getKey());
        r3.writeObject(r0.getValue());
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
        r5.defaultReadObject();
        int r0 = r5.readInt();
        if (r0 < 0) goto L9;
        init(r0);
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        put(r5.readObject(), r5.readObject());
        r1 = r1 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new InvalidObjectException(new StringBuilder(25).append("Invalid size: ").append(r0).toString());
    }

    private Object requireTable() {
        return java.util.Objects.requireNonNull(this.table);
    }

    private int[] requireEntries() {
        return (int[]) java.util.Objects.requireNonNull(this.entries);
    }

    private Object[] requireKeys() {
        return (Object[]) java.util.Objects.requireNonNull(this.keys);
    }

    private Object[] requireValues() {
        return (Object[]) java.util.Objects.requireNonNull(this.values);
    }

    private K key(int r1) {
        return (K) requireKeys()[r1];
    }

    private V value(int r1) {
        return (V) requireValues()[r1];
    }

    private int entry(int r1) {
        return requireEntries()[r1];
    }

    private void setKey(int r1, K r2) {
        requireKeys()[r1] = r2;
    }

    private void setValue(int r1, V r2) {
        requireValues()[r1] = r2;
    }

    private void setEntry(int r1, int r2) {
        requireEntries()[r1] = r2;
    }
}
