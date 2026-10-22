package org.apache.commons.math3.stat.interval;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class NormalApproximationInterval implements BinomialConfidenceInterval {
    public NormalApproximationInterval() {
    }

    @Override // org.apache.commons.math3.stat.interval.BinomialConfidenceInterval
    public ConfidenceInterval createInterval(int r14, int r15, double r16) {
        IntervalUtils.checkParameters(r14, r15, r16);
        double r2 = r14;
        double r0 = ((double) r15) / r2;
        double r6 = new NormalDistribution().inverseCumulativeProbability(1.0d - ((1.0d - r16) / 2.0d)) * FastMath.sqrt(((1.0d / r2) * r0) * (1.0d - r0));
        return new ConfidenceInterval(r0 - r6, r0 + r6, r16);
    }
}
