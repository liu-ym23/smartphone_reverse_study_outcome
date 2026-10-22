package io.reactivex.plugins;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.internal.schedulers.NewThreadScheduler;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public final class RxJavaPlugins {

    @Nullable
    static volatile Consumer<? super Throwable> errorHandler;
    static volatile boolean failNonBlockingScheduler;
    static volatile boolean lockdown;

    @Nullable
    static volatile BooleanSupplier onBeforeBlocking;

    @Nullable
    static volatile Function<? super Completable, ? extends Completable> onCompletableAssembly;

    @Nullable
    static volatile BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> onCompletableSubscribe;

    @Nullable
    static volatile Function<? super Scheduler, ? extends Scheduler> onComputationHandler;

    @Nullable
    static volatile Function<? super ConnectableFlowable, ? extends ConnectableFlowable> onConnectableFlowableAssembly;

    @Nullable
    static volatile Function<? super ConnectableObservable, ? extends ConnectableObservable> onConnectableObservableAssembly;

    @Nullable
    static volatile Function<? super Flowable, ? extends Flowable> onFlowableAssembly;

    @Nullable
    static volatile BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> onFlowableSubscribe;

    @Nullable
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitComputationHandler;

    @Nullable
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitIoHandler;

    @Nullable
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitNewThreadHandler;

    @Nullable
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitSingleHandler;

    @Nullable
    static volatile Function<? super Scheduler, ? extends Scheduler> onIoHandler;

    @Nullable
    static volatile Function<? super Maybe, ? extends Maybe> onMaybeAssembly;

    @Nullable
    static volatile BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> onMaybeSubscribe;

    @Nullable
    static volatile Function<? super Scheduler, ? extends Scheduler> onNewThreadHandler;

    @Nullable
    static volatile Function<? super Observable, ? extends Observable> onObservableAssembly;

    @Nullable
    static volatile BiFunction<? super Observable, ? super Observer, ? extends Observer> onObservableSubscribe;

    @Nullable
    static volatile Function<? super ParallelFlowable, ? extends ParallelFlowable> onParallelAssembly;

    @Nullable
    static volatile Function<? super Runnable, ? extends Runnable> onScheduleHandler;

    @Nullable
    static volatile Function<? super Single, ? extends Single> onSingleAssembly;

    @Nullable
    static volatile Function<? super Scheduler, ? extends Scheduler> onSingleHandler;

    @Nullable
    static volatile BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> onSingleSubscribe;

    private RxJavaPlugins() {
        throw new IllegalStateException("No instances!");
    }

    @NonNull
    public static <T, R> R apply(@NonNull Function<T, R> r0, @NonNull T r1) {
        return r0.apply(r1);
    L4:
        th = move-exception;
        throw ExceptionHelper.wrapOrThrow(th);
    }

    @NonNull
    public static Scheduler applyRequireNonNull(@NonNull Function<? super Callable<Scheduler>, ? extends Scheduler> r0, Callable<Scheduler> r1) {
        return (Scheduler) ObjectHelper.requireNonNull(apply(r0, r1), "Scheduler Callable result can't be null");
    }

    @NonNull
    public static Scheduler callRequireNonNull(@NonNull Callable<Scheduler> r1) {
        return (Scheduler) ObjectHelper.requireNonNull(r1.call(), "Scheduler Callable result can't be null");
    L4:
        th = move-exception;
        throw ExceptionHelper.wrapOrThrow(th);
    }

    @NonNull
    public static Scheduler createComputationScheduler(@NonNull ThreadFactory r2) {
        return new ComputationScheduler((ThreadFactory) ObjectHelper.requireNonNull(r2, "threadFactory is null"));
    }

    @NonNull
    public static Scheduler createIoScheduler(@NonNull ThreadFactory r2) {
        return new IoScheduler((ThreadFactory) ObjectHelper.requireNonNull(r2, "threadFactory is null"));
    }

    @NonNull
    public static Scheduler createNewThreadScheduler(@NonNull ThreadFactory r2) {
        return new NewThreadScheduler((ThreadFactory) ObjectHelper.requireNonNull(r2, "threadFactory is null"));
    }

    @NonNull
    public static Scheduler createSingleScheduler(@NonNull ThreadFactory r2) {
        return new SingleScheduler((ThreadFactory) ObjectHelper.requireNonNull(r2, "threadFactory is null"));
    }

    @Nullable
    public static Function<? super Scheduler, ? extends Scheduler> getComputationSchedulerHandler() {
        return onComputationHandler;
    }

    @Nullable
    public static Consumer<? super Throwable> getErrorHandler() {
        return errorHandler;
    }

    @Nullable
    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitComputationSchedulerHandler() {
        return onInitComputationHandler;
    }

    @Nullable
    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitIoSchedulerHandler() {
        return onInitIoHandler;
    }

    @Nullable
    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitNewThreadSchedulerHandler() {
        return onInitNewThreadHandler;
    }

    @Nullable
    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitSingleSchedulerHandler() {
        return onInitSingleHandler;
    }

    @Nullable
    public static Function<? super Scheduler, ? extends Scheduler> getIoSchedulerHandler() {
        return onIoHandler;
    }

    @Nullable
    public static Function<? super Scheduler, ? extends Scheduler> getNewThreadSchedulerHandler() {
        return onNewThreadHandler;
    }

    @Nullable
    public static BooleanSupplier getOnBeforeBlocking() {
        return onBeforeBlocking;
    }

    @Nullable
    public static Function<? super Completable, ? extends Completable> getOnCompletableAssembly() {
        return onCompletableAssembly;
    }

    @Nullable
    public static BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> getOnCompletableSubscribe() {
        return onCompletableSubscribe;
    }

    @Nullable
    public static Function<? super ConnectableFlowable, ? extends ConnectableFlowable> getOnConnectableFlowableAssembly() {
        return onConnectableFlowableAssembly;
    }

    @Nullable
    public static Function<? super ConnectableObservable, ? extends ConnectableObservable> getOnConnectableObservableAssembly() {
        return onConnectableObservableAssembly;
    }

    @Nullable
    public static Function<? super Flowable, ? extends Flowable> getOnFlowableAssembly() {
        return onFlowableAssembly;
    }

    @Nullable
    public static BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> getOnFlowableSubscribe() {
        return onFlowableSubscribe;
    }

    @Nullable
    public static Function<? super Maybe, ? extends Maybe> getOnMaybeAssembly() {
        return onMaybeAssembly;
    }

    @Nullable
    public static BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> getOnMaybeSubscribe() {
        return onMaybeSubscribe;
    }

    @Nullable
    public static Function<? super Observable, ? extends Observable> getOnObservableAssembly() {
        return onObservableAssembly;
    }

    @Nullable
    public static BiFunction<? super Observable, ? super Observer, ? extends Observer> getOnObservableSubscribe() {
        return onObservableSubscribe;
    }

    @Nullable
    public static Function<? super ParallelFlowable, ? extends ParallelFlowable> getOnParallelAssembly() {
        return onParallelAssembly;
    }

    @Nullable
    public static Function<? super Single, ? extends Single> getOnSingleAssembly() {
        return onSingleAssembly;
    }

    @Nullable
    public static BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> getOnSingleSubscribe() {
        return onSingleSubscribe;
    }

    @Nullable
    public static Function<? super Runnable, ? extends Runnable> getScheduleHandler() {
        return onScheduleHandler;
    }

    @Nullable
    public static Function<? super Scheduler, ? extends Scheduler> getSingleSchedulerHandler() {
        return onSingleHandler;
    }

    @NonNull
    public static Scheduler initComputationScheduler(@NonNull Callable<Scheduler> r1) {
        ObjectHelper.requireNonNull(r1, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> r0 = onInitComputationHandler;
        if (r0 != null) goto L7;
        return callRequireNonNull(r1);
    L7:
        return applyRequireNonNull(r0, r1);
    }

    @NonNull
    public static Scheduler initIoScheduler(@NonNull Callable<Scheduler> r1) {
        ObjectHelper.requireNonNull(r1, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> r0 = onInitIoHandler;
        if (r0 != null) goto L7;
        return callRequireNonNull(r1);
    L7:
        return applyRequireNonNull(r0, r1);
    }

    @NonNull
    public static Scheduler initNewThreadScheduler(@NonNull Callable<Scheduler> r1) {
        ObjectHelper.requireNonNull(r1, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> r0 = onInitNewThreadHandler;
        if (r0 != null) goto L7;
        return callRequireNonNull(r1);
    L7:
        return applyRequireNonNull(r0, r1);
    }

    @NonNull
    public static Scheduler initSingleScheduler(@NonNull Callable<Scheduler> r1) {
        ObjectHelper.requireNonNull(r1, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> r0 = onInitSingleHandler;
        if (r0 != null) goto L7;
        return callRequireNonNull(r1);
    L7:
        return applyRequireNonNull(r0, r1);
    }

    public static boolean isBug(Throwable r2) {
        if ((r2 instanceof OnErrorNotImplementedException) == false) goto L6;
        return true;
    L6:
        if ((r2 instanceof MissingBackpressureException) == false) goto L9;
        return true;
    L9:
        if ((r2 instanceof IllegalStateException) == false) goto L12;
        return true;
    L12:
        if ((r2 instanceof NullPointerException) == false) goto L15;
        return true;
    L15:
        if ((r2 instanceof IllegalArgumentException) == false) goto L18;
        return true;
    L18:
        if ((r2 instanceof CompositeException) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public static boolean isFailOnNonBlockingScheduler() {
        return failNonBlockingScheduler;
    }

    public static boolean isLockdown() {
        return lockdown;
    }

    public static void lockdown() {
        lockdown = true;
    }

    @NonNull
    public static <T> Maybe<T> onAssembly(@NonNull Maybe<T> r1) {
        Function<? super Maybe, ? extends Maybe> r0 = onMaybeAssembly;
        if (r0 != null) goto L5;
        return r1;
    L5:
        return (Maybe) apply(r0, r1);
    }

    public static boolean onBeforeBlocking() {
        BooleanSupplier r0 = onBeforeBlocking;
        if (r0 != null) goto L11;
        return false;
    L11:
        return r0.getAsBoolean();
    L6:
        th = move-exception;
        throw ExceptionHelper.wrapOrThrow(th);
    }

    @NonNull
    public static Scheduler onComputationScheduler(@NonNull Scheduler r1) {
        Function<? super Scheduler, ? extends Scheduler> r0 = onComputationHandler;
        if (r0 != null) goto L6;
        return r1;
    L6:
        return (Scheduler) apply(r0, r1);
    }

    public static void onError(@NonNull Throwable r2) {
        Consumer<? super Throwable> r0 = errorHandler;
        if (r2 != null) goto L6;
        r2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    L8:
        if (r0 != null) goto L15;
    L13:
        r2.printStackTrace();
        uncaught(r2);
        return;
    L15:
        r0.accept(r2);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        uncaught(th);
        goto L13
    L6:
        if (isBug(r2) == true) goto L8;
        r2 = new UndeliverableException(r2);
        goto L8
    }

    @NonNull
    public static Scheduler onIoScheduler(@NonNull Scheduler r1) {
        Function<? super Scheduler, ? extends Scheduler> r0 = onIoHandler;
        if (r0 != null) goto L6;
        return r1;
    L6:
        return (Scheduler) apply(r0, r1);
    }

    @NonNull
    public static Scheduler onNewThreadScheduler(@NonNull Scheduler r1) {
        Function<? super Scheduler, ? extends Scheduler> r0 = onNewThreadHandler;
        if (r0 != null) goto L6;
        return r1;
    L6:
        return (Scheduler) apply(r0, r1);
    }

    @NonNull
    public static Runnable onSchedule(@NonNull Runnable r1) {
        ObjectHelper.requireNonNull(r1, "run is null");
        Function<? super Runnable, ? extends Runnable> r0 = onScheduleHandler;
        if (r0 != null) goto L6;
        return r1;
    L6:
        return (Runnable) apply(r0, r1);
    }

    @NonNull
    public static Scheduler onSingleScheduler(@NonNull Scheduler r1) {
        Function<? super Scheduler, ? extends Scheduler> r0 = onSingleHandler;
        if (r0 != null) goto L6;
        return r1;
    L6:
        return (Scheduler) apply(r0, r1);
    }

    @NonNull
    public static <T> Subscriber<? super T> onSubscribe(@NonNull Flowable<T> r1, @NonNull Subscriber<? super T> r2) {
        BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> r0 = onFlowableSubscribe;
        if (r0 != null) goto L5;
        return r2;
    L5:
        return (Subscriber) apply(r0, r1, r2);
    }

    public static void reset() {
        setErrorHandler(null);
        setScheduleHandler(null);
        setComputationSchedulerHandler(null);
        setInitComputationSchedulerHandler(null);
        setIoSchedulerHandler(null);
        setInitIoSchedulerHandler(null);
        setSingleSchedulerHandler(null);
        setInitSingleSchedulerHandler(null);
        setNewThreadSchedulerHandler(null);
        setInitNewThreadSchedulerHandler(null);
        setOnFlowableAssembly(null);
        setOnFlowableSubscribe(null);
        setOnObservableAssembly(null);
        setOnObservableSubscribe(null);
        setOnSingleAssembly(null);
        setOnSingleSubscribe(null);
        setOnCompletableAssembly(null);
        setOnCompletableSubscribe(null);
        setOnConnectableFlowableAssembly(null);
        setOnConnectableObservableAssembly(null);
        setOnMaybeAssembly(null);
        setOnMaybeSubscribe(null);
        setOnParallelAssembly(null);
        setFailOnNonBlockingScheduler(false);
        setOnBeforeBlocking(null);
    }

    public static void setComputationSchedulerHandler(@Nullable Function<? super Scheduler, ? extends Scheduler> r1) {
        if (lockdown == true) goto L7;
        onComputationHandler = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setErrorHandler(@Nullable Consumer<? super Throwable> r1) {
        if (lockdown == true) goto L7;
        errorHandler = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setFailOnNonBlockingScheduler(boolean r1) {
        if (lockdown == true) goto L7;
        failNonBlockingScheduler = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitComputationSchedulerHandler(@Nullable Function<? super Callable<Scheduler>, ? extends Scheduler> r1) {
        if (lockdown == true) goto L7;
        onInitComputationHandler = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitIoSchedulerHandler(@Nullable Function<? super Callable<Scheduler>, ? extends Scheduler> r1) {
        if (lockdown == true) goto L7;
        onInitIoHandler = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitNewThreadSchedulerHandler(@Nullable Function<? super Callable<Scheduler>, ? extends Scheduler> r1) {
        if (lockdown == true) goto L7;
        onInitNewThreadHandler = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitSingleSchedulerHandler(@Nullable Function<? super Callable<Scheduler>, ? extends Scheduler> r1) {
        if (lockdown == true) goto L7;
        onInitSingleHandler = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setIoSchedulerHandler(@Nullable Function<? super Scheduler, ? extends Scheduler> r1) {
        if (lockdown == true) goto L7;
        onIoHandler = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setNewThreadSchedulerHandler(@Nullable Function<? super Scheduler, ? extends Scheduler> r1) {
        if (lockdown == true) goto L7;
        onNewThreadHandler = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnBeforeBlocking(@Nullable BooleanSupplier r1) {
        if (lockdown == true) goto L7;
        onBeforeBlocking = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnCompletableAssembly(@Nullable Function<? super Completable, ? extends Completable> r1) {
        if (lockdown == true) goto L7;
        onCompletableAssembly = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnCompletableSubscribe(@Nullable BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> r1) {
        if (lockdown == true) goto L7;
        onCompletableSubscribe = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnConnectableFlowableAssembly(@Nullable Function<? super ConnectableFlowable, ? extends ConnectableFlowable> r1) {
        if (lockdown == true) goto L7;
        onConnectableFlowableAssembly = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnConnectableObservableAssembly(@Nullable Function<? super ConnectableObservable, ? extends ConnectableObservable> r1) {
        if (lockdown == true) goto L7;
        onConnectableObservableAssembly = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnFlowableAssembly(@Nullable Function<? super Flowable, ? extends Flowable> r1) {
        if (lockdown == true) goto L7;
        onFlowableAssembly = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnFlowableSubscribe(@Nullable BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> r1) {
        if (lockdown == true) goto L7;
        onFlowableSubscribe = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnMaybeAssembly(@Nullable Function<? super Maybe, ? extends Maybe> r1) {
        if (lockdown == true) goto L7;
        onMaybeAssembly = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnMaybeSubscribe(@Nullable BiFunction<? super Maybe, MaybeObserver, ? extends MaybeObserver> r1) {
        if (lockdown == true) goto L7;
        onMaybeSubscribe = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnObservableAssembly(@Nullable Function<? super Observable, ? extends Observable> r1) {
        if (lockdown == true) goto L7;
        onObservableAssembly = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnObservableSubscribe(@Nullable BiFunction<? super Observable, ? super Observer, ? extends Observer> r1) {
        if (lockdown == true) goto L7;
        onObservableSubscribe = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnParallelAssembly(@Nullable Function<? super ParallelFlowable, ? extends ParallelFlowable> r1) {
        if (lockdown == true) goto L7;
        onParallelAssembly = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnSingleAssembly(@Nullable Function<? super Single, ? extends Single> r1) {
        if (lockdown == true) goto L7;
        onSingleAssembly = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnSingleSubscribe(@Nullable BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> r1) {
        if (lockdown == true) goto L7;
        onSingleSubscribe = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setScheduleHandler(@Nullable Function<? super Runnable, ? extends Runnable> r1) {
        if (lockdown == true) goto L7;
        onScheduleHandler = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setSingleSchedulerHandler(@Nullable Function<? super Scheduler, ? extends Scheduler> r1) {
        if (lockdown == true) goto L7;
        onSingleHandler = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void uncaught(@NonNull Throwable r2) {
        Thread r0 = Thread.currentThread();
        r0.getUncaughtExceptionHandler().uncaughtException(r0, r2);
    }

    public static void unlock() {
        lockdown = false;
    }

    @NonNull
    public static <T, U, R> R apply(@NonNull BiFunction<T, U, R> r0, @NonNull T r1, @NonNull U r2) {
        return r0.apply(r1, r2);
    L4:
        th = move-exception;
        throw ExceptionHelper.wrapOrThrow(th);
    }

    @NonNull
    public static <T> Flowable<T> onAssembly(@NonNull Flowable<T> r1) {
        Function<? super Flowable, ? extends Flowable> r0 = onFlowableAssembly;
        if (r0 != null) goto L5;
        return r1;
    L5:
        return (Flowable) apply(r0, r1);
    }

    @NonNull
    public static <T> Observer<? super T> onSubscribe(@NonNull Observable<T> r1, @NonNull Observer<? super T> r2) {
        BiFunction<? super Observable, ? super Observer, ? extends Observer> r0 = onObservableSubscribe;
        if (r0 != null) goto L5;
        return r2;
    L5:
        return (Observer) apply(r0, r1, r2);
    }

    @NonNull
    public static <T> ConnectableFlowable<T> onAssembly(@NonNull ConnectableFlowable<T> r1) {
        Function<? super ConnectableFlowable, ? extends ConnectableFlowable> r0 = onConnectableFlowableAssembly;
        if (r0 != null) goto L5;
        return r1;
    L5:
        return (ConnectableFlowable) apply(r0, r1);
    }

    @NonNull
    public static <T> SingleObserver<? super T> onSubscribe(@NonNull Single<T> r1, @NonNull SingleObserver<? super T> r2) {
        BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> r0 = onSingleSubscribe;
        if (r0 != null) goto L5;
        return r2;
    L5:
        return (SingleObserver) apply(r0, r1, r2);
    }

    @NonNull
    public static <T> Observable<T> onAssembly(@NonNull Observable<T> r1) {
        Function<? super Observable, ? extends Observable> r0 = onObservableAssembly;
        if (r0 != null) goto L5;
        return r1;
    L5:
        return (Observable) apply(r0, r1);
    }

    @NonNull
    public static CompletableObserver onSubscribe(@NonNull Completable r1, @NonNull CompletableObserver r2) {
        BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> r0 = onCompletableSubscribe;
        if (r0 != null) goto L5;
        return r2;
    L5:
        return (CompletableObserver) apply(r0, r1, r2);
    }

    @NonNull
    public static <T> ConnectableObservable<T> onAssembly(@NonNull ConnectableObservable<T> r1) {
        Function<? super ConnectableObservable, ? extends ConnectableObservable> r0 = onConnectableObservableAssembly;
        if (r0 != null) goto L5;
        return r1;
    L5:
        return (ConnectableObservable) apply(r0, r1);
    }

    @NonNull
    public static <T> MaybeObserver<? super T> onSubscribe(@NonNull Maybe<T> r1, @NonNull MaybeObserver<? super T> r2) {
        BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> r0 = onMaybeSubscribe;
        if (r0 != null) goto L5;
        return r2;
    L5:
        return (MaybeObserver) apply(r0, r1, r2);
    }

    @NonNull
    public static <T> Single<T> onAssembly(@NonNull Single<T> r1) {
        Function<? super Single, ? extends Single> r0 = onSingleAssembly;
        if (r0 != null) goto L5;
        return r1;
    L5:
        return (Single) apply(r0, r1);
    }

    @NonNull
    public static Completable onAssembly(@NonNull Completable r1) {
        Function<? super Completable, ? extends Completable> r0 = onCompletableAssembly;
        if (r0 != null) goto L5;
        return r1;
    L5:
        return (Completable) apply(r0, r1);
    }

    @NonNull
    public static <T> ParallelFlowable<T> onAssembly(@NonNull ParallelFlowable<T> r1) {
        Function<? super ParallelFlowable, ? extends ParallelFlowable> r0 = onParallelAssembly;
        if (r0 != null) goto L5;
        return r1;
    L5:
        return (ParallelFlowable) apply(r0, r1);
    }
}
