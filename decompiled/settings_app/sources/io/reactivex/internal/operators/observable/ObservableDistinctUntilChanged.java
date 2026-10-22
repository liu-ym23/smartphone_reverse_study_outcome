package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.observers.BasicFuseableObserver;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableDistinctUntilChanged<T, K> extends AbstractObservableWithUpstream<T, T> {
    final BiPredicate<? super K, ? super K> comparer;
    final Function<? super T, K> keySelector;

    static final class DistinctUntilChangedObserver<T, K> extends BasicFuseableObserver<T, T> {
        final BiPredicate<? super K, ? super K> comparer;
        boolean hasValue;
        final Function<? super T, K> keySelector;
        K last;

        DistinctUntilChangedObserver(Observer<? super T> r1, Function<? super T, K> r2, BiPredicate<? super K, ? super K> r3) {
            super(r1);
            this.keySelector = r2;
            this.comparer = r3;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.Observer
        public void onNext(T r4) {
            if (this.done == false) goto L6;
            return;
        L6:
            if (this.sourceMode == 0) goto L20;
            this.downstream.onNext((Object) r4);
            return;
        L20:
            K r0 = this.keySelector.apply(r4);     // Catch: Throwable -> L17
            if (this.hasValue == false) goto L14;
            boolean r1 = this.comparer.test(this.last, r0);     // Catch: Throwable -> L17
            this.last = r0;     // Catch: Throwable -> L17
            if (r1 == false) goto L15;
            return;
        L15:
            this.downstream.onNext((Object) r4);
            return;
        L14:
            this.hasValue = true;     // Catch: Throwable -> L17
            this.last = r0;     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            fail(th);
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r1) {
            return transitiveBoundaryFusion(r1);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
        L2:
            T r0 = this.qd.poll();
            if (r0 == null) goto L4;
            K r1 = this.keySelector.apply(r0);
            if (this.hasValue == false) goto L8;
            if (this.comparer.test(this.last, r1) == false) goto L12;
            this.last = r1;
            goto L2
        L12:
            this.last = r1;
            return r0;
        L8:
            this.hasValue = true;
            this.last = r1;
            return r0;
        L4:
            return null;
        }
    }

    public ObservableDistinctUntilChanged(ObservableSource<T> r1, Function<? super T, K> r2, BiPredicate<? super K, ? super K> r3) {
        super(r1);
        this.keySelector = r2;
        this.comparer = r3;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> r4) {
        this.source.subscribe(new DistinctUntilChangedObserver(r4, this.keySelector, this.comparer));
    }
}
