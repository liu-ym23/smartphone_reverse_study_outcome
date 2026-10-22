package com.android.settingslib.wifi;

import android.net.wifi.WifiManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: compiled from: WifiUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.android.settingslib.wifi.WifiUtils$Companion$queryWepAllowed$2", f = "WifiUtils.kt", i = {}, l = {579}, m = "invokeSuspend", n = {}, s = {})
final class WifiUtils$Companion$queryWepAllowed$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ WifiManager $this_queryWepAllowed;
    Object L$0;
    int label;

    WifiUtils$Companion$queryWepAllowed$2(WifiManager r1, Continuation<? super WifiUtils$Companion$queryWepAllowed$2> r2) {
        this.$this_queryWepAllowed = r1;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new WifiUtils$Companion$queryWepAllowed$2(this.$this_queryWepAllowed, r2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return ((WifiUtils$Companion$queryWepAllowed$2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        WifiManager r5 = (WifiManager) this.L$0;
        ResultKt.throwOnFailure(r6);
    L13:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        WifiManager r7 = this.$this_queryWepAllowed;
        this.L$0 = r7;
        this.label = 1;
        WifiUtils$Companion$queryWepAllowed$2 r8 = this;
        CancellableContinuationImpl r2 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r8), 1);
        r2.initCancellability();
        final CancellableContinuationImpl r3 = r2;
        r7.queryWepAllowed(ExecutorsKt.asExecutor(Dispatchers.getDefault()), new WifiUtils$Companion$queryWepAllowed$2$1$1(r3));
        r6 = r2.getResult();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(r8);
    L11:
        if (r6 != r0) goto L13;
        return r0;
    }
}
