package cz.msebera.android.httpclient.concurrent;

import cz.msebera.android.httpclient.util.Args;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes5.dex */
public class BasicFuture<T> implements Future<T>, Cancellable {
    private final FutureCallback<T> callback;
    private volatile boolean cancelled;
    private volatile boolean completed;
    private volatile Exception ex;
    private volatile T result;

    public BasicFuture(FutureCallback<T> r1) {
        this.callback = r1;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.completed;
    }

    private T getResult() throws ExecutionException {
        if (this.ex != null) goto L11;
        if (this.cancelled == true) goto L9;
        return this.result;
    L9:
        throw new CancellationException();
    L11:
        throw new ExecutionException(this.ex);
    }

    @Override // java.util.concurrent.Future
    public synchronized T get() throws InterruptedException, ExecutionException {
        monitor-enter(this);
    L12:
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.completed == true) goto L6;
        wait();     // Catch: Throwable -> L9
        goto L12
    L6:
        T r0 = getResult();     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    @Override // java.util.concurrent.Future
    public synchronized T get(long r7, TimeUnit r9) throws InterruptedException, ExecutionException, TimeoutException {
        monitor-enter(this);
        Args.notNull(r9, "Time unit");     // Catch: Throwable -> L26
        long r8 = r9.toMillis(r7);     // Catch: Throwable -> L26
        if (r8 > 0) goto L6;
        long r2 = 0;
    L8:
        if (this.completed == false) goto L12;
        T r10 = getResult();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r10;
    L12:
        if (r8 <= 0) goto L25;
        long r4 = r8;
    L14:
        wait(r4);     // Catch: Throwable -> L26
        if (this.completed == true) goto L16;
        r4 = r8 - (System.currentTimeMillis() - r2);     // Catch: Throwable -> L26
        if (r4 > 0) goto L14;
        throw new TimeoutException();     // Catch: Throwable -> L26
    L16:
        T r11 = getResult();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r11;
    L25:
        throw new TimeoutException();     // Catch: Throwable -> L26
    L6:
        r2 = System.currentTimeMillis();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public boolean completed(T r2) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.completed == false) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L14
        return false;
    L8:
        this.completed = true;     // Catch: Throwable -> L14
        this.result = r2;     // Catch: Throwable -> L14
        notifyAll();     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        FutureCallback<T> r1 = this.callback;
        if (r1 == null) goto L13;
        r1.completed(r2);
    L13:
        return true;
    }

    public boolean failed(Exception r2) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.completed == false) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L14
        return false;
    L8:
        this.completed = true;     // Catch: Throwable -> L14
        this.ex = r2;     // Catch: Throwable -> L14
        notifyAll();     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        FutureCallback<T> r1 = this.callback;
        if (r1 == null) goto L13;
        r1.failed(r2);
    L13:
        return true;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r1) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.completed == false) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L14
        return false;
    L8:
        this.completed = true;     // Catch: Throwable -> L14
        this.cancelled = true;     // Catch: Throwable -> L14
        notifyAll();     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        FutureCallback<T> r0 = this.callback;
        if (r0 == null) goto L13;
        r0.cancelled();
    L13:
        return true;
    }

    @Override // cz.msebera.android.httpclient.concurrent.Cancellable
    public boolean cancel() {
        return cancel(true);
    }
}
