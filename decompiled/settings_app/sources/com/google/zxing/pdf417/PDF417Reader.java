package com.google.zxing.pdf417;

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
import com.google.zxing.common.DecoderResult;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.google.zxing.pdf417.decoder.PDF417ScanningDecoder;
import com.google.zxing.pdf417.detector.Detector;
import com.google.zxing.pdf417.detector.PDF417DetectorResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class PDF417Reader implements Reader, MultipleBarcodeReader {
    @Override // com.google.zxing.Reader
    public void reset() {
    }

    public PDF417Reader() {
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap r2) throws NotFoundException, FormatException, ChecksumException {
        return decode(r2, null);
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap r1, Map<DecodeHintType, ?> r2) throws NotFoundException, FormatException, ChecksumException {
        Result[] r3 = decode(r1, r2, false);
        if (r3 == null) goto L10;
        if (r3.length == 0) goto L10;
        Result r0 = r3[0];
        if (r0 == null) goto L10;
        return r0;
    L10:
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap r2) throws NotFoundException {
        return decodeMultiple(r2, null);
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap r1, Map<DecodeHintType, ?> r2) throws NotFoundException {
        return decode(r1, r2, true);
    L6:
        throw NotFoundException.getNotFoundInstance();
    }

    private static Result[] decode(BinaryBitmap r8, Map<DecodeHintType, ?> r9, boolean r10) throws NotFoundException, FormatException, ChecksumException {
        ArrayList r0 = new ArrayList();
        PDF417DetectorResult r11 = Detector.detect(r8, r9, r10);
        Iterator<ResultPoint[]> r12 = r11.getPoints().iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        ResultPoint[] r13 = r12.next();
        DecoderResult r1 = PDF417ScanningDecoder.decode(r11.getBits(), r13[4], r13[5], r13[6], r13[7], getMinCodewordWidth(r13), getMaxCodewordWidth(r13));
        Result r2 = new Result(r1.getText(), r1.getRawBytes(), r13, BarcodeFormat.PDF_417);
        r2.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, r1.getECLevel());
        PDF417ResultMetadata r14 = (PDF417ResultMetadata) r1.getOther();
        if (r14 == null) goto L8;
        r2.putMetadata(ResultMetadataType.PDF417_EXTRA_METADATA, r14);
    L8:
        r0.add(r2);
        goto L4
    L10:
        return (Result[]) r0.toArray(new Result[r0.size()]);
    }

    private static int getMaxWidth(ResultPoint r0, ResultPoint r1) {
        if (r0 == null) goto L7;
        if (r1 != null) goto L6;
        return 0;
    L6:
        return (int) Math.abs(r0.getX() - r1.getX());
    L7:
        return 0;
    }

    private static int getMinWidth(ResultPoint r0, ResultPoint r1) {
        if (r0 == null) goto L7;
        if (r1 != null) goto L6;
        return Integer.MAX_VALUE;
    L6:
        return (int) Math.abs(r0.getX() - r1.getX());
    L7:
        return Integer.MAX_VALUE;
    }

    private static int getMaxCodewordWidth(ResultPoint[] r4) {
        return Math.max(Math.max(getMaxWidth(r4[0], r4[4]), (getMaxWidth(r4[6], r4[2]) * 17) / 18), Math.max(getMaxWidth(r4[1], r4[5]), (getMaxWidth(r4[7], r4[3]) * 17) / 18));
    }

    private static int getMinCodewordWidth(ResultPoint[] r4) {
        return Math.min(Math.min(getMinWidth(r4[0], r4[4]), (getMinWidth(r4[6], r4[2]) * 17) / 18), Math.min(getMinWidth(r4[1], r4[5]), (getMinWidth(r4[7], r4[3]) * 17) / 18));
    }
}
