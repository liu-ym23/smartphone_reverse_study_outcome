package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableAutoConnect<T> extends Flowable<T> {
    final AtomicInteger clients;
    final Consumer<? super Disposable> connection;
    final int numberOfSubscribers;
    final ConnectableFlowable<? extends T> source;

    public FlowableAutoConnect(ConnectableFlowable<? extends T> r1, int r2, Consumer<? super Disposable> r3) {
        this.source = r1;
        this.numberOfSubscribers = r2;
        this.connection = r3;
        this.clients = new AtomicInteger();
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r2) {
        this.source.subscribe(r2);
        if (this.clients.incrementAndGet() != this.numberOfSubscribers) goto L6;
        this.source.connect(this.connection);
        return;
    }
}
