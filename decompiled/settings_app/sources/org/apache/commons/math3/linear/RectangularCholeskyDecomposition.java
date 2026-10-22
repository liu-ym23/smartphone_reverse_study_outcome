package org.apache.commons.math3.linear;

import java.lang.reflect.Array;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class RectangularCholeskyDecomposition {
    private int rank;
    private final RealMatrix root;

    public RectangularCholeskyDecomposition(RealMatrix r3) throws NonPositiveDefiniteMatrixException {
        this(r3, 0.0d);
    }

    public RectangularCholeskyDecomposition(RealMatrix r27, double r28) throws NonPositiveDefiniteMatrixException {
        int r1 = r27.getRowDimension();
        double[][] r2 = r27.getData();
        boolean r7 = false;
        double[][] r3 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r1, r1});
        int[] r8 = new int[r1];
        int r9 = 0;
    L3:
        if (r9 >= r1) goto L5;
        r8[r9] = r9;
        r9 = r9 + 1;
        goto L3
    L5:
        boolean r10 = true;
        int r11 = 0;
    L6:
        if (r10 == false) goto L39;
        int r12 = r11 + 1;
        int r13 = r12;
        int r14 = r11;
    L8:
        if (r13 >= r1) goto L13;
        int r15 = r8[r13];
        int r16 = r8[r14];
        if (r2[r15][r15] <= r2[r16][r16]) goto L12;
        r14 = r13;
    L12:
        r13 = r13 + 1;
        goto L8
    L13:
        if (r14 == r11) goto L15;
        int r17 = r8[r11];
        r8[r11] = r8[r14];
        r8[r14] = r17;
        double[] r18 = r3[r11];
        r3[r11] = r3[r14];
        r3[r14] = r18;
    L15:
        int r19 = r8[r11];
        double r110 = r2[r19][r19];
        if (r110 > r28) goto L28;
        if (r11 == 0) goto L27;
        int r20 = r11;
    L19:
        if (r20 >= r1) goto L25;
        int r111 = r8[r20];
        if (r2[r111][r111] < (-r28)) goto L23;
        r20 = r20 + 1;
        goto L19
    L23:
        int r0 = r8[r20];
        throw new NonPositiveDefiniteMatrixException(r2[r0][r0], r20, r28);
    L25:
        r10 = r7;
    L38:
        r7 = false;
        goto L6
    L27:
        throw new NonPositiveDefiniteMatrixException(r2[r19][r19], r19, r28);
    L28:
        double r112 = FastMath.sqrt(r110);
        r3[r11][r11] = r112;
        double r113 = 1.0d / r112;
        double r114 = 1.0d / r2[r19][r19];
        int r6 = r12;
    L29:
        if (r6 >= r1) goto L34;
        int r115 = r8[r6];
        double[] r116 = r2[r115];
        double r117 = r116[r19] * r113;
        r3[r6][r11] = r117;
        double r21 = r116[r115];
        double r22 = r116[r19];
        r116[r115] = r21 - ((r22 * r22) * r114);
        int r23 = r12;
    L31:
        if (r23 >= r6) goto L33;
        int r24 = r8[r23];
        double[] r25 = r2[r115];
        double r26 = r25[r24] - (r3[r23][r11] * r117);
        r25[r24] = r26;
        r2[r24][r115] = r26;
        r23 = r23 + 1;
        goto L31
    L33:
        r6 = r6 + 1;
        goto L29
    L34:
        if (r12 >= r1) goto L36;
        boolean r29 = true;
    L37:
        r11 = r12;
        r10 = r29;
        goto L38
    L36:
        r29 = false;
        goto L37
    L39:
        this.rank = r11;
        this.root = MatrixUtils.createRealMatrix(r1, r11);
        int r4 = 0;
    L40:
        if (r4 >= r1) goto L45;
        int r5 = 0;
    L42:
        if (r5 >= r11) goto L44;
        this.root.setEntry(r8[r4], r5, r3[r4][r5]);
        r5 = r5 + 1;
        goto L42
    L44:
        r4 = r4 + 1;
        goto L40
    }

    public RealMatrix getRootMatrix() {
        return this.root;
    }

    public int getRank() {
        return this.rank;
    }
}
