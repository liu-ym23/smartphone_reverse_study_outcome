package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableIntervalRange extends Flowable<Long> {
    final long end;
    final long initialDelay;
    final long period;
    final Scheduler scheduler;
    final long start;
    final TimeUnit unit;

    public static final class IntervalRangeSubscriber extends AtomicLong implements Subscription, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        long count;
        final Subscriber<? super Long> downstream;
        final long end;
        final AtomicReference<Disposable> resource;

        public IntervalRangeSubscriber(Subscriber<? super Long> r2, long r3, long r5) {
            this.resource = new AtomicReference();
            this.downstream = r2;
            this.count = r3;
            this.end = r5;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            DisposableHelper.dispose(this.resource);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.add(this, r2);
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            Disposable r0 = this.resource.get();
            DisposableHelper r1 = DisposableHelper.DISPOSED;
            if (r0 == r1) goto L18;
            long r2 = get();
            if (r2 == 0) goto L16;
            long r4 = this.count;
            this.downstream.onNext(Long.valueOf(r4));
            if (r4 == this.end) goto L9;
            this.count = r4 + 1;
            if (r2 == Long.MAX_VALUE) goto L19;
            decrementAndGet();
            return;
        L19:
            return;
        L9:
            if (this.resource.get() == r1) goto L11;
            this.downstream.onComplete();
        L11:
            DisposableHelper.dispose(this.resource);
            return;
        L16:
            this.downstream.onError(new MissingBackpressureException("Can't deliver value " + this.count + " due to lack of requests"));
            DisposableHelper.dispose(this.resource);
            return;
        }

        public void setResource(Disposable r1) {
            DisposableHelper.setOnce(this.resource, r1);
        }
    }

    public FlowableIntervalRange(long r1, long r3, long r5, long r7, TimeUnit r9, Scheduler r10) {
        this.initialDelay = r5;
        this.period = r7;
        this.unit = r9;
        this.scheduler = r10;
        this.start = r1;
        this.end = r3;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Long> r9) {
        IntervalRangeSubscriber r7 = new IntervalRangeSubscriber(r9, this.start, this.end);
        r9.onSubscribe(r7);
        Scheduler r0 = this.scheduler;
        if ((r0 instanceof TrampolineScheduler) == false) goto L5;
        Scheduler.Worker r1 = r0.createWorker();
        r7.setResource(r1);
        r1.schedulePeriodically(r7, this.initialDelay, this.period, this.unit);
        return;
    L5:
        r7.setResource(r0.schedulePeriodicallyDirect(r7, this.initialDelay, this.period, this.unit));
    }
}
