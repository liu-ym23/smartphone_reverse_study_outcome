package org.apache.commons.math3.fitting.leastsquares;

import org.apache.commons.math3.analysis.MultivariateMatrixFunction;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DiagonalMatrix;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.optim.AbstractOptimizationProblem;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.PointVectorValuePair;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Incrementor;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
public class LeastSquaresFactory {

    private static class LocalLeastSquaresProblem extends AbstractOptimizationProblem<LeastSquaresProblem.Evaluation> implements LeastSquaresProblem {
        private final boolean lazyEvaluation;
        private final MultivariateJacobianFunction model;
        private final ParameterValidator paramValidator;
        private final RealVector start;
        private final RealVector target;

        private static class LazyUnweightedEvaluation extends AbstractEvaluation {
            private final ValueAndJacobianFunction model;
            private final RealVector point;
            private final RealVector target;

            /* synthetic */ LazyUnweightedEvaluation(ValueAndJacobianFunction r1, RealVector r2, RealVector r3, AnonymousClass1 r4) {
                this(r1, r2, r3);
            }

            private LazyUnweightedEvaluation(ValueAndJacobianFunction r2, RealVector r3, RealVector r4) {
                super(r3.getDimension());
                this.model = r2;
                this.point = r4;
                this.target = r3;
            }

            @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem.Evaluation
            public RealMatrix getJacobian() {
                return this.model.computeJacobian(this.point.toArray());
            }

            @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem.Evaluation
            public RealVector getPoint() {
                return this.point;
            }

            @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem.Evaluation
            public RealVector getResiduals() {
                return this.target.subtract(this.model.computeValue(this.point.toArray()));
            }
        }

        private static class UnweightedEvaluation extends AbstractEvaluation {
            private final RealMatrix jacobian;
            private final RealVector point;
            private final RealVector residuals;

            /* synthetic */ UnweightedEvaluation(RealVector r1, RealMatrix r2, RealVector r3, RealVector r4, AnonymousClass1 r5) {
                this(r1, r2, r3, r4);
            }

            private UnweightedEvaluation(RealVector r2, RealMatrix r3, RealVector r4, RealVector r5) {
                super(r4.getDimension());
                this.jacobian = r3;
                this.point = r5;
                this.residuals = r4.subtract(r2);
            }

            @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem.Evaluation
            public RealMatrix getJacobian() {
                return this.jacobian;
            }

            @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem.Evaluation
            public RealVector getPoint() {
                return this.point;
            }

            @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem.Evaluation
            public RealVector getResiduals() {
                return this.residuals;
            }
        }

        LocalLeastSquaresProblem(MultivariateJacobianFunction r1, RealVector r2, RealVector r3, ConvergenceChecker<LeastSquaresProblem.Evaluation> r4, int r5, int r6, boolean r7, ParameterValidator r8) {
            super(r5, r6, r4);
            this.target = r2;
            this.model = r1;
            this.start = r3;
            this.lazyEvaluation = r7;
            this.paramValidator = r8;
            if (r7 == true) goto L5;
            return;
        L5:
            if ((r1 instanceof ValueAndJacobianFunction) == false) goto L8;
            return;
        L8:
            throw new MathIllegalStateException(LocalizedFormats.INVALID_IMPLEMENTATION, new Object[]{r1.getClass().getName()});
        }

        @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem
        public int getObservationSize() {
            return this.target.getDimension();
        }

        @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem
        public int getParameterSize() {
            return this.start.getDimension();
        }

        @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem
        public RealVector getStart() {
            RealVector r0 = this.start;
            if (r0 != null) goto L6;
            return null;
        L6:
            return r0.copy();
        }

        @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem
        public LeastSquaresProblem.Evaluation evaluate(RealVector r8) {
            ParameterValidator r0 = this.paramValidator;
            RealVector r9 = r8.copy();
            if (r0 == null) goto L6;
            r9 = r0.validate(r9);
        L6:
            RealVector r4 = r9;
            if (this.lazyEvaluation == true) goto L9;
            Pair<RealVector, RealMatrix> r10 = this.model.value(r4);
            return new UnweightedEvaluation(r10.getFirst(), r10.getSecond(), this.target, r4, null);
        L9:
            return new LazyUnweightedEvaluation((ValueAndJacobianFunction) this.model, this.target, r4, null);
        }
    }

    private static class LocalValueAndJacobianFunction implements ValueAndJacobianFunction {
        private final MultivariateMatrixFunction jacobian;
        private final MultivariateVectorFunction value;

        LocalValueAndJacobianFunction(MultivariateVectorFunction r1, MultivariateMatrixFunction r2) {
            this.value = r1;
            this.jacobian = r2;
        }

        @Override // org.apache.commons.math3.fitting.leastsquares.MultivariateJacobianFunction
        public Pair<RealVector, RealMatrix> value(RealVector r3) {
            double[] r4 = r3.toArray();
            return new Pair(computeValue(r4), computeJacobian(r4));
        }

        @Override // org.apache.commons.math3.fitting.leastsquares.ValueAndJacobianFunction
        public RealVector computeValue(double[] r2) {
            return new ArrayRealVector(this.value.value(r2), false);
        }

        @Override // org.apache.commons.math3.fitting.leastsquares.ValueAndJacobianFunction
        public RealMatrix computeJacobian(double[] r2) {
            return new Array2DRowRealMatrix(this.jacobian.value(r2), false);
        }
    }

    private LeastSquaresFactory() {
    }

    public static LeastSquaresProblem create(MultivariateJacobianFunction r11, RealVector r12, RealVector r13, RealMatrix r14, ConvergenceChecker<LeastSquaresProblem.Evaluation> r15, int r16, int r17, boolean r18, ParameterValidator r19) {
        LocalLeastSquaresProblem r10 = new LocalLeastSquaresProblem(r11, r12, r13, r15, r16, r17, r18, r19);
        if (r14 != null) goto L5;
        return r10;
    L5:
        return weightMatrix(r10, r14);
    }

    public static LeastSquaresProblem create(MultivariateJacobianFunction r9, RealVector r10, RealVector r11, ConvergenceChecker<LeastSquaresProblem.Evaluation> r12, int r13, int r14) {
        return create(r9, r10, r11, null, r12, r13, r14, false, null);
    }

    public static LeastSquaresProblem create(MultivariateJacobianFunction r6, RealVector r7, RealVector r8, RealMatrix r9, ConvergenceChecker<LeastSquaresProblem.Evaluation> r10, int r11, int r12) {
        return weightMatrix(create(r6, r7, r8, r10, r11, r12), r9);
    }

    public static LeastSquaresProblem create(MultivariateVectorFunction r7, MultivariateMatrixFunction r8, double[] r9, double[] r10, RealMatrix r11, ConvergenceChecker<LeastSquaresProblem.Evaluation> r12, int r13, int r14) {
        return create(model(r7, r8), new ArrayRealVector(r9, false), new ArrayRealVector(r10, false), r11, r12, r13, r14);
    }

    public static LeastSquaresProblem weightMatrix(final LeastSquaresProblem r1, RealMatrix r2) {
        final RealMatrix r3 = squareRoot(r2);
        return new AnonymousClass1(r1, r3);
    }

    public static LeastSquaresProblem weightDiagonal(LeastSquaresProblem r1, RealVector r2) {
        return weightMatrix(r1, new DiagonalMatrix(r2.toArray()));
    }

    public static LeastSquaresProblem countEvaluations(final LeastSquaresProblem r1, final Incrementor r2) {
        return new AnonymousClass2(r1, r2);
    }

    public static ConvergenceChecker<LeastSquaresProblem.Evaluation> evaluationChecker(final ConvergenceChecker<PointVectorValuePair> r1) {
        return new AnonymousClass3(r1);
    }

    private static RealMatrix squareRoot(RealMatrix r5) {
        if ((r5 instanceof DiagonalMatrix) == false) goto L9;
        int r0 = r5.getRowDimension();
        DiagonalMatrix r1 = new DiagonalMatrix(r0);
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L7;
        r1.setEntry(r2, r2, FastMath.sqrt(r5.getEntry(r2, r2)));
        r2 = r2 + 1;
        goto L5
    L7:
        return r1;
    L9:
        return new EigenDecomposition(r5).getSquareRoot();
    }

    public static MultivariateJacobianFunction model(MultivariateVectorFunction r1, MultivariateMatrixFunction r2) {
        return new LocalValueAndJacobianFunction(r1, r2);
    }
}
