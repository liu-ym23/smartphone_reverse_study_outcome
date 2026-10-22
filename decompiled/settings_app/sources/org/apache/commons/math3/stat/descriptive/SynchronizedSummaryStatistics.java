package org.apache.commons.math3.stat.descriptive;

import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class SynchronizedSummaryStatistics extends SummaryStatistics {
    private static final long serialVersionUID = 1909861009042253704L;

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public /* bridge */ /* synthetic */ SummaryStatistics copy() {
        return copy();
    }

    public SynchronizedSummaryStatistics() {
    }

    public SynchronizedSummaryStatistics(SynchronizedSummaryStatistics r1) throws NullArgumentException {
        copy(r1, this);
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized StatisticalSummary getSummary() {
        monitor-enter(this);
        StatisticalSummary r0 = super.getSummary();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized void addValue(double r1) {
        monitor-enter(this);
        super.addValue(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics, org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public synchronized long getN() {
        monitor-enter(this);
        long r0 = super.getN();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics, org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public synchronized double getSum() {
        monitor-enter(this);
        double r0 = super.getSum();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized double getSumsq() {
        monitor-enter(this);
        double r0 = super.getSumsq();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics, org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public synchronized double getMean() {
        monitor-enter(this);
        double r0 = super.getMean();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics, org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public synchronized double getStandardDeviation() {
        monitor-enter(this);
        double r0 = super.getStandardDeviation();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized double getQuadraticMean() {
        monitor-enter(this);
        double r0 = super.getQuadraticMean();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics, org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public synchronized double getVariance() {
        monitor-enter(this);
        double r0 = super.getVariance();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized double getPopulationVariance() {
        monitor-enter(this);
        double r0 = super.getPopulationVariance();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics, org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public synchronized double getMax() {
        monitor-enter(this);
        double r0 = super.getMax();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics, org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public synchronized double getMin() {
        monitor-enter(this);
        double r0 = super.getMin();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized double getGeometricMean() {
        monitor-enter(this);
        double r0 = super.getGeometricMean();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized String toString() {
        monitor-enter(this);
        String r0 = super.toString();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized void clear() {
        monitor-enter(this);
        super.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized boolean equals(Object r1) {
        monitor-enter(this);
        boolean r2 = super.equals(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r2;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized int hashCode() {
        monitor-enter(this);
        int r0 = super.hashCode();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized StorelessUnivariateStatistic getSumImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic r0 = super.getSumImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized void setSumImpl(StorelessUnivariateStatistic r1) throws MathIllegalStateException {
        monitor-enter(this);
        super.setSumImpl(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized StorelessUnivariateStatistic getSumsqImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic r0 = super.getSumsqImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized void setSumsqImpl(StorelessUnivariateStatistic r1) throws MathIllegalStateException {
        monitor-enter(this);
        super.setSumsqImpl(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized StorelessUnivariateStatistic getMinImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic r0 = super.getMinImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized void setMinImpl(StorelessUnivariateStatistic r1) throws MathIllegalStateException {
        monitor-enter(this);
        super.setMinImpl(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized StorelessUnivariateStatistic getMaxImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic r0 = super.getMaxImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized void setMaxImpl(StorelessUnivariateStatistic r1) throws MathIllegalStateException {
        monitor-enter(this);
        super.setMaxImpl(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized StorelessUnivariateStatistic getSumLogImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic r0 = super.getSumLogImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized void setSumLogImpl(StorelessUnivariateStatistic r1) throws MathIllegalStateException {
        monitor-enter(this);
        super.setSumLogImpl(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized StorelessUnivariateStatistic getGeoMeanImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic r0 = super.getGeoMeanImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized void setGeoMeanImpl(StorelessUnivariateStatistic r1) throws MathIllegalStateException {
        monitor-enter(this);
        super.setGeoMeanImpl(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized StorelessUnivariateStatistic getMeanImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic r0 = super.getMeanImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized void setMeanImpl(StorelessUnivariateStatistic r1) throws MathIllegalStateException {
        monitor-enter(this);
        super.setMeanImpl(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized StorelessUnivariateStatistic getVarianceImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic r0 = super.getVarianceImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized void setVarianceImpl(StorelessUnivariateStatistic r1) throws MathIllegalStateException {
        monitor-enter(this);
        super.setVarianceImpl(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
    public synchronized SynchronizedSummaryStatistics copy() {
        monitor-enter(this);
        SynchronizedSummaryStatistics r0 = new SynchronizedSummaryStatistics();     // Catch: Throwable -> L6
        copy(this, r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public static void copy(SynchronizedSummaryStatistics r1, SynchronizedSummaryStatistics r2) throws NullArgumentException {
        MathUtils.checkNotNull(r1);
        MathUtils.checkNotNull(r2);
        monitor-enter(r1);
        monitor-enter(r2);     // Catch: Throwable -> L12
        SummaryStatistics.copy(r1, r2);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }
}
