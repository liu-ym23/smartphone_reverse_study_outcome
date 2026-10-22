package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class AggregateFuture<InputT, OutputT> extends AggregateFutureState<OutputT> {
    private static final Logger logger = null;
    private final boolean allMustSucceed;
    private final boolean collectsValues;

    @CheckForNull
    private ImmutableCollection<? extends ListenableFuture<? extends InputT>> futures;

    static final enum ReleaseResourcesReason extends Enum<ReleaseResourcesReason> {
        private static final /* synthetic */ ReleaseResourcesReason[] $VALUES = null;
        public static final ReleaseResourcesReason ALL_INPUT_FUTURES_PROCESSED = null;
        public static final ReleaseResourcesReason OUTPUT_FUTURE_DONE = null;

        private static /* synthetic */ ReleaseResourcesReason[] $values() {
            return new ReleaseResourcesReason[]{OUTPUT_FUTURE_DONE, ALL_INPUT_FUTURES_PROCESSED};
        }

        private ReleaseResourcesReason(String r1, int r2) {
            super(r1, r2);
        }

        public static ReleaseResourcesReason valueOf(String r1) {
            return (ReleaseResourcesReason) Enum.valueOf(ReleaseResourcesReason.class, r1);
        }

        public static ReleaseResourcesReason[] values() {
            return (ReleaseResourcesReason[]) $VALUES.clone();
        }

        static {
            OUTPUT_FUTURE_DONE = new ReleaseResourcesReason("OUTPUT_FUTURE_DONE", 0);
            ALL_INPUT_FUTURES_PROCESSED = new ReleaseResourcesReason("ALL_INPUT_FUTURES_PROCESSED", 1);
            $VALUES = $values();
        }
    }

    abstract void collectOneValue(int r1, @ParametricNullness InputT r2);

    abstract void handleAllCompleted();

    static /* synthetic */ ImmutableCollection access$002(AggregateFuture r0, ImmutableCollection r1) {
        r0.futures = r1;
        return r1;
    }

    static /* synthetic */ void access$100(AggregateFuture r0, int r1, Future r2) {
        r0.collectValueFromNonCancelledFuture(r1, r2);
    }

    static /* synthetic */ void access$200(AggregateFuture r0, ImmutableCollection r1) {
        r0.decrementCountAndMaybeComplete(r1);
    }

    static {
        logger = Logger.getLogger(AggregateFuture.class.getName());
    }

    AggregateFuture(ImmutableCollection<? extends ListenableFuture<? extends InputT>> r2, boolean r3, boolean r4) {
        super(r2.size());
        this.futures = (ImmutableCollection) Preconditions.checkNotNull(r2);
        this.allMustSucceed = r3;
        this.collectsValues = r4;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected final void afterDone() {
        super.afterDone();
        ImmutableCollection<? extends ListenableFuture<? extends InputT>> r0 = this.futures;
        releaseResources(ReleaseResourcesReason.OUTPUT_FUTURE_DONE);
        boolean r1 = isCancelled();
        if (r0 == null) goto L5;
        boolean r2 = true;
    L7:
        if ((r1 & r2) == false) goto L12;
        boolean r3 = wasInterrupted();
        UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> r4 = r0.iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        r4.next().cancel(r3);
        goto L10
    L14:
        return;
    L12:
        return;
    L5:
        r2 = false;
        goto L7
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CheckForNull
    protected final String pendingToString() {
        ImmutableCollection<? extends ListenableFuture<? extends InputT>> r0 = this.futures;
        if (r0 == null) goto L7;
        String r2 = String.valueOf(r0);
        return new StringBuilder(String.valueOf(r2).length() + 8).append("futures=").append(r2).toString();
    L7:
        return super.pendingToString();
    }

    final void init() {
        Objects.requireNonNull(this.futures);
        if (this.futures.isEmpty() == false) goto L7;
        handleAllCompleted();
        return;
    L7:
        if (this.allMustSucceed == false) goto L13;
        UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> r0 = this.futures.iterator();
        final int r1 = 0;
    L10:
        if (r0.hasNext() == false) goto L20;
        final ListenableFuture<? extends InputT> r2 = r0.next();
        int r3 = r1 + 1;
        r2.addListener(new AnonymousClass1(this, r2, r1), MoreExecutors.directExecutor());
        r1 = r3;
        goto L10
    L20:
        return;
    L13:
        if (this.collectsValues == false) goto L15;
        final ImmutableCollection<? extends ListenableFuture<? extends InputT>> r4 = this.futures;
    L16:
        Runnable r5 = new AnonymousClass2(this, r4);
        UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> r6 = this.futures.iterator();
    L18:
        if (r6.hasNext() == false) goto L23;
        r6.next().addListener(r5, MoreExecutors.directExecutor());
        goto L18
    L23:
        return;
    L15:
        r4 = null;
        goto L16
    }

    private void handleException(Throwable r2) {
        Preconditions.checkNotNull(r2);
        if (this.allMustSucceed == false) goto L11;
        if (setException(r2) == true) goto L11;
        if (addCausalChain(getOrInitSeenExceptions(), r2) == false) goto L11;
        log(r2);
        return;
    L11:
        if ((r2 instanceof Error) == false) goto L14;
        log(r2);
        return;
    }

    private static void log(Throwable r3) {
        if ((r3 instanceof Error) == false) goto L5;
        String r0 = "Input Future failed with Error";
    L6:
        logger.log(Level.SEVERE, r0, r3);
        return;
    L5:
        r0 = "Got more than one input Future failure. Logging failures after the first";
        goto L6
    }

    @Override // com.google.common.util.concurrent.AggregateFutureState
    final void addInitialException(Set<Throwable> r2) {
        Preconditions.checkNotNull(r2);
        if (isCancelled() == true) goto L6;
        addCausalChain(r2, (Throwable) Objects.requireNonNull(tryInternalFastPathGetFailure()));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void collectValueFromNonCancelledFuture(int r1, Future<? extends InputT> r2) {
        collectOneValue(r1, Futures.getDone(r2));     // Catch: Throwable -> L4 ExecutionException -> L6
    L12:
        return;
    L6:
        e = move-exception;
        handleException(e.getCause());
        return;
    L4:
        th = move-exception;
        handleException(th);
    }

    private void decrementCountAndMaybeComplete(@CheckForNull ImmutableCollection<? extends Future<? extends InputT>> r4) {
        int r0 = decrementRemainingAndGet();
        if (r0 < 0) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkState(r1, "Less than 0 remaining futures");
        if (r0 != 0) goto L10;
        processCompleted(r4);
        return;
    L10:
        return;
    L5:
        r1 = false;
        goto L6
    }

    private void processCompleted(@CheckForNull ImmutableCollection<? extends Future<? extends InputT>> r4) {
        if (r4 == null) goto L10;
        UnmodifiableIterator<? extends Future<? extends InputT>> r5 = r4.iterator();
        int r0 = 0;
    L5:
        if (r5.hasNext() == false) goto L10;
        Future<? extends InputT> r1 = r5.next();
        if (r1.isCancelled() == true) goto L9;
        collectValueFromNonCancelledFuture(r0, r1);
    L9:
        r0 = r0 + 1;
    L10:
        clearSeenExceptions();
        handleAllCompleted();
        releaseResources(ReleaseResourcesReason.ALL_INPUT_FUTURES_PROCESSED);
    }

    void releaseResources(ReleaseResourcesReason r1) {
        Preconditions.checkNotNull(r1);
        this.futures = null;
    }

    private static boolean addCausalChain(Set<Throwable> r1, Throwable r2) {
    L2:
        if (r2 == null) goto L8;
        if (r1.add(r2) == false) goto L5;
        r2 = r2.getCause();
        goto L2
    L5:
        return false;
    L8:
        return true;
    }
}
