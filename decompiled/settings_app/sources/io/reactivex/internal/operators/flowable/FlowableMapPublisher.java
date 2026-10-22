package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableMapPublisher<T, U> extends Flowable<U> {
    final Function<? super T, ? extends U> mapper;
    final Publisher<T> source;

    public FlowableMapPublisher(Publisher<T> r1, Function<? super T, ? extends U> r2) {
        this.source = r1;
        this.mapper = r2;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super U> r3) {
        this.source.subscribe(new FlowableMap.MapSubscriber(r3, this.mapper));
    }
}
