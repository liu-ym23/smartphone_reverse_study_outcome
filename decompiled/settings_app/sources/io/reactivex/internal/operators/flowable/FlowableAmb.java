package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableAmb<T> extends Flowable<T> {
    final Publisher<? extends T>[] sources;
    final Iterable<? extends Publisher<? extends T>> sourcesIterable;

    static final class AmbCoordinator<T> implements Subscription {
        final Subscriber<? super T> downstream;
        final AmbInnerSubscriber<T>[] subscribers;
        final AtomicInteger winner;

        AmbCoordinator(Subscriber<? super T> r2, int r3) {
            this.winner = new AtomicInteger();
            this.downstream = r2;
            this.subscribers = new AmbInnerSubscriber[r3];
        }

        public void subscribe(Publisher<? extends T>[] r8) {
            AmbInnerSubscriber<T>[] r0 = this.subscribers;
            int r1 = r0.length;
            int r2 = 0;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L5;
            int r5 = r3 + 1;
            r0[r3] = new AmbInnerSubscriber(this, r5, this.downstream);
            r3 = r5;
            goto L3
        L5:
            this.winner.lazySet(0);
            this.downstream.onSubscribe(this);
        L6:
            if (r2 >= r1) goto L11;
            if (this.winner.get() != 0) goto L9;
            r8[r2].subscribe(r0[r2]);
            r2 = r2 + 1;
            goto L6
        L9:
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r4) {
            if (SubscriptionHelper.validate(r4) == false) goto L11;
            int r0 = this.winner.get();
            if (r0 <= 0) goto L7;
            this.subscribers[r0 - 1].request(r4);
            return;
        L7:
            if (r0 != 0) goto L14;
            AmbInnerSubscriber<T>[] r3 = this.subscribers;
            int r1 = r3.length;
            int r2 = 0;
        L9:
            if (r2 >= r1) goto L15;
            r3[r2].request(r4);
            r2 = r2 + 1;
            goto L9
        L15:
            return;
        L14:
            return;
        }

        public boolean win(int r4) {
            int r1 = 0;
            if (this.winner.get() == 0) goto L5;
        L14:
            return false;
        L5:
            if (this.winner.compareAndSet(0, r4) == false) goto L14;
            AmbInnerSubscriber<T>[] r3 = this.subscribers;
            int r0 = r3.length;
        L7:
            if (r1 >= r0) goto L12;
            int r2 = r1 + 1;
            if (r2 == r4) goto L11;
            r3[r1].cancel();
        L11:
            r1 = r2;
            goto L7
        L12:
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.winner.get() == (-1)) goto L7;
            this.winner.lazySet(-1);
            AmbInnerSubscriber<T>[] r3 = this.subscribers;
            int r0 = r3.length;
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            r3[r1].cancel();
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }
    }

    static final class AmbInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -1185974347409665484L;
        final Subscriber<? super T> downstream;
        final int index;
        final AtomicLong missedRequested;
        final AmbCoordinator<T> parent;
        boolean won;

        AmbInnerSubscriber(AmbCoordinator<T> r2, int r3, Subscriber<? super T> r4) {
            this.missedRequested = new AtomicLong();
            this.parent = r2;
            this.index = r3;
            this.downstream = r4;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            SubscriptionHelper.deferredSetOnce(this, this.missedRequested, r2);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            SubscriptionHelper.deferredRequest(this, this.missedRequested, r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            if (this.won == false) goto L6;
            this.downstream.onNext(r3);
            return;
        L6:
            if (this.parent.win(this.index) == false) goto L8;
            this.won = true;
            this.downstream.onNext(r3);
            return;
        L8:
            get().cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r3) {
            if (this.won == false) goto L6;
            this.downstream.onError(r3);
            return;
        L6:
            if (this.parent.win(this.index) == false) goto L8;
            this.won = true;
            this.downstream.onError(r3);
            return;
        L8:
            get().cancel();
            RxJavaPlugins.onError(r3);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.won == false) goto L6;
            this.downstream.onComplete();
            return;
        L6:
            if (this.parent.win(this.index) == false) goto L8;
            this.won = true;
            this.downstream.onComplete();
            return;
        L8:
            get().cancel();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }
    }

    public FlowableAmb(Publisher<? extends T>[] r1, Iterable<? extends Publisher<? extends T>> r2) {
        this.sources = r1;
        this.sourcesIterable = r2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r6) {
        Publisher<? extends T>[] r0 = this.sources;
        if (r0 != null) goto L20;
        r0 = new Publisher[8];
        Iterator<? extends Publisher<? extends T>> r5 = this.sourcesIterable.iterator();     // Catch: Throwable -> L17
        int r2 = 0;
    L7:
        if (r5.hasNext() == false) goto L21;
        Publisher<? extends T> r3 = r5.next();     // Catch: Throwable -> L17
        if (r3 == null) goto L10;
        if (r2 != r0.length) goto L15;
        Publisher<? extends T>[] r4 = new Publisher[(r2 >> 2) + r2];     // Catch: Throwable -> L17
        System.arraycopy(r0, 0, r4, 0, r2);     // Catch: Throwable -> L17
        r0 = r4;
    L15:
        int r7 = r2 + 1;     // Catch: Throwable -> L17
        r0[r2] = r3;     // Catch: Throwable -> L17
        r2 = r7;
        goto L7
    L10:
        EmptySubscription.error(new NullPointerException("One of the sources is null"), r6);     // Catch: Throwable -> L17
        return;
    L21:
        if (r2 != 0) goto L25;
        EmptySubscription.complete(r6);
        return;
    L25:
        if (r2 != 1) goto L28;
        r0[0].subscribe(r6);
        return;
    L28:
        new AmbCoordinator(r6, r2).subscribe(r0);
        return;
    L17:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptySubscription.error(th, r6);
        return;
    L20:
        r2 = r0.length;
        goto L21
    }
}
