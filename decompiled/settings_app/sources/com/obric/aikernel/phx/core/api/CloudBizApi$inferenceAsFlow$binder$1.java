package com.obric.aikernel.phx.core.api;

import com.obric.aikernel.sdk.response.Response;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: CloudBizApi.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001*\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/obric/aikernel/sdk/response/Response;", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.phx.core.api.CloudBizApi$inferenceAsFlow$binder$1", f = "CloudBizApi.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
final class CloudBizApi$inferenceAsFlow$binder$1 extends SuspendLambda implements Function2<FlowCollector<? super Response<Object>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    CloudBizApi$inferenceAsFlow$binder$1(Continuation<? super CloudBizApi$inferenceAsFlow$binder$1> r2) {
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        CloudBizApi$inferenceAsFlow$binder$1 r0 = new CloudBizApi$inferenceAsFlow$binder$1(r2);
        r0.L$0 = r1;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Response<Object>> r1, Continuation<? super Unit> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super Response<Object>> r1, Continuation<? super Unit> r2) {
        return ((CloudBizApi$inferenceAsFlow$binder$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        this.label = 1;
        if (((FlowCollector) this.L$0).emit(new Response(102, null, null, false, false, null, null, 126, null), this) != r0) goto L12;
        return r0;
    }
}
