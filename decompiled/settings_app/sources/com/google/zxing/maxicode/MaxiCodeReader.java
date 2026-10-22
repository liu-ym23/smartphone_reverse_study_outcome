package com.google.zxing.maxicode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.maxicode.decoder.Decoder;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class MaxiCodeReader implements Reader {
    private static final int MATRIX_HEIGHT = 33;
    private static final int MATRIX_WIDTH = 30;
    private static final ResultPoint[] NO_POINTS = null;
    private final Decoder decoder;

    @Override // com.google.zxing.Reader
    public void reset() {
    }

    public MaxiCodeReader() {
        this.decoder = new Decoder();
    }

    static {
        NO_POINTS = new ResultPoint[0];
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap r2) throws NotFoundException, ChecksumException, FormatException {
        return decode(r2, null);
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap r4, Map<DecodeHintType, ?> r5) throws NotFoundException, ChecksumException, FormatException {
        if (r5 == null) goto L10;
        if (r5.containsKey(DecodeHintType.PURE_BARCODE) == false) goto L10;
        BitMatrix r6 = extractPureBits(r4.getBlackMatrix());
        DecoderResult r3 = this.decoder.decode(r6, r5);
        Result r7 = new Result(r3.getText(), r3.getRawBytes(), NO_POINTS, BarcodeFormat.MAXICODE);
        String r8 = r3.getECLevel();
        if (r8 == null) goto L8;
        r7.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, r8);
    L8:
        return r7;
    L10:
        throw NotFoundException.getNotFoundInstance();
    }

    private static BitMatrix extractPureBits(BitMatrix r14) throws NotFoundException {
        int[] r0 = r14.getEnclosingRectangle();
        if (r0 == null) goto L15;
        int r2 = r0[0];
        int r3 = r0[1];
        int r5 = r0[2];
        int r1 = r0[3];
        BitMatrix r6 = new BitMatrix(30, 33);
        int r9 = 0;
    L5:
        if (r9 >= 33) goto L13;
        int r10 = (((r9 * r1) + (r1 / 2)) / 33) + r3;
        int r11 = 0;
    L7:
        if (r11 >= 30) goto L12;
        if (r14.get(((((r11 * r5) + (r5 / 2)) + (((r9 & 1) * r5) / 2)) / 30) + r2, r10) == false) goto L11;
        r6.set(r11, r9);
    L11:
        r11 = r11 + 1;
        goto L7
    L12:
        r9 = r9 + 1;
        goto L5
    L13:
        return r6;
    L15:
        throw NotFoundException.getNotFoundInstance();
    }
}
