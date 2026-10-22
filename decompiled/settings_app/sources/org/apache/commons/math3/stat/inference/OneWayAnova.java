package org.apache.commons.math3.stat.inference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class OneWayAnova {

    /* JADX INFO: renamed from: org.apache.commons.math3.stat.inference.OneWayAnova$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class AnovaStats {
        private final double F;
        private final int dfbg;
        private final int dfwg;

        /* synthetic */ AnovaStats(int r1, int r2, double r3, AnonymousClass1 r5) {
            this(r1, r2, r3);
        }

        static /* synthetic */ double access$000(AnovaStats r2) {
            return r2.F;
        }

        static /* synthetic */ int access$100(AnovaStats r0) {
            return r0.dfbg;
        }

        static /* synthetic */ int access$200(AnovaStats r0) {
            return r0.dfwg;
        }

        private AnovaStats(int r1, int r2, double r3) {
            this.dfbg = r1;
            this.dfwg = r2;
            this.F = r3;
        }
    }

    public OneWayAnova() {
    }

    public double anovaFValue(Collection<double[]> r1) throws NullArgumentException, DimensionMismatchException {
        return AnovaStats.access$000(anovaStats(r1));
    }

    public double anovaPValue(Collection<double[]> r7) throws NullArgumentException, DimensionMismatchException, ConvergenceException, MaxCountExceededException {
        AnovaStats r6 = anovaStats(r7);
        return 1.0d - new FDistribution(null, AnovaStats.access$100(r6), AnovaStats.access$200(r6)).cumulativeProbability(AnovaStats.access$000(r6));
    }

    public double anovaPValue(Collection<SummaryStatistics> r7, boolean r8) throws NullArgumentException, DimensionMismatchException, ConvergenceException, MaxCountExceededException {
        AnovaStats r6 = anovaStats(r7, r8);
        return 1.0d - new FDistribution(null, AnovaStats.access$100(r6), AnovaStats.access$200(r6)).cumulativeProbability(AnovaStats.access$000(r6));
    }

    private AnovaStats anovaStats(Collection<double[]> r8) throws NullArgumentException, DimensionMismatchException {
        MathUtils.checkNotNull(r8);
        ArrayList r0 = new ArrayList(r8.size());
        Iterator<double[]> r9 = r8.iterator();
    L3:
        int r2 = 0;
        if (r9.hasNext() == false) goto L9;
        double[] r1 = r9.next();
        SummaryStatistics r3 = new SummaryStatistics();
        r0.add(r3);
        int r4 = r1.length;
    L6:
        if (r2 >= r4) goto L3;
        r3.addValue(r1[r2]);
        r2 = r2 + 1;
        goto L6
    L9:
        return anovaStats(r0, false);
    }

    public boolean anovaTest(Collection<double[]> r5, double r6) throws NullArgumentException, DimensionMismatchException, OutOfRangeException, ConvergenceException, MaxCountExceededException {
        if (r6 <= 0.0d) goto L11;
        if (r6 > 0.5d) goto L11;
        if (anovaPValue(r5) >= r6) goto L12;
        return true;
    L12:
        return false;
    L11:
        throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, Double.valueOf(r6), 0, Double.valueOf(0.5d));
    }

    private AnovaStats anovaStats(Collection<SummaryStatistics> r17, boolean r18) throws NullArgumentException, DimensionMismatchException {
        MathUtils.checkNotNull(r17);
        if (r18 == false) goto L5;
    L16:
        Iterator<SummaryStatistics> r0 = r17.iterator();
        int r1 = 0;
        double r2 = 0.0d;
        int r4 = 0;
        double r5 = 0.0d;
        double r7 = 0.0d;
    L18:
        if (r0.hasNext() == false) goto L20;
        SummaryStatistics r9 = r0.next();
        double r10 = r9.getSum();
        double r12 = r9.getSumsq();
        int r11 = (int) r9.getN();
        r1 = r1 + r11;
        r5 = r5 + r10;
        r2 = r2 + r12;
        r4 = r4 + (r11 - 1);
        r7 = r7 + (r12 - ((r10 * r10) / ((double) r11)));
        goto L18
    L20:
        double r3 = (r2 - ((r5 * r5) / ((double) r1))) - r7;
        int r6 = r17.size() - 1;
        return new AnovaStats(r6, r4, (r3 / ((double) r6)) / (r7 / ((double) r4)), null);
    L5:
        if (r17.size() < 2) goto L15;
        Iterator<SummaryStatistics> r8 = r17.iterator();
    L8:
        if (r8.hasNext() == false) goto L16;
        SummaryStatistics r13 = r8.next();
        if (r13.getN() > 1) goto L8;
        throw new DimensionMismatchException(LocalizedFormats.TWO_OR_MORE_VALUES_IN_CATEGORY_REQUIRED, (int) r13.getN(), 2);
    L15:
        throw new DimensionMismatchException(LocalizedFormats.TWO_OR_MORE_CATEGORIES_REQUIRED, r17.size(), 2);
    }
}
