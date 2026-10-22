package com.android.settings.wifi.assistant;

import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: WifiUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.android.settings.wifi.assistant.WifiUtils$connectSubWifi$2$1$1", f = "WifiUtils.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
final class WifiUtils$connectSubWifi$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Continuation<String> $continuation;
    final /* synthetic */ Ref.BooleanRef $hasResumed;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    WifiUtils$connectSubWifi$2$1$1(Ref.BooleanRef r1, Continuation<? super String> r2, Continuation<? super WifiUtils$connectSubWifi$2$1$1> r3) {
        this.$hasResumed = r1;
        this.$continuation = r2;
        super(2, r3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new WifiUtils$connectSubWifi$2$1$1(this.$hasResumed, this.$continuation, r3);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
        return ((WifiUtils$connectSubWifi$2$1$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        if (this.$hasResumed.element == true) goto L15;
        this.$hasResumed.element = true;
        OLog.i("WifiUtils", "requestNetwork timeout");
        Continuation<String> r5 = this.$continuation;
        Result.Companion r7 = Result.Companion;
        r5.resumeWith(Result.m1508constructorimpl(null));
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        if (DelayKt.delay(10000, this) != r0) goto L12;
        return r0;
    }
}
