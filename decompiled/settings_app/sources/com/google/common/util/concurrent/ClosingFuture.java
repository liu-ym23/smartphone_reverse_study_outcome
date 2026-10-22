package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Closeable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@DoNotMock("Use ClosingFuture.from(Futures.immediate*Future)")
@ElementTypesAreNonnullByDefault
public final class ClosingFuture<V> {
    private static final Logger logger = null;
    private final CloseableList closeables;
    private final FluentFuture<V> future;
    private final AtomicReference<State> state;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$12, reason: invalid class name */
    static /* synthetic */ class AnonymousClass12 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$util$concurrent$ClosingFuture$State = null;

        static {
            int[] r0 = new int[State.values().length];
            $SwitchMap$com$google$common$util$concurrent$ClosingFuture$State = r0;
            r0[State.SUBSUMED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$google$common$util$concurrent$ClosingFuture$State[State.WILL_CREATE_VALUE_AND_CLOSER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$google$common$util$concurrent$ClosingFuture$State[State.WILL_CLOSE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$google$common$util$concurrent$ClosingFuture$State[State.CLOSING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$google$common$util$concurrent$ClosingFuture$State[State.CLOSED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$google$common$util$concurrent$ClosingFuture$State[State.OPEN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    @FunctionalInterface
    public interface AsyncClosingCallable<V> {
        ClosingFuture<V> call(DeferredCloser r1) throws Exception;
    }

    @FunctionalInterface
    public interface AsyncClosingFunction<T, U> {
        ClosingFuture<U> apply(DeferredCloser r1, @ParametricNullness T r2) throws Exception;
    }

    private static final class CloseableList extends IdentityHashMap<AutoCloseable, Executor> implements Closeable {
        private volatile boolean closed;
        private final DeferredCloser closer;

        @CheckForNull
        private volatile CountDownLatch whenClosed;

        private CloseableList() {
            this.closer = new DeferredCloser(this);
        }

        /* synthetic */ CloseableList(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ DeferredCloser access$300(CloseableList r0) {
            return r0.closer;
        }

        /* JADX WARN: Multi-variable type inference failed */
        <V, U> ListenableFuture<U> applyClosingFunction(ClosingFunction<? super V, U> r3, @ParametricNullness V r4) throws Exception {
            CloseableList r0 = new CloseableList();
            ListenableFuture<U> r5 = Futures.immediateFuture(r3.apply(r0.closer, r4));     // Catch: Throwable -> L6
            add(r0, MoreExecutors.directExecutor());
            return r5;
        L6:
            th = move-exception;
            add(r0, MoreExecutors.directExecutor());
            throw th;
        }

        <V, U> FluentFuture<U> applyAsyncClosingFunction(AsyncClosingFunction<V, U> r3, @ParametricNullness V r4) throws Exception {
            CloseableList r0 = new CloseableList();
            ClosingFuture<U> r5 = r3.apply(r0.closer, r4);     // Catch: Throwable -> L6
            ClosingFuture.access$1000(r5, r0);     // Catch: Throwable -> L6
            FluentFuture<U> r6 = ClosingFuture.access$000(r5);     // Catch: Throwable -> L6
            add(r0, MoreExecutors.directExecutor());
            return r6;
        L6:
            th = move-exception;
            add(r0, MoreExecutors.directExecutor());
            throw th;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed == false) goto L5;
            return;
        L5:
            monitor-enter(this);
        L20:
            th = move-exception;
            throw th;
        L7:
            if (this.closed == false) goto L10;
            monitor-exit(this);     // Catch: Throwable -> L20
            return;
        L10:
            this.closed = true;     // Catch: Throwable -> L20
            monitor-exit(this);     // Catch: Throwable -> L20
            Iterator<Map.Entry<AutoCloseable, Executor>> r0 = entrySet().iterator();
        L14:
            if (r0.hasNext() == false) goto L16;
            Map.Entry<AutoCloseable, Executor> r1 = r0.next();
            ClosingFuture.access$3300(r1.getKey(), r1.getValue());
            goto L14
        L16:
            clear();
            if (this.whenClosed == null) goto L25;
            this.whenClosed.countDown();
            return;
        }

        void add(@CheckForNull AutoCloseable r2, Executor r3) {
            Preconditions.checkNotNull(r3);
            if (r2 != null) goto L5;
            return;
        L5:
            monitor-enter(this);
        L14:
            th = move-exception;
            throw th;
        L7:
            if (this.closed == true) goto L11;
            put(r2, r3);     // Catch: Throwable -> L14
            monitor-exit(this);     // Catch: Throwable -> L14
            return;
        L11:
            monitor-exit(this);     // Catch: Throwable -> L14
            ClosingFuture.access$3300(r2, r3);
        }

        CountDownLatch whenClosedCountDown() {
            boolean r1 = false;
            if (this.closed == true) goto L5;
            monitor-enter(this);
        L18:
            th = move-exception;
            throw th;
        L8:
            if (this.closed == false) goto L13;
            CountDownLatch r0 = new CountDownLatch(0);     // Catch: Throwable -> L18
            monitor-exit(this);     // Catch: Throwable -> L18
            return r0;
        L13:
            if (this.whenClosed != null) goto L15;
            r1 = true;
        L15:
            Preconditions.checkState(r1);     // Catch: Throwable -> L18
            CountDownLatch r2 = new CountDownLatch(1);     // Catch: Throwable -> L18
            this.whenClosed = r2;     // Catch: Throwable -> L18
            monitor-exit(this);     // Catch: Throwable -> L18
            return r2;
        L5:
            return new CountDownLatch(0);
        }
    }

    @FunctionalInterface
    public interface ClosingCallable<V> {
        @ParametricNullness
        V call(DeferredCloser r1) throws Exception;
    }

    @FunctionalInterface
    public interface ClosingFunction<T, U> {
        @ParametricNullness
        U apply(DeferredCloser r1, @ParametricNullness T r2) throws Exception;
    }

    @DoNotMock("Use ClosingFuture.whenAllSucceed() or .whenAllComplete() instead.")
    public static class Combiner {
        private static final Function<ClosingFuture<?>, FluentFuture<?>> INNER_FUTURE = null;
        private final boolean allMustSucceed;
        private final CloseableList closeables;
        protected final ImmutableList<ClosingFuture<?>> inputs;

        @FunctionalInterface
        public interface AsyncCombiningCallable<V> {
            ClosingFuture<V> call(DeferredCloser r1, Peeker r2) throws Exception;
        }

        @FunctionalInterface
        public interface CombiningCallable<V> {
            @ParametricNullness
            V call(DeferredCloser r1, Peeker r2) throws Exception;
        }

        /* synthetic */ Combiner(boolean r1, Iterable r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ CloseableList access$1300(Combiner r0) {
            return r0.closeables;
        }

        private Combiner(boolean r3, Iterable<? extends ClosingFuture<?>> r4) {
            this.closeables = new CloseableList(null);
            this.allMustSucceed = r3;
            this.inputs = ImmutableList.copyOf(r4);
            Iterator<? extends ClosingFuture<?>> r5 = r4.iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            ClosingFuture.access$1000(r5.next(), this.closeables);
            goto L4
        }

        public <V> ClosingFuture<V> call(final CombiningCallable<V> r3, Executor r4) {
            Callable<V> r0 = new AnonymousClass1(this, r3);
            ClosingFuture<V> r5 = new ClosingFuture(futureCombiner().call(r0, r4), null);
            ClosingFuture.access$200(r5).add(this.closeables, MoreExecutors.directExecutor());
            return r5;
        }

        public <V> ClosingFuture<V> callAsync(final AsyncCombiningCallable<V> r3, Executor r4) {
            AsyncCallable<V> r0 = new AnonymousClass2(this, r3);
            ClosingFuture<V> r5 = new ClosingFuture(futureCombiner().callAsync(r0, r4), null);
            ClosingFuture.access$200(r5).add(this.closeables, MoreExecutors.directExecutor());
            return r5;
        }

        private Futures.FutureCombiner<Object> futureCombiner() {
            if (this.allMustSucceed == false) goto L6;
            return Futures.whenAllSucceed(inputFutures());
        L6:
            return Futures.whenAllComplete(inputFutures());
        }

        static {
            INNER_FUTURE = new AnonymousClass3();
        }

        private ImmutableList<FluentFuture<?>> inputFutures() {
            return FluentIterable.from(this.inputs).transform(INNER_FUTURE).toList();
        }
    }

    public static final class Combiner2<V1, V2> extends Combiner {
        private final ClosingFuture<V1> future1;
        private final ClosingFuture<V2> future2;

        @FunctionalInterface
        public interface AsyncClosingFunction2<V1, V2, U> {
            ClosingFuture<U> apply(DeferredCloser r1, @ParametricNullness V1 r2, @ParametricNullness V2 r3) throws Exception;
        }

        @FunctionalInterface
        public interface ClosingFunction2<V1, V2, U> {
            @ParametricNullness
            U apply(DeferredCloser r1, @ParametricNullness V1 r2, @ParametricNullness V2 r3) throws Exception;
        }

        /* synthetic */ Combiner2(ClosingFuture r1, ClosingFuture r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ ClosingFuture access$1800(Combiner2 r0) {
            return r0.future1;
        }

        static /* synthetic */ ClosingFuture access$1900(Combiner2 r0) {
            return r0.future2;
        }

        private Combiner2(ClosingFuture<V1> r4, ClosingFuture<V2> r5) {
            boolean r2 = true;
            super(r2, ImmutableList.of(r4, r5), null);
            this.future1 = r4;
            this.future2 = r5;
        }

        public <U> ClosingFuture<U> call(final ClosingFunction2<V1, V2, U> r2, Executor r3) {
            return call(new AnonymousClass1(this, r2), r3);
        }

        public <U> ClosingFuture<U> callAsync(final AsyncClosingFunction2<V1, V2, U> r2, Executor r3) {
            return callAsync(new AnonymousClass2(this, r2), r3);
        }
    }

    public static final class Combiner3<V1, V2, V3> extends Combiner {
        private final ClosingFuture<V1> future1;
        private final ClosingFuture<V2> future2;
        private final ClosingFuture<V3> future3;

        @FunctionalInterface
        public interface AsyncClosingFunction3<V1, V2, V3, U> {
            ClosingFuture<U> apply(DeferredCloser r1, @ParametricNullness V1 r2, @ParametricNullness V2 r3, @ParametricNullness V3 r4) throws Exception;
        }

        @FunctionalInterface
        public interface ClosingFunction3<V1, V2, V3, U> {
            @ParametricNullness
            U apply(DeferredCloser r1, @ParametricNullness V1 r2, @ParametricNullness V2 r3, @ParametricNullness V3 r4) throws Exception;
        }

        /* synthetic */ Combiner3(ClosingFuture r1, ClosingFuture r2, ClosingFuture r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        static /* synthetic */ ClosingFuture access$2000(Combiner3 r0) {
            return r0.future1;
        }

        static /* synthetic */ ClosingFuture access$2100(Combiner3 r0) {
            return r0.future2;
        }

        static /* synthetic */ ClosingFuture access$2200(Combiner3 r0) {
            return r0.future3;
        }

        private Combiner3(ClosingFuture<V1> r4, ClosingFuture<V2> r5, ClosingFuture<V3> r6) {
            boolean r2 = true;
            super(r2, ImmutableList.of(r4, r5, r6), null);
            this.future1 = r4;
            this.future2 = r5;
            this.future3 = r6;
        }

        public <U> ClosingFuture<U> call(final ClosingFunction3<V1, V2, V3, U> r2, Executor r3) {
            return call(new AnonymousClass1(this, r2), r3);
        }

        public <U> ClosingFuture<U> callAsync(final AsyncClosingFunction3<V1, V2, V3, U> r2, Executor r3) {
            return callAsync(new AnonymousClass2(this, r2), r3);
        }
    }

    public static final class Combiner4<V1, V2, V3, V4> extends Combiner {
        private final ClosingFuture<V1> future1;
        private final ClosingFuture<V2> future2;
        private final ClosingFuture<V3> future3;
        private final ClosingFuture<V4> future4;

        @FunctionalInterface
        public interface AsyncClosingFunction4<V1, V2, V3, V4, U> {
            ClosingFuture<U> apply(DeferredCloser r1, @ParametricNullness V1 r2, @ParametricNullness V2 r3, @ParametricNullness V3 r4, @ParametricNullness V4 r5) throws Exception;
        }

        @FunctionalInterface
        public interface ClosingFunction4<V1, V2, V3, V4, U> {
            @ParametricNullness
            U apply(DeferredCloser r1, @ParametricNullness V1 r2, @ParametricNullness V2 r3, @ParametricNullness V3 r4, @ParametricNullness V4 r5) throws Exception;
        }

        /* synthetic */ Combiner4(ClosingFuture r1, ClosingFuture r2, ClosingFuture r3, ClosingFuture r4, AnonymousClass1 r5) {
            this(r1, r2, r3, r4);
        }

        static /* synthetic */ ClosingFuture access$2300(Combiner4 r0) {
            return r0.future1;
        }

        static /* synthetic */ ClosingFuture access$2400(Combiner4 r0) {
            return r0.future2;
        }

        static /* synthetic */ ClosingFuture access$2500(Combiner4 r0) {
            return r0.future3;
        }

        static /* synthetic */ ClosingFuture access$2600(Combiner4 r0) {
            return r0.future4;
        }

        private Combiner4(ClosingFuture<V1> r4, ClosingFuture<V2> r5, ClosingFuture<V3> r6, ClosingFuture<V4> r7) {
            boolean r2 = true;
            super(r2, ImmutableList.of(r4, r5, r6, r7), null);
            this.future1 = r4;
            this.future2 = r5;
            this.future3 = r6;
            this.future4 = r7;
        }

        public <U> ClosingFuture<U> call(final ClosingFunction4<V1, V2, V3, V4, U> r2, Executor r3) {
            return call(new AnonymousClass1(this, r2), r3);
        }

        public <U> ClosingFuture<U> callAsync(final AsyncClosingFunction4<V1, V2, V3, V4, U> r2, Executor r3) {
            return callAsync(new AnonymousClass2(this, r2), r3);
        }
    }

    public static final class Combiner5<V1, V2, V3, V4, V5> extends Combiner {
        private final ClosingFuture<V1> future1;
        private final ClosingFuture<V2> future2;
        private final ClosingFuture<V3> future3;
        private final ClosingFuture<V4> future4;
        private final ClosingFuture<V5> future5;

        @FunctionalInterface
        public interface AsyncClosingFunction5<V1, V2, V3, V4, V5, U> {
            ClosingFuture<U> apply(DeferredCloser r1, @ParametricNullness V1 r2, @ParametricNullness V2 r3, @ParametricNullness V3 r4, @ParametricNullness V4 r5, @ParametricNullness V5 r6) throws Exception;
        }

        @FunctionalInterface
        public interface ClosingFunction5<V1, V2, V3, V4, V5, U> {
            @ParametricNullness
            U apply(DeferredCloser r1, @ParametricNullness V1 r2, @ParametricNullness V2 r3, @ParametricNullness V3 r4, @ParametricNullness V4 r5, @ParametricNullness V5 r6) throws Exception;
        }

        /* synthetic */ Combiner5(ClosingFuture r1, ClosingFuture r2, ClosingFuture r3, ClosingFuture r4, ClosingFuture r5, AnonymousClass1 r6) {
            this(r1, r2, r3, r4, r5);
        }

        static /* synthetic */ ClosingFuture access$2700(Combiner5 r0) {
            return r0.future1;
        }

        static /* synthetic */ ClosingFuture access$2800(Combiner5 r0) {
            return r0.future2;
        }

        static /* synthetic */ ClosingFuture access$2900(Combiner5 r0) {
            return r0.future3;
        }

        static /* synthetic */ ClosingFuture access$3000(Combiner5 r0) {
            return r0.future4;
        }

        static /* synthetic */ ClosingFuture access$3100(Combiner5 r0) {
            return r0.future5;
        }

        private Combiner5(ClosingFuture<V1> r4, ClosingFuture<V2> r5, ClosingFuture<V3> r6, ClosingFuture<V4> r7, ClosingFuture<V5> r8) {
            boolean r2 = true;
            super(r2, ImmutableList.of(r4, r5, r6, r7, r8), null);
            this.future1 = r4;
            this.future2 = r5;
            this.future3 = r6;
            this.future4 = r7;
            this.future5 = r8;
        }

        public <U> ClosingFuture<U> call(final ClosingFunction5<V1, V2, V3, V4, V5, U> r2, Executor r3) {
            return call(new AnonymousClass1(this, r2), r3);
        }

        public <U> ClosingFuture<U> callAsync(final AsyncClosingFunction5<V1, V2, V3, V4, V5, U> r2, Executor r3) {
            return callAsync(new AnonymousClass2(this, r2), r3);
        }
    }

    public static final class DeferredCloser {
        private final CloseableList list;

        DeferredCloser(CloseableList r1) {
            this.list = r1;
        }

        @ParametricNullness
        public <C extends AutoCloseable> C eventuallyClose(@ParametricNullness C r2, Executor r3) {
            Preconditions.checkNotNull(r3);
            if (r2 == null) goto L5;
            this.list.add(r2, r3);
        L5:
            return r2;
        }
    }

    public static final class Peeker {
        private volatile boolean beingCalled;
        private final ImmutableList<ClosingFuture<?>> futures;

        /* synthetic */ Peeker(ImmutableList r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ Object access$1500(Peeker r0, Combiner.CombiningCallable r1, CloseableList r2) throws Exception {
            return r0.call(r1, r2);
        }

        static /* synthetic */ FluentFuture access$1700(Peeker r0, Combiner.AsyncCombiningCallable r1, CloseableList r2) throws Exception {
            return r0.callAsync(r1, r2);
        }

        private Peeker(ImmutableList<ClosingFuture<?>> r1) {
            this.futures = (ImmutableList) Preconditions.checkNotNull(r1);
        }

        @ParametricNullness
        public final <D> D getDone(ClosingFuture<D> r2) throws ExecutionException {
            Preconditions.checkState(this.beingCalled);
            Preconditions.checkArgument(this.futures.contains(r2));
            return (D) Futures.getDone(ClosingFuture.access$000(r2));
        }

        @ParametricNullness
        private <V> V call(Combiner.CombiningCallable<V> r4, CloseableList r5) throws Exception {
            this.beingCalled = true;
            CloseableList r0 = new CloseableList(null);
            V r6 = r4.call(CloseableList.access$300(r0), this);     // Catch: Throwable -> L6
            r5.add(r0, MoreExecutors.directExecutor());
            this.beingCalled = false;
            return r6;
        L6:
            th = move-exception;
            r5.add(r0, MoreExecutors.directExecutor());
            this.beingCalled = false;
            throw th;
        }

        private <V> FluentFuture<V> callAsync(Combiner.AsyncCombiningCallable<V> r4, CloseableList r5) throws Exception {
            this.beingCalled = true;
            CloseableList r0 = new CloseableList(null);
            ClosingFuture<V> r6 = r4.call(CloseableList.access$300(r0), this);     // Catch: Throwable -> L6
            ClosingFuture.access$1000(r6, r5);     // Catch: Throwable -> L6
            FluentFuture<V> r7 = ClosingFuture.access$000(r6);     // Catch: Throwable -> L6
            r5.add(r0, MoreExecutors.directExecutor());
            this.beingCalled = false;
            return r7;
        L6:
            th = move-exception;
            r5.add(r0, MoreExecutors.directExecutor());
            this.beingCalled = false;
            throw th;
        }
    }

    static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State CLOSED = null;
        public static final State CLOSING = null;
        public static final State OPEN = null;
        public static final State SUBSUMED = null;
        public static final State WILL_CLOSE = null;
        public static final State WILL_CREATE_VALUE_AND_CLOSER = null;

        private static /* synthetic */ State[] $values() {
            return new State[]{OPEN, SUBSUMED, WILL_CLOSE, CLOSING, CLOSED, WILL_CREATE_VALUE_AND_CLOSER};
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static State valueOf(String r1) {
            return (State) Enum.valueOf(State.class, r1);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        static {
            OPEN = new State("OPEN", 0);
            SUBSUMED = new State("SUBSUMED", 1);
            WILL_CLOSE = new State("WILL_CLOSE", 2);
            CLOSING = new State("CLOSING", 3);
            CLOSED = new State("CLOSED", 4);
            WILL_CREATE_VALUE_AND_CLOSER = new State("WILL_CREATE_VALUE_AND_CLOSER", 5);
            $VALUES = $values();
        }
    }

    public static final class ValueAndCloser<V> {
        private final ClosingFuture<? extends V> closingFuture;

        ValueAndCloser(ClosingFuture<? extends V> r1) {
            this.closingFuture = (ClosingFuture) Preconditions.checkNotNull(r1);
        }

        @ParametricNullness
        public V get() throws ExecutionException {
            return (V) Futures.getDone(ClosingFuture.access$000(this.closingFuture));
        }

        public void closeAsync() {
            ClosingFuture.access$100(this.closingFuture);
        }
    }

    @FunctionalInterface
    public interface ValueAndCloserConsumer<V> {
        void accept(ValueAndCloser<V> r1);
    }

    /* synthetic */ ClosingFuture(ListenableFuture r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ FluentFuture access$000(ClosingFuture r0) {
        return r0.future;
    }

    static /* synthetic */ void access$100(ClosingFuture r0) {
        r0.close();
    }

    static /* synthetic */ void access$1000(ClosingFuture r0, CloseableList r1) {
        r0.becomeSubsumedInto(r1);
    }

    static /* synthetic */ void access$1100(ClosingFuture r0, State r1, State r2) {
        r0.checkAndUpdateState(r1, r2);
    }

    static /* synthetic */ void access$1200(ValueAndCloserConsumer r0, ClosingFuture r1) {
        provideValueAndCloser(r0, r1);
    }

    static /* synthetic */ CloseableList access$200(ClosingFuture r0) {
        return r0.closeables;
    }

    static /* synthetic */ Logger access$3200() {
        return logger;
    }

    static /* synthetic */ void access$3300(AutoCloseable r0, Executor r1) {
        closeQuietly(r0, r1);
    }

    static {
        logger = Logger.getLogger(ClosingFuture.class.getName());
    }

    public static <V> ClosingFuture<V> submit(ClosingCallable<V> r1, Executor r2) {
        return new ClosingFuture(r1, r2);
    }

    public static <V> ClosingFuture<V> submitAsync(AsyncClosingCallable<V> r1, Executor r2) {
        return new ClosingFuture(r1, r2);
    }

    public static <V> ClosingFuture<V> from(ListenableFuture<V> r1) {
        return new ClosingFuture(r1);
    }

    @Deprecated
    public static <C extends AutoCloseable> ClosingFuture<C> eventuallyClosing(ListenableFuture<C> r2, final Executor r3) {
        Preconditions.checkNotNull(r3);
        final ClosingFuture<C> r0 = new ClosingFuture(Futures.nonCancellationPropagating(r2));
        Futures.addCallback(r2, new AnonymousClass1(r0, r3), MoreExecutors.directExecutor());
        return r0;
    }

    public static Combiner whenAllComplete(Iterable<? extends ClosingFuture<?>> r3) {
        return new Combiner(false, r3, null);
    }

    public static Combiner whenAllComplete(ClosingFuture<?> r0, ClosingFuture<?>... r1) {
        return whenAllComplete(Lists.asList(r0, r1));
    }

    public static Combiner whenAllSucceed(Iterable<? extends ClosingFuture<?>> r3) {
        return new Combiner(true, r3, null);
    }

    public static <V1, V2> Combiner2<V1, V2> whenAllSucceed(ClosingFuture<V1> r2, ClosingFuture<V2> r3) {
        return new Combiner2(r2, r3, null);
    }

    public static <V1, V2, V3> Combiner3<V1, V2, V3> whenAllSucceed(ClosingFuture<V1> r2, ClosingFuture<V2> r3, ClosingFuture<V3> r4) {
        return new Combiner3(r2, r3, r4, null);
    }

    public static <V1, V2, V3, V4> Combiner4<V1, V2, V3, V4> whenAllSucceed(ClosingFuture<V1> r7, ClosingFuture<V2> r8, ClosingFuture<V3> r9, ClosingFuture<V4> r10) {
        return new Combiner4(r7, r8, r9, r10, null);
    }

    public static <V1, V2, V3, V4, V5> Combiner5<V1, V2, V3, V4, V5> whenAllSucceed(ClosingFuture<V1> r8, ClosingFuture<V2> r9, ClosingFuture<V3> r10, ClosingFuture<V4> r11, ClosingFuture<V5> r12) {
        return new Combiner5(r8, r9, r10, r11, r12, null);
    }

    public static Combiner whenAllSucceed(ClosingFuture<?> r2, ClosingFuture<?> r3, ClosingFuture<?> r4, ClosingFuture<?> r5, ClosingFuture<?> r6, ClosingFuture<?> r7, ClosingFuture<?>... r8) {
        return whenAllSucceed(FluentIterable.of(r2, new ClosingFuture[]{r3, r4, r5, r6, r7}).append(r8));
    }

    private ClosingFuture(ListenableFuture<V> r3) {
        this.state = new AtomicReference(State.OPEN);
        this.closeables = new CloseableList(null);
        this.future = FluentFuture.from(r3);
    }

    private ClosingFuture(final ClosingCallable<V> r3, Executor r4) {
        this.state = new AtomicReference(State.OPEN);
        this.closeables = new CloseableList(null);
        Preconditions.checkNotNull(r3);
        TrustedListenableFutureTask r5 = TrustedListenableFutureTask.create(new AnonymousClass2(this, r3));
        r4.execute(r5);
        this.future = r5;
    }

    private ClosingFuture(final AsyncClosingCallable<V> r3, Executor r4) {
        this.state = new AtomicReference(State.OPEN);
        this.closeables = new CloseableList(null);
        Preconditions.checkNotNull(r3);
        TrustedListenableFutureTask r5 = TrustedListenableFutureTask.create(new AnonymousClass3(this, r3));
        r4.execute(r5);
        this.future = r5;
    }

    public ListenableFuture<?> statusFuture() {
        return Futures.nonCancellationPropagating(this.future.transform(Functions.constant(null), MoreExecutors.directExecutor()));
    }

    public <U> ClosingFuture<U> transform(final ClosingFunction<? super V, U> r2, Executor r3) {
        Preconditions.checkNotNull(r2);
        AsyncFunction<V, U> r0 = new AnonymousClass4(this, r2);
        return derive(this.future.transformAsync(r0, r3));
    }

    public <U> ClosingFuture<U> transformAsync(final AsyncClosingFunction<? super V, U> r2, Executor r3) {
        Preconditions.checkNotNull(r2);
        AsyncFunction<V, U> r0 = new AnonymousClass5(this, r2);
        return derive(this.future.transformAsync(r0, r3));
    }

    public static <V, U> AsyncClosingFunction<V, U> withoutCloser(final AsyncFunction<V, U> r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass6(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <X extends Throwable> ClosingFuture<V> catching(Class<X> r1, ClosingFunction<? super X, ? extends V> r2, Executor r3) {
        return catchingMoreGeneric(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    private <X extends Throwable, W extends V> ClosingFuture<V> catchingMoreGeneric(Class<X> r2, final ClosingFunction<? super X, W> r3, Executor r4) {
        Preconditions.checkNotNull(r3);
        Object r0 = new AnonymousClass7(this, r3);
        return (ClosingFuture<V>) derive(this.future.catchingAsync(r2, r0, r4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <X extends Throwable> ClosingFuture<V> catchingAsync(Class<X> r1, AsyncClosingFunction<? super X, ? extends V> r2, Executor r3) {
        return catchingAsyncMoreGeneric(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    private <X extends Throwable, W extends V> ClosingFuture<V> catchingAsyncMoreGeneric(Class<X> r2, final AsyncClosingFunction<? super X, W> r3, Executor r4) {
        Preconditions.checkNotNull(r3);
        Object r0 = new AnonymousClass8(this, r3);
        return (ClosingFuture<V>) derive(this.future.catchingAsync(r2, r0, r4));
    }

    public FluentFuture<V> finishToFuture() {
        if (compareAndUpdateState(State.OPEN, State.WILL_CLOSE) == false) goto L6;
        logger.log(Level.FINER, "will close {0}", this);
        this.future.addListener(new AnonymousClass9(this), MoreExecutors.directExecutor());
    L17:
        return this.future;
    L6:
        switch(AnonymousClass12.$SwitchMap$com$google$common$util$concurrent$ClosingFuture$State[this.state.get().ordinal()]) {
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L11;
            case 6: goto L9;
            default: goto L17;
        };
    L9:
        throw new AssertionError();
    L11:
        throw new IllegalStateException("Cannot call finishToFuture() twice");
    L13:
        throw new IllegalStateException("Cannot call finishToFuture() after calling finishToValueAndCloser()");
    L15:
        throw new IllegalStateException("Cannot call finishToFuture() after deriving another step");
    }

    public void finishToValueAndCloser(final ValueAndCloserConsumer<? super V> r3, Executor r4) {
        Preconditions.checkNotNull(r3);
        if (compareAndUpdateState(State.OPEN, State.WILL_CREATE_VALUE_AND_CLOSER) == true) goto L22;
        int r5 = AnonymousClass12.$SwitchMap$com$google$common$util$concurrent$ClosingFuture$State[this.state.get().ordinal()];
        if (r5 == 1) goto L21;
        if (r5 == 2) goto L19;
        if (r5 == 3) goto L17;
        if (r5 == 4) goto L17;
        if (r5 == 5) goto L17;
        throw new AssertionError(this.state);
    L17:
        throw new IllegalStateException("Cannot call finishToValueAndCloser() after calling finishToFuture()");
    L19:
        throw new IllegalStateException("Cannot call finishToValueAndCloser() twice");
    L21:
        throw new IllegalStateException("Cannot call finishToValueAndCloser() after deriving another step");
    L22:
        this.future.addListener(new AnonymousClass10(this, r3), r4);
    }

    private static <C, V extends C> void provideValueAndCloser(ValueAndCloserConsumer<C> r1, ClosingFuture<V> r2) {
        r1.accept(new ValueAndCloser(r2));
    }

    public boolean cancel(boolean r4) {
        logger.log(Level.FINER, "cancelling {0}", this);
        boolean r5 = this.future.cancel(r4);
        if (r5 == false) goto L5;
        close();
    L5:
        return r5;
    }

    private void close() {
        logger.log(Level.FINER, "closing {0}", this);
        this.closeables.close();
    }

    private <U> ClosingFuture<U> derive(FluentFuture<U> r2) {
        ClosingFuture<U> r0 = new ClosingFuture(r2);
        becomeSubsumedInto(r0.closeables);
        return r0;
    }

    private void becomeSubsumedInto(CloseableList r3) {
        checkAndUpdateState(State.OPEN, State.SUBSUMED);
        r3.add(this.closeables, MoreExecutors.directExecutor());
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("state", this.state.get()).addValue(this.future).toString();
    }

    protected void finalize() {
        if (this.state.get().equals(State.OPEN) == false) goto L6;
        logger.log(Level.SEVERE, "Uh oh! An open ClosingFuture has leaked and will close: {0}", this);
        finishToFuture();
        return;
    }

    private static void closeQuietly(@CheckForNull final AutoCloseable r5, Executor r6) {
        if (r5 != null) goto L12;
        return;
    L12:
        r6.execute(new AnonymousClass11(r5));     // Catch: RejectedExecutionException -> L6
        return;
    L6:
        e = move-exception;
        Logger r1 = logger;
        if (r1.isLoggable(Level.WARNING) == false) goto L10;
        r1.log(Level.WARNING, String.format("while submitting close to %s; will close inline", new Object[]{r6}), e);
    L10:
        closeQuietly(r5, MoreExecutors.directExecutor());
    }

    private void checkAndUpdateState(State r2, State r3) {
        Preconditions.checkState(compareAndUpdateState(r2, r3), "Expected state to be %s, but it was %s", r2, r3);
    }

    private boolean compareAndUpdateState(State r1, State r2) {
        return this.state.compareAndSet(r1, r2);
    }

    CountDownLatch whenClosedCountDown() {
        return this.closeables.whenClosedCountDown();
    }
}
