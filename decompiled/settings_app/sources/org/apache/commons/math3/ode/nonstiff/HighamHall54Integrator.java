package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class HighamHall54Integrator extends EmbeddedRungeKuttaIntegrator {
    private static final String METHOD_NAME = "Higham-Hall 5(4)";
    private static final double[][] STATIC_A = null;
    private static final double[] STATIC_B = null;
    private static final double[] STATIC_C = null;
    private static final double[] STATIC_E = null;

    @Override // org.apache.commons.math3.ode.nonstiff.EmbeddedRungeKuttaIntegrator
    public int getOrder() {
        return 5;
    }

    static {
        STATIC_C = new double[]{0.2222222222222222d, 0.3333333333333333d, 0.5d, 0.6d, 1.0d, 1.0d};
        STATIC_A = new double[][]{new double[]{0.2222222222222222d}, new double[]{0.08333333333333333d, 0.25d}, new double[]{0.125d, 0.0d, 0.375d}, new double[]{0.182d, -0.27d, 0.624d, 0.064d}, new double[]{-0.55d, 1.35d, 2.4d, -7.2d, 5.0d}, new double[]{0.08333333333333333d, 0.0d, 0.84375d, -1.3333333333333333d, 1.3020833333333333d, 0.10416666666666667d}};
        STATIC_B = new double[]{0.08333333333333333d, 0.0d, 0.84375d, -1.3333333333333333d, 1.3020833333333333d, 0.10416666666666667d, 0.0d};
        STATIC_E = new double[]{-0.05d, 0.0d, 0.50625d, -1.2d, 0.78125d, 0.0625d, -0.1d};
    }

    public HighamHall54Integrator(double r16, double r18, double r20, double r22) {
        super(METHOD_NAME, false, STATIC_C, STATIC_A, STATIC_B, new HighamHall54StepInterpolator(), r16, r18, r20, r22);
    }

    public HighamHall54Integrator(double r14, double r16, double[] r18, double[] r19) {
        super(METHOD_NAME, false, STATIC_C, STATIC_A, STATIC_B, new HighamHall54StepInterpolator(), r14, r16, r18, r19);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.EmbeddedRungeKuttaIntegrator
    protected double estimateError(double[][] r14, double[] r15, double[] r16, double r17) {
        double r1 = 0.0d;
        int r4 = 0;
    L4:
        if (r4 >= this.mainSetDimension) goto L15;
        double r5 = STATIC_E[0] * r14[0][r4];
        int r7 = 1;
    L6:
        double[] r8 = STATIC_E;
        if (r7 >= r8.length) goto L9;
        r5 = r5 + (r8[r7] * r14[r7][r4]);
        r7 = r7 + 1;
        goto L6
    L9:
        double r9 = FastMath.max(FastMath.abs(r15[r4]), FastMath.abs(r16[r4]));
        if (this.vecAbsoluteTolerance != null) goto L12;
        double r10 = this.scalAbsoluteTolerance;
        double r11 = this.scalRelativeTolerance;
    L13:
        double r6 = (r5 * r17) / (r10 + (r11 * r9));
        r1 = r1 + (r6 * r6);
        r4 = r4 + 1;
        goto L4
    L12:
        r10 = this.vecAbsoluteTolerance[r4];
        r11 = this.vecRelativeTolerance[r4];
        goto L13
    L15:
        return FastMath.sqrt(r1 / ((double) this.mainSetDimension));
    }
}
