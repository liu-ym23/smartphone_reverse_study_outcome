package com.obric.security.keymanager;

/* JADX INFO: loaded from: classes.dex */
public class UDIDManagerResult {
    private static final String TAG = null;
    private int mResultCode;
    private String mUDID;

    static {
        TAG = KeyManagerResult.class.getSimpleName();
    }

    public UDIDManagerResult(int code, String udid) {
        this.mResultCode = -1000;
        this.mResultCode = code;
        this.mUDID = udid;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public String getUDIDValue() {
        return this.mUDID;
    }
}
