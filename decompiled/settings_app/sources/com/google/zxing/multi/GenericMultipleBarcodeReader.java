package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class GenericMultipleBarcodeReader implements MultipleBarcodeReader {
    private static final int MAX_DEPTH = 4;
    private static final int MIN_DIMENSION_TO_RECUR = 100;
    private final Reader delegate;

    public GenericMultipleBarcodeReader(Reader r1) {
        this.delegate = r1;
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap r2) throws NotFoundException {
        return decodeMultiple(r2, null);
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap r9, Map<DecodeHintType, ?> r10) throws NotFoundException {
        ArrayList r7 = new ArrayList();
        doDecodeMultiple(r9, r10, r7, 0, 0, 0);
        if (r7.isEmpty() == true) goto L7;
        return (Result[]) r7.toArray(new Result[r7.size()]);
    L7:
        throw NotFoundException.getNotFoundInstance();
    }

    private void doDecodeMultiple(BinaryBitmap r23, Map<DecodeHintType, ?> r24, List<Result> r25, int r26, int r27, int r28) {
        if (r28 <= 4) goto L56;
        return;
    L56:
        Result r1 = this.delegate.decode(r23, r24);     // Catch: ReaderException -> L55
        Iterator<Result> r2 = r25.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        if (r2.next().getText().equals(r1.getText()) == false) goto L9;
        boolean r3 = true;
    L14:
        if (r3 == true) goto L17;
        r25.add(translateResultPoints(r1, r26, r27));
    L17:
        ResultPoint[] r4 = r1.getResultPoints();
        if (r4 != null) goto L20;
        return;
    L20:
        if (r4.length == 0) goto L67;
        int r7 = r23.getWidth();
        int r6 = r23.getHeight();
        float r5 = r7;
        int r8 = r4.length;
        float r13 = 0.0f;
        int r14 = 0;
        float r9 = r6;
        float r10 = 0.0f;
    L23:
        if (r14 >= r8) goto L40;
        ResultPoint r16 = r4[r14];
        if (r16 == null) goto L38;
        float r17 = r16.getX();
        float r18 = r16.getY();
        if (r17 >= r5) goto L30;
        r5 = r17;
    L30:
        if (r18 >= r9) goto L33;
        r9 = r18;
    L33:
        if (r17 <= r10) goto L36;
        r10 = r17;
    L36:
        if (r18 <= r13) goto L38;
        r13 = r18;
    L38:
        r14 = r14 + 1;
        goto L23
    L40:
        if (r5 <= 100.0f) goto L42;
        float r19 = r10;
        doDecodeMultiple(r23.crop(0, 0, (int) r5, r6), r24, r25, r26, r27, r28 + 1);
    L44:
        if (r9 <= 100.0f) goto L46;
        int r11 = r7;
        doDecodeMultiple(r23.crop(0, 0, r11, (int) r9), r24, r25, r26, r27, r28 + 1);
    L47:
        float r12 = r19;
        if (r12 >= (r11 - 100)) goto L50;
        int r15 = (int) r12;
        int r110 = r6;
        doDecodeMultiple(r23.crop(r15, 0, r11 - r15, r110), r24, r25, r26 + r15, r27, r28 + 1);
    L52:
        if (r13 >= (r110 - 100)) goto L66;
        int r20 = (int) r13;
        doDecodeMultiple(r23.crop(0, r20, r11, r110 - r20), r24, r25, r26, r27 + r20, r28 + 1);
        return;
    L66:
        return;
    L50:
        r110 = r6;
        goto L52
    L46:
        r11 = r7;
        goto L47
    L42:
        r19 = r10;
        goto L44
    L67:
        return;
    L13:
        r3 = false;
    }

    private static Result translateResultPoints(Result r10, int r11, int r12) {
        ResultPoint[] r0 = r10.getResultPoints();
        if (r0 != null) goto L5;
        return r10;
    L5:
        ResultPoint[] r6 = new ResultPoint[r0.length];
        int r1 = 0;
    L7:
        if (r1 >= r0.length) goto L12;
        ResultPoint r2 = r0[r1];
        if (r2 == null) goto L11;
        r6[r1] = new ResultPoint(r2.getX() + r11, r2.getY() + r12);
    L11:
        r1 = r1 + 1;
        goto L7
    L12:
        Result r13 = new Result(r10.getText(), r10.getRawBytes(), r10.getNumBits(), r6, r10.getBarcodeFormat(), r10.getTimestamp());
        r13.putAllMetadata(r10.getResultMetadata());
        return r13;
    }
}
