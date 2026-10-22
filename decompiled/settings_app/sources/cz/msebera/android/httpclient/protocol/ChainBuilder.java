package cz.msebera.android.httpclient.protocol;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
final class ChainBuilder<E> {
    private final LinkedList<E> list;
    private final Map<Class<?>, E> uniqueClasses;

    public ChainBuilder() {
        this.list = new LinkedList();
        this.uniqueClasses = new HashMap();
    }

    private void ensureUnique(E r3) {
        E r0 = this.uniqueClasses.remove(r3.getClass());
        if (r0 == null) goto L5;
        this.list.remove(r0);
    L5:
        this.uniqueClasses.put(r3.getClass(), r3);
    }

    public ChainBuilder<E> addFirst(E r2) {
        if (r2 != null) goto L4;
        return this;
    L4:
        ensureUnique(r2);
        this.list.addFirst(r2);
        return this;
    }

    public ChainBuilder<E> addLast(E r2) {
        if (r2 != null) goto L4;
        return this;
    L4:
        ensureUnique(r2);
        this.list.addLast(r2);
        return this;
    }

    public ChainBuilder<E> addAllFirst(Collection<E> r2) {
        if (r2 != null) goto L4;
        return this;
    L4:
        Iterator<E> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        addFirst(r3.next());
        goto L6
    L8:
        return this;
    }

    public ChainBuilder<E> addAllFirst(E... r4) {
        if (r4 != null) goto L4;
        return this;
    L4:
        int r0 = r4.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        addFirst(r4[r1]);
        r1 = r1 + 1;
        goto L5
    L7:
        return this;
    }

    public ChainBuilder<E> addAllLast(Collection<E> r2) {
        if (r2 != null) goto L4;
        return this;
    L4:
        Iterator<E> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        addLast(r3.next());
        goto L6
    L8:
        return this;
    }

    public ChainBuilder<E> addAllLast(E... r4) {
        if (r4 != null) goto L4;
        return this;
    L4:
        int r0 = r4.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        addLast(r4[r1]);
        r1 = r1 + 1;
        goto L5
    L7:
        return this;
    }

    public LinkedList<E> build() {
        return new LinkedList(this.list);
    }
}
