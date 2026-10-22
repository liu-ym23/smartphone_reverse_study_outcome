package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableOnErrorReturn<T> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super Throwable, ? extends T> valueSupplier;

    public static final class OnErrorReturnSubscriber<T> extends SinglePostCompleteSubscriber<T, T> {
        private static final long serialVersionUID = -3740826063558713822L;
        final Function<? super Throwable, ? extends T> valueSupplier;

        public OnErrorReturnSubscriber(Subscriber<? super T> r1, Function<? super Throwable, ? extends T> r2) {
            super(r1);
            this.valueSupplier = r2;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r3) {
            complete(ObjectHelper.requireNonNull(this.valueSupplier.apply(r3), "The valueSupplier returned a null value"));
            return;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r3, th}));
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T r5) {
            this.produced++;
            this.downstream.onNext((Object) r5);
        }
    }

    public FlowableOnErrorReturn(Flowable<T> r1, Function<? super Throwable, ? extends T> r2) {
        super(r1);
        this.valueSupplier = r2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r3) {
        this.source.subscribe(new OnErrorReturnSubscriber(r3, this.valueSupplier));
    }
}
