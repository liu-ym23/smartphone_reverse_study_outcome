package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.subjects.UnicastSubject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableWindowTimed<T> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final int bufferSize;
    final long maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    public static final class WindowExactBoundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {
        final int bufferSize;
        long count;
        final long maxSize;
        long producerIndex;
        final boolean restartTimerOnMaxSize;
        final Scheduler scheduler;
        volatile boolean terminated;
        final AtomicReference<Disposable> timer;
        final long timespan;
        final TimeUnit unit;
        Disposable upstream;
        UnicastSubject<T> window;
        final Scheduler.Worker worker;

        public static final class ConsumerIndexHolder implements Runnable {
            final long index;
            final WindowExactBoundedObserver<?> parent;

            public ConsumerIndexHolder(long r1, WindowExactBoundedObserver<?> r3) {
                this.index = r1;
                this.parent = r3;
            }

            @Override // java.lang.Runnable
            public void run() {
                WindowExactBoundedObserver<?> r0 = this.parent;
                if (WindowExactBoundedObserver.access$000(r0) == true) goto L5;
                WindowExactBoundedObserver.access$100(r0).offer(this);
            L7:
                if (r0.enter() == false) goto L10;
                r0.drainLoop();
                return;
            L10:
                return;
            L5:
                r0.terminated = true;
                r0.disposeTimer();
                goto L7
            }
        }

        public WindowExactBoundedObserver(Observer<? super Observable<T>> r2, long r3, TimeUnit r5, Scheduler r6, int r7, long r8, boolean r10) {
            super(r2, new MpscLinkedQueue());
            this.timer = new AtomicReference();
            this.timespan = r3;
            this.unit = r5;
            this.scheduler = r6;
            this.bufferSize = r7;
            this.maxSize = r8;
            this.restartTimerOnMaxSize = r10;
            if (r10 == false) goto L5;
            this.worker = r6.createWorker();
            return;
        L5:
            this.worker = null;
        }

        public static /* synthetic */ boolean access$000(WindowExactBoundedObserver r0) {
            return r0.cancelled;
        }

        public static /* synthetic */ SimplePlainQueue access$100(WindowExactBoundedObserver r0) {
            return r0.queue;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }

        public void disposeTimer() {
            DisposableHelper.dispose(this.timer);
            Scheduler.Worker r1 = this.worker;
            if (r1 == null) goto L6;
            r1.dispose();
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [io.reactivex.subjects.UnicastSubject<T>] */
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
        public void drainLoop() {
            MpscLinkedQueue r0 = (MpscLinkedQueue) this.queue;
            Observer<? super V> r1 = this.downstream;
            UnicastSubject<T> r2 = this.window;
            int r4 = 1;
        L4:
            if (this.terminated == true) goto L5;
            boolean r5 = this.done;
            Object r6 = r0.poll();
            if (r6 != null) goto L10;
            boolean r7 = true;
        L11:
            boolean r8 = r6 instanceof ConsumerIndexHolder;
            if (r5 == false) goto L20;
            if (r7 == true) goto L15;
            if (r8 == false) goto L20;
        L15:
            this.window = null;
            r0.clear();
            disposeTimer();
            Throwable r13 = this.error;
            if (r13 == null) goto L18;
            r2.onError(r13);
            return;
        L18:
            r2.onComplete();
            return;
        L20:
            if (r7 == true) goto L21;
            if (r8 == true) goto L26;
            r2.onNext(NotificationLite.getValue(r6));
            long r9 = this.count + 1;
            if (r9 >= this.maxSize) goto L33;
            this.count = r9;
            goto L4
        L33:
            this.producerIndex++;
            this.count = 0;
            r2.onComplete();
            r2 = (UnicastSubject<T>) UnicastSubject.create(this.bufferSize);
            this.window = r2;
            this.downstream.onNext(r2);
            if (this.restartTimerOnMaxSize == false) goto L4;
            Disposable r10 = this.timer.get();
            r10.dispose();
            Scheduler.Worker r11 = this.worker;
            ConsumerIndexHolder r12 = new ConsumerIndexHolder(this.producerIndex, this);
            long r14 = this.timespan;
            Disposable r15 = r11.schedulePeriodically(r12, r14, r14, this.unit);
            if (this.timer.compareAndSet(r10, r15) == true) goto L4;
            r15.dispose();
            goto L4
        L26:
            ConsumerIndexHolder r16 = (ConsumerIndexHolder) r6;
            if (this.restartTimerOnMaxSize == true) goto L30;
            if (this.producerIndex != r16.index) goto L4;
        L30:
            r2.onComplete();
            this.count = 0;
            r2 = (UnicastSubject<T>) UnicastSubject.create(this.bufferSize);
            this.window = r2;
            r1.onNext(r2);
            goto L4
        L21:
            r4 = leave(-r4);
            if (r4 != 0) goto L4;
            return;
        L10:
            r7 = false;
            goto L11
        L5:
            this.upstream.dispose();
            r0.clear();
            disposeTimer();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            if (enter() == false) goto L5;
            drainLoop();
        L5:
            this.downstream.onComplete();
            disposeTimer();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            this.error = r2;
            this.done = true;
            if (enter() == false) goto L5;
            drainLoop();
        L5:
            this.downstream.onError(r2);
            disposeTimer();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.Observer
        public void onNext(T r8) {
            if (this.terminated == false) goto L6;
            return;
        L6:
            if (fastEnter() == false) goto L16;
            UnicastSubject<T> r0 = this.window;
            r0.onNext(r8);
            long r1 = this.count + 1;
            if (r1 < this.maxSize) goto L12;
            this.producerIndex++;
            this.count = 0;
            r0.onComplete();
            UnicastSubject<T> r9 = UnicastSubject.create(this.bufferSize);
            this.window = r9;
            this.downstream.onNext(r9);
            if (this.restartTimerOnMaxSize == false) goto L14;
            this.timer.get().dispose();
            Scheduler.Worker r2 = this.worker;
            ConsumerIndexHolder r3 = new ConsumerIndexHolder(this.producerIndex, this);
            long r4 = this.timespan;
            DisposableHelper.replace(this.timer, r2.schedulePeriodically(r3, r4, r4, this.unit));
        L14:
            if (leave(-1) != 0) goto L19;
            return;
        L19:
            drainLoop();
            return;
        L12:
            this.count = r1;
            goto L14
        L16:
            this.queue.offer((U) NotificationLite.next(r8));
            if (enter() == true) goto L19;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r9) {
            if (DisposableHelper.validate(this.upstream, r9) == false) goto L13;
            this.upstream = r9;
            Observer<? super V> r10 = this.downstream;
            r10.onSubscribe(this);
            if (this.cancelled == false) goto L7;
            return;
        L7:
            UnicastSubject<T> r0 = UnicastSubject.create(this.bufferSize);
            this.window = r0;
            r10.onNext(r0);
            ConsumerIndexHolder r2 = new ConsumerIndexHolder(this.producerIndex, this);
            if (this.restartTimerOnMaxSize == false) goto L10;
            Scheduler.Worker r1 = this.worker;
            long r5 = this.timespan;
            Disposable r11 = r1.schedulePeriodically(r2, r5, r5, this.unit);
        L11:
            DisposableHelper.replace(this.timer, r11);
            return;
        L10:
            Scheduler r3 = this.scheduler;
            long r6 = this.timespan;
            r11 = r3.schedulePeriodicallyDirect(r2, r6, r6, this.unit);
            goto L11
        }
    }

    public static final class WindowExactUnboundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Observer<T>, Disposable, Runnable {
        static final Object NEXT = null;
        final int bufferSize;
        final Scheduler scheduler;
        volatile boolean terminated;
        final AtomicReference<Disposable> timer;
        final long timespan;
        final TimeUnit unit;
        Disposable upstream;
        UnicastSubject<T> window;

        static {
            NEXT = new Object();
        }

        public WindowExactUnboundedObserver(Observer<? super Observable<T>> r2, long r3, TimeUnit r5, Scheduler r6, int r7) {
            super(r2, new MpscLinkedQueue());
            this.timer = new AtomicReference();
            this.timespan = r3;
            this.unit = r5;
            this.scheduler = r6;
            this.bufferSize = r7;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }

        public void disposeTimer() {
            DisposableHelper.dispose(this.timer);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [io.reactivex.subjects.UnicastSubject<T>] */
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
        public void drainLoop() {
            MpscLinkedQueue r0 = (MpscLinkedQueue) this.queue;
            Observer<? super V> r1 = this.downstream;
            UnicastSubject<T> r2 = this.window;
            int r3 = 1;
        L3:
            boolean r4 = this.terminated;
            boolean r5 = this.done;
            Object r6 = r0.poll();
            if (r5 == false) goto L13;
            if (r6 == null) goto L8;
            if (r6 != NEXT) goto L13;
        L8:
            this.window = null;
            r0.clear();
            disposeTimer();
            Throwable r7 = this.error;
            if (r7 == null) goto L11;
            r2.onError(r7);
            return;
        L11:
            r2.onComplete();
            return;
        L13:
            if (r6 == null) goto L14;
            if (r6 == NEXT) goto L19;
            UnicastSubject<T> r8 = r2;
            r8.onNext(NotificationLite.getValue(r6));
            goto L3
        L19:
            r2.onComplete();
            if (r4 == false) goto L21;
            this.upstream.dispose();
            goto L3
        L21:
            r2 = (UnicastSubject<T>) UnicastSubject.create(this.bufferSize);
            this.window = r2;
            r1.onNext(r2);
            goto L3
        L14:
            r3 = leave(-r3);
            if (r3 != 0) goto L3;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            if (enter() == false) goto L5;
            drainLoop();
        L5:
            disposeTimer();
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            this.error = r2;
            this.done = true;
            if (enter() == false) goto L5;
            drainLoop();
        L5:
            disposeTimer();
            this.downstream.onError(r2);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            if (this.terminated == false) goto L6;
            return;
        L6:
            if (fastEnter() == false) goto L10;
            this.window.onNext(r2);
            if (leave(-1) != 0) goto L13;
            return;
        L13:
            drainLoop();
            return;
        L10:
            this.queue.offer((U) NotificationLite.next(r2));
            if (enter() == true) goto L13;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r8) {
            if (DisposableHelper.validate(this.upstream, r8) == false) goto L8;
            this.upstream = r8;
            this.window = UnicastSubject.create(this.bufferSize);
            Observer<? super V> r9 = this.downstream;
            r9.onSubscribe(this);
            r9.onNext(this.window);
            if (this.cancelled == true) goto L9;
            Scheduler r0 = this.scheduler;
            long r4 = this.timespan;
            Disposable r10 = r0.schedulePeriodicallyDirect(this, r4, r4, this.unit);
            DisposableHelper.replace(this.timer, r10);
            return;
        L9:
            return;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled == false) goto L5;
            this.terminated = true;
            disposeTimer();
        L5:
            this.queue.offer((U) NEXT);
            if (enter() == false) goto L9;
            drainLoop();
            return;
        }
    }

    public static final class WindowSkipObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable, Runnable {
        final int bufferSize;
        volatile boolean terminated;
        final long timeskip;
        final long timespan;
        final TimeUnit unit;
        Disposable upstream;
        final List<UnicastSubject<T>> windows;
        final Scheduler.Worker worker;

        public final class CompletionTask implements Runnable {
            final /* synthetic */ WindowSkipObserver this$0;
            private final UnicastSubject<T> w;

            public CompletionTask(WindowSkipObserver r1, UnicastSubject<T> r2) {
                this.this$0 = r1;
                this.w = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.this$0.complete(this.w);
            }
        }

        public static final class SubjectWork<T> {
            final boolean open;
            final UnicastSubject<T> w;

            public SubjectWork(UnicastSubject<T> r1, boolean r2) {
                this.w = r1;
                this.open = r2;
            }
        }

        public WindowSkipObserver(Observer<? super Observable<T>> r2, long r3, long r5, TimeUnit r7, Scheduler.Worker r8, int r9) {
            super(r2, new MpscLinkedQueue());
            this.timespan = r3;
            this.timeskip = r5;
            this.unit = r7;
            this.worker = r8;
            this.bufferSize = r9;
            this.windows = new LinkedList();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public void complete(UnicastSubject<T> r4) {
            this.queue.offer((U) new SubjectWork(r4, false));
            if (enter() == false) goto L6;
            drainLoop();
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }

        public void disposeWorker() {
            this.worker.dispose();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public void drainLoop() {
            MpscLinkedQueue r0 = (MpscLinkedQueue) this.queue;
            Observer<? super V> r1 = this.downstream;
            List<UnicastSubject<T>> r2 = this.windows;
            int r4 = 1;
        L4:
            if (this.terminated == true) goto L5;
            boolean r5 = this.done;
            Object r6 = r0.poll();
            if (r6 != null) goto L10;
            boolean r7 = true;
        L11:
            boolean r8 = r6 instanceof SubjectWork;
            if (r5 == false) goto L27;
            if (r7 == true) goto L15;
            if (r8 == false) goto L27;
        L15:
            r0.clear();
            Throwable r3 = this.error;
            if (r3 == null) goto L21;
            Iterator<UnicastSubject<T>> r9 = r2.iterator();
        L19:
            if (r9.hasNext() == false) goto L25;
            r9.next().onError(r3);
        L25:
            disposeWorker();
            r2.clear();
            return;
        L21:
            Iterator<UnicastSubject<T>> r10 = r2.iterator();
        L23:
            if (r10.hasNext() == false) goto L25;
            r10.next().onComplete();
        L27:
            if (r7 == true) goto L28;
            if (r8 == true) goto L32;
            Iterator<UnicastSubject<T>> r11 = r2.iterator();
        L45:
            if (r11.hasNext() == false) goto L4;
            r11.next().onNext(r6);
            goto L45
        L32:
            SubjectWork r12 = (SubjectWork) r6;
            if (r12.open == true) goto L35;
            r2.remove(r12.w);
            r12.w.onComplete();
            if (r2.isEmpty() == false) goto L4;
            if (this.cancelled == false) goto L4;
            this.terminated = true;
            goto L4
        L35:
            if (this.cancelled == true) goto L4;
            UnicastSubject<T> r13 = UnicastSubject.create(this.bufferSize);
            r2.add(r13);
            r1.onNext(r13);
            this.worker.schedule(new CompletionTask(this, r13), this.timespan, this.unit);
            goto L4
        L28:
            r4 = leave(-r4);
            if (r4 != 0) goto L4;
            return;
        L10:
            r7 = false;
            goto L11
        L5:
            this.upstream.dispose();
            disposeWorker();
            r0.clear();
            r2.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            if (enter() == false) goto L5;
            drainLoop();
        L5:
            this.downstream.onComplete();
            disposeWorker();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            this.error = r2;
            this.done = true;
            if (enter() == false) goto L5;
            drainLoop();
        L5:
            this.downstream.onError(r2);
            disposeWorker();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.Observer
        public void onNext(T r3) {
            if (fastEnter() == false) goto L11;
            Iterator<UnicastSubject<T>> r0 = this.windows.iterator();
        L6:
            if (r0.hasNext() == false) goto L9;
            r0.next().onNext(r3);
            goto L6
        L9:
            if (leave(-1) != 0) goto L14;
            return;
        L14:
            drainLoop();
            return;
        L11:
            this.queue.offer((U) r3);
            if (enter() == true) goto L14;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r12) {
            if (DisposableHelper.validate(this.upstream, r12) == false) goto L9;
            this.upstream = r12;
            this.downstream.onSubscribe(this);
            if (this.cancelled == false) goto L7;
            return;
        L7:
            UnicastSubject<T> r13 = UnicastSubject.create(this.bufferSize);
            this.windows.add(r13);
            this.downstream.onNext(r13);
            this.worker.schedule(new CompletionTask(this, r13), this.timespan, this.unit);
            Scheduler.Worker r4 = this.worker;
            long r8 = this.timeskip;
            r4.schedulePeriodically(this, r8, r8, this.unit);
            return;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.lang.Runnable
        public void run() {
            Object r1 = new SubjectWork(UnicastSubject.create(this.bufferSize), true);
            if (this.cancelled == true) goto L6;
            this.queue.offer((U) r1);
        L6:
            if (enter() == false) goto L9;
            drainLoop();
            return;
        }
    }

    public ObservableWindowTimed(ObservableSource<T> r1, long r2, long r4, TimeUnit r6, Scheduler r7, long r8, int r10, boolean r11) {
        super(r1);
        this.timespan = r2;
        this.timeskip = r4;
        this.unit = r6;
        this.scheduler = r7;
        this.maxSize = r8;
        this.bufferSize = r10;
        this.restartTimerOnMaxSize = r11;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> r12) {
        SerializedObserver r1 = new SerializedObserver(r12);
        long r2 = this.timespan;
        long r4 = this.timeskip;
        if (r2 != r4) goto L10;
        long r7 = this.maxSize;
        if (r7 != Long.MAX_VALUE) goto L8;
        this.source.subscribe(new WindowExactUnboundedObserver(r1, r2, this.unit, this.scheduler, this.bufferSize));
        return;
    L8:
        this.source.subscribe(new WindowExactBoundedObserver(r1, r2, this.unit, this.scheduler, this.bufferSize, r7, this.restartTimerOnMaxSize));
        return;
    L10:
        this.source.subscribe(new WindowSkipObserver(r1, r2, r4, this.unit, this.scheduler.createWorker(), this.bufferSize));
    }
}
