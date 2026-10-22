package io.reactivex.flowables;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableAutoConnect;
import io.reactivex.internal.operators.flowable.FlowablePublishAlt;
import io.reactivex.internal.operators.flowable.FlowablePublishClassic;
import io.reactivex.internal.operators.flowable.FlowableRefCount;
import io.reactivex.internal.util.ConnectConsumer;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ConnectableFlowable<T> extends Flowable<T> {
    public abstract void connect(Consumer<? super Disposable> r1);

    public ConnectableFlowable() {
    }

    public final Disposable connect() {
        ConnectConsumer r0 = new ConnectConsumer();
        connect(r0);
        return r0.disposable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ConnectableFlowable<T> onRefCount() {
        if ((this instanceof FlowablePublishClassic) == false) goto L6;
        FlowablePublishClassic r2 = (FlowablePublishClassic) this;
        return RxJavaPlugins.onAssembly(new FlowablePublishAlt(r2.publishSource(), r2.publishBufferSize()));
    L6:
        return this;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public Flowable<T> refCount() {
        return RxJavaPlugins.onAssembly(new FlowableRefCount(onRefCount()));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> refCount(int r7) {
        return refCount(r7, 0, TimeUnit.NANOSECONDS, Schedulers.trampoline());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> refCount(long r7, TimeUnit r9) {
        return refCount(1, r7, r9, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> refCount(long r7, TimeUnit r9, Scheduler r10) {
        return refCount(1, r7, r9, r10);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> refCount(int r7, long r8, TimeUnit r10) {
        return refCount(r7, r8, r10, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> refCount(int r9, long r10, TimeUnit r12, Scheduler r13) {
        ObjectHelper.verifyPositive(r9, "subscriberCount");
        ObjectHelper.requireNonNull(r12, "unit is null");
        ObjectHelper.requireNonNull(r13, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableRefCount(onRefCount(), r9, r10, r12, r13));
    }

    public Flowable<T> autoConnect() {
        return autoConnect(1);
    }

    public Flowable<T> autoConnect(int r2) {
        return autoConnect(r2, Functions.emptyConsumer());
    }

    public Flowable<T> autoConnect(int r2, Consumer<? super Disposable> r3) {
        if (r2 > 0) goto L6;
        connect(r3);
        return RxJavaPlugins.onAssembly(this);
    L6:
        return RxJavaPlugins.onAssembly(new FlowableAutoConnect(this, r2, r3));
    }
}
