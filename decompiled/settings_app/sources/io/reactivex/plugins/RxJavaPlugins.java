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

/* JADX INFO: loaded from: classes5.dex */
public final class RxJavaPlugins {
    static volatile Consumer<? super Throwable> errorHandler;
    static volatile boolean failNonBlockingScheduler;
    static volatile boolean lockdown;
    static volatile BooleanSupplier onBeforeBlocking;
    static volatile Function<? super Completable, ? extends Completable> onCompletableAssembly;
    static volatile BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> onCompletableSubscribe;
    static volatile Function<? super Scheduler, ? extends Scheduler> onComputationHandler;
    static volatile Function<? super ConnectableFlowable, ? extends ConnectableFlowable> onConnectableFlowableAssembly;
    static volatile Function<? super ConnectableObservable, ? extends ConnectableObservable> onConnectableObservableAssembly;
    static volatile Function<? super Flowable, ? extends Flowable> onFlowableAssembly;
    static volatile BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> onFlowableSubscribe;
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitComputationHandler;
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitIoHandler;
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitNewThreadHandler;
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitSingleHandler;
    static volatile Function<? super Scheduler, ? extends Scheduler> onIoHandler;
    static volatile Function<? super Maybe, ? extends Maybe> onMaybeAssembly;
    static volatile BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> onMaybeSubscribe;
    static volatile Function<? super Scheduler, ? extends Scheduler> onNewThreadHandler;
    static volatile Function<? super Observable, ? extends Observable> onObservableAssembly;
    static volatile BiFunction<? super Observable, ? super Observer, ? extends Observer> onObservableSubscribe;
    static volatile Function<? super ParallelFlowable, ? extends ParallelFlowable> onParallelAssembly;
    static volatile Function<? super Runnable, ? extends Runnable> onScheduleHandler;
    static volatile Function<? super Single, ? extends Single> onSingleAssembly;
    static volatile Function<? super Scheduler, ? extends Scheduler> onSingleHandler;
    static volatile BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> onSingleSubscribe;

    public static void lockdown() {
        lockdown = true;
    }

    public static boolean isLockdown() {
        return lockdown;
    }

    public static void setFailOnNonBlockingScheduler(boolean r1) {
        if (lockdown == true) goto L7;
        failNonBlockingScheduler = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static boolean isFailOnNonBlockingScheduler() {
        return failNonBlockingScheduler;
    }

    public static Function<? super Scheduler, ? extends Scheduler> getComputationSchedulerHandler() {
        return onComputationHandler;
    }

    public static Consumer<? super Throwable> getErrorHandler() {
        return errorHandler;
    }

    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitComputationSchedulerHandler() {
        return onInitComputationHandler;
    }

    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitIoSchedulerHandler() {
        return onInitIoHandler;
    }

    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitNewThreadSchedulerHandler() {
        return onInitNewThreadHandler;
    }

    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitSingleSchedulerHandler() {
        return onInitSingleHandler;
    }

    public static Function<? super Scheduler, ? extends Scheduler> getIoSchedulerHandler() {
        return onIoHandler;
    }

    public static Function<? super Scheduler, ? extends Scheduler> getNewThreadSchedulerHandler() {
        return onNewThreadHandler;
    }

    public static Function<? super Runnable, ? extends Runnable> getScheduleHandler() {
        return onScheduleHandler;
    }

    public static Function<? super Scheduler, ? extends Scheduler> getSingleSchedulerHandler() {
        return onSingleHandler;
    }

    public static Scheduler initComputationScheduler(Callable<Scheduler> r1) {
        ObjectHelper.requireNonNull(r1, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> r0 = onInitComputationHandler;
        if (r0 != null) goto L7;
        return callRequireNonNull(r1);
    L7:
        return applyRequireNonNull(r0, r1);
    }

    public static Scheduler initIoScheduler(Callable<Scheduler> r1) {
        ObjectHelper.requireNonNull(r1, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> r0 = onInitIoHandler;
        if (r0 != null) goto L7;
        return callRequireNonNull(r1);
    L7:
        return applyRequireNonNull(r0, r1);
    }

    public static Scheduler initNewThreadScheduler(Callable<Scheduler> r1) {
        ObjectHelper.requireNonNull(r1, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> r0 = onInitNewThreadHandler;
        if (r0 != null) goto L7;
        return callRequireNonNull(r1);
    L7:
        return applyRequireNonNull(r0, r1);
    }

    public static Scheduler initSingleScheduler(Callable<Scheduler> r1) {
        ObjectHelper.requireNonNull(r1, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> r0 = onInitSingleHandler;
        if (r0 != null) goto L7;
        return callRequireNonNull(r1);
    L7:
        return applyRequireNonNull(r0, r1);
    }

    public static Scheduler onComputationScheduler(Scheduler r1) {
        Function<? super Scheduler, ? extends Scheduler> r0 = onComputationHandler;
        if (r0 != null) goto L6;
        return r1;
    L6:
        return (Scheduler) apply(r0, r1);
    }

    public static void onError(Throwable r2) {
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

    static boolean isBug(Throwable r2) {
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

    static void uncaught(Throwable r2) {
        Thread r0 = Thread.currentThread();
        r0.getUncaughtExceptionHandler().uncaughtException(r0, r2);
    }

    public static Scheduler onIoScheduler(Scheduler r1) {
        Function<? super Scheduler, ? extends Scheduler> r0 = onIoHandler;
        if (r0 != null) goto L6;
        return r1;
    L6:
        return (Scheduler) apply(r0, r1);
    }

    public static Scheduler onNewThreadScheduler(Scheduler r1) {
        Function<? super Scheduler, ? extends Scheduler> r0 = onNewThreadHandler;
        if (r0 != null) goto L6;
        return r1;
    L6:
        return (Scheduler) apply(r0, r1);
    }

    public static Runnable onSchedule(Runnable r1) {
        ObjectHelper.requireNonNull(r1, "run is null");
        Function<? super Runnable, ? extends Runnable> r0 = onScheduleHandler;
        if (r0 != null) goto L6;
        return r1;
    L6:
        return (Runnable) apply(r0, r1);
    }

    public static Scheduler onSingleScheduler(Scheduler r1) {
        Function<? super Scheduler, ? extends Scheduler> r0 = onSingleHandler;
        if (r0 != null) goto L6;
        return r1;
    L6:
        return (Scheduler) apply(r0, r1);
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

    public static void setComputationSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> r1) {
        if (lockdown == true) goto L7;
        onComputationHandler = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setErrorHandler(Consumer<? super Throwable> r1) {
        if (lockdown == true) goto L7;
        errorHandler = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitComputationSchedulerHandler(Function<? super Callable<Scheduler>, ? extends Scheduler> r1) {
        if (lockdown == true) goto L7;
        onInitComputationHandler = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitIoSchedulerHandler(Function<? super Callable<Scheduler>, ? extends Scheduler> r1) {
        if (lockdown == true) goto L7;
        onInitIoHandler = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitNewThreadSchedulerHandler(Function<? super Callable<Scheduler>, ? extends Scheduler> r1) {
        if (lockdown == true) goto L7;
        onInitNewThreadHandler = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitSingleSchedulerHandler(Function<? super Callable<Scheduler>, ? extends Scheduler> r1) {
        if (lockdown == true) goto L7;
        onInitSingleHandler = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setIoSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> r1) {
        if (lockdown == true) goto L7;
        onIoHandler = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setNewThreadSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> r1) {
        if (lockdown == true) goto L7;
        onNewThreadHandler = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setScheduleHandler(Function<? super Runnable, ? extends Runnable> r1) {
        if (lockdown == true) goto L7;
        onScheduleHandler = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setSingleSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> r1) {
        if (lockdown == true) goto L7;
        onSingleHandler = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    static void unlock() {
        lockdown = false;
    }

    public static Function<? super Completable, ? extends Completable> getOnCompletableAssembly() {
        return onCompletableAssembly;
    }

    public static BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> getOnCompletableSubscribe() {
        return onCompletableSubscribe;
    }

    public static Function<? super Flowable, ? extends Flowable> getOnFlowableAssembly() {
        return onFlowableAssembly;
    }

    public static Function<? super ConnectableFlowable, ? extends ConnectableFlowable> getOnConnectableFlowableAssembly() {
        return onConnectableFlowableAssembly;
    }

    public static BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> getOnFlowableSubscribe() {
        return onFlowableSubscribe;
    }

    public static BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> getOnMaybeSubscribe() {
        return onMaybeSubscribe;
    }

    public static Function<? super Maybe, ? extends Maybe> getOnMaybeAssembly() {
        return onMaybeAssembly;
    }

    public static Function<? super Single, ? extends Single> getOnSingleAssembly() {
        return onSingleAssembly;
    }

    public static BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> getOnSingleSubscribe() {
        return onSingleSubscribe;
    }

    public static Function<? super Observable, ? extends Observable> getOnObservableAssembly() {
        return onObservableAssembly;
    }

    public static Function<? super ConnectableObservable, ? extends ConnectableObservable> getOnConnectableObservableAssembly() {
        return onConnectableObservableAssembly;
    }

    public static BiFunction<? super Observable, ? super Observer, ? extends Observer> getOnObservableSubscribe() {
        return onObservableSubscribe;
    }

    public static void setOnCompletableAssembly(Function<? super Completable, ? extends Completable> r1) {
        if (lockdown == true) goto L7;
        onCompletableAssembly = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnCompletableSubscribe(BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> r1) {
        if (lockdown == true) goto L7;
        onCompletableSubscribe = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnFlowableAssembly(Function<? super Flowable, ? extends Flowable> r1) {
        if (lockdown == true) goto L7;
        onFlowableAssembly = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnMaybeAssembly(Function<? super Maybe, ? extends Maybe> r1) {
        if (lockdown == true) goto L7;
        onMaybeAssembly = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnConnectableFlowableAssembly(Function<? super ConnectableFlowable, ? extends ConnectableFlowable> r1) {
        if (lockdown == true) goto L7;
        onConnectableFlowableAssembly = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnFlowableSubscribe(BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> r1) {
        if (lockdown == true) goto L7;
        onFlowableSubscribe = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnMaybeSubscribe(BiFunction<? super Maybe, MaybeObserver, ? extends MaybeObserver> r1) {
        if (lockdown == true) goto L7;
        onMaybeSubscribe = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnObservableAssembly(Function<? super Observable, ? extends Observable> r1) {
        if (lockdown == true) goto L7;
        onObservableAssembly = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnConnectableObservableAssembly(Function<? super ConnectableObservable, ? extends ConnectableObservable> r1) {
        if (lockdown == true) goto L7;
        onConnectableObservableAssembly = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnObservableSubscribe(BiFunction<? super Observable, ? super Observer, ? extends Observer> r1) {
        if (lockdown == true) goto L7;
        onObservableSubscribe = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnSingleAssembly(Function<? super Single, ? extends Single> r1) {
        if (lockdown == true) goto L7;
        onSingleAssembly = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnSingleSubscribe(BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> r1) {
        if (lockdown == true) goto L7;
        onSingleSubscribe = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static <T> Subscriber<? super T> onSubscribe(Flowable<T> r1, Subscriber<? super T> r2) {
        BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> r0 = onFlowableSubscribe;
        if (r0 != null) goto L5;
        return r2;
    L5:
        return (Subscriber) apply(r0, r1, r2);
    }

    public static <T> Observer<? super T> onSubscribe(Observable<T> r1, Observer<? super T> r2) {
        BiFunction<? super Observable, ? super Observer, ? extends Observer> r0 = onObservableSubscribe;
        if (r0 != null) goto L5;
        return r2;
    L5:
        return (Observer) apply(r0, r1, r2);
    }

    public static <T> SingleObserver<? super T> onSubscribe(Single<T> r1, SingleObserver<? super T> r2) {
        BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> r0 = onSingleSubscribe;
        if (r0 != null) goto L5;
        return r2;
    L5:
        return (SingleObserver) apply(r0, r1, r2);
    }

    public static CompletableObserver onSubscribe(Completable r1, CompletableObserver r2) {
        BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> r0 = onCompletableSubscribe;
        if (r0 != null) goto L5;
        return r2;
    L5:
        return (CompletableObserver) apply(r0, r1, r2);
    }

    public static <T> MaybeObserver<? super T> onSubscribe(Maybe<T> r1, MaybeObserver<? super T> r2) {
        BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> r0 = onMaybeSubscribe;
        if (r0 != null) goto L5;
        return r2;
    L5:
        return (MaybeObserver) apply(r0, r1, r2);
    }

    public static <T> Maybe<T> onAssembly(Maybe<T> r1) {
        Function<? super Maybe, ? extends Maybe> r0 = onMaybeAssembly;
        if (r0 != null) goto L5;
        return r1;
    L5:
        return (Maybe) apply(r0, r1);
    }

    public static <T> Flowable<T> onAssembly(Flowable<T> r1) {
        Function<? super Flowable, ? extends Flowable> r0 = onFlowableAssembly;
        if (r0 != null) goto L5;
        return r1;
    L5:
        return (Flowable) apply(r0, r1);
    }

    public static <T> ConnectableFlowable<T> onAssembly(ConnectableFlowable<T> r1) {
        Function<? super ConnectableFlowable, ? extends ConnectableFlowable> r0 = onConnectableFlowableAssembly;
        if (r0 != null) goto L5;
        return r1;
    L5:
        return (ConnectableFlowable) apply(r0, r1);
    }

    public static <T> Observable<T> onAssembly(Observable<T> r1) {
        Function<? super Observable, ? extends Observable> r0 = onObservableAssembly;
        if (r0 != null) goto L5;
        return r1;
    L5:
        return (Observable) apply(r0, r1);
    }

    public static <T> ConnectableObservable<T> onAssembly(ConnectableObservable<T> r1) {
        Function<? super ConnectableObservable, ? extends ConnectableObservable> r0 = onConnectableObservableAssembly;
        if (r0 != null) goto L5;
        return r1;
    L5:
        return (ConnectableObservable) apply(r0, r1);
    }

    public static <T> Single<T> onAssembly(Single<T> r1) {
        Function<? super Single, ? extends Single> r0 = onSingleAssembly;
        if (r0 != null) goto L5;
        return r1;
    L5:
        return (Single) apply(r0, r1);
    }

    public static Completable onAssembly(Completable r1) {
        Function<? super Completable, ? extends Completable> r0 = onCompletableAssembly;
        if (r0 != null) goto L5;
        return r1;
    L5:
        return (Completable) apply(r0, r1);
    }

    public static void setOnParallelAssembly(Function<? super ParallelFlowable, ? extends ParallelFlowable> r1) {
        if (lockdown == true) goto L7;
        onParallelAssembly = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static Function<? super ParallelFlowable, ? extends ParallelFlowable> getOnParallelAssembly() {
        return onParallelAssembly;
    }

    public static <T> ParallelFlowable<T> onAssembly(ParallelFlowable<T> r1) {
        Function<? super ParallelFlowable, ? extends ParallelFlowable> r0 = onParallelAssembly;
        if (r0 != null) goto L5;
        return r1;
    L5:
        return (ParallelFlowable) apply(r0, r1);
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

    public static void setOnBeforeBlocking(BooleanSupplier r1) {
        if (lockdown == true) goto L7;
        onBeforeBlocking = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static BooleanSupplier getOnBeforeBlocking() {
        return onBeforeBlocking;
    }

    public static Scheduler createComputationScheduler(ThreadFactory r2) {
        return new ComputationScheduler((ThreadFactory) ObjectHelper.requireNonNull(r2, "threadFactory is null"));
    }

    public static Scheduler createIoScheduler(ThreadFactory r2) {
        return new IoScheduler((ThreadFactory) ObjectHelper.requireNonNull(r2, "threadFactory is null"));
    }

    public static Scheduler createNewThreadScheduler(ThreadFactory r2) {
        return new NewThreadScheduler((ThreadFactory) ObjectHelper.requireNonNull(r2, "threadFactory is null"));
    }

    public static Scheduler createSingleScheduler(ThreadFactory r2) {
        return new SingleScheduler((ThreadFactory) ObjectHelper.requireNonNull(r2, "threadFactory is null"));
    }

    static <T, R> R apply(Function<T, R> r0, T r1) {
        return r0.apply(r1);
    L4:
        th = move-exception;
        throw ExceptionHelper.wrapOrThrow(th);
    }

    static <T, U, R> R apply(BiFunction<T, U, R> r0, T r1, U r2) {
        return r0.apply(r1, r2);
    L4:
        th = move-exception;
        throw ExceptionHelper.wrapOrThrow(th);
    }

    static Scheduler callRequireNonNull(Callable<Scheduler> r1) {
        return (Scheduler) ObjectHelper.requireNonNull(r1.call(), "Scheduler Callable result can't be null");
    L4:
        th = move-exception;
        throw ExceptionHelper.wrapOrThrow(th);
    }

    static Scheduler applyRequireNonNull(Function<? super Callable<Scheduler>, ? extends Scheduler> r0, Callable<Scheduler> r1) {
        return (Scheduler) ObjectHelper.requireNonNull(apply(r0, r1), "Scheduler Callable result can't be null");
    }

    private RxJavaPlugins() {
        throw new IllegalStateException("No instances!");
    }
}
