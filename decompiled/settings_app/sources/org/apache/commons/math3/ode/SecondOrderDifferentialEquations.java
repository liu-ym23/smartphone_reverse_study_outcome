package org.apache.commons.math3.ode;

/* JADX INFO: loaded from: classes6.dex */
public interface SecondOrderDifferentialEquations {
    void computeSecondDerivatives(double r1, double[] r3, double[] r4, double[] r5);

    int getDimension();
}
