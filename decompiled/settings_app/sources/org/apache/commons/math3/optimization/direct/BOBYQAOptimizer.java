package org.apache.commons.math3.optimization.direct;

import android.icu.lang.UCharacter;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.MultivariateOptimizer;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class BOBYQAOptimizer extends BaseAbstractMultivariateSimpleBoundsOptimizer<MultivariateFunction> implements MultivariateOptimizer {
    public static final double DEFAULT_INITIAL_RADIUS = 10.0d;
    public static final double DEFAULT_STOPPING_RADIUS = 1.0E-8d;
    private static final double HALF = 0.5d;
    public static final int MINIMUM_PROBLEM_DIMENSION = 2;
    private static final double MINUS_ONE = -1.0d;
    private static final double ONE = 1.0d;
    private static final double ONE_OVER_A_THOUSAND = 0.001d;
    private static final double ONE_OVER_EIGHT = 0.125d;
    private static final double ONE_OVER_FOUR = 0.25d;
    private static final double ONE_OVER_TEN = 0.1d;
    private static final double SIXTEEN = 16.0d;
    private static final double TEN = 10.0d;
    private static final double TWO = 2.0d;
    private static final double TWO_HUNDRED_FIFTY = 250.0d;
    private static final double ZERO = 0.0d;
    private ArrayRealVector alternativeNewPoint;
    private Array2DRowRealMatrix bMatrix;
    private double[] boundDifference;
    private ArrayRealVector currentBest;
    private ArrayRealVector fAtInterpolationPoints;
    private ArrayRealVector gradientAtTrustRegionCenter;
    private double initialTrustRegionRadius;
    private Array2DRowRealMatrix interpolationPoints;
    private boolean isMinimize;
    private ArrayRealVector lagrangeValuesAtNewPoint;
    private ArrayRealVector lowerDifference;
    private ArrayRealVector modelSecondDerivativesParameters;
    private ArrayRealVector modelSecondDerivativesValues;
    private ArrayRealVector newPoint;
    private final int numberOfInterpolationPoints;
    private ArrayRealVector originShift;
    private final double stoppingTrustRegionRadius;
    private ArrayRealVector trialStepPoint;
    private int trustRegionCenterInterpolationPointIndex;
    private ArrayRealVector trustRegionCenterOffset;
    private ArrayRealVector upperDifference;
    private Array2DRowRealMatrix zMatrix;

    private static class PathIsExploredException extends RuntimeException {
        private static final String PATH_IS_EXPLORED = "If this exception is thrown, just remove it from the code";
        private static final long serialVersionUID = 745350979634801853L;

        PathIsExploredException() {
            super("If this exception is thrown, just remove it from the code " + BOBYQAOptimizer.access$000(3));
        }
    }

    private static void printMethod() {
    }

    private static void printState(int r0) {
    }

    static /* synthetic */ String access$000(int r0) {
        return caller(r0);
    }

    public BOBYQAOptimizer(int r7) {
        this(r7, 10.0d, 1.0E-8d);
    }

    public BOBYQAOptimizer(int r2, double r3, double r5) {
        super(null);
        this.numberOfInterpolationPoints = r2;
        this.initialTrustRegionRadius = r3;
        this.stoppingTrustRegionRadius = r5;
    }

    @Override // org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateOptimizer
    protected PointValuePair doOptimize() {
        double[] r0 = getLowerBound();
        double[] r1 = getUpperBound();
        setup(r0, r1);
        if (getGoalType() != GoalType.MINIMIZE) goto L5;
        boolean r2 = true;
    L6:
        this.isMinimize = r2;
        this.currentBest = new ArrayRealVector(getStartPoint());
        double r3 = bobyqa(r0, r1);
        double[] r4 = this.currentBest.getDataRef();
        if (this.isMinimize == true) goto L11;
        r3 = -r3;
    L11:
        return new PointValuePair(r4, r3);
    L5:
        r2 = false;
        goto L6
    }

    private double bobyqa(double[] r12, double[] r13) {
        printMethod();
        int r0 = this.currentBest.getDimension();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L18;
        double r2 = this.boundDifference[r1];
        this.lowerDifference.setEntry(r1, r12[r1] - this.currentBest.getEntry(r1));
        this.upperDifference.setEntry(r1, r13[r1] - this.currentBest.getEntry(r1));
        if (this.lowerDifference.getEntry(r1) < (-this.initialTrustRegionRadius)) goto L11;
        if (this.lowerDifference.getEntry(r1) < 0.0d) goto L9;
        this.currentBest.setEntry(r1, r12[r1]);
        this.lowerDifference.setEntry(r1, 0.0d);
        this.upperDifference.setEntry(r1, r2);
    L16:
        r1 = r1 + 1;
        goto L3
    L9:
        this.currentBest.setEntry(r1, r12[r1] + this.initialTrustRegionRadius);
        this.lowerDifference.setEntry(r1, -this.initialTrustRegionRadius);
        double r3 = r13[r1] - this.currentBest.getEntry(r1);
        this.upperDifference.setEntry(r1, FastMath.max(r3, this.initialTrustRegionRadius));
        goto L16
    L11:
        if (this.upperDifference.getEntry(r1) > this.initialTrustRegionRadius) goto L16;
        if (this.upperDifference.getEntry(r1) > 0.0d) goto L15;
        this.currentBest.setEntry(r1, r13[r1]);
        this.lowerDifference.setEntry(r1, -r2);
        this.upperDifference.setEntry(r1, 0.0d);
        goto L16
    L15:
        this.currentBest.setEntry(r1, r13[r1] - this.initialTrustRegionRadius);
        double r4 = r12[r1] - this.currentBest.getEntry(r1);
        double r5 = -this.initialTrustRegionRadius;
        this.lowerDifference.setEntry(r1, FastMath.min(r4, r5));
        this.upperDifference.setEntry(r1, this.initialTrustRegionRadius);
        goto L16
    L18:
        return bobyqb(r12, r13);
    }

    private double bobyqb(double[] r97, double[] r98) {
        BOBYQAOptimizer r8 = this;
        printMethod();
        int r9 = r8.currentBest.getDimension();
        int r10 = r8.numberOfInterpolationPoints;
        int r0 = r9 + 1;
        int r11 = r10 - r0;
        int r12 = (r0 * r9) / 2;
        ArrayRealVector r13 = new ArrayRealVector(r9);
        ArrayRealVector r14 = new ArrayRealVector(r10);
        ArrayRealVector r15 = new ArrayRealVector(r10);
        r8.trustRegionCenterInterpolationPointIndex = 0;
        prelim(r97, r98);
        int r1 = 0;
        double r2 = 0.0d;
    L3:
        if (r1 >= r9) goto L5;
        r8.trustRegionCenterOffset.setEntry(r1, r8.interpolationPoints.getEntry(r8.trustRegionCenterInterpolationPointIndex, r1));
        double r3 = r8.trustRegionCenterOffset.getEntry(r1);
        r2 = r2 + (r3 * r3);
        r1 = r1 + 1;
        goto L3
    L5:
        double r4 = r8.fAtInterpolationPoints.getEntry(0);
        int r5 = getEvaluations();
        double r6 = r8.initialTrustRegionRadius;
        double r22 = r4;
        double r7 = r6;
        double r24 = Double.NaN;
        double r28 = Double.NaN;
        double r26 = 0.0d;
        int r30 = 0;
        double r31 = 0.0d;
        double r33 = 0.0d;
        int r35 = 0;
        double r36 = 0.0d;
        double r38 = 0.0d;
        double r40 = 0.0d;
        double r42 = 0.0d;
        double r44 = 0.0d;
        double r46 = 0.0d;
        double r48 = 0.0d;
        int r50 = 0;
        int r19 = r5;
        double r20 = r2;
        double r16 = Double.NaN;
        char r17 = 20;
    L6:
        double r62 = r16;
        if (r17 == 20) goto L316;
        if (r17 != '<') goto L10;
        char r54 = 210;
        r8 = r8;
        int r18 = 60;
        r12 = r12;
        char r32 = 20;
    L340:
        printState(r18);
        int r21 = r30;
        ArrayRealVector r72 = r14;
        r7 = r7;
        r14 = r72;
        char r53 = r54;
        int r34 = 0;
        int r37 = 90;
        char r57 = 230;
        double[] r23 = trsbox(r7, new ArrayRealVector(r9), new ArrayRealVector(r9), new ArrayRealVector(r9), new ArrayRealVector(r9), new ArrayRealVector(r9));
        r16 = r23[0];
        double r25 = r23[1];
        r42 = FastMath.min(r7, FastMath.sqrt(r16));
        if (r42 >= (r6 * 0.5d)) goto L373;
        double r39 = r6 * 10.0d;
        r48 = r39 * r39;
        if (getEvaluations() > (r19 + 2)) goto L346;
        r30 = r21;
        r8 = r8;
        r7 = r7;
        r17 = 650;
        r13 = r13;
        r15 = r15;
        r31 = r31;
        r11 = r11;
    L345:
        r35 = -1;
        goto L6
    L346:
        int r27 = r21;
        double r29 = r36;
        double r41 = r38;
        double r43 = FastMath.max(r29, r41);
        r36 = r29;
        double r45 = r40;
        double r47 = FastMath.max(r43, r45);
        double r310 = (ONE_OVER_EIGHT * r6) * r6;
        if (r25 > 0.0d) goto L349;
    L352:
        double r49 = r47 / r6;
        int r51 = 0;
    L353:
        if (r51 >= r9) goto L371;
        if (r8.newPoint.getEntry(r51) != r8.lowerDifference.getEntry(r51)) goto L357;
        ArrayRealVector r52 = r13;
        double r311 = r52.getEntry(r51);
    L358:
        r40 = r45;
        if (r8.newPoint.getEntry(r51) != r8.upperDifference.getEntry(r51)) goto L362;
        r311 = -r52.getEntry(r51);
    L362:
        if (r311 >= r49) goto L369;
        double r55 = r8.modelSecondDerivativesValues.getEntry(((r51 * r51) + r51) / 2);
        int r110 = 0;
    L364:
        if (r110 >= r10) goto L366;
        double r56 = r8.interpolationPoints.getEntry(r110, r51);
        r55 = r55 + (r8.modelSecondDerivativesParameters.getEntry(r110) * (r56 * r56));
        r110 = r110 + 1;
        r27 = r27;
        goto L364
    L366:
        int r410 = r27;
        if ((r311 + ((r55 * 0.5d) * r6)) >= r49) goto L370;
    L372:
        r30 = r410;
        r17 = 680;
        r13 = r52;
    L351:
        r38 = r41;
    L370:
        r51 = r51 + 1;
        r13 = r52;
        r45 = r40;
        r27 = r410;
        goto L353
    L369:
        r410 = r27;
        goto L370
    L357:
        r52 = r13;
        r311 = r49;
        goto L358
    L371:
        r40 = r45;
        r410 = r27;
        r52 = r13;
        goto L372
    L349:
        if (r47 <= (r310 * r25)) goto L352;
        r40 = r45;
        r30 = r27;
        r17 = 650;
        r13 = r13;
        goto L351
    L373:
        r30 = r21;
        ArrayRealVector r58 = r13;
        int r111 = r35 + 1;
        double r81 = r42;
        r16 = r16;
    L374:
        printState(r37);
        if (r16 > (ONE_OVER_A_THOUSAND * r20)) goto L423;
        double r59 = ONE_OVER_FOUR * r20;
        int r60 = r34;
        double r61 = 0.0d;
    L378:
        if (r60 >= r10) goto L389;
        double r63 = r61 + r8.modelSecondDerivativesParameters.getEntry(r60);
        double r510 = r38;
        int r64 = r34;
        double r65 = (-0.5d) * r20;
    L380:
        if (r64 >= r9) goto L382;
        r65 = r65 + (r8.interpolationPoints.getEntry(r60, r64) * r8.trustRegionCenterOffset.getEntry(r64));
        r64 = r64 + 1;
        r63 = r63;
        r7 = r7;
        goto L380
    L382:
        double r511 = r63;
        double r79 = r7;
        r14.setEntry(r60, r65);
        double r66 = r59 - (r65 * 0.5d);
        int r67 = r34;
    L383:
        if (r67 >= r9) goto L388;
        r58.setEntry(r67, r8.bMatrix.getEntry(r60, r67));
        double r68 = r65;
        r8.lagrangeValuesAtNewPoint.setEntry(r67, (r8.interpolationPoints.getEntry(r60, r67) * r65) + (r8.trustRegionCenterOffset.getEntry(r67) * r66));
        int r69 = r10 + r67;
        int r70 = r34;
    L385:
        if (r70 > r67) goto L387;
        Array2DRowRealMatrix r112 = r8.bMatrix;
        r112.setEntry(r69, r70, (r112.getEntry(r69, r70) + (r58.getEntry(r67) * r8.lagrangeValuesAtNewPoint.getEntry(r70))) + (r8.lagrangeValuesAtNewPoint.getEntry(r67) * r58.getEntry(r70)));
        r70 = r70 + 1;
        r66 = r66;
        goto L385
    L387:
        r67 = r67 + 1;
        r65 = r68;
        goto L383
    L388:
        r60 = r60 + 1;
        r38 = r510;
        r61 = r511;
        r7 = r79;
        goto L378
    L389:
        r38 = r38;
        double r710 = r7;
        int r71 = r34;
        int r73 = r11;
    L390:
        if (r71 >= r73) goto L410;
        int r76 = r73;
        int r74 = r34;
        double r75 = 0.0d;
        double r113 = 0.0d;
    L392:
        if (r74 >= r10) goto L394;
        double r77 = r75 + r8.zMatrix.getEntry(r74, r71);
        r8.lagrangeValuesAtNewPoint.setEntry(r74, r8.zMatrix.getEntry(r74, r71) * r14.getEntry(r74));
        r113 = r113 + r8.lagrangeValuesAtNewPoint.getEntry(r74);
        r74 = r74 + 1;
        r111 = r111;
        r75 = r77;
        goto L392
    L394:
        int r114 = r111;
        int r78 = r34;
    L395:
        if (r78 >= r9) goto L403;
        double r512 = r59;
        double r80 = ((r59 * r75) - (r113 * 0.5d)) * r8.trustRegionCenterOffset.getEntry(r78);
        int r115 = r34;
    L397:
        if (r115 >= r10) goto L399;
        r80 = r80 + (r8.lagrangeValuesAtNewPoint.getEntry(r115) * r8.interpolationPoints.getEntry(r115, r78));
        r115 = r115 + 1;
        r75 = r75;
        r14 = r14;
        goto L397
    L399:
        double r210 = r75;
        ArrayRealVector r711 = r14;
        r58.setEntry(r78, r80);
        int r82 = r34;
    L400:
        if (r82 >= r10) goto L402;
        Array2DRowRealMatrix r83 = r8.bMatrix;
        r83.setEntry(r82, r78, r83.getEntry(r82, r78) + (r8.zMatrix.getEntry(r82, r71) * r80));
        r82 = r82 + 1;
        r113 = r113;
        goto L400
    L402:
        r78 = r78 + 1;
        r75 = r210;
        r59 = r512;
        r14 = r711;
        goto L395
    L403:
        double r513 = r59;
        ArrayRealVector r712 = r14;
        int r84 = r34;
    L404:
        if (r84 >= r9) goto L409;
        int r85 = r84 + r10;
        double r86 = r58.getEntry(r84);
        int r87 = r34;
    L406:
        if (r87 > r84) goto L408;
        Array2DRowRealMatrix r116 = r8.bMatrix;
        r116.setEntry(r85, r87, r116.getEntry(r85, r87) + (r58.getEntry(r87) * r86));
        r87 = r87 + 1;
        goto L406
    L408:
        r84 = r84 + 1;
        goto L404
    L409:
        r71 = r71 + 1;
        r111 = r114;
        r59 = r513;
        r14 = r712;
        r73 = r76;
        goto L390
    L410:
        int r713 = r73;
        int r117 = r111;
        ArrayRealVector r714 = r14;
        int r88 = r34;
        int r89 = r88;
    L411:
        if (r88 >= r9) goto L419;
        r58.setEntry(r88, (r61 * (-0.5d)) * r8.trustRegionCenterOffset.getEntry(r88));
        int r90 = r34;
    L413:
        if (r90 >= r10) goto L415;
        r58.setEntry(r88, r58.getEntry(r88) + (r8.modelSecondDerivativesParameters.getEntry(r90) * r8.interpolationPoints.getEntry(r90, r88)));
        Array2DRowRealMatrix r91 = r8.interpolationPoints;
        r91.setEntry(r90, r88, r91.getEntry(r90, r88) - r8.trustRegionCenterOffset.getEntry(r88));
        r90 = r90 + 1;
        goto L413
    L415:
        int r92 = r34;
    L416:
        if (r92 > r88) goto L418;
        ArrayRealVector r93 = r8.modelSecondDerivativesValues;
        r93.setEntry(r89, (r93.getEntry(r89) + (r58.getEntry(r92) * r8.trustRegionCenterOffset.getEntry(r88))) + (r8.trustRegionCenterOffset.getEntry(r92) * r58.getEntry(r88)));
        Array2DRowRealMatrix r94 = r8.bMatrix;
        r94.setEntry(r10 + r92, r88, r94.getEntry(r10 + r88, r92));
        r89 = r89 + 1;
        r92 = r92 + 1;
        goto L416
    L418:
        r88 = r88 + 1;
        goto L411
    L419:
        int r95 = r34;
    L420:
        if (r95 >= r9) goto L422;
        ArrayRealVector r96 = r8.originShift;
        r96.setEntry(r95, r96.getEntry(r95) + r8.trustRegionCenterOffset.getEntry(r95));
        ArrayRealVector r99 = r8.newPoint;
        r99.setEntry(r95, r99.getEntry(r95) - r8.trustRegionCenterOffset.getEntry(r95));
        ArrayRealVector r100 = r8.lowerDifference;
        r100.setEntry(r95, r100.getEntry(r95) - r8.trustRegionCenterOffset.getEntry(r95));
        ArrayRealVector r101 = r8.upperDifference;
        r101.setEntry(r95, r101.getEntry(r95) - r8.trustRegionCenterOffset.getEntry(r95));
        r8.trustRegionCenterOffset.setEntry(r95, 0.0d);
        r95 = r95 + 1;
        goto L420
    L422:
        r20 = 0.0d;
    L424:
        if (r117 != 0) goto L426;
        r17 = r53;
    L427:
        r6 = r6;
        r14 = r714;
        r15 = r15;
        r31 = r31;
        r11 = r713;
        r42 = r81;
        r13 = r58;
        r35 = r117;
        r7 = r710;
        goto L6
    L426:
        r17 = r57;
        goto L427
    L423:
        r38 = r38;
        r117 = r111;
        r714 = r14;
        r710 = r7;
        r713 = r11;
        goto L424
    L10:
        if (r17 != 'Z') goto L12;
        r11 = r11;
        ArrayRealVector r610 = r13;
        r15 = r15;
        r111 = r35;
        r81 = r42;
        r8 = r8;
        r6 = r6;
        r12 = r12;
        r14 = r14;
        r30 = r30;
        r31 = r31;
        r53 = 210;
        r34 = 0;
        r57 = 230;
        r37 = 90;
        r7 = r7;
        r16 = r62;
        r58 = r610;
        goto L374
    L12:
        if (r17 != 210) goto L14;
        printState(210);
        BOBYQAOptimizer r102 = this;
        int r103 = r30;
        double r104 = r31;
        double[] r211 = r102.altmov(r103, r104);
        double r212 = r211[0];
        double r213 = r211[1];
        int r105 = 0;
    L29:
        if (r105 >= r9) goto L31;
        r102.trialStepPoint.setEntry(r105, r102.newPoint.getEntry(r105) - r102.trustRegionCenterOffset.getEntry(r105));
        r105 = r105 + 1;
        r104 = r104;
        goto L29
    L31:
        double r715 = r104;
        int r106 = UCharacter.UnicodeBlock.KHUDAWADI_ID;
        r24 = r213;
        r28 = r212;
    L32:
        printState(r106);
        int r107 = 0;
    L33:
        if (r107 >= r10) goto L38;
        double r716 = r6;
        int r108 = 0;
        double r109 = 0.0d;
        double r118 = 0.0d;
        double r214 = 0.0d;
    L35:
        if (r108 >= r9) goto L37;
        r118 = r118 + (r102.interpolationPoints.getEntry(r107, r108) * r102.trialStepPoint.getEntry(r108));
        r214 = r214 + (r102.interpolationPoints.getEntry(r107, r108) * r102.trustRegionCenterOffset.getEntry(r108));
        r109 = r109 + (r102.bMatrix.getEntry(r107, r108) * r102.trialStepPoint.getEntry(r108));
        r108 = r108 + 1;
        goto L35
    L37:
        r15.setEntry(r107, ((r118 * 0.5d) + r214) * r118);
        r102.lagrangeValuesAtNewPoint.setEntry(r107, r109);
        r14.setEntry(r107, r118);
        r107 = r107 + 1;
        r6 = r716;
        goto L33
    L38:
        double r717 = r6;
        int r119 = 0;
        double r120 = 0.0d;
    L39:
        if (r119 >= r11) goto L47;
        double r121 = 0.0d;
        int r122 = 0;
    L41:
        if (r122 >= r10) goto L43;
        r121 = r121 + (r102.zMatrix.getEntry(r122, r119) * r15.getEntry(r122));
        r122 = r122 + 1;
        goto L41
    L43:
        r120 = r120 - (r121 * r121);
        int r123 = 0;
    L44:
        if (r123 >= r10) goto L46;
        ArrayRealVector r124 = r102.lagrangeValuesAtNewPoint;
        r124.setEntry(r123, r124.getEntry(r123) + (r102.zMatrix.getEntry(r123, r119) * r121));
        r123 = r123 + 1;
        r120 = r120;
        goto L44
    L46:
        r119 = r119 + 1;
        goto L39
    L47:
        int r125 = 0;
        double r126 = 0.0d;
        double r127 = 0.0d;
        double r215 = 0.0d;
    L48:
        if (r125 >= r9) goto L56;
        ArrayRealVector r718 = r14;
        double r719 = r102.trialStepPoint.getEntry(r125);
        double r128 = r126 + (r719 * r719);
        int r129 = 0;
        double r720 = 0.0d;
    L50:
        if (r129 >= r10) goto L52;
        r720 = r720 + (r15.getEntry(r129) * r102.bMatrix.getEntry(r129, r125));
        r129 = r129 + 1;
        r128 = r128;
        goto L50
    L52:
        double r810 = r128;
        double r216 = r215 + (r102.trialStepPoint.getEntry(r125) * r720);
        int r130 = r10 + r125;
        ArrayRealVector r721 = r15;
        double r131 = r720;
        int r132 = 0;
    L53:
        if (r132 >= r9) goto L55;
        r131 = r131 + (r102.bMatrix.getEntry(r130, r132) * r102.trialStepPoint.getEntry(r132));
        r132 = r132 + 1;
        r11 = r11;
        goto L53
    L55:
        r102.lagrangeValuesAtNewPoint.setEntry(r130, r131);
        r215 = r216 + (r131 * r102.trialStepPoint.getEntry(r125));
        r127 = r127 + (r102.trialStepPoint.getEntry(r125) * r102.trustRegionCenterOffset.getEntry(r125));
        r125 = r125 + 1;
        r14 = r718;
        r15 = r721;
        r11 = r11;
        r126 = r810;
        goto L48
    L56:
        int r722 = r11;
        ArrayRealVector r723 = r14;
        ArrayRealVector r724 = r15;
        r26 = (((r127 * r127) + ((((r20 + r127) + r127) + (r126 * 0.5d)) * r126)) + r120) - r215;
        ArrayRealVector r133 = r102.lagrangeValuesAtNewPoint;
        int r134 = r102.trustRegionCenterInterpolationPointIndex;
        r133.setEntry(r134, r133.getEntry(r134) + ONE);
        int r135 = r35;
        if (r135 != 0) goto L67;
        double r136 = r102.lagrangeValuesAtNewPoint.getEntry(r103);
        r44 = (r136 * r136) + (r28 * r26);
        if (r44 >= r24) goto L66;
        if (r24 <= 0.0d) goto L66;
        int r137 = 0;
    L63:
        if (r137 >= r9) goto L65;
        r102.newPoint.setEntry(r137, r102.alternativeNewPoint.getEntry(r137));
        r102.trialStepPoint.setEntry(r137, r102.newPoint.getEntry(r137) - r102.trustRegionCenterOffset.getEntry(r137));
        r137 = r137 + 1;
        goto L63
    L65:
        r30 = r103;
        r35 = r135;
        r12 = r12;
        r13 = r13;
        r6 = r717;
        r14 = r723;
        r15 = r724;
        r31 = r715;
        r11 = r722;
        r17 = 230;
        r24 = 0.0d;
        r8 = r102;
        r16 = r126;
    L66:
        int r312 = r103;
        double r725 = r7;
        double r726 = r126;
    L85:
        int r138 = 360;
    L86:
        printState(r138);
        int r139 = 0;
    L87:
        if (r139 >= r9) goto L95;
        r102.currentBest.setEntry(r139, FastMath.min(FastMath.max(r97[r139], r102.originShift.getEntry(r139) + r102.newPoint.getEntry(r139)), r98[r139]));
        if (r102.newPoint.getEntry(r139) != r102.lowerDifference.getEntry(r139)) goto L92;
        r102.currentBest.setEntry(r139, r97[r139]);
    L92:
        if (r102.newPoint.getEntry(r139) != r102.upperDifference.getEntry(r139)) goto L94;
        r102.currentBest.setEntry(r139, r98[r139]);
    L94:
        r139 = r139 + 1;
        goto L87
    L95:
        double r140 = r102.computeObjectiveValue(r102.currentBest.toArray());
        if (r102.isMinimize == true) goto L98;
        r140 = -r140;
    L98:
        double r141 = r140;
        if (r135 != (-1)) goto L101;
        r22 = r141;
        r35 = r135;
        r12 = r12;
        r30 = r312;
        r13 = r13;
        r6 = r717;
        r14 = r723;
        r15 = r724;
        r31 = r715;
        r11 = r722;
        r7 = r725;
        r17 = 720;
        r8 = r102;
        r33 = r22;
        r16 = r726;
        goto L6
    L101:
        double r142 = r102.fAtInterpolationPoints.getEntry(r102.trustRegionCenterInterpolationPointIndex);
        double r143 = 0.0d;
        int r144 = 0;
        int r145 = 0;
    L102:
        if (r144 >= r9) goto L110;
        r143 = r143 + (r102.trialStepPoint.getEntry(r144) * r102.gradientAtTrustRegionCenter.getEntry(r144));
        int r146 = 0;
    L104:
        if (r146 > r144) goto L109;
        double r147 = r102.trialStepPoint.getEntry(r146) * r102.trialStepPoint.getEntry(r144);
        if (r146 != r144) goto L108;
        r147 = r147 * 0.5d;
    L108:
        r143 = r143 + (r102.modelSecondDerivativesValues.getEntry(r145) * r147);
        r145 = r145 + 1;
        r146 = r146 + 1;
        goto L104
    L109:
        r144 = r144 + 1;
        goto L102
    L110:
        double r148 = r143;
        int r149 = 0;
    L111:
        if (r149 >= r10) goto L113;
        double r150 = r723.getEntry(r149);
        r148 = r148 + ((r102.modelSecondDerivativesParameters.getEntry(r149) * 0.5d) * (r150 * r150));
        r149 = r149 + 1;
        goto L111
    L113:
        ArrayRealVector r151 = r723;
        double r152 = r141 - r142;
        double r313 = r152 - r148;
        double r411 = FastMath.abs(r313);
        double r153 = r42;
        if (r153 <= r717) goto L117;
        r19 = getEvaluations();
    L117:
        if (r135 <= 0) goto L154;
        double r154 = 0.0d;
        if (r148 >= 0.0d) goto L153;
        r46 = r152 / r148;
        double r155 = r725 * 0.5d;
        if (r46 > 0.1d) goto L125;
        double r156 = FastMath.min(r155, r153);
    L129:
        if (r156 > (r717 * 1.5d)) goto L132;
        r156 = r717;
    L132:
        if (r141 >= r142) goto L150;
        double r157 = r156 * r156;
        double r811 = r153;
        r725 = r156;
        double r158 = 0.0d;
        double r812 = r44;
        double r813 = r48;
        int r159 = 0;
        int r160 = 0;
        double r412 = 0.0d;
    L134:
        if (r159 >= r10) goto L146;
        int r514 = r160;
        double r814 = 0.0d;
        int r161 = 0;
        int r910 = r722;
        int r727 = r135;
        int r162 = r910;
    L136:
        if (r161 >= r162) goto L138;
        double r815 = r102.zMatrix.getEntry(r159, r161);
        r814 = r814 + (r815 * r815);
        r161 = r161 + 1;
        r162 = r162;
        goto L136
    L138:
        int r515 = r162;
        double r816 = r102.lagrangeValuesAtNewPoint.getEntry(r159);
        double r817 = (r814 * r26) + (r816 * r816);
        double r818 = 0.0d;
        int r163 = 0;
    L139:
        if (r163 >= r9) goto L141;
        double r819 = r102.interpolationPoints.getEntry(r159, r163) - r102.newPoint.getEntry(r163);
        r818 = r818 + (r819 * r819);
        r163 = r163 + 1;
        goto L139
    L141:
        double r820 = r818 / r157;
        double r911 = r157;
        double r164 = r820 * r820;
        double r821 = r142;
        double r165 = FastMath.max(ONE, r164);
        double r611 = r165 * r817;
        if (r611 <= r412) goto L144;
        r160 = r159;
        r412 = r611;
        r812 = r817;
    L145:
        double r612 = r102.lagrangeValuesAtNewPoint.getEntry(r159);
        r158 = FastMath.max(r158, r165 * (r612 * r612));
        r159 = r159 + 1;
        r135 = r727;
        r813 = r818;
        r142 = r821;
        r157 = r911;
        r722 = r515;
        goto L134
    L144:
        r160 = r514;
        goto L145
    L146:
        int r516 = r160;
        double r822 = r142;
        int r517 = r722;
        int r728 = r135;
        BOBYQAOptimizer r166 = r102;
        if (r412 > (r158 * 0.5d)) goto L149;
        int r167 = r312;
        r48 = r813;
    L155:
        int r168 = r517;
        update(r26, r44, r167);
        double r169 = r166.modelSecondDerivativesParameters.getEntry(r167);
        r166.modelSecondDerivativesParameters.setEntry(r167, r154);
        int r170 = 0;
        int r171 = 0;
    L156:
        if (r170 >= r9) goto L161;
        double r172 = r166.interpolationPoints.getEntry(r167, r170) * r169;
        int r173 = 0;
    L158:
        if (r173 > r170) goto L160;
        ArrayRealVector r174 = r166.modelSecondDerivativesValues;
        r174.setEntry(r171, r174.getEntry(r171) + (r166.interpolationPoints.getEntry(r167, r173) * r172));
        r171 = r171 + 1;
        r173 = r173 + 1;
        r169 = r169;
        goto L158
    L160:
        r170 = r170 + 1;
        goto L156
    L161:
        int r175 = r168;
        int r176 = 0;
    L162:
        if (r176 >= r175) goto L167;
        double r177 = r166.zMatrix.getEntry(r167, r176) * r313;
        int r178 = 0;
    L164:
        if (r178 >= r10) goto L166;
        ArrayRealVector r179 = r166.modelSecondDerivativesParameters;
        r179.setEntry(r178, r179.getEntry(r178) + (r166.zMatrix.getEntry(r178, r176) * r177));
        r178 = r178 + 1;
        r177 = r177;
        goto L164
    L166:
        r176 = r176 + 1;
        goto L162
    L167:
        r166.fAtInterpolationPoints.setEntry(r167, r141);
        int r180 = 0;
    L168:
        if (r180 >= r9) goto L170;
        r166.interpolationPoints.setEntry(r167, r180, r166.newPoint.getEntry(r180));
        r13.setEntry(r180, r166.bMatrix.getEntry(r167, r180));
        r180 = r180 + 1;
        goto L168
    L170:
        ArrayRealVector r181 = r13;
        int r182 = 0;
    L171:
        if (r182 >= r10) goto L182;
        double r183 = 0.0d;
        int r184 = 0;
    L173:
        if (r184 >= r175) goto L175;
        r183 = r183 + (r166.zMatrix.getEntry(r167, r184) * r166.zMatrix.getEntry(r182, r184));
        r184 = r184 + 1;
        r148 = r148;
        goto L173
    L175:
        double r613 = r148;
        double r185 = 0.0d;
        int r186 = 0;
    L176:
        if (r186 >= r9) goto L178;
        r185 = r185 + (r166.interpolationPoints.getEntry(r182, r186) * r166.trustRegionCenterOffset.getEntry(r186));
        r186 = r186 + 1;
        r175 = r175;
        goto L176
    L178:
        int r912 = r175;
        double r187 = r183 * r185;
        int r188 = 0;
    L179:
        if (r188 >= r9) goto L181;
        r181.setEntry(r188, r181.getEntry(r188) + (r166.interpolationPoints.getEntry(r182, r188) * r187));
        r188 = r188 + 1;
        goto L179
    L181:
        r182 = r182 + 1;
        r148 = r613;
        r175 = r912;
        goto L171
    L182:
        int r913 = r175;
        double r614 = r148;
        int r189 = 0;
    L183:
        if (r189 >= r9) goto L186;
        ArrayRealVector r190 = r166.gradientAtTrustRegionCenter;
        r190.setEntry(r189, r190.getEntry(r189) + (r181.getEntry(r189) * r313));
        r189 = r189 + 1;
        goto L183
    L186:
        if (r141 >= r822) goto L205;
        r166.trustRegionCenterInterpolationPointIndex = r167;
        double r191 = 0.0d;
        int r192 = 0;
        int r193 = 0;
    L188:
        if (r192 >= r9) goto L195;
        r166.trustRegionCenterOffset.setEntry(r192, r166.newPoint.getEntry(r192));
        double r194 = r166.trustRegionCenterOffset.getEntry(r192);
        r191 = r191 + (r194 * r194);
        int r195 = 0;
    L190:
        if (r195 > r192) goto L194;
        if (r195 >= r192) goto L193;
        ArrayRealVector r196 = r166.gradientAtTrustRegionCenter;
        r196.setEntry(r192, r196.getEntry(r192) + (r166.modelSecondDerivativesValues.getEntry(r193) * r166.trialStepPoint.getEntry(r195)));
    L193:
        ArrayRealVector r197 = r166.gradientAtTrustRegionCenter;
        r197.setEntry(r195, r197.getEntry(r195) + (r166.modelSecondDerivativesValues.getEntry(r193) * r166.trialStepPoint.getEntry(r192)));
        r193 = r193 + 1;
        r195 = r195 + 1;
        goto L190
    L194:
        r192 = r192 + 1;
        goto L188
    L195:
        int r198 = 0;
    L196:
        if (r198 >= r10) goto L204;
        double r199 = 0.0d;
        int r200 = 0;
    L198:
        if (r200 >= r9) goto L200;
        r199 = r199 + (r166.interpolationPoints.getEntry(r198, r200) * r166.trialStepPoint.getEntry(r200));
        r200 = r200 + 1;
        goto L198
    L200:
        double r201 = r199 * r166.modelSecondDerivativesParameters.getEntry(r198);
        int r202 = 0;
    L201:
        if (r202 >= r9) goto L203;
        ArrayRealVector r1100 = r166.gradientAtTrustRegionCenter;
        r1100.setEntry(r202, r1100.getEntry(r202) + (r166.interpolationPoints.getEntry(r198, r202) * r201));
        r202 = r202 + 1;
        r191 = r191;
        goto L201
    L203:
        r198 = r198 + 1;
        goto L196
    L204:
        r20 = r191;
    L205:
        if (r728 <= 0) goto L253;
        int r203 = 0;
    L207:
        if (r203 >= r10) goto L209;
        r166.lagrangeValuesAtNewPoint.setEntry(r203, r166.fAtInterpolationPoints.getEntry(r203) - r166.fAtInterpolationPoints.getEntry(r166.trustRegionCenterInterpolationPointIndex));
        r724.setEntry(r203, 0.0d);
        r203 = r203 + 1;
        goto L207
    L209:
        ArrayRealVector r1101 = r724;
        int r1102 = r913;
        int r204 = 0;
    L210:
        if (r204 >= r1102) goto L218;
        double r205 = 0.0d;
        int r206 = 0;
    L212:
        if (r206 >= r10) goto L214;
        r205 = r205 + (r166.zMatrix.getEntry(r206, r204) * r166.lagrangeValuesAtNewPoint.getEntry(r206));
        r206 = r206 + 1;
        goto L212
    L214:
        int r207 = 0;
    L215:
        if (r207 >= r10) goto L217;
        r1101.setEntry(r207, r1101.getEntry(r207) + (r166.zMatrix.getEntry(r207, r204) * r205));
        r207 = r207 + 1;
        goto L215
    L217:
        r204 = r204 + 1;
        goto L210
    L218:
        int r208 = 0;
    L219:
        if (r208 >= r10) goto L224;
        double r209 = 0.0d;
        int r217 = 0;
    L221:
        if (r217 >= r9) goto L223;
        r209 = r209 + (r166.interpolationPoints.getEntry(r208, r217) * r166.trustRegionCenterOffset.getEntry(r217));
        r217 = r217 + 1;
        goto L221
    L223:
        r151.setEntry(r208, r1101.getEntry(r208));
        r1101.setEntry(r208, r209 * r1101.getEntry(r208));
        r208 = r208 + 1;
        goto L219
    L224:
        ArrayRealVector r1103 = r151;
        double r218 = 0.0d;
        double r219 = 0.0d;
        int r220 = 0;
    L225:
        if (r220 >= r9) goto L238;
        int r314 = r167;
        int r914 = r1102;
        double r221 = 0.0d;
        int r1104 = 0;
    L227:
        if (r1104 >= r10) goto L229;
        r221 = r221 + ((r166.bMatrix.getEntry(r1104, r220) * r166.lagrangeValuesAtNewPoint.getEntry(r1104)) + (r166.interpolationPoints.getEntry(r1104, r220) * r1101.getEntry(r1104)));
        r1104 = r1104 + 1;
        r181 = r181;
        goto L227
    L229:
        ArrayRealVector r615 = r181;
        if (r166.trustRegionCenterOffset.getEntry(r220) != r166.lowerDifference.getEntry(r220)) goto L233;
        double r1105 = FastMath.min(0.0d, r166.gradientAtTrustRegionCenter.getEntry(r220));
        r218 = r218 + (r1105 * r1105);
        double r1106 = FastMath.min(0.0d, r221);
        r219 = r219 + (r1106 * r1106);
    L237:
        r166.lagrangeValuesAtNewPoint.setEntry(r10 + r220, r221);
        r220 = r220 + 1;
        r167 = r314;
        r141 = r141;
        r181 = r615;
        r1101 = r1101;
        r1102 = r914;
        goto L225
    L233:
        if (r166.trustRegionCenterOffset.getEntry(r220) != r166.upperDifference.getEntry(r220)) goto L235;
        double r222 = FastMath.max(0.0d, r166.gradientAtTrustRegionCenter.getEntry(r220));
        r218 = r218 + (r222 * r222);
        double r223 = FastMath.max(0.0d, r221);
        double r224 = r223 * r223;
    L236:
        r219 = r219 + r224;
        goto L237
    L235:
        double r225 = r166.gradientAtTrustRegionCenter.getEntry(r220);
        r218 = r218 + (r225 * r225);
        r224 = r221 * r221;
        goto L236
    L238:
        int r315 = r167;
        double r316 = r141;
        r724 = r1101;
        ArrayRealVector r616 = r181;
        r913 = r1102;
        int r226 = r50 + 1;
        if (r218 >= (r219 * 10.0d)) goto L241;
        r226 = 0;
    L241:
        int r227 = r12;
        if (r226 < 3) goto L252;
        int r228 = FastMath.max(r10, r227);
        int r229 = 0;
    L244:
        if (r229 >= r228) goto L252;
        if (r229 >= r9) goto L247;
        r166.gradientAtTrustRegionCenter.setEntry(r229, r166.lagrangeValuesAtNewPoint.getEntry(r10 + r229));
    L247:
        if (r229 >= r10) goto L249;
        r166.modelSecondDerivativesParameters.setEntry(r229, r1103.getEntry(r229));
    L249:
        if (r229 >= r227) goto L251;
        r166.modelSecondDerivativesValues.setEntry(r229, 0.0d);
    L251:
        r229 = r229 + 1;
        r226 = 0;
    L252:
        r50 = r226;
    L254:
        if (r728 == 0) goto L255;
        if (r316 <= (r822 + (r614 * 0.1d))) goto L255;
        double r413 = TWO * r725;
        double r230 = r717 * 10.0d;
        r48 = FastMath.max(r413 * r413, r230 * r230);
        r33 = r316;
        r16 = r726;
        r7 = r725;
        int r231 = 650;
        double r915 = r36;
        r36 = r411;
        r40 = r38;
        r38 = r915;
    L260:
        printState(r231);
        int r232 = 0;
        int r233 = -1;
    L261:
        if (r232 >= r10) goto L269;
        double r234 = 0.0d;
        int r1107 = 0;
    L263:
        if (r1107 >= r9) goto L266;
        double r414 = r166.interpolationPoints.getEntry(r232, r1107) - r166.trustRegionCenterOffset.getEntry(r1107);
        r234 = r234 + (r414 * r414);
        r1107 = r1107 + 1;
        goto L263
    L266:
        if (r234 <= r48) goto L268;
        r233 = r232;
        r48 = r234;
    L268:
        r232 = r232 + 1;
        goto L261
    L269:
        if (r233 < 0) goto L277;
        double r235 = FastMath.sqrt(r48);
        if (r728 != (-1)) goto L276;
        double r236 = FastMath.min(r7 * 0.1d, r235 * 0.5d);
        if (r236 > (r717 * 1.5d)) goto L275;
        r7 = r717;
        goto L276
    L275:
        r7 = r236;
    L276:
        double r237 = r717;
        r31 = FastMath.max(FastMath.min(r235 * 0.1d, r7), r237);
        r16 = r31 * r31;
        r30 = r233;
        r6 = r237;
        r12 = r227;
        r8 = r166;
        r14 = r1103;
        r13 = r616;
        r15 = r724;
        r42 = r811;
        r11 = r913;
        r17 = 'Z';
        r35 = 0;
        goto L6
    L277:
        double r238 = r717;
        int r1108 = r728;
        if (r1108 != (-1)) goto L281;
        r30 = r233;
        r6 = r238;
        r12 = r227;
        r35 = r1108;
        r8 = r166;
        r14 = r1103;
        r13 = r616;
        r15 = r724;
        r31 = r715;
        r42 = r811;
        r11 = r913;
        r17 = 680;
        goto L6
    L281:
        if (r46 <= 0.0d) goto L283;
        r30 = r233;
        r6 = r238;
        r12 = r227;
        r35 = r1108;
        r8 = r166;
        r14 = r1103;
        r13 = r616;
        r15 = r724;
        r31 = r715;
        r42 = r811;
        r11 = r913;
        r17 = '<';
        goto L6
    L283:
        double r415 = r16;
        double r239 = r811;
        if (FastMath.max(r7, r239) <= r238) goto L286;
        r30 = r233;
        r6 = r238;
        r12 = r227;
        r35 = r1108;
        r8 = r166;
        r14 = r1103;
        r13 = r616;
        r15 = r724;
        r31 = r715;
        r11 = r913;
        r17 = '<';
        r16 = r415;
        r42 = r239;
        goto L6
    L286:
        r62 = r415;
        int r1109 = 680;
    L287:
        printState(r1109);
        double r823 = r239;
        double r240 = r166.stoppingTrustRegionRadius;
        if (r238 > r240) goto L289;
        if (r1108 != (-1)) goto L300;
        r30 = r233;
        r6 = r238;
        r12 = r227;
        r35 = r1108;
        r8 = r166;
        r14 = r1103;
        r16 = r62;
        r13 = r616;
        r15 = r724;
        r31 = r715;
        r42 = r823;
        r11 = r913;
        r17 = 360;
        goto L6
    L300:
        int r241 = 720;
    L301:
        printState(r241);
        if (r166.fAtInterpolationPoints.getEntry(r166.trustRegionCenterInterpolationPointIndex) > r22) goto L565;
        int r242 = 0;
    L304:
        if (r242 >= r9) goto L313;
        r166.currentBest.setEntry(r242, FastMath.min(FastMath.max(r97[r242], r166.originShift.getEntry(r242) + r166.trustRegionCenterOffset.getEntry(r242)), r98[r242]));
        if (r166.trustRegionCenterOffset.getEntry(r242) != r166.lowerDifference.getEntry(r242)) goto L309;
        r166.currentBest.setEntry(r242, r97[r242]);
    L309:
        if (r166.trustRegionCenterOffset.getEntry(r242) != r166.upperDifference.getEntry(r242)) goto L311;
        r166.currentBest.setEntry(r242, r98[r242]);
    L311:
        r242 = r242 + 1;
        goto L304
    L313:
        return r166.fAtInterpolationPoints.getEntry(r166.trustRegionCenterInterpolationPointIndex);
    L565:
        return r33;
    L289:
        double r243 = r238 * 0.5d;
        r46 = r238 / r240;
        if (r46 > SIXTEEN) goto L293;
    L296:
        r7 = FastMath.max(r243, r240);
        r19 = getEvaluations();
        r30 = r233;
        r12 = r227;
        r8 = r166;
        r14 = r1103;
        r13 = r616;
        r15 = r724;
        r31 = r715;
        r42 = r823;
        r11 = r913;
        r17 = '<';
        r35 = 0;
        r6 = r240;
        r16 = r62;
        goto L6
    L293:
        if (r46 > TWO_HUNDRED_FIFTY) goto L295;
        r240 = FastMath.sqrt(r46) * r166.stoppingTrustRegionRadius;
        goto L296
    L295:
        r240 = r238 * 0.1d;
    L255:
        r12 = r227;
        r8 = r166;
        r14 = r1103;
        r30 = r315;
        r33 = r316;
        r13 = r616;
        r6 = r717;
        r15 = r724;
        r31 = r715;
        r35 = r728;
        r16 = r726;
        r7 = r725;
        r42 = r811;
        r11 = r913;
        r17 = '<';
        double r916 = r36;
        r36 = r411;
        r40 = r38;
        r38 = r916;
        goto L6
    L253:
        r315 = r167;
        r316 = r141;
        r616 = r181;
        r227 = r12;
        r1103 = r151;
        goto L254
    L149:
        r167 = r516;
        r48 = r813;
        r44 = r812;
        goto L155
    L150:
        r811 = r153;
        r725 = r156;
        r822 = r142;
        r517 = r722;
        r728 = r135;
        r166 = r102;
        r167 = r312;
        goto L155
    L125:
        if (r46 > 0.7d) goto L127;
        r156 = FastMath.max(r155, r153);
        goto L129
    L127:
        r156 = FastMath.max(r155, r153 * TWO);
        goto L129
    L153:
        throw new MathIllegalStateException(LocalizedFormats.TRUST_REGION_STEP_FAILED, new Object[]{Double.valueOf(r148)});
    L154:
        r811 = r153;
        r822 = r142;
        r517 = r722;
        r154 = 0.0d;
        r728 = r135;
        r166 = r102;
        r167 = r312;
        goto L155
    L67:
        double r244 = r7 * r7;
        double r245 = 0.0d;
        double r1110 = 0.0d;
        int r1111 = 0;
        int r1112 = 0;
    L68:
        if (r1111 >= r10) goto L84;
        double r729 = r126;
        if (r1111 == r102.trustRegionCenterInterpolationPointIndex) goto L83;
        int r317 = r1112;
        int r246 = r722;
        double r247 = 0.0d;
        int r1113 = 0;
    L73:
        if (r1113 >= r246) goto L75;
        double r318 = r102.zMatrix.getEntry(r1111, r1113);
        r247 = r247 + (r318 * r318);
        r1113 = r1113 + 1;
        goto L73
    L75:
        double r319 = r102.lagrangeValuesAtNewPoint.getEntry(r1111);
        double r248 = (r247 * r26) + (r319 * r319);
        int r249 = 0;
        double r320 = 0.0d;
    L76:
        if (r249 >= r9) goto L78;
        double r416 = r102.interpolationPoints.getEntry(r1111, r249) - r102.trustRegionCenterOffset.getEntry(r249);
        r320 = r320 + (r416 * r416);
        r249 = r249 + 1;
        goto L76
    L78:
        double r417 = r320 / r244;
        r722 = r246;
        double r250 = FastMath.max(ONE, r417 * r417);
        double r251 = r250 * r248;
        if (r251 <= r245) goto L81;
        r245 = r251;
        r44 = r248;
        r1112 = r1111;
    L82:
        double r252 = r102.lagrangeValuesAtNewPoint.getEntry(r1111);
        r1110 = FastMath.max(r1110, r250 * (r252 * r252));
        r48 = r320;
        goto L83
    L81:
        r1112 = r317;
    L83:
        r1111 = r1111 + 1;
        r126 = r729;
        r7 = r7;
        r244 = r244;
        goto L68
    L84:
        r725 = r7;
        r726 = r126;
        r312 = r1112;
        goto L85
    L14:
        if (r17 != 230) goto L15;
        r106 = 230;
        r103 = r30;
        r715 = r31;
        r102 = this;
        goto L32
    L15:
        if (r17 != 360) goto L17;
        r102 = this;
        r725 = r7;
        r717 = r6;
        r138 = 360;
        r722 = r11;
        r13 = r13;
        r723 = r14;
        r724 = r15;
        r312 = r30;
        r715 = r31;
        r135 = r35;
        r726 = r62;
        r12 = r12;
        goto L86
    L17:
        if (r17 != 650) goto L19;
        r231 = 650;
        r717 = r6;
        r913 = r11;
        r227 = r12;
        r616 = r13;
        r724 = r15;
        r715 = r31;
        r728 = r35;
        r811 = r42;
        r16 = r62;
        r166 = this;
        r1103 = r14;
        goto L260
    L19:
        if (r17 != 680) goto L20;
        r238 = r6;
        r913 = r11;
        r227 = r12;
        r616 = r13;
        r724 = r15;
        r233 = r30;
        r715 = r31;
        r1108 = r35;
        r166 = this;
        r1109 = 680;
        r1103 = r14;
        r239 = r42;
        goto L287
    L20:
        if (r17 != 720) goto L23;
        r166 = this;
        r241 = 720;
        goto L301
    L23:
        throw new MathIllegalStateException(LocalizedFormats.SIMPLE_MESSAGE, new Object[]{"bobyqb"});
    L316:
        r54 = 210;
        r32 = 20;
        r8 = r8;
        int r253 = r12;
        printState(20);
        if (r8.trustRegionCenterInterpolationPointIndex == 0) goto L338;
        int r254 = 0;
        int r255 = 0;
    L319:
        if (r254 >= r9) goto L327;
        int r256 = 0;
    L321:
        if (r256 > r254) goto L326;
        if (r256 >= r254) goto L325;
        ArrayRealVector r257 = r8.gradientAtTrustRegionCenter;
        r257.setEntry(r254, r257.getEntry(r254) + (r8.modelSecondDerivativesValues.getEntry(r255) * r8.trustRegionCenterOffset.getEntry(r256)));
    L325:
        ArrayRealVector r258 = r8.gradientAtTrustRegionCenter;
        r258.setEntry(r256, r258.getEntry(r256) + (r8.modelSecondDerivativesValues.getEntry(r255) * r8.trustRegionCenterOffset.getEntry(r254)));
        r255 = r255 + 1;
        r256 = r256 + 1;
        r253 = r253;
        goto L321
    L326:
        r254 = r254 + 1;
        goto L319
    L327:
        r12 = r253;
        if (getEvaluations() <= r10) goto L339;
        int r259 = 0;
    L330:
        if (r259 >= r10) goto L339;
        int r260 = 0;
        double r261 = 0.0d;
    L332:
        if (r260 >= r9) goto L334;
        r261 = r261 + (r8.interpolationPoints.getEntry(r259, r260) * r8.trustRegionCenterOffset.getEntry(r260));
        r260 = r260 + 1;
        goto L332
    L334:
        double r262 = r261 * r8.modelSecondDerivativesParameters.getEntry(r259);
        int r263 = 0;
    L335:
        if (r263 >= r9) goto L337;
        ArrayRealVector r264 = r8.gradientAtTrustRegionCenter;
        r264.setEntry(r263, r264.getEntry(r263) + (r8.interpolationPoints.getEntry(r259, r263) * r262));
        r263 = r263 + 1;
        goto L335
    L337:
        r259 = r259 + 1;
    L339:
        r18 = 60;
        goto L340
    L338:
        r12 = r253;
        goto L339
    }

    private double[] altmov(int r51, double r52) {
        printMethod();
        int r2 = this.currentBest.getDimension();
        int r3 = this.numberOfInterpolationPoints;
        ArrayRealVector r4 = new ArrayRealVector(r2);
        ArrayRealVector r5 = new ArrayRealVector(r3);
        ArrayRealVector r6 = new ArrayRealVector(r2);
        ArrayRealVector r7 = new ArrayRealVector(r2);
        int r9 = 0;
    L4:
        if (r9 >= r3) goto L6;
        r5.setEntry(r9, 0.0d);
        r9 = r9 + 1;
        goto L4
    L6:
        int r10 = (r3 - r2) - 1;
        int r13 = 0;
    L7:
        if (r13 >= r10) goto L12;
        double r14 = this.zMatrix.getEntry(r51, r13);
        int r8 = 0;
    L9:
        if (r8 >= r3) goto L11;
        r5.setEntry(r8, r5.getEntry(r8) + (this.zMatrix.getEntry(r8, r13) * r14));
        r8 = r8 + 1;
        goto L9
    L11:
        r13 = r13 + 1;
        goto L7
    L12:
        double r11 = r5.getEntry(r51);
        double r12 = r11 * 0.5d;
        int r15 = 0;
    L13:
        if (r15 >= r2) goto L15;
        r4.setEntry(r15, this.bMatrix.getEntry(r51, r15));
        r15 = r15 + 1;
        goto L13
    L15:
        int r16 = 0;
    L16:
        if (r16 >= r3) goto L24;
        int r17 = 0;
        double r18 = 0.0d;
    L18:
        if (r17 >= r2) goto L20;
        r18 = r18 + (this.interpolationPoints.getEntry(r16, r17) * this.trustRegionCenterOffset.getEntry(r17));
        r17 = r17 + 1;
        r7 = r7;
        goto L18
    L20:
        ArrayRealVector r19 = r7;
        double r110 = r18 * r5.getEntry(r16);
        int r20 = 0;
    L21:
        if (r20 >= r2) goto L23;
        r4.setEntry(r20, r4.getEntry(r20) + (this.interpolationPoints.getEntry(r16, r20) * r110));
        r20 = r20 + 1;
        r110 = r110;
        goto L21
    L23:
        r16 = r16 + 1;
        r7 = r19;
        goto L16
    L24:
        ArrayRealVector r111 = r7;
        double r27 = Double.NaN;
        int r21 = 0;
        int r112 = 0;
        int r113 = 0;
        double r23 = 0.0d;
        double r25 = 0.0d;
    L25:
        if (r21 >= r3) goto L77;
        if (r21 != this.trustRegionCenterInterpolationPointIndex) goto L29;
        int r35 = r3;
        ArrayRealVector r39 = r4;
        ArrayRealVector r22 = r5;
        ArrayRealVector r37 = r6;
        double r33 = r11;
    L76:
        r21 = r21 + 1;
        r5 = r22;
        r11 = r33;
        r3 = r35;
        r6 = r37;
        r4 = r39;
        goto L25
    L29:
        int r114 = 0;
        double r28 = 0.0d;
        double r31 = 0.0d;
    L30:
        if (r114 >= r2) goto L32;
        double r34 = this.interpolationPoints.getEntry(r21, r114) - this.trustRegionCenterOffset.getEntry(r114);
        r31 = r31 + (r4.getEntry(r114) * r34);
        r28 = r28 + (r34 * r34);
        r114 = r114 + 1;
        goto L30
    L32:
        double r115 = r52 / FastMath.sqrt(r28);
        r33 = r11;
        r22 = r5;
        r37 = r6;
        double r24 = FastMath.min(ONE, r115);
        double r26 = -r115;
        int r36 = 0;
        int r38 = 0;
        r35 = r3;
        int r29 = 0;
    L33:
        if (r29 >= r2) goto L52;
        ArrayRealVector r310 = r4;
        double r40 = this.interpolationPoints.getEntry(r21, r29) - this.trustRegionCenterOffset.getEntry(r29);
        if (r40 <= 0.0d) goto L44;
        if ((r26 * r40) >= (this.lowerDifference.getEntry(r29) - this.trustRegionCenterOffset.getEntry(r29))) goto L40;
        r26 = (this.lowerDifference.getEntry(r29) - this.trustRegionCenterOffset.getEntry(r29)) / r40;
        r36 = (-r29) - 1;
    L40:
        if ((r115 * r40) <= (this.upperDifference.getEntry(r29) - this.trustRegionCenterOffset.getEntry(r29))) goto L51;
        r115 = FastMath.max(r24, (this.upperDifference.getEntry(r29) - this.trustRegionCenterOffset.getEntry(r29)) / r40);
        int r30 = r29 + 1;
    L42:
        r38 = r30;
    L51:
        r29 = r29 + 1;
        r4 = r310;
        goto L33
    L44:
        if (r40 >= 0.0d) goto L51;
        if ((r26 * r40) <= (this.upperDifference.getEntry(r29) - this.trustRegionCenterOffset.getEntry(r29))) goto L49;
        r26 = (this.upperDifference.getEntry(r29) - this.trustRegionCenterOffset.getEntry(r29)) / r40;
        r36 = r29 + 1;
    L49:
        if ((r115 * r40) >= (this.lowerDifference.getEntry(r29) - this.trustRegionCenterOffset.getEntry(r29))) goto L51;
        r115 = FastMath.max(r24, (this.lowerDifference.getEntry(r29) - this.trustRegionCenterOffset.getEntry(r29)) / r40);
        r30 = (-r29) - 1;
        goto L42
    L52:
        r39 = r4;
        if (r21 != r51) goto L62;
        double r32 = r31 - ONE;
        double r41 = r26 * r32;
        double r42 = (r31 - r41) * r26;
        double r43 = r115 * r32;
        double r44 = (r31 - r43) * r115;
        if (FastMath.abs(r44) <= FastMath.abs(r42)) goto L57;
        r26 = r115;
        r36 = r38;
        r42 = r44;
    L57:
        double r311 = r31 * 0.5d;
        if (((r311 - r41) * (r311 - r43)) >= 0.0d) goto L72;
        double r45 = (r311 * r311) / r32;
        if (FastMath.abs(r45) <= FastMath.abs(r42)) goto L72;
        r26 = r311 / r32;
        r42 = r45;
        r36 = 0;
    L72:
        double r116 = ((ONE - r26) * r26) * r28;
        double r46 = r42 * r42;
        double r47 = r46 * (r46 + ((r12 * r116) * r116));
        if (r47 <= r25) goto L75;
        r112 = r21;
        r23 = r26;
        r27 = r23;
        r113 = r36;
        r25 = r47;
        goto L76
    L75:
        r27 = r26;
        goto L76
    L62:
        double r48 = (ONE - r26) * r26;
        double r49 = (ONE - r115) * r115;
        if (FastMath.abs(r49) <= FastMath.abs(r48)) goto L66;
        r26 = r115;
        r36 = r38;
        r48 = r49;
    L66:
        if (r115 > 0.5d) goto L68;
    L70:
        double r117 = r26;
    L71:
        r42 = r48 * r31;
        r26 = r117;
        goto L72
    L68:
        if (FastMath.abs(r48) >= ONE_OVER_FOUR) goto L70;
        r48 = 0.25d;
        r117 = 0.5d;
        r36 = 0;
        goto L71
    L77:
        int r312 = r3;
        ArrayRealVector r313 = r4;
        ArrayRealVector r210 = r5;
        ArrayRealVector r314 = r6;
        double r315 = r11;
        int r1 = 0;
    L78:
        if (r1 >= r2) goto L80;
        this.newPoint.setEntry(r1, FastMath.max(this.lowerDifference.getEntry(r1), FastMath.min(this.upperDifference.getEntry(r1), this.trustRegionCenterOffset.getEntry(r1) + ((this.interpolationPoints.getEntry(r112, r1) - this.trustRegionCenterOffset.getEntry(r1)) * r23))));
        r1 = r1 + 1;
        goto L78
    L80:
        if (r113 >= 0) goto L82;
        int r50 = 1;
        int r53 = (-r113) - 1;
        this.newPoint.setEntry(r53, this.lowerDifference.getEntry(r53));
    L83:
        if (r113 <= 0) goto L85;
        int r118 = r113 - r50;
        this.newPoint.setEntry(r118, this.upperDifference.getEntry(r118));
    L85:
        double r54 = r52 + r52;
        double r119 = r27;
        boolean r55 = false;
        double r56 = 0.0d;
    L86:
        int r57 = 0;
        double r58 = 0.0d;
    L87:
        if (r57 >= r2) goto L94;
        ArrayRealVector r120 = r313;
        double r121 = r120.getEntry(r57);
        double r211 = r119;
        ArrayRealVector r122 = r314;
        r122.setEntry(r57, 0.0d);
        double r212 = r56;
        if (FastMath.min(this.trustRegionCenterOffset.getEntry(r57) - this.lowerDifference.getEntry(r57), r121) <= 0.0d) goto L91;
    L92:
        r122.setEntry(r57, r54);
        r58 = r58 + (r121 * r121);
    L93:
        r57 = r57 + 1;
        r313 = r120;
        r314 = r122;
        r119 = r211;
        r56 = r212;
        goto L87
    L91:
        if (FastMath.max(this.trustRegionCenterOffset.getEntry(r57) - this.upperDifference.getEntry(r57), r121) >= 0.0d) goto L93;
    L94:
        double r213 = r56;
        double r214 = r119;
        r314 = r314;
        ArrayRealVector r123 = r313;
        if (r58 == 0.0d) goto L97;
        double r124 = (r52 * r52) - 0.0d;
        if (r124 <= 0.0d) goto L112;
        double r59 = FastMath.sqrt(r124 / r58);
        int r60 = 0;
    L101:
        if (r60 >= r2) goto L113;
        if (r314.getEntry(r60) != r54) goto L111;
        double r61 = this.trustRegionCenterOffset.getEntry(r60) - (r123.getEntry(r60) * r59);
        if (r61 > this.lowerDifference.getEntry(r60)) goto L108;
        r314.setEntry(r60, this.lowerDifference.getEntry(r60) - this.trustRegionCenterOffset.getEntry(r60));
        r314.getEntry(r60);
        goto L111
    L108:
        if (r61 < this.upperDifference.getEntry(r60)) goto L110;
        r314.setEntry(r60, this.upperDifference.getEntry(r60) - this.trustRegionCenterOffset.getEntry(r60));
        r314.getEntry(r60);
        goto L111
    L110:
        r123.getEntry(r60);
    L111:
        r60 = r60 + 1;
    L113:
        int r62 = 0;
        double r63 = 0.0d;
    L114:
        if (r62 >= r2) goto L126;
        double r125 = r123.getEntry(r62);
        if (r314.getEntry(r62) != r54) goto L118;
        r314.setEntry(r62, (-r59) * r125);
        double r215 = r54;
        double r216 = r59;
        this.alternativeNewPoint.setEntry(r62, FastMath.max(this.lowerDifference.getEntry(r62), FastMath.min(this.upperDifference.getEntry(r62), this.trustRegionCenterOffset.getEntry(r62) + r314.getEntry(r62))));
    L125:
        r63 = r63 + (r125 * r314.getEntry(r62));
        r62 = r62 + 1;
        r54 = r215;
        r59 = r216;
        goto L114
    L118:
        r215 = r54;
        r216 = r59;
        if (r314.getEntry(r62) != 0.0d) goto L122;
        this.alternativeNewPoint.setEntry(r62, this.trustRegionCenterOffset.getEntry(r62));
        goto L125
    L122:
        if (r125 <= 0.0d) goto L124;
        this.alternativeNewPoint.setEntry(r62, this.lowerDifference.getEntry(r62));
        goto L125
    L124:
        this.alternativeNewPoint.setEntry(r62, this.upperDifference.getEntry(r62));
        goto L125
    L126:
        double r217 = r54;
        double r218 = r59;
        double r64 = 0.0d;
        r312 = r312;
        int r65 = 0;
    L127:
        if (r65 >= r312) goto L132;
        double r126 = 0.0d;
        int r66 = 0;
    L129:
        if (r66 >= r2) goto L131;
        r126 = r126 + (this.interpolationPoints.getEntry(r65, r66) * r314.getEntry(r66));
        r66 = r66 + 1;
        goto L129
    L131:
        r64 = r64 + ((r210.getEntry(r65) * r126) * r126);
        r65 = r65 + 1;
        goto L127
    L132:
        r210 = r210;
        if (r55 != true) goto L135;
        r64 = -r64;
    L135:
        double r127 = -r63;
        if (r64 > r127) goto L138;
        double r67 = 0.5d;
    L145:
        double r68 = r63 + (r64 * r67);
    L146:
        double r69 = r68 * r68;
        if (r55 == true) goto L153;
        int r70 = 0;
    L149:
        if (r70 >= r2) goto L151;
        r123.setEntry(r70, -r123.getEntry(r70));
        r111.setEntry(r70, this.alternativeNewPoint.getEntry(r70));
        r70 = r70 + 1;
        goto L149
    L151:
        r56 = r69;
        r313 = r123;
        r54 = r217;
        r119 = r218;
        r55 = true;
        goto L86
    L153:
        if (r213 <= r69) goto L158;
        int r71 = 0;
    L155:
        if (r71 >= r2) goto L157;
        this.alternativeNewPoint.setEntry(r71, r111.getEntry(r71));
        r71 = r71 + 1;
        goto L155
    L157:
        double r72 = r213;
    L160:
        return new double[]{r315, r72};
    L158:
        r72 = r69;
        goto L160
    L138:
        if (r64 >= ((FastMath.sqrt(TWO) + ONE) * r127)) goto L143;
        double r128 = r127 / r64;
        int r73 = 0;
    L140:
        if (r73 >= r2) goto L142;
        this.alternativeNewPoint.setEntry(r73, FastMath.max(this.lowerDifference.getEntry(r73), FastMath.min(this.upperDifference.getEntry(r73), this.trustRegionCenterOffset.getEntry(r73) + (r314.getEntry(r73) * r128))));
        r73 = r73 + 1;
        r210 = r210;
        r312 = r312;
        r314 = r314;
        goto L140
    L142:
        r312 = r312;
        r210 = r210;
        r314 = r314;
        r68 = (r63 * 0.5d) * r128;
        goto L146
    L143:
        r67 = 0.5d;
        goto L145
    L112:
        r59 = r214;
        goto L113
    L97:
        return new double[]{r315, 0.0d};
    L82:
        r50 = 1;
        goto L83
    }

    private void prelim(double[] r44, double[] r45) {
        printMethod();
        int r1 = this.currentBest.getDimension();
        int r2 = this.numberOfInterpolationPoints;
        int r3 = this.bMatrix.getRowDimension();
        double r4 = this.initialTrustRegionRadius;
        double r5 = r4 * r4;
        double r8 = ONE / r5;
        int r10 = r1 + 1;
        int r12 = 0;
    L4:
        if (r12 >= r1) goto L12;
        this.originShift.setEntry(r12, this.currentBest.getEntry(r12));
        int r6 = 0;
    L6:
        if (r6 >= r2) goto L8;
        this.interpolationPoints.setEntry(r6, r12, 0.0d);
        r6 = r6 + 1;
        goto L6
    L8:
        int r7 = 0;
    L9:
        if (r7 >= r3) goto L11;
        this.bMatrix.setEntry(r7, r12, 0.0d);
        r7 = r7 + 1;
        goto L9
    L11:
        r12 = r12 + 1;
        goto L4
    L12:
        int r9 = (r1 * r10) / 2;
        int r11 = 0;
    L13:
        if (r11 >= r9) goto L15;
        this.modelSecondDerivativesValues.setEntry(r11, 0.0d);
        r11 = r11 + 1;
        goto L13
    L15:
        int r13 = 0;
    L16:
        if (r13 >= r2) goto L21;
        this.modelSecondDerivativesParameters.setEntry(r13, 0.0d);
        int r14 = r2 - r10;
        int r15 = 0;
    L18:
        if (r15 >= r14) goto L20;
        this.zMatrix.setEntry(r13, r15, 0.0d);
        r15 = r15 + 1;
        goto L18
    L20:
        r13 = r13 + 1;
        goto L16
    L21:
        double r18 = Double.NaN;
        int r16 = 0;
        int r17 = 0;
    L22:
        int r19 = getEvaluations();
        int r110 = r19 - r1;
        int r20 = r19 - 1;
        int r111 = r110 - 1;
        int r112 = r1 * 2;
        if (r19 > r112) goto L42;
        if (r19 < 1) goto L30;
        if (r19 > r1) goto L30;
        int r26 = r110;
        double r113 = this.initialTrustRegionRadius;
        int r28 = r16;
        if (this.upperDifference.getEntry(r20) != 0.0d) goto L29;
        r113 = -r113;
    L29:
        this.interpolationPoints.setEntry(r19, r20, r113);
        int r21 = r28;
    L41:
        double r22 = 0.0d;
    L46:
        int r23 = 0;
    L47:
        if (r23 >= r1) goto L55;
        int r30 = r21;
        double r33 = r22;
        int r24 = r1;
        int r39 = r2;
        this.currentBest.setEntry(r23, FastMath.min(FastMath.max(r44[r23], this.originShift.getEntry(r23) + this.interpolationPoints.getEntry(r19, r23)), r45[r23]));
        if (this.interpolationPoints.getEntry(r19, r23) != this.lowerDifference.getEntry(r23)) goto L52;
        this.currentBest.setEntry(r23, r44[r23]);
    L52:
        if (this.interpolationPoints.getEntry(r19, r23) != this.upperDifference.getEntry(r23)) goto L54;
        this.currentBest.setEntry(r23, r45[r23]);
    L54:
        r23 = r23 + 1;
        r1 = r24;
        r21 = r30;
        r22 = r33;
        r2 = r39;
        goto L47
    L55:
        int r310 = r2;
        int r31 = r21;
        double r34 = r22;
        int r25 = r1;
        double r27 = computeObjectiveValue(this.currentBest.toArray());
        if (this.isMinimize == true) goto L59;
        r27 = -r27;
    L59:
        int r29 = getEvaluations();
        this.fAtInterpolationPoints.setEntry(r19, r27);
        if (r29 != 1) goto L63;
        this.trustRegionCenterInterpolationPointIndex = 0;
        r18 = r27;
    L66:
        if (r29 <= (r112 + 1)) goto L68;
        r25 = r25;
        long r210 = 0;
        double r32 = r8;
        this.zMatrix.setEntry(0, r111, r32);
        this.zMatrix.setEntry(r19, r111, r32);
        double r35 = -r32;
        int r114 = r31;
        this.zMatrix.setEntry(r114, r111, r35);
        this.zMatrix.setEntry(r17, r111, r35);
        int r36 = r114 - 1;
        char r37 = 2;
        this.modelSecondDerivativesValues.setEntry((((r114 * r36) / 2) + r17) - 1, (((r18 - this.fAtInterpolationPoints.getEntry(r114)) - this.fAtInterpolationPoints.getEntry(r17)) + r27) / (this.interpolationPoints.getEntry(r19, r36) * this.interpolationPoints.getEntry(r19, r17 - 1)));
    L91:
        r2 = r310;
        if (getEvaluations() >= r2) goto L93;
        r1 = r25;
        r16 = r114;
        r8 = r32;
        r5 = r5;
        goto L22
    L93:
        return;
    L68:
        if (r29 < 2) goto L74;
        if (r29 > r10) goto L74;
        this.gradientAtTrustRegionCenter.setEntry(r20, (r27 - r18) / r113);
        if (r310 >= (r29 + r25)) goto L73;
        double r38 = ONE / r113;
        this.bMatrix.setEntry(0, r20, -r38);
        this.bMatrix.setEntry(r19, r20, r38);
        this.bMatrix.setEntry(r310 + r20, r20, (-0.5d) * r5);
    L73:
        r310 = r310;
        r25 = r25;
        r114 = r31;
        r32 = r8;
        r37 = 2;
        r210 = 0;
    L74:
        r310 = r310;
        if (r29 < (r25 + 2)) goto L88;
        double r311 = (r27 - r18) / r34;
        double r312 = r34 - r113;
        this.modelSecondDerivativesValues.setEntry((((r26 + 1) * r26) / 2) - 1, ((r311 - this.gradientAtTrustRegionCenter.getEntry(r111)) * TWO) / r312);
        ArrayRealVector r40 = this.gradientAtTrustRegionCenter;
        r40.setEntry(r111, ((r40.getEntry(r111) * r34) - (r311 * r113)) / r312);
        double r41 = r113 * r34;
        r210 = 0;
        if (r41 >= 0.0d) goto L85;
        int r42 = r26;
        if (r27 >= this.fAtInterpolationPoints.getEntry(r42)) goto L86;
        ArrayRealVector r43 = this.fAtInterpolationPoints;
        r310 = r310;
        r25 = r25;
        r43.setEntry(r19, r43.getEntry(r42));
        this.fAtInterpolationPoints.setEntry(r42, r27);
        if (this.trustRegionCenterInterpolationPointIndex != r19) goto L83;
        this.trustRegionCenterInterpolationPointIndex = r42;
    L83:
        double r46 = r34;
        this.interpolationPoints.setEntry(r42, r111, r46);
        this.interpolationPoints.setEntry(r19, r111, r113);
    L87:
        this.bMatrix.setEntry(0, r111, (-(r113 + r46)) / r41);
        this.bMatrix.setEntry(r19, r111, (-0.5d) / this.interpolationPoints.getEntry(r42, r111));
        Array2DRowRealMatrix r47 = this.bMatrix;
        r47.setEntry(r42, r111, (-r47.getEntry(0, r111)) - this.bMatrix.getEntry(r19, r111));
        this.zMatrix.setEntry(0, r111, FastMath.sqrt(TWO) / r41);
        this.zMatrix.setEntry(r19, r111, FastMath.sqrt(0.5d) / r5);
        Array2DRowRealMatrix r48 = this.zMatrix;
        r48.setEntry(r42, r111, (-r48.getEntry(0, r111)) - this.zMatrix.getEntry(r19, r111));
    L89:
        r114 = r31;
        r32 = r8;
        r37 = 2;
    L86:
        r46 = r34;
        goto L87
    L85:
        r42 = r26;
        goto L86
    L88:
        r310 = r310;
        r25 = r25;
        r210 = 0;
        goto L89
    L63:
        if (r27 >= this.fAtInterpolationPoints.getEntry(this.trustRegionCenterInterpolationPointIndex)) goto L66;
        this.trustRegionCenterInterpolationPointIndex = r19;
    L30:
        int r211 = r16;
        r26 = r110;
        if (r19 <= r1) goto L40;
        r26 = r26;
        double r212 = this.interpolationPoints.getEntry(r26, r111);
        int r49 = r17;
        r8 = r8;
        double r50 = -this.initialTrustRegionRadius;
        if (this.lowerDifference.getEntry(r111) != 0.0d) goto L37;
        r50 = FastMath.min(this.initialTrustRegionRadius * TWO, this.upperDifference.getEntry(r111));
    L37:
        if (this.upperDifference.getEntry(r111) != 0.0d) goto L39;
        r50 = FastMath.max(this.initialTrustRegionRadius * (-2.0d), this.lowerDifference.getEntry(r111));
    L39:
        this.interpolationPoints.setEntry(r19, r111, r50);
        r113 = r212;
        double r410 = r50;
        r17 = r49;
        r21 = r211;
        r22 = r410;
        goto L46
    L40:
        r21 = r211;
        r113 = 0.0d;
        goto L41
    L42:
        r8 = r8;
        r26 = r110;
        int r51 = (r19 - r10) / r1;
        r17 = (r19 - (r51 * r1)) - r1;
        r21 = r51 + r17;
        if (r21 <= r1) goto L45;
        r17 = r21 - r1;
        r21 = r17;
    L45:
        int r52 = r21 - 1;
        int r53 = r17 - 1;
        Array2DRowRealMatrix r115 = this.interpolationPoints;
        r115.setEntry(r19, r52, r115.getEntry(r21, r52));
        Array2DRowRealMatrix r54 = this.interpolationPoints;
        r54.setEntry(r19, r53, r54.getEntry(r17, r53));
        r22 = 0.0d;
        r113 = 0.0d;
        goto L46
    }

    private double[] trsbox(double r81, ArrayRealVector r83, ArrayRealVector r84, ArrayRealVector r85, ArrayRealVector r86, ArrayRealVector r87) {
        ArrayRealVector r2 = r84;
        ArrayRealVector r3 = r85;
        r86 = r86;
        printMethod();
        int r6 = this.currentBest.getDimension();
        int r7 = this.numberOfInterpolationPoints;
        int r9 = 0;
        int r10 = 0;
    L4:
        if (r9 >= r6) goto L19;
        r2.setEntry(r9, 0.0d);
        if (this.trustRegionCenterOffset.getEntry(r9) > this.lowerDifference.getEntry(r9)) goto L11;
        if (this.gradientAtTrustRegionCenter.getEntry(r9) < 0.0d) goto L16;
        r2.setEntry(r9, MINUS_ONE);
    L16:
        if (r2.getEntry(r9) == 0.0d) goto L18;
        r10 = r10 + 1;
    L18:
        this.trialStepPoint.setEntry(r9, 0.0d);
        r83.setEntry(r9, this.gradientAtTrustRegionCenter.getEntry(r9));
        r9 = r9 + 1;
        goto L4
    L11:
        if (this.trustRegionCenterOffset.getEntry(r9) < this.upperDifference.getEntry(r9)) goto L16;
        if (this.gradientAtTrustRegionCenter.getEntry(r9) > 0.0d) goto L16;
        r2.setEntry(r9, ONE);
        goto L16
    L19:
        double r8 = r81 * r81;
        int r15 = 20;
        double r22 = 0.0d;
        double r24 = 0.0d;
        double r26 = 0.0d;
        double r28 = 0.0d;
        double r30 = 0.0d;
        double r32 = 0.0d;
        double r34 = 0.0d;
        double r39 = 0.0d;
        double r41 = 0.0d;
        double r43 = 0.0d;
        double r45 = 0.0d;
        double r48 = 0.0d;
        double r51 = 0.0d;
        int r12 = 20;
        int r11 = 0;
        int r36 = 0;
        double r37 = MINUS_ONE;
        int r47 = -1;
        int r50 = 0;
    L21:
        if (r12 == r15) goto L233;
        if (r12 != 30) goto L24;
        r15 = r15;
        int r13 = 30;
    L234:
        printState(r13);
        int r14 = 0;
        r30 = 0.0d;
    L235:
        if (r14 >= r6) goto L245;
        if (r2.getEntry(r14) == 0.0d) goto L240;
        r3.setEntry(r14, 0.0d);
    L243:
        double r4 = r3.getEntry(r14);
        r30 = r30 + (r4 * r4);
        r14 = r14 + 1;
        goto L235
    L240:
        if (r34 != 0.0d) goto L242;
        r3.setEntry(r14, -r83.getEntry(r14));
        goto L243
    L242:
        r3.setEntry(r14, (r3.getEntry(r14) * r34) - r83.getEntry(r14));
        goto L243
    L245:
        if (r30 != 0.0d) goto L250;
        r50 = r50;
    L247:
        r12 = 190;
    L248:
        r86 = r86;
        r3 = r3;
        r7 = r7;
        r37 = r37;
        goto L21
    L250:
        if (r34 != 0.0d) goto L252;
        r50 = (r11 + r6) - r10;
        r22 = r30;
    L254:
        if ((r22 * r8) <= ((1.0E-4d * r28) * r28)) goto L247;
        r15 = r15;
        r12 = 210;
        goto L248
    L252:
        r50 = r50;
        goto L254
    L24:
        if (r12 != 50) goto L25;
        double r63 = r8;
        r10 = r10;
        int r71 = r11;
        r36 = r36;
        double r72 = r37;
        int r16 = r47;
        double r17 = r48;
        r7 = r7;
        r3 = r3;
        printState(50);
        double r53 = r63;
        int r18 = 0;
        double r38 = 0.0d;
        double r49 = 0.0d;
    L151:
        if (r18 >= r6) goto L157;
        if (r2.getEntry(r18) != 0.0d) goto L155;
        double r65 = this.trialStepPoint.getEntry(r18);
        r53 = r53 - (r65 * r65);
        r38 = r38 + (r3.getEntry(r18) * this.trialStepPoint.getEntry(r18));
        r49 = r49 + (r3.getEntry(r18) * r86.getEntry(r18));
    L155:
        r18 = r18 + 1;
        goto L151
    L157:
        if (r53 <= 0.0d) goto L158;
        double r55 = FastMath.sqrt((r30 * r53) + (r38 * r38));
        if (r38 >= 0.0d) goto L162;
        double r56 = (r55 - r38) / r30;
    L163:
        double r5 = r56;
        if (r49 <= 0.0d) goto L166;
        double r19 = FastMath.min(r5, r22 / r49);
    L167:
        double r20 = r19;
        int r21 = 0;
        r47 = -1;
    L168:
        if (r21 >= r6) goto L180;
        if (r3.getEntry(r21) == 0.0d) goto L178;
        double r66 = this.trustRegionCenterOffset.getEntry(r21) + this.trialStepPoint.getEntry(r21);
        if (r3.getEntry(r21) <= 0.0d) goto L174;
        double r54 = this.upperDifference.getEntry(r21) - r66;
        double r67 = r3.getEntry(r21);
    L175:
        double r57 = r54 / r67;
        if (r57 >= r20) goto L178;
        r47 = r21;
        r20 = r57;
        goto L178
    L174:
        r54 = this.lowerDifference.getEntry(r21) - r66;
        r67 = r3.getEntry(r21);
    L178:
        r21 = r21 + 1;
        goto L168
    L180:
        if (r20 <= 0.0d) goto L196;
        int r23 = r71 + 1;
        double r25 = r49 / r30;
        if (r47 == (-1)) goto L184;
    L188:
        r48 = r17;
        double r110 = r72;
    L189:
        int r27 = 0;
        double r52 = 0.0d;
    L190:
        if (r27 >= r6) goto L195;
        double r73 = r110;
        r83.setEntry(r27, r83.getEntry(r27) + (r86.getEntry(r27) * r20));
        if (r2.getEntry(r27) != 0.0d) goto L194;
        double r111 = r83.getEntry(r27);
        r52 = r52 + (r111 * r111);
    L194:
        ArrayRealVector r112 = this.trialStepPoint;
        r112.setEntry(r27, r112.getEntry(r27) + (r3.getEntry(r27) * r20));
        r27 = r27 + 1;
        r110 = r73;
        goto L190
    L195:
        r37 = r110;
        double r29 = 0.0d;
        double r58 = FastMath.max((r22 - ((0.5d * r20) * r49)) * r20, 0.0d);
        r28 = r28 + r58;
        double r113 = r58;
        double r78 = r22;
        r22 = r52;
        r51 = r78;
    L197:
        if (r47 < 0) goto L207;
        r10 = r10 + 1;
        r2.setEntry(r47, ONE);
        if (r3.getEntry(r47) >= r29) goto L201;
        r2.setEntry(r47, MINUS_ONE);
    L201:
        double r114 = this.trialStepPoint.getEntry(r47);
        double r115 = r63 - (r114 * r114);
        if (r115 > r29) goto L204;
        r12 = 190;
    L205:
        r15 = 20;
        r11 = r23;
        r8 = r115;
        goto L21
    L204:
        r12 = 20;
        goto L205
    L207:
        if (r20 >= r5) goto L216;
        r50 = r50;
        if (r23 != r50) goto L213;
    L210:
        r12 = 190;
    L211:
        r15 = 20;
        r11 = r23;
        r8 = r63;
        goto L21
    L213:
        if (r113 <= (0.01d * r28)) goto L210;
        r34 = r22 / r51;
        r12 = 30;
        goto L211
    L216:
        r47 = r47;
        int r116 = r23;
        int r31 = 90;
    L217:
        printState(r31);
        r36 = r116;
        int r33 = 100;
        double r74 = 0.0d;
    L218:
        printState(r33);
        r10 = r10;
        if (r10 < (r6 - 1)) goto L224;
        r86 = r86;
        r3 = r3;
        r50 = r50;
        r11 = r36;
        r7 = r7;
        r36 = r36;
        r8 = r63;
        r48 = r48;
    L221:
        r37 = r74;
        r12 = 190;
    L223:
        r15 = 20;
        goto L21
    L224:
        int r35 = 0;
        r22 = 0.0d;
        r24 = 0.0d;
        r26 = 0.0d;
    L225:
        if (r35 >= r6) goto L231;
        if (r2.getEntry(r35) != 0.0d) goto L229;
        double r117 = this.trialStepPoint.getEntry(r35);
        r24 = r24 + (r117 * r117);
        r26 = r26 + (this.trialStepPoint.getEntry(r35) * r83.getEntry(r35));
        double r118 = r83.getEntry(r35);
        r22 = r22 + (r118 * r118);
        r3.setEntry(r35, this.trialStepPoint.getEntry(r35));
    L230:
        r35 = r35 + 1;
        goto L225
    L229:
        r3.setEntry(r35, 0.0d);
        goto L230
    L231:
        r86 = r86;
        r3 = r3;
        r50 = r50;
        r11 = r36;
        r7 = r7;
        r8 = r63;
        r48 = r48;
        r37 = r74;
        r12 = 210;
        goto L223
    L184:
        if (r25 <= 0.0d) goto L188;
        r48 = r17;
        r110 = FastMath.min(r72, r25);
        if (r110 != MINUS_ONE) goto L189;
        r110 = r25;
        goto L189
    L196:
        r48 = r17;
        r29 = 0.0d;
        r23 = r71;
        r37 = r72;
        r113 = 0.0d;
        goto L197
    L166:
        r19 = r5;
        goto L167
    L162:
        r56 = r53 / (r55 + r38);
        goto L163
    L158:
        r3 = r3;
        r47 = r16;
        r48 = r17;
        r7 = r7;
        r36 = r36;
        r11 = r71;
        r37 = r72;
        r10 = r10;
        r12 = 90;
        r8 = r63;
        goto L223
    L25:
        if (r12 == 90) goto L149;
        if (r12 == 100) goto L148;
        if (r12 != 120) goto L30;
        double r64 = r8;
        int r119 = r10;
        int r75 = r11;
        int r62 = r36;
        double r76 = r37;
        int r120 = r47;
        double r121 = r48;
        int r310 = r7;
        printState(120);
        int r122 = r75 + 1;
        double r123 = (r22 * r24) - (r26 * r26);
        if (r123 <= ((1.0E-4d * r28) * r28)) goto L117;
        double r40 = FastMath.sqrt(r123);
        int r42 = 0;
    L119:
        if (r42 >= r6) goto L125;
        int r82 = r122;
        if (r2.getEntry(r42) != 0.0d) goto L123;
        r85.setEntry(r42, ((this.trialStepPoint.getEntry(r42) * r26) - (r83.getEntry(r42) * r24)) / r40);
    L124:
        r42 = r42 + 1;
        r122 = r82;
        goto L119
    L123:
        r85.setEntry(r42, 0.0d);
        goto L124
    L125:
        int r88 = r122;
        double r44 = 0.0d;
        double r46 = -r40;
        r48 = r121;
        int r59 = 0;
        r32 = ONE;
        r47 = -1;
    L126:
        if (r59 >= r6) goto L146;
        if (r2.getEntry(r59) != r44) goto L145;
        double r60 = (this.trustRegionCenterOffset.getEntry(r59) + this.trialStepPoint.getEntry(r59)) - this.lowerDifference.getEntry(r59);
        double r124 = (this.upperDifference.getEntry(r59) - this.trustRegionCenterOffset.getEntry(r59)) - this.trialStepPoint.getEntry(r59);
        if (r60 <= 0.0d) goto L131;
        if (r124 <= 0.0d) goto L134;
        double r311 = this.trialStepPoint.getEntry(r59);
        double r410 = r85.getEntry(r59);
        double r312 = (r311 * r311) + (r410 * r410);
        double r411 = this.trustRegionCenterOffset.getEntry(r59) - this.lowerDifference.getEntry(r59);
        double r412 = r312 - (r411 * r411);
        if (r412 <= 0.0d) goto L140;
        double r413 = FastMath.sqrt(r412) - r85.getEntry(r59);
        if ((r32 * r413) <= r60) goto L140;
        r32 = r60 / r413;
        r47 = r59;
        r48 = MINUS_ONE;
    L140:
        double r61 = this.upperDifference.getEntry(r59) - this.trustRegionCenterOffset.getEntry(r59);
        double r313 = r312 - (r61 * r61);
        if (r313 <= 0.0d) goto L145;
        double r68 = FastMath.sqrt(r313) + r85.getEntry(r59);
        if ((r32 * r68) <= r124) goto L145;
        r47 = r59;
        r32 = r124 / r68;
        r48 = ONE;
        goto L145
    L134:
        r10 = r119 + 1;
        r2.setEntry(r59, ONE);
    L147:
        r45 = r46;
        r3 = r85;
        r7 = r310;
        r36 = r62;
        r8 = r64;
        r37 = r76;
        r12 = 210;
        r15 = 20;
        r11 = r88;
        goto L21
    L131:
        r10 = r119 + 1;
        r2.setEntry(r59, MINUS_ONE);
    L145:
        r59 = r59 + 1;
        r44 = 0.0d;
        goto L126
    L146:
        r10 = r119;
        goto L147
    L117:
        r47 = r120;
        r48 = r121;
        r7 = r310;
        r36 = r62;
        r8 = r64;
        r37 = r76;
        r15 = 20;
        r11 = r122;
        r10 = r119;
        r12 = 190;
        r3 = r85;
        goto L21
    L30:
        if (r12 != 150) goto L32;
        double r69 = r8;
        int r70 = r36;
        double r125 = r37;
        printState(150);
        int r77 = 0;
        double r314 = 0.0d;
        double r510 = 0.0d;
        double r610 = 0.0d;
    L67:
        if (r77 >= r6) goto L72;
        if (r2.getEntry(r77) != 0.0d) goto L71;
        r314 = r314 + (r3.getEntry(r77) * r86.getEntry(r77));
        r510 = r510 + (this.trialStepPoint.getEntry(r77) * r86.getEntry(r77));
        r610 = r610 + (this.trialStepPoint.getEntry(r77) * r87.getEntry(r77));
    L71:
        r77 = r77 + 1;
        goto L67
    L72:
        int r79 = (int) ((17.0d * r32) + 3.1d);
        int r126 = 0;
        int r127 = -1;
        double r611 = 0.0d;
        double r612 = 0.0d;
    L73:
        if (r126 >= r79) goto L81;
        int r315 = r7;
        int r613 = r70;
        int r710 = r11;
        double r711 = r125;
        r39 = (((double) r126) * r32) / ((double) r79);
        double r80 = (r39 + r39) / ((r39 * r39) + ONE);
        double r89 = r80 * (((r39 * r26) - r45) - ((r80 * 0.5d) * (r314 + ((((r39 * r610) - r510) - r510) * r39))));
        if (r89 <= r611) goto L78;
        r611 = r89;
        r127 = r126;
        r41 = r612;
    L80:
        r126 = r126 + 1;
        r612 = r89;
        r7 = r315;
        r70 = r613;
        r11 = r710;
        r125 = r711;
        goto L73
    L78:
        if (r126 != (r127 + 1)) goto L80;
        r43 = r89;
        goto L80
    L81:
        int r316 = r7;
        int r614 = r70;
        int r712 = r11;
        r74 = r125;
        if (r127 >= 0) goto L84;
    L83:
        r7 = r316;
        r36 = r614;
        r8 = r69;
        r11 = r712;
        goto L221
    L84:
        if (r127 >= r79) goto L86;
        r39 = ((((double) r127) + (((r43 - r41) / (((r611 + r611) - r41) - r43)) * 0.5d)) * r32) / ((double) r79);
    L86:
        double r90 = r39 * r39;
        double r128 = ONE - r90;
        double r91 = r90 + ONE;
        double r129 = r128 / r91;
        double r130 = (r39 + r39) / r91;
        double r92 = (((r39 * r26) - r45) - ((0.5d * r130) * (r314 + ((((r610 * r39) - r510) - r510) * r39)))) * r130;
        if (r92 <= 0.0d) goto L83;
        int r131 = 0;
        r22 = 0.0d;
        r26 = 0.0d;
    L90:
        if (r131 >= r6) goto L95;
        int r615 = r79;
        int r132 = r10;
        r83.setEntry(r131, (r83.getEntry(r131) + ((r129 - ONE) * r87.getEntry(r131))) + (r86.getEntry(r131) * r130));
        if (r2.getEntry(r131) != 0.0d) goto L94;
        ArrayRealVector r93 = this.trialStepPoint;
        r93.setEntry(r131, (r93.getEntry(r131) * r129) + (r3.getEntry(r131) * r130));
        r26 = r26 + (this.trialStepPoint.getEntry(r131) * r83.getEntry(r131));
        double r94 = r83.getEntry(r131);
        r22 = r22 + (r94 * r94);
    L94:
        r87.setEntry(r131, (r87.getEntry(r131) * r129) + (r86.getEntry(r131) * r130));
        r131 = r131 + 1;
        r2 = r84;
        r3 = r85;
        r10 = r132;
        r79 = r615;
        goto L90
    L95:
        int r616 = r79;
        int r133 = r10;
        r28 = r28 + r92;
        int r134 = r47;
        if (r134 >= 0) goto L98;
    L100:
        r2 = r84;
        double r135 = r48;
        if (r92 <= (0.01d * r28)) goto L103;
        r3 = r85;
        r47 = r134;
        r10 = r133;
        r48 = r135;
        r7 = r316;
        r36 = r614;
        r8 = r69;
        r11 = r712;
        r37 = r74;
    L62:
        r12 = 120;
        goto L223
    L103:
        int r95 = 190;
    L104:
        printState(r95);
        int r96 = 0;
        double r136 = 0.0d;
    L105:
        if (r96 >= r6) goto L114;
        this.newPoint.setEntry(r96, FastMath.max(FastMath.min(this.trustRegionCenterOffset.getEntry(r96) + this.trialStepPoint.getEntry(r96), this.upperDifference.getEntry(r96)), this.lowerDifference.getEntry(r96)));
        if (r2.getEntry(r96) != MINUS_ONE) goto L110;
        this.newPoint.setEntry(r96, this.lowerDifference.getEntry(r96));
    L110:
        if (r2.getEntry(r96) != ONE) goto L112;
        this.newPoint.setEntry(r96, this.upperDifference.getEntry(r96));
    L112:
        this.trialStepPoint.setEntry(r96, this.newPoint.getEntry(r96) - this.trustRegionCenterOffset.getEntry(r96));
        double r97 = this.trialStepPoint.getEntry(r96);
        r136 = r136 + (r97 * r97);
        r96 = r96 + 1;
        goto L105
    L114:
        return new double[]{r136, r74};
    L98:
        if (r127 != r616) goto L100;
        r10 = r133 + 1;
        r2 = r84;
        r2.setEntry(r134, r48);
        r3 = r85;
        r47 = r134;
        r7 = r316;
        r36 = r614;
        r8 = r69;
        r11 = r712;
        r37 = r74;
        r12 = 100;
        goto L223
    L32:
        if (r12 == 190) goto L65;
        if (r12 != 210) goto L64;
        printState(210);
        int r137 = 0;
        int r138 = 0;
    L36:
        if (r137 >= r6) goto L44;
        r86.setEntry(r137, 0.0d);
        r138 = r138;
        int r139 = 0;
    L38:
        if (r139 > r137) goto L43;
        if (r139 >= r137) goto L42;
        r86.setEntry(r137, r86.getEntry(r137) + (this.modelSecondDerivativesValues.getEntry(r138) * r3.getEntry(r139)));
    L42:
        r86.setEntry(r139, r86.getEntry(r139) + (this.modelSecondDerivativesValues.getEntry(r138) * r3.getEntry(r137)));
        r138 = r138 + 1;
        r139 = r139 + 1;
        r8 = r8;
        goto L38
    L43:
        r137 = r137 + 1;
        goto L36
    L44:
        double r617 = r8;
        RealVector r98 = this.interpolationPoints.operate(r3).ebeMultiply(this.modelSecondDerivativesParameters);
        int r99 = 0;
    L45:
        if (r99 >= r7) goto L52;
        if (this.modelSecondDerivativesParameters.getEntry(r99) == 0.0d) goto L51;
        int r140 = 0;
    L49:
        if (r140 >= r6) goto L51;
        r86.setEntry(r140, r86.getEntry(r140) + (r98.getEntry(r99) * this.interpolationPoints.getEntry(r99, r140)));
        r140 = r140 + 1;
    L51:
        r99 = r99 + 1;
        goto L45
    L52:
        double r141 = r37;
        if (r141 == 0.0d) goto L55;
        r37 = r141;
        r8 = r617;
        r12 = 50;
        goto L223
    L55:
        int r100 = r36;
        if (r11 <= r100) goto L58;
        r36 = r100;
        r37 = r141;
        r8 = r617;
        r12 = 150;
        goto L223
    L58:
        int r101 = 0;
    L59:
        if (r101 >= r6) goto L61;
        r87.setEntry(r101, r86.getEntry(r101));
        r101 = r101 + 1;
        goto L59
    L61:
        r36 = r100;
        r37 = r141;
        r8 = r617;
        goto L62
    L64:
        throw new MathIllegalStateException(LocalizedFormats.SIMPLE_MESSAGE, new Object[]{"trsbox"});
    L65:
        r95 = 190;
        r74 = r37;
        goto L104
    L148:
        r63 = r8;
        r10 = r10;
        r36 = r36;
        r74 = r37;
        r7 = r7;
        r3 = r3;
        r33 = 100;
        r48 = r48;
        r50 = r50;
        r36 = r11;
        goto L218
    L149:
        r7 = r7;
        r63 = r8;
        r10 = r10;
        r36 = r36;
        r3 = r3;
        r31 = 90;
        r48 = r48;
        r116 = r11;
        goto L217
    L233:
        r15 = r15;
        printState(r15);
        r13 = 30;
        r34 = 0.0d;
        goto L234
    }

    private void update(double r28, double r30, int r32) {
        int r1 = r32;
        printMethod();
        int r2 = this.currentBest.getDimension();
        int r3 = this.numberOfInterpolationPoints;
        int r5 = 1;
        int r4 = (r3 - r2) - 1;
        ArrayRealVector r6 = new ArrayRealVector(r3 + r2);
        int r9 = 0;
        int r10 = 0;
        double r11 = 0.0d;
    L3:
        if (r10 >= r3) goto L8;
        int r13 = 0;
    L5:
        if (r13 >= r4) goto L7;
        r11 = FastMath.max(r11, FastMath.abs(this.zMatrix.getEntry(r10, r13)));
        r13 = r13 + 1;
        goto L5
    L7:
        r10 = r10 + 1;
        goto L3
    L8:
        double r12 = r11 * 1.0E-20d;
    L9:
        if (r5 >= r4) goto L16;
        if (FastMath.abs(this.zMatrix.getEntry(r1, r5)) <= r12) goto L15;
        double r14 = this.zMatrix.getEntry(r1, 0);
        double r15 = this.zMatrix.getEntry(r1, r5);
        double r16 = FastMath.sqrt((r14 * r14) + (r15 * r15));
        double r17 = this.zMatrix.getEntry(r1, 0) / r16;
        double r18 = this.zMatrix.getEntry(r1, r5) / r16;
        int r19 = 0;
    L13:
        if (r19 >= r3) goto L15;
        double r110 = (this.zMatrix.getEntry(r19, 0) * r17) + (this.zMatrix.getEntry(r19, r5) * r18);
        Array2DRowRealMatrix r7 = this.zMatrix;
        r7.setEntry(r19, r5, (r7.getEntry(r19, r5) * r17) - (this.zMatrix.getEntry(r19, 0) * r18));
        this.zMatrix.setEntry(r19, 0, r110);
        r19 = r19 + 1;
        r12 = r12;
    L15:
        this.zMatrix.setEntry(r1, r5, 0.0d);
        r5 = r5 + 1;
        r12 = r12;
        goto L9
    L16:
        int r8 = 0;
    L17:
        if (r8 >= r3) goto L19;
        r6.setEntry(r8, this.zMatrix.getEntry(r1, 0) * this.zMatrix.getEntry(r8, 0));
        r8 = r8 + 1;
        goto L17
    L19:
        double r20 = r6.getEntry(r1);
        double r21 = this.lagrangeValuesAtNewPoint.getEntry(r1);
        ArrayRealVector r111 = this.lagrangeValuesAtNewPoint;
        r111.setEntry(r1, r111.getEntry(r1) - ONE);
        double r112 = FastMath.sqrt(r30);
        double r113 = r21 / r112;
        double r114 = this.zMatrix.getEntry(r1, 0) / r112;
        int r115 = 0;
    L20:
        if (r115 >= r3) goto L22;
        Array2DRowRealMatrix r116 = this.zMatrix;
        double r22 = r113;
        double r117 = (r116.getEntry(r115, r9) * r113) - (this.lagrangeValuesAtNewPoint.getEntry(r115) * r114);
        r9 = 0;
        r116.setEntry(r115, 0, r117);
        r115 = r115 + 1;
        r113 = r22;
        goto L20
    L22:
        int r118 = r9;
    L23:
        if (r118 >= r2) goto L32;
        int r119 = r3 + r118;
        r6.setEntry(r119, this.bMatrix.getEntry(r1, r118));
        double r120 = ((this.lagrangeValuesAtNewPoint.getEntry(r119) * r20) - (r6.getEntry(r119) * r21)) / r30;
        int r121 = r118;
        double r23 = (((-r28) * r6.getEntry(r119)) - (this.lagrangeValuesAtNewPoint.getEntry(r119) * r21)) / r30;
        int r24 = 0;
    L25:
        if (r24 > r119) goto L31;
        int r122 = r2;
        Array2DRowRealMatrix r25 = this.bMatrix;
        double r123 = r20;
        int r26 = r121;
        ArrayRealVector r124 = r6;
        r25.setEntry(r24, r26, (r25.getEntry(r24, r26) + (this.lagrangeValuesAtNewPoint.getEntry(r24) * r120)) + (r6.getEntry(r24) * r23));
        if (r24 < r3) goto L30;
        Array2DRowRealMatrix r27 = this.bMatrix;
        r27.setEntry(r119, r24 - r3, r27.getEntry(r24, r26));
    L30:
        r24 = r24 + 1;
        r6 = r124;
        r2 = r122;
        r21 = r21;
        r121 = r26;
        r20 = r123;
        goto L25
    L31:
        r118 = r121 + 1;
        r1 = r32;
        r20 = r20;
        goto L23
    }

    private void setup(double[] r16, double[] r17) {
        printMethod();
        int r1 = getStartPoint().length;
        if (r1 < 2) goto L18;
        int r5 = r1 + 2;
        int r6 = 0;
        int r7 = r1 + 1;
        int r8 = (r5 * r7) / 2;
        int[] r4 = {r5, r8};
        int r9 = this.numberOfInterpolationPoints;
        if (r9 < r5) goto L16;
        if (r9 > r8) goto L16;
        this.boundDifference = new double[r1];
        double r10 = this.initialTrustRegionRadius * TWO;
        double r11 = Double.POSITIVE_INFINITY;
    L8:
        if (r6 >= r1) goto L11;
        double[] r12 = this.boundDifference;
        double r13 = r17[r6] - r16[r6];
        r12[r6] = r13;
        r11 = FastMath.min(r11, r13);
        r6 = r6 + 1;
        goto L8
    L11:
        if (r11 >= r10) goto L13;
        this.initialTrustRegionRadius = r11 / 3.0d;
    L13:
        this.bMatrix = new Array2DRowRealMatrix(this.numberOfInterpolationPoints + r1, r1);
        int r14 = this.numberOfInterpolationPoints;
        this.zMatrix = new Array2DRowRealMatrix(r14, (r14 - r1) - 1);
        this.interpolationPoints = new Array2DRowRealMatrix(this.numberOfInterpolationPoints, r1);
        this.originShift = new ArrayRealVector(r1);
        this.fAtInterpolationPoints = new ArrayRealVector(this.numberOfInterpolationPoints);
        this.trustRegionCenterOffset = new ArrayRealVector(r1);
        this.gradientAtTrustRegionCenter = new ArrayRealVector(r1);
        this.lowerDifference = new ArrayRealVector(r1);
        this.upperDifference = new ArrayRealVector(r1);
        this.modelSecondDerivativesParameters = new ArrayRealVector(this.numberOfInterpolationPoints);
        this.newPoint = new ArrayRealVector(r1);
        this.alternativeNewPoint = new ArrayRealVector(r1);
        this.trialStepPoint = new ArrayRealVector(r1);
        this.lagrangeValuesAtNewPoint = new ArrayRealVector(this.numberOfInterpolationPoints + r1);
        this.modelSecondDerivativesValues = new ArrayRealVector((r1 * r7) / 2);
        return;
    L16:
        throw new OutOfRangeException(LocalizedFormats.NUMBER_OF_INTERPOLATION_POINTS, Integer.valueOf(this.numberOfInterpolationPoints), Integer.valueOf(r4[0]), Integer.valueOf(r4[1]));
    L18:
        throw new NumberIsTooSmallException(Integer.valueOf(r1), 2, true);
    }

    private static String caller(int r2) {
        StackTraceElement r3 = new Throwable().getStackTrace()[r2];
        return r3.getMethodName() + " (at line " + r3.getLineNumber() + ")";
    }
}
