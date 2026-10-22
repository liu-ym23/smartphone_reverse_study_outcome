package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableObserveOn<T> extends AbstractObservableWithUpstream<T, T> {
    final int bufferSize;
    final boolean delayError;
    final Scheduler scheduler;

    static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        final int bufferSize;
        final boolean delayError;
        volatile boolean disposed;
        volatile boolean done;
        final Observer<? super T> downstream;
        Throwable error;
        boolean outputFused;
        SimpleQueue<T> queue;
        int sourceMode;
        Disposable upstream;
        final Scheduler.Worker worker;

        ObserveOnObserver(Observer<? super T> r1, Scheduler.Worker r2, boolean r3, int r4) {
            this.downstream = r1;
            this.worker = r2;
            this.delayError = r3;
            this.bufferSize = r4;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r3) {
            if (DisposableHelper.validate(this.upstream, r3) == false) goto L16;
            this.upstream = r3;
            if ((r3 instanceof QueueDisposable) == false) goto L14;
            QueueDisposable r4 = (QueueDisposable) r3;
            int r0 = r4.requestFusion(7);
            if (r0 != 1) goto L11;
            this.sourceMode = r0;
            this.queue = r4;
            this.done = true;
            this.downstream.onSubscribe(this);
            schedule();
            return;
        L11:
            if (r0 != 2) goto L14;
            this.sourceMode = r0;
            this.queue = r4;
            this.downstream.onSubscribe(this);
            return;
        L14:
            this.queue = new SpscLinkedArrayQueue(this.bufferSize);
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r3) {
            if (this.done == false) goto L6;
            return;
        L6:
            if (this.sourceMode == 2) goto L8;
            this.queue.offer(r3);
        L8:
            schedule();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.error = r2;
            this.done = true;
            schedule();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            schedule();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.disposed == true) goto L8;
            this.disposed = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (getAndIncrement() != 0) goto L9;
            this.queue.clear();
            return;
        L9:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        void schedule() {
            if (getAndIncrement() != 0) goto L6;
            this.worker.schedule(this);
            return;
        }

        void drainNormal() {
            SimpleQueue<T> r0 = this.queue;
            Observer<? super T> r1 = this.downstream;
            int r3 = 1;
        L4:
            if (checkTerminated(this.done, r0.isEmpty(), r1) == true) goto L5;
        L6:
            boolean r4 = this.done;
            T r5 = r0.poll();     // Catch: Throwable -> L19
            if (r5 != null) goto L10;
            boolean r6 = true;
        L12:
            if (checkTerminated(r4, r6, r1) == true) goto L13;
            if (r6 == true) goto L15;
            r1.onNext(r5);
            goto L6
        L15:
            r3 = addAndGet(-r3);
            if (r3 != 0) goto L4;
            return;
        L13:
            return;
        L10:
            r6 = false;
        L19:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.disposed = true;
            this.upstream.dispose();
            r0.clear();
            r1.onError(th);
            this.worker.dispose();
            return;
        }

        void drainFused() {
            int r1 = 1;
        L4:
            if (this.disposed == true) goto L5;
            boolean r2 = this.done;
            Throwable r3 = this.error;
            if (this.delayError == true) goto L12;
            if (r2 == false) goto L12;
            if (r3 == null) goto L12;
            this.disposed = true;
            this.downstream.onError(this.error);
            this.worker.dispose();
            return;
        L12:
            this.downstream.onNext(null);
            if (r2 == true) goto L14;
            r1 = addAndGet(-r1);
            if (r1 != 0) goto L4;
            return;
        L14:
            this.disposed = true;
            Throwable r0 = this.error;
            if (r0 == null) goto L17;
            this.downstream.onError(r0);
        L18:
            this.worker.dispose();
            return;
        L17:
            this.downstream.onComplete();
            goto L18
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.outputFused == false) goto L5;
            drainFused();
            return;
        L5:
            drainNormal();
        }

        boolean checkTerminated(boolean r3, boolean r4, Observer<? super T> r5) {
            if (this.disposed == false) goto L6;
            this.queue.clear();
            return true;
        L6:
            if (r3 == false) goto L22;
            Throwable r6 = this.error;
            if (this.delayError == false) goto L16;
            if (r4 == false) goto L24;
            this.disposed = true;
            if (r6 == null) goto L13;
            r5.onError(r6);
        L14:
            this.worker.dispose();
            return true;
        L13:
            r5.onComplete();
            goto L14
        L24:
            return false;
        L16:
            if (r6 == null) goto L19;
            this.disposed = true;
            this.queue.clear();
            r5.onError(r6);
            this.worker.dispose();
            return true;
        L19:
            if (r4 == false) goto L25;
            this.disposed = true;
            r5.onComplete();
            this.worker.dispose();
            return true;
        L25:
            return false;
        L22:
            return false;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r2) {
            if ((r2 & 2) == 0) goto L6;
            this.outputFused = true;
            return 2;
        L6:
            return 0;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            return this.queue.poll();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }
    }

    public ObservableObserveOn(ObservableSource<T> r1, Scheduler r2, boolean r3, int r4) {
        super(r1);
        this.scheduler = r2;
        this.delayError = r3;
        this.bufferSize = r4;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> r5) {
        Scheduler r0 = this.scheduler;
        if ((r0 instanceof TrampolineScheduler) == false) goto L5;
        this.source.subscribe(r5);
        return;
    L5:
        Scheduler.Worker r1 = r0.createWorker();
        this.source.subscribe(new ObserveOnObserver(r5, r1, this.delayError, this.bufferSize));
    }
}
