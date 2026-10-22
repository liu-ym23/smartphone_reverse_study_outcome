package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

/* JADX INFO: loaded from: classes4.dex */
final class BinaryShiftToken extends Token {
    private final short binaryShiftByteCount;
    private final short binaryShiftStart;

    BinaryShiftToken(Token r1, int r2, int r3) {
        super(r1);
        this.binaryShiftStart = (short) r2;
        this.binaryShiftByteCount = (short) r3;
    }

    @Override // com.google.zxing.aztec.encoder.Token
    public void appendTo(BitArray r6, byte[] r7) {
        int r0 = 0;
    L3:
        short r1 = this.binaryShiftByteCount;
        if (r0 >= r1) goto L16;
        if (r0 == 0) goto L9;
        if (r0 != 31) goto L15;
        if (r1 <= 62) goto L9;
    L15:
        r6.appendBits(r7[this.binaryShiftStart + r0], 8);
        r0 = r0 + 1;
    L9:
        r6.appendBits(31, 5);
        short r4 = this.binaryShiftByteCount;
        if (r4 <= 62) goto L12;
        r6.appendBits(r4 - 31, 16);
        goto L15
    L12:
        if (r0 != 0) goto L14;
        r6.appendBits(Math.min(r4, 31), 5);
        goto L15
    L14:
        r6.appendBits(r4 - 31, 5);
        goto L15
    }

    public String toString() {
        return "<" + this.binaryShiftStart + "::" + ((this.binaryShiftStart + this.binaryShiftByteCount) - 1) + '>';
    }
}
