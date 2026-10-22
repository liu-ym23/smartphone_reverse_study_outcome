package org.apache.commons.math3.fitting;

import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresBuilder;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem;
import org.apache.commons.math3.linear.DiagonalMatrix;

/* JADX INFO: loaded from: classes6.dex */
public class SimpleCurveFitter extends AbstractCurveFitter {
    private final ParametricUnivariateFunction function;
    private final double[] initialGuess;
    private final int maxIter;

    private SimpleCurveFitter(ParametricUnivariateFunction r1, double[] r2, int r3) {
        this.function = r1;
        this.initialGuess = r2;
        this.maxIter = r3;
    }

    public static SimpleCurveFitter create(ParametricUnivariateFunction r2, double[] r3) {
        return new SimpleCurveFitter(r2, r3, Integer.MAX_VALUE);
    }

    public SimpleCurveFitter withStartPoint(double[] r3) {
        return new SimpleCurveFitter(this.function, (double[]) r3.clone(), this.maxIter);
    }

    public SimpleCurveFitter withMaxIterations(int r3) {
        return new SimpleCurveFitter(this.function, this.initialGuess, r3);
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
        AbstractCurveFitter.TheoreticalValuesFunction r6 = new AbstractCurveFitter.TheoreticalValuesFunction(this.function, r8);
        return new LeastSquaresBuilder().maxEvaluations(Integer.MAX_VALUE).maxIterations(this.maxIter).start(this.initialGuess).target(r1).weight(new DiagonalMatrix(r2)).model(r6.getModelFunction(), r6.getModelFunctionJacobian()).build();
    }
}
