package cz.msebera.android.httpclient.pool;

import cz.msebera.android.httpclient.pool.PoolEntry;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes5.dex */
abstract class RouteSpecificPool<T, C, E extends PoolEntry<T, C>> {
    private final LinkedList<E> available;
    private final Set<E> leased;
    private final LinkedList<Future<E>> pending;
    private final T route;

    protected abstract E createEntry(C r1);

    RouteSpecificPool(T r1) {
        this.route = r1;
        this.leased = new HashSet();
        this.available = new LinkedList();
        this.pending = new LinkedList();
    }

    public final T getRoute() {
        return this.route;
    }

    public int getLeasedCount() {
        return this.leased.size();
    }

    public int getPendingCount() {
        return this.pending.size();
    }

    public int getAvailableCount() {
        return this.available.size();
    }

    public int getAllocatedCount() {
        return this.available.size() + this.leased.size();
    }

    public E getFree(Object r4) {
        if (this.available.isEmpty() == true) goto L19;
        if (r4 == null) goto L12;
        Iterator<E> r0 = this.available.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        E r1 = r0.next();
        if (r4.equals(r1.getState()) == false) goto L7;
        r0.remove();
        this.leased.add(r1);
        return r1;
    L12:
        Iterator<E> r5 = this.available.iterator();
    L14:
        if (r5.hasNext() == false) goto L27;
        E r2 = r5.next();
        if (r2.getState() != null) goto L14;
        r5.remove();
        this.leased.add(r2);
        return r2;
    L27:
        return null;
    L19:
        return null;
    }

    public E getLastUsed() {
        if (this.available.isEmpty() == false) goto L6;
        return null;
    L6:
        return this.available.getLast();
    }

    public boolean remove(E r2) {
        Args.notNull(r2, "Pool entry");
        if (this.available.remove(r2) == false) goto L5;
        return true;
    L5:
        if (this.leased.remove(r2) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public void free(E r3, boolean r4) {
        Args.notNull(r3, "Pool entry");
        Asserts.check(this.leased.remove(r3), "Entry %s has not been leased from this pool", r3);
        if (r4 == false) goto L6;
        this.available.addFirst(r3);
        return;
    }

    public E add(C r1) {
        E r2 = (E) createEntry(r1);
        this.leased.add(r2);
        return r2;
    }

    public void queue(Future<E> r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.pending.add(r1);
    }

    public Future<E> nextPending() {
        return this.pending.poll();
    }

    public void unqueue(Future<E> r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.pending.remove(r1);
    }

    public void shutdown() {
        Iterator<Future<E>> r0 = this.pending.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().cancel(true);
        goto L4
    L6:
        this.pending.clear();
        Iterator<E> r1 = this.available.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r1.next().close();
        goto L8
    L10:
        this.available.clear();
        Iterator<E> r2 = this.leased.iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        r2.next().close();
        goto L12
    L14:
        this.leased.clear();
    }

    public String toString() {
        return "[route: " + this.route + "][leased: " + this.leased.size() + "][available: " + this.available.size() + "][pending: " + this.pending.size() + "]";
    }
}
