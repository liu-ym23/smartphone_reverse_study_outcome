package org.apache.commons.math3.ode.sampling;

/* JADX INFO: loaded from: classes6.dex */
public interface FixedStepHandler {
    void handleStep(double r1, double[] r3, double[] r4, boolean r5);

    void init(double r1, double[] r3, double r4);
}
