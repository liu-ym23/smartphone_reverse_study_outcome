package com.google.zxing.oned.rss.expanded;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.rss.AbstractRSSReader;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
import com.google.zxing.oned.rss.RSSUtils;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class RSSExpandedReader extends AbstractRSSReader {
    private static final int[] EVEN_TOTAL_SUBSET = null;
    private static final int[][] FINDER_PATTERNS = null;
    private static final int[][] FINDER_PATTERN_SEQUENCES = null;
    private static final int FINDER_PAT_A = 0;
    private static final int FINDER_PAT_B = 1;
    private static final int FINDER_PAT_C = 2;
    private static final int FINDER_PAT_D = 3;
    private static final int FINDER_PAT_E = 4;
    private static final int FINDER_PAT_F = 5;
    private static final int[] GSUM = null;
    private static final int MAX_PAIRS = 11;
    private static final int[] SYMBOL_WIDEST = null;
    private static final int[][] WEIGHTS = null;
    private final List<ExpandedPair> pairs;
    private final List<ExpandedRow> rows;
    private final int[] startEnd;
    private boolean startFromEven;

    public RSSExpandedReader() {
        this.pairs = new ArrayList(11);
        this.rows = new ArrayList();
        this.startEnd = new int[2];
    }

    static {
        SYMBOL_WIDEST = new int[]{7, 5, 4, 3, 1};
        EVEN_TOTAL_SUBSET = new int[]{4, 20, 52, 104, 204};
        GSUM = new int[]{0, 348, 1388, 2948, 3988};
        FINDER_PATTERNS = new int[][]{new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
        WEIGHTS = new int[][]{new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};
        FINDER_PATTERN_SEQUENCES = new int[][]{new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int r1, BitArray r2, Map<DecodeHintType, ?> r3) throws NotFoundException, FormatException {
        this.pairs.clear();
        this.startFromEven = false;
        return constructResult(decodeRow2pairs(r1, r2));
    L5:
        this.pairs.clear();
        this.startFromEven = true;
        return constructResult(decodeRow2pairs(r1, r2));
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        this.pairs.clear();
        this.rows.clear();
    }

    List<ExpandedPair> decodeRow2pairs(int r6, BitArray r7) throws NotFoundException {
        boolean r1 = false;
    L4:
        if (r1 == true) goto L13;
        List<ExpandedPair> r3 = this.pairs;     // Catch: NotFoundException -> L7
        r3.add(retrieveNextPair(r7, r3, r6));     // Catch: NotFoundException -> L7
    L7:
        e = move-exception;
        if (this.pairs.isEmpty() == true) goto L11;
        r1 = true;
        goto L4
    L11:
        throw e;
    L13:
        if (checkChecksum() == true) goto L15;
        boolean r8 = !this.rows.isEmpty();
        storeRow(r6, false);
        if (r8 == false) goto L25;
        List<ExpandedPair> r9 = checkRows(false);
        if (r9 == null) goto L21;
        return r9;
    L21:
        List<ExpandedPair> r5 = checkRows(true);
        if (r5 == null) goto L25;
        return r5;
    L25:
        throw NotFoundException.getNotFoundInstance();
    L15:
        return this.pairs;
    }

    private List<ExpandedPair> checkRows(boolean r4) {
        List<ExpandedPair> r2 = null;
        if (this.rows.size() <= 25) goto L6;
        this.rows.clear();
        return null;
    L6:
        this.pairs.clear();
        if (r4 == false) goto L14;
        Collections.reverse(this.rows);
    L14:
        r2 = checkRows(new ArrayList(), 0);     // Catch: NotFoundException -> L13
    L10:
        if (r4 == false) goto L12;
        Collections.reverse(this.rows);
    L12:
        return r2;
    }

    private List<ExpandedPair> checkRows(List<ExpandedRow> r5, int r6) throws NotFoundException {
    L3:
        if (r6 >= this.rows.size()) goto L19;
        ExpandedRow r0 = this.rows.get(r6);
        this.pairs.clear();
        Iterator<ExpandedRow> r1 = r5.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        ExpandedRow r2 = r1.next();
        this.pairs.addAll(r2.getPairs());
        goto L6
    L8:
        this.pairs.addAll(r0.getPairs());
        if (isValidSequence(this.pairs) == false) goto L17;
        if (this.checkChecksum() == true) goto L13;
        ArrayList r3 = new ArrayList(r5);
        r3.add(r0);
        return this.checkRows(r3, r6 + 1);
    L13:
        return this.pairs;
    L17:
        r6 = r6 + 1;
        goto L3
    L19:
        throw NotFoundException.getNotFoundInstance();
    }

    private static boolean isValidSequence(List<ExpandedPair> r9) {
        int[][] r0 = FINDER_PATTERN_SEQUENCES;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L17;
        int[] r4 = r0[r3];
        if (r9.size() > r4.length) goto L16;
        int r5 = 0;
    L8:
        if (r5 >= r9.size()) goto L13;
        if (r9.get(r5).getFinderPattern().getValue() != r4[r5]) goto L11;
        r5 = r5 + 1;
        goto L8
    L11:
        boolean r6 = false;
    L14:
        if (r6 == false) goto L16;
        return true;
    L13:
        r6 = true;
    L16:
        r3 = r3 + 1;
        goto L3
    L17:
        return false;
    }

    private void storeRow(int r6, boolean r7) {
        boolean r0 = false;
        int r1 = 0;
        boolean r2 = false;
    L4:
        if (r1 >= this.rows.size()) goto L9;
        ExpandedRow r3 = this.rows.get(r1);
        if (r3.getRowNumber() > r6) goto L7;
        r2 = r3.isEquivalent(this.pairs);
        r1 = r1 + 1;
        goto L4
    L7:
        r0 = r3.isEquivalent(this.pairs);
    L9:
        if (r0 == true) goto L19;
        if (r2 == false) goto L13;
        return;
    L13:
        if (isPartialRow(this.pairs, this.rows) == false) goto L15;
        return;
    L15:
        this.rows.add(r1, new ExpandedRow(this.pairs, r6, r7));
        removePartialRows(this.pairs, this.rows);
        return;
    }

    private static void removePartialRows(List<ExpandedPair> r6, List<ExpandedRow> r7) {
        Iterator<ExpandedRow> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L21;
        ExpandedRow r0 = r8.next();
        if (r0.getPairs().size() == r6.size()) goto L4;
        Iterator<ExpandedPair> r1 = r0.getPairs().iterator();
    L8:
        boolean r2 = true;
        if (r1.hasNext() == false) goto L19;
        ExpandedPair r3 = r1.next();
        Iterator<ExpandedPair> r4 = r6.iterator();
    L12:
        if (r4.hasNext() == false) goto L16;
        if (r3.equals(r4.next()) == false) goto L12;
    L17:
        if (r2 == true) goto L8;
        r2 = false;
        goto L19
    L16:
        r2 = false;
    L19:
        if (r2 == false) goto L4;
        r8.remove();
        goto L4
    }

    private static boolean isPartialRow(Iterable<ExpandedPair> r7, Iterable<ExpandedRow> r8) {
        Iterator<ExpandedRow> r9 = r8.iterator();
    L3:
        boolean r1 = false;
        if (r9.hasNext() == false) goto L20;
        ExpandedRow r0 = r9.next();
        Iterator<ExpandedPair> r2 = r7.iterator();
    L7:
        if (r2.hasNext() == false) goto L17;
        ExpandedPair r3 = r2.next();
        Iterator<ExpandedPair> r5 = r0.getPairs().iterator();
    L10:
        if (r5.hasNext() == false) goto L14;
        if (r3.equals(r5.next()) == false) goto L10;
        boolean r4 = true;
    L15:
        if (r4 == true) goto L7;
    L18:
        if (r1 == false) goto L3;
        return true;
    L14:
        r4 = false;
        goto L15
    L17:
        r1 = true;
        goto L18
    L20:
        return false;
    }

    List<ExpandedRow> getRows() {
        return this.rows;
    }

    static Result constructResult(List<ExpandedPair> r7) throws NotFoundException, FormatException {
        String r0 = AbstractExpandedDecoder.createDecoder(BitArrayBuilder.buildBitArray(r7)).parseInformation();
        ResultPoint[] r2 = r7.get(0).getFinderPattern().getResultPoints();
        ResultPoint[] r8 = r7.get(r7.size() - 1).getFinderPattern().getResultPoints();
        return new Result(r0, null, new ResultPoint[]{r2[0], r2[1], r8[0], r8[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    private boolean checkChecksum() {
        ExpandedPair r0 = this.pairs.get(0);
        DataCharacter r2 = r0.getLeftChar();
        DataCharacter r1 = r0.getRightChar();
        if (r1 != null) goto L5;
        return false;
    L5:
        int r3 = r1.getChecksumPortion();
        int r4 = 2;
        int r5 = 1;
    L7:
        if (r5 >= this.pairs.size()) goto L13;
        ExpandedPair r6 = this.pairs.get(r5);
        r3 = r3 + r6.getLeftChar().getChecksumPortion();
        r4 = r4 + 1;
        DataCharacter r7 = r6.getRightChar();
        if (r7 == null) goto L11;
        r3 = r3 + r7.getChecksumPortion();
        r4 = r4 + 1;
    L11:
        r5 = r5 + 1;
        goto L7
    L13:
        if ((((r4 - 4) * 211) + (r3 % 211)) != r2.getValue()) goto L15;
        return true;
    L15:
        return false;
    }

    private static int getNextSecondBar(BitArray r1, int r2) {
        if (r1.get(r2) == false) goto L6;
        return r1.getNextSet(r1.getNextUnset(r2));
    L6:
        return r1.getNextUnset(r1.getNextSet(r2));
    }

    ExpandedPair retrieveNextPair(BitArray r7, List<ExpandedPair> r8, int r9) throws NotFoundException {
        if ((r8.size() % 2) != 0) goto L5;
        boolean r0 = true;
    L7:
        if (this.startFromEven == false) goto L9;
        r0 = !r0;
    L9:
        int r3 = -1;
        boolean r4 = true;
    L10:
        findNextPair(r7, r8, r3);
        FinderPattern r5 = parseFoundFinderPattern(r7, r9, r0);
        if (r5 != null) goto L13;
        r3 = getNextSecondBar(r7, this.startEnd[0]);
    L14:
        if (r4 == true) goto L10;
        DataCharacter r10 = decodeDataCharacter(r7, r5, r0, true);
        if (r8.isEmpty() == false) goto L18;
    L27:
        DataCharacter r6 = decodeDataCharacter(r7, r5, r0, false);     // Catch: NotFoundException -> L24
    L26:
        return new ExpandedPair(r10, r6, r5, true);
    L24:
        r6 = null;
        goto L26
    L18:
        if (r8.get(r8.size() - 1).mustBeLast() == false) goto L27;
        throw NotFoundException.getNotFoundInstance();
    L13:
        r4 = false;
        goto L14
    L5:
        r0 = false;
        goto L7
    }

    private void findNextPair(BitArray r12, List<ExpandedPair> r13, int r14) throws NotFoundException {
        int[] r0 = getDecodeFinderCounters();
        r0[0] = 0;
        r0[1] = 0;
        r0[2] = 0;
        r0[3] = 0;
        int r5 = r12.getSize();
        if (r14 >= 0) goto L10;
        if (r13.isEmpty() == false) goto L8;
        r14 = 0;
        goto L10
    L8:
        r14 = r13.get(r13.size() - 1).getFinderPattern().getStartEnd()[1];
    L10:
        if ((r13.size() % 2) == 0) goto L12;
        boolean r15 = true;
    L14:
        if (this.startFromEven == false) goto L16;
        r15 = !r15;
    L16:
        boolean r6 = false;
    L17:
        if (r14 >= r5) goto L21;
        r6 = !r12.get(r14);
        if (r6 == false) goto L21;
        r14 = r14 + 1;
    L21:
        int r8 = 0;
        boolean r7 = r6;
        int r9 = r14;
    L22:
        if (r14 >= r5) goto L40;
        if (r12.get(r14) == r7) goto L26;
        r0[r8] = r0[r8] + 1;
    L38:
        r14 = r14 + 1;
        goto L22
    L26:
        if (r8 != 3) goto L36;
        if (r15 == false) goto L30;
        reverseCounters(r0);
    L30:
        if (isFinderPattern(r0) == true) goto L31;
        if (r15 == false) goto L35;
        reverseCounters(r0);
    L35:
        r9 = r9 + (r0[0] + r0[1]);
        r0[0] = r0[2];
        r0[1] = r0[3];
        r0[2] = 0;
        r0[3] = 0;
        r8 = r8 - 1;
    L37:
        r0[r8] = 1;
        r7 = !r7;
        goto L38
    L31:
        int[] r11 = this.startEnd;
        r11[0] = r9;
        r11[1] = r14;
        return;
    L36:
        r8 = r8 + 1;
        goto L37
    L40:
        throw NotFoundException.getNotFoundInstance();
    L12:
        r15 = false;
        goto L14
    }

    private static void reverseCounters(int[] r5) {
        int r0 = r5.length;
        int r1 = 0;
    L4:
        if (r1 >= (r0 / 2)) goto L6;
        int r2 = r5[r1];
        int r3 = (r0 - r1) - 1;
        r5[r1] = r5[r3];
        r5[r3] = r2;
        r1 = r1 + 1;
        goto L4
    }

    private FinderPattern parseFoundFinderPattern(BitArray r10, int r11, boolean r12) {
        if (r12 == false) goto L10;
        int r13 = this.startEnd[0] - 1;
    L5:
        if (r13 < 0) goto L9;
        if (r10.get(r13) == true) goto L9;
        r13 = r13 - 1;
    L9:
        int r14 = r13 + 1;
        int[] r15 = this.startEnd;
        int r2 = r15[0] - r14;
        int r7 = r15[1];
        int r6 = r14;
    L11:
        int[] r9 = getDecodeFinderCounters();
        System.arraycopy(r9, 0, r9, 1, r9.length - 1);
        r9[0] = r2;
        return new FinderPattern(parseFinderValue(r9, FINDER_PATTERNS), new int[]{r6, r7}, r6, r7, r11);
    L15:
        return null;
    L10:
        int[] r16 = this.startEnd;
        int r3 = r16[0];
        int r17 = r10.getNextUnset(r16[1] + 1);
        r7 = r17;
        r6 = r3;
        r2 = r17 - this.startEnd[1];
        goto L11
    }

    DataCharacter decodeDataCharacter(BitArray r15, FinderPattern r16, boolean r17, boolean r18) throws NotFoundException {
        int[] r1 = getDataCharacterCounters();
        int r3 = 0;
    L4:
        if (r3 >= r1.length) goto L7;
        r1[r3] = 0;
        r3 = r3 + 1;
        goto L4
    L7:
        if (r18 == false) goto L9;
        recordPatternInReverse(r15, r16.getStartEnd()[0], r1);
    L12:
        float r0 = MathUtils.sum(r1) / 17.0f;
        float r4 = (r16.getStartEnd()[1] - r16.getStartEnd()[0]) / 15.0f;
        if ((Math.abs(r0 - r4) / r4) > 0.3f) goto L62;
        int[] r5 = getOddCounts();
        int[] r6 = getEvenCounts();
        float[] r7 = getOddRoundingErrors();
        float[] r8 = getEvenRoundingErrors();
        int r9 = 0;
    L16:
        if (r9 >= r1.length) goto L36;
        float r10 = (r1[r9] * 1.0f) / r0;
        int r11 = (int) (0.5f + r10);
        if (r11 > 0) goto L25;
        if (r10 < 0.3f) goto L23;
        r11 = 1;
    L31:
        int r12 = r9 / 2;
        if ((r9 & 1) != 0) goto L34;
        r5[r12] = r11;
        r7[r12] = r10 - r11;
    L35:
        r9 = r9 + 1;
        goto L16
    L34:
        r6[r12] = r11;
        r8[r12] = r10 - r11;
        goto L35
    L23:
        throw NotFoundException.getNotFoundInstance();
    L25:
        if (r11 <= 8) goto L31;
        if (r10 > 8.7f) goto L30;
        r11 = 8;
        goto L31
    L30:
        throw NotFoundException.getNotFoundInstance();
    L36:
        adjustOddEvenCounts(17);
        int r2 = r16.getValue() * 4;
        if (r17 == false) goto L39;
        int r13 = 0;
    L40:
        int r14 = ((r2 + r13) + (!r18 ? 1 : 0)) - 1;
        int r19 = r5.length - 1;
        int r20 = 0;
        int r21 = 0;
    L41:
        if (r19 < 0) goto L46;
        if (isNotA1left(r16, r17, r18) == false) goto L45;
        r20 = r20 + (r5[r19] * WEIGHTS[r14][r19 * 2]);
    L45:
        r21 = r21 + r5[r19];
        r19 = r19 - 1;
        goto L41
    L46:
        int r22 = r6.length - 1;
        int r110 = 0;
    L47:
        if (r22 < 0) goto L52;
        if (isNotA1left(r16, r17, r18) == false) goto L51;
        r110 = r110 + (r6[r22] * WEIGHTS[r14][(r22 * 2) + 1]);
    L51:
        r22 = r22 - 1;
        goto L47
    L52:
        int r23 = r20 + r110;
        if ((r21 & 1) != 0) goto L60;
        if (r21 > 13) goto L60;
        if (r21 < 4) goto L60;
        int r24 = (13 - r21) / 2;
        int r25 = SYMBOL_WIDEST[r24];
        int r26 = 9 - r25;
        int r27 = RSSUtils.getRSSvalue(r5, r25, true);
        return new DataCharacter(((r27 * EVEN_TOTAL_SUBSET[r24]) + RSSUtils.getRSSvalue(r6, r26, false)) + GSUM[r24], r23);
    L60:
        throw NotFoundException.getNotFoundInstance();
    L39:
        r13 = 2;
        goto L40
    L62:
        throw NotFoundException.getNotFoundInstance();
    L9:
        recordPattern(r15, r16.getStartEnd()[1], r1);
        int r28 = r1.length - 1;
        int r29 = 0;
    L10:
        if (r29 >= r28) goto L12;
        int r30 = r1[r29];
        r1[r29] = r1[r28];
        r1[r28] = r30;
        r29 = r29 + 1;
        r28 = r28 - 1;
        goto L10
    }

    private static boolean isNotA1left(FinderPattern r0, boolean r1, boolean r2) {
        if (r0.getValue() != 0) goto L9;
        if (r1 == false) goto L11;
        if (r2 == false) goto L12;
        return false;
    L12:
        return true;
    L11:
        return true;
    L9:
        return true;
    }

    private void adjustOddEvenCounts(int r11) throws NotFoundException {
        int r0 = MathUtils.sum(getOddCounts());
        int r1 = MathUtils.sum(getEvenCounts());
        boolean r3 = true;
        boolean r4 = false;
        if (r0 <= 13) goto L5;
        boolean r7 = true;
        boolean r6 = false;
    L8:
        if (r1 <= 13) goto L10;
        boolean r5 = true;
        boolean r2 = false;
    L13:
        int r8 = (r0 + r1) - r11;
        if ((r0 & 1) != 1) goto L16;
        boolean r12 = true;
    L18:
        if ((r1 & 1) != 0) goto L20;
        r4 = true;
    L20:
        if (r8 != 1) goto L32;
        if (r12 == false) goto L26;
        if (r4 == true) goto L25;
        r7 = true;
    L28:
        r3 = r6;
    L52:
        if (r3 == false) goto L57;
        if (r7 == true) goto L56;
        increment(getOddCounts(), getOddRoundingErrors());
        goto L57
    L56:
        throw NotFoundException.getNotFoundInstance();
    L57:
        if (r7 == false) goto L59;
        decrement(getOddCounts(), getOddRoundingErrors());
    L59:
        if (r2 == false) goto L64;
        if (r5 == true) goto L63;
        increment(getEvenCounts(), getOddRoundingErrors());
        goto L64
    L63:
        throw NotFoundException.getNotFoundInstance();
    L64:
        if (r5 == false) goto L71;
        decrement(getEvenCounts(), getEvenRoundingErrors());
        return;
    L71:
        return;
    L25:
        throw NotFoundException.getNotFoundInstance();
    L26:
        if (r4 == false) goto L30;
        r5 = true;
        goto L28
    L30:
        throw NotFoundException.getNotFoundInstance();
    L32:
        if (r8 != (-1)) goto L42;
        if (r12 == false) goto L38;
        if (r4 == false) goto L52;
        throw NotFoundException.getNotFoundInstance();
    L38:
        if (r4 == false) goto L41;
        r2 = true;
        goto L28
    L41:
        throw NotFoundException.getNotFoundInstance();
    L42:
        if (r8 != 0) goto L70;
        if (r12 == false) goto L50;
        if (r4 == false) goto L49;
        if (r0 >= r1) goto L47;
        r5 = true;
        goto L52
    L47:
        r2 = true;
        r7 = true;
        goto L28
    L49:
        throw NotFoundException.getNotFoundInstance();
    L50:
        if (r4 == false) goto L28;
        throw NotFoundException.getNotFoundInstance();
    L70:
        throw NotFoundException.getNotFoundInstance();
    L16:
        r12 = false;
        goto L18
    L10:
        if (r1 >= 4) goto L12;
        r2 = true;
        r5 = false;
        goto L13
    L12:
        r2 = false;
        r5 = false;
        goto L13
    L5:
        if (r0 >= 4) goto L7;
        r6 = true;
        r7 = false;
        goto L8
    L7:
        r6 = false;
        r7 = false;
        goto L8
    }
}
