package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableTimeout<T, U, V> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<U> firstTimeoutIndicator;
    final Function<? super T, ? extends ObservableSource<V>> itemTimeoutIndicator;
    final ObservableSource<? extends T> other;

    public static final class TimeoutConsumer extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = 8708641127342403073L;
        final long idx;
        final TimeoutSelectorSupport parent;

        public TimeoutConsumer(long r1, TimeoutSelectorSupport r3) {
            this.idx = r1;
            this.parent = r3;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Object r0 = get();
            DisposableHelper r1 = DisposableHelper.DISPOSED;
            if (r0 == r1) goto L6;
            lazySet(r1);
            this.parent.onTimeout(this.idx);
            return;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r4) {
            Object r0 = get();
            DisposableHelper r1 = DisposableHelper.DISPOSED;
            if (r0 == r1) goto L5;
            lazySet(r1);
            this.parent.onTimeoutError(this.idx, r4);
            return;
        L5:
            RxJavaPlugins.onError(r4);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object r3) {
            Disposable r4 = (Disposable) get();
            DisposableHelper r0 = DisposableHelper.DISPOSED;
            if (r4 == r0) goto L6;
            r4.dispose();
            lazySet(r0);
            this.parent.onTimeout(this.idx);
            return;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this, r1);
        }
    }

    public static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, TimeoutSelectorSupport {
        private static final long serialVersionUID = -7508389464265974549L;
        final Observer<? super T> downstream;
        ObservableSource<? extends T> fallback;
        final AtomicLong index;
        final Function<? super T, ? extends ObservableSource<?>> itemTimeoutIndicator;
        final SequentialDisposable task;
        final AtomicReference<Disposable> upstream;

        public TimeoutFallbackObserver(Observer<? super T> r1, Function<? super T, ? extends ObservableSource<?>> r2, ObservableSource<? extends T> r3) {
            this.downstream = r1;
            this.itemTimeoutIndicator = r2;
            this.task = new SequentialDisposable();
            this.fallback = r3;
            this.index = new AtomicLong();
            this.upstream = new AtomicReference();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
            this.task.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
            this.task.dispose();
            this.downstream.onComplete();
            this.task.dispose();
            return;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r6) {
            if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
            this.task.dispose();
            this.downstream.onError(r6);
            this.task.dispose();
            return;
        L5:
            RxJavaPlugins.onError(r6);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r8) {
            long r0 = this.index.get();
            if (r0 == Long.MAX_VALUE) goto L22;
            long r5 = 1 + r0;
            if (this.index.compareAndSet(r0, r5) == false) goto L23;
            Disposable r1 = this.task.get();
            if (r1 == null) goto L10;
            r1.dispose();
        L10:
            this.downstream.onNext(r8);
            ObservableSource r9 = (ObservableSource) ObjectHelper.requireNonNull(this.itemTimeoutIndicator.apply(r8), "The itemTimeoutIndicator returned a null ObservableSource.");     // Catch: Throwable -> L16
            TimeoutConsumer r2 = new TimeoutConsumer(r5, this);
            if (this.task.replace(r2) == false) goto L21;
            r9.subscribe(r2);
            return;
        L21:
            return;
        L16:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.get().dispose();
            this.index.getAndSet(Long.MAX_VALUE);
            this.downstream.onError(th);
            return;
        L23:
            return;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this.upstream, r1);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.TimeoutSupport
        public void onTimeout(long r4) {
            if (this.index.compareAndSet(r4, Long.MAX_VALUE) == false) goto L6;
            DisposableHelper.dispose(this.upstream);
            ObservableSource<? extends T> r5 = this.fallback;
            this.fallback = null;
            r5.subscribe(new ObservableTimeoutTimed.FallbackObserver(this.downstream, this));
            return;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.TimeoutSelectorSupport
        public void onTimeoutError(long r4, Throwable r6) {
            if (this.index.compareAndSet(r4, Long.MAX_VALUE) == false) goto L5;
            DisposableHelper.dispose(this);
            this.downstream.onError(r6);
            return;
        L5:
            RxJavaPlugins.onError(r6);
        }

        public void startFirstTimeout(ObservableSource<?> r4) {
            if (r4 == null) goto L7;
            TimeoutConsumer r0 = new TimeoutConsumer(0, this);
            if (this.task.replace(r0) == false) goto L8;
            r4.subscribe(r0);
            return;
        L8:
            return;
        }
    }

    public static final class TimeoutObserver<T> extends AtomicLong implements Observer<T>, Disposable, TimeoutSelectorSupport {
        private static final long serialVersionUID = 3764492702657003550L;
        final Observer<? super T> downstream;
        final Function<? super T, ? extends ObservableSource<?>> itemTimeoutIndicator;
        final SequentialDisposable task;
        final AtomicReference<Disposable> upstream;

        public TimeoutObserver(Observer<? super T> r1, Function<? super T, ? extends ObservableSource<?>> r2) {
            this.downstream = r1;
            this.itemTimeoutIndicator = r2;
            this.task = new SequentialDisposable();
            this.upstream = new AtomicReference();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            this.task.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
            this.task.dispose();
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r5) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
            this.task.dispose();
            this.downstream.onError(r5);
            return;
        L5:
            RxJavaPlugins.onError(r5);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r7) {
            long r0 = get();
            if (r0 == Long.MAX_VALUE) goto L22;
            long r4 = 1 + r0;
            if (compareAndSet(r0, r4) == false) goto L23;
            Disposable r1 = this.task.get();
            if (r1 == null) goto L10;
            r1.dispose();
        L10:
            this.downstream.onNext(r7);
            ObservableSource r8 = (ObservableSource) ObjectHelper.requireNonNull(this.itemTimeoutIndicator.apply(r7), "The itemTimeoutIndicator returned a null ObservableSource.");     // Catch: Throwable -> L16
            TimeoutConsumer r2 = new TimeoutConsumer(r4, this);
            if (this.task.replace(r2) == false) goto L21;
            r8.subscribe(r2);
            return;
        L21:
            return;
        L16:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.get().dispose();
            getAndSet(Long.MAX_VALUE);
            this.downstream.onError(th);
            return;
        L23:
            return;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this.upstream, r1);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.TimeoutSupport
        public void onTimeout(long r3) {
            if (compareAndSet(r3, Long.MAX_VALUE) == false) goto L6;
            DisposableHelper.dispose(this.upstream);
            this.downstream.onError(new TimeoutException());
            return;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.TimeoutSelectorSupport
        public void onTimeoutError(long r3, Throwable r5) {
            if (compareAndSet(r3, Long.MAX_VALUE) == false) goto L5;
            DisposableHelper.dispose(this.upstream);
            this.downstream.onError(r5);
            return;
        L5:
            RxJavaPlugins.onError(r5);
        }

        public void startFirstTimeout(ObservableSource<?> r4) {
            if (r4 == null) goto L7;
            TimeoutConsumer r0 = new TimeoutConsumer(0, this);
            if (this.task.replace(r0) == false) goto L8;
            r4.subscribe(r0);
            return;
        L8:
            return;
        }
    }

    public interface TimeoutSelectorSupport extends ObservableTimeoutTimed.TimeoutSupport {
        void onTimeoutError(long r1, Throwable r3);
    }

    public ObservableTimeout(Observable<T> r1, ObservableSource<U> r2, Function<? super T, ? extends ObservableSource<V>> r3, ObservableSource<? extends T> r4) {
        super(r1);
        this.firstTimeoutIndicator = r2;
        this.itemTimeoutIndicator = r3;
        this.other = r4;
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
    public void subscribeActual(Observer<? super T> r4) {
        if (this.other != null) goto L5;
        TimeoutObserver r0 = new TimeoutObserver(r4, this.itemTimeoutIndicator);
        r4.onSubscribe(r0);
        r0.startFirstTimeout(this.firstTimeoutIndicator);
        this.source.subscribe(r0);
        return;
    L5:
        TimeoutFallbackObserver r1 = new TimeoutFallbackObserver(r4, this.itemTimeoutIndicator, this.other);
        r4.onSubscribe(r1);
        r1.startFirstTimeout(this.firstTimeoutIndicator);
        this.source.subscribe(r1);
    }
}
