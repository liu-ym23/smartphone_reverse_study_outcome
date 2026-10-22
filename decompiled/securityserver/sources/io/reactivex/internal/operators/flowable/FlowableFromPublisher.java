package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableFromPublisher<T> extends Flowable<T> {
    final Publisher<? extends T> publisher;

    public FlowableFromPublisher(Publisher<? extends T> r1) {
        this.publisher = r1;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r1) {
        this.publisher.subscribe(r1);
    }
}
