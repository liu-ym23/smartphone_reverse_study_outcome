package com.obric.security.health.ui;

import android.os.Bundle;
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

/* JADX INFO: compiled from: OptimizeCenterViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.obric.security.health.ui.OptimizeCenterViewModel$eventCallback$1$onEvent$1", f = "OptimizeCenterViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class OptimizeCenterViewModel$eventCallback$1$onEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $param;
    int label;
    final /* synthetic */ OptimizeCenterViewModel$eventCallback$1 this$0;

    OptimizeCenterViewModel$eventCallback$1$onEvent$1(OptimizeCenterViewModel$eventCallback$1 r1, Bundle r2, Continuation r3) {
        this.this$0 = r1;
        this.$param = r2;
        super(2, r3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        return new OptimizeCenterViewModel$eventCallback$1$onEvent$1(this.this$0, this.$param, r3);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return ((OptimizeCenterViewModel$eventCallback$1$onEvent$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        OptimizeCenterViewModel.access$handleBinderEvent(this.this$0.this$0, this.$param);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
