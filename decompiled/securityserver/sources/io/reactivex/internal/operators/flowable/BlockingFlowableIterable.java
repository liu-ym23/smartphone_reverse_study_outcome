package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class BlockingFlowableIterable<T> implements Iterable<T> {
    final int bufferSize;
    final Flowable<T> source;

    public static final class BlockingFlowableIterator<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Iterator<T>, Runnable, Disposable {
        private static final long serialVersionUID = 6695226475494099826L;
        final long batchSize;
        final Condition condition;
        volatile boolean done;
        volatile Throwable error;
        final long limit;
        final Lock lock;
        long produced;
        final SpscArrayQueue<T> queue;

        public BlockingFlowableIterator(int r3) {
            this.queue = new SpscArrayQueue(r3);
            this.batchSize = r3;
            this.limit = r3 - (r3 >> 2);
            ReentrantLock r4 = new ReentrantLock();
            this.lock = r4;
            this.condition = r4.newCondition();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SubscriptionHelper.cancel(this);
            signalConsumer();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
        L3:
            if (isDisposed() == true) goto L4;
            boolean r0 = this.done;
            boolean r2 = this.queue.isEmpty();
            if (r0 == false) goto L17;
            Throwable r1 = this.error;
            if (r1 != null) goto L16;
            if (r2 == false) goto L17;
            return false;
        L16:
            throw ExceptionHelper.wrapOrThrow(r1);
        L17:
            if (r2 == false) goto L36;
            BlockingHelper.verifyNonBlocking();
            this.lock.lock();
        L38:
        L27:
            th = move-exception;
            this.lock.unlock();
            throw th;
        L29:
            e = move-exception;
            run();     // Catch: Throwable -> L27
            throw ExceptionHelper.wrapOrThrow(e);     // Catch: Throwable -> L27
        L20:
            if (this.done == true) goto L31;
            if (this.queue.isEmpty() == false) goto L31;
            if (isDisposed() == true) goto L31;
            this.condition.await();     // Catch: Throwable -> L27 InterruptedException -> L29
        L31:
            this.lock.unlock();
            goto L3
        L36:
            return true;
        L4:
            Throwable r3 = this.error;
            if (r3 != null) goto L8;
            return false;
        L8:
            throw ExceptionHelper.wrapOrThrow(r3);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() != SubscriptionHelper.CANCELLED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext() == false) goto L10;
            T r0 = this.queue.poll();
            long r1 = this.produced + 1;
            if (r1 != this.limit) goto L7;
            this.produced = 0;
            get().request(r1);
        L8:
            return r0;
        L7:
            this.produced = r1;
            goto L8
        L10:
            throw new NoSuchElementException();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            signalConsumer();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            this.error = r1;
            this.done = true;
            signalConsumer();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r2) {
            if (this.queue.offer(r2) == true) goto L5;
            SubscriptionHelper.cancel(this);
            onError(new MissingBackpressureException("Queue full?!"));
            return;
        L5:
            signalConsumer();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            SubscriptionHelper.setOnce(this, r3, this.batchSize);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.lang.Runnable
        public void run() {
            SubscriptionHelper.cancel(this);
            signalConsumer();
        }

        public void signalConsumer() {
            this.lock.lock();
            this.condition.signalAll();     // Catch: Throwable -> L6
            this.lock.unlock();
            return;
        L6:
            th = move-exception;
            this.lock.unlock();
            throw th;
        }
    }

    public BlockingFlowableIterable(Flowable<T> r1, int r2) {
        this.source = r1;
        this.bufferSize = r2;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        BlockingFlowableIterator r0 = new BlockingFlowableIterator(this.bufferSize);
        this.source.subscribe(r0);
        return r0;
    }
}
