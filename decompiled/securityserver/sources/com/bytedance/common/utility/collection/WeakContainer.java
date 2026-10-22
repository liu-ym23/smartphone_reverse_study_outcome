package com.bytedance.common.utility.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class WeakContainer<E> implements Iterable<E> {
    private final WeakHashMap<E, Object> mMap;
    private final Object mValue;

    public WeakContainer() {
        this.mMap = new WeakHashMap();
        this.mValue = new Object();
    }

    public void add(E r2) {
        if (r2 != null) goto L5;
        this.mMap.size();
        return;
    L5:
        this.mMap.put(r2, this.mValue);
    }

    public void clear() {
        this.mMap.clear();
    }

    public boolean contains(E r1) {
        return this.mMap.containsKey(r1);
    }

    public boolean isEmpty() {
        return this.mMap.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        ArrayList r0 = new ArrayList(this.mMap.size());
        Iterator<E> r2 = this.mMap.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        E r1 = r2.next();
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L9:
        return r0.iterator();
    }

    public E peek() {
        E r1 = null;
        if (this.mMap.size() != 0) goto L5;
        return null;
    L5:
        Iterator<E> r0 = this.mMap.keySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        E r2 = r0.next();
        if (r2 == null) goto L7;
        r1 = r2;
    L11:
        this.mMap.remove(r1);
        return r1;
    }

    public void remove(E r1) {
        if (r1 != null) goto L5;
        this.mMap.size();
        return;
    L5:
        this.mMap.remove(r1);
    }

    public int size() {
        return this.mMap.size();
    }
}
