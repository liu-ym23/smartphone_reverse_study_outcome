package org.apache.commons.math3.optim.nonlinear.scalar.gradient;

import org.apache.commons.math3.analysis.solvers.UnivariateSolver;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.optim.nonlinear.scalar.GradientMultivariateOptimizer;
import org.apache.commons.math3.optim.nonlinear.scalar.LineSearch;

/* JADX INFO: loaded from: classes6.dex */
public class NonLinearConjugateGradientOptimizer extends GradientMultivariateOptimizer {
    private final LineSearch line;
    private final Preconditioner preconditioner;
    private final Formula updateFormula;

    /* JADX INFO: renamed from: org.apache.commons.math3.optim.nonlinear.scalar.gradient.NonLinearConjugateGradientOptimizer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$optim$nonlinear$scalar$gradient$NonLinearConjugateGradientOptimizer$Formula = null;

        static {
            int[] r0 = new int[Formula.values().length];
            $SwitchMap$org$apache$commons$math3$optim$nonlinear$scalar$gradient$NonLinearConjugateGradientOptimizer$Formula = r0;
            r0[Formula.FLETCHER_REEVES.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$org$apache$commons$math3$optim$nonlinear$scalar$gradient$NonLinearConjugateGradientOptimizer$Formula[Formula.POLAK_RIBIERE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    @Deprecated
    public static class BracketingStep implements OptimizationData {
        private final double initialStep;

        public BracketingStep(double r1) {
            this.initialStep = r1;
        }

        public double getBracketingStep() {
            return this.initialStep;
        }
    }

    public static final enum Formula extends Enum<Formula> {
        private static final /* synthetic */ Formula[] $VALUES = null;
        public static final Formula FLETCHER_REEVES = null;
        public static final Formula POLAK_RIBIERE = null;

        private Formula(String r1, int r2) {
            super(r1, r2);
        }

        public static Formula valueOf(String r1) {
            return (Formula) Enum.valueOf(Formula.class, r1);
        }

        public static Formula[] values() {
            return (Formula[]) $VALUES.clone();
        }

        static {
            Formula r0 = new Formula("FLETCHER_REEVES", 0);
            FLETCHER_REEVES = r0;
            Formula r1 = new Formula("POLAK_RIBIERE", 1);
            POLAK_RIBIERE = r1;
            $VALUES = new Formula[]{r0, r1};
        }
    }

    public static class IdentityPreconditioner implements Preconditioner {
        public IdentityPreconditioner() {
        }

        @Override // org.apache.commons.math3.optim.nonlinear.scalar.gradient.Preconditioner
        public double[] precondition(double[] r1, double[] r2) {
            return (double[]) r2.clone();
        }
    }

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    protected /* bridge */ /* synthetic */ Object doOptimize() {
        return doOptimize();
    }

    @Override // org.apache.commons.math3.optim.nonlinear.scalar.GradientMultivariateOptimizer, org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer, org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public /* bridge */ /* synthetic */ Object optimize(OptimizationData[] r1) {
        return optimize(r1);
    }

    public NonLinearConjugateGradientOptimizer(Formula r11, ConvergenceChecker<PointValuePair> r12) {
        this(r11, r12, 1.0E-8d, 1.0E-8d, 1.0E-8d, new IdentityPreconditioner());
    }

    @Deprecated
    public NonLinearConjugateGradientOptimizer(Formula r2, ConvergenceChecker<PointValuePair> r3, UnivariateSolver r4) {
        this(r2, r3, r4, new IdentityPreconditioner());
    }

    public NonLinearConjugateGradientOptimizer(Formula r11, ConvergenceChecker<PointValuePair> r12, double r13, double r15, double r17) {
        this(r11, r12, r13, r15, r17, new IdentityPreconditioner());
    }

    @Deprecated
    public NonLinearConjugateGradientOptimizer(Formula r11, ConvergenceChecker<PointValuePair> r12, UnivariateSolver r13, Preconditioner r14) {
        this(r11, r12, r13.getRelativeAccuracy(), r13.getAbsoluteAccuracy(), r13.getAbsoluteAccuracy(), r14);
    }

    public NonLinearConjugateGradientOptimizer(Formula r11, ConvergenceChecker<PointValuePair> r12, double r13, double r15, double r17, Preconditioner r19) {
        super(r12);
        this.updateFormula = r11;
        this.preconditioner = r19;
        this.line = new LineSearch(this, r13, r15, r17);
    }

    @Override // org.apache.commons.math3.optim.nonlinear.scalar.GradientMultivariateOptimizer, org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer, org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public PointValuePair optimize(OptimizationData... r1) throws TooManyEvaluationsException {
        return super.optimize(r1);
    }

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    protected PointValuePair doOptimize() {
        ConvergenceChecker<PointValuePair> r1 = getConvergenceChecker();
        double[] r2 = getStartPoint();
        GoalType r3 = getGoalType();
        int r4 = r2.length;
        double[] r5 = computeObjectiveGradient(r2);
        if (r3 != GoalType.MINIMIZE) goto L7;
        int r6 = 0;
    L5:
        if (r6 >= r4) goto L7;
        r5[r6] = -r5[r6];
        r6 = r6 + 1;
    L7:
        double[] r7 = this.preconditioner.precondition(r2, r5);
        double[] r8 = (double[]) r7.clone();
        int r11 = 0;
        double r12 = 0.0d;
    L8:
        if (r11 >= r4) goto L10;
        r12 = r12 + (r5[r11] * r8[r11]);
        r11 = r11 + 1;
        goto L8
    L10:
        PointValuePair r9 = null;
    L11:
        incrementIterationCount();
        PointValuePair r13 = new PointValuePair(r2, computeObjectiveValue(r2));
        if (r9 != null) goto L14;
    L16:
        double r14 = this.line.search(r2, r8).getPoint();
        int r10 = 0;
    L18:
        if (r10 >= r2.length) goto L20;
        r2[r10] = r2[r10] + (r8[r10] * r14);
        r10 = r10 + 1;
        goto L18
    L20:
        double[] r15 = computeObjectiveGradient(r2);
        if (r3 != GoalType.MINIMIZE) goto L25;
        int r16 = 0;
    L23:
        if (r16 >= r4) goto L25;
        r15[r16] = -r15[r16];
        r16 = r16 + 1;
    L25:
        double[] r17 = this.preconditioner.precondition(r2, r15);
        int r18 = 0;
        double r19 = 0.0d;
    L26:
        if (r18 >= r4) goto L28;
        r19 = r19 + (r15[r18] * r17[r18]);
        r18 = r18 + 1;
        goto L26
    L28:
        int r20 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$optim$nonlinear$scalar$gradient$NonLinearConjugateGradientOptimizer$Formula[this.updateFormula.ordinal()];
        if (r20 != 1) goto L31;
        double r21 = r19 / r12;
    L41:
        if ((getIterations() % r4) == 0) goto L49;
        if (r21 < 0.0d) goto L49;
        int r110 = 0;
    L46:
        if (r110 >= r4) goto L50;
        r8[r110] = r17[r110] + (r8[r110] * r21);
        r110 = r110 + 1;
    L50:
        r7 = r17;
        r9 = r13;
        r12 = r19;
    L49:
        r8 = (double[]) r17.clone();
        goto L50
    L31:
        if (r20 != 2) goto L38;
        int r22 = 0;
        double r111 = 0.0d;
    L34:
        if (r22 >= r15.length) goto L36;
        r111 = r111 + (r15[r22] * r7[r22]);
        r22 = r22 + 1;
        goto L34
    L36:
        r21 = (r19 - r111) / r12;
        goto L41
    L38:
        throw new MathInternalError();
    L14:
        if (r1.converged(getIterations(), r9, r13) == false) goto L16;
        return r13;
    }

    @Override // org.apache.commons.math3.optim.nonlinear.scalar.GradientMultivariateOptimizer, org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer, org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    protected void parseOptimizationData(OptimizationData... r1) {
        super.parseOptimizationData(r1);
        checkParameters();
    }

    private void checkParameters() {
        if (getLowerBound() != null) goto L8;
        if (getUpperBound() != null) goto L8;
        return;
    L8:
        throw new MathUnsupportedOperationException(LocalizedFormats.CONSTRAINT, new Object[0]);
    }
}
