package com.obric.aikernel.phx;

import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.api.AIKernelApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: SdkContext.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/obric/aikernel/phx/SdkContext;", "", "()V", "getBinder", "Lcom/obric/aikernel/AIKBinder;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isLegacyArch", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SdkContext {
    public static final SdkContext INSTANCE = null;

    static {
        INSTANCE = new SdkContext();
    }

    private SdkContext() {
    }

    public final Object getBinder(Continuation<? super AIKBinder> r7) {
        return AIKernelApi.getBinder$default(AIKernelManager.INSTANCE.getInstance$sdk_release(), 0, r7, 1, null);
    }

    public final boolean isLegacyArch() {
        return AIKernelManager.INSTANCE.getInstance$sdk_release().getLegacyArch();
    }
}
