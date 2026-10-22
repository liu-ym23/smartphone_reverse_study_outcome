package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class GroupedLinkedMap<K extends Poolable, V> {
    private final LinkedEntry<K, V> head;
    private final Map<K, LinkedEntry<K, V>> keyToEntry;

    private static class LinkedEntry<K, V> {
        final K key;
        LinkedEntry<K, V> next;
        LinkedEntry<K, V> prev;
        private List<V> values;

        LinkedEntry() {
            this(null);
        }

        LinkedEntry(K r1) {
            this.prev = this;
            this.next = this;
            this.key = r1;
        }

        public V removeLast() {
            int r0 = size();
            if (r0 > 0) goto L7;
            return null;
        L7:
            return this.values.remove(r0 - 1);
        }

        public int size() {
            List<V> r0 = this.values;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        public void add(V r2) {
            if (this.values != null) goto L5;
            this.values = new ArrayList();
        L5:
            this.values.add(r2);
        }
    }

    GroupedLinkedMap() {
        this.head = new LinkedEntry();
        this.keyToEntry = new HashMap();
    }

    public void put(K r2, V r3) {
        LinkedEntry<K, V> r0 = this.keyToEntry.get(r2);
        if (r0 != null) goto L5;
        r0 = new LinkedEntry(r2);
        makeTail(r0);
        this.keyToEntry.put(r2, r0);
    L6:
        r0.add(r3);
        return;
    L5:
        r2.offer();
        goto L6
    }

    public V get(K r3) {
        LinkedEntry<K, V> r0 = this.keyToEntry.get(r3);
        if (r0 != null) goto L5;
        r0 = new LinkedEntry(r3);
        this.keyToEntry.put(r3, r0);
    L6:
        makeHead(r0);
        return r0.removeLast();
    L5:
        r3.offer();
        goto L6
    }

    public V removeLast() {
        LinkedEntry r0 = this.head.prev;
    L4:
        if (r0.equals(this.head) == true) goto L9;
        V r1 = (V) r0.removeLast();
        if (r1 != null) goto L7;
        removeEntry(r0);
        this.keyToEntry.remove(r0.key);
        ((Poolable) r0.key).offer();
        r0 = r0.prev;
        goto L4
    L7:
        return r1;
    L9:
        return null;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("GroupedLinkedMap( ");
        LinkedEntry r1 = this.head.next;
        boolean r2 = false;
    L4:
        if (r1.equals(this.head) == true) goto L6;
        r0.append('{').append(r1.key).append(':').append(r1.size()).append("}, ");
        r1 = r1.next;
        r2 = true;
        goto L4
    L6:
        if (r2 == false) goto L9;
        r0.delete(r0.length() - 2, r0.length());
    L9:
        return r0.append(" )").toString();
    }

    private void makeHead(LinkedEntry<K, V> r2) {
        removeEntry(r2);
        r2.prev = this.head;
        r2.next = this.head.next;
        updateEntry(r2);
    }

    private void makeTail(LinkedEntry<K, V> r2) {
        removeEntry(r2);
        r2.prev = this.head.prev;
        r2.next = this.head;
        updateEntry(r2);
    }

    private static <K, V> void updateEntry(LinkedEntry<K, V> r1) {
        r1.next.prev = r1;
        r1.prev.next = r1;
    }

    private static <K, V> void removeEntry(LinkedEntry<K, V> r2) {
        LinkedEntry<K, V> r0 = r2.prev;
        r0.next = r2.next;
        LinkedEntry<K, V> r1 = r2.next;
        r1.prev = r2.prev;
    }
}
