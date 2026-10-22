package com.obric.matrix.sdk.push.cross_process;

import com.obric.matrix.push.common.CommonSupport;
import com.obric.matrix.sdk.push.IPushClient;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
public abstract class MessageServiceV2 extends CrossProcessService implements IPushClient {
    public MessageServiceV2() {
    }

    @Override // com.obric.matrix.sdk.push.cross_process.CrossProcessService
    public void registerCrossProcessMethod() {
        CommonSupport.INSTANCE.getCrossProcessService(this).registerCrossProcessMethod(new AnonymousClass1(this));
    }
}
