package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableRangeLong extends Flowable<Long> {
    final long end;
    final long start;

    static abstract class BaseRangeSubscription extends BasicQueueSubscription<Long> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        final long end;
        long index;

        abstract void fastPath();

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int r1) {
            return r1 & 1;
        }

        abstract void slowPath(long r1);

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public /* bridge */ /* synthetic */ Object poll() throws Exception {
            return poll();
        }

        BaseRangeSubscription(long r1, long r3) {
            this.index = r1;
            this.end = r3;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final Long poll() {
            long r0 = this.index;
            if (r0 != this.end) goto L6;
            return null;
        L6:
            this.index = 1 + r0;
            return Long.valueOf(r0);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            if (this.index != this.end) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.index = this.end;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long r5) {
            if (SubscriptionHelper.validate(r5) == true) goto L5;
            return;
        L5:
            if (BackpressureHelper.add(this, r5) == 0) goto L7;
            return;
        L7:
            if (r5 != Long.MAX_VALUE) goto L9;
            fastPath();
            return;
        L9:
            slowPath(r5);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.cancelled = true;
        }
    }

    static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final ConditionalSubscriber<? super Long> downstream;

        RangeConditionalSubscription(ConditionalSubscriber<? super Long> r1, long r2, long r4) {
            super(r2, r4);
            this.downstream = r1;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void fastPath() {
            long r0 = this.end;
            ConditionalSubscriber<? super Long> r2 = this.downstream;
            long r3 = this.index;
        L4:
            if (r3 == r0) goto L10;
            if (this.cancelled == true) goto L7;
            r2.tryOnNext(Long.valueOf(r3));
            r3 = r3 + 1;
            goto L4
        L7:
            return;
        L10:
            if (this.cancelled == false) goto L12;
            return;
        L12:
            r2.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void slowPath(long r13) {
            long r0 = this.end;
            long r2 = this.index;
            ConditionalSubscriber<? super Long> r4 = this.downstream;
        L3:
            long r7 = 0;
        L5:
            if (r7 == r13) goto L16;
            if (r2 == r0) goto L16;
            if (this.cancelled == true) goto L10;
            if (r4.tryOnNext(Long.valueOf(r2)) == false) goto L14;
            r7 = r7 + 1;
        L14:
            r2 = r2 + 1;
            goto L5
        L10:
            return;
        L16:
            if (r2 == r0) goto L18;
            r13 = get();
            if (r7 != r13) goto L5;
            this.index = r2;
            r13 = addAndGet(-r7);
            if (r13 != 0) goto L3;
            return;
        L18:
            if (this.cancelled == true) goto L37;
            r4.onComplete();
            return;
        }
    }

    static final class RangeSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final Subscriber<? super Long> downstream;

        RangeSubscription(Subscriber<? super Long> r1, long r2, long r4) {
            super(r2, r4);
            this.downstream = r1;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void fastPath() {
            long r0 = this.end;
            Subscriber<? super Long> r2 = this.downstream;
            long r3 = this.index;
        L4:
            if (r3 == r0) goto L10;
            if (this.cancelled == true) goto L7;
            r2.onNext(Long.valueOf(r3));
            r3 = r3 + 1;
            goto L4
        L7:
            return;
        L10:
            if (this.cancelled == false) goto L12;
            return;
        L12:
            r2.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void slowPath(long r12) {
            long r0 = this.end;
            long r2 = this.index;
            Subscriber<? super Long> r4 = this.downstream;
        L3:
            long r7 = 0;
        L5:
            if (r7 == r12) goto L13;
            if (r2 == r0) goto L13;
            if (this.cancelled == true) goto L10;
            r4.onNext(Long.valueOf(r2));
            r7 = r7 + 1;
            r2 = r2 + 1;
            goto L5
        L10:
            return;
        L13:
            if (r2 == r0) goto L15;
            r12 = get();
            if (r7 != r12) goto L5;
            this.index = r2;
            r12 = addAndGet(-r7);
            if (r12 != 0) goto L3;
            return;
        L15:
            if (this.cancelled == true) goto L34;
            r4.onComplete();
            return;
        }
    }

    public FlowableRangeLong(long r1, long r3) {
        this.start = r1;
        this.end = r1 + r3;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Long> r14) {
        if ((r14 instanceof ConditionalSubscriber) == false) goto L5;
        r14.onSubscribe(new RangeConditionalSubscription((ConditionalSubscriber) r14, this.start, this.end));
        return;
    L5:
        r14.onSubscribe(new RangeSubscription(r14, this.start, this.end));
    }
}
