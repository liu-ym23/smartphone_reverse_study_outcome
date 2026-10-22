package com.obric.safecheck.riskcontrol.ui;

import com.obric.safecheck.riskcontrol.domain.usecase.LoadRiskAppsUseCase;
import java.util.ArrayList;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RiskAppListViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Lcom/obric/safecheck/riskcontrol/ui/RiskAppListItemUiState;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.obric.safecheck.riskcontrol.ui.RiskAppListViewModel$loadControlledApps$1$items$1", f = "RiskAppListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RiskAppListViewModel$loadControlledApps$1$items$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends RiskAppListItemUiState>>, Object> {
    int label;
    final /* synthetic */ RiskAppListViewModel.AnonymousClass1 this$0;

    RiskAppListViewModel$loadControlledApps$1$items$1(RiskAppListViewModel.AnonymousClass1 r1, Continuation r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "completion");
        return new RiskAppListViewModel$loadControlledApps$1$items$1(this.this$0, r2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r1, Continuation<? super List<? extends RiskAppListItemUiState>> r2) {
        return ((RiskAppListViewModel$loadControlledApps$1$items$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r9);
        List<LoadRiskAppsUseCase.ListItem> r8 = RiskAppListViewModel.access$getLoadUseCase$p(this.this$0.this$0).loadControlledApps();
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r11 = r8.iterator();
    L6:
        if (r11.hasNext() == false) goto L9;
        LoadRiskAppsUseCase.ListItem r0 = (LoadRiskAppsUseCase.ListItem) r11.next();
        r10.add(new RiskAppListItemUiState(r0.getPkg(), r0.getUserId(), r0.getContent(), r0.getAppInfo(), r0.isInstallationPackage()));
        goto L6
    L9:
        return r10;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
