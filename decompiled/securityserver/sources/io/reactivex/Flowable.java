package io.reactivex;

import a.a;
import androidx.appcompat.widget.ActivityChooserView;
import com.bytedance.apm.constant.PerfConsts;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.flowables.GroupedFlowable;
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
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.operators.flowable.BlockingFlowableIterable;
import io.reactivex.internal.operators.flowable.BlockingFlowableLatest;
import io.reactivex.internal.operators.flowable.BlockingFlowableMostRecent;
import io.reactivex.internal.operators.flowable.BlockingFlowableNext;
import io.reactivex.internal.operators.flowable.FlowableAllSingle;
import io.reactivex.internal.operators.flowable.FlowableAmb;
import io.reactivex.internal.operators.flowable.FlowableAnySingle;
import io.reactivex.internal.operators.flowable.FlowableBlockingSubscribe;
import io.reactivex.internal.operators.flowable.FlowableBuffer;
import io.reactivex.internal.operators.flowable.FlowableBufferBoundary;
import io.reactivex.internal.operators.flowable.FlowableBufferBoundarySupplier;
import io.reactivex.internal.operators.flowable.FlowableBufferExactBoundary;
import io.reactivex.internal.operators.flowable.FlowableBufferTimed;
import io.reactivex.internal.operators.flowable.FlowableCache;
import io.reactivex.internal.operators.flowable.FlowableCollectSingle;
import io.reactivex.internal.operators.flowable.FlowableCombineLatest;
import io.reactivex.internal.operators.flowable.FlowableConcatArray;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.operators.flowable.FlowableConcatMapEager;
import io.reactivex.internal.operators.flowable.FlowableConcatMapEagerPublisher;
import io.reactivex.internal.operators.flowable.FlowableConcatWithCompletable;
import io.reactivex.internal.operators.flowable.FlowableConcatWithMaybe;
import io.reactivex.internal.operators.flowable.FlowableConcatWithSingle;
import io.reactivex.internal.operators.flowable.FlowableCountSingle;
import io.reactivex.internal.operators.flowable.FlowableCreate;
import io.reactivex.internal.operators.flowable.FlowableDebounce;
import io.reactivex.internal.operators.flowable.FlowableDebounceTimed;
import io.reactivex.internal.operators.flowable.FlowableDefer;
import io.reactivex.internal.operators.flowable.FlowableDelay;
import io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther;
import io.reactivex.internal.operators.flowable.FlowableDematerialize;
import io.reactivex.internal.operators.flowable.FlowableDetach;
import io.reactivex.internal.operators.flowable.FlowableDistinct;
import io.reactivex.internal.operators.flowable.FlowableDistinctUntilChanged;
import io.reactivex.internal.operators.flowable.FlowableDoAfterNext;
import io.reactivex.internal.operators.flowable.FlowableDoFinally;
import io.reactivex.internal.operators.flowable.FlowableDoOnEach;
import io.reactivex.internal.operators.flowable.FlowableDoOnLifecycle;
import io.reactivex.internal.operators.flowable.FlowableElementAtMaybe;
import io.reactivex.internal.operators.flowable.FlowableElementAtSingle;
import io.reactivex.internal.operators.flowable.FlowableEmpty;
import io.reactivex.internal.operators.flowable.FlowableError;
import io.reactivex.internal.operators.flowable.FlowableFilter;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.internal.operators.flowable.FlowableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe;
import io.reactivex.internal.operators.flowable.FlowableFlatMapSingle;
import io.reactivex.internal.operators.flowable.FlowableFlattenIterable;
import io.reactivex.internal.operators.flowable.FlowableFromArray;
import io.reactivex.internal.operators.flowable.FlowableFromCallable;
import io.reactivex.internal.operators.flowable.FlowableFromFuture;
import io.reactivex.internal.operators.flowable.FlowableFromIterable;
import io.reactivex.internal.operators.flowable.FlowableFromPublisher;
import io.reactivex.internal.operators.flowable.FlowableGenerate;
import io.reactivex.internal.operators.flowable.FlowableGroupBy;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin;
import io.reactivex.internal.operators.flowable.FlowableHide;
import io.reactivex.internal.operators.flowable.FlowableIgnoreElements;
import io.reactivex.internal.operators.flowable.FlowableIgnoreElementsCompletable;
import io.reactivex.internal.operators.flowable.FlowableInternalHelper;
import io.reactivex.internal.operators.flowable.FlowableInterval;
import io.reactivex.internal.operators.flowable.FlowableIntervalRange;
import io.reactivex.internal.operators.flowable.FlowableJoin;
import io.reactivex.internal.operators.flowable.FlowableJust;
import io.reactivex.internal.operators.flowable.FlowableLastMaybe;
import io.reactivex.internal.operators.flowable.FlowableLastSingle;
import io.reactivex.internal.operators.flowable.FlowableLift;
import io.reactivex.internal.operators.flowable.FlowableLimit;
import io.reactivex.internal.operators.flowable.FlowableMap;
import io.reactivex.internal.operators.flowable.FlowableMapNotification;
import io.reactivex.internal.operators.flowable.FlowableMaterialize;
import io.reactivex.internal.operators.flowable.FlowableMergeWithCompletable;
import io.reactivex.internal.operators.flowable.FlowableMergeWithMaybe;
import io.reactivex.internal.operators.flowable.FlowableMergeWithSingle;
import io.reactivex.internal.operators.flowable.FlowableNever;
import io.reactivex.internal.operators.flowable.FlowableObserveOn;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest;
import io.reactivex.internal.operators.flowable.FlowableOnErrorNext;
import io.reactivex.internal.operators.flowable.FlowableOnErrorReturn;
import io.reactivex.internal.operators.flowable.FlowablePublish;
import io.reactivex.internal.operators.flowable.FlowablePublishMulticast;
import io.reactivex.internal.operators.flowable.FlowableRange;
import io.reactivex.internal.operators.flowable.FlowableRangeLong;
import io.reactivex.internal.operators.flowable.FlowableReduceMaybe;
import io.reactivex.internal.operators.flowable.FlowableReduceSeedSingle;
import io.reactivex.internal.operators.flowable.FlowableReduceWithSingle;
import io.reactivex.internal.operators.flowable.FlowableRepeat;
import io.reactivex.internal.operators.flowable.FlowableRepeatUntil;
import io.reactivex.internal.operators.flowable.FlowableRepeatWhen;
import io.reactivex.internal.operators.flowable.FlowableReplay;
import io.reactivex.internal.operators.flowable.FlowableRetryBiPredicate;
import io.reactivex.internal.operators.flowable.FlowableRetryPredicate;
import io.reactivex.internal.operators.flowable.FlowableRetryWhen;
import io.reactivex.internal.operators.flowable.FlowableSamplePublisher;
import io.reactivex.internal.operators.flowable.FlowableSampleTimed;
import io.reactivex.internal.operators.flowable.FlowableScalarXMap;
import io.reactivex.internal.operators.flowable.FlowableScan;
import io.reactivex.internal.operators.flowable.FlowableScanSeed;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqualSingle;
import io.reactivex.internal.operators.flowable.FlowableSerialized;
import io.reactivex.internal.operators.flowable.FlowableSingleMaybe;
import io.reactivex.internal.operators.flowable.FlowableSingleSingle;
import io.reactivex.internal.operators.flowable.FlowableSkip;
import io.reactivex.internal.operators.flowable.FlowableSkipLast;
import io.reactivex.internal.operators.flowable.FlowableSkipLastTimed;
import io.reactivex.internal.operators.flowable.FlowableSkipUntil;
import io.reactivex.internal.operators.flowable.FlowableSkipWhile;
import io.reactivex.internal.operators.flowable.FlowableSubscribeOn;
import io.reactivex.internal.operators.flowable.FlowableSwitchIfEmpty;
import io.reactivex.internal.operators.flowable.FlowableSwitchMap;
import io.reactivex.internal.operators.flowable.FlowableTake;
import io.reactivex.internal.operators.flowable.FlowableTakeLast;
import io.reactivex.internal.operators.flowable.FlowableTakeLastOne;
import io.reactivex.internal.operators.flowable.FlowableTakeLastTimed;
import io.reactivex.internal.operators.flowable.FlowableTakeUntil;
import io.reactivex.internal.operators.flowable.FlowableTakeUntilPredicate;
import io.reactivex.internal.operators.flowable.FlowableTakeWhile;
import io.reactivex.internal.operators.flowable.FlowableThrottleFirstTimed;
import io.reactivex.internal.operators.flowable.FlowableThrottleLatest;
import io.reactivex.internal.operators.flowable.FlowableTimeInterval;
import io.reactivex.internal.operators.flowable.FlowableTimeout;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed;
import io.reactivex.internal.operators.flowable.FlowableTimer;
import io.reactivex.internal.operators.flowable.FlowableToListSingle;
import io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn;
import io.reactivex.internal.operators.flowable.FlowableUsing;
import io.reactivex.internal.operators.flowable.FlowableWindow;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundary;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundarySupplier;
import io.reactivex.internal.operators.flowable.FlowableWindowTimed;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFrom;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany;
import io.reactivex.internal.operators.flowable.FlowableZip;
import io.reactivex.internal.operators.flowable.FlowableZipIterable;
import io.reactivex.internal.operators.mixed.FlowableConcatMapCompletable;
import io.reactivex.internal.operators.mixed.FlowableConcatMapMaybe;
import io.reactivex.internal.operators.mixed.FlowableConcatMapSingle;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapCompletable;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapMaybe;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapSingle;
import io.reactivex.internal.operators.observable.ObservableFromPublisher;
import io.reactivex.internal.schedulers.ImmediateThinScheduler;
import io.reactivex.internal.subscribers.BlockingFirstSubscriber;
import io.reactivex.internal.subscribers.BlockingLastSubscriber;
import io.reactivex.internal.subscribers.ForEachWhileSubscriber;
import io.reactivex.internal.subscribers.FutureSubscriber;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.subscribers.StrictSubscriber;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.HashMapSupplier;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.Timed;
import io.reactivex.subscribers.SafeSubscriber;
import io.reactivex.subscribers.TestSubscriber;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Flowable<T> implements Publisher<T> {
    static final int BUFFER_SIZE = 0;

    static {
        BUFFER_SIZE = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());
    }

    public Flowable() {
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> amb(Iterable<? extends Publisher<? extends T>> r2) {
        ObjectHelper.requireNonNull(r2, "sources is null");
        return RxJavaPlugins.onAssembly(new FlowableAmb(null, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> ambArray(Publisher<? extends T>... r2) {
        ObjectHelper.requireNonNull(r2, "sources is null");
        int r0 = r2.length;
        if (r0 != 0) goto L7;
        return empty();
    L7:
        if (r0 != 1) goto L11;
        return fromPublisher(r2[0]);
    L11:
        return RxJavaPlugins.onAssembly(new FlowableAmb(r2, null));
    }

    public static int bufferSize() {
        return BUFFER_SIZE;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatest(Publisher<? extends T>[] r1, Function<? super Object[], ? extends R> r2) {
        return combineLatest(r1, r2, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatestDelayError(Publisher<? extends T>[] r1, Function<? super Object[], ? extends R> r2) {
        return combineLatestDelayError(r1, r2, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> concat(Iterable<? extends Publisher<? extends T>> r3) {
        ObjectHelper.requireNonNull(r3, "sources is null");
        return fromIterable(r3).concatMapDelayError(Functions.identity(), 2, false);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatArray(Publisher<? extends T>... r3) {
        if (r3.length != 0) goto L7;
        return empty();
    L7:
        if (r3.length != 1) goto L11;
        return fromPublisher(r3[0]);
    L11:
        return RxJavaPlugins.onAssembly(new FlowableConcatArray(r3, false));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatArrayDelayError(Publisher<? extends T>... r2) {
        if (r2.length != 0) goto L7;
        return empty();
    L7:
        if (r2.length != 1) goto L11;
        return fromPublisher(r2[0]);
    L11:
        return RxJavaPlugins.onAssembly(new FlowableConcatArray(r2, true));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatArrayEager(Publisher<? extends T>... r2) {
        return concatArrayEager(bufferSize(), bufferSize(), r2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatArrayEagerDelayError(Publisher<? extends T>... r2) {
        return concatArrayEagerDelayError(bufferSize(), bufferSize(), r2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> concatDelayError(Iterable<? extends Publisher<? extends T>> r1) {
        ObjectHelper.requireNonNull(r1, "sources is null");
        return fromIterable(r1).concatMapDelayError(Functions.identity());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatEager(Publisher<? extends Publisher<? extends T>> r2) {
        return concatEager(r2, bufferSize(), bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> create(FlowableOnSubscribe<T> r1, BackpressureStrategy r2) {
        ObjectHelper.requireNonNull(r1, "source is null");
        ObjectHelper.requireNonNull(r2, "mode is null");
        return RxJavaPlugins.onAssembly(new FlowableCreate(r1, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> defer(Callable<? extends Publisher<? extends T>> r1) {
        ObjectHelper.requireNonNull(r1, "supplier is null");
        return RxJavaPlugins.onAssembly(new FlowableDefer(r1));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    private Flowable<T> doOnEach(Consumer<? super T> r8, Consumer<? super Throwable> r9, Action r10, Action r11) {
        ObjectHelper.requireNonNull(r8, "onNext is null");
        ObjectHelper.requireNonNull(r9, "onError is null");
        ObjectHelper.requireNonNull(r10, "onComplete is null");
        ObjectHelper.requireNonNull(r11, "onAfterTerminate is null");
        return RxJavaPlugins.onAssembly(new FlowableDoOnEach(this, r8, r9, r10, r11));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static <T> Flowable<T> empty() {
        return RxJavaPlugins.onAssembly(FlowableEmpty.INSTANCE);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> error(Callable<? extends Throwable> r1) {
        ObjectHelper.requireNonNull(r1, "supplier is null");
        return RxJavaPlugins.onAssembly(new FlowableError(r1));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> fromArray(T... r2) {
        ObjectHelper.requireNonNull(r2, "items is null");
        if (r2.length != 0) goto L7;
        return empty();
    L7:
        if (r2.length != 1) goto L11;
        return just(r2[0]);
    L11:
        return RxJavaPlugins.onAssembly(new FlowableFromArray(r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> fromCallable(Callable<? extends T> r1) {
        ObjectHelper.requireNonNull(r1, "supplier is null");
        return RxJavaPlugins.onAssembly(new FlowableFromCallable(r1));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> fromFuture(Future<? extends T> r4) {
        ObjectHelper.requireNonNull(r4, "future is null");
        return RxJavaPlugins.onAssembly(new FlowableFromFuture(r4, 0, null));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> fromIterable(Iterable<? extends T> r1) {
        ObjectHelper.requireNonNull(r1, "source is null");
        return RxJavaPlugins.onAssembly(new FlowableFromIterable(r1));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> fromPublisher(Publisher<? extends T> r1) {
        if ((r1 instanceof Flowable) == true) goto L5;
        ObjectHelper.requireNonNull(r1, "source is null");
        return RxJavaPlugins.onAssembly(new FlowableFromPublisher(r1));
    L5:
        return RxJavaPlugins.onAssembly((Flowable) r1);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> generate(Consumer<Emitter<T>> r2) {
        ObjectHelper.requireNonNull(r2, "generator is null");
        return generate(Functions.nullSupplier(), FlowableInternalHelper.simpleGenerator(r2), Functions.emptyConsumer());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public static Flowable<Long> interval(long r6, long r8, TimeUnit r10) {
        return interval(r6, r8, r10, Schedulers.computation());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public static Flowable<Long> intervalRange(long r10, long r12, long r14, long r16, TimeUnit r18) {
        return intervalRange(r10, r12, r14, r16, r18, Schedulers.computation());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> just(T r1) {
        ObjectHelper.requireNonNull(r1, "item is null");
        return RxJavaPlugins.onAssembly(new FlowableJust(r1));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> merge(Iterable<? extends Publisher<? extends T>> r2, int r3, int r4) {
        return fromIterable(r2).flatMap(Functions.identity(), false, r3, r4);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeArray(int r2, int r3, Publisher<? extends T>... r4) {
        return fromArray(r4).flatMap(Functions.identity(), false, r2, r3);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeArrayDelayError(int r2, int r3, Publisher<? extends T>... r4) {
        return fromArray(r4).flatMap(Functions.identity(), true, r2, r3);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(Iterable<? extends Publisher<? extends T>> r2) {
        return fromIterable(r2).flatMap(Functions.identity(), true);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static <T> Flowable<T> never() {
        return RxJavaPlugins.onAssembly(FlowableNever.INSTANCE);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable<Integer> range(int r4, int r5) {
        if (r5 < 0) goto L17;
        if (r5 != 0) goto L7;
        return empty();
    L7:
        if (r5 != 1) goto L11;
        return just(Integer.valueOf(r4));
    L11:
        if ((((long) r4) + ((long) (r5 - 1))) > 2147483647L) goto L15;
        return RxJavaPlugins.onAssembly(new FlowableRange(r4, r5));
    L15:
        throw new IllegalArgumentException("Integer overflow");
    L17:
        throw new IllegalArgumentException(a.e(r5, "count >= 0 required but it was "));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable<Long> rangeLong(long r5, long r7) {
        if (r7 < 0) goto L21;
        if (r7 != 0) goto L8;
        return empty();
    L8:
        if (r7 == 1) goto L10;
        long r2 = (r7 - 1) + r5;
        if (r5 <= 0) goto L19;
        if (r2 >= 0) goto L19;
        throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
    L19:
        return RxJavaPlugins.onAssembly(new FlowableRangeLong(r5, r7));
    L10:
        return just(Long.valueOf(r5));
    L21:
        throw new IllegalArgumentException(a.h("count >= 0 required but it was ", r7));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Single<Boolean> sequenceEqual(Publisher<? extends T> r2, Publisher<? extends T> r3) {
        return sequenceEqual(r2, r3, ObjectHelper.equalsPredicate(), bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> switchOnNext(Publisher<? extends Publisher<? extends T>> r1, int r2) {
        return fromPublisher(r1).switchMap(Functions.identity(), r2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> switchOnNextDelayError(Publisher<? extends Publisher<? extends T>> r1) {
        return switchOnNextDelayError(r1, bufferSize());
    }

    private Flowable<T> timeout0(long r9, TimeUnit r11, Publisher<? extends T> r12, Scheduler r13) {
        ObjectHelper.requireNonNull(r11, "timeUnit is null");
        ObjectHelper.requireNonNull(r13, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableTimeoutTimed(this, r9, r11, r13, r12));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public static Flowable<Long> timer(long r1, TimeUnit r3) {
        return timer(r1, r3, Schedulers.computation());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.NONE)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> unsafeCreate(Publisher<T> r1) {
        ObjectHelper.requireNonNull(r1, "onSubscribe is null");
        if ((r1 instanceof Flowable) == true) goto L7;
        return RxJavaPlugins.onAssembly(new FlowableFromPublisher(r1));
    L7:
        throw new IllegalArgumentException("unsafeCreate(Flowable) should be upgraded");
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static <T, D> Flowable<T> using(Callable<? extends D> r1, Function<? super D, ? extends Publisher<? extends T>> r2, Consumer<? super D> r3) {
        return using(r1, r2, r3, true);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T, R> Flowable<R> zip(Iterable<? extends Publisher<? extends T>> r7, Function<? super Object[], ? extends R> r8) {
        ObjectHelper.requireNonNull(r8, "zipper is null");
        ObjectHelper.requireNonNull(r7, "sources is null");
        return RxJavaPlugins.onAssembly(new FlowableZip(null, r7, r8, bufferSize(), false));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T, R> Flowable<R> zipArray(Function<? super Object[], ? extends R> r7, boolean r8, int r9, Publisher<? extends T>... r10) {
        if (r10.length == 0) goto L5;
        ObjectHelper.requireNonNull(r7, "zipper is null");
        ObjectHelper.verifyPositive(r9, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableZip(r10, null, r7, r9, r8));
    L5:
        return empty();
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T, R> Flowable<R> zipIterable(Iterable<? extends Publisher<? extends T>> r7, Function<? super Object[], ? extends R> r8, boolean r9, int r10) {
        ObjectHelper.requireNonNull(r8, "zipper is null");
        ObjectHelper.requireNonNull(r7, "sources is null");
        ObjectHelper.verifyPositive(r10, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableZip(null, r7, r8, r10, r9));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final Single<Boolean> all(Predicate<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "predicate is null");
        return RxJavaPlugins.onAssembly(new FlowableAllSingle(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> ambWith(Publisher<? extends T> r3) {
        ObjectHelper.requireNonNull(r3, "other is null");
        return ambArray(new Publisher[]{this, r3});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final Single<Boolean> any(Predicate<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "predicate is null");
        return RxJavaPlugins.onAssembly(new FlowableAnySingle(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final <R> R as(@NonNull FlowableConverter<T, ? extends R> r2) {
        return (R) ((FlowableConverter) ObjectHelper.requireNonNull(r2, "converter is null")).apply(this);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final T blockingFirst() {
        BlockingFirstSubscriber r0 = new BlockingFirstSubscriber();
        subscribe(r0);
        T r1 = r0.blockingGet();
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new NoSuchElementException();
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public final void blockingForEach(Consumer<? super T> r2) {
        Iterator<T> r1 = blockingIterable().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        r2.accept(r1.next());     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        ((Disposable) r1).dispose();
        throw ExceptionHelper.wrapOrThrow(th);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Iterable<T> blockingIterable() {
        return blockingIterable(bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final T blockingLast() {
        BlockingLastSubscriber r0 = new BlockingLastSubscriber();
        subscribe(r0);
        T r1 = r0.blockingGet();
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new NoSuchElementException();
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Iterable<T> blockingLatest() {
        return new BlockingFlowableLatest(this);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Iterable<T> blockingMostRecent(T r2) {
        return new BlockingFlowableMostRecent(this, r2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Iterable<T> blockingNext() {
        return new BlockingFlowableNext(this);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final T blockingSingle() {
        return singleOrError().blockingGet();
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public final void blockingSubscribe() {
        FlowableBlockingSubscribe.subscribe(this);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<List<T>> buffer(int r1) {
        return buffer(r1, r1);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> cache() {
        return cacheWithInitialCapacity(16);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> cacheWithInitialCapacity(int r2) {
        ObjectHelper.verifyPositive(r2, "initialCapacity");
        return RxJavaPlugins.onAssembly(new FlowableCache(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public final <U> Flowable<U> cast(Class<U> r2) {
        ObjectHelper.requireNonNull(r2, "clazz is null");
        return (Flowable<U>) map(Functions.castFunction(r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final <U> Single<U> collect(Callable<? extends U> r2, BiConsumer<? super U, ? super T> r3) {
        ObjectHelper.requireNonNull(r2, "initialItemSupplier is null");
        ObjectHelper.requireNonNull(r3, "collector is null");
        return RxJavaPlugins.onAssembly(new FlowableCollectSingle(this, r2, r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final <U> Single<U> collectInto(U r2, BiConsumer<? super U, ? super T> r3) {
        ObjectHelper.requireNonNull(r2, "initialItem is null");
        return collect(Functions.justCallable(r2), r3);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final <R> Flowable<R> compose(FlowableTransformer<? super T, ? extends R> r2) {
        return fromPublisher(((FlowableTransformer) ObjectHelper.requireNonNull(r2, "composer is null")).apply(this));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> concatMap(Function<? super T, ? extends Publisher<? extends R>> r2) {
        return concatMap(r2, 2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> r2) {
        return concatMapCompletable(r2, 2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> r3) {
        return concatMapCompletableDelayError(r3, true, 2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> concatMapDelayError(Function<? super T, ? extends Publisher<? extends R>> r3) {
        return concatMapDelayError(r3, 2, true);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> concatMapEager(Function<? super T, ? extends Publisher<? extends R>> r3) {
        return concatMapEager(r3, bufferSize(), bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> concatMapEagerDelayError(Function<? super T, ? extends Publisher<? extends R>> r3, boolean r4) {
        return concatMapEagerDelayError(r3, bufferSize(), bufferSize(), r4);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U> Flowable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> r2) {
        return concatMapIterable(r2, 2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> r2) {
        return concatMapMaybe(r2, 2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> r3) {
        return concatMapMaybeDelayError(r3, true, 2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> r2) {
        return concatMapSingle(r2, 2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> r3) {
        return concatMapSingleDelayError(r3, true, 2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> concatWith(Publisher<? extends T> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return concat(this, r2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final Single<Boolean> contains(Object r2) {
        ObjectHelper.requireNonNull(r2, "item is null");
        return any(Functions.equalsWith(r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Single<Long> count() {
        return RxJavaPlugins.onAssembly(new FlowableCountSingle(this));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    @NonNull
    public final <U> Flowable<T> debounce(Function<? super T, ? extends Publisher<U>> r2) {
        ObjectHelper.requireNonNull(r2, "debounceIndicator is null");
        return RxJavaPlugins.onAssembly(new FlowableDebounce(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> defaultIfEmpty(T r2) {
        ObjectHelper.requireNonNull(r2, "defaultItem is null");
        return switchIfEmpty(just(r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <U> Flowable<T> delay(Function<? super T, ? extends Publisher<U>> r2) {
        ObjectHelper.requireNonNull(r2, "itemDelayIndicator is null");
        return (Flowable<T>) flatMap(FlowableInternalHelper.itemDelay(r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <U> Flowable<T> delaySubscription(Publisher<U> r2) {
        ObjectHelper.requireNonNull(r2, "subscriptionIndicator is null");
        return RxJavaPlugins.onAssembly(new FlowableDelaySubscriptionOther(this, r2));
    }

    @Deprecated
    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final <T2> Flowable<T2> dematerialize() {
        return RxJavaPlugins.onAssembly(new FlowableDematerialize(this, Functions.identity()));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> distinct() {
        return distinct(Functions.identity(), Functions.createHashSet());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> distinctUntilChanged() {
        return distinctUntilChanged(Functions.identity());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> doAfterNext(Consumer<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "onAfterNext is null");
        return RxJavaPlugins.onAssembly(new FlowableDoAfterNext(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> doAfterTerminate(Action r4) {
        return doOnEach(Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, r4);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> doFinally(Action r2) {
        ObjectHelper.requireNonNull(r2, "onFinally is null");
        return RxJavaPlugins.onAssembly(new FlowableDoFinally(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> doOnCancel(Action r3) {
        return doOnLifecycle(Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, r3);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> doOnComplete(Action r4) {
        return doOnEach(Functions.emptyConsumer(), Functions.emptyConsumer(), r4, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> doOnError(Consumer<? super Throwable> r3) {
        Consumer<? super T> r0 = Functions.emptyConsumer();
        Action r1 = Functions.EMPTY_ACTION;
        return doOnEach(r0, r3, r1, r1);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> doOnLifecycle(Consumer<? super Subscription> r2, LongConsumer r3, Action r4) {
        ObjectHelper.requireNonNull(r2, "onSubscribe is null");
        ObjectHelper.requireNonNull(r3, "onRequest is null");
        ObjectHelper.requireNonNull(r4, "onCancel is null");
        return RxJavaPlugins.onAssembly(new FlowableDoOnLifecycle(this, r2, r3, r4));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> doOnNext(Consumer<? super T> r3) {
        Consumer<? super Throwable> r0 = Functions.emptyConsumer();
        Action r1 = Functions.EMPTY_ACTION;
        return doOnEach(r3, r0, r1, r1);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> doOnRequest(LongConsumer r3) {
        return doOnLifecycle(Functions.emptyConsumer(), r3, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> doOnSubscribe(Consumer<? super Subscription> r3) {
        return doOnLifecycle(r3, Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> doOnTerminate(Action r4) {
        return doOnEach(Functions.emptyConsumer(), Functions.actionConsumer(r4), r4, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Maybe<T> elementAt(long r3) {
        if (r3 < 0) goto L7;
        return RxJavaPlugins.onAssembly(new FlowableElementAtMaybe(this, r3));
    L7:
        throw new IndexOutOfBoundsException(a.h("index >= 0 required but it was ", r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Single<T> elementAtOrError(long r3) {
        if (r3 < 0) goto L7;
        return RxJavaPlugins.onAssembly(new FlowableElementAtSingle(this, r3, null));
    L7:
        throw new IndexOutOfBoundsException(a.h("index >= 0 required but it was ", r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> filter(Predicate<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "predicate is null");
        return RxJavaPlugins.onAssembly(new FlowableFilter(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final Single<T> first(T r3) {
        return elementAt(0, r3);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final Maybe<T> firstElement() {
        return elementAt(0);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final Single<T> firstOrError() {
        return elementAtOrError(0);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> r4) {
        return flatMap(r4, false, bufferSize(), bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> r3) {
        return flatMapCompletable(r3, false, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U> Flowable<U> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> r2) {
        return flatMapIterable(r2, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <R> Flowable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> r3) {
        return flatMapMaybe(r3, false, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <R> Flowable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> r3) {
        return flatMapSingle(r3, false, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.NONE)
    @CheckReturnValue
    public final Disposable forEach(Consumer<? super T> r1) {
        return subscribe(r1);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.NONE)
    @CheckReturnValue
    public final Disposable forEachWhile(Predicate<? super T> r3) {
        return forEachWhile(r3, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <K> Flowable<GroupedFlowable<K, T>> groupBy(Function<? super T, ? extends K> r4) {
        return (Flowable<GroupedFlowable<K, T>>) groupBy(r4, Functions.identity(), false, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    @NonNull
    public final <TRight, TLeftEnd, TRightEnd, R> Flowable<R> groupJoin(Publisher<? extends TRight> r8, Function<? super T, ? extends Publisher<TLeftEnd>> r9, Function<? super TRight, ? extends Publisher<TRightEnd>> r10, BiFunction<? super T, ? super Flowable<TRight>, ? extends R> r11) {
        ObjectHelper.requireNonNull(r8, "other is null");
        ObjectHelper.requireNonNull(r9, "leftEnd is null");
        ObjectHelper.requireNonNull(r10, "rightEnd is null");
        ObjectHelper.requireNonNull(r11, "resultSelector is null");
        return RxJavaPlugins.onAssembly(new FlowableGroupJoin(this, r8, r9, r10, r11));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> hide() {
        return RxJavaPlugins.onAssembly(new FlowableHide(this));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Completable ignoreElements() {
        return RxJavaPlugins.onAssembly(new FlowableIgnoreElementsCompletable(this));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Single<Boolean> isEmpty() {
        return all(Functions.alwaysFalse());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    @NonNull
    public final <TRight, TLeftEnd, TRightEnd, R> Flowable<R> join(Publisher<? extends TRight> r8, Function<? super T, ? extends Publisher<TLeftEnd>> r9, Function<? super TRight, ? extends Publisher<TRightEnd>> r10, BiFunction<? super T, ? super TRight, ? extends R> r11) {
        ObjectHelper.requireNonNull(r8, "other is null");
        ObjectHelper.requireNonNull(r9, "leftEnd is null");
        ObjectHelper.requireNonNull(r10, "rightEnd is null");
        ObjectHelper.requireNonNull(r11, "resultSelector is null");
        return RxJavaPlugins.onAssembly(new FlowableJoin(this, r8, r9, r10, r11));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final Single<T> last(T r2) {
        ObjectHelper.requireNonNull(r2, "defaultItem");
        return RxJavaPlugins.onAssembly(new FlowableLastSingle(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Maybe<T> lastElement() {
        return RxJavaPlugins.onAssembly(new FlowableLastMaybe(this));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Single<T> lastOrError() {
        return RxJavaPlugins.onAssembly(new FlowableLastSingle(this, null));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> lift(FlowableOperator<? extends R, ? super T> r2) {
        ObjectHelper.requireNonNull(r2, "lifter is null");
        return RxJavaPlugins.onAssembly(new FlowableLift(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final Flowable<T> limit(long r3) {
        if (r3 < 0) goto L7;
        return RxJavaPlugins.onAssembly(new FlowableLimit(this, r3));
    L7:
        throw new IllegalArgumentException(a.h("count >= 0 required but it was ", r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> map(Function<? super T, ? extends R> r2) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        return RxJavaPlugins.onAssembly(new FlowableMap(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<Notification<T>> materialize() {
        return RxJavaPlugins.onAssembly(new FlowableMaterialize(this));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> mergeWith(Publisher<? extends T> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return merge(this, r2);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> observeOn(Scheduler r3) {
        return observeOn(r3, false, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public final <U> Flowable<U> ofType(Class<U> r2) {
        ObjectHelper.requireNonNull(r2, "clazz is null");
        return filter(Functions.isInstanceOf(r2)).cast(r2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Flowable<T> onBackpressureBuffer() {
        return onBackpressureBuffer(bufferSize(), false, true);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Flowable<T> onBackpressureDrop() {
        return RxJavaPlugins.onAssembly(new FlowableOnBackpressureDrop(this));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Flowable<T> onBackpressureLatest() {
        return RxJavaPlugins.onAssembly(new FlowableOnBackpressureLatest(this));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> onErrorResumeNext(Function<? super Throwable, ? extends Publisher<? extends T>> r3) {
        ObjectHelper.requireNonNull(r3, "resumeFunction is null");
        return RxJavaPlugins.onAssembly(new FlowableOnErrorNext(this, r3, false));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> onErrorReturn(Function<? super Throwable, ? extends T> r2) {
        ObjectHelper.requireNonNull(r2, "valueSupplier is null");
        return RxJavaPlugins.onAssembly(new FlowableOnErrorReturn(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> onErrorReturnItem(T r2) {
        ObjectHelper.requireNonNull(r2, "item is null");
        return onErrorReturn(Functions.justFunction(r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> onExceptionResumeNext(Publisher<? extends T> r3) {
        ObjectHelper.requireNonNull(r3, "next is null");
        return RxJavaPlugins.onAssembly(new FlowableOnErrorNext(this, Functions.justFunction(r3), true));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> onTerminateDetach() {
        return RxJavaPlugins.onAssembly(new FlowableDetach(this));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final ParallelFlowable<T> parallel() {
        return ParallelFlowable.from(this);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final ConnectableFlowable<T> publish() {
        return publish(bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> rebatchRequests(int r3) {
        return observeOn(ImmediateThinScheduler.INSTANCE, true, r3);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final Maybe<T> reduce(BiFunction<T, T, T> r2) {
        ObjectHelper.requireNonNull(r2, "reducer is null");
        return RxJavaPlugins.onAssembly(new FlowableReduceMaybe(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final <R> Single<R> reduceWith(Callable<R> r2, BiFunction<R, ? super T, R> r3) {
        ObjectHelper.requireNonNull(r2, "seedSupplier is null");
        ObjectHelper.requireNonNull(r3, "reducer is null");
        return RxJavaPlugins.onAssembly(new FlowableReduceWithSingle(this, r2, r3));
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
    @NonNull
    public final Flowable<T> repeatUntil(BooleanSupplier r2) {
        ObjectHelper.requireNonNull(r2, "stop is null");
        return RxJavaPlugins.onAssembly(new FlowableRepeatUntil(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> r2) {
        ObjectHelper.requireNonNull(r2, "handler is null");
        return RxJavaPlugins.onAssembly(new FlowableRepeatWhen(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final ConnectableFlowable<T> replay() {
        return FlowableReplay.createFrom(this);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> retry() {
        return retry(Long.MAX_VALUE, Functions.alwaysTrue());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> retryUntil(BooleanSupplier r3) {
        ObjectHelper.requireNonNull(r3, "stop is null");
        return retry(Long.MAX_VALUE, Functions.predicateReverseFor(r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> r2) {
        ObjectHelper.requireNonNull(r2, "handler is null");
        return RxJavaPlugins.onAssembly(new FlowableRetryWhen(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    public final void safeSubscribe(Subscriber<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "s is null");
        if ((r2 instanceof SafeSubscriber) == false) goto L5;
        subscribe((SafeSubscriber) r2);
        return;
    L5:
        subscribe(new SafeSubscriber(r2));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> sample(long r2, TimeUnit r4) {
        return sample(r2, r4, Schedulers.computation());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> scan(BiFunction<T, T, T> r2) {
        ObjectHelper.requireNonNull(r2, "accumulator is null");
        return RxJavaPlugins.onAssembly(new FlowableScan(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> scanWith(Callable<R> r2, BiFunction<R, ? super T, R> r3) {
        ObjectHelper.requireNonNull(r2, "seedSupplier is null");
        ObjectHelper.requireNonNull(r3, "accumulator is null");
        return RxJavaPlugins.onAssembly(new FlowableScanSeed(this, r2, r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> serialize() {
        return RxJavaPlugins.onAssembly(new FlowableSerialized(this));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> share() {
        return publish().refCount();
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final Single<T> single(T r2) {
        ObjectHelper.requireNonNull(r2, "defaultItem is null");
        return RxJavaPlugins.onAssembly(new FlowableSingleSingle(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Maybe<T> singleElement() {
        return RxJavaPlugins.onAssembly(new FlowableSingleMaybe(this));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Single<T> singleOrError() {
        return RxJavaPlugins.onAssembly(new FlowableSingleSingle(this, null));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> skip(long r3) {
        if (r3 > 0) goto L7;
        return RxJavaPlugins.onAssembly(this);
    L7:
        return RxJavaPlugins.onAssembly(new FlowableSkip(this, r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> skipLast(int r2) {
        if (r2 < 0) goto L9;
        if (r2 != 0) goto L7;
        return RxJavaPlugins.onAssembly(this);
    L7:
        return RxJavaPlugins.onAssembly(new FlowableSkipLast(this, r2));
    L9:
        throw new IndexOutOfBoundsException(a.e(r2, "count >= 0 required but it was "));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <U> Flowable<T> skipUntil(Publisher<U> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableSkipUntil(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> skipWhile(Predicate<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "predicate is null");
        return RxJavaPlugins.onAssembly(new FlowableSkipWhile(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> sorted() {
        return toList().toFlowable().map(Functions.listSorter(Functions.naturalComparator())).flatMapIterable(Functions.identity());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> startWith(Iterable<? extends T> r3) {
        return concatArray(new Publisher[]{fromIterable(r3), this});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> startWithArray(T... r3) {
        Flowable r4 = fromArray(r3);
        if (r4 != empty()) goto L7;
        return RxJavaPlugins.onAssembly(this);
    L7:
        return concatArray(new Publisher[]{r4, this});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public final Disposable subscribe() {
        return subscribe(Functions.emptyConsumer(), Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, FlowableInternalHelper.RequestMax.INSTANCE);
    }

    public abstract void subscribeActual(Subscriber<? super T> r1);

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> subscribeOn(@NonNull Scheduler r2) {
        ObjectHelper.requireNonNull(r2, "scheduler is null");
        return subscribeOn(r2, !(this instanceof FlowableCreate));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final <E extends Subscriber<? super T>> E subscribeWith(E r1) {
        subscribe(r1);
        return r1;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> switchIfEmpty(Publisher<? extends T> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableSwitchIfEmpty(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> switchMap(Function<? super T, ? extends Publisher<? extends R>> r2) {
        return switchMap(r2, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <R> Flowable<R> switchMap0(Function<? super T, ? extends Publisher<? extends R>> r2, int r3, boolean r4) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        ObjectHelper.verifyPositive(r3, "bufferSize");
        if ((this instanceof ScalarCallable) == false) goto L11;
        Object r1 = ((ScalarCallable) this).call();
        if (r1 != null) goto L9;
        return empty();
    L9:
        return FlowableScalarXMap.scalarXMap(r1, r2);
    L11:
        return RxJavaPlugins.onAssembly(new FlowableSwitchMap(this, r2, r3, r4));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final Completable switchMapCompletable(@NonNull Function<? super T, ? extends CompletableSource> r3) {
        ObjectHelper.requireNonNull(r3, "mapper is null");
        return RxJavaPlugins.onAssembly(new FlowableSwitchMapCompletable(this, r3, false));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final Completable switchMapCompletableDelayError(@NonNull Function<? super T, ? extends CompletableSource> r3) {
        ObjectHelper.requireNonNull(r3, "mapper is null");
        return RxJavaPlugins.onAssembly(new FlowableSwitchMapCompletable(this, r3, true));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final <R> Flowable<R> switchMapDelayError(Function<? super T, ? extends Publisher<? extends R>> r2) {
        return switchMapDelayError(r2, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> switchMapMaybe(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> r3) {
        ObjectHelper.requireNonNull(r3, "mapper is null");
        return RxJavaPlugins.onAssembly(new FlowableSwitchMapMaybe(this, r3, false));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> switchMapMaybeDelayError(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> r3) {
        ObjectHelper.requireNonNull(r3, "mapper is null");
        return RxJavaPlugins.onAssembly(new FlowableSwitchMapMaybe(this, r3, true));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> switchMapSingle(@NonNull Function<? super T, ? extends SingleSource<? extends R>> r3) {
        ObjectHelper.requireNonNull(r3, "mapper is null");
        return RxJavaPlugins.onAssembly(new FlowableSwitchMapSingle(this, r3, false));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> switchMapSingleDelayError(@NonNull Function<? super T, ? extends SingleSource<? extends R>> r3) {
        ObjectHelper.requireNonNull(r3, "mapper is null");
        return RxJavaPlugins.onAssembly(new FlowableSwitchMapSingle(this, r3, true));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final Flowable<T> take(long r3) {
        if (r3 < 0) goto L7;
        return RxJavaPlugins.onAssembly(new FlowableTake(this, r3));
    L7:
        throw new IllegalArgumentException(a.h("count >= 0 required but it was ", r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> takeLast(int r2) {
        if (r2 < 0) goto L13;
        if (r2 != 0) goto L7;
        return RxJavaPlugins.onAssembly(new FlowableIgnoreElements(this));
    L7:
        if (r2 != 1) goto L11;
        return RxJavaPlugins.onAssembly(new FlowableTakeLastOne(this));
    L11:
        return RxJavaPlugins.onAssembly(new FlowableTakeLast(this, r2));
    L13:
        throw new IndexOutOfBoundsException(a.e(r2, "count >= 0 required but it was "));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> takeUntil(Predicate<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "stopPredicate is null");
        return RxJavaPlugins.onAssembly(new FlowableTakeUntilPredicate(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> takeWhile(Predicate<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "predicate is null");
        return RxJavaPlugins.onAssembly(new FlowableTakeWhile(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final TestSubscriber<T> test() {
        TestSubscriber<T> r0 = new TestSubscriber();
        subscribe(r0);
        return r0;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> throttleFirst(long r2, TimeUnit r4) {
        return throttleFirst(r2, r4, Schedulers.computation());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> throttleLast(long r1, TimeUnit r3) {
        return sample(r1, r3);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> throttleLatest(long r7, TimeUnit r9) {
        return throttleLatest(r7, r9, Schedulers.computation(), false);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> throttleWithTimeout(long r1, TimeUnit r3) {
        return debounce(r1, r3);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<Timed<T>> timeInterval() {
        return timeInterval(TimeUnit.MILLISECONDS, Schedulers.computation());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final <V> Flowable<T> timeout(Function<? super T, ? extends Publisher<V>> r2) {
        return timeout0(null, r2, null);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<Timed<T>> timestamp() {
        return timestamp(TimeUnit.MILLISECONDS, Schedulers.computation());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final <R> R to(Function<? super Flowable<T>, R> r2) {
        return (R) ((Function) ObjectHelper.requireNonNull(r2, "converter is null")).apply(this);
    L4:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        throw ExceptionHelper.wrapOrThrow(th);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Future<T> toFuture() {
        return (Future) subscribeWith(new FutureSubscriber());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Single<List<T>> toList() {
        return RxJavaPlugins.onAssembly(new FlowableToListSingle(this));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final <K> Single<Map<K, T>> toMap(Function<? super T, ? extends K> r2) {
        ObjectHelper.requireNonNull(r2, "keySelector is null");
        return (Single<Map<K, T>>) collect(HashMapSupplier.asCallable(), Functions.toMapKeySelector(r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <K> Single<Map<K, Collection<T>>> toMultimap(Function<? super T, ? extends K> r4) {
        return (Single<Map<K, Collection<T>>>) toMultimap(r4, Functions.identity(), HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Observable<T> toObservable() {
        return RxJavaPlugins.onAssembly(new ObservableFromPublisher(this));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Single<List<T>> toSortedList() {
        return toSortedList(Functions.naturalComparator());
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> unsubscribeOn(Scheduler r2) {
        ObjectHelper.requireNonNull(r2, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableUnsubscribeOn(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long r7) {
        return window(r7, r7, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public final <U, R> Flowable<R> withLatestFrom(Publisher<? extends U> r2, BiFunction<? super T, ? super U, ? extends R> r3) {
        ObjectHelper.requireNonNull(r2, "other is null");
        ObjectHelper.requireNonNull(r3, "combiner is null");
        return RxJavaPlugins.onAssembly(new FlowableWithLatestFrom(this, r3, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <U, R> Flowable<R> zipWith(Iterable<U> r2, BiFunction<? super T, ? super U, ? extends R> r3) {
        ObjectHelper.requireNonNull(r2, "other is null");
        ObjectHelper.requireNonNull(r3, "zipper is null");
        return RxJavaPlugins.onAssembly(new FlowableZipIterable(this, r2, r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatest(Function<? super Object[], ? extends R> r1, Publisher<? extends T>... r2) {
        return combineLatest(r2, r1, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatestDelayError(Function<? super Object[], ? extends R> r1, Publisher<? extends T>... r2) {
        return combineLatestDelayError(r2, r1, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> concatArrayEager(int r7, int r8, Publisher<? extends T>... r9) {
        ObjectHelper.requireNonNull(r9, "sources is null");
        ObjectHelper.verifyPositive(r7, "maxConcurrency");
        ObjectHelper.verifyPositive(r8, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapEager(new FlowableFromArray(r9), Functions.identity(), r7, r8, ErrorMode.IMMEDIATE));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatArrayEagerDelayError(int r2, int r3, Publisher<? extends T>... r4) {
        return fromArray(r4).concatMapEagerDelayError(Functions.identity(), r2, r3, true);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> concatEager(Publisher<? extends Publisher<? extends T>> r7, int r8, int r9) {
        ObjectHelper.requireNonNull(r7, "sources is null");
        ObjectHelper.verifyPositive(r8, "maxConcurrency");
        ObjectHelper.verifyPositive(r9, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapEagerPublisher(r7, Functions.identity(), r8, r9, ErrorMode.IMMEDIATE));
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    @NonNull
    public static Flowable<Long> interval(long r8, long r10, TimeUnit r12, Scheduler r13) {
        ObjectHelper.requireNonNull(r12, "unit is null");
        ObjectHelper.requireNonNull(r13, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableInterval(Math.max(0, r8), Math.max(0, r10), r12, r13));
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    @NonNull
    public static Flowable<Long> intervalRange(long r16, long r18, long r20, long r22, TimeUnit r24, Scheduler r25) {
        if (r18 < 0) goto L17;
        if (r18 == 0) goto L6;
        long r6 = (r18 - 1) + r16;
        if (r16 > 0) goto L10;
    L14:
        ObjectHelper.requireNonNull(r24, "unit is null");
        ObjectHelper.requireNonNull(r25, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableIntervalRange(r16, r6, Math.max(0, r20), Math.max(0, r22), r24, r25));
    L10:
        if (r6 >= 0) goto L14;
        throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
    L6:
        return empty().delay(r20, r24, r25);
    L17:
        throw new IllegalArgumentException(a.h("count >= 0 required but it was ", r18));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> merge(Iterable<? extends Publisher<? extends T>> r1) {
        return fromIterable(r1).flatMap(Functions.identity());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeArray(Publisher<? extends T>... r2) {
        return fromArray(r2).flatMap(Functions.identity(), r2.length);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeArrayDelayError(Publisher<? extends T>... r3) {
        return fromArray(r3).flatMap(Functions.identity(), true, r3.length);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(Iterable<? extends Publisher<? extends T>> r2, int r3, int r4) {
        return fromIterable(r2).flatMap(Functions.identity(), true, r3, r4);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Single<Boolean> sequenceEqual(Publisher<? extends T> r1, Publisher<? extends T> r2, BiPredicate<? super T, ? super T> r3) {
        return sequenceEqual(r1, r2, r3, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> switchOnNext(Publisher<? extends Publisher<? extends T>> r1) {
        return fromPublisher(r1).switchMap(Functions.identity());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> switchOnNextDelayError(Publisher<? extends Publisher<? extends T>> r1, int r2) {
        return fromPublisher(r1).switchMapDelayError(Functions.identity(), r2);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    @NonNull
    public static Flowable<Long> timer(long r3, TimeUnit r5, Scheduler r6) {
        ObjectHelper.requireNonNull(r5, "unit is null");
        ObjectHelper.requireNonNull(r6, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableTimer(Math.max(0, r3), r5, r6));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public static <T, D> Flowable<T> using(Callable<? extends D> r1, Function<? super D, ? extends Publisher<? extends T>> r2, Consumer<? super D> r3, boolean r4) {
        ObjectHelper.requireNonNull(r1, "resourceSupplier is null");
        ObjectHelper.requireNonNull(r2, "sourceSupplier is null");
        ObjectHelper.requireNonNull(r3, "resourceDisposer is null");
        return RxJavaPlugins.onAssembly(new FlowableUsing(r1, r2, r3, r4));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Iterable<T> blockingIterable(int r2) {
        ObjectHelper.verifyPositive(r2, "bufferSize");
        return new BlockingFlowableIterable(this, r2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final T blockingSingle(T r1) {
        return single(r1).blockingGet();
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public final void blockingSubscribe(Consumer<? super T> r3) {
        FlowableBlockingSubscribe.subscribe(this, r3, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<List<T>> buffer(int r2, int r3) {
        return (Flowable<List<T>>) buffer(r2, r3, ArrayListSupplier.asCallable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> concatMap(Function<? super T, ? extends Publisher<? extends R>> r3, int r4) {
        ObjectHelper.requireNonNull(r3, "mapper is null");
        ObjectHelper.verifyPositive(r4, "prefetch");
        if ((this instanceof ScalarCallable) == false) goto L11;
        Object r2 = ((ScalarCallable) this).call();
        if (r2 != null) goto L9;
        return empty();
    L9:
        return FlowableScalarXMap.scalarXMap(r2, r3);
    L11:
        return RxJavaPlugins.onAssembly(new FlowableConcatMap(this, r3, r4, ErrorMode.IMMEDIATE));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> r3, int r4) {
        ObjectHelper.requireNonNull(r3, "mapper is null");
        ObjectHelper.verifyPositive(r4, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapCompletable(this, r3, ErrorMode.IMMEDIATE, r4));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> r2, boolean r3) {
        return concatMapCompletableDelayError(r2, r3, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> concatMapDelayError(Function<? super T, ? extends Publisher<? extends R>> r2, int r3, boolean r4) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        ObjectHelper.verifyPositive(r3, "prefetch");
        if ((this instanceof ScalarCallable) == false) goto L11;
        Object r1 = ((ScalarCallable) this).call();
        if (r1 != null) goto L9;
        return empty();
    L9:
        return FlowableScalarXMap.scalarXMap(r1, r2);
    L11:
        if (r4 == false) goto L13;
        ErrorMode r5 = ErrorMode.END;
    L15:
        return RxJavaPlugins.onAssembly(new FlowableConcatMap(this, r2, r3, r5));
    L13:
        r5 = ErrorMode.BOUNDARY;
        goto L15
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> concatMapEager(Function<? super T, ? extends Publisher<? extends R>> r8, int r9, int r10) {
        ObjectHelper.requireNonNull(r8, "mapper is null");
        ObjectHelper.verifyPositive(r9, "maxConcurrency");
        ObjectHelper.verifyPositive(r10, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapEager(this, r8, r9, r10, ErrorMode.IMMEDIATE));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> concatMapEagerDelayError(Function<? super T, ? extends Publisher<? extends R>> r8, int r9, int r10, boolean r11) {
        ObjectHelper.requireNonNull(r8, "mapper is null");
        ObjectHelper.verifyPositive(r9, "maxConcurrency");
        ObjectHelper.verifyPositive(r10, "prefetch");
        if (r11 == false) goto L6;
        ErrorMode r12 = ErrorMode.END;
    L8:
        return RxJavaPlugins.onAssembly(new FlowableConcatMapEager(this, r8, r9, r10, r12));
    L6:
        r12 = ErrorMode.BOUNDARY;
        goto L8
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <U> Flowable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> r2, int r3) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        ObjectHelper.verifyPositive(r3, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableFlattenIterable(this, r2, r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> r3, int r4) {
        ObjectHelper.requireNonNull(r3, "mapper is null");
        ObjectHelper.verifyPositive(r4, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapMaybe(this, r3, ErrorMode.IMMEDIATE, r4));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> r2, boolean r3) {
        return concatMapMaybeDelayError(r2, r3, 2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> r3, int r4) {
        ObjectHelper.requireNonNull(r3, "mapper is null");
        ObjectHelper.verifyPositive(r4, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapSingle(this, r3, ErrorMode.IMMEDIATE, r4));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> r2, boolean r3) {
        return concatMapSingleDelayError(r2, r3, 2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @Experimental
    @NonNull
    public final <R> Flowable<R> dematerialize(Function<? super T, Notification<R>> r2) {
        ObjectHelper.requireNonNull(r2, "selector is null");
        return RxJavaPlugins.onAssembly(new FlowableDematerialize(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <K> Flowable<T> distinct(Function<? super T, K> r2) {
        return distinct(r2, Functions.createHashSet());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <K> Flowable<T> distinctUntilChanged(Function<? super T, K> r3) {
        ObjectHelper.requireNonNull(r3, "keySelector is null");
        return RxJavaPlugins.onAssembly(new FlowableDistinctUntilChanged(this, r3, ObjectHelper.equalsPredicate()));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> r3, boolean r4) {
        return flatMap(r3, r4, bufferSize(), bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> r2, boolean r3, int r4) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        ObjectHelper.verifyPositive(r4, "maxConcurrency");
        return RxJavaPlugins.onAssembly(new FlowableFlatMapCompletableCompletable(this, r2, r3, r4));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <U> Flowable<U> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> r2, int r3) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        ObjectHelper.verifyPositive(r3, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableFlattenIterable(this, r2, r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> r2, boolean r3, int r4) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        ObjectHelper.verifyPositive(r4, "maxConcurrency");
        return RxJavaPlugins.onAssembly(new FlowableFlatMapMaybe(this, r2, r3, r4));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> r2, boolean r3, int r4) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        ObjectHelper.verifyPositive(r4, "maxConcurrency");
        return RxJavaPlugins.onAssembly(new FlowableFlatMapSingle(this, r2, r3, r4));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.NONE)
    @CheckReturnValue
    public final Disposable forEachWhile(Predicate<? super T> r2, Consumer<? super Throwable> r3) {
        return forEachWhile(r2, r3, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <K> Flowable<GroupedFlowable<K, T>> groupBy(Function<? super T, ? extends K> r3, boolean r4) {
        return (Flowable<GroupedFlowable<K, T>>) groupBy(r3, Functions.identity(), r4, bufferSize());
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> observeOn(Scheduler r2, boolean r3) {
        return observeOn(r2, r3, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Flowable<T> onBackpressureBuffer(boolean r3) {
        return onBackpressureBuffer(bufferSize(), r3, true);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> onBackpressureDrop(Consumer<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "onDrop is null");
        return RxJavaPlugins.onAssembly(new FlowableOnBackpressureDrop(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final ParallelFlowable<T> parallel(int r2) {
        ObjectHelper.verifyPositive(r2, "parallelism");
        return ParallelFlowable.from(this, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> publish(Function<? super Flowable<T>, ? extends Publisher<R>> r2) {
        return publish(r2, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> repeat(long r3) {
        if (r3 < 0) goto L10;
        if (r3 != 0) goto L8;
        return empty();
    L8:
        return RxJavaPlugins.onAssembly(new FlowableRepeat(this, r3));
    L10:
        throw new IllegalArgumentException(a.h("times >= 0 required but it was ", r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> r2) {
        ObjectHelper.requireNonNull(r2, "selector is null");
        return FlowableReplay.multicastSelector(FlowableInternalHelper.replayCallable(this), r2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> retry(BiPredicate<? super Integer, ? super Throwable> r2) {
        ObjectHelper.requireNonNull(r2, "predicate is null");
        return RxJavaPlugins.onAssembly(new FlowableRetryBiPredicate(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> sample(long r7, TimeUnit r9, boolean r10) {
        return sample(r7, r9, Schedulers.computation(), r10);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> sorted(Comparator<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "sortFunction");
        return toList().toFlowable().map(Functions.listSorter(r2)).flatMapIterable(Functions.identity());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> startWith(Publisher<? extends T> r3) {
        ObjectHelper.requireNonNull(r3, "other is null");
        return concatArray(new Publisher[]{r3, this});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> r4) {
        return subscribe(r4, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, FlowableInternalHelper.RequestMax.INSTANCE);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> switchMap(Function<? super T, ? extends Publisher<? extends R>> r2, int r3) {
        return switchMap0(r2, r3, false);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final <R> Flowable<R> switchMapDelayError(Function<? super T, ? extends Publisher<? extends R>> r2, int r3) {
        return switchMap0(r2, r3, true);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> throttleFirst(long r8, TimeUnit r10, Scheduler r11) {
        ObjectHelper.requireNonNull(r10, "unit is null");
        ObjectHelper.requireNonNull(r11, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableThrottleFirstTimed(this, r8, r10, r11));
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> throttleLast(long r1, TimeUnit r3, Scheduler r4) {
        return sample(r1, r3, r4);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> throttleLatest(long r7, TimeUnit r9, boolean r10) {
        return throttleLatest(r7, r9, Schedulers.computation(), r10);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> throttleWithTimeout(long r1, TimeUnit r3, Scheduler r4) {
        return debounce(r1, r3, r4);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<Timed<T>> timeInterval(Scheduler r2) {
        return timeInterval(TimeUnit.MILLISECONDS, r2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <V> Flowable<T> timeout(Function<? super T, ? extends Publisher<V>> r2, Flowable<? extends T> r3) {
        ObjectHelper.requireNonNull(r3, "other is null");
        return timeout0(null, r2, r3);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<Timed<T>> timestamp(Scheduler r2) {
        return timestamp(TimeUnit.MILLISECONDS, r2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Single<List<T>> toList(int r2) {
        ObjectHelper.verifyPositive(r2, "capacityHint");
        return RxJavaPlugins.onAssembly(new FlowableToListSingle(this, Functions.createArrayList(r2)));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final Single<List<T>> toSortedList(Comparator<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "comparator is null");
        return (Single<List<T>>) toList().map(Functions.listSorter(r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long r7, long r9) {
        return window(r7, r9, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T, R> Flowable<R> combineLatest(Publisher<? extends T>[] r2, Function<? super Object[], ? extends R> r3, int r4) {
        ObjectHelper.requireNonNull(r2, "sources is null");
        if (r2.length == 0) goto L5;
        ObjectHelper.requireNonNull(r3, "combiner is null");
        ObjectHelper.verifyPositive(r4, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableCombineLatest(r2, r3, r4, false));
    L5:
        return empty();
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatestDelayError(Function<? super Object[], ? extends R> r0, int r1, Publisher<? extends T>... r2) {
        return combineLatestDelayError(r2, r0, r1);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concat(Publisher<? extends Publisher<? extends T>> r1) {
        return concat(r1, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatDelayError(Publisher<? extends Publisher<? extends T>> r2) {
        return concatDelayError(r2, bufferSize(), true);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> error(Throwable r1) {
        ObjectHelper.requireNonNull(r1, "throwable is null");
        return error(Functions.justCallable(r1));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> fromFuture(Future<? extends T> r1, long r2, TimeUnit r4) {
        ObjectHelper.requireNonNull(r1, "future is null");
        ObjectHelper.requireNonNull(r4, "unit is null");
        return RxJavaPlugins.onAssembly(new FlowableFromFuture(r1, r2, r4));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> just(T r1, T r2) {
        ObjectHelper.requireNonNull(r1, "item1 is null");
        ObjectHelper.requireNonNull(r2, "item2 is null");
        return fromArray(new Object[]{r1, r2});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> merge(Iterable<? extends Publisher<? extends T>> r1, int r2) {
        return fromIterable(r1).flatMap(Functions.identity(), r2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(Iterable<? extends Publisher<? extends T>> r2, int r3) {
        return fromIterable(r2).flatMap(Functions.identity(), true, r3);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Single<Boolean> sequenceEqual(Publisher<? extends T> r1, Publisher<? extends T> r2, BiPredicate<? super T, ? super T> r3, int r4) {
        ObjectHelper.requireNonNull(r1, "source1 is null");
        ObjectHelper.requireNonNull(r2, "source2 is null");
        ObjectHelper.requireNonNull(r3, "isEqual is null");
        ObjectHelper.verifyPositive(r4, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableSequenceEqualSingle(r1, r2, r3, r4));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    public final void blockingSubscribe(Consumer<? super T> r3, int r4) {
        FlowableBlockingSubscribe.subscribe(this, r3, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, r4);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <U extends Collection<? super T>> Flowable<U> buffer(int r2, int r3, Callable<U> r4) {
        ObjectHelper.verifyPositive(r2, "count");
        ObjectHelper.verifyPositive(r3, "skip");
        ObjectHelper.requireNonNull(r4, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new FlowableBuffer(this, r2, r3, r4));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> r2, boolean r3, int r4) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        ObjectHelper.verifyPositive(r4, "prefetch");
        if (r3 == false) goto L5;
        ErrorMode r5 = ErrorMode.END;
    L7:
        return RxJavaPlugins.onAssembly(new FlowableConcatMapCompletable(this, r2, r5, r4));
    L5:
        r5 = ErrorMode.BOUNDARY;
        goto L7
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> r2, boolean r3, int r4) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        ObjectHelper.verifyPositive(r4, "prefetch");
        if (r3 == false) goto L5;
        ErrorMode r5 = ErrorMode.END;
    L7:
        return RxJavaPlugins.onAssembly(new FlowableConcatMapMaybe(this, r2, r5, r4));
    L5:
        r5 = ErrorMode.BOUNDARY;
        goto L7
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> r2, boolean r3, int r4) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        ObjectHelper.verifyPositive(r4, "prefetch");
        if (r3 == false) goto L5;
        ErrorMode r5 = ErrorMode.END;
    L7:
        return RxJavaPlugins.onAssembly(new FlowableConcatMapSingle(this, r2, r5, r4));
    L5:
        r5 = ErrorMode.BOUNDARY;
        goto L7
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> concatWith(@NonNull SingleSource<? extends T> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableConcatWithSingle(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> debounce(long r2, TimeUnit r4) {
        return debounce(r2, r4, Schedulers.computation());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> delay(long r7, TimeUnit r9) {
        return delay(r7, r9, Schedulers.computation(), false);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> delaySubscription(long r2, TimeUnit r4) {
        return delaySubscription(r2, r4, Schedulers.computation());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <K> Flowable<T> distinct(Function<? super T, K> r2, Callable<? extends Collection<? super K>> r3) {
        ObjectHelper.requireNonNull(r2, "keySelector is null");
        ObjectHelper.requireNonNull(r3, "collectionSupplier is null");
        return RxJavaPlugins.onAssembly(new FlowableDistinct(this, r2, r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> r3, int r4) {
        return flatMap(r3, false, r4, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.NONE)
    @CheckReturnValue
    @NonNull
    public final Disposable forEachWhile(Predicate<? super T> r2, Consumer<? super Throwable> r3, Action r4) {
        ObjectHelper.requireNonNull(r2, "onNext is null");
        ObjectHelper.requireNonNull(r3, "onError is null");
        ObjectHelper.requireNonNull(r4, "onComplete is null");
        ForEachWhileSubscriber r0 = new ForEachWhileSubscriber(r2, r3, r4);
        subscribe(r0);
        return r0;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(Function<? super T, ? extends K> r3, Function<? super T, ? extends V> r4) {
        return groupBy(r3, r4, false, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> mergeWith(@NonNull SingleSource<? extends T> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableMergeWithSingle(this, r2));
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> observeOn(Scheduler r2, boolean r3, int r4) {
        ObjectHelper.requireNonNull(r2, "scheduler is null");
        ObjectHelper.verifyPositive(r4, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableObserveOn(this, r2, r3, r4));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> onBackpressureBuffer(int r2) {
        return onBackpressureBuffer(r2, false, false);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> onErrorResumeNext(Publisher<? extends T> r2) {
        ObjectHelper.requireNonNull(r2, "next is null");
        return onErrorResumeNext(Functions.justFunction(r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> publish(Function<? super Flowable<T>, ? extends Publisher<? extends R>> r3, int r4) {
        ObjectHelper.requireNonNull(r3, "selector is null");
        ObjectHelper.verifyPositive(r4, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowablePublishMulticast(this, r3, r4, false));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final <R> Single<R> reduce(R r2, BiFunction<R, ? super T, R> r3) {
        ObjectHelper.requireNonNull(r2, "seed is null");
        ObjectHelper.requireNonNull(r3, "reducer is null");
        return RxJavaPlugins.onAssembly(new FlowableReduceSeedSingle(this, r2, r3));
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> sample(long r9, TimeUnit r11, Scheduler r12) {
        ObjectHelper.requireNonNull(r11, "unit is null");
        ObjectHelper.requireNonNull(r12, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableSampleTimed(this, r9, r11, r12, false));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> scan(R r2, BiFunction<R, ? super T, R> r3) {
        ObjectHelper.requireNonNull(r2, "initialValue is null");
        return scanWith(Functions.justCallable(r2), r3);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> skip(long r1, TimeUnit r3) {
        return skipUntil(timer(r1, r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> r3, Consumer<? super Throwable> r4) {
        return subscribe(r3, r4, Functions.EMPTY_ACTION, FlowableInternalHelper.RequestMax.INSTANCE);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> subscribeOn(@NonNull Scheduler r2, boolean r3) {
        ObjectHelper.requireNonNull(r2, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableSubscribeOn(this, r2, r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public final <U> Flowable<T> takeUntil(Publisher<U> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableTakeUntil(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final TestSubscriber<T> test(long r2) {
        TestSubscriber<T> r0 = new TestSubscriber(r2);
        subscribe(r0);
        return r0;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> throttleLatest(long r7, TimeUnit r9, Scheduler r10) {
        return throttleLatest(r7, r9, r10, false);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<Timed<T>> timeInterval(TimeUnit r2) {
        return timeInterval(r2, Schedulers.computation());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<Timed<T>> timestamp(TimeUnit r2) {
        return timestamp(r2, Schedulers.computation());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> r2, Function<? super T, ? extends V> r3) {
        ObjectHelper.requireNonNull(r2, "keySelector is null");
        ObjectHelper.requireNonNull(r3, "valueSelector is null");
        return (Single<Map<K, V>>) collect(HashMapSupplier.asCallable(), Functions.toMapKeyValueSelector(r2, r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long r9, long r11, int r13) {
        ObjectHelper.verifyPositive(r11, "skip");
        ObjectHelper.verifyPositive(r9, "count");
        ObjectHelper.verifyPositive(r13, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableWindow(this, r9, r11, r13));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T, R> Flowable<R> combineLatestDelayError(Publisher<? extends T>[] r2, Function<? super Object[], ? extends R> r3, int r4) {
        ObjectHelper.requireNonNull(r2, "sources is null");
        ObjectHelper.requireNonNull(r3, "combiner is null");
        ObjectHelper.verifyPositive(r4, "bufferSize");
        if (r2.length != 0) goto L7;
        return empty();
    L7:
        return RxJavaPlugins.onAssembly(new FlowableCombineLatest(r2, r3, r4, true));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concat(Publisher<? extends Publisher<? extends T>> r1, int r2) {
        return fromPublisher(r1).concatMap(Functions.identity(), r2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatDelayError(Publisher<? extends Publisher<? extends T>> r1, int r2, boolean r3) {
        return fromPublisher(r1).concatMapDelayError(Functions.identity(), r2, r3);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> merge(Publisher<? extends Publisher<? extends T>> r1) {
        return merge(r1, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends Publisher<? extends T>> r1) {
        return mergeDelayError(r1, bufferSize());
    }

    private <U, V> Flowable<T> timeout0(Publisher<U> r2, Function<? super T, ? extends Publisher<V>> r3, Publisher<? extends T> r4) {
        ObjectHelper.requireNonNull(r3, "itemTimeoutIndicator is null");
        return RxJavaPlugins.onAssembly(new FlowableTimeout(this, r2, r3, r4));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T, R> Flowable<R> zip(Publisher<? extends Publisher<? extends T>> r1, Function<? super Object[], ? extends R> r2) {
        ObjectHelper.requireNonNull(r2, "zipper is null");
        return fromPublisher(r1).toList().flatMapPublisher(FlowableInternalHelper.zipIterable(r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public final void blockingSubscribe(Consumer<? super T> r2, Consumer<? super Throwable> r3) {
        FlowableBlockingSubscribe.subscribe(this, r2, r3, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> debounce(long r8, TimeUnit r10, Scheduler r11) {
        ObjectHelper.requireNonNull(r10, "unit is null");
        ObjectHelper.requireNonNull(r11, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableDebounceTimed(this, r8, r10, r11));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> delay(long r7, TimeUnit r9, boolean r10) {
        return delay(r7, r9, Schedulers.computation(), r10);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> delaySubscription(long r1, TimeUnit r3, Scheduler r4) {
        return delaySubscription(timer(r1, r3, r4));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> distinctUntilChanged(BiPredicate<? super T, ? super T> r3) {
        ObjectHelper.requireNonNull(r3, "comparer is null");
        return RxJavaPlugins.onAssembly(new FlowableDistinctUntilChanged(this, Functions.identity(), r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> r2, boolean r3, int r4) {
        return flatMap(r2, r3, r4, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(Function<? super T, ? extends K> r2, Function<? super T, ? extends V> r3, boolean r4) {
        return groupBy(r2, r3, r4, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> onBackpressureBuffer(int r2, boolean r3) {
        return onBackpressureBuffer(r2, r3, false);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final ParallelFlowable<T> parallel(int r2, int r3) {
        ObjectHelper.verifyPositive(r2, "parallelism");
        ObjectHelper.verifyPositive(r3, "prefetch");
        return ParallelFlowable.from(this, r2, r3);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> r2, int r3) {
        ObjectHelper.requireNonNull(r2, "selector is null");
        ObjectHelper.verifyPositive(r3, "bufferSize");
        return FlowableReplay.multicastSelector(FlowableInternalHelper.replayCallable(this, r3), r2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> retry(long r2) {
        return retry(r2, Functions.alwaysTrue());
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> skip(long r1, TimeUnit r3, Scheduler r4) {
        return skipUntil(timer(r1, r3, r4));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> startWith(T r3) {
        ObjectHelper.requireNonNull(r3, "value is null");
        return concatArray(new Publisher[]{just(r3), this});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> r2, Consumer<? super Throwable> r3, Action r4) {
        return subscribe(r2, r3, r4, FlowableInternalHelper.RequestMax.INSTANCE);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> throttleLatest(long r9, TimeUnit r11, Scheduler r12, boolean r13) {
        ObjectHelper.requireNonNull(r11, "unit is null");
        ObjectHelper.requireNonNull(r12, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableThrottleLatest(this, r9, r11, r12, r13));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<Timed<T>> timeInterval(TimeUnit r2, Scheduler r3) {
        ObjectHelper.requireNonNull(r2, "unit is null");
        ObjectHelper.requireNonNull(r3, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableTimeInterval(this, r2, r3));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> timeout(long r7, TimeUnit r9) {
        return timeout0(r7, r9, null, Schedulers.computation());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public final Flowable<Timed<T>> timestamp(TimeUnit r2, Scheduler r3) {
        ObjectHelper.requireNonNull(r2, "unit is null");
        ObjectHelper.requireNonNull(r3, "scheduler is null");
        return (Flowable<Timed<T>>) map(Functions.timestampWith(r2, r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <U extends Collection<? super T>> Single<U> toList(Callable<U> r2) {
        ObjectHelper.requireNonNull(r2, "collectionSupplier is null");
        return RxJavaPlugins.onAssembly(new FlowableToListSingle(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final Single<List<T>> toSortedList(Comparator<? super T> r2, int r3) {
        ObjectHelper.requireNonNull(r2, "comparator is null");
        return (Single<List<T>>) toList(r3).map(Functions.listSorter(r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public final <T1, T2, R> Flowable<R> withLatestFrom(Publisher<T1> r3, Publisher<T2> r4, Function3<? super T, ? super T1, ? super T2, R> r5) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        return withLatestFrom(new Publisher[]{r3, r4}, Functions.toFunction(r5));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <U, R> Flowable<R> zipWith(Publisher<? extends U> r2, BiFunction<? super T, ? super U, ? extends R> r3) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return zip(this, r2, r3);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> concat(Publisher<? extends T> r2, Publisher<? extends T> r3) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        return concatArray(new Publisher[]{r2, r3});
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public static Flowable<Long> interval(long r6, TimeUnit r8) {
        return interval(r6, r6, r8, Schedulers.computation());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> merge(Publisher<? extends Publisher<? extends T>> r1, int r2) {
        return fromPublisher(r1).flatMap(Functions.identity(), r2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends Publisher<? extends T>> r2, int r3) {
        return fromPublisher(r2).flatMap(Functions.identity(), true, r3);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final T blockingFirst(T r2) {
        BlockingFirstSubscriber r0 = new BlockingFirstSubscriber();
        subscribe(r0);
        T r1 = r0.blockingGet();
        if (r1 != null) goto L5;
        return r2;
    L5:
        return r1;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final T blockingLast(T r2) {
        BlockingLastSubscriber r0 = new BlockingLastSubscriber();
        subscribe(r0);
        T r1 = r0.blockingGet();
        if (r1 != null) goto L5;
        return r2;
    L5:
        return r1;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    public final void blockingSubscribe(Consumer<? super T> r2, Consumer<? super Throwable> r3, int r4) {
        FlowableBlockingSubscribe.subscribe(this, r2, r3, Functions.EMPTY_ACTION, r4);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> concatWith(@NonNull MaybeSource<? extends T> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableConcatWithMaybe(this, r2));
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> delay(long r7, TimeUnit r9, Scheduler r10) {
        return delay(r7, r9, r10, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> r8, boolean r9, int r10, int r11) {
        ObjectHelper.requireNonNull(r8, "mapper is null");
        ObjectHelper.verifyPositive(r10, "maxConcurrency");
        ObjectHelper.verifyPositive(r11, "bufferSize");
        if ((this instanceof ScalarCallable) == false) goto L11;
        Object r7 = ((ScalarCallable) this).call();
        if (r7 != null) goto L9;
        return empty();
    L9:
        return FlowableScalarXMap.scalarXMap(r7, r8);
    L11:
        return RxJavaPlugins.onAssembly(new FlowableFlatMap(this, r8, r9, r10, r11));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <U, V> Flowable<V> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> r8, BiFunction<? super T, ? super U, ? extends V> r9) {
        ObjectHelper.requireNonNull(r8, "mapper is null");
        ObjectHelper.requireNonNull(r9, "resultSelector is null");
        return (Flowable<V>) flatMap(FlowableInternalHelper.flatMapIntoIterable(r8), r9, false, bufferSize(), bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(Function<? super T, ? extends K> r9, Function<? super T, ? extends V> r10, boolean r11, int r12) {
        ObjectHelper.requireNonNull(r9, "keySelector is null");
        ObjectHelper.requireNonNull(r10, "valueSelector is null");
        ObjectHelper.verifyPositive(r12, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableGroupBy(this, r9, r10, r12, r11, null));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> mergeWith(@NonNull MaybeSource<? extends T> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableMergeWithMaybe(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final Flowable<T> onBackpressureBuffer(int r8, boolean r9, boolean r10) {
        ObjectHelper.verifyPositive(r8, PerfConsts.KEY_CURRENT_CAPACITY);
        return RxJavaPlugins.onAssembly(new FlowableOnBackpressureBuffer(this, r8, r10, r9, Functions.EMPTY_ACTION));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> retry(long r3, Predicate<? super Throwable> r5) {
        if (r3 < 0) goto L7;
        ObjectHelper.requireNonNull(r5, "predicate is null");
        return RxJavaPlugins.onAssembly(new FlowableRetryPredicate(this, r3, r5));
    L7:
        throw new IllegalArgumentException(a.h("times >= 0 required but it was ", r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    @NonNull
    public final Disposable subscribe(Consumer<? super T> r2, Consumer<? super Throwable> r3, Action r4, Consumer<? super Subscription> r5) {
        ObjectHelper.requireNonNull(r2, "onNext is null");
        ObjectHelper.requireNonNull(r3, "onError is null");
        ObjectHelper.requireNonNull(r4, "onComplete is null");
        ObjectHelper.requireNonNull(r5, "onSubscribe is null");
        LambdaSubscriber r0 = new LambdaSubscriber(r2, r3, r4, r5);
        subscribe(r0);
        return r0;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final TestSubscriber<T> test(long r2, boolean r4) {
        TestSubscriber<T> r0 = new TestSubscriber(r2);
        if (r4 == false) goto L5;
        r0.cancel();
    L5:
        subscribe(r0);
        return r0;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> timeout(long r8, TimeUnit r10, Publisher<? extends T> r11) {
        ObjectHelper.requireNonNull(r11, "other is null");
        return timeout0(r8, r10, r11, Schedulers.computation());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> r3, Function<? super T, ? extends V> r4) {
        return toMultimap(r3, r4, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatEager(Iterable<? extends Publisher<? extends T>> r2) {
        return concatEager(r2, bufferSize(), bufferSize());
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> fromFuture(Future<? extends T> r1, long r2, TimeUnit r4, Scheduler r5) {
        ObjectHelper.requireNonNull(r5, "scheduler is null");
        return fromFuture(r1, r2, r4).subscribeOn(r5);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T, S> Flowable<T> generate(Callable<S> r1, BiConsumer<S, Emitter<T>> r2) {
        ObjectHelper.requireNonNull(r2, "generator is null");
        return generate(r1, FlowableInternalHelper.simpleBiGenerator(r2), Functions.emptyConsumer());
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public static Flowable<Long> interval(long r6, TimeUnit r8, Scheduler r9) {
        return interval(r6, r6, r8, r9);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> just(T r1, T r2, T r3) {
        ObjectHelper.requireNonNull(r1, "item1 is null");
        ObjectHelper.requireNonNull(r2, "item2 is null");
        ObjectHelper.requireNonNull(r3, "item3 is null");
        return fromArray(new Object[]{r1, r2, r3});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> merge(Publisher<? extends T> r3, Publisher<? extends T> r4) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        return fromArray(new Publisher[]{r3, r4}).flatMap(Functions.identity(), false, 2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends T> r3, Publisher<? extends T> r4) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        return fromArray(new Publisher[]{r3, r4}).flatMap(Functions.identity(), true, 2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T1, T2, R> Flowable<R> zip(Publisher<? extends T1> r3, Publisher<? extends T2> r4, BiFunction<? super T1, ? super T2, ? extends R> r5) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        return zipArray(Functions.toFunction(r5), false, bufferSize(), new Publisher[]{r3, r4});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public final void blockingSubscribe(Consumer<? super T> r1, Consumer<? super Throwable> r2, Action r3) {
        FlowableBlockingSubscribe.subscribe(this, r1, r2, r3);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> delay(long r9, TimeUnit r11, Scheduler r12, boolean r13) {
        ObjectHelper.requireNonNull(r11, "unit is null");
        ObjectHelper.requireNonNull(r12, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableDelay(this, Math.max(0, r9), r11, r12, r13));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> doOnEach(Consumer<? super Notification<T>> r4) {
        ObjectHelper.requireNonNull(r4, "onNotification is null");
        return doOnEach(Functions.notificationOnNext(r4), Functions.notificationOnError(r4), Functions.notificationOnComplete(r4), Functions.EMPTY_ACTION);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final ConnectableFlowable<T> publish(int r2) {
        ObjectHelper.verifyPositive(r2, "bufferSize");
        return FlowablePublish.create(this, r2);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> sample(long r9, TimeUnit r11, Scheduler r12, boolean r13) {
        ObjectHelper.requireNonNull(r11, "unit is null");
        ObjectHelper.requireNonNull(r12, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableSampleTimed(this, r9, r11, r12, r13));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> r2, Function<? super T, ? extends V> r3, Callable<? extends Map<K, V>> r4) {
        ObjectHelper.requireNonNull(r2, "keySelector is null");
        ObjectHelper.requireNonNull(r3, "valueSelector is null");
        return (Single<Map<K, V>>) collect(r4, Functions.toMapKeyValueSelector(r2, r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Single<List<T>> toSortedList(int r2) {
        return toSortedList(Functions.naturalComparator(), r2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U, R> Flowable<R> zipWith(Publisher<? extends U> r1, BiFunction<? super T, ? super U, ? extends R> r2, boolean r3) {
        return zip(this, r1, r2, r3);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> concatEager(Iterable<? extends Publisher<? extends T>> r7, int r8, int r9) {
        ObjectHelper.requireNonNull(r7, "sources is null");
        ObjectHelper.verifyPositive(r8, "maxConcurrency");
        ObjectHelper.verifyPositive(r9, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapEager(new FlowableFromIterable(r7), Functions.identity(), r8, r9, ErrorMode.IMMEDIATE));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    public final void blockingSubscribe(Consumer<? super T> r1, Consumer<? super Throwable> r2, Action r3, int r4) {
        FlowableBlockingSubscribe.subscribe(this, r1, r2, r3, r4);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U extends Collection<? super T>> Flowable<U> buffer(int r1, Callable<U> r2) {
        return buffer(r1, r1, r2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> concatWith(@NonNull CompletableSource r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableConcatWithCompletable(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> mergeWith(@NonNull CompletableSource r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableMergeWithCompletable(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> onBackpressureBuffer(int r8, boolean r9, boolean r10, Action r11) {
        ObjectHelper.requireNonNull(r11, "onOverflow is null");
        ObjectHelper.verifyPositive(r8, PerfConsts.KEY_CURRENT_CAPACITY);
        return RxJavaPlugins.onAssembly(new FlowableOnBackpressureBuffer(this, r8, r10, r9, r11));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> r8, int r9, long r10, TimeUnit r12) {
        return replay(r8, r9, r10, r12, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> timeout(long r7, TimeUnit r9, Scheduler r10, Publisher<? extends T> r11) {
        ObjectHelper.requireNonNull(r11, "other is null");
        return timeout0(r7, r9, r11, r10);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long r9, long r11, TimeUnit r13) {
        return window(r9, r11, r13, Schedulers.computation(), bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U, R> Flowable<R> zipWith(Publisher<? extends U> r1, BiFunction<? super T, ? super U, ? extends R> r2, boolean r3, int r4) {
        return zip(this, r1, r2, r3, r4);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> concat(Publisher<? extends T> r2, Publisher<? extends T> r3, Publisher<? extends T> r4) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        return concatArray(new Publisher[]{r2, r3, r4});
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> fromFuture(Future<? extends T> r1, Scheduler r2) {
        ObjectHelper.requireNonNull(r2, "scheduler is null");
        return fromFuture(r1).subscribeOn(r2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Single<Boolean> sequenceEqual(Publisher<? extends T> r1, Publisher<? extends T> r2, int r3) {
        return sequenceEqual(r1, r2, ObjectHelper.equalsPredicate(), r3);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.SPECIAL)
    public final void blockingSubscribe(Subscriber<? super T> r1) {
        FlowableBlockingSubscribe.subscribe(this, r1);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<List<T>> buffer(long r9, long r11, TimeUnit r13) {
        return (Flowable<List<T>>) buffer(r9, r11, r13, Schedulers.computation(), ArrayListSupplier.asCallable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <U, V> Flowable<V> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> r8, BiFunction<? super T, ? super U, ? extends V> r9, int r10) {
        ObjectHelper.requireNonNull(r8, "mapper is null");
        ObjectHelper.requireNonNull(r9, "resultSelector is null");
        return (Flowable<V>) flatMap(FlowableInternalHelper.flatMapIntoIterable(r8), r9, false, bufferSize(), r10);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> r7, int r8, long r9, TimeUnit r11, Scheduler r12) {
        ObjectHelper.requireNonNull(r7, "selector is null");
        ObjectHelper.requireNonNull(r11, "unit is null");
        ObjectHelper.verifyPositive(r8, "bufferSize");
        ObjectHelper.requireNonNull(r12, "scheduler is null");
        return FlowableReplay.multicastSelector(FlowableInternalHelper.replayCallable(this, r8, r9, r11, r12), r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> r2, Function<? super T, ? extends V> r3, Callable<? extends Map<K, Collection<V>>> r4, Function<? super K, ? extends Collection<? super V>> r5) {
        ObjectHelper.requireNonNull(r2, "keySelector is null");
        ObjectHelper.requireNonNull(r3, "valueSelector is null");
        ObjectHelper.requireNonNull(r4, "mapSupplier is null");
        ObjectHelper.requireNonNull(r5, "collectionFactory is null");
        return (Single<Map<K, Collection<V>>>) collect(r4, Functions.toMultimapKeyValueSelector(r2, r3, r5));
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long r9, long r11, TimeUnit r13, Scheduler r14) {
        return window(r9, r11, r13, r14, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public final <T1, T2, T3, R> Flowable<R> withLatestFrom(Publisher<T1> r3, Publisher<T2> r4, Publisher<T3> r5, Function4<? super T, ? super T1, ? super T2, ? super T3, R> r6) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        return withLatestFrom(new Publisher[]{r3, r4, r5}, Functions.toFunction(r6));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatest(Iterable<? extends Publisher<? extends T>> r1, Function<? super Object[], ? extends R> r2) {
        return combineLatest(r1, r2, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> merge(Publisher<? extends T> r3, Publisher<? extends T> r4, Publisher<? extends T> r5) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        return fromArray(new Publisher[]{r3, r4, r5}).flatMap(Functions.identity(), false, 3);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends T> r3, Publisher<? extends T> r4, Publisher<? extends T> r5) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        return fromArray(new Publisher[]{r3, r4, r5}).flatMap(Functions.identity(), true, 3);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T1, T2, R> Flowable<R> zip(Publisher<? extends T1> r3, Publisher<? extends T2> r4, BiFunction<? super T1, ? super T2, ? extends R> r5, boolean r6) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        return zipArray(Functions.toFunction(r5), r6, bufferSize(), new Publisher[]{r3, r4});
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<List<T>> buffer(long r9, long r11, TimeUnit r13, Scheduler r14) {
        return (Flowable<List<T>>) buffer(r9, r11, r13, r14, ArrayListSupplier.asCallable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U, V> Flowable<T> delay(Publisher<U> r1, Function<? super T, ? extends Publisher<V>> r2) {
        return delaySubscription(r1).delay(r2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final Single<T> elementAt(long r3, T r5) {
        if (r3 < 0) goto L7;
        ObjectHelper.requireNonNull(r5, "defaultItem is null");
        return RxJavaPlugins.onAssembly(new FlowableElementAtSingle(this, r3, r5));
    L7:
        throw new IndexOutOfBoundsException(a.h("index >= 0 required but it was ", r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(Function<? super T, ? extends K> r9, Function<? super T, ? extends V> r10, boolean r11, int r12, Function<? super Consumer<Object>, ? extends Map<K, Object>> r13) {
        ObjectHelper.requireNonNull(r9, "keySelector is null");
        ObjectHelper.requireNonNull(r10, "valueSelector is null");
        ObjectHelper.verifyPositive(r12, "bufferSize");
        ObjectHelper.requireNonNull(r13, "evictingMapFactory is null");
        return RxJavaPlugins.onAssembly(new FlowableGroupBy(this, r9, r10, r12, r11, r13));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    @NonNull
    public final <U> Flowable<T> sample(Publisher<U> r3) {
        ObjectHelper.requireNonNull(r3, "sampler is null");
        return RxJavaPlugins.onAssembly(new FlowableSamplePublisher(this, r3, false));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> take(long r1, TimeUnit r3) {
        return takeUntil(timer(r1, r3));
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> timeout(long r7, TimeUnit r9, Scheduler r10) {
        return timeout0(r7, r9, null, r10);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    @NonNull
    public final Flowable<Flowable<T>> window(long r14, long r16, TimeUnit r18, Scheduler r19, int r20) {
        ObjectHelper.verifyPositive(r20, "bufferSize");
        ObjectHelper.verifyPositive(r14, "timespan");
        ObjectHelper.verifyPositive(r16, "timeskip");
        ObjectHelper.requireNonNull(r19, "scheduler is null");
        ObjectHelper.requireNonNull(r18, "unit is null");
        return RxJavaPlugins.onAssembly(new FlowableWindowTimed(this, r14, r16, r18, r19, Long.MAX_VALUE, r20, false));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T, R> Flowable<R> combineLatest(Iterable<? extends Publisher<? extends T>> r2, Function<? super Object[], ? extends R> r3, int r4) {
        ObjectHelper.requireNonNull(r2, "sources is null");
        ObjectHelper.requireNonNull(r3, "combiner is null");
        ObjectHelper.verifyPositive(r4, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableCombineLatest(r2, r3, r4, false));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatestDelayError(Iterable<? extends Publisher<? extends T>> r1, Function<? super Object[], ? extends R> r2) {
        return combineLatestDelayError(r1, r2, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T, S> Flowable<T> generate(Callable<S> r1, BiConsumer<S, Emitter<T>> r2, Consumer<? super S> r3) {
        ObjectHelper.requireNonNull(r2, "generator is null");
        return generate(r1, FlowableInternalHelper.simpleBiGenerator(r2), r3);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> just(T r1, T r2, T r3, T r4) {
        ObjectHelper.requireNonNull(r1, "item1 is null");
        ObjectHelper.requireNonNull(r2, "item2 is null");
        ObjectHelper.requireNonNull(r3, "item3 is null");
        ObjectHelper.requireNonNull(r4, "item4 is null");
        return fromArray(new Object[]{r1, r2, r3, r4});
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    @NonNull
    public final <U extends Collection<? super T>> Flowable<U> buffer(long r13, long r15, TimeUnit r17, Scheduler r18, Callable<U> r19) {
        ObjectHelper.requireNonNull(r17, "unit is null");
        ObjectHelper.requireNonNull(r18, "scheduler is null");
        ObjectHelper.requireNonNull(r19, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new FlowableBufferTimed(this, r13, r15, r17, r18, r19, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, false));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> onBackpressureBuffer(int r2, Action r3) {
        return onBackpressureBuffer(r2, false, false, r3);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Flowable<T> skipLast(long r8, TimeUnit r10) {
        return skipLast(r8, r10, Schedulers.computation(), false, bufferSize());
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> take(long r1, TimeUnit r3, Scheduler r4) {
        return takeUntil(timer(r1, r3, r4));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public final <U, V> Flowable<T> timeout(Publisher<U> r2, Function<? super T, ? extends Publisher<V>> r3) {
        ObjectHelper.requireNonNull(r2, "firstTimeoutIndicator is null");
        return timeout0(r2, r3, null);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatestDelayError(Iterable<? extends Publisher<? extends T>> r2, Function<? super Object[], ? extends R> r3, int r4) {
        ObjectHelper.requireNonNull(r2, "sources is null");
        ObjectHelper.requireNonNull(r3, "combiner is null");
        ObjectHelper.verifyPositive(r4, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableCombineLatest(r2, r3, r4, true));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> doOnEach(Subscriber<? super T> r4) {
        ObjectHelper.requireNonNull(r4, "subscriber is null");
        return doOnEach(FlowableInternalHelper.subscriberOnNext(r4), FlowableInternalHelper.subscriberOnError(r4), FlowableInternalHelper.subscriberOnComplete(r4), Functions.EMPTY_ACTION);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> onBackpressureBuffer(long r8, Action r10, BackpressureOverflowStrategy r11) {
        ObjectHelper.requireNonNull(r11, "overflowStrategy is null");
        ObjectHelper.verifyPositive(r8, PerfConsts.KEY_CURRENT_CAPACITY);
        return RxJavaPlugins.onAssembly(new FlowableOnBackpressureBufferStrategy(this, r8, r10, r11));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    @NonNull
    public final <U> Flowable<T> sample(Publisher<U> r2, boolean r3) {
        ObjectHelper.requireNonNull(r2, "sampler is null");
        return RxJavaPlugins.onAssembly(new FlowableSamplePublisher(this, r2, r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Flowable<T> skipLast(long r8, TimeUnit r10, boolean r11) {
        return skipLast(r8, r10, Schedulers.computation(), r11, bufferSize());
    }

    @Override // org.reactivestreams.Publisher
    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.SPECIAL)
    public final void subscribe(Subscriber<? super T> r2) {
        if ((r2 instanceof FlowableSubscriber) == false) goto L5;
        subscribe((FlowableSubscriber) r2);
        return;
    L5:
        ObjectHelper.requireNonNull(r2, "s is null");
        subscribe(new StrictSubscriber(r2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> takeLast(long r10, long r12, TimeUnit r14) {
        return takeLast(r10, r12, r14, Schedulers.computation(), false, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> concat(Publisher<? extends T> r2, Publisher<? extends T> r3, Publisher<? extends T> r4, Publisher<? extends T> r5) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        ObjectHelper.requireNonNull(r5, "source4 is null");
        return concatArray(new Publisher[]{r2, r3, r4, r5});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, S> Flowable<T> generate(Callable<S> r1, BiFunction<S, Emitter<T>, S> r2) {
        return generate(r1, r2, Functions.emptyConsumer());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T1, T2, R> Flowable<R> zip(Publisher<? extends T1> r2, Publisher<? extends T2> r3, BiFunction<? super T1, ? super T2, ? extends R> r4, boolean r5, int r6) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        return zipArray(Functions.toFunction(r4), r5, r6, new Publisher[]{r2, r3});
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Flowable<T> skipLast(long r8, TimeUnit r10, Scheduler r11) {
        return skipLast(r8, r10, r11, false, bufferSize());
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> takeLast(long r10, long r12, TimeUnit r14, Scheduler r15) {
        return takeLast(r10, r12, r14, r15, false, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <U, V> Flowable<T> timeout(Publisher<U> r2, Function<? super T, ? extends Publisher<V>> r3, Publisher<? extends T> r4) {
        ObjectHelper.requireNonNull(r2, "firstTimeoutSelector is null");
        ObjectHelper.requireNonNull(r4, "other is null");
        return timeout0(r2, r3, r4);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T, S> Flowable<T> generate(Callable<S> r1, BiFunction<S, Emitter<T>, S> r2, Consumer<? super S> r3) {
        ObjectHelper.requireNonNull(r1, "initialState is null");
        ObjectHelper.requireNonNull(r2, "generator is null");
        ObjectHelper.requireNonNull(r3, "disposeState is null");
        return RxJavaPlugins.onAssembly(new FlowableGenerate(r1, r2, r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> merge(Publisher<? extends T> r3, Publisher<? extends T> r4, Publisher<? extends T> r5, Publisher<? extends T> r6) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        ObjectHelper.requireNonNull(r6, "source4 is null");
        return fromArray(new Publisher[]{r3, r4, r5, r6}).flatMap(Functions.identity(), false, 4);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends T> r3, Publisher<? extends T> r4, Publisher<? extends T> r5, Publisher<? extends T> r6) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        ObjectHelper.requireNonNull(r6, "source4 is null");
        return fromArray(new Publisher[]{r3, r4, r5, r6}).flatMap(Functions.identity(), true, 4);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> r2, Function<? super Throwable, ? extends Publisher<? extends R>> r3, Callable<? extends Publisher<? extends R>> r4) {
        ObjectHelper.requireNonNull(r2, "onNextMapper is null");
        ObjectHelper.requireNonNull(r3, "onErrorMapper is null");
        ObjectHelper.requireNonNull(r4, "onCompleteSupplier is null");
        return merge(new FlowableMapNotification(this, r2, r3, r4));
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Flowable<T> skipLast(long r8, TimeUnit r10, Scheduler r11, boolean r12) {
        return skipLast(r8, r10, r11, r12, bufferSize());
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> takeLast(long r12, long r14, TimeUnit r16, Scheduler r17, boolean r18, int r19) {
        ObjectHelper.requireNonNull(r16, "unit is null");
        ObjectHelper.requireNonNull(r17, "scheduler is null");
        ObjectHelper.verifyPositive(r19, "bufferSize");
        if (r12 < 0) goto L7;
        return RxJavaPlugins.onAssembly(new FlowableTakeLastTimed(this, r12, r14, r16, r17, r19, r18));
    L7:
        throw new IndexOutOfBoundsException(a.h("count >= 0 required but it was ", r12));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> r2, Function<? super T, ? extends V> r3, Callable<Map<K, Collection<V>>> r4) {
        return toMultimap(r2, r3, r4, ArrayListSupplier.asFunction());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public final <T1, T2, T3, T4, R> Flowable<R> withLatestFrom(Publisher<T1> r3, Publisher<T2> r4, Publisher<T3> r5, Publisher<T4> r6, Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> r7) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        ObjectHelper.requireNonNull(r6, "source4 is null");
        return withLatestFrom(new Publisher[]{r3, r4, r5, r6}, Functions.toFunction(r7));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T1, T2, R> Flowable<R> combineLatest(Publisher<? extends T1> r2, Publisher<? extends T2> r3, BiFunction<? super T1, ? super T2, ? extends R> r4) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        return combineLatest(Functions.toFunction(r4), new Publisher[]{r2, r3});
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<List<T>> buffer(long r7, TimeUnit r9) {
        return buffer(r7, r9, Schedulers.computation(), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> r2, int r3, Scheduler r4) {
        ObjectHelper.requireNonNull(r2, "selector is null");
        ObjectHelper.requireNonNull(r4, "scheduler is null");
        ObjectHelper.verifyPositive(r3, "bufferSize");
        return FlowableReplay.multicastSelector(FlowableInternalHelper.replayCallable(this, r3), FlowableInternalHelper.replayFunction(r2, r4));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> retry(Predicate<? super Throwable> r3) {
        return retry(Long.MAX_VALUE, r3);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> skipLast(long r10, TimeUnit r12, Scheduler r13, boolean r14, int r15) {
        ObjectHelper.requireNonNull(r12, "unit is null");
        ObjectHelper.requireNonNull(r13, "scheduler is null");
        ObjectHelper.verifyPositive(r15, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableSkipLastTimed(this, r10, r12, r13, r15 << 1, r14));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> just(T r1, T r2, T r3, T r4, T r5) {
        ObjectHelper.requireNonNull(r1, "item1 is null");
        ObjectHelper.requireNonNull(r2, "item2 is null");
        ObjectHelper.requireNonNull(r3, "item3 is null");
        ObjectHelper.requireNonNull(r4, "item4 is null");
        ObjectHelper.requireNonNull(r5, "item5 is null");
        return fromArray(new Object[]{r1, r2, r3, r4, r5});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T1, T2, T3, R> Flowable<R> zip(Publisher<? extends T1> r3, Publisher<? extends T2> r4, Publisher<? extends T3> r5, Function3<? super T1, ? super T2, ? super T3, ? extends R> r6) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        return zipArray(Functions.toFunction(r6), false, bufferSize(), new Publisher[]{r3, r4, r5});
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<List<T>> buffer(long r7, TimeUnit r9, int r10) {
        return buffer(r7, r9, Schedulers.computation(), r10);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.SPECIAL)
    public final void subscribe(FlowableSubscriber<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "s is null");
        Subscriber<? super T> r3 = RxJavaPlugins.onSubscribe(this, r2);     // Catch: Throwable -> L5 NullPointerException -> L7
        ObjectHelper.requireNonNull(r3, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");     // Catch: Throwable -> L5 NullPointerException -> L7
        subscribeActual(r3);     // Catch: Throwable -> L5 NullPointerException -> L7
        return;
    L7:
        e = move-exception;
        throw e;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
        NullPointerException r4 = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
        r4.initCause(th);
        throw r4;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long r9, TimeUnit r11) {
        return window(r9, r11, Schedulers.computation(), Long.MAX_VALUE, false);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<List<T>> buffer(long r9, TimeUnit r11, Scheduler r12, int r13) {
        return (Flowable<List<T>>) buffer(r9, r11, r12, r13, ArrayListSupplier.asCallable(), false);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long r9, TimeUnit r11, long r12) {
        return window(r9, r11, Schedulers.computation(), r12, false);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <U extends Collection<? super T>> Flowable<U> buffer(long r13, TimeUnit r15, Scheduler r16, int r17, Callable<U> r18, boolean r19) {
        ObjectHelper.requireNonNull(r15, "unit is null");
        ObjectHelper.requireNonNull(r16, "scheduler is null");
        ObjectHelper.requireNonNull(r18, "bufferSupplier is null");
        ObjectHelper.verifyPositive(r17, "count");
        return RxJavaPlugins.onAssembly(new FlowableBufferTimed(this, r13, r13, r15, r16, r18, r17, r19));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> r2, Function<Throwable, ? extends Publisher<? extends R>> r3, Callable<? extends Publisher<? extends R>> r4, int r5) {
        ObjectHelper.requireNonNull(r2, "onNextMapper is null");
        ObjectHelper.requireNonNull(r3, "onErrorMapper is null");
        ObjectHelper.requireNonNull(r4, "onCompleteSupplier is null");
        return merge(new FlowableMapNotification(this, r2, r3, r4), r5);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long r9, TimeUnit r11, long r12, boolean r14) {
        return window(r9, r11, Schedulers.computation(), r12, r14);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T1, T2, T3, R> Flowable<R> combineLatest(Publisher<? extends T1> r2, Publisher<? extends T2> r3, Publisher<? extends T3> r4, Function3<? super T1, ? super T2, ? super T3, ? extends R> r5) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        return combineLatest(Functions.toFunction(r5), new Publisher[]{r2, r3, r4});
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long r9, TimeUnit r11, Scheduler r12) {
        return window(r9, r11, r12, Long.MAX_VALUE, false);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T1, T2, T3, T4, R> Flowable<R> zip(Publisher<? extends T1> r3, Publisher<? extends T2> r4, Publisher<? extends T3> r5, Publisher<? extends T4> r6, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> r7) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        ObjectHelper.requireNonNull(r6, "source4 is null");
        return zipArray(Functions.toFunction(r7), false, bufferSize(), new Publisher[]{r3, r4, r5, r6});
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long r9, TimeUnit r11, Scheduler r12, long r13) {
        return window(r9, r11, r12, r13, false);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> withLatestFrom(Publisher<?>[] r2, Function<? super Object[], R> r3) {
        ObjectHelper.requireNonNull(r2, "others is null");
        ObjectHelper.requireNonNull(r3, "combiner is null");
        return RxJavaPlugins.onAssembly(new FlowableWithLatestFromMany(this, r2, r3));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> r7, long r8, TimeUnit r10) {
        return replay(r7, r8, r10, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long r10, TimeUnit r12, Scheduler r13, long r14, boolean r16) {
        return window(r10, r12, r13, r14, r16, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> just(T r1, T r2, T r3, T r4, T r5, T r6) {
        ObjectHelper.requireNonNull(r1, "item1 is null");
        ObjectHelper.requireNonNull(r2, "item2 is null");
        ObjectHelper.requireNonNull(r3, "item3 is null");
        ObjectHelper.requireNonNull(r4, "item4 is null");
        ObjectHelper.requireNonNull(r5, "item5 is null");
        ObjectHelper.requireNonNull(r6, "item6 is null");
        return fromArray(new Object[]{r1, r2, r3, r4, r5, r6});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> r7, BiFunction<? super T, ? super U, ? extends R> r8) {
        return flatMap(r7, r8, false, bufferSize(), bufferSize());
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> r2, long r3, TimeUnit r5, Scheduler r6) {
        ObjectHelper.requireNonNull(r2, "selector is null");
        ObjectHelper.requireNonNull(r5, "unit is null");
        ObjectHelper.requireNonNull(r6, "scheduler is null");
        return FlowableReplay.multicastSelector(FlowableInternalHelper.replayCallable(this, r3, r5, r6), r2);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    @NonNull
    public final Flowable<Flowable<T>> window(long r14, TimeUnit r16, Scheduler r17, long r18, boolean r20, int r21) {
        ObjectHelper.verifyPositive(r21, "bufferSize");
        ObjectHelper.requireNonNull(r17, "scheduler is null");
        ObjectHelper.requireNonNull(r16, "unit is null");
        ObjectHelper.verifyPositive(r18, "count");
        return RxJavaPlugins.onAssembly(new FlowableWindowTimed(this, r14, r14, r16, r17, r18, r21, r20));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T1, T2, T3, T4, R> Flowable<R> combineLatest(Publisher<? extends T1> r2, Publisher<? extends T2> r3, Publisher<? extends T3> r4, Publisher<? extends T4> r5, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> r6) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        ObjectHelper.requireNonNull(r5, "source4 is null");
        return combineLatest(Functions.toFunction(r6), new Publisher[]{r2, r3, r4, r5});
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<List<T>> buffer(long r9, TimeUnit r11, Scheduler r12) {
        return (Flowable<List<T>>) buffer(r9, r11, r12, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ArrayListSupplier.asCallable(), false);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> r7, BiFunction<? super T, ? super U, ? extends R> r8, boolean r9) {
        return flatMap(r7, r8, r9, bufferSize(), bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> withLatestFrom(Iterable<? extends Publisher<?>> r2, Function<? super Object[], R> r3) {
        ObjectHelper.requireNonNull(r2, "others is null");
        ObjectHelper.requireNonNull(r3, "combiner is null");
        return RxJavaPlugins.onAssembly(new FlowableWithLatestFromMany(this, r2, r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <TOpening, TClosing> Flowable<List<T>> buffer(Flowable<? extends TOpening> r2, Function<? super TOpening, ? extends Publisher<? extends TClosing>> r3) {
        return (Flowable<List<T>>) buffer(r2, r3, ArrayListSupplier.asCallable());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> r7, BiFunction<? super T, ? super U, ? extends R> r8, boolean r9, int r10) {
        return flatMap(r7, r8, r9, r10, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T1, T2, T3, T4, T5, R> Flowable<R> zip(Publisher<? extends T1> r3, Publisher<? extends T2> r4, Publisher<? extends T3> r5, Publisher<? extends T4> r6, Publisher<? extends T5> r7, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> r8) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        ObjectHelper.requireNonNull(r6, "source4 is null");
        ObjectHelper.requireNonNull(r7, "source5 is null");
        return zipArray(Functions.toFunction(r8), false, bufferSize(), new Publisher[]{r3, r4, r5, r6, r7});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <TOpening, TClosing, U extends Collection<? super T>> Flowable<U> buffer(Flowable<? extends TOpening> r2, Function<? super TOpening, ? extends Publisher<? extends TClosing>> r3, Callable<U> r4) {
        ObjectHelper.requireNonNull(r2, "openingIndicator is null");
        ObjectHelper.requireNonNull(r3, "closingIndicator is null");
        ObjectHelper.requireNonNull(r4, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new FlowableBufferBoundary(this, r2, r3, r4));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> r2, BiFunction<? super T, ? super U, ? extends R> r3, boolean r4, int r5, int r6) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        ObjectHelper.requireNonNull(r3, "combiner is null");
        ObjectHelper.verifyPositive(r5, "maxConcurrency");
        ObjectHelper.verifyPositive(r6, "bufferSize");
        return flatMap(FlowableInternalHelper.flatMapWithCombiner(r2, r3), r4, r5, r6);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> takeLast(long r8, TimeUnit r10) {
        return takeLast(r8, r10, Schedulers.computation(), false, bufferSize());
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> r2, Scheduler r3) {
        ObjectHelper.requireNonNull(r2, "selector is null");
        ObjectHelper.requireNonNull(r3, "scheduler is null");
        return FlowableReplay.multicastSelector(FlowableInternalHelper.replayCallable(this), FlowableInternalHelper.replayFunction(r2, r3));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> takeLast(long r8, TimeUnit r10, boolean r11) {
        return takeLast(r8, r10, Schedulers.computation(), r11, bufferSize());
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> takeLast(long r8, TimeUnit r10, Scheduler r11) {
        return takeLast(r8, r10, r11, false, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <B> Flowable<Flowable<T>> window(Publisher<B> r2) {
        return window(r2, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T1, T2, T3, T4, T5, R> Flowable<R> combineLatest(Publisher<? extends T1> r2, Publisher<? extends T2> r3, Publisher<? extends T3> r4, Publisher<? extends T4> r5, Publisher<? extends T5> r6, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> r7) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        ObjectHelper.requireNonNull(r5, "source4 is null");
        ObjectHelper.requireNonNull(r6, "source5 is null");
        return combineLatest(Functions.toFunction(r7), new Publisher[]{r2, r3, r4, r5, r6});
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> takeLast(long r8, TimeUnit r10, Scheduler r11, boolean r12) {
        return takeLast(r8, r10, r11, r12, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    @NonNull
    public final <B> Flowable<Flowable<T>> window(Publisher<B> r2, int r3) {
        ObjectHelper.requireNonNull(r2, "boundaryIndicator is null");
        ObjectHelper.verifyPositive(r3, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableWindowBoundary(this, r2, r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> just(T r1, T r2, T r3, T r4, T r5, T r6, T r7) {
        ObjectHelper.requireNonNull(r1, "item1 is null");
        ObjectHelper.requireNonNull(r2, "item2 is null");
        ObjectHelper.requireNonNull(r3, "item3 is null");
        ObjectHelper.requireNonNull(r4, "item4 is null");
        ObjectHelper.requireNonNull(r5, "item5 is null");
        ObjectHelper.requireNonNull(r6, "item6 is null");
        ObjectHelper.requireNonNull(r7, "item7 is null");
        return fromArray(new Object[]{r1, r2, r3, r4, r5, r6, r7});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <B> Flowable<List<T>> buffer(Publisher<B> r2) {
        return (Flowable<List<T>>) buffer(r2, ArrayListSupplier.asCallable());
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> takeLast(long r10, TimeUnit r12, Scheduler r13, boolean r14, int r15) {
        return takeLast(Long.MAX_VALUE, r10, r12, r13, r14, r15);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <B> Flowable<List<T>> buffer(Publisher<B> r2, int r3) {
        ObjectHelper.verifyPositive(r3, "initialCapacity");
        return (Flowable<List<T>>) buffer(r2, Functions.createArrayList(r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> r7, BiFunction<? super T, ? super U, ? extends R> r8, int r9) {
        return flatMap(r7, r8, false, r9, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T1, T2, T3, T4, T5, T6, R> Flowable<R> zip(Publisher<? extends T1> r3, Publisher<? extends T2> r4, Publisher<? extends T3> r5, Publisher<? extends T4> r6, Publisher<? extends T5> r7, Publisher<? extends T6> r8, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> r9) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        ObjectHelper.requireNonNull(r6, "source4 is null");
        ObjectHelper.requireNonNull(r7, "source5 is null");
        ObjectHelper.requireNonNull(r8, "source6 is null");
        return zipArray(Functions.toFunction(r9), false, bufferSize(), new Publisher[]{r3, r4, r5, r6, r7, r8});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final ConnectableFlowable<T> replay(int r2) {
        ObjectHelper.verifyPositive(r2, "bufferSize");
        return FlowableReplay.create(this, r2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <U, V> Flowable<Flowable<T>> window(Publisher<U> r2, Function<? super U, ? extends Publisher<V>> r3) {
        return window(r2, r3, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <B, U extends Collection<? super T>> Flowable<U> buffer(Publisher<B> r2, Callable<U> r3) {
        ObjectHelper.requireNonNull(r2, "boundaryIndicator is null");
        ObjectHelper.requireNonNull(r3, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new FlowableBufferExactBoundary(this, r2, r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    @NonNull
    public final <U, V> Flowable<Flowable<T>> window(Publisher<U> r2, Function<? super U, ? extends Publisher<V>> r3, int r4) {
        ObjectHelper.requireNonNull(r2, "openingIndicator is null");
        ObjectHelper.requireNonNull(r3, "closingIndicator is null");
        ObjectHelper.verifyPositive(r4, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableWindowBoundarySelector(this, r2, r3, r4));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final ConnectableFlowable<T> replay(int r7, long r8, TimeUnit r10) {
        return replay(r7, r8, r10, Schedulers.computation());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T1, T2, T3, T4, T5, T6, R> Flowable<R> combineLatest(Publisher<? extends T1> r2, Publisher<? extends T2> r3, Publisher<? extends T3> r4, Publisher<? extends T4> r5, Publisher<? extends T5> r6, Publisher<? extends T6> r7, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> r8) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        ObjectHelper.requireNonNull(r5, "source4 is null");
        ObjectHelper.requireNonNull(r6, "source5 is null");
        ObjectHelper.requireNonNull(r7, "source6 is null");
        return combineLatest(Functions.toFunction(r8), new Publisher[]{r2, r3, r4, r5, r6, r7});
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final ConnectableFlowable<T> replay(int r7, long r8, TimeUnit r10, Scheduler r11) {
        ObjectHelper.verifyPositive(r7, "bufferSize");
        ObjectHelper.requireNonNull(r10, "unit is null");
        ObjectHelper.requireNonNull(r11, "scheduler is null");
        ObjectHelper.verifyPositive(r7, "bufferSize");
        return FlowableReplay.create(this, r8, r10, r11, r7);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <B> Flowable<List<T>> buffer(Callable<? extends Publisher<B>> r2) {
        return (Flowable<List<T>>) buffer(r2, ArrayListSupplier.asCallable());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <B, U extends Collection<? super T>> Flowable<U> buffer(Callable<? extends Publisher<B>> r2, Callable<U> r3) {
        ObjectHelper.requireNonNull(r2, "boundaryIndicatorSupplier is null");
        ObjectHelper.requireNonNull(r3, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new FlowableBufferBoundarySupplier(this, r2, r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <B> Flowable<Flowable<T>> window(Callable<? extends Publisher<B>> r2) {
        return window(r2, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> just(T r1, T r2, T r3, T r4, T r5, T r6, T r7, T r8) {
        ObjectHelper.requireNonNull(r1, "item1 is null");
        ObjectHelper.requireNonNull(r2, "item2 is null");
        ObjectHelper.requireNonNull(r3, "item3 is null");
        ObjectHelper.requireNonNull(r4, "item4 is null");
        ObjectHelper.requireNonNull(r5, "item5 is null");
        ObjectHelper.requireNonNull(r6, "item6 is null");
        ObjectHelper.requireNonNull(r7, "item7 is null");
        ObjectHelper.requireNonNull(r8, "item8 is null");
        return fromArray(new Object[]{r1, r2, r3, r4, r5, r6, r7, r8});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    @NonNull
    public final <B> Flowable<Flowable<T>> window(Callable<? extends Publisher<B>> r2, int r3) {
        ObjectHelper.requireNonNull(r2, "boundaryIndicatorSupplier is null");
        ObjectHelper.verifyPositive(r3, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableWindowBoundarySupplier(this, r2, r3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, R> Flowable<R> zip(Publisher<? extends T1> r3, Publisher<? extends T2> r4, Publisher<? extends T3> r5, Publisher<? extends T4> r6, Publisher<? extends T5> r7, Publisher<? extends T6> r8, Publisher<? extends T7> r9, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> r10) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        ObjectHelper.requireNonNull(r6, "source4 is null");
        ObjectHelper.requireNonNull(r7, "source5 is null");
        ObjectHelper.requireNonNull(r8, "source6 is null");
        ObjectHelper.requireNonNull(r9, "source7 is null");
        return zipArray(Functions.toFunction(r10), false, bufferSize(), new Publisher[]{r3, r4, r5, r6, r7, r8, r9});
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final ConnectableFlowable<T> replay(int r2, Scheduler r3) {
        ObjectHelper.requireNonNull(r3, "scheduler is null");
        return FlowableReplay.observeOn(replay(r2), r3);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, R> Flowable<R> combineLatest(Publisher<? extends T1> r2, Publisher<? extends T2> r3, Publisher<? extends T3> r4, Publisher<? extends T4> r5, Publisher<? extends T5> r6, Publisher<? extends T6> r7, Publisher<? extends T7> r8, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> r9) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        ObjectHelper.requireNonNull(r5, "source4 is null");
        ObjectHelper.requireNonNull(r6, "source5 is null");
        ObjectHelper.requireNonNull(r7, "source6 is null");
        ObjectHelper.requireNonNull(r8, "source7 is null");
        return combineLatest(Functions.toFunction(r9), new Publisher[]{r2, r3, r4, r5, r6, r7, r8});
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final ConnectableFlowable<T> replay(long r2, TimeUnit r4) {
        return replay(r2, r4, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final ConnectableFlowable<T> replay(long r2, TimeUnit r4, Scheduler r5) {
        ObjectHelper.requireNonNull(r4, "unit is null");
        ObjectHelper.requireNonNull(r5, "scheduler is null");
        return FlowableReplay.create(this, r2, r4, r5);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final ConnectableFlowable<T> replay(Scheduler r2) {
        ObjectHelper.requireNonNull(r2, "scheduler is null");
        return FlowableReplay.observeOn(replay(), r2);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> just(T r1, T r2, T r3, T r4, T r5, T r6, T r7, T r8, T r9) {
        ObjectHelper.requireNonNull(r1, "item1 is null");
        ObjectHelper.requireNonNull(r2, "item2 is null");
        ObjectHelper.requireNonNull(r3, "item3 is null");
        ObjectHelper.requireNonNull(r4, "item4 is null");
        ObjectHelper.requireNonNull(r5, "item5 is null");
        ObjectHelper.requireNonNull(r6, "item6 is null");
        ObjectHelper.requireNonNull(r7, "item7 is null");
        ObjectHelper.requireNonNull(r8, "item8 is null");
        ObjectHelper.requireNonNull(r9, "item9 is null");
        return fromArray(new Object[]{r1, r2, r3, r4, r5, r6, r7, r8, r9});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Flowable<R> zip(Publisher<? extends T1> r3, Publisher<? extends T2> r4, Publisher<? extends T3> r5, Publisher<? extends T4> r6, Publisher<? extends T5> r7, Publisher<? extends T6> r8, Publisher<? extends T7> r9, Publisher<? extends T8> r10, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> r11) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        ObjectHelper.requireNonNull(r6, "source4 is null");
        ObjectHelper.requireNonNull(r7, "source5 is null");
        ObjectHelper.requireNonNull(r8, "source6 is null");
        ObjectHelper.requireNonNull(r9, "source7 is null");
        ObjectHelper.requireNonNull(r10, "source8 is null");
        return zipArray(Functions.toFunction(r11), false, bufferSize(), new Publisher[]{r3, r4, r5, r6, r7, r8, r9, r10});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Flowable<R> combineLatest(Publisher<? extends T1> r2, Publisher<? extends T2> r3, Publisher<? extends T3> r4, Publisher<? extends T4> r5, Publisher<? extends T5> r6, Publisher<? extends T6> r7, Publisher<? extends T7> r8, Publisher<? extends T8> r9, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> r10) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        ObjectHelper.requireNonNull(r5, "source4 is null");
        ObjectHelper.requireNonNull(r6, "source5 is null");
        ObjectHelper.requireNonNull(r7, "source6 is null");
        ObjectHelper.requireNonNull(r8, "source7 is null");
        ObjectHelper.requireNonNull(r9, "source8 is null");
        return combineLatest(Functions.toFunction(r10), new Publisher[]{r2, r3, r4, r5, r6, r7, r8, r9});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Flowable<R> zip(Publisher<? extends T1> r3, Publisher<? extends T2> r4, Publisher<? extends T3> r5, Publisher<? extends T4> r6, Publisher<? extends T5> r7, Publisher<? extends T6> r8, Publisher<? extends T7> r9, Publisher<? extends T8> r10, Publisher<? extends T9> r11, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> r12) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        ObjectHelper.requireNonNull(r6, "source4 is null");
        ObjectHelper.requireNonNull(r7, "source5 is null");
        ObjectHelper.requireNonNull(r8, "source6 is null");
        ObjectHelper.requireNonNull(r9, "source7 is null");
        ObjectHelper.requireNonNull(r10, "source8 is null");
        ObjectHelper.requireNonNull(r11, "source9 is null");
        return zipArray(Functions.toFunction(r12), false, bufferSize(), new Publisher[]{r3, r4, r5, r6, r7, r8, r9, r10, r11});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> just(T r1, T r2, T r3, T r4, T r5, T r6, T r7, T r8, T r9, T r10) {
        ObjectHelper.requireNonNull(r1, "item1 is null");
        ObjectHelper.requireNonNull(r2, "item2 is null");
        ObjectHelper.requireNonNull(r3, "item3 is null");
        ObjectHelper.requireNonNull(r4, "item4 is null");
        ObjectHelper.requireNonNull(r5, "item5 is null");
        ObjectHelper.requireNonNull(r6, "item6 is null");
        ObjectHelper.requireNonNull(r7, "item7 is null");
        ObjectHelper.requireNonNull(r8, "item8 is null");
        ObjectHelper.requireNonNull(r9, "item9 is null");
        ObjectHelper.requireNonNull(r10, "item10 is null");
        return fromArray(new Object[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10});
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Flowable<R> combineLatest(Publisher<? extends T1> r2, Publisher<? extends T2> r3, Publisher<? extends T3> r4, Publisher<? extends T4> r5, Publisher<? extends T5> r6, Publisher<? extends T6> r7, Publisher<? extends T7> r8, Publisher<? extends T8> r9, Publisher<? extends T9> r10, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> r11) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        ObjectHelper.requireNonNull(r5, "source4 is null");
        ObjectHelper.requireNonNull(r6, "source5 is null");
        ObjectHelper.requireNonNull(r7, "source6 is null");
        ObjectHelper.requireNonNull(r8, "source7 is null");
        ObjectHelper.requireNonNull(r9, "source8 is null");
        ObjectHelper.requireNonNull(r10, "source9 is null");
        return combineLatest(Functions.toFunction(r11), new Publisher[]{r2, r3, r4, r5, r6, r7, r8, r9, r10});
    }
}
