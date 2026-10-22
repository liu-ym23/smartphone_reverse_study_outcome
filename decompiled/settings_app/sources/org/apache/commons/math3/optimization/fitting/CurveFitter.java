package org.apache.commons.math3.optimization.fitting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.analysis.DifferentiableMultivariateVectorFunction;
import org.apache.commons.math3.analysis.MultivariateMatrixFunction;
import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableVectorFunction;
import org.apache.commons.math3.optimization.DifferentiableMultivariateVectorOptimizer;
import org.apache.commons.math3.optimization.MultivariateDifferentiableVectorOptimizer;
import org.apache.commons.math3.optimization.PointVectorValuePair;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class CurveFitter<T extends ParametricUnivariateFunction> {
    private final List<WeightedObservedPoint> observations;

    @Deprecated
    private final DifferentiableMultivariateVectorOptimizer oldOptimizer;
    private final MultivariateDifferentiableVectorOptimizer optimizer;

    @Deprecated
    private class OldTheoreticalValuesFunction implements DifferentiableMultivariateVectorFunction {
        private final ParametricUnivariateFunction f;
        final /* synthetic */ CurveFitter this$0;

        static /* synthetic */ ParametricUnivariateFunction access$100(OldTheoreticalValuesFunction r0) {
            return r0.f;
        }

        OldTheoreticalValuesFunction(CurveFitter r1, ParametricUnivariateFunction r2) {
            this.this$0 = r1;
            this.f = r2;
        }

        @Override // org.apache.commons.math3.analysis.DifferentiableMultivariateVectorFunction
        public MultivariateMatrixFunction jacobian() {
            return new AnonymousClass1(this);
        }

        @Override // org.apache.commons.math3.analysis.MultivariateVectorFunction
        public double[] value(double[] r9) {
            double[] r0 = new double[CurveFitter.access$000(this.this$0).size()];
            Iterator r1 = CurveFitter.access$000(this.this$0).iterator();
            int r2 = 0;
        L4:
            if (r1.hasNext() == false) goto L6;
            WeightedObservedPoint r3 = (WeightedObservedPoint) r1.next();
            r0[r2] = this.f.value(r3.getX(), r9);
            r2 = r2 + 1;
            goto L4
        L6:
            return r0;
        }
    }

    private class TheoreticalValuesFunction implements MultivariateDifferentiableVectorFunction {
        private final ParametricUnivariateFunction f;
        final /* synthetic */ CurveFitter this$0;

        TheoreticalValuesFunction(CurveFitter r1, ParametricUnivariateFunction r2) {
            this.this$0 = r1;
            this.f = r2;
        }

        @Override // org.apache.commons.math3.analysis.MultivariateVectorFunction
        public double[] value(double[] r9) {
            double[] r0 = new double[CurveFitter.access$000(this.this$0).size()];
            Iterator r1 = CurveFitter.access$000(this.this$0).iterator();
            int r2 = 0;
        L4:
            if (r1.hasNext() == false) goto L6;
            WeightedObservedPoint r3 = (WeightedObservedPoint) r1.next();
            r0[r2] = this.f.value(r3.getX(), r9);
            r2 = r2 + 1;
            goto L4
        L6:
            return r0;
        }

        @Override // org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableVectorFunction
        public DerivativeStructure[] value(DerivativeStructure[] r15) {
            double[] r0 = new double[r15.length];
            int r2 = 0;
        L4:
            if (r2 >= r15.length) goto L6;
            r0[r2] = r15[r2].getValue();
            r2 = r2 + 1;
            goto L4
        L6:
            DerivativeStructure[] r3 = new DerivativeStructure[CurveFitter.access$000(this.this$0).size()];
            Iterator r4 = CurveFitter.access$000(this.this$0).iterator();
            int r5 = 0;
        L8:
            if (r4.hasNext() == false) goto L14;
            DerivativeStructure r6 = new DerivativeStructure(r15.length, 1, this.f.value(((WeightedObservedPoint) r4.next()).getX(), r0));
            int r7 = 0;
        L11:
            if (r7 >= r15.length) goto L13;
            r6 = r6.add(new DerivativeStructure(r15.length, 1, r7, 0.0d));
            r7 = r7 + 1;
            goto L11
        L13:
            r3[r5] = r6;
            r5 = r5 + 1;
            goto L8
        L14:
            return r3;
        }
    }

    static /* synthetic */ List access$000(CurveFitter r0) {
        return r0.observations;
    }

    @Deprecated
    public CurveFitter(DifferentiableMultivariateVectorOptimizer r1) {
        this.oldOptimizer = r1;
        this.optimizer = null;
        this.observations = new ArrayList();
    }

    public CurveFitter(MultivariateDifferentiableVectorOptimizer r2) {
        this.oldOptimizer = null;
        this.optimizer = r2;
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

    public double[] fit(int r9, T r10, double[] r11) {
        double[] r4 = new double[this.observations.size()];
        double[] r5 = new double[this.observations.size()];
        Iterator<WeightedObservedPoint> r0 = this.observations.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        WeightedObservedPoint r2 = r0.next();
        r4[r1] = r2.getY();
        r5[r1] = r2.getWeight();
        r1 = r1 + 1;
        goto L4
    L6:
        MultivariateDifferentiableVectorOptimizer r3 = this.optimizer;
        if (r3 != null) goto L9;
        PointVectorValuePair r8 = this.oldOptimizer.optimize(r9, new OldTheoreticalValuesFunction(this, r10), r4, r5, r11);
    L11:
        return r8.getPointRef();
    L9:
        r8 = r3.optimize(r9, new TheoreticalValuesFunction(this, r10), r4, r5, r11);
        goto L11
    }
}
