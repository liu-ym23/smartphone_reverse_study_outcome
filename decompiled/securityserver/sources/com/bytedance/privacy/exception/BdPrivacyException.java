package com.bytedance.privacy.exception;

/* JADX INFO: loaded from: classes.dex */
public class BdPrivacyException extends Exception {
    public final int b;

    public BdPrivacyException(String r1, int r2) {
        super(r1);
        this.b = r2;
    }

    public BdPrivacyException(String r1, int r2, Exception r3) {
        super(r1, r3);
        this.b = r2;
    }
}
