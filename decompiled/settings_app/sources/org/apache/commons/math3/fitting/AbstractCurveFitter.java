package org.apache.commons.math3.fitting;

import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.math3.analysis.MultivariateMatrixFunction;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresOptimizer;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractCurveFitter {

    protected static class TheoreticalValuesFunction {
        private final ParametricUnivariateFunction f;
        private final double[] points;

        static /* synthetic */ double[] access$000(TheoreticalValuesFunction r0) {
            return r0.points;
        }

        static /* synthetic */ ParametricUnivariateFunction access$100(TheoreticalValuesFunction r0) {
            return r0.f;
        }

        public TheoreticalValuesFunction(ParametricUnivariateFunction r6, Collection<WeightedObservedPoint> r7) {
            this.f = r6;
            this.points = new double[r7.size()];
            Iterator<WeightedObservedPoint> r8 = r7.iterator();
            int r9 = 0;
        L4:
            if (r8.hasNext() == false) goto L6;
            WeightedObservedPoint r0 = r8.next();
            this.points[r9] = r0.getX();
            r9 = r9 + 1;
            goto L4
        }

        public MultivariateVectorFunction getModelFunction() {
            return new AnonymousClass1(this);
        }

        public MultivariateMatrixFunction getModelFunctionJacobian() {
            return new AnonymousClass2(this);
        }
    }

    protected abstract LeastSquaresProblem getProblem(Collection<WeightedObservedPoint> r1);

    public AbstractCurveFitter() {
    }

    public double[] fit(Collection<WeightedObservedPoint> r2) {
        return getOptimizer().optimize(getProblem(r2)).getPoint().toArray();
    }

    protected LeastSquaresOptimizer getOptimizer() {
        return new LevenbergMarquardtOptimizer();
    }
}
