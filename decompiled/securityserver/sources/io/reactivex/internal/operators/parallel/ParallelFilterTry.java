package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class ParallelFilterTry<T> extends ParallelFlowable<T> {
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
    final Predicate<? super T> predicate;
    final ParallelFlowable<T> source;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.parallel.ParallelFilterTry$1, reason: invalid class name */
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

    public static abstract class BaseFilterSubscriber<T> implements ConditionalSubscriber<T>, Subscription {
        boolean done;
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
        final Predicate<? super T> predicate;
        Subscription upstream;

        public BaseFilterSubscriber(Predicate<? super T> r1, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> r2) {
            this.predicate = r1;
            this.errorHandler = r2;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.upstream.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T r3) {
            if (tryOnNext(r3) == false) goto L5;
            return;
        L5:
            if (this.done == true) goto L9;
            this.upstream.request(1);
            return;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long r1) {
            this.upstream.request(r1);
        }
    }

    public static final class ParallelFilterConditionalSubscriber<T> extends BaseFilterSubscriber<T> {
        final ConditionalSubscriber<? super T> downstream;

        public ParallelFilterConditionalSubscriber(ConditionalSubscriber<? super T> r1, Predicate<? super T> r2, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> r3) {
            super(r2, r3);
            this.downstream = r1;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            this.downstream.onComplete();
            return;
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

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            if (SubscriptionHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T r9) {
            if (this.done == true) goto L27;
            long r2 = 0;
        L30:
            if (this.predicate.test(r9) == true) goto L9;
            return false;
        L9:
            if (this.downstream.tryOnNext(r9) == true) goto L11;
            return false;
        L11:
            return true;
        L12:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r2 = r2 + 1;     // Catch: Throwable -> L25
            ParallelFailureHandling r5 = (ParallelFailureHandling) ObjectHelper.requireNonNull(this.errorHandler.apply(Long.valueOf(r2), th), "The errorHandler returned a null item");     // Catch: Throwable -> L25
            int r6 = AnonymousClass1.$SwitchMap$io$reactivex$parallel$ParallelFailureHandling[r5.ordinal()];
            if (r6 == 1) goto L30;
            if (r6 != 2) goto L20;
        L24:
            return false;
        L20:
            if (r6 == 3) goto L23;
            cancel();
            onError(th);
            return false;
        L23:
            cancel();
            onComplete();
        L25:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel();
            onError(new CompositeException(new Throwable[]{th, th}));
        L27:
            return false;
        }
    }

    public static final class ParallelFilterSubscriber<T> extends BaseFilterSubscriber<T> {
        final Subscriber<? super T> downstream;

        public ParallelFilterSubscriber(Subscriber<? super T> r1, Predicate<? super T> r2, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> r3) {
            super(r2, r3);
            this.downstream = r1;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            this.downstream.onComplete();
            return;
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

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            if (SubscriptionHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T r9) {
            if (this.done == true) goto L26;
            long r2 = 0;
        L27:
            if (this.predicate.test(r9) == false) goto L10;
            this.downstream.onNext(r9);
            return true;
        L10:
            return false;
        L11:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r2 = r2 + 1;     // Catch: Throwable -> L24
            ParallelFailureHandling r5 = (ParallelFailureHandling) ObjectHelper.requireNonNull(this.errorHandler.apply(Long.valueOf(r2), th), "The errorHandler returned a null item");     // Catch: Throwable -> L24
            int r6 = AnonymousClass1.$SwitchMap$io$reactivex$parallel$ParallelFailureHandling[r5.ordinal()];
            if (r6 == 1) goto L27;
            if (r6 != 2) goto L19;
        L23:
            return false;
        L19:
            if (r6 == 3) goto L22;
            cancel();
            onError(th);
            return false;
        L22:
            cancel();
            onComplete();
        L24:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel();
            onError(new CompositeException(new Throwable[]{th, th}));
        L26:
            return false;
        }
    }

    public ParallelFilterTry(ParallelFlowable<T> r1, Predicate<? super T> r2, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> r3) {
        this.source = r1;
        this.predicate = r2;
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
        r1[r2] = new ParallelFilterConditionalSubscriber((ConditionalSubscriber) r3, this.predicate, this.errorHandler);
    L11:
        r2 = r2 + 1;
        goto L6
    L10:
        r1[r2] = new ParallelFilterSubscriber(r3, this.predicate, this.errorHandler);
        goto L11
    L12:
        this.source.subscribe(r1);
    }
}
