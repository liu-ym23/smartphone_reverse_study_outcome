package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class UnicastSubject<T> extends Subject<T> {
    final boolean delayError;
    volatile boolean disposed;
    volatile boolean done;
    final AtomicReference<Observer<? super T>> downstream;
    boolean enableOperatorFusion;
    Throwable error;
    final AtomicReference<Runnable> onTerminate;
    final AtomicBoolean once;
    final SpscLinkedArrayQueue<T> queue;
    final BasicIntQueueDisposable<T> wip;

    final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;
        final /* synthetic */ UnicastSubject this$0;

        UnicastQueueDisposable(UnicastSubject r1) {
            this.this$0 = r1;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r2) {
            if ((r2 & 2) == 0) goto L6;
            this.this$0.enableOperatorFusion = true;
            return 2;
        L6:
            return 0;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            return this.this$0.queue.poll();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.this$0.queue.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.this$0.queue.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.this$0.disposed == true) goto L8;
            this.this$0.disposed = true;
            this.this$0.doTerminate();
            this.this$0.downstream.lazySet(null);
            if (this.this$0.wip.getAndIncrement() != 0) goto L9;
            this.this$0.downstream.lazySet(null);
            this.this$0.queue.clear();
            return;
        L9:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.this$0.disposed;
        }
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create() {
        return new UnicastSubject(bufferSize(), true);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create(int r2) {
        return new UnicastSubject(r2, true);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create(int r2, Runnable r3) {
        return new UnicastSubject(r2, r3, true);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create(int r1, Runnable r2, boolean r3) {
        return new UnicastSubject(r1, r2, r3);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create(boolean r2) {
        return new UnicastSubject(bufferSize(), r2);
    }

    UnicastSubject(int r3, boolean r4) {
        this.queue = new SpscLinkedArrayQueue(ObjectHelper.verifyPositive(r3, "capacityHint"));
        this.onTerminate = new AtomicReference();
        this.delayError = r4;
        this.downstream = new AtomicReference();
        this.once = new AtomicBoolean();
        this.wip = new UnicastQueueDisposable(this);
    }

    UnicastSubject(int r2, Runnable r3) {
        this(r2, r3, true);
    }

    UnicastSubject(int r3, Runnable r4, boolean r5) {
        this.queue = new SpscLinkedArrayQueue(ObjectHelper.verifyPositive(r3, "capacityHint"));
        this.onTerminate = new AtomicReference(ObjectHelper.requireNonNull(r4, "onTerminate"));
        this.delayError = r5;
        this.downstream = new AtomicReference();
        this.once = new AtomicBoolean();
        this.wip = new UnicastQueueDisposable(this);
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> r4) {
        if (this.once.get() == false) goto L5;
    L11:
        EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), r4);
        return;
    L5:
        if (this.once.compareAndSet(false, true) == false) goto L11;
        r4.onSubscribe(this.wip);
        this.downstream.lazySet(r4);
        if (this.disposed == false) goto L10;
        this.downstream.lazySet(null);
        return;
    L10:
        drain();
    }

    void doTerminate() {
        Runnable r0 = this.onTerminate.get();
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.onTerminate.compareAndSet(r0, null) == false) goto L9;
        r0.run();
        return;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r2) {
        if (this.done == false) goto L5;
    L6:
        r2.dispose();
        return;
    L5:
        if (this.disposed == true) goto L6;
    }

    @Override // io.reactivex.Observer
    public void onNext(T r2) {
        ObjectHelper.requireNonNull(r2, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.done == false) goto L5;
        return;
    L5:
        if (this.disposed == true) goto L10;
        this.queue.offer(r2);
        drain();
        return;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r2) {
        ObjectHelper.requireNonNull(r2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.done == false) goto L5;
    L9:
        RxJavaPlugins.onError(r2);
        return;
    L5:
        if (this.disposed == true) goto L9;
        this.error = r2;
        this.done = true;
        doTerminate();
        drain();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        if (this.disposed == true) goto L10;
        this.done = true;
        doTerminate();
        drain();
        return;
    }

    void drainNormal(Observer<? super T> r10) {
        SpscLinkedArrayQueue<T> r0 = this.queue;
        boolean r1 = !this.delayError;
        boolean r3 = true;
        int r4 = 1;
    L4:
        if (this.disposed == true) goto L5;
        boolean r5 = this.done;
        T r6 = this.queue.poll();
        if (r6 != null) goto L10;
        boolean r8 = true;
    L11:
        if (r5 == false) goto L21;
        if (r1 == false) goto L18;
        if (r3 == false) goto L18;
        if (failedFast(r0, r10) == true) goto L16;
        r3 = false;
        goto L18
    L16:
        return;
    L18:
        if (r8 == false) goto L21;
        errorOrComplete(r10);
        return;
    L21:
        if (r8 == true) goto L22;
        r10.onNext(r6);
        goto L4
    L22:
        r4 = this.wip.addAndGet(-r4);
        if (r4 != 0) goto L4;
        return;
    L10:
        r8 = false;
        goto L11
    L5:
        this.downstream.lazySet(null);
        r0.clear();
    }

    void drainFused(Observer<? super T> r7) {
        SpscLinkedArrayQueue<T> r0 = this.queue;
        int r2 = 1;
        boolean r1 = !this.delayError;
    L4:
        if (this.disposed == true) goto L5;
        boolean r3 = this.done;
        if (r1 == false) goto L13;
        if (r3 == false) goto L13;
        if (failedFast(r0, r7) == false) goto L13;
        return;
    L13:
        r7.onNext(null);
        if (r3 == true) goto L15;
        r2 = this.wip.addAndGet(-r2);
        if (r2 != 0) goto L4;
        return;
    L15:
        errorOrComplete(r7);
        return;
    L5:
        this.downstream.lazySet(null);
        r0.clear();
    }

    void errorOrComplete(Observer<? super T> r3) {
        this.downstream.lazySet(null);
        Throwable r2 = this.error;
        if (r2 == null) goto L5;
        r3.onError(r2);
        return;
    L5:
        r3.onComplete();
    }

    boolean failedFast(SimpleQueue<T> r3, Observer<? super T> r4) {
        Throwable r0 = this.error;
        if (r0 == null) goto L6;
        this.downstream.lazySet(null);
        r3.clear();
        r4.onError(r0);
        return true;
    L6:
        return false;
    }

    void drain() {
        if (this.wip.getAndIncrement() == 0) goto L5;
        return;
    L5:
        Observer<? super T> r0 = this.downstream.get();
        int r1 = 1;
    L6:
        if (r0 != null) goto L8;
        r1 = this.wip.addAndGet(-r1);
        if (r1 == 0) goto L14;
        r0 = this.downstream.get();
        goto L6
    L14:
        return;
    L8:
        if (this.enableOperatorFusion == false) goto L10;
        drainFused(r0);
        return;
    L10:
        drainNormal(r0);
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        if (this.downstream.get() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.subjects.Subject
    public Throwable getThrowable() {
        if (this.done == true) goto L5;
        return null;
    L5:
        return this.error;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        if (this.done == true) goto L5;
    L7:
        return false;
    L5:
        if (this.error == null) goto L7;
        return true;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        if (this.done == true) goto L5;
    L7:
        return false;
    L5:
        if (this.error != null) goto L7;
        return true;
    }
}
