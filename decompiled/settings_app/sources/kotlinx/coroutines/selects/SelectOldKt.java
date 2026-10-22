package kotlinx.coroutines.selects;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: compiled from: SelectOld.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\u001a8\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u001f\b\u0004\u0010\u0002\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0081Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a8\u0010\b\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u001f\b\u0004\u0010\u0002\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0081Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a%\u0010\t\u001a\u00020\u0005\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\f\u001a\u0002H\nH\u0002¢\u0006\u0002\u0010\r\u001a\u0018\u0010\u000e\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"selectOld", "R", "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectUnbiasedOld", "resumeUndispatched", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CancellableContinuation;", "result", "(Lkotlinx/coroutines/CancellableContinuation;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "exception", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SelectOldKt {
    public static final /* synthetic */ void access$resumeUndispatched(CancellableContinuation r0, Object r1) {
        resumeUndispatched(r0, r1);
    }

    public static final /* synthetic */ void access$resumeUndispatchedWithException(CancellableContinuation r0, Throwable r1) {
        resumeUndispatchedWithException(r0, r1);
    }

    private static final <R> Object selectOld$$forInline(Function1<? super SelectBuilder<? super R>, Unit> r1, Continuation<? super R> r2) {
        InlineMarker.mark(0);
        SelectBuilderImpl r0 = new SelectBuilderImpl(r2);
        r1.invoke(r0);     // Catch: Throwable -> L5
    L7:
        Object r3 = r0.getResult();
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L10:
        InlineMarker.mark(1);
        return r3;
    L5:
        th = move-exception;
        r0.handleBuilderException(th);
        goto L7
    }

    public static final <R> Object selectOld(Function1<? super SelectBuilder<? super R>, Unit> r1, Continuation<? super R> r2) {
        SelectBuilderImpl r0 = new SelectBuilderImpl(r2);
        r1.invoke(r0);     // Catch: Throwable -> L5
    L7:
        Object r3 = r0.getResult();
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L10:
        return r3;
    L5:
        th = move-exception;
        r0.handleBuilderException(th);
        goto L7
    }

    private static final <R> Object selectUnbiasedOld$$forInline(Function1<? super SelectBuilder<? super R>, Unit> r1, Continuation<? super R> r2) {
        InlineMarker.mark(0);
        UnbiasedSelectBuilderImpl r0 = new UnbiasedSelectBuilderImpl(r2);
        r1.invoke(r0);     // Catch: Throwable -> L5
    L7:
        Object r3 = r0.initSelectResult();
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L10:
        InlineMarker.mark(1);
        return r3;
    L5:
        th = move-exception;
        r0.handleBuilderException(th);
        goto L7
    }

    public static final <R> Object selectUnbiasedOld(Function1<? super SelectBuilder<? super R>, Unit> r1, Continuation<? super R> r2) {
        UnbiasedSelectBuilderImpl r0 = new UnbiasedSelectBuilderImpl(r2);
        r1.invoke(r0);     // Catch: Throwable -> L5
    L7:
        Object r3 = r0.initSelectResult();
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L10:
        return r3;
    L5:
        th = move-exception;
        r0.handleBuilderException(th);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> void resumeUndispatched(CancellableContinuation<? super T> r2, T r3) {
        CoroutineDispatcher r0 = (CoroutineDispatcher) r2.getContext().get(CoroutineDispatcher.Key);
        if (r0 == null) goto L5;
        r2.resumeUndispatched(r0, r3);
        return;
    L5:
        Result.Companion r1 = Result.Companion;
        r2.resumeWith(Result.m1508constructorimpl(r3));
    }

    private static final void resumeUndispatchedWithException(CancellableContinuation<?> r2, Throwable r3) {
        CoroutineDispatcher r0 = (CoroutineDispatcher) r2.getContext().get(CoroutineDispatcher.Key);
        if (r0 == null) goto L5;
        r2.resumeUndispatchedWithException(r0, r3);
        return;
    L5:
        Result.Companion r1 = Result.Companion;
        r2.resumeWith(Result.m1508constructorimpl(ResultKt.createFailure(r3)));
    }
}
