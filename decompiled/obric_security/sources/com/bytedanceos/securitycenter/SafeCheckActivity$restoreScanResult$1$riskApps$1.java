package com.bytedanceos.securitycenter;

import com.bytedanceos.securitycenter.scan.SafeCheckRiskAppItem;
import java.util.List;
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

/* JADX INFO: compiled from: SafeCheckActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Lcom/bytedanceos/securitycenter/scan/SafeCheckRiskAppItem;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedanceos.securitycenter.SafeCheckActivity$restoreScanResult$1$riskApps$1", f = "SafeCheckActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SafeCheckActivity$restoreScanResult$1$riskApps$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends SafeCheckRiskAppItem>>, Object> {
    int label;
    final /* synthetic */ SafeCheckActivity.C01591 this$0;

    SafeCheckActivity$restoreScanResult$1$riskApps$1(SafeCheckActivity.C01591 r1, Continuation r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "completion");
        return new SafeCheckActivity$restoreScanResult$1$riskApps$1(this.this$0, r2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r1, Continuation<? super List<? extends SafeCheckRiskAppItem>> r2) {
        return ((SafeCheckActivity$restoreScanResult$1$riskApps$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        return SafeCheckActivity.access$getRiskAppUseCase$p(this.this$0.this$0).collectRiskApps(this.this$0.$allResults);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
