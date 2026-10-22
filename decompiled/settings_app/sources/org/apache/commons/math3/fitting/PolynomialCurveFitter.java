package org.apache.commons.math3.fitting;

import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresBuilder;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem;
import org.apache.commons.math3.linear.DiagonalMatrix;

/* JADX INFO: loaded from: classes6.dex */
public class PolynomialCurveFitter extends AbstractCurveFitter {
    private static final PolynomialFunction.Parametric FUNCTION = null;
    private final double[] initialGuess;
    private final int maxIter;

    static {
        FUNCTION = new PolynomialFunction.Parametric();
    }

    private PolynomialCurveFitter(double[] r1, int r2) {
        this.initialGuess = r1;
        this.maxIter = r2;
    }

    public static PolynomialCurveFitter create(int r2) {
        return new PolynomialCurveFitter(new double[r2 + 1], Integer.MAX_VALUE);
    }

    public PolynomialCurveFitter withStartPoint(double[] r2) {
        return new PolynomialCurveFitter((double[]) r2.clone(), this.maxIter);
    }

    public PolynomialCurveFitter withMaxIterations(int r2) {
        return new PolynomialCurveFitter(this.initialGuess, r2);
    }

    @Override // org.apache.commons.math3.fitting.AbstractCurveFitter
    protected LeastSquaresProblem getProblem(Collection<WeightedObservedPoint> r8) {
        int r0 = r8.size();
        double[] r1 = new double[r0];
        double[] r2 = new double[r0];
        Iterator<WeightedObservedPoint> r3 = r8.iterator();
        int r4 = 0;
    L4:
        if (r3.hasNext() == false) goto L6;
        WeightedObservedPoint r5 = r3.next();
        r1[r4] = r5.getY();
        r2[r4] = r5.getWeight();
        r4 = r4 + 1;
        goto L4
    L6:
        AbstractCurveFitter.TheoreticalValuesFunction r6 = new AbstractCurveFitter.TheoreticalValuesFunction(FUNCTION, r8);
        if (this.initialGuess == null) goto L11;
        return new LeastSquaresBuilder().maxEvaluations(Integer.MAX_VALUE).maxIterations(this.maxIter).start(this.initialGuess).target(r1).weight(new DiagonalMatrix(r2)).model(r6.getModelFunction(), r6.getModelFunctionJacobian()).build();
    L11:
        throw new MathInternalError();
    }
}
