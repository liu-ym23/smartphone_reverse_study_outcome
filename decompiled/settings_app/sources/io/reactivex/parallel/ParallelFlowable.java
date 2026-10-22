package io.reactivex.parallel;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.parallel.ParallelCollect;
import io.reactivex.internal.operators.parallel.ParallelConcatMap;
import io.reactivex.internal.operators.parallel.ParallelDoOnNextTry;
import io.reactivex.internal.operators.parallel.ParallelFilter;
import io.reactivex.internal.operators.parallel.ParallelFilterTry;
import io.reactivex.internal.operators.parallel.ParallelFlatMap;
import io.reactivex.internal.operators.parallel.ParallelFromArray;
import io.reactivex.internal.operators.parallel.ParallelFromPublisher;
import io.reactivex.internal.operators.parallel.ParallelJoin;
import io.reactivex.internal.operators.parallel.ParallelMap;
import io.reactivex.internal.operators.parallel.ParallelMapTry;
import io.reactivex.internal.operators.parallel.ParallelPeek;
import io.reactivex.internal.operators.parallel.ParallelReduce;
import io.reactivex.internal.operators.parallel.ParallelReduceFull;
import io.reactivex.internal.operators.parallel.ParallelRunOn;
import io.reactivex.internal.operators.parallel.ParallelSortedJoin;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.ListAddBiConsumer;
import io.reactivex.internal.util.MergerBiFunction;
import io.reactivex.internal.util.SorterFunction;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ParallelFlowable<T> {
    public abstract int parallelism();

    public abstract void subscribe(Subscriber<? super T>[] r1);

    public ParallelFlowable() {
    }

    protected final boolean validate(Subscriber<?>[] r5) {
        int r4 = parallelism();
        if (r5.length == r4) goto L8;
        IllegalArgumentException r0 = new IllegalArgumentException("parallelism = " + r4 + ", subscribers = " + r5.length);
        int r6 = r5.length;
        int r2 = 0;
    L5:
        if (r2 >= r6) goto L7;
        EmptySubscription.error(r0, r5[r2]);
        r2 = r2 + 1;
        goto L5
    L7:
        return false;
    L8:
        return true;
    }

    @CheckReturnValue
    public static <T> ParallelFlowable<T> from(Publisher<? extends T> r2) {
        return from(r2, Runtime.getRuntime().availableProcessors(), Flowable.bufferSize());
    }

    @CheckReturnValue
    public static <T> ParallelFlowable<T> from(Publisher<? extends T> r1, int r2) {
        return from(r1, r2, Flowable.bufferSize());
    }

    @CheckReturnValue
    public static <T> ParallelFlowable<T> from(Publisher<? extends T> r1, int r2, int r3) {
        ObjectHelper.requireNonNull(r1, "source");
        ObjectHelper.verifyPositive(r2, "parallelism");
        ObjectHelper.verifyPositive(r3, "prefetch");
        return RxJavaPlugins.onAssembly(new ParallelFromPublisher(r1, r2, r3));
    }

    @CheckReturnValue
    public final <R> R as(ParallelFlowableConverter<T, R> r2) {
        return (R) ((ParallelFlowableConverter) ObjectHelper.requireNonNull(r2, "converter is null")).apply(this);
    }

    @CheckReturnValue
    public final <R> ParallelFlowable<R> map(Function<? super T, ? extends R> r2) {
        ObjectHelper.requireNonNull(r2, "mapper");
        return RxJavaPlugins.onAssembly(new ParallelMap(this, r2));
    }

    @CheckReturnValue
    public final <R> ParallelFlowable<R> map(Function<? super T, ? extends R> r2, ParallelFailureHandling r3) {
        ObjectHelper.requireNonNull(r2, "mapper");
        ObjectHelper.requireNonNull(r3, "errorHandler is null");
        return RxJavaPlugins.onAssembly(new ParallelMapTry(this, r2, r3));
    }

    @CheckReturnValue
    public final <R> ParallelFlowable<R> map(Function<? super T, ? extends R> r2, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> r3) {
        ObjectHelper.requireNonNull(r2, "mapper");
        ObjectHelper.requireNonNull(r3, "errorHandler is null");
        return RxJavaPlugins.onAssembly(new ParallelMapTry(this, r2, r3));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> filter(Predicate<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "predicate");
        return RxJavaPlugins.onAssembly(new ParallelFilter(this, r2));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> filter(Predicate<? super T> r2, ParallelFailureHandling r3) {
        ObjectHelper.requireNonNull(r2, "predicate");
        ObjectHelper.requireNonNull(r3, "errorHandler is null");
        return RxJavaPlugins.onAssembly(new ParallelFilterTry(this, r2, r3));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> filter(Predicate<? super T> r2, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> r3) {
        ObjectHelper.requireNonNull(r2, "predicate");
        ObjectHelper.requireNonNull(r3, "errorHandler is null");
        return RxJavaPlugins.onAssembly(new ParallelFilterTry(this, r2, r3));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> runOn(Scheduler r2) {
        return runOn(r2, Flowable.bufferSize());
    }

    @CheckReturnValue
    public final ParallelFlowable<T> runOn(Scheduler r2, int r3) {
        ObjectHelper.requireNonNull(r2, "scheduler");
        ObjectHelper.verifyPositive(r3, "prefetch");
        return RxJavaPlugins.onAssembly(new ParallelRunOn(this, r2, r3));
    }

    @CheckReturnValue
    public final Flowable<T> reduce(BiFunction<T, T, T> r2) {
        ObjectHelper.requireNonNull(r2, "reducer");
        return RxJavaPlugins.onAssembly(new ParallelReduceFull(this, r2));
    }

    @CheckReturnValue
    public final <R> ParallelFlowable<R> reduce(Callable<R> r2, BiFunction<R, ? super T, R> r3) {
        ObjectHelper.requireNonNull(r2, "initialSupplier");
        ObjectHelper.requireNonNull(r3, "reducer");
        return RxJavaPlugins.onAssembly(new ParallelReduce(this, r2, r3));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> sequential() {
        return sequential(Flowable.bufferSize());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> sequential(int r3) {
        ObjectHelper.verifyPositive(r3, "prefetch");
        return RxJavaPlugins.onAssembly(new ParallelJoin(this, r3, false));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> sequentialDelayError() {
        return sequentialDelayError(Flowable.bufferSize());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> sequentialDelayError(int r3) {
        ObjectHelper.verifyPositive(r3, "prefetch");
        return RxJavaPlugins.onAssembly(new ParallelJoin(this, r3, true));
    }

    @CheckReturnValue
    public final Flowable<T> sorted(Comparator<? super T> r2) {
        return sorted(r2, 16);
    }

    @CheckReturnValue
    public final Flowable<T> sorted(Comparator<? super T> r2, int r3) {
        ObjectHelper.requireNonNull(r2, "comparator is null");
        ObjectHelper.verifyPositive(r3, "capacityHint");
        return RxJavaPlugins.onAssembly(new ParallelSortedJoin(reduce(Functions.createArrayList((r3 / parallelism()) + 1), ListAddBiConsumer.instance()).map(new SorterFunction(r2)), r2));
    }

    @CheckReturnValue
    public final Flowable<List<T>> toSortedList(Comparator<? super T> r2) {
        return toSortedList(r2, 16);
    }

    @CheckReturnValue
    public final Flowable<List<T>> toSortedList(Comparator<? super T> r2, int r3) {
        ObjectHelper.requireNonNull(r2, "comparator is null");
        ObjectHelper.verifyPositive(r3, "capacityHint");
        return RxJavaPlugins.onAssembly(reduce(Functions.createArrayList((r3 / parallelism()) + 1), ListAddBiConsumer.instance()).map(new SorterFunction(r2)).reduce(new MergerBiFunction(r2)));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> doOnNext(Consumer<? super T> r12) {
        ObjectHelper.requireNonNull(r12, "onNext is null");
        return RxJavaPlugins.onAssembly(new ParallelPeek(this, r12, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> doOnNext(Consumer<? super T> r2, ParallelFailureHandling r3) {
        ObjectHelper.requireNonNull(r2, "onNext is null");
        ObjectHelper.requireNonNull(r3, "errorHandler is null");
        return RxJavaPlugins.onAssembly(new ParallelDoOnNextTry(this, r2, r3));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> doOnNext(Consumer<? super T> r2, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> r3) {
        ObjectHelper.requireNonNull(r2, "onNext is null");
        ObjectHelper.requireNonNull(r3, "errorHandler is null");
        return RxJavaPlugins.onAssembly(new ParallelDoOnNextTry(this, r2, r3));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> doAfterNext(Consumer<? super T> r12) {
        ObjectHelper.requireNonNull(r12, "onAfterNext is null");
        return RxJavaPlugins.onAssembly(new ParallelPeek(this, Functions.emptyConsumer(), r12, Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> doOnError(Consumer<Throwable> r12) {
        ObjectHelper.requireNonNull(r12, "onError is null");
        return RxJavaPlugins.onAssembly(new ParallelPeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), r12, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> doOnComplete(Action r12) {
        ObjectHelper.requireNonNull(r12, "onComplete is null");
        return RxJavaPlugins.onAssembly(new ParallelPeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.emptyConsumer(), r12, Functions.EMPTY_ACTION, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> doAfterTerminated(Action r12) {
        ObjectHelper.requireNonNull(r12, "onAfterTerminate is null");
        return RxJavaPlugins.onAssembly(new ParallelPeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, r12, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> doOnSubscribe(Consumer<? super Subscription> r12) {
        ObjectHelper.requireNonNull(r12, "onSubscribe is null");
        return RxJavaPlugins.onAssembly(new ParallelPeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, r12, Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> doOnRequest(LongConsumer r12) {
        ObjectHelper.requireNonNull(r12, "onRequest is null");
        return RxJavaPlugins.onAssembly(new ParallelPeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.emptyConsumer(), r12, Functions.EMPTY_ACTION));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> doOnCancel(Action r12) {
        ObjectHelper.requireNonNull(r12, "onCancel is null");
        return RxJavaPlugins.onAssembly(new ParallelPeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, r12));
    }

    @CheckReturnValue
    public final <C> ParallelFlowable<C> collect(Callable<? extends C> r2, BiConsumer<? super C, ? super T> r3) {
        ObjectHelper.requireNonNull(r2, "collectionSupplier is null");
        ObjectHelper.requireNonNull(r3, "collector is null");
        return RxJavaPlugins.onAssembly(new ParallelCollect(this, r2, r3));
    }

    @CheckReturnValue
    public static <T> ParallelFlowable<T> fromArray(Publisher<T>... r1) {
        if (r1.length == 0) goto L7;
        return RxJavaPlugins.onAssembly(new ParallelFromArray(r1));
    L7:
        throw new IllegalArgumentException("Zero publishers not supported");
    }

    @CheckReturnValue
    public final <U> U to(Function<? super ParallelFlowable<T>, U> r2) {
        return (U) ((Function) ObjectHelper.requireNonNull(r2, "converter is null")).apply(this);
    L4:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        throw ExceptionHelper.wrapOrThrow(th);
    }

    @CheckReturnValue
    public final <U> ParallelFlowable<U> compose(ParallelTransformer<T, U> r2) {
        return RxJavaPlugins.onAssembly(((ParallelTransformer) ObjectHelper.requireNonNull(r2, "composer is null")).apply(this));
    }

    @CheckReturnValue
    public final <R> ParallelFlowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> r4) {
        return flatMap(r4, false, Integer.MAX_VALUE, Flowable.bufferSize());
    }

    @CheckReturnValue
    public final <R> ParallelFlowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> r3, boolean r4) {
        return flatMap(r3, r4, Integer.MAX_VALUE, Flowable.bufferSize());
    }

    @CheckReturnValue
    public final <R> ParallelFlowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> r2, boolean r3, int r4) {
        return flatMap(r2, r3, r4, Flowable.bufferSize());
    }

    @CheckReturnValue
    public final <R> ParallelFlowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> r8, boolean r9, int r10, int r11) {
        ObjectHelper.requireNonNull(r8, "mapper is null");
        ObjectHelper.verifyPositive(r10, "maxConcurrency");
        ObjectHelper.verifyPositive(r11, "prefetch");
        return RxJavaPlugins.onAssembly(new ParallelFlatMap(this, r8, r9, r10, r11));
    }

    @CheckReturnValue
    public final <R> ParallelFlowable<R> concatMap(Function<? super T, ? extends Publisher<? extends R>> r2) {
        return concatMap(r2, 2);
    }

    @CheckReturnValue
    public final <R> ParallelFlowable<R> concatMap(Function<? super T, ? extends Publisher<? extends R>> r3, int r4) {
        ObjectHelper.requireNonNull(r3, "mapper is null");
        ObjectHelper.verifyPositive(r4, "prefetch");
        return RxJavaPlugins.onAssembly(new ParallelConcatMap(this, r3, r4, ErrorMode.IMMEDIATE));
    }

    @CheckReturnValue
    public final <R> ParallelFlowable<R> concatMapDelayError(Function<? super T, ? extends Publisher<? extends R>> r2, boolean r3) {
        return concatMapDelayError(r2, 2, r3);
    }

    @CheckReturnValue
    public final <R> ParallelFlowable<R> concatMapDelayError(Function<? super T, ? extends Publisher<? extends R>> r2, int r3, boolean r4) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        ObjectHelper.verifyPositive(r3, "prefetch");
        if (r4 == false) goto L5;
        ErrorMode r5 = ErrorMode.END;
    L7:
        return RxJavaPlugins.onAssembly(new ParallelConcatMap(this, r2, r3, r5));
    L5:
        r5 = ErrorMode.BOUNDARY;
        goto L7
    }
}
