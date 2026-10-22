package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableScanSeed<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final BiFunction<R, ? super T, R> accumulator;
    final Callable<R> seedSupplier;

    static final class ScanSeedSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -1776795561228106469L;
        final BiFunction<R, ? super T, R> accumulator;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        Throwable error;
        final int limit;
        final int prefetch;
        final SimplePlainQueue<R> queue;
        final AtomicLong requested;
        Subscription upstream;
        R value;

        ScanSeedSubscriber(Subscriber<? super R> r1, BiFunction<R, ? super T, R> r2, R r3, int r4) {
            this.downstream = r1;
            this.accumulator = r2;
            this.value = r3;
            this.prefetch = r4;
            this.limit = r4 - (r4 >> 2);
            SpscArrayQueue r5 = new SpscArrayQueue(r4);
            this.queue = r5;
            r5.offer(r3);
            this.requested = new AtomicLong();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L6;
            this.upstream = r3;
            this.downstream.onSubscribe(this);
            r3.request(this.prefetch - 1);
            return;
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
        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            if (this.done == false) goto L5;
            return;
        L5:
            R r0 = this.value;
            R r4 = (R) ObjectHelper.requireNonNull(this.accumulator.apply(r0, r3), "The accumulator returned a null value");
            this.value = r4;
            this.queue.offer(r4);
            drain();
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            onError(th);
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
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() != 0) goto L6;
            this.queue.clear();
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.add(this.requested, r2);
            drain();
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            Subscriber<? super R> r1 = this.downstream;
            SimplePlainQueue<R> r2 = this.queue;
            int r3 = this.limit;
            int r4 = this.consumed;
            int r6 = 1;
        L6:
            long r7 = this.requested.get();
            long r11 = 0;
        L8:
            if (r11 == r7) goto L32;
            if (this.cancelled == true) goto L11;
            boolean r14 = this.done;
            if (r14 == false) goto L19;
            Throwable r15 = this.error;
            if (r15 == null) goto L19;
            r2.clear();
            r1.onError(r15);
            return;
        L19:
            R r16 = r2.poll();
            if (r16 != null) goto L22;
            boolean r17 = true;
        L23:
            if (r14 == false) goto L27;
            if (r17 == false) goto L27;
            r1.onComplete();
            return;
        L27:
            if (r17 == true) goto L32;
            r1.onNext(r16);
            r11 = r11 + 1;
            r4 = r4 + 1;
            if (r4 != r3) goto L8;
            this.upstream.request(r3);
            r4 = 0;
            goto L8
        L22:
            r17 = false;
            goto L23
        L11:
            r2.clear();
            return;
        L32:
            if (r11 != r7) goto L44;
            if (this.done == false) goto L44;
            Throwable r8 = this.error;
            if (r8 != null) goto L37;
            if (r2.isEmpty() == false) goto L44;
            r1.onComplete();
            return;
        L37:
            r2.clear();
            r1.onError(r8);
            return;
        L44:
            if (r11 == 0) goto L46;
            BackpressureHelper.produced(this.requested, r11);
        L46:
            this.consumed = r4;
            r6 = addAndGet(-r6);
            if (r6 != 0) goto L6;
        }
    }

    public FlowableScanSeed(Flowable<T> r1, Callable<R> r2, BiFunction<R, ? super T, R> r3) {
        super(r1);
        this.accumulator = r3;
        this.seedSupplier = r2;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> r5) {
        Object r0 = ObjectHelper.requireNonNull(this.seedSupplier.call(), "The seed supplied is null");     // Catch: Throwable -> L5
        this.source.subscribe(new ScanSeedSubscriber(r5, this.accumulator, r0, bufferSize()));
        return;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptySubscription.error(th, r5);
    }
}
