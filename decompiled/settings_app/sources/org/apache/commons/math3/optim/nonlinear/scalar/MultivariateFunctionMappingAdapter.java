package org.apache.commons.math3.optim.nonlinear.scalar;

import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.function.Logit;
import org.apache.commons.math3.analysis.function.Sigmoid;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class MultivariateFunctionMappingAdapter implements MultivariateFunction {
    private final MultivariateFunction bounded;
    private final Mapper[] mappers;

    /* JADX INFO: renamed from: org.apache.commons.math3.optim.nonlinear.scalar.MultivariateFunctionMappingAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class LowerBoundMapper implements Mapper {
        private final double lower;

        LowerBoundMapper(double r1) {
            this.lower = r1;
        }

        @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateFunctionMappingAdapter.Mapper
        public double unboundedToBounded(double r3) {
            return this.lower + FastMath.exp(r3);
        }

        @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateFunctionMappingAdapter.Mapper
        public double boundedToUnbounded(double r3) {
            return FastMath.log(r3 - this.lower);
        }
    }

    private static class LowerUpperBoundMapper implements Mapper {
        private final UnivariateFunction boundingFunction;
        private final UnivariateFunction unboundingFunction;

        LowerUpperBoundMapper(double r2, double r4) {
            this.boundingFunction = new Sigmoid(r2, r4);
            this.unboundingFunction = new Logit(r2, r4);
        }

        @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateFunctionMappingAdapter.Mapper
        public double unboundedToBounded(double r1) {
            return this.boundingFunction.value(r1);
        }

        @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateFunctionMappingAdapter.Mapper
        public double boundedToUnbounded(double r1) {
            return this.unboundingFunction.value(r1);
        }
    }

    private interface Mapper {
        double boundedToUnbounded(double r1);

        double unboundedToBounded(double r1);
    }

    private static class NoBoundsMapper implements Mapper {
        @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateFunctionMappingAdapter.Mapper
        public double boundedToUnbounded(double r1) {
            return r1;
        }

        @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateFunctionMappingAdapter.Mapper
        public double unboundedToBounded(double r1) {
            return r1;
        }

        private NoBoundsMapper() {
        }

        /* synthetic */ NoBoundsMapper(AnonymousClass1 r1) {
            this();
        }
    }

    private static class UpperBoundMapper implements Mapper {
        private final double upper;

        UpperBoundMapper(double r1) {
            this.upper = r1;
        }

        @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateFunctionMappingAdapter.Mapper
        public double unboundedToBounded(double r3) {
            return this.upper - FastMath.exp(-r3);
        }

        @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateFunctionMappingAdapter.Mapper
        public double boundedToUnbounded(double r3) {
            return -FastMath.log(this.upper - r3);
        }
    }

    public MultivariateFunctionMappingAdapter(MultivariateFunction r7, double[] r8, double[] r9) {
        MathUtils.checkNotNull(r8);
        MathUtils.checkNotNull(r9);
        if (r8.length != r9.length) goto L28;
        int r0 = 0;
        int r1 = 0;
    L6:
        if (r1 >= r8.length) goto L12;
        if (r9[r1] < r8[r1]) goto L11;
        r1 = r1 + 1;
        goto L6
    L11:
        throw new NumberIsTooSmallException(Double.valueOf(r9[r1]), Double.valueOf(r8[r1]), true);
    L12:
        this.bounded = r7;
        this.mappers = new Mapper[r8.length];
    L14:
        if (r0 >= this.mappers.length) goto L26;
        if (Double.isInfinite(r8[r0]) == false) goto L22;
        if (Double.isInfinite(r9[r0]) == false) goto L20;
        this.mappers[r0] = new NoBoundsMapper(null);
    L25:
        r0 = r0 + 1;
        goto L14
    L20:
        this.mappers[r0] = new UpperBoundMapper(r9[r0]);
        goto L25
    L22:
        if (Double.isInfinite(r9[r0]) == false) goto L24;
        this.mappers[r0] = new LowerBoundMapper(r8[r0]);
        goto L25
    L24:
        this.mappers[r0] = new LowerUpperBoundMapper(r8[r0], r9[r0]);
        goto L25
    L26:
        return;
    L28:
        throw new DimensionMismatchException(r8.length, r9.length);
    }

    public double[] unboundedToBounded(double[] r6) {
        double[] r0 = new double[this.mappers.length];
        int r1 = 0;
    L3:
        Mapper[] r2 = this.mappers;
        if (r1 >= r2.length) goto L6;
        r0[r1] = r2[r1].unboundedToBounded(r6[r1]);
        r1 = r1 + 1;
        goto L3
    L6:
        return r0;
    }

    public double[] boundedToUnbounded(double[] r6) {
        double[] r0 = new double[this.mappers.length];
        int r1 = 0;
    L3:
        Mapper[] r2 = this.mappers;
        if (r1 >= r2.length) goto L6;
        r0[r1] = r2[r1].boundedToUnbounded(r6[r1]);
        r1 = r1 + 1;
        goto L3
    L6:
        return r0;
    }

    @Override // org.apache.commons.math3.analysis.MultivariateFunction
    public double value(double[] r2) {
        return this.bounded.value(unboundedToBounded(r2));
    }
}
