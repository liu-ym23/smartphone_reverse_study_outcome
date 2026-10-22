package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableTimeout<T, U, V> extends AbstractFlowableWithUpstream<T, T> {
    final Publisher<U> firstTimeoutIndicator;
    final Function<? super T, ? extends Publisher<V>> itemTimeoutIndicator;
    final Publisher<? extends T> other;

    public static final class TimeoutConsumer extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = 8708641127342403073L;
        final long idx;
        final TimeoutSelectorSupport parent;

        public TimeoutConsumer(long r1, TimeoutSelectorSupport r3) {
            this.idx = r1;
            this.parent = r3;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() != SubscriptionHelper.CANCELLED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Object r0 = get();
            SubscriptionHelper r1 = SubscriptionHelper.CANCELLED;
            if (r0 == r1) goto L6;
            lazySet(r1);
            this.parent.onTimeout(this.idx);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r4) {
            Object r0 = get();
            SubscriptionHelper r1 = SubscriptionHelper.CANCELLED;
            if (r0 == r1) goto L5;
            lazySet(r1);
            this.parent.onTimeoutError(this.idx, r4);
            return;
        L5:
            RxJavaPlugins.onError(r4);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object r3) {
            Subscription r4 = (Subscription) get();
            SubscriptionHelper r0 = SubscriptionHelper.CANCELLED;
            if (r4 == r0) goto L6;
            r4.cancel();
            lazySet(r0);
            this.parent.onTimeout(this.idx);
            return;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            SubscriptionHelper.setOnce(this, r3, Long.MAX_VALUE);
        }
    }

    public static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T>, TimeoutSelectorSupport {
        private static final long serialVersionUID = 3764492702657003550L;
        long consumed;
        final Subscriber<? super T> downstream;
        Publisher<? extends T> fallback;
        final AtomicLong index;
        final Function<? super T, ? extends Publisher<?>> itemTimeoutIndicator;
        final SequentialDisposable task;
        final AtomicReference<Subscription> upstream;

        public TimeoutFallbackSubscriber(Subscriber<? super T> r2, Function<? super T, ? extends Publisher<?>> r3, Publisher<? extends T> r4) {
            super(true);
            this.downstream = r2;
            this.itemTimeoutIndicator = r3;
            this.task = new SequentialDisposable();
            this.upstream = new AtomicReference();
            this.fallback = r4;
            this.index = new AtomicLong();
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.task.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
            this.task.dispose();
            this.downstream.onComplete();
            this.task.dispose();
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r6) {
            if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
            this.task.dispose();
            this.downstream.onError(r6);
            this.task.dispose();
            return;
        L5:
            RxJavaPlugins.onError(r6);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r10) {
            long r0 = this.index.get();
            if (r0 == Long.MAX_VALUE) goto L22;
            long r7 = r0 + 1;
            if (this.index.compareAndSet(r0, r7) == false) goto L23;
            Disposable r1 = this.task.get();
            if (r1 == null) goto L10;
            r1.dispose();
        L10:
            this.consumed++;
            this.downstream.onNext(r10);
            Publisher r11 = (Publisher) ObjectHelper.requireNonNull(this.itemTimeoutIndicator.apply(r10), "The itemTimeoutIndicator returned a null Publisher.");     // Catch: Throwable -> L16
            TimeoutConsumer r2 = new TimeoutConsumer(r7, this);
            if (this.task.replace(r2) == false) goto L21;
            r11.subscribe(r2);
            return;
        L21:
            return;
        L16:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.get().cancel();
            this.index.getAndSet(Long.MAX_VALUE);
            this.downstream.onError(th);
            return;
        L23:
            return;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            if (SubscriptionHelper.setOnce(this.upstream, r2) == false) goto L6;
            setSubscription(r2);
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.TimeoutSupport
        public void onTimeout(long r5) {
            if (this.index.compareAndSet(r5, Long.MAX_VALUE) == false) goto L9;
            SubscriptionHelper.cancel(this.upstream);
            Publisher<? extends T> r6 = this.fallback;
            this.fallback = null;
            long r0 = this.consumed;
            if (r0 == 0) goto L7;
            produced(r0);
        L7:
            r6.subscribe(new FlowableTimeoutTimed.FallbackSubscriber(this.downstream, this));
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeout.TimeoutSelectorSupport
        public void onTimeoutError(long r4, Throwable r6) {
            if (this.index.compareAndSet(r4, Long.MAX_VALUE) == false) goto L5;
            SubscriptionHelper.cancel(this.upstream);
            this.downstream.onError(r6);
            return;
        L5:
            RxJavaPlugins.onError(r6);
        }

        public void startFirstTimeout(Publisher<?> r4) {
            if (r4 == null) goto L7;
            TimeoutConsumer r0 = new TimeoutConsumer(0, this);
            if (this.task.replace(r0) == false) goto L8;
            r4.subscribe(r0);
            return;
        L8:
            return;
        }
    }

    public interface TimeoutSelectorSupport extends FlowableTimeoutTimed.TimeoutSupport {
        void onTimeoutError(long r1, Throwable r3);
    }

    public static final class TimeoutSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, TimeoutSelectorSupport {
        private static final long serialVersionUID = 3764492702657003550L;
        final Subscriber<? super T> downstream;
        final Function<? super T, ? extends Publisher<?>> itemTimeoutIndicator;
        final AtomicLong requested;
        final SequentialDisposable task;
        final AtomicReference<Subscription> upstream;

        public TimeoutSubscriber(Subscriber<? super T> r1, Function<? super T, ? extends Publisher<?>> r2) {
            this.downstream = r1;
            this.itemTimeoutIndicator = r2;
            this.task = new SequentialDisposable();
            this.upstream = new AtomicReference();
            this.requested = new AtomicLong();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            this.task.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
            this.task.dispose();
            this.downstream.onComplete();
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r5) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
            this.task.dispose();
            this.downstream.onError(r5);
            return;
        L5:
            RxJavaPlugins.onError(r5);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r7) {
            long r0 = get();
            if (r0 == Long.MAX_VALUE) goto L22;
            long r4 = 1 + r0;
            if (compareAndSet(r0, r4) == false) goto L23;
            Disposable r1 = this.task.get();
            if (r1 == null) goto L10;
            r1.dispose();
        L10:
            this.downstream.onNext(r7);
            Publisher r8 = (Publisher) ObjectHelper.requireNonNull(this.itemTimeoutIndicator.apply(r7), "The itemTimeoutIndicator returned a null Publisher.");     // Catch: Throwable -> L16
            TimeoutConsumer r2 = new TimeoutConsumer(r4, this);
            if (this.task.replace(r2) == false) goto L21;
            r8.subscribe(r2);
            return;
        L21:
            return;
        L16:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.get().cancel();
            getAndSet(Long.MAX_VALUE);
            this.downstream.onError(th);
            return;
        L23:
            return;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r2);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.TimeoutSupport
        public void onTimeout(long r3) {
            if (compareAndSet(r3, Long.MAX_VALUE) == false) goto L6;
            SubscriptionHelper.cancel(this.upstream);
            this.downstream.onError(new TimeoutException());
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeout.TimeoutSelectorSupport
        public void onTimeoutError(long r3, Throwable r5) {
            if (compareAndSet(r3, Long.MAX_VALUE) == false) goto L5;
            SubscriptionHelper.cancel(this.upstream);
            this.downstream.onError(r5);
            return;
        L5:
            RxJavaPlugins.onError(r5);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, r2);
        }

        public void startFirstTimeout(Publisher<?> r4) {
            if (r4 == null) goto L7;
            TimeoutConsumer r0 = new TimeoutConsumer(0, this);
            if (this.task.replace(r0) == false) goto L8;
            r4.subscribe(r0);
            return;
        L8:
            return;
        }
    }

    public FlowableTimeout(Flowable<T> r1, Publisher<U> r2, Function<? super T, ? extends Publisher<V>> r3, Publisher<? extends T> r4) {
        super(r1);
        this.firstTimeoutIndicator = r2;
        this.itemTimeoutIndicator = r3;
        this.other = r4;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r4) {
        if (this.other != null) goto L5;
        TimeoutSubscriber r0 = new TimeoutSubscriber(r4, this.itemTimeoutIndicator);
        r4.onSubscribe(r0);
        r0.startFirstTimeout(this.firstTimeoutIndicator);
        this.source.subscribe(r0);
        return;
    L5:
        TimeoutFallbackSubscriber r1 = new TimeoutFallbackSubscriber(r4, this.itemTimeoutIndicator, this.other);
        r4.onSubscribe(r1);
        r1.startFirstTimeout(this.firstTimeoutIndicator);
        this.source.subscribe(r1);
    }
}
