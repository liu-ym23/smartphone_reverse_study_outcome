package com.obric.security.secretdata;

/* JADX INFO: loaded from: classes.dex */
public class AddResult {
    private String mAlias;
    private int mResultCode;

    public AddResult(int code, String alias) {
        this.mResultCode = code;
        this.mAlias = alias;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public String getAlias() {
        return this.mAlias;
    }
}
