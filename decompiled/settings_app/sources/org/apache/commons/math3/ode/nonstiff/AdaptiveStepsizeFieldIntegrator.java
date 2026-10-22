package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.ode.AbstractFieldIntegrator;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEState;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AdaptiveStepsizeFieldIntegrator<T extends RealFieldElement<T>> extends AbstractFieldIntegrator<T> {
    private T initialStep;
    protected int mainSetDimension;
    private T maxStep;
    private T minStep;
    protected double scalAbsoluteTolerance;
    protected double scalRelativeTolerance;
    protected double[] vecAbsoluteTolerance;
    protected double[] vecRelativeTolerance;

    public AdaptiveStepsizeFieldIntegrator(Field<T> r10, String r11, double r12, double r14, double r16, double r18) {
        super(r10, r11);
        setStepSizeControl(r12, r14, r16, r18);
        resetInternalState();
    }

    public AdaptiveStepsizeFieldIntegrator(Field<T> r8, String r9, double r10, double r12, double[] r14, double[] r15) {
        super(r8, r9);
        setStepSizeControl(r10, r12, r14, r15);
        resetInternalState();
    }

    public void setStepSizeControl(double r2, double r4, double r6, double r8) {
        this.minStep = (T) getField().getZero().add(FastMath.abs(r2));
        this.maxStep = (T) getField().getZero().add(FastMath.abs(r4));
        this.initialStep = (T) getField().getOne().negate();
        this.scalAbsoluteTolerance = r6;
        this.scalRelativeTolerance = r8;
        this.vecAbsoluteTolerance = null;
        this.vecRelativeTolerance = null;
    }

    public void setStepSizeControl(double r2, double r4, double[] r6, double[] r7) {
        this.minStep = (T) getField().getZero().add(FastMath.abs(r2));
        this.maxStep = (T) getField().getZero().add(FastMath.abs(r4));
        this.initialStep = (T) getField().getOne().negate();
        this.scalAbsoluteTolerance = 0.0d;
        this.scalRelativeTolerance = 0.0d;
        this.vecAbsoluteTolerance = (double[]) r6.clone();
        this.vecRelativeTolerance = (double[]) r7.clone();
    }

    public void setInitialStepSize(T r5) {
        if (((RealFieldElement) r5.subtract(this.minStep)).getReal() >= 0.0d) goto L5;
    L8:
        this.initialStep = (T) getField().getOne().negate();
        return;
    L5:
        if (((RealFieldElement) r5.subtract(this.maxStep)).getReal() > 0.0d) goto L8;
        this.initialStep = r5;
    }

    @Override // org.apache.commons.math3.ode.AbstractFieldIntegrator
    protected void sanityChecks(FieldODEState<T> r1, T r2) throws DimensionMismatchException, NumberIsTooSmallException {
        super.sanityChecks(r1, r2);
        int r3 = r1.getStateDimension();
        this.mainSetDimension = r3;
        double[] r4 = this.vecAbsoluteTolerance;
        if (r4 != null) goto L5;
    L9:
        double[] r5 = this.vecRelativeTolerance;
        if (r5 != null) goto L12;
        return;
    L12:
        if (r5.length != r3) goto L15;
        return;
    L15:
        throw new DimensionMismatchException(this.mainSetDimension, this.vecRelativeTolerance.length);
    L5:
        if (r4.length == r3) goto L9;
        throw new DimensionMismatchException(this.mainSetDimension, this.vecAbsoluteTolerance.length);
    }

    public T initializeStep(boolean r11, int r12, T[] r13, FieldODEStateAndDerivative<T> r14, FieldEquationsMapper<T> r15) throws MaxCountExceededException, DimensionMismatchException {
        if (this.initialStep.getReal() <= 0.0d) goto L9;
        T r10 = this.initialStep;
        if (r11 == false) goto L8;
        return r10;
    L8:
        return (T) r10.negate();
    L9:
        RealFieldElement[] r0 = r15.mapState(r14);
        RealFieldElement[] r16 = r15.mapDerivative(r14);
        T r1 = getField().getZero();
        T r2 = getField().getZero();
        int r3 = 0;
        int r4 = 0;
    L11:
        if (r4 >= r13.length) goto L14;
        RealFieldElement r5 = (RealFieldElement) r0[r4].divide(r13[r4]);
        r1 = (T) r1.add(r5.multiply(r5));
        RealFieldElement r6 = (RealFieldElement) r16[r4].divide(r13[r4]);
        r2 = (T) r2.add(r6.multiply(r6));
        r4 = r4 + 1;
        goto L11
    L14:
        if (r1.getReal() >= 1.0E-10d) goto L16;
    L19:
        Object r7 = getField().getZero().add(1.0E-6d);
    L20:
        RealFieldElement r8 = (RealFieldElement) r7;
        if (r11 == true) goto L23;
        r8 = (RealFieldElement) r8.negate();
    L23:
        RealFieldElement[] r9 = (RealFieldElement[]) MathArrays.buildArray(getField(), r0.length);
        int r17 = 0;
    L25:
        if (r17 >= r0.length) goto L27;
        r9[r17] = (RealFieldElement) r0[r17].add(r16[r17].multiply(r8));
        r17 = r17 + 1;
        goto L25
    L27:
        T[] r18 = computeDerivatives((RealFieldElement) r14.getTime().add(r8), r9);
        T r19 = getField().getZero();
    L29:
        if (r3 >= r13.length) goto L31;
        RealFieldElement r20 = (RealFieldElement) ((RealFieldElement) r18[r3].subtract(r16[r3])).divide(r13[r3]);
        r19 = (T) r19.add(r20.multiply(r20));
        r3 = r3 + 1;
        goto L29
    L31:
        RealFieldElement r110 = MathUtils.max((RealFieldElement) r2.sqrt(), (RealFieldElement) ((RealFieldElement) r19.sqrt()).divide(r8));
        if (r110.getReal() >= 1.0E-15d) goto L34;
        RealFieldElement r111 = MathUtils.max((RealFieldElement) getField().getZero().add(1.0E-6d), (RealFieldElement) ((RealFieldElement) r8.abs()).multiply(0.001d));
    L35:
        T r112 = (T) MathUtils.max(this.minStep, MathUtils.min(this.maxStep, MathUtils.max(MathUtils.min((RealFieldElement) ((RealFieldElement) r8.abs()).multiply(100), r111), (RealFieldElement) ((RealFieldElement) r14.getTime().abs()).multiply(1.0E-12d))));
        if (r11 == false) goto L38;
        return r112;
    L38:
        return (T) r112.negate();
    L34:
        r111 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r110.multiply(100)).reciprocal()).pow(1.0d / ((double) r12));
        goto L35
    L16:
        if (r2.getReal() < 1.0E-10d) goto L19;
        r7 = ((RealFieldElement) ((RealFieldElement) r1.divide(r2)).sqrt()).multiply(0.01d);
        goto L20
    }

    protected T filterStep(T r5, boolean r6, boolean r7) throws NumberIsTooSmallException {
        if (((RealFieldElement) ((RealFieldElement) r5.abs()).subtract(this.minStep)).getReal() >= 0.0d) goto L12;
        if (r7 == false) goto L10;
        r5 = this.minStep;
        if (r6 == true) goto L12;
        r5 = (T) r5.negate();
        goto L12
    L10:
        throw new NumberIsTooSmallException(LocalizedFormats.MINIMAL_STEPSIZE_REACHED_DURING_INTEGRATION, Double.valueOf(((RealFieldElement) r5.abs()).getReal()), Double.valueOf(this.minStep.getReal()), true);
    L12:
        if (((RealFieldElement) r5.subtract(this.maxStep)).getReal() <= 0.0d) goto L15;
        return this.maxStep;
    L15:
        if (((RealFieldElement) r5.add(this.maxStep)).getReal() < 0.0d) goto L17;
        return r5;
    L17:
        return (T) this.maxStep.negate();
    }

    protected void resetInternalState() {
        setStepStart(null);
        setStepSize((RealFieldElement) ((RealFieldElement) this.minStep.multiply(this.maxStep)).sqrt());
    }

    public T getMinStep() {
        return this.minStep;
    }

    public T getMaxStep() {
        return this.maxStep;
    }
}
