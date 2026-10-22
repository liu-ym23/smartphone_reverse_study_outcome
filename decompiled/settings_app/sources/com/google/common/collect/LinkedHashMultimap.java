package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class LinkedHashMultimap<K, V> extends LinkedHashMultimapGwtSerializationDependencies<K, V> {
    private static final int DEFAULT_KEY_CAPACITY = 16;
    private static final int DEFAULT_VALUE_SET_CAPACITY = 2;
    static final double VALUE_SET_LOAD_FACTOR = 1.0d;
    private static final long serialVersionUID = 1;
    private transient ValueEntry<K, V> multimapHeaderEntry;
    transient int valueSetCapacity;

    static final class ValueEntry<K, V> extends ImmutableEntry<K, V> implements ValueSetLink<K, V> {

        @CheckForNull
        ValueEntry<K, V> nextInValueBucket;

        @CheckForNull
        ValueEntry<K, V> predecessorInMultimap;

        @CheckForNull
        ValueSetLink<K, V> predecessorInValueSet;
        final int smearedValueHash;

        @CheckForNull
        ValueEntry<K, V> successorInMultimap;

        @CheckForNull
        ValueSetLink<K, V> successorInValueSet;

        ValueEntry(@ParametricNullness K r1, @ParametricNullness V r2, int r3, @CheckForNull ValueEntry<K, V> r4) {
            super(r1, r2);
            this.smearedValueHash = r3;
            this.nextInValueBucket = r4;
        }

        static <K, V> ValueEntry<K, V> newHeader() {
            return new ValueEntry(null, null, 0, null);
        }

        boolean matchesValue(@CheckForNull Object r2, int r3) {
            if (this.smearedValueHash == r3) goto L5;
        L7:
            return false;
        L5:
            if (Objects.equal(getValue(), r2) == false) goto L7;
            return true;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public ValueSetLink<K, V> getPredecessorInValueSet() {
            return (ValueSetLink) java.util.Objects.requireNonNull(this.predecessorInValueSet);
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public ValueSetLink<K, V> getSuccessorInValueSet() {
            return (ValueSetLink) java.util.Objects.requireNonNull(this.successorInValueSet);
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public void setPredecessorInValueSet(ValueSetLink<K, V> r1) {
            this.predecessorInValueSet = r1;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public void setSuccessorInValueSet(ValueSetLink<K, V> r1) {
            this.successorInValueSet = r1;
        }

        public ValueEntry<K, V> getPredecessorInMultimap() {
            return (ValueEntry) java.util.Objects.requireNonNull(this.predecessorInMultimap);
        }

        public ValueEntry<K, V> getSuccessorInMultimap() {
            return (ValueEntry) java.util.Objects.requireNonNull(this.successorInMultimap);
        }

        public void setSuccessorInMultimap(ValueEntry<K, V> r1) {
            this.successorInMultimap = r1;
        }

        public void setPredecessorInMultimap(ValueEntry<K, V> r1) {
            this.predecessorInMultimap = r1;
        }
    }

    final class ValueSet extends Sets.ImprovedAbstractSet<V> implements ValueSetLink<K, V> {
        private ValueSetLink<K, V> firstEntry;
        ValueEntry<K, V>[] hashTable;

        @ParametricNullness
        private final K key;
        private ValueSetLink<K, V> lastEntry;
        private int modCount;
        private int size;
        final /* synthetic */ LinkedHashMultimap this$0;

        static /* synthetic */ ValueSetLink access$000(ValueSet r0) {
            return r0.firstEntry;
        }

        static /* synthetic */ int access$100(ValueSet r0) {
            return r0.modCount;
        }

        ValueSet(@ParametricNullness LinkedHashMultimap r1, K r2, int r3) {
            this.this$0 = r1;
            this.size = 0;
            this.modCount = 0;
            this.key = r2;
            this.firstEntry = this;
            this.lastEntry = this;
            this.hashTable = new ValueEntry[Hashing.closedTableSize(r3, LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)];
        }

        private int mask() {
            return this.hashTable.length - 1;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public ValueSetLink<K, V> getPredecessorInValueSet() {
            return this.lastEntry;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public ValueSetLink<K, V> getSuccessorInValueSet() {
            return this.firstEntry;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public void setPredecessorInValueSet(ValueSetLink<K, V> r1) {
            this.lastEntry = r1;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public void setSuccessorInValueSet(ValueSetLink<K, V> r1) {
            this.firstEntry = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new AnonymousClass1(this);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super V> r3) {
            Preconditions.checkNotNull(r3);
            ValueSetLink<K, V> r0 = this.firstEntry;
        L3:
            if (r0 == this) goto L5;
            r3.accept(((ValueEntry) r0).getValue());
            r0 = r0.getSuccessorInValueSet();
            goto L3
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r3) {
            int r0 = Hashing.smearedHash(r3);
            ValueEntry<K, V> r2 = this.hashTable[mask() & r0];
        L3:
            if (r2 == null) goto L9;
            if (r2.matchesValue(r3, r0) == true) goto L6;
            r2 = r2.nextInValueBucket;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(@ParametricNullness V r6) {
            int r0 = Hashing.smearedHash(r6);
            int r1 = mask() & r0;
            ValueEntry<K, V> r2 = this.hashTable[r1];
            ValueEntry<K, V> r3 = r2;
        L3:
            if (r3 == null) goto L9;
            if (r3.matchesValue(r6, r0) == true) goto L6;
            r3 = r3.nextInValueBucket;
            goto L3
        L6:
            return false;
        L9:
            ValueEntry<K, V> r4 = new ValueEntry(this.key, r6, r0, r2);
            LinkedHashMultimap.access$200(this.lastEntry, r4);
            LinkedHashMultimap.access$200(r4, this);
            LinkedHashMultimap.access$400(LinkedHashMultimap.access$300(this.this$0).getPredecessorInMultimap(), r4);
            LinkedHashMultimap.access$400(r4, LinkedHashMultimap.access$300(this.this$0));
            this.hashTable[r1] = r4;
            this.size++;
            this.modCount++;
            rehashIfNecessary();
            return true;
        }

        private void rehashIfNecessary() {
            if (Hashing.needsResizing(this.size, this.hashTable.length, LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) == false) goto L7;
            int r0 = this.hashTable.length * 2;
            ValueEntry<K, V>[] r1 = new ValueEntry[r0];
            this.hashTable = r1;
            int r2 = r0 - 1;
            ValueSetLink<K, V> r3 = this.firstEntry;
        L5:
            if (r3 == this) goto L9;
            ValueEntry<K, V> r4 = (ValueEntry) r3;
            int r5 = r4.smearedValueHash & r2;
            r4.nextInValueBucket = r1[r5];
            r1[r5] = r4;
            r3 = r3.getSuccessorInValueSet();
            goto L5
        L9:
            return;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object r7) {
            int r0 = Hashing.smearedHash(r7);
            int r1 = mask() & r0;
            ValueEntry<K, V> r2 = this.hashTable[r1];
            ValueEntry<K, V> r3 = null;
        L3:
            if (r2 == null) goto L12;
            if (r2.matchesValue(r7, r0) == true) goto L6;
            r3 = r2;
            r2 = r2.nextInValueBucket;
            goto L3
        L6:
            if (r3 != null) goto L8;
            this.hashTable[r1] = r2.nextInValueBucket;
        L9:
            LinkedHashMultimap.access$500(r2);
            LinkedHashMultimap.access$600(r2);
            this.size--;
            this.modCount++;
            return true;
        L8:
            r3.nextInValueBucket = r2.nextInValueBucket;
            goto L9
        L12:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Arrays.fill(this.hashTable, null);
            this.size = 0;
            ValueSetLink<K, V> r0 = this.firstEntry;
        L3:
            if (r0 == this) goto L5;
            LinkedHashMultimap.access$600((ValueEntry) r0);
            r0 = r0.getSuccessorInValueSet();
            goto L3
        L5:
            LinkedHashMultimap.access$200(this, this);
            this.modCount++;
        }
    }

    private interface ValueSetLink<K, V> {
        ValueSetLink<K, V> getPredecessorInValueSet();

        ValueSetLink<K, V> getSuccessorInValueSet();

        void setPredecessorInValueSet(ValueSetLink<K, V> r1);

        void setSuccessorInValueSet(ValueSetLink<K, V> r1);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(@CheckForNull Object r1, @CheckForNull Object r2) {
        return super.containsEntry(r1, r2);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsKey(@CheckForNull Object r1) {
        return super.containsKey(r1);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsValue(@CheckForNull Object r1) {
        return super.containsValue(r1);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    /* bridge */ /* synthetic */ Collection createCollection() {
        return createCollection();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection entries() {
        return entries();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object r1) {
        return super.equals(r1);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ void forEach(BiConsumer r1) {
        super.forEach(r1);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Set get(@ParametricNullness Object r1) {
        return super.get(r1);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean put(@ParametricNullness Object r1, @ParametricNullness Object r2) {
        return super.put(r1, r2);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean putAll(Multimap r1) {
        return super.putAll(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean putAll(@ParametricNullness Object r1, Iterable r2) {
        return super.putAll(r1, r2);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean remove(@CheckForNull Object r1, @CheckForNull Object r2) {
        return super.remove(r1, r2);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Set removeAll(@CheckForNull Object r1) {
        return super.removeAll(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Collection replaceValues(@ParametricNullness Object r1, Iterable r2) {
        return replaceValues(r1, r2);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    static /* synthetic */ void access$200(ValueSetLink r0, ValueSetLink r1) {
        succeedsInValueSet(r0, r1);
    }

    static /* synthetic */ ValueEntry access$300(LinkedHashMultimap r0) {
        return r0.multimapHeaderEntry;
    }

    static /* synthetic */ void access$400(ValueEntry r0, ValueEntry r1) {
        succeedsInMultimap(r0, r1);
    }

    static /* synthetic */ void access$500(ValueSetLink r0) {
        deleteFromValueSet(r0);
    }

    static /* synthetic */ void access$600(ValueEntry r0) {
        deleteFromMultimap(r0);
    }

    public static <K, V> LinkedHashMultimap<K, V> create() {
        return new LinkedHashMultimap(16, 2);
    }

    public static <K, V> LinkedHashMultimap<K, V> create(int r1, int r2) {
        return new LinkedHashMultimap(Maps.capacity(r1), Maps.capacity(r2));
    }

    public static <K, V> LinkedHashMultimap<K, V> create(Multimap<? extends K, ? extends V> r2) {
        LinkedHashMultimap<K, V> r0 = create(r2.keySet().size(), 2);
        r0.putAll(r2);
        return r0;
    }

    private static <K, V> void succeedsInValueSet(ValueSetLink<K, V> r0, ValueSetLink<K, V> r1) {
        r0.setSuccessorInValueSet(r1);
        r1.setPredecessorInValueSet(r0);
    }

    private static <K, V> void succeedsInMultimap(ValueEntry<K, V> r0, ValueEntry<K, V> r1) {
        r0.setSuccessorInMultimap(r1);
        r1.setPredecessorInMultimap(r0);
    }

    private static <K, V> void deleteFromValueSet(ValueSetLink<K, V> r1) {
        succeedsInValueSet(r1.getPredecessorInValueSet(), r1.getSuccessorInValueSet());
    }

    private static <K, V> void deleteFromMultimap(ValueEntry<K, V> r1) {
        succeedsInMultimap(r1.getPredecessorInMultimap(), r1.getSuccessorInMultimap());
    }

    private LinkedHashMultimap(int r1, int r2) {
        super(Platform.newLinkedHashMapWithExpectedSize(r1));
        this.valueSetCapacity = 2;
        CollectPreconditions.checkNonnegative(r2, "expectedValuesPerKey");
        this.valueSetCapacity = r2;
        ValueEntry<K, V> r3 = ValueEntry.newHeader();
        this.multimapHeaderEntry = r3;
        succeedsInMultimap(r3, r3);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    Set<V> createCollection() {
        return Platform.newLinkedHashSetWithExpectedSize(this.valueSetCapacity);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    Collection<V> createCollection(@ParametricNullness K r3) {
        return new ValueSet(this, r3, this.valueSetCapacity);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Set<V> replaceValues(@ParametricNullness K r1, Iterable<? extends V> r2) {
        return super.replaceValues(r1, r2);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Set<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Set<K> keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Collection<V> values() {
        return super.values();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
    Iterator<Map.Entry<K, V>> entryIterator() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
    Spliterator<Map.Entry<K, V>> entrySpliterator() {
        return Spliterators.spliterator(entries(), 17);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
    Iterator<V> valueIterator() {
        return Maps.valueIterator(entryIterator());
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
    Spliterator<V> valueSpliterator() {
        return CollectSpliterators.map(entrySpliterator(), new ImmutableMapValues$$ExternalSyntheticLambda0());
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public void clear() {
        super.clear();
        ValueEntry<K, V> r0 = this.multimapHeaderEntry;
        succeedsInMultimap(r0, r0);
    }

    private void writeObject(ObjectOutputStream r3) throws IOException {
        r3.defaultWriteObject();
        r3.writeInt(keySet().size());
        Iterator<K> r0 = keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r3.writeObject(r0.next());
        goto L4
    L6:
        r3.writeInt(size());
        Iterator<Map.Entry<K, V>> r2 = entries().iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        Map.Entry<K, V> r1 = r2.next();
        r3.writeObject(r1.getKey());
        r3.writeObject(r1.getValue());
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream r7) throws IOException, ClassNotFoundException {
        r7.defaultReadObject();
        ValueEntry<K, V> r0 = ValueEntry.newHeader();
        this.multimapHeaderEntry = r0;
        succeedsInMultimap(r0, r0);
        this.valueSetCapacity = 2;
        int r1 = r7.readInt();
        Map r2 = Platform.newLinkedHashMapWithExpectedSize(12);
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L5;
        Object r5 = r7.readObject();
        r2.put(r5, createCollection(r5));
        r4 = r4 + 1;
        goto L3
    L5:
        int r6 = r7.readInt();
    L6:
        if (r3 >= r6) goto L8;
        Object r8 = r7.readObject();
        ((Collection) java.util.Objects.requireNonNull((Collection) r2.get(r8))).add(r7.readObject());
        r3 = r3 + 1;
        goto L6
    L8:
        setMap(r2);
    }
}
