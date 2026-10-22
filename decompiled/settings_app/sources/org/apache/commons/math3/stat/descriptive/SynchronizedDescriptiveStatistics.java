package org.apache.commons.math3.stat.descriptive;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class SynchronizedDescriptiveStatistics extends DescriptiveStatistics {
    private static final long serialVersionUID = 1;

    @Override // org.apache.commons.math3.stat.descriptive.DescriptiveStatistics
    public /* bridge */ /* synthetic */ DescriptiveStatistics copy() {
        return copy();
    }

    public SynchronizedDescriptiveStatistics() {
        this(-1);
    }

    public SynchronizedDescriptiveStatistics(int r1) throws MathIllegalArgumentException {
        super(r1);
    }

    public SynchronizedDescriptiveStatistics(SynchronizedDescriptiveStatistics r1) throws NullArgumentException {
        copy(r1, this);
    }

    @Override // org.apache.commons.math3.stat.descriptive.DescriptiveStatistics
    public synchronized void addValue(double r1) {
        monitor-enter(this);
        super.addValue(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.DescriptiveStatistics
    public synchronized double apply(UnivariateStatistic r3) {
        monitor-enter(this);
        double r0 = super.apply(r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.DescriptiveStatistics
    public synchronized void clear() {
        monitor-enter(this);
        super.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.DescriptiveStatistics
    public synchronized double getElement(int r3) {
        monitor-enter(this);
        double r0 = super.getElement(r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.DescriptiveStatistics, org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public synchronized long getN() {
        monitor-enter(this);
        long r0 = super.getN();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.DescriptiveStatistics, org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public synchronized double getStandardDeviation() {
        monitor-enter(this);
        double r0 = super.getStandardDeviation();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.DescriptiveStatistics
    public synchronized double getQuadraticMean() {
        monitor-enter(this);
        double r0 = super.getQuadraticMean();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.DescriptiveStatistics
    public synchronized double[] getValues() {
        monitor-enter(this);
        double[] r0 = super.getValues();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.DescriptiveStatistics
    public synchronized int getWindowSize() {
        monitor-enter(this);
        int r0 = super.getWindowSize();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.DescriptiveStatistics
    public synchronized void setWindowSize(int r1) throws MathIllegalArgumentException {
        monitor-enter(this);
        super.setWindowSize(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.DescriptiveStatistics
    public synchronized String toString() {
        monitor-enter(this);
        String r0 = super.toString();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.DescriptiveStatistics
    public synchronized SynchronizedDescriptiveStatistics copy() {
        monitor-enter(this);
        SynchronizedDescriptiveStatistics r0 = new SynchronizedDescriptiveStatistics();     // Catch: Throwable -> L6
        copy(this, r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public static void copy(SynchronizedDescriptiveStatistics r1, SynchronizedDescriptiveStatistics r2) throws NullArgumentException {
        MathUtils.checkNotNull(r1);
        MathUtils.checkNotNull(r2);
        monitor-enter(r1);
        monitor-enter(r2);     // Catch: Throwable -> L12
        DescriptiveStatistics.copy(r1, r2);     // Catch: Throwable -> L9
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
