package com.google.zxing.datamatrix;

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
import com.google.zxing.common.DetectorResult;
import com.google.zxing.datamatrix.decoder.Decoder;
import com.google.zxing.datamatrix.detector.Detector;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class DataMatrixReader implements Reader {
    private static final ResultPoint[] NO_POINTS = null;
    private final Decoder decoder;

    @Override // com.google.zxing.Reader
    public void reset() {
    }

    public DataMatrixReader() {
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
        if (r5 != null) goto L4;
    L6:
        DetectorResult r6 = new Detector(r4.getBlackMatrix()).detect();
        DecoderResult r3 = this.decoder.decode(r6.getBits());
        ResultPoint[] r7 = r6.getPoints();
    L7:
        Result r8 = new Result(r3.getText(), r3.getRawBytes(), r7, BarcodeFormat.DATA_MATRIX);
        List<byte[]> r9 = r3.getByteSegments();
        if (r9 == null) goto L10;
        r8.putMetadata(ResultMetadataType.BYTE_SEGMENTS, r9);
    L10:
        String r10 = r3.getECLevel();
        if (r10 == null) goto L13;
        r8.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, r10);
    L13:
        return r8;
    L4:
        if (r5.containsKey(DecodeHintType.PURE_BARCODE) == false) goto L6;
        BitMatrix r11 = extractPureBits(r4.getBlackMatrix());
        r3 = this.decoder.decode(r11);
        r7 = NO_POINTS;
        goto L7
    }

    private static BitMatrix extractPureBits(BitMatrix r11) throws NotFoundException {
        int[] r0 = r11.getTopLeftOnBit();
        int[] r1 = r11.getBottomRightOnBit();
        if (r0 == null) goto L21;
        if (r1 == null) goto L21;
        int r2 = moduleSize(r0, r11);
        int r4 = r0[1];
        int r5 = r1[1];
        int r3 = r0[0];
        int r6 = ((r1[0] - r3) + 1) / r2;
        int r7 = ((r5 - r4) + 1) / r2;
        if (r6 <= 0) goto L19;
        if (r7 <= 0) goto L19;
        int r8 = r2 / 2;
        int r9 = r4 + r8;
        int r10 = r3 + r8;
        BitMatrix r12 = new BitMatrix(r6, r7);
        int r13 = 0;
    L9:
        if (r13 >= r7) goto L17;
        int r14 = (r13 * r2) + r9;
        int r15 = 0;
    L11:
        if (r15 >= r6) goto L16;
        if (r11.get((r15 * r2) + r10, r14) == false) goto L15;
        r12.set(r15, r13);
    L15:
        r15 = r15 + 1;
        goto L11
    L16:
        r13 = r13 + 1;
        goto L9
    L17:
        return r12;
    L19:
        throw NotFoundException.getNotFoundInstance();
    L21:
        throw NotFoundException.getNotFoundInstance();
    }

    private static int moduleSize(int[] r5, BitMatrix r6) throws NotFoundException {
        int r0 = r6.getWidth();
        int r2 = r5[0];
        int r3 = r5[1];
    L3:
        if (r2 >= r0) goto L7;
        if (r6.get(r2, r3) == false) goto L7;
        r2 = r2 + 1;
    L7:
        if (r2 == r0) goto L14;
        int r4 = r2 - r5[0];
        if (r4 == 0) goto L12;
        return r4;
    L12:
        throw NotFoundException.getNotFoundInstance();
    L14:
        throw NotFoundException.getNotFoundInstance();
    }
}
