package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Notification;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableMaterialize<T> extends AbstractFlowableWithUpstream<T, Notification<T>> {

    public static final class MaterializeSubscriber<T> extends SinglePostCompleteSubscriber<T, Notification<T>> {
        private static final long serialVersionUID = -3740826063558713822L;

        public MaterializeSubscriber(Subscriber<? super Notification<T>> r1) {
            super(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            complete(Notification.createOnComplete());
        }

        @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber
        public /* bridge */ /* synthetic */ void onDrop(Object r1) {
            onDrop((Notification) r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            complete(Notification.createOnError(r1));
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T r5) {
            this.produced++;
            this.downstream.onNext(Notification.createOnNext(r5));
        }

        public void onDrop(Notification<T> r1) {
            if (r1.isOnError() == false) goto L6;
            RxJavaPlugins.onError(r1.getError());
            return;
        }
    }

    public FlowableMaterialize(Flowable<T> r1) {
        super(r1);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Notification<T>> r2) {
        this.source.subscribe(new MaterializeSubscriber(r2));
    }
}
