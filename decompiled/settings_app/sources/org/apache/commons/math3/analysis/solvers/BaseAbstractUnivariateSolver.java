package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.IntegerSequence;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class BaseAbstractUnivariateSolver<FUNC extends UnivariateFunction> implements BaseUnivariateSolver<FUNC> {
    private static final double DEFAULT_FUNCTION_VALUE_ACCURACY = 1.0E-15d;
    private static final double DEFAULT_RELATIVE_ACCURACY = 1.0E-14d;
    private final double absoluteAccuracy;
    private IntegerSequence.Incrementor evaluations;
    private FUNC function;
    private final double functionValueAccuracy;
    private final double relativeAccuracy;
    private double searchMax;
    private double searchMin;
    private double searchStart;

    protected abstract double doSolve() throws TooManyEvaluationsException, NoBracketingException;

    protected BaseAbstractUnivariateSolver(double r8) {
        this(DEFAULT_RELATIVE_ACCURACY, r8, 1.0E-15d);
    }

    protected BaseAbstractUnivariateSolver(double r8, double r10) {
        this(r8, r10, 1.0E-15d);
    }

    protected BaseAbstractUnivariateSolver(double r1, double r3, double r5) {
        this.absoluteAccuracy = r3;
        this.relativeAccuracy = r1;
        this.functionValueAccuracy = r5;
        this.evaluations = IntegerSequence.Incrementor.create();
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseUnivariateSolver
    public int getMaxEvaluations() {
        return this.evaluations.getMaximalCount();
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseUnivariateSolver
    public int getEvaluations() {
        return this.evaluations.getCount();
    }

    public double getMin() {
        return this.searchMin;
    }

    public double getMax() {
        return this.searchMax;
    }

    public double getStartValue() {
        return this.searchStart;
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseUnivariateSolver
    public double getAbsoluteAccuracy() {
        return this.absoluteAccuracy;
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseUnivariateSolver
    public double getRelativeAccuracy() {
        return this.relativeAccuracy;
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseUnivariateSolver
    public double getFunctionValueAccuracy() {
        return this.functionValueAccuracy;
    }

    protected double computeObjectiveValue(double r1) throws TooManyEvaluationsException {
        incrementEvaluationCount();
        return this.function.value(r1);
    }

    protected void setup(int r1, FUNC r2, double r3, double r5, double r7) throws NullArgumentException {
        MathUtils.checkNotNull(r2);
        this.searchMin = r3;
        this.searchMax = r5;
        this.searchStart = r7;
        this.function = r2;
        this.evaluations = this.evaluations.withMaximalCount(r1).withStart(0);
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseUnivariateSolver
    public double solve(int r1, FUNC r2, double r3, double r5, double r7) throws TooManyEvaluationsException, NoBracketingException {
        setup(r1, r2, r3, r5, r7);
        return doSolve();
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseUnivariateSolver
    public double solve(int r10, FUNC r11, double r12, double r14) {
        return solve(r10, r11, r12, r14, r12 + ((r14 - r12) * 0.5d));
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseUnivariateSolver
    public double solve(int r10, FUNC r11, double r12) throws TooManyEvaluationsException, NoBracketingException {
        return solve(r10, r11, Double.NaN, Double.NaN, r12);
    }

    protected boolean isBracketing(double r1, double r3) {
        return UnivariateSolverUtils.isBracketing(this.function, r1, r3);
    }

    protected boolean isSequence(double r1, double r3, double r5) {
        return UnivariateSolverUtils.isSequence(r1, r3, r5);
    }

    protected void verifyInterval(double r1, double r3) throws NumberIsTooLargeException {
        UnivariateSolverUtils.verifyInterval(r1, r3);
    }

    protected void verifySequence(double r1, double r3, double r5) throws NumberIsTooLargeException {
        UnivariateSolverUtils.verifySequence(r1, r3, r5);
    }

    protected void verifyBracketing(double r1, double r3) throws NullArgumentException, NoBracketingException {
        UnivariateSolverUtils.verifyBracketing(this.function, r1, r3);
    }

    protected void incrementEvaluationCount() throws TooManyEvaluationsException {
        this.evaluations.increment();     // Catch: MaxCountExceededException -> L4
        return;
    L4:
        e = move-exception;
        throw new TooManyEvaluationsException(e.getMax());
    }
}
