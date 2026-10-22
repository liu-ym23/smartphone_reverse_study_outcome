package org.apache.commons.math3.stat.interval;

import org.apache.commons.math3.distribution.FDistribution;

/* JADX INFO: loaded from: classes6.dex */
public class ClopperPearsonInterval implements BinomialConfidenceInterval {
    public ClopperPearsonInterval() {
    }

    @Override // org.apache.commons.math3.stat.interval.BinomialConfidenceInterval
    public ConfidenceInterval createInterval(int r15, int r16, double r17) {
        IntervalUtils.checkParameters(r15, r16, r17);
        int r6 = r15 - r16;
        int r7 = r6 + 1;
        double r1 = 1.0d - ((1.0d - r17) / 2.0d);
        double r3 = new FDistribution(r7 * 2, r16 * 2).inverseCumulativeProbability(r1);
        if (r16 <= 0) goto L5;
        double r10 = r16;
        double r4 = r10 / ((((double) r7) * r3) + r10);
    L6:
        int r8 = r16 + 1;
        double r2 = new FDistribution(r8 * 2, r6 * 2).inverseCumulativeProbability(r1);
        if (r16 <= 0) goto L9;
        double r9 = ((double) r8) * r2;
        double r11 = r9 / (((double) r6) + r9);
    L11:
        return new ConfidenceInterval(r4, r11, r17);
    L9:
        r11 = 0.0d;
        goto L11
    L5:
        r4 = 0.0d;
        goto L6
    }
}
