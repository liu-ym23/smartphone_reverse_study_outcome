package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.NonPositiveDefiniteMatrixException;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.SingularMatrixException;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class MultivariateNormalDistribution extends AbstractMultivariateRealDistribution {
    private final RealMatrix covarianceMatrix;
    private final double covarianceMatrixDeterminant;
    private final RealMatrix covarianceMatrixInverse;
    private final double[] means;
    private final RealMatrix samplingMatrix;

    public MultivariateNormalDistribution(double[] r2, double[][] r3) throws SingularMatrixException, DimensionMismatchException, NonPositiveDefiniteMatrixException {
        this(new Well19937c(), r2, r3);
    }

    public MultivariateNormalDistribution(RandomGenerator r8, double[] r9, double[][] r10) throws SingularMatrixException, DimensionMismatchException, NonPositiveDefiniteMatrixException {
        super(r8, r9.length);
        int r11 = r9.length;
        if (r10.length != r11) goto L31;
        int r1 = 0;
    L5:
        if (r1 >= r11) goto L11;
        if (r11 != r10[r1].length) goto L10;
        r1 = r1 + 1;
        goto L5
    L10:
        throw new DimensionMismatchException(r10[r1].length, r11);
    L11:
        this.means = MathArrays.copyOf(r9);
        Array2DRowRealMatrix r12 = new Array2DRowRealMatrix(r10);
        this.covarianceMatrix = r12;
        EigenDecomposition r13 = new EigenDecomposition(r12);
        this.covarianceMatrixInverse = r13.getSolver().getInverse();
        this.covarianceMatrixDeterminant = r13.getDeterminant();
        double[] r14 = r13.getRealEigenvalues();
        int r4 = 0;
    L13:
        if (r4 >= r14.length) goto L19;
        if (r14[r4] < 0.0d) goto L18;
        r4 = r4 + 1;
        goto L13
    L18:
        throw new NonPositiveDefiniteMatrixException(r14[r4], r4, 0.0d);
    L19:
        Array2DRowRealMatrix r2 = new Array2DRowRealMatrix(r11, r11);
        int r3 = 0;
    L20:
        if (r3 >= r11) goto L22;
        r2.setColumn(r3, r13.getEigenvector(r3).toArray());
        r3 = r3 + 1;
        goto L20
    L22:
        RealMatrix r15 = r2.transpose();
        int r5 = 0;
    L23:
        if (r5 >= r11) goto L28;
        double r6 = FastMath.sqrt(r14[r5]);
        int r7 = 0;
    L25:
        if (r7 >= r11) goto L27;
        r15.multiplyEntry(r5, r7, r6);
        r7 = r7 + 1;
        goto L25
    L27:
        r5 = r5 + 1;
        goto L23
    L28:
        this.samplingMatrix = r2.multiply(r15);
        return;
    L31:
        throw new DimensionMismatchException(r10.length, r11);
    }

    public double[] getMeans() {
        return MathArrays.copyOf(this.means);
    }

    public RealMatrix getCovariances() {
        return this.covarianceMatrix.copy();
    }

    @Override // org.apache.commons.math3.distribution.MultivariateRealDistribution
    public double density(double[] r7) throws DimensionMismatchException {
        int r0 = getDimension();
        if (r7.length != r0) goto L7;
        return (FastMath.pow(6.283185307179586d, ((double) r0) * (-0.5d)) * FastMath.pow(this.covarianceMatrixDeterminant, -0.5d)) * getExponentTerm(r7);
    L7:
        throw new DimensionMismatchException(r7.length, r0);
    }

    public double[] getStandardDeviations() {
        int r0 = getDimension();
        double[] r1 = new double[r0];
        double[][] r5 = this.covarianceMatrix.getData();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = FastMath.sqrt(r5[r2][r2]);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // org.apache.commons.math3.distribution.AbstractMultivariateRealDistribution, org.apache.commons.math3.distribution.MultivariateRealDistribution
    public double[] sample() {
        int r0 = getDimension();
        double[] r1 = new double[r0];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1[r3] = this.random.nextGaussian();
        r3 = r3 + 1;
        goto L3
    L5:
        double[] r4 = this.samplingMatrix.operate(r1);
    L6:
        if (r2 >= r0) goto L8;
        r4[r2] = r4[r2] + this.means[r2];
        r2 = r2 + 1;
        goto L6
    L8:
        return r4;
    }

    private double getExponentTerm(double[] r10) {
        int r0 = r10.length;
        double[] r1 = new double[r0];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1[r3] = r10[r3] - getMeans()[r3];
        r3 = r3 + 1;
        goto L3
    L5:
        double[] r9 = this.covarianceMatrixInverse.preMultiply(r1);
        double r4 = 0.0d;
    L7:
        if (r2 >= r9.length) goto L10;
        r4 = r4 + (r9[r2] * r1[r2]);
        r2 = r2 + 1;
        goto L7
    L10:
        return FastMath.exp(r4 * (-0.5d));
    }
}
