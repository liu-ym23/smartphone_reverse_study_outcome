package com.obric.aikernel.phx.sdk;

import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.core.log.ILog;
import com.obric.aikernel.phx.sdk.api.AIKernelApi;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AIKernelManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ2\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0096@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015J\u001a\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\t\u0010\u0018\u001a\u00020\u0001H\u0086\u0002J+\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0017J2\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0096@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\"\u0010#R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Lcom/obric/aikernel/phx/sdk/AIKernelManager;", "Lcom/obric/aikernel/phx/sdk/IAIKernelManager;", "()V", "instance", "Lcom/obric/aikernel/phx/sdk/api/AIKernelApi;", "getInstance$sdk_release", "()Lcom/obric/aikernel/phx/sdk/api/AIKernelApi;", "clearAIKernelData", "", "params", "Lcom/obric/aikernel/sdk/config/RequestParams;", "(Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPackage", "Lkotlin/Result;", "Lcom/obric/aikernel/sdk/data/PackageResource;", "business", "", "getPackage-0E7RQCE", "(Ljava/lang/String;Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "init", "config", "Lcom/obric/aikernel/sdk/AIKernelConfig;", "logger", "Lcom/obric/aikernel/core/log/ILog;", "invoke", "loadPackage", "Lcom/obric/aikernel/phx/sdk/api/IBaseModel;", "name", "useCloud", "", "(Ljava/lang/String;ZLcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerLog", "inst", "updatePackage", "updatePackage-0E7RQCE", "(Lcom/obric/aikernel/sdk/data/PackageResource;Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AIKernelManager implements IAIKernelManager {
    public static final AIKernelManager INSTANCE = null;
    private static final AIKernelApi instance = null;

    private AIKernelManager() {
    }

    static {
        INSTANCE = new AIKernelManager();
        instance = new AIKernelApi();
    }

    public final AIKernelApi getInstance$sdk_release() {
        return instance;
    }

    public final void init(AIKernelConfig r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        AIKernelApi.init$default(instance, r3, null, 2, null);
    }

    public static /* synthetic */ void init$default(AIKernelManager r0, AIKernelConfig r1, ILog r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.init(r1, r2);
    }

    public final void init(AIKernelConfig r1, ILog r2) {
        Intrinsics.checkNotNullParameter(r1, "config");
        instance.init(r1, r2);
    }

    public final void registerLog(ILog r1) {
        Intrinsics.checkNotNullParameter(r1, "inst");
        AIKLog.INSTANCE.registerLog(r1);
    }

    public final IAIKernelManager invoke() {
        return this;
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    /* JADX INFO: renamed from: getPackage-0E7RQCE, reason: not valid java name */
    public Object mo971getPackage0E7RQCE(String r4, RequestParams r5, Continuation<? super Result<PackageResource>> r6) {
        if ((r6 instanceof AIKernelManager$getPackage$1) == false) goto L7;
        AIKernelManager$getPackage$1 r0 = (AIKernelManager$getPackage$1) r6;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r0.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r0.label;
        if (r1 == 0) goto L14;
        if (r1 != 1) goto L13;
        ResultKt.throwOnFailure(r3);
        return ((Result) r3).m1517unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r3);
        AIKernelApi r8 = instance;
        r0.label = 1;
        Object r9 = r8.mo971getPackage0E7RQCE(r4, r5, r0);
        if (r9 != r7) goto L18;
        return r7;
    L18:
        return r9;
    L7:
        r0 = new AIKernelManager$getPackage$1(this, r6);
        goto L8
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    /* JADX INFO: renamed from: updatePackage-0E7RQCE, reason: not valid java name */
    public Object mo972updatePackage0E7RQCE(PackageResource r4, RequestParams r5, Continuation<? super Result<PackageResource>> r6) {
        if ((r6 instanceof AIKernelManager$updatePackage$1) == false) goto L7;
        AIKernelManager$updatePackage$1 r0 = (AIKernelManager$updatePackage$1) r6;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r0.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r0.label;
        if (r1 == 0) goto L14;
        if (r1 != 1) goto L13;
        ResultKt.throwOnFailure(r3);
        return ((Result) r3).m1517unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r3);
        AIKernelApi r8 = instance;
        r0.label = 1;
        Object r9 = r8.mo972updatePackage0E7RQCE(r4, r5, r0);
        if (r9 != r7) goto L18;
        return r7;
    L18:
        return r9;
    L7:
        r0 = new AIKernelManager$updatePackage$1(this, r6);
        goto L8
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    public Object loadPackage(String r1, boolean r2, RequestParams r3, Continuation<? super IBaseModel> r4) {
        return instance.loadPackage(r1, r2, r3, r4);
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    public Object clearAIKernelData(RequestParams r1, Continuation<? super Unit> r2) {
        Object r0 = instance.clearAIKernelData(r1, r2);
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r0;
    L6:
        return Unit.INSTANCE;
    }
}
