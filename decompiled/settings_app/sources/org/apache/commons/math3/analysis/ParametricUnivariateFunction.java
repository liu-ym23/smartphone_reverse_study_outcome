package org.apache.commons.math3.analysis;

/* JADX INFO: loaded from: classes6.dex */
public interface ParametricUnivariateFunction {
    double[] gradient(double r1, double... r3);

    double value(double r1, double... r3);
}
