package com.obric.security.mainpage.block;

import android.content.Context;
import com.obric.safecheck.riskcontrol.ui.RiskAppListActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SafeCheckBlock.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.obric.security.mainpage.block.SafeCheckBlock$onResume$1$riskCount$1", f = "SafeCheckBlock.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SafeCheckBlock$onResume$1$riskCount$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    int label;
    final /* synthetic */ SafeCheckBlock.AnonymousClass1 this$0;

    SafeCheckBlock$onResume$1$riskCount$1(SafeCheckBlock.AnonymousClass1 r1, Continuation r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "completion");
        return new SafeCheckBlock$onResume$1$riskCount$1(this.this$0, r2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r1, Continuation<? super Integer> r2) {
        return ((SafeCheckBlock$onResume$1$riskCount$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        RiskAppListActivity.Companion r3 = RiskAppListActivity.Companion;
        Context r1 = this.this$0.$context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r1, "context.applicationContext");
        return Boxing.boxInt(r3.getUncontrolledRiskAppCount(r1));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
