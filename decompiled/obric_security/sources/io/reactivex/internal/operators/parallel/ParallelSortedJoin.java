package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
public final class ParallelSortedJoin<T> extends Flowable<T> {
    final Comparator<? super T> comparator;
    final ParallelFlowable<List<T>> source;

    static final class SortedJoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<List<T>> {
        private static final long serialVersionUID = 6751017204873808094L;
        final int index;
        final SortedJoinSubscription<T> parent;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public /* bridge */ /* synthetic */ void onNext(Object r1) {
            onNext((List) r1);
        }

        SortedJoinInnerSubscriber(SortedJoinSubscription<T> r1, int r2) {
            this.parent = r1;
            this.index = r2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            SubscriptionHelper.setOnce(this, r3, Long.MAX_VALUE);
        }

        public void onNext(List<T> r2) {
            this.parent.innerNext(r2, this.index);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            this.parent.innerError(r1);
        }

        void cancel() {
            SubscriptionHelper.cancel(this);
        }
    }

    static final class SortedJoinSubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3481980673745556697L;
        volatile boolean cancelled;
        final Comparator<? super T> comparator;
        final Subscriber<? super T> downstream;
        final AtomicReference<Throwable> error;
        final int[] indexes;
        final List<T>[] lists;
        final AtomicInteger remaining;
        final AtomicLong requested;
        final SortedJoinInnerSubscriber<T>[] subscribers;

        SortedJoinSubscription(Subscriber<? super T> r2, int r3, Comparator<? super T> r4) {
            this.requested = new AtomicLong();
            this.remaining = new AtomicInteger();
            this.error = new AtomicReference();
            this.downstream = r2;
            this.comparator = r4;
            SortedJoinInnerSubscriber<T>[] r5 = new SortedJoinInnerSubscriber[r3];
            int r6 = 0;
        L3:
            if (r6 >= r3) goto L5;
            r5[r6] = new SortedJoinInnerSubscriber(this, r6);
            r6 = r6 + 1;
            goto L3
        L5:
            this.subscribers = r5;
            this.lists = new List[r3];
            this.indexes = new int[r3];
            this.remaining.lazySet(r3);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L8;
            BackpressureHelper.add(this.requested, r2);
            if (this.remaining.get() != 0) goto L9;
            drain();
            return;
        L9:
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() != 0) goto L9;
            Arrays.fill(this.lists, null);
            return;
        L9:
            return;
        }

        void cancelAll() {
            SortedJoinInnerSubscriber<T>[] r3 = this.subscribers;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].cancel();
            r1 = r1 + 1;
            goto L3
        }

        void innerNext(List<T> r2, int r3) {
            this.lists[r3] = r2;
            if (this.remaining.decrementAndGet() != 0) goto L6;
            drain();
            return;
        }

        void innerError(Throwable r3) {
            if (b0$$ExternalSyntheticBackport0.m(this.error, null, r3) == false) goto L6;
            drain();
            return;
        L6:
            if (r3 == this.error.get()) goto L10;
            RxJavaPlugins.onError(r3);
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            Subscriber<? super T> r2 = this.downstream;
            List<T>[] r3 = this.lists;
            int[] r0 = this.indexes;
            int r4 = r0.length;
            int r6 = 1;
        L6:
            long r7 = this.requested.get();
            long r11 = 0;
        L8:
            if (r11 == r7) goto L43;
            if (this.cancelled == true) goto L11;
            Throwable r13 = this.error.get();
            if (r13 != null) goto L15;
            int r14 = -1;
            T r9 = null;
            int r15 = 0;
        L18:
            if (r15 >= r4) goto L38;
            List<T> r10 = r3[r15];
            int r5 = r0[r15];
            if (r10.size() == r5) goto L37;
            if (r9 != null) goto L24;
            r9 = r10.get(r5);
        L23:
            r14 = r15;
            goto L37
        L24:
            T r8 = r10.get(r5);
            if (this.comparator.compare(r9, r8) <= 0) goto L28;
            boolean r12 = true;
        L29:
            if (r12 == false) goto L37;
            r9 = r8;
            goto L23
        L28:
            r12 = false;
        L31:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancelAll();
            Arrays.fill(r3, null);
            if (b0$$ExternalSyntheticBackport0.m(this.error, null, th) == true) goto L35;
            RxJavaPlugins.onError(th);
        L35:
            r2.onError(this.error.get());
            return;
        L37:
            r15 = r15 + 1;
            goto L18
        L38:
            if (r9 == null) goto L39;
            r2.onNext(r9);
            r0[r14] = r0[r14] + 1;
            r11 = r11 + 1;
            goto L8
        L39:
            Arrays.fill(r3, null);
            r2.onComplete();
            return;
        L15:
            cancelAll();
            Arrays.fill(r3, null);
            r2.onError(r13);
            return;
        L11:
            Arrays.fill(r3, null);
            return;
        L43:
            if (r11 != r7) goto L63;
            if (this.cancelled == true) goto L46;
            Throwable r16 = this.error.get();
            if (r16 != null) goto L50;
            int r17 = 0;
        L53:
            if (r17 >= r4) goto L58;
            if (r0[r17] != r3[r17].size()) goto L56;
            r17 = r17 + 1;
            goto L53
        L56:
            boolean r18 = false;
        L59:
            if (r18 == false) goto L63;
            Arrays.fill(r3, null);
            r2.onComplete();
            return;
        L58:
            r18 = true;
            goto L59
        L50:
            cancelAll();
            Arrays.fill(r3, null);
            r2.onError(r16);
            return;
        L46:
            Arrays.fill(r3, null);
            return;
        L63:
            if (r11 != 0) goto L65;
        L67:
            int r19 = get();
            if (r19 != r6) goto L72;
            r19 = addAndGet(-r6);
            if (r19 != 0) goto L72;
            return;
        L72:
            r6 = r19;
            goto L6
        L65:
            if (r7 == Long.MAX_VALUE) goto L67;
            this.requested.addAndGet(-r11);
            goto L67
        }
    }

    public ParallelSortedJoin(ParallelFlowable<List<T>> r1, Comparator<? super T> r2) {
        this.source = r1;
        this.comparator = r2;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r4) {
        SortedJoinSubscription r0 = new SortedJoinSubscription(r4, this.source.parallelism(), this.comparator);
        r4.onSubscribe(r0);
        this.source.subscribe(r0.subscribers);
    }
}
