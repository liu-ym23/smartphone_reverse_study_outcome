package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes5.dex */
public final class BlockingObservableIterable<T> implements Iterable<T> {
    final int bufferSize;
    final ObservableSource<? extends T> source;

    static final class BlockingObservableIterator<T> extends AtomicReference<Disposable> implements Observer<T>, Iterator<T>, Disposable {
        private static final long serialVersionUID = 6695226475494099826L;
        final Condition condition;
        volatile boolean done;
        volatile Throwable error;
        final Lock lock;
        final SpscLinkedArrayQueue<T> queue;

        BlockingObservableIterator(int r2) {
            this.queue = new SpscLinkedArrayQueue(r2);
            ReentrantLock r3 = new ReentrantLock();
            this.lock = r3;
            this.condition = r3.newCondition();
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
            if (r2 == false) goto L34;
            BlockingHelper.verifyNonBlocking();     // Catch: InterruptedException -> L31
            this.lock.lock();     // Catch: InterruptedException -> L31
        L38:
        L28:
            th = move-exception;
            this.lock.unlock();     // Catch: InterruptedException -> L31
            throw th;     // Catch: InterruptedException -> L31
        L20:
            if (this.done == true) goto L27;
            if (this.queue.isEmpty() == false) goto L27;
            if (isDisposed() == true) goto L27;
            this.condition.await();     // Catch: Throwable -> L28
        L27:
            this.lock.unlock();     // Catch: InterruptedException -> L31
        L31:
            e = move-exception;
            DisposableHelper.dispose(this);
            signalConsumer();
            throw ExceptionHelper.wrapOrThrow(e);
        L34:
            return true;
        L4:
            Throwable r3 = this.error;
            if (r3 != null) goto L8;
            return false;
        L8:
            throw ExceptionHelper.wrapOrThrow(r3);
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext() == false) goto L7;
            return this.queue.poll();
        L7:
            throw new NoSuchElementException();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this, r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            this.queue.offer(r2);
            signalConsumer();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            this.error = r1;
            this.done = true;
            signalConsumer();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            signalConsumer();
        }

        void signalConsumer() {
            this.lock.lock();
            this.condition.signalAll();     // Catch: Throwable -> L6
            this.lock.unlock();
            return;
        L6:
            th = move-exception;
            this.lock.unlock();
            throw th;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
            signalConsumer();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }
    }

    public BlockingObservableIterable(ObservableSource<? extends T> r1, int r2) {
        this.source = r1;
        this.bufferSize = r2;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        BlockingObservableIterator r0 = new BlockingObservableIterator(this.bufferSize);
        this.source.subscribe(r0);
        return r0;
    }
}
