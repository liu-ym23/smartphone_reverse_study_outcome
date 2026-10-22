package org.apache.commons.math3.linear;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.IterationManager;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class IterativeLinearSolver {
    private final IterationManager manager;

    public abstract RealVector solveInPlace(RealLinearOperator r1, RealVector r2, RealVector r3) throws NullArgumentException, NonSquareOperatorException, DimensionMismatchException, MaxCountExceededException;

    public IterativeLinearSolver(int r2) {
        this.manager = new IterationManager(r2);
    }

    public IterativeLinearSolver(IterationManager r1) throws NullArgumentException {
        MathUtils.checkNotNull(r1);
        this.manager = r1;
    }

    protected static void checkParameters(RealLinearOperator r2, RealVector r3, RealVector r4) throws NullArgumentException, NonSquareOperatorException, DimensionMismatchException {
        MathUtils.checkNotNull(r2);
        MathUtils.checkNotNull(r3);
        MathUtils.checkNotNull(r4);
        if (r2.getRowDimension() != r2.getColumnDimension()) goto L14;
        if (r3.getDimension() != r2.getRowDimension()) goto L12;
        if (r4.getDimension() != r2.getColumnDimension()) goto L10;
        return;
    L10:
        throw new DimensionMismatchException(r4.getDimension(), r2.getColumnDimension());
    L12:
        throw new DimensionMismatchException(r3.getDimension(), r2.getRowDimension());
    L14:
        throw new NonSquareOperatorException(r2.getRowDimension(), r2.getColumnDimension());
    }

    public IterationManager getIterationManager() {
        return this.manager;
    }

    public RealVector solve(RealLinearOperator r4, RealVector r5) throws NullArgumentException, NonSquareOperatorException, DimensionMismatchException, MaxCountExceededException {
        MathUtils.checkNotNull(r4);
        ArrayRealVector r0 = new ArrayRealVector(r4.getColumnDimension());
        r0.set(0.0d);
        return solveInPlace(r4, r5, r0);
    }

    public RealVector solve(RealLinearOperator r1, RealVector r2, RealVector r3) throws NullArgumentException, NonSquareOperatorException, DimensionMismatchException, MaxCountExceededException {
        MathUtils.checkNotNull(r3);
        return solveInPlace(r1, r2, r3.copy());
    }
}
