package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Action;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableOnBackpressureBufferStrategy<T> extends AbstractFlowableWithUpstream<T, T> {
    final long bufferSize;
    final Action onOverflow;
    final BackpressureOverflowStrategy strategy;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$reactivex$BackpressureOverflowStrategy = null;

        static {
            int[] r0 = new int[BackpressureOverflowStrategy.values().length];
            $SwitchMap$io$reactivex$BackpressureOverflowStrategy = r0;
            r0[BackpressureOverflowStrategy.DROP_LATEST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$io$reactivex$BackpressureOverflowStrategy[BackpressureOverflowStrategy.DROP_OLDEST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final class OnBackpressureBufferStrategySubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 3240706908776709697L;
        final long bufferSize;
        volatile boolean cancelled;
        final Deque<T> deque;
        volatile boolean done;
        final Subscriber<? super T> downstream;
        Throwable error;
        final Action onOverflow;
        final AtomicLong requested;
        final BackpressureOverflowStrategy strategy;
        Subscription upstream;

        public OnBackpressureBufferStrategySubscriber(Subscriber<? super T> r1, Action r2, BackpressureOverflowStrategy r3, long r4) {
            this.downstream = r1;
            this.onOverflow = r2;
            this.strategy = r3;
            this.bufferSize = r4;
            this.requested = new AtomicLong();
            this.deque = new ArrayDeque();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() != 0) goto L6;
            clear(this.deque);
            return;
        }

        public void clear(Deque<T> r1) {
            monitor-enter(r1);
            r1.clear();     // Catch: Throwable -> L6
            monitor-exit(r1);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            Deque<T> r0 = this.deque;
            Subscriber<? super T> r1 = this.downstream;
            int r3 = 1;
        L6:
            long r4 = this.requested.get();
            long r8 = 0;
        L8:
            if (r8 == r4) goto L34;
            if (this.cancelled == true) goto L11;
            boolean r11 = this.done;
            monitor-enter(r0);
            T r12 = r0.poll();     // Catch: Throwable -> L31
            monitor-exit(r0);     // Catch: Throwable -> L31
            if (r12 != null) goto L19;
            boolean r13 = true;
        L20:
            if (r11 == false) goto L28;
            Throwable r14 = this.error;
            if (r14 != null) goto L23;
            if (r13 == false) goto L28;
            r1.onComplete();
            return;
        L23:
            clear(r0);
            r1.onError(r14);
            return;
        L28:
            if (r13 == true) goto L34;
            r1.onNext(r12);
            r8 = r8 + 1;
            goto L8
        L19:
            r13 = false;
        L31:
            th = move-exception;
            throw th;
        L11:
            clear(r0);
            return;
        L34:
            if (r8 != r4) goto L55;
            if (this.cancelled == true) goto L37;
            boolean r5 = this.done;
            monitor-enter(r0);
            boolean r6 = r0.isEmpty();     // Catch: Throwable -> L51
            monitor-exit(r0);     // Catch: Throwable -> L51
            if (r5 == false) goto L55;
            Throwable r7 = this.error;
            if (r7 != null) goto L46;
            if (r6 == false) goto L55;
            r1.onComplete();
            return;
        L46:
            clear(r0);
            r1.onError(r7);
            return;
        L51:
            th = move-exception;
            throw th;
        L37:
            clear(r0);
            return;
        L55:
            if (r8 == 0) goto L57;
            BackpressureHelper.produced(this.requested, r8);
        L57:
            r3 = addAndGet(-r3);
            if (r3 != 0) goto L6;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.error = r2;
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r7) {
            if (this.done == false) goto L5;
            return;
        L5:
            Deque<T> r0 = this.deque;
            monitor-enter(r0);
            boolean r2 = false;
            if (r0.size() != this.bufferSize) goto L19;
            int r1 = AnonymousClass1.$SwitchMap$io$reactivex$BackpressureOverflowStrategy[this.strategy.ordinal()];     // Catch: Throwable -> L16
            boolean r3 = true;
            if (r1 != 1) goto L12;
            r0.pollLast();     // Catch: Throwable -> L16
            r0.offer(r7);     // Catch: Throwable -> L16
        L15:
            r3 = false;
            r2 = true;
        L20:
            monitor-exit(r0);     // Catch: Throwable -> L16
            if (r2 == false) goto L28;
            Action r8 = this.onOverflow;
            if (r8 == null) goto L38;
            r8.run();     // Catch: Throwable -> L26
            return;
        L26:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            onError(th);
            return;
        L38:
            return;
        L28:
            if (r3 == false) goto L30;
            this.upstream.cancel();
            onError(new MissingBackpressureException());
            return;
        L30:
            drain();
            return;
        L12:
            if (r1 != 2) goto L20;
            r0.poll();     // Catch: Throwable -> L16
            r0.offer(r7);     // Catch: Throwable -> L16
            goto L15
        L19:
            r0.offer(r7);     // Catch: Throwable -> L16
            r3 = false;
        L16:
            th = move-exception;
            throw th;
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
            BackpressureHelper.add(this.requested, r2);
            drain();
            return;
        }
    }

    public FlowableOnBackpressureBufferStrategy(Flowable<T> r1, long r2, Action r4, BackpressureOverflowStrategy r5) {
        super(r1);
        this.bufferSize = r2;
        this.onOverflow = r4;
        this.strategy = r5;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r9) {
        this.source.subscribe(new OnBackpressureBufferStrategySubscriber(r9, this.onOverflow, this.strategy, this.bufferSize));
    }
}
