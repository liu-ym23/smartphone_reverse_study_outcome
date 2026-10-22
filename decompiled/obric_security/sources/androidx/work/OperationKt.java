package androidx.work;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: Operation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, d2 = {"await", "Landroidx/work/Operation$State$SUCCESS;", "Landroidx/work/Operation;", "(Landroidx/work/Operation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "work-runtime-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class OperationKt {

    /* JADX INFO: renamed from: androidx.work.OperationKt$await$1, reason: invalid class name */
    /* JADX INFO: compiled from: Operation.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 176)
    @DebugMetadata(c = "androidx.work.OperationKt", f = "Operation.kt", i = {0}, l = {39}, m = "await", n = {"$this$await$iv"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return OperationKt.await(null, this);
        }
    }

    public static final Object await(Operation r5, Continuation<? super Operation.State.SUCCESS> r6) {
        if ((r6 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r6;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ListenableFuture r8 = (ListenableFuture) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L28:
        Object r9 = r7;
    L29:
        Intrinsics.checkNotNullExpressionValue(r9, "result.await()");
        return r9;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        ListenableFuture<Operation.State.SUCCESS> r10 = r5.getResult();
        Intrinsics.checkNotNullExpressionValue(r10, "result");
        if (r10.isDone() == true) goto L31;
        r0.L$0 = r10;
        r0.label = 1;
        CancellableContinuationImpl r11 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r0), 1);
        r11.initCancellability();
        CancellableContinuationImpl r3 = r11;
        r10.addListener(new ListenableFutureKt$await$2$1(r3, r10), DirectExecutor.INSTANCE);
        r3.invokeOnCancellation(new ListenableFutureKt$await$2$2(r10));
        r7 = r11.getResult();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L26:
        if (r7 != r1) goto L28;
        return r1;
    L31:
        r9 = r10.get();     // Catch: ExecutionException -> L18
    L18:
        e = move-exception;
        Throwable r12 = e.getCause();
        if (r12 == null) goto L22;
        throw r12;
    L22:
        throw e;
    L7:
        r0 = new AnonymousClass1(r6);
        goto L8
    }

    private static final Object await$$forInline(Operation r5, Continuation<? super Operation.State.SUCCESS> r6) {
        ListenableFuture<Operation.State.SUCCESS> r7 = r5.getResult();
        Intrinsics.checkNotNullExpressionValue(r7, "result");
        if (r7.isDone() == true) goto L18;
        InlineMarker.mark(0);
        CancellableContinuationImpl r0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r6), 1);
        r0.initCancellability();
        CancellableContinuationImpl r1 = r0;
        r7.addListener(new ListenableFutureKt$await$2$1(r1, r7), DirectExecutor.INSTANCE);
        r1.invokeOnCancellation(new ListenableFutureKt$await$2$2(r7));
        Unit r8 = Unit.INSTANCE;
        Object r9 = r0.getResult();
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L15:
        InlineMarker.mark(1);
    L16:
        Intrinsics.checkNotNullExpressionValue(r9, "result.await()");
        return r9;
    L18:
        r9 = r7.get();     // Catch: ExecutionException -> L6
    L6:
        e = move-exception;
        Throwable r10 = e.getCause();
        if (r10 == null) goto L11;
        throw r10;
    L11:
        throw e;
    }
}
