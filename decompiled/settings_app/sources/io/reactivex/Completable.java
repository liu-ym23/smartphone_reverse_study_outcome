package io.reactivex;

import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.FuseToMaybe;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.observers.BlockingMultiObserver;
import io.reactivex.internal.observers.CallbackCompletableObserver;
import io.reactivex.internal.observers.EmptyCompletableObserver;
import io.reactivex.internal.operators.completable.CompletableAmb;
import io.reactivex.internal.operators.completable.CompletableAndThenCompletable;
import io.reactivex.internal.operators.completable.CompletableCache;
import io.reactivex.internal.operators.completable.CompletableConcat;
import io.reactivex.internal.operators.completable.CompletableConcatArray;
import io.reactivex.internal.operators.completable.CompletableConcatIterable;
import io.reactivex.internal.operators.completable.CompletableCreate;
import io.reactivex.internal.operators.completable.CompletableDefer;
import io.reactivex.internal.operators.completable.CompletableDelay;
import io.reactivex.internal.operators.completable.CompletableDetach;
import io.reactivex.internal.operators.completable.CompletableDisposeOn;
import io.reactivex.internal.operators.completable.CompletableDoFinally;
import io.reactivex.internal.operators.completable.CompletableDoOnEvent;
import io.reactivex.internal.operators.completable.CompletableEmpty;
import io.reactivex.internal.operators.completable.CompletableError;
import io.reactivex.internal.operators.completable.CompletableErrorSupplier;
import io.reactivex.internal.operators.completable.CompletableFromAction;
import io.reactivex.internal.operators.completable.CompletableFromCallable;
import io.reactivex.internal.operators.completable.CompletableFromObservable;
import io.reactivex.internal.operators.completable.CompletableFromPublisher;
import io.reactivex.internal.operators.completable.CompletableFromRunnable;
import io.reactivex.internal.operators.completable.CompletableFromSingle;
import io.reactivex.internal.operators.completable.CompletableFromUnsafeSource;
import io.reactivex.internal.operators.completable.CompletableHide;
import io.reactivex.internal.operators.completable.CompletableLift;
import io.reactivex.internal.operators.completable.CompletableMaterialize;
import io.reactivex.internal.operators.completable.CompletableMerge;
import io.reactivex.internal.operators.completable.CompletableMergeArray;
import io.reactivex.internal.operators.completable.CompletableMergeDelayErrorArray;
import io.reactivex.internal.operators.completable.CompletableMergeDelayErrorIterable;
import io.reactivex.internal.operators.completable.CompletableMergeIterable;
import io.reactivex.internal.operators.completable.CompletableNever;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableOnErrorComplete;
import io.reactivex.internal.operators.completable.CompletablePeek;
import io.reactivex.internal.operators.completable.CompletableResumeNext;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.internal.operators.completable.CompletableTakeUntilCompletable;
import io.reactivex.internal.operators.completable.CompletableTimeout;
import io.reactivex.internal.operators.completable.CompletableTimer;
import io.reactivex.internal.operators.completable.CompletableToFlowable;
import io.reactivex.internal.operators.completable.CompletableToObservable;
import io.reactivex.internal.operators.completable.CompletableToSingle;
import io.reactivex.internal.operators.completable.CompletableUsing;
import io.reactivex.internal.operators.maybe.MaybeDelayWithCompletable;
import io.reactivex.internal.operators.maybe.MaybeFromCompletable;
import io.reactivex.internal.operators.maybe.MaybeIgnoreElementCompletable;
import io.reactivex.internal.operators.mixed.CompletableAndThenObservable;
import io.reactivex.internal.operators.mixed.CompletableAndThenPublisher;
import io.reactivex.internal.operators.single.SingleDelayWithCompletable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Completable implements CompletableSource {
    protected abstract void subscribeActual(CompletableObserver r1);

    public Completable() {
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable ambArray(CompletableSource... r2) {
        ObjectHelper.requireNonNull(r2, "sources is null");
        if (r2.length != 0) goto L7;
        return complete();
    L7:
        if (r2.length != 1) goto L11;
        return wrap(r2[0]);
    L11:
        return RxJavaPlugins.onAssembly(new CompletableAmb(r2, null));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable amb(Iterable<? extends CompletableSource> r2) {
        ObjectHelper.requireNonNull(r2, "sources is null");
        return RxJavaPlugins.onAssembly(new CompletableAmb(null, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable complete() {
        return RxJavaPlugins.onAssembly(CompletableEmpty.INSTANCE);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable concatArray(CompletableSource... r2) {
        ObjectHelper.requireNonNull(r2, "sources is null");
        if (r2.length != 0) goto L7;
        return complete();
    L7:
        if (r2.length != 1) goto L11;
        return wrap(r2[0]);
    L11:
        return RxJavaPlugins.onAssembly(new CompletableConcatArray(r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable concat(Iterable<? extends CompletableSource> r1) {
        ObjectHelper.requireNonNull(r1, "sources is null");
        return RxJavaPlugins.onAssembly(new CompletableConcatIterable(r1));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Completable concat(Publisher<? extends CompletableSource> r1) {
        return concat(r1, 2);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Completable concat(Publisher<? extends CompletableSource> r1, int r2) {
        ObjectHelper.requireNonNull(r1, "sources is null");
        ObjectHelper.verifyPositive(r2, "prefetch");
        return RxJavaPlugins.onAssembly(new CompletableConcat(r1, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable create(CompletableOnSubscribe r1) {
        ObjectHelper.requireNonNull(r1, "source is null");
        return RxJavaPlugins.onAssembly(new CompletableCreate(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable unsafeCreate(CompletableSource r1) {
        ObjectHelper.requireNonNull(r1, "source is null");
        if ((r1 instanceof Completable) == true) goto L7;
        return RxJavaPlugins.onAssembly(new CompletableFromUnsafeSource(r1));
    L7:
        throw new IllegalArgumentException("Use of unsafeCreate(Completable)!");
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable defer(Callable<? extends CompletableSource> r1) {
        ObjectHelper.requireNonNull(r1, "completableSupplier");
        return RxJavaPlugins.onAssembly(new CompletableDefer(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable error(Callable<? extends Throwable> r1) {
        ObjectHelper.requireNonNull(r1, "errorSupplier is null");
        return RxJavaPlugins.onAssembly(new CompletableErrorSupplier(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable error(Throwable r1) {
        ObjectHelper.requireNonNull(r1, "error is null");
        return RxJavaPlugins.onAssembly(new CompletableError(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable fromAction(Action r1) {
        ObjectHelper.requireNonNull(r1, "run is null");
        return RxJavaPlugins.onAssembly(new CompletableFromAction(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable fromCallable(Callable<?> r1) {
        ObjectHelper.requireNonNull(r1, "callable is null");
        return RxJavaPlugins.onAssembly(new CompletableFromCallable(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable fromFuture(Future<?> r1) {
        ObjectHelper.requireNonNull(r1, "future is null");
        return fromAction(Functions.futureAction(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Completable fromMaybe(MaybeSource<T> r1) {
        ObjectHelper.requireNonNull(r1, "maybe is null");
        return RxJavaPlugins.onAssembly(new MaybeIgnoreElementCompletable(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable fromRunnable(Runnable r1) {
        ObjectHelper.requireNonNull(r1, "run is null");
        return RxJavaPlugins.onAssembly(new CompletableFromRunnable(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Completable fromObservable(ObservableSource<T> r1) {
        ObjectHelper.requireNonNull(r1, "observable is null");
        return RxJavaPlugins.onAssembly(new CompletableFromObservable(r1));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static <T> Completable fromPublisher(Publisher<T> r1) {
        ObjectHelper.requireNonNull(r1, "publisher is null");
        return RxJavaPlugins.onAssembly(new CompletableFromPublisher(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Completable fromSingle(SingleSource<T> r1) {
        ObjectHelper.requireNonNull(r1, "single is null");
        return RxJavaPlugins.onAssembly(new CompletableFromSingle(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable mergeArray(CompletableSource... r2) {
        ObjectHelper.requireNonNull(r2, "sources is null");
        if (r2.length != 0) goto L7;
        return complete();
    L7:
        if (r2.length != 1) goto L11;
        return wrap(r2[0]);
    L11:
        return RxJavaPlugins.onAssembly(new CompletableMergeArray(r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable merge(Iterable<? extends CompletableSource> r1) {
        ObjectHelper.requireNonNull(r1, "sources is null");
        return RxJavaPlugins.onAssembly(new CompletableMergeIterable(r1));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static Completable merge(Publisher<? extends CompletableSource> r2) {
        return merge0(r2, Integer.MAX_VALUE, false);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Completable merge(Publisher<? extends CompletableSource> r1, int r2) {
        return merge0(r1, r2, false);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    private static Completable merge0(Publisher<? extends CompletableSource> r1, int r2, boolean r3) {
        ObjectHelper.requireNonNull(r1, "sources is null");
        ObjectHelper.verifyPositive(r2, "maxConcurrency");
        return RxJavaPlugins.onAssembly(new CompletableMerge(r1, r2, r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable mergeArrayDelayError(CompletableSource... r1) {
        ObjectHelper.requireNonNull(r1, "sources is null");
        return RxJavaPlugins.onAssembly(new CompletableMergeDelayErrorArray(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable mergeDelayError(Iterable<? extends CompletableSource> r1) {
        ObjectHelper.requireNonNull(r1, "sources is null");
        return RxJavaPlugins.onAssembly(new CompletableMergeDelayErrorIterable(r1));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static Completable mergeDelayError(Publisher<? extends CompletableSource> r2) {
        return merge0(r2, Integer.MAX_VALUE, true);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Completable mergeDelayError(Publisher<? extends CompletableSource> r1, int r2) {
        return merge0(r1, r2, true);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable never() {
        return RxJavaPlugins.onAssembly(CompletableNever.INSTANCE);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static Completable timer(long r1, TimeUnit r3) {
        return timer(r1, r3, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static Completable timer(long r1, TimeUnit r3, Scheduler r4) {
        ObjectHelper.requireNonNull(r3, "unit is null");
        ObjectHelper.requireNonNull(r4, "scheduler is null");
        return RxJavaPlugins.onAssembly(new CompletableTimer(r1, r3, r4));
    }

    private static NullPointerException toNpe(Throwable r2) {
        NullPointerException r0 = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        r0.initCause(r2);
        return r0;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <R> Completable using(Callable<R> r1, Function<? super R, ? extends CompletableSource> r2, Consumer<? super R> r3) {
        return using(r1, r2, r3, true);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <R> Completable using(Callable<R> r1, Function<? super R, ? extends CompletableSource> r2, Consumer<? super R> r3, boolean r4) {
        ObjectHelper.requireNonNull(r1, "resourceSupplier is null");
        ObjectHelper.requireNonNull(r2, "completableFunction is null");
        ObjectHelper.requireNonNull(r3, "disposer is null");
        return RxJavaPlugins.onAssembly(new CompletableUsing(r1, r2, r3, r4));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable wrap(CompletableSource r1) {
        ObjectHelper.requireNonNull(r1, "source is null");
        if ((r1 instanceof Completable) == false) goto L7;
        return RxJavaPlugins.onAssembly((Completable) r1);
    L7:
        return RxJavaPlugins.onAssembly(new CompletableFromUnsafeSource(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable ambWith(CompletableSource r3) {
        ObjectHelper.requireNonNull(r3, "other is null");
        return ambArray(new CompletableSource[]{this, r3});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> Observable<T> andThen(ObservableSource<T> r2) {
        ObjectHelper.requireNonNull(r2, "next is null");
        return RxJavaPlugins.onAssembly(new CompletableAndThenObservable(this, r2));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T> Flowable<T> andThen(Publisher<T> r2) {
        ObjectHelper.requireNonNull(r2, "next is null");
        return RxJavaPlugins.onAssembly(new CompletableAndThenPublisher(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> Single<T> andThen(SingleSource<T> r2) {
        ObjectHelper.requireNonNull(r2, "next is null");
        return RxJavaPlugins.onAssembly(new SingleDelayWithCompletable(r2, this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> Maybe<T> andThen(MaybeSource<T> r2) {
        ObjectHelper.requireNonNull(r2, "next is null");
        return RxJavaPlugins.onAssembly(new MaybeDelayWithCompletable(r2, this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable andThen(CompletableSource r2) {
        ObjectHelper.requireNonNull(r2, "next is null");
        return RxJavaPlugins.onAssembly(new CompletableAndThenCompletable(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> R as(CompletableConverter<? extends R> r2) {
        return (R) ((CompletableConverter) ObjectHelper.requireNonNull(r2, "converter is null")).apply(this);
    }

    @SchedulerSupport("none")
    public final void blockingAwait() {
        BlockingMultiObserver r0 = new BlockingMultiObserver();
        subscribe(r0);
        r0.blockingGet();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final boolean blockingAwait(long r2, TimeUnit r4) {
        ObjectHelper.requireNonNull(r4, "unit is null");
        BlockingMultiObserver r0 = new BlockingMultiObserver();
        subscribe(r0);
        return r0.blockingAwait(r2, r4);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Throwable blockingGet() {
        BlockingMultiObserver r0 = new BlockingMultiObserver();
        subscribe(r0);
        return r0.blockingGetError();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Throwable blockingGet(long r2, TimeUnit r4) {
        ObjectHelper.requireNonNull(r4, "unit is null");
        BlockingMultiObserver r0 = new BlockingMultiObserver();
        subscribe(r0);
        return r0.blockingGetError(r2, r4);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable cache() {
        return RxJavaPlugins.onAssembly(new CompletableCache(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable compose(CompletableTransformer r2) {
        return wrap(((CompletableTransformer) ObjectHelper.requireNonNull(r2, "transformer is null")).apply(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable concatWith(CompletableSource r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new CompletableAndThenCompletable(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Completable delay(long r7, TimeUnit r9) {
        return delay(r7, r9, Schedulers.computation(), false);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Completable delay(long r7, TimeUnit r9, Scheduler r10) {
        return delay(r7, r9, r10, false);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Completable delay(long r9, TimeUnit r11, Scheduler r12, boolean r13) {
        ObjectHelper.requireNonNull(r11, "unit is null");
        ObjectHelper.requireNonNull(r12, "scheduler is null");
        return RxJavaPlugins.onAssembly(new CompletableDelay(this, r9, r11, r12, r13));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Completable delaySubscription(long r2, TimeUnit r4) {
        return delaySubscription(r2, r4, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Completable delaySubscription(long r1, TimeUnit r3, Scheduler r4) {
        return timer(r1, r3, r4).andThen(this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable doOnComplete(Action r8) {
        return doOnLifecycle(Functions.emptyConsumer(), Functions.emptyConsumer(), r8, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable doOnDispose(Action r8) {
        return doOnLifecycle(Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, r8);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable doOnError(Consumer<? super Throwable> r8) {
        return doOnLifecycle(Functions.emptyConsumer(), r8, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable doOnEvent(Consumer<? super Throwable> r2) {
        ObjectHelper.requireNonNull(r2, "onEvent is null");
        return RxJavaPlugins.onAssembly(new CompletableDoOnEvent(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    private Completable doOnLifecycle(Consumer<? super Disposable> r10, Consumer<? super Throwable> r11, Action r12, Action r13, Action r14, Action r15) {
        ObjectHelper.requireNonNull(r10, "onSubscribe is null");
        ObjectHelper.requireNonNull(r11, "onError is null");
        ObjectHelper.requireNonNull(r12, "onComplete is null");
        ObjectHelper.requireNonNull(r13, "onTerminate is null");
        ObjectHelper.requireNonNull(r14, "onAfterTerminate is null");
        ObjectHelper.requireNonNull(r15, "onDispose is null");
        return RxJavaPlugins.onAssembly(new CompletablePeek(this, r10, r11, r12, r13, r14, r15));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable doOnSubscribe(Consumer<? super Disposable> r8) {
        return doOnLifecycle(r8, Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable doOnTerminate(Action r8) {
        return doOnLifecycle(Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, r8, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable doAfterTerminate(Action r8) {
        return doOnLifecycle(Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, r8, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable doFinally(Action r2) {
        ObjectHelper.requireNonNull(r2, "onFinally is null");
        return RxJavaPlugins.onAssembly(new CompletableDoFinally(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable lift(CompletableOperator r2) {
        ObjectHelper.requireNonNull(r2, "onLift is null");
        return RxJavaPlugins.onAssembly(new CompletableLift(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> Single<Notification<T>> materialize() {
        return RxJavaPlugins.onAssembly(new CompletableMaterialize(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable mergeWith(CompletableSource r3) {
        ObjectHelper.requireNonNull(r3, "other is null");
        return mergeArray(new CompletableSource[]{this, r3});
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Completable observeOn(Scheduler r2) {
        ObjectHelper.requireNonNull(r2, "scheduler is null");
        return RxJavaPlugins.onAssembly(new CompletableObserveOn(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable onErrorComplete() {
        return onErrorComplete(Functions.alwaysTrue());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable onErrorComplete(Predicate<? super Throwable> r2) {
        ObjectHelper.requireNonNull(r2, "predicate is null");
        return RxJavaPlugins.onAssembly(new CompletableOnErrorComplete(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable onErrorResumeNext(Function<? super Throwable, ? extends CompletableSource> r2) {
        ObjectHelper.requireNonNull(r2, "errorMapper is null");
        return RxJavaPlugins.onAssembly(new CompletableResumeNext(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable onTerminateDetach() {
        return RxJavaPlugins.onAssembly(new CompletableDetach(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable repeat() {
        return fromPublisher(toFlowable().repeat());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable repeat(long r1) {
        return fromPublisher(toFlowable().repeat(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable repeatUntil(BooleanSupplier r1) {
        return fromPublisher(toFlowable().repeatUntil(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> r1) {
        return fromPublisher(toFlowable().repeatWhen(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable retry() {
        return fromPublisher(toFlowable().retry());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable retry(BiPredicate<? super Integer, ? super Throwable> r1) {
        return fromPublisher(toFlowable().retry(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable retry(long r1) {
        return fromPublisher(toFlowable().retry(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable retry(long r1, Predicate<? super Throwable> r3) {
        return fromPublisher(toFlowable().retry(r1, r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable retry(Predicate<? super Throwable> r1) {
        return fromPublisher(toFlowable().retry(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> r1) {
        return fromPublisher(toFlowable().retryWhen(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable startWith(CompletableSource r3) {
        ObjectHelper.requireNonNull(r3, "other is null");
        return concatArray(new CompletableSource[]{r3, this});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> Observable<T> startWith(Observable<T> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return r2.concatWith(toObservable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T> Flowable<T> startWith(Publisher<T> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return toFlowable().startWith(r2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable hide() {
        return RxJavaPlugins.onAssembly(new CompletableHide(this));
    }

    @SchedulerSupport("none")
    public final Disposable subscribe() {
        EmptyCompletableObserver r0 = new EmptyCompletableObserver();
        subscribe(r0);
        return r0;
    }

    @Override // io.reactivex.CompletableSource
    @SchedulerSupport("none")
    public final void subscribe(CompletableObserver r2) {
        ObjectHelper.requireNonNull(r2, "observer is null");
        CompletableObserver r3 = RxJavaPlugins.onSubscribe(this, r2);     // Catch: Throwable -> L5 NullPointerException -> L8
        ObjectHelper.requireNonNull(r3, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");     // Catch: Throwable -> L5 NullPointerException -> L8
        subscribeActual(r3);     // Catch: Throwable -> L5 NullPointerException -> L8
        return;
    L8:
        e = move-exception;
        throw e;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
        throw toNpe(th);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <E extends CompletableObserver> E subscribeWith(E r1) {
        subscribe(r1);
        return r1;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Action r2, Consumer<? super Throwable> r3) {
        ObjectHelper.requireNonNull(r3, "onError is null");
        ObjectHelper.requireNonNull(r2, "onComplete is null");
        CallbackCompletableObserver r0 = new CallbackCompletableObserver(r3, r2);
        subscribe(r0);
        return r0;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Action r2) {
        ObjectHelper.requireNonNull(r2, "onComplete is null");
        CallbackCompletableObserver r0 = new CallbackCompletableObserver(r2);
        subscribe(r0);
        return r0;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Completable subscribeOn(Scheduler r2) {
        ObjectHelper.requireNonNull(r2, "scheduler is null");
        return RxJavaPlugins.onAssembly(new CompletableSubscribeOn(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable takeUntil(CompletableSource r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new CompletableTakeUntilCompletable(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Completable timeout(long r7, TimeUnit r9) {
        return timeout0(r7, r9, Schedulers.computation(), null);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Completable timeout(long r8, TimeUnit r10, CompletableSource r11) {
        ObjectHelper.requireNonNull(r11, "other is null");
        return timeout0(r8, r10, Schedulers.computation(), r11);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Completable timeout(long r7, TimeUnit r9, Scheduler r10) {
        return timeout0(r7, r9, r10, null);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Completable timeout(long r2, TimeUnit r4, Scheduler r5, CompletableSource r6) {
        ObjectHelper.requireNonNull(r6, "other is null");
        return timeout0(r2, r4, r5, r6);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    private Completable timeout0(long r9, TimeUnit r11, Scheduler r12, CompletableSource r13) {
        ObjectHelper.requireNonNull(r11, "unit is null");
        ObjectHelper.requireNonNull(r12, "scheduler is null");
        return RxJavaPlugins.onAssembly(new CompletableTimeout(this, r9, r11, r12, r13));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> U to(Function<? super Completable, U> r2) {
        return (U) ((Function) ObjectHelper.requireNonNull(r2, "converter is null")).apply(this);
    L4:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        throw ExceptionHelper.wrapOrThrow(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T> Flowable<T> toFlowable() {
        if ((this instanceof FuseToFlowable) == false) goto L7;
        return ((FuseToFlowable) this).fuseToFlowable();
    L7:
        return RxJavaPlugins.onAssembly(new CompletableToFlowable(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> Maybe<T> toMaybe() {
        if ((this instanceof FuseToMaybe) == false) goto L7;
        return ((FuseToMaybe) this).fuseToMaybe();
    L7:
        return RxJavaPlugins.onAssembly(new MaybeFromCompletable(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> Observable<T> toObservable() {
        if ((this instanceof FuseToObservable) == false) goto L7;
        return ((FuseToObservable) this).fuseToObservable();
    L7:
        return RxJavaPlugins.onAssembly(new CompletableToObservable(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> Single<T> toSingle(Callable<? extends T> r3) {
        ObjectHelper.requireNonNull(r3, "completionValueSupplier is null");
        return RxJavaPlugins.onAssembly(new CompletableToSingle(this, r3, null));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> Single<T> toSingleDefault(T r3) {
        ObjectHelper.requireNonNull(r3, "completionValue is null");
        return RxJavaPlugins.onAssembly(new CompletableToSingle(this, null, r3));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Completable unsubscribeOn(Scheduler r2) {
        ObjectHelper.requireNonNull(r2, "scheduler is null");
        return RxJavaPlugins.onAssembly(new CompletableDisposeOn(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver<Void> test() {
        TestObserver<Void> r0 = new TestObserver();
        subscribe(r0);
        return r0;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver<Void> test(boolean r2) {
        TestObserver<Void> r0 = new TestObserver();
        if (r2 == false) goto L5;
        r0.cancel();
    L5:
        subscribe(r0);
        return r0;
    }
}
