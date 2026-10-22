package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Futures extends GwtFuturesCatchingSpecialization {

    private static final class CallbackListener<V> implements Runnable {
        final FutureCallback<? super V> callback;
        final Future<V> future;

        CallbackListener(Future<V> r1, FutureCallback<? super V> r2) {
            this.future = r1;
            this.callback = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Future<V> r0 = this.future;
            if ((r0 instanceof InternalFutureFailureAccess) == false) goto L17;
            Throwable r1 = InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess) r0);
            if (r1 == null) goto L17;
            this.callback.onFailure(r1);
            return;
        L17:
            Object r2 = Futures.getDone(this.future);     // Catch: Throwable -> L11 ExecutionException -> L14
            this.callback.onSuccess(r2);
            return;
        L11:
            e = move-exception;
            this.callback.onFailure(e);
            return;
        L14:
            e = move-exception;
            this.callback.onFailure(e.getCause());
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).addValue(this.callback).toString();
        }
    }

    public static final class FutureCombiner<V> {
        private final boolean allMustSucceed;
        private final ImmutableList<ListenableFuture<? extends V>> futures;

        /* synthetic */ FutureCombiner(boolean r1, ImmutableList r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private FutureCombiner(boolean r1, ImmutableList<ListenableFuture<? extends V>> r2) {
            this.allMustSucceed = r1;
            this.futures = r2;
        }

        public <C> ListenableFuture<C> callAsync(AsyncCallable<C> r3, Executor r4) {
            return new CombinedFuture(this.futures, this.allMustSucceed, r4, r3);
        }

        public <C> ListenableFuture<C> call(Callable<C> r3, Executor r4) {
            return new CombinedFuture(this.futures, this.allMustSucceed, r4, r3);
        }

        public ListenableFuture<?> run(final Runnable r2, Executor r3) {
            return call(new AnonymousClass1(this, r2), r3);
        }
    }

    private static final class InCompletionOrderFuture<T> extends AbstractFuture<T> {

        @CheckForNull
        private InCompletionOrderState<T> state;

        /* synthetic */ InCompletionOrderFuture(InCompletionOrderState r1, AnonymousClass1 r2) {
            this(r1);
        }

        private InCompletionOrderFuture(InCompletionOrderState<T> r1) {
            this.state = r1;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean cancel(boolean r2) {
            InCompletionOrderState<T> r0 = this.state;
            if (super.cancel(r2) == false) goto L6;
            InCompletionOrderState.access$400((InCompletionOrderState) Objects.requireNonNull(r0), r2);
            return true;
        L6:
            return false;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        protected void afterDone() {
            this.state = null;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        @CheckForNull
        protected String pendingToString() {
            InCompletionOrderState<T> r3 = this.state;
            if (r3 == null) goto L6;
            int r0 = InCompletionOrderState.access$500(r3).length;
            int r4 = InCompletionOrderState.access$600(r3).get();
            return new StringBuilder(49).append("inputCount=[").append(r0).append("], remaining=[").append(r4).append("]").toString();
        L6:
            return null;
        }
    }

    private static final class InCompletionOrderState<T> {
        private volatile int delegateIndex;
        private final AtomicInteger incompleteOutputCount;
        private final ListenableFuture<? extends T>[] inputFutures;
        private boolean shouldInterrupt;
        private boolean wasCancelled;

        /* synthetic */ InCompletionOrderState(ListenableFuture[] r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ void access$300(InCompletionOrderState r0, ImmutableList r1, int r2) {
            r0.recordInputCompletion(r1, r2);
        }

        static /* synthetic */ void access$400(InCompletionOrderState r0, boolean r1) {
            r0.recordOutputCancellation(r1);
        }

        static /* synthetic */ ListenableFuture[] access$500(InCompletionOrderState r0) {
            return r0.inputFutures;
        }

        static /* synthetic */ AtomicInteger access$600(InCompletionOrderState r0) {
            return r0.incompleteOutputCount;
        }

        private InCompletionOrderState(ListenableFuture<? extends T>[] r3) {
            this.wasCancelled = false;
            this.shouldInterrupt = true;
            this.delegateIndex = 0;
            this.inputFutures = r3;
            this.incompleteOutputCount = new AtomicInteger(r3.length);
        }

        private void recordOutputCancellation(boolean r2) {
            this.wasCancelled = true;
            if (r2 == true) goto L5;
            this.shouldInterrupt = false;
        L5:
            recordCompletion();
        }

        private void recordInputCompletion(ImmutableList<AbstractFuture<T>> r4, int r5) {
            ListenableFuture<? extends T> r0 = (ListenableFuture) Objects.requireNonNull(this.inputFutures[r5]);
            this.inputFutures[r5] = null;
            int r6 = this.delegateIndex;
        L4:
            if (r6 >= r4.size()) goto L10;
            if (r4.get(r6).setFuture(r0) == true) goto L7;
            r6 = r6 + 1;
            goto L4
        L7:
            recordCompletion();
            this.delegateIndex = r6 + 1;
            return;
        L10:
            this.delegateIndex = r4.size();
        }

        private void recordCompletion() {
            if (this.incompleteOutputCount.decrementAndGet() == 0) goto L5;
            return;
        L5:
            if (this.wasCancelled == false) goto L16;
            ListenableFuture<? extends T>[] r0 = this.inputFutures;
            int r1 = r0.length;
            int r2 = 0;
        L7:
            if (r2 >= r1) goto L17;
            ListenableFuture<? extends T> r3 = r0[r2];
            if (r3 == null) goto L11;
            r3.cancel(this.shouldInterrupt);
        L11:
            r2 = r2 + 1;
            goto L7
        L17:
            return;
        }
    }

    private static final class NonCancellationPropagatingFuture<V> extends AbstractFuture.TrustedFuture<V> implements Runnable {

        @CheckForNull
        private ListenableFuture<V> delegate;

        NonCancellationPropagatingFuture(ListenableFuture<V> r1) {
            this.delegate = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            ListenableFuture<V> r0 = this.delegate;
            if (r0 == null) goto L6;
            setFuture(r0);
            return;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        @CheckForNull
        protected String pendingToString() {
            ListenableFuture<V> r2 = this.delegate;
            if (r2 == null) goto L6;
            String r3 = String.valueOf(r2);
            return new StringBuilder(String.valueOf(r3).length() + 11).append("delegate=[").append(r3).append("]").toString();
        L6:
            return null;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        protected void afterDone() {
            this.delegate = null;
        }
    }

    private Futures() {
    }

    public static <V> ListenableFuture<V> immediateFuture(@ParametricNullness V r1) {
        if (r1 != null) goto L6;
        return (ListenableFuture<V>) ImmediateFuture.NULL;
    L6:
        return new ImmediateFuture(r1);
    }

    public static ListenableFuture<Void> immediateVoidFuture() {
        return ImmediateFuture.NULL;
    }

    public static <V> ListenableFuture<V> immediateFailedFuture(Throwable r1) {
        Preconditions.checkNotNull(r1);
        return new ImmediateFuture.ImmediateFailedFuture(r1);
    }

    public static <V> ListenableFuture<V> immediateCancelledFuture() {
        return new ImmediateFuture.ImmediateCancelledFuture();
    }

    public static <O> ListenableFuture<O> submit(Callable<O> r0, Executor r1) {
        TrustedListenableFutureTask r2 = TrustedListenableFutureTask.create(r0);
        r1.execute(r2);
        return r2;
    }

    public static ListenableFuture<Void> submit(Runnable r1, Executor r2) {
        TrustedListenableFutureTask r3 = TrustedListenableFutureTask.create(r1, null);
        r2.execute(r3);
        return r3;
    }

    public static <O> ListenableFuture<O> submitAsync(AsyncCallable<O> r0, Executor r1) {
        TrustedListenableFutureTask r2 = TrustedListenableFutureTask.create(r0);
        r1.execute(r2);
        return r2;
    }

    public static <O> ListenableFuture<O> scheduleAsync(AsyncCallable<O> r2, Duration r3, ScheduledExecutorService r4) {
        return scheduleAsync(r2, Internal.toNanosSaturated(r3), TimeUnit.NANOSECONDS, r4);
    }

    public static <O> ListenableFuture<O> scheduleAsync(AsyncCallable<O> r0, long r1, TimeUnit r3, ScheduledExecutorService r4) {
        TrustedListenableFutureTask r2 = TrustedListenableFutureTask.create(r0);
        final ScheduledFuture<?> r5 = r4.schedule(r2, r1, r3);
        r2.addListener(new AnonymousClass1(r5), MoreExecutors.directExecutor());
        return r2;
    }

    public static <V, X extends Throwable> ListenableFuture<V> catching(ListenableFuture<? extends V> r0, Class<X> r1, Function<? super X, ? extends V> r2, Executor r3) {
        return AbstractCatchingFuture.create(r0, r1, r2, r3);
    }

    public static <V, X extends Throwable> ListenableFuture<V> catchingAsync(ListenableFuture<? extends V> r0, Class<X> r1, AsyncFunction<? super X, ? extends V> r2, Executor r3) {
        return AbstractCatchingFuture.create(r0, r1, r2, r3);
    }

    public static <V> ListenableFuture<V> withTimeout(ListenableFuture<V> r2, Duration r3, ScheduledExecutorService r4) {
        return withTimeout(r2, Internal.toNanosSaturated(r3), TimeUnit.NANOSECONDS, r4);
    }

    public static <V> ListenableFuture<V> withTimeout(ListenableFuture<V> r1, long r2, TimeUnit r4, ScheduledExecutorService r5) {
        if (r1.isDone() == false) goto L6;
        return r1;
    L6:
        return TimeoutFuture.create(r1, r2, r4, r5);
    }

    public static <I, O> ListenableFuture<O> transformAsync(ListenableFuture<I> r0, AsyncFunction<? super I, ? extends O> r1, Executor r2) {
        return AbstractTransformFuture.create(r0, r1, r2);
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> r0, Function<? super I, ? extends O> r1, Executor r2) {
        return AbstractTransformFuture.create(r0, r1, r2);
    }

    public static <I, O> Future<O> lazyTransform(final Future<I> r1, final Function<? super I, ? extends O> r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        return new AnonymousClass2(r1, r2);
    }

    @SafeVarargs
    public static <V> ListenableFuture<List<V>> allAsList(ListenableFuture<? extends V>... r2) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(r2), true);
    }

    public static <V> ListenableFuture<List<V>> allAsList(Iterable<? extends ListenableFuture<? extends V>> r2) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(r2), true);
    }

    @SafeVarargs
    public static <V> FutureCombiner<V> whenAllComplete(ListenableFuture<? extends V>... r3) {
        boolean r2 = false;
        return new FutureCombiner(r2, ImmutableList.copyOf(r3), null);
    }

    public static <V> FutureCombiner<V> whenAllComplete(Iterable<? extends ListenableFuture<? extends V>> r3) {
        boolean r2 = false;
        return new FutureCombiner(r2, ImmutableList.copyOf(r3), null);
    }

    @SafeVarargs
    public static <V> FutureCombiner<V> whenAllSucceed(ListenableFuture<? extends V>... r3) {
        boolean r2 = true;
        return new FutureCombiner(r2, ImmutableList.copyOf(r3), null);
    }

    public static <V> FutureCombiner<V> whenAllSucceed(Iterable<? extends ListenableFuture<? extends V>> r3) {
        boolean r2 = true;
        return new FutureCombiner(r2, ImmutableList.copyOf(r3), null);
    }

    public static <V> ListenableFuture<V> nonCancellationPropagating(ListenableFuture<V> r2) {
        if (r2.isDone() == false) goto L5;
        return r2;
    L5:
        NonCancellationPropagatingFuture r0 = new NonCancellationPropagatingFuture(r2);
        r2.addListener(r0, MoreExecutors.directExecutor());
        return r0;
    }

    @SafeVarargs
    public static <V> ListenableFuture<List<V>> successfulAsList(ListenableFuture<? extends V>... r2) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(r2), false);
    }

    public static <V> ListenableFuture<List<V>> successfulAsList(Iterable<? extends ListenableFuture<? extends V>> r2) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(r2), false);
    }

    public static <T> ImmutableList<ListenableFuture<T>> inCompletionOrder(Iterable<? extends ListenableFuture<? extends T>> r6) {
        ListenableFuture[] r7 = gwtCompatibleToArray(r6);
        AnonymousClass1 r1 = null;
        final InCompletionOrderState r0 = new InCompletionOrderState(r7, r1);
        ImmutableList.Builder r2 = ImmutableList.builderWithExpectedSize(r7.length);
        final int r3 = 0;
        int r4 = 0;
    L4:
        if (r4 >= r7.length) goto L6;
        r2.add(new InCompletionOrderFuture(r0, r1));
        r4 = r4 + 1;
        goto L4
    L6:
        final ImmutableList<ListenableFuture<T>> r5 = r2.build();
    L8:
        if (r3 >= r7.length) goto L10;
        r7[r3].addListener(new AnonymousClass3(r0, r5, r3), MoreExecutors.directExecutor());
        r3 = r3 + 1;
        goto L8
    L10:
        return r5;
    }

    private static <T> ListenableFuture<? extends T>[] gwtCompatibleToArray(Iterable<? extends ListenableFuture<? extends T>> r1) {
        if ((r1 instanceof Collection) == false) goto L5;
        Collection r2 = (Collection) r1;
    L7:
        return (ListenableFuture[]) r2.toArray(new ListenableFuture[0]);
    L5:
        r2 = ImmutableList.copyOf(r1);
        goto L7
    }

    public static <V> void addCallback(ListenableFuture<V> r1, FutureCallback<? super V> r2, Executor r3) {
        Preconditions.checkNotNull(r2);
        r1.addListener(new CallbackListener(r1, r2), r3);
    }

    @ParametricNullness
    public static <V> V getDone(Future<V> r2) throws ExecutionException {
        Preconditions.checkState(r2.isDone(), "Future was expected to be done: %s", r2);
        return (V) Uninterruptibles.getUninterruptibly(r2);
    }

    @ParametricNullness
    public static <V, X extends Exception> V getChecked(Future<V> r0, Class<X> r1) throws Exception {
        return (V) FuturesGetChecked.getChecked(r0, r1);
    }

    @ParametricNullness
    public static <V, X extends Exception> V getChecked(Future<V> r2, Class<X> r3, Duration r4) throws Exception {
        return (V) getChecked(r2, r3, Internal.toNanosSaturated(r4), TimeUnit.NANOSECONDS);
    }

    @ParametricNullness
    public static <V, X extends Exception> V getChecked(Future<V> r0, Class<X> r1, long r2, TimeUnit r4) throws Exception {
        return (V) FuturesGetChecked.getChecked(r0, r1, r2, r4);
    }

    @ParametricNullness
    public static <V> V getUnchecked(Future<V> r0) {
        Preconditions.checkNotNull(r0);
        return (V) Uninterruptibles.getUninterruptibly(r0);
    L5:
        e = move-exception;
        wrapAndThrowUnchecked(e.getCause());
        throw new AssertionError();
    }

    private static void wrapAndThrowUnchecked(Throwable r1) {
        if ((r1 instanceof Error) == false) goto L7;
        throw new ExecutionError((Error) r1);
    L7:
        throw new UncheckedExecutionException(r1);
    }
}
