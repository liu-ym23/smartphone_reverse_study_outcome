package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ListCompositeDisposable implements Disposable, DisposableContainer {
    volatile boolean disposed;
    List<Disposable> resources;

    public ListCompositeDisposable() {
    }

    public ListCompositeDisposable(Disposable... r5) {
        ObjectHelper.requireNonNull(r5, "resources is null");
        this.resources = new LinkedList();
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Disposable r2 = r5[r1];
        ObjectHelper.requireNonNull(r2, "Disposable item is null");
        this.resources.add(r2);
        r1 = r1 + 1;
        goto L3
    }

    public ListCompositeDisposable(Iterable<? extends Disposable> r3) {
        ObjectHelper.requireNonNull(r3, "resources is null");
        this.resources = new LinkedList();
        Iterator<? extends Disposable> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Disposable r0 = r4.next();
        ObjectHelper.requireNonNull(r0, "Disposable item is null");
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
        List<Disposable> r0 = this.resources;     // Catch: Throwable -> L14
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
        ObjectHelper.requireNonNull(r2, "d is null");
        if (this.disposed == true) goto L19;
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (this.disposed == true) goto L14;
        List r0 = this.resources;     // Catch: Throwable -> L16
        if (r0 != null) goto L10;
        r0 = new LinkedList();     // Catch: Throwable -> L16
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

    public boolean addAll(Disposable... r6) {
        ObjectHelper.requireNonNull(r6, "ds is null");
        int r1 = 0;
        if (this.disposed == true) goto L21;
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L6:
        if (this.disposed == true) goto L16;
        List r0 = this.resources;     // Catch: Throwable -> L18
        if (r0 != null) goto L10;
        r0 = new LinkedList();     // Catch: Throwable -> L18
        this.resources = r0;     // Catch: Throwable -> L18
    L10:
        int r2 = r6.length;     // Catch: Throwable -> L18
    L11:
        if (r1 >= r2) goto L13;
        Disposable r3 = r6[r1];     // Catch: Throwable -> L18
        ObjectHelper.requireNonNull(r3, "d is null");     // Catch: Throwable -> L18
        r0.add(r3);     // Catch: Throwable -> L18
        r1 = r1 + 1;     // Catch: Throwable -> L18
        goto L11
    L13:
        monitor-exit(this);     // Catch: Throwable -> L18
        return true;
    L16:
        monitor-exit(this);     // Catch: Throwable -> L18
    L21:
        int r5 = r6.length;
        int r4 = 0;
    L22:
        if (r4 >= r5) goto L24;
        r6[r4].dispose();
        r4 = r4 + 1;
        goto L22
    L24:
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
        ObjectHelper.requireNonNull(r3, "Disposable item is null");
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
        List<Disposable> r0 = this.resources;     // Catch: Throwable -> L20
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
        List<Disposable> r0 = this.resources;     // Catch: Throwable -> L14
        this.resources = null;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        dispose(r0);
    }

    void dispose(List<Disposable> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        Iterator<Disposable> r1 = r2.iterator();
        ArrayList r3 = null;
    L6:
        if (r1.hasNext() == false) goto L15;
        r1.next().dispose();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        if (r3 != null) goto L14;
        r3 = new ArrayList();
    L14:
        r3.add(th);
        goto L6
    L15:
        if (r3 != null) goto L17;
        return;
    L17:
        if (r3.size() != 1) goto L21;
        throw ExceptionHelper.wrapOrThrow((Throwable) r3.get(0));
    L21:
        throw new CompositeException(r3);
    }
}
