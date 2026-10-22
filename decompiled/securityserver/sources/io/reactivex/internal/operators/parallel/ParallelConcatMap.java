package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public final class ParallelConcatMap<T, R> extends ParallelFlowable<R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int prefetch;
    final ParallelFlowable<T> source;

    public ParallelConcatMap(ParallelFlowable<T> r1, Function<? super T, ? extends Publisher<? extends R>> r2, int r3, ErrorMode r4) {
        this.source = r1;
        this.mapper = (Function) ObjectHelper.requireNonNull(r2, "mapper");
        this.prefetch = r3;
        this.errorMode = (ErrorMode) ObjectHelper.requireNonNull(r4, "errorMode");
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.source.parallelism();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super R>[] r8) {
        if (validate(r8) == true) goto L5;
        return;
    L5:
        int r0 = r8.length;
        Subscriber<? super T>[] r1 = new Subscriber[r0];
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        r1[r2] = FlowableConcatMap.subscribe(r8[r2], this.mapper, this.prefetch, this.errorMode);
        r2 = r2 + 1;
        goto L6
    L8:
        this.source.subscribe(r1);
    }
}
