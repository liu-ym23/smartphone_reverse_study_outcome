package io.reactivex;

import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
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
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.observers.BlockingFirstObserver;
import io.reactivex.internal.observers.BlockingLastObserver;
import io.reactivex.internal.observers.ForEachWhileObserver;
import io.reactivex.internal.observers.FutureObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.flowable.FlowableFromObservable;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureError;
import io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable;
import io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe;
import io.reactivex.internal.operators.mixed.ObservableConcatMapSingle;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle;
import io.reactivex.internal.operators.observable.BlockingObservableIterable;
import io.reactivex.internal.operators.observable.BlockingObservableLatest;
import io.reactivex.internal.operators.observable.BlockingObservableMostRecent;
import io.reactivex.internal.operators.observable.BlockingObservableNext;
import io.reactivex.internal.operators.observable.ObservableAllSingle;
import io.reactivex.internal.operators.observable.ObservableAmb;
import io.reactivex.internal.operators.observable.ObservableAnySingle;
import io.reactivex.internal.operators.observable.ObservableBlockingSubscribe;
import io.reactivex.internal.operators.observable.ObservableBuffer;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary;
import io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier;
import io.reactivex.internal.operators.observable.ObservableBufferExactBoundary;
import io.reactivex.internal.operators.observable.ObservableBufferTimed;
import io.reactivex.internal.operators.observable.ObservableCache;
import io.reactivex.internal.operators.observable.ObservableCollectSingle;
import io.reactivex.internal.operators.observable.ObservableCombineLatest;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableConcatMapEager;
import io.reactivex.internal.operators.observable.ObservableConcatWithCompletable;
import io.reactivex.internal.operators.observable.ObservableConcatWithMaybe;
import io.reactivex.internal.operators.observable.ObservableConcatWithSingle;
import io.reactivex.internal.operators.observable.ObservableCountSingle;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.observable.ObservableDebounce;
import io.reactivex.internal.operators.observable.ObservableDebounceTimed;
import io.reactivex.internal.operators.observable.ObservableDefer;
import io.reactivex.internal.operators.observable.ObservableDelay;
import io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther;
import io.reactivex.internal.operators.observable.ObservableDematerialize;
import io.reactivex.internal.operators.observable.ObservableDetach;
import io.reactivex.internal.operators.observable.ObservableDistinct;
import io.reactivex.internal.operators.observable.ObservableDistinctUntilChanged;
import io.reactivex.internal.operators.observable.ObservableDoAfterNext;
import io.reactivex.internal.operators.observable.ObservableDoFinally;
import io.reactivex.internal.operators.observable.ObservableDoOnEach;
import io.reactivex.internal.operators.observable.ObservableDoOnLifecycle;
import io.reactivex.internal.operators.observable.ObservableElementAtMaybe;
import io.reactivex.internal.operators.observable.ObservableElementAtSingle;
import io.reactivex.internal.operators.observable.ObservableEmpty;
import io.reactivex.internal.operators.observable.ObservableError;
import io.reactivex.internal.operators.observable.ObservableFilter;
import io.reactivex.internal.operators.observable.ObservableFlatMap;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.observable.ObservableFlatMapMaybe;
import io.reactivex.internal.operators.observable.ObservableFlatMapSingle;
import io.reactivex.internal.operators.observable.ObservableFlattenIterable;
import io.reactivex.internal.operators.observable.ObservableFromArray;
import io.reactivex.internal.operators.observable.ObservableFromCallable;
import io.reactivex.internal.operators.observable.ObservableFromFuture;
import io.reactivex.internal.operators.observable.ObservableFromIterable;
import io.reactivex.internal.operators.observable.ObservableFromPublisher;
import io.reactivex.internal.operators.observable.ObservableFromUnsafeSource;
import io.reactivex.internal.operators.observable.ObservableGenerate;
import io.reactivex.internal.operators.observable.ObservableGroupBy;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.operators.observable.ObservableHide;
import io.reactivex.internal.operators.observable.ObservableIgnoreElements;
import io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable;
import io.reactivex.internal.operators.observable.ObservableInternalHelper;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableIntervalRange;
import io.reactivex.internal.operators.observable.ObservableJoin;
import io.reactivex.internal.operators.observable.ObservableJust;
import io.reactivex.internal.operators.observable.ObservableLastMaybe;
import io.reactivex.internal.operators.observable.ObservableLastSingle;
import io.reactivex.internal.operators.observable.ObservableLift;
import io.reactivex.internal.operators.observable.ObservableMap;
import io.reactivex.internal.operators.observable.ObservableMapNotification;
import io.reactivex.internal.operators.observable.ObservableMaterialize;
import io.reactivex.internal.operators.observable.ObservableMergeWithCompletable;
import io.reactivex.internal.operators.observable.ObservableMergeWithMaybe;
import io.reactivex.internal.operators.observable.ObservableMergeWithSingle;
import io.reactivex.internal.operators.observable.ObservableNever;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.internal.operators.observable.ObservableOnErrorNext;
import io.reactivex.internal.operators.observable.ObservableOnErrorReturn;
import io.reactivex.internal.operators.observable.ObservablePublish;
import io.reactivex.internal.operators.observable.ObservablePublishSelector;
import io.reactivex.internal.operators.observable.ObservableRange;
import io.reactivex.internal.operators.observable.ObservableRangeLong;
import io.reactivex.internal.operators.observable.ObservableReduceMaybe;
import io.reactivex.internal.operators.observable.ObservableReduceSeedSingle;
import io.reactivex.internal.operators.observable.ObservableReduceWithSingle;
import io.reactivex.internal.operators.observable.ObservableRepeat;
import io.reactivex.internal.operators.observable.ObservableRepeatUntil;
import io.reactivex.internal.operators.observable.ObservableRepeatWhen;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.internal.operators.observable.ObservableRetryBiPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryWhen;
import io.reactivex.internal.operators.observable.ObservableSampleTimed;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.operators.observable.ObservableScan;
import io.reactivex.internal.operators.observable.ObservableScanSeed;
import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle;
import io.reactivex.internal.operators.observable.ObservableSerialized;
import io.reactivex.internal.operators.observable.ObservableSingleMaybe;
import io.reactivex.internal.operators.observable.ObservableSingleSingle;
import io.reactivex.internal.operators.observable.ObservableSkip;
import io.reactivex.internal.operators.observable.ObservableSkipLast;
import io.reactivex.internal.operators.observable.ObservableSkipLastTimed;
import io.reactivex.internal.operators.observable.ObservableSkipUntil;
import io.reactivex.internal.operators.observable.ObservableSkipWhile;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.internal.operators.observable.ObservableSwitchIfEmpty;
import io.reactivex.internal.operators.observable.ObservableSwitchMap;
import io.reactivex.internal.operators.observable.ObservableTake;
import io.reactivex.internal.operators.observable.ObservableTakeLast;
import io.reactivex.internal.operators.observable.ObservableTakeLastOne;
import io.reactivex.internal.operators.observable.ObservableTakeLastTimed;
import io.reactivex.internal.operators.observable.ObservableTakeUntil;
import io.reactivex.internal.operators.observable.ObservableTakeUntilPredicate;
import io.reactivex.internal.operators.observable.ObservableTakeWhile;
import io.reactivex.internal.operators.observable.ObservableThrottleFirstTimed;
import io.reactivex.internal.operators.observable.ObservableThrottleLatest;
import io.reactivex.internal.operators.observable.ObservableTimeInterval;
import io.reactivex.internal.operators.observable.ObservableTimeout;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.internal.operators.observable.ObservableTimer;
import io.reactivex.internal.operators.observable.ObservableToList;
import io.reactivex.internal.operators.observable.ObservableToListSingle;
import io.reactivex.internal.operators.observable.ObservableUnsubscribeOn;
import io.reactivex.internal.operators.observable.ObservableUsing;
import io.reactivex.internal.operators.observable.ObservableWindow;
import io.reactivex.internal.operators.observable.ObservableWindowBoundary;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier;
import io.reactivex.internal.operators.observable.ObservableWindowTimed;
import io.reactivex.internal.operators.observable.ObservableWithLatestFrom;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany;
import io.reactivex.internal.operators.observable.ObservableZip;
import io.reactivex.internal.operators.observable.ObservableZipIterable;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.HashMapSupplier;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.observers.SafeObserver;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.Timed;
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

/* JADX INFO: loaded from: classes3.dex */
public abstract class Observable<T> implements ObservableSource<T> {

    /* JADX INFO: renamed from: io.reactivex.Observable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$reactivex$BackpressureStrategy = null;

        static {
            int[] r0 = new int[BackpressureStrategy.values().length];
            $SwitchMap$io$reactivex$BackpressureStrategy = r0;
            r0[BackpressureStrategy.DROP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.LATEST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.MISSING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    protected abstract void subscribeActual(Observer<? super T> r1);

    public Observable() {
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> amb(Iterable<? extends ObservableSource<? extends T>> r2) {
        ObjectHelper.requireNonNull(r2, "sources is null");
        return RxJavaPlugins.onAssembly(new ObservableAmb(null, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> ambArray(ObservableSource<? extends T>... r2) {
        ObjectHelper.requireNonNull(r2, "sources is null");
        int r0 = r2.length;
        if (r0 != 0) goto L7;
        return empty();
    L7:
        if (r0 != 1) goto L11;
        return wrap(r2[0]);
    L11:
        return RxJavaPlugins.onAssembly(new ObservableAmb(r2, null));
    }

    public static int bufferSize() {
        return Flowable.bufferSize();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatest(Function<? super Object[], ? extends R> r0, int r1, ObservableSource<? extends T>... r2) {
        return combineLatest(r2, r0, r1);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatest(Iterable<? extends ObservableSource<? extends T>> r1, Function<? super Object[], ? extends R> r2) {
        return combineLatest(r1, r2, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatest(Iterable<? extends ObservableSource<? extends T>> r7, Function<? super Object[], ? extends R> r8, int r9) {
        ObjectHelper.requireNonNull(r7, "sources is null");
        ObjectHelper.requireNonNull(r8, "combiner is null");
        ObjectHelper.verifyPositive(r9, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableCombineLatest(null, r7, r8, r9 << 1, false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatest(ObservableSource<? extends T>[] r1, Function<? super Object[], ? extends R> r2) {
        return combineLatest(r1, r2, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatest(ObservableSource<? extends T>[] r7, Function<? super Object[], ? extends R> r8, int r9) {
        ObjectHelper.requireNonNull(r7, "sources is null");
        if (r7.length == 0) goto L5;
        ObjectHelper.requireNonNull(r8, "combiner is null");
        ObjectHelper.verifyPositive(r9, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableCombineLatest(r7, null, r8, r9 << 1, false));
    L5:
        return empty();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, R> Observable<R> combineLatest(ObservableSource<? extends T1> r3, ObservableSource<? extends T2> r4, BiFunction<? super T1, ? super T2, ? extends R> r5) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        return combineLatest(Functions.toFunction(r5), bufferSize(), new ObservableSource[]{r3, r4});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, R> Observable<R> combineLatest(ObservableSource<? extends T1> r3, ObservableSource<? extends T2> r4, ObservableSource<? extends T3> r5, Function3<? super T1, ? super T2, ? super T3, ? extends R> r6) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        return combineLatest(Functions.toFunction(r6), bufferSize(), new ObservableSource[]{r3, r4, r5});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, R> Observable<R> combineLatest(ObservableSource<? extends T1> r3, ObservableSource<? extends T2> r4, ObservableSource<? extends T3> r5, ObservableSource<? extends T4> r6, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> r7) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        ObjectHelper.requireNonNull(r6, "source4 is null");
        return combineLatest(Functions.toFunction(r7), bufferSize(), new ObservableSource[]{r3, r4, r5, r6});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, R> Observable<R> combineLatest(ObservableSource<? extends T1> r3, ObservableSource<? extends T2> r4, ObservableSource<? extends T3> r5, ObservableSource<? extends T4> r6, ObservableSource<? extends T5> r7, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> r8) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        ObjectHelper.requireNonNull(r6, "source4 is null");
        ObjectHelper.requireNonNull(r7, "source5 is null");
        return combineLatest(Functions.toFunction(r8), bufferSize(), new ObservableSource[]{r3, r4, r5, r6, r7});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> combineLatest(ObservableSource<? extends T1> r3, ObservableSource<? extends T2> r4, ObservableSource<? extends T3> r5, ObservableSource<? extends T4> r6, ObservableSource<? extends T5> r7, ObservableSource<? extends T6> r8, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> r9) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        ObjectHelper.requireNonNull(r6, "source4 is null");
        ObjectHelper.requireNonNull(r7, "source5 is null");
        ObjectHelper.requireNonNull(r8, "source6 is null");
        return combineLatest(Functions.toFunction(r9), bufferSize(), new ObservableSource[]{r3, r4, r5, r6, r7, r8});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> combineLatest(ObservableSource<? extends T1> r3, ObservableSource<? extends T2> r4, ObservableSource<? extends T3> r5, ObservableSource<? extends T4> r6, ObservableSource<? extends T5> r7, ObservableSource<? extends T6> r8, ObservableSource<? extends T7> r9, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> r10) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        ObjectHelper.requireNonNull(r6, "source4 is null");
        ObjectHelper.requireNonNull(r7, "source5 is null");
        ObjectHelper.requireNonNull(r8, "source6 is null");
        ObjectHelper.requireNonNull(r9, "source7 is null");
        return combineLatest(Functions.toFunction(r10), bufferSize(), new ObservableSource[]{r3, r4, r5, r6, r7, r8, r9});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> combineLatest(ObservableSource<? extends T1> r3, ObservableSource<? extends T2> r4, ObservableSource<? extends T3> r5, ObservableSource<? extends T4> r6, ObservableSource<? extends T5> r7, ObservableSource<? extends T6> r8, ObservableSource<? extends T7> r9, ObservableSource<? extends T8> r10, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> r11) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        ObjectHelper.requireNonNull(r6, "source4 is null");
        ObjectHelper.requireNonNull(r7, "source5 is null");
        ObjectHelper.requireNonNull(r8, "source6 is null");
        ObjectHelper.requireNonNull(r9, "source7 is null");
        ObjectHelper.requireNonNull(r10, "source8 is null");
        return combineLatest(Functions.toFunction(r11), bufferSize(), new ObservableSource[]{r3, r4, r5, r6, r7, r8, r9, r10});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> combineLatest(ObservableSource<? extends T1> r3, ObservableSource<? extends T2> r4, ObservableSource<? extends T3> r5, ObservableSource<? extends T4> r6, ObservableSource<? extends T5> r7, ObservableSource<? extends T6> r8, ObservableSource<? extends T7> r9, ObservableSource<? extends T8> r10, ObservableSource<? extends T9> r11, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> r12) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        ObjectHelper.requireNonNull(r6, "source4 is null");
        ObjectHelper.requireNonNull(r7, "source5 is null");
        ObjectHelper.requireNonNull(r8, "source6 is null");
        ObjectHelper.requireNonNull(r9, "source7 is null");
        ObjectHelper.requireNonNull(r10, "source8 is null");
        ObjectHelper.requireNonNull(r11, "source9 is null");
        return combineLatest(Functions.toFunction(r12), bufferSize(), new ObservableSource[]{r3, r4, r5, r6, r7, r8, r9, r10, r11});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatestDelayError(ObservableSource<? extends T>[] r1, Function<? super Object[], ? extends R> r2) {
        return combineLatestDelayError(r1, r2, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatestDelayError(Function<? super Object[], ? extends R> r0, int r1, ObservableSource<? extends T>... r2) {
        return combineLatestDelayError(r2, r0, r1);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatestDelayError(ObservableSource<? extends T>[] r6, Function<? super Object[], ? extends R> r7, int r8) {
        ObjectHelper.verifyPositive(r8, "bufferSize");
        ObjectHelper.requireNonNull(r7, "combiner is null");
        if (r6.length != 0) goto L7;
        return empty();
    L7:
        return RxJavaPlugins.onAssembly(new ObservableCombineLatest(r6, null, r7, r8 << 1, true));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatestDelayError(Iterable<? extends ObservableSource<? extends T>> r1, Function<? super Object[], ? extends R> r2) {
        return combineLatestDelayError(r1, r2, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatestDelayError(Iterable<? extends ObservableSource<? extends T>> r7, Function<? super Object[], ? extends R> r8, int r9) {
        ObjectHelper.requireNonNull(r7, "sources is null");
        ObjectHelper.requireNonNull(r8, "combiner is null");
        ObjectHelper.verifyPositive(r9, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableCombineLatest(null, r7, r8, r9 << 1, true));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concat(Iterable<? extends ObservableSource<? extends T>> r3) {
        ObjectHelper.requireNonNull(r3, "sources is null");
        return fromIterable(r3).concatMapDelayError(Functions.identity(), bufferSize(), false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concat(ObservableSource<? extends ObservableSource<? extends T>> r1) {
        return concat(r1, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concat(ObservableSource<? extends ObservableSource<? extends T>> r3, int r4) {
        ObjectHelper.requireNonNull(r3, "sources is null");
        ObjectHelper.verifyPositive(r4, "prefetch");
        return RxJavaPlugins.onAssembly(new ObservableConcatMap(r3, Functions.identity(), r4, ErrorMode.IMMEDIATE));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concat(ObservableSource<? extends T> r2, ObservableSource<? extends T> r3) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        return concatArray(new ObservableSource[]{r2, r3});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concat(ObservableSource<? extends T> r2, ObservableSource<? extends T> r3, ObservableSource<? extends T> r4) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        return concatArray(new ObservableSource[]{r2, r3, r4});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concat(ObservableSource<? extends T> r2, ObservableSource<? extends T> r3, ObservableSource<? extends T> r4, ObservableSource<? extends T> r5) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        ObjectHelper.requireNonNull(r5, "source4 is null");
        return concatArray(new ObservableSource[]{r2, r3, r4, r5});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatArray(ObservableSource<? extends T>... r4) {
        if (r4.length != 0) goto L7;
        return empty();
    L7:
        if (r4.length != 1) goto L11;
        return wrap(r4[0]);
    L11:
        return RxJavaPlugins.onAssembly(new ObservableConcatMap(fromArray(r4), Functions.identity(), bufferSize(), ErrorMode.BOUNDARY));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatArrayDelayError(ObservableSource<? extends T>... r2) {
        if (r2.length != 0) goto L7;
        return empty();
    L7:
        if (r2.length != 1) goto L11;
        return wrap(r2[0]);
    L11:
        return concatDelayError(fromArray(r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatArrayEager(ObservableSource<? extends T>... r2) {
        return concatArrayEager(bufferSize(), bufferSize(), r2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatArrayEager(int r2, int r3, ObservableSource<? extends T>... r4) {
        return fromArray(r4).concatMapEagerDelayError(Functions.identity(), r2, r3, false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatArrayEagerDelayError(ObservableSource<? extends T>... r2) {
        return concatArrayEagerDelayError(bufferSize(), bufferSize(), r2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatArrayEagerDelayError(int r2, int r3, ObservableSource<? extends T>... r4) {
        return fromArray(r4).concatMapEagerDelayError(Functions.identity(), r2, r3, true);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatDelayError(Iterable<? extends ObservableSource<? extends T>> r1) {
        ObjectHelper.requireNonNull(r1, "sources is null");
        return concatDelayError(fromIterable(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatDelayError(ObservableSource<? extends ObservableSource<? extends T>> r2) {
        return concatDelayError(r2, bufferSize(), true);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatDelayError(ObservableSource<? extends ObservableSource<? extends T>> r2, int r3, boolean r4) {
        ObjectHelper.requireNonNull(r2, "sources is null");
        ObjectHelper.verifyPositive(r3, "prefetch is null");
        Function r1 = Functions.identity();
        if (r4 == false) goto L5;
        ErrorMode r5 = ErrorMode.END;
    L7:
        return RxJavaPlugins.onAssembly(new ObservableConcatMap(r2, r1, r3, r5));
    L5:
        r5 = ErrorMode.BOUNDARY;
        goto L7
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatEager(ObservableSource<? extends ObservableSource<? extends T>> r2) {
        return concatEager(r2, bufferSize(), bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatEager(ObservableSource<? extends ObservableSource<? extends T>> r1, int r2, int r3) {
        return wrap(r1).concatMapEager(Functions.identity(), r2, r3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatEager(Iterable<? extends ObservableSource<? extends T>> r2) {
        return concatEager(r2, bufferSize(), bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatEager(Iterable<? extends ObservableSource<? extends T>> r2, int r3, int r4) {
        return fromIterable(r2).concatMapEagerDelayError(Functions.identity(), r3, r4, false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> create(ObservableOnSubscribe<T> r1) {
        ObjectHelper.requireNonNull(r1, "source is null");
        return RxJavaPlugins.onAssembly(new ObservableCreate(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> defer(Callable<? extends ObservableSource<? extends T>> r1) {
        ObjectHelper.requireNonNull(r1, "supplier is null");
        return RxJavaPlugins.onAssembly(new ObservableDefer(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> empty() {
        return RxJavaPlugins.onAssembly(ObservableEmpty.INSTANCE);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> error(Callable<? extends Throwable> r1) {
        ObjectHelper.requireNonNull(r1, "errorSupplier is null");
        return RxJavaPlugins.onAssembly(new ObservableError(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> error(Throwable r1) {
        ObjectHelper.requireNonNull(r1, "exception is null");
        return error(Functions.justCallable(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> fromArray(T... r2) {
        ObjectHelper.requireNonNull(r2, "items is null");
        if (r2.length != 0) goto L7;
        return empty();
    L7:
        if (r2.length != 1) goto L11;
        return just(r2[0]);
    L11:
        return RxJavaPlugins.onAssembly(new ObservableFromArray(r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> fromCallable(Callable<? extends T> r1) {
        ObjectHelper.requireNonNull(r1, "supplier is null");
        return RxJavaPlugins.onAssembly(new ObservableFromCallable(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> fromFuture(Future<? extends T> r4) {
        ObjectHelper.requireNonNull(r4, "future is null");
        return RxJavaPlugins.onAssembly(new ObservableFromFuture(r4, 0, null));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> fromFuture(Future<? extends T> r1, long r2, TimeUnit r4) {
        ObjectHelper.requireNonNull(r1, "future is null");
        ObjectHelper.requireNonNull(r4, "unit is null");
        return RxJavaPlugins.onAssembly(new ObservableFromFuture(r1, r2, r4));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static <T> Observable<T> fromFuture(Future<? extends T> r1, long r2, TimeUnit r4, Scheduler r5) {
        ObjectHelper.requireNonNull(r5, "scheduler is null");
        return fromFuture(r1, r2, r4).subscribeOn(r5);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static <T> Observable<T> fromFuture(Future<? extends T> r1, Scheduler r2) {
        ObjectHelper.requireNonNull(r2, "scheduler is null");
        return fromFuture(r1).subscribeOn(r2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> fromIterable(Iterable<? extends T> r1) {
        ObjectHelper.requireNonNull(r1, "source is null");
        return RxJavaPlugins.onAssembly(new ObservableFromIterable(r1));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static <T> Observable<T> fromPublisher(Publisher<? extends T> r1) {
        ObjectHelper.requireNonNull(r1, "publisher is null");
        return RxJavaPlugins.onAssembly(new ObservableFromPublisher(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> generate(Consumer<Emitter<T>> r2) {
        ObjectHelper.requireNonNull(r2, "generator is null");
        return generate(Functions.nullSupplier(), ObservableInternalHelper.simpleGenerator(r2), Functions.emptyConsumer());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, S> Observable<T> generate(Callable<S> r1, BiConsumer<S, Emitter<T>> r2) {
        ObjectHelper.requireNonNull(r2, "generator is null");
        return generate(r1, ObservableInternalHelper.simpleBiGenerator(r2), Functions.emptyConsumer());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, S> Observable<T> generate(Callable<S> r1, BiConsumer<S, Emitter<T>> r2, Consumer<? super S> r3) {
        ObjectHelper.requireNonNull(r2, "generator is null");
        return generate(r1, ObservableInternalHelper.simpleBiGenerator(r2), r3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, S> Observable<T> generate(Callable<S> r1, BiFunction<S, Emitter<T>, S> r2) {
        return generate(r1, r2, Functions.emptyConsumer());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, S> Observable<T> generate(Callable<S> r1, BiFunction<S, Emitter<T>, S> r2, Consumer<? super S> r3) {
        ObjectHelper.requireNonNull(r1, "initialState is null");
        ObjectHelper.requireNonNull(r2, "generator is null");
        ObjectHelper.requireNonNull(r3, "disposeState is null");
        return RxJavaPlugins.onAssembly(new ObservableGenerate(r1, r2, r3));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static Observable<Long> interval(long r6, long r8, TimeUnit r10) {
        return interval(r6, r8, r10, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static Observable<Long> interval(long r8, long r10, TimeUnit r12, Scheduler r13) {
        ObjectHelper.requireNonNull(r12, "unit is null");
        ObjectHelper.requireNonNull(r13, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableInterval(Math.max(0, r8), Math.max(0, r10), r12, r13));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static Observable<Long> interval(long r6, TimeUnit r8) {
        return interval(r6, r6, r8, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static Observable<Long> interval(long r6, TimeUnit r8, Scheduler r9) {
        return interval(r6, r6, r8, r9);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static Observable<Long> intervalRange(long r10, long r12, long r14, long r16, TimeUnit r18) {
        return intervalRange(r10, r12, r14, r16, r18, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static Observable<Long> intervalRange(long r16, long r18, long r20, long r22, TimeUnit r24, Scheduler r25) {
        if (r18 < 0) goto L17;
        if (r18 == 0) goto L6;
        long r6 = r16 + (r18 - 1);
        if (r16 > 0) goto L10;
    L14:
        ObjectHelper.requireNonNull(r24, "unit is null");
        ObjectHelper.requireNonNull(r25, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableIntervalRange(r16, r6, Math.max(0, r20), Math.max(0, r22), r24, r25));
    L10:
        if (r6 >= 0) goto L14;
        throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
    L6:
        return empty().delay(r20, r24, r25);
    L17:
        throw new IllegalArgumentException("count >= 0 required but it was " + r18);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T r1) {
        ObjectHelper.requireNonNull(r1, "item is null");
        return RxJavaPlugins.onAssembly(new ObservableJust(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T r2, T r3) {
        ObjectHelper.requireNonNull(r2, "item1 is null");
        ObjectHelper.requireNonNull(r3, "item2 is null");
        return fromArray(new Object[]{r2, r3});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T r2, T r3, T r4) {
        ObjectHelper.requireNonNull(r2, "item1 is null");
        ObjectHelper.requireNonNull(r3, "item2 is null");
        ObjectHelper.requireNonNull(r4, "item3 is null");
        return fromArray(new Object[]{r2, r3, r4});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T r2, T r3, T r4, T r5) {
        ObjectHelper.requireNonNull(r2, "item1 is null");
        ObjectHelper.requireNonNull(r3, "item2 is null");
        ObjectHelper.requireNonNull(r4, "item3 is null");
        ObjectHelper.requireNonNull(r5, "item4 is null");
        return fromArray(new Object[]{r2, r3, r4, r5});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T r2, T r3, T r4, T r5, T r6) {
        ObjectHelper.requireNonNull(r2, "item1 is null");
        ObjectHelper.requireNonNull(r3, "item2 is null");
        ObjectHelper.requireNonNull(r4, "item3 is null");
        ObjectHelper.requireNonNull(r5, "item4 is null");
        ObjectHelper.requireNonNull(r6, "item5 is null");
        return fromArray(new Object[]{r2, r3, r4, r5, r6});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T r2, T r3, T r4, T r5, T r6, T r7) {
        ObjectHelper.requireNonNull(r2, "item1 is null");
        ObjectHelper.requireNonNull(r3, "item2 is null");
        ObjectHelper.requireNonNull(r4, "item3 is null");
        ObjectHelper.requireNonNull(r5, "item4 is null");
        ObjectHelper.requireNonNull(r6, "item5 is null");
        ObjectHelper.requireNonNull(r7, "item6 is null");
        return fromArray(new Object[]{r2, r3, r4, r5, r6, r7});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T r2, T r3, T r4, T r5, T r6, T r7, T r8) {
        ObjectHelper.requireNonNull(r2, "item1 is null");
        ObjectHelper.requireNonNull(r3, "item2 is null");
        ObjectHelper.requireNonNull(r4, "item3 is null");
        ObjectHelper.requireNonNull(r5, "item4 is null");
        ObjectHelper.requireNonNull(r6, "item5 is null");
        ObjectHelper.requireNonNull(r7, "item6 is null");
        ObjectHelper.requireNonNull(r8, "item7 is null");
        return fromArray(new Object[]{r2, r3, r4, r5, r6, r7, r8});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T r2, T r3, T r4, T r5, T r6, T r7, T r8, T r9) {
        ObjectHelper.requireNonNull(r2, "item1 is null");
        ObjectHelper.requireNonNull(r3, "item2 is null");
        ObjectHelper.requireNonNull(r4, "item3 is null");
        ObjectHelper.requireNonNull(r5, "item4 is null");
        ObjectHelper.requireNonNull(r6, "item5 is null");
        ObjectHelper.requireNonNull(r7, "item6 is null");
        ObjectHelper.requireNonNull(r8, "item7 is null");
        ObjectHelper.requireNonNull(r9, "item8 is null");
        return fromArray(new Object[]{r2, r3, r4, r5, r6, r7, r8, r9});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T r2, T r3, T r4, T r5, T r6, T r7, T r8, T r9, T r10) {
        ObjectHelper.requireNonNull(r2, "item1 is null");
        ObjectHelper.requireNonNull(r3, "item2 is null");
        ObjectHelper.requireNonNull(r4, "item3 is null");
        ObjectHelper.requireNonNull(r5, "item4 is null");
        ObjectHelper.requireNonNull(r6, "item5 is null");
        ObjectHelper.requireNonNull(r7, "item6 is null");
        ObjectHelper.requireNonNull(r8, "item7 is null");
        ObjectHelper.requireNonNull(r9, "item8 is null");
        ObjectHelper.requireNonNull(r10, "item9 is null");
        return fromArray(new Object[]{r2, r3, r4, r5, r6, r7, r8, r9, r10});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T r2, T r3, T r4, T r5, T r6, T r7, T r8, T r9, T r10, T r11) {
        ObjectHelper.requireNonNull(r2, "item1 is null");
        ObjectHelper.requireNonNull(r3, "item2 is null");
        ObjectHelper.requireNonNull(r4, "item3 is null");
        ObjectHelper.requireNonNull(r5, "item4 is null");
        ObjectHelper.requireNonNull(r6, "item5 is null");
        ObjectHelper.requireNonNull(r7, "item6 is null");
        ObjectHelper.requireNonNull(r8, "item7 is null");
        ObjectHelper.requireNonNull(r9, "item8 is null");
        ObjectHelper.requireNonNull(r10, "item9 is null");
        ObjectHelper.requireNonNull(r11, "item10 is null");
        return fromArray(new Object[]{r2, r3, r4, r5, r6, r7, r8, r9, r10, r11});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> r2, int r3, int r4) {
        return fromIterable(r2).flatMap(Functions.identity(), false, r3, r4);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeArray(int r2, int r3, ObservableSource<? extends T>... r4) {
        return fromArray(r4).flatMap(Functions.identity(), false, r2, r3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> r1) {
        return fromIterable(r1).flatMap(Functions.identity());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> r1, int r2) {
        return fromIterable(r1).flatMap(Functions.identity(), r2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> merge(ObservableSource<? extends ObservableSource<? extends T>> r7) {
        ObjectHelper.requireNonNull(r7, "sources is null");
        return RxJavaPlugins.onAssembly(new ObservableFlatMap(r7, Functions.identity(), false, Integer.MAX_VALUE, bufferSize()));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> merge(ObservableSource<? extends ObservableSource<? extends T>> r7, int r8) {
        ObjectHelper.requireNonNull(r7, "sources is null");
        ObjectHelper.verifyPositive(r8, "maxConcurrency");
        return RxJavaPlugins.onAssembly(new ObservableFlatMap(r7, Functions.identity(), false, r8, bufferSize()));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> merge(ObservableSource<? extends T> r3, ObservableSource<? extends T> r4) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        return fromArray(new ObservableSource[]{r3, r4}).flatMap(Functions.identity(), false, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> merge(ObservableSource<? extends T> r3, ObservableSource<? extends T> r4, ObservableSource<? extends T> r5) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        return fromArray(new ObservableSource[]{r3, r4, r5}).flatMap(Functions.identity(), false, 3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> merge(ObservableSource<? extends T> r3, ObservableSource<? extends T> r4, ObservableSource<? extends T> r5, ObservableSource<? extends T> r6) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        ObjectHelper.requireNonNull(r6, "source4 is null");
        return fromArray(new ObservableSource[]{r3, r4, r5, r6}).flatMap(Functions.identity(), false, 4);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeArray(ObservableSource<? extends T>... r2) {
        return fromArray(r2).flatMap(Functions.identity(), r2.length);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> r2) {
        return fromIterable(r2).flatMap(Functions.identity(), true);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> r2, int r3, int r4) {
        return fromIterable(r2).flatMap(Functions.identity(), true, r3, r4);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeArrayDelayError(int r2, int r3, ObservableSource<? extends T>... r4) {
        return fromArray(r4).flatMap(Functions.identity(), true, r2, r3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> r2, int r3) {
        return fromIterable(r2).flatMap(Functions.identity(), true, r3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends ObservableSource<? extends T>> r7) {
        ObjectHelper.requireNonNull(r7, "sources is null");
        return RxJavaPlugins.onAssembly(new ObservableFlatMap(r7, Functions.identity(), true, Integer.MAX_VALUE, bufferSize()));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends ObservableSource<? extends T>> r7, int r8) {
        ObjectHelper.requireNonNull(r7, "sources is null");
        ObjectHelper.verifyPositive(r8, "maxConcurrency");
        return RxJavaPlugins.onAssembly(new ObservableFlatMap(r7, Functions.identity(), true, r8, bufferSize()));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> r3, ObservableSource<? extends T> r4) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        return fromArray(new ObservableSource[]{r3, r4}).flatMap(Functions.identity(), true, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> r3, ObservableSource<? extends T> r4, ObservableSource<? extends T> r5) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        return fromArray(new ObservableSource[]{r3, r4, r5}).flatMap(Functions.identity(), true, 3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> r3, ObservableSource<? extends T> r4, ObservableSource<? extends T> r5, ObservableSource<? extends T> r6) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        ObjectHelper.requireNonNull(r6, "source4 is null");
        return fromArray(new ObservableSource[]{r3, r4, r5, r6}).flatMap(Functions.identity(), true, 4);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeArrayDelayError(ObservableSource<? extends T>... r3) {
        return fromArray(r3).flatMap(Functions.identity(), true, r3.length);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> never() {
        return RxJavaPlugins.onAssembly(ObservableNever.INSTANCE);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable<Integer> range(int r4, int r5) {
        if (r5 < 0) goto L17;
        if (r5 != 0) goto L7;
        return empty();
    L7:
        if (r5 != 1) goto L11;
        return just(Integer.valueOf(r4));
    L11:
        if ((((long) r4) + ((long) (r5 - 1))) > 2147483647L) goto L15;
        return RxJavaPlugins.onAssembly(new ObservableRange(r4, r5));
    L15:
        throw new IllegalArgumentException("Integer overflow");
    L17:
        throw new IllegalArgumentException("count >= 0 required but it was " + r5);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable<Long> rangeLong(long r5, long r7) {
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
        return RxJavaPlugins.onAssembly(new ObservableRangeLong(r5, r7));
    L10:
        return just(Long.valueOf(r5));
    L21:
        throw new IllegalArgumentException("count >= 0 required but it was " + r7);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> r2, ObservableSource<? extends T> r3) {
        return sequenceEqual(r2, r3, ObjectHelper.equalsPredicate(), bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> r1, ObservableSource<? extends T> r2, BiPredicate<? super T, ? super T> r3) {
        return sequenceEqual(r1, r2, r3, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> r1, ObservableSource<? extends T> r2, BiPredicate<? super T, ? super T> r3, int r4) {
        ObjectHelper.requireNonNull(r1, "source1 is null");
        ObjectHelper.requireNonNull(r2, "source2 is null");
        ObjectHelper.requireNonNull(r3, "isEqual is null");
        ObjectHelper.verifyPositive(r4, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableSequenceEqualSingle(r1, r2, r3, r4));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> r1, ObservableSource<? extends T> r2, int r3) {
        return sequenceEqual(r1, r2, ObjectHelper.equalsPredicate(), r3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> switchOnNext(ObservableSource<? extends ObservableSource<? extends T>> r3, int r4) {
        ObjectHelper.requireNonNull(r3, "sources is null");
        ObjectHelper.verifyPositive(r4, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableSwitchMap(r3, Functions.identity(), r4, false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> switchOnNext(ObservableSource<? extends ObservableSource<? extends T>> r1) {
        return switchOnNext(r1, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> switchOnNextDelayError(ObservableSource<? extends ObservableSource<? extends T>> r1) {
        return switchOnNextDelayError(r1, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> switchOnNextDelayError(ObservableSource<? extends ObservableSource<? extends T>> r3, int r4) {
        ObjectHelper.requireNonNull(r3, "sources is null");
        ObjectHelper.verifyPositive(r4, "prefetch");
        return RxJavaPlugins.onAssembly(new ObservableSwitchMap(r3, Functions.identity(), r4, true));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static Observable<Long> timer(long r1, TimeUnit r3) {
        return timer(r1, r3, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static Observable<Long> timer(long r3, TimeUnit r5, Scheduler r6) {
        ObjectHelper.requireNonNull(r5, "unit is null");
        ObjectHelper.requireNonNull(r6, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableTimer(Math.max(r3, 0), r5, r6));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> unsafeCreate(ObservableSource<T> r1) {
        ObjectHelper.requireNonNull(r1, "onSubscribe is null");
        if ((r1 instanceof Observable) == true) goto L7;
        return RxJavaPlugins.onAssembly(new ObservableFromUnsafeSource(r1));
    L7:
        throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, D> Observable<T> using(Callable<? extends D> r1, Function<? super D, ? extends ObservableSource<? extends T>> r2, Consumer<? super D> r3) {
        return using(r1, r2, r3, true);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, D> Observable<T> using(Callable<? extends D> r1, Function<? super D, ? extends ObservableSource<? extends T>> r2, Consumer<? super D> r3, boolean r4) {
        ObjectHelper.requireNonNull(r1, "resourceSupplier is null");
        ObjectHelper.requireNonNull(r2, "sourceSupplier is null");
        ObjectHelper.requireNonNull(r3, "disposer is null");
        return RxJavaPlugins.onAssembly(new ObservableUsing(r1, r2, r3, r4));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> wrap(ObservableSource<T> r1) {
        ObjectHelper.requireNonNull(r1, "source is null");
        if ((r1 instanceof Observable) == false) goto L7;
        return RxJavaPlugins.onAssembly((Observable) r1);
    L7:
        return RxJavaPlugins.onAssembly(new ObservableFromUnsafeSource(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> zip(Iterable<? extends ObservableSource<? extends T>> r7, Function<? super Object[], ? extends R> r8) {
        ObjectHelper.requireNonNull(r8, "zipper is null");
        ObjectHelper.requireNonNull(r7, "sources is null");
        return RxJavaPlugins.onAssembly(new ObservableZip(null, r7, r8, bufferSize(), false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> zip(ObservableSource<? extends ObservableSource<? extends T>> r2, Function<? super Object[], ? extends R> r3) {
        ObjectHelper.requireNonNull(r3, "zipper is null");
        ObjectHelper.requireNonNull(r2, "sources is null");
        return RxJavaPlugins.onAssembly(new ObservableToList(r2, 16).flatMap(ObservableInternalHelper.zipIterable(r3)));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> r3, ObservableSource<? extends T2> r4, BiFunction<? super T1, ? super T2, ? extends R> r5) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        return zipArray(Functions.toFunction(r5), false, bufferSize(), new ObservableSource[]{r3, r4});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> r3, ObservableSource<? extends T2> r4, BiFunction<? super T1, ? super T2, ? extends R> r5, boolean r6) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        return zipArray(Functions.toFunction(r5), r6, bufferSize(), new ObservableSource[]{r3, r4});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> r2, ObservableSource<? extends T2> r3, BiFunction<? super T1, ? super T2, ? extends R> r4, boolean r5, int r6) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        return zipArray(Functions.toFunction(r4), r5, r6, new ObservableSource[]{r2, r3});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, R> Observable<R> zip(ObservableSource<? extends T1> r3, ObservableSource<? extends T2> r4, ObservableSource<? extends T3> r5, Function3<? super T1, ? super T2, ? super T3, ? extends R> r6) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        return zipArray(Functions.toFunction(r6), false, bufferSize(), new ObservableSource[]{r3, r4, r5});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, R> Observable<R> zip(ObservableSource<? extends T1> r3, ObservableSource<? extends T2> r4, ObservableSource<? extends T3> r5, ObservableSource<? extends T4> r6, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> r7) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        ObjectHelper.requireNonNull(r6, "source4 is null");
        return zipArray(Functions.toFunction(r7), false, bufferSize(), new ObservableSource[]{r3, r4, r5, r6});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, R> Observable<R> zip(ObservableSource<? extends T1> r3, ObservableSource<? extends T2> r4, ObservableSource<? extends T3> r5, ObservableSource<? extends T4> r6, ObservableSource<? extends T5> r7, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> r8) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        ObjectHelper.requireNonNull(r6, "source4 is null");
        ObjectHelper.requireNonNull(r7, "source5 is null");
        return zipArray(Functions.toFunction(r8), false, bufferSize(), new ObservableSource[]{r3, r4, r5, r6, r7});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> zip(ObservableSource<? extends T1> r3, ObservableSource<? extends T2> r4, ObservableSource<? extends T3> r5, ObservableSource<? extends T4> r6, ObservableSource<? extends T5> r7, ObservableSource<? extends T6> r8, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> r9) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        ObjectHelper.requireNonNull(r6, "source4 is null");
        ObjectHelper.requireNonNull(r7, "source5 is null");
        ObjectHelper.requireNonNull(r8, "source6 is null");
        return zipArray(Functions.toFunction(r9), false, bufferSize(), new ObservableSource[]{r3, r4, r5, r6, r7, r8});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> zip(ObservableSource<? extends T1> r3, ObservableSource<? extends T2> r4, ObservableSource<? extends T3> r5, ObservableSource<? extends T4> r6, ObservableSource<? extends T5> r7, ObservableSource<? extends T6> r8, ObservableSource<? extends T7> r9, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> r10) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        ObjectHelper.requireNonNull(r6, "source4 is null");
        ObjectHelper.requireNonNull(r7, "source5 is null");
        ObjectHelper.requireNonNull(r8, "source6 is null");
        ObjectHelper.requireNonNull(r9, "source7 is null");
        return zipArray(Functions.toFunction(r10), false, bufferSize(), new ObservableSource[]{r3, r4, r5, r6, r7, r8, r9});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> zip(ObservableSource<? extends T1> r3, ObservableSource<? extends T2> r4, ObservableSource<? extends T3> r5, ObservableSource<? extends T4> r6, ObservableSource<? extends T5> r7, ObservableSource<? extends T6> r8, ObservableSource<? extends T7> r9, ObservableSource<? extends T8> r10, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> r11) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        ObjectHelper.requireNonNull(r6, "source4 is null");
        ObjectHelper.requireNonNull(r7, "source5 is null");
        ObjectHelper.requireNonNull(r8, "source6 is null");
        ObjectHelper.requireNonNull(r9, "source7 is null");
        ObjectHelper.requireNonNull(r10, "source8 is null");
        return zipArray(Functions.toFunction(r11), false, bufferSize(), new ObservableSource[]{r3, r4, r5, r6, r7, r8, r9, r10});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> zip(ObservableSource<? extends T1> r3, ObservableSource<? extends T2> r4, ObservableSource<? extends T3> r5, ObservableSource<? extends T4> r6, ObservableSource<? extends T5> r7, ObservableSource<? extends T6> r8, ObservableSource<? extends T7> r9, ObservableSource<? extends T8> r10, ObservableSource<? extends T9> r11, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> r12) {
        ObjectHelper.requireNonNull(r3, "source1 is null");
        ObjectHelper.requireNonNull(r4, "source2 is null");
        ObjectHelper.requireNonNull(r5, "source3 is null");
        ObjectHelper.requireNonNull(r6, "source4 is null");
        ObjectHelper.requireNonNull(r7, "source5 is null");
        ObjectHelper.requireNonNull(r8, "source6 is null");
        ObjectHelper.requireNonNull(r9, "source7 is null");
        ObjectHelper.requireNonNull(r10, "source8 is null");
        ObjectHelper.requireNonNull(r11, "source9 is null");
        return zipArray(Functions.toFunction(r12), false, bufferSize(), new ObservableSource[]{r3, r4, r5, r6, r7, r8, r9, r10, r11});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> zipArray(Function<? super Object[], ? extends R> r7, boolean r8, int r9, ObservableSource<? extends T>... r10) {
        if (r10.length == 0) goto L5;
        ObjectHelper.requireNonNull(r7, "zipper is null");
        ObjectHelper.verifyPositive(r9, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableZip(r10, null, r7, r9, r8));
    L5:
        return empty();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> zipIterable(Iterable<? extends ObservableSource<? extends T>> r7, Function<? super Object[], ? extends R> r8, boolean r9, int r10) {
        ObjectHelper.requireNonNull(r8, "zipper is null");
        ObjectHelper.requireNonNull(r7, "sources is null");
        ObjectHelper.verifyPositive(r10, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableZip(null, r7, r8, r10, r9));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<Boolean> all(Predicate<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "predicate is null");
        return RxJavaPlugins.onAssembly(new ObservableAllSingle(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> ambWith(ObservableSource<? extends T> r3) {
        ObjectHelper.requireNonNull(r3, "other is null");
        return ambArray(new ObservableSource[]{this, r3});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<Boolean> any(Predicate<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "predicate is null");
        return RxJavaPlugins.onAssembly(new ObservableAnySingle(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> R as(ObservableConverter<T, ? extends R> r2) {
        return (R) ((ObservableConverter) ObjectHelper.requireNonNull(r2, "converter is null")).apply(this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingFirst() {
        BlockingFirstObserver r0 = new BlockingFirstObserver();
        subscribe(r0);
        T r1 = r0.blockingGet();
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new NoSuchElementException();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingFirst(T r2) {
        BlockingFirstObserver r0 = new BlockingFirstObserver();
        subscribe(r0);
        T r1 = r0.blockingGet();
        if (r1 != null) goto L5;
        return r2;
    L5:
        return r1;
    }

    @SchedulerSupport("none")
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

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Iterable<T> blockingIterable() {
        return blockingIterable(bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Iterable<T> blockingIterable(int r2) {
        ObjectHelper.verifyPositive(r2, "bufferSize");
        return new BlockingObservableIterable(this, r2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingLast() {
        BlockingLastObserver r0 = new BlockingLastObserver();
        subscribe(r0);
        T r1 = r0.blockingGet();
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new NoSuchElementException();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingLast(T r2) {
        BlockingLastObserver r0 = new BlockingLastObserver();
        subscribe(r0);
        T r1 = r0.blockingGet();
        if (r1 != null) goto L5;
        return r2;
    L5:
        return r1;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Iterable<T> blockingLatest() {
        return new BlockingObservableLatest(this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Iterable<T> blockingMostRecent(T r2) {
        return new BlockingObservableMostRecent(this, r2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Iterable<T> blockingNext() {
        return new BlockingObservableNext(this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingSingle() {
        T r0 = singleElement().blockingGet();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NoSuchElementException();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingSingle(T r1) {
        return single(r1).blockingGet();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Future<T> toFuture() {
        return (Future) subscribeWith(new FutureObserver());
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe() {
        ObservableBlockingSubscribe.subscribe(this);
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> r3) {
        ObservableBlockingSubscribe.subscribe(this, r3, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> r2, Consumer<? super Throwable> r3) {
        ObservableBlockingSubscribe.subscribe(this, r2, r3, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> r1, Consumer<? super Throwable> r2, Action r3) {
        ObservableBlockingSubscribe.subscribe(this, r1, r2, r3);
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Observer<? super T> r1) {
        ObservableBlockingSubscribe.subscribe(this, r1);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<List<T>> buffer(int r1) {
        return buffer(r1, r1);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<List<T>> buffer(int r2, int r3) {
        return (Observable<List<T>>) buffer(r2, r3, ArrayListSupplier.asCallable());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U extends Collection<? super T>> Observable<U> buffer(int r2, int r3, Callable<U> r4) {
        ObjectHelper.verifyPositive(r2, "count");
        ObjectHelper.verifyPositive(r3, "skip");
        ObjectHelper.requireNonNull(r4, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new ObservableBuffer(this, r2, r3, r4));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U extends Collection<? super T>> Observable<U> buffer(int r1, Callable<U> r2) {
        return buffer(r1, r1, r2);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<List<T>> buffer(long r9, long r11, TimeUnit r13) {
        return (Observable<List<T>>) buffer(r9, r11, r13, Schedulers.computation(), ArrayListSupplier.asCallable());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<List<T>> buffer(long r9, long r11, TimeUnit r13, Scheduler r14) {
        return (Observable<List<T>>) buffer(r9, r11, r13, r14, ArrayListSupplier.asCallable());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final <U extends Collection<? super T>> Observable<U> buffer(long r13, long r15, TimeUnit r17, Scheduler r18, Callable<U> r19) {
        ObjectHelper.requireNonNull(r17, "unit is null");
        ObjectHelper.requireNonNull(r18, "scheduler is null");
        ObjectHelper.requireNonNull(r19, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new ObservableBufferTimed(this, r13, r15, r17, r18, r19, Integer.MAX_VALUE, false));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<List<T>> buffer(long r7, TimeUnit r9) {
        return buffer(r7, r9, Schedulers.computation(), Integer.MAX_VALUE);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<List<T>> buffer(long r7, TimeUnit r9, int r10) {
        return buffer(r7, r9, Schedulers.computation(), r10);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<List<T>> buffer(long r9, TimeUnit r11, Scheduler r12, int r13) {
        return (Observable<List<T>>) buffer(r9, r11, r12, r13, ArrayListSupplier.asCallable(), false);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final <U extends Collection<? super T>> Observable<U> buffer(long r13, TimeUnit r15, Scheduler r16, int r17, Callable<U> r18, boolean r19) {
        ObjectHelper.requireNonNull(r15, "unit is null");
        ObjectHelper.requireNonNull(r16, "scheduler is null");
        ObjectHelper.requireNonNull(r18, "bufferSupplier is null");
        ObjectHelper.verifyPositive(r17, "count");
        return RxJavaPlugins.onAssembly(new ObservableBufferTimed(this, r13, r13, r15, r16, r18, r17, r19));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<List<T>> buffer(long r9, TimeUnit r11, Scheduler r12) {
        return (Observable<List<T>>) buffer(r9, r11, r12, Integer.MAX_VALUE, ArrayListSupplier.asCallable(), false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <TOpening, TClosing> Observable<List<T>> buffer(ObservableSource<? extends TOpening> r2, Function<? super TOpening, ? extends ObservableSource<? extends TClosing>> r3) {
        return (Observable<List<T>>) buffer(r2, r3, ArrayListSupplier.asCallable());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <TOpening, TClosing, U extends Collection<? super T>> Observable<U> buffer(ObservableSource<? extends TOpening> r2, Function<? super TOpening, ? extends ObservableSource<? extends TClosing>> r3, Callable<U> r4) {
        ObjectHelper.requireNonNull(r2, "openingIndicator is null");
        ObjectHelper.requireNonNull(r3, "closingIndicator is null");
        ObjectHelper.requireNonNull(r4, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new ObservableBufferBoundary(this, r2, r3, r4));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> Observable<List<T>> buffer(ObservableSource<B> r2) {
        return (Observable<List<T>>) buffer(r2, ArrayListSupplier.asCallable());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> Observable<List<T>> buffer(ObservableSource<B> r2, int r3) {
        ObjectHelper.verifyPositive(r3, "initialCapacity");
        return (Observable<List<T>>) buffer(r2, Functions.createArrayList(r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B, U extends Collection<? super T>> Observable<U> buffer(ObservableSource<B> r2, Callable<U> r3) {
        ObjectHelper.requireNonNull(r2, "boundary is null");
        ObjectHelper.requireNonNull(r3, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new ObservableBufferExactBoundary(this, r2, r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> Observable<List<T>> buffer(Callable<? extends ObservableSource<B>> r2) {
        return (Observable<List<T>>) buffer(r2, ArrayListSupplier.asCallable());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B, U extends Collection<? super T>> Observable<U> buffer(Callable<? extends ObservableSource<B>> r2, Callable<U> r3) {
        ObjectHelper.requireNonNull(r2, "boundarySupplier is null");
        ObjectHelper.requireNonNull(r3, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new ObservableBufferBoundarySupplier(this, r2, r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> cache() {
        return cacheWithInitialCapacity(16);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> cacheWithInitialCapacity(int r2) {
        ObjectHelper.verifyPositive(r2, "initialCapacity");
        return RxJavaPlugins.onAssembly(new ObservableCache(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<U> cast(Class<U> r2) {
        ObjectHelper.requireNonNull(r2, "clazz is null");
        return (Observable<U>) map(Functions.castFunction(r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Single<U> collect(Callable<? extends U> r2, BiConsumer<? super U, ? super T> r3) {
        ObjectHelper.requireNonNull(r2, "initialValueSupplier is null");
        ObjectHelper.requireNonNull(r3, "collector is null");
        return RxJavaPlugins.onAssembly(new ObservableCollectSingle(this, r2, r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Single<U> collectInto(U r2, BiConsumer<? super U, ? super T> r3) {
        ObjectHelper.requireNonNull(r2, "initialValue is null");
        return collect(Functions.justCallable(r2), r3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> compose(ObservableTransformer<? super T, ? extends R> r2) {
        return wrap(((ObservableTransformer) ObjectHelper.requireNonNull(r2, "composer is null")).apply(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> r2) {
        return concatMap(r2, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> r3, int r4) {
        ObjectHelper.requireNonNull(r3, "mapper is null");
        ObjectHelper.verifyPositive(r4, "prefetch");
        if ((this instanceof ScalarCallable) == false) goto L11;
        Object r2 = ((ScalarCallable) this).call();
        if (r2 != null) goto L9;
        return empty();
    L9:
        return ObservableScalarXMap.scalarXMap(r2, r3);
    L11:
        return RxJavaPlugins.onAssembly(new ObservableConcatMap(this, r3, r4, ErrorMode.IMMEDIATE));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> r3) {
        return concatMapDelayError(r3, bufferSize(), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> r2, int r3, boolean r4) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        ObjectHelper.verifyPositive(r3, "prefetch");
        if ((this instanceof ScalarCallable) == false) goto L11;
        Object r1 = ((ScalarCallable) this).call();
        if (r1 != null) goto L9;
        return empty();
    L9:
        return ObservableScalarXMap.scalarXMap(r1, r2);
    L11:
        if (r4 == false) goto L13;
        ErrorMode r5 = ErrorMode.END;
    L15:
        return RxJavaPlugins.onAssembly(new ObservableConcatMap(this, r2, r3, r5));
    L13:
        r5 = ErrorMode.BOUNDARY;
        goto L15
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapEager(Function<? super T, ? extends ObservableSource<? extends R>> r3) {
        return concatMapEager(r3, Integer.MAX_VALUE, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapEager(Function<? super T, ? extends ObservableSource<? extends R>> r8, int r9, int r10) {
        ObjectHelper.requireNonNull(r8, "mapper is null");
        ObjectHelper.verifyPositive(r9, "maxConcurrency");
        ObjectHelper.verifyPositive(r10, "prefetch");
        return RxJavaPlugins.onAssembly(new ObservableConcatMapEager(this, r8, ErrorMode.IMMEDIATE, r9, r10));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapEagerDelayError(Function<? super T, ? extends ObservableSource<? extends R>> r3, boolean r4) {
        return concatMapEagerDelayError(r3, Integer.MAX_VALUE, bufferSize(), r4);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapEagerDelayError(Function<? super T, ? extends ObservableSource<? extends R>> r8, int r9, int r10, boolean r11) {
        ObjectHelper.requireNonNull(r8, "mapper is null");
        ObjectHelper.verifyPositive(r9, "maxConcurrency");
        ObjectHelper.verifyPositive(r10, "prefetch");
        if (r11 == false) goto L5;
        ErrorMode r12 = ErrorMode.END;
    L7:
        return RxJavaPlugins.onAssembly(new ObservableConcatMapEager(this, r8, r12, r9, r10));
    L5:
        r12 = ErrorMode.BOUNDARY;
        goto L7
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> r2) {
        return concatMapCompletable(r2, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> r3, int r4) {
        ObjectHelper.requireNonNull(r3, "mapper is null");
        ObjectHelper.verifyPositive(r4, "capacityHint");
        return RxJavaPlugins.onAssembly(new ObservableConcatMapCompletable(this, r3, ErrorMode.IMMEDIATE, r4));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> r3) {
        return concatMapCompletableDelayError(r3, true, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> r2, boolean r3) {
        return concatMapCompletableDelayError(r2, r3, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> r2, boolean r3, int r4) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        ObjectHelper.verifyPositive(r4, "prefetch");
        if (r3 == false) goto L5;
        ErrorMode r5 = ErrorMode.END;
    L7:
        return RxJavaPlugins.onAssembly(new ObservableConcatMapCompletable(this, r2, r5, r4));
    L5:
        r5 = ErrorMode.BOUNDARY;
        goto L7
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> r2) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableFlattenIterable(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> r2, int r3) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        ObjectHelper.verifyPositive(r3, "prefetch");
        return (Observable<U>) concatMap(ObservableInternalHelper.flatMapIntoIterable(r2), r3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> r2) {
        return concatMapMaybe(r2, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> r3, int r4) {
        ObjectHelper.requireNonNull(r3, "mapper is null");
        ObjectHelper.verifyPositive(r4, "prefetch");
        return RxJavaPlugins.onAssembly(new ObservableConcatMapMaybe(this, r3, ErrorMode.IMMEDIATE, r4));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> r3) {
        return concatMapMaybeDelayError(r3, true, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> r2, boolean r3) {
        return concatMapMaybeDelayError(r2, r3, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> r2, boolean r3, int r4) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        ObjectHelper.verifyPositive(r4, "prefetch");
        if (r3 == false) goto L5;
        ErrorMode r5 = ErrorMode.END;
    L7:
        return RxJavaPlugins.onAssembly(new ObservableConcatMapMaybe(this, r2, r5, r4));
    L5:
        r5 = ErrorMode.BOUNDARY;
        goto L7
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> r2) {
        return concatMapSingle(r2, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> r3, int r4) {
        ObjectHelper.requireNonNull(r3, "mapper is null");
        ObjectHelper.verifyPositive(r4, "prefetch");
        return RxJavaPlugins.onAssembly(new ObservableConcatMapSingle(this, r3, ErrorMode.IMMEDIATE, r4));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> r3) {
        return concatMapSingleDelayError(r3, true, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> r2, boolean r3) {
        return concatMapSingleDelayError(r2, r3, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> r2, boolean r3, int r4) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        ObjectHelper.verifyPositive(r4, "prefetch");
        if (r3 == false) goto L5;
        ErrorMode r5 = ErrorMode.END;
    L7:
        return RxJavaPlugins.onAssembly(new ObservableConcatMapSingle(this, r2, r5, r4));
    L5:
        r5 = ErrorMode.BOUNDARY;
        goto L7
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> concatWith(ObservableSource<? extends T> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return concat(this, r2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> concatWith(SingleSource<? extends T> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new ObservableConcatWithSingle(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> concatWith(MaybeSource<? extends T> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new ObservableConcatWithMaybe(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> concatWith(CompletableSource r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new ObservableConcatWithCompletable(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<Boolean> contains(Object r2) {
        ObjectHelper.requireNonNull(r2, "element is null");
        return any(Functions.equalsWith(r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<Long> count() {
        return RxJavaPlugins.onAssembly(new ObservableCountSingle(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<T> debounce(Function<? super T, ? extends ObservableSource<U>> r2) {
        ObjectHelper.requireNonNull(r2, "debounceSelector is null");
        return RxJavaPlugins.onAssembly(new ObservableDebounce(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> debounce(long r2, TimeUnit r4) {
        return debounce(r2, r4, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> debounce(long r8, TimeUnit r10, Scheduler r11) {
        ObjectHelper.requireNonNull(r10, "unit is null");
        ObjectHelper.requireNonNull(r11, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableDebounceTimed(this, r8, r10, r11));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> defaultIfEmpty(T r2) {
        ObjectHelper.requireNonNull(r2, "defaultItem is null");
        return switchIfEmpty(just(r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<T> delay(Function<? super T, ? extends ObservableSource<U>> r2) {
        ObjectHelper.requireNonNull(r2, "itemDelay is null");
        return (Observable<T>) flatMap(ObservableInternalHelper.itemDelay(r2));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> delay(long r7, TimeUnit r9) {
        return delay(r7, r9, Schedulers.computation(), false);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> delay(long r7, TimeUnit r9, boolean r10) {
        return delay(r7, r9, Schedulers.computation(), r10);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> delay(long r7, TimeUnit r9, Scheduler r10) {
        return delay(r7, r9, r10, false);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> delay(long r9, TimeUnit r11, Scheduler r12, boolean r13) {
        ObjectHelper.requireNonNull(r11, "unit is null");
        ObjectHelper.requireNonNull(r12, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableDelay(this, r9, r11, r12, r13));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, V> Observable<T> delay(ObservableSource<U> r1, Function<? super T, ? extends ObservableSource<V>> r2) {
        return delaySubscription(r1).delay(r2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<T> delaySubscription(ObservableSource<U> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new ObservableDelaySubscriptionOther(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> delaySubscription(long r2, TimeUnit r4) {
        return delaySubscription(r2, r4, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> delaySubscription(long r1, TimeUnit r3, Scheduler r4) {
        return delaySubscription(timer(r1, r3, r4));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Deprecated
    public final <T2> Observable<T2> dematerialize() {
        return RxJavaPlugins.onAssembly(new ObservableDematerialize(this, Functions.identity()));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> dematerialize(Function<? super T, Notification<R>> r2) {
        ObjectHelper.requireNonNull(r2, "selector is null");
        return RxJavaPlugins.onAssembly(new ObservableDematerialize(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> distinct() {
        return distinct(Functions.identity(), Functions.createHashSet());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> Observable<T> distinct(Function<? super T, K> r2) {
        return distinct(r2, Functions.createHashSet());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> Observable<T> distinct(Function<? super T, K> r2, Callable<? extends Collection<? super K>> r3) {
        ObjectHelper.requireNonNull(r2, "keySelector is null");
        ObjectHelper.requireNonNull(r3, "collectionSupplier is null");
        return RxJavaPlugins.onAssembly(new ObservableDistinct(this, r2, r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> distinctUntilChanged() {
        return distinctUntilChanged(Functions.identity());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> Observable<T> distinctUntilChanged(Function<? super T, K> r3) {
        ObjectHelper.requireNonNull(r3, "keySelector is null");
        return RxJavaPlugins.onAssembly(new ObservableDistinctUntilChanged(this, r3, ObjectHelper.equalsPredicate()));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> distinctUntilChanged(BiPredicate<? super T, ? super T> r3) {
        ObjectHelper.requireNonNull(r3, "comparer is null");
        return RxJavaPlugins.onAssembly(new ObservableDistinctUntilChanged(this, Functions.identity(), r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doAfterNext(Consumer<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "onAfterNext is null");
        return RxJavaPlugins.onAssembly(new ObservableDoAfterNext(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doAfterTerminate(Action r4) {
        ObjectHelper.requireNonNull(r4, "onFinally is null");
        return doOnEach(Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, r4);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doFinally(Action r2) {
        ObjectHelper.requireNonNull(r2, "onFinally is null");
        return RxJavaPlugins.onAssembly(new ObservableDoFinally(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnDispose(Action r2) {
        return doOnLifecycle(Functions.emptyConsumer(), r2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnComplete(Action r4) {
        return doOnEach(Functions.emptyConsumer(), Functions.emptyConsumer(), r4, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    private Observable<T> doOnEach(Consumer<? super T> r8, Consumer<? super Throwable> r9, Action r10, Action r11) {
        ObjectHelper.requireNonNull(r8, "onNext is null");
        ObjectHelper.requireNonNull(r9, "onError is null");
        ObjectHelper.requireNonNull(r10, "onComplete is null");
        ObjectHelper.requireNonNull(r11, "onAfterTerminate is null");
        return RxJavaPlugins.onAssembly(new ObservableDoOnEach(this, r8, r9, r10, r11));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnEach(Consumer<? super Notification<T>> r4) {
        ObjectHelper.requireNonNull(r4, "onNotification is null");
        return doOnEach(Functions.notificationOnNext(r4), Functions.notificationOnError(r4), Functions.notificationOnComplete(r4), Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnEach(Observer<? super T> r4) {
        ObjectHelper.requireNonNull(r4, "observer is null");
        return doOnEach(ObservableInternalHelper.observerOnNext(r4), ObservableInternalHelper.observerOnError(r4), ObservableInternalHelper.observerOnComplete(r4), Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnError(Consumer<? super Throwable> r4) {
        return doOnEach(Functions.emptyConsumer(), r4, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnLifecycle(Consumer<? super Disposable> r2, Action r3) {
        ObjectHelper.requireNonNull(r2, "onSubscribe is null");
        ObjectHelper.requireNonNull(r3, "onDispose is null");
        return RxJavaPlugins.onAssembly(new ObservableDoOnLifecycle(this, r2, r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnNext(Consumer<? super T> r4) {
        return doOnEach(r4, Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnSubscribe(Consumer<? super Disposable> r2) {
        return doOnLifecycle(r2, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnTerminate(Action r4) {
        ObjectHelper.requireNonNull(r4, "onTerminate is null");
        return doOnEach(Functions.emptyConsumer(), Functions.actionConsumer(r4), r4, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe<T> elementAt(long r3) {
        if (r3 < 0) goto L7;
        return RxJavaPlugins.onAssembly(new ObservableElementAtMaybe(this, r3));
    L7:
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + r3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> elementAt(long r3, T r5) {
        if (r3 < 0) goto L7;
        ObjectHelper.requireNonNull(r5, "defaultItem is null");
        return RxJavaPlugins.onAssembly(new ObservableElementAtSingle(this, r3, r5));
    L7:
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + r3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> elementAtOrError(long r3) {
        if (r3 < 0) goto L7;
        return RxJavaPlugins.onAssembly(new ObservableElementAtSingle(this, r3, null));
    L7:
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + r3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> filter(Predicate<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "predicate is null");
        return RxJavaPlugins.onAssembly(new ObservableFilter(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe<T> firstElement() {
        return elementAt(0);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> first(T r3) {
        return elementAt(0, r3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> firstOrError() {
        return elementAtOrError(0);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> r2) {
        return flatMap(r2, false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> r2, boolean r3) {
        return flatMap(r2, r3, Integer.MAX_VALUE);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> r2, boolean r3, int r4) {
        return flatMap(r2, r3, r4, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> r8, boolean r9, int r10, int r11) {
        ObjectHelper.requireNonNull(r8, "mapper is null");
        ObjectHelper.verifyPositive(r10, "maxConcurrency");
        ObjectHelper.verifyPositive(r11, "bufferSize");
        if ((this instanceof ScalarCallable) == false) goto L11;
        Object r7 = ((ScalarCallable) this).call();
        if (r7 != null) goto L9;
        return empty();
    L9:
        return ObservableScalarXMap.scalarXMap(r7, r8);
    L11:
        return RxJavaPlugins.onAssembly(new ObservableFlatMap(this, r8, r9, r10, r11));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> r2, Function<? super Throwable, ? extends ObservableSource<? extends R>> r3, Callable<? extends ObservableSource<? extends R>> r4) {
        ObjectHelper.requireNonNull(r2, "onNextMapper is null");
        ObjectHelper.requireNonNull(r3, "onErrorMapper is null");
        ObjectHelper.requireNonNull(r4, "onCompleteSupplier is null");
        return merge(new ObservableMapNotification(this, r2, r3, r4));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> r2, Function<Throwable, ? extends ObservableSource<? extends R>> r3, Callable<? extends ObservableSource<? extends R>> r4, int r5) {
        ObjectHelper.requireNonNull(r2, "onNextMapper is null");
        ObjectHelper.requireNonNull(r3, "onErrorMapper is null");
        ObjectHelper.requireNonNull(r4, "onCompleteSupplier is null");
        return merge(new ObservableMapNotification(this, r2, r3, r4), r5);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> r3, int r4) {
        return flatMap(r3, false, r4, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> r7, BiFunction<? super T, ? super U, ? extends R> r8) {
        return flatMap(r7, r8, false, bufferSize(), bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> r7, BiFunction<? super T, ? super U, ? extends R> r8, boolean r9) {
        return flatMap(r7, r8, r9, bufferSize(), bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> r7, BiFunction<? super T, ? super U, ? extends R> r8, boolean r9, int r10) {
        return flatMap(r7, r8, r9, r10, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> r2, BiFunction<? super T, ? super U, ? extends R> r3, boolean r4, int r5, int r6) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        ObjectHelper.requireNonNull(r3, "combiner is null");
        return flatMap(ObservableInternalHelper.flatMapWithCombiner(r2, r3), r4, r5, r6);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> r7, BiFunction<? super T, ? super U, ? extends R> r8, int r9) {
        return flatMap(r7, r8, false, r9, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> r2) {
        return flatMapCompletable(r2, false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> r2, boolean r3) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableFlatMapCompletableCompletable(this, r2, r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<U> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> r2) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableFlattenIterable(this, r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, V> Observable<V> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> r8, BiFunction<? super T, ? super U, ? extends V> r9) {
        ObjectHelper.requireNonNull(r8, "mapper is null");
        ObjectHelper.requireNonNull(r9, "resultSelector is null");
        return (Observable<V>) flatMap(ObservableInternalHelper.flatMapIntoIterable(r8), r9, false, bufferSize(), bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> r2) {
        return flatMapMaybe(r2, false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> r2, boolean r3) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableFlatMapMaybe(this, r2, r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> r2) {
        return flatMapSingle(r2, false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> r2, boolean r3) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableFlatMapSingle(this, r2, r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable forEach(Consumer<? super T> r1) {
        return subscribe(r1);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable forEachWhile(Predicate<? super T> r3) {
        return forEachWhile(r3, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable forEachWhile(Predicate<? super T> r2, Consumer<? super Throwable> r3) {
        return forEachWhile(r2, r3, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable forEachWhile(Predicate<? super T> r2, Consumer<? super Throwable> r3, Action r4) {
        ObjectHelper.requireNonNull(r2, "onNext is null");
        ObjectHelper.requireNonNull(r3, "onError is null");
        ObjectHelper.requireNonNull(r4, "onComplete is null");
        ForEachWhileObserver r0 = new ForEachWhileObserver(r2, r3, r4);
        subscribe(r0);
        return r0;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> Observable<GroupedObservable<K, T>> groupBy(Function<? super T, ? extends K> r4) {
        return (Observable<GroupedObservable<K, T>>) groupBy(r4, Functions.identity(), false, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> Observable<GroupedObservable<K, T>> groupBy(Function<? super T, ? extends K> r3, boolean r4) {
        return (Observable<GroupedObservable<K, T>>) groupBy(r3, Functions.identity(), r4, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> r3, Function<? super T, ? extends V> r4) {
        return groupBy(r3, r4, false, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> r2, Function<? super T, ? extends V> r3, boolean r4) {
        return groupBy(r2, r3, r4, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> r8, Function<? super T, ? extends V> r9, boolean r10, int r11) {
        ObjectHelper.requireNonNull(r8, "keySelector is null");
        ObjectHelper.requireNonNull(r9, "valueSelector is null");
        ObjectHelper.verifyPositive(r11, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableGroupBy(this, r8, r9, r11, r10));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <TRight, TLeftEnd, TRightEnd, R> Observable<R> groupJoin(ObservableSource<? extends TRight> r8, Function<? super T, ? extends ObservableSource<TLeftEnd>> r9, Function<? super TRight, ? extends ObservableSource<TRightEnd>> r10, BiFunction<? super T, ? super Observable<TRight>, ? extends R> r11) {
        ObjectHelper.requireNonNull(r8, "other is null");
        ObjectHelper.requireNonNull(r9, "leftEnd is null");
        ObjectHelper.requireNonNull(r10, "rightEnd is null");
        ObjectHelper.requireNonNull(r11, "resultSelector is null");
        return RxJavaPlugins.onAssembly(new ObservableGroupJoin(this, r8, r9, r10, r11));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> hide() {
        return RxJavaPlugins.onAssembly(new ObservableHide(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable ignoreElements() {
        return RxJavaPlugins.onAssembly(new ObservableIgnoreElementsCompletable(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<Boolean> isEmpty() {
        return all(Functions.alwaysFalse());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <TRight, TLeftEnd, TRightEnd, R> Observable<R> join(ObservableSource<? extends TRight> r8, Function<? super T, ? extends ObservableSource<TLeftEnd>> r9, Function<? super TRight, ? extends ObservableSource<TRightEnd>> r10, BiFunction<? super T, ? super TRight, ? extends R> r11) {
        ObjectHelper.requireNonNull(r8, "other is null");
        ObjectHelper.requireNonNull(r9, "leftEnd is null");
        ObjectHelper.requireNonNull(r10, "rightEnd is null");
        ObjectHelper.requireNonNull(r11, "resultSelector is null");
        return RxJavaPlugins.onAssembly(new ObservableJoin(this, r8, r9, r10, r11));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe<T> lastElement() {
        return RxJavaPlugins.onAssembly(new ObservableLastMaybe(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> last(T r2) {
        ObjectHelper.requireNonNull(r2, "defaultItem is null");
        return RxJavaPlugins.onAssembly(new ObservableLastSingle(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> lastOrError() {
        return RxJavaPlugins.onAssembly(new ObservableLastSingle(this, null));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> lift(ObservableOperator<? extends R, ? super T> r2) {
        ObjectHelper.requireNonNull(r2, "lifter is null");
        return RxJavaPlugins.onAssembly(new ObservableLift(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> map(Function<? super T, ? extends R> r2) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableMap(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Notification<T>> materialize() {
        return RxJavaPlugins.onAssembly(new ObservableMaterialize(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> mergeWith(ObservableSource<? extends T> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return merge(this, r2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> mergeWith(SingleSource<? extends T> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new ObservableMergeWithSingle(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> mergeWith(MaybeSource<? extends T> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new ObservableMergeWithMaybe(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> mergeWith(CompletableSource r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new ObservableMergeWithCompletable(this, r2));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> observeOn(Scheduler r3) {
        return observeOn(r3, false, bufferSize());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> observeOn(Scheduler r2, boolean r3) {
        return observeOn(r2, r3, bufferSize());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> observeOn(Scheduler r2, boolean r3, int r4) {
        ObjectHelper.requireNonNull(r2, "scheduler is null");
        ObjectHelper.verifyPositive(r4, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableObserveOn(this, r2, r3, r4));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<U> ofType(Class<U> r2) {
        ObjectHelper.requireNonNull(r2, "clazz is null");
        return filter(Functions.isInstanceOf(r2)).cast(r2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> onErrorResumeNext(Function<? super Throwable, ? extends ObservableSource<? extends T>> r3) {
        ObjectHelper.requireNonNull(r3, "resumeFunction is null");
        return RxJavaPlugins.onAssembly(new ObservableOnErrorNext(this, r3, false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> onErrorResumeNext(ObservableSource<? extends T> r2) {
        ObjectHelper.requireNonNull(r2, "next is null");
        return onErrorResumeNext(Functions.justFunction(r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> onErrorReturn(Function<? super Throwable, ? extends T> r2) {
        ObjectHelper.requireNonNull(r2, "valueSupplier is null");
        return RxJavaPlugins.onAssembly(new ObservableOnErrorReturn(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> onErrorReturnItem(T r2) {
        ObjectHelper.requireNonNull(r2, "item is null");
        return onErrorReturn(Functions.justFunction(r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> onExceptionResumeNext(ObservableSource<? extends T> r3) {
        ObjectHelper.requireNonNull(r3, "next is null");
        return RxJavaPlugins.onAssembly(new ObservableOnErrorNext(this, Functions.justFunction(r3), true));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> onTerminateDetach() {
        return RxJavaPlugins.onAssembly(new ObservableDetach(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final ConnectableObservable<T> publish() {
        return ObservablePublish.create(this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> publish(Function<? super Observable<T>, ? extends ObservableSource<R>> r2) {
        ObjectHelper.requireNonNull(r2, "selector is null");
        return RxJavaPlugins.onAssembly(new ObservablePublishSelector(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe<T> reduce(BiFunction<T, T, T> r2) {
        ObjectHelper.requireNonNull(r2, "reducer is null");
        return RxJavaPlugins.onAssembly(new ObservableReduceMaybe(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Single<R> reduce(R r2, BiFunction<R, ? super T, R> r3) {
        ObjectHelper.requireNonNull(r2, "seed is null");
        ObjectHelper.requireNonNull(r3, "reducer is null");
        return RxJavaPlugins.onAssembly(new ObservableReduceSeedSingle(this, r2, r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Single<R> reduceWith(Callable<R> r2, BiFunction<R, ? super T, R> r3) {
        ObjectHelper.requireNonNull(r2, "seedSupplier is null");
        ObjectHelper.requireNonNull(r3, "reducer is null");
        return RxJavaPlugins.onAssembly(new ObservableReduceWithSingle(this, r2, r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> repeat() {
        return repeat(Long.MAX_VALUE);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> repeat(long r3) {
        if (r3 < 0) goto L10;
        if (r3 != 0) goto L8;
        return empty();
    L8:
        return RxJavaPlugins.onAssembly(new ObservableRepeat(this, r3));
    L10:
        throw new IllegalArgumentException("times >= 0 required but it was " + r3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> repeatUntil(BooleanSupplier r2) {
        ObjectHelper.requireNonNull(r2, "stop is null");
        return RxJavaPlugins.onAssembly(new ObservableRepeatUntil(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> repeatWhen(Function<? super Observable<Object>, ? extends ObservableSource<?>> r2) {
        ObjectHelper.requireNonNull(r2, "handler is null");
        return RxJavaPlugins.onAssembly(new ObservableRepeatWhen(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final ConnectableObservable<T> replay() {
        return ObservableReplay.createFrom(this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> r2) {
        ObjectHelper.requireNonNull(r2, "selector is null");
        return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this), r2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> r2, int r3) {
        ObjectHelper.requireNonNull(r2, "selector is null");
        ObjectHelper.verifyPositive(r3, "bufferSize");
        return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this, r3), r2);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> r8, int r9, long r10, TimeUnit r12) {
        return replay(r8, r9, r10, r12, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> r7, int r8, long r9, TimeUnit r11, Scheduler r12) {
        ObjectHelper.requireNonNull(r7, "selector is null");
        ObjectHelper.verifyPositive(r8, "bufferSize");
        ObjectHelper.requireNonNull(r11, "unit is null");
        ObjectHelper.requireNonNull(r12, "scheduler is null");
        return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this, r8, r9, r11, r12), r7);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> r2, int r3, Scheduler r4) {
        ObjectHelper.requireNonNull(r2, "selector is null");
        ObjectHelper.requireNonNull(r4, "scheduler is null");
        ObjectHelper.verifyPositive(r3, "bufferSize");
        return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this, r3), ObservableInternalHelper.replayFunction(r2, r4));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> r7, long r8, TimeUnit r10) {
        return replay(r7, r8, r10, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> r2, long r3, TimeUnit r5, Scheduler r6) {
        ObjectHelper.requireNonNull(r2, "selector is null");
        ObjectHelper.requireNonNull(r5, "unit is null");
        ObjectHelper.requireNonNull(r6, "scheduler is null");
        return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this, r3, r5, r6), r2);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> r2, Scheduler r3) {
        ObjectHelper.requireNonNull(r2, "selector is null");
        ObjectHelper.requireNonNull(r3, "scheduler is null");
        return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this), ObservableInternalHelper.replayFunction(r2, r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final ConnectableObservable<T> replay(int r2) {
        ObjectHelper.verifyPositive(r2, "bufferSize");
        return ObservableReplay.create(this, r2);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final ConnectableObservable<T> replay(int r7, long r8, TimeUnit r10) {
        return replay(r7, r8, r10, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final ConnectableObservable<T> replay(int r7, long r8, TimeUnit r10, Scheduler r11) {
        ObjectHelper.verifyPositive(r7, "bufferSize");
        ObjectHelper.requireNonNull(r10, "unit is null");
        ObjectHelper.requireNonNull(r11, "scheduler is null");
        return ObservableReplay.create(this, r8, r10, r11, r7);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final ConnectableObservable<T> replay(int r2, Scheduler r3) {
        ObjectHelper.verifyPositive(r2, "bufferSize");
        return ObservableReplay.observeOn(replay(r2), r3);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final ConnectableObservable<T> replay(long r2, TimeUnit r4) {
        return replay(r2, r4, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final ConnectableObservable<T> replay(long r2, TimeUnit r4, Scheduler r5) {
        ObjectHelper.requireNonNull(r4, "unit is null");
        ObjectHelper.requireNonNull(r5, "scheduler is null");
        return ObservableReplay.create(this, r2, r4, r5);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final ConnectableObservable<T> replay(Scheduler r2) {
        ObjectHelper.requireNonNull(r2, "scheduler is null");
        return ObservableReplay.observeOn(replay(), r2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> retry() {
        return retry(Long.MAX_VALUE, Functions.alwaysTrue());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> retry(BiPredicate<? super Integer, ? super Throwable> r2) {
        ObjectHelper.requireNonNull(r2, "predicate is null");
        return RxJavaPlugins.onAssembly(new ObservableRetryBiPredicate(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> retry(long r2) {
        return retry(r2, Functions.alwaysTrue());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> retry(long r3, Predicate<? super Throwable> r5) {
        if (r3 < 0) goto L7;
        ObjectHelper.requireNonNull(r5, "predicate is null");
        return RxJavaPlugins.onAssembly(new ObservableRetryPredicate(this, r3, r5));
    L7:
        throw new IllegalArgumentException("times >= 0 required but it was " + r3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> retry(Predicate<? super Throwable> r3) {
        return retry(Long.MAX_VALUE, r3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> retryUntil(BooleanSupplier r3) {
        ObjectHelper.requireNonNull(r3, "stop is null");
        return retry(Long.MAX_VALUE, Functions.predicateReverseFor(r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> retryWhen(Function<? super Observable<Throwable>, ? extends ObservableSource<?>> r2) {
        ObjectHelper.requireNonNull(r2, "handler is null");
        return RxJavaPlugins.onAssembly(new ObservableRetryWhen(this, r2));
    }

    @SchedulerSupport("none")
    public final void safeSubscribe(Observer<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "observer is null");
        if ((r2 instanceof SafeObserver) == false) goto L5;
        subscribe(r2);
        return;
    L5:
        subscribe(new SafeObserver(r2));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> sample(long r2, TimeUnit r4) {
        return sample(r2, r4, Schedulers.computation());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> sample(long r7, TimeUnit r9, boolean r10) {
        return sample(r7, r9, Schedulers.computation(), r10);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> sample(long r9, TimeUnit r11, Scheduler r12) {
        ObjectHelper.requireNonNull(r11, "unit is null");
        ObjectHelper.requireNonNull(r12, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableSampleTimed(this, r9, r11, r12, false));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> sample(long r9, TimeUnit r11, Scheduler r12, boolean r13) {
        ObjectHelper.requireNonNull(r11, "unit is null");
        ObjectHelper.requireNonNull(r12, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableSampleTimed(this, r9, r11, r12, r13));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<T> sample(ObservableSource<U> r3) {
        ObjectHelper.requireNonNull(r3, "sampler is null");
        return RxJavaPlugins.onAssembly(new ObservableSampleWithObservable(this, r3, false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<T> sample(ObservableSource<U> r2, boolean r3) {
        ObjectHelper.requireNonNull(r2, "sampler is null");
        return RxJavaPlugins.onAssembly(new ObservableSampleWithObservable(this, r2, r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> scan(BiFunction<T, T, T> r2) {
        ObjectHelper.requireNonNull(r2, "accumulator is null");
        return RxJavaPlugins.onAssembly(new ObservableScan(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> scan(R r2, BiFunction<R, ? super T, R> r3) {
        ObjectHelper.requireNonNull(r2, "initialValue is null");
        return scanWith(Functions.justCallable(r2), r3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> scanWith(Callable<R> r2, BiFunction<R, ? super T, R> r3) {
        ObjectHelper.requireNonNull(r2, "seedSupplier is null");
        ObjectHelper.requireNonNull(r3, "accumulator is null");
        return RxJavaPlugins.onAssembly(new ObservableScanSeed(this, r2, r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> serialize() {
        return RxJavaPlugins.onAssembly(new ObservableSerialized(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> share() {
        return publish().refCount();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe<T> singleElement() {
        return RxJavaPlugins.onAssembly(new ObservableSingleMaybe(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> single(T r2) {
        ObjectHelper.requireNonNull(r2, "defaultItem is null");
        return RxJavaPlugins.onAssembly(new ObservableSingleSingle(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> singleOrError() {
        return RxJavaPlugins.onAssembly(new ObservableSingleSingle(this, null));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> skip(long r3) {
        if (r3 > 0) goto L7;
        return RxJavaPlugins.onAssembly(this);
    L7:
        return RxJavaPlugins.onAssembly(new ObservableSkip(this, r3));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> skip(long r1, TimeUnit r3) {
        return skipUntil(timer(r1, r3));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> skip(long r1, TimeUnit r3, Scheduler r4) {
        return skipUntil(timer(r1, r3, r4));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> skipLast(int r3) {
        if (r3 < 0) goto L9;
        if (r3 != 0) goto L7;
        return RxJavaPlugins.onAssembly(this);
    L7:
        return RxJavaPlugins.onAssembly(new ObservableSkipLast(this, r3));
    L9:
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + r3);
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    @CheckReturnValue
    public final Observable<T> skipLast(long r8, TimeUnit r10) {
        return skipLast(r8, r10, Schedulers.trampoline(), false, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    @CheckReturnValue
    public final Observable<T> skipLast(long r8, TimeUnit r10, boolean r11) {
        return skipLast(r8, r10, Schedulers.trampoline(), r11, bufferSize());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> skipLast(long r8, TimeUnit r10, Scheduler r11) {
        return skipLast(r8, r10, r11, false, bufferSize());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> skipLast(long r8, TimeUnit r10, Scheduler r11, boolean r12) {
        return skipLast(r8, r10, r11, r12, bufferSize());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> skipLast(long r10, TimeUnit r12, Scheduler r13, boolean r14, int r15) {
        ObjectHelper.requireNonNull(r12, "unit is null");
        ObjectHelper.requireNonNull(r13, "scheduler is null");
        ObjectHelper.verifyPositive(r15, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableSkipLastTimed(this, r10, r12, r13, r15 << 1, r14));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<T> skipUntil(ObservableSource<U> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new ObservableSkipUntil(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> skipWhile(Predicate<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "predicate is null");
        return RxJavaPlugins.onAssembly(new ObservableSkipWhile(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> sorted() {
        return toList().toObservable().map(Functions.listSorter(Functions.naturalComparator())).flatMapIterable(Functions.identity());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> sorted(Comparator<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "sortFunction is null");
        return toList().toObservable().map(Functions.listSorter(r2)).flatMapIterable(Functions.identity());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> startWith(Iterable<? extends T> r3) {
        return concatArray(new ObservableSource[]{fromIterable(r3), this});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> startWith(ObservableSource<? extends T> r3) {
        ObjectHelper.requireNonNull(r3, "other is null");
        return concatArray(new ObservableSource[]{r3, this});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> startWith(T r3) {
        ObjectHelper.requireNonNull(r3, "item is null");
        return concatArray(new ObservableSource[]{just(r3), this});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> startWithArray(T... r3) {
        Observable r4 = fromArray(r3);
        if (r4 != empty()) goto L7;
        return RxJavaPlugins.onAssembly(this);
    L7:
        return concatArray(new ObservableSource[]{r4, this});
    }

    @SchedulerSupport("none")
    public final Disposable subscribe() {
        return subscribe(Functions.emptyConsumer(), Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, Functions.emptyConsumer());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> r4) {
        return subscribe(r4, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, Functions.emptyConsumer());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> r3, Consumer<? super Throwable> r4) {
        return subscribe(r3, r4, Functions.EMPTY_ACTION, Functions.emptyConsumer());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> r2, Consumer<? super Throwable> r3, Action r4) {
        return subscribe(r2, r3, r4, Functions.emptyConsumer());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> r2, Consumer<? super Throwable> r3, Action r4, Consumer<? super Disposable> r5) {
        ObjectHelper.requireNonNull(r2, "onNext is null");
        ObjectHelper.requireNonNull(r3, "onError is null");
        ObjectHelper.requireNonNull(r4, "onComplete is null");
        ObjectHelper.requireNonNull(r5, "onSubscribe is null");
        LambdaObserver r0 = new LambdaObserver(r2, r3, r4, r5);
        subscribe(r0);
        return r0;
    }

    @Override // io.reactivex.ObservableSource
    @SchedulerSupport("none")
    public final void subscribe(Observer<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "observer is null");
        Observer<? super T> r3 = RxJavaPlugins.onSubscribe(this, r2);     // Catch: Throwable -> L5 NullPointerException -> L8
        ObjectHelper.requireNonNull(r3, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");     // Catch: Throwable -> L5 NullPointerException -> L8
        subscribeActual(r3);     // Catch: Throwable -> L5 NullPointerException -> L8
        return;
    L8:
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

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <E extends Observer<? super T>> E subscribeWith(E r1) {
        subscribe(r1);
        return r1;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> subscribeOn(Scheduler r2) {
        ObjectHelper.requireNonNull(r2, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableSubscribeOn(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> switchIfEmpty(ObservableSource<? extends T> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new ObservableSwitchIfEmpty(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> switchMap(Function<? super T, ? extends ObservableSource<? extends R>> r2) {
        return switchMap(r2, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> switchMap(Function<? super T, ? extends ObservableSource<? extends R>> r3, int r4) {
        ObjectHelper.requireNonNull(r3, "mapper is null");
        ObjectHelper.verifyPositive(r4, "bufferSize");
        if ((this instanceof ScalarCallable) == false) goto L11;
        Object r2 = ((ScalarCallable) this).call();
        if (r2 != null) goto L9;
        return empty();
    L9:
        return ObservableScalarXMap.scalarXMap(r2, r3);
    L11:
        return RxJavaPlugins.onAssembly(new ObservableSwitchMap(this, r3, r4, false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable switchMapCompletable(Function<? super T, ? extends CompletableSource> r3) {
        ObjectHelper.requireNonNull(r3, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableSwitchMapCompletable(this, r3, false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable switchMapCompletableDelayError(Function<? super T, ? extends CompletableSource> r3) {
        ObjectHelper.requireNonNull(r3, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableSwitchMapCompletable(this, r3, true));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> switchMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> r3) {
        ObjectHelper.requireNonNull(r3, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableSwitchMapMaybe(this, r3, false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> switchMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> r3) {
        ObjectHelper.requireNonNull(r3, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableSwitchMapMaybe(this, r3, true));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> switchMapSingle(Function<? super T, ? extends SingleSource<? extends R>> r3) {
        ObjectHelper.requireNonNull(r3, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableSwitchMapSingle(this, r3, false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> switchMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> r3) {
        ObjectHelper.requireNonNull(r3, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableSwitchMapSingle(this, r3, true));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> switchMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> r2) {
        return switchMapDelayError(r2, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> switchMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> r3, int r4) {
        ObjectHelper.requireNonNull(r3, "mapper is null");
        ObjectHelper.verifyPositive(r4, "bufferSize");
        if ((this instanceof ScalarCallable) == false) goto L11;
        Object r2 = ((ScalarCallable) this).call();
        if (r2 != null) goto L9;
        return empty();
    L9:
        return ObservableScalarXMap.scalarXMap(r2, r3);
    L11:
        return RxJavaPlugins.onAssembly(new ObservableSwitchMap(this, r3, r4, true));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> take(long r3) {
        if (r3 < 0) goto L7;
        return RxJavaPlugins.onAssembly(new ObservableTake(this, r3));
    L7:
        throw new IllegalArgumentException("count >= 0 required but it was " + r3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> take(long r1, TimeUnit r3) {
        return takeUntil(timer(r1, r3));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> take(long r1, TimeUnit r3, Scheduler r4) {
        return takeUntil(timer(r1, r3, r4));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> takeLast(int r3) {
        if (r3 < 0) goto L13;
        if (r3 != 0) goto L7;
        return RxJavaPlugins.onAssembly(new ObservableIgnoreElements(this));
    L7:
        if (r3 != 1) goto L11;
        return RxJavaPlugins.onAssembly(new ObservableTakeLastOne(this));
    L11:
        return RxJavaPlugins.onAssembly(new ObservableTakeLast(this, r3));
    L13:
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + r3);
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    @CheckReturnValue
    public final Observable<T> takeLast(long r10, long r12, TimeUnit r14) {
        return takeLast(r10, r12, r14, Schedulers.trampoline(), false, bufferSize());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> takeLast(long r10, long r12, TimeUnit r14, Scheduler r15) {
        return takeLast(r10, r12, r14, r15, false, bufferSize());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> takeLast(long r12, long r14, TimeUnit r16, Scheduler r17, boolean r18, int r19) {
        ObjectHelper.requireNonNull(r16, "unit is null");
        ObjectHelper.requireNonNull(r17, "scheduler is null");
        ObjectHelper.verifyPositive(r19, "bufferSize");
        if (r12 < 0) goto L7;
        return RxJavaPlugins.onAssembly(new ObservableTakeLastTimed(this, r12, r14, r16, r17, r19, r18));
    L7:
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + r12);
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    @CheckReturnValue
    public final Observable<T> takeLast(long r8, TimeUnit r10) {
        return takeLast(r8, r10, Schedulers.trampoline(), false, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    @CheckReturnValue
    public final Observable<T> takeLast(long r8, TimeUnit r10, boolean r11) {
        return takeLast(r8, r10, Schedulers.trampoline(), r11, bufferSize());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> takeLast(long r8, TimeUnit r10, Scheduler r11) {
        return takeLast(r8, r10, r11, false, bufferSize());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> takeLast(long r8, TimeUnit r10, Scheduler r11, boolean r12) {
        return takeLast(r8, r10, r11, r12, bufferSize());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> takeLast(long r10, TimeUnit r12, Scheduler r13, boolean r14, int r15) {
        return takeLast(Long.MAX_VALUE, r10, r12, r13, r14, r15);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<T> takeUntil(ObservableSource<U> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new ObservableTakeUntil(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> takeUntil(Predicate<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "stopPredicate is null");
        return RxJavaPlugins.onAssembly(new ObservableTakeUntilPredicate(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> takeWhile(Predicate<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "predicate is null");
        return RxJavaPlugins.onAssembly(new ObservableTakeWhile(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> throttleFirst(long r2, TimeUnit r4) {
        return throttleFirst(r2, r4, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> throttleFirst(long r8, TimeUnit r10, Scheduler r11) {
        ObjectHelper.requireNonNull(r10, "unit is null");
        ObjectHelper.requireNonNull(r11, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableThrottleFirstTimed(this, r8, r10, r11));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> throttleLast(long r1, TimeUnit r3) {
        return sample(r1, r3);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> throttleLast(long r1, TimeUnit r3, Scheduler r4) {
        return sample(r1, r3, r4);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> throttleLatest(long r7, TimeUnit r9) {
        return throttleLatest(r7, r9, Schedulers.computation(), false);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> throttleLatest(long r7, TimeUnit r9, boolean r10) {
        return throttleLatest(r7, r9, Schedulers.computation(), r10);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> throttleLatest(long r7, TimeUnit r9, Scheduler r10) {
        return throttleLatest(r7, r9, r10, false);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> throttleLatest(long r9, TimeUnit r11, Scheduler r12, boolean r13) {
        ObjectHelper.requireNonNull(r11, "unit is null");
        ObjectHelper.requireNonNull(r12, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableThrottleLatest(this, r9, r11, r12, r13));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> throttleWithTimeout(long r1, TimeUnit r3) {
        return debounce(r1, r3);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> throttleWithTimeout(long r1, TimeUnit r3, Scheduler r4) {
        return debounce(r1, r3, r4);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Timed<T>> timeInterval() {
        return timeInterval(TimeUnit.MILLISECONDS, Schedulers.computation());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Timed<T>> timeInterval(Scheduler r2) {
        return timeInterval(TimeUnit.MILLISECONDS, r2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Timed<T>> timeInterval(TimeUnit r2) {
        return timeInterval(r2, Schedulers.computation());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Timed<T>> timeInterval(TimeUnit r2, Scheduler r3) {
        ObjectHelper.requireNonNull(r2, "unit is null");
        ObjectHelper.requireNonNull(r3, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableTimeInterval(this, r2, r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <V> Observable<T> timeout(Function<? super T, ? extends ObservableSource<V>> r2) {
        return timeout0(null, r2, null);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <V> Observable<T> timeout(Function<? super T, ? extends ObservableSource<V>> r2, ObservableSource<? extends T> r3) {
        ObjectHelper.requireNonNull(r3, "other is null");
        return timeout0(null, r2, r3);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> timeout(long r7, TimeUnit r9) {
        return timeout0(r7, r9, null, Schedulers.computation());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> timeout(long r8, TimeUnit r10, ObservableSource<? extends T> r11) {
        ObjectHelper.requireNonNull(r11, "other is null");
        return timeout0(r8, r10, r11, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> timeout(long r7, TimeUnit r9, Scheduler r10, ObservableSource<? extends T> r11) {
        ObjectHelper.requireNonNull(r11, "other is null");
        return timeout0(r7, r9, r11, r10);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> timeout(long r7, TimeUnit r9, Scheduler r10) {
        return timeout0(r7, r9, null, r10);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, V> Observable<T> timeout(ObservableSource<U> r2, Function<? super T, ? extends ObservableSource<V>> r3) {
        ObjectHelper.requireNonNull(r2, "firstTimeoutIndicator is null");
        return timeout0(r2, r3, null);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, V> Observable<T> timeout(ObservableSource<U> r2, Function<? super T, ? extends ObservableSource<V>> r3, ObservableSource<? extends T> r4) {
        ObjectHelper.requireNonNull(r2, "firstTimeoutIndicator is null");
        ObjectHelper.requireNonNull(r4, "other is null");
        return timeout0(r2, r3, r4);
    }

    private Observable<T> timeout0(long r9, TimeUnit r11, ObservableSource<? extends T> r12, Scheduler r13) {
        ObjectHelper.requireNonNull(r11, "timeUnit is null");
        ObjectHelper.requireNonNull(r13, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableTimeoutTimed(this, r9, r11, r13, r12));
    }

    private <U, V> Observable<T> timeout0(ObservableSource<U> r2, Function<? super T, ? extends ObservableSource<V>> r3, ObservableSource<? extends T> r4) {
        ObjectHelper.requireNonNull(r3, "itemTimeoutIndicator is null");
        return RxJavaPlugins.onAssembly(new ObservableTimeout(this, r2, r3, r4));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Timed<T>> timestamp() {
        return timestamp(TimeUnit.MILLISECONDS, Schedulers.computation());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Timed<T>> timestamp(Scheduler r2) {
        return timestamp(TimeUnit.MILLISECONDS, r2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Timed<T>> timestamp(TimeUnit r2) {
        return timestamp(r2, Schedulers.computation());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Timed<T>> timestamp(TimeUnit r2, Scheduler r3) {
        ObjectHelper.requireNonNull(r2, "unit is null");
        ObjectHelper.requireNonNull(r3, "scheduler is null");
        return (Observable<Timed<T>>) map(Functions.timestampWith(r2, r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> R to(Function<? super Observable<T>, R> r2) {
        return (R) ((Function) ObjectHelper.requireNonNull(r2, "converter is null")).apply(this);
    L4:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        throw ExceptionHelper.wrapOrThrow(th);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<List<T>> toList() {
        return toList(16);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<List<T>> toList(int r2) {
        ObjectHelper.verifyPositive(r2, "capacityHint");
        return RxJavaPlugins.onAssembly(new ObservableToListSingle(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U extends Collection<? super T>> Single<U> toList(Callable<U> r2) {
        ObjectHelper.requireNonNull(r2, "collectionSupplier is null");
        return RxJavaPlugins.onAssembly(new ObservableToListSingle(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> Single<Map<K, T>> toMap(Function<? super T, ? extends K> r2) {
        ObjectHelper.requireNonNull(r2, "keySelector is null");
        return (Single<Map<K, T>>) collect(HashMapSupplier.asCallable(), Functions.toMapKeySelector(r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> r2, Function<? super T, ? extends V> r3) {
        ObjectHelper.requireNonNull(r2, "keySelector is null");
        ObjectHelper.requireNonNull(r3, "valueSelector is null");
        return (Single<Map<K, V>>) collect(HashMapSupplier.asCallable(), Functions.toMapKeyValueSelector(r2, r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> r2, Function<? super T, ? extends V> r3, Callable<? extends Map<K, V>> r4) {
        ObjectHelper.requireNonNull(r2, "keySelector is null");
        ObjectHelper.requireNonNull(r3, "valueSelector is null");
        ObjectHelper.requireNonNull(r4, "mapSupplier is null");
        return (Single<Map<K, V>>) collect(r4, Functions.toMapKeyValueSelector(r2, r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> Single<Map<K, Collection<T>>> toMultimap(Function<? super T, ? extends K> r4) {
        return (Single<Map<K, Collection<T>>>) toMultimap(r4, Functions.identity(), HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> r3, Function<? super T, ? extends V> r4) {
        return toMultimap(r3, r4, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> r2, Function<? super T, ? extends V> r3, Callable<? extends Map<K, Collection<V>>> r4, Function<? super K, ? extends Collection<? super V>> r5) {
        ObjectHelper.requireNonNull(r2, "keySelector is null");
        ObjectHelper.requireNonNull(r3, "valueSelector is null");
        ObjectHelper.requireNonNull(r4, "mapSupplier is null");
        ObjectHelper.requireNonNull(r5, "collectionFactory is null");
        return (Single<Map<K, Collection<V>>>) collect(r4, Functions.toMultimapKeyValueSelector(r2, r3, r5));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> r2, Function<? super T, ? extends V> r3, Callable<Map<K, Collection<V>>> r4) {
        return toMultimap(r2, r3, r4, ArrayListSupplier.asFunction());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final Flowable<T> toFlowable(BackpressureStrategy r2) {
        FlowableFromObservable r0 = new FlowableFromObservable(this);
        int r1 = AnonymousClass1.$SwitchMap$io$reactivex$BackpressureStrategy[r2.ordinal()];
        if (r1 == 1) goto L18;
        if (r1 == 2) goto L16;
        if (r1 != 3) goto L9;
        return r0;
    L9:
        if (r1 == 4) goto L13;
        return r0.onBackpressureBuffer();
    L13:
        return RxJavaPlugins.onAssembly(new FlowableOnBackpressureError(r0));
    L16:
        return r0.onBackpressureLatest();
    L18:
        return r0.onBackpressureDrop();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<List<T>> toSortedList() {
        return toSortedList(Functions.naturalOrder());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<List<T>> toSortedList(Comparator<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "comparator is null");
        return (Single<List<T>>) toList().map(Functions.listSorter(r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<List<T>> toSortedList(Comparator<? super T> r2, int r3) {
        ObjectHelper.requireNonNull(r2, "comparator is null");
        return (Single<List<T>>) toList(r3).map(Functions.listSorter(r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<List<T>> toSortedList(int r2) {
        return toSortedList(Functions.naturalOrder(), r2);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> unsubscribeOn(Scheduler r2) {
        ObjectHelper.requireNonNull(r2, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableUnsubscribeOn(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Observable<T>> window(long r7) {
        return window(r7, r7, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Observable<T>> window(long r7, long r9) {
        return window(r7, r9, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Observable<T>> window(long r9, long r11, int r13) {
        ObjectHelper.verifyPositive(r9, "count");
        ObjectHelper.verifyPositive(r11, "skip");
        ObjectHelper.verifyPositive(r13, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableWindow(this, r9, r11, r13));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<Observable<T>> window(long r9, long r11, TimeUnit r13) {
        return window(r9, r11, r13, Schedulers.computation(), bufferSize());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<Observable<T>> window(long r9, long r11, TimeUnit r13, Scheduler r14) {
        return window(r9, r11, r13, r14, bufferSize());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<Observable<T>> window(long r14, long r16, TimeUnit r18, Scheduler r19, int r20) {
        ObjectHelper.verifyPositive(r14, "timespan");
        ObjectHelper.verifyPositive(r16, "timeskip");
        ObjectHelper.verifyPositive(r20, "bufferSize");
        ObjectHelper.requireNonNull(r19, "scheduler is null");
        ObjectHelper.requireNonNull(r18, "unit is null");
        return RxJavaPlugins.onAssembly(new ObservableWindowTimed(this, r14, r16, r18, r19, Long.MAX_VALUE, r20, false));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<Observable<T>> window(long r9, TimeUnit r11) {
        return window(r9, r11, Schedulers.computation(), Long.MAX_VALUE, false);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<Observable<T>> window(long r9, TimeUnit r11, long r12) {
        return window(r9, r11, Schedulers.computation(), r12, false);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<Observable<T>> window(long r9, TimeUnit r11, long r12, boolean r14) {
        return window(r9, r11, Schedulers.computation(), r12, r14);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<Observable<T>> window(long r9, TimeUnit r11, Scheduler r12) {
        return window(r9, r11, r12, Long.MAX_VALUE, false);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<Observable<T>> window(long r9, TimeUnit r11, Scheduler r12, long r13) {
        return window(r9, r11, r12, r13, false);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<Observable<T>> window(long r10, TimeUnit r12, Scheduler r13, long r14, boolean r16) {
        return window(r10, r12, r13, r14, r16, bufferSize());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<Observable<T>> window(long r14, TimeUnit r16, Scheduler r17, long r18, boolean r20, int r21) {
        ObjectHelper.verifyPositive(r21, "bufferSize");
        ObjectHelper.requireNonNull(r17, "scheduler is null");
        ObjectHelper.requireNonNull(r16, "unit is null");
        ObjectHelper.verifyPositive(r18, "count");
        return RxJavaPlugins.onAssembly(new ObservableWindowTimed(this, r14, r14, r16, r17, r18, r21, r20));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> Observable<Observable<T>> window(ObservableSource<B> r2) {
        return window(r2, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> Observable<Observable<T>> window(ObservableSource<B> r2, int r3) {
        ObjectHelper.requireNonNull(r2, "boundary is null");
        ObjectHelper.verifyPositive(r3, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableWindowBoundary(this, r2, r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, V> Observable<Observable<T>> window(ObservableSource<U> r2, Function<? super U, ? extends ObservableSource<V>> r3) {
        return window(r2, r3, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, V> Observable<Observable<T>> window(ObservableSource<U> r2, Function<? super U, ? extends ObservableSource<V>> r3, int r4) {
        ObjectHelper.requireNonNull(r2, "openingIndicator is null");
        ObjectHelper.requireNonNull(r3, "closingIndicator is null");
        ObjectHelper.verifyPositive(r4, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableWindowBoundarySelector(this, r2, r3, r4));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> Observable<Observable<T>> window(Callable<? extends ObservableSource<B>> r2) {
        return window(r2, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> Observable<Observable<T>> window(Callable<? extends ObservableSource<B>> r2, int r3) {
        ObjectHelper.requireNonNull(r2, "boundary is null");
        ObjectHelper.verifyPositive(r3, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableWindowBoundarySupplier(this, r2, r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> withLatestFrom(ObservableSource<? extends U> r2, BiFunction<? super T, ? super U, ? extends R> r3) {
        ObjectHelper.requireNonNull(r2, "other is null");
        ObjectHelper.requireNonNull(r3, "combiner is null");
        return RxJavaPlugins.onAssembly(new ObservableWithLatestFrom(this, r3, r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, R> Observable<R> withLatestFrom(ObservableSource<T1> r3, ObservableSource<T2> r4, Function3<? super T, ? super T1, ? super T2, R> r5) {
        ObjectHelper.requireNonNull(r3, "o1 is null");
        ObjectHelper.requireNonNull(r4, "o2 is null");
        ObjectHelper.requireNonNull(r5, "combiner is null");
        return withLatestFrom(new ObservableSource[]{r3, r4}, Functions.toFunction(r5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, R> Observable<R> withLatestFrom(ObservableSource<T1> r3, ObservableSource<T2> r4, ObservableSource<T3> r5, Function4<? super T, ? super T1, ? super T2, ? super T3, R> r6) {
        ObjectHelper.requireNonNull(r3, "o1 is null");
        ObjectHelper.requireNonNull(r4, "o2 is null");
        ObjectHelper.requireNonNull(r5, "o3 is null");
        ObjectHelper.requireNonNull(r6, "combiner is null");
        return withLatestFrom(new ObservableSource[]{r3, r4, r5}, Functions.toFunction(r6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, T4, R> Observable<R> withLatestFrom(ObservableSource<T1> r3, ObservableSource<T2> r4, ObservableSource<T3> r5, ObservableSource<T4> r6, Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> r7) {
        ObjectHelper.requireNonNull(r3, "o1 is null");
        ObjectHelper.requireNonNull(r4, "o2 is null");
        ObjectHelper.requireNonNull(r5, "o3 is null");
        ObjectHelper.requireNonNull(r6, "o4 is null");
        ObjectHelper.requireNonNull(r7, "combiner is null");
        return withLatestFrom(new ObservableSource[]{r3, r4, r5, r6}, Functions.toFunction(r7));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> withLatestFrom(ObservableSource<?>[] r2, Function<? super Object[], R> r3) {
        ObjectHelper.requireNonNull(r2, "others is null");
        ObjectHelper.requireNonNull(r3, "combiner is null");
        return RxJavaPlugins.onAssembly(new ObservableWithLatestFromMany(this, r2, r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> withLatestFrom(Iterable<? extends ObservableSource<?>> r2, Function<? super Object[], R> r3) {
        ObjectHelper.requireNonNull(r2, "others is null");
        ObjectHelper.requireNonNull(r3, "combiner is null");
        return RxJavaPlugins.onAssembly(new ObservableWithLatestFromMany(this, r2, r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> zipWith(Iterable<U> r2, BiFunction<? super T, ? super U, ? extends R> r3) {
        ObjectHelper.requireNonNull(r2, "other is null");
        ObjectHelper.requireNonNull(r3, "zipper is null");
        return RxJavaPlugins.onAssembly(new ObservableZipIterable(this, r2, r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> r2, BiFunction<? super T, ? super U, ? extends R> r3) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return zip(this, r2, r3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> r1, BiFunction<? super T, ? super U, ? extends R> r2, boolean r3) {
        return zip(this, r1, r2, r3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> r1, BiFunction<? super T, ? super U, ? extends R> r2, boolean r3, int r4) {
        return zip(this, r1, r2, r3, r4);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver<T> test() {
        TestObserver<T> r0 = new TestObserver();
        subscribe(r0);
        return r0;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver<T> test(boolean r2) {
        TestObserver<T> r0 = new TestObserver();
        if (r2 == false) goto L5;
        r0.dispose();
    L5:
        subscribe(r0);
        return r0;
    }
}
