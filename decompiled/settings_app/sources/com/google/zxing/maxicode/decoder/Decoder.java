package com.google.zxing.maxicode.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class Decoder {
    private static final int ALL = 0;
    private static final int EVEN = 1;
    private static final int ODD = 2;
    private final ReedSolomonDecoder rsDecoder;

    public Decoder() {
        this.rsDecoder = new ReedSolomonDecoder(GenericGF.MAXICODE_FIELD_64);
    }

    public DecoderResult decode(BitMatrix r2) throws ChecksumException, FormatException {
        return decode(r2, null);
    }

    public DecoderResult decode(BitMatrix r8, Map<DecodeHintType, ?> r9) throws FormatException, ChecksumException {
        byte[] r10 = new BitMatrixParser(r8).readCodewords();
        correctErrors(r10, 0, 10, 10, 0);
        int r6 = r10[0] & 15;
        if (r6 != 2) goto L5;
    L13:
        correctErrors(r10, 20, 84, 40, 1);
        correctErrors(r10, 20, 84, 40, 2);
        byte[] r7 = new byte[94];
    L14:
        System.arraycopy(r10, 0, r7, 0, 10);
        System.arraycopy(r10, 20, r7, 10, r7.length - 10);
        return DecodedBitStreamParser.decode(r7, r6);
    L5:
        if (r6 == 3) goto L13;
        if (r6 == 4) goto L13;
        if (r6 != 5) goto L12;
        correctErrors(r10, 20, 68, 56, 1);
        correctErrors(r10, 20, 68, 56, 2);
        r7 = new byte[78];
        goto L14
    L12:
        throw FormatException.getFormatInstance();
    }

    private void correctErrors(byte[] r8, int r9, int r10, int r11, int r12) throws ChecksumException {
        int r0 = r10 + r11;
        if (r12 != 0) goto L5;
        int r1 = 1;
    L6:
        int[] r2 = new int[r0 / r1];
        int r3 = 0;
        int r4 = 0;
    L7:
        if (r4 >= r0) goto L23;
        if (r12 != 0) goto L10;
    L11:
        r2[r4 / r1] = r8[r4 + r9] & 255;
    L12:
        r4 = r4 + 1;
        goto L7
    L10:
        if ((r4 % 2) != (r12 - 1)) goto L12;
    L23:
        this.rsDecoder.decode(r2, r11 / r1);     // Catch: ReedSolomonException -> L21
    L14:
        if (r3 >= r10) goto L20;
        if (r12 != 0) goto L17;
    L18:
        r8[r3 + r9] = (byte) r2[r3 / r1];
    L19:
        r3 = r3 + 1;
        goto L14
    L17:
        if ((r3 % 2) != (r12 - 1)) goto L19;
    L20:
        return;
    L22:
        throw ChecksumException.getChecksumInstance();
    L5:
        r1 = 2;
        goto L6
    }
}
