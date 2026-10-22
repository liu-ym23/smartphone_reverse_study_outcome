package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class CompletableMerge extends Completable {
    final boolean delayErrors;
    final int maxConcurrency;
    final Publisher<? extends CompletableSource> source;

    public static final class CompletableMergeSubscriber extends AtomicInteger implements FlowableSubscriber<CompletableSource>, Disposable {
        private static final long serialVersionUID = -2108443387387077490L;
        final boolean delayErrors;
        final CompletableObserver downstream;
        final AtomicThrowable error;
        final int maxConcurrency;
        final CompositeDisposable set;
        Subscription upstream;

        public final class MergeInnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            private static final long serialVersionUID = 251330541679988317L;
            final /* synthetic */ CompletableMergeSubscriber this$0;

            public MergeInnerObserver(CompletableMergeSubscriber r1) {
                this.this$0 = r1;
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.this$0.innerComplete(this);
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable r2) {
                this.this$0.innerError(this, r2);
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable r1) {
                DisposableHelper.setOnce(this, r1);
            }
        }

        public CompletableMergeSubscriber(CompletableObserver r1, int r2, boolean r3) {
            this.downstream = r1;
            this.maxConcurrency = r2;
            this.delayErrors = r3;
            this.set = new CompositeDisposable();
            this.error = new AtomicThrowable();
            lazySet(1);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.cancel();
            this.set.dispose();
        }

        public void innerComplete(MergeInnerObserver r3) {
            this.set.delete(r3);
            if (decrementAndGet() != 0) goto L9;
            Throwable r4 = this.error.get();
            if (r4 == null) goto L7;
            this.downstream.onError(r4);
            return;
        L7:
            this.downstream.onComplete();
            return;
        L9:
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L14;
            this.upstream.request(1);
            return;
        }

        public void innerError(MergeInnerObserver r2, Throwable r3) {
            this.set.delete(r2);
            if (this.delayErrors == true) goto L11;
            this.upstream.cancel();
            this.set.dispose();
            if (this.error.addThrowable(r3) == true) goto L7;
            RxJavaPlugins.onError(r3);
            return;
        L7:
            if (getAndSet(0) <= 0) goto L20;
            this.downstream.onError(this.error.terminate());
            return;
        L20:
            return;
        L11:
            if (this.error.addThrowable(r3) == true) goto L13;
            RxJavaPlugins.onError(r3);
            return;
        L13:
            if (decrementAndGet() != 0) goto L16;
            this.downstream.onError(this.error.terminate());
            return;
        L16:
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L24;
            this.upstream.request(1);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.set.isDisposed();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (decrementAndGet() == 0) goto L5;
            return;
        L5:
            if (this.error.get() == null) goto L7;
            this.downstream.onError(this.error.terminate());
            return;
        L7:
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.delayErrors == true) goto L11;
            this.set.dispose();
            if (this.error.addThrowable(r2) == true) goto L7;
            RxJavaPlugins.onError(r2);
            return;
        L7:
            if (getAndSet(0) <= 0) goto L17;
            this.downstream.onError(this.error.terminate());
            return;
        L17:
            return;
        L11:
            if (this.error.addThrowable(r2) == true) goto L13;
            RxJavaPlugins.onError(r2);
            return;
        L13:
            if (decrementAndGet() != 0) goto L20;
            this.downstream.onError(this.error.terminate());
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public /* bridge */ /* synthetic */ void onNext(Object r1) {
            onNext((CompletableSource) r1);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L9;
            this.upstream = r3;
            this.downstream.onSubscribe(this);
            int r2 = this.maxConcurrency;
            if (r2 != Integer.MAX_VALUE) goto L7;
            r3.request(Long.MAX_VALUE);
            return;
        L7:
            r3.request(r2);
            return;
        }

        public void onNext(CompletableSource r2) {
            getAndIncrement();
            MergeInnerObserver r0 = new MergeInnerObserver(this);
            this.set.add(r0);
            r2.subscribe(r0);
        }
    }

    public CompletableMerge(Publisher<? extends CompletableSource> r1, int r2, boolean r3) {
        this.source = r1;
        this.maxConcurrency = r2;
        this.delayErrors = r3;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver r4) {
        CompletableMergeSubscriber r0 = new CompletableMergeSubscriber(r4, this.maxConcurrency, this.delayErrors);
        this.source.subscribe(r0);
    }
}
