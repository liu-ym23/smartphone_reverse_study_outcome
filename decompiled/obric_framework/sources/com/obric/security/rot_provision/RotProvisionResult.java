package com.obric.security.rot_provision;

/* JADX INFO: loaded from: classes.dex */
public class RotProvisionResult {
    private static final String TAG = null;
    private byte[] mOutData;
    private int mResultCode;

    static {
        TAG = RotProvisionResult.class.getSimpleName();
    }

    public RotProvisionResult(int code, byte[] outData) {
        this.mResultCode = -2000;
        this.mResultCode = code;
        this.mOutData = outData;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public byte[] getOutData() {
        return this.mOutData;
    }
}
