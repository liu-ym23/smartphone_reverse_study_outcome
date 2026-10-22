package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowablePublishMulticast<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final boolean delayError;
    final int prefetch;
    final Function<? super Flowable<T>, ? extends Publisher<? extends R>> selector;

    static final class MulticastProcessor<T> extends Flowable<T> implements FlowableSubscriber<T>, Disposable {
        static final MulticastSubscription[] EMPTY = null;
        static final MulticastSubscription[] TERMINATED = null;
        int consumed;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final int limit;
        final int prefetch;
        volatile SimpleQueue<T> queue;
        int sourceMode;
        final AtomicReference<MulticastSubscription<T>[]> subscribers;
        final AtomicReference<Subscription> upstream;
        final AtomicInteger wip;

        static {
            EMPTY = new MulticastSubscription[0];
            TERMINATED = new MulticastSubscription[0];
        }

        MulticastProcessor(int r2, boolean r3) {
            this.prefetch = r2;
            this.limit = r2 - (r2 >> 2);
            this.delayError = r3;
            this.wip = new AtomicInteger();
            this.upstream = new AtomicReference();
            this.subscribers = new AtomicReference(EMPTY);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r4) {
            if (SubscriptionHelper.setOnce(this.upstream, r4) == true) goto L5;
            return;
        L5:
            if ((r4 instanceof QueueSubscription) == false) goto L14;
            QueueSubscription r0 = (QueueSubscription) r4;
            int r1 = r0.requestFusion(3);
            if (r1 != 1) goto L11;
            this.sourceMode = r1;
            this.queue = r0;
            this.done = true;
            drain();
            return;
        L11:
            if (r1 != 2) goto L14;
            this.sourceMode = r1;
            this.queue = r0;
            QueueDrainHelper.request(r4, this.prefetch);
            return;
        L14:
            this.queue = QueueDrainHelper.createQueue(this.prefetch);
            QueueDrainHelper.request(r4, this.prefetch);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SubscriptionHelper.cancel(this.upstream);
            if (this.wip.getAndIncrement() != 0) goto L8;
            SimpleQueue<T> r1 = this.queue;
            if (r1 == null) goto L9;
            r1.clear();
            return;
        L9:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.upstream.get() != SubscriptionHelper.CANCELLED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r2) {
            if (this.done == false) goto L6;
            return;
        L6:
            if (this.sourceMode == 0) goto L8;
        L11:
            drain();
            return;
        L8:
            if (this.queue.offer(r2) == true) goto L11;
            this.upstream.get().cancel();
            onError(new MissingBackpressureException());
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.error = r2;
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            drain();
            return;
        }

        boolean add(MulticastSubscription<T> r5) {
        L2:
            MulticastSubscription<T>[] r0 = this.subscribers.get();
            if (r0 == TERMINATED) goto L4;
            int r1 = r0.length;
            MulticastSubscription[] r3 = new MulticastSubscription[r1 + 1];
            System.arraycopy(r0, 0, r3, 0, r1);
            r3[r1] = r5;
            if (b0$$ExternalSyntheticBackport0.m(this.subscribers, r0, r3) == false) goto L2;
            return true;
        L4:
            return false;
        }

        void remove(MulticastSubscription<T> r7) {
        L2:
            MulticastSubscription<T>[] r0 = this.subscribers.get();
            int r1 = r0.length;
            if (r1 == 0) goto L4;
            int r3 = 0;
        L6:
            if (r3 >= r1) goto L11;
            if (r0[r3] == r7) goto L12;
            r3 = r3 + 1;
        L12:
            if (r3 < 0) goto L13;
            if (r1 != 1) goto L17;
            MulticastSubscription[] r2 = EMPTY;
        L19:
            if (b0$$ExternalSyntheticBackport0.m(this.subscribers, r0, r2) == false) goto L2;
            return;
        L17:
            MulticastSubscription[] r5 = new MulticastSubscription[r1 - 1];
            System.arraycopy(r0, 0, r5, 0, r3);
            System.arraycopy(r0, r3 + 1, r5, r3, (r1 - r3) - 1);
            r2 = r5;
            goto L19
        L13:
            return;
        L11:
            r3 = -1;
            goto L12
        }

        @Override // io.reactivex.Flowable
        protected void subscribeActual(Subscriber<? super T> r3) {
            MulticastSubscription<T> r0 = new MulticastSubscription(r3, this);
            r3.onSubscribe(r0);
            if (add(r0) == true) goto L5;
            Throwable r2 = this.error;
            if (r2 == null) goto L12;
            r3.onError(r2);
            return;
        L12:
            r3.onComplete();
            return;
        L5:
            if (r0.isCancelled() == false) goto L8;
            remove(r0);
            return;
        L8:
            drain();
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) goto L5;
            return;
        L5:
            SimpleQueue<T> r0 = this.queue;
            int r2 = this.consumed;
            int r3 = this.limit;
            if (this.sourceMode == 1) goto L8;
            boolean r4 = true;
        L9:
            AtomicReference<MulticastSubscription<T>[]> r7 = this.subscribers;
            MulticastSubscription<T>[] r8 = r7.get();
            int r9 = 1;
        L10:
            int r10 = r8.length;
            if (r0 == null) goto L99;
            if (r10 == 0) goto L99;
            int r11 = r8.length;
            long r12 = Long.MAX_VALUE;
            long r15 = Long.MAX_VALUE;
            int r14 = 0;
        L15:
            if (r14 >= r11) goto L23;
            MulticastSubscription<T> r5 = r8[r14];
            AtomicReference<MulticastSubscription<T>[]> r21 = r7;
            long r19 = r5.get() - r5.emitted;
            if (r19 != Long.MIN_VALUE) goto L19;
            r10 = r10 - 1;
        L22:
            r14 = r14 + 1;
            r7 = r21;
            goto L15
        L19:
            if (r15 <= r19) goto L22;
            r15 = r19;
            goto L22
        L23:
            AtomicReference<MulticastSubscription<T>[]> r22 = r7;
            long r6 = 0;
            if (r10 != 0) goto L27;
            r15 = 0;
        L27:
            if (r15 == r6) goto L78;
            if (isDisposed() == true) goto L30;
            boolean r13 = this.done;
            if (r13 == true) goto L35;
        L107:
            T r16 = r0.poll();     // Catch: Throwable -> L75
            if (r16 != null) goto L43;
            boolean r17 = true;
        L44:
            if (r13 == false) goto L51;
            if (r17 == false) goto L51;
            Throwable r1 = this.error;
            if (r1 == null) goto L49;
            errorAll(r1);
            return;
        L49:
            completeAll();
            return;
        L51:
            if (r17 == true) goto L78;
            int r18 = r8.length;
            int r110 = 0;
            boolean r111 = false;
        L55:
            if (r110 >= r18) goto L64;
            MulticastSubscription<T> r20 = r8[r110];
            long r23 = r20.get();
            if (r23 != Long.MIN_VALUE) goto L59;
            r111 = true;
        L63:
            r110 = r110 + 1;
            r12 = Long.MAX_VALUE;
            goto L55
        L59:
            if (r23 == r12) goto L61;
            r20.emitted++;
        L61:
            r20.downstream.onNext(r16);
            goto L63
        L64:
            r15 = r15 - 1;
            if (r4 == false) goto L69;
            r2 = r2 + 1;
            if (r2 != r3) goto L69;
            this.upstream.get().request(r3);
            r2 = 0;
        L69:
            MulticastSubscription<T>[] r24 = r22.get();
            if (r111 == true) goto L74;
            if (r24 != r8) goto L74;
            r6 = 0;
            r12 = Long.MAX_VALUE;
        L74:
            r8 = r24;
        L106:
            r7 = r22;
            goto L10
        L43:
            r17 = false;
        L75:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            SubscriptionHelper.cancel(this.upstream);
            errorAll(th);
            return;
        L35:
            if (this.delayError == true) goto L107;
            Throwable r112 = this.error;
            if (r112 == null) goto L107;
            errorAll(r112);
            return;
        L30:
            r0.clear();
            return;
        L78:
            if (r15 == r6) goto L80;
        L100:
            this.consumed = r2;
            r9 = this.wip.addAndGet(-r9);
            if (r9 == 0) goto L102;
            if (r0 != null) goto L105;
            r0 = this.queue;
        L105:
            r8 = r22.get();
            goto L106
        L102:
            return;
        L80:
            if (isDisposed() == true) goto L81;
            boolean r25 = this.done;
            if (r25 == true) goto L86;
        L91:
            if (r25 == false) goto L100;
            if (r0.isEmpty() == false) goto L100;
            Throwable r26 = this.error;
            if (r26 == null) goto L97;
            errorAll(r26);
            return;
        L97:
            completeAll();
            return;
        L86:
            if (this.delayError == true) goto L91;
            Throwable r27 = this.error;
            if (r27 == null) goto L91;
            errorAll(r27);
            return;
        L81:
            r0.clear();
            return;
        L99:
            r22 = r7;
            goto L100
        L8:
            r4 = false;
            goto L9
        }

        void errorAll(Throwable r8) {
            MulticastSubscription<T>[] r7 = this.subscribers.getAndSet(TERMINATED);
            int r0 = r7.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            MulticastSubscription<T> r2 = r7[r1];
            if (r2.get() == Long.MIN_VALUE) goto L7;
            r2.downstream.onError(r8);
        L7:
            r1 = r1 + 1;
            goto L3
        }

        void completeAll() {
            MulticastSubscription<T>[] r7 = this.subscribers.getAndSet(TERMINATED);
            int r0 = r7.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            MulticastSubscription<T> r2 = r7[r1];
            if (r2.get() == Long.MIN_VALUE) goto L7;
            r2.downstream.onComplete();
        L7:
            r1 = r1 + 1;
            goto L3
        }
    }

    static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 8664815189257569791L;
        final Subscriber<? super T> downstream;
        long emitted;
        final MulticastProcessor<T> parent;

        MulticastSubscription(Subscriber<? super T> r1, MulticastProcessor<T> r2) {
            this.downstream = r1;
            this.parent = r2;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.addCancel(this, r2);
            this.parent.drain();
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) goto L6;
            this.parent.remove(this);
            this.parent.drain();
            return;
        }

        public boolean isCancelled() {
            if (get() != Long.MIN_VALUE) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static final class OutputCanceller<R> implements FlowableSubscriber<R>, Subscription {
        final Subscriber<? super R> downstream;
        final MulticastProcessor<?> processor;
        Subscription upstream;

        OutputCanceller(Subscriber<? super R> r1, MulticastProcessor<?> r2) {
            this.downstream = r1;
            this.processor = r2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            if (SubscriptionHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(R r1) {
            this.downstream.onNext(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            this.downstream.onError(r2);
            this.processor.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
            this.processor.dispose();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r1) {
            this.upstream.request(r1);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
            this.processor.dispose();
        }
    }

    public FlowablePublishMulticast(Flowable<T> r1, Function<? super Flowable<T>, ? extends Publisher<? extends R>> r2, int r3, boolean r4) {
        super(r1);
        this.selector = r2;
        this.prefetch = r3;
        this.delayError = r4;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> r4) {
        MulticastProcessor r0 = new MulticastProcessor(this.prefetch, this.delayError);
        Publisher r1 = (Publisher) ObjectHelper.requireNonNull(this.selector.apply(r0), "selector returned a null Publisher");     // Catch: Throwable -> L6
        r1.subscribe(new OutputCanceller(r4, r0));
        this.source.subscribe(r0);
        return;
    L6:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptySubscription.error(th, r4);
    }
}
