package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class BlockingObservableNext<T> implements Iterable<T> {
    final ObservableSource<T> source;

    static final class NextIterator<T> implements Iterator<T> {
        private Throwable error;
        private boolean hasNext;
        private boolean isNextConsumed;
        private final ObservableSource<T> items;
        private T next;
        private final NextObserver<T> observer;
        private boolean started;

        NextIterator(ObservableSource<T> r2, NextObserver<T> r3) {
            this.hasNext = true;
            this.isNextConsumed = true;
            this.items = r2;
            this.observer = r3;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable r0 = this.error;
            if (r0 != null) goto L14;
            if (this.hasNext == true) goto L8;
            return false;
        L8:
            if (this.isNextConsumed == true) goto L10;
        L11:
            return true;
        L10:
            if (moveToNext() == true) goto L11;
            return false;
        L14:
            throw ExceptionHelper.wrapOrThrow(r0);
        }

        private boolean moveToNext() {
            if (this.started == true) goto L18;
            this.started = true;
            this.observer.setWaiting();
            new ObservableMaterialize(this.items).subscribe(this.observer);
        L18:
            Notification<T> r0 = this.observer.takeNext();     // Catch: InterruptedException -> L15
            if (r0.isOnNext() == false) goto L10;
            this.isNextConsumed = false;
            this.next = r0.getValue();
            return true;
        L10:
            this.hasNext = false;
            if (r0.isOnComplete() == false) goto L13;
            return false;
        L13:
            Throwable r1 = r0.getError();
            this.error = r1;
            throw ExceptionHelper.wrapOrThrow(r1);
        L15:
            e = move-exception;
            this.observer.dispose();
            this.error = e;
            throw ExceptionHelper.wrapOrThrow(e);
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable r0 = this.error;
            if (r0 != null) goto L11;
            if (hasNext() == false) goto L9;
            this.isNextConsumed = true;
            return this.next;
        L9:
            throw new NoSuchElementException("No more elements");
        L11:
            throw ExceptionHelper.wrapOrThrow(r0);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    static final class NextObserver<T> extends DisposableObserver<Notification<T>> {
        private final BlockingQueue<Notification<T>> buf;
        final AtomicInteger waiting;

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        NextObserver() {
            this.buf = new ArrayBlockingQueue(1);
            this.waiting = new AtomicInteger();
        }

        @Override // io.reactivex.Observer
        public /* bridge */ /* synthetic */ void onNext(Object r1) {
            onNext((Notification) r1);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            RxJavaPlugins.onError(r1);
        }

        public void onNext(Notification<T> r3) {
            if (this.waiting.getAndSet(0) == 1) goto L7;
            if (r3.isOnNext() == false) goto L7;
            return;
        L7:
            if (this.buf.offer(r3) == true) goto L22;
            Notification<T> r0 = this.buf.poll();
            if (r0 == null) goto L7;
            if (r0.isOnNext() == true) goto L7;
            r3 = r0;
            goto L7
        }

        public Notification<T> takeNext() throws InterruptedException {
            setWaiting();
            BlockingHelper.verifyNonBlocking();
            return this.buf.take();
        }

        void setWaiting() {
            this.waiting.set(1);
        }
    }

    public BlockingObservableNext(ObservableSource<T> r1) {
        this.source = r1;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        NextObserver r0 = new NextObserver();
        return new NextIterator(this.source, r0);
    }
}
