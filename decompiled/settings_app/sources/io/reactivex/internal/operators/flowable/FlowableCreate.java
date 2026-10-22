package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableCreate<T> extends Flowable<T> {
    final BackpressureStrategy backpressure;
    final FlowableOnSubscribe<T> source;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.FlowableCreate$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$reactivex$BackpressureStrategy = null;

        static {
            int[] r0 = new int[BackpressureStrategy.values().length];
            $SwitchMap$io$reactivex$BackpressureStrategy = r0;
            r0[BackpressureStrategy.MISSING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.DROP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.LATEST.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static abstract class BaseEmitter<T> extends AtomicLong implements FlowableEmitter<T>, Subscription {
        private static final long serialVersionUID = 7326289992464377023L;
        final Subscriber<? super T> downstream;
        final SequentialDisposable serial;

        void onRequested() {
        }

        void onUnsubscribed() {
        }

        BaseEmitter(Subscriber<? super T> r1) {
            this.downstream = r1;
            this.serial = new SequentialDisposable();
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            complete();
        }

        protected void complete() {
            if (isCancelled() == false) goto L11;
            return;
        L11:
            this.downstream.onComplete();     // Catch: Throwable -> L8
            this.serial.dispose();
            return;
        L8:
            th = move-exception;
            this.serial.dispose();
            throw th;
        }

        @Override // io.reactivex.Emitter
        public final void onError(Throwable r1) {
            if (tryOnError(r1) == true) goto L6;
            RxJavaPlugins.onError(r1);
            return;
        }

        @Override // io.reactivex.FlowableEmitter
        public boolean tryOnError(Throwable r1) {
            return error(r1);
        }

        protected boolean error(Throwable r2) {
            if (r2 != null) goto L5;
            r2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        L5:
            if (isCancelled() == false) goto L14;
            return false;
        L14:
            this.downstream.onError(r2);     // Catch: Throwable -> L11
            this.serial.dispose();
            return true;
        L11:
            th = move-exception;
            this.serial.dispose();
            throw th;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.serial.dispose();
            onUnsubscribed();
        }

        @Override // io.reactivex.FlowableEmitter
        public final boolean isCancelled() {
            return this.serial.isDisposed();
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.add(this, r2);
            onRequested();
            return;
        }

        @Override // io.reactivex.FlowableEmitter
        public final void setDisposable(Disposable r1) {
            this.serial.update(r1);
        }

        @Override // io.reactivex.FlowableEmitter
        public final void setCancellable(Cancellable r2) {
            setDisposable(new CancellableDisposable(r2));
        }

        @Override // io.reactivex.FlowableEmitter
        public final long requested() {
            return get();
        }

        @Override // io.reactivex.FlowableEmitter
        public final FlowableEmitter<T> serialize() {
            return new SerializedEmitter(this);
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public String toString() {
            return String.format("%s{%s}", new Object[]{getClass().getSimpleName(), super.toString()});
        }
    }

    static final class BufferAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        volatile boolean done;
        Throwable error;
        final SpscLinkedArrayQueue<T> queue;
        final AtomicInteger wip;

        BufferAsyncEmitter(Subscriber<? super T> r1, int r2) {
            super(r1);
            this.queue = new SpscLinkedArrayQueue(r2);
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.Emitter
        public void onNext(T r2) {
            if (this.done == false) goto L5;
            return;
        L5:
            if (isCancelled() == true) goto L13;
            if (r2 != null) goto L10;
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        L10:
            this.queue.offer(r2);
            drain();
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.FlowableEmitter
        public boolean tryOnError(Throwable r2) {
            if (this.done == false) goto L5;
            return false;
        L5:
            if (isCancelled() == true) goto L13;
            if (r2 != null) goto L9;
            r2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        L9:
            this.error = r2;
            this.done = true;
            drain();
            return true;
        L13:
            return false;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.Emitter
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onRequested() {
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() != 0) goto L6;
            this.queue.clear();
            return;
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) goto L5;
            return;
        L5:
            Subscriber<? super T> r0 = this.downstream;
            SpscLinkedArrayQueue<T> r1 = this.queue;
            int r3 = 1;
        L6:
            long r4 = get();
            long r8 = 0;
        L8:
            if (r8 == r4) goto L27;
            if (isCancelled() == true) goto L11;
            boolean r11 = this.done;
            T r12 = r1.poll();
            if (r12 != null) goto L16;
            boolean r13 = true;
        L17:
            if (r11 == false) goto L24;
            if (r13 == false) goto L24;
            Throwable r2 = this.error;
            if (r2 == null) goto L22;
            error(r2);
            return;
        L22:
            complete();
            return;
        L24:
            if (r13 == true) goto L27;
            r0.onNext(r12);
            r8 = r8 + 1;
            goto L8
        L16:
            r13 = false;
            goto L17
        L11:
            r1.clear();
            return;
        L27:
            if (r8 != r4) goto L41;
            if (isCancelled() == true) goto L30;
            boolean r5 = this.done;
            boolean r6 = r1.isEmpty();
            if (r5 == false) goto L41;
            if (r6 == false) goto L41;
            Throwable r7 = this.error;
            if (r7 == null) goto L38;
            error(r7);
            return;
        L38:
            complete();
            return;
        L30:
            r1.clear();
            return;
        L41:
            if (r8 == 0) goto L43;
            BackpressureHelper.produced(this, r8);
        L43:
            r3 = this.wip.addAndGet(-r3);
            if (r3 != 0) goto L6;
        }
    }

    static final class DropAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.NoOverflowBaseAsyncEmitter
        void onOverflow() {
        }

        DropAsyncEmitter(Subscriber<? super T> r1) {
            super(r1);
        }
    }

    static final class ErrorAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 338953216916120960L;

        ErrorAsyncEmitter(Subscriber<? super T> r1) {
            super(r1);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.NoOverflowBaseAsyncEmitter
        void onOverflow() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }

    static final class LatestAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        volatile boolean done;
        Throwable error;
        final AtomicReference<T> queue;
        final AtomicInteger wip;

        LatestAsyncEmitter(Subscriber<? super T> r1) {
            super(r1);
            this.queue = new AtomicReference();
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.Emitter
        public void onNext(T r2) {
            if (this.done == false) goto L5;
            return;
        L5:
            if (isCancelled() == true) goto L13;
            if (r2 != null) goto L10;
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        L10:
            this.queue.set(r2);
            drain();
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.FlowableEmitter
        public boolean tryOnError(Throwable r3) {
            if (this.done == false) goto L5;
            return false;
        L5:
            if (isCancelled() == true) goto L13;
            if (r3 != null) goto L9;
            onError(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
        L9:
            this.error = r3;
            this.done = true;
            drain();
            return true;
        L13:
            return false;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.Emitter
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onRequested() {
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() != 0) goto L6;
            this.queue.lazySet(null);
            return;
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) goto L5;
            return;
        L5:
            Subscriber<? super T> r1 = this.downstream;
            AtomicReference<T> r2 = this.queue;
            int r4 = 1;
        L6:
            long r5 = get();
            long r9 = 0;
        L7:
            boolean r12 = false;
            if (r9 == r5) goto L27;
            if (isCancelled() == true) goto L11;
            boolean r14 = this.done;
            T r15 = r2.getAndSet(null);
            if (r15 != null) goto L16;
            boolean r16 = true;
        L17:
            if (r14 == false) goto L24;
            if (r16 == false) goto L24;
            Throwable r3 = this.error;
            if (r3 == null) goto L22;
            error(r3);
            return;
        L22:
            complete();
            return;
        L24:
            if (r16 == true) goto L27;
            r1.onNext(r15);
            r9 = r9 + 1;
            goto L7
        L16:
            r16 = false;
            goto L17
        L11:
            r2.lazySet(null);
            return;
        L27:
            if (r9 != r5) goto L43;
            if (isCancelled() == true) goto L30;
            boolean r6 = this.done;
            if (r2.get() != null) goto L35;
            r12 = true;
        L35:
            if (r6 == false) goto L43;
            if (r12 == false) goto L43;
            Throwable r7 = this.error;
            if (r7 == null) goto L40;
            error(r7);
            return;
        L40:
            complete();
            return;
        L30:
            r2.lazySet(null);
            return;
        L43:
            if (r9 == 0) goto L45;
            BackpressureHelper.produced(this, r9);
        L45:
            r4 = this.wip.addAndGet(-r4);
            if (r4 != 0) goto L6;
        }
    }

    static final class MissingEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        MissingEmitter(Subscriber<? super T> r1) {
            super(r1);
        }

        @Override // io.reactivex.Emitter
        public void onNext(T r5) {
            if (isCancelled() == false) goto L5;
            return;
        L5:
            if (r5 == null) goto L12;
            this.downstream.onNext(r5);
        L7:
            long r0 = get();
            if (r0 == 0) goto L11;
            if (compareAndSet(r0, r0 - 1) == false) goto L7;
            return;
        L11:
            return;
        L12:
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        }
    }

    static abstract class NoOverflowBaseAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        abstract void onOverflow();

        NoOverflowBaseAsyncEmitter(Subscriber<? super T> r1) {
            super(r1);
        }

        @Override // io.reactivex.Emitter
        public final void onNext(T r5) {
            if (isCancelled() == false) goto L5;
            return;
        L5:
            if (r5 != null) goto L9;
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        L9:
            if (get() == 0) goto L11;
            this.downstream.onNext(r5);
            BackpressureHelper.produced(this, 1);
            return;
        L11:
            onOverflow();
        }
    }

    static final class SerializedEmitter<T> extends AtomicInteger implements FlowableEmitter<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        volatile boolean done;
        final BaseEmitter<T> emitter;
        final AtomicThrowable error;
        final SimplePlainQueue<T> queue;

        @Override // io.reactivex.FlowableEmitter
        public FlowableEmitter<T> serialize() {
            return this;
        }

        SerializedEmitter(BaseEmitter<T> r2) {
            this.emitter = r2;
            this.error = new AtomicThrowable();
            this.queue = new SpscLinkedArrayQueue(16);
        }

        @Override // io.reactivex.Emitter
        public void onNext(T r3) {
            if (this.emitter.isCancelled() == false) goto L5;
            return;
        L5:
            if (this.done == true) goto L32;
            if (r3 != null) goto L11;
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        L11:
            if (get() == 0) goto L13;
        L17:
            SimplePlainQueue<T> r0 = this.queue;
            monitor-enter(r0);
            r0.offer(r3);     // Catch: Throwable -> L26
            monitor-exit(r0);     // Catch: Throwable -> L26
            if (getAndIncrement() == 0) goto L24;
            return;
        L24:
            drainLoop();
            return;
        L26:
            th = move-exception;
            throw th;
        L13:
            if (compareAndSet(0, 1) == false) goto L17;
            this.emitter.onNext(r3);
            if (decrementAndGet() != 0) goto L24;
            return;
        }

        @Override // io.reactivex.Emitter
        public void onError(Throwable r1) {
            if (tryOnError(r1) == true) goto L6;
            RxJavaPlugins.onError(r1);
            return;
        }

        @Override // io.reactivex.FlowableEmitter
        public boolean tryOnError(Throwable r3) {
            if (this.emitter.isCancelled() == false) goto L5;
        L13:
            return false;
        L5:
            if (this.done == true) goto L13;
            if (r3 != null) goto L10;
            r3 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        L10:
            if (this.error.addThrowable(r3) == false) goto L13;
            this.done = true;
            drain();
            return true;
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            if (this.emitter.isCancelled() == false) goto L5;
            return;
        L5:
            if (this.done == true) goto L10;
            this.done = true;
            drain();
            return;
        }

        void drain() {
            if (getAndIncrement() != 0) goto L6;
            drainLoop();
            return;
        }

        void drainLoop() {
            BaseEmitter<T> r0 = this.emitter;
            SimplePlainQueue<T> r1 = this.queue;
            AtomicThrowable r2 = this.error;
            int r4 = 1;
        L4:
            if (r0.isCancelled() == true) goto L5;
            if (r2.get() != null) goto L9;
            boolean r5 = this.done;
            T r6 = r1.poll();
            if (r6 != null) goto L14;
            boolean r7 = true;
        L15:
            if (r5 == false) goto L19;
            if (r7 == false) goto L19;
            r0.onComplete();
            return;
        L19:
            if (r7 == true) goto L20;
            r0.onNext(r6);
            goto L4
        L20:
            r4 = addAndGet(-r4);
            if (r4 != 0) goto L4;
            return;
        L14:
            r7 = false;
            goto L15
        L9:
            r1.clear();
            r0.onError(r2.terminate());
            return;
        L5:
            r1.clear();
        }

        @Override // io.reactivex.FlowableEmitter
        public void setDisposable(Disposable r1) {
            this.emitter.setDisposable(r1);
        }

        @Override // io.reactivex.FlowableEmitter
        public void setCancellable(Cancellable r1) {
            this.emitter.setCancellable(r1);
        }

        @Override // io.reactivex.FlowableEmitter
        public long requested() {
            return this.emitter.requested();
        }

        @Override // io.reactivex.FlowableEmitter
        public boolean isCancelled() {
            return this.emitter.isCancelled();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public String toString() {
            return this.emitter.toString();
        }
    }

    public FlowableCreate(FlowableOnSubscribe<T> r1, BackpressureStrategy r2) {
        this.source = r1;
        this.backpressure = r2;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r3) {
        int r0 = AnonymousClass1.$SwitchMap$io$reactivex$BackpressureStrategy[this.backpressure.ordinal()];
        if (r0 != 1) goto L5;
        BaseEmitter r1 = new MissingEmitter(r3);
    L15:
        r3.onSubscribe(r1);
        this.source.subscribe(r1);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        r1.onError(th);
        return;
    L5:
        if (r0 != 2) goto L7;
        r1 = new ErrorAsyncEmitter(r3);
        goto L15
    L7:
        if (r0 != 3) goto L9;
        r1 = new DropAsyncEmitter(r3);
        goto L15
    L9:
        if (r0 == 4) goto L11;
        r1 = new BufferAsyncEmitter(r3, bufferSize());
        goto L15
    L11:
        r1 = new LatestAsyncEmitter(r3);
        goto L15
    }
}
