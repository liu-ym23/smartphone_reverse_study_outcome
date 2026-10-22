package org.apache.commons.math3.linear;

import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
class SchurTransformer {
    private static final int MAX_ITERATIONS = 100;
    private RealMatrix cachedP;
    private RealMatrix cachedPt;
    private RealMatrix cachedT;
    private final double epsilon;
    private final double[][] matrixP;
    private final double[][] matrixT;

    /* JADX INFO: renamed from: org.apache.commons.math3.linear.SchurTransformer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class ShiftInfo {
        double exShift;
        double w;
        double x;
        double y;

        private ShiftInfo() {
        }

        /* synthetic */ ShiftInfo(AnonymousClass1 r1) {
            this();
        }
    }

    SchurTransformer(RealMatrix r3) {
        this.epsilon = Precision.EPSILON;
        if (r3.isSquare() == false) goto L7;
        HessenbergTransformer r0 = new HessenbergTransformer(r3);
        this.matrixT = r0.getH().getData();
        this.matrixP = r0.getP().getData();
        this.cachedT = null;
        this.cachedP = null;
        this.cachedPt = null;
        transform();
        return;
    L7:
        throw new NonSquareMatrixException(r3.getRowDimension(), r3.getColumnDimension());
    }

    public RealMatrix getP() {
        if (this.cachedP != null) goto L6;
        this.cachedP = MatrixUtils.createRealMatrix(this.matrixP);
    L6:
        return this.cachedP;
    }

    public RealMatrix getPT() {
        if (this.cachedPt != null) goto L6;
        this.cachedPt = getP().transpose();
    L6:
        return this.cachedPt;
    }

    public RealMatrix getT() {
        if (this.cachedT != null) goto L6;
        this.cachedT = MatrixUtils.createRealMatrix(this.matrixT);
    L6:
        return this.cachedT;
    }

    private void transform() {
        int r7 = this.matrixT.length;
        double r8 = getNorm();
        ShiftInfo r10 = new ShiftInfo(null);
        int r11 = r7 - 1;
        int r13 = r11;
        int r0 = 0;
    L3:
        if (r13 < 0) goto L32;
        int r1 = findSmallSubDiagonalElement(r13, r8);
        if (r1 != r13) goto L8;
        double[] r2 = this.matrixT[r13];
        r2[r13] = r2[r13] + r10.exShift;
        r13 = r13 - 1;
    L7:
        r0 = 0;
    L29:
        r8 = r8;
        goto L3
    L8:
        int r3 = r13 - 1;
        if (r1 != r3) goto L26;
        double[][] r4 = this.matrixT;
        double[] r5 = r4[r3];
        double r6 = r5[r3];
        double[] r9 = r4[r13];
        double r14 = r9[r13];
        double r12 = (r6 - r14) / 2.0d;
        double r16 = (r12 * r12) + (r9[r3] * r5[r13]);
        r9[r13] = r14 + r10.exShift;
        double[] r15 = this.matrixT[r3];
        r15[r3] = r15[r3] + r10.exShift;
        if (r16 < 0.0d) goto L25;
        double r17 = FastMath.sqrt(FastMath.abs(r16));
        if (r12 < 0.0d) goto L15;
        double r18 = r12 + r17;
    L16:
        double r19 = this.matrixT[r13][r3];
        double r20 = FastMath.abs(r19) + FastMath.abs(r18);
        double r21 = r19 / r20;
        double r22 = r18 / r20;
        double r23 = FastMath.sqrt((r21 * r21) + (r22 * r22));
        double r24 = r21 / r23;
        double r25 = r22 / r23;
        int r26 = r3;
    L17:
        if (r26 >= r7) goto L19;
        double[][] r27 = this.matrixT;
        double[] r28 = r27[r3];
        double r110 = r28[r26];
        double[] r29 = r27[r13];
        r28[r26] = (r25 * r110) + (r29[r26] * r24);
        r29[r26] = (r29[r26] * r25) - (r110 * r24);
        r26 = r26 + 1;
        goto L17
    L19:
        int r30 = 0;
    L20:
        if (r30 > r13) goto L22;
        double[] r31 = this.matrixT[r30];
        double r111 = r31[r3];
        r31[r3] = (r25 * r111) + (r31[r13] * r24);
        r31[r13] = (r31[r13] * r25) - (r111 * r24);
        r30 = r30 + 1;
        goto L20
    L22:
        int r32 = 0;
    L23:
        if (r32 > r11) goto L25;
        double[] r33 = this.matrixP[r32];
        double r112 = r33[r3];
        r33[r3] = (r25 * r112) + (r33[r13] * r24);
        r33[r13] = (r33[r13] * r25) - (r112 * r24);
        r32 = r32 + 1;
        goto L23
    L15:
        r18 = r12 - r17;
    L25:
        r13 = r13 - 2;
        goto L7
    L26:
        r8 = r8;
        computeShift(r1, r13, r0, r10);
        int r34 = r0 + 1;
        if (r34 > 100) goto L31;
        double[] r35 = new double[3];
        performDoubleQRStep(r1, initQRStep(r1, r13, r10, r35), r13, r10, r35);
        r0 = r34;
        goto L29
    L31:
        throw new MaxCountExceededException(LocalizedFormats.CONVERGENCE_FAILED, 100, new Object[0]);
    }

    private double getNorm() {
        double r0 = 0.0d;
        int r3 = 0;
    L4:
        if (r3 >= this.matrixT.length) goto L10;
        int r4 = FastMath.max(r3 - 1, 0);
    L6:
        double[][] r5 = this.matrixT;
        if (r4 >= r5.length) goto L9;
        r0 = r0 + FastMath.abs(r5[r3][r4]);
        r4 = r4 + 1;
        goto L6
    L9:
        r3 = r3 + 1;
        goto L4
    L10:
        return r0;
    }

    private int findSmallSubDiagonalElement(int r7, double r8) {
    L2:
        if (r7 <= 0) goto L10;
        int r1 = r7 - 1;
        double r2 = FastMath.abs(this.matrixT[r1][r1]) + FastMath.abs(this.matrixT[r7][r7]);
        if (r2 != 0.0d) goto L7;
        r2 = r8;
    L7:
        if (FastMath.abs(this.matrixT[r7][r1]) < (this.epsilon * r2)) goto L10;
        r7 = r7 - 1;
    L10:
        return r7;
    }

    private void computeShift(int r19, int r20, int r21, ShiftInfo r22) {
        r22.x = this.matrixT[r20][r20];
        r22.w = 0.0d;
        r22.y = 0.0d;
        if (r19 >= r20) goto L6;
        int r7 = r20 - 1;
        r22.y = this.matrixT[r7][r7];
        double[][] r6 = this.matrixT;
        r22.w = r6[r20][r7] * r6[r7][r20];
    L6:
        if (r21 != 10) goto L12;
        r22.exShift += r22.x;
        int r8 = 0;
    L8:
        if (r8 > r20) goto L10;
        double[] r9 = this.matrixT[r8];
        r9[r8] = r9[r8] - r22.x;
        r8 = r8 + 1;
        goto L8
    L10:
        int r10 = r20 - 1;
        double r11 = FastMath.abs(this.matrixT[r20][r10]) + FastMath.abs(this.matrixT[r10][r20 - 2]);
        double r12 = 0.75d * r11;
        r22.x = r12;
        r22.y = r12;
        r22.w = ((-0.4375d) * r11) * r11;
    L12:
        if (r21 != 30) goto L25;
        double r13 = (r22.y - r22.x) / 2.0d;
        double r14 = (r13 * r13) + r22.w;
        if (r14 <= 0.0d) goto L26;
        double r4 = FastMath.sqrt(r14);
        if (r22.y >= r22.x) goto L18;
        r4 = -r4;
    L18:
        double r15 = r22.x - (r22.w / (((r22.y - r22.x) / 2.0d) + r4));
        int r16 = 0;
    L19:
        if (r16 > r20) goto L21;
        double[] r2 = this.matrixT[r16];
        r2[r16] = r2[r16] - r15;
        r16 = r16 + 1;
        goto L19
    L21:
        r22.exShift += r15;
        r22.w = 0.964d;
        r22.y = 0.964d;
        r22.x = 0.964d;
        return;
    L26:
        return;
    }

    private int initQRStep(int r20, int r21, ShiftInfo r22, double[] r23) {
        int r4 = r21 - 2;
    L3:
        if (r4 < r20) goto L11;
        double r5 = this.matrixT[r4][r4];
        double r7 = r22.x - r5;
        double r9 = r22.y - r5;
        double r11 = (r7 * r9) - r22.w;
        double[][] r13 = this.matrixT;
        int r14 = r4 + 1;
        double[] r15 = r13[r14];
        double r12 = r11 / r15[r4];
        double[] r16 = r13[r4];
        r23[0] = r12 + r16[r14];
        r23[1] = ((r15[r14] - r5) - r7) - r9;
        r23[2] = r13[r4 + 2][r14];
        if (r4 == r20) goto L11;
        int r8 = r4 - 1;
        if ((FastMath.abs(r16[r8]) * (FastMath.abs(r23[1]) + FastMath.abs(r23[2]))) < (this.epsilon * (FastMath.abs(r23[0]) * ((FastMath.abs(this.matrixT[r8][r8]) + FastMath.abs(r5)) + FastMath.abs(this.matrixT[r14][r14]))))) goto L11;
        r4 = r4 - 1;
    L11:
        return r4;
    }

    private void performDoubleQRStep(int r29, int r30, int r31, ShiftInfo r32, double[] r33) {
        int r4 = this.matrixT.length;
        boolean r5 = false;
        double r6 = r33[0];
        boolean r8 = true;
        double r9 = r33[1];
        int r11 = 2;
        double r12 = r33[2];
        int r14 = r30;
    L3:
        int r15 = r31 - 1;
        if (r14 > r15) goto L49;
        if (r14 == r15) goto L7;
        boolean r16 = r8;
    L8:
        if (r14 == r30) goto L17;
        double[][] r7 = this.matrixT;
        int r10 = r14 - 1;
        double r13 = r7[r14][r10];
        double r18 = r7[r14 + 1][r10];
        if (r16 == false) goto L12;
        double r17 = r7[r14 + 2][r10];
    L13:
        r32.x = (FastMath.abs(r13) + FastMath.abs(r18)) + FastMath.abs(r17);
        double r26 = r17;
        if (Precision.equals(r32.x, 0.0d, this.epsilon) == false) goto L16;
        boolean r19 = r8;
        r6 = r13;
        r9 = r18;
        r12 = r26;
        int r27 = r4;
    L48:
        r14 = r14 + 1;
        r8 = r19;
        r4 = r27;
        r5 = false;
        r11 = 2;
        goto L3
    L16:
        r6 = r13 / r32.x;
        r9 = r18 / r32.x;
        r12 = r26 / r32.x;
        goto L17
    L12:
        r17 = 0.0d;
    L17:
        double r20 = r12;
        double r110 = FastMath.sqrt(((r6 * r6) + (r9 * r9)) + (r12 * r12));
        if (r6 >= 0.0d) goto L21;
        r110 = -r110;
    L21:
        if (r110 == 0.0d) goto L47;
        if (r14 == r30) goto L24;
        double r22 = r9;
        double r24 = r6;
        this.matrixT[r14][r14 - 1] = (-r110) * r32.x;
    L27:
        r6 = r24 + r110;
        r32.x = r6 / r110;
        r32.y = r22 / r110;
        double r111 = r20 / r110;
        double r21 = r22 / r6;
        double r112 = r20 / r6;
        int r23 = r14;
    L28:
        if (r23 >= r4) goto L33;
        double[][] r25 = this.matrixT;
        double[] r28 = r25[r14];
        int r113 = r14 + 1;
        double r114 = r28[r23] + (r25[r113][r23] * r21);
        if (r16 == false) goto L32;
        double[] r34 = r25[r14 + 2];
        double r210 = r34[r23];
        r114 = r114 + (r112 * r210);
        r34[r23] = r210 - (r114 * r111);
    L32:
        int r211 = r4;
        r28[r23] = r28[r23] - (r32.x * r114);
        double[] r35 = this.matrixT[r113];
        r35[r23] = r35[r23] - (r32.y * r114);
        r23 = r23 + 1;
        r6 = r114;
        r21 = r21;
        r4 = r211;
        goto L28
    L33:
        r27 = r4;
        double r212 = r21;
        int r36 = 0;
    L35:
        if (r36 > FastMath.min(r31, r14 + 3)) goto L40;
        double r37 = r32.x * this.matrixT[r36][r14];
        double r38 = r32.y;
        double[] r39 = this.matrixT[r36];
        int r115 = r14 + 1;
        double r40 = r37 + (r38 * r39[r115]);
        if (r16 == false) goto L39;
        int r41 = r14 + 2;
        double r116 = r39[r41];
        r40 = r40 + (r111 * r116);
        r39[r41] = r116 - (r40 * r112);
    L39:
        r6 = r40;
        r39[r14] = r39[r14] - r6;
        r39[r115] = r39[r115] - (r6 * r212);
        r36 = r36 + 1;
        goto L35
    L40:
        r19 = true;
        int r42 = this.matrixT.length - 1;
        int r43 = 0;
    L41:
        if (r43 > r42) goto L46;
        double r44 = r32.x * this.matrixP[r43][r14];
        double r45 = r32.y;
        double[] r117 = this.matrixP[r43];
        int r118 = r14 + 1;
        r6 = r44 + (r45 * r117[r118]);
        if (r16 == false) goto L45;
        int r46 = r14 + 2;
        double r119 = r117[r46];
        r6 = r6 + (r111 * r119);
        r117[r46] = r119 - (r6 * r112);
    L45:
        r117[r14] = r117[r14] - r6;
        r117[r118] = r117[r118] - (r6 * r212);
        r43 = r43 + 1;
        goto L41
    L46:
        r12 = r112;
        r9 = r212;
        goto L48
    L24:
        r24 = r6;
        r22 = r9;
        if (r29 == r30) goto L27;
        double[] r47 = this.matrixT[r14];
        int r48 = r14 - 1;
        r47[r48] = -r47[r48];
        goto L27
    L47:
        r27 = r4;
        r19 = r8;
        r12 = r20;
        goto L48
    L7:
        r16 = r5;
        goto L8
    L49:
        int r1 = r30 + r11;
        int r3 = r1;
    L50:
        if (r3 > r31) goto L55;
        double[] r49 = this.matrixT[r3];
        r49[r3 - 2] = 0.0d;
        if (r3 <= r1) goto L54;
        r49[r3 - 3] = 0.0d;
    L54:
        r3 = r3 + 1;
        goto L50
    }
}
