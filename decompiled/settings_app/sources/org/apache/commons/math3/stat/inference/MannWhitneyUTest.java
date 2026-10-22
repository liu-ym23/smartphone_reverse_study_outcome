package org.apache.commons.math3.stat.inference;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.stat.ranking.NaNStrategy;
import org.apache.commons.math3.stat.ranking.NaturalRanking;
import org.apache.commons.math3.stat.ranking.TiesStrategy;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class MannWhitneyUTest {
    private NaturalRanking naturalRanking;

    public MannWhitneyUTest() {
        this.naturalRanking = new NaturalRanking(NaNStrategy.FIXED, TiesStrategy.AVERAGE);
    }

    public MannWhitneyUTest(NaNStrategy r2, TiesStrategy r3) {
        this.naturalRanking = new NaturalRanking(r2, r3);
    }

    private void ensureDataConformance(double[] r1, double[] r2) throws NullArgumentException, NoDataException {
        if (r1 == null) goto L12;
        if (r2 == null) goto L12;
        if (r1.length == 0) goto L10;
        if (r2.length == 0) goto L10;
        return;
    L10:
        throw new NoDataException();
    L12:
        throw new NullArgumentException();
    }

    private double[] concatenateSamples(double[] r3, double[] r4) {
        double[] r2 = new double[r3.length + r4.length];
        System.arraycopy(r3, 0, r2, 0, r3.length);
        System.arraycopy(r4, 0, r2, r3.length, r4.length);
        return r2;
    }

    public double mannWhitneyU(double[] r7, double[] r8) throws NullArgumentException, NoDataException {
        ensureDataConformance(r7, r8);
        double[] r6 = this.naturalRanking.rank(concatenateSamples(r7, r8));
        double r0 = 0.0d;
        int r2 = 0;
    L4:
        if (r2 >= r7.length) goto L6;
        r0 = r0 + r6[r2];
        r2 = r2 + 1;
        goto L4
    L6:
        double r1 = r0 - ((((long) r7.length) * ((long) (r7.length + 1))) / 2);
        return FastMath.max(r1, (((long) r7.length) * ((long) r8.length)) - r1);
    }

    private double calculateAsymptoticPValue(double r15, int r17, int r18) throws ConvergenceException, MaxCountExceededException {
        long r2 = ((long) r17) * ((long) r18);
        return new NormalDistribution(null, 0.0d, 1.0d).cumulativeProbability((r15 - (r2 / 2.0d)) / FastMath.sqrt((r2 * ((long) ((r17 + r18) + 1))) / 12.0d)) * 2.0d;
    }

    public double mannWhitneyUTest(double[] r7, double[] r8) throws NullArgumentException, NoDataException, ConvergenceException, MaxCountExceededException {
        ensureDataConformance(r7, r8);
        return calculateAsymptoticPValue((((long) r7.length) * ((long) r8.length)) - mannWhitneyU(r7, r8), r7.length, r8.length);
    }
}
