package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableDebounceTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    public static final class DebounceEmitter<T> extends AtomicReference<Disposable> implements Runnable, Disposable {
        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final AtomicBoolean once;
        final DebounceTimedSubscriber<T> parent;
        final T value;

        public DebounceEmitter(T r2, long r3, DebounceTimedSubscriber<T> r5) {
            this.once = new AtomicBoolean();
            this.value = r2;
            this.idx = r3;
            this.parent = r5;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void emit() {
            if (this.once.compareAndSet(false, true) == false) goto L6;
            this.parent.emit(this.idx, this.value, this);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() != DisposableHelper.DISPOSED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            emit();
        }

        public void setResource(Disposable r1) {
            DisposableHelper.replace(this, r1);
        }
    }

    public static final class DebounceTimedSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -9102637559663639004L;
        boolean done;
        final Subscriber<? super T> downstream;
        volatile long index;
        final long timeout;
        Disposable timer;
        final TimeUnit unit;
        Subscription upstream;
        final Scheduler.Worker worker;

        public DebounceTimedSubscriber(Subscriber<? super T> r1, long r2, TimeUnit r4, Scheduler.Worker r5) {
            this.downstream = r1;
            this.timeout = r2;
            this.unit = r4;
            this.worker = r5;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
            this.worker.dispose();
        }

        public void emit(long r3, T r5, DebounceEmitter<T> r6) {
            if (r3 == this.index) goto L5;
            return;
        L5:
            if (get() == 0) goto L7;
            this.downstream.onNext(r5);
            BackpressureHelper.produced(this, 1);
            r6.dispose();
            return;
        L7:
            cancel();
            this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            Disposable r0 = this.timer;
            if (r0 == null) goto L8;
            r0.dispose();
        L8:
            DebounceEmitter r1 = (DebounceEmitter) r0;
            if (r1 == null) goto L11;
            r1.emit();
        L11:
            this.downstream.onComplete();
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            Disposable r0 = this.timer;
            if (r0 == null) goto L9;
            r0.dispose();
        L9:
            this.downstream.onError(r2);
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r5) {
            if (this.done == false) goto L5;
            return;
        L5:
            long r0 = this.index + 1;
            this.index = r0;
            Disposable r2 = this.timer;
            if (r2 == null) goto L8;
            r2.dispose();
        L8:
            DebounceEmitter r3 = new DebounceEmitter(r5, r0, this);
            this.timer = r3;
            r3.setResource(this.worker.schedule(r3, this.timeout, this.unit));
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L6;
            this.upstream = r3;
            this.downstream.onSubscribe(this);
            r3.request(Long.MAX_VALUE);
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.add(this, r2);
            return;
        }
    }

    public FlowableDebounceTimed(Flowable<T> r1, long r2, TimeUnit r4, Scheduler r5) {
        super(r1);
        this.timeout = r2;
        this.unit = r4;
        this.scheduler = r5;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r9) {
        this.source.subscribe(new DebounceTimedSubscriber(new SerializedSubscriber(r9), this.timeout, this.unit, this.scheduler.createWorker()));
    }
}
