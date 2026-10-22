package com.ss.android.common;

/* JADX INFO: loaded from: classes5.dex */
public class NetworkResponseInfo {
    private String mResult;
    private int mResultCode;

    public NetworkResponseInfo() {
        this.mResult = "";
        this.mResultCode = -1;
    }

    public void setResult(String r1) {
        this.mResult = r1;
    }

    public void setResultCode(int r1) {
        this.mResultCode = r1;
    }

    public String getResult() {
        return this.mResult;
    }

    public int getResultCode() {
        return this.mResultCode;
    }
}
