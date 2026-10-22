package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class DormandPrince54Integrator extends EmbeddedRungeKuttaIntegrator {
    private static final double E1 = 0.0012326388888888888d;
    private static final double E3 = -0.0042527702905061394d;
    private static final double E4 = 0.03697916666666667d;
    private static final double E5 = -0.05086379716981132d;
    private static final double E6 = 0.0419047619047619d;
    private static final double E7 = -0.025d;
    private static final String METHOD_NAME = "Dormand-Prince 5(4)";
    private static final double[][] STATIC_A = null;
    private static final double[] STATIC_B = null;
    private static final double[] STATIC_C = null;

    @Override // org.apache.commons.math3.ode.nonstiff.EmbeddedRungeKuttaIntegrator
    public int getOrder() {
        return 5;
    }

    static {
        STATIC_C = new double[]{0.2d, 0.3d, 0.8d, 0.8888888888888888d, 1.0d, 1.0d};
        STATIC_A = new double[][]{new double[]{0.2d}, new double[]{0.075d, 0.225d}, new double[]{0.9777777777777777d, -3.7333333333333334d, 3.5555555555555554d}, new double[]{2.9525986892242035d, -11.595793324188385d, 9.822892851699436d, -0.2908093278463649d}, new double[]{2.8462752525252526d, -10.757575757575758d, 8.906422717743473d, 0.2784090909090909d, -0.2735313036020583d}, new double[]{0.09114583333333333d, 0.0d, 0.44923629829290207d, 0.6510416666666666d, -0.322376179245283d, 0.13095238095238096d}};
        STATIC_B = new double[]{0.09114583333333333d, 0.0d, 0.44923629829290207d, 0.6510416666666666d, -0.322376179245283d, 0.13095238095238096d, 0.0d};
    }

    public DormandPrince54Integrator(double r16, double r18, double r20, double r22) {
        super(METHOD_NAME, true, STATIC_C, STATIC_A, STATIC_B, new DormandPrince54StepInterpolator(), r16, r18, r20, r22);
    }

    public DormandPrince54Integrator(double r14, double r16, double[] r18, double[] r19) {
        super(METHOD_NAME, true, STATIC_C, STATIC_A, STATIC_B, new DormandPrince54StepInterpolator(), r14, r16, r18, r19);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.EmbeddedRungeKuttaIntegrator
    protected double estimateError(double[][] r14, double[] r15, double[] r16, double r17) {
        double r1 = 0.0d;
        int r4 = 0;
    L4:
        if (r4 >= this.mainSetDimension) goto L11;
        double r5 = (((((r14[0][r4] * E1) + (r14[2][r4] * E3)) + (r14[3][r4] * E4)) + (r14[4][r4] * E5)) + (r14[5][r4] * E6)) + (r14[6][r4] * E7);
        double r7 = FastMath.max(FastMath.abs(r15[r4]), FastMath.abs(r16[r4]));
        if (this.vecAbsoluteTolerance != null) goto L8;
        double r9 = this.scalAbsoluteTolerance;
        double r11 = this.scalRelativeTolerance;
    L9:
        double r6 = (r5 * r17) / (r9 + (r11 * r7));
        r1 = r1 + (r6 * r6);
        r4 = r4 + 1;
        goto L4
    L8:
        r9 = this.vecAbsoluteTolerance[r4];
        r11 = this.vecRelativeTolerance[r4];
        goto L9
    L11:
        return FastMath.sqrt(r1 / ((double) this.mainSetDimension));
    }
}
