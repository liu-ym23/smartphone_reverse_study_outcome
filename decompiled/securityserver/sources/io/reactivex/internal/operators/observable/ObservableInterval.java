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
public final class ObservableInterval extends Observable<Long> {
    final long initialDelay;
    final long period;
    final Scheduler scheduler;
    final TimeUnit unit;

    public static final class IntervalObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 346773832286157679L;
        long count;
        final Observer<? super Long> downstream;

        public IntervalObserver(Observer<? super Long> r1) {
            this.downstream = r1;
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
            if (get() == DisposableHelper.DISPOSED) goto L6;
            Observer<? super Long> r0 = this.downstream;
            long r1 = this.count;
            this.count = 1 + r1;
            r0.onNext(Long.valueOf(r1));
            return;
        }

        public void setResource(Disposable r1) {
            DisposableHelper.setOnce(this, r1);
        }
    }

    public ObservableInterval(long r1, long r3, TimeUnit r5, Scheduler r6) {
        this.initialDelay = r1;
        this.period = r3;
        this.unit = r5;
        this.scheduler = r6;
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
        IntervalObserver r7 = new IntervalObserver(r9);
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
