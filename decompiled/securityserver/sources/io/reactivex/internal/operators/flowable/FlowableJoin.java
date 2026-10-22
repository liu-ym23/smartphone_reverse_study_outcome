package io.reactivex.internal.operators.flowable;

import android.R;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractFlowableWithUpstream<TLeft, R> {
    final Function<? super TLeft, ? extends Publisher<TLeftEnd>> leftEnd;
    final Publisher<? extends TRight> other;
    final BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector;
    final Function<? super TRight, ? extends Publisher<TRightEnd>> rightEnd;

    public static final class JoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Subscription, FlowableGroupJoin.JoinSupport {
        static final Integer LEFT_CLOSE = null;
        static final Integer LEFT_VALUE = null;
        static final Integer RIGHT_CLOSE = null;
        static final Integer RIGHT_VALUE = null;
        private static final long serialVersionUID = -6071216598687999801L;
        final AtomicInteger active;
        volatile boolean cancelled;
        final CompositeDisposable disposables;
        final Subscriber<? super R> downstream;
        final AtomicReference<Throwable> error;
        final Function<? super TLeft, ? extends Publisher<TLeftEnd>> leftEnd;
        int leftIndex;
        final Map<Integer, TLeft> lefts;
        final SpscLinkedArrayQueue<Object> queue;
        final AtomicLong requested;
        final BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector;
        final Function<? super TRight, ? extends Publisher<TRightEnd>> rightEnd;
        int rightIndex;
        final Map<Integer, TRight> rights;

        static {
            LEFT_VALUE = 1;
            RIGHT_VALUE = 2;
            LEFT_CLOSE = 3;
            RIGHT_CLOSE = 4;
        }

        public JoinSubscription(Subscriber<? super R> r2, Function<? super TLeft, ? extends Publisher<TLeftEnd>> r3, Function<? super TRight, ? extends Publisher<TRightEnd>> r4, BiFunction<? super TLeft, ? super TRight, ? extends R> r5) {
            this.downstream = r2;
            this.requested = new AtomicLong();
            this.disposables = new CompositeDisposable();
            this.queue = new SpscLinkedArrayQueue(Flowable.bufferSize());
            this.lefts = new LinkedHashMap();
            this.rights = new LinkedHashMap();
            this.error = new AtomicReference();
            this.leftEnd = r3;
            this.rightEnd = r4;
            this.resultSelector = r5;
            this.active = new AtomicInteger(2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled == false) goto L5;
            return;
        L5:
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() != 0) goto L9;
            this.queue.clear();
            return;
        }

        public void cancelAll() {
            this.disposables.dispose();
        }

        public void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            SpscLinkedArrayQueue<Object> r2 = this.queue;
            Subscriber<? super R> r3 = this.downstream;
            boolean r0 = true;
            int r4 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            if (this.error.get() != null) goto L12;
            if (this.active.get() != 0) goto L17;
            boolean r5 = r0;
        L18:
            Integer r7 = (Integer) r2.poll();
            if (r7 != null) goto L21;
            boolean r8 = r0;
        L22:
            if (r5 == false) goto L26;
            if (r8 == false) goto L26;
            this.lefts.clear();
            this.rights.clear();
            this.disposables.dispose();
            r3.onComplete();
            return;
        L26:
            if (r8 == true) goto L27;
            Object r6 = r2.poll();
            if (r7 != LEFT_VALUE) goto L58;
            int r9 = this.leftIndex;
            this.leftIndex = r9 + 1;
            this.lefts.put(Integer.valueOf(r9), (TLeft) r6);
            Publisher r10 = (Publisher) ObjectHelper.requireNonNull(this.leftEnd.apply(r6), "The leftEnd returned a null Publisher");     // Catch: Throwable -> L54
            FlowableGroupJoin.LeftRightEndSubscriber r11 = new FlowableGroupJoin.LeftRightEndSubscriber(this, r0, r9);
            this.disposables.add(r11);
            r10.subscribe(r11);
            if (this.error.get() != null) goto L36;
            long r12 = this.requested.get();
            Iterator<TRight> r13 = this.rights.values().iterator();
            long r14 = 0;
        L40:
            if (r13.hasNext() == false) goto L52;
            R.animator r1 = (Object) ObjectHelper.requireNonNull(this.resultSelector.apply(r6, r13.next()), "The resultSelector returned a null value");
            if (r14 == r12) goto L46;
            r3.onNext(r1);
            r14 = r14 + 1;
            goto L40
        L46:
            ExceptionHelper.addThrowable(this.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
            r2.clear();
            cancelAll();
            errorAll(r3);
            return;
        L48:
            th = move-exception;
            fail(th, r3, r2);
            return;
        L52:
            if (r14 == 0) goto L90;
            BackpressureHelper.produced(this.requested, r14);
        L90:
            r0 = true;
            goto L7
        L36:
            r2.clear();
            cancelAll();
            errorAll(r3);
            return;
        L54:
            th = move-exception;
            fail(th, r3, r2);
            return;
        L58:
            if (r7 != RIGHT_VALUE) goto L85;
            int r15 = this.rightIndex;
            this.rightIndex = r15 + 1;
            this.rights.put(Integer.valueOf(r15), (TRight) r6);
            Publisher r16 = (Publisher) ObjectHelper.requireNonNull(this.rightEnd.apply(r6), "The rightEnd returned a null Publisher");     // Catch: Throwable -> L81
            FlowableGroupJoin.LeftRightEndSubscriber r17 = new FlowableGroupJoin.LeftRightEndSubscriber(this, false, r15);
            this.disposables.add(r17);
            r16.subscribe(r17);
            if (this.error.get() != null) goto L63;
            long r18 = this.requested.get();
            Iterator<TLeft> r19 = this.lefts.values().iterator();
            long r110 = 0;
        L67:
            if (r19.hasNext() == false) goto L79;
            R.animator r20 = (Object) ObjectHelper.requireNonNull(this.resultSelector.apply(r19.next(), r6), "The resultSelector returned a null value");
            if (r110 == r18) goto L73;
            r3.onNext(r20);
            r110 = r110 + 1;
            goto L67
        L73:
            ExceptionHelper.addThrowable(this.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
            r2.clear();
            cancelAll();
            errorAll(r3);
            return;
        L75:
            th = move-exception;
            fail(th, r3, r2);
            return;
        L79:
            if (r110 == 0) goto L90;
            BackpressureHelper.produced(this.requested, r110);
            goto L90
        L63:
            r2.clear();
            cancelAll();
            errorAll(r3);
            return;
        L81:
            th = move-exception;
            fail(th, r3, r2);
            return;
        L85:
            if (r7 != LEFT_CLOSE) goto L88;
            FlowableGroupJoin.LeftRightEndSubscriber r21 = (FlowableGroupJoin.LeftRightEndSubscriber) r6;
            this.lefts.remove(Integer.valueOf(r21.index));
            this.disposables.remove(r21);
            goto L90
        L88:
            if (r7 != RIGHT_CLOSE) goto L90;
            FlowableGroupJoin.LeftRightEndSubscriber r22 = (FlowableGroupJoin.LeftRightEndSubscriber) r6;
            this.rights.remove(Integer.valueOf(r22.index));
            this.disposables.remove(r22);
            goto L90
        L27:
            r4 = addAndGet(-r4);
            if (r4 != 0) goto L7;
            return;
        L21:
            r8 = false;
            goto L22
        L17:
            r5 = false;
            goto L18
        L12:
            r2.clear();
            cancelAll();
            errorAll(r3);
            return;
        L8:
            r2.clear();
        }

        public void errorAll(Subscriber<?> r3) {
            Throwable r0 = ExceptionHelper.terminate(this.error);
            this.lefts.clear();
            this.rights.clear();
            r3.onError(r0);
        }

        public void fail(Throwable r2, Subscriber<?> r3, SimpleQueue<?> r4) {
            Exceptions.throwIfFatal(r2);
            ExceptionHelper.addThrowable(this.error, r2);
            r4.clear();
            cancelAll();
            errorAll(r3);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void innerClose(boolean r2, FlowableGroupJoin.LeftRightEndSubscriber r3) {
            monitor-enter(this);
            SpscLinkedArrayQueue<Object> r0 = this.queue;     // Catch: Throwable -> L6
            if (r2 == false) goto L8;
            Integer r4 = LEFT_CLOSE;     // Catch: Throwable -> L6
        L9:
            r0.offer(r4, r3);     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            drain();
            return;
        L8:
            r4 = RIGHT_CLOSE;     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void innerCloseError(Throwable r2) {
            if (ExceptionHelper.addThrowable(this.error, r2) == false) goto L5;
            drain();
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void innerComplete(FlowableGroupJoin.LeftRightSubscriber r2) {
            this.disposables.delete(r2);
            this.active.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void innerError(Throwable r2) {
            if (ExceptionHelper.addThrowable(this.error, r2) == false) goto L5;
            this.active.decrementAndGet();
            drain();
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void innerValue(boolean r2, Object r3) {
            monitor-enter(this);
            SpscLinkedArrayQueue<Object> r0 = this.queue;     // Catch: Throwable -> L6
            if (r2 == false) goto L8;
            Integer r4 = LEFT_VALUE;     // Catch: Throwable -> L6
        L9:
            r0.offer(r4, r3);     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            drain();
            return;
        L8:
            r4 = RIGHT_VALUE;     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            throw th;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.add(this.requested, r2);
            return;
        }
    }

    public FlowableJoin(Flowable<TLeft> r1, Publisher<? extends TRight> r2, Function<? super TLeft, ? extends Publisher<TLeftEnd>> r3, Function<? super TRight, ? extends Publisher<TRightEnd>> r4, BiFunction<? super TLeft, ? super TRight, ? extends R> r5) {
        super(r1);
        this.other = r2;
        this.leftEnd = r3;
        this.rightEnd = r4;
        this.resultSelector = r5;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> r5) {
        JoinSubscription r0 = new JoinSubscription(r5, this.leftEnd, this.rightEnd, this.resultSelector);
        r5.onSubscribe(r0);
        FlowableGroupJoin.LeftRightSubscriber r6 = new FlowableGroupJoin.LeftRightSubscriber(r0, true);
        r0.disposables.add(r6);
        FlowableGroupJoin.LeftRightSubscriber r1 = new FlowableGroupJoin.LeftRightSubscriber(r0, false);
        r0.disposables.add(r1);
        this.source.subscribe(r6);
        this.other.subscribe(r1);
    }
}
