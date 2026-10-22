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

/* JADX INFO: loaded from: classes2.dex */
public final class ParallelSortedJoin<T> extends Flowable<T> {
    final Comparator<? super T> comparator;
    final ParallelFlowable<List<T>> source;

    public static final class SortedJoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<List<T>> {
        private static final long serialVersionUID = 6751017204873808094L;
        final int index;
        final SortedJoinSubscription<T> parent;

        public SortedJoinInnerSubscriber(SortedJoinSubscription<T> r1, int r2) {
            this.parent = r1;
            this.index = r2;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            this.parent.innerError(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public /* bridge */ /* synthetic */ void onNext(Object r1) {
            onNext((List) r1);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            SubscriptionHelper.setOnce(this, r3, Long.MAX_VALUE);
        }

        public void onNext(List<T> r2) {
            this.parent.innerNext(r2, this.index);
        }
    }

    public static final class SortedJoinSubscription<T> extends AtomicInteger implements Subscription {
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

        public SortedJoinSubscription(Subscriber<? super T> r2, int r3, Comparator<? super T> r4) {
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

        public void cancelAll() {
            SortedJoinInnerSubscriber<T>[] r3 = this.subscribers;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].cancel();
            r1 = r1 + 1;
            goto L3
        }

        public void drain() {
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
        L7:
            int r14 = 0;
            if (r11 == r7) goto L40;
            if (this.cancelled == true) goto L11;
            Throwable r13 = this.error.get();
            if (r13 != null) goto L15;
            int r15 = -1;
            T r9 = null;
        L18:
            if (r14 >= r4) goto L35;
            List<T> r10 = r3[r14];
            int r5 = r0[r14];
            if (r10.size() == r5) goto L34;
            if (r9 != null) goto L24;
            r9 = r10.get(r5);
        L23:
            r15 = r14;
            goto L34
        L24:
            T r8 = r10.get(r5);
            if (this.comparator.compare(r9, r8) <= 0) goto L34;
            r9 = r8;
        L28:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancelAll();
            Arrays.fill(r3, null);
            if (this.error.compareAndSet(null, th) == true) goto L32;
            RxJavaPlugins.onError(th);
        L32:
            r2.onError(this.error.get());
            return;
        L34:
            r14 = r14 + 1;
            goto L18
        L35:
            if (r9 == null) goto L36;
            r2.onNext(r9);
            r0[r15] = r0[r15] + 1;
            r11 = r11 + 1;
            goto L7
        L36:
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
        L40:
            if (r11 != r7) goto L57;
            if (this.cancelled == true) goto L43;
            Throwable r12 = this.error.get();
            if (r12 != null) goto L47;
        L49:
            if (r14 >= r4) goto L54;
            if (r0[r14] != r3[r14].size()) goto L57;
            r14 = r14 + 1;
            goto L49
        L54:
            Arrays.fill(r3, null);
            r2.onComplete();
            return;
        L47:
            cancelAll();
            Arrays.fill(r3, null);
            r2.onError(r12);
            return;
        L43:
            Arrays.fill(r3, null);
            return;
        L57:
            if (r11 != 0) goto L59;
        L61:
            int r16 = get();
            if (r16 != r6) goto L66;
            r16 = addAndGet(-r6);
            if (r16 != 0) goto L66;
            return;
        L66:
            r6 = r16;
            goto L6
        L59:
            if (r7 == Long.MAX_VALUE) goto L61;
            this.requested.addAndGet(-r11);
            goto L61
        }

        public void innerError(Throwable r3) {
            if (this.error.compareAndSet(null, r3) == false) goto L6;
            drain();
            return;
        L6:
            if (r3 == this.error.get()) goto L10;
            RxJavaPlugins.onError(r3);
            return;
        }

        public void innerNext(List<T> r2, int r3) {
            this.lists[r3] = r2;
            if (this.remaining.decrementAndGet() != 0) goto L6;
            drain();
            return;
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
    }

    public ParallelSortedJoin(ParallelFlowable<List<T>> r1, Comparator<? super T> r2) {
        this.source = r1;
        this.comparator = r2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r4) {
        SortedJoinSubscription r0 = new SortedJoinSubscription(r4, this.source.parallelism(), this.comparator);
        r4.onSubscribe(r0);
        this.source.subscribe(r0.subscribers);
    }
}
