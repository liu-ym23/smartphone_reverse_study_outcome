package com.obric.security.health.engine;

import android.content.Context;
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

/* JADX INFO: compiled from: HealthTaskManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Lcom/obric/security/health/engine/HealthTaskManager$TaskExecution;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/obric/security/health/engine/HealthTaskManager$execute$executions$1$1$1"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.obric.security.health.engine.HealthTaskManager$execute$executions$1$1$1", f = "HealthTaskManager.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
final class HealthTaskManager$execute$executions$1$invokeSuspend$$inlined$map$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HealthTaskManager.TaskExecution>, Object> {
    final /* synthetic */ String $itemId;
    final /* synthetic */ CoroutineScope $this_coroutineScope$inlined;
    int label;
    final /* synthetic */ HealthTaskManager$execute$executions$1 this$0;

    HealthTaskManager$execute$executions$1$invokeSuspend$$inlined$map$lambda$1(String r1, Continuation r2, HealthTaskManager$execute$executions$1 r3, CoroutineScope r4) {
        this.$itemId = r1;
        this.this$0 = r3;
        this.$this_coroutineScope$inlined = r4;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        return new HealthTaskManager$execute$executions$1$invokeSuspend$$inlined$map$lambda$1(this.$itemId, r4, this.this$0, this.$this_coroutineScope$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r1, Continuation<? super HealthTaskManager.TaskExecution> r2) {
        return ((HealthTaskManager$execute$executions$1$invokeSuspend$$inlined$map$lambda$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        HealthTaskManager r3 = this.this$0.this$0;
        String r4 = this.$itemId;
        HealthTaskStage r5 = this.this$0.$stage;
        Context r6 = this.this$0.$runtimeContext;
        this.label = 1;
        r10 = HealthTaskManager.access$executeOneWithProfile(r3, r4, r5, r6, true, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
