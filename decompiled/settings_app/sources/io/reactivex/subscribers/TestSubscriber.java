package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.BaseTestConsumer;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public class TestSubscriber<T> extends BaseTestConsumer<T, TestSubscriber<T>> implements FlowableSubscriber<T>, Subscription, Disposable {
    private volatile boolean cancelled;
    private final Subscriber<? super T> downstream;
    private final AtomicLong missedRequested;
    private QueueSubscription<T> qs;
    private final AtomicReference<Subscription> upstream;

    static final enum EmptySubscriber extends Enum<EmptySubscriber> implements FlowableSubscriber<Object> {
        private static final /* synthetic */ EmptySubscriber[] $VALUES = null;
        public static final EmptySubscriber INSTANCE = null;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object r1) {
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r1) {
        }

        private EmptySubscriber(String r1, int r2) {
            super(r1, r2);
        }

        public static EmptySubscriber valueOf(String r1) {
            return (EmptySubscriber) Enum.valueOf(EmptySubscriber.class, r1);
        }

        public static EmptySubscriber[] values() {
            return (EmptySubscriber[]) $VALUES.clone();
        }

        static {
            EmptySubscriber r0 = new EmptySubscriber("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new EmptySubscriber[]{r0};
        }
    }

    protected void onStart() {
    }

    @Override // io.reactivex.observers.BaseTestConsumer
    public /* bridge */ /* synthetic */ BaseTestConsumer assertNotSubscribed() {
        return assertNotSubscribed();
    }

    @Override // io.reactivex.observers.BaseTestConsumer
    public /* bridge */ /* synthetic */ BaseTestConsumer assertSubscribed() {
        return assertSubscribed();
    }

    public static <T> TestSubscriber<T> create() {
        return new TestSubscriber();
    }

    public static <T> TestSubscriber<T> create(long r1) {
        return new TestSubscriber(r1);
    }

    public static <T> TestSubscriber<T> create(Subscriber<? super T> r1) {
        return new TestSubscriber(r1);
    }

    public TestSubscriber() {
        this(EmptySubscriber.INSTANCE, Long.MAX_VALUE);
    }

    public TestSubscriber(long r2) {
        this(EmptySubscriber.INSTANCE, r2);
    }

    public TestSubscriber(Subscriber<? super T> r3) {
        this(r3, Long.MAX_VALUE);
    }

    public TestSubscriber(Subscriber<? super T> r3, long r4) {
        if (r4 < 0) goto L7;
        this.downstream = r3;
        this.upstream = new AtomicReference();
        this.missedRequested = new AtomicLong(r4);
        return;
    L7:
        throw new IllegalArgumentException("Negative initial request not allowed");
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r6) {
        this.lastThread = Thread.currentThread();
        if (r6 != null) goto L7;
        this.errors.add(new NullPointerException("onSubscribe received a null Subscription"));
        return;
    L7:
        if (this.upstream.compareAndSet(null, r6) == true) goto L13;
        r6.cancel();
        if (this.upstream.get() == SubscriptionHelper.CANCELLED) goto L35;
        this.errors.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + r6));
        return;
    L35:
        return;
    L13:
        if (this.initialFusionMode != 0) goto L15;
    L27:
        this.downstream.onSubscribe(r6);
        long r3 = this.missedRequested.getAndSet(0);
        if (r3 == 0) goto L30;
        r6.request(r3);
    L30:
        onStart();
        return;
    L15:
        if ((r6 instanceof QueueSubscription) == false) goto L27;
        QueueSubscription<T> r0 = (QueueSubscription) r6;
        this.qs = r0;
        int r1 = r0.requestFusion(this.initialFusionMode);
        this.establishedFusionMode = r1;
        if (r1 != 1) goto L27;
        this.checkSubscriptionOnce = true;
        this.lastThread = Thread.currentThread();
    L32:
        T r7 = this.qs.poll();     // Catch: Throwable -> L24
        if (r7 == null) goto L22;
        this.values.add(r7);     // Catch: Throwable -> L24
        goto L32
    L22:
        this.completions++;     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        this.errors.add(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r4) {
        if (this.checkSubscriptionOnce == true) goto L7;
        this.checkSubscriptionOnce = true;
        if (this.upstream.get() != null) goto L7;
        this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
    L7:
        this.lastThread = Thread.currentThread();
        if (this.establishedFusionMode == 2) goto L21;
        this.values.add(r4);
        if (r4 != null) goto L19;
        this.errors.add(new NullPointerException("onNext received a null value"));
    L19:
        this.downstream.onNext(r4);
        return;
    L21:
        T r5 = this.qs.poll();     // Catch: Throwable -> L13
        if (r5 == null) goto L25;
        this.values.add(r5);     // Catch: Throwable -> L13
        goto L21
    L25:
        return;
    L13:
        th = move-exception;
        this.errors.add(th);
        this.qs.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r4) {
        if (this.checkSubscriptionOnce == true) goto L16;
        this.checkSubscriptionOnce = true;
        if (this.upstream.get() != null) goto L16;
        this.errors.add(new NullPointerException("onSubscribe not called in proper order"));
    L16:
        this.lastThread = Thread.currentThread();     // Catch: Throwable -> L13
        this.errors.add(r4);     // Catch: Throwable -> L13
        if (r4 != null) goto L10;
        this.errors.add(new IllegalStateException("onError received a null Throwable"));     // Catch: Throwable -> L13
    L10:
        this.downstream.onError(r4);     // Catch: Throwable -> L13
        this.done.countDown();
        return;
    L13:
        th = move-exception;
        this.done.countDown();
        throw th;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.checkSubscriptionOnce == true) goto L13;
        this.checkSubscriptionOnce = true;
        if (this.upstream.get() != null) goto L13;
        this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
    L13:
        this.lastThread = Thread.currentThread();     // Catch: Throwable -> L10
        this.completions++;     // Catch: Throwable -> L10
        this.downstream.onComplete();     // Catch: Throwable -> L10
        this.done.countDown();
        return;
    L10:
        th = move-exception;
        this.done.countDown();
        throw th;
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long r2) {
        SubscriptionHelper.deferredRequest(this.upstream, this.missedRequested, r2);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (this.cancelled == true) goto L6;
        this.cancelled = true;
        SubscriptionHelper.cancel(this.upstream);
        return;
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        cancel();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.cancelled;
    }

    public final boolean hasSubscription() {
        if (this.upstream.get() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.observers.BaseTestConsumer
    public final TestSubscriber<T> assertSubscribed() {
        if (this.upstream.get() == null) goto L6;
        return this;
    L6:
        throw fail("Not subscribed!");
    }

    @Override // io.reactivex.observers.BaseTestConsumer
    public final TestSubscriber<T> assertNotSubscribed() {
        if (this.upstream.get() != null) goto L10;
        if (this.errors.isEmpty() == false) goto L8;
        return this;
    L8:
        throw fail("Not subscribed but errors found");
    L10:
        throw fail("Subscribed!");
    }

    final TestSubscriber<T> setInitialFusionMode(int r1) {
        this.initialFusionMode = r1;
        return this;
    }

    final TestSubscriber<T> assertFusionMode(int r4) {
        int r0 = this.establishedFusionMode;
        if (r0 != r4) goto L5;
        return this;
    L5:
        if (this.qs == null) goto L9;
        throw new AssertionError("Fusion mode different. Expected: " + fusionModeToString(r4) + ", actual: " + fusionModeToString(r0));
    L9:
        throw fail("Upstream is not fuseable");
    }

    static String fusionModeToString(int r2) {
        if (r2 != 0) goto L4;
        return "NONE";
    L4:
        if (r2 != 1) goto L6;
        return "SYNC";
    L6:
        if (r2 != 2) goto L8;
        return "ASYNC";
    L8:
        return "Unknown(" + r2 + ")";
    }

    final TestSubscriber<T> assertFuseable() {
        if (this.qs == null) goto L6;
        return this;
    L6:
        throw new AssertionError("Upstream is not fuseable.");
    }

    final TestSubscriber<T> assertNotFuseable() {
        if (this.qs != null) goto L6;
        return this;
    L6:
        throw new AssertionError("Upstream is fuseable.");
    }

    public final TestSubscriber<T> assertOf(Consumer<? super TestSubscriber<T>> r1) {
        r1.accept(this);     // Catch: Throwable -> L4
        return this;
    L4:
        th = move-exception;
        throw ExceptionHelper.wrapOrThrow(th);
    }

    public final TestSubscriber<T> requestMore(long r1) {
        request(r1);
        return this;
    }
}
