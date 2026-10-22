package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableMapNotification<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Callable<? extends R> onCompleteSupplier;
    final Function<? super Throwable, ? extends R> onErrorMapper;
    final Function<? super T, ? extends R> onNextMapper;

    static final class MapNotificationSubscriber<T, R> extends SinglePostCompleteSubscriber<T, R> {
        private static final long serialVersionUID = 2757120512858778108L;
        final Callable<? extends R> onCompleteSupplier;
        final Function<? super Throwable, ? extends R> onErrorMapper;
        final Function<? super T, ? extends R> onNextMapper;

        MapNotificationSubscriber(Subscriber<? super R> r1, Function<? super T, ? extends R> r2, Function<? super Throwable, ? extends R> r3, Callable<? extends R> r4) {
            super(r1);
            this.onNextMapper = r2;
            this.onErrorMapper = r3;
            this.onCompleteSupplier = r4;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r5) {
            Object r6 = ObjectHelper.requireNonNull(this.onNextMapper.apply(r5), "The onNext publisher returned is null");     // Catch: Throwable -> L5
            this.produced++;
            this.downstream.onNext(r6);
            return;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r5) {
            complete(ObjectHelper.requireNonNull(this.onErrorMapper.apply(r5), "The onError publisher returned is null"));
            return;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r5, th}));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            complete(ObjectHelper.requireNonNull(this.onCompleteSupplier.call(), "The onComplete publisher returned is null"));
            return;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
        }
    }

    public FlowableMapNotification(Flowable<T> r1, Function<? super T, ? extends R> r2, Function<? super Throwable, ? extends R> r3, Callable<? extends R> r4) {
        super(r1);
        this.onNextMapper = r2;
        this.onErrorMapper = r3;
        this.onCompleteSupplier = r4;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> r5) {
        this.source.subscribe(new MapNotificationSubscriber(r5, this.onNextMapper, this.onErrorMapper, this.onCompleteSupplier));
    }
}
