package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class RequestFutureTarget<R> implements FutureTarget<R>, RequestListener<R> {
    private static final Waiter DEFAULT_WAITER = null;
    private final boolean assertBackgroundThread;
    private GlideException exception;
    private final int height;
    private boolean isCancelled;
    private boolean loadFailed;
    private Request request;
    private R resource;
    private boolean resultReceived;
    private final Waiter waiter;
    private final int width;

    static class Waiter {
        Waiter() {
        }

        void waitForTimeout(Object r1, long r2) throws InterruptedException {
            r1.wait(r2);
        }

        void notifyAll(Object r1) {
            r1.notifyAll();
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable r1) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable r1) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(SizeReadyCallback r1) {
    }

    static {
        DEFAULT_WAITER = new Waiter();
    }

    public RequestFutureTarget(int r3, int r4) {
        this(r3, r4, true, DEFAULT_WAITER);
    }

    RequestFutureTarget(int r1, int r2, boolean r3, Waiter r4) {
        this.width = r1;
        this.height = r2;
        this.assertBackgroundThread = r3;
        this.waiter = r4;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r3) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (isDone() == false) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L15
        return false;
    L8:
        this.isCancelled = true;     // Catch: Throwable -> L15
        this.waiter.notifyAll(this);     // Catch: Throwable -> L15
        Request r1 = null;
        if (r3 == false) goto L11;
        Request r4 = this.request;     // Catch: Throwable -> L15
        this.request = null;     // Catch: Throwable -> L15
        r1 = r4;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L15
        if (r1 == null) goto L14;
        r1.clear();
    L14:
        return true;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        monitor-enter(this);
        boolean r0 = this.isCancelled;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.isCancelled == false) goto L6;
    L11:
        boolean r0 = true;
    L12:
        monitor-exit(this);
        return r0;
    L6:
        if (this.resultReceived == true) goto L11;
        if (this.loadFailed == true) goto L11;
        r0 = false;
        goto L12
    }

    @Override // java.util.concurrent.Future
    public R get() throws InterruptedException, ExecutionException {
        return doGet(null);
    L5:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // java.util.concurrent.Future
    public R get(long r1, TimeUnit r3) throws InterruptedException, ExecutionException, TimeoutException {
        return doGet(Long.valueOf(r3.toMillis(r1)));
    }

    @Override // com.bumptech.glide.request.target.Target
    public void getSize(SizeReadyCallback r2) {
        r2.onSizeReady(this.width, this.height);
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void setRequest(Request r1) {
        monitor-enter(this);
        this.request = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized Request getRequest() {
        monitor-enter(this);
        Request r0 = this.request;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void onLoadFailed(Drawable r1) {
        monitor-enter(this);
        monitor-exit(this);
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void onResourceReady(R r1, Transition<? super R> r2) {
        monitor-enter(this);
        monitor-exit(this);
    }

    private synchronized R doGet(Long r5) throws ExecutionException, InterruptedException, TimeoutException {
        monitor-enter(this);
    L51:
        th = move-exception;
        throw th;
    L4:
        if (this.assertBackgroundThread == false) goto L9;
        if (isDone() == true) goto L9;
        Util.assertBackgroundThread();     // Catch: Throwable -> L51
    L9:
        if (this.isCancelled == true) goto L50;
        if (this.loadFailed == true) goto L48;
        if (this.resultReceived == false) goto L18;
        R r6 = this.resource;     // Catch: Throwable -> L51
        monitor-exit(this);
        return r6;
    L18:
        if (r5 != null) goto L21;
        this.waiter.waitForTimeout(this, 0);     // Catch: Throwable -> L51
    L29:
        if (Thread.interrupted() == true) goto L46;
        if (this.loadFailed == true) goto L44;
        if (this.isCancelled == true) goto L42;
        if (this.resultReceived == false) goto L40;
        R r7 = this.resource;     // Catch: Throwable -> L51
        monitor-exit(this);
        return r7;
    L40:
        throw new TimeoutException();     // Catch: Throwable -> L51
    L42:
        throw new CancellationException();     // Catch: Throwable -> L51
    L44:
        throw new ExecutionException(this.exception);     // Catch: Throwable -> L51
    L46:
        throw new InterruptedException();     // Catch: Throwable -> L51
    L21:
        if (r5.longValue() <= 0) goto L29;
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L51
        long r2 = r5.longValue() + r0;     // Catch: Throwable -> L51
    L24:
        if (isDone() == true) goto L29;
        if (r0 >= r2) goto L29;
        this.waiter.waitForTimeout(this, r2 - r0);     // Catch: Throwable -> L51
        r0 = System.currentTimeMillis();     // Catch: Throwable -> L51
        goto L24
    L48:
        throw new ExecutionException(this.exception);     // Catch: Throwable -> L51
    L50:
        throw new CancellationException();     // Catch: Throwable -> L51
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean onLoadFailed(GlideException r1, Object r2, Target<R> r3, boolean r4) {
        monitor-enter(this);
        this.loadFailed = true;     // Catch: Throwable -> L8
        this.exception = r1;     // Catch: Throwable -> L8
        this.waiter.notifyAll(this);     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean onResourceReady(R r1, Object r2, Target<R> r3, DataSource r4, boolean r5) {
        monitor-enter(this);
        this.resultReceived = true;     // Catch: Throwable -> L8
        this.resource = r1;     // Catch: Throwable -> L8
        this.waiter.notifyAll(this);     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L8:
        th = move-exception;
        throw th;
    }

    public String toString() {
        String r0 = super.toString() + "[status=";
        monitor-enter(this);
        Request r2 = null;
        if (this.isCancelled == false) goto L8;
        String r1 = "CANCELLED";
    L14:
        monitor-exit(this);     // Catch: Throwable -> L20
        if (r2 == null) goto L19;
        return r0 + r1 + ", request=[" + r2 + "]]";
    L19:
        return r0 + r1 + "]";
    L8:
        if (this.loadFailed == false) goto L11;
        r1 = "FAILURE";
        goto L14
    L11:
        if (this.resultReceived == false) goto L13;
        r1 = "SUCCESS";
        goto L14
    L13:
        r1 = "PENDING";
        r2 = this.request;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }
}
