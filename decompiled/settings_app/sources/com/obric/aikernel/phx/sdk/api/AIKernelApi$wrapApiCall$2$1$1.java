package com.obric.aikernel.phx.sdk.api;

import android.os.IBinder;
import androidx.exifinterface.media.ExifInterface;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.TransactHandle;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.config.RequestParams;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AIKernelApi.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$wrapApiCall$2$1$1", f = "AIKernelApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AIKernelApi$wrapApiCall$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AIKBinder $binder;
    final /* synthetic */ Throwable $cause;
    final /* synthetic */ int $event;
    final /* synthetic */ RequestParams $params;
    int label;

    AIKernelApi$wrapApiCall$2$1$1(RequestParams r1, int r2, Throwable r3, AIKBinder r4, Continuation<? super AIKernelApi$wrapApiCall$2$1$1> r5) {
        this.$params = r1;
        this.$event = r2;
        this.$cause = r3;
        this.$binder = r4;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new AIKernelApi$wrapApiCall$2$1$1(this.$params, this.$event, this.$cause, this.$binder, r8);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
        return ((AIKernelApi$wrapApiCall$2$1$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r6);
        AIKLog.INSTANCE.i(AIKernelApi.TAG, "[SDK] client req " + this.$params.getTraceIdStr() + " competed by event " + this.$event + " cause: " + this.$cause);
        TransactHandle r7 = TransactHandle.INSTANCE;
        IBinder r0 = this.$binder.asBinder();
        Intrinsics.checkNotNullExpressionValue(r0, "binder.asBinder()");
        final RequestParams r3 = this.$params;
        r7.notifyRequestComplete(r0, new RequestParams(null, new AnonymousClass1(r3), 1, null), this.$event);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
