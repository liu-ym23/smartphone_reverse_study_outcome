package com.google.zxing.oned.rss;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.detector.MathUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class RSS14Reader extends AbstractRSSReader {
    private static final int[][] FINDER_PATTERNS = null;
    private static final int[] INSIDE_GSUM = null;
    private static final int[] INSIDE_ODD_TOTAL_SUBSET = null;
    private static final int[] INSIDE_ODD_WIDEST = null;
    private static final int[] OUTSIDE_EVEN_TOTAL_SUBSET = null;
    private static final int[] OUTSIDE_GSUM = null;
    private static final int[] OUTSIDE_ODD_WIDEST = null;
    private final List<Pair> possibleLeftPairs;
    private final List<Pair> possibleRightPairs;

    static {
        OUTSIDE_EVEN_TOTAL_SUBSET = new int[]{1, 10, 34, 70, 126};
        INSIDE_ODD_TOTAL_SUBSET = new int[]{4, 20, 48, 81};
        OUTSIDE_GSUM = new int[]{0, 161, 961, 2015, 2715};
        INSIDE_GSUM = new int[]{0, 336, 1036, 1516};
        OUTSIDE_ODD_WIDEST = new int[]{8, 6, 4, 3, 1};
        INSIDE_ODD_WIDEST = new int[]{2, 4, 6, 8};
        FINDER_PATTERNS = new int[][]{new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    }

    public RSS14Reader() {
        this.possibleLeftPairs = new ArrayList();
        this.possibleRightPairs = new ArrayList();
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int r4, BitArray r5, Map<DecodeHintType, ?> r6) throws NotFoundException {
        Pair r0 = decodePair(r5, false, r4, r6);
        addOrTally(this.possibleLeftPairs, r0);
        r5.reverse();
        Pair r7 = decodePair(r5, true, r4, r6);
        addOrTally(this.possibleRightPairs, r7);
        r5.reverse();
        Iterator<Pair> r8 = this.possibleLeftPairs.iterator();
    L4:
        if (r8.hasNext() == false) goto L17;
        Pair r9 = r8.next();
        if (r9.getCount() <= 1) goto L4;
        Iterator<Pair> r10 = this.possibleRightPairs.iterator();
    L9:
        if (r10.hasNext() == false) goto L4;
        Pair r1 = r10.next();
        if (r1.getCount() <= 1) goto L9;
        if (checkChecksum(r9, r1) == false) goto L9;
        return constructResult(r9, r1);
    L17:
        throw NotFoundException.getNotFoundInstance();
    }

    private static void addOrTally(Collection<Pair> r4, Pair r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Iterator<Pair> r0 = r4.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        Pair r1 = r0.next();
        if (r1.getValue() != r5.getValue()) goto L6;
        r1.incrementCount();
        boolean r2 = true;
    L11:
        if (r2 == true) goto L17;
        r4.add(r5);
        return;
    L17:
        return;
    L10:
        r2 = false;
        goto L11
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        this.possibleLeftPairs.clear();
        this.possibleRightPairs.clear();
    }

    private static Result constructResult(Pair r8, Pair r9) {
        String r0 = String.valueOf((((long) r8.getValue()) * 4537077) + ((long) r9.getValue()));
        StringBuilder r1 = new StringBuilder(14);
        int r2 = 13 - r0.length();
    L4:
        if (r2 <= 0) goto L6;
        r1.append('0');
        r2 = r2 - 1;
        goto L4
    L6:
        r1.append(r0);
        int r3 = 0;
        int r5 = 0;
    L7:
        if (r3 >= 13) goto L12;
        int r6 = r1.charAt(r3) - '0';
        if ((r3 & 1) != 0) goto L11;
        r6 = r6 * 3;
    L11:
        r5 = r5 + r6;
        r3 = r3 + 1;
        goto L7
    L12:
        int r4 = 10 - (r5 % 10);
        if (r4 != 10) goto L15;
        r4 = 0;
    L15:
        r1.append(r4);
        ResultPoint[] r10 = r8.getFinderPattern().getResultPoints();
        ResultPoint[] r11 = r9.getFinderPattern().getResultPoints();
        return new Result(r1.toString(), null, new ResultPoint[]{r10[0], r10[1], r11[0], r11[1]}, BarcodeFormat.RSS_14);
    }

    private static boolean checkChecksum(Pair r2, Pair r3) {
        int r0 = (r2.getChecksumPortion() + (r3.getChecksumPortion() * 16)) % 79;
        int r4 = (r2.getFinderPattern().getValue() * 9) + r3.getFinderPattern().getValue();
        if (r4 <= 72) goto L6;
        r4 = r4 - 1;
    L6:
        if (r4 <= 8) goto L8;
        r4 = r4 - 1;
    L8:
        if (r0 != r4) goto L11;
        return true;
    L11:
        return false;
    }

    private Pair decodePair(BitArray r7, boolean r8, int r9, Map<DecodeHintType, ?> r10) {
        int[] r1 = findFinderPattern(r7, r8);     // Catch: NotFoundException -> L15
        FinderPattern r2 = parseFoundFinderPattern(r7, r9, r8, r1);     // Catch: NotFoundException -> L15
        if (r10 != null) goto L6;
        ResultPointCallback r11 = null;
    L8:
        if (r11 == null) goto L13;
        float r3 = (r1[0] + r1[1]) / 2.0f;     // Catch: NotFoundException -> L15
        if (r8 == false) goto L12;
        r3 = (r7.getSize() - 1) - r3;     // Catch: NotFoundException -> L15
    L12:
        r11.foundPossibleResultPoint(new ResultPoint(r3, r9));     // Catch: NotFoundException -> L15
    L13:
        DataCharacter r12 = decodeDataCharacter(r7, r2, true);     // Catch: NotFoundException -> L15
        DataCharacter r6 = decodeDataCharacter(r7, r2, false);     // Catch: NotFoundException -> L15
        return new Pair((r12.getValue() * 1597) + r6.getValue(), r12.getChecksumPortion() + (r6.getChecksumPortion() * 4), r2);
    L6:
        r11 = (ResultPointCallback) r10.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);     // Catch: NotFoundException -> L15
    L15:
        return null;
    }

    private DataCharacter decodeDataCharacter(BitArray r13, FinderPattern r14, boolean r15) throws NotFoundException {
        int[] r0 = getDataCharacterCounters();
        int r2 = 0;
    L4:
        if (r2 >= r0.length) goto L7;
        r0[r2] = 0;
        r2 = r2 + 1;
        goto L4
    L7:
        if (r15 == false) goto L9;
        recordPatternInReverse(r13, r14.getStartEnd()[0], r0);
    L12:
        if (r15 == false) goto L14;
        int r16 = 16;
    L15:
        float r17 = MathUtils.sum(r0) / r16;
        int[] r3 = getOddCounts();
        int[] r4 = getEvenCounts();
        float[] r5 = getOddRoundingErrors();
        float[] r6 = getEvenRoundingErrors();
        int r7 = 0;
    L17:
        if (r7 >= r0.length) goto L29;
        float r8 = r0[r7] / r17;
        int r9 = (int) (0.5f + r8);
        if (r9 > 0) goto L22;
        r9 = 1;
    L24:
        int r10 = r7 / 2;
        if ((r7 & 1) != 0) goto L27;
        r3[r10] = r9;
        r5[r10] = r8 - r9;
    L28:
        r7 = r7 + 1;
        goto L17
    L27:
        r4[r10] = r9;
        r6[r10] = r8 - r9;
        goto L28
    L22:
        if (r9 <= 8) goto L24;
        r9 = 8;
        goto L24
    L29:
        adjustOddEvenCounts(r15, r16);
        int r12 = r3.length - 1;
        int r18 = 0;
        int r19 = 0;
    L30:
        if (r12 < 0) goto L32;
        int r1 = r3[r12];
        r18 = (r18 * 9) + r1;
        r19 = r19 + r1;
        r12 = r12 - 1;
        goto L30
    L32:
        int r110 = r4.length - 1;
        int r11 = 0;
        int r20 = 0;
    L33:
        if (r110 < 0) goto L35;
        int r21 = r4[r110];
        r11 = (r11 * 9) + r21;
        r20 = r20 + r21;
        r110 = r110 - 1;
        goto L33
    L35:
        int r111 = r18 + (r11 * 3);
        if (r15 == false) goto L47;
        if ((r19 & 1) != 0) goto L45;
        if (r19 > 12) goto L45;
        if (r19 < 4) goto L45;
        int r112 = (12 - r19) / 2;
        int r113 = OUTSIDE_ODD_WIDEST[r112];
        int r114 = 9 - r113;
        int r115 = RSSUtils.getRSSvalue(r3, r113, false);
        return new DataCharacter(((r115 * OUTSIDE_EVEN_TOTAL_SUBSET[r112]) + RSSUtils.getRSSvalue(r4, r114, true)) + OUTSIDE_GSUM[r112], r111);
    L45:
        throw NotFoundException.getNotFoundInstance();
    L47:
        if ((r20 & 1) != 0) goto L54;
        if (r20 > 10) goto L54;
        if (r20 < 4) goto L54;
        int r116 = (10 - r20) / 2;
        int r117 = INSIDE_ODD_WIDEST[r116];
        int r118 = 9 - r117;
        return new DataCharacter(((RSSUtils.getRSSvalue(r4, r118, false) * INSIDE_ODD_TOTAL_SUBSET[r116]) + RSSUtils.getRSSvalue(r3, r117, true)) + INSIDE_GSUM[r116], r111);
    L54:
        throw NotFoundException.getNotFoundInstance();
    L14:
        r16 = 15;
        goto L15
    L9:
        recordPattern(r13, r14.getStartEnd()[1] + 1, r0);
        int r119 = r0.length - 1;
        int r120 = 0;
    L10:
        if (r120 >= r119) goto L12;
        int r22 = r0[r120];
        r0[r120] = r0[r119];
        r0[r119] = r22;
        r120 = r120 + 1;
        r119 = r119 - 1;
        goto L10
    }

    private int[] findFinderPattern(BitArray r11, boolean r12) throws NotFoundException {
        int[] r10 = getDecodeFinderCounters();
        r10[0] = 0;
        r10[1] = 0;
        r10[2] = 0;
        r10[3] = 0;
        int r4 = r11.getSize();
        int r5 = 0;
        boolean r6 = false;
    L3:
        if (r5 >= r4) goto L7;
        r6 = !r11.get(r5);
        if (r12 == r6) goto L7;
        r5 = r5 + 1;
    L7:
        int r7 = 0;
        int r13 = r5;
    L8:
        if (r5 >= r4) goto L22;
        if (r11.get(r5) == r6) goto L12;
        r10[r7] = r10[r7] + 1;
    L20:
        r5 = r5 + 1;
        goto L8
    L12:
        if (r7 == 3) goto L14;
        r7 = r7 + 1;
    L19:
        r10[r7] = 1;
        r6 = !r6;
        goto L20
    L14:
        if (isFinderPattern(r10) == true) goto L16;
        r13 = r13 + (r10[0] + r10[1]);
        r10[0] = r10[2];
        r10[1] = r10[3];
        r10[2] = 0;
        r10[3] = 0;
        r7 = r7 - 1;
        goto L19
    L16:
        return new int[]{r13, r5};
    L22:
        throw NotFoundException.getNotFoundInstance();
    }

    private FinderPattern parseFoundFinderPattern(BitArray r11, int r12, boolean r13, int[] r14) throws NotFoundException {
        boolean r1 = r11.get(r14[0]);
        int r2 = r14[0] - 1;
    L3:
        if (r2 < 0) goto L7;
        if (r1 == r11.get(r2)) goto L7;
        r2 = r2 - 1;
    L7:
        int r3 = r2 + 1;
        int r4 = r14[0] - r3;
        int[] r10 = getDecodeFinderCounters();
        System.arraycopy(r10, 0, r10, 1, r10.length - 1);
        r10[0] = r4;
        int r5 = parseFinderValue(r10, FINDER_PATTERNS);
        int r15 = r14[1];
        if (r13 == false) goto L10;
        int r16 = (r11.getSize() - 1) - r3;
        int r8 = (r11.getSize() - 1) - r15;
        int r7 = r16;
    L12:
        return new FinderPattern(r5, new int[]{r3, r14[1]}, r7, r8, r12);
    L10:
        r8 = r15;
        r7 = r3;
        goto L12
    }

    private void adjustOddEvenCounts(boolean r10, int r11) throws NotFoundException {
        int r0 = MathUtils.sum(getOddCounts());
        int r1 = MathUtils.sum(getEvenCounts());
        boolean r3 = true;
        boolean r4 = false;
        if (r10 == false) goto L15;
        if (r0 <= 12) goto L7;
        boolean r7 = true;
        boolean r6 = false;
    L10:
        if (r1 > 12) goto L23;
        if (r1 < 4) goto L25;
    L26:
        boolean r2 = false;
        boolean r5 = false;
    L27:
        int r8 = (r0 + r1) - r11;
        if ((r0 & 1) != r10) goto L30;
        boolean r12 = true;
    L32:
        if ((r1 & 1) != 1) goto L34;
        r4 = true;
    L34:
        if (r8 != 1) goto L46;
        if (r12 == false) goto L40;
        if (r4 == true) goto L39;
        r7 = true;
    L42:
        r3 = r6;
    L66:
        if (r3 == false) goto L71;
        if (r7 == true) goto L70;
        increment(getOddCounts(), getOddRoundingErrors());
        goto L71
    L70:
        throw NotFoundException.getNotFoundInstance();
    L71:
        if (r7 == false) goto L73;
        decrement(getOddCounts(), getOddRoundingErrors());
    L73:
        if (r2 == false) goto L78;
        if (r5 == true) goto L77;
        increment(getEvenCounts(), getOddRoundingErrors());
        goto L78
    L77:
        throw NotFoundException.getNotFoundInstance();
    L78:
        if (r5 == false) goto L85;
        decrement(getEvenCounts(), getEvenRoundingErrors());
        return;
    L85:
        return;
    L39:
        throw NotFoundException.getNotFoundInstance();
    L40:
        if (r4 == false) goto L44;
        r5 = true;
        goto L42
    L44:
        throw NotFoundException.getNotFoundInstance();
    L46:
        if (r8 != (-1)) goto L56;
        if (r12 == false) goto L52;
        if (r4 == false) goto L66;
        throw NotFoundException.getNotFoundInstance();
    L52:
        if (r4 == false) goto L55;
        r2 = true;
        goto L42
    L55:
        throw NotFoundException.getNotFoundInstance();
    L56:
        if (r8 != 0) goto L84;
        if (r12 == false) goto L64;
        if (r4 == false) goto L63;
        if (r0 >= r1) goto L61;
        r5 = true;
        goto L66
    L61:
        r2 = true;
        r7 = true;
        goto L42
    L63:
        throw NotFoundException.getNotFoundInstance();
    L64:
        if (r4 == false) goto L42;
        throw NotFoundException.getNotFoundInstance();
    L84:
        throw NotFoundException.getNotFoundInstance();
    L30:
        r12 = false;
    L25:
        r2 = true;
        r5 = false;
    L23:
        r5 = true;
        r2 = false;
        goto L27
    L7:
        if (r0 >= 4) goto L9;
        r6 = true;
        r7 = false;
        goto L10
    L9:
        r6 = false;
        r7 = false;
        goto L10
    L15:
        if (r0 <= 11) goto L18;
        r7 = true;
        r6 = false;
    L22:
        if (r1 > 10) goto L23;
        if (r1 >= 4) goto L26;
    L18:
        if (r0 >= 5) goto L20;
        r6 = true;
        r7 = false;
        goto L22
    L20:
        r6 = false;
        r7 = false;
        goto L22
    }
}
