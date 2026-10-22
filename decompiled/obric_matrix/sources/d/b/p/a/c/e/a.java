package d.b.p.a.c.e;

import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class a<E> extends ConcurrentLinkedQueue<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ConcurrentLinkedQueue<Runnable> f14221f;

    public a(ConcurrentLinkedQueue<Runnable> r1) {
        this.f14221f = r1;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E r1) {
        return this.f14221f.add((Runnable) r1);
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue
    public E poll() {
        return null;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object r1) {
        return this.f14221f.remove(r1);
    }
}
