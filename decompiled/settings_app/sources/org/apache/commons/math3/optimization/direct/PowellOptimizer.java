package org.apache.commons.math3.optimization.direct;

import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.MultivariateOptimizer;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.optimization.univariate.BracketFinder;
import org.apache.commons.math3.optimization.univariate.BrentOptimizer;
import org.apache.commons.math3.optimization.univariate.SimpleUnivariateValueChecker;
import org.apache.commons.math3.optimization.univariate.UnivariatePointValuePair;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class PowellOptimizer extends BaseAbstractMultivariateOptimizer<MultivariateFunction> implements MultivariateOptimizer {
    private static final double MIN_RELATIVE_TOLERANCE = 0.0d;
    private final double absoluteThreshold;
    private final LineSearch line;
    private final double relativeThreshold;

    private class LineSearch extends BrentOptimizer {
        private static final double ABS_TOL_UNUSED = Double.MIN_VALUE;
        private static final double REL_TOL_UNUSED = 1.0E-15d;
        private final BracketFinder bracket;
        final /* synthetic */ PowellOptimizer this$0;

        LineSearch(PowellOptimizer r7, double r8, double r10) {
            this.this$0 = r7;
            super(1.0E-15d, Double.MIN_VALUE, new SimpleUnivariateValueChecker(r8, r10));
            this.bracket = new BracketFinder();
        }

        public UnivariatePointValuePair search(final double[] r14, final double[] r15) {
            final int r0 = r14.length;
            UnivariateFunction r8 = new AnonymousClass1(this, r0, r14, r15);
            GoalType r16 = this.this$0.getGoalType();
            this.bracket.search(r8, r16, 0.0d, 1.0d);
            return optimize(Integer.MAX_VALUE, r8, r16, this.bracket.getLo(), this.bracket.getHi(), this.bracket.getMid());
        }
    }

    static {
        MIN_RELATIVE_TOLERANCE = FastMath.ulp(1.0d) * 2.0d;
    }

    public PowellOptimizer(double r11, double r13, ConvergenceChecker<PointValuePair> r15) {
        this(r11, r13, FastMath.sqrt(r11), FastMath.sqrt(r13), r15);
    }

    public PowellOptimizer(double r7, double r9, double r11, double r13, ConvergenceChecker<PointValuePair> r15) {
        super(r15);
        double r0 = MIN_RELATIVE_TOLERANCE;
        if (r7 < r0) goto L11;
        if (r9 <= 0.0d) goto L9;
        this.relativeThreshold = r7;
        this.absoluteThreshold = r9;
        this.line = new LineSearch(this, r11, r13);
        return;
    L9:
        throw new NotStrictlyPositiveException(Double.valueOf(r9));
    L11:
        throw new NumberIsTooSmallException(Double.valueOf(r7), Double.valueOf(r0), true);
    }

    public PowellOptimizer(double r7, double r9) {
        this(r7, r9, null);
    }

    public PowellOptimizer(double r11, double r13, double r15, double r17) {
        this(r11, r13, r15, r17, null);
    }

    @Override // org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateOptimizer
    protected PointValuePair doOptimize() {
        GoalType r1 = getGoalType();
        double[] r2 = getStartPoint();
        int r3 = r2.length;
        int r5 = 1;
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
        int r11 = 0;
    L6:
        r11 = r11 + r5;
        int r14 = r6;
        int r18 = r14;
        double r12 = r9;
        double r16 = 0.0d;
    L7:
        if (r14 >= r3) goto L12;
        double[] r15 = MathArrays.copyOf(r4[r14]);
        UnivariatePointValuePair r13 = this.line.search(r2, r15);
        double r20 = r13.getValue();
        double[][] r19 = r4;
        r2 = newPointAndDirection(r2, r15, r13.getPoint())[r6];
        double r17 = r12 - r20;
        if (r17 <= r16) goto L11;
        r16 = r17;
        r18 = r14;
    L11:
        r14 = r14 + 1;
        r4 = r19;
        r12 = r20;
        goto L7
    L12:
        double[][] r110 = r4;
        double r21 = r9 - r12;
        ConvergenceChecker<PointValuePair> r25 = r8;
        if ((r21 * 2.0d) > ((this.relativeThreshold * (FastMath.abs(r9) + FastMath.abs(r12))) + this.absoluteThreshold)) goto L15;
        boolean r22 = true;
    L16:
        PointValuePair r23 = new PointValuePair(r10, r9);
        PointValuePair r111 = new PointValuePair(r2, r12);
        if (r22 == true) goto L20;
        if (r25 == null) goto L20;
        ConvergenceChecker<PointValuePair> r112 = r25;
        r22 = r112.converged(r11, r23, r111);
    L21:
        if (r22 == true) goto L23;
        double[] r24 = new double[r3];
        double[] r26 = new double[r3];
        int r113 = 0;
    L33:
        if (r113 >= r3) goto L35;
        r24[r113] = r2[r113] - r10[r113];
        r26[r113] = (r2[r113] * 2.0d) - r10[r113];
        r113 = r113 + 1;
        goto L33
    L35:
        r10 = (double[]) r2.clone();
        double r27 = computeObjectiveValue(r26);
        if (r9 <= r27) goto L40;
        double r28 = r21 - r16;
        double r29 = (((r9 + r27) - (r12 * 2.0d)) * 2.0d) * (r28 * r28);
        double r30 = r9 - r27;
        if ((r29 - ((r16 * r30) * r30)) >= 0.0d) goto L40;
        UnivariatePointValuePair r31 = this.line.search(r2, r24);
        double r32 = r31.getValue();
        double[][] r33 = newPointAndDirection(r2, r24, r31.getPoint());
        int r34 = 0;
        double[] r35 = r33[0];
        int r36 = r3 - 1;
        r110[r18] = r110[r36];
        int r37 = 1;
        r110[r36] = r33[1];
        r2 = r35;
    L41:
        r6 = r34;
        r5 = r37;
        r4 = r110;
        r9 = r32;
        r8 = r112;
    L40:
        r34 = 0;
        r37 = 1;
        r32 = r12;
        goto L41
    L23:
        if (r1 != GoalType.MINIMIZE) goto L29;
        if (r12 < r9) goto L27;
        return r23;
    L27:
        return r111;
    L29:
        if (r12 > r9) goto L31;
        return r23;
    L31:
        return r111;
    L20:
        r112 = r25;
        goto L21
    L15:
        r22 = false;
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
}
