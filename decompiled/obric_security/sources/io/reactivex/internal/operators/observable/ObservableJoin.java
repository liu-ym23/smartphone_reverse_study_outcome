package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractObservableWithUpstream<TLeft, R> {
    final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> leftEnd;
    final ObservableSource<? extends TRight> other;
    final BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector;
    final Function<? super TRight, ? extends ObservableSource<TRightEnd>> rightEnd;

    static final class JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, ObservableGroupJoin.JoinSupport {
        static final Integer LEFT_CLOSE = null;
        static final Integer LEFT_VALUE = null;
        static final Integer RIGHT_CLOSE = null;
        static final Integer RIGHT_VALUE = null;
        private static final long serialVersionUID = -6071216598687999801L;
        final AtomicInteger active;
        volatile boolean cancelled;
        final CompositeDisposable disposables;
        final Observer<? super R> downstream;
        final AtomicReference<Throwable> error;
        final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> leftEnd;
        int leftIndex;
        final Map<Integer, TLeft> lefts;
        final SpscLinkedArrayQueue<Object> queue;
        final BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector;
        final Function<? super TRight, ? extends ObservableSource<TRightEnd>> rightEnd;
        int rightIndex;
        final Map<Integer, TRight> rights;

        static {
            LEFT_VALUE = 1;
            RIGHT_VALUE = 2;
            LEFT_CLOSE = 3;
            RIGHT_CLOSE = 4;
        }

        JoinDisposable(Observer<? super R> r2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> r3, Function<? super TRight, ? extends ObservableSource<TRightEnd>> r4, BiFunction<? super TLeft, ? super TRight, ? extends R> r5) {
            this.downstream = r2;
            this.disposables = new CompositeDisposable();
            this.queue = new SpscLinkedArrayQueue(Observable.bufferSize());
            this.lefts = new LinkedHashMap();
            this.rights = new LinkedHashMap();
            this.error = new AtomicReference();
            this.leftEnd = r3;
            this.rightEnd = r4;
            this.resultSelector = r5;
            this.active = new AtomicInteger(2);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() != 0) goto L9;
            this.queue.clear();
            return;
        L9:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        void cancelAll() {
            this.disposables.dispose();
        }

        void errorAll(Observer<?> r3) {
            Throwable r0 = ExceptionHelper.terminate(this.error);
            this.lefts.clear();
            this.rights.clear();
            r3.onError(r0);
        }

        void fail(Throwable r2, Observer<?> r3, SpscLinkedArrayQueue<?> r4) {
            Exceptions.throwIfFatal(r2);
            ExceptionHelper.addThrowable(this.error, r2);
            r4.clear();
            cancelAll();
            errorAll(r3);
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            SpscLinkedArrayQueue<?> r0 = this.queue;
            Observer<? super R> r1 = this.downstream;
            int r3 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            if (this.error.get() != null) goto L12;
            if (this.active.get() != 0) goto L17;
            boolean r4 = true;
        L18:
            Integer r6 = (Integer) r0.poll();
            if (r6 != null) goto L21;
            boolean r7 = true;
        L22:
            if (r4 == false) goto L26;
            if (r7 == false) goto L26;
            this.lefts.clear();
            this.rights.clear();
            this.disposables.dispose();
            r1.onComplete();
            return;
        L26:
            if (r7 == true) goto L27;
            Object r5 = r0.poll();
            if (r6 == LEFT_VALUE) goto L32;
            if (r6 == RIGHT_VALUE) goto L52;
            if (r6 == LEFT_CLOSE) goto L72;
            ObservableGroupJoin.LeftRightEndObserver r8 = (ObservableGroupJoin.LeftRightEndObserver) r5;
            this.rights.remove(Integer.valueOf(r8.index));
            this.disposables.remove(r8);
            goto L7
        L72:
            ObservableGroupJoin.LeftRightEndObserver r9 = (ObservableGroupJoin.LeftRightEndObserver) r5;
            this.lefts.remove(Integer.valueOf(r9.index));
            this.disposables.remove(r9);
            goto L7
        L52:
            int r10 = this.rightIndex;
            this.rightIndex = r10 + 1;
            this.rights.put(Integer.valueOf(r10), (TRight) r5);
            ObservableSource r11 = (ObservableSource) ObjectHelper.requireNonNull(this.rightEnd.apply(r5), "The rightEnd returned a null ObservableSource");     // Catch: Throwable -> L67
            ObservableGroupJoin.LeftRightEndObserver r12 = new ObservableGroupJoin.LeftRightEndObserver(this, false, r10);
            this.disposables.add(r12);
            r11.subscribe(r12);
            if (this.error.get() != null) goto L56;
            Iterator<TLeft> r13 = this.lefts.values().iterator();
        L60:
            if (r13.hasNext() == false) goto L7;
            r1.onNext((Object) ObjectHelper.requireNonNull(this.resultSelector.apply(r13.next(), r5), "The resultSelector returned a null value"));
        L64:
            th = move-exception;
            fail(th, r1, r0);
            return;
        L56:
            r0.clear();
            cancelAll();
            errorAll(r1);
            return;
        L67:
            th = move-exception;
            fail(th, r1, r0);
            return;
        L32:
            int r14 = this.leftIndex;
            this.leftIndex = r14 + 1;
            this.lefts.put(Integer.valueOf(r14), (TLeft) r5);
            ObservableSource r15 = (ObservableSource) ObjectHelper.requireNonNull(this.leftEnd.apply(r5), "The leftEnd returned a null ObservableSource");     // Catch: Throwable -> L47
            ObservableGroupJoin.LeftRightEndObserver r16 = new ObservableGroupJoin.LeftRightEndObserver(this, true, r14);
            this.disposables.add(r16);
            r15.subscribe(r16);
            if (this.error.get() != null) goto L36;
            Iterator<TRight> r17 = this.rights.values().iterator();
        L40:
            if (r17.hasNext() == false) goto L7;
            r1.onNext((Object) ObjectHelper.requireNonNull(this.resultSelector.apply(r5, r17.next()), "The resultSelector returned a null value"));
        L44:
            th = move-exception;
            fail(th, r1, r0);
            return;
        L36:
            r0.clear();
            cancelAll();
            errorAll(r1);
            return;
        L47:
            th = move-exception;
            fail(th, r1, r0);
            return;
        L27:
            r3 = addAndGet(-r3);
            if (r3 != 0) goto L7;
            return;
        L21:
            r7 = false;
            goto L22
        L17:
            r4 = false;
            goto L18
        L12:
            r0.clear();
            cancelAll();
            errorAll(r1);
            return;
        L8:
            r0.clear();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerError(Throwable r2) {
            if (ExceptionHelper.addThrowable(this.error, r2) == false) goto L5;
            this.active.decrementAndGet();
            drain();
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerComplete(ObservableGroupJoin.LeftRightObserver r2) {
            this.disposables.delete(r2);
            this.active.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerValue(boolean r2, Object r3) {
            monitor-enter(this);
            SpscLinkedArrayQueue<Object> r0 = this.queue;     // Catch: Throwable -> L11
            if (r2 == false) goto L6;
            Integer r4 = LEFT_VALUE;     // Catch: Throwable -> L11
        L7:
            r0.offer(r4, r3);     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            drain();
            return;
        L6:
            r4 = RIGHT_VALUE;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerClose(boolean r2, ObservableGroupJoin.LeftRightEndObserver r3) {
            monitor-enter(this);
            SpscLinkedArrayQueue<Object> r0 = this.queue;     // Catch: Throwable -> L11
            if (r2 == false) goto L6;
            Integer r4 = LEFT_CLOSE;     // Catch: Throwable -> L11
        L7:
            r0.offer(r4, r3);     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            drain();
            return;
        L6:
            r4 = RIGHT_CLOSE;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerCloseError(Throwable r2) {
            if (ExceptionHelper.addThrowable(this.error, r2) == false) goto L5;
            drain();
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }
    }

    public ObservableJoin(ObservableSource<TLeft> r1, ObservableSource<? extends TRight> r2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> r3, Function<? super TRight, ? extends ObservableSource<TRightEnd>> r4, BiFunction<? super TLeft, ? super TRight, ? extends R> r5) {
        super(r1);
        this.other = r2;
        this.leftEnd = r3;
        this.rightEnd = r4;
        this.resultSelector = r5;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> r5) {
        JoinDisposable r0 = new JoinDisposable(r5, this.leftEnd, this.rightEnd, this.resultSelector);
        r5.onSubscribe(r0);
        ObservableGroupJoin.LeftRightObserver r6 = new ObservableGroupJoin.LeftRightObserver(r0, true);
        r0.disposables.add(r6);
        ObservableGroupJoin.LeftRightObserver r1 = new ObservableGroupJoin.LeftRightObserver(r0, false);
        r0.disposables.add(r1);
        this.source.subscribe(r6);
        this.other.subscribe(r1);
    }
}
