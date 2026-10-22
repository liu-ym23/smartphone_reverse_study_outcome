package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.detector.FinderPattern;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
import com.google.zxing.qrcode.detector.FinderPatternInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class MultiFinderPatternFinder extends FinderPatternFinder {
    private static final float DIFF_MODSIZE_CUTOFF = 0.5f;
    private static final float DIFF_MODSIZE_CUTOFF_PERCENT = 0.05f;
    private static final FinderPatternInfo[] EMPTY_RESULT_ARRAY = null;
    private static final float MAX_MODULE_COUNT_PER_EDGE = 180.0f;
    private static final float MIN_MODULE_COUNT_PER_EDGE = 9.0f;

    /* JADX INFO: renamed from: com.google.zxing.multi.qrcode.detector.MultiFinderPatternFinder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class ModuleSizeComparator implements Serializable, Comparator<FinderPattern> {
        private ModuleSizeComparator() {
        }

        /* synthetic */ ModuleSizeComparator(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(FinderPattern r1, FinderPattern r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(FinderPattern r3, FinderPattern r4) {
            double r2 = r4.getEstimatedModuleSize() - r3.getEstimatedModuleSize();
            if (r2 >= 0.0d) goto L7;
            return -1;
        L7:
            if (r2 <= 0.0d) goto L10;
            return 1;
        L10:
            return 0;
        }
    }

    static {
        EMPTY_RESULT_ARRAY = new FinderPatternInfo[0];
    }

    MultiFinderPatternFinder(BitMatrix r1) {
        super(r1);
    }

    MultiFinderPatternFinder(BitMatrix r1, ResultPointCallback r2) {
        super(r1, r2);
    }

    private FinderPattern[][] selectMutipleBestPatterns() throws NotFoundException {
        List<FinderPattern> r0 = getPossibleCenters();
        int r1 = r0.size();
        int r2 = 3;
        if (r1 < 3) goto L53;
        char r3 = 2;
        char r4 = 0;
        if (r1 == 3) goto L7;
        Collections.sort(r0, new ModuleSizeComparator(null));
        ArrayList r6 = new ArrayList();
        int r7 = 0;
    L10:
        if (r7 >= (r1 - 2)) goto L47;
        FinderPattern r8 = r0.get(r7);
        if (r8 == null) goto L45;
        int r9 = r7 + 1;
    L15:
        if (r9 >= (r1 - 1)) goto L45;
        FinderPattern r10 = r0.get(r9);
        if (r10 == null) goto L43;
        float r11 = (r8.getEstimatedModuleSize() - r10.getEstimatedModuleSize()) / Math.min(r8.getEstimatedModuleSize(), r10.getEstimatedModuleSize());
        float r12 = Math.abs(r8.getEstimatedModuleSize() - r10.getEstimatedModuleSize());
        float r13 = 0.5f;
        float r14 = DIFF_MODSIZE_CUTOFF_PERCENT;
        if (r12 > 0.5f) goto L21;
    L22:
        int r15 = r9 + 1;
    L23:
        if (r15 >= r1) goto L43;
        FinderPattern r16 = r0.get(r15);
        if (r16 == null) goto L41;
        float r17 = (r10.getEstimatedModuleSize() - r16.getEstimatedModuleSize()) / Math.min(r10.getEstimatedModuleSize(), r16.getEstimatedModuleSize());
        if (Math.abs(r10.getEstimatedModuleSize() - r16.getEstimatedModuleSize()) > r13) goto L29;
    L32:
        FinderPattern[] r5 = new FinderPattern[r2];
        r5[r4] = r8;
        r5[1] = r10;
        char r18 = 2;
        r5[2] = r16;
        ResultPoint.orderBestPatterns(r5);
        FinderPatternInfo r19 = new FinderPatternInfo(r5);
        float r20 = ResultPoint.distance(r19.getTopLeft(), r19.getBottomLeft());
        float r21 = ResultPoint.distance(r19.getTopRight(), r19.getBottomLeft());
        float r22 = ResultPoint.distance(r19.getTopLeft(), r19.getTopRight());
        float r110 = (r20 + r22) / (r8.getEstimatedModuleSize() * 2.0f);
        if (r110 > MAX_MODULE_COUNT_PER_EDGE) goto L42;
        if (r110 < MIN_MODULE_COUNT_PER_EDGE) goto L42;
        if (Math.abs((r20 - r22) / Math.min(r20, r22)) >= 0.1f) goto L42;
        float r23 = (float) Math.sqrt((r20 * r20) + (r22 * r22));
        if (Math.abs((r21 - r23) / Math.min(r21, r23)) >= 0.1f) goto L42;
        r6.add(r5);
    L42:
        r15 = r15 + 1;
        r3 = r18;
        r2 = 3;
        r4 = 0;
        r13 = 0.5f;
        r14 = DIFF_MODSIZE_CUTOFF_PERCENT;
        goto L23
    L29:
        if (r17 < r14) goto L32;
        char r111 = 2;
    L44:
        r9 = r9 + 1;
        r3 = r111;
        r2 = 3;
        r4 = 0;
        goto L15
    L41:
        r18 = r3;
        goto L42
    L21:
        if (r11 >= DIFF_MODSIZE_CUTOFF_PERCENT) goto L45;
    L43:
        r111 = r3;
    L45:
        r7 = r7 + 1;
        r3 = r3;
        r2 = 3;
        r4 = 0;
        goto L10
    L47:
        if (r6.isEmpty() == true) goto L51;
        return (FinderPattern[][]) r6.toArray(new FinderPattern[r6.size()][]);
    L51:
        throw NotFoundException.getNotFoundInstance();
    L7:
        return new FinderPattern[][]{new FinderPattern[]{r0.get(0), r0.get(1), r0.get(2)}};
    L53:
        throw NotFoundException.getNotFoundInstance();
    }

    public FinderPatternInfo[] findMulti(Map<DecodeHintType, ?> r12) throws NotFoundException {
        int r0 = 0;
        if (r12 != null) goto L5;
    L7:
        boolean r13 = false;
    L8:
        BitMatrix r2 = getImage();
        int r3 = r2.getHeight();
        int r4 = r2.getWidth();
        int r5 = (r3 * 3) / 388;
        if (r5 < 3) goto L11;
        if (r13 == true) goto L11;
    L12:
        int[] r14 = new int[5];
        int r7 = r5 - 1;
    L13:
        if (r7 >= r3) goto L39;
        clearCounts(r14);
        int r8 = 0;
        int r9 = 0;
    L15:
        if (r8 >= r4) goto L36;
        if (r2.get(r8, r7) == false) goto L23;
        if ((r9 & 1) != 1) goto L21;
        r9 = r9 + 1;
    L21:
        r14[r9] = r14[r9] + 1;
    L34:
        r8 = r8 + 1;
        goto L15
    L23:
        if ((r9 & 1) == 0) goto L25;
        r14[r9] = r14[r9] + 1;
        goto L34
    L25:
        if (r9 == 4) goto L27;
        r9 = r9 + 1;
        r14[r9] = r14[r9] + 1;
        goto L34
    L27:
        if (foundPatternCross(r14) == true) goto L29;
    L31:
        shiftCounts2(r14);
        r9 = 3;
        goto L34
    L29:
        if (handlePossibleCenter(r14, r7, r8) == false) goto L31;
        clearCounts(r14);
        r9 = 0;
        goto L34
    L36:
        if (foundPatternCross(r14) == false) goto L38;
        handlePossibleCenter(r14, r7, r4);
    L38:
        r7 = r7 + r5;
        goto L13
    L39:
        FinderPattern[][] r11 = selectMutipleBestPatterns();
        ArrayList r15 = new ArrayList();
        int r1 = r11.length;
    L40:
        if (r0 >= r1) goto L43;
        FinderPattern[] r6 = r11[r0];
        ResultPoint.orderBestPatterns(r6);
        r15.add(new FinderPatternInfo(r6));
        r0 = r0 + 1;
        goto L40
    L43:
        if (r15.isEmpty() == false) goto L47;
        return EMPTY_RESULT_ARRAY;
    L47:
        return (FinderPatternInfo[]) r15.toArray(new FinderPatternInfo[r15.size()]);
    L11:
        r5 = 3;
        goto L12
    L5:
        if (r12.containsKey(DecodeHintType.TRY_HARDER) == false) goto L7;
        r13 = true;
        goto L8
    }
}
