package com.google.zxing.pdf417.detector;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class Detector {
    private static final int BARCODE_MIN_HEIGHT = 10;
    private static final int[] INDEXES_START_PATTERN = null;
    private static final int[] INDEXES_STOP_PATTERN = null;
    private static final float MAX_AVG_VARIANCE = 0.42f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.8f;
    private static final int MAX_PATTERN_DRIFT = 5;
    private static final int MAX_PIXEL_DRIFT = 3;
    private static final int ROW_STEP = 5;
    private static final int SKIPPED_ROW_COUNT_MAX = 25;
    private static final int[] START_PATTERN = null;
    private static final int[] STOP_PATTERN = null;

    static {
        INDEXES_START_PATTERN = new int[]{0, 4, 1, 5};
        INDEXES_STOP_PATTERN = new int[]{6, 2, 7, 3};
        START_PATTERN = new int[]{8, 1, 1, 1, 1, 1, 1, 3};
        STOP_PATTERN = new int[]{7, 1, 1, 3, 1, 1, 1, 2, 1};
    }

    private Detector() {
    }

    public static PDF417DetectorResult detect(BinaryBitmap r1, Map<DecodeHintType, ?> r2, boolean r3) throws NotFoundException {
        BitMatrix r4 = r1.getBlackMatrix();
        List<ResultPoint[]> r5 = detect(r3, r4);
        if (r5.isEmpty() == false) goto L6;
        r4 = r4.clone();
        r4.rotate180();
        r5 = detect(r3, r4);
    L6:
        return new PDF417DetectorResult(r4, r5);
    }

    private static List<ResultPoint[]> detect(boolean r8, BitMatrix r9) {
        ArrayList r0 = new ArrayList();
        int r2 = 0;
        int r3 = 0;
    L3:
        int r4 = r3;
    L5:
        if (r2 >= r9.getHeight()) goto L28;
        ResultPoint[] r5 = findVertices(r9, r2, r3);
        if (r5[0] == null) goto L9;
    L21:
        r0.add(r5);
        if (r8 == false) goto L28;
        ResultPoint r6 = r5[2];
        if (r6 == null) goto L26;
        int r7 = (int) r6.getX();
        float r10 = r5[2].getY();
    L27:
        r2 = (int) r10;
        r3 = r7;
        r4 = 1;
        goto L5
    L26:
        r7 = (int) r5[4].getX();
        r10 = r5[4].getY();
        goto L27
    L9:
        if (r5[3] != null) goto L21;
        if (r4 == 0) goto L28;
        Iterator r11 = r0.iterator();
    L13:
        if (r11.hasNext() == false) goto L20;
        ResultPoint[] r12 = (ResultPoint[]) r11.next();
        ResultPoint r13 = r12[1];
        if (r13 == null) goto L17;
        r2 = (int) Math.max(r2, r13.getY());
    L17:
        ResultPoint r14 = r12[3];
        if (r14 == null) goto L13;
        r2 = Math.max(r2, (int) r14.getY());
        goto L13
    L20:
        r2 = r2 + 5;
        r3 = 0;
    L28:
        return r0;
    }

    private static ResultPoint[] findVertices(BitMatrix r9, int r10, int r11) {
        int r6 = r9.getHeight();
        int r7 = r9.getWidth();
        ResultPoint[] r8 = new ResultPoint[8];
        copyToResult(r8, findRowsWithPattern(r9, r6, r7, r10, r11, START_PATTERN), INDEXES_START_PATTERN);
        ResultPoint r1 = r8[4];
        if (r1 == null) goto L5;
        r11 = (int) r1.getX();
        r10 = (int) r8[4].getY();
    L5:
        copyToResult(r8, findRowsWithPattern(r9, r6, r7, r10, r11, STOP_PATTERN), INDEXES_STOP_PATTERN);
        return r8;
    }

    private static void copyToResult(ResultPoint[] r3, ResultPoint[] r4, int[] r5) {
        int r0 = 0;
    L4:
        if (r0 >= r5.length) goto L6;
        r3[r5[r0]] = r4[r0];
        r0 = r0 + 1;
        goto L4
    }

    private static ResultPoint[] findRowsWithPattern(BitMatrix r18, int r19, int r20, int r21, int r22, int[] r23) {
        ResultPoint[] r1 = new ResultPoint[4];
        int[] r10 = new int[r23.length];
        int r11 = r21;
    L4:
        if (r11 >= r19) goto L16;
        int[] r2 = findGuardPattern(r18, r22, r11, r20, false, r23, r10);
        if (r2 != null) goto L7;
        r11 = r11 + 5;
        goto L4
    L7:
        int r17 = r11;
        int[] r12 = r2;
        int r3 = r17;
    L8:
        if (r3 <= 0) goto L13;
        int r14 = r3 - 1;
        int[] r4 = findGuardPattern(r18, r22, r14, r20, false, r23, r10);
        if (r4 == null) goto L12;
        r12 = r4;
        r3 = r14;
        goto L8
    L12:
        int r15 = r14 + 1;
    L14:
        float r5 = r15;
        r1[0] = new ResultPoint(r12[0], r5);
        r1[1] = new ResultPoint(r12[1], r5);
        boolean r6 = true;
        r11 = r15;
    L17:
        int r7 = r11 + 1;
        if (r6 == false) goto L35;
        int[] r16 = {(int) r1[0].getX(), (int) r1[1].getX()};
        int r8 = r7;
        int r9 = 0;
    L20:
        if (r8 >= r19) goto L32;
        int r110 = r9;
        int r111 = r8;
        int[] r13 = findGuardPattern(r18, r16[0], r8, r20, false, r23, r10);
        if (r13 == null) goto L29;
        if (Math.abs(r16[0] - r13[0]) >= 5) goto L29;
        if (Math.abs(r16[1] - r13[1]) >= 5) goto L29;
        r16 = r13;
        r9 = 0;
    L31:
        r8 = r111 + 1;
    L29:
        if (r110 > 25) goto L33;
        r9 = r110 + 1;
    L33:
        r7 = r111 - (r110 + 1);
        float r24 = r7;
        r1[2] = new ResultPoint(r16[0], r24);
        r1[3] = new ResultPoint(r16[1], r24);
        goto L35
    L32:
        r110 = r9;
        r111 = r8;
    L35:
        if ((r7 - r11) >= 10) goto L37;
        Arrays.fill(r1, null);
    L37:
        return r1;
    L13:
        r15 = r3;
        goto L14
    L16:
        r6 = false;
        goto L17
    }

    private static int[] findGuardPattern(BitMatrix r9, int r10, int r11, int r12, boolean r13, int[] r14, int[] r15) {
        Arrays.fill(r15, 0, r15.length, 0);
        int r0 = 0;
    L4:
        if (r9.get(r10, r11) == false) goto L9;
        if (r10 <= 0) goto L9;
        int r2 = r0 + 1;
        if (r0 >= 3) goto L9;
        r10 = r10 - 1;
        r0 = r2;
    L9:
        int r1 = r14.length;
        boolean r3 = r13;
        int r4 = 0;
        int r16 = r10;
    L11:
        if (r10 >= r12) goto L26;
        if (r9.get(r10, r11) == r3) goto L16;
        r15[r4] = r15[r4] + 1;
    L24:
        r10 = r10 + 1;
        goto L11
    L16:
        if (r4 == (r1 - 1)) goto L18;
        r4 = r4 + 1;
    L23:
        r15[r4] = 1;
        r3 = !r3;
        goto L24
    L18:
        if (patternMatchVariance(r15, r14, 0.8f) < 0.42f) goto L20;
        r16 = r16 + (r15[0] + r15[1]);
        int r5 = r4 - 1;
        System.arraycopy(r15, 2, r15, 0, r5);
        r15[r5] = 0;
        r15[r4] = 0;
        r4 = r4 - 1;
        goto L23
    L20:
        return new int[]{r16, r10};
    L26:
        if (r4 == (r1 - 1)) goto L28;
        return null;
    L28:
        if (patternMatchVariance(r15, r14, 0.8f) < 0.42f) goto L30;
        return null;
    L30:
        return new int[]{r16, r10 - 1};
    }

    private static float patternMatchVariance(int[] r9, int[] r10, float r11) {
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
