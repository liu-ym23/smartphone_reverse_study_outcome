package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class DormandPrince853Integrator extends EmbeddedRungeKuttaIntegrator {
    private static final double E1_01 = 0.01312004499419488d;
    private static final double E1_06 = -1.2251564463762044d;
    private static final double E1_07 = -0.4957589496572502d;
    private static final double E1_08 = 1.6643771824549864d;
    private static final double E1_09 = -0.35032884874997366d;
    private static final double E1_10 = 0.3341791187130175d;
    private static final double E1_11 = 0.08192320648511571d;
    private static final double E1_12 = -0.022355307863886294d;
    private static final double E2_01 = -0.18980075407240762d;
    private static final double E2_06 = 4.450312892752409d;
    private static final double E2_07 = 1.8915178993145003d;
    private static final double E2_08 = -5.801203960010585d;
    private static final double E2_09 = -0.42268232132379197d;
    private static final double E2_10 = -0.1521609496625161d;
    private static final double E2_11 = 0.20136540080403034d;
    private static final double E2_12 = 0.022651792198360825d;
    private static final String METHOD_NAME = "Dormand-Prince 8 (5, 3)";
    private static final double[][] STATIC_A = null;
    private static final double[] STATIC_B = null;
    private static final double[] STATIC_C = null;

    @Override // org.apache.commons.math3.ode.nonstiff.EmbeddedRungeKuttaIntegrator
    public int getOrder() {
        return 8;
    }

    static {
        STATIC_C = new double[]{(12.0d - (FastMath.sqrt(6.0d) * 2.0d)) / 135.0d, (6.0d - FastMath.sqrt(6.0d)) / 45.0d, (6.0d - FastMath.sqrt(6.0d)) / 30.0d, (FastMath.sqrt(6.0d) + 6.0d) / 30.0d, 0.3333333333333333d, 0.25d, 0.3076923076923077d, 0.6512820512820513d, 0.6d, 0.8571428571428571d, 1.0d, 1.0d};
        STATIC_A = new double[][]{new double[]{(12.0d - (FastMath.sqrt(6.0d) * 2.0d)) / 135.0d}, new double[]{(6.0d - FastMath.sqrt(6.0d)) / 180.0d, (6.0d - FastMath.sqrt(6.0d)) / 60.0d}, new double[]{(6.0d - FastMath.sqrt(6.0d)) / 120.0d, 0.0d, (6.0d - FastMath.sqrt(6.0d)) / 40.0d}, new double[]{((FastMath.sqrt(6.0d) * 107.0d) + 462.0d) / 3000.0d, 0.0d, ((-402.0d) - (FastMath.sqrt(6.0d) * 197.0d)) / 1000.0d, ((FastMath.sqrt(6.0d) * 73.0d) + 168.0d) / 375.0d}, new double[]{0.037037037037037035d, 0.0d, 0.0d, (FastMath.sqrt(6.0d) + 16.0d) / 108.0d, (16.0d - FastMath.sqrt(6.0d)) / 108.0d}, new double[]{0.037109375d, 0.0d, 0.0d, ((FastMath.sqrt(6.0d) * 23.0d) + 118.0d) / 1024.0d, (118.0d - (FastMath.sqrt(6.0d) * 23.0d)) / 1024.0d, -0.017578125d}, new double[]{0.03709200011850479d, 0.0d, 0.0d, ((FastMath.sqrt(6.0d) * 4784.0d) + 51544.0d) / 371293.0d, (51544.0d - (FastMath.sqrt(6.0d) * 4784.0d)) / 371293.0d, -0.015319437748624402d, 0.008273789163814023d}, new double[]{0.6241109587160757d, 0.0d, 0.0d, ((-1.324889724104E12d) - (FastMath.sqrt(6.0d) * 3.18801444819E11d)) / 6.265569375E11d, ((FastMath.sqrt(6.0d) * 3.18801444819E11d) - 1.324889724104E12d) / 6.265569375E11d, 27.59209969944671d, 20.154067550477894d, -43.48988418106996d}, new double[]{0.47766253643826434d, 0.0d, 0.0d, ((-4521408.0d) - (FastMath.sqrt(6.0d) * 1137963.0d)) / 2937500.0d, ((FastMath.sqrt(6.0d) * 1137963.0d) - 4521408.0d) / 2937500.0d, 21.230051448181193d, 15.279233632882423d, -33.28821096898486d, -0.020331201708508627d}, new double[]{-0.9371424300859873d, 0.0d, 0.0d, ((FastMath.sqrt(6.0d) * 94326.0d) + 354216.0d) / 112847.0d, (354216.0d - (FastMath.sqrt(6.0d) * 94326.0d)) / 112847.0d, -8.149787010746927d, -18.52006565999696d, 22.739487099350505d, 2.4936055526796523d, -3.0467644718982196d}, new double[]{2.273310147516538d, 0.0d, 0.0d, ((-3457480.0d) - (FastMath.sqrt(6.0d) * 960905.0d)) / 551636.0d, ((FastMath.sqrt(6.0d) * 960905.0d) - 3457480.0d) / 551636.0d, -17.9589318631188d, 27.94888452941996d, -2.8589982771350235d, -8.87285693353063d, 12.360567175794303d, 0.6433927460157636d}, new double[]{0.054293734116568765d, 0.0d, 0.0d, 0.0d, 0.0d, E2_06, E2_07, E2_08, 0.3111643669578199d, E2_10, E2_11, 0.04471061572777259d}};
        STATIC_B = new double[]{0.054293734116568765d, 0.0d, 0.0d, 0.0d, 0.0d, E2_06, E2_07, E2_08, 0.3111643669578199d, E2_10, E2_11, 0.04471061572777259d, 0.0d};
    }

    public DormandPrince853Integrator(double r16, double r18, double r20, double r22) {
        super(METHOD_NAME, true, STATIC_C, STATIC_A, STATIC_B, new DormandPrince853StepInterpolator(), r16, r18, r20, r22);
    }

    public DormandPrince853Integrator(double r14, double r16, double[] r18, double[] r19) {
        super(METHOD_NAME, true, STATIC_C, STATIC_A, STATIC_B, new DormandPrince853StepInterpolator(), r14, r16, r18, r19);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.EmbeddedRungeKuttaIntegrator
    protected double estimateError(double[][] r30, double[] r31, double[] r32, double r33) {
        char r3 = 0;
        int r4 = 0;
        double r5 = 0.0d;
        double r7 = 0.0d;
    L4:
        if (r4 >= this.mainSetDimension) goto L10;
        double r9 = r30[r3][r4];
        double r11 = E1_01 * r9;
        double r13 = r30[5][r4];
        double r12 = r11 + (E1_06 * r13);
        double r15 = r30[6][r4];
        double r14 = r12 + (E1_07 * r15);
        double r17 = r30[7][r4];
        double r16 = r14 + (E1_08 * r17);
        double r19 = r30[8][r4];
        double r18 = r16 + (E1_09 * r19);
        double r21 = r30[9][r4];
        double r110 = r18 + (E1_10 * r21);
        double r23 = r30[10][r4];
        double r111 = r110 + (E1_11 * r23);
        double r25 = r30[11][r4];
        double r112 = r111 + (E1_12 * r25);
        double r10 = (((((((r9 * E2_01) + (r13 * E2_06)) + (r15 * E2_07)) + (r17 * E2_08)) + (r19 * E2_09)) + (r21 * E2_10)) + (r23 * E2_11)) + (r25 * E2_12);
        double r1 = FastMath.max(FastMath.abs(r31[r4]), FastMath.abs(r32[r4]));
        if (this.vecAbsoluteTolerance != null) goto L8;
        double r113 = this.scalAbsoluteTolerance;
        int r114 = r4;
        double r6 = this.scalRelativeTolerance * r1;
    L9:
        double r115 = r113 + r6;
        double r116 = r112 / r115;
        r5 = r5 + (r116 * r116);
        double r20 = r10 / r115;
        r7 = r7 + (r20 * r20);
        r4 = r114 + 1;
        r3 = 0;
        goto L4
    L8:
        r114 = r4;
        r6 = this.vecAbsoluteTolerance[r114];
        r113 = this.vecRelativeTolerance[r114] * r1;
        goto L9
    L10:
        double r8 = (r7 * 0.01d) + r5;
        if (r8 > 0.0d) goto L14;
        r8 = 1.0d;
    L14:
        return (FastMath.abs(r33) * r5) / FastMath.sqrt(((double) this.mainSetDimension) * r8);
    }
}
