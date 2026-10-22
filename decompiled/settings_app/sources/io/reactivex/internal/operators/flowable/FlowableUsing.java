package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableUsing<T, D> extends Flowable<T> {
    final Consumer<? super D> disposer;
    final boolean eager;
    final Callable<? extends D> resourceSupplier;
    final Function<? super D, ? extends Publisher<? extends T>> sourceSupplier;

    static final class UsingSubscriber<T, D> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 5904473792286235046L;
        final Consumer<? super D> disposer;
        final Subscriber<? super T> downstream;
        final boolean eager;
        final D resource;
        Subscription upstream;

        UsingSubscriber(Subscriber<? super T> r1, D r2, Consumer<? super D> r3, boolean r4) {
            this.downstream = r1;
            this.resource = r2;
            this.disposer = r3;
            this.eager = r4;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            if (SubscriptionHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r6) {
            if (this.eager == true) goto L5;
            this.downstream.onError(r6);
            this.upstream.cancel();
            disposeAfter();
            return;
        L5:
            if (compareAndSet(false, true) == true) goto L17;
        L10:
            th = null;
        L11:
            this.upstream.cancel();
            if (th == null) goto L14;
            this.downstream.onError(new CompositeException(new Throwable[]{r6, th}));
            return;
        L14:
            this.downstream.onError(r6);
            return;
        L17:
            this.disposer.accept(this.resource);     // Catch: Throwable -> L8
        L8:
            th = th;
            Exceptions.throwIfFatal(th);
            goto L11
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.eager == true) goto L5;
            this.downstream.onComplete();
            this.upstream.cancel();
            disposeAfter();
            return;
        L5:
            if (compareAndSet(false, true) == true) goto L14;
        L11:
            this.upstream.cancel();
            this.downstream.onComplete();
            return;
        L14:
            this.disposer.accept(this.resource);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r1) {
            this.upstream.request(r1);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            disposeAfter();
            this.upstream.cancel();
        }

        void disposeAfter() {
            if (compareAndSet(false, true) == false) goto L11;
            this.disposer.accept(this.resource);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            return;
        }
    }

    public FlowableUsing(Callable<? extends D> r1, Function<? super D, ? extends Publisher<? extends T>> r2, Consumer<? super D> r3, boolean r4) {
        this.resourceSupplier = r1;
        this.sourceSupplier = r2;
        this.disposer = r3;
        this.eager = r4;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r5) {
        D r0 = this.resourceSupplier.call();     // Catch: Throwable -> L14
        ((Publisher) ObjectHelper.requireNonNull(this.sourceSupplier.apply(r0), "The sourceSupplier returned a null Publisher")).subscribe(new UsingSubscriber(r5, r0, this.disposer, this.eager));
        return;
    L6:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        this.disposer.accept(r0);     // Catch: Throwable -> L11
        EmptySubscription.error(th, r5);
        return;
    L11:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptySubscription.error(new CompositeException(new Throwable[]{th, th}), r5);
        return;
    L14:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptySubscription.error(th, r5);
    }
}
