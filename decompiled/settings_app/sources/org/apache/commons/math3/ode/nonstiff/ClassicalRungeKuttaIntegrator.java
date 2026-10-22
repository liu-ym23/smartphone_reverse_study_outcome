package org.apache.commons.math3.ode.nonstiff;

/* JADX INFO: loaded from: classes6.dex */
public class ClassicalRungeKuttaIntegrator extends RungeKuttaIntegrator {
    private static final double[][] STATIC_A = null;
    private static final double[] STATIC_B = null;
    private static final double[] STATIC_C = null;

    static {
        STATIC_C = new double[]{0.5d, 0.5d, 1.0d};
        STATIC_A = new double[][]{new double[]{0.5d}, new double[]{0.0d, 0.5d}, new double[]{0.0d, 0.0d, 1.0d}};
        STATIC_B = new double[]{0.16666666666666666d, 0.3333333333333333d, 0.3333333333333333d, 0.16666666666666666d};
    }

    public ClassicalRungeKuttaIntegrator(double r9) {
        super("classical Runge-Kutta", STATIC_C, STATIC_A, STATIC_B, new ClassicalRungeKuttaStepInterpolator(), r9);
    }
}
