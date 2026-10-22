package androidx.work;

import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: ListenableFuture.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, d2 = {"await", "R", "Lcom/google/common/util/concurrent/ListenableFuture;", "(Lcom/google/common/util/concurrent/ListenableFuture;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "work-runtime-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ListenableFutureKt {
    public static final <R> Object await(ListenableFuture<R> r4, Continuation<? super R> r5) {
        if (r4.isDone() == true) goto L15;
        CancellableContinuationImpl r0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r5), 1);
        r0.initCancellability();
        CancellableContinuationImpl r1 = r0;
        r4.addListener(new ListenableFutureKt$await$2$1(r1, r4), DirectExecutor.INSTANCE);
        r1.invokeOnCancellation(new ListenableFutureKt$await$2$2(r4));
        Object r6 = r0.getResult();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L14:
        return r6;
    L15:
        return r4.get();
    L6:
        e = move-exception;
        Throwable r7 = e.getCause();
        if (r7 == null) goto L10;
        throw r7;
    L10:
        throw e;
    }

    private static final <R> Object await$$forInline(ListenableFuture<R> r5, Continuation<? super R> r6) {
        if (r5.isDone() == true) goto L17;
        InlineMarker.mark(0);
        CancellableContinuationImpl r0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r6), 1);
        r0.initCancellability();
        CancellableContinuationImpl r1 = r0;
        r5.addListener(new ListenableFutureKt$await$2$1(r1, r5), DirectExecutor.INSTANCE);
        r1.invokeOnCancellation(new ListenableFutureKt$await$2$2(r5));
        Unit r7 = Unit.INSTANCE;
        Object r8 = r0.getResult();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L15:
        InlineMarker.mark(1);
        return r8;
    L17:
        return r5.get();
    L6:
        e = move-exception;
        Throwable r9 = e.getCause();
        if (r9 == null) goto L11;
        throw r9;
    L11:
        throw e;
    }
}
