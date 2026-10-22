package org.apache.commons.math3.fitting.leastsquares;

import java.util.Arrays;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Incrementor;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class LevenbergMarquardtOptimizer implements LeastSquaresOptimizer {
    private static final double TWO_EPS = 0.0d;
    private final double costRelativeTolerance;
    private final double initialStepBoundFactor;
    private final double orthoTolerance;
    private final double parRelativeTolerance;
    private final double qrRankingThreshold;

    private static class InternalData {
        private final double[] beta;
        private final double[] diagR;
        private final double[] jacNorm;
        private final int[] permutation;
        private final int rank;
        private final double[][] weightedJacobian;

        static /* synthetic */ double[][] access$000(InternalData r0) {
            return r0.weightedJacobian;
        }

        static /* synthetic */ int[] access$100(InternalData r0) {
            return r0.permutation;
        }

        static /* synthetic */ double[] access$200(InternalData r0) {
            return r0.diagR;
        }

        static /* synthetic */ double[] access$300(InternalData r0) {
            return r0.jacNorm;
        }

        static /* synthetic */ int access$400(InternalData r0) {
            return r0.rank;
        }

        static /* synthetic */ double[] access$500(InternalData r0) {
            return r0.beta;
        }

        InternalData(double[][] r1, int[] r2, int r3, double[] r4, double[] r5, double[] r6) {
            this.weightedJacobian = r1;
            this.permutation = r2;
            this.rank = r3;
            this.diagR = r4;
            this.jacNorm = r5;
            this.beta = r6;
        }
    }

    static {
        TWO_EPS = Precision.EPSILON * 2.0d;
    }

    public LevenbergMarquardtOptimizer() {
        this(100.0d, 1.0E-10d, 1.0E-10d, 1.0E-10d, Precision.SAFE_MIN);
    }

    public LevenbergMarquardtOptimizer(double r1, double r3, double r5, double r7, double r9) {
        this.initialStepBoundFactor = r1;
        this.costRelativeTolerance = r3;
        this.parRelativeTolerance = r5;
        this.orthoTolerance = r7;
        this.qrRankingThreshold = r9;
    }

    public LevenbergMarquardtOptimizer withInitialStepBoundFactor(double r13) {
        return new LevenbergMarquardtOptimizer(r13, this.costRelativeTolerance, this.parRelativeTolerance, this.orthoTolerance, this.qrRankingThreshold);
    }

    public LevenbergMarquardtOptimizer withCostRelativeTolerance(double r13) {
        return new LevenbergMarquardtOptimizer(this.initialStepBoundFactor, r13, this.parRelativeTolerance, this.orthoTolerance, this.qrRankingThreshold);
    }

    public LevenbergMarquardtOptimizer withParameterRelativeTolerance(double r13) {
        return new LevenbergMarquardtOptimizer(this.initialStepBoundFactor, this.costRelativeTolerance, r13, this.orthoTolerance, this.qrRankingThreshold);
    }

    public LevenbergMarquardtOptimizer withOrthoTolerance(double r13) {
        return new LevenbergMarquardtOptimizer(this.initialStepBoundFactor, this.costRelativeTolerance, this.parRelativeTolerance, r13, this.qrRankingThreshold);
    }

    public LevenbergMarquardtOptimizer withRankingThreshold(double r13) {
        return new LevenbergMarquardtOptimizer(this.initialStepBoundFactor, this.costRelativeTolerance, this.parRelativeTolerance, this.orthoTolerance, r13);
    }

    public double getInitialStepBoundFactor() {
        return this.initialStepBoundFactor;
    }

    public double getCostRelativeTolerance() {
        return this.costRelativeTolerance;
    }

    public double getParameterRelativeTolerance() {
        return this.parRelativeTolerance;
    }

    public double getOrthoTolerance() {
        return this.orthoTolerance;
    }

    public double getRankingThreshold() {
        return this.qrRankingThreshold;
    }

    @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresOptimizer
    public LeastSquaresOptimizer.Optimum optimize(LeastSquaresProblem r64) {
        LevenbergMarquardtOptimizer r13 = this;
        int r15 = r64.getObservationSize();
        int r11 = r64.getParameterSize();
        Incrementor r16 = r64.getIterationCounter();
        Incrementor r17 = r64.getEvaluationCounter();
        ConvergenceChecker<LeastSquaresProblem.Evaluation> r12 = r64.getConvergenceChecker();
        int r10 = FastMath.min(r15, r11);
        double[] r9 = new double[r11];
        double[] r8 = new double[r11];
        double[] r7 = new double[r11];
        double[] r0 = new double[r15];
        double[] r6 = new double[r15];
        double[] r5 = new double[r11];
        double[] r4 = new double[r11];
        double[] r2 = new double[r11];
        r17.incrementCount();
        LeastSquaresProblem.Evaluation r1 = r64.evaluate(r64.getStart());
        double[] r3 = r1.getResiduals().toArray();
        double r18 = r1.getCost();
        double r23 = 0.0d;
        double r25 = 0.0d;
        double r27 = 0.0d;
        boolean r22 = true;
        LeastSquaresProblem.Evaluation r14 = r1;
        double[] r19 = r1.getPoint().toArray();
    L3:
        r16.incrementCount();
        InternalData r110 = r13.qrDecomposition(r14.getJacobian(), r10);
        double[][] r30 = InternalData.access$000(r110);
        int[] r31 = InternalData.access$100(r110);
        double[] r32 = InternalData.access$200(r110);
        double[] r33 = InternalData.access$300(r110);
        double[] r35 = r2;
        int r20 = 0;
    L4:
        if (r20 >= r15) goto L6;
        r6[r20] = r3[r20];
        r20 = r20 + 1;
        goto L4
    L6:
        r13.qTy(r6, r110);
        int r21 = 0;
    L7:
        if (r21 >= r10) goto L10;
        int r36 = r31[r21];
        r30[r21][r36] = r32[r36];
        r21 = r21 + 1;
        goto L7
    L10:
        if (r22 == false) goto L22;
        double r26 = 0.0d;
        int r24 = 0;
    L12:
        if (r24 >= r11) goto L17;
        double r28 = r33[r24];
        if (r28 != 0.0d) goto L16;
        r28 = 1.0d;
    L16:
        double r38 = r19[r24] * r28;
        r26 = r26 + (r38 * r38);
        r8[r24] = r28;
        r24 = r24 + 1;
        goto L12
    L17:
        r27 = FastMath.sqrt(r26);
        if (r27 != 0.0d) goto L20;
        double r29 = r13.initialStepBoundFactor;
    L21:
        r25 = r29;
    L23:
        double[] r39 = r3;
        if (r18 == 0.0d) goto L36;
        double r34 = 0.0d;
        int r37 = 0;
    L26:
        if (r37 >= r10) goto L35;
        int r310 = r31[r37];
        double r40 = r33[r310];
        if (r40 == 0.0d) goto L34;
        double r43 = 0.0d;
        int r41 = 0;
    L30:
        if (r41 > r37) goto L32;
        r43 = r43 + (r30[r41][r310] * r6[r41]);
        r41 = r41 + 1;
        goto L30
    L32:
        r34 = FastMath.max(r34, FastMath.abs(r43) / (r40 * r18));
    L34:
        r37 = r37 + 1;
        r5 = r5;
        r4 = r4;
        goto L26
    L35:
        double[] r42 = r4;
        double[] r311 = r5;
        double r44 = r34;
    L38:
        if (r44 <= r13.orthoTolerance) goto L40;
        int r45 = 0;
    L42:
        if (r45 >= r11) goto L44;
        r8[r45] = FastMath.max(r8[r45], r33[r45]);
        r45 = r45 + 1;
        goto L42
    L44:
        LeastSquaresProblem.Evaluation r46 = r14;
        double[] r47 = r19;
        r3 = r39;
        double r312 = 0.0d;
    L46:
        if (r312 >= 1.0E-4d) goto L138;
        int r48 = 0;
    L48:
        if (r48 >= r10) goto L50;
        int r49 = r31[r48];
        r7[r49] = r47[r49];
        r48 = r48 + 1;
        goto L48
    L50:
        LeastSquaresProblem.Evaluation r50 = r14;
        double[] r313 = r35;
        int r314 = r15;
        double[] r315 = r42;
        double[] r111 = r47;
        double[] r316 = r311;
        double[] r317 = r6;
        double[] r410 = r7;
        double[] r411 = r8;
        double[] r412 = r9;
        InternalData r413 = r110;
        int r112 = r10;
        ConvergenceChecker<LeastSquaresProblem.Evaluation> r414 = r12;
        int r113 = r11;
        double r51 = determineLMParameter(r6, r25, r8, r110, r10, r316, r315, r313, r412, r23);
        double r52 = 0.0d;
        int r53 = 0;
    L51:
        if (r53 >= r112) goto L53;
        int r54 = r31[r53];
        double r55 = -r412[r54];
        r412[r54] = r55;
        r111[r54] = r410[r54] + r55;
        double r56 = r411[r54] * r412[r54];
        r52 = r52 + (r56 * r56);
        r53 = r53 + 1;
        goto L51
    L53:
        double r57 = FastMath.sqrt(r52);
        double r58 = r25;
        if (r22 == false) goto L56;
        r58 = FastMath.min(r58, r57);
    L56:
        r17.incrementCount();
        LeastSquaresProblem.Evaluation r59 = r64.evaluate(new ArrayRealVector(r111));
        double[] r60 = r59.getResiduals().toArray();
        double r114 = r59.getCost();
        double[] r115 = r59.getPoint().toArray();
        double r210 = 0.1d;
        double r211 = r114 * 0.1d;
        if (r211 >= r18) goto L59;
        double r510 = r114 / r18;
        double r511 = 1.0d - (r510 * r510);
    L60:
        int r116 = 0;
    L61:
        if (r116 >= r112) goto L66;
        int r212 = r31[r116];
        double r512 = r412[r212];
        r316[r116] = 0.0d;
        int r61 = 0;
    L63:
        if (r61 > r116) goto L65;
        r316[r61] = r316[r61] + (r30[r61][r212] * r512);
        r61 = r61 + 1;
        goto L63
    L65:
        r116 = r116 + 1;
        goto L61
    L66:
        double r513 = 0.0d;
        int r62 = 0;
    L67:
        if (r62 >= r112) goto L69;
        double r514 = r316[r62];
        r513 = r513 + (r514 * r514);
        r62 = r62 + 1;
        goto L67
    L69:
        double r515 = r18 * r18;
        double r516 = r513 / r515;
        double r517 = ((r51 * r57) * r57) / r515;
        double r518 = r516 + (r517 * 2.0d);
        double r63 = -(r516 + r517);
        if (r518 != 0.0d) goto L72;
        double r519 = 0.0d;
    L73:
        double r520 = 0.5d;
        if (r519 > 0.25d) goto L86;
        if (r511 >= 0.0d) goto L79;
        r520 = (r63 * 0.5d) / (r63 + (0.5d * r511));
    L79:
        if (r211 < r18) goto L81;
    L84:
        double r65 = FastMath.min(r58, r57 * 10.0d) * r210;
        double r66 = r51 / r210;
    L92:
        r23 = r66;
        r25 = r65;
    L94:
        if (r519 < 1.0E-4d) goto L106;
        double r67 = 0.0d;
        int r68 = 0;
    L96:
        if (r68 >= r113) goto L98;
        double r69 = r411[r68] * r115[r68];
        r67 = r67 + (r69 * r69);
        r68 = r68 + 1;
        goto L96
    L98:
        r27 = FastMath.sqrt(r67);
        ConvergenceChecker<LeastSquaresProblem.Evaluation> r70 = r414;
        if (r70 == null) goto L104;
        LeastSquaresProblem.Evaluation r71 = r50;
        if (r70.converged(r16.getCount(), r71, r59) == true) goto L103;
    L105:
        r46 = r59;
        r18 = r114;
        r22 = false;
    L110:
        double r72 = FastMath.abs(r511);
        double r73 = this.costRelativeTolerance;
        if (r72 > r73) goto L117;
        if (r518 > r73) goto L117;
        if (r519 > 2.0d) goto L117;
    L119:
        return new OptimumImpl(r46, r17.getCount(), r16.getCount());
    L117:
        if (r25 <= (this.parRelativeTolerance * r27)) goto L119;
        double r74 = FastMath.abs(r511);
        double r75 = TWO_EPS;
        if (r74 > r75) goto L130;
        if (r518 > r75) goto L130;
        if (r519 > 2.0d) goto L130;
        throw new ConvergenceException(LocalizedFormats.TOO_SMALL_COST_RELATIVE_TOLERANCE, new Object[]{Double.valueOf(this.costRelativeTolerance)});
    L130:
        if (r25 <= (r75 * r27)) goto L137;
        if (r44 <= r75) goto L135;
        r14 = r71;
        r13 = this;
        r3 = r60;
        r47 = r115;
        r10 = r112;
        r11 = r113;
        r15 = r314;
        r6 = r317;
        r7 = r410;
        r8 = r411;
        r9 = r412;
        r110 = r413;
        r12 = r70;
        r35 = r313;
        r42 = r315;
        r311 = r316;
        r312 = r519;
        goto L46
    L135:
        throw new ConvergenceException(LocalizedFormats.TOO_SMALL_ORTHOGONALITY_TOLERANCE, new Object[]{Double.valueOf(this.orthoTolerance)});
    L137:
        throw new ConvergenceException(LocalizedFormats.TOO_SMALL_PARAMETERS_RELATIVE_TOLERANCE, new Object[]{Double.valueOf(this.parRelativeTolerance)});
    L103:
        return new OptimumImpl(r59, r17.getCount(), r16.getCount());
    L104:
        r71 = r50;
        goto L105
    L106:
        r71 = r50;
        r70 = r414;
        int r76 = 0;
    L107:
        if (r76 >= r112) goto L109;
        int r77 = r31[r76];
        r115[r77] = r410[r77];
        r76 = r76 + 1;
        goto L107
    L109:
        r46 = r71;
        goto L110
    L81:
        if (r520 < 0.1d) goto L84;
        r210 = r520;
        goto L84
    L86:
        if (r51 != 0.0d) goto L88;
    L91:
        r65 = r57 * 2.0d;
        r66 = r51 * 0.5d;
        goto L92
    L88:
        if (r519 >= 0.75d) goto L91;
        r23 = r51;
        r25 = r58;
        goto L94
    L72:
        r519 = r511 / r518;
        goto L73
    L59:
        r511 = -1.0d;
        goto L60
    L138:
        r14 = r46;
        r19 = r47;
        r5 = r311;
        r4 = r42;
        r12 = r12;
        r2 = r35;
        goto L3
    L40:
        return new OptimumImpl(r14, r17.getCount(), r16.getCount());
    L36:
        r42 = r4;
        r311 = r5;
        r44 = 0.0d;
        goto L38
    L20:
        r29 = r13.initialStepBoundFactor * r27;
        goto L21
    L22:
        r3 = r3;
        goto L23
    }

    private double determineLMParameter(double[] r35, double r36, double[] r38, InternalData r39, int r40, double[] r41, double[] r42, double[] r43, double[] r44, double r45) {
        double[][] r11 = InternalData.access$000(r39);
        int[] r12 = InternalData.access$100(r39);
        int r0 = InternalData.access$400(r39);
        double[] r1 = InternalData.access$200(r39);
        int r13 = 0;
        int r2 = r11[0].length;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r44[r12[r3]] = r35[r3];
        r3 = r3 + 1;
        goto L3
    L5:
        int r4 = r0;
    L7:
        if (r4 >= r2) goto L9;
        r44[r12[r4]] = 0.0d;
        r4 = r4 + 1;
        goto L7
    L9:
        int r5 = r0 - 1;
    L10:
        if (r5 < 0) goto L15;
        int r6 = r12[r5];
        double r7 = r44[r6] / r1[r6];
        int r8 = 0;
    L12:
        if (r8 >= r5) goto L14;
        int r9 = r12[r8];
        r44[r9] = r44[r9] - (r11[r8][r6] * r7);
        r8 = r8 + 1;
        goto L12
    L14:
        r44[r6] = r7;
        r5 = r5 - 1;
        goto L10
    L15:
        int r10 = 0;
        double r14 = 0.0d;
    L16:
        if (r10 >= r40) goto L18;
        int r15 = r12[r10];
        double r16 = r38[r15] * r44[r15];
        r41[r15] = r16;
        r14 = r14 + (r16 * r16);
        r10 = r10 + 1;
        goto L16
    L18:
        double r17 = FastMath.sqrt(r14);
        double r18 = r17 - r36;
        double r19 = r36 * 0.1d;
        if (r18 > r19) goto L21;
        return 0.0d;
    L21:
        if (r0 != r40) goto L32;
        int r20 = 0;
    L23:
        if (r20 >= r40) goto L25;
        int r110 = r12[r20];
        r41[r110] = r41[r110] * (r38[r110] / r17);
        r20 = r20 + 1;
        goto L23
    L25:
        int r21 = 0;
        double r111 = 0.0d;
    L26:
        if (r21 >= r40) goto L31;
        int r22 = r12[r21];
        double r23 = 0.0d;
    L28:
        if (r13 >= r21) goto L30;
        r23 = r23 + (r11[r13][r22] * r41[r12[r13]]);
        r13 = r13 + 1;
        goto L28
    L30:
        double r24 = (r41[r22] - r23) / r1[r22];
        r41[r22] = r24;
        r111 = r111 + (r24 * r24);
        r21 = r21 + 1;
        r13 = 0;
        goto L26
    L31:
        double r25 = r18 / (r36 * r111);
    L33:
        double r112 = 0.0d;
        int r113 = 0;
    L34:
        if (r113 >= r40) goto L39;
        int r26 = r12[r113];
        double r27 = 0.0d;
        int r28 = 0;
    L36:
        if (r28 > r113) goto L38;
        r27 = r27 + (r11[r28][r26] * r35[r28]);
        r28 = r28 + 1;
        goto L36
    L38:
        double r29 = r27 / r38[r26];
        r112 = r112 + (r29 * r29);
        r113 = r113 + 1;
        goto L34
    L39:
        double r30 = FastMath.sqrt(r112);
        double r114 = r30 / r36;
        if (r114 != 0.0d) goto L42;
        r114 = Precision.SAFE_MIN / FastMath.min(r36, 0.1d);
    L42:
        double r115 = r114;
        double r116 = r18;
        double r31 = FastMath.min(r115, FastMath.max(r45, r25));
        double r210 = 0.0d;
        if (r31 != 0.0d) goto L45;
        r31 = r30 / r17;
    L45:
        int r117 = 10;
        double r32 = r115;
        double r118 = r25;
    L46:
        if (r117 < 0) goto L85;
        if (r31 != r210) goto L50;
        r31 = FastMath.max(Precision.SAFE_MIN, 0.001d * r32);
    L50:
        double r33 = FastMath.sqrt(r31);
        int r34 = 0;
    L51:
        if (r34 >= r40) goto L53;
        int r37 = r12[r34];
        r41[r37] = r38[r37] * r33;
        r34 = r34 + 1;
        goto L51
    L53:
        double r310 = r31;
        double r311 = r32;
        determineLMDirection(r35, r41, r42, r39, r40, r43, r44);
        double r46 = 0.0d;
        int r47 = 0;
    L54:
        if (r47 >= r40) goto L56;
        int r48 = r12[r47];
        double r49 = r38[r48] * r44[r48];
        r43[r48] = r49;
        r46 = r46 + (r49 * r49);
        r47 = r47 + 1;
        goto L54
    L56:
        double r50 = FastMath.sqrt(r46);
        double r51 = r50 - r36;
        if (FastMath.abs(r51) <= r19) goto L84;
        if (r118 == 0.0d) goto L61;
    L65:
        int r52 = 0;
    L66:
        if (r52 >= r40) goto L68;
        int r53 = r12[r52];
        r41[r53] = (r43[r53] * r38[r53]) / r50;
        r52 = r52 + 1;
        goto L66
    L68:
        int r54 = 0;
    L69:
        if (r54 >= r40) goto L73;
        int r55 = r12[r54];
        double r56 = r41[r55] / r42[r54];
        r41[r55] = r56;
        r54 = r54 + 1;
        int r57 = r54;
    L71:
        if (r57 >= r40) goto L69;
        int r58 = r12[r57];
        r41[r58] = r41[r58] - (r11[r57][r55] * r56);
        r57 = r57 + 1;
        goto L71
    L73:
        int r59 = 0;
        double r211 = 0.0d;
    L74:
        if (r59 >= r40) goto L76;
        double r60 = r41[r12[r59]];
        r211 = r211 + (r60 * r60);
        r59 = r59 + 1;
        goto L74
    L76:
        double r61 = r51 / (r36 * r211);
        if (r51 <= 0.0d) goto L79;
        double r62 = r310;
        r118 = FastMath.max(r118, r62);
        double r63 = r311;
    L82:
        double r64 = FastMath.max(r118, r61 + r62);
        r117 = r117 - 1;
        r32 = r63;
        r116 = r51;
        r210 = 0.0d;
        r31 = r64;
        goto L46
    L79:
        r62 = r310;
        r63 = r311;
        if (r51 >= 0.0d) goto L82;
        r63 = FastMath.min(r63, r62);
        goto L82
    L61:
        if (r51 > r116) goto L65;
        if (r116 >= 0.0d) goto L65;
    L84:
        return r310;
    L85:
        return r31;
    L32:
        r25 = 0.0d;
        goto L33
    }

    private void determineLMDirection(double[] r28, double[] r29, double[] r30, InternalData r31, int r32, double[] r33, double[] r34) {
        double[] r2 = r34;
        int[] r3 = InternalData.access$100(r31);
        double[][] r4 = InternalData.access$000(r31);
        double[] r5 = InternalData.access$200(r31);
        int r7 = 0;
    L3:
        if (r7 >= r32) goto L8;
        int r8 = r3[r7];
        int r9 = r7 + 1;
        int r10 = r9;
    L5:
        if (r10 >= r32) goto L7;
        r4[r10][r8] = r4[r7][r3[r10]];
        r10 = r10 + 1;
        goto L5
    L7:
        r2[r7] = r5[r8];
        r33[r7] = r28[r7];
        r7 = r9;
        goto L3
    L8:
        int r6 = 0;
    L9:
        double r11 = 0.0d;
        if (r6 >= r32) goto L28;
        double r12 = r29[r3[r6]];
        if (r12 == 0.0d) goto L14;
        Arrays.fill(r30, r6 + 1, r30.length, 0.0d);
    L14:
        r30[r6] = r12;
        int r13 = r6;
        double r14 = 0.0d;
    L15:
        if (r13 >= r32) goto L27;
        int r15 = r3[r13];
        if (r30[r13] == r11) goto L26;
        double r16 = r4[r13][r15];
        if (FastMath.abs(r16) >= FastMath.abs(r30[r13])) goto L21;
        double r18 = r16 / r30[r13];
        double r17 = 1.0d / FastMath.sqrt((r18 * r18) + 1.0d);
        double r19 = r17;
        double r110 = r18 * r17;
    L22:
        r4[r13][r15] = (r16 * r110) + (r30[r13] * r19);
        double r111 = r33[r13];
        double r112 = (r110 * r111) + (r19 * r14);
        double r20 = -r19;
        r14 = (r14 * r110) + (r111 * r20);
        r33[r13] = r112;
        int r113 = r13 + 1;
    L23:
        if (r113 >= r32) goto L26;
        double[] r114 = r4[r113];
        double r115 = r114[r15];
        double r23 = r30[r113];
        r30[r113] = (r115 * r20) + (r23 * r110);
        r114[r15] = (r110 * r115) + (r19 * r23);
        r113 = r113 + 1;
        goto L23
    L21:
        double r116 = r30[r13] / r16;
        r110 = 1.0d / FastMath.sqrt((r116 * r116) + 1.0d);
        r19 = r110 * r116;
    L26:
        r13 = r13 + 1;
        r3 = r3;
        r11 = 0.0d;
        goto L15
    L27:
        int[] r21 = r3;
        double[] r22 = r4[r6];
        int r24 = r21[r6];
        r30[r6] = r22[r24];
        r22[r24] = r34[r6];
        r6 = r6 + 1;
        r2 = r34;
        r3 = r21;
        goto L9
    L28:
        double[] r25 = r2;
        int[] r26 = r3;
        int r27 = r32;
        int r35 = 0;
    L29:
        if (r35 >= r32) goto L38;
        if (r30[r35] != 0.0d) goto L34;
        if (r27 != r32) goto L34;
        r27 = r35;
    L34:
        if (r27 >= r32) goto L36;
        r33[r35] = 0.0d;
    L36:
        r35 = r35 + 1;
        goto L29
    L38:
        if (r27 <= 0) goto L45;
        int r1 = r27 - 1;
    L40:
        if (r1 < 0) goto L45;
        int r36 = r26[r1];
        int r37 = r1 + 1;
        double r38 = 0.0d;
    L42:
        if (r37 >= r27) goto L44;
        r38 = r38 + (r4[r37][r36] * r33[r37]);
        r37 = r37 + 1;
        goto L42
    L44:
        r33[r1] = (r33[r1] - r38) / r30[r1];
        r1 = r1 - 1;
    L45:
        int r0 = 0;
    L47:
        if (r0 >= r25.length) goto L49;
        r25[r26[r0]] = r33[r0];
        r0 = r0 + 1;
        goto L47
    }

    private InternalData qrDecomposition(RealMatrix r25, int r26) throws ConvergenceException {
        double[][] r2 = r25.scalarMultiply(-1.0d).getData();
        int r0 = r2.length;
        char r1 = 0;
        int r3 = r2[0].length;
        int[] r4 = new int[r3];
        double[] r5 = new double[r3];
        double[] r6 = new double[r3];
        double[] r7 = new double[r3];
        int r8 = 0;
    L3:
        if (r8 >= r3) goto L8;
        r4[r8] = r8;
        int r11 = 0;
        double r9 = 0.0d;
    L5:
        if (r11 >= r0) goto L7;
        double r12 = r2[r11][r8];
        r9 = r9 + (r12 * r12);
        r11 = r11 + 1;
        goto L5
    L7:
        r6[r8] = FastMath.sqrt(r9);
        r8 = r8 + 1;
        goto L3
    L8:
        int r10 = 0;
    L9:
        if (r10 >= r3) goto L43;
        int r13 = -1;
        double r14 = Double.NEGATIVE_INFINITY;
        int r15 = r10;
    L11:
        if (r15 >= r3) goto L26;
        int r16 = r10;
        double r17 = 0.0d;
    L13:
        if (r16 >= r0) goto L16;
        double r18 = r2[r16][r4[r15]];
        r17 = r17 + (r18 * r18);
        r16 = r16 + 1;
        goto L13
    L16:
        if (Double.isInfinite(r17) == true) goto L23;
        if (Double.isNaN(r17) == true) goto L23;
        if (r17 <= r14) goto L22;
        r13 = r15;
        r14 = r17;
    L22:
        r15 = r15 + 1;
    L23:
        LocalizedFormats r19 = LocalizedFormats.UNABLE_TO_PERFORM_QR_DECOMPOSITION_ON_JACOBIAN;
        Object[] r20 = new Object[2];
        r20[r1] = Integer.valueOf(r0);
        r20[1] = Integer.valueOf(r3);
        throw new ConvergenceException(r19, r20);
    L26:
        if (r14 <= this.qrRankingThreshold) goto L28;
        int r21 = r4[r13];
        r4[r13] = r4[r10];
        r4[r10] = r21;
        double r110 = r2[r10][r21];
        double[][] r27 = r2;
        double r22 = FastMath.sqrt(r14);
        if (r110 <= 0.0d) goto L32;
        r22 = -r22;
    L32:
        double r111 = 1.0d / (r14 - (r110 * r22));
        r7[r21] = r111;
        r5[r21] = r22;
        double[] r112 = r27[r10];
        r112[r21] = r112[r21] - r22;
        int r23 = (r3 - 1) - r10;
    L33:
        if (r23 <= 0) goto L41;
        int r24 = r10;
        double r113 = 0.0d;
    L35:
        if (r24 >= r0) goto L37;
        double[] r114 = r27[r24];
        r113 = r113 + (r114[r21] * r114[r4[r10 + r23]]);
        r24 = r24 + 1;
        goto L35
    L37:
        double r115 = r113 * r111;
        int r28 = r10;
    L38:
        if (r28 >= r0) goto L40;
        double[] r116 = r27[r28];
        int r117 = r4[r10 + r23];
        r116[r117] = r116[r117] - (r116[r21] * r115);
        r28 = r28 + 1;
        goto L38
    L40:
        r23 = r23 - 1;
        goto L33
    L41:
        r10 = r10 + 1;
        r2 = r27;
        r1 = 0;
        goto L9
    L28:
        return new InternalData(r2, r4, r10, r5, r6, r7);
    L43:
        return new InternalData(r2, r4, r26, r5, r6, r7);
    }

    private void qTy(double[] r13, InternalData r14) {
        double[][] r12 = InternalData.access$000(r14);
        int[] r0 = InternalData.access$100(r14);
        double[] r15 = InternalData.access$500(r14);
        int r1 = r12.length;
        int r2 = 0;
        int r3 = r12[0].length;
    L3:
        if (r2 >= r3) goto L11;
        int r4 = r0[r2];
        double r5 = 0.0d;
        int r7 = r2;
    L5:
        if (r7 >= r1) goto L7;
        r5 = r5 + (r12[r7][r4] * r13[r7]);
        r7 = r7 + 1;
        goto L5
    L7:
        double r6 = r5 * r15[r4];
        int r8 = r2;
    L8:
        if (r8 >= r1) goto L10;
        r13[r8] = r13[r8] - (r12[r8][r4] * r6);
        r8 = r8 + 1;
        goto L8
    L10:
        r2 = r2 + 1;
        goto L3
    }
}
