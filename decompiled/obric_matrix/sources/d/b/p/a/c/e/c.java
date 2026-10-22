package d.b.p.a.c.e;

import android.os.Looper;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class c<E> extends LinkedList<E> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object f14223g = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private LinkedList<Runnable> f14224f;

    static {
        f14223g = new Object();
    }

    public c(LinkedList<Runnable> r1) {
        this.f14224f = r1;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(E r2) {
        Object r0 = f14223g;
        monitor-enter(r0);
        boolean r1 = this.f14224f.add((Runnable) r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L6;
        d.d();
        return;
    L6:
        Object r0 = f14223g;
        monitor-enter(r0);
        this.f14224f.clear();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // java.util.LinkedList
    public Object clone() {
        super.clone();
        if (Looper.getMainLooper() == Looper.myLooper()) goto L5;
        Object r0 = f14223g;
        monitor-enter(r0);
        LinkedList r1 = new LinkedList(this.f14224f);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    L5:
        return new LinkedList();
    }
}
