package com.google.zxing.datamatrix.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

/* JADX INFO: loaded from: classes4.dex */
public final class Decoder {
    private final ReedSolomonDecoder rsDecoder;

    public Decoder() {
        this.rsDecoder = new ReedSolomonDecoder(GenericGF.DATA_MATRIX_FIELD_256);
    }

    public DecoderResult decode(boolean[][] r1) throws FormatException, ChecksumException {
        return decode(BitMatrix.parse(r1));
    }

    public DecoderResult decode(BitMatrix r10) throws FormatException, ChecksumException {
        BitMatrixParser r0 = new BitMatrixParser(r10);
        DataBlock[] r11 = DataBlock.getDataBlocks(r0.readCodewords(), r0.getVersion());
        int r1 = r11.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r3 = r3 + r11[r2].getNumDataCodewords();
        r2 = r2 + 1;
        goto L3
    L5:
        byte[] r4 = new byte[r3];
        int r5 = r11.length;
        int r6 = 0;
    L6:
        if (r6 >= r5) goto L12;
        DataBlock r7 = r11[r6];
        byte[] r8 = r7.getCodewords();
        int r9 = r7.getNumDataCodewords();
        correctErrors(r8, r9);
        int r12 = 0;
    L8:
        if (r12 >= r9) goto L10;
        r4[(r12 * r5) + r6] = r8[r12];
        r12 = r12 + 1;
        goto L8
    L10:
        r6 = r6 + 1;
        goto L6
    L12:
        return DecodedBitStreamParser.decode(r4);
    }

    private void correctErrors(byte[] r6, int r7) throws ChecksumException {
        int r0 = r6.length;
        int[] r1 = new int[r0];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L11;
        r1[r3] = r6[r3] & 255;
        r3 = r3 + 1;
        goto L3
    L11:
        this.rsDecoder.decode(r1, r6.length - r7);     // Catch: ReedSolomonException -> L9
    L6:
        if (r2 >= r7) goto L8;
        r6[r2] = (byte) r1[r2];
        r2 = r2 + 1;
        goto L6
    L8:
        return;
    L10:
        throw ChecksumException.getChecksumInstance();
    }
}
