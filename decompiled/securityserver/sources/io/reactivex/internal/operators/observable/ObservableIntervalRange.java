package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableIntervalRange extends Observable<Long> {
    final long end;
    final long initialDelay;
    final long period;
    final Scheduler scheduler;
    final long start;
    final TimeUnit unit;

    public static final class IntervalRangeObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 1891866368734007884L;
        long count;
        final Observer<? super Long> downstream;
        final long end;

        public IntervalRangeObserver(Observer<? super Long> r1, long r2, long r4) {
            this.downstream = r1;
            this.count = r2;
            this.end = r4;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() != DisposableHelper.DISPOSED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (isDisposed() == true) goto L10;
            long r0 = this.count;
            this.downstream.onNext(Long.valueOf(r0));
            if (r0 != this.end) goto L8;
            DisposableHelper.dispose(this);
            this.downstream.onComplete();
            return;
        L8:
            this.count = r0 + 1;
            return;
        }

        public void setResource(Disposable r1) {
            DisposableHelper.setOnce(this, r1);
        }
    }

    public ObservableIntervalRange(long r1, long r3, long r5, long r7, TimeUnit r9, Scheduler r10) {
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
    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Long> r9) {
        IntervalRangeObserver r7 = new IntervalRangeObserver(r9, this.start, this.end);
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
