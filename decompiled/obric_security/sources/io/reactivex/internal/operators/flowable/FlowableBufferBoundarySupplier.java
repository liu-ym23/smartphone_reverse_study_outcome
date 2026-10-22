package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableBufferBoundarySupplier<T, U extends Collection<? super T>, B> extends AbstractFlowableWithUpstream<T, U> {
    final Callable<? extends Publisher<B>> boundarySupplier;
    final Callable<U> bufferSupplier;

    static final class BufferBoundarySubscriber<T, U extends Collection<? super T>, B> extends DisposableSubscriber<B> {
        boolean once;
        final BufferBoundarySupplierSubscriber<T, U, B> parent;

        BufferBoundarySubscriber(BufferBoundarySupplierSubscriber<T, U, B> r1) {
            this.parent = r1;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(B r1) {
            if (this.once == false) goto L5;
            return;
        L5:
            this.once = true;
            cancel();
            this.parent.next();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.once == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.once = true;
            this.parent.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.once == false) goto L5;
            return;
        L5:
            this.once = true;
            this.parent.next();
        }
    }

    static final class BufferBoundarySupplierSubscriber<T, U extends Collection<? super T>, B> extends QueueDrainSubscriber<T, U, U> implements FlowableSubscriber<T>, Subscription, Disposable {
        final Callable<? extends Publisher<B>> boundarySupplier;
        U buffer;
        final Callable<U> bufferSupplier;
        final AtomicReference<Disposable> other;
        Subscription upstream;

        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public /* bridge */ /* synthetic */ boolean accept(Subscriber r1, Object r2) {
            return accept(r1, (Collection) r2);
        }

        BufferBoundarySupplierSubscriber(Subscriber<? super U> r2, Callable<U> r3, Callable<? extends Publisher<B>> r4) {
            super(r2, new MpscLinkedQueue());
            this.other = new AtomicReference();
            this.bufferSupplier = r3;
            this.boundarySupplier = r4;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r6) {
            if (SubscriptionHelper.validate(this.upstream, r6) == true) goto L5;
            return;
        L5:
            this.upstream = r6;
            Subscriber<? super V> r0 = this.downstream;
            this.buffer = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null");
            Publisher r2 = (Publisher) ObjectHelper.requireNonNull(this.boundarySupplier.call(), "The boundary publisher supplied is null");     // Catch: Throwable -> L13
            BufferBoundarySubscriber r1 = new BufferBoundarySubscriber(this);
            this.other.set(r1);
            r0.onSubscribe(this);
            if (this.cancelled == true) goto L23;
            r6.request(Long.MAX_VALUE);
            r2.subscribe(r1);
            return;
        L23:
            return;
        L13:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.cancelled = true;
            r6.cancel();
            EmptySubscription.error(th, r0);
            return;
        L16:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.cancelled = true;
            r6.cancel();
            EmptySubscription.error(th, r0);
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
            this.upstream.cancel();
            disposeOther();
            if (enter() == false) goto L9;
            this.queue.clear();
            return;
        L9:
            return;
        }

        void disposeOther() {
            DisposableHelper.dispose(this.other);
        }

        void next() {
            U r0 = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null");     // Catch: Throwable -> L21
            Publisher r1 = (Publisher) ObjectHelper.requireNonNull(this.boundarySupplier.call(), "The boundary publisher supplied is null");     // Catch: Throwable -> L18
            BufferBoundarySubscriber r2 = new BufferBoundarySubscriber(this);
            if (DisposableHelper.replace(this.other, r2) == false) goto L17;
            monitor-enter(this);
            U r3 = this.buffer;     // Catch: Throwable -> L14
            if (r3 != null) goto L11;
            monitor-exit(this);     // Catch: Throwable -> L14
            return;
        L11:
            this.buffer = r0;     // Catch: Throwable -> L14
            monitor-exit(this);     // Catch: Throwable -> L14
            r1.subscribe(r2);
            fastPathEmitMax(r3, false, this);
            return;
        L14:
            th = move-exception;
            throw th;
        L17:
            return;
        L18:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.cancelled = true;
            this.upstream.cancel();
            this.downstream.onError(th);
            return;
        L21:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.cancel();
            disposeOther();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.other.get() != DisposableHelper.DISPOSED) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public boolean accept(Subscriber<? super U> r1, U r2) {
            this.downstream.onNext((Object) r2);
            return true;
        }
    }

    public FlowableBufferBoundarySupplier(Flowable<T> r1, Callable<? extends Publisher<B>> r2, Callable<U> r3) {
        super(r1);
        this.boundarySupplier = r2;
        this.bufferSupplier = r3;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super U> r4) {
        this.source.subscribe(new BufferBoundarySupplierSubscriber(new SerializedSubscriber(r4), this.bufferSupplier, this.boundarySupplier));
    }
}
