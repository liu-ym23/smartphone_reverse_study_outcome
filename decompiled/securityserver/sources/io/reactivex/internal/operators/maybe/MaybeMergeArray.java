package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public final class MaybeMergeArray<T> extends Flowable<T> {
    final MaybeSource<? extends T>[] sources;

    public static final class ClqSimpleQueue<T> extends ConcurrentLinkedQueue<T> implements SimpleQueueWithConsumerIndex<T> {
        private static final long serialVersionUID = -4025173261791142821L;
        int consumerIndex;
        final AtomicInteger producerIndex;

        public ClqSimpleQueue() {
            this.producerIndex = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int consumerIndex() {
            return this.consumerIndex;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public void drop() {
            poll();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T r1, T r2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex, io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            T r0 = (T) super.poll();
            if (r0 == null) goto L5;
            this.consumerIndex++;
        L5:
            return r0;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int producerIndex() {
            return this.producerIndex.get();
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T r2) {
            this.producerIndex.getAndIncrement();
            return super.offer(r2);
        }
    }

    public static final class MergeMaybeObserver<T> extends BasicIntQueueSubscription<T> implements MaybeObserver<T> {
        private static final long serialVersionUID = -660395290758764731L;
        volatile boolean cancelled;
        long consumed;
        final Subscriber<? super T> downstream;
        final AtomicThrowable error;
        boolean outputFused;
        final SimpleQueueWithConsumerIndex<Object> queue;
        final AtomicLong requested;
        final CompositeDisposable set;
        final int sourceCount;

        public MergeMaybeObserver(Subscriber<? super T> r1, int r2, SimpleQueueWithConsumerIndex<Object> r3) {
            this.downstream = r1;
            this.sourceCount = r2;
            this.set = new CompositeDisposable();
            this.requested = new AtomicLong();
            this.error = new AtomicThrowable();
            this.queue = r3;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            this.set.dispose();
            if (getAndIncrement() != 0) goto L9;
            this.queue.clear();
            return;
        L9:
            return;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.queue.clear();
        }

        public void drain() {
            if (getAndIncrement() == 0) goto L6;
            return;
        L6:
            if (this.outputFused == false) goto L8;
            drainFused();
            return;
        L8:
            drainNormal();
        }

        public void drainFused() {
            Subscriber<? super T> r0 = this.downstream;
            SimpleQueueWithConsumerIndex<Object> r1 = this.queue;
            int r3 = 1;
        L4:
            if (this.cancelled == true) goto L5;
            Throwable r4 = this.error.get();
            if (r4 != null) goto L9;
            if (r1.producerIndex() != this.sourceCount) goto L14;
            boolean r5 = true;
        L16:
            if (r1.isEmpty() == true) goto L18;
            r0.onNext(null);
        L18:
            if (r5 == true) goto L19;
            r3 = addAndGet(-r3);
            if (r3 != 0) goto L4;
            return;
        L19:
            r0.onComplete();
            return;
        L14:
            r5 = false;
            goto L16
        L9:
            r1.clear();
            r0.onError(r4);
            return;
        L5:
            r1.clear();
        }

        public void drainNormal() {
            Subscriber<? super T> r0 = this.downstream;
            SimpleQueueWithConsumerIndex<Object> r1 = this.queue;
            long r2 = this.consumed;
            int r4 = 1;
        L3:
            long r5 = this.requested.get();
        L5:
            if (r2 == r5) goto L24;
            if (this.cancelled == true) goto L8;
            if (this.error.get() != null) goto L12;
            if (r1.consumerIndex() == this.sourceCount) goto L16;
            Object r8 = r1.poll();
            if (r8 == null) goto L24;
            if (r8 == NotificationLite.COMPLETE) goto L5;
            r0.onNext(r8);
            r2 = r2 + 1;
            goto L5
        L16:
            r0.onComplete();
            return;
        L12:
            r1.clear();
            r0.onError(this.error.terminate());
            return;
        L8:
            r1.clear();
            return;
        L24:
            if (r2 == r5) goto L26;
        L36:
            this.consumed = r2;
            r4 = addAndGet(-r4);
            if (r4 != 0) goto L3;
            return;
        L26:
            if (this.error.get() != null) goto L27;
        L30:
            if (r1.peek() != NotificationLite.COMPLETE) goto L33;
            r1.drop();
            goto L30
        L33:
            if (r1.consumerIndex() != this.sourceCount) goto L36;
            r0.onComplete();
            return;
        L27:
            r1.clear();
            r0.onError(this.error.terminate());
        }

        public boolean isCancelled() {
            return this.cancelled;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.queue.offer(NotificationLite.COMPLETE);
            drain();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r2) {
            if (this.error.addThrowable(r2) == false) goto L5;
            this.set.dispose();
            this.queue.offer(NotificationLite.COMPLETE);
            drain();
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r1) {
            this.set.add(r1);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T r2) {
            this.queue.offer(r2);
            drain();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
        L2:
            T r0 = (T) this.queue.poll();
            if (r0 == NotificationLite.COMPLETE) goto L2;
            return r0;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.add(this.requested, r2);
            drain();
            return;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r2) {
            if ((r2 & 2) == 0) goto L6;
            this.outputFused = true;
            return 2;
        L6:
            return 0;
        }
    }

    public static final class MpscFillOnceSimpleQueue<T> extends AtomicReferenceArray<T> implements SimpleQueueWithConsumerIndex<T> {
        private static final long serialVersionUID = -7969063454040569579L;
        int consumerIndex;
        final AtomicInteger producerIndex;

        public MpscFillOnceSimpleQueue(int r1) {
            super(r1);
            this.producerIndex = new AtomicInteger();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
        L3:
            if (poll() == null) goto L7;
            if (isEmpty() == false) goto L3;
            return;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int consumerIndex() {
            return this.consumerIndex;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public void drop() {
            int r0 = this.consumerIndex;
            lazySet(r0, null);
            this.consumerIndex = r0 + 1;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            if (this.consumerIndex != producerIndex()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T r3) {
            ObjectHelper.requireNonNull(r3, "value is null");
            int r0 = this.producerIndex.getAndIncrement();
            if (r0 >= length()) goto L6;
            lazySet(r0, r3);
            return true;
        L6:
            return false;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public T peek() {
            int r0 = this.consumerIndex;
            if (r0 != length()) goto L7;
            return null;
        L7:
            return get(r0);
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex, java.util.Queue, io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            int r0 = this.consumerIndex;
            if (r0 != length()) goto L5;
            return null;
        L5:
            AtomicInteger r1 = this.producerIndex;
        L6:
            T r3 = get(r0);
            if (r3 != null) goto L8;
            if (r1.get() != r0) goto L6;
            return null;
        L8:
            this.consumerIndex = r0 + 1;
            lazySet(r0, null);
            return r3;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int producerIndex() {
            return this.producerIndex.get();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T r1, T r2) {
            throw new UnsupportedOperationException();
        }
    }

    public interface SimpleQueueWithConsumerIndex<T> extends SimpleQueue<T> {
        int consumerIndex();

        void drop();

        T peek();

        @Override // java.util.Queue, io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex, io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        T poll();

        int producerIndex();
    }

    public MaybeMergeArray(MaybeSource<? extends T>[] r1) {
        this.sources = r1;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r6) {
        MaybeSource[] r5 = this.sources;
        int r0 = r5.length;
        if (r0 > Flowable.bufferSize()) goto L5;
        SimpleQueueWithConsumerIndex r1 = new MpscFillOnceSimpleQueue(r0);
    L6:
        MergeMaybeObserver r2 = new MergeMaybeObserver(r6, r0, r1);
        r6.onSubscribe(r2);
        AtomicThrowable r7 = r2.error;
        int r3 = r5.length;
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L14;
        MaybeSource r8 = r5[r4];
        if (r2.isCancelled() == true) goto L18;
        if (r7.get() != null) goto L19;
        r8.subscribe(r2);
        r4 = r4 + 1;
        goto L7
    L19:
        return;
    L18:
        return;
    L14:
        return;
    L5:
        r1 = new ClqSimpleQueue();
        goto L6
    }
}
