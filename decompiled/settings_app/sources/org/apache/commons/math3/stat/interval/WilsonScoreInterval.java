package org.apache.commons.math3.stat.interval;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class WilsonScoreInterval implements BinomialConfidenceInterval {
    public WilsonScoreInterval() {
    }

    @Override // org.apache.commons.math3.stat.interval.BinomialConfidenceInterval
    public ConfidenceInterval createInterval(int r19, int r20, double r21) {
        IntervalUtils.checkParameters(r19, r20, r21);
        double r3 = new NormalDistribution().inverseCumulativeProbability(1.0d - ((1.0d - r21) / 2.0d));
        double r6 = FastMath.pow(r3, 2);
        double r10 = r19;
        double r8 = ((double) r20) / r10;
        double r12 = 1.0d / r10;
        double r14 = 1.0d / ((r12 * r6) + 1.0d);
        double r15 = ((1.0d / ((double) (r19 * 2))) * r6) + r8;
        double r4 = r3 * FastMath.sqrt(((r12 * r8) * (1.0d - r8)) + ((1.0d / (FastMath.pow(r10, 2) * 4.0d)) * r6));
        return new ConfidenceInterval((r15 - r4) * r14, r14 * (r15 + r4), r21);
    }
}
