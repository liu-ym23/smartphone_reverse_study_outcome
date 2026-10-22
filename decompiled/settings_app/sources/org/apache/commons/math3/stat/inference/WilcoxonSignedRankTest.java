package org.apache.commons.math3.stat.inference;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.stat.ranking.NaNStrategy;
import org.apache.commons.math3.stat.ranking.NaturalRanking;
import org.apache.commons.math3.stat.ranking.TiesStrategy;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class WilcoxonSignedRankTest {
    private NaturalRanking naturalRanking;

    private double calculateExactPValue(double r8, int r10) {
        int r0 = 1 << r10;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L15;
        int r4 = 0;
        int r5 = 0;
    L5:
        if (r4 >= r10) goto L11;
        if (((r2 >> r4) & 1) != 1) goto L9;
        r5 = r5 + (r4 + 1);
    L9:
        r4 = r4 + 1;
        goto L5
    L11:
        if (r5 < r8) goto L13;
        r3 = r3 + 1;
    L13:
        r2 = r2 + 1;
        goto L3
    L15:
        return (((double) r3) * 2.0d) / ((double) r0);
    }

    public WilcoxonSignedRankTest() {
        this.naturalRanking = new NaturalRanking(NaNStrategy.FIXED, TiesStrategy.AVERAGE);
    }

    public WilcoxonSignedRankTest(NaNStrategy r2, TiesStrategy r3) {
        this.naturalRanking = new NaturalRanking(r2, r3);
    }

    private void ensureDataConformance(double[] r2, double[] r3) throws NullArgumentException, NoDataException, DimensionMismatchException {
        if (r2 == null) goto L16;
        if (r3 == null) goto L16;
        if (r2.length == 0) goto L14;
        if (r3.length == 0) goto L14;
        if (r3.length != r2.length) goto L12;
        return;
    L12:
        throw new DimensionMismatchException(r3.length, r2.length);
    L14:
        throw new NoDataException();
    L16:
        throw new NullArgumentException();
    }

    private double[] calculateDifferences(double[] r6, double[] r7) {
        double[] r5 = new double[r6.length];
        int r0 = 0;
    L4:
        if (r0 >= r6.length) goto L6;
        r5[r0] = r7[r0] - r6[r0];
        r0 = r0 + 1;
        goto L4
    L6:
        return r5;
    }

    private double[] calculateAbsoluteDifferences(double[] r4) throws NullArgumentException, NoDataException {
        if (r4 == null) goto L13;
        if (r4.length == 0) goto L11;
        double[] r3 = new double[r4.length];
        int r0 = 0;
    L7:
        if (r0 >= r4.length) goto L9;
        r3[r0] = FastMath.abs(r4[r0]);
        r0 = r0 + 1;
        goto L7
    L9:
        return r3;
    L11:
        throw new NoDataException();
    L13:
        throw new NullArgumentException();
    }

    public double wilcoxonSignedRank(double[] r8, double[] r9) throws NullArgumentException, NoDataException, DimensionMismatchException {
        ensureDataConformance(r8, r9);
        double[] r10 = calculateDifferences(r8, r9);
        double[] r7 = this.naturalRanking.rank(calculateAbsoluteDifferences(r10));
        int r2 = 0;
        double r3 = 0.0d;
    L4:
        if (r2 >= r10.length) goto L9;
        if (r10[r2] <= 0.0d) goto L8;
        r3 = r3 + r7[r2];
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        int r11 = r8.length;
        return FastMath.max(r3, (((double) (r11 * (r11 + 1))) / 2.0d) - r3);
    }

    private double calculateAsymptoticPValue(double r7, int r9) {
        double r0 = ((double) ((r9 + 1) * r9)) / 4.0d;
        double r8 = ((r7 - r0) - 0.5d) / FastMath.sqrt((((double) ((r9 * 2) + 1)) / 6.0d) * r0);
        return new NormalDistribution(null, 0.0d, 1.0d).cumulativeProbability(r8) * 2.0d;
    }

    public double wilcoxonSignedRankTest(double[] r6, double[] r7, boolean r8) throws NullArgumentException, NoDataException, DimensionMismatchException, NumberIsTooLargeException, ConvergenceException, MaxCountExceededException {
        ensureDataConformance(r6, r7);
        int r0 = r6.length;
        double r9 = wilcoxonSignedRank(r6, r7);
        if (r8 == true) goto L5;
    L9:
        if (r8 == false) goto L13;
        return calculateExactPValue(r9, r0);
    L13:
        return calculateAsymptoticPValue((((double) ((r0 + 1) * r0)) / 2.0d) - r9, r0);
    L5:
        if (r0 <= 30) goto L9;
        throw new NumberIsTooLargeException(Integer.valueOf(r0), 30, true);
    }
}
