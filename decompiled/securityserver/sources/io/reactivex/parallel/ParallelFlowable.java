package io.reactivex.parallel;

import a.a;
import androidx.appcompat.widget.ActivityChooserView;
import com.bytedance.apm.battery.dao.DBHelper;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
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

/* JADX INFO: loaded from: classes2.dex */
public abstract class ParallelFlowable<T> {
    public ParallelFlowable() {
    }

    @CheckReturnValue
    public static <T> ParallelFlowable<T> from(@NonNull Publisher<? extends T> r2) {
        return from(r2, Runtime.getRuntime().availableProcessors(), Flowable.bufferSize());
    }

    @CheckReturnValue
    @NonNull
    public static <T> ParallelFlowable<T> fromArray(@NonNull Publisher<T>... r1) {
        if (r1.length == 0) goto L7;
        return RxJavaPlugins.onAssembly(new ParallelFromArray(r1));
    L7:
        throw new IllegalArgumentException("Zero publishers not supported");
    }

    @CheckReturnValue
    @NonNull
    public final <R> R as(@NonNull ParallelFlowableConverter<T, R> r2) {
        return (R) ((ParallelFlowableConverter) ObjectHelper.requireNonNull(r2, "converter is null")).apply(this);
    }

    @CheckReturnValue
    @NonNull
    public final <C> ParallelFlowable<C> collect(@NonNull Callable<? extends C> r2, @NonNull BiConsumer<? super C, ? super T> r3) {
        ObjectHelper.requireNonNull(r2, "collectionSupplier is null");
        ObjectHelper.requireNonNull(r3, "collector is null");
        return RxJavaPlugins.onAssembly(new ParallelCollect(this, r2, r3));
    }

    @CheckReturnValue
    @NonNull
    public final <U> ParallelFlowable<U> compose(@NonNull ParallelTransformer<T, U> r2) {
        return RxJavaPlugins.onAssembly(((ParallelTransformer) ObjectHelper.requireNonNull(r2, "composer is null")).apply(this));
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> concatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> r2) {
        return concatMap(r2, 2);
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> concatMapDelayError(@NonNull Function<? super T, ? extends Publisher<? extends R>> r2, boolean r3) {
        return concatMapDelayError(r2, 2, r3);
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doAfterNext(@NonNull Consumer<? super T> r12) {
        ObjectHelper.requireNonNull(r12, "onAfterNext is null");
        Consumer r3 = Functions.emptyConsumer();
        Consumer r5 = Functions.emptyConsumer();
        Action r10 = Functions.EMPTY_ACTION;
        return RxJavaPlugins.onAssembly(new ParallelPeek(this, r3, r12, r5, r10, r10, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, r10));
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doAfterTerminated(@NonNull Action r12) {
        ObjectHelper.requireNonNull(r12, "onAfterTerminate is null");
        Consumer r3 = Functions.emptyConsumer();
        Consumer r4 = Functions.emptyConsumer();
        Consumer r5 = Functions.emptyConsumer();
        Action r10 = Functions.EMPTY_ACTION;
        return RxJavaPlugins.onAssembly(new ParallelPeek(this, r3, r4, r5, r10, r12, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, r10));
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doOnCancel(@NonNull Action r12) {
        ObjectHelper.requireNonNull(r12, "onCancel is null");
        Consumer r3 = Functions.emptyConsumer();
        Consumer r4 = Functions.emptyConsumer();
        Consumer r5 = Functions.emptyConsumer();
        Action r7 = Functions.EMPTY_ACTION;
        return RxJavaPlugins.onAssembly(new ParallelPeek(this, r3, r4, r5, r7, r7, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, r12));
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doOnComplete(@NonNull Action r12) {
        ObjectHelper.requireNonNull(r12, "onComplete is null");
        Consumer r3 = Functions.emptyConsumer();
        Consumer r4 = Functions.emptyConsumer();
        Consumer r5 = Functions.emptyConsumer();
        Action r10 = Functions.EMPTY_ACTION;
        return RxJavaPlugins.onAssembly(new ParallelPeek(this, r3, r4, r5, r12, r10, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, r10));
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doOnError(@NonNull Consumer<Throwable> r12) {
        ObjectHelper.requireNonNull(r12, "onError is null");
        Consumer r3 = Functions.emptyConsumer();
        Consumer r4 = Functions.emptyConsumer();
        Action r10 = Functions.EMPTY_ACTION;
        return RxJavaPlugins.onAssembly(new ParallelPeek(this, r3, r4, r12, r10, r10, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, r10));
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doOnNext(@NonNull Consumer<? super T> r12) {
        ObjectHelper.requireNonNull(r12, "onNext is null");
        Consumer r4 = Functions.emptyConsumer();
        Consumer r5 = Functions.emptyConsumer();
        Action r10 = Functions.EMPTY_ACTION;
        return RxJavaPlugins.onAssembly(new ParallelPeek(this, r12, r4, r5, r10, r10, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, r10));
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doOnRequest(@NonNull LongConsumer r12) {
        ObjectHelper.requireNonNull(r12, "onRequest is null");
        Consumer r3 = Functions.emptyConsumer();
        Consumer r4 = Functions.emptyConsumer();
        Consumer r5 = Functions.emptyConsumer();
        Action r10 = Functions.EMPTY_ACTION;
        return RxJavaPlugins.onAssembly(new ParallelPeek(this, r3, r4, r5, r10, r10, Functions.emptyConsumer(), r12, r10));
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doOnSubscribe(@NonNull Consumer<? super Subscription> r12) {
        ObjectHelper.requireNonNull(r12, "onSubscribe is null");
        Consumer r3 = Functions.emptyConsumer();
        Consumer r4 = Functions.emptyConsumer();
        Consumer r5 = Functions.emptyConsumer();
        Action r10 = Functions.EMPTY_ACTION;
        return RxJavaPlugins.onAssembly(new ParallelPeek(this, r3, r4, r5, r10, r10, r12, Functions.EMPTY_LONG_CONSUMER, r10));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> filter(@NonNull Predicate<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "predicate");
        return RxJavaPlugins.onAssembly(new ParallelFilter(this, r2));
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> r4) {
        return flatMap(r4, false, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Flowable.bufferSize());
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> map(@NonNull Function<? super T, ? extends R> r2) {
        ObjectHelper.requireNonNull(r2, "mapper");
        return RxJavaPlugins.onAssembly(new ParallelMap(this, r2));
    }

    public abstract int parallelism();

    @CheckReturnValue
    @NonNull
    public final Flowable<T> reduce(@NonNull BiFunction<T, T, T> r2) {
        ObjectHelper.requireNonNull(r2, "reducer");
        return RxJavaPlugins.onAssembly(new ParallelReduceFull(this, r2));
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> runOn(@NonNull Scheduler r2) {
        return runOn(r2, Flowable.bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> sequential() {
        return sequential(Flowable.bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> sequentialDelayError() {
        return sequentialDelayError(Flowable.bufferSize());
    }

    @CheckReturnValue
    @NonNull
    public final Flowable<T> sorted(@NonNull Comparator<? super T> r2) {
        return sorted(r2, 16);
    }

    public abstract void subscribe(@NonNull Subscriber<? super T>[] r1);

    @CheckReturnValue
    @NonNull
    public final <U> U to(@NonNull Function<? super ParallelFlowable<T>, U> r2) {
        return (U) ((Function) ObjectHelper.requireNonNull(r2, "converter is null")).apply(this);
    L4:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        throw ExceptionHelper.wrapOrThrow(th);
    }

    @CheckReturnValue
    @NonNull
    public final Flowable<List<T>> toSortedList(@NonNull Comparator<? super T> r2) {
        return toSortedList(r2, 16);
    }

    public final boolean validate(@NonNull Subscriber<?>[] r5) {
        int r4 = parallelism();
        if (r5.length == r4) goto L8;
        StringBuilder r6 = a.p(r4, "parallelism = ", ", subscribers = ");
        r6.append(r5.length);
        IllegalArgumentException r0 = new IllegalArgumentException(r6.toString());
        int r7 = r5.length;
        int r2 = 0;
    L5:
        if (r2 >= r7) goto L7;
        EmptySubscription.error(r0, r5[r2]);
        r2 = r2 + 1;
        goto L5
    L7:
        return false;
    L8:
        return true;
    }

    @CheckReturnValue
    public static <T> ParallelFlowable<T> from(@NonNull Publisher<? extends T> r1, int r2) {
        return from(r1, r2, Flowable.bufferSize());
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> concatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> r3, int r4) {
        ObjectHelper.requireNonNull(r3, "mapper is null");
        ObjectHelper.verifyPositive(r4, "prefetch");
        return RxJavaPlugins.onAssembly(new ParallelConcatMap(this, r3, r4, ErrorMode.IMMEDIATE));
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> concatMapDelayError(@NonNull Function<? super T, ? extends Publisher<? extends R>> r2, int r3, boolean r4) {
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

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> r3, boolean r4) {
        return flatMap(r3, r4, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Flowable.bufferSize());
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> runOn(@NonNull Scheduler r2, int r3) {
        ObjectHelper.requireNonNull(r2, "scheduler");
        ObjectHelper.verifyPositive(r3, "prefetch");
        return RxJavaPlugins.onAssembly(new ParallelRunOn(this, r2, r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> sequential(int r3) {
        ObjectHelper.verifyPositive(r3, "prefetch");
        return RxJavaPlugins.onAssembly(new ParallelJoin(this, r3, false));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> sequentialDelayError(int r3) {
        ObjectHelper.verifyPositive(r3, "prefetch");
        return RxJavaPlugins.onAssembly(new ParallelJoin(this, r3, true));
    }

    @CheckReturnValue
    @NonNull
    public final Flowable<T> sorted(@NonNull Comparator<? super T> r2, int r3) {
        ObjectHelper.requireNonNull(r2, "comparator is null");
        ObjectHelper.verifyPositive(r3, "capacityHint");
        return RxJavaPlugins.onAssembly(new ParallelSortedJoin(reduce(Functions.createArrayList((r3 / parallelism()) + 1), ListAddBiConsumer.instance()).map(new SorterFunction(r2)), r2));
    }

    @CheckReturnValue
    @NonNull
    public final Flowable<List<T>> toSortedList(@NonNull Comparator<? super T> r2, int r3) {
        ObjectHelper.requireNonNull(r2, "comparator is null");
        ObjectHelper.verifyPositive(r3, "capacityHint");
        return RxJavaPlugins.onAssembly(reduce(Functions.createArrayList((r3 / parallelism()) + 1), ListAddBiConsumer.instance()).map(new SorterFunction(r2)).reduce(new MergerBiFunction(r2)));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ParallelFlowable<T> from(@NonNull Publisher<? extends T> r1, int r2, int r3) {
        ObjectHelper.requireNonNull(r1, DBHelper.BATTERY_COL_SOURCE);
        ObjectHelper.verifyPositive(r2, "parallelism");
        ObjectHelper.verifyPositive(r3, "prefetch");
        return RxJavaPlugins.onAssembly(new ParallelFromPublisher(r1, r2, r3));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> filter(@NonNull Predicate<? super T> r2, @NonNull ParallelFailureHandling r3) {
        ObjectHelper.requireNonNull(r2, "predicate");
        ObjectHelper.requireNonNull(r3, "errorHandler is null");
        return RxJavaPlugins.onAssembly(new ParallelFilterTry(this, r2, r3));
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> r2, boolean r3, int r4) {
        return flatMap(r2, r3, r4, Flowable.bufferSize());
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> map(@NonNull Function<? super T, ? extends R> r2, @NonNull ParallelFailureHandling r3) {
        ObjectHelper.requireNonNull(r2, "mapper");
        ObjectHelper.requireNonNull(r3, "errorHandler is null");
        return RxJavaPlugins.onAssembly(new ParallelMapTry(this, r2, r3));
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> reduce(@NonNull Callable<R> r2, @NonNull BiFunction<R, ? super T, R> r3) {
        ObjectHelper.requireNonNull(r2, "initialSupplier");
        ObjectHelper.requireNonNull(r3, "reducer");
        return RxJavaPlugins.onAssembly(new ParallelReduce(this, r2, r3));
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> r8, boolean r9, int r10, int r11) {
        ObjectHelper.requireNonNull(r8, "mapper is null");
        ObjectHelper.verifyPositive(r10, "maxConcurrency");
        ObjectHelper.verifyPositive(r11, "prefetch");
        return RxJavaPlugins.onAssembly(new ParallelFlatMap(this, r8, r9, r10, r11));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> filter(@NonNull Predicate<? super T> r2, @NonNull BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> r3) {
        ObjectHelper.requireNonNull(r2, "predicate");
        ObjectHelper.requireNonNull(r3, "errorHandler is null");
        return RxJavaPlugins.onAssembly(new ParallelFilterTry(this, r2, r3));
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> map(@NonNull Function<? super T, ? extends R> r2, @NonNull BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> r3) {
        ObjectHelper.requireNonNull(r2, "mapper");
        ObjectHelper.requireNonNull(r3, "errorHandler is null");
        return RxJavaPlugins.onAssembly(new ParallelMapTry(this, r2, r3));
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doOnNext(@NonNull Consumer<? super T> r2, @NonNull ParallelFailureHandling r3) {
        ObjectHelper.requireNonNull(r2, "onNext is null");
        ObjectHelper.requireNonNull(r3, "errorHandler is null");
        return RxJavaPlugins.onAssembly(new ParallelDoOnNextTry(this, r2, r3));
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doOnNext(@NonNull Consumer<? super T> r2, @NonNull BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> r3) {
        ObjectHelper.requireNonNull(r2, "onNext is null");
        ObjectHelper.requireNonNull(r3, "errorHandler is null");
        return RxJavaPlugins.onAssembly(new ParallelDoOnNextTry(this, r2, r3));
    }
}
