package org.apache.commons.math3.ode.nonstiff;

import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.solvers.UnivariateSolver;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.ode.ExpandableStatefulODE;
import org.apache.commons.math3.ode.events.EventHandler;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class GraggBulirschStoerIntegrator extends AdaptiveStepsizeIntegrator {
    private static final String METHOD_NAME = "Gragg-Bulirsch-Stoer";
    private double[][] coeff;
    private int[] costPerStep;
    private double[] costPerTimeUnit;
    private int maxChecks;
    private int maxIter;
    private int maxOrder;
    private int mudif;
    private double[] optimalStep;
    private double orderControl1;
    private double orderControl2;
    private boolean performTest;
    private int[] sequence;
    private double stabilityReduction;
    private double stepControl1;
    private double stepControl2;
    private double stepControl3;
    private double stepControl4;
    private boolean useInterpolationError;

    public GraggBulirschStoerIntegrator(double r15, double r17, double r19, double r21) {
        super(METHOD_NAME, r15, r17, r19, r21);
        setStabilityCheck(true, -1, -1, -1.0d);
        setControlFactors(-1.0d, -1.0d, -1.0d, -1.0d);
        setOrderControl(-1, -1.0d, -1.0d);
        setInterpolationControl(true, -1);
    }

    public GraggBulirschStoerIntegrator(double r10, double r12, double[] r14, double[] r15) {
        super(METHOD_NAME, r10, r12, r14, r15);
        setStabilityCheck(true, -1, -1, -1.0d);
        setControlFactors(-1.0d, -1.0d, -1.0d, -1.0d);
        setOrderControl(-1, -1.0d, -1.0d);
        setInterpolationControl(true, -1);
    }

    public void setStabilityCheck(boolean r1, int r2, int r3, double r4) {
        this.performTest = r1;
        if (r2 > 0) goto L5;
        r2 = 2;
    L5:
        this.maxIter = r2;
        if (r3 > 0) goto L8;
        r3 = 1;
    L8:
        this.maxChecks = r3;
        if (r4 >= 1.0E-4d) goto L11;
    L14:
        this.stabilityReduction = 0.5d;
        return;
    L11:
        if (r4 > 0.9999d) goto L14;
        this.stabilityReduction = r4;
    }

    public void setControlFactors(double r6, double r8, double r10, double r12) {
        if (r6 >= 1.0E-4d) goto L5;
    L8:
        this.stepControl1 = 0.65d;
    L10:
        if (r8 >= 1.0E-4d) goto L12;
    L15:
        this.stepControl2 = 0.94d;
    L17:
        if (r10 >= 1.0E-4d) goto L19;
    L22:
        this.stepControl3 = 0.02d;
    L24:
        if (r12 >= 1.0001d) goto L26;
    L29:
        this.stepControl4 = 4.0d;
        return;
    L26:
        if (r12 > 999.9d) goto L29;
        this.stepControl4 = r12;
        return;
    L19:
        if (r10 > 0.9999d) goto L22;
        this.stepControl3 = r10;
        goto L24
    L12:
        if (r8 > 0.9999d) goto L15;
        this.stepControl2 = r8;
        goto L17
    L5:
        if (r6 > 0.9999d) goto L8;
        this.stepControl1 = r6;
        goto L10
    }

    public void setOrderControl(int r5, double r6, double r8) {
        if (r5 > 6) goto L5;
    L6:
        this.maxOrder = 18;
    L8:
        if (r6 >= 1.0E-4d) goto L10;
    L13:
        this.orderControl1 = 0.8d;
    L15:
        if (r8 >= 1.0E-4d) goto L17;
    L20:
        this.orderControl2 = 0.9d;
    L21:
        initializeArrays();
        return;
    L17:
        if (r8 > 0.9999d) goto L20;
        this.orderControl2 = r8;
        goto L21
    L10:
        if (r6 > 0.9999d) goto L13;
        this.orderControl1 = r6;
        goto L15
    L5:
        if ((r5 % 2) == 0) goto L8;
        goto L6
    }

    @Override // org.apache.commons.math3.ode.AbstractIntegrator, org.apache.commons.math3.ode.ODEIntegrator
    public void addStepHandler(StepHandler r1) {
        super.addStepHandler(r1);
        initializeArrays();
    }

    @Override // org.apache.commons.math3.ode.AbstractIntegrator, org.apache.commons.math3.ode.ODEIntegrator
    public void addEventHandler(EventHandler r1, double r2, double r4, int r6, UnivariateSolver r7) {
        super.addEventHandler(r1, r2, r4, r6, r7);
        initializeArrays();
    }

    private void initializeArrays() {
        int r0 = this.maxOrder / 2;
        int[] r1 = this.sequence;
        if (r1 != null) goto L5;
    L6:
        this.sequence = new int[r0];
        this.costPerStep = new int[r0];
        this.coeff = new double[r0][];
        this.costPerTimeUnit = new double[r0];
        this.optimalStep = new double[r0];
    L7:
        int r2 = 0;
    L8:
        if (r2 >= r0) goto L10;
        this.sequence[r2] = (r2 * 4) + 2;
        r2 = r2 + 1;
        goto L8
    L10:
        this.costPerStep[0] = this.sequence[0] + 1;
        int r3 = 1;
    L11:
        if (r3 >= r0) goto L13;
        int[] r4 = this.costPerStep;
        r4[r3] = r4[r3 - 1] + this.sequence[r3];
        r3 = r3 + 1;
        goto L11
    L13:
        int r5 = 0;
    L14:
        if (r5 >= r0) goto L23;
        double[][] r6 = this.coeff;
        if (r5 <= 0) goto L18;
        double[] r7 = new double[r5];
    L19:
        r6[r5] = r7;
        int r8 = 0;
    L20:
        if (r8 >= r5) goto L22;
        int[] r9 = this.sequence;
        double r10 = ((double) r9[r5]) / ((double) r9[(r5 - r8) - 1]);
        this.coeff[r5][r8] = 1.0d / ((r10 * r10) - 1.0d);
        r8 = r8 + 1;
        goto L20
    L22:
        r5 = r5 + 1;
        goto L14
    L18:
        r7 = null;
        goto L19
    L23:
        return;
    L5:
        if (r1.length == r0) goto L7;
        goto L6
    }

    public void setInterpolationControl(boolean r1, int r2) {
        this.useInterpolationError = r1;
        if (r2 > 0) goto L5;
    L8:
        this.mudif = 4;
        return;
    L5:
        if (r2 >= 7) goto L8;
        this.mudif = r2;
    }

    private void rescale(double[] r9, double[] r10, double[] r11) {
        int r1 = 0;
        if (this.vecAbsoluteTolerance != null) goto L8;
    L5:
        if (r1 >= r11.length) goto L10;
        double r2 = FastMath.max(FastMath.abs(r9[r1]), FastMath.abs(r10[r1]));
        r11[r1] = this.scalAbsoluteTolerance + (this.scalRelativeTolerance * r2);
        r1 = r1 + 1;
        goto L5
    L10:
        return;
    L8:
        if (r1 >= r11.length) goto L13;
        double r3 = FastMath.max(FastMath.abs(r9[r1]), FastMath.abs(r10[r1]));
        r11[r1] = this.vecAbsoluteTolerance[r1] + (this.vecRelativeTolerance[r1] * r3);
        r1 = r1 + 1;
        goto L8
    }

    private boolean tryStep(double r24, double[] r26, double r27, int r29, double[] r30, double[][] r31, double[] r32, double[] r33, double[] r34) throws MaxCountExceededException, DimensionMismatchException {
        GraggBulirschStoerIntegrator r0 = this;
        int r2 = r29;
        int r5 = r0.sequence[r2];
        double r6 = r27 / ((double) r5);
        double r8 = 2.0d * r6;
        double r10 = r24 + r6;
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r13 >= r26.length) goto L6;
        r34[r13] = r26[r13];
        r33[r13] = r26[r13] + (r31[0][r13] * r6);
        r13 = r13 + 1;
        goto L4
    L6:
        r0.computeDerivatives(r10, r33, r31[1]);
        int r14 = 1;
    L7:
        if (r14 >= r5) goto L38;
        if ((r14 * 2) != r5) goto L12;
        System.arraycopy(r33, r12, r32, r12, r26.length);
    L12:
        r10 = r10 + r6;
        int r15 = r12;
    L14:
        if (r15 >= r26.length) goto L16;
        double r16 = r33[r15];
        r33[r15] = r34[r15] + (r31[r14][r15] * r8);
        r34[r15] = r16;
        r15 = r15 + 1;
        goto L14
    L16:
        int r17 = r14 + 1;
        r0.computeDerivatives(r10, r33, r31[r17]);
        if (r0.performTest == false) goto L35;
        if (r14 > r0.maxChecks) goto L35;
        if (r2 >= r0.maxIter) goto L35;
        double r9 = 0.0d;
        int r18 = 0;
    L24:
        if (r18 >= r30.length) goto L26;
        double r19 = r31[0][r18] / r30[r18];
        r9 = r9 + (r19 * r19);
        r18 = r18 + 1;
        goto L24
    L26:
        int r1 = 0;
        double r110 = 0.0d;
    L28:
        if (r1 >= r30.length) goto L31;
        double r111 = (r31[r17][r1] - r31[0][r1]) / r30[r1];
        r110 = r110 + (r111 * r111);
        r1 = r1 + 1;
        goto L28
    L31:
        if (r110 <= (FastMath.max(1.0E-15d, r9) * 4.0d)) goto L35;
        return false;
    L35:
        r2 = r29;
        r14 = r17;
        r8 = r8;
        r12 = 0;
        r0 = this;
    L38:
        if (r12 >= r26.length) goto L40;
        r33[r12] = ((r34[r12] + r33[r12]) + (r31[r5][r12] * r6)) * 0.5d;
        r12 = r12 + 1;
        goto L38
    L40:
        return true;
    }

    private void extrapolate(int r12, int r13, double[][] r14, double[] r15) {
        int r1 = 1;
    L3:
        int r2 = 0;
        if (r1 >= r13) goto L9;
    L6:
        if (r2 >= r15.length) goto L8;
        int r3 = r13 - r1;
        double[] r4 = r14[r3 - 1];
        double r5 = r14[r3][r2];
        r4[r2] = r5 + (this.coeff[r13 + r12][r1 - 1] * (r5 - r4[r2]));
        r2 = r2 + 1;
        goto L6
    L8:
        r1 = r1 + 1;
        goto L3
    L9:
        int r6 = 0;
    L11:
        if (r6 >= r15.length) goto L13;
        double r7 = r14[0][r6];
        r15[r6] = r7 + (this.coeff[r13 + r12][r13 - 1] * (r7 - r15[r6]));
        r6 = r6 + 1;
        goto L11
    }

    @Override // org.apache.commons.math3.ode.nonstiff.AdaptiveStepsizeIntegrator, org.apache.commons.math3.ode.AbstractIntegrator
    public void integrate(ExpandableStatefulODE r50, double r51) throws NumberIsTooSmallException, DimensionMismatchException, MaxCountExceededException, NoBracketingException {
        sanityChecks(r50, r51);
        setEquations(r50);
        int r15 = 1;
        if (r51 <= r50.getTime()) goto L5;
        boolean r11 = true;
    L6:
        double[] r10 = r50.getCompleteState();
        double[] r0 = (double[]) r10.clone();
        double[] r9 = new double[r0.length];
        double[] r8 = new double[r0.length];
        double[] r7 = new double[r0.length];
        double[] r6 = new double[r0.length];
        int[] r1 = this.sequence;
        double[][] r5 = new double[r1.length - 1][];
        double[][] r4 = new double[r1.length - 1][];
        int r2 = 0;
    L7:
        int[] r3 = this.sequence;
        if (r2 >= (r3.length - 1)) goto L10;
        r5[r2] = new double[r0.length];
        r4[r2] = new double[r0.length];
        r2 = r2 + 1;
        goto L7
    L10:
        double[][][] r12 = new double[r3.length][][];
        int r13 = 0;
    L11:
        int[] r14 = this.sequence;
        if (r13 >= r14.length) goto L18;
        double[][] r16 = new double[r14[r13] + r15][];
        r12[r13] = r16;
        r16[0] = r9;
        int r17 = 0;
    L15:
        if (r17 >= this.sequence[r13]) goto L17;
        r17 = r17 + 1;
        r12[r13][r17] = new double[r10.length];
        goto L15
    L17:
        r13 = r13 + 1;
        r15 = 1;
        goto L11
    L18:
        if (r0 == r10) goto L20;
        System.arraycopy(r10, 0, r0, 0, r10.length);
    L20:
        double[] r18 = new double[r10.length];
        double[][] r19 = r4;
        double[][] r110 = (double[][]) Array.newInstance(Double.TYPE, new int[]{(this.sequence.length * 2) + 1, r10.length});
        double[] r20 = new double[this.mainSetDimension];
        rescale(r0, r0, r20);
        if (this.vecRelativeTolerance != null) goto L23;
        double r21 = this.scalRelativeTolerance;
    L24:
        double[] r111 = r20;
        int r22 = FastMath.max(1, FastMath.min(this.sequence.length - 2, (int) FastMath.floor(0.5d - (FastMath.log10(FastMath.max(1.0E-10d, r21)) * 0.6d))));
        GraggBulirschStoerStepInterpolator r112 = r4;
        double[][] r113 = r5;
        double[] r28 = r18;
        double[] r23 = r8;
        double[] r114 = r9;
        GraggBulirschStoerStepInterpolator r24 = new GraggBulirschStoerStepInterpolator(r0, r9, r8, r18, r110, r11, r50.getPrimaryMapper(), r50.getSecondaryMappers());
        r112.storeTime(r50.getTime());
        this.stepStart = r50.getTime();
        double[] r25 = r0;
        initIntegration(r50.getTime(), r10, r51);
        this.costPerTimeUnit[0] = 0.0d;
        this.isLastStep = false;
        double r31 = Double.MAX_VALUE;
        int r34 = r22;
        double r26 = 0.0d;
        boolean r27 = true;
        boolean r29 = false;
        boolean r210 = true;
        boolean r33 = false;
    L25:
        if (r27 == false) goto L33;
        r112.shift();
        if (r29 == true) goto L29;
        computeDerivatives(this.stepStart, r25, r114);
    L29:
        if (r210 == false) goto L32;
        r26 = initializeStep(r11, (r34 * 2) + 1, r111, this.stepStart, r25, r114, r7, r6);
    L32:
        boolean r36 = false;
    L34:
        this.stepSize = r26;
        if (r11 == true) goto L37;
    L38:
        if (r11 == false) goto L40;
    L42:
        double r30 = this.stepStart + this.stepSize;
        if (r11 == false) goto L48;
        if (r30 >= r51) goto L49;
    L50:
        boolean r32 = false;
    L51:
        this.isLastStep = r32;
        byte r35 = -1;
        int r37 = -1;
        double r38 = r31;
        int r39 = r34;
        boolean r310 = true;
        boolean r311 = false;
        double r312 = r26;
    L52:
        if (r310 == false) goto L131;
        int r40 = r37 + 1;
        double r41 = this.stepStart;
        double r42 = this.stepSize;
        double[][] r43 = r12[r40];
        if (r40 != 0) goto L56;
        double[] r44 = r110[0];
    L57:
        if (r40 != 0) goto L59;
        double[] r45 = r23;
    L60:
        r112 = r112;
        r114 = r114;
        r39 = r39;
        r113 = r113;
        r10 = r10;
        r11 = r11;
        if (tryStep(r41, r25, r42, r40, r111, r43, r44, r45, r7) == false) goto L62;
        char r46 = 0;
        if (r40 <= 0) goto L129;
        double[][] r47 = r19;
        double[] r48 = r23;
        extrapolate(0, r40, r47, r48);
        double[] r115 = r111;
        double[] r49 = r25;
        rescale(r49, r48, r115);
        int r52 = 0;
        double r53 = 0.0d;
    L68:
        if (r52 >= this.mainSetDimension) goto L70;
        double r54 = FastMath.abs(r48[r52] - r47[r46][r52]) / r115[r52];
        r53 = r53 + (r54 * r54);
        r52 = r52 + 1;
        r46 = 0;
        goto L68
    L70:
        double r55 = FastMath.sqrt(r53 / ((double) this.mainSetDimension));
        if (r55 > 1.0E15d) goto L128;
        if (r40 <= 1) goto L77;
        if (r55 > r38) goto L128;
    L77:
        r38 = FastMath.max(4.0d * r55, 1.0d);
        double r56 = 1.0d / ((double) ((r40 * 2) + 1));
        r19 = r47;
        r25 = r49;
        double r57 = this.stepControl2 / FastMath.pow(r55 / this.stepControl1, r56);
        double r58 = FastMath.pow(this.stepControl3, r56);
        this.optimalStep[r40] = FastMath.abs(filterStep(this.stepSize * FastMath.max(r58 / this.stepControl4, FastMath.min(1.0d / r58, r57)), r11, true));
        double[] r59 = this.costPerTimeUnit;
        double r60 = this.costPerStep[r40];
        double[] r61 = this.optimalStep;
        double r62 = r60 / r61[r40];
        r59[r40] = r62;
        int r63 = r40 - r39;
        if (r63 == (-1)) goto L111;
        if (r63 == 0) goto L97;
        if (r63 == 1) goto L89;
        if (r210 == true) goto L86;
        if (this.isLastStep == true) goto L86;
    L125:
        r111 = r115;
    L126:
        r39 = r39;
    L127:
        r23 = r48;
    L130:
        r11 = r11;
        r113 = r113;
        r112 = r112;
        r114 = r114;
        r10 = r10;
        r35 = -1;
    L86:
        if (r55 > 1.0d) goto L125;
    L98:
        r111 = r115;
        r39 = r39;
        r310 = false;
        goto L127
    L89:
        if (r55 <= 1.0d) goto L98;
        if (r39 > 1) goto L93;
    L95:
        r312 = r61[r39];
        r311 = true;
        goto L98
    L93:
        if (r59[r39 - 1] >= (this.orderControl1 * r59[r39])) goto L95;
        r39 = r39 - 1;
        goto L95
    L97:
        if (r55 <= 1.0d) goto L98;
        int[] r64 = this.sequence;
        double r65 = ((double) r64[r40 + 1]) / ((double) r64[0]);
        if (r55 > (r65 * r65)) goto L102;
        r39 = r39;
    L109:
        r111 = r115;
        goto L127
    L102:
        if (r39 > 1) goto L104;
    L106:
        r39 = r39;
    L107:
        r312 = r61[r39];
        r310 = false;
        r311 = true;
        goto L109
    L104:
        if (r59[r39 - 1] >= (this.orderControl1 * r59[r39])) goto L106;
        r39 = r39 - 1;
        goto L107
    L111:
        if (r39 <= 1) goto L125;
        if (r33 == true) goto L125;
        if (r55 <= 1.0d) goto L98;
        int[] r66 = this.sequence;
        r111 = r115;
        double r67 = ((double) r66[r39]) * ((double) r66[r39 + 1]);
        int r68 = r66[0];
        double r69 = r67 / ((double) (r68 * r68));
        if (r55 <= (r69 * r69)) goto L126;
        if (r40 > 1) goto L121;
    L123:
        r39 = r40;
    L124:
        r312 = r61[r39];
        r310 = false;
        r311 = true;
        goto L127
    L121:
        if (r59[r40 - 1] >= (this.orderControl1 * r62)) goto L123;
        r39 = r40 - 1;
    L128:
        r19 = r47;
        r25 = r49;
        r111 = r115;
        r312 = FastMath.abs(filterStep(this.stepSize * this.stabilityReduction, r11, false));
        r23 = r48;
        r35 = -1;
        r310 = false;
    L63:
        r311 = true;
        goto L52
    L129:
        r39 = r39;
        goto L130
    L62:
        r312 = FastMath.abs(filterStep(this.stepSize * this.stabilityReduction, r11, false));
        r310 = false;
        r35 = -1;
        goto L63
    L59:
        r45 = r19[r40 - 1];
        goto L60
    L56:
        r44 = r113[r40 - 1];
        goto L57
    L131:
        double[] r410 = r10;
        GraggBulirschStoerStepInterpolator r411 = r112;
        double[] r412 = r114;
        double[][] r413 = r113;
        double[] r70 = r23;
        int r116 = r39;
        boolean r117 = r11;
        if (r311 == true) goto L134;
        double[] r71 = r28;
        computeDerivatives(this.stepStart + this.stepSize, r70, r71);
    L135:
        double r72 = getMaxStep();
        if (r311 == true) goto L178;
        int r73 = 1;
    L138:
        if (r73 > r37) goto L140;
        extrapolate(0, r73, r413, r110[0]);
        r73 = r73 + 1;
        goto L138
    L140:
        double[][] r74 = r413;
        int r75 = ((r37 * 2) - this.mudif) + 3;
        int r76 = 0;
    L141:
        if (r76 >= r75) goto L170;
        int r77 = r76 / 2;
        double r118 = FastMath.pow(((double) this.sequence[r77]) * 0.5d, r76);
        int r78 = r12[r77].length / 2;
        double r414 = r72;
        boolean r211 = r117;
        double[] r119 = r410;
        int r120 = 0;
    L144:
        if (r120 >= r119.length) goto L146;
        r110[r76 + 1][r120] = r12[r77][r78 + r76][r120] * r118;
        r120 = r120 + 1;
        goto L144
    L146:
        int r79 = 1;
    L148:
        if (r79 > (r37 - r77)) goto L154;
        int r80 = r79 + r77;
        double r121 = FastMath.pow(((double) this.sequence[r80]) * 0.5d, r76);
        int r81 = r12[r80].length / 2;
        int r212 = r116;
        int r122 = 0;
    L151:
        if (r122 >= r119.length) goto L153;
        r74[r79 - 1][r122] = r12[r80][r81 + r76][r122] * r121;
        r122 = r122 + 1;
        goto L151
    L153:
        extrapolate(r77, r79, r74, r110[r76 + 1]);
        r79 = r79 + 1;
        r116 = r212;
        goto L148
    L154:
        int r213 = r116;
        int r82 = 0;
    L156:
        if (r82 >= r119.length) goto L158;
        double[] r83 = r110[r76 + 1];
        r83[r82] = r83[r82] * this.stepSize;
        r82 = r82 + 1;
        goto L156
    L158:
        r76 = r76 + 1;
        int r84 = r76 / 2;
    L159:
        if (r84 > r37) goto L169;
        int r85 = r12[r84].length - 1;
    L162:
        if (r85 < (r76 * 2)) goto L168;
        int r86 = 0;
    L165:
        if (r86 >= r119.length) goto L167;
        double[][] r87 = r12[r84];
        double[] r123 = r87[r85];
        r123[r86] = r123[r86] - r87[r85 - 2][r86];
        r86 = r86 + 1;
        goto L165
    L167:
        r85 = r85 - 1;
        goto L162
    L168:
        r84 = r84 + 1;
        goto L159
    L169:
        r410 = r119;
        r117 = r211;
        r116 = r213;
        r72 = r414;
        goto L141
    L170:
        double r415 = r72;
        int r214 = r116;
        boolean r215 = r117;
        double[] r124 = r410;
        if (r75 < 0) goto L177;
        GraggBulirschStoerStepInterpolator r125 = r411;
        r125.computeCoefficients(r75, this.stepSize);
        double[] r126 = r111;
        if (this.useInterpolationError == false) goto L179;
        double r88 = r125.estimateError(r126);
        int r127 = r37;
        double r128 = FastMath.abs(this.stepSize / FastMath.max(FastMath.pow(r88, 1.0d / ((double) (r75 + 4))), 0.01d));
        if (r88 <= 10.0d) goto L180;
        r312 = r128;
        r311 = true;
    L180:
        if (r311 == true) goto L219;
        r125.storeTime(this.stepStart + this.stepSize);
        this.stepStart = acceptStep(r125, r70, r71, r51);
        r125.storeTime(this.stepStart);
        double[] r89 = r25;
        System.arraycopy(r70, 0, r89, 0, r124.length);
        System.arraycopy(r71, 0, r412, 0, r124.length);
        int r90 = r127;
        int r91 = 1;
        if (r90 != 1) goto L188;
        r412 = r412;
        double[] r92 = r70;
        r28 = r71;
        double[][] r416 = r74;
        int r93 = r214;
        if (r33 == true) goto L208;
        r91 = 2;
    L208:
        if (r33 == false) goto L210;
        int r94 = FastMath.min(r91, r90);
        double r313 = FastMath.min(FastMath.abs(this.stepSize), this.optimalStep[r94]);
        boolean r95 = r215;
        boolean r96 = false;
    L218:
        r34 = r94;
        double r97 = r313;
        r29 = true;
        r36 = true;
    L220:
        double r98 = FastMath.min(r97, r128);
        if (r95 == true) goto L223;
        r98 = -r98;
    L223:
        if (r311 == false) goto L225;
        this.isLastStep = r96;
        r33 = true;
    L227:
        if (this.isLastStep == true) goto L228;
        r210 = r96;
        r25 = r89;
        r26 = r98;
        r23 = r92;
        r112 = r125;
        r111 = r126;
        r10 = r124;
        r27 = r36;
        r31 = r38;
        r113 = r416;
        r114 = r412;
        r11 = r95;
        goto L25
    L228:
        r50.setTime(this.stepStart);
        r50.setCompleteState(r89);
        resetInternalState();
        return;
    L225:
        r33 = r96;
        goto L227
    L210:
        if (r91 > r90) goto L212;
        double r99 = this.optimalStep[r91];
        r95 = r215;
        r96 = false;
    L217:
        r313 = r99;
        r94 = r91;
        goto L218
    L212:
        if (r90 >= r93) goto L216;
        double[] r100 = this.costPerTimeUnit;
        if (r100[r90] >= (this.orderControl2 * r100[r90 - 1])) goto L216;
        double r101 = this.optimalStep[r90];
        int[] r102 = this.costPerStep;
        double r103 = (r101 * ((double) r102[r91 + 1])) / ((double) r102[r90]);
        r95 = r215;
        r96 = false;
        r99 = filterStep(r103, r95, false);
    L216:
        r95 = r215;
        double r104 = this.optimalStep[r90];
        int[] r105 = this.costPerStep;
        double r106 = (r104 * ((double) r105[r91])) / ((double) r105[r90]);
        r96 = false;
        r99 = filterStep(r106, r95, false);
        goto L217
    L188:
        r93 = r214;
        if (r90 > r93) goto L198;
        double[] r107 = this.costPerTimeUnit;
        int r108 = r90 - 1;
        double r314 = r107[r108];
        r412 = r412;
        double r109 = this.orderControl1;
        double r315 = r107[r90];
        if (r314 >= (r109 * r315)) goto L194;
        r91 = r108;
    L197:
        r92 = r70;
        r28 = r71;
        r416 = r74;
        goto L208
    L194:
        if (r315 >= (this.orderControl2 * r314)) goto L196;
        r91 = FastMath.min(r90 + 1, this.sequence.length - 2);
        r92 = r70;
        r28 = r71;
        r416 = r74;
        goto L208
    L196:
        r91 = r90;
        goto L197
    L198:
        r412 = r412;
        int r129 = r90 - 1;
        if (r90 <= 2) goto L203;
        double[] r130 = this.costPerTimeUnit;
        int r131 = r90 - 2;
        r92 = r70;
        r28 = r71;
        if (r130[r131] >= (this.orderControl1 * r130[r129])) goto L204;
        r91 = r131;
    L205:
        double[] r132 = this.costPerTimeUnit;
        r416 = r74;
        if (r132[r90] >= (this.orderControl2 * r132[r91])) goto L208;
        r91 = FastMath.min(r90, this.sequence.length - 2);
    L204:
        r91 = r129;
        goto L205
    L203:
        r92 = r70;
        r28 = r71;
        goto L204
    L219:
        r92 = r70;
        r28 = r71;
        r416 = r74;
        r95 = r215;
        r89 = r25;
        r96 = false;
        r34 = r214;
        r97 = r312;
    L179:
        r127 = r37;
        r128 = r415;
        goto L180
    L177:
        r126 = r111;
        r125 = r411;
        goto L179
    L178:
        r214 = r116;
        r215 = r117;
        r126 = r111;
        r74 = r413;
        r125 = r411;
        r124 = r410;
        r415 = r72;
        goto L179
    L134:
        r71 = r28;
    L49:
        r32 = true;
        goto L51
    L48:
        if (r30 > r51) goto L50;
    L40:
        if ((this.stepStart + this.stepSize) >= r51) goto L42;
    L41:
        this.stepSize = r51 - this.stepStart;
        goto L42
    L37:
        if ((this.stepStart + this.stepSize) > r51) goto L41;
    L33:
        r25 = r25;
        r36 = r27;
        goto L34
    L23:
        r21 = this.vecRelativeTolerance[0];
        goto L24
    L5:
        r11 = false;
        goto L6
    }
}
