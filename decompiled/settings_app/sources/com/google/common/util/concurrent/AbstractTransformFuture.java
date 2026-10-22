package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractTransformFuture<I, O, F, T> extends FluentFuture.TrustedFuture<O> implements Runnable {

    @CheckForNull
    F function;

    @CheckForNull
    ListenableFuture<? extends I> inputFuture;

    private static final class AsyncTransformFuture<I, O> extends AbstractTransformFuture<I, O, AsyncFunction<? super I, ? extends O>, ListenableFuture<? extends O>> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        /* bridge */ /* synthetic */ Object doTransform(Object r1, @ParametricNullness Object r2) throws Exception {
            return doTransform((AsyncFunction) r1, r2);
        }

        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        /* bridge */ /* synthetic */ void setResult(Object r1) {
            setResult((ListenableFuture) r1);
        }

        AsyncTransformFuture(ListenableFuture<? extends I> r1, AsyncFunction<? super I, ? extends O> r2) {
            super(r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        ListenableFuture<? extends O> doTransform(AsyncFunction<? super I, ? extends O> r1, @ParametricNullness I r2) throws Exception {
            ListenableFuture<? extends O> r0 = r1.apply(r2);
            Preconditions.checkNotNull(r0, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", r1);
            return r0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void setResult(ListenableFuture<? extends O> r1) {
            setFuture(r1);
        }
    }

    private static final class TransformFuture<I, O> extends AbstractTransformFuture<I, O, Function<? super I, ? extends O>, O> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        @ParametricNullness
        /* bridge */ /* synthetic */ Object doTransform(Object r1, @ParametricNullness Object r2) throws Exception {
            return doTransform((Function) r1, r2);
        }

        TransformFuture(ListenableFuture<? extends I> r1, Function<? super I, ? extends O> r2) {
            super(r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @ParametricNullness
        O doTransform(Function<? super I, ? extends O> r1, @ParametricNullness I r2) {
            return r1.apply(r2);
        }

        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        void setResult(@ParametricNullness O r1) {
            set(r1);
        }
    }

    @ParametricNullness
    abstract T doTransform(F r1, @ParametricNullness I r2) throws Exception;

    abstract void setResult(@ParametricNullness T r1);

    static <I, O> ListenableFuture<O> create(ListenableFuture<I> r1, AsyncFunction<? super I, ? extends O> r2, Executor r3) {
        Preconditions.checkNotNull(r3);
        AsyncTransformFuture r0 = new AsyncTransformFuture(r1, r2);
        r1.addListener(r0, MoreExecutors.rejectionPropagatingExecutor(r3, r0));
        return r0;
    }

    static <I, O> ListenableFuture<O> create(ListenableFuture<I> r1, Function<? super I, ? extends O> r2, Executor r3) {
        Preconditions.checkNotNull(r2);
        TransformFuture r0 = new TransformFuture(r1, r2);
        r1.addListener(r0, MoreExecutors.rejectionPropagatingExecutor(r3, r0));
        return r0;
    }

    AbstractTransformFuture(ListenableFuture<? extends I> r1, F r2) {
        this.inputFuture = (ListenableFuture) Preconditions.checkNotNull(r1);
        this.function = (F) Preconditions.checkNotNull(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture<? extends I> r0 = this.inputFuture;
        F r1 = this.function;
        boolean r2 = isCancelled();
        boolean r3 = true;
        if (r0 != null) goto L5;
        boolean r5 = true;
    L6:
        boolean r4 = r2 | r5;
        if (r1 == null) goto L11;
        r3 = false;
    L11:
        if ((r4 | r3) == false) goto L13;
        return;
    L13:
        this.inputFuture = null;
        if (r0.isCancelled() == false) goto L43;
        setFuture(r0);
        return;
    L43:
        Object r6 = doTransform(r1, Futures.getDone(r0));     // Catch: Throwable -> L21
        this.function = null;
        setResult(r6);
        return;
    L21:
        th = move-exception;
        setException(th);     // Catch: Throwable -> L25
        this.function = null;
        return;
    L25:
        th = move-exception;
        this.function = null;
        throw th;
    L28:
        e = move-exception;
        setException(e);
        return;
    L37:
        cancel(false);
        return;
    L31:
        e = move-exception;
        setException(e);
        return;
    L34:
        e = move-exception;
        setException(e.getCause());
        return;
    L5:
        r5 = false;
        goto L6
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.function = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CheckForNull
    protected String pendingToString() {
        ListenableFuture<? extends I> r0 = this.inputFuture;
        F r1 = this.function;
        String r4 = super.pendingToString();
        if (r0 == null) goto L5;
        String r2 = String.valueOf(r0);
        String r3 = new StringBuilder(String.valueOf(r2).length() + 16).append("inputFuture=[").append(r2).append("], ").toString();
    L6:
        if (r1 == null) goto L9;
        String r5 = String.valueOf(r1);
        return new StringBuilder((String.valueOf(r3).length() + 11) + String.valueOf(r5).length()).append(r3).append("function=[").append(r5).append("]").toString();
    L9:
        if (r4 == null) goto L15;
        String r6 = String.valueOf(r3);
        String r7 = String.valueOf(r4);
        if (r7.length() == 0) goto L14;
        return r6.concat(r7);
    L14:
        return new String(r6);
    L15:
        return null;
    L5:
        r3 = "";
        goto L6
    }
}
