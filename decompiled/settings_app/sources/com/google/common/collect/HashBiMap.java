package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class HashBiMap<K, V> extends Maps.IteratorBasedAbstractMap<K, V> implements BiMap<K, V>, Serializable {
    private static final double LOAD_FACTOR = 1.0d;
    private static final long serialVersionUID = 0;

    @CheckForNull
    private transient BiEntry<K, V> firstInKeyInsertionOrder;
    private transient BiEntry<K, V>[] hashTableKToV;
    private transient BiEntry<K, V>[] hashTableVToK;

    @CheckForNull
    @LazyInit
    private transient BiMap<V, K> inverse;

    @CheckForNull
    private transient BiEntry<K, V> lastInKeyInsertionOrder;
    private transient int mask;
    private transient int modCount;
    private transient int size;

    private static final class BiEntry<K, V> extends ImmutableEntry<K, V> {
        final int keyHash;

        @CheckForNull
        BiEntry<K, V> nextInKToVBucket;

        @CheckForNull
        BiEntry<K, V> nextInKeyInsertionOrder;

        @CheckForNull
        BiEntry<K, V> nextInVToKBucket;

        @CheckForNull
        BiEntry<K, V> prevInKeyInsertionOrder;
        final int valueHash;

        BiEntry(@ParametricNullness K r1, int r2, @ParametricNullness V r3, int r4) {
            super(r1, r3);
            this.keyHash = r2;
            this.valueHash = r4;
        }
    }

    private final class Inverse extends Maps.IteratorBasedAbstractMap<V, K> implements BiMap<V, K>, Serializable {
        final /* synthetic */ HashBiMap this$0;

        private final class InverseKeySet extends Maps.KeySet<V, K> {
            final /* synthetic */ Inverse this$1;

            InverseKeySet(Inverse r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object r3) {
                BiEntry r4 = HashBiMap.access$400(this.this$1.this$0, r3, Hashing.smearedHash(r3));
                if (r4 != null) goto L6;
                return false;
            L6:
                HashBiMap.access$200(this.this$1.this$0, r4);
                return true;
            }

            @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<V> iterator() {
                return new AnonymousClass1(this);
            }
        }

        private Inverse(HashBiMap r1) {
            this.this$0 = r1;
        }

        /* synthetic */ Inverse(HashBiMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        public /* bridge */ /* synthetic */ Collection values() {
            return values();
        }

        BiMap<K, V> forward() {
            return this.this$0;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return HashBiMap.access$700(this.this$0);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            forward().clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object r1) {
            return forward().containsValue(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public K get(@CheckForNull Object r2) {
            return (K) Maps.keyOrNull(HashBiMap.access$400(this.this$0, r2, Hashing.smearedHash(r2)));
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        @CheckForNull
        public K put(@ParametricNullness V r2, @ParametricNullness K r3) {
            return (K) HashBiMap.access$800(this.this$0, r2, r3, false);
        }

        @Override // com.google.common.collect.BiMap
        @CheckForNull
        public K forcePut(@ParametricNullness V r2, @ParametricNullness K r3) {
            return (K) HashBiMap.access$800(this.this$0, r2, r3, true);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public K remove(@CheckForNull Object r3) {
            BiEntry r4 = HashBiMap.access$400(this.this$0, r3, Hashing.smearedHash(r3));
            if (r4 != null) goto L5;
            return null;
        L5:
            HashBiMap.access$200(this.this$0, r4);
            r4.prevInKeyInsertionOrder = null;
            r4.nextInKeyInsertionOrder = null;
            return r4.key;
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<K, V> inverse() {
            return forward();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return new InverseKeySet(this);
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        public Set<K> values() {
            return forward().keySet();
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        Iterator<Map.Entry<V, K>> entryIterator() {
            return new AnonymousClass1(this);
        }

        @Override // java.util.Map
        public void forEach(final BiConsumer<? super V, ? super K> r2) {
            Preconditions.checkNotNull(r2);
            this.this$0.forEach(new HashBiMap$Inverse$$ExternalSyntheticLambda0(r2));
        }

        static /* synthetic */ void lambda$forEach$0(BiConsumer r0, Object r1, Object r2) {
            r0.accept(r2, r1);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super V, ? super K, ? extends K> r5) {
            Preconditions.checkNotNull(r5);
            BiEntry<K, V> r0 = HashBiMap.access$000(this.this$0);
            clear();
        L3:
            if (r0 == null) goto L5;
            put(r0.value, r5.apply(r0.value, r0.key));
            r0 = r0.nextInKeyInsertionOrder;
            goto L3
        }

        Object writeReplace() {
            return new InverseSerializedForm(this.this$0);
        }
    }

    private static final class InverseSerializedForm<K, V> implements Serializable {
        private final HashBiMap<K, V> bimap;

        InverseSerializedForm(HashBiMap<K, V> r1) {
            this.bimap = r1;
        }

        Object readResolve() {
            return this.bimap.inverse();
        }
    }

    abstract class Itr<T> implements Iterator<T> {
        int expectedModCount;

        @CheckForNull
        BiEntry<K, V> next;
        int remaining;
        final /* synthetic */ HashBiMap this$0;

        @CheckForNull
        BiEntry<K, V> toRemove;

        abstract T output(BiEntry<K, V> r1);

        Itr(HashBiMap r2) {
            this.this$0 = r2;
            this.next = HashBiMap.access$000(r2);
            this.toRemove = null;
            this.expectedModCount = HashBiMap.access$100(r2);
            this.remaining = r2.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (HashBiMap.access$100(this.this$0) != this.expectedModCount) goto L12;
            if (this.next != null) goto L7;
        L9:
            return false;
        L7:
            if (this.remaining <= 0) goto L9;
            return true;
        L12:
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext() == false) goto L7;
            BiEntry<K, V> r0 = (BiEntry) Objects.requireNonNull(this.next);
            this.next = r0.nextInKeyInsertionOrder;
            this.toRemove = r0;
            this.remaining--;
            return output(r0);
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (HashBiMap.access$100(this.this$0) != this.expectedModCount) goto L11;
            BiEntry<K, V> r0 = this.toRemove;
            if (r0 == null) goto L9;
            HashBiMap.access$200(this.this$0, r0);
            this.expectedModCount = HashBiMap.access$100(this.this$0);
            this.toRemove = null;
            return;
        L9:
            throw new IllegalStateException("no calls to next() since the last call to remove()");
        L11:
            throw new ConcurrentModificationException();
        }
    }

    private final class KeySet extends Maps.KeySet<K, V> {
        final /* synthetic */ HashBiMap this$0;

        KeySet(HashBiMap r1) {
            this.this$0 = r1;
            super(r1);
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new AnonymousClass1(this);
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object r3) {
            BiEntry r4 = HashBiMap.access$300(this.this$0, r3, Hashing.smearedHash(r3));
            if (r4 != null) goto L6;
            return false;
        L6:
            HashBiMap.access$200(this.this$0, r4);
            r4.prevInKeyInsertionOrder = null;
            r4.nextInKeyInsertionOrder = null;
            return true;
        }
    }

    @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    static /* synthetic */ BiEntry access$000(HashBiMap r0) {
        return r0.firstInKeyInsertionOrder;
    }

    static /* synthetic */ int access$100(HashBiMap r0) {
        return r0.modCount;
    }

    static /* synthetic */ void access$200(HashBiMap r0, BiEntry r1) {
        r0.delete(r1);
    }

    static /* synthetic */ BiEntry access$300(HashBiMap r0, Object r1, int r2) {
        return r0.seekByKey(r1, r2);
    }

    static /* synthetic */ BiEntry access$400(HashBiMap r0, Object r1, int r2) {
        return r0.seekByValue(r1, r2);
    }

    static /* synthetic */ void access$500(HashBiMap r0, BiEntry r1, BiEntry r2) {
        r0.insert(r1, r2);
    }

    static /* synthetic */ int access$700(HashBiMap r0) {
        return r0.size;
    }

    static /* synthetic */ Object access$800(HashBiMap r0, Object r1, Object r2, boolean r3) {
        return r0.putInverse(r1, r2, r3);
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    public static <K, V> HashBiMap<K, V> create(int r1) {
        return new HashBiMap(r1);
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> r1) {
        HashBiMap<K, V> r0 = create(r1.size());
        r0.putAll(r1);
        return r0;
    }

    private HashBiMap(int r1) {
        init(r1);
    }

    private void init(int r3) {
        CollectPreconditions.checkNonnegative(r3, "expectedSize");
        int r4 = Hashing.closedTableSize(r3, LOAD_FACTOR);
        this.hashTableKToV = createTable(r4);
        this.hashTableVToK = createTable(r4);
        this.firstInKeyInsertionOrder = null;
        this.lastInKeyInsertionOrder = null;
        this.size = 0;
        this.mask = r4 - 1;
        this.modCount = 0;
    }

    private void delete(BiEntry<K, V> r6) {
        int r0 = r6.keyHash & this.mask;
        BiEntry<K, V> r1 = this.hashTableKToV[r0];
        BiEntry<K, V> r2 = null;
        BiEntry<K, V> r3 = null;
    L3:
        if (r1 == r6) goto L4;
        r3 = r1;
        r1 = r1.nextInKToVBucket;
        goto L3
    L4:
        if (r3 != null) goto L6;
        this.hashTableKToV[r0] = r6.nextInKToVBucket;
    L7:
        int r4 = r6.valueHash & this.mask;
        BiEntry<K, V> r5 = this.hashTableVToK[r4];
    L8:
        BiEntry<K, V> r7 = r2;
        r2 = r5;
        if (r2 == r6) goto L10;
        r5 = r2.nextInVToKBucket;
        goto L8
    L10:
        if (r7 != null) goto L12;
        this.hashTableVToK[r4] = r6.nextInVToKBucket;
    L14:
        if (r6.prevInKeyInsertionOrder != null) goto L16;
        this.firstInKeyInsertionOrder = r6.nextInKeyInsertionOrder;
    L18:
        if (r6.nextInKeyInsertionOrder != null) goto L20;
        this.lastInKeyInsertionOrder = r6.prevInKeyInsertionOrder;
    L21:
        this.size--;
        this.modCount++;
        return;
    L20:
        r6.nextInKeyInsertionOrder.prevInKeyInsertionOrder = r6.prevInKeyInsertionOrder;
        goto L21
    L16:
        r6.prevInKeyInsertionOrder.nextInKeyInsertionOrder = r6.nextInKeyInsertionOrder;
        goto L18
    L12:
        r7.nextInVToKBucket = r6.nextInVToKBucket;
        goto L14
    L6:
        r3.nextInKToVBucket = r6.nextInKToVBucket;
        goto L7
    }

    private void insert(BiEntry<K, V> r3, @CheckForNull BiEntry<K, V> r4) {
        int r0 = r3.keyHash & this.mask;
        r3.nextInKToVBucket = this.hashTableKToV[r0];
        this.hashTableKToV[r0] = r3;
        int r1 = r3.valueHash & this.mask;
        r3.nextInVToKBucket = this.hashTableVToK[r1];
        this.hashTableVToK[r1] = r3;
        if (r4 != null) goto L9;
        r3.prevInKeyInsertionOrder = this.lastInKeyInsertionOrder;
        r3.nextInKeyInsertionOrder = null;
        BiEntry<K, V> r5 = this.lastInKeyInsertionOrder;
        if (r5 != null) goto L7;
        this.firstInKeyInsertionOrder = r3;
    L8:
        this.lastInKeyInsertionOrder = r3;
    L17:
        this.size++;
        this.modCount++;
        return;
    L7:
        r5.nextInKeyInsertionOrder = r3;
        goto L8
    L9:
        r3.prevInKeyInsertionOrder = r4.prevInKeyInsertionOrder;
        if (r3.prevInKeyInsertionOrder != null) goto L12;
        this.firstInKeyInsertionOrder = r3;
    L13:
        r3.nextInKeyInsertionOrder = r4.nextInKeyInsertionOrder;
        if (r3.nextInKeyInsertionOrder != null) goto L16;
        this.lastInKeyInsertionOrder = r3;
        goto L17
    L16:
        r3.nextInKeyInsertionOrder.prevInKeyInsertionOrder = r3;
        goto L17
    L12:
        r3.prevInKeyInsertionOrder.nextInKeyInsertionOrder = r3;
        goto L13
    }

    @CheckForNull
    private BiEntry<K, V> seekByKey(@CheckForNull Object r2, int r3) {
        BiEntry<K, V> r1 = this.hashTableKToV[this.mask & r3];
    L3:
        if (r1 == null) goto L10;
        if (r3 != r1.keyHash) goto L9;
        if (com.google.common.base.Objects.equal(r2, r1.key) == false) goto L9;
        return r1;
    L9:
        r1 = r1.nextInKToVBucket;
        goto L3
    L10:
        return null;
    }

    @CheckForNull
    private BiEntry<K, V> seekByValue(@CheckForNull Object r2, int r3) {
        BiEntry<K, V> r1 = this.hashTableVToK[this.mask & r3];
    L3:
        if (r1 == null) goto L10;
        if (r3 != r1.valueHash) goto L9;
        if (com.google.common.base.Objects.equal(r2, r1.value) == false) goto L9;
        return r1;
    L9:
        r1 = r1.nextInVToKBucket;
        goto L3
    L10:
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@CheckForNull Object r2) {
        if (seekByKey(r2, Hashing.smearedHash(r2)) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@CheckForNull Object r2) {
        if (seekByValue(r2, Hashing.smearedHash(r2)) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object r2) {
        return (V) Maps.valueOrNull(seekByKey(r2, Hashing.smearedHash(r2)));
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    @CheckForNull
    public V put(@ParametricNullness K r2, @ParametricNullness V r3) {
        return put(r2, r3, false);
    }

    @CheckForNull
    private V put(@ParametricNullness K r5, @ParametricNullness V r6, boolean r7) {
        int r0 = Hashing.smearedHash(r5);
        int r1 = Hashing.smearedHash(r6);
        BiEntry<K, V> r2 = seekByKey(r5, r0);
        if (r2 != null) goto L5;
    L9:
        BiEntry<K, V> r3 = seekByValue(r6, r1);
        if (r3 == null) goto L15;
        if (r7 == false) goto L13;
        delete(r3);
        goto L15
    L13:
        String r8 = String.valueOf(r6);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(r8).length() + 23).append("value already present: ").append(r8).toString());
    L15:
        BiEntry<K, V> r9 = new BiEntry(r5, r0, r6, r1);
        if (r2 == null) goto L19;
        delete(r2);
        insert(r9, r2);
        r2.prevInKeyInsertionOrder = null;
        r2.nextInKeyInsertionOrder = null;
        return r2.value;
    L19:
        insert(r9, null);
        rehashIfNecessary();
        return null;
    L5:
        if (r1 != r2.valueHash) goto L9;
        if (com.google.common.base.Objects.equal(r6, r2.value) == false) goto L9;
        return r6;
    }

    @Override // com.google.common.collect.BiMap
    @CheckForNull
    public V forcePut(@ParametricNullness K r2, @ParametricNullness V r3) {
        return put(r2, r3, true);
    }

    @CheckForNull
    private K putInverse(@ParametricNullness V r6, @ParametricNullness K r7, boolean r8) {
        int r0 = Hashing.smearedHash(r6);
        int r1 = Hashing.smearedHash(r7);
        BiEntry<K, V> r2 = seekByValue(r6, r0);
        BiEntry<K, V> r3 = seekByKey(r7, r1);
        if (r2 != null) goto L5;
    L9:
        if (r3 == null) goto L14;
        if (r8 == true) goto L14;
        String r9 = String.valueOf(r7);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(r9).length() + 21).append("key already present: ").append(r9).toString());
    L14:
        if (r2 == null) goto L16;
        delete(r2);
    L16:
        if (r3 == null) goto L18;
        delete(r3);
    L18:
        insert(new BiEntry(r7, r1, r6, r0), r3);
        if (r3 == null) goto L21;
        r3.prevInKeyInsertionOrder = null;
        r3.nextInKeyInsertionOrder = null;
    L21:
        if (r2 == null) goto L23;
        r2.prevInKeyInsertionOrder = null;
        r2.nextInKeyInsertionOrder = null;
    L23:
        rehashIfNecessary();
        return (K) Maps.keyOrNull(r2);
    L5:
        if (r1 != r2.keyHash) goto L9;
        if (com.google.common.base.Objects.equal(r7, r2.key) == false) goto L9;
        return r7;
    }

    private void rehashIfNecessary() {
        BiEntry<K, V>[] r0 = this.hashTableKToV;
        if (Hashing.needsResizing(this.size, r0.length, LOAD_FACTOR) == false) goto L10;
        int r1 = r0.length * 2;
        this.hashTableKToV = createTable(r1);
        this.hashTableVToK = createTable(r1);
        this.mask = r1 - 1;
        this.size = 0;
        BiEntry<K, V> r2 = this.firstInKeyInsertionOrder;
    L5:
        if (r2 == null) goto L7;
        insert(r2, r2);
        r2 = r2.nextInKeyInsertionOrder;
        goto L5
    L7:
        this.modCount++;
        return;
    }

    private BiEntry<K, V>[] createTable(int r1) {
        return new BiEntry[r1];
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V remove(@CheckForNull Object r2) {
        BiEntry<K, V> r3 = seekByKey(r2, Hashing.smearedHash(r2));
        if (r3 != null) goto L5;
        return null;
    L5:
        delete(r3);
        r3.prevInKeyInsertionOrder = null;
        r3.nextInKeyInsertionOrder = null;
        return r3.value;
    }

    @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        this.size = 0;
        Arrays.fill(this.hashTableKToV, null);
        Arrays.fill(this.hashTableVToK, null);
        this.firstInKeyInsertionOrder = null;
        this.lastInKeyInsertionOrder = null;
        this.modCount++;
    }

    @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        return new KeySet(this);
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    public Set<V> values() {
        return inverse().keySet();
    }

    @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
    Iterator<Map.Entry<K, V>> entryIterator() {
        return new AnonymousClass1(this);
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> r3) {
        Preconditions.checkNotNull(r3);
        BiEntry<K, V> r2 = this.firstInKeyInsertionOrder;
    L3:
        if (r2 == null) goto L5;
        r3.accept(r2.key, r2.value);
        r2 = r2.nextInKeyInsertionOrder;
        goto L3
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> r5) {
        Preconditions.checkNotNull(r5);
        BiEntry<K, V> r0 = this.firstInKeyInsertionOrder;
        clear();
    L3:
        if (r0 == null) goto L5;
        put(r0.key, r5.apply(r0.key, r0.value));
        r0 = r0.nextInKeyInsertionOrder;
        goto L3
    }

    @Override // com.google.common.collect.BiMap
    public BiMap<V, K> inverse() {
        BiMap<V, K> r0 = this.inverse;
        if (r0 != null) goto L6;
        Inverse r1 = new Inverse(this, null);
        this.inverse = r1;
        return r1;
    L6:
        return r0;
    }

    private void writeObject(ObjectOutputStream r1) throws IOException {
        r1.defaultWriteObject();
        Serialization.writeMap(this, r1);
    }

    private void readObject(ObjectInputStream r3) throws IOException, ClassNotFoundException {
        r3.defaultReadObject();
        int r0 = Serialization.readCount(r3);
        init(16);
        Serialization.populateMap(this, r3, r0);
    }
}
