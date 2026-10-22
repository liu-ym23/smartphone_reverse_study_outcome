package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicFuseableObserver;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    final Function<? super T, ? extends U> function;

    public static final class MapObserver<T, U> extends BasicFuseableObserver<T, U> {
        final Function<? super T, ? extends U> mapper;

        public MapObserver(Observer<? super U> r1, Function<? super T, ? extends U> r2) {
            super(r1);
            this.mapper = r2;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            if (this.done == false) goto L6;
            return;
        L6:
            if (this.sourceMode == 0) goto L15;
            this.downstream.onNext(null);
            return;
        L15:
            Object r3 = ObjectHelper.requireNonNull(this.mapper.apply(r2), "The mapper function returned a null value.");     // Catch: Throwable -> L12
            this.downstream.onNext((Object) r3);
            return;
        L12:
            th = move-exception;
            fail(th);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public U poll() {
            T r0 = this.qd.poll();
            if (r0 != null) goto L7;
            return null;
        L7:
            return (U) ObjectHelper.requireNonNull(this.mapper.apply(r0), "The mapper function returned a null value.");
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r1) {
            return transitiveBoundaryFusion(r1);
        }
    }

    public ObservableMap(ObservableSource<T> r1, Function<? super T, ? extends U> r2) {
        super(r1);
        this.function = r2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super U> r3) {
        this.source.subscribe(new MapObserver(r3, this.function));
    }
}
