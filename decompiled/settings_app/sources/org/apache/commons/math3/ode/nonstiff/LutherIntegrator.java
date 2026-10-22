package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class LutherIntegrator extends RungeKuttaIntegrator {
    private static final double Q = 0.0d;
    private static final double[][] STATIC_A = null;
    private static final double[] STATIC_B = null;
    private static final double[] STATIC_C = null;

    static {
        double r0 = FastMath.sqrt(21.0d);
        Q = r0;
        STATIC_C = new double[]{1.0d, 0.5d, 0.6666666666666666d, (7.0d - r0) / 14.0d, (7.0d + r0) / 14.0d, 1.0d};
        STATIC_A = new double[][]{new double[]{1.0d}, new double[]{0.375d, 0.125d}, new double[]{0.2962962962962963d, 0.07407407407407407d, 0.2962962962962963d}, new double[]{((9.0d * r0) - 21.0d) / 392.0d, ((8.0d * r0) - 56.0d) / 392.0d, (336.0d - (48.0d * r0)) / 392.0d, ((3.0d * r0) - 63.0d) / 392.0d}, new double[]{((-1155.0d) - (255.0d * r0)) / 1960.0d, ((-280.0d) - (40.0d * r0)) / 1960.0d, (0.0d - (320.0d * r0)) / 1960.0d, ((363.0d * r0) + 63.0d) / 1960.0d, ((392.0d * r0) + 2352.0d) / 1960.0d}, new double[]{((105.0d * r0) + 330.0d) / 180.0d, ((0.0d * r0) + 120.0d) / 180.0d, ((280.0d * r0) - 200.0d) / 180.0d, (126.0d - (189.0d * r0)) / 180.0d, ((-686.0d) - (126.0d * r0)) / 180.0d, (490.0d - (r0 * 70.0d)) / 180.0d}};
        STATIC_B = new double[]{0.05d, 0.0d, 0.35555555555555557d, 0.0d, 0.2722222222222222d, 0.2722222222222222d, 0.05d};
    }

    public LutherIntegrator(double r9) {
        super("Luther", STATIC_C, STATIC_A, STATIC_B, new LutherStepInterpolator(), r9);
    }
}
