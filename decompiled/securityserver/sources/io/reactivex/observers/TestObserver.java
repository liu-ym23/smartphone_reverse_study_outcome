package io.reactivex.observers;

import a.a;
import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public class TestObserver<T> extends BaseTestConsumer<T, TestObserver<T>> implements Observer<T>, Disposable, MaybeObserver<T>, SingleObserver<T>, CompletableObserver {
    private final Observer<? super T> downstream;
    private QueueDisposable<T> qd;
    private final AtomicReference<Disposable> upstream;

    public static final enum EmptyObserver extends Enum<EmptyObserver> implements Observer<Object> {
        private static final /* synthetic */ EmptyObserver[] $VALUES = null;
        public static final EmptyObserver INSTANCE = null;

        static {
            EmptyObserver r0 = new EmptyObserver("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new EmptyObserver[]{r0};
        }

        private EmptyObserver(String r1, int r2) {
            super(r1, r2);
        }

        public static EmptyObserver valueOf(String r1) {
            return (EmptyObserver) Enum.valueOf(EmptyObserver.class, r1);
        }

        public static EmptyObserver[] values() {
            return (EmptyObserver[]) $VALUES.clone();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
        }

        @Override // io.reactivex.Observer
        public void onNext(Object r1) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
        }
    }

    public TestObserver() {
        this(EmptyObserver.INSTANCE);
    }

    public static <T> TestObserver<T> create() {
        return new TestObserver();
    }

    public static String fusionModeToString(int r2) {
        if (r2 != 0) goto L4;
        return "NONE";
    L4:
        if (r2 != 1) goto L6;
        return "SYNC";
    L6:
        if (r2 != 2) goto L8;
        return "ASYNC";
    L8:
        return a.f(r2, "Unknown(", ")");
    }

    public final TestObserver<T> assertFuseable() {
        if (this.qd == null) goto L6;
        return this;
    L6:
        throw new AssertionError("Upstream is not fuseable.");
    }

    public final TestObserver<T> assertFusionMode(int r4) {
        int r0 = this.establishedFusionMode;
        if (r0 != r4) goto L5;
        return this;
    L5:
        if (this.qd == null) goto L9;
        throw new AssertionError("Fusion mode different. Expected: " + fusionModeToString(r4) + ", actual: " + fusionModeToString(r0));
    L9:
        throw fail("Upstream is not fuseable");
    }

    public final TestObserver<T> assertNotFuseable() {
        if (this.qd != null) goto L6;
        return this;
    L6:
        throw new AssertionError("Upstream is fuseable.");
    }

    @Override // io.reactivex.observers.BaseTestConsumer
    public /* bridge */ /* synthetic */ BaseTestConsumer assertNotSubscribed() {
        return assertNotSubscribed();
    }

    public final TestObserver<T> assertOf(Consumer<? super TestObserver<T>> r1) {
        r1.accept(this);     // Catch: Throwable -> L4
        return this;
    L4:
        th = move-exception;
        throw ExceptionHelper.wrapOrThrow(th);
    }

    @Override // io.reactivex.observers.BaseTestConsumer
    public /* bridge */ /* synthetic */ BaseTestConsumer assertSubscribed() {
        return assertSubscribed();
    }

    public final void cancel() {
        dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.upstream);
    }

    public final boolean hasSubscription() {
        if (this.upstream.get() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isCancelled() {
        return isDisposed();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    @Override // io.reactivex.Observer
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

    @Override // io.reactivex.Observer
    public void onError(Throwable r4) {
        if (this.checkSubscriptionOnce == true) goto L18;
        this.checkSubscriptionOnce = true;
        if (this.upstream.get() != null) goto L18;
        this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
    L18:
        this.lastThread = Thread.currentThread();     // Catch: Throwable -> L10
        if (r4 != null) goto L12;
        this.errors.add(new NullPointerException("onError received a null Throwable"));     // Catch: Throwable -> L10
    L13:
        this.downstream.onError(r4);     // Catch: Throwable -> L10
        this.done.countDown();
        return;
    L12:
        this.errors.add(r4);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.done.countDown();
        throw th;
    }

    @Override // io.reactivex.Observer
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
        T r5 = this.qd.poll();     // Catch: Throwable -> L13
        if (r5 == null) goto L25;
        this.values.add(r5);     // Catch: Throwable -> L13
        goto L21
    L25:
        return;
    L13:
        th = move-exception;
        this.errors.add(th);
        this.qd.dispose();
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r5) {
        this.lastThread = Thread.currentThread();
        if (r5 != null) goto L7;
        this.errors.add(new NullPointerException("onSubscribe received a null Subscription"));
        return;
    L7:
        if (this.upstream.compareAndSet(null, r5) == true) goto L12;
        r5.dispose();
        if (this.upstream.get() == DisposableHelper.DISPOSED) goto L33;
        this.errors.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + r5));
        return;
    L33:
        return;
    L12:
        int r0 = this.initialFusionMode;
        if (r0 != 0) goto L15;
    L28:
        this.downstream.onSubscribe(r5);
        return;
    L15:
        if ((r5 instanceof QueueDisposable) == false) goto L28;
        QueueDisposable<T> r1 = (QueueDisposable) r5;
        this.qd = r1;
        int r2 = r1.requestFusion(r0);
        this.establishedFusionMode = r2;
        if (r2 != 1) goto L28;
        this.checkSubscriptionOnce = true;
        this.lastThread = Thread.currentThread();
    L30:
        T r6 = this.qd.poll();     // Catch: Throwable -> L22
        if (r6 == null) goto L24;
        this.values.add(r6);     // Catch: Throwable -> L22
        goto L30
    L24:
        this.completions++;     // Catch: Throwable -> L22
        this.upstream.lazySet(DisposableHelper.DISPOSED);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        this.errors.add(th);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T r1) {
        onNext(r1);
        onComplete();
    }

    public final TestObserver<T> setInitialFusionMode(int r1) {
        this.initialFusionMode = r1;
        return this;
    }

    public TestObserver(Observer<? super T> r2) {
        this.upstream = new AtomicReference();
        this.downstream = r2;
    }

    public static <T> TestObserver<T> create(Observer<? super T> r1) {
        return new TestObserver(r1);
    }

    @Override // io.reactivex.observers.BaseTestConsumer
    public final TestObserver<T> assertNotSubscribed() {
        if (this.upstream.get() != null) goto L10;
        if (this.errors.isEmpty() == false) goto L8;
        return this;
    L8:
        throw fail("Not subscribed but errors found");
    L10:
        throw fail("Subscribed!");
    }

    @Override // io.reactivex.observers.BaseTestConsumer
    public final TestObserver<T> assertSubscribed() {
        if (this.upstream.get() == null) goto L6;
        return this;
    L6:
        throw fail("Not subscribed!");
    }
}
