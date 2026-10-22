package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Notification;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes2.dex */
public final class BlockingFlowableNext<T> implements Iterable<T> {
    final Publisher<? extends T> source;

    public static final class NextIterator<T> implements Iterator<T> {
        private Throwable error;
        private boolean hasNext;
        private boolean isNextConsumed;
        private final Publisher<? extends T> items;
        private T next;
        private boolean started;
        private final NextSubscriber<T> subscriber;

        public NextIterator(Publisher<? extends T> r2, NextSubscriber<T> r3) {
            this.hasNext = true;
            this.isNextConsumed = true;
            this.items = r2;
            this.subscriber = r3;
        }

        private boolean moveToNext() {
        L5:
            e = move-exception;
            this.subscriber.dispose();
            this.error = e;
            throw ExceptionHelper.wrapOrThrow(e);
        L3:
            if (this.started == true) goto L7;
            this.started = true;     // Catch: InterruptedException -> L5
            this.subscriber.setWaiting();     // Catch: InterruptedException -> L5
            Flowable.fromPublisher(this.items).materialize().subscribe(this.subscriber);     // Catch: InterruptedException -> L5
        L7:
            Notification<T> r0 = this.subscriber.takeNext();     // Catch: InterruptedException -> L5
            if (r0.isOnNext() == false) goto L11;
            this.isNextConsumed = false;     // Catch: InterruptedException -> L5
            this.next = r0.getValue();     // Catch: InterruptedException -> L5
            return true;
        L11:
            this.hasNext = false;     // Catch: InterruptedException -> L5
            if (r0.isOnComplete() == false) goto L15;
            return false;
        L15:
            if (r0.isOnError() == false) goto L19;
            Throwable r1 = r0.getError();     // Catch: InterruptedException -> L5
            this.error = r1;     // Catch: InterruptedException -> L5
            throw ExceptionHelper.wrapOrThrow(r1);     // Catch: InterruptedException -> L5
        L19:
            throw new IllegalStateException("Should not reach here");     // Catch: InterruptedException -> L5
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

    public static final class NextSubscriber<T> extends DisposableSubscriber<Notification<T>> {
        private final BlockingQueue<Notification<T>> buf;
        final AtomicInteger waiting;

        public NextSubscriber() {
            this.buf = new ArrayBlockingQueue(1);
            this.waiting = new AtomicInteger();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            RxJavaPlugins.onError(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public /* bridge */ /* synthetic */ void onNext(Object r1) {
            onNext((Notification) r1);
        }

        public void setWaiting() {
            this.waiting.set(1);
        }

        public Notification<T> takeNext() {
            setWaiting();
            BlockingHelper.verifyNonBlocking();
            return this.buf.take();
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
    }

    public BlockingFlowableNext(Publisher<? extends T> r1) {
        this.source = r1;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        NextSubscriber r0 = new NextSubscriber();
        return new NextIterator(this.source, r0);
    }
}
