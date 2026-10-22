package io.reactivex.internal.operators.flowable;

import adcpeJava.adcpe.Ciphertext;
import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableScalarXMap {

    static final class ScalarXMapFlowable<T, R> extends Flowable<R> {
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        final T value;

        ScalarXMapFlowable(T r1, Function<? super T, ? extends Publisher<? extends R>> r2) {
            this.value = r1;
            this.mapper = r2;
        }

        @Override // io.reactivex.Flowable
        public void subscribeActual(Subscriber<? super R> r2) {
            Publisher r1 = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(this.value), "The mapper returned a null Publisher");     // Catch: Throwable -> L15
            if ((r1 instanceof Callable) == true) goto L20;
            r1.subscribe(r2);
            return;
        L20:
            Object r3 = ((Callable) r1).call();     // Catch: Throwable -> L10
            if (r3 != null) goto L9;
            EmptySubscription.complete(r2);
            return;
        L9:
            r2.onSubscribe(new ScalarSubscription(r2, r3));
            return;
        L10:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, r2);
            return;
        L15:
            th = move-exception;
            EmptySubscription.error(th, r2);
        }
    }

    private FlowableScalarXMap() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, R> boolean tryScalarXMapSubscribe(Publisher<T> r1, Subscriber<? super R> r2, Function<? super T, ? extends Publisher<? extends R>> r3) {
        if ((r1 instanceof Callable) == true) goto L34;
        return false;
    L34:
        Ciphertext r4 = (Object) ((Callable) r1).call();
        if (r4 != null) goto L30;
        EmptySubscription.complete(r2);
        return true;
    L30:
        Publisher r5 = (Publisher) ObjectHelper.requireNonNull(r3.apply(r4), "The mapper returned a null Publisher");     // Catch: Throwable -> L22
        if ((r5 instanceof Callable) == true) goto L32;
        r5.subscribe(r2);
    L21:
        return true;
    L32:
        Object r6 = ((Callable) r5).call();     // Catch: Throwable -> L17
        if (r6 != null) goto L16;
        EmptySubscription.complete(r2);
        return true;
    L16:
        r2.onSubscribe(new ScalarSubscription(r2, r6));
    L17:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptySubscription.error(th, r2);
        return true;
    L22:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptySubscription.error(th, r2);
        return true;
    L25:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptySubscription.error(th, r2);
        return true;
    }

    public static <T, U> Flowable<U> scalarXMap(T r1, Function<? super T, ? extends Publisher<? extends U>> r2) {
        return RxJavaPlugins.onAssembly(new ScalarXMapFlowable(r1, r2));
    }
}
