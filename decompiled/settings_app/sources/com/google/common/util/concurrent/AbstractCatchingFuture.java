package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import java.lang.Throwable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractCatchingFuture<V, X extends Throwable, F, T> extends FluentFuture.TrustedFuture<V> implements Runnable {

    @CheckForNull
    Class<X> exceptionType;

    @CheckForNull
    F fallback;

    @CheckForNull
    ListenableFuture<? extends V> inputFuture;

    private static final class AsyncCatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, AsyncFunction<? super X, ? extends V>, ListenableFuture<? extends V>> {
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        /* bridge */ /* synthetic */ Object doFallback(Object r1, Throwable r2) throws Exception {
            return doFallback((AsyncFunction) r1, r2);
        }

        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        /* bridge */ /* synthetic */ void setResult(Object r1) {
            setResult((ListenableFuture) r1);
        }

        AsyncCatchingFuture(ListenableFuture<? extends V> r1, Class<X> r2, AsyncFunction<? super X, ? extends V> r3) {
            super(r1, r2, r3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        ListenableFuture<? extends V> doFallback(AsyncFunction<? super X, ? extends V> r1, X r2) throws Exception {
            ListenableFuture<? extends V> r0 = r1.apply(r2);
            Preconditions.checkNotNull(r0, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", r1);
            return r0;
        }

        void setResult(ListenableFuture<? extends V> r1) {
            setFuture(r1);
        }
    }

    private static final class CatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, Function<? super X, ? extends V>, V> {
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        @ParametricNullness
        /* bridge */ /* synthetic */ Object doFallback(Object r1, Throwable r2) throws Exception {
            return doFallback((Function) r1, r2);
        }

        CatchingFuture(ListenableFuture<? extends V> r1, Class<X> r2, Function<? super X, ? extends V> r3) {
            super(r1, r2, r3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @ParametricNullness
        V doFallback(Function<? super X, ? extends V> r1, X r2) throws Exception {
            return r1.apply(r2);
        }

        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        void setResult(@ParametricNullness V r1) {
            set(r1);
        }
    }

    @ParametricNullness
    abstract T doFallback(F r1, X r2) throws Exception;

    abstract void setResult(@ParametricNullness T r1);

    static <V, X extends Throwable> ListenableFuture<V> create(ListenableFuture<? extends V> r1, Class<X> r2, Function<? super X, ? extends V> r3, Executor r4) {
        CatchingFuture r0 = new CatchingFuture(r1, r2, r3);
        r1.addListener(r0, MoreExecutors.rejectionPropagatingExecutor(r4, r0));
        return r0;
    }

    static <X extends Throwable, V> ListenableFuture<V> create(ListenableFuture<? extends V> r1, Class<X> r2, AsyncFunction<? super X, ? extends V> r3, Executor r4) {
        AsyncCatchingFuture r0 = new AsyncCatchingFuture(r1, r2, r3);
        r1.addListener(r0, MoreExecutors.rejectionPropagatingExecutor(r4, r0));
        return r0;
    }

    AbstractCatchingFuture(ListenableFuture<? extends V> r1, Class<X> r2, F r3) {
        this.inputFuture = (ListenableFuture) Preconditions.checkNotNull(r1);
        this.exceptionType = (Class) Preconditions.checkNotNull(r2);
        this.fallback = (F) Preconditions.checkNotNull(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture<? extends V> r0 = this.inputFuture;
        Class<X> r1 = this.exceptionType;
        F r2 = this.fallback;
        boolean r3 = true;
        if (r0 != 0) goto L5;
        boolean r5 = true;
    L6:
        if (r1 != null) goto L8;
        boolean r6 = true;
    L9:
        boolean r7 = r5 | r6;
        if (r2 == null) goto L14;
        r3 = false;
    L14:
        if ((r3 | r7) == false) goto L16;
        return;
    L16:
        if (isCancelled() == true) goto L57;
        this.inputFuture = null;
    L28:
        e = move-exception;
        Throwable r8 = e.getCause();
        if (r8 != null) goto L32;
        String r9 = String.valueOf(r0.getClass());
        String r4 = String.valueOf(e.getClass());
        r8 = new NullPointerException(new StringBuilder((String.valueOf(r9).length() + 35) + String.valueOf(r4).length()).append("Future type ").append(r9).append(" threw ").append(r4).append(" without a cause").toString());
    L32:
        th = r8;
    L27:
        Object r10 = null;
    L33:
        if (th != null) goto L37;
        set(NullnessCasts.uncheckedCastNullableTToT(r10));
        return;
    L37:
        if (Platform.isInstanceOfThrowableClass(th, r1) == true) goto L51;
        setFuture(r0);
        return;
    L51:
        Object r11 = doFallback(r2, th);     // Catch: Throwable -> L43
        this.exceptionType = null;
        this.fallback = null;
        setResult(r11);
        return;
    L43:
        th = move-exception;
        setException(th);     // Catch: Throwable -> L47
        this.exceptionType = null;
        this.fallback = null;
        return;
    L47:
        th = move-exception;
        this.exceptionType = null;
        this.fallback = null;
        throw th;
    L26:
        th = th;
        goto L27
    L20:
        if ((r0 instanceof InternalFutureFailureAccess) == false) goto L22;
        th = InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess) r0);     // Catch: Throwable -> L26 ExecutionException -> L28
    L23:
        if (th != null) goto L27;
        r10 = Futures.getDone(r0);     // Catch: Throwable -> L26 ExecutionException -> L28
    L22:
        th = null;
        goto L23
    L57:
        return;
    L8:
        r6 = false;
        goto L9
    L5:
        r5 = false;
        goto L6
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CheckForNull
    protected String pendingToString() {
        ListenableFuture<? extends V> r0 = this.inputFuture;
        Class<X> r1 = this.exceptionType;
        F r2 = this.fallback;
        String r5 = super.pendingToString();
        if (r0 == null) goto L5;
        String r3 = String.valueOf(r0);
        String r4 = new StringBuilder(String.valueOf(r3).length() + 16).append("inputFuture=[").append(r3).append("], ").toString();
    L6:
        if (r1 == null) goto L10;
        if (r2 == null) goto L10;
        String r6 = String.valueOf(r1);
        String r7 = String.valueOf(r2);
        return new StringBuilder(((String.valueOf(r4).length() + 29) + String.valueOf(r6).length()) + String.valueOf(r7).length()).append(r4).append("exceptionType=[").append(r6).append("], fallback=[").append(r7).append("]").toString();
    L10:
        if (r5 == null) goto L16;
        String r8 = String.valueOf(r4);
        String r9 = String.valueOf(r5);
        if (r9.length() == 0) goto L15;
        return r8.concat(r9);
    L15:
        return new String(r8);
    L16:
        return null;
    L5:
        r4 = "";
        goto L6
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.exceptionType = null;
        this.fallback = null;
    }
}
