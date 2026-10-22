package com.google.zxing.aztec;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.aztec.decoder.Decoder;
import com.google.zxing.aztec.detector.Detector;
import com.google.zxing.common.DecoderResult;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class AztecReader implements Reader {
    @Override // com.google.zxing.Reader
    public void reset() {
    }

    public AztecReader() {
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap r2) throws NotFoundException, FormatException {
        return decode(r2, null);
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap r10, Map<DecodeHintType, ?> r11) throws NotFoundException, FormatException {
        Detector r9 = new Detector(r10.getBlackMatrix());
        int r12 = 0;
        DecoderResult r0 = null;
        AztecDetectorResult r1 = r9.detect(false);     // Catch: FormatException -> L10 NotFoundException -> L13
        ResultPoint[] r2 = r1.getPoints();     // Catch: FormatException -> L10 NotFoundException -> L13
        ResultPoint[] r3 = r2;
        FormatException r4 = null;
        r0 = new Decoder().decode(r1);     // Catch: FormatException -> L6 NotFoundException -> L8
        e = null;
    L16:
        if (r0 == null) goto L40;
    L26:
        ResultPoint[] r5 = r3;
        if (r11 == null) goto L33;
        ResultPointCallback r13 = (ResultPointCallback) r11.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        if (r13 == null) goto L33;
        int r14 = r5.length;
    L31:
        if (r12 >= r14) goto L33;
        r13.foundPossibleResultPoint(r5[r12]);
        r12 = r12 + 1;
    L33:
        Result r15 = new Result(r0.getText(), r0.getRawBytes(), r0.getNumBits(), r5, BarcodeFormat.AZTEC, System.currentTimeMillis());
        List<byte[]> r16 = r0.getByteSegments();
        if (r16 == null) goto L36;
        r15.putMetadata(ResultMetadataType.BYTE_SEGMENTS, r16);
    L36:
        String r17 = r0.getECLevel();
        if (r17 == null) goto L39;
        r15.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, r17);
    L39:
        return r15;
    L40:
        AztecDetectorResult r18 = r9.detect(true);     // Catch: Throwable -> L20
        r3 = r18.getPoints();     // Catch: Throwable -> L20
        r0 = new Decoder().decode(r18);     // Catch: Throwable -> L20
    L20:
        e = move-exception;
        if (e != null) goto L25;
        if (r4 == null) goto L24;
        throw r4;
    L24:
        throw e;
    L25:
        throw e;
    L6:
        e = e;
    L12:
        r3 = r2;
        r4 = e;
        e = null;
    L8:
        e = e;
    L15:
        r3 = r2;
        r4 = null;
        goto L16
    L10:
        e = e;
        r2 = null;
    L13:
        e = e;
        r2 = null;
        goto L15
    }
}
