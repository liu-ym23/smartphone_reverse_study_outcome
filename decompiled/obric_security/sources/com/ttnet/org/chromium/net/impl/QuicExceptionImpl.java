package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.QuicException;

/* JADX INFO: loaded from: classes3.dex */
public class QuicExceptionImpl extends QuicException {
    private final NetworkExceptionImpl mNetworkException;
    private final int mQuicDetailedErrorCode;

    public QuicExceptionImpl(String r2, int r3, int r4, int r5) {
        super(r2, null);
        this.mNetworkException = new NetworkExceptionImpl(r2, r3, r4);
        this.mQuicDetailedErrorCode = r5;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder r0 = new StringBuilder(this.mNetworkException.getMessage());
        r0.append(", QuicDetailedErrorCode=").append(this.mQuicDetailedErrorCode);
        return r0.toString();
    }

    @Override // com.ttnet.org.chromium.net.NetworkException
    public int getErrorCode() {
        return this.mNetworkException.getErrorCode();
    }

    @Override // com.ttnet.org.chromium.net.NetworkException
    public int getCronetInternalErrorCode() {
        return this.mNetworkException.getCronetInternalErrorCode();
    }

    @Override // com.ttnet.org.chromium.net.NetworkException
    public boolean immediatelyRetryable() {
        return this.mNetworkException.immediatelyRetryable();
    }

    @Override // com.ttnet.org.chromium.net.QuicException
    public int getQuicDetailedErrorCode() {
        return this.mQuicDetailedErrorCode;
    }
}
