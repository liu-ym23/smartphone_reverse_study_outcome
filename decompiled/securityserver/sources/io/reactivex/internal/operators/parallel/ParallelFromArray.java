package io.reactivex.internal.operators.parallel;

import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public final class ParallelFromArray<T> extends ParallelFlowable<T> {
    final Publisher<T>[] sources;

    public ParallelFromArray(Publisher<T>[] r1) {
        this.sources = r1;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.sources.length;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super T>[] r5) {
        if (validate(r5) == true) goto L5;
        return;
    L5:
        int r0 = r5.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L8;
        this.sources[r1].subscribe(r5[r1]);
        r1 = r1 + 1;
        goto L6
    }
}
