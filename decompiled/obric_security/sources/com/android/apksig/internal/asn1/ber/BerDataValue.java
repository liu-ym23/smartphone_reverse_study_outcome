package com.android.apksig.internal.asn1.ber;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class BerDataValue {
    private final boolean mConstructed;
    private final ByteBuffer mEncoded;
    private final ByteBuffer mEncodedContents;
    private final int mTagClass;
    private final int mTagNumber;

    BerDataValue(ByteBuffer r1, ByteBuffer r2, int r3, boolean r4, int r5) {
        this.mEncoded = r1;
        this.mEncodedContents = r2;
        this.mTagClass = r3;
        this.mConstructed = r4;
        this.mTagNumber = r5;
    }

    public BerDataValueReader contentsReader() {
        return new ByteBufferBerDataValueReader(getEncodedContents());
    }

    public ByteBuffer getEncoded() {
        return this.mEncoded.slice();
    }

    public ByteBuffer getEncodedContents() {
        return this.mEncodedContents.slice();
    }

    public int getTagClass() {
        return this.mTagClass;
    }

    public int getTagNumber() {
        return this.mTagNumber;
    }
}
