package org.apache.commons.math3.optimization.general;

import java.lang.reflect.Array;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.BlockRealMatrix;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.SingularMatrixException;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.PointVectorValuePair;
import org.apache.commons.math3.optimization.SimpleVectorValueChecker;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class GaussNewtonOptimizer extends AbstractLeastSquaresOptimizer {
    private final boolean useLU;

    @Deprecated
    public GaussNewtonOptimizer() {
        this(true);
    }

    public GaussNewtonOptimizer(ConvergenceChecker<PointVectorValuePair> r2) {
        this(true, r2);
    }

    @Deprecated
    public GaussNewtonOptimizer(boolean r2) {
        this(r2, new SimpleVectorValueChecker());
    }

    public GaussNewtonOptimizer(boolean r1, ConvergenceChecker<PointVectorValuePair> r2) {
        super(r2);
        this.useLU = r1;
    }

    @Override // org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateVectorOptimizer
    public PointVectorValuePair doOptimize() {
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
        int r11 = 0;
    L8:
        if (r10 == true) goto L39;
        r11 = r11 + 1;
        double[] r12 = computeObjectiveValue(r7);
        double[] r13 = computeResiduals(r12);
        RealMatrix r14 = computeWeightedJacobian(r7);
        PointVectorValuePair r15 = new PointVectorValuePair(r7, r12);
        double[] r16 = new double[r8];
        int[] r17 = new int[2];
        r17[1] = r8;
        r17[r5] = r8;
        double[][] r18 = (double[][]) Array.newInstance(Double.TYPE, r17);
        int r19 = r5;
    L10:
        if (r19 >= r2) goto L21;
        double[] r110 = r14.getRow(r19);
        double r111 = r4[r19];
        double r112 = r13[r19] * r111;
    L12:
        if (r5 >= r8) goto L14;
        r16[r5] = r16[r5] + (r110[r5] * r112);
        r5 = r5 + 1;
        goto L12
    L14:
        int r20 = 0;
    L15:
        if (r20 >= r8) goto L20;
        double[] r113 = r18[r20];
        double r21 = r110[r20] * r111;
        int r22 = r2;
        int r23 = 0;
    L17:
        if (r23 >= r8) goto L19;
        r113[r23] = r113[r23] + (r110[r23] * r21);
        r23 = r23 + 1;
        goto L17
    L19:
        r20 = r20 + 1;
        r2 = r22;
        goto L15
    L20:
        r19 = r19 + 1;
        r5 = 0;
        goto L10
    L21:
        int r24 = r2;
        BlockRealMatrix r25 = new BlockRealMatrix(r18);     // Catch: SingularMatrixException -> L36
        if (this.useLU == false) goto L25;
        DecompositionSolver r26 = new LUDecomposition(r25).getSolver();     // Catch: SingularMatrixException -> L36
    L26:
        double[] r27 = r26.solve(new ArrayRealVector(r16, false)).toArray();     // Catch: SingularMatrixException -> L36
        int r114 = 0;
    L27:
        if (r114 >= r8) goto L30;
        r7[r114] = r7[r114] + r27[r114];     // Catch: SingularMatrixException -> L36
        r114 = r114 + 1;
        goto L27
    L30:
        if (r9 == null) goto L35;
        r10 = r1.converged(r11, r9, r15);
        if (r10 == false) goto L35;
        this.cost = computeCost(r13);
        this.point = r15.getPoint();
        return r15;
    L35:
        r9 = r15;
        r2 = r24;
        r5 = 0;
        goto L8
    L25:
        r26 = new QRDecomposition(r25).getSolver();     // Catch: SingularMatrixException -> L36
    L37:
        throw new ConvergenceException(LocalizedFormats.UNABLE_TO_SOLVE_SINGULAR_PROBLEM, new Object[0]);
    L39:
        throw new MathInternalError();
    L41:
        throw new NullArgumentException();
    }
}
