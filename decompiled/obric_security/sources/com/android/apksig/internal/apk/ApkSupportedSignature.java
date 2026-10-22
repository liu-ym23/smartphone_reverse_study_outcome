package com.android.apksig.internal.apk;

/* JADX INFO: loaded from: classes.dex */
public class ApkSupportedSignature {
    public final SignatureAlgorithm algorithm;
    public final byte[] signature;

    public ApkSupportedSignature(SignatureAlgorithm r1, byte[] r2) {
        this.algorithm = r1;
        this.signature = r2;
    }
}
