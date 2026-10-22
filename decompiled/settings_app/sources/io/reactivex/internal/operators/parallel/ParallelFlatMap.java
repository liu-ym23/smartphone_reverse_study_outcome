package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes5.dex */
public final class ParallelFlatMap<T, R> extends ParallelFlowable<R> {
    final boolean delayError;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int maxConcurrency;
    final int prefetch;
    final ParallelFlowable<T> source;

    public ParallelFlatMap(ParallelFlowable<T> r1, Function<? super T, ? extends Publisher<? extends R>> r2, boolean r3, int r4, int r5) {
        this.source = r1;
        this.mapper = r2;
        this.delayError = r3;
        this.maxConcurrency = r4;
        this.prefetch = r5;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.source.parallelism();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super R>[] r9) {
        if (validate(r9) == true) goto L5;
        return;
    L5:
        int r0 = r9.length;
        Subscriber<? super T>[] r1 = new Subscriber[r0];
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        r1[r2] = FlowableFlatMap.subscribe(r9[r2], this.mapper, this.delayError, this.maxConcurrency, this.prefetch);
        r2 = r2 + 1;
        goto L6
    L8:
        this.source.subscribe(r1);
    }
}
