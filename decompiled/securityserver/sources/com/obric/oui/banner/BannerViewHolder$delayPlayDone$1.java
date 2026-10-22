package com.obric.oui.banner;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "com.obric.oui.banner.BannerViewHolder$delayPlayDone$1", f = "BannerViewHolder.kt", l = {91}, m = "invokeSuspend")
final class BannerViewHolder$delayPlayDone$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int i;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r1, Continuation r2) {
        Intrinsics.f(r2, "completion");
        throw null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r3) {
        int r0 = this.i;
        if (r0 == 0) goto L9;
        if (r0 != 1) goto L8;
        ResultKt.b(r3);
        throw null;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.b(r3);
        this.i = 1;
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return ((BannerViewHolder$delayPlayDone$1) f(r1, (Continuation) r2)).i(Unit.f330a);
    }
}
