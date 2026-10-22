package com.android.settingslib.view.accessibility.data.repository;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CaptioningRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.android.settingslib.view.accessibility.data.repository.CaptioningRepositoryImpl$CaptioningChangeProducingListener$emitChange$1", f = "CaptioningRepository.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
final class CaptioningRepositoryImpl$CaptioningChangeProducingListener$emitChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CaptioningRepositoryImpl.CaptioningChange $change;
    int label;
    final /* synthetic */ CaptioningRepositoryImpl.CaptioningChangeProducingListener this$0;

    CaptioningRepositoryImpl$CaptioningChangeProducingListener$emitChange$1(CaptioningRepositoryImpl.CaptioningChangeProducingListener r1, CaptioningRepositoryImpl.CaptioningChange r2, Continuation<? super CaptioningRepositoryImpl$CaptioningChangeProducingListener$emitChange$1> r3) {
        this.this$0 = r1;
        this.$change = r2;
        super(2, r3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CaptioningRepositoryImpl$CaptioningChangeProducingListener$emitChange$1(this.this$0, this.$change, r3);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
        return ((CaptioningRepositoryImpl$CaptioningChangeProducingListener$emitChange$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        this.label = 1;
        if (CaptioningRepositoryImpl.CaptioningChangeProducingListener.access$getScope$p(this.this$0).send(this.$change, this) != r0) goto L12;
        return r0;
    }
}
