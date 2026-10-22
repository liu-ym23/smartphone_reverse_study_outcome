package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableSkipLastTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final int bufferSize;
    final boolean delayError;
    final Scheduler scheduler;
    final long time;
    final TimeUnit unit;

    public static final class SkipLastTimedObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        final Observer<? super T> downstream;
        Throwable error;
        final SpscLinkedArrayQueue<Object> queue;
        final Scheduler scheduler;
        final long time;
        final TimeUnit unit;
        Disposable upstream;

        public SkipLastTimedObserver(Observer<? super T> r1, long r2, TimeUnit r4, Scheduler r5, int r6, boolean r7) {
            this.downstream = r1;
            this.time = r2;
            this.unit = r4;
            this.scheduler = r5;
            this.queue = new SpscLinkedArrayQueue(r6);
            this.delayError = r7;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            this.upstream.dispose();
            if (getAndIncrement() != 0) goto L9;
            this.queue.clear();
            return;
        L9:
            return;
        }

        public void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            Observer<? super T> r1 = this.downstream;
            SpscLinkedArrayQueue<Object> r2 = this.queue;
            boolean r3 = this.delayError;
            TimeUnit r4 = this.unit;
            Scheduler r5 = this.scheduler;
            long r6 = this.time;
            int r9 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            boolean r10 = this.done;
            Long r11 = (Long) r2.peek();
            if (r11 != null) goto L13;
            boolean r12 = true;
        L14:
            long r13 = r5.now(r4);
            if (r12 == false) goto L17;
        L19:
            if (r10 == false) goto L34;
            if (r3 == false) goto L27;
            if (r12 == false) goto L34;
            Throwable r0 = this.error;
            if (r0 == null) goto L25;
            r1.onError(r0);
            return;
        L25:
            r1.onComplete();
            return;
        L27:
            Throwable r14 = this.error;
            if (r14 != null) goto L29;
            if (r12 == false) goto L34;
            r1.onComplete();
            return;
        L29:
            this.queue.clear();
            r1.onError(r14);
            return;
        L34:
            if (r12 == true) goto L35;
            r2.poll();
            r1.onNext(r2.poll());
            goto L7
        L35:
            r9 = addAndGet(-r9);
            if (r9 != 0) goto L7;
            return;
        L17:
            if (r11.longValue() <= (r13 - r6)) goto L19;
            r12 = true;
            goto L19
        L13:
            r12 = false;
            goto L14
        L8:
            this.queue.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            this.error = r1;
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onNext(T r4) {
            this.queue.offer(Long.valueOf(this.scheduler.now(this.unit)), r4);
            drain();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }
    }

    public ObservableSkipLastTimed(ObservableSource<T> r1, long r2, TimeUnit r4, Scheduler r5, int r6, boolean r7) {
        super(r1);
        this.time = r2;
        this.unit = r4;
        this.scheduler = r5;
        this.bufferSize = r6;
        this.delayError = r7;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r11) {
        this.source.subscribe(new SkipLastTimedObserver(r11, this.time, this.unit, this.scheduler, this.bufferSize, this.delayError));
    }
}
