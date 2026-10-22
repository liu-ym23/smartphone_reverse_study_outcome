package com.bytedance.common.utility;

/* JADX INFO: loaded from: classes3.dex */
public class CommonHttpException extends Exception {
    private int mResponseCode;

    public CommonHttpException(int r1, String r2) {
        super(r2);
        this.mResponseCode = r1;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }
}
