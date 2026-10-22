package org.apache.commons.math3.ml.neuralnet;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.function.Constant;
import org.apache.commons.math3.distribution.RealDistribution;
import org.apache.commons.math3.distribution.UniformRealDistribution;
import org.apache.commons.math3.random.RandomGenerator;

/* JADX INFO: loaded from: classes6.dex */
public class FeatureInitializerFactory {
    private FeatureInitializerFactory() {
    }

    public static FeatureInitializer uniform(RandomGenerator r7, double r8, double r10) {
        return randomize(new UniformRealDistribution(r7, r8, r10), function(new Constant(0.0d), 0.0d, 0.0d));
    }

    public static FeatureInitializer uniform(double r1, double r3) {
        return randomize(new UniformRealDistribution(r1, r3), function(new Constant(0.0d), 0.0d, 0.0d));
    }

    public static FeatureInitializer function(final UnivariateFunction r7, final double r8, final double r10) {
        return new AnonymousClass1(r8, r7, r10);
    }

    public static FeatureInitializer randomize(final RealDistribution r1, final FeatureInitializer r2) {
        return new AnonymousClass2(r2, r1);
    }
}
