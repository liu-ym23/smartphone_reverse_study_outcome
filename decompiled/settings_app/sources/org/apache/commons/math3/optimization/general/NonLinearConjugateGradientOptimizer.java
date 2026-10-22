package org.apache.commons.math3.optimization.general;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.solvers.BrentSolver;
import org.apache.commons.math3.analysis.solvers.UnivariateSolver;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.optimization.SimpleValueChecker;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class NonLinearConjugateGradientOptimizer extends AbstractScalarDifferentiableOptimizer {
    private double initialStep;
    private double[] point;
    private final Preconditioner preconditioner;
    private final UnivariateSolver solver;
    private final ConjugateGradientFormula updateFormula;

    public static class IdentityPreconditioner implements Preconditioner {
        public IdentityPreconditioner() {
        }

        @Override // org.apache.commons.math3.optimization.general.Preconditioner
        public double[] precondition(double[] r1, double[] r2) {
            return (double[]) r2.clone();
        }
    }

    private class LineSearchFunction implements UnivariateFunction {
        private final double[] searchDirection;
        final /* synthetic */ NonLinearConjugateGradientOptimizer this$0;

        LineSearchFunction(NonLinearConjugateGradientOptimizer r1, double[] r2) {
            this.this$0 = r1;
            this.searchDirection = r2;
        }

        @Override // org.apache.commons.math3.analysis.UnivariateFunction
        public double value(double r9) {
            double[] r0 = (double[]) NonLinearConjugateGradientOptimizer.access$000(this.this$0).clone();
            int r1 = 0;
            int r2 = 0;
        L4:
            if (r2 >= r0.length) goto L6;
            r0[r2] = r0[r2] + (this.searchDirection[r2] * r9);
            r2 = r2 + 1;
            goto L4
        L6:
            double[] r10 = this.this$0.computeObjectiveGradient(r0);
            double r3 = 0.0d;
        L8:
            if (r1 >= r10.length) goto L10;
            r3 = r3 + (r10[r1] * this.searchDirection[r1]);
            r1 = r1 + 1;
            goto L8
        L10:
            return r3;
        }
    }

    static /* synthetic */ double[] access$000(NonLinearConjugateGradientOptimizer r0) {
        return r0.point;
    }

    @Deprecated
    public NonLinearConjugateGradientOptimizer(ConjugateGradientFormula r2) {
        this(r2, new SimpleValueChecker());
    }

    public NonLinearConjugateGradientOptimizer(ConjugateGradientFormula r3, ConvergenceChecker<PointValuePair> r4) {
        this(r3, r4, new BrentSolver(), new IdentityPreconditioner());
    }

    public NonLinearConjugateGradientOptimizer(ConjugateGradientFormula r2, ConvergenceChecker<PointValuePair> r3, UnivariateSolver r4) {
        this(r2, r3, r4, new IdentityPreconditioner());
    }

    public NonLinearConjugateGradientOptimizer(ConjugateGradientFormula r1, ConvergenceChecker<PointValuePair> r2, UnivariateSolver r3, Preconditioner r4) {
        super(r2);
        this.updateFormula = r1;
        this.solver = r3;
        this.preconditioner = r4;
        this.initialStep = 1.0d;
    }

    public void setInitialStep(double r3) {
        if (r3 > 0.0d) goto L5;
        this.initialStep = 1.0d;
        return;
    L5:
        this.initialStep = r3;
    }

    @Override // org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateOptimizer
    protected PointValuePair doOptimize() {
        ConvergenceChecker<PointValuePair> r7 = getConvergenceChecker();
        this.point = getStartPoint();
        GoalType r8 = getGoalType();
        double[] r0 = this.point;
        int r9 = r0.length;
        double[] r1 = computeObjectiveGradient(r0);
        if (r8 != GoalType.MINIMIZE) goto L7;
        int r2 = 0;
    L5:
        if (r2 >= r9) goto L7;
        r1[r2] = -r1[r2];
        r2 = r2 + 1;
    L7:
        double[] r3 = this.preconditioner.precondition(this.point, r1);
        double[] r4 = (double[]) r3.clone();
        double r5 = 0.0d;
        int r6 = 0;
    L8:
        if (r6 >= r9) goto L10;
        r5 = r5 + (r1[r6] * r4[r6]);
        r6 = r6 + 1;
        goto L8
    L10:
        PointValuePair r10 = null;
        int r22 = getMaxEvaluations();
        double[] r23 = r3;
        double[] r15 = r4;
        double r24 = r5;
        int r11 = 0;
    L11:
        int r14 = r11 + 1;
        PointValuePair r13 = new PointValuePair(this.point, computeObjectiveValue(this.point));
        if (r10 != null) goto L14;
    L16:
        LineSearchFunction r12 = new LineSearchFunction(this, r15);
        double r16 = findUpperBound(r12, 0.0d, this.initialStep);
        r10 = r13;
        double[] r17 = r15;
        double r18 = this.solver.solve(r22, r12, 0.0d, r16, 1.0E-15d);
        r22 = r22 - this.solver.getEvaluations();
        int r19 = 0;
    L17:
        double[] r110 = this.point;
        if (r19 >= r110.length) goto L20;
        r110[r19] = r110[r19] + (r17[r19] * r18);
        r19 = r19 + 1;
        goto L17
    L20:
        double[] r20 = computeObjectiveGradient(r110);
        if (r8 != GoalType.MINIMIZE) goto L25;
        int r21 = 0;
    L23:
        if (r21 >= r9) goto L25;
        r20[r21] = -r20[r21];
        r21 = r21 + 1;
    L25:
        double[] r25 = this.preconditioner.precondition(this.point, r20);
        double r111 = 0.0d;
        int r26 = 0;
    L26:
        if (r26 >= r9) goto L29;
        r111 = r111 + (r20[r26] * r25[r26]);
        r26 = r26 + 1;
        goto L26
    L29:
        if (this.updateFormula != ConjugateGradientFormula.FLETCHER_REEVES) goto L31;
        double r112 = r111 / r24;
    L37:
        if ((r14 % r9) != 0) goto L39;
    L45:
        r15 = (double[]) r25.clone();
    L46:
        r23 = r25;
        r11 = r14;
        r24 = r111;
        goto L11
    L39:
        if (r112 < 0.0d) goto L45;
        int r27 = 0;
    L42:
        if (r27 >= r9) goto L44;
        r17[r27] = r25[r27] + (r17[r27] * r112);
        r27 = r27 + 1;
        goto L42
    L44:
        r15 = r17;
        goto L46
    L31:
        double r113 = 0.0d;
        int r28 = 0;
    L33:
        if (r28 >= r20.length) goto L35;
        r113 = r113 + (r20[r28] * r23[r28]);
        r28 = r28 + 1;
        goto L33
    L35:
        r112 = (r111 - r113) / r24;
        goto L37
    L14:
        if (r7.converged(r14, r10, r13) == false) goto L16;
        return r13;
    }

    private double findUpperBound(UnivariateFunction r11, double r12, double r14) {
        double r0 = r11.value(r12);
    L4:
        if (r14 >= Double.MAX_VALUE) goto L10;
        double r2 = r12 + r14;
        double r4 = r11.value(r2);
        if ((r0 * r4) <= 0.0d) goto L7;
        r14 = r14 * FastMath.max(2.0d, r0 / r4);
        goto L4
    L7:
        return r2;
    L10:
        throw new MathIllegalStateException(LocalizedFormats.UNABLE_TO_BRACKET_OPTIMUM_IN_LINE_SEARCH, new Object[0]);
    }
}
