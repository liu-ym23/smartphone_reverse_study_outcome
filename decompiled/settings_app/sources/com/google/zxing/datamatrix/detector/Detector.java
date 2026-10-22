package com.google.zxing.datamatrix.detector;

import com.bytedance.librarian.LibrarianImpl;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class Detector {
    private final BitMatrix image;
    private final WhiteRectangleDetector rectangleDetector;

    /* JADX INFO: renamed from: com.google.zxing.datamatrix.detector.Detector$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class ResultPointsAndTransitions {
        private final ResultPoint from;
        private final ResultPoint to;
        private final int transitions;

        /* synthetic */ ResultPointsAndTransitions(ResultPoint r1, ResultPoint r2, int r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        private ResultPointsAndTransitions(ResultPoint r1, ResultPoint r2, int r3) {
            this.from = r1;
            this.to = r2;
            this.transitions = r3;
        }

        ResultPoint getFrom() {
            return this.from;
        }

        ResultPoint getTo() {
            return this.to;
        }

        int getTransitions() {
            return this.transitions;
        }

        public String toString() {
            return this.from + LibrarianImpl.Constants.SEPARATOR + this.to + IOUtils.DIR_SEPARATOR_UNIX + this.transitions;
        }
    }

    private static final class ResultPointsAndTransitionsComparator implements Serializable, Comparator<ResultPointsAndTransitions> {
        private ResultPointsAndTransitionsComparator() {
        }

        /* synthetic */ ResultPointsAndTransitionsComparator(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(ResultPointsAndTransitions r1, ResultPointsAndTransitions r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(ResultPointsAndTransitions r1, ResultPointsAndTransitions r2) {
            return r1.getTransitions() - r2.getTransitions();
        }
    }

    public Detector(BitMatrix r2) throws NotFoundException {
        this.image = r2;
        this.rectangleDetector = new WhiteRectangleDetector(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DetectorResult detect() throws NotFoundException {
        ResultPoint[] r0 = this.rectangleDetector.detect();
        ResultPoint r1 = r0[0];
        ResultPoint r2 = r0[1];
        ResultPoint r3 = r0[2];
        ResultPoint r4 = r0[3];
        ArrayList r5 = new ArrayList(4);
        r5.add(transitionsBetween(r1, r2));
        r5.add(transitionsBetween(r1, r3));
        r5.add(transitionsBetween(r2, r4));
        r5.add(transitionsBetween(r3, r4));
        ResultPoint r6 = null;
        Collections.sort(r5, new ResultPointsAndTransitionsComparator(0 == true ? 1 : 0));
        ResultPointsAndTransitions r7 = (ResultPointsAndTransitions) r5.get(0);
        ResultPointsAndTransitions r8 = (ResultPointsAndTransitions) r5.get(1);
        HashMap r13 = new HashMap();
        increment(r13, r7.getFrom());
        increment(r13, r7.getTo());
        increment(r13, r8.getFrom());
        increment(r13, r8.getTo());
        Iterator r9 = r13.entrySet().iterator();
        ResultPoint r10 = null;
        ResultPoint r14 = null;
    L4:
        if (r9.hasNext() == false) goto L11;
        Map.Entry r15 = (Map.Entry) r9.next();
        ResultPoint r16 = (ResultPoint) r15.getKey();
        if (((Integer) r15.getValue()).intValue() == 2) goto L7;
        if (r6 == null) goto L9;
        r14 = r16;
        goto L4
    L9:
        r6 = r16;
        goto L4
    L7:
        r10 = r16;
        goto L4
    L11:
        if (r6 == null) goto L57;
        if (r10 == null) goto L57;
        if (r14 == null) goto L57;
        ResultPoint[] r11 = {r6, r10, r14};
        ResultPoint.orderBestPatterns(r11);
        ResultPoint r17 = r11[0];
        ResultPoint r22 = r11[1];
        ResultPoint r12 = r11[2];
        if (r13.containsKey(r1) == true) goto L18;
        ResultPoint r18 = r1;
    L24:
        int r19 = transitionsBetween(r12, r18).getTransitions();
        int r20 = transitionsBetween(r17, r18).getTransitions();
        if ((r19 & 1) != 1) goto L27;
        r19 = r19 + 1;
    L27:
        int r21 = r19 + 2;
        if ((r20 & 1) != 1) goto L30;
        r20 = r20 + 1;
    L30:
        int r110 = r20 + 2;
        if ((r21 * 4) < (r110 * 7)) goto L33;
    L43:
        ResultPoint r111 = r12;
        ResultPoint r23 = correctTopRightRectangular(r22, r17, r12, r18, r21, r110);
        if (r23 == null) goto L47;
        r18 = r23;
    L47:
        int r24 = transitionsBetween(r111, r18).getTransitions();
        int r25 = transitionsBetween(r17, r18).getTransitions();
        if ((r24 & 1) != 1) goto L50;
        r24 = r24 + 1;
    L50:
        int r26 = r24;
        if ((r25 & 1) != 1) goto L53;
        r25 = r25 + 1;
    L53:
        BitMatrix r27 = sampleGrid(this.image, r111, r22, r17, r18, r26, r25);
    L55:
        return new DetectorResult(r27, new ResultPoint[]{r111, r22, r17, r18});
    L33:
        if ((r110 * 4) >= (r21 * 7)) goto L43;
        ResultPoint r28 = correctTopRight(r22, r17, r12, r18, Math.min(r110, r21));
        if (r28 == null) goto L39;
        r18 = r28;
    L39:
        int r29 = Math.max(transitionsBetween(r12, r18).getTransitions(), transitionsBetween(r17, r18).getTransitions()) + 1;
        if ((r29 & 1) != 1) goto L42;
        r29 = r29 + 1;
    L42:
        int r210 = r29;
        r27 = sampleGrid(this.image, r12, r22, r17, r18, r210, r210);
        r111 = r12;
        goto L55
    L18:
        if (r13.containsKey(r2) == true) goto L21;
        r18 = r2;
        goto L24
    L21:
        if (r13.containsKey(r3) == true) goto L23;
        r18 = r3;
        goto L24
    L23:
        r18 = r4;
    L57:
        throw NotFoundException.getNotFoundInstance();
    }

    private ResultPoint correctTopRightRectangular(ResultPoint r6, ResultPoint r7, ResultPoint r8, ResultPoint r9, int r10, int r11) {
        float r0 = distance(r6, r7) / r10;
        float r1 = distance(r8, r9);
        ResultPoint r2 = new ResultPoint(r9.getX() + (((r9.getX() - r8.getX()) / r1) * r0), r9.getY() + (r0 * ((r9.getY() - r8.getY()) / r1)));
        float r12 = distance(r6, r8) / r11;
        float r3 = distance(r7, r9);
        ResultPoint r4 = new ResultPoint(r9.getX() + (((r9.getX() - r7.getX()) / r3) * r12), r9.getY() + (r12 * ((r9.getY() - r7.getY()) / r3)));
        if (isValid(r2) == true) goto L10;
        if (isValid(r4) == false) goto L7;
        return r4;
    L7:
        return null;
    L10:
        if (isValid(r4) == true) goto L13;
        return r2;
    L13:
        if ((Math.abs(r10 - transitionsBetween(r8, r2).getTransitions()) + Math.abs(r11 - transitionsBetween(r7, r2).getTransitions())) > (Math.abs(r10 - transitionsBetween(r8, r4).getTransitions()) + Math.abs(r11 - transitionsBetween(r7, r4).getTransitions()))) goto L15;
        return r2;
    L15:
        return r4;
    }

    private ResultPoint correctTopRight(ResultPoint r6, ResultPoint r7, ResultPoint r8, ResultPoint r9, int r10) {
        float r11 = r10;
        float r0 = distance(r6, r7) / r11;
        float r1 = distance(r8, r9);
        ResultPoint r2 = new ResultPoint(r9.getX() + (((r9.getX() - r8.getX()) / r1) * r0), r9.getY() + (r0 * ((r9.getY() - r8.getY()) / r1)));
        float r12 = distance(r6, r8) / r11;
        float r13 = distance(r7, r9);
        ResultPoint r14 = new ResultPoint(r9.getX() + (((r9.getX() - r7.getX()) / r13) * r12), r9.getY() + (r12 * ((r9.getY() - r7.getY()) / r13)));
        if (isValid(r2) == true) goto L10;
        if (isValid(r14) == false) goto L7;
        return r14;
    L7:
        return null;
    L10:
        if (isValid(r14) == true) goto L13;
        return r2;
    L13:
        if (Math.abs(transitionsBetween(r8, r2).getTransitions() - transitionsBetween(r7, r2).getTransitions()) > Math.abs(transitionsBetween(r8, r14).getTransitions() - transitionsBetween(r7, r14).getTransitions())) goto L15;
        return r2;
    L15:
        return r14;
    }

    private boolean isValid(ResultPoint r4) {
        if (r4.getX() >= 0.0f) goto L5;
        return false;
    L5:
        if (r4.getX() < this.image.getWidth()) goto L7;
        return false;
    L7:
        if (r4.getY() > 0.0f) goto L9;
        return false;
    L9:
        if (r4.getY() >= this.image.getHeight()) goto L16;
        return true;
    L16:
        return false;
    }

    private static int distance(ResultPoint r0, ResultPoint r1) {
        return MathUtils.round(ResultPoint.distance(r0, r1));
    }

    private static void increment(Map<ResultPoint, Integer> r2, ResultPoint r3) {
        Integer r0 = r2.get(r3);
        int r1 = 1;
        if (r0 == null) goto L6;
        r1 = 1 + r0.intValue();
    L6:
        r2.put(r3, Integer.valueOf(r1));
    }

    private static BitMatrix sampleGrid(BitMatrix r20, ResultPoint r21, ResultPoint r22, ResultPoint r23, ResultPoint r24, int r25, int r26) throws NotFoundException {
        float r6 = r25 - 0.5f;
        float r11 = r26 - 0.5f;
        return GridSampler.getInstance().sampleGrid(r20, r25, r26, 0.5f, 0.5f, r6, 0.5f, r6, r11, 0.5f, r11, r21.getX(), r21.getY(), r24.getX(), r24.getY(), r23.getX(), r23.getY(), r22.getX(), r22.getY());
    }

    private ResultPointsAndTransitions transitionsBetween(ResultPoint r19, ResultPoint r20) {
        int r1 = (int) r19.getX();
        int r2 = (int) r19.getY();
        int r3 = (int) r20.getX();
        int r4 = (int) r20.getY();
        int r7 = 0;
        int r8 = 1;
        if (Math.abs(r4 - r2) <= Math.abs(r3 - r1)) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        r2 = r1;
        r1 = r2;
        r4 = r3;
        r3 = r4;
    L8:
        int r6 = Math.abs(r3 - r1);
        int r9 = Math.abs(r4 - r2);
        int r10 = (-r6) / 2;
        if (r2 >= r4) goto L11;
        int r12 = 1;
    L12:
        if (r1 < r3) goto L15;
        r8 = -1;
    L15:
        BitMatrix r11 = this.image;
        if (r5 == false) goto L18;
        int r13 = r2;
    L19:
        if (r5 == false) goto L21;
        int r14 = r1;
    L22:
        boolean r15 = r11.get(r13, r14);
    L23:
        if (r1 == r3) goto L40;
        BitMatrix r16 = this.image;
        if (r5 == false) goto L27;
        int r17 = r2;
    L28:
        if (r5 == false) goto L30;
        int r18 = r1;
    L31:
        boolean r110 = r16.get(r17, r18);
        if (r110 == r15) goto L34;
        r7 = r7 + 1;
        r15 = r110;
    L34:
        r10 = r10 + r9;
        if (r10 <= 0) goto L38;
        if (r2 == r4) goto L40;
        r2 = r2 + r12;
        r10 = r10 - r6;
    L38:
        r1 = r1 + r8;
        goto L23
    L30:
        r18 = r2;
        goto L31
    L27:
        r17 = r1;
    L40:
        return new ResultPointsAndTransitions(r19, r20, r7, null);
    L21:
        r14 = r2;
        goto L22
    L18:
        r13 = r1;
        goto L19
    L11:
        r12 = -1;
        goto L12
    L5:
        r5 = false;
        goto L6
    }
}
