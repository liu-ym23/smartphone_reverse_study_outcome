package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class ParallelDoOnNextTry<T> extends ParallelFlowable<T> {
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
    final Consumer<? super T> onNext;
    final ParallelFlowable<T> source;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.parallel.ParallelDoOnNextTry$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$reactivex$parallel$ParallelFailureHandling = null;

        static {
            int[] r0 = new int[ParallelFailureHandling.values().length];
            $SwitchMap$io$reactivex$parallel$ParallelFailureHandling = r0;
            r0[ParallelFailureHandling.RETRY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$io$reactivex$parallel$ParallelFailureHandling[ParallelFailureHandling.SKIP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$io$reactivex$parallel$ParallelFailureHandling[ParallelFailureHandling.STOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final class ParallelDoOnNextConditionalSubscriber<T> implements ConditionalSubscriber<T>, Subscription {
        boolean done;
        final ConditionalSubscriber<? super T> downstream;
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
        final Consumer<? super T> onNext;
        Subscription upstream;

        public ParallelDoOnNextConditionalSubscriber(ConditionalSubscriber<? super T> r1, Consumer<? super T> r2, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> r3) {
            this.downstream = r1;
            this.onNext = r2;
            this.errorHandler = r3;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.downstream.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            if (tryOnNext(r3) == false) goto L5;
            return;
        L5:
            if (this.done == true) goto L9;
            this.upstream.request(1);
            return;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            if (SubscriptionHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r1) {
            this.upstream.request(r1);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T r8) {
            if (this.done == false) goto L5;
            return false;
        L5:
            long r2 = 0;
        L25:
            this.onNext.accept(r8);     // Catch: Throwable -> L9
            return this.downstream.tryOnNext(r8);
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r2 = r2 + 1;     // Catch: Throwable -> L22
            ParallelFailureHandling r4 = (ParallelFailureHandling) ObjectHelper.requireNonNull(this.errorHandler.apply(Long.valueOf(r2), th), "The errorHandler returned a null item");     // Catch: Throwable -> L22
            int r5 = AnonymousClass1.$SwitchMap$io$reactivex$parallel$ParallelFailureHandling[r4.ordinal()];
            if (r5 == 1) goto L25;
            if (r5 != 2) goto L17;
        L21:
            return false;
        L17:
            if (r5 == 3) goto L20;
            cancel();
            onError(th);
            return false;
        L20:
            cancel();
            onComplete();
        L22:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel();
            onError(new CompositeException(new Throwable[]{th, th}));
            return false;
        }
    }

    public static final class ParallelDoOnNextSubscriber<T> implements ConditionalSubscriber<T>, Subscription {
        boolean done;
        final Subscriber<? super T> downstream;
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
        final Consumer<? super T> onNext;
        Subscription upstream;

        public ParallelDoOnNextSubscriber(Subscriber<? super T> r1, Consumer<? super T> r2, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> r3) {
            this.downstream = r1;
            this.onNext = r2;
            this.errorHandler = r3;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.downstream.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            if (tryOnNext(r3) == true) goto L6;
            this.upstream.request(1);
            return;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            if (SubscriptionHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r1) {
            this.upstream.request(r1);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T r9) {
            if (this.done == false) goto L5;
            return false;
        L5:
            long r2 = 0;
        L26:
            this.onNext.accept(r9);     // Catch: Throwable -> L10
            this.downstream.onNext(r9);
            return true;
        L10:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r2 = r2 + 1;     // Catch: Throwable -> L23
            ParallelFailureHandling r5 = (ParallelFailureHandling) ObjectHelper.requireNonNull(this.errorHandler.apply(Long.valueOf(r2), th), "The errorHandler returned a null item");     // Catch: Throwable -> L23
            int r6 = AnonymousClass1.$SwitchMap$io$reactivex$parallel$ParallelFailureHandling[r5.ordinal()];
            if (r6 == 1) goto L26;
            if (r6 != 2) goto L18;
        L22:
            return false;
        L18:
            if (r6 == 3) goto L21;
            cancel();
            onError(th);
            return false;
        L21:
            cancel();
            onComplete();
        L23:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel();
            onError(new CompositeException(new Throwable[]{th, th}));
            return false;
        }
    }

    public ParallelDoOnNextTry(ParallelFlowable<T> r1, Consumer<? super T> r2, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> r3) {
        this.source = r1;
        this.onNext = r2;
        this.errorHandler = r3;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.source.parallelism();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super T>[] r8) {
        if (validate(r8) == true) goto L5;
        return;
    L5:
        int r0 = r8.length;
        Subscriber<? super T>[] r1 = new Subscriber[r0];
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L12;
        Subscriber<? super T> r3 = r8[r2];
        if ((r3 instanceof ConditionalSubscriber) == false) goto L10;
        r1[r2] = new ParallelDoOnNextConditionalSubscriber((ConditionalSubscriber) r3, this.onNext, this.errorHandler);
    L11:
        r2 = r2 + 1;
        goto L6
    L10:
        r1[r2] = new ParallelDoOnNextSubscriber(r3, this.onNext, this.errorHandler);
        goto L11
    L12:
        this.source.subscribe(r1);
    }
}
