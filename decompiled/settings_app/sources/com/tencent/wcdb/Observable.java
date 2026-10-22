package com.tencent.wcdb;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Observable<T> {
    protected final ArrayList<T> mObservers;

    public Observable() {
        this.mObservers = new ArrayList();
    }

    public void registerObserver(T r4) {
        if (r4 == null) goto L17;
        ArrayList<T> r1 = this.mObservers;
        monitor-enter(r1);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.mObservers.contains(r4) == true) goto L12;
        this.mObservers.add(r4);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L12:
        throw new IllegalStateException("Observer " + r4 + " is already registered.");     // Catch: Throwable -> L13
    L17:
        throw new IllegalArgumentException("The observer is null.");
    }

    public void unregisterObserver(T r5) {
        if (r5 == null) goto L17;
        ArrayList<T> r1 = this.mObservers;
        monitor-enter(r1);
        int r2 = this.mObservers.indexOf(r5);     // Catch: Throwable -> L13
        if (r2 == (-1)) goto L12;
        this.mObservers.remove(r2);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L12:
        throw new IllegalStateException("Observer " + r5 + " was not registered.");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L17:
        throw new IllegalArgumentException("The observer is null.");
    }

    public void unregisterAll() {
        ArrayList<T> r0 = this.mObservers;
        monitor-enter(r0);
        this.mObservers.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
