package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableZipIterable<T, U, V> extends AbstractFlowableWithUpstream<T, V> {
    final Iterable<U> other;
    final BiFunction<? super T, ? super U, ? extends V> zipper;

    public static final class ZipIterableSubscriber<T, U, V> implements FlowableSubscriber<T>, Subscription {
        boolean done;
        final Subscriber<? super V> downstream;
        final Iterator<U> iterator;
        Subscription upstream;
        final BiFunction<? super T, ? super U, ? extends V> zipper;

        public ZipIterableSubscriber(Subscriber<? super V> r1, Iterator<U> r2, BiFunction<? super T, ? super U, ? extends V> r3) {
            this.downstream = r1;
            this.iterator = r2;
            this.zipper = r3;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }

        public void error(Throwable r2) {
            Exceptions.throwIfFatal(r2);
            this.done = true;
            this.upstream.cancel();
            this.downstream.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.downstream.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            if (this.done == false) goto L21;
            return;
        L21:
            Object r0 = ObjectHelper.requireNonNull(this.iterator.next(), "The iterator returned a null value");     // Catch: Throwable -> L18
            Object r4 = ObjectHelper.requireNonNull(this.zipper.apply(r3, r0), "The zipper function returned a null value");     // Catch: Throwable -> L15
            this.downstream.onNext(r4);
            if (this.iterator.hasNext() == true) goto L27;
            this.done = true;
            this.upstream.cancel();
            this.downstream.onComplete();
            return;
        L27:
            return;
        L12:
            th = move-exception;
            error(th);
            return;
        L15:
            th = move-exception;
            error(th);
            return;
        L18:
            th = move-exception;
            error(th);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            if (SubscriptionHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r1) {
            this.upstream.request(r1);
        }
    }

    public FlowableZipIterable(Flowable<T> r1, Iterable<U> r2, BiFunction<? super T, ? super U, ? extends V> r3) {
        super(r1);
        this.other = r2;
        this.zipper = r3;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super V> r4) {
        Iterator r0 = (Iterator) ObjectHelper.requireNonNull(this.other.iterator(), "The iterator returned by other is null");     // Catch: Throwable -> L12
        if (r0.hasNext() == true) goto L7;
        EmptySubscription.complete(r4);
        return;
    L7:
        this.source.subscribe(new ZipIterableSubscriber(r4, r0, this.zipper));
        return;
    L9:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptySubscription.error(th, r4);
        return;
    L12:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptySubscription.error(th, r4);
    }
}
