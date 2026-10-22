package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableSequenceEqualSingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {
    final BiPredicate<? super T, ? super T> comparer;
    final Publisher<? extends T> first;
    final int prefetch;
    final Publisher<? extends T> second;

    public static final class EqualCoordinator<T> extends AtomicInteger implements Disposable, FlowableSequenceEqual.EqualCoordinatorHelper {
        private static final long serialVersionUID = -6178010334400373240L;
        final BiPredicate<? super T, ? super T> comparer;
        final SingleObserver<? super Boolean> downstream;
        final AtomicThrowable error;
        final FlowableSequenceEqual.EqualSubscriber<T> first;
        final FlowableSequenceEqual.EqualSubscriber<T> second;
        T v1;
        T v2;

        public EqualCoordinator(SingleObserver<? super Boolean> r1, int r2, BiPredicate<? super T, ? super T> r3) {
            this.downstream = r1;
            this.comparer = r3;
            this.first = new FlowableSequenceEqual.EqualSubscriber(this, r2);
            this.second = new FlowableSequenceEqual.EqualSubscriber(this, r2);
            this.error = new AtomicThrowable();
        }

        public void cancelAndClear() {
            this.first.cancel();
            this.first.clear();
            this.second.cancel();
            this.second.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.first.cancel();
            this.second.cancel();
            if (getAndIncrement() != 0) goto L6;
            this.first.clear();
            this.second.clear();
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinatorHelper
        public void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            int r1 = 1;
        L6:
            SimpleQueue<T> r2 = this.first.queue;
            SimpleQueue<T> r3 = this.second.queue;
            if (r2 == null) goto L60;
            if (r3 == null) goto L60;
        L10:
            if (isDisposed() == true) goto L11;
            if (this.error.get() != null) goto L15;
            boolean r4 = this.first.done;
            T r5 = this.v1;
            if (r5 == null) goto L74;
        L24:
            boolean r6 = false;
            if (r5 != null) goto L27;
            boolean r7 = true;
        L28:
            boolean r8 = this.second.done;
            T r9 = this.v2;
            if (r9 == null) goto L72;
        L35:
            if (r9 != null) goto L37;
            r6 = true;
        L37:
            if (r4 == false) goto L43;
            if (r8 == false) goto L43;
            if (r7 == false) goto L43;
            if (r6 == false) goto L43;
            this.downstream.onSuccess(Boolean.TRUE);
            return;
        L43:
            if (r4 == false) goto L48;
            if (r8 == false) goto L48;
            if (r7 == r6) goto L48;
            cancelAndClear();
            this.downstream.onSuccess(Boolean.FALSE);
            return;
        L48:
            if (r7 == true) goto L67;
            if (r6 == true) goto L67;
            if (this.comparer.test(r5, r9) == false) goto L53;
            this.v1 = null;
            this.v2 = null;
            this.first.request();
            this.second.request();
            goto L10
        L53:
            cancelAndClear();
            this.downstream.onSuccess(Boolean.FALSE);
            return;
        L56:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancelAndClear();
            this.error.addThrowable(th);
            this.downstream.onError(this.error.terminate());
            return;
        L67:
            r1 = addAndGet(-r1);
            if (r1 != 0) goto L6;
            return;
        L72:
            r9 = r3.poll();     // Catch: Throwable -> L32
            this.v2 = r9;
        L32:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancelAndClear();
            this.error.addThrowable(th);
            this.downstream.onError(this.error.terminate());
            return;
        L27:
            r7 = false;
            goto L28
        L74:
            r5 = r2.poll();     // Catch: Throwable -> L21
            this.v1 = r5;
        L21:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancelAndClear();
            this.error.addThrowable(th);
            this.downstream.onError(this.error.terminate());
            return;
        L15:
            cancelAndClear();
            this.downstream.onError(this.error.terminate());
            return;
        L11:
            this.first.clear();
            this.second.clear();
            return;
        L60:
            if (isDisposed() == true) goto L61;
            if (this.error.get() == null) goto L67;
            cancelAndClear();
            this.downstream.onError(this.error.terminate());
            return;
        L61:
            this.first.clear();
            this.second.clear();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinatorHelper
        public void innerError(Throwable r2) {
            if (this.error.addThrowable(r2) == false) goto L5;
            drain();
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.first.get() != SubscriptionHelper.CANCELLED) goto L5;
            return true;
        L5:
            return false;
        }

        public void subscribe(Publisher<? extends T> r2, Publisher<? extends T> r3) {
            r2.subscribe(this.first);
            r3.subscribe(this.second);
        }
    }

    public FlowableSequenceEqualSingle(Publisher<? extends T> r1, Publisher<? extends T> r2, BiPredicate<? super T, ? super T> r3, int r4) {
        this.first = r1;
        this.second = r2;
        this.comparer = r3;
        this.prefetch = r4;
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public Flowable<Boolean> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableSequenceEqual(this.first, this.second, this.comparer, this.prefetch));
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super Boolean> r4) {
        EqualCoordinator r0 = new EqualCoordinator(r4, this.prefetch, this.comparer);
        r4.onSubscribe(r0);
        r0.subscribe(this.first, this.second);
    }
}
