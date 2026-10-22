package org.apache.commons.math3.ode.sampling;

import org.apache.commons.math3.exception.MaxCountExceededException;

/* JADX INFO: loaded from: classes6.dex */
public interface StepHandler {
    void handleStep(StepInterpolator r1, boolean r2) throws MaxCountExceededException;

    void init(double r1, double[] r3, double r4);
}
