package org.apache.commons.math3.stat.descriptive;

import org.apache.commons.math3.exception.MathIllegalArgumentException;

/* JADX INFO: loaded from: classes6.dex */
public interface StorelessUnivariateStatistic extends UnivariateStatistic {
    void clear();

    StorelessUnivariateStatistic copy();

    long getN();

    double getResult();

    void increment(double r1);

    void incrementAll(double[] r1) throws MathIllegalArgumentException;

    void incrementAll(double[] r1, int r2, int r3) throws MathIllegalArgumentException;
}
