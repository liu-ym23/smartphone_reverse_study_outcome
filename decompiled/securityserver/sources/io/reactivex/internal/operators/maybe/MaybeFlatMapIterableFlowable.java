package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public final class MaybeFlatMapIterableFlowable<T, R> extends Flowable<R> {
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    final MaybeSource<T> source;

    public static final class FlatMapIterableObserver<T, R> extends BasicIntQueueSubscription<R> implements MaybeObserver<T> {
        private static final long serialVersionUID = -8938804753851907758L;
        volatile boolean cancelled;
        final Subscriber<? super R> downstream;
        volatile Iterator<? extends R> it;
        final Function<? super T, ? extends Iterable<? extends R>> mapper;
        boolean outputFused;
        final AtomicLong requested;
        Disposable upstream;

        public FlatMapIterableObserver(Subscriber<? super R> r1, Function<? super T, ? extends Iterable<? extends R>> r2) {
            this.downstream = r1;
            this.mapper = r2;
            this.requested = new AtomicLong();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.it = null;
        }

        public void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            Subscriber<? super R> r0 = this.downstream;
            Iterator<? extends R> r1 = this.it;
            if (this.outputFused == false) goto L10;
            if (r1 == null) goto L10;
            r0.onNext(null);
            r0.onComplete();
            return;
        L10:
            int r2 = 1;
        L11:
            if (r1 == null) goto L40;
            long r3 = this.requested.get();
            if (r3 == Long.MAX_VALUE) goto L14;
            long r7 = 0;
        L18:
            if (r7 == r3) goto L38;
            if (this.cancelled == true) goto L21;
            r0.onNext((Object) ObjectHelper.requireNonNull(r1.next(), "The iterator returned a null value"));
            if (this.cancelled == true) goto L25;
            r7 = r7 + 1;
            if (r1.hasNext() == true) goto L18;
            r0.onComplete();
            return;
        L31:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r0.onError(th);
            return;
        L25:
            return;
        L34:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r0.onError(th);
            return;
        L21:
            return;
        L38:
            if (r7 == 0) goto L40;
            BackpressureHelper.produced(this.requested, r7);
            goto L40
        L14:
            fastPath(r0, r1);
            return;
        L40:
            r2 = addAndGet(-r2);
            if (r2 == 0) goto L42;
            if (r1 != null) goto L11;
            r1 = this.it;
            goto L11
        }

        public void fastPath(Subscriber<? super R> r2, Iterator<? extends R> r3) {
        L3:
            if (this.cancelled == true) goto L4;
            r2.onNext(r3.next());
            if (this.cancelled == true) goto L8;
            if (r3.hasNext() == true) goto L3;
            r2.onComplete();
            return;
        L13:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r2.onError(th);
            return;
        L8:
            return;
        L16:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r2.onError(th);
            return;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            if (this.it != null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r2) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T r2) {
            Iterator<? extends R> r3 = this.mapper.apply(r2).iterator();     // Catch: Throwable -> L8
            if (r3.hasNext() == true) goto L6;
            this.downstream.onComplete();
            return;
        L6:
            this.it = r3;
            drain();
            return;
        L8:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public R poll() {
            Iterator<? extends R> r0 = this.it;
            if (r0 == null) goto L8;
            R r2 = (R) ObjectHelper.requireNonNull(r0.next(), "The iterator returned a null value");
            if (r0.hasNext() == true) goto L7;
            this.it = null;
        L7:
            return r2;
        L8:
            return null;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.add(this.requested, r2);
            drain();
            return;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r2) {
            if ((r2 & 2) == 0) goto L6;
            this.outputFused = true;
            return 2;
        L6:
            return 0;
        }
    }

    public MaybeFlatMapIterableFlowable(MaybeSource<T> r1, Function<? super T, ? extends Iterable<? extends R>> r2) {
        this.source = r1;
        this.mapper = r2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> r3) {
        this.source.subscribe(new FlatMapIterableObserver(r3, this.mapper));
    }
}
