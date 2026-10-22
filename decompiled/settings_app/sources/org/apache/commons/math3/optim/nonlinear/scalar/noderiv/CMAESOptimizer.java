package org.apache.commons.math3.optim.nonlinear.scalar.noderiv;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class CMAESOptimizer extends MultivariateOptimizer {
    private RealMatrix B;
    private RealMatrix BD;
    private RealMatrix C;
    private RealMatrix D;
    private double cc;
    private double ccov1;
    private double ccov1Sep;
    private double ccovmu;
    private double ccovmuSep;
    private final int checkFeasableCount;
    private double chiN;
    private double cs;
    private double damps;
    private RealMatrix diagC;
    private RealMatrix diagD;
    private int diagonalOnly;
    private int dimension;
    private double[] fitnessHistory;
    private final boolean generateStatistics;
    private int historySize;
    private double[] inputSigma;
    private final boolean isActiveCMA;
    private boolean isMinimize;
    private int iterations;
    private int lambda;
    private double logMu2;
    private final int maxIterations;
    private int mu;
    private double mueff;
    private double normps;
    private RealMatrix pc;
    private RealMatrix ps;
    private final RandomGenerator random;
    private double sigma;
    private final List<RealMatrix> statisticsDHistory;
    private final List<Double> statisticsFitnessHistory;
    private final List<RealMatrix> statisticsMeanHistory;
    private final List<Double> statisticsSigmaHistory;
    private final double stopFitness;
    private double stopTolFun;
    private double stopTolHistFun;
    private double stopTolUpX;
    private double stopTolX;
    private RealMatrix weights;
    private RealMatrix xmean;

    private static class DoubleIndex implements Comparable<DoubleIndex> {
        private final int index;
        private final double value;

        static /* synthetic */ int access$300(DoubleIndex r0) {
            return r0.index;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(DoubleIndex r1) {
            return compareTo2(r1);
        }

        DoubleIndex(double r1, int r3) {
            this.value = r1;
            this.index = r3;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(DoubleIndex r3) {
            return Double.compare(this.value, r3.value);
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L6;
            return true;
        L6:
            if ((r6 instanceof DoubleIndex) == true) goto L8;
            return false;
        L8:
            if (Double.compare(this.value, ((DoubleIndex) r6).value) != 0) goto L11;
            return true;
        L11:
            return false;
        }

        public int hashCode() {
            long r0 = Double.doubleToLongBits(this.value);
            return (int) ((r0 ^ ((r0 >>> 32) ^ 1438542)) & (-1));
        }
    }

    private class FitnessFunction {
        private final boolean isRepairMode;
        final /* synthetic */ CMAESOptimizer this$0;

        static /* synthetic */ double[] access$200(FitnessFunction r0, double[] r1) {
            return r0.repair(r1);
        }

        FitnessFunction(CMAESOptimizer r1) {
            this.this$0 = r1;
            this.isRepairMode = true;
        }

        public ValuePenaltyPair value(double[] r6) {
            if (this.isRepairMode == false) goto L5;
            double[] r0 = repair(r6);
            double r1 = this.this$0.computeObjectiveValue(r0);
            double r3 = penalty(r6, r0);
        L7:
            if (CMAESOptimizer.access$400(this.this$0) == true) goto L11;
            r1 = -r1;
        L11:
            if (CMAESOptimizer.access$400(this.this$0) == true) goto L15;
            r3 = -r3;
        L15:
            return new ValuePenaltyPair(r1, r3);
        L5:
            r1 = this.this$0.computeObjectiveValue(r6);
            r3 = 0.0d;
            goto L7
        }

        public boolean isFeasible(double[] r8) {
            double[] r0 = this.this$0.getLowerBound();
            double[] r7 = this.this$0.getUpperBound();
            int r2 = 0;
        L4:
            if (r2 >= r8.length) goto L12;
            double r3 = r8[r2];
            if (r3 < r0[r2]) goto L7;
            if (r3 > r7[r2]) goto L10;
            r2 = r2 + 1;
            goto L4
        L10:
            return false;
        L7:
            return false;
        L12:
            return true;
        }

        private double[] repair(double[] r9) {
            double[] r0 = this.this$0.getLowerBound();
            double[] r8 = this.this$0.getUpperBound();
            double[] r1 = new double[r9.length];
            int r2 = 0;
        L4:
            if (r2 >= r9.length) goto L13;
            double r3 = r9[r2];
            double r5 = r0[r2];
            if (r3 >= r5) goto L8;
            r1[r2] = r5;
        L12:
            r2 = r2 + 1;
            goto L4
        L8:
            double r6 = r8[r2];
            if (r3 <= r6) goto L11;
            r1[r2] = r6;
            goto L12
        L11:
            r1[r2] = r3;
            goto L12
        L13:
            return r1;
        }

        private double penalty(double[] r8, double[] r9) {
            double r0 = 0.0d;
            int r2 = 0;
        L4:
            if (r2 >= r8.length) goto L7;
            r0 = r0 + FastMath.abs(r8[r2] - r9[r2]);
            r2 = r2 + 1;
            goto L4
        L7:
            if (CMAESOptimizer.access$400(this.this$0) == false) goto L10;
            return r0;
        L10:
            return -r0;
        }
    }

    public static class PopulationSize implements OptimizationData {
        private final int lambda;

        public PopulationSize(int r1) throws NotStrictlyPositiveException {
            if (r1 <= 0) goto L7;
            this.lambda = r1;
            return;
        L7:
            throw new NotStrictlyPositiveException(Integer.valueOf(r1));
        }

        public int getPopulationSize() {
            return this.lambda;
        }
    }

    public static class Sigma implements OptimizationData {
        private final double[] sigma;

        public Sigma(double[] r6) throws NotPositiveException {
            int r0 = 0;
        L4:
            if (r0 >= r6.length) goto L10;
            if (r6[r0] < 0.0d) goto L9;
            r0 = r0 + 1;
            goto L4
        L9:
            throw new NotPositiveException(Double.valueOf(r6[r0]));
        L10:
            this.sigma = (double[]) r6.clone();
        }

        public double[] getSigma() {
            return (double[]) this.sigma.clone();
        }
    }

    private static class ValuePenaltyPair {
        private double penalty;
        private double value;

        static /* synthetic */ double access$000(ValuePenaltyPair r2) {
            return r2.value;
        }

        static /* synthetic */ double access$100(ValuePenaltyPair r2) {
            return r2.penalty;
        }

        ValuePenaltyPair(double r1, double r3) {
            this.value = r1;
            this.penalty = r3;
        }
    }

    static /* synthetic */ boolean access$400(CMAESOptimizer r0) {
        return r0.isMinimize;
    }

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    protected /* bridge */ /* synthetic */ Object doOptimize() {
        return doOptimize();
    }

    @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer, org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public /* bridge */ /* synthetic */ Object optimize(OptimizationData[] r1) {
        return optimize(r1);
    }

    public CMAESOptimizer(int r1, double r2, boolean r4, int r5, int r6, RandomGenerator r7, boolean r8, ConvergenceChecker<PointValuePair> r9) {
        super(r9);
        this.isMinimize = true;
        this.statisticsSigmaHistory = new ArrayList();
        this.statisticsMeanHistory = new ArrayList();
        this.statisticsFitnessHistory = new ArrayList();
        this.statisticsDHistory = new ArrayList();
        this.maxIterations = r1;
        this.stopFitness = r2;
        this.isActiveCMA = r4;
        this.diagonalOnly = r5;
        this.checkFeasableCount = r6;
        this.random = r7;
        this.generateStatistics = r8;
    }

    public List<Double> getStatisticsSigmaHistory() {
        return this.statisticsSigmaHistory;
    }

    public List<RealMatrix> getStatisticsMeanHistory() {
        return this.statisticsMeanHistory;
    }

    public List<Double> getStatisticsFitnessHistory() {
        return this.statisticsFitnessHistory;
    }

    public List<RealMatrix> getStatisticsDHistory() {
        return this.statisticsDHistory;
    }

    @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer, org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public PointValuePair optimize(OptimizationData... r1) throws TooManyEvaluationsException, DimensionMismatchException {
        return super.optimize(r1);
    }

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    protected PointValuePair doOptimize() {
        this.isMinimize = getGoalType().equals(GoalType.MINIMIZE);
        FitnessFunction r7 = new FitnessFunction(this);
        double[] r0 = getStartPoint();
        this.dimension = r0.length;
        initializeCMA(r0);
        int r8 = 0;
        this.iterations = 0;
        ValuePenaltyPair r1 = r7.value(r0);
        double r2 = ValuePenaltyPair.access$000(r1) + ValuePenaltyPair.access$100(r1);
        push(this.fitnessHistory, r2);
        double[] r3 = getStartPoint();
        if (this.isMinimize == false) goto L5;
        double r4 = r2;
    L6:
        PointValuePair r5 = new PointValuePair(r3, r4);
        int r9 = 1;
        this.iterations = 1;
        PointValuePair r11 = r5;
        double r12 = r2;
        PointValuePair r14 = null;
    L8:
        if (this.iterations > this.maxIterations) goto L117;
        incrementIterationCount();
        RealMatrix r6 = randn1(this.dimension, this.lambda);
        RealMatrix r10 = zeros(this.dimension, this.lambda);
        int r13 = this.lambda;
        double[] r15 = new double[r13];
        ValuePenaltyPair[] r16 = new ValuePenaltyPair[r13];
        int r17 = r8;
    L11:
        if (r17 >= this.lambda) goto L30;
        int r18 = r8;
        RealMatrix r19 = null;
    L14:
        if (r18 >= (this.checkFeasableCount + r9)) goto L26;
        if (this.diagonalOnly > 0) goto L18;
        RealMatrix r20 = this.xmean.add(this.BD.multiply(r6.getColumnMatrix(r17)).scalarMultiply(this.sigma));
    L20:
        if (r18 >= this.checkFeasableCount) goto L25;
        if (r7.isFeasible(r20.getColumn(0)) == true) goto L25;
        r6.setColumn(r17, randn(this.dimension));
        r18 = r18 + 1;
        r19 = r20;
        r11 = r11;
        r12 = r12;
        r8 = 0;
        r9 = 1;
    L25:
        int r21 = 0;
    L27:
        copyColumn(r20, r21, r10, r17);
        r16[r17] = r7.value(r10.getColumn(r17));     // Catch: TooManyEvaluationsException -> L120
        r17 = r17 + 1;
        r11 = r11;
        r12 = r12;
        r8 = 0;
        r9 = 1;
    L119:
        return r11;
    L18:
        r20 = this.xmean.add(times(this.diagD, r6.getColumnMatrix(r17)).scalarMultiply(this.sigma));
        goto L20
    L26:
        r11 = r11;
        r12 = r12;
        r21 = r8;
        r20 = r19;
        goto L27
    L30:
        PointValuePair r22 = r11;
        double r110 = r12;
        double r23 = valueRange(r16);
        int r24 = 0;
    L31:
        if (r24 >= r13) goto L33;
        r15[r24] = ValuePenaltyPair.access$000(r16[r24]) + (ValuePenaltyPair.access$100(r16[r24]) * r23);
        r24 = r24 + 1;
        goto L31
    L33:
        int[] r25 = sortedIndices(r15);
        RealMatrix r26 = this.xmean;
        RealMatrix r111 = selectColumns(r10, MathArrays.copyOf(r25, this.mu));
        this.xmean = r111.multiply(this.weights);
        RealMatrix r27 = selectColumns(r6, MathArrays.copyOf(r25, this.mu));
        boolean r28 = updateEvolutionPaths(r27.multiply(this.weights), r26);
        if (this.diagonalOnly > 0) goto L36;
        updateCovariance(r28, r111, r6, r25, r26);
    L37:
        this.sigma *= FastMath.exp(FastMath.min(1.0d, (((this.normps / this.chiN) - 1.0d) * this.cs) / this.damps));
        double r29 = r15[r25[0]];
        double r30 = r15[r25[r25.length - 1]];
        if (r110 <= r29) goto L49;
        double[] r31 = FitnessFunction.access$200(r7, r111.getColumn(0));
        if (this.isMinimize == false) goto L42;
        double r112 = r29;
    L43:
        PointValuePair r32 = new PointValuePair(r31, r112);
        if (getConvergenceChecker() != null) goto L46;
    L48:
        r110 = r29;
        PointValuePair r113 = r22;
    L50:
        double r114 = this.stopFitness;
        if (r114 != 0.0d) goto L53;
    L59:
        double[] r33 = sqrt(this.diagC).getColumn(0);
        double[] r115 = this.pc.getColumn(0);
        int r34 = 0;
    L61:
        if (r34 >= this.dimension) goto L69;
        FitnessFunction r116 = r7;
        int[] r210 = r25;
        PointValuePair r211 = r113;
        double[] r212 = r115;
        if ((this.sigma * FastMath.max(FastMath.abs(r115[r34]), r33[r34])) > this.stopTolX) goto L70;
        if (r34 >= (this.dimension - 1)) goto L142;
        r34 = r34 + 1;
        r7 = r116;
        r113 = r211;
        r115 = r212;
        r25 = r210;
    L142:
        return r32;
    L70:
        int r35 = 0;
    L72:
        if (r35 >= this.dimension) goto L77;
        if ((this.sigma * r33[r35]) > this.stopTolUpX) goto L142;
        r35 = r35 + 1;
        goto L72
    L77:
        double r36 = min(this.fitnessHistory);
        double r117 = max(this.fitnessHistory);
        if (this.iterations <= 2) goto L83;
        if ((FastMath.max(r117, r30) - FastMath.min(r36, r29)) < this.stopTolFun) goto L142;
    L83:
        if (this.iterations <= this.fitnessHistory.length) goto L88;
        if ((r117 - r36) < this.stopTolHistFun) goto L142;
    L88:
        if ((max(this.diagD) / min(this.diagD)) > 1.0E7d) goto L142;
        if (getConvergenceChecker() == null) goto L102;
        double[] r37 = r111.getColumn(0);
        if (this.isMinimize == false) goto L95;
        double r118 = r29;
    L96:
        PointValuePair r38 = new PointValuePair(r37, r118);
        if (r211 != null) goto L99;
    L101:
        PointValuePair r119 = r38;
    L104:
        if (r110 != r15[r210[(int) ((((double) this.lambda) / 4.0d) + 0.1d)]]) goto L108;
        this.sigma *= FastMath.exp((this.cs / this.damps) + 0.2d);
    L108:
        if (this.iterations <= 2) goto L112;
        double r39 = r29;
        if ((FastMath.max(r117, r39) - FastMath.min(r36, r39)) != 0.0d) goto L113;
        this.sigma *= FastMath.exp((this.cs / this.damps) + 0.2d);
    L113:
        push(this.fitnessHistory, r39);
        if (this.generateStatistics == false) goto L116;
        this.statisticsSigmaHistory.add(Double.valueOf(this.sigma));
        this.statisticsFitnessHistory.add(Double.valueOf(r39));
        this.statisticsMeanHistory.add(this.xmean.transpose());
        this.statisticsDHistory.add(this.diagD.transpose().scalarMultiply(100000.0d));
    L116:
        this.iterations++;
        r9 = 1;
        r11 = r32;
        r14 = r119;
        r7 = r116;
        r12 = r110;
        r8 = 0;
        goto L8
    L112:
        r39 = r29;
        goto L113
    L99:
        if (getConvergenceChecker().converged(this.iterations, r38, r211) == false) goto L101;
    L95:
        r118 = -r29;
        goto L96
    L102:
        r119 = r211;
        goto L104
    L69:
        r116 = r7;
        r210 = r25;
        r211 = r113;
        goto L70
    L53:
        if (this.isMinimize == true) goto L57;
        r114 = -r114;
    L57:
        if (r29 >= r114) goto L59;
    L46:
        if (getConvergenceChecker().converged(this.iterations, r32, r22) == false) goto L48;
    L42:
        r112 = -r29;
        goto L43
    L49:
        r32 = r22;
        r113 = r14;
        goto L50
    L36:
        updateCovarianceDiagonalOnly(r28, r27);
        goto L37
    L117:
        r11 = r11;
        goto L119
    L5:
        r4 = -r2;
        goto L6
    }

    @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer, org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    protected void parseOptimizationData(OptimizationData... r5) {
        super.parseOptimizationData(r5);
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        OptimizationData r2 = r5[r1];
        if ((r2 instanceof Sigma) == false) goto L8;
        this.inputSigma = ((Sigma) r2).getSigma();
    L10:
        r1 = r1 + 1;
        goto L3
    L8:
        if ((r2 instanceof PopulationSize) == false) goto L10;
        this.lambda = ((PopulationSize) r2).getPopulationSize();
        goto L10
    L11:
        checkParameters();
    }

    private void checkParameters() {
        double[] r0 = getStartPoint();
        double[] r1 = getLowerBound();
        double[] r2 = getUpperBound();
        double[] r3 = this.inputSigma;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.length != r0.length) goto L15;
        int r4 = 0;
    L8:
        if (r4 >= r0.length) goto L19;
        if (this.inputSigma[r4] > (r2[r4] - r1[r4])) goto L13;
        r4 = r4 + 1;
        goto L8
    L13:
        throw new OutOfRangeException(Double.valueOf(this.inputSigma[r4]), 0, Double.valueOf(r2[r4] - r1[r4]));
    L19:
        return;
    L15:
        throw new DimensionMismatchException(this.inputSigma.length, r0.length);
    }

    private void initializeCMA(double[] r22) {
        if (this.lambda <= 0) goto L18;
        double[][] r2 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r22.length, 1});
        int r4 = 0;
    L6:
        if (r4 >= r22.length) goto L8;
        r2[r4][0] = this.inputSigma[r4];
        r4 = r4 + 1;
        goto L6
    L8:
        Array2DRowRealMatrix r5 = new Array2DRowRealMatrix(r2, false);
        this.sigma = max(r5);
        this.stopTolUpX = max(r5) * 1000.0d;
        this.stopTolX = max(r5) * 1.0E-11d;
        this.stopTolFun = 1.0E-12d;
        this.stopTolHistFun = 1.0E-13d;
        int r3 = this.lambda / 2;
        this.mu = r3;
        this.logMu2 = FastMath.log(((double) r3) + 0.5d);
        this.weights = log(sequence(1.0d, this.mu, 1.0d)).scalarMultiply(-1.0d).scalarAdd(this.logMu2);
        int r6 = 0;
        double r9 = 0.0d;
        double r11 = 0.0d;
    L10:
        if (r6 >= this.mu) goto L12;
        double r13 = this.weights.getEntry(r6, 0);
        r9 = r9 + r13;
        r11 = r11 + (r13 * r13);
        r6 = r6 + 1;
        goto L10
    L12:
        this.weights = this.weights.scalarMultiply(1.0d / r9);
        double r10 = (r9 * r9) / r11;
        this.mueff = r10;
        int r7 = this.dimension;
        this.cc = ((r10 / ((double) r7)) + 4.0d) / (((double) (r7 + 4)) + ((r10 * 2.0d) / ((double) r7)));
        this.cs = (r10 + 2.0d) / ((((double) r7) + r10) + 3.0d);
        this.damps = (((FastMath.max(0.0d, FastMath.sqrt((r10 - 1.0d) / ((double) (r7 + 1))) - 1.0d) * 2.0d) + 1.0d) * FastMath.max(0.3d, 1.0d - (((double) this.dimension) / (((double) this.maxIterations) + 1.0E-6d)))) + this.cs;
        int r8 = this.dimension;
        double r12 = this.mueff;
        double r14 = 2.0d / (((((double) r8) + 1.3d) * (((double) r8) + 1.3d)) + r12);
        this.ccov1 = r14;
        this.ccovmu = FastMath.min(1.0d - r14, (((r12 - 2.0d) + (1.0d / r12)) * 2.0d) / (((double) ((r8 + 2) * (r8 + 2))) + r12));
        this.ccov1Sep = FastMath.min(1.0d, (this.ccov1 * (((double) this.dimension) + 1.5d)) / 3.0d);
        this.ccovmuSep = FastMath.min(1.0d - this.ccov1, (this.ccovmu * (((double) this.dimension) + 1.5d)) / 3.0d);
        double r15 = FastMath.sqrt(this.dimension);
        int r16 = this.dimension;
        this.chiN = r15 * ((1.0d - (1.0d / (((double) r16) * 4.0d))) + (1.0d / ((((double) r16) * 21.0d) * ((double) r16))));
        this.xmean = MatrixUtils.createColumnRealMatrix(r22);
        RealMatrix r1 = r5.scalarMultiply(1.0d / this.sigma);
        this.diagD = r1;
        this.diagC = square(r1);
        this.pc = zeros(this.dimension, 1);
        RealMatrix r17 = zeros(this.dimension, 1);
        this.ps = r17;
        this.normps = r17.getFrobeniusNorm();
        int r18 = this.dimension;
        this.B = eye(r18, r18);
        this.D = ones(this.dimension, 1);
        this.BD = times(this.B, repmat(this.diagD.transpose(), this.dimension, 1));
        this.C = this.B.multiply(diag(square(this.D)).multiply(this.B.transpose()));
        int r19 = ((int) (((double) (this.dimension * 30)) / ((double) this.lambda))) + 10;
        this.historySize = r19;
        this.fitnessHistory = new double[r19];
        int r20 = 0;
    L14:
        if (r20 >= this.historySize) goto L16;
        this.fitnessHistory[r20] = Double.MAX_VALUE;
        r20 = r20 + 1;
        goto L14
    L16:
        return;
    L18:
        throw new NotStrictlyPositiveException(Integer.valueOf(this.lambda));
    }

    private boolean updateEvolutionPaths(RealMatrix r12, RealMatrix r13) {
        RealMatrix r0 = this.ps.scalarMultiply(1.0d - this.cs);
        RealMatrix r14 = this.B.multiply(r12);
        double r1 = this.cs;
        RealMatrix r15 = r0.add(r14.scalarMultiply(FastMath.sqrt((r1 * (2.0d - r1)) * this.mueff)));
        this.ps = r15;
        double r2 = r15.getFrobeniusNorm();
        this.normps = r2;
        if (((r2 / FastMath.sqrt(1.0d - FastMath.pow(1.0d - this.cs, this.iterations * 2))) / this.chiN) >= ((2.0d / (((double) this.dimension) + 1.0d)) + 1.4d)) goto L5;
        boolean r16 = true;
    L6:
        RealMatrix r3 = this.pc.scalarMultiply(1.0d - this.cc);
        this.pc = r3;
        if (r16 == false) goto L9;
        RealMatrix r17 = this.xmean.subtract(r13);
        double r4 = this.cc;
        this.pc = r3.add(r17.scalarMultiply(FastMath.sqrt((r4 * (2.0d - r4)) * this.mueff) / this.sigma));
    L9:
        return r16;
    L5:
        r16 = false;
        goto L6
    }

    private void updateCovarianceDiagonalOnly(boolean r7, RealMatrix r8) {
        if (r7 == false) goto L4;
        double r0 = 0.0d;
    L5:
        double r1 = r0 + ((1.0d - this.ccov1Sep) - this.ccovmuSep);
        RealMatrix r9 = this.diagC.scalarMultiply(r1).add(square(this.pc).scalarMultiply(this.ccov1Sep)).add(times(this.diagC, square(r8).multiply(this.weights)).scalarMultiply(this.ccovmuSep));
        this.diagC = r9;
        this.diagD = sqrt(r9);
        int r10 = this.diagonalOnly;
        if (r10 > 1) goto L8;
        return;
    L8:
        if (this.iterations <= r10) goto L12;
        this.diagonalOnly = 0;
        int r11 = this.dimension;
        this.B = eye(r11, r11);
        this.BD = diag(this.diagD);
        this.C = diag(this.diagC);
        return;
    L12:
        return;
    L4:
        double r2 = this.ccov1Sep;
        double r3 = this.cc;
        r0 = (r2 * r3) * (2.0d - r3);
        goto L5
    }

    private void updateCovariance(boolean r16, RealMatrix r17, RealMatrix r18, int[] r19, RealMatrix r20) {
        if ((this.ccov1 + this.ccovmu) <= 0.0d) goto L16;
        RealMatrix r1 = r17.subtract(repmat(r20, 1, this.mu)).scalarMultiply(1.0d / this.sigma);
        RealMatrix r5 = this.pc;
        RealMatrix r6 = r5.multiply(r5.transpose()).scalarMultiply(this.ccov1);
        if (r16 == false) goto L7;
        double r11 = 0.0d;
    L8:
        double r13 = 1.0d - this.ccov1;
        double r3 = this.ccovmu;
        double r12 = r11 + (r13 - r3);
        if (this.isActiveCMA == false) goto L15;
        double r7 = (((1.0d - r3) * 0.25d) * this.mueff) / (FastMath.pow(this.dimension + 2, 1.5d) + (this.mueff * 2.0d));
        RealMatrix r4 = selectColumns(r18, MathArrays.copyOf(reverse(r19), this.mu));
        RealMatrix r8 = sqrt(sumRows(square(r4)));
        int[] r9 = sortedIndices(r8.getRow(0));
        RealMatrix r10 = selectColumns(divide(selectColumns(r8, reverse(r9)), selectColumns(r8, r9)), inverse(r9));
        double r14 = 0.33999999999999997d / square(r10).multiply(this.weights).getEntry(0, 0);
        if (r7 > r14) goto L14;
        r14 = r7;
    L14:
        RealMatrix r15 = this.BD.multiply(times(r4, repmat(r10, this.dimension, 1)));
        RealMatrix r21 = r15.multiply(diag(this.weights)).multiply(r15.transpose());
        double r22 = 0.5d * r14;
        this.C = this.C.scalarMultiply(r12 + r22).add(r6).add(r1.scalarMultiply(this.ccovmu + r22).multiply(times(repmat(this.weights, 1, this.dimension), r1.transpose()))).subtract(r21.scalarMultiply(r14));
        double r23 = r14;
    L17:
        updateBD(r23);
        return;
    L15:
        this.C = this.C.scalarMultiply(r12).add(r6).add(r1.scalarMultiply(this.ccovmu).multiply(times(repmat(this.weights, 1, this.dimension), r1.transpose())));
        goto L16
    L7:
        double r110 = this.ccov1;
        double r111 = this.cc;
        r11 = (r110 * r111) * (2.0d - r111);
    L16:
        r23 = 0.0d;
        goto L17
    }

    private void updateBD(double r11) {
        double r0 = this.ccov1;
        double r2 = this.ccovmu;
        if (((r0 + r2) + r11) > 0.0d) goto L5;
        return;
    L5:
        if (((((((double) this.iterations) % 1.0d) / ((r0 + r2) + r11)) / ((double) this.dimension)) / 10.0d) >= 1.0d) goto L25;
        this.C = triu(this.C, 0).add(triu(this.C, 1).transpose());
        EigenDecomposition r12 = new EigenDecomposition(this.C);
        this.B = r12.getV();
        RealMatrix r13 = r12.getD();
        this.D = r13;
        RealMatrix r14 = diag(r13);
        this.diagD = r14;
        if (min(r14) > 0.0d) goto L17;
        int r15 = 0;
    L10:
        if (r15 >= this.dimension) goto L15;
        if (this.diagD.getEntry(r15, 0) >= 0.0d) goto L14;
        this.diagD.setEntry(r15, 0, 0.0d);
    L14:
        r15 = r15 + 1;
        goto L10
    L15:
        double r16 = max(this.diagD) / 1.0E14d;
        RealMatrix r1 = this.C;
        int r4 = this.dimension;
        this.C = r1.add(eye(r4, r4).scalarMultiply(r16));
        this.diagD = this.diagD.add(ones(this.dimension, 1).scalarMultiply(r16));
    L17:
        if (max(this.diagD) <= (min(this.diagD) * 1.0E14d)) goto L19;
        double r17 = (max(this.diagD) / 1.0E14d) - min(this.diagD);
        RealMatrix r3 = this.C;
        int r5 = this.dimension;
        this.C = r3.add(eye(r5, r5).scalarMultiply(r17));
        this.diagD = this.diagD.add(ones(this.dimension, 1).scalarMultiply(r17));
    L19:
        this.diagC = diag(this.C);
        RealMatrix r18 = sqrt(this.diagD);
        this.diagD = r18;
        this.BD = times(this.B, repmat(r18.transpose(), this.dimension, 1));
        return;
    }

    private static void push(double[] r3, double r4) {
        int r0 = r3.length - 1;
    L3:
        if (r0 <= 0) goto L5;
        r3[r0] = r3[r0 - 1];
        r0 = r0 - 1;
        goto L3
    L5:
        r3[0] = r4;
    }

    private int[] sortedIndices(double[] r6) {
        DoubleIndex[] r5 = new DoubleIndex[r6.length];
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L6;
        r5[r1] = new DoubleIndex(r6[r1], r1);
        r1 = r1 + 1;
        goto L4
    L6:
        Arrays.sort(r5);
        int[] r2 = new int[r6.length];
    L8:
        if (r0 >= r6.length) goto L10;
        r2[r0] = DoubleIndex.access$300(r5[r0]);
        r0 = r0 + 1;
        goto L8
    L10:
        return r2;
    }

    private double valueRange(ValuePenaltyPair[] r9) {
        int r8 = r9.length;
        double r0 = Double.NEGATIVE_INFINITY;
        double r2 = Double.MAX_VALUE;
        int r4 = 0;
    L3:
        if (r4 >= r8) goto L12;
        ValuePenaltyPair r5 = r9[r4];
        if (ValuePenaltyPair.access$000(r5) <= r0) goto L8;
        r0 = ValuePenaltyPair.access$000(r5);
    L8:
        if (ValuePenaltyPair.access$000(r5) >= r2) goto L10;
        r2 = ValuePenaltyPair.access$000(r5);
    L10:
        r4 = r4 + 1;
        goto L3
    L12:
        return r0 - r2;
    }

    private static RealMatrix log(RealMatrix r7) {
        double[][] r0 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r7.getRowDimension(), r7.getColumnDimension()});
        int r2 = 0;
    L4:
        if (r2 >= r7.getRowDimension()) goto L11;
        int r3 = 0;
    L7:
        if (r3 >= r7.getColumnDimension()) goto L9;
        r0[r2][r3] = FastMath.log(r7.getEntry(r2, r3));
        r3 = r3 + 1;
        goto L7
    L9:
        r2 = r2 + 1;
        goto L4
    L11:
        return new Array2DRowRealMatrix(r0, false);
    }

    private static RealMatrix sqrt(RealMatrix r7) {
        double[][] r0 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r7.getRowDimension(), r7.getColumnDimension()});
        int r2 = 0;
    L4:
        if (r2 >= r7.getRowDimension()) goto L11;
        int r3 = 0;
    L7:
        if (r3 >= r7.getColumnDimension()) goto L9;
        r0[r2][r3] = FastMath.sqrt(r7.getEntry(r2, r3));
        r3 = r3 + 1;
        goto L7
    L9:
        r2 = r2 + 1;
        goto L4
    L11:
        return new Array2DRowRealMatrix(r0, false);
    }

    private static RealMatrix square(RealMatrix r7) {
        double[][] r0 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r7.getRowDimension(), r7.getColumnDimension()});
        int r2 = 0;
    L4:
        if (r2 >= r7.getRowDimension()) goto L11;
        int r3 = 0;
    L7:
        if (r3 >= r7.getColumnDimension()) goto L9;
        double r4 = r7.getEntry(r2, r3);
        r0[r2][r3] = r4 * r4;
        r3 = r3 + 1;
        goto L7
    L9:
        r2 = r2 + 1;
        goto L4
    L11:
        return new Array2DRowRealMatrix(r0, false);
    }

    private static RealMatrix times(RealMatrix r9, RealMatrix r10) {
        double[][] r0 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r9.getRowDimension(), r9.getColumnDimension()});
        int r2 = 0;
    L4:
        if (r2 >= r9.getRowDimension()) goto L11;
        int r3 = 0;
    L7:
        if (r3 >= r9.getColumnDimension()) goto L9;
        r0[r2][r3] = r9.getEntry(r2, r3) * r10.getEntry(r2, r3);
        r3 = r3 + 1;
        goto L7
    L9:
        r2 = r2 + 1;
        goto L4
    L11:
        return new Array2DRowRealMatrix(r0, false);
    }

    private static RealMatrix divide(RealMatrix r9, RealMatrix r10) {
        double[][] r0 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r9.getRowDimension(), r9.getColumnDimension()});
        int r2 = 0;
    L4:
        if (r2 >= r9.getRowDimension()) goto L11;
        int r3 = 0;
    L7:
        if (r3 >= r9.getColumnDimension()) goto L9;
        r0[r2][r3] = r9.getEntry(r2, r3) / r10.getEntry(r2, r3);
        r3 = r3 + 1;
        goto L7
    L9:
        r2 = r2 + 1;
        goto L4
    L11:
        return new Array2DRowRealMatrix(r0, false);
    }

    private static RealMatrix selectColumns(RealMatrix r7, int[] r8) {
        double[][] r0 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r7.getRowDimension(), r8.length});
        int r2 = 0;
    L4:
        if (r2 >= r7.getRowDimension()) goto L11;
        int r3 = 0;
    L7:
        if (r3 >= r8.length) goto L9;
        r0[r2][r3] = r7.getEntry(r2, r8[r3]);
        r3 = r3 + 1;
        goto L7
    L9:
        r2 = r2 + 1;
        goto L4
    L11:
        return new Array2DRowRealMatrix(r0, false);
    }

    private static RealMatrix triu(RealMatrix r7, int r8) {
        double[][] r0 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r7.getRowDimension(), r7.getColumnDimension()});
        int r2 = 0;
    L4:
        if (r2 >= r7.getRowDimension()) goto L15;
        int r3 = 0;
    L7:
        if (r3 >= r7.getColumnDimension()) goto L13;
        double[] r4 = r0[r2];
        if (r2 > (r3 - r8)) goto L11;
        double r5 = r7.getEntry(r2, r3);
    L12:
        r4[r3] = r5;
        r3 = r3 + 1;
        goto L7
    L11:
        r5 = 0.0d;
        goto L12
    L13:
        r2 = r2 + 1;
        goto L4
    L15:
        return new Array2DRowRealMatrix(r0, false);
    }

    private static RealMatrix sumRows(RealMatrix r8) {
        double[][] r1 = (double[][]) Array.newInstance(Double.TYPE, new int[]{1, r8.getColumnDimension()});
        int r2 = 0;
    L4:
        if (r2 >= r8.getColumnDimension()) goto L11;
        double r3 = 0.0d;
        int r5 = 0;
    L7:
        if (r5 >= r8.getRowDimension()) goto L9;
        r3 = r3 + r8.getEntry(r5, r2);
        r5 = r5 + 1;
        goto L7
    L9:
        r1[0][r2] = r3;
        r2 = r2 + 1;
        goto L4
    L11:
        return new Array2DRowRealMatrix(r1, false);
    }

    private static RealMatrix diag(RealMatrix r6) {
        if (r6.getColumnDimension() != 1) goto L10;
        double[][] r0 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r6.getRowDimension(), r6.getRowDimension()});
        int r1 = 0;
    L6:
        if (r1 >= r6.getRowDimension()) goto L9;
        r0[r1][r1] = r6.getEntry(r1, 0);
        r1 = r1 + 1;
        goto L6
    L9:
        return new Array2DRowRealMatrix(r0, false);
    L10:
        double[][] r2 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r6.getRowDimension(), 1});
        int r3 = 0;
    L12:
        if (r3 >= r6.getColumnDimension()) goto L15;
        r2[r3][0] = r6.getEntry(r3, r3);
        r3 = r3 + 1;
        goto L12
    L15:
        return new Array2DRowRealMatrix(r2, false);
    }

    private static void copyColumn(RealMatrix r3, int r4, RealMatrix r5, int r6) {
        int r0 = 0;
    L4:
        if (r0 >= r3.getRowDimension()) goto L6;
        r5.setEntry(r0, r6, r3.getEntry(r0, r4));
        r0 = r0 + 1;
        goto L4
    }

    private static RealMatrix ones(int r5, int r6) {
        double[][] r0 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r5, r6});
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L6;
        Arrays.fill(r0[r1], 1.0d);
        r1 = r1 + 1;
        goto L3
    L6:
        return new Array2DRowRealMatrix(r0, false);
    }

    private static RealMatrix eye(int r6, int r7) {
        double[][] r0 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r6, r7});
        int r2 = 0;
    L3:
        if (r2 >= r6) goto L8;
        if (r2 >= r7) goto L6;
        r0[r2][r2] = 1.0d;
    L6:
        r2 = r2 + 1;
        goto L3
    L8:
        return new Array2DRowRealMatrix(r0, false);
    }

    private static RealMatrix zeros(int r1, int r2) {
        return new Array2DRowRealMatrix(r1, r2);
    }

    private static RealMatrix repmat(RealMatrix r9, int r10, int r11) {
        int r0 = r9.getRowDimension();
        int r1 = r9.getColumnDimension();
        int r12 = r10 * r0;
        int r13 = r11 * r1;
        double[][] r2 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r12, r13});
        int r4 = 0;
    L3:
        if (r4 >= r12) goto L9;
        int r5 = 0;
    L5:
        if (r5 >= r13) goto L7;
        r2[r4][r5] = r9.getEntry(r4 % r0, r5 % r1);
        r5 = r5 + 1;
        goto L5
    L7:
        r4 = r4 + 1;
        goto L3
    L9:
        return new Array2DRowRealMatrix(r2, false);
    }

    private static RealMatrix sequence(double r3, double r5, double r7) {
        int r6 = (int) (((r5 - r3) / r7) + 1.0d);
        double[][] r8 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r6, 1});
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L6;
        r8[r1][0] = r3;
        r3 = r3 + r7;
        r1 = r1 + 1;
        goto L3
    L6:
        return new Array2DRowRealMatrix(r8, false);
    }

    private static double max(RealMatrix r8) {
        double r0 = -1.7976931348623157E308d;
        int r3 = 0;
    L4:
        if (r3 >= r8.getRowDimension()) goto L13;
        int r4 = 0;
    L7:
        if (r4 >= r8.getColumnDimension()) goto L12;
        double r5 = r8.getEntry(r3, r4);
        if (r0 >= r5) goto L11;
        r0 = r5;
    L11:
        r4 = r4 + 1;
        goto L7
    L12:
        r3 = r3 + 1;
        goto L4
    L13:
        return r0;
    }

    private static double min(RealMatrix r8) {
        double r0 = Double.MAX_VALUE;
        int r3 = 0;
    L4:
        if (r3 >= r8.getRowDimension()) goto L13;
        int r4 = 0;
    L7:
        if (r4 >= r8.getColumnDimension()) goto L12;
        double r5 = r8.getEntry(r3, r4);
        if (r0 <= r5) goto L11;
        r0 = r5;
    L11:
        r4 = r4 + 1;
        goto L7
    L12:
        r3 = r3 + 1;
        goto L4
    L13:
        return r0;
    }

    private static double max(double[] r6) {
        double r0 = -1.7976931348623157E308d;
        int r2 = 0;
    L4:
        if (r2 >= r6.length) goto L9;
        double r3 = r6[r2];
        if (r0 >= r3) goto L8;
        r0 = r3;
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        return r0;
    }

    private static double min(double[] r6) {
        double r0 = Double.MAX_VALUE;
        int r2 = 0;
    L4:
        if (r2 >= r6.length) goto L9;
        double r3 = r6[r2];
        if (r0 <= r3) goto L8;
        r0 = r3;
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        return r0;
    }

    private static int[] inverse(int[] r3) {
        int[] r0 = new int[r3.length];
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L6;
        r0[r3[r1]] = r1;
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    private static int[] reverse(int[] r3) {
        int[] r0 = new int[r3.length];
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L6;
        r0[r1] = r3[(r3.length - r1) - 1];
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    private double[] randn(int r5) {
        double[] r0 = new double[r5];
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L5;
        r0[r1] = this.random.nextGaussian();
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    private RealMatrix randn1(int r8, int r9) {
        double[][] r0 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r8, r9});
        int r2 = 0;
    L3:
        if (r2 >= r8) goto L9;
        int r3 = 0;
    L5:
        if (r3 >= r9) goto L7;
        r0[r2][r3] = this.random.nextGaussian();
        r3 = r3 + 1;
        goto L5
    L7:
        r2 = r2 + 1;
        goto L3
    L9:
        return new Array2DRowRealMatrix(r0, false);
    }
}
