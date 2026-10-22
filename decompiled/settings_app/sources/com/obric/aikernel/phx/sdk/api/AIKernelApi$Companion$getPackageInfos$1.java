package com.obric.aikernel.phx.sdk.api;

import android.icu.lang.UCharacter;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: AIKernelApi.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$Companion", f = "AIKernelApi.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {UCharacter.UnicodeBlock.NUSHU_ID, 391}, m = "getPackageInfos-BWLJW6A", n = {"binder", "names", "ctx", "monitorTask", "binder", "names", "ctx", "monitorTask", "args"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"})
final class AIKernelApi$Companion$getPackageInfos$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIKernelApi.Companion this$0;

    AIKernelApi$Companion$getPackageInfos$1(AIKernelApi.Companion r1, Continuation<? super AIKernelApi$Companion$getPackageInfos$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        Object r1 = this.this$0.m983getPackageInfosBWLJW6A(null, null, null, this);
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r1;
    L6:
        return Result.m1507boximpl(r1);
    }
}
