package org.apache.commons.math3.ode.nonstiff;

/* JADX INFO: loaded from: classes6.dex */
public class EulerIntegrator extends RungeKuttaIntegrator {
    private static final double[][] STATIC_A = null;
    private static final double[] STATIC_B = null;
    private static final double[] STATIC_C = null;

    static {
        STATIC_C = new double[0];
        STATIC_A = new double[0][];
        STATIC_B = new double[]{1.0d};
    }

    public EulerIntegrator(double r9) {
        super("Euler", STATIC_C, STATIC_A, STATIC_B, new EulerStepInterpolator(), r9);
    }
}
