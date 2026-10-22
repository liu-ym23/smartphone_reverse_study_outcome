package com.google.zxing.qrcode.decoder;

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
    private final ReedSolomonDecoder rsDecoder;

    public Decoder() {
        this.rsDecoder = new ReedSolomonDecoder(GenericGF.QR_CODE_FIELD_256);
    }

    public DecoderResult decode(boolean[][] r2) throws ChecksumException, FormatException {
        return decode(r2, null);
    }

    public DecoderResult decode(boolean[][] r1, Map<DecodeHintType, ?> r2) throws ChecksumException, FormatException {
        return decode(BitMatrix.parse(r1), r2);
    }

    public DecoderResult decode(BitMatrix r2) throws ChecksumException, FormatException {
        return decode(r2, null);
    }

    public DecoderResult decode(BitMatrix r5, Map<DecodeHintType, ?> r6) throws FormatException, ChecksumException {
        BitMatrixParser r0 = new BitMatrixParser(r5);
        FormatException r7 = null;
        return decode(r0, r6);
    L5:
        ChecksumException e = e;
    L14:
        r0.remask();     // Catch: Throwable -> L11
        r0.setMirror(true);     // Catch: Throwable -> L11
        r0.readVersion();     // Catch: Throwable -> L11
        r0.readFormatInformation();     // Catch: Throwable -> L11
        r0.mirror();     // Catch: Throwable -> L11
        DecoderResult r4 = decode(r0, r6);     // Catch: Throwable -> L11
        r4.setOther(new QRCodeDecoderMetaData(true));     // Catch: Throwable -> L11
        return r4;
    L11:
        if (r7 == null) goto L13;
        throw r7;
    L13:
        throw e;
    L7:
        e = move-exception;
        e = null;
        r7 = e;
        goto L14
    }

    private DecoderResult decode(BitMatrixParser r13, Map<DecodeHintType, ?> r14) throws FormatException, ChecksumException {
        Version r0 = r13.readVersion();
        ErrorCorrectionLevel r1 = r13.readFormatInformation().getErrorCorrectionLevel();
        DataBlock[] r15 = DataBlock.getDataBlocks(r13.readCodewords(), r0, r1);
        int r2 = r15.length;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r2) goto L5;
        r5 = r5 + r15[r4].getNumDataCodewords();
        r4 = r4 + 1;
        goto L3
    L5:
        byte[] r3 = new byte[r5];
        int r6 = r15.length;
        int r7 = 0;
        int r8 = 0;
    L6:
        if (r7 >= r6) goto L12;
        DataBlock r9 = r15[r7];
        byte[] r10 = r9.getCodewords();
        int r11 = r9.getNumDataCodewords();
        correctErrors(r10, r11);
        int r12 = 0;
    L8:
        if (r12 >= r11) goto L10;
        r3[r8] = r10[r12];
        r12 = r12 + 1;
        r8 = r8 + 1;
        goto L8
    L10:
        r7 = r7 + 1;
        goto L6
    L12:
        return DecodedBitStreamParser.decode(r3, r0, r1, r14);
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
