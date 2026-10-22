package org.apache.commons.math3.filter;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

/* JADX INFO: loaded from: classes6.dex */
public class DefaultProcessModel implements ProcessModel {
    private RealMatrix controlMatrix;
    private RealMatrix initialErrorCovMatrix;
    private RealVector initialStateEstimateVector;
    private RealMatrix processNoiseCovMatrix;
    private RealMatrix stateTransitionMatrix;

    public DefaultProcessModel(double[][] r6, double[][] r7, double[][] r8, double[] r9, double[][] r10) throws NullArgumentException, NoDataException, DimensionMismatchException {
        this(new Array2DRowRealMatrix(r6), new Array2DRowRealMatrix(r7), new Array2DRowRealMatrix(r8), new ArrayRealVector(r9), new Array2DRowRealMatrix(r10));
    }

    public DefaultProcessModel(double[][] r7, double[][] r8, double[][] r9) throws NullArgumentException, NoDataException, DimensionMismatchException {
        this(new Array2DRowRealMatrix(r7), new Array2DRowRealMatrix(r8), new Array2DRowRealMatrix(r9), null, null);
    }

    public DefaultProcessModel(RealMatrix r1, RealMatrix r2, RealMatrix r3, RealVector r4, RealMatrix r5) {
        this.stateTransitionMatrix = r1;
        this.controlMatrix = r2;
        this.processNoiseCovMatrix = r3;
        this.initialStateEstimateVector = r4;
        this.initialErrorCovMatrix = r5;
    }

    @Override // org.apache.commons.math3.filter.ProcessModel
    public RealMatrix getStateTransitionMatrix() {
        return this.stateTransitionMatrix;
    }

    @Override // org.apache.commons.math3.filter.ProcessModel
    public RealMatrix getControlMatrix() {
        return this.controlMatrix;
    }

    @Override // org.apache.commons.math3.filter.ProcessModel
    public RealMatrix getProcessNoise() {
        return this.processNoiseCovMatrix;
    }

    @Override // org.apache.commons.math3.filter.ProcessModel
    public RealVector getInitialStateEstimate() {
        return this.initialStateEstimateVector;
    }

    @Override // org.apache.commons.math3.filter.ProcessModel
    public RealMatrix getInitialErrorCovariance() {
        return this.initialErrorCovMatrix;
    }
}
