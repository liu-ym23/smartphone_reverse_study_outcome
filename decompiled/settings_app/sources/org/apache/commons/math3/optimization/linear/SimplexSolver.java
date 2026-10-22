package org.apache.commons.math3.optimization.linear;

import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class SimplexSolver extends AbstractLinearOptimizer {
    private static final double DEFAULT_EPSILON = 1.0E-6d;
    private static final int DEFAULT_ULPS = 10;
    private final double epsilon;
    private final int maxUlps;

    public SimplexSolver() {
        this(1.0E-6d, 10);
    }

    public SimplexSolver(double r1, int r3) {
        this.epsilon = r1;
        this.maxUlps = r3;
    }

    private Integer getPivotColumn(SimplexTableau r7) {
        int r6 = r7.getNumObjectiveFunctions();
        double r0 = 0.0d;
        Integer r2 = null;
    L4:
        if (r6 >= (r7.getWidth() - 1)) goto L9;
        double r3 = r7.getEntry(0, r6);
        if (r3 >= r0) goto L8;
        r2 = Integer.valueOf(r6);
        r0 = r3;
    L8:
        r6 = r6 + 1;
        goto L4
    L9:
        return r2;
    }

    private Integer getPivotRow(SimplexTableau r13, int r14) {
        ArrayList r0 = new ArrayList();
        int r1 = r13.getNumObjectiveFunctions();
        double r2 = Double.MAX_VALUE;
    L4:
        if (r1 >= r13.getHeight()) goto L13;
        double r4 = r13.getEntry(r1, r13.getWidth() - 1);
        double r6 = r13.getEntry(r1, r14);
        if (Precision.compareTo(r6, 0.0d, this.maxUlps) <= 0) goto L12;
        double r5 = r4 / r6;
        int r7 = Double.compare(r5, r2);
        if (r7 != 0) goto L10;
        r0.add(Integer.valueOf(r1));
        goto L12
    L10:
        if (r7 >= 0) goto L12;
        r0 = new ArrayList();
        r0.add(Integer.valueOf(r1));
        r2 = r5;
    L12:
        r1 = r1 + 1;
        goto L4
    L13:
        Integer r3 = null;
        if (r0.size() != 0) goto L17;
        return null;
    L17:
        if (r0.size() <= 1) goto L50;
        if (r13.getNumArtificialVariables() <= 0) goto L33;
        Iterator r15 = r0.iterator();
    L22:
        if (r15.hasNext() == false) goto L33;
        Integer r8 = (Integer) r15.next();
        int r9 = 0;
    L25:
        if (r9 >= r13.getNumArtificialVariables()) goto L22;
        int r10 = r13.getArtificialVariableOffset() + r9;
        if (Precision.equals(r13.getEntry(r8.intValue(), r10), 1.0d, this.maxUlps) == false) goto L31;
        if (r8.equals(r13.getBasicRow(r10)) == false) goto L31;
        return r8;
    L31:
        r9 = r9 + 1;
    L33:
        if (getIterations() >= (getMaxIterations() / 2)) goto L50;
        int r12 = r13.getWidth();
        int r16 = r13.getNumObjectiveFunctions();
        int r11 = r13.getWidth() - 1;
        Iterator r17 = r0.iterator();
    L36:
        if (r17.hasNext() == false) goto L48;
        Integer r18 = (Integer) r17.next();
        int r19 = r16;
    L38:
        if (r19 >= r11) goto L36;
        if (r18.equals(r3) == true) goto L36;
        Integer r20 = r13.getBasicRow(r19);
        if (r20 == null) goto L47;
        if (r20.equals(r18) == false) goto L47;
        if (r19 >= r12) goto L47;
        r3 = r18;
        r12 = r19;
    L47:
        r19 = r19 + 1;
        goto L38
    L48:
        return r3;
    L50:
        return (Integer) r0.get(0);
    }

    protected void doIteration(SimplexTableau r6) throws MaxCountExceededException, UnboundedSolutionException {
        incrementIterationsCounter();
        Integer r0 = getPivotColumn(r6);
        Integer r5 = getPivotRow(r6, r0.intValue());
        if (r5 == null) goto L13;
        double r1 = r6.getEntry(r5.intValue(), r0.intValue());
        r6.divideRow(r5.intValue(), r1);
        int r2 = 0;
    L6:
        if (r2 >= r6.getHeight()) goto L11;
        if (r2 == r5.intValue()) goto L10;
        double r3 = r6.getEntry(r2, r0.intValue());
        r6.subtractRow(r2, r5.intValue(), r3);
    L10:
        r2 = r2 + 1;
        goto L6
    L11:
        return;
    L13:
        throw new UnboundedSolutionException();
    }

    protected void solvePhase1(SimplexTableau r9) throws MaxCountExceededException, UnboundedSolutionException, NoFeasibleSolutionException {
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

    @Override // org.apache.commons.math3.optimization.linear.AbstractLinearOptimizer
    public PointValuePair doOptimize() throws MaxCountExceededException, UnboundedSolutionException, NoFeasibleSolutionException {
        SimplexTableau r8 = new SimplexTableau(getFunction(), getConstraints(), getGoalType(), restrictToNonNegative(), this.epsilon, this.maxUlps);
        solvePhase1(r8);
        r8.dropPhase1Objective();
    L4:
        if (r8.isOptimal() == true) goto L7;
        doIteration(r8);
        goto L4
    L7:
        return r8.getSolution();
    }
}
