package com.obric.capabilitykit;

import com.obric.capabilitykit.common.IErrorCodeCallback;
import com.obric.capabilitykit.logger.Logger;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/capabilitykit/ErrorCodeCallback;", "Lcom/obric/capabilitykit/common/IErrorCodeCallback$Stub;", "()V", "onResult", "", "resultCode", "", "resultMessage", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class ErrorCodeCallback extends IErrorCodeCallback.Stub {
    public ErrorCodeCallback() {
    }

    @Override // com.obric.capabilitykit.common.IErrorCodeCallback
    public void onResult(int r3, String r4) {
        Logger.INSTANCE.i(AtomicCapabilitySdk.TAG, "AtomicCapabilitySdk onResult " + r3 + " resultMessage " + r4);
    }
}
