package org.apache.commons.math3.optim.linear;

import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.math3.exception.TooManyIterationsException;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class SimplexSolver extends LinearOptimizer {
    static final double DEFAULT_CUT_OFF = 1.0E-10d;
    private static final double DEFAULT_EPSILON = 1.0E-6d;
    static final int DEFAULT_ULPS = 10;
    private final double cutOff;
    private final double epsilon;
    private final int maxUlps;
    private PivotSelectionRule pivotSelection;
    private SolutionCallback solutionCallback;

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    public /* bridge */ /* synthetic */ Object doOptimize() {
        return doOptimize();
    }

    @Override // org.apache.commons.math3.optim.linear.LinearOptimizer, org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer, org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public /* bridge */ /* synthetic */ Object optimize(OptimizationData[] r1) {
        return optimize(r1);
    }

    public SimplexSolver() {
        this(1.0E-6d, 10, 1.0E-10d);
    }

    public SimplexSolver(double r7) {
        this(r7, 10, 1.0E-10d);
    }

    public SimplexSolver(double r7, int r9) {
        this(r7, r9, 1.0E-10d);
    }

    public SimplexSolver(double r1, int r3, double r4) {
        this.epsilon = r1;
        this.maxUlps = r3;
        this.cutOff = r4;
        this.pivotSelection = PivotSelectionRule.DANTZIG;
    }

    @Override // org.apache.commons.math3.optim.linear.LinearOptimizer, org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer, org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public PointValuePair optimize(OptimizationData... r1) throws TooManyIterationsException {
        return super.optimize(r1);
    }

    @Override // org.apache.commons.math3.optim.linear.LinearOptimizer, org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer, org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    protected void parseOptimizationData(OptimizationData... r5) {
        super.parseOptimizationData(r5);
        this.solutionCallback = null;
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        OptimizationData r2 = r5[r1];
        if ((r2 instanceof SolutionCallback) == false) goto L8;
        this.solutionCallback = (SolutionCallback) r2;
    L10:
        r1 = r1 + 1;
        goto L3
    L8:
        if ((r2 instanceof PivotSelectionRule) == false) goto L10;
        this.pivotSelection = (PivotSelectionRule) r2;
        goto L10
    }

    private Integer getPivotColumn(SimplexTableau r8) {
        int r0 = r8.getNumObjectiveFunctions();
        double r1 = 0.0d;
        Integer r3 = null;
    L4:
        if (r0 >= (r8.getWidth() - 1)) goto L14;
        double r4 = r8.getEntry(0, r0);
        if (r4 >= r1) goto L13;
        r3 = Integer.valueOf(r0);
        if (this.pivotSelection == PivotSelectionRule.BLAND) goto L10;
    L12:
        r1 = r4;
        goto L13
    L10:
        if (isValidPivotColumn(r8, r0) == false) goto L12;
    L13:
        r0 = r0 + 1;
    L14:
        return r3;
    }

    private boolean isValidPivotColumn(SimplexTableau r9, int r10) {
        int r0 = r9.getNumObjectiveFunctions();
    L4:
        if (r0 >= r9.getHeight()) goto L10;
        if (Precision.compareTo(r9.getEntry(r0, r10), 0.0d, this.cutOff) > 0) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    private Integer getPivotRow(SimplexTableau r18, int r19) {
        ArrayList r2 = new ArrayList();
        int r3 = r18.getNumObjectiveFunctions();
        double r4 = Double.MAX_VALUE;
    L4:
        if (r3 >= r18.getHeight()) goto L13;
        double r6 = r18.getEntry(r3, r18.getWidth() - 1);
        double r15 = r18.getEntry(r3, r19);
        if (Precision.compareTo(r15, 0.0d, this.cutOff) <= 0) goto L12;
        double r7 = FastMath.abs(r6 / r15);
        int r9 = Double.compare(r7, r4);
        if (r9 != 0) goto L10;
        r2.add(Integer.valueOf(r3));
        goto L12
    L10:
        if (r9 >= 0) goto L12;
        r2.clear();
        r2.add(Integer.valueOf(r3));
        r4 = r7;
    L12:
        r3 = r3 + 1;
        goto L4
    L13:
        Integer r5 = null;
        if (r2.size() != 0) goto L17;
        return null;
    L17:
        if (r2.size() <= 1) goto L40;
        if (r18.getNumArtificialVariables() <= 0) goto L32;
        Iterator r8 = r2.iterator();
    L22:
        if (r8.hasNext() == false) goto L32;
        Integer r10 = (Integer) r8.next();
        int r11 = 0;
    L25:
        if (r11 >= r18.getNumArtificialVariables()) goto L22;
        int r12 = r18.getArtificialVariableOffset() + r11;
        if (Precision.equals(r18.getEntry(r10.intValue(), r12), 1.0d, this.maxUlps) == false) goto L31;
        if (r10.equals(r18.getBasicRow(r12)) == false) goto L31;
        return r10;
    L31:
        r11 = r11 + 1;
    L32:
        int r0 = r18.getWidth();
        Iterator r13 = r2.iterator();
    L34:
        if (r13.hasNext() == false) goto L38;
        Integer r14 = (Integer) r13.next();
        int r16 = r18.getBasicVariable(r14.intValue());
        if (r16 >= r0) goto L34;
        r5 = r14;
        r0 = r16;
        goto L34
    L38:
        return r5;
    L40:
        return (Integer) r2.get(0);
    }

    protected void doIteration(SimplexTableau r3) throws TooManyIterationsException, UnboundedSolutionException {
        incrementIterationCount();
        Integer r0 = getPivotColumn(r3);
        Integer r2 = getPivotRow(r3, r0.intValue());
        if (r2 == null) goto L7;
        r3.performRowOperations(r0.intValue(), r2.intValue());
        return;
    L7:
        throw new UnboundedSolutionException();
    }

    protected void solvePhase1(SimplexTableau r9) throws TooManyIterationsException, UnboundedSolutionException, NoFeasibleSolutionException {
        if (r9.getNumArtificialVariables() != 0) goto L6;
        return;
    L6:
        if (r9.isOptimal() == true) goto L9;
        doIteration(r9);
        goto L6
    L9:
        if (Precision.equals(r9.getEntry(0, r9.getRhsOffset()), 0.0d, this.epsilon) == false) goto L12;
        return;
    L12:
        throw new NoFeasibleSolutionException();
    }

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    public PointValuePair doOptimize() throws TooManyIterationsException, UnboundedSolutionException, NoFeasibleSolutionException {
        SolutionCallback r0 = this.solutionCallback;
        if (r0 == null) goto L5;
        r0.setTableau(null);
    L5:
        SimplexTableau r1 = new SimplexTableau(getFunction(), getConstraints(), getGoalType(), isRestrictedToNonNegative(), this.epsilon, this.maxUlps);
        solvePhase1(r1);
        r1.dropPhase1Objective();
        SolutionCallback r2 = this.solutionCallback;
        if (r2 == null) goto L9;
        r2.setTableau(r1);
    L9:
        if (r1.isOptimal() == true) goto L11;
        doIteration(r1);
        goto L9
    L11:
        PointValuePair r3 = r1.getSolution();
        if (isRestrictedToNonNegative() == false) goto L21;
        double[] r4 = r3.getPoint();
        int r5 = 0;
    L15:
        if (r5 >= r4.length) goto L21;
        if (Precision.compareTo(r4[r5], 0.0d, this.epsilon) < 0) goto L20;
        r5 = r5 + 1;
        goto L15
    L20:
        throw new NoFeasibleSolutionException();
    L21:
        return r3;
    }
}
