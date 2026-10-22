package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractObservableWithUpstream<TLeft, R> {
    final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> leftEnd;
    final ObservableSource<? extends TRight> other;
    final BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> resultSelector;
    final Function<? super TRight, ? extends ObservableSource<TRightEnd>> rightEnd;

    static final class GroupJoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, JoinSupport {
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
        final Map<Integer, UnicastSubject<TRight>> lefts;
        final SpscLinkedArrayQueue<Object> queue;
        final BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> resultSelector;
        final Function<? super TRight, ? extends ObservableSource<TRightEnd>> rightEnd;
        int rightIndex;
        final Map<Integer, TRight> rights;

        static {
            LEFT_VALUE = 1;
            RIGHT_VALUE = 2;
            LEFT_CLOSE = 3;
            RIGHT_CLOSE = 4;
        }

        GroupJoinDisposable(Observer<? super R> r2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> r3, Function<? super TRight, ? extends ObservableSource<TRightEnd>> r4, BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> r5) {
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
            if (this.cancelled == false) goto L5;
            return;
        L5:
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() != 0) goto L9;
            this.queue.clear();
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        void cancelAll() {
            this.disposables.dispose();
        }

        void errorAll(Observer<?> r4) {
            Throwable r0 = ExceptionHelper.terminate(this.error);
            Iterator<UnicastSubject<TRight>> r1 = this.lefts.values().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            r1.next().onError(r0);
            goto L4
        L6:
            this.lefts.clear();
            this.rights.clear();
            r4.onError(r0);
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
            if (r4 == false) goto L30;
            if (r7 == false) goto L30;
            Iterator<UnicastSubject<TRight>> r2 = this.lefts.values().iterator();
        L26:
            if (r2.hasNext() == false) goto L28;
            r2.next().onComplete();
            goto L26
        L28:
            this.lefts.clear();
            this.rights.clear();
            this.disposables.dispose();
            r1.onComplete();
            return;
        L30:
            if (r7 == true) goto L31;
            Object r5 = r0.poll();
            if (r6 == LEFT_VALUE) goto L36;
            if (r6 == RIGHT_VALUE) goto L55;
            if (r6 == LEFT_CLOSE) goto L70;
            if (r6 != RIGHT_CLOSE) goto L7;
            LeftRightEndObserver r8 = (LeftRightEndObserver) r5;
            this.rights.remove(Integer.valueOf(r8.index));
            this.disposables.remove(r8);
            goto L7
        L70:
            LeftRightEndObserver r9 = (LeftRightEndObserver) r5;
            UnicastSubject<TRight> r10 = this.lefts.remove(Integer.valueOf(r9.index));
            this.disposables.remove(r9);
            if (r10 == null) goto L7;
            r10.onComplete();
            goto L7
        L55:
            int r11 = this.rightIndex;
            this.rightIndex = r11 + 1;
            this.rights.put(Integer.valueOf(r11), (TRight) r5);
            ObservableSource r12 = (ObservableSource) ObjectHelper.requireNonNull(this.rightEnd.apply(r5), "The rightEnd returned a null ObservableSource");     // Catch: Throwable -> L65
            LeftRightEndObserver r13 = new LeftRightEndObserver(this, false, r11);
            this.disposables.add(r13);
            r12.subscribe(r13);
            if (this.error.get() != null) goto L59;
            Iterator<UnicastSubject<TRight>> r14 = this.lefts.values().iterator();
        L63:
            if (r14.hasNext() == false) goto L7;
            r14.next().onNext(r5);
            goto L63
        L59:
            r0.clear();
            cancelAll();
            errorAll(r1);
            return;
        L65:
            th = move-exception;
            fail(th, r1, r0);
            return;
        L36:
            UnicastSubject r15 = UnicastSubject.create();
            int r16 = this.leftIndex;
            this.leftIndex = r16 + 1;
            this.lefts.put(Integer.valueOf(r16), (UnicastSubject<TRight>) r15);
            ObservableSource r17 = (ObservableSource) ObjectHelper.requireNonNull(this.leftEnd.apply(r5), "The leftEnd returned a null ObservableSource");     // Catch: Throwable -> L50
            LeftRightEndObserver r18 = new LeftRightEndObserver(this, true, r16);
            this.disposables.add(r18);
            r17.subscribe(r18);
            if (this.error.get() != null) goto L40;
            r1.onNext((Object) ObjectHelper.requireNonNull(this.resultSelector.apply(r5, r15), "The resultSelector returned a null value"));
            Iterator<TRight> r19 = this.rights.values().iterator();
        L45:
            if (r19.hasNext() == false) goto L7;
            r15.onNext(r19.next());
        L47:
            th = move-exception;
            fail(th, r1, r0);
            return;
        L40:
            r0.clear();
            cancelAll();
            errorAll(r1);
            return;
        L50:
            th = move-exception;
            fail(th, r1, r0);
            return;
        L31:
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
        public void innerComplete(LeftRightObserver r2) {
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
        public void innerClose(boolean r2, LeftRightEndObserver r3) {
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

    interface JoinSupport {
        void innerClose(boolean r1, LeftRightEndObserver r2);

        void innerCloseError(Throwable r1);

        void innerComplete(LeftRightObserver r1);

        void innerError(Throwable r1);

        void innerValue(boolean r1, Object r2);
    }

    static final class LeftRightEndObserver extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = 1883890389173668373L;
        final int index;
        final boolean isLeft;
        final JoinSupport parent;

        LeftRightEndObserver(JoinSupport r1, boolean r2, int r3) {
            this.parent = r1;
            this.isLeft = r2;
            this.index = r3;
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
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this, r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object r2) {
            if (DisposableHelper.dispose(this) == false) goto L6;
            this.parent.innerClose(this.isLeft, this);
            return;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            this.parent.innerCloseError(r1);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.parent.innerClose(this.isLeft, this);
        }
    }

    static final class LeftRightObserver extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = 1883890389173668373L;
        final boolean isLeft;
        final JoinSupport parent;

        LeftRightObserver(JoinSupport r1, boolean r2) {
            this.parent = r1;
            this.isLeft = r2;
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
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this, r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object r2) {
            this.parent.innerValue(this.isLeft, r2);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            this.parent.innerError(r1);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.parent.innerComplete(this);
        }
    }

    public ObservableGroupJoin(ObservableSource<TLeft> r1, ObservableSource<? extends TRight> r2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> r3, Function<? super TRight, ? extends ObservableSource<TRightEnd>> r4, BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> r5) {
        super(r1);
        this.other = r2;
        this.leftEnd = r3;
        this.rightEnd = r4;
        this.resultSelector = r5;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> r5) {
        GroupJoinDisposable r0 = new GroupJoinDisposable(r5, this.leftEnd, this.rightEnd, this.resultSelector);
        r5.onSubscribe(r0);
        LeftRightObserver r6 = new LeftRightObserver(r0, true);
        r0.disposables.add(r6);
        LeftRightObserver r1 = new LeftRightObserver(r0, false);
        r0.disposables.add(r1);
        this.source.subscribe(r6);
        this.other.subscribe(r1);
    }
}
