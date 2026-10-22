package com.google.gson.internal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = null;
    Comparator<? super K> comparator;
    private LinkedTreeMap<K, V>.EntrySet entrySet;
    final Node<K, V> header;
    private LinkedTreeMap<K, V>.KeySet keySet;
    int modCount;
    Node<K, V> root;
    int size;

    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        final /* synthetic */ LinkedTreeMap this$0;

        public EntrySet(LinkedTreeMap r1) {
            this.this$0 = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r2) {
            if ((r2 instanceof Map.Entry) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.this$0.findByEntry((Map.Entry) r2) == null) goto L7;
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new AnonymousClass1(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r3) {
            if ((r3 instanceof Map.Entry) == true) goto L5;
            return false;
        L5:
            Node<K, V> r4 = this.this$0.findByEntry((Map.Entry) r3);
            if (r4 != null) goto L8;
            return false;
        L8:
            this.this$0.removeInternal(r4, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size;
        }
    }

    public final class KeySet extends AbstractSet<K> {
        final /* synthetic */ LinkedTreeMap this$0;

        public KeySet(LinkedTreeMap r1) {
            this.this$0 = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return this.this$0.containsKey(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new AnonymousClass1(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r1) {
            if (this.this$0.removeInternalByKey(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size;
        }
    }

    public abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
        int expectedModCount;
        Node<K, V> lastReturned;
        Node<K, V> next;
        final /* synthetic */ LinkedTreeMap this$0;

        public LinkedTreeMapIterator(LinkedTreeMap r2) {
            this.this$0 = r2;
            this.next = r2.header.next;
            this.lastReturned = null;
            this.expectedModCount = r2.modCount;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.next == this.this$0.header) goto L5;
            return true;
        L5:
            return false;
        }

        public final Node<K, V> nextNode() {
            Node<K, V> r0 = this.next;
            LinkedTreeMap r1 = this.this$0;
            if (r0 == r1.header) goto L11;
            if (r1.modCount != this.expectedModCount) goto L9;
            this.next = r0.next;
            this.lastReturned = r0;
            return r0;
        L9:
            throw new ConcurrentModificationException();
        L11:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            Node<K, V> r0 = this.lastReturned;
            if (r0 == null) goto L7;
            this.this$0.removeInternal(r0, true);
            this.lastReturned = null;
            this.expectedModCount = this.this$0.modCount;
            return;
        L7:
            throw new IllegalStateException();
        }
    }

    public static final class Node<K, V> implements Map.Entry<K, V> {
        int height;
        final K key;
        Node<K, V> left;
        Node<K, V> next;
        Node<K, V> parent;
        Node<K, V> prev;
        Node<K, V> right;
        V value;

        public Node() {
            this.key = null;
            this.prev = this;
            this.next = this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r4) {
            if ((r4 instanceof Map.Entry) == false) goto L20;
            Map.Entry r5 = (Map.Entry) r4;
            K r0 = this.key;
            if (r0 != null) goto L10;
            if (r5.getKey() != null) goto L21;
        L11:
            V r3 = this.value;
            if (r3 != null) goto L17;
            if (r5.getValue() != null) goto L23;
        L18:
            return true;
        L23:
            return false;
        L17:
            if (r3.equals(r5.getValue()) == true) goto L18;
            return false;
        L21:
            return false;
        L10:
            if (r0.equals(r5.getKey()) == true) goto L11;
            return false;
        L20:
            return false;
        }

        public Node<K, V> first() {
            Node<K, V> r0 = this.left;
        L3:
            Node<K, V> r1 = r0;
            Node<K, V> r2 = this;
            Node<K, V> this = r1;
            if (this == null) goto L6;
            r0 = this.left;
            goto L3
        L6:
            return r2;
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

        public Node<K, V> last() {
            Node<K, V> r0 = this.right;
        L3:
            Node<K, V> r1 = r0;
            Node<K, V> r2 = this;
            Node<K, V> this = r1;
            if (this == null) goto L6;
            r0 = this.right;
            goto L3
        L6:
            return r2;
        }

        @Override // java.util.Map.Entry
        public V setValue(V r2) {
            V r0 = this.value;
            this.value = r2;
            return r0;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }

        public Node(Node<K, V> r1, K r2, Node<K, V> r3, Node<K, V> r4) {
            this.parent = r1;
            this.key = r2;
            this.height = 1;
            this.next = r3;
            this.prev = r4;
            r4.next = this;
            r3.prev = this;
        }
    }

    static {
        NATURAL_ORDER = new AnonymousClass1();
    }

    public LinkedTreeMap() {
        this(NATURAL_ORDER);
    }

    private boolean equal(Object r1, Object r2) {
        if (r1 == r2) goto L8;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.equals(r2) == false) goto L7;
    L8:
        return true;
    }

    private void readObject(ObjectInputStream r1) {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private void rebalance(Node<K, V> r8, boolean r9) {
    L2:
        if (r8 == null) goto L52;
        Node<K, V> r0 = r8.left;
        Node<K, V> r1 = r8.right;
        int r2 = 0;
        if (r0 == null) goto L6;
        int r3 = r0.height;
    L7:
        if (r1 == null) goto L9;
        int r4 = r1.height;
    L10:
        int r5 = r3 - r4;
        if (r5 != (-2)) goto L28;
        Node<K, V> r6 = r1.left;
        Node<K, V> r7 = r1.right;
        if (r7 == null) goto L15;
        int r10 = r7.height;
    L16:
        if (r6 == null) goto L18;
        r2 = r6.height;
    L18:
        int r11 = r2 - r10;
        if (r11 == (-1)) goto L24;
        if (r11 != 0) goto L23;
        if (r9 == false) goto L24;
    L23:
        rotateRight(r1);
        rotateLeft(r8);
    L25:
        if (r9 == false) goto L51;
        return;
    L51:
        r8 = r8.parent;
    L24:
        rotateLeft(r8);
        goto L25
    L15:
        r10 = 0;
        goto L16
    L28:
        if (r5 != 2) goto L44;
        Node<K, V> r12 = r0.left;
        Node<K, V> r13 = r0.right;
        if (r13 == null) goto L32;
        int r14 = r13.height;
    L33:
        if (r12 == null) goto L35;
        r2 = r12.height;
    L35:
        int r15 = r2 - r14;
        if (r15 == 1) goto L41;
        if (r15 != 0) goto L40;
        if (r9 == false) goto L41;
    L40:
        rotateLeft(r0);
        rotateRight(r8);
    L42:
        if (r9 == false) goto L51;
        return;
    L41:
        rotateRight(r8);
        goto L42
    L32:
        r14 = 0;
        goto L33
    L44:
        if (r5 != 0) goto L48;
        r8.height = r3 + 1;
        if (r9 == false) goto L51;
        return;
    L48:
        r8.height = Math.max(r3, r4) + 1;
        if (r9 == true) goto L51;
        return;
    L9:
        r4 = 0;
        goto L10
    L6:
        r3 = 0;
        goto L7
    }

    private void replaceInParent(Node<K, V> r3, Node<K, V> r4) {
        Node<K, V> r0 = r3.parent;
        r3.parent = null;
        if (r4 == null) goto L5;
        r4.parent = r0;
    L5:
        if (r0 != null) goto L7;
        this.root = r4;
        return;
    L7:
        if (r0.left != r3) goto L9;
        r0.left = r4;
        return;
    L9:
        r0.right = r4;
    }

    private void rotateLeft(Node<K, V> r5) {
        Node<K, V> r0 = r5.left;
        Node<K, V> r1 = r5.right;
        Node<K, V> r2 = r1.left;
        Node<K, V> r3 = r1.right;
        r5.right = r2;
        if (r2 == null) goto L5;
        r2.parent = r5;
    L5:
        replaceInParent(r5, r1);
        r1.left = r5;
        r5.parent = r1;
        int r4 = 0;
        if (r0 == null) goto L8;
        int r6 = r0.height;
    L9:
        if (r2 == null) goto L11;
        int r7 = r2.height;
    L12:
        int r8 = Math.max(r6, r7) + 1;
        r5.height = r8;
        if (r3 == null) goto L15;
        r4 = r3.height;
    L15:
        r1.height = Math.max(r8, r4) + 1;
        return;
    L11:
        r7 = 0;
        goto L12
    L8:
        r6 = 0;
        goto L9
    }

    private void rotateRight(Node<K, V> r5) {
        Node<K, V> r0 = r5.left;
        Node<K, V> r1 = r5.right;
        Node<K, V> r2 = r0.left;
        Node<K, V> r3 = r0.right;
        r5.left = r3;
        if (r3 == null) goto L5;
        r3.parent = r5;
    L5:
        replaceInParent(r5, r0);
        r0.right = r5;
        r5.parent = r0;
        int r4 = 0;
        if (r1 == null) goto L8;
        int r6 = r1.height;
    L9:
        if (r3 == null) goto L11;
        int r7 = r3.height;
    L12:
        int r8 = Math.max(r6, r7) + 1;
        r5.height = r8;
        if (r2 == null) goto L15;
        r4 = r2.height;
    L15:
        r0.height = Math.max(r8, r4) + 1;
        return;
    L11:
        r7 = 0;
        goto L12
    L8:
        r6 = 0;
        goto L9
    }

    private Object writeReplace() {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        Node<K, V> r1 = this.header;
        r1.prev = r1;
        r1.next = r1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r1) {
        if (findByObject(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.EntrySet r0 = this.entrySet;
        if (r0 != null) goto L7;
        LinkedTreeMap<K, V>.EntrySet r1 = new EntrySet(this);
        this.entrySet = r1;
        return r1;
    L7:
        return r0;
    }

    public Node<K, V> find(K r7, boolean r8) {
        Comparator<? super K> r0 = this.comparator;
        Node<K, V> r1 = this.root;
        if (r1 != null) goto L5;
        int r4 = 0;
    L20:
        if (r8 == true) goto L22;
        return null;
    L22:
        Node<K, V> r9 = this.header;
        if (r1 == null) goto L25;
        Node<K, V> r2 = new Node(r1, r7, r9, r9.prev);
        if (r4 >= 0) goto L35;
        r1.left = r2;
    L36:
        rebalance(r1, true);
    L37:
        this.size++;
        this.modCount++;
        return r2;
    L35:
        r1.right = r2;
        goto L36
    L25:
        if (r0 == NATURAL_ORDER) goto L27;
    L31:
        r2 = new Node(r1, r7, r9, r9.prev);
        this.root = r2;
        goto L37
    L27:
        if ((r7 instanceof Comparable) == true) goto L31;
        throw new ClassCastException(r7.getClass().getName().concat(" is not Comparable"));
    L5:
        if (r0 != NATURAL_ORDER) goto L7;
        Comparable r3 = (Comparable) r7;
    L8:
        if (r3 == null) goto L10;
        r4 = r3.compareTo(r1.key);
    L11:
        if (r4 == 0) goto L12;
        if (r4 >= 0) goto L15;
        Node<K, V> r5 = r1.left;
    L16:
        if (r5 == null) goto L20;
        r1 = r5;
        goto L8
    L15:
        r5 = r1.right;
        goto L16
    L12:
        return r1;
    L10:
        r4 = r0.compare(r7, r1.key);
        goto L11
    L7:
        r3 = null;
        goto L8
    }

    public Node<K, V> findByEntry(Map.Entry<?, ?> r3) {
        Node<K, V> r0 = findByObject(r3.getKey());
        if (r0 != null) goto L5;
    L7:
        return null;
    L5:
        if (equal(r0.value, r3.getValue()) == false) goto L7;
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Node<K, V> findByObject(Object r3) {
        if (r3 != 0) goto L8;
        return null;
    L8:
        return find(r3, false);
    L11:
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r1) {
        Node<K, V> r0 = findByObject(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedTreeMap<K, V>.KeySet r0 = this.keySet;
        if (r0 != null) goto L7;
        LinkedTreeMap<K, V>.KeySet r1 = new KeySet(this);
        this.keySet = r1;
        return r1;
    L7:
        return r0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K r2, V r3) {
        if (r2 == null) goto L6;
        Node<K, V> r1 = find(r2, true);
        V r4 = r1.value;
        r1.value = r3;
        return r4;
    L6:
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r1) {
        Node<K, V> r0 = removeInternalByKey(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.value;
    }

    public void removeInternal(Node<K, V> r6, boolean r7) {
        if (r7 == false) goto L4;
        Node<K, V> r8 = r6.prev;
        r8.next = r6.next;
        r6.next.prev = r8;
    L4:
        Node<K, V> r9 = r6.left;
        Node<K, V> r0 = r6.right;
        Node<K, V> r1 = r6.parent;
        int r2 = 0;
        if (r9 == null) goto L20;
        if (r0 == null) goto L20;
        if (r9.height <= r0.height) goto L10;
        Node<K, V> r10 = r9.last();
    L11:
        removeInternal(r10, false);
        Node<K, V> r3 = r6.left;
        if (r3 == null) goto L14;
        int r4 = r3.height;
        r10.left = r3;
        r3.parent = r10;
        r6.left = null;
    L15:
        Node<K, V> r5 = r6.right;
        if (r5 == null) goto L18;
        r2 = r5.height;
        r10.right = r5;
        r5.parent = r10;
        r6.right = null;
    L18:
        r10.height = Math.max(r4, r2) + 1;
        replaceInParent(r6, r10);
        return;
    L14:
        r4 = 0;
        goto L15
    L10:
        r10 = r0.first();
    L20:
        if (r9 == null) goto L22;
        replaceInParent(r6, r9);
        r6.left = null;
    L25:
        rebalance(r1, false);
        this.size--;
        this.modCount++;
        return;
    L22:
        if (r0 == null) goto L24;
        replaceInParent(r6, r0);
        r6.right = null;
        goto L25
    L24:
        replaceInParent(r6, null);
        goto L25
    }

    public Node<K, V> removeInternalByKey(Object r2) {
        Node<K, V> r3 = findByObject(r2);
        if (r3 == null) goto L5;
        removeInternal(r3, true);
    L5:
        return r3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public LinkedTreeMap(Comparator<? super K> r2) {
        this.size = 0;
        this.modCount = 0;
        this.header = new Node();
        if (r2 != null) goto L6;
        r2 = NATURAL_ORDER;
    L6:
        this.comparator = r2;
    }
}
