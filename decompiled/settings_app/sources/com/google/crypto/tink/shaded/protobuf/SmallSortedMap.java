package com.google.crypto.tink.shaded.protobuf;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes4.dex */
class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private List<SmallSortedMap<K, V>.Entry> entryList;
    private boolean isImmutable;
    private volatile SmallSortedMap<K, V>.DescendingEntrySet lazyDescendingEntrySet;
    private volatile SmallSortedMap<K, V>.EntrySet lazyEntrySet;
    private final int maxArraySize;
    private Map<K, V> overflowEntries;
    private Map<K, V> overflowEntriesDescending;

    private class DescendingEntryIterator implements Iterator<Map.Entry<K, V>> {
        private Iterator<Map.Entry<K, V>> lazyOverflowIterator;
        private int pos;
        final /* synthetic */ SmallSortedMap this$0;

        private DescendingEntryIterator(final SmallSortedMap this$0) {
            this.this$0 = this$0;
            this.pos = SmallSortedMap.access$600(this$0).size();
        }

        /* synthetic */ DescendingEntryIterator(SmallSortedMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int r0 = this.pos;
            if (r0 <= 0) goto L7;
            if (r0 > SmallSortedMap.access$600(this.this$0).size()) goto L7;
        L8:
            return true;
        L7:
            if (getOverflowIterator().hasNext() == true) goto L8;
            return false;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (getOverflowIterator().hasNext() == true) goto L5;
            List r0 = SmallSortedMap.access$600(this.this$0);
            int r1 = this.pos - 1;
            this.pos = r1;
            return (Map.Entry) r0.get(r1);
        L5:
            return getOverflowIterator().next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private Iterator<Map.Entry<K, V>> getOverflowIterator() {
            if (this.lazyOverflowIterator != null) goto L6;
            this.lazyOverflowIterator = SmallSortedMap.access$900(this.this$0).entrySet().iterator();
        L6:
            return this.lazyOverflowIterator;
        }
    }

    private class DescendingEntrySet extends SmallSortedMap<K, V>.EntrySet {
        final /* synthetic */ SmallSortedMap this$0;

        private DescendingEntrySet(final SmallSortedMap this$0) {
            this.this$0 = this$0;
            super(this$0, null);
        }

        /* synthetic */ DescendingEntrySet(SmallSortedMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.SmallSortedMap.EntrySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new DescendingEntryIterator(this.this$0, null);
        }
    }

    private static class EmptySet {
        private static final Iterable<Object> ITERABLE = null;
        private static final Iterator<Object> ITERATOR = null;

        private EmptySet() {
        }

        static /* synthetic */ Iterator access$1000() {
            return ITERATOR;
        }

        static {
            ITERATOR = new AnonymousClass1();
            ITERABLE = new AnonymousClass2();
        }

        static <T> Iterable<T> iterable() {
            return (Iterable<T>) ITERABLE;
        }
    }

    private class Entry implements Map.Entry<K, V>, Comparable<SmallSortedMap<K, V>.Entry> {
        private final K key;
        final /* synthetic */ SmallSortedMap this$0;
        private V value;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object other) {
            return compareTo((Entry) other);
        }

        @Override // java.util.Map.Entry
        public /* bridge */ /* synthetic */ Object getKey() {
            return getKey();
        }

        Entry(final SmallSortedMap this$0, Map.Entry<K, V> copy) {
            this(this$0, copy.getKey(), copy.getValue());
        }

        Entry(final SmallSortedMap this$0, K key, V value) {
            this.this$0 = this$0;
            this.key = key;
            this.value = value;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        public int compareTo(SmallSortedMap<K, V>.Entry other) {
            return getKey().compareTo(other.getKey());
        }

        @Override // java.util.Map.Entry
        public V setValue(V newValue) {
            SmallSortedMap.access$300(this.this$0);
            V r0 = this.value;
            this.value = newValue;
            return r0;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object o) {
            if (o != this) goto L6;
            return true;
        L6:
            if ((o instanceof Map.Entry) == true) goto L8;
            return false;
        L8:
            Map.Entry r5 = (Map.Entry) o;
            if (equals(this.key, r5.getKey()) == false) goto L14;
            if (equals(this.value, r5.getValue()) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K r0 = this.key;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            V r3 = this.value;
            if (r3 == null) goto L11;
            r1 = r3.hashCode();
        L11:
            return r2 ^ r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return this.key + "=" + this.value;
        }

        private boolean equals(Object o1, Object o2) {
            if (o1 != null) goto L7;
            if (o2 != null) goto L5;
            return true;
        L5:
            return false;
        L7:
            return o1.equals(o2);
        }
    }

    private class EntryIterator implements Iterator<Map.Entry<K, V>> {
        private Iterator<Map.Entry<K, V>> lazyOverflowIterator;
        private boolean nextCalledBeforeRemove;
        private int pos;
        final /* synthetic */ SmallSortedMap this$0;

        private EntryIterator(final SmallSortedMap this$0) {
            this.this$0 = this$0;
            this.pos = -1;
        }

        /* synthetic */ EntryIterator(SmallSortedMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if ((this.pos + 1) >= SmallSortedMap.access$600(this.this$0).size()) goto L5;
            return true;
        L5:
            if (SmallSortedMap.access$700(this.this$0).isEmpty() == false) goto L7;
        L9:
            return false;
        L7:
            if (getOverflowIterator().hasNext() == false) goto L9;
            return true;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            this.nextCalledBeforeRemove = true;
            int r1 = this.pos + 1;
            this.pos = r1;
            if (r1 >= SmallSortedMap.access$600(this.this$0).size()) goto L7;
            return (Map.Entry) SmallSortedMap.access$600(this.this$0).get(this.pos);
        L7:
            return getOverflowIterator().next();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.nextCalledBeforeRemove == false) goto L10;
            this.nextCalledBeforeRemove = false;
            SmallSortedMap.access$300(this.this$0);
            if (this.pos >= SmallSortedMap.access$600(this.this$0).size()) goto L7;
            SmallSortedMap r0 = this.this$0;
            int r1 = this.pos;
            this.pos = r1 - 1;
            SmallSortedMap.access$800(r0, r1);
            return;
        L7:
            getOverflowIterator().remove();
            return;
        L10:
            throw new IllegalStateException("remove() was called before next()");
        }

        private Iterator<Map.Entry<K, V>> getOverflowIterator() {
            if (this.lazyOverflowIterator != null) goto L6;
            this.lazyOverflowIterator = SmallSortedMap.access$700(this.this$0).entrySet().iterator();
        L6:
            return this.lazyOverflowIterator;
        }
    }

    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        final /* synthetic */ SmallSortedMap this$0;

        private EntrySet(final SmallSortedMap this$0) {
            this.this$0 = this$0;
        }

        /* synthetic */ EntrySet(SmallSortedMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public /* bridge */ /* synthetic */ boolean add(Object entry) {
            return add((Map.Entry) entry);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(this.this$0, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            Map.Entry r2 = (Map.Entry) o;
            Object r1 = this.this$0.get(r2.getKey());
            Object r3 = r2.getValue();
            if (r1 == r3) goto L9;
            if (r1 != null) goto L6;
        L8:
            return false;
        L6:
            if (r1.equals(r3) == false) goto L8;
        L9:
            return true;
        }

        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry) == true) goto L6;
            this.this$0.put(entry.getKey(), entry.getValue());
            return true;
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            Map.Entry r2 = (Map.Entry) o;
            if (contains(r2) == false) goto L6;
            this.this$0.remove(r2.getKey());
            return true;
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }
    }

    /* synthetic */ SmallSortedMap(int r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ void access$300(SmallSortedMap r0) {
        r0.checkMutable();
    }

    static /* synthetic */ List access$600(SmallSortedMap r0) {
        return r0.entryList;
    }

    static /* synthetic */ Map access$700(SmallSortedMap r0) {
        return r0.overflowEntries;
    }

    static /* synthetic */ Object access$800(SmallSortedMap r0, int r1) {
        return r0.removeArrayEntryAt(r1);
    }

    static /* synthetic */ Map access$900(SmallSortedMap r0) {
        return r0.overflowEntriesDescending;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object key, Object value) {
        return put((Comparable) key, value);
    }

    static <FieldDescriptorType extends FieldSet.FieldDescriptorLite<FieldDescriptorType>> SmallSortedMap<FieldDescriptorType, Object> newFieldMap(final int r1) {
        return (SmallSortedMap<FieldDescriptorType, Object>) new AnonymousClass1(r1);
    }

    static <K extends Comparable<K>, V> SmallSortedMap<K, V> newInstanceForTest(int arraySize) {
        return new SmallSortedMap(arraySize);
    }

    private SmallSortedMap(int arraySize) {
        this.maxArraySize = arraySize;
        this.entryList = Collections.emptyList();
        this.overflowEntries = Collections.emptyMap();
        this.overflowEntriesDescending = Collections.emptyMap();
    }

    public void makeImmutable() {
        if (this.isImmutable == false) goto L5;
        return;
    L5:
        if (this.overflowEntries.isEmpty() == false) goto L7;
        Map<K, V> r0 = Collections.emptyMap();
    L8:
        this.overflowEntries = r0;
        if (this.overflowEntriesDescending.isEmpty() == false) goto L11;
        Map<K, V> r1 = Collections.emptyMap();
    L12:
        this.overflowEntriesDescending = r1;
        this.isImmutable = true;
        return;
    L11:
        r1 = Collections.unmodifiableMap(this.overflowEntriesDescending);
        goto L12
    L7:
        r0 = Collections.unmodifiableMap(this.overflowEntries);
        goto L8
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public int getNumArrayEntries() {
        return this.entryList.size();
    }

    public Map.Entry<K, V> getArrayEntryAt(int index) {
        return this.entryList.get(index);
    }

    public int getNumOverflowEntries() {
        return this.overflowEntries.size();
    }

    public Iterable<Map.Entry<K, V>> getOverflowEntries() {
        if (this.overflowEntries.isEmpty() == false) goto L6;
        return EmptySet.iterable();
    L6:
        return this.overflowEntries.entrySet();
    }

    Iterable<Map.Entry<K, V>> getOverflowEntriesDescending() {
        if (this.overflowEntriesDescending.isEmpty() == false) goto L6;
        return EmptySet.iterable();
    L6:
        return this.overflowEntriesDescending.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.entryList.size() + this.overflowEntries.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object o) {
        Comparable r2 = (Comparable) o;
        if (binarySearchInArray(r2) < 0) goto L5;
    L8:
        return true;
    L5:
        if (this.overflowEntries.containsKey(r2) == true) goto L8;
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object o) {
        Comparable r2 = (Comparable) o;
        int r0 = binarySearchInArray(r2);
        if (r0 < 0) goto L7;
        return this.entryList.get(r0).getValue();
    L7:
        return this.overflowEntries.get(r2);
    }

    public V put(K r5, V r6) {
        checkMutable();
        int r0 = binarySearchInArray(r5);
        if (r0 >= 0) goto L5;
        ensureEntryArrayMutable();
        int r1 = -(r0 + 1);
        if (r1 >= this.maxArraySize) goto L9;
        int r2 = this.entryList.size();
        int r3 = this.maxArraySize;
        if (r2 != r3) goto L13;
        SmallSortedMap<K, V>.Entry r4 = this.entryList.remove(r3 - 1);
        getOverflowEntriesMutable().put(r4.getKey(), r4.getValue());
    L13:
        this.entryList.add(r1, new Entry(this, r5, r6));
        return null;
    L9:
        return getOverflowEntriesMutable().put(r5, r6);
    L5:
        return this.entryList.get(r0).setValue(r6);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        checkMutable();
        if (this.entryList.isEmpty() == true) goto L6;
        this.entryList.clear();
    L6:
        if (this.overflowEntries.isEmpty() == true) goto L9;
        this.overflowEntries.clear();
        return;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object o) {
        checkMutable();
        Comparable r2 = (Comparable) o;
        int r0 = binarySearchInArray(r2);
        if (r0 < 0) goto L7;
        return removeArrayEntryAt(r0);
    L7:
        if (this.overflowEntries.isEmpty() == false) goto L11;
        return null;
    L11:
        return this.overflowEntries.remove(r2);
    }

    private V removeArrayEntryAt(int index) {
        checkMutable();
        V r5 = this.entryList.remove(index).getValue();
        if (this.overflowEntries.isEmpty() == true) goto L5;
        Iterator<Map.Entry<K, V>> r0 = getOverflowEntriesMutable().entrySet().iterator();
        this.entryList.add(new Entry(this, r0.next()));
        r0.remove();
    L5:
        return r5;
    }

    private int binarySearchInArray(K key) {
        int r0 = this.entryList.size() - 1;
        if (r0 < 0) goto L10;
        int r1 = key.compareTo(this.entryList.get(r0).getKey());
        if (r1 > 0) goto L7;
        if (r1 != 0) goto L10;
        return r0;
    L7:
        return -(r0 + 2);
    L10:
        int r2 = 0;
    L11:
        if (r2 > r0) goto L19;
        int r3 = (r2 + r0) / 2;
        int r4 = key.compareTo(this.entryList.get(r3).getKey());
        if (r4 < 0) goto L14;
        if (r4 <= 0) goto L17;
        r2 = r3 + 1;
        goto L11
    L17:
        return r3;
    L14:
        r0 = r3 - 1;
        goto L11
    L19:
        return -(r2 + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.lazyEntrySet != null) goto L6;
        this.lazyEntrySet = new EntrySet(this, null);
    L6:
        return this.lazyEntrySet;
    }

    Set<Map.Entry<K, V>> descendingEntrySet() {
        if (this.lazyDescendingEntrySet != null) goto L6;
        this.lazyDescendingEntrySet = new DescendingEntrySet(this, null);
    L6:
        return this.lazyDescendingEntrySet;
    }

    private void checkMutable() {
        if (this.isImmutable == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    private SortedMap<K, V> getOverflowEntriesMutable() {
        checkMutable();
        if (this.overflowEntries.isEmpty() == false) goto L8;
        if ((this.overflowEntries instanceof TreeMap) == true) goto L8;
        TreeMap r0 = new TreeMap();
        this.overflowEntries = r0;
        this.overflowEntriesDescending = r0.descendingMap();
    L8:
        return (SortedMap) this.overflowEntries;
    }

    private void ensureEntryArrayMutable() {
        checkMutable();
        if (this.entryList.isEmpty() == true) goto L5;
        return;
    L5:
        if ((this.entryList instanceof ArrayList) == true) goto L9;
        this.entryList = new ArrayList(this.maxArraySize);
        return;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if ((o instanceof SmallSortedMap) == false) goto L8;
        SmallSortedMap r8 = (SmallSortedMap) o;
        int r1 = size();
        if (r1 == r8.size()) goto L12;
        return false;
    L12:
        int r2 = getNumArrayEntries();
        if (r2 != r8.getNumArrayEntries()) goto L15;
        int r4 = 0;
    L17:
        if (r4 >= r2) goto L22;
        if (getArrayEntryAt(r4).equals(r8.getArrayEntryAt(r4)) == false) goto L20;
        r4 = r4 + 1;
        goto L17
    L20:
        return false;
    L22:
        if (r2 != r1) goto L24;
        return true;
    L24:
        return this.overflowEntries.equals(r8.overflowEntries);
    L15:
        return entrySet().equals(r8.entrySet());
    L8:
        return super.equals(o);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int r0 = getNumArrayEntries();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L6;
        r2 = r2 + this.entryList.get(r1).hashCode();
        r1 = r1 + 1;
        goto L3
    L6:
        if (getNumOverflowEntries() > 0) goto L8;
        return r2;
    L8:
        return r2 + this.overflowEntries.hashCode();
    }
}
