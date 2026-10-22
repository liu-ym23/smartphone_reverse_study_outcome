package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableTakeLastTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final int bufferSize;
    final long count;
    final boolean delayError;
    final Scheduler scheduler;
    final long time;
    final TimeUnit unit;

    static final class TakeLastTimedObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final long count;
        final boolean delayError;
        final Observer<? super T> downstream;
        Throwable error;
        final SpscLinkedArrayQueue<Object> queue;
        final Scheduler scheduler;
        final long time;
        final TimeUnit unit;
        Disposable upstream;

        TakeLastTimedObserver(Observer<? super T> r1, long r2, long r4, TimeUnit r6, Scheduler r7, int r8, boolean r9) {
            this.downstream = r1;
            this.count = r2;
            this.time = r4;
            this.unit = r6;
            this.scheduler = r7;
            this.queue = new SpscLinkedArrayQueue(r8);
            this.delayError = r9;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r13) {
            SpscLinkedArrayQueue<Object> r0 = this.queue;
            long r1 = this.scheduler.now(this.unit);
            long r3 = this.time;
            long r5 = this.count;
            if (r5 != Long.MAX_VALUE) goto L5;
            boolean r12 = true;
        L6:
            r0.offer(Long.valueOf(r1), r13);
        L8:
            if (r0.isEmpty() == true) goto L15;
            if (((Long) r0.peek()).longValue() <= (r1 - r3)) goto L14;
            if (r12 == true) goto L21;
            if ((r0.size() >> 1) > r5) goto L14;
            return;
        L21:
            return;
        L14:
            r0.poll();
            r0.poll();
            goto L8
        L15:
            return;
        L5:
            r12 = false;
            goto L6
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            this.error = r1;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            this.upstream.dispose();
            if (compareAndSet(false, true) == false) goto L9;
            this.queue.clear();
            return;
        L9:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        void drain() {
            if (compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            Observer<? super T> r2 = this.downstream;
            SpscLinkedArrayQueue<Object> r3 = this.queue;
            boolean r4 = this.delayError;
        L7:
            if (this.cancelled == true) goto L8;
            if (r4 == true) goto L15;
            Throwable r5 = this.error;
            if (r5 == null) goto L15;
            r3.clear();
            r2.onError(r5);
            return;
        L15:
            Object r6 = r3.poll();
            if (r6 != null) goto L18;
            boolean r7 = true;
        L19:
            if (r7 == true) goto L20;
            Object r8 = r3.poll();
            if (((Long) r6).longValue() < (this.scheduler.now(this.unit) - this.time)) goto L7;
            r2.onNext(r8);
            goto L7
        L20:
            Throwable r13 = this.error;
            if (r13 == null) goto L23;
            r2.onError(r13);
            return;
        L23:
            r2.onComplete();
            return;
        L18:
            r7 = false;
            goto L19
        L8:
            r3.clear();
        }
    }

    public ObservableTakeLastTimed(ObservableSource<T> r1, long r2, long r4, TimeUnit r6, Scheduler r7, int r8, boolean r9) {
        super(r1);
        this.count = r2;
        this.time = r4;
        this.unit = r6;
        this.scheduler = r7;
        this.bufferSize = r8;
        this.delayError = r9;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r13) {
        this.source.subscribe(new TakeLastTimedObserver(r13, this.count, this.time, this.unit, this.scheduler, this.bufferSize, this.delayError));
    }
}
