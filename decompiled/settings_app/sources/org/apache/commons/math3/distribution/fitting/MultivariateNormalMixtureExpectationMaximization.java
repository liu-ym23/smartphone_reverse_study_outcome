package org.apache.commons.math3.distribution.fitting;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.math3.distribution.MixtureMultivariateNormalDistribution;
import org.apache.commons.math3.distribution.MultivariateNormalDistribution;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.SingularMatrixException;
import org.apache.commons.math3.stat.correlation.Covariance;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
public class MultivariateNormalMixtureExpectationMaximization {
    private static final int DEFAULT_MAX_ITERATIONS = 1000;
    private static final double DEFAULT_THRESHOLD = 1.0E-5d;
    private final double[][] data;
    private MixtureMultivariateNormalDistribution fittedModel;
    private double logLikelihood;

    private static class DataRow implements Comparable<DataRow> {
        private Double mean;
        private final double[] row;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(DataRow r1) {
            return compareTo2(r1);
        }

        DataRow(double[] r6) {
            this.row = r6;
            this.mean = Double.valueOf(0.0d);
            int r0 = 0;
        L4:
            if (r0 >= r6.length) goto L6;
            this.mean = Double.valueOf(this.mean.doubleValue() + r6[r0]);
            r0 = r0 + 1;
            goto L4
        L6:
            this.mean = Double.valueOf(this.mean.doubleValue() / ((double) r6.length));
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(DataRow r1) {
            return this.mean.compareTo(r1.mean);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L6;
            return true;
        L6:
            if ((r2 instanceof DataRow) == true) goto L8;
            return false;
        L8:
            return MathArrays.equals(this.row, ((DataRow) r2).row);
        }

        public int hashCode() {
            return Arrays.hashCode(this.row);
        }

        public double[] getRow() {
            return this.row;
        }
    }

    public MultivariateNormalMixtureExpectationMaximization(double[][] r8) throws NotStrictlyPositiveException, DimensionMismatchException, NumberIsTooSmallException {
        this.logLikelihood = 0.0d;
        if (r8.length < 1) goto L18;
        this.data = (double[][]) Array.newInstance(Double.TYPE, new int[]{r8.length, r8[0].length});
        int r0 = 0;
    L6:
        if (r0 >= r8.length) goto L16;
        double[] r3 = r8[r0];
        if (r3.length != r8[0].length) goto L15;
        if (r3.length < 2) goto L13;
        this.data[r0] = MathArrays.copyOf(r3, r3.length);
        r0 = r0 + 1;
        goto L6
    L13:
        throw new NumberIsTooSmallException(LocalizedFormats.NUMBER_TOO_SMALL, Integer.valueOf(r8[r0].length), 2, true);
    L15:
        throw new DimensionMismatchException(r8[r0].length, r8[0].length);
    L16:
        return;
    L18:
        throw new NotStrictlyPositiveException(Integer.valueOf(r8.length));
    }

    public void fit(MixtureMultivariateNormalDistribution r31, int r32, double r33) throws SingularMatrixException, NotStrictlyPositiveException, DimensionMismatchException {
        int r1 = r32;
        char r2 = 1;
        if (r1 < 1) goto L54;
        if (r33 < Double.MIN_VALUE) goto L52;
        double[][] r3 = this.data;
        int r4 = r3.length;
        int r5 = 0;
        int r6 = r3[0].length;
        int r7 = r31.getComponents().size();
        int r8 = r31.getComponents().get(0).getSecond().getMeans().length;
        if (r8 != r6) goto L50;
        this.logLikelihood = Double.NEGATIVE_INFINITY;
        this.fittedModel = new MixtureMultivariateNormalDistribution(r31.getComponents());
        int r9 = 0;
        double r10 = 0.0d;
    L9:
        int r12 = r9 + 1;
        if (r9 > r1) goto L45;
        if (FastMath.abs(r10 - this.logLikelihood) <= r33) goto L45;
        double r11 = this.logLikelihood;
        List<Pair<Double, MultivariateNormalDistribution>> r13 = this.fittedModel.getComponents();
        double[] r14 = new double[r7];
        MultivariateNormalDistribution[] r15 = new MultivariateNormalDistribution[r7];
        int r16 = r5;
    L14:
        if (r16 >= r7) goto L16;
        r14[r16] = r13.get(r16).getFirst().doubleValue();
        r15[r16] = r13.get(r16).getSecond();
        r16 = r16 + 1;
        goto L14
    L16:
        int[] r17 = new int[2];
        r17[r2] = r7;
        r17[r5] = r4;
        double[][] r18 = (double[][]) Array.newInstance(Double.TYPE, r17);
        double[] r19 = new double[r7];
        int[] r110 = new int[2];
        r110[r2] = r6;
        r110[r5] = r7;
        double[][] r20 = (double[][]) Array.newInstance(Double.TYPE, r110);
        int r111 = 0;
        double r112 = 0.0d;
    L17:
        if (r111 >= r4) goto L25;
        double r21 = this.fittedModel.density(this.data[r111]);
        r112 = r112 + FastMath.log(r21);
        int r22 = 0;
    L19:
        if (r22 >= r7) goto L24;
        double r25 = r11;
        r18[r111][r22] = (r14[r22] * r15[r22].density(this.data[r111])) / r21;
        r19[r22] = r19[r22] + r18[r111][r22];
        int r23 = 0;
    L21:
        if (r23 >= r6) goto L23;
        double[] r24 = r20[r22];
        r24[r23] = r24[r23] + (r18[r111][r22] * this.data[r111][r23]);
        r23 = r23 + 1;
        r12 = r12;
        goto L21
    L23:
        r22 = r22 + 1;
        r11 = r25;
        goto L19
    L24:
        r111 = r111 + 1;
        goto L17
    L25:
        double r26 = r11;
        int r27 = r12;
        double r28 = r4;
        this.logLikelihood = r112 / r28;
        double[] r29 = new double[r7];
        double[][] r113 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r7, r6});
        int r114 = 0;
    L26:
        if (r114 >= r7) goto L31;
        r29[r114] = r19[r114] / r28;
        int r115 = 0;
    L28:
        if (r115 >= r6) goto L30;
        r113[r114][r115] = r20[r114][r115] / r19[r114];
        r115 = r115 + 1;
        goto L28
    L30:
        r114 = r114 + 1;
        goto L26
    L31:
        RealMatrix[] r30 = new RealMatrix[r7];
        int r34 = 0;
    L32:
        if (r34 >= r7) goto L34;
        r30[r34] = new Array2DRowRealMatrix(r6, r6);
        r34 = r34 + 1;
        goto L32
    L34:
        int r35 = 0;
    L35:
        if (r35 >= r4) goto L40;
        int r36 = 0;
    L37:
        if (r36 >= r7) goto L39;
        Array2DRowRealMatrix r116 = new Array2DRowRealMatrix(MathArrays.ebeSubtract(this.data[r35], r113[r36]));
        r30[r36] = r30[r36].add(r116.multiply(r116.transpose()).scalarMultiply(r18[r35][r36]));
        r36 = r36 + 1;
        goto L37
    L39:
        r35 = r35 + 1;
        goto L35
    L40:
        double[][][] r37 = (double[][][]) Array.newInstance(Double.TYPE, new int[]{r7, r6, r6});
        int r117 = 0;
    L41:
        if (r117 >= r7) goto L43;
        RealMatrix r118 = r30[r117].scalarMultiply(1.0d / r19[r117]);
        r30[r117] = r118;
        r37[r117] = r118.getData();
        r117 = r117 + 1;
        goto L41
    L43:
        this.fittedModel = new MixtureMultivariateNormalDistribution(r29, r113, r37);
        r1 = r32;
        r2 = 1;
        r5 = 0;
        r10 = r26;
        r9 = r27;
    L45:
        if (FastMath.abs(r10 - this.logLikelihood) > r33) goto L48;
        return;
    L48:
        throw new ConvergenceException();
    L50:
        throw new DimensionMismatchException(r8, r6);
    L52:
        throw new NotStrictlyPositiveException(Double.valueOf(r33));
    L54:
        throw new NotStrictlyPositiveException(Integer.valueOf(r32));
    }

    public void fit(MixtureMultivariateNormalDistribution r4) throws SingularMatrixException, NotStrictlyPositiveException {
        fit(r4, 1000, 1.0E-5d);
    }

    public static MixtureMultivariateNormalDistribution estimate(double[][] r22, int r23) throws NotStrictlyPositiveException, DimensionMismatchException {
        if (r22.length < 2) goto L26;
        if (r23 < 2) goto L24;
        if (r23 > r22.length) goto L22;
        int r4 = r22.length;
        int r5 = 0;
        int r6 = r22[0].length;
        DataRow[] r7 = new DataRow[r4];
        int r8 = 0;
    L9:
        if (r8 >= r4) goto L11;
        r7[r8] = new DataRow(r22[r8]);
        r8 = r8 + 1;
        goto L9
    L11:
        Arrays.sort(r7);
        double r9 = 1.0d / ((double) r23);
        ArrayList r0 = new ArrayList(r23);
        int r12 = 0;
    L12:
        if (r12 >= r23) goto L20;
        int r13 = (r12 * r4) / r23;
        r12 = r12 + 1;
        int r14 = (r12 * r4) / r23;
        int r15 = r14 - r13;
        int[] r10 = new int[2];
        r10[1] = r6;
        r10[r5] = r15;
        double[][] r11 = (double[][]) Array.newInstance(Double.TYPE, r10);
        double[] r16 = new double[r6];
        int r17 = r5;
    L14:
        if (r13 >= r14) goto L18;
    L15:
        if (r5 >= r6) goto L17;
        double r18 = r7[r13].getRow()[r5];
        r16[r5] = r16[r5] + r18;
        r11[r17][r5] = r18;
        r5 = r5 + 1;
        goto L15
    L17:
        r13 = r13 + 1;
        r17 = r17 + 1;
        r5 = 0;
        goto L14
    L18:
        MathArrays.scaleInPlace(1.0d / ((double) r15), r16);
        r0.add(new Pair(Double.valueOf(r9), new MultivariateNormalDistribution(r16, new Covariance(r11).getCovarianceMatrix().getData())));
        r5 = 0;
        goto L12
    L20:
        return new MixtureMultivariateNormalDistribution(r0);
    L22:
        throw new NumberIsTooLargeException(Integer.valueOf(r23), Integer.valueOf(r22.length), true);
    L24:
        throw new NumberIsTooSmallException(Integer.valueOf(r23), 2, true);
    L26:
        throw new NotStrictlyPositiveException(Integer.valueOf(r22.length));
    }

    public double getLogLikelihood() {
        return this.logLikelihood;
    }

    public MixtureMultivariateNormalDistribution getFittedModel() {
        return new MixtureMultivariateNormalDistribution(this.fittedModel.getComponents());
    }
}
