package com.android.apksig.internal.asn1.ber;

import java.nio.ByteBuffer;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes.dex */
public class ByteBufferBerDataValueReader implements BerDataValueReader {
    private final ByteBuffer mBuf;

    public ByteBufferBerDataValueReader(ByteBuffer r1) {
        if (r1 == null) goto L7;
        this.mBuf = r1;
        return;
    L7:
        throw new NullPointerException("buf == null");
    }

    private int readHighTagNumber() throws BerDataValueFormatException {
        int r0 = 0;
    L4:
        if (this.mBuf.hasRemaining() == false) goto L13;
        byte r1 = this.mBuf.get();
        if (r0 > 16777215) goto L11;
        r0 = (r0 << 7) | (r1 & ByteCompanionObject.MAX_VALUE);
        if ((r1 & ByteCompanionObject.MIN_VALUE) != 0) goto L4;
        return r0;
    L11:
        throw new BerDataValueFormatException("Tag number too large");
    L13:
        throw new BerDataValueFormatException("Truncated tag number");
    }

    private int readLongFormLength(int r5) throws BerDataValueFormatException {
        int r6 = r5 & 127;
        if (r6 > 4) goto L17;
        int r0 = 0;
        int r1 = 0;
    L5:
        if (r0 >= r6) goto L15;
        if (this.mBuf.hasRemaining() == false) goto L14;
        byte r2 = this.mBuf.get();
        if (r1 > 8388607) goto L12;
        r1 = (r1 << 8) | (r2 & UByte.MAX_VALUE);
        r0 = r0 + 1;
        goto L5
    L12:
        throw new BerDataValueFormatException("Length too large");
    L14:
        throw new BerDataValueFormatException("Truncated length");
    L15:
        return r1;
    L17:
        throw new BerDataValueFormatException("Length too large: " + r6 + " bytes");
    }

    private int readShortFormLength(int r1) {
        return r1 & 127;
    }

    private int readTagNumber(byte r2) throws BerDataValueFormatException {
        int r3 = BerEncoding.getTagNumber(r2);
        if (r3 == 31) goto L5;
        return r3;
    L5:
        return readHighTagNumber();
    }

    private int skipConstructedIndefiniteLengthContents() throws BerDataValueFormatException {
        int r0 = this.mBuf.position();
    L4:
        if (this.mBuf.hasRemaining() == false) goto L13;
        if (this.mBuf.remaining() <= 1) goto L11;
        ByteBuffer r1 = this.mBuf;
        if (r1.getShort(r1.position()) != 0) goto L11;
        int r2 = this.mBuf.position() - r0;
        ByteBuffer r4 = this.mBuf;
        r4.position(r4.position() + 2);
        return r2;
    L11:
        readDataValue();
        goto L4
    L13:
        throw new BerDataValueFormatException("Truncated indefinite-length contents: " + (this.mBuf.position() - r0) + " bytes read");
    }

    private void skipDefiniteLengthContents(int r4) throws BerDataValueFormatException {
        if (this.mBuf.remaining() < r4) goto L7;
        ByteBuffer r3 = this.mBuf;
        r3.position(r3.position() + r4);
        return;
    L7:
        throw new BerDataValueFormatException("Truncated contents. Need: " + r4 + " bytes, available: " + this.mBuf.remaining());
    }

    private int skipPrimitiveIndefiniteLengthContents() throws BerDataValueFormatException {
        int r1 = 0;
        boolean r2 = false;
    L4:
        if (this.mBuf.hasRemaining() == false) goto L17;
        byte r3 = this.mBuf.get();
        int r4 = r1 + 1;
        if (r4 < 0) goto L15;
        if (r3 != 0) goto L12;
        if (r2 == true) goto L10;
        r2 = true;
    L13:
        r1 = r4;
        goto L4
    L10:
        return r1 - 1;
    L12:
        r2 = false;
        goto L13
    L15:
        throw new BerDataValueFormatException("Indefinite-length contents too long");
    L17:
        throw new BerDataValueFormatException("Truncated indefinite-length contents: " + r1 + " bytes read");
    }

    @Override // com.android.apksig.internal.asn1.ber.BerDataValueReader
    public BerDataValue readDataValue() throws BerDataValueFormatException {
        int r0 = this.mBuf.position();
        if (this.mBuf.hasRemaining() == true) goto L6;
        return null;
    L6:
        byte r1 = this.mBuf.get();
        int r7 = readTagNumber(r1);
        boolean r6 = BerEncoding.isConstructed(r1);
        if (this.mBuf.hasRemaining() == false) goto L20;
        byte r2 = this.mBuf.get();
        int r3 = r2 & UByte.MAX_VALUE;
        if ((r2 & ByteCompanionObject.MIN_VALUE) != 0) goto L11;
        int r4 = readShortFormLength(r3);
        int r5 = this.mBuf.position() - r0;
        skipDefiniteLengthContents(r4);
    L17:
        int r8 = this.mBuf.position();
        this.mBuf.position(r0);
        int r9 = this.mBuf.limit();
        this.mBuf.limit(r8);
        ByteBuffer r10 = this.mBuf.slice();
        ByteBuffer r11 = this.mBuf;
        r11.position(r11.limit());
        this.mBuf.limit(r9);
        r10.position(r5);
        r10.limit(r5 + r4);
        ByteBuffer r12 = r10.slice();
        r10.clear();
        return new BerDataValue(r10, r12, BerEncoding.getTagClass(r1), r6, r7);
    L11:
        if (r3 == 128) goto L13;
        r4 = readLongFormLength(r3);
        r5 = this.mBuf.position() - r0;
        skipDefiniteLengthContents(r4);
        goto L17
    L13:
        r5 = this.mBuf.position() - r0;
        if (r6 == false) goto L16;
        r4 = skipConstructedIndefiniteLengthContents();
        goto L17
    L16:
        r4 = skipPrimitiveIndefiniteLengthContents();
        goto L17
    L20:
        throw new BerDataValueFormatException("Missing length");
    }
}
