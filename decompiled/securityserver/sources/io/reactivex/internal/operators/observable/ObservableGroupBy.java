package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.observables.GroupedObservable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableGroupBy<T, K, V> extends AbstractObservableWithUpstream<T, GroupedObservable<K, V>> {
    final int bufferSize;
    final boolean delayError;
    final Function<? super T, ? extends K> keySelector;
    final Function<? super T, ? extends V> valueSelector;

    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements Observer<T>, Disposable {
        static final Object NULL_KEY = null;
        private static final long serialVersionUID = -3688291656102519502L;
        final int bufferSize;
        final AtomicBoolean cancelled;
        final boolean delayError;
        final Observer<? super GroupedObservable<K, V>> downstream;
        final Map<Object, GroupedUnicast<K, V>> groups;
        final Function<? super T, ? extends K> keySelector;
        Disposable upstream;
        final Function<? super T, ? extends V> valueSelector;

        static {
            NULL_KEY = new Object();
        }

        public GroupByObserver(Observer<? super GroupedObservable<K, V>> r2, Function<? super T, ? extends K> r3, Function<? super T, ? extends V> r4, int r5, boolean r6) {
            this.cancelled = new AtomicBoolean();
            this.downstream = r2;
            this.keySelector = r3;
            this.valueSelector = r4;
            this.bufferSize = r5;
            this.delayError = r6;
            this.groups = new ConcurrentHashMap();
            lazySet(1);
        }

        public void cancel(K r2) {
            if (r2 != null) goto L5;
            r2 = (K) NULL_KEY;
        L5:
            this.groups.remove(r2);
            if (decrementAndGet() != 0) goto L9;
            this.upstream.dispose();
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            if (decrementAndGet() != 0) goto L9;
            this.upstream.dispose();
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ArrayList r0 = new ArrayList(this.groups.values());
            this.groups.clear();
            Iterator r1 = r0.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ((GroupedUnicast) r1.next()).onComplete();
            goto L4
        L6:
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r3) {
            ArrayList r0 = new ArrayList(this.groups.values());
            this.groups.clear();
            Iterator r1 = r0.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ((GroupedUnicast) r1.next()).onError(r3);
            goto L4
        L6:
            this.downstream.onError(r3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.Observer
        public void onNext(T r5) {
            K r0 = this.keySelector.apply(r5);     // Catch: Throwable -> L18
            if (r0 == null) goto L5;
            Object r1 = r0;
        L6:
            GroupedUnicast<K, V> r2 = this.groups.get(r1);
            GroupedUnicast r3 = r2;
            if (r2 == false) goto L9;
        L23:
            r3.onNext(ObjectHelper.requireNonNull(this.valueSelector.apply(r5), "The value supplied is null"));
            return;
        L15:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.dispose();
            onError(th);
            return;
        L9:
            if (this.cancelled.get() == false) goto L11;
            return;
        L11:
            GroupedUnicast<K, V> r4 = GroupedUnicast.createWith(r0, this.bufferSize, this, this.delayError);
            this.groups.put(r1, r4);
            getAndIncrement();
            this.downstream.onNext(r4);
            r3 = r4;
            goto L23
        L5:
            r1 = NULL_KEY;
        L18:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.dispose();
            onError(th);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }
    }

    public static final class GroupedUnicast<K, T> extends GroupedObservable<K, T> {
        final State<T, K> state;

        public GroupedUnicast(K r1, State<T, K> r2) {
            super(r1);
            this.state = r2;
        }

        public static <T, K> GroupedUnicast<K, T> createWith(K r1, int r2, GroupByObserver<?, K, T> r3, boolean r4) {
            return new GroupedUnicast(r1, new State(r2, r3, r1, r4));
        }

        public void onComplete() {
            this.state.onComplete();
        }

        public void onError(Throwable r1) {
            this.state.onError(r1);
        }

        public void onNext(T r1) {
            this.state.onNext(r1);
        }

        @Override // io.reactivex.Observable
        public void subscribeActual(Observer<? super T> r1) {
            this.state.subscribe(r1);
        }
    }

    public static final class State<T, K> extends AtomicInteger implements Disposable, ObservableSource<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final AtomicReference<Observer<? super T>> actual;
        final AtomicBoolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        final AtomicBoolean once;
        final GroupByObserver<?, K, T> parent;
        final SpscLinkedArrayQueue<T> queue;

        public State(int r2, GroupByObserver<?, K, T> r3, K r4, boolean r5) {
            this.cancelled = new AtomicBoolean();
            this.once = new AtomicBoolean();
            this.actual = new AtomicReference();
            this.queue = new SpscLinkedArrayQueue(r2);
            this.parent = r3;
            this.key = r4;
            this.delayError = r5;
        }

        public boolean checkTerminated(boolean r4, boolean r5, Observer<? super T> r6, boolean r7) {
            if (this.cancelled.get() == false) goto L6;
            this.queue.clear();
            this.parent.cancel(this.key);
            this.actual.lazySet(null);
            return true;
        L6:
            if (r4 == false) goto L21;
            if (r7 == false) goto L14;
            if (r5 == false) goto L23;
            Throwable r8 = this.error;
            this.actual.lazySet(null);
            if (r8 == null) goto L12;
            r6.onError(r8);
        L13:
            return true;
        L12:
            r6.onComplete();
            goto L13
        L23:
            return false;
        L14:
            Throwable r9 = this.error;
            if (r9 == null) goto L18;
            this.queue.clear();
            this.actual.lazySet(null);
            r6.onError(r9);
            return true;
        L18:
            if (r5 == false) goto L24;
            this.actual.lazySet(null);
            r6.onComplete();
            return true;
        L24:
            return false;
        L21:
            return false;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            if (getAndIncrement() != 0) goto L9;
            this.actual.lazySet(null);
            this.parent.cancel(this.key);
            return;
        }

        public void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            SpscLinkedArrayQueue<T> r0 = this.queue;
            boolean r1 = this.delayError;
            Observer<? super T> r2 = this.actual.get();
            int r4 = 1;
        L6:
            if (r2 == null) goto L17;
        L7:
            boolean r5 = this.done;
            T r6 = r0.poll();
            if (r6 != null) goto L10;
            boolean r7 = true;
        L12:
            if (checkTerminated(r5, r7, r2, r1) == true) goto L13;
            if (r7 == true) goto L17;
            r2.onNext(r6);
            goto L7
        L13:
            return;
        L10:
            r7 = false;
        L17:
            r4 = addAndGet(-r4);
            if (r4 == 0) goto L19;
            if (r2 != null) goto L6;
            r2 = this.actual.get();
            goto L6
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void onError(Throwable r1) {
            this.error = r1;
            this.done = true;
            drain();
        }

        public void onNext(T r2) {
            this.queue.offer(r2);
            drain();
        }

        @Override // io.reactivex.ObservableSource
        public void subscribe(Observer<? super T> r4) {
            if (this.once.compareAndSet(false, true) == false) goto L8;
            r4.onSubscribe(this);
            this.actual.lazySet(r4);
            if (this.cancelled.get() == false) goto L7;
            this.actual.lazySet(null);
            return;
        L7:
            drain();
            return;
        L8:
            EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), r4);
        }
    }

    public ObservableGroupBy(ObservableSource<T> r1, Function<? super T, ? extends K> r2, Function<? super T, ? extends V> r3, int r4, boolean r5) {
        super(r1);
        this.keySelector = r2;
        this.valueSelector = r3;
        this.bufferSize = r4;
        this.delayError = r5;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super GroupedObservable<K, V>> r9) {
        this.source.subscribe(new GroupByObserver(r9, this.keySelector, this.valueSelector, this.bufferSize, this.delayError));
    }
}
