package io.reactivex.disposables;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.OpenHashSet;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public final class CompositeDisposable implements Disposable, DisposableContainer {
    volatile boolean disposed;
    OpenHashSet<Disposable> resources;

    public CompositeDisposable() {
    }

    public CompositeDisposable(Disposable... r5) {
        ObjectHelper.requireNonNull(r5, "disposables is null");
        this.resources = new OpenHashSet(r5.length + 1);
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Disposable r2 = r5[r1];
        ObjectHelper.requireNonNull(r2, "A Disposable in the disposables array is null");
        this.resources.add(r2);
        r1 = r1 + 1;
        goto L3
    }

    public CompositeDisposable(Iterable<? extends Disposable> r3) {
        ObjectHelper.requireNonNull(r3, "disposables is null");
        this.resources = new OpenHashSet();
        Iterator<? extends Disposable> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Disposable r0 = r4.next();
        ObjectHelper.requireNonNull(r0, "A Disposable item in the disposables sequence is null");
        this.resources.add(r0);
        goto L4
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.disposed == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (this.disposed == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L10:
        this.disposed = true;     // Catch: Throwable -> L14
        OpenHashSet<Disposable> r0 = this.resources;     // Catch: Throwable -> L14
        this.resources = null;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        dispose(r0);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.disposed;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean add(Disposable r2) {
        ObjectHelper.requireNonNull(r2, "disposable is null");
        if (this.disposed == true) goto L19;
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (this.disposed == true) goto L14;
        OpenHashSet<Disposable> r0 = this.resources;     // Catch: Throwable -> L16
        if (r0 != null) goto L10;
        r0 = new OpenHashSet();     // Catch: Throwable -> L16
        this.resources = r0;     // Catch: Throwable -> L16
    L10:
        r0.add(r2);     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return true;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
    L19:
        r2.dispose();
        return false;
    }

    public boolean addAll(Disposable... r7) {
        ObjectHelper.requireNonNull(r7, "disposables is null");
        int r1 = 0;
        if (this.disposed == true) goto L20;
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L6:
        if (this.disposed == true) goto L15;
        OpenHashSet<Disposable> r0 = this.resources;     // Catch: Throwable -> L17
        if (r0 != null) goto L10;
        r0 = new OpenHashSet(r7.length + 1);     // Catch: Throwable -> L17
        this.resources = r0;     // Catch: Throwable -> L17
    L10:
        int r3 = r7.length;     // Catch: Throwable -> L17
    L11:
        if (r1 >= r3) goto L13;
        Disposable r4 = r7[r1];     // Catch: Throwable -> L17
        ObjectHelper.requireNonNull(r4, "A Disposable in the disposables array is null");     // Catch: Throwable -> L17
        r0.add(r4);     // Catch: Throwable -> L17
        r1 = r1 + 1;     // Catch: Throwable -> L17
        goto L11
    L13:
        monitor-exit(this);     // Catch: Throwable -> L17
        return true;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L17
    L20:
        int r6 = r7.length;
        int r2 = 0;
    L21:
        if (r2 >= r6) goto L23;
        r7[r2].dispose();
        r2 = r2 + 1;
        goto L21
    L23:
        return false;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean remove(Disposable r1) {
        if (delete(r1) == false) goto L6;
        r1.dispose();
        return true;
    L6:
        return false;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean delete(Disposable r3) {
        ObjectHelper.requireNonNull(r3, "disposables is null");
        if (this.disposed == false) goto L5;
        return false;
    L5:
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (this.disposed == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L20
        return false;
    L10:
        OpenHashSet<Disposable> r0 = this.resources;     // Catch: Throwable -> L20
        if (r0 != null) goto L13;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        return false;
    L13:
        if (r0.remove(r3) == false) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L20
        return true;
    }

    public void clear() {
        if (this.disposed == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (this.disposed == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L10:
        OpenHashSet<Disposable> r0 = this.resources;     // Catch: Throwable -> L14
        this.resources = null;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        dispose(r0);
    }

    public int size() {
        int r1 = 0;
        if (this.disposed == false) goto L5;
        return 0;
    L5:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (this.disposed == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L15
        return 0;
    L10:
        OpenHashSet<Disposable> r0 = this.resources;     // Catch: Throwable -> L15
        if (r0 == null) goto L13;
        r1 = r0.size();     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);     // Catch: Throwable -> L15
        return r1;
    }

    void dispose(OpenHashSet<Disposable> r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        Object[] r5 = r6.keys();
        int r7 = r5.length;
        ArrayList r1 = null;
        int r2 = 0;
    L5:
        if (r2 >= r7) goto L16;
        Object r3 = r5[r2];
        if ((r3 instanceof Disposable) == false) goto L15;
        ((Disposable) r3).dispose();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        if (r1 != null) goto L14;
        r1 = new ArrayList();
    L14:
        r1.add(th);
    L15:
        r2 = r2 + 1;
        goto L5
    L16:
        if (r1 != null) goto L18;
        return;
    L18:
        if (r1.size() != 1) goto L22;
        throw ExceptionHelper.wrapOrThrow((Throwable) r1.get(0));
    L22:
        throw new CompositeException(r1);
    }
}
