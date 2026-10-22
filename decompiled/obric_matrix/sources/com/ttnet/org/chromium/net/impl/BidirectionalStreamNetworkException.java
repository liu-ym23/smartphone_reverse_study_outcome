package com.ttnet.org.chromium.net.impl;

import androidx.annotation.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
public class BidirectionalStreamNetworkException extends NetworkExceptionImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    static {
    }

    public BidirectionalStreamNetworkException(String r1, int r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.NetworkExceptionImpl, com.ttnet.org.chromium.net.NetworkException
    public boolean immediatelyRetryable() {
        int r0 = this.mCronetInternalErrorCode;
        if (r0 != (-358)) goto L5;
        return true;
    L5:
        if (r0 != (-352)) goto L7;
        return true;
    L7:
        return super.immediatelyRetryable();
    }
}
