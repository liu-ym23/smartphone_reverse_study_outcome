package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableElementAt<T> extends AbstractFlowableWithUpstream<T, T> {
    final T defaultValue;
    final boolean errorOnFewer;
    final long index;

    static final class ElementAtSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 4066607327284737757L;
        long count;
        final T defaultValue;
        boolean done;
        final boolean errorOnFewer;
        final long index;
        Subscription upstream;

        ElementAtSubscriber(Subscriber<? super T> r1, long r2, T r4, boolean r5) {
            super(r1);
            this.index = r2;
            this.defaultValue = r4;
            this.errorOnFewer = r5;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L6;
            this.upstream = r3;
            this.downstream.onSubscribe(this);
            r3.request(Long.MAX_VALUE);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r5) {
            if (this.done == false) goto L5;
            return;
        L5:
            long r0 = this.count;
            if (r0 != this.index) goto L9;
            this.done = true;
            this.upstream.cancel();
            complete(r5);
            return;
        L9:
            this.count = r0 + 1;
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
        public void onComplete() {
            if (this.done == true) goto L12;
            this.done = true;
            T r0 = this.defaultValue;
            if (r0 == null) goto L7;
            complete(r0);
            return;
        L7:
            if (this.errorOnFewer == false) goto L9;
            this.downstream.onError(new NoSuchElementException());
            return;
        L9:
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }
    }

    public FlowableElementAt(Flowable<T> r1, long r2, T r4, boolean r5) {
        super(r1);
        this.index = r2;
        this.defaultValue = r4;
        this.errorOnFewer = r5;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r9) {
        this.source.subscribe(new ElementAtSubscriber(r9, this.index, this.defaultValue, this.errorOnFewer));
    }
}
