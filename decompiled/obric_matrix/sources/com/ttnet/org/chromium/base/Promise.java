package com.ttnet.org.chromium.base;

import android.os.Handler;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class Promise<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final List<Callback<T>> mFulfillCallbacks;
    private final Handler mHandler;
    private final List<Callback<Exception>> mRejectCallbacks;
    private Exception mRejectReason;
    private T mResult;
    private int mState;
    private final Thread mThread;
    private boolean mThrowingRejectionHandler;

    public interface AsyncFunction<A, RT> extends Function<A, Promise<RT>> {
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface PromiseState {
        public static final int FULFILLED = 1;
        public static final int REJECTED = 2;
        public static final int UNFULFILLED = 0;
    }

    public static class UnhandledRejectionException extends RuntimeException {
        public UnhandledRejectionException(String r1, Throwable r2) {
            super(r1, r2);
        }
    }

    static {
    }

    public Promise() {
        this.mState = 0;
        this.mFulfillCallbacks = new LinkedList();
        this.mRejectCallbacks = new LinkedList();
        this.mThread = Thread.currentThread();
        this.mHandler = new Handler();
    }

    static /* synthetic */ void a(Exception r2) {
        throw new UnhandledRejectionException("Promise was rejected without a rejection handler.", r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void b(Promise r0, Function r1, Object r2) {
        r0.fulfill(r1.apply(r2));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        r0.reject(e);
    }

    static /* synthetic */ void c(AsyncFunction r1, final Promise r2, Object r3) {
        Promise r4 = r1.apply(r3);     // Catch: Exception -> L4
        Objects.requireNonNull(r2);     // Catch: Exception -> L4
        Callback<T> r5 = new a(r2);     // Catch: Exception -> L4
        Objects.requireNonNull(r2);     // Catch: Exception -> L4
        r4.then(r5, new d(r2));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        r2.reject(e);
    }

    private void checkThread() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void exceptInner(Callback<Exception> r3) {
        int r0 = this.mState;
        if (r0 != 2) goto L5;
        postCallbackToLooper(r3, this.mRejectReason);
        return;
    L5:
        if (r0 != 0) goto L9;
        this.mRejectCallbacks.add(r3);
        return;
    }

    public static <T> Promise<T> fulfilled(T r1) {
        Promise<T> r0 = new Promise();
        r0.fulfill(r1);
        return r0;
    }

    private <S> void postCallbackToLooper(Callback<S> r1, S r2) {
        this.mHandler.post(r1.bind(r2));
    }

    public static <T> Promise<T> rejected() {
        Promise<T> r0 = new Promise();
        r0.reject();
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void thenInner(Callback<T> r3) {
        int r0 = this.mState;
        if (r0 != 1) goto L5;
        postCallbackToLooper(r3, this.mResult);
        return;
    L5:
        if (r0 != 0) goto L9;
        this.mFulfillCallbacks.add(r3);
        return;
    }

    public void except(Callback<Exception> r1) {
        checkThread();
        exceptInner(r1);
    }

    public void fulfill(T r3) {
        checkThread();
        this.mState = 1;
        this.mResult = r3;
        Iterator<Callback<T>> r0 = this.mFulfillCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        postCallbackToLooper(r0.next(), r3);
        goto L4
    L6:
        this.mFulfillCallbacks.clear();
    }

    public T getResult() {
        return this.mResult;
    }

    public boolean isFulfilled() {
        checkThread();
        if (this.mState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isRejected() {
        checkThread();
        if (this.mState != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public void reject() {
        reject(null);
    }

    public void reject(Exception r3) {
        checkThread();
        this.mState = 2;
        this.mRejectReason = r3;
        Iterator<Callback<Exception>> r0 = this.mRejectCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        postCallbackToLooper((Callback) r0.next(), r3);
        goto L4
    L6:
        this.mRejectCallbacks.clear();
    }

    public <RT> Promise<RT> then(final Function<T, RT> r3) {
        checkThread();
        final Promise<RT> r0 = new Promise();
        thenInner(new g(r0, r3));
        exceptInner(new d(r0));
        return r0;
    }

    public <RT> Promise<RT> then(final AsyncFunction<T, RT> r3) {
        checkThread();
        final Promise<RT> r0 = new Promise();
        thenInner(new h(r3, r0));
        exceptInner(new d(r0));
        return r0;
    }

    public void then(Callback<T> r2) {
        checkThread();
        if (this.mThrowingRejectionHandler == false) goto L6;
        thenInner(r2);
        return;
    L6:
        then(r2, i.f12345f);
        this.mThrowingRejectionHandler = true;
    }

    public void then(Callback<T> r1, Callback<Exception> r2) {
        checkThread();
        thenInner(r1);
        exceptInner(r2);
    }
}
