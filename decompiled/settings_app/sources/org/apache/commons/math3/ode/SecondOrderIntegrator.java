package org.apache.commons.math3.ode;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathIllegalStateException;

/* JADX INFO: loaded from: classes6.dex */
public interface SecondOrderIntegrator extends ODEIntegrator {
    void integrate(SecondOrderDifferentialEquations r1, double r2, double[] r4, double[] r5, double r6, double[] r8, double[] r9) throws MathIllegalStateException, MathIllegalArgumentException;
}
