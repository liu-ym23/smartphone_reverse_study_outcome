package d.b.p.a.c.e;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class b<E> extends LinkedList<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private LinkedList<Runnable> f14222f;

    public b(LinkedList<Runnable> r1) {
        this.f14222f = r1;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(E r1) {
        return this.f14222f.add((Runnable) r1);
    }

    @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
    public E poll() {
        return null;
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public boolean remove(Object r1) {
        return this.f14222f.remove(r1);
    }
}
