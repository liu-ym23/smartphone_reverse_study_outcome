package org.apache.commons.math3.ode.nonstiff;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.math3.fraction.BigFraction;
import org.apache.commons.math3.linear.Array2DRowFieldMatrix;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayFieldVector;
import org.apache.commons.math3.linear.FieldDecompositionSolver;
import org.apache.commons.math3.linear.FieldLUDecomposition;
import org.apache.commons.math3.linear.FieldMatrix;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;

/* JADX INFO: loaded from: classes6.dex */
public class AdamsNordsieckTransformer {
    private static final Map<Integer, AdamsNordsieckTransformer> CACHE = null;
    private final double[] c1;
    private final Array2DRowRealMatrix update;

    static {
        CACHE = new HashMap();
    }

    private AdamsNordsieckTransformer(int r8) {
        int r9 = r8 - 1;
        FieldMatrix<BigFraction> r0 = buildP(r9);
        FieldDecompositionSolver r1 = new FieldLUDecomposition(r0).getSolver();
        BigFraction[] r2 = new BigFraction[r9];
        Arrays.fill(r2, BigFraction.ONE);
        int r4 = 0;
        BigFraction[] r3 = (BigFraction[]) r1.solve(new ArrayFieldVector(r2, false)).toArray();
        BigFraction[][] r5 = (BigFraction[][]) r0.getData();
        int r6 = r5.length - 1;
    L3:
        if (r6 <= 0) goto L5;
        r5[r6] = r5[r6 - 1];
        r6 = r6 - 1;
        goto L3
    L5:
        BigFraction[] r7 = new BigFraction[r9];
        r5[0] = r7;
        Arrays.fill(r7, BigFraction.ZERO);
        this.update = MatrixUtils.bigFractionMatrixToRealMatrix(r1.solve(new Array2DRowFieldMatrix(r5, false)));
        this.c1 = new double[r9];
    L6:
        if (r4 >= r9) goto L8;
        this.c1[r4] = r3[r4].doubleValue();
        r4 = r4 + 1;
        goto L6
    }

    public static AdamsNordsieckTransformer getInstance(int r2) {
        Map<Integer, AdamsNordsieckTransformer> r0 = CACHE;
        monitor-enter(r0);
        AdamsNordsieckTransformer r1 = r0.get(Integer.valueOf(r2));     // Catch: Throwable -> L9
        if (r1 != null) goto L7;
        r1 = new AdamsNordsieckTransformer(r2);     // Catch: Throwable -> L9
        r0.put(Integer.valueOf(r2), r1);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public int getNSteps() {
        return this.c1.length;
    }

    private FieldMatrix<BigFraction> buildP(int r10) {
        BigFraction[][] r9 = (BigFraction[][]) Array.newInstance(BigFraction.class, new int[]{r10, r10});
        int r11 = 1;
    L4:
        if (r11 > r9.length) goto L11;
        BigFraction[] r2 = r9[r11 - 1];
        int r3 = -r11;
        int r4 = 1;
        int r5 = r3;
    L7:
        if (r4 > r2.length) goto L9;
        int r6 = r4 - 1;
        r4 = r4 + 1;
        r2[r6] = new BigFraction(r5 * r4);
        r5 = r5 * r3;
        goto L7
    L9:
        r11 = r11 + 1;
        goto L4
    L11:
        return new Array2DRowFieldMatrix(r9, false);
    }

    public Array2DRowRealMatrix initializeHighOrderDerivatives(double r21, double[] r23, double[][] r24, double[][] r25) {
        double[] r2 = this.c1;
        int r4 = 1;
        int[] r6 = {r2.length + 1, r2.length + 1};
        char r3 = 0;
        double[][] r5 = (double[][]) Array.newInstance(Double.TYPE, r6);
        double[][] r0 = (double[][]) Array.newInstance(Double.TYPE, new int[]{this.c1.length + 1, r24[0].length});
        double[] r7 = r24[0];
        double[] r8 = r25[0];
        int r9 = 1;
    L4:
        if (r9 >= r24.length) goto L28;
        double r10 = r23[r9] - r23[r3];
        double r11 = r10 / r21;
        double r12 = 1.0d / r21;
        int r14 = r9 * 2;
        int r15 = r14 - 2;
        double[] r13 = r5[r15];
        int r16 = r14 - r4;
        double[] r17 = null;
        if (r16 >= r5.length) goto L8;
        double[] r18 = r5[r16];
    L9:
        double[][] r19 = r5;
        double[] r20 = r8;
        int r22 = 0;
    L11:
        if (r22 >= r13.length) goto L17;
        r12 = r12 * r11;
        r13[r22] = r10 * r12;
        if (r18 == null) goto L16;
        r18[r22] = ((double) (r22 + 2)) * r12;
    L16:
        r22 = r22 + 1;
        r11 = r11;
        goto L11
    L17:
        double[] r26 = r24[r9];
        double[] r27 = r25[r9];
        double[] r28 = r0[r15];
        if (r16 >= r0.length) goto L20;
        r17 = r0[r16];
    L20:
        int r29 = 0;
    L22:
        if (r29 >= r26.length) goto L27;
        r28[r29] = (r26[r29] - r7[r29]) - (r20[r29] * r10);
        if (r17 == null) goto L26;
        r17[r29] = r27[r29] - r20[r29];
    L26:
        r29 = r29 + 1;
        goto L22
    L27:
        r9 = r9 + 1;
        r8 = r20;
        r5 = r19;
        r3 = 0;
        r4 = 1;
        goto L4
    L8:
        r18 = null;
        goto L9
    L28:
        RealMatrix r1 = new QRDecomposition(new Array2DRowRealMatrix(r5, false)).getSolver().solve(new Array2DRowRealMatrix(r0, false));
        Array2DRowRealMatrix r30 = new Array2DRowRealMatrix(r1.getRowDimension() - 1, r1.getColumnDimension());
        int r31 = 0;
    L30:
        if (r31 >= r30.getRowDimension()) goto L36;
        int r32 = 0;
    L33:
        if (r32 >= r30.getColumnDimension()) goto L35;
        r30.setEntry(r31, r32, r1.getEntry(r31, r32));
        r32 = r32 + 1;
        goto L33
    L35:
        r31 = r31 + 1;
        goto L30
    L36:
        return r30;
    }

    public Array2DRowRealMatrix updateHighOrderDerivativesPhase1(Array2DRowRealMatrix r1) {
        return this.update.multiply(r1);
    }

    public void updateHighOrderDerivativesPhase2(double[] r13, double[] r14, Array2DRowRealMatrix r15) {
        double[][] r16 = r15.getDataRef();
        int r1 = 0;
    L4:
        if (r1 >= r16.length) goto L10;
        double[] r2 = r16[r1];
        double r3 = this.c1[r1];
        int r5 = 0;
    L7:
        if (r5 >= r2.length) goto L9;
        r2[r5] = r2[r5] + ((r13[r5] - r14[r5]) * r3);
        r5 = r5 + 1;
        goto L7
    L9:
        r1 = r1 + 1;
        goto L4
    }
}
