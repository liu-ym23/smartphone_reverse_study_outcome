package org.apache.commons.math3.fitting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.optim.InitialGuess;
import org.apache.commons.math3.optim.MaxEval;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.nonlinear.vector.ModelFunction;
import org.apache.commons.math3.optim.nonlinear.vector.ModelFunctionJacobian;
import org.apache.commons.math3.optim.nonlinear.vector.MultivariateVectorOptimizer;
import org.apache.commons.math3.optim.nonlinear.vector.Target;
import org.apache.commons.math3.optim.nonlinear.vector.Weight;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class CurveFitter<T extends ParametricUnivariateFunction> {
    private final List<WeightedObservedPoint> observations;
    private final MultivariateVectorOptimizer optimizer;

    private class TheoreticalValuesFunction {
        private final ParametricUnivariateFunction f;
        final /* synthetic */ CurveFitter this$0;

        static /* synthetic */ ParametricUnivariateFunction access$100(TheoreticalValuesFunction r0) {
            return r0.f;
        }

        TheoreticalValuesFunction(CurveFitter r1, ParametricUnivariateFunction r2) {
            this.this$0 = r1;
            this.f = r2;
        }

        public ModelFunction getModelFunction() {
            return new ModelFunction(new AnonymousClass1(this));
        }

        public ModelFunctionJacobian getModelFunctionJacobian() {
            return new ModelFunctionJacobian(new AnonymousClass2(this));
        }
    }

    static /* synthetic */ List access$000(CurveFitter r0) {
        return r0.observations;
    }

    public CurveFitter(MultivariateVectorOptimizer r1) {
        this.optimizer = r1;
        this.observations = new ArrayList();
    }

    public void addObservedPoint(double r8, double r10) {
        addObservedPoint(1.0d, r8, r10);
    }

    public void addObservedPoint(double r9, double r11, double r13) {
        this.observations.add(new WeightedObservedPoint(r9, r11, r13));
    }

    public void addObservedPoint(WeightedObservedPoint r1) {
        this.observations.add(r1);
    }

    public WeightedObservedPoint[] getObservations() {
        List<WeightedObservedPoint> r1 = this.observations;
        return (WeightedObservedPoint[]) r1.toArray(new WeightedObservedPoint[r1.size()]);
    }

    public void clearObservations() {
        this.observations.clear();
    }

    public double[] fit(T r2, double[] r3) {
        return fit(Integer.MAX_VALUE, r2, r3);
    }

    public double[] fit(int r10, T r11, double[] r12) {
        double[] r0 = new double[this.observations.size()];
        double[] r1 = new double[this.observations.size()];
        Iterator<WeightedObservedPoint> r2 = this.observations.iterator();
        int r4 = 0;
    L4:
        if (r2.hasNext() == false) goto L6;
        WeightedObservedPoint r5 = r2.next();
        r0[r4] = r5.getY();
        r1[r4] = r5.getWeight();
        r4 = r4 + 1;
        goto L4
    L6:
        TheoreticalValuesFunction r3 = new TheoreticalValuesFunction(this, r11);
        return this.optimizer.optimize(new OptimizationData[]{new MaxEval(r10), r3.getModelFunction(), r3.getModelFunctionJacobian(), new Target(r0), new Weight(r1), new InitialGuess(r12)}).getPointRef();
    }
}
