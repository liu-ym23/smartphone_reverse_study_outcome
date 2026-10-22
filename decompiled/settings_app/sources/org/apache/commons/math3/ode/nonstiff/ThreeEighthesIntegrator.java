package org.apache.commons.math3.ode.nonstiff;

/* JADX INFO: loaded from: classes6.dex */
public class ThreeEighthesIntegrator extends RungeKuttaIntegrator {
    private static final double[][] STATIC_A = null;
    private static final double[] STATIC_B = null;
    private static final double[] STATIC_C = null;

    static {
        STATIC_C = new double[]{0.3333333333333333d, 0.6666666666666666d, 1.0d};
        STATIC_A = new double[][]{new double[]{0.3333333333333333d}, new double[]{-0.3333333333333333d, 1.0d}, new double[]{1.0d, -1.0d, 1.0d}};
        STATIC_B = new double[]{0.125d, 0.375d, 0.375d, 0.125d};
    }

    public ThreeEighthesIntegrator(double r9) {
        super("3/8", STATIC_C, STATIC_A, STATIC_B, new ThreeEighthesStepInterpolator(), r9);
    }
}
