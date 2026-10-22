package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class RequestFuture<T> implements Future<T>, Response.Listener<T>, Response.ErrorListener {
    private VolleyError mException;
    private Request<?> mRequest;
    private T mResult;
    private boolean mResultReceived;

    public static <E> RequestFuture<E> newFuture() {
        return new RequestFuture();
    }

    private RequestFuture() {
        this.mResultReceived = false;
    }

    public void setRequest(Request<?> r1) {
        this.mRequest = r1;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean r2) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mRequest != null) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (isDone() == true) goto L14;
        this.mRequest.cancel();     // Catch: Throwable -> L16
        monitor-exit(this);
        return true;
    L14:
        monitor-exit(this);
        return false;
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        return doGet(null);
    L5:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // java.util.concurrent.Future
    public T get(long r2, TimeUnit r4) throws InterruptedException, ExecutionException, TimeoutException {
        return doGet(Long.valueOf(TimeUnit.MILLISECONDS.convert(r2, r4)));
    }

    private synchronized T doGet(Long r5) throws InterruptedException, ExecutionException, TimeoutException {
        monitor-enter(this);
    L36:
        th = move-exception;
        throw th;
    L4:
        if (this.mException != null) goto L35;
        if (this.mResultReceived == false) goto L11;
        T r6 = this.mResult;     // Catch: Throwable -> L36
        monitor-exit(this);
        return r6;
    L11:
        if (r5 != null) goto L16;
    L13:
        if (isDone() == true) goto L24;
        wait(0);     // Catch: Throwable -> L36
    L24:
        if (this.mException != null) goto L33;
        if (this.mResultReceived == false) goto L31;
        T r7 = this.mResult;     // Catch: Throwable -> L36
        monitor-exit(this);
        return r7;
    L31:
        throw new TimeoutException();     // Catch: Throwable -> L36
    L33:
        throw new ExecutionException(this.mException);     // Catch: Throwable -> L36
    L16:
        if (r5.longValue() <= 0) goto L24;
        long r0 = SystemClock.uptimeMillis();     // Catch: Throwable -> L36
        long r2 = r5.longValue() + r0;     // Catch: Throwable -> L36
    L19:
        if (isDone() == true) goto L24;
        if (r0 >= r2) goto L24;
        wait(r2 - r0);     // Catch: Throwable -> L36
        r0 = SystemClock.uptimeMillis();     // Catch: Throwable -> L36
        goto L19
    L35:
        throw new ExecutionException(this.mException);     // Catch: Throwable -> L36
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        Request<?> r0 = this.mRequest;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isCanceled();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.mResultReceived == false) goto L6;
    L11:
        boolean r0 = true;
    L12:
        monitor-exit(this);
        return r0;
    L6:
        if (this.mException != null) goto L11;
        if (isCancelled() == true) goto L11;
        r0 = false;
        goto L12
    }

    @Override // com.android.volley.Response.Listener
    public synchronized void onResponse(T r2) {
        monitor-enter(this);
        this.mResultReceived = true;     // Catch: Throwable -> L7
        this.mResult = r2;     // Catch: Throwable -> L7
        notifyAll();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.volley.Response.ErrorListener
    public synchronized void onErrorResponse(VolleyError r1) {
        monitor-enter(this);
        this.mException = r1;     // Catch: Throwable -> L6
        notifyAll();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
