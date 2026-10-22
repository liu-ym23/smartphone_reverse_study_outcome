package org.apache.commons.math3.optim.nonlinear.vector.jacobian;

import java.lang.reflect.Array;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.BlockRealMatrix;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.SingularMatrixException;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.PointVectorValuePair;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class GaussNewtonOptimizer extends AbstractLeastSquaresOptimizer {
    private final boolean useLU;

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    public /* bridge */ /* synthetic */ Object doOptimize() {
        return doOptimize();
    }

    public GaussNewtonOptimizer(ConvergenceChecker<PointVectorValuePair> r2) {
        this(true, r2);
    }

    public GaussNewtonOptimizer(boolean r1, ConvergenceChecker<PointVectorValuePair> r2) {
        super(r2);
        this.useLU = r1;
    }

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    public PointVectorValuePair doOptimize() {
        checkParameters();
        ConvergenceChecker<PointVectorValuePair> r1 = getConvergenceChecker();
        if (r1 == null) goto L41;
        int r2 = getTarget().length;
        RealMatrix r3 = getWeight();
        double[] r4 = new double[r2];
        int r5 = 0;
        int r6 = 0;
    L5:
        if (r6 >= r2) goto L7;
        r4[r6] = r3.getEntry(r6, r6);
        r6 = r6 + 1;
        goto L5
    L7:
        double[] r7 = getStartPoint();
        int r8 = r7.length;
        PointVectorValuePair r9 = null;
        boolean r10 = false;
    L8:
        if (r10 == true) goto L39;
        incrementIterationCount();
        double[] r11 = computeObjectiveValue(r7);
        double[] r12 = computeResiduals(r11);
        RealMatrix r13 = computeWeightedJacobian(r7);
        PointVectorValuePair r14 = new PointVectorValuePair(r7, r11);
        double[] r15 = new double[r8];
        int[] r16 = new int[2];
        r16[1] = r8;
        r16[r5] = r8;
        double[][] r17 = (double[][]) Array.newInstance(Double.TYPE, r16);
        int r18 = r5;
    L10:
        if (r18 >= r2) goto L21;
        double[] r19 = r13.getRow(r18);
        double r110 = r4[r18];
        double r111 = r12[r18] * r110;
    L12:
        if (r5 >= r8) goto L14;
        r15[r5] = r15[r5] + (r19[r5] * r111);
        r5 = r5 + 1;
        goto L12
    L14:
        int r20 = 0;
    L15:
        if (r20 >= r8) goto L20;
        double[] r112 = r17[r20];
        double r21 = r19[r20] * r110;
        int r113 = r2;
        int r22 = 0;
    L17:
        if (r22 >= r8) goto L19;
        r112[r22] = r112[r22] + (r19[r22] * r21);
        r22 = r22 + 1;
        goto L17
    L19:
        r20 = r20 + 1;
        r2 = r113;
        goto L15
    L20:
        r18 = r18 + 1;
        r5 = 0;
        goto L10
    L21:
        int r114 = r2;
        if (r9 == null) goto L42;
        r10 = r1.converged(getIterations(), r9, r14);
        if (r10 == false) goto L42;
        setCost(computeCost(r12));
        return r14;
    L42:
        BlockRealMatrix r23 = new BlockRealMatrix(r17);     // Catch: SingularMatrixException -> L36
        if (this.useLU == false) goto L30;
        DecompositionSolver r24 = new LUDecomposition(r23).getSolver();     // Catch: SingularMatrixException -> L36
    L31:
        double[] r25 = r24.solve(new ArrayRealVector(r15, false)).toArray();     // Catch: SingularMatrixException -> L36
        int r26 = 0;
    L32:
        if (r26 >= r8) goto L35;
        r7[r26] = r7[r26] + r25[r26];     // Catch: SingularMatrixException -> L36
        r26 = r26 + 1;
        goto L32
    L35:
        r9 = r14;
        r2 = r114;
        r5 = 0;
        goto L8
    L30:
        r24 = new QRDecomposition(r23).getSolver();     // Catch: SingularMatrixException -> L36
    L37:
        throw new ConvergenceException(LocalizedFormats.UNABLE_TO_SOLVE_SINGULAR_PROBLEM, new Object[0]);
    L39:
        throw new MathInternalError();
    L41:
        throw new NullArgumentException();
    }

    private void checkParameters() {
        if (getLowerBound() != null) goto L8;
        if (getUpperBound() != null) goto L8;
        return;
    L8:
        throw new MathUnsupportedOperationException(LocalizedFormats.CONSTRAINT, new Object[0]);
    }
}
