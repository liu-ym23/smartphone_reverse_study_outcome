package com.obric.security.health.engine;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: HealthTaskManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Lcom/obric/security/health/engine/HealthTaskManager$TaskExecution;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.obric.security.health.engine.HealthTaskManager$execute$executions$1", f = "HealthTaskManager.kt", i = {0}, l = {119}, m = "invokeSuspend", n = {"destination$iv$iv"}, s = {"L$0"})
final class HealthTaskManager$execute$executions$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends HealthTaskManager.TaskExecution>>, Object> {
    final /* synthetic */ List $itemIds;
    final /* synthetic */ Context $runtimeContext;
    final /* synthetic */ HealthTaskStage $stage;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ HealthTaskManager this$0;

    HealthTaskManager$execute$executions$1(HealthTaskManager r1, List r2, HealthTaskStage r3, Context r4, Continuation r5) {
        this.this$0 = r1;
        this.$itemIds = r2;
        this.$stage = r3;
        this.$runtimeContext = r4;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        Intrinsics.checkNotNullParameter(r9, "completion");
        HealthTaskManager$execute$executions$1 r0 = new HealthTaskManager$execute$executions$1(this.this$0, this.$itemIds, this.$stage, this.$runtimeContext, r9);
        r0.L$0 = r8;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r1, Continuation<? super List<? extends HealthTaskManager.TaskExecution>> r2) {
        return ((HealthTaskManager$execute$executions$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0092 -> B:19:0x0093). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Collection r2 = (Collection) this.L$2;
        Iterator r3 = (Iterator) this.L$1;
        Collection r4 = (Collection) this.L$0;
        ResultKt.throwOnFailure(r12);
    L19:
        r2.add((HealthTaskManager.TaskExecution) r12);
        r2 = r4;
    L14:
        if (r3.hasNext() == false) goto L21;
        Deferred r13 = (Deferred) r3.next();
        this.L$0 = r2;
        this.L$1 = r3;
        this.L$2 = r2;
        this.label = 1;
        r12 = r13.await(this);
        if (r12 != r0) goto L18;
        return r0;
    L18:
        r4 = r2;
        goto L19
    L21:
        return (List) r2;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        List r5 = this.$itemIds;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r6 = r5.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        r10.add(BuildersKt.async$default(r14, null, null, new HealthTaskManager$execute$executions$1$invokeSuspend$$inlined$map$lambda$1((String) r6.next(), null, this, r14), 3, null));
        goto L10
    L12:
        ArrayList r11 = r10;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        r3 = r11.iterator();
        r2 = r15;
        goto L14
    }
}
