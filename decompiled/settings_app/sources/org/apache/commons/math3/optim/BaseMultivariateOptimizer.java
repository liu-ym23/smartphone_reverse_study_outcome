package org.apache.commons.math3.optim;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;

/* JADX INFO: loaded from: classes6.dex */
public abstract class BaseMultivariateOptimizer<PAIR> extends BaseOptimizer<PAIR> {
    private double[] lowerBound;
    private double[] start;
    private double[] upperBound;

    protected BaseMultivariateOptimizer(ConvergenceChecker<PAIR> r1) {
        super(r1);
    }

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    public PAIR optimize(OptimizationData... r1) {
        return (PAIR) super.optimize(r1);
    }

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    protected void parseOptimizationData(OptimizationData... r5) {
        super.parseOptimizationData(r5);
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        OptimizationData r2 = r5[r1];
        if ((r2 instanceof InitialGuess) == false) goto L8;
        this.start = ((InitialGuess) r2).getInitialGuess();
    L10:
        r1 = r1 + 1;
        goto L3
    L8:
        if ((r2 instanceof SimpleBounds) == false) goto L10;
        SimpleBounds r3 = (SimpleBounds) r2;
        this.lowerBound = r3.getLower();
        this.upperBound = r3.getUpper();
        goto L10
    L11:
        checkParameters();
    }

    public double[] getStartPoint() {
        double[] r0 = this.start;
        if (r0 != null) goto L6;
        return null;
    L6:
        return (double[]) r0.clone();
    }

    public double[] getLowerBound() {
        double[] r0 = this.lowerBound;
        if (r0 != null) goto L6;
        return null;
    L6:
        return (double[]) r0.clone();
    }

    public double[] getUpperBound() {
        double[] r0 = this.upperBound;
        if (r0 != null) goto L6;
        return null;
    L6:
        return (double[]) r0.clone();
    }

    private void checkParameters() {
        double[] r0 = this.start;
        if (r0 == null) goto L29;
        int r1 = r0.length;
        double[] r2 = this.lowerBound;
        int r3 = 0;
        if (r2 != null) goto L7;
    L17:
        double[] r4 = this.upperBound;
        if (r4 != null) goto L20;
        return;
    L20:
        if (r4.length != r1) goto L28;
    L21:
        if (r3 >= r1) goto L35;
        double r5 = this.start[r3];
        double r6 = this.upperBound[r3];
        if (r5 > r6) goto L26;
        r3 = r3 + 1;
        goto L21
    L26:
        throw new NumberIsTooLargeException(Double.valueOf(r5), Double.valueOf(r6), true);
    L35:
        return;
    L28:
        throw new DimensionMismatchException(this.upperBound.length, r1);
    L7:
        if (r2.length != r1) goto L16;
        int r7 = 0;
    L9:
        if (r7 >= r1) goto L17;
        double r8 = this.start[r7];
        double r9 = this.lowerBound[r7];
        if (r8 < r9) goto L14;
        r7 = r7 + 1;
        goto L9
    L14:
        throw new NumberIsTooSmallException(Double.valueOf(r8), Double.valueOf(r9), true);
    L16:
        throw new DimensionMismatchException(this.lowerBound.length, r1);
    }
}
