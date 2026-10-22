package org.apache.commons.math3.optim.nonlinear.scalar.noderiv;

import java.lang.reflect.Array;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.optim.nonlinear.scalar.LineSearch;
import org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer;
import org.apache.commons.math3.optim.univariate.UnivariatePointValuePair;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class PowellOptimizer extends MultivariateOptimizer {
    private static final double MIN_RELATIVE_TOLERANCE = 0.0d;
    private final double absoluteThreshold;
    private final LineSearch line;
    private final double relativeThreshold;

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    protected /* bridge */ /* synthetic */ Object doOptimize() {
        return doOptimize();
    }

    static {
        MIN_RELATIVE_TOLERANCE = FastMath.ulp(1.0d) * 2.0d;
    }

    public PowellOptimizer(double r11, double r13, ConvergenceChecker<PointValuePair> r15) {
        this(r11, r13, FastMath.sqrt(r11), FastMath.sqrt(r13), r15);
    }

    public PowellOptimizer(double r11, double r13, double r15, double r17, ConvergenceChecker<PointValuePair> r19) {
        super(r19);
        double r4 = MIN_RELATIVE_TOLERANCE;
        if (r11 < r4) goto L11;
        if (r13 <= 0.0d) goto L9;
        this.relativeThreshold = r11;
        this.absoluteThreshold = r13;
        this.line = new LineSearch(this, r15, r17, 1.0d);
        return;
    L9:
        throw new NotStrictlyPositiveException(Double.valueOf(r13));
    L11:
        throw new NumberIsTooSmallException(Double.valueOf(r11), Double.valueOf(r4), true);
    }

    public PowellOptimizer(double r7, double r9) {
        this(r7, r9, null);
    }

    public PowellOptimizer(double r11, double r13, double r15, double r17) {
        this(r11, r13, r15, r17, null);
    }

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    protected PointValuePair doOptimize() {
        checkParameters();
        GoalType r1 = getGoalType();
        double[] r2 = getStartPoint();
        int r3 = r2.length;
        int r6 = 0;
        double[][] r4 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r3, r3});
        int r7 = 0;
    L3:
        if (r7 >= r3) goto L5;
        r4[r7][r7] = 1.0d;
        r7 = r7 + 1;
        goto L3
    L5:
        ConvergenceChecker<PointValuePair> r8 = getConvergenceChecker();
        double r9 = computeObjectiveValue(r2);
        double[] r10 = (double[]) r2.clone();
    L6:
        incrementIterationCount();
        int r13 = r6;
        int r18 = r13;
        double r14 = r9;
        double r16 = 0.0d;
    L7:
        if (r13 >= r3) goto L12;
        double[] r5 = MathArrays.copyOf(r4[r13]);
        UnivariatePointValuePair r11 = this.line.search(r2, r5);
        double r20 = r11.getValue();
        r2 = newPointAndDirection(r2, r5, r11.getPoint())[r6];
        double r15 = r14 - r20;
        if (r15 <= r16) goto L11;
        r18 = r13;
        r16 = r15;
    L11:
        r13 = r13 + 1;
        r14 = r20;
        goto L7
    L12:
        double r12 = r9 - r14;
        ConvergenceChecker<PointValuePair> r17 = r8;
        double[][] r19 = r4;
        if ((r12 * 2.0d) > ((this.relativeThreshold * (FastMath.abs(r9) + FastMath.abs(r14))) + this.absoluteThreshold)) goto L15;
        boolean r21 = true;
    L16:
        PointValuePair r22 = new PointValuePair(r10, r9);
        PointValuePair r23 = new PointValuePair(r2, r14);
        if (r21 == true) goto L20;
        if (r17 == null) goto L20;
        r21 = r17.converged(getIterations(), r22, r23);
    L20:
        if (r21 == true) goto L22;
        double[] r24 = new double[r3];
        double[] r25 = new double[r3];
        int r26 = 0;
    L32:
        if (r26 >= r3) goto L34;
        r24[r26] = r2[r26] - r10[r26];
        r25[r26] = (r2[r26] * 2.0d) - r10[r26];
        r26 = r26 + 1;
        goto L32
    L34:
        r10 = (double[]) r2.clone();
        double r27 = computeObjectiveValue(r25);
        if (r9 <= r27) goto L39;
        double r110 = r12 - r16;
        double r28 = (((r9 + r27) - (r14 * 2.0d)) * 2.0d) * (r110 * r110);
        double r29 = r9 - r27;
        if ((r28 - ((r16 * r29) * r29)) >= 0.0d) goto L39;
        UnivariatePointValuePair r30 = this.line.search(r2, r24);
        double r31 = r30.getValue();
        double[][] r32 = newPointAndDirection(r2, r24, r30.getPoint());
        int r33 = 0;
        double[] r34 = r32[0];
        int r35 = r3 - 1;
        r19[r18] = r19[r35];
        boolean r36 = true;
        r19[r35] = r32[1];
        r2 = r34;
    L40:
        r9 = r31;
        r8 = r17;
        r6 = r33;
        r4 = r19;
    L39:
        r33 = 0;
        r36 = true;
        r31 = r14;
        goto L40
    L22:
        if (r1 != GoalType.MINIMIZE) goto L28;
        if (r14 < r9) goto L26;
        return r22;
    L26:
        return r23;
    L28:
        if (r14 > r9) goto L30;
        return r22;
    L30:
        return r23;
    L15:
        r21 = false;
        goto L16
    }

    private double[][] newPointAndDirection(double[] r9, double[] r10, double r11) {
        int r8 = r9.length;
        double[] r0 = new double[r8];
        double[] r1 = new double[r8];
        int r3 = 0;
    L3:
        if (r3 >= r8) goto L6;
        double r4 = r10[r3] * r11;
        r1[r3] = r4;
        r0[r3] = r9[r3] + r4;
        r3 = r3 + 1;
        goto L3
    L6:
        return new double[][]{r0, r1};
    }

    private void checkParameters() {
        if (getLowerBound() != null) goto L8;
        if (getUpperBound() != null) goto L8;
        return;
    L8:
        throw new MathUnsupportedOperationException(LocalizedFormats.CONSTRAINT, new Object[0]);
    }
}
