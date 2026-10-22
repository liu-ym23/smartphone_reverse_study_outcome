package com.android.apksig.internal.asn1;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class Asn1OpaqueObject {
    private final ByteBuffer mEncoded;

    public Asn1OpaqueObject(ByteBuffer r1) {
        this.mEncoded = r1.slice();
    }

    public ByteBuffer getEncoded() {
        return this.mEncoded.slice();
    }

    public Asn1OpaqueObject(byte[] r1) {
        this.mEncoded = ByteBuffer.wrap(r1);
    }
}
