package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.qrcode.decoder.Version;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class Detector {
    private final BitMatrix image;
    private ResultPointCallback resultPointCallback;

    public Detector(BitMatrix r1) {
        this.image = r1;
    }

    protected final BitMatrix getImage() {
        return this.image;
    }

    protected final ResultPointCallback getResultPointCallback() {
        return this.resultPointCallback;
    }

    public DetectorResult detect() throws NotFoundException, FormatException {
        return detect(null);
    }

    public final DetectorResult detect(Map<DecodeHintType, ?> r4) throws NotFoundException, FormatException {
        if (r4 != null) goto L4;
        ResultPointCallback r0 = null;
    L5:
        this.resultPointCallback = r0;
        return processFinderPatternInfo(new FinderPatternFinder(this.image, this.resultPointCallback).find(r4));
    L4:
        r0 = (ResultPointCallback) r4.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        goto L5
    }

    protected final DetectorResult processFinderPatternInfo(FinderPatternInfo r11) throws NotFoundException, FormatException {
        FinderPattern r0 = r11.getTopLeft();
        FinderPattern r1 = r11.getTopRight();
        FinderPattern r12 = r11.getBottomLeft();
        float r2 = calculateModuleSize(r0, r1, r12);
        if (r2 < 1.0f) goto L21;
        int r4 = computeDimension(r0, r1, r12, r2);
        Version r5 = Version.getProvisionalVersionForDimension(r4);
        int r6 = r5.getDimensionForVersion() - 7;
        if (r5.getAlignmentPatternCenters().length <= 0) goto L13;
        float r7 = (r1.getX() - r0.getX()) + r12.getX();
        float r8 = (r1.getY() - r0.getY()) + r12.getY();
        float r3 = 1.0f - (3.0f / r6);
        int r9 = (int) (r0.getX() + ((r7 - r0.getX()) * r3));
        int r10 = (int) (r0.getY() + (r3 * (r8 - r0.getY())));
        int r13 = 4;
    L8:
        if (r13 > 16) goto L13;
        AlignmentPattern r14 = findAlignmentInRegion(r2, r9, r10, r13);     // Catch: NotFoundException -> L12
    L14:
        BitMatrix r15 = sampleGrid(this.image, createTransform(r0, r1, r12, r14, r4), r4);
        if (r14 != null) goto L17;
        ResultPoint[] r16 = {r12, r0, r1};
    L19:
        return new DetectorResult(r15, r16);
    L17:
        r16 = new ResultPoint[]{r12, r0, r1, r14};
    L12:
        r13 = r13 << 1;
    L13:
        r14 = null;
        goto L14
    L21:
        throw NotFoundException.getNotFoundInstance();
    }

    private static PerspectiveTransform createTransform(ResultPoint r18, ResultPoint r19, ResultPoint r20, ResultPoint r21, int r22) {
        float r9 = r22 - 3.5f;
        if (r21 == null) goto L5;
        float r14 = r21.getX();
        float r15 = r21.getY();
        float r7 = r9 - 3.0f;
    L7:
        return PerspectiveTransform.quadrilateralToQuadrilateral(3.5f, 3.5f, r9, 3.5f, r7, r7, 3.5f, r9, r18.getX(), r18.getY(), r19.getX(), r19.getY(), r14, r15, r20.getX(), r20.getY());
    L5:
        r14 = (r19.getX() - r18.getX()) + r20.getX();
        r15 = (r19.getY() - r18.getY()) + r20.getY();
        r7 = r9;
        goto L7
    }

    private static BitMatrix sampleGrid(BitMatrix r1, PerspectiveTransform r2, int r3) throws NotFoundException {
        return GridSampler.getInstance().sampleGrid(r1, r3, r3, r2);
    }

    private static int computeDimension(ResultPoint r0, ResultPoint r1, ResultPoint r2, float r3) throws NotFoundException {
        int r4 = ((MathUtils.round(ResultPoint.distance(r0, r1) / r3) + MathUtils.round(ResultPoint.distance(r0, r2) / r3)) / 2) + 7;
        int r5 = r4 & 3;
        if (r5 == 0) goto L12;
        if (r5 == 2) goto L13;
        if (r5 == 3) goto L9;
        return r4;
    L9:
        throw NotFoundException.getNotFoundInstance();
    L13:
        return r4 - 1;
    L12:
        return r4 + 1;
    }

    protected final float calculateModuleSize(ResultPoint r1, ResultPoint r2, ResultPoint r3) {
        return (calculateModuleSizeOneWay(r1, r2) + calculateModuleSizeOneWay(r1, r3)) / 2.0f;
    }

    private float calculateModuleSizeOneWay(ResultPoint r5, ResultPoint r6) {
        float r0 = sizeOfBlackWhiteBlackRunBothWays((int) r5.getX(), (int) r5.getY(), (int) r6.getX(), (int) r6.getY());
        float r4 = sizeOfBlackWhiteBlackRunBothWays((int) r6.getX(), (int) r6.getY(), (int) r5.getX(), (int) r5.getY());
        if (Float.isNaN(r0) == false) goto L7;
        return r4 / 7.0f;
    L7:
        if (Float.isNaN(r4) == false) goto L11;
        return r0 / 7.0f;
    L11:
        return (r0 + r4) / 14.0f;
    }

    private float sizeOfBlackWhiteBlackRunBothWays(int r6, int r7, int r8, int r9) {
        float r0 = sizeOfBlackWhiteBlackRun(r6, r7, r8, r9);
        int r10 = r6 - (r8 - r6);
        int r1 = 0;
        if (r10 >= 0) goto L6;
        float r3 = r6 / (r6 - r10);
        r10 = 0;
    L9:
        float r4 = r7;
        int r11 = (int) (r4 - ((r9 - r7) * r3));
        if (r11 >= 0) goto L13;
        float r5 = r4 / (r7 - r11);
    L17:
        return (r0 + sizeOfBlackWhiteBlackRun(r6, r7, (int) (r6 + ((r10 - r6) * r5)), r1)) - 1.0f;
    L13:
        if (r11 < this.image.getHeight()) goto L15;
        r5 = ((this.image.getHeight() - 1) - r7) / (r11 - r7);
        r1 = this.image.getHeight() - 1;
        goto L17
    L15:
        r1 = r11;
        r5 = 1.0f;
        goto L17
    L6:
        if (r10 < this.image.getWidth()) goto L8;
        r3 = ((this.image.getWidth() - 1) - r6) / (r10 - r6);
        r10 = this.image.getWidth() - 1;
        goto L9
    L8:
        r3 = 1.0f;
        goto L9
    }

    private float sizeOfBlackWhiteBlackRun(int r18, int r19, int r20, int r21) {
        int r3 = 1;
        if (Math.abs(r21 - r19) <= Math.abs(r20 - r18)) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        int r4 = r18;
        int r1 = r19;
        int r6 = r20;
        int r5 = r21;
    L9:
        int r7 = Math.abs(r5 - r1);
        int r8 = Math.abs(r6 - r4);
        int r10 = 2;
        int r9 = (-r7) / 2;
        int r11 = -1;
        if (r1 >= r5) goto L12;
        int r12 = 1;
    L13:
        if (r4 >= r6) goto L15;
        r11 = 1;
    L15:
        int r13 = r5 + r12;
        int r14 = r1;
        int r15 = r4;
        int r16 = 0;
    L16:
        if (r14 == r13) goto L39;
        if (r0 == false) goto L19;
        int r2 = r15;
    L20:
        if (r0 == false) goto L22;
        int r17 = r14;
    L23:
        if (r16 != r3) goto L25;
        int r22 = r3;
    L27:
        if (r22 == this.image.get(r2, r17)) goto L29;
    L33:
        r9 = r9 + r8;
        if (r9 <= 0) goto L38;
        if (r15 == r6) goto L37;
        r15 = r15 + r11;
        r9 = r9 - r7;
        goto L38
    L37:
        int r23 = 2;
    L40:
        if (r16 == r23) goto L42;
        return Float.NaN;
    L42:
        return MathUtils.distance(r13, r6, r1, r4);
    L38:
        r14 = r14 + r12;
        r13 = r13;
        r0 = r0;
        r3 = 1;
        r10 = 2;
        goto L16
    L29:
        if (r16 == 2) goto L31;
        r16 = r16 + 1;
        goto L33
    L31:
        return MathUtils.distance(r14, r15, r1, r4);
    L25:
        r22 = 0;
        goto L27
    L22:
        r17 = r15;
        goto L23
    L19:
        r2 = r14;
        goto L20
    L39:
        r13 = r13;
        r23 = r10;
        goto L40
    L12:
        r12 = -1;
        goto L13
    L8:
        r1 = r18;
        r4 = r19;
        r5 = r20;
        r6 = r21;
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    protected final AlignmentPattern findAlignmentInRegion(float r11, int r12, int r13, float r14) throws NotFoundException {
        int r15 = (int) (r14 * r11);
        int r4 = Math.max(0, r12 - r15);
        int r6 = Math.min(this.image.getWidth() - 1, r12 + r15) - r4;
        float r0 = 3.0f * r11;
        if (r6 < r0) goto L11;
        int r5 = Math.max(0, r13 - r15);
        int r7 = Math.min(this.image.getHeight() - 1, r13 + r15) - r5;
        if (r7 < r0) goto L9;
        return new AlignmentPatternFinder(this.image, r4, r5, r6, r7, r11, this.resultPointCallback).find();
    L9:
        throw NotFoundException.getNotFoundInstance();
    L11:
        throw NotFoundException.getNotFoundInstance();
    }
}
