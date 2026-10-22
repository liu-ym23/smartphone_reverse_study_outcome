package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableBufferExactBoundary<T, U extends Collection<? super T>, B> extends AbstractFlowableWithUpstream<T, U> {
    final Publisher<B> boundary;
    final Callable<U> bufferSupplier;

    static final class BufferBoundarySubscriber<T, U extends Collection<? super T>, B> extends DisposableSubscriber<B> {
        final BufferExactBoundarySubscriber<T, U, B> parent;

        BufferBoundarySubscriber(BufferExactBoundarySubscriber<T, U, B> r1) {
            this.parent = r1;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(B r1) {
            this.parent.next();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            this.parent.onError(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.parent.onComplete();
        }
    }

    static final class BufferExactBoundarySubscriber<T, U extends Collection<? super T>, B> extends QueueDrainSubscriber<T, U, U> implements FlowableSubscriber<T>, Subscription, Disposable {
        final Publisher<B> boundary;
        U buffer;
        final Callable<U> bufferSupplier;
        Disposable other;
        Subscription upstream;

        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public /* bridge */ /* synthetic */ boolean accept(Subscriber r1, Object r2) {
            return accept(r1, (Collection) r2);
        }

        BufferExactBoundarySubscriber(Subscriber<? super U> r2, Callable<U> r3, Publisher<B> r4) {
            super(r2, new MpscLinkedQueue());
            this.bufferSupplier = r3;
            this.boundary = r4;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r4) {
            if (SubscriptionHelper.validate(this.upstream, r4) == true) goto L5;
            return;
        L5:
            this.upstream = r4;
            this.buffer = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null");
            BufferBoundarySubscriber r0 = new BufferBoundarySubscriber(this);
            this.other = r0;
            this.downstream.onSubscribe(this);
            if (this.cancelled == true) goto L16;
            r4.request(Long.MAX_VALUE);
            this.boundary.subscribe(r0);
            return;
        L16:
            return;
        L11:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.cancelled = true;
            r4.cancel();
            EmptySubscription.error(th, this.downstream);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r2) {
            monitor-enter(this);
            U r0 = this.buffer;     // Catch: Throwable -> L10
            if (r0 != null) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L10
            return;
        L7:
            r0.add(r2);     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            cancel();
            this.downstream.onError(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            monitor-enter(this);
            U r0 = this.buffer;     // Catch: Throwable -> L13
            if (r0 != null) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L7:
            this.buffer = null;     // Catch: Throwable -> L13
            monitor-exit(this);     // Catch: Throwable -> L13
            this.queue.offer(r0);
            this.done = true;
            if (enter() == false) goto L17;
            QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, this, this);
            return;
        L17:
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r1) {
            requested(r1);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            this.other.dispose();
            this.upstream.cancel();
            if (enter() == false) goto L9;
            this.queue.clear();
            return;
        L9:
            return;
        }

        void next() {
            U r0 = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null");     // Catch: Throwable -> L15
            monitor-enter(this);
            U r1 = this.buffer;     // Catch: Throwable -> L12
            if (r1 != null) goto L8;
            monitor-exit(this);     // Catch: Throwable -> L12
            return;
        L8:
            this.buffer = r0;     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
            fastPathEmitMax(r1, false, this);
            return;
        L12:
            th = move-exception;
            throw th;
        L15:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public boolean accept(Subscriber<? super U> r1, U r2) {
            this.downstream.onNext((Object) r2);
            return true;
        }
    }

    public FlowableBufferExactBoundary(Flowable<T> r1, Publisher<B> r2, Callable<U> r3) {
        super(r1);
        this.boundary = r2;
        this.bufferSupplier = r3;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super U> r4) {
        this.source.subscribe(new BufferExactBoundarySubscriber(new SerializedSubscriber(r4), this.bufferSupplier, this.boundary));
    }
}
