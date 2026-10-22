package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class MaybeConcatArrayDelayError<T> extends Flowable<T> {
    final MaybeSource<? extends T>[] sources;

    public static final class ConcatMaybeObserver<T> extends AtomicInteger implements MaybeObserver<T>, Subscription {
        private static final long serialVersionUID = 3520831347801429610L;
        final AtomicReference<Object> current;
        final SequentialDisposable disposables;
        final Subscriber<? super T> downstream;
        final AtomicThrowable errors;
        int index;
        long produced;
        final AtomicLong requested;
        final MaybeSource<? extends T>[] sources;

        public ConcatMaybeObserver(Subscriber<? super T> r1, MaybeSource<? extends T>[] r2) {
            this.downstream = r1;
            this.sources = r2;
            this.requested = new AtomicLong();
            this.disposables = new SequentialDisposable();
            this.current = new AtomicReference(NotificationLite.COMPLETE);
            this.errors = new AtomicThrowable();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.disposables.dispose();
        }

        public void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            AtomicReference<Object> r0 = this.current;
            Subscriber<? super T> r1 = this.downstream;
            SequentialDisposable r2 = this.disposables;
        L7:
            if (r2.isDisposed() == true) goto L8;
            Object r3 = r0.get();
            if (r3 == null) goto L29;
            if (r3 == NotificationLite.COMPLETE) goto L17;
            long r5 = this.produced;
            if (r5 == this.requested.get()) goto L29;
            this.produced = r5 + 1;
            r0.lazySet(null);
            r1.onNext(r3);
        L19:
            if (r2.isDisposed() == true) goto L29;
            int r4 = this.index;
            MaybeSource<? extends T>[] r6 = this.sources;
            if (r4 == r6.length) goto L23;
            this.index = r4 + 1;
            r6[r4].subscribe(this);
            goto L29
        L23:
            if (this.errors.get() == null) goto L25;
            r1.onError(this.errors.terminate());
            return;
        L25:
            r1.onComplete();
            return;
        L17:
            r0.lazySet(null);
        L29:
            if (decrementAndGet() != 0) goto L7;
            return;
        L8:
            r0.lazySet(null);
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.current.lazySet(NotificationLite.COMPLETE);
            drain();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r3) {
            this.current.lazySet(NotificationLite.COMPLETE);
            if (this.errors.addThrowable(r3) == false) goto L5;
            drain();
            return;
        L5:
            RxJavaPlugins.onError(r3);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r1) {
            this.disposables.replace(r1);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T r2) {
            this.current.lazySet(r2);
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.add(this.requested, r2);
            drain();
            return;
        }
    }

    public MaybeConcatArrayDelayError(MaybeSource<? extends T>[] r1) {
        this.sources = r1;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r2) {
        ConcatMaybeObserver r0 = new ConcatMaybeObserver(r2, this.sources);
        r2.onSubscribe(r0);
        r0.drain();
    }
}
