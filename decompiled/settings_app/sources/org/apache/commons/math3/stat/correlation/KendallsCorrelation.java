package org.apache.commons.math3.stat.correlation;

import java.util.Arrays;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.linear.BlockRealMatrix;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
public class KendallsCorrelation {
    private final RealMatrix correlationMatrix;

    public KendallsCorrelation() {
        this.correlationMatrix = null;
    }

    public KendallsCorrelation(double[][] r1) {
        this(MatrixUtils.createRealMatrix(r1));
    }

    public KendallsCorrelation(RealMatrix r1) {
        this.correlationMatrix = computeCorrelationMatrix(r1);
    }

    public RealMatrix getCorrelationMatrix() {
        return this.correlationMatrix;
    }

    public RealMatrix computeCorrelationMatrix(RealMatrix r8) {
        int r0 = r8.getColumnDimension();
        BlockRealMatrix r1 = new BlockRealMatrix(r0, r0);
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L8;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L7;
        double r5 = correlation(r8.getColumn(r3), r8.getColumn(r4));
        r1.setEntry(r3, r4, r5);
        r1.setEntry(r4, r3, r5);
        r4 = r4 + 1;
        goto L5
    L7:
        r1.setEntry(r3, r3, 1.0d);
        r3 = r3 + 1;
        goto L3
    L8:
        return r1;
    }

    public RealMatrix computeCorrelationMatrix(double[][] r2) {
        return computeCorrelationMatrix(new BlockRealMatrix(r2));
    }

    public double correlation(double[] r25, double[] r26) throws DimensionMismatchException {
        if (r25.length != r26.length) goto L47;
        int r2 = r25.length;
        long r3 = sum(r2 - 1);
        Pair[] r5 = new Pair[r2];
        int r6 = 0;
        int r7 = 0;
    L5:
        if (r7 >= r2) goto L7;
        r5[r7] = new Pair(Double.valueOf(r25[r7]), Double.valueOf(r26[r7]));
        r7 = r7 + 1;
        goto L5
    L7:
        Arrays.sort(r5, new AnonymousClass1(this));
        Pair r0 = r5[0];
        long r14 = 1;
        long r18 = 1;
        int r11 = 1;
        long r12 = 0;
        long r16 = 0;
    L8:
        if (r11 >= r2) goto L17;
        Pair r20 = r5[r11];
        if (((Double) r20.getFirst()).equals(r0.getFirst()) == false) goto L15;
        r14 = r14 + 1;
        if (((Double) r20.getSecond()).equals(r0.getSecond()) == false) goto L14;
        r18 = r18 + 1;
    L16:
        r11 = r11 + 1;
        r0 = r20;
        goto L8
    L14:
        r16 = r16 + sum(r18 - 1);
        r18 = 1;
        goto L16
    L15:
        r12 = r12 + sum(r14 - 1);
        r16 = r16 + sum(r18 - 1);
        r14 = 1;
        r18 = 1;
        goto L16
    L17:
        long r13 = r12 + sum(r14 - 1);
        long r17 = r16 + sum(r18 - 1);
        Pair[] r1 = new Pair[r2];
        int r4 = 1;
        long r8 = 0;
    L18:
        if (r4 >= r2) goto L37;
        int r15 = r6;
    L20:
        if (r15 >= r2) goto L36;
        int r19 = FastMath.min(r15 + r4, r2);
        int r110 = FastMath.min(r19 + r4, r2);
        int r9 = r15;
        int r21 = r9;
        int r10 = r19;
    L22:
        if (r9 < r19) goto L26;
        if (r10 < r110) goto L26;
        r15 = r15 + (r4 * 2);
    L26:
        if (r9 >= r19) goto L34;
        if (r10 >= r110) goto L32;
        int r22 = r15;
        if (((Double) r5[r9].getSecond()).compareTo((Double) r5[r10].getSecond()) > 0) goto L31;
        r1[r21] = r5[r9];
    L33:
        r9 = r9 + 1;
    L35:
        r21 = r21 + 1;
        r15 = r22;
        goto L22
    L31:
        r1[r21] = r5[r10];
        r8 = r8 + ((long) (r19 - r9));
        r10 = r10 + 1;
        goto L35
    L32:
        r22 = r15;
        r1[r21] = r5[r9];
        goto L33
    L34:
        r22 = r15;
        r1[r21] = r5[r10];
        r10 = r10 + 1;
        goto L35
    L36:
        r4 = r4 << 1;
        r6 = 0;
        Pair[] r23 = r5;
        r5 = r1;
        r1 = r23;
        goto L18
    L37:
        Pair r24 = r5[r6];
        int r27 = 1;
        long r28 = 0;
        long r111 = 1;
    L38:
        if (r27 >= r2) goto L44;
        Pair r29 = r5[r27];
        if (((Double) r29.getSecond()).equals(r24.getSecond()) == false) goto L42;
        r111 = r111 + 1;
    L43:
        r27 = r27 + 1;
        r24 = r29;
        goto L38
    L42:
        r28 = r28 + sum(r111 - 1);
        r111 = 1;
        goto L43
    L44:
        long r30 = r28 + sum(r111 - 1);
        long r31 = r3 - r13;
        return (((r31 - r30) + r17) - (r8 * 2)) / FastMath.sqrt(r31 * (r3 - r30));
    L47:
        throw new DimensionMismatchException(r25.length, r26.length);
    }

    private static long sum(long r2) {
        return (r2 * (1 + r2)) / 2;
    }
}
