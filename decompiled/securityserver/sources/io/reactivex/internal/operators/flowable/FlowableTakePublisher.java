package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableTakePublisher<T> extends Flowable<T> {
    final long limit;
    final Publisher<T> source;

    public FlowableTakePublisher(Publisher<T> r1, long r2) {
        this.source = r1;
        this.limit = r2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r5) {
        this.source.subscribe(new FlowableTake.TakeSubscriber(r5, this.limit));
    }
}
