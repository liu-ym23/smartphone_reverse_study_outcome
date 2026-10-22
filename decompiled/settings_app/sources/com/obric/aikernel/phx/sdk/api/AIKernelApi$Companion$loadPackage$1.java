package com.obric.aikernel.phx.sdk.api;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: AIKernelApi.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$Companion", f = "AIKernelApi.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {358, 388}, m = "loadPackage", n = {"binder", ApmTrafficStats.KEY_BIZ, "ctx", "monitorTask", "binder", "ctx", "monitorTask", "args"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
final class AIKernelApi$Companion$loadPackage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIKernelApi.Companion this$0;

    AIKernelApi$Companion$loadPackage$1(AIKernelApi.Companion r1, Continuation<? super AIKernelApi$Companion$loadPackage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadPackage(null, null, null, this);
    }
}
