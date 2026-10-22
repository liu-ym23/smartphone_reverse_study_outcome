package org.apache.commons.math3.random;

import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class UniformRandomGenerator implements NormalizedRandomGenerator {
    private static final double SQRT3 = 0.0d;
    private final RandomGenerator generator;

    static {
        SQRT3 = FastMath.sqrt(3.0d);
    }

    public UniformRandomGenerator(RandomGenerator r1) {
        this.generator = r1;
    }

    @Override // org.apache.commons.math3.random.NormalizedRandomGenerator
    public double nextNormalizedDouble() {
        return SQRT3 * ((this.generator.nextDouble() * 2.0d) - 1.0d);
    }
}
