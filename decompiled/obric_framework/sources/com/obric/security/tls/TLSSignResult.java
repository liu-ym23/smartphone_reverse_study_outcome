package com.obric.security.tls;

/* JADX INFO: loaded from: classes.dex */
public class TLSSignResult {
    private static final String TAG = null;
    private int errorCode;
    private byte[] signature;

    static {
        TAG = TLSSignResult.class.getSimpleName();
    }

    public TLSSignResult(int errorCode, byte[] signature) {
        this.errorCode = -1000;
        this.errorCode = errorCode;
        this.signature = signature;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public byte[] getSignature() {
        return this.signature;
    }
}
