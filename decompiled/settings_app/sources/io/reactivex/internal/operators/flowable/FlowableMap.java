package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableMap<T, U> extends AbstractFlowableWithUpstream<T, U> {
    final Function<? super T, ? extends U> mapper;

    static final class MapConditionalSubscriber<T, U> extends BasicFuseableConditionalSubscriber<T, U> {
        final Function<? super T, ? extends U> mapper;

        MapConditionalSubscriber(ConditionalSubscriber<? super U> r1, Function<? super T, ? extends U> r2) {
            super(r1);
            this.mapper = r2;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // org.reactivestreams.Subscriber
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

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T r2) {
            if (this.done == false) goto L12;
            return false;
        L12:
            Object r3 = ObjectHelper.requireNonNull(this.mapper.apply(r2), "The mapper function returned a null value.");     // Catch: Throwable -> L9
            return this.downstream.tryOnNext((Object) r3);
        L9:
            th = move-exception;
            fail(th);
            return true;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r1) {
            return transitiveBoundaryFusion(r1);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public U poll() throws Exception {
            T r0 = this.qs.poll();
            if (r0 != null) goto L7;
            return null;
        L7:
            return (U) ObjectHelper.requireNonNull(this.mapper.apply(r0), "The mapper function returned a null value.");
        }
    }

    static final class MapSubscriber<T, U> extends BasicFuseableSubscriber<T, U> {
        final Function<? super T, ? extends U> mapper;

        MapSubscriber(Subscriber<? super U> r1, Function<? super T, ? extends U> r2) {
            super(r1);
            this.mapper = r2;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // org.reactivestreams.Subscriber
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

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r1) {
            return transitiveBoundaryFusion(r1);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public U poll() throws Exception {
            T r0 = this.qs.poll();
            if (r0 != null) goto L7;
            return null;
        L7:
            return (U) ObjectHelper.requireNonNull(this.mapper.apply(r0), "The mapper function returned a null value.");
        }
    }

    public FlowableMap(Flowable<T> r1, Function<? super T, ? extends U> r2) {
        super(r1);
        this.mapper = r2;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super U> r3) {
        if ((r3 instanceof ConditionalSubscriber) == false) goto L5;
        this.source.subscribe(new MapConditionalSubscriber((ConditionalSubscriber) r3, this.mapper));
        return;
    L5:
        this.source.subscribe(new MapSubscriber(r3, this.mapper));
    }
}
