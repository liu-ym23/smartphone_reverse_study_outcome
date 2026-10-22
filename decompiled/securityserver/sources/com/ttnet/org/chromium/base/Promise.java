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
    public @interface PromiseState {
        public static final int FULFILLED = 1;
        public static final int REJECTED = 2;
        public static final int UNFULFILLED = 0;
    }

    public static class UnhandledRejectionException extends RuntimeException {
        public UnhandledRejectionException(String r1, Throwable r2) {
            super(r1, r2);
        }
    }

    public Promise() {
        this.mState = 0;
        this.mFulfillCallbacks = new LinkedList();
        this.mRejectCallbacks = new LinkedList();
        this.mThread = Thread.currentThread();
        this.mHandler = new Handler();
    }

    public static /* synthetic */ void a(AsyncFunction r0, Promise r1, Object r2) {
        lambda$then$2(r0, r1, r2);
    }

    public static /* synthetic */ void b(Exception r0) {
        lambda$then$0(r0);
    }

    public static /* synthetic */ void c(Promise r0, Function r1, Object r2) {
        lambda$then$1(r0, r1, r2);
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

    private static /* synthetic */ void lambda$then$0(Exception r2) {
        throw new UnhandledRejectionException("Promise was rejected without a rejection handler.", r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static /* synthetic */ void lambda$then$1(Promise r0, Function r1, Object r2) {
        r0.fulfill(r1.apply(r2));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        r0.reject(e);
    }

    private static /* synthetic */ void lambda$then$2(AsyncFunction r2, Promise r3, Object r4) {
        Promise r5 = r2.apply(r4);     // Catch: Exception -> L4
        Objects.requireNonNull(r3);     // Catch: Exception -> L4
        r5.then(new e(r3, 1), new e(r3, 0));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        r3.reject(e);
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

    public void then(Callback<T> r2) {
        checkThread();
        if (this.mThrowingRejectionHandler == false) goto L6;
        thenInner(r2);
        return;
    L6:
        then(r2, new f());
        this.mThrowingRejectionHandler = true;
    }

    public void reject() {
        reject(null);
    }

    public void then(Callback<T> r1, Callback<Exception> r2) {
        checkThread();
        thenInner(r1);
        exceptInner(r2);
    }

    public <RT> Promise<RT> then(Function<T, RT> r3) {
        checkThread();
        Promise<RT> r0 = new Promise();
        thenInner(new d(r0, r3));
        exceptInner(new e(r0, 0));
        return r0;
    }

    public <RT> Promise<RT> then(AsyncFunction<T, RT> r3) {
        checkThread();
        Promise<RT> r0 = new Promise();
        thenInner(new d(r3, r0));
        exceptInner(new e(r0, 0));
        return r0;
    }
}
