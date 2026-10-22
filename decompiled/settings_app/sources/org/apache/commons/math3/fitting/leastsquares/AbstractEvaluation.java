package org.apache.commons.math3.fitting.leastsquares;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractEvaluation implements LeastSquaresProblem.Evaluation {
    private final int observationSize;

    AbstractEvaluation(int r1) {
        this.observationSize = r1;
    }

    @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem.Evaluation
    public RealMatrix getCovariances(double r2) {
        RealMatrix r1 = getJacobian();
        return new QRDecomposition(r1.transpose().multiply(r1), r2).getSolver().getInverse();
    }

    @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem.Evaluation
    public RealVector getSigma(double r4) {
        RealMatrix r3 = getCovariances(r4);
        int r5 = r3.getColumnDimension();
        ArrayRealVector r6 = new ArrayRealVector(r5);
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L5;
        r6.setEntry(r0, FastMath.sqrt(r3.getEntry(r0, r0)));
        r0 = r0 + 1;
        goto L3
    L5:
        return r6;
    }

    @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem.Evaluation
    public double getRMS() {
        double r0 = getCost();
        return FastMath.sqrt((r0 * r0) / ((double) this.observationSize));
    }

    @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem.Evaluation
    public double getCost() {
        RealVector r0 = new ArrayRealVector(getResiduals());
        return FastMath.sqrt(r0.dotProduct(r0));
    }
}
