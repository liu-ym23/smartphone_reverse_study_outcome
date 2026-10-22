package com.obric.aikernel.phx.sdk.api;

import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AIKernelApi.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/obric/aikernel/sdk/data/PackageResource;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$updatePackage$2", f = "AIKernelApi.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, s = {})
final class AIKernelApi$updatePackage$2 extends SuspendLambda implements Function1<Continuation<? super Result<? extends PackageResource>>, Object> {
    final /* synthetic */ PackageResource $business;
    final /* synthetic */ RequestParams $params;
    int label;
    final /* synthetic */ AIKernelApi this$0;

    AIKernelApi$updatePackage$2(AIKernelApi r1, PackageResource r2, RequestParams r3, Continuation<? super AIKernelApi$updatePackage$2> r4) {
        this.this$0 = r1;
        this.$business = r2;
        this.$params = r3;
        super(1, r4);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r4) {
        return new AIKernelApi$updatePackage$2(this.this$0, this.$business, this.$params, r4);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Result<? extends PackageResource>> r1) {
        return invoke2(r1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Result<PackageResource>> r1) {
        return ((AIKernelApi$updatePackage$2) create(r1)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
        Object r5 = ((Result) r6).m1517unboximpl();
    L12:
        return Result.m1507boximpl(r5);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        r5 = AIKernelApi.m977access$updatePackageInner0E7RQCE(this.this$0, this.$business, this.$params, this);
        if (r5 != r0) goto L12;
        return r0;
    }
}
