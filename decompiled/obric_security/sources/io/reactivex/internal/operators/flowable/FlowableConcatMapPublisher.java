package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableConcatMapPublisher<T, R> extends Flowable<R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int prefetch;
    final Publisher<T> source;

    public FlowableConcatMapPublisher(Publisher<T> r1, Function<? super T, ? extends Publisher<? extends R>> r2, int r3, ErrorMode r4) {
        this.source = r1;
        this.mapper = r2;
        this.prefetch = r3;
        this.errorMode = r4;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> r4) {
        if (FlowableScalarXMap.tryScalarXMapSubscribe(this.source, r4, this.mapper) == false) goto L5;
        return;
    L5:
        this.source.subscribe(FlowableConcatMap.subscribe(r4, this.mapper, this.prefetch, this.errorMode));
    }
}
