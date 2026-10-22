package org.apache.commons.math3.filter;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.CholeskyDecomposition;
import org.apache.commons.math3.linear.MatrixDimensionMismatchException;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.NonSquareMatrixException;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.linear.SingularMatrixException;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class KalmanFilter {
    private RealMatrix controlMatrix;
    private RealMatrix errorCovariance;
    private RealMatrix measurementMatrix;
    private RealMatrix measurementMatrixT;
    private final MeasurementModel measurementModel;
    private final ProcessModel processModel;
    private RealVector stateEstimation;
    private RealMatrix transitionMatrix;
    private RealMatrix transitionMatrixT;

    public KalmanFilter(ProcessModel r4, MeasurementModel r5) throws NullArgumentException, NonSquareMatrixException, DimensionMismatchException, MatrixDimensionMismatchException {
        MathUtils.checkNotNull(r4);
        MathUtils.checkNotNull(r5);
        this.processModel = r4;
        this.measurementModel = r5;
        RealMatrix r0 = r4.getStateTransitionMatrix();
        this.transitionMatrix = r0;
        MathUtils.checkNotNull(r0);
        this.transitionMatrixT = this.transitionMatrix.transpose();
        if (r4.getControlMatrix() != null) goto L5;
        this.controlMatrix = new Array2DRowRealMatrix();
    L6:
        RealMatrix r1 = r5.getMeasurementMatrix();
        this.measurementMatrix = r1;
        MathUtils.checkNotNull(r1);
        this.measurementMatrixT = this.measurementMatrix.transpose();
        RealMatrix r2 = r4.getProcessNoise();
        MathUtils.checkNotNull(r2);
        RealMatrix r6 = r5.getMeasurementNoise();
        MathUtils.checkNotNull(r6);
        if (r4.getInitialStateEstimate() != null) goto L9;
        this.stateEstimation = new ArrayRealVector(this.transitionMatrix.getColumnDimension());
    L11:
        if (this.transitionMatrix.getColumnDimension() != this.stateEstimation.getDimension()) goto L41;
        if (r4.getInitialErrorCovariance() != null) goto L15;
        this.errorCovariance = r2.copy();
    L17:
        if (this.transitionMatrix.isSquare() == false) goto L39;
        RealMatrix r7 = this.controlMatrix;
        if (r7 != null) goto L21;
    L29:
        MatrixUtils.checkAdditionCompatible(this.transitionMatrix, r2);
        if (this.measurementMatrix.getColumnDimension() != this.transitionMatrix.getRowDimension()) goto L37;
        if (r6.getRowDimension() != this.measurementMatrix.getRowDimension()) goto L35;
        return;
    L35:
        throw new MatrixDimensionMismatchException(r6.getRowDimension(), r6.getColumnDimension(), this.measurementMatrix.getRowDimension(), r6.getColumnDimension());
    L37:
        throw new MatrixDimensionMismatchException(this.measurementMatrix.getRowDimension(), this.measurementMatrix.getColumnDimension(), this.measurementMatrix.getRowDimension(), this.transitionMatrix.getRowDimension());
    L21:
        if (r7.getRowDimension() <= 0) goto L29;
        if (this.controlMatrix.getColumnDimension() <= 0) goto L29;
        if (this.controlMatrix.getRowDimension() == this.transitionMatrix.getRowDimension()) goto L29;
        throw new MatrixDimensionMismatchException(this.controlMatrix.getRowDimension(), this.controlMatrix.getColumnDimension(), this.transitionMatrix.getRowDimension(), this.controlMatrix.getColumnDimension());
    L39:
        throw new NonSquareMatrixException(this.transitionMatrix.getRowDimension(), this.transitionMatrix.getColumnDimension());
    L15:
        this.errorCovariance = r4.getInitialErrorCovariance();
        goto L17
    L41:
        throw new DimensionMismatchException(this.transitionMatrix.getColumnDimension(), this.stateEstimation.getDimension());
    L9:
        this.stateEstimation = r4.getInitialStateEstimate();
        goto L11
    L5:
        this.controlMatrix = r4.getControlMatrix();
        goto L6
    }

    public int getStateDimension() {
        return this.stateEstimation.getDimension();
    }

    public int getMeasurementDimension() {
        return this.measurementMatrix.getRowDimension();
    }

    public double[] getStateEstimation() {
        return this.stateEstimation.toArray();
    }

    public RealVector getStateEstimationVector() {
        return this.stateEstimation.copy();
    }

    public double[][] getErrorCovariance() {
        return this.errorCovariance.getData();
    }

    public RealMatrix getErrorCovarianceMatrix() {
        return this.errorCovariance.copy();
    }

    public void predict() {
        RealVector r1 = (RealVector) null;
        predict(null);
    }

    public void predict(double[] r3) throws DimensionMismatchException {
        predict(new ArrayRealVector(r3, false));
    }

    public void predict(RealVector r3) throws DimensionMismatchException {
        if (r3 != null) goto L4;
    L8:
        RealVector r0 = this.transitionMatrix.operate(this.stateEstimation);
        this.stateEstimation = r0;
        if (r3 == null) goto L11;
        this.stateEstimation = r0.add(this.controlMatrix.operate(r3));
    L11:
        this.errorCovariance = this.transitionMatrix.multiply(this.errorCovariance).multiply(this.transitionMatrixT).add(this.processModel.getProcessNoise());
        return;
    L4:
        if (r3.getDimension() == this.controlMatrix.getColumnDimension()) goto L8;
        throw new DimensionMismatchException(r3.getDimension(), this.controlMatrix.getColumnDimension());
    }

    public void correct(double[] r3) throws NullArgumentException, DimensionMismatchException, SingularMatrixException {
        correct(new ArrayRealVector(r3, false));
    }

    public void correct(RealVector r4) throws NullArgumentException, DimensionMismatchException, SingularMatrixException {
        MathUtils.checkNotNull(r4);
        if (r4.getDimension() != this.measurementMatrix.getRowDimension()) goto L7;
        RealMatrix r0 = this.measurementMatrix.multiply(this.errorCovariance).multiply(this.measurementMatrixT).add(this.measurementModel.getMeasurementNoise());
        RealVector r5 = r4.subtract(this.measurementMatrix.operate(this.stateEstimation));
        RealMatrix r1 = new CholeskyDecomposition(r0).getSolver().solve(this.measurementMatrix.multiply(this.errorCovariance.transpose())).transpose();
        this.stateEstimation = this.stateEstimation.add(r1.operate(r5));
        this.errorCovariance = MatrixUtils.createRealIdentityMatrix(r1.getRowDimension()).subtract(r1.multiply(this.measurementMatrix)).multiply(this.errorCovariance);
        return;
    L7:
        throw new DimensionMismatchException(r4.getDimension(), this.measurementMatrix.getRowDimension());
    }
}
