package org.apache.commons.math3.linear;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.IterationManager;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class PreconditionedIterativeLinearSolver extends IterativeLinearSolver {
    public abstract RealVector solveInPlace(RealLinearOperator r1, RealLinearOperator r2, RealVector r3, RealVector r4) throws NullArgumentException, NonSquareOperatorException, DimensionMismatchException, MaxCountExceededException;

    public PreconditionedIterativeLinearSolver(int r1) {
        super(r1);
    }

    public PreconditionedIterativeLinearSolver(IterationManager r1) throws NullArgumentException {
        super(r1);
    }

    public RealVector solve(RealLinearOperator r1, RealLinearOperator r2, RealVector r3, RealVector r4) throws NullArgumentException, NonSquareOperatorException, DimensionMismatchException, MaxCountExceededException {
        MathUtils.checkNotNull(r4);
        return solveInPlace(r1, r2, r3, r4.copy());
    }

    @Override // org.apache.commons.math3.linear.IterativeLinearSolver
    public RealVector solve(RealLinearOperator r4, RealVector r5) throws NullArgumentException, NonSquareOperatorException, DimensionMismatchException, MaxCountExceededException {
        MathUtils.checkNotNull(r4);
        ArrayRealVector r0 = new ArrayRealVector(r4.getColumnDimension());
        r0.set(0.0d);
        return solveInPlace(r4, null, r5, r0);
    }

    @Override // org.apache.commons.math3.linear.IterativeLinearSolver
    public RealVector solve(RealLinearOperator r2, RealVector r3, RealVector r4) throws NullArgumentException, NonSquareOperatorException, DimensionMismatchException, MaxCountExceededException {
        MathUtils.checkNotNull(r4);
        return solveInPlace(r2, null, r3, r4.copy());
    }

    protected static void checkParameters(RealLinearOperator r0, RealLinearOperator r1, RealVector r2, RealVector r3) throws NullArgumentException, NonSquareOperatorException, DimensionMismatchException {
        checkParameters(r0, r2, r3);
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.getColumnDimension() != r1.getRowDimension()) goto L12;
        if (r1.getRowDimension() != r0.getRowDimension()) goto L10;
        return;
    L10:
        throw new DimensionMismatchException(r1.getRowDimension(), r0.getRowDimension());
    L12:
        throw new NonSquareOperatorException(r1.getColumnDimension(), r1.getRowDimension());
    }

    public RealVector solve(RealLinearOperator r3, RealLinearOperator r4, RealVector r5) throws NullArgumentException, NonSquareOperatorException, DimensionMismatchException, MaxCountExceededException {
        MathUtils.checkNotNull(r3);
        return solveInPlace(r3, r4, r5, new ArrayRealVector(r3.getColumnDimension()));
    }

    @Override // org.apache.commons.math3.linear.IterativeLinearSolver
    public RealVector solveInPlace(RealLinearOperator r2, RealVector r3, RealVector r4) throws NullArgumentException, NonSquareOperatorException, DimensionMismatchException, MaxCountExceededException {
        return solveInPlace(r2, null, r3, r4);
    }
}
