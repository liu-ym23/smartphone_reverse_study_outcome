package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.observers.BasicFuseableObserver;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableFilter<T> extends AbstractObservableWithUpstream<T, T> {
    final Predicate<? super T> predicate;

    public static final class FilterObserver<T> extends BasicFuseableObserver<T, T> {
        final Predicate<? super T> filter;

        public FilterObserver(Observer<? super T> r1, Predicate<? super T> r2) {
            super(r1);
            this.filter = r2;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            if (this.sourceMode == 0) goto L12;
            this.downstream.onNext(null);
            return;
        L12:
            if (this.filter.test(r2) == false) goto L14;
            this.downstream.onNext((Object) r2);
            return;
        L14:
            return;
        L7:
            th = move-exception;
            fail(th);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
        L2:
            T r0 = this.qd.poll();
            if (r0 == null) goto L6;
            if (this.filter.test(r0) == false) goto L2;
        L6:
            return r0;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r1) {
            return transitiveBoundaryFusion(r1);
        }
    }

    public ObservableFilter(ObservableSource<T> r1, Predicate<? super T> r2) {
        super(r1);
        this.predicate = r2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r3) {
        this.source.subscribe(new FilterObserver(r3, this.predicate));
    }
}
