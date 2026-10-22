package org.apache.commons.math3.linear;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.ExceptionContext;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.IterationManager;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class SymmLQ extends PreconditionedIterativeLinearSolver {
    private static final String OPERATOR = "operator";
    private static final String THRESHOLD = "threshold";
    private static final String VECTOR = "vector";
    private static final String VECTOR1 = "vector1";
    private static final String VECTOR2 = "vector2";
    private final boolean check;
    private final double delta;

    private static class State {
        static final double CBRT_MACH_PREC = 0.0d;
        static final double MACH_PREC = 0.0d;
        private final RealLinearOperator a;
        private final RealVector b;
        private boolean bIsNull;
        private double beta;
        private double beta1;
        private double bstep;
        private double cgnorm;
        private final boolean check;
        private double dbar;
        private final double delta;
        private double gammaZeta;
        private double gbar;
        private double gmax;
        private double gmin;
        private final boolean goodb;
        private boolean hasConverged;
        private double lqnorm;
        private final RealLinearOperator m;
        private final RealVector mb;
        private double minusEpsZeta;
        private double oldb;
        private RealVector r1;
        private RealVector r2;
        private double rnorm;
        private final double shift;
        private double snprod;
        private double tnorm;
        private RealVector wbar;
        private final RealVector xL;
        private RealVector y;
        private double ynorm2;

        static {
            double r0 = FastMath.ulp(1.0d);
            MACH_PREC = r0;
            CBRT_MACH_PREC = FastMath.cbrt(r0);
        }

        State(RealLinearOperator r2, RealLinearOperator r3, RealVector r4, boolean r5, double r6, double r8, boolean r10) {
            this.a = r2;
            this.m = r3;
            this.b = r4;
            this.xL = new ArrayRealVector(r4.getDimension());
            this.goodb = r5;
            this.shift = r6;
            if (r3 == null) goto L6;
            r4 = r3.operate(r4);
        L6:
            this.mb = r4;
            this.hasConverged = false;
            this.check = r10;
            this.delta = r8;
        }

        private static void checkSymmetry(RealLinearOperator r8, RealVector r9, RealVector r10, RealVector r11) throws NonSelfAdjointOperatorException {
            double r0 = r10.dotProduct(r10);
            double r2 = r9.dotProduct(r11);
            double r4 = (MACH_PREC + r0) * CBRT_MACH_PREC;
            if (FastMath.abs(r0 - r2) > r4) goto L5;
            return;
        L5:
            NonSelfAdjointOperatorException r12 = new NonSelfAdjointOperatorException();
            ExceptionContext r1 = r12.getContext();
            r1.setValue("operator", r8);
            r1.setValue(SymmLQ.VECTOR1, r9);
            r1.setValue(SymmLQ.VECTOR2, r10);
            r1.setValue(SymmLQ.THRESHOLD, Double.valueOf(r4));
            throw r12;
        }

        private static void throwNPDLOException(RealLinearOperator r3, RealVector r4) throws NonPositiveDefiniteOperatorException {
            NonPositiveDefiniteOperatorException r0 = new NonPositiveDefiniteOperatorException();
            ExceptionContext r1 = r0.getContext();
            r1.setValue("operator", r3);
            r1.setValue("vector", r4);
            throw r0;
        }

        private static void daxpy(double r6, RealVector r8, RealVector r9) {
            int r0 = r8.getDimension();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r9.setEntry(r1, (r8.getEntry(r1) * r6) + r9.getEntry(r1));
            r1 = r1 + 1;
            goto L3
        }

        private static void daxpbypz(double r6, RealVector r8, double r9, RealVector r11, RealVector r12) {
            int r0 = r12.getDimension();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r12.setEntry(r1, ((r8.getEntry(r1) * r6) + (r11.getEntry(r1) * r9)) + r12.getEntry(r1));
            r1 = r1 + 1;
            goto L3
        }

        void refineSolution(RealVector r14) {
            int r0 = this.xL.getDimension();
            int r2 = 0;
            if (this.lqnorm < this.cgnorm) goto L5;
            double r3 = FastMath.sqrt(this.tnorm);
            double r5 = this.gbar;
            if (r5 != 0.0d) goto L13;
            r5 = MACH_PREC * r3;
        L13:
            double r4 = this.gammaZeta / r5;
            double r6 = (this.bstep + (this.snprod * r4)) / this.beta1;
            if (this.goodb == true) goto L17;
        L15:
            if (r2 >= r0) goto L24;
            r14.setEntry(r2, this.xL.getEntry(r2) + (this.wbar.getEntry(r2) * r4));
            r2 = r2 + 1;
            goto L15
        L24:
            return;
        L17:
            if (r2 >= r0) goto L25;
            double r7 = this.xL.getEntry(r2);
            double r9 = this.wbar.getEntry(r2);
            r14.setEntry(r2, (r7 + (r9 * r4)) + (this.mb.getEntry(r2) * r6));
            r2 = r2 + 1;
            goto L17
        L25:
            return;
        L5:
            if (this.goodb == true) goto L7;
            r14.setSubVector(0, this.xL);
            return;
        L7:
            double r8 = this.bstep / this.beta1;
        L8:
            if (r2 >= r0) goto L23;
            double r10 = this.mb.getEntry(r2);
            r14.setEntry(r2, this.xL.getEntry(r2) + (r10 * r8));
            r2 = r2 + 1;
            goto L8
        }

        void init() {
            this.xL.set(0.0d);
            RealVector r0 = this.b.copy();
            this.r1 = r0;
            RealLinearOperator r3 = this.m;
            if (r3 != null) goto L5;
            RealVector r1 = this.b.copy();
        L6:
            this.y = r1;
            RealLinearOperator r4 = this.m;
            if (r4 != null) goto L9;
        L11:
            double r5 = this.r1.dotProduct(this.y);
            this.beta1 = r5;
            if (r5 >= 0.0d) goto L14;
            throwNPDLOException(this.m, this.y);
        L14:
            double r6 = this.beta1;
            if (r6 != 0.0d) goto L18;
            this.bIsNull = true;
            return;
        L18:
            this.bIsNull = false;
            double r7 = FastMath.sqrt(r6);
            this.beta1 = r7;
            RealVector r2 = this.y.mapMultiply(1.0d / r7);
            RealVector r8 = this.a.operate(r2);
            this.y = r8;
            if (this.check == false) goto L21;
            RealLinearOperator r9 = this.a;
            checkSymmetry(r9, r2, r8, r9.operate(r8));
        L21:
            daxpy(-this.shift, r2, this.y);
            double r10 = r2.dotProduct(this.y);
            daxpy((-r10) / this.beta1, this.r1, this.y);
            double r11 = r2.dotProduct(this.y);
            double r12 = -r11;
            daxpy(r12 / r2.dotProduct(r2), r2, this.y);
            RealVector r13 = this.y.copy();
            this.r2 = r13;
            RealLinearOperator r14 = this.m;
            if (r14 == null) goto L24;
            this.y = r14.operate(r13);
        L24:
            this.oldb = this.beta1;
            double r15 = this.r2.dotProduct(this.y);
            this.beta = r15;
            if (r15 >= 0.0d) goto L27;
            throwNPDLOException(this.m, this.y);
        L27:
            double r16 = FastMath.sqrt(this.beta);
            this.beta = r16;
            double r17 = this.beta1;
            this.cgnorm = r17;
            this.gbar = r10;
            this.dbar = r16;
            this.gammaZeta = r17;
            this.minusEpsZeta = 0.0d;
            this.bstep = 0.0d;
            this.snprod = 1.0d;
            this.tnorm = (r10 * r10) + (r16 * r16);
            this.ynorm2 = 0.0d;
            double r18 = FastMath.abs(r10) + MACH_PREC;
            this.gmax = r18;
            this.gmin = r18;
            if (this.goodb == false) goto L30;
            ArrayRealVector r19 = new ArrayRealVector(this.a.getRowDimension());
            this.wbar = r19;
            r19.set(0.0d);
        L31:
            updateNorms();
            return;
        L30:
            this.wbar = r2;
            goto L31
        L9:
            if (this.check == false) goto L11;
            checkSymmetry(r4, this.r1, r1, r4.operate(r1));
            goto L11
        L5:
            r1 = r3.operate(r0);
            goto L6
        }

        void update() {
            RealVector r1 = this.y.mapMultiply(1.0d / this.beta);
            RealVector r10 = this.a.operate(r1);
            this.y = r10;
            daxpbypz(-this.shift, r1, (-this.beta) / this.oldb, this.r1, r10);
            double r2 = r1.dotProduct(this.y);
            daxpy((-r2) / this.beta, this.r2, this.y);
            this.r1 = this.r2;
            RealVector r4 = this.y;
            this.r2 = r4;
            RealLinearOperator r5 = this.m;
            if (r5 == null) goto L5;
            this.y = r5.operate(r4);
        L5:
            this.oldb = this.beta;
            double r6 = this.r2.dotProduct(this.y);
            this.beta = r6;
            if (r6 >= 0.0d) goto L8;
            throwNPDLOException(this.m, this.y);
        L8:
            double r7 = FastMath.sqrt(this.beta);
            this.beta = r7;
            double r8 = this.tnorm;
            double r11 = this.oldb;
            this.tnorm = r8 + (((r2 * r2) + (r11 * r11)) + (r7 * r7));
            double r9 = this.gbar;
            double r12 = FastMath.sqrt((r9 * r9) + (r11 * r11));
            double r13 = this.gbar / r12;
            double r14 = this.oldb / r12;
            double r15 = this.dbar;
            double r16 = (r13 * r15) + (r14 * r2);
            this.gbar = (r15 * r14) - (r2 * r13);
            double r3 = this.beta;
            double r17 = r14 * r3;
            this.dbar = (-r13) * r3;
            double r18 = this.gammaZeta / r12;
            double r19 = r18 * r13;
            double r110 = r18 * r14;
            int r111 = this.xL.getDimension();
            int r112 = 0;
        L9:
            if (r112 >= r111) goto L11;
            double r21 = this.xL.getEntry(r112);
            double r23 = r1.getEntry(r112);
            double r25 = this.wbar.getEntry(r112);
            this.xL.setEntry(r112, (r21 + (r25 * r19)) + (r23 * r110));
            this.wbar.setEntry(r112, (r25 * r14) - (r23 * r13));
            r112 = r112 + 1;
            r111 = r111;
            r19 = r19;
            goto L9
        L11:
            double r113 = this.bstep;
            double r114 = this.snprod;
            this.bstep = r113 + ((r13 * r114) * r18);
            this.snprod = r114 * r14;
            this.gmax = FastMath.max(this.gmax, r12);
            this.gmin = FastMath.min(this.gmin, r12);
            this.ynorm2 += r18 * r18;
            this.gammaZeta = this.minusEpsZeta - (r16 * r18);
            this.minusEpsZeta = (-r17) * r18;
            updateNorms();
        }

        private void updateNorms() {
            double r0 = FastMath.sqrt(this.tnorm);
            double r2 = FastMath.sqrt(this.ynorm2);
            double r4 = MACH_PREC;
            double r6 = r0 * r4;
            double r1 = r0 * r2;
            double r3 = r1 * r4;
            double r5 = r1 * this.delta;
            double r8 = this.gbar;
            if (r8 == 0.0d) goto L6;
            r6 = r8;
        L6:
            double r9 = this.gammaZeta;
            double r10 = this.minusEpsZeta;
            this.lqnorm = FastMath.sqrt((r9 * r9) + (r10 * r10));
            double r11 = ((this.snprod * this.beta1) * this.beta) / FastMath.abs(r6);
            this.cgnorm = r11;
            if (this.lqnorm > r11) goto L9;
            double r7 = this.gmax / this.gmin;
        L11:
            if ((r4 * r7) >= 0.1d) goto L26;
            if (this.beta1 <= r3) goto L24;
            this.rnorm = FastMath.min(this.cgnorm, this.lqnorm);
            double r12 = this.cgnorm;
            if (r12 > r3) goto L17;
        L20:
            boolean r13 = true;
        L21:
            this.hasConverged = r13;
            return;
        L17:
            if (r12 <= r5) goto L20;
            r13 = false;
            goto L21
        L24:
            throw new SingularOperatorException();
        L26:
            throw new IllConditionedOperatorException(r7);
        L9:
            r7 = this.gmax / FastMath.min(this.gmin, FastMath.abs(r6));
            goto L11
        }

        boolean hasConverged() {
            return this.hasConverged;
        }

        boolean bEqualsNullVector() {
            return this.bIsNull;
        }

        boolean betaEqualsZero() {
            if (this.beta >= MACH_PREC) goto L5;
            return true;
        L5:
            return false;
        }

        double getNormOfResidual() {
            return this.rnorm;
        }
    }

    public SymmLQ(int r1, double r2, boolean r4) {
        super(r1);
        this.delta = r2;
        this.check = r4;
    }

    public SymmLQ(IterationManager r1, double r2, boolean r4) {
        super(r1);
        this.delta = r2;
        this.check = r4;
    }

    public final boolean getCheck() {
        return this.check;
    }

    @Override // org.apache.commons.math3.linear.PreconditionedIterativeLinearSolver
    public RealVector solve(RealLinearOperator r9, RealLinearOperator r10, RealVector r11) throws NullArgumentException, NonSquareOperatorException, DimensionMismatchException, MaxCountExceededException, NonSelfAdjointOperatorException, NonPositiveDefiniteOperatorException, IllConditionedOperatorException {
        MathUtils.checkNotNull(r9);
        return solveInPlace(r9, r10, r11, new ArrayRealVector(r9.getColumnDimension()), false, 0.0d);
    }

    public RealVector solve(RealLinearOperator r9, RealLinearOperator r10, RealVector r11, boolean r12, double r13) throws NullArgumentException, NonSquareOperatorException, DimensionMismatchException, MaxCountExceededException, NonSelfAdjointOperatorException, NonPositiveDefiniteOperatorException, IllConditionedOperatorException {
        MathUtils.checkNotNull(r9);
        return solveInPlace(r9, r10, r11, new ArrayRealVector(r9.getColumnDimension()), r12, r13);
    }

    @Override // org.apache.commons.math3.linear.PreconditionedIterativeLinearSolver
    public RealVector solve(RealLinearOperator r9, RealLinearOperator r10, RealVector r11, RealVector r12) throws NullArgumentException, NonSquareOperatorException, DimensionMismatchException, NonSelfAdjointOperatorException, NonPositiveDefiniteOperatorException, IllConditionedOperatorException, MaxCountExceededException {
        MathUtils.checkNotNull(r12);
        return solveInPlace(r9, r10, r11, r12.copy(), false, 0.0d);
    }

    @Override // org.apache.commons.math3.linear.PreconditionedIterativeLinearSolver, org.apache.commons.math3.linear.IterativeLinearSolver
    public RealVector solve(RealLinearOperator r9, RealVector r10) throws NullArgumentException, NonSquareOperatorException, DimensionMismatchException, NonSelfAdjointOperatorException, IllConditionedOperatorException, MaxCountExceededException {
        MathUtils.checkNotNull(r9);
        ArrayRealVector r4 = new ArrayRealVector(r9.getColumnDimension());
        r4.set(0.0d);
        return solveInPlace(r9, null, r10, r4, false, 0.0d);
    }

    public RealVector solve(RealLinearOperator r9, RealVector r10, boolean r11, double r12) throws NullArgumentException, NonSquareOperatorException, DimensionMismatchException, NonSelfAdjointOperatorException, IllConditionedOperatorException, MaxCountExceededException {
        MathUtils.checkNotNull(r9);
        return solveInPlace(r9, null, r10, new ArrayRealVector(r9.getColumnDimension()), r11, r12);
    }

    @Override // org.apache.commons.math3.linear.PreconditionedIterativeLinearSolver, org.apache.commons.math3.linear.IterativeLinearSolver
    public RealVector solve(RealLinearOperator r9, RealVector r10, RealVector r11) throws NullArgumentException, NonSquareOperatorException, DimensionMismatchException, NonSelfAdjointOperatorException, IllConditionedOperatorException, MaxCountExceededException {
        MathUtils.checkNotNull(r11);
        return solveInPlace(r9, null, r10, r11.copy(), false, 0.0d);
    }

    @Override // org.apache.commons.math3.linear.PreconditionedIterativeLinearSolver
    public RealVector solveInPlace(RealLinearOperator r9, RealLinearOperator r10, RealVector r11, RealVector r12) throws NullArgumentException, NonSquareOperatorException, DimensionMismatchException, NonSelfAdjointOperatorException, NonPositiveDefiniteOperatorException, IllConditionedOperatorException, MaxCountExceededException {
        return solveInPlace(r9, r10, r11, r12, false, 0.0d);
    }

    public RealVector solveInPlace(RealLinearOperator r21, RealLinearOperator r22, RealVector r23, RealVector r24, boolean r25, double r26) throws NullArgumentException, NonSquareOperatorException, DimensionMismatchException, NonSelfAdjointOperatorException, NonPositiveDefiniteOperatorException, IllConditionedOperatorException, MaxCountExceededException {
        checkParameters(r21, r22, r23, r24);
        IterationManager r9 = getIterationManager();
        r9.resetIterationCount();
        r9.incrementIterationCount();
        State r5 = new State(r21, r22, r23, r25, r26, this.delta, this.check);
        r5.init();
        r5.refineSolution(r24);
        DefaultIterativeLinearSolverEvent r10 = new DefaultIterativeLinearSolverEvent(this, r9.getIterations(), r24, r23, r5.getNormOfResidual());
        if (r5.bEqualsNullVector() == false) goto L7;
        r9.fireTerminationEvent(r10);
        return r24;
    L7:
        if (r5.betaEqualsZero() == false) goto L9;
    L12:
        boolean r0 = true;
    L13:
        r9.fireInitializationEvent(r10);
        if (r0 == true) goto L17;
    L15:
        r9.incrementIterationCount();
        r9.fireIterationStartedEvent(new DefaultIterativeLinearSolverEvent(this, r9.getIterations(), r24, r23, r5.getNormOfResidual()));
        r5.update();
        r5.refineSolution(r24);
        r9.fireIterationPerformedEvent(new DefaultIterativeLinearSolverEvent(this, r9.getIterations(), r24, r23, r5.getNormOfResidual()));
        if (r5.hasConverged() == false) goto L15;
    L17:
        r9.fireTerminationEvent(new DefaultIterativeLinearSolverEvent(this, r9.getIterations(), r24, r23, r5.getNormOfResidual()));
        return r24;
    L9:
        if (r5.hasConverged() == true) goto L12;
        r0 = false;
        goto L13
    }

    @Override // org.apache.commons.math3.linear.PreconditionedIterativeLinearSolver, org.apache.commons.math3.linear.IterativeLinearSolver
    public RealVector solveInPlace(RealLinearOperator r9, RealVector r10, RealVector r11) throws NullArgumentException, NonSquareOperatorException, DimensionMismatchException, NonSelfAdjointOperatorException, IllConditionedOperatorException, MaxCountExceededException {
        return solveInPlace(r9, null, r10, r11, false, 0.0d);
    }
}
