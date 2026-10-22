package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class FinderPatternFinder {
    private static final int CENTER_QUORUM = 2;
    protected static final int MAX_MODULES = 97;
    protected static final int MIN_SKIP = 3;
    private final int[] crossCheckStateCount;
    private boolean hasSkipped;
    private final BitMatrix image;
    private final List<FinderPattern> possibleCenters;
    private final ResultPointCallback resultPointCallback;

    /* JADX INFO: renamed from: com.google.zxing.qrcode.detector.FinderPatternFinder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class CenterComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        /* synthetic */ CenterComparator(float r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(FinderPattern r1, FinderPattern r2) {
            return compare2(r1, r2);
        }

        private CenterComparator(float r1) {
            this.average = r1;
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(FinderPattern r3, FinderPattern r4) {
            int r0 = Integer.compare(r4.getCount(), r3.getCount());
            if (r0 == 0) goto L5;
            return r0;
        L5:
            return Float.compare(Math.abs(r3.getEstimatedModuleSize() - this.average), Math.abs(r4.getEstimatedModuleSize() - this.average));
        }
    }

    private static final class FurthestFromAverageComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        /* synthetic */ FurthestFromAverageComparator(float r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(FinderPattern r1, FinderPattern r2) {
            return compare2(r1, r2);
        }

        private FurthestFromAverageComparator(float r1) {
            this.average = r1;
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(FinderPattern r2, FinderPattern r3) {
            return Float.compare(Math.abs(r3.getEstimatedModuleSize() - this.average), Math.abs(r2.getEstimatedModuleSize() - this.average));
        }
    }

    public FinderPatternFinder(BitMatrix r2) {
        this(r2, null);
    }

    public FinderPatternFinder(BitMatrix r1, ResultPointCallback r2) {
        this.image = r1;
        this.possibleCenters = new ArrayList();
        this.crossCheckStateCount = new int[5];
        this.resultPointCallback = r2;
    }

    protected final BitMatrix getImage() {
        return this.image;
    }

    protected final List<FinderPattern> getPossibleCenters() {
        return this.possibleCenters;
    }

    final FinderPatternInfo find(Map<DecodeHintType, ?> r12) throws NotFoundException {
        if (r12 != null) goto L5;
    L7:
        boolean r13 = false;
    L8:
        int r2 = this.image.getHeight();
        int r3 = this.image.getWidth();
        int r4 = (r2 * 3) / 388;
        if (r4 < 3) goto L11;
        if (r13 == true) goto L11;
    L12:
        int[] r14 = new int[5];
        int r6 = r4 - 1;
        boolean r7 = false;
    L13:
        if (r6 >= r2) goto L52;
        if (r7 == true) goto L52;
        clearCounts(r14);
        int r8 = 0;
        int r9 = 0;
    L16:
        if (r8 >= r3) goto L45;
        if (this.image.get(r8, r6) == false) goto L24;
        if ((r9 & 1) != 1) goto L22;
        r9 = r9 + 1;
    L22:
        r14[r9] = r14[r9] + 1;
    L43:
        r8 = r8 + 1;
        goto L16
    L24:
        if ((r9 & 1) == 0) goto L26;
        r14[r9] = r14[r9] + 1;
        goto L43
    L26:
        if (r9 == 4) goto L28;
        r9 = r9 + 1;
        r14[r9] = r14[r9] + 1;
        goto L43
    L28:
        if (foundPatternCross(r14) == true) goto L30;
        shiftCounts2(r14);
    L40:
        r9 = 3;
        goto L43
    L30:
        if (handlePossibleCenter(r14, r6, r8) == true) goto L32;
        shiftCounts2(r14);
        goto L40
    L32:
        if (this.hasSkipped == false) goto L34;
        r7 = haveMultiplyConfirmedCenters();
    L37:
        clearCounts(r14);
        r4 = 2;
        r9 = 0;
        goto L43
    L34:
        int r5 = findRowSkip();
        int r10 = r14[2];
        if (r5 <= r10) goto L37;
        r6 = r6 + ((r5 - r10) - 2);
        r8 = r3 - 1;
        goto L37
    L45:
        if (foundPatternCross(r14) == false) goto L51;
        if (handlePossibleCenter(r14, r6, r3) == false) goto L51;
        r4 = r14[0];
        if (this.hasSkipped == false) goto L51;
        r7 = haveMultiplyConfirmedCenters();
    L51:
        r6 = r6 + r4;
    L52:
        FinderPattern[] r11 = selectBestPatterns();
        ResultPoint.orderBestPatterns(r11);
        return new FinderPatternInfo(r11);
    L11:
        r4 = 3;
        goto L12
    L5:
        if (r12.containsKey(DecodeHintType.TRY_HARDER) == false) goto L7;
        r13 = true;
        goto L8
    }

    private static float centerFromEnd(int[] r1, int r2) {
        return ((r2 - r1[4]) - r1[3]) - (r1[2] / 2.0f);
    }

    protected static boolean foundPatternCross(int[] r7) {
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= 5) goto L10;
        int r3 = r7[r1];
        if (r3 == 0) goto L7;
        r2 = r2 + r3;
        r1 = r1 + 1;
        goto L4
    L7:
        return false;
    L10:
        if (r2 >= 7) goto L12;
        return false;
    L12:
        float r4 = r2 / 7.0f;
        float r5 = r4 / 2.0f;
        if (Math.abs(r4 - r7[0]) < r5) goto L15;
    L23:
        return false;
    L15:
        if (Math.abs(r4 - r7[1]) >= r5) goto L23;
        if (Math.abs((r4 * 3.0f) - r7[2]) >= (3.0f * r5)) goto L23;
        if (Math.abs(r4 - r7[3]) >= r5) goto L23;
        if (Math.abs(r4 - r7[4]) >= r5) goto L23;
        return true;
    }

    protected static boolean foundPatternDiagonal(int[] r7) {
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= 5) goto L10;
        int r3 = r7[r1];
        if (r3 == 0) goto L7;
        r2 = r2 + r3;
        r1 = r1 + 1;
        goto L4
    L7:
        return false;
    L10:
        if (r2 >= 7) goto L12;
        return false;
    L12:
        float r4 = r2 / 7.0f;
        float r5 = r4 / 1.333f;
        if (Math.abs(r4 - r7[0]) < r5) goto L15;
    L23:
        return false;
    L15:
        if (Math.abs(r4 - r7[1]) >= r5) goto L23;
        if (Math.abs((r4 * 3.0f) - r7[2]) >= (3.0f * r5)) goto L23;
        if (Math.abs(r4 - r7[3]) >= r5) goto L23;
        if (Math.abs(r4 - r7[4]) >= r5) goto L23;
        return true;
    }

    private int[] getCrossCheckStateCount() {
        clearCounts(this.crossCheckStateCount);
        return this.crossCheckStateCount;
    }

    protected final void clearCounts(int[] r3) {
        int r0 = 0;
    L4:
        if (r0 >= r3.length) goto L6;
        r3[r0] = 0;
        r0 = r0 + 1;
        goto L4
    }

    protected final void shiftCounts2(int[] r6) {
        r6[0] = r6[2];
        r6[1] = r6[3];
        r6[2] = r6[4];
        r6[3] = 1;
        r6[4] = 0;
    }

    private boolean crossCheckDiagonal(int r11, int r12) {
        int[] r0 = getCrossCheckStateCount();
        int r2 = 0;
    L4:
        if (r11 < r2) goto L10;
        if (r12 < r2) goto L10;
        if (this.image.get(r12 - r2, r11 - r2) == false) goto L10;
        r0[2] = r0[2] + 1;
        r2 = r2 + 1;
    L10:
        if (r0[2] != 0) goto L12;
        return false;
    L12:
        if (r11 < r2) goto L18;
        if (r12 < r2) goto L18;
        if (this.image.get(r12 - r2, r11 - r2) == true) goto L18;
        r0[1] = r0[1] + 1;
        r2 = r2 + 1;
    L18:
        if (r0[1] != 0) goto L20;
        return false;
    L20:
        if (r11 < r2) goto L26;
        if (r12 < r2) goto L26;
        if (this.image.get(r12 - r2, r11 - r2) == false) goto L26;
        r0[0] = r0[0] + 1;
        r2 = r2 + 1;
    L26:
        if (r0[0] != 0) goto L28;
        return false;
    L28:
        int r3 = this.image.getHeight();
        int r5 = this.image.getWidth();
        int r6 = 1;
    L29:
        int r7 = r11 + r6;
        if (r7 >= r3) goto L36;
        int r8 = r12 + r6;
        if (r8 >= r5) goto L36;
        if (this.image.get(r8, r7) == false) goto L36;
        r0[2] = r0[2] + 1;
        r6 = r6 + 1;
    L36:
        int r4 = r11 + r6;
        if (r4 >= r3) goto L44;
        int r9 = r12 + r6;
        if (r9 >= r5) goto L44;
        if (this.image.get(r9, r4) == true) goto L44;
        r0[3] = r0[3] + 1;
        r6 = r6 + 1;
    L44:
        if (r0[3] != 0) goto L46;
        return false;
    L46:
        int r10 = r11 + r6;
        if (r10 >= r3) goto L54;
        int r13 = r12 + r6;
        if (r13 >= r5) goto L54;
        if (this.image.get(r13, r10) == false) goto L54;
        r0[4] = r0[4] + 1;
        r6 = r6 + 1;
    L54:
        if (r0[4] != 0) goto L57;
        return false;
    L57:
        return foundPatternDiagonal(r0);
    }

    private float crossCheckVertical(int r10, int r11, int r12, int r13) {
        BitMatrix r0 = this.image;
        int r1 = r0.getHeight();
        int[] r9 = getCrossCheckStateCount();
        int r2 = r10;
    L4:
        if (r2 < 0) goto L9;
        if (r0.get(r11, r2) == false) goto L9;
        r9[2] = r9[2] + 1;
        r2 = r2 - 1;
    L9:
        if (r2 >= 0) goto L11;
        return Float.NaN;
    L11:
        if (r2 < 0) goto L17;
        if (r0.get(r11, r2) == true) goto L17;
        int r6 = r9[1];
        if (r6 > r12) goto L17;
        r9[1] = r6 + 1;
        r2 = r2 - 1;
    L17:
        if (r2 >= 0) goto L19;
    L66:
        return Float.NaN;
    L19:
        if (r9[1] > r12) goto L66;
    L22:
        if (r2 < 0) goto L29;
        if (r0.get(r11, r2) == false) goto L29;
        int r7 = r9[0];
        if (r7 > r12) goto L29;
        r9[0] = r7 + 1;
        r2 = r2 - 1;
    L29:
        if (r9[0] <= r12) goto L31;
        return Float.NaN;
    L31:
        int r14 = r10 + 1;
    L32:
        if (r14 >= r1) goto L36;
        if (r0.get(r11, r14) == false) goto L36;
        r9[2] = r9[2] + 1;
        r14 = r14 + 1;
    L36:
        if (r14 != r1) goto L39;
        return Float.NaN;
    L39:
        if (r14 >= r1) goto L45;
        if (r0.get(r11, r14) == true) goto L45;
        int r8 = r9[3];
        if (r8 >= r12) goto L45;
        r9[3] = r8 + 1;
        r14 = r14 + 1;
    L45:
        if (r14 == r1) goto L66;
        if (r9[3] >= r12) goto L66;
    L50:
        if (r14 >= r1) goto L56;
        if (r0.get(r11, r14) == false) goto L56;
        int r15 = r9[4];
        if (r15 >= r12) goto L56;
        r9[4] = r15 + 1;
        r14 = r14 + 1;
    L56:
        int r16 = r9[4];
        if (r16 < r12) goto L60;
        return Float.NaN;
    L60:
        if ((Math.abs(((((r9[0] + r9[1]) + r9[2]) + r9[3]) + r16) - r13) * 5) < (r13 * 2)) goto L63;
        return Float.NaN;
    L63:
        if (foundPatternCross(r9) == false) goto L66;
        return centerFromEnd(r9, r14);
    }

    private float crossCheckHorizontal(int r10, int r11, int r12, int r13) {
        BitMatrix r0 = this.image;
        int r1 = r0.getWidth();
        int[] r9 = getCrossCheckStateCount();
        int r2 = r10;
    L4:
        if (r2 < 0) goto L9;
        if (r0.get(r2, r11) == false) goto L9;
        r9[2] = r9[2] + 1;
        r2 = r2 - 1;
    L9:
        if (r2 >= 0) goto L11;
        return Float.NaN;
    L11:
        if (r2 < 0) goto L17;
        if (r0.get(r2, r11) == true) goto L17;
        int r6 = r9[1];
        if (r6 > r12) goto L17;
        r9[1] = r6 + 1;
        r2 = r2 - 1;
    L17:
        if (r2 >= 0) goto L19;
    L66:
        return Float.NaN;
    L19:
        if (r9[1] > r12) goto L66;
    L22:
        if (r2 < 0) goto L29;
        if (r0.get(r2, r11) == false) goto L29;
        int r7 = r9[0];
        if (r7 > r12) goto L29;
        r9[0] = r7 + 1;
        r2 = r2 - 1;
    L29:
        if (r9[0] <= r12) goto L31;
        return Float.NaN;
    L31:
        int r14 = r10 + 1;
    L32:
        if (r14 >= r1) goto L36;
        if (r0.get(r14, r11) == false) goto L36;
        r9[2] = r9[2] + 1;
        r14 = r14 + 1;
    L36:
        if (r14 != r1) goto L39;
        return Float.NaN;
    L39:
        if (r14 >= r1) goto L45;
        if (r0.get(r14, r11) == true) goto L45;
        int r8 = r9[3];
        if (r8 >= r12) goto L45;
        r9[3] = r8 + 1;
        r14 = r14 + 1;
    L45:
        if (r14 == r1) goto L66;
        if (r9[3] >= r12) goto L66;
    L50:
        if (r14 >= r1) goto L56;
        if (r0.get(r14, r11) == false) goto L56;
        int r15 = r9[4];
        if (r15 >= r12) goto L56;
        r9[4] = r15 + 1;
        r14 = r14 + 1;
    L56:
        int r16 = r9[4];
        if (r16 < r12) goto L60;
        return Float.NaN;
    L60:
        if ((Math.abs(((((r9[0] + r9[1]) + r9[2]) + r9[3]) + r16) - r13) * 5) < r13) goto L63;
        return Float.NaN;
    L63:
        if (foundPatternCross(r9) == false) goto L66;
        return centerFromEnd(r9, r14);
    }

    @Deprecated
    protected final boolean handlePossibleCenter(int[] r1, int r2, int r3, boolean r4) {
        return handlePossibleCenter(r1, r2, r3);
    }

    protected final boolean handlePossibleCenter(int[] r6, int r7, int r8) {
        boolean r0 = false;
        int r1 = (((r6[0] + r6[1]) + r6[2]) + r6[3]) + r6[4];
        int r9 = (int) centerFromEnd(r6, r8);
        float r10 = crossCheckVertical(r7, r9, r6[2], r1);
        if (Float.isNaN(r10) == true) goto L20;
        int r4 = (int) r10;
        float r11 = crossCheckHorizontal(r9, r4, r6[2], r1);
        if (Float.isNaN(r11) == true) goto L20;
        if (crossCheckDiagonal(r4, (int) r11) == false) goto L20;
        float r12 = r1 / 7.0f;
        int r2 = 0;
    L10:
        if (r2 >= this.possibleCenters.size()) goto L15;
        FinderPattern r3 = this.possibleCenters.get(r2);
        if (r3.aboutEquals(r12, r10, r11) == true) goto L13;
        r2 = r2 + 1;
        goto L10
    L13:
        this.possibleCenters.set(r2, r3.combineEstimate(r10, r11, r12));
        r0 = true;
    L15:
        if (r0 == true) goto L19;
        FinderPattern r5 = new FinderPattern(r11, r10, r12);
        this.possibleCenters.add(r5);
        ResultPointCallback r13 = this.resultPointCallback;
        if (r13 == null) goto L19;
        r13.foundPossibleResultPoint(r5);
    L19:
        return true;
    L20:
        return false;
    }

    private int findRowSkip() {
        if (this.possibleCenters.size() > 1) goto L5;
        return 0;
    L5:
        Iterator<FinderPattern> r0 = this.possibleCenters.iterator();
        FinderPattern r3 = null;
    L7:
        if (r0.hasNext() == false) goto L14;
        FinderPattern r4 = r0.next();
        if (r4.getCount() < 2) goto L7;
        if (r3 != null) goto L12;
        r3 = r4;
        goto L7
    L12:
        this.hasSkipped = true;
        return ((int) (Math.abs(r3.getX() - r4.getX()) - Math.abs(r3.getY() - r4.getY()))) / 2;
    L14:
        return 0;
    }

    private boolean haveMultiplyConfirmedCenters() {
        int r0 = this.possibleCenters.size();
        Iterator<FinderPattern> r1 = this.possibleCenters.iterator();
        float r3 = 0.0f;
        int r4 = 0;
        float r5 = 0.0f;
    L4:
        if (r1.hasNext() == false) goto L9;
        FinderPattern r6 = r1.next();
        if (r6.getCount() < 2) goto L4;
        r4 = r4 + 1;
        r5 = r5 + r6.getEstimatedModuleSize();
        goto L4
    L9:
        if (r4 >= 3) goto L11;
        return false;
    L11:
        float r2 = r5 / r0;
        Iterator<FinderPattern> r9 = this.possibleCenters.iterator();
    L13:
        if (r9.hasNext() == false) goto L16;
        r3 = r3 + Math.abs(r9.next().getEstimatedModuleSize() - r2);
        goto L13
    L16:
        if (r3 > (r5 * 0.05f)) goto L19;
        return true;
    L19:
        return false;
    }

    private FinderPattern[] selectBestPatterns() throws NotFoundException {
        int r0 = this.possibleCenters.size();
        if (r0 < 3) goto L29;
        AnonymousClass1 r2 = null;
        float r5 = 0.0f;
        if (r0 <= 3) goto L20;
        Iterator<FinderPattern> r6 = this.possibleCenters.iterator();
        float r7 = 0.0f;
        float r8 = 0.0f;
    L8:
        if (r6.hasNext() == false) goto L10;
        float r9 = r6.next().getEstimatedModuleSize();
        r7 = r7 + r9;
        r8 = r8 + (r9 * r9);
        goto L8
    L10:
        float r1 = r0;
        float r10 = r7 / r1;
        float r3 = (float) Math.sqrt((r8 / r1) - (r10 * r10));
        Collections.sort(this.possibleCenters, new FurthestFromAverageComparator(r10, r2));
        float r4 = Math.max(0.2f * r10, r3);
        int r11 = 0;
    L12:
        if (r11 >= this.possibleCenters.size()) goto L20;
        if (this.possibleCenters.size() <= 3) goto L20;
        if (Math.abs(this.possibleCenters.get(r11).getEstimatedModuleSize() - r10) <= r4) goto L18;
        this.possibleCenters.remove(r11);
        r11 = r11 - 1;
    L18:
        r11 = r11 + 1;
    L20:
        if (this.possibleCenters.size() <= 3) goto L27;
        Iterator<FinderPattern> r12 = this.possibleCenters.iterator();
    L23:
        if (r12.hasNext() == false) goto L25;
        r5 = r5 + r12.next().getEstimatedModuleSize();
        goto L23
    L25:
        Collections.sort(this.possibleCenters, new CenterComparator(r5 / this.possibleCenters.size(), r2));
        List<FinderPattern> r13 = this.possibleCenters;
        r13.subList(3, r13.size()).clear();
    L27:
        return new FinderPattern[]{this.possibleCenters.get(0), this.possibleCenters.get(1), this.possibleCenters.get(2)};
    L29:
        throw NotFoundException.getNotFoundInstance();
    }
}
