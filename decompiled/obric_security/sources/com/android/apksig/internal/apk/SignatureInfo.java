package com.android.apksig.internal.apk;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class SignatureInfo {
    public final long apkSigningBlockOffset;
    public final long centralDirOffset;
    public final ByteBuffer eocd;
    public final long eocdOffset;
    public final ByteBuffer signatureBlock;

    public SignatureInfo(ByteBuffer r1, long r2, long r4, long r6, ByteBuffer r8) {
        this.signatureBlock = r1;
        this.apkSigningBlockOffset = r2;
        this.centralDirOffset = r4;
        this.eocdOffset = r6;
        this.eocd = r8;
    }
}
