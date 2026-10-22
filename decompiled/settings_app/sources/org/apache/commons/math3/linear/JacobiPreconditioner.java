package org.apache.commons.math3.linear;

import org.apache.commons.math3.analysis.function.Sqrt;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class JacobiPreconditioner extends RealLinearOperator {
    private final ArrayRealVector diag;

    public JacobiPreconditioner(double[] r2, boolean r3) {
        this.diag = new ArrayRealVector(r2, r3);
    }

    public static JacobiPreconditioner create(RealLinearOperator r7) throws NonSquareOperatorException {
        int r0 = r7.getColumnDimension();
        if (r7.getRowDimension() != r0) goto L15;
        double[] r1 = new double[r0];
        if ((r7 instanceof AbstractRealMatrix) == false) goto L9;
        AbstractRealMatrix r8 = (AbstractRealMatrix) r7;
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L13;
        r1[r2] = r8.getEntry(r2, r2);
        r2 = r2 + 1;
    L13:
        return new JacobiPreconditioner(r1, false);
    L9:
        ArrayRealVector r3 = new ArrayRealVector(r0);
        int r4 = 0;
    L10:
        if (r4 >= r0) goto L13;
        r3.set(0.0d);
        r3.setEntry(r4, 1.0d);
        r1[r4] = r7.operate(r3).getEntry(r4);
        r4 = r4 + 1;
        goto L10
    L15:
        throw new NonSquareOperatorException(r7.getRowDimension(), r0);
    }

    @Override // org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
    public int getColumnDimension() {
        return this.diag.getDimension();
    }

    @Override // org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
    public int getRowDimension() {
        return this.diag.getDimension();
    }

    @Override // org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.RealMatrix
    public RealVector operate(RealVector r2) {
        return new ArrayRealVector(MathArrays.ebeDivide(r2.toArray(), this.diag.toArray()), false);
    }

    public RealLinearOperator sqrt() {
        final ArrayRealVector r0 = this.diag.map(new Sqrt());
        return new AnonymousClass1(this, r0);
    }
}
