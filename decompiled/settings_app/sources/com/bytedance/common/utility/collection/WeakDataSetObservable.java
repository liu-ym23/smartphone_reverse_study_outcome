package com.bytedance.common.utility.collection;

import android.database.DataSetObserver;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class WeakDataSetObservable<T extends DataSetObserver> {
    protected final WeakContainer<T> mObservers;

    public WeakDataSetObservable() {
        this.mObservers = new WeakContainer();
    }

    public void registerObserver(T r2) {
        if (r2 == null) goto L12;
        WeakContainer<T> r0 = this.mObservers;
        monitor-enter(r0);
        this.mObservers.add(r2);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L12:
        throw new IllegalArgumentException("The observer is null.");
    }

    public void unregisterObserver(T r2) {
        if (r2 == null) goto L12;
        WeakContainer<T> r0 = this.mObservers;
        monitor-enter(r0);
        this.mObservers.remove(r2);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L12:
        throw new IllegalArgumentException("The observer is null.");
    }

    public void unregisterAll() {
        WeakContainer<T> r0 = this.mObservers;
        monitor-enter(r0);
        this.mObservers.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void notifyChanged() {
        WeakContainer<T> r0 = this.mObservers;
        monitor-enter(r0);
        Iterator<T> r2 = this.mObservers.iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L8;
        r2.next().onChanged();     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void notifyInvalidated() {
        WeakContainer<T> r0 = this.mObservers;
        monitor-enter(r0);
        Iterator<T> r2 = this.mObservers.iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L8;
        r2.next().onInvalidated();     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
