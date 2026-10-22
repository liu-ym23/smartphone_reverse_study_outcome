package kotlinx.coroutines.future;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: Future.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0005\u001a\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a!\u0010\b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a[\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2'\u0010\u0010\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011¢\u0006\u0002\b\u0014ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a\u0018\u0010\u0016\u001a\u00020\u0004*\u00020\u00052\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"asCompletableFuture", "Ljava/util/concurrent/CompletableFuture;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/Deferred;", "", "Lkotlinx/coroutines/Job;", "asDeferred", "Ljava/util/concurrent/CompletionStage;", "await", "(Ljava/util/concurrent/CompletionStage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "future", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Ljava/util/concurrent/CompletableFuture;", "setupCancellation", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FutureKt {
    public static /* synthetic */ Object $r8$lambda$cMgNW2d0OUgIe_VSg9ZnIbI9BYk(Function2 r0, Object r1, Throwable r2) {
        return asDeferred$lambda$4(r0, r1, r2);
    }

    public static /* synthetic */ Unit $r8$lambda$fyhs1ohzwEwbEqWUL9pjUeRyd8k(Job r0, Object r1, Throwable r2) {
        return setupCancellation$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ CompletableFuture future$default(CoroutineScope r0, EmptyCoroutineContext r1, CoroutineStart r2, Function2 r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = CoroutineStart.DEFAULT;
    L9:
        return future(r0, r1, r2, r3);
    }

    public static final <T> CompletableFuture<T> future(CoroutineScope r1, CoroutineContext r2, CoroutineStart r3, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r4) {
        if ((!r3.isLazy()) == false) goto L7;
        CoroutineContext r5 = CoroutineContextKt.newCoroutineContext(r1, r2);
        CompletableFuture<T> r6 = new CompletableFuture();
        CompletableFutureCoroutine r0 = new CompletableFutureCoroutine(r5, r6);
        r6.handle(r0);
        r0.start(r3, r0, r4);
        return r6;
    L7:
        throw new IllegalArgumentException((r3 + " start is not supported").toString());
    }

    public static final <T> CompletableFuture<T> asCompletableFuture(final Deferred<? extends T> r2) {
        final CompletableFuture<T> r0 = new CompletableFuture();
        setupCancellation(r2, r0);
        r2.invokeOnCompletion(new AnonymousClass1(r0, r2));
        return r0;
    }

    public static final CompletableFuture<Unit> asCompletableFuture(Job r2) {
        final CompletableFuture<Unit> r0 = new CompletableFuture();
        setupCancellation(r2, r0);
        r2.invokeOnCompletion(new AnonymousClass2(r0));
        return r0;
    }

    private static final void setupCancellation(final Job r1, CompletableFuture<?> r2) {
        r2.handle(new FutureKt$$ExternalSyntheticLambda1(r1));
    }

    private static final Unit setupCancellation$lambda$2(Job r1, Object r2, Throwable r3) {
        CancellationException r4 = null;
        if (r3 != null) goto L5;
    L9:
        r1.cancel(r4);
        return Unit.INSTANCE;
    L5:
        if ((r3 instanceof CancellationException) == false) goto L7;
        r4 = (CancellationException) r3;
    L7:
        if (r4 != null) goto L9;
        r4 = ExceptionsKt.CancellationException("CompletableFuture was completed exceptionally", r3);
        goto L9
    }

    public static final <T> Deferred<T> asDeferred(CompletionStage<T> r4) {
        CompletableFuture<T> r0 = r4.toCompletableFuture();
        if (r0.isDone() == true) goto L20;
        final CompletableDeferred r1 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        final Function2<T, Throwable, Object> r2 = new C04312(r1);
        r4.handle(new FutureKt$$ExternalSyntheticLambda0(r2));
        JobKt.cancelFutureOnCompletion(r1, r0);
        return r1;
    L20:
        return CompletableDeferredKt.CompletableDeferred(r0.get());
    L6:
        th = th;
        if ((th instanceof ExecutionException) == false) goto L10;
        ExecutionException r3 = (ExecutionException) th;
    L11:
        if (r3 == null) goto L16;
        Throwable r5 = r3.getCause();
        if (r5 == null) goto L16;
        th = r5;
    L16:
        CompletableDeferred r6 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        r6.completeExceptionally(th);
        return r6;
    L10:
        r3 = null;
        goto L11
    }

    private static final Object asDeferred$lambda$4(Function2 r0, Object r1, Throwable r2) {
        return r0.invoke(r1, r2);
    }

    public static final <T> Object await(CompletionStage<T> r5, Continuation<? super T> r6) {
        final CompletableFuture<T> r0 = r5.toCompletableFuture();
        if (r0.isDone() == true) goto L15;
        CancellableContinuationImpl r1 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r6), 1);
        r1.initCancellability();
        CancellableContinuationImpl r2 = r1;
        final ContinuationHandler r3 = new ContinuationHandler(r2);
        r5.handle(r3);
        r2.invokeOnCancellation(new FutureKt$await$2$1(r0, r3));
        Object r7 = r1.getResult();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L14:
        return r7;
    L15:
        return r0.get();
    L6:
        e = move-exception;
        Throwable r8 = e.getCause();
        if (r8 == null) goto L10;
        throw r8;
    L10:
        throw e;
    }
}
