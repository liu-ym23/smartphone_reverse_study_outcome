package org.apache.commons.math3.stat.descriptive;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.math3.exception.NullArgumentException;

/* JADX INFO: loaded from: classes6.dex */
public class AggregateSummaryStatistics implements StatisticalSummary, Serializable {
    private static final long serialVersionUID = -8207112444016386906L;
    private final SummaryStatistics statistics;
    private final SummaryStatistics statisticsPrototype;

    private static class AggregatingSummaryStatistics extends SummaryStatistics {
        private static final long serialVersionUID = 1;
        private final SummaryStatistics aggregateStatistics;

        AggregatingSummaryStatistics(SummaryStatistics r1) {
            this.aggregateStatistics = r1;
        }

        @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
        public void addValue(double r2) {
            super.addValue(r2);
            SummaryStatistics r0 = this.aggregateStatistics;
            monitor-enter(r0);
            this.aggregateStatistics.addValue(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
        public boolean equals(Object r4) {
            if (r4 != this) goto L6;
            return true;
        L6:
            if ((r4 instanceof AggregatingSummaryStatistics) == true) goto L8;
            return false;
        L8:
            AggregatingSummaryStatistics r5 = (AggregatingSummaryStatistics) r4;
            if (super.equals(r5) == false) goto L14;
            if (this.aggregateStatistics.equals(r5.aggregateStatistics) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
        public int hashCode() {
            return (super.hashCode() + 123) + this.aggregateStatistics.hashCode();
        }
    }

    public AggregateSummaryStatistics() {
        this(new SummaryStatistics());
    }

    public AggregateSummaryStatistics(SummaryStatistics r2) throws NullArgumentException {
        if (r2 != null) goto L4;
        SummaryStatistics r0 = null;
    L5:
        this(r2, r0);
        return;
    L4:
        r0 = new SummaryStatistics(r2);
        goto L5
    }

    public AggregateSummaryStatistics(SummaryStatistics r1, SummaryStatistics r2) {
        if (r1 != null) goto L5;
        r1 = new SummaryStatistics();
    L5:
        this.statisticsPrototype = r1;
        if (r2 != null) goto L8;
        r2 = new SummaryStatistics();
    L8:
        this.statistics = r2;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMax() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getMax();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMean() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getMean();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMin() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getMin();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public long getN() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        long r1 = this.statistics.getN();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getStandardDeviation() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getStandardDeviation();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getSum() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getSum();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getVariance() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getVariance();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public double getSumOfLogs() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getSumOfLogs();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public double getGeometricMean() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getGeometricMean();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public double getSumsq() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getSumsq();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public double getSecondMoment() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getSecondMoment();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public StatisticalSummary getSummary() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        StatisticalSummaryValues r14 = new StatisticalSummaryValues(getMean(), getVariance(), getN(), getMax(), getMin(), getSum());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r14;
    L7:
        th = move-exception;
        throw th;
    }

    public SummaryStatistics createContributingStatistics() {
        AggregatingSummaryStatistics r0 = new AggregatingSummaryStatistics(this.statistics);
        SummaryStatistics.copy(this.statisticsPrototype, r0);
        return r0;
    }

    public static StatisticalSummaryValues aggregate(Collection<? extends StatisticalSummary> r29) {
        if (r29 != null) goto L5;
        return null;
    L5:
        Iterator<? extends StatisticalSummary> r1 = r29.iterator();
        if (r1.hasNext() == true) goto L8;
        return null;
    L8:
        StatisticalSummary r0 = r1.next();
        long r2 = r0.getN();
        double r4 = r0.getMin();
        double r6 = r0.getSum();
        double r8 = r0.getMax();
        double r10 = r0.getVariance() * (r2 - 1.0d);
        double r25 = r4;
        double r27 = r6;
        double r23 = r8;
        double r17 = r0.getMean();
    L10:
        if (r1.hasNext() == false) goto L23;
        StatisticalSummary r3 = r1.next();
        if (r3.getMin() >= r25) goto L14;
    L15:
        r25 = r3.getMin();
    L17:
        if (r3.getMax() <= r23) goto L19;
    L20:
        r23 = r3.getMax();
    L21:
        r27 = r27 + r3.getSum();
        double r5 = r2;
        double r7 = r3.getN();
        long r9 = (long) (r5 + r7);
        double r11 = r3.getMean() - r17;
        double r12 = r9;
        r17 = r27 / r12;
        r10 = (r10 + (r3.getVariance() * (r7 - 1.0d))) + ((((r11 * r11) * r5) * r7) / r12);
        r2 = r9;
        goto L10
    L19:
        if (Double.isNaN(r23) == false) goto L21;
    L14:
        if (Double.isNaN(r25) == false) goto L17;
    L23:
        if (r2 != 0) goto L27;
        double r13 = Double.NaN;
    L25:
        double r19 = r13;
    L31:
        return new StatisticalSummaryValues(r17, r19, r2, r23, r25, r27);
    L27:
        if (r2 != 1) goto L29;
        r13 = 0.0d;
        goto L25
    L29:
        r19 = r10 / (r2 - 1);
        goto L31
    }
}
