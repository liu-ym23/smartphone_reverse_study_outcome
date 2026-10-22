package org.apache.commons.math3.optimization;

import org.apache.commons.math3.linear.DiagonalMatrix;
import org.apache.commons.math3.linear.NonSquareMatrixException;
import org.apache.commons.math3.linear.RealMatrix;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class Weight implements OptimizationData {
    private final RealMatrix weightMatrix;

    public Weight(double[] r2) {
        this.weightMatrix = new DiagonalMatrix(r2);
    }

    public Weight(RealMatrix r3) {
        if (r3.getColumnDimension() != r3.getRowDimension()) goto L7;
        this.weightMatrix = r3.copy();
        return;
    L7:
        throw new NonSquareMatrixException(r3.getColumnDimension(), r3.getRowDimension());
    }

    public RealMatrix getWeight() {
        return this.weightMatrix.copy();
    }
}
