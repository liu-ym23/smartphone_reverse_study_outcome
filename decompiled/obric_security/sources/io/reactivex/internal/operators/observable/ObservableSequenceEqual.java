package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableSequenceEqual<T> extends Observable<Boolean> {
    final int bufferSize;
    final BiPredicate<? super T, ? super T> comparer;
    final ObservableSource<? extends T> first;
    final ObservableSource<? extends T> second;

    static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = -6178010334400373240L;
        volatile boolean cancelled;
        final BiPredicate<? super T, ? super T> comparer;
        final Observer<? super Boolean> downstream;
        final ObservableSource<? extends T> first;
        final EqualObserver<T>[] observers;
        final ArrayCompositeDisposable resources;
        final ObservableSource<? extends T> second;
        T v1;
        T v2;

        EqualCoordinator(Observer<? super Boolean> r1, int r2, ObservableSource<? extends T> r3, ObservableSource<? extends T> r4, BiPredicate<? super T, ? super T> r5) {
            this.downstream = r1;
            this.first = r3;
            this.second = r4;
            this.comparer = r5;
            this.observers = new EqualObserver[]{new EqualObserver(this, 0, r2), new EqualObserver(this, 1, r2)};
            this.resources = new ArrayCompositeDisposable(2);
        }

        boolean setDisposable(Disposable r1, int r2) {
            return this.resources.setResource(r2, r1);
        }

        void subscribe() {
            EqualObserver<T>[] r0 = this.observers;
            this.first.subscribe(r0[0]);
            this.second.subscribe(r0[1]);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            this.resources.dispose();
            if (getAndIncrement() != 0) goto L9;
            EqualObserver<T>[] r2 = this.observers;
            r2[0].queue.clear();
            r2[1].queue.clear();
            return;
        L9:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        void cancel(SpscLinkedArrayQueue<T> r2, SpscLinkedArrayQueue<T> r3) {
            this.cancelled = true;
            r2.clear();
            r3.clear();
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            EqualObserver<T>[] r0 = this.observers;
            EqualObserver<T> r2 = r0[0];
            SpscLinkedArrayQueue<T> r3 = r2.queue;
            EqualObserver<T> r1 = r0[1];
            SpscLinkedArrayQueue<T> r5 = r1.queue;
            int r6 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            boolean r7 = r2.done;
            if (r7 == false) goto L16;
            Throwable r8 = r2.error;
            if (r8 == null) goto L16;
            cancel(r3, r5);
            this.downstream.onError(r8);
            return;
        L16:
            boolean r9 = r1.done;
            if (r9 == false) goto L23;
            Throwable r10 = r1.error;
            if (r10 == null) goto L23;
            cancel(r3, r5);
            this.downstream.onError(r10);
            return;
        L23:
            if (this.v1 != null) goto L26;
            this.v1 = r3.poll();
        L26:
            if (this.v1 != null) goto L28;
            boolean r11 = true;
        L30:
            if (this.v2 != null) goto L32;
            this.v2 = r5.poll();
        L32:
            T r12 = this.v2;
            if (r12 != null) goto L35;
            boolean r13 = true;
        L36:
            if (r7 == false) goto L42;
            if (r9 == false) goto L42;
            if (r11 == false) goto L42;
            if (r13 == false) goto L42;
            this.downstream.onNext(true);
            this.downstream.onComplete();
            return;
        L42:
            if (r7 == false) goto L47;
            if (r9 == false) goto L47;
            if (r11 == r13) goto L47;
            cancel(r3, r5);
            this.downstream.onNext(false);
            this.downstream.onComplete();
            return;
        L47:
            if (r11 == true) goto L57;
            if (r13 == true) goto L57;
            if (this.comparer.test(this.v1, r12) == false) goto L51;
            this.v1 = null;
            this.v2 = null;
            goto L57
        L51:
            cancel(r3, r5);
            this.downstream.onNext(false);
            this.downstream.onComplete();
            return;
        L54:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel(r3, r5);
            this.downstream.onError(th);
            return;
        L57:
            if (r11 == true) goto L59;
            if (r13 == false) goto L7;
        L59:
            r6 = addAndGet(-r6);
            if (r6 != 0) goto L7;
            return;
        L35:
            r13 = false;
            goto L36
        L28:
            r11 = false;
            goto L30
        L8:
            r3.clear();
            r5.clear();
        }
    }

    static final class EqualObserver<T> implements Observer<T> {
        volatile boolean done;
        Throwable error;
        final int index;
        final EqualCoordinator<T> parent;
        final SpscLinkedArrayQueue<T> queue;

        EqualObserver(EqualCoordinator<T> r1, int r2, int r3) {
            this.parent = r1;
            this.index = r2;
            this.queue = new SpscLinkedArrayQueue(r3);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            this.parent.setDisposable(r2, this.index);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            this.queue.offer(r2);
            this.parent.drain();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            this.error = r1;
            this.done = true;
            this.parent.drain();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }
    }

    public ObservableSequenceEqual(ObservableSource<? extends T> r1, ObservableSource<? extends T> r2, BiPredicate<? super T, ? super T> r3, int r4) {
        this.first = r1;
        this.second = r2;
        this.comparer = r3;
        this.bufferSize = r4;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Boolean> r8) {
        EqualCoordinator r6 = new EqualCoordinator(r8, this.bufferSize, this.first, this.second, this.comparer);
        r8.onSubscribe(r6);
        r6.subscribe();
    }
}
