package org.apache.commons.math3.ode.nonstiff;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.AbstractIntegrator;
import org.apache.commons.math3.ode.EquationsMapper;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

/* JADX INFO: loaded from: classes6.dex */
class DormandPrince853StepInterpolator extends RungeKuttaStepInterpolator {
    private static final double B_01 = 0.054293734116568765d;
    private static final double B_06 = 4.450312892752409d;
    private static final double B_07 = 1.8915178993145003d;
    private static final double B_08 = -5.801203960010585d;
    private static final double B_09 = 0.3111643669578199d;
    private static final double B_10 = -0.1521609496625161d;
    private static final double B_11 = 0.20136540080403034d;
    private static final double B_12 = 0.04471061572777259d;
    private static final double C14 = 0.1d;
    private static final double C15 = 0.2d;
    private static final double C16 = 0.7777777777777778d;
    private static final double[][] D = null;
    private static final double K14_01 = 0.0018737681664791894d;
    private static final double K14_06 = -4.450312892752409d;
    private static final double K14_07 = -1.6380176890978755d;
    private static final double K14_08 = 5.554964922539782d;
    private static final double K14_09 = -0.4353557902216363d;
    private static final double K14_10 = 0.30545274794128174d;
    private static final double K14_11 = -0.19316434850839564d;
    private static final double K14_12 = -0.03714271806722689d;
    private static final double K14_13 = -0.008298d;
    private static final double K15_01 = -0.022459085953066622d;
    private static final double K15_06 = -4.422011983080043d;
    private static final double K15_07 = -1.8379759110070617d;
    private static final double K15_08 = 5.746280211439194d;
    private static final double K15_09 = -0.3111643669578199d;
    private static final double K15_10 = 0.1521609496625161d;
    private static final double K15_11 = -0.2014737481327276d;
    private static final double K15_12 = -0.04432804463693693d;
    private static final double K15_13 = -3.4046500868740456E-4d;
    private static final double K15_14 = 0.1413124436746325d;
    private static final double K16_01 = -0.4831900357003607d;
    private static final double K16_06 = -9.147934308113573d;
    private static final double K16_07 = 5.791903296748099d;
    private static final double K16_08 = 9.870193778407696d;
    private static final double K16_09 = 0.04556282049746119d;
    private static final double K16_10 = 0.1521609496625161d;
    private static final double K16_11 = -0.20136540080403034d;
    private static final double K16_12 = -0.04471061572777259d;
    private static final double K16_13 = -0.0013990241651590145d;
    private static final double K16_14 = 2.9475147891527724d;
    private static final double K16_15 = -9.15095847217987d;
    private static final long serialVersionUID = 20111120;
    private double[][] v;
    private boolean vectorsInitialized;
    private double[][] yDotKLast;

    static {
        D = new double[][]{new double[]{-8.428938276109013d, 0.5667149535193777d, -3.0689499459498917d, 2.38466765651207d, 2.1170345824450285d, -0.871391583777973d, 2.2404374302607883d, 0.6315787787694688d, -0.08899033645133331d, 18.148505520854727d, -9.194632392478356d, -4.436036387594894d}, new double[]{10.427508642579134d, 242.28349177525817d, 165.20045171727028d, -374.5467547226902d, -22.113666853125302d, 7.733432668472264d, -30.674084731089398d, -9.332130526430229d, 15.697238121770845d, -31.139403219565178d, -9.35292435884448d, 35.81684148639408d}, new double[]{19.985053242002433d, -387.0373087493518d, -189.17813819516758d, 527.8081592054236d, -11.573902539959631d, 6.8812326946963d, -1.0006050966910838d, 0.7777137798053443d, -2.778205752353508d, -60.19669523126412d, 84.32040550667716d, 11.99229113618279d}, new double[]{-25.69393346270375d, -154.18974869023643d, -231.5293791760455d, 357.6391179106141d, 93.4053241836243d, -37.45832313645163d, 104.0996495089623d, 29.8402934266605d, -43.53345659001114d, 96.32455395918828d, -39.17726167561544d, -149.72683625798564d}};
    }

    public DormandPrince853StepInterpolator() {
        double[][] r1 = (double[][]) null;
        this.yDotKLast = null;
        this.v = null;
        this.vectorsInitialized = false;
    }

    DormandPrince853StepInterpolator(DormandPrince853StepInterpolator r6) {
        super(r6);
        if (r6.currentState != null) goto L5;
        double[][] r0 = (double[][]) null;
        this.yDotKLast = null;
        this.v = null;
        this.vectorsInitialized = false;
        return;
    L5:
        int r1 = r6.currentState.length;
        this.yDotKLast = new double[3][];
        int r2 = 0;
    L6:
        double[][] r3 = this.yDotKLast;
        if (r2 >= r3.length) goto L9;
        double[] r4 = new double[r1];
        r3[r2] = r4;
        System.arraycopy(r6.yDotKLast[r2], 0, r4, 0, r1);
        r2 = r2 + 1;
        goto L6
    L9:
        this.v = new double[7][];
        int r5 = 0;
    L10:
        double[][] r7 = this.v;
        if (r5 >= r7.length) goto L13;
        double[] r8 = new double[r1];
        r7[r5] = r8;
        System.arraycopy(r6.v[r5], 0, r8, 0, r1);
        r5 = r5 + 1;
        goto L10
    L13:
        this.vectorsInitialized = r6.vectorsInitialized;
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    protected StepInterpolator doCopy() {
        return new DormandPrince853StepInterpolator(this);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaStepInterpolator
    public void reinitialize(AbstractIntegrator r1, double[] r2, double[][] r3, boolean r4, EquationsMapper r5, EquationsMapper[] r6) {
        super.reinitialize(r1, r2, r3, r4, r5, r6);
        int r7 = this.currentState.length;
        this.yDotKLast = new double[3][];
        int r8 = 0;
    L3:
        double[][] r9 = this.yDotKLast;
        if (r8 >= r9.length) goto L6;
        r9[r8] = new double[r7];
        r8 = r8 + 1;
        goto L3
    L6:
        this.v = new double[7][];
        int r10 = 0;
    L7:
        double[][] r11 = this.v;
        if (r10 >= r11.length) goto L10;
        r11[r10] = new double[r7];
        r10 = r10 + 1;
        goto L7
    L10:
        this.vectorsInitialized = false;
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void storeTime(double r1) {
        super.storeTime(r1);
        this.vectorsInitialized = false;
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    protected void computeInterpolatedStateAndDerivatives(double r46, double r48) throws MaxCountExceededException {
        char r3 = 6;
        char r4 = 5;
        if (this.vectorsInitialized == true) goto L18;
        char r9 = 7;
        if (this.v != null) goto L9;
        this.v = new double[7][];
        int r1 = 0;
    L7:
        if (r1 >= 7) goto L9;
        this.v[r1] = new double[this.interpolatedState.length];
        r1 = r1 + 1;
    L9:
        finalizeStep();
        int r2 = 0;
    L11:
        if (r2 >= this.interpolatedState.length) goto L17;
        double r10 = this.yDotK[0][r2];
        double r12 = this.yDotK[r4][r2];
        double r14 = this.yDotK[r3][r2];
        double r17 = this.yDotK[r9][r2];
        double r20 = this.yDotK[8][r2];
        double r23 = this.yDotK[9][r2];
        double r26 = this.yDotK[10][r2];
        double r29 = this.yDotK[11][r2];
        double r32 = this.yDotK[12][r2];
        double[][] r5 = this.yDotKLast;
        double r34 = r5[0][r2];
        double r36 = r5[1][r2];
        double r38 = r5[2][r2];
        double[][] r6 = this.v;
        double[] r40 = r6[0];
        double r41 = (((((((B_01 * r10) + (B_06 * r12)) + (B_07 * r14)) + (B_08 * r17)) + (B_09 * r20)) + (B_10 * r23)) + (B_11 * r26)) + (B_12 * r29);
        r40[r2] = r41;
        double r42 = r10 - r41;
        r6[1][r2] = r42;
        r6[2][r2] = (r40[r2] - r42) - this.yDotK[12][r2];
        int r7 = 0;
    L13:
        double[][] r11 = D;
        if (r7 >= r11.length) goto L16;
        double[] r8 = this.v[r7 + 3];
        double[] r13 = r11[r7];
        r8[r2] = (((((((((((r13[0] * r10) + (r13[1] * r12)) + (r13[2] * r14)) + (r13[3] * r17)) + (r13[4] * r20)) + (r13[5] * r23)) + (r13[6] * r26)) + (r13[7] * r29)) + (r13[8] * r32)) + (r13[9] * r34)) + (r13[10] * r36)) + (r13[11] * r38);
        r7 = r7 + 1;
        goto L13
    L16:
        r2 = r2 + 1;
        r9 = 7;
        r3 = 6;
        r4 = 5;
        goto L11
    L17:
        this.vectorsInitialized = true;
    L18:
        double r15 = 1.0d - r46;
        double r16 = r46 * 2.0d;
        double r18 = r46 * r46;
        double r19 = 1.0d - r16;
        double r110 = (2.0d - (r46 * 3.0d)) * r46;
        double r111 = r16 * (((r16 - 3.0d) * r46) + 1.0d);
        double r21 = ((((5.0d * r46) - 8.0d) * r46) + 3.0d) * r18;
        double r24 = ((((r46 * (15.0d - (6.0d * r46))) - 12.0d) * r46) + 3.0d) * r18;
        double r112 = (r18 * r46) * ((((r46 * (18.0d - (7.0d * r46))) - 15.0d) * r46) + 4.0d);
        if (this.previousState != null) goto L21;
    L26:
        int r22 = 0;
    L28:
        if (r22 >= this.interpolatedState.length) goto L36;
        double[] r25 = this.interpolatedState;
        double r27 = this.currentState[r22];
        double[][] r28 = this.v;
        r25[r22] = r27 - ((r28[0][r22] - ((r28[1][r22] + ((r28[2][r22] + ((r28[3][r22] + ((r28[4][r22] + ((r28[5][r22] + (r28[6][r22] * r46)) * r15)) * r46)) * r15)) * r46)) * r46)) * r48);
        double[] r30 = this.interpolatedDerivatives;
        double[][] r31 = this.v;
        r30[r22] = (((((r31[0][r22] + (r31[1][r22] * r19)) + (r31[2][r22] * r110)) + (r31[3][r22] * r111)) + (r31[4][r22] * r21)) + (r31[5][r22] * r24)) + (r31[6][r22] * r112);
        r22 = r22 + 1;
        goto L28
    L36:
        return;
    L21:
        if (r46 > 0.5d) goto L26;
        int r33 = 0;
    L24:
        if (r33 >= this.interpolatedState.length) goto L30;
        double[] r113 = this.interpolatedState;
        double r210 = this.previousState[r33];
        double r35 = this.h * r46;
        double[][] r37 = this.v;
        r113[r33] = r210 + (r35 * (r37[0][r33] + ((r37[1][r33] + ((r37[2][r33] + ((r37[3][r33] + ((r37[4][r33] + ((r37[5][r33] + (r37[6][r33] * r46)) * r15)) * r46)) * r15)) * r46)) * r15)));
        double[] r39 = this.interpolatedDerivatives;
        double[][] r43 = this.v;
        r39[r33] = (((((r43[0][r33] + (r43[1][r33] * r19)) + (r43[2][r33] * r110)) + (r43[3][r33] * r111)) + (r43[4][r33] * r21)) + (r43[5][r33] * r24)) + (r43[6][r33] * r112);
        r33 = r33 + 1;
        goto L24
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    protected void doFinalize() throws MaxCountExceededException {
        if (this.currentState != null) goto L5;
        return;
    L5:
        double[] r1 = new double[this.currentState.length];
        double r2 = getGlobalPreviousTime();
        int r5 = 0;
    L6:
        char r9 = '\n';
        char r10 = '\t';
        if (r5 >= this.currentState.length) goto L9;
        r1[r5] = this.currentState[r5] + (this.h * (((((((((this.yDotK[0][r5] * K14_01) + (this.yDotK[5][r5] * K14_06)) + (this.yDotK[6][r5] * K14_07)) + (this.yDotK[7][r5] * K14_08)) + (this.yDotK[8][r5] * K14_09)) + (this.yDotK[9][r5] * K14_10)) + (this.yDotK[10][r5] * K14_11)) + (this.yDotK[11][r5] * K14_12)) + (this.yDotK[12][r5] * K14_13)));
        r5 = r5 + 1;
        goto L6
    L9:
        this.integrator.computeDerivatives((this.h * 0.1d) + r2, r1, this.yDotKLast[0]);
        int r6 = 0;
    L11:
        if (r6 >= this.currentState.length) goto L13;
        r1[r6] = this.currentState[r6] + (this.h * ((((((((((this.yDotK[0][r6] * K15_01) + (this.yDotK[5][r6] * K15_06)) + (this.yDotK[6][r6] * K15_07)) + (this.yDotK[7][r6] * K15_08)) + (this.yDotK[8][r6] * K15_09)) + (this.yDotK[r10][r6] * 0.1521609496625161d)) + (this.yDotK[r9][r6] * K15_11)) + (this.yDotK[11][r6] * K15_12)) + (this.yDotK[12][r6] * K15_13)) + (this.yDotKLast[0][r6] * K15_14)));
        r6 = r6 + 1;
        r9 = '\n';
        r10 = '\t';
        goto L11
    L13:
        this.integrator.computeDerivatives((this.h * 0.2d) + r2, r1, this.yDotKLast[1]);
        int r7 = 0;
    L15:
        if (r7 >= this.currentState.length) goto L17;
        double r11 = ((((((((this.yDotK[0][r7] * K16_01) + (this.yDotK[5][r7] * K16_06)) + (this.yDotK[6][r7] * K16_07)) + (this.yDotK[7][r7] * K16_08)) + (this.yDotK[8][r7] * K16_09)) + (this.yDotK[9][r7] * 0.1521609496625161d)) + (this.yDotK[10][r7] * K16_11)) + (this.yDotK[11][r7] * K16_12)) + (this.yDotK[12][r7] * K16_13);
        double[][] r8 = this.yDotKLast;
        r1[r7] = this.currentState[r7] + (this.h * ((r11 + (r8[0][r7] * K16_14)) + (r8[1][r7] * K16_15)));
        r7 = r7 + 1;
        goto L15
    L17:
        this.integrator.computeDerivatives(r2 + (this.h * C16), r1, this.yDotKLast[2]);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaStepInterpolator, org.apache.commons.math3.ode.sampling.AbstractStepInterpolator, java.io.Externalizable
    public void writeExternal(ObjectOutput r6) throws IOException {
        finalizeStep();     // Catch: MaxCountExceededException -> L12
        if (this.currentState != null) goto L6;
        int r0 = -1;
    L7:
        r6.writeInt(r0);
        int r2 = 0;
    L8:
        if (r2 >= r0) goto L10;
        r6.writeDouble(this.yDotKLast[0][r2]);
        r6.writeDouble(this.yDotKLast[1][r2]);
        r6.writeDouble(this.yDotKLast[2][r2]);
        r2 = r2 + 1;
        goto L8
    L10:
        super.writeExternal(r6);
        return;
    L6:
        r0 = this.currentState.length;
    L12:
        e = move-exception;
        IOException r7 = new IOException(e.getLocalizedMessage());
        r7.initCause(e);
        throw r7;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaStepInterpolator, org.apache.commons.math3.ode.sampling.AbstractStepInterpolator, java.io.Externalizable
    public void readExternal(ObjectInput r9) throws IOException, ClassNotFoundException {
        this.yDotKLast = new double[3][];
        int r0 = r9.readInt();
        double[][] r1 = this.yDotKLast;
        double[] r2 = null;
        if (r0 >= 0) goto L5;
        double[] r3 = null;
    L6:
        r1[0] = r3;
        if (r0 >= 0) goto L9;
        double[] r4 = null;
    L10:
        r1[1] = r4;
        if (r0 < 0) goto L14;
        r2 = new double[r0];
    L14:
        r1[2] = r2;
        int r5 = 0;
    L15:
        if (r5 >= r0) goto L17;
        this.yDotKLast[0][r5] = r9.readDouble();
        this.yDotKLast[1][r5] = r9.readDouble();
        this.yDotKLast[2][r5] = r9.readDouble();
        r5 = r5 + 1;
        goto L15
    L17:
        super.readExternal(r9);
        return;
    L9:
        r4 = new double[r0];
        goto L10
    L5:
        r3 = new double[r0];
        goto L6
    }
}
