package io.reactivex;

import androidx.appcompat.widget.ActivityChooserView;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.observers.BlockingMultiObserver;
import io.reactivex.internal.operators.flowable.FlowableConcatMapPublisher;
import io.reactivex.internal.operators.flowable.FlowableFlatMapPublisher;
import io.reactivex.internal.operators.maybe.MaybeAmb;
import io.reactivex.internal.operators.maybe.MaybeCache;
import io.reactivex.internal.operators.maybe.MaybeCallbackObserver;
import io.reactivex.internal.operators.maybe.MaybeConcatArray;
import io.reactivex.internal.operators.maybe.MaybeConcatArrayDelayError;
import io.reactivex.internal.operators.maybe.MaybeConcatIterable;
import io.reactivex.internal.operators.maybe.MaybeContains;
import io.reactivex.internal.operators.maybe.MaybeCount;
import io.reactivex.internal.operators.maybe.MaybeCreate;
import io.reactivex.internal.operators.maybe.MaybeDefer;
import io.reactivex.internal.operators.maybe.MaybeDelay;
import io.reactivex.internal.operators.maybe.MaybeDelayOtherPublisher;
import io.reactivex.internal.operators.maybe.MaybeDelaySubscriptionOtherPublisher;
import io.reactivex.internal.operators.maybe.MaybeDetach;
import io.reactivex.internal.operators.maybe.MaybeDoAfterSuccess;
import io.reactivex.internal.operators.maybe.MaybeDoFinally;
import io.reactivex.internal.operators.maybe.MaybeDoOnEvent;
import io.reactivex.internal.operators.maybe.MaybeDoOnTerminate;
import io.reactivex.internal.operators.maybe.MaybeEmpty;
import io.reactivex.internal.operators.maybe.MaybeEqualSingle;
import io.reactivex.internal.operators.maybe.MaybeError;
import io.reactivex.internal.operators.maybe.MaybeErrorCallable;
import io.reactivex.internal.operators.maybe.MaybeFilter;
import io.reactivex.internal.operators.maybe.MaybeFlatMapBiSelector;
import io.reactivex.internal.operators.maybe.MaybeFlatMapCompletable;
import io.reactivex.internal.operators.maybe.MaybeFlatMapIterableFlowable;
import io.reactivex.internal.operators.maybe.MaybeFlatMapIterableObservable;
import io.reactivex.internal.operators.maybe.MaybeFlatMapNotification;
import io.reactivex.internal.operators.maybe.MaybeFlatMapSingle;
import io.reactivex.internal.operators.maybe.MaybeFlatMapSingleElement;
import io.reactivex.internal.operators.maybe.MaybeFlatten;
import io.reactivex.internal.operators.maybe.MaybeFromAction;
import io.reactivex.internal.operators.maybe.MaybeFromCallable;
import io.reactivex.internal.operators.maybe.MaybeFromCompletable;
import io.reactivex.internal.operators.maybe.MaybeFromFuture;
import io.reactivex.internal.operators.maybe.MaybeFromRunnable;
import io.reactivex.internal.operators.maybe.MaybeFromSingle;
import io.reactivex.internal.operators.maybe.MaybeHide;
import io.reactivex.internal.operators.maybe.MaybeIgnoreElementCompletable;
import io.reactivex.internal.operators.maybe.MaybeIsEmptySingle;
import io.reactivex.internal.operators.maybe.MaybeJust;
import io.reactivex.internal.operators.maybe.MaybeLift;
import io.reactivex.internal.operators.maybe.MaybeMap;
import io.reactivex.internal.operators.maybe.MaybeMaterialize;
import io.reactivex.internal.operators.maybe.MaybeMergeArray;
import io.reactivex.internal.operators.maybe.MaybeNever;
import io.reactivex.internal.operators.maybe.MaybeObserveOn;
import io.reactivex.internal.operators.maybe.MaybeOnErrorComplete;
import io.reactivex.internal.operators.maybe.MaybeOnErrorNext;
import io.reactivex.internal.operators.maybe.MaybeOnErrorReturn;
import io.reactivex.internal.operators.maybe.MaybePeek;
import io.reactivex.internal.operators.maybe.MaybeSubscribeOn;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmpty;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmptySingle;
import io.reactivex.internal.operators.maybe.MaybeTakeUntilMaybe;
import io.reactivex.internal.operators.maybe.MaybeTakeUntilPublisher;
import io.reactivex.internal.operators.maybe.MaybeTimeoutMaybe;
import io.reactivex.internal.operators.maybe.MaybeTimeoutPublisher;
import io.reactivex.internal.operators.maybe.MaybeTimer;
import io.reactivex.internal.operators.maybe.MaybeToFlowable;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.maybe.MaybeToPublisher;
import io.reactivex.internal.operators.maybe.MaybeToSingle;
import io.reactivex.internal.operators.maybe.MaybeUnsafeCreate;
import io.reactivex.internal.operators.maybe.MaybeUnsubscribeOn;
import io.reactivex.internal.operators.maybe.MaybeUsing;
import io.reactivex.internal.operators.maybe.MaybeZipArray;
import io.reactivex.internal.operators.maybe.MaybeZipIterable;
import io.reactivex.internal.operators.mixed.MaybeFlatMapObservable;
import io.reactivex.internal.operators.mixed.MaybeFlatMapPublisher;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Maybe<T> implements MaybeSource<T> {
    public Maybe() {
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T> Maybe<T> amb(Iterable<? extends MaybeSource<? extends T>> r2) {
        ObjectHelper.requireNonNull(r2, "sources is null");
        return RxJavaPlugins.onAssembly(new MaybeAmb(null, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public static <T> Maybe<T> ambArray(MaybeSource<? extends T>... r2) {
        if (r2.length != 0) goto L7;
        return empty();
    L7:
        if (r2.length != 1) goto L11;
        return wrap(r2[0]);
    L11:
        return RxJavaPlugins.onAssembly(new MaybeAmb(r2, null));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> concat(Iterable<? extends MaybeSource<? extends T>> r1) {
        ObjectHelper.requireNonNull(r1, "sources is null");
        return RxJavaPlugins.onAssembly(new MaybeConcatIterable(r1));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> concatArray(MaybeSource<? extends T>... r2) {
        ObjectHelper.requireNonNull(r2, "sources is null");
        if (r2.length != 0) goto L7;
        return Flowable.empty();
    L7:
        if (r2.length != 1) goto L11;
        return RxJavaPlugins.onAssembly(new MaybeToFlowable(r2[0]));
    L11:
        return RxJavaPlugins.onAssembly(new MaybeConcatArray(r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatArrayDelayError(MaybeSource<? extends T>... r2) {
        if (r2.length != 0) goto L7;
        return Flowable.empty();
    L7:
        if (r2.length != 1) goto L11;
        return RxJavaPlugins.onAssembly(new MaybeToFlowable(r2[0]));
    L11:
        return RxJavaPlugins.onAssembly(new MaybeConcatArrayDelayError(r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatArrayEager(MaybeSource<? extends T>... r1) {
        return Flowable.fromArray(r1).concatMapEager(MaybeToPublisher.instance());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> concatDelayError(Iterable<? extends MaybeSource<? extends T>> r1) {
        ObjectHelper.requireNonNull(r1, "sources is null");
        return Flowable.fromIterable(r1).concatMapDelayError(MaybeToPublisher.instance());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatEager(Iterable<? extends MaybeSource<? extends T>> r1) {
        return Flowable.fromIterable(r1).concatMapEager(MaybeToPublisher.instance());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T> Maybe<T> create(MaybeOnSubscribe<T> r1) {
        ObjectHelper.requireNonNull(r1, "onSubscribe is null");
        return RxJavaPlugins.onAssembly(new MaybeCreate(r1));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T> Maybe<T> defer(Callable<? extends MaybeSource<? extends T>> r1) {
        ObjectHelper.requireNonNull(r1, "maybeSupplier is null");
        return RxJavaPlugins.onAssembly(new MaybeDefer(r1));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public static <T> Maybe<T> empty() {
        return RxJavaPlugins.onAssembly(MaybeEmpty.INSTANCE);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T> Maybe<T> error(Throwable r1) {
        ObjectHelper.requireNonNull(r1, "exception is null");
        return RxJavaPlugins.onAssembly(new MaybeError(r1));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T> Maybe<T> fromAction(Action r1) {
        ObjectHelper.requireNonNull(r1, "run is null");
        return RxJavaPlugins.onAssembly(new MaybeFromAction(r1));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T> Maybe<T> fromCallable(@NonNull Callable<? extends T> r1) {
        ObjectHelper.requireNonNull(r1, "callable is null");
        return RxJavaPlugins.onAssembly(new MaybeFromCallable(r1));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T> Maybe<T> fromCompletable(CompletableSource r1) {
        ObjectHelper.requireNonNull(r1, "completableSource is null");
        return RxJavaPlugins.onAssembly(new MaybeFromCompletable(r1));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T> Maybe<T> fromFuture(Future<? extends T> r4) {
        ObjectHelper.requireNonNull(r4, "future is null");
        return RxJavaPlugins.onAssembly(new MaybeFromFuture(r4, 0, null));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T> Maybe<T> fromRunnable(Runnable r1) {
        ObjectHelper.requireNonNull(r1, "run is null");
        return RxJavaPlugins.onAssembly(new MaybeFromRunnable(r1));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T> Maybe<T> fromSingle(SingleSource<T> r1) {
        ObjectHelper.requireNonNull(r1, "singleSource is null");
        return RxJavaPlugins.onAssembly(new MaybeFromSingle(r1));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T> Maybe<T> just(T r1) {
        ObjectHelper.requireNonNull(r1, "item is null");
        return RxJavaPlugins.onAssembly(new MaybeJust(r1));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> merge(Iterable<? extends MaybeSource<? extends T>> r0) {
        return merge(Flowable.fromIterable(r0));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> mergeArray(MaybeSource<? extends T>... r2) {
        ObjectHelper.requireNonNull(r2, "sources is null");
        if (r2.length != 0) goto L7;
        return Flowable.empty();
    L7:
        if (r2.length != 1) goto L11;
        return RxJavaPlugins.onAssembly(new MaybeToFlowable(r2[0]));
    L11:
        return RxJavaPlugins.onAssembly(new MaybeMergeArray(r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeArrayDelayError(MaybeSource<? extends T>... r3) {
        if (r3.length != 0) goto L7;
        return Flowable.empty();
    L7:
        return Flowable.fromArray(r3).flatMap(MaybeToPublisher.instance(), true, r3.length);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(Iterable<? extends MaybeSource<? extends T>> r2) {
        return Flowable.fromIterable(r2).flatMap(MaybeToPublisher.instance(), true);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public static <T> Maybe<T> never() {
        return RxJavaPlugins.onAssembly(MaybeNever.INSTANCE);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public static <T> Single<Boolean> sequenceEqual(MaybeSource<? extends T> r1, MaybeSource<? extends T> r2) {
        return sequenceEqual(r1, r2, ObjectHelper.equalsPredicate());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static Maybe<Long> timer(long r1, TimeUnit r3) {
        return timer(r1, r3, Schedulers.computation());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T> Maybe<T> unsafeCreate(MaybeSource<T> r1) {
        if ((r1 instanceof Maybe) == true) goto L7;
        ObjectHelper.requireNonNull(r1, "onSubscribe is null");
        return RxJavaPlugins.onAssembly(new MaybeUnsafeCreate(r1));
    L7:
        throw new IllegalArgumentException("unsafeCreate(Maybe) should be upgraded");
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public static <T, D> Maybe<T> using(Callable<? extends D> r1, Function<? super D, ? extends MaybeSource<? extends T>> r2, Consumer<? super D> r3) {
        return using(r1, r2, r3, true);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T> Maybe<T> wrap(MaybeSource<T> r1) {
        if ((r1 instanceof Maybe) == true) goto L5;
        ObjectHelper.requireNonNull(r1, "onSubscribe is null");
        return RxJavaPlugins.onAssembly(new MaybeUnsafeCreate(r1));
    L5:
        return RxJavaPlugins.onAssembly((Maybe) r1);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T, R> Maybe<R> zip(Iterable<? extends MaybeSource<? extends T>> r1, Function<? super Object[], ? extends R> r2) {
        ObjectHelper.requireNonNull(r2, "zipper is null");
        ObjectHelper.requireNonNull(r1, "sources is null");
        return RxJavaPlugins.onAssembly(new MaybeZipIterable(r1, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T, R> Maybe<R> zipArray(Function<? super Object[], ? extends R> r1, MaybeSource<? extends T>... r2) {
        ObjectHelper.requireNonNull(r2, "sources is null");
        if (r2.length == 0) goto L5;
        ObjectHelper.requireNonNull(r1, "zipper is null");
        return RxJavaPlugins.onAssembly(new MaybeZipArray(r2, r1));
    L5:
        return empty();
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final Maybe<T> ambWith(MaybeSource<? extends T> r3) {
        ObjectHelper.requireNonNull(r3, "other is null");
        return ambArray(new MaybeSource[]{this, r3});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <R> R as(@NonNull MaybeConverter<T, ? extends R> r2) {
        return (R) ((MaybeConverter) ObjectHelper.requireNonNull(r2, "converter is null")).apply(this);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final T blockingGet() {
        BlockingMultiObserver r0 = new BlockingMultiObserver();
        subscribe(r0);
        return (T) r0.blockingGet();
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final Maybe<T> cache() {
        return RxJavaPlugins.onAssembly(new MaybeCache(this));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final <U> Maybe<U> cast(Class<? extends U> r2) {
        ObjectHelper.requireNonNull(r2, "clazz is null");
        return (Maybe<U>) map(Functions.castFunction(r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <R> Maybe<R> compose(MaybeTransformer<? super T, ? extends R> r2) {
        return wrap(((MaybeTransformer) ObjectHelper.requireNonNull(r2, "transformer is null")).apply(this));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final <R> Maybe<R> concatMap(Function<? super T, ? extends MaybeSource<? extends R>> r2) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        return RxJavaPlugins.onAssembly(new MaybeFlatten(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> concatWith(MaybeSource<? extends T> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return concat(this, r2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final Single<Boolean> contains(Object r2) {
        ObjectHelper.requireNonNull(r2, "item is null");
        return RxJavaPlugins.onAssembly(new MaybeContains(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final Single<Long> count() {
        return RxJavaPlugins.onAssembly(new MaybeCount(this));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final Maybe<T> defaultIfEmpty(T r2) {
        ObjectHelper.requireNonNull(r2, "defaultItem is null");
        return switchIfEmpty(just(r2));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Maybe<T> delay(long r2, TimeUnit r4) {
        return delay(r2, r4, Schedulers.computation());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final <U> Maybe<T> delaySubscription(Publisher<U> r2) {
        ObjectHelper.requireNonNull(r2, "subscriptionIndicator is null");
        return RxJavaPlugins.onAssembly(new MaybeDelaySubscriptionOtherPublisher(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final Maybe<T> doAfterSuccess(Consumer<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "onAfterSuccess is null");
        return RxJavaPlugins.onAssembly(new MaybeDoAfterSuccess(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final Maybe<T> doAfterTerminate(Action r10) {
        Consumer r2 = Functions.emptyConsumer();
        Consumer r3 = Functions.emptyConsumer();
        Consumer r4 = Functions.emptyConsumer();
        Action r7 = Functions.EMPTY_ACTION;
        return RxJavaPlugins.onAssembly(new MaybePeek(this, r2, r3, r4, r7, (Action) ObjectHelper.requireNonNull(r10, "onAfterTerminate is null"), r7));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final Maybe<T> doFinally(Action r2) {
        ObjectHelper.requireNonNull(r2, "onFinally is null");
        return RxJavaPlugins.onAssembly(new MaybeDoFinally(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final Maybe<T> doOnComplete(Action r10) {
        Consumer r2 = Functions.emptyConsumer();
        Consumer r3 = Functions.emptyConsumer();
        Consumer r4 = Functions.emptyConsumer();
        Action r5 = (Action) ObjectHelper.requireNonNull(r10, "onComplete is null");
        Action r7 = Functions.EMPTY_ACTION;
        return RxJavaPlugins.onAssembly(new MaybePeek(this, r2, r3, r4, r5, r7, r7));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final Maybe<T> doOnDispose(Action r10) {
        Consumer r2 = Functions.emptyConsumer();
        Consumer r3 = Functions.emptyConsumer();
        Consumer r4 = Functions.emptyConsumer();
        Action r6 = Functions.EMPTY_ACTION;
        return RxJavaPlugins.onAssembly(new MaybePeek(this, r2, r3, r4, r6, r6, (Action) ObjectHelper.requireNonNull(r10, "onDispose is null")));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final Maybe<T> doOnError(Consumer<? super Throwable> r10) {
        Consumer r2 = Functions.emptyConsumer();
        Consumer r3 = Functions.emptyConsumer();
        Consumer r4 = (Consumer) ObjectHelper.requireNonNull(r10, "onError is null");
        Action r7 = Functions.EMPTY_ACTION;
        return RxJavaPlugins.onAssembly(new MaybePeek(this, r2, r3, r4, r7, r7, r7));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final Maybe<T> doOnEvent(BiConsumer<? super T, ? super Throwable> r2) {
        ObjectHelper.requireNonNull(r2, "onEvent is null");
        return RxJavaPlugins.onAssembly(new MaybeDoOnEvent(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final Maybe<T> doOnSubscribe(Consumer<? super Disposable> r10) {
        Consumer r2 = (Consumer) ObjectHelper.requireNonNull(r10, "onSubscribe is null");
        Consumer r3 = Functions.emptyConsumer();
        Consumer r4 = Functions.emptyConsumer();
        Action r7 = Functions.EMPTY_ACTION;
        return RxJavaPlugins.onAssembly(new MaybePeek(this, r2, r3, r4, r7, r7, r7));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final Maybe<T> doOnSuccess(Consumer<? super T> r10) {
        Consumer r2 = Functions.emptyConsumer();
        Consumer r3 = (Consumer) ObjectHelper.requireNonNull(r10, "onSuccess is null");
        Consumer r4 = Functions.emptyConsumer();
        Action r7 = Functions.EMPTY_ACTION;
        return RxJavaPlugins.onAssembly(new MaybePeek(this, r2, r3, r4, r7, r7, r7));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @Experimental
    @NonNull
    public final Maybe<T> doOnTerminate(Action r2) {
        ObjectHelper.requireNonNull(r2, "onTerminate is null");
        return RxJavaPlugins.onAssembly(new MaybeDoOnTerminate(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final Maybe<T> filter(Predicate<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "predicate is null");
        return RxJavaPlugins.onAssembly(new MaybeFilter(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final <R> Maybe<R> flatMap(Function<? super T, ? extends MaybeSource<? extends R>> r2) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        return RxJavaPlugins.onAssembly(new MaybeFlatten(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> r2) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        return RxJavaPlugins.onAssembly(new MaybeFlatMapCompletable(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final <R> Observable<R> flatMapObservable(Function<? super T, ? extends ObservableSource<? extends R>> r2) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        return RxJavaPlugins.onAssembly(new MaybeFlatMapObservable(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> flatMapPublisher(Function<? super T, ? extends Publisher<? extends R>> r2) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        return RxJavaPlugins.onAssembly(new MaybeFlatMapPublisher(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final <R> Single<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> r2) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        return RxJavaPlugins.onAssembly(new MaybeFlatMapSingle(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final <R> Maybe<R> flatMapSingleElement(Function<? super T, ? extends SingleSource<? extends R>> r2) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        return RxJavaPlugins.onAssembly(new MaybeFlatMapSingleElement(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <U> Flowable<U> flattenAsFlowable(Function<? super T, ? extends Iterable<? extends U>> r2) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        return RxJavaPlugins.onAssembly(new MaybeFlatMapIterableFlowable(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final <U> Observable<U> flattenAsObservable(Function<? super T, ? extends Iterable<? extends U>> r2) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        return RxJavaPlugins.onAssembly(new MaybeFlatMapIterableObservable(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final Maybe<T> hide() {
        return RxJavaPlugins.onAssembly(new MaybeHide(this));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final Completable ignoreElement() {
        return RxJavaPlugins.onAssembly(new MaybeIgnoreElementCompletable(this));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final Single<Boolean> isEmpty() {
        return RxJavaPlugins.onAssembly(new MaybeIsEmptySingle(this));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final <R> Maybe<R> lift(MaybeOperator<? extends R, ? super T> r2) {
        ObjectHelper.requireNonNull(r2, "lift is null");
        return RxJavaPlugins.onAssembly(new MaybeLift(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final <R> Maybe<R> map(Function<? super T, ? extends R> r2) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        return RxJavaPlugins.onAssembly(new MaybeMap(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @Experimental
    public final Single<Notification<T>> materialize() {
        return RxJavaPlugins.onAssembly(new MaybeMaterialize(this));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> mergeWith(MaybeSource<? extends T> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return merge(this, r2);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    @NonNull
    public final Maybe<T> observeOn(Scheduler r2) {
        ObjectHelper.requireNonNull(r2, "scheduler is null");
        return RxJavaPlugins.onAssembly(new MaybeObserveOn(this, r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final <U> Maybe<U> ofType(Class<U> r2) {
        ObjectHelper.requireNonNull(r2, "clazz is null");
        return filter(Functions.isInstanceOf(r2)).cast(r2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final Maybe<T> onErrorComplete() {
        return onErrorComplete(Functions.alwaysTrue());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final Maybe<T> onErrorResumeNext(MaybeSource<? extends T> r2) {
        ObjectHelper.requireNonNull(r2, "next is null");
        return onErrorResumeNext(Functions.justFunction(r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final Maybe<T> onErrorReturn(Function<? super Throwable, ? extends T> r2) {
        ObjectHelper.requireNonNull(r2, "valueSupplier is null");
        return RxJavaPlugins.onAssembly(new MaybeOnErrorReturn(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final Maybe<T> onErrorReturnItem(T r2) {
        ObjectHelper.requireNonNull(r2, "item is null");
        return onErrorReturn(Functions.justFunction(r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final Maybe<T> onExceptionResumeNext(MaybeSource<? extends T> r3) {
        ObjectHelper.requireNonNull(r3, "next is null");
        return RxJavaPlugins.onAssembly(new MaybeOnErrorNext(this, Functions.justFunction(r3), false));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final Maybe<T> onTerminateDetach() {
        return RxJavaPlugins.onAssembly(new MaybeDetach(this));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> repeat() {
        return repeat(Long.MAX_VALUE);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> repeatUntil(BooleanSupplier r1) {
        return toFlowable().repeatUntil(r1);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> r1) {
        return toFlowable().repeatWhen(r1);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final Maybe<T> retry() {
        return retry(Long.MAX_VALUE, Functions.alwaysTrue());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final Maybe<T> retryUntil(BooleanSupplier r3) {
        ObjectHelper.requireNonNull(r3, "stop is null");
        return retry(Long.MAX_VALUE, Functions.predicateReverseFor(r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final Maybe<T> retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> r1) {
        return toFlowable().retryWhen(r1).singleElement();
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    public final Disposable subscribe() {
        return subscribe(Functions.emptyConsumer(), Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
    }

    public abstract void subscribeActual(MaybeObserver<? super T> r1);

    @SchedulerSupport("custom")
    @CheckReturnValue
    @NonNull
    public final Maybe<T> subscribeOn(Scheduler r2) {
        ObjectHelper.requireNonNull(r2, "scheduler is null");
        return RxJavaPlugins.onAssembly(new MaybeSubscribeOn(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <E extends MaybeObserver<? super T>> E subscribeWith(E r1) {
        subscribe(r1);
        return r1;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final Maybe<T> switchIfEmpty(MaybeSource<? extends T> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new MaybeSwitchIfEmpty(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final <U> Maybe<T> takeUntil(MaybeSource<U> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new MaybeTakeUntilMaybe(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final TestObserver<T> test() {
        TestObserver<T> r0 = new TestObserver();
        subscribe(r0);
        return r0;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Maybe<T> timeout(long r2, TimeUnit r4) {
        return timeout(r2, r4, Schedulers.computation());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final <R> R to(Function<? super Maybe<T>, R> r2) {
        return (R) ((Function) ObjectHelper.requireNonNull(r2, "convert is null")).apply(this);
    L4:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        throw ExceptionHelper.wrapOrThrow(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> toFlowable() {
        if ((this instanceof FuseToFlowable) == false) goto L7;
        return ((FuseToFlowable) this).fuseToFlowable();
    L7:
        return RxJavaPlugins.onAssembly(new MaybeToFlowable(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final Observable<T> toObservable() {
        if ((this instanceof FuseToObservable) == false) goto L7;
        return ((FuseToObservable) this).fuseToObservable();
    L7:
        return RxJavaPlugins.onAssembly(new MaybeToObservable(this));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final Single<T> toSingle(T r2) {
        ObjectHelper.requireNonNull(r2, "defaultValue is null");
        return RxJavaPlugins.onAssembly(new MaybeToSingle(this, r2));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    @NonNull
    public final Maybe<T> unsubscribeOn(Scheduler r2) {
        ObjectHelper.requireNonNull(r2, "scheduler is null");
        return RxJavaPlugins.onAssembly(new MaybeUnsubscribeOn(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final <U, R> Maybe<R> zipWith(MaybeSource<? extends U> r2, BiFunction<? super T, ? super U, ? extends R> r3) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return zip(this, r2, r3);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatEager(Publisher<? extends MaybeSource<? extends T>> r1) {
        return Flowable.fromPublisher(r1).concatMapEager(MaybeToPublisher.instance());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> merge(Publisher<? extends MaybeSource<? extends T>> r1) {
        return merge(r1, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends MaybeSource<? extends T>> r1) {
        return mergeDelayError(r1, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T> Single<Boolean> sequenceEqual(MaybeSource<? extends T> r1, MaybeSource<? extends T> r2, BiPredicate<? super T, ? super T> r3) {
        ObjectHelper.requireNonNull(r1, "source1 is null");
        ObjectHelper.requireNonNull(r2, "source2 is null");
        ObjectHelper.requireNonNull(r3, "isEqual is null");
        return RxJavaPlugins.onAssembly(new MaybeEqualSingle(r1, r2, r3));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    @NonNull
    public static Maybe<Long> timer(long r3, TimeUnit r5, Scheduler r6) {
        ObjectHelper.requireNonNull(r5, "unit is null");
        ObjectHelper.requireNonNull(r6, "scheduler is null");
        return RxJavaPlugins.onAssembly(new MaybeTimer(Math.max(0, r3), r5, r6));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T, D> Maybe<T> using(Callable<? extends D> r1, Function<? super D, ? extends MaybeSource<? extends T>> r2, Consumer<? super D> r3, boolean r4) {
        ObjectHelper.requireNonNull(r1, "resourceSupplier is null");
        ObjectHelper.requireNonNull(r2, "sourceSupplier is null");
        ObjectHelper.requireNonNull(r3, "disposer is null");
        return RxJavaPlugins.onAssembly(new MaybeUsing(r1, r2, r3, r4));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    @NonNull
    public final Maybe<T> delay(long r8, TimeUnit r10, Scheduler r11) {
        ObjectHelper.requireNonNull(r10, "unit is null");
        ObjectHelper.requireNonNull(r11, "scheduler is null");
        return RxJavaPlugins.onAssembly(new MaybeDelay(this, Math.max(0, r8), r10, r11));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final Maybe<T> onErrorComplete(Predicate<? super Throwable> r2) {
        ObjectHelper.requireNonNull(r2, "predicate is null");
        return RxJavaPlugins.onAssembly(new MaybeOnErrorComplete(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> repeat(long r1) {
        return toFlowable().repeat(r1);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final Maybe<T> retry(BiPredicate<? super Integer, ? super Throwable> r1) {
        return toFlowable().retry(r1).singleElement();
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> r3) {
        return subscribe(r3, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    @NonNull
    public final Maybe<T> timeout(long r8, TimeUnit r10, MaybeSource<? extends T> r11) {
        ObjectHelper.requireNonNull(r11, "fallback is null");
        return timeout(r8, r10, Schedulers.computation(), r11);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> concat(MaybeSource<? extends T> r2, MaybeSource<? extends T> r3) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        return concatArray(new MaybeSource[]{r2, r3});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatDelayError(Publisher<? extends MaybeSource<? extends T>> r1) {
        return Flowable.fromPublisher(r1).concatMapDelayError(MaybeToPublisher.instance());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T> Maybe<T> error(Callable<? extends Throwable> r1) {
        ObjectHelper.requireNonNull(r1, "errorSupplier is null");
        return RxJavaPlugins.onAssembly(new MaybeErrorCallable(r1));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T> Maybe<T> fromFuture(Future<? extends T> r1, long r2, TimeUnit r4) {
        ObjectHelper.requireNonNull(r1, "future is null");
        ObjectHelper.requireNonNull(r4, "unit is null");
        return RxJavaPlugins.onAssembly(new MaybeFromFuture(r1, r2, r4));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> merge(Publisher<? extends MaybeSource<? extends T>> r7, int r8) {
        ObjectHelper.requireNonNull(r7, "source is null");
        ObjectHelper.verifyPositive(r8, "maxConcurrency");
        return RxJavaPlugins.onAssembly(new FlowableFlatMapPublisher(r7, MaybeToPublisher.instance(), false, r8, 1));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends MaybeSource<? extends T>> r7, int r8) {
        ObjectHelper.requireNonNull(r7, "source is null");
        ObjectHelper.verifyPositive(r8, "maxConcurrency");
        return RxJavaPlugins.onAssembly(new FlowableFlatMapPublisher(r7, MaybeToPublisher.instance(), true, r8, 1));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Maybe<T> delaySubscription(long r2, TimeUnit r4) {
        return delaySubscription(r2, r4, Schedulers.computation());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final <R> Maybe<R> flatMap(Function<? super T, ? extends MaybeSource<? extends R>> r2, Function<? super Throwable, ? extends MaybeSource<? extends R>> r3, Callable<? extends MaybeSource<? extends R>> r4) {
        ObjectHelper.requireNonNull(r2, "onSuccessMapper is null");
        ObjectHelper.requireNonNull(r3, "onErrorMapper is null");
        ObjectHelper.requireNonNull(r4, "onCompleteSupplier is null");
        return RxJavaPlugins.onAssembly(new MaybeFlatMapNotification(this, r2, r3, r4));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final Maybe<T> onErrorResumeNext(Function<? super Throwable, ? extends MaybeSource<? extends T>> r3) {
        ObjectHelper.requireNonNull(r3, "resumeFunction is null");
        return RxJavaPlugins.onAssembly(new MaybeOnErrorNext(this, r3, true));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final Maybe<T> retry(long r2) {
        return retry(r2, Functions.alwaysTrue());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> r2, Consumer<? super Throwable> r3) {
        return subscribe(r2, r3, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final Single<T> switchIfEmpty(SingleSource<? extends T> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new MaybeSwitchIfEmptySingle(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final <U> Maybe<T> takeUntil(Publisher<U> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new MaybeTakeUntilPublisher(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final TestObserver<T> test(boolean r2) {
        TestObserver<T> r0 = new TestObserver();
        if (r2 == false) goto L5;
        r0.cancel();
    L5:
        subscribe(r0);
        return r0;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final Single<T> toSingle() {
        return RxJavaPlugins.onAssembly(new MaybeToSingle(this, null));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T1, T2, R> Maybe<R> zip(MaybeSource<? extends T1> r2, MaybeSource<? extends T2> r3, BiFunction<? super T1, ? super T2, ? extends R> r4) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        return zipArray(Functions.toFunction(r4), new MaybeSource[]{r2, r3});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final T blockingGet(T r2) {
        ObjectHelper.requireNonNull(r2, "defaultValue is null");
        BlockingMultiObserver r0 = new BlockingMultiObserver();
        subscribe(r0);
        return (T) r0.blockingGet(r2);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Maybe<T> delaySubscription(long r1, TimeUnit r3, Scheduler r4) {
        return delaySubscription(Flowable.timer(r1, r3, r4));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final Maybe<T> retry(long r1, Predicate<? super Throwable> r3) {
        return toFlowable().retry(r1, r3).singleElement();
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final Disposable subscribe(Consumer<? super T> r2, Consumer<? super Throwable> r3, Action r4) {
        ObjectHelper.requireNonNull(r2, "onSuccess is null");
        ObjectHelper.requireNonNull(r3, "onError is null");
        ObjectHelper.requireNonNull(r4, "onComplete is null");
        return (Disposable) subscribeWith(new MaybeCallbackObserver(r2, r3, r4));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    @NonNull
    public final Maybe<T> timeout(long r2, TimeUnit r4, Scheduler r5, MaybeSource<? extends T> r6) {
        ObjectHelper.requireNonNull(r6, "fallback is null");
        return timeout(timer(r2, r4, r5), r6);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final <U, V> Maybe<T> delay(Publisher<U> r2) {
        ObjectHelper.requireNonNull(r2, "delayIndicator is null");
        return RxJavaPlugins.onAssembly(new MaybeDelayOtherPublisher(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final Maybe<T> retry(Predicate<? super Throwable> r3) {
        return retry(Long.MAX_VALUE, r3);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> concat(MaybeSource<? extends T> r2, MaybeSource<? extends T> r3, MaybeSource<? extends T> r4) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        return concatArray(new MaybeSource[]{r2, r3, r4});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T> Maybe<T> merge(MaybeSource<? extends MaybeSource<? extends T>> r2) {
        ObjectHelper.requireNonNull(r2, "source is null");
        return RxJavaPlugins.onAssembly(new MaybeFlatten(r2, Functions.identity()));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> mergeDelayError(MaybeSource<? extends T> r2, MaybeSource<? extends T> r3) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        return mergeArrayDelayError(new MaybeSource[]{r2, r3});
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Maybe<T> timeout(long r1, TimeUnit r3, Scheduler r4) {
        return timeout(timer(r1, r3, r4));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T1, T2, T3, R> Maybe<R> zip(MaybeSource<? extends T1> r2, MaybeSource<? extends T2> r3, MaybeSource<? extends T3> r4, Function3<? super T1, ? super T2, ? super T3, ? extends R> r5) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        return zipArray(Functions.toFunction(r5), new MaybeSource[]{r2, r3, r4});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final <U, R> Maybe<R> flatMap(Function<? super T, ? extends MaybeSource<? extends U>> r2, BiFunction<? super T, ? super U, ? extends R> r3) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        ObjectHelper.requireNonNull(r3, "resultSelector is null");
        return RxJavaPlugins.onAssembly(new MaybeFlatMapBiSelector(this, r2, r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final <U> Maybe<T> timeout(MaybeSource<U> r3) {
        ObjectHelper.requireNonNull(r3, "timeoutIndicator is null");
        return RxJavaPlugins.onAssembly(new MaybeTimeoutMaybe(this, r3, null));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> merge(MaybeSource<? extends T> r2, MaybeSource<? extends T> r3) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        return mergeArray(new MaybeSource[]{r2, r3});
    }

    @Override // io.reactivex.MaybeSource
    @SchedulerSupport(SchedulerSupport.NONE)
    public final void subscribe(MaybeObserver<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "observer is null");
        MaybeObserver<? super T> r3 = RxJavaPlugins.onSubscribe(this, r2);
        ObjectHelper.requireNonNull(r3, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        subscribeActual(r3);     // Catch: Throwable -> L5 NullPointerException -> L8
        return;
    L8:
        e = move-exception;
        throw e;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        NullPointerException r4 = new NullPointerException("subscribeActual failed");
        r4.initCause(th);
        throw r4;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> mergeDelayError(MaybeSource<? extends T> r2, MaybeSource<? extends T> r3, MaybeSource<? extends T> r4) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        return mergeArrayDelayError(new MaybeSource[]{r2, r3, r4});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public final <U> Maybe<T> timeout(MaybeSource<U> r2, MaybeSource<? extends T> r3) {
        ObjectHelper.requireNonNull(r2, "timeoutIndicator is null");
        ObjectHelper.requireNonNull(r3, "fallback is null");
        return RxJavaPlugins.onAssembly(new MaybeTimeoutMaybe(this, r2, r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> concat(MaybeSource<? extends T> r2, MaybeSource<? extends T> r3, MaybeSource<? extends T> r4, MaybeSource<? extends T> r5) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        ObjectHelper.requireNonNull(r5, "source4 is null");
        return concatArray(new MaybeSource[]{r2, r3, r4, r5});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> merge(MaybeSource<? extends T> r2, MaybeSource<? extends T> r3, MaybeSource<? extends T> r4) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        return mergeArray(new MaybeSource[]{r2, r3, r4});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T1, T2, T3, T4, R> Maybe<R> zip(MaybeSource<? extends T1> r2, MaybeSource<? extends T2> r3, MaybeSource<? extends T3> r4, MaybeSource<? extends T4> r5, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> r6) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        ObjectHelper.requireNonNull(r5, "source4 is null");
        return zipArray(Functions.toFunction(r6), new MaybeSource[]{r2, r3, r4, r5});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final <U> Maybe<T> timeout(Publisher<U> r3) {
        ObjectHelper.requireNonNull(r3, "timeoutIndicator is null");
        return RxJavaPlugins.onAssembly(new MaybeTimeoutPublisher(this, r3, null));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> mergeDelayError(MaybeSource<? extends T> r2, MaybeSource<? extends T> r3, MaybeSource<? extends T> r4, MaybeSource<? extends T> r5) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        ObjectHelper.requireNonNull(r5, "source4 is null");
        return mergeArrayDelayError(new MaybeSource[]{r2, r3, r4, r5});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final <U> Maybe<T> timeout(Publisher<U> r2, MaybeSource<? extends T> r3) {
        ObjectHelper.requireNonNull(r2, "timeoutIndicator is null");
        ObjectHelper.requireNonNull(r3, "fallback is null");
        return RxJavaPlugins.onAssembly(new MaybeTimeoutPublisher(this, r2, r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concat(Publisher<? extends MaybeSource<? extends T>> r1) {
        return concat(r1, 2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> merge(MaybeSource<? extends T> r2, MaybeSource<? extends T> r3, MaybeSource<? extends T> r4, MaybeSource<? extends T> r5) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        ObjectHelper.requireNonNull(r5, "source4 is null");
        return mergeArray(new MaybeSource[]{r2, r3, r4, r5});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> concat(Publisher<? extends MaybeSource<? extends T>> r3, int r4) {
        ObjectHelper.requireNonNull(r3, "sources is null");
        ObjectHelper.verifyPositive(r4, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapPublisher(r3, MaybeToPublisher.instance(), r4, ErrorMode.IMMEDIATE));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T1, T2, T3, T4, T5, R> Maybe<R> zip(MaybeSource<? extends T1> r2, MaybeSource<? extends T2> r3, MaybeSource<? extends T3> r4, MaybeSource<? extends T4> r5, MaybeSource<? extends T5> r6, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> r7) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        ObjectHelper.requireNonNull(r5, "source4 is null");
        ObjectHelper.requireNonNull(r6, "source5 is null");
        return zipArray(Functions.toFunction(r7), new MaybeSource[]{r2, r3, r4, r5, r6});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T1, T2, T3, T4, T5, T6, R> Maybe<R> zip(MaybeSource<? extends T1> r2, MaybeSource<? extends T2> r3, MaybeSource<? extends T3> r4, MaybeSource<? extends T4> r5, MaybeSource<? extends T5> r6, MaybeSource<? extends T6> r7, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> r8) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        ObjectHelper.requireNonNull(r5, "source4 is null");
        ObjectHelper.requireNonNull(r6, "source5 is null");
        ObjectHelper.requireNonNull(r7, "source6 is null");
        return zipArray(Functions.toFunction(r8), new MaybeSource[]{r2, r3, r4, r5, r6, r7});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, R> Maybe<R> zip(MaybeSource<? extends T1> r2, MaybeSource<? extends T2> r3, MaybeSource<? extends T3> r4, MaybeSource<? extends T4> r5, MaybeSource<? extends T5> r6, MaybeSource<? extends T6> r7, MaybeSource<? extends T7> r8, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> r9) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        ObjectHelper.requireNonNull(r5, "source4 is null");
        ObjectHelper.requireNonNull(r6, "source5 is null");
        ObjectHelper.requireNonNull(r7, "source6 is null");
        ObjectHelper.requireNonNull(r8, "source7 is null");
        return zipArray(Functions.toFunction(r9), new MaybeSource[]{r2, r3, r4, r5, r6, r7, r8});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Maybe<R> zip(MaybeSource<? extends T1> r2, MaybeSource<? extends T2> r3, MaybeSource<? extends T3> r4, MaybeSource<? extends T4> r5, MaybeSource<? extends T5> r6, MaybeSource<? extends T6> r7, MaybeSource<? extends T7> r8, MaybeSource<? extends T8> r9, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> r10) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        ObjectHelper.requireNonNull(r5, "source4 is null");
        ObjectHelper.requireNonNull(r6, "source5 is null");
        ObjectHelper.requireNonNull(r7, "source6 is null");
        ObjectHelper.requireNonNull(r8, "source7 is null");
        ObjectHelper.requireNonNull(r9, "source8 is null");
        return zipArray(Functions.toFunction(r10), new MaybeSource[]{r2, r3, r4, r5, r6, r7, r8, r9});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    @NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Maybe<R> zip(MaybeSource<? extends T1> r2, MaybeSource<? extends T2> r3, MaybeSource<? extends T3> r4, MaybeSource<? extends T4> r5, MaybeSource<? extends T5> r6, MaybeSource<? extends T6> r7, MaybeSource<? extends T7> r8, MaybeSource<? extends T8> r9, MaybeSource<? extends T9> r10, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> r11) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        ObjectHelper.requireNonNull(r5, "source4 is null");
        ObjectHelper.requireNonNull(r6, "source5 is null");
        ObjectHelper.requireNonNull(r7, "source6 is null");
        ObjectHelper.requireNonNull(r8, "source7 is null");
        ObjectHelper.requireNonNull(r9, "source8 is null");
        ObjectHelper.requireNonNull(r10, "source9 is null");
        return zipArray(Functions.toFunction(r11), new MaybeSource[]{r2, r3, r4, r5, r6, r7, r8, r9, r10});
    }
}
