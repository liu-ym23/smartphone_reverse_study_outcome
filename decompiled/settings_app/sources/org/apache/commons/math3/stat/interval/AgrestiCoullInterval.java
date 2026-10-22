package org.apache.commons.math3.stat.interval;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class AgrestiCoullInterval implements BinomialConfidenceInterval {
    public AgrestiCoullInterval() {
    }

    @Override // org.apache.commons.math3.stat.interval.BinomialConfidenceInterval
    public ConfidenceInterval createInterval(int r13, int r14, double r15) {
        IntervalUtils.checkParameters(r13, r14, r15);
        double r2 = new NormalDistribution().inverseCumulativeProbability(1.0d - ((1.0d - r15) / 2.0d));
        double r4 = FastMath.pow(r2, 2);
        double r6 = 1.0d / (((double) r13) + r4);
        double r8 = (((double) r14) + (r4 * 0.5d)) * r6;
        double r3 = r2 * FastMath.sqrt((r6 * r8) * (1.0d - r8));
        return new ConfidenceInterval(r8 - r3, r8 + r3, r15);
    }
}
