package com.google.zxing.oned;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class OneDReader implements Reader {
    public abstract Result decodeRow(int r1, BitArray r2, Map<DecodeHintType, ?> r3) throws NotFoundException, ChecksumException, FormatException;

    @Override // com.google.zxing.Reader
    public void reset() {
    }

    public OneDReader() {
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap r2) throws NotFoundException, FormatException {
        return decode(r2, null);
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap r5, Map<DecodeHintType, ?> r6) throws NotFoundException, FormatException {
        return doDecode(r5, r6);
    L4:
        e = move-exception;
        int r1 = 0;
        if (r6 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == true) goto L13;
    L26:
        throw e;
    L13:
        if (r5.isRotateSupported() == false) goto L26;
        BinaryBitmap r7 = r5.rotateCounterClockwise();
        Result r4 = doDecode(r7, r6);
        Map<ResultMetadataType, Object> r8 = r4.getResultMetadata();
        int r0 = 270;
        if (r8 != null) goto L17;
    L19:
        r4.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(r0));
        ResultPoint[] r9 = r4.getResultPoints();
        if (r9 == null) goto L25;
        int r10 = r7.getHeight();
    L23:
        if (r1 >= r9.length) goto L25;
        r9[r1] = new ResultPoint((r10 - r9[r1].getY()) - 1.0f, r9[r1].getX());
        r1 = r1 + 1;
    L25:
        return r4;
    L17:
        if (r8.containsKey(ResultMetadataType.ORIENTATION) == false) goto L19;
        r0 = (((Integer) r8.get(ResultMetadataType.ORIENTATION)).intValue() + 270) % 360;
        goto L19
    L8:
        if (r6.containsKey(DecodeHintType.TRY_HARDER) == false) goto L10;
        r2 = true;
        goto L11
    }

    private Result doDecode(BinaryBitmap r22, Map<DecodeHintType, ?> r23) throws NotFoundException {
        Map<DecodeHintType, ?> r0 = r23;
        int r1 = r22.getWidth();
        int r2 = r22.getHeight();
        BitArray r3 = new BitArray(r1);
        int r4 = 0;
        int r5 = 1;
        if (r0 != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r6 == false) goto L10;
        int r7 = 8;
    L11:
        int r8 = Math.max(1, r2 >> r7);
        if (r6 == false) goto L14;
        int r9 = r2;
    L15:
        int r10 = r2 / 2;
        int r11 = 0;
    L16:
        if (r11 >= r9) goto L61;
        int r12 = r11 + 1;
        int r13 = r12 / 2;
        if ((r11 & 1) != 0) goto L20;
        int r14 = r5;
    L21:
        if (r14 != 0) goto L24;
        r13 = -r13;
    L24:
        int r15 = (r13 * r8) + r10;
        if (r15 < 0) goto L61;
        if (r15 >= r2) goto L61;
        r3 = r22.getBlackRow(r15, r3);     // Catch: NotFoundException -> L65
        int r16 = r4;
    L31:
        if (r16 >= 2) goto L59;
        if (r16 != r5) goto L72;
        r3.reverse();
        if (r0 == null) goto L72;
        if (r0.containsKey(DecodeHintType.NEED_RESULT_POINT_CALLBACK) == false) goto L72;
        EnumMap r17 = new EnumMap(DecodeHintType.class);
        r17.putAll(r0);
        r17.remove(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        r0 = r17;
    L72:
        Result r18 = decodeRow(r15, r3, r0);     // Catch: ReaderException -> L57
        if (r16 != r5) goto L56;
        r18.putMetadata(ResultMetadataType.ORIENTATION, 180);     // Catch: ReaderException -> L53
        ResultPoint[] r19 = r18.getResultPoints();     // Catch: ReaderException -> L53
        if (r19 == null) goto L56;
        Map<DecodeHintType, ?> r110 = r0;
        float r20 = r1;
        int r21 = r1;
        r19[0] = new ResultPoint((r20 - r19[r4].getX()) - 1.0f, r19[r4].getY());     // Catch: ReaderException -> L63
        int r111 = 1;
        r19[1] = new ResultPoint((r20 - r19[1].getX()) - 1.0f, r19[1].getY());     // Catch: ReaderException -> L62
    L58:
        r16 = r16 + 1;
        r5 = r111;
        r0 = r110;
        r1 = r21;
        r4 = 0;
    L55:
        r111 = 1;
    L54:
        r21 = r1;
    L53:
        r110 = r0;
    L56:
        return r18;
    L57:
        r110 = r0;
        r21 = r1;
        r111 = r5;
    L59:
        r11 = r12;
        r5 = r5;
        r1 = r1;
        r4 = 0;
        goto L16
    L20:
        r14 = r4;
    L61:
        throw NotFoundException.getNotFoundInstance();
    L14:
        r9 = 15;
        goto L15
    L10:
        r7 = 5;
        goto L11
    L5:
        if (r0.containsKey(DecodeHintType.TRY_HARDER) == false) goto L7;
        r6 = true;
        goto L8
    }

    protected static void recordPattern(BitArray r6, int r7, int[] r8) throws NotFoundException {
        int r0 = r8.length;
        int r1 = 0;
        Arrays.fill(r8, 0, r0, 0);
        int r2 = r6.getSize();
        if (r7 >= r2) goto L22;
        boolean r3 = !r6.get(r7);
    L5:
        if (r7 >= r2) goto L13;
        if (r6.get(r7) == r3) goto L9;
        r8[r1] = r8[r1] + 1;
    L12:
        r7 = r7 + 1;
        goto L5
    L9:
        r1 = r1 + 1;
        if (r1 == r0) goto L13;
        r8[r1] = 1;
        r3 = !r3;
    L13:
        if (r1 != r0) goto L15;
        return;
    L15:
        if (r1 != (r0 - 1)) goto L19;
        if (r7 != r2) goto L19;
        return;
    L19:
        throw NotFoundException.getNotFoundInstance();
    L22:
        throw NotFoundException.getNotFoundInstance();
    }

    protected static void recordPatternInReverse(BitArray r3, int r4, int[] r5) throws NotFoundException {
        int r0 = r5.length;
        boolean r1 = r3.get(r4);
    L3:
        if (r4 <= 0) goto L8;
        if (r0 < 0) goto L8;
        r4 = r4 - 1;
        if (r3.get(r4) == r1) goto L3;
        r0 = r0 - 1;
        r1 = !r1;
    L8:
        if (r0 >= 0) goto L12;
        recordPattern(r3, r4 + 1, r5);
        return;
    L12:
        throw NotFoundException.getNotFoundInstance();
    }

    protected static float patternMatchVariance(int[] r9, int[] r10, float r11) {
        int r0 = r9.length;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r2 >= r0) goto L6;
        r3 = r3 + r9[r2];
        r4 = r4 + r10[r2];
        r2 = r2 + 1;
        goto L3
    L6:
        if (r3 >= r4) goto L8;
        return Float.POSITIVE_INFINITY;
    L8:
        float r5 = r3;
        float r6 = r5 / r4;
        float r12 = r11 * r6;
        float r7 = 0.0f;
    L9:
        if (r1 >= r0) goto L19;
        int r8 = r9[r1];
        float r13 = r10[r1] * r6;
        float r14 = r8;
        if (r14 <= r13) goto L13;
        float r15 = r14 - r13;
    L15:
        if (r15 > r12) goto L16;
        r7 = r7 + r15;
        r1 = r1 + 1;
        goto L9
    L16:
        return Float.POSITIVE_INFINITY;
    L13:
        r15 = r13 - r14;
        goto L15
    L19:
        return r7 / r5;
    }
}
