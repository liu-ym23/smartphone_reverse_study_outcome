package io.reactivex.internal.schedulers;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Function;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public class SchedulerWhen extends Scheduler implements Disposable {
    static final Disposable DISPOSED = null;
    static final Disposable SUBSCRIBED = null;
    private final Scheduler actualScheduler;
    private Disposable disposable;
    private final FlowableProcessor<Flowable<Completable>> workerProcessor;

    static final class CreateWorkerFunction implements Function<ScheduledAction, Completable> {
        final Scheduler.Worker actualWorker;

        final class WorkerCompletable extends Completable {
            final ScheduledAction action;
            final /* synthetic */ CreateWorkerFunction this$0;

            WorkerCompletable(CreateWorkerFunction r1, ScheduledAction r2) {
                this.this$0 = r1;
                this.action = r2;
            }

            @Override // io.reactivex.Completable
            protected void subscribeActual(CompletableObserver r2) {
                r2.onSubscribe(this.action);
                this.action.call(this.this$0.actualWorker, r2);
            }
        }

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Completable apply(ScheduledAction r1) throws Exception {
            return apply2(r1);
        }

        CreateWorkerFunction(Scheduler.Worker r1) {
            this.actualWorker = r1;
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public Completable apply2(ScheduledAction r2) {
            return new WorkerCompletable(this, r2);
        }
    }

    static class DelayedAction extends ScheduledAction {
        private final Runnable action;
        private final long delayTime;
        private final TimeUnit unit;

        DelayedAction(Runnable r1, long r2, TimeUnit r4) {
            this.action = r1;
            this.delayTime = r2;
            this.unit = r4;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        protected Disposable callActual(Scheduler.Worker r4, CompletableObserver r5) {
            return r4.schedule(new OnCompletedAction(this.action, r5), this.delayTime, this.unit);
        }
    }

    static class ImmediateAction extends ScheduledAction {
        private final Runnable action;

        ImmediateAction(Runnable r1) {
            this.action = r1;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        protected Disposable callActual(Scheduler.Worker r2, CompletableObserver r3) {
            return r2.schedule(new OnCompletedAction(this.action, r3));
        }
    }

    static class OnCompletedAction implements Runnable {
        final Runnable action;
        final CompletableObserver actionCompletable;

        OnCompletedAction(Runnable r1, CompletableObserver r2) {
            this.action = r1;
            this.actionCompletable = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.action.run();     // Catch: Throwable -> L5
            this.actionCompletable.onComplete();
            return;
        L5:
            th = move-exception;
            this.actionCompletable.onComplete();
            throw th;
        }
    }

    static final class QueueWorker extends Scheduler.Worker {
        private final FlowableProcessor<ScheduledAction> actionProcessor;
        private final Scheduler.Worker actualWorker;
        private final AtomicBoolean unsubscribed;

        QueueWorker(FlowableProcessor<ScheduledAction> r1, Scheduler.Worker r2) {
            this.actionProcessor = r1;
            this.actualWorker = r2;
            this.unsubscribed = new AtomicBoolean();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.unsubscribed.compareAndSet(false, true) == false) goto L6;
            this.actionProcessor.onComplete();
            this.actualWorker.dispose();
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.unsubscribed.get();
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable r2, long r3, TimeUnit r5) {
            DelayedAction r0 = new DelayedAction(r2, r3, r5);
            this.actionProcessor.onNext(r0);
            return r0;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable r2) {
            ImmediateAction r0 = new ImmediateAction(r2);
            this.actionProcessor.onNext(r0);
            return r0;
        }
    }

    static abstract class ScheduledAction extends AtomicReference<Disposable> implements Disposable {
        protected abstract Disposable callActual(Scheduler.Worker r1, CompletableObserver r2);

        ScheduledAction() {
            super(SchedulerWhen.SUBSCRIBED);
        }

        void call(Scheduler.Worker r3, CompletableObserver r4) {
            Disposable r0 = get();
            if (r0 != SchedulerWhen.DISPOSED) goto L6;
            return;
        L6:
            if (r0 == SchedulerWhen.SUBSCRIBED) goto L8;
            return;
        L8:
            Disposable r5 = callActual(r3, r4);
            if (compareAndSet(SchedulerWhen.SUBSCRIBED, r5) == true) goto L12;
            r5.dispose();
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get().isDisposed();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Disposable r0 = SchedulerWhen.DISPOSED;
        L3:
            Disposable r1 = get();
            if (r1 == SchedulerWhen.DISPOSED) goto L5;
            if (compareAndSet(r1, r0) == false) goto L3;
            if (r1 == SchedulerWhen.SUBSCRIBED) goto L15;
            r1.dispose();
            return;
        L15:
            return;
        }
    }

    static final class SubscribedDisposable implements Disposable {
        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return false;
        }

        SubscribedDisposable() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SchedulerWhen(Function<Flowable<Flowable<Completable>>, Completable> r1, Scheduler r2) {
        this.actualScheduler = r2;
        FlowableProcessor r3 = UnicastProcessor.create().toSerialized();
        this.workerProcessor = r3;
        this.disposable = ((Completable) r1.apply(r3)).subscribe();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        throw ExceptionHelper.wrapOrThrow(th);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.disposable.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.disposable.isDisposed();
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        Scheduler.Worker r0 = this.actualScheduler.createWorker();
        FlowableProcessor<T> r1 = UnicastProcessor.create().toSerialized();
        Flowable<Completable> r2 = r1.map(new CreateWorkerFunction(r0));
        QueueWorker r3 = new QueueWorker(r1, r0);
        this.workerProcessor.onNext(r2);
        return r3;
    }

    static {
        SUBSCRIBED = new SubscribedDisposable();
        DISPOSED = Disposables.disposed();
    }
}
