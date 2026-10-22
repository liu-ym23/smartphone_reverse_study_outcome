package io.reactivex.internal.util;

import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final enum EmptyComponent extends Enum<EmptyComponent> implements FlowableSubscriber<Object>, Observer<Object>, MaybeObserver<Object>, SingleObserver<Object>, CompletableObserver, Subscription, Disposable {
    private static final /* synthetic */ EmptyComponent[] $VALUES = null;
    public static final EmptyComponent INSTANCE = null;

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return true;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(Object r1) {
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(Object r1) {
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r1) {
    }

    private EmptyComponent(String r1, int r2) {
        super(r1, r2);
    }

    public static EmptyComponent valueOf(String r1) {
        return (EmptyComponent) Enum.valueOf(EmptyComponent.class, r1);
    }

    public static EmptyComponent[] values() {
        return (EmptyComponent[]) $VALUES.clone();
    }

    static {
        EmptyComponent r0 = new EmptyComponent("INSTANCE", 0);
        INSTANCE = r0;
        $VALUES = new EmptyComponent[]{r0};
    }

    public static <T> Subscriber<T> asSubscriber() {
        return INSTANCE;
    }

    public static <T> Observer<T> asObserver() {
        return INSTANCE;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r1) {
        r1.dispose();
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r1) {
        r1.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r1) {
        RxJavaPlugins.onError(r1);
    }
}
