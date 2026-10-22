package org.apache.commons.math3.optim.nonlinear.vector.jacobian;

import java.util.Arrays;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.PointVectorValuePair;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class LevenbergMarquardtOptimizer extends AbstractLeastSquaresOptimizer {
    private static final double TWO_EPS = 0.0d;
    private double[] beta;
    private final double costRelativeTolerance;
    private double[] diagR;
    private final double initialStepBoundFactor;
    private double[] jacNorm;
    private double[] lmDir;
    private double lmPar;
    private final double orthoTolerance;
    private final double parRelativeTolerance;
    private int[] permutation;
    private final double qrRankingThreshold;
    private int rank;
    private int solvedCols;
    private double[][] weightedJacobian;
    private double[] weightedResidual;

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    protected /* bridge */ /* synthetic */ Object doOptimize() {
        return doOptimize();
    }

    static {
        TWO_EPS = Precision.EPSILON * 2.0d;
    }

    public LevenbergMarquardtOptimizer() {
        this(100.0d, 1.0E-10d, 1.0E-10d, 1.0E-10d, Precision.SAFE_MIN);
    }

    public LevenbergMarquardtOptimizer(ConvergenceChecker<PointVectorValuePair> r13) {
        this(100.0d, r13, 1.0E-10d, 1.0E-10d, 1.0E-10d, Precision.SAFE_MIN);
    }

    public LevenbergMarquardtOptimizer(double r1, ConvergenceChecker<PointVectorValuePair> r3, double r4, double r6, double r8, double r10) {
        super(r3);
        this.initialStepBoundFactor = r1;
        this.costRelativeTolerance = r4;
        this.parRelativeTolerance = r6;
        this.orthoTolerance = r8;
        this.qrRankingThreshold = r10;
    }

    public LevenbergMarquardtOptimizer(double r12, double r14, double r16) {
        this(100.0d, r12, r14, r16, Precision.SAFE_MIN);
    }

    public LevenbergMarquardtOptimizer(double r2, double r4, double r6, double r8, double r10) {
        super(null);
        this.initialStepBoundFactor = r2;
        this.costRelativeTolerance = r4;
        this.parRelativeTolerance = r6;
        this.orthoTolerance = r8;
        this.qrRankingThreshold = r10;
    }

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    protected PointVectorValuePair doOptimize() {
        checkParameters();
        int r9 = getTarget().length;
        double[] r10 = getStartPoint();
        int r11 = r10.length;
        this.solvedCols = FastMath.min(r9, r11);
        this.diagR = new double[r11];
        this.jacNorm = new double[r11];
        this.beta = new double[r11];
        this.permutation = new int[r11];
        this.lmDir = new double[r11];
        double[] r12 = new double[r11];
        double[] r13 = new double[r11];
        double[] r0 = new double[r9];
        double[] r1 = new double[r9];
        double[] r14 = new double[r9];
        double[] r15 = new double[r11];
        RealMatrix r5 = getWeightSquareRoot();
        double[] r2 = computeObjectiveValue(r10);
        double[] r3 = computeResiduals(r2);
        PointVectorValuePair r4 = new PointVectorValuePair(r10, r2);
        double r16 = computeCost(r3);
        double[] r19 = new double[r11];
        double[] r18 = new double[r11];
        this.lmPar = 0.0d;
        ConvergenceChecker<PointVectorValuePair> r6 = getConvergenceChecker();
        double r7 = r16;
        double r22 = 0.0d;
        double r24 = 0.0d;
        PointVectorValuePair r17 = r4;
        boolean r8 = true;
    L3:
        incrementIterationCount();
        double[] r26 = r0;
        qrDecomposition(computeWeightedJacobian(r10));
        this.weightedResidual = r5.operate(r3);
        int r20 = 0;
    L4:
        if (r20 >= r9) goto L6;
        r14[r20] = this.weightedResidual[r20];
        r20 = r20 + 1;
        r2 = r2;
        goto L4
    L6:
        double[] r28 = r2;
        qTy(r14);
        int r21 = 0;
    L8:
        if (r21 >= this.solvedCols) goto L10;
        int r23 = this.permutation[r21];
        this.weightedJacobian[r21][r23] = this.diagR[r23];
        r21 = r21 + 1;
        r3 = r3;
        r6 = r6;
        goto L8
    L10:
        double[] r29 = r3;
        ConvergenceChecker<PointVectorValuePair> r30 = r6;
        if (r8 == false) goto L23;
        int r25 = 0;
        double r27 = 0.0d;
    L13:
        if (r25 >= r11) goto L18;
        double r210 = this.jacNorm[r25];
        if (r210 != 0.0d) goto L17;
        r210 = 1.0d;
    L17:
        double r211 = r10[r25] * r210;
        r27 = r27 + (r211 * r211);
        r12[r25] = r210;
        r25 = r25 + 1;
        goto L13
    L18:
        r24 = FastMath.sqrt(r27);
        double r212 = 0.0d;
        if (r24 != 0.0d) goto L21;
        double r31 = this.initialStepBoundFactor;
    L22:
        r22 = r31;
    L25:
        if (r7 == r212) goto L38;
        double r32 = r212;
        int r33 = 0;
    L28:
        if (r33 >= this.solvedCols) goto L37;
        int r34 = this.permutation[r33];
        boolean r35 = r8;
        double r36 = this.jacNorm[r34];
        if (r36 == r212) goto L35;
        double r37 = r212;
        int r38 = 0;
    L32:
        if (r38 > r33) goto L34;
        r37 = r37 + (this.weightedJacobian[r38][r34] * r14[r38]);
        r38 = r38 + 1;
        r5 = r5;
        goto L32
    L34:
        RealMatrix r39 = r5;
        r32 = FastMath.max(r32, FastMath.abs(r37) / (r36 * r7));
    L36:
        r33 = r33 + 1;
        r8 = r35;
        r5 = r39;
        goto L28
    L35:
        r39 = r5;
        goto L36
    L37:
        boolean r310 = r8;
        RealMatrix r311 = r5;
        double r312 = r32;
    L40:
        if (r312 <= this.orthoTolerance) goto L41;
        int r40 = 0;
    L44:
        if (r40 >= r11) goto L46;
        r12[r40] = FastMath.max(r12[r40], this.jacNorm[r40]);
        r40 = r40 + 1;
        goto L44
    L46:
        PointVectorValuePair r41 = r17;
        double r42 = r212;
        r0 = r26;
        r3 = r29;
        double[] r43 = r28;
        double r213 = r24;
        double r214 = r22;
        double r215 = r7;
    L48:
        if (r42 >= 1.0E-4d) goto L144;
        int r44 = 0;
    L51:
        if (r44 >= this.solvedCols) goto L53;
        int r45 = this.permutation[r44];
        r13[r45] = r10[r45];
        r44 = r44 + 1;
        goto L51
    L53:
        double[] r46 = this.weightedResidual;
        this.weightedResidual = r0;
        ConvergenceChecker<PointVectorValuePair> r47 = r30;
        int r313 = r9;
        RealMatrix r216 = r311;
        double[] r110 = r19;
        double r111 = r212;
        double[] r217 = r14;
        double[] r48 = r18;
        double[] r49 = r43;
        double[] r57 = r18;
        double[] r112 = r46;
        PointVectorValuePair r113 = r17;
        determineLMParameter(r14, r214, r12, r15, r48, r110);
        double r50 = r111;
        int r51 = 0;
    L55:
        if (r51 >= this.solvedCols) goto L57;
        int r52 = this.permutation[r51];
        double[] r53 = this.lmDir;
        double r54 = -r53[r52];
        r53[r52] = r54;
        r10[r52] = r13[r52] + r54;
        double r55 = r12[r52] * r53[r52];
        r50 = r50 + (r55 * r55);
        r51 = r51 + 1;
        goto L55
    L57:
        double r56 = FastMath.sqrt(r50);
        double r58 = r214;
        if (r310 == false) goto L60;
        r58 = FastMath.min(r58, r56);
    L60:
        double[] r59 = computeObjectiveValue(r10);
        double[] r60 = computeResiduals(r59);
        PointVectorValuePair r61 = new PointVectorValuePair(r10, r59);
        double r62 = computeCost(r60);
        double r314 = 0.1d;
        double r410 = r62 * 0.1d;
        if (r410 >= r215) goto L63;
        double r411 = r62 / r215;
        double r412 = 1.0d - (r411 * r411);
    L64:
        double[] r413 = r13;
        int r63 = 0;
    L66:
        if (r63 >= this.solvedCols) goto L71;
        int r114 = this.permutation[r63];
        double r414 = r62;
        double r64 = this.lmDir[r114];
        r15[r63] = r111;
        PointVectorValuePair r415 = r61;
        int r65 = 0;
    L68:
        if (r65 > r63) goto L70;
        r15[r65] = r15[r65] + (this.weightedJacobian[r65][r114] * r64);
        r65 = r65 + 1;
        r113 = r113;
        goto L68
    L70:
        r63 = r63 + 1;
        r62 = r414;
        r61 = r415;
        goto L66
    L71:
        PointVectorValuePair r416 = r61;
        double r417 = r62;
        PointVectorValuePair r510 = r113;
        double r66 = r111;
        int r67 = 0;
    L73:
        if (r67 >= this.solvedCols) goto L75;
        double r115 = r15[r67];
        r66 = r66 + (r115 * r115);
        r67 = r67 + 1;
        goto L73
    L75:
        double r68 = r215 * r215;
        double r69 = r66 / r68;
        double r116 = this.lmPar;
        double r418 = ((r116 * r56) * r56) / r68;
        double r511 = r69 + (r418 * 2.0d);
        double r70 = -(r69 + r418);
        if (r511 != r111) goto L78;
        double r419 = r111;
    L79:
        double r512 = 0.5d;
        if (r419 > 0.25d) goto L92;
        if (r412 >= r111) goto L85;
        r512 = (r70 * 0.5d) / (r70 + (0.5d * r412));
    L85:
        if (r410 < r215) goto L87;
    L90:
        double r71 = FastMath.min(r58, r56 * 10.0d) * r314;
        this.lmPar /= r314;
    L99:
        if (r419 < 1.0E-4d) goto L111;
        double r72 = r111;
        int r73 = 0;
    L101:
        if (r73 >= r11) goto L103;
        double r117 = r12[r73] * r10[r73];
        r72 = r72 + (r117 * r117);
        r73 = r73 + 1;
        goto L101
    L103:
        r213 = FastMath.sqrt(r72);
        if (r47 == null) goto L109;
        PointVectorValuePair r74 = r416;
        PointVectorValuePair r75 = r510;
        double r118 = r417;
        if (r47.converged(getIterations(), r75, r74) == true) goto L107;
    L110:
        r43 = r59;
        r310 = false;
    L116:
        double r218 = FastMath.abs(r412);
        double r76 = this.costRelativeTolerance;
        if (r218 > r76) goto L123;
        if (r511 > r76) goto L123;
        if (r419 > 2.0d) goto L123;
    L124:
        setCost(r118);
        return r74;
    L123:
        if (r71 <= (this.parRelativeTolerance * r213)) goto L124;
        double r77 = FastMath.abs(r412);
        double r219 = TWO_EPS;
        if (r77 > r219) goto L136;
        if (r511 > r219) goto L136;
        if (r419 > 2.0d) goto L136;
        throw new ConvergenceException(LocalizedFormats.TOO_SMALL_COST_RELATIVE_TOLERANCE, new Object[]{Double.valueOf(this.costRelativeTolerance)});
    L136:
        if (r71 <= (r219 * r213)) goto L143;
        if (r312 <= r219) goto L141;
        r41 = r74;
        r215 = r118;
        r14 = r217;
        r3 = r60;
        r311 = r216;
        r13 = r413;
        r214 = r71;
        r0 = r112;
        r212 = r111;
        r19 = r110;
        r18 = r57;
        r17 = r75;
        r42 = r419;
        r30 = r47;
        r9 = r313;
        goto L48
    L141:
        throw new ConvergenceException(LocalizedFormats.TOO_SMALL_ORTHOGONALITY_TOLERANCE, new Object[]{Double.valueOf(this.orthoTolerance)});
    L143:
        throw new ConvergenceException(LocalizedFormats.TOO_SMALL_PARAMETERS_RELATIVE_TOLERANCE, new Object[]{Double.valueOf(this.parRelativeTolerance)});
    L107:
        setCost(r118);
        return r74;
    L109:
        r118 = r417;
        r74 = r416;
        r75 = r510;
        goto L110
    L111:
        r75 = r510;
        int r78 = 0;
    L113:
        if (r78 >= this.solvedCols) goto L115;
        int r79 = this.permutation[r78];
        r10[r79] = r413[r79];
        r78 = r78 + 1;
        goto L113
    L115:
        double[] r80 = this.weightedResidual;
        this.weightedResidual = r112;
        r43 = r49;
        r74 = new PointVectorValuePair(r10, r43);
        r112 = r80;
        r118 = r215;
        goto L116
    L87:
        if (r512 < 0.1d) goto L90;
        r314 = r512;
        goto L90
    L92:
        if (r116 != r111) goto L94;
    L97:
        r71 = r56 * 2.0d;
        this.lmPar = r116 * 0.5d;
        goto L99
    L94:
        if (r419 >= 0.75d) goto L97;
        r71 = r58;
        goto L99
    L78:
        r419 = r412 / r511;
        goto L79
    L63:
        r412 = -1.0d;
        goto L64
    L144:
        double r81 = r214;
        r17 = r41;
        r2 = r43;
        r19 = r19;
        r7 = r215;
        r24 = r213;
        r8 = r310;
        r22 = r81;
        r6 = r30;
        r9 = r9;
        r5 = r311;
        goto L3
    L41:
        setCost(r7);
        return r17;
    L38:
        r310 = r8;
        r311 = r5;
        r312 = r212;
        goto L40
    L21:
        r31 = this.initialStepBoundFactor * r24;
        goto L22
    L23:
        r212 = 0.0d;
        goto L25
    }

    private void determineLMParameter(double[] r32, double r33, double[] r35, double[] r36, double[] r37, double[] r38) {
        double[] r1 = r32;
        double r2 = r33;
        int r8 = 0;
        int r7 = this.weightedJacobian[0].length;
        int r9 = 0;
    L3:
        int r10 = this.rank;
        if (r9 >= r10) goto L7;
        this.lmDir[this.permutation[r9]] = r1[r9];
        r9 = r9 + 1;
    L7:
        if (r10 >= r7) goto L9;
        this.lmDir[this.permutation[r10]] = 0.0d;
        r10 = r10 + 1;
        goto L7
    L9:
        int r11 = this.rank - 1;
    L10:
        if (r11 < 0) goto L15;
        int r12 = this.permutation[r11];
        double r13 = this.lmDir[r12] / this.diagR[r12];
        int r14 = r8;
    L12:
        if (r14 >= r11) goto L14;
        double[] r15 = this.lmDir;
        int r16 = this.permutation[r14];
        r15[r16] = r15[r16] - (this.weightedJacobian[r14][r12] * r13);
        r14 = r14 + 1;
        goto L12
    L14:
        this.lmDir[r12] = r13;
        r11 = r11 - 1;
        r8 = 0;
        goto L10
    L15:
        double r17 = 0.0d;
        int r18 = 0;
    L17:
        if (r18 >= this.solvedCols) goto L19;
        int r19 = this.permutation[r18];
        double r110 = r35[r19] * this.lmDir[r19];
        r36[r19] = r110;
        r17 = r17 + (r110 * r110);
        r18 = r18 + 1;
        goto L17
    L19:
        double r20 = FastMath.sqrt(r17);
        double r21 = r20 - r2;
        double r111 = r2 * 0.1d;
        if (r21 > r111) goto L24;
        this.lmPar = 0.0d;
        return;
    L24:
        if (this.rank != this.solvedCols) goto L37;
        int r112 = 0;
    L27:
        if (r112 >= this.solvedCols) goto L29;
        int r113 = this.permutation[r112];
        r36[r113] = r36[r113] * (r35[r113] / r20);
        r112 = r112 + 1;
        goto L27
    L29:
        double r114 = 0.0d;
        int r115 = 0;
    L31:
        if (r115 >= this.solvedCols) goto L36;
        int r116 = this.permutation[r115];
        int r117 = 0;
        double r23 = 0.0d;
    L33:
        if (r117 >= r115) goto L35;
        r23 = r23 + (this.weightedJacobian[r117][r116] * r36[this.permutation[r117]]);
        r117 = r117 + 1;
        goto L33
    L35:
        double r25 = (r36[r116] - r23) / this.diagR[r116];
        r36[r116] = r25;
        r114 = r114 + (r25 * r25);
        r115 = r115 + 1;
        goto L31
    L36:
        double r118 = r21 / (r114 * r2);
    L38:
        int r5 = 0;
        double r119 = 0.0d;
    L40:
        if (r5 >= this.solvedCols) goto L45;
        int r120 = this.permutation[r5];
        double r26 = r21;
        int r22 = 0;
        double r24 = 0.0d;
    L42:
        if (r22 > r5) goto L44;
        r24 = r24 + (this.weightedJacobian[r22][r120] * r1[r22]);
        r22 = r22 + 1;
        goto L42
    L44:
        double r27 = r24 / r35[r120];
        r119 = r119 + (r27 * r27);
        r5 = r5 + 1;
        r21 = r26;
        goto L40
    L45:
        double r28 = r21;
        double r29 = FastMath.sqrt(r119);
        double r121 = r29 / r2;
        double r122 = 0.0d;
        if (r121 != 0.0d) goto L48;
        r121 = Precision.SAFE_MIN / FastMath.min(r2, 0.1d);
    L48:
        double r6 = FastMath.min(r121, FastMath.max(this.lmPar, r118));
        this.lmPar = r6;
        if (r6 != 0.0d) goto L51;
        this.lmPar = r29 / r20;
    L51:
        int r30 = 10;
        double r31 = r28;
    L52:
        if (r30 < 0) goto L120;
        if (this.lmPar != r122) goto L57;
        this.lmPar = FastMath.max(Precision.SAFE_MIN, r121 * 0.001d);
    L57:
        double r34 = FastMath.sqrt(this.lmPar);
        int r39 = 0;
    L59:
        if (r39 >= this.solvedCols) goto L61;
        int r40 = this.permutation[r39];
        r36[r40] = r35[r40] * r34;
        r39 = r39 + 1;
        goto L59
    L61:
        determineLMDirection(r1, r36, r37, r38);
        double r41 = 0.0d;
        int r123 = 0;
    L63:
        if (r123 >= this.solvedCols) goto L65;
        int r124 = this.permutation[r123];
        double r125 = r35[r124] * this.lmDir[r124];
        r38[r124] = r125;
        r41 = r41 + (r125 * r125);
        r123 = r123 + 1;
        goto L63
    L65:
        double r42 = FastMath.sqrt(r41);
        double r126 = r42 - r2;
        if (FastMath.abs(r126) <= r111) goto L96;
        if (r118 == 0.0d) goto L70;
    L74:
        int r3 = 0;
    L76:
        if (r3 >= this.solvedCols) goto L78;
        int r127 = this.permutation[r3];
        r36[r127] = (r38[r127] * r35[r127]) / r42;
        r3 = r3 + 1;
        goto L76
    L78:
        int r4 = 0;
    L80:
        if (r4 >= this.solvedCols) goto L85;
        int r43 = this.permutation[r4];
        double r210 = r36[r43] / r37[r4];
        r36[r43] = r210;
        r4 = r4 + 1;
        int r44 = r4;
    L83:
        if (r44 >= this.solvedCols) goto L80;
        int r128 = this.permutation[r44];
        r36[r128] = r36[r128] - (this.weightedJacobian[r44][r43] * r210);
        r44 = r44 + 1;
        goto L83
    L85:
        int r45 = 0;
        double r46 = 0.0d;
    L87:
        if (r45 >= this.solvedCols) goto L89;
        double r211 = r36[this.permutation[r45]];
        r46 = r46 + (r211 * r211);
        r45 = r45 + 1;
        goto L87
    L89:
        double r47 = r126 / (r46 * r2);
        r122 = 0.0d;
        if (r126 <= 0.0d) goto L93;
        r118 = FastMath.max(r118, this.lmPar);
    L95:
        this.lmPar = FastMath.max(r118, this.lmPar + r47);
        r30 = r30 - 1;
        r1 = r32;
        r2 = r33;
        r31 = r126;
        goto L52
    L93:
        if (r126 >= 0.0d) goto L95;
        r121 = FastMath.min(r121, this.lmPar);
        goto L95
    L70:
        if (r126 > r31) goto L74;
        if (r31 >= 0.0d) goto L74;
        return;
    L96:
        return;
    L120:
        return;
    L37:
        r118 = 0.0d;
        goto L38
    }

    private void determineLMDirection(double[] r30, double[] r31, double[] r32, double[] r33) {
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= this.solvedCols) goto L10;
        int r4 = this.permutation[r3];
        int r5 = r3 + 1;
        int r6 = r5;
    L7:
        if (r6 >= this.solvedCols) goto L9;
        double[][] r7 = this.weightedJacobian;
        r7[r6][r4] = r7[r3][this.permutation[r6]];
        r6 = r6 + 1;
        goto L7
    L9:
        this.lmDir[r3] = this.diagR[r4];
        r33[r3] = r30[r3];
        r3 = r5;
        goto L4
    L10:
        int r8 = 0;
    L11:
        int r9 = this.solvedCols;
        double r10 = 0.0d;
        if (r8 >= r9) goto L31;
        double r11 = r31[this.permutation[r8]];
        if (r11 == 0.0d) goto L16;
        Arrays.fill(r32, r8 + 1, r32.length, 0.0d);
    L16:
        r32[r8] = r11;
        int r12 = r8;
        double r13 = 0.0d;
    L18:
        if (r12 >= this.solvedCols) goto L30;
        int r14 = this.permutation[r12];
        if (r32[r12] == r10) goto L29;
        double r15 = this.weightedJacobian[r12][r14];
        if (FastMath.abs(r15) >= FastMath.abs(r32[r12])) goto L24;
        double r16 = r15 / r32[r12];
        double r17 = 1.0d / FastMath.sqrt((r16 * r16) + 1.0d);
        double r18 = r16 * r17;
    L25:
        this.weightedJacobian[r12][r14] = (r15 * r18) + (r32[r12] * r17);
        double r19 = r33[r12];
        double r110 = (r18 * r19) + (r17 * r13);
        double r20 = -r17;
        r13 = (r13 * r18) + (r19 * r20);
        r33[r12] = r110;
        int r111 = r12 + 1;
    L27:
        if (r111 >= this.solvedCols) goto L29;
        double[] r112 = this.weightedJacobian[r111];
        double r113 = r112[r14];
        double r23 = r32[r111];
        r32[r111] = (r113 * r20) + (r23 * r18);
        r112[r14] = (r18 * r113) + (r17 * r23);
        r111 = r111 + 1;
        goto L27
    L24:
        double r114 = r32[r12] / r15;
        double r115 = 1.0d / FastMath.sqrt((r114 * r114) + 1.0d);
        r17 = r115 * r114;
        r18 = r115;
    L29:
        r12 = r12 + 1;
        r10 = 0.0d;
        goto L18
    L30:
        double[] r21 = this.weightedJacobian[r8];
        int r22 = this.permutation[r8];
        r32[r8] = r21[r22];
        r21[r22] = this.lmDir[r8];
        r8 = r8 + 1;
        goto L11
    L31:
        int r24 = 0;
    L32:
        int r25 = this.solvedCols;
        if (r24 >= r25) goto L42;
        if (r32[r24] != 0.0d) goto L38;
        if (r9 != r25) goto L38;
        r9 = r24;
    L38:
        if (r9 >= r25) goto L40;
        r33[r24] = 0.0d;
    L40:
        r24 = r24 + 1;
        goto L32
    L42:
        if (r9 <= 0) goto L49;
        int r26 = r9 - 1;
    L44:
        if (r26 < 0) goto L49;
        int r27 = this.permutation[r26];
        int r28 = r26 + 1;
        double r116 = 0.0d;
    L46:
        if (r28 >= r9) goto L48;
        r116 = r116 + (this.weightedJacobian[r28][r27] * r33[r28]);
        r28 = r28 + 1;
        goto L46
    L48:
        r33[r26] = (r33[r26] - r116) / r32[r26];
        r26 = r26 - 1;
    L49:
        double[] r1 = this.lmDir;
        if (r2 >= r1.length) goto L52;
        r1[this.permutation[r2]] = r33[r2];
        r2 = r2 + 1;
        goto L49
    }

    private void qrDecomposition(RealMatrix r20) throws ConvergenceException {
        double[][] r1 = r20.scalarMultiply(-1.0d).getData();
        this.weightedJacobian = r1;
        int r2 = r1.length;
        char r3 = 0;
        int r4 = r1[0].length;
        int r5 = 0;
    L3:
        double r6 = 0.0d;
        if (r5 >= r4) goto L9;
        this.permutation[r5] = r5;
        int r7 = 0;
    L6:
        if (r7 >= r2) goto L8;
        double r8 = this.weightedJacobian[r7][r5];
        r6 = r6 + (r8 * r8);
        r7 = r7 + 1;
        goto L6
    L8:
        this.jacNorm[r5] = FastMath.sqrt(r6);
        r5 = r5 + 1;
        goto L3
    L9:
        int r9 = 0;
    L10:
        if (r9 >= r4) goto L43;
        int r10 = -1;
        double r11 = Double.NEGATIVE_INFINITY;
        int r12 = r9;
    L12:
        if (r12 >= r4) goto L27;
        int r13 = r9;
        double r14 = 0.0d;
    L14:
        if (r13 >= r2) goto L17;
        double r15 = this.weightedJacobian[r13][this.permutation[r12]];
        r14 = r14 + (r15 * r15);
        r13 = r13 + 1;
        goto L14
    L17:
        if (Double.isInfinite(r14) == true) goto L24;
        if (Double.isNaN(r14) == true) goto L24;
        if (r14 <= r11) goto L23;
        r10 = r12;
        r11 = r14;
    L23:
        r12 = r12 + 1;
    L24:
        LocalizedFormats r16 = LocalizedFormats.UNABLE_TO_PERFORM_QR_DECOMPOSITION_ON_JACOBIAN;
        Object[] r17 = new Object[2];
        r17[r3] = Integer.valueOf(r2);
        r17[1] = Integer.valueOf(r4);
        throw new ConvergenceException(r16, r17);
    L27:
        if (r11 <= this.qrRankingThreshold) goto L28;
        int[] r18 = this.permutation;
        int r19 = r18[r10];
        r18[r10] = r18[r9];
        r18[r9] = r19;
        double r110 = this.weightedJacobian[r9][r19];
        double r111 = FastMath.sqrt(r11);
        if (r110 <= 0.0d) goto L33;
        r111 = -r111;
    L33:
        double r112 = 1.0d / (r11 - (r110 * r111));
        this.beta[r19] = r112;
        this.diagR[r19] = r111;
        double[] r21 = this.weightedJacobian[r9];
        r21[r19] = r21[r19] - r111;
        int r22 = (r4 - 1) - r9;
    L34:
        if (r22 <= 0) goto L42;
        int r23 = r9;
        double r24 = 0.0d;
    L36:
        if (r23 >= r2) goto L38;
        double[] r113 = this.weightedJacobian[r23];
        r24 = r24 + (r113[r19] * r113[this.permutation[r9 + r22]]);
        r23 = r23 + 1;
        goto L36
    L38:
        double r25 = r24 * r112;
        int r26 = r9;
    L39:
        if (r26 >= r2) goto L41;
        double[] r27 = this.weightedJacobian[r26];
        int r114 = this.permutation[r9 + r22];
        r27[r114] = r27[r114] - (r27[r19] * r25);
        r26 = r26 + 1;
        goto L39
    L41:
        r22 = r22 - 1;
        goto L34
    L42:
        r9 = r9 + 1;
        r3 = 0;
        goto L10
    L28:
        this.rank = r9;
        return;
    L43:
        this.rank = this.solvedCols;
    }

    private void qTy(double[] r12) {
        double[][] r0 = this.weightedJacobian;
        int r1 = r0.length;
        int r2 = 0;
        int r3 = r0[0].length;
    L3:
        if (r2 >= r3) goto L11;
        int r4 = this.permutation[r2];
        double r5 = 0.0d;
        int r6 = r2;
    L5:
        if (r6 >= r1) goto L7;
        r5 = r5 + (this.weightedJacobian[r6][r4] * r12[r6]);
        r6 = r6 + 1;
        goto L5
    L7:
        double r7 = r5 * this.beta[r4];
        int r8 = r2;
    L8:
        if (r8 >= r1) goto L10;
        r12[r8] = r12[r8] - (this.weightedJacobian[r8][r4] * r7);
        r8 = r8 + 1;
        goto L8
    L10:
        r2 = r2 + 1;
        goto L3
    }

    private void checkParameters() {
        if (getLowerBound() != null) goto L8;
        if (getUpperBound() != null) goto L8;
        return;
    L8:
        throw new MathUnsupportedOperationException(LocalizedFormats.CONSTRAINT, new Object[0]);
    }
}
