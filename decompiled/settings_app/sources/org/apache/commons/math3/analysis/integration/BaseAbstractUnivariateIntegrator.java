package org.apache.commons.math3.analysis.integration;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.solvers.UnivariateSolverUtils;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.Incrementor;
import org.apache.commons.math3.util.IntegerSequence;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class BaseAbstractUnivariateIntegrator implements UnivariateIntegrator {
    public static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-15d;
    public static final int DEFAULT_MAX_ITERATIONS_COUNT = Integer.MAX_VALUE;
    public static final int DEFAULT_MIN_ITERATIONS_COUNT = 3;
    public static final double DEFAULT_RELATIVE_ACCURACY = 1.0E-6d;
    private final double absoluteAccuracy;
    private IntegerSequence.Incrementor count;
    private IntegerSequence.Incrementor evaluations;
    private UnivariateFunction function;

    @Deprecated
    protected Incrementor iterations;
    private double max;
    private double min;
    private final int minimalIterationCount;
    private final double relativeAccuracy;

    protected abstract double doIntegrate() throws TooManyEvaluationsException, MaxCountExceededException;

    protected BaseAbstractUnivariateIntegrator(double r1, double r3, int r5, int r6) throws NotStrictlyPositiveException, NumberIsTooSmallException {
        this.relativeAccuracy = r1;
        this.absoluteAccuracy = r3;
        if (r5 <= 0) goto L10;
        if (r6 <= r5) goto L8;
        this.minimalIterationCount = r5;
        IntegerSequence.Incrementor r2 = IntegerSequence.Incrementor.create().withMaximalCount(r6);
        this.count = r2;
        this.iterations = Incrementor.wrap(r2);
        this.evaluations = IntegerSequence.Incrementor.create();
        return;
    L8:
        throw new NumberIsTooSmallException(Integer.valueOf(r6), Integer.valueOf(r5), false);
    L10:
        throw new NotStrictlyPositiveException(Integer.valueOf(r5));
    }

    protected BaseAbstractUnivariateIntegrator(double r8, double r10) {
        this(r8, r10, 3, Integer.MAX_VALUE);
    }

    protected BaseAbstractUnivariateIntegrator(int r8, int r9) throws NotStrictlyPositiveException, NumberIsTooSmallException {
        this(1.0E-6d, 1.0E-15d, r8, r9);
    }

    @Override // org.apache.commons.math3.analysis.integration.UnivariateIntegrator
    public double getRelativeAccuracy() {
        return this.relativeAccuracy;
    }

    @Override // org.apache.commons.math3.analysis.integration.UnivariateIntegrator
    public double getAbsoluteAccuracy() {
        return this.absoluteAccuracy;
    }

    @Override // org.apache.commons.math3.analysis.integration.UnivariateIntegrator
    public int getMinimalIterationCount() {
        return this.minimalIterationCount;
    }

    @Override // org.apache.commons.math3.analysis.integration.UnivariateIntegrator
    public int getMaximalIterationCount() {
        return this.count.getMaximalCount();
    }

    @Override // org.apache.commons.math3.analysis.integration.UnivariateIntegrator
    public int getEvaluations() {
        return this.evaluations.getCount();
    }

    @Override // org.apache.commons.math3.analysis.integration.UnivariateIntegrator
    public int getIterations() {
        return this.count.getCount();
    }

    protected void incrementCount() throws MaxCountExceededException {
        this.count.increment();
    }

    protected double getMin() {
        return this.min;
    }

    protected double getMax() {
        return this.max;
    }

    protected double computeObjectiveValue(double r2) throws TooManyEvaluationsException {
        this.evaluations.increment();     // Catch: MaxCountExceededException -> L5
        return this.function.value(r2);
    L5:
        e = move-exception;
        throw new TooManyEvaluationsException(e.getMax());
    }

    protected void setup(int r1, UnivariateFunction r2, double r3, double r5) throws NullArgumentException, MathIllegalArgumentException {
        MathUtils.checkNotNull(r2);
        UnivariateSolverUtils.verifyInterval(r3, r5);
        this.min = r3;
        this.max = r5;
        this.function = r2;
        this.evaluations = this.evaluations.withMaximalCount(r1).withStart(0);
        this.count = this.count.withStart(0);
    }

    @Override // org.apache.commons.math3.analysis.integration.UnivariateIntegrator
    public double integrate(int r1, UnivariateFunction r2, double r3, double r5) throws TooManyEvaluationsException, MaxCountExceededException, MathIllegalArgumentException, NullArgumentException {
        setup(r1, r2, r3, r5);
        return doIntegrate();
    }
}
